package com.syu.carinfo.xincheng.infiniti;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class Xincheng_Nissan_TuleNewCarinfoAct extends Activity {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_bmw_dashboard_car_null;
            switch (updateCode) {
                case 0:
                    int value = DataCanbus.DATA[0];
                    ImageView imageView = (ImageView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.image_car_door_engine);
                    Resources resources = Xincheng_Nissan_TuleNewCarinfoAct.this.getResources();
                    if (value == 1) {
                        i = R.drawable.ic_tule_dashboard_car_door_front;
                    }
                    imageView.setImageDrawable(resources.getDrawable(i));
                    break;
                case 1:
                    int value2 = DataCanbus.DATA[1];
                    ImageView imageView2 = (ImageView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.image_car_door_fl);
                    Resources resources2 = Xincheng_Nissan_TuleNewCarinfoAct.this.getResources();
                    if (value2 == 1) {
                        i = R.drawable.ic_tule_dashboard_car_door_fl;
                    }
                    imageView2.setImageDrawable(resources2.getDrawable(i));
                    break;
                case 2:
                    int value3 = DataCanbus.DATA[2];
                    ImageView imageView3 = (ImageView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.image_car_door_fr);
                    Resources resources3 = Xincheng_Nissan_TuleNewCarinfoAct.this.getResources();
                    if (value3 == 1) {
                        i = R.drawable.ic_tule_dashboard_car_door_fr;
                    }
                    imageView3.setImageDrawable(resources3.getDrawable(i));
                    break;
                case 3:
                    int value4 = DataCanbus.DATA[3];
                    ImageView imageView4 = (ImageView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.image_car_door_rl);
                    Resources resources4 = Xincheng_Nissan_TuleNewCarinfoAct.this.getResources();
                    if (value4 == 1) {
                        i = R.drawable.ic_tule_dashboard_car_door_rl;
                    }
                    imageView4.setImageDrawable(resources4.getDrawable(i));
                    break;
                case 4:
                    int value5 = DataCanbus.DATA[4];
                    ImageView imageView5 = (ImageView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.image_car_door_rr);
                    Resources resources5 = Xincheng_Nissan_TuleNewCarinfoAct.this.getResources();
                    if (value5 == 1) {
                        i = R.drawable.ic_tule_dashboard_car_door_rr;
                    }
                    imageView5.setImageDrawable(resources5.getDrawable(i));
                    break;
                case 5:
                    int value6 = DataCanbus.DATA[5];
                    ImageView imageView6 = (ImageView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.image_car_door_rear);
                    Resources resources6 = Xincheng_Nissan_TuleNewCarinfoAct.this.getResources();
                    if (value6 == 1) {
                        i = R.drawable.ic_tule_dashboard_car_door_rear;
                    }
                    imageView6.setImageDrawable(resources6.getDrawable(i));
                    break;
                case 105:
                    int value7 = DataCanbus.DATA[105];
                    ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value7) + " km");
                    break;
                case 161:
                    Xincheng_Nissan_TuleNewCarinfoAct.this.updateSpeed();
                    break;
                case 162:
                    int value8 = DataCanbus.DATA[162];
                    ((Xincheng_Nissan_TuleViewEngineSpeed) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed((value8 * 280) / 8000);
                    break;
                case 163:
                    int value9 = DataCanbus.DATA[163];
                    if (value9 == 1) {
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_ON);
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-65536);
                        break;
                    } else {
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-1);
                        break;
                    }
                case 164:
                    int value10 = DataCanbus.DATA[164];
                    if (value10 == 1) {
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_seat_belt_tied);
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-1);
                        break;
                    } else {
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_seat_belt_not_tied);
                        ((TextView) Xincheng_Nissan_TuleNewCarinfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-65536);
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
        //setContentView(R.layout.layout_xincheng_nissan_tule_dashboard);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(0, new int[]{1, 1}, null, null);
        DoorHelper.disableDoorWindowLocal(true);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[4];
        iArr[0] = 1;
        remoteModuleProxy.cmd(0, iArr, null, null);
        DoorHelper.disableDoorWindowLocal(false);
        mIsFront = false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateSpeed() {
        int speed = DataCanbus.DATA[161];
        ((Xincheng_Nissan_TuleViewSpeed) findViewById(R.id.infoView_speed)).setSpeed(speed);
    }
}
