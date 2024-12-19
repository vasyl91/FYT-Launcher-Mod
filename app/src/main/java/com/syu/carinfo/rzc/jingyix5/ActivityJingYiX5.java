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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityJingYiX5 extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jingyix5.ActivityJingYiX5.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    ActivityJingYiX5.this.updateHeadLightDelayed(value);
                    break;
                case 87:
                    ActivityJingYiX5.this.updateSavingTime(value);
                    break;
                case 88:
                    ActivityJingYiX5.this.updateSpeedLock(value);
                    break;
                case 89:
                    ActivityJingYiX5.this.updateAutoRelock(value);
                    break;
                case 96:
                    ActivityJingYiX5.this.updateRemoteLockCycle(value);
                    break;
                case 97:
                    ActivityJingYiX5.this.updateRemoteLockWindow(value);
                    break;
                case 98:
                    ActivityJingYiX5.this.updateRearviewAuto(value);
                    break;
                case 105:
                    ((CheckedTextView) ActivityJingYiX5.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                    break;
                case 127:
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
                case 128:
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
                case 129:
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
                case 132:
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_227_rzc_jingyi_x5);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[98];
                setCarInfoCmd(6, value != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[96] - 1;
                if (value2 < 0) {
                    value2 = 0;
                }
                setCarInfoCmd(4, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[96] + 1;
                if (value3 > 1) {
                    value3 = 1;
                }
                setCarInfoCmd(4, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[97] - 1;
                if (value4 < 0) {
                    value4 = 0;
                }
                setCarInfoCmd(5, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[97] + 1;
                if (value5 > 1) {
                    value5 = 1;
                }
                setCarInfoCmd(5, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[86] - 1;
                if (value6 < 0) {
                    value6 = 0;
                }
                setCarInfoCmd(0, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[86] + 1;
                if (value7 > 3) {
                    value7 = 3;
                }
                setCarInfoCmd(0, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[87] - 1;
                if (value8 < 0) {
                    value8 = 0;
                }
                setCarInfoCmd(1, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[87] + 1;
                if (value9 > 2) {
                    value9 = 2;
                }
                setCarInfoCmd(1, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value10 = DataCanbus.DATA[105];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[1];
                iArr[0] = value10 != 0 ? 0 : 1;
                remoteModuleProxy.cmd(3, iArr, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value11 = DataCanbus.DATA[89];
                setCarInfoCmd(3, value11 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value12 = DataCanbus.DATA[88];
                setCarInfoCmd(2, value12 != 0 ? 0 : 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        super.addNotify();
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        super.removeNotify();
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
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
