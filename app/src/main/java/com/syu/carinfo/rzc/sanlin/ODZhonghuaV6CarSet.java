package com.syu.carinfo.rzc.sanlin;

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
import com.syu.carinfo.jili.ODZhonghuaHUDSetActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

public class ODZhonghuaV6CarSet extends BaseActivity implements View.OnClickListener {
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
                case 98:
                    ODZhonghuaV6CarSet.this.updateLauguageSet();
                    break;
                case 99:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 100:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 101:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 102:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 103:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 4) {
                            ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value - 4)).toString());
                            break;
                        } else if (value < 4) {
                            ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text2)).setText("-" + (4 - value));
                            break;
                        }
                    }
                    break;
                case 104:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 105:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_1);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_0);
                                break;
                        }
                    }
                    break;
                case 106:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 2:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                                break;
                            case 3:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 107:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 108:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 109:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_lanesensewarn_2);
                                break;
                            case 2:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_lanesensewarn_1);
                                break;
                            case 3:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.jeep_lanesensewarn_0);
                                break;
                        }
                    }
                    break;
                case 110:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 111:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 112:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text7)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text7)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text7)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 114:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 115:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text8)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text8)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text8)).setText("90s");
                                break;
                            case 4:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text8)).setText("120s");
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
        //setContentView(R.layout.layout_0452_od_zhonghua_v6_settings);
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
                ODZhonghuaV6CarSet.this.language_set = position;
                if (ODZhonghuaV6CarSet.this.language_set >= 0 && ODZhonghuaV6CarSet.this.language_set <= ODZhonghuaV6CarSet.this.mLauStylelist.size() && ODZhonghuaV6CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{0, ODZhonghuaV6CarSet.this.send_lang[ODZhonghuaV6CarSet.this.language_set]}, null, null);
                }
                ODZhonghuaV6CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[98];
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
                if (ODZhonghuaV6CarSet.this.mLauStyle == null) {
                    ODZhonghuaV6CarSet.this.initLauStyle();
                }
                if (ODZhonghuaV6CarSet.this.mLauStyle != null && ODZhonghuaV6CarSet.this.mPopShowView != null) {
                    ODZhonghuaV6CarSet.this.mLauStyle.showAtLocation(ODZhonghuaV6CarSet.this.mPopShowView, 17, 0, 0);
                    ODZhonghuaV6CarSet.this.updateLauguageSet();
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Zhonghua_V7 /* 14221766 */:
            case FinalCanbus.CAR_454_OD_Zhonghua_V7_H /* 14287302 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                return;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                return;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[102];
                if (value > 0) {
                    value--;
                }
                setCarInfo(10, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[102];
                if (value2 < 15) {
                    value2++;
                }
                setCarInfo(10, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[103];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(11, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[103];
                if (value4 < 9) {
                    value4++;
                }
                setCarInfo(11, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
            case R.id.btn_plus3 /* 2131427463 */:
                int value5 = DataCanbus.DATA[105];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(13, value5);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value6 = DataCanbus.DATA[106] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(14, value6);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value7 = DataCanbus.DATA[106] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(14, value7);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value8 = DataCanbus.DATA[109] - 1;
                if (value8 < 0) {
                    value8 = 3;
                }
                setCarInfo(22, value8);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value9 = DataCanbus.DATA[109] + 1;
                if (value9 > 3) {
                    value9 = 0;
                }
                setCarInfo(22, value9);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value10 = DataCanbus.DATA[112] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(25, value10);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value11 = DataCanbus.DATA[112] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(25, value11);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value12 = DataCanbus.DATA[113] - 1;
                if (value12 < 0) {
                    value12 = 3;
                }
                setCarInfo(17, value12);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value13 = DataCanbus.DATA[113] + 1;
                if (value13 > 3) {
                    value13 = 0;
                }
                setCarInfo(17, value13);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value14 = DataCanbus.DATA[115] - 1;
                if (value14 < 0) {
                    value14 = 4;
                }
                setCarInfo(16, value14);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value15 = DataCanbus.DATA[115] + 1;
                if (value15 > 4) {
                    value15 = 0;
                }
                setCarInfo(16, value15);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value16 = DataCanbus.DATA[99];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(1, value16);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value17 = DataCanbus.DATA[100];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(2, value17);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value18 = DataCanbus.DATA[101];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(3, value18);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value19 = DataCanbus.DATA[104];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(12, value19);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value20 = DataCanbus.DATA[107];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(7, value20);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value21 = DataCanbus.DATA[108];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(19, value21);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value22 = DataCanbus.DATA[110];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(21, value22);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value23 = DataCanbus.DATA[111];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(20, value23);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value24 = DataCanbus.DATA[114];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(18, value24);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ODZhonghuaHUDSetActi.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
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

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
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
