package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class UIWCXiandaiSeat {
    private static UIWCXiandaiSeat mInstance;
    Context context;
    private View mLayoutImage;
    private View sWarnContent;

    public static UIWCXiandaiSeat getInstance() {
        if (mInstance == null) {
            mInstance = new UIWCXiandaiSeat();
        }
        return mInstance;
    }

    public void showWindowTip(int updateCode, int value) {
        WarnUtils.getWindow();
        initTip(updateCode, value);
        if (this.sWarnContent != null) {
            if ((DataCanbus.DATA[36] != 0 || DataCanbus.DATA[37] != 0) && DataCanbus.DATA[41] != 0) {
                WarnUtils.showWindow();
                WarnUtils.postDimiss(5000);
            }
        }
    }

    private void initTip(int updateCode, int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0443_wc_xiandai_seat, (ViewGroup) null, false);
            this.mLayoutImage = (ImageView) this.sWarnContent.findViewById(R.id.iv_ax5_warn);
        }
        switch (updateCode) {
            case 36:
                switch (value) {
                    case 1:
                        this.mLayoutImage.setBackgroundResource(R.drawable.shengda_seat_info1);
                        break;
                    case 2:
                        this.mLayoutImage.setBackgroundResource(R.drawable.shengda_seat_info2);
                        break;
                    case 3:
                        this.mLayoutImage.setBackgroundResource(R.drawable.shengda_seat_info3);
                        break;
                    case 4:
                        this.mLayoutImage.setBackgroundResource(R.drawable.shengda_seat_info4);
                        break;
                }
            case 37:
                switch (value) {
                    case 1:
                        this.mLayoutImage.setBackgroundResource(R.drawable.shengda_seat_info5);
                        break;
                    case 2:
                        this.mLayoutImage.setBackgroundResource(R.drawable.shengda_seat_info6);
                        break;
                }
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}