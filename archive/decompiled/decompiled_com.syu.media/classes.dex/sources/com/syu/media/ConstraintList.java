package com.syu.media;

import android.util.Log;
import chip.FinalChip;
import com.fasterxml.aalto.util.XmlConsts;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import com.syu.media.provider.Media;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MediaProxy.kt */
/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BI\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u001b\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/syu/media/ConstraintList;", "Lcom/syu/media/Constraint;", "()V", "mediaDao", "Lcom/syu/media/dao/MediaDao;", "rootFolder", FinalChip.BSP_PLATFORM_Null, Media.FOLDER, Media.ALBUM, Media.ARTIST, "favorite", FinalChip.BSP_PLATFORM_Null, "(Lcom/syu/media/dao/MediaDao;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "constraint", "(Lcom/syu/media/dao/MediaDao;Lcom/syu/media/Constraint;)V", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "setMediaDao", "(Lcom/syu/media/dao/MediaDao;)V", "values", "Lkotlinx/coroutines/flow/Flow;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;", "app_appRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConstraintList extends Constraint {
    private MediaDao mediaDao;

    public final MediaDao getMediaDao() {
        return this.mediaDao;
    }

    public final void setMediaDao(MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    public ConstraintList() {
    }

    public /* synthetic */ ConstraintList(MediaDao mediaDao, String str, String str2, String str3, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaDao, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) == 0 ? str4 : null, (i2 & 32) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintList(MediaDao mediaDao, String str, String str2, String str3, String str4, int i) {
        super(str, str2, str3, str4, i);
        Intrinsics.checkNotNullParameter(mediaDao, "mediaDao");
        this.mediaDao = mediaDao;
    }

    public /* synthetic */ ConstraintList(MediaDao mediaDao, Constraint constraint, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mediaDao, constraint);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintList(MediaDao mediaDao, Constraint constraint) {
        super(constraint.getRootFolder(), constraint.getFolder(), constraint.getAlbum(), constraint.getArtist(), constraint.getFavorite());
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        this.mediaDao = mediaDao;
    }

    public final Flow<List<AudioSource>> values() {
        MediaDao mediaDao;
        Flow<List<AudioSource>> favorites;
        int mFlag = (getMFlag() >> 4) & 15;
        int mFlag2 = getMFlag() & 15;
        Log.e("music", "------------- values:" + mFlag + XmlConsts.CHAR_SPACE + mFlag2 + XmlConsts.CHAR_SPACE + this.mediaDao);
        if (mFlag == 0 && mFlag2 == 0) {
            MediaDao mediaDao2 = this.mediaDao;
            if (mediaDao2 != null) {
                return mediaDao2.allAudioSources();
            }
            return null;
        }
        if (mFlag == 0 && mFlag2 == 1) {
            MediaDao mediaDao3 = this.mediaDao;
            if (mediaDao3 == null) {
                return null;
            }
            String folder = getFolder();
            Intrinsics.checkNotNull(folder);
            Flow<List<AudioSource>> flowAudiosByFolder = mediaDao3.audiosByFolder(folder);
            if (flowAudiosByFolder != null) {
                return FlowKt.distinctUntilChanged(flowAudiosByFolder);
            }
            return null;
        }
        if (mFlag == 0 && mFlag2 == 2) {
            MediaDao mediaDao4 = this.mediaDao;
            if (mediaDao4 == null) {
                return null;
            }
            String album = getAlbum();
            Intrinsics.checkNotNull(album);
            Flow<List<AudioSource>> flowAudiosByAlum = mediaDao4.audiosByAlum(album);
            if (flowAudiosByAlum != null) {
                return FlowKt.distinctUntilChanged(flowAudiosByAlum);
            }
            return null;
        }
        if (mFlag == 0 && mFlag2 == 4) {
            MediaDao mediaDao5 = this.mediaDao;
            if (mediaDao5 == null) {
                return null;
            }
            String artist = getArtist();
            Intrinsics.checkNotNull(artist);
            Flow<List<AudioSource>> flowAudiosByArtist = mediaDao5.audiosByArtist(artist);
            if (flowAudiosByArtist != null) {
                return FlowKt.distinctUntilChanged(flowAudiosByArtist);
            }
            return null;
        }
        if (mFlag == 2 && mFlag2 == 0) {
            MediaDao mediaDao6 = this.mediaDao;
            if (mediaDao6 == null || (favorites = mediaDao6.getFavorites()) == null) {
                return null;
            }
            return FlowKt.distinctUntilChanged(favorites);
        }
        if (mFlag == 2 && mFlag2 == 1) {
            MediaDao mediaDao7 = this.mediaDao;
            if (mediaDao7 == null) {
                return null;
            }
            String folder2 = getFolder();
            Intrinsics.checkNotNull(folder2);
            Flow<List<AudioSource>> flowFavoritesByFolder = mediaDao7.favoritesByFolder(folder2);
            if (flowFavoritesByFolder != null) {
                return FlowKt.distinctUntilChanged(flowFavoritesByFolder);
            }
            return null;
        }
        if (mFlag == 2 && mFlag2 == 2) {
            MediaDao mediaDao8 = this.mediaDao;
            if (mediaDao8 == null) {
                return null;
            }
            String album2 = getAlbum();
            Intrinsics.checkNotNull(album2);
            Flow<List<AudioSource>> flowFavoritesByAlbum = mediaDao8.favoritesByAlbum(album2);
            if (flowFavoritesByAlbum != null) {
                return FlowKt.distinctUntilChanged(flowFavoritesByAlbum);
            }
            return null;
        }
        if (mFlag == 2 && mFlag2 == 4) {
            MediaDao mediaDao9 = this.mediaDao;
            if (mediaDao9 == null) {
                return null;
            }
            String artist2 = getArtist();
            Intrinsics.checkNotNull(artist2);
            Flow<List<AudioSource>> flowFavoritesByArtist = mediaDao9.favoritesByArtist(artist2);
            if (flowFavoritesByArtist != null) {
                return FlowKt.distinctUntilChanged(flowFavoritesByArtist);
            }
            return null;
        }
        if (mFlag == 1 && mFlag2 == 0) {
            MediaDao mediaDao10 = this.mediaDao;
            if (mediaDao10 == null) {
                return null;
            }
            String rootFolder = getRootFolder();
            Intrinsics.checkNotNull(rootFolder);
            Flow<List<AudioSource>> flowAudiosByRootFolder = mediaDao10.audiosByRootFolder(rootFolder);
            if (flowAudiosByRootFolder != null) {
                return FlowKt.distinctUntilChanged(flowAudiosByRootFolder);
            }
            return null;
        }
        if (mFlag == 1 && mFlag2 == 1) {
            MediaDao mediaDao11 = this.mediaDao;
            if (mediaDao11 == null) {
                return null;
            }
            String folder3 = getFolder();
            Intrinsics.checkNotNull(folder3);
            Flow<List<AudioSource>> flowAudiosByFolder2 = mediaDao11.audiosByFolder(folder3);
            if (flowAudiosByFolder2 != null) {
                return FlowKt.distinctUntilChanged(flowAudiosByFolder2);
            }
            return null;
        }
        if (mFlag == 1 && mFlag2 == 2) {
            MediaDao mediaDao12 = this.mediaDao;
            if (mediaDao12 == null) {
                return null;
            }
            String rootFolder2 = getRootFolder();
            Intrinsics.checkNotNull(rootFolder2);
            String album3 = getAlbum();
            Intrinsics.checkNotNull(album3);
            Flow<List<AudioSource>> flowAudiosByRootFolderAndAlbum = mediaDao12.audiosByRootFolderAndAlbum(rootFolder2, album3);
            if (flowAudiosByRootFolderAndAlbum != null) {
                return FlowKt.distinctUntilChanged(flowAudiosByRootFolderAndAlbum);
            }
            return null;
        }
        if (mFlag != 1 || mFlag2 != 4 || (mediaDao = this.mediaDao) == null) {
            return null;
        }
        String rootFolder3 = getRootFolder();
        Intrinsics.checkNotNull(rootFolder3);
        String artist3 = getArtist();
        Intrinsics.checkNotNull(artist3);
        Flow<List<AudioSource>> flowAudiosByRootFolderAndArtist = mediaDao.audiosByRootFolderAndArtist(rootFolder3, artist3);
        if (flowAudiosByRootFolderAndArtist != null) {
            return FlowKt.distinctUntilChanged(flowAudiosByRootFolderAndArtist);
        }
        return null;
    }
}
