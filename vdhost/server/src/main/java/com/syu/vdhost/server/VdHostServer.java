package com.syu.vdhost.server;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

import com.syu.vdhost.VdHostCore;
import com.syu.vdhost.VdHostProtocol;
import com.syu.vdhost.VdHostStub;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Entry point of the VD host daemon. Started by the Magisk module's service.sh:
 *
 *   su 1000 -c "CLASSPATH=vdhost.apk app_process /system/bin com.syu.vdhost.server.VdHostServer
 *               --package com.android.launcher66"
 *
 * It has to run as uid 1000. DisplayManagerService checks the package name of every
 * createVirtualDisplay() caller, and before Android 14 root has no package that passes; as
 * system it also holds INTERNAL_SYSTEM_WINDOW, INJECT_EVENTS and ADD_TRUSTED_DISPLAY.
 */
public final class VdHostServer {
    private static final String TAG = "FytVdHost";

    private VdHostServer() {}

    /**
     * Deprecated for apps (the system makes their main looper), but a process started by
     * app_process has none: the system context and the framework's handlers need it.
     */
    @SuppressWarnings("deprecation")
    private static void prepareMainLooper() {
        Looper.prepareMainLooper();
    }

    public static void main(String[] args) {
        List<String> packages = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if ("--package".equals(args[i]) && i + 1 < args.length) packages.add(args[++i]);
        }
        if (packages.isEmpty()) packages.add("com.android.launcher66");

        log("starting: uid=" + Process.myUid() + " pid=" + Process.myPid()
                + " sdk=" + android.os.Build.VERSION.SDK_INT + " packages=" + packages
                + " protocol=" + VdHostProtocol.VERSION);
        if (Process.myUid() != 1000) {
            log("WARNING: not running as uid 1000 -- createVirtualDisplay() is likely to be refused");
        }

        prepareMainLooper();

        final Context context;
        final VdHostCore core;
        try {
            context = createSystemContext();
            core = new VdHostCore(context);
        } catch (Throwable t) {
            log("cannot initialise: " + Log.getStackTraceString(t));
            System.exit(1);
            return;
        }

        // Uids of the launcher processes we delivered to, plus root and system.
        final Set<Integer> allowed = ConcurrentHashMap.newKeySet();
        allowed.add(0);
        allowed.add(1000);
        allowed.add(Process.myUid());

        VdHostStub stub = new VdHostStub(core, allowed::contains);
        BinderDelivery delivery = new BinderDelivery(stub, packages, context.getPackageName(), allowed::add);
        delivery.start();

        Runtime.getRuntime().addShutdownHook(new Thread(core::releaseAll));
        log("ready");
        Looper.loop();
    }

    /**
     * A Context for a process that was not forked from zygote, as scrcpy does it: an ActivityThread
     * that believes it is the system thread, and its system context (package "android").
     */
    private static Context createSystemContext() throws ReflectiveOperationException {
        Class<?> atClass = Class.forName("android.app.ActivityThread");
        Constructor<?> ctor = atClass.getDeclaredConstructor();
        ctor.setAccessible(true);
        Object thread = ctor.newInstance();

        Field current = atClass.getDeclaredField("sCurrentActivityThread");
        current.setAccessible(true);
        current.set(null, thread);

        Field systemThread = atClass.getDeclaredField("mSystemThread");
        systemThread.setAccessible(true);
        systemThread.setBoolean(thread, true);

        Method getSystemContext = atClass.getDeclaredMethod("getSystemContext");
        return (Context) getSystemContext.invoke(thread);
    }

    static void log(String msg) {
        Log.i(TAG, msg);
        System.out.println(TAG + ": " + msg);
    }
}
