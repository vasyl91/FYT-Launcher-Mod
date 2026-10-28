package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class TDLandRoverNewECOCarinfoAct2 extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 181:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text2)).setText(value / 10 + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text2)).setText("---");
                        break;
                    }
                case 182:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text3)).setText(value / 10 + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text3)).setText("---");
                        break;
                    }
                case 183:
                    if (value >= 10 && value <= 50) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text4)).setText(value / 10 + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text4)).setText("---");
                        break;
                    }
                case 185:
                    if (value >= 0 && value <= 100) {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text1)).setText(value + "%");
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text1)).setText("---");
                        break;
                    }
                case 186:
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
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text5)).setText(value / 10 + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text5)).setText("---");
                        break;
                    }
                case 187:
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
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text6)).setText(value / 10 + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text6)).setText("---");
                        break;
                    }
                case 188:
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
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text7)).setText(value / 10 + "." + (value % 10));
                        break;
                    } else {
                        ((TextView) TDLandRoverNewECOCarinfoAct2.this.findViewById(R.id.tv_text7)).setText("---");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_td_landrover_neweco_info2);
    }

    @Override
    public void onClick(View v) {
        v.getId();
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

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(0, new int[]{102}, null, null);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }
}
