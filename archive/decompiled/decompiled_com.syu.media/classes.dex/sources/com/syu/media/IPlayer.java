package com.syu.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.syu.media.entities.MediaSource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface IPlayer extends IInterface {

    public static class Default implements IPlayer {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.syu.media.IPlayer
        public int audioSessionId() {
            return 0;
        }

        @Override // com.syu.media.IPlayer
        public int getPlayMode() {
            return 0;
        }

        @Override // com.syu.media.IPlayer
        public MediaSource getPlayingSong() {
            return null;
        }

        @Override // com.syu.media.IPlayer
        public int getProgress() {
            return 0;
        }

        @Override // com.syu.media.IPlayer
        public boolean isPlaying() {
            return false;
        }

        @Override // com.syu.media.IPlayer
        public boolean pause() {
            return false;
        }

        @Override // com.syu.media.IPlayer
        public boolean play() {
            return false;
        }

        @Override // com.syu.media.IPlayer
        public boolean playLast() {
            return false;
        }

        @Override // com.syu.media.IPlayer
        public void playListWithId(int i, int i2) {
        }

        @Override // com.syu.media.IPlayer
        public boolean playNext() {
            return false;
        }

        @Override // com.syu.media.IPlayer
        public void playWithId(int i) {
        }

        @Override // com.syu.media.IPlayer
        public void playWithPath(String str) {
        }

        @Override // com.syu.media.IPlayer
        public void registerCallback(ICallback iCallback) {
        }

        @Override // com.syu.media.IPlayer
        public void registerCallback2(ICallback2 iCallback2) {
        }

        @Override // com.syu.media.IPlayer
        public boolean seekTo(int i) {
            return false;
        }

        @Override // com.syu.media.IPlayer
        public void setPlayMode(int i) {
        }

        @Override // com.syu.media.IPlayer
        public void unregisterCallback(ICallback iCallback) {
        }

        @Override // com.syu.media.IPlayer
        public void unregisterCallback2(ICallback2 iCallback2) {
        }
    }

    public static abstract class Stub extends Binder implements IPlayer {

        public static class Proxy implements IPlayer {
            public static IPlayer sDefaultImpl;
            public final IBinder a;

            public Proxy(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.syu.media.IPlayer
            public int audioSessionId() {
                int iAudioSessionId;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (this.a.transact(14, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        iAudioSessionId = parcelObtain2.readInt();
                    } else {
                        iAudioSessionId = Stub.getDefaultImpl().audioSessionId();
                    }
                    return iAudioSessionId;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.syu.media.IPlayer";
            }

            @Override // com.syu.media.IPlayer
            public int getPlayMode() {
                int playMode;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (this.a.transact(11, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        playMode = parcelObtain2.readInt();
                    } else {
                        playMode = Stub.getDefaultImpl().getPlayMode();
                    }
                    return playMode;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public MediaSource getPlayingSong() {
                MediaSource mediaSourceCreateFromParcel;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (this.a.transact(10, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        mediaSourceCreateFromParcel = parcelObtain2.readInt() != 0 ? MediaSource.INSTANCE.createFromParcel(parcelObtain2) : null;
                    } else {
                        mediaSourceCreateFromParcel = Stub.getDefaultImpl().getPlayingSong();
                    }
                    return mediaSourceCreateFromParcel;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public int getProgress() {
                int progress;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (this.a.transact(9, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        progress = parcelObtain2.readInt();
                    } else {
                        progress = Stub.getDefaultImpl().getProgress();
                    }
                    return progress;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public boolean isPlaying() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (!this.a.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isPlaying();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public boolean pause() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (!this.a.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().pause();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public boolean play() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().play();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public boolean playLast() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (!this.a.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().playLast();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void playListWithId(int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (this.a.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().playListWithId(i, i2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public boolean playNext() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    if (!this.a.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().playNext();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void playWithId(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeInt(i);
                    if (this.a.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().playWithId(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void playWithPath(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeString(str);
                    if (this.a.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().playWithPath(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void registerCallback(ICallback iCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    if (this.a.transact(15, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCallback(iCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void registerCallback2(ICallback2 iCallback2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeStrongBinder(iCallback2 != null ? iCallback2.asBinder() : null);
                    if (this.a.transact(17, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCallback2(iCallback2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public boolean seekTo(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeInt(i);
                    if (!this.a.transact(12, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().seekTo(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void setPlayMode(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeInt(i);
                    if (this.a.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setPlayMode(i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void unregisterCallback(ICallback iCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeStrongBinder(iCallback != null ? iCallback.asBinder() : null);
                    if (this.a.transact(16, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterCallback(iCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.syu.media.IPlayer
            public void unregisterCallback2(ICallback2 iCallback2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.syu.media.IPlayer");
                    parcelObtain.writeStrongBinder(iCallback2 != null ? iCallback2.asBinder() : null);
                    if (this.a.transact(18, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().unregisterCallback2(iCallback2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.syu.media.IPlayer");
        }

        public static IPlayer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.syu.media.IPlayer");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPlayer)) ? new Proxy(iBinder) : (IPlayer) iInterfaceQueryLocalInterface;
        }

        public static IPlayer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPlayer iPlayer) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPlayer == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPlayer;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.syu.media.IPlayer");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    boolean zPlay = play();
                    parcel2.writeNoException();
                    parcel2.writeInt(zPlay ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    playListWithId(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    playWithPath(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    playWithId(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    boolean zPlayLast = playLast();
                    parcel2.writeNoException();
                    parcel2.writeInt(zPlayLast ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    boolean zPlayNext = playNext();
                    parcel2.writeNoException();
                    parcel2.writeInt(zPlayNext ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    boolean zPause = pause();
                    parcel2.writeNoException();
                    parcel2.writeInt(zPause ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    boolean zIsPlaying = isPlaying();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsPlaying ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    int progress = getProgress();
                    parcel2.writeNoException();
                    parcel2.writeInt(progress);
                    return true;
                case 10:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    MediaSource playingSong = getPlayingSong();
                    parcel2.writeNoException();
                    if (playingSong != null) {
                        parcel2.writeInt(1);
                        playingSong.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    int playMode = getPlayMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(playMode);
                    return true;
                case 12:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    boolean zSeekTo = seekTo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zSeekTo ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    setPlayMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    int iAudioSessionId = audioSessionId();
                    parcel2.writeNoException();
                    parcel2.writeInt(iAudioSessionId);
                    return true;
                case 15:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    registerCallback(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    unregisterCallback(ICallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    registerCallback2(ICallback2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.syu.media.IPlayer");
                    unregisterCallback2(ICallback2.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int audioSessionId();

    int getPlayMode();

    MediaSource getPlayingSong();

    int getProgress();

    boolean isPlaying();

    boolean pause();

    boolean play();

    boolean playLast();

    void playListWithId(int i, int i2);

    boolean playNext();

    void playWithId(int i);

    void playWithPath(String str);

    void registerCallback(ICallback iCallback);

    void registerCallback2(ICallback2 iCallback2);

    boolean seekTo(int i);

    void setPlayMode(int i);

    void unregisterCallback(ICallback iCallback);

    void unregisterCallback2(ICallback2 iCallback2);
}
