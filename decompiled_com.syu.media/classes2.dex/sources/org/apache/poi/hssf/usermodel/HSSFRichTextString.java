package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HSSFRichTextString implements Comparable<HSSFRichTextString>, RichTextString {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final short NO_FONT = 0;
    private InternalWorkbook _book;
    private LabelSSTRecord _record;
    private UnicodeString _string;

    public int hashCode() {
        return 42;
    }

    public HSSFRichTextString() {
        this("");
    }

    public HSSFRichTextString(String str) {
        if (str == null) {
            this._string = new UnicodeString("");
        } else {
            this._string = new UnicodeString(str);
        }
    }

    HSSFRichTextString(InternalWorkbook internalWorkbook, LabelSSTRecord labelSSTRecord) {
        setWorkbookReferences(internalWorkbook, labelSSTRecord);
        this._string = internalWorkbook.getSSTString(labelSSTRecord.getSSTIndex());
    }

    void setWorkbookReferences(InternalWorkbook internalWorkbook, LabelSSTRecord labelSSTRecord) {
        this._book = internalWorkbook;
        this._record = labelSSTRecord;
    }

    private UnicodeString cloneStringIfRequired() {
        if (this._book == null) {
            return this._string;
        }
        return (UnicodeString) this._string.clone();
    }

    private void addToSSTIfRequired() {
        InternalWorkbook internalWorkbook = this._book;
        if (internalWorkbook != null) {
            int iAddSSTString = internalWorkbook.addSSTString(this._string);
            this._record.setSSTIndex(iAddSSTString);
            this._string = this._book.getSSTString(iAddSSTString);
        }
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i, int i2, short s) {
        if (i > i2) {
            throw new IllegalArgumentException("Start index must be less than end index.");
        }
        if (i < 0 || i2 > length()) {
            throw new IllegalArgumentException("Start and end index not in range.");
        }
        if (i == i2) {
            return;
        }
        short fontAtIndex = i2 != length() ? getFontAtIndex(i2) : (short) 0;
        UnicodeString unicodeStringCloneStringIfRequired = cloneStringIfRequired();
        this._string = unicodeStringCloneStringIfRequired;
        Iterator<UnicodeString.FormatRun> iterator = unicodeStringCloneStringIfRequired.formatIterator();
        if (iterator != null) {
            while (iterator.hasNext()) {
                UnicodeString.FormatRun next = iterator.next();
                if (next.getCharacterPos() >= i && next.getCharacterPos() < i2) {
                    iterator.remove();
                }
            }
        }
        this._string.addFormatRun(new UnicodeString.FormatRun((short) i, s));
        if (i2 != length()) {
            this._string.addFormatRun(new UnicodeString.FormatRun((short) i2, fontAtIndex));
        }
        addToSSTIfRequired();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i, int i2, Font font) {
        applyFont(i, i2, ((HSSFFont) font).getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(Font font) {
        applyFont(0, this._string.getCharCount(), font);
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void clearFormatting() {
        UnicodeString unicodeStringCloneStringIfRequired = cloneStringIfRequired();
        this._string = unicodeStringCloneStringIfRequired;
        unicodeStringCloneStringIfRequired.clearFormatting();
        addToSSTIfRequired();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public String getString() {
        return this._string.getString();
    }

    UnicodeString getUnicodeString() {
        return cloneStringIfRequired();
    }

    UnicodeString getRawUnicodeString() {
        return this._string;
    }

    void setUnicodeString(UnicodeString unicodeString) {
        this._string = unicodeString;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int length() {
        return this._string.getCharCount();
    }

    public short getFontAtIndex(int i) {
        int formatRunCount = this._string.getFormatRunCount();
        UnicodeString.FormatRun formatRun = null;
        int i2 = 0;
        while (i2 < formatRunCount) {
            UnicodeString.FormatRun formatRun2 = this._string.getFormatRun(i2);
            if (formatRun2.getCharacterPos() > i) {
                break;
            }
            i2++;
            formatRun = formatRun2;
        }
        if (formatRun == null) {
            return (short) 0;
        }
        return formatRun.getFontIndex();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int numFormattingRuns() {
        return this._string.getFormatRunCount();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int getIndexOfFormattingRun(int i) {
        return this._string.getFormatRun(i).getCharacterPos();
    }

    public short getFontOfFormattingRun(int i) {
        return this._string.getFormatRun(i).getFontIndex();
    }

    @Override // java.lang.Comparable
    public int compareTo(HSSFRichTextString hSSFRichTextString) {
        return this._string.compareTo(hSSFRichTextString._string);
    }

    public boolean equals(Object obj) {
        if (obj instanceof HSSFRichTextString) {
            return this._string.equals(((HSSFRichTextString) obj)._string);
        }
        return false;
    }

    public String toString() {
        return this._string.toString();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(short s) {
        applyFont(0, this._string.getCharCount(), s);
    }
}
