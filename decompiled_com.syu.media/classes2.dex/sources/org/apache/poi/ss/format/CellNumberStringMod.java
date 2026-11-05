package org.apache.poi.ss.format;

import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Internal
public class CellNumberStringMod implements Comparable<CellNumberStringMod> {
    public static final int AFTER = 2;
    public static final int BEFORE = 1;
    public static final int REPLACE = 3;
    private CellNumberFormatter.Special end;
    private boolean endInclusive;
    private final int op;
    private final CellNumberFormatter.Special special;
    private boolean startInclusive;
    private CharSequence toAdd;

    public CellNumberStringMod(CellNumberFormatter.Special special, CharSequence charSequence, int i) {
        this.special = special;
        this.toAdd = charSequence;
        this.op = i;
    }

    public CellNumberStringMod(CellNumberFormatter.Special special, boolean z, CellNumberFormatter.Special special2, boolean z2, char c) {
        this(special, z, special2, z2);
        this.toAdd = c + "";
    }

    public CellNumberStringMod(CellNumberFormatter.Special special, boolean z, CellNumberFormatter.Special special2, boolean z2) {
        this.special = special;
        this.startInclusive = z;
        this.end = special2;
        this.endInclusive = z2;
        this.op = 3;
        this.toAdd = "";
    }

    @Override // java.lang.Comparable
    public int compareTo(CellNumberStringMod cellNumberStringMod) {
        int i = this.special.pos - cellNumberStringMod.special.pos;
        return i != 0 ? i : this.op - cellNumberStringMod.op;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CellNumberStringMod) && compareTo((CellNumberStringMod) obj) == 0;
    }

    public int hashCode() {
        return this.special.hashCode() + this.op;
    }

    public CellNumberFormatter.Special getSpecial() {
        return this.special;
    }

    public int getOp() {
        return this.op;
    }

    public CharSequence getToAdd() {
        return this.toAdd;
    }

    public CellNumberFormatter.Special getEnd() {
        return this.end;
    }

    public boolean isStartInclusive() {
        return this.startInclusive;
    }

    public boolean isEndInclusive() {
        return this.endInclusive;
    }
}
