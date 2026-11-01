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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityCarRadio extends Activity implements View.OnTouchListener {
    public static ActivityCarRadio mInst;
    public static boolean mIsFront = false;
    public static boolean mIsInit = false;
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
                case 99:
                    ActivityCarRadio.this.mUpdaterRadioCurChannel();
                    break;
                case 100:
                    ActivityCarRadio.this.mUpdaterRadioCurFreq();
                    break;
                case 101:
                    ActivityCarRadio.this.mUpdaterRadioCurrentChannelPreset();
                    break;
                case 102:
                    ActivityCarRadio.this.updateRadioState();
                    break;
                case 103:
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
                case R.id.btn_am_radio0 /* 2131429461 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio1 /* 2131429462 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio2 /* 2131429463 */:
                    this.curnum = 3;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio3 /* 2131429464 */:
                    this.curnum = 4;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio4 /* 2131429465 */:
                    this.curnum = 5;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio5 /* 2131429466 */:
                    this.curnum = 6;
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_am_radio0 /* 2131429461 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 1);
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 1);
                        }
                    }
                    break;
                case R.id.btn_am_radio1 /* 2131429462 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 2);
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 2);
                        }
                    }
                    break;
                case R.id.btn_am_radio2 /* 2131429463 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 3);
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 3);
                        }
                    }
                    break;
                case R.id.btn_am_radio3 /* 2131429464 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 4);
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 4);
                        }
                    }
                    break;
                case R.id.btn_am_radio4 /* 2131429465 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 5);
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 5);
                        }
                    }
                    break;
                case R.id.btn_am_radio5 /* 2131429466 */:
                    mUpdatermCalTime(false);
                    this.curnum = 0;
                    this.num = 0;
                    if (!this.flag) {
                        if (DataCanbus.DATA[99] == 1 || DataCanbus.DATA[99] == 2) {
                            DataCanbus.PROXY.cmd(0, 5, 6);
                        } else {
                            DataCanbus.PROXY.cmd(0, 4, 6);
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
                if (DataCanbus.DATA[99] == 1) {
                    DataCanbus.PROXY.cmd(2, 5, 1);
                    DataCanbus.PROXY.cmd(2, 5, 0);
                } else if (DataCanbus.DATA[99] == 2) {
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
                DataCanbus.PROXY.cmd(0, 3, DataCanbus.DATA[101]);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(1, 16);
        FuncMain.setChannel(11);
        if (DataCanbus.DATA[1000] != 590253 && DataCanbus.DATA[1000] != 655789 && DataCanbus.DATA[1000] != 721325 && DataCanbus.DATA[1000] != 786861 && DataCanbus.DATA[1000] != 852397 && DataCanbus.DATA[1000] != 1245613 && DataCanbus.DATA[1000] != 917933 && DataCanbus.DATA[1000] != 983469 && DataCanbus.DATA[98] != 1) {
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurChannel() {
        int value = DataCanbus.DATA[99];
        if (value == 1 || value == 2) {
            ((TextView) findViewById(R.id.channel)).setText("FM" + (value == 1 ? "" : "2"));
            ((TextView) findViewById(R.id.band)).setText("MHZ");
        } else if (value == 17 || value == 16) {
            ((TextView) findViewById(R.id.channel)).setText("AM");
            ((TextView) findViewById(R.id.band)).setText("KHZ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRadioState() {
        if (((TextView) findViewById(R.id.tv_radio_state)) != null) {
            int i = DataCanbus.DATA[102];
            ((TextView) findViewById(R.id.tv_radio_state)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurFreq() {
        int value = DataCanbus.DATA[100];
        if (value == 0) {
            value = 8750;
        }
        if (DataCanbus.DATA[99] == 17 || DataCanbus.DATA[99] == 16) {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder().append(value).toString());
        } else if (DataCanbus.DATA[1000] == 6947255 || DataCanbus.DATA[1000] == 1245636) {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder(String.valueOf(value / 100.0f)).toString());
        } else {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder(String.valueOf(value / 10.0f)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioChannelPreset() {
        if (DataCanbus.DATA[99] == 17 || DataCanbus.DATA[99] == 16) {
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
        int value = DataCanbus.DATA[101];
        if (value >= 1 && value <= 6) {
            this.mFmRadio[DataCanbus.DATA[101] - 1].setBackgroundResource(R.drawable.bk_button);
        }
        if (value >= 1 && value <= 6) {
            this.mFmRadio[DataCanbus.DATA[101] - 1].setBackgroundResource(R.drawable.ic_btn_sp);
        }
    }
}
