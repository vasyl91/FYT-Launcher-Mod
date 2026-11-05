package com.syu.media.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import chip.FinalChip;
import com.syu.media.dao.MediaDao;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.PlayListWithAudios;
import com.syu.media.entities.RadioSource;
import com.syu.media.entities.VideoSource;
import com.syu.media.provider.Media;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b1\u00102J\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002J\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u0002J\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0014\u001a\u00020\rJ\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u00022\u0006\u0010\u0014\u001a\u00020\rJ\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u00022\u0006\u0010\u0014\u001a\u00020\rJ\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u00022\u0006\u0010\u0014\u001a\u00020\rJ\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0018\u00010\u0002J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u0002J\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u00022\u0006\u0010\u0014\u001a\u00020\rJ\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00030\u00022\u0006\u0010\u0014\u001a\u00020\rJ\u0014\u0010\u001f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0003\u0018\u00010\u0002R\u0017\u0010%\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R#\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0'0&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020-0&8\u0006¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+¨\u00063"}, d2 = {"Lcom/syu/media/model/MediaModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/flow/Flow;", FinalChip.BSP_PLATFORM_Null, "Lcom/syu/media/entities/AudioSource;", "getAllSongs", "getFavorites", FinalChip.BSP_PLATFORM_Null, "id", "Lcom/syu/media/entities/PlayListWithAudios;", "getPlayListById", "Lcom/syu/media/entities/VideoSource;", "getVideoFavorites", FinalChip.BSP_PLATFORM_Null, "getAlbums", "getArtists", "getFolders", "getAlbumsWithFavorite", "getArtistsWithFavorite", "getFoldersWithFavorite", Media.FOLDER, "getAudiosByPath", "getAlbumsWithFolder", "getArtistsWithFolder", "getFoldersWithFolder", "getAllVideos", "getFoldersOfVideo", "getFoldersOfVideoWithFavorite", "getVideosByPath", "getFoldersOfVideoWithFolder", "Lcom/syu/media/entities/RadioSource;", "allRadios", "Lcom/syu/media/dao/MediaDao;", "a", "Lcom/syu/media/dao/MediaDao;", "getMediaDao", "()Lcom/syu/media/dao/MediaDao;", "mediaDao", "Landroidx/lifecycle/MutableLiveData;", FinalChip.BSP_PLATFORM_Null, "b", "Landroidx/lifecycle/MutableLiveData;", "getStorageDevices", "()Landroidx/lifecycle/MutableLiveData;", "storageDevices", FinalChip.BSP_PLATFORM_Null, "c", "getScanning", "scanning", "<init>", "(Lcom/syu/media/dao/MediaDao;)V", "MediaLib_release"}, k = 1, mv = {1, 7, 1})
public final class MediaModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final MediaDao mediaDao;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final MutableLiveData storageDevices;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final MutableLiveData scanning;

    public MediaModel(MediaDao mediaDao) {
        Intrinsics.checkNotNullParameter(mediaDao, "mediaDao");
        this.mediaDao = mediaDao;
        this.storageDevices = new MutableLiveData();
        MutableLiveData mutableLiveData = new MutableLiveData();
        mutableLiveData.setValue(Boolean.FALSE);
        this.scanning = mutableLiveData;
    }

    public final Flow<List<RadioSource>> allRadios() {
        return this.mediaDao.allRadios();
    }

    public final Flow<List<String>> getAlbums() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getAlbums());
    }

    public final Flow<List<String>> getAlbumsWithFavorite() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getAlbumsWithFavorite());
    }

    public final Flow<List<String>> getAlbumsWithFolder(String folder) {
        Intrinsics.checkNotNullParameter(folder, Media.FOLDER);
        return FlowKt.distinctUntilChanged(this.mediaDao.getAlbumsByPath(folder));
    }

    public final Flow<List<AudioSource>> getAllSongs() {
        Flow<List<AudioSource>> flowAllAudioSources = this.mediaDao.allAudioSources();
        if (flowAllAudioSources != null) {
            return FlowKt.distinctUntilChanged(flowAllAudioSources);
        }
        return null;
    }

    public final Flow<List<VideoSource>> getAllVideos() {
        return this.mediaDao.allVideos();
    }

    public final Flow<List<String>> getArtists() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getArtists());
    }

    public final Flow<List<String>> getArtistsWithFavorite() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getArtistsWithFavorite());
    }

    public final Flow<List<String>> getArtistsWithFolder(String folder) {
        Intrinsics.checkNotNullParameter(folder, Media.FOLDER);
        return FlowKt.distinctUntilChanged(this.mediaDao.getArtistsByPath(folder));
    }

    public final Flow<List<AudioSource>> getAudiosByPath(String folder) {
        Intrinsics.checkNotNullParameter(folder, Media.FOLDER);
        return FlowKt.distinctUntilChanged(this.mediaDao.getAudioSourcesFlowWithFilter(folder));
    }

    public final Flow<List<AudioSource>> getFavorites() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getFavorites());
    }

    public final Flow<List<String>> getFolders() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getFoldersFlow());
    }

    public final Flow<List<String>> getFoldersOfVideo() {
        return this.mediaDao.getFoldersOfVideo();
    }

    public final Flow<List<String>> getFoldersOfVideoWithFavorite() {
        return this.mediaDao.getFoldersOfVideoWithFavorite();
    }

    public final Flow<List<String>> getFoldersOfVideoWithFolder(String folder) {
        Intrinsics.checkNotNullParameter(folder, Media.FOLDER);
        return this.mediaDao.getFoldersOfVideoWithFolder(folder);
    }

    public final Flow<List<String>> getFoldersWithFavorite() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getFoldersWithFavorite());
    }

    public final Flow<List<String>> getFoldersWithFolder(String folder) {
        Intrinsics.checkNotNullParameter(folder, Media.FOLDER);
        return FlowKt.distinctUntilChanged(this.mediaDao.getFoldersByPath(folder));
    }

    public final MediaDao getMediaDao() {
        return this.mediaDao;
    }

    public final Flow<PlayListWithAudios> getPlayListById(int id) {
        return FlowKt.distinctUntilChanged(this.mediaDao.getPlayListById(id));
    }

    public final MutableLiveData<Boolean> getScanning() {
        return this.scanning;
    }

    public final MutableLiveData<List<String>> getStorageDevices() {
        return this.storageDevices;
    }

    public final Flow<List<VideoSource>> getVideoFavorites() {
        return FlowKt.distinctUntilChanged(this.mediaDao.getVideoFavorites());
    }

    public final Flow<List<VideoSource>> getVideosByPath(String folder) {
        Intrinsics.checkNotNullParameter(folder, Media.FOLDER);
        return FlowKt.distinctUntilChanged(this.mediaDao.getVideosByPath(folder));
    }
}
