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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class YLInfoSetFirstAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    boolean bRzc_Gl8 = false;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 7:
                    YLInfoSetFirstAct.this.updaterlightsParking();
                    break;
                case 8:
                    YLInfoSetFirstAct.this.updaterLasuoHeadlightDelay();
                    break;
                case 9:
                    YLInfoSetFirstAct.this.updaterdefeatDoorAutoLock();
                    break;
                case 10:
                    YLInfoSetFirstAct.this.updaterdoorAutoLock();
                    break;
                case 11:
                    YLInfoSetFirstAct.this.updaterparkCarAutoUnlock();
                    break;
                case 12:
                    YLInfoSetFirstAct.this.updaterlaterLock();
                    break;
                case 13:
                    YLInfoSetFirstAct.this.updaterremoteUnlockLight();
                    break;
                case 14:
                    YLInfoSetFirstAct.this.updaterremoteLockDoor();
                    break;
                case 15:
                    YLInfoSetFirstAct.this.updaterremoteUnlock();
                    break;
                case 16:
                    YLInfoSetFirstAct.this.updaterreversWipersStart();
                    break;
                case 34:
                    YLInfoSetFirstAct.this.updaterWarnVolumSet();
                    break;
                case 67:
                    YLInfoSetFirstAct.this.updaterreversWipersStartAble();
                    break;
                case 74:
                    YLInfoSetFirstAct.this.updaterlightsParkingAble();
                    break;
                case 75:
                    YLInfoSetFirstAct.this.updaterLasuoHeadlightDelayAble();
                    break;
                case 76:
                    YLInfoSetFirstAct.this.updaterdefeatDoorAutoLockAble();
                    break;
                case 77:
                    YLInfoSetFirstAct.this.updaterparkCarAutoUnlockAble();
                    break;
                case 78:
                    YLInfoSetFirstAct.this.updaterdoorAutoLockAble();
                    break;
                case 79:
                    YLInfoSetFirstAct.this.updaterlaterLockAble();
                    break;
                case 80:
                    YLInfoSetFirstAct.this.updaterremoteLockDoorAble();
                    break;
                case 81:
                    YLInfoSetFirstAct.this.updaterremoteUnlockLightAble();
                    break;
                case 82:
                    YLInfoSetFirstAct.this.updaterremoteUnlockAble();
                    break;
                case 121:
                    YLInfoSetFirstAct.this.updaterRadarSwitch();
                    break;
                case 124:
                case 298:
                    YLInfoSetFirstAct.this.updaterRampAssist();
                    break;
                case 281:
                    YLInfoSetFirstAct.this.updateAutoDriverStartTip();
                    break;
                case 301:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_info_first_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
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

    /* JADX INFO: Access modifiers changed from: private */
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
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
        this.bRzc_Gl8 = DataCanbus.DATA[1000] == 262407 || DataCanbus.DATA[1000] == 327943 || DataCanbus.DATA[1000] == 655623 || DataCanbus.DATA[1000] == 524551 || DataCanbus.DATA[1000] == 590087 || DataCanbus.DATA[1000] == 393479;
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436 || this.bRzc_Gl8) {
            findViewById(R.id.xp_yl_lane_assist).setVisibility(0);
        } else {
            findViewById(R.id.xp_yl_lane_assist).setVisibility(8);
        }
        findViewById(R.id.rzc_gl8_auto_driver_start_tip).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        findViewById(R.id.layout_view1).setVisibility(this.bRzc_Gl8 ? 0 : 8);
        ((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.yinglang.YLInfoSetFirstAct.3
            @Override // android.view.View.OnClickListener
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[301] - 1;
                if (value < 0) {
                    value = 18;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[301] + 1;
                if (value2 > 18) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{32, value2}, null, null);
                break;
            case R.id.xp_yl_btn_Delay_latch_check /* 2131429110 */:
                int value3 = DataCanbus.DATA[12];
                YLFunc.CAR_COMM_CONTROL(5, value3 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_Unlock_light_Feedback_check /* 2131429112 */:
                int value4 = DataCanbus.DATA[13];
                YLFunc.CAR_COMM_CONTROL(6, value4 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_Remote_control_lock_door_Feedback_pre /* 2131429114 */:
                int value9 = DataCanbus.DATA[14];
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
            case R.id.xp_yl_Remote_control_lock_door_Feedback_next /* 2131429116 */:
                int value10 = DataCanbus.DATA[14];
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
            case R.id.xp_yl_Remote_control_Unlock_check /* 2131429118 */:
                int value5 = DataCanbus.DATA[15];
                YLFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_comfort_rear_wiper_auto_start_check /* 2131429121 */:
                int value6 = DataCanbus.DATA[16];
                YLFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_warn_volm_pre /* 2131429122 */:
                int value11 = DataCanbus.DATA[34];
                if (value11 == 0) {
                    YLFunc.CAR_WARNN_VOL(15);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value11 - 1);
                    break;
                }
            case R.id.xp_yl_warn_volm_next /* 2131429124 */:
                int value12 = DataCanbus.DATA[34];
                if (value12 == 15) {
                    YLFunc.CAR_WARNN_VOL(0);
                    break;
                } else {
                    YLFunc.CAR_WARNN_VOL(value12 + 1);
                    break;
                }
            case R.id.xp_yl_btn_Look_for_lightsParking_check /* 2131433505 */:
                int valLightPark = DataCanbus.DATA[7];
                YLFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Lasuo_headlight_delay_pre /* 2131433507 */:
                int valLasuoDelayPre = DataCanbus.DATA[8];
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
            case R.id.xp_yl_btn_Lasuo_headlight_delay_next /* 2131433509 */:
                int valLasuoDelayNext = DataCanbus.DATA[8];
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
            case R.id.xp_yl_btn_Prevent_automatic_door_latch_check /* 2131433510 */:
                int value1 = DataCanbus.DATA[9];
                YLFunc.CAR_COMM_CONTROL(2, value1 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_btn_Automatic_latch_check /* 2131433511 */:
                int value22 = DataCanbus.DATA[10];
                YLFunc.CAR_COMM_CONTROL(3, value22 == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_lock_automatic_transmission_pre /* 2131433512 */:
                int value7 = DataCanbus.DATA[11];
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
            case R.id.xp_yl_lock_automatic_transmission_next /* 2131433514 */:
                int value8 = DataCanbus.DATA[11];
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
            case R.id.xp_yl_lane_assist_pre /* 2131433517 */:
            case R.id.xp_yl_lane_assist_next /* 2131433519 */:
                int value13 = DataCanbus.DATA[124];
                if (this.bRzc_Gl8) {
                    value13 = DataCanbus.DATA[298];
                }
                YLFunc.CAR_COMM_CONTROL(81, value13 == 0 ? 1 : 0);
                break;
            case R.id.rzc_gl8_auto_driver_start_tip_check /* 2131433521 */:
                YLFunc.CAR_COMM_CONTROL(82, DataCanbus.DATA[281] == 0 ? 1 : 0);
                break;
            case R.id.xp_yl_radarswitch_check /* 2131433523 */:
                int value62 = DataCanbus.DATA[121];
                YLFunc.CAR_ON_RADAR_CTL(value62 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        setViewVisible(findViewById(R.id.all_func_btn_lauguage_set_view), 1);
        if (DataCanbus.DATA[1000] == 2359321) {
            setViewVisible(findViewById(R.id.xp_yl_radarswitch_view), 0);
            setViewVisible(findViewById(R.id.xp_yl_warn_volm_view), 0);
        }
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
            setViewVisible(findViewById(R.id.xp_yl_radarswitch_view), 0);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    @Override // com.syu.canbus.BaseActivity
    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
            DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        }
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        if (this.bRzc_Gl8) {
            DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[298].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 364 || DataCanbus.DATA[1000] == 65900 || DataCanbus.DATA[1000] == 131436) {
            DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        }
        if (this.bRzc_Gl8) {
            DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[298].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParkingAble() {
        int enable = DataCanbus.DATA[74];
        if (enable == 0) {
            findViewById(R.id.xp_yl_btn_Look_for_lightsParking_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_btn_Look_for_lightsParking_view).setVisibility(0);
        }
    }

    protected void updateAutoDriverStartTip() {
        int enable = DataCanbus.DATA[281];
        ((CheckedTextView) findViewById(R.id.rzc_gl8_auto_driver_start_tip_check)).setChecked(enable != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelayAble() {
        int enable = DataCanbus.DATA[75];
        if (enable == 0) {
            findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_light_Lasuo_headlight_delay_view).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdefeatDoorAutoLockAble() {
        int enable = DataCanbus.DATA[76];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_Prevent_automatic_door_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_Prevent_automatic_door_latch_view).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLockAble() {
        int enable = DataCanbus.DATA[78];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_Automatic_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_Automatic_latch_view).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlockAble() {
        int enable = DataCanbus.DATA[77];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_automatic_transmission).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_automatic_transmission).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaterLockAble() {
        int enable = DataCanbus.DATA[79];
        if (enable == 0) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLightAble() {
        int enable = DataCanbus.DATA[81];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoorAble() {
        int enable = DataCanbus.DATA[80];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Remote_control_lock_door_Feedback).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockAble() {
        int enable = DataCanbus.DATA[82];
        if (enable == 0) {
            findViewById(R.id.xp_yl_Remote_control_Unlock).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_Remote_control_Unlock).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStartAble() {
        int enable = DataCanbus.DATA[67];
        if (enable == 0) {
            findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[7];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Look_for_lightsParking_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[8];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[9];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Prevent_automatic_door_latch_check)).setChecked(switchOn != 0);
        if (this.bRzc_Gl8) {
            if (switchOn == 0) {
                findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(0);
            } else if (switchOn == 1) {
                findViewById(R.id.xp_yl_lock_Delay_latch_view).setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[10];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Automatic_latch_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[11];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.xp_yl_lock_automatic_transmission_Tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[12];
        ((CheckedTextView) findViewById(R.id.xp_yl_btn_Delay_latch_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[13];
        ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_light_Feedback_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[14];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[15];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(false);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.xp_yl_Remote_control_Unlock_check)).setChecked(true);
            ((TextView) findViewById(R.id.xp_yl_Remote_control_Unlock_tv)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[16];
        ((CheckedTextView) findViewById(R.id.xp_yl_comfort_rear_wiper_auto_start_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadarSwitch() {
        int switchOn = DataCanbus.DATA[121];
        ((CheckedTextView) findViewById(R.id.xp_yl_radarswitch_check)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnVolumSet() {
        int switchOn = DataCanbus.DATA[34];
        ((TextView) findViewById(R.id.xp_yl_warn_volm_tv)).setText(new StringBuilder().append(switchOn).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRampAssist() {
        int switchOn = DataCanbus.DATA[124];
        if (this.bRzc_Gl8) {
            switchOn = DataCanbus.DATA[298];
        }
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.xp_yl_lane_assist_tv)).setText(R.string.xp_yl_lane_assist_str1);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.xp_yl_lane_assist_tv)).setText(R.string.xp_yl_lane_assist_str2);
        }
    }
}
