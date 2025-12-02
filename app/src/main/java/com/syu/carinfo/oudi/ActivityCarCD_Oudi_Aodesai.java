package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityCarCD_Oudi_Aodesai extends BaseActivity {
    int value;
    ImageView[] image = new ImageView[6];
    TextView[] textView = new TextView[6];
    private int[] eventIDs = {118, 119, 120, 121, 122};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            ActivityCarCD_Oudi_Aodesai.this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    ActivityCarCD_Oudi_Aodesai.this.uStateView(ActivityCarCD_Oudi_Aodesai.this.value);
                    break;
                case 119:
                    ActivityCarCD_Oudi_Aodesai.this.uRadioInfo(ActivityCarCD_Oudi_Aodesai.this.value);
                    break;
                case 120:
                    ActivityCarCD_Oudi_Aodesai.this.uCDInfo1(ActivityCarCD_Oudi_Aodesai.this.value);
                    break;
                case 121:
                    ActivityCarCD_Oudi_Aodesai.this.uCDInfo2(ActivityCarCD_Oudi_Aodesai.this.value);
                    break;
                case 122:
                    ActivityCarCD_Oudi_Aodesai.this.uCDVol(ActivityCarCD_Oudi_Aodesai.this.value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0203_oudi_08aodesai);
        init();
    }

    @Override
    public void init() {
        this.image[0] = (ImageView) findViewById(R.id.xuni_cd1_img);
        this.image[1] = (ImageView) findViewById(R.id.xuni_cd2_img);
        this.image[2] = (ImageView) findViewById(R.id.xuni_cd3_img);
        this.image[3] = (ImageView) findViewById(R.id.xuni_cd4_img);
        this.image[4] = (ImageView) findViewById(R.id.xuni_cd5_img);
        this.image[5] = (ImageView) findViewById(R.id.xuni_cd6_img);
        this.textView[0] = (TextView) findViewById(R.id.xuni_cd1_text);
        this.textView[1] = (TextView) findViewById(R.id.xuni_cd2_text);
        this.textView[2] = (TextView) findViewById(R.id.xuni_cd3_text);
        this.textView[3] = (TextView) findViewById(R.id.xuni_cd4_text);
        this.textView[4] = (TextView) findViewById(R.id.xuni_cd5_text);
        this.textView[5] = (TextView) findViewById(R.id.xuni_cd6_text);
        if (((Button) findViewById(R.id.jeep_btn_ff)) != null) {
            ((Button) findViewById(R.id.jeep_btn_ff)).setOnTouchListener(new View.OnTouchListener() { 
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
                
                    return false;
                 */
                @Override
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
                    /*
                        r4 = this;
                        r3 = 2
                        r2 = 0
                        r1 = 1
                        int r0 = r6.getAction()
                        switch(r0) {
                            case 0: goto Lb;
                            case 1: goto L11;
                            default: goto La;
                        }
                    La:
                        return r2
                    Lb:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r3, r1)
                        goto La
                    L11:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r3, r2)
                        goto La
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.oudi.ActivityCarCD_Oudi_Aodesai.AnonymousClass2.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        }
        if (((Button) findViewById(R.id.jeep_btn_fr)) != null) {
            ((Button) findViewById(R.id.jeep_btn_fr)).setOnTouchListener(new View.OnTouchListener() { 
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
                
                    return false;
                 */
                @Override
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
                    /*
                        r3 = this;
                        r2 = 0
                        r1 = 1
                        int r0 = r5.getAction()
                        switch(r0) {
                            case 0: goto La;
                            case 1: goto L10;
                            default: goto L9;
                        }
                    L9:
                        return r2
                    La:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r1, r1)
                        goto L9
                    L10:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r1, r2)
                        goto L9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.oudi.ActivityCarCD_Oudi_Aodesai.AnonymousClass3.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        }
        if (((Button) findViewById(R.id.jeep_btn_prev)) != null) {
            ((Button) findViewById(R.id.jeep_btn_prev)).setOnTouchListener(new View.OnTouchListener() { 
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
                
                    return false;
                 */
                @Override
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
                    /*
                        r4 = this;
                        r3 = 4
                        r2 = 0
                        r1 = 1
                        int r0 = r6.getAction()
                        switch(r0) {
                            case 0: goto Lb;
                            case 1: goto L11;
                            default: goto La;
                        }
                    La:
                        return r2
                    Lb:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r3, r1)
                        goto La
                    L11:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r3, r2)
                        goto La
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.oudi.ActivityCarCD_Oudi_Aodesai.AnonymousClass4.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        }
        if (((Button) findViewById(R.id.jeep_btn_next)) != null) {
            ((Button) findViewById(R.id.jeep_btn_next)).setOnTouchListener(new View.OnTouchListener() { 
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
                
                    return false;
                 */
                @Override
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
                    /*
                        r4 = this;
                        r3 = 3
                        r2 = 0
                        r1 = 1
                        int r0 = r6.getAction()
                        switch(r0) {
                            case 0: goto Lb;
                            case 1: goto L11;
                            default: goto La;
                        }
                    La:
                        return r2
                    Lb:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r3, r1)
                        goto La
                    L11:
                        com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                        r0.cmd(r1, r3, r2)
                        goto La
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.oudi.ActivityCarCD_Oudi_Aodesai.AnonymousClass5.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        for (int i : this.eventIDs) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.eventIDs) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    protected void uCDInfo2(int value) {
        int cdMin = value & 105;
        int cdSec = (value >> 8) & 255;
        int cdState = (value >> 16) & 255;
        String info = "";
        if (((TextView) findViewById(R.id.file_num_tv)) != null) {
            switch (cdState) {
                case 0:
                    info = "LOAD";
                    break;
                case 1:
                    info = "READ";
                    break;
                case 2:
                    info = "EJECT";
                    break;
                case 3:
                    info = "NO DISC";
                    break;
                case 4:
                    info = "CHECK DISC";
                    break;
                case 5:
                    info = "BUSY";
                    break;
                case 6:
                    info = "OK";
                    break;
            }
            ((TextView) findViewById(R.id.file_num_tv)).setText(info);
        }
        if (((TextView) findViewById(R.id.time_tv)) != null) {
            ((TextView) findViewById(R.id.time_tv)).setText(String.format("%02d:%02d", Integer.valueOf(cdMin), Integer.valueOf(cdSec)));
        }
    }

    protected void uCDVol(int value) {
        int show = (value >> 8) & 1;
        int volume = value & 255;
        setViewVisible(findViewById(R.id.tv_car_vol_view), show);
        if (((TextView) findViewById(R.id.tv_car_vol)) != null) {
            ((TextView) findViewById(R.id.tv_car_vol)).setText(new StringBuilder().append(volume).toString());
        }
    }

    protected void uCDInfo1(int value) {
        int cdExist = value & 255;
        int cdCurPos = (value >> 8) & 255;
        int cdChannel = (value >> 16) & 255;
        for (int j = 0; j < 6; j++) {
            if (cdCurPos == j) {
                if (this.textView[j] != null) {
                    this.textView[j].setText(R.string.str_sbd_x80_media_state_22);
                }
                if (this.image[j] != null) {
                    this.image[j].setImageResource(R.drawable.ic_sbd_play1);
                }
            } else {
                if (this.textView[j] != null) {
                    this.textView[j].setText("CD" + (j + 1));
                }
                if ((cdExist >> j) == 1) {
                    if (this.image[j] != null) {
                        this.image[j].setImageResource(R.drawable.ic_sbd_ready);
                    }
                } else if (this.image[j] != null) {
                    this.image[j].setImageResource(R.drawable.ic_sbd_gray);
                }
            }
        }
        if (((TextView) findViewById(R.id.track_num_tv)) != null) {
            ((TextView) findViewById(R.id.track_num_tv)).setText(new StringBuilder(String.valueOf(cdChannel)).toString());
        }
    }

    protected void uRadioInfo(int value) {
        String bandInfo;
        int b0 = (value >> 16) & 255;
        int band = (b0 >> 6) & 3;
        String bandstr = "";
        switch (band) {
            case 0:
                bandstr = "FM1";
                break;
            case 1:
                bandstr = "FM2";
                break;
            case 3:
                bandstr = "AM";
                break;
        }
        if ((b0 & 15) == 0) {
            bandInfo = bandstr;
        } else {
            bandInfo = String.valueOf(bandstr) + "-" + (b0 & 15);
        }
        if (((TextView) findViewById(R.id.radio_band_show)) != null) {
            ((TextView) findViewById(R.id.radio_band_show)).setText(bandInfo);
        }
        String freqInfo = "";
        int freq = value & 65535;
        if (band == 3) {
            freqInfo = String.valueOf(freq) + " KHZ";
        } else if (band == 1 || band == 0) {
            freqInfo = String.valueOf(freq / 100.0f) + " MHZ";
        }
        if (((TextView) findViewById(R.id.radio_freq_show)) != null) {
            ((TextView) findViewById(R.id.radio_freq_show)).setText(freqInfo);
        }
    }

    protected void uStateView(int value) {
        setViewVisible(findViewById(R.id.radio_view), value == 1);
        setViewVisible(findViewById(R.id.cd_view), value == 2);
        if (value == 3) {
            finish();
        }
    }
}
