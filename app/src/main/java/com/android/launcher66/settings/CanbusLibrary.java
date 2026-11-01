package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;

import androidx.preference.PreferenceManager;

import com.syu.module.canbus.DataCanbus;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/**
 * The canbus library: for each car id the class of the screen FYT's canbus app opens and, for the cars that
 * need one, the requests (canbus commands) its fuel screens send when they open and the codes of its fuel
 * consumption and range (several pairs of them, for the different versions of the canbus module) and where its protocol
 * reports the unit of the instantaneous consumption. The format (version 4; versions 1 to 3 are still read) is described in
 * canbus_library/README.md, which also holds the script that builds a file of it.
 *
 * Everything in here is plain Java (no android.*), so that the parser, the merge and the checks run in JVM
 * tests. A {@link Library} never changes; a merge makes a new one.
 */
public final class CanbusLibrary {

    /** The header of a file with at most one code pair per car; {@link #HEADER_3} when a car has several. */
    public static final String HEADER = "canbus_library 2";
    public static final String HEADER_3 = "canbus_library 3";
    /** The header of a file with a {@code U} record (the unit of the consumption). */
    public static final String HEADER_4 = "canbus_library 4";
    /** The most fuel/range pairs a car can have in a version 3 file. */
    public static final int MAX_CODE_PAIRS = 4;
    /** The highest code the canbus module can report (FinalCanbus.U_CNT_MAX - 1). */
    static final int MAX_CODE = 1199;
    public static final long MAX_BYTES = 2L * 1024 * 1024;
    public static final int MAX_LINES = 200_000;
    public static final int MAX_ERRORS = 200;
    static final int MAX_IDS_PER_LINE = 5000;
    static final int MAX_PAGES_PER_ID = 10;
    static final int MAX_REQUESTS_PER_PAGE = 8;
    static final int MAX_INTS = 8;
    private static final int CANCEL_CHECK_EVERY = 200;

    private static final Pattern CLASS_NAME = Pattern.compile("com\\.syu(\\.[A-Za-z_$][A-Za-z0-9_$]*)+");
    private static final Pattern TOKEN = Pattern.compile("[A-Za-z0-9]{1,16}");
    private static final Pattern REQUEST = Pattern.compile("\\s*([0-9]{1,6})(?::\\s*(-?[0-9]+(?:\\s*,\\s*-?[0-9]+)*))?\\s*");
    private static final Pattern FOOTER = Pattern.compile("end\\s+([0-9]+)\\s+([0-9a-f]{8})");
    private static final Pattern FOOTER_LIKE = Pattern.compile("end\\b.*");
    private static final Pattern HEADER_LINE = Pattern.compile("canbus_library\\s+([1234])");

    private CanbusLibrary() {
    }

    // ---------------------------------------------------------------------------------------------
    // Values
    // ---------------------------------------------------------------------------------------------

    /** One request: DataCanbus.PROXY.cmd(cmd, ints, null, null). */
    public static final class Request {
        public final int cmd;
        private final int[] ints;

        public Request(int cmd, int[] ints) {
            this.cmd = cmd;
            this.ints = ints == null ? new int[0] : ints.clone();
        }

        public int[] ints() {
            return ints.clone();
        }

