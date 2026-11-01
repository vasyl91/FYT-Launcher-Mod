package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WCSuzukielcCarInfo extends BaseActivity implements View.OnClickListener {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                case 126:
                    int on = DataCanbus.DATA[125];
                    int lev = DataCanbus.DATA[126];
                    if (on == 1) {
                        switch (lev) {
                            case 1:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_suzuki_elec_lleft_1);
                                break;
                            case 2:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_suzuki_elec_lleft_2);
                                break;
                            case 3:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_suzuki_elec_lleft_3);
                                break;
                            case 4:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_suzuki_elec_lleft_4);
                                break;
                            default:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setVisibility(8);
                                break;
                        }
                    } else {
                        WCSuzukielcCarInfo.this.findViewById(R.id.layout_view1).setVisibility(8);
                        break;
                    }
                case 127:
                case 128:
                    int on2 = DataCanbus.DATA[127];
                    int lev2 = DataCanbus.DATA[128];
                    if (on2 == 1) {
                        switch (lev2) {
                            case 1:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mright_1);
                                break;
                            case 2:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mright_2);
                                break;
                            case 3:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mright_3);
                                break;
                            case 4:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mright_4);
                                break;
                            default:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                                break;
                        }
                    } else if (on2 == 2) {
                        switch (lev2) {
                            case 1:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mleft_1);
                                break;
                            case 2:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mleft_2);
                                break;
                            case 3:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mleft_3);
                                break;
                            case 4:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_suzuki_elec_mleft_4);
                                break;
                            default:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                                break;
                        }
                    } else {
                        WCSuzukielcCarInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                        break;
                    }
                case 129:
                case 130:
                    int on3 = DataCanbus.DATA[129];
                    int lev3 = DataCanbus.DATA[130];
                    if (on3 == 1) {
                        switch (lev3) {
                            case 1:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rright_1);
                                break;
                            case 2:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rright_2);
                                break;
                            case 3:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rright_3);
                                break;
                            case 4:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rright_4);
                                break;
                            default:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(8);
                                break;
                        }
                    } else if (on3 == 2) {
                        switch (lev3) {
                            case 1:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rleft_1);
                                break;
                            case 2:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rleft_2);
                                break;
                            case 3:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rleft_3);
                                break;
                            case 4:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(0);
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_suzuki_elec_rleft_4);
                                break;
                            default:
                                WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(8);
                                break;
                        }
                    } else {
                        WCSuzukielcCarInfo.this.findViewById(R.id.layout_view3).setVisibility(8);
                        break;
                    }
                case 131:
                    if (value == 1) {
                        WCSuzukielcCarInfo.this.findViewById(R.id.layout_view4).setVisibility(0);
                        break;
                    } else {
                        WCSuzukielcCarInfo.this.findViewById(R.id.layout_view4).setVisibility(8);
                        break;
                    }
                case 132:
                    if (value != 0 && (value = (value / 20) + 1) > 5) {
                        value = 5;
                    }
                    switch (value) {
                        case 1:
                            WCSuzukielcCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_suzuki_elec_lev1);
                            break;
                        case 2:
                            WCSuzukielcCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_suzuki_elec_lev2);
                            break;
                        case 3:
                            WCSuzukielcCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_suzuki_elec_lev3);
                            break;
                        case 4:
                            WCSuzukielcCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_suzuki_elec_lev4);
                            break;
                        case 5:
                            WCSuzukielcCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_suzuki_elec_lev5);
                            break;
                        default:
                            WCSuzukielcCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_suzuki_elec_lev0);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0443_wc_suzuki_elec_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
    }
}
