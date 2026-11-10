package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    private final EmojiMetadata mMetadata;
    private final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    private short mWidth = -1;
    private short mHeight = -1;
    private float mRatio = 1.0f;

    EmojiSpan(EmojiMetadata emojiMetadata) {
        Preconditions.checkNotNull(emojiMetadata, "metadata cannot be null");
        this.mMetadata = emojiMetadata;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.mTmpFontMetrics);
        this.mRatio = (Math.abs(this.mTmpFontMetrics.descent - this.mTmpFontMetrics.ascent) * 1.0f) / this.mMetadata.getHeight();
        this.mHeight = (short) (this.mMetadata.getHeight() * this.mRatio);
        this.mWidth = (short) (this.mMetadata.getWidth() * this.mRatio);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = this.mTmpFontMetrics.ascent;
            fontMetricsInt.descent = this.mTmpFontMetrics.descent;
            fontMetricsInt.top = this.mTmpFontMetrics.top;
            fontMetricsInt.bottom = this.mTmpFontMetrics.bottom;
        }
        return this.mWidth;
    }

    public final EmojiMetadata getMetadata() {
        return this.mMetadata;
    }

    final int getWidth() {
        return this.mWidth;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    final float getRatio() {
        return this.mRatio;
    }

    public final int getId() {
        return getMetadata().getId();
    }
}
