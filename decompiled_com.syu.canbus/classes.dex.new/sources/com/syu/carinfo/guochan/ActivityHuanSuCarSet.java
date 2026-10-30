package com.syu.carinfo.guochan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ActivityHuanSuCarSet extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.guochan.ActivityHuanSuCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 115:
                    ActivityHuanSuCarSet.this.updateUpLightAutoDelay(value);
                    break;
                case 116:
                    ActivityHuanSuCarSet.this.updateOutRearview(value);
                    break;
                case 117:
                    ActivityHuanSuCarSet.this.updateAwayHome(value);
                    break;
                case 118:
                    ActivityHuanSuCarSet.this.updateBackHome(value);
                    break;
                case 119:
                    ActivityHuanSuCarSet.this.updateFoldRearview(value);
                    break;
                case 120:
                    ActivityHuanSuCarSet.this.updateAutoLock15(value);
                    break;
                case 121:
                    ActivityHuanSuCarSet.this.updateSecondaryUnlock(value);
                    break;
                case 122:
                    ActivityHuanSuCarSet.this.updateMagneticRelay(value);
                    break;
                case 123:
                    ActivityHuanSuCarSet.this.updateDriverSeat(value);
                    break;
                case 124:
                    ActivityHuanSuCarSet.this.updateTurnAutoFrontFogLight(value);
                    break;
                case 125:
                    ActivityHuanSuCarSet.this.updateStopWiper(value);
                    break;
                case 126:
                    ActivityHuanSuCarSet.this.updateBeamFlash(value);
                    break;
                case 127:
                    ActivityHuanSuCarSet.this.updateRemoteWinDown(value);
                    break;
                case 128:
                    ActivityHuanSuCarSet.this.updateRemoteWinUp(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_419_huansu_s6_car_set);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mCanbusNotify, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = (DataCanbus.DATA[117] & 255) - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(5, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = (DataCanbus.DATA[117] & 255) + 1;
                if (value2 > 6) {
                    value2 = 6;
                }
                setCmd(5, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = (DataCanbus.DATA[118] & 255) - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCmd(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = (DataCanbus.DATA[118] & 255) + 1;
                if (value4 > 6) {
                    value4 = 6;
                }
                setCmd(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = (DataCanbus.DATA[115] & 255) - 1;
                if (value5 < 0) {
                    value5 = 0;
                }
                setCmd(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = (DataCanbus.DATA[115] & 255) + 1;
                if (value6 > 3) {
                    value6 = 3;
                }
                setCmd(7, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCmd(2, (DataCanbus.DATA[120] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCmd(10, (DataCanbus.DATA[126] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCmd(9, (DataCanbus.DATA[127] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCmd(1, (DataCanbus.DATA[121] & 255) == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCmd(11, (DataCanbus.DATA[125] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCmd(8, (DataCanbus.DATA[128] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCmd(6, (DataCanbus.DATA[116] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCmd(3, (DataCanbus.DATA[119] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCmd(14, (DataCanbus.DATA[122] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCmd(13, (DataCanbus.DATA[123] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCmd(12, (DataCanbus.DATA[124] & 255) != 0 ? 0 : 1);
                break;
        }
    }

    private void setCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, cmd, value);
    }

    protected void updateRemoteWinUp(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view8).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view8).setVisibility(8);
        }
    }

    protected void updateRemoteWinDown(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view7).setVisibility(8);
        }
    }

    protected void updateBeamFlash(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view6).setVisibility(8);
        }
    }

    protected void updateStopWiper(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view5).setVisibility(8);
        }
    }

    protected void updateTurnAutoFrontFogLight(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view14).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view14).setVisibility(8);
        }
    }

    protected void updateDriverSeat(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view13).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view13).setVisibility(8);
        }
    }

    protected void updateMagneticRelay(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view12).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked((value & 255) == 1);
            if ((value & 255) == 0) {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_mode_factory);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_mode_user);
                return;
            }
        }
        findViewById(R.id.layout_view12).setVisibility(8);
    }

    protected void updateSecondaryUnlock(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked((value & 255) == 1);
            if ((value & 255) == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                return;
            }
        }
        findViewById(R.id.layout_view4).setVisibility(8);
    }

    protected void updateAutoLock15(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
    }

    protected void updateFoldRearview(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view11).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view11).setVisibility(8);
        }
    }

    protected void updateBackHome(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText("10S");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText("20S");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText("30S");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text2)).setText("40S");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text2)).setText("50S");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text2)).setText("60S");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                    break;
            }
            return;
        }
        findViewById(R.id.layout_view2).setVisibility(8);
    }

    protected void updateAwayHome(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText("10S");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText("20S");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText("30S");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text1)).setText("40S");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text1)).setText("50S");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_text1)).setText("60S");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
                    break;
            }
            return;
        }
        findViewById(R.id.layout_view1).setVisibility(8);
    }

    protected void updateOutRearview(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view10).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked((value & 255) == 1);
        } else {
            findViewById(R.id.layout_view10).setVisibility(8);
        }
    }

    protected void updateUpLightAutoDelay(int value) {
        if (1 == 1) {
            findViewById(R.id.layout_view9).setVisibility(0);
            switch (value & 255) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("8S");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("15S");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText("30S");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text4)).setText("0S");
                    break;
            }
            return;
        }
        findViewById(R.id.layout_view9).setVisibility(8);
    }
}
