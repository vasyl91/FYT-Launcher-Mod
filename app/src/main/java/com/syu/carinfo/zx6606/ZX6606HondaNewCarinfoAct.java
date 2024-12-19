package com.syu.carinfo.zx6606;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ZX6606HondaNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zx6606.ZX6606HondaNewCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value;
            int value2 = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 180:
                    int flag = 0;
                    if ((32768 & value2) != 0) {
                        flag = 1;
                        value2 = 65536 - value2;
                    }
                    int value3 = (value2 * 32) / 540;
                    if (value3 > 32) {
                        value3 = 32;
                    }
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value3).toString());
                    if (flag == 1) {
                        value = 32 - value3;
                    } else {
                        value = value3 + 32;
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
                case 181:
                case 182:
                    int min = DataCanbus.DATA[182];
                    int hour = DataCanbus.DATA[181];
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(hour / 10) + (hour % 10) + ":" + (min / 10) + (min % 10));
                    break;
                case 183:
                case 184:
                case 185:
                    int month = DataCanbus.DATA[183] + 1;
                    int monthDay = DataCanbus.DATA[184];
                    int weekDay = DataCanbus.DATA[185];
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
                case 187:
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
                case 189:
                    ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view3)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(value2 == 1 ? R.drawable.ic_zx6606_dashboard_lock_p : R.drawable.ic_zx6606_dashboard_lock));
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text10)).setText(value2 == 1 ? R.string.str_locked : R.string.str_unlocked);
                    break;
                case ConstRzcAddData.U_CAR_CUR_SPEED /* 510 */:
                    int value4 = value2 / 100;
                    if (value4 > 240) {
                        value4 = 240;
                    }
                    ((InfoZX6606ViewSpeed) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.infoview_speed)).setSpeed(value4);
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value4).toString());
                    break;
                case ConstRzcAddData.U_CAR_DRIVENABLE_MILEAGE /* 513 */:
                    ((TextView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value2 / 10).toString());
                    break;
                case ConstRzcAddData.U_CAR_HANDBRAKE /* 519 */:
                    ((ImageView) ZX6606HondaNewCarinfoAct.this.findViewById(R.id.layout_view1)).setImageDrawable(ZX6606HondaNewCarinfoAct.this.getResources().getDrawable(value2 == 1 ? R.drawable.ic_zx6606_dashboard_handbrake_p : R.drawable.ic_zx6606_dashboard_handbrake));
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.layout_zx6606_honda_dashboard);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[510].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[513].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[519].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[510].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[513].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[519].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
    }
}
