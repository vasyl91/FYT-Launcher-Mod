package com.fasterxml.aalto.impl;

import chip.FinalChip;
import org.codehaus.stax2.XMLStreamLocation2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class LocationImpl implements XMLStreamLocation2 {
    private static final LocationImpl EMPTY = new LocationImpl(FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, -1, -1, -1);
    protected final int _charOffset;
    protected final int _col;
    protected transient String _desc = null;
    protected final String _publicId;
    protected final int _row;
    protected final String _systemId;

    public XMLStreamLocation2 getContext() {
        return null;
    }

    public LocationImpl(String str, String str2, int i, int i2, int i3) {
        this._publicId = str;
        this._systemId = str2;
        this._charOffset = i < 0 ? Integer.MAX_VALUE : i;
        this._col = i3;
        this._row = i2;
    }

    public static LocationImpl fromZeroBased(String str, String str2, long j, int i, int i2) {
        return new LocationImpl(str, str2, (int) j, i + 1, i2 + 1);
    }

    public static LocationImpl getEmptyLocation() {
        return EMPTY;
    }

    public int getCharacterOffset() {
        return this._charOffset;
    }

    public int getColumnNumber() {
        return this._col;
    }

    public int getLineNumber() {
        return this._row;
    }

    public String getPublicId() {
        return this._publicId;
    }

    public String getSystemId() {
        return this._systemId;
    }

    public String toString() {
        if (this._desc == null) {
            StringBuffer stringBuffer = new StringBuffer(100);
            appendDesc(stringBuffer);
            this._desc = stringBuffer.toString();
        }
        return this._desc;
    }

    private void appendDesc(StringBuffer stringBuffer) {
        String str;
        if (this._systemId != null) {
            stringBuffer.append("[row,col,system-id]: ");
            str = this._systemId;
        } else if (this._publicId != null) {
            stringBuffer.append("[row,col,public-id]: ");
            str = this._publicId;
        } else {
            stringBuffer.append("[row,col {unknown-source}]: ");
            str = null;
        }
        stringBuffer.append('[');
        stringBuffer.append(this._row);
        stringBuffer.append(',');
        stringBuffer.append(this._col);
        if (str != null) {
            stringBuffer.append(',');
            stringBuffer.append('\"');
            stringBuffer.append(str);
            stringBuffer.append('\"');
        }
        stringBuffer.append(']');
    }
}
