package qin.x_core.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public interface IModule extends IInterface {

    public static abstract class Stub extends Binder implements IModule {

        public static class Proxy implements IModule {
            public final IBinder a;

            public Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // qin.x_core.aidl.IModule
            public void command(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qin.x_core.aidl.IModule");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "qin.x_core.aidl.IModule";
            }

            @Override // qin.x_core.aidl.IModule
            public int id() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qin.x_core.aidl.IModule");
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qin.x_core.aidl.IModule
            public void register(IDataObserver iDataObserver, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qin.x_core.aidl.IModule");
                    parcelObtain.writeStrongBinder(iDataObserver != null ? iDataObserver.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qin.x_core.aidl.IModule
            public void unregister(IDataObserver iDataObserver, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qin.x_core.aidl.IModule");
                    parcelObtain.writeStrongBinder(iDataObserver != null ? iDataObserver.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // qin.x_core.aidl.IModule
            public Bundle valueOf(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("qin.x_core.aidl.IModule");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "qin.x_core.aidl.IModule");
        }

        public static IModule asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("qin.x_core.aidl.IModule");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IModule)) ? new Proxy(iBinder) : (IModule) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("qin.x_core.aidl.IModule");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("qin.x_core.aidl.IModule");
                int iId = id();
                parcel2.writeNoException();
                parcel2.writeInt(iId);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("qin.x_core.aidl.IModule");
                command(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("qin.x_core.aidl.IModule");
                Bundle bundleValueOf = valueOf(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (bundleValueOf != null) {
                    parcel2.writeInt(1);
                    bundleValueOf.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("qin.x_core.aidl.IModule");
                register(IDataObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("qin.x_core.aidl.IModule");
            unregister(IDataObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void command(Bundle bundle);

    int id();

    void register(IDataObserver iDataObserver, Bundle bundle);

    void unregister(IDataObserver iDataObserver, Bundle bundle);

    Bundle valueOf(Bundle bundle);
}
