package com.syu.canbus.warn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.loopview.LoopView;
import com.syu.loopview.OnItemScrollListener;
import com.syu.loopview.OnItemSelectedListener;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class UIWCYuncheShowAir {
    private static UIWCYuncheShowAir mInstance;
    Context context;
    public ArrayList<String> mLauStylelist;
    private View sWarnContent;
    int windowshownum = 0;
    int curscrollState = -1;
    int curscrollcnt = 0;
    int tempdata = 0;
    int winlevdata = 0;
    boolean recvflag = false;
    Runnable mShowWindowcnt = new Runnable() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.1
        @Override // java.lang.Runnable
        public void run() {
            UIWCYuncheShowAir.this.windowshownum--;
            if (UIWCYuncheShowAir.this.windowshownum == 0) {
                HandlerUI.getInstance().removeCallbacks(UIWCYuncheShowAir.this.mShowWindowcnt);
                DataCanbus.PROXY.cmd(5, new int[1], null, null);
                DataCanbus.PROXY.cmd(6, new int[1], null, null);
                WarnUtils.postDimiss(50);
                return;
            }
            HandlerUI.getInstance().removeCallbacks(UIWCYuncheShowAir.this.mShowWindowcnt);
            HandlerUI.getInstance().postDelayed(UIWCYuncheShowAir.this.mShowWindowcnt, 1000L);
        }
    };
    Runnable mShowScrollcnt = new Runnable() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.2
        @Override // java.lang.Runnable
        public void run() {
            UIWCYuncheShowAir.this.curscrollcnt--;
            if (UIWCYuncheShowAir.this.curscrollcnt < 0) {
                UIWCYuncheShowAir.this.curscrollcnt = 0;
                UIWCYuncheShowAir.this.initmLauStylelist();
                ((LoopView) UIWCYuncheShowAir.this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(28);
                if (UIWCYuncheShowAir.this.tempdata == -2) {
                    ((LoopView) UIWCYuncheShowAir.this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(28);
                } else if (UIWCYuncheShowAir.this.tempdata == -3) {
                    ((LoopView) UIWCYuncheShowAir.this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(0);
                } else if (UIWCYuncheShowAir.this.tempdata == 0) {
                    ((LoopView) UIWCYuncheShowAir.this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(28);
                } else {
                    int value = 64 - UIWCYuncheShowAir.this.tempdata;
                    if (value > 27) {
                        value = 27;
                    }
                    UIWCYuncheShowAir.this.mLauStylelist.add(value, String.valueOf(UIWCYuncheShowAir.this.tempdata / 2.0f) + "℃");
                    UIWCYuncheShowAir.this.mLauStylelist.remove(value + 1);
                    ((LoopView) UIWCYuncheShowAir.this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(value);
                }
                ((LoopView) UIWCYuncheShowAir.this.sWarnContent.findViewById(R.id.layout_view1)).setItems(UIWCYuncheShowAir.this.mLauStylelist);
                HandlerUI.getInstance().removeCallbacks(UIWCYuncheShowAir.this.mShowScrollcnt);
                return;
            }
            HandlerUI.getInstance().removeCallbacks(UIWCYuncheShowAir.this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(UIWCYuncheShowAir.this.mShowScrollcnt, 1000L);
        }
    };
    Runnable mShowSeekbarcnt = new Runnable() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.3
        @Override // java.lang.Runnable
        public void run() {
            UIWCYuncheShowAir.this.curscrollcnt--;
            if (UIWCYuncheShowAir.this.curscrollcnt < 0) {
                UIWCYuncheShowAir.this.curscrollcnt = 0;
                ((SeekBar) UIWCYuncheShowAir.this.sWarnContent.findViewById(R.id.air_pa_jeep_wind_lev)).setProgress(UIWCYuncheShowAir.this.winlevdata);
                HandlerUI.getInstance().removeCallbacks(UIWCYuncheShowAir.this.mShowSeekbarcnt);
            } else {
                HandlerUI.getInstance().removeCallbacks(UIWCYuncheShowAir.this.mShowSeekbarcnt);
                HandlerUI.getInstance().postDelayed(UIWCYuncheShowAir.this.mShowSeekbarcnt, 1000L);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.4
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.air_pa_jeep_wind_lev /* 2131428108 */:
                    Log.v("zed", "onStopTrackingTouch value = " + v.getProgress());
                    UIWCYuncheShowAir.this.curscrollcnt = 2;
                    UIWCYuncheShowAir.this.windowshownum = 6;
                    UIWCYuncheShowAir.this.mUpdaterSeekbarcnt(UIWCYuncheShowAir.this.recvflag);
                    int value = v.getProgress();
                    DataCanbus.PROXY.cmd(1, new int[]{39, value}, null, null);
                    Log.v("zed", "DataCanbus.PROXY.cmd 0x27 value = " + value);
                    break;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            arg0.getId();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar arg0) {
        }
    };

    public static UIWCYuncheShowAir getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCYuncheShowAir();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        PopupWindow window = WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null && (DataCanbus.DATA[120] != 0 || DataCanbus.DATA[121] != 0)) {
            WarnUtils.showWindow();
            this.recvflag = false;
            this.windowshownum = 6;
            mUpdaterWindowShow(true);
            return;
        }
        if (window.isShowing()) {
            this.windowshownum = 0;
            mUpdaterWindowShow(false);
            window.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmLauStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add("HI");
        this.mLauStylelist.add("31.5");
        this.mLauStylelist.add("31.0");
        this.mLauStylelist.add("30.5");
        this.mLauStylelist.add("30.0");
        this.mLauStylelist.add("29.5");
        this.mLauStylelist.add("29.0");
        this.mLauStylelist.add("28.5");
        this.mLauStylelist.add("28.0");
        this.mLauStylelist.add("27.5");
        this.mLauStylelist.add("27.0");
        this.mLauStylelist.add("26.5");
        this.mLauStylelist.add("26.0");
        this.mLauStylelist.add("25.5");
        this.mLauStylelist.add("25.0");
        this.mLauStylelist.add("24.5");
        this.mLauStylelist.add("24.0");
        this.mLauStylelist.add("23.5");
        this.mLauStylelist.add("23.0");
        this.mLauStylelist.add("22.5");
        this.mLauStylelist.add("22.0");
        this.mLauStylelist.add("21.5");
        this.mLauStylelist.add("21.0");
        this.mLauStylelist.add("20.5");
        this.mLauStylelist.add("20.0");
        this.mLauStylelist.add("19.5");
        this.mLauStylelist.add("19.0");
        this.mLauStylelist.add("18.5");
        this.mLauStylelist.add("LO");
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = TheApp.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0444_wc_yunche_airshow, (ViewGroup) null, false);
            this.mLauStylelist = new ArrayList<>();
            initmLauStylelist();
            ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setNotLoop();
            ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setListener(new OnItemSelectedListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.5
                @Override // com.syu.loopview.OnItemSelectedListener
                public void onItemSelected(int index) {
                    if (UIWCYuncheShowAir.this.curscrollState == 2) {
                        UIWCYuncheShowAir.this.curscrollcnt = 2;
                        UIWCYuncheShowAir.this.windowshownum = 6;
                        UIWCYuncheShowAir.this.mUpdaterScrollcnt(UIWCYuncheShowAir.this.recvflag);
                        switch (index) {
                            case 0:
                                DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                                break;
                            case 28:
                                DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                                break;
                            default:
                                int value2 = 64 - index;
                                DataCanbus.PROXY.cmd(1, new int[]{37, value2}, null, null);
                                break;
                        }
                    }
                }
            });
            ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setOnItemScrollListener(new OnItemScrollListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.6
                @Override // com.syu.loopview.OnItemScrollListener
                public void onItemScrollStateChanged(LoopView loopView, int currentPassItem, int oldScrollState, int scrollState, int totalScrollY) {
                    UIWCYuncheShowAir.this.curscrollState = scrollState;
                    UIWCYuncheShowAir.this.windowshownum = 6;
                    if (scrollState == 0) {
                        UIWCYuncheShowAir.this.curscrollcnt = 2;
                        UIWCYuncheShowAir.this.mUpdaterScrollcnt(UIWCYuncheShowAir.this.recvflag);
                        switch (currentPassItem) {
                            case 0:
                                DataCanbus.PROXY.cmd(1, new int[]{37, 255}, null, null);
                                break;
                            case 28:
                                DataCanbus.PROXY.cmd(1, new int[]{37, 254}, null, null);
                                break;
                            default:
                                int value2 = 64 - currentPassItem;
                                DataCanbus.PROXY.cmd(1, new int[]{37, value2}, null, null);
                                break;
                        }
                    }
                }

                @Override // com.syu.loopview.OnItemScrollListener
                public void onItemScrolling(LoopView loopView, int currentPassItem, int scrollState, int totalScrollY) {
                }
            });
            ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setItems(this.mLauStylelist);
            ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setCenterTextSize(40.0f);
            ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setOuterTextSize(34.0f);
            seekbaronClick((SeekBar) this.sWarnContent.findViewById(R.id.air_pa_jeep_wind_lev));
            this.sWarnContent.findViewById(R.id.btn_air_temp_left_plus).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    UIWCYuncheShowAir.this.windowshownum = 6;
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(1, new int[]{13, 1}, null, null);
                    } else if (action == 1) {
                        DataCanbus.PROXY.cmd(1, new int[]{13, 0}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.btn_air_temp_left_minus).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.8
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    UIWCYuncheShowAir.this.windowshownum = 6;
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(1, new int[]{14, 1}, null, null);
                    } else if (action == 1) {
                        DataCanbus.PROXY.cmd(1, new int[]{14, 0}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.dj_xts_air_win_plus_btn).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.9
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    UIWCYuncheShowAir.this.windowshownum = 6;
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(1, new int[]{11, 1}, null, null);
                    } else if (action == 1) {
                        DataCanbus.PROXY.cmd(1, new int[]{11, 0}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.dj_xts_air_win_minuts_btn).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.10
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    UIWCYuncheShowAir.this.windowshownum = 6;
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(1, new int[]{12, 1}, null, null);
                    } else if (action == 1) {
                        DataCanbus.PROXY.cmd(1, new int[]{12, 0}, null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.11
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(8, new int[1], null, null);
                    }
                    return true;
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.canbus.warn.UIWCYuncheShowAir.12
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getAction();
                    if (action == 0) {
                        DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                    } else {
                        DataCanbus.PROXY.cmd(8, new int[1], null, null);
                    }
                    return true;
                }
            });
        }
        switch (updateCode) {
            case 21:
                mUpdaterAirWindLevelLeft();
                break;
            case 27:
                mUpdateAirTempLeft();
                break;
            case 120:
                this.sWarnContent.findViewById(R.id.layout_view2).setVisibility(value == 1 ? 0 : 8);
                this.sWarnContent.findViewById(R.id.layout_view3).setVisibility(value != 0 ? 8 : 0);
                break;
            case 121:
                this.sWarnContent.findViewById(R.id.layout_view4).setVisibility(value == 1 ? 0 : 8);
                this.sWarnContent.findViewById(R.id.layout_view5).setVisibility(value != 0 ? 8 : 0);
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }

    private void mUpdateAirTempLeft() {
        int temp = DataCanbus.DATA[27];
        this.tempdata = temp;
        if (this.curscrollcnt != 0) {
            this.recvflag = true;
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
        }
        if (((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)) != null) {
            initmLauStylelist();
            if (temp == -2) {
                ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(28);
            } else if (temp == -3) {
                ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(0);
            } else if (temp == 0) {
                ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(28);
            } else {
                int temp2 = 64 - temp;
                if (temp2 > 27) {
                    temp2 = 27;
                }
                this.mLauStylelist.add(temp2, String.valueOf(this.tempdata / 2.0f) + "℃");
                this.mLauStylelist.remove(temp2 + 1);
                ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setCurrentPosition(temp2);
            }
            ((LoopView) this.sWarnContent.findViewById(R.id.layout_view1)).setItems(this.mLauStylelist);
        }
    }

    private void mUpdaterAirWindLevelLeft() {
        int leave = DataCanbus.DATA[21];
        this.winlevdata = leave;
        if (this.curscrollcnt != 0) {
            this.recvflag = true;
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
            HandlerUI.getInstance().removeCallbacks(this.mShowSeekbarcnt);
        }
        Log.v("zed", "mUpdaterAirWindLevelLeft leave = " + leave);
        ((SeekBar) this.sWarnContent.findViewById(R.id.air_pa_jeep_wind_lev)).setProgress(leave);
        ((SeekBar) this.sWarnContent.findViewById(R.id.air_pa_jeep_wind_lev)).invalidate();
    }

    private void mUpdaterWindowShow(boolean flag) {
        if (flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
            HandlerUI.getInstance().postDelayed(this.mShowWindowcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowWindowcnt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterScrollcnt(boolean flag) {
        if (!flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
            HandlerUI.getInstance().postDelayed(this.mShowScrollcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowScrollcnt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeekbarcnt(boolean flag) {
        if (!flag) {
            HandlerUI.getInstance().removeCallbacks(this.mShowSeekbarcnt);
            HandlerUI.getInstance().postDelayed(this.mShowSeekbarcnt, 1000L);
        } else {
            HandlerUI.getInstance().removeCallbacks(this.mShowSeekbarcnt);
        }
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }
}
