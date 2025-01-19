package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RZC_GMChargeSet1InfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 217:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                        break;
                    }
                case 218:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                        break;
                    }
                case 219:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                        break;
                    }
                case 220:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 221:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + "°");
                        break;
                    }
                case 222:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                        break;
                    }
                case 223:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 224:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 100) + "." + ((value % 100) / 10) + (value % 10) + "L");
                        break;
                    }
                case 225:
                    if (((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RZC_GMChargeSet1InfoAct.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_charge_setinf1);
        init();
    }

    @Override
    public void init() {
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(11, new int[]{80, 1}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[222].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[223].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[224].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[225].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[222].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[223].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[224].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[225].removeNotify(this.mNotifyCanbus);
    }
}
