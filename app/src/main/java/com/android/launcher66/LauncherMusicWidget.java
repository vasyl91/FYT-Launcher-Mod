package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.launcher66.settings.Keys;
import com.android.recycler.AppListBean;
import com.fyt.car.IUiRefresher;
import com.fyt.car.LauncherNotify;
import com.fyt.car.MusicService;
import com.fyt.car.StockSources;
import com.fyt.car.StockTitles;
import com.fyt.skin.SkinUtils;
import com.syu.car.CarStates;
import com.syu.util.Id3Info;
import com.syu.util.Lrc;
import com.syu.util.Utils;
import com.syu.util.WindowUtil;
import com.syu.widget.DateMusicProvider;
import com.syu.widget.DateRadioProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import share.Config;
import share.ResValue;

/**
 * The music widget on the home screen and the music bar: what LauncherNotify reports (title,
 * artist, cover, progress, playing state, stock player or MediaSession), the prev / play-pause /
 * next / favorite buttons and the remembered title, artist and cover. Split out of Launcher, which
 * keeps the entry points Workspace and CellLayout call.
 */
final class LauncherMusicWidget {

    // Not final: field initializers below use it in lambdas, which javac rejects for a blank final.
    private Launcher mLauncher;

    LauncherMusicWidget(Launcher launcher) {
        mLauncher = launcher;
    }

    String mediaSource = "fyt";

    AudioManager mAudioManager;

    String activeController;

    String musictitle = null;

    public ImageView ivALbumBg;

    public ImageView ivALbumBgTwo;

    public ImageView ivMusicScore;

    public ImageView ivMusicScore2;

    Button mMusicNextButton;

    Button mMusicNextButtonTwo;

    Button mMusicPrevButton;

    Button mMusicPrevButtonTwo;

    Button mMusicFavoriteButton;

    Button mMusicFavoriteButtonTwo;

    ProgressBar musicProgress;

    SeekBar musicSeekBar;

    Button mPlayPauseButton;

    Button mPlayPauseButtonTwo;

    TextView tvAlbum;

    TextView tvAritst;

    TextView tvAritstTwo;

    TextView tvCurTime;

    TextView tvMusicName;

    TextView tvMusicNameTwo;

    TextView tvTotalTime;

    boolean temporarilyDisablePlayPauseButton = false;

    /**
     * Longest wait for AudioManager.isMusicActive() on the main thread. The answer normally takes a
     * few ms; while the audioserver hangs (at boot on this ROM) the last known one is used instead.
     */
    static final long AUDIO_STATE_WAIT_MS = 100L;

    boolean barTint = false;

    boolean widgetTint = false;

    static final String PREF_LAST_ALBUM_ART = "last_album_art_bitmap";

    static final String PREF_LAST_ALBUM_PATH = "last_album_path";

    /**
     * The title of the track the saved cover belongs to. A track without a cover left the
     * previous one's in the file, and a restart showed it under the new title.
     */
    static final String PREF_LAST_ALBUM_TITLE = "last_album_title";

    static final String MUSIC_TITLE_PREF = "music_title_pref";

    static final String ARTIST_PREF = "artist_pref";

    String lastProcessedPath = null;

    String lastMusictitle = null;

    String lastArtist = null;

    ConstraintLayout prevLayout;

    ConstraintLayout playPauseLayout;

    ConstraintLayout nextLayout;

    ConstraintLayout favoriteLayout;

    ConstraintLayout prevLayoutTwo ;

    ConstraintLayout playPauseLayoutTwo;

    ConstraintLayout nextLayoutTwo;

    ConstraintLayout favoriteLayoutTwo;

    String lastpath = null;

