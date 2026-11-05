package com.autonavi.amapauto.gdarcameraservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.autonavi.amapauto.gdarcameraservice.model.GDArCameraParam;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface IGDCameraService extends IInterface {
    boolean closeCamera(String str) throws RemoteException;

    IGDSize getRecommendSize(String str) throws RemoteException;

    boolean initCamera(String str, GDArCameraParam gDArCameraParam, Surface surface) throws RemoteException;

    boolean isCameraConnected(String str) throws RemoteException;

    boolean isCameraOpened(String str) throws RemoteException;

    boolean isSupportArNavi(String str) throws RemoteException;

    boolean openCamera(String str) throws RemoteException;

    boolean registerCameraStateCallback(String str, IGDCameraStateCallBack iGDCameraStateCallBack) throws RemoteException;

    boolean unInitCamera(String str) throws RemoteException;

    boolean unregisterCameraStateCallback(String str, IGDCameraStateCallBack iGDCameraStateCallBack) throws RemoteException;

    public static class Default implements IGDCameraService {
        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean registerCameraStateCallback(String clientId, IGDCameraStateCallBack gdCameraStateCallBack) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean unregisterCameraStateCallback(String clientId, IGDCameraStateCallBack gdCameraStateCallBack) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean isSupportArNavi(String clientId) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public IGDSize getRecommendSize(String clientId) throws RemoteException {
            return null;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean isCameraConnected(String clientId) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean isCameraOpened(String clientId) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean initCamera(String clientId, GDArCameraParam gdArCameraParam, Surface surface) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean openCamera(String clientId) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean closeCamera(String clientId) throws RemoteException {
            return false;
        }

        @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
        public boolean unInitCamera(String clientId) throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IGDCameraService {
        private static final String DESCRIPTOR = "com.autonavi.amapauto.gdarcameraservice.IGDCameraService";
        static final int TRANSACTION_closeCamera = 9;
        static final int TRANSACTION_getRecommendSize = 4;
        static final int TRANSACTION_initCamera = 7;
        static final int TRANSACTION_isCameraConnected = 5;
        static final int TRANSACTION_isCameraOpened = 6;
        static final int TRANSACTION_isSupportArNavi = 3;
        static final int TRANSACTION_openCamera = 8;
        static final int TRANSACTION_registerCameraStateCallback = 1;
        static final int TRANSACTION_unInitCamera = 10;
        static final int TRANSACTION_unregisterCameraStateCallback = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGDCameraService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IGDCameraService)) {
                return (IGDCameraService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            GDArCameraParam _arg1;
            Surface _arg2;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    IGDCameraStateCallBack _arg3 = IGDCameraStateCallBack.Stub.asInterface(data.readStrongBinder());
                    boolean _result = registerCameraStateCallback(_arg0, _arg3);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg4 = data.readString();
                    IGDCameraStateCallBack _arg5 = IGDCameraStateCallBack.Stub.asInterface(data.readStrongBinder());
                    boolean _result2 = unregisterCameraStateCallback(_arg4, _arg5);
                    reply.writeNoException();
                    reply.writeInt(_result2 ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg6 = data.readString();
                    boolean _result3 = isSupportArNavi(_arg6);
                    reply.writeNoException();
                    reply.writeInt(_result3 ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg7 = data.readString();
                    IGDSize _result4 = getRecommendSize(_arg7);
                    reply.writeNoException();
                    reply.writeStrongBinder(_result4 != null ? _result4.asBinder() : null);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg8 = data.readString();
                    boolean _result5 = isCameraConnected(_arg8);
                    reply.writeNoException();
                    reply.writeInt(_result5 ? 1 : 0);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg9 = data.readString();
                    boolean _result6 = isCameraOpened(_arg9);
                    reply.writeNoException();
                    reply.writeInt(_result6 ? 1 : 0);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg10 = data.readString();
                    if (data.readInt() != 0) {
                        _arg1 = GDArCameraParam.CREATOR.createFromParcel(data);
                    } else {
                        _arg1 = null;
                    }
                    if (data.readInt() != 0) {
                        _arg2 = (Surface) Surface.CREATOR.createFromParcel(data);
                    } else {
                        _arg2 = null;
                    }
                    boolean _result7 = initCamera(_arg10, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result7 ? 1 : 0);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg11 = data.readString();
                    boolean _result8 = openCamera(_arg11);
                    reply.writeNoException();
                    reply.writeInt(_result8 ? 1 : 0);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg12 = data.readString();
                    boolean _result9 = closeCamera(_arg12);
                    reply.writeNoException();
                    reply.writeInt(_result9 ? 1 : 0);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg13 = data.readString();
                    boolean _result10 = unInitCamera(_arg13);
                    reply.writeNoException();
                    reply.writeInt(_result10 ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IGDCameraService {
            public static IGDCameraService sDefaultImpl;
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

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean registerCameraStateCallback(String clientId, IGDCameraStateCallBack gdCameraStateCallBack) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    _data.writeStrongBinder(gdCameraStateCallBack != null ? gdCameraStateCallBack.asBinder() : null);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().registerCameraStateCallback(clientId, gdCameraStateCallBack);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean unregisterCameraStateCallback(String clientId, IGDCameraStateCallBack gdCameraStateCallBack) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    _data.writeStrongBinder(gdCameraStateCallBack != null ? gdCameraStateCallBack.asBinder() : null);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().unregisterCameraStateCallback(clientId, gdCameraStateCallBack);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean isSupportArNavi(String clientId) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().isSupportArNavi(clientId);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public IGDSize getRecommendSize(String clientId) throws RemoteException {
                IGDSize iGDSizeAsInterface;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        iGDSizeAsInterface = Stub.getDefaultImpl().getRecommendSize(clientId);
                    } else {
                        _reply.readException();
                        iGDSizeAsInterface = IGDSize.Stub.asInterface(_reply.readStrongBinder());
                    }
                    return iGDSizeAsInterface;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean isCameraConnected(String clientId) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    boolean _status = this.mRemote.transact(5, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().isCameraConnected(clientId);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean isCameraOpened(String clientId) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    boolean _status = this.mRemote.transact(6, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().isCameraOpened(clientId);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean initCamera(String clientId, GDArCameraParam gdArCameraParam, Surface surface) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    if (gdArCameraParam != null) {
                        _data.writeInt(1);
                        gdArCameraParam.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if (surface != null) {
                        _data.writeInt(1);
                        surface.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = this.mRemote.transact(7, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().initCamera(clientId, gdArCameraParam, surface);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean openCamera(String clientId) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    boolean _status = this.mRemote.transact(8, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().openCamera(clientId);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean closeCamera(String clientId) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    boolean _status = this.mRemote.transact(9, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().closeCamera(clientId);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.autonavi.amapauto.gdarcameraservice.IGDCameraService
            public boolean unInitCamera(String clientId) throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(clientId);
                    boolean _status = this.mRemote.transact(10, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().unInitCamera(clientId);
                    } else {
                        _reply.readException();
                        _result = _reply.readInt() != 0;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGDCameraService impl) {
            if (Proxy.sDefaultImpl != null || impl == null) {
                return false;
            }
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static IGDCameraService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
