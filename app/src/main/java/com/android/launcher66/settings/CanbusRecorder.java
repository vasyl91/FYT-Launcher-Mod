package com.android.launcher66.settings;

import android.location.Location;
import android.util.SparseArray;

import com.syu.ipc.IModuleCallback;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Records every update of every canbus code (0..1199) with the time it came, and the GPS speed beside
 * them: what the code reader and the automatic code check both work from. It registers for the codes
 * straight with com.syu.ms (not through DataCanbus.NOTIFY_EVENTS, which knows only the codes the
 * callback of the car registered, and for a car the launcher has no callback for only code 0).
 *
 * <p>Registering and unregistering are many binder calls: only from a background thread. The limits
 * are those of the reader: 5000 events per code and 200 000 in all; the rest is counted as dropped.
 */
final class CanbusRecorder {

    static final int BATCH_SIZE = 50;
    static final int CODES = 1200;
    static final int MAX_EVENTS_PER_CODE = 5000;
    static final int MAX_EVENTS = 200_000;

    /**
     * One update of a code: its time, ints[0] if there was one, and the rest of the payload as text. The
     * whole of ints too, when there is more than one number (the raw frames of a CAN box are decoded from it).
     */
    static final class Event {
        final long t;
        final boolean hasInt;
        final int v;
        final String extra;
        final int[] ints;

        Event(long t, boolean hasInt, int v, String extra, int[] ints) {
            this.t = t;
            this.hasInt = hasInt;
            this.v = v;
            this.extra = extra;
            this.ints = ints;
        }

        boolean sameAs(Event o) {
            return hasInt == o.hasInt && v == o.v && extra.equals(o.extra);
        }
    }

    /** A stable copy of the recording: from the moment it is taken nothing is added to it. */
    static final class Snapshot {
        final SparseArray<ArrayList<Event>> events;
        final int total;
        final int dropped;

        Snapshot(SparseArray<ArrayList<Event>> events, int total, int dropped) {
            this.events = events;
            this.total = total;
            this.dropped = dropped;
        }
    }

    private final Object lock = new Object();
    /** Code -> its events, in order; guarded by lock. */
    private final SparseArray<ArrayList<Event>> events = new SparseArray<>();
    private int totalEvents;
    private int droppedEvents;
    private volatile boolean recording;
    /** discard() came: a begin() that is still on its way must not start the recording. */
    private volatile boolean discarded;
    private volatile long startTime;
    private final Set<Integer> skipCodes;
    /** The GPS speed during the recording. */
    private final List<CanbusCodeEstimator.GpsFix> gpsFixes = Collections.synchronizedList(new ArrayList<>());

    final RecorderCallback callback = new RecorderCallback(this);

    /**
     * The binder stub com.syu.ms holds. The remote process keeps a proxy to it (a JNI global reference)
     * for minutes after unregister, until its own GC runs, and an anonymous class would keep the recorder
     * alive meanwhile, with up to 200 000 events and the GPS fixes. This one is static and reaches the
     * recorder only through a field that release() clears.
     */
    static final class RecorderCallback extends IModuleCallback.Stub {
        private volatile CanbusRecorder target;

        RecorderCallback(CanbusRecorder target) {
            this.target = target;
        }

        @Override
        public void update(int updateCode, int[] ints, float[] flts, String[] strs) {
            CanbusRecorder recorder = target;
            if (recorder != null) {
                recorder.record(updateCode, ints, flts, strs);
            }
        }
    }

    CanbusRecorder(Set<Integer> skipCodes) {
        this.skipCodes = skipCodes;
    }

    /** Recording starts: updates that come from now on are kept. */
    void begin(long now) {
        if (discarded) {
            return;
        }
        startTime = now;
        recording = true;
    }

    boolean isRecording() {
        return recording;
    }

    long startTime() {
        return startTime;
    }

    /** Registers for the codes, one by one; a binder call each. Background thread. */
    void registerCodes() {
        for (int code = 0; code < CODES && !discarded; code++) {
            if (!skipCodes.contains(code)) {
                DataCanbus.PROXY.register(callback, code, 1);
            }
        }
    }

