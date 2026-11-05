package com.syu.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.lsec.core.frame.app.MyApplication;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyMediaPlayer extends MediaPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener {
    private static final int LOCAL = 1;
    private static final int NETWORK = 0;
    public static AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.syu.util.MyMediaPlayer.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == -2 || focusChange == 1 || focusChange != -3) {
            }
        }
    };
    private static MyMediaPlayer myMediaPlayer;
    public AudioManager audioManager;
    private MediaPlayer mediaPlayer;
    private Timer mTimer = new Timer();
    private boolean isPlay = false;
    private Handler handleProgress = new Handler(Looper.getMainLooper()) { // from class: com.syu.util.MyMediaPlayer.2
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (MyMediaPlayer.this.mediaPlayer != null) {
                MyMediaPlayer.this.mediaPlayer.getDuration();
            }
        }
    };
    private TimerTask mTimerTask = new TimerTask() { // from class: com.syu.util.MyMediaPlayer.3
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MyMediaPlayer.this.isPlay = false;
            if (MyMediaPlayer.this.mediaPlayer != null && MyMediaPlayer.this.mediaPlayer.isPlaying()) {
                MyMediaPlayer.this.isPlay = true;
                MyMediaPlayer.this.handleProgress.sendEmptyMessage(0);
            }
        }
    };

    public MyMediaPlayer() {
        try {
            this.audioManager = (AudioManager) MyApplication.myApp.getSystemService("audio");
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayer.setAudioStreamType(2);
            this.mediaPlayer.setOnBufferingUpdateListener(this);
            this.mediaPlayer.setOnPreparedListener(this);
        } catch (Exception e) {
            Log.e("mediaPlayer", "error", e);
        }
        this.mTimer.schedule(this.mTimerTask, 0L, 1000L);
    }

    public static MyMediaPlayer getIntances() {
        if (myMediaPlayer == null) {
            synchronized (MyMediaPlayer.class) {
                if (myMediaPlayer == null) {
                    myMediaPlayer = new MyMediaPlayer();
                }
            }
        }
        return myMediaPlayer;
    }

    public static long getDurationLong(String url, int type) throws IOException {
        String duration = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            if (type == 0 || type == 1) {
                retriever.setDataSource(url);
            }
            duration = retriever.extractMetadata(9);
            try {
                retriever.release();
            } catch (RuntimeException e) {
            }
        } catch (Exception e2) {
            try {
                retriever.release();
            } catch (RuntimeException e3) {
            }
        } catch (Throwable th) {
            try {
                retriever.release();
            } catch (RuntimeException e4) {
            }
            throw th;
        }
        if (!TextUtils.isEmpty(duration)) {
            return Long.parseLong(duration);
        }
        return 0L;
    }

    public void playUrl(Context context, String url, boolean isAsync, final MediaPlayer.OnCompletionListener listener) {
        try {
            if (this.mediaPlayer != null) {
                this.mediaPlayer.reset();
                this.audioManager.requestAudioFocus(afChangeListener, 3, 3);
                this.mediaPlayer.setDataSource(context, Uri.parse(url));
                setMpPrepareMrthod(this.mediaPlayer, isAsync);
                this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.syu.util.MyMediaPlayer.4
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mp) {
                        MyMediaPlayer.this.playCompletion(mp, listener);
                    }
                });
                this.mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.syu.util.MyMediaPlayer.5
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mp, int what, int extra) {
                        MyMediaPlayer.this.audioManager.abandonAudioFocus(MyMediaPlayer.afChangeListener);
                        return false;
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setMpPrepareMrthod(MediaPlayer mp, boolean isAsync) {
        if (isAsync) {
            mp.prepareAsync();
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.syu.util.MyMediaPlayer.6
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mp2) {
                    mp2.start();
                }
            });
        } else {
            try {
                mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playCompletion(MediaPlayer mp, MediaPlayer.OnCompletionListener listener) {
        if (listener != null) {
            listener.onCompletion(mp);
        }
        this.audioManager.abandonAudioFocus(afChangeListener);
    }

    public void playUrl(Context context, String videoUrl) {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.reset();
            Uri uri = Uri.parse(videoUrl);
            try {
                this.mediaPlayer.setDataSource(context, uri);
                this.mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void play(AssetFileDescriptor fd) {
        if (fd != null && this.mediaPlayer != null) {
            this.mediaPlayer.reset();
            this.audioManager.requestAudioFocus(afChangeListener, 2, 3);
            try {
                this.mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
                this.mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.media.MediaPlayer
    public void setNextMediaPlayer(MediaPlayer next) {
        super.setNextMediaPlayer(next);
    }

    @Override // android.media.MediaPlayer
    public boolean isPlaying() {
        return this.isPlay;
    }

    @Override // android.media.MediaPlayer
    public void pause() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.pause();
        }
    }

    @Override // android.media.MediaPlayer
    public void start() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.start();
        }
    }

    @Override // android.media.MediaPlayer
    public void stop() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public void releaseMedia() {
        this.mTimerTask.cancel();
        this.handleProgress.removeCallbacksAndMessages(null);
        if (this.mediaPlayer != null) {
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer arg0) {
        arg0.start();
        Log.e("mediaPlayer", "onPrepared");
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer arg0) {
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer arg0, int bufferingProgress) {
    }
}
