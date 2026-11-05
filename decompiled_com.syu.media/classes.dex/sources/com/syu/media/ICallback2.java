package com.syu.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ICallback2 extends IInterface {

    public static class Default implements ICallback2 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.syu.media.ICallback2
        public void onVideoSizeChanged(int i, int i2) {
        }
    }

    public static abstract class Stub extends Binder implements ICallback2 {

        public static class Proxy implements ICallback2 {
            public static ICallback2 sDefaultImpl;
            public final IBinder a;

            public Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String getInterfaceDescriptor() {
                return "com.syu.media.ICallback2";
            }

            @Override // com.syu.media.ICallback2
            public void onVideoSizeChanged(int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.ICallback2");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onVideoSizeChanged(i, i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.syu.media.ICallback2");
        }

        public static ICallback2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.syu.media.ICallback2");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICallback2)) ? new Proxy(iBinder) : (ICallback2) iInterfaceQueryLocalInterface;
        }

        public static ICallback2 getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICallback2 iCallback2) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCallback2 == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCallback2;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.syu.media.ICallback2");
                return true;
            }
            parcel.enforceInterface("com.syu.media.ICallback2");
            onVideoSizeChanged(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onVideoSizeChanged(int i, int i2);
}
