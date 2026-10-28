package com.syu.carinfo.honda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0298_XP1_2015SIYU_CRV;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CZHHondaNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 225:
                case 226:
                    int min = DataCanbus.DATA[226];
                    int hour = DataCanbus.DATA[225];
                    ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                    break;
                case 227:
                case 228:
                case 229:
                    int month = DataCanbus.DATA[227] + 1;
                    int monthDay = DataCanbus.DATA[228];
                    int weekDay = DataCanbus.DATA[229];
                    String str = String.valueOf(month / 10) + (month % 10) + "-" + (monthDay / 10) + (monthDay % 10) + "  ";
                    switch (weekDay) {
                        case 0:
                            str = String.valueOf(str) + CZHHondaNewCarinfoAct.this.getResources().getString(R.string.str_week7);
                            break;
                        case 1:
                            str = String.valueOf(str) + CZHHondaNewCarinfoAct.this.getResources().getString(R.string.str_week1);
                            break;
                        case 2:
                            str = String.valueOf(str) + CZHHondaNewCarinfoAct.this.getResources().getString(R.string.str_week2);
                            break;
                        case 3:
                            str = String.valueOf(str) + CZHHondaNewCarinfoAct.this.getResources().getString(R.string.str_week3);
                            break;
                        case 4:
                            str = String.valueOf(str) + CZHHondaNewCarinfoAct.this.getResources().getString(R.string.str_week4);
                            break;
                        case 5:
                            str = String.valueOf(str) + CZHHondaNewCarinfoAct.this.getResources().getString(R.string.str_week5);
                            break;
                        case 6:
                            str = String.valueOf(str) + CZHHondaNewCarinfoAct.this.getResources().getString(R.string.str_week6);
                            break;
                    }
                    ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text8)).setText(str);
                    break;
                case 328:
                    ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    break;
                case 329:
                    switch (value) {
                        case 0:
                            ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_p));
                            break;
                        case 1:
                            ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_r));
                            break;
                        case 2:
                            ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_n));
                            break;
                        case 3:
                            ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_d));
                            break;
                    }
                case 330:
                    ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view1)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_zx6606_dashboard_handbrake_p : R.drawable.ic_zx6606_dashboard_handbrake));
                    break;
                case 331:
                    if (DataCanbus.DATA[1000] == 5701930) {
                        ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view3)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(value == 0 ? R.drawable.ic_zx6606_dashboard_lock_p : R.drawable.ic_zx6606_dashboard_lock));
                        ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text10)).setText(value == 0 ? R.string.str_locked : R.string.str_unlocked);
                        break;
                    } else {
                        ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view3)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_zx6606_dashboard_lock_p : R.drawable.ic_zx6606_dashboard_lock));
                        ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text10)).setText(value == 1 ? R.string.str_locked : R.string.str_unlocked);
                        break;
                    }
                case 332:
                    ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view5)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_pilotcar_far_light_p : R.drawable.ic_pilotcar_far_light));
                    break;
                case 333:
                    ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view4)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_pilotcar_short_light_p : R.drawable.ic_pilotcar_short_light));
                    break;
                case 334:
                    ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view6)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_bmw_dashboard_car_belt_p : R.drawable.ic_bmw_dashboard_car_belt));
                    break;
                case 335:
                    ((ImageView) CZHHondaNewCarinfoAct.this.findViewById(R.id.layout_view7)).setImageDrawable(CZHHondaNewCarinfoAct.this.getResources().getDrawable(value == 1 ? R.drawable.ic_bmw_dashboard_car_belt_p : R.drawable.ic_bmw_dashboard_car_belt));
                    break;
                case 336:
                    if (value > 240) {
                        value = 240;
                    }
                    ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 337:
                    ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 338:
                    ((TextView) CZHHondaNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText(Callback_0298_XP1_2015SIYU_CRV.Caridstr);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_czh_honda_dashboard);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(97, new int[]{51, 6}, null, null);
        DataCanbus.PROXY.cmd(97, new int[]{51, 7}, null, null);
        addNotify();
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[337].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[336].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[328].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[330].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[329].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[331].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[332].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[333].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[334].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[335].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[338].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[337].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[336].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[328].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[330].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[329].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[331].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[332].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[333].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[334].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[335].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[338].removeNotify(this.mNotifyCanbus);
    }
}
