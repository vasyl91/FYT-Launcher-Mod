package com.syu.carinfo.daojun.lexus;

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
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class djLexusCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 107:
                    djLexusCd.this.updateDiscNum(value);
                    break;
                case 108:
                    ((TextView) djLexusCd.this.findViewById(R.id.dj_lexus_cd_track)).setText(String.format("Track:%d", Integer.valueOf(value)));
                    break;
                case 110:
                    djLexusCd.this.mUpdateCdRpt();
                    break;
                case 111:
                    djLexusCd.this.mUpdateCdRandom();
                    break;
                case 114:
                case 115:
                    djLexusCd.this.updatecdTime();
                    break;
                case 116:
                    djLexusCd.this.mUpdateCdAsl();
                    break;
                case 123:
                    djLexusCd.this.mUpdateCdScan();
                    break;
                case 126:
                    djLexusCd.this.mUpdateCd1State();
                    break;
                case 127:
                    djLexusCd.this.mUpdateCd2State();
                    break;
                case 128:
                    djLexusCd.this.mUpdateCd3State();
                    break;
                case 129:
                    djLexusCd.this.mUpdateCd4State();
                    break;
                case 130:
                    djLexusCd.this.mUpdateCd5State();
                    break;
                case 131:
                    djLexusCd.this.mUpdateCd6State();
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

    public void init() {
        findViewById(R.id.lexus_cd_toaudio).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(djLexusCd.this, djLexusAudio.class);
                    djLexusCd.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.lexus_cd_scan).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{13, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_rpt).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[110];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{11, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_random).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[111];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{12, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_asl).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                if (value == 1) {
                    value = 8;
                } else if (value == 8) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_prev).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{9, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{9}, null, null);
                    }
                }, 100L);
            }
        });
        findViewById(R.id.lexus_cd_next).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{8, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{8}, null, null);
                    }
                }, 100L);
            }
        });
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_cd1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[126] == 2 && DataCanbus.DATA[107] == 1) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 1}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[127] == 2 && DataCanbus.DATA[107] == 2) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 2}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[128] == 2 && DataCanbus.DATA[107] == 3) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 3}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[129] == 2 && DataCanbus.DATA[107] == 4) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 4}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[130] == 2 && DataCanbus.DATA[107] == 5) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 5}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (DataCanbus.DATA[131] == 2 && DataCanbus.DATA[107] == 6) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 6}, null, null);
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[126];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("CD");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("DVD");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.str_sbd_x80_media_state_10);
                break;
        }
    }

    
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[127];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("CD");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("DVD");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.str_sbd_x80_media_state_10);
                break;
        }
    }

    
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[128];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("CD");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("DVD");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.str_sbd_x80_media_state_10);
                break;
        }
    }

    
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[129];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("CD");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("DVD");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.str_sbd_x80_media_state_10);
                break;
        }
    }

    
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[130];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("CD");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("DVD");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.str_sbd_x80_media_state_10);
                break;
        }
    }

    
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[131];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("CD");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("DVD");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.str_sbd_x80_media_state_10);
                break;
        }
    }

    
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[123];
        findViewById(R.id.lexus_cd_scan).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_scan_n : R.drawable.ic_lexus_cd_scan_p);
    }

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[110];
        findViewById(R.id.lexus_cd_rpt).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
    }

    
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[111];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    
    public void mUpdateCdAsl() {
        int On = DataCanbus.DATA[116];
        if (On == 8) {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_p);
        } else {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_n);
        }
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[114];
        int value1 = DataCanbus.DATA[115];
        ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(String.format("%d:%d", Integer.valueOf(value), Integer.valueOf(value1)));
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
        DataCanbus.PROXY.cmd(1, new int[]{7, 1}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{7}, null, null);
            }
        }, 100L);
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
            }
        }, 50L);
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
            DataCanbus.PROXY.cmd(5, new int[1], null, null);
            finish();
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(3, new int[]{15, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(3, new int[]{14, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(3, new int[]{15}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(3, new int[]{14}, null, null);
                    break;
            }
        }
        return false;
    }
}
