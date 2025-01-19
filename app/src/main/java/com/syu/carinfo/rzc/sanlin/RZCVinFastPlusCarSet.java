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

public class RZCVinFastPlusCarSet extends BaseActivity implements View.OnClickListener {
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
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText("Light");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText("Horn");
                                break;
                            case 3:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text3)).setText("Both");
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("5km/h");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("10km/h");
                                break;
                            case 3:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("15km/h");
                                break;
                            case 4:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("20km/h");
                                break;
                            case 5:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text4)).setText("25km/h");
                                break;
                        }
                    }
                    break;
                case 100:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 101:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("60s");
                                break;
                            case 3:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("90s");
                                break;
                            case 4:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text5)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 102:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 103:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 104:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 105:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value + 40) + "km/h");
                        break;
                    }
                case 106:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 107:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 108:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 109:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 110:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 111:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 112:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 113:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text7)).setText("ECO");
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text7)).setText("Sport");
                                break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)).setText("Off");
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)).setText("Low");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text8)).setText("High");
                                break;
                        }
                    }
                    break;
                case 115:
                    RZCVinFastPlusCarSet.this.updateLauguageSet();
                    break;
                case 116:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 121:
                    RZCVinFastPlusCarSet.this.setCheck((CheckedTextView) RZCVinFastPlusCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 122:
                    if (((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text10)).setText("50%");
                                break;
                            case 1:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text10)).setText("60%");
                                break;
                            case 2:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text10)).setText("70%");
                                break;
                            case 3:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text10)).setText("80%");
                                break;
                            case 4:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text10)).setText("90%");
                                break;
                            case 5:
                                ((TextView) RZCVinFastPlusCarSet.this.findViewById(R.id.tv_text10)).setText("100%");
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
        //setContentView(R.layout.layout_0453_rzc_vinfast_settings);
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
                RZCVinFastPlusCarSet.this.language_set = position;
                if (RZCVinFastPlusCarSet.this.language_set >= 0 && RZCVinFastPlusCarSet.this.language_set <= RZCVinFastPlusCarSet.this.mLauStylelist.size() && RZCVinFastPlusCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{48, RZCVinFastPlusCarSet.this.send_lang[RZCVinFastPlusCarSet.this.language_set]}, null, null);
                }
                RZCVinFastPlusCarSet.this.mLauStyle.dismiss();
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

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("Viet Nam");
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (RZCVinFastPlusCarSet.this.mLauStyle == null) {
                    RZCVinFastPlusCarSet.this.initLauStyle();
                }
                if (RZCVinFastPlusCarSet.this.mLauStyle != null && RZCVinFastPlusCarSet.this.mPopShowView != null) {
                    RZCVinFastPlusCarSet.this.mLauStyle.showAtLocation(RZCVinFastPlusCarSet.this.mPopShowView, 17, 0, 0);
                    RZCVinFastPlusCarSet.this.updateLauguageSet();
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
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
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[98] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[99] - 1;
                if (value3 < 0) {
                    value3 = 5;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[99] + 1;
                if (value4 > 5) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[101] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[101] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[105];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(8, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[105];
                if (value8 < 80) {
                    value8++;
                }
                setCarInfo(8, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[113] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(33, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[113] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(33, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[114] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(34, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[114] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(34, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[116];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo(49, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[116];
                if (value14 < 14) {
                    value14++;
                }
                setCarInfo(49, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[122];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo(52, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[122];
                if (value16 < 5) {
                    value16++;
                }
                setCarInfo(52, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value17 = DataCanbus.DATA[100];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(2, value17);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value18 = DataCanbus.DATA[102];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(5, value18);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value19 = DataCanbus.DATA[103];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(6, value19);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value20 = DataCanbus.DATA[104];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(7, value20);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value21 = DataCanbus.DATA[106];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(16, value21);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value22 = DataCanbus.DATA[107];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(17, value22);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value23 = DataCanbus.DATA[108];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(18, value23);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value24 = DataCanbus.DATA[109];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(19, value24);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value25 = DataCanbus.DATA[110];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(20, value25);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value26 = DataCanbus.DATA[111];
                if (value26 == 1) {
                    value26 = 0;
                } else if (value26 == 0) {
                    value26 = 1;
                }
                setCarInfo(21, value26);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value27 = DataCanbus.DATA[112];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(32, value27);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value28 = DataCanbus.DATA[121];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(35, value28);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{38}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }
}
