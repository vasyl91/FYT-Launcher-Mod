package com.syu.carinfo.rzc.havalh6;

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
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_0439_HavalH9AmpSetAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.RZC_0439_HavalH9AmpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 142:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 143:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 144:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 145:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 146:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)).setText("R" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)).setText("L" + (10 - value));
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 147:
                    if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)).setText("R" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)).setText("F" + (10 - value));
                        } else {
                            ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 148:
                    if (RZC_0439_HavalH9AmpSetAct.this.iSODCanbus()) {
                        RZC_0439_HavalH9AmpSetAct.this.updateLauguageSet();
                    } else if (((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 149:
                    if (RZC_0439_HavalH9AmpSetAct.this.iSODCanbus()) {
                        RZC_0439_HavalH9AmpSetAct.this.setCheck((CheckedTextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 2);
                    } else {
                        RZC_0439_HavalH9AmpSetAct.this.setCheck((CheckedTextView) RZC_0439_HavalH9AmpSetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_h9_amp_settings);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage5, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.havalh6.RZC_0439_HavalH9AmpSetAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                RZC_0439_HavalH9AmpSetAct.this.language_set = position;
                if (RZC_0439_HavalH9AmpSetAct.this.language_set >= 0 && RZC_0439_HavalH9AmpSetAct.this.language_set <= RZC_0439_HavalH9AmpSetAct.this.mLauStylelist.size() && RZC_0439_HavalH9AmpSetAct.this.send_lang != null) {
                    RZC_0439_HavalH9AmpSetAct.this.setCarInfo(8, RZC_0439_HavalH9AmpSetAct.this.send_lang[RZC_0439_HavalH9AmpSetAct.this.language_set]);
                }
                RZC_0439_HavalH9AmpSetAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[148];
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
        this.mLauStylelist.add(getResources().getString(R.string.klc_Parking_with_trailer_Off));
        this.mLauStylelist.add(getResources().getString(R.string.klc_Parking_with_trailer_ON));
        this.mLauStylelist.add(getResources().getString(R.string.lingdu_air_con_profile_0));
        this.mLauStylelist.add(getResources().getString(R.string.lingdu_air_con_profile_1));
        this.mLauStylelist.add(getResources().getString(R.string.lingdu_air_con_profile_2));
        this.send_lang = new int[]{0, 1, 2, 3, 4};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.rzc.havalh6.RZC_0439_HavalH9AmpSetAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (RZC_0439_HavalH9AmpSetAct.this.mLauStyle == null) {
                    RZC_0439_HavalH9AmpSetAct.this.initLauStyle();
                }
                if (RZC_0439_HavalH9AmpSetAct.this.mLauStyle != null && RZC_0439_HavalH9AmpSetAct.this.mPopShowView != null) {
                    RZC_0439_HavalH9AmpSetAct.this.mLauStyle.showAtLocation(RZC_0439_HavalH9AmpSetAct.this.mPopShowView, 17, 0, 0);
                    RZC_0439_HavalH9AmpSetAct.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
        if (iSODCanbus()) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(8);
        } else {
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }

    public boolean iSODCanbus() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H /* 1769911 */:
            case FinalCanbus.CAR_RZC_Haval_H9 /* 2490807 */:
            case FinalCanbus.CAR_RZC_Haval_H9_H /* 2556343 */:
            case FinalCanbus.CAR_455_OD_Haval_H7 /* 12124615 */:
            case FinalCanbus.CAR_455_OD_Haval_H7_H /* 12190151 */:
            case FinalCanbus.CAR_439_OuDi_Haval_H9_H_RS /* 15663543 */:
            case FinalCanbus.CAR_452_OD_Haval_VV5_H /* 16318916 */:
            case FinalCanbus.CAR_452_OD_Haval_VV6_H /* 16384452 */:
            case FinalCanbus.CAR_452_OD_Haval_VV7_H /* 16449988 */:
                return true;
            default:
                return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int bass = DataCanbus.DATA[145];
                if (bass > 0) {
                    bass--;
                }
                if (iSODCanbus()) {
                    setCarInfo(4, bass);
                } else {
                    setCarInfo(5, bass);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int bass2 = DataCanbus.DATA[145];
                if (bass2 < 20) {
                    bass2++;
                }
                if (iSODCanbus()) {
                    setCarInfo(4, bass2);
                } else {
                    setCarInfo(5, bass2);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int mid = DataCanbus.DATA[144];
                if (mid > 0) {
                    mid--;
                }
                if (iSODCanbus()) {
                    setCarInfo(3, mid);
                } else {
                    setCarInfo(4, mid);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int mid2 = DataCanbus.DATA[144];
                if (mid2 < 20) {
                    mid2++;
                }
                if (iSODCanbus()) {
                    setCarInfo(3, mid2);
                } else {
                    setCarInfo(4, mid2);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int treb = DataCanbus.DATA[143];
                if (treb > 0) {
                    treb--;
                }
                if (iSODCanbus()) {
                    setCarInfo(2, treb);
                } else {
                    setCarInfo(3, treb);
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int treb2 = DataCanbus.DATA[143];
                if (treb2 < 20) {
                    treb2++;
                }
                if (iSODCanbus()) {
                    setCarInfo(2, treb2);
                } else {
                    setCarInfo(3, treb2);
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int bal = DataCanbus.DATA[146];
                if (bal > 0) {
                    bal--;
                }
                if (iSODCanbus()) {
                    setCarInfo(5, bal);
                } else {
                    setCarInfo(2, bal);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int bal2 = DataCanbus.DATA[146];
                if (bal2 < 20) {
                    bal2++;
                }
                if (iSODCanbus()) {
                    setCarInfo(5, bal2);
                } else {
                    setCarInfo(2, bal2);
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int fad = DataCanbus.DATA[147];
                if (fad > 0) {
                    fad--;
                }
                if (iSODCanbus()) {
                    setCarInfo(6, fad);
                } else {
                    setCarInfo(1, fad);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int fad2 = DataCanbus.DATA[147];
                if (fad2 < 20) {
                    fad2++;
                }
                if (iSODCanbus()) {
                    setCarInfo(6, fad2);
                } else {
                    setCarInfo(1, fad2);
                }
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value = DataCanbus.DATA[148];
                if (value > 0) {
                    value--;
                }
                if (iSODCanbus()) {
                    setCarInfo(8, value);
                } else {
                    setCarInfo(6, value);
                }
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value2 = DataCanbus.DATA[148];
                if (value2 < 3) {
                    value2++;
                }
                if (iSODCanbus()) {
                    setCarInfo(8, value2);
                } else {
                    setCarInfo(6, value2);
                }
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value3 = DataCanbus.DATA[142];
                if (value3 > 0) {
                    value3--;
                }
                if (iSODCanbus()) {
                    setCarInfo(1, value3);
                }
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value4 = DataCanbus.DATA[142];
                if (value4 < 40) {
                    value4++;
                }
                if (iSODCanbus()) {
                    setCarInfo(1, value4);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value5 = DataCanbus.DATA[149];
                if (iSODCanbus()) {
                    if (value5 == 1) {
                        value5 = 2;
                    } else {
                        value5 = 1;
                    }
                } else if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(7, value5);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        if (iSODCanbus()) {
            DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
        } else {
            DataCanbus.PROXY.cmd(6, new int[]{value0, value1}, null, null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(7, new int[]{49}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
    }
}
