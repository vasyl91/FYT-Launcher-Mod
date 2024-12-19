package com.syu.carinfo.dasauto;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0452_TZY_UAZ_Patriot;
import com.syu.module.canbus.DataCanbus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FaultCodeWindow extends BaseActivity implements View.OnClickListener {
    private int mFaultCount;
    private PopupWindow mWindow;
    private TextView[] mErrorCodes = new TextView[8];
    private List<Integer> mCodeSets = new ArrayList();
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.FaultCodeWindow.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 2:
                    FaultCodeWindow.this.updateErrorCode(value);
                    break;
                case 3:
                    FaultCodeWindow.this.refreshData(FaultCodeWindow.this.mFaultCount);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pop_fault_code);
        initView();
    }

    private void initView() {
        this.mErrorCodes[0] = (TextView) findViewById(R.id.pop_code1);
        this.mErrorCodes[1] = (TextView) findViewById(R.id.pop_code2);
        this.mErrorCodes[2] = (TextView) findViewById(R.id.pop_code3);
        this.mErrorCodes[3] = (TextView) findViewById(R.id.pop_code4);
        this.mErrorCodes[4] = (TextView) findViewById(R.id.pop_code5);
        this.mErrorCodes[5] = (TextView) findViewById(R.id.pop_code6);
        this.mErrorCodes[6] = (TextView) findViewById(R.id.pop_code7);
        this.mErrorCodes[7] = (TextView) findViewById(R.id.pop_code8);
        ((ImageView) findViewById(R.id.pop_close)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.pop_remove)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateErrorCode(int value) {
        this.mFaultCount = value;
    }

    public void showWindow(View Parent) {
        this.mWindow.showAtLocation(Parent, 48, 0, LauncherApplication.getScreenHeight());
    }

    public void hideWindow() {
        this.mWindow.dismiss();
    }

    public void refreshData(int value) {
        this.mCodeSets.clear();
        if (Callback_0452_TZY_UAZ_Patriot.CHANNEL_ERROR_CODES[0] != 0) {
            for (int i = 0; i < value; i++) {
                this.mCodeSets.add(Integer.valueOf(Callback_0452_TZY_UAZ_Patriot.CHANNEL_ERROR_CODES[i]));
            }
            setText();
        }
    }

    private void setText() {
        if (this.mCodeSets != null && !this.mCodeSets.isEmpty()) {
            int mPageCount = 8;
            if (this.mCodeSets.size() < this.mErrorCodes.length) {
                mPageCount = this.mCodeSets.size();
            }
            for (int i = 0; i < mPageCount; i++) {
                int dtc = this.mCodeSets.get(i).intValue();
                String prefix = letterFormat((dtc >> 12) & 15);
                this.mErrorCodes[i].setText(String.valueOf(prefix) + Integer.toHexString(dtc & 4095).toUpperCase());
                gradientAnim(this.mErrorCodes[i], 0.0f, 1.0f);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pop_close /* 2131427922 */:
                hideWindow();
                break;
            case R.id.pop_remove /* 2131432252 */:
                for (int i = 0; i < this.mErrorCodes.length; i++) {
                    if (this.mErrorCodes[i].getAlpha() == 1.0f) {
                        gradientAnim(this.mErrorCodes[i], 1.0f, 0.0f);
                    }
                }
                DataCanbus.PROXY.cmd(0, 0, 0);
                break;
        }
    }

    private void gradientAnim(View view, float fromAlpha, float toAlpha) {
        ObjectAnimator.ofFloat(view, "alpha", fromAlpha, toAlpha).setDuration(600L).start();
    }

    private String letterFormat(int digit) {
        switch (digit) {
            case 0:
                return "P0";
            case 1:
                return "P1";
            case 2:
                return "P2";
            case 3:
                return "P3";
            case 4:
                return "C0";
            case 5:
                return "C1";
            case 6:
                return "C2";
            case 7:
                return "C3";
            case 8:
                return "B0";
            case 9:
                return "B1";
            case 10:
                return "B2";
            case 11:
                return "B3";
            case 12:
                return "U0";
            case 13:
                return "U1";
            case 14:
                return "U2";
            case 15:
                return "U3";
            default:
                return "";
        }
    }
}
