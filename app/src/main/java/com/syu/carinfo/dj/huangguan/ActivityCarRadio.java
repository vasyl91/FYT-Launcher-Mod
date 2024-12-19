package com.syu.carinfo.dj.huangguan;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0429_DJ_XP1_TOYOTA_12Crown;
import com.syu.module.canbus.Callback_0439_RZC_TOYOTA_HuangGuan;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityCarRadio extends Activity implements View.OnTouchListener {
    public static ActivityCarRadio mInst;
    public static boolean mIsFront = false;
    public static boolean mIsInit = false;
    public static int Current_Band = 0;
    public static int Current_preset_station = 1;
    public static final String[] mPointerFreqs = new String[7];
    public static final int[] mOffsets = new int[7];
    public Button[] mFmRadio = new Button[6];
    private final int[] FREQ_PRE = {0, 875, 901, 981, 1061, 1080, 875};
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { // from class: com.syu.carinfo.dj.huangguan.ActivityCarRadio.1
        @Override // java.lang.Runnable
        public void run() {
            ActivityCarRadio.this.num++;
            if (ActivityCarRadio.this.num == 3 && ActivityCarRadio.this.curnum != 0) {
                ActivityCarRadio.this.mSetCurFrq(ActivityCarRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(ActivityCarRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(ActivityCarRadio.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.huangguan.ActivityCarRadio.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 51:
                    ActivityCarRadio.this.mUpdaterRadioCurChannel();
                    break;
                case 52:
                    ActivityCarRadio.this.mUpdaterRadioCurFreq();
                    break;
                case 53:
                    ActivityCarRadio.this.mUpdaterRadioCurrentChannelPreset();
                    break;
                case 54:
                    ActivityCarRadio.this.updateRadioState();
                    break;
                case 55:
                    ActivityCarRadio.this.mUpdaterRadioChannelPreset();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_429_carradio);
        mInst = this;
        createUI();
        setListener();
        Callback_0429_DJ_XP1_TOYOTA_12Crown.CHANNEL_FREQ_PRESET = this.FREQ_PRE;
        Callback_0439_RZC_TOYOTA_HuangGuan.CHANNEL_FREQ_PRESET = this.FREQ_PRE;
        mIsInit = true;
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
        DataCanbus.PROXY.cmd(0, 3, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_am_radio0 /* 2131430083 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio1 /* 2131430084 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio2 /* 2131430085 */:
                    this.curnum = 3;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio3 /* 2131430086 */:
                    this.curnum = 4;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio4 /* 2131430087 */:
                    this.curnum = 5;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio5 /* 2131430088 */:
                    this.curnum = 6;
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_am_radio0 /* 2131430083 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (Current_Band == 1 || Current_Band == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 1);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 1);
                            break;
                        }
                    }
                    break;
                case R.id.btn_am_radio1 /* 2131430084 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (Current_Band == 1 || Current_Band == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 2);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 2);
                            break;
                        }
                    }
                    break;
                case R.id.btn_am_radio2 /* 2131430085 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (Current_Band == 1 || Current_Band == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 3);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 3);
                            break;
                        }
                    }
                    break;
                case R.id.btn_am_radio3 /* 2131430086 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (Current_Band == 1 || Current_Band == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 4);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 4);
                            break;
                        }
                    }
                    break;
                case R.id.btn_am_radio4 /* 2131430087 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (Current_Band == 1 || Current_Band == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 5);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 5);
                            break;
                        }
                    }
                    break;
                case R.id.btn_am_radio5 /* 2131430088 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (Current_Band == 1 || Current_Band == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 6);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 6);
                            break;
                        }
                    }
                    break;
            }
        }
        return false;
    }

    private void createUI() {
        this.mFmRadio[0] = (Button) findViewById(R.id.btn_am_radio0);
        this.mFmRadio[1] = (Button) findViewById(R.id.btn_am_radio1);
        this.mFmRadio[2] = (Button) findViewById(R.id.btn_am_radio2);
        this.mFmRadio[3] = (Button) findViewById(R.id.btn_am_radio3);
        this.mFmRadio[4] = (Button) findViewById(R.id.btn_am_radio4);
        this.mFmRadio[5] = (Button) findViewById(R.id.btn_am_radio5);
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_am_radio0)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_am_radio1)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_am_radio2)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_am_radio3)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_am_radio4)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_am_radio5)).setOnTouchListener(this);
        ((Button) findViewById(R.id.freqm)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.ActivityCarRadio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, 9, 1);
                DataCanbus.PROXY.cmd(2, 9, 0);
            }
        });
        ((Button) findViewById(R.id.freqp)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.ActivityCarRadio.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, 8, 1);
                DataCanbus.PROXY.cmd(2, 8, 0);
            }
        });
        ((Button) findViewById(R.id.btn_band)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.ActivityCarRadio.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ActivityCarRadio.Current_Band == 1) {
                    DataCanbus.PROXY.cmd(2, 5, 1);
                    DataCanbus.PROXY.cmd(2, 5, 0);
                } else if (ActivityCarRadio.Current_Band == 2) {
                    DataCanbus.PROXY.cmd(2, 4, 1);
                    DataCanbus.PROXY.cmd(2, 4, 0);
                } else {
                    DataCanbus.PROXY.cmd(2, 5, 1);
                    DataCanbus.PROXY.cmd(2, 5, 0);
                }
            }
        });
        ((Button) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.huangguan.ActivityCarRadio.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 3, ActivityCarRadio.Current_preset_station);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(1, 16);
        FuncMain.setChannel(11);
        if (DataCanbus.DATA[1000] != 590253 && DataCanbus.DATA[1000] != 655789 && DataCanbus.DATA[1000] != 721325 && DataCanbus.DATA[1000] != 786861 && DataCanbus.DATA[1000] != 852397 && DataCanbus.DATA[1000] != 917933 && DataCanbus.DATA[1000] != 983469 && DataCanbus.DATA[50] != 1) {
            DataCanbus.PROXY.cmd(2, 5, 1);
            DataCanbus.PROXY.cmd(2, 5, 0);
        }
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurChannel() {
        int value = DataCanbus.DATA[51];
        if (value == 1 || value == 2) {
            ((TextView) findViewById(R.id.channel)).setText("FM" + (value == 1 ? "" : "2"));
            ((TextView) findViewById(R.id.band)).setText("MHZ");
        } else if (value == 17 || value == 16) {
            ((TextView) findViewById(R.id.channel)).setText("AM");
            ((TextView) findViewById(R.id.band)).setText("KHZ");
        }
        Current_Band = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioState() {
        if (((TextView) findViewById(R.id.tv_radio_state)) != null) {
            int i = DataCanbus.DATA[54];
            ((TextView) findViewById(R.id.tv_radio_state)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurFreq() {
        int value = DataCanbus.DATA[52];
        if (value == 0) {
            value = 8750;
        }
        if (Current_Band == 17 || Current_Band == 16) {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder().append(value).toString());
        } else if (DataCanbus.DATA[1000] == 6947255 || DataCanbus.DATA[1000] == 1245636) {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder(String.valueOf(value / 100.0f)).toString());
        } else {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder(String.valueOf(value / 10.0f)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioChannelPreset() {
        if (Current_Band == 17 || Current_Band == 16) {
            for (int i = 0; i < 6; i++) {
                this.mFmRadio[i].setText(new StringBuilder().append(Callback_0429_DJ_XP1_TOYOTA_12Crown.CHANNEL_FREQ_PRESET[i + 1]).toString());
            }
            return;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            if (DataCanbus.DATA[1000] == 6947255 || DataCanbus.DATA[1000] == 1245636) {
                this.mFmRadio[i2].setText(new StringBuilder(String.valueOf(Callback_0439_RZC_TOYOTA_HuangGuan.CHANNEL_FREQ_PRESET[i2 + 1] / 100.0f)).toString());
            } else {
                this.mFmRadio[i2].setText(new StringBuilder(String.valueOf(Callback_0429_DJ_XP1_TOYOTA_12Crown.CHANNEL_FREQ_PRESET[i2 + 1] / 10.0f)).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurrentChannelPreset() {
        int value = DataCanbus.DATA[53];
        this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.bk_button);
        if (value >= 1 && value <= 6) {
            Current_preset_station = DataCanbus.DATA[53];
        }
        if (Current_preset_station >= 1 && Current_preset_station <= 6) {
            this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.ic_btn_sp);
        }
    }
}
