package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class RZC_GMChargeSet2InfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 226:
                    if (((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 227:
                    if (((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 228:
                    if (((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 229:
                    if (((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZC_GMChargeSet2InfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0061_rzc_gm_charge_setinf2);
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
        DataCanbus.PROXY.cmd(11, new int[]{80, 2}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[226].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[227].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[228].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[229].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[226].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[227].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[228].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[229].removeNotify(this.mNotifyCanbus);
    }
}
