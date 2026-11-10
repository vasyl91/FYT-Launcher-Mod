package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas.drawRect(f, i3, f + getWidth(), i5, getDebugPaint());
        }
        getMetadata().draw(canvas, f, i4, paint);
    }

    private static Paint getDebugPaint() {
        if (sDebugPaint == null) {
            TextPaint textPaint = new TextPaint();
            sDebugPaint = textPaint;
            textPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            sDebugPaint.setStyle(Paint.Style.FILL);
        }
        return sDebugPaint;
    }
}
