package com.syu.carinfo.hechi.fordexplorer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HcFordExplorerRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static HcFordExplorerRadio mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 45:
                    HcFordExplorerRadio.this.updateRadioBand();
                    break;
                case 46:
                    if (HcFordExplorerRadio.this.unit == 1) {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                        break;
                    } else {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText((value / 100) + "." + (value % 100));
                        break;
                    }
                case 47:
                    HcFordExplorerRadio.this.updateRadioChannel();
                    break;
                case 48:
                    if (HcFordExplorerRadio.this.unit == 1) {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("  " + value + " khz");
                        break;
                    } else {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq1)).setText("  " + (value / 100) + "." + (value % 100) + " mhz");
                        break;
                    }
                case 49:
                    if (HcFordExplorerRadio.this.unit == 1) {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("  " + value + " khz");
                        break;
                    } else {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq2)).setText("  " + (value / 100) + "." + (value % 100) + " mhz");
                        break;
                    }
                case 50:
                    if (HcFordExplorerRadio.this.unit == 1) {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("  " + value + " khz");
                        break;
                    } else {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq3)).setText("  " + (value / 100) + "." + (value % 100) + " mhz");
                        break;
                    }
                case 51:
                    if (HcFordExplorerRadio.this.unit == 1) {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("  " + value + " khz");
                        break;
                    } else {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq4)).setText("  " + (value / 100) + "." + (value % 100) + " mhz");
                        break;
                    }
                case 52:
                    if (HcFordExplorerRadio.this.unit == 1) {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("  " + value + " khz");
                        break;
                    } else {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq5)).setText("  " + (value / 100) + "." + (value % 100) + " mhz");
                        break;
                    }
                case 53:
                    if (HcFordExplorerRadio.this.unit == 1) {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("  " + value + " khz");
                        break;
                    } else {
                        ((TextView) HcFordExplorerRadio.this.findViewById(R.id.dj_lexus_radio_freq6)).setText("  " + (value / 100) + "." + (value % 100) + " mhz");
                        break;
                    }
            }
        }
    };
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerRadio.2
        @Override // java.lang.Runnable
        public void run() {
            HcFordExplorerRadio.this.num++;
            if (HcFordExplorerRadio.this.num == 3 && HcFordExplorerRadio.this.curnum != 0) {
                HcFordExplorerRadio.this.mSetCurFrq(HcFordExplorerRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(HcFordExplorerRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(HcFordExplorerRadio.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
            setContentView(R.layout.layout_djlexus_carradio);
        } else if (LauncherApplication.getConfiguration() == 1) {
            setContentView(R.layout.layout_djlexus_carradio_7731);
        } else {
            setContentView(R.layout.layout_djlexus_carradio);
        }
        init();
    }

    public void init() {
        mInit = this;
        findViewById(R.id.btn_lexus_radio_frq1).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq2).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq3).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq4).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq5).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_radio_frq6).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_scan_plus).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_scan_minu).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_prev).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_next).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_fm).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_am).setOnTouchListener(this);
        findViewById(R.id.lexus_radio_toaudio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerRadio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(HcFordExplorerRadio.this, HcFordExplorerAudio.class);
                    HcFordExplorerRadio.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[45];
        switch (value) {
            case 1:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 3:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 5:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM-AST");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
        }
    }

    public void updateRadioChannel() {
        int value = DataCanbus.DATA[47];
        findViewById(R.id.btn_lexus_radio_frq1).setBackgroundResource(R.drawable.ic_lexus_radio_freq_n);
        findViewById(R.id.btn_lexus_radio_frq2).setBackgroundResource(R.drawable.ic_lexus_radio_freq_n);
        findViewById(R.id.btn_lexus_radio_frq3).setBackgroundResource(R.drawable.ic_lexus_radio_freq_n);
        findViewById(R.id.btn_lexus_radio_frq4).setBackgroundResource(R.drawable.ic_lexus_radio_freq_n);
        findViewById(R.id.btn_lexus_radio_frq5).setBackgroundResource(R.drawable.ic_lexus_radio_freq_n);
        findViewById(R.id.btn_lexus_radio_frq6).setBackgroundResource(R.drawable.ic_lexus_radio_freq_n);
        switch (value) {
            case 1:
                findViewById(R.id.btn_lexus_radio_frq1).setBackgroundResource(R.drawable.ic_lexus_radio_freq_p);
                break;
            case 2:
                findViewById(R.id.btn_lexus_radio_frq2).setBackgroundResource(R.drawable.ic_lexus_radio_freq_p);
                break;
            case 3:
                findViewById(R.id.btn_lexus_radio_frq3).setBackgroundResource(R.drawable.ic_lexus_radio_freq_p);
                break;
            case 4:
                findViewById(R.id.btn_lexus_radio_frq4).setBackgroundResource(R.drawable.ic_lexus_radio_freq_p);
                break;
            case 5:
                findViewById(R.id.btn_lexus_radio_frq5).setBackgroundResource(R.drawable.ic_lexus_radio_freq_p);
                break;
            case 6:
                findViewById(R.id.btn_lexus_radio_frq6).setBackgroundResource(R.drawable.ic_lexus_radio_freq_p);
                break;
        }
    }

    private void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
            this.num = 0;
            this.flag = false;
            return;
        }
        HandlerUI.getInstance().removeCallbacks(this.mCalTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mSetCurFrq(int value) {
        this.flag = true;
        DataCanbus.PROXY.cmd(2, new int[]{11, value}, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_radio_prev /* 2131427850 */:
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
                case R.id.lexus_radio_next /* 2131427851 */:
                    DataCanbus.PROXY.cmd(2, new int[]{3, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_plus /* 2131427853 */:
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                    break;
                case R.id.lexus_radio_scan_minu /* 2131427854 */:
                    DataCanbus.PROXY.cmd(2, new int[]{2, 1}, null, null);
                    break;
                case R.id.lexus_radio_fm /* 2131427855 */:
                    int value = DataCanbus.DATA[45];
                    switch (value) {
                        case 1:
                        case 2:
                            DataCanbus.PROXY.cmd(2, new int[]{5, 2}, null, null);
                            break;
                        case 3:
                            DataCanbus.PROXY.cmd(2, new int[]{6, 4}, null, null);
                            break;
                        case 4:
                            DataCanbus.PROXY.cmd(2, new int[]{6, 5}, null, null);
                            break;
                        case 5:
                            DataCanbus.PROXY.cmd(2, new int[]{6, 3}, null, null);
                            break;
                    }
                case R.id.lexus_radio_am /* 2131427856 */:
                    int value2 = DataCanbus.DATA[45];
                    switch (value2) {
                        case 1:
                            DataCanbus.PROXY.cmd(2, new int[]{6, 2}, null, null);
                            break;
                        case 2:
                            DataCanbus.PROXY.cmd(2, new int[]{6, 1}, null, null);
                            break;
                        case 3:
                        case 4:
                        case 5:
                            DataCanbus.PROXY.cmd(2, new int[]{5, 1}, null, null);
                            break;
                    }
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    this.curnum = 3;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    this.curnum = 4;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    this.curnum = 5;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    this.curnum = 6;
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_lexus_radio_frq1 /* 2131427858 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 1}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq2 /* 2131427860 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 2}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq3 /* 2131427862 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 3}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq4 /* 2131427864 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 4}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq5 /* 2131427866 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 5}, null, null);
                        break;
                    }
                case R.id.btn_lexus_radio_frq6 /* 2131427868 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        DataCanbus.PROXY.cmd(2, new int[]{12, 6}, null, null);
                        break;
                    }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        if (DataCanbus.DATA[62] != 1) {
            DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
        }
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            DataCanbus.PROXY.cmd(2, new int[1], null, null);
            finish();
        }
        return true;
    }
}