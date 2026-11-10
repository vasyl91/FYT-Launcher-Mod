package com.syu.carinfo.lz.lexusis;

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
public class TangduLexusCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.TangduLexusCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 158:
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
                case 159:
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
                case 160:
                    TangduLexusCarSet.this.setCheck((CheckedTextView) TangduLexusCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 8);
                    break;
                case 161:
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
                case 162:
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
                case 163:
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
                case 164:
                    if (((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) TangduLexusCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 165:
                    TangduLexusCarSet.this.setCheck((CheckedTextView) TangduLexusCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 166:
                    TangduLexusCarSet.this.setCheck((CheckedTextView) TangduLexusCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 168:
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
                case 169:
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
                case 170:
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
                case 171:
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
            case R.id.btn_minus1 /* 2131427456 */:
                int value2 = DataCanbus.DATA[158];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value3 = DataCanbus.DATA[158];
                if (value3 < 12) {
                    value3++;
                }
                setAmpCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value4 = DataCanbus.DATA[159];
                if (value4 > 0) {
                    value4--;
                }
                setAmpCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value5 = DataCanbus.DATA[159];
                if (value5 < 12) {
                    value5++;
                }
                setAmpCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value6 = DataCanbus.DATA[161];
                if (value6 > 0) {
                    value6--;
                }
                setAmpCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value7 = DataCanbus.DATA[161];
                if (value7 < 12) {
                    value7++;
                }
                setAmpCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value8 = DataCanbus.DATA[163];
                if (value8 > 0) {
                    value8--;
                }
                setAmpCarInfo(6, value8);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value9 = DataCanbus.DATA[163];
                if (value9 < 12) {
                    value9++;
                }
                setAmpCarInfo(6, value9);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value10 = DataCanbus.DATA[162];
                if (value10 > 0) {
                    value10--;
                }
                setAmpCarInfo(5, value10);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value11 = DataCanbus.DATA[162];
                if (value11 < 12) {
                    value11++;
                }
                setAmpCarInfo(5, value11);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value12 = DataCanbus.DATA[164];
                if (value12 > 0) {
                    value12--;
                }
                setAmpCarInfo(7, value12);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value13 = DataCanbus.DATA[164];
                if (value13 < 63) {
                    value13++;
                }
                setAmpCarInfo(7, value13);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value14 = DataCanbus.DATA[168] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(2, value14);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value15 = DataCanbus.DATA[168] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(2, value15);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value16 = DataCanbus.DATA[169] - 1;
                if (value16 < 0) {
                    value16 = 1;
                }
                setCarInfo(3, value16);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value17 = DataCanbus.DATA[169] + 1;
                if (value17 > 1) {
                    value17 = 0;
                }
                setCarInfo(3, value17);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value18 = DataCanbus.DATA[170] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo(4, value18);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value19 = DataCanbus.DATA[170] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo(4, value19);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[160] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setAmpCarInfo(3, value);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value20 = DataCanbus.DATA[171];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(5, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setAmpCarInfo(101, 1);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setAmpCarInfo(101, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value21 = DataCanbus.DATA[165];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setAmpCarInfo(96, value21);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value22 = DataCanbus.DATA[166];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setAmpCarInfo(97, value22);
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
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }
}
