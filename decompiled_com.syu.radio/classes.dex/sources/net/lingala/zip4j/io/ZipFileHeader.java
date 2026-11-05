package net.lingala.zip4j.io;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ZipFileHeader {
    private long compressedSize;
    private int compressionMethod;
    private String fileName;
    private boolean isEncrypted;
    private long offset;
    public final int[] keys = new int[3];
    private long uncompressedSize = 0;

    public void initKeys(byte[] headerBytes, String strName, int iExtra) {
        ZipJni zipJni = ZipJni.getInstance();
        if (zipJni != null) {
            zipJni.initKeys(this.keys, headerBytes, strName, iExtra);
        }
    }

    public void decryptData(byte[] buff, int start, int len) {
        ZipJni zipJni;
        if (isEncrypted() && (zipJni = ZipJni.getInstance()) != null) {
            zipJni.decryptData(this.keys, buff, start, len);
        }
    }

    public int getCompressionMethod() {
        return this.compressionMethod;
    }

    public void setCompressionMethod(int compressionMethod) {
        this.compressionMethod = compressionMethod;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public void setCompressedSize(long compressedSize) {
        this.compressedSize = compressedSize;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void setUncompressedSize(long uncompressedSize) {
        this.uncompressedSize = uncompressedSize;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setEncrypted(boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }
}
