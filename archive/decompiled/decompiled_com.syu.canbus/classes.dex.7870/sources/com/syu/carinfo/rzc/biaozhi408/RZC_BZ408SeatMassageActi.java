package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class RZC_BZ408SeatMassageActi extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408SeatMassageActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 267:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text1)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text1)).setText(R.string.str_dynamic);
                                break;
                            case 2:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_comfort);
                                break;
                        }
                    }
                    break;
                case 268:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 269:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text3)).setText(R.string.str_wc_174008_str16);
                                break;
                            case 2:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text3)).setText(R.string.wc_golf_comfort);
                                break;
                        }
                    }
                    break;
                case 270:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection5);
                                break;
                            case 1:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_sbd_x80_eq_4);
                                break;
                            case 2:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_sbd_x80_eq_2);
                                break;
                            case 3:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_sbd_x80_eq_3);
                                break;
                            case 4:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection4);
                                break;
                            case 5:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text4)).setText(R.string.str_252_sound_selection2);
                                break;
                        }
                    }
                    break;
                case 271:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_standard);
                                break;
                            case 1:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text5)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 272:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 273:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 274:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 275:
                    if (((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZC_BZ408SeatMassageActi.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_biaozhi408_func_seatmassage);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[267];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 2;
                }
                DataCanbus.PROXY.cmd(92, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value3 = DataCanbus.DATA[267];
                int value4 = value3 + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(92, new int[]{1, value4}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value5 = DataCanbus.DATA[268];
                int value6 = value5 - 1;
                if (value6 < 0) {
                    value6 = 6;
                }
                DataCanbus.PROXY.cmd(92, new int[]{2, value6}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value7 = DataCanbus.DATA[268];
                int value8 = value7 + 1;
                if (value8 > 6) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(92, new int[]{2, value8}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value9 = DataCanbus.DATA[269];
                int value10 = value9 - 1;
                if (value10 < 0) {
                    value10 = 2;
                }
                DataCanbus.PROXY.cmd(92, new int[]{3, value10}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value11 = DataCanbus.DATA[269];
                int value12 = value11 + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(92, new int[]{3, value12}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value13 = DataCanbus.DATA[270];
                int value14 = value13 + 1;
                if (value14 > 5) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(92, new int[]{4, value14}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value15 = DataCanbus.DATA[271];
                int value16 = value15 + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(92, new int[]{5, value16}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int b54 = DataCanbus.DATA[272];
                int b30 = DataCanbus.DATA[273];
                int b55 = b54 + 1;
                if (b55 > 3) {
                    b55 = 0;
                }
                int value17 = ((b30 << 4) & 240) | (b55 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{6, value17}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int b56 = DataCanbus.DATA[272];
                int b31 = DataCanbus.DATA[273] + 1;
                if (b31 > 5) {
                    b31 = 1;
                }
                int value18 = ((b31 << 4) & 240) | (b56 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{6, value18}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int b57 = DataCanbus.DATA[274];
                int b32 = DataCanbus.DATA[275];
                int b58 = b57 + 1;
                if (b58 > 3) {
                    b58 = 0;
                }
                int value19 = ((b32 << 4) & 240) | (b58 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{7, value19}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int b59 = DataCanbus.DATA[274];
                int b33 = DataCanbus.DATA[275] + 1;
                if (b33 > 5) {
                    b33 = 1;
                }
                int value20 = ((b33 << 4) & 240) | (b59 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{7, value20}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value21 = DataCanbus.DATA[270];
                int value22 = value21 - 1;
                if (value22 < 0) {
                    value22 = 5;
                }
                DataCanbus.PROXY.cmd(92, new int[]{4, value22}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value23 = DataCanbus.DATA[271];
                int value24 = value23 - 1;
                if (value24 < 0) {
                    value24 = 1;
                }
                DataCanbus.PROXY.cmd(92, new int[]{5, value24}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int b510 = DataCanbus.DATA[272];
                int b34 = DataCanbus.DATA[273];
                int b511 = b510 - 1;
                if (b511 < 0) {
                    b511 = 3;
                }
                int value25 = ((b34 << 4) & 240) | (b511 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{6, value25}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int b512 = DataCanbus.DATA[272];
                int b35 = DataCanbus.DATA[273] - 1;
                if (b35 < 1) {
                    b35 = 5;
                }
                int value26 = ((b35 << 4) & 240) | (b512 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{6, value26}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int b513 = DataCanbus.DATA[274];
                int b36 = DataCanbus.DATA[275];
                int b514 = b513 - 1;
                if (b514 < 0) {
                    b514 = 3;
                }
                int value27 = ((b36 << 4) & 240) | (b514 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{7, value27}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int b515 = DataCanbus.DATA[274];
                int b37 = DataCanbus.DATA[275] - 1;
                if (b37 < 1) {
                    b37 = 5;
                }
                int value28 = ((b37 << 4) & 240) | (b515 & 15);
                DataCanbus.PROXY.cmd(92, new int[]{7, value28}, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
    }
}
