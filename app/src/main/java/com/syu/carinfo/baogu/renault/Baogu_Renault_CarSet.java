package com.syu.carinfo.baogu.renault;

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
public class Baogu_Renault_CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private int type = 0;
    private int[] iResetString = {R.string.bsd_klj_str13, R.string.bsd_klj_str14, R.string.bsd_klj_str15, R.string.bsd_klj_str16, R.string.bsd_klj_str17};
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.baogu.renault.Baogu_Renault_CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 27:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_playstate11);
                                break;
                            case 1:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.stop_mode1_str);
                                break;
                            case 2:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.stop_mode2_str);
                                break;
                            case 3:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.stop_mode3_str);
                                break;
                        }
                    }
                    break;
                case 28:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 29:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 30:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 31:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 32:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 33:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 34:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.rzc_zhenglizi_str);
                                break;
                            case 2:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.rzc_fulizi_str);
                                break;
                        }
                    }
                    break;
                case 35:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 36:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 37:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 38:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 39:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 40:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 41:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_volumestr1);
                                break;
                            case 2:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_volumestr2);
                                break;
                            case 3:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_372_volumestr3);
                                break;
                        }
                    }
                    break;
                case 43:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_4);
                                break;
                            case 1:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_4);
                                break;
                            case 2:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_3);
                                break;
                            case 3:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_5);
                                break;
                            case 4:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_6);
                                break;
                            case 5:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 44:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 45:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 46:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 47:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 48:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 49:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 50:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 51:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_4);
                                break;
                            case 1:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_3);
                                break;
                            case 2:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_5);
                                break;
                            case 3:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_6);
                                break;
                            case 4:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_403_ambient_1);
                                break;
                        }
                    }
                    break;
                case 52:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 53:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 54:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text10)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 55:
                    if (((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) Baogu_Renault_CarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 56:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 57:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 58:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 59:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 60:
                    Baogu_Renault_CarSet.this.setCheck((CheckedTextView) Baogu_Renault_CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_baogu_renault_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.baogu.renault.Baogu_Renault_CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Baogu_Renault_CarSet.this.language_set = position;
                if (Baogu_Renault_CarSet.this.language_set >= 0 && Baogu_Renault_CarSet.this.language_set <= Baogu_Renault_CarSet.this.mLauStylelist.size() && Baogu_Renault_CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{13, Baogu_Renault_CarSet.this.send_lang[Baogu_Renault_CarSet.this.language_set]}, null, null);
                }
                Baogu_Renault_CarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.baogu.renault.Baogu_Renault_CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Baogu_Renault_CarSet.this.mLauStyle == null) {
                    Baogu_Renault_CarSet.this.initLauStyle();
                }
                if (Baogu_Renault_CarSet.this.mLauStyle != null && Baogu_Renault_CarSet.this.mPopShowView != null) {
                    Baogu_Renault_CarSet.this.mLauStyle.showAtLocation(Baogu_Renault_CarSet.this.mPopShowView, 17, 0, 0);
                    Baogu_Renault_CarSet.this.updateLauguageSet();
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
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
    }

    protected void postConfirmDialog(final int type) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(this.iResetString[type - 1]).setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.baogu.renault.Baogu_Renault_CarSet.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    int value = type;
                    if (value > 0) {
                        DataCanbus.PROXY.cmd(0, new int[]{128, value}, null, null);
                    }
                }
            }).setNegativeButton(R.string.wc_psa_all_cancel, (DialogInterface.OnClickListener) null);
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[28];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(17, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[27] - 1;
                if (value2 < 1) {
                    value2 = 3;
                }
                setCarInfo(19, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[27] + 1;
                if (value3 > 3) {
                    value3 = 1;
                }
                setCarInfo(19, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[34] - 1;
                if (value4 < 0) {
                    value4 = 2;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[34] + 1;
                if (value5 > 2) {
                    value5 = 0;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[41] - 1;
                if (value6 < 1) {
                    value6 = 3;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[41] + 1;
                if (value7 > 3) {
                    value7 = 1;
                }
                setCarInfo(7, value7);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value8 = DataCanbus.DATA[43] - 1;
                if (value8 < 1) {
                    value8 = 5;
                }
                setCarInfo(16, value8);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value9 = DataCanbus.DATA[43] + 1;
                if (value9 > 5) {
                    value9 = 1;
                }
                setCarInfo(16, value9);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value10 = DataCanbus.DATA[44] - 1;
                if (value10 < 1) {
                    value10 = 4;
                }
                setCarInfo(14, value10);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value11 = DataCanbus.DATA[44] + 1;
                if (value11 > 4) {
                    value11 = 1;
                }
                setCarInfo(14, value11);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value12 = DataCanbus.DATA[45];
                if (value12 > 0) {
                    value12 -= 5;
                }
                setCarInfo(15, value12);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value13 = DataCanbus.DATA[45];
                if (value13 < 100) {
                    value13 += 5;
                }
                setCarInfo(15, value13);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value14 = DataCanbus.DATA[51] - 1;
                if (value14 < 0) {
                    value14 = 4;
                }
                setCarInfo(51, value14);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value15 = DataCanbus.DATA[51] + 1;
                if (value15 > 4) {
                    value15 = 0;
                }
                setCarInfo(51, value15);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value16 = DataCanbus.DATA[52];
                if (value16 > 0) {
                    value16 -= 5;
                }
                setCarInfo(52, value16);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value17 = DataCanbus.DATA[52];
                if (value17 < 100) {
                    value17 += 5;
                }
                setCarInfo(52, value17);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value18 = DataCanbus.DATA[54] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(65, value18);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value19 = DataCanbus.DATA[54] + 1;
                if (value19 > 2) {
                    value19 = 0;
                }
                setCarInfo(65, value19);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value20 = DataCanbus.DATA[55] - 1;
                if (value20 < 0) {
                    value20 = 4;
                }
                setCarInfo(66, value20);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value21 = DataCanbus.DATA[55] + 1;
                if (value21 > 4) {
                    value21 = 0;
                }
                setCarInfo(66, value21);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value22 = DataCanbus.DATA[29];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(18, value22);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value23 = DataCanbus.DATA[30];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(1, value23);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value24 = DataCanbus.DATA[31];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(2, value24);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value25 = DataCanbus.DATA[60];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(71, value25);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value26 = DataCanbus.DATA[32];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(3, value26);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value27 = DataCanbus.DATA[33];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(5, value27);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value28 = DataCanbus.DATA[35];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(12, value28);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value29 = DataCanbus.DATA[36];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(11, value29);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value30 = DataCanbus.DATA[37];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(10, value30);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value31 = DataCanbus.DATA[38];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(9, value31);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value32 = DataCanbus.DATA[39];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(8, value32);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value33 = DataCanbus.DATA[40];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarInfo(6, value33);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value34 = DataCanbus.DATA[46];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarInfo(32, value34);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value35 = DataCanbus.DATA[47];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(33, value35);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value36 = DataCanbus.DATA[48];
                if (value36 == 1) {
                    value36 = 0;
                } else if (value36 == 0) {
                    value36 = 1;
                }
                setCarInfo(48, value36);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value37 = DataCanbus.DATA[49];
                if (value37 == 1) {
                    value37 = 0;
                } else if (value37 == 0) {
                    value37 = 1;
                }
                setCarInfo(49, value37);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value38 = DataCanbus.DATA[50];
                if (value38 == 1) {
                    value38 = 0;
                } else if (value38 == 0) {
                    value38 = 1;
                }
                setCarInfo(50, value38);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value39 = DataCanbus.DATA[53];
                if (value39 == 1) {
                    value39 = 0;
                } else if (value39 == 0) {
                    value39 = 1;
                }
                setCarInfo(64, value39);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                int value40 = DataCanbus.DATA[56];
                if (value40 == 1) {
                    value40 = 0;
                } else if (value40 == 0) {
                    value40 = 1;
                }
                setCarInfo(67, value40);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value41 = DataCanbus.DATA[57];
                if (value41 == 1) {
                    value41 = 0;
                } else if (value41 == 0) {
                    value41 = 1;
                }
                setCarInfo(68, value41);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value42 = DataCanbus.DATA[58];
                if (value42 == 1) {
                    value42 = 0;
                } else if (value42 == 0) {
                    value42 = 1;
                }
                setCarInfo(69, value42);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                int value43 = DataCanbus.DATA[59];
                if (value43 == 1) {
                    value43 = 0;
                } else if (value43 == 0) {
                    value43 = 1;
                }
                setCarInfo(70, value43);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                postConfirmDialog(1);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                postConfirmDialog(2);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                postConfirmDialog(3);
                break;
            case R.id.ctv_checkedtext27 /* 2131427838 */:
                postConfirmDialog(4);
                break;
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                postConfirmDialog(5);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{0, 1}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
    }
}
