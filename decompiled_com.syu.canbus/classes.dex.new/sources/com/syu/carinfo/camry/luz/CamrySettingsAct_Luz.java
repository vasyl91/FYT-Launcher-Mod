package com.syu.carinfo.camry.luz;

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
import com.syu.carinfo.zhtd.bmw.LZToyotaLexRX450LightAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class CamrySettingsAct_Luz extends BaseActivity implements View.OnClickListener {
    public static CamrySettingsAct_Luz mInit;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry.luz.CamrySettingsAct_Luz.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    CamrySettingsAct_Luz.this.mUpdaterDayTimeRuningLights();
                    break;
                case 102:
                    CamrySettingsAct_Luz.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 103:
                    CamrySettingsAct_Luz.this.mUpdaterInteriorLightOffTime();
                    break;
                case 104:
                    CamrySettingsAct_Luz.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 105:
                    CamrySettingsAct_Luz.this.mUpdaterAutolockBySpeed();
                    break;
                case 106:
                    CamrySettingsAct_Luz.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 107:
                    CamrySettingsAct_Luz.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 108:
                    CamrySettingsAct_Luz.this.mUpdaterRemote2PressUnlock();
                    break;
                case 109:
                    CamrySettingsAct_Luz.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 110:
                    CamrySettingsAct_Luz.this.m2TimesKeyUnLock();
                    break;
                case 111:
                    CamrySettingsAct_Luz.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 112:
                    CamrySettingsAct_Luz.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 113:
                    CamrySettingsAct_Luz.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 114:
                    CamrySettingsAct_Luz.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 115:
                    CamrySettingsAct_Luz.this.mUpdaterElectric();
                    break;
                case 116:
                    CamrySettingsAct_Luz.this.mUpdaterAirByAutoKey();
                    break;
                case 117:
                    CamrySettingsAct_Luz.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 118:
                    CamrySettingsAct_Luz.this.mUpdaterLoucs();
                    break;
                case 120:
                    CamrySettingsAct_Luz.this.updateAutoRelockTime();
                    break;
                case 121:
                    CamrySettingsAct_Luz.this.mUpdaterGasSensor();
                    break;
                case 122:
                    CamrySettingsAct_Luz.this.mUpdaterSeatMoveMent();
                    break;
                case 125:
                    if (((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((CheckedTextView) CamrySettingsAct_Luz.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) CamrySettingsAct_Luz.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    }
                    break;
                case 127:
                    if (((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 159:
                    if (((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText("15s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            default:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 162:
                    CamrySettingsAct_Luz.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_toyota_camry_settings);
        mInit = this;
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.camry.luz.CamrySettingsAct_Luz.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                CamrySettingsAct_Luz.this.language_set = position;
                if (CamrySettingsAct_Luz.this.language_set >= 0 && CamrySettingsAct_Luz.this.language_set <= CamrySettingsAct_Luz.this.mLauStylelist.size() && CamrySettingsAct_Luz.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(40, new int[]{39, CamrySettingsAct_Luz.this.send_lang[CamrySettingsAct_Luz.this.language_set]}, null, null);
                }
                CamrySettingsAct_Luz.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[162];
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
        this.mLauStylelist.add("Null");
        this.mLauStylelist.add("2.0");
        this.mLauStylelist.add("3.0");
        this.mLauStylelist.add("2010-2014 prado auto");
        this.mLauStylelist.add("2014 prado hand");
        this.mLauStylelist.add("Lexus IS/GS High");
        this.mLauStylelist.add("Lexus IS/GS Low");
        this.mLauStylelist.add("2011 Lexus RX270");
        this.mLauStylelist.add("2011 LandCruiser");
        this.mLauStylelist.add("2018 LandCruiser High");
        this.send_lang = new int[]{255, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.camry.luz.CamrySettingsAct_Luz.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (CamrySettingsAct_Luz.this.mLauStyle == null) {
                    CamrySettingsAct_Luz.this.initLauStyle();
                }
                if (CamrySettingsAct_Luz.this.mLauStyle != null && CamrySettingsAct_Luz.this.mPopShowView != null) {
                    CamrySettingsAct_Luz.this.mLauStyle.showAtLocation(CamrySettingsAct_Luz.this.mPopShowView, 17, 0, 0);
                    CamrySettingsAct_Luz.this.updateLauguageSet();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 12648900 || DataCanbus.DATA[1000] == 4915655) {
            findViewById(R.id.layout_view30).setVisibility(0);
        } else {
            findViewById(R.id.layout_view30).setVisibility(8);
        }
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value3 = DataCanbus.DATA[127];
                if (value3 > 1) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value3 - 1}, null, null);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value4 = DataCanbus.DATA[127];
                if (value4 < 5) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value4 + 1}, null, null);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                if (DataCanbus.DATA[125] == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value2}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                if (DataCanbus.DATA[125] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value5 = DataCanbus.DATA[109];
                if (value5 > 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{value5 - 1}, null, null);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value6 = DataCanbus.DATA[109];
                if (value6 < 6) {
                    DataCanbus.PROXY.cmd(6, new int[]{value6 + 1}, null, null);
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value7 = DataCanbus.DATA[102];
                if (value7 > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value7 - 1}, null, null);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value8 = DataCanbus.DATA[102];
                if (value8 < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value8 + 1}, null, null);
                }
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value9 = DataCanbus.DATA[103];
                if (value9 > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value9 - 1}, null, null);
                }
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value10 = DataCanbus.DATA[103];
                if (value10 < 3) {
                    DataCanbus.PROXY.cmd(11, new int[]{value10 + 1}, null, null);
                }
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value11 = DataCanbus.DATA[104];
                if (value11 > 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{value11 - 1}, null, null);
                }
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value12 = DataCanbus.DATA[104];
                if (value12 < 3) {
                    DataCanbus.PROXY.cmd(7, new int[]{value12 + 1}, null, null);
                }
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value13 = DataCanbus.DATA[115];
                if (value13 > 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{value13 - 1}, null, null);
                }
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value14 = DataCanbus.DATA[115];
                if (value14 < 4) {
                    DataCanbus.PROXY.cmd(19, new int[]{value14 + 1}, null, null);
                }
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value15 = DataCanbus.DATA[118];
                if (value15 > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value15 - 1}, null, null);
                }
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value16 = DataCanbus.DATA[118];
                if (value16 < 2) {
                    DataCanbus.PROXY.cmd(21, new int[]{value16 + 1}, null, null);
                }
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value17 = DataCanbus.DATA[120];
                if (value17 > 0) {
                    DataCanbus.PROXY.cmd(23, new int[]{value17 - 1}, null, null);
                }
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value18 = DataCanbus.DATA[120];
                if (value18 < 3) {
                    DataCanbus.PROXY.cmd(23, new int[]{value18 + 1}, null, null);
                }
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value19 = DataCanbus.DATA[122];
                if (value19 > 0) {
                    DataCanbus.PROXY.cmd(28, new int[]{value19 - 1}, null, null);
                }
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value20 = DataCanbus.DATA[122];
                if (value20 < 2) {
                    DataCanbus.PROXY.cmd(28, new int[]{value20 + 1}, null, null);
                }
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value21 = DataCanbus.DATA[121];
                if (value21 > 0) {
                    DataCanbus.PROXY.cmd(27, new int[]{value21 - 1}, null, null);
                }
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value22 = DataCanbus.DATA[121];
                if (value22 < 6) {
                    DataCanbus.PROXY.cmd(27, new int[]{value22 + 1}, null, null);
                }
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value23 = DataCanbus.DATA[159] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{43, value23}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value24 = DataCanbus.DATA[159] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{43, value24}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                if (DataCanbus.DATA[126] == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{22, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{22, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[108] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                if (DataCanbus.DATA[105] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[106] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                if (DataCanbus.DATA[110] == 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(12, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                if (DataCanbus.DATA[111] == 0) {
                    DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(13, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                if (DataCanbus.DATA[112] == 0) {
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(14, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                if (DataCanbus.DATA[113] == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                if (DataCanbus.DATA[114] == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                if (DataCanbus.DATA[116] == 0) {
                    DataCanbus.PROXY.cmd(17, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(17, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                if (DataCanbus.DATA[117] == 0) {
                    DataCanbus.PROXY.cmd(18, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(18, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                if (DataCanbus.DATA[101] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZToyotaLexRX450LightAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(43, new int[]{38, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoRelockTime() {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            int value = DataCanbus.DATA[120];
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_onstar_call_alarm_off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoucs() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model0_string);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model1_string);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model2_string);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model0_string);
                    break;
            }
        }
    }

    private void mUpdaterLoucsenable() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnlockFeedbackTone() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[113];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[114];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[116];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[117];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[101];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text6)).setText(CamryData.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterGasSensor() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            ((TextView) findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value + 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatMoveMent() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_sbd_x80_shengchang_0);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.distance_very_close);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.jeep_comfortsystems_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsAutoOffTimer() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_text7)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.tv_text7)).setText(CamryData.mStrHeadLampsAutoOffTimer[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_4);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_0);
                    break;
            }
        }
    }
}
