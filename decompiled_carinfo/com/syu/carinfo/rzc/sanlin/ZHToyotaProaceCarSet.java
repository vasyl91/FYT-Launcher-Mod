package com.syu.carinfo.rzc.sanlin;

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
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZHToyotaProaceCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 1:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 2:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 4:
                    if (((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text3)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 5:
                    if (((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 3:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 6:
                    if (((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text5)).setText("KM/L");
                                break;
                            case 1:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text5)).setText("L/100KM");
                                break;
                            case 2:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text5)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
                                break;
                        }
                    }
                    break;
                case 8:
                    ZHToyotaProaceCarSet.this.updateLauguageSet();
                    break;
                case 52:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 53:
                    if (((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.distance_close);
                                break;
                            case 1:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_normal);
                                break;
                            case 2:
                                ((TextView) ZHToyotaProaceCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 54:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 55:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 56:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 57:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 58:
                    ZHToyotaProaceCarSet.this.setCheck((CheckedTextView) ZHToyotaProaceCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
            }
        }
    };
    private View mPopShowView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_zh_toyota_proace_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_tpms_calibration)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ZHToyotaProaceCarSet.this.dialog();
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                ZHToyotaProaceCarSet.this.dialog2();
            }
        });
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_29));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (ZHToyotaProaceCarSet.this.mLauStyle == null) {
                    ZHToyotaProaceCarSet.this.initLauStyle();
                }
                if (ZHToyotaProaceCarSet.this.mLauStyle != null && ZHToyotaProaceCarSet.this.mPopShowView != null) {
                    ZHToyotaProaceCarSet.this.mLauStyle.showAtLocation(ZHToyotaProaceCarSet.this.mPopShowView, 17, 0, 0);
                    ZHToyotaProaceCarSet.this.updateLauguageSet();
                }
            }
        });
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
                DataCanbus.PROXY.cmd(0, new int[]{11, position}, null, null);
                ZHToyotaProaceCarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[8];
        if (value < 0) {
            value = 0;
        }
        if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
            ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(value));
        }
        if (this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(value, true);
        }
    }

    protected void dialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.str_troubleshooting));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.wc_psa_all_confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(2, new int[]{252, 255}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.wc_psa_all_cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.wc_psa_all_reset_tpms));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.wc_psa_all_confirm), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{16, 1}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.wc_psa_all_cancel), new DialogInterface.OnClickListener() { 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{16}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[53] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(28, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[53] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(28, value2);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value3 = DataCanbus.DATA[4] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(6, value3);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value4 = DataCanbus.DATA[4] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(6, value4);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[5] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[5] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value7 = DataCanbus.DATA[6] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(10, value7);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value8 = DataCanbus.DATA[6] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(10, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value9 = DataCanbus.DATA[1];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(2, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value10 = DataCanbus.DATA[2];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(21, value10);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value11 = DataCanbus.DATA[52];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(27, value11);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value12 = DataCanbus.DATA[54];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(29, value12);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value13 = DataCanbus.DATA[55];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(30, value13);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value14 = DataCanbus.DATA[56];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(31, value14);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value15 = DataCanbus.DATA[58];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(20, value15);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value16 = DataCanbus.DATA[57];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(13, value16);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[4];
        iArr[0] = 56;
        remoteModuleProxy.cmd(1, iArr, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
    }
}
