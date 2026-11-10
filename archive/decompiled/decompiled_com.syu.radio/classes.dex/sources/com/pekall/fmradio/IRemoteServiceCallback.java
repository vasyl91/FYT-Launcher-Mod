package com.pekall.fmradio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface IRemoteServiceCallback extends IInterface {
    void openFMRadioCallBack(boolean z) throws RemoteException;

    void openFMRadioTxCallBack(boolean z) throws RemoteException;

    void seekStationCallback(boolean z, int i) throws RemoteException;

    void setFrequencyCallback(boolean z, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteServiceCallback {
        private static final String DESCRIPTOR = "com.pekall.fmradio.IRemoteServiceCallback";
        static final int TRANSACTION_openFMRadioCallBack = 1;
        static final int TRANSACTION_openFMRadioTxCallBack = 2;
        static final int TRANSACTION_seekStationCallback = 4;
        static final int TRANSACTION_setFrequencyCallback = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteServiceCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRemoteServiceCallback)) {
                return (IRemoteServiceCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg0;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    openFMRadioCallBack(_arg0);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    openFMRadioTxCallBack(_arg0);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    int _arg1 = data.readInt();
                    setFrequencyCallback(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    int _arg2 = data.readInt();
                    seekStationCallback(_arg0, _arg2);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IRemoteServiceCallback {
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

            @Override // com.pekall.fmradio.IRemoteServiceCallback
            public void openFMRadioCallBack(boolean result) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(result ? 1 : 0);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.pekall.fmradio.IRemoteServiceCallback
            public void openFMRadioTxCallBack(boolean result) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(result ? 1 : 0);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.pekall.fmradio.IRemoteServiceCallback
            public void setFrequencyCallback(boolean result, int freq) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(result ? 1 : 0);
                    _data.writeInt(freq);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.pekall.fmradio.IRemoteServiceCallback
            public void seekStationCallback(boolean result, int frequency) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(result ? 1 : 0);
                    _data.writeInt(frequency);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
