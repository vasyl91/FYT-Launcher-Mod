package com.syu.carinfo.qiya.kx7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityWCXianDaiE_InfoAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    if (value == 65535) {
                        ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text2)).setText("--.- kW");
                        break;
                    } else {
                        ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kW");
                        break;
                    }
                case 124:
                case 125:
                    int unit = DataCanbus.DATA[125];
                    int data = DataCanbus.DATA[124];
                    if (value == 65535) {
                        ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText("--.-");
                        break;
                    } else {
                        switch (unit) {
                            case 2:
                                ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(data / 10) + "." + (data % 10) + " MPG(US)");
                                break;
                            case 3:
                                ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(data / 10) + "." + (data % 10) + " MPG(UK)");
                                break;
                            case 4:
                                ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(data / 10) + "." + (data % 10) + " km/L");
                                break;
                            default:
                                ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(data / 10) + "." + (data % 10) + " L/100km");
                                break;
                        }
                    }
                case 126:
                    switch (value) {
                        case 1:
                            ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("Idle Mode");
                            break;
                        case 2:
                            ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("Electric Mode");
                            break;
                        case 3:
                            ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("Hybrid Mode");
                            break;
                        case 4:
                            ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("Engine Mode");
                            break;
                        case 5:
                            ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("Charging");
                            break;
                        case 6:
                            ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("Engine Braking");
                            break;
                        default:
                            ((TextView) ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.tv_text3)).setText("");
                            break;
                    }
                case 127:
                    switch (value) {
                        case 1:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_wc_xiandai_ui0_1);
                            break;
                        case 2:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_wc_xiandai_ui0_2);
                            break;
                        default:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_wc_xiandai_ui0_0);
                            break;
                    }
                case 128:
                    switch (value) {
                        case 1:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_wc_xiandai_ui1_1);
                            break;
                        case 2:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_wc_xiandai_ui1_2);
                            break;
                        default:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_wc_xiandai_ui1_0);
                            break;
                    }
                case 129:
                    switch (value) {
                        case 1:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_wc_xiandai_ui3_1);
                            break;
                        case 2:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_wc_xiandai_ui4_2);
                            break;
                        case 3:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_wc_xiandai_ui4_1);
                            break;
                        default:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_wc_xiandai_ui3_0);
                            break;
                    }
                case 130:
                    switch (value) {
                        case 1:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_wc_xiandai_ui3_1);
                            break;
                        case 2:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_wc_xiandai_ui3_2);
                            break;
                        default:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_wc_xiandai_ui3_0);
                            break;
                    }
                case 131:
                    switch (value) {
                        case 1:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_1);
                            break;
                        case 2:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_2);
                            break;
                        case 3:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_3);
                            break;
                        case 4:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_4);
                            break;
                        case 5:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_5);
                            break;
                        case 6:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_6);
                            break;
                        case 7:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_7);
                            break;
                        case 8:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_8);
                            break;
                        default:
                            ActivityWCXianDaiE_InfoAct.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_wc_xiandai_evlev_0);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0444_wc_xiandai_e_info);
        findViewById(R.id.tv_text1).setOnClickListener(this);
        findViewById(R.id.tv_text2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_text1 /* 2131427456 */:
            case R.id.tv_text2 /* 2131427459 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ActivityWCXianDaiE45min_InfoAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
    }
}
