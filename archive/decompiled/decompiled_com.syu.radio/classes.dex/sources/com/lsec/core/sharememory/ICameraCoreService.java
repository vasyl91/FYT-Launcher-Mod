package com.lsec.core.sharememory;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface ICameraCoreService extends IInterface {
    void addExportMemoryFile(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, int i3) throws RemoteException;

    boolean isRecording() throws RemoteException;

    void startRecord(String str, int i) throws RemoteException;

    void stopRecord() throws RemoteException;

    public static class Default implements ICameraCoreService {
        @Override // com.lsec.core.sharememory.ICameraCoreService
        public boolean isRecording() throws RemoteException {
            return false;
        }

        @Override // com.lsec.core.sharememory.ICameraCoreService
        public void startRecord(String recordPath, int recordSharpness) throws RemoteException {
        }

        @Override // com.lsec.core.sharememory.ICameraCoreService
        public void stopRecord() throws RemoteException {
        }

        @Override // com.lsec.core.sharememory.ICameraCoreService
        public void addExportMemoryFile(ParcelFileDescriptor pfd, int w, int h, int size) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICameraCoreService {
        private static final String DESCRIPTOR = "com.lsec.core.sharememory.ICameraCoreService";
        static final int TRANSACTION_addExportMemoryFile = 4;
        static final int TRANSACTION_isRecording = 1;
        static final int TRANSACTION_startRecord = 2;
        static final int TRANSACTION_stopRecord = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICameraCoreService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ICameraCoreService)) {
                return (ICameraCoreService) iin;
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
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = isRecording();
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg1 = data.readString();
                    int _arg2 = data.readInt();
                    startRecord(_arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    stopRecord();
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg3 = data.readInt();
                    int _arg4 = data.readInt();
                    int _arg5 = data.readInt();
                    addExportMemoryFile(_arg0, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ICameraCoreService {
            public static ICameraCoreService sDefaultImpl;
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

            @Override // com.lsec.core.sharememory.ICameraCoreService
            public boolean isRecording() throws RemoteException {
                boolean _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(1, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        _result = Stub.getDefaultImpl().isRecording();
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

            @Override // com.lsec.core.sharememory.ICameraCoreService
            public void startRecord(String recordPath, int recordSharpness) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(recordPath);
                    _data.writeInt(recordSharpness);
                    boolean _status = this.mRemote.transact(2, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startRecord(recordPath, recordSharpness);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.lsec.core.sharememory.ICameraCoreService
            public void stopRecord() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _status = this.mRemote.transact(3, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopRecord();
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.lsec.core.sharememory.ICameraCoreService
            public void addExportMemoryFile(ParcelFileDescriptor pfd, int w, int h, int size) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (pfd != null) {
                        _data.writeInt(1);
                        pfd.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(w);
                    _data.writeInt(h);
                    _data.writeInt(size);
                    boolean _status = this.mRemote.transact(4, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addExportMemoryFile(pfd, w, h, size);
                    } else {
                        _reply.readException();
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICameraCoreService impl) {
            if (Proxy.sDefaultImpl != null || impl == null) {
                return false;
            }
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static ICameraCoreService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
