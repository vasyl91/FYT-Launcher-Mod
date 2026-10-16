package com.syu.vdhost;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.InputEvent;
import android.view.Surface;

/**
 * Binder protocol between the launcher and the VD host.
 *
 * Hand-written instead of AIDL so the daemon builds from plain javac + d8, and so both sides can
 * never disagree about transaction codes: there is exactly one copy of them.
 *
 * The host owns VirtualDisplays that render into a Surface handed over by the launcher (the
 * SurfaceView of a pane), starts activities on them and injects the pane's touches into them.
 * Those three things need INTERNAL_SYSTEM_WINDOW, INJECT_EVENTS and ADD_TRUSTED_DISPLAY, which an
 * app cannot be granted, so on Android 11+ they run either in the Magisk daemon (uid 1000) or
 * in-process when the launcher itself is android.uid.system.
 */
public final class VdHostProtocol {
    private VdHostProtocol() {}

    public static final String DESCRIPTOR = "com.syu.vdhost.IVdHost";
    public static final int VERSION = 1;

    static final int TX_GET_VERSION      = IBinder.FIRST_CALL_TRANSACTION;
    static final int TX_CREATE_DISPLAY   = IBinder.FIRST_CALL_TRANSACTION + 1;
    static final int TX_RELEASE_DISPLAY  = IBinder.FIRST_CALL_TRANSACTION + 2;
    static final int TX_SET_SURFACE      = IBinder.FIRST_CALL_TRANSACTION + 3;
    static final int TX_RESIZE           = IBinder.FIRST_CALL_TRANSACTION + 4;
    static final int TX_SET_STATE        = IBinder.FIRST_CALL_TRANSACTION + 5;
    static final int TX_INJECT_INPUT     = IBinder.FIRST_CALL_TRANSACTION + 6;   // oneway
    static final int TX_START_ACTIVITY   = IBinder.FIRST_CALL_TRANSACTION + 7;
    static final int TX_GET_TASK_COUNT   = IBinder.FIRST_CALL_TRANSACTION + 8;
    static final int TX_COMPILE_PACKAGE  = IBinder.FIRST_CALL_TRANSACTION + 9;
    static final int TX_CLEAR_PROFILES   = IBinder.FIRST_CALL_TRANSACTION + 10;
    static final int TX_GET_HOST_UID     = IBinder.FIRST_CALL_TRANSACTION + 11;
    static final int TX_EXEC             = IBinder.FIRST_CALL_TRANSACTION + 12;
    static final int TX_SEND_BOOT_COMPLETED = IBinder.FIRST_CALL_TRANSACTION + 13;
    static final int TX_WATCH_FOREGROUND = IBinder.FIRST_CALL_TRANSACTION + 14;
    static final int TX_ALLOW_WRITE_SETTINGS = IBinder.FIRST_CALL_TRANSACTION + 15;

    /** The handle exec() returns: waitFor() (blocking, the exit code), destroy(). */
    static final int EXEC_WAIT_FOR = IBinder.FIRST_CALL_TRANSACTION;
    static final int EXEC_DESTROY  = IBinder.FIRST_CALL_TRANSACTION + 1;

    /** What watchForeground()'s callback gets: one-way, the package in front as a String. */
    public static final int FOREGROUND_CHANGED = IBinder.FIRST_CALL_TRANSACTION;

    /** Set to "1" by the Magisk module (system.prop), so the launcher knows a daemon is coming. */
    public static final String PROP_MODULE = "ro.fyt.vdhost";

    /** The daemon hands its binder to the launcher through this provider: authority = package + suffix. */
    public static final String AUTHORITY_SUFFIX = ".vdhost";
    public static final String METHOD_ATTACH = "attach";
    public static final String KEY_BINDER = "binder";
    public static final String KEY_VERSION = "version";
    public static final String KEY_ACCEPTED = "accepted";

