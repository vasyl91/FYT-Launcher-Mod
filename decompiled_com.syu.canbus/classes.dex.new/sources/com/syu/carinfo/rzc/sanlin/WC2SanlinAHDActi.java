package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC2SanlinAHDActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.WC2SanlinAHDActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if ((DataCanbus.DATA[1000] & 65535) == 294) {
                switch (updateCode) {
                    case 214:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)) != null) {
                            switch (value) {
                                case 0:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                    break;
                                case 1:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                    break;
                                case 2:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                    break;
                            }
                        }
                        break;
                    case 215:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)) != null) {
                            switch (value) {
                                case 0:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1280x720@25Hz");
                                    break;
                                case 1:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1280x720@30Hz");
                                    break;
                                case 2:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1920x1080@25Hz");
                                    break;
                                case 3:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1920x1080@30Hz");
                                    break;
                                case 4:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("CVBS");
                                    break;
                            }
                        }
                        break;
                    case 216:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)) != null) {
                            if (value > 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("+" + (value - 100));
                            } else if (value < 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("-" + (100 - value));
                            } else {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("0");
                            }
                        }
                        break;
                    case 217:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)) != null) {
                            if (value > 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("+" + (value - 100));
                            } else if (value < 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("-" + (100 - value));
                            } else {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("0");
                            }
                        }
                        break;
                    case 229:
                        WC2SanlinAHDActi.this.setCheck((CheckedTextView) WC2SanlinAHDActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                        break;
                }
            }
            if ((DataCanbus.DATA[1000] & 65535) == 372) {
                switch (updateCode) {
                    case 272:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)) != null) {
                            switch (value) {
                                case 0:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                    break;
                                case 1:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                    break;
                                case 2:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                    break;
                            }
                        }
                        break;
                    case 273:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)) != null) {
                            switch (value) {
                                case 0:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1280x720@25Hz");
                                    break;
                                case 1:
                                    ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1280x720@30Hz");
                                    break;
                            }
                        }
                        break;
                    case 274:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)) != null) {
                            if (value > 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("+" + (value - 100));
                            } else if (value < 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("-" + (100 - value));
                            } else {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("0");
                            }
                        }
                        break;
                    case 275:
                        if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)) != null) {
                            if (value > 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("+" + (value - 100));
                            } else if (value < 100) {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("-" + (100 - value));
                            } else {
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("0");
                            }
                        }
                        break;
                    case 276:
                        WC2SanlinAHDActi.this.setCheck((CheckedTextView) WC2SanlinAHDActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                        break;
                }
            }
            switch (updateCode) {
                case 152:
                    WC2SanlinAHDActi.this.setCheck((CheckedTextView) WC2SanlinAHDActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 153:
                    if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 154:
                    if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1280x720@25Hz");
                                break;
                            case 1:
                                ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text2)).setText("1280x720@30Hz");
                                break;
                        }
                    }
                    break;
                case 155:
                    if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 100) {
                            ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("+" + (value - 100));
                        } else if (value < 100) {
                            ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("-" + (100 - value));
                        } else {
                            ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 156:
                    if (((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 100) {
                            ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("+" + (value - 100));
                        } else if (value < 100) {
                            ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("-" + (100 - value));
                        } else {
                            ((TextView) WC2SanlinAHDActi.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_sanlin_xforce_ahdsettings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if ((DataCanbus.DATA[1000] & 65535) == 294) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427456 */:
                    int value = DataCanbus.DATA[214] - 1;
                    if (value < 0) {
                        value = 2;
                    }
                    setCarInfo2(1, value, 255, 255);
                    break;
                case R.id.btn_plus1 /* 2131427458 */:
                    int value2 = DataCanbus.DATA[214] + 1;
                    if (value2 > 2) {
                        value2 = 0;
                    }
                    setCarInfo2(1, value2, 255, 255);
                    break;
                case R.id.btn_minus2 /* 2131427459 */:
                    int value3 = DataCanbus.DATA[215] - 1;
                    if (value3 < 0) {
                        value3 = 4;
                    }
                    setCarInfo2(2, value3, 255, 255);
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    int value4 = DataCanbus.DATA[215] + 1;
                    if (value4 > 4) {
                        value4 = 0;
                    }
                    setCarInfo2(2, value4, 255, 255);
                    break;
                case R.id.btn_minus3 /* 2131427462 */:
                    int value5 = DataCanbus.DATA[216];
                    if (value5 > 0) {
                        value5--;
                    }
                    setCarInfo2(3, value5, 255, 255);
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    int value6 = DataCanbus.DATA[216];
                    if (value6 < 200) {
                        value6++;
                    }
                    setCarInfo2(3, value6, 255, 255);
                    break;
                case R.id.btn_minus4 /* 2131427465 */:
                    int value7 = DataCanbus.DATA[217];
                    if (value7 > 0) {
                        value7--;
                    }
                    setCarInfo2(4, value7, 255, 255);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    int value8 = DataCanbus.DATA[217];
                    if (value8 < 200) {
                        value8++;
                    }
                    setCarInfo2(4, value8, 255, 255);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    setCarInfo2(5, DataCanbus.DATA[229] == 1 ? 0 : 1, 255, 255);
                    break;
            }
        }
        if ((DataCanbus.DATA[1000] & 65535) == 372) {
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427456 */:
                    int value9 = DataCanbus.DATA[272] - 1;
                    if (value9 < 0) {
                        value9 = 2;
                    }
                    setCarInfo2(1, value9, 255, 255);
                    break;
                case R.id.btn_plus1 /* 2131427458 */:
                    int value10 = DataCanbus.DATA[272] + 1;
                    if (value10 > 2) {
                        value10 = 0;
                    }
                    setCarInfo2(1, value10, 255, 255);
                    break;
                case R.id.btn_minus2 /* 2131427459 */:
                    int value11 = DataCanbus.DATA[273] - 1;
                    if (value11 < 0) {
                        value11 = 1;
                    }
                    setCarInfo2(2, value11, 255, 255);
                    break;
                case R.id.btn_plus2 /* 2131427461 */:
                    int value12 = DataCanbus.DATA[273] + 1;
                    if (value12 > 1) {
                        value12 = 0;
                    }
                    setCarInfo2(2, value12, 255, 255);
                    break;
                case R.id.btn_minus3 /* 2131427462 */:
                    int value13 = DataCanbus.DATA[274];
                    if (value13 > 0) {
                        value13--;
                    }
                    setCarInfo2(3, value13, 255, 255);
                    break;
                case R.id.btn_plus3 /* 2131427464 */:
                    int value14 = DataCanbus.DATA[274];
                    if (value14 < 200) {
                        value14++;
                    }
                    setCarInfo2(3, value14, 255, 255);
                    break;
                case R.id.btn_minus4 /* 2131427465 */:
                    int value15 = DataCanbus.DATA[275];
                    if (value15 > 0) {
                        value15--;
                    }
                    setCarInfo2(4, value15, 255, 255);
                    break;
                case R.id.btn_plus4 /* 2131427467 */:
                    int value16 = DataCanbus.DATA[275];
                    if (value16 < 200) {
                        value16++;
                    }
                    setCarInfo2(4, value16, 255, 255);
                    break;
                case R.id.ctv_checkedtext1 /* 2131427554 */:
                    setCarInfo2(5, DataCanbus.DATA[276] == 1 ? 0 : 1, 255, 255);
                    break;
            }
        }
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value17 = DataCanbus.DATA[153] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo2(1, value17, 255, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value18 = DataCanbus.DATA[153] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo2(1, value18, 255, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value19 = DataCanbus.DATA[154] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo2(2, value19, 255, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value20 = DataCanbus.DATA[154] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo2(2, value20, 255, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value21 = DataCanbus.DATA[155];
                if (value21 > 0) {
                    value21--;
                }
                setCarInfo2(3, value21, 255, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value22 = DataCanbus.DATA[155];
                if (value22 < 200) {
                    value22++;
                }
                setCarInfo2(3, value22, 255, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value23 = DataCanbus.DATA[156];
                if (value23 > 0) {
                    value23--;
                }
                setCarInfo2(4, value23, 255, 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value24 = DataCanbus.DATA[156];
                if (value24 < 200) {
                    value24++;
                }
                setCarInfo2(4, value24, 255, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(12, DataCanbus.DATA[152] == 1 ? 0 : 1, 255, 255);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        if ((DataCanbus.DATA[1000] & 65535) == 294) {
            DataCanbus.PROXY.cmd(37, new int[]{value0, value1, value2, value3}, null, null);
        } else {
            DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
        }
    }

    public void setCarInfo2(int value0, int value1, int value2, int value3) {
        if ((DataCanbus.DATA[1000] & 65535) == 294) {
            DataCanbus.PROXY.cmd(36, new int[]{value0, value1, value2, value3}, null, null);
        } else if ((DataCanbus.DATA[1000] & 65535) == 372) {
            DataCanbus.PROXY.cmd(36, new int[]{value0, value1, value2, value3}, null, null);
        } else {
            DataCanbus.PROXY.cmd(3, new int[]{value0, value1, value2, value3}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if ((DataCanbus.DATA[1000] & 65535) == 294) {
            DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[214].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[215].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[216].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        if ((DataCanbus.DATA[1000] & 65535) == 372) {
            DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if ((DataCanbus.DATA[1000] & 65535) == 294) {
            DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
            return;
        }
        if ((DataCanbus.DATA[1000] & 65535) == 372) {
            DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
    }
}
