package com.syu.carinfo.zhtd.bmw;

import android.content.Intent;
import android.os.Bundle;
import android.SystemProperties;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZH2PilotcarCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int touchnum = 0;
    Runnable mCalTime = new Runnable() { 
        @Override
        public void run() {
            ZH2PilotcarCarinfoAct.this.touchnum++;
            if (ZH2PilotcarCarinfoAct.this.touchnum >= 5) {
                ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.ic_pilotcar_normal_p);
            }
            HandlerUI.getInstance().removeCallbacks(ZH2PilotcarCarinfoAct.this.mCalTime);
            HandlerUI.getInstance().postDelayed(ZH2PilotcarCarinfoAct.this.mCalTime, 1000L);
        }
    };
    int mileunit = 0;
    int errorcode = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view21)).setBackgroundResource(R.drawable.ic_pilotcar_gear_n);
                    if (((value >> 2) & 1) == 1) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view21)).setBackgroundResource(R.drawable.ic_pilotcar_gear_d);
                    } else if (((value >> 1) & 1) == 1) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view21)).setBackgroundResource(R.drawable.ic_pilotcar_gear_r);
                    }
                    if (((value >> 3) & 1) == 1) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode_p);
                    } else {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode);
                    }
                    if (((value >> 0) & 1) == 1) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view13)).setBackgroundResource(R.drawable.ic_pilotcar_park_p);
                        break;
                    } else {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view13)).setBackgroundResource(R.drawable.ic_pilotcar_park);
                        break;
                    }
                case 100:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view11)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_service_p : R.drawable.ic_pilotcar_service);
                    break;
                case 101:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view12)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_hydraulicwarn_p : R.drawable.ic_pilotcar_hydraulicwarn);
                    break;
                case 102:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view18)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_belt_p : R.drawable.ic_pilotcar_belt);
                    break;
                case 103:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view14)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_frontfogs_p : R.drawable.ic_pilotcar_frontfogs);
                    break;
                case 104:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view7)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_short_light_p : R.drawable.ic_pilotcar_short_light);
                    break;
                case 105:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view5)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_far_light_p : R.drawable.ic_pilotcar_far_light);
                    break;
                case 106:
                    if (value == 0) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                        break;
                    } else {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view2)).setBackgroundResource(R.drawable.ic_pilotcar_rightlight);
                        break;
                    }
                case 107:
                    if (value == 0) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_dashboard_car_null);
                        break;
                    } else {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view1)).setBackgroundResource(R.drawable.ic_pilotcar_leftlight);
                        break;
                    }
                case 108:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view6)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_park_light_p : R.drawable.ic_pilotcar_park_light);
                    break;
                case 109:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view8)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_frontfogs_light_p : R.drawable.ic_pilotcar_frontfogs_light);
                    break;
                case 110:
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view4)).setBackgroundResource(value == 1 ? R.drawable.ic_pilotcar_rearfogs_light_p : R.drawable.ic_pilotcar_rearfogs_light);
                    break;
                case 111:
                    if (value == 16777215) {
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text1)).setText("--- MI");
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText("--- TRIP");
                        break;
                    } else if (ZH2PilotcarCarinfoAct.this.mileunit == 1) {
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 16) + " MI");
                        if (value > DataCanbus.DATA[126]) {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf((value - DataCanbus.DATA[126]) / 16) + " TRIP");
                            break;
                        } else {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText("0 TRIP");
                            break;
                        }
                    } else {
                        if (value > DataCanbus.DATA[126]) {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf((value - DataCanbus.DATA[126]) / 10) + " KM");
                        } else {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText("0 TRIP");
                        }
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + " KM");
                        break;
                    }
                case 112:
                    if ((32768 & value) != 0) {
                        value = 65536 - value;
                        if (ZH2PilotcarCarinfoAct.this.mileunit == 1) {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf((value * 10) / 256)).toString());
                        } else {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value / 16)).toString());
                        }
                    } else if (ZH2PilotcarCarinfoAct.this.mileunit == 1) {
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf((value * 10) / 256)).toString());
                    } else {
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value / 16)).toString());
                    }
                    if (value > 80) {
                        ZH2PilotcarCarinfoAct.this.mUpdatermCalTime(false);
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.ic_pilotcar_normal);
                        break;
                    } else if (value == 0 && ZH2PilotcarCarinfoAct.this.errorcode == 0) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.ic_pilotcar_normal_p);
                        break;
                    }
                case 114:
                    ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + (value % 10));
                    ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-1);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view15)).setBackgroundResource(R.drawable.ic_pilotcar_battery);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view20)).setBackgroundResource(R.drawable.ic_pilotcar_charge);
                    if (value <= 29) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view22)).setBackgroundResource(R.drawable.ic_pilotcar_soc1);
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view15)).setBackgroundResource(R.drawable.ic_pilotcar_battery_p);
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view20)).setBackgroundResource(R.drawable.ic_pilotcar_charge_p);
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                        break;
                    } else if (value <= 49) {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view22)).setBackgroundResource(R.drawable.ic_pilotcar_soc2);
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-256);
                        break;
                    } else {
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view22)).setBackgroundResource(R.drawable.ic_pilotcar_soc3);
                        break;
                    }
                case 115:
                    ZH2PilotcarCarinfoAct.this.errorcode = value;
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view19)).setBackgroundResource(R.drawable.ic_pilotcar_water);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view17)).setBackgroundResource(R.drawable.ic_pilotcar_evwarn);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view9)).setBackgroundResource(R.drawable.ic_pilotcar_fault);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view16)).setBackgroundResource(R.drawable.ic_pilotcar_engine);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view23)).setBackgroundResource(R.drawable.ic_pilotcar_rbs_n);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view25)).setBackgroundResource(R.drawable.ic_pilotcar_footbrake_n);
                    ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode);
                    ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setText("");
                    switch (value) {
                        case 15:
                        case 16:
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view17)).setBackgroundResource(R.drawable.ic_pilotcar_evwarn_p);
                            break;
                        case 17:
                        case 23:
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setText("Limited Power");
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-256);
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode_p);
                            break;
                        case 22:
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view17)).setBackgroundResource(R.drawable.ic_pilotcar_evwarn_p);
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setText("Limited Power");
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-256);
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode_p);
                            break;
                        case 24:
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setText("RBS Deactivated");
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-256);
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view23)).setBackgroundResource(R.drawable.ic_pilotcar_rbs_p);
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view25)).setBackgroundResource(R.drawable.ic_pilotcar_footbrake_p);
                            break;
                        case 28:
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view19)).setBackgroundResource(R.drawable.ic_pilotcar_water_p);
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setText("Limited Power");
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-256);
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view10)).setBackgroundResource(R.drawable.ic_pilotcar_slowmode_p);
                            break;
                        case 29:
                            ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view19)).setBackgroundResource(R.drawable.ic_pilotcar_water_p);
                            break;
                    }
                    if (value != 0) {
                        ZH2PilotcarCarinfoAct.this.mUpdatermCalTime(false);
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view9)).setBackgroundResource(R.drawable.ic_pilotcar_fault_p);
                        ((ImageView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.layout_view16)).setBackgroundResource(R.drawable.ic_pilotcar_engine_p);
                        break;
                    } else {
                        ZH2PilotcarCarinfoAct.this.mUpdatermCalTime(true);
                        break;
                    }
                case 119:
                    if ((32768 & value) != 0) {
                        int value2 = (65536 - value) / 10;
                        if (value2 > 600) {
                            value2 = 600;
                        }
                        ((ProgressBar) ZH2PilotcarCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(300);
                        ((ProgressBar) ZH2PilotcarCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(value2);
                    } else {
                        int value3 = value / 10;
                        if (value3 > 300) {
                            value3 = 300;
                        }
                        ((ProgressBar) ZH2PilotcarCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(300 - value3);
                        ((ProgressBar) ZH2PilotcarCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(0);
                    }
                    ((ProgressBar) ZH2PilotcarCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                    ((ProgressBar) ZH2PilotcarCarinfoAct.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                    break;
                case 126:
                    if (DataCanbus.DATA[111] > value) {
                        int value4 = DataCanbus.DATA[111] - value;
                        if (ZH2PilotcarCarinfoAct.this.mileunit == 1) {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value4 / 16) + " TRIP");
                            break;
                        } else {
                            ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value4 / 10) + " TRIP");
                            break;
                        }
                    } else {
                        ((TextView) ZH2PilotcarCarinfoAct.this.findViewById(R.id.tv_text5)).setText("0 TRIP");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_0454_zh_pilotcar_dashboard);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ZH2PilotcarUnitSetAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                break;
        }
    }

    
    public void mUpdatermCalTime(boolean on) {
        if (on) {
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
            HandlerUI.getInstance().postDelayed(this.mCalTime, 1000L);
            this.touchnum = 0;
        } else {
            ((ImageView) findViewById(R.id.layout_view3)).setBackgroundResource(R.drawable.ic_pilotcar_normal);
            HandlerUI.getInstance().removeCallbacks(this.mCalTime);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mileunit = SystemProperties.getInt("persist.fyt.mileunit", 0);
        if (this.mileunit == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText("mph");
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[112] / 16)).toString());
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(DataCanbus.DATA[111] / 16) + " MI");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText("km/h");
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[112] / 10)).toString());
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(DataCanbus.DATA[111] / 10) + " KM");
        }
        addNotify();
        Intent i = new Intent("android.fyt.action.360HIDE");
        i.setPackage("com.fyt.screenbutton");
        LauncherApplication.getInstance().startService(i);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent i = new Intent("android.fyt.action.360SHOW");
        i.setPackage("com.fyt.screenbutton");
        LauncherApplication.getInstance().startService(i);
        removeNotify();
        mIsFront = false;
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
