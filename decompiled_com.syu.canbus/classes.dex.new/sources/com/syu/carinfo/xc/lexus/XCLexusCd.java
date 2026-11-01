package com.syu.carinfo.xc.lexus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XCLexusCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static XCLexusRadio mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    XCLexusCd.this.mUpdateCdAsl();
                    break;
                case 114:
                    XCLexusCd.this.mUpdateCd1State();
                    break;
                case 115:
                    XCLexusCd.this.mUpdateCd2State();
                    break;
                case 116:
                    XCLexusCd.this.mUpdateCd3State();
                    break;
                case 117:
                    XCLexusCd.this.mUpdateCd4State();
                    break;
                case 118:
                    XCLexusCd.this.mUpdateCd5State();
                    break;
                case 119:
                    XCLexusCd.this.mUpdateCd6State();
                    break;
                case 121:
                    XCLexusCd.this.updateDiscNum(value);
                    break;
                case 136:
                case 137:
                    XCLexusCd.this.updatecdTrack();
                    break;
                case 138:
                case 139:
                case 140:
                case 144:
                case 145:
                case 146:
                    XCLexusCd.this.updatecdTime();
                    break;
                case 141:
                    XCLexusCd.this.mUpdateCdRpt();
                    break;
                case 142:
                    XCLexusCd.this.mUpdateCdRandom();
                    break;
                case 143:
                    XCLexusCd.this.mUpdateCdScan();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djlexus_carcd);
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[114];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[115];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[116];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[117];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[118];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[119];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[143];
        findViewById(R.id.lexus_cd_scan).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_scan_n : R.drawable.ic_lexus_cd_scan_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[141];
        switch (On) {
            case 0:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_n);
                break;
            case 1:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt1_n);
                break;
            case 2:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rptall_n);
                break;
            default:
                findViewById(R.id.lexus_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_n);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[142];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdAsl() {
        int On = DataCanbus.DATA[111];
        if (On == 1) {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_p);
        } else {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_n);
        }
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[136];
        int value1 = DataCanbus.DATA[137];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d / %d", Integer.valueOf(value1), Integer.valueOf(value)));
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[138];
        int value1 = DataCanbus.DATA[139];
        int value2 = DataCanbus.DATA[140];
        int value3 = DataCanbus.DATA[144];
        int value4 = DataCanbus.DATA[145];
        int value5 = DataCanbus.DATA[146];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d%d:%d%d:%d%d / %d%d:%d%d:%d%d", Integer.valueOf(value5 / 10), Integer.valueOf(value5 % 10), Integer.valueOf(value4 / 10), Integer.valueOf(value4 % 10), Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10), Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10), Integer.valueOf(value1 / 10), Integer.valueOf(value1 % 10), Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
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

    public void init() {
        ((Button) findViewById(R.id.lexus_cd_toaudio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(XCLexusCd.this, XCLexusAudio.class);
                    XCLexusCd.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lexus_cd_asl)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_prev)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_cd_next)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_cd_skipb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_cd_skipf)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_cd1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{23, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{23, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{23, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{23, 4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{23, 5}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xc.lexus.XCLexusCd.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{23, 6}, null, null);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(0, new int[2], null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_prev /* 2131428049 */:
                    DataCanbus.PROXY.cmd(1, new int[]{19, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipb /* 2131428050 */:
                    DataCanbus.PROXY.cmd(1, new int[]{19, 2}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131428053 */:
                    DataCanbus.PROXY.cmd(1, new int[]{20, 2}, null, null);
                    break;
                case R.id.lexus_cd_next /* 2131428054 */:
                    DataCanbus.PROXY.cmd(1, new int[]{20, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_prev /* 2131428049 */:
                case R.id.lexus_cd_skipb /* 2131428050 */:
                    DataCanbus.PROXY.cmd(1, new int[]{19, 0}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131428053 */:
                case R.id.lexus_cd_next /* 2131428054 */:
                    DataCanbus.PROXY.cmd(1, new int[]{20, 0}, null, null);
                    break;
            }
        }
        return false;
    }
}
