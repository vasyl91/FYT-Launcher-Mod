package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class UIXCRongwei950 {
    private static UIXCRongwei950 mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIXCRongwei950 getInstance() {
        if (mInstance == null) {
            mInstance = new UIXCRongwei950();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        switch (updateCode) {
            case 60:
                if (this.sWarnContent != null) {
                    if (value == 1 || value == 2) {
                        WarnUtils.showWindow();
                        WarnUtils.postDimiss(5000);
                        break;
                    }
                }
                break;
            case 61:
                if (DataCanbus.DATA[60] == 1 || DataCanbus.DATA[60] == 2) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                    break;
                }
            case 62:
                if (DataCanbus.DATA[60] == 1 || DataCanbus.DATA[60] == 2) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                    break;
                }
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 79:
                if (value != 0) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                    break;
                }
        }
    }

    private void initTip(int value, int updateCode) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = (TextView) this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 60:
                if (value == 1) {
                    switch (DataCanbus.DATA[61]) {
                        case 0:
                            this.mTextWarn.setText("驾驶模式 : ECO");
                            break;
                        case 1:
                            this.mTextWarn.setText("驾驶模式 : Normal");
                            break;
                    }
                } else if (value == 2) {
                    switch (DataCanbus.DATA[62]) {
                        case 0:
                            this.mTextWarn.setText("能力回收 : Light");
                            break;
                        case 1:
                            this.mTextWarn.setText("能力回收: Moderate");
                            break;
                        case 2:
                            this.mTextWarn.setText("能力回收: Heavy");
                            break;
                    }
                }
                break;
            case 61:
                if (DataCanbus.DATA[60] == 1) {
                    switch (value) {
                        case 0:
                            this.mTextWarn.setText("驾驶模式 : ECO");
                            break;
                        case 1:
                            this.mTextWarn.setText("驾驶模式 : Normal");
                            break;
                    }
                }
                break;
            case 62:
                if (DataCanbus.DATA[60] == 2) {
                    switch (value) {
                        case 0:
                            this.mTextWarn.setText("能力回收 : Light");
                            break;
                        case 1:
                            this.mTextWarn.setText("能力回收: Moderate");
                            break;
                        case 2:
                            this.mTextWarn.setText("能力回收: Heavy");
                            break;
                    }
                }
                break;
            case 63:
                if (value != 0) {
                    this.mTextWarn.setText("混动系统故障");
                    break;
                }
            case 64:
                if (value != 0) {
                    this.mTextWarn.setText("动力蓄电池故障");
                    break;
                }
            case 65:
                if (value != 0) {
                    this.mTextWarn.setText("动力蓄电池切断");
                    break;
                }
            case 66:
                if (value != 0) {
                    this.mTextWarn.setText("电机过温");
                    break;
                }
            case 67:
                if (value != 0) {
                    this.mTextWarn.setText("蓄电池电流过低，请启动车辆");
                    break;
                }
            case 68:
                if (value != 0) {
                    this.mTextWarn.setText("EDU冷却液过温");
                    break;
                }
            case 69:
                if (value != 0) {
                    this.mTextWarn.setText("功率受限,限速行驶");
                    break;
                }
            case 70:
                if (value != 0) {
                    this.mTextWarn.setText("请充电 保持高压电池均衡");
                    break;
                }
            case 79:
                switch (value) {
                    case 1:
                        this.mTextWarn.setText("默认模式");
                        break;
                    case 2:
                        this.mTextWarn.setText("怠速充电模式");
                        break;
                    case 3:
                        this.mTextWarn.setText("行车充电模式");
                        break;
                    case 4:
                        this.mTextWarn.setText("纯电动驱动模式");
                        break;
                    case 5:
                        this.mTextWarn.setText("发动机驱动模式");
                        break;
                    case 6:
                        this.mTextWarn.setText("串联驱动模式");
                        break;
                    case 7:
                        this.mTextWarn.setText("并联驱动模式");
                        break;
                    case 8:
                        this.mTextWarn.setText("能量回收模式");
                        break;
                    case 9:
                        this.mTextWarn.setText("外接充电模式");
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
