package com.syu.carinfo.rzc.xima;

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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class LZ_NissanInfinitiCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.LZ_NissanInfinitiCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 110:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 111:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value + 1).toString());
                    }
                    break;
                case 112:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("45s");
                                break;
                            case 3:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 4:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("90s");
                                break;
                            case 5:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                            case 6:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("150s");
                                break;
                            case 7:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text2)).setText("180s");
                                break;
                        }
                    }
                    break;
                case 113:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 114:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 115:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 116:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 117:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 118:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 119:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 120:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 121:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 122:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 123:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 127:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)).setText("Type3");
                                break;
                            case 3:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text6)).setText("Type4");
                                break;
                        }
                    }
                    break;
                case 129:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 130:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 131:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 132:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 143:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 144:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
                case 145:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 146:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 147:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 148:
                    LZ_NissanInfinitiCarSet.this.setCheck((CheckedTextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 149:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text7)).setText(CamryData.PRESSURE_UNIT_KPA);
                                break;
                            case 1:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text7)).setText(CamryData.PRESSURE_UNIT_PSI);
                                break;
                            case 2:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text7)).setText(CamryData.PRESSURE_UNIT_BAR);
                                break;
                            case 3:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text7)).setText("KGF/CM2");
                                break;
                        }
                    }
                    break;
                case 150:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text8)).setText("km/l");
                                break;
                            case 1:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text8)).setText("l/100km");
                                break;
                        }
                    }
                    break;
                case 151:
                    LZ_NissanInfinitiCarSet.this.updateLauguageSet();
                    break;
                case 152:
                    if (((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text9)).setText("Type1");
                                break;
                            case 1:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text9)).setText("Type2");
                                break;
                            case 2:
                                ((TextView) LZ_NissanInfinitiCarSet.this.findViewById(R.id.tv_text9)).setText("Type3");
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
        setContentView(R.layout.layout_0453_lz_nissaninfiniti_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_NissanInfinitiCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZ_NissanInfinitiCarSet.this.language_set = position;
                if (LZ_NissanInfinitiCarSet.this.language_set >= 0 && LZ_NissanInfinitiCarSet.this.language_set <= LZ_NissanInfinitiCarSet.this.mLauStylelist.size() && LZ_NissanInfinitiCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{27, LZ_NissanInfinitiCarSet.this.send_lang[LZ_NissanInfinitiCarSet.this.language_set], 0}, null, null);
                }
                LZ_NissanInfinitiCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[151];
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
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_0));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_3));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_NissanInfinitiCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZ_NissanInfinitiCarSet.this.mLauStyle == null) {
                    LZ_NissanInfinitiCarSet.this.initLauStyle();
                }
                if (LZ_NissanInfinitiCarSet.this.mLauStyle != null && LZ_NissanInfinitiCarSet.this.mPopShowView != null) {
                    LZ_NissanInfinitiCarSet.this.mLauStyle.showAtLocation(LZ_NissanInfinitiCarSet.this.mPopShowView, 17, 0, 0);
                    LZ_NissanInfinitiCarSet.this.updateLauguageSet();
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value = DataCanbus.DATA[111] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(6, value, 0);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value2 = DataCanbus.DATA[111] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(6, value2, 0);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value3 = DataCanbus.DATA[112] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setCarInfo(7, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value4 = DataCanbus.DATA[112] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setCarInfo(7, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value5 = DataCanbus.DATA[121] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(17, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value6 = DataCanbus.DATA[121] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(17, value6, 0);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value7 = DataCanbus.DATA[122] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(19, value7, 0);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value8 = DataCanbus.DATA[123] + 1;
                if (value8 > 3) {
                    value8 = 0;
                }
                setCarInfo(20, value8, 0);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value9 = DataCanbus.DATA[127] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(255, value9, 0);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value10 = DataCanbus.DATA[149] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(26, value10, 0);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value11 = DataCanbus.DATA[150] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(28, value11, 0);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value12 = DataCanbus.DATA[152] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(254, value12, 0);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value13 = DataCanbus.DATA[122] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(19, value13, 0);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value14 = DataCanbus.DATA[123] - 1;
                if (value14 < 0) {
                    value14 = 3;
                }
                setCarInfo(20, value14, 0);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value15 = DataCanbus.DATA[127] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                setCarInfo(255, value15, 0);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value16 = DataCanbus.DATA[149] - 1;
                if (value16 < 0) {
                    value16 = 3;
                }
                setCarInfo(26, value16, 0);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value17 = DataCanbus.DATA[150] - 1;
                if (value17 < 0) {
                    value17 = 1;
                }
                setCarInfo(28, value17, 0);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[152] - 1;
                if (value18 < 0) {
                    value18 = 2;
                }
                setCarInfo(254, value18, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427548 */:
                int value19 = DataCanbus.DATA[110];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(2, value19, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427552 */:
                int value20 = DataCanbus.DATA[115];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(12, value20, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427553 */:
                int value21 = DataCanbus.DATA[116];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(15, value21, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427558 */:
                int value22 = DataCanbus.DATA[113];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(8, value22, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427559 */:
                int value23 = DataCanbus.DATA[114];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(11, value23, 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427563 */:
                int value24 = DataCanbus.DATA[117];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(16, value24, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427564 */:
                int value25 = DataCanbus.DATA[118];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(21, value25, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427615 */:
                int value26 = DataCanbus.DATA[119];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(22, value26, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427616 */:
                int value27 = DataCanbus.DATA[120];
                if (value27 == 0) {
                    value27 = 1;
                } else if (value27 == 1) {
                    value27 = 0;
                }
                setCarInfo(23, value27, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427617 */:
                dialog(R.string.str_298_default_all, 255);
                break;
            case R.id.ctv_checkedtext11 /* 2131427618 */:
                int value28 = DataCanbus.DATA[129];
                if (value28 == 0) {
                    value28 = 1;
                } else if (value28 == 1) {
                    value28 = 0;
                }
                setCarInfo(0, value28, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427619 */:
                int value29 = DataCanbus.DATA[130];
                if (value29 == 0) {
                    value29 = 1;
                } else if (value29 == 1) {
                    value29 = 0;
                }
                setCarInfo(1, value29, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427620 */:
                setCarInfo(33, 0, 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427621 */:
                setCarInfo(34, 0, 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427622 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZ_Nissan22TuleAmpCarSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext16 /* 2131427623 */:
                int value30 = DataCanbus.DATA[143];
                if (value30 == 0) {
                    value30 = 1;
                } else if (value30 == 1) {
                    value30 = 0;
                }
                setCarInfo(40, value30, 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427624 */:
                setCarInfo(35, 0, 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427728 */:
                setCarInfo(36, 0, 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427730 */:
                setCarInfo(37, 0, 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427732 */:
                setCarInfo(38, 0, 0);
                break;
            case R.id.ctv_checkedtext21 /* 2131427734 */:
                setCarInfo(39, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1, value2}, null, null);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_NissanInfinitiCarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.xima.LZ_NissanInfinitiCarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{i, 0, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.LZ_NissanInfinitiCarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{56, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
    }
}
