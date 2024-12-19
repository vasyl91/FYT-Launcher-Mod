package com.syu.carinfo.ford;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class FordCarSet_XP extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarSet_XP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text1)).setText("℉");
                            break;
                        } else {
                            ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text1)).setText("℃");
                            break;
                        }
                    }
                    break;
                case 103:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 105:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 106:
                    if (((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                            break;
                        } else {
                            ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                            break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text2)).setText("MILE");
                            break;
                        } else {
                            ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text2)).setText("KM");
                            break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text4)).setText(R.string.xp_ylford_set_voice_mode1);
                                break;
                            case 2:
                                ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text4)).setText(R.string.xp_ylford_set_voice_mode2);
                                break;
                            case 3:
                                ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text4)).setText(R.string.xp_ylford_set_voice_mode3);
                                break;
                            case 4:
                                ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_auto);
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text3)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                                break;
                            case 1:
                                ((TextView) FordCarSet_XP.this.findViewById(R.id.tv_text3)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                                break;
                        }
                    }
                    break;
                case 110:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 112:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 117:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 118:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 119:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 120:
                    FordCarSet_XP.this.setCheck((CheckedTextView) FordCarSet_XP.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 121:
                    FordCarSet_XP.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_ford_focus_carset);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_XP.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                FordCarSet_XP.this.language_set = position;
                if (FordCarSet_XP.this.language_set >= 0 && FordCarSet_XP.this.language_set <= FordCarSet_XP.this.mLauStylelist.size() && FordCarSet_XP.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{164, FordCarSet_XP.this.send_lang[FordCarSet_XP.this.language_set]}, null, null);
                }
                FordCarSet_XP.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[121];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 18, 22, 23, 27, 28};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_XP.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FordCarSet_XP.this.mLauStyle == null) {
                    FordCarSet_XP.this.initLauStyle();
                }
                if (FordCarSet_XP.this.mLauStyle != null && FordCarSet_XP.this.mPopShowView != null) {
                    FordCarSet_XP.this.mLauStyle.showAtLocation(FordCarSet_XP.this.mPopShowView, 17, 0, 0);
                    FordCarSet_XP.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        int value12;
        int value13;
        int value14;
        int value15;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value16 = DataCanbus.DATA[103];
                if (value16 == 1) {
                    value15 = 2;
                } else {
                    value15 = 1;
                }
                setCarInfo(163, value15);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
            case R.id.btn_plus1 /* 2131427482 */:
                int value17 = DataCanbus.DATA[37];
                if (value17 == 1) {
                    value6 = 0;
                } else {
                    value6 = 1;
                }
                setCarInfo(160, value6);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
            case R.id.btn_plus2 /* 2131427486 */:
                int value18 = DataCanbus.DATA[107];
                if (value18 == 1) {
                    value5 = 14;
                } else {
                    value5 = 15;
                }
                setCarInfo(163, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
            case R.id.btn_plus3 /* 2131427490 */:
                int value19 = DataCanbus.DATA[109];
                if (value19 == 1) {
                    value4 = 3;
                } else {
                    value4 = 4;
                }
                setCarInfo(163, value4);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value20 = DataCanbus.DATA[108];
                if (value20 == 0) {
                    value3 = 10;
                } else if (value20 == 1) {
                    value3 = 11;
                } else if (value20 == 2) {
                    value3 = 12;
                } else if (value20 == 3) {
                    value3 = 13;
                } else if (value20 == 4) {
                    value3 = 9;
                } else {
                    value3 = 9;
                }
                setCarInfo(163, value3);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value21 = DataCanbus.DATA[108];
                if (value21 == 0) {
                    value2 = 13;
                } else if (value21 == 1) {
                    value2 = 9;
                } else if (value21 == 2) {
                    value2 = 10;
                } else if (value21 == 3) {
                    value2 = 11;
                } else if (value21 == 4) {
                    value2 = 12;
                } else {
                    value2 = 13;
                }
                setCarInfo(163, value2);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
            case R.id.btn_plus5 /* 2131427498 */:
                int value22 = DataCanbus.DATA[106];
                if (value22 == 1) {
                    value = 16;
                } else {
                    value = 17;
                }
                setCarInfo(163, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value23 = DataCanbus.DATA[104];
                if (value23 == 1) {
                    value14 = 5;
                } else {
                    value14 = 6;
                }
                setCarInfo(163, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value24 = DataCanbus.DATA[105];
                if (value24 == 1) {
                    value13 = 7;
                } else {
                    value13 = 8;
                }
                setCarInfo(163, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value25 = DataCanbus.DATA[112];
                if (value25 == 1) {
                    value12 = 0;
                } else {
                    value12 = 1;
                }
                setCarInfo(165, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value26 = DataCanbus.DATA[110];
                if (value26 == 1) {
                    value11 = 0;
                } else {
                    value11 = 1;
                }
                setCarInfo(166, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value27 = DataCanbus.DATA[117];
                if (value27 == 1) {
                    value10 = 0;
                } else {
                    value10 = 1;
                }
                setCarInfo(167, value10);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value28 = DataCanbus.DATA[118];
                if (value28 == 1) {
                    value9 = 0;
                } else {
                    value9 = 1;
                }
                setCarInfo(168, value9);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value29 = DataCanbus.DATA[119];
                if (value29 == 1) {
                    value8 = 0;
                } else {
                    value8 = 1;
                }
                setCarInfo(173, value8);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value30 = DataCanbus.DATA[120];
                if (value30 == 1) {
                    value7 = 18;
                } else {
                    value7 = 19;
                }
                setCarInfo(171, value7);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                dialog(R.string.xp_ylford_set_tyre_monitor, 169);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_XP.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.ford.FordCarSet_XP.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.FordCarSet_XP.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{36}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }
}
