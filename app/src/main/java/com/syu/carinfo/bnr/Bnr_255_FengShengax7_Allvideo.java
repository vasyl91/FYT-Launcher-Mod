package com.syu.carinfo.bnr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Bnr_255_FengShengax7_Allvideo extends BaseActivity {
    int camValue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    Bnr_255_FengShengax7_Allvideo.this.camValue = DataCanbus.DATA[102];
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_bnr_ax7_carset);
        init();
    }

    @Override
    public void init() {
        this.mClick = new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.wc_turncam_set_minus /* 2131430606 */:
                        if (Bnr_255_FengShengax7_Allvideo.this.camValue == 0) {
                            Bnr_255_FengShengax7_Allvideo.this.CarSetControl(1);
                            break;
                        } else {
                            Bnr_255_FengShengax7_Allvideo.this.CarSetControl(0);
                            break;
                        }
                    case R.id.wc_turncam_set_plus /* 2131430608 */:
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

    
    public void CarSetControl(int cmd1) {
        DataCanbus.PROXY.cmd(3, cmd1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }
}
