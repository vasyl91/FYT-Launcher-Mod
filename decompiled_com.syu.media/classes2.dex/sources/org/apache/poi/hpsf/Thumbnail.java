package org.apache.poi.hpsf;

import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Thumbnail {
    public static final int CFTAG_FMTID = -3;
    public static final int CFTAG_MACINTOSH = -2;
    public static final int CFTAG_NODATA = 0;
    public static final int CFTAG_WINDOWS = -1;
    public static final int CF_BITMAP = 2;
    public static final int CF_DIB = 8;
    public static final int CF_ENHMETAFILE = 14;
    public static final int CF_METAFILEPICT = 3;
    public static final int OFFSET_CF = 8;
    public static final int OFFSET_CFTAG = 4;
    public static final int OFFSET_WMFDATA = 20;
    private byte[] _thumbnailData;

    public Thumbnail() {
        this._thumbnailData = null;
    }

    public Thumbnail(byte[] bArr) {
        this._thumbnailData = bArr;
    }

    public byte[] getThumbnail() {
        return this._thumbnailData;
    }

    public void setThumbnail(byte[] bArr) {
        this._thumbnailData = bArr;
    }

    public long getClipboardFormatTag() {
        return LittleEndian.getInt(getThumbnail(), 4);
    }

    public long getClipboardFormat() throws HPSFException {
        if (getClipboardFormatTag() != -1) {
            throw new HPSFException("Clipboard Format Tag of Thumbnail must be CFTAG_WINDOWS.");
        }
        return LittleEndian.getInt(getThumbnail(), 8);
    }

    public byte[] getThumbnailAsWMF() throws HPSFException {
        if (getClipboardFormatTag() != -1) {
            throw new HPSFException("Clipboard Format Tag of Thumbnail must be CFTAG_WINDOWS.");
        }
        if (getClipboardFormat() != 3) {
            throw new HPSFException("Clipboard Format of Thumbnail must be CF_METAFILEPICT.");
        }
        byte[] thumbnail = getThumbnail();
        int length = thumbnail.length - 20;
        byte[] bArr = new byte[length];
        System.arraycopy(thumbnail, 20, bArr, 0, length);
        return bArr;
    }
}
