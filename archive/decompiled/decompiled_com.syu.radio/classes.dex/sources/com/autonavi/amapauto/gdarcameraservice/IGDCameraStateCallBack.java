package com.autonavi.amapauto.gdarcameraservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.autonavi.amapauto.gdarcameraservice.model.ArCameraOpenResultParam;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface IGDCameraStateCallBack extends IInterface {
    void onClosed(int i, String str) throws RemoteException;

    void onConnected() throws RemoteException;

    void onDisconnected() throws RemoteException;

    void onError(int i, String str) throws RemoteException;

    void onOpened(ParcelFileDescriptor parcelFileDescriptor, ArCameraOpenResultParam arCameraOpenResultParam, String str) throws RemoteException;

    public static class Default implements IGDCameraStateCallBack {
        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
        public void onConnected() throws RemoteException {
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
        public void onDisconnected() throws RemoteException {
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
        public void onOpened(ParcelFileDescriptor parcelFileDescriptor, ArCameraOpenResultParam arCameraOpenResultParam, String memoryfileName) throws RemoteException {
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
        public void onClosed(int code, String message) throws RemoteException {
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
        public void onError(int code, String message) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IGDCameraStateCallBack {
        private static final String DESCRIPTOR = "com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack";
        static final int TRANSACTION_onClosed = 4;
        static final int TRANSACTION_onConnected = 1;
        static final int TRANSACTION_onDisconnected = 2;
        static final int TRANSACTION_onError = 5;
        static final int TRANSACTION_onOpened = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGDCameraStateCallBack asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IGDCameraStateCallBack)) {
                return (IGDCameraStateCallBack) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelFileDescriptor _arg0;
            ArCameraOpenResultParam _arg1;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    onConnected();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    onDisconnected();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    if (data.readInt() != 0) {
                        _arg1 = ArCameraOpenResultParam.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    String _arg2 = data.readString();
                    onOpened(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg3 = data.readInt();
                    String _arg4 = data.readString();
                    onClosed(_arg3, _arg4);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg5 = data.readInt();
                    String _arg6 = data.readString();
                    onError(_arg5, _arg6);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IGDCameraStateCallBack {
            public static IGDCameraStateCallBack sDefaultImpl;
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

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
            public void onConnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onConnected();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
            public void onDisconnected() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDisconnected();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
            public void onOpened(ParcelFileDescriptor parcelFileDescriptor, ArCameraOpenResultParam arCameraOpenResultParam, String memoryfileName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (parcelFileDescriptor != null) {
                        _data.writeInt(1);
                        parcelFileDescriptor.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if (arCameraOpenResultParam != null) {
                        _data.writeInt(1);
                        arCameraOpenResultParam.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeString(memoryfileName);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onOpened(parcelFileDescriptor, arCameraOpenResultParam, memoryfileName);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
            public void onClosed(int code, String message) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(code);
                    _data.writeString(message);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onClosed(code, message);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack
            public void onError(int code, String message) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(code);
                    _data.writeString(message);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onError(code, message);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGDCameraStateCallBack impl) {
            if (Proxy.sDefaultImpl != null || impl == null) {
                return false;
            }
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static IGDCameraStateCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
