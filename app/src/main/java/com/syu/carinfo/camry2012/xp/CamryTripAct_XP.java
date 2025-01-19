package com.syu.carinfo.camry2012.xp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class CamryTripAct_XP extends BaseActivity {
    private VerticalProgressbar[] mProgressbar = new VerticalProgressbar[15];
    private TextView[] mOilTv = new TextView[4];
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 101:
                    CamryTripAct_XP.this.mUpdaterAveragVelocity();
                    break;
                case 103:
                    CamryTripAct_XP.this.mUpdaterDrivingMileage();
                    break;
                case 104:
                    CamryTripAct_XP.this.mUpdaterOilExpend();
                    break;
                case 135:
                    if (ints != null) {
                        CamryTripAct_XP.this.mUpdaterOilValue(ints);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_trip);
        init();
    }

    @Override
    public void init() {
        this.mProgressbar[0] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_0);
        this.mProgressbar[1] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_1);
        this.mProgressbar[2] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_2);
        this.mProgressbar[3] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_3);
        this.mProgressbar[4] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_4);
        this.mProgressbar[5] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_5);
        this.mProgressbar[6] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_6);
        this.mProgressbar[7] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_7);
        this.mProgressbar[8] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_8);
        this.mProgressbar[9] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_9);
        this.mProgressbar[10] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_10);
        this.mProgressbar[11] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_11);
        this.mProgressbar[12] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_12);
        this.mProgressbar[13] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_13);
        this.mProgressbar[14] = (VerticalProgressbar) findViewById(R.id.camry_progressbar_14);
        this.mOilTv[0] = (TextView) findViewById(R.id.camry_tv_oil_0);
        this.mOilTv[1] = (TextView) findViewById(R.id.camry_tv_oil_1);
        this.mOilTv[2] = (TextView) findViewById(R.id.camry_tv_oil_2);
        this.mOilTv[3] = (TextView) findViewById(R.id.camry_tv_oil_3);
        findViewById(R.id.camry_btn_clear).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(10, null, null, null);
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }

    private void mUpdataOilUnit(int unit) {
        if (((TextView) findViewById(R.id.camry_tv_oil_unit)) != null) {
            if (unit == 0) {
                ((TextView) findViewById(R.id.camry_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_MPG);
            } else if (unit == 1) {
                ((TextView) findViewById(R.id.camry_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_KM_PER_L);
            } else if (unit == 2) {
                ((TextView) findViewById(R.id.camry_tv_oil_unit)).setText(CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
            }
        }
    }

    
    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[104];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        int numMax = 30;
        mUpdataOilUnit(unit);
        if (num != 65535) {
            if (unit == 0) {
                numMax = 60;
                for (int i = 0; i < 4; i++) {
                    if (this.mOilTv[i] != null) {
                        this.mOilTv[i].setText(new StringBuilder().append(CamryData.mOilNum1[i]).toString());
                    }
                }
            } else if (unit == 1) {
                numMax = 30;
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this.mOilTv[i2] != null) {
                        this.mOilTv[i2].setText(new StringBuilder().append(CamryData.mOilNum0[i2]).toString());
                    }
                }
            } else if (unit == 2) {
                numMax = 30;
                for (int i3 = 0; i3 < 4; i3++) {
                    if (this.mOilTv[i3] != null) {
                        this.mOilTv[i3].setText(new StringBuilder().append(CamryData.mOilNum0[i3]).toString());
                    }
                }
            }
            if (((VerticalProgressbar) findViewById(R.id.camry_progressbar_cur)) != null) {
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_cur)).setMax(numMax * 10);
                if (num < 0) {
                    num = 0;
                } else if (num > numMax * 10) {
                    num = numMax * 10;
                }
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_cur)).setProgress(num);
                ((VerticalProgressbar) findViewById(R.id.camry_progressbar_cur)).invalidate();
                return;
            }
            return;
        }
        ((VerticalProgressbar) findViewById(R.id.camry_progressbar_cur)).setProgress(0);
        ((VerticalProgressbar) findViewById(R.id.camry_progressbar_cur)).invalidate();
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (unit == 2) {
            str = String.valueOf(num) + " " + CamryData.MILEAGE_UNIT_KM;
        } else if (unit == 1) {
            str = String.valueOf(num) + " " + CamryData.MILEAGE_UNIT_MILE;
        } else if (unit == 0) {
            str = String.valueOf(num) + " ";
        }
        if (num > 9999 || num < 0) {
            if (((TextView) findViewById(R.id.camry_tv_driving_mileage)) != null) {
                ((TextView) findViewById(R.id.camry_tv_driving_mileage)).setText("----");
            }
        } else if (((TextView) findViewById(R.id.camry_tv_driving_mileage)) != null) {
            ((TextView) findViewById(R.id.camry_tv_driving_mileage)).setText(str);
        }
    }

    
    public void mUpdaterAveragVelocity() {
        int value = DataCanbus.DATA[101];
        int unit = (value >> 24) & 255;
        int num = value & 16777215;
        String str = "";
        if (unit == 2) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.SPEED_UNIT_KM;
        } else if (unit == 1) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " " + CamryData.SPEED_UNIT_MILE;
        } else if (unit == 0) {
            str = String.valueOf(String.format("%d.%d", Integer.valueOf(num / 10), Integer.valueOf(num % 10))) + " ";
        }
        if (((TextView) findViewById(R.id.camry_tv_average_velocity)) != null) {
            ((TextView) findViewById(R.id.camry_tv_average_velocity)).setText(str);
        }
    }

    
    public void mUpdaterOilValue(int[] ints) {
        if (ints[0] > -1 && ints[0] < 30) {
            int value = ints[1];
            int unit = (value >> 24) & 255;
            int num = value & 16777215;
            int numMax = 30;
            mUpdataOilUnit(unit);
            if (num != 65535) {
                if (unit == 0) {
                    numMax = 60;
                } else if (unit == 1) {
                    numMax = 30;
                } else if (unit == 2) {
                    numMax = 30;
                }
                if (this.mProgressbar[ints[0]] != null) {
                    this.mProgressbar[ints[0]].setMax(numMax * 10);
                    if (num < 0) {
                        num = 0;
                    } else if (num > numMax * 10) {
                        num = numMax * 10;
                    }
                    this.mProgressbar[ints[0]].setProgress(num);
                    this.mProgressbar[ints[0]].invalidate();
                    return;
                }
                return;
            }
            this.mProgressbar[ints[0]].setProgress(0);
            this.mProgressbar[ints[0]].invalidate();
        }
    }
}
