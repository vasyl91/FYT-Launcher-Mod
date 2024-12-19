package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class TDLandRoverNewECOCarinfoAct2 extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.TDLandRoverNewECOCarinfoAct2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 169:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text2)).setText("---");
                        break;
                    }
                case 170:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text3)).setText("---");
                        break;
                    }
                case 171:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text4)).setText("---");
                        break;
                    }
                case 173:
                    if (value >= 0 && value <= 100) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text1)).setText("---");
                        break;
                    }
                case 174:
                    if (value >= 10 && value <= 14) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_front1));
                    } else if (value >= 15 && value <= 24) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_front2));
                    } else if (value >= 25 && value <= 34) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_front3));
                    } else if (value >= 35 && value <= 44) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_front4));
                    } else if (value >= 45 && value <= 50) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_front5));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image1)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                    }
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text5)).setText("---");
                        break;
                    }
                case 175:
                    if (value >= 10 && value <= 14) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_center1));
                    } else if (value >= 15 && value <= 24) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_center2));
                    } else if (value >= 25 && value <= 34) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_center3));
                    } else if (value >= 35 && value <= 44) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_center4));
                    } else if (value >= 45 && value <= 50) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_center5));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image2)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                    }
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text6)).setText("---");
                        break;
                    }
                case 176:
                    if (value >= 10 && value <= 14) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_rear1));
                    } else if (value >= 15 && value <= 24) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_rear2));
                    } else if (value >= 25 && value <= 34) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_rear3));
                    } else if (value >= 35 && value <= 44) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_rear4));
                    } else if (value >= 45 && value <= 50) {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_td_landrover_rear5));
                    } else {
                        ((ImageView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.id_image3)).setImageDrawable(TDLandRoverNewECOCarinfoAct2.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                    }
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text7)).setText("---");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_neweco_info2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{102}, null, null);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
    }
}
