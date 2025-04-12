package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZCLandRoverNewCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int bkNum = 0;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 119:
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_esp));
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_off));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_on));
                            break;
                    }
                case 120:
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                            break;
                    }
                case 121:
                case 122:
                    int yellow = DataCanbus.DATA[121];
                    int green = DataCanbus.DATA[122];
                    if (yellow == 1) {
                        ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_hdc_y));
                        break;
                    } else if (green == 1) {
                        ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_hdc));
                        break;
                    } else {
                        ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                        break;
                    }
                case 123:
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("ECO");
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0));
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Special program off");
                            break;
                        case 2:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Grass gravel snow");
                            break;
                        case 3:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Mud-ruts");
                            break;
                        case 4:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Sand");
                            break;
                    }
                case 124:
                    switch (value) {
                        case 0:
                            RZCLandRoverNewCarinfoAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_asr_n);
                            break;
                        case 1:
                            RZCLandRoverNewCarinfoAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_asr_p);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_lz_landrover_44info);
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.id_image10).setVisibility(8);
        findViewById(R.id.id_image11).setVisibility(8);
        findViewById(R.id.id_image12).setVisibility(8);
        findViewById(R.id.id_image13).setVisibility(8);
        findViewById(R.id.id_image14).setVisibility(8);
        findViewById(R.id.id_image15).setVisibility(8);
        findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_jaguar_drivemode_p);
        findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_sup);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427457 */:
                this.bkNum = 1;
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.id_image10).setVisibility(8);
                findViewById(R.id.id_image11).setVisibility(8);
                findViewById(R.id.id_image12).setVisibility(8);
                findViewById(R.id.id_image13).setVisibility(8);
                findViewById(R.id.id_image14).setVisibility(8);
                findViewById(R.id.id_image15).setVisibility(8);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_jaguar_drivemode_p);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value = DataCanbus.DATA[124];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(1, new int[2], null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(1, new int[]{0, 1}, null, null);
                    break;
                }
        }
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
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }
}
