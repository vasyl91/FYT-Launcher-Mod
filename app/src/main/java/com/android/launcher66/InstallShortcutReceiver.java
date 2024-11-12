package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class InstallShortcutReceiver extends BroadcastReceiver {
    public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static final String APPS_PENDING_INSTALL = "apps_to_install";
    public static final String DATA_INTENT_KEY = "intent.data";
    private static final boolean DBG = false;
    public static final String ICON_KEY = "icon";
    public static final String ICON_RESOURCE_NAME_KEY = "iconResource";
    public static final String ICON_RESOURCE_PACKAGE_NAME_KEY = "iconResourcePackage";
    private static final int INSTALL_SHORTCUT_IS_DUPLICATE = -1;
    private static final int INSTALL_SHORTCUT_SUCCESSFUL = 0;
    public static final String LAUNCH_INTENT_KEY = "intent.launch";
    public static final String NAME_KEY = "name";
    public static final int NEW_SHORTCUT_BOUNCE_DURATION = 450;
    public static final int NEW_SHORTCUT_STAGGER_DELAY = 85;
    public static final String SHORTCUT_MIMETYPE = "com.android.launcher66/shortcut";
    private static final String TAG = "InstallShortcutReceiver";
    private static Object sLock = new Object();
    private static boolean mUseInstallQueue = false;

    private static void addToStringSet(SharedPreferences sharedPrefs, SharedPreferences.Editor editor, String key, String value) {
        Set<String> strings;
        Set<String> strings2 = sharedPrefs.getStringSet(key, null);
        if (strings2 == null) {
            strings = new HashSet<>(0);
        } else {
            strings = new HashSet<>(strings2);
        }
        strings.add(value);
        editor.putStringSet(key, strings);
    }

    private static void addToInstallQueue(SharedPreferences sharedPrefs, PendingInstallShortcutInfo info) {
        synchronized (sLock) {
            try {
                JSONStringer json = new JSONStringer().object().key(DATA_INTENT_KEY).value(info.data.toUri(0)).key(LAUNCH_INTENT_KEY).value(info.launchIntent.toUri(0)).key("name").value(info.name);
                if (info.icon != null) {
                    byte[] iconByteArray = ItemInfo.flattenBitmap(info.icon);
                    json = json.key("icon").value(Base64.encodeToString(iconByteArray, 0, iconByteArray.length, 0));
                }
                if (info.iconResource != null) {
                    json = json.key("iconResource").value(info.iconResource.resourceName).key(ICON_RESOURCE_PACKAGE_NAME_KEY).value(info.iconResource.packageName);
                }
                JSONStringer json2 = json.endObject();
                SharedPreferences.Editor editor = sharedPrefs.edit();
                addToStringSet(sharedPrefs, editor, APPS_PENDING_INSTALL, json2.toString());
                editor.commit();
            } catch (JSONException e) {
                Log.d(TAG, "Exception when adding shortcut: " + e);
            }
        }
    }

    public static void removeFromInstallQueue(SharedPreferences sharedPrefs, ArrayList<String> packageNames) {
        synchronized (sLock) {
            Set<String> strings = sharedPrefs.getStringSet(APPS_PENDING_INSTALL, null);
            if (strings != null) {
                Set<String> newStrings = new HashSet<>(strings);
                Iterator<String> newStringsIter = newStrings.iterator();
                while (newStringsIter.hasNext()) {
                    String json = newStringsIter.next();
                    try {
                        JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
                        Intent launchIntent = Intent.parseUri(object.getString(LAUNCH_INTENT_KEY), 0);
                        String pn = launchIntent.getPackage();
                        if (pn == null) {
                            pn = launchIntent.getComponent().getPackageName();
                        }
                        if (packageNames.contains(pn)) {
                            newStringsIter.remove();
                        }
                    } catch (URISyntaxException e) {
                        Log.d(TAG, "Exception reading shortcut to remove: " + e);
                    } catch (JSONException e2) {
                        Log.d(TAG, "Exception reading shortcut to remove: " + e2);
                    }
                }
                sharedPrefs.edit().putStringSet(APPS_PENDING_INSTALL, new HashSet(newStrings)).commit();
            }
        }
    }

    private static ArrayList<PendingInstallShortcutInfo> getAndClearInstallQueue(SharedPreferences sharedPrefs) {
        ArrayList<PendingInstallShortcutInfo> infos;
        synchronized (sLock) {
            Set<String> strings = sharedPrefs.getStringSet(APPS_PENDING_INSTALL, null);
            if (strings == null) {
                infos = new ArrayList<>();
            } else {
                infos = new ArrayList<>();
                for (String json : strings) {
                    try {
                        try {
                            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
                            Intent data = Intent.parseUri(object.getString(DATA_INTENT_KEY), 0);
                            Intent launchIntent = Intent.parseUri(object.getString(LAUNCH_INTENT_KEY), 0);
                            String name = object.getString("name");
                            String iconBase64 = object.optString("icon");
                            String iconResourceName = object.optString("iconResource");
                            String iconResourcePackageName = object.optString(ICON_RESOURCE_PACKAGE_NAME_KEY);
                            if (iconBase64 != null && !iconBase64.isEmpty()) {
                                byte[] iconArray = Base64.decode(iconBase64, 0);
                                Bitmap b = BitmapFactory.decodeByteArray(iconArray, 0, iconArray.length);
                                data.putExtra("android.intent.extra.shortcut.ICON", b);
                            } else if (iconResourceName != null && !iconResourceName.isEmpty()) {
                                Intent.ShortcutIconResource iconResource = new Intent.ShortcutIconResource();
                                iconResource.resourceName = iconResourceName;
                                iconResource.packageName = iconResourcePackageName;
                                data.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", iconResource);
                            }
                            data.putExtra("android.intent.extra.shortcut.INTENT", launchIntent);
                            PendingInstallShortcutInfo info = new PendingInstallShortcutInfo(data, name, launchIntent);
                            infos.add(info);
                        } catch (JSONException e) {
                            Log.d(TAG, "Exception reading shortcut to add: " + e);
                        }
                    } catch (URISyntaxException e2) {
                        Log.d(TAG, "Exception reading shortcut to add: " + e2);
                    }
                }
                sharedPrefs.edit().putStringSet(APPS_PENDING_INSTALL, new HashSet()).commit();
            }
        }
        return infos;
    }

    private static class PendingInstallShortcutInfo {
        Intent data;
        Bitmap icon;
        Intent.ShortcutIconResource iconResource;
        Intent launchIntent;
        String name;

        public PendingInstallShortcutInfo(Intent rawData, String shortcutName, Intent shortcutIntent) {
            this.data = rawData;
            this.name = shortcutName;
            this.launchIntent = shortcutIntent;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent data) {
        Intent intent;
        if (ACTION_INSTALL_SHORTCUT.equals(data.getAction()) && (intent = (Intent) data.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
            String name = data.getStringExtra("android.intent.extra.shortcut.NAME");
            if (name == null) {
                try {
                    PackageManager pm = context.getPackageManager();
                    name = pm.getActivityInfo(intent.getComponent(), 0).loadLabel(pm).toString();
                } catch (PackageManager.NameNotFoundException e) {
                    return;
                }
            }
            Bitmap icon = (Bitmap) data.getParcelableExtra("android.intent.extra.shortcut.ICON");
            Intent.ShortcutIconResource iconResource = (Intent.ShortcutIconResource) data.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
            LauncherAppState.setApplicationContext(context.getApplicationContext());
            LauncherAppState app = LauncherAppState.getInstance();
            boolean launcherNotLoaded = app.getDynamicGrid() == null;
            PendingInstallShortcutInfo info = new PendingInstallShortcutInfo(data, name, intent);
            info.icon = icon;
            info.iconResource = iconResource;
            String spKey = LauncherAppState.getSharedPreferencesKey();
            SharedPreferences sp = context.getSharedPreferences(spKey, 0);
            addToInstallQueue(sp, info);
            if (!mUseInstallQueue && !launcherNotLoaded) {
                flushInstallQueue(context);
            }
        }
    }

    static void enableInstallQueue() {
        mUseInstallQueue = true;
    }

    static void disableAndFlushInstallQueue(Context context) {
        mUseInstallQueue = false;
        flushInstallQueue(context);
    }

    static void flushInstallQueue(Context context) {
        String spKey = LauncherAppState.getSharedPreferencesKey();
        SharedPreferences sp = context.getSharedPreferences(spKey, 0);
        ArrayList<PendingInstallShortcutInfo> installQueue = getAndClearInstallQueue(sp);
        if (!installQueue.isEmpty()) {
            Iterator<PendingInstallShortcutInfo> iter = installQueue.iterator();
            ArrayList<ItemInfo> addShortcuts = new ArrayList<>();
            while (iter.hasNext()) {
                PendingInstallShortcutInfo pendingInfo = iter.next();
                Intent intent = pendingInfo.launchIntent;
                String name = pendingInfo.name;
                boolean exists = LauncherModel.shortcutExists(context, name, intent);
                if (!exists) {
                    ShortcutInfo info = getShortcutInfo(context, pendingInfo.data, pendingInfo.launchIntent);
                    addShortcuts.add(info);
                }
            }
            if (0 == -1) {
                Toast.makeText(context, context.getString(R.string.shortcut_duplicate, ""), Toast.LENGTH_SHORT).show();
            }
            if (!addShortcuts.isEmpty()) {
                LauncherAppState app = LauncherAppState.getInstance();
                app.getModel().addAndBindAddedApps(context, addShortcuts, null);
            }
        }
    }

    private static ShortcutInfo getShortcutInfo(Context context, Intent data, Intent launchIntent) {
        if (launchIntent.getAction() == null) {
            launchIntent.setAction("android.intent.action.VIEW");
        } else if (launchIntent.getAction().equals("android.intent.action.MAIN") && launchIntent.getCategories() != null && launchIntent.getCategories().contains("android.intent.category.LAUNCHER")) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        }
        LauncherAppState app = LauncherAppState.getInstance();
        return app.getModel().infoFromShortcutIntent(context, data, null);
    }
}
