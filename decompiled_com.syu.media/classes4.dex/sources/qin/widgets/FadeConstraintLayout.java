package qin.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-B\u001b\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b,\u00100B#\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00101\u001a\u00020\u000e¢\u0006\u0004\b,\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\"\u0010!\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00063"}, d2 = {"Lqin/widgets/FadeConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/Canvas;", "canvas", "", "dispatchDraw", "", "a", "F", "getMFadeLength", "()F", "setMFadeLength", "(F)V", "mFadeLength", "", "b", "I", "getMStartColor", "()I", "setMStartColor", "(I)V", "mStartColor", "c", "getMEndColor", "setMEndColor", "mEndColor", "d", "getMLastColor", "setMLastColor", "mLastColor", "e", "getMFadeMode", "setMFadeMode", "mFadeMode", "Landroid/graphics/LinearGradient;", "f", "Landroid/graphics/LinearGradient;", "getMShader", "()Landroid/graphics/LinearGradient;", "setMShader", "(Landroid/graphics/LinearGradient;)V", "mShader", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class FadeConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public float mFadeLength;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int mStartColor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int mEndColor;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int mLastColor;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public int mFadeMode;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public LinearGradient mShader;
    public final Paint g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FadeConstraintLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchDraw(Canvas canvas) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Rect rect;
        Matrix matrix = new Matrix();
        Rect rect2 = new Rect();
        int paddingLeft = getPaddingLeft() + getScrollX();
        int paddingTop = getPaddingTop() + getScrollY();
        int right = ((getRight() + paddingLeft) - getLeft()) - getPaddingRight();
        int bottom = ((getBottom() + paddingTop) - getTop()) - getPaddingBottom();
        int i = this.mFadeMode;
        if (i != 0) {
            if (i == 1) {
                float width = this.mFadeLength * getWidth();
                matrix.setScale(1.0f, width);
                matrix.postRotate(-90.0f);
                float f = right;
                matrix.postTranslate(f, paddingTop);
                rect = new Rect((int) (f - width), paddingTop, right, bottom);
            } else if (i == 2) {
                float height = this.mFadeLength * getHeight();
                matrix.setScale(1.0f, height);
                float f2 = paddingTop;
                matrix.postTranslate(paddingLeft, f2);
                rect2 = new Rect(paddingLeft, paddingTop, right, (int) (f2 + height));
            } else if (i == 3) {
                float width2 = this.mFadeLength * getWidth();
                matrix.setScale(1.0f, width2);
                matrix.postRotate(90.0f);
                float f3 = paddingLeft;
                matrix.postTranslate(f3, paddingTop);
                rect = new Rect(paddingLeft, paddingTop, (int) (f3 + width2), bottom);
            }
            rect2 = rect;
        } else {
            float height2 = this.mFadeLength * getHeight();
            matrix.setScale(1.0f, height2);
            matrix.postRotate(180.0f);
            float f4 = bottom;
            matrix.postTranslate(paddingLeft, f4);
            rect2 = new Rect(paddingLeft, (int) (f4 - height2), right, bottom);
        }
        this.mShader.setLocalMatrix(matrix);
        this.g.setShader(this.mShader);
        ReflexMethod reflexMethod = new ReflexMethod("saveUnclippedLayer").target(canvas).setupClass(Canvas.class);
        Class<?> cls = Integer.TYPE;
        Integer num = (Integer) reflexMethod.paramClasses(cls, cls, cls, cls).params(Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.right), Integer.valueOf(rect2.bottom)).call();
        super.dispatchDraw(canvas);
        if (num != null) {
            new ReflexMethod("restoreUnclippedLayer").target(canvas).setupClass(Canvas.class).paramClasses(cls, Paint.class).params(Integer.valueOf(num.intValue()), this.g).call();
        }
    }

    public final int getMEndColor() {
        return this.mEndColor;
    }

    public final float getMFadeLength() {
        return this.mFadeLength;
    }

    public final int getMFadeMode() {
        return this.mFadeMode;
    }

    public final int getMLastColor() {
        return this.mLastColor;
    }

    public final LinearGradient getMShader() {
        return this.mShader;
    }

    public final int getMStartColor() {
        return this.mStartColor;
    }

    public final void setMEndColor(int i) {
        this.mEndColor = i;
    }

    public final void setMFadeLength(float f) {
        this.mFadeLength = f;
    }

    public final void setMFadeMode(int i) {
        this.mFadeMode = i;
    }

    public final void setMLastColor(int i) {
        this.mLastColor = i;
    }

    public final void setMShader(LinearGradient linearGradient) {
        Intrinsics.checkNotNullParameter(linearGradient, "<set-?>");
        this.mShader = linearGradient;
    }

    public final void setMStartColor(int i) {
        this.mStartColor = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FadeConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FadeConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFadeLength = 1.0f;
        this.mEndColor = -16777216;
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.g = paint;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FadeView, i, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getIndex(i2));
            int i3 = R.styleable.FadeView_fadeLength;
            if (numValueOf != null && numValueOf.intValue() == i3) {
                this.mFadeLength = Math.max(0.0f, Math.min(1.0f, typedArrayObtainStyledAttributes.getFloat(numValueOf.intValue(), 1.0f)));
            } else {
                int i4 = R.styleable.FadeView_fadeMode;
                if (numValueOf != null && numValueOf.intValue() == i4) {
                    this.mFadeMode = typedArrayObtainStyledAttributes.getInt(numValueOf.intValue(), 0);
                } else {
                    int i5 = R.styleable.FadeView_startColor;
                    if (numValueOf != null && numValueOf.intValue() == i5) {
                        this.mStartColor = typedArrayObtainStyledAttributes.getColor(numValueOf.intValue(), 0);
                    } else {
                        int i6 = R.styleable.FadeView_endColor;
                        if (numValueOf != null && numValueOf.intValue() == i6) {
                            this.mEndColor = typedArrayObtainStyledAttributes.getColor(numValueOf.intValue(), -16777216);
                        }
                    }
                }
            }
        }
        this.mShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, this.mEndColor, this.mStartColor, Shader.TileMode.CLAMP);
        typedArrayObtainStyledAttributes.recycle();
    }
}
