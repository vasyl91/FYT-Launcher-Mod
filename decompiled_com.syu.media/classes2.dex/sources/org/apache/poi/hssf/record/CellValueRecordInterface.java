package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface CellValueRecordInterface {
    short getColumn();

    int getRow();

    short getXFIndex();

    void setColumn(short s);

    void setRow(int i);

    void setXFIndex(short s);
}
