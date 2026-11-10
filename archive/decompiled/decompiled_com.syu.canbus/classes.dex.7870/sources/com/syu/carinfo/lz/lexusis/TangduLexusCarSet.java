package com.syu.carinfo.lz.lexusis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class TangduLexusCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 176:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text1)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text1)).setText("F" + (7 - value));
                        } else if (value == 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 177:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (7 - value));
                        } else if (value == 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 178:
                    TangduLexusCarSet.this.setCheck((CheckedTextView) TangduLexusCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 8);
                    break;
                case 179:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                        } else if (value == 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 180:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                        } else if (value == 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 181:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                        } else if (value == 7) {
                            ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 182:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 183:
                    TangduLexusCarSet.this.setCheck((CheckedTextView) TangduLexusCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 184:
                    TangduLexusCarSet.this.setCheck((CheckedTextView) TangduLexusCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 186:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text7)).setText("2010");
                                break;
                            case 1:
                                ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text7)).setText("2016");
                                break;
                        }
                    }
                    break;
                case 187:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 188:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_244_als1);
                                break;
                            case 1:
                                ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_244_als2);
                                break;
                        }
                    }
                    break;
                case 189:
                    TangduLexusCarSet.this.setCheck((CheckedTextView) TangduLexusCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_td_lexuse_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value2 = DataCanbus.DATA[176];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value3 = DataCanbus.DATA[176];
                if (value3 < 12) {
                    value3++;
                }
                setAmpCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value4 = DataCanbus.DATA[177];
                if (value4 > 0) {
                    value4--;
                }
                setAmpCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value5 = DataCanbus.DATA[177];
                if (value5 < 12) {
                    value5++;
                }
                setAmpCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value6 = DataCanbus.DATA[179];
                if (value6 > 0) {
                    value6--;
                }
                setAmpCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value7 = DataCanbus.DATA[179];
                if (value7 < 12) {
                    value7++;
                }
                setAmpCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value8 = DataCanbus.DATA[181];
                if (value8 < 12) {
                    value8++;
                }
                setAmpCarInfo(6, value8);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value9 = DataCanbus.DATA[180];
                if (value9 < 12) {
                    value9++;
                }
                setAmpCarInfo(5, value9);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value10 = DataCanbus.DATA[182];
                if (value10 < 63) {
                    value10++;
                }
                setAmpCarInfo(7, value10);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value11 = DataCanbus.DATA[186] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(2, value11);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value12 = DataCanbus.DATA[187] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(3, value12);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value13 = DataCanbus.DATA[188] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(4, value13);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value14 = DataCanbus.DATA[181];
                if (value14 > 0) {
                    value14--;
                }
                setAmpCarInfo(6, value14);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value15 = DataCanbus.DATA[180];
                if (value15 > 0) {
                    value15--;
                }
                setAmpCarInfo(5, value15);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value16 = DataCanbus.DATA[182];
                if (value16 > 0) {
                    value16--;
                }
                setAmpCarInfo(7, value16);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value17 = DataCanbus.DATA[186] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(2, value17);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value18 = DataCanbus.DATA[187] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo(3, value18);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value19 = DataCanbus.DATA[188] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(4, value19);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                if (DataCanbus.DATA[178] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setAmpCarInfo(3, value);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value20 = DataCanbus.DATA[189];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(5, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                setAmpCarInfo(101, 1);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setAmpCarInfo(101, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value21 = DataCanbus.DATA[183];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setAmpCarInfo(96, value21);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value22 = DataCanbus.DATA[184];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setAmpCarInfo(97, value22);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, TangduLexusSettingsAct.class);
                    startActivity(intent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setAmpCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
    }
}