    // DisplayManager.VIRTUAL_DISPLAY_FLAG_* -- several of them are @hide.
    public static final int VD_FLAG_PUBLIC                     = 1;
    public static final int VD_FLAG_SECURE                     = 1 << 2;
    public static final int VD_FLAG_OWN_CONTENT_ONLY           = 1 << 3;
    public static final int VD_FLAG_SUPPORTS_TOUCH             = 1 << 6;
    public static final int VD_FLAG_DESTROY_CONTENT_ON_REMOVAL = 1 << 8;
    /** Android 11+. IME, focus and launches by other apps behave as on a real display. */
    public static final int VD_FLAG_TRUSTED                    = 1 << 10;
    /** Android 13+. The keyguard is never shown on the display. */
    public static final int VD_FLAG_ALWAYS_UNLOCKED            = 1 << 12;

    /**
     * PUBLIC: the launcher can read the Display (size checks) and start activities on it itself.
     * OWN_CONTENT_ONLY keeps it from mirroring the main screen. SECURE lets FLAG_SECURE apps render.
     * The host drops the flags its Android version does not know.
     */
    public static final int DEFAULT_FLAGS = VD_FLAG_PUBLIC
            | VD_FLAG_SECURE
            | VD_FLAG_OWN_CONTENT_ONLY
            | VD_FLAG_SUPPORTS_TOUCH
            | VD_FLAG_DESTROY_CONTENT_ON_REMOVAL
            | VD_FLAG_TRUSTED
            | VD_FLAG_ALWAYS_UNLOCKED;

    /** Client side of the protocol. Every call is a blocking binder call except injectInput(). */
    public static final class Proxy {
        private final IBinder mRemote;

        public Proxy(IBinder remote) {
            mRemote = remote;
        }

        public IBinder asBinder() {
            return mRemote;
        }

        public int getVersion() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TX_GET_VERSION, data, reply, 0);
                reply.readException();
                return reply.readInt();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        /**
         * @param clientToken any Binder owned by the caller: when its process dies, the host
         *                    releases every display created with it
         * @return the new display id
         */
        public int createDisplay(IBinder clientToken, String name, int width, int height,
                                 int densityDpi, int flags, Surface surface) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeStrongBinder(clientToken);
                data.writeString(name);
                data.writeInt(width);
                data.writeInt(height);
                data.writeInt(densityDpi);
                data.writeInt(flags);
                data.writeTypedObject(surface, 0);
                mRemote.transact(TX_CREATE_DISPLAY, data, reply, 0);
                reply.readException();
                return reply.readInt();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        public void releaseDisplay(int displayId) throws RemoteException {
            simpleCall(TX_RELEASE_DISPLAY, displayId, 0, 0, 0);
        }

        /** null detaches the display from any surface; the display keeps running. */
        public void setSurface(int displayId, Surface surface) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeInt(displayId);
                data.writeTypedObject(surface, 0);
                mRemote.transact(TX_SET_SURFACE, data, reply, 0);
                reply.readException();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        public void resize(int displayId, int width, int height, int densityDpi) throws RemoteException {
            simpleCall(TX_RESIZE, displayId, width, height, densityDpi);
        }

        public void setDisplayState(int displayId, boolean on) throws RemoteException {
            simpleCall(TX_SET_STATE, displayId, on ? 1 : 0, 0, 0);
        }

