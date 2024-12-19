package com.syu.carinfo.rzc.feiyate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcFeiyateSetFunc extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.feiyate.RzcFeiyateSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 28:
                    RzcFeiyateSetFunc.this.updateText1(val);
                    break;
                case 29:
                    RzcFeiyateSetFunc.this.updateText2(val);
                    break;
                case 30:
                    RzcFeiyateSetFunc.this.updateText3(val);
                    break;
                case 31:
                    RzcFeiyateSetFunc.this.updateText4(val);
                    break;
                case 32:
                    RzcFeiyateSetFunc.this.updateText5(val);
                    break;
                case 33:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 34:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 35:
                    RzcFeiyateSetFunc.this.updateText9(val);
                    break;
                case 36:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 37:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 38:
                    RzcFeiyateSetFunc.this.updateText6(val);
                    break;
                case 39:
                    RzcFeiyateSetFunc.this.updateText7(val);
                    break;
                case 40:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 41:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 42:
                    RzcFeiyateSetFunc.this.updateText8(val);
                    break;
                case 55:
                    RzcFeiyateSetFunc.this.updateText10(val);
                    break;
                case 56:
                    RzcFeiyateSetFunc.this.updateText11(val);
                    break;
                case 57:
                    RzcFeiyateSetFunc.this.updateText12(val);
                    break;
                case 58:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 59:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 60:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 61:
                    if (((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("0s");
                                break;
                            case 1:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("60s");
                                break;
                            case 3:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text13)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 62:
                    if (((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text14)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text14)).setText("Driver door");
                                break;
                            case 1:
                                ((TextView) RzcFeiyateSetFunc.this.findViewById(R.id.tv_text14)).setText("All doors");
                                break;
                        }
                    }
                    break;
                case 63:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 64:
                    RzcFeiyateSetFunc.this.setCheck((CheckedTextView) RzcFeiyateSetFunc.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_feiyate_setfunc);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.feiyate.RzcFeiyateSetFunc.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RzcFeiyateSetFunc.this.language_set = position;
                if (RzcFeiyateSetFunc.this.language_set >= 0 && RzcFeiyateSetFunc.this.language_set <= RzcFeiyateSetFunc.this.mLauStylelist.size() && RzcFeiyateSetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{0, RzcFeiyateSetFunc.this.send_lang[RzcFeiyateSetFunc.this.language_set]}, null, null);
                }
                RzcFeiyateSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_39));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 13};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.feiyate.RzcFeiyateSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RzcFeiyateSetFunc.this.mLauStyle == null) {
                    RzcFeiyateSetFunc.this.initLauStyle();
                }
                if (RzcFeiyateSetFunc.this.mLauStyle != null && RzcFeiyateSetFunc.this.mPopShowView != null) {
                    RzcFeiyateSetFunc.this.mLauStyle.showAtLocation(RzcFeiyateSetFunc.this.mPopShowView, 17, 0, 0);
                    RzcFeiyateSetFunc.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value6 = DataCanbus.DATA[61] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(21, value6);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value7 = DataCanbus.DATA[61] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(21, value7);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value8 = DataCanbus.DATA[62] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(33, value8);
                break;
            case R.id.btn_plus14 /* 2131427473 */:
                int value9 = DataCanbus.DATA[62] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(33, value9);
                break;
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value10 = DataCanbus.DATA[33];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(16, value10);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value11 = DataCanbus.DATA[28];
                if (value11 == 9) {
                    value5 = 7;
                } else {
                    value5 = value11 - 1;
                    if (value5 < 0) {
                        value5 = 9;
                    }
                }
                setCarInfo(0, value5);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value12 = DataCanbus.DATA[29] + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                setCarInfo(1, value12);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                if (DataCanbus.DATA[30] == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                if (DataCanbus.DATA[30] == 1) {
                    value3 = 0;
                } else {
                    value3 = 1;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value13 = DataCanbus.DATA[31] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(3, value13);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value14 = DataCanbus.DATA[31] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(3, value14);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value15 = DataCanbus.DATA[32] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(4, value15);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value16 = DataCanbus.DATA[32] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(4, value16);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value17 = DataCanbus.DATA[38] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(48, value17);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value18 = DataCanbus.DATA[38] + 1;
                if (value18 > 1) {
                    value18 = 0;
                }
                setCarInfo(48, value18);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value19 = DataCanbus.DATA[39] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(49, value19);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value20 = DataCanbus.DATA[39] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(49, value20);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value21 = DataCanbus.DATA[42] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(244, value21);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value22 = DataCanbus.DATA[42] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(244, value22);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value23 = DataCanbus.DATA[35];
                if (DataCanbus.DATA[1000] == 393255) {
                    if (value23 == 2) {
                        value2 = 0;
                    } else {
                        value2 = value23 - 1;
                        if (value2 < 0) {
                            value2 = 4;
                        }
                    }
                } else {
                    value2 = value23 - 1;
                    if (value2 < 0) {
                        value2 = 1;
                    }
                }
                setCarInfo(18, value2);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value24 = DataCanbus.DATA[35];
                if (DataCanbus.DATA[1000] == 393255) {
                    if (value24 == 0) {
                        value = 2;
                    } else {
                        value = value24 + 1;
                        if (value > 4) {
                            value = 0;
                        }
                    }
                } else {
                    value = value24 + 1;
                    if (value > 1) {
                        value = 0;
                    }
                }
                setCarInfo(18, value);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value25 = DataCanbus.DATA[55] - 1;
                if (value25 < 0) {
                    value25 = 2;
                }
                setCarInfo(20, value25);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value26 = DataCanbus.DATA[55] + 1;
                if (value26 > 2) {
                    value26 = 0;
                }
                setCarInfo(20, value26);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value27 = DataCanbus.DATA[56] - 1;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(50, value27);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value28 = DataCanbus.DATA[56] + 1;
                if (value28 > 2) {
                    value28 = 0;
                }
                setCarInfo(50, value28);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value29 = DataCanbus.DATA[57] - 1;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(51, value29);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value30 = DataCanbus.DATA[57] + 1;
                if (value30 > 2) {
                    value30 = 0;
                }
                setCarInfo(51, value30);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value31 = DataCanbus.DATA[34];
                if (value31 == 0) {
                    value31 = 1;
                } else if (value31 == 1) {
                    value31 = 0;
                }
                setCarInfo(17, value31);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value32 = DataCanbus.DATA[36];
                if (value32 == 0) {
                    value32 = 1;
                } else if (value32 == 1) {
                    value32 = 0;
                }
                setCarInfo(19, value32);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value33 = DataCanbus.DATA[37];
                if (value33 == 0) {
                    value33 = 1;
                } else if (value33 == 1) {
                    value33 = 0;
                }
                setCarInfo(32, value33);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value34 = DataCanbus.DATA[40];
                if (value34 == 0) {
                    value34 = 1;
                } else if (value34 == 1) {
                    value34 = 0;
                }
                setCarInfo(240, value34);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value35 = DataCanbus.DATA[41];
                if (value35 == 0) {
                    value35 = 1;
                } else if (value35 == 1) {
                    value35 = 0;
                }
                setCarInfo(243, value35);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value36 = DataCanbus.DATA[58];
                if (value36 == 0) {
                    value36 = 1;
                } else if (value36 == 1) {
                    value36 = 0;
                }
                setCarInfo(52, value36);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value37 = DataCanbus.DATA[59];
                if (value37 == 0) {
                    value37 = 1;
                } else if (value37 == 1) {
                    value37 = 0;
                }
                setCarInfo(53, value37);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value38 = DataCanbus.DATA[60];
                if (value38 == 0) {
                    value38 = 1;
                } else if (value38 == 1) {
                    value38 = 0;
                }
                setCarInfo(54, value38);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value39 = DataCanbus.DATA[63];
                if (value39 == 0) {
                    value39 = 1;
                } else if (value39 == 1) {
                    value39 = 0;
                }
                setCarInfo(55, value39);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value40 = DataCanbus.DATA[64];
                if (value40 == 0) {
                    value40 = 1;
                } else if (value40 == 1) {
                    value40 = 0;
                }
                setCarInfo(56, value40);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64, 255}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText12(int value) {
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Near");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Med");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text12)).setText("Far");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText11(int value) {
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text11)).setText("OFF");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Only Act.Braking");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text11)).setText("Warn+Act.Brk");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText10(int value) {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text10)).setText("1");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText("2");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText("3");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText9(int value) {
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText("Off");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText("On");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text9)).setText("60s");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text9)).setText("90s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText8(int value) {
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type1");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type2");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText("Type3");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText7(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Low");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText("Med");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText("High");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6(int value) {
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Sound");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("Sound Display");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5(int value) {
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Imperial");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("Custom");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("℃");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("℉");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Km");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText("Mil");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text2)).setText("Km/L");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("L/100Km");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("MPG(UK)");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("MPG(US)");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1(int value) {
        if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_21);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_15);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_10);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_35);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_14);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_29);
                    break;
                case 6:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_27);
                    break;
                case 7:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_9);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_28);
                    break;
                case 9:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_39);
                    break;
                case 13:
                    ((TextView) findViewById(R.id.lauguage_set_curr)).setText(R.string.rzc_others_language_setting_31);
                    break;
            }
        }
    }
}
