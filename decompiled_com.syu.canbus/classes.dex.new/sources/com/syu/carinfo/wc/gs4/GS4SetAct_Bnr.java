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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class GS4SetAct_Bnr extends BaseActivity {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_drivemode;
    int[] send_lang;
    int cmdtype = 0;
    int language_set = 255;
    int drivemode_set = 255;
    int[] ids = {106, 131, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 123, 124, 125, 126, 127, 128, 129, 130, 29, 30, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 179, 180, 181, 182, 183, 184, 185, 186, 187, 218, 219};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.1
        @Override // com.syu.module.IUiNotify
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
                    GS4SetAct_Bnr.this.updateLauguageModeSet(val);
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
                    }
                    break;
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
                    }
                    break;
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
                    }
                    break;
                case 165:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 166:
                    TextView v4 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text4);
                    if (v4 != null) {
                        v4.setText(new StringBuilder().append(val + 1).toString());
                    }
                    break;
                case 167:
                    TextView v5 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text5);
                    if (v5 != null) {
                        v5.setText(new StringBuilder().append(val + 1).toString());
                    }
                    break;
                case 168:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                        case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext17), val == 1);
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext11), val == 1);
                            break;
                    }
                    break;
                case 169:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                        case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext18), val == 1);
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext12), val == 1);
                            break;
                    }
                    break;
                case 170:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                        case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                            TextView v6 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text10);
                            if (v6 != null) {
                                if (val == 2) {
                                    v6.setText("澎湃");
                                } else if (val == 3) {
                                    v6.setText("灵动");
                                } else {
                                    v6.setText("舒缓");
                                }
                            }
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext13), val == 1);
                            break;
                    }
                    break;
                case 171:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                        case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                            TextView v7 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text11);
                            if (v7 != null) {
                                if (val == 2) {
                                    v7.setText("标准");
                                } else if (val == 3) {
                                    v7.setText("舒适");
                                } else {
                                    v7.setText("运动");
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
                            }
                            break;
                    }
                    break;
                case 172:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                        case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext19), val == 1);
                            break;
                        default:
                            GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext14), val == 1);
                            break;
                    }
                    break;
                case 173:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
                        case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
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
                            }
                            break;
                    }
                    break;
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
                    }
                    break;
                case 176:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 179:
                    TextView v11 = (TextView) GS4SetAct_Bnr.this.findViewById(R.id.tv_text9);
                    if (v11 != null) {
                        if (val == 2) {
                            v11.setText("灵动");
                        } else if (val == 3) {
                            v11.setText("澎湃");
                        } else {
                            v11.setText("舒缓");
                        }
                    }
                    break;
                case 218:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext22), val == 1);
                    break;
                case 219:
                    GS4SetAct_Bnr.this.setCheck((CheckedTextView) GS4SetAct_Bnr.this.bindViewClick(R.id.ctv_checkedtext23), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_280_bnr_gs4_set);
        this.mHandler = new Handler(Looper.getMainLooper());
        initClick();
        setUI();
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                switch (GS4SetAct_Bnr.this.cmdtype) {
                    case 1:
                        GS4SetAct_Bnr.this.language_set = position;
                        if (GS4SetAct_Bnr.this.language_set >= 0 && GS4SetAct_Bnr.this.language_set <= GS4SetAct_Bnr.this.mLauStylelist.size() && GS4SetAct_Bnr.this.send_lang != null) {
                            GS4SetAct_Bnr.this.setCMD(32, GS4SetAct_Bnr.this.send_lang[GS4SetAct_Bnr.this.language_set]);
                        }
                        break;
                    case 2:
                        GS4SetAct_Bnr.this.drivemode_set = position;
                        if (GS4SetAct_Bnr.this.drivemode_set >= 0 && GS4SetAct_Bnr.this.drivemode_set <= GS4SetAct_Bnr.this.mLauStylelist.size() && GS4SetAct_Bnr.this.send_drivemode != null) {
                            GS4SetAct_Bnr.this.setCMD(1, GS4SetAct_Bnr.this.send_drivemode[GS4SetAct_Bnr.this.drivemode_set]);
                        }
                        break;
                }
                GS4SetAct_Bnr.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageModeSet(int index) {
        if (index >= 0 && index < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(index, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmLauStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add(getResources().getString(R.string.confirm));
        this.mLauStylelist.add(getResources().getString(R.string.cancel));
        this.send_lang = new int[]{4, 5};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initmDrivemodeStylelist() {
        this.mLauStylelist.clear();
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
            case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
                this.mLauStylelist.add("Thai");
                this.mLauStylelist.add("Malaysia");
                this.mLauStylelist.add("Vietnamese");
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
                this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_3));
                this.send_drivemode = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                break;
            default:
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
                this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
                this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_3));
                this.mLauStylelist.add("Vietnamese");
                this.mLauStylelist.add("Thai");
                this.mLauStylelist.add("Malaysia");
                this.send_drivemode = new int[]{1, 2, 3, 4, 9, 10, 11};
                break;
        }
    }

    private void initClick() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GS4SetAct_Bnr.this.initmLauStylelist();
                GS4SetAct_Bnr.this.cmdtype = 1;
                if (GS4SetAct_Bnr.this.mLauStyle == null) {
                    GS4SetAct_Bnr.this.initLauStyle();
                }
                if (GS4SetAct_Bnr.this.mLauStyle == null || GS4SetAct_Bnr.this.mPopShowView == null) {
                    return;
                }
                GS4SetAct_Bnr.this.setCMD(32, 3);
                GS4SetAct_Bnr.this.mLauStyle.showAtLocation(GS4SetAct_Bnr.this.mPopShowView, 17, 0, 0);
                GS4SetAct_Bnr.this.updateLauguageModeSet(GS4SetAct_Bnr.this.language_set);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), new View.OnClickListener() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GS4SetAct_Bnr.this.initmDrivemodeStylelist();
                GS4SetAct_Bnr.this.cmdtype = 2;
                if (GS4SetAct_Bnr.this.mLauStyle == null) {
                    GS4SetAct_Bnr.this.initLauStyle();
                }
                if (GS4SetAct_Bnr.this.mLauStyle != null && GS4SetAct_Bnr.this.mPopShowView != null) {
                    GS4SetAct_Bnr.this.mLauStyle.showAtLocation(GS4SetAct_Bnr.this.mPopShowView, 17, 0, 0);
                    GS4SetAct_Bnr.this.updateLauguageModeSet(GS4SetAct_Bnr.this.drivemode_set);
                }
            }
        });
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int iAirComfort;
                switch (v.getId()) {
                    case R.id.btn_minus1 /* 2131427456 */:
                        int value = DataCanbus.DATA[161] - 1;
                        if (value < 1) {
                            value = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(37, value);
                        break;
                    case R.id.btn_plus1 /* 2131427458 */:
                        int value2 = DataCanbus.DATA[161] + 1;
                        if (value2 > 3) {
                            value2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(37, value2);
                        break;
                    case R.id.btn_minus2 /* 2131427459 */:
                        int value3 = DataCanbus.DATA[162] - 1;
                        if (value3 < 1) {
                            value3 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(38, value3);
                        break;
                    case R.id.btn_plus2 /* 2131427461 */:
                        int value4 = DataCanbus.DATA[162] + 1;
                        if (value4 > 3) {
                            value4 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(38, value4);
                        break;
                    case R.id.btn_minus3 /* 2131427462 */:
                        int value5 = DataCanbus.DATA[164] - 1;
                        if (value5 < 1) {
                            value5 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(39, value5);
                        break;
                    case R.id.btn_plus3 /* 2131427464 */:
                        int value6 = DataCanbus.DATA[164] + 1;
                        if (value6 > 3) {
                            value6 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(39, value6);
                        break;
                    case R.id.btn_minus4 /* 2131427465 */:
                        int value7 = DataCanbus.DATA[166];
                        if (value7 > 0) {
                            value7--;
                        }
                        GS4SetAct_Bnr.this.setCMD(41, value7);
                        break;
                    case R.id.btn_plus4 /* 2131427467 */:
                        int value8 = DataCanbus.DATA[166];
                        if (value8 < 7) {
                            value8++;
                        }
                        GS4SetAct_Bnr.this.setCMD(41, value8);
                        break;
                    case R.id.btn_minus5 /* 2131427468 */:
                        int value9 = DataCanbus.DATA[167];
                        if (value9 > 0) {
                            value9--;
                        }
                        GS4SetAct_Bnr.this.setCMD(42, value9);
                        break;
                    case R.id.btn_plus5 /* 2131427470 */:
                        int value10 = DataCanbus.DATA[167];
                        if (value10 < 31) {
                            value10++;
                        }
                        GS4SetAct_Bnr.this.setCMD(42, value10);
                        break;
                    case R.id.btn_minus6 /* 2131427471 */:
                        int value11 = DataCanbus.DATA[171] - 1;
                        if (value11 < 1) {
                            value11 = 2;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value11);
                        break;
                    case R.id.btn_plus6 /* 2131427473 */:
                        int value12 = DataCanbus.DATA[171] + 1;
                        if (value12 > 2) {
                            value12 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value12);
                        break;
                    case R.id.btn_minus7 /* 2131427474 */:
                        int value13 = DataCanbus.DATA[173] - 1;
                        if (value13 < 1) {
                            value13 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(48, value13);
                        break;
                    case R.id.btn_plus7 /* 2131427476 */:
                        int value14 = DataCanbus.DATA[173] + 1;
                        if (value14 > 3) {
                            value14 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(48, value14);
                        break;
                    case R.id.btn_minus8 /* 2131427477 */:
                        int value15 = DataCanbus.DATA[175] - 1;
                        if (value15 < 1) {
                            value15 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(50, value15);
                        break;
                    case R.id.btn_plus8 /* 2131427479 */:
                        int value16 = DataCanbus.DATA[175] + 1;
                        if (value16 > 3) {
                            value16 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(50, value16);
                        break;
                    case R.id.btn_minus9 /* 2131427480 */:
                        int value17 = DataCanbus.DATA[179] - 1;
                        if (value17 < 1) {
                            value17 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(52, value17);
                        break;
                    case R.id.btn_plus9 /* 2131427482 */:
                        int value18 = DataCanbus.DATA[179] + 1;
                        if (value18 > 3) {
                            value18 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(52, value18);
                        break;
                    case R.id.btn_minus10 /* 2131427483 */:
                        int value19 = DataCanbus.DATA[170] - 1;
                        if (value19 < 1) {
                            value19 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(45, value19);
                        break;
                    case R.id.btn_plus10 /* 2131427485 */:
                        int value20 = DataCanbus.DATA[170] + 1;
                        if (value20 > 3) {
                            value20 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(45, value20);
                        break;
                    case R.id.btn_minus11 /* 2131427486 */:
                        int value21 = DataCanbus.DATA[171] - 1;
                        if (value21 < 1) {
                            value21 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value21);
                        break;
                    case R.id.btn_plus11 /* 2131427488 */:
                        int value22 = DataCanbus.DATA[171] + 1;
                        if (value22 > 3) {
                            value22 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(46, value22);
                        break;
                    case R.id.btn_minus12 /* 2131427489 */:
                        int iAirComfort2 = DataCanbus.DATA[108] - 1;
                        if (iAirComfort2 < 1) {
                            iAirComfort2 = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(4, iAirComfort2);
                        break;
                    case R.id.btn_plus12 /* 2131427491 */:
                        int iAirComfort3 = DataCanbus.DATA[108];
                        if (iAirComfort3 > 2) {
                            iAirComfort = 1;
                        } else {
                            iAirComfort = iAirComfort3 + 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(4, iAirComfort);
                        break;
                    case R.id.btn_minus13 /* 2131427492 */:
                        int iSpeedWarn = DataCanbus.DATA[111] - 1;
                        if (iSpeedWarn < 1) {
                            iSpeedWarn = 0;
                        }
                        GS4SetAct_Bnr.this.setCMD(7, iSpeedWarn);
                        break;
                    case R.id.btn_plus13 /* 2131427494 */:
                        int iSpeedWarn2 = DataCanbus.DATA[111] + 1;
                        if (iSpeedWarn2 > 20) {
                            iSpeedWarn2 = 20;
                        }
                        GS4SetAct_Bnr.this.setCMD(7, iSpeedWarn2);
                        break;
                    case R.id.btn_minus14 /* 2131427495 */:
                        int iMeterWarnVol = DataCanbus.DATA[112] - 1;
                        if (iMeterWarnVol < 1) {
                            iMeterWarnVol = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(8, iMeterWarnVol);
                        break;
                    case R.id.btn_plus14 /* 2131427497 */:
                        int iMeterWarnVol2 = DataCanbus.DATA[112] + 1;
                        if (iMeterWarnVol2 < 3) {
                            iMeterWarnVol2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(8, iMeterWarnVol2);
                        break;
                    case R.id.btn_minus15 /* 2131427498 */:
                        int iRemotePowerOn = DataCanbus.DATA[113] - 5;
                        if (iRemotePowerOn < 0) {
                            iRemotePowerOn = 0;
                        }
                        GS4SetAct_Bnr.this.setCMD(9, iRemotePowerOn);
                        break;
                    case R.id.btn_plus15 /* 2131427500 */:
                        int iRemotePowerOn2 = DataCanbus.DATA[113] + 5;
                        if (iRemotePowerOn2 > 30) {
                            iRemotePowerOn2 = 30;
                        }
                        GS4SetAct_Bnr.this.setCMD(9, iRemotePowerOn2);
                        break;
                    case R.id.btn_minus16 /* 2131427501 */:
                        int iRemoteStart = DataCanbus.DATA[114] - 5;
                        if (iRemoteStart < 0) {
                            iRemoteStart = 0;
                        }
                        GS4SetAct_Bnr.this.setCMD(10, iRemoteStart);
                        break;
                    case R.id.btn_plus16 /* 2131427503 */:
                        int iRemoteStart2 = DataCanbus.DATA[114] + 5;
                        if (iRemoteStart2 > 30) {
                            iRemoteStart2 = 30;
                        }
                        GS4SetAct_Bnr.this.setCMD(10, iRemoteStart2);
                        break;
                    case R.id.btn_minus17 /* 2131427504 */:
                        int iTurnMode = DataCanbus.DATA[115] - 1;
                        if (iTurnMode < 1) {
                            iTurnMode = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(11, iTurnMode);
                        break;
                    case R.id.btn_plus17 /* 2131427506 */:
                        int iTurnMode2 = DataCanbus.DATA[115] + 1;
                        if (iTurnMode2 > 3) {
                            iTurnMode2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(11, iTurnMode2);
                        break;
                    case R.id.btn_minus18 /* 2131427507 */:
                        int iHome = DataCanbus.DATA[123] - 1;
                        if (iHome < 1) {
                            iHome = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(18, iHome);
                        break;
                    case R.id.btn_plus18 /* 2131427509 */:
                        int iHome2 = DataCanbus.DATA[123] + 1;
                        if (iHome2 > 3) {
                            iHome2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(18, iHome2);
                        break;
                    case R.id.ctv_checkedtext1 /* 2131427554 */:
                        GS4SetAct_Bnr.this.setCMD(28, DataCanbus.DATA[152] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext4 /* 2131427561 */:
                        GS4SetAct_Bnr.this.setCMD(31, DataCanbus.DATA[155] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext5 /* 2131427562 */:
                        GS4SetAct_Bnr.this.setCMD(32, DataCanbus.DATA[156] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext2 /* 2131427576 */:
                        GS4SetAct_Bnr.this.setCMD(29, DataCanbus.DATA[153] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext3 /* 2131427577 */:
                        GS4SetAct_Bnr.this.setCMD(30, DataCanbus.DATA[154] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext6 /* 2131427581 */:
                        GS4SetAct_Bnr.this.setCMD(33, DataCanbus.DATA[157] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext7 /* 2131427582 */:
                        GS4SetAct_Bnr.this.setCMD(36, DataCanbus.DATA[160] == 1 ? 2 : 1);
                        break;
                    case R.id.btn_minus19 /* 2131427593 */:
                        int iLightSense = DataCanbus.DATA[126] - 1;
                        if (iLightSense < 1) {
                            iLightSense = 3;
                        }
                        GS4SetAct_Bnr.this.setCMD(21, iLightSense);
                        break;
                    case R.id.btn_plus19 /* 2131427595 */:
                        int iLightSense2 = DataCanbus.DATA[126] + 1;
                        if (iLightSense2 > 3) {
                            iLightSense2 = 1;
                        }
                        GS4SetAct_Bnr.this.setCMD(21, iLightSense2);
                        break;
                    case R.id.ctv_checkedtext8 /* 2131427633 */:
                        GS4SetAct_Bnr.this.setCMD(34, DataCanbus.DATA[158] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext9 /* 2131427634 */:
                        GS4SetAct_Bnr.this.setCMD(35, DataCanbus.DATA[159] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext10 /* 2131427635 */:
                        GS4SetAct_Bnr.this.setCMD(40, DataCanbus.DATA[165] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext11 /* 2131427636 */:
                        GS4SetAct_Bnr.this.setCMD(43, DataCanbus.DATA[168] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext12 /* 2131427637 */:
                        GS4SetAct_Bnr.this.setCMD(44, DataCanbus.DATA[169] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext13 /* 2131427638 */:
                        GS4SetAct_Bnr.this.setCMD(45, DataCanbus.DATA[170] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext14 /* 2131427639 */:
                        GS4SetAct_Bnr.this.setCMD(47, DataCanbus.DATA[172] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext15 /* 2131427640 */:
                        GS4SetAct_Bnr.this.setCMD(49, DataCanbus.DATA[174] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext16 /* 2131427641 */:
                        GS4SetAct_Bnr.this.setCMD(51, DataCanbus.DATA[176] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext17 /* 2131427642 */:
                        GS4SetAct_Bnr.this.setCMD(43, DataCanbus.DATA[168] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext18 /* 2131427764 */:
                        GS4SetAct_Bnr.this.setCMD(44, DataCanbus.DATA[169] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext19 /* 2131427766 */:
                        GS4SetAct_Bnr.this.setCMD(47, DataCanbus.DATA[172] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext20 /* 2131427768 */:
                        GS4SetAct_Bnr.this.setCMD(48, DataCanbus.DATA[173] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext21 /* 2131427770 */:
                        GS4SetAct_Bnr.this.setCMD(49, 1);
                        break;
                    case R.id.ctv_checkedtext22 /* 2131427772 */:
                        GS4SetAct_Bnr.this.setCMD(61, DataCanbus.DATA[218] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext23 /* 2131427775 */:
                        GS4SetAct_Bnr.this.setCMD(62, DataCanbus.DATA[219] == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext25 /* 2131427782 */:
                        GS4SetAct_Bnr.this.sendCmd(22);
                        break;
                    case R.id.ctv_checkedtext26 /* 2131427824 */:
                        GS4SetAct_Bnr.this.sendCmd(23);
                        break;
                    case R.id.ctv_checkedtext27 /* 2131427825 */:
                        int iAutoCompress = DataCanbus.DATA[131];
                        GS4SetAct_Bnr.this.setCMD(2, iAutoCompress == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext28 /* 2131427826 */:
                        int iAutoCycle = DataCanbus.DATA[107];
                        GS4SetAct_Bnr.this.setCMD(3, iAutoCycle == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext29 /* 2131427827 */:
                        int iNegIons = DataCanbus.DATA[127];
                        GS4SetAct_Bnr.this.setCMD(24, iNegIons == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext30 /* 2131427838 */:
                        int iSeatHeatLeft = DataCanbus.DATA[109];
                        GS4SetAct_Bnr.this.setCMD(5, iSeatHeatLeft == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext31 /* 2131427839 */:
                        int iSeatHeatRight = DataCanbus.DATA[110];
                        GS4SetAct_Bnr.this.setCMD(6, iSeatHeatRight == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext32 /* 2131427840 */:
                        int iRemoteUnlock = DataCanbus.DATA[116];
                        GS4SetAct_Bnr.this.setCMD(12, iRemoteUnlock == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext33 /* 2131427841 */:
                        int iSpeedlock = DataCanbus.DATA[117];
                        GS4SetAct_Bnr.this.setCMD(13, iSpeedlock == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext34 /* 2131427842 */:
                        int iAutoUnlock = DataCanbus.DATA[118];
                        GS4SetAct_Bnr.this.setCMD(14, iAutoUnlock == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext35 /* 2131427843 */:
                        int iRemoteLeftTopWindow = DataCanbus.DATA[119];
                        GS4SetAct_Bnr.this.setCMD(15, iRemoteLeftTopWindow == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext36 /* 2131427844 */:
                        int iRainBrush = DataCanbus.DATA[120];
                        GS4SetAct_Bnr.this.setCMD(16, iRainBrush == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext37 /* 2131427855 */:
                        int iRearRainBrushAutoStart = DataCanbus.DATA[121];
                        GS4SetAct_Bnr.this.setCMD(17, iRearRainBrushAutoStart == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext38 /* 2131427856 */:
                        int iRearMirrorFold = DataCanbus.DATA[130];
                        GS4SetAct_Bnr.this.setCMD(27, iRearMirrorFold == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext39 /* 2131427857 */:
                        int iWelcome = DataCanbus.DATA[128];
                        GS4SetAct_Bnr.this.setCMD(25, iWelcome == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext40 /* 2131427858 */:
                        int iSmartKeyIndentify = DataCanbus.DATA[129];
                        GS4SetAct_Bnr.this.setCMD(26, iSmartKeyIndentify == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext41 /* 2131427859 */:
                        int iFrogTurn = DataCanbus.DATA[124];
                        GS4SetAct_Bnr.this.setCMD(19, iFrogTurn == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext42 /* 2131427860 */:
                        int iDayLight = DataCanbus.DATA[125];
                        GS4SetAct_Bnr.this.setCMD(20, iDayLight == 1 ? 2 : 1);
                        break;
                    case R.id.ctv_checkedtext43 /* 2131427861 */:
                        GS4SetAct_Bnr.this.showResetDlg();
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(final int cmd) {
        setCMD(cmd, 2);
        this.mHandler.postDelayed(new Runnable() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.6
            @Override // java.lang.Runnable
            public void run() {
                DataCanbus.PROXY.cmd(0, new int[]{cmd, 1}, null, null);
            }
        }, 200L);
    }

    protected void showResetDlg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.factory_data_reset)) + "?");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GS4SetAct_Bnr.this.setCMD(0, 255);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.wc.gs4.GS4SetAct_Bnr.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(0, new int[]{cmd, val}, null, null);
    }

    private void setUI() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_OD_AION_EV /* 2228504 */:
            case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                findViewById(R.id.wc_gs4_language_txt).setVisibility(8);
                break;
            default:
                findViewById(R.id.wc_gs4_language_txt).setVisibility(0);
                break;
        }
        bindViewClick(R.id.btn_minus12);
        bindViewClick(R.id.btn_plus12);
        bindViewClick(R.id.btn_minus13);
        bindViewClick(R.id.btn_plus13);
        bindViewClick(R.id.btn_minus14);
        bindViewClick(R.id.btn_plus14);
        bindViewClick(R.id.btn_minus15);
        bindViewClick(R.id.btn_plus15);
        bindViewClick(R.id.btn_minus16);
        bindViewClick(R.id.btn_plus16);
        bindViewClick(R.id.btn_minus17);
        bindViewClick(R.id.btn_plus17);
        bindViewClick(R.id.btn_minus18);
        bindViewClick(R.id.btn_plus18);
        bindViewClick(R.id.btn_plus19);
        bindViewClick(R.id.btn_minus19);
        bindViewClick(R.id.ctv_checkedtext43);
        bindViewClick(R.id.ctv_checkedtext25);
        bindViewClick(R.id.ctv_checkedtext26);
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
        bindViewClick(R.id.ctv_checkedtext22);
        bindViewClick(R.id.ctv_checkedtext23);
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
        findViewById(R.id.layout_view62).setVisibility(8);
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
        findViewById(R.id.layout_view61).setVisibility(8);
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
            case FinalCanbus.CAR_RZC_OD_AION_EV_25 /* 2556184 */:
                findViewById(R.id.layout_view1).setVisibility(0);
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
                findViewById(R.id.layout_view25).setVisibility(0);
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
            case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES /* 2359576 */:
            case FinalCanbus.CAR_RZC_XP1_ChuanQi_AION_23ES_R /* 2490648 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_ChuanQi_AIRTREKEV_22 /* 2425112 */:
                findViewById(R.id.all_func_btn_lauguage_set_view).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view61).setVisibility(0);
                findViewById(R.id.layout_text_view5).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public View bindViewClick(int id) {
        View v = findViewById(id);
        if (v != null) {
            setClick(v);
        }
        return v;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet2(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext27), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet3(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext28), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet4(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text12);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet5(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext30), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet6(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext31), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet7(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text13);
        if (v != null) {
            v.setText(String.valueOf(val * 10) + "km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet8(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text14);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet9(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text15);
        if (v != null) {
            v.setText(String.valueOf(val) + getResources().getString(R.string.time_minutes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet10(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text16);
        if (v != null) {
            v.setText(String.valueOf(val) + getResources().getString(R.string.time_minutes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet11(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text17);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet12(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext32), val == 1);
        TextView v = (TextView) findViewById(R.id.wc_gs4_romote_unlock_TV);
        if (v != null) {
            int id = R.string.str_gs4_acc_all_door;
            if (val == 2) {
                id = R.string.str_gs4_acc_left_door;
            }
            v.setText(id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet13(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext33), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet14(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext34), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet15(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext35), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet16(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext36), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet17(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext37), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet19(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text18);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet20(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext41), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet21(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext42), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet22(int val) {
        TextView v = (TextView) findViewById(R.id.tv_text19);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet23(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext29), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet24(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext39), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet25(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext40), val == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uSet26(int val) {
        setCheck((CheckedTextView) bindViewClick(R.id.ctv_checkedtext38), val == 1);
    }
}
