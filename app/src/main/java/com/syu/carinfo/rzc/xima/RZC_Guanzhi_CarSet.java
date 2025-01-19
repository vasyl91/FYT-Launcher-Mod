package com.syu.carinfo.rzc.xima;

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

public class RZC_Guanzhi_CarSet extends BaseActivity implements View.OnClickListener {
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
                case 107:
                    RZC_Guanzhi_CarSet.this.setCheck((CheckedTextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 108:
                    RZC_Guanzhi_CarSet.this.setCheck((CheckedTextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 109:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value * 5) + "s");
                        break;
                    }
                case 110:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 111:
                    RZC_Guanzhi_CarSet.this.updateLauguageSet();
                    break;
                case 112:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text3)).setText("mile");
                                break;
                            default:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text3)).setText("km");
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                            default:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text5)).setText("℉");
                                break;
                            default:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text5)).setText("℃");
                                break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text6)).setText("mpg");
                                break;
                            case 2:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text6)).setText("km/l");
                                break;
                            default:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text6)).setText("l/100km");
                                break;
                        }
                    }
                    break;
                case 117:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 119:
                    RZC_Guanzhi_CarSet.this.setCheck((CheckedTextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 120:
                    if (((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text8)).setText("头灯+日间行车灯");
                                break;
                            case 2:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text8)).setText("尾灯");
                                break;
                            default:
                                ((TextView) RZC_Guanzhi_CarSet.this.findViewById(R.id.tv_text8)).setText("头灯+日间行车灯+尾灯");
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
        //setContentView(R.layout.layout_0454_rzc_guanzhi_settings);
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
                RZC_Guanzhi_CarSet.this.language_set = position;
                if (RZC_Guanzhi_CarSet.this.language_set >= 0 && RZC_Guanzhi_CarSet.this.language_set <= RZC_Guanzhi_CarSet.this.mLauStylelist.size() && RZC_Guanzhi_CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{4, RZC_Guanzhi_CarSet.this.send_lang[RZC_Guanzhi_CarSet.this.language_set]}, null, null);
                }
                RZC_Guanzhi_CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[111];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZC_Guanzhi_CarSet.this.mLauStyle == null) {
                    RZC_Guanzhi_CarSet.this.initLauStyle();
                }
                if (RZC_Guanzhi_CarSet.this.mLauStyle != null && RZC_Guanzhi_CarSet.this.mPopShowView != null) {
                    RZC_Guanzhi_CarSet.this.mLauStyle.showAtLocation(RZC_Guanzhi_CarSet.this.mPopShowView, 17, 0, 0);
                    RZC_Guanzhi_CarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[109] - 1;
                if (value < 0) {
                    value = 12;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[109] + 1;
                if (value2 > 12) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[110] - 1;
                if (value3 < 0) {
                    value3 = 10;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[110] + 1;
                if (value4 > 10) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[112] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(5, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[112] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(5, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[113] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(6, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[113] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[114] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[114] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[115] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(8, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[115] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(8, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[117];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(10, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[117];
                if (value14 < 100) {
                    value14++;
                }
                setCarInfo(10, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[120] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(12, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[120] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(12, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[107];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(0, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[108];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(2, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value19 = DataCanbus.DATA[119];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(11, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                dialog(R.string.xp_yinglang_car_set_Second_str10, 9);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 1}, null, null);
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

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{50}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
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
    }
}
