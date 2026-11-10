package com.syu.media.dao;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.syu.media.database.Converters;
import com.syu.media.entities.AudioSource;
import com.syu.media.entities.PlayList;
import com.syu.media.entities.PlayListWithAudios;
import com.syu.media.entities.PlayListWithRadios;
import com.syu.media.entities.PlaylistAudioCrossRef;
import com.syu.media.entities.PlaylistRadioCrossRef;
import com.syu.media.entities.PlaylistVideoCrossRef;
import com.syu.media.entities.RadioSource;
import com.syu.media.entities.VideoSource;
import com.syu.media.provider.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MediaDao_Impl extends MediaDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter b;
    public final EntityInsertionAdapter c;
    public final Converters d = new Converters();
    public final EntityInsertionAdapter e;
    public final EntityInsertionAdapter f;
    public final EntityInsertionAdapter g;
    public final EntityInsertionAdapter h;
    public final EntityInsertionAdapter i;
    public final EntityInsertionAdapter j;
    public final EntityDeletionOrUpdateAdapter k;
    public final EntityDeletionOrUpdateAdapter l;
    public final EntityDeletionOrUpdateAdapter m;
    public final EntityDeletionOrUpdateAdapter n;
    public final EntityDeletionOrUpdateAdapter o;
    public final EntityDeletionOrUpdateAdapter p;
    public final EntityDeletionOrUpdateAdapter q;
    public final SharedSQLiteStatement r;
    public final SharedSQLiteStatement s;
    public final SharedSQLiteStatement t;

    public MediaDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new EntityInsertionAdapter<AudioSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.1
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AudioSource audioSource) {
                if (audioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, audioSource.getId().intValue());
                }
                if (audioSource.getTitle() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, audioSource.getTitle());
                }
                if (audioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, audioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, audioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, audioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.PATH java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, audioSource.getCom.syu.media.provider.Media.PATH java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, audioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String());
                }
                supportSQLiteStatement.bindLong(8, audioSource.getCom.syu.media.provider.Media.DURATION java.lang.String());
                supportSQLiteStatement.bindLong(9, audioSource.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, audioSource.getCom.syu.media.provider.Media.LENGTH java.lang.String());
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `song` (`_id`,`title`,`displayName`,`artist`,`album`,`path`,`folder`,`duration`,`favorite`,`length`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.c = new EntityInsertionAdapter<PlayList>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.2
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlayList playList) {
                supportSQLiteStatement.bindLong(1, playList.getId());
                if (playList.getTitle() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, playList.getTitle());
                }
                supportSQLiteStatement.bindLong(3, playList.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(4, MediaDao_Impl.this.d.toTime(playList.getCreation()));
                supportSQLiteStatement.bindLong(5, playList.getPlayingIndex());
                supportSQLiteStatement.bindLong(6, MediaDao_Impl.this.d.toTime(playList.getUpdateTime()));
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `list` (`playlist_id`,`playlist_title`,`playlist_favorite`,`playlist_creation`,`playlist_playing_index`,`playlist_update`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }
        };
        this.e = new EntityInsertionAdapter<PlayList>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.3
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlayList playList) {
                supportSQLiteStatement.bindLong(1, playList.getId());
                if (playList.getTitle() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, playList.getTitle());
                }
                supportSQLiteStatement.bindLong(3, playList.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(4, MediaDao_Impl.this.d.toTime(playList.getCreation()));
                supportSQLiteStatement.bindLong(5, playList.getPlayingIndex());
                supportSQLiteStatement.bindLong(6, MediaDao_Impl.this.d.toTime(playList.getUpdateTime()));
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `list` (`playlist_id`,`playlist_title`,`playlist_favorite`,`playlist_creation`,`playlist_playing_index`,`playlist_update`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }
        };
        this.f = new EntityInsertionAdapter<PlaylistAudioCrossRef>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.4
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlaylistAudioCrossRef playlistAudioCrossRef) {
                supportSQLiteStatement.bindLong(1, playlistAudioCrossRef.getListId());
                supportSQLiteStatement.bindLong(2, playlistAudioCrossRef.getAudioId());
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `PlaylistAudioCrossRef` (`playlist_id`,`_id`) VALUES (?,?)";
            }
        };
        this.g = new EntityInsertionAdapter<PlaylistVideoCrossRef>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.5
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlaylistVideoCrossRef playlistVideoCrossRef) {
                supportSQLiteStatement.bindLong(1, playlistVideoCrossRef.getListId());
                supportSQLiteStatement.bindLong(2, playlistVideoCrossRef.getVideoId());
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `PlaylistVideoCrossRef` (`playlist_id`,`_id`) VALUES (?,?)";
            }
        };
        this.h = new EntityInsertionAdapter<VideoSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.6
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, VideoSource videoSource) {
                supportSQLiteStatement.bindLong(1, videoSource.getWidth());
                supportSQLiteStatement.bindLong(2, videoSource.getHeight());
                if (videoSource.getId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, videoSource.getId().intValue());
                }
                if (videoSource.getTitle() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, videoSource.getTitle());
                }
                if (videoSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, videoSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.ARTIST java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, videoSource.getCom.syu.media.provider.Media.ARTIST java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.ALBUM java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, videoSource.getCom.syu.media.provider.Media.ALBUM java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.PATH java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, videoSource.getCom.syu.media.provider.Media.PATH java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.FOLDER java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, videoSource.getCom.syu.media.provider.Media.FOLDER java.lang.String());
                }
                supportSQLiteStatement.bindLong(10, videoSource.getCom.syu.media.provider.Media.DURATION java.lang.String());
                supportSQLiteStatement.bindLong(11, videoSource.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(12, videoSource.getCom.syu.media.provider.Media.LENGTH java.lang.String());
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `video` (`width`,`height`,`_id`,`title`,`displayName`,`artist`,`album`,`path`,`folder`,`duration`,`favorite`,`length`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.i = new EntityInsertionAdapter<RadioSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.7
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RadioSource radioSource) {
                if (radioSource.getCom.syu.media.provider.Media.TYPE java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, radioSource.getCom.syu.media.provider.Media.TYPE java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.COUNTRY java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, radioSource.getCom.syu.media.provider.Media.COUNTRY java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.LOCAL java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, radioSource.getCom.syu.media.provider.Media.LOCAL java.lang.String());
                }
                if (radioSource.getFreqTitle() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, radioSource.getFreqTitle());
                }
                if (radioSource.getCom.syu.media.provider.Media.ICON java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, radioSource.getCom.syu.media.provider.Media.ICON java.lang.String());
                }
                if (radioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, radioSource.getId().intValue());
                }
                if (radioSource.getTitle() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, radioSource.getTitle());
                }
                if (radioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, radioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, radioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, radioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.PATH java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, radioSource.getCom.syu.media.provider.Media.PATH java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, radioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String());
                }
                supportSQLiteStatement.bindLong(13, radioSource.getCom.syu.media.provider.Media.DURATION java.lang.String());
                supportSQLiteStatement.bindLong(14, radioSource.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(15, radioSource.getCom.syu.media.provider.Media.LENGTH java.lang.String());
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `radio` (`type`,`country`,`local`,`freq`,`icon`,`_id`,`title`,`displayName`,`artist`,`album`,`path`,`folder`,`duration`,`favorite`,`length`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.j = new EntityInsertionAdapter<PlaylistRadioCrossRef>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.8
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlaylistRadioCrossRef playlistRadioCrossRef) {
                supportSQLiteStatement.bindLong(1, playlistRadioCrossRef.getListId());
                supportSQLiteStatement.bindLong(2, playlistRadioCrossRef.getRadioId());
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `PlaylistRadioCrossRef` (`playlist_id`,`_id`) VALUES (?,?)";
            }
        };
        this.k = new EntityDeletionOrUpdateAdapter<AudioSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.9
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AudioSource audioSource) {
                if (audioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, audioSource.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `song` WHERE `_id` = ?";
            }
        };
        this.l = new EntityDeletionOrUpdateAdapter<VideoSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.10
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, VideoSource videoSource) {
                if (videoSource.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, videoSource.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `video` WHERE `_id` = ?";
            }
        };
        this.m = new EntityDeletionOrUpdateAdapter<RadioSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.11
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RadioSource radioSource) {
                if (radioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, radioSource.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `radio` WHERE `_id` = ?";
            }
        };
        this.n = new EntityDeletionOrUpdateAdapter<AudioSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.12
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AudioSource audioSource) {
                if (audioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, audioSource.getId().intValue());
                }
                if (audioSource.getTitle() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, audioSource.getTitle());
                }
                if (audioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, audioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, audioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, audioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.PATH java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, audioSource.getCom.syu.media.provider.Media.PATH java.lang.String());
                }
                if (audioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, audioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String());
                }
                supportSQLiteStatement.bindLong(8, audioSource.getCom.syu.media.provider.Media.DURATION java.lang.String());
                supportSQLiteStatement.bindLong(9, audioSource.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, audioSource.getCom.syu.media.provider.Media.LENGTH java.lang.String());
                if (audioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, audioSource.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `song` SET `_id` = ?,`title` = ?,`displayName` = ?,`artist` = ?,`album` = ?,`path` = ?,`folder` = ?,`duration` = ?,`favorite` = ?,`length` = ? WHERE `_id` = ?";
            }
        };
        this.o = new EntityDeletionOrUpdateAdapter<PlayList>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.13
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlayList playList) {
                supportSQLiteStatement.bindLong(1, playList.getId());
                if (playList.getTitle() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, playList.getTitle());
                }
                supportSQLiteStatement.bindLong(3, playList.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(4, MediaDao_Impl.this.d.toTime(playList.getCreation()));
                supportSQLiteStatement.bindLong(5, playList.getPlayingIndex());
                supportSQLiteStatement.bindLong(6, MediaDao_Impl.this.d.toTime(playList.getUpdateTime()));
                supportSQLiteStatement.bindLong(7, playList.getId());
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `list` SET `playlist_id` = ?,`playlist_title` = ?,`playlist_favorite` = ?,`playlist_creation` = ?,`playlist_playing_index` = ?,`playlist_update` = ? WHERE `playlist_id` = ?";
            }
        };
        this.p = new EntityDeletionOrUpdateAdapter<VideoSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.14
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, VideoSource videoSource) {
                supportSQLiteStatement.bindLong(1, videoSource.getWidth());
                supportSQLiteStatement.bindLong(2, videoSource.getHeight());
                if (videoSource.getId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, videoSource.getId().intValue());
                }
                if (videoSource.getTitle() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, videoSource.getTitle());
                }
                if (videoSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, videoSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.ARTIST java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, videoSource.getCom.syu.media.provider.Media.ARTIST java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.ALBUM java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, videoSource.getCom.syu.media.provider.Media.ALBUM java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.PATH java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, videoSource.getCom.syu.media.provider.Media.PATH java.lang.String());
                }
                if (videoSource.getCom.syu.media.provider.Media.FOLDER java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, videoSource.getCom.syu.media.provider.Media.FOLDER java.lang.String());
                }
                supportSQLiteStatement.bindLong(10, videoSource.getCom.syu.media.provider.Media.DURATION java.lang.String());
                supportSQLiteStatement.bindLong(11, videoSource.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(12, videoSource.getCom.syu.media.provider.Media.LENGTH java.lang.String());
                if (videoSource.getId() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, videoSource.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `video` SET `width` = ?,`height` = ?,`_id` = ?,`title` = ?,`displayName` = ?,`artist` = ?,`album` = ?,`path` = ?,`folder` = ?,`duration` = ?,`favorite` = ?,`length` = ? WHERE `_id` = ?";
            }
        };
        this.q = new EntityDeletionOrUpdateAdapter<RadioSource>(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.15
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RadioSource radioSource) {
                if (radioSource.getCom.syu.media.provider.Media.TYPE java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, radioSource.getCom.syu.media.provider.Media.TYPE java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.COUNTRY java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, radioSource.getCom.syu.media.provider.Media.COUNTRY java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.LOCAL java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, radioSource.getCom.syu.media.provider.Media.LOCAL java.lang.String());
                }
                if (radioSource.getFreqTitle() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, radioSource.getFreqTitle());
                }
                if (radioSource.getCom.syu.media.provider.Media.ICON java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, radioSource.getCom.syu.media.provider.Media.ICON java.lang.String());
                }
                if (radioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, radioSource.getId().intValue());
                }
                if (radioSource.getTitle() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, radioSource.getTitle());
                }
                if (radioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, radioSource.getCom.syu.media.provider.Media.DISPLAY_NAME java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, radioSource.getCom.syu.media.provider.Media.ARTIST java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, radioSource.getCom.syu.media.provider.Media.ALBUM java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.PATH java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, radioSource.getCom.syu.media.provider.Media.PATH java.lang.String());
                }
                if (radioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, radioSource.getCom.syu.media.provider.Media.FOLDER java.lang.String());
                }
                supportSQLiteStatement.bindLong(13, radioSource.getCom.syu.media.provider.Media.DURATION java.lang.String());
                supportSQLiteStatement.bindLong(14, radioSource.getFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(15, radioSource.getCom.syu.media.provider.Media.LENGTH java.lang.String());
                if (radioSource.getId() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindLong(16, radioSource.getId().intValue());
                }
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `radio` SET `type` = ?,`country` = ?,`local` = ?,`freq` = ?,`icon` = ?,`_id` = ?,`title` = ?,`displayName` = ?,`artist` = ?,`album` = ?,`path` = ?,`folder` = ?,`duration` = ?,`favorite` = ?,`length` = ? WHERE `_id` = ?";
            }
        };
        this.r = new SharedSQLiteStatement(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM song WHERE path LIKE ? || '%'";
            }
        };
        this.s = new SharedSQLiteStatement(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM video WHERE path LIKE ? || '%'";
            }
        };
        this.t = new SharedSQLiteStatement(roomDatabase) { // from class: com.syu.media.dao.MediaDao_Impl.18
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM radio WHERE path LIKE ? || '%'";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public final void a(LongSparseArray longSparseArray) {
        longSparseArray = longSparseArray;
        if (longSparseArray.isEmpty()) {
            return;
        }
        if (longSparseArray.size() > 999) {
            LongSparseArray longSparseArray2 = new LongSparseArray(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            int size = longSparseArray.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                longSparseArray2.put(longSparseArray.keyAt(i), (ArrayList) longSparseArray.valueAt(i));
                i++;
                i2++;
                if (i2 == 999) {
                    a(longSparseArray2);
                    longSparseArray2 = new LongSparseArray(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                    i2 = 0;
                }
            }
            if (i2 > 0) {
                a(longSparseArray2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `radio`.`type` AS `type`,`radio`.`country` AS `country`,`radio`.`local` AS `local`,`radio`.`freq` AS `freq`,`radio`.`icon` AS `icon`,`radio`.`_id` AS `_id`,`radio`.`title` AS `title`,`radio`.`displayName` AS `displayName`,`radio`.`artist` AS `artist`,`radio`.`album` AS `album`,`radio`.`path` AS `path`,`radio`.`folder` AS `folder`,`radio`.`duration` AS `duration`,`radio`.`favorite` AS `favorite`,`radio`.`length` AS `length`,_junction.`playlist_id` FROM `PlaylistRadioCrossRef` AS _junction INNER JOIN `radio` ON (_junction.`_id` = `radio`.`_id`) WHERE _junction.`playlist_id` IN (");
        int size2 = longSparseArray.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size2);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size2 + 0);
        int i3 = 1;
        for (int i4 = 0; i4 < longSparseArray.size(); i4++) {
            roomSQLiteQueryAcquire.bindLong(i3, longSparseArray.keyAt(i4));
            i3++;
        }
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            while (cursorQuery.moveToNext()) {
                int i5 = columnIndexOrThrow15;
                int i6 = columnIndexOrThrow11;
                int i7 = columnIndexOrThrow12;
                ArrayList arrayList = (ArrayList) longSparseArray.get(cursorQuery.getLong(15));
                if (arrayList != null) {
                    RadioSource radioSource = new RadioSource();
                    radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    radioSource.setPath(cursorQuery.isNull(i6) ? null : cursorQuery.getString(i6));
                    radioSource.setFolder(cursorQuery.isNull(i7) ? null : cursorQuery.getString(i7));
                    radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                    columnIndexOrThrow14 = columnIndexOrThrow14;
                    radioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow14) != 0);
                    radioSource.setLength(cursorQuery.getInt(i5));
                    arrayList.add(radioSource);
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow11 = i6;
                    columnIndexOrThrow12 = i7;
                } else {
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow11 = i6;
                    columnIndexOrThrow12 = i7;
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> audiosByAlum(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE album = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.32
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> audiosByArtist(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE artist = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.33
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> audiosByFolder(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE folder = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.34
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> audiosByRootFolder(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE path LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.35
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> audiosByRootFolderAndAlbum(String str, String str2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE album = ? AND path LIKE ? || '%' ORDER BY _id", 2);
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str2);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.37
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> audiosByRootFolderAndArtist(String str, String str2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE artist = ? AND path LIKE ? || '%' ORDER BY _id", 2);
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str2);
        }
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.36
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    public final void b(LongSparseArray longSparseArray) {
        if (longSparseArray.isEmpty()) {
            return;
        }
        if (longSparseArray.size() > 999) {
            LongSparseArray longSparseArray2 = new LongSparseArray(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            int size = longSparseArray.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                longSparseArray2.put(longSparseArray.keyAt(i), (ArrayList) longSparseArray.valueAt(i));
                i++;
                i2++;
                if (i2 == 999) {
                    b(longSparseArray2);
                    longSparseArray2 = new LongSparseArray(RoomDatabase.MAX_BIND_PARAMETER_CNT);
                    i2 = 0;
                }
            }
            if (i2 > 0) {
                b(longSparseArray2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `song`.`_id` AS `_id`,`song`.`title` AS `title`,`song`.`displayName` AS `displayName`,`song`.`artist` AS `artist`,`song`.`album` AS `album`,`song`.`path` AS `path`,`song`.`folder` AS `folder`,`song`.`duration` AS `duration`,`song`.`favorite` AS `favorite`,`song`.`length` AS `length`,_junction.`playlist_id` FROM `PlaylistAudioCrossRef` AS _junction INNER JOIN `song` ON (_junction.`_id` = `song`.`_id`) WHERE _junction.`playlist_id` IN (");
        int size2 = longSparseArray.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size2);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size2 + 0);
        int i3 = 1;
        for (int i4 = 0; i4 < longSparseArray.size(); i4++) {
            roomSQLiteQueryAcquire.bindLong(i3, longSparseArray.keyAt(i4));
            i3++;
        }
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            while (cursorQuery.moveToNext()) {
                int i5 = columnIndexOrThrow2;
                ArrayList arrayList = (ArrayList) longSparseArray.get(cursorQuery.getLong(10));
                if (arrayList != null) {
                    AudioSource audioSource = new AudioSource();
                    audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                    columnIndexOrThrow2 = i5;
                    audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                    audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                    audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                    audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                    arrayList.add(audioSource);
                } else {
                    columnIndexOrThrow2 = i5;
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<String> countries() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT country FROM radio ORDER BY _id", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> countriesFlow() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT country FROM radio ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.63
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public void delete(AudioSource... audioSourceArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.k.handleMultiple(audioSourceArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void deleteAudioSource(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.r.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.r.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void deleteRadioSource(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.t.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.t.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void deleteVideoSource(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.s.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.s.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> favoritesByAlbum(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE favorite = 1 AND album = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.38
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> favoritesByArtist(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE favorite = 1 AND artist = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.39
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> favoritesByFolder(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE favorite = 1 AND folder = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.40
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getAlbums() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT album FROM song", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.27
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getAlbumsByPath(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT album FROM song WHERE path LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.29
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getAlbumsWithFavorite() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT album FROM song WHERE favorite = 1", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.28
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> getAllAudioSources() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.19
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<RadioSource>> getAllRadios() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<RadioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.51
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioSource radioSource = new RadioSource();
                        radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                        radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                        i = i;
                        radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                        int i2 = columnIndexOrThrow15;
                        int i3 = columnIndexOrThrow13;
                        radioSource.setLength(cursorQuery.getInt(i2));
                        arrayList.add(radioSource);
                        columnIndexOrThrow13 = i3;
                        columnIndexOrThrow15 = i2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<VideoSource>> getAllVideos() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM video ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.VIDEO_TABLE}, new Callable<List<VideoSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.45
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<VideoSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_WIDTH);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_HEIGHT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        int i = columnIndexOrThrow;
                        VideoSource videoSource = new VideoSource(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2));
                        videoSource.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                        videoSource.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        videoSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        videoSource.setArtist(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        videoSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        videoSource.setPath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        videoSource.setFolder(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        videoSource.setDuration(cursorQuery.getInt(columnIndexOrThrow10));
                        videoSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow11) != 0);
                        videoSource.setLength(cursorQuery.getInt(columnIndexOrThrow12));
                        arrayList.add(videoSource);
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getArtists() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT artist FROM song", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.24
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getArtistsByPath(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT artist FROM song WHERE path LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.26
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getArtistsWithFavorite() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT artist FROM song WHERE favorite = 1", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.25
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public int getAudioSourceId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id FROM song WHERE path = ? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesByAlbumAndPath(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE album = ?  AND path LIKE ? || '%' ORDER BY _id", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesByAlbumAndPathAndFavorite(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE album = ?  AND favorite = 1 AND path LIKE ? || '%' ORDER BY _id", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesByArtistAndPath(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE artist = ? AND path LIKE ? || '%' ORDER BY _id", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesByArtistAndPathAndFavorite(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE artist = ? AND favorite = 1 AND path LIKE ? || '%' ORDER BY _id", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> getAudioSourcesFlowWithFilter(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE folder LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.20
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesOfAlbum(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE album = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                audioSource.setId(numValueOf);
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
                numValueOf = null;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesOfArtist(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE artist = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                audioSource.setId(numValueOf);
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
                numValueOf = null;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesWithFolder(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE folder = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                audioSource.setId(numValueOf);
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
                numValueOf = null;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesWithFolderAndFavorite(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE favorite = 1 AND folder = ? AND folder LIKE ? || '%' ORDER BY _id", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> getAudioSourcesWithFolderAndParent(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE folder = ? AND folder LIKE ? || '%' ORDER BY _id", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public AudioSource getExistsAudioSource(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE path = ? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        AudioSource audioSource = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            if (cursorQuery.moveToFirst()) {
                AudioSource audioSource2 = new AudioSource();
                audioSource2.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                audioSource2.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource2.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource2.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource2.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource2.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                if (!cursorQuery.isNull(columnIndexOrThrow7)) {
                    string = cursorQuery.getString(columnIndexOrThrow7);
                }
                audioSource2.setFolder(string);
                audioSource2.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource2.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource2.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                audioSource = audioSource2;
            }
            return audioSource;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public PlayList getExistsPlaylist(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list WHERE playlist_id = ? LIMIT 1", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.a.assertNotSuspendingTransaction();
        PlayList playList = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
            if (cursorQuery.moveToFirst()) {
                playList = new PlayList(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0, this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                playList.setUpdateTime(this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
            }
            return playList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public RadioSource getExistsRadioSource(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RadioSource radioSource;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE path = ? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                if (cursorQuery.moveToFirst()) {
                    RadioSource radioSource2 = new RadioSource();
                    radioSource2.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    radioSource2.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    radioSource2.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    radioSource2.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    radioSource2.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    radioSource2.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    radioSource2.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    radioSource2.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    radioSource2.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    radioSource2.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    radioSource2.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    radioSource2.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    radioSource2.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                    radioSource2.setFavorite(cursorQuery.getInt(columnIndexOrThrow14) != 0);
                    radioSource2.setLength(cursorQuery.getInt(columnIndexOrThrow15));
                    radioSource = radioSource2;
                } else {
                    radioSource = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return radioSource;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public VideoSource getExistsVideoSource(String str) {
        VideoSource videoSource;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM video WHERE path = ? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_WIDTH);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_HEIGHT);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            if (cursorQuery.moveToFirst()) {
                videoSource = new VideoSource(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2));
                videoSource.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                videoSource.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                videoSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                videoSource.setArtist(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                videoSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                videoSource.setPath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                videoSource.setFolder(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                videoSource.setDuration(cursorQuery.getInt(columnIndexOrThrow10));
                videoSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow11) != 0);
                videoSource.setLength(cursorQuery.getInt(columnIndexOrThrow12));
            } else {
                videoSource = null;
            }
            return videoSource;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> getFavorites() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE favorite = 1 ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.30
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<AudioSource>> getFavoritesByPath(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE favorite = 1  AND path LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<AudioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.31
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<AudioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        AudioSource audioSource = new AudioSource();
                        audioSource.setId(cursorQuery.isNull(columnIndexOrThrow) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow)));
                        audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                        audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                        audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                        arrayList.add(audioSource);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public List<String> getFolders() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT folder FROM song", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getFoldersByPath(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT folder FROM song WHERE path LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.23
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getFoldersFlow() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT folder FROM song", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.21
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getFoldersOfVideo() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT folder FROM video", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.VIDEO_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.46
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getFoldersOfVideoWithFavorite() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT folder FROM song WHERE favorite = 1", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.49
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getFoldersOfVideoWithFolder(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT folder FROM video WHERE path LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.VIDEO_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.48
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> getFoldersWithFavorite() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT folder FROM song WHERE favorite = 1", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.SONG_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.22
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<PlayListWithRadios> getOnlinePlayListById(int i) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list WHERE playlist_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        return CoroutinesRoom.createFlow(this.a, true, new String[]{"PlaylistRadioCrossRef", Media.ONLINE_TABLE, Media.LIST_TABLE}, new Callable<PlayListWithRadios>() { // from class: com.syu.media.dao.MediaDao_Impl.43
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PlayListWithRadios call() {
                MediaDao_Impl.this.a.beginTransaction();
                try {
                    boolean z = true;
                    PlayListWithRadios playListWithRadios = null;
                    PlayList playList = null;
                    Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            if (((ArrayList) longSparseArray.get(j)) == null) {
                                longSparseArray.put(j, new ArrayList());
                            }
                        }
                        cursorQuery.moveToPosition(-1);
                        MediaDao_Impl.this.a(longSparseArray);
                        if (cursorQuery.moveToFirst()) {
                            if (!cursorQuery.isNull(columnIndexOrThrow) || !cursorQuery.isNull(columnIndexOrThrow2) || !cursorQuery.isNull(columnIndexOrThrow3) || !cursorQuery.isNull(columnIndexOrThrow4) || !cursorQuery.isNull(columnIndexOrThrow5) || !cursorQuery.isNull(columnIndexOrThrow6)) {
                                int i2 = cursorQuery.getInt(columnIndexOrThrow);
                                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                                if (cursorQuery.getInt(columnIndexOrThrow3) == 0) {
                                    z = false;
                                }
                                PlayList playList2 = new PlayList(i2, string, z, MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                                playList2.setUpdateTime(MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
                                playList = playList2;
                            }
                            ArrayList arrayList = (ArrayList) longSparseArray.get(cursorQuery.getLong(columnIndexOrThrow));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            playListWithRadios = new PlayListWithRadios(playList, arrayList);
                        }
                        MediaDao_Impl.this.a.setTransactionSuccessful();
                        cursorQuery.close();
                        MediaDao_Impl.this.a.endTransaction();
                        return playListWithRadios;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    MediaDao_Impl.this.a.endTransaction();
                    throw th2;
                }
            }

            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<PlayListWithAudios> getPlayListById(int i) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list WHERE playlist_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        return CoroutinesRoom.createFlow(this.a, true, new String[]{"PlaylistAudioCrossRef", Media.SONG_TABLE, Media.LIST_TABLE}, new Callable<PlayListWithAudios>() { // from class: com.syu.media.dao.MediaDao_Impl.42
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PlayListWithAudios call() {
                MediaDao_Impl.this.a.beginTransaction();
                try {
                    boolean z = true;
                    PlayListWithAudios playListWithAudios = null;
                    PlayList playList = null;
                    Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            if (((ArrayList) longSparseArray.get(j)) == null) {
                                longSparseArray.put(j, new ArrayList());
                            }
                        }
                        cursorQuery.moveToPosition(-1);
                        MediaDao_Impl.this.b(longSparseArray);
                        if (cursorQuery.moveToFirst()) {
                            if (!cursorQuery.isNull(columnIndexOrThrow) || !cursorQuery.isNull(columnIndexOrThrow2) || !cursorQuery.isNull(columnIndexOrThrow3) || !cursorQuery.isNull(columnIndexOrThrow4) || !cursorQuery.isNull(columnIndexOrThrow5) || !cursorQuery.isNull(columnIndexOrThrow6)) {
                                int i2 = cursorQuery.getInt(columnIndexOrThrow);
                                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                                if (cursorQuery.getInt(columnIndexOrThrow3) == 0) {
                                    z = false;
                                }
                                PlayList playList2 = new PlayList(i2, string, z, MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                                playList2.setUpdateTime(MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
                                playList = playList2;
                            }
                            ArrayList arrayList = (ArrayList) longSparseArray.get(cursorQuery.getLong(columnIndexOrThrow));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            playListWithAudios = new PlayListWithAudios(playList, arrayList);
                        }
                        MediaDao_Impl.this.a.setTransactionSuccessful();
                        cursorQuery.close();
                        MediaDao_Impl.this.a.endTransaction();
                        return playListWithAudios;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    MediaDao_Impl.this.a.endTransaction();
                    throw th2;
                }
            }

            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<PlayListWithAudios> getPlayListByName(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list WHERE playlist_title = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, true, new String[]{"PlaylistAudioCrossRef", Media.SONG_TABLE, Media.LIST_TABLE}, new Callable<PlayListWithAudios>() { // from class: com.syu.media.dao.MediaDao_Impl.41
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PlayListWithAudios call() {
                MediaDao_Impl.this.a.beginTransaction();
                try {
                    boolean z = true;
                    PlayListWithAudios playListWithAudios = null;
                    PlayList playList = null;
                    Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            if (((ArrayList) longSparseArray.get(j)) == null) {
                                longSparseArray.put(j, new ArrayList());
                            }
                        }
                        cursorQuery.moveToPosition(-1);
                        MediaDao_Impl.this.b(longSparseArray);
                        if (cursorQuery.moveToFirst()) {
                            if (!cursorQuery.isNull(columnIndexOrThrow) || !cursorQuery.isNull(columnIndexOrThrow2) || !cursorQuery.isNull(columnIndexOrThrow3) || !cursorQuery.isNull(columnIndexOrThrow4) || !cursorQuery.isNull(columnIndexOrThrow5) || !cursorQuery.isNull(columnIndexOrThrow6)) {
                                int i = cursorQuery.getInt(columnIndexOrThrow);
                                String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                                if (cursorQuery.getInt(columnIndexOrThrow3) == 0) {
                                    z = false;
                                }
                                PlayList playList2 = new PlayList(i, string, z, MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                                playList2.setUpdateTime(MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
                                playList = playList2;
                            }
                            ArrayList arrayList = (ArrayList) longSparseArray.get(cursorQuery.getLong(columnIndexOrThrow));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            playListWithAudios = new PlayListWithAudios(playList, arrayList);
                        }
                        MediaDao_Impl.this.a.setTransactionSuccessful();
                        cursorQuery.close();
                        MediaDao_Impl.this.a.endTransaction();
                        return playListWithAudios;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    MediaDao_Impl.this.a.endTransaction();
                    throw th2;
                }
            }

            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public int getPlayListId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT playlist_id FROM list WHERE playlist_title = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<PlayListWithAudios>> getPlayListWithAudios() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list", 0);
        return CoroutinesRoom.createFlow(this.a, true, new String[]{"PlaylistAudioCrossRef", Media.SONG_TABLE, Media.LIST_TABLE}, new Callable<List<PlayListWithAudios>>() { // from class: com.syu.media.dao.MediaDao_Impl.44
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<PlayListWithAudios> call() {
                PlayList playList;
                MediaDao_Impl.this.a.beginTransaction();
                try {
                    boolean z = true;
                    Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            if (((ArrayList) longSparseArray.get(j)) == null) {
                                longSparseArray.put(j, new ArrayList());
                            }
                        }
                        cursorQuery.moveToPosition(-1);
                        MediaDao_Impl.this.b(longSparseArray);
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            if (cursorQuery.isNull(columnIndexOrThrow) && cursorQuery.isNull(columnIndexOrThrow2) && cursorQuery.isNull(columnIndexOrThrow3) && cursorQuery.isNull(columnIndexOrThrow4) && cursorQuery.isNull(columnIndexOrThrow5) && cursorQuery.isNull(columnIndexOrThrow6)) {
                                playList = null;
                            } else {
                                playList = new PlayList(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0 ? z : false, MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                                playList.setUpdateTime(MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
                            }
                            ArrayList arrayList2 = (ArrayList) longSparseArray.get(cursorQuery.getLong(columnIndexOrThrow));
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList.add(new PlayListWithAudios(playList, arrayList2));
                            z = true;
                        }
                        MediaDao_Impl.this.a.setTransactionSuccessful();
                        cursorQuery.close();
                        MediaDao_Impl.this.a.endTransaction();
                        return arrayList;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    MediaDao_Impl.this.a.endTransaction();
                    throw th2;
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<PlayListWithRadios>> getPlayListWithRadios() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list", 0);
        return CoroutinesRoom.createFlow(this.a, true, new String[]{"PlaylistRadioCrossRef", Media.ONLINE_TABLE, Media.LIST_TABLE}, new Callable<List<PlayListWithRadios>>() { // from class: com.syu.media.dao.MediaDao_Impl.64
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<PlayListWithRadios> call() {
                PlayList playList;
                MediaDao_Impl.this.a.beginTransaction();
                try {
                    boolean z = true;
                    Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        while (cursorQuery.moveToNext()) {
                            long j = cursorQuery.getLong(columnIndexOrThrow);
                            if (((ArrayList) longSparseArray.get(j)) == null) {
                                longSparseArray.put(j, new ArrayList());
                            }
                        }
                        cursorQuery.moveToPosition(-1);
                        MediaDao_Impl.this.a(longSparseArray);
                        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                        while (cursorQuery.moveToNext()) {
                            if (cursorQuery.isNull(columnIndexOrThrow) && cursorQuery.isNull(columnIndexOrThrow2) && cursorQuery.isNull(columnIndexOrThrow3) && cursorQuery.isNull(columnIndexOrThrow4) && cursorQuery.isNull(columnIndexOrThrow5) && cursorQuery.isNull(columnIndexOrThrow6)) {
                                playList = null;
                            } else {
                                playList = new PlayList(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3) != 0 ? z : false, MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                                playList.setUpdateTime(MediaDao_Impl.this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
                            }
                            ArrayList arrayList2 = (ArrayList) longSparseArray.get(cursorQuery.getLong(columnIndexOrThrow));
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList.add(new PlayListWithRadios(playList, arrayList2));
                            z = true;
                        }
                        MediaDao_Impl.this.a.setTransactionSuccessful();
                        cursorQuery.close();
                        MediaDao_Impl.this.a.endTransaction();
                        return arrayList;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    MediaDao_Impl.this.a.endTransaction();
                    throw th2;
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<RadioSource>> getRadioFavorites() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE favorite = 1 ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<RadioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.52
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioSource radioSource = new RadioSource();
                        radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                        radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                        i = i;
                        radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                        int i2 = columnIndexOrThrow15;
                        int i3 = columnIndexOrThrow13;
                        radioSource.setLength(cursorQuery.getInt(i2));
                        arrayList.add(radioSource);
                        columnIndexOrThrow13 = i3;
                        columnIndexOrThrow15 = i2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public List<RadioSource> getRadiosByCountry(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE country LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    RadioSource radioSource = new RadioSource();
                    radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                    i = i;
                    radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                    int i2 = columnIndexOrThrow15;
                    int i3 = columnIndexOrThrow11;
                    radioSource.setLength(cursorQuery.getInt(i2));
                    arrayList.add(radioSource);
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<RadioSource> getRadiosByCountryAndType(String str, String str2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE country LIKE ? || '%' AND type LIKE ? || '%'", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    RadioSource radioSource = new RadioSource();
                    radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                    i = i;
                    radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                    int i2 = columnIndexOrThrow15;
                    int i3 = columnIndexOrThrow11;
                    radioSource.setLength(cursorQuery.getInt(i2));
                    arrayList.add(radioSource);
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<RadioSource>> getRadiosByCountryAndTypeFlow(String str, String str2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE country LIKE ? || '%' AND type LIKE ? || '%'", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<RadioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.54
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioSource radioSource = new RadioSource();
                        radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                        radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                        i = i;
                        radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                        int i2 = columnIndexOrThrow15;
                        int i3 = columnIndexOrThrow13;
                        radioSource.setLength(cursorQuery.getInt(i2));
                        arrayList.add(radioSource);
                        columnIndexOrThrow13 = i3;
                        columnIndexOrThrow15 = i2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<RadioSource>> getRadiosByCountryFlow(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE country LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<RadioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.53
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioSource radioSource = new RadioSource();
                        radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                        radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                        i = i;
                        radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                        int i2 = columnIndexOrThrow15;
                        int i3 = columnIndexOrThrow13;
                        radioSource.setLength(cursorQuery.getInt(i2));
                        arrayList.add(radioSource);
                        columnIndexOrThrow13 = i3;
                        columnIndexOrThrow15 = i2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public List<RadioSource> getRadiosByLocal(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE local LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    RadioSource radioSource = new RadioSource();
                    radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                    i = i;
                    radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                    int i2 = columnIndexOrThrow15;
                    int i3 = columnIndexOrThrow11;
                    radioSource.setLength(cursorQuery.getInt(i2));
                    arrayList.add(radioSource);
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<RadioSource> getRadiosByLocalAndType(String str, String str2) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE local LIKE ? || '%' AND type LIKE ? || '%'", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    RadioSource radioSource = new RadioSource();
                    radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                    i = i;
                    radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                    int i2 = columnIndexOrThrow15;
                    int i3 = columnIndexOrThrow11;
                    radioSource.setLength(cursorQuery.getInt(i2));
                    arrayList.add(radioSource);
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<RadioSource>> getRadiosByLocalAndTypeFlow(String str, String str2) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE local LIKE ? || '%' AND type LIKE ? || '%'", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<RadioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.57
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioSource radioSource = new RadioSource();
                        radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                        radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                        i = i;
                        radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                        int i2 = columnIndexOrThrow15;
                        int i3 = columnIndexOrThrow13;
                        radioSource.setLength(cursorQuery.getInt(i2));
                        arrayList.add(radioSource);
                        columnIndexOrThrow13 = i3;
                        columnIndexOrThrow15 = i2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<RadioSource>> getRadiosByLocalFlow(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE local LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<RadioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.56
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioSource radioSource = new RadioSource();
                        radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                        radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                        i = i;
                        radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                        int i2 = columnIndexOrThrow15;
                        int i3 = columnIndexOrThrow13;
                        radioSource.setLength(cursorQuery.getInt(i2));
                        arrayList.add(radioSource);
                        columnIndexOrThrow13 = i3;
                        columnIndexOrThrow15 = i2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public List<RadioSource> getRadiosByType(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE type LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    RadioSource radioSource = new RadioSource();
                    radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                    radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                    radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                    radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                    radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                    radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                    radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                    radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                    radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                    radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                    radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                    radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                    radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                    i = i;
                    radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                    int i2 = columnIndexOrThrow15;
                    int i3 = columnIndexOrThrow11;
                    radioSource.setLength(cursorQuery.getInt(i2));
                    arrayList.add(radioSource);
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow15 = i2;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<RadioSource>> getRadiosByTypeFlow(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM radio WHERE type LIKE ? || '%'", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<RadioSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.55
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<RadioSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.TYPE);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.COUNTRY);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LOCAL);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "freq");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ICON);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    int i = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        RadioSource radioSource = new RadioSource();
                        radioSource.setType(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow));
                        radioSource.setCountry(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        radioSource.setLocal(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        radioSource.setFreqTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        radioSource.setIcon(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        radioSource.setId(cursorQuery.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow6)));
                        radioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        radioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        radioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        radioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow10) ? null : cursorQuery.getString(columnIndexOrThrow10));
                        radioSource.setPath(cursorQuery.isNull(columnIndexOrThrow11) ? null : cursorQuery.getString(columnIndexOrThrow11));
                        radioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getString(columnIndexOrThrow12));
                        radioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow13));
                        i = i;
                        radioSource.setFavorite(cursorQuery.getInt(i) != 0);
                        int i2 = columnIndexOrThrow15;
                        int i3 = columnIndexOrThrow13;
                        radioSource.setLength(cursorQuery.getInt(i2));
                        arrayList.add(radioSource);
                        columnIndexOrThrow13 = i3;
                        columnIndexOrThrow15 = i2;
                        columnIndexOrThrow = columnIndexOrThrow;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<VideoSource>> getVideoFavorites() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM video WHERE favorite = 1 ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.VIDEO_TABLE}, new Callable<List<VideoSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.50
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<VideoSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_WIDTH);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_HEIGHT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        int i = columnIndexOrThrow;
                        VideoSource videoSource = new VideoSource(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2));
                        videoSource.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                        videoSource.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        videoSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        videoSource.setArtist(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        videoSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        videoSource.setPath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        videoSource.setFolder(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        videoSource.setDuration(cursorQuery.getInt(columnIndexOrThrow10));
                        videoSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow11) != 0);
                        videoSource.setLength(cursorQuery.getInt(columnIndexOrThrow12));
                        arrayList.add(videoSource);
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public int getVideoSource(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id FROM video WHERE path = ? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public int getVideoSourceId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT _id FROM video WHERE path = ? LIMIT 1", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<VideoSource>> getVideosByPath(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM video WHERE folder LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.VIDEO_TABLE}, new Callable<List<VideoSource>>() { // from class: com.syu.media.dao.MediaDao_Impl.47
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<VideoSource> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_WIDTH);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_HEIGHT);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        int i = columnIndexOrThrow;
                        VideoSource videoSource = new VideoSource(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2));
                        videoSource.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                        videoSource.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                        videoSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                        videoSource.setArtist(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                        videoSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                        videoSource.setPath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                        videoSource.setFolder(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                        videoSource.setDuration(cursorQuery.getInt(columnIndexOrThrow10));
                        videoSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow11) != 0);
                        videoSource.setLength(cursorQuery.getInt(columnIndexOrThrow12));
                        arrayList.add(videoSource);
                        columnIndexOrThrow = i;
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public List<VideoSource> getVideosWithFolder(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM video WHERE folder = ? ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_WIDTH);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_HEIGHT);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow2;
                VideoSource videoSource = new VideoSource(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2));
                videoSource.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                videoSource.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                videoSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                videoSource.setArtist(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                videoSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                videoSource.setPath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                videoSource.setFolder(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                videoSource.setDuration(cursorQuery.getInt(columnIndexOrThrow10));
                videoSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow11) != 0);
                videoSource.setLength(cursorQuery.getInt(columnIndexOrThrow12));
                arrayList.add(videoSource);
                columnIndexOrThrow = i;
                columnIndexOrThrow2 = i2;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<VideoSource> getVideosWithFolderAndParent(String str, String str2) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM video WHERE folder = ? AND folder LIKE ? || '%' ORDER BY _id", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        if (str2 == null) {
            roomSQLiteQueryAcquire.bindNull(2);
        } else {
            roomSQLiteQueryAcquire.bindString(2, str2);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_WIDTH);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_HEIGHT);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow2;
                VideoSource videoSource = new VideoSource(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2));
                videoSource.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                videoSource.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                videoSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                videoSource.setArtist(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                videoSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                videoSource.setPath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                videoSource.setFolder(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                videoSource.setDuration(cursorQuery.getInt(columnIndexOrThrow10));
                videoSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow11) != 0);
                videoSource.setLength(cursorQuery.getInt(columnIndexOrThrow12));
                arrayList.add(videoSource);
                columnIndexOrThrow = i;
                columnIndexOrThrow2 = i2;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> historicalAudio() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song ORDER BY _id", 0);
        this.a.assertNotSuspendingTransaction();
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                audioSource.setId(numValueOf);
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
                numValueOf = null;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<VideoSource> historicalVideo() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM video ORDER BY _id", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_WIDTH);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.VIDEO_HEIGHT);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                int i = columnIndexOrThrow;
                int i2 = columnIndexOrThrow2;
                VideoSource videoSource = new VideoSource(cursorQuery.getInt(columnIndexOrThrow), cursorQuery.getInt(columnIndexOrThrow2));
                videoSource.setId(cursorQuery.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow3)));
                videoSource.setTitle(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                videoSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                videoSource.setArtist(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                videoSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                videoSource.setPath(cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8));
                videoSource.setFolder(cursorQuery.isNull(columnIndexOrThrow9) ? null : cursorQuery.getString(columnIndexOrThrow9));
                videoSource.setDuration(cursorQuery.getInt(columnIndexOrThrow10));
                videoSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow11) != 0);
                videoSource.setLength(cursorQuery.getInt(columnIndexOrThrow12));
                arrayList.add(videoSource);
                columnIndexOrThrow = i;
                columnIndexOrThrow2 = i2;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void insert(AudioSource... audioSourceArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((Object[]) audioSourceArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> listOfAllAudio() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song ORDER BY _id", 0);
        this.a.assertNotSuspendingTransaction();
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                audioSource.setId(numValueOf);
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
                numValueOf = null;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<AudioSource> listOfFavorite() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM song WHERE favorite = 1 ORDER BY _id", 0);
        this.a.assertNotSuspendingTransaction();
        Integer numValueOf = null;
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "title");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DISPLAY_NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ARTIST);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.ALBUM);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.PATH);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.FOLDER);
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.DURATION);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "favorite");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, Media.LENGTH);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AudioSource audioSource = new AudioSource();
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                audioSource.setId(numValueOf);
                audioSource.setTitle(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                audioSource.setDisplayName(cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                audioSource.setArtist(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4));
                audioSource.setAlbum(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5));
                audioSource.setPath(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6));
                audioSource.setFolder(cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7));
                audioSource.setDuration(cursorQuery.getInt(columnIndexOrThrow8));
                audioSource.setFavorite(cursorQuery.getInt(columnIndexOrThrow9) != 0);
                audioSource.setLength(cursorQuery.getInt(columnIndexOrThrow10));
                arrayList.add(audioSource);
                numValueOf = null;
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<String> locals() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT local FROM radio ORDER BY _id", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<String> localsByCountry(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT local FROM radio WHERE country LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> localsByCountryFlow(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT local FROM radio WHERE country LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.62
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> localsFlow() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT local FROM radio ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.61
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public PlayListWithRadios onlinePlayListById(int i) {
        boolean z = true;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list WHERE playlist_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            PlayListWithRadios playListWithRadios = null;
            PlayList playList = null;
            Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
                LongSparseArray longSparseArray = new LongSparseArray();
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    if (((ArrayList) longSparseArray.get(j)) == null) {
                        longSparseArray.put(j, new ArrayList());
                    }
                }
                cursorQuery.moveToPosition(-1);
                a(longSparseArray);
                if (cursorQuery.moveToFirst()) {
                    if (!cursorQuery.isNull(columnIndexOrThrow) || !cursorQuery.isNull(columnIndexOrThrow2) || !cursorQuery.isNull(columnIndexOrThrow3) || !cursorQuery.isNull(columnIndexOrThrow4) || !cursorQuery.isNull(columnIndexOrThrow5) || !cursorQuery.isNull(columnIndexOrThrow6)) {
                        int i2 = cursorQuery.getInt(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        if (cursorQuery.getInt(columnIndexOrThrow3) == 0) {
                            z = false;
                        }
                        playList = new PlayList(i2, string, z, this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                        playList.setUpdateTime(this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
                    }
                    ArrayList arrayList = (ArrayList) longSparseArray.get(cursorQuery.getLong(columnIndexOrThrow));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    playListWithRadios = new PlayListWithRadios(playList, arrayList);
                }
                this.a.setTransactionSuccessful();
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                this.a.endTransaction();
                return playListWithRadios;
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        } catch (Throwable th2) {
            this.a.endTransaction();
            throw th2;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public PlayListWithAudios playListById(int i) {
        boolean z = true;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM list WHERE playlist_id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            PlayListWithAudios playListWithAudios = null;
            PlayList playList = null;
            Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_title");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_favorite");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_creation");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_playing_index");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playlist_update");
                LongSparseArray longSparseArray = new LongSparseArray();
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(columnIndexOrThrow);
                    if (((ArrayList) longSparseArray.get(j)) == null) {
                        longSparseArray.put(j, new ArrayList());
                    }
                }
                cursorQuery.moveToPosition(-1);
                b(longSparseArray);
                if (cursorQuery.moveToFirst()) {
                    if (!cursorQuery.isNull(columnIndexOrThrow) || !cursorQuery.isNull(columnIndexOrThrow2) || !cursorQuery.isNull(columnIndexOrThrow3) || !cursorQuery.isNull(columnIndexOrThrow4) || !cursorQuery.isNull(columnIndexOrThrow5) || !cursorQuery.isNull(columnIndexOrThrow6)) {
                        int i2 = cursorQuery.getInt(columnIndexOrThrow);
                        String string = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                        if (cursorQuery.getInt(columnIndexOrThrow3) == 0) {
                            z = false;
                        }
                        playList = new PlayList(i2, string, z, this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow4)), cursorQuery.getInt(columnIndexOrThrow5));
                        playList.setUpdateTime(this.d.fromTime(cursorQuery.getLong(columnIndexOrThrow6)));
                    }
                    ArrayList arrayList = (ArrayList) longSparseArray.get(cursorQuery.getLong(columnIndexOrThrow));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    playListWithAudios = new PlayListWithAudios(playList, arrayList);
                }
                this.a.setTransactionSuccessful();
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                this.a.endTransaction();
                return playListWithAudios;
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        } catch (Throwable th2) {
            this.a.endTransaction();
            throw th2;
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<String> types() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT type FROM radio ORDER BY _id", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public List<String> typesByCountry(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT type FROM radio WHERE country LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> typesByCountryFlow(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT type FROM radio WHERE country LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.59
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public List<String> typesByLocal(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT type FROM radio WHERE local LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.a, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> typesByLocalFlow(String str) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT type FROM radio WHERE local LIKE ? || '%' ORDER BY _id", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.60
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public Flow<List<String>> typesFlow() {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT DISTINCT type FROM radio ORDER BY _id", 0);
        return CoroutinesRoom.createFlow(this.a, false, new String[]{Media.ONLINE_TABLE}, new Callable<List<String>>() { // from class: com.syu.media.dao.MediaDao_Impl.58
            public void finalize() {
                roomSQLiteQueryAcquire.release();
            }

            @Override // java.util.concurrent.Callable
            public List<String> call() {
                Cursor cursorQuery = DBUtil.query(MediaDao_Impl.this.a, roomSQLiteQueryAcquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            }
        });
    }

    @Override // com.syu.media.dao.MediaDao
    public void update(PlayList playList) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.o.handle(playList);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void delete(PlayList... playListArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.e.insert((Object[]) playListArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void insert(PlayList... playListArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.insert((Object[]) playListArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void update(RadioSource radioSource) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.q.handle(radioSource);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void delete(RadioSource... radioSourceArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.m.handleMultiple(radioSourceArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void insert(PlaylistAudioCrossRef... playlistAudioCrossRefArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f.insert((Object[]) playlistAudioCrossRefArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void update(VideoSource videoSource) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.p.handle(videoSource);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void delete(VideoSource... videoSourceArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.l.handleMultiple(videoSourceArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void insert(PlaylistRadioCrossRef... playlistRadioCrossRefArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.j.insert((Object[]) playlistRadioCrossRefArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void update(AudioSource... audioSourceArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.n.handleMultiple(audioSourceArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void insert(PlaylistVideoCrossRef... playlistVideoCrossRefArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.g.insert((Object[]) playlistVideoCrossRefArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void insert(RadioSource... radioSourceArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.i.insert((Object[]) radioSourceArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.syu.media.dao.MediaDao
    public void insert(VideoSource... videoSourceArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.h.insert((Object[]) videoSourceArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
