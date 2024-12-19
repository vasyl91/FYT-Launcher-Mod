package com.syu.carinfo.rzc.sanlin;

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
public class RZCVinFastPlusCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText("Light");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText("Horn");
                                break;
                            case 3:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText("Both");
                                break;
                        }
                    }
                    break;
                case 87:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("5s");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("10s");
                                break;
                            case 3:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 4:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("20s");
                                break;
                            case 5:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("25s");
                                break;
                        }
                    }
                    break;
                case 88:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 89:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("60s");
                                break;
                            case 3:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("90s");
                                break;
                            case 4:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 90:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 91:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 92:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 93:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value * 10) + "km/h");
                        break;
                    }
                case 94:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 95:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 96:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 97:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 98:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 99:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 100:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 101:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text7)).setText("ECO");
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text7)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 102:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)).setText("Off");
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)).setText("Low");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)).setText("High");
                                break;
                        }
                    }
                    break;
                case 103:
                    RZCVinFastPlusCarSet.this.updateLauguageSet();
                    break;
                case 104:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 105:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                        break;
                    }
                case 106:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_rzc_vinfast_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RZCVinFastPlusCarSet.this.language_set = position;
                if (RZCVinFastPlusCarSet.this.language_set >= 0 && RZCVinFastPlusCarSet.this.language_set <= RZCVinFastPlusCarSet.this.mLauStylelist.size() && RZCVinFastPlusCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{48, RZCVinFastPlusCarSet.this.send_lang[RZCVinFastPlusCarSet.this.language_set]}, null, null);
                }
                RZCVinFastPlusCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[103];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("Viet Nam");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.RZCVinFastPlusCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RZCVinFastPlusCarSet.this.mLauStyle == null) {
                    RZCVinFastPlusCarSet.this.initLauStyle();
                }
                if (RZCVinFastPlusCarSet.this.mLauStyle != null && RZCVinFastPlusCarSet.this.mPopShowView != null) {
                    RZCVinFastPlusCarSet.this.mLauStyle.showAtLocation(RZCVinFastPlusCarSet.this.mPopShowView, 17, 0, 0);
                    RZCVinFastPlusCarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[88];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[86] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[86] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[87] - 1;
                if (value4 < 0) {
                    value4 = 5;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[87] + 1;
                if (value5 > 5) {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[89] - 1;
                if (value6 < 0) {
                    value6 = 4;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[89] + 1;
                if (value7 > 4) {
                    value7 = 0;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[93];
                if (value8 > 4) {
                    value8--;
                }
                if (value8 < 4) {
                    value8 = 4;
                }
                setCarInfo(8, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[93];
                if (value9 < 12) {
                    value9++;
                }
                if (value9 < 4) {
                    value9 = 4;
                }
                setCarInfo(8, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[101] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(33, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[101] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(33, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[102] - 1;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(34, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[102] + 1;
                if (value13 > 2) {
                    value13 = 0;
                }
                setCarInfo(34, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[104];
                if (value14 < 0) {
                    value14--;
                }
                setCarInfo(49, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[104];
                if (value15 < 14) {
                    value15++;
                }
                setCarInfo(49, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value16 = DataCanbus.DATA[90];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(5, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value17 = DataCanbus.DATA[91];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(6, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value18 = DataCanbus.DATA[92];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(7, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value19 = DataCanbus.DATA[94];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(16, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value20 = DataCanbus.DATA[95];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(17, value20);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value21 = DataCanbus.DATA[96];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(18, value21);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value22 = DataCanbus.DATA[97];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(19, value22);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value23 = DataCanbus.DATA[98];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(20, value23);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value24 = DataCanbus.DATA[99];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(21, value24);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value25 = DataCanbus.DATA[100];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(32, value25);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{38}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }
}
