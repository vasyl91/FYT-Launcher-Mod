package com.syu.carinfo.rzc.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0364_RZC_XP1_MaiRuiBao16;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcKlcOnstatWifiAct extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RzcKlcOnstatWifiAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 120:
                    RzcKlcOnstatWifiAct.this.updaterWifiName();
                    break;
                case 121:
                    RzcKlcOnstatWifiAct.this.updaterWifiPsWord();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_klc_onstar_wifi);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
        DataCanbus.PROXY.cmd(8, 65);
        DataCanbus.PROXY.cmd(8, 66);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWifiName() {
        String str = Callback_0364_RZC_XP1_MaiRuiBao16.WifiName;
        if (str != null) {
            ((TextView) findViewById(R.id.rzc_klc_wifi_point_tv)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWifiPsWord() {
        String str = Callback_0364_RZC_XP1_MaiRuiBao16.WifiPsword;
        if (str != null) {
            ((TextView) findViewById(R.id.rzc_klc_psworld_tv)).setText(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
