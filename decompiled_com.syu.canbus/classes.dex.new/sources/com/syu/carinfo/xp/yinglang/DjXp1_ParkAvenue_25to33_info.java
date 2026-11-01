package com.syu.carinfo.xp.yinglang;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerRemove;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class DjXp1_ParkAvenue_25to33_info extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.yinglang.DjXp1_ParkAvenue_25to33_info.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 130:
                    DjXp1_ParkAvenue_25to33_info.this.mUpdateCarSpeed();
                    break;
                case 135:
                    DjXp1_ParkAvenue_25to33_info.this.mUpdateMachineSpeed();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0025_dj_parkavenue);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        bindViewOnClick(R.id.ctv_checkedtext1, new View.OnClickListener() { // from class: com.syu.carinfo.xp.yinglang.DjXp1_ParkAvenue_25to33_info.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(3, new int[]{98, 1}, null, null);
                HandlerRemove.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.xp.yinglang.DjXp1_ParkAvenue_25to33_info.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(3, new int[]{98, 0}, null, null);
                    }
                }, 100L);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCarSpeed() {
        int value = DataCanbus.DATA[130];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km/h");
        }
    }

    protected void mUpdateMachineSpeed() {
        int value = DataCanbus.DATA[135];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "rpm");
        }
    }
}
