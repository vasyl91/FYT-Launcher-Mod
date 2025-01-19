package com.syu.carinfo.xp.ziyouguang;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.canbus.DataCanbus;
import java.lang.reflect.Field;

public class PAFordDoornumWindow extends BaseActivity implements View.OnClickListener {
    private View mRootView;
    private PopupWindow mWindow;
    int pagenum = 0;

    public PAFordDoornumWindow(PAFordDoornumSetAct act) {
        initView();
        initPop();
    }

    private void initPop() {
        if (this.mWindow == null) {
            this.mWindow = new PopupWindow(LauncherApplication.getInstance());
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
        this.mRootView = View.inflate(LauncherApplication.getInstance(), R.layout.layout_0374_pa_ford_doornum_ok, null);
        ((Button) this.mRootView.findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus4)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427457 */:
                if (this.pagenum == 2) {
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[6];
                    iArr[0] = 13;
                    remoteModuleProxy.cmd(22, iArr, null, null);
                }
                hideWindow();
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[6];
                iArr2[0] = 15;
                remoteModuleProxy2.cmd(22, iArr2, null, null);
                hideWindow();
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[6];
                iArr3[0] = 2;
                remoteModuleProxy3.cmd(22, iArr3, null, null);
                hideWindow();
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                hideWindow();
                break;
        }
    }

    public void showWindow(View Parent, int num) {
        this.pagenum = num;
        switch (num) {
            case 1:
                this.mRootView.findViewById(R.id.layout_view1).setVisibility(0);
                this.mRootView.findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Incorrect code entered. Please try again.");
                break;
            case 2:
                this.mRootView.findViewById(R.id.layout_view1).setVisibility(0);
                this.mRootView.findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("User door keypad codehas been added");
                break;
            case 3:
                this.mRootView.findViewById(R.id.layout_view1).setVisibility(0);
                this.mRootView.findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Door keypad code has been successfully erased");
                break;
            case 4:
                this.mRootView.findViewById(R.id.layout_view1).setVisibility(8);
                this.mRootView.findViewById(R.id.layout_view2).setVisibility(0);
                break;
            case 14:
                this.mRootView.findViewById(R.id.layout_view1).setVisibility(0);
                this.mRootView.findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Door keypad code not match.Try again.");
                break;
        }
        this.mWindow.showAtLocation(Parent, 48, 0, LauncherApplication.getScreenHeight());
    }

    public void hideWindow() {
        this.mWindow.dismiss();
    }
}
