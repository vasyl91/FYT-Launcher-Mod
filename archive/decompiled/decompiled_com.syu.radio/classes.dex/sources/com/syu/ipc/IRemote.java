package com.syu.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface IRemote extends IInterface {
    void cmd(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    float[] getAF(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    int[] getAI(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    String[] getAS(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    float getF(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    int getI(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    String getS(int i, int[] iArr, float[] fArr, String[] strArr) throws RemoteException;

    void registerCallback(ICallback iCallback, int i, boolean z) throws RemoteException;

    void unregisterCallback(ICallback iCallback, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemote {
        private static final String DESCRIPTOR = "com.syu.ipc.IRemote";
        static final int TRANSACTION_cmd = 1;
        static final int TRANSACTION_getAF = 6;
        static final int TRANSACTION_getAI = 5;
        static final int TRANSACTION_getAS = 7;
        static final int TRANSACTION_getF = 3;
        static final int TRANSACTION_getI = 2;
        static final int TRANSACTION_getS = 4;
        static final int TRANSACTION_registerCallback = 8;
        static final int TRANSACTION_unregisterCallback = 9;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemote asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRemote)) {
                return (IRemote) iin;
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
                    int cmdCode = data.readInt();
                    int[] ints = data.createIntArray();
                    float[] flts = data.createFloatArray();
                    String[] strs = data.createStringArray();
                    cmd(cmdCode, ints, flts, strs);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int getCode = data.readInt();
                    int[] ints2 = data.createIntArray();
                    float[] flts2 = data.createFloatArray();
                    String[] strs2 = data.createStringArray();
                    int _result = getI(getCode, ints2, flts2, strs2);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int getCode2 = data.readInt();
                    int[] ints3 = data.createIntArray();
                    float[] flts3 = data.createFloatArray();
                    String[] strs3 = data.createStringArray();
                    float _result2 = getF(getCode2, ints3, flts3, strs3);
                    reply.writeNoException();
                    reply.writeFloat(_result2);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int getCode3 = data.readInt();
                    int[] ints4 = data.createIntArray();
                    float[] flts4 = data.createFloatArray();
                    String[] strs4 = data.createStringArray();
                    String _result3 = getS(getCode3, ints4, flts4, strs4);
                    reply.writeNoException();
                    reply.writeString(_result3);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int getCode4 = data.readInt();
                    int[] ints5 = data.createIntArray();
                    float[] flts5 = data.createFloatArray();
                    String[] strs5 = data.createStringArray();
                    int[] _result4 = getAI(getCode4, ints5, flts5, strs5);
                    reply.writeNoException();
                    reply.writeIntArray(_result4);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    int getCode5 = data.readInt();
                    int[] ints6 = data.createIntArray();
                    float[] flts6 = data.createFloatArray();
                    String[] strs6 = data.createStringArray();
                    float[] _result5 = getAF(getCode5, ints6, flts6, strs6);
                    reply.writeNoException();
                    reply.writeFloatArray(_result5);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int getCode6 = data.readInt();
                    int[] ints7 = data.createIntArray();
                    float[] flts7 = data.createFloatArray();
                    String[] strs7 = data.createStringArray();
                    String[] _result6 = getAS(getCode6, ints7, flts7, strs7);
                    reply.writeNoException();
                    reply.writeStringArray(_result6);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    ICallback cb = ICallback.Stub.asInterface(data.readStrongBinder());
                    int updateCode = data.readInt();
                    boolean now = data.readInt() != 0;
                    registerCallback(cb, updateCode, now);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    ICallback cb2 = ICallback.Stub.asInterface(data.readStrongBinder());
                    int updateCode2 = data.readInt();
                    unregisterCallback(cb2, updateCode2);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IRemote {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.syu.ipc.IRemote
            public void cmd(int cmdCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(cmdCode);
                    _data.writeIntArray(ints);
                    _data.writeFloatArray(flts);
                    _data.writeStringArray(strs);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public int getI(int getCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(getCode);
                    _data.writeIntArray(ints);
                    _data.writeFloatArray(flts);
                    _data.writeStringArray(strs);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public float getF(int getCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(getCode);
                    _data.writeIntArray(ints);
                    _data.writeFloatArray(flts);
                    _data.writeStringArray(strs);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    float _result = _reply.readFloat();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public String getS(int getCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(getCode);
                    _data.writeIntArray(ints);
                    _data.writeFloatArray(flts);
                    _data.writeStringArray(strs);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public int[] getAI(int getCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(getCode);
                    _data.writeIntArray(ints);
                    _data.writeFloatArray(flts);
                    _data.writeStringArray(strs);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    int[] _result = _reply.createIntArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public float[] getAF(int getCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(getCode);
                    _data.writeIntArray(ints);
                    _data.writeFloatArray(flts);
                    _data.writeStringArray(strs);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    float[] _result = _reply.createFloatArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public String[] getAS(int getCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(getCode);
                    _data.writeIntArray(ints);
                    _data.writeFloatArray(flts);
                    _data.writeStringArray(strs);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public void registerCallback(ICallback cb, int updateCode, boolean cbNow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(cb != null ? cb.asBinder() : null);
                    _data.writeInt(updateCode);
                    _data.writeInt(cbNow ? 1 : 0);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.syu.ipc.IRemote
            public void unregisterCallback(ICallback cb, int updateCode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(cb != null ? cb.asBinder() : null);
                    _data.writeInt(updateCode);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
