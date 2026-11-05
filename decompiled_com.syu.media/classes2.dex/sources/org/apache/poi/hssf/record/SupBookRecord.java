package org.apache.poi.hssf.record;

import module.canbus.FinalCanbus;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SupBookRecord extends StandardRecord {
    protected static final char CH_ALT_STARTUP_DIR = 7;
    protected static final char CH_DOWN_DIR = 3;
    protected static final char CH_LIB_DIR = '\b';
    protected static final char CH_LONG_VOLUME = 5;
    protected static final char CH_SAME_VOLUME = 2;
    protected static final char CH_STARTUP_DIR = 6;
    protected static final char CH_UP_DIR = 4;
    protected static final char CH_VOLUME = 1;
    private static final short SMALL_RECORD_SIZE = 4;
    private static final short TAG_ADD_IN_FUNCTIONS = 14849;
    private static final short TAG_INTERNAL_REFERENCES = 1025;
    public static final short sid = 430;
    private boolean _isAddInFunctions;
    private short field_1_number_of_sheets;
    private String field_2_encoded_url;
    private String[] field_3_sheet_names;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) SupBookRecord.class);
    protected static final String PATH_SEPERATOR = System.getProperty("file.separator");

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public static SupBookRecord createInternalReferences(short s) {
        return new SupBookRecord(false, s);
    }

    public static SupBookRecord createAddInFunctions() {
        return new SupBookRecord(true, (short) 1);
    }

    public static SupBookRecord createExternalReferences(String str, String[] strArr) {
        return new SupBookRecord(str, strArr);
    }

    private SupBookRecord(boolean z, short s) {
        this.field_1_number_of_sheets = s;
        this.field_2_encoded_url = null;
        this.field_3_sheet_names = null;
        this._isAddInFunctions = z;
    }

    public SupBookRecord(String str, String[] strArr) {
        this.field_1_number_of_sheets = (short) strArr.length;
        this.field_2_encoded_url = str;
        this.field_3_sheet_names = strArr;
        this._isAddInFunctions = false;
    }

    public boolean isExternalReferences() {
        return this.field_3_sheet_names != null;
    }

    public boolean isInternalReferences() {
        return this.field_3_sheet_names == null && !this._isAddInFunctions;
    }

    public boolean isAddInFunctions() {
        return this.field_3_sheet_names == null && this._isAddInFunctions;
    }

    public SupBookRecord(RecordInputStream recordInputStream) {
        int iRemaining = recordInputStream.remaining();
        this.field_1_number_of_sheets = recordInputStream.readShort();
        if (iRemaining > 4) {
            this._isAddInFunctions = false;
            this.field_2_encoded_url = recordInputStream.readString();
            int i = this.field_1_number_of_sheets;
            String[] strArr = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                strArr[i2] = recordInputStream.readString();
            }
            this.field_3_sheet_names = strArr;
            return;
        }
        this.field_2_encoded_url = null;
        this.field_3_sheet_names = null;
        short s = recordInputStream.readShort();
        if (s == 1025) {
            this._isAddInFunctions = false;
        } else {
            if (s == 14849) {
                this._isAddInFunctions = true;
                if (this.field_1_number_of_sheets != 1) {
                    throw new RuntimeException("Expected 0x0001 for number of sheets field in 'Add-In Functions' but got (" + ((int) this.field_1_number_of_sheets) + ")");
                }
                return;
            }
            throw new RuntimeException("invalid EXTERNALBOOK code (" + Integer.toHexString(s) + ")");
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[SUPBOOK ");
        if (isExternalReferences()) {
            stringBuffer.append("External References]\n .url     = ");
            stringBuffer.append(this.field_2_encoded_url).append("\n .nSheets = ");
            stringBuffer.append((int) this.field_1_number_of_sheets).append("\n");
            for (String str : this.field_3_sheet_names) {
                stringBuffer.append("    .name = ").append(str).append("\n");
            }
            stringBuffer.append("[/SUPBOOK");
        } else if (this._isAddInFunctions) {
            stringBuffer.append("Add-In Functions");
        } else {
            stringBuffer.append("Internal References nSheets=");
            stringBuffer.append((int) this.field_1_number_of_sheets);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        if (!isExternalReferences()) {
            return 4;
        }
        int encodedSize = StringUtil.getEncodedSize(this.field_2_encoded_url) + 2;
        int i = 0;
        while (true) {
            String[] strArr = this.field_3_sheet_names;
            if (i >= strArr.length) {
                return encodedSize;
            }
            encodedSize += StringUtil.getEncodedSize(strArr[i]);
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_number_of_sheets);
        if (isExternalReferences()) {
            StringUtil.writeUnicodeString(littleEndianOutput, this.field_2_encoded_url);
            int i = 0;
            while (true) {
                String[] strArr = this.field_3_sheet_names;
                if (i >= strArr.length) {
                    return;
                }
                StringUtil.writeUnicodeString(littleEndianOutput, strArr[i]);
                i++;
            }
        } else {
            littleEndianOutput.writeShort(this._isAddInFunctions ? 14849 : FinalCanbus.U_CANBUS_SLAVECAR_TOUCH_CALI);
        }
    }

    public void setNumberOfSheets(short s) {
        this.field_1_number_of_sheets = s;
    }

    public short getNumberOfSheets() {
        return this.field_1_number_of_sheets;
    }

    public String getURL() {
        String str = this.field_2_encoded_url;
        char cCharAt = str.charAt(0);
        if (cCharAt == 0) {
            return str.substring(1);
        }
        if (cCharAt != 1) {
            return cCharAt != 2 ? str : str.substring(1);
        }
        return decodeFileName(str);
    }

    private static String decodeFileName(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case 1:
                    i++;
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 == '@') {
                        sb.append("\\\\");
                    } else {
                        sb.append(cCharAt2).append(":");
                    }
                    break;
                case 2:
                    sb.append(PATH_SEPERATOR);
                    break;
                case 3:
                    sb.append(PATH_SEPERATOR);
                    break;
                case 4:
                    sb.append("..").append(PATH_SEPERATOR);
                    break;
                case 5:
                    logger.log(5, "Found unexpected key: ChLongVolume - IGNORING");
                    break;
                case 6:
                case 7:
                case '\b':
                    logger.log(5, "EXCEL.EXE path unkown - using this directoy instead: .");
                    sb.append(".").append(PATH_SEPERATOR);
                    break;
                default:
                    sb.append(cCharAt);
                    break;
            }
            i++;
        }
        return sb.toString();
    }

    public String[] getSheetNames() {
        return (String[]) this.field_3_sheet_names.clone();
    }

    public void setURL(String str) {
        this.field_2_encoded_url = this.field_2_encoded_url.substring(0, 1) + str;
    }
}
