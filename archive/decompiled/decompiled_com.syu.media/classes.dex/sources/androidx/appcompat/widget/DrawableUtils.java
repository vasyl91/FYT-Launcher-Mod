package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();

    private DrawableUtils() {
    }

    public static Rect getOpticalBounds(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = Api29Impl.getOpticalInsets(drawable);
            return new Rect(opticalInsets.left, opticalInsets.top, opticalInsets.right, opticalInsets.bottom);
        }
        return Api18Impl.getOpticalInsets(DrawableCompat.unwrap(drawable));
    }

    static void fixDrawable(Drawable drawable) {
        String name = drawable.getClass().getName();
        if (Build.VERSION.SDK_INT < 29 || Build.VERSION.SDK_INT >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        forceDrawableStateChange(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(Drawable drawable) {
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!canSafelyMutateDrawable(drawable2)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof WrappedDrawable) {
            return canSafelyMutateDrawable(((WrappedDrawable) drawable).getWrappedDrawable());
        }
        if (drawable instanceof DrawableWrapper) {
            return canSafelyMutateDrawable(((DrawableWrapper) drawable).getWrappedDrawable());
        }
        if (drawable instanceof ScaleDrawable) {
            return canSafelyMutateDrawable(((ScaleDrawable) drawable).getDrawable());
        }
        return true;
    }

    private static void forceDrawableStateChange(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(CHECKED_STATE_SET);
        } else {
            drawable.setState(EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    static class Api18Impl {
        private static final Field sBottom;
        private static final Method sGetOpticalInsets;
        private static final Field sLeft;
        private static final boolean sReflectionSuccessful;
        private static final Field sRight;
        private static final Field sTop;

        /* JADX WARN: Code duplicated, block: B:25:0x004b  */
        /* JADX WARN: Code duplicated, block: B:26:0x0058  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z;
            try {
                Class<?> cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
                try {
                    field = cls.getField("left");
                    try {
                        field2 = cls.getField("top");
                        try {
                            field3 = cls.getField("right");
                            try {
                                field4 = cls.getField("bottom");
                                z = true;
                            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused) {
                                field4 = null;
                                z = false;
                            }
                        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                            field3 = null;
                        }
                    } catch (ClassNotFoundException unused3) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z = false;
                        if (z) {
                            sGetOpticalInsets = method;
                            sLeft = field;
                            sTop = field2;
                            sRight = field3;
                            sBottom = field4;
                            sReflectionSuccessful = true;
                            return;
                        }
                        sGetOpticalInsets = null;
                        sLeft = null;
                        sTop = null;
                        sRight = null;
                        sBottom = null;
                        sReflectionSuccessful = false;
                    } catch (NoSuchFieldException unused4) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z = false;
                        if (z) {
                            sGetOpticalInsets = method;
                            sLeft = field;
                            sTop = field2;
                            sRight = field3;
                            sBottom = field4;
                            sReflectionSuccessful = true;
                            return;
                        }
                        sGetOpticalInsets = null;
                        sLeft = null;
                        sTop = null;
                        sRight = null;
                        sBottom = null;
                        sReflectionSuccessful = false;
                    } catch (NoSuchMethodException unused5) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z = false;
                        if (z) {
                            sGetOpticalInsets = method;
                            sLeft = field;
                            sTop = field2;
                            sRight = field3;
                            sBottom = field4;
                            sReflectionSuccessful = true;
                            return;
                        }
                        sGetOpticalInsets = null;
                        sLeft = null;
                        sTop = null;
                        sRight = null;
                        sBottom = null;
                        sReflectionSuccessful = false;
                    }
                } catch (ClassNotFoundException unused6) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (z) {
                        sGetOpticalInsets = method;
                        sLeft = field;
                        sTop = field2;
                        sRight = field3;
                        sBottom = field4;
                        sReflectionSuccessful = true;
                        return;
                    }
                    sGetOpticalInsets = null;
                    sLeft = null;
                    sTop = null;
                    sRight = null;
                    sBottom = null;
                    sReflectionSuccessful = false;
                } catch (NoSuchFieldException unused7) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (z) {
                        sGetOpticalInsets = method;
                        sLeft = field;
                        sTop = field2;
                        sRight = field3;
                        sBottom = field4;
                        sReflectionSuccessful = true;
                        return;
                    }
                    sGetOpticalInsets = null;
                    sLeft = null;
                    sTop = null;
                    sRight = null;
                    sBottom = null;
                    sReflectionSuccessful = false;
                } catch (NoSuchMethodException unused8) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (z) {
                        sGetOpticalInsets = method;
                        sLeft = field;
                        sTop = field2;
                        sRight = field3;
                        sBottom = field4;
                        sReflectionSuccessful = true;
                        return;
                    }
                    sGetOpticalInsets = null;
                    sLeft = null;
                    sTop = null;
                    sRight = null;
                    sBottom = null;
                    sReflectionSuccessful = false;
                }
            } catch (ClassNotFoundException unused9) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused10) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused11) {
                method = null;
                field = null;
            }
            if (z) {
                sGetOpticalInsets = method;
                sLeft = field;
                sTop = field2;
                sRight = field3;
                sBottom = field4;
                sReflectionSuccessful = true;
                return;
            }
            sGetOpticalInsets = null;
            sLeft = null;
            sTop = null;
            sRight = null;
            sBottom = null;
            sReflectionSuccessful = false;
        }

        private Api18Impl() {
        }

        static Rect getOpticalInsets(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && sReflectionSuccessful) {
                try {
                    Object objInvoke = sGetOpticalInsets.invoke(drawable, new Object[0]);
                    if (objInvoke != null) {
                        return new Rect(sLeft.getInt(objInvoke), sTop.getInt(objInvoke), sRight.getInt(objInvoke), sBottom.getInt(objInvoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.INSETS_NONE;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets getOpticalInsets(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }
}
