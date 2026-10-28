package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class ZH2PilotcarChargeCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value;
            int value2 = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 119:
                    if ((32768 & value2) != 0) {
                        value2 = 65536 - value2;
                    }
                    ((TextView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value2 / 10) + "A");
                    break;
                case 121:
                    if (value2 >= 9950) {
                        value = 100;
                    } else {
                        value = value2 / 100;
                    }
                    ((TextView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + (value % 10));
                    ((TextView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-1);
                    ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view1).setVisibility(8);
                    ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                    ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view3).setVisibility(8);
                    if (value <= 29) {
                        ((ImageView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view4)).setBackgroundResource(R.drawable.ic_pilotcar_soc1);
                        ((TextView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-65536);
                        ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                        ((ProgressBar) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view1)).setProgress(value);
                        ((ProgressBar) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view1)).invalidate();
                        break;
                    } else if (value <= 49) {
                        ((ImageView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view4)).setBackgroundResource(R.drawable.ic_pilotcar_soc2);
                        ((TextView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-256);
                        ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                        ((ProgressBar) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view2)).setProgress(value);
                        ((ProgressBar) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view2)).invalidate();
                        break;
                    } else {
                        ((ImageView) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view4)).setBackgroundResource(R.drawable.ic_pilotcar_soc3);
                        ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                        ((ProgressBar) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view3)).setProgress(value);
                        ((ProgressBar) ZH2PilotcarChargeCarinfoAct.this.findViewById(R.id.layout_view3)).invalidate();
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
        //setContentView(R.layout.layout_0454_zh_pilotcar_charge_info);
    }

    @Override
    public void onClick(View v) {
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
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }
}
