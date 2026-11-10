package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface PrintSetup {
    public static final short A3_PAPERSIZE = 8;
    public static final short A4_EXTRA_PAPERSIZE = 53;
    public static final short A4_PAPERSIZE = 9;
    public static final short A4_PLUS_PAPERSIZE = 60;
    public static final short A4_ROTATED_PAPERSIZE = 77;
    public static final short A4_SMALL_PAPERSIZE = 10;
    public static final short A4_TRANSVERSE_PAPERSIZE = 55;
    public static final short A5_PAPERSIZE = 11;
    public static final short B4_PAPERSIZE = 12;
    public static final short B5_PAPERSIZE = 13;
    public static final short ELEVEN_BY_SEVENTEEN_PAPERSIZE = 17;
    public static final short ENVELOPE_10_PAPERSIZE = 20;
    public static final short ENVELOPE_9_PAPERSIZE = 19;
    public static final short ENVELOPE_C3_PAPERSIZE = 29;
    public static final short ENVELOPE_C4_PAPERSIZE = 30;
    public static final short ENVELOPE_C5_PAPERSIZE = 28;
    public static final short ENVELOPE_C6_PAPERSIZE = 31;
    public static final short ENVELOPE_CS_PAPERSIZE = 28;
    public static final short ENVELOPE_DL_PAPERSIZE = 27;
    public static final short ENVELOPE_MONARCH_PAPERSIZE = 37;
    public static final short EXECUTIVE_PAPERSIZE = 7;
    public static final short FOLIO8_PAPERSIZE = 14;
    public static final short LEDGER_PAPERSIZE = 4;
    public static final short LEGAL_PAPERSIZE = 5;
    public static final short LETTER_PAPERSIZE = 1;
    public static final short LETTER_ROTATED_PAPERSIZE = 75;
    public static final short LETTER_SMALL_PAGESIZE = 2;
    public static final short NOTE8_PAPERSIZE = 18;
    public static final short PRINTER_DEFAULT_PAPERSIZE = 0;
    public static final short QUARTO_PAPERSIZE = 15;
    public static final short STATEMENT_PAPERSIZE = 6;
    public static final short TABLOID_PAPERSIZE = 3;
    public static final short TEN_BY_FOURTEEN_PAPERSIZE = 16;

    short getCopies();

    boolean getDraft();

    short getFitHeight();

    short getFitWidth();

    double getFooterMargin();

    short getHResolution();

    double getHeaderMargin();

    boolean getLandscape();

    boolean getLeftToRight();

    boolean getNoColor();

    boolean getNoOrientation();

    boolean getNotes();

    short getPageStart();

    short getPaperSize();

    short getScale();

    boolean getUsePage();

    short getVResolution();

    boolean getValidSettings();

    void setCopies(short s);

    void setDraft(boolean z);

    void setFitHeight(short s);

    void setFitWidth(short s);

    void setFooterMargin(double d);

    void setHResolution(short s);

    void setHeaderMargin(double d);

    void setLandscape(boolean z);

    void setLeftToRight(boolean z);

    void setNoColor(boolean z);

    void setNoOrientation(boolean z);

    void setNotes(boolean z);

    void setPageStart(short s);

    void setPaperSize(short s);

    void setScale(short s);

    void setUsePage(boolean z);

    void setVResolution(short s);

    void setValidSettings(boolean z);
}
