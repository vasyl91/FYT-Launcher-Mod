package com.syu.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.syu.media.entities.MediaSource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface IOnlineCallback extends IInterface {

    public static class Default implements IOnlineCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.syu.media.IOnlineCallback
        public void onlineChanged(MediaSource mediaSource, int i) {
        }
    }

    public static abstract class Stub extends Binder implements IOnlineCallback {

        public static class Proxy implements IOnlineCallback {
            public static IOnlineCallback sDefaultImpl;
            public final IBinder a;

            public Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String getInterfaceDescriptor() {
                return "com.syu.media.IOnlineCallback";
            }

            @Override // com.syu.media.IOnlineCallback
            public void onlineChanged(MediaSource mediaSource, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IOnlineCallback");
                    if (mediaSource != null) {
                        parcelObtain.writeInt(1);
                        mediaSource.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onlineChanged(mediaSource, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.syu.media.IOnlineCallback");
        }

        public static IOnlineCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.syu.media.IOnlineCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IOnlineCallback)) ? new Proxy(iBinder) : (IOnlineCallback) iInterfaceQueryLocalInterface;
        }

        public static IOnlineCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IOnlineCallback iOnlineCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOnlineCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOnlineCallback;
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
                parcel2.writeString("com.syu.media.IOnlineCallback");
                return true;
            }
            parcel.enforceInterface("com.syu.media.IOnlineCallback");
            onlineChanged(parcel.readInt() != 0 ? MediaSource.INSTANCE.createFromParcel(parcel) : null, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onlineChanged(MediaSource mediaSource, int i);
}
