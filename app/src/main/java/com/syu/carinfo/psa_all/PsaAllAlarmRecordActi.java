package com.syu.carinfo.psa_all;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PsaAllAlarmRecordActi extends BaseActivity {
    public static PsaAllAlarmRecordActi mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    PsaAllAlarmRecordActi.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_all_alarm_record);
        mInstance = this;
    }

    public void updateUpdaterValue120() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_4);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_5);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_8);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_a);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_b);
                    break;
                case 13:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d);
                    break;
                case 15:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f);
                    break;
                case 17:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_11);
                    break;
                case 18:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_12);
                    break;
                case 19:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_13);
                    break;
                case 20:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_14);
                    break;
                case 97:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_61);
                    break;
                case 98:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_62);
                    break;
                case 100:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_64);
                    break;
                case 103:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_67);
                    break;
                case 104:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_68);
                    break;
                case 105:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_69);
                    break;
                case 106:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6a);
                    break;
                case 107:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6b);
                    break;
                case 108:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6c);
                    break;
                case 109:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6d);
                    break;
                case 110:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6e);
                    break;
                case 111:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6f);
                    break;
                case 129:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_81);
                    break;
                case 131:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_83);
                    break;
                case 136:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_88);
                    break;
                case 137:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_89);
                    break;
                case 138:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_8a);
                    break;
                case 141:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_8d);
                    break;
                case 154:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9a);
                    break;
                case 155:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9b);
                    break;
                case 156:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9c);
                    break;
                case 157:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9d);
                    break;
                case 158:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9e);
                    break;
                case 159:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9f);
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_a0);
                    break;
                case 215:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d7);
                    break;
                case 216:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d8);
                    break;
                case 217:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d9);
                    break;
                case 222:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_de);
                    break;
                case 223:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_df);
                    break;
                case 224:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e0);
                    break;
                case 225:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e1);
                    break;
                case 227:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e3);
                    break;
                case 229:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e5);
                    break;
                case 231:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e7);
                    break;
                case 232:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e8);
                    break;
                case 240:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f0);
                    break;
                case 241:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f1);
                    break;
                case 247:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f7);
                    break;
                case 248:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f8);
                    break;
                case 249:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f9);
                    break;
                case 303:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_12f);
                    break;
                case 304:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_130);
                    break;
                case 305:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_131);
                    break;
                case 306:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_132);
                    break;
                case 307:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_133);
                    break;
                case 308:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_134);
                    break;
                case 506:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fa);
                    break;
                case 507:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fb);
                    break;
                case 508:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fc);
                    break;
                case 509:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fd);
                    break;
                case 510:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fe);
                    break;
                case 511:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1ff);
                    break;
                case 512:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_200);
                    break;
                case 514:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_202);
                    break;
                case 515:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_203);
                    break;
                case 516:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_204);
                    break;
                case 517:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_205);
                    break;
                case 518:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_206);
                    break;
                case 521:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_209);
                    break;
                case 522:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_20a);
                    break;
                case 523:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_20b);
                    break;
                case 32767:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_7fff);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.start_stop_warning_14);
                    break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[107];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_4);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_5);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_8);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_a);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_b);
                    break;
                case 13:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d);
                    break;
                case 15:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f);
                    break;
                case 17:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_11);
                    break;
                case 18:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_12);
                    break;
                case 19:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_13);
                    break;
                case 20:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_14);
                    break;
                case 97:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_61);
                    break;
                case 98:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_62);
                    break;
                case 100:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_64);
                    break;
                case 103:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_67);
                    break;
                case 104:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_68);
                    break;
                case 105:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_69);
                    break;
                case 106:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6a);
                    break;
                case 107:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6b);
                    break;
                case 108:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6c);
                    break;
                case 109:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6d);
                    break;
                case 110:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6e);
                    break;
                case 111:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_6f);
                    break;
                case 129:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_81);
                    break;
                case 131:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_83);
                    break;
                case 136:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_88);
                    break;
                case 137:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_89);
                    break;
                case 138:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_8a);
                    break;
                case 141:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_8d);
                    break;
                case 154:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9a);
                    break;
                case 155:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9b);
                    break;
                case 156:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9c);
                    break;
                case 157:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9d);
                    break;
                case 158:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9e);
                    break;
                case 159:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_9f);
                    break;
                case 160:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_a0);
                    break;
                case 215:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d7);
                    break;
                case 216:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d8);
                    break;
                case 217:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_d9);
                    break;
                case 222:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_de);
                    break;
                case 223:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_df);
                    break;
                case 224:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e0);
                    break;
                case 225:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e1);
                    break;
                case 227:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e3);
                    break;
                case 229:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e5);
                    break;
                case 231:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e7);
                    break;
                case 232:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_e8);
                    break;
                case 240:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f0);
                    break;
                case 241:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f1);
                    break;
                case 247:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f7);
                    break;
                case 248:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f8);
                    break;
                case 249:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_f9);
                    break;
                case 303:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_12f);
                    break;
                case 304:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_130);
                    break;
                case 305:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_131);
                    break;
                case 306:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_132);
                    break;
                case 307:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_133);
                    break;
                case 308:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_134);
                    break;
                case 506:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fa);
                    break;
                case 507:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fb);
                    break;
                case 508:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fc);
                    break;
                case 509:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fd);
                    break;
                case 510:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1fe);
                    break;
                case 511:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_1ff);
                    break;
                case 512:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_200);
                    break;
                case 514:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_202);
                    break;
                case 515:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_203);
                    break;
                case 516:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_204);
                    break;
                case 517:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_205);
                    break;
                case 518:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_206);
                    break;
                case 521:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_209);
                    break;
                case 522:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_20a);
                    break;
                case 523:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_20b);
                    break;
                case 32767:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.bz408_warning_7fff);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.start_stop_warning_14);
                    break;
            }
        }
    }
}
