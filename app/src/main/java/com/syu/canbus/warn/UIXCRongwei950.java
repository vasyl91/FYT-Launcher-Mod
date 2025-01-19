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
            case 124:
                if (this.sWarnContent != null) {
                    if (value == 1 || value == 2) {
                        WarnUtils.showWindow();
                        WarnUtils.postDimiss(5000);
                        break;
                    }
                }
                break;
            case 125:
                if (DataCanbus.DATA[124] == 1 || DataCanbus.DATA[124] == 2) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                    break;
                }
            case 126:
                if (DataCanbus.DATA[124] == 1 || DataCanbus.DATA[124] == 2) {
                    WarnUtils.showWindow();
                    WarnUtils.postDimiss(5000);
                    break;
                }
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 143:
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
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_273_warn, null, false);
            this.mLayoutImage = this.sWarnContent.findViewById(R.id.iv_ax5_warn);
            this.mTextWarn = this.sWarnContent.findViewById(R.id.tv_ax5_text);
        }
        switch (updateCode) {
            case 124:
                if (value == 1) {
                    switch (DataCanbus.DATA[125]) {
                        case 0:
                            this.mTextWarn.setText("驾驶模式 : ECO");
                            break;
                        case 1:
                            this.mTextWarn.setText("驾驶模式 : Normal");
                            break;
                    }
                } else if (value == 2) {
                    switch (DataCanbus.DATA[126]) {
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
            case 125:
                if (DataCanbus.DATA[124] == 1) {
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
            case 126:
                if (DataCanbus.DATA[124] == 2) {
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
            case 127:
                if (value != 0) {
                    this.mTextWarn.setText("混动系统故障");
                    break;
                }
            case 128:
                if (value != 0) {
                    this.mTextWarn.setText("动力蓄电池故障");
                    break;
                }
            case 129:
                if (value != 0) {
                    this.mTextWarn.setText("动力蓄电池切断");
                    break;
                }
            case 130:
                if (value != 0) {
                    this.mTextWarn.setText("电机过温");
                    break;
                }
            case 131:
                if (value != 0) {
                    this.mTextWarn.setText("蓄电池电流过低，请启动车辆");
                    break;
                }
            case 132:
                if (value != 0) {
                    this.mTextWarn.setText("EDU冷却液过温");
                    break;
                }
            case 133:
                if (value != 0) {
                    this.mTextWarn.setText("功率受限,限速行驶");
                    break;
                }
            case 134:
                if (value != 0) {
                    this.mTextWarn.setText("请充电 保持高压电池均衡");
                    break;
                }
            case 143:
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
