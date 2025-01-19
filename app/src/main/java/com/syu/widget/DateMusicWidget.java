package com.syu.widget;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.RemoteViews;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.fyt.car.MusicService;
import com.syu.car.CarStates;
import com.syu.log.LogPreview;
import com.syu.util.Id3Info;
import com.syu.util.Lrc;

import share.ResValue;

public class DateMusicWidget extends Widget {
    private int count;
    private String music_path_pre;
    private boolean runAnimation;
    private final Runnable runnable;
    private static final int[] mImageRes = {ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
    private static final int[] mImageId = {ResValue.getInstance().mtu_img_ht1, ResValue.getInstance().mtu_img_hu1, ResValue.getInstance().mtu_img_mt1, ResValue.getInstance().mtu_img_mu1};

    public DateMusicWidget(Context context, int id) {
        super(context, id);
        this.music_path_pre = "";
        this.count = 0;
        this.runAnimation = false;
        this.runnable = new Runnable() { 
            @Override
            public void run() {
                Widget.widgetUpdate(LauncherApplication.sApp, DateMusicProvider.class);
                LauncherApplication.handler.postDelayed(this, 500L);
            }
        };
    }

    @Override
        // com.syu.widget.Widget
    void updateViews(RemoteViews views) {
        LogPreview.show("updateViews");
        if (Launcher.mainState == 8) {
            if (MusicService.state.booleanValue()) {
                int i = ResValue.getInstance().widget_music_score;
                int i2 = ResValue.getInstance().music_score_0;
                int i3 = this.count;
                this.count = i3 + 1;
                views.setImageViewResource(i, i2 + i3);
                if (this.count == 10) {
                    this.count = 0;
                }
                if (!this.runAnimation) {
                    LauncherApplication.handler.post(this.runnable);
                    this.runAnimation = true;
                }
            } else {
                LauncherApplication.handler.removeCallbacks(this.runnable);
                this.runAnimation = false;
            }
        }
        if (MusicService.music_path != null) {
            if (MusicService.music_path.equals("") || MusicService.music_path.lastIndexOf("/") < 0) {
                LogPreview.show("MusicService.music_path" + MusicService.music_path);
                views.setTextViewText(ResValue.getInstance().music_name, this.mContext.getResources().getString(R.string.music_name));
            } else {
                String musictitle = MusicService.music_path.substring(MusicService.music_path.lastIndexOf("/") + 1);
                views.setTextViewText(ResValue.getInstance().music_name, musictitle);
            }
        }
        if (MusicService.music_path != null && !MusicService.music_path.equals(this.music_path_pre)) {
            this.music_path_pre = MusicService.music_path;
            Lrc lrc = new Lrc();
            Id3Info info = lrc.getId3Info(MusicService.music_path);
            byte[] dataPic = info.dataPic;
            if (dataPic != null && dataPic.length > 0) {
                Bitmap bp = BitmapFactory.decodeByteArray(dataPic, 0, dataPic.length);
                if (bp != null) {
                    if (LauncherApplication.sApp.getResources().getBoolean(R.bool.music_bitmap_circular)) {
                        bp = makeRoundCorner(bp);
                    }
                    views.setImageViewBitmap(ResValue.getInstance().ivwidget_album_bg, bp);
                }
            } else {
                views.setImageViewResource(ResValue.getInstance().ivwidget_album_bg, ResValue.getInstance().music_album_def);
            }
        }
        if (MusicService.author_name != null) {
            if (MusicService.author_name.equals("")) {
                views.setTextViewText(ResValue.getInstance().music_art, this.mContext.getResources().getString(R.string.music_author));
            } else {
                views.setTextViewText(ResValue.getInstance().music_art, MusicService.author_name);
            }
        }
        if (MusicService.state.booleanValue()) {
            if (Launcher.sNightMode) {
                views.setImageViewResource(ResValue.getInstance().musicbutton_playpause, ResValue.getInstance().music_playpause_icon_n);
            } else {
                views.setImageViewResource(ResValue.getInstance().musicbutton_playpause, ResValue.getInstance().music_playpause_icon);
            }
        } else if (Launcher.sNightMode) {
            views.setImageViewResource(ResValue.getInstance().musicbutton_playpause, ResValue.getInstance().music_pause_icon_n);
        } else {
            views.setImageViewResource(ResValue.getInstance().musicbutton_playpause, ResValue.getInstance().music_pause_icon);
        }
        if (MusicService.CURMINUTES >= 0) {
            long curProgress = MusicService.CURMINUTES;
            long totalProgress = MusicService.TOTALMINUTES;
            if (totalProgress > 0) {
                if (curProgress < 0) {
                    curProgress = 0;
                }
                int precent = (int) ((1000 * curProgress) / totalProgress);
                views.setProgressBar(ResValue.getInstance().music_progress, 1000, precent, false);
            } else {
                views.setProgressBar(ResValue.getInstance().music_progress, 1000, 0, false);
            }
            String cur = timeParse(curProgress);
            String total = timeParse(totalProgress);
            views.setTextViewText(ResValue.getInstance().music_cur_time, cur);
            views.setTextViewText(ResValue.getInstance().music_total_time, total);
        }
        if (CarStates.mAppID != 8) {
            clearMusicCache(views);
        }
    }

    private void clearMusicCache(RemoteViews views) {
        views.setTextViewText(ResValue.getInstance().music_name, this.mContext.getResources().getString(R.string.music_name));
        views.setTextViewText(ResValue.getInstance().music_art, this.mContext.getResources().getString(R.string.music_author));
        views.setImageViewResource(ResValue.getInstance().ivwidget_album_bg, ResValue.getInstance().musicwidget_album_def);
        views.setTextViewText(ResValue.getInstance().music_cur_time, "00:00");
        views.setTextViewText(ResValue.getInstance().music_total_time, "00:00");
        views.setProgressBar(ResValue.getInstance().music_progress, 1000, 0, false);
    }

    private static Bitmap big(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            matrix.postScale(145.0f / bitmap.getWidth(), 145.0f / bitmap.getHeight());
            Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return resizeBmp;
        }
        return bitmap;
    }

