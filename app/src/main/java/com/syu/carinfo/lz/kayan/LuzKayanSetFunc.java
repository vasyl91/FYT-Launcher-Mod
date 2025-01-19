package com.syu.carinfo.lz.kayan;

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
import com.syu.module.canbus.Callback_0439_LZ_Kayan;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LuzKayanSetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private final IUiNotify sNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0439_LZ_Kayan.modevalue = ints[2];
                                break;
                        }
                    }
                    break;
            }
        }
    };
    private final IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                    LuzKayanSetFunc.this.updateInterlightOfftime(value);
                    break;
                case 114:
                    LuzKayanSetFunc.this.updateInterlight(value);
                    break;
                case 115:
                    LuzKayanSetFunc.this.updateDayTimeLight(value);
                    break;
                case 116:
                    LuzKayanSetFunc.this.updateWiperSensorType(value);
                    break;
                case 117:
                    LuzKayanSetFunc.this.updateWiperRearType(value);
                    break;
                case 118:
                    LuzKayanSetFunc.this.updateReversingOptions(value);
                    break;
                case 119:
                    LuzKayanSetFunc.this.updateDoorUnlockType(value);
                    break;
                case 120:
                    LuzKayanSetFunc.this.updateDoorlockType(value);
                    break;
                case 121:
                    LuzKayanSetFunc.this.updateComfortEntry(value);
                    break;
                case 122:
                    LuzKayanSetFunc.this.updateAirPanel(value);
                    break;
                case 123:
                    LuzKayanSetFunc.this.updateAirAutoCirc(value);
                    break;
                case 124:
                    LuzKayanSetFunc.this.updateAirStyleType(value);
                    break;
                case 125:
                    LuzKayanSetFunc.this.updateOutlightOfftime(value);
                    break;
                case 127:
                    switch (value) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text1)).setText("Type1");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text1)).setText("Type2");
                            break;
                    }
                case 128:
                    LuzKayanSetFunc.this.updateLauguageSet();
                    break;
                case 130:
                    switch (value) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_Manual);
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_luz_kayan_setfunc);
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LUZ_KAYAN_MACAN_CD_HP_LOW /* 1900998 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD /* 6291895 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD_HP /* 6422967 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        init();
        findViewById(R.id.luz_kayan_intlight_offtime_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] - 1;
                if (value < 0) {
                    value = 30;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_intlight_offtime_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[113] + 1;
                if (value > 30) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_intamblight_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[114] - 1;
                if (value < 0) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_intamblightplus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[114] + 1;
                if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        findViewById(R.id.ctv_luz_kayan_daytimelight_onoff).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[115];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{0, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_outlight_offtime_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] - 1;
                if (value < 1) {
                    value = 12;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_outlight_offtime_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[125] + 1;
                if (value > 12) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_wiper_rainauto_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_wiper_rainauto_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[116] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_rear_wiper_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_rear_wiper_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[117] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        findViewById(R.id.ctv_luz_reversing_options_onoff).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[118];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_door_unlock_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_door_unlock_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[119] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_door_lock_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_door_lock_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[120] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
            }
        });
        findViewById(R.id.btn_minus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{248, value}, null, null);
            }
        });
        findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[130] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{248, value}, null, null);
            }
        });
        findViewById(R.id.ctv_luz_comfort_entry_onoff).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
        findViewById(R.id.ctv_luz_air_vent_panel_onoff).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        findViewById(R.id.ctv_luz_air_auto_circ_onoff).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_air_conditioning_minus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
        findViewById(R.id.luz_kayan_air_conditioning_plus).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[124] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
    }

    String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(str + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage2, null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter(new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LuzKayanSetFunc.this.language_set = position;
                if (LuzKayanSetFunc.this.language_set >= 0 && LuzKayanSetFunc.this.language_set <= LuzKayanSetFunc.this.mLauStylelist.size() && LuzKayanSetFunc.this.send_lang != null) {
                    LuzKayanSetFunc.this.setCarInfo(250, LuzKayanSetFunc.this.language_set);
                    switch (LuzKayanSetFunc.this.language_set) {
                        case 0:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 9}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                            }
                            if (DataCanbus.DATA[129] != 2) {
                                LuzKayanSetFunc.this.setCarInfo(254, 2);
                                break;
                            }
                        case 1:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 19}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                            }
                            if (DataCanbus.DATA[129] != 1) {
                                LuzKayanSetFunc.this.setCarInfo(254, 1);
                                break;
                            }
                        case 2:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 10}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1}, null, null);
                            }
                            if (DataCanbus.DATA[129] != 1) {
                                LuzKayanSetFunc.this.setCarInfo(254, 1);
                                break;
                            }
                    }
                }
                LuzKayanSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[128];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (findViewById(R.id.lauguage_set_curr) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("Audi 2017 A4L 1024x480 T100");
        this.mLauStylelist.add("Audi 2017 A4L 400x240 T100");
        this.mLauStylelist.add("Audi 2017 A4L 800x480 T100");
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick(findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (LuzKayanSetFunc.this.mLauStyle == null) {
                    LuzKayanSetFunc.this.initLauStyle();
                }
                if (LuzKayanSetFunc.this.mLauStyle != null && LuzKayanSetFunc.this.mPopShowView != null) {
                    LuzKayanSetFunc.this.mLauStyle.showAtLocation(LuzKayanSetFunc.this.mPopShowView, 17, 0, 0);
                    LuzKayanSetFunc.this.updateLauguageSet();
                }
            }
        });
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
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
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
    }

    
    public void updateAirStyleType(int value) {
        if (findViewById(R.id.tv_luz_kayan_air_conditioning) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.mateng_air_con_profile_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.str_mode_normal);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.mateng_air_con_profile_2);
                    break;
            }
        }
    }

    
    public void updateAirAutoCirc(int value) {
        if (findViewById(R.id.ctv_luz_air_auto_circ_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_air_auto_circ_onoff)).setChecked(value == 1);
        }
    }

    
    public void updateAirPanel(int value) {
        if (findViewById(R.id.ctv_luz_air_vent_panel_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_air_vent_panel_onoff)).setChecked(value == 1);
        }
    }

    
    public void updateComfortEntry(int value) {
        if (findViewById(R.id.ctv_luz_comfort_entry_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_comfort_entry_onoff)).setChecked(value == 1);
        }
    }

    
    public void updateDoorlockType(int value) {
        if (findViewById(R.id.tv_luz_kayan_door_lock) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.str_ignition_on_lock);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.jeep_runautolock);
                    break;
            }
        }
    }

    
    public void updateDoorUnlockType(int value) {
        if (findViewById(R.id.tv_luz_kayan_door_unlock) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)).setText(R.string.xp_psa_all_string_door_open_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)).setText(R.string.xp_psa_all_string_door_open_0);
                    break;
            }
        }
    }

    
    public void updateReversingOptions(int value) {
        if (findViewById(R.id.ctv_luz_reversing_options_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_reversing_options_onoff)).setChecked(value == 1);
        }
    }

    
    public void updateWiperRearType(int value) {
        if (findViewById(R.id.tv_luz_kayan_rear_wiper) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    
    public void updateWiperSensorType(int value) {
        if (findViewById(R.id.tv_luz_kayan_wiper_rainauto) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    
    public void updateOutlightOfftime(int value) {
        int value2 = value * 10;
        if (findViewById(R.id.tv_luz_kayan_outlight_offtime) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_outlight_offtime)).setText(value2 + "s");
        }
    }

    
    public void updateDayTimeLight(int value) {
        if (findViewById(R.id.ctv_luz_kayan_daytimelight_onoff) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_kayan_daytimelight_onoff)).setChecked(value == 1);
        }
    }

    
    public void updateInterlight(int value) {
        int value2 = value * 10;
        if (findViewById(R.id.tv_luz_kayan_intamblight) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_intamblight)).setText(value2 + "%");
        }
    }

    
    public void updateInterlightOfftime(int value) {
        int value2 = value * 10;
        if (findViewById(R.id.tv_luz_kayan_intlight_offtime) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_intlight_offtime)).setText(value2 + "s");
        }
    }
}
