package com.syu.carinfo.luz.binli;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BinliCarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static BinliCarCD mInst;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 69:
                    BinliCarCD.this.mUpdateCd1State();
                    break;
                case 70:
                    BinliCarCD.this.mUpdateCd2State();
                    break;
                case 71:
                    BinliCarCD.this.mUpdateCd3State();
                    break;
                case 72:
                    BinliCarCD.this.mUpdateCd4State();
                    break;
                case 73:
                    BinliCarCD.this.mUpdateCd5State();
                    break;
                case 74:
                    BinliCarCD.this.mUpdateCd6State();
                    break;
                case 75:
                    switch (value) {
                        case 0:
                            ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_titlenum)).setText(R.string.jeep_playstate7);
                            break;
                        case 1:
                            ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_titlenum)).setText(R.string.jeep_playstate2);
                            break;
                        case 2:
                            ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_titlenum)).setText(R.string.jeep_playstate6);
                            break;
                        case 3:
                            ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_titlenum)).setText(R.string.jeep_playstate3);
                            break;
                        case 4:
                            ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_titlenum)).setText(R.string.jeep_playstate4);
                            break;
                        case 5:
                            ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_titlenum)).setText(R.string.jeep_playstate5);
                            break;
                        case 6:
                            ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_titlenum)).setText(R.string.jeep_playstate9);
                            break;
                    }
                case 76:
                    BinliCarCD.this.mUpdateCdRpt();
                    break;
                case 77:
                    BinliCarCD.this.mUpdateCdRandom();
                    break;
                case 78:
                    BinliCarCD.this.mUpdateCdScan();
                    break;
                case 79:
                    BinliCarCD.this.updateDiscNum(value);
                    break;
                case 80:
                    ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_track)).setText(String.format("Track:%d", Integer.valueOf(value)));
                    break;
                case 81:
                case 82:
                    BinliCarCD.this.updatecdTime();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0439_luz_binli_carcd);
        init();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        isFront = true;
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[69];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[70];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[71];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[72];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[73];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[74];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setText("CD");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[76];
        switch (On) {
            case 0:
                findViewById(R.id.prado_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt_n);
                break;
            case 1:
                findViewById(R.id.prado_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rptall_n);
                break;
            case 2:
                findViewById(R.id.prado_cd_rpt).setBackgroundResource(R.drawable.ic_lexus_cd_rpt1_n);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[77];
        findViewById(R.id.prado_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[78];
        findViewById(R.id.prado_cd_scan).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_scan_n : R.drawable.ic_lexus_cd_scan_p);
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[81];
        int value1 = DataCanbus.DATA[82];
        ((TextView) findViewById(R.id.dj_prado_cd_time)).setText(String.format("%d:%d", Integer.valueOf(value), Integer.valueOf(value1)));
    }

    public void updateDiscNum(int value) {
        ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setTextColor(-65536);
                break;
        }
    }

    private void init() {
        findViewById(R.id.prado_cd_scan).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[78];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.prado_cd_rpt).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[76];
                if (value == 1) {
                    value = 2;
                } else if (value == 2) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{8, value}, null, null);
            }
        });
        findViewById(R.id.prado_cd_random).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[77];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.prado_cd_power).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[75];
                if (value != 1) {
                    DataCanbus.PROXY.cmd(2, new int[2], null, null);
                }
            }
        });
        findViewById(R.id.prado_cd_disc).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[75];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[2], null, null);
                }
            }
        });
        findViewById(R.id.prado_cd_prev).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{3}, null, null);
            }
        });
        findViewById(R.id.prado_cd_next).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
            }
        });
        findViewById(R.id.prado_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.prado_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.btn_prado_cd1).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd2).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd3).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 3}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd4).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 4}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd5).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 5}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd6).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.luz.binli.BinliCarCD.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 6}, null, null);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.prado_cd_skipb /* 2131428260 */:
                    DataCanbus.PROXY.cmd(2, new int[]{5, 1}, null, null);
                    break;
                case R.id.prado_cd_skipf /* 2131428263 */:
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.prado_cd_skipb /* 2131428260 */:
                    DataCanbus.PROXY.cmd(2, new int[]{5}, null, null);
                    break;
                case R.id.prado_cd_skipf /* 2131428263 */:
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
            }
        }
        return false;
    }
}
