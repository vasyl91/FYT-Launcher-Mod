package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class EmojiMetadata {
    public static final int HAS_GLYPH_ABSENT = 1;
    public static final int HAS_GLYPH_EXISTS = 2;
    public static final int HAS_GLYPH_UNKNOWN = 0;
    private static final ThreadLocal<MetadataItem> sMetadataItem = new ThreadLocal<>();
    private volatile int mHasGlyph = 0;
    private final int mIndex;
    private final MetadataRepo mMetadataRepo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    EmojiMetadata(MetadataRepo metadataRepo, int i) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = i;
    }

    public void draw(Canvas canvas, float f, float f2, Paint paint) {
        Typeface typeface = this.mMetadataRepo.getTypeface();
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(this.mMetadataRepo.getEmojiCharArray(), this.mIndex * 2, 2, f, f2, paint);
        paint.setTypeface(typeface2);
    }

    public Typeface getTypeface() {
        return this.mMetadataRepo.getTypeface();
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> threadLocal = sMetadataItem;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.mMetadataRepo.getMetadataList().list(metadataItem, this.mIndex);
        return metadataItem;
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getWidth() {
        return getMetadataItem().width();
    }

    public short getHeight() {
        return getMetadataItem().height();
    }

    public short getCompatAdded() {
        return getMetadataItem().compatAdded();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    public int getHasGlyph() {
        return this.mHasGlyph;
    }

    public void resetHasGlyphCache() {
        this.mHasGlyph = 0;
    }

    public void setHasGlyph(boolean z) {
        this.mHasGlyph = z ? 2 : 1;
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    public int getCodepointAt(int i) {
        return getMetadataItem().codepoints(i);
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(getId()));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i = 0; i < codepointsLength; i++) {
            sb.append(Integer.toHexString(getCodepointAt(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
