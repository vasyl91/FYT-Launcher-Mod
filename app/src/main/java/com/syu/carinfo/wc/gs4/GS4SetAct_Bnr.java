package com.syu.carinfo.wc.gs4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

import java.util.ArrayList;

public class GS4SetAct_Bnr extends BaseActivity {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int[] ids = {106, 131, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 127, 128, 129, 130, 29, 30, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 179};
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    GS4SetAct_Bnr.this.uSet27(val);
                    break;
                case 30:
                    GS4SetAct_Bnr.this.uSet28(val);
                    break;
                case 106:
                    GS4SetAct_Bnr.this.uSet1(val);
                    break;
                case 107:
                    GS4SetAct_Bnr.this.uSet3(val);
                    break;
                case 108:
                    GS4SetAct_Bnr.this.uSet4(val);
                    break;
                case 109:
                    GS4SetAct_Bnr.this.uSet5(val);
                    break;
                case 110:
                    GS4SetAct_Bnr.this.uSet6(val);
                    break;
                case 111:
                    GS4SetAct_Bnr.this.uSet7(val);
                    break;
                case 112:
                    GS4SetAct_Bnr.this.uSet8(val);
                    break;
                case 113:
                    GS4SetAct_Bnr.this.uSet9(val);
                    break;
                case 114:
                    GS4SetAct_Bnr.this.uSet10(val);
                    break;
                case 115:
                    GS4SetAct_Bnr.this.uSet11(val);
                    break;
                case 116:
                    GS4SetAct_Bnr.this.uSet12(val);
                    break;
                case 117:
                    GS4SetAct_Bnr.this.uSet13(val);
                    break;
                case 118:
                    GS4SetAct_Bnr.this.uSet14(val);
                    break;
                case 119:
                    GS4SetAct_Bnr.this.uSet15(val);
                    break;
                case 120:
                    GS4SetAct_Bnr.this.uSet16(val);
                    break;
                case 121:
                    GS4SetAct_Bnr.this.uSet17(val);
                    break;
                case 123:
                    GS4SetAct_Bnr.this.uSet19(val);
                    break;
                case 124:
                    GS4SetAct_Bnr.this.uSet20(val);
                    break;
                case 125:
                    GS4SetAct_Bnr.this.uSet21(val);
                    break;
                case 126:
                    GS4SetAct_Bnr.this.uSet22(val);
                    break;
                case 127:
                    GS4SetAct_Bnr.this.uSet23(val);
                    break;
                case 128:
                    GS4SetAct_Bnr.this.uSet24(val);
                    break;
                case 129:
                    GS4SetAct_Bnr.this.uSet25(val);
                    break;
                case 130:
                    GS4SetAct_Bnr.this.uSet26(val);
                    break;
                case 131:
                    GS4SetAct_Bnr.this.uSet2(val);
                    break;
                case 152:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 153:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 154:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 155:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 156:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 157:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 158:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 159:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 160:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 161:
                    TextView v = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text1);
                    if (v != null) {
                        int id = R.string.klc_air_low;
                        if (val == 2) {
                            id = R.string.klc_air_middle;
                        }
                        if (val == 3) {
                            id = R.string.klc_air_high;
                        }
                        v.setText(id);
                        break;
                    }
                case 162:
                    TextView v2 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text2);
                    if (v2 != null) {
                        int id2 = R.string.klc_air_low;
                        if (val == 2) {
                            id2 = R.string.klc_air_middle;
                        }
                        if (val == 3) {
                            id2 = R.string.klc_air_high;
                        }
                        v2.setText(id2);
                        break;
                    }
                case 164:
                    TextView v3 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text3);
                    if (v3 != null) {
                        int id3 = R.string.off;
                        if (val == 2) {
                            id3 = R.string.str_on_only;
                        }
                        if (val == 3) {
                            id3 = R.string.str_sbd_x80_tishi_vol;
                        }
                        v3.setText(id3);
                        break;
                    }
                case 165:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 166:
                    TextView v4 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text4);
                    if (v4 != null) {
                        v4.setText(new StringBuilder().append(val + 1).toString());
                        break;
                    }
                case 167:
                    TextView v5 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text5);
                    if (v5 != null) {
                        v5.setText(new StringBuilder().append(val + 1).toString());
                        break;
                    }
                case 168:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext17), val == 1);
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext11), val == 1);
                            break;
                    }
                case 169:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext18), val == 1);
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext12), val == 1);
                            break;
                    }
                case 170:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                            TextView v6 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text10);
                            if (v6 != null) {
                                if (val == 2) {
                                    v6.setText("澎湃");
                                    break;
                                } else if (val == 3) {
                                    v6.setText("灵动");
                                    break;
                                } else {
                                    v6.setText("舒缓");
                                    break;
                                }
                            }
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext13), val == 1);
                            break;
                    }
                case 171:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                            TextView v7 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text11);
                            if (v7 != null) {
                                if (val == 2) {
                                    v7.setText("标准");
                                    break;
                                } else if (val == 3) {
                                    v7.setText("舒适");
                                    break;
                                } else {
                                    v7.setText("运动");
                                    break;
                                }
                            }
                            break;
                        default:
                            TextView v8 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text6);
                            if (v8 != null) {
                                int id4 = R.string.driver_system;
                                if (val == 2) {
                                    id4 = R.string.str_cruise_integrated;
                                }
                                v8.setText(id4);
                                break;
                            }
                    }
                case 172:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext19), val == 1);
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext14), val == 1);
                            break;
                    }
                case 173:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext20), val == 1);
                            break;
                        default:
                            TextView v9 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text7);
                            if (v9 != null) {
                                int id5 = R.string.klc_air_middle;
                                if (val == 2) {
                                    id5 = R.string.jeep_forwardcollisionwarn_0;
                                }
                                if (val == 3) {
                                    id5 = R.string.jeep_forwardcollisionwarn_1;
                                }
                                v9.setText(id5);
                                break;
                            }
                    }
                case 174:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 175:
                    TextView v10 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text8);
                    if (v10 != null) {
                        int id6 = R.string.str_steering_assist;
                        if (val == 2) {
                            id6 = R.string.str_warning;
                        }
                        if (val == 3) {
                            id6 = R.string.str_steering_assist_warning;
                        }
                        v10.setText(id6);
                        break;
                    }
                case 176:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 179:
                    TextView v11 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text9);
                    if (v11 != null) {
                        if (val == 2) {
                            v11.setText("灵动");
                            break;
                        } else if (val == 3) {
                            v11.setText("澎湃");
                            break;
                        } else {
                            v11.setText("舒缓");
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_280_bnr_gs4_set);
        this.mHandler = new Handler(Looper.getMainLooper());
        initClick();
        setUI();
    }

    
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                GS4SetAct_Bnr.this.language_set = position;
                if (GS4SetAct_Bnr.this.language_set >= 0 && GS4SetAct_Bnr.this.language_set <= GS4SetAct_Bnr.this.mLauStylelist.size() && GS4SetAct_Bnr.this.send_lang != null) {
                    GS4SetAct_Bnr.this.setCMD(32, GS4SetAct_Bnr.this.send_lang[GS4SetAct_Bnr.this.language_set]);
                }
                GS4SetAct_Bnr.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    private void initClick() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.confirm));
        this.mLauStylelist.add(getResources().getString(R.string.cancel));
        this.send_lang = new int[]{4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (GS4SetAct_Bnr.this.mLauStyle == null) {
                    GS4SetAct_Bnr.this.initLauStyle();
                }
                if (GS4SetAct_Bnr.this.mLauStyle == null || GS4SetAct_Bnr.this.mPopShowView == null) {
                    return;
                }
                GS4SetAct_Bnr.this.setCMD(32, 3);
                GS4SetAct_Bnr.this.mLauStyle.showAtLocation(GS4SetAct_Bnr.this.mPopShowView, 17, 0, 0);
                GS4SetAct_Bnr.this.updateLauguageSet();
            }
        });
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int iAirComfort;
                switch (v.getId()) {
                    case R.id.btn_minus1 /* 2131427455 */:
                        int value = DataCanbus.DATA[161] - 1;
                        if (value < 1) {
                            value = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(37, value);
                        break;
                    case R.id.btn_plus1 /* 2131427457 */:
                        int value2 = DataCanbus.DATA[161] + 1;
                        if (value2 > 3) {
                            value2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(37, value2);
                        break;
                    case R.id.btn_minus2 /* 2131427458 */:
                        int value3 = DataCanbus.DATA[162] - 1;
                        if (value3 < 1) {
                            value3 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(38, value3);
                        break;
                    case R.id.btn_plus2 /* 2131427460 */:
                        int value4 = DataCanbus.DATA[162] + 1;
                        if (value4 > 3) {
                            value4 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(38, value4);
                        break;
                    case R.id.btn_minus3 /* 2131427461 */:
                        int value5 = DataCanbus.DATA[164] - 1;
                        if (value5 < 1) {
                            value5 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(39, value5);
                        break;
                    case R.id.btn_plus3 /* 2131427463 */:
                        int value6 = DataCanbus.DATA[164] + 1;
                        if (value6 > 3) {
                            value6 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(39, value6);
                        break;
                    case R.id.btn_minus4 /* 2131427464 */:
                        int value7 = DataCanbus.DATA[166];
                        if (value7 > 0) {
                            value7--;
                        }
                        GS4SetAct_Bnr.this.setCMD(41, value7);
                        break;
                    case R.id.btn_plus4 /* 2131427466 */:
                        int value8 = DataCanbus.DATA[166];
                        if (value8 < 7) {
                            value8++;
                        }
                        GS4SetAct_Bnr.this.setCMD(41, value8);
                        break;
                    case R.id.btn_minus5 /* 2131427467 */:
                        int value9 = DataCanbus.DATA[167];
                        if (value9 > 0) {
                            value9--;
                        }
                        GS4SetAct_Bnr.this.setCMD(42, value9);
                        break;
                    case R.id.btn_plus5 /* 2131427469 */:
                        int value10 = DataCanbus.DATA[167];
                        if (value10 < 31) {
                            value10++;
                        }
                        GS4SetAct_Bnr.this.setCMD(42, value10);
                        break;
                    case R.id.btn_minus6 /* 2131427470 */:
                        int value11 = DataCanbus.DATA[171] - 1;
                        if (value11 < 1) {
                            value11 = 2;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value11);
                        break;
                    case R.id.btn_plus6 /* 2131427472 */:
                        int value12 = DataCanbus.DATA[171] + 1;
                        if (value12 > 2) {
                            value12 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value12);
                        break;
                    case R.id.btn_minus7 /* 2131427473 */:
                        int value13 = DataCanbus.DATA[173] - 1;
                        if (value13 < 1) {
                            value13 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(48, value13);
                        break;
                    case R.id.btn_plus7 /* 2131427475 */:
                        int value14 = DataCanbus.DATA[173] + 1;
                        if (value14 > 3) {
                            value14 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(48, value14);
                        break;
                    case R.id.btn_minus8 /* 2131427476 */:
                        int value15 = DataCanbus.DATA[175] - 1;
                        if (value15 < 1) {
                            value15 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(50, value15);
                        break;
                    case R.id.btn_plus8 /* 2131427478 */:
                        int value16 = DataCanbus.DATA[175] + 1;
                        if (value16 > 3) {
                            value16 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(50, value16);
                        break;
                    case R.id.btn_minus9 /* 2131427479 */:
                        int value17 = DataCanbus.DATA[179] - 1;
                        if (value17 < 1) {
                            value17 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(52, value17);
                        break;
                    case R.id.btn_plus9 /* 2131427481 */:
                        int value18 = DataCanbus.DATA[179] + 1;
                        if (value18 > 3) {
                            value18 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(52, value18);
                        break;
                    case R.id.btn_minus10 /* 2131427482 */:
                        int value19 = DataCanbus.DATA[170] - 1;
                        if (value19 < 1) {
                            value19 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(45, value19);
                        break;
                    case R.id.btn_plus10 /* 2131427484 */:
                        int value20 = DataCanbus.DATA[170] + 1;
                        if (value20 > 3) {
                            value20 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(45, value20);
                        break;
                    case R.id.btn_minus11 /* 2131427485 */:
                        int value21 = DataCanbus.DATA[171] - 1;
                        if (value21 < 1) {
                            value21 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value21);
                        break;
                    case R.id.btn_plus11 /* 2131427487 */:
                        int value22 = DataCanbus.DATA[171] + 1;
                        if (value22 > 3) {
                            value22 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value22);
                        break;
                    case R.id.ctv_checkedtext1 /* 2131427525 */:
                        GS4SetAct_Bnr.this.setCMD(28, DataCanbus.DATA[152] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427541 */:
                        GS4SetAct_Bnr.this.setCMD(29, DataCanbus.DATA[153] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427542 */:
                        GS4SetAct_Bnr.this.setCMD(30, DataCanbus.DATA[154] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext4 /* 2131427544 */:
                        GS4SetAct_Bnr.this.setCMD(31, DataCanbus.DATA[155] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext5 /* 2131427547 */:
                        GS4SetAct_Bnr.this.setCMD(32, DataCanbus.DATA[156] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext6 /* 2131427548 */:
                        GS4SetAct_Bnr.this.setCMD(33, DataCanbus.DATA[157] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext7 /* 2131427549 */:
                        GS4SetAct_Bnr.this.setCMD(36, DataCanbus.DATA[160] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext8 /* 2131427550 */:
                        GS4SetAct_Bnr.this.setCMD(34, DataCanbus.DATA[158] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext9 /* 2131427551 */:
                        GS4SetAct_Bnr.this.setCMD(35, DataCanbus.DATA[159] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext10 /* 2131427552 */:
                        GS4SetAct_Bnr.this.setCMD(40, DataCanbus.DATA[165] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext11 /* 2131427553 */:
                        GS4SetAct_Bnr.this.setCMD(43, DataCanbus.DATA[168] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext12 /* 2131427554 */:
                        GS4SetAct_Bnr.this.setCMD(44, DataCanbus.DATA[169] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext13 /* 2131427555 */:
                        GS4SetAct_Bnr.this.setCMD(45, DataCanbus.DATA[170] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext14 /* 2131427556 */:
                        GS4SetAct_Bnr.this.setCMD(47, DataCanbus.DATA[172] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext15 /* 2131427557 */:
                        GS4SetAct_Bnr.this.setCMD(49, DataCanbus.DATA[174] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext16 /* 2131427558 */:
                        GS4SetAct_Bnr.this.setCMD(51, DataCanbus.DATA[176] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext17 /* 2131427559 */:
                        GS4SetAct_Bnr.this.setCMD(43, DataCanbus.DATA[168] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext18 /* 2131427661 */:
                        GS4SetAct_Bnr.this.setCMD(44, DataCanbus.DATA[169] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext19 /* 2131427663 */:
                        GS4SetAct_Bnr.this.setCMD(47, DataCanbus.DATA[172] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext20 /* 2131427665 */:
                        GS4SetAct_Bnr.this.setCMD(48, DataCanbus.DATA[173] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext21 /* 2131427667 */:
                        GS4SetAct_Bnr.this.setCMD(49, 1);
                        break;
                    case R.id.wc_gs4_language /* 2131429018 */:
                        int iLang = DataCanbus.DATA[106] + 1;
                        if (iLang > 4) {
                            iLang = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(1, iLang);
                        break;
                    case R.id.wc_gs4_seathot_left /* 2131429020 */:
                        GS4SetAct_Bnr.this.sendCmd(22);
                        break;
                    case R.id.wc_gs4_seathot_right /* 2131429022 */:
                        GS4SetAct_Bnr.this.sendCmd(23);
                        break;
                    case R.id.wc_gs4_air_set_auto_compressor_check /* 2131429024 */:
                        int iAutoCompress = DataCanbus.DATA[131];
                        GS4SetAct_Bnr.this.setCMD(2, iAutoCompress == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_air_set_auto_cycle_state_check /* 2131429025 */:
                        int iAutoCycle = DataCanbus.DATA[107];
                        GS4SetAct_Bnr.this.setCMD(3, iAutoCycle == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_air_set_auto_neg_ions /* 2131429026 */:
                        int iNegIons = DataCanbus.DATA[127];
                        GS4SetAct_Bnr.this.setCMD(24, iNegIons == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_air_set_comfort_curve_pre /* 2131429027 */:
                        int iAirComfort2 = DataCanbus.DATA[108] - 1;
                        if (iAirComfort2 < 1) {
                            iAirComfort2 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(4, iAirComfort2);
                        break;
                    case R.id.wc_gs4_air_set_comfort_curve_next /* 2131429029 */:
                        int iAirComfort3 = DataCanbus.DATA[108];
                        if (iAirComfort3 > 2) {
                            iAirComfort = 1;
                        } else {
                            iAirComfort = iAirComfort3 + 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(4, iAirComfort);
                        break;
                    case R.id.wc_gs4_seat_set_drive_seat_check /* 2131429030 */:
                        int iSeatHeatLeft = DataCanbus.DATA[109];
                        GS4SetAct_Bnr.this.setCMD(5, iSeatHeatLeft == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_air_set_the_pilot_drive_seat_check /* 2131429031 */:
                        int iSeatHeatRight = DataCanbus.DATA[110];
                        GS4SetAct_Bnr.this.setCMD(6, iSeatHeatRight == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_warn_of_speed_pre /* 2131429032 */:
                        int iSpeedWarn = DataCanbus.DATA[111] - 1;
                        if (iSpeedWarn < 1) {
                            iSpeedWarn = 0;
                        }
                        GS4SetAct_Bnr.this.setCMD(7, iSpeedWarn);
                        break;
                    case R.id.wc_gs4_warn_of_speed_next /* 2131429034 */:
                        int iSpeedWarn2 = DataCanbus.DATA[111] + 1;
                        if (iSpeedWarn2 > 20) {
                            iSpeedWarn2 = 20;
                        }
                        GS4SetAct_Bnr.this.setCMD(7, iSpeedWarn2);
                        break;
                    case R.id.wc_gs4_driver_help_sound_pre /* 2131429035 */:
                        int iMeterWarnVol = DataCanbus.DATA[112] - 1;
                        if (iMeterWarnVol < 1) {
                            iMeterWarnVol = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(8, iMeterWarnVol);
                        break;
                    case R.id.wc_gs4_driver_help_sound_next /* 2131429037 */:
                        int iMeterWarnVol2 = DataCanbus.DATA[112] + 1;
                        if (iMeterWarnVol2 < 3) {
                            iMeterWarnVol2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(8, iMeterWarnVol2);
                        break;
                    case R.id.wc_gs4_driver_help_away_time_pre /* 2131429038 */:
                        int iRemotePowerOn = DataCanbus.DATA[113] - 5;
                        if (iRemotePowerOn < 0) {
                            iRemotePowerOn = 0;
                        }
                        GS4SetAct_Bnr.this.setCMD(9, iRemotePowerOn);
                        break;
                    case R.id.wc_gs4_driver_help_away_time_next /* 2131429040 */:
                        int iRemotePowerOn2 = DataCanbus.DATA[113] + 5;
                        if (iRemotePowerOn2 > 30) {
                            iRemotePowerOn2 = 30;
                        }
                        GS4SetAct_Bnr.this.setCMD(9, iRemotePowerOn2);
                        break;
                    case R.id.wc_gs4_driver_help_start_time_pre /* 2131429041 */:
                        int iRemoteStart = DataCanbus.DATA[114] - 5;
                        if (iRemoteStart < 0) {
                            iRemoteStart = 0;
                        }
                        GS4SetAct_Bnr.this.setCMD(10, iRemoteStart);
                        break;
                    case R.id.wc_gs4_driver_help_start_time_next /* 2131429043 */:
                        int iRemoteStart2 = DataCanbus.DATA[114] + 5;
                        if (iRemoteStart2 > 30) {
                            iRemoteStart2 = 30;
                        }
                        GS4SetAct_Bnr.this.setCMD(10, iRemoteStart2);
                        break;
                    case R.id.wc_gs4_driver_help_turn_mode_pre /* 2131429044 */:
                        int iTurnMode = DataCanbus.DATA[115] - 1;
                        if (iTurnMode < 1) {
                            iTurnMode = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(11, iTurnMode);
                        break;
                    case R.id.wc_gs4_driver_help_turn_mode_next /* 2131429046 */:
                        int iTurnMode2 = DataCanbus.DATA[115] + 1;
                        if (iTurnMode2 > 3) {
                            iTurnMode2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(11, iTurnMode2);
                        break;
                    case R.id.wc_gs4_romote_unlock_check /* 2131429047 */:
                        int iRemoteUnlock = DataCanbus.DATA[116];
                        GS4SetAct_Bnr.this.setCMD(12, iRemoteUnlock == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_car_speed_lock_check /* 2131429049 */:
                        int iSpeedlock = DataCanbus.DATA[117];
                        GS4SetAct_Bnr.this.setCMD(13, iSpeedlock == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_auto_unlock_check /* 2131429050 */:
                        int iAutoUnlock = DataCanbus.DATA[118];
                        GS4SetAct_Bnr.this.setCMD(14, iAutoUnlock == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_romote_front_rear_window_check /* 2131429051 */:
                        int iRemoteLeftTopWindow = DataCanbus.DATA[119];
                        GS4SetAct_Bnr.this.setCMD(15, iRemoteLeftTopWindow == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_front_yugua_weihu_check /* 2131429052 */:
                        int iRainBrush = DataCanbus.DATA[120];
                        GS4SetAct_Bnr.this.setCMD(16, iRainBrush == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_rear_yugua_check /* 2131429053 */:
                        int iRearRainBrushAutoStart = DataCanbus.DATA[121];
                        GS4SetAct_Bnr.this.setCMD(17, iRearRainBrushAutoStart == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_rearmirror_fold /* 2131429054 */:
                        int iRearMirrorFold = DataCanbus.DATA[130];
                        GS4SetAct_Bnr.this.setCMD(27, iRearMirrorFold == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_welcome /* 2131429055 */:
                        int iWelcome = DataCanbus.DATA[128];
                        GS4SetAct_Bnr.this.setCMD(25, iWelcome == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_smartkey /* 2131429056 */:
                        int iSmartKeyIndentify = DataCanbus.DATA[129];
                        GS4SetAct_Bnr.this.setCMD(26, iSmartKeyIndentify == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_with_me_home_lighting_pre /* 2131429057 */:
                        int iHome = DataCanbus.DATA[123] - 1;
                        if (iHome < 1) {
                            iHome = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(18, iHome);
                        break;
                    case R.id.wc_gs4_with_me_home_lighting_next /* 2131429059 */:
                        int iHome2 = DataCanbus.DATA[123] + 1;
                        if (iHome2 > 3) {
                            iHome2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(18, iHome2);
                        break;
                    case R.id.wc_gs4_wudeng_turn_around_help_check /* 2131429060 */:
                        int iFrogTurn = DataCanbus.DATA[124];
                        GS4SetAct_Bnr.this.setCMD(19, iFrogTurn == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_day_light_check /* 2131429061 */:
                        int iDayLight = DataCanbus.DATA[125];
                        GS4SetAct_Bnr.this.setCMD(20, iDayLight == 1 ? 2 : 1);
                        break;
                    case R.id.wc_gs4_light_sensitivity_pre /* 2131429062 */:
                        int iLightSense = DataCanbus.DATA[126] - 1;
                        if (iLightSense < 1) {
                            iLightSense = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(21, iLightSense);
                        break;
                    case R.id.wc_gs4_light_sensitivity_next /* 2131429064 */:
                        int iLightSense2 = DataCanbus.DATA[126] + 1;
                        if (iLightSense2 > 3) {
                            iLightSense2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(21, iLightSense2);
                        break;
                    case R.id.wc_gs4_reset /* 2131429065 */:
                        GS4SetAct_Bnr.this.showResetDlg();
                        break;
                }
            }
        };
    }

    
    public void sendCmd(final int cmd) {
        setCMD(cmd, 2);
        this.mHandler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
            }
        }, 200L);
    }

    protected void showResetDlg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.factory_data_reset)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        GS4SetAct_Bnr.this.setCMD(0, 255);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    
    public void setCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, val}, null, null);
    }

    private void setUI() {
        bindViewClick(R.id.wc_gs4_air_set_comfort_curve_pre);
        bindViewClick(R.id.wc_gs4_air_set_comfort_curve_next);
        bindViewClick(R.id.wc_gs4_warn_of_speed_pre);
        bindViewClick(R.id.wc_gs4_warn_of_speed_next);
        bindViewClick(R.id.wc_gs4_driver_help_sound_pre);
        bindViewClick(R.id.wc_gs4_driver_help_sound_next);
        bindViewClick(R.id.wc_gs4_driver_help_away_time_pre);
        bindViewClick(R.id.wc_gs4_driver_help_away_time_next);
        bindViewClick(R.id.wc_gs4_driver_help_start_time_pre);
        bindViewClick(R.id.wc_gs4_driver_help_start_time_next);
        bindViewClick(R.id.wc_gs4_driver_help_turn_mode_pre);
        bindViewClick(R.id.wc_gs4_driver_help_turn_mode_next);
        bindViewClick(R.id.wc_gs4_with_me_home_lighting_pre);
        bindViewClick(R.id.wc_gs4_with_me_home_lighting_next);
        bindViewClick(R.id.wc_gs4_light_sensitivity_next);
        bindViewClick(R.id.wc_gs4_light_sensitivity_pre);
        bindViewClick(R.id.wc_gs4_reset);
        bindViewClick(R.id.wc_gs4_language);
        bindViewClick(R.id.wc_gs4_seathot_left);
        bindViewClick(R.id.wc_gs4_seathot_right);
        bindViewClick(R.id.ctv_checkedtext1);
        bindViewClick(R.id.ctv_checkedtext2);
        bindViewClick(R.id.ctv_checkedtext3);
        bindViewClick(R.id.ctv_checkedtext4);
        bindViewClick(R.id.ctv_checkedtext5);
        bindViewClick(R.id.ctv_checkedtext6);
        bindViewClick(R.id.ctv_checkedtext7);
        bindViewClick(R.id.ctv_checkedtext8);
        bindViewClick(R.id.ctv_checkedtext9);
        bindViewClick(R.id.ctv_checkedtext10);
        bindViewClick(R.id.ctv_checkedtext11);
        bindViewClick(R.id.ctv_checkedtext12);
        bindViewClick(R.id.ctv_checkedtext13);
        bindViewClick(R.id.ctv_checkedtext14);
        bindViewClick(R.id.ctv_checkedtext15);
        bindViewClick(R.id.ctv_checkedtext16);
        bindViewClick(R.id.ctv_checkedtext17);
        bindViewClick(R.id.ctv_checkedtext18);
        bindViewClick(R.id.ctv_checkedtext19);
        bindViewClick(R.id.ctv_checkedtext20);
        bindViewClick(R.id.ctv_checkedtext21);
        bindViewClick(R.id.btn_minus1);
        bindViewClick(R.id.btn_plus1);
        bindViewClick(R.id.btn_minus2);
        bindViewClick(R.id.btn_plus2);
        bindViewClick(R.id.btn_minus3);
        bindViewClick(R.id.btn_plus3);
        bindViewClick(R.id.btn_minus4);
        bindViewClick(R.id.btn_plus4);
        bindViewClick(R.id.btn_minus5);
        bindViewClick(R.id.btn_plus5);
        bindViewClick(R.id.btn_minus6);
        bindViewClick(R.id.btn_plus6);
        bindViewClick(R.id.btn_minus7);
        bindViewClick(R.id.btn_plus7);
        bindViewClick(R.id.btn_minus8);
        bindViewClick(R.id.btn_plus8);
        bindViewClick(R.id.btn_minus9);
        bindViewClick(R.id.btn_plus9);
        bindViewClick(R.id.btn_minus10);
        bindViewClick(R.id.btn_plus10);
        bindViewClick(R.id.btn_minus11);
        bindViewClick(R.id.btn_plus11);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        findViewById(R.id.layout_view58).setVisibility(8);
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
        findViewById(R.id.layout_text_view3).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.all_func_btn_lauguage_set_view).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_text_view4).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_text_view5).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGM8_20 /* 1573144 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS5_20 /* 1638680 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3_21 /* 1704216 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS3_17_H /* 1769752 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_ChuanQiGS8_20 /* 1835288 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.all_func_btn_lauguage_set_view).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_ChuanQiGS4_20_EV /* 1966360 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_view60).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.all_func_btn_lauguage_set_view).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                break;
        }
    }

    
    public View bindViewClick(int id) {
        View v = findViewById(id);
        if (v != null) {
            setClick(v);
        }
        return v;
    }

    @Override
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void uSet27(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_seathot_left_txt);
        if (v != null) {
            if (val == 0) {
                v.setText(R.string.off);
            } else {
                v.setText(new StringBuilder().append(val).toString());
            }
        }
    }

    
    public void uSet28(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_seathot_right_txt);
        if (v != null) {
            if (val == 0) {
                v.setText(R.string.off);
            } else {
                v.setText(new StringBuilder().append(val).toString());
            }
        }
    }

    
    public void uSet1(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_language_txt);
        if (v != null) {
            switch (val) {
                case 1:
                    v.setText(R.string.jeep_language_set1);
                    break;
                case 2:
                    v.setText(R.string.jeep_language_set0);
                    break;
                case 3:
                    v.setText(R.string.wc_psa_all_lauguage_set_value_17);
                    break;
                case 4:
                    v.setText(R.string.wc_psa_all_lauguage_set_value_15);
                    break;
                default:
                    v.setText(R.string.jeep_language_set1);
                    break;
            }
        }
    }

    
    public void uSet2(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_air_set_auto_compressor_check), val == 1);
    }

    
    public void uSet3(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_air_set_auto_cycle_state_check), val == 1);
    }

    
    public void uSet4(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV);
        if (v != null) {
            int id = R.string.wc_gs4_air_set_comfort_slow;
            if (val == 2) {
                id = R.string.wc_gs4_air_set_comfort_nomol;
            }
            if (val == 3) {
                id = R.string.wc_gs4_air_set_comfort_fast;
            }
            v.setText(id);
        }
    }

    
    public void uSet5(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_seat_set_drive_seat_check), val == 1);
    }

    
    public void uSet6(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_air_set_the_pilot_drive_seat_check), val == 1);
    }

    
    public void uSet7(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_warn_of_speed_TV);
        if (v != null) {
            v.setText(String.valueOf(val * 10) + "km/h");
        }
    }

    
    public void uSet8(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV);
        if (v != null) {
            int id = R.string.wc_372_low;
            if (val == 2) {
                id = R.string.wc_372_mid;
            }
            if (val == 3) {
                id = R.string.wc_372_high;
            }
            v.setText(id);
        }
    }

    
    public void uSet9(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_driver_help_away_time_TV);
        if (v != null) {
            v.setText(String.valueOf(val) + getResources().getString(R.string.time_minutes));
        }
    }

    
    public void uSet10(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_driver_help_start_time_TV);
        if (v != null) {
            v.setText(String.valueOf(val) + getResources().getString(R.string.time_minutes));
        }
    }

    
    public void uSet11(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV);
        if (v != null) {
            int id = R.string.driver_system_sports;
            if (val == 2) {
                id = R.string.driver_system_standard;
            }
            if (val == 3) {
                id = R.string.str_driving_comfort;
            }
            v.setText(id);
        }
    }

    
    public void uSet12(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_romote_unlock_check), val == 1);
        TextView v = (TextView) findViewById(R.id.wc_gs4_romote_unlock_TV);
        if (v != null) {
            int id = R.string.str_gs4_acc_all_door;
            if (val == 2) {
                id = R.string.str_gs4_acc_left_door;
            }
            v.setText(id);
        }
    }

    
    public void uSet13(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_car_speed_lock_check), val == 1);
    }

    
    public void uSet14(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_auto_unlock_check), val == 1);
    }

    
    public void uSet15(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_romote_front_rear_window_check), val == 1);
    }

    
    public void uSet16(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_front_yugua_weihu_check), val == 1);
    }

    
    public void uSet17(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_rear_yugua_check), val == 1);
    }

    
    public void uSet19(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_with_me_home_lighting_TV);
        if (v != null) {
            int id = R.string.off;
            if (val == 2) {
                id = R.string.wc_gs4_only_near_light;
            }
            if (val == 3) {
                id = R.string.wc_gs4_near_light_forgost;
            }
            v.setText(id);
        }
    }

    
    public void uSet20(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_wudeng_turn_around_help_check), val == 1);
    }

    
    public void uSet21(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_day_light_check), val == 1);
    }

    
    public void uSet22(int val) {
        TextView v = (TextView) findViewById(R.id.wc_gs4_light_sensitivity_TV);
        if (v != null) {
            int id = R.string.wc_372_low;
            if (val == 2) {
                id = R.string.wc_372_mid;
            }
            if (val == 3) {
                id = R.string.wc_372_high;
            }
            v.setText(id);
        }
    }

    
    public void uSet23(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_air_set_auto_neg_ions), val == 1);
    }

    
    public void uSet24(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_welcome), val == 1);
    }

    
    public void uSet25(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_smartkey), val == 1);
    }

    
    public void uSet26(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.wc_gs4_rearmirror_fold), val == 1);
    }
}
