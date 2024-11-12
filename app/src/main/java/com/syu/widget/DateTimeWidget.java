package com.syu.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RemoteViews;
import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.fyt.skin.SkinUtils;
import com.syu.util.WeatherUtils;
import com.syu.weather.WeatherDescription;
import com.syu.widget.util.TimeUtil;
import share.ResValue;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class DateTimeWidget extends Widget {
    private static final int[] mImageRes = {ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
    private static final int[] mImageId = {ResValue.getInstance().mtu_img_ht1, ResValue.getInstance().mtu_img_hu1, ResValue.getInstance().mtu_img_mt1, ResValue.getInstance().mtu_img_mu1};

    public DateTimeWidget(Context context, int id) {
        super(context, id);
    }

    @Override // com.syu.widget.Widget
    void updateViews(RemoteViews views) {
        int index;
        views.setTextViewText(ResValue.getInstance().dt_weekday1, TimeUtil.getWeekDay(this.mContext));
        switch (LauncherApplication.sApp.getResources().getInteger(R.integer.apps_timewidget_show)) {
            case 0:
                views.setTextViewText(ResValue.getInstance().dt_date1, TimeUtil.getDateOfToday(this.mContext, "yyyy-MM-dd"));
                break;
            case 1:
                views.setTextViewText(ResValue.getInstance().dt_date1, TimeUtil.getDateOfToday(this.mContext, "yyyy/MM/dd"));
                break;
            case 2:
                views.setTextViewText(ResValue.getInstance().dt_date1, TimeUtil.getDateOfToday(this.mContext, "yyyy.MM.dd"));
                break;
            case 3:
                views.setTextViewText(ResValue.getInstance().dt_date1, TimeUtil.getDateOfToday(this.mContext, "yyyy - MM - dd"));
                break;
        }
        if (TimeUtil.b24Hour(this.mContext)) {
            views.setViewVisibility(ResValue.getInstance().dt_ampm1, View.GONE);
        } else {
            views.setViewVisibility(ResValue.getInstance().dt_ampm1, View.VISIBLE);
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.app_ampm_show)) {
                views.setTextViewText(ResValue.getInstance().dt_ampm1, TimeUtil.getAmPm(this.mContext));
            } else {
                views.setImageViewResource(ResValue.getInstance().dt_ampm1, TimeUtil.getAmPm(this.mContext).equals(this.mContext.getString(R.string.am)) ? ResValue.getInstance().im_am : ResValue.getInstance().im_pm);
            }
        }
        String hm = TimeUtil.getCurStr(this.mContext);
        char[] times = hm.toCharArray();
        int len = times.length;
        if (len == 3) {
            views.setViewVisibility(mImageId[0], View.GONE);
            views.setImageViewResource(mImageId[0], 0);
        } else if (len > 3) {
            views.setViewVisibility(mImageId[0], View.VISIBLE);
        }
        for (int i = 0; i < len; i++) {
            try {
                if (times[i] != ':' && (index = Math.max(0, Math.min(Integer.parseInt(new String(new char[]{times[i]})), mImageRes.length - 1))) >= 0) {
                    int w = len > 3 ? i : i + 1;
                    views.setImageViewBitmap(mImageId[Math.max(0, Math.min(w, mImageId.length - 1))], SkinUtils.getBitmap(mImageRes[index]));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bmp;
    }

    private void updateWeather(RemoteViews views) {
        if (Launcher.getLauncher() != null) {
            refreshData(views, Launcher.getLauncher().mCurDescription);
        }
    }

    private void refreshData(RemoteViews views, WeatherDescription weather) {
        if (weather != null && weather.vaild()) {
            views.setTextViewText(ResValue.getInstance().weather_city, weather.getCity());
            views.setTextViewText(ResValue.getInstance().weather_temp_range, weather.getTemDescription());
            views.setTextViewText(ResValue.getInstance().weather_temp, weather.getCurTem());
            views.setTextViewText(ResValue.getInstance().weather_weather, weather.getWeather());
            views.setImageViewResource(ResValue.getInstance().weather_imge, WeatherUtils.getWeatherImagId(this.mContext, weather.getWeather()));
        }
    }

    @Override // com.syu.widget.Widget
    void addLisenter(RemoteViews views) {
        Intent mIntent = new Intent("android.settings.DATE_SETTINGS");
        PendingIntent pendIntent = PendingIntent.getActivity(this.mContext, 0, mIntent, PendingIntent.FLAG_IMMUTABLE);
        views.setOnClickPendingIntent(ResValue.getInstance().dt_layout, pendIntent);
    }

    @Override // com.syu.widget.Widget
    void getLayoutId() {
        this.layoutId = ResValue.getInstance().fyt_xml_dtwidget;
    }

    @Override // com.syu.widget.Widget
    protected void add() {
        TimeUpdateReceiver.addWidget(this);
        super.add();
    }

    @Override // com.syu.widget.Widget
    public void delete() {
        TimeUpdateReceiver.removeWidget(this);
        super.delete();
    }
}
