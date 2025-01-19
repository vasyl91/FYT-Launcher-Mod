package com.syu.carinfo.psa_all;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

public class PSAFuncIndexActi extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 166:
                    PSAFuncIndexActi.this.mUpdaterValue53();
                    break;
                case 167:
                    PSAFuncIndexActi.this.mUpdaterValue51();
                    break;
                case 168:
                    PSAFuncIndexActi.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_func_index);
        initObject();
        registerListener();
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
                PSAFuncIndexActi.this.language_set = position;
                if (PSAFuncIndexActi.this.language_set >= 0 && PSAFuncIndexActi.this.language_set <= PSAFuncIndexActi.this.mLauStylelist.size() && PSAFuncIndexActi.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(51, new int[]{PSAFuncIndexActi.this.send_lang[PSAFuncIndexActi.this.language_set]}, null, null);
                }
                PSAFuncIndexActi.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[168];
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

    public void initObject() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_30));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_28));
        this.mLauStylelist.add("Vietnam");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_11));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 20, 22, 23, 25, 26, 28, 29, 30, 31, 32, 33};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
    }

    public void registerListener() {
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (PSAFuncIndexActi.this.mLauStyle == null) {
                    PSAFuncIndexActi.this.initLauStyle();
                }
                if (PSAFuncIndexActi.this.mLauStyle != null && PSAFuncIndexActi.this.mPopShowView != null) {
                    PSAFuncIndexActi.this.mLauStyle.showAtLocation(PSAFuncIndexActi.this.mPopShowView, 17, 0, 0);
                    PSAFuncIndexActi.this.updateLauguageSet();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_parking_and_Manoeurvring)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAFuncIndexActi.this, PSAFuncParkingActi.class);
                    PSAFuncIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_light_settings)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAFuncIndexActi.this, PSAFuncLightActi.class);
                    PSAFuncIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_lock_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAFuncIndexActi.this, PSAFuncLockActi.class);
                    PSAFuncIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_tpms_calibration)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                PSAFuncIndexActi.this.dialog();
            }
        });
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_engine_start_stop)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[167];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value != 0 ? 0 : 1;
                remoteModuleProxy.cmd(52, iArr, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.psa_all_func_btn_others)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PSAFuncIndexActi.this, PSAFuncOthersActi.class);
                    PSAFuncIndexActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue51() {
        int value = DataCanbus.DATA[167];
        if (((CheckedTextView) findViewById(R.id.psa_all_func_btn_engine_start_stop)) != null) {
            ((CheckedTextView) findViewById(R.id.psa_all_func_btn_engine_start_stop)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterValue53() {
        int value = DataCanbus.DATA[166];
        if (((RelativeLayout) findViewById(R.id.psa_all_func_btn_engine_start_stop_view)) != null) {
            if (value == 1) {
                ((RelativeLayout) findViewById(R.id.psa_all_func_btn_engine_start_stop_view)).setVisibility(0);
            } else {
                ((RelativeLayout) findViewById(R.id.psa_all_func_btn_engine_start_stop_view)).setVisibility(8);
            }
        }
    }

    public void isVisibleView() {
        if (DataCanbus.DATA[149] == 0 && DataCanbus.DATA[150] == 0) {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_others_view)).setVisibility(8);
        } else {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_others_view)).setVisibility(0);
        }
        if (DataCanbus.DATA[175] == 0 && DataCanbus.DATA[116] == 0 && DataCanbus.DATA[115] == 0 && DataCanbus.DATA[118] == 0) {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_lock_set_view)).setVisibility(8);
        } else {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_lock_set_view)).setVisibility(0);
        }
        if (DataCanbus.DATA[167] == 0 && DataCanbus.DATA[119] == 0 && DataCanbus.DATA[146] == 0 && DataCanbus.DATA[110] == 0 && DataCanbus.DATA[111] == 0 && DataCanbus.DATA[117] == 0) {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_light_settings_view)).setVisibility(8);
        } else {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_light_settings_view)).setVisibility(0);
        }
        if (DataCanbus.DATA[108] == 0 && DataCanbus.DATA[112] == 0 && DataCanbus.DATA[147] == 0 && DataCanbus.DATA[145] == 0 && DataCanbus.DATA[109] == 0) {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_parking_and_Manoeurvring_view)).setVisibility(8);
        } else {
            ((RelativeLayout) findViewById(R.id.psa_all_func_btn_parking_and_Manoeurvring_view)).setVisibility(0);
        }
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
                        DataCanbus.PROXY.cmd(23, new int[]{1}, null, null);
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
                        DataCanbus.PROXY.cmd(23, new int[1], null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
