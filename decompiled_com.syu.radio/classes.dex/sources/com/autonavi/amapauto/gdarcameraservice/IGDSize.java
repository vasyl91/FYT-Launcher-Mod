package com.autonavi.amapauto.gdarcameraservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface IGDSize extends IInterface {
    int getHeight() throws RemoteException;

    int getWidth() throws RemoteException;

    public static class Default implements IGDSize {
        @Override // com.autonavi.amapauto.gdarcameraservice.IGDSize
        public int getWidth() throws RemoteException {
            return 0;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDSize
        public int getHeight() throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IGDSize {
        private static final String DESCRIPTOR = "com.autonavi.amapauto.gdarcameraservice.IGDSize";
        static final int TRANSACTION_getHeight = 2;
        static final int TRANSACTION_getWidth = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGDSize asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IGDSize)) {
                return (IGDSize) iin;
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
                    int _result = getWidth();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _result2 = getHeight();
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IGDSize {
            public static IGDSize sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDSize
            public int getWidth() throws RemoteException {
                int width;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        width = Stub.getDefaultImpl().getWidth();
                    } else {
                        _reply.readException();
                        width = _reply.readInt();
                    }
                    return width;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDSize
            public int getHeight() throws RemoteException {
                int height;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        height = Stub.getDefaultImpl().getHeight();
                    } else {
                        _reply.readException();
                        height = _reply.readInt();
                    }
                    return height;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGDSize impl) {
            if (Proxy.sDefaultImpl != null || impl == null) {
                return false;
            }
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static IGDSize getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
