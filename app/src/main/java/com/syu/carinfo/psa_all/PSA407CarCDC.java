package com.syu.carinfo.psa_all;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PSA407CarCDC extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static PSA407CarCDC mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 218:
                    PSA407CarCDC.this.updateDiscNum(value);
                    break;
                case 219:
                case 225:
                    PSA407CarCDC.this.mUpdateCd6State();
                    break;
                case 220:
                case 226:
                    PSA407CarCDC.this.mUpdateCd5State();
                    break;
                case 221:
                case 227:
                    PSA407CarCDC.this.mUpdateCd4State();
                    break;
                case 222:
                case 228:
                    PSA407CarCDC.this.mUpdateCd3State();
                    break;
                case 223:
                case 229:
                    PSA407CarCDC.this.mUpdateCd2State();
                    break;
                case 224:
                case 230:
                    PSA407CarCDC.this.mUpdateCd1State();
                    break;
                case 231:
                case 241:
                    PSA407CarCDC.this.updatecdTrack();
                    break;
                case 232:
                case 233:
                    PSA407CarCDC.this.updatecdTime();
                    break;
                case 234:
                case 235:
                    PSA407CarCDC.this.mUpdateCdScan();
                    break;
                case 236:
                case 237:
                    PSA407CarCDC.this.mUpdateCdRpt();
                    break;
                case 238:
                case 239:
                    PSA407CarCDC.this.mUpdateCdRandom();
                    break;
                case 240:
                    switch (value) {
                        case 0:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Readng TOC");
                            break;
                        case 1:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Pause");
                            break;
                        case 2:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Play");
                            break;
                        case 3:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Fast");
                            break;
                        case 4:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("User search");
                            break;
                        case 5:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Internal search");
                            break;
                        case 6:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Stop");
                            break;
                        case 7:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Rom read");
                            break;
                        case 8:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Rom search");
                            break;
                        case 9:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Retrieving");
                            break;
                        case 10:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Disc changing(User)");
                            break;
                        case 11:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Disc changing(Internal)");
                            break;
                        case 12:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Eject");
                            break;
                        case 13:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Load");
                            break;
                        case 14:
                            ((TextView) PSA407CarCDC.this.findViewById(R.id.tv_text1)).setText("Disc error");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0252_wc_psa_407_carcd);
        init();
    }

    public void init() {
        ((Button) findViewById(R.id.lexus_cd_scan)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[234] == 1) {
                    DataCanbus.PROXY.cmd(105, new int[]{14}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(105, new int[]{14, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.lexus_cd_random)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[238] == 1) {
                    DataCanbus.PROXY.cmd(105, new int[]{15}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(105, new int[]{15, 1}, null, null);
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[224];
        int value1 = DataCanbus.DATA[230];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("CD");
                    break;
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("Rom disk");
                    break;
                }
        }
    }

    
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[223];
        int value1 = DataCanbus.DATA[229];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("CD");
                    break;
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("Rom disk");
                    break;
                }
        }
    }

    
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[222];
        int value1 = DataCanbus.DATA[228];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("CD");
                    break;
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("Rom disk");
                    break;
                }
        }
    }

    
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[221];
        int value1 = DataCanbus.DATA[227];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("CD");
                    break;
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("Rom disk");
                    break;
                }
        }
    }

    
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[220];
        int value1 = DataCanbus.DATA[226];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("CD");
                    break;
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("Rom disk");
                    break;
                }
        }
    }

    
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[219];
        int value1 = DataCanbus.DATA[225];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (value1 == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("CD");
                    break;
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("Rom disk");
                    break;
                }
        }
    }

    
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[234];
        int DiscOn = DataCanbus.DATA[235];
        if (On == 1 || DiscOn == 1) {
            findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_p);
        } else {
            findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_n);
        }
    }

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[236];
        int DiscOn = DataCanbus.DATA[237];
        if (On == 1 || DiscOn == 1) {
            findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_p);
        } else {
            findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_n);
        }
    }

    
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[238];
        int DiscOn = DataCanbus.DATA[239];
        if (On == 1 || DiscOn == 1) {
            findViewById(R.id.lexus_cd_random).setBackgroundResource(R.drawable.ic_lexus_cd_random_p);
        } else {
            findViewById(R.id.lexus_cd_random).setBackgroundResource(R.drawable.ic_lexus_cd_random_n);
        }
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[241];
        int value1 = DataCanbus.DATA[231];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d / %d", Integer.valueOf(value1), Integer.valueOf(value)));
    }

    public void updatecdTime() {
        int value3 = DataCanbus.DATA[233];
        int value4 = DataCanbus.DATA[232];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d%d:%d%d", Integer.valueOf(value4 / 10), Integer.valueOf(value4 % 10), Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10)));
    }

    public void updateDiscNum(int value) {
        ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-65536);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
