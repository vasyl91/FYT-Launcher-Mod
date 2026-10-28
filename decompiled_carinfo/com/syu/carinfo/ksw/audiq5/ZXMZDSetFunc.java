package com.syu.carinfo.ksw.audiq5;

import android.os.Bundle;
import android.util.Log;
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
import com.syu.module.canbus.Callback_0448_LZ_BWM_CarUi;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;

import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZXMZDSetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0448_LZ_BWM_CarUi.modevalue = ints[2];
                                break;
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ZXMZDSetFunc.this.updateCameraType(value);
                    break;
                case 118:
                    ZXMZDSetFunc.this.mUpdaterCarUiOn(value);
                    break;
                case 119:
                    ZXMZDSetFunc.this.updateTrajectoryOnoff(value);
                    break;
                case 120:
                    switch (value) {
                        case 3:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_full_a);
                            break;
                        case 4:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_full_b);
                            break;
                        case 5:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_half_a);
                            break;
                        case 6:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.str_half_b);
                            break;
                        default:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                case 121:
                    ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 130:
                    switch (value) {
                        case 2:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_vehicle);
                            break;
                        case 3:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_logo);
                            break;
                        default:
                            ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                            break;
                    }
                case 131:
                    ((TextView) ZXMZDSetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 133:
                    ZXMZDSetFunc.this.updateLauguageSet();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_zx_mzd_setfunc);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_448_6606_ZX_Honda_CRV_24 /* 328128 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_CRV_17 /* 393664 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_Accord_8 /* 459200 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_Accord_7 /* 524736 */:
            case FinalCanbus.CAR_448_6606_ZX_MAZ /* 655808 */:
            case FinalCanbus.CAR_448_6606_ZX_Honda_CRV_17_RIGHT /* 721344 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        init();
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] + 1;
                if (value > 4) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] - 1;
                if (value < 0) {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] + 1;
                if (value > 16) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] - 1;
                if (value < 0) {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[121] + 1;
                if (value > 16) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] - 1;
                if (value < 0) {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] + 1;
                if (value > 16) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] - 1;
                if (value < 0) {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[131] + 1;
                if (value > 16) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[119];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage2, (ViewGroup) null);
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
                ZXMZDSetFunc.this.language_set = position;
                if (ZXMZDSetFunc.this.language_set >= 0 && ZXMZDSetFunc.this.language_set <= ZXMZDSetFunc.this.mLauStylelist.size() && ZXMZDSetFunc.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(51, new int[]{ZXMZDSetFunc.this.language_set}, null, null);
                    if (DataCanbus.DATA[1000] == 655808) {
                        switch (ZXMZDSetFunc.this.language_set) {
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 13}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3, 1}, null, null);
                                if (Callback_0448_LZ_BWM_CarUi.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[132] != 0) {
                                    DataCanbus.PROXY.cmd(52, new int[1], null, null);
                                    break;
                                }
                        }
                    } else {
                        switch (ZXMZDSetFunc.this.language_set) {
                            case 1:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 20}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0448_LZ_BWM_CarUi.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[132] != 0) {
                                    DataCanbus.PROXY.cmd(52, new int[1], null, null);
                                    break;
                                }
                            case 2:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 10}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0448_LZ_BWM_CarUi.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[132] != 0) {
                                    DataCanbus.PROXY.cmd(52, new int[1], null, null);
                                    break;
                                }
                            case 3:
                                DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 2, 23}, null, null);
                                DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                                if (Callback_0448_LZ_BWM_CarUi.modevalue != -1) {
                                    DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                                }
                                if (DataCanbus.DATA[132] != 0) {
                                    DataCanbus.PROXY.cmd(52, new int[1], null, null);
                                    break;
                                }
                        }
                    }
                }
                ZXMZDSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[133];
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
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        if (DataCanbus.DATA[1000] == 655808) {
            this.mLauStylelist.add("No selected");
            this.mLauStylelist.add("Mazda 1280x480 M400");
            this.send_lang = new int[]{0, 1};
        } else {
            this.mLauStylelist.add("No selected");
            this.mLauStylelist.add("Honda CRV 1280x720 T700");
            this.mLauStylelist.add("Honda 800x480 T700");
            this.mLauStylelist.add("Honda Accord 1280x720 T700");
            this.send_lang = new int[]{0, 1, 2, 3};
        }
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (ZXMZDSetFunc.this.mLauStyle == null) {
                    ZXMZDSetFunc.this.initLauStyle();
                }
                if (ZXMZDSetFunc.this.mLauStyle != null && ZXMZDSetFunc.this.mPopShowView != null) {
                    ZXMZDSetFunc.this.mLauStyle.showAtLocation(ZXMZDSetFunc.this.mPopShowView, 17, 0, 0);
                    ZXMZDSetFunc.this.updateLauguageSet();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
    }

    
    public void updateCameraType(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_after_device);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_car_device);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_car_360device);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_car360_type1);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_car360_type2);
                break;
        }
    }

    
    public void mUpdaterCarUiOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    
    public void updateTrajectoryOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
        }
    }
}
