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

@SuppressWarnings({"deprecation", "unchecked"})
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
    Runnable mCalTime = new Runnable() { 
        @Override
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
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_429_carradio);
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

    
    public void mSetCurFrq(int value) {
        this.flag = true;
        DataCanbus.PROXY.cmd(0, 3, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_am_radio0 /* 2131430039 */:
                    this.curnum = 1;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio1 /* 2131430040 */:
                    this.curnum = 2;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio2 /* 2131430041 */:
                    this.curnum = 3;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio3 /* 2131430042 */:
                    this.curnum = 4;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio4 /* 2131430043 */:
                    this.curnum = 5;
                    mUpdatermCalTime(true);
                    break;
                case R.id.btn_am_radio5 /* 2131430044 */:
                    this.curnum = 6;
                    mUpdatermCalTime(true);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_am_radio0 /* 2131430039 */:
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
                case R.id.btn_am_radio1 /* 2131430040 */:
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
                case R.id.btn_am_radio2 /* 2131430041 */:
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
                case R.id.btn_am_radio3 /* 2131430042 */:
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
                case R.id.btn_am_radio4 /* 2131430043 */:
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
                case R.id.btn_am_radio5 /* 2131430044 */:
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
        this.mFmRadio[0] = findViewById(R.id.btn_am_radio0);
        this.mFmRadio[1] = findViewById(R.id.btn_am_radio1);
        this.mFmRadio[2] = findViewById(R.id.btn_am_radio2);
        this.mFmRadio[3] = findViewById(R.id.btn_am_radio3);
        this.mFmRadio[4] = findViewById(R.id.btn_am_radio4);
        this.mFmRadio[5] = findViewById(R.id.btn_am_radio5);
    }

    private void setListener() {
        findViewById(R.id.btn_am_radio0).setOnTouchListener(this);
        findViewById(R.id.btn_am_radio1).setOnTouchListener(this);
        findViewById(R.id.btn_am_radio2).setOnTouchListener(this);
        findViewById(R.id.btn_am_radio3).setOnTouchListener(this);
        findViewById(R.id.btn_am_radio4).setOnTouchListener(this);
        findViewById(R.id.btn_am_radio5).setOnTouchListener(this);
        findViewById(R.id.freqm).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, 9, 1);
                DataCanbus.PROXY.cmd(2, 9, 0);
            }
        });
        findViewById(R.id.freqp).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, 8, 1);
                DataCanbus.PROXY.cmd(2, 8, 0);
            }
        });
        findViewById(R.id.btn_band).setOnClickListener(new View.OnClickListener() { 
            @Override
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
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(0, 3, ActivityCarRadio.Current_preset_station);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(1, 16);
        FuncMain.setChannel(11);
        if (DataCanbus.DATA[1000] != 590253 && DataCanbus.DATA[1000] != 655789 && DataCanbus.DATA[1000] != 721325 && DataCanbus.DATA[1000] != 786861 && DataCanbus.DATA[1000] != 852397 && DataCanbus.DATA[1000] != 917933 && DataCanbus.DATA[1000] != 983469 && DataCanbus.DATA[98] != 1) {
            DataCanbus.PROXY.cmd(2, 5, 1);
            DataCanbus.PROXY.cmd(2, 5, 0);
        }
        mIsFront = true;
    }

    @Override
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

    
    public void mUpdaterRadioCurChannel() {
        int value = DataCanbus.DATA[99];
        if (value == 1 || value == 2) {
            ((TextView) findViewById(R.id.channel)).setText("FM" + (value == 1 ? "" : "2"));
            ((TextView) findViewById(R.id.band)).setText("MHZ");
        } else if (value == 17 || value == 16) {
            ((TextView) findViewById(R.id.channel)).setText("AM");
            ((TextView) findViewById(R.id.band)).setText("KHZ");
        }
        Current_Band = value;
    }

    
    public void updateRadioState() {
        if (findViewById(R.id.tv_radio_state) != null) {
            int i = DataCanbus.DATA[102];
            ((TextView) findViewById(R.id.tv_radio_state)).setText("");
        }
    }

    
    public void mUpdaterRadioCurFreq() {
        int value = DataCanbus.DATA[100];
        if (value == 0) {
            value = 8750;
        }
        if (Current_Band == 17 || Current_Band == 16) {
            ((TextView) findViewById(R.id.freq)).setText(String.valueOf(value));
        } else if (DataCanbus.DATA[1000] == 6947255 || DataCanbus.DATA[1000] == 1245636) {
            ((TextView) findViewById(R.id.freq)).setText(String.valueOf(value / 100.0f));
        } else {
            ((TextView) findViewById(R.id.freq)).setText(String.valueOf(value / 10.0f));
        }
    }

    
    public void mUpdaterRadioChannelPreset() {
        if (Current_Band == 17 || Current_Band == 16) {
            for (int i = 0; i < 6; i++) {
                this.mFmRadio[i].setText(String.valueOf(Callback_0429_DJ_XP1_TOYOTA_12Crown.CHANNEL_FREQ_PRESET[i + 1]));
            }
            return;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            if (DataCanbus.DATA[1000] == 6947255 || DataCanbus.DATA[1000] == 1245636) {
                this.mFmRadio[i2].setText(String.valueOf(Callback_0439_RZC_TOYOTA_HuangGuan.CHANNEL_FREQ_PRESET[i2 + 1] / 100.0f));
            } else {
                this.mFmRadio[i2].setText(String.valueOf(Callback_0429_DJ_XP1_TOYOTA_12Crown.CHANNEL_FREQ_PRESET[i2 + 1] / 10.0f));
            }
        }
    }

    
    public void mUpdaterRadioCurrentChannelPreset() {
        int value = DataCanbus.DATA[101];
        this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.bk_button);
        if (value >= 1 && value <= 6) {
            Current_preset_station = DataCanbus.DATA[101];
        }
        if (Current_preset_station >= 1 && Current_preset_station <= 6) {
            this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.ic_btn_sp);
        }
    }
}
