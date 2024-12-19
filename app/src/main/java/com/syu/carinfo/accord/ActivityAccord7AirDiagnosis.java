package com.syu.carinfo.accord;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityAccord7AirDiagnosis extends Activity {
    IUiNotify mCanbusNotify = new IUiNotify() { // from class: com.syu.carinfo.accord.ActivityAccord7AirDiagnosis.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 50:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text1), value);
                    break;
                case 51:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text2), value);
                    break;
                case 52:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text3), value);
                    break;
                case 53:
                    updateSensorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text4), value);
                    break;
                case 54:
                    updateMotorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text5), value);
                    break;
                case 55:
                    updateMotorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text6), value);
                    break;
                case 56:
                    updateMotorState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text7), value);
                    break;
                case 57:
                    updateBlowerMotor(value);
                    break;
                case 58:
                    updateAirMixOpenDegreeState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text9), value);
                    break;
                case 59:
                    updateAirMixOpenDegreeState((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text10), value);
                    break;
                case 60:
                    updateSunlightLevel((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text11), value);
                    break;
                case 61:
                    updateCarTemp((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text12), value);
                    break;
                case 62:
                    updateCarTemp((TextView) ActivityAccord7AirDiagnosis.this.findViewById(R.id.tv_text13), value);
                    break;
                case 63:
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

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_274_accord7_air_diagnosis);
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
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mCanbusNotify, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mCanbusNotify, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mCanbusNotify);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mCanbusNotify);
    }
}
