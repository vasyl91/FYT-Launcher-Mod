package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Where the widgets that were placed freely are (D6): the {@link WidgetFrame} of each, by its appwidget id, in the
 * preferences file {@value #PREFS} ("left,top,right,bottom", fractions of the page's content area).
 *
 * <p>The rules: the file is read once, off the main thread at the start ({@link #load}, from
 * {@code LauncherApplication.warmUpOffMainThread}), and the frames are kept in memory, so that the layout of a page asks
 * a map and never the disk; a change is written with {@code apply()}, never {@code commit()}. A frame is kept when the
 * setting is turned off, and is used again when it is turned on; the database keeps the nearest cells of every widget
 * for the time it is off. A frame goes with its widget ({@link #remove}).
 */
final class WidgetFrames {

    static final String PREFS = "widget_frames";

    private static final Map<Integer, WidgetFrame> sFrames = new HashMap<>();
    private static boolean sLoaded;

    private WidgetFrames() {
    }

    /** Reads the file into memory, once. */
    static synchronized void load(Context context) {
        if (sLoaded) {
            return;
        }
        SharedPreferences prefs = context.getApplicationContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        for (Map.Entry<String, ?> entry : prefs.getAll().entrySet()) {
            try {
                WidgetFrame frame = WidgetFrame.parse(String.valueOf(entry.getValue()));
                if (frame != null) {
                    sFrames.put(Integer.parseInt(entry.getKey()), frame);
                }
            } catch (NumberFormatException notAnId) {
                // a stray key: no widget has it
            }
        }
        sLoaded = true;
    }

    /** The frame of a widget, or null when it has none (it is in cells). */
    static synchronized WidgetFrame get(Context context, int appWidgetId) {
        load(context);   // normally done by now, off the main thread
        return sFrames.get(appWidgetId);
    }

    /** Keeps the frame in memory only, for the moments while the user drags or resizes. */
    static synchronized void hold(int appWidgetId, WidgetFrame frame) {
        sFrames.put(appWidgetId, frame);
    }

    /** Keeps the frame in memory and writes it. */
    static synchronized void put(Context context, int appWidgetId, WidgetFrame frame) {
        load(context);
        sFrames.put(appWidgetId, frame);
        context.getApplicationContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit()
                .putString(String.valueOf(appWidgetId), frame.format()).apply();
    }

    /** The widget is gone: so is its frame. */
    static synchronized void remove(Context context, int appWidgetId) {
        load(context);
        if (sFrames.remove(appWidgetId) != null) {
            context.getApplicationContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit()
                    .remove(String.valueOf(appWidgetId)).apply();
        }
    }
}
