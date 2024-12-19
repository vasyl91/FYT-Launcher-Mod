package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7Electric_management_Acti_RZC extends BaseActivity implements View.OnClickListener {
    int value_select = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7Electric_management_Acti_RZC.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            Golf7Electric_management_Acti_RZC.this.mUpdaterCurStation();
            switch (updateCode) {
                case 360:
                    if (((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text2)) != null) {
                        if (DataCanbus.DATA[1000] == 655377) {
                            if (value == 254) {
                                ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text2)).setText("LO");
                                break;
                            } else if (value == 255) {
                                ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text2)).setText("HI");
                                break;
                            } else {
                                int value2 = value * 5;
                                ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "℃");
                                break;
                            }
                        } else if (value < 60) {
                            ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text2)).setText("LO");
                            break;
                        } else if (value > 195 || value == 255) {
                            ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text2)).setText("HI");
                            break;
                        } else {
                            int value3 = value + 100;
                            ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "℃");
                            break;
                        }
                    }
                    break;
                case 404:
                    if (DataCanbus.DATA[1000] == 655377) {
                        Golf7Electric_management_Acti_RZC.this.value_select |= value & 32;
                    } else {
                        Golf7Electric_management_Acti_RZC.this.value_select |= value & 4;
                    }
                    Golf7Electric_management_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 405:
                    if (DataCanbus.DATA[1000] == 655377) {
                        Golf7Electric_management_Acti_RZC.this.value_select |= value & 64;
                    } else {
                        Golf7Electric_management_Acti_RZC.this.value_select |= value & 2;
                    }
                    Golf7Electric_management_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 406:
                    if (DataCanbus.DATA[1000] == 655377) {
                        Golf7Electric_management_Acti_RZC.this.value_select |= value & 128;
                    } else {
                        Golf7Electric_management_Acti_RZC.this.value_select |= value & 1;
                    }
                    Golf7Electric_management_Acti_RZC.this.setCheck((CheckedTextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 410:
                case 411:
                    if (DataCanbus.DATA[410] == 1 && DataCanbus.DATA[411] == 0) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text4)).setText("充电");
                        break;
                    } else if (DataCanbus.DATA[410] == 0 && DataCanbus.DATA[411] == 1) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text4)).setText("空调控制");
                        break;
                    } else if (DataCanbus.DATA[410] == 1 && DataCanbus.DATA[411] == 1) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text4)).setText("充电和空调控制");
                        break;
                    }
                case 429:
                case 430:
                    if (DataCanbus.DATA[429] == 1 && DataCanbus.DATA[430] == 0) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text5)).setText("充电");
                        break;
                    } else if (DataCanbus.DATA[429] == 0 && DataCanbus.DATA[430] == 1) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text5)).setText("空调控制");
                        break;
                    } else if (DataCanbus.DATA[429] == 1 && DataCanbus.DATA[430] == 1) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text5)).setText("充电和空调控制");
                        break;
                    }
                case 448:
                case 449:
                    if (DataCanbus.DATA[448] == 1 && DataCanbus.DATA[449] == 0) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text6)).setText("充电");
                        break;
                    } else if (DataCanbus.DATA[448] == 0 && DataCanbus.DATA[449] == 1) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text6)).setText("空调控制");
                        break;
                    } else if (DataCanbus.DATA[448] == 1 && DataCanbus.DATA[449] == 1) {
                        ((TextView) Golf7Electric_management_Acti_RZC.this.findViewById(R.id.tv_text6)).setText("充电和空调控制");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0160_rzc_mqb_electric_management);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[406];
                if (DataCanbus.DATA[1000] == 655377) {
                    if (value == 1) {
                        this.value_select &= 127;
                    } else if (value == 0) {
                        this.value_select |= 128;
                    }
                    setCarInfo_WC(this.value_select);
                    break;
                } else {
                    if (value == 1) {
                        this.value_select &= 254;
                    } else if (value == 0) {
                        this.value_select |= 1;
                    }
                    setCarInfo(0, this.value_select);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Golf7Electric_management_d1_Acti_RZC.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value2 = DataCanbus.DATA[405];
                if (DataCanbus.DATA[1000] == 655377) {
                    if (value2 == 1) {
                        this.value_select &= 191;
                    } else if (value2 == 0) {
                        this.value_select |= 64;
                    }
                    setCarInfo_WC(this.value_select);
                    break;
                } else {
                    if (value2 == 1) {
                        this.value_select &= 253;
                    } else if (value2 == 0) {
                        this.value_select |= 2;
                    }
                    setCarInfo(0, this.value_select);
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Golf7Electric_management_d2_Acti_RZC.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value3 = DataCanbus.DATA[404];
                if (DataCanbus.DATA[1000] == 655377) {
                    if (value3 == 1) {
                        this.value_select &= 223;
                    } else if (value3 == 0) {
                        this.value_select |= 32;
                    }
                    setCarInfo_WC(this.value_select);
                    break;
                } else {
                    if (value3 == 1) {
                        this.value_select &= 251;
                    } else if (value3 == 0) {
                        this.value_select |= 4;
                    }
                    setCarInfo(0, this.value_select);
                    break;
                }
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, Golf7Electric_management_d3_Acti_RZC.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
        }
    }

    public void setCarInfo_WC(int value) {
        RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
        int[] iArr = new int[19];
        iArr[0] = value | 28;
        remoteModuleProxy.cmd(147, iArr, null, null);
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(142, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[404].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[405].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[406].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[360].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[464].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[465].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[407].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[408].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[410].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[411].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[413].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[426].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[427].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[429].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[430].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[432].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[445].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[446].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[448].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[449].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[451].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[404].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[405].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[406].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[360].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[464].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[465].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[407].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[408].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[410].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[411].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[413].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[426].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[427].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[429].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[430].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[432].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[445].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[446].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[448].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[449].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[451].removeNotify(this.mNotifyCanbus);
    }

    int mGetSmallvalue(int value1, int value2, int value3) {
        int value = value1;
        if (value > value2) {
            value = value2;
        }
        if (value > value3) {
            return value3;
        }
        return value;
    }

    int mGetAbsolutevalue(int value, int value2) {
        if (value >= value2) {
            int t = value - value2;
            return t;
        }
        int t2 = value2 - value;
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurStation() {
        boolean num1 = DataCanbus.DATA[406] == 1;
        boolean num2 = DataCanbus.DATA[405] == 1;
        boolean num3 = DataCanbus.DATA[404] == 1;
        int cur_h = DataCanbus.DATA[464];
        int cur_m = DataCanbus.DATA[465];
        int num1_h = DataCanbus.DATA[407];
        int num1_m = DataCanbus.DATA[408];
        int num2_h = DataCanbus.DATA[426];
        int num2_m = DataCanbus.DATA[427];
        int num3_h = DataCanbus.DATA[445];
        int num3_m = DataCanbus.DATA[446];
        String num1_cur = "";
        switch (DataCanbus.DATA[413]) {
            case 0:
                num1_cur = "5A";
                break;
            case 1:
                num1_cur = "10A";
                break;
            case 2:
                num1_cur = "13A";
                break;
            case 3:
                num1_cur = "MAX";
                break;
        }
        String num2_cur = "";
        switch (DataCanbus.DATA[432]) {
            case 0:
                num2_cur = "5A";
                break;
            case 1:
                num2_cur = "10A";
                break;
            case 2:
                num2_cur = "13A";
                break;
            case 3:
                num2_cur = "MAX";
                break;
        }
        String num3_cur = "";
        switch (DataCanbus.DATA[451]) {
            case 0:
                num3_cur = "5A";
                break;
            case 1:
                num3_cur = "10A";
                break;
            case 2:
                num3_cur = "13A";
                break;
            case 3:
                num3_cur = "MAX";
                break;
        }
        if (!num1 && !num2 && !num3) {
            ((TextView) findViewById(R.id.tv_text1)).setText("--:--");
            return;
        }
        if (num1 && !num2 && !num3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
            ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
            return;
        }
        if (!num1 && num2 && !num3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
            ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
            return;
        }
        if (!num1 && !num2 && num3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
            ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
            return;
        }
        if (num1 && num2 && !num3) {
            int h1_dis = mGetAbsolutevalue(num1_h, cur_h);
            int h2_dis = mGetAbsolutevalue(num2_h, cur_h);
            if (h1_dis > h2_dis) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                return;
            }
            if (h1_dis < h2_dis) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                return;
            } else {
                if (h1_dis == h2_dis) {
                    if (mGetAbsolutevalue(num1_m, cur_m) > mGetAbsolutevalue(num2_m, cur_m)) {
                        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                        ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                        ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                        return;
                    }
                }
                return;
            }
        }
        if (!num1 && num2 && num3) {
            int h2_dis2 = mGetAbsolutevalue(num2_h, cur_h);
            int h3_dis = mGetAbsolutevalue(num3_h, cur_h);
            if (h2_dis2 > h3_dis) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                return;
            }
            if (h2_dis2 < h3_dis) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                return;
            } else {
                if (h2_dis2 == h3_dis) {
                    if (mGetAbsolutevalue(num2_m, cur_m) > mGetAbsolutevalue(num3_m, cur_m)) {
                        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                        ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                        ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                        return;
                    }
                }
                return;
            }
        }
        if (num1 && !num2 && num3) {
            int h1_dis2 = mGetAbsolutevalue(num1_h, cur_h);
            int h3_dis2 = mGetAbsolutevalue(num3_h, cur_h);
            if (h1_dis2 > h3_dis2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                return;
            }
            if (h1_dis2 < h3_dis2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                return;
            } else {
                if (h1_dis2 == h3_dis2) {
                    if (mGetAbsolutevalue(num1_m, cur_m) > mGetAbsolutevalue(num3_m, cur_m)) {
                        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                        ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                        return;
                    } else {
                        ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                        ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                        return;
                    }
                }
                return;
            }
        }
        if (num1 && num2 && num3) {
            int h1_dis3 = mGetAbsolutevalue(num1_h, cur_h);
            int h2_dis3 = mGetAbsolutevalue(num2_h, cur_h);
            int h3_dis3 = mGetAbsolutevalue(num3_h, cur_h);
            if (h1_dis3 == mGetSmallvalue(h1_dis3, h2_dis3, h3_dis3) && h1_dis3 != h2_dis3 && h1_dis3 != h3_dis3) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                return;
            }
            if (h2_dis3 == mGetSmallvalue(h1_dis3, h2_dis3, h3_dis3) && h1_dis3 != h2_dis3 && h2_dis3 != h3_dis3) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                return;
            }
            if (h3_dis3 == mGetSmallvalue(h1_dis3, h2_dis3, h3_dis3) && h1_dis3 != h3_dis3 && h2_dis3 != h3_dis3) {
                ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                return;
            }
            if (h1_dis3 == mGetSmallvalue(h1_dis3, h2_dis3, h3_dis3) && h1_dis3 == h2_dis3 && h2_dis3 != h3_dis3) {
                if (mGetAbsolutevalue(num1_m, cur_m) > mGetAbsolutevalue(num2_m, cur_m)) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                    return;
                }
            }
            if (h1_dis3 == mGetSmallvalue(h1_dis3, h2_dis3, h3_dis3) && h1_dis3 != h2_dis3 && h1_dis3 == h3_dis3) {
                if (mGetAbsolutevalue(num1_m, cur_m) > mGetAbsolutevalue(num3_m, cur_m)) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                    return;
                } else {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                    return;
                }
            }
            if (h1_dis3 == mGetSmallvalue(h1_dis3, h2_dis3, h3_dis3) && h1_dis3 == h2_dis3 && h2_dis3 == h3_dis3) {
                int m1_dis = mGetAbsolutevalue(num1_m, cur_m);
                int m2_dis = mGetAbsolutevalue(num2_m, cur_m);
                int m3_dis = mGetAbsolutevalue(num3_m, cur_m);
                if (m1_dis == mGetSmallvalue(m1_dis, m2_dis, m3_dis)) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num1_h) + ":" + num1_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num1_cur);
                } else if (m2_dis == mGetSmallvalue(m1_dis, m2_dis, m3_dis)) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                }
                if (m3_dis == mGetSmallvalue(m1_dis, m2_dis, m3_dis)) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                    return;
                }
                return;
            }
            if (h2_dis3 == mGetSmallvalue(h1_dis3, h2_dis3, h3_dis3) && h2_dis3 == h3_dis3) {
                if (mGetAbsolutevalue(num2_m, cur_m) > mGetAbsolutevalue(num3_m, cur_m)) {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num3_h) + ":" + num3_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num3_cur);
                } else {
                    ((TextView) findViewById(R.id.tv_text1)).setText(String.valueOf(num2_h) + ":" + num2_m);
                    ((TextView) findViewById(R.id.tv_text3)).setText(num2_cur);
                }
            }
        }
    }
}
