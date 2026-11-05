package com.syu.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface IRemoteModule extends IInterface {

    public static abstract class Stub extends Binder implements IRemoteModule {
        private static final String DESCRIPTOR = "com.syu.ipc.IRemoteModule";
        static final int TRANSACTION_cmd = 1;
        static final int TRANSACTION_get = 2;
        static final int TRANSACTION_register = 3;
        static final int TRANSACTION_unregister = 4;

        public static class Proxy implements IRemoteModule {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.syu.ipc.IRemoteModule
            public void cmd(int i, int[] iArr, float[] fArr, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeFloatArray(fArr);
                    parcelObtain.writeStringArray(strArr);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 1);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.ipc.IRemoteModule
            public ModuleObject get(int i, int[] iArr, float[] fArr, String[] strArr) {
                ModuleObject moduleObject;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeFloatArray(fArr);
                    parcelObtain.writeStringArray(strArr);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        moduleObject = new ModuleObject();
                        moduleObject.ints = parcelObtain2.createIntArray();
                        moduleObject.flts = parcelObtain2.createFloatArray();
                        moduleObject.strs = parcelObtain2.createStringArray();
                    } else {
                        moduleObject = null;
                    }
                    return moduleObject;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.ipc.IRemoteModule
            public void register(IModuleCallback iModuleCallback, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iModuleCallback != null ? iModuleCallback.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 1);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.ipc.IRemoteModule
            public void unregister(IModuleCallback iModuleCallback, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iModuleCallback != null ? iModuleCallback.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 1);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteModule asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteModule)) ? new Proxy(iBinder) : (IRemoteModule) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                cmd(parcel.readInt(), parcel.createIntArray(), parcel.createFloatArray(), parcel.createStringArray());
                return true;
            }
            if (i != 2) {
                if (i == 3) {
                    parcel.enforceInterface(DESCRIPTOR);
                    register(IModuleCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                }
                if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel.enforceInterface(DESCRIPTOR);
                unregister(IModuleCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            ModuleObject moduleObject = get(parcel.readInt(), parcel.createIntArray(), parcel.createFloatArray(), parcel.createStringArray());
            parcel2.writeNoException();
            if (moduleObject != null) {
                parcel2.writeInt(1);
                parcel2.writeIntArray(moduleObject.ints);
                parcel2.writeFloatArray(moduleObject.flts);
                parcel2.writeStringArray(moduleObject.strs);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    void cmd(int i, int[] iArr, float[] fArr, String[] strArr);

    ModuleObject get(int i, int[] iArr, float[] fArr, String[] strArr);

    void register(IModuleCallback iModuleCallback, int i, int i2);

    void unregister(IModuleCallback iModuleCallback, int i);
}
