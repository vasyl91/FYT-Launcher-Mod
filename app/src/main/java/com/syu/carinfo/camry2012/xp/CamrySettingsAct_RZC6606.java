package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamrySettingsAct_RZC6606 extends BaseActivity {
    public static CamrySettingsAct_RZC6606 mInit;
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 29:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text17)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text17)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 30:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text18)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text18)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 31:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text24)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text24)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 32:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text25)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text25)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 115:
                    CamrySettingsAct_RZC6606.this.mUpdaterDayTimeRuningLights();
                    break;
                case 116:
                    CamrySettingsAct_RZC6606.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 117:
                    CamrySettingsAct_RZC6606.this.mUpdaterInteriorLightOffTime();
                    break;
                case 118:
                    CamrySettingsAct_RZC6606.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 119:
                    CamrySettingsAct_RZC6606.this.mUpdaterAutolockBySpeed();
                    break;
                case 120:
                    CamrySettingsAct_RZC6606.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 121:
                    CamrySettingsAct_RZC6606.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 122:
                    CamrySettingsAct_RZC6606.this.mUpdaterRemote2PressUnlock();
                    break;
                case 123:
                    CamrySettingsAct_RZC6606.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 124:
                    CamrySettingsAct_RZC6606.this.m2TimesKeyUnLock();
                    break;
                case 125:
                    CamrySettingsAct_RZC6606.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 126:
                    CamrySettingsAct_RZC6606.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 127:
                    CamrySettingsAct_RZC6606.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 128:
                    CamrySettingsAct_RZC6606.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 129:
                    CamrySettingsAct_RZC6606.this.mUpdaterElectric();
                    break;
                case 130:
                    CamrySettingsAct_RZC6606.this.mUpdaterAirByAutoKey();
                    break;
                case 131:
                    CamrySettingsAct_RZC6606.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 132:
                    CamrySettingsAct_RZC6606.this.mUpdaterLoucs();
                    break;
                case 133:
                    CamrySettingsAct_RZC6606.this.mUpdaterLoucsenable();
                    break;
                case 156:
                    CamrySettingsAct_RZC6606.this.updateAuotAC();
                    break;
                case 157:
                    CamrySettingsAct_RZC6606.this.updateBlowEffective();
                    break;
                case 159:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 160:
                    if (((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 161:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 162:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text2)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 165:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.wc_psa_all_lauguage_set_value_20);
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_0);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_15);
                                break;
                            case 4:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_14);
                                break;
                            case 5:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_35);
                                break;
                            case 6:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_21);
                                break;
                            case 7:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_29);
                                break;
                            case 8:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_9);
                                break;
                            case 9:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_37);
                                break;
                            case 10:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_26);
                                break;
                            case 11:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_8);
                                break;
                            case 12:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_31);
                                break;
                            case 13:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_12);
                                break;
                            case 14:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_16);
                                break;
                            case 15:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_27);
                                break;
                            case 16:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_40);
                                break;
                            case 17:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_39);
                                break;
                            case 18:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_18);
                                break;
                            case 19:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_7);
                                break;
                            case 20:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_33);
                                break;
                            case 21:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.rzc_others_language_setting_30);
                                break;
                            case 22:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_language_set0);
                                break;
                        }
                    }
                    break;
                case 167:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text6)).setText("On");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text6)).setText(R.string.str_214_proda_9);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text6)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 168:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text4)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            default:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text4)).setText("Off");
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 188:
                    if (((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 8);
                        break;
                    }
                case 196:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text16)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text16)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text16)).setText("倾斜和伸缩");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text16)).setText(R.string.str_tilt);
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text16)).setText("伸缩");
                                break;
                        }
                    }
                    break;
                case 197:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text13)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 198:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text14)).setText(new StringBuilder().append(value - 5).toString());
                        break;
                    }
                case 199:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text15)) != null) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text15)).setText(new StringBuilder().append(value - 5).toString());
                        break;
                    }
                case 205:
                    if (((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                        break;
                    }
                case 207:
                    if (((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text22)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text22)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text22)).setText("部分");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text22)).setText("全部");
                                break;
                        }
                    }
                    break;
                case 220:
                    switch (value) {
                        case 0:
                            ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text26)).setText(R.string.str_no_delay);
                            break;
                        case 1:
                            ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text26)).setText(R.string.str_delay1);
                            break;
                        case 2:
                            ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text26)).setText(R.string.str_delay2);
                            break;
                        case 3:
                            ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text26)).setText(R.string.str_delay3);
                            break;
                    }
                case 222:
                    CamrySettingsAct_RZC6606.this.updateLauguageSet();
                    break;
                case 223:
                    ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text27)).setText(new StringBuilder().append(value).toString());
                    break;
                case 224:
                    ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
                    break;
                case 225:
                    ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext15)).setChecked(value != 0);
                    break;
                case 226:
                    ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
                    break;
                case 227:
                    ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
                    break;
                case 228:
                    ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
                    break;
                case 230:
                    if (value == 1) {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text28)).setText(R.string.str_244_als2);
                        break;
                    } else {
                        ((TextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.tv_text28)).setText(R.string.str_244_als1);
                        break;
                    }
                case 239:
                    if (((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext27)) != null) {
                        ((CheckedTextView) CamrySettingsAct_RZC6606.this.findViewById(R.id.ctv_checkedtext27)).setChecked(value == 1);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_settings_rzc6606);
        this.mHandler = new Handler(Looper.getMainLooper());
        init();
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
                CamrySettingsAct_RZC6606.this.language_set = position;
                if (CamrySettingsAct_RZC6606.this.language_set >= 0 && CamrySettingsAct_RZC6606.this.language_set <= CamrySettingsAct_RZC6606.this.mLauStylelist.size() && CamrySettingsAct_RZC6606.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(151, new int[]{4, CamrySettingsAct_RZC6606.this.send_lang[CamrySettingsAct_RZC6606.this.language_set]}, null, null);
                }
                CamrySettingsAct_RZC6606.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[222];
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("0");
        this.mLauStylelist.add("3");
        this.mLauStylelist.add("4");
        this.mLauStylelist.add("5");
        this.mLauStylelist.add("6");
        this.mLauStylelist.add("7");
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (CamrySettingsAct_RZC6606.this.mLauStyle == null) {
                    CamrySettingsAct_RZC6606.this.initLauStyle();
                }
                if (CamrySettingsAct_RZC6606.this.mLauStyle != null && CamrySettingsAct_RZC6606.this.mPopShowView != null) {
                    CamrySettingsAct_RZC6606.this.mLauStyle.showAtLocation(CamrySettingsAct_RZC6606.this.mPopShowView, 17, 0, 0);
                    CamrySettingsAct_RZC6606.this.updateLauguageSet();
                }
            }
        });
        mInit = this;
        findViewById(R.id.layout_view63).setVisibility(0);
        findViewById(R.id.layout_view64).setVisibility(0);
        findViewById(R.id.layout_view65).setVisibility(0);
        findViewById(R.id.layout_view66).setVisibility(0);
        findViewById(R.id.layout_view67).setVisibility(0);
        findViewById(R.id.layout_view68).setVisibility(0);
        findViewById(R.id.layout_view69).setVisibility(0);
        findViewById(R.id.layout_view70).setVisibility(0);
        findViewById(R.id.layout_view79).setVisibility(0);
        findViewById(R.id.layout_view80).setVisibility(0);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[160];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{22, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{22}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[188];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(24, new int[]{3, 8}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(24, new int[]{3, 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[205];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(50, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(50, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[224] & 255;
                int value1 = DataCanbus.DATA[225] & 255;
                int value2 = DataCanbus.DATA[226] & 255;
                int value3 = DataCanbus.DATA[227] & 255;
                int value4 = DataCanbus.DATA[228] & 255;
                if (value0 == 0) {
                    value0 = 1;
                } else if (value0 == 1) {
                    value0 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[224] & 255;
                int value1 = DataCanbus.DATA[225] & 255;
                int value2 = DataCanbus.DATA[226] & 255;
                int value3 = DataCanbus.DATA[227] & 255;
                int value4 = DataCanbus.DATA[228] & 255;
                if (value1 == 0) {
                    value1 = 1;
                } else if (value1 == 1) {
                    value1 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[224] & 255;
                int value1 = DataCanbus.DATA[225] & 255;
                int value2 = DataCanbus.DATA[226] & 255;
                int value3 = DataCanbus.DATA[227] & 255;
                int value4 = DataCanbus.DATA[228] & 255;
                if (value2 == 0) {
                    value2 = 1;
                } else if (value2 == 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[224] & 255;
                int value1 = DataCanbus.DATA[225] & 255;
                int value2 = DataCanbus.DATA[226] & 255;
                int value3 = DataCanbus.DATA[227] & 255;
                int value4 = DataCanbus.DATA[228] & 255;
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value0 = DataCanbus.DATA[224] & 255;
                int value1 = DataCanbus.DATA[225] & 255;
                int value2 = DataCanbus.DATA[226] & 255;
                int value3 = DataCanbus.DATA[227] & 255;
                int value4 = DataCanbus.DATA[228] & 255;
                if (value4 == 0) {
                    value4 = 1;
                } else if (value4 == 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(152, new int[]{value0, value1, value2, value3, value4}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[239];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(50, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(50, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus22)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[207];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{29, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus22)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[207];
                if (value < 2) {
                    DataCanbus.PROXY.cmd(40, new int[]{29, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[197];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{25, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[197];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(40, new int[]{25, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[198];
                if (value > 3) {
                    value--;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{26, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus14)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[198];
                if (value < 7) {
                    value++;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{26, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[199];
                if (value > 3) {
                    value--;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{27, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus15)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[199];
                if (value < 7) {
                    value++;
                }
                if (value < 3) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{27, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[196];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{28, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus16)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[196];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(40, new int[]{28, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 8;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus17)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 16;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus18)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 2;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus18)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 4;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus25)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 32;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus25)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 32;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus24)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 64;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_plus24)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[6];
                iArr[2] = 64;
                remoteModuleProxy.cmd(41, iArr, null, null);
                CamrySettingsAct_RZC6606.this.mHandler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(41, new int[6], null, null);
                    }
                }, 200L);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[161];
                if (value > 1) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[161];
                if (value < 5) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[159];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[159];
                if (value2 == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[168] + 4;
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(40, new int[]{12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[168] + 4;
                if (value > 4) {
                    DataCanbus.PROXY.cmd(40, new int[]{12, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[165] + 1;
                if (value > 22) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{38, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[165] - 1;
                if (value < 0) {
                    value = 22;
                }
                DataCanbus.PROXY.cmd(40, new int[]{38, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[167] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{37, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[167];
                if (value - 1 < 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{37, 2}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[169] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{36, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[169] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{36, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(40, new int[]{24, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(40, new int[]{24, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[162];
                if (value2 == 0) {
                    value = 3;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[162];
                if (value2 == 0) {
                    value = 3;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus19)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus19)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus20)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 17}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus20)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(40, new int[]{65, 16}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus26)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[220] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus26)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = (DataCanbus.DATA[220] & 255) + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(151, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus27)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[223] - 1;
                if (value < 0) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(151, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus27)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[223] + 1;
                if (value > 9) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(151, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus28)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[230] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus28)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[230] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{57, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_auto_ac)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[156];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(37, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(37, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_blow_effective)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[157];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(38, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(38, new int[1], null, null);
                }
            }
        });
        findViewById(R.id.layout_view21).setVisibility(8);
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[122];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_lock_set_lock_unlock_feedback_tone_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_lock_set_lock_unlock_feedback_tone_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[123];
                if (value < 6) {
                    DataCanbus.PROXY.cmd(6, new int[]{value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(12, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(13, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[126];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(14, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[128];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(17, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(17, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(18, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(18, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[115];
                if (value == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(11, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_headlamps_auto_off_timer_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_headlamps_auto_off_timer_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[118];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(7, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_electric_door_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_electric_door_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[129];
                if (value < 4) {
                    DataCanbus.PROXY.cmd(19, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_loucs_set_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.xp_loucs_set_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[132];
                if (value < 2) {
                    DataCanbus.PROXY.cmd(21, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_auto_relock_time_minus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[206];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{20, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.camry_btn_auto_relock_time_plus)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[206];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(40, new int[]{20, value + 1}, null, null);
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(43, new int[]{38}, null, null);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view1).setVisibility(0);
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
        findViewById(R.id.layout_view12).setVisibility(0);
        findViewById(R.id.layout_view13).setVisibility(0);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(0);
        findViewById(R.id.layout_view16).setVisibility(0);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view61).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(0);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(0);
        findViewById(R.id.layout_view23).setVisibility(0);
        findViewById(R.id.layout_view24).setVisibility(0);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_text_view1).setVisibility(0);
        findViewById(R.id.layout_view26).setVisibility(0);
        findViewById(R.id.layout_view27).setVisibility(0);
        findViewById(R.id.layout_view28).setVisibility(0);
        findViewById(R.id.layout_view29).setVisibility(0);
        findViewById(R.id.layout_bnr_camry).setVisibility(8);
        findViewById(R.id.layout_text_view2).setVisibility(0);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_view58).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
        findViewById(R.id.layout_view71).setVisibility(8);
        findViewById(R.id.layout_view72).setVisibility(8);
        findViewById(R.id.layout_view73).setVisibility(8);
        findViewById(R.id.layout_view74).setVisibility(8);
        findViewById(R.id.layout_view75).setVisibility(8);
        findViewById(R.id.layout_view76).setVisibility(8);
        findViewById(R.id.layout_view77).setVisibility(8);
        findViewById(R.id.layout_view78).setVisibility(8);
        int i = DataCanbus.DATA[1000];
        findViewById(R.id.layout_view25).setVisibility(0);
        findViewById(R.id.layout_view54).setVisibility(0);
        findViewById(R.id.layout_view55).setVisibility(0);
        findViewById(R.id.layout_view61).setVisibility(0);
        findViewById(R.id.layout_view62).setVisibility(0);
        findViewById(R.id.layout_text_view2).setVisibility(0);
        findViewById(R.id.layout_view30).setVisibility(0);
        findViewById(R.id.layout_view31).setVisibility(0);
        findViewById(R.id.layout_view32).setVisibility(0);
        findViewById(R.id.layout_view33).setVisibility(0);
        findViewById(R.id.layout_view35).setVisibility(0);
        findViewById(R.id.layout_view36).setVisibility(0);
        findViewById(R.id.layout_view58).setVisibility(0);
        findViewById(R.id.layout_view53).setVisibility(0);
        if (DataCanbus.DATA[1000] == 3735664) {
            findViewById(R.id.layout_view24).setVisibility(8);
        }
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
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
    }

    private void updateAutoRelockTime() {
        if (((TextView) findViewById(R.id.camry_tv_auto_relock_time)) != null) {
            int value = DataCanbus.DATA[206];
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.camry_tv_auto_relock_time)).setText(R.string.klc_onstar_call_alarm_off);
                    break;
            }
        }
    }

    
    public void updateAuotAC() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_auto_ac)) != null) {
            int value = DataCanbus.DATA[156];
            ((CheckedTextView) findViewById(R.id.camry_btn_auto_ac)).setChecked(value != 0);
        }
    }

    
    public void updateBlowEffective() {
        if (((CheckedTextView) findViewById(R.id.camry_btn_blow_effective)) != null) {
            int value = DataCanbus.DATA[157];
            ((CheckedTextView) findViewById(R.id.camry_btn_blow_effective)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLoucs() {
        int value = DataCanbus.DATA[132];
        if (((TextView) findViewById(R.id.xp_loucs_set_show)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model0_string);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model1_string);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model2_string);
                    break;
                default:
                    ((TextView) findViewById(R.id.xp_loucs_set_show)).setText(R.string.xp_loucs_model0_string);
                    break;
            }
        }
    }

    
    public void mUpdaterLoucsenable() {
    }

    
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[119];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_auto_lock_by_speed)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[120];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autolock_by_shift_from_p)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[121];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_autounlock_by_shift_to_p)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[122];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_remote_2_press_unlock)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnlockFeedbackTone() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.camry_tv_lock_set_lock_unlock_feedback_tone)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_lock_unlock_feedback_tone)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[124];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_operation_key_two_times)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[125];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_driver_door_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[126];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_unlock_intelligent_door)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[127];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_intelligent_lock_and_one_key_start)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[128];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lock_set_lock_unlock_emergency_flashers_response)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[130];
        if (((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_air_conditioning_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[131];
        if (((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_climate_set_gas_switch_and_AUTO_bond_linkage)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[115];
        if (((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)) != null) {
            ((CheckedTextView) findViewById(R.id.camry_btn_lights_set_daytime_running_lights)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.camry_tv_sens_cur)) != null) {
            ((TextView) findViewById(R.id.camry_tv_sens_cur)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[117];
        if (((TextView) findViewById(R.id.camry_tv_interior_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.camry_tv_interior_lighting_off_time)).setText(CamryData.mStrInteriorLightOffTime[value]);
        }
    }

    
    public void mUpdaterHeadLampsAutoOffTimer() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.camry_tv_headlamps_auto_off_timer)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.camry_tv_headlamps_auto_off_timer)).setText(CamryData.mStrHeadLampsAutoOffTimer[value]);
        }
    }

    
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[129];
        if (((TextView) findViewById(R.id.camry_tv_electric_door)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_4);
                    break;
                default:
                    ((TextView) findViewById(R.id.camry_tv_electric_door)).setText(R.string.xp_camry_electric_level_0);
                    break;
            }
        }
    }
}
