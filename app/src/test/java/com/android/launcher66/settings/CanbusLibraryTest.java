package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.CanbusLibrary.CancelledException;
import com.android.launcher66.settings.CanbusLibrary.Library;
import com.android.launcher66.settings.CanbusLibrary.MergeResult;
import com.android.launcher66.settings.CanbusLibrary.Page;
import com.android.launcher66.settings.CanbusLibrary.ParseResult;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class CanbusLibraryTest {

    private static final String P408 = "com.syu.carinfo.rzc.biaozhi408.";
    private static final String EXAMPLE_BODY =
            "canbus_library 1\n"
            + "C 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi\n"
            + "C 274 | com.syu.carinfo.accord.ActivityAccord7Index | com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi | portrait\n"
            + "R 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti | 70:51; 29:0\n"
            + "R 19 | com.syu.carinfo.honda.HondaTripActi | 100:1; 100:3\n"
            + "N 1\n";

    private static ParseResult parse(String text) {
        try {
            return CanbusLibrary.parse(new StringReader(text), text.getBytes(StandardCharsets.UTF_8).length, null, null);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private static Library lib(String body) {
        ParseResult r = parse(CanbusLibrary.seal(body));
        assertTrue(r.ok(), r.errors.toString());
        return r.library;
    }

    private static void assertError(String text, int line, String contains) {
        ParseResult r = parse(text);
        assertFalse(r.ok(), "expected an error");
        assertNull(r.library);
        boolean found = false;
        for (CanbusLibrary.Error e : r.errors) {
            if (e.line == line && e.reason.contains(contains)) {
                found = true;
            }
        }
        assertTrue(found, "no error at line " + line + " containing \"" + contains + "\": " + r.errors);
    }

    // ---- the example of the format

    @Test
    void theExampleOfTheFormatIsRead() {
        ParseResult r = parse(CanbusLibrary.seal(EXAMPLE_BODY));
        assertTrue(r.ok(), r.errors.toString());
        Library l = r.library;
        assertEquals(3, l.carsWithClass());
        assertEquals(3, l.carsWithRequest());
        assertEquals(5, r.recordLines);
        assertEquals("com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi", l.classNameFor(163, false, ""));
        assertEquals("com.syu.carinfo.accord.ActivityAccord7Index", l.classNameFor(274, false, ""));
        assertEquals("com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi", l.classNameFor(274, true, ""));
        assertNull(l.classNameFor(999, false, ""));
        List<Page> pages = l.pagesFor(163);
        assertEquals(1, pages.size());
        assertEquals(P408 + "RZC_BZ408OilMilePage1Acti", pages.get(0).fqcn);
        assertEquals("70:51; 29:0", pages.get(0).requestsText());
        assertEquals(70, pages.get(0).requests.get(0).cmd);
        assertArrayEquals(new int[]{51}, pages.get(0).requests.get(0).ints());
        assertEquals("100:1; 100:3", l.pagesFor(19).get(0).requestsText());
        assertTrue(l.pagesFor(1).isEmpty());
        assertTrue(l.pagesFor(2).isEmpty());
    }

    @Test
    void aBomCrLfCommentsAndBlankLinesAreAllowed() {
        String body = "# a comment before the header\n\ncanbus_library 1\n# comment\n\nC 5 | com.syu.a.B\n";
        String sealed = CanbusLibrary.seal(body.substring(body.indexOf("canbus_library")));
        // the lines before the header are not part of the checksum
        String text = "﻿# a comment before the header\r\n\r\n" + sealed.replace("\n", "\r\n");
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertEquals("com.syu.a.B", r.library.classNameFor(5, false, null));
        // blank lines after the footer are fine
        assertTrue(parse(sealed + "\n\n").ok());
    }

    @Test
    void firmwareAlternativeAndNoClassAlternative() {
        Library l = lib("canbus_library 1\n"
                + "C 12648900 | com.syu.a.Camry | com.syu.a.Bba | fytver:Ls18,Lt18\n"
                + "C 7 | com.syu.a.Seven | - | portrait\n");
        assertEquals("com.syu.a.Camry", l.classNameFor(12648900, false, ""));
        assertEquals("com.syu.a.Camry", l.classNameFor(12648900, false, null));
        assertEquals("com.syu.a.Bba", l.classNameFor(12648900, false, "xLs18x"));
        assertEquals("com.syu.a.Bba", l.classNameFor(12648900, true, "Lt18"));
        assertEquals("com.syu.a.Seven", l.classNameFor(7, false, ""));
        assertNull(l.classNameFor(7, true, ""));
    }

    // ---- errors, each with its line

    @Test
    void noHeader() {
        assertError("C 1 | com.syu.a.B\nend 1 00000000\n", 1, "header");
        assertError("", 0, "missing header");
        assertError("# only a comment\n", 0, "missing header");
        assertError("canbus_library 2\nend 0 00000000\n", 1, "header");
    }

    @Test
    void noFooter() {
        assertError("canbus_library 1\nC 1 | com.syu.a.B\n", 2, "missing footer");
    }

    @Test
    void wrongRecordCountAndWrongCrc() {
        String ok = CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B\n");
        assertTrue(parse(ok).ok());
        String count = ok.replace("end 1 ", "end 2 ");
        assertError(count, 3, "footer says 2 records");
        // another letter in a record: the footer no longer matches
        String changed = ok.replace("com.syu.a.B", "com.syu.a.C");
        assertError(changed, 3, "CRC32 mismatch");
        assertError("canbus_library 1\nC 1 | com.syu.a.B\nend one two\n", 3, "bad footer");
    }

    @Test
    void contentAfterTheFooter() {
        String ok = CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B\n");
        assertError(ok + "C 2 | com.syu.a.B\n", 4, "after the footer");
        assertError(ok + "# comment\n", 4, "after the footer");
    }

    @Test
    void badFields() {
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1 | not.a.syu.Class\n"), 2, "bad class name");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 0 | com.syu.a.B\n"), 2, "outside 1..2147483647");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 2147483648 | com.syu.a.B\n"), 2, "outside 1..2147483647");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1,1 | com.syu.a.B\n"), 2, "repeated");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1,,2 | com.syu.a.B\n"), 2, "decimal numbers");
        assertError(CanbusLibrary.seal("canbus_library 1\nC a | com.syu.a.B\n"), 2, "decimal numbers");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B | com.syu.a.D\n"), 2, "C takes");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B | com.syu.a.D | landscape\n"), 2, "bad condition");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B | com.syu.a.D | fytver:\n"), 2, "fytver tokens");
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B | com.syu.a.D | fytver:a,b,c,d,e,f,g,h,i\n"), 2, "fytver tokens");
        assertError(CanbusLibrary.seal("canbus_library 1\nX 1 | com.syu.a.B\n"), 2, "unknown record");
        assertError(CanbusLibrary.seal("canbus_library 1\nN 1 | com.syu.a.B\n"), 2, "N takes");
    }

    @Test
    void badRequests() {
        String page = "com.syu.a.OilPage";
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + " | 10000\n"), 2, "outside 0..9999");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + " | 70:1,2,3,4,5,6,7,8,9\n"), 2, "more than 8 numbers");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + " | 70:70000\n"), 2, "outside -65536..65536");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + " | 70:\n"), 2, "bad request");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + " | x\n"), 2, "bad request");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + " | 1;2;3;4;5;6;7;8;9\n"), 2, "1 to 8 requests");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + "\n"), 2, "R takes");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | java.lang.String | 1\n"), 2, "bad page class");
        assertTrue(parse(CanbusLibrary.seal("canbus_library 1\nR 1 | " + page + " | 70:-65536,65536; 9999; 0:0\n")).ok());
    }

    @Test
    void conflictsInsideOneFile() {
        assertError(CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B\nC 1,2 | com.syu.a.D\n"), 3, "two different C");
        assertError(CanbusLibrary.seal("canbus_library 1\nN 1\nR 1 | com.syu.a.OilPage | 70:1\n"), 3, "both N and R");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | com.syu.a.OilPage | 70:1\nN 1\n"), 3, "both N and R");
        assertError(CanbusLibrary.seal("canbus_library 1\nR 1 | com.syu.a.OilPage | 70:1\nR 1 | com.syu.a.OilPage | 70:2\n"),
                3, "two different request lists");
        StringBuilder many = new StringBuilder("canbus_library 1\n");
        for (int i = 0; i < 11; i++) {
            many.append("R 1 | com.syu.a.OilPage").append(i).append(" | 70:").append(i).append('\n');
        }
        assertError(CanbusLibrary.seal(many.toString()), 12, "more than 10 pages");
    }

    @Test
    void manyErrorsAreCollectedUpToTheLimit() {
        StringBuilder sb = new StringBuilder("canbus_library 1\n");
        for (int i = 0; i < 300; i++) {
            sb.append("C x | com.syu.a.B\n");
        }
        ParseResult r = parse(CanbusLibrary.seal(sb.toString()));
        assertEquals(CanbusLibrary.MAX_ERRORS, r.errors.size());
        assertEquals(2, r.errors.get(0).line);
        assertEquals(201, r.errors.get(199).line);
    }

    @Test
    void aFileOverTwoMegabytesIsRejected() throws IOException {
        String text = CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.a.B\n");
        ParseResult r = CanbusLibrary.parse(new StringReader(text), CanbusLibrary.MAX_BYTES + 1, null, null);
        assertFalse(r.ok());
        assertTrue(r.errors.get(0).reason.contains("larger"));
        // and one that is longer than it says
        StringBuilder big = new StringBuilder("canbus_library 1\n");
        String filler = "# " + "x".repeat(1000) + "\n";
        for (int i = 0; i < 2200; i++) {
            big.append(filler);
        }
        ParseResult r2 = CanbusLibrary.parse(new StringReader(big.toString()), -1, null, null);
        assertFalse(r2.ok());
        assertTrue(r2.errors.get(0).reason.contains("larger"));
    }

    // ---- duplicates inside a file

    @Test
    void anIdenticalRecordRepeatedIsCountedNotAnError() {
        String body = "canbus_library 1\n"
                + "C 1,2 | com.syu.a.B\n"
                + "C 2,3 | com.syu.a.B\n"
                + "R 1 | com.syu.a.OilPage | 70:1\n"
                + "R 1 | com.syu.a.OilPage | 70:1\n"
                + "N 9\nN 9\n";
        ParseResult r = parse(CanbusLibrary.seal(body));
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(3, r.duplicatesInFile);
        assertEquals(3, r.library.carsWithClass());
        assertEquals(1, r.library.pagesFor(1).size());
    }

    // ---- merging

    @Test
    void mergeCountsNewDuplicateAndReplacedForClasses() {
        Library base = lib("canbus_library 1\nC 1 | com.syu.a.One\nC 2 | com.syu.a.Two\n");
        Library file = lib("canbus_library 1\nC 2 | com.syu.a.Two\nC 1 | com.syu.a.OneNew\nC 3 | com.syu.a.Three\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.classes.added);
        assertEquals(1, m.classes.duplicate);
        assertEquals(1, m.classes.replaced);
        assertEquals("com.syu.a.OneNew", m.library.classNameFor(1, false, null));
        assertEquals("com.syu.a.Two", m.library.classNameFor(2, false, null));
        assertEquals("com.syu.a.Three", m.library.classNameFor(3, false, null));
        assertEquals(1, m.replacements.size());
        assertEquals('C', m.replacements.get(0).kind);
        assertEquals(1, m.replacements.get(0).id);
        assertEquals("com.syu.a.One", m.replacements.get(0).oldValue);
        assertEquals("com.syu.a.OneNew", m.replacements.get(0).newValue);
        // the base is not changed
        assertEquals("com.syu.a.One", base.classNameFor(1, false, null));
        assertEquals(3, m.added() + m.duplicates() + m.replaced());
    }

    @Test
    void aClassWithAConditionIsAnotherClassThanWithout() {
        Library base = lib("canbus_library 1\nC 1 | com.syu.a.One\n");
        Library file = lib("canbus_library 1\nC 1 | com.syu.a.One | com.syu.a.Alt | portrait\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.classes.replaced);
        assertEquals("com.syu.a.Alt", m.library.classNameFor(1, true, null));
    }

    @Test
    void mergeOfRequestsKeepsTheOrderOfTheFileFirst() {
        Library base = lib("canbus_library 1\n"
                + "R 5 | com.syu.a.OilPage1 | 70:1\n"
                + "R 5 | com.syu.a.OilPage2 | 71:2\n"
                + "R 5 | com.syu.a.OilPage3 | 72:3\n");
        Library file = lib("canbus_library 1\n"
                + "R 5 | com.syu.a.OilPage3 | 72:3\n"
                + "R 5 | com.syu.a.OilPage1 | 70:99\n"
                + "R 5 | com.syu.a.OilPage4 | 73:4\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.requests.added);
        assertEquals(1, m.requests.duplicate);
        assertEquals(1, m.requests.replaced);
        List<String> names = new ArrayList<>();
        for (Page p : m.library.pagesFor(5)) {
            names.add(p.simpleName() + " " + p.requestsText());
        }
        assertEquals(List.of("OilPage3 72:3", "OilPage1 70:99", "OilPage4 73:4", "OilPage2 71:2"), names);
        assertEquals("70:1", m.replacements.get(0).oldValue);
        assertEquals("70:99", m.replacements.get(0).newValue);
    }

    @Test
    void requestsOfTheFileRemoveNoRequestOfTheBase() {
        Library base = lib("canbus_library 1\nN 7,8\n");
        Library file = lib("canbus_library 1\nR 7 | com.syu.a.OilPage | 70:1\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.requests.added);
        assertEquals(1, m.library.pagesFor(7).size());
        // 8 is still N: no pages, and a file with N for it is a duplicate
        assertTrue(m.library.pagesFor(8).isEmpty());
        MergeResult again = m.library.mergedWith(lib("canbus_library 1\nN 8\n"));
        assertEquals(1, again.noRequest.duplicate);
        // writing it out and reading it back gives 7 with a page and 8 without
        Library back = parse(m.library.serialize()).library;
        assertEquals(1, back.pagesFor(7).size());
        assertTrue(back.pagesFor(8).isEmpty());
    }

    @Test
    void noRequestOfTheFileCountsAgainstTheBase() {
        Library base = lib("canbus_library 1\nR 3 | com.syu.a.OilPage | 70:1\nN 4\n");
        Library file = lib("canbus_library 1\nN 3,4,5\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.noRequest.added);
        assertEquals(1, m.noRequest.duplicate);
        assertEquals(1, m.noRequest.replaced);
        assertTrue(m.library.pagesFor(3).isEmpty());
        assertEquals('N', m.replacements.get(0).kind);
    }

    @Test
    void otherIdsAreUntouchedAndAnEmptyFileChangesNothing() {
        Library base = lib(EXAMPLE_BODY);
        Library file = lib("canbus_library 1\nC 500 | com.syu.a.Five\nR 501 | com.syu.a.OilPage | 70:1\nN 502\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.classes.added);
        assertEquals(1, m.requests.added);
        assertEquals(1, m.noRequest.added);
        assertEquals(base.carsWithClass() + 1, m.library.carsWithClass());
        assertEquals("70:51; 29:0", m.library.pagesFor(163).get(0).requestsText());
        MergeResult nothing = base.mergedWith(Library.EMPTY);
        assertEquals(0, nothing.added() + nothing.duplicates() + nothing.replaced());
        assertEquals(base.serialize(), nothing.library.serialize());
        // the same file twice: everything is a duplicate
        MergeResult twice = m.library.mergedWith(file);
        assertEquals(0, twice.added());
        assertEquals(0, twice.replaced());
        assertEquals(3, twice.duplicates());
    }

    // ---- serialize / parse

    @Test
    void serializeThenParseGivesTheSameLibrary() {
        Library l = lib(EXAMPLE_BODY + "C 12648900 | com.syu.a.Camry | com.syu.a.Bba | fytver:Ls18,Lt18\n");
        String text = l.serialize();
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(text, r.library.serialize());
        assertEquals(l.carsWithClass(), r.library.carsWithClass());
        assertEquals(l.carsWithRequest(), r.library.carsWithRequest());
        assertEquals(l.recordCount(), r.library.recordCount());
        assertEquals("com.syu.a.Bba", r.library.classNameFor(12648900, false, "Ls18"));
        assertEquals(CanbusLibrary.Library.EMPTY.serialize(), parse(Library.EMPTY.serialize()).library.serialize());
    }

    @Test
    void sealAgreesWithTheFooterThePythonScriptWrote() throws IOException {
        String text = new String(Files.readAllBytes(new File("src/main/assets/canbus_library.txt").toPath()),
                StandardCharsets.UTF_8);
        int footerAt = text.lastIndexOf("\nend ") + 1;
        assertTrue(footerAt > 0);
        assertEquals(text, CanbusLibrary.seal(text.substring(0, footerAt)));
    }

    // ---- cancel and progress

    @Test
    void cancelStopsTheParse() throws IOException {
        StringBuilder sb = new StringBuilder("canbus_library 1\n");
        for (int i = 1; i <= 1000; i++) {
            sb.append("C ").append(i).append(" | com.syu.a.B\n");
        }
        String text = CanbusLibrary.seal(sb.toString());
        int[] checks = {0};
        assertThrows(CancelledException.class, () -> CanbusLibrary.parse(
                new StringReader(text), text.length(), null, () -> ++checks[0] >= 2));
        assertEquals(2, checks[0]);
        // not cancelled: a progress of growing byte counts that ends at the file size
        long[] last = {0};
        ParseResult r = CanbusLibrary.parse(new StringReader(text), text.getBytes(StandardCharsets.UTF_8).length,
                (read, total) -> {
                    assertTrue(read >= last[0]);
                    last[0] = read;
                }, () -> false);
        assertTrue(r.ok());
        assertEquals(text.getBytes(StandardCharsets.UTF_8).length, last[0]);
    }

    // ---- cmdArr

    @Test
    void parseIntsReadsTheCmdArrField() {
        assertArrayEquals(new int[]{74, 3}, CanbusLibrary.parseInts("74,3"));
        assertArrayEquals(new int[]{74, 3}, CanbusLibrary.parseInts(" 74, 3 "));
        assertArrayEquals(new int[]{51}, CanbusLibrary.parseInts("51"));
        assertArrayEquals(new int[]{-1, 0}, CanbusLibrary.parseInts("-1,0"));
        assertArrayEquals(new int[0], CanbusLibrary.parseInts(""));
        assertArrayEquals(new int[0], CanbusLibrary.parseInts("   "));
        assertNull(CanbusLibrary.parseInts("74,"));
        assertNull(CanbusLibrary.parseInts(",3"));
        assertNull(CanbusLibrary.parseInts("a"));
        assertNull(CanbusLibrary.parseInts("1,2,3,4,5,6,7,8,9"));
        assertNull(CanbusLibrary.parseInts("99999999999"));
        assertNull(CanbusLibrary.parseInts("1 2"));
    }

    // ---- the real asset

    private static Library asset() throws IOException {
        File f = new File("src/main/assets/canbus_library.txt");
        assertTrue(f.isFile(), "the test runs in app/: " + f.getAbsolutePath());
        try (InputStreamReader in = new InputStreamReader(Files.newInputStream(f.toPath()), StandardCharsets.UTF_8)) {
            ParseResult r = CanbusLibrary.parse(in, f.length(), null, null);
            assertTrue(r.ok(), r.errors.toString());
            return r.library;
        }
    }

    @Test
    void theAssetAgreesWithCanbusClasses() throws IOException {
        Library l = asset();
        assertEquals(CanbusClasses.className(1), l.classNameFor(1, false, ""));
        assertEquals(CanbusClasses.className(273), l.classNameFor(273, false, ""));
        assertEquals(CanbusClasses.className(16384453), l.classNameFor(16384453, false, ""));
        assertEquals(CanbusClasses.className(16646583), l.classNameFor(16646583, false, ""));
        assertEquals("com.syu.carinfo.dasauto.DasAutoWcAct", l.classNameFor(1, true, "anything"));
        assertNull(l.classNameFor(999999999, false, ""));
        assertTrue(l.carsWithClass() > 3000);
    }

    @Test
    void theAssetHandlesTheOrientationAndTheFirmware() throws IOException {
        Library l = asset();
        // 274: the screen of the car in landscape, and the one the case falls through to in portrait
        assertEquals("com.syu.carinfo.accord.ActivityAccord7Index", l.classNameFor(274, false, ""));
        assertEquals(CanbusClasses.className(276), l.classNameFor(274, true, ""));
        assertNotNull(CanbusClasses.className(276));
        // 12648900: by the firmware
        assertEquals("com.syu.carinfo.camry.luz.CamryIndexAct_LuZ", l.classNameFor(12648900, false, ""));
        assertEquals("com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc", l.classNameFor(12648900, false, "xLs18x"));
        assertEquals("com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc", l.classNameFor(12648900, true, "Lt18"));
    }

    @Test
    void theAssetHasTheRequestsOfTheFuelScreens() throws IOException {
        Library l = asset();
        List<Page> p163 = l.pagesFor(163);
        assertFalse(p163.isEmpty());
        assertEquals(P408 + "RZC_BZ408OilMilePage1Acti", p163.get(0).fqcn);
        assertEquals("70:51; 29:0", p163.get(0).requestsText());
        assertEquals("100:1; 100:3", l.pagesFor(19).get(0).requestsText());
        assertEquals("11:74,3", l.pagesFor(2687429).get(0).requestsText());
        assertTrue(l.pagesFor(1).isEmpty());
        assertTrue(l.carsWithRequest() > 400);
        // a request sent from a click listener is not a request of the page
        for (int id : new int[]{163, 19, 2687429, 65932, 1114564}) {
            for (Page p : l.pagesFor(id)) {
                assertFalse(p.fqcn.endsWith("RZCLandRoverMilePage1Acti"));
            }
        }
    }

    @Test
    void noPageOfTheAssetIsTheLandRoverOne() throws IOException {
        String text = new String(Files.readAllBytes(new File("src/main/assets/canbus_library.txt").toPath()),
                StandardCharsets.UTF_8);
        assertFalse(text.contains("RZCLandRoverMilePage1Acti"));
    }

    @Test
    void theAssetSerializesAndReadsBack() throws IOException {
        Library l = asset();
        ParseResult r = parse(l.serialize());
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(l.carsWithClass(), r.library.carsWithClass());
        assertEquals(l.carsWithRequest(), r.library.carsWithRequest());
        assertEquals(l.recordCount(), r.library.recordCount());
        assertEquals(l.serialize(), r.library.serialize());
    }
}
