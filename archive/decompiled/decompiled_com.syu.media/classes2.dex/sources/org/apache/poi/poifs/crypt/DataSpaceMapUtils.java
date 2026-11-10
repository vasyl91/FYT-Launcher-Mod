package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DataSpaceMapUtils {
    public static void addDefaultDataSpace(DirectoryEntry directoryEntry) throws IOException {
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/DataSpaceMap", new DataSpaceMap(new DataSpaceMapEntry[]{new DataSpaceMapEntry(new int[]{0}, new String[]{Decryptor.DEFAULT_POIFS_ENTRY}, "StrongEncryptionDataSpace")}));
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/DataSpaceInfo/StrongEncryptionDataSpace", new DataSpaceDefinition(new String[]{"StrongEncryptionTransform"}));
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/TransformInfo/StrongEncryptionTransform/\u0006Primary", new IRMDSTransformInfo(new TransformInfoHeader(1, "{FF9A3F03-56EF-4613-BDD5-5A41C1D07246}", "Microsoft.Container.EncryptionTransform", 1, 0, 1, 0, 1, 0), 0, null));
        createEncryptionEntry(directoryEntry, "\u0006DataSpaces/Version", new DataSpaceVersionInfo("Microsoft.Container.DataSpaces", 1, 0, 1, 0, 1, 0));
    }

    public static DocumentEntry createEncryptionEntry(DirectoryEntry directoryEntry, String str, EncryptionRecord encryptionRecord) throws IOException {
        String[] strArrSplit = str.split("/");
        for (int i = 0; i < strArrSplit.length - 1; i++) {
            directoryEntry = directoryEntry.hasEntry(strArrSplit[i]) ? (DirectoryEntry) directoryEntry.getEntry(strArrSplit[i]) : directoryEntry.createDirectory(strArrSplit[i]);
        }
        final byte[] bArr = new byte[5000];
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, 0);
        encryptionRecord.write(littleEndianByteArrayOutputStream);
        String str2 = strArrSplit[strArrSplit.length - 1];
        if (directoryEntry.hasEntry(str2)) {
            directoryEntry.getEntry(str2).delete();
        }
        return directoryEntry.createDocument(str2, littleEndianByteArrayOutputStream.getWriteIndex(), new POIFSWriterListener() { // from class: org.apache.poi.poifs.crypt.DataSpaceMapUtils.1
            @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
            public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
                try {
                    pOIFSWriterEvent.getStream().write(bArr, 0, pOIFSWriterEvent.getLimit());
                } catch (IOException e) {
                    throw new EncryptedDocumentException(e);
                }
            }
        });
    }

    public static class DataSpaceMap implements EncryptionRecord {
        DataSpaceMapEntry[] entries;

        public DataSpaceMap(DataSpaceMapEntry[] dataSpaceMapEntryArr) {
            this.entries = (DataSpaceMapEntry[]) dataSpaceMapEntryArr.clone();
        }

        public DataSpaceMap(LittleEndianInput littleEndianInput) {
            littleEndianInput.readInt();
            int i = littleEndianInput.readInt();
            this.entries = new DataSpaceMapEntry[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.entries[i2] = new DataSpaceMapEntry(littleEndianInput);
            }
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            littleEndianByteArrayOutputStream.writeInt(8);
            littleEndianByteArrayOutputStream.writeInt(this.entries.length);
            for (DataSpaceMapEntry dataSpaceMapEntry : this.entries) {
                dataSpaceMapEntry.write(littleEndianByteArrayOutputStream);
            }
        }
    }

    public static class DataSpaceMapEntry implements EncryptionRecord {
        final String dataSpaceName;
        final String[] referenceComponent;
        final int[] referenceComponentType;

        public DataSpaceMapEntry(int[] iArr, String[] strArr, String str) {
            this.referenceComponentType = (int[]) iArr.clone();
            this.referenceComponent = (String[]) strArr.clone();
            this.dataSpaceName = str;
        }

        public DataSpaceMapEntry(LittleEndianInput littleEndianInput) {
            littleEndianInput.readInt();
            int i = littleEndianInput.readInt();
            this.referenceComponentType = new int[i];
            this.referenceComponent = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.referenceComponentType[i2] = littleEndianInput.readInt();
                this.referenceComponent[i2] = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            }
            this.dataSpaceName = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            int writeIndex = littleEndianByteArrayOutputStream.getWriteIndex();
            LittleEndianOutput littleEndianOutputCreateDelayedOutput = littleEndianByteArrayOutputStream.createDelayedOutput(4);
            littleEndianByteArrayOutputStream.writeInt(this.referenceComponent.length);
            for (int i = 0; i < this.referenceComponent.length; i++) {
                littleEndianByteArrayOutputStream.writeInt(this.referenceComponentType[i]);
                DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.referenceComponent[i]);
            }
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.dataSpaceName);
            littleEndianOutputCreateDelayedOutput.writeInt(littleEndianByteArrayOutputStream.getWriteIndex() - writeIndex);
        }
    }

    public static class DataSpaceDefinition implements EncryptionRecord {
        String[] transformer;

        public DataSpaceDefinition(String[] strArr) {
            this.transformer = (String[]) strArr.clone();
        }

        public DataSpaceDefinition(LittleEndianInput littleEndianInput) {
            littleEndianInput.readInt();
            int i = littleEndianInput.readInt();
            this.transformer = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.transformer[i2] = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            }
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            littleEndianByteArrayOutputStream.writeInt(8);
            littleEndianByteArrayOutputStream.writeInt(this.transformer.length);
            for (String str : this.transformer) {
                DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, str);
            }
        }
    }

    public static class IRMDSTransformInfo implements EncryptionRecord {
        int extensibilityHeader;
        TransformInfoHeader transformInfoHeader;
        String xrMLLicense;

        public IRMDSTransformInfo(TransformInfoHeader transformInfoHeader, int i, String str) {
            this.transformInfoHeader = transformInfoHeader;
            this.extensibilityHeader = i;
            this.xrMLLicense = str;
        }

        public IRMDSTransformInfo(LittleEndianInput littleEndianInput) {
            this.transformInfoHeader = new TransformInfoHeader(littleEndianInput);
            this.extensibilityHeader = littleEndianInput.readInt();
            this.xrMLLicense = DataSpaceMapUtils.readUtf8LPP4(littleEndianInput);
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            this.transformInfoHeader.write(littleEndianByteArrayOutputStream);
            littleEndianByteArrayOutputStream.writeInt(this.extensibilityHeader);
            DataSpaceMapUtils.writeUtf8LPP4(littleEndianByteArrayOutputStream, this.xrMLLicense);
            littleEndianByteArrayOutputStream.writeInt(4);
        }
    }

    public static class TransformInfoHeader implements EncryptionRecord {
        int readerVersionMajor;
        int readerVersionMinor;
        int transformType;
        String transformerId;
        String transformerName;
        int updaterVersionMajor;
        int updaterVersionMinor;
        int writerVersionMajor;
        int writerVersionMinor;

        public TransformInfoHeader(int i, String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.transformType = i;
            this.transformerId = str;
            this.transformerName = str2;
            this.readerVersionMajor = i2;
            this.readerVersionMinor = i3;
            this.updaterVersionMajor = i4;
            this.updaterVersionMinor = i5;
            this.writerVersionMajor = i6;
            this.writerVersionMinor = i7;
        }

        public TransformInfoHeader(LittleEndianInput littleEndianInput) {
            this.readerVersionMajor = 1;
            this.readerVersionMinor = 0;
            this.updaterVersionMajor = 1;
            this.updaterVersionMinor = 0;
            this.writerVersionMajor = 1;
            this.writerVersionMinor = 0;
            littleEndianInput.readInt();
            this.transformType = littleEndianInput.readInt();
            this.transformerId = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            this.transformerName = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            this.readerVersionMajor = littleEndianInput.readShort();
            this.readerVersionMinor = littleEndianInput.readShort();
            this.updaterVersionMajor = littleEndianInput.readShort();
            this.updaterVersionMinor = littleEndianInput.readShort();
            this.writerVersionMajor = littleEndianInput.readShort();
            this.writerVersionMinor = littleEndianInput.readShort();
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            int writeIndex = littleEndianByteArrayOutputStream.getWriteIndex();
            LittleEndianOutput littleEndianOutputCreateDelayedOutput = littleEndianByteArrayOutputStream.createDelayedOutput(4);
            littleEndianByteArrayOutputStream.writeInt(this.transformType);
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.transformerId);
            littleEndianOutputCreateDelayedOutput.writeInt(littleEndianByteArrayOutputStream.getWriteIndex() - writeIndex);
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.transformerName);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMinor);
        }
    }

    public static class DataSpaceVersionInfo implements EncryptionRecord {
        String featureIdentifier;
        int readerVersionMajor;
        int readerVersionMinor;
        int updaterVersionMajor;
        int updaterVersionMinor;
        int writerVersionMajor;
        int writerVersionMinor;

        public DataSpaceVersionInfo(LittleEndianInput littleEndianInput) {
            this.readerVersionMajor = 1;
            this.readerVersionMinor = 0;
            this.updaterVersionMajor = 1;
            this.updaterVersionMinor = 0;
            this.writerVersionMajor = 1;
            this.writerVersionMinor = 0;
            this.featureIdentifier = DataSpaceMapUtils.readUnicodeLPP4(littleEndianInput);
            this.readerVersionMajor = littleEndianInput.readShort();
            this.readerVersionMinor = littleEndianInput.readShort();
            this.updaterVersionMajor = littleEndianInput.readShort();
            this.updaterVersionMinor = littleEndianInput.readShort();
            this.writerVersionMajor = littleEndianInput.readShort();
            this.writerVersionMinor = littleEndianInput.readShort();
        }

        public DataSpaceVersionInfo(String str, int i, int i2, int i3, int i4, int i5, int i6) {
            this.featureIdentifier = str;
            this.readerVersionMajor = i;
            this.readerVersionMinor = i2;
            this.updaterVersionMajor = i3;
            this.updaterVersionMinor = i4;
            this.writerVersionMajor = i5;
            this.writerVersionMinor = i6;
        }

        @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
        public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
            DataSpaceMapUtils.writeUnicodeLPP4(littleEndianByteArrayOutputStream, this.featureIdentifier);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.readerVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.updaterVersionMinor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMajor);
            littleEndianByteArrayOutputStream.writeShort(this.writerVersionMinor);
        }
    }

    public static String readUnicodeLPP4(LittleEndianInput littleEndianInput) {
        int i = littleEndianInput.readInt();
        if (i % 2 != 0) {
            throw new EncryptedDocumentException("UNICODE-LP-P4 structure is a multiple of 4 bytes. If Padding is present, it MUST be exactly 2 bytes long");
        }
        String unicodeLE = StringUtil.readUnicodeLE(littleEndianInput, i / 2);
        if (i % 4 == 2) {
            littleEndianInput.readShort();
        }
        return unicodeLE;
    }

    public static void writeUnicodeLPP4(LittleEndianOutput littleEndianOutput, String str) {
        byte[] toUnicodeLE = StringUtil.getToUnicodeLE(str);
        littleEndianOutput.writeInt(toUnicodeLE.length);
        littleEndianOutput.write(toUnicodeLE);
        if (toUnicodeLE.length % 4 == 2) {
            littleEndianOutput.writeShort(0);
        }
    }

    public static String readUtf8LPP4(LittleEndianInput littleEndianInput) {
        int i = littleEndianInput.readInt();
        if (i == 0 || i == 4) {
            littleEndianInput.readInt();
            if (i == 0) {
                return null;
            }
            return "";
        }
        byte[] bArr = new byte[i];
        littleEndianInput.readFully(bArr);
        int i2 = i % 4;
        if (i2 > 0) {
            for (int i3 = 0; i3 < 4 - i2; i3++) {
                littleEndianInput.readByte();
            }
        }
        return new String(bArr, 0, i, Charset.forName("UTF-8"));
    }

    public static void writeUtf8LPP4(LittleEndianOutput littleEndianOutput, String str) {
        if (str == null || "".equals(str)) {
            littleEndianOutput.writeInt(str == null ? 0 : 4);
            littleEndianOutput.writeInt(0);
            return;
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        littleEndianOutput.writeInt(bytes.length);
        littleEndianOutput.write(bytes);
        int length = bytes.length % 4;
        if (length > 0) {
            for (int i = 0; i < 4 - length; i++) {
                littleEndianOutput.writeByte(0);
            }
        }
    }
}
