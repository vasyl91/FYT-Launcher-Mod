package org.apache.poi.hssf.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class WorkbookRecordList {
    private List<Record> records = new ArrayList();
    private int protpos = 0;
    private int bspos = 0;
    private int tabpos = 0;
    private int fontpos = 0;
    private int xfpos = 0;
    private int backuppos = 0;
    private int namepos = 0;
    private int supbookpos = 0;
    private int externsheetPos = 0;
    private int palettepos = -1;

    public void setRecords(List<Record> list) {
        this.records = list;
    }

    public int size() {
        return this.records.size();
    }

    public Record get(int i) {
        return this.records.get(i);
    }

    public void add(int i, Record record) {
        this.records.add(i, record);
        updateRecordPos(i, true);
    }

    public List<Record> getRecords() {
        return this.records;
    }

    public void remove(Object obj) {
        Iterator<Record> it = this.records.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() == obj) {
                remove(i);
                return;
            }
            i++;
        }
    }

    public void remove(int i) {
        this.records.remove(i);
        updateRecordPos(i, false);
    }

    public int getProtpos() {
        return this.protpos;
    }

    public void setProtpos(int i) {
        this.protpos = i;
    }

    public int getBspos() {
        return this.bspos;
    }

    public void setBspos(int i) {
        this.bspos = i;
    }

    public int getTabpos() {
        return this.tabpos;
    }

    public void setTabpos(int i) {
        this.tabpos = i;
    }

    public int getFontpos() {
        return this.fontpos;
    }

    public void setFontpos(int i) {
        this.fontpos = i;
    }

    public int getXfpos() {
        return this.xfpos;
    }

    public void setXfpos(int i) {
        this.xfpos = i;
    }

    public int getBackuppos() {
        return this.backuppos;
    }

    public void setBackuppos(int i) {
        this.backuppos = i;
    }

    public int getPalettepos() {
        return this.palettepos;
    }

    public void setPalettepos(int i) {
        this.palettepos = i;
    }

    public int getNamepos() {
        return this.namepos;
    }

    public int getSupbookpos() {
        return this.supbookpos;
    }

    public void setNamepos(int i) {
        this.namepos = i;
    }

    public void setSupbookpos(int i) {
        this.supbookpos = i;
    }

    public int getExternsheetPos() {
        return this.externsheetPos;
    }

    public void setExternsheetPos(int i) {
        this.externsheetPos = i;
    }

    private void updateRecordPos(int i, boolean z) {
        int i2 = z ? 1 : -1;
        int protpos = getProtpos();
        if (protpos >= i) {
            setProtpos(protpos + i2);
        }
        int bspos = getBspos();
        if (bspos >= i) {
            setBspos(bspos + i2);
        }
        int tabpos = getTabpos();
        if (tabpos >= i) {
            setTabpos(tabpos + i2);
        }
        int fontpos = getFontpos();
        if (fontpos >= i) {
            setFontpos(fontpos + i2);
        }
        int xfpos = getXfpos();
        if (xfpos >= i) {
            setXfpos(xfpos + i2);
        }
        int backuppos = getBackuppos();
        if (backuppos >= i) {
            setBackuppos(backuppos + i2);
        }
        int namepos = getNamepos();
        if (namepos >= i) {
            setNamepos(namepos + i2);
        }
        int supbookpos = getSupbookpos();
        if (supbookpos >= i) {
            setSupbookpos(supbookpos + i2);
        }
        int palettepos = getPalettepos();
        if (palettepos != -1 && palettepos >= i) {
            setPalettepos(palettepos + i2);
        }
        int externsheetPos = getExternsheetPos();
        if (externsheetPos >= i) {
            setExternsheetPos(externsheetPos + i2);
        }
    }
}
