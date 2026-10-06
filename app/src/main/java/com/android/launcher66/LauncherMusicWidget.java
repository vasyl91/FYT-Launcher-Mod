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
import com.android.async.AsyncTask;
import com.android.launcher66.settings.Keys;
import com.android.recycler.AppListBean;
import com.fyt.car.IUiRefresher;
import com.fyt.car.LauncherNotify;
import com.fyt.car.MusicService;
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
            mAudioManager = (AudioManager) mLauncher.getSystemService(Context.AUDIO_SERVICE);
            mediaSource = source; 
            if (mediaSource == null) {
                mediaSource = "fyt";
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
                Lrc lrc = new Lrc();
                Id3Info info = lrc.getId3Info(path);
                byte[] dataPic =  info.dataPic;
                if (dataPic == null) {
                    dataPic = byts;
                }
                if (dataPic != null && dataPic.length > 0) {
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
                        if (tvAritst != null) {
                            tvAritst.setText("Live");
                        }    
                        if (tvAritstTwo != null) {
                            tvAritstTwo.setText("Live");
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
            if (CarStates.mAppID != 8 && ("fyt".equals(mediaSource) || activeController == null)) {
                if (MusicService.music_path != null && !MusicService.music_path.isEmpty() && MusicService.music_path.lastIndexOf("/") >= 0) {
                    if (mLauncher.fytData) { // from metadata
                        musictitle = MusicService.music_name;
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
            MediaWidgetState.Snapshot snapshot = MediaWidgetState.getExternalSnapshot();
            if (snapshot != null) {
                return snapshot.playing;
            }
            return "true".equals(mLauncher.state);
        }
        // Not mAudioManager.isMusicActive() directly: see AudioStateCache.
        return MusicService.state.booleanValue()
                || AudioStateCache.isMusicActive(mLauncher, AUDIO_STATE_WAIT_MS);
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

    public void preSetMusicWidgets() {
        Bitmap savedBitmap = getBitmapFromPreferences();
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

        // seeded so the first live update is not written back as a change
        lastMusictitle = normalizeMediaText(mLauncher.mPrefs.getString(MUSIC_TITLE_PREF, null));
        lastArtist = normalizeMediaText(mLauncher.mPrefs.getString(ARTIST_PREF, null));
        showMusicTitle(lastMusictitle);
        showMusicArtist(lastArtist);

        mAudioManager = (AudioManager) mLauncher.getSystemService(Context.AUDIO_SERVICE);
        // Asked once for both buttons, and never waiting long for the audioserver; see AudioStateCache.
        final boolean playing = MusicService.state.booleanValue()
                || AudioStateCache.isMusicActive(mLauncher, AUDIO_STATE_WAIT_MS);
        if (this.mPlayPauseButton != null) {
            if (playing) {
                this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            } else {
                this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            }
        }
        if (this.mPlayPauseButtonTwo != null) {
            if (playing) {
                this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            } else {
                this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            }
        }    
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
        if (title.equals(lastMusictitle)) {
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
        
        new AsyncTask<Object, Void, Void>() {
            @Override
            protected void onProgress(Void[] progress) {
                //
            }

            @Override
            protected Void doInBackground(Object... params) {
                Bitmap bitmapToSave = (Bitmap) params[0];
                String path = (String) params[1];
                
                try {
                    // Double-check with persisted path
                    String lastSavedPath = mLauncher.mPrefs.getString(PREF_LAST_ALBUM_PATH, "");
                    
                    if (path.equals(lastSavedPath)) {
                        return null; // Already saved for this path
                    }
                    
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmapToSave.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String encodedBitmap = Base64.encodeToString(byteArray, Base64.DEFAULT);
                    
                    SharedPreferences.Editor editor = mLauncher.mPrefs.edit();
                    editor.putString(PREF_LAST_ALBUM_ART, encodedBitmap);
                    editor.putString(PREF_LAST_ALBUM_PATH, path);
                    editor.apply();
                    
                    // Update in-memory cache
                    lastProcessedPath = path;
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onBackgroundError(Exception e) {
                Log.e(Launcher.TAG, "saveBitmapToPreferences: " + e.getMessage());
            }
        }.execute(bitmap, currentPath);
    }

    Bitmap getBitmapFromPreferences() {
        try {
            String encodedBitmap = mLauncher.mPrefs.getString(PREF_LAST_ALBUM_ART, null);
            
            if (encodedBitmap != null) {
                byte[] decodedBytes = Base64.decode(encodedBitmap, Base64.DEFAULT);
                return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
        String preferredPackage = getPreferredMediaControllerPackage();
        if (MediaFavoriteController.isFavoriteTemporarilyDisabledPackage(preferredPackage)) {
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

        if (mLauncher.mRadioWidget.isRadioPlaying() && "mediaController".equals(mediaSource)) {
            openActiveMusicPlayer(null);
            return;
        }

        MediaTransportController.handleAction(
                mLauncher,
                MediaTransportController.ACTION_PREVIOUS,
                getPreferredMediaControllerPackage()
        );
        mLauncher.requestWidgetUpdate(DateMusicProvider.class, DateRadioProvider.class);
    }

    public void onPlayPauseButtonClicked(boolean barView) {
        if (barView) {
            mLauncher.mWorkspace.scheduleAutoHide();
        }
        if (!temporarilyDisablePlayPauseButton) {
            if ("fyt".equals(mediaSource)) {
                if (this.mPlayPauseButton != null) {
                    if (MusicService.state.booleanValue()) {
                        this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setWidgetButtonsTint(mPlayPauseButton);
                    } else {
                        this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                        setWidgetButtonsTint(mPlayPauseButton);
                    }
                }
                if (this.mPlayPauseButtonTwo != null && barView) {
                    if (MusicService.state.booleanValue()) {
                        this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setBarButtonsTint(mPlayPauseButtonTwo);
                    } else {
                        this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                        setBarButtonsTint(mPlayPauseButtonTwo);
                    }
                } 
                Intent intent = new Intent();
                intent.setAction("com.syu.music.playpause");
                intent.setPackage("com.syu.music");
                SysCalls.startService(mLauncher, intent);
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

                        if (playbackState == PlaybackState.STATE_PLAYING) {
                            mLauncher.handler.postDelayed(() -> {
                                if (playbackState == PlaybackState.STATE_PLAYING) {
                                    if (this.mPlayPauseButton != null) {
                                        this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                                        setWidgetButtonsTint(mPlayPauseButton);
                                    }
                                    if (this.mPlayPauseButtonTwo != null && barView) {
                                        this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                                        setBarButtonsTint(mPlayPauseButtonTwo);
                                    } 
                                    controller.getTransportControls().pause();  
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
                    WindowUtil.removePip();
                    Intent launchIntent = mLauncher.getPackageManager().getLaunchIntentForPackage(activeController);
                    try {
                        ComponentName componentName = launchIntent.getComponent();
                        PackageManager pm = mLauncher.getPackageManager();
                        ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                        String appTitle = appInfo.loadLabel(pm).toString();
                        AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                        mLauncher.refreshLeftCycle(bean);
                        mLauncher.cleanWidgetBar();
                    } catch (PackageManager.NameNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    mLauncher.startActivity(launchIntent);
                }
            }
        }

        temporarilyDisablePlayPauseButton = true;

        mLauncher.mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                temporarilyDisablePlayPauseButton = false;
            }
        }, 500);
    }

    public void onNextButtonClicked(boolean barView) {
        if (barView) {
            mLauncher.mWorkspace.scheduleAutoHide();
        }

        if (mLauncher.mRadioWidget.isRadioPlaying() && "mediaController".equals(mediaSource)) {
            openActiveMusicPlayer(null);
            return;
        }

        MediaTransportController.handleAction(
                mLauncher,
                MediaTransportController.ACTION_NEXT,
                getPreferredMediaControllerPackage()
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
