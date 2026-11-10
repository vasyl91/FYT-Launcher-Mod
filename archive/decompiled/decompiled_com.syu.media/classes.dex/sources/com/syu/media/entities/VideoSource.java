package com.syu.media.entities;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.provider.Media;
import com.syu.utils.BitmapUtils;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\nHÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\t\u0010\u0010\u001a\u00020\nHÖ\u0001R\u001a\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/syu/media/entities/VideoSource;", "Lcom/syu/media/entities/MediaSource;", FinalChip.BSP_PLATFORM_Null, "toString", "Landroid/graphics/Bitmap;", "getAlbumCover", FinalChip.BSP_PLATFORM_Null, "other", FinalChip.BSP_PLATFORM_Null, "equals", FinalChip.BSP_PLATFORM_Null, "component1", "component2", Media.VIDEO_WIDTH, Media.VIDEO_HEIGHT, "copy", "hashCode", "k", "I", "getWidth", "()I", "l", "getHeight", "<init>", "(II)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final /* data */ class VideoSource extends MediaSource {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final int width;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final int height;

    public VideoSource(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ VideoSource copy$default(VideoSource videoSource, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = videoSource.width;
        }
        if ((i3 & 2) != 0) {
            i2 = videoSource.height;
        }
        return videoSource.copy(i, i2);
    }

    @Override // com.syu.media.entities.MediaSource
    public Object clone() {
        return super.clone();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final VideoSource copy(int width, int height) {
        return new VideoSource(width, height);
    }

    @Override // com.syu.media.entities.MediaSource
    public boolean equals(Object other) {
        return super.equals(other);
    }

    @Override // com.syu.media.entities.MediaSource
    public Bitmap getAlbumCover() throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(getCom.syu.media.provider.Media.PATH java.lang.String());
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
        Bitmap bitmapScaleNotDeform$default = frameAtTime != null ? BitmapUtils.scaleNotDeform$default(BitmapUtils.INSTANCE, frameAtTime, 120.0f, 120.0f, false, 8, (Object) null) : null;
        mediaMetadataRetriever.release();
        return bitmapScaleNotDeform$default;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return Integer.hashCode(this.height) + (Integer.hashCode(this.width) * 31);
    }

    @Override // com.syu.media.entities.MediaSource
    public String toString() {
        return "VideoSource:(width=" + this.width + ", height=" + this.height + XmlConsts.CHAR_SPACE + super.toString() + ") ";
    }
}
