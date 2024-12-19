package com.syu.carinfo.qirui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityWCAiRuiZe extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.qirui.ActivityWCAiRuiZe.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 59:
                    if (value == 1) {
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view5).setVisibility(0);
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view6).setVisibility(0);
                        break;
                    } else {
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view5).setVisibility(8);
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view6).setVisibility(8);
                        break;
                    }
                case 60:
                    if (((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                        break;
                    }
                case 61:
                    if (((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                                break;
                            case 2:
                                ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 62:
                    if (((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 73:
                    ActivityWCAiRuiZe.this.updateAutoLock(value);
                    break;
                case 74:
                    ActivityWCAiRuiZe.this.updateBiglightSleep(value);
                    break;
                case 75:
                    ActivityWCAiRuiZe.this.updateDayLight(value);
                    break;
                case 76:
                    ActivityWCAiRuiZe.this.updateSteeringAvm(value);
                    break;
                case 77:
                    ActivityWCAiRuiZe.this.updateSteeringAnim(value);
                    break;
                case 78:
                    ActivityWCAiRuiZe.this.updateVehicleGuides(value);
                    break;
                case 79:
                    ActivityWCAiRuiZe.this.updateSpeedAlarm(value);
                    break;
                case 80:
                    ActivityWCAiRuiZe.this.updateDashBoardBacklight(value);
                    break;
                case 87:
                    ActivityWCAiRuiZe.this.updateRemodeBack(value);
                    break;
                case 88:
                    ActivityWCAiRuiZe.this.updateAutoUnlock(value);
                    break;
                case 89:
                    ActivityWCAiRuiZe.this.updateAutoFoldRearview(value);
                    break;
                case 106:
                    ActivityWCAiRuiZe.this.updateBlidSide(value);
                    break;
                case 107:
                    ActivityWCAiRuiZe.this.updateRoadAway(value);
                    break;
                case 108:
                    ActivityWCAiRuiZe.this.updateFortificationPrompt(value);
                    break;
                case 109:
                    ActivityWCAiRuiZe.this.updateHomeLight(value);
                    break;
                case 110:
                    ActivityWCAiRuiZe.this.updateChangeRoad(value);
                    break;
                case 111:
                    ActivityWCAiRuiZe.this.updateEpsMode(value);
                    break;
                case 112:
                    ActivityWCAiRuiZe.this.updateWelcomeLight(value);
                    break;
                case 113:
                    if (((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 114:
                    if (((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_395_qirui_airuize);
        findViewById(R.id.layout_view7).setVisibility(8);
        setListener();
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
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 983435 || DataCanbus.DATA[1000] == 2097547) {
            findViewById(R.id.layout_view4).setVisibility(0);
        } else {
            findViewById(R.id.layout_view4).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 1966475) {
            findViewById(R.id.layout_view3).setVisibility(0);
        } else {
            findViewById(R.id.layout_view3).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 1966475 || DataCanbus.DATA[1000] == 1900939) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mCanbusNotify);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                setCarInfoCmd(19, (DataCanbus.DATA[113] & 255) != 0 ? 0 : 1);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value = DataCanbus.DATA[61] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfoCmd(2, value);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value2 = DataCanbus.DATA[61] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfoCmd(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value3 = DataCanbus.DATA[62] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCarInfoCmd(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value4 = DataCanbus.DATA[62] + 1;
                if (value4 > 30) {
                    value4 = 30;
                }
                setCarInfoCmd(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value5 = (DataCanbus.DATA[78] & 255) - 1;
                if (value5 < 0) {
                    value5 = 0;
                }
                setCarInfoCmd(11, value5);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value6 = (DataCanbus.DATA[78] & 255) + 1;
                if (value6 > 2) {
                    value6 = 2;
                }
                setCarInfoCmd(11, value6);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value7 = (DataCanbus.DATA[79] & 255) - 1;
                if (value7 < 0) {
                    value7 = 0;
                }
                setCarInfoCmd(7, value7);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value8 = (DataCanbus.DATA[79] & 255) + 1;
                if (value8 > 21) {
                    value8 = 21;
                }
                setCarInfoCmd(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value9 = (DataCanbus.DATA[80] & 255) - 1;
                if (value9 < 1) {
                    value9 = 1;
                }
                setCarInfoCmd(8, value9);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value10 = (DataCanbus.DATA[80] & 255) + 1;
                if (value10 > 10) {
                    value10 = 10;
                }
                setCarInfoCmd(8, value10);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value11 = (DataCanbus.DATA[108] & 255) - 1;
                if (value11 < 0) {
                    value11 = 0;
                }
                setCarInfoCmd(17, value11);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value12 = (DataCanbus.DATA[108] & 255) + 1;
                if (value12 > 2) {
                    value12 = 2;
                }
                setCarInfoCmd(17, value12);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value13 = (DataCanbus.DATA[109] & 255) - 1;
                if (value13 < 0) {
                    value13 = 0;
                }
                setCarInfoCmd(21, value13);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value14 = (DataCanbus.DATA[109] & 255) + 1;
                if (value14 > 2) {
                    value14 = 2;
                }
                setCarInfoCmd(21, value14);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value15 = (DataCanbus.DATA[110] & 255) - 1;
                if (value15 < 0) {
                    value15 = 0;
                }
                setCarInfoCmd(22, value15);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value16 = (DataCanbus.DATA[110] & 255) + 1;
                if (value16 > 3) {
                    value16 = 3;
                }
                setCarInfoCmd(22, value16);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value17 = (DataCanbus.DATA[111] & 255) - 1;
                if (value17 < 0) {
                    value17 = 0;
                }
                setCarInfoCmd(23, value17);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value18 = (DataCanbus.DATA[111] & 255) + 1;
                if (value18 > 1) {
                    value18 = 1;
                }
                setCarInfoCmd(23, value18);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                setCarInfoCmd(20, (DataCanbus.DATA[114] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                setCarInfoCmd(170, 254);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                Intent intent = new Intent(this, (Class<?>) ActivityRuiHu7.class);
                startActivity(intent);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                setCarInfoCmd(1, DataCanbus.DATA[60] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                setCarInfoCmd(4, (DataCanbus.DATA[73] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                setCarInfoCmd(5, (DataCanbus.DATA[74] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                setCarInfoCmd(6, (DataCanbus.DATA[75] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                setCarInfoCmd(9, (DataCanbus.DATA[76] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                setCarInfoCmd(10, (DataCanbus.DATA[77] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                setCarInfoCmd(12, (DataCanbus.DATA[87] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                setCarInfoCmd(13, (DataCanbus.DATA[88] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                setCarInfoCmd(14, (DataCanbus.DATA[89] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                setCarInfoCmd(15, (DataCanbus.DATA[106] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                setCarInfoCmd(16, (DataCanbus.DATA[107] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                setCarInfoCmd(24, (DataCanbus.DATA[112] & 255) != 0 ? 0 : 1);
                break;
        }
    }

    protected void updateAutoLock(int value2) {
        if (findViewById(R.id.layout_view8) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view8).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view8).setVisibility(8);
            }
        }
    }

    protected void updateBiglightSleep(int value2) {
        if (findViewById(R.id.layout_view9) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view9).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view9).setVisibility(8);
            }
        }
    }

    protected void updateDayLight(int value2) {
        if (findViewById(R.id.layout_view10) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view10).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view10).setVisibility(8);
            }
        }
    }

    protected void updateSteeringAvm(int value2) {
        if (findViewById(R.id.layout_view11) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view11).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view11).setVisibility(8);
            }
        }
    }

    protected void updateSteeringAnim(int value2) {
        if (findViewById(R.id.layout_view12) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view12).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view12).setVisibility(8);
            }
        }
    }

    protected void updateVehicleGuides(int value2) {
        if (findViewById(R.id.layout_view13) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view13).setVisibility(0);
                switch (value2 & 255) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text3)).setText(R.string.off);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_395_static_state);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text3)).setText(R.string.str_395_static_and_dynamic);
                        break;
                }
            }
            findViewById(R.id.layout_view13).setVisibility(8);
        }
    }

    protected void updateEpsMode(int value2) {
        if (findViewById(R.id.layout_view24) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view24).setVisibility(0);
                int value = value2 & 255;
                if (value == 0) {
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
                    return;
                } else {
                    if (value == 1) {
                        ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_driving_sport);
                        return;
                    }
                    return;
                }
            }
            findViewById(R.id.layout_view24).setVisibility(8);
        }
    }

    protected void updateChangeRoad(int value2) {
        if (findViewById(R.id.layout_view23) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view23).setVisibility(0);
                int value = value2 & 255;
                if (value == 0) {
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                    return;
                }
                if (value == 1) {
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_three_times);
                    return;
                } else if (value == 2) {
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_five_times);
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_seven_times);
                    return;
                }
            }
            findViewById(R.id.layout_view23).setVisibility(8);
        }
    }

    protected void updateHomeLight(int value2) {
        if (findViewById(R.id.layout_view22) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view22).setVisibility(0);
                int value = value2 & 255;
                if (value == 0) {
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.off);
                    return;
                } else if (value == 1) {
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                    return;
                }
            }
            findViewById(R.id.layout_view22).setVisibility(8);
        }
    }

    protected void updateFortificationPrompt(int value2) {
        if (findViewById(R.id.layout_view21) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view21).setVisibility(0);
                int value = value2 & 255;
                if (value == 0) {
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_light);
                    return;
                } else if (value == 1) {
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_sounds);
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_text6)).setText(R.string.dj_airuize7_prompt_lightsounds);
                    return;
                }
            }
            findViewById(R.id.layout_view21).setVisibility(8);
        }
    }

    protected void updateSpeedAlarm(int value2) {
        if (findViewById(R.id.layout_view14) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view14).setVisibility(0);
                int value = value2 & 255;
                if (value == 0) {
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append((value * 5) + 25).toString());
                    return;
                }
            }
            findViewById(R.id.layout_view14).setVisibility(8);
        }
    }

    protected void updateRoadAway(int value2) {
        if (findViewById(R.id.layout_view20) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view20).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext15)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view20).setVisibility(8);
            }
        }
    }

    protected void updateWelcomeLight(int value2) {
        if (findViewById(R.id.layout_view25) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view25).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view25).setVisibility(8);
            }
        }
    }

    protected void updateBlidSide(int value2) {
        if (findViewById(R.id.layout_view19) != null) {
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view19).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view19).setVisibility(8);
            }
        }
    }

    protected void updateAutoFoldRearview(int value2) {
        if (findViewById(R.id.layout_view18) != null) {
            int i = value2 & 255;
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view18).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view18).setVisibility(8);
            }
        }
    }

    protected void updateAutoUnlock(int value2) {
        if (findViewById(R.id.layout_view17) != null) {
            int i = value2 & 255;
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view17).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view17).setVisibility(8);
            }
        }
    }

    protected void updateRemodeBack(int value2) {
        if (findViewById(R.id.layout_view16) != null) {
            int i = value2 & 255;
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view16).setVisibility(0);
                ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked((value2 & 255) == 1);
            } else {
                findViewById(R.id.layout_view16).setVisibility(8);
            }
        }
    }

    protected void updateDashBoardBacklight(int value2) {
        if (findViewById(R.id.layout_view15) != null) {
            int value = value2 & 255;
            if (((65280 & value2) >> 8) == 1) {
                findViewById(R.id.layout_view15).setVisibility(0);
                if (value > 10) {
                    value = 10;
                } else if (value <= 0) {
                    value = 0;
                }
                ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                return;
            }
            findViewById(R.id.layout_view15).setVisibility(8);
        }
    }

    private void setCarInfoCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(2, cmd, value);
    }
}
