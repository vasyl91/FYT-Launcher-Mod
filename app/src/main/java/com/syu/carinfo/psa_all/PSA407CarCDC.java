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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PSA407CarCDC extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static PSA407CarCDC mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSA407CarCDC.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 206:
                    PSA407CarCDC.this.updateDiscNum(value);
                    break;
                case 207:
                case 213:
                    PSA407CarCDC.this.mUpdateCd6State();
                    break;
                case 208:
                case 214:
                    PSA407CarCDC.this.mUpdateCd5State();
                    break;
                case 209:
                case 215:
                    PSA407CarCDC.this.mUpdateCd4State();
                    break;
                case 210:
                case 216:
                    PSA407CarCDC.this.mUpdateCd3State();
                    break;
                case 211:
                case 217:
                    PSA407CarCDC.this.mUpdateCd2State();
                    break;
                case 212:
                case 218:
                    PSA407CarCDC.this.mUpdateCd1State();
                    break;
                case 219:
                case 229:
                    PSA407CarCDC.this.updatecdTrack();
                    break;
                case 220:
                case 221:
                    PSA407CarCDC.this.updatecdTime();
                    break;
                case 222:
                case 223:
                    PSA407CarCDC.this.mUpdateCdScan();
                    break;
                case 224:
                case 225:
                    PSA407CarCDC.this.mUpdateCdRpt();
                    break;
                case 226:
                case 227:
                    PSA407CarCDC.this.mUpdateCdRandom();
                    break;
                case 228:
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0252_wc_psa_407_carcd);
        init();
    }

    public void init() {
        ((Button) findViewById(R.id.lexus_cd_scan)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA407CarCDC.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[222] == 1) {
                    DataCanbus.PROXY.cmd(105, new int[]{14}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(105, new int[]{14, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.lexus_cd_random)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA407CarCDC.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[226] == 1) {
                    DataCanbus.PROXY.cmd(105, new int[]{15}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(105, new int[]{15, 1}, null, null);
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.notifyCanbus, 1);
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
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.notifyCanbus);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[212];
        int value1 = DataCanbus.DATA[218];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[211];
        int value1 = DataCanbus.DATA[217];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[210];
        int value1 = DataCanbus.DATA[216];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[209];
        int value1 = DataCanbus.DATA[215];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[208];
        int value1 = DataCanbus.DATA[214];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[207];
        int value1 = DataCanbus.DATA[213];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[222];
        int DiscOn = DataCanbus.DATA[223];
        if (On == 1 || DiscOn == 1) {
            findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_p);
        } else {
            findViewById(R.id.lexus_cd_scan).setBackgroundResource(R.drawable.ic_lexus_cd_scan_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[224];
        int DiscOn = DataCanbus.DATA[225];
        if (On == 1 || DiscOn == 1) {
            findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_p);
        } else {
            findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[226];
        int DiscOn = DataCanbus.DATA[227];
        if (On == 1 || DiscOn == 1) {
            findViewById(R.id.lexus_cd_random).setBackgroundResource(R.drawable.ic_lexus_cd_random_p);
        } else {
            findViewById(R.id.lexus_cd_random).setBackgroundResource(R.drawable.ic_lexus_cd_random_n);
        }
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[229];
        int value1 = DataCanbus.DATA[219];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d / %d", Integer.valueOf(value1), Integer.valueOf(value)));
    }

    public void updatecdTime() {
        int value3 = DataCanbus.DATA[221];
        int value4 = DataCanbus.DATA[220];
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

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
