package com.syu.media.companion.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import chip.FinalChip;
import com.syu.media.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaToast.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0003\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0012H\u0003J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\n\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/syu/media/companion/utils/MediaToast;", FinalChip.BSP_PLATFORM_Null, "()V", "hide", "Ljava/lang/reflect/Method;", "isShow", FinalChip.BSP_PLATFORM_Null, "mTN", "Ljava/lang/Object;", "mToken", "show", "toast", "Landroid/widget/Toast;", "tvText", "Landroid/widget/TextView;", "view", "Landroid/view/View;", "create", FinalChip.BSP_PLATFORM_Null, "context", "Landroid/content/Context;", "initTN", "makeText", "resId", FinalChip.BSP_PLATFORM_Null, "gravity", "str", FinalChip.BSP_PLATFORM_Null, "Companion", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MediaToast {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<MediaToast> me$delegate = LazyKt.lazy(new Function0<MediaToast>() { // from class: com.syu.media.companion.utils.MediaToast$Companion$me$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MediaToast m151invoke() {
            return new MediaToast();
        }
    });
    private Method hide;
    private boolean isShow;
    private Object mTN;
    private Method mToken;
    private Method show;
    private Toast toast;
    private TextView tvText;
    private View view;

    /* JADX INFO: compiled from: MediaToast.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/syu/media/companion/utils/MediaToast$Companion;", FinalChip.BSP_PLATFORM_Null, "()V", "me", "Lcom/syu/media/companion/utils/MediaToast;", "getMe", "()Lcom/syu/media/companion/utils/MediaToast;", "me$delegate", "Lkotlin/Lazy;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaToast getMe() {
            return (MediaToast) MediaToast.me$delegate.getValue();
        }
    }

    public final void create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.toast == null) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.toast_layout, (ViewGroup) null);
            this.tvText = viewInflate != null ? (TextView) viewInflate.findViewById(R.id.toast_text) : null;
            Toast toast = new Toast(context);
            toast.setView(viewInflate);
            toast.setDuration(0);
            this.toast = toast;
        }
    }

    public static /* synthetic */ void makeText$default(MediaToast mediaToast, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 17;
        }
        mediaToast.makeText(str, i);
    }

    public final void makeText(String str, int gravity) {
        Intrinsics.checkNotNullParameter(str, "str");
        TextView textView = this.tvText;
        if (textView != null) {
            textView.setText(str);
        }
        Toast toast = this.toast;
        if (toast != null) {
            toast.setGravity(gravity, 0, 0);
        }
        Toast toast2 = this.toast;
        if (toast2 != null) {
            toast2.show();
        }
    }

    public static /* synthetic */ void makeText$default(MediaToast mediaToast, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 17;
        }
        mediaToast.makeText(context, i, i2);
    }

    public final void makeText(Context context, int resId, int gravity) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        makeText(string, gravity);
    }

    public final void show() {
        if (this.isShow) {
            return;
        }
        initTN();
        try {
            Method method = this.show;
            if (method == null) {
                Intrinsics.throwUninitializedPropertyAccessException("show");
                method = null;
            }
            Object obj = this.mTN;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj = Unit.INSTANCE;
            }
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
        this.isShow = true;
    }

    public final void hide() {
        try {
            Method method = this.hide;
            if (method == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hide");
                method = null;
            }
            Object obj = this.mTN;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj = Unit.INSTANCE;
            }
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
        this.isShow = false;
    }

    private final void initTN() {
        Class<?> cls;
        try {
            Toast toast = this.toast;
            Method method = null;
            Field declaredField = (toast == null || (cls = toast.getClass()) == null) ? null : cls.getDeclaredField("mTN");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Object obj = declaredField != null ? declaredField.get(this.toast) : null;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
            }
            this.mTN = obj;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj = Unit.INSTANCE;
            }
            Method method2 = obj.getClass().getMethod("show", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method2, "mTN.javaClass.getMethod(\"show\")");
            this.show = method2;
            Object obj2 = this.mTN;
            if (obj2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj2 = Unit.INSTANCE;
            }
            Method method3 = obj2.getClass().getMethod("hide", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method3, "mTN.javaClass.getMethod(\"hide\")");
            this.hide = method3;
            StringBuilder sb = new StringBuilder("initTN:");
            Object obj3 = this.mTN;
            if (obj3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj3 = Unit.INSTANCE;
            }
            StringBuilder sbAppend = sb.append(obj3).append(",hide");
            Method method4 = this.hide;
            if (method4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hide");
            } else {
                method = method4;
            }
            Log.d("LZP", sbAppend.append(method).toString());
            Object obj4 = this.mTN;
            if (obj4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj4 = Unit.INSTANCE;
            }
            Field declaredField2 = obj4.getClass().getDeclaredField("mNextView");
            declaredField2.setAccessible(true);
            Object obj5 = this.mTN;
            if (obj5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj5 = Unit.INSTANCE;
            }
            declaredField2.set(obj5, this.view);
            int i = R.style.toastAniStyle;
            Object obj6 = this.mTN;
            if (obj6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj6 = Unit.INSTANCE;
            }
            Field declaredField3 = obj6.getClass().getDeclaredField("mParams");
            declaredField3.setAccessible(true);
            Object obj7 = this.mTN;
            if (obj7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTN");
                obj7 = Unit.INSTANCE;
            }
            Object obj8 = declaredField3.get(obj7);
            if (obj8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
            }
            ((WindowManager.LayoutParams) obj8).windowAnimations = i;
        } catch (Exception e) {
            Log.d("LZP", "initTN:" + e);
            e.printStackTrace();
        }
    }
}
