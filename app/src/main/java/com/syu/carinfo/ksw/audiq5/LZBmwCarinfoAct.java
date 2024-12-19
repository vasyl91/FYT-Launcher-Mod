package com.syu.carinfo.ksw.audiq5;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class LZBmwCarinfoAct extends Activity {
    public static LZBmwCarinfoAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ksw.audiq5.LZBmwCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_bmw_dashboard_car_null;
            switch (updateCode) {
                case 0:
                    int value = DataCanbus.DATA[0];
                    ImageView imageView = (ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_door_engine);
                    Resources resources = LZBmwCarinfoAct.this.getResources();
                    if (value == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_door_front;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 1:
                    int value2 = DataCanbus.DATA[1];
                    ImageView imageView2 = (ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_door_fl);
                    Resources resources2 = LZBmwCarinfoAct.this.getResources();
                    if (value2 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_door_fl;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
                    break;
                case 2:
                    int value3 = DataCanbus.DATA[2];
                    ImageView imageView3 = (ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_door_fr);
                    Resources resources3 = LZBmwCarinfoAct.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_door_fr;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i));
                    break;
                case 3:
                    int value4 = DataCanbus.DATA[3];
                    ImageView imageView4 = (ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_door_rl);
                    Resources resources4 = LZBmwCarinfoAct.this.getResources();
                    if (value4 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_door_rl;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 4:
                    int value5 = DataCanbus.DATA[4];
                    ImageView imageView5 = (ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_door_rr);
                    Resources resources5 = LZBmwCarinfoAct.this.getResources();
                    if (value5 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_door_rr;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 5:
                    int value6 = DataCanbus.DATA[5];
                    ImageView imageView6 = (ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_door_rear);
                    Resources resources6 = LZBmwCarinfoAct.this.getResources();
                    if (value6 == 1) {
                        i = R.drawable.ic_bmw_dashboard_car_door_back;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 12:
                    int value7 = DataCanbus.DATA[12];
                    if (value7 == 1) {
                        ((TextView) LZBmwCarinfoAct.this.findViewById(R.id.txt_car_handbrake_state)).setText(R.string.str_handbrake_pulled_up);
                    } else {
                        ((TextView) LZBmwCarinfoAct.this.findViewById(R.id.txt_car_handbrake_state)).setText(R.string.str_handbrake_pulled_down);
                    }
                    ((ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_handbrake)).setImageDrawable(LZBmwCarinfoAct.this.getResources().getDrawable(value7 == 1 ? R.drawable.ic_bmw_dashboard_car_handbrake_p : R.drawable.ic_bmw_dashboard_car_handbrake));
                    break;
                case 15:
                case 19:
                    LZBmwCarinfoAct.this.updateSpeed();
                    break;
                case 16:
                    int value8 = DataCanbus.DATA[16];
                    ((TextView) LZBmwCarinfoAct.this.findViewById(R.id.txt_car_engine_speed)).setText(String.valueOf(value8) + " rpm");
                    ((InfoView) LZBmwCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed(value8);
                    break;
                case 47:
                    int value9 = DataCanbus.DATA[47];
                    if (value9 == 1) {
                        ((TextView) LZBmwCarinfoAct.this.findViewById(R.id.txt_car_belt_state)).setText(R.string.str_seat_belt_tied);
                    } else {
                        ((TextView) LZBmwCarinfoAct.this.findViewById(R.id.txt_car_belt_state)).setText(R.string.str_seat_belt_not_tied);
                    }
                    ((ImageView) LZBmwCarinfoAct.this.findViewById(R.id.image_car_belt)).setImageDrawable(LZBmwCarinfoAct.this.getResources().getDrawable(value9 == 0 ? R.drawable.ic_bmw_dashboard_car_belt_p : R.drawable.ic_bmw_dashboard_car_belt));
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lz_bmw_dashboard);
        mInstance = this;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DoorHelper.disableDoorWindowLocal(true);
        mIsFront = true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DoorHelper.disableDoorWindowLocal(false);
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed() {
        int speed = DataCanbus.DATA[15];
        int unit = DataCanbus.DATA[19];
        switch (unit) {
            case 0:
                ((InfoView2) findViewById(R.id.infoView_speed)).setSpeed(speed);
                ((TextView) findViewById(R.id.txt_car_speed)).setText(String.valueOf(speed) + " km/h");
                break;
            case 1:
                int speed2 = speed / 16;
                ((InfoView2) findViewById(R.id.infoView_speed)).setSpeed(speed2);
                ((TextView) findViewById(R.id.txt_car_speed)).setText(String.valueOf(speed2) + " mile/h");
                break;
        }
    }
}
