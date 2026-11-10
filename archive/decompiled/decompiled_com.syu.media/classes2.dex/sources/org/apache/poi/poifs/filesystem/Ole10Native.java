package org.apache.poi.poifs.filesystem;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianOutputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Ole10Native {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String ISO1 = "ISO-8859-1";
    public static final String OLE10_NATIVE = "\u0001Ole10Native";
    private String command;
    private byte[] dataBuffer;
    private String fileName;
    private short flags1;
    private short flags2;
    private short flags3;
    private String label;
    private EncodingMode mode;
    private int totalSize;
    private short unknown1;

    private enum EncodingMode {
        parsed,
        unparsed,
        compact
    }

    public static Ole10Native createFromEmbeddedOleObject(POIFSFileSystem pOIFSFileSystem) throws Ole10NativeException, IOException {
        return createFromEmbeddedOleObject(pOIFSFileSystem.getRoot());
    }

    public static Ole10Native createFromEmbeddedOleObject(DirectoryNode directoryNode) throws Ole10NativeException, IOException {
        DocumentEntry documentEntry = (DocumentEntry) directoryNode.getEntry(OLE10_NATIVE);
        byte[] bArr = new byte[documentEntry.getSize()];
        directoryNode.createDocumentInputStream(documentEntry).read(bArr);
        return new Ole10Native(bArr, 0);
    }

    public Ole10Native(String str, String str2, String str3, byte[] bArr) {
        this.flags1 = (short) 2;
        this.flags2 = (short) 0;
        this.unknown1 = (short) 3;
        this.flags3 = (short) 0;
        setLabel(str);
        setFileName(str2);
        setCommand(str3);
        setDataBuffer(bArr);
        this.mode = EncodingMode.parsed;
    }

    public Ole10Native(byte[] bArr, int i) throws Ole10NativeException {
        int i2;
        this.flags1 = (short) 2;
        this.flags2 = (short) 0;
        this.unknown1 = (short) 3;
        this.flags3 = (short) 0;
        if (bArr.length < i + 2) {
            throw new Ole10NativeException("data is too small");
        }
        this.totalSize = LittleEndian.getInt(bArr, i);
        int i3 = i + 4;
        this.mode = EncodingMode.unparsed;
        if (LittleEndian.getShort(bArr, i3) == 2) {
            if (Character.isISOControl(bArr[i3 + 2])) {
                this.mode = EncodingMode.compact;
            } else {
                this.mode = EncodingMode.parsed;
            }
        }
        int i4 = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode[this.mode.ordinal()];
        if (i4 == 1) {
            this.flags1 = LittleEndian.getShort(bArr, i3);
            int i5 = i3 + 2;
            int stringLength = getStringLength(bArr, i5);
            this.label = StringUtil.getFromCompressedUnicode(bArr, i5, stringLength - 1);
            int i6 = i5 + stringLength;
            int stringLength2 = getStringLength(bArr, i6);
            this.fileName = StringUtil.getFromCompressedUnicode(bArr, i6, stringLength2 - 1);
            int i7 = i6 + stringLength2;
            this.flags2 = LittleEndian.getShort(bArr, i7);
            int i8 = i7 + 2;
            this.unknown1 = LittleEndian.getShort(bArr, i8);
            int i9 = i8 + 2;
            int i10 = LittleEndian.getInt(bArr, i9);
            int i11 = i9 + 4;
            this.command = StringUtil.getFromCompressedUnicode(bArr, i11, i10 - 1);
            int i12 = i11 + i10;
            if (this.totalSize < i12) {
                throw new Ole10NativeException("Invalid Ole10Native");
            }
            i2 = LittleEndian.getInt(bArr, i12);
            i3 = i12 + 4;
            if (i2 < 0 || this.totalSize - (i3 - 4) < i2) {
                throw new Ole10NativeException("Invalid Ole10Native");
            }
        } else if (i4 == 2) {
            this.flags1 = LittleEndian.getShort(bArr, i3);
            i3 += 2;
            i2 = this.totalSize - 2;
        } else {
            i2 = this.totalSize;
        }
        if (((long) i2) + ((long) i3) > bArr.length) {
            throw new Ole10NativeException("Invalid Ole10Native: declared data length > available data");
        }
        byte[] bArr2 = new byte[i2];
        this.dataBuffer = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, i2);
    }

    /* JADX INFO: renamed from: org.apache.poi.poifs.filesystem.Ole10Native$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode;

        static {
            int[] iArr = new int[EncodingMode.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode = iArr;
            try {
                iArr[EncodingMode.parsed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode[EncodingMode.compact.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode[EncodingMode.unparsed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static int getStringLength(byte[] bArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            if (i3 >= bArr.length || bArr[i3] == 0) {
                break;
            }
            i2++;
        }
        return i2 + 1;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public short getFlags1() {
        return this.flags1;
    }

    public String getLabel() {
        return this.label;
    }

    public String getFileName() {
        return this.fileName;
    }

    public short getFlags2() {
        return this.flags2;
    }

    public short getUnknown1() {
        return this.unknown1;
    }

    public String getCommand() {
        return this.command;
    }

    public int getDataSize() {
        return this.dataBuffer.length;
    }

    public byte[] getDataBuffer() {
        return this.dataBuffer;
    }

    public short getFlags3() {
        return this.flags3;
    }

    public void writeOut(OutputStream outputStream) throws IOException {
        LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream(outputStream);
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode[this.mode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                littleEndianOutputStream.writeInt(getDataSize() + 2);
                littleEndianOutputStream.writeShort(getFlags1());
                outputStream.write(getDataBuffer());
                return;
            } else {
                littleEndianOutputStream.writeInt(getDataSize());
                outputStream.write(getDataBuffer());
                return;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        LittleEndianOutputStream littleEndianOutputStream2 = new LittleEndianOutputStream(byteArrayOutputStream);
        littleEndianOutputStream2.writeShort(getFlags1());
        littleEndianOutputStream2.write(getLabel().getBytes("ISO-8859-1"));
        littleEndianOutputStream2.write(0);
        littleEndianOutputStream2.write(getFileName().getBytes("ISO-8859-1"));
        littleEndianOutputStream2.write(0);
        littleEndianOutputStream2.writeShort(getFlags2());
        littleEndianOutputStream2.writeShort(getUnknown1());
        littleEndianOutputStream2.writeInt(getCommand().length() + 1);
        littleEndianOutputStream2.write(getCommand().getBytes("ISO-8859-1"));
        littleEndianOutputStream2.write(0);
        littleEndianOutputStream2.writeInt(getDataSize());
        littleEndianOutputStream2.write(getDataBuffer());
        littleEndianOutputStream2.writeShort(getFlags3());
        littleEndianOutputStream2.close();
        littleEndianOutputStream.writeInt(byteArrayOutputStream.size());
        byteArrayOutputStream.writeTo(outputStream);
    }

    public void setFlags1(short s) {
        this.flags1 = s;
    }

    public void setFlags2(short s) {
        this.flags2 = s;
    }

    public void setFlags3(short s) {
        this.flags3 = s;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setUnknown1(short s) {
        this.unknown1 = s;
    }

    public void setDataBuffer(byte[] bArr) {
        this.dataBuffer = (byte[]) bArr.clone();
    }
}
