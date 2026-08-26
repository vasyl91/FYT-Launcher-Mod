package com.android.recycler;

import org.litepal.crud.LitePalSupport;

public class LeftAppMultiple extends LitePalSupport {
    public String className;
    public int id;

    /**
     * DEAD COLUMN - kept only so the existing table schema is not altered.
     *
     * Every row is created with index = 0 (both the placeholders in
     * Launcher.refreshLeftCycle() and the real entries), so this value carries no
     * information. Ordering of the left bar comes from "id asc" alone. Never use it in a
     * where clause: it is not unique, and "index" is a SQLite reserved keyword that must
     * be quoted anyway.
     */
    public int index;

    public String name;
    public String packageName;

    /** LitePal needs a no-arg constructor to instantiate model objects. */
    public LeftAppMultiple() {
    }

    public LeftAppMultiple(int index, String name, String packageName, String className) {
        this.index = index;
        this.name = name;
        this.packageName = packageName;
        this.className = className;
    }

    /**
     * Primary key of this row - the only safe way to address a left-bar slot.
     * Prefer the mapped {@code id} column, fall back to LitePal's internal object id for
     * rows that were just saved.
     */
    public long rowId() {
        return id > 0 ? id : getBaseObjId();
    }
}
