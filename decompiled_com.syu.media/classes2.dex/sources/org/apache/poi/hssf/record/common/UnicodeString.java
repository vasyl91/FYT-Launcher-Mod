package org.apache.poi.hssf.record.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.cont.ContinuableRecordInput;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class UnicodeString implements Comparable<UnicodeString> {
    private short field_1_charCount;
    private byte field_2_optionflags;
    private String field_3_string;
    private List<FormatRun> field_4_format_runs;
    private ExtRst field_5_ext_rst;
    private static POILogger _logger = POILogFactory.getLogger((Class<?>) UnicodeString.class);
    private static final BitField highByte = BitFieldFactory.getInstance(1);
    private static final BitField extBit = BitFieldFactory.getInstance(4);
    private static final BitField richText = BitFieldFactory.getInstance(8);

    public static class FormatRun implements Comparable<FormatRun> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final short _character;
        short _fontIndex;

        public int hashCode() {
            return 42;
        }

        public FormatRun(short s, short s2) {
            this._character = s;
            this._fontIndex = s2;
        }

        public FormatRun(LittleEndianInput littleEndianInput) {
            this(littleEndianInput.readShort(), littleEndianInput.readShort());
        }

        public short getCharacterPos() {
            return this._character;
        }

        public short getFontIndex() {
            return this._fontIndex;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FormatRun)) {
                return false;
            }
            FormatRun formatRun = (FormatRun) obj;
            return this._character == formatRun._character && this._fontIndex == formatRun._fontIndex;
        }

        @Override // java.lang.Comparable
        public int compareTo(FormatRun formatRun) {
            short s = this._character;
            short s2 = formatRun._character;
            if (s == s2 && this._fontIndex == formatRun._fontIndex) {
                return 0;
            }
            return s == s2 ? this._fontIndex - formatRun._fontIndex : s - s2;
        }

        public String toString() {
            return "character=" + ((int) this._character) + ",fontIndex=" + ((int) this._fontIndex);
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._character);
            littleEndianOutput.writeShort(this._fontIndex);
        }
    }

    public static class ExtRst implements Comparable<ExtRst> {
        private byte[] extraData;
        private short formattingFontIndex;
        private short formattingOptions;
        private int numberOfRuns;
        private PhRun[] phRuns;
        private String phoneticText;
        private short reserved;

        private void populateEmpty() {
            this.reserved = (short) 1;
            this.phoneticText = "";
            this.phRuns = new PhRun[0];
            this.extraData = new byte[0];
        }

        protected ExtRst() {
            populateEmpty();
        }

        protected ExtRst(LittleEndianInput littleEndianInput, int i) {
            short s = littleEndianInput.readShort();
            this.reserved = s;
            if (s == -1) {
                populateEmpty();
                return;
            }
            int i2 = 0;
            if (s != 1) {
                UnicodeString._logger.log(5, "Warning - ExtRst has wrong magic marker, expecting 1 but found " + ((int) this.reserved) + " - ignoring");
                while (i2 < i - 2) {
                    littleEndianInput.readByte();
                    i2++;
                }
                populateEmpty();
                return;
            }
            short s2 = littleEndianInput.readShort();
            this.formattingFontIndex = littleEndianInput.readShort();
            this.formattingOptions = littleEndianInput.readShort();
            this.numberOfRuns = littleEndianInput.readUShort();
            short s3 = littleEndianInput.readShort();
            short s4 = littleEndianInput.readShort();
            if (s3 == 0 && s4 > 0) {
                s4 = 0;
            }
            if (s3 != s4) {
                throw new IllegalStateException("The two length fields of the Phonetic Text don't agree! " + ((int) s3) + " vs " + ((int) s4));
            }
            String unicodeLE = StringUtil.readUnicodeLE(littleEndianInput, s3);
            this.phoneticText = unicodeLE;
            int length = ((s2 - 4) - 6) - (unicodeLE.length() * 2);
            int i3 = length / 6;
            this.phRuns = new PhRun[i3];
            int i4 = 0;
            while (true) {
                PhRun[] phRunArr = this.phRuns;
                if (i4 >= phRunArr.length) {
                    break;
                }
                phRunArr[i4] = new PhRun(littleEndianInput);
                i4++;
            }
            int i5 = length - (i3 * 6);
            if (i5 < 0) {
                UnicodeString._logger.log(5, "Warning - ExtRst overran by " + (0 - i5) + " bytes");
                i5 = 0;
            }
            this.extraData = new byte[i5];
            while (true) {
                byte[] bArr = this.extraData;
                if (i2 >= bArr.length) {
                    return;
                }
                bArr[i2] = littleEndianInput.readByte();
                i2++;
            }
        }

        protected int getDataSize() {
            return (this.phoneticText.length() * 2) + 10 + (this.phRuns.length * 6) + this.extraData.length;
        }

        protected void serialize(ContinuableRecordOutput continuableRecordOutput) {
            int dataSize = getDataSize();
            continuableRecordOutput.writeContinueIfRequired(8);
            continuableRecordOutput.writeShort(this.reserved);
            continuableRecordOutput.writeShort(dataSize);
            continuableRecordOutput.writeShort(this.formattingFontIndex);
            continuableRecordOutput.writeShort(this.formattingOptions);
            continuableRecordOutput.writeContinueIfRequired(6);
            continuableRecordOutput.writeShort(this.numberOfRuns);
            continuableRecordOutput.writeShort(this.phoneticText.length());
            continuableRecordOutput.writeShort(this.phoneticText.length());
            continuableRecordOutput.writeContinueIfRequired(this.phoneticText.length() * 2);
            StringUtil.putUnicodeLE(this.phoneticText, continuableRecordOutput);
            int i = 0;
            while (true) {
                PhRun[] phRunArr = this.phRuns;
                if (i >= phRunArr.length) {
                    continuableRecordOutput.write(this.extraData);
                    return;
                } else {
                    phRunArr[i].serialize(continuableRecordOutput);
                    i++;
                }
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ExtRst) && compareTo((ExtRst) obj) == 0;
        }

        @Override // java.lang.Comparable
        public int compareTo(ExtRst extRst) {
            int i = this.reserved - extRst.reserved;
            if (i != 0) {
                return i;
            }
            int i2 = this.formattingFontIndex - extRst.formattingFontIndex;
            if (i2 != 0) {
                return i2;
            }
            int i3 = this.formattingOptions - extRst.formattingOptions;
            if (i3 != 0) {
                return i3;
            }
            int i4 = this.numberOfRuns - extRst.numberOfRuns;
            if (i4 != 0) {
                return i4;
            }
            int iCompareTo = this.phoneticText.compareTo(extRst.phoneticText);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int length = this.phRuns.length - extRst.phRuns.length;
            if (length != 0) {
                return length;
            }
            int i5 = 0;
            while (true) {
                PhRun[] phRunArr = this.phRuns;
                if (i5 >= phRunArr.length) {
                    return Arrays.hashCode(this.extraData) - Arrays.hashCode(extRst.extraData);
                }
                int i6 = phRunArr[i5].phoneticTextFirstCharacterOffset - extRst.phRuns[i5].phoneticTextFirstCharacterOffset;
                if (i6 != 0) {
                    return i6;
                }
                int i7 = this.phRuns[i5].realTextFirstCharacterOffset - extRst.phRuns[i5].realTextFirstCharacterOffset;
                if (i7 != 0) {
                    return i7;
                }
                int i8 = this.phRuns[i5].realTextLength - extRst.phRuns[i5].realTextLength;
                if (i8 != 0) {
                    return i8;
                }
                i5++;
            }
        }

        public int hashCode() {
            int iHashCode = (((((((this.reserved * 31) + this.formattingFontIndex) * 31) + this.formattingOptions) * 31) + this.numberOfRuns) * 31) + this.phoneticText.hashCode();
            PhRun[] phRunArr = this.phRuns;
            if (phRunArr != null) {
                for (PhRun phRun : phRunArr) {
                    iHashCode = (((((iHashCode * 31) + phRun.phoneticTextFirstCharacterOffset) * 31) + phRun.realTextFirstCharacterOffset) * 31) + phRun.realTextLength;
                }
            }
            return iHashCode;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtRst clone() {
            ExtRst extRst = new ExtRst();
            extRst.reserved = this.reserved;
            extRst.formattingFontIndex = this.formattingFontIndex;
            extRst.formattingOptions = this.formattingOptions;
            extRst.numberOfRuns = this.numberOfRuns;
            extRst.phoneticText = this.phoneticText;
            extRst.phRuns = new PhRun[this.phRuns.length];
            int i = 0;
            while (true) {
                PhRun[] phRunArr = extRst.phRuns;
                if (i >= phRunArr.length) {
                    return extRst;
                }
                phRunArr[i] = new PhRun(this.phRuns[i].phoneticTextFirstCharacterOffset, this.phRuns[i].realTextFirstCharacterOffset, this.phRuns[i].realTextLength);
                i++;
            }
        }

        public short getFormattingFontIndex() {
            return this.formattingFontIndex;
        }

        public short getFormattingOptions() {
            return this.formattingOptions;
        }

        public int getNumberOfRuns() {
            return this.numberOfRuns;
        }

        public String getPhoneticText() {
            return this.phoneticText;
        }

        public PhRun[] getPhRuns() {
            return this.phRuns;
        }
    }

    public static class PhRun {
        private int phoneticTextFirstCharacterOffset;
        private int realTextFirstCharacterOffset;
        private int realTextLength;

        public PhRun(int i, int i2, int i3) {
            this.phoneticTextFirstCharacterOffset = i;
            this.realTextFirstCharacterOffset = i2;
            this.realTextLength = i3;
        }

        private PhRun(LittleEndianInput littleEndianInput) {
            this.phoneticTextFirstCharacterOffset = littleEndianInput.readUShort();
            this.realTextFirstCharacterOffset = littleEndianInput.readUShort();
            this.realTextLength = littleEndianInput.readUShort();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void serialize(ContinuableRecordOutput continuableRecordOutput) {
            continuableRecordOutput.writeContinueIfRequired(6);
            continuableRecordOutput.writeShort(this.phoneticTextFirstCharacterOffset);
            continuableRecordOutput.writeShort(this.realTextFirstCharacterOffset);
            continuableRecordOutput.writeShort(this.realTextLength);
        }
    }

    private UnicodeString() {
    }

    public UnicodeString(String str) {
        setString(str);
    }

    public int hashCode() {
        String str = this.field_3_string;
        return this.field_1_charCount + (str != null ? str.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        int size;
        if (!(obj instanceof UnicodeString)) {
            return false;
        }
        UnicodeString unicodeString = (UnicodeString) obj;
        if (this.field_1_charCount != unicodeString.field_1_charCount || this.field_2_optionflags != unicodeString.field_2_optionflags || !this.field_3_string.equals(unicodeString.field_3_string)) {
            return false;
        }
        List<FormatRun> list = this.field_4_format_runs;
        if (list == null) {
            return unicodeString.field_4_format_runs == null;
        }
        if (unicodeString.field_4_format_runs == null || (size = list.size()) != unicodeString.field_4_format_runs.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.field_4_format_runs.get(i).equals(unicodeString.field_4_format_runs.get(i))) {
                return false;
            }
        }
        ExtRst extRst = this.field_5_ext_rst;
        if (extRst == null) {
            return unicodeString.field_5_ext_rst == null;
        }
        ExtRst extRst2 = unicodeString.field_5_ext_rst;
        if (extRst2 == null) {
            return false;
        }
        return extRst.equals(extRst2);
    }

    public UnicodeString(RecordInputStream recordInputStream) {
        this.field_1_charCount = recordInputStream.readShort();
        this.field_2_optionflags = recordInputStream.readByte();
        short s = isRichText() ? recordInputStream.readShort() : (short) 0;
        int i = isExtendedText() ? recordInputStream.readInt() : 0;
        boolean z = (this.field_2_optionflags & 1) == 0;
        int charCount = getCharCount();
        this.field_3_string = z ? recordInputStream.readCompressedUnicode(charCount) : recordInputStream.readUnicodeLEString(charCount);
        if (isRichText() && s > 0) {
            this.field_4_format_runs = new ArrayList(s);
            for (int i2 = 0; i2 < s; i2++) {
                this.field_4_format_runs.add(new FormatRun(recordInputStream));
            }
        }
        if (!isExtendedText() || i <= 0) {
            return;
        }
        ExtRst extRst = new ExtRst(new ContinuableRecordInput(recordInputStream), i);
        this.field_5_ext_rst = extRst;
        if (extRst.getDataSize() + 4 != i) {
            _logger.log(5, "ExtRst was supposed to be " + i + " bytes long, but seems to actually be " + (this.field_5_ext_rst.getDataSize() + 4));
        }
    }

    public int getCharCount() {
        short s = this.field_1_charCount;
        return s < 0 ? s + 65536 : s;
    }

    public short getCharCountShort() {
        return this.field_1_charCount;
    }

    public void setCharCount(short s) {
        this.field_1_charCount = s;
    }

    public byte getOptionFlags() {
        return this.field_2_optionflags;
    }

    public void setOptionFlags(byte b) {
        this.field_2_optionflags = b;
    }

    public String getString() {
        return this.field_3_string;
    }

    public void setString(String str) {
        this.field_3_string = str;
        setCharCount((short) str.length());
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) > 255) {
                z = true;
                break;
            }
        }
        if (z) {
            this.field_2_optionflags = highByte.setByte(this.field_2_optionflags);
        } else {
            this.field_2_optionflags = highByte.clearByte(this.field_2_optionflags);
        }
    }

    public int getFormatRunCount() {
        List<FormatRun> list = this.field_4_format_runs;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public FormatRun getFormatRun(int i) {
        List<FormatRun> list = this.field_4_format_runs;
        if (list != null && i >= 0 && i < list.size()) {
            return this.field_4_format_runs.get(i);
        }
        return null;
    }

    private int findFormatRunAt(int i) {
        int size = this.field_4_format_runs.size();
        for (int i2 = 0; i2 < size; i2++) {
            FormatRun formatRun = this.field_4_format_runs.get(i2);
            if (formatRun._character == i) {
                return i2;
            }
            if (formatRun._character > i) {
                return -1;
            }
        }
        return -1;
    }

    public void addFormatRun(FormatRun formatRun) {
        if (this.field_4_format_runs == null) {
            this.field_4_format_runs = new ArrayList();
        }
        int iFindFormatRunAt = findFormatRunAt(formatRun._character);
        if (iFindFormatRunAt != -1) {
            this.field_4_format_runs.remove(iFindFormatRunAt);
        }
        this.field_4_format_runs.add(formatRun);
        Collections.sort(this.field_4_format_runs);
        this.field_2_optionflags = richText.setByte(this.field_2_optionflags);
    }

    public Iterator<FormatRun> formatIterator() {
        List<FormatRun> list = this.field_4_format_runs;
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    public void removeFormatRun(FormatRun formatRun) {
        this.field_4_format_runs.remove(formatRun);
        if (this.field_4_format_runs.size() == 0) {
            this.field_4_format_runs = null;
            this.field_2_optionflags = richText.clearByte(this.field_2_optionflags);
        }
    }

    public void clearFormatting() {
        this.field_4_format_runs = null;
        this.field_2_optionflags = richText.clearByte(this.field_2_optionflags);
    }

    public ExtRst getExtendedRst() {
        return this.field_5_ext_rst;
    }

    void setExtendedRst(ExtRst extRst) {
        if (extRst != null) {
            this.field_2_optionflags = extBit.setByte(this.field_2_optionflags);
        } else {
            this.field_2_optionflags = extBit.clearByte(this.field_2_optionflags);
        }
        this.field_5_ext_rst = extRst;
    }

    public void swapFontUse(short s, short s2) {
        for (FormatRun formatRun : this.field_4_format_runs) {
            if (formatRun._fontIndex == s) {
                formatRun._fontIndex = s2;
            }
        }
    }

    public String toString() {
        return getString();
    }

    public String getDebugInfo() {
        StringBuffer stringBuffer = new StringBuffer("[UNICODESTRING]\n    .charcount       = ");
        stringBuffer.append(Integer.toHexString(getCharCount())).append("\n    .optionflags     = ");
        stringBuffer.append(Integer.toHexString(getOptionFlags())).append("\n    .string          = ");
        stringBuffer.append(getString()).append("\n");
        if (this.field_4_format_runs != null) {
            for (int i = 0; i < this.field_4_format_runs.size(); i++) {
                stringBuffer.append("      .format_run" + i + "          = ").append(this.field_4_format_runs.get(i)).append("\n");
            }
        }
        if (this.field_5_ext_rst != null) {
            stringBuffer.append("    .field_5_ext_rst          = \n");
            stringBuffer.append(this.field_5_ext_rst).append("\n");
        }
        stringBuffer.append("[/UNICODESTRING]\n");
        return stringBuffer.toString();
    }

    public void serialize(ContinuableRecordOutput continuableRecordOutput) {
        ExtRst extRst;
        ExtRst extRst2;
        List<FormatRun> list;
        int size = (!isRichText() || (list = this.field_4_format_runs) == null) ? 0 : list.size();
        int dataSize = (!isExtendedText() || (extRst2 = this.field_5_ext_rst) == null) ? 0 : extRst2.getDataSize() + 4;
        continuableRecordOutput.writeString(this.field_3_string, size, dataSize);
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (continuableRecordOutput.getAvailableSpace() < 4) {
                    continuableRecordOutput.writeContinue();
                }
                this.field_4_format_runs.get(i).serialize(continuableRecordOutput);
            }
        }
        if (dataSize <= 0 || (extRst = this.field_5_ext_rst) == null) {
            return;
        }
        extRst.serialize(continuableRecordOutput);
    }

    @Override // java.lang.Comparable
    public int compareTo(UnicodeString unicodeString) {
        int iCompareTo = getString().compareTo(unicodeString.getString());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        List<FormatRun> list = this.field_4_format_runs;
        if (list == null) {
            return unicodeString.field_4_format_runs == null ? 0 : 1;
        }
        if (unicodeString.field_4_format_runs == null) {
            return -1;
        }
        int size = list.size();
        if (size != unicodeString.field_4_format_runs.size()) {
            return size - unicodeString.field_4_format_runs.size();
        }
        for (int i = 0; i < size; i++) {
            int iCompareTo2 = this.field_4_format_runs.get(i).compareTo(unicodeString.field_4_format_runs.get(i));
            if (iCompareTo2 != 0) {
                return iCompareTo2;
            }
        }
        ExtRst extRst = this.field_5_ext_rst;
        if (extRst == null) {
            return unicodeString.field_5_ext_rst == null ? 0 : 1;
        }
        ExtRst extRst2 = unicodeString.field_5_ext_rst;
        if (extRst2 == null) {
            return -1;
        }
        return extRst.compareTo(extRst2);
    }

    private boolean isRichText() {
        return richText.isSet(getOptionFlags());
    }

    private boolean isExtendedText() {
        return extBit.isSet(getOptionFlags());
    }

    public Object clone() {
        UnicodeString unicodeString = new UnicodeString();
        unicodeString.field_1_charCount = this.field_1_charCount;
        unicodeString.field_2_optionflags = this.field_2_optionflags;
        unicodeString.field_3_string = this.field_3_string;
        if (this.field_4_format_runs != null) {
            unicodeString.field_4_format_runs = new ArrayList();
            for (FormatRun formatRun : this.field_4_format_runs) {
                unicodeString.field_4_format_runs.add(new FormatRun(formatRun._character, formatRun._fontIndex));
            }
        }
        ExtRst extRst = this.field_5_ext_rst;
        if (extRst != null) {
            unicodeString.field_5_ext_rst = extRst.clone();
        }
        return unicodeString;
    }
}
