package com.syu.carinfo.xp.ziyouguang;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

import java.lang.reflect.Field;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAJeepWeekdaysWindow extends BaseActivity implements View.OnClickListener {
    private View mRootView;
    private PopupWindow mWindow;
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 273:
                case 277:
                    if (((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text1)) != null) {
                        if (PAJeepWeekdaysWindow.this.pagenum == 2) {
                            ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[277])).toString());
                            break;
                        } else {
                            ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[273])).toString());
                            break;
                        }
                    }
                    break;
                case 274:
                case 278:
                    if (((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text2)) != null) {
                        if (PAJeepWeekdaysWindow.this.pagenum == 2) {
                            ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[278])).toString());
                            break;
                        } else {
                            ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[274])).toString());
                            break;
                        }
                    }
                    break;
                case 275:
                case 279:
                    if (((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text3)) != null) {
                        if (PAJeepWeekdaysWindow.this.pagenum == 2) {
                            int value = DataCanbus.DATA[279];
                            if (value == 24) {
                                ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text3)).setText("Full");
                                ((Button) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.pop_full_charge_onoff)).setBackgroundResource(R.drawable.ic_pa_chargfull_on);
                                break;
                            } else {
                                ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                                ((Button) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.pop_full_charge_onoff)).setBackgroundResource(R.drawable.ic_pa_chargfull_off);
                                break;
                            }
                        } else {
                            int value2 = DataCanbus.DATA[275];
                            if (value2 == 24) {
                                ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text3)).setText("Full");
                                ((Button) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.pop_full_charge_onoff)).setBackgroundResource(R.drawable.ic_pa_chargfull_on);
                                break;
                            } else {
                                ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value2)).toString());
                                ((Button) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.pop_full_charge_onoff)).setBackgroundResource(R.drawable.ic_pa_chargfull_off);
                                break;
                            }
                        }
                    }
                    break;
                case 276:
                case 280:
                    if (((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text4)) != null) {
                        if (PAJeepWeekdaysWindow.this.pagenum == 2) {
                            ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[280])).toString());
                            break;
                        } else {
                            ((TextView) PAJeepWeekdaysWindow.this.mRootView.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[276])).toString());
                            break;
                        }
                    }
                    break;
            }
        }
    };

    public PAJeepWeekdaysWindow(PAJeepChargingScheduleAct act) {
        initView();
        initPop();
    }

    private void initPop() {
        if (this.mWindow == null) {
            this.mWindow = new PopupWindow(LauncherApplication.getInstance());
            this.mWindow.setContentView(this.mRootView);
            this.mWindow.setAnimationStyle(R.style.contextMenuAnim);
            this.mWindow.setWidth(-1);
            this.mWindow.setHeight(-1);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mWindow.setOutsideTouchable(false);
            try {
                Field mLayoutInScreen = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                mLayoutInScreen.setAccessible(true);
                mLayoutInScreen.set(this.mWindow, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mRootView = View.inflate(LauncherApplication.getInstance(), R.layout.layout_0374_pa_jeep_weekdays, null);
        ((Button) this.mRootView.findViewById(R.id.pop_close)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.pop_full_charge_onoff)).setOnClickListener(this);
    }

    public void showWindow(View Parent, int num) {
        this.pagenum = num;
        if (num == 2) {
            ((TextView) this.mRootView.findViewById(R.id.tv_text5)).setText(R.string.str_weekends);
        } else {
            ((TextView) this.mRootView.findViewById(R.id.tv_text5)).setText(R.string.str_weekdays);
        }
        this.mWindow.showAtLocation(Parent, 48, 0, LauncherApplication.getScreenHeight());
        addNotify();
    }

    public void hideWindow() {
        this.mWindow.dismiss();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (this.pagenum == 2) {
                    int value = DataCanbus.DATA[277] - 1;
                    if (value < 0) {
                        value = 23;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{8, value}, null, null);
                    break;
                } else {
                    int value2 = DataCanbus.DATA[273] - 1;
                    if (value2 < 0) {
                        value2 = 23;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{4, value2}, null, null);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                if (this.pagenum == 2) {
                    int value3 = DataCanbus.DATA[277] + 1;
                    if (value3 > 23) {
                        value3 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{8, value3}, null, null);
                    break;
                } else {
                    int value4 = DataCanbus.DATA[273] + 1;
                    if (value4 > 23) {
                        value4 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{4, value4}, null, null);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                if (this.pagenum == 2) {
                    int value5 = DataCanbus.DATA[278] - 15;
                    if (value5 < 0) {
                        value5 = 45;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{9, value5}, null, null);
                    break;
                } else {
                    int value6 = DataCanbus.DATA[274] - 15;
                    if (value6 < 0) {
                        value6 = 45;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{5, value6}, null, null);
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                if (this.pagenum == 2) {
                    int value7 = DataCanbus.DATA[278] + 15;
                    if (value7 > 59) {
                        value7 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{9, value7}, null, null);
                    break;
                } else {
                    int value8 = DataCanbus.DATA[274] + 15;
                    if (value8 > 59) {
                        value8 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{5, value8}, null, null);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                if (this.pagenum == 2) {
                    int value9 = DataCanbus.DATA[279] - 1;
                    if (value9 < 0) {
                        value9 = 23;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{10, value9}, null, null);
                    break;
                } else {
                    int value10 = DataCanbus.DATA[275] - 1;
                    if (value10 < 0) {
                        value10 = 23;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{6, value10}, null, null);
                    break;
                }
            case R.id.btn_plus3 /* 2131427463 */:
                if (this.pagenum == 2) {
                    int value11 = DataCanbus.DATA[279] + 1;
                    if (value11 > 23) {
                        value11 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{10, value11}, null, null);
                    break;
                } else {
                    int value12 = DataCanbus.DATA[275] + 1;
                    if (value12 > 23) {
                        value12 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{6, value12}, null, null);
                    break;
                }
            case R.id.btn_minus4 /* 2131427464 */:
                if (this.pagenum == 2) {
                    int value13 = DataCanbus.DATA[280] - 15;
                    if (value13 < 0) {
                        value13 = 45;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{11, value13}, null, null);
                    break;
                } else {
                    int value14 = DataCanbus.DATA[276] - 15;
                    if (value14 < 0) {
                        value14 = 45;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{7, value14}, null, null);
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                if (this.pagenum == 2) {
                    int value15 = DataCanbus.DATA[280] + 15;
                    if (value15 > 59) {
                        value15 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{11, value15}, null, null);
                    break;
                } else {
                    int value16 = DataCanbus.DATA[276] + 15;
                    if (value16 > 59) {
                        value16 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{7, value16}, null, null);
                    break;
                }
            case R.id.pop_close /* 2131427925 */:
                hideWindow();
                break;
            case R.id.pop_full_charge_onoff /* 2131428018 */:
                if (this.pagenum == 2) {
                    int value17 = DataCanbus.DATA[279];
                    if (value17 != 24) {
                        value17 = 24;
                    } else if (value17 == 24) {
                        value17 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{10, value17}, null, null);
                    break;
                } else {
                    int value18 = DataCanbus.DATA[275];
                    if (value18 != 24) {
                        value18 = 24;
                    } else if (value18 == 24) {
                        value18 = 0;
                    }
                    DataCanbus.PROXY.cmd(11, new int[]{6, value18}, null, null);
                    break;
                }
        }
    }
}
