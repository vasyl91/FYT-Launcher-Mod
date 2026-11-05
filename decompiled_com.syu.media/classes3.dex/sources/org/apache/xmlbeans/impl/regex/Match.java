package org.apache.xmlbeans.impl.regex;

import java.text.CharacterIterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Match implements Cloneable {
    int[] beginpos = null;
    int[] endpos = null;
    int nofgroups = 0;
    CharacterIterator ciSource = null;
    String strSource = null;
    char[] charSource = null;

    public synchronized Object clone() {
        Match match;
        match = new Match();
        int i = this.nofgroups;
        if (i > 0) {
            match.setNumberOfGroups(i);
            CharacterIterator characterIterator = this.ciSource;
            if (characterIterator != null) {
                match.setSource(characterIterator);
            }
            String str = this.strSource;
            if (str != null) {
                match.setSource(str);
            }
            for (int i2 = 0; i2 < this.nofgroups; i2++) {
                match.setBeginning(i2, getBeginning(i2));
                match.setEnd(i2, getEnd(i2));
            }
        }
        return match;
    }

    protected void setNumberOfGroups(int i) {
        int i2 = this.nofgroups;
        this.nofgroups = i;
        if (i2 <= 0 || i2 < i || i * 2 < i2) {
            this.beginpos = new int[i];
            this.endpos = new int[i];
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.beginpos[i3] = -1;
            this.endpos[i3] = -1;
        }
    }

    protected void setSource(CharacterIterator characterIterator) {
        this.ciSource = characterIterator;
        this.strSource = null;
        this.charSource = null;
    }

    protected void setSource(String str) {
        this.ciSource = null;
        this.strSource = str;
        this.charSource = null;
    }

    protected void setSource(char[] cArr) {
        this.ciSource = null;
        this.strSource = null;
        this.charSource = cArr;
    }

    protected void setBeginning(int i, int i2) {
        this.beginpos[i] = i2;
    }

    protected void setEnd(int i, int i2) {
        this.endpos[i] = i2;
    }

    public int getNumberOfGroups() {
        int i = this.nofgroups;
        if (i > 0) {
            return i;
        }
        throw new IllegalStateException("A result is not set.");
    }

    public int getBeginning(int i) {
        int[] iArr = this.beginpos;
        if (iArr == null) {
            throw new IllegalStateException("A result is not set.");
        }
        if (i < 0 || this.nofgroups <= i) {
            throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + i);
        }
        return iArr[i];
    }

    public int getEnd(int i) {
        int[] iArr = this.endpos;
        if (iArr == null) {
            throw new IllegalStateException("A result is not set.");
        }
        if (i < 0 || this.nofgroups <= i) {
            throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + i);
        }
        return iArr[i];
    }

    public String getCapturedText(int i) {
        int[] iArr = this.beginpos;
        if (iArr == null) {
            throw new IllegalStateException("match() has never been called.");
        }
        if (i < 0 || this.nofgroups <= i) {
            throw new IllegalArgumentException("The parameter must be less than " + this.nofgroups + ": " + i);
        }
        int i2 = iArr[i];
        int i3 = this.endpos[i];
        if (i2 < 0 || i3 < 0) {
            return null;
        }
        CharacterIterator characterIterator = this.ciSource;
        if (characterIterator != null) {
            return REUtil.substring(characterIterator, i2, i3);
        }
        String str = this.strSource;
        if (str != null) {
            return str.substring(i2, i3);
        }
        return new String(this.charSource, i2, i3 - i2);
    }
}