        /**
         * One-way: touches must not wait for the host. Binder keeps one-way calls to the same
         * object in order, so a gesture arrives in sequence.
         */
        public void injectInput(int displayId, InputEvent event) throws RemoteException {
            Parcel data = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeInt(displayId);
                data.writeTypedObject(event, 0);
                mRemote.transact(TX_INJECT_INPUT, data, null, IBinder.FLAG_ONEWAY);
            } finally {
                data.recycle();
            }
        }

        /** @return the ActivityManager start result: >= 0 on success */
        public int startActivity(int displayId, Intent intent, Bundle options) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeInt(displayId);
                data.writeTypedObject(intent, 0);
                data.writeTypedObject(options, 0);
                mRemote.transact(TX_START_ACTIVITY, data, reply, 0);
                reply.readException();
                return reply.readInt();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        /** @return how many tasks the display hosts, or -1 when the host cannot tell */
        public int getTaskCount(int displayId) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeInt(displayId);
                mRemote.transact(TX_GET_TASK_COUNT, data, reply, 0);
                reply.readException();
                return reply.readInt();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        /**
         * Compiles one of the caller's own packages with its profile, as "adb shell cmd package
         * compile -m speed-profile -f" does. Blocks until the compilation is over: tens of seconds.
         *
         * @return the host's report, starting with "OK" on success
         */
        public String compilePackage(String packageName) throws RemoteException {
            return packageCall(TX_COMPILE_PACKAGE, packageName);
        }

        /**
         * Drops the ART profiles of one of the caller's packages: what ART recorded and the
         * Baseline Profile written from the APK. Depending on the host this stops the package.
         *
         * @return the host's report, starting with "OK" on success
         */
        public String clearProfiles(String packageName) throws RemoteException {
            return packageCall(TX_CLEAR_PROFILES, packageName);
        }

        /** The uid the host runs as: 1000 (daemon), 2000 (Shizuku over ADB) or 0 (Shizuku with root). */
        public int getHostUid() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TX_GET_HOST_UID, data, reply, 0);
                reply.readException();
                return reply.readInt();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        /**
         * Runs a command as the host, its output (stderr included) going into out, which the host
         * closes when the command ends. Only reading the logs (logcat) and setting logd's buffer
         * sizes (logcat -G, setprop persist.logd.size*) are allowed. Closing the reading end of the pipe, or
         * the death of clientToken's process, ends the command.
         */
        public ExecHandle exec(String[] argv, ParcelFileDescriptor out, IBinder clientToken)
                throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeStringArray(argv);
                data.writeTypedObject(out, 0);
                data.writeStrongBinder(clientToken);
                mRemote.transact(TX_EXEC, data, reply, 0);
                reply.readException();
                return new ExecHandle(reply.readStrongBinder());
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        /**
         * Sends BOOT_COMPLETED to one package, as the launcher's boot autostart does as system.
         *
         * @return the host's report, "OK ..." on success; "UNSUPPORTED ..." for Shizuku over ADB,
         *         as shell may not send that broadcast
         */
        public String sendBootCompleted(String packageName) throws RemoteException {
            return packageCall(TX_SEND_BOOT_COMPLETED, packageName);
        }

        /** Lets the caller's package write the system settings (the WRITE_SETTINGS app op). */
        public String allowWriteSettings(String packageName) throws RemoteException {
            return packageCall(TX_ALLOW_WRITE_SETTINGS, packageName);
        }

        /**
         * The host reports the app in front on the main display to callback whenever it changes
         * (FOREGROUND_CHANGED), until callback's process dies.
         */
        public void watchForeground(IBinder callback) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeStrongBinder(callback);
                mRemote.transact(TX_WATCH_FOREGROUND, data, reply, 0);
                reply.readException();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        private String packageCall(int code, String packageName) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeString(packageName);
                mRemote.transact(code, data, reply, 0);
                reply.readException();
                return reply.readString();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        private void simpleCall(int code, int a, int b, int c, int d) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeInt(a);
                data.writeInt(b);
                data.writeInt(c);
                data.writeInt(d);
                mRemote.transact(code, data, reply, 0);
                reply.readException();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }
    }

    /** The client side of a command exec() started. */
    public static final class ExecHandle {
        private final IBinder mRemote;

        ExecHandle(IBinder remote) {
            mRemote = remote;
        }

        /** Blocks until the command ends. @return its exit code */
        public int waitFor() throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                mRemote.transact(EXEC_WAIT_FOR, data, reply, 0);
                return reply.readInt();
            } finally {
                reply.recycle();
                data.recycle();
            }
        }

        public void destroy() throws RemoteException {
            Parcel data = Parcel.obtain();
            try {
                mRemote.transact(EXEC_DESTROY, data, null, IBinder.FLAG_ONEWAY);
            } finally {
                data.recycle();
            }
        }
    }
}
