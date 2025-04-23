package com.syu.carinfo.psa;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class PsaAlarmRecordActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 114:
                    PsaAlarmRecordActi.this.mUpdaterValue1();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_psa_alarm_record);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(48, new int[]{1}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.psa_tv_alarm)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_1);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_4);
                    break;
                case 5:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_5);
                    break;
                case 8:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_8);
                    break;
                case 10:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_a);
                    break;
                case 11:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_b);
                    break;
                case 13:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_d);
                    break;
                case 15:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_f);
                    break;
                case 17:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_11);
                    break;
                case 18:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_12);
                    break;
                case 19:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_13);
                    break;
                case 20:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_14);
                    break;
                case 97:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_61);
                    break;
                case 98:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_62);
                    break;
                case 100:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_64);
                    break;
                case 103:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_67);
                    break;
                case 104:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_68);
                    break;
                case 105:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_69);
                    break;
                case 106:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_6a);
                    break;
                case 107:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_6b);
                    break;
                case 108:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_6c);
                    break;
                case 109:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_6d);
                    break;
                case 110:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_6e);
                    break;
                case 111:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_6f);
                    break;
                case 129:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_81);
                    break;
                case 131:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_83);
                    break;
                case 136:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_88);
                    break;
                case 137:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_89);
                    break;
                case 138:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_8a);
                    break;
                case 141:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_8d);
                    break;
                case 154:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_9a);
                    break;
                case 155:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_9b);
                    break;
                case 156:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_9c);
                    break;
                case 157:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_9d);
                    break;
                case 158:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_9e);
                    break;
                case 159:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_9f);
                    break;
                case 160:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_a0);
                    break;
                case 215:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_d7);
                    break;
                case 216:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_d8);
                    break;
                case 217:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_d9);
                    break;
                case 222:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_de);
                    break;
                case 223:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_df);
                    break;
                case 224:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_e0);
                    break;
                case 225:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_e1);
                    break;
                case 227:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_e3);
                    break;
                case 229:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_e5);
                    break;
                case 231:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_e7);
                    break;
                case 232:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_e8);
                    break;
                case 240:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_f0);
                    break;
                case 241:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_f1);
                    break;
                case 247:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_f7);
                    break;
                case 248:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_f8);
                    break;
                case 249:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_f9);
                    break;
                case 303:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_12f);
                    break;
                case 304:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_130);
                    break;
                case 305:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_131);
                    break;
                case 306:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_132);
                    break;
                case 307:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_133);
                    break;
                case 308:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_134);
                    break;
                case 506:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_1fa);
                    break;
                case 507:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_1fb);
                    break;
                case 508:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_1fc);
                    break;
                case 509:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_1fd);
                    break;
                case 510:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_1fe);
                    break;
                case 511:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_1ff);
                    break;
                case 512:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_200);
                    break;
                case 514:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_202);
                    break;
                case 515:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_203);
                    break;
                case 516:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_204);
                    break;
                case 517:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_205);
                    break;
                case 518:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_206);
                    break;
                case 521:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_209);
                    break;
                case 522:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_20a);
                    break;
                case 523:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_20b);
                    break;
                case 524:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_20c);
                    break;
                case 526:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_20e);
                    break;
                case 527:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_20f);
                    break;
                case 528:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_210);
                    break;
                case 529:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_211);
                    break;
                case 530:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_212);
                    break;
                case 531:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_213);
                    break;
                case 532:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_214);
                    break;
                case 533:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_215);
                    break;
                case 534:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_216);
                    break;
                case 535:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_217);
                    break;
                case 536:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_218);
                    break;
                case 537:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_219);
                    break;
                case 538:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_21A);
                    break;
                case 542:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_21E);
                    break;
                case 543:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_21F);
                    break;
                case 544:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_220);
                    break;
                case 545:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_221);
                    break;
                case 546:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_222);
                    break;
                case 547:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_223);
                    break;
                case 548:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_224);
                    break;
                case 549:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_225);
                    break;
                case 550:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_226);
                    break;
                case 551:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_227);
                    break;
                case 552:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_228);
                    break;
                case 554:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_22A);
                    break;
                case 558:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_22E);
                    break;
                case 559:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_22F);
                    break;
                case 560:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_230);
                    break;
                case 561:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_231);
                    break;
                case 562:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_232);
                    break;
                case 564:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_234);
                    break;
                case 565:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_235);
                    break;
                case 566:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_236);
                    break;
                case 567:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_237);
                    break;
                case 568:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_238);
                    break;
                case 569:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_239);
                    break;
                case 571:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_23B);
                    break;
                case 572:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_23C);
                    break;
                case 573:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_23D);
                    break;
                case 32767:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.bz408_warning_7fff);
                    break;
                default:
                    ((TextView) findViewById(R.id.psa_tv_alarm)).setText(R.string.start_stop_warning_14);
                    break;
            }
        }
    }
}
