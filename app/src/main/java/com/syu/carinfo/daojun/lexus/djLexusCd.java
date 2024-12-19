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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class djLexusCd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    djLexusCd.this.updateDiscNum(value);
                    break;
                case 29:
                    ((TextView) djLexusCd.this.findViewById(R.id.dj_lexus_cd_track)).setText(String.format("Track:%d", Integer.valueOf(value)));
                    break;
                case 31:
                    djLexusCd.this.mUpdateCdRpt();
                    break;
                case 32:
                    djLexusCd.this.mUpdateCdRandom();
                    break;
                case 35:
                case 36:
                    djLexusCd.this.updatecdTime();
                    break;
                case 37:
                    djLexusCd.this.mUpdateCdAsl();
                    break;
                case 44:
                    djLexusCd.this.mUpdateCdScan();
                    break;
                case 54:
                    djLexusCd.this.mUpdateCd1State();
                    break;
                case 55:
                    djLexusCd.this.mUpdateCd2State();
                    break;
                case 56:
                    djLexusCd.this.mUpdateCd3State();
                    break;
                case 57:
                    djLexusCd.this.mUpdateCd4State();
                    break;
                case 58:
                    djLexusCd.this.mUpdateCd5State();
                    break;
                case 59:
                    djLexusCd.this.mUpdateCd6State();
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

    public void init() {
        findViewById(R.id.lexus_cd_toaudio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.2
            @Override // android.view.View.OnClickListener
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
        findViewById(R.id.lexus_cd_scan).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[44];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{13, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_rpt).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[31];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{11, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_random).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[32];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(3, new int[]{12, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_asl).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[37];
                if (value == 1) {
                    value = 8;
                } else if (value == 8) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(4, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.lexus_cd_prev).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{9, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{9}, null, null);
                    }
                }, 100L);
            }
        });
        findViewById(R.id.lexus_cd_next).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(1, new int[]{8, 1}, null, null);
                HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{8}, null, null);
                    }
                }, 100L);
            }
        });
        findViewById(R.id.lexus_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.lexus_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.btn_lexus_cd1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[54] == 2 && DataCanbus.DATA[28] == 1) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 1}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[55] == 2 && DataCanbus.DATA[28] == 2) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 2}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[56] == 2 && DataCanbus.DATA[28] == 3) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 3}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[57] == 2 && DataCanbus.DATA[28] == 4) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 4}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[58] == 2 && DataCanbus.DATA[28] == 5) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 5}, null, null);
                }
            }
        });
        findViewById(R.id.btn_lexus_cd6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[59] == 2 && DataCanbus.DATA[28] == 6) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[]{6, 6}, null, null);
                }
            }
        });
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[54];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[55];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[56];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[57];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[58];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[59];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[44];
        findViewById(R.id.lexus_cd_scan).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_scan_n : R.drawable.ic_lexus_cd_scan_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[31];
        findViewById(R.id.lexus_cd_rpt).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_rpt_n : R.drawable.ic_lexus_cd_rpt_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[32];
        findViewById(R.id.lexus_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdAsl() {
        int On = DataCanbus.DATA[37];
        if (On == 8) {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_p);
        } else {
            findViewById(R.id.lexus_cd_asl).setBackgroundResource(R.drawable.ic_lexus_cd_asl_n);
        }
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[35];
        int value1 = DataCanbus.DATA[36];
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

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        DataCanbus.PROXY.cmd(1, new int[]{7, 1}, null, null);
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.15
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(1, new int[]{7}, null, null);
            }
        }, 100L);
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.daojun.lexus.djLexusCd.16
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
            }
        }, 50L);
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
            DataCanbus.PROXY.cmd(5, new int[1], null, null);
            finish();
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427844 */:
                    DataCanbus.PROXY.cmd(3, new int[]{15, 1}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427847 */:
                    DataCanbus.PROXY.cmd(3, new int[]{14, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.lexus_cd_skipb /* 2131427844 */:
                    DataCanbus.PROXY.cmd(3, new int[]{15}, null, null);
                    break;
                case R.id.lexus_cd_skipf /* 2131427847 */:
                    DataCanbus.PROXY.cmd(3, new int[]{14}, null, null);
                    break;
            }
        }
        return false;
    }
}
