package com.android.launcher66.settings;

import com.android.launcher66.settings.CanbusCodeEstimator.Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * The raw frames of an RZC CAN box, as they arrive in the updates of a code: {@code FD len cmd data... checksum}
 * with {@code len} the number of bytes after the 0xFD and {@code checksum = (len + cmd + data) & 0xFF}. A frame
 * can come in two updates, and one update can hold several frames. Which code carries them depends on the CAN
 * box, so a code is taken for a channel of frames by what it holds (see {@link #assemble}), never by its number.
 *
 * Plain Java (no android.*), so that it runs in JVM tests.
 */
public final class CanbusFrames {

    private static final int START = 0xFD;
    /** A frame goes on in an update that comes at most this long after the previous one. */
    private static final long CONTINUATION_MS = 50L;
    /** A code follows its frame by this much: the value of the code at the time of the frame + this. */
    private static final long CODE_FOLLOWS_MS = 300L;
    private static final int MIN_FRAMES = 20;
    private static final double MIN_SHARE = 0.8;
    static final int MAX_TYPES = 30;
    static final int MAX_FIELDS_PER_TYPE = 8;
    private static final double MATCH_SHARE = 0.9;
    private static final int MIN_COMPARED = 10;

    private CanbusFrames() {
    }

    /** One update of a code: its time and the whole payload (ints). */
    public static final class Event {
        public final long t;
        public final int[] ints;

        public Event(long t, int[] ints) {
            this.t = t;
            this.ints = ints;
        }
    }

    public static final class Frame {
        public final long t;
        public final int cmd;
        public final int len;
        /** The bytes between cmd and the checksum. */
        public final int[] data;
        public final boolean checksumOk;

        Frame(long t, int cmd, int len, int[] data, boolean checksumOk) {
            this.t = t;
            this.cmd = cmd;
            this.len = len;
            this.data = data;
            this.checksumOk = checksumOk;
        }
    }

    /** The frames put together from the updates of one code, and whether the code is a channel of them. */
    public static final class Channel {
        public final int code;
        public final List<Frame> frames;
        public final int checksumOk;
        /** Updates with at least 4 numbers, and how many of them start with 0xFD. */
        public final int longEvents;
        public final int startingWithStart;

        Channel(int code, List<Frame> frames, int checksumOk, int longEvents, int startingWithStart) {
            this.code = code;
            this.frames = Collections.unmodifiableList(frames);
            this.checksumOk = checksumOk;
            this.longEvents = longEvents;
            this.startingWithStart = startingWithStart;
        }

        public double checksumShare() {
            return frames.isEmpty() ? 0 : (double) checksumOk / frames.size();
        }

        /**
         * At least 80 % of the updates with 4 numbers or more start with 0xFD, at least 80 % of the frames have
         * the right checksum, and there are at least 20 frames.
         */
        public boolean isChannel() {
            return longEvents > 0 && (double) startingWithStart / longEvents >= MIN_SHARE
                    && frames.size() >= MIN_FRAMES && checksumShare() >= MIN_SHARE;
        }
    }

    /** Puts the frames together from the updates of a code, in the order they came. Never null. */
    public static Channel assemble(int code, List<Event> events) {
        List<Frame> frames = new ArrayList<>();
        int[] buf = new int[512];
        int n = 0;
        long bufT = 0;
        long lastT = 0;
        int okCount = 0;
        int longEvents = 0;
        int starting = 0;
        for (Event e : events) {
            int[] ints = e.ints;
            if (ints == null || ints.length == 0) {
                continue;
            }
            boolean bytes = true;
            for (int x : ints) {
                if (x < 0 || x > 255) {
                    bytes = false;
                    break;
                }
            }
            if (ints.length >= 4) {
                longEvents++;
                if (ints[0] == START) {
                    starting++;
                }
            }
            if (!bytes) {
                n = 0;
                continue;
            }
            if (ints[0] == START) {
                n = 0;
                bufT = e.t;
            } else if (n > 0 && e.t - lastT <= CONTINUATION_MS) {
                // the rest of a frame
            } else {
                n = 0;
                continue;
            }
            lastT = e.t;
            if (n + ints.length > buf.length) {
                buf = Arrays.copyOf(buf, Math.max(buf.length * 2, n + ints.length));
            }
            System.arraycopy(ints, 0, buf, n, ints.length);
            n += ints.length;

            int pos = 0;
            long frameT = bufT;
            while (n - pos >= 2) {
                if (buf[pos] != START) {
                    pos++;
                    continue;
                }
                int len = buf[pos + 1];
                if (len < 3) {
                    pos++;
                    continue;
                }
                if (n - pos < len + 1) {
                    break;
                }
                int cmd = buf[pos + 2];
                int[] data = Arrays.copyOfRange(buf, pos + 3, pos + len);
                int sum = len + cmd;
                for (int d : data) {
                    sum += d;
                }
                boolean ok = (sum & 0xFF) == buf[pos + len];
                if (ok) {
                    okCount++;
                }
                frames.add(new Frame(frameT, cmd, len, data, ok));
                frameT = e.t;
                pos += len + 1;
            }
            if (pos > 0) {
                System.arraycopy(buf, pos, buf, 0, n - pos);
                n -= pos;
                bufT = e.t;
            }
        }
        return new Channel(code, frames, okCount, longEvents, starting);
    }

    /** The codes that are channels of frames, from the updates of every code that had more than one number. */
    public static Map<Integer, Channel> detect(Map<Integer, List<Event>> eventsByCode) {
        Map<Integer, Channel> out = new TreeMap<>();
        if (eventsByCode == null) {
            return out;
        }
        for (Map.Entry<Integer, List<Event>> e : eventsByCode.entrySet()) {
            if (e.getValue() == null || e.getValue().size() < MIN_FRAMES / 2) {
                continue;
            }
            Channel c = assemble(e.getKey(), e.getValue());
            if (c.isChannel()) {
                out.put(e.getKey(), c);
            }
        }
        return out;
    }

    // ---------------------------------------------------------------------------------------------
    // The section of the file
    // ---------------------------------------------------------------------------------------------

    private static final class CodeSeries {
        final int code;
        final long[] t;
        final int[] v;

        CodeSeries(int code, long[] t, int[] v) {
            this.code = code;
            this.t = t;
            this.v = v;
        }

        /** The last value at or before the time, or Integer.MIN_VALUE if the code had none yet. */
        int valueAt(long time) {
            int lo = 0;
            int hi = t.length - 1;
            int found = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (t[mid] <= time) {
                    found = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return found < 0 ? Integer.MIN_VALUE : v[found];
        }
    }

    private static List<CodeSeries> codeSeries(Map<Integer, List<Sample>> series, Set<Integer> exclude) {
        List<CodeSeries> out = new ArrayList<>();
        if (series == null) {
            return out;
        }
        for (Map.Entry<Integer, List<Sample>> e : new TreeMap<>(series).entrySet()) {
            if (exclude.contains(e.getKey()) || e.getValue() == null || e.getValue().size() < 2) {
                continue;
            }
            List<Sample> list = new ArrayList<>(e.getValue());
            Collections.sort(list, new Comparator<Sample>() {
                @Override
                public int compare(Sample a, Sample b) {
                    return Long.compare(a.t, b.t);
                }
            });
            long[] t = new long[list.size()];
            int[] v = new int[list.size()];
            boolean changes = false;
            for (int i = 0; i < t.length; i++) {
                t[i] = list.get(i).t;
                v[i] = list.get(i).v;
                if (i > 0 && v[i] != v[i - 1]) {
                    changes = true;
                }
            }
            if (changes) {
                out.add(new CodeSeries(e.getKey(), t, v));
            }
        }
        return out;
    }

    /**
     * The lines of the section for every channel: the types of frames, and in each the bytes and the fields
     * that change. A field that equals an ordinary code (one that changed at least once) in at least 90 % of
     * the frames, the code taken 300 ms after the frame, is marked {@code = code N}.
     *
     * @param series the recorded values per code, with the channels of frames left out
     */
    public static List<String> report(Map<Integer, Channel> channels, Map<Integer, List<Sample>> series) {
        List<String> lines = new ArrayList<>();
        if (channels == null || channels.isEmpty()) {
            return lines;
        }
        List<CodeSeries> codes = codeSeries(series, channels.keySet());
        for (Channel c : channels.values()) {
            if (!lines.isEmpty()) {
                lines.add("");
            }
            lines.add(String.format(Locale.ROOT,
                    "Raw frames on code %d (RZC format: FD len cmd data checksum), %d frames, checksum ok %d%%",
                    c.code, c.frames.size(), Math.round(100.0 * c.checksumShare())));
            describe(c, codes, lines);
        }
        return lines;
    }

    private static final class FrameType implements Comparable<FrameType> {
        final int cmd;
        final int len;
        /** The sub-command, data[0], or -1 when the command has one length only. */
        final int sub;
        final List<Frame> frames = new ArrayList<>();

        FrameType(int cmd, int len, int sub) {
            this.cmd = cmd;
            this.len = len;
            this.sub = sub;
        }

        String name() {
            return sub >= 0 ? String.format(Locale.ROOT, "0x%02X/%02d", cmd, sub)
                    : String.format(Locale.ROOT, "0x%02X", cmd);
        }

        @Override
        public int compareTo(FrameType o) {
            if (frames.size() != o.frames.size()) {
                return o.frames.size() - frames.size();
            }
            if (cmd != o.cmd) {
                return cmd - o.cmd;
            }
            if (len != o.len) {
                return len - o.len;
            }
            return sub - o.sub;
        }
    }

    private static void describe(Channel c, List<CodeSeries> codes, List<String> lines) {
        Map<Integer, Set<Integer>> lengthsOfCmd = new TreeMap<>();
        for (Frame f : c.frames) {
            Set<Integer> s = lengthsOfCmd.get(f.cmd);
            if (s == null) {
                s = new HashSet<>();
                lengthsOfCmd.put(f.cmd, s);
            }
            s.add(f.len);
        }
        Map<String, FrameType> types = new LinkedHashMap<>();
        for (Frame f : c.frames) {
            boolean sub = lengthsOfCmd.get(f.cmd).size() > 1 && f.data.length > 0;
            int subCmd = sub ? f.data[0] : -1;
            String key = f.cmd + "/" + f.len + "/" + subCmd;
            FrameType t = types.get(key);
            if (t == null) {
                t = new FrameType(f.cmd, f.len, subCmd);
                types.put(key, t);
            }
            t.frames.add(f);
        }
        List<FrameType> sorted = new ArrayList<>(types.values());
        Collections.sort(sorted);
        int shown = 0;
        for (FrameType t : sorted) {
            if (shown >= MAX_TYPES) {
                break;
            }
            shown++;
            describeType(t, codes, lines);
        }
        if (sorted.size() > shown) {
            lines.add("... and " + (sorted.size() - shown) + " more frame types");
        }
    }

    private static void describeType(FrameType type, List<CodeSeries> codes, List<String> lines) {
        List<Frame> frames = type.frames;
        StringBuilder head = new StringBuilder(String.format(Locale.ROOT, "Frame %s (len %d): %d frames",
                type.name(), type.len, frames.size()));
        long span = frames.get(frames.size() - 1).t - frames.get(0).t;
        if (frames.size() > 1 && span >= 1000) {
            head.append(String.format(Locale.ROOT, ", %.1f/s", (frames.size() - 1) * 1000.0 / span));
        }
        lines.add(head.toString());

        int n = type.len - 3;
        int first = type.sub >= 0 ? 1 : 0;
        if (n <= first) {
            return;
        }
        int[][] col = new int[n][frames.size()];
        boolean[] varies = new boolean[n];
        int[] distinct = new int[n];
        int[] lo = new int[n];
        int[] hi = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[256];
            lo[i] = 255;
            hi[i] = 0;
            for (int k = 0; k < frames.size(); k++) {
                int b = frames.get(k).data[i];
                col[i][k] = b;
                if (!seen[b]) {
                    seen[b] = true;
                    distinct[i]++;
                }
                lo[i] = Math.min(lo[i], b);
                hi[i] = Math.max(hi[i], b);
            }
            varies[i] = distinct[i] > 1;
        }
        long[] times = new long[frames.size()];
        for (int k = 0; k < times.length; k++) {
            times[k] = frames.get(k).t;
        }

        List<String> out = new ArrayList<>();
        boolean[] covered = new boolean[n];

        // 1. the fields that equal a code: the narrowest first, then the others of the same code are redundant
        List<int[]> candidates = new ArrayList<>();      // {width, endianness (0 LE, 1 BE), start}
        for (int width = 2; width <= 3; width++) {
            for (int i = first; i + width <= n; i++) {
                boolean any = false;
                for (int j = i; j < i + width; j++) {
                    any |= varies[j];
                }
                if (!any) {
                    continue;
                }
                candidates.add(new int[]{width, 0, i});
                if (width == 2) {
                    candidates.add(new int[]{width, 1, i});
                }
            }
        }
        List<int[]> matchedFields = new ArrayList<>();      // {width, endianness, start, code, signed}
        Set<Integer> codesTaken = new HashSet<>();
        for (int[] cand : candidates) {
            int[] values = fieldValues(col, cand[0], cand[1], cand[2], false);
            int code = matchCode(values, times, codes, codesTaken);
            boolean signed = false;
            if (code < 0 && cand[0] == 2 && anyAbove(values, 0x8000)) {
                values = fieldValues(col, cand[0], cand[1], cand[2], true);
                code = matchCode(values, times, codes, codesTaken);
                signed = code >= 0;
            }
            if (code >= 0) {
                codesTaken.add(code);
                matchedFields.add(new int[]{cand[0], cand[1], cand[2], code, signed ? 1 : 0});
            }
        }
        for (int[] m : matchedFields) {
            int[] values = fieldValues(col, m[0], m[1], m[2], m[4] == 1);
            out.add(fieldLine(m[0], m[1], m[2], m[4] == 1, values) + " = code " + m[3]);
            for (int j = m[2]; j < m[2] + m[0]; j++) {
                covered[j] = true;
            }
        }

        // 2. the other fields whose bytes all change, and 3. the single bytes that change and are in no field
        for (int i = first; i < n; i++) {
            if (covered[i]) {
                continue;
            }
            int width = 1;
            if (i + 2 < n && varies[i] && varies[i + 1] && varies[i + 2] && !covered[i + 1] && !covered[i + 2]) {
                width = 3;
            } else if (i + 1 < n && varies[i] && varies[i + 1] && !covered[i + 1]) {
                width = 2;
            }
            if (width == 1) {
                if (varies[i]) {
                    out.add(String.format(Locale.ROOT, "  data[%d]: %d-%d (%d values)", i, lo[i], hi[i], distinct[i]));
                }
                continue;
            }
            boolean be = width == 2 && distinct[i] < distinct[i + 1];
            int[] raw = fieldValues(col, width, be ? 1 : 0, i, false);
            boolean signed = width == 2 && anyAbove(raw, 0x8000)
                    && allWithin(fieldValues(col, width, be ? 1 : 0, i, true), 4096);
            int[] values = signed ? fieldValues(col, width, be ? 1 : 0, i, true) : raw;
            out.add(fieldLine(width, be ? 1 : 0, i, signed, values));
            for (int j = i; j < i + width; j++) {
                covered[j] = true;
            }
            i += width - 1;
        }

        int limit = Math.min(out.size(), MAX_FIELDS_PER_TYPE);
        lines.addAll(out.subList(0, limit));
        if (out.size() > limit) {
            lines.add("  ... and " + (out.size() - limit) + " more fields");
        }
    }

    private static boolean anyAbove(int[] values, int limit) {
        for (int v : values) {
            if (v >= limit) {
                return true;
            }
        }
        return false;
    }

    private static boolean allWithin(int[] values, int limit) {
        for (int v : values) {
            if (Math.abs(v) > limit) {
                return false;
            }
        }
        return true;
    }

    /** The field of {@code width} bytes at {@code start} in every frame: little (0) or big (1) endian. */
    private static int[] fieldValues(int[][] col, int width, int endianness, int start, boolean signed16) {
        int frames = col[0].length;
        int[] out = new int[frames];
        for (int k = 0; k < frames; k++) {
            int v = 0;
            if (endianness == 0) {
                for (int j = width - 1; j >= 0; j--) {
                    v = (v << 8) | col[start + j][k];
                }
            } else {
                for (int j = 0; j < width; j++) {
                    v = (v << 8) | col[start + j][k];
                }
            }
            if (signed16 && width == 2 && v >= 0x8000) {
                v -= 0x10000;
            }
            out[k] = v;
        }
        return out;
    }

    private static String fieldLine(int width, int endianness, int start, boolean signed, int[] values) {
        StringBuilder sb = new StringBuilder("  data[").append(start).append("..").append(start + width - 1).append("] ");
        sb.append(endianness == 0 ? "LE" : "BE").append(width * 8);
        if (signed) {
            sb.append(" signed");
        }
        sb.append(": ");
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        boolean allOnes = false;
        for (int v : values) {
            if (width == 2 && !signed && v == 0xFFFF) {
                allOnes = true;
                continue;
            }
            lo = Math.min(lo, v);
            hi = Math.max(hi, v);
        }
        if (lo > hi) {
            sb.append("65535");
            return sb.toString();
        }
        if (signed) {
            sb.append(lo).append("..").append(hi);
        } else if (lo == hi) {
            sb.append(lo);
        } else {
            sb.append(lo).append('-').append(hi);
        }
        if (allOnes) {
            sb.append(", 65535");
        }
        return sb.toString();
    }

    /**
     * The code (not one of {@code taken}) whose value, 300 ms after each frame, equals the field in at least 90 %
     * of the frames it can be compared on (at least 10 of them); -1 if none. The fewest differences win.
     */
    private static int matchCode(int[] values, long[] times, List<CodeSeries> codes, Set<Integer> taken) {
        int best = -1;
        int bestBad = Integer.MAX_VALUE;
        for (CodeSeries cs : codes) {
            if (taken.contains(cs.code)) {
                continue;
            }
            int comparable = 0;
            for (long t : times) {
                if (t + CODE_FOLLOWS_MS >= cs.t[0]) {
                    comparable++;
                }
            }
            if (comparable < MIN_COMPARED) {
                continue;
            }
            int allowed = (int) Math.floor((1 - MATCH_SHARE) * comparable + 1e-9);
            int bad = 0;
            for (int k = 0; k < values.length && bad <= allowed; k++) {
                int v = cs.valueAt(times[k] + CODE_FOLLOWS_MS);
                if (v == Integer.MIN_VALUE) {
                    continue;
                }
                if (v != values[k]) {
                    bad++;
                }
            }
            if (bad <= allowed && bad < bestBad) {
                best = cs.code;
                bestBad = bad;
            }
        }
        return best;
    }
}
