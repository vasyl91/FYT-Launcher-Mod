package com.syu.carinfo.focus.yl;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0347_YingLong_Ruijie;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityRadio extends Activity implements DialogInterface.OnClickListener, View.OnLongClickListener {
    public static ActivityRadio mInst;
    public static ActivityRadio mInstance;
    public static TextView mTvCurrfreq;
    public RadioRuler mRuler;
    public static boolean mIsFront = false;
    public static boolean mIsInit = false;
    public static int Current_Band = 0;
    public static int Current_preset_station = 1;
    public static int Seek_down = 0;
    public static int mFreqStep = 50;
    public static int mFreqMin = 8750;
    public static int mFreqMax = 10800;
    public static final String[] mPointerFreqs = new String[7];
    public static final int[] mOffsets = new int[7];
    public Button[] mFmRadio = new Button[10];
    private final int[] FREQ_PRE = {87500, 90100, 98100, 106100, 108000, 87500, 87500, 87500, 87500, 87500};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 22:
                    ActivityRadio.this.mUpdaterRadioCurChannel();
                    break;
                case 23:
                    ActivityRadio.this.mUpdaterRadioCurFreq();
                    break;
                case 27:
                    ActivityRadio.this.mUpdaterRadioCurrentChannelPreset();
                    break;
                case 28:
                    ActivityRadio.this.mUpdaterRadioChannelPreset();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_radio);
        mInstance = this;
        mInst = this;
        createUI();
        setUI();
        setListener();
        Callback_0347_YingLong_Ruijie.freq = this.FREQ_PRE;
        mIsInit = true;
    }

    private void createUI() {
        this.mRuler = (RadioRuler) findViewById(R.id.ruler);
        mTvCurrfreq = (TextView) findViewById(R.id.freq);
        this.mFmRadio[0] = (Button) findViewById(R.id.btn_am_radio0);
        this.mFmRadio[1] = (Button) findViewById(R.id.btn_am_radio1);
        this.mFmRadio[2] = (Button) findViewById(R.id.btn_am_radio2);
        this.mFmRadio[3] = (Button) findViewById(R.id.btn_am_radio3);
        this.mFmRadio[4] = (Button) findViewById(R.id.btn_am_radio4);
        this.mFmRadio[5] = (Button) findViewById(R.id.btn_am_radio5);
        this.mFmRadio[6] = (Button) findViewById(R.id.btn_am_radio6);
        this.mFmRadio[7] = (Button) findViewById(R.id.btn_am_radio7);
        this.mFmRadio[8] = (Button) findViewById(R.id.btn_am_radio8);
        this.mFmRadio[9] = (Button) findViewById(R.id.btn_am_radio9);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        return true;
     */
    @Override // android.view.View.OnLongClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onLongClick(android.view.View r7) {
        /*
            r6 = this;
            r5 = 18
            r4 = 3
            r3 = 1
            int r0 = r7.getId()
            switch(r0) {
                case 2131430079: goto Lc;
                case 2131430080: goto L16;
                case 2131432413: goto Lb;
                case 2131432416: goto Lb;
                default: goto Lb;
            }
        Lb:
            return r3
        Lc:
            com.syu.carinfo.focus.yl.ActivityRadio.Seek_down = r3
            com.syu.ipc.RemoteModuleProxy r1 = com.syu.module.canbus.DataCanbus.PROXY
            r2 = 11
            r1.cmd(r4, r5, r2)
            goto Lb
        L16:
            r1 = -1
            com.syu.carinfo.focus.yl.ActivityRadio.Seek_down = r1
            com.syu.ipc.RemoteModuleProxy r1 = com.syu.module.canbus.DataCanbus.PROXY
            r2 = 9
            r1.cmd(r4, r5, r2)
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.focus.yl.ActivityRadio.onLongClick(android.view.View):boolean");
    }

    private void setUI() {
    }

    private void setListener() {
        for (int i = 0; i < 10; i++) {
            final int button_id = i;
            this.mFmRadio[i].setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (ActivityRadio.Current_Band == 0) {
                        DataCanbus.PROXY.cmd(3, 18, button_id + 17);
                        return;
                    }
                    if (ActivityRadio.Current_Band == 1) {
                        DataCanbus.PROXY.cmd(3, 18, button_id + 33);
                    } else if (ActivityRadio.Current_Band == 2) {
                        DataCanbus.PROXY.cmd(3, 18, button_id + 49);
                    } else if (ActivityRadio.Current_Band == 3) {
                        DataCanbus.PROXY.cmd(3, 18, button_id + 65);
                    }
                }
            });
        }
        findViewById(R.id.freqm).setOnLongClickListener(this);
        findViewById(R.id.freqp).setOnLongClickListener(this);
        findViewById(R.id.btn_skipb).setOnLongClickListener(this);
        findViewById(R.id.btn_skipf).setOnLongClickListener(this);
        ((ViewGroup) findViewById(R.id.all_ground)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ActivityRadio.Seek_down == 1) {
                    DataCanbus.PROXY.cmd(3, 18, 12);
                } else {
                    DataCanbus.PROXY.cmd(3, 18, 10);
                }
            }
        });
        ((Button) findViewById(R.id.freqm)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, 18, 3);
            }
        });
        ((Button) findViewById(R.id.freqp)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, 18, 2);
            }
        });
        ((Button) findViewById(R.id.btn_skipb)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ActivityRadio.Current_Band == 0) {
                    if (ActivityRadio.Current_preset_station == 1) {
                        DataCanbus.PROXY.cmd(3, 18, 272);
                        return;
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, (ActivityRadio.Current_preset_station + 17) - 2);
                        return;
                    }
                }
                if (ActivityRadio.Current_Band == 1) {
                    if (ActivityRadio.Current_preset_station == 1) {
                        DataCanbus.PROXY.cmd(3, 18, 528);
                        return;
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, (ActivityRadio.Current_preset_station + 33) - 2);
                        return;
                    }
                }
                if (ActivityRadio.Current_Band == 2) {
                    if (ActivityRadio.Current_preset_station == 1) {
                        DataCanbus.PROXY.cmd(3, 18, 784);
                        return;
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, (ActivityRadio.Current_preset_station + 49) - 2);
                        return;
                    }
                }
                if (ActivityRadio.Current_Band == 3) {
                    if (ActivityRadio.Current_preset_station == 1) {
                        DataCanbus.PROXY.cmd(3, 18, 1040);
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, (ActivityRadio.Current_preset_station + 65) - 2);
                    }
                }
            }
        });
        ((Button) findViewById(R.id.btn_band)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[22];
                int switchOn = value + 6;
                if (switchOn == 9) {
                    switchOn = 5;
                }
                DataCanbus.PROXY.cmd(3, 18, switchOn);
            }
        });
        ((Button) findViewById(R.id.scan)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, 18, 4);
            }
        });
        ((Button) findViewById(R.id.btn_save)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        ((Button) findViewById(R.id.list)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
        ((Button) findViewById(R.id.btn_skipf)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.focus.yl.ActivityRadio.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ActivityRadio.Current_Band == 0) {
                    if (ActivityRadio.Current_preset_station == 10) {
                        DataCanbus.PROXY.cmd(3, 18, 17);
                        return;
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, ActivityRadio.Current_preset_station + 17);
                        return;
                    }
                }
                if (ActivityRadio.Current_Band == 1) {
                    if (ActivityRadio.Current_preset_station == 10) {
                        DataCanbus.PROXY.cmd(3, 18, 33);
                        return;
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, ActivityRadio.Current_preset_station + 33);
                        return;
                    }
                }
                if (ActivityRadio.Current_Band == 2) {
                    if (ActivityRadio.Current_preset_station == 10) {
                        DataCanbus.PROXY.cmd(3, 18, 49);
                        return;
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, ActivityRadio.Current_preset_station + 49);
                        return;
                    }
                }
                if (ActivityRadio.Current_Band == 3) {
                    if (ActivityRadio.Current_preset_station == 10) {
                        DataCanbus.PROXY.cmd(3, 18, 65);
                    } else {
                        DataCanbus.PROXY.cmd(3, 18, ActivityRadio.Current_preset_station + 65);
                    }
                }
            }
        });
        this.mRuler.setCallback(RadioRuler.mRulerListener);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(3, 18, 1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mInst = null;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurChannel() {
        int value = DataCanbus.DATA[22];
        if (value == 0 || value == 1) {
            mFreqMin = 8750;
            mFreqMax = 10800;
            mFreqStep = 50;
        } else {
            mFreqMin = ConstRzcAddData.U_CAR_TEMP_WATER;
            mFreqMax = 1620;
            mFreqStep = 9;
        }
        rulerNum();
        if (value == 0 || value == 1) {
            ((TextView) findViewById(R.id.channel)).setText("FM" + (value + 1));
            ((TextView) findViewById(R.id.band)).setText("MHZ");
        } else if (value == 2 || value == 3) {
            ((TextView) findViewById(R.id.channel)).setText("AM" + (value - 1));
            ((TextView) findViewById(R.id.band)).setText("KHZ");
        }
        Current_Band = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurFreq() {
        int value = DataCanbus.DATA[23];
        if (value == 0) {
            value = 87500;
        }
        if (Current_Band == 2 || Current_Band == 3) {
            ((TextView) findViewById(R.id.freq)).setText(new StringBuilder().append(value).toString());
            mInst.mRuler.setTargetMarkAnim(value, mFreqMin, mFreqMax);
        } else {
            ((TextView) findViewById(R.id.freq)).setText(String.format("%d.%02d", Integer.valueOf(value / 1000), Integer.valueOf((value % 1000) / 10)));
            mInst.mRuler.setTargetMarkAnim(value / 10, mFreqMin, mFreqMax);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioChannelPreset() {
        if (Current_Band == 2 || Current_Band == 3) {
            for (int i = 0; i < 10; i++) {
                this.mFmRadio[i].setText(new StringBuilder().append(Callback_0347_YingLong_Ruijie.freq[i]).toString());
            }
            return;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            this.mFmRadio[i2].setText(String.format("%d.%02d", Integer.valueOf(Callback_0347_YingLong_Ruijie.freq[i2] / 1000), Integer.valueOf((Callback_0347_YingLong_Ruijie.freq[i2] % 1000) / 10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadioCurrentChannelPreset() {
        int value = DataCanbus.DATA[27];
        this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.bk_button);
        if (value >= 1 && value <= 10) {
            Current_preset_station = DataCanbus.DATA[27];
        }
        if (Current_preset_station >= 1) {
            this.mFmRadio[Current_preset_station - 1].setBackgroundResource(R.drawable.ic_btn_sp);
        }
    }

    public void rulerNum() {
        if (mFreqMax > 0 && mFreqMin > 0 && mFreqStep > 0 && mFreqMax > mFreqMin) {
            int total = mFreqMax - mFreqMin;
            for (int j = 0; j < 7; j++) {
                int freq = mFreqMin + ((((mFreqMin + ((total * j) / 6)) - mFreqMin) / mFreqStep) * mFreqStep);
                if (freq > 5000) {
                    mPointerFreqs[j] = String.format("%d.%d%d", Integer.valueOf(freq / 100), Integer.valueOf((freq % 100) / 10), Integer.valueOf(freq % 10));
                } else {
                    if ((freq < 5000) & (freq > 400)) {
                        mPointerFreqs[j] = String.format("%d", Integer.valueOf(freq));
                    }
                }
            }
            for (int i = 0; i < 7; i++) {
                mOffsets[i] = RadioRuler.STARTPOINT + (RadioRuler.ERACHROAD * i);
            }
            mInst.mRuler.updateFreqNumber(true, mPointerFreqs, mOffsets);
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int which) {
    }
}
