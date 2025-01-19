package com.syu.carinfo.rzc.jingyix5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityJingYiX5 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ActivityJingYiX5.this.updateHeadLightDelayed(value);
                    break;
                case 99:
                    ActivityJingYiX5.this.updateSavingTime(value);
                    break;
                case 100:
                    ActivityJingYiX5.this.updateSpeedLock(value);
                    break;
                case 101:
                    ActivityJingYiX5.this.updateAutoRelock(value);
                    break;
                case 108:
                    ActivityJingYiX5.this.updateRemoteLockCycle(value);
                    break;
                case 109:
                    ActivityJingYiX5.this.updateRemoteLockWindow(value);
                    break;
                case 110:
                    ActivityJingYiX5.this.updateRearviewAuto(value);
                    break;
                case 117:
                    ((CheckedTextView) ActivityJingYiX5.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
                case 139:
                    if (((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                            default:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text5)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                        }
                    }
                    break;
                case 140:
                    if (((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text6)).setText(R.string.klc_Parking_with_trailer_ON);
                                break;
                            default:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text6)).setText(R.string.klc_Parking_with_trailer_Off);
                                break;
                        }
                    }
                    break;
                case 141:
                    if (((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text7)).setText("ACC");
                                break;
                            case 2:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text7)).setText("ON");
                                break;
                            case 3:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text7)).setText("Start");
                                break;
                            default:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text7)).setText("Lock");
                                break;
                        }
                    }
                    break;
                case 144:
                    if (((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text8)).setText("Cranking");
                                break;
                            case 2:
                            case 4:
                            case 5:
                            case 6:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text8)).setText("Reserved");
                                break;
                            case 3:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text8)).setText("Eninge running");
                                break;
                            case 7:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text8)).setText("Fault detected");
                                break;
                            default:
                                ((TextView) ActivityJingYiX5.this.findViewById(R.id.tv_text8)).setText("Eninge Stop");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_227_rzc_jingyi_x5);
        initUi();
        setListener();
    }

    private void initUi() {
        if (DataCanbus.DATA[1000] == 327907) {
            setViewVisible(findViewById(R.id.layout_view1), true);
        } else {
            setViewVisible(findViewById(R.id.layout_view1), false);
        }
    }

    private void setListener() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[108] - 1;
                if (value < 0) {
                    value = 0;
                }
                setCarInfoCmd(4, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[108] + 1;
                if (value2 > 1) {
                    value2 = 1;
                }
                setCarInfoCmd(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[109] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCarInfoCmd(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[109] + 1;
                if (value4 > 1) {
                    value4 = 1;
                }
                setCarInfoCmd(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[98] - 1;
                if (value5 < 0) {
                    value5 = 0;
                }
                setCarInfoCmd(0, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[98] + 1;
                if (value6 > 3) {
                    value6 = 3;
                }
                setCarInfoCmd(0, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[99] - 1;
                if (value7 < 0) {
                    value7 = 0;
                }
                setCarInfoCmd(1, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[99] + 1;
                if (value8 > 2) {
                    value8 = 2;
                }
                setCarInfoCmd(1, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value9 = DataCanbus.DATA[110];
                setCarInfoCmd(6, value9 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value10 = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value10 != 0 ? 0 : 1;
                remoteModuleProxy.cmd(3, iArr, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value11 = DataCanbus.DATA[101];
                setCarInfoCmd(3, value11 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value12 = DataCanbus.DATA[100];
                setCarInfoCmd(2, value12 != 0 ? 0 : 1);
                break;
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
    }

    private void setCarInfoCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    protected void updateRearviewAuto(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    protected void updateAutoRelock(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    protected void updateSpeedLock(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    protected void updateRemoteLockWindow(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_long_press);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_short_press);
                    break;
            }
        }
    }

    protected void updateRemoteLockCycle(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                    break;
            }
        }
    }

    protected void updateSavingTime(int value) {
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_227_savingtime_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_227_savingtime_2);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_227_savingtime_0);
                    break;
            }
        }
    }

    protected void updateHeadLightDelayed(int value) {
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_227_headlight_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_227_headlight_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_227_headlight_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text3)).setText(R.string.crv_source_null);
                    break;
            }
        }
    }
}
