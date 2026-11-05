package com.android.launcher66.settings;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * What a recording of the canbus codes (see {@link CanbusRecorder}) says: the series of each code,
 * the raw frames of a CAN box, the guesses of what the codes are and how the library's codes for the
 * car compare. The code reader writes the result to its file; the automatic check keeps the guesses.
 * Off the main thread: the library may have to be read.
 */
final class CanbusAnalysis {

    private static final String TAG = "CanbusAnalysis";

    /** The result of {@link #analyse}. */
    static final class Result {
        /** Code -> its updates that carried a number, frames left out. */
        final Map<Integer, List<CanbusCodeEstimator.Sample>> samples;
        /** The codes that carry the raw frames of a CAN box, by code. */
        final Map<Integer, CanbusFrames.Channel> channels;
        /** Null if the estimate failed. */
        final CanbusCodeEstimator.Result guesses;
        /** What the library says of the car against the recording; empty when there is nothing to say. */
        final String libraryLine;
        /** The pairs of fuel and range codes the library has for the car. */
        final List<CanbusLibrary.CarCodes> libraryPairs;
        final List<String> frameLines;
        final int withData;
        final int unchanged;
        final int onlyZero;

        Result(Map<Integer, List<CanbusCodeEstimator.Sample>> samples, Map<Integer, CanbusFrames.Channel> channels,
               CanbusCodeEstimator.Result guesses, String libraryLine, List<CanbusLibrary.CarCodes> libraryPairs,
               List<String> frameLines, int withData, int unchanged, int onlyZero) {
            this.samples = samples;
            this.channels = channels;
            this.guesses = guesses;
            this.libraryLine = libraryLine;
            this.libraryPairs = libraryPairs;
            this.frameLines = frameLines;
            this.withData = withData;
            this.unchanged = unchanged;
            this.onlyZero = onlyZero;
        }
    }

    private CanbusAnalysis() {
    }

    static Result analyse(Context context, SparseArray<ArrayList<CanbusRecorder.Event>> snapshot,
                          List<CanbusCodeEstimator.GpsFix> fixes, int carId) {
        // What the codes look like, for the guesses
        Map<Integer, List<CanbusCodeEstimator.Sample>> samples = new HashMap<>();
        int withData = 0;
        int unchanged = 0;
        int onlyZero = 0;
        for (int i = 0; i < snapshot.size(); i++) {
            int code = snapshot.keyAt(i);
            ArrayList<CanbusRecorder.Event> list = snapshot.valueAt(i);
            if (list.isEmpty()) {
                continue;
            }
            withData++;
            if (CanbusRecorder.isUnchanged(list)) {
                unchanged++;
            }
            if (CanbusRecorder.sentOnlyZero(list)) {
                onlyZero++;
            }
            List<CanbusCodeEstimator.Sample> s = new ArrayList<>();
            for (CanbusRecorder.Event e : list) {
                if (e.hasInt) {
                    s.add(new CanbusCodeEstimator.Sample(e.t, e.v));
                }
            }
            samples.put(code, s);
        }
        // The codes that carry the raw frames of a CAN box (found by what they hold, whatever their number) are
        // not values: their ints[0] is a frame header. They leave the guesses and get a section of their own.
        Map<Integer, CanbusFrames.Channel> channels = new TreeMap<>();
        try {
            Map<Integer, List<CanbusFrames.Event>> frameEvents = new HashMap<>();
            for (int i = 0; i < snapshot.size(); i++) {
                boolean payloads = false;
                for (CanbusRecorder.Event e : snapshot.valueAt(i)) {
                    payloads |= e.ints != null;
                }
                if (!payloads) {
                    continue;       // only codes with updates of several numbers can carry frames
                }
                // An update of one number is part of a frame too: often just its checksum
                List<CanbusFrames.Event> list = new ArrayList<>();
                for (CanbusRecorder.Event e : snapshot.valueAt(i)) {
                    if (e.ints != null) {
                        list.add(new CanbusFrames.Event(e.t, e.ints));
                    } else if (e.hasInt && e.extra.isEmpty()) {
                        list.add(new CanbusFrames.Event(e.t, new int[]{e.v}));
                    }
                }
                frameEvents.put(snapshot.keyAt(i), list);
            }
            channels.putAll(CanbusFrames.detect(frameEvents));
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not look for raw frames", e);
        }
        for (Integer code : channels.keySet()) {
            samples.remove(code);
        }
        CanbusCodeEstimator.Result guesses;
        try {
            guesses = CanbusCodeEstimator.estimate(samples, fixes);
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not guess the meaning of the codes", e);
            guesses = null;
        }
        // What the library says of this car, against what the recording shows
        String libraryLine = "";
        List<CanbusLibrary.CarCodes> pairs = new ArrayList<>();
        try {
            // The library may have a pair for each version of the canbus module: nothing to say if one of them
            // agrees with the recording, else what the first one does not
            pairs = CanbusLibrary.loadBlocking(context).codePairsFor(carId);
            for (CanbusLibrary.CarCodes libraryCodes : pairs) {
                String line = CanbusCodeEstimator.libraryCodesLine(libraryCodes.fuel, libraryCodes.range, samples,
                        guesses);
                if (line.isEmpty()) {
                    libraryLine = "";
                    break;
                }
                if (libraryLine.isEmpty()) {
                    libraryLine = line;
                }
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not compare the codes of the library", e);
        }
        List<String> frameLines = new ArrayList<>();
        try {
            frameLines = CanbusFrames.report(channels, samples);
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not describe the raw frames", e);
        }
        return new Result(samples, channels, guesses, libraryLine, pairs, frameLines, withData, unchanged, onlyZero);
    }

    /**
     * Keeps the best guesses of a recording for the Canbus codes window and for the service, over the ones of an
     * earlier reading, in the settings under {@link ReaderGuesses#key}. Returns what was kept (null: nothing found).
     * Off the main thread.
     */
    static ReaderGuesses saveGuesses(android.content.SharedPreferences prefs, int carId,
                                     CanbusCodeEstimator.Result guesses, long time) {
        if (carId == 0 || guesses == null) {
            return null;
        }
        ReaderGuesses found = ReaderGuesses.of(guesses, time);
        if (found.isEmpty()) {
            return null;
        }
        String key = ReaderGuesses.key(carId);
        ReaderGuesses older = ReaderGuesses.parse(prefs.getString(key, null));
        ReaderGuesses merged = found.over(older);
        prefs.edit().putString(key, merged.serialize()).apply();
        return merged;
    }
}
