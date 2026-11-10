package com.syu.carinfo.havah6;

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
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class WC_0320_HavalH9SetAct extends BaseActivity implements View.OnClickListener {
    protected Handler mHandler;
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 163:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("0S");
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("10S");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("20S");
                                break;
                            case 3:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                        }
                    }
                    break;
                case 164:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("1Min");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("2Min");
                                break;
                            case 3:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text2)).setText("3Min");
                                break;
                        }
                    }
                    break;
                case 165:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)).setText("10Min");
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)).setText("20Min");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text3)).setText("30Min");
                                break;
                        }
                    }
                    break;
                case 166:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall2);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_244_rainfall1);
                                break;
                        }
                    }
                    break;
                case 167:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_frontlight1);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_frontlight2);
                                break;
                        }
                    }
                    break;
                case 168:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_auto);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_Manual);
                                break;
                        }
                    }
                    break;
                case 169:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText("10Min");
                                break;
                            case 2:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText("20Min");
                                break;
                            case 3:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text7)).setText("30Min");
                                break;
                        }
                    }
                    break;
                case 170:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_WeiChi2_ChangChengH9 /* 328000 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH9_M /* 393536 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH9_H /* 459072 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH8 /* 1573184 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH8_M /* 1638720 */:
                        case FinalCanbus.CAR_WeiChi2_ChangChengH8_H /* 1704256 */:
                            WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext1), value == 0);
                            break;
                        default:
                            WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                            break;
                    }
                    break;
                case 171:
                    if (((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_unlockall_set);
                                break;
                            case 1:
                                ((TextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_unlockdriver_set);
                                break;
                        }
                    }
                    break;
                case 172:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 173:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 174:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 175:
                    WC_0320_HavalH9SetAct.this.setCheck((CheckedTextView) WC_0320_HavalH9SetAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0320_wc_haval_h9_settings);
        this.mHandler = new Handler(Looper.getMainLooper());
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SetAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                WC_0320_HavalH9SetAct.this.language_set = position;
                if (WC_0320_HavalH9SetAct.this.language_set >= 0 && WC_0320_HavalH9SetAct.this.language_set <= WC_0320_HavalH9SetAct.this.mLauStylelist.size() && WC_0320_HavalH9SetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(6, new int[]{1, WC_0320_HavalH9SetAct.this.send_lang[WC_0320_HavalH9SetAct.this.language_set]}, null, null);
                }
                WC_0320_HavalH9SetAct.this.mLauStyle.dismiss();
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
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.havah6.WC_0320_HavalH9SetAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WC_0320_HavalH9SetAct.this.mLauStyle == null) {
                    WC_0320_HavalH9SetAct.this.initLauStyle();
                }
                if (WC_0320_HavalH9SetAct.this.mLauStyle != null && WC_0320_HavalH9SetAct.this.mPopShowView != null) {
                    WC_0320_HavalH9SetAct.this.mLauStyle.showAtLocation(WC_0320_HavalH9SetAct.this.mPopShowView, 17, 0, 0);
                    WC_0320_HavalH9SetAct.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[163] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(16, value, 0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[163] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(16, value2, 0, 0);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[164] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(17, value3, 0, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[164] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(17, value4, 0, 0);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[165] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(18, value5, 0, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[165] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(18, value6, 0, 0);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[166] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(19, value7, 0, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[166] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(19, value8, 0, 0);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[167] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(20, value9, 0, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[167] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(20, value10, 0, 0);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[168] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(21, value11, 0, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[168] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(21, value12, 0, 0);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[169] - 1;
                if (value13 < 0) {
                    value13 = 3;
                }
                setCarInfo(22, value13, 0, 0);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[169] + 1;
                if (value14 > 3) {
                    value14 = 0;
                }
                setCarInfo(22, value14, 0, 0);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[171] - 1;
                if (value15 < 0) {
                    value15 = 1;
                }
                setCarInfo(24, value15, 0, 0);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[171] + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                setCarInfo(24, value16, 0, 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value17 = DataCanbus.DATA[170];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(23, value17, 0, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                int value18 = DataCanbus.DATA[174];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(27, value18, 0, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                int value19 = DataCanbus.DATA[175];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(28, value19, 0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                int value20 = DataCanbus.DATA[172];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(25, value20, 0, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                int value21 = DataCanbus.DATA[173];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(26, value21, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(7, new int[]{value0, value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
    }
}
