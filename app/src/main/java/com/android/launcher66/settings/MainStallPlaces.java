package com.android.launcher66.settings;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The distinct places a stalled main thread was seen at, for the report of LogcatWorker's
 * watcher. A report that said "3 different places in 3 samples" showed only the last stack, so
 * the other two places were lost; this names every one (up to MAX_PLACES) in a line of its own.
 * A place is the first frame of the stack that belongs to this app or to the car (a launcher,
 * com.syu. or com.fyt. class): that is the code that can be changed, while the top frames are
 * mostly the framework. Without such a frame it is the top frame. Pure, so it can be tested.
 */
final class MainStallPlaces {

    static final int MAX_PLACES = 5;

    private final Set<String> places = new LinkedHashSet<>();

    static String placeOf(StackTraceElement[] stack) {
        if (stack == null || stack.length == 0) return "(no stack)";
        for (StackTraceElement e : stack) {
            String c = e.getClassName();
            if (c.startsWith("com.android.launcher66") || c.startsWith("com.syu.")
                    || c.startsWith("com.fyt.")) {
                return e.toString();
            }
        }
        return stack[0].toString();
    }

    void add(StackTraceElement[] stack) {
        if (places.size() < MAX_PLACES) places.add(placeOf(stack));
    }

    void clear() {
        places.clear();
    }

    List<String> list() {
        return new ArrayList<>(places);
    }

    /** "a; b; c", empty when nothing was sampled. */
    String describe() {
        return String.join("; ", places);
    }
}
