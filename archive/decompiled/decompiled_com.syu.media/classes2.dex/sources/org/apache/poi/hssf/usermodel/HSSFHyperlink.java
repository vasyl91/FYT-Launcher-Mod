package org.apache.poi.hssf.usermodel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HSSFHyperlink implements Hyperlink {
    protected final HyperlinkType link_type;
    protected final HyperlinkRecord record;

    @Internal(since = "3.15 beta 3")
    protected HSSFHyperlink(HyperlinkType hyperlinkType) {
        this.link_type = hyperlinkType;
        HyperlinkRecord hyperlinkRecord = new HyperlinkRecord();
        this.record = hyperlinkRecord;
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[hyperlinkType.ordinal()];
        if (i == 1 || i == 2) {
            hyperlinkRecord.newUrlLink();
        } else if (i == 3) {
            hyperlinkRecord.newFileLink();
        } else {
            if (i == 4) {
                hyperlinkRecord.newDocumentLink();
                return;
            }
            throw new IllegalArgumentException("Invalid type: " + hyperlinkType);
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFHyperlink$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType;

        static {
            int[] iArr = new int[HyperlinkType.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType = iArr;
            try {
                iArr[HyperlinkType.URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$HyperlinkType[HyperlinkType.DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected HSSFHyperlink(HyperlinkRecord hyperlinkRecord) {
        this.record = hyperlinkRecord;
        this.link_type = getType(hyperlinkRecord);
    }

    private static HyperlinkType getType(HyperlinkRecord hyperlinkRecord) {
        if (hyperlinkRecord.isFileLink()) {
            return HyperlinkType.FILE;
        }
        if (hyperlinkRecord.isDocumentLink()) {
            return HyperlinkType.DOCUMENT;
        }
        if (hyperlinkRecord.getAddress() != null && hyperlinkRecord.getAddress().startsWith("mailto:")) {
            return HyperlinkType.EMAIL;
        }
        return HyperlinkType.URL;
    }

    protected HSSFHyperlink(Hyperlink hyperlink) {
        if (hyperlink instanceof HSSFHyperlink) {
            HyperlinkRecord hyperlinkRecordClone = ((HSSFHyperlink) hyperlink).record.clone();
            this.record = hyperlinkRecordClone;
            this.link_type = getType(hyperlinkRecordClone);
        } else {
            this.link_type = hyperlink.getTypeEnum();
            this.record = new HyperlinkRecord();
            setFirstRow(hyperlink.getFirstRow());
            setFirstColumn(hyperlink.getFirstColumn());
            setLastRow(hyperlink.getLastRow());
            setLastColumn(hyperlink.getLastColumn());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstRow() {
        return this.record.getFirstRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstRow(int i) {
        this.record.setFirstRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastRow() {
        return this.record.getLastRow();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastRow(int i) {
        this.record.setLastRow(i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getFirstColumn() {
        return this.record.getFirstColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setFirstColumn(int i) {
        this.record.setFirstColumn((short) i);
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public int getLastColumn() {
        return this.record.getLastColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Hyperlink
    public void setLastColumn(int i) {
        this.record.setLastColumn((short) i);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getAddress() {
        return this.record.getAddress();
    }

    public String getTextMark() {
        return this.record.getTextMark();
    }

    public void setTextMark(String str) {
        this.record.setTextMark(str);
    }

    public String getShortFilename() {
        return this.record.getShortFilename();
    }

    public void setShortFilename(String str) {
        this.record.setShortFilename(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setAddress(String str) {
        this.record.setAddress(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public String getLabel() {
        return this.record.getLabel();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public void setLabel(String str) {
        this.record.setLabel(str);
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public int getType() {
        return this.link_type.getCode();
    }

    @Override // org.apache.poi.common.usermodel.Hyperlink
    public HyperlinkType getTypeEnum() {
        return this.link_type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HSSFHyperlink) && this.record == ((HSSFHyperlink) obj).record;
    }

    public int hashCode() {
        return this.record.hashCode();
    }
}
