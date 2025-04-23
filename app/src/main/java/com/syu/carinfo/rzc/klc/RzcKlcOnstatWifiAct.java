package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0364_RZC_XP1_MaiRuiBao16;
import com.syu.module.canbus.DataCanbus;

public class RzcKlcOnstatWifiAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 187:
                    RzcKlcOnstatWifiAct.this.updaterWifiName();
                    break;
                case 188:
                    RzcKlcOnstatWifiAct.this.updaterWifiPsWord();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_rzc_klc_onstar_wifi);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
        DataCanbus.PROXY.cmd(8, 65);
        DataCanbus.PROXY.cmd(8, 66);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    
    public void updaterWifiName() {
        String str = Callback_0364_RZC_XP1_MaiRuiBao16.WifiName;
        if (str != null) {
            ((TextView) findViewById(R.id.rzc_klc_wifi_point_tv)).setText(str);
        }
    }

    
    public void updaterWifiPsWord() {
        String str = Callback_0364_RZC_XP1_MaiRuiBao16.WifiPsword;
        if (str != null) {
            ((TextView) findViewById(R.id.rzc_klc_psworld_tv)).setText(str);
        }
    }

    @Override
    public void onClick(View v) {
    }
}
