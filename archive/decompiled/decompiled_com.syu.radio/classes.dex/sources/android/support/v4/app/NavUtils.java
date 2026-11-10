package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.IntentCompat;
import android.util.Log;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class NavUtils {
    private static final NavUtilsImpl IMPL;
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    interface NavUtilsImpl {
        Intent getParentActivityIntent(Activity activity);

        String getParentActivityName(Context context, ActivityInfo activityInfo);

        void navigateUpTo(Activity activity, Intent intent);

        boolean shouldUpRecreateTask(Activity activity, Intent intent);
    }

    static class NavUtilsImplBase implements NavUtilsImpl {
        NavUtilsImplBase() {
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImpl
        public Intent getParentActivityIntent(Activity activity) {
            Intent parentIntent = null;
            String parentName = NavUtils.getParentActivityName(activity);
            if (parentName != null) {
                ComponentName target = new ComponentName(activity, parentName);
                try {
                    String grandparent = NavUtils.getParentActivityName(activity, target);
                    parentIntent = grandparent == null ? IntentCompat.makeMainActivity(target) : new Intent().setComponent(target);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(NavUtils.TAG, "getParentActivityIntent: bad parentActivityName '" + parentName + "' in manifest");
                }
            }
            return parentIntent;
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImpl
        public boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImpl
        public void navigateUpTo(Activity activity, Intent upIntent) {
            upIntent.addFlags(67108864);
            activity.startActivity(upIntent);
            activity.finish();
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImpl
        public String getParentActivityName(Context context, ActivityInfo info) {
            String parentActivity;
            if (info.metaData != null && (parentActivity = info.metaData.getString(NavUtils.PARENT_ACTIVITY)) != null) {
                if (parentActivity.charAt(0) == '.') {
                    return context.getPackageName() + parentActivity;
                }
                return parentActivity;
            }
            return null;
        }
    }

    static class NavUtilsImplJB extends NavUtilsImplBase {
        NavUtilsImplJB() {
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImplBase, android.support.v4.app.NavUtils.NavUtilsImpl
        public Intent getParentActivityIntent(Activity activity) {
            Intent result = NavUtilsJB.getParentActivityIntent(activity);
            if (result == null) {
                return superGetParentActivityIntent(activity);
            }
            return result;
        }

        Intent superGetParentActivityIntent(Activity activity) {
            return super.getParentActivityIntent(activity);
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImplBase, android.support.v4.app.NavUtils.NavUtilsImpl
        public boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
            return NavUtilsJB.shouldUpRecreateTask(activity, targetIntent);
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImplBase, android.support.v4.app.NavUtils.NavUtilsImpl
        public void navigateUpTo(Activity activity, Intent upIntent) {
            NavUtilsJB.navigateUpTo(activity, upIntent);
        }

        @Override // android.support.v4.app.NavUtils.NavUtilsImplBase, android.support.v4.app.NavUtils.NavUtilsImpl
        public String getParentActivityName(Context context, ActivityInfo info) {
            String result = NavUtilsJB.getParentActivityName(info);
            if (result == null) {
                return super.getParentActivityName(context, info);
            }
            return result;
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 16) {
            IMPL = new NavUtilsImplJB();
        } else {
            IMPL = new NavUtilsImplBase();
        }
    }

    public static boolean shouldUpRecreateTask(Activity sourceActivity, Intent targetIntent) {
        return IMPL.shouldUpRecreateTask(sourceActivity, targetIntent);
    }

    public static void navigateUpFromSameTask(Activity sourceActivity) {
        Intent upIntent = getParentActivityIntent(sourceActivity);
        if (upIntent == null) {
            throw new IllegalArgumentException("Activity " + sourceActivity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
        }
        navigateUpTo(sourceActivity, upIntent);
    }

    public static void navigateUpTo(Activity sourceActivity, Intent upIntent) {
        IMPL.navigateUpTo(sourceActivity, upIntent);
    }

    public static Intent getParentActivityIntent(Activity sourceActivity) {
        return IMPL.getParentActivityIntent(sourceActivity);
    }

    public static Intent getParentActivityIntent(Context context, Class<?> sourceActivityClass) throws PackageManager.NameNotFoundException {
        String parentActivity = getParentActivityName(context, new ComponentName(context, sourceActivityClass));
        if (parentActivity == null) {
            return null;
        }
        ComponentName target = new ComponentName(context, parentActivity);
        String grandparent = getParentActivityName(context, target);
        return grandparent == null ? IntentCompat.makeMainActivity(target) : new Intent().setComponent(target);
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivity = getParentActivityName(context, componentName);
        if (parentActivity == null) {
            return null;
        }
        ComponentName target = new ComponentName(componentName.getPackageName(), parentActivity);
        String grandparent = getParentActivityName(context, target);
        return grandparent == null ? IntentCompat.makeMainActivity(target) : new Intent().setComponent(target);
    }

    @Nullable
    public static String getParentActivityName(Activity sourceActivity) {
        try {
            return getParentActivityName(sourceActivity, sourceActivity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public static String getParentActivityName(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        ActivityInfo info = pm.getActivityInfo(componentName, 128);
        String parentActivity = IMPL.getParentActivityName(context, info);
        return parentActivity;
    }

    private NavUtils() {
    }
}
