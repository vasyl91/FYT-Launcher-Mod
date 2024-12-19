package com.syu.carinfo.bnr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Bnr_255_FengShengax7_Allvideo extends BaseActivity {
    int camValue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.Bnr_255_FengShengax7_Allvideo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 22:
                    Bnr_255_FengShengax7_Allvideo.this.camValue = DataCanbus.DATA[22];
                    if (Bnr_255_FengShengax7_Allvideo.this.camValue == 0) {
                        ((TextView) Bnr_255_FengShengax7_Allvideo.this.findViewById(R.id.wc_turncam_show)).setText(R.string.rzc_c4l_close);
                        break;
                    } else if (Bnr_255_FengShengax7_Allvideo.this.camValue == 1) {
                        ((TextView) Bnr_255_FengShengax7_Allvideo.this.findViewById(R.id.wc_turncam_show)).setText(R.string.rzc_c4l_open);
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bnr_ax7_carset);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mClick = new View.OnClickListener() { // from class: com.syu.carinfo.bnr.Bnr_255_FengShengax7_Allvideo.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.wc_turncam_set_minus /* 2131430628 */:
                        if (Bnr_255_FengShengax7_Allvideo.this.camValue == 0) {
                            Bnr_255_FengShengax7_Allvideo.this.CarSetControl(1);
                            break;
                        } else {
                            Bnr_255_FengShengax7_Allvideo.this.CarSetControl(0);
                            break;
                        }
                    case R.id.wc_turncam_set_plus /* 2131430630 */:
                        if (Bnr_255_FengShengax7_Allvideo.this.camValue == 0) {
                            Bnr_255_FengShengax7_Allvideo.this.CarSetControl(1);
                            break;
                        } else {
                            Bnr_255_FengShengax7_Allvideo.this.CarSetControl(0);
                            break;
                        }
                }
            }
        };
        setClick((Button) findViewById(R.id.wc_turncam_set_minus));
        setClick((Button) findViewById(R.id.wc_turncam_set_plus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CarSetControl(int cmd1) {
        DataCanbus.PROXY.cmd(3, cmd1);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
    }
}
