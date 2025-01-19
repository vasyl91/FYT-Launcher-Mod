package com.syu.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.syu.ipc.IRemoteModule;

public interface IRemoteToolkit extends IInterface {
    IRemoteModule getRemoteModule(int i) throws RemoteException;

    abstract class Stub extends Binder implements IRemoteToolkit {
        private static final String DESCRIPTOR = "com.syu.ipc.IRemoteToolkit";
        static final int TRANSACTION_getRemoteModule = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteToolkit asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRemoteToolkit)) {
                return (IRemoteToolkit) iin;
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
                    int moduleCode = data.readInt();
                    IRemoteModule result = getRemoteModule(moduleCode);
                    reply.writeNoException();
                    reply.writeStrongBinder(result != null ? result.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IRemoteToolkit {
            private final IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override
            public IRemoteModule getRemoteModule(int moduleCode) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(Stub.DESCRIPTOR);
                    data.writeInt(moduleCode);
                    this.mRemote.transact(1, data, reply, 0);
                    reply.readException();
                    IRemoteModule result = IRemoteModule.Stub.asInterface(reply.readStrongBinder());
                    return result;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
        }
    }
}
