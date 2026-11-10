package com.syu.media.provider;

import chip.FinalChip;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0014\u0010\u0019\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/syu/media/provider/MediaConstant;", FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null, "DEF_ORDER", "Ljava/lang/String;", "AUTHORITY", "SONG_TABLE_URI", "LIST_TABLE_URI", "FOLDER_TABLE_URI", "VIDEO_TABLE_URI", "ONLINE_TABLE_URI", FinalChip.BSP_PLATFORM_Null, "PLAY_LIST_ID", "I", "ALLAUDIO_LIST_ID", "FAVORITE_LIST_ID", "VIDEO_PLAY_LIST_ID", "ALLVIDEO_LIST_ID", "VIDEO_FAVORITE_LIST_ID", "RADIO_LIST_ID", "RADIO_PLAY_LIST_ID", "RADIO_FAVORITE_LIST_ID", "SONG_CODE", "LIST_CODE", "VIDEO_CODE", "FOLDER_CODE", "ONLINE_CODE", "ONLINE_LIST_CODE", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class MediaConstant {
    public static final int ALLAUDIO_LIST_ID = 2;
    public static final int ALLVIDEO_LIST_ID = 5;
    public static final String AUTHORITY = "com.syu.media";
    public static final String DEF_ORDER = "_id";
    public static final int FAVORITE_LIST_ID = 3;
    public static final int FOLDER_CODE = 4;
    public static final String FOLDER_TABLE_URI = "content://com.syu.media/Folder";
    public static final MediaConstant INSTANCE = new MediaConstant();
    public static final int LIST_CODE = 2;
    public static final String LIST_TABLE_URI = "content://com.syu.media/list";
    public static final int ONLINE_CODE = 5;
    public static final int ONLINE_LIST_CODE = 6;
    public static final String ONLINE_TABLE_URI = "content://com.syu.media/radio";
    public static final int PLAY_LIST_ID = 1;
    public static final int RADIO_FAVORITE_LIST_ID = 9;
    public static final int RADIO_LIST_ID = 8;
    public static final int RADIO_PLAY_LIST_ID = 7;
    public static final int SONG_CODE = 1;
    public static final String SONG_TABLE_URI = "content://com.syu.media/song";
    public static final int VIDEO_CODE = 3;
    public static final int VIDEO_FAVORITE_LIST_ID = 6;
    public static final int VIDEO_PLAY_LIST_ID = 4;
    public static final String VIDEO_TABLE_URI = "content://com.syu.media/video";
}
