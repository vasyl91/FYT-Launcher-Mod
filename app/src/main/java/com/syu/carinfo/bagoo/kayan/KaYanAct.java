package com.syu.carinfo.bagoo.kayan;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class KaYanAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bagoo.kayan.KaYanAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    KaYanAct.this.updateroilJuli();
                    break;
                case 2:
                    KaYanAct.this.updaterhour();
                    break;
                case 3:
                    KaYanAct.this.updaterminute();
                    break;
                case 4:
                    KaYanAct.this.updatersecond();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_kayan_main);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateroilJuli() {
        int oilJulivalue = DataCanbus.DATA[1];
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(oilJulivalue) + "KM");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterhour() {
        int hourvalue = DataCanbus.DATA[2];
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(hourvalue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterminute() {
        int minutevalue = DataCanbus.DATA[3];
        ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(minutevalue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatersecond() {
        int secondvalue = DataCanbus.DATA[4];
        ((TextView) findViewById(R.id.tv_text6)).setText(new StringBuilder().append(secondvalue).toString());
    }
}
