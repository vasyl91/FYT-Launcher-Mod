package com.syu.carinfo.xp.yinglang;

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

public class YLInfoSetFirstAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    boolean bRzc_Gl8 = false;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    if (value == 0) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text2)).setText("℃");
                        break;
                    } else {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text2)).setText("℉");
                        break;
                    }
                case 104:
                    YLInfoSetFirstAct.this.updaterlightsParking();
                    break;
                case 105:
                    YLInfoSetFirstAct.this.updaterLasuoHeadlightDelay();
                    break;
                case 106:
                    YLInfoSetFirstAct.this.updaterdefeatDoorAutoLock();
                    break;
                case 107:
                    YLInfoSetFirstAct.this.updaterdoorAutoLock();
                    break;
                case 108:
                    YLInfoSetFirstAct.this.updaterparkCarAutoUnlock();
                    break;
                case 109:
                    YLInfoSetFirstAct.this.updaterlaterLock();
                    break;
                case 110:
                    YLInfoSetFirstAct.this.updaterremoteUnlockLight();
                    break;
                case 111:
                    YLInfoSetFirstAct.this.updaterremoteLockDoor();
                    break;
                case 112:
                    YLInfoSetFirstAct.this.updaterremoteUnlock();
                    break;
                case 113:
                    YLInfoSetFirstAct.this.updaterreversWipersStart();
                    break;
                case 131:
                    YLInfoSetFirstAct.this.updaterWarnVolumSet();
                    break;
                case 164:
                    YLInfoSetFirstAct.this.updaterreversWipersStartAble();
                    break;
                case 171:
                    YLInfoSetFirstAct.this.updaterlightsParkingAble();
                    break;
                case 172:
                    YLInfoSetFirstAct.this.updaterLasuoHeadlightDelayAble();
                    break;
                case 173:
                    YLInfoSetFirstAct.this.updaterdefeatDoorAutoLockAble();
                    break;
                case 174:
                    YLInfoSetFirstAct.this.updaterparkCarAutoUnlockAble();
                    break;
                case 175:
                    YLInfoSetFirstAct.this.updaterdoorAutoLockAble();
                    break;
                case 176:
                    YLInfoSetFirstAct.this.updaterlaterLockAble();
                    break;
                case 177:
                    YLInfoSetFirstAct.this.updaterremoteLockDoorAble();
                    break;
                case 178:
                    YLInfoSetFirstAct.this.updaterremoteUnlockLightAble();
                    break;
                case 179:
                    YLInfoSetFirstAct.this.updaterremoteUnlockAble();
                    break;
                case 184:
                    YLInfoSetFirstAct.this.updaterRadarSwitch();
                    break;
                case 187:
                    YLInfoSetFirstAct.this.updateAutoDriverStartTip();
                    break;
                case 189:
                case 192:
                    YLInfoSetFirstAct.this.updaterRampAssist();
                    break;
                case 195:
                    if (value == 0) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                        break;
                    } else if (value >= 1 && value <= 6) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText("蓝色" + value);
                        break;
                    } else if (value >= 7 && value <= 12) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText("紫色" + (value - 6));
                        break;
                    } else if (value >= 13 && value <= 18) {
                        ((TextView) YLInfoSetFirstAct.this.findViewById(R.id.tv_text1)).setText("金色" + (value - 12));
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_xp_yl_info_first_set);
        init();
        setUI();
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_6));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_11));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_18));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_17));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
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
                YLInfoSetFirstAct.this.language_set = position;
                YLFunc.C_CAR_LANGUAGE_SETUP(position);
                YLInfoSetFirstAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < 16) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(this.language_set));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(this.language_set, true);
            }
        }
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Look_for_lightsParking_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Prevent_automatic_door_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Automatic_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Delay_latch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_language_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.xp_yl_radarswitch_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.rzc_gl8_auto_driver_start_tip_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_btn_Lasuo_headlight_delay_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_btn_Lasuo_headlight_delay_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lock_automatic_transmission_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lock_automatic_transmission_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_warn_volm_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_warn_volm_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lane_assist_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.xp_yl_lane_assist_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        this.bRzc_Gl8 = DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 393479;
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661 || this.bRzc_Gl8) {
            findViewById(R.id.xp_yl_lane_assist).setVisibility(0);
        } else {
            findViewById(R.id.xp_yl_lane_assist).setVisibility(8);
        }
        findViewById(R.id.rzc_gl8_auto_driver_start_tip).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        findViewById(R.id.layout_view1).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                if (YLInfoSetFirstAct.this.mLauStyle == null) {
                    YLInfoSetFirstAct.this.initLauStyle();
                }
                if (YLInfoSetFirstAct.this.mLauStyle != null && YLInfoSetFirstAct.this.mPopShowView != null) {
                    YLInfoSetFirstAct.this.mLauStyle.showAtLocation(YLInfoSetFirstAct.this.mPopShowView, 17, 0, 0);
                    YLInfoSetFirstAct.this.updateLauguageSet();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[195] - 1;
                if (value < 0) {
                    value = 18;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[195] + 1;
                if (value2 > 18) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[37] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[37] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{9, value4}, null, null);
                break;
            case R.id.xp_yl_btn_Delay_latch_check /* 2131429070 */:
                int value32 = DataCanbus.DATA[109];
                YLFunc.CAR_COMM_CONTROL(5, value32 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_Unlock_light_Feedback_check /* 2131429072 */:
                int value42 = DataCanbus.DATA[110];
                YLFunc.CAR_COMM_CONTROL(6, value42 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_lock_door_Feedback_pre /* 2131429074 */:
                int value9 = DataCanbus.DATA[111];
                if (value9 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (value9 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                } else if (value9 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (value9 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                }
            case R.id.xp_yl_Remote_control_lock_door_Feedback_next /* 2131429076 */:
                int value10 = DataCanbus.DATA[111];
                if (value10 == 0) {
                    YLFunc.CAR_COMM_CONTROL(7, 1);
                    break;
                } else if (value10 == 1) {
                    YLFunc.CAR_COMM_CONTROL(7, 2);
                    break;
                } else if (value10 == 2) {
                    YLFunc.CAR_COMM_CONTROL(7, 3);
                    break;
                } else if (value10 == 3) {
                    YLFunc.CAR_COMM_CONTROL(7, 0);
                    break;
                }
            case R.id.xp_yl_Remote_control_Unlock_check /* 2131429078 */:
                int value5 = DataCanbus.DATA[112];
                YLFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_rear_wiper_auto_start_check /* 2131429081 */:
                int value6 = DataCanbus.DATA[113];
                YLFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_warn_volm_pre /* 2131429082 */:
                int value11 = DataCanbus.DATA[131];
                if (value11 == 0) {
                    YLFunc.CAR_WARNN_VOL(15);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value11 - 1);
                    break;
                }
            case R.id.xp_yl_warn_volm_next /* 2131429084 */:
                int value12 = DataCanbus.DATA[131];
                if (value12 == 15) {
                    YLFunc.CAR_WARNN_VOL(0);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value12 + 1);
                    break;
                }
            case R.id.xp_yl_btn_Look_for_lightsParking_check /* 2131433419 */:
                int valLightPark = DataCanbus.DATA[104];
                YLFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Lasuo_headlight_delay_pre /* 2131433421 */:
                int valLasuoDelayPre = DataCanbus.DATA[105];
                if (valLasuoDelayPre == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (valLasuoDelayPre == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                } else if (valLasuoDelayPre == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (valLasuoDelayPre == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                }
            case R.id.xp_yl_btn_Lasuo_headlight_delay_next /* 2131433423 */:
                int valLasuoDelayNext = DataCanbus.DATA[105];
                if (valLasuoDelayNext == 0) {
                    YLFunc.CAR_COMM_CONTROL(1, 1);
                    break;
                } else if (valLasuoDelayNext == 1) {
                    YLFunc.CAR_COMM_CONTROL(1, 2);
                    break;
                } else if (valLasuoDelayNext == 2) {
                    YLFunc.CAR_COMM_CONTROL(1, 3);
                    break;
                } else if (valLasuoDelayNext == 3) {
                    YLFunc.CAR_COMM_CONTROL(1, 0);
                    break;
                }
            case R.id.xp_yl_btn_Prevent_automatic_door_latch_check /* 2131433424 */:
                int value1 = DataCanbus.DATA[106];
                YLFunc.CAR_COMM_CONTROL(2, value1 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Automatic_latch_check /* 2131433425 */:
                int value22 = DataCanbus.DATA[107];
                YLFunc.CAR_COMM_CONTROL(3, value22 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_lock_automatic_transmission_pre /* 2131433426 */:
                int value7 = DataCanbus.DATA[108];
                if (value7 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (value7 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                } else if (value7 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                }
            case R.id.xp_yl_lock_automatic_transmission_next /* 2131433428 */:
                int value8 = DataCanbus.DATA[108];
                if (value8 == 0) {
                    YLFunc.CAR_COMM_CONTROL(4, 1);
                    break;
                } else if (value8 == 1) {
                    YLFunc.CAR_COMM_CONTROL(4, 2);
                    break;
                } else if (value8 == 2) {
                    YLFunc.CAR_COMM_CONTROL(4, 0);
                    break;
                }
            case R.id.xp_yl_lane_assist_pre /* 2131433431 */:
            case R.id.xp_yl_lane_assist_next /* 2131433433 */:
                int value13 = DataCanbus.DATA[189];
                if (this.bRzc_Gl8) {
                    value13 = DataCanbus.DATA[192];
                }
                YLFunc.CAR_COMM_CONTROL(81, value13 == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_auto_driver_start_tip_check /* 2131433435 */:
                YLFunc.CAR_COMM_CONTROL(82, DataCanbus.DATA[187] == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_radarswitch_check /* 2131433437 */:
                int value62 = DataCanbus.DATA[184];
                YLFunc.CAR_ON_RADAR_CTL(value62 == 0 ? 1 : 0);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
        setViewVisible(findViewById(R.id.all_func_btn_lauguage_set_view), 1);
        if (DataCanbus.DATA[1000] == 2359321) {
            setViewVisible(findViewById(R.id.xp_yl_radarswitch_view), 0);
            setViewVisible(findViewById(R.id.xp_yl_warn_volm_view), 0);
        }
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
            setViewVisible(findViewById(R.id.xp_yl_radarswitch_view), 0);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    @Override
    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
            DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        if (this.bRzc_Gl8) {
            DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
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
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 6422589 || DataCanbus.DATA[1000] == 6488125 || DataCanbus.DATA[1000] == 6553661) {
            DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        }
        if (this.bRzc_Gl8) {
            DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterlightsParkingAble() {
        int enable = DataCanbus.DATA[171];
        if (enable == 0) {
            findViewById(R.id.xp_yl_btn_Look_for_lightsParking_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_btn_Look_for_lightsParking_view).setVisibility(0);
        }
    }

    protected void updateAutoDriverStartTip() {
        int enable = DataCanbus.DATA[187];
        ((CheckedTextView) findViewById(R.id.rzc_gl8_auto_driver_start_tip_check)).setChecked(enable != 0);
    }

    
    public void updaterLasuoHeadlightDelayAble() {
        int enable = DataCanbus.DATA[172];
        if (enable == 0) {
            findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_view).setVisibility(0);
        }
    }

    
    public void updaterdefeatDoorAutoLockAble() {
        int enable = DataCanbus.DATA[173];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_Prevent_automatic_door_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_Prevent_automatic_door_latch_view).setVisibility(0);
        }
    }

    
    public void updaterdoorAutoLockAble() {
        int enable = DataCanbus.DATA[175];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_Automatic_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_Automatic_latch_view).setVisibility(0);
        }
    }

    
    public void updaterparkCarAutoUnlockAble() {
        int enable = DataCanbus.DATA[174];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_automatic_transmission).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_automatic_transmission).setVisibility(0);
        }
    }

    
    public void updaterlaterLockAble() {
        int enable = DataCanbus.DATA[176];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(0);
        }
    }

    
    public void updaterremoteUnlockLightAble() {
        int enable = DataCanbus.DATA[178];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback).setVisibility(0);
        }
    }

    
    public void updaterremoteLockDoorAble() {
        int enable = DataCanbus.DATA[177];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback).setVisibility(0);
        }
    }

    
    public void updaterremoteUnlockAble() {
        int enable = DataCanbus.DATA[179];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Remote_control_Unlock).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Remote_control_Unlock).setVisibility(0);
        }
    }

    
    public void updaterreversWipersStartAble() {
        int enable = DataCanbus.DATA[164];
        if (enable == 0) {
            findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start).setVisibility(0);
        }
    }

    
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Look_for_lightsParking_check)).setChecked(switchOn != 0);
    }

    
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[105];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_Parking_with_trailer_Off);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_tv)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
        }
    }

    
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Prevent_automatic_door_latch_check)).setChecked(switchOn != 0);
        if (this.bRzc_Gl8) {
            if (switchOn == 0) {
                findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(0);
            } else if (switchOn == 1) {
                findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(8);
            }
        }
    }

    
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Automatic_latch_check)).setChecked(switchOn != 0);
    }

    
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[108];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Delay_latch_check)).setChecked(switchOn != 0);
    }

    
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback_check)).setChecked(switchOn != 0);
    }

    
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[111];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_remote_Remote_control_latch_only_light);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_remote_Remote_control_latch_speaker);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        }
    }

    
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[112];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[113];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start_check)).setChecked(switchOn != 0);
    }

    
    public void updaterRadarSwitch() {
        int switchOn = DataCanbus.DATA[184];
        ((CheckedTextView) findViewById(R.id.xp_yl_radarswitch_check)).setChecked(switchOn != 0);
    }

    
    public void updaterWarnVolumSet() {
        int switchOn = DataCanbus.DATA[131];
        ((TextView) findViewById(R.id.xp_yl_warn_volm_tv)).setText(new StringBuilder().append(switchOn).toString());
    }

    
    public void updaterRampAssist() {
        int switchOn = DataCanbus.DATA[189];
        if (this.bRzc_Gl8) {
            switchOn = DataCanbus.DATA[192];
        }
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_lane_assist_tv)).setText(R.string.xp_yl_lane_assist_str1);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_lane_assist_tv)).setText(R.string.xp_yl_lane_assist_str2);
        }
    }
}