    public String timeParse(long duration) {
        String time = "";
        long minute = duration / 60000;
        long seconds = duration % 60000;
        long second = Math.round(((float) seconds) / 1000.0f);
        if (minute < 10) {
            time = "" + "0";
        }
        String time2 = time + minute + ":";
        if (second < 10) {
            time2 = time2 + "0";
        }
        return time2 + second;
    }

    public String timeChangeParse(long duration) {
        long hour = duration / 3600;
        long min = (duration / 60) % 60;
        long sec = duration % 60;
        String time = String.format("%02d:%02d:%02d", Long.valueOf(hour), Long.valueOf(min), Long.valueOf(sec));
        return time;
    }

    public static Bitmap makeRoundCorner(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int left = 0;
        int top = 0;
        int right = width;
        int bottom = height;
        float roundPx = height / 2;
        if (width > height) {
            left = (width - height) / 2;
            top = 0;
            right = left + height;
            bottom = height;
        } else if (height > width) {
            left = 0;
            top = (height - width) / 2;
            right = width;
            bottom = top + width;
            roundPx = width / 2;
        }
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(left, top, right, bottom);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BDBDBE"));
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    @Override
        // com.syu.widget.Widget
    void addLisenter(RemoteViews views) {
        Intent intent = new Intent(WidgetProvider.APP_WIDGET_START);
        intent.setComponent(new ComponentName("com.syu.music", "com.syu.music.MAct"));
        views.setOnClickPendingIntent(ResValue.getInstance().dt_music_layout, PendingIntent.getActivity(this.mContext, 0, intent, PendingIntent.FLAG_IMMUTABLE));
        Intent intent2 = new Intent(WidgetProvider.APP_WIDGET_START);
        intent2.setComponent(new ComponentName("com.syu.radio", "com.syu.radio.Launch"));
        views.setOnClickPendingIntent(ResValue.getInstance().dt_radio_layout, PendingIntent.getActivity(this.mContext, 0, intent2, PendingIntent.FLAG_IMMUTABLE));
        Intent intent3 = new Intent(WidgetProvider.APP_WIDGET_START);
        intent3.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
        views.setOnClickPendingIntent(ResValue.getInstance().dt_btav_layout, PendingIntent.getActivity(this.mContext, 0, intent3, PendingIntent.FLAG_IMMUTABLE));
        Intent mIntent4 = new Intent("android.settings.DATE_SETTINGS");
        PendingIntent pendIntent = PendingIntent.getActivity(this.mContext, 0, mIntent4, PendingIntent.FLAG_IMMUTABLE);
        views.setOnClickPendingIntent(ResValue.getInstance().dt_layout, pendIntent);
        views.setOnClickPendingIntent(ResValue.getInstance().musicbutton_prev, getPIntend(this.mContext, "com.syu.music.prev"));
        views.setOnClickPendingIntent(ResValue.getInstance().musicbutton_playpause, getPIntend(this.mContext, "com.syu.music.playpause"));
        views.setOnClickPendingIntent(ResValue.getInstance().musicbutton_next, getPIntend(this.mContext, "com.syu.music.next"));
        views.setOnClickPendingIntent(ResValue.getInstance().Radiobutton_prev, getPIntend(this.mContext, WidgetProvider.RADIOPREV));
        views.setOnClickPendingIntent(ResValue.getInstance().Radiobutton_next, getPIntend(this.mContext, WidgetProvider.RADIONEXT));
        views.setOnClickPendingIntent(ResValue.getInstance().btavbutton_prev, getPIntend(this.mContext, "com.syu.bt.byav.widgetPrev"));
        views.setOnClickPendingIntent(ResValue.getInstance().btavbutton_playpause, getPIntend(this.mContext, "com.syu.bt.byav.widgetPlayPause"));
        views.setOnClickPendingIntent(ResValue.getInstance().btavbutton_next, getPIntend(this.mContext, "com.syu.bt.byav.widgetNext"));
    }

    public PendingIntent getPIntend(Context context, String action) {
        return PendingIntent.getService(context, 0, new Intent(action), PendingIntent.FLAG_IMMUTABLE);
    }

    @Override
        // com.syu.widget.Widget
    void getLayoutId() {
        this.layoutId = ResValue.getInstance().fyt_xml_dtmusicwidget;
    }

    @Override
    protected void add() {
        super.add();
    }

    @Override
    public void delete() {
        TimeUpdateReceiver.removeWidget(this);
        super.delete();
    }
}
