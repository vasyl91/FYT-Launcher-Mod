package com.syu.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IModuleCallback extends IInterface {
    void update(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IModuleCallback {
        private static final String DESCRIPTOR = "com.syu.ipc.IModuleCallback";
        static final int TRANSACTION_update = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IModuleCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IModuleCallback)) {
                return (IModuleCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    int updateCode = data.readInt();
                    int[] ints = data.createIntArray();
                    float[] flts = data.createFloatArray();
                    String[] strs = data.createStringArray();
                    update(updateCode, ints, flts, strs);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IModuleCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.syu.ipc.IModuleCallback
            public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel data = Parcel.obtain();
                try {
                    data.writeInterfaceToken(Stub.DESCRIPTOR);
                    data.writeInt(updateCode);
                    data.writeIntArray(ints);
                    data.writeFloatArray(flts);
                    data.writeStringArray(strs);
                    this.mRemote.transact(1, data, null, 1);
                } finally {
                    data.recycle();
                }
            }
        }
    }
}