        /** The numbers as a cmdArr field has them: {@code 74,3}; empty if there are none. */
        public String intsText() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(ints[i]);
            }
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Request && ((Request) o).cmd == cmd && Arrays.equals(((Request) o).ints, ints);
        }

        @Override
        public int hashCode() {
            return 31 * cmd + Arrays.hashCode(ints);
        }

        /** {@code 70:51}, or {@code 100} for a request without numbers. */
        @Override
        public String toString() {
            if (ints.length == 0) {
                return String.valueOf(cmd);
            }
            StringBuilder sb = new StringBuilder().append(cmd).append(':');
            for (int i = 0; i < ints.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(ints[i]);
            }
            return sb.toString();
        }
    }

    /** A fuel page of a car and the requests it sends when it opens, in order. */
    public static final class Page {
        public final String fqcn;
        public final List<Request> requests;

        public Page(String fqcn, List<Request> requests) {
            this.fqcn = fqcn;
            this.requests = Collections.unmodifiableList(new ArrayList<>(requests));
        }

        public String simpleName() {
            return fqcn.substring(fqcn.lastIndexOf('.') + 1);
        }

        /** The requests as the library writes them: {@code 70:51; 29:0}. */
        public String requestsText() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < requests.size(); i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(requests.get(i));
            }
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Page && ((Page) o).fqcn.equals(fqcn) && ((Page) o).requests.equals(requests);
        }

        @Override
        public int hashCode() {
            return 31 * fqcn.hashCode() + requests.hashCode();
        }

        @Override
        public String toString() {
            return fqcn + " | " + requestsText();
        }
    }

    public enum Condition { NONE, PORTRAIT, FYTVER }

    /** The class of a car's screen, optionally another one when the screen is portrait or the firmware matches. */
    public static final class CarClass {
        public final String fqcn;
        /** The class when {@link #condition} is met; null = none (written as {@code -}). */
        public final String alt;
        public final Condition condition;
        public final List<String> tokens;

        public CarClass(String fqcn, String alt, Condition condition, List<String> tokens) {
            this.fqcn = fqcn;
            this.alt = condition == Condition.NONE ? null : alt;
            this.condition = condition;
            this.tokens = Collections.unmodifiableList(new ArrayList<>(
                    condition == Condition.FYTVER ? tokens : Collections.<String>emptyList()));
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof CarClass)) {
                return false;
            }
            CarClass c = (CarClass) o;
            return fqcn.equals(c.fqcn) && Objects.equals(alt, c.alt) && condition == c.condition
                    && tokens.equals(c.tokens);
        }

        @Override
        public int hashCode() {
            return Objects.hash(fqcn, alt, condition, tokens);
        }

        /** The record text after the ids: {@code class} or {@code class | alt | portrait}. */
        @Override
        public String toString() {
            switch (condition) {
                case PORTRAIT:
                    return fqcn + " | " + (alt == null ? "-" : alt) + " | portrait";
                case FYTVER:
                    return fqcn + " | " + (alt == null ? "-" : alt) + " | fytver:" + String.join(",", tokens);
                default:
                    return fqcn;
            }
        }
    }

    /** The codes a car reports its fuel consumption and its range under (DataCanbus.DATA indices); -1 = unknown. */
    public static final class CarCodes {
        public final int fuel;
        public final int range;

        public CarCodes(int fuel, int range) {
            this.fuel = fuel;
            this.range = range;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof CarCodes && ((CarCodes) o).fuel == fuel && ((CarCodes) o).range == range;
        }

        @Override
        public int hashCode() {
            return fuel * 31 + range;
        }

        /** The record text after the ids: {@code fuel | range}, {@code -} for an unknown code. */
        @Override
        public String toString() {
            return (fuel < 0 ? "-" : String.valueOf(fuel)) + " | " + (range < 0 ? "-" : String.valueOf(range));
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Progress, cancellation, results
    // ---------------------------------------------------------------------------------------------

    public interface ProgressSink {
        /** Bytes of the file read so far, and its total size (-1 when unknown). */
        void onBytes(long read, long total);

        /** The number of the line being read; called at the same pace as {@link #onBytes}. */
        default void onLine(int line) {
        }
    }

    public interface CancelToken {
        boolean isCancelled();
    }

    public static final class CancelledException extends RuntimeException {
        public CancelledException() {
            super("cancelled");
        }
    }

    public static final class Error {
        public final int line;
        public final String reason;

        Error(int line, String reason) {
            this.line = line;
            this.reason = reason;
        }

        @Override
        public String toString() {
            return line > 0 ? "line " + line + ": " + reason : reason;
        }
    }

    public static final class ParseResult {
        /** The library read, or null when there are errors. */
        public final Library library;
        public final List<Error> errors;
        /** Records of the file that repeated an identical record (per car id / per id and page). */
        public final int duplicatesInFile;
        /** Lines C/R/N/S/U in the file. */
        public final int recordLines;
        public final int declaredRecords;
        public final String declaredCrc;
        public final String computedCrc;
        /** The version of the header of the file (1 to 4); 0 when there was no valid header. */
        public final int version;

        ParseResult(Library library, List<Error> errors, int duplicatesInFile, int recordLines,
                    int declaredRecords, String declaredCrc, String computedCrc, int version) {
            this.library = library;
            this.errors = Collections.unmodifiableList(errors);
            this.duplicatesInFile = duplicatesInFile;
            this.recordLines = recordLines;
            this.declaredRecords = declaredRecords;
            this.declaredCrc = declaredCrc;
            this.computedCrc = computedCrc;
            this.version = version;
        }

        public boolean ok() {
            return errors.isEmpty();
        }
    }

    /** new / duplicate / replaced records of a merge, for one kind of record. */
    public static final class Counts {
        public int added;
        public int duplicate;
        public int replaced;

        public int total() {
            return added + duplicate + replaced;
        }
    }

    /** A record of the file that replaced a different one of the base. */
    public static final class Replacement {
        /** 'C', 'R', 'N', 'S' or 'U'. */
        public final char kind;
        public final int id;
        /** The page of an R record, else null. */
        public final String page;
        public final String oldValue;
        public final String newValue;

        Replacement(char kind, int id, String page, String oldValue, String newValue) {
            this.kind = kind;
            this.id = id;
            this.page = page;
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        @Override
        public String toString() {
            return kind + " " + id + (page == null ? "" : " " + page.substring(page.lastIndexOf('.') + 1))
                    + ": " + oldValue + " -> " + newValue;
        }
    }

    public static final class MergeResult {
        public final Library library;
        public final Counts classes = new Counts();
        public final Counts requests = new Counts();
        public final Counts noRequest = new Counts();
        public final Counts codes = new Counts();
        public final Counts units = new Counts();
        public final List<Replacement> replacements = new ArrayList<>();

        MergeResult(Library library) {
            this.library = library;
        }

        public int added() {
            return classes.added + requests.added + noRequest.added + codes.added + units.added;
        }

        public int duplicates() {
            return classes.duplicate + requests.duplicate + noRequest.duplicate + codes.duplicate + units.duplicate;
        }

        public int replaced() {
            return classes.replaced + requests.replaced + noRequest.replaced + codes.replaced + units.replaced;
        }
    }

    // ---------------------------------------------------------------------------------------------
    // The library
    // ---------------------------------------------------------------------------------------------

    public static final class Library {
        public static final Library EMPTY = new Library(new TreeMap<Integer, CarClass>(),
                new TreeMap<Integer, List<Page>>(), new TreeSet<Integer>(), new TreeMap<Integer, List<CarCodes>>(),
                new TreeMap<Integer, FuelUnit>());

        private final TreeMap<Integer, CarClass> classes;
        private final TreeMap<Integer, List<Page>> pages;
        private final TreeSet<Integer> noRequest;
        /** The pairs of a car in order of preference, the newest version of the canbus module first. */
        private final TreeMap<Integer, List<CarCodes>> codes;
        /** Where the protocol of a car reports the unit of the instantaneous consumption. */
        private final TreeMap<Integer, FuelUnit> units;

        Library(TreeMap<Integer, CarClass> classes, TreeMap<Integer, List<Page>> pages, TreeSet<Integer> noRequest,
                TreeMap<Integer, List<CarCodes>> codes, TreeMap<Integer, FuelUnit> units) {
            this.classes = classes;
            this.pages = pages;
            this.noRequest = noRequest;
            this.codes = codes;
            this.units = units;
        }

        /** Where the car's protocol reports the unit of the consumption, or null if the library does not say. */
        public FuelUnit unitFor(int id) {
            return units.get(id);
        }

        /** The first (preferred) fuel and range codes of a car, or null if the library has none for it. */
        public CarCodes codesFor(int id) {
            List<CarCodes> pairs = codes.get(id);
            return pairs == null ? null : pairs.get(0);
        }

        /** All the fuel and range pairs of a car, the preferred first; empty if the library has none for it. */
        public List<CarCodes> codePairsFor(int id) {
            List<CarCodes> pairs = codes.get(id);
            return pairs == null ? Collections.<CarCodes>emptyList() : pairs;
        }

        /** The fuel pages of a car and their requests, main page first; empty = the car needs no request. */
        public List<Page> pagesFor(int id) {
            List<Page> p = pages.get(id);
            return p == null ? Collections.<Page>emptyList() : p;
        }

        public CarClass carClassFor(int id) {
            return classes.get(id);
        }

        /**
         * The name of the class of the car's screen, or null if there is none.
         *
         * @param portrait whether the screen is portrait (getConfiguration() == 1)
         * @param fytver   the content of /sys/fytver/fyt_bin_version, null or empty if unknown
         */
        public String classNameFor(int id, boolean portrait, String fytver) {
            CarClass c = classes.get(id);
            if (c == null) {
                return null;
            }
            switch (c.condition) {
                case PORTRAIT:
                    return portrait ? c.alt : c.fqcn;
                case FYTVER:
                    if (fytver != null) {
                        for (String t : c.tokens) {
                            if (fytver.contains(t)) {
                                return c.alt;
                            }
                        }
                    }
                    return c.fqcn;
                default:
                    return c.fqcn;
            }
        }

        /** Cars with a class. */
        public int carsWithClass() {
            return classes.size();
        }

        /** Cars with at least one request. */
        public int carsWithRequest() {
            return pages.size();
        }

        /** Records the way a merge counts them: C per car, R per car and page, N per car, S per car, U per car. */
        public int recordCount() {
            int n = classes.size() + noRequest.size() + codes.size() + units.size();
            for (List<Page> p : pages.values()) {
                n += p.size();
            }
            return n;
        }

        public boolean isEmpty() {
            return classes.isEmpty() && pages.isEmpty() && noRequest.isEmpty() && codes.isEmpty() && units.isEmpty();
        }

        /** {@code base.mergedWith(file)}: the file wins where both have a record for the same car (and page). */
        public MergeResult mergedWith(Library file) {
            TreeMap<Integer, CarClass> c = new TreeMap<>(classes);
            TreeMap<Integer, List<Page>> p = new TreeMap<>(pages);
            TreeSet<Integer> n = new TreeSet<>(noRequest);
            TreeMap<Integer, List<CarCodes>> k = new TreeMap<>(codes);
            TreeMap<Integer, FuelUnit> u = new TreeMap<>(units);
            MergeResult res;
            List<Replacement> replacements = new ArrayList<>();
            Counts cc = new Counts();
            Counts rc = new Counts();
            Counts nc = new Counts();
            Counts kc = new Counts();
            Counts uc = new Counts();

            for (Map.Entry<Integer, CarClass> e : file.classes.entrySet()) {
                CarClass old = c.get(e.getKey());
                if (old == null) {
                    cc.added++;
                } else if (old.equals(e.getValue())) {
                    cc.duplicate++;
                } else {
                    cc.replaced++;
                    replacements.add(new Replacement('C', e.getKey(), null, old.toString(), e.getValue().toString()));
                }
                c.put(e.getKey(), e.getValue());
            }

            for (Map.Entry<Integer, List<Page>> e : file.pages.entrySet()) {
                int id = e.getKey();
                List<Page> basePages = p.get(id);
                List<Page> merged = new ArrayList<>();
                for (Page fp : e.getValue()) {
                    Page old = null;
                    if (basePages != null) {
                        for (Page bp : basePages) {
                            if (bp.fqcn.equals(fp.fqcn)) {
                                old = bp;
                                break;
                            }
                        }
                    }
                    if (old == null) {
                        rc.added++;
                    } else if (old.equals(fp)) {
                        rc.duplicate++;
                    } else {
                        rc.replaced++;
                        replacements.add(new Replacement('R', id, fp.fqcn, old.requestsText(), fp.requestsText()));
                    }
                    merged.add(fp);
                }
                if (basePages != null) {
                    for (Page bp : basePages) {
                        boolean mentioned = false;
                        for (Page fp : e.getValue()) {
                            if (fp.fqcn.equals(bp.fqcn)) {
                                mentioned = true;
                                break;
                            }
                        }
                        if (!mentioned && merged.size() < MAX_PAGES_PER_ID) {
                            merged.add(bp);
                        }
                    }
                }
                p.put(id, Collections.unmodifiableList(merged));
                n.remove(id);
            }

            for (int id : file.noRequest) {
                if (n.contains(id)) {
                    nc.duplicate++;
                } else if (p.containsKey(id)) {
                    nc.replaced++;
                    List<Page> gone = p.remove(id);
                    replacements.add(new Replacement('N', id, null, pagesText(gone), "no request"));
                } else {
                    nc.added++;
                }
                n.add(id);
                p.remove(id);
            }

            for (Map.Entry<Integer, List<CarCodes>> e : file.codes.entrySet()) {
                List<CarCodes> old = k.get(e.getKey());
                // the pairs of the file first, then those of the base the file does not have, at most MAX_CODE_PAIRS
                List<CarCodes> merged = new ArrayList<>(e.getValue());
                if (old != null) {
                    for (CarCodes pair : old) {
                        if (!merged.contains(pair) && merged.size() < MAX_CODE_PAIRS) {
                            merged.add(pair);
                        }
                    }
                }
                if (old == null) {
                    kc.added++;
                } else if (old.equals(e.getValue())) {
                    kc.duplicate++;
                } else {
                    kc.replaced++;
                    replacements.add(new Replacement('S', e.getKey(), null, pairsText(old), pairsText(merged)));
                }
                k.put(e.getKey(), Collections.unmodifiableList(merged));
            }

            for (Map.Entry<Integer, FuelUnit> e : file.units.entrySet()) {
                FuelUnit old = u.get(e.getKey());
                if (old == null) {
                    uc.added++;
                } else if (old.equals(e.getValue())) {
                    uc.duplicate++;
                } else {
                    uc.replaced++;
                    replacements.add(new Replacement('U', e.getKey(), null, old.toString(), e.getValue().toString()));
                }
                u.put(e.getKey(), e.getValue());
            }

            res = new MergeResult(new Library(c, p, n, k, u));
            copy(cc, res.classes);
            copy(rc, res.requests);
            copy(nc, res.noRequest);
            copy(kc, res.codes);
            copy(uc, res.units);
            res.replacements.addAll(replacements);
            return res;
        }

        private static String pairsText(List<CarCodes> pairs) {
            StringBuilder sb = new StringBuilder();
            for (CarCodes pair : pairs) {
                if (sb.length() > 0) {
                    sb.append(" | ");
                }
                sb.append(pair);
            }
            return sb.toString();
        }

        private static String pagesText(List<Page> pages) {
            StringBuilder sb = new StringBuilder();
            for (Page pg : pages) {
                if (sb.length() > 0) {
                    sb.append(" / ");
                }
                sb.append(pg.simpleName()).append(' ').append(pg.requestsText());
            }
            return sb.toString();
        }

        private static void copy(Counts from, Counts to) {
            to.added = from.added;
            to.duplicate = from.duplicate;
            to.replaced = from.replaced;
        }

        /** The library as a file of the format, footer included. Parsing it gives the same library. */
        public String serialize() {
            return serialize(Collections.<String>emptyList());
        }

        /**
         * {@link #serialize()} with comment lines (each one is written as {@code # <text>}) right after the header.
         * They are part of the checksum like any line of the body, and no record.
         */
        public String serialize(List<String> comments) {
            boolean several = false;
            for (List<CarCodes> pairs : codes.values()) {
                several |= pairs.size() > 1;
            }
            StringBuilder body = new StringBuilder(!units.isEmpty() ? HEADER_4 : several ? HEADER_3 : HEADER).append('\n');
            for (String comment : comments) {
                body.append("# ").append(comment.replace('\r', ' ').replace('\n', ' ')).append('\n');
            }

            Map<CarClass, List<Integer>> byClass = new LinkedHashMap<>();
            for (Map.Entry<Integer, CarClass> e : classes.entrySet()) {
                List<Integer> ids = byClass.get(e.getValue());
                if (ids == null) {
                    ids = new ArrayList<>();
                    byClass.put(e.getValue(), ids);
                }
                ids.add(e.getKey());
            }
            for (Map.Entry<CarClass, List<Integer>> e : byClass.entrySet()) {
                for (String ids : idChunks(e.getValue())) {
                    body.append("C ").append(ids).append(" | ").append(e.getKey()).append('\n');
                }
            }

            Map<List<Page>, List<Integer>> byPages = new LinkedHashMap<>();
            for (Map.Entry<Integer, List<Page>> e : pages.entrySet()) {
                List<Integer> ids = byPages.get(e.getValue());
                if (ids == null) {
                    ids = new ArrayList<>();
                    byPages.put(e.getValue(), ids);
                }
                ids.add(e.getKey());
            }
            for (Map.Entry<List<Page>, List<Integer>> e : byPages.entrySet()) {
                List<String> chunks = idChunks(e.getValue());
                for (Page pg : e.getKey()) {
                    for (String ids : chunks) {
                        body.append("R ").append(ids).append(" | ").append(pg.fqcn).append(" | ")
                                .append(pg.requestsText()).append('\n');
                    }
                }
            }

            if (!noRequest.isEmpty()) {
                for (String ids : idChunks(new ArrayList<>(noRequest))) {
                    body.append("N ").append(ids).append('\n');
                }
            }

            Map<List<CarCodes>, List<Integer>> byCodes = new LinkedHashMap<>();
            for (Map.Entry<Integer, List<CarCodes>> e : codes.entrySet()) {
                List<Integer> ids = byCodes.get(e.getValue());
                if (ids == null) {
                    ids = new ArrayList<>();
                    byCodes.put(e.getValue(), ids);
                }
                ids.add(e.getKey());
            }
            for (Map.Entry<List<CarCodes>, List<Integer>> e : byCodes.entrySet()) {
                for (String ids : idChunks(e.getValue())) {
                    body.append("S ").append(ids).append(" | ").append(pairsText(e.getKey())).append('\n');
                }
            }

            Map<FuelUnit, List<Integer>> byUnit = new LinkedHashMap<>();
            for (Map.Entry<Integer, FuelUnit> e : units.entrySet()) {
                List<Integer> ids = byUnit.get(e.getValue());
                if (ids == null) {
                    ids = new ArrayList<>();
                    byUnit.put(e.getValue(), ids);
                }
                ids.add(e.getKey());
            }
            for (Map.Entry<FuelUnit, List<Integer>> e : byUnit.entrySet()) {
                for (String ids : idChunks(e.getValue())) {
                    body.append("U ").append(ids).append(" | ").append(e.getKey()).append('\n');
                }
            }
            return seal(body.toString());
        }

        private static List<String> idChunks(List<Integer> ids) {
            List<String> out = new ArrayList<>();
            for (int i = 0; i < ids.size(); i += MAX_IDS_PER_LINE) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < Math.min(ids.size(), i + MAX_IDS_PER_LINE); j++) {
                    if (j > i) {
                        sb.append(',');
                    }
                    sb.append(ids.get(j));
                }
                out.add(sb.toString());
            }
            return out;
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Export
    // ---------------------------------------------------------------------------------------------

    /** The time stamp of an export's name, the one the script's files have: {@code 2026-10-30_00-56-34}. */
    static final String EXPORT_STAMP_PATTERN = "yyyy-MM-dd_HH-mm-ss";

    /** {@code canbus_library_export_2026-10-30_00-56-34.txt}. */
    static String exportFileName(long timeMillis) {
        return "canbus_library_export_"
                + new java.text.SimpleDateFormat(EXPORT_STAMP_PATTERN, java.util.Locale.US).format(new java.util.Date(timeMillis))
                + ".txt";
    }

    /**
     * The file to export: the library as it is used, with a comment after the header that tells how many record lines
     * and cars it has and when it was written. Reading it gives the library back.
     */
    public static String exportText(Library library, long timeMillis) {
        String when = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US)
                .format(new java.util.Date(timeMillis));
        // The lines the footer counts, not the records of the library (those are per car and page)
        int recordLines = 0;
        for (String line : library.serialize().split("\n")) {
            if (line.startsWith("C ") || line.startsWith("R ") || line.startsWith("N ") || line.startsWith("S ")
                    || line.startsWith("U ")) {
                recordLines++;
            }
        }
        return library.serialize(Collections.singletonList("Exported by the launcher on " + when + ": "
                + recordLines + " record lines (" + library.recordCount() + " records per car), "
                + library.carsWithClass() + " cars with a class, " + library.carsWithRequest() + " with a request."));
    }

    // ---------------------------------------------------------------------------------------------
    // Footer
    // ---------------------------------------------------------------------------------------------

    /**
     * {@code body} (from the header line to the last record, lines separated by \n) with the footer
     * {@code end <records> <crc32>} appended. Every line ends with \n.
     */
    public static String seal(String bodyWithoutFooter) {
        String body = bodyWithoutFooter;
        if (!body.isEmpty() && !body.endsWith("\n")) {
            body += "\n";
        }
        int records = 0;
        CRC32 crc = new CRC32();
        int start = 0;
        while (start < body.length()) {
            int nl = body.indexOf('\n', start);
            String line = body.substring(start, nl);
            if (line.startsWith("C ") || line.startsWith("R ") || line.startsWith("N ") || line.startsWith("S ")
                    || line.startsWith("U ")) {
                records++;
            }
            crc.update((line + "\n").getBytes(StandardCharsets.UTF_8));
            start = nl + 1;
        }
        return body + "end " + records + " " + crcText(crc) + "\n";
    }

    private static String crcText(CRC32 crc) {
        return String.format(java.util.Locale.ROOT, "%08x", crc.getValue());
    }

    // ---------------------------------------------------------------------------------------------
    // Parsing
    // ---------------------------------------------------------------------------------------------

    /**
     * Reads a library file. The file is valid only as a whole: all errors (up to {@link #MAX_ERRORS}) are
     * collected, and with one the result has no library.
     *
     * @param sizeBytes the size of the file (for the limit and the progress), -1 if unknown
     * @throws CancelledException when {@code cancel} says so (checked every 200 lines)
     */
    public static ParseResult parse(Reader reader, long sizeBytes, ProgressSink progress, CancelToken cancel)
            throws IOException {
        Parser p = new Parser(sizeBytes, progress, cancel);
        return p.run(reader);
    }

    private static final class Parser {
        private final long sizeBytes;
        private final ProgressSink progress;
        private final CancelToken cancel;
        private final List<Error> errors = new ArrayList<>();
        private final TreeMap<Integer, CarClass> classes = new TreeMap<>();
        private final TreeMap<Integer, List<Page>> pages = new TreeMap<>();
        private final TreeSet<Integer> noRequest = new TreeSet<>();
        private final TreeMap<Integer, List<CarCodes>> codes = new TreeMap<>();
        private final TreeMap<Integer, FuelUnit> units = new TreeMap<>();
        private int version;
        private int recordLines;
        private int duplicates;

        Parser(long sizeBytes, ProgressSink progress, CancelToken cancel) {
            this.sizeBytes = sizeBytes;
            this.progress = progress;
            this.cancel = cancel;
        }

        void err(int line, String reason) {
            if (errors.size() < MAX_ERRORS) {
                errors.add(new Error(line, reason));
            }
        }

        ParseResult run(Reader source) throws IOException {
            Reader reader = new BufferedReader(source);
            if (sizeBytes > MAX_BYTES) {
                err(0, "file larger than " + MAX_BYTES + " bytes");
                return result(-1, null, null);
            }
            CRC32 crc = new CRC32();
            boolean headerSeen = false;
            boolean footerSeen = false;
            int headerLine = 0;
            int footerLine = 0;
            int declared = -1;
            String declaredCrc = null;
            String computedCrc = null;
            long bytes = 0;
            int lineNo = 0;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            boolean eof = false;
            while (!eof) {
                int ch = reader.read();
                String line;
                if (ch < 0) {
                    eof = true;
                    if (sb.length() == 0) {
                        break;
                    }
                    line = sb.toString();
                    sb.setLength(0);
                } else if (ch == '\n') {
                    line = sb.toString();
                    sb.setLength(0);
                } else {
                    sb.append((char) ch);
                    continue;
                }
                lineNo++;
                if (first) {
                    first = false;
                    if (line.length() > 0 && line.charAt(0) == '﻿') {
                        line = line.substring(1);
                    }
                }
                if (line.endsWith("\r")) {
                    line = line.substring(0, line.length() - 1);
                }
                if (lineNo > MAX_LINES) {
                    err(0, "more than " + MAX_LINES + " lines");
                    return result(-1, null, null);
                }
                byte[] raw = (line + "\n").getBytes(StandardCharsets.UTF_8);
                bytes += raw.length;
                if (bytes > MAX_BYTES) {
                    err(0, "file larger than " + MAX_BYTES + " bytes");
                    return result(-1, null, null);
                }
                if (lineNo % CANCEL_CHECK_EVERY == 0) {
                    if (cancel != null && cancel.isCancelled()) {
                        throw new CancelledException();
                    }
                    if (progress != null) {
                        progress.onLine(lineNo);
                        progress.onBytes(bytes, sizeBytes);
                    }
                }

                String s = line.trim();
                if (footerSeen) {
                    if (!s.isEmpty()) {
                        err(lineNo, "content after the footer");
                    }
                    continue;
                }
                if (s.isEmpty() || s.charAt(0) == '#') {
                    if (headerSeen) {
                        crc.update(raw);
                    }
                    continue;
                }
                if (!headerSeen) {
                    headerSeen = true;
                    headerLine = lineNo;
                    Matcher hm = HEADER_LINE.matcher(s);
                    if (!hm.matches()) {
                        err(lineNo, "missing or unsupported header (expected \"canbus_library 1\" to \"canbus_library 4\")");
                        return result(-1, null, null);
                    }
                    version = Integer.parseInt(hm.group(1));
                    crc.update(raw);
                    continue;
                }
                Matcher fm = FOOTER.matcher(s);
                if (fm.matches()) {
                    footerSeen = true;
                    footerLine = lineNo;
                    try {
                        declared = Integer.parseInt(fm.group(1));
                    } catch (NumberFormatException e) {
                        declared = Integer.MAX_VALUE;
                    }
                    declaredCrc = fm.group(2);
                    computedCrc = crcText(crc);
                    continue;
                }
                if (FOOTER_LIKE.matcher(s).matches()) {
                    footerSeen = true;
                    footerLine = lineNo;
                    err(lineNo, "bad footer (expected \"end <records> <crc32>\")");
                    continue;
                }
                crc.update(raw);
                record(lineNo, s);
            }
            if (progress != null) {
                progress.onBytes(bytes, sizeBytes);
            }
            if (!headerSeen) {
                err(0, "empty file: missing header \"canbus_library 1\" to \"canbus_library 4\"");
            } else if (!footerSeen) {
                err(lineNo, "missing footer \"end <records> <crc32>\"");
            } else if (declared >= 0) {
                if (declared != recordLines) {
                    err(footerLine, "footer says " + declared + " records, the file has " + recordLines);
                }
                if (!computedCrc.equals(declaredCrc)) {
                    err(footerLine, "CRC32 mismatch: footer " + declaredCrc + ", computed " + computedCrc);
                }
            }
            return result(declared, declaredCrc, computedCrc);
        }

        private ParseResult result(int declared, String declaredCrc, String computedCrc) {
            Library lib = null;
            if (errors.isEmpty()) {
                TreeMap<Integer, List<Page>> frozen = new TreeMap<>();
                for (Map.Entry<Integer, List<Page>> e : pages.entrySet()) {
                    frozen.put(e.getKey(), Collections.unmodifiableList(new ArrayList<>(e.getValue())));
                }
                lib = new Library(new TreeMap<>(classes), frozen, new TreeSet<>(noRequest), new TreeMap<>(codes),
                        new TreeMap<>(units));
            }
            return new ParseResult(lib, new ArrayList<>(errors), duplicates, recordLines,
                    declared, declaredCrc, computedCrc, version);
        }

        private void record(int no, String s) {
            char kind = s.charAt(0);
            if ((kind != 'C' && kind != 'R' && kind != 'N' && kind != 'S' && kind != 'U') || (s.length() > 1 && !Character.isWhitespace(s.charAt(1)))) {
                err(no, "unknown record \"" + (s.length() > 20 ? s.substring(0, 20) : s) + "\"");
                return;
            }
            recordLines++;
            String[] raw = s.substring(1).split("\\|", -1);
            String[] f = new String[raw.length];
            for (int i = 0; i < raw.length; i++) {
                f[i] = raw[i].trim();
            }
            Object[] parsed = parseIds(f[0]);
            if (parsed[0] == null) {
                err(no, (String) parsed[1]);
                return;
            }
            int[] ids = (int[]) parsed[0];
            switch (kind) {
                case 'N':
                    noRecord(no, f, ids);
                    break;
                case 'C':
                    classRecord(no, f, ids);
                    break;
                case 'S':
                    codesRecord(no, f, ids);
                    break;
                case 'U':
                    unitRecord(no, f, ids);
                    break;
                default:
                    pageRecord(no, f, ids);
                    break;
            }
        }

        private void noRecord(int no, String[] f, int[] ids) {
            if (f.length != 1) {
                err(no, "N takes only ids");
                return;
            }
            for (int id : ids) {
                if (pages.containsKey(id)) {
                    err(no, "id " + id + " has both N and R records");
                } else if (noRequest.contains(id)) {
                    duplicates++;
                } else {
                    noRequest.add(id);
                }
            }
        }

        private void classRecord(int no, String[] f, int[] ids) {
            if (f.length != 2 && f.length != 4) {
                err(no, "C takes \"ids | class\" or \"ids | class | alt | condition\"");
                return;
            }
            String cls = f[1];
            if (!validClass(cls)) {
                err(no, "bad class name \"" + clip(cls) + "\"");
                return;
            }
            String alt = null;
            Condition cond = Condition.NONE;
            List<String> tokens = Collections.emptyList();
            if (f.length == 4) {
                alt = f[2];
                if (!alt.equals("-") && !validClass(alt)) {
                    err(no, "bad alternative class \"" + clip(alt) + "\"");
                    return;
                }
                if (alt.equals("-")) {
                    alt = null;
                }
                String c = f[3];
                if (c.equals("portrait")) {
                    cond = Condition.PORTRAIT;
                } else if (c.startsWith("fytver:")) {
                    String[] parts = c.substring(7).split(",", -1);
                    if (parts.length < 1 || parts.length > 8) {
                        err(no, "bad fytver tokens \"" + clip(c.substring(7)) + "\"");
                        return;
                    }
                    List<String> list = new ArrayList<>();
                    for (String t : parts) {
                        t = t.trim();
                        if (!TOKEN.matcher(t).matches()) {
                            err(no, "bad fytver tokens \"" + clip(c.substring(7)) + "\"");
                            return;
                        }
                        list.add(t);
                    }
                    cond = Condition.FYTVER;
                    tokens = list;
                } else {
                    err(no, "bad condition \"" + clip(c) + "\" (portrait or fytver:tokens)");
                    return;
                }
            }
            CarClass rec = new CarClass(cls, alt, cond, tokens);
            for (int id : ids) {
                CarClass old = classes.get(id);
                if (old == null) {
                    classes.put(id, rec);
                } else if (old.equals(rec)) {
                    duplicates++;
                } else {
                    err(no, "id " + id + " has two different C records");
                }
            }
        }

        private void codesRecord(int no, String[] f, int[] ids) {
            if (version < 2) {
                err(no, "S records need version 2");
                return;
            }
            int count = f.length - 1;
            if (count < 2 || count % 2 != 0) {
                err(no, "S takes \"ids | fuel code | range code [| fuel code | range code]...\"");
                return;
            }
            if (count > 2 && version < 3) {
                err(no, "several code pairs need version 3");
                return;
            }
            if (count / 2 > MAX_CODE_PAIRS) {
                err(no, "more than " + MAX_CODE_PAIRS + " code pairs");
                return;
            }
            int[] values = new int[count];
            for (int i = 0; i < count; i++) {
                String t = f[i + 1];
                if (t.equals("-")) {
                    values[i] = -1;
                } else if (t.matches("[0-9]{1,4}") && Integer.parseInt(t) <= MAX_CODE) {
                    values[i] = Integer.parseInt(t);
                } else {
                    err(no, "bad code \"" + clip(t) + "\" (0.." + MAX_CODE + " or -)");
                    return;
                }
            }
            List<CarCodes> pairs = new ArrayList<>();
            for (int i = 0; i < count; i += 2) {
                if (values[i] < 0 && values[i + 1] < 0) {
                    err(no, "S with nothing to say (\"- | -\")");
                    return;
                }
                pairs.add(new CarCodes(values[i], values[i + 1]));
            }
            if (new HashSet<>(pairs).size() != pairs.size()) {
                err(no, "a code pair repeated in the record");
                return;
            }
            List<CarCodes> rec = Collections.unmodifiableList(pairs);
            for (int id : ids) {
                List<CarCodes> old = codes.get(id);
                if (old == null) {
                    codes.put(id, rec);
                } else if (old.equals(rec)) {
                    duplicates++;
                } else {
                    err(no, "id " + id + " has two different S records");
                }
            }
        }

        private void unitRecord(int no, String[] f, int[] ids) {
            if (version < 4) {
                err(no, "U records need version 4");
                return;
            }
            FuelUnit unit;
            try {
                unit = FuelUnit.parse(f, 1);
            } catch (IllegalArgumentException e) {
                err(no, e.getMessage());
                return;
            }
            for (int id : ids) {
                FuelUnit old = units.get(id);
                if (old == null) {
                    units.put(id, unit);
                } else if (old.equals(unit)) {
                    duplicates++;
                } else {
                    err(no, "id " + id + " has two different U records");
                }
            }
        }

        private void pageRecord(int no, String[] f, int[] ids) {
            if (f.length != 3) {
                err(no, "R takes \"ids | page | requests\"");
                return;
            }
            String page = f[1];
            if (!validClass(page)) {
                err(no, "bad page class \"" + clip(page) + "\"");
                return;
            }
            String[] parts = f[2].split(";", -1);
            if (parts.length < 1 || parts.length > MAX_REQUESTS_PER_PAGE) {
                err(no, "R takes 1 to " + MAX_REQUESTS_PER_PAGE + " requests");
                return;
            }
            List<Request> reqs = new ArrayList<>();
            for (String part : parts) {
                Matcher m = REQUEST.matcher(part);
                if (!m.matches()) {
                    err(no, "bad request \"" + clip(part.trim()) + "\"");
                    return;
                }
                int cmd = Integer.parseInt(m.group(1));
                if (cmd > 9999) {
                    err(no, "cmd " + cmd + " outside 0..9999");
                    return;
                }
                int[] ints = new int[0];
                if (m.group(2) != null) {
                    String[] nums = m.group(2).split(",");
                    if (nums.length > MAX_INTS) {
                        err(no, "more than " + MAX_INTS + " numbers in a request");
                        return;
                    }
                    ints = new int[nums.length];
                    for (int i = 0; i < nums.length; i++) {
                        long v;
                        try {
                            v = Long.parseLong(nums[i].trim());
                        } catch (NumberFormatException e) {
                            v = Long.MAX_VALUE;
                        }
                        if (v < -65536 || v > 65536) {
                            err(no, "a number outside -65536..65536");
                            return;
                        }
                        ints[i] = (int) v;
                    }
                }
                reqs.add(new Request(cmd, ints));
            }
            Page pg = new Page(page, reqs);
            for (int id : ids) {
                if (noRequest.contains(id)) {
                    err(no, "id " + id + " has both N and R records");
                    continue;
                }
                List<Page> list = pages.get(id);
                if (list == null) {
                    list = new ArrayList<>();
                    pages.put(id, list);
                }
                Page old = null;
                for (Page q : list) {
                    if (q.fqcn.equals(page)) {
                        old = q;
                        break;
                    }
                }
                if (old != null) {
                    if (old.equals(pg)) {
                        duplicates++;
                    } else {
                        err(no, "id " + id + " page " + pg.simpleName() + " has two different request lists");
                    }
                } else if (list.size() >= MAX_PAGES_PER_ID) {
                    err(no, "id " + id + " has more than " + MAX_PAGES_PER_ID + " pages");
                } else {
                    list.add(pg);
                }
            }
        }

        private static boolean validClass(String name) {
            return name.length() <= 200 && CLASS_NAME.matcher(name).matches();
        }

        private static String clip(String s) {
            return s.length() > 60 ? s.substring(0, 60) : s;
        }

        /** {ids, null} or {null, reason}. */
        private static Object[] parseIds(String text) {
            if (text.isEmpty()) {
                return new Object[]{null, "ids must be decimal numbers separated by commas"};
            }
            String[] parts = text.split(",", -1);
            if (parts.length > MAX_IDS_PER_LINE) {
                return new Object[]{null, "more than " + MAX_IDS_PER_LINE + " ids"};
            }
            int[] ids = new int[parts.length];
            java.util.HashSet<Integer> seen = new java.util.HashSet<>();
            for (int i = 0; i < parts.length; i++) {
                String t = parts[i].trim();
                if (t.isEmpty() || t.length() > 10) {
                    return new Object[]{null, t.isEmpty()
                            ? "ids must be decimal numbers separated by commas" : "an id outside 1..2147483647"};
                }
                for (int k = 0; k < t.length(); k++) {
                    char c = t.charAt(k);
                    if (c < '0' || c > '9') {
                        return new Object[]{null, "ids must be decimal numbers separated by commas"};
                    }
                }
                long v = Long.parseLong(t);
                if (v < 1 || v > Integer.MAX_VALUE) {
                    return new Object[]{null, "an id outside 1..2147483647"};
                }
                if (!seen.add((int) v)) {
                    return new Object[]{null, "an id repeated in the line"};
                }
                ids[i] = (int) v;
            }
            return new Object[]{ids, null};
        }
    }

    // ---------------------------------------------------------------------------------------------
    // On the device: the built-in library, the user's one, and the request of the car
    // ---------------------------------------------------------------------------------------------

    private static final String TAG = "CanbusLibrary";
    static final String ASSET_NAME = "canbus_library.txt";
    static final String USER_FILE_NAME = "canbus_library_user.txt";
    /** What {@link #sendForCar} reports when it sent nothing. */
    static final String NONE = "none";

    private static final Object LOAD_LOCK = new Object();
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "CanbusLibrary");
        t.setDaemon(true);
        return t;
    });
    private static volatile Library sBuiltIn;
    private static volatile Library sOverlay;
    private static volatile Library sEffective;

    /** The single thread the files are read and written on, and the requests are sent from. */
    static ExecutorService executor() {
        return EXECUTOR;
    }

    /** Reads the library on the executor, so that the first use does not wait for the files. */
    public static void preload(Context context) {
        final Context app = context.getApplicationContext();
        EXECUTOR.execute(() -> loadBlocking(app));
    }

    /** The library in use (built-in merged with the user's), or null while it is not loaded yet. Never reads a file. */
    public static Library cached() {
        return sEffective;
    }

    /** The library in use, loaded if needed. Not on the main thread (it reads the asset and a file). */
    public static Library loadBlocking(Context context) {
        Library ready = sEffective;
        if (ready != null) {
            return ready;
        }
        Looper main = Looper.getMainLooper();
        if (main != null && Looper.myLooper() == main) {
            throw new IllegalStateException("CanbusLibrary.loadBlocking() on the main thread");
        }
        synchronized (LOAD_LOCK) {
            if (sEffective != null) {
                return sEffective;
            }
            Context app = context.getApplicationContext();
            Library builtIn = sBuiltIn;
            if (builtIn == null) {
                builtIn = readAsset(app);
                sBuiltIn = builtIn;
            }
            Library overlay = sOverlay;
            if (overlay == null) {
                overlay = readUserFile(app);
                sOverlay = overlay;
            }
            sEffective = builtIn.mergedWith(overlay).library;
            return sEffective;
        }
    }

    /** The libraries the user imported (merged into one), loaded if needed; empty if there are none. Not on the main thread. */
    static Library overlayBlocking(Context context) {
        loadBlocking(context);
        Library overlay = sOverlay;
        return overlay == null ? Library.EMPTY : overlay;
    }

    /** The libraries the user imported, or null while they are not loaded yet. Never reads a file. */
    static Library overlayCached() {
        return sOverlay;
    }

    /** After an import or a reset: the next {@link #loadBlocking} reads the files again. */
    static void invalidate() {
        synchronized (LOAD_LOCK) {
            sOverlay = null;
            sEffective = null;
        }
    }

    static File userFile(Context context) {
        return new File(context.getApplicationContext().getFilesDir(), USER_FILE_NAME);
    }

    private static Library readAsset(Context app) {
        try (InputStream in = app.getAssets().open(ASSET_NAME);
             InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            ParseResult r = parse(reader, -1, null, null);
            if (r.ok()) {
                return r.library;
            }
            Log.e(TAG, "The built-in library is not valid: " + r.errors.get(0));
        } catch (IOException | RuntimeException e) {
            Log.e(TAG, "Could not read the built-in library", e);
        }
        return Library.EMPTY;
    }

    private static Library readUserFile(Context app) {
        File file = userFile(app);
        if (!file.isFile()) {
            return Library.EMPTY;
        }
        try (InputStream in = new java.io.FileInputStream(file);
             InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            ParseResult r = parse(reader, file.length(), null, null);
            if (r.ok()) {
                return r.library;
            }
            Log.w(TAG, "The imported library is not valid, ignored: " + r.errors.get(0));
        } catch (IOException | RuntimeException e) {
            Log.w(TAG, "Could not read the imported library, ignored", e);
        }
        return Library.EMPTY;
    }

    /**
     * The request the user wrote in the Canbus codes window, or null if there is none. Empty fields, or
     * "0" and "0" (what saving the window used to write for an empty field), mean none.
     */
    static Request userRequest(SharedPreferences prefs) {
        String cmd = prefs.getString(Keys.CMD_INT, "").trim();
        String arr = prefs.getString(Keys.CMD_ARR, "").trim();
        if ((cmd.isEmpty() || cmd.equals("0")) && (arr.isEmpty() || arr.equals("0"))) {
            return null;
        }
        try {
            int c = Integer.parseInt(cmd.isEmpty() ? "0" : cmd);
            int[] ints = parseInts(arr);
            if (ints == null || c < 0 || c > 9999) {
                Log.w(TAG, "The request in the settings is not valid: cmdInt \"" + cmd + "\", cmdArr \"" + arr + "\"");
                return null;
            }
            return new Request(c, ints);
        } catch (NumberFormatException e) {
            Log.w(TAG, "The request in the settings is not valid: cmdInt \"" + cmd + "\", cmdArr \"" + arr + "\"");
            return null;
        }
    }

    /**
     * Sends the car the request its fuel screen sends when it opens, on the executor: nothing for a car
     * that needs none (and nothing is sent to it at all), the user's own request if there is one, else
     * all requests of the car's main fuel page, in order. The result is a description of what was sent,
     * {@link #NONE} if nothing.
     */
    public static Future<String> sendForCar(Context context, int carId) {
        final Context app = context.getApplicationContext();
        return EXECUTOR.submit(() -> {
            try {
                return sendForCarNow(app, carId);
            } catch (RuntimeException e) {
                Log.w(TAG, "Could not send the request of car " + carId, e);
                return NONE;
            }
        });
    }

    private static String sendForCarNow(Context app, int carId) {
        if (carId == 0) {
            return NONE;
        }
        List<Page> pages = loadBlocking(app).pagesFor(carId);
        if (pages.isEmpty()) {
            Log.i(TAG, "Car " + carId + " needs no request, nothing sent");
            return NONE;
        }
        Request user = userRequest(PreferenceManager.getDefaultSharedPreferences(app));
        if (user != null) {
            send(user);
            Log.i(TAG, "Car " + carId + ": sent the request from the settings, " + user);
            return user.toString();
        }
        Page main = pages.get(0);
        for (Request r : main.requests) {
            send(r);
        }
        Log.i(TAG, "Car " + carId + ": sent the requests of " + main.simpleName() + ", " + main.requestsText());
        return main.requestsText();
    }

    private static void send(Request r) {
        DataCanbus.PROXY.cmd(r.cmd, r.ints(), null, null);
    }

    /** The first request of the car's main page, for the hint of the fields, or null if the car has none. */
    static Request firstRequest(Library library, int carId) {
        List<Page> pages = library.pagesFor(carId);
        return pages.isEmpty() || pages.get(0).requests.isEmpty() ? null : pages.get(0).requests.get(0);
    }

    /** Runs {@code onMainThread} on the main thread once the library is loaded (loading it on the executor if needed). */
    static void whenLoaded(Context context, Runnable onMainThread) {
        final Context app = context.getApplicationContext();
        EXECUTOR.execute(() -> {
            loadBlocking(app);
            new android.os.Handler(Looper.getMainLooper()).post(onMainThread);
        });
    }

    /** One line per page of the car, {@code OilMilePage1Acti: 70:51; 29:0}; empty if the car has none. */
    static String knownRequestsText(Library library, int carId) {
        StringBuilder sb = new StringBuilder();
        for (Page p : library.pagesFor(carId)) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(p.simpleName()).append(": ").append(p.requestsText());
        }
        return sb.toString();
    }

    // ---------------------------------------------------------------------------------------------
    // cmdArr field
    // ---------------------------------------------------------------------------------------------

    /**
     * The numbers of a cmdArr field: {@code "74,3"} and {@code " 74, 3 "} give {74, 3}, {@code "51"} gives {51},
     * an empty text gives an empty array and a bad one (a stray comma, a letter, too many or too big numbers) null.
     */
    public static int[] parseInts(String text) {
        if (text == null) {
            return new int[0];
        }
        String t = text.trim();
        if (t.isEmpty()) {
            return new int[0];
        }
        String[] parts = t.split(",", -1);
        if (parts.length > MAX_INTS) {
            return null;
        }
        int[] out = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String s = parts[i].trim();
            if (!s.matches("-?[0-9]{1,6}")) {
                return null;
            }
            int v = Integer.parseInt(s);
            if (v < -65536 || v > 65536) {
                return null;
            }
            out[i] = v;
        }
        return out;
    }
}
