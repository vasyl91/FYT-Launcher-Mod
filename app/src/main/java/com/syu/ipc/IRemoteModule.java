package com.syu.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public interface IRemoteModule extends IInterface {
    void cmd(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    ModuleObject get(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    void register(IModuleCallback iModuleCallback, int i, int i2) throws RemoteException;

    void unregister(IModuleCallback iModuleCallback, int i) throws RemoteException;

    abstract class Stub extends Binder implements IRemoteModule {
        private static final String DESCRIPTOR = "com.syu.ipc.IRemoteModule";
        static final int TRANSACTION_cmd = 1;
        static final int TRANSACTION_get = 2;
        static final int TRANSACTION_register = 3;
        static final int TRANSACTION_unregister = 4;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteModule asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRemoteModule)) {
                return (IRemoteModule) iin;
            }
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    int cmdCode = data.readInt();
                    int[] ints = data.createIntArray();
                    float[] flts = data.createFloatArray();
                    String[] strs = data.createStringArray();
                    cmd(cmdCode, ints, flts, strs);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int getCode = data.readInt();
                    int[] ints2 = data.createIntArray();
                    float[] flts2 = data.createFloatArray();
                    String[] strs2 = data.createStringArray();
                    ModuleObject result = get(getCode, ints2, flts2, strs2);
                    reply.writeNoException();
                    if (result != null) {
                        reply.writeInt(1);
                        reply.writeIntArray(result.ints);
                        reply.writeFloatArray(result.flts);
                        reply.writeStringArray(result.strs);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    IModuleCallback callback = IModuleCallback.Stub.asInterface(data.readStrongBinder());
                    int updateCode = data.readInt();
                    int update = data.readInt();
                    register(callback, updateCode, update);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    IModuleCallback callback2 = IModuleCallback.Stub.asInterface(data.readStrongBinder());
                    int updateCode2 = data.readInt();
                    unregister(callback2, updateCode2);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IRemoteModule {
            private final IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override
            public void cmd(int cmdCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(Stub.DESCRIPTOR);
                    data.writeInt(cmdCode);
                    data.writeIntArray(ints);
                    data.writeFloatArray(flts);
                    data.writeStringArray(strs);
                    this.mRemote.transact(1, data, reply, 1);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public ModuleObject get(int getCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                ModuleObject result;
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(Stub.DESCRIPTOR);
                    data.writeInt(getCode);
                    data.writeIntArray(ints);
                    data.writeFloatArray(flts);
                    data.writeStringArray(strs);
                    this.mRemote.transact(2, data, reply, 0);
                    reply.readException();
                    if (reply.readInt() != 0) {
                        result = new ModuleObject();
                        result.ints = reply.createIntArray();
                        result.flts = reply.createFloatArray();
                        result.strs = reply.createStringArray();
                    } else {
                        result = null;
                    }
                    return result;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public void register(IModuleCallback callback, int updateCode, int update) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(Stub.DESCRIPTOR);
                    data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    data.writeInt(updateCode);
                    data.writeInt(update);
                    this.mRemote.transact(3, data, reply, 1);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public void unregister(IModuleCallback callback, int updateCode) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(Stub.DESCRIPTOR);
                    data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    data.writeInt(updateCode);
                    this.mRemote.transact(4, data, reply, 1);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
        }
    }
}
