package com.syu.vdhost;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.InputEvent;
import android.view.Surface;

/**
 * Server side of {@link VdHostProtocol}: unmarshals a call and hands it to {@link VdHostCore}.
 * Not final: the Shizuku UserService in the launcher extends it.
 */
public class VdHostStub extends Binder {
    private static final String TAG = "FytVdHost";

    /** Decides which uids may use the host at all. */
    public interface CallerPolicy {
        boolean isAllowed(int uid);
    }

    private final VdHostCore mCore;
    private final CallerPolicy mPolicy;

    public VdHostStub(VdHostCore core, CallerPolicy policy) {
        mCore = core;
        mPolicy = policy;
        attachInterface(null, VdHostProtocol.DESCRIPTOR);
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (code < FIRST_CALL_TRANSACTION || code > LAST_CALL_TRANSACTION) {
            return super.onTransact(code, data, reply, flags);
        }
        data.enforceInterface(VdHostProtocol.DESCRIPTOR);
        final int uid = Binder.getCallingUid();

        if (!mPolicy.isAllowed(uid)) {
            Log.w(TAG, "rejected call " + code + " from uid " + uid);
            if (reply != null) reply.writeException(new SecurityException("uid " + uid + " may not use the VD host"));
            return true;
        }

        try {
            switch (code) {
                case VdHostProtocol.TX_GET_VERSION: {
                    reply.writeNoException();
                    reply.writeInt(VdHostProtocol.VERSION);
                    return true;
                }
                case VdHostProtocol.TX_CREATE_DISPLAY: {
                    IBinder token = data.readStrongBinder();
                    String name = data.readString();
                    int w = data.readInt();
                    int h = data.readInt();
                    int dpi = data.readInt();
                    int fl = data.readInt();
                    Surface surface = data.readTypedObject(Surface.CREATOR);
                    int id = clearIdentity(() -> mCore.createDisplay(uid, token, name, w, h, dpi, fl, surface));
                    reply.writeNoException();
                    reply.writeInt(id);
                    return true;
                }
                case VdHostProtocol.TX_RELEASE_DISPLAY: {
                    int id = data.readInt();
                    clearIdentity(() -> { mCore.releaseDisplay(uid, id); return 0; });
                    reply.writeNoException();
                    return true;
                }
                case VdHostProtocol.TX_SET_SURFACE: {
                    int id = data.readInt();
                    Surface surface = data.readTypedObject(Surface.CREATOR);
                    clearIdentity(() -> { mCore.setSurface(uid, id, surface); return 0; });
                    reply.writeNoException();
                    return true;
                }
                case VdHostProtocol.TX_RESIZE: {
                    int id = data.readInt();
                    int w = data.readInt();
                    int h = data.readInt();
                    int dpi = data.readInt();
                    clearIdentity(() -> { mCore.resize(uid, id, w, h, dpi); return 0; });
                    reply.writeNoException();
                    return true;
                }
                case VdHostProtocol.TX_SET_STATE: {
                    int id = data.readInt();
                    boolean on = data.readInt() != 0;
                    clearIdentity(() -> { mCore.setDisplayState(uid, id, on); return 0; });
                    reply.writeNoException();
                    return true;
                }
                case VdHostProtocol.TX_INJECT_INPUT: {
                    int id = data.readInt();
                    InputEvent event = data.readTypedObject(InputEvent.CREATOR);
                    clearIdentity(() -> { mCore.injectInput(uid, id, event); return 0; });
                    return true;
                }
                case VdHostProtocol.TX_START_ACTIVITY: {
                    int id = data.readInt();
                    Intent intent = data.readTypedObject(Intent.CREATOR);
                    Bundle options = data.readTypedObject(Bundle.CREATOR);
                    int res = clearIdentity(() -> mCore.startActivity(uid, id, intent, options));
                    reply.writeNoException();
                    reply.writeInt(res);
                    return true;
                }
                case VdHostProtocol.TX_GET_TASK_COUNT: {
                    int id = data.readInt();
                    int res = clearIdentity(() -> mCore.getTaskCount(uid, id));
                    reply.writeNoException();
                    reply.writeInt(res);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "call " + code + " failed", e);
            if (reply == null || (flags & FLAG_ONEWAY) != 0) return true;
            // Parcel.writeException() only knows a handful of types; keep the message, not the type.
            RuntimeException out = (e instanceof SecurityException
                    || e instanceof IllegalArgumentException
                    || e instanceof IllegalStateException) ? e : new IllegalStateException(String.valueOf(e));
            reply.writeException(out);
            return true;
        }
    }

    private interface IntCall {
        int run();
    }

    /**
     * Calls into the system as this process, not as the client. In the daemon that changes
     * nothing (the client is another process anyway); in-process it matters when the launcher
     * calls its own stub from a binder thread.
     */
    private static int clearIdentity(IntCall call) {
        long ident = Binder.clearCallingIdentity();
        try {
            return call.run();
        } finally {
            Binder.restoreCallingIdentity(ident);
        }
    }
}
