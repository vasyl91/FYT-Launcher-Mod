package com.syu.carinfo.wc.ruijie15;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class Focus19CarSetAct extends BaseActivity implements View.OnClickListener {
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
                case 37:
                    Focus19CarSetAct.this.updaterTempUnit();
                    break;
                case 98:
                    Focus19CarSetAct.this.updaterCameraDelay();
                    break;
                case 100:
                    Focus19CarSetAct.this.updaterMileUnit();
                    break;
                case 101:
                    Focus19CarSetAct.this.updaterAmbientLight();
                    break;
                case 102:
                    Focus19CarSetAct.this.updaterEQVol();
                    break;
                case 103:
                    Focus19CarSetAct.this.updaterEQBal();
                    break;
                case 104:
                    Focus19CarSetAct.this.updaterEQFad();
                    break;
                case 105:
                    Focus19CarSetAct.this.updaterEQBass();
                    break;
                case 106:
                    Focus19CarSetAct.this.updaterEQMid();
                    break;
                case 107:
                    Focus19CarSetAct.this.updaterEQTreb();
                    break;
                case 108:
                    Focus19CarSetAct.this.updaterEQSpeedVol();
                    break;
                case 109:
                    Focus19CarSetAct.this.updaterEQSurround();
                    break;
                case 110:
                    Focus19CarSetAct.this.updaterChecked1();
                    break;
                case 115:
                    if (value == 1) {
                        ((TextView) Focus19CarSetAct.this.findViewById(R.id.tv_text12)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                    } else {
                        ((TextView) Focus19CarSetAct.this.findViewById(R.id.tv_text12)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                    }
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                    break;
                case 116:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                    break;
                case 117:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    break;
                case 118:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    break;
                case 119:
                    Focus19CarSetAct.this.updateLauguageSet();
                    break;
                case 120:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    break;
                case 121:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    break;
                case 122:
                    if (value == 1) {
                        ((TextView) Focus19CarSetAct.this.findViewById(R.id.tv_text13)).setText("Air box");
                    } else {
                        ((TextView) Focus19CarSetAct.this.findViewById(R.id.tv_text13)).setText("Canbus box");
                    }
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                    break;
                case 123:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                    break;
                case 124:
                    switch (value) {
                        case 0:
                            ((TextView) Focus19CarSetAct.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Focus19CarSetAct.this.findViewById(R.id.tv_text14)).setText(R.string.str_right_camera_open);
                            break;
                        case 2:
                            ((TextView) Focus19CarSetAct.this.findViewById(R.id.tv_text14)).setText(R.string.klc_sport_mode_Engine_sport);
                            break;
                    }
                case 126:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    break;
                case 127:
                    ((CheckedTextView) Focus19CarSetAct.this.findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc2_ford_car_set);
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
                Focus19CarSetAct.this.language_set = position;
                if (Focus19CarSetAct.this.language_set >= 0 && Focus19CarSetAct.this.language_set <= Focus19CarSetAct.this.mLauStylelist.size() && Focus19CarSetAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{1, Focus19CarSetAct.this.send_lang[Focus19CarSetAct.this.language_set]}, null, null);
                }
                Focus19CarSetAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[119];
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.send_lang = new int[]{1, 2, 5, 7, 27};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (Focus19CarSetAct.this.mLauStyle == null) {
                    Focus19CarSetAct.this.initLauStyle();
                }
                if (Focus19CarSetAct.this.mLauStyle != null && Focus19CarSetAct.this.mPopShowView != null) {
                    Focus19CarSetAct.this.mLauStyle.showAtLocation(Focus19CarSetAct.this.mPopShowView, 17, 0, 0);
                    Focus19CarSetAct.this.updateLauguageSet();
                }
            }
        });
        if (DataCanbus.DATA[1000] == 1769915 || DataCanbus.DATA[1000] == 1835451 || DataCanbus.DATA[1000] == 4391355 || DataCanbus.DATA[1000] == 4456891 || DataCanbus.DATA[1000] == 4522427 || DataCanbus.DATA[1000] == 5964219 || DataCanbus.DATA[1000] == 5898683 || DataCanbus.DATA[1000] == 6160827 || DataCanbus.DATA[1000] == 6226363 || DataCanbus.DATA[1000] == 6291899 || DataCanbus.DATA[1000] == 6357435 || DataCanbus.DATA[1000] == 15139259 || DataCanbus.DATA[1000] == 15532475 || DataCanbus.DATA[1000] == 15598011) {
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 1835451 || DataCanbus.DATA[1000] == 15139259 || DataCanbus.DATA[1000] == 15532475 || DataCanbus.DATA[1000] == 15598011) {
            findViewById(R.id.layout_text_view1).setVisibility(0);
            findViewById(R.id.layout_view3).setVisibility(0);
            findViewById(R.id.layout_view4).setVisibility(0);
            findViewById(R.id.layout_view5).setVisibility(0);
            findViewById(R.id.layout_view6).setVisibility(0);
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
            findViewById(R.id.layout_view9).setVisibility(0);
            findViewById(R.id.layout_view10).setVisibility(0);
        } else {
            findViewById(R.id.layout_text_view1).setVisibility(8);
            findViewById(R.id.layout_view3).setVisibility(8);
            findViewById(R.id.layout_view4).setVisibility(8);
            findViewById(R.id.layout_view5).setVisibility(8);
            findViewById(R.id.layout_view6).setVisibility(8);
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
            findViewById(R.id.layout_view9).setVisibility(8);
            findViewById(R.id.layout_view10).setVisibility(8);
        }
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext10).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext11).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext12).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext13).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext14).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext15).setOnClickListener(this);
        findViewById(R.id.btn_minus1).setOnClickListener(this);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_minus2).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_minus3).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        findViewById(R.id.btn_minus4).setOnClickListener(this);
        findViewById(R.id.btn_plus4).setOnClickListener(this);
        findViewById(R.id.btn_minus5).setOnClickListener(this);
        findViewById(R.id.btn_plus5).setOnClickListener(this);
        findViewById(R.id.btn_minus6).setOnClickListener(this);
        findViewById(R.id.btn_plus6).setOnClickListener(this);
        findViewById(R.id.btn_minus7).setOnClickListener(this);
        findViewById(R.id.btn_plus7).setOnClickListener(this);
        findViewById(R.id.btn_minus8).setOnClickListener(this);
        findViewById(R.id.btn_plus8).setOnClickListener(this);
        findViewById(R.id.btn_minus9).setOnClickListener(this);
        findViewById(R.id.btn_plus9).setOnClickListener(this);
        findViewById(R.id.btn_minus10).setOnClickListener(this);
        findViewById(R.id.btn_plus10).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[102];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{1, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[102];
                if (value2 < 30) {
                    value2++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[105];
                if (value3 > 0) {
                    value3--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{4, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[105];
                if (value4 < 14) {
                    value4++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{4, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[106];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{5, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[106];
                if (value6 < 14) {
                    value6++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{5, value6}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[107];
                if (value7 > 0) {
                    value7--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{6, value7}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[107];
                if (value8 < 14) {
                    value8++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{6, value8}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[103];
                if (value9 > 0) {
                    value9--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{2, value9}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[103];
                if (value10 < 14) {
                    value10++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{2, value10}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[104];
                if (value11 > 0) {
                    value11--;
                }
                DataCanbus.PROXY.cmd(8, new int[]{3, value11}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[104];
                if (value12 < 14) {
                    value12++;
                }
                DataCanbus.PROXY.cmd(8, new int[]{3, value12}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[109] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(8, new int[]{8, value13}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[109] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                DataCanbus.PROXY.cmd(8, new int[]{8, value14}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[108] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                DataCanbus.PROXY.cmd(8, new int[]{7, value15}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[108] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(8, new int[]{7, value16}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[101] - 1;
                if (value17 < 0) {
                    value17 = 7;
                }
                DataCanbus.PROXY.cmd(7, new int[]{3, value17}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[101] + 1;
                if (value18 > 7) {
                    value18 = 0;
                }
                DataCanbus.PROXY.cmd(7, new int[]{3, value18}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[124] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                DataCanbus.PROXY.cmd(9, new int[]{4, value19}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[124] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                DataCanbus.PROXY.cmd(9, new int[]{4, value20}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                RJFunc.SET_TIPS_CMD(6, DataCanbus.DATA[110] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                RJFunc.SET_TIPS_CMD(4, DataCanbus.DATA[37] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                DataCanbus.PROXY.cmd(6, new int[]{5, DataCanbus.DATA[100] == 0 ? 1 : 0}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                RJFunc.SET_CAR_CMD(6, DataCanbus.DATA[98] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = DataCanbus.DATA[115] == 0 ? 1 : 0;
                remoteModuleProxy.cmd(6, iArr, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 4;
                iArr2[1] = DataCanbus.DATA[116] == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(6, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 6;
                iArr3[1] = DataCanbus.DATA[117] == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(6, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 7;
                iArr4[1] = DataCanbus.DATA[118] == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(6, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 23;
                iArr5[1] = DataCanbus.DATA[120] == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(7, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 22;
                iArr6[1] = DataCanbus.DATA[121] == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(7, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 19;
                iArr7[1] = DataCanbus.DATA[122] == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(7, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 3;
                iArr8[1] = DataCanbus.DATA[123] == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(9, iArr8, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[2];
                iArr9[0] = 6;
                iArr9[1] = DataCanbus.DATA[126] == 0 ? 1 : 0;
                remoteModuleProxy9.cmd(9, iArr9, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[2];
                iArr10[0] = 7;
                iArr10[1] = DataCanbus.DATA[127] == 0 ? 1 : 0;
                remoteModuleProxy10.cmd(9, iArr10, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                dialog(R.string.xp_yinglang_car_set_Second_str10, 5);
                break;
        }
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
                        DataCanbus.PROXY.cmd(9, new int[]{i, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(9, new int[]{i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
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

    
    public void updaterEQSurround() {
        int value = DataCanbus.DATA[109];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.haval_volspeed1);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text7)).setText(R.string.wc_372_surroundstr);
                break;
        }
    }

    
    public void updaterEQSpeedVol() {
        int value = DataCanbus.DATA[108];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                break;
        }
    }

    
    public void updaterEQTreb() {
        int value = DataCanbus.DATA[107];
        if (value > 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText("+" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.tv_text4)).setText("0");
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText("-" + (7 - value));
        }
    }

    
    public void updaterEQMid() {
        int value = DataCanbus.DATA[106];
        if (value > 7) {
            ((TextView) findViewById(R.id.tv_text3)).setText("+" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.tv_text3)).setText("0");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText("-" + (7 - value));
        }
    }

    
    public void updaterEQBass() {
        int value = DataCanbus.DATA[105];
        if (value > 7) {
            ((TextView) findViewById(R.id.tv_text2)).setText("+" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.tv_text2)).setText("0");
        } else {
            ((TextView) findViewById(R.id.tv_text2)).setText("-" + (7 - value));
        }
    }

    
    public void updaterEQFad() {
        int value = DataCanbus.DATA[104];
        if (value > 7) {
            ((TextView) findViewById(R.id.tv_text6)).setText("R" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.tv_text6)).setText("0");
        } else {
            ((TextView) findViewById(R.id.tv_text6)).setText("F" + (7 - value));
        }
    }

    
    public void updaterEQBal() {
        int value = DataCanbus.DATA[103];
        if (value > 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText("R" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.tv_text5)).setText("0");
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText("L" + (7 - value));
        }
    }

    
    public void updaterEQVol() {
        int value = DataCanbus.DATA[102];
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
    }

    
    public void updaterAmbientLight() {
        int value = DataCanbus.DATA[101];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_403_ambient_2);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_403_ambient_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_wc_174008_str11);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_403_ambient_3);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_403_ambient_4);
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_403_ambient_5);
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_403_ambient_6);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text11)).setText(R.string.off);
                break;
        }
    }

    
    public void updaterMileUnit() {
        int value = DataCanbus.DATA[100];
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text10)).setText(R.string.jeep_format_set1);
        } else {
            ((TextView) findViewById(R.id.tv_text10)).setText(R.string.jeep_format_set0);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    
    public void updaterTempUnit() {
        int value = DataCanbus.DATA[37];
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        } else {
            ((TextView) findViewById(R.id.tv_text9)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    
    public void updaterCameraDelay() {
        int value = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    
    public void updaterChecked1() {
        int value = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
