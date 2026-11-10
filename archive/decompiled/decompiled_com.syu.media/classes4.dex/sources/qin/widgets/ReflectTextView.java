package qin.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b-\u00101B#\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\u0002¢\u0006\u0004\b-\u00103J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016¨\u00064"}, d2 = {"Lqin/widgets/ReflectTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", "canvas", "onDraw", "", "text", "start", "lengthBefore", "lengthAfter", "onTextChanged", "", "c", "F", "getOffset", "()F", "setOffset", "(F)V", "offset", "d", "I", "getOldHeight", "()I", "setOldHeight", "(I)V", "oldHeight", "e", "getSpace", "setSpace", "space", "f", "getScale", "setScale", "scale", "g", "getReflectAlpha", "setReflectAlpha", "reflectAlpha", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class ReflectTextView extends AppCompatTextView {
    public final Matrix a;
    public Paint b;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float offset;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int oldHeight;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public float space;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public float scale;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public float reflectAlpha;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReflectTextView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final float getOffset() {
        return this.offset;
    }

    public final int getOldHeight() {
        return this.oldHeight;
    }

    public final float getReflectAlpha() {
        return this.reflectAlpha;
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getSpace() {
        return this.space;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        setDrawingCacheEnabled(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getDrawingCache());
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(drawingCache)");
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, (int) (this.oldHeight - this.offset), this.a, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(originalIma….toInt(), mMatrix, false)");
        canvas.drawBitmap(bitmapCreateBitmap2, 0.0f, getBaseline() + this.space, (Paint) null);
        if (this.b == null) {
            this.b = new Paint();
            LinearGradient linearGradient = new LinearGradient(0.0f, getBaseline() + this.space, 0.0f, height, (((int) (255 * this.reflectAlpha)) << 24) | 16777215, 268435455, Shader.TileMode.CLAMP);
            Paint paint = this.b;
            if (paint != null) {
                paint.setShader(linearGradient);
            }
            Paint paint2 = this.b;
            if (paint2 != null) {
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            }
        }
        Paint paint3 = this.b;
        Intrinsics.checkNotNull(paint3);
        canvas.drawRect(0.0f, getBaseline() + this.space, width, height, paint3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredHeight = getMeasuredHeight();
        this.oldHeight = measuredHeight;
        this.offset = measuredHeight - getBaseline();
        setMeasuredDimension(getMeasuredWidth(), (int) ((getTextSize() * this.scale) + getBaseline() + this.space));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        buildDrawingCache();
        postInvalidate();
        destroyDrawingCache();
    }

    public final void setOffset(float f) {
        this.offset = f;
    }

    public final void setOldHeight(int i) {
        this.oldHeight = i;
    }

    public final void setReflectAlpha(float f) {
        this.reflectAlpha = f;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    public final void setSpace(float f) {
        this.space = f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReflectTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Matrix matrix = new Matrix();
        this.a = matrix;
        this.scale = 0.05f;
        this.reflectAlpha = 0.5f;
        matrix.preScale(1.0f, -1.0f);
        setLayerType(1, (Paint) null);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.reflectTextView, i, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(R.styleable.reflectTextView_reflect_alpha, 0.5f);
        this.reflectAlpha = f;
        this.reflectAlpha = Math.max(0.0f, Math.min(f, 1.0f));
        float f2 = typedArrayObtainStyledAttributes.getFloat(R.styleable.reflectTextView_reflect_height, 0.5f);
        this.scale = f2;
        this.scale = Math.max(0.0f, Math.min(f2, 1.0f));
        this.space = typedArrayObtainStyledAttributes.getDimension(R.styleable.reflectTextView_reflect_space, 1.0f);
    }
}
