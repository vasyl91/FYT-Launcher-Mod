package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class UIEi6Warn {
    private static UIEi6Warn mInstance;
    Context context;
    private View mLayoutImage;
    private TextView mTextWarn;
    private View sWarnContent;

    public static UIEi6Warn getInstance() {
        if (mInstance == null) {
            mInstance = new UIEi6Warn();
        }
        return mInstance;
    }

    public void showWindowTip(int value, int updateCode) {
        WarnUtils.getWindow();
        initTip(value, updateCode);
        if (this.sWarnContent != null) {
            boolean showflag = false;
            switch (updateCode) {
                case 176:
                    switch (value) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            showflag = true;
                            break;
                    }
                case 178:
                    switch (value) {
                        case 1:
                        case 2:
                        case 3:
                            showflag = true;
                            break;
                    }
            }
            if (showflag) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(5000);
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
            case 176:
                switch (value) {
                    case 1:
                        this.mTextWarn.setText(R.string.driver_system_economics);
                        break;
                    case 2:
                        this.mTextWarn.setText(R.string.driver_system_standard);
                        break;
                    case 3:
                        this.mTextWarn.setText(R.string.driver_system_sports);
                        break;
                    case 4:
                        this.mTextWarn.setText(R.string.str_252_sound_selection5);
                        break;
                }
            case 178:
                switch (value) {
                    case 1:
                        this.mTextWarn.setText("能力回收等级：轻");
                        break;
                    case 2:
                        this.mTextWarn.setText("能力回收等级：中");
                        break;
                    case 3:
                        this.mTextWarn.setText("能力回收等级：强");
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
