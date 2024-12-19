package com.syu.carinfo.rzc.biaozhi408;

import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_BZ408_Panel_Keys extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_217_keys);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        sendClick(R.id.pasbz408_btn_mode, 0, 64);
        sendClick(R.id.pasbz408_btn_up, 0, 4);
        sendClick(R.id.pasbz408_btn_dark, 0, 128);
        sendClick(R.id.pasbz408_btn_left, 0, 16);
        sendClick(R.id.pasbz408_btn_right, 0, 32);
        sendClick(R.id.pasbz408_btn_down, 0, 8);
        sendClick(R.id.pasbz408_btn_esc, 0, 2);
        sendClick(R.id.pasbz408_btn_menu, 0, 1);
        sendClick(R.id.pasbz408_btn_ok, 32, 0);
    }

    private void sendClick(int resid, final int cmd1, final int cmd2) {
        View v = findViewById(resid);
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ408_Panel_Keys.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v2) {
                    RZC_BZ408_Panel_Keys.this.sendCmd(cmd1, cmd2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCmd(int cmd1, int cmd2) {
        DataCanbus.PROXY.cmd(73, new int[]{cmd1, cmd2}, null, null);
    }
}
