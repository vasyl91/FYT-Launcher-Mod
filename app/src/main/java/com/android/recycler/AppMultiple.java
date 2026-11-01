package com.android.recycler;

import org.litepal.crud.LitePalSupport;

public class AppMultiple extends LitePalSupport {
    public String className;
    public int id;
    public int index;
    public String name;
    public String packageName;

    /** LitePal needs a no-arg constructor to instantiate model objects. */
    public AppMultiple() {
    }

    public AppMultiple(int index, String name, String packageName, String className) {
        this.index = index;
        this.name = name;
        this.packageName = packageName;
        this.className = className;
    }

    /**
     * Primary key of this row. Prefer the mapped {@code id} column; fall back to
     * LitePal's internal object id for rows that were just saved.
     *
     * This is the ONLY safe way to address a bottom-bar slot: {@link #index} is not
     * guaranteed to be unique or contiguous. It is also a SQLite reserved keyword: LitePal
     * stores it as the column index_lpcolumn and rewrites "index" itself in the where, order
     * and select clauses it builds, so write it unquoted there (quoted, it matches no column);
     * only raw SQL has to say index_lpcolumn.
     */
    public long rowId() {
        return id > 0 ? id : getBaseObjId();
    }
}
