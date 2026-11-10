package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class TangduLexusCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LuzLexusISRadio mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 138:
                case 146:
                    TangduLexusCd.this.mUpdateCd1State();
                    break;
                case 139:
                case 147:
                    TangduLexusCd.this.mUpdateCd2State();
                    break;
                case 140:
                case 148:
                    TangduLexusCd.this.mUpdateCd3State();
                    break;
                case 141:
                case 149:
                    TangduLexusCd.this.mUpdateCd4State();
                    break;
                case 142:
                case 150:
                    TangduLexusCd.this.mUpdateCd5State();
                    break;
                case 143:
                case 151:
                    TangduLexusCd.this.mUpdateCd6State();
                    break;
                case 145:
                    TangduLexusCd.this.updateDiscNum(value);
                    break;
                case 164:
                    TangduLexusCd.this.mUpdateCdRpt();
                    break;
                case 165:
                    TangduLexusCd.this.mUpdateCdRandom();
                    break;
                case 166:
                case 167:
                    TangduLexusCd.this.updatecdTrack();
                    break;
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                    TangduLexusCd.this.updatecdTime();
                    break;
                case 178:
                    TangduLexusCd.this.mUpdateCdAsl();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_13_CD /* 4981191 */:
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_14_CD /* 5046727 */:
            case FinalCanbus.CAR_456_YL_Elynx_Tangdu_Toyota_LexusGX_13_CD /* 8847816 */:
                setContentView(R.layout.layout_djlexus_carcd_yl);
                break;
            default:
                setContentView(R.layout.layout_djlexus_carcd);
                break;
        }
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[138];
        int type = DataCanbus.DATA[146];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (type == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("CD");
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("DVD");
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[139];
        int type = DataCanbus.DATA[147];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (type == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("CD");
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("DVD");
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[140];
        int type = DataCanbus.DATA[148];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (type == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("CD");
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("DVD");
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[141];
        int type = DataCanbus.DATA[149];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (type == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("CD");
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("DVD");
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[142];
        int type = DataCanbus.DATA[150];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (type == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("CD");
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("DVD");
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[143];
        int type = DataCanbus.DATA[151];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                if (type == 0) {
                    ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("CD");
                } else {
                    ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("DVD");
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[164];
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
        int On = DataCanbus.DATA[165];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdAsl() {
        int On = DataCanbus.DATA[178];
        if (On == 8) {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_p);
        } else {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_n);
        }
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[166];
        int value1 = DataCanbus.DATA[167];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_13_CD /* 4981191 */:
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_14_CD /* 5046727 */:
            case FinalCanbus.CAR_456_YL_Elynx_Tangdu_Toyota_LexusGX_13_CD /* 8847816 */:
                ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d ", Integer.valueOf(value1)));
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d / %d", Integer.valueOf(value1), Integer.valueOf(value)));
                break;
        }
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[168];
        int value1 = DataCanbus.DATA[169];
        int value2 = DataCanbus.DATA[170];
        int value3 = DataCanbus.DATA[171];
        int value4 = DataCanbus.DATA[172];
        int value5 = DataCanbus.DATA[173];
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_13_CD /* 4981191 */:
            case FinalCanbus.CAR_455_YL_Tangdu_Toyota_LexusGX_14_CD /* 5046727 */:
            case FinalCanbus.CAR_456_YL_Elynx_Tangdu_Toyota_LexusGX_13_CD /* 8847816 */:
                ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d%d:%d%d:%d%d", Integer.valueOf(value5 / 10), Integer.valueOf(value5 % 10), Integer.valueOf(value4 / 10), Integer.valueOf(value4 % 10), Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10)));
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d%d:%d%d:%d%d / %d%d:%d%d:%d%d", Integer.valueOf(value5 / 10), Integer.valueOf(value5 % 10), Integer.valueOf(value4 / 10), Integer.valueOf(value4 % 10), Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10), Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10), Integer.valueOf(value1 / 10), Integer.valueOf(value1 % 10), Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                break;
        }
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
        ((Button) findViewById(R.id.lexus_cd_toaudio)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(TangduLexusCd.this, TangduLexusCarSet.class);
                    TangduLexusCd.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.lexus_cd_scan)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{26, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_rpt)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{17, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_random)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{16, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_asl)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[178];
                if (value == 1) {
                    value = 8;
                } else if (value == 8) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_prev)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{20, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_next)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{19, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.lexus_cd_skipb)).setOnTouchListener(this);
        ((Button) findViewById(R.id.lexus_cd_skipf)).setOnTouchListener(this);
        ((Button) findViewById(R.id.btn_lexus_cd1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 5}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_lexus_cd6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCd.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 6}, null, null);
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(2, new int[]{48, 4}, null, null);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            DataCanbus.PROXY.cmd(2, new int[]{48, 5}, null, null);
            finish();
            return true;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131428020 */:
                    DataCanbus.PROXY.cmd(2, new int[]{25, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131428023 */:
                    DataCanbus.PROXY.cmd(2, new int[]{24, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131428020 */:
                    DataCanbus.PROXY.cmd(2, new int[]{25, 0}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131428023 */:
                    DataCanbus.PROXY.cmd(2, new int[]{24, 0}, null, null);
                    break;
            }
        }
        return false;
    }
}