    public IUiRefresher refreshMusic = new IUiRefresher() {
        @Override
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            mLastRefresh = new Object[] { ints, lngs, flts, strs, byts, source };
            mAudioManager = (AudioManager) mLauncher.getSystemService(Context.AUDIO_SERVICE);
            mediaSource = source; 
            if (mediaSource == null) {
                mediaSource = "fyt";
            }
            if (strs == null && !LauncherApplication.isFytDevice()) {
                // Nothing published yet (right after a start, when the listener re-sends what it
                // holds): no stock player here to read instead, and the placeholders below wrote
                // over the last track restored by preSetMusicWidgets().
                setPlayPauseIcon(false);
                return;
            }
            mLauncher.state = null;
            String artist = null;
            String album = null;
            String path = null;
            if (strs != null && strs.length > 5) {
                musictitle = strs[0];
                artist = strs[1];   
                if ("null".equals(artist)) {
                    artist = strs[3];
                }
                if ("null".equals(artist)) {
                    artist = "\u0020";
                }
                mLauncher.state = strs[2];
                album = strs[3];
                path = strs[4];
                activeController = strs[5];
            }
            if (path == null || path.isEmpty()) {
                // Some apps produce null path - we need a value to properly save a bitmap
                path = String.valueOf(Arrays.hashCode(byts));
            }
            if ("mediaController".equals(mediaSource)) {
                boolean activeControllerAppRunning = false;
                MediaSessionManager msm = (MediaSessionManager) mLauncher.getSystemService(Context.MEDIA_SESSION_SERVICE);
                ComponentName component = new ComponentName(mLauncher, NotificationListener.class);
                List<MediaController> controllers = msm.getActiveSessions(component);

                for (MediaController controller : controllers) {
                    if (controller.getPackageName().equals(activeController)) {
                        activeControllerAppRunning = true;
                        break;
                    }
                }
                if (!activeControllerAppRunning) {
                    if (tvMusicName != null) {
                        tvMusicName.setText(R.string.music_name);
                    }
                    if (tvMusicNameTwo != null) {
                        tvMusicNameTwo.setText(R.string.music_name);
                    }
                    if (mPlayPauseButton != null) {
                        mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setWidgetButtonsTint(mPlayPauseButton);
                    }
                    if (mPlayPauseButtonTwo != null) {
                        mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setBarButtonsTint(mPlayPauseButtonTwo);
                    }
                    if (tvAritst != null) {
                        tvAritst.setText(R.string.music_author);
                    }
                    if (tvAritstTwo != null) {
                        tvAritstTwo.setText(R.string.music_author);
                    }
                    if (tvAlbum != null) {
                        tvAlbum.setText(R.string.music_album);
                    }  
                    if (tvCurTime != null) {
                        tvCurTime.setText("00:00");
                    }
                    if (tvTotalTime != null) {
                        tvTotalTime.setText("00:00");
                    }
                    if (musicProgress != null) {
                        musicProgress.setProgress(0);
                    }
                    if (musicSeekBar != null) {
                        musicSeekBar.setOnSeekBarChangeListener(mLauncher.new OnSeekBarChangeListenerImp(mLauncher, null));
                    }
                    updateFavoriteButtonState(MediaFavoriteController.FAVORITE_STATE_UNKNOWN);
                    return;         
                }
            }

            updateFavoriteButtonState();
            setPlayPauseIcon(false);

            if ("true".equals(mLauncher.state)) {
                saveLastPlayer(currentPlayerPackage());
                boolean coverPending = !isId3Read(path);
                byte[] dataPic = coverPending ? null : mId3Pic;
                if (dataPic == null) {
                    dataPic = byts;
                }
                if (coverPending && (dataPic == null || dataPic.length == 0)) {
                    // The file's own cover is being read: the one shown stays until it lands
                } else if (dataPic != null && dataPic.length > 0) {
                    Bitmap bp = BitmapFactory.decodeByteArray(dataPic, 0, dataPic.length);
                    if (bp != null) {
                        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.music_bitmap_circular)) {
                            if (Utils.getNameToBool("isRoundedCorner")) {
                                bp = Launcher.GetRoundedCornerBitmap(bp);
                            } else {
                                bp = Launcher.makeRoundCorner(bp);
                            }
                        }
                        
                        // Only save if this is a new path
                        if (!path.equals(lastProcessedPath)) {
                            saveBitmapToPreferences(bp, path);
                        }
                        
                        Drawable drawable = new BitmapDrawable(mLauncher.getApplicationContext().getResources(), bp);
                        if (ivALbumBg != null) {
                            ivALbumBg.setImageDrawable(drawable);
                        }
                        if (ivALbumBgTwo != null) {
                            ivALbumBgTwo.setImageDrawable(drawable);
                        }
                    }
                } else if ("mediaController".equals(mediaSource)
                        && playerIcon(currentPlayerPackage()) != null) {
                    // No cover, a third-party session: the player's icon, as for every other app.
                    // The stock players (com.syu.music, com.syu.media) are deliberately left out so
                    // they fall through to music_album_def below, not their app icon.
                    //
                    // Shown and kept under this track's title (the path names both, so the next
                    // track of the same player is saved again).
                    lastpath = null;
                    String player = currentPlayerPackage();
                    Bitmap icon = playerIcon(player);
                    saveBitmapToPreferences(icon, "icon:" + player + ":" + normalizeMediaText(musictitle));
                    Drawable drawable = new BitmapDrawable(mLauncher.getApplicationContext().getResources(), icon);
                    if (ivALbumBg != null) {
                        ivALbumBg.setImageDrawable(drawable);
                    }
                    if (ivALbumBgTwo != null) {
                        ivALbumBgTwo.setImageDrawable(drawable);
                    }
                } else {
                    lastpath = null;
                    lastProcessedPath = null; // Reset when no image data
                    
                    // The saved cover only stands in for this same file (read failing this time);
                    // a track without a cover gets the default, not the previous track's cover.
                    Bitmap savedBitmap = path != null
                            && path.equals(mLauncher.mPrefs.getString(PREF_LAST_ALBUM_PATH, ""))
                            ? getBitmapFromPreferences() : null;
                    if (savedBitmap != null) {
                        Drawable drawable = new BitmapDrawable(mLauncher.getApplicationContext().getResources(), savedBitmap);
                        if (ivALbumBg != null) {
                            ivALbumBg.setImageDrawable(drawable);
                        }
                        if (ivALbumBgTwo != null) {
                            ivALbumBgTwo.setImageDrawable(drawable);
                        }
                    } else {
                        // Use default if no saved bitmap
                        if (ivALbumBg != null) {
                            ivALbumBg.setImageResource(ResValue.getInstance().music_album_def);
                        }
                        if (ivALbumBgTwo != null) {
                            ivALbumBgTwo.setImageResource(ResValue.getInstance().music_album_def);
                        }
                    }
                }
                if (ivMusicScore != null) {
                    ((AnimationDrawable) ivMusicScore.getDrawable()).start();
                }
                if (ivMusicScore2 != null) {
                    ((AnimationDrawable) ivMusicScore2.getDrawable()).start();
                }

