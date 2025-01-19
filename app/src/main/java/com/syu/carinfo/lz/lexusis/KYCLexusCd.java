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
import com.syu.carinfo.rzc.sanlin.KYCToyotaAllCarSet;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class KYCLexusCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LuzLexusISRadio mInit;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 131:
                    KYCLexusCd.this.mUpdateCd1State();
                    break;
                case 132:
                    KYCLexusCd.this.mUpdateCd2State();
                    break;
                case 133:
                    KYCLexusCd.this.mUpdateCd3State();
                    break;
                case 134:
                    KYCLexusCd.this.mUpdateCd4State();
                    break;
                case 135:
                    KYCLexusCd.this.mUpdateCd5State();
                    break;
                case 136:
                    KYCLexusCd.this.mUpdateCd6State();
                    break;
                case 138:
                    KYCLexusCd.this.updateDiscNum(value);
                    break;
                case 157:
                    KYCLexusCd.this.mUpdateCdRpt();
                    break;
                case 158:
                    KYCLexusCd.this.mUpdateCdRandom();
                    break;
                case 159:
                case 160:
                    KYCLexusCd.this.updatecdTrack();
                    break;
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                    KYCLexusCd.this.updatecdTime();
                    break;
                case 167:
                    KYCLexusCd.this.mUpdateCdScan();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_djlexus_carcd);
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[131];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[132];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[133];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[134];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[135];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[136];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[167];
        findViewById(R.id.lexus_cd_scan).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_scan_n : R.drawable.ic_lexus_cd_scan_p);
    }

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[157];
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

    
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[158];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    
    public void updatecdTrack() {
        int value = DataCanbus.DATA[159];
        int value1 = DataCanbus.DATA[160];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d / %d", Integer.valueOf(value1), Integer.valueOf(value)));
    }

    
    public void updatecdTime() {
        int value = DataCanbus.DATA[161];
        int value1 = DataCanbus.DATA[162];
        int value2 = DataCanbus.DATA[163];
        int value3 = DataCanbus.DATA[164];
        int value4 = DataCanbus.DATA[165];
        int value5 = DataCanbus.DATA[166];
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

    private void init() {
        findViewById(R.id.lexus_cd_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(KYCLexusCd.this, KYCToyotaAllCarSet.class);
                    KYCLexusCd.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.lexus_cd_scan).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[167] == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{13}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[]{13, 1}, null, null);
                }
            }
        });
        findViewById(R.id.lexus_cd_rpt).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{15, 1}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_random).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[158] == 1) {
                    DataCanbus.PROXY.cmd(1, new int[]{14}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[]{14, 1}, null, null);
                }
            }
        });
        findViewById(R.id.lexus_cd_asl).setVisibility(8);
        findViewById(R.id.tv_text1).setVisibility(8);
        findViewById(R.id.lexus_cd_prev).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{19, 1}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_next).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{20, 1}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_cd1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{18, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{18, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{18, 3}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{18, 4}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{18, 5}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{18, 6}, null, null);
            }
        });
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FuncMain.setChannel(0);
            finish();
            return true;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(1, new int[]{21, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(1, new int[]{22, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(1, new int[]{21}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(1, new int[]{22}, null, null);
                    break;
            }
        }
        return false;
    }
}
