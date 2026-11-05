package com.syu.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.syu.media.entities.MediaSource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface ICallback extends IInterface {

    public static class Default implements ICallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.syu.media.ICallback
        public void onPlayModeChanged(int i) {
        }

        @Override // com.syu.media.ICallback
        public void onPlayStatusChanged(boolean z) {
        }

        @Override // com.syu.media.ICallback
        public void onSongChanged(MediaSource mediaSource) {
        }
    }

    public static abstract class Stub extends Binder implements ICallback {

        public static class Proxy implements ICallback {
            public static ICallback sDefaultImpl;
            public final IBinder a;

            public Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String getInterfaceDescriptor() {
                return "com.syu.media.ICallback";
            }

            @Override // com.syu.media.ICallback
            public void onPlayModeChanged(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.ICallback");
                    parcelObtain.writeInt(i);
                    if (this.a.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPlayModeChanged(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.ICallback
            public void onPlayStatusChanged(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.ICallback");
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.a.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onPlayStatusChanged(z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.ICallback
            public void onSongChanged(MediaSource mediaSource) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.ICallback");
                    if (mediaSource != null) {
                        parcelObtain.writeInt(1);
                        mediaSource.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSongChanged(mediaSource);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.syu.media.ICallback");
        }

        public static ICallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.syu.media.ICallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICallback)) ? new Proxy(iBinder) : (ICallback) iInterfaceQueryLocalInterface;
        }

        public static ICallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICallback iCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.syu.media.ICallback");
                onSongChanged(parcel.readInt() != 0 ? MediaSource.INSTANCE.createFromParcel(parcel) : null);
            } else if (i == 2) {
                parcel.enforceInterface("com.syu.media.ICallback");
                onPlayStatusChanged(parcel.readInt() != 0);
            } else {
                if (i != 3) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.syu.media.ICallback");
                    return true;
                }
                parcel.enforceInterface("com.syu.media.ICallback");
                onPlayModeChanged(parcel.readInt());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onPlayModeChanged(int i);

    void onPlayStatusChanged(boolean z);

    void onSongChanged(MediaSource mediaSource);
}
