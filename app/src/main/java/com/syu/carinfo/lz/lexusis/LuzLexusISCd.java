package com.syu.carinfo.lz.lexusis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class LuzLexusISCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LuzLexusISRadio mInit;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    LuzLexusISCd.this.mUpdateCd1State();
                    break;
                case 107:
                    LuzLexusISCd.this.mUpdateCd2State();
                    break;
                case 108:
                    LuzLexusISCd.this.mUpdateCd3State();
                    break;
                case 109:
                    LuzLexusISCd.this.mUpdateCd4State();
                    break;
                case 110:
                    LuzLexusISCd.this.mUpdateCd5State();
                    break;
                case 111:
                    LuzLexusISCd.this.mUpdateCd6State();
                    break;
                case 113:
                    LuzLexusISCd.this.updateDiscNum(value);
                    break;
                case 126:
                    LuzLexusISCd.this.mUpdateCdRpt();
                    break;
                case 127:
                    LuzLexusISCd.this.mUpdateCdRandom();
                    break;
                case 128:
                case 129:
                    LuzLexusISCd.this.updatecdTrack();
                    break;
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                    LuzLexusISCd.this.updatecdTime();
                    break;
                case 138:
                    LuzLexusISCd.this.mUpdateCdAsl();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX /* 3015111 */:
            case FinalCanbus.CAR_455_LZ_CG_Toyota_LEUXS_GX_H /* 3080647 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                //setContentView(R.layout.layout_djlexus_carcd_cg);
                break;
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX /* 3342791 */:
            case FinalCanbus.CAR_455_LZ_YL_Toyota_LEUXS_GX_H /* 3408327 */:
                //setContentView(R.layout.layout_djlexus_carcd_yl);
                break;
            default:
                //setContentView(R.layout.layout_djlexus_carcd);
                break;
        }
        init();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[106];
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
        int value = DataCanbus.DATA[107];
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
        int value = DataCanbus.DATA[108];
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
        int value = DataCanbus.DATA[109];
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
        int value = DataCanbus.DATA[110];
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

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[126];
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
        int On = DataCanbus.DATA[127];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    
    public void mUpdateCdAsl() {
        int On = DataCanbus.DATA[138];
        if (On == 8) {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_p);
        } else {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_n);
        }
    }

    public void updatecdTrack() {
        int value = DataCanbus.DATA[128];
        int value1 = DataCanbus.DATA[129];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d / %d", Integer.valueOf(value1), Integer.valueOf(value)));
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[130];
        int value1 = DataCanbus.DATA[131];
        int value2 = DataCanbus.DATA[132];
        int value3 = DataCanbus.DATA[133];
        int value4 = DataCanbus.DATA[134];
        int value5 = DataCanbus.DATA[135];
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
        findViewById(R.id.lexus_cd_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(LuzLexusISCd.this, LZLexusISCarSet.class);
                    LuzLexusISCd.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.lexus_cd_scan).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{26}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_rpt).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{17}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_random).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{16}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_asl).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[138];
                if (value == 1) {
                    value = 8;
                } else if (value == 8) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_prev).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{20}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_next).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{19, 1}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_cd1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 3}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 4}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 5}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{23, 6}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(2, new int[]{48, 4}, null, null);
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
            DataCanbus.PROXY.cmd(2, new int[]{48, 5}, null, null);
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
                    DataCanbus.PROXY.cmd(2, new int[]{25, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(2, new int[]{24, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(2, new int[]{25}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(2, new int[]{24}, null, null);
                    break;
            }
        }
        return false;
    }
}
