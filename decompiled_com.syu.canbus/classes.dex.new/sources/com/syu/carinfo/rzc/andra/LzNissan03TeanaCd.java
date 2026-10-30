package com.syu.carinfo.rzc.andra;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LzNissan03TeanaCd extends Activity implements View.OnTouchListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 111:
                    LzNissan03TeanaCd.this.mUpdateCd6State();
                    break;
                case 112:
                    LzNissan03TeanaCd.this.mUpdateCd5State();
                    break;
                case 113:
                    LzNissan03TeanaCd.this.mUpdateCd4State();
                    break;
                case 114:
                    LzNissan03TeanaCd.this.mUpdateCd3State();
                    break;
                case 115:
                    LzNissan03TeanaCd.this.mUpdateCd2State();
                    break;
                case 116:
                    LzNissan03TeanaCd.this.mUpdateCd1State();
                    break;
                case 117:
                    LzNissan03TeanaCd.this.mUpdateCdRpt();
                    break;
                case 118:
                    LzNissan03TeanaCd.this.mUpdateCdRandom();
                    break;
                case 119:
                    LzNissan03TeanaCd.this.mUpdateCdState();
                    break;
                case 120:
                    LzNissan03TeanaCd.this.updateDiscNum(value);
                    break;
                case 121:
                    LzNissan03TeanaCd.this.updatecdTrack();
                    break;
                case 122:
                case 123:
                    LzNissan03TeanaCd.this.updatecdTime();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_nissan_03teana_carcd);
        init();
    }

    public void init() {
        ((Button) findViewById(R.id.lexus_cd_playpause)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[119] == 1) {
                    DataCanbus.PROXY.cmd(4, new int[]{1, 0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[2], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.lexus_cd_rpt)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{7, 2}, null, null);
                    return;
                }
                if (value == 1) {
                    DataCanbus.PROXY.cmd(4, new int[]{7, 1}, null, null);
                } else if (value == 2) {
                    DataCanbus.PROXY.cmd(4, new int[]{7, 0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[]{7, 2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.lexus_cd_random)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{6, 1}, null, null);
                } else if (value == 1) {
                    DataCanbus.PROXY.cmd(4, new int[]{6, 0}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[]{6, 0}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.lexus_cd_prev)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{3, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_next)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{2, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_prevdisc)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{9, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_nextdisc)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.andra.LzNissan03TeanaCd.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(4, new int[]{8, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_skipb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_cd_skipf)).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131428050 */:
                    DataCanbus.PROXY.cmd(4, new int[]{5, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131428053 */:
                    DataCanbus.PROXY.cmd(4, new int[]{4, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131428050 */:
                    DataCanbus.PROXY.cmd(4, new int[]{5, 0}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131428053 */:
                    DataCanbus.PROXY.cmd(4, new int[]{4, 0}, null, null);
                    break;
            }
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[116];
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
        int value = DataCanbus.DATA[114];
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
        int value = DataCanbus.DATA[113];
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
        int value = DataCanbus.DATA[112];
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
        int value = DataCanbus.DATA[111];
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
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[117];
        switch (On) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText("Rpt:All disc");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText("Rpt:Track");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText("Rpt:Disc");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText("Rpt:off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[118];
        switch (On) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText("Random:All disc");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText("Random:Disc");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText("Random:off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdState() {
        int On = DataCanbus.DATA[119];
        switch (On) {
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_playstate2);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_playstate6);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_car_cd_ff);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_car_cd_fb);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.crv_state_loading);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_status_idle);
                break;
        }
    }

    public void updatecdTrack() {
        int value1 = DataCanbus.DATA[121];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d", Integer.valueOf(value1)));
    }

    public void updatecdTime() {
        int value3 = DataCanbus.DATA[123];
        int value4 = DataCanbus.DATA[122];
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
}
