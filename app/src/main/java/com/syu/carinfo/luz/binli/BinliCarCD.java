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

public class BinliCarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static BinliCarCD mInst;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 135:
                    BinliCarCD.this.mUpdateCd1State();
                    break;
                case 136:
                    BinliCarCD.this.mUpdateCd2State();
                    break;
                case 137:
                    BinliCarCD.this.mUpdateCd3State();
                    break;
                case 138:
                    BinliCarCD.this.mUpdateCd4State();
                    break;
                case 139:
                    BinliCarCD.this.mUpdateCd5State();
                    break;
                case 140:
                    BinliCarCD.this.mUpdateCd6State();
                    break;
                case 141:
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
                case 142:
                    BinliCarCD.this.mUpdateCdRpt();
                    break;
                case 143:
                    BinliCarCD.this.mUpdateCdRandom();
                    break;
                case 144:
                    BinliCarCD.this.mUpdateCdScan();
                    break;
                case 145:
                    BinliCarCD.this.updateDiscNum(value);
                    break;
                case 146:
                    ((TextView) BinliCarCD.this.findViewById(R.id.dj_prado_cd_track)).setText(String.format("Track:%d", Integer.valueOf(value)));
                    break;
                case 147:
                case 148:
                    BinliCarCD.this.updatecdTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_0439_luz_binli_carcd);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncMain.setChannel(13);
        isFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
    }

    
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[135];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd1)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[136];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd2)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[137];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd3)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[138];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd4)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[139];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd5)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[140];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setText(R.string.jeep_playstate1);
                break;
            case 1:
                ((TextView) findViewById(R.id.dj_prado_cd6)).setText("CD");
                break;
        }
    }

    
    public void mUpdateCdRpt() {
        int On = DataCanbus.DATA[142];
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

    
    public void mUpdateCdRandom() {
        int On = DataCanbus.DATA[143];
        findViewById(R.id.prado_cd_random).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_random_n : R.drawable.ic_lexus_cd_random_p);
    }

    
    public void mUpdateCdScan() {
        int On = DataCanbus.DATA[144];
        findViewById(R.id.prado_cd_scan).setBackgroundResource(On == 0 ? R.drawable.ic_lexus_cd_scan_n : R.drawable.ic_lexus_cd_scan_p);
    }

    public void updatecdTime() {
        int value = DataCanbus.DATA[147];
        int value1 = DataCanbus.DATA[148];
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
        findViewById(R.id.prado_cd_scan).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[144];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.prado_cd_rpt).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[142];
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
        findViewById(R.id.prado_cd_random).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[143];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.prado_cd_power).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[141];
                if (value != 1) {
                    DataCanbus.PROXY.cmd(2, new int[2], null, null);
                }
            }
        });
        findViewById(R.id.prado_cd_disc).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[141];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(2, new int[2], null, null);
                }
            }
        });
        findViewById(R.id.prado_cd_prev).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{3}, null, null);
            }
        });
        findViewById(R.id.prado_cd_next).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{2}, null, null);
            }
        });
        findViewById(R.id.prado_cd_skipb).setOnTouchListener(this);
        findViewById(R.id.prado_cd_skipf).setOnTouchListener(this);
        findViewById(R.id.btn_prado_cd1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd3).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 3}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd4).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 4}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd5).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 5}, null, null);
            }
        });
        findViewById(R.id.btn_prado_cd6).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(2, new int[]{1, 6}, null, null);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.prado_cd_skipb /* 2131428252 */:
                    DataCanbus.PROXY.cmd(2, new int[]{5, 1}, null, null);
                    break;
                case R.id.prado_cd_skipf /* 2131428255 */:
                    DataCanbus.PROXY.cmd(2, new int[]{4, 1}, null, null);
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.prado_cd_skipb /* 2131428252 */:
                    DataCanbus.PROXY.cmd(2, new int[]{5}, null, null);
                    break;
                case R.id.prado_cd_skipf /* 2131428255 */:
                    DataCanbus.PROXY.cmd(2, new int[]{4}, null, null);
                    break;
            }
        }
        return false;
    }
}
