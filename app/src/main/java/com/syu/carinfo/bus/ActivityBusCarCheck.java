package com.syu.carinfo.bus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityBusCarCheck extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        int value;

        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ActivityBusCarCheck.this.updateCarInfo0(this.value);
                    break;
                case 100:
                    ActivityBusCarCheck.this.updateCarInfo1(this.value);
                    break;
                case 101:
                    ActivityBusCarCheck.this.updateCarInfo2(this.value);
                    break;
                case 102:
                    ActivityBusCarCheck.this.updateCarInfo3(this.value);
                    break;
                case 103:
                    ActivityBusCarCheck.this.updateCarInfo4(this.value);
                    break;
                case 104:
                    ActivityBusCarCheck.this.updateCarInfo5(this.value);
                    break;
                case 105:
                    ActivityBusCarCheck.this.updateCarInfo6(this.value);
                    break;
                case 106:
                    ActivityBusCarCheck.this.updateCarInfo7(this.value);
                    break;
                case 107:
                    ActivityBusCarCheck.this.updateCarInfo8(this.value);
                    break;
                case 108:
                    ActivityBusCarCheck.this.updateCarInfo9(this.value);
                    break;
                case 109:
                    ActivityBusCarCheck.this.updateCarInfo10(this.value);
                    break;
                case 110:
                    ActivityBusCarCheck.this.updateCarInfo11(this.value);
                    break;
                case 111:
                    ActivityBusCarCheck.this.updateCarInfo12(this.value);
                    break;
                case 112:
                    ActivityBusCarCheck.this.updateCarInfo13(this.value);
                    break;
                case 113:
                    ActivityBusCarCheck.this.updateCarInfo14(this.value);
                    break;
                case 114:
                    ActivityBusCarCheck.this.updateCarInfo15(this.value);
                    break;
                case 115:
                    ActivityBusCarCheck.this.updateCarInfo16(this.value);
                    break;
                case 116:
                    ActivityBusCarCheck.this.updateCarInfo17(this.value);
                    break;
                case 117:
                    ActivityBusCarCheck.this.updateCarInfo18(this.value);
                    break;
                case 118:
                    ActivityBusCarCheck.this.updateCarInfo19(this.value);
                    break;
                case 119:
                    ActivityBusCarCheck.this.updateCarInfo20(this.value);
                    break;
                case 120:
                    ActivityBusCarCheck.this.updateCarInfo21(this.value);
                    break;
                case 121:
                    ActivityBusCarCheck.this.updateCarInfo22(this.value);
                    break;
                case 122:
                    ActivityBusCarCheck.this.updateCarInfo23(this.value);
                    break;
                case 123:
                    ActivityBusCarCheck.this.updateCarInfo24(this.value);
                    break;
                case 124:
                    ActivityBusCarCheck.this.updateCarInfo25(this.value);
                    break;
                case 125:
                    ActivityBusCarCheck.this.updateCarInfo26(this.value);
                    break;
                case 126:
                    ActivityBusCarCheck.this.updateCarInfo27(this.value);
                    break;
                case 127:
                    ActivityBusCarCheck.this.updateCarInfo28(this.value);
                    break;
                case 128:
                    ActivityBusCarCheck.this.updateCarInfo29(this.value);
                    break;
                case 129:
                    ActivityBusCarCheck.this.updateCarInfo30(this.value);
                    break;
                case 130:
                    ActivityBusCarCheck.this.updateCarInfo31(this.value);
                    break;
                case 131:
                    ActivityBusCarCheck.this.updateCarInfo32(this.value);
                    break;
                case 132:
                    ActivityBusCarCheck.this.updateCarInfo33(this.value);
                    break;
                case 133:
                    ActivityBusCarCheck.this.updateCarInfo34(this.value);
                    break;
                case 134:
                    ActivityBusCarCheck.this.updateCarInfo35(this.value);
                    break;
                case 135:
                    ActivityBusCarCheck.this.updateCarInfo36(this.value);
                    break;
                case 136:
                    ActivityBusCarCheck.this.updateCarInfo37(this.value);
                    break;
                case 137:
                    ActivityBusCarCheck.this.updateCarInfo38(this.value);
                    break;
                case 138:
                    ActivityBusCarCheck.this.updateCarInfo39(this.value);
                    break;
                case 139:
                    ActivityBusCarCheck.this.updateCarInfo40(this.value);
                    break;
                case 140:
                    ActivityBusCarCheck.this.updateCarInfo41(this.value);
                    break;
                case 141:
                    ActivityBusCarCheck.this.updateCarInfo42(this.value);
                    break;
                case 142:
                    ActivityBusCarCheck.this.updateCarInfo43(this.value);
                    break;
                case 143:
                    ActivityBusCarCheck.this.updateCarInfo44(this.value);
                    break;
                case 144:
                    ActivityBusCarCheck.this.updateCarInfo45(this.value);
                    break;
                case 145:
                    ActivityBusCarCheck.this.updateCarInfo46(this.value);
                    break;
                case 146:
                    ActivityBusCarCheck.this.updateCarInfo47(this.value);
                    break;
                case 147:
                    ActivityBusCarCheck.this.updateCarInfo48(this.value);
                    break;
                case 148:
                    ActivityBusCarCheck.this.updateCarInfo49(this.value);
                    break;
                case 149:
                    ActivityBusCarCheck.this.updateCarInfo50(this.value);
                    break;
                case 150:
                    ActivityBusCarCheck.this.updateCarInfo51(this.value);
                    break;
                case 151:
                    ActivityBusCarCheck.this.updateCarInfo52(this.value);
                    break;
                case 152:
                    ActivityBusCarCheck.this.updateCarInfo53(this.value);
                    break;
                case 153:
                    ActivityBusCarCheck.this.updateCarInfo54(this.value);
                    break;
                case 154:
                    ActivityBusCarCheck.this.updateCarInfo55(this.value);
                    break;
                case 155:
                    ActivityBusCarCheck.this.updateCarInfo56(this.value);
                    break;
                case 156:
                    ActivityBusCarCheck.this.updateCarInfo57(this.value);
                    break;
                case 157:
                    ActivityBusCarCheck.this.updateCarInfo58(this.value);
                    break;
                case 158:
                    ActivityBusCarCheck.this.updateCarInfo59(this.value);
                    break;
                case 159:
                    ActivityBusCarCheck.this.updateCarInfo60(this.value);
                    break;
                case 160:
                    ActivityBusCarCheck.this.updateCarInfo61(this.value);
                    break;
                case 161:
                    ActivityBusCarCheck.this.updateCarInfo62(this.value);
                    break;
                case 162:
                    ActivityBusCarCheck.this.updateCarInfo63(this.value);
                    break;
                case 163:
                    ActivityBusCarCheck.this.updateCarInfo64(this.value);
                    break;
                case 164:
                    ActivityBusCarCheck.this.updateCarInfo65(this.value);
                    break;
                case 165:
                    ActivityBusCarCheck.this.updateCarInfo66(this.value);
                    break;
                case 166:
                    ActivityBusCarCheck.this.updateCarInfo67(this.value);
                    break;
                case 167:
                    ActivityBusCarCheck.this.updateCarInfo68(this.value);
                    break;
                case 168:
                    ActivityBusCarCheck.this.updateCarInfo69(this.value);
                    break;
                case 169:
                    ActivityBusCarCheck.this.updateCarInfo70(this.value);
                    break;
                case 170:
                    ActivityBusCarCheck.this.updateCarInfo71(this.value);
                    break;
                case 171:
                    ActivityBusCarCheck.this.updateCarInfo72(this.value);
                    break;
                case 172:
                    ActivityBusCarCheck.this.updateCarInfo73(this.value);
                    break;
                case 173:
                    ActivityBusCarCheck.this.updateCarInfo74(this.value);
                    break;
                case 174:
                    ActivityBusCarCheck.this.updateCarInfo75(this.value);
                    break;
                case 175:
                    ActivityBusCarCheck.this.updateCarInfo76(this.value);
                    break;
                case 176:
                    ActivityBusCarCheck.this.updateCarInfo77(this.value);
                    break;
                case 177:
                    ActivityBusCarCheck.this.updateCarInfo78(this.value);
                    break;
                case 178:
                    ActivityBusCarCheck.this.updateCarInfo79(this.value);
                    break;
                case 179:
                    ActivityBusCarCheck.this.updateCarInfo80(this.value);
                    break;
                case 180:
                    ActivityBusCarCheck.this.updateCarInfo81(this.value);
                    break;
                case 181:
                    ActivityBusCarCheck.this.updateCarInfo82(this.value);
                    break;
                case 182:
                    ActivityBusCarCheck.this.updateCarInfo83(this.value);
                    break;
                case 183:
                    ActivityBusCarCheck.this.updateCarInfo84(this.value);
                    break;
                case 184:
                    ActivityBusCarCheck.this.updateCarInfo85(this.value);
                    break;
                case 185:
                    ActivityBusCarCheck.this.updateCarInfo86(this.value);
                    break;
                case 186:
                    ActivityBusCarCheck.this.updateCarInfo87(this.value);
                    break;
                case 187:
                    ActivityBusCarCheck.this.updateCarInfo88(this.value);
                    break;
                case 188:
                    ActivityBusCarCheck.this.updateCarInfo89(this.value);
                    break;
                case 189:
                    ActivityBusCarCheck.this.updateCarInfo90(this.value);
                    break;
                case 190:
                    ActivityBusCarCheck.this.updateCarInfo91(this.value);
                    break;
                case 191:
                    ActivityBusCarCheck.this.updateCarInfo92(this.value);
                    break;
                case 192:
                    ActivityBusCarCheck.this.updateCarInfo93(this.value);
                    break;
                case 193:
                    ActivityBusCarCheck.this.updateCarInfo94(this.value);
                    break;
                case 194:
                    ActivityBusCarCheck.this.updateCarInfo95(this.value);
                    break;
                case 195:
                    ActivityBusCarCheck.this.updateCarInfo96(this.value);
                    break;
                case 196:
                    ActivityBusCarCheck.this.updateCarInfo97(this.value);
                    break;
                case 197:
                    ActivityBusCarCheck.this.updateCarInfo98(this.value);
                    break;
                case 198:
                    ActivityBusCarCheck.this.updateCarInfo99(this.value);
                    break;
                case 199:
                    ActivityBusCarCheck.this.updateCarInfo100(this.value);
                    break;
                case 200:
                    ActivityBusCarCheck.this.updateCarInfo101(this.value);
                    break;
                case 201:
                    ActivityBusCarCheck.this.updateCarInfo102(this.value);
                    break;
                case 202:
                    ActivityBusCarCheck.this.updateCarInfo103(this.value);
                    break;
                case 203:
                    ActivityBusCarCheck.this.updateCarInfo104(this.value);
                    break;
                case 204:
                    ActivityBusCarCheck.this.updateCarInfo105(this.value);
                    break;
                case 205:
                    ActivityBusCarCheck.this.updateCarInfo106(this.value);
                    break;
                case 206:
                    ActivityBusCarCheck.this.updateCarInfo107(this.value);
                    break;
                case 207:
                    ActivityBusCarCheck.this.updateCarInfo108(this.value);
                    break;
                case 208:
                    ActivityBusCarCheck.this.updateCarInfo109(this.value);
                    break;
                case 209:
                    ActivityBusCarCheck.this.updateCarInfo110(this.value);
                    break;
                case 210:
                    ActivityBusCarCheck.this.updateCarInfo111(this.value);
                    break;
                case 211:
                    ActivityBusCarCheck.this.updateCarInfo112(this.value);
                    break;
                case 212:
                    ActivityBusCarCheck.this.updateCarInfo113(this.value);
                    break;
                case 213:
                    ActivityBusCarCheck.this.updateCarInfo114(this.value);
                    break;
                case 214:
                    ActivityBusCarCheck.this.updateCarInfo115(this.value);
                    break;
                case 215:
                    ActivityBusCarCheck.this.updateCarInfo116(this.value);
                    break;
                case 216:
                    ActivityBusCarCheck.this.updateCarInfo117(this.value);
                    break;
                case 217:
                    ActivityBusCarCheck.this.updateCarInfo118(this.value);
                    break;
                case 218:
                    ActivityBusCarCheck.this.updateCarInfo119(this.value);
                    break;
                case 219:
                    ActivityBusCarCheck.this.updateCarInfo120(this.value);
                    break;
                case 220:
                    ActivityBusCarCheck.this.updateCarInfo121(this.value);
                    break;
                case 221:
                    ActivityBusCarCheck.this.updateCarInfo122(this.value);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_408_car_check_state);
        init();
    }

    private void init() {
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
        for (int i = 99; i <= 221; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeNotify() {
        for (int i = 99; i <= 221; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void updateCarInfo0(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_0)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_0), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_0)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_0)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_0)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_0)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo1(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_1)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_1), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_1)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_1)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_1)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_1)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo2(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_2)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_2), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_2)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_2)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_2)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_2)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo3(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_3)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_3), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_3)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_3)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_3)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_3)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo4(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_4)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_4), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_4)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_4)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_4)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_4)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo5(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_5)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_5), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_5)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_5)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_5)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_5)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo6(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_6)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_6), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_6)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_6)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_6)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_6)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo7(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_7)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_7), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_7)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_7)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_7)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_7)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo8(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_8)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_8), value);
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_408_carinfo_8)).setText(R.string.str_408_car_error_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_408_carinfo_8)).setText(R.string.str_408_car_error_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_408_carinfo_8)).setText(R.string.str_408_car_error_level_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_408_carinfo_8)).setText(R.string.str_408_car_error_level_0);
                    break;
            }
        }
    }

    
    public void updateCarInfo9(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_9)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_9), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_9)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo10(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_10)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_10), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_10)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo11(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_11)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_11), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_11)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo12(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_12)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_12), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_12)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo13(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_13)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_13), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_13)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo14(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_14)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_14), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_14)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo15(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_15)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_15), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_15)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo16(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_16)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_16), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_16)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo17(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_17)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_17), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_17)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo18(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_18)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_18), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_18)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo19(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_19)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_19), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_19)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo20(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_20)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_20), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_20)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo21(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_21)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_21), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_21)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo22(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_22)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_22), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_22)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo23(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_23)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_23), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_23)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo24(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_24)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_24), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_24)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo25(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_25)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_25), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_25)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo26(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_26)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_26), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_26)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo27(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_27)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_27), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_27)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo28(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_28)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_28), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_28)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo29(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_29)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_29), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_29)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo30(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_30)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_30), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_30)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo31(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_31)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_31), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_31)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo32(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_32)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_32), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_32)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo33(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_33)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_33), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_33)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo34(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_34)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_34), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_34)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo35(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_35)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_35), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_35)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo36(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_36)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_36), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_36)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo37(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_37)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_37), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_37)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo38(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_38)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_38), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_38)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo39(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_39)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_39), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_39)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo40(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_40)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_40), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_40)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo41(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_41)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_41), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_41)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo42(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_42)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_42), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_42)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo43(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_43)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_43), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_43)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo44(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_44)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_44), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_44)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo45(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_45)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_45), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_45)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo46(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_46)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_46), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_46)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo47(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_47)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_47), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_47)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo48(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_48)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_48), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_48)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo49(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_49)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_49), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_49)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo50(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_50)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_50), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_50)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo51(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_51)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_51), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_51)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo52(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_52)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_52), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_52)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo53(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_53)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_53), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_53)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo54(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_54)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_54), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_54)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo55(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_55)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_55), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_55)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo56(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_56)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_56), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_56)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo57(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_57)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_57), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_57)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo58(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_58)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_58), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_58)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo59(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_59)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_59), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_59)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo60(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_60)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_60), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_60)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo61(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_61)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_61), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_61)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo62(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_62)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_62), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_62)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo63(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_63)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_63), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_63)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo64(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_64)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_64), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_64)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo65(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_65)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_65), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_65)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo66(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_66)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_66), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_66)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo67(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_67)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_67), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_67)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo68(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_68)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_68), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_68)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo69(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_69)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_69), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_69)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo70(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_70)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_70), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_70)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo71(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_71)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_71), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_71)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo72(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_72)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_72), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_72)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo73(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_73)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_73), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_73)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo74(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_74)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_74), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_74)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo75(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_75)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_75), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_75)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo76(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_76)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_76), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_76)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo77(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_77)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_77), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_77)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo78(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_78)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_78), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_78)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo79(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_79)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_79), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_79)).setText(value == 1 ? R.string.str_408_carinfo_79_1 : R.string.normal);
        }
    }

    
    public void updateCarInfo80(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_80)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_80), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_80)).setText(value == 1 ? R.string.str_408_carinfo_80_1 : R.string.str_408_carinfo_80_0);
        }
    }

    
    public void updateCarInfo81(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_81)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_81), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_81)).setText(value == 1 ? R.string.str_408_carinfo_81_1 : R.string.str_408_carinfo_81_0);
        }
    }

    
    public void updateCarInfo82(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_82)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_82), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_82)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo83(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_83)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_83), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_83)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo84(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_84)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_84), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_84)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo85(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_85)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_85), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_85)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo86(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_86)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_86), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_86)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo87(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_87)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_87), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_87)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo88(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_88)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_88), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_88)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo89(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_89)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_89), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_89)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo90(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_90)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_90), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_90)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo91(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_91)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_91), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_91)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo92(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_92)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_92), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_92)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo93(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_93)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_93), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_93)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo94(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_94)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_94), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_94)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo95(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_95)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_95), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_95)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo96(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_96)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_96), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_96)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo97(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_97)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_97), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_97)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo98(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_98)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_98), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_98)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo99(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_99)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_99), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_99)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo100(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_100)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_100), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_100)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo101(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_101)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_101), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_101)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo102(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_102)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_102), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_102)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo103(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_103)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_103), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_103)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo104(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_104)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_104), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_104)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo105(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_105)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_105), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_105)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo106(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_106)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_106), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_106)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo107(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_107)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_107), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_107)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo108(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_108)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_108), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_108)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo109(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_109)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_109), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_109)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo110(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_110)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_110), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_110)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo111(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_111)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_111), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_111)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo112(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_112)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_112), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_112)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo113(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_113)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_113), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_113)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo114(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_114)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_114), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_114)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo115(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_115)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_115), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_115)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo116(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_116)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_116), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_116)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo117(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_117)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_117), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_117)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo118(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_118)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_118), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_118)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo119(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_119)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_119), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_119)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo120(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_120)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_120), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_120)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo121(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_121)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_121), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_121)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    
    public void updateCarInfo122(int value) {
        if (((TextView) findViewById(R.id.tv_408_carinfo_122)) != null) {
            setTextViewColor((TextView) findViewById(R.id.tv_408_carinfo_122), value);
            ((TextView) findViewById(R.id.tv_408_carinfo_122)).setText(value == 1 ? R.string.str_pack_break_down : R.string.normal);
        }
    }

    public void setTextViewColor(TextView mText, int value) {
        if (mText != null) {
            mText.setTextColor(value == 0 ? -16777216 : -65536);
        }
    }
}
