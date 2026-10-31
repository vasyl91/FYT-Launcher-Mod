package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        assertError("canbus_library 5\nend 0 00000000\n", 1, "header");
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

    // ---- S records: the fuel and range codes of a car (version 2)

    @Test
    void version1ParsesWithoutCodesAndVersion2WithThem() {
        Library v1 = lib("canbus_library 1\nC 1 | com.syu.a.One\n");
        assertNull(v1.codesFor(1));
        Library v2 = lib("canbus_library 2\nC 1 | com.syu.a.One\nS 1,5 | 102 | 103\nS 7 | 91 | -\nS 8 | - | 92\n");
        assertEquals(new CanbusLibrary.CarCodes(102, 103), v2.codesFor(1));
        assertEquals(new CanbusLibrary.CarCodes(102, 103), v2.codesFor(5));
        assertEquals(91, v2.codesFor(7).fuel);
        assertEquals(-1, v2.codesFor(7).range);
        assertEquals(-1, v2.codesFor(8).fuel);
        assertEquals("91 | -", v2.codesFor(7).toString());
        assertNull(v2.codesFor(2));
        assertEquals(1 + 4, v2.recordCount());
    }

    @Test
    void anSRecordInVersion1IsAnError() {
        assertError(CanbusLibrary.seal("canbus_library 1\nS 1 | 102 | 103\n"), 2, "S records need version 2");
    }

    @Test
    void badFieldsOfAnSRecord() {
        assertError(CanbusLibrary.seal("canbus_library 2\nS 1 | 1200 | 103\n"), 2, "bad code");
        assertError(CanbusLibrary.seal("canbus_library 2\nS 1 | 102 | x\n"), 2, "bad code");
        assertError(CanbusLibrary.seal("canbus_library 2\nS 1 | -1 | 103\n"), 2, "bad code");
        assertError(CanbusLibrary.seal("canbus_library 2\nS 5 | - | -\n"), 2, "nothing to say");
        assertError(CanbusLibrary.seal("canbus_library 2\nS 1 | 102\n"), 2, "S takes");
        assertError(CanbusLibrary.seal("canbus_library 2\nS 1 | 102 | 103 | 104\n"), 2, "S takes");
        assertError(CanbusLibrary.seal("canbus_library 2\nS 0 | 102 | 103\n"), 2, "outside 1..2147483647");
    }

    @Test
    void twoDifferentSRecordsForOneIdAreAnErrorAndAnIdenticalOneIsADuplicate() {
        assertError(CanbusLibrary.seal("canbus_library 2\nS 1 | 102 | 103\nS 1 | 91 | 92\n"), 3, "two different S records");
        ParseResult r = parse(CanbusLibrary.seal("canbus_library 2\nS 1 | 102 | 103\nS 1,2 | 102 | 103\n"));
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(1, r.duplicatesInFile);
        assertEquals(2, r.library.recordCount());
    }

    @Test
    void mergeCountsNewDuplicateAndReplacedForCodes() {
        Library base = lib("canbus_library 2\nS 1,2 | 102 | 103\nS 3 | 98 | -\nS 9 | 5 | 6\n");
        Library file = lib("canbus_library 2\nS 1 | 91 | 92\nS 2 | 102 | 103\nS 4 | - | 77\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.codes.added);
        assertEquals(1, m.codes.duplicate);
        assertEquals(1, m.codes.replaced);
        assertEquals(new CanbusLibrary.CarCodes(91, 92), m.library.codesFor(1));
        assertEquals(new CanbusLibrary.CarCodes(102, 103), m.library.codesFor(2));
        assertEquals(new CanbusLibrary.CarCodes(98, -1), m.library.codesFor(3));
        assertEquals(new CanbusLibrary.CarCodes(-1, 77), m.library.codesFor(4));
        assertEquals(new CanbusLibrary.CarCodes(5, 6), m.library.codesFor(9));
        assertEquals(1, m.replacements.size());
        assertEquals('S', m.replacements.get(0).kind);
        assertEquals("102 | 103", m.replacements.get(0).oldValue);
        // the pair of the file first, the base's pair after it (the radio may have the older module)
        assertEquals("91 | 92 | 102 | 103", m.replacements.get(0).newValue);
        assertEquals(3, m.added() + m.duplicates() + m.replaced());
        // the base is not changed
        assertEquals(new CanbusLibrary.CarCodes(102, 103), base.codesFor(1));
    }

    @Test
    void codesSurviveSerializeAndParse() {
        Library l = lib("canbus_library 2\nC 1 | com.syu.a.One\nS 1,5 | 102 | 103\nS 7 | 91 | -\n");
        String text = l.serialize();
        assertTrue(text.startsWith("canbus_library 2\n"));
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(text, r.library.serialize());
        assertEquals(new CanbusLibrary.CarCodes(91, -1), r.library.codesFor(7));
        assertEquals(l.recordCount(), r.library.recordCount());
    }

    @Test
    void theAssetHasTheCodesOfThePsaCar() throws IOException {
        Library l = asset();
        // the newer module (102/103) first, then the older (91/92): the radio is not known to have the newer one
        List<CanbusLibrary.CarCodes> psa = java.util.Arrays.asList(
                new CanbusLibrary.CarCodes(102, 103), new CanbusLibrary.CarCodes(91, 92));
        assertEquals(psa, l.codePairsFor(163));
        assertEquals(psa, l.codePairsFor(1507667));
        assertEquals(new CanbusLibrary.CarCodes(102, 103), l.codesFor(163));
        assertEquals(java.util.Arrays.asList(new CanbusLibrary.CarCodes(98, 103), new CanbusLibrary.CarCodes(0, 5)),
                l.codePairsFor(19));
        assertEquals(new CanbusLibrary.CarCodes(98, 103), l.codesFor(19));
        assertNull(l.codesFor(1));
        assertTrue(l.codePairsFor(1).isEmpty());
    }

    @Test
    void theCarOfTheOwnerStartsWithTheFuelScreenNotTheElectricOne() throws IOException {
        Library l = asset();
        assertEquals(P408 + "RZC_BZ408IndexActi", l.classNameFor(1507667, false, ""));
        List<Page> pages = l.pagesFor(1507667);
        assertEquals(P408 + "RZC_BZ408OilMilePage1Acti", pages.get(0).fqcn);
        assertEquals("70:51; 29:0", pages.get(0).requestsText());
        assertEquals("71:52; 29:1", pages.get(1).requestsText());
        // the electric car's screens (70:80..83) are there, after the fuel ones
        boolean ev = false;
        for (Page p : pages.subList(1, pages.size())) {
            ev |= p.fqcn.endsWith("RZC_BZ408EVMilePage1Acti") && p.requestsText().equals("70:80");
        }
        assertTrue(ev);
        for (Page p : pages) {
            if (p.fqcn.contains("EVMile")) {
                assertTrue(pages.indexOf(p) > 0);
            }
        }
    }

    @Test
    void theAssetIsWrittenAsVersion4BecauseSomeCarsHaveAUnitAndSeveralPairs() throws IOException {
        String text = new String(Files.readAllBytes(new File("src/main/assets/canbus_library.txt").toPath()),
                StandardCharsets.UTF_8);
        assertTrue(text.startsWith("canbus_library 4\n"));
        assertTrue(text.contains("| 102 | 103 | 91 | 92\n"));
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
    void theAssetHasTheKnownClasses() throws IOException {
        Library l = asset();
        assertEquals("com.syu.carinfo.dasauto.DasAutoWcAct", l.classNameFor(1, false, ""));
        assertEquals("com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengIndex", l.classNameFor(273, false, ""));
        assertEquals("com.syu.carinfo.rzc.sanlin.ODModerninIndexAct", l.classNameFor(16384453, false, ""));
        assertEquals("com.syu.carinfo.rzc.sanlin.ODBMWCarInfo", l.classNameFor(16646583, false, ""));
        assertEquals("com.syu.carinfo.dasauto.DasAutoWcAct", l.classNameFor(1, true, "anything"));
        assertNull(l.classNameFor(999999999, false, ""));
        assertTrue(l.carsWithClass() > 3000);
    }

    @Test
    void theAssetHandlesTheOrientationAndTheFirmware() throws IOException {
        Library l = asset();
        // 274: the screen of the car in landscape, and the one the case falls through to in portrait
        // (in portrait both the older and the newer ActivityLauncher open the air diagnosis, the asset had another class)
        assertEquals("com.syu.carinfo.accord.ActivityAccord7Index", l.classNameFor(274, false, ""));
        assertEquals("com.syu.carinfo.accord.ActivityAccord7AirDiagnosis", l.classNameFor(274, true, ""));
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

    // ---- export

    private static int recordLinesOf(String text) {
        int n = 0;
        for (String line : text.split("\n")) {
            if (line.startsWith("C ") || line.startsWith("R ") || line.startsWith("N ") || line.startsWith("S ")
                    || line.startsWith("U ")) {
                n++;
            }
        }
        return n;
    }

    /** An import with a record of every kind: new and replaced classes and codes, a new page, an N that drops pages. */
    private static final String OVERLAY_BODY =
            "canbus_library 2\n"
            + "C 999000001 | com.syu.test.NewIndex | com.syu.test.NewPortrait | portrait\n"
            + "C 19 | com.syu.test.ReplacedIndex\n"
            + "R 999000001 | com.syu.test.NewPage | 1:2; 3\n"
            + "N 163\n"
            + "S 999000001 | 5 | 6\n"
            + "S 19 | 1 | -\n";

    @Test
    void theAssetMergedWithAnOverlayOfEveryRecordKindSerializesAndReadsBack() throws IOException {
        Library base = asset();
        MergeResult merged = base.mergedWith(lib(OVERLAY_BODY));
        assertEquals(1, merged.noRequest.added + merged.noRequest.replaced);
        assertTrue(merged.codes.added >= 1 && merged.codes.replaced >= 1);
        Library l = merged.library;
        String text = l.serialize();
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(text, r.library.serialize());
        assertEquals(l.recordCount(), r.library.recordCount());
        assertEquals("com.syu.test.NewPortrait", r.library.classNameFor(999000001, true, ""));
        assertEquals("com.syu.test.ReplacedIndex", r.library.classNameFor(19, false, ""));
        assertEquals("1:2; 3", r.library.pagesFor(999000001).get(0).requestsText());
        assertTrue(r.library.pagesFor(163).isEmpty());
        assertEquals(new CanbusLibrary.CarCodes(1, -1), r.library.codesFor(19));
    }

    @Test
    void theExportHasACommentAfterTheHeaderAndReadsBackAsTheSameLibrary() throws IOException {
        Library l = asset().mergedWith(lib(OVERLAY_BODY)).library;
        String text = CanbusLibrary.exportText(l, 1_761_785_794_000L);
        String[] lines = text.split("\n");
        // the asset has U records: version 4 (the overlay gave car 19 a second pair of codes, which version 3 would hold)
        assertEquals(CanbusLibrary.HEADER_4, lines[0]);
        assertTrue(lines[1].startsWith("# Exported by the launcher on 2025-"), lines[1]);
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertTrue(lines[1].contains(r.recordLines + " record lines (" + l.recordCount() + " records per car)"), lines[1]);
        assertTrue(text.contains("\nend " + r.recordLines + " "), text);
        // the comment is no record, but it is in the checksum: the footer agrees with the parser
        assertEquals(recordLinesOf(text), r.recordLines);
        assertEquals(r.declaredCrc, r.computedCrc);
        assertEquals(l.serialize(), r.library.serialize());
        assertEquals(text, CanbusLibrary.seal(text.substring(0, text.lastIndexOf("\nend ") + 1)));
    }

    @Test
    void theParseResultHasTheVersionOfTheHeader() {
        assertEquals(1, parse(CanbusLibrary.seal("canbus_library 1\nC 1 | com.syu.x.Y\n")).version);
        assertEquals(2, parse(CanbusLibrary.seal("canbus_library 2\nC 1 | com.syu.x.Y\n")).version);
        assertEquals(3, parse(CanbusLibrary.seal("canbus_library 3\nC 1 | com.syu.x.Y\n")).version);
        assertEquals(4, parse(CanbusLibrary.seal("canbus_library 4\nC 1 | com.syu.x.Y\n")).version);
        assertEquals(0, parse("").version);
    }

    @Test
    void aCommentOfTheExportCannotBreakTheFile() {
        Library l = lib(EXAMPLE_BODY);
        String text = l.serialize(java.util.Arrays.asList("a\nC 5 | com.syu.x.Y", "end 0 00000000"));
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(recordLinesOf(text), r.recordLines);
        assertEquals(5, r.recordLines);
        assertNull(r.library.carClassFor(5));
    }

    @Test
    void theExportIsNamedLikeTheFilesOfTheScript() {
        String name = CanbusLibrary.exportFileName(1_761_785_794_000L);
        assertTrue(name.matches("canbus_library_export_\\d{4}-\\d{2}-\\d{2}_\\d{2}-\\d{2}-\\d{2}\\.txt"), name);
    }

    // ---- version 3: several fuel/range pairs for a car

    private static final String V3_BODY =
            "canbus_library 3\n"
            + "C 163 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi\n"
            + "S 163 | 102 | 103 | 91 | 92\n"
            + "S 7 | - | 77 | 5 | -\n"
            + "S 9 | 1 | 2\n";

    @Test
    void version3HoldsSeveralPairsInOrderAndReadsThemBack() {
        Library l = lib(V3_BODY);
        assertEquals(java.util.Arrays.asList(new CanbusLibrary.CarCodes(102, 103), new CanbusLibrary.CarCodes(91, 92)),
                l.codePairsFor(163));
        assertEquals(new CanbusLibrary.CarCodes(102, 103), l.codesFor(163));
        assertEquals(java.util.Arrays.asList(new CanbusLibrary.CarCodes(-1, 77), new CanbusLibrary.CarCodes(5, -1)),
                l.codePairsFor(7));
        assertEquals(1, l.codePairsFor(9).size());
        assertTrue(l.codePairsFor(1).isEmpty());
        assertNull(l.codesFor(1));
        assertEquals(3, l.recordCount() - 1);   // the class and three cars with codes
        String text = l.serialize();
        assertTrue(text.startsWith("canbus_library 3\n"), text);
        assertTrue(text.contains("S 163 | 102 | 103 | 91 | 92\n"), text);
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(text, r.library.serialize());
        assertEquals(l.codePairsFor(7), r.library.codePairsFor(7));
    }

    @Test
    void aLibraryWithOnePairPerCarIsWrittenAsVersion2() {
        Library l = lib("canbus_library 3\nS 9 | 1 | 2\n");
        assertTrue(l.serialize().startsWith("canbus_library 2\n"));
        assertTrue(parse(l.serialize()).ok());
    }

    @Test
    void severalPairsInAVersion2FileAreAnError() {
        assertError(CanbusLibrary.seal("canbus_library 2\nS 5 | 1 | 2 | 3 | 4\n"), 2, "several code pairs need version 3");
        assertTrue(parse(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 3 | 4\n")).ok());
    }

    @Test
    void badSRecordsOfVersion3() {
        assertError(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | - | -\n"), 2, "nothing to say");
        assertError(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 1 | 2\n"), 2, "repeated");
        assertError(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 3\n"), 2, "S takes");
        assertError(CanbusLibrary.seal("canbus_library 3\nS 5 | 1\n"), 2, "S takes");
        assertError(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10\n"), 2, "more than 4");
        assertError(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 3 | 4000\n"), 2, "bad code");
        assertError(CanbusLibrary.seal("canbus_library 1\nS 5 | 1 | 2\n"), 2, "S records need version 2");
        assertTrue(parse(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8\n")).ok());
        // the same pairs in another order are another record
        assertError(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 3 | 4\nS 5 | 3 | 4 | 1 | 2\n"), 3, "two different S records");
        // an identical record is a duplicate
        ParseResult dup = parse(CanbusLibrary.seal("canbus_library 3\nS 5 | 1 | 2 | 3 | 4\nS 5 | 1 | 2 | 3 | 4\n"));
        assertTrue(dup.ok(), dup.errors.toString());
        assertEquals(1, dup.duplicatesInFile);
    }

    @Test
    void mergingPairsPutsThoseOfTheFileFirstAndKeepsTheOthersOfTheBase() {
        Library base = lib("canbus_library 3\nS 1 | 91 | 92\nS 2 | 5 | 6 | 7 | 8\nS 3 | 1 | 2 | 3 | 4\nS 4 | 10 | 11\n");
        Library file = lib("canbus_library 3\nS 1 | 102 | 103 | 91 | 92\nS 2 | 7 | 8\nS 3 | 1 | 2 | 3 | 4\n"
                + "S 4 | 20 | 21 | 22 | 23 | 24 | 25 | 26 | 27\nS 5 | 9 | 9\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.codes.added);        // 5
        assertEquals(1, m.codes.duplicate);    // 3
        assertEquals(3, m.codes.replaced);     // 1, 2, 4
        assertEquals(java.util.Arrays.asList(new CanbusLibrary.CarCodes(102, 103), new CanbusLibrary.CarCodes(91, 92)),
                m.library.codePairsFor(1));
        // the pair of the file first, then the base's others
        assertEquals(java.util.Arrays.asList(new CanbusLibrary.CarCodes(7, 8), new CanbusLibrary.CarCodes(5, 6)),
                m.library.codePairsFor(2));
        assertEquals(base.codePairsFor(3), m.library.codePairsFor(3));
        // at most four: the four of the file, and nothing of the base's one
        assertEquals(4, m.library.codePairsFor(4).size());
        assertEquals(new CanbusLibrary.CarCodes(20, 21), m.library.codesFor(4));
        assertFalse(m.library.codePairsFor(4).contains(new CanbusLibrary.CarCodes(10, 11)));
        String replaced = m.replacements.toString();
        assertTrue(replaced.contains("S 1: 91 | 92 -> 102 | 103 | 91 | 92"), replaced);
        // the merge reads back
        assertTrue(parse(m.library.serialize()).ok());
    }

    @Test
    void mergingTheAssetWithAVersion3FileKeepsTheAssetsOtherPair() throws IOException {
        Library base = asset();
        CanbusLibrary.CarCodes first = base.codesFor(163);
        Library file = lib("canbus_library 3\nS 163 | 91 | 92 | 102 | 103\n");
        Library merged = base.mergedWith(file).library;
        assertEquals(new CanbusLibrary.CarCodes(91, 92), merged.codesFor(163));
        assertEquals(java.util.Arrays.asList(new CanbusLibrary.CarCodes(91, 92), first), merged.codePairsFor(163));
    }

    // ---- version 4: the unit of the consumption

    private static final String V4_BODY =
            "canbus_library 4\n"
            + "C 13042103,13107639 | com.syu.carinfo.od.ford.falcon.FordFalconIndexAct\n"
            + "C 2687429 | com.syu.carinfo.rzc.andra.GmAndraIndexActi\n"
            + "C 332 | com.syu.carinfo.saiou3.SaiOu3Index\n"
            + "U 13042103,13107639 | bit 5 | mask 31 | 0=L100,1=LH\n"
            + "U 2687429 | code 184 | 1=L100,2=OTHER,3=OTHER,*=LH\n"
            + "U 332 | fixed LH\n";

    @Test
    void theUnitOfTheConsumptionIsReadOfEveryKind() {
        Library l = lib(V4_BODY);
        FuelUnit bit = l.unitFor(13042103);
        assertEquals(FuelUnit.Kind.BIT, bit.kind);
        assertEquals(5, bit.bit);
        assertEquals(31, bit.mask);
        assertEquals(bit, l.unitFor(13107639));
        FuelUnit code = l.unitFor(2687429);
        assertEquals(FuelUnit.Kind.CODE, code.kind);
        assertEquals(184, code.unitCode());
        assertEquals(FuelUnit.Kind.FIXED, l.unitFor(332).kind);
        assertNull(l.unitFor(1));
        assertEquals(4, parse(CanbusLibrary.seal(V4_BODY)).version);
    }

    @Test
    void theUnitIsDecodedFromTheCodesOfTheProtocol() {
        Library l = lib(V4_BODY);
        // a bit of the consumption code, the consumption is the code & 31: 5.7 L/h or 5.7 L/100 km
        FuelUnit falcon = l.unitFor(13042103);
        int perHour = (1 << 5) | 57 - 32 + 32;
        assertEquals(FuelUnit.Unit.LH, falcon.unitNow(null, (1 << 5) | 25));
        assertEquals(FuelUnit.Unit.L100, falcon.unitNow(null, 25));
        assertEquals(25, falcon.consumption((1 << 5) | 25));
        assertEquals(perHour & 31, falcon.consumption(perHour));
        // the unit in a code of its own: a value that is listed, the others, and a code that was never reported
        FuelUnit andra = l.unitFor(2687429);
        assertEquals(FuelUnit.Unit.L100, andra.unitNow(1, 57));
        assertEquals(FuelUnit.Unit.LH, andra.unitNow(0, 57));
        assertEquals(FuelUnit.Unit.LH, andra.unitNow(77, 57));
        assertNull(andra.unitNow(2, 57));       // gal/h: not used
        assertNull(andra.unitNow(null, 57));
        assertEquals(57, andra.consumption(57));
        // the same always
        assertEquals(FuelUnit.Unit.LH, l.unitFor(332).unitNow(null, 57));
        // a code with no "otherwise": every other value is unknown
        FuelUnit infiniti = lib("canbus_library 4\nC 1 | com.syu.x.Y\nU 1 | code 109 | 0=LH,1=L100\n").unitFor(1);
        assertEquals(FuelUnit.Unit.LH, infiniti.unitNow(0, 5));
        assertNull(infiniti.unitNow(5, 5));
    }

    @Test
    void theUnitRecordsSerializeAndReadBackInTheTextOfTheScript() {
        Library l = lib(V4_BODY);
        String text = l.serialize();
        assertTrue(text.startsWith("canbus_library 4\n"), text);
        assertTrue(text.contains("U 13042103,13107639 | bit 5 | mask 31 | 0=L100,1=LH\n"), text);
        assertTrue(text.contains("U 2687429 | code 184 | 1=L100,2=OTHER,3=OTHER,*=LH\n"), text);
        assertTrue(text.contains("U 332 | fixed LH\n"), text);
        ParseResult r = parse(text);
        assertTrue(r.ok(), r.errors.toString());
        assertEquals(text, r.library.serialize());
        assertEquals(l.recordCount(), r.library.recordCount());
        assertEquals(recordLinesOf(text), r.recordLines);
        // written in another order, with spaces: the same record
        assertEquals(l.unitFor(2687429), lib("canbus_library 4\nC 1 | com.syu.x.Y\nU 2687429 | code 184 | *=LH, 3=OTHER, 2=OTHER, 1=L100\n")
                .unitFor(2687429));
        // a file without U is not version 4
        assertTrue(lib(EXAMPLE_BODY).serialize().startsWith("canbus_library 2"));
    }

    @Test
    void aBadUnitRecordIsAnError() {
        String head = "canbus_library 4\n";
        assertError(CanbusLibrary.seal("canbus_library 3\nU 1 | fixed LH\n"), 2, "U records need version 4");
        assertError(CanbusLibrary.seal(head + "U 1 | fixed GAL\n"), 2, "unit");
        assertError(CanbusLibrary.seal(head + "U 1 | fixed\n"), 2, "U fixed");
        assertError(CanbusLibrary.seal(head + "U 1 | code 2000 | 0=LH\n"), 2, "U code");
        assertError(CanbusLibrary.seal(head + "U 1 | code 5 | 0=LH,0=L100\n"), 2, "repeated");
        assertError(CanbusLibrary.seal(head + "U 1 | code 5 | LH\n"), 2, "bad unit");
        assertError(CanbusLibrary.seal(head + "U 1 | bit 5 | mask 31 | 0=LH\n"), 2, "exactly");
        assertError(CanbusLibrary.seal(head + "U 1 | bit 5 | mask 0 | 0=LH,1=L100\n"), 2, "mask");
        assertError(CanbusLibrary.seal(head + "U 1 | bit 31 | mask 3 | 0=LH,1=L100\n"), 2, "U bit");
        assertError(CanbusLibrary.seal(head + "U 1 | wheel 3\n"), 2, "U takes");
        assertError(CanbusLibrary.seal(head + "U 1 | fixed LH\nU 1 | fixed L100\n"), 3, "two different U records");
        // an identical one is a duplicate, not an error
        ParseResult dup = parse(CanbusLibrary.seal(head + "U 1,2 | fixed LH\nU 2 | fixed LH\n"));
        assertTrue(dup.ok(), dup.errors.toString());
        assertEquals(1, dup.duplicatesInFile);
    }

    @Test
    void theUnitRecordsMergeLikeTheOthers() {
        Library base = lib("canbus_library 4\nC 1,2,3 | com.syu.x.Y\nU 1 | fixed LH\nU 2 | code 109 | 0=LH,1=L100\n");
        Library file = lib("canbus_library 4\nU 1 | fixed LH\nU 2 | code 109 | 0=L100,1=LH\nU 3 | bit 5 | mask 31 | 0=L100,1=LH\n");
        MergeResult m = base.mergedWith(file);
        assertEquals(1, m.units.added);
        assertEquals(1, m.units.duplicate);
        assertEquals(1, m.units.replaced);
        assertEquals(file.unitFor(2), m.library.unitFor(2));
        assertEquals(file.unitFor(3), m.library.unitFor(3));
        assertEquals(base.unitFor(1), m.library.unitFor(1));
        assertEquals("U", String.valueOf(m.replacements.get(0).kind));
        // merging it again changes nothing
        MergeResult again = m.library.mergedWith(file);
        assertEquals(0, again.added());
        assertEquals(0, again.replaced());
        assertEquals(3, again.duplicates());
        assertEquals(m.library.serialize(), again.library.serialize());
    }

    @Test
    void theAssetHasTheUnitsOfTheProtocolsThatReportThem() throws IOException {
        Library l = asset();
        // Ford Falcon: bit 5 of the codes 115 and 116; GM Andra: code 184; Infiniti: code 109; Tule: code 129; Opel: 108
        assertEquals(FuelUnit.Kind.BIT, l.unitFor(13042103).kind);
        assertEquals(184, l.unitFor(2687429).unitCode());
        assertEquals(109, l.unitFor(1573316).unitCode());
        assertEquals(129, l.unitFor(1704391).unitCode());
        assertEquals(108, l.unitFor(7274939).unitCode());
        assertEquals(FuelUnit.Kind.FIXED, l.unitFor(332).kind);
        // the owner's PSA reports none
        assertNull(l.unitFor(1507667));
        assertNull(l.unitFor(163));
        assertTrue(parse(l.serialize()).ok());
    }
}
