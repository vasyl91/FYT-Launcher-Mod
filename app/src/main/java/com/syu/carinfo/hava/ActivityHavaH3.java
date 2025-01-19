package com.syu.carinfo.hava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class ActivityHavaH3 extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ActivityHavaH3.this.updateAutoDoorUnLock(val);
                    break;
                case 100:
                    ActivityHavaH3.this.updateAutoDoorLock(val);
                    break;
                case 101:
                    ActivityHavaH3.this.updateAutoDoorReLock(val);
                    break;
                case 102:
                    ActivityHavaH3.this.updateOneDoorUnlock(val);
                    break;
                case 103:
                    ActivityHavaH3.this.updateLockFlash(val);
                    break;
                case 104:
                    ActivityHavaH3.this.updateUnlockFlash(val);
                    break;
                case 105:
                    ActivityHavaH3.this.updateRearMirrorAutoFold(val);
                    break;
                case 106:
                    ActivityHavaH3.this.updateBackCamera(val);
                    break;
                case 107:
                    ActivityHavaH3.this.updateBackCarMuteInhibition(val);
                    break;
                case 108:
                    if (((CheckedTextView) ActivityHavaH3.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) ActivityHavaH3.this.findViewById(R.id.ctv_checkedtext1)).setChecked(val != 0);
                        break;
                    }
                case 109:
                    if (((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                                break;
                            default:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                                break;
                        }
                    }
                    break;
                case 110:
                    if (((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text2)).setText(R.string.dj_airuize7_prompt_light);
                                break;
                            case 2:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text2)).setText(R.string.dj_airuize7_prompt_sounds);
                                break;
                            case 3:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text2)).setText(R.string.dj_airuize7_prompt_lightsounds);
                                break;
                            default:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((CheckedTextView) ActivityHavaH3.this.findViewById(R.id.ctv_checkedtext2)) != null) {
                        ((CheckedTextView) ActivityHavaH3.this.findViewById(R.id.ctv_checkedtext2)).setChecked(val != 0);
                        break;
                    }
                case 112:
                    if (((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(val)).toString());
                        break;
                    }
                case 113:
                    if (((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text4)) != null) {
                        if (val > 4) {
                            ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text4)).setText("+" + (val - 4));
                            break;
                        } else if (val < 4) {
                            ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text4)).setText("-" + (4 - val));
                            break;
                        } else {
                            ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text4)).setText("0");
                            break;
                        }
                    }
                    break;
                case 114:
                    if (((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text5)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text5)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text5)).setText("90s");
                                break;
                            case 4:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text5)).setText("120s");
                                break;
                            default:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 115:
                    if (((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text6)).setText("30s");
                                break;
                            case 2:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text6)).setText("60s");
                                break;
                            case 3:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text6)).setText("90s");
                                break;
                            default:
                                ((TextView) ActivityHavaH3.this.findViewById(R.id.tv_text6)).setText(R.string.off);
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
        //setContentView(R.layout.layout_307_rzc_havah3);
        setListener();
    }

    private void setListener() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_17ZhongHuaH3 /* 65843 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6 /* 131379 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18ZhongHuaV6_H /* 196915 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[109] - 1;
                if (value < 0) {
                    value = 0;
                }
                setCarInfoCmd(13, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[109] + 1;
                if (value2 > 1) {
                    value2 = 1;
                }
                setCarInfoCmd(13, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[110] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCarInfoCmd(12, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[110] + 1;
                if (value4 > 3) {
                    value4 = 3;
                }
                setCarInfoCmd(12, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[112] - 1;
                if (value5 < 0) {
                    value5 = 0;
                }
                setCarInfoCmd(14, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[112] + 1;
                if (value6 > 15) {
                    value6 = 15;
                }
                setCarInfoCmd(14, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[113] - 1;
                if (value7 < 0) {
                    value7 = 0;
                }
                setCarInfoCmd(15, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[113] + 1;
                if (value8 > 8) {
                    value8 = 8;
                }
                setCarInfoCmd(15, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[114] - 1;
                if (value9 < 0) {
                    value9 = 0;
                }
                setCarInfoCmd(16, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[114] + 1;
                if (value10 > 4) {
                    value10 = 4;
                }
                setCarInfoCmd(16, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[115] - 1;
                if (value11 < 0) {
                    value11 = 0;
                }
                setCarInfoCmd(17, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[115] + 1;
                if (value12 > 3) {
                    value12 = 3;
                }
                setCarInfoCmd(17, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[107] - 1;
                if (value13 < 0) {
                    value13 = 0;
                }
                setCarInfoCmd(9, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[107] + 1;
                if (value14 > 3) {
                    value14 = 3;
                }
                setCarInfoCmd(9, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfoCmd(10, DataCanbus.DATA[108] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfoCmd(11, DataCanbus.DATA[111] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfoCmd(1, DataCanbus.DATA[100] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfoCmd(2, DataCanbus.DATA[99] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfoCmd(3, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfoCmd(4, DataCanbus.DATA[102] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfoCmd(5, DataCanbus.DATA[103] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfoCmd(6, DataCanbus.DATA[104] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfoCmd(7, DataCanbus.DATA[105] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfoCmd(8, DataCanbus.DATA[106] != 0 ? 0 : 1);
                break;
        }
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

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    private void setCarInfoCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(0, cmd, value);
    }

    protected void updateAutoDoorUnLock(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    protected void updateAutoDoorLock(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    protected void updateAutoDoorReLock(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    protected void updateOneDoorUnlock(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    protected void updateLockFlash(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    protected void updateUnlockFlash(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
    }

    protected void updateRearMirrorAutoFold(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    protected void updateBackCamera(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    protected void updateBackCarMuteInhibition(int value) {
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_middle);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.klc_air_high);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text7)).setText(R.string.crv_source_null);
                    break;
            }
        }
    }
}
