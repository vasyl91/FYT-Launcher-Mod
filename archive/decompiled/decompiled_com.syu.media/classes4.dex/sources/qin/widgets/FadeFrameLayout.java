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
import android.widget.FrameLayout;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import syu.reflex.ReflexMethod;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b.\u00102B#\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b.\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00065"}, d2 = {"Lqin/widgets/FadeFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", "canvas", "", "dispatchDraw", "", "color", "setFadeColor", "", "a", "F", "getMFadeLength", "()F", "setMFadeLength", "(F)V", "mFadeLength", "b", "I", "getMStartColor", "()I", "setMStartColor", "(I)V", "mStartColor", "c", "getMEndColor", "setMEndColor", "mEndColor", "d", "getMLastColor", "setMLastColor", "mLastColor", "e", "getMFadeMode", "setMFadeMode", "mFadeMode", "Landroid/graphics/LinearGradient;", "f", "Landroid/graphics/LinearGradient;", "getMShader", "()Landroid/graphics/LinearGradient;", "setMShader", "(Landroid/graphics/LinearGradient;)V", "mShader", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class FadeFrameLayout extends FrameLayout {

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
    public FadeFrameLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Code duplicated, block: B:15:0x014f  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Rect rect;
        Class<?> cls;
        Integer num;
        Matrix matrix = new Matrix();
        Rect rect2 = new Rect();
        int i = this.mFadeMode;
        if (i == 0) {
            float height = this.mFadeLength * getHeight();
            matrix.setScale(1.0f, height);
            matrix.postRotate(180.0f);
            matrix.postTranslate(getLeft(), getBottom());
            rect = new Rect(getLeft(), (int) (getBottom() - height), getRight(), getBottom());
        } else if (i == 1) {
            float width = this.mFadeLength * getWidth();
            matrix.setScale(1.0f, width);
            matrix.postRotate(-90.0f);
            matrix.postTranslate(getRight(), getTop());
            rect = new Rect((int) (getRight() - width), getTop(), getRight(), getBottom());
        } else {
            if (i != 2) {
                if (i == 3) {
                    float width2 = this.mFadeLength * getWidth();
                    matrix.setScale(1.0f, width2);
                    matrix.postRotate(90.0f);
                    matrix.postTranslate(getLeft(), getTop());
                    rect = new Rect(getLeft(), getTop(), (int) (getLeft() + width2), getBottom());
                }
                this.mShader.setLocalMatrix(matrix);
                this.g.setShader(this.mShader);
                ReflexMethod reflexMethod = new ReflexMethod("saveUnclippedLayer").target(canvas).setupClass(Canvas.class);
                cls = Integer.TYPE;
                num = (Integer) reflexMethod.paramClasses(cls, cls, cls, cls).params(Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.right), Integer.valueOf(rect2.bottom)).call();
                super.dispatchDraw(canvas);
                if (num != null) {
                    new ReflexMethod("restoreUnclippedLayer").target(canvas).setupClass(Canvas.class).paramClasses(cls, Paint.class).params(Integer.valueOf(num.intValue()), this.g).call();
                }
            }
            float height2 = this.mFadeLength * getHeight();
            matrix.setScale(1.0f, height2);
            matrix.postTranslate(getLeft(), getTop());
            rect = new Rect(getLeft(), getTop(), getRight(), (int) (getTop() + height2));
        }
        rect2 = rect;
        this.mShader.setLocalMatrix(matrix);
        this.g.setShader(this.mShader);
        ReflexMethod reflexMethod2 = new ReflexMethod("saveUnclippedLayer").target(canvas).setupClass(Canvas.class);
        cls = Integer.TYPE;
        num = (Integer) reflexMethod2.paramClasses(cls, cls, cls, cls).params(Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.right), Integer.valueOf(rect2.bottom)).call();
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

    public final void setFadeColor(int color) {
        Paint paint;
        PorterDuffXfermode porterDuffXfermode;
        if (color != this.mLastColor) {
            this.mLastColor = color;
            if (color != 0) {
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, color | (-16777216), color & 16777215, Shader.TileMode.CLAMP);
                this.mShader = linearGradient;
                this.g.setShader(linearGradient);
                paint = this.g;
                porterDuffXfermode = null;
            } else {
                LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, -16777216, 0, Shader.TileMode.CLAMP);
                this.mShader = linearGradient2;
                this.g.setShader(linearGradient2);
                paint = this.g;
                porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            }
            paint.setXfermode(porterDuffXfermode);
        }
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
    public FadeFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FadeFrameLayout(Context context, AttributeSet attributeSet, int i) {
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
