package com.syu.carinfo.wc2.tata;

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
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZBMWMiniCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                case 8:
                    int hour = DataCanbus.DATA[7];
                    int min = DataCanbus.DATA[8];
                    if (hour == 255 && min == 255) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(hour) + "H" + min + "M");
                        break;
                    }
                case 9:
                case 10:
                    int hour2 = DataCanbus.DATA[9];
                    int min2 = DataCanbus.DATA[10];
                    if (hour2 == 65535 && min2 == 255) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(hour2) + "H" + min2 + "M");
                        break;
                    }
                case 11:
                    if (value == 65535) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 12:
                    if (value == 65535) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    }
                case 13:
                    if (value == 65535) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
                        break;
                    }
                case 14:
                    if (value == 65535) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 15:
                    if (value == 65535) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text14)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                        break;
                    }
                case 16:
                    if (value == 65535) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text15)).setText("----");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text15)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/h");
                        break;
                    }
                case 17:
                    LZBMWMiniCarSet.this.setCheck((CheckedTextView) LZBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 18:
                    LZBMWMiniCarSet.this.setCheck((CheckedTextView) LZBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 19:
                    if (value == 1) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text7)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                        break;
                    }
                case 20:
                    LZBMWMiniCarSet.this.setCheck((CheckedTextView) LZBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 21:
                    LZBMWMiniCarSet.this.setCheck((CheckedTextView) LZBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 22:
                    LZBMWMiniCarSet.this.setCheck((CheckedTextView) LZBMWMiniCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 23:
                    if (value == 1) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text8)).setText("mls");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text8)).setText("km");
                        break;
                    }
                case 24:
                    if (value == 1) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text9)).setText("℉");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text9)).setText("℃");
                        break;
                    }
                case 25:
                    if (value == 1) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_bogoo_bmw_time_format_1);
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text10)).setText(R.string.str_bogoo_bmw_time_format_0);
                        break;
                    }
                case 26:
                    if (value == 1) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text11)).setText("mpg(us)");
                        break;
                    } else if (value == 2) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text11)).setText("mpg(uk)");
                        break;
                    } else if (value == 3) {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text11)).setText("km/L");
                        break;
                    } else {
                        ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text11)).setText("L/100km");
                        break;
                    }
                case 27:
                    ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value) + "s");
                    break;
                case 28:
                    ((TextView) LZBMWMiniCarSet.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + "km/h");
                    break;
                case 29:
                    LZBMWMiniCarSet.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_lz_oldmini_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZBMWMiniCarSet.this.language_set = position;
                if (LZBMWMiniCarSet.this.language_set >= 0 && LZBMWMiniCarSet.this.language_set <= LZBMWMiniCarSet.this.mLauStylelist.size() && LZBMWMiniCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{13, LZBMWMiniCarSet.this.send_lang[LZBMWMiniCarSet.this.language_set]}, null, null);
                }
                LZBMWMiniCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[29];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZBMWMiniCarSet.this.mLauStyle == null) {
                    LZBMWMiniCarSet.this.initLauStyle();
                }
                if (LZBMWMiniCarSet.this.mLauStyle != null && LZBMWMiniCarSet.this.mPopShowView != null) {
                    LZBMWMiniCarSet.this.mLauStyle.showAtLocation(LZBMWMiniCarSet.this.mPopShowView, 17, 0, 0);
                    LZBMWMiniCarSet.this.updateLauguageSet();
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[17];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(5, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[19] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(8, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[19] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(8, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[23] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[23] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(12, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[24] - 1;
                if (value6 < 0) {
                    value6 = 1;
                }
                setCarInfo(15, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[24] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                setCarInfo(15, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[25] - 1;
                if (value8 < 0) {
                    value8 = 1;
                }
                setCarInfo(16, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[25] + 1;
                if (value9 > 1) {
                    value9 = 0;
                }
                setCarInfo(16, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[26] - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                setCarInfo(14, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[26] + 1;
                if (value11 > 3) {
                    value11 = 0;
                }
                setCarInfo(14, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[27] - 10;
                if (value12 < 0) {
                    value12 = 0;
                }
                setCarInfo(6, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[27] + 10;
                if (value13 > 240) {
                    value13 = 240;
                }
                setCarInfo(6, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[28] - 5;
                if (value14 < 6) {
                    value14 = 6;
                }
                if (value14 > 335) {
                    value14 = 335;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, (value14 >> 8) & 255, value14 & 255}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[28] + 5;
                if (value15 < 6) {
                    value15 = 6;
                }
                if (value15 > 335) {
                    value15 = 335;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, (value15 >> 8) & 255, value15 & 255}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value16 = DataCanbus.DATA[18];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(7, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value17 = DataCanbus.DATA[20];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(9, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value18 = DataCanbus.DATA[21];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(10, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value19 = DataCanbus.DATA[22];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(11, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZBMWMiniTireAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                dialog(R.string.str_journey_computer, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                dialog(R.string.str_416_reset_tire, 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                dialog(R.string.str_speed_reset, 2);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                dialog(R.string.str_fuel_reset, 3);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniCarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{52}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
    }
}
