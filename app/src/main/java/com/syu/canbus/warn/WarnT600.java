package com.syu.canbus.warn;

import android.content.Context;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import com.syu.util.ObjApp;
import com.syu.util.SecondTickThread;
import com.syu.util.ToolkitApp;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WarnT600 implements Runnable {
    static int mTick = 0;
    private static WarnT600 mWarn;
    private Context context;
    private int iUpdateCode;
    private LinearLayout mLayout;
    private Ringtone mRingTone;
    private TextView mText;
    private final int TEXT_SIZE = 13;
    private final int VIEW_WITH = ConstRzcAddData.U_CAR_ADD_START;
    private final int VIEW_HEIGHT = 300;
    private WindowManager.LayoutParams mLp = ToolkitApp.buildOverlayLayoutParams(ConstRzcAddData.U_CAR_ADD_START, 300);
    boolean isShow = false;
    private Runnable SHOW = new Runnable() { // from class: com.syu.canbus.warn.WarnT600.1
        @Override // java.lang.Runnable
        public void run() {
            WarnT600.mTick = 15;
            if (WarnT600.this.mLayout != null && !WarnT600.this.isShow) {
                WarnT600.this.isShow = true;
                ObjApp.getWindowManager().addView(WarnT600.this.mLayout, WarnT600.this.getWindowLayoutParams());
            }
        }
    };
    private Runnable HIDE = new Runnable() { // from class: com.syu.canbus.warn.WarnT600.2
        @Override // java.lang.Runnable
        public void run() {
            if (WarnT600.this.mLayout != null && WarnT600.this.isShow) {
                WarnT600.this.isShow = false;
                WarnT600.mTick = 0;
                DataCanbus.DATA[WarnT600.this.iUpdateCode] = -1;
                ObjApp.getWindowManager().removeView(WarnT600.this.mLayout);
            }
        }
    };
    int[] resWarnId = {R.string.str_265_8, R.string.str_265_9, R.string.str_265_10, R.string.str_265_11, R.string.str_265_12, R.string.str_265_13, R.string.str_265_14, R.string.str_265_15, R.string.str_265_16, R.string.str_265_17, R.string.str_265_18};
    int ilastLevel = 0;
    private WarnRing mWarnRing = new WarnRing(this, null);
    private Thread mRingThread = new Thread(this.mWarnRing);

    public WarnT600() {
        init();
        mWarn = this;
    }

    public static synchronized WarnT600 getInstance() {
        WarnT600 warnT600;
        synchronized (WarnT600.class) {
            if (mWarn == null) {
                mWarn = new WarnT600();
            }
            warnT600 = mWarn;
        }
        return warnT600;
    }

    private void init() {
        if (this.mLayout == null) {
            SecondTickThread.getInstance().addTick(this);
            this.context = LauncherApplication.getInstance();
            Uri notification = RingtoneManager.getDefaultUri(2);
            this.mRingTone = RingtoneManager.getRingtone(this.context, notification);
            this.mLayout = new LinearLayout(this.context);
            this.mLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mLayout.setBackgroundColor(Color.parseColor("#AA48525E"));
            this.mLayout.setPadding(10, 10, 10, 10);
            this.mLayout.setOrientation(0);
            this.mLayout.setGravity(17);
            ImageView iv = new ImageView(this.context);
            iv.setBackgroundResource(R.drawable.ic_dasauto_wc_warnning);
            this.mLayout.addView(iv);
            this.mText = new TextView(this.context);
            this.mText.setGravity(17);
            this.mText.setTextSize(35.0f);
            this.mText.setPadding(10, 10, 10, 10);
            this.mText.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
            this.mText.setTextColor(Color.parseColor("#FFFFFF"));
            this.mLayout.addView(this.mText);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (mTick > 0) {
            mTick--;
            if (mTick == 0) {
                hideWindow();
            }
        }
    }

    public WindowManager.LayoutParams getWindowLayoutParams() {
        this.mLp.x = (LauncherApplication.getScreenWidth() - 500) / 2;
        this.mLp.y = ((LauncherApplication.getScreenHeight() - 300) + 100) / 2;
        return this.mLp;
    }

    public void showWarnLevel(int level) {
        if (level > -1 && level < this.resWarnId.length) {
            this.ilastLevel = level;
            this.mText.setText(this.resWarnId[level]);
            HandlerUI.getInstance().post(this.SHOW);
            return;
        }
        hideWindow();
    }

    private void hideWindow() {
        HandlerUI.getInstance().post(this.HIDE);
    }

    public void showWindowTip(int updateCode, int i) {
        this.iUpdateCode = updateCode;
        if (i != 0) {
            int level = -1;
            int b0 = i & 255;
            int b1 = (i >> 8) & 255;
            if (DataCanbus.DATA[1000] == 327945) {
                if (((b0 >> 7) & 1) == 1) {
                    level = 2;
                } else if (((b0 >> 6) & 1) == 1) {
                    level = 1;
                } else if (((b0 >> 4) & 3) == 1) {
                    level = 7;
                } else if (((b0 >> 4) & 3) == 2) {
                    level = 8;
                } else if (((b0 >> 4) & 3) == 3) {
                    level = 9;
                } else if (((b0 >> 3) & 1) == 1) {
                    level = 10;
                } else if (((b0 >> 2) & 1) == 1) {
                    level = 6;
                } else if ((b0 & 3) == 1) {
                    level = 3;
                } else if ((b0 & 3) == 2) {
                    level = 4;
                } else if ((b0 & 3) == 3) {
                    level = 5;
                }
            } else if (b0 != 0) {
                switch (b0) {
                    case 3:
                        level = 0;
                        break;
                    case 4:
                        level = 1;
                        break;
                    case 5:
                        level = 2;
                        break;
                }
            } else if (b1 != 0) {
                switch (b1) {
                    case 1:
                        level = 3;
                        break;
                    case 2:
                        level = 4;
                        break;
                    case 3:
                        level = 5;
                        break;
                    case 4:
                        level = 6;
                        break;
                    case 5:
                        level = 7;
                        break;
                    case 6:
                        level = 8;
                        break;
                    case 7:
                        level = 9;
                        break;
                }
            }
            if (level == 1 || this.ilastLevel != level || mTick == 0) {
                showWarnLevel(level);
                if (level == 0) {
                    this.mWarnRing.setTimes(4);
                    new Thread(this.mWarnRing).start();
                    return;
                } else {
                    if (level == 1) {
                        this.mWarnRing.setTimes(2);
                        new Thread(this.mWarnRing).start();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        hideWindow();
    }

    private class WarnRing implements Runnable {
        private int times;

        private WarnRing() {
            this.times = 0;
        }

        /* synthetic */ WarnRing(WarnT600 warnT600, WarnRing warnRing) {
            this();
        }

        public void setTimes(int times) {
            this.times = times;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (this.times > 0) {
                if (!WarnT600.this.mRingTone.isPlaying()) {
                    WarnT600.this.mRingTone.play();
                    this.times--;
                    SystemClock.sleep(1000L);
                }
            }
        }
    }
}
