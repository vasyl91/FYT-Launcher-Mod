package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class UIRZCBiaozhiWarn {
    private static UIRZCBiaozhiWarn mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIRZCBiaozhiWarn getInstance() {
        if (mInstance == null) {
            mInstance = new UIRZCBiaozhiWarn();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null) {
            WarnUtils.showWindow();
            WarnUtils.postDimiss(5000);
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
            case 205:
                if (((value >> 0) & 3) == 1) {
                    this.mTextWarn.setText(R.string.bz408_warning_61);
                } else if (((value >> 0) & 3) == 2) {
                    this.mTextWarn.setText(R.string.bz408_warning_62);
                }
                if (((value >> 2) & 3) == 1) {
                    this.mTextWarn.setText("自动雨刮启用");
                } else if (((value >> 2) & 3) == 2) {
                    this.mTextWarn.setText("自动雨刮停用");
                }
                if (((value >> 4) & 3) == 1) {
                    this.mTextWarn.setText("大灯自动点亮启用");
                } else if (((value >> 4) & 3) == 2) {
                    this.mTextWarn.setText("大灯自动点亮停用");
                }
                if (((value >> 6) & 3) == 1) {
                    this.mTextWarn.setText("车门自锁启用");
                    break;
                } else if (((value >> 6) & 3) == 2) {
                    this.mTextWarn.setText("车门自锁停用");
                    break;
                }
            case 206:
                if (((value >> 0) & 3) == 1) {
                    this.mTextWarn.setText("儿童安全装置启用");
                } else if (((value >> 0) & 3) == 2) {
                    this.mTextWarn.setText("儿童安全装置停用");
                }
                if (((value >> 2) & 3) == 1) {
                    this.mTextWarn.setText("ESP系统启用");
                } else if (((value >> 2) & 3) == 2) {
                    this.mTextWarn.setText("ESP系统停用");
                }
                if (((value >> 4) & 7) == 1) {
                    this.mTextWarn.setText("驱动防滑系统：正常模式");
                    break;
                } else if (((value >> 4) & 7) == 2) {
                    this.mTextWarn.setText("驱动防滑系统：泥地模式");
                    break;
                } else if (((value >> 4) & 7) == 3) {
                    this.mTextWarn.setText("驱动防滑系统：雪地模式");
                    break;
                } else if (((value >> 4) & 7) == 4) {
                    this.mTextWarn.setText("驱动防滑系统：沙地模式");
                    break;
                }
            case 207:
                if (((value >> 0) & 3) == 1) {
                    this.mTextWarn.setText("发动机启停功能启用");
                } else if (((value >> 0) & 3) == 2) {
                    this.mTextWarn.setText("发动机启停功能停用");
                }
                if (((value >> 2) & 3) == 1) {
                    this.mTextWarn.setText("牵引控制开启");
                    break;
                } else if (((value >> 2) & 3) == 2) {
                    this.mTextWarn.setText("牵引控制关闭");
                    break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
