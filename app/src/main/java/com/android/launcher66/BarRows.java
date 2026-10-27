package com.android.launcher66;

import android.util.Log;

import com.android.recycler.AppMultiple;
import com.android.recycler.LeftAppMultiple;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

/**
 * The bars' rows (AppMultiple: the bottom bar, LeftAppMultiple: the left bar), read once and kept
 * in memory. The bars rebuild many times at a start, on the main thread, and each rebuild read
 * them from the database again; now the first read happens on a thread of its own at the start
 * (preload()), which also opens the database, and the main thread gets a copy. Whatever writes
 * either table calls invalidate() afterwards.
 */
public final class BarRows {

    private static final String TAG = "BarRows";

    private static final Object LOCK = new Object();
    private static List<AppMultiple> sBottom;
    private static List<LeftAppMultiple> sLeft;
    private static int sLeftLimit = -1;
    /** Bumped by invalidate(): a read begun before a write does not keep its stale rows. */
    private static int sGeneration;

    private BarRows() {
    }

    /** The bottom bar's rows by slot; a copy (null when the database cannot be read). */
    public static List<AppMultiple> bottom() {
        int generation;
        synchronized (LOCK) {
            if (sBottom != null) return new ArrayList<>(sBottom);
            generation = sGeneration;
        }
        // Not quoted: LitePal stores "index" (a SQLite keyword) as index_lpcolumn and rewrites the
        // name itself in an order clause (DBUtility.convertOrderByClauseToValidName). Quoted, it
        // found no column called index, SQLite read "index" as a string (log: "(28) double-quoted
        // string literal") and the bar came in rowid order. id breaks ties.
        List<AppMultiple> rows = LitePal.order("index asc, id asc").find(AppMultiple.class);
        synchronized (LOCK) {
            if (generation == sGeneration) sBottom = rows;
        }
        return rows == null ? null : new ArrayList<>(rows);
    }

    /** The left bar's first limit rows by id; a copy. */
    public static List<LeftAppMultiple> left(int limit) {
        int generation;
        synchronized (LOCK) {
            if (sLeft != null && sLeftLimit == limit) return new ArrayList<>(sLeft);
            generation = sGeneration;
        }
        List<LeftAppMultiple> rows = LitePal.order("id asc").limit(limit).find(LeftAppMultiple.class);
        synchronized (LOCK) {
            if (generation == sGeneration) {
                sLeft = rows;
                sLeftLimit = limit;
            }
        }
        return rows == null ? null : new ArrayList<>(rows);
    }

    /** Either table was written: the next read goes to the database. */
    public static void invalidate() {
        synchronized (LOCK) {
            sGeneration++;
            sBottom = null;
            sLeft = null;
        }
    }

    /** Reads both tables off the main thread, so the bars find them in memory. */
    static void preload(int leftLimit) {
        new Thread(() -> {
            try {
                bottom();
                left(leftLimit);
            } catch (Throwable t) {
                Log.w(TAG, "preload failed: " + t);
            }
        }, "BarRowsPreload").start();
    }
}
