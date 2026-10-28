package com.syu.carinfo.oudi.changan;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class OdChanganTireAct extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.changan.OdChanganTireAct.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:54:0x0197  */
        /* JADX WARN: Code duplicated, block: B:57:0x01b0  */
        /* JADX WARN: Code duplicated, block: B:60:0x01c9  */
        /* JADX WARN: Code duplicated, block: B:63:0x01e2  */
        /* JADX WARN: Code duplicated, block: B:66:0x01fb  */
        /* JADX WARN: Code duplicated, block: B:69:0x0214  */
        /* JADX WARN: Code duplicated, block: B:72:0x022d  */
        /* JADX WARN: Code duplicated, block: B:74:0x0252  */
        /* JADX WARN: Code duplicated, block: B:75:0x0264  */
        /* JADX WARN: Code duplicated, block: B:76:0x0276  */
        /* JADX WARN: Code duplicated, block: B:77:0x0288  */
        /* JADX WARN: Code duplicated, block: B:79:0x0290  */
        /* JADX WARN: Code duplicated, block: B:80:0x02a0  */
        /* JADX WARN: Code duplicated, block: B:81:0x02b2  */
        /* JADX WARN: Code duplicated, block: B:83:0x02ba  */
        /* JADX WARN: Code duplicated, block: B:84:0x02ca  */
        /* JADX WARN: Code duplicated, block: B:85:0x02dc  */
        /* JADX WARN: Code duplicated, block: B:87:0x02e4  */
        /* JADX WARN: Code duplicated, block: B:88:0x02f4  */
        /* JADX WARN: Code duplicated, block: B:89:0x0306  */
        /* JADX WARN: Code duplicated, block: B:91:0x030e  */
        /* JADX WARN: Code duplicated, block: B:92:0x031e  */
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 1:
                    OdChanganTireAct.this.updaterTempFL();
                    break;
                case 2:
                    OdChanganTireAct.this.updaterTempFR();
                    break;
                case 3:
                    OdChanganTireAct.this.updaterTempRL();
                    break;
                case 4:
                    OdChanganTireAct.this.updaterTempRR();
                    break;
                case 5:
                    OdChanganTireAct.this.mUpdaterTireFL();
                    break;
                case 6:
                    OdChanganTireAct.this.mUpdaterTireFR();
                    break;
                case 7:
                    OdChanganTireAct.this.mUpdaterTireRL();
                    break;
                case 8:
                    OdChanganTireAct.this.mUpdaterTireRR();
                    break;
                case 9:
                case 10:
                case 11:
                    OdChanganTireAct.this.updaterFLWalm();
                    break;
                case 12:
                case 13:
                case 14:
                    OdChanganTireAct.this.updaterFRWalm();
                    break;
                case 15:
                case 16:
                case 17:
                    OdChanganTireAct.this.updaterRLWalm();
                    break;
                case 18:
                case 19:
                case 20:
                    OdChanganTireAct.this.updaterRRWalm();
                    break;
                case 21:
                case 22:
                case 23:
                case 28:
                case 29:
                    OdChanganTireAct.this.updaterFLWalm2();
                    break;
                case 25:
                    if (DataCanbus.DATA[25] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top)).setText("----");
                    }
                    if (DataCanbus.DATA[36] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[47] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[58] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[30] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[31] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[52] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[53] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 26:
                case 27:
                    if (DataCanbus.DATA[27] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[26] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_temp)).setTextColor(-1);
                    }
                    break;
                case 30:
                case 31:
                    if (DataCanbus.DATA[30] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[31] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[52] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[53] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 32:
                case 33:
                case 34:
                case 39:
                case 40:
                    OdChanganTireAct.this.updaterFRWalm2();
                    break;
                case 36:
                    if (DataCanbus.DATA[36] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top)).setText("----");
                    }
                    if (DataCanbus.DATA[47] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[58] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[30] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[31] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[52] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[53] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 37:
                case 38:
                    if (DataCanbus.DATA[38] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[37] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_temp)).setTextColor(-1);
                    }
                    break;
                case 41:
                case 42:
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[52] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[53] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 43:
                case 44:
                case 45:
                case 50:
                case 51:
                    OdChanganTireAct.this.updaterRLWalm2();
                    break;
                case 47:
                    if (DataCanbus.DATA[47] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top)).setText("----");
                    }
                    if (DataCanbus.DATA[58] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[30] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[31] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[52] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[53] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 48:
                case 49:
                    if (DataCanbus.DATA[49] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[48] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_temp)).setTextColor(-1);
                    }
                    break;
                case 52:
                case 53:
                    if (DataCanbus.DATA[52] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[53] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 54:
                case 55:
                case 56:
                case 61:
                case 62:
                    OdChanganTireAct.this.updaterRRWalm2();
                    break;
                case 58:
                    if (DataCanbus.DATA[58] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText(R.string.str_376_sensor_battery_low);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top)).setText("----");
                    }
                    if (DataCanbus.DATA[30] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[31] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire1_top1)).setText("");
                    }
                    if (DataCanbus.DATA[41] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[42] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire2_top1)).setText("");
                    }
                    if (DataCanbus.DATA[52] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[53] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire3_top1)).setText("");
                    }
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
                case 59:
                case 60:
                    if (DataCanbus.DATA[60] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-65536);
                    } else if (DataCanbus.DATA[59] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-256);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_temp)).setTextColor(-1);
                    }
                    break;
                case 63:
                case 64:
                    if (DataCanbus.DATA[63] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str3);
                    } else if (DataCanbus.DATA[64] == 1) {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText(R.string.wc_damaix5_str2);
                    } else {
                        ((TextView) OdChanganTireAct.this.findViewById(R.id.oudi_changan_tire4_top1)).setText("");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        if (DataCanbus.sCanbusId == 786871) {
            DataCanbus.NOTIFY_EVENTS[9].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[16].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[17].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[18].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[19].addNotify(this.notifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[32].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[33].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        if (DataCanbus.sCanbusId == 786871) {
            DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.notifyCanbus);
            DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[32].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[33].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm2() {
        int system = DataCanbus.DATA[21];
        int system1 = DataCanbus.DATA[22];
        int system2 = DataCanbus.DATA[23];
        int value = DataCanbus.DATA[28];
        int value1 = DataCanbus.DATA[29];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm2() {
        int system = DataCanbus.DATA[32];
        int system1 = DataCanbus.DATA[33];
        int system2 = DataCanbus.DATA[34];
        int value = DataCanbus.DATA[39];
        int value1 = DataCanbus.DATA[40];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm2() {
        int system = DataCanbus.DATA[43];
        int system1 = DataCanbus.DATA[44];
        int system2 = DataCanbus.DATA[45];
        int value = DataCanbus.DATA[50];
        int value1 = DataCanbus.DATA[51];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm2() {
        int system = DataCanbus.DATA[54];
        int system1 = DataCanbus.DATA[55];
        int system2 = DataCanbus.DATA[56];
        int value = DataCanbus.DATA[61];
        int value1 = DataCanbus.DATA[62];
        if (system == 1 || system1 == 1 || system2 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[1];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[2];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[3];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[4];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value - 40)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[5];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (((double) value) * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[6];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (((double) value) * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[7];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (((double) value) * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[8];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
            return;
        }
        if (DataCanbus.sCanbusId == 786871) {
            int value2 = (int) (((double) value) * 1.373d * 100.0d);
            if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
                DecimalFormat df = new DecimalFormat("#.#");
                ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value2 / 100.0f)) + "Kpa");
                return;
            }
            return;
        }
        if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[9];
        int value = DataCanbus.DATA[10];
        int value1 = DataCanbus.DATA[11];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[12];
        int value = DataCanbus.DATA[13];
        int value1 = DataCanbus.DATA[14];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[15];
        int value = DataCanbus.DATA[16];
        int value1 = DataCanbus.DATA[17];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[18];
        int value = DataCanbus.DATA[19];
        int value1 = DataCanbus.DATA[20];
        if (system == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }
}
