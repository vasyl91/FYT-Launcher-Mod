package com.syu.carinfo.zhtd.bmw;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class DSOutModeShowWindow extends BaseActivity implements View.OnClickListener {
    private View mRootView;
    private PopupWindow mWindow;
    int pagenum = 0;

    public DSOutModeShowWindow(DaiSGolfSixPackControlAct act) {
        initView();
        initPop();
    }

    private void initPop() {
        if (this.mWindow == null) {
            this.mWindow = new PopupWindow(TheApp.getInstance());
            this.mWindow.setContentView(this.mRootView);
            this.mWindow.setAnimationStyle(R.style.contextMenuAnim);
            this.mWindow.setWidth(-1);
            this.mWindow.setHeight(-1);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mWindow.setOutsideTouchable(false);
            try {
                Field mLayoutInScreen = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                mLayoutInScreen.setAccessible(true);
                mLayoutInScreen.set(this.mWindow, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mRootView = View.inflate(TheApp.getInstance(), R.layout.layout_0456_ds_outmode_show, null);
        ((Button) this.mRootView.findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    public void showWindow(View Parent) {
        this.mWindow.showAtLocation(Parent, 48, 0, TheApp.getScreenHeight());
    }

    public void hideWindow() {
        this.mWindow.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427419 */:
                hideWindow();
                break;
        }
    }
}
