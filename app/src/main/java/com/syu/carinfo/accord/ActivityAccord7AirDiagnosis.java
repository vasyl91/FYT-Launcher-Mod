package com.syu.carinfo.accord;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityAccord7AirDiagnosis extends Activity {
    IUiNotify mCanbusNotify = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 100:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text1), value);
                    break;
                case 101:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text2), value);
                    break;
                case 102:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text3), value);
                    break;
                case 103:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text4), value);
                    break;
                case 104:
                    updateMotorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text5), value);
                    break;
                case 105:
                    updateMotorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text6), value);
                    break;
                case 106:
                    updateMotorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text7), value);
                    break;
                case 107:
                    updateBlowerMotor(value);
                    break;
                case 108:
                    updateAirMixOpenDegreeState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text9), value);
                    break;
                case 109:
                    updateAirMixOpenDegreeState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text10), value);
                    break;
                case 110:
                    updateSunlightLevel((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text11), value);
                    break;
                case 111:
                    updateCarTemp((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text12), value);
                    break;
                case 112:
                    updateCarTemp((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text13), value);
                    break;
                case 113:
                    updateEnginerCoolant((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text14), value);
                    break;
            }
        }

        private void updateEnginerCoolant(TextView mText, int value) {
            if (mText != null) {
                if (value >= 0 && value <= 130) {
                    mText.setText(String.valueOf(value) + " ℃");
                } else if (value == -255) {
                    mText.setText("Er");
                } else {
                    mText.setText("");
                }
            }
        }

        private void updateCarTemp(TextView mText, int value) {
            if (mText != null) {
                if (value >= -40 && value <= 85 && value != 0) {
                    mText.setText(String.valueOf(value) + " ℃");
                } else if (value == -41) {
                    mText.setText("Er");
                } else {
                    mText.setText("");
                }
            }
        }

        public void updateSunlightLevel(TextView mText, int value) {
            if (mText != null) {
                if (value >= 0 && value <= 109) {
                    mText.setText(String.valueOf(value) + " Kcal/m2.h");
                } else if (value == 110) {
                    mText.setText("Er");
                } else {
                    mText.setText("");
                }
            }
        }

        private void updateAirMixOpenDegreeState(TextView mText, int value) {
            if (mText != null) {
                if (value >= 0 && value <= 100) {
                    mText.setText(String.valueOf(value) + " %");
                } else if (value == 101) {
                    mText.setText("Er");
                } else {
                    mText.setText("");
                }
            }
        }

        private void updateBlowerMotor(int value) {
            if (((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text8)) != null) {
                if (value == 1) {
                    ((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text8)).setText(R.string.str_pack_break_down);
                } else {
                    ((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text8)).setText("");
                }
            }
        }

        private void updateSensorState(TextView mText, int value) {
            if (mText != null) {
                if (value == 1) {
                    mText.setText(R.string.str_274_sensor_open_circuit);
                } else if (value == 2) {
                    mText.setText(R.string.str_274_sensor_close_circuit);
                } else {
                    mText.setText("");
                }
            }
        }

        private void updateMotorState(TextView mText, int value) {
            if (mText != null) {
                if (value == 1) {
                    mText.setText(R.string.str_274_motor_open_circuit);
                    return;
                }
                if (value == 2) {
                    mText.setText(R.string.str_274_motor_close_circuit);
                } else if (value == 3) {
                    mText.setText(R.string.str_274_throttle_motor_close_circuit);
                } else {
                    mText.setText("");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_274_accord7_air_diagnosis);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mCanbusNotify);
    }
}
