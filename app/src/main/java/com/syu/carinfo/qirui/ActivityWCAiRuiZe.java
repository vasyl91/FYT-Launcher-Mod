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

@SuppressWarnings({"deprecation", "unchecked"})
public class ActivityWCAiRuiZe extends Activity implements View.OnClickListener {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 129:
                    if (value == 1) {
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view5).setVisibility(0);
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view6).setVisibility(0);
                        break;
                    } else {
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view5).setVisibility(8);
                        ActivityWCAiRuiZe.this.findViewById(R.id.layout_view6).setVisibility(8);
                        break;
                    }
                case 130:
                    if (((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                        break;
                    }
                case 131:
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
                case 132:
                    if (((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityWCAiRuiZe.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 133:
                    ActivityWCAiRuiZe.this.updateAutoLock(value);
                    break;
                case 134:
                    ActivityWCAiRuiZe.this.updateBiglightSleep(value);
                    break;
                case 135:
                    ActivityWCAiRuiZe.this.updateDayLight(value);
                    break;
                case 136:
                    ActivityWCAiRuiZe.this.updateSteeringAvm(value);
                    break;
                case 137:
                    ActivityWCAiRuiZe.this.updateSteeringAnim(value);
                    break;
                case 138:
                    ActivityWCAiRuiZe.this.updateVehicleGuides(value);
                    break;
                case 139:
                    ActivityWCAiRuiZe.this.updateSpeedAlarm(value);
                    break;
                case 140:
                    ActivityWCAiRuiZe.this.updateDashBoardBacklight(value);
                    break;
                case 146:
                    ActivityWCAiRuiZe.this.updateRemodeBack(value);
                    break;
                case 147:
                    ActivityWCAiRuiZe.this.updateAutoUnlock(value);
                    break;
                case 148:
                    ActivityWCAiRuiZe.this.updateAutoFoldRearview(value);
                    break;
                case 165:
                    ActivityWCAiRuiZe.this.updateBlidSide(value);
                    break;
                case 166:
                    ActivityWCAiRuiZe.this.updateRoadAway(value);
                    break;
                case 167:
                    ActivityWCAiRuiZe.this.updateFortificationPrompt(value);
                    break;
                case 168:
                    ActivityWCAiRuiZe.this.updateHomeLight(value);
                    break;
                case 169:
                    ActivityWCAiRuiZe.this.updateChangeRoad(value);
                    break;
                case 170:
                    ActivityWCAiRuiZe.this.updateEpsMode(value);
                    break;
                case 171:
                    ActivityWCAiRuiZe.this.updateWelcomeLight(value);
                    break;
                case 172:
                    if (((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 173:
                    if (((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityWCAiRuiZe.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_395_qirui_airuize);
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

    @Override
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

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mCanbusNotify);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[131] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfoCmd(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[131] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfoCmd(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[132] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCarInfoCmd(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[132] + 1;
                if (value4 > 30) {
                    value4 = 30;
                }
                setCarInfoCmd(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = (DataCanbus.DATA[138] & 255) - 1;
                if (value5 < 0) {
                    value5 = 0;
                }
                setCarInfoCmd(11, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = (DataCanbus.DATA[138] & 255) + 1;
                if (value6 > 2) {
                    value6 = 2;
                }
                setCarInfoCmd(11, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = (DataCanbus.DATA[139] & 255) - 1;
                if (value7 < 0) {
                    value7 = 0;
                }
                setCarInfoCmd(7, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = (DataCanbus.DATA[139] & 255) + 1;
                if (value8 > 21) {
                    value8 = 21;
                }
                setCarInfoCmd(7, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = (DataCanbus.DATA[140] & 255) - 1;
                if (value9 < 1) {
                    value9 = 1;
                }
                setCarInfoCmd(8, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = (DataCanbus.DATA[140] & 255) + 1;
                if (value10 > 10) {
                    value10 = 10;
                }
                setCarInfoCmd(8, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = (DataCanbus.DATA[167] & 255) - 1;
                if (value11 < 0) {
                    value11 = 0;
                }
                setCarInfoCmd(17, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = (DataCanbus.DATA[167] & 255) + 1;
                if (value12 > 2) {
                    value12 = 2;
                }
                setCarInfoCmd(17, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = (DataCanbus.DATA[168] & 255) - 1;
                if (value13 < 0) {
                    value13 = 0;
                }
                setCarInfoCmd(21, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = (DataCanbus.DATA[168] & 255) + 1;
                if (value14 > 2) {
                    value14 = 2;
                }
                setCarInfoCmd(21, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = (DataCanbus.DATA[169] & 255) - 1;
                if (value15 < 0) {
                    value15 = 0;
                }
                setCarInfoCmd(22, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = (DataCanbus.DATA[169] & 255) + 1;
                if (value16 > 3) {
                    value16 = 3;
                }
                setCarInfoCmd(22, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = (DataCanbus.DATA[170] & 255) - 1;
                if (value17 < 0) {
                    value17 = 0;
                }
                setCarInfoCmd(23, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = (DataCanbus.DATA[170] & 255) + 1;
                if (value18 > 1) {
                    value18 = 1;
                }
                setCarInfoCmd(23, value18);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfoCmd(19, (DataCanbus.DATA[172] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfoCmd(20, (DataCanbus.DATA[173] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfoCmd(170, 254);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                Intent intent = new Intent(this, (Class<?>) ActivityRuiHu7.class);
                startActivity(intent);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfoCmd(1, DataCanbus.DATA[130] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfoCmd(4, (DataCanbus.DATA[133] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfoCmd(5, (DataCanbus.DATA[134] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfoCmd(6, (DataCanbus.DATA[135] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfoCmd(9, (DataCanbus.DATA[136] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfoCmd(10, (DataCanbus.DATA[137] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfoCmd(12, (DataCanbus.DATA[146] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfoCmd(13, (DataCanbus.DATA[147] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setCarInfoCmd(14, (DataCanbus.DATA[148] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                setCarInfoCmd(15, (DataCanbus.DATA[165] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                setCarInfoCmd(16, (DataCanbus.DATA[166] & 255) != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                setCarInfoCmd(24, (DataCanbus.DATA[171] & 255) != 0 ? 0 : 1);
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
