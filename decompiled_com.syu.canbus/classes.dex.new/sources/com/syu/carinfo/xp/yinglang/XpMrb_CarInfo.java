package com.syu.carinfo.xp.yinglang;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class XpMrb_CarInfo extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.XpMrb_CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode] & 255;
            switch (updateCode) {
                case 187:
                    XpMrb_CarInfo.this.uRF(value);
                    break;
                case 188:
                    XpMrb_CarInfo.this.uLF(value);
                    break;
                case 189:
                    XpMrb_CarInfo.this.uRR(value);
                    break;
                case 190:
                    XpMrb_CarInfo.this.uLR(value);
                    break;
                case 191:
                    XpMrb_CarInfo.this.uAngel(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_359_carinfo);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    private void setT(TextView v, boolean on) {
        if (v != null) {
            v.setText(on ? "Open" : "Close");
        }
    }

    private void setVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 8);
        }
    }

    protected void uAngel(int val) {
        int angle = (val * 3) / 2;
        if (((ImageView) findViewById(R.id.layout_view6)) != null) {
            ((ImageView) findViewById(R.id.layout_view6)).setRotation(angle);
        }
    }

    protected void uLR(int val) {
        setT((TextView) findViewById(R.id.tv_text3), val == 1);
        setVisible((ImageView) findViewById(R.id.layout_view2), val == 1);
    }

    protected void uRR(int val) {
        setT((TextView) findViewById(R.id.tv_text5), val == 1);
        setVisible((ImageView) findViewById(R.id.layout_view5), val == 1);
    }

    protected void uLF(int val) {
        setT((TextView) findViewById(R.id.tv_text4), val == 1);
        setVisible((ImageView) findViewById(R.id.layout_view3), val == 1);
    }

    protected void uRF(int val) {
        setT((TextView) findViewById(R.id.tv_text2), val == 1);
        setVisible((ImageView) findViewById(R.id.layout_view4), val == 1);
    }
}