                applyMusicTitle(musictitle);
                applyMusicArtist(artist);
                if (album != null && !album.isEmpty() && !album.trim().isEmpty() && tvAlbum != null) {
                    tvAlbum.setText(album);
                }
                if (lngs != null && lngs.length > 1) {
                    long curProgress = lngs[1];
                    long totalProgress = lngs[0];
                    if (totalProgress > 0) {
                        if (curProgress < 0) {
                            curProgress = 0;
                        }
                        int progressPercent = (int) ((1000 * curProgress) / totalProgress);
                        if (progressPercent < 5) {
                            if (musicSeekBar != null) {
                                musicSeekBar.setProgress(5);
                            }
                            if (musicProgress != null) {
                                musicProgress.setProgress(progressPercent);
                            }
                        } else {
                            if (musicSeekBar != null) {
                                musicSeekBar.setProgress(progressPercent);
                            }
                            if (musicProgress != null) {
                                musicProgress.setProgress(progressPercent);
                            }
                        }
                    }
                    if (curProgress == 0 && totalProgress == 0) {
                        if (musicProgress != null) {
                            musicProgress.setProgress(0);
                        }
                        // The radio's second line says where it is tuned (FM 101.50 MHz) rather than "Live"
                        String liveLine = StockSources.radioShown() && artist != null && !artist.trim().isEmpty()
                                ? artist : "Live";
                        if (tvAritst != null) {
                            tvAritst.setText(liveLine);
                        }
                        if (tvAritstTwo != null) {
                            tvAritstTwo.setText(liveLine);
                        }
                    }
                    String cur = mLauncher.timeParse(curProgress);
                    String total = mLauncher.timeParse(totalProgress);
                    if (tvCurTime != null && cur != null) {
                        tvCurTime.setText(cur);
                    }
                    if (tvTotalTime != null && total != null) {
                        tvTotalTime.setText(total);
                        return;
                    }
                    return;
                }
                return;
            }
            if (LauncherApplication.isFytDevice() && stockChannelLeft()
                    && ("fyt".equals(mediaSource) || activeController == null)) {
                if (MusicService.music_path != null && !MusicService.music_path.isEmpty() && MusicService.music_path.lastIndexOf("/") >= 0) {
                    if (mLauncher.fytData) { // from metadata
                        musictitle = MusicService.music_name;
                    } else if (StockSources.isSyuMediaUnit()) {
                        // A stream has no file name to take the title from
                        musictitle = StockTitles.displayTitle(true, MusicService.music_path, MusicService.music_name);
                    } else { // from file title
                        File file = new File(MusicService.music_path);
                        String filename = file.getName();
                        musictitle = filename.substring(0, filename.lastIndexOf("."));
                    }
                    Utils.setTextStr(tvMusicName, musictitle);
                    Utils.setTextStr(tvMusicNameTwo, musictitle); 
                    if (MusicService.author_name != null && !MusicService.author_name.isEmpty()) {
                        Utils.setTextStr(tvAritst, MusicService.author_name);
                        Utils.setTextStr(tvAritstTwo, MusicService.author_name);
                    } else {
                        Utils.setTextId(tvAritst, R.string.music_author);
                        Utils.setTextId(tvAritstTwo, R.string.music_author);
                    }                            
                } else {
                    Utils.setTextId(tvMusicName, R.string.music_name);
                    Utils.setTextId(tvMusicNameTwo, R.string.music_name); 
                    Utils.setTextId(tvAritst, R.string.music_author);
                    Utils.setTextId(tvAritstTwo, R.string.music_author);         
                }

                Utils.setTextStr(tvCurTime, "00:00");
                Utils.setTextStr(tvTotalTime, "00:00");
                if (musicSeekBar != null) {
                    musicSeekBar.setProgress(0);
                }
                if (musicProgress != null) {
                    musicProgress.setProgress(0);
                }
                if (mPlayPauseButton != null) {
                    mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                    setWidgetButtonsTint(mPlayPauseButton);
                    return;
                }
                if (mPlayPauseButtonTwo != null) {
                    mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                    setBarButtonsTint(mPlayPauseButtonTwo);
                    return;
                }
                return;
            }
            if (ivMusicScore != null) {
                ((AnimationDrawable) ivMusicScore.getDrawable()).selectDrawable(0);
                ((AnimationDrawable) ivMusicScore.getDrawable()).stop();
            }
            if (ivMusicScore2 != null) {
                ((AnimationDrawable) ivMusicScore2.getDrawable()).selectDrawable(0);
                ((AnimationDrawable) ivMusicScore2.getDrawable()).stop();
            }
            /*if (mPlayPauseButton != null) {
                mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }
            if (mPlayPauseButtonTwo != null) {
                mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }*/
            if (musictitle != null && !musictitle.isEmpty() && !musictitle.trim().isEmpty()) {
                if (tvMusicName != null) {
                    if (!(tvMusicName.getText().toString()).equals(musictitle)) {
                        tvMusicName.setText(musictitle);                                                  
                    }
                    tvMusicName.setSelected(true);
                }
                if (tvMusicNameTwo != null) {
                    if (!(tvMusicNameTwo.getText().toString()).equals(musictitle)) {
                        tvMusicNameTwo.setText(musictitle);                       
                    }
                    tvMusicNameTwo.setSelected(true); 
                }
            }
            if (artist != null && !artist.isEmpty() && tvAritst != null) {
                if (tvAritst != null) {
                    if (!(tvAritst.getText().toString()).equals(artist)) {
                        tvAritst.setText(artist);              
                    }
                    tvAritst.setSelected(true);
                }                   
            }
            if (artist != null && !artist.isEmpty() && tvAritstTwo != null) {
                if (tvAritstTwo != null) {
                    if (!(tvAritstTwo.getText().toString()).equals(artist)) {
                        tvAritstTwo.setText(artist);              
                    }
                    tvAritstTwo.setSelected(true);
                }                   
            }
            mLauncher.requestWidgetUpdate(DateMusicProvider.class, DateRadioProvider.class);
        }
    };

    // set play/pause icon for stock and other music players
    public void setPlayPauseIcon(boolean wait) {
        if (wait) {
            mLauncher.mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setPlayPauseIcon();
                    mLauncher.requestWidgetUpdate(DateMusicProvider.class, DateRadioProvider.class);
                }
            }, 300);
        } else {
           setPlayPauseIcon();
        }
    }

    /**
     * Whether anything is playing right now, decided from whichever source
     * currently owns the widget.
     *
     * MusicService.state cannot answer this on its own: it is only ever set
     * from intents sent by com.syu.music, so once that package is force
     * stopped the last value it published stays behind. isMusicActive() is no
     * better on its own either, since it still reports true for a moment after
     * a pause.
     */
    boolean isMediaPlayingNow() {
        if ("mediaController".equals(mediaSource)) {
            // The session itself first: the snapshot is only as fresh as the last callback the
            // listener got, and after a long sleep (listener reconnected, PAUSED missed) a play
            // could leave it saying paused while the music played.
            Boolean live = isSessionPlaying(activeController);
            if (live != null) {
                return live;
            }
            if (activeSessions() != null) {
                // The sessions could be read and none is its own (after a restart, say): the
                // snapshot and the saved state still say what played before.
                return false;
            }
            MediaWidgetState.Snapshot snapshot = MediaWidgetState.getExternalSnapshot();
            if (snapshot != null) {
                return snapshot.playing;
            }
            return "true".equals(mLauncher.state);
        }
        if (!LauncherApplication.isFytDevice()) {
            // No stock player: the source a restart starts with. Whatever else makes a sound
            // (navigation, say) is not what the widget shows; a session that plays is.
            List<MediaController> controllers = activeSessions();
            if (controllers != null) {
                for (MediaController controller : controllers) {
                    try {
                        PlaybackState state = controller.getPlaybackState();
                        if (state != null && MediaWidgetState.isPlaybackActive(state.getState())) {
                            return true;
                        }
                    } catch (RuntimeException ignored) {
                        // the session went away meanwhile
                    }
                }
                return false;
            }
        }
        if (StockSources.shownOverlay() != null) {
            // The radio's sound is the MCU's, not an Android player the audioserver would report
            return StockSources.isShownPlaying();
        }
        if (StockSources.isSyuMediaUnit() && MusicService.isSyuMediaSource()) {
            // The player's own state, read over its binder: isMusicActive() goes on saying
            // "playing" for a moment after a pause, and for the sound of any other app
            return MusicService.state.booleanValue();
        }
        // Not mAudioManager.isMusicActive() directly: see AudioStateCache.
        return MusicService.state.booleanValue()
                || AudioStateCache.isMusicActive(mLauncher, AUDIO_STATE_WAIT_MS);
    }

    /**
     * Whether the stock source the widget shows is off its channel (paused, say): com.syu.music's
     * channel is 8; the 7870's players have their own (music 8, internet radio 7); the radio (BT)
     * the widget shows as an overlay is always taken to be on it, being what it shows.
     */
    private boolean stockChannelLeft() {
        if (StockSources.shownOverlay() != null) {
            return false;
        }
        int channel = StockSources.isSyuMediaUnit() ? StockSources.shownChannel() : 8;
        return CarStates.mAppID != channel;
    }

    /** The play state the widget's stock source reports, for the icon a press is about to change. */
    private boolean stockPlayingForIcon() {
        return StockSources.shownOverlay() != null
                ? StockSources.isShownPlaying() : MusicService.state.booleanValue();
    }

    /** The state of that player's session right now; null if it has none or it cannot be read. */
    private Boolean isSessionPlaying(String packageName) {
        MediaController controller = findSession(packageName);
        if (controller == null) {
            return null;
        }
        try {
            PlaybackState state = controller.getPlaybackState();
            return state != null && MediaWidgetState.isPlaybackActive(state.getState());
        } catch (RuntimeException e) {
            return null; // the session went away meanwhile
        }
    }

    /** That player's active session; null if it has none or the sessions cannot be read. */
    private MediaController findSession(String packageName) {
        List<MediaController> controllers = activeSessions();
        if (controllers == null || packageName == null || packageName.isEmpty()) {
            return null;
        }
        for (MediaController controller : controllers) {
            if (packageName.equals(controller.getPackageName())) {
                return controller;
            }
        }
        return null;
    }

    /** The active sessions; null if they cannot be read (no notification access). */
    private List<MediaController> activeSessions() {
        try {
            MediaSessionManager msm = (MediaSessionManager) mLauncher.getSystemService(Context.MEDIA_SESSION_SERVICE);
            return msm != null
                    ? msm.getActiveSessions(new ComponentName(mLauncher, NotificationListener.class)) : null;
        } catch (RuntimeException e) {
            return null; // SecurityException
        }
    }

    public void setPlayPauseIcon() {
        boolean playing = isMediaPlayingNow();
        if (this.mPlayPauseButton != null && !temporarilyDisablePlayPauseButton) {
            if (playing) {
                this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            } else {
                this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            }
        }
        if (this.mPlayPauseButtonTwo != null && !temporarilyDisablePlayPauseButton) {
            if (playing) {
                this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            } else {
                this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            }
        }         
    }

    /** The last onRefresh() arguments, to draw them again once a file's cover has been read. */
    private Object[] mLastRefresh;
    /** The file whose cover was read last (main thread), the cover (null for none), and whether it has been. */
    private String mId3Path;
    private byte[] mId3Pic;
    private boolean mId3Read;

    /**
     * The cover in a track's file is read off the main thread, once per file: read there it took
     * about 30 ms of every update, once a second while the stock player played (StrictMode,
     * capture 18-10-2026 23:18:46). False while it is being read; the widget is drawn again then.
     */
    private boolean isId3Read(String path) {
        if (path.equals(mId3Path)) {
            return mId3Read;
        }
        mId3Path = path;
        mId3Pic = null;
        if (!StockTitles.isLocalFile(path)
                && (StockSources.isSyuMediaUnit() || StockSources.shownOverlay() != null)) {
            // A stream's URL or a station: there is no file to read the tags of
            mId3Read = true;
            return true;
        }
        mId3Read = false;
        ID3_READER.execute(() -> {
            byte[] pic = null;
            try {
                Id3Info info = new Lrc().getId3Info(path);
                pic = info != null ? info.dataPic : null;
            } catch (RuntimeException e) {
                Log.w(Launcher.TAG, "Unreadable tags: " + path, e);
            }
            byte[] cover = pic;
            mLauncher.mHandler.post(() -> {
                if (!path.equals(mId3Path)) {
                    return; // another track meanwhile
                }
                mId3Pic = cover;
                mId3Read = true;
                Object[] a = mLastRefresh;
                if (a != null) {
                    refreshMusic.onRefresh((int[]) a[0], (long[]) a[1], (float[]) a[2],
                            (String[]) a[3], (byte[]) a[4], (String) a[5]);
                }
            });
        });
        return false;
    }

    private static final ExecutorService ID3_READER = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "MusicId3");
        t.setDaemon(true);
        return t;
    });

    /** The player of what the widget shows now: the session's app, else FYT's stock player. */
    private String currentPlayerPackage() {
        if ("mediaController".equals(mediaSource)) {
            return activeController;
        }
        if (!LauncherApplication.isFytDevice()) {
            return null;
        }
        // The 7870's stock player is com.syu.media. The radio shown on a 7862 stays com.syu.music
        // here, a stock player no button opens as "the last player"
        return StockSources.isSyuMediaUnit() || MusicService.isSyuMediaSource()
                ? MusicService.MEDIA_PKG : STOCK_MUSIC_PACKAGE;
    }

    private String mPlayerIconPackage;
    private Bitmap mPlayerIcon;

    /** The player's icon as a cover (a track without one), kept per package; null without it. */
    private Bitmap playerIcon(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return null;
        }
        if (packageName.equals(mPlayerIconPackage)) {
            return mPlayerIcon;
        }
        Bitmap icon = null;
        try {
            Drawable drawable = mLauncher.getPackageManager().getApplicationIcon(packageName);
            icon = Bitmap.createBitmap(PLAYER_ICON_SIZE, PLAYER_ICON_SIZE, Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(icon);
            drawable.setBounds(0, 0, PLAYER_ICON_SIZE, PLAYER_ICON_SIZE);
            drawable.draw(canvas);
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            icon = null;
        }
        mPlayerIconPackage = packageName;
        mPlayerIcon = icon;
        return icon;
    }

    private static final int PLAYER_ICON_SIZE = 256;

    /** The app the last track played in; see openLastPlayerIfNoSession(). */
    static final String PREF_LAST_PLAYER = "last_music_player";

    private void saveLastPlayer(String packageName) {
        if (packageName == null || packageName.isEmpty()
                || packageName.equals(mLauncher.mPrefs.getString(PREF_LAST_PLAYER, null))) {
            return;
        }
        mLauncher.mPrefs.edit().putString(PREF_LAST_PLAYER, packageName).apply();
    }

    /**
     * After a restart (no session of the last track's app): any button of the widget opens that
     * app instead, as the restored title and cover suggest. Not FYT's stock player, whose play
     * resumes the last track by itself. True if it was opened.
     */
    private boolean openLastPlayerIfNoSession() {
        String packageName = mLauncher.mPrefs.getString(PREF_LAST_PLAYER, null);
        if (packageName == null || packageName.isEmpty() || STOCK_MUSIC_PACKAGE.equals(packageName)
                || MusicService.MEDIA_PKG.equals(packageName)) {
            return false;
        }
        List<MediaController> controllers = activeSessions();
        if (controllers == null) {
            return false; // no access to the sessions: not known whether it has one
        }
        for (MediaController controller : controllers) {
            if (packageName.equals(controller.getPackageName())) {
                return false;
            }
        }
        Intent launchIntent = launchIntentIfInstalled(packageName);
        if (launchIntent == null) {
            Log.i(Launcher.TAG, "Music widget: no session of " + packageName + ", not installed");
            return false;
        }
        Log.i(Launcher.TAG, "Music widget: no session of " + packageName + ", opening it");
        WindowUtil.removePip();
        refreshLeftCycleForIntent(launchIntent);
        mLauncher.startActivitySafely(null, launchIntent, "music");
        return true;
    }

    /** Its launch intent; null if it is not installed (or has nothing to open). */
    private Intent launchIntentIfInstalled(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return null;
        }
        PackageManager pm = mLauncher.getPackageManager();
        try {
            pm.getApplicationInfo(packageName, 0);
            return pm.getLaunchIntentForPackage(packageName);
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            return null;
        }
    }

    private static final String STOCK_MUSIC_PACKAGE = "com.syu.music";

    public void preSetMusicWidgets() {
        // seeded so the first live update is not written back as a change
        lastMusictitle = normalizeMediaText(mLauncher.mPrefs.getString(MUSIC_TITLE_PREF, null));
        lastArtist = normalizeMediaText(mLauncher.mPrefs.getString(ARTIST_PREF, null));

        Bitmap savedBitmap = getBitmapFromPreferences();
        // Only under its own track's title (saved before the title key existed: as before).
        String coverTitle = mLauncher.mPrefs.getString(PREF_LAST_ALBUM_TITLE, null);
        if (savedBitmap != null && coverTitle != null && !coverTitle.equals(lastMusictitle)) {
            savedBitmap = null;
        }
        if (savedBitmap != null) {
            Drawable drawable = new BitmapDrawable(mLauncher.getApplicationContext().getResources(), savedBitmap);
            if (this.ivALbumBg != null) {
                this.ivALbumBg.setImageDrawable(drawable);
            }
            if (this.ivALbumBgTwo != null) {
                this.ivALbumBgTwo.setImageDrawable(drawable);
            }
        } else {
            // Use default if no saved bitmap
            if (this.ivALbumBg != null) {
                this.ivALbumBg.setImageResource(ResValue.getInstance().music_album_def);
            }
            if (this.ivALbumBgTwo != null) {
                this.ivALbumBgTwo.setImageResource(ResValue.getInstance().music_album_def);
            }
        }

        showMusicTitle(lastMusictitle);
        showMusicArtist(lastArtist);

        mAudioManager = (AudioManager) mLauncher.getSystemService(Context.AUDIO_SERVICE);
        // The same decision as every other icon update (the session, then what the stock player
        // and the audioserver say): this one used to go by the stock player's last value alone,
        // and it is what a wake from sleep shows.
        setPlayPauseIcon();
    }

    /**
     * Null, blank, literal "null" and "Unknown" all mean the track supplied no
     * value, and have to be stored as such - skipping the write is what leaves
     * the previous track's title or artist behind.
     */
    static String normalizeMediaText(String value) {
        if (value == null) {
            return "";
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty() || "null".equalsIgnoreCase(trimmed) || "Unknown".equalsIgnoreCase(trimmed)) {
            return "";
        }
        return trimmed;
    }

    void applyMusicTitle(String rawTitle) {
        String title = normalizeMediaText(rawTitle);
        saveTitleToPreferences(title);
        showMusicTitle(title);
    }

    void applyMusicArtist(String rawArtist) {
        String artist = normalizeMediaText(rawArtist);
        saveArtistToPreferences(artist);
        showMusicArtist(artist);
    }

    void showMusicTitle(String title) {
        TextView[] views = { this.tvMusicName, this.tvMusicNameTwo };
        for (TextView view : views) {
            if (view == null) {
                continue;
            }
            if (title.isEmpty()) {
                view.setText(R.string.music_name);
            } else if (!view.getText().toString().equals(title)) {
                view.setText(title);
            } else if (mediaSource != null && !mediaSource.equals(mLauncher.helpers.returnMediaSourcePre())) {
                // restarts the marquee when the source changed but the text did not
                mLauncher.helpers.setMediaSourcePre(mediaSource);
                view.setText("\u0020" + title + "\u0020");
            }
            view.setSelected(true);
        }
    }

    void showMusicArtist(String artist) {
        TextView[] views = { this.tvAritst, this.tvAritstTwo };
        for (TextView view : views) {
            if (view == null) {
                continue;
            }
            if (artist.isEmpty()) {
                view.setText(R.string.music_author);
            } else if (!view.getText().toString().equals(artist)) {
                view.setText(artist);
            }
            view.setSelected(true);
        }
    }

    void saveTitleToPreferences(String currentTitle) {
        String title = normalizeMediaText(currentTitle);
        // A track always has a title: a blank one is a moment between two (or a stop), and
        // writing it erased the last track a restart shows.
        if (title.isEmpty() || title.equals(lastMusictitle)) {
            return;
        }
        lastMusictitle = title;
        mLauncher.mPrefs.edit().putString(MUSIC_TITLE_PREF, title).apply();
    }

    void saveArtistToPreferences(String currentArtist) {
        String artist = normalizeMediaText(currentArtist);
        if (artist.equals(lastArtist)) {
            return;
        }
        lastArtist = artist;
        mLauncher.mPrefs.edit().putString(ARTIST_PREF, artist).apply();
    }

    void saveBitmapToPreferences(Bitmap bitmap, String currentPath) {
        if (bitmap == null || currentPath == null) return;
        
        // Check if this is the same path we just processed
        if (currentPath.equals(lastProcessedPath)) {
            return;
        }
        // Here, on the main thread, where it is read: set on the saving thread, a quick track
        // change could check against an old value.
        lastProcessedPath = currentPath;
        final String coverTitle = normalizeMediaText(musictitle);

        // One thread, in order: the last track's cover is the one left in the file (four
        // threads could finish two quick saves the other way round).
        ALBUM_ART_SAVER.execute(() -> {
            try {
                // Double-check with persisted path
                String lastSavedPath = mLauncher.mPrefs.getString(PREF_LAST_ALBUM_PATH, "");
                if (currentPath.equals(lastSavedPath)) {
                    return; // Already saved for this path
                }

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                if (!writeAlbumArt(mLauncher, byteArrayOutputStream.toByteArray())) {
                    return;
                }
                synchronized (ALBUM_ART_LOCK) {
                    sAlbumArt = bitmap;
                    sAlbumArtLoaded = true;
                }

                // The cover is a file: only its track's path and title are preferences.
                mLauncher.mPrefs.edit()
                        .putString(PREF_LAST_ALBUM_PATH, currentPath)
                        .putString(PREF_LAST_ALBUM_TITLE, coverTitle)
                        .remove(PREF_LAST_ALBUM_ART)
                        .apply();
            } catch (Exception e) {
                Log.e(Launcher.TAG, "saveBitmapToPreferences: " + e.getMessage());
            }
        });
    }

    /** Saves the covers, one after the other; see saveBitmapToPreferences(). */
    private static final java.util.concurrent.ExecutorService ALBUM_ART_SAVER =
            java.util.concurrent.Executors.newSingleThreadExecutor(r -> {
                Thread t = new Thread(r, "AlbumArtSave");
                t.setDaemon(true);
                return t;
            });
    private static final Object ALBUM_ART_LOCK = new Object();

    Bitmap getBitmapFromPreferences() {
        if (sAlbumArtLoaded) return sAlbumArt;
        // Not read yet by the start-up warm-up (preloadAlbumArt()): read here, once.
        preloadAlbumArt(mLauncher);
        return sAlbumArt;
    }

    /** The last cover, kept: read from its file once, off the main thread at a start. */
    private static volatile Bitmap sAlbumArt;
    private static volatile boolean sAlbumArtLoaded;

    /** Reads the last cover into memory; called by the start-up warm-up thread. */
    static void preloadAlbumArt(Context context) {
        if (sAlbumArtLoaded) return;
        Bitmap read = null;
        try {
            File file = albumArtFile(context);
            read = file.isFile() ? BitmapFactory.decodeFile(file.getPath()) : null;
        } catch (Exception e) {
            Log.w(Launcher.TAG, "album art not read: " + e);
        }
        synchronized (ALBUM_ART_LOCK) {
            // A cover saved (or moved) meanwhile is newer than the one just read
            if (!sAlbumArtLoaded) {
                sAlbumArt = read;
                sAlbumArtLoaded = true;
            }
        }
    }

    /** The last cover, as a PNG file of its own. */
    private static File albumArtFile(Context context) {
        return new File(context.getFilesDir(), "last_album_art.png");
    }

    /** Writes the cover through a temporary file, so a half-written one is never read. */
    private static boolean writeAlbumArt(Context context, byte[] png) {
        File file = albumArtFile(context);
        File tmp = new File(file.getPath() + ".tmp");
        try (java.io.FileOutputStream out = new java.io.FileOutputStream(tmp)) {
            out.write(png);
        } catch (java.io.IOException e) {
            Log.w(Launcher.TAG, "album art not saved: " + e);
            tmp.delete();
            return false;
        }
        if (!tmp.renameTo(file)) {
            tmp.delete();
            return false;
        }
        return true;
    }

    /**
     * Moves a cover kept in the default preferences (as Base64, a quarter of a megabyte) to its
     * file. In the preferences it made reading them take two seconds at a cold start, and every
     * write of any setting write it all again. Off the main thread; once.
     */
    static void migrateAlbumArt(Context context, SharedPreferences prefs) {
        if (!prefs.contains(PREF_LAST_ALBUM_ART)) return;
        try {
            String encoded = prefs.getString(PREF_LAST_ALBUM_ART, null);
            if (encoded != null) {
                byte[] png = Base64.decode(encoded, Base64.DEFAULT);
                if (writeAlbumArt(context, png)) {
                    Bitmap moved = BitmapFactory.decodeByteArray(png, 0, png.length);
                    synchronized (ALBUM_ART_LOCK) {
                        sAlbumArt = moved;
                        sAlbumArtLoaded = true;
                    }
                }
            }
        } catch (RuntimeException e) {
            Log.w(Launcher.TAG, "album art not moved: " + e);
        }
        prefs.edit().remove(PREF_LAST_ALBUM_ART).apply();
    }

    public void initMusicWidgetView(View musicWidgetView) {
        if (musicWidgetView != null) {
            mPlayPauseButton = musicWidgetView.findViewById(ResValue.getInstance().musicbutton_playpause);
            mMusicPrevButton = musicWidgetView.findViewById(ResValue.getInstance().musicbutton_prev);
            mMusicNextButton = musicWidgetView.findViewById(ResValue.getInstance().musicbutton_next);
            mMusicFavoriteButton = musicWidgetView.findViewById(ResValue.getInstance().musicbutton_favorite);
            setWidgetButtonsTint(mPlayPauseButton);
            setWidgetButtonsTint(mMusicPrevButton);
            setWidgetButtonsTint(mMusicNextButton);
            updateFavoriteButtonState(MediaFavoriteController.FAVORITE_STATE_UNKNOWN);
            tvMusicName = musicWidgetView.findViewById(ResValue.getInstance().tv_musicName);
            ivALbumBg = musicWidgetView.findViewById(ResValue.getInstance().iv_album_bg);
            ivMusicScore = musicWidgetView.findViewById(ResValue.getInstance().music_score);
            ivMusicScore2 = musicWidgetView.findViewById(ResValue.getInstance().music_score2);
            tvAritst = musicWidgetView.findViewById(ResValue.getInstance().tv_artist);
            tvAlbum = musicWidgetView.findViewById(ResValue.getInstance().tv_album);
            tvCurTime = musicWidgetView.findViewById(ResValue.getInstance().music_cur_time);
            tvTotalTime = musicWidgetView.findViewById(ResValue.getInstance().music_total_time);
            mLauncher.mTvMusic = musicWidgetView.findViewById(ResValue.getInstance().tv_music);
            musicSeekBar = musicWidgetView.findViewById(ResValue.getInstance().music_seekbar);
            musicProgress = musicWidgetView.findViewById(ResValue.getInstance().music_progress);
            widgetTint = mLauncher.mPrefs.getBoolean(Keys.BLACK_WIDGETS, false);
            if (widgetTint && musicProgress != null) {
                musicProgress.getProgressDrawable().setColorFilter(
                    Color.BLACK, 
                    PorterDuff.Mode.SRC_IN
                );
            } else if (musicProgress != null) {
                musicProgress.getProgressDrawable().clearColorFilter();
            }
            mLauncher.putCustomView(Config.WS_Music, musicWidgetView.findViewById(ResValue.getInstance().rl_music));
            if (mLauncher.getCustomView(Config.WS_Music) != null) {
                mLauncher.getCustomView(Config.WS_Music).setOnClickListener(mLauncher);
            }
        }
    }

    public void initMusicBarView(View musicBarView) {
        if (musicBarView != null) {
            mPlayPauseButtonTwo = musicBarView.findViewById(ResValue.getInstance().musicbutton_playpause_two);
            mMusicPrevButtonTwo = musicBarView.findViewById(ResValue.getInstance().musicbutton_prev_two);
            mMusicNextButtonTwo = musicBarView.findViewById(ResValue.getInstance().musicbutton_next_two);
            mMusicFavoriteButtonTwo = musicBarView.findViewById(ResValue.getInstance().musicbutton_favorite_two);
            setBarButtonsTint(mPlayPauseButtonTwo);
            setBarButtonsTint(mMusicPrevButtonTwo);
            setBarButtonsTint(mMusicNextButtonTwo);
            updateFavoriteButtonState(MediaFavoriteController.FAVORITE_STATE_UNKNOWN);
            tvMusicNameTwo = musicBarView.findViewById(ResValue.getInstance().tv_musicName_two);
            ivALbumBgTwo = musicBarView.findViewById(ResValue.getInstance().iv_album_bg_two);
            tvAritstTwo = musicBarView.findViewById(ResValue.getInstance().tv_artist_two);
            View musicWidget = musicBarView.findViewById(ResValue.getInstance().rl_music_two);
            if (musicWidget != null) {
                musicWidget.setOnClickListener(mLauncher);
            }
        }
    }

    public void bindMusicWidgetOnclickListener(View musicWidgetView) {
        mAudioManager = (AudioManager) mLauncher.getSystemService(Context.AUDIO_SERVICE);

        prevLayout = musicWidgetView.findViewById(R.id.constraint_layout_prev);
        playPauseLayout = musicWidgetView.findViewById(R.id.constraint_layout_playpause);
        nextLayout = musicWidgetView.findViewById(R.id.constraint_layout_next);
        favoriteLayout = musicWidgetView.findViewById(R.id.constraint_layout_favorite);
        
        // Set up previous button
        View.OnClickListener prevClickListener = v -> onPrevButtonClicked(false);
        prevLayout.setOnClickListener(prevClickListener);
        if (mMusicPrevButton != null) {
            mMusicPrevButton.setOnClickListener(prevClickListener);
        }
        
        // Set up play/pause button
        View.OnClickListener playPauseClickListener = v -> onPlayPauseButtonClicked(false);
        playPauseLayout.setOnClickListener(playPauseClickListener);
        if (mPlayPauseButton != null) {
            mPlayPauseButton.setOnClickListener(playPauseClickListener);
        }
        
        // Set up next button
        View.OnClickListener nextClickListener = v -> onNextButtonClicked(false);
        nextLayout.setOnClickListener(nextClickListener);
        if (mMusicNextButton != null) {
            mMusicNextButton.setOnClickListener(nextClickListener);
        }

        View.OnClickListener favoriteClickListener = v -> onFavoriteButtonClicked(false);
        if (favoriteLayout != null) {
            favoriteLayout.setOnClickListener(favoriteClickListener);
        }
        if (mMusicFavoriteButton != null) {
            mMusicFavoriteButton.setOnClickListener(favoriteClickListener);
        }
        
        // Make layouts clickable
        prevLayout.setClickable(true);
        playPauseLayout.setClickable(true);
        nextLayout.setClickable(true);
        if (favoriteLayout != null) {
            favoriteLayout.setClickable(true);
        }
        
        prevLayout.setFocusable(true);
        playPauseLayout.setFocusable(true);
        nextLayout.setFocusable(true);
        if (favoriteLayout != null) {
            favoriteLayout.setFocusable(true);
        }
    }

    public void bindMusicBarOnclickListener(View musicBarView) {
        mAudioManager = (AudioManager) mLauncher.getSystemService(Context.AUDIO_SERVICE);

        prevLayoutTwo = musicBarView.findViewById(R.id.constraint_layout_prev_two);
        playPauseLayoutTwo = musicBarView.findViewById(R.id.constraint_layout_playpause_two);
        nextLayoutTwo = musicBarView.findViewById(R.id.constraint_layout_next_two);
        favoriteLayoutTwo = musicBarView.findViewById(R.id.constraint_layout_favorite_two);
        
        // Set up previous button
        View.OnClickListener prevClickListener = v -> onPrevButtonClicked(true);
        prevLayoutTwo.setOnClickListener(prevClickListener);
        if (mMusicPrevButtonTwo != null) {
            mMusicPrevButtonTwo.setOnClickListener(prevClickListener);
        }
        
        // Set up play/pause button
        View.OnClickListener playPauseClickListener = v -> onPlayPauseButtonClicked(true);
        playPauseLayoutTwo.setOnClickListener(playPauseClickListener);
        if (mPlayPauseButtonTwo != null) {
            mPlayPauseButtonTwo.setOnClickListener(playPauseClickListener);
        }
        
        // Set up next button
        View.OnClickListener nextClickListener = v -> onNextButtonClicked(true);
        nextLayoutTwo.setOnClickListener(nextClickListener);
        if (mMusicNextButtonTwo != null) {
            mMusicNextButtonTwo.setOnClickListener(nextClickListener);
        }

        View.OnClickListener favoriteClickListener = v -> onFavoriteButtonClicked(true);
        if (favoriteLayoutTwo != null) {
            favoriteLayoutTwo.setOnClickListener(favoriteClickListener);
        }
        if (mMusicFavoriteButtonTwo != null) {
            mMusicFavoriteButtonTwo.setOnClickListener(favoriteClickListener);
        }
        
        // Make LayoutTwos clickable
        prevLayoutTwo.setClickable(true);
        playPauseLayoutTwo.setClickable(true);
        nextLayoutTwo.setClickable(true);
        if (favoriteLayoutTwo != null) {
            favoriteLayoutTwo.setClickable(true);
        }
        
        prevLayoutTwo.setFocusable(true);
        playPauseLayoutTwo.setFocusable(true);
        nextLayoutTwo.setFocusable(true);
        if (favoriteLayoutTwo != null) {
            favoriteLayoutTwo.setFocusable(true);
        }
    }

    public void onFavoriteButtonClicked(boolean barView) {
        if (barView && mLauncher.mWorkspace != null) {
            mLauncher.mWorkspace.scheduleAutoHide();
        }
        if (openLastPlayerIfNoSession()) {
            return;
        }
        String preferredPackage = getPreferredMediaControllerPackage();
        if (MediaFavoriteController.isFavoriteTemporarilyDisabledPackage(preferredPackage)) {
            // Logged: from the outside a press refused here does nothing at all.
            Log.i(Launcher.TAG, "Favorite press ignored: " + preferredPackage + " not ready (status or video id)");
            updateFavoriteButtonState(MediaFavoriteController.FAVORITE_STATE_UNKNOWN, false);
            return;
        }
        int stateBefore = MediaFavoriteController.getCurrentFavoriteState(mLauncher, preferredPackage);
        boolean sent = MediaFavoriteReceiver.handleFavoriteAction(mLauncher, preferredPackage);
        if (sent) {
            if (stateBefore == MediaFavoriteController.FAVORITE_STATE_FAVORITED) {
                updateFavoriteButtonState(MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED);
            } else if (stateBefore == MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED) {
                updateFavoriteButtonState(MediaFavoriteController.FAVORITE_STATE_FAVORITED);
            } else {
                updateFavoriteButtonState(MediaFavoriteController.getCurrentFavoriteState(mLauncher, preferredPackage));
            }
            mLauncher.mHandler.postDelayed(this::updateFavoriteButtonState, 700);
        }
    }

    void updateFavoriteButtonState() {
        String preferredPackage = getPreferredMediaControllerPackage();
        if (MediaFavoriteController.isFavoriteTemporarilyDisabledPackage(preferredPackage)) {
            updateFavoriteButtonState(MediaFavoriteController.FAVORITE_STATE_UNKNOWN, false);
            return;
        }
        updateFavoriteButtonState(MediaFavoriteController.getCurrentFavoriteState(mLauncher, preferredPackage));
    }

    void updateFavoriteButtonState(int favoriteState) {
        updateFavoriteButtonState(favoriteState, true);
    }

    void updateFavoriteButtonState(int favoriteState, boolean enabled) {
        int drawable = favoriteState == MediaFavoriteController.FAVORITE_STATE_FAVORITED
                ? R.drawable.music_favorite_p
                : R.drawable.btn_ic_favorite;
        setFavoriteButtonBackground(mMusicFavoriteButton, drawable, false, enabled);
        setFavoriteButtonBackground(mMusicFavoriteButtonTwo, drawable, true, enabled);
    }

    void setFavoriteButtonBackground(Button button, int drawable, boolean barView, boolean enabled) {
        if (button == null) {
            return;
        }
        button.setEnabled(enabled);
        button.setAlpha(enabled ? 1f : 0.45f);
        button.setBackground(SkinUtils.getDrawable(drawable));
        if (barView) {
            setBarButtonsTint(button);
        } else {
            setWidgetButtonsTint(button);
        }
    }

    /**
     * Where the transport buttons go: the session's app, or on an FYT unit the stock player whose
     * track the widget shows (its play state does not matter, see dispatchToStockPlayer()).
     */
    String getTransportTargetPackage() {
        if ("fyt".equals(mediaSource) && LauncherApplication.isFytDevice()) {
            String overlay = StockSources.overlayPackage();
            if (overlay != null) {
                return overlay;
            }
            return MusicService.isSyuMediaSource() || StockSources.isSyuMediaUnit()
                    ? MusicService.MEDIA_PKG : MusicService.MUSIC_PKG;
        }
        return getPreferredMediaControllerPackage();
    }

    String getPreferredMediaControllerPackage() {
        if ("mediaController".equals(mediaSource) && activeController != null && !activeController.isEmpty()) {
            return activeController;
        }
        return null;
    }

    void refreshLeftCycleForIntent(Intent launchIntent) {
        if (launchIntent == null || launchIntent.getComponent() == null) {
            return;
        }

        try {
            ComponentName componentName = launchIntent.getComponent();
            PackageManager pm = mLauncher.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
            String appTitle = appInfo.loadLabel(pm).toString();
            AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
            mLauncher.mAppBars.refreshLeftCycle(bean);
            mLauncher.cleanWidgetBar();
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(Launcher.TAG, "Unable to refresh music app cycle", e);
        }
    }

    void openActiveMusicPlayer(View v) {
        WindowUtil.removePip();
        Intent launchIntent = MediaTransportController.getActivePlayerLaunchIntent(
                mLauncher,
                getPreferredMediaControllerPackage()
        );
        if (launchIntent == null) {
            return;
        }
        refreshLeftCycleForIntent(launchIntent);
        mLauncher.startActivitySafely(v, launchIntent, "music");
    }

    public void onPrevButtonClicked(boolean barView) {
        if (barView) {
            mLauncher.mWorkspace.scheduleAutoHide();
        }
        if (openLastPlayerIfNoSession()) {
            return;
        }

        if (mLauncher.mRadioWidget.isRadioPlaying() && "mediaController".equals(mediaSource)) {
            openActiveMusicPlayer(null);
            return;
        }

        MediaTransportController.handleAction(
                mLauncher,
                MediaTransportController.ACTION_PREVIOUS,
                getTransportTargetPackage()
        );
        mLauncher.requestWidgetUpdate(DateMusicProvider.class, DateRadioProvider.class);
    }

    public void onPlayPauseButtonClicked(boolean barView) {
        if (barView) {
            mLauncher.mWorkspace.scheduleAutoHide();
        }
        if (openLastPlayerIfNoSession()) {
            return;
        }
        if (!temporarilyDisablePlayPauseButton) {
            if ("fyt".equals(mediaSource) && !LauncherApplication.isFytDevice()) {
                // The source a restart starts with; no stock player to ask on another device:
                // the session the system would send the key to.
                MediaTransportController.handleAction(mLauncher,
                        MediaTransportController.ACTION_PLAY_PAUSE, getPreferredMediaControllerPackage());
            } else if ("fyt".equals(mediaSource)) {
                if (this.mPlayPauseButton != null) {
                    if (stockPlayingForIcon()) {
                        this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setWidgetButtonsTint(mPlayPauseButton);
                    } else {
                        this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                        setWidgetButtonsTint(mPlayPauseButton);
                    }
                }
                if (this.mPlayPauseButtonTwo != null && barView) {
                    if (stockPlayingForIcon()) {
                        this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setBarButtonsTint(mPlayPauseButtonTwo);
                    } else {
                        this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                        setBarButtonsTint(mPlayPauseButtonTwo);
                    }
                } 
                // com.syu.music, or com.syu.media on the 7870 (which takes no intents)
                MediaTransportController.dispatchToStockPlayer(mLauncher,
                        MediaTransportController.ACTION_PLAY_PAUSE);
            } else if ("mediaController".equals(mediaSource)) {
                boolean activeControllerAppRunning = false;
                MediaSessionManager msm = (MediaSessionManager) mLauncher.getSystemService(Context.MEDIA_SESSION_SERVICE);
                ComponentName component = new ComponentName(mLauncher, NotificationListener.class);
                List<MediaController> controllers = msm.getActiveSessions(component);
                for (MediaController controller : controllers) {
                    if (controller.getPackageName().equals(activeController)) {
                        activeControllerAppRunning = true;

                        PlaybackState state = controller.getPlaybackState();
                        int playbackState = (state != null) ? state.getState() : PlaybackState.STATE_NONE;

                        // Buffering is playing too: a play sent to it again would be lost.
                        if (MediaWidgetState.isPlaybackActive(playbackState)) {
                            mLauncher.handler.postDelayed(() -> {
                                if (this.mPlayPauseButton != null) {
                                    this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                                    setWidgetButtonsTint(mPlayPauseButton);
                                }
                                if (this.mPlayPauseButtonTwo != null && barView) {
                                    this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                                    setBarButtonsTint(mPlayPauseButtonTwo);
                                }
                                controller.getTransportControls().pause();
                            }, 350);

                        } else {
                            if (this.mPlayPauseButton != null) {
                                this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                                setWidgetButtonsTint(mPlayPauseButton);
                            }
                            if (this.mPlayPauseButtonTwo != null && barView) {
                                this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                                setBarButtonsTint(mPlayPauseButtonTwo);
                            }   

                            controller.getTransportControls().play();
                        }
                        break;
                    }
                }
                if (!activeControllerAppRunning || mLauncher.mRadioWidget.isRadioPlaying()) {
                    // Uninstalled meanwhile: nothing to open (it used to crash here)
                    Intent launchIntent = launchIntentIfInstalled(activeController);
                    if (launchIntent != null) {
                        WindowUtil.removePip();
                        refreshLeftCycleForIntent(launchIntent);
                        mLauncher.startActivitySafely(null, launchIntent, "music");
                    }
                }
            }
        }

        temporarilyDisablePlayPauseButton = true;

        // The icon above is a guess made before the player has answered, and every update in the
        // next 500 ms is dropped: once the button is free again the real state is shown, and
        // once more a little later for a player slow to start (after a long sleep, say).
        mLauncher.mHandler.postDelayed(() -> {
            temporarilyDisablePlayPauseButton = false;
            setPlayPauseIcon();
        }, 500);
        mLauncher.mHandler.postDelayed(this::setPlayPauseIcon, PLAY_PAUSE_RECHECK_MS);
    }

    /** After a tap: the second look at the real state, see onPlayPauseButtonClicked(). */
    private static final long PLAY_PAUSE_RECHECK_MS = 1500L;

    public void onNextButtonClicked(boolean barView) {
        if (barView) {
            mLauncher.mWorkspace.scheduleAutoHide();
        }
        if (openLastPlayerIfNoSession()) {
            return;
        }

        if (mLauncher.mRadioWidget.isRadioPlaying() && "mediaController".equals(mediaSource)) {
            openActiveMusicPlayer(null);
            return;
        }

        MediaTransportController.handleAction(
                mLauncher,
                MediaTransportController.ACTION_NEXT,
                getTransportTargetPackage()
        );
        mLauncher.requestWidgetUpdate(DateMusicProvider.class, DateRadioProvider.class);
    }

    void setBarButtonsTint(Button button) {
        if (button == null) {
            return;
        }
        barTint = mLauncher.mPrefs.getBoolean(Keys.BLACK_BAR, false);
        if (barTint) {
            mLauncher.helpers.applyColorFilterToButton(button);
        }
    }

    void setWidgetButtonsTint(Button button) {
        if (button == null) {
            return;
        }
        widgetTint = mLauncher.mPrefs.getBoolean(Keys.BLACK_WIDGETS, false);
        if (widgetTint) {
            mLauncher.helpers.applyColorFilterToButton(button);
        }
    }
}
