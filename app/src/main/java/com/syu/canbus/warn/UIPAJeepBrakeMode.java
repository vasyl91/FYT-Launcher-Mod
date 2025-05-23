package com.syu.canbus.warn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class UIPAJeepBrakeMode {
    private static UIPAJeepBrakeMode mInstance;
    Context context;
    private View sWarnContent;

    public static UIPAJeepBrakeMode getInstance() {
        if (mInstance == null) {
            mInstance = new UIPAJeepBrakeMode();
        }
        return mInstance;
    }

    public void showWindowTip(int value) {
        WarnUtils.getWindow();
        initTip(value);
        WarnUtils.showWindow();
    }

    public void Hideindow() {
        PopupWindow window = WarnUtils.getWindow();
        window.dismiss();
    }

    private void initTip(int value) {
        if (this.sWarnContent == null) {
            this.context = LauncherApplication.getInstance();
            this.sWarnContent = LayoutInflater.from(this.context).inflate(R.layout.layout_0374_pa_jeep_brakemode_window, null, false);
            this.sWarnContent.findViewById(R.id.btn_plus1).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    UIPAJeepBrakeMode.this.Hideindow();
                }
            });
            this.sWarnContent.findViewById(R.id.btn_plus2).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    if (DataCanbus.DATA[370] == 7) {
                        DataCanbus.PROXY.cmd(0, new int[]{190, 1}, null, null);
                    }
                    UIPAJeepBrakeMode.this.Hideindow();
                }
            });
        }
        switch (value) {
            case 1:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("Service Mode is not available. While vehicle is in motion");
                break;
            case 2:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("Service Mode is not available. When brake pedal is pressed");
                break;
            case 3:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("Service Mode is not available. Release Park Brake");
                break;
            case 4:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("Service Mode is not available.Vehicle must be in Park or Neutral");
                break;
            case 5:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("To exit Service Mode, vehicle must not be in motion");
                break;
            case 6:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("Press brake pedal and activate park brake switch to exit service mode");
                break;
            case 7:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("Park Brake retracted .To reset,Press brake pedal and activate Park Brake switch");
                break;
            case 8:
                ((TextView) this.sWarnContent.findViewById(R.id.tv_text1)).setText("Park Brake reset ,Brake Service exit complete");
                break;
        }
        WarnUtils.getWindow().setContentView(this.sWarnContent);
    }
}
