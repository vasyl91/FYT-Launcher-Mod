package com.syu.carinfo.od.bmw;

import android.app.Activity;
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

public class LZBMWE46CarCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LZBMWE46CarCd mInit;
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 42:
                    LZBMWE46CarCd.this.updatecdPlaystate();
                    break;
                case 43:
                    LZBMWE46CarCd.this.mUpdateCdRandom();
                    break;
                case 44:
                    LZBMWE46CarCd.this.mUpdateCdScan();
                    break;
                case 45:
                    LZBMWE46CarCd.this.updateDiscNum(value);
                    break;
                case 46:
                    LZBMWE46CarCd.this.updatecdTrack();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_lz_bmw_e46_carcd);
        init();
    }

    public void init() {
        findViewById(R.id.lexus_cd_scan).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[44];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_random).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[43];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_prev).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{7}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_next).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{8, 1}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_play).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[2], null, null);
            }
        });
        findViewById(R.id.lexus_cd_pause).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{1, 1}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_cd1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{2, 1}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{2, 2}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{2, 3}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{2, 4}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{2, 5}, null, null);
            }
        });
        findViewById(R.id.btn_lexus_cd6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(3, new int[]{2, 6}, null, null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
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

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[44];
        findViewById(R.id.lexus_cd_scan).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_scan_n : R.drawable.ic_lexus_cd_scan_p);
    }

    
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[43];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    public void updatecdTrack() {
        int value1 = DataCanbus.DATA[46];
        ((TextView) findViewById(R.id.dj_lexus_cd_track)).setText(String.format("TRACK: %d", Integer.valueOf(value1)));
    }

    public void updatecdPlaystate() {
        int value = DataCanbus.DATA[42];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(R.string.crv_state_play);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(R.string.crv_state_pause);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(R.string.str_car_cd_work_state_2);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(R.string.str_sbd_x80_media_state_10);
                break;
            default:
                ((TextView) findViewById(R.id.dj_lexus_cd_time)).setText(R.string.str_car_cd_work_state_6);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(3, new int[]{4, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(3, new int[]{3, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427860 */:
                    DataCanbus.PROXY.cmd(3, new int[]{4}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427863 */:
                    DataCanbus.PROXY.cmd(3, new int[]{3}, null, null);
                    break;
            }
        }
        return false;
    }
}
