package com.syu.carinfo.qiya.kx7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityWCHongqiH7Set extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCHongqiH7Set.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text1)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text1)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text1)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 99:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    break;
                case 100:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
                case 101:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                    break;
                case 102:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                    break;
                case 103:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                    break;
                case 104:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            default:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 107:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 116:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    break;
                case 117:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text6)).setText(R.string.str_driving_eco);
                                break;
                        }
                    }
                    break;
                case 118:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text7)).setText("15%");
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text7)).setText("20%");
                                break;
                            case 2:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text7)).setText("25%");
                                break;
                            case 3:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text7)).setText("30%");
                                break;
                            case 4:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text7)).setText("35%");
                                break;
                            case 5:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text7)).setText("40%");
                                break;
                        }
                    }
                    break;
                case 119:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    break;
                case 120:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text8)).setText(R.string.wc_golf_comfort);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text8)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text8)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 121:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    break;
                case 122:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    break;
                case 123:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_mid);
                                break;
                            case 2:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_low);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_mid);
                                break;
                        }
                    }
                    break;
                case 125:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                    break;
                case 126:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                    break;
                case 127:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    break;
                case 128:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text11)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 129:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
                    break;
                case 130:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
                    break;
                case 131:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text12)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text12)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_auto);
                                break;
                            case 2:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text12)).setText(R.string.wc_ruiteng_string_near_light);
                                break;
                            case 3:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text12)).setText(R.string.str_position_lamp);
                                break;
                        }
                    }
                    break;
                case 132:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext19)).setChecked(value != 0);
                    break;
                case 134:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    break;
                case 135:
                    ((CheckedTextView) ActivityWCHongqiH7Set.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
                    break;
                case 136:
                    if (((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text13)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ActivityWCHongqiH7Set.this.findViewById(R.id.tv_text13)).setText("60s");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0444_wc_hongqi_h7_set);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCHongqiH7Set.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ActivityWCHongqiH7Set.this.language_set = position;
                if (ActivityWCHongqiH7Set.this.language_set >= 0 && ActivityWCHongqiH7Set.this.language_set <= ActivityWCHongqiH7Set.this.mLauStylelist.size() && ActivityWCHongqiH7Set.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(3, new int[]{1, ActivityWCHongqiH7Set.this.send_lang[ActivityWCHongqiH7Set.this.language_set]}, null, null);
                }
                ActivityWCHongqiH7Set.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.send_lang = new int[]{1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCHongqiH7Set.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ActivityWCHongqiH7Set.this.mLauStyle == null) {
                    ActivityWCHongqiH7Set.this.initLauStyle();
                }
                if (ActivityWCHongqiH7Set.this.mLauStyle != null && ActivityWCHongqiH7Set.this.mPopShowView != null) {
                    ActivityWCHongqiH7Set.this.mLauStyle.showAtLocation(ActivityWCHongqiH7Set.this.mPopShowView, 17, 0, 0);
                    ActivityWCHongqiH7Set.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setOnClickListener(this);
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
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(this);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCHongqiH7Set.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCHongqiH7Set.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityWCHongqiH7Set.this.setCmd(i, 1, 255);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCHongqiH7Set.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCHongqiH7Set.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityWCHongqiH7Set.this.setCmd(i, 0, 255);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCmd(1, value, 255);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCmd(1, value2, 255);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[104] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCmd(4, value3, 255);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[104] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCmd(4, value4, 255);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[105] - 10;
                if (value5 > 0 && value5 < 30) {
                    value5 = 0;
                } else if (value5 < 0) {
                    value5 = 220;
                }
                setCmd(8, value5, 255);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[105] + 10;
                if (value6 > 0 && value6 < 30) {
                    value6 = 30;
                } else if (value6 > 220) {
                    value6 = 0;
                }
                setCmd(8, value6, 255);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[106] - 1;
                if (value7 < 0) {
                    value7 = 0;
                }
                setCmd(10, (value7 >> 8) & 255, value7 & 255);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[106] + 1;
                if (value8 > 220) {
                    value8 = 0;
                }
                setCmd(10, (value8 >> 8) & 255, value8 & 255);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[107] - 1;
                if (value9 < 0) {
                    value9 = 0;
                }
                setCmd(11, (value9 >> 8) & 255, value9 & 255);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[107] + 1;
                if (value10 > 500) {
                    value10 = Callback_0374_XP1_ZiYouGuang.U_CARSET_D49_D0_B54;
                }
                setCmd(11, (value10 >> 8) & 255, value10 & 255);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[117] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCmd(13, value11, 255);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[117] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCmd(13, value12, 255);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[118] - 1;
                if (value13 < 0) {
                    value13 = 5;
                }
                setCmd(12, value13, 255);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[118] + 1;
                if (value14 > 5) {
                    value14 = 0;
                }
                setCmd(12, value14, 255);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[120] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCmd(15, value15, 255);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[120] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCmd(15, value16, 255);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[123] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCmd(20, value17, 255);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[123] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCmd(20, value18, 255);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[124] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCmd(19, value19, 255);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[124] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCmd(19, value20, 255);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[128] - 1;
                if (value21 < 1) {
                    value21 = 5;
                }
                setCmd(31, value21, 255);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[128] + 1;
                if (value22 > 5) {
                    value22 = 1;
                }
                setCmd(31, value22, 255);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[131] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                setCmd(33, value23, 255);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[131] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                setCmd(33, value24, 255);
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value25 = DataCanbus.DATA[136] - 1;
                if (value25 < 0) {
                    value25 = 3;
                }
                setCmd(35, value25, 255);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value26 = DataCanbus.DATA[136] + 1;
                if (value26 > 3) {
                    value26 = 0;
                }
                setCmd(35, value26, 255);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCmd(2, DataCanbus.DATA[99] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCmd(6, DataCanbus.DATA[102] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCmd(5, DataCanbus.DATA[103] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCmd(1, DataCanbus.DATA[100] == 0 ? 1 : 0, 255);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCmd(7, DataCanbus.DATA[101] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ActivityWCHongqiH7SetTireAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCmd(9, DataCanbus.DATA[116] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCmd(14, DataCanbus.DATA[119] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCmd(22, DataCanbus.DATA[121] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCmd(21, DataCanbus.DATA[122] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCmd(18, DataCanbus.DATA[125] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCmd(17, DataCanbus.DATA[126] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCmd(16, DataCanbus.DATA[127] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCmd(32, DataCanbus.DATA[129] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                dialog(R.string.xp_yinglang_car_set_Second_str10, 38);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCmd(34, DataCanbus.DATA[130] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCmd(36, DataCanbus.DATA[135] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCmd(37, DataCanbus.DATA[134] != 0 ? 0 : 1, 255);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                setCmd(39, DataCanbus.DATA[132] != 0 ? 0 : 1, 255);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCmd(int type, int value, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{type, value, value1, 255}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{97}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
    }
}
