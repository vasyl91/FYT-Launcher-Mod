package qin.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010$JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004JJ\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lqin/widgets/NumberView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "number", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "num", "", "prefix", "Landroid/graphics/drawable/Drawable;", "dawable", "", "setupNumber", "setNumberDrawable", "a", "I", "getNumber", "()I", "setNumber", "(I)V", "b", "Ljava/lang/String;", "getNumberPrefix", "()Ljava/lang/String;", "setNumberPrefix", "(Ljava/lang/String;)V", "numberPrefix", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Components_release"}, k = 1, mv = {1, 7, 1})
public final class NumberView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public int number;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String numberPrefix;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumberView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setNumberDrawable$default(NumberView numberView, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = null;
        }
        numberView.setNumberDrawable(i, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setupNumber$default(NumberView numberView, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = null;
        }
        numberView.setupNumber(i, function2);
    }

    public final int getNumber() {
        return this.number;
    }

    public final String getNumberPrefix() {
        return this.numberPrefix;
    }

    public final void setNumber(int i) {
        this.number = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setNumberDrawable(int number, Function2<? super Integer, ? super String, ? extends Drawable> dawable) {
        Drawable drawable;
        if (dawable != null) {
            drawable = (Drawable) dawable.invoke(Integer.valueOf(number), this.numberPrefix);
        } else {
            int identifier = getResources().getIdentifier(this.numberPrefix + number, "drawable", getContext().getPackageName());
            Log.e("smart", this.numberPrefix + number + "  - " + identifier);
            drawable = getResources().getDrawable(identifier, null);
        }
        if (drawable != null) {
            setImageDrawable(drawable);
        }
    }

    public final void setNumberPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.numberPrefix = str;
    }

    public final void setupNumber(int number, Function2<? super Integer, ? super String, ? extends Drawable> dawable) {
        Log.e("smart", "setupNumber  - this.number : " + this.number + "  " + number);
        if (this.number != number) {
            this.number = number;
            setNumberDrawable(number, dawable);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.numberPrefix = "";
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.NumberView, i, 0);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.NumberView_number_prefix);
        this.numberPrefix = string != null ? string : "";
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.NumberView_number, 0);
        this.number = i2;
        if (!(i2 >= 0 && i2 < 10)) {
            this.number = 0;
        }
        setNumberDrawable$default(this, this.number, null, 2, null);
        typedArrayObtainStyledAttributes.recycle();
    }
}
