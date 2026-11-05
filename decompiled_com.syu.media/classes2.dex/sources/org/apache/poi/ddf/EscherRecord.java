package org.apache.poi.ddf;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class EscherRecord implements Cloneable {
    private static final BitField fInstance = BitFieldFactory.getInstance(65520);
    private static final BitField fVersion = BitFieldFactory.getInstance(15);
    private short _options;
    private short _recordId;

    public abstract int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory);

    @Internal
    protected abstract Object[][] getAttributeMap();

    public abstract String getRecordName();

    public abstract int getRecordSize();

    public abstract int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener);

    protected int fillFields(byte[] bArr, EscherRecordFactory escherRecordFactory) {
        return fillFields(bArr, 0, escherRecordFactory);
    }

    protected int readHeader(byte[] bArr, int i) {
        this._options = LittleEndian.getShort(bArr, i);
        this._recordId = LittleEndian.getShort(bArr, i + 2);
        return LittleEndian.getInt(bArr, i + 4);
    }

    protected static short readInstance(byte[] bArr, int i) {
        return fInstance.getShortValue(LittleEndian.getShort(bArr, i));
    }

    public boolean isContainerRecord() {
        return getVersion() == 15;
    }

    @Internal
    public short getOptions() {
        return this._options;
    }

    @Internal
    public void setOptions(short s) {
        setVersion(fVersion.getShortValue(s));
        setInstance(fInstance.getShortValue(s));
        this._options = s;
    }

    public byte[] serialize() {
        byte[] bArr = new byte[getRecordSize()];
        serialize(0, bArr);
        return bArr;
    }

    public int serialize(int i, byte[] bArr) {
        return serialize(i, bArr, new NullEscherSerializationListener());
    }

    public short getRecordId() {
        return this._recordId;
    }

    public void setRecordId(short s) {
        this._recordId = s;
    }

    public List<EscherRecord> getChildRecords() {
        return Collections.emptyList();
    }

    public void setChildRecords(List<EscherRecord> list) {
        throw new UnsupportedOperationException("This record does not support child records.");
    }

    @Override // 
    public EscherRecord clone() throws CloneNotSupportedException {
        return (EscherRecord) super.clone();
    }

    public EscherRecord getChild(int i) {
        return getChildRecords().get(i);
    }

    public void display(PrintWriter printWriter, int i) {
        for (int i2 = 0; i2 < i * 4; i2++) {
            printWriter.print(' ');
        }
        printWriter.println(getRecordName());
    }

    public short getInstance() {
        return fInstance.getShortValue(this._options);
    }

    public void setInstance(short s) {
        this._options = fInstance.setShortValue(this._options, s);
    }

    public short getVersion() {
        return fVersion.getShortValue(this._options);
    }

    public void setVersion(short s) {
        this._options = fVersion.setShortValue(this._options, s);
    }

    public String toXml() {
        return toXml("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    public final String toXml(String str) {
        String property = System.getProperty("line.separator");
        String simpleName = getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(1000);
        String str2 = "<";
        sb.append(str).append("<").append(simpleName).append(" recordId=\"0x").append(HexDump.toHex(getRecordId())).append("\" version=\"0x").append(HexDump.toHex(getVersion())).append("\" instance=\"0x").append(HexDump.toHex(getInstance())).append("\" options=\"0x").append(HexDump.toHex(getOptions())).append("\" recordSize=\"").append(getRecordSize());
        Object[][] attributeMap = getAttributeMap();
        if (attributeMap == null || attributeMap.length == 0) {
            sb.append("\" />").append(property);
        } else {
            sb.append("\">").append(property);
            String str3 = str + "   ";
            int length = attributeMap.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                Object[] objArr = attributeMap[i2];
                String strCapitalizeAndTrim = capitalizeAndTrim((String) objArr[i]);
                int i3 = i;
                int i4 = i3;
                ?? AppendValue = i4;
                while (i3 < objArr.length) {
                    Object obj = objArr[i3 + 1];
                    if (obj == null) {
                        str2 = str2;
                    } else {
                        if (i4 == 0) {
                            sb.append(str3).append(str2).append(strCapitalizeAndTrim).append(">");
                        }
                        String strCapitalizeAndTrim2 = capitalizeAndTrim((String) objArr[i3 + 0]);
                        if (i3 > 0) {
                            sb.append(property).append(str3).append("  <").append(strCapitalizeAndTrim2).append(">");
                        }
                        AppendValue = appendValue(sb, obj, true, str3);
                        if (i3 > 0) {
                            sb.append(property).append(str3).append("  </").append(strCapitalizeAndTrim2).append(">");
                        }
                        i4 = 1;
                    }
                    i3 += 2;
                    attributeMap = attributeMap;
                    str2 = str2;
                    AppendValue = AppendValue;
                }
                Object[][] objArr2 = attributeMap;
                String str4 = str2;
                if (i4 != 0) {
                    if (AppendValue != 0) {
                        sb.append(property).append(str3);
                    }
                    sb.append("</").append(strCapitalizeAndTrim).append(">").append(property);
                }
                i2++;
                attributeMap = objArr2;
                str2 = str4;
                i = 0;
            }
            sb.append(str).append("</").append(simpleName).append(">");
        }
        return sb.toString();
    }

    public final String toString() {
        String property = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder(1000);
        sb.append(getClass().getName()).append(" (").append(getRecordName()).append("):").append(property).append("  RecordId: 0x").append(HexDump.toHex(getRecordId())).append(property).append("  Version: 0x").append(HexDump.toHex(getVersion())).append(property).append("  Instance: 0x").append(HexDump.toHex(getInstance())).append(property).append("  Options: 0x").append(HexDump.toHex(getOptions())).append(property).append("  Record Size: ").append(getRecordSize());
        Object[][] attributeMap = getAttributeMap();
        if (attributeMap != null && attributeMap.length > 0) {
            for (Object[] objArr : attributeMap) {
                for (int i = 0; i < objArr.length; i += 2) {
                    Object obj = objArr[i + 1];
                    if (obj != null) {
                        sb.append(property).append("  ").append((String) objArr[i + 0]).append(": ");
                        appendValue(sb, obj, false, "  ");
                    }
                }
            }
        }
        return sb.toString();
    }

    private static boolean appendValue(StringBuilder sb, Object obj, boolean z, String str) {
        String property = System.getProperty("line.separator");
        if (obj instanceof String) {
            if (z) {
                escapeXML((String) obj, sb);
            } else {
                sb.append((String) obj);
            }
        } else if (obj instanceof Byte) {
            sb.append("0x").append(HexDump.toHex(((Byte) obj).byteValue()));
        } else if (obj instanceof Short) {
            sb.append("0x").append(HexDump.toHex(((Short) obj).shortValue()));
        } else if (obj instanceof Integer) {
            sb.append("0x").append(HexDump.toHex(((Integer) obj).intValue()));
        } else if (obj instanceof byte[]) {
            sb.append(property).append(HexDump.toHex((byte[]) obj, 32).replaceAll("(?m)^", str + "   "));
        } else if (obj instanceof Boolean) {
            sb.append(((Boolean) obj).booleanValue());
        } else {
            if (obj instanceof EscherRecord) {
                EscherRecord escherRecord = (EscherRecord) obj;
                if (z) {
                    sb.append(property).append(escherRecord.toXml(str + "    "));
                } else {
                    sb.append(escherRecord.toString().replaceAll("(?m)^", str));
                }
            } else if (obj instanceof EscherProperty) {
                EscherProperty escherProperty = (EscherProperty) obj;
                if (z) {
                    sb.append(property).append(escherProperty.toXml(str + "  "));
                } else {
                    sb.append(escherProperty.toString().replaceAll("(?m)^", str));
                }
            } else {
                throw new IllegalArgumentException("unknown attribute type " + obj.getClass().getSimpleName());
            }
            return true;
        }
        return false;
    }

    private static String capitalizeAndTrim(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        boolean z = true;
        for (char titleCase : str.toCharArray()) {
            if (Character.isLetterOrDigit(titleCase)) {
                if (z) {
                    if (!Character.isLetter(titleCase)) {
                        sb.append('_');
                    } else {
                        titleCase = Character.toTitleCase(titleCase);
                    }
                    z = false;
                }
                sb.append(titleCase);
            } else {
                z = true;
            }
        }
        return sb.toString();
    }

    private static void escapeXML(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        for (char c : str.toCharArray()) {
            if (c > 127 || c == '\"' || c == '<' || c == '>' || c == '&') {
                sb.append("&#");
                sb.append((int) c);
                sb.append(';');
            } else {
                sb.append(c);
            }
        }
    }
}
