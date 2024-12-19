package com.syu.carinfo.accord9.xp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XPAccord9BackCarActi extends BaseActivity {
    public static XPAccord9BackCarActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.accord9.xp.XPAccord9BackCarActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 37:
                    XPAccord9BackCarActi.this.mUpdaterCameraType();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_accord9_xp_backcar);
        init();
        mInstance = this;
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.xp_accord9_camera_standard)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9BackCarActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(FinalCanbus.C_CAMERA_MODE, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_camera_wideangle)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9BackCarActi.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(FinalCanbus.C_CAMERA_MODE, new int[1], null, null);
            }
        });
        ((Button) findViewById(R.id.xp_accord9_camera_depression)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.accord9.xp.XPAccord9BackCarActi.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DataCanbus.PROXY.cmd(FinalCanbus.C_CAMERA_MODE, new int[]{2}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCameraType() {
        int value = DataCanbus.DATA[37];
        if (((Button) findViewById(R.id.xp_accord9_camera_standard)) != null && ((Button) findViewById(R.id.xp_accord9_camera_wideangle)) != null && ((Button) findViewById(R.id.xp_accord9_camera_depression)) != null) {
            switch (value) {
                case 0:
                    setBk((Button) findViewById(R.id.xp_accord9_camera_wideangle), R.drawable.ic_accord9_wideangle_p);
                    setBk((Button) findViewById(R.id.xp_accord9_camera_standard), R.drawable.ic_accord9_standard_n);
                    setBk((Button) findViewById(R.id.xp_accord9_camera_depression), R.drawable.ic_accord9_depression_n);
                    break;
                case 1:
                default:
                    setBk((Button) findViewById(R.id.xp_accord9_camera_wideangle), R.drawable.ic_accord9_wideangle_n);
                    setBk((Button) findViewById(R.id.xp_accord9_camera_standard), R.drawable.ic_accord9_standard_p);
                    setBk((Button) findViewById(R.id.xp_accord9_camera_depression), R.drawable.ic_accord9_depression_n);
                    break;
                case 2:
                    setBk((Button) findViewById(R.id.xp_accord9_camera_wideangle), R.drawable.ic_accord9_wideangle_n);
                    setBk((Button) findViewById(R.id.xp_accord9_camera_standard), R.drawable.ic_accord9_standard_n);
                    setBk((Button) findViewById(R.id.xp_accord9_camera_depression), R.drawable.ic_accord9_depression_p);
                    break;
            }
        }
    }

    private void setBk(Button btn, int id) {
        if (btn != null) {
            btn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(id), (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 || keyCode == 3) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
