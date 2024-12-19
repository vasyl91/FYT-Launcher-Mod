package com.syu.carinfo.ford;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FordCarSeatInfo extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static FordCarSeatInfo mInit;
    int pagenum = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarSeatInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    if (FordCarSeatInfo.this.pagenum == 0) {
                        switch (value) {
                            case 0:
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                                break;
                            case 1:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                                break;
                            case 2:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(8);
                                break;
                        }
                    }
                    break;
                case 101:
                    if (FordCarSeatInfo.this.pagenum == 1) {
                        switch (value) {
                            case 0:
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                                break;
                            case 1:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                                break;
                            case 2:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(8);
                                break;
                        }
                    }
                    break;
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                    FordCarSeatInfo.this.mUpdateSeatValue();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_seatset);
        init();
    }

    public void init() {
        mInit = this;
        findViewById(R.id.ford_seat_sub1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub3).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add3).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub_1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub_2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add_1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add_2).setOnTouchListener(this);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427482 */:
                    this.pagenum = 0;
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                    mUpdateSeatValue();
                    break;
                case R.id.btn_plus2 /* 2131427486 */:
                    this.pagenum = 1;
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                    mUpdateSeatValue();
                    break;
                case R.id.btn_plus3 /* 2131427490 */:
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 10, 1}, null, null);
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 11, 1}, null, null);
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    }
                case R.id.btn_plus4 /* 2131427494 */:
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 10, 2}, null, null);
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 11, 2}, null, null);
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    }
                case R.id.ford_seat_sub1 /* 2131427817 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 0, 2}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3, 2}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub2 /* 2131427818 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1, 2}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4, 2}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub3 /* 2131427819 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2, 2}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5, 2}, null, null);
                        break;
                    }
                case R.id.ford_seat_add1 /* 2131427820 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 0, 1}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3, 1}, null, null);
                        break;
                    }
                case R.id.ford_seat_add2 /* 2131427821 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1, 1}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4, 1}, null, null);
                        break;
                    }
                case R.id.ford_seat_add3 /* 2131427822 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2, 1}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5, 1}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub_1 /* 2131427823 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int leftmassage_vaue1 = DataCanbus.DATA[105];
                        if (leftmassage_vaue1 > 0) {
                            leftmassage_vaue1--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 6, leftmassage_vaue1}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int rightmassage_vaue1 = DataCanbus.DATA[110];
                        if (rightmassage_vaue1 > 0) {
                            rightmassage_vaue1--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 8, rightmassage_vaue1}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub_2 /* 2131427824 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int leftmassage_vaue2 = DataCanbus.DATA[106];
                        if (leftmassage_vaue2 > 0) {
                            leftmassage_vaue2--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 7, leftmassage_vaue2}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int rightmassage_vaue2 = DataCanbus.DATA[111];
                        if (rightmassage_vaue2 > 0) {
                            rightmassage_vaue2--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 9, rightmassage_vaue2}, null, null);
                        break;
                    }
                case R.id.ford_seat_add_1 /* 2131427825 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int leftmassage_vaue12 = DataCanbus.DATA[105];
                        if (leftmassage_vaue12 < 2) {
                            leftmassage_vaue12++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 6, leftmassage_vaue12}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int rightmassage_vaue12 = DataCanbus.DATA[110];
                        if (rightmassage_vaue12 < 2) {
                            rightmassage_vaue12++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 8, rightmassage_vaue12}, null, null);
                        break;
                    }
                case R.id.ford_seat_add_2 /* 2131427826 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int leftmassage_vaue22 = DataCanbus.DATA[106];
                        if (leftmassage_vaue22 < 2) {
                            leftmassage_vaue22++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 7, leftmassage_vaue22}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int rightmassage_vaue22 = DataCanbus.DATA[111];
                        if (rightmassage_vaue22 < 2) {
                            rightmassage_vaue22++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 9, rightmassage_vaue22}, null, null);
                        break;
                    }
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.ford_seat_sub1 /* 2131427817 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub2 /* 2131427818 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4}, null, null);
                        break;
                    }
                case R.id.ford_seat_sub3 /* 2131427819 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5}, null, null);
                        break;
                    }
                case R.id.ford_seat_add1 /* 2131427820 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3}, null, null);
                        break;
                    }
                case R.id.ford_seat_add2 /* 2131427821 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4}, null, null);
                        break;
                    }
                case R.id.ford_seat_add3 /* 2131427822 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2}, null, null);
                        break;
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5}, null, null);
                        break;
                    }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{100}, null, null);
        isFront = true;
        addNotify();
        if (this.pagenum == 0) {
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
            ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
            return;
        }
        if (this.pagenum == 1) {
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
            ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSeatValue() {
        int left_vaue1 = DataCanbus.DATA[102];
        int left_vaue2 = DataCanbus.DATA[103];
        int left_vaue3 = DataCanbus.DATA[104];
        int leftmassage_vaue1 = DataCanbus.DATA[105];
        int leftmassage_vaue2 = DataCanbus.DATA[106];
        int right_vaue1 = DataCanbus.DATA[107];
        int right_vaue2 = DataCanbus.DATA[108];
        int right_vaue3 = DataCanbus.DATA[109];
        int rightmassage_vaue1 = DataCanbus.DATA[110];
        int rightmassage_vaue2 = DataCanbus.DATA[111];
        if (this.pagenum == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(left_vaue1)).toString());
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(left_vaue2)).toString());
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(left_vaue3)).toString());
            switch (leftmassage_vaue1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                    break;
            }
            switch (leftmassage_vaue2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                    break;
            }
        }
        if (this.pagenum == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(right_vaue1)).toString());
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(right_vaue2)).toString());
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(right_vaue3)).toString());
            switch (rightmassage_vaue1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                    break;
            }
            switch (rightmassage_vaue2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                    break;
            }
        }
    }
}
