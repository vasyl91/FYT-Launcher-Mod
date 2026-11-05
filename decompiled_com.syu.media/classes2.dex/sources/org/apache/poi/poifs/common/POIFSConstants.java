package org.apache.poi.poifs.common;

import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface POIFSConstants {
    public static final int BIG_BLOCK_MINIMUM_DOCUMENT_SIZE = 4096;
    public static final int DIFAT_SECTOR_BLOCK = -4;
    public static final int END_OF_CHAIN = -2;
    public static final int FAT_SECTOR_BLOCK = -3;
    public static final int LARGER_BIG_BLOCK_SIZE = 4096;
    public static final int LARGEST_REGULAR_SECTOR_NUMBER = -5;
    public static final int PROPERTY_SIZE = 128;
    public static final int SMALLER_BIG_BLOCK_SIZE = 512;
    public static final int SMALL_BLOCK_SIZE = 64;
    public static final int UNUSED_BLOCK = -1;
    public static final POIFSBigBlockSize SMALLER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(512, 9);
    public static final POIFSBigBlockSize LARGER_BIG_BLOCK_SIZE_DETAILS = new POIFSBigBlockSize(4096, 12);
    public static final byte[] OOXML_FILE_HEADER = {80, 75, 3, 4};
    public static final byte[] RAW_XML_FILE_HEADER = {DeletedRef3DPtg.sid, 63, 120, 109, 108};
}
