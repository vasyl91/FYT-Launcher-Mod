package com.syu.carinfo.zx6606;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ZX6606HondaNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value;
            int value2 = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 149:
                    int value3 = value2 / 100;
                    if (value3 > 240) {
                        value3 = 240;
                    }
                    ((InfoZX6606ViewSpeed) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.infoview_speed)).setSpeed(value3);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value3).toString());
                    break;
                case 224:
                    int flag = 0;
                    if ((32768 & value2) != 0) {
                        flag = 1;
                        value2 = 65536 - value2;
                    }
                    int value4 = (value2 * 32) / 540;
                    if (value4 > 32) {
                        value4 = 32;
                    }
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value4).toString());
                    if (flag == 1) {
                        value = 32 - value4;
                    } else {
                        value = value4 + 32;
                    }
                    ((InfoZX6606ViewSteer) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.infoview_steer)).setSpeed(value);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-1);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-1);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-1);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text1)).setTextSize(18.0f);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text2)).setTextSize(18.0f);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text3)).setTextSize(18.0f);
                    if (value == 32) {
                        ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-65536);
                        ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text2)).setTextSize(24.0f);
                        break;
                    } else if (value > 32) {
                        ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-65536);
                        ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text3)).setTextSize(24.0f);
                        break;
                    } else if (value < 32) {
                        ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-65536);
                        ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text1)).setTextSize(24.0f);
                        break;
                    }
                case 225:
                case 226:
                    int min = DataCanbus.DATA[226];
                    int hour = DataCanbus.DATA[225];
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
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
                            str = String.valueOf(str) + ZX6606HondaNewCarinfoAct.this.getResources().getString(R.string.str_week7);
                            break;
                        case 1:
                            str = String.valueOf(str) + ZX6606HondaNewCarinfoAct.this.getResources().getString(R.string.str_week1);
                            break;
                        case 2:
                            str = String.valueOf(str) + ZX6606HondaNewCarinfoAct.this.getResources().getString(R.string.str_week2);
                            break;
                        case 3:
                            str = String.valueOf(str) + ZX6606HondaNewCarinfoAct.this.getResources().getString(R.string.str_week3);
                            break;
                        case 4:
                            str = String.valueOf(str) + ZX6606HondaNewCarinfoAct.this.getResources().getString(R.string.str_week4);
                            break;
                        case 5:
                            str = String.valueOf(str) + ZX6606HondaNewCarinfoAct.this.getResources().getString(R.string.str_week5);
                            break;
                        case 6:
                            str = String.valueOf(str) + ZX6606HondaNewCarinfoAct.this.getResources().getString(R.string.str_week6);
                            break;
                    }
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text8)).setText(str);
                    break;
                case 231:
                    switch (value2) {
                        case 1:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_d));
                            break;
                        case 2:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_n));
                            break;
                        case 3:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_r));
                            break;
                        case 4:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_p));
                            break;
                        case 5:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_1));
                            break;
                        case 6:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_2));
                            break;
                        case 7:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_3));
                            break;
                        case 8:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_4));
                            break;
                        case 9:
                            ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view2)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_zx6606_dashboard_5));
                            break;
                    }
                case 233:
                    ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view3)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(value2 == 1 ? R.drawable.ic_zx6606_dashboard_lock_p : R.drawable.ic_zx6606_dashboard_lock));
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text10)).setText(value2 == 1 ? R.string.str_locked : R.string.str_unlocked);
                    break;
                case 326:
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value2 / 10).toString());
                    break;
                case 327:
                    ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view1)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(value2 == 1 ? R.drawable.ic_zx6606_dashboard_handbrake_p : R.drawable.ic_zx6606_dashboard_handbrake));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_zx6606_honda_dashboard);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[326].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[327].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[326].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[327].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
    }
}
