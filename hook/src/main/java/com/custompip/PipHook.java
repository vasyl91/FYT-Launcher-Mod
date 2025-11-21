package com.custompip;

import android.os.SystemProperties;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class PipHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        // Hook will apply only for the front app
        if ("com.android.launcher66".equals(lpparam.packageName)) {
            return; 
        }

        String pipAppPackageName = SystemProperties.get("persist.launcher.packagename", "");
        if (pipAppPackageName.isEmpty() || !pipAppPackageName.equals(lpparam.packageName)) {
            return;
        }

        if (!"com.google.android.apps.maps".equals(lpparam.packageName)) {
            return;
        }
        
        XposedBridge.log("PipHook: Hook active for " + lpparam.packageName);

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "enterPictureInPictureMode",
                XC_MethodReplacement.returnConstant(false)
            );
            XposedBridge.log("PipHook: Hooked enterPictureInPictureMode()");
        } catch (Throwable t) {
            XposedBridge.log("PipHook: Failed hooking enterPictureInPictureMode: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "onPictureInPictureRequested",
                XC_MethodReplacement.returnConstant(false)
            );
            XposedBridge.log("PipHook: Hooked onPictureInPictureRequested()");
        } catch (Throwable t) {
            XposedBridge.log("PipHook: Failed hooking onPictureInPictureRequested: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "isInPictureInPictureMode",
                XC_MethodReplacement.returnConstant(false)
            );
            XposedBridge.log("PipHook: Hooked isInPictureInPictureMode()");
        } catch (Throwable t) {
            XposedBridge.log("PipHook: Failed hooking isInPictureInPictureMode: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "onPictureInPictureModeChanged",
                boolean.class,
                XC_MethodReplacement.DO_NOTHING
            );
            XposedBridge.log("PipHook: Hooked onPictureInPictureModeChanged()");
        } catch (Throwable t) {
            XposedBridge.log("PipHook: Failed hooking onPictureInPictureModeChanged: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "onUserLeaveHint",
                XC_MethodReplacement.DO_NOTHING
            );
            XposedBridge.log("PipHook: Hooked onUserLeaveHint()");
        } catch (Throwable t) {
            XposedBridge.log("PipHook: Failed hooking onUserLeaveHint: " + t);
        }
    }
}