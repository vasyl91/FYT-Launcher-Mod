package com.syu.carinfo.camry2012.xp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0112_RZC_XP1_Carmy;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class ToyotaLexusActivityCarRadio extends Activity implements View.OnTouchListener {
    public static ToyotaLexusActivityCarRadio mInst;
    public static boolean mIsFront = false;
    public static boolean mIsInit = false;
    public static int Current_Band = 0;
    public static int Current_preset_station = 1;
    public static final String[] mPointerFreqs = new String[7];
    public static final int[] mOffsets = new int[7];
    public Button[] mFmRadio = new Button[6];
    private final int[] FREQ_PRE = {0, 8750, 9010, 9810, 10610, 10800, 8750};
    int num = 0;
    int curnum = 0;
    Runnable mCalTime = new Runnable() { 
        @Override
        public void run() {
            ToyotaLexusActivityCarRadio.this.num++;
            if (ToyotaLexusActivityCarRadio.this.num == 3 && ToyotaLexusActivityCarRadio.this.curnum != 0) {
                ToyotaLexusActivityCarRadio.this.mSetCurFrq(ToyotaLexusActivityCarRadio.this.curnum);
            }
            HandlerUI.getInstance().removeCallbacks(ToyotaLexusActivityCarRadio.this.mCalTime);
            HandlerUI.getInstance().postDelayed(ToyotaLexusActivityCarRadio.this.mCalTime, 1000L);
        }
    };
    boolean flag = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 191:
                    ToyotaLexusActivityCarRadio.this.mUpdaterRadioCurChannel();
                    break;
                case 192:
                    ToyotaLexusActivityCarRadio.this.mUpdaterRadioCurFreq();
                    break;
                case 193:
                    ToyotaLexusActivityCarRadio.this.mUpdaterRadioCurrentChannelPreset();
                    break;
                case 194:
                    ToyotaLexusActivityCarRadio.this.updateRadioState();
                    break;
                case 195:
                    ToyotaLexusActivityCarRadio.this.mUpdaterRadioChannelPreset();
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
        Callback_0112_RZC_XP1_Carmy.CHANNEL_FREQ_PRESET = this.FREQ_PRE;
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
        DataCanbus.PROXY.cmd(45, 3, value);
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
                            DataCanbus.PROXY.cmd(45, 5, 1);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(45, 4, 1);
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
                            DataCanbus.PROXY.cmd(45, 5, 2);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(45, 4, 2);
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
                            DataCanbus.PROXY.cmd(45, 5, 3);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(45, 4, 3);
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
                            DataCanbus.PROXY.cmd(45, 5, 4);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(45, 4, 4);
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
                            DataCanbus.PROXY.cmd(45, 5, 5);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(45, 4, 5);
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
                            DataCanbus.PROXY.cmd(45, 5, 6);
                            break;
                        } else {
                            DataCanbus.PROXY.cmd(45, 4, 6);
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
        ((Button) findViewById(R.id.freqm)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(46, 9, 1);
                DataCanbus.PROXY.cmd(46, 9, 0);
            }
        });
        ((Button) findViewById(R.id.freqp)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(46, 8, 1);
                DataCanbus.PROXY.cmd(46, 8, 0);
            }
        });
        ((Button) findViewById(R.id.btn_band)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (ToyotaLexusActivityCarRadio.Current_Band == 1) {
                    DataCanbus.PROXY.cmd(46, 6, 1);
                    DataCanbus.PROXY.cmd(46, 6, 0);
                } else if (ToyotaLexusActivityCarRadio.Current_Band == 2) {
                    DataCanbus.PROXY.cmd(46, 4, 1);
                    DataCanbus.PROXY.cmd(46, 4, 0);
                } else {
                    DataCanbus.PROXY.cmd(46, 5, 1);
                    DataCanbus.PROXY.cmd(46, 5, 0);
                }
            }
        });
        ((Button) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(45, 3, ToyotaLexusActivityCarRadio.Current_preset_station);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        FuncMain.setChannel(11);
        if (DataCanbus.DATA[181] != 129) {
            DataCanbus.PROXY.cmd(46, 5, 1);
            DataCanbus.PROXY.cmd(46, 5, 0);
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
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterRadioCurChannel() {
        int value = DataCanbus.DATA[191];
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
        if (((TextView) findViewById(R.id.tv_radio_state)) != null) {
            int i = DataCanbus.DATA[194];
            ((TextView) findViewById(R.id.tv_radio_state)).setText("");
        }
    }

    
    public void mUpdaterRadioCurFreq() {
        int value = DataCanbus.DATA[192];
        if (value == 0) {
            value = 8750;
        }
        if (Current_Band == 17 || Current_Band == 16) {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder().append(value).toString());
        } else {
            ((TextView) findViewById(R.id.freq)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10));
        }
    }

    
    public void mUpdaterRadioChannelPreset() {
        if (Current_Band == 17 || Current_Band == 16) {
            for (int i = 0; i < 6; i++) {
                this.mFmRadio[i].setText(new StringBuilder().append(Callback_0112_RZC_XP1_Carmy.CHANNEL_FREQ_PRESET[i + 1]).toString());
            }
            return;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            this.mFmRadio[i2].setText(String.valueOf(Callback_0112_RZC_XP1_Carmy.CHANNEL_FREQ_PRESET[i2 + 1] / 100) + "." + ((Callback_0112_RZC_XP1_Carmy.CHANNEL_FREQ_PRESET[i2 + 1] % 100) / 10) + (Callback_0112_RZC_XP1_Carmy.CHANNEL_FREQ_PRESET[i2 + 1] % 10));
        }
    }

    
    public void mUpdaterRadioCurrentChannelPreset() {
        int value = DataCanbus.DATA[193];
        this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.bk_button);
        if (value >= 1 && value <= 6) {
            Current_preset_station = DataCanbus.DATA[193];
        }
        if (Current_preset_station >= 1 && Current_preset_station <= 6) {
            this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.ic_btn_sp);
        }
    }
}
