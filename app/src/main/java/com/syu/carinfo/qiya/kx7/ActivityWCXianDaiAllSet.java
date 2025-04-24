package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
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
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityWCXianDaiAllSet extends Activity implements View.OnClickListener {
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
                case 99:
                    ActivityWCXianDaiAllSet.this.updateTrackDisplay(value);
                    break;
                case 100:
                    ActivityWCXianDaiAllSet.this.updateRadarDisplay(value);
                    break;
                case 101:
                    ActivityWCXianDaiAllSet.this.updateFrontViewInit(value);
                    break;
                case 102:
                    ActivityWCXianDaiAllSet.this.updateRearViewInit(value);
                    break;
                case 105:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                        break;
                    }
                case 106:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 107:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 16));
                            break;
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("L" + (16 - value));
                            break;
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 16));
                            break;
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("F" + (16 - value));
                            break;
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("0");
                            break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("+" + (value - 16));
                            break;
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("-" + (16 - value));
                            break;
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("0");
                            break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("+" + (value - 16));
                            break;
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("-" + (16 - value));
                            break;
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("0");
                            break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("+" + (value - 16));
                            break;
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("-" + (16 - value));
                            break;
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("0");
                            break;
                        }
                    }
                    break;
                case 112:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                        break;
                    }
                case 113:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                        break;
                    }
                case 114:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                        break;
                    }
                case 115:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                        break;
                    }
                case 116:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                        break;
                    }
                case 117:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                        break;
                    }
                case 118:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 120:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                        break;
                    }
                case 121:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_xiandai_all_set);
        setListener();
    }

    private void initLauStyle() {
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
                ActivityWCXianDaiAllSet.this.language_set = position;
                if (ActivityWCXianDaiAllSet.this.language_set >= 0 && ActivityWCXianDaiAllSet.this.language_set <= ActivityWCXianDaiAllSet.this.mLauStylelist.size() && ActivityWCXianDaiAllSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(5, new int[]{1, ActivityWCXianDaiAllSet.this.send_lang[ActivityWCXianDaiAllSet.this.language_set]}, null, null);
                }
                ActivityWCXianDaiAllSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    void setListener() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.send_lang = new int[]{1, 2, 5, 7, 9, 10, 15, 17};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda /* 3473851 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_XianDai_All_21Elantra_EV /* 3211708 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[101] - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(4, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[101] + 1;
                if (value2 > 3) {
                    value2 = 3;
                }
                setCmd(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[102] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCmd(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[102] + 1;
                if (value4 > 3) {
                    value4 = 3;
                }
                setCmd(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[106];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, DataCanbus.DATA[106] + 1}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value6 = DataCanbus.DATA[107];
                if (value6 > 6) {
                    value6--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value7 = DataCanbus.DATA[107];
                if (value7 < 26) {
                    value7++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value7}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value8 = DataCanbus.DATA[108];
                if (value8 > 6) {
                    value8--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value8}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value9 = DataCanbus.DATA[108];
                if (value9 < 26) {
                    value9++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value9}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value10 = DataCanbus.DATA[109];
                if (value10 > 6) {
                    value10--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value10}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value11 = DataCanbus.DATA[109];
                if (value11 < 26) {
                    value11++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value11}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value12 = DataCanbus.DATA[110];
                if (value12 > 6) {
                    value12--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value12}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value13 = DataCanbus.DATA[110];
                if (value13 < 26) {
                    value13++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value13}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value14 = DataCanbus.DATA[111];
                if (value14 > 6) {
                    value14--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value14}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value15 = DataCanbus.DATA[111];
                if (value15 < 26) {
                    value15++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value15}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value16 = DataCanbus.DATA[118];
                if (value16 > 0) {
                    value16--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{16, value16, 255, 255}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value17 = DataCanbus.DATA[118];
                if (value17 < 10) {
                    value17++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{16, value17, 255, 255}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value18 = DataCanbus.DATA[119];
                if (value18 > 0) {
                    value18--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{17, value18, 255, 255}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value19 = DataCanbus.DATA[119];
                if (value19 < 72) {
                    value19++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{17, value19, 255, 255}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCmd(3, DataCanbus.DATA[100] != 0 ? 0 : 1);
                break;
            case R.id.all_func_btn_lauguage_set /* 2131427539 */:
                if (this.mLauStyle == null) {
                    initLauStyle();
                }
                if (this.mLauStyle != null && this.mPopShowView != null) {
                    this.mLauStyle.showAtLocation(this.mPopShowView, 17, 0, 0);
                    updateLauguageSet();
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCmd(2, DataCanbus.DATA[99] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                DataCanbus.PROXY.cmd(2, DataCanbus.DATA[105] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value20 = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value20 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value21 = DataCanbus.DATA[113];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[4];
                iArr2[0] = 1;
                iArr2[1] = value21 == 0 ? 1 : 0;
                iArr2[2] = 255;
                iArr2[3] = 255;
                remoteModuleProxy2.cmd(4, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value22 = DataCanbus.DATA[114];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[4];
                iArr3[0] = 2;
                iArr3[1] = value22 == 0 ? 1 : 0;
                iArr3[2] = 255;
                iArr3[3] = 255;
                remoteModuleProxy3.cmd(4, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value23 = DataCanbus.DATA[115];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[4];
                iArr4[0] = 3;
                iArr4[1] = value23 == 0 ? 1 : 0;
                iArr4[2] = 255;
                iArr4[3] = 255;
                remoteModuleProxy4.cmd(4, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value24 = DataCanbus.DATA[116];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[4];
                iArr5[0] = 4;
                iArr5[1] = value24 == 0 ? 1 : 0;
                iArr5[2] = 255;
                iArr5[3] = 255;
                remoteModuleProxy5.cmd(4, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value25 = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[4];
                iArr6[0] = 5;
                iArr6[1] = value25 == 0 ? 1 : 0;
                iArr6[2] = 255;
                iArr6[3] = 255;
                remoteModuleProxy6.cmd(4, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value26 = DataCanbus.DATA[120];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[4];
                iArr7[0] = 6;
                iArr7[1] = value26 == 0 ? 1 : 0;
                iArr7[2] = 255;
                iArr7[3] = 255;
                remoteModuleProxy7.cmd(4, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value27 = DataCanbus.DATA[121];
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[4];
                iArr8[0] = 7;
                iArr8[1] = value27 == 0 ? 1 : 0;
                iArr8[2] = 255;
                iArr8[3] = 255;
                remoteModuleProxy8.cmd(4, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ActivityWCXianDaiE_InfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    private void setCmd(int type, int value) {
        DataCanbus.PROXY.cmd(1, type, value);
    }

    protected void updateTrackDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    protected void updateRadarDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    protected void updateRearViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }

    protected void updateFrontViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }
}
