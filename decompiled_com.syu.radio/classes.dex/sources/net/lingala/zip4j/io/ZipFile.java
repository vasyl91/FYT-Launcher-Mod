package net.lingala.zip4j.io;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ZipFile {
    private Context context;
    private HashMap<String, ZipFileHeader> fileHeaders;
    private String strAsset;
    private String strZipFile;

    public ZipFile(Context context, String strAsset) {
        this.strAsset = null;
        this.context = context;
        this.strAsset = strAsset;
    }

    public ZipFile(File zipFile) throws Exception {
        this.strAsset = null;
        this.strZipFile = zipFile.getPath();
    }

    public HashMap<String, ZipFileHeader> getFileHeaders() throws Exception {
        ZipIn zipIn;
        ZipIn zipIn2 = null;
        try {
            try {
                if (!TextUtils.isEmpty(this.strAsset)) {
                    ZipIn zipIn3 = new ZipIn2(this.context, this.strAsset);
                    zipIn = zipIn3;
                } else {
                    ZipIn zipIn4 = new ZipIn1(new RandomAccessFile(new File(this.strZipFile), ZipIn.READ_MODE));
                    zipIn = zipIn4;
                }
                if (zipIn != null) {
                    byte[] ebs = new byte[4];
                    long pos = zipIn.length() - 22;
                    int counter = 0;
                    do {
                        long pos2 = pos;
                        pos = pos2 - 1;
                        zipIn.seek(pos2);
                        counter++;
                        if (zipIn.readLeInt(ebs) == ZipIn.ENDSIG) {
                            break;
                        }
                    } while (counter <= 3000);
                    if (zipIn.readLongLittleEndian(ebs) != ZipIn.ENDSIG) {
                        throw new Exception("zip headers not found. probably not a zip file");
                    }
                    byte[] intBuff = new byte[4];
                    byte[] shortBuff = new byte[2];
                    zipIn.skip(6L);
                    zipIn.read(shortBuff);
                    int centralDirEntryCount = zipIn.readShortLittleEndian(shortBuff);
                    zipIn.skip(4L);
                    zipIn.read(intBuff);
                    long offSetStartCentralDir = zipIn.readLongLittleEndian(intBuff);
                    HashMap<String, ZipFileHeader> fileHeaderList = new HashMap<>();
                    zipIn.seek(offSetStartCentralDir);
                    for (int i = 0; i < centralDirEntryCount; i++) {
                        ZipFileHeader fileHeader = new ZipFileHeader();
                        zipIn.read(intBuff);
                        if (zipIn.readLongLittleEndian(intBuff) != ZipIn.CENSIG) {
                            throw new Exception("Expected central directory entry not found (#" + (i + 1) + ")");
                        }
                        zipIn.skip(6L);
                        zipIn.read(shortBuff);
                        fileHeader.setCompressionMethod(zipIn.readShortLittleEndian(shortBuff));
                        zipIn.skip(8L);
                        zipIn.read(intBuff);
                        fileHeader.setCompressedSize(zipIn.readLongLittleEndian(intBuff));
                        zipIn.read(intBuff);
                        fileHeader.setUncompressedSize(zipIn.readLongLittleEndian(intBuff));
                        zipIn.read(shortBuff);
                        int fileNameLength = zipIn.readShortLittleEndian(shortBuff);
                        zipIn.read(shortBuff);
                        int lenSkip = 0 + zipIn.readShortLittleEndian(shortBuff);
                        zipIn.read(shortBuff);
                        int lenSkip2 = lenSkip + zipIn.readShortLittleEndian(shortBuff);
                        zipIn.skip(8L);
                        zipIn.read(intBuff);
                        fileHeader.setOffset(zipIn.readLongLittleEndian(intBuff) & 4294967295L);
                        String fileName = null;
                        if (fileNameLength > 0) {
                            byte[] fileNameBuf = new byte[fileNameLength];
                            zipIn.read(fileNameBuf);
                            fileName = new String(fileNameBuf, "gbk");
                        }
                        fileHeader.setFileName(fileName);
                        if (lenSkip2 > 0) {
                            zipIn.skip(lenSkip2);
                        }
                        fileHeaderList.put(fileHeader.getFileName(), fileHeader);
                    }
                    this.fileHeaders = fileHeaderList;
                }
                zipIn.close();
                return this.fileHeaders;
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            zipIn2.close();
            throw th;
        }
    }

    public ZipInputStream getInputStream(ZipFileHeader fileHeader) throws Exception {
        ZipIn zipIn;
        if (!TextUtils.isEmpty(this.strAsset)) {
            zipIn = new ZipIn2(this.context, this.strAsset);
        } else {
            zipIn = new ZipIn1(new RandomAccessFile(new File(this.strZipFile), ZipIn.READ_MODE));
        }
        try {
            long locHdrOffset = fileHeader.getOffset();
            if (locHdrOffset < 0) {
                throw new Exception("invalid local header offset");
            }
            byte[] shortBuff = new byte[2];
            byte[] intBuff = new byte[4];
            zipIn.seek(locHdrOffset);
            ZipFileHeader localFileHeader = new ZipFileHeader();
            zipIn.read(intBuff);
            if (zipIn.readLongLittleEndian(intBuff) != ZipIn.LOCSIG) {
                throw new Exception("invalid local header signature for file: " + fileHeader.getFileName());
            }
            zipIn.read(shortBuff);
            int iExtra = zipIn.readShortLittleEndian(shortBuff);
            zipIn.read(shortBuff);
            if ((shortBuff[0] & 1) != 0) {
                localFileHeader.setEncrypted(true);
            }
            zipIn.read(shortBuff);
            localFileHeader.setCompressionMethod(zipIn.readShortLittleEndian(shortBuff));
            zipIn.skip(8L);
            zipIn.read(intBuff);
            localFileHeader.setCompressedSize(zipIn.readLongLittleEndian(intBuff));
            zipIn.skip(4L);
            zipIn.read(shortBuff);
            int fileNameLength = zipIn.readShortLittleEndian(shortBuff);
            zipIn.read(shortBuff);
            int extraFieldLength = zipIn.readShortLittleEndian(shortBuff);
            localFileHeader.setOffset(30 + locHdrOffset + ((long) fileNameLength) + ((long) extraFieldLength));
            if (localFileHeader.getCompressedSize() <= 0) {
                localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
            }
            if (localFileHeader.getCompressionMethod() != fileHeader.getCompressionMethod()) {
                throw new Exception("local header and file header do not match");
            }
            if (localFileHeader.isEncrypted()) {
                byte[] headerBytes = new byte[12];
                zipIn.seek(localFileHeader.getOffset());
                zipIn.read(headerBytes, 0, 12);
                localFileHeader.initKeys(headerBytes, fileHeader.getFileName(), iExtra);
            }
            long comprSize = localFileHeader.getCompressedSize();
            long offsetStartOfData = localFileHeader.getOffset();
            if (localFileHeader.isEncrypted()) {
                comprSize -= 12;
                offsetStartOfData += 12;
            }
            int compressionMethod = fileHeader.getCompressionMethod();
            zipIn.seek(offsetStartOfData);
            switch (compressionMethod) {
                case 0:
                    return new ZipInputStream(zipIn, localFileHeader, offsetStartOfData, comprSize, fileHeader.getUncompressedSize(), false);
                case 8:
                    return new ZipInputStream(zipIn, localFileHeader, offsetStartOfData, comprSize, fileHeader.getUncompressedSize(), true);
                default:
                    throw new Exception("compression type not supported");
            }
        } catch (Exception e) {
            zipIn.close();
            throw e;
        }
    }
}
