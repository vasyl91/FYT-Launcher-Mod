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

public class LZMaseratiCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 115:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 116:
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
                case 117:
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
                case 118:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 119:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 120:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 121:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 122:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 123:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 124:
                    LZMaseratiCarSet.this.setCheck((CheckedTextView) LZMaseratiCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 125:
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
                case 126:
                    if (((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZMaseratiCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 127:
                    LZMaseratiCarSet.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_lz_maserati_settings);
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
        this.mLauStyle.setAnimationStyle(R.style.popAnimationFade);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
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
        int value = DataCanbus.DATA[127];
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
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[114] - 5;
                if (value < 30) {
                    value = 250;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[114] + 5;
                if (value2 > 250) {
                    value2 = 30;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[116] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[116] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[117] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[117] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[118] - 1;
                if (value7 < 0) {
                    value7 = 7;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[118] + 1;
                if (value8 > 7) {
                    value8 = 0;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int i = DataCanbus.DATA[125];
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int i2 = DataCanbus.DATA[125];
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value9 = DataCanbus.DATA[126] - 1;
                if (value9 < 1) {
                    value9 = 3;
                }
                setCarInfo(8, value9);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value10 = DataCanbus.DATA[126] + 1;
                if (value10 > 3) {
                    value10 = 1;
                }
                setCarInfo(8, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value11 = DataCanbus.DATA[115];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(1, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value12 = DataCanbus.DATA[119];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(5, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value13 = DataCanbus.DATA[120];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(6, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value14 = DataCanbus.DATA[121];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(7, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value15 = DataCanbus.DATA[122];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(9, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value16 = DataCanbus.DATA[123];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(10, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value17 = DataCanbus.DATA[124];
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{56}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
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
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
    }
}