    /** Unregisters from all the codes in batches, a pause between them. Background thread. */
    void unregisterCodesInBatches() {
        for (int start = 0; start < CODES; start += BATCH_SIZE) {
            for (int code = start; code < Math.min(start + BATCH_SIZE, CODES); code++) {
                DataCanbus.PROXY.unregister(callback, code);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    /** Stops recording and takes the recording. */
    Snapshot freeze() {
        SparseArray<ArrayList<Event>> copy = new SparseArray<>();
        int total;
        int dropped;
        synchronized (lock) {
            recording = false;
            for (int i = 0; i < events.size(); i++) {
                copy.put(events.keyAt(i), new ArrayList<>(events.valueAt(i)));
            }
            total = totalEvents;
            dropped = droppedEvents;
        }
        return new Snapshot(copy, total, dropped);
    }

    /** Stops recording without taking anything: the data is thrown away. */
    void discard() {
        discarded = true;
        synchronized (lock) {
            recording = false;
            events.clear();
            totalEvents = 0;
            droppedEvents = 0;
        }
        gpsFixes.clear();
    }

    /**
     * The codes are unregistered and the recording has been taken (freeze, fixes): the recorder lets go
     * of everything it holds. Call it after unregisterCodesInBatches, from the background thread; a
     * proxy that com.syu.ms still has to the callback then keeps only the empty stub.
     */
    void release() {
        callback.target = null;
        discard();
    }

    /** A GPS fix, with its speed, bearing and altitude; one without a speed is not kept. */
    void addFix(Location location) {
        if (location != null && location.hasSpeed()) {
            gpsFixes.add(new CanbusCodeEstimator.GpsFix(System.currentTimeMillis(), location.getSpeed() * 3.6f,
                    location.hasBearing() ? location.getBearing() : Float.NaN,
                    location.hasAltitude() ? location.getAltitude() : Double.NaN,
                    location.hasVerticalAccuracy() ? location.getVerticalAccuracyMeters() : Float.NaN));
        }
    }

    /** A copy of the fixes so far. */
    List<CanbusCodeEstimator.GpsFix> fixes() {
        synchronized (gpsFixes) {
            return new ArrayList<>(gpsFixes);
        }
    }

    /** Binder thread: every update of a registered code is recorded with the time it came. */
    private void record(int code, int[] ints, float[] flts, String[] strs) {
        if (!recording || code < 0 || code >= CODES) {
            return;
        }
        long now = System.currentTimeMillis();
        boolean hasInt = ints != null && ints.length > 0;
        Event event = new Event(now, hasInt, hasInt ? ints[0] : 0, describeExtra(ints, flts, strs),
                ints != null && ints.length > 1 ? ints.clone() : null);
        synchronized (lock) {
            if (!recording) {
                return;
            }
            if (totalEvents >= MAX_EVENTS) {
                droppedEvents++;
                return;
            }
            ArrayList<Event> list = events.get(code);
            if (list == null) {
                list = new ArrayList<>();
                events.put(code, list);
            }
            if (list.size() >= MAX_EVENTS_PER_CODE) {
                droppedEvents++;
                return;
            }
            list.add(event);
            totalEvents++;
        }
    }

    /** What the update carried besides ints[0]: {@code ints=68,1; flts=...; strs=...}, or an empty text. */
    static String describeExtra(int[] ints, float[] flts, String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (ints != null && ints.length > 1) {
            sb.append("ints=");
            for (int i = 0; i < ints.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(ints[i]);
            }
        }
        if (flts != null && flts.length > 0) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append("flts=");
            for (int i = 0; i < flts.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(flts[i]);
            }
        }
        if (strs != null && strs.length > 0) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append("strs=");
            for (int i = 0; i < strs.length; i++) {
                if (i > 0) {
                    sb.append('|');
                }
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    static boolean isUnchanged(List<Event> list) {
        Event first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (!first.sameAs(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /** Every update of the code was 0 with nothing else in it. An update without ints is not a 0. */
    static boolean sentOnlyZero(List<Event> list) {
        for (Event e : list) {
            if (!e.hasInt || e.v != 0 || !e.extra.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
