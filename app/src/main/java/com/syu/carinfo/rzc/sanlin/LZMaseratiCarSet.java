package com.syu.carinfo.rzc.sanlin;

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
public class LZMaseratiCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZMaseratiCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 102:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 103:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 104:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text2)).setText("℉");
                            break;
                        } else {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text2)).setText("℃");
                            break;
                        }
                    }
                    break;
                case 105:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 0) {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text3)).setText("l/100km");
                            break;
                        } else if (value == 1) {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text3)).setText("mpg(uk)");
                            break;
                        } else if (value == 2) {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text3)).setText("km/l");
                            break;
                        } else if (value == 3) {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text3)).setText("mpg(us)");
                            break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 107:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 108:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 109:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 110:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 111:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 112:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 113:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text5)).setText("mil");
                            break;
                        } else {
                            ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text5)).setText("km");
                            break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 115:
                    LZMaseratiCarSet.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_maserati_settings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZMaseratiCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZMaseratiCarSet.this.language_set = position;
                if (LZMaseratiCarSet.this.language_set >= 0 && LZMaseratiCarSet.this.language_set <= LZMaseratiCarSet.this.mLauStylelist.size() && LZMaseratiCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{12, LZMaseratiCarSet.this.send_lang[LZMaseratiCarSet.this.language_set]}, null, null);
                }
                LZMaseratiCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[115];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5, 6};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZMaseratiCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZMaseratiCarSet.this.mLauStyle == null) {
                    LZMaseratiCarSet.this.initLauStyle();
                }
                if (LZMaseratiCarSet.this.mLauStyle != null && LZMaseratiCarSet.this.mPopShowView != null) {
                    LZMaseratiCarSet.this.mLauStyle.showAtLocation(LZMaseratiCarSet.this.mPopShowView, 17, 0, 0);
                    LZMaseratiCarSet.this.updateLauguageSet();
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[103];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[102] - 5;
                if (value2 < 30) {
                    value2 = 250;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[102] + 5;
                if (value3 > 250) {
                    value3 = 30;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[104] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[104] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[105] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[105] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[106] - 1;
                if (value8 < 0) {
                    value8 = 7;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[106] + 1;
                if (value9 > 7) {
                    value9 = 0;
                }
                setCarInfo(4, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int i = DataCanbus.DATA[113];
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int i2 = DataCanbus.DATA[113];
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value10 = DataCanbus.DATA[114] - 1;
                if (value10 < 1) {
                    value10 = 3;
                }
                setCarInfo(8, value10);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value11 = DataCanbus.DATA[114] + 1;
                if (value11 > 3) {
                    value11 = 1;
                }
                setCarInfo(8, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value12 = DataCanbus.DATA[107];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(5, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value13 = DataCanbus.DATA[108];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(6, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value14 = DataCanbus.DATA[109];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(7, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value15 = DataCanbus.DATA[110];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(9, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value16 = DataCanbus.DATA[111];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(10, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value17 = DataCanbus.DATA[112];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(11, value17);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }
}
