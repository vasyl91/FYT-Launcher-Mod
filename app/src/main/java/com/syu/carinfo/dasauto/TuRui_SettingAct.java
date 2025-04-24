package com.syu.carinfo.dasauto;

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
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;

@SuppressWarnings({"deprecation", "unchecked"})
public class TuRui_SettingAct extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int iLanguageSet = 0;
    private int[] eventIds = {124, 125, 218, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 138, 137, 175, 116, 117, 118, 119, 120, 231, 232, 233, 234, 235, 236, 274, 275, 273, 179};
    int language_set = 255;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    TuRui_SettingAct.this.uAutoActive(DataCanbus.DATA[updateCode]);
                    break;
                case 117:
                    TuRui_SettingAct.this.uFVol(DataCanbus.DATA[updateCode]);
                    break;
                case 118:
                    TuRui_SettingAct.this.uFTone(DataCanbus.DATA[updateCode]);
                    break;
                case 119:
                    TuRui_SettingAct.this.uRVol(DataCanbus.DATA[updateCode]);
                    break;
                case 120:
                    TuRui_SettingAct.this.uRTone(DataCanbus.DATA[updateCode]);
                    break;
                case 124:
                    TuRui_SettingAct.this.uSpeedWarn(DataCanbus.DATA[updateCode]);
                    break;
                case 125:
                    TuRui_SettingAct.this.uSpeedWarnAt(DataCanbus.DATA[updateCode]);
                    break;
                case 137:
                    TuRui_SettingAct.this.uDoorUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 138:
                    TuRui_SettingAct.this.uAutoLock(DataCanbus.DATA[updateCode]);
                    break;
                case 175:
                    TuRui_SettingAct.this.uDaytimeLight(DataCanbus.DATA[updateCode]);
                    break;
                case 179:
                    TuRui_SettingAct.this.UpdateVehicleVin(ConstGolf.mCarId);
                    break;
                case 218:
                    TuRui_SettingAct.this.uRainSensor(DataCanbus.DATA[updateCode]);
                    break;
                case 220:
                    TuRui_SettingAct.this.uLeftDrive(DataCanbus.DATA[updateCode]);
                    break;
                case 221:
                    TuRui_SettingAct.this.uSmartBiglight(DataCanbus.DATA[updateCode]);
                    break;
                case 222:
                    TuRui_SettingAct.this.uHomelight(DataCanbus.DATA[updateCode]);
                    break;
                case 223:
                    TuRui_SettingAct.this.uLeaveHomelight(DataCanbus.DATA[updateCode]);
                    break;
                case 224:
                    TuRui_SettingAct.this.uFootlight(DataCanbus.DATA[updateCode]);
                    break;
                case 225:
                    TuRui_SettingAct.this.uInSidelight(DataCanbus.DATA[updateCode]);
                    break;
                case 226:
                    TuRui_SettingAct.this.uFWin(DataCanbus.DATA[updateCode]);
                    break;
                case 227:
                    TuRui_SettingAct.this.uRWin(DataCanbus.DATA[updateCode]);
                    break;
                case 228:
                    TuRui_SettingAct.this.uSkyWin(DataCanbus.DATA[updateCode]);
                    break;
                case 229:
                    TuRui_SettingAct.this.uFoldMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 230:
                    TuRui_SettingAct.this.uOnlyUnlockTrunk(DataCanbus.DATA[updateCode]);
                    break;
                case 231:
                    TuRui_SettingAct.this.uUnitDistance(DataCanbus.DATA[updateCode]);
                    break;
                case 232:
                    TuRui_SettingAct.this.uUnitSpeed(DataCanbus.DATA[updateCode]);
                    break;
                case 233:
                    TuRui_SettingAct.this.uUnitTemp(DataCanbus.DATA[updateCode]);
                    break;
                case 234:
                    TuRui_SettingAct.this.uUnitCapacity(DataCanbus.DATA[updateCode]);
                    break;
                case 235:
                    TuRui_SettingAct.this.uUnitEnergy(DataCanbus.DATA[updateCode]);
                    break;
                case 236:
                    TuRui_SettingAct.this.uUnitTirePress(DataCanbus.DATA[updateCode]);
                    break;
                case 273:
                    TuRui_SettingAct.this.uMatchedKeys(DataCanbus.DATA[updateCode]);
                    break;
                case 274:
                    TuRui_SettingAct.this.uTireLoadStatus(DataCanbus.DATA[updateCode]);
                    break;
                case 275:
                    TuRui_SettingAct.this.uTireType(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    private int[] doorUnlockStr = {R.string.wc_ruiteng_string_unlock_mode_1, R.string.wc_ruiteng_string_unlock_mode_0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_turui_settings);
        init();
    }

    
    public void sendCMD(int type, int cmd, int value) {
        DataCanbus.PROXY.cmd(23, new int[]{type, cmd, value}, null, null);
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
                TuRui_SettingAct.this.language_set = position;
                if (TuRui_SettingAct.this.language_set >= 0 && TuRui_SettingAct.this.language_set <= TuRui_SettingAct.this.mLauStylelist.size() && TuRui_SettingAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(105, new int[]{1, TuRui_SettingAct.this.send_lang[TuRui_SettingAct.this.language_set]}, null, null);
                }
                TuRui_SettingAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_10));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_14));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_23));
        this.mLauStylelist.add("Malaysian");
        this.mLauStylelist.add("Thai");
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 25};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (TuRui_SettingAct.this.mLauStyle == null) {
                    TuRui_SettingAct.this.initLauStyle();
                }
                if (TuRui_SettingAct.this.mLauStyle != null && TuRui_SettingAct.this.mPopShowView != null) {
                    TuRui_SettingAct.this.mLauStyle.showAtLocation(TuRui_SettingAct.this.mPopShowView, 17, 0, 0);
                    TuRui_SettingAct.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_winter_tyres), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[124] & 255;
                TuRui_SettingAct.this.sendCMD(75, 2, val == 1 ? 0 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_tpres_setting_warnint_at_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[125] & 255) + 10;
                if (val > 240) {
                    val = 240;
                }
                TuRui_SettingAct.this.sendCMD(75, 3, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_tpres_setting_warnint_at_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[125] & 255) - 10;
                if (val < 30) {
                    val = 30;
                }
                TuRui_SettingAct.this.sendCMD(75, 3, val);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_rainsensor), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[218] & 255;
                TuRui_SettingAct.this.sendCMD(77, 1, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_leftdriver), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[220] & 255;
                TuRui_SettingAct.this.sendCMD(109, 19, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_smartbiglight), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[221] & 255;
                TuRui_SettingAct.this.sendCMD(109, 18, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_daytimelight), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[175] & 255;
                TuRui_SettingAct.this.sendCMD(109, 16, val == 1 ? 0 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_homelight_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[222] & 255) - 1;
                if (val < 1) {
                    val = 1;
                }
                TuRui_SettingAct.this.sendCMD(109, 13, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_homelight_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[222] & 255) + 1;
                if (val > 3) {
                    val = 3;
                }
                TuRui_SettingAct.this.sendCMD(109, 13, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_leavehomelight_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[223] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(109, 14, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_leavehomelight_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[223] & 255) + 1;
                if (val > 3) {
                    val = 3;
                }
                TuRui_SettingAct.this.sendCMD(109, 14, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_footlight_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[224] & 255) - 10;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(109, 15, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_footlight_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[224] & 255) + 10;
                if (val > 100) {
                    val = 100;
                }
                TuRui_SettingAct.this.sendCMD(109, 15, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_insidecarlight_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[225] & 255) + 10;
                if (val > 100) {
                    val = 100;
                }
                TuRui_SettingAct.this.sendCMD(109, 17, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_insidecarlight_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[225] & 255) - 10;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(109, 17, val);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_frontwindow), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[226] & 255;
                TuRui_SettingAct.this.sendCMD(111, 1, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_rearwindow), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[227] & 255;
                TuRui_SettingAct.this.sendCMD(111, 2, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_skywindow), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[228] & 255;
                TuRui_SettingAct.this.sendCMD(111, 3, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_autolock), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[138] & 255;
                TuRui_SettingAct.this.sendCMD(111, 5, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_foldrearmirror), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[229] & 255;
                TuRui_SettingAct.this.sendCMD(111, 6, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_cardoor_unlock), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[137] & 255;
                TuRui_SettingAct.this.sendCMD(111, 7, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_only_unlock_trunk), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[230] & 255;
                TuRui_SettingAct.this.sendCMD(111, 8, val == 1 ? 0 : 1);
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.turui_activate_automaticlly), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[116] & 255;
                TuRui_SettingAct.this.sendCMD(122, 5, val == 1 ? 0 : 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_frontvol_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[117] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 1, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_frontvol_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[117] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 1, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_fronttune_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[118] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 2, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_fronttune_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[118] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 2, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_rearvol_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[119] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 3, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_rearvol_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[119] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 3, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_reartone_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[120] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(122, 4, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_reartone_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[120] & 255) + 1;
                if (val > 9) {
                    val = 9;
                }
                TuRui_SettingAct.this.sendCMD(122, 4, val);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_distance_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[231] & 255;
                TuRui_SettingAct.this.sendCMD(202, 1, val == 0 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_distance_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[231] & 255;
                TuRui_SettingAct.this.sendCMD(202, 1, val == 0 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_speed_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[232] & 255;
                TuRui_SettingAct.this.sendCMD(202, 2, val == 0 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_speed_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[232] & 255;
                TuRui_SettingAct.this.sendCMD(202, 2, val == 0 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_temp_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[233] & 255;
                TuRui_SettingAct.this.sendCMD(202, 3, val == 0 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_temp_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = DataCanbus.DATA[233] & 255;
                TuRui_SettingAct.this.sendCMD(202, 3, val == 0 ? 1 : 2);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_capacity_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[234] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(202, 4, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_capacity_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[234] & 255) + 1;
                if (val > 2) {
                    val = 2;
                }
                TuRui_SettingAct.this.sendCMD(202, 4, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_energycost_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[235] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(202, 5, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_energycost_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[235] & 255) + 1;
                if (val > 3) {
                    val = 3;
                }
                TuRui_SettingAct.this.sendCMD(202, 5, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_tirepress_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[236] & 255) - 1;
                if (val < 0) {
                    val = 0;
                }
                TuRui_SettingAct.this.sendCMD(202, 6, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_unit_tirepress_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int val = (DataCanbus.DATA[236] & 255) + 1;
                if (val > 2) {
                    val = 2;
                }
                TuRui_SettingAct.this.sendCMD(202, 6, val + 1);
            }
        });
        setSelfClick(findViewById(R.id.turui_language_setting_minus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (TuRui_SettingAct.this.iLanguageSet <= 1) {
                    TuRui_SettingAct.this.iLanguageSet = 16;
                } else {
                    TuRui_SettingAct tuRui_SettingAct = TuRui_SettingAct.this;
                    tuRui_SettingAct.iLanguageSet--;
                }
                TuRui_SettingAct.this.UpdateLanguageSettings(TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.sendCMD(154, 1, TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.getSharedPreferences("turui", 0).edit().putInt("languageset", TuRui_SettingAct.this.iLanguageSet).commit();
            }
        });
        setSelfClick(findViewById(R.id.turui_language_setting_plus), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (TuRui_SettingAct.this.iLanguageSet >= 16) {
                    TuRui_SettingAct.this.iLanguageSet = 1;
                } else {
                    TuRui_SettingAct.this.iLanguageSet++;
                }
                TuRui_SettingAct.this.UpdateLanguageSettings(TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.sendCMD(154, 1, TuRui_SettingAct.this.iLanguageSet);
                TuRui_SettingAct.this.getSharedPreferences("turui", 0).edit().putInt("languageset", TuRui_SettingAct.this.iLanguageSet).commit();
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_load_status_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[274] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 1, value);
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_load_status_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[274] & 255;
                if (value2 == 1) {
                    value = 2;
                } else {
                    value = 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 1, value);
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_type_m), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[275];
                if (value2 <= 0) {
                    value = 8;
                } else {
                    value = value2 - 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 2, value);
            }
        });
        setSelfClick(findViewById(R.id.turui_tire_type_p), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[275] & 255;
                if (value2 >= 8) {
                    value = 0;
                } else {
                    value = value2 + 1;
                }
                TuRui_SettingAct.this.sendCMD(205, 2, value);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] != 196878) {
            if (((TextView) findViewById(R.id.turui_tire_title)) != null) {
                ((TextView) findViewById(R.id.turui_tire_title)).setVisibility(8);
            }
            if (((TextView) findViewById(R.id.turui_matchedkeys_title)) != null) {
                ((TextView) findViewById(R.id.turui_matchedkeys_title)).setVisibility(8);
            }
            if (findViewById(R.id.turui_tire_load_status_view) != null) {
                findViewById(R.id.turui_tire_load_status_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_tire_type_view) != null) {
                findViewById(R.id.turui_tire_type_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_matchedkeys_view) != null) {
                findViewById(R.id.turui_matchedkeys_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_vehicle_vin_view) != null) {
                findViewById(R.id.turui_vehicle_vin_view).setVisibility(8);
            }
            if (findViewById(R.id.turui_language_setting_view) != null) {
                findViewById(R.id.turui_language_setting_view).setVisibility(8);
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.turui_tire_title)) != null) {
            ((TextView) findViewById(R.id.turui_tire_title)).setVisibility(0);
        }
        if (((TextView) findViewById(R.id.turui_matchedkeys_title)) != null) {
            ((TextView) findViewById(R.id.turui_matchedkeys_title)).setVisibility(0);
        }
        if (findViewById(R.id.turui_tire_load_status_view) != null) {
            findViewById(R.id.turui_tire_load_status_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_tire_type_view) != null) {
            findViewById(R.id.turui_tire_type_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_matchedkeys_view) != null) {
            findViewById(R.id.turui_matchedkeys_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_vehicle_vin_view) != null) {
            findViewById(R.id.turui_vehicle_vin_view).setVisibility(0);
        }
        if (findViewById(R.id.turui_language_setting_view) != null) {
            findViewById(R.id.turui_language_setting_view).setVisibility(0);
        }
        this.iLanguageSet = getSharedPreferences("turui", 0).getInt("languageset", 1);
        UpdateLanguageSettings(this.iLanguageSet);
    }

    @Override
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.notifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.notifyCanbus);
        }
    }

    
    public void UpdateVehicleVin(String str) {
        if (((TextView) findViewById(R.id.turui_vehiclevin_txt)) != null) {
            ((TextView) findViewById(R.id.turui_vehiclevin_txt)).setText(str);
        }
    }

    
    public void UpdateLanguageSettings(int val) {
        if (((TextView) findViewById(R.id.turui_language_setting_show)) != null) {
            String str = "";
            switch (val) {
                case 1:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_1);
                    break;
                case 2:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_2);
                    break;
                case 3:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_3);
                    break;
                case 4:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_4);
                    break;
                case 5:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_5);
                    break;
                case 6:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_6);
                    break;
                case 7:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_7);
                    break;
                case 8:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_8);
                    break;
                case 9:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_9);
                    break;
                case 10:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_10);
                    break;
                case 11:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_11);
                    break;
                case 12:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_12);
                    break;
                case 13:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_13);
                    break;
                case 14:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_14);
                    break;
                case 15:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_15);
                    break;
                case 16:
                    str = getResources().getString(R.string.wc_psa_all_lauguage_set_value_16);
                    break;
            }
            ((TextView) findViewById(R.id.turui_language_setting_show)).setText(str);
        }
    }

    
    public void uTireLoadStatus(int val) {
        if (((TextView) findViewById(R.id.turui_tire_load_status_txt)) != null) {
            if (findViewById(R.id.turui_tire_load_status_view) != null) {
                findViewById(R.id.turui_tire_load_status_view).setVisibility(1 == 1 ? 0 : 8);
            }
            int val2 = val & 255;
            String str = getResources().getString(R.string.str_270_tirepress2);
            if (val2 == 1) {
                str = getResources().getString(R.string.str_270_tirepress2);
            } else if (val2 == 2) {
                str = getResources().getString(R.string.str_270_tirepress3);
            }
            ((TextView) findViewById(R.id.turui_tire_load_status_txt)).setText(str);
        }
    }

    
    public void uTireType(int val) {
        if (((TextView) findViewById(R.id.turui_tire_type_txt)) != null) {
            if (findViewById(R.id.turui_tire_type_view) != null) {
                findViewById(R.id.turui_tire_type_view).setVisibility(1 == 1 ? 0 : 8);
            }
            String str = String.valueOf(val & 255);
            ((TextView) findViewById(R.id.turui_tire_type_txt)).setText(str);
        }
    }

    
    public void uMatchedKeys(int val) {
        if (((TextView) findViewById(R.id.turui_matchedkeys_txt)) != null) {
            if (findViewById(R.id.turui_matchedkeys_view) != null) {
                findViewById(R.id.turui_matchedkeys_view).setVisibility(1 == 1 ? 0 : 8);
            }
            String str = String.valueOf(val & 255);
            ((TextView) findViewById(R.id.turui_matchedkeys_txt)).setText(str);
        }
    }

    
    public void uSpeedWarn(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_winter_tyres)) != null) {
            if (findViewById(R.id.turui_winter_tyres_view) != null) {
                findViewById(R.id.turui_winter_tyres_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_winter_tyres)).setChecked((val & 255) == 1);
        }
    }

    
    public void uSpeedWarnAt(int val) {
        if (((TextView) findViewById(R.id.turui_tpres_setting_warnint_at_txt)) != null) {
            if (findViewById(R.id.turui_tpres_setting_warnint_at_view) != null) {
                findViewById(R.id.turui_tpres_setting_warnint_at_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((TextView) findViewById(R.id.turui_tpres_setting_warnint_at_txt)).setText((val & 255) + " km/h");
        }
    }

    
    public void uRainSensor(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_rainsensor)) != null) {
            if (findViewById(R.id.turui_rainsensor_view) != null) {
                findViewById(R.id.turui_rainsensor_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_rainsensor)).setChecked((val & 255) == 1);
        }
    }

    
    public void uLeftDrive(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_leftdriver)) != null) {
            if (findViewById(R.id.turui_leftdriver_view) != null) {
                findViewById(R.id.turui_leftdriver_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_leftdriver)).setChecked((val & 255) == 1);
        }
    }

    
    public void uSmartBiglight(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_smartbiglight)) != null) {
            if (findViewById(R.id.turui_smartbiglight_view) != null) {
                findViewById(R.id.turui_smartbiglight_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_smartbiglight)).setChecked((val & 255) == 1);
        }
    }

    
    public void uHomelight(int val) {
        if (((TextView) findViewById(R.id.turui_homelight_txt)) != null) {
            if (findViewById(R.id.turui_homelight_view) != null) {
                findViewById(R.id.turui_homelight_view).setVisibility(1 == 1 ? 0 : 8);
            }
            int val2 = val & 255;
            int id = R.string.off;
            if (val2 == 1) {
                id = R.string.str_wc_jy_str8;
            } else if (val2 == 2) {
                id = R.string.str_wc_jy_str9;
            } else if (val2 == 3) {
                id = R.string.str_wc_jy_str10;
            }
            ((TextView) findViewById(R.id.turui_homelight_txt)).setText(id);
        }
    }

    
    public void uLeaveHomelight(int val) {
        if (((TextView) findViewById(R.id.turui_leavehomelight_txt)) != null) {
            if (findViewById(R.id.turui_leavehomelight_view) != null) {
                findViewById(R.id.turui_leavehomelight_view).setVisibility(1 == 1 ? 0 : 8);
            }
            int val2 = val & 255;
            int id = R.string.off;
            if (val2 == 1) {
                id = R.string.str_wc_jy_str8;
            } else if (val2 == 2) {
                id = R.string.str_wc_jy_str9;
            } else if (val2 == 3) {
                id = R.string.str_wc_jy_str10;
            }
            ((TextView) findViewById(R.id.turui_leavehomelight_txt)).setText(id);
        }
    }

    
    public void uFootlight(int val) {
        if (((TextView) findViewById(R.id.turui_footlight_txt)) != null) {
            if (findViewById(R.id.turui_footlight_view) != null) {
                findViewById(R.id.turui_footlight_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((TextView) findViewById(R.id.turui_footlight_txt)).setText(String.valueOf(val & 255) + "%");
        }
    }

    
    public void uInSidelight(int val) {
        if (((TextView) findViewById(R.id.turui_insidecarlight_txt)) != null) {
            ((TextView) findViewById(R.id.turui_insidecarlight_txt)).setText(String.valueOf(val & 255) + "%");
        }
    }

    
    public void uFWin(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_frontwindow)) != null) {
            if (findViewById(R.id.turui_frontwindow_view) != null) {
                findViewById(R.id.turui_frontwindow_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_frontwindow)).setChecked((val & 255) == 1);
        }
    }

    
    public void uRWin(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_rearwindow)) != null) {
            if (findViewById(R.id.turui_rearwindow_view) != null) {
                findViewById(R.id.turui_rearwindow_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_rearwindow)).setChecked((val & 255) == 1);
        }
    }

    
    public void uSkyWin(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_skywindow)) != null) {
            if (findViewById(R.id.turui_skywindow_view) != null) {
                findViewById(R.id.turui_skywindow_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_skywindow)).setChecked((val & 255) == 1);
        }
    }

    
    public void uFoldMirror(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_foldrearmirror)) != null) {
            if (findViewById(R.id.turui_foldrearmirror_view) != null) {
                findViewById(R.id.turui_foldrearmirror_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_foldrearmirror)).setChecked((val & 255) == 1);
        }
    }

    
    public void uOnlyUnlockTrunk(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_only_unlock_trunk)) != null) {
            if (findViewById(R.id.turui_only_unlock_trunk_view) != null) {
                findViewById(R.id.turui_only_unlock_trunk_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_only_unlock_trunk)).setChecked((val & 255) == 1);
        }
    }

    
    public void uAutoLock(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_autolock)) != null) {
            if (findViewById(R.id.turui_autolock_view) != null) {
                findViewById(R.id.turui_autolock_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_autolock)).setChecked((val & 255) == 1);
        }
    }

    
    public void uDoorUnlock(int val) {
        if (findViewById(R.id.turui_cardoor_unlock_view) != null) {
            findViewById(R.id.turui_cardoor_unlock_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((CheckedTextView) findViewById(R.id.turui_cardoor_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.turui_cardoor_unlock)).setChecked(val2 == 1);
        }
        if (((TextView) findViewById(R.id.turui_cardoor_unlock_txt)) != null) {
            ((TextView) findViewById(R.id.turui_cardoor_unlock_txt)).setText(this.doorUnlockStr[val2 % 2]);
        }
    }

    
    public void uDaytimeLight(int val) {
        if (((CheckedTextView) findViewById(R.id.turui_daytimelight)) != null) {
            if (findViewById(R.id.turui_daytimelight_view) != null) {
                findViewById(R.id.turui_daytimelight_view).setVisibility(1 == 1 ? 0 : 8);
            }
            ((CheckedTextView) findViewById(R.id.turui_daytimelight)).setChecked((val & 255) == 1);
        }
    }

    
    public void uAutoActive(int val) {
        if (findViewById(R.id.turui_activate_automaticlly_view) != null) {
            findViewById(R.id.turui_activate_automaticlly_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((CheckedTextView) findViewById(R.id.turui_activate_automaticlly)) != null) {
            ((CheckedTextView) findViewById(R.id.turui_activate_automaticlly)).setChecked(val2 == 1);
        }
    }

    
    public void uFVol(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_frontvol_txt)) != null) {
            ((TextView) findViewById(R.id.turui_frontvol_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    
    public void uFTone(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_fronttune_txt)) != null) {
            ((TextView) findViewById(R.id.turui_fronttune_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    
    public void uRVol(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_rearvol_txt)) != null) {
            ((TextView) findViewById(R.id.turui_rearvol_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    
    public void uRTone(int val) {
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_reartone_txt)) != null) {
            ((TextView) findViewById(R.id.turui_reartone_txt)).setText(new StringBuilder().append(val2).toString());
        }
    }

    
    public void uUnitDistance(int val) {
        if (findViewById(R.id.turui_unit_distance_view) != null) {
            findViewById(R.id.turui_unit_distance_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_distance_txt)) != null) {
            int id = R.string.str_turui_str12;
            if (val2 == 1) {
                id = R.string.str_bogoo_bmw_juli_unit_0;
            }
            ((TextView) findViewById(R.id.turui_unit_distance_txt)).setText(id);
        }
    }

    
    public void uUnitSpeed(int val) {
        if (findViewById(R.id.turui_unit_speed_view) != null) {
            findViewById(R.id.turui_unit_speed_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_speed_txt)) != null) {
            int id = R.string.str_turui_str14;
            if (val2 == 1) {
                id = R.string.str_turui_str13;
            }
            ((TextView) findViewById(R.id.turui_unit_speed_txt)).setText(id);
        }
    }

    
    public void uUnitTemp(int val) {
        if (findViewById(R.id.turui_unit_temp_view) != null) {
            findViewById(R.id.turui_unit_temp_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_temp_txt)) != null) {
            int id = R.string.wc_15ruijie_temp_unit_f_set;
            if (val2 == 1) {
                id = R.string.wc_15ruijie_temp_unit_c_set;
            }
            ((TextView) findViewById(R.id.turui_unit_temp_txt)).setText(id);
        }
    }

    
    public void uUnitCapacity(int val) {
        if (findViewById(R.id.turui_unit_capacity_view) != null) {
            findViewById(R.id.turui_unit_capacity_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_capacity_txt)) != null) {
            int id = R.string.str_turui_str15;
            if (val2 == 1) {
                id = R.string.str_turui_str16;
            } else if (val2 == 2) {
                id = R.string.str_turui_str17;
            }
            ((TextView) findViewById(R.id.turui_unit_capacity_txt)).setText(id);
        }
    }

    
    public void uUnitEnergy(int val) {
        if (findViewById(R.id.turui_unit_energycost_view) != null) {
            findViewById(R.id.turui_unit_energycost_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_energycost_txt)) != null) {
            int id = R.string.str_bogoo_bmw_oil_unit_0;
            if (val2 == 1) {
                id = R.string.str_bogoo_bmw_oil_unit_3;
            } else if (val2 == 2) {
                id = R.string.str_bogoo_bmw_oil_unit_1;
            } else if (val2 == 3) {
                id = R.string.str_bogoo_bmw_oil_unit_2;
            }
            ((TextView) findViewById(R.id.turui_unit_energycost_txt)).setText(id);
        }
    }

    
    public void uUnitTirePress(int val) {
        if (findViewById(R.id.turui_unit_tirepress_view) != null) {
            findViewById(R.id.turui_unit_tirepress_view).setVisibility(1 == 1 ? 0 : 8);
        }
        int val2 = val & 255;
        if (((TextView) findViewById(R.id.turui_unit_tirepress_txt)) != null) {
            int id = R.string.str_press_unit_0;
            if (val2 == 1) {
                id = R.string.str_press_unit_1;
            } else if (val2 == 2) {
                id = R.string.str_press_unit_2;
            }
            ((TextView) findViewById(R.id.turui_unit_tirepress_txt)).setText(id);
        }
    }
}
