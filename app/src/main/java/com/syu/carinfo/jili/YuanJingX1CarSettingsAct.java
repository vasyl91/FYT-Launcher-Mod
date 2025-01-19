package com.syu.carinfo.jili;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.mzd.RZCJiliSkySetActi;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

public class YuanJingX1CarSettingsAct extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_drivemode;
    int[] send_lang;
    private int[] eventIds = {98, 99, 100, 101, 102, 111, 130, 117, 131, 132, 133, 134, 135, 136, 151, 152, 153, 154, 155, 156, 157, 179, 172, 173, 174, 175, 176, 177, 166, 178, 181, 182, 183, 184, 158, 115, 167, 185, 187, 188, 189, 190, 191, 192, 193, 195, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213};
    int cmdtype = 0;
    int language_set = 255;
    int drivemode_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext29), value == 1);
                    break;
                case 99:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext30), value == 1);
                    break;
                case 100:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext31), value == 1);
                    break;
                case 101:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext32), value == 1);
                    break;
                case 102:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext33), value == 1);
                    break;
                case 111:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext34), value == 1);
                    break;
                case 115:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext18), value == 1);
                    break;
                case 117:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext35), value == 1);
                    if (((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.boyue_fortification_prompt_txt)) != null) {
                        ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.boyue_fortification_prompt_txt)).setText(value == 1 ? R.string.klc_remote_Remote_control_latch_only_light : R.string.klc_remote_Remote_control_latch_light_Speaker);
                        break;
                    }
                case 130:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext36), value == 1);
                    break;
                case 131:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext37), value == 1);
                    break;
                case 132:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext38), value == 1);
                    break;
                case 133:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext39), value == 1);
                    break;
                case 134:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext40), value == 1);
                    break;
                case 135:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext41), value == 1);
                    break;
                case 136:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext42), value == 1);
                    break;
                case 151:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 152:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 153:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 154:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 155:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 156:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
                            switch (value) {
                                case 0:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text14)).setText("锁车自动关窗");
                                    break;
                                case 1:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text14)).setText("长按钥匙自动关窗");
                                    break;
                                case 2:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                    break;
                            }
                        default:
                            YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                            break;
                    }
                case 157:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 158:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_403_ambient_5);
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_403_ambient_3);
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.guandao_lock2);
                            break;
                        case 3:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_403_ambient_7);
                            break;
                    }
                case 166:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 167:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 172:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    if (((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text1)).setText(value == 1 ? R.string.jeep_forwardcollisionwarn_1 : R.string.jeep_forwardcollisionwarn_0);
                        break;
                    }
                case 173:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 174:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 175:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 176:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 177:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 178:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 179:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 181:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text2)).setText("30s");
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text2)).setText("60s");
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text2)).setText("90s");
                            break;
                    }
                case 182:
                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    break;
                case 183:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_0);
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                            break;
                    }
                case 184:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 185:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 187:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 188:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 189:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text13)).setText("COMFORT");
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text13)).setText("ECO");
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text13)).setText("SPORT");
                            break;
                    }
                case 190:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 191:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 192:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
                case 193:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext27), value == 1);
                    break;
                case 195:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("0.5小时");
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("1小时");
                            break;
                        case 3:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("1.5小时");
                            break;
                        case 4:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("2小时");
                            break;
                        case 5:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("2.5小时");
                            break;
                        case 6:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("3小时");
                            break;
                        case 7:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("3.5小时");
                            break;
                        case 8:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("4小时");
                            break;
                        case 9:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text6)).setText("4.5小时");
                            break;
                    }
                case 197:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text7)).setText("10km/h");
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text7)).setText("20km/h");
                            break;
                    }
                case 198:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext43), value == 1);
                    break;
                case 199:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext44), value == 1);
                    break;
                case 201:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext45), value == 1);
                    break;
                case 202:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext46), value == 1);
                    break;
                case 203:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext47), value == 1);
                    break;
                case 204:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext48), value == 1);
                    break;
                case 205:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext49), value == 1);
                    break;
                case 206:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                            break;
                    }
                case 207:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext50), value == 1);
                    break;
                case 208:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext51), value == 1);
                    break;
                case 209:
                    YuanJingX1CarSettingsAct.this.setCheckView((CheckedTextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.ctv_checkedtext52), value == 1);
                    break;
                case 210:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text9)).setText("两次锁车开启");
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text9)).setText("两次锁车关闭");
                            break;
                    }
                case 211:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text10)).setText("Smart");
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text10)).setText("REV");
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text10)).setText("EV");
                            break;
                        case 3:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text10)).setText("Save");
                            break;
                    }
                case 212:
                    switch (DataCanbus.DATA[1000]) {
                        case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                            switch (value) {
                                case 4:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.str_driving_sport);
                                    break;
                                default:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.str_driving_normal);
                                    break;
                            }
                        default:
                            switch (value) {
                                case 0:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("Default");
                                    break;
                                case 1:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("ECO+长途模式");
                                    break;
                                case 2:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("ECO");
                                    break;
                                case 3:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("Comfort");
                                    break;
                                case 4:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("Sport");
                                    break;
                                case 5:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("Offroad");
                                    break;
                                case 6:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("Snow");
                                    break;
                                case 7:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("MUD");
                                    break;
                                case 8:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("Rock");
                                    break;
                                case 9:
                                    ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text11)).setText("Normal");
                                    break;
                            }
                    }
                case 213:
                    switch (value) {
                        case 0:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text12)).setText("L1");
                            break;
                        case 1:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text12)).setText("L2");
                            break;
                        case 2:
                            ((TextView) YuanJingX1CarSettingsAct.this.findViewById(R.id.tv_text12)).setText("L3");
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_139_rzc_yuanjing_x1);
        init();
    }

    @Override
    public void addNotify() {
        for (int i = 1; i < 65; i++) {
            if (i % 5 == 0) {
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            DataCanbus.PROXY.cmd(7, new int[]{78, i}, null, null);
        }
        for (int i2 = 0; i2 < this.eventIds.length; i2++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i2]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
        DataCanbus.PROXY.cmd(5, new int[1], null, null);
    }

    
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                switch (YuanJingX1CarSettingsAct.this.cmdtype) {
                    case 1:
                        YuanJingX1CarSettingsAct.this.language_set = position;
                        if (YuanJingX1CarSettingsAct.this.language_set >= 0 && YuanJingX1CarSettingsAct.this.language_set <= YuanJingX1CarSettingsAct.this.mLauStylelist.size() && YuanJingX1CarSettingsAct.this.send_lang != null) {
                            DataCanbus.PROXY.cmd(1, new int[]{26, YuanJingX1CarSettingsAct.this.send_lang[YuanJingX1CarSettingsAct.this.language_set]}, null, null);
                            break;
                        }
                    case 2:
                        YuanJingX1CarSettingsAct.this.drivemode_set = position;
                        if (YuanJingX1CarSettingsAct.this.drivemode_set >= 0 && YuanJingX1CarSettingsAct.this.drivemode_set <= YuanJingX1CarSettingsAct.this.mLauStylelist.size() && YuanJingX1CarSettingsAct.this.send_lang != null) {
                            DataCanbus.PROXY.cmd(1, new int[]{44, YuanJingX1CarSettingsAct.this.send_drivemode[YuanJingX1CarSettingsAct.this.drivemode_set]}, null, null);
                            break;
                        }
                }
                YuanJingX1CarSettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet(int index) {
        if (index >= 0 && index < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(index, true);
        }
    }

    
    public void initmLauStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.send_lang = new int[]{0, 1};
    }

    
    public void initmDrivemodeStylelist() {
        this.mLauStylelist.clear();
        this.mLauStylelist.add(getResources().getString(R.string.wc_golf_comfort));
        this.mLauStylelist.add(getResources().getString(R.string.str_driving_eco));
        this.mLauStylelist.add(getResources().getString(R.string.str_driving_sport));
        this.send_drivemode = new int[]{0, 1, 2};
    }

    @Override
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                YuanJingX1CarSettingsAct.this.initmLauStylelist();
                YuanJingX1CarSettingsAct.this.cmdtype = 1;
                if (YuanJingX1CarSettingsAct.this.mLauStyle == null) {
                    YuanJingX1CarSettingsAct.this.initLauStyle();
                }
                if (YuanJingX1CarSettingsAct.this.mLauStyle != null && YuanJingX1CarSettingsAct.this.mPopShowView != null) {
                    YuanJingX1CarSettingsAct.this.mLauStyle.showAtLocation(YuanJingX1CarSettingsAct.this.mPopShowView, 17, 0, 0);
                    YuanJingX1CarSettingsAct.this.updateLauguageSet(YuanJingX1CarSettingsAct.this.language_set);
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext54), new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                YuanJingX1CarSettingsAct.this.initmDrivemodeStylelist();
                YuanJingX1CarSettingsAct.this.cmdtype = 2;
                if (YuanJingX1CarSettingsAct.this.mLauStyle == null) {
                    YuanJingX1CarSettingsAct.this.initLauStyle();
                }
                if (YuanJingX1CarSettingsAct.this.mLauStyle != null && YuanJingX1CarSettingsAct.this.mPopShowView != null) {
                    YuanJingX1CarSettingsAct.this.mLauStyle.showAtLocation(YuanJingX1CarSettingsAct.this.mPopShowView, 17, 0, 0);
                    YuanJingX1CarSettingsAct.this.updateLauguageSet(YuanJingX1CarSettingsAct.this.drivemode_set);
                }
            }
        });
        findViewById(R.id.layout_view1).setVisibility(8);
        findViewById(R.id.layout_view2).setVisibility(8);
        findViewById(R.id.layout_view3).setVisibility(8);
        findViewById(R.id.layout_view4).setVisibility(8);
        findViewById(R.id.layout_view5).setVisibility(8);
        findViewById(R.id.layout_view6).setVisibility(8);
        findViewById(R.id.layout_view30).setVisibility(8);
        findViewById(R.id.layout_view7).setVisibility(8);
        findViewById(R.id.layout_view8).setVisibility(8);
        findViewById(R.id.layout_view9).setVisibility(8);
        findViewById(R.id.layout_view10).setVisibility(8);
        findViewById(R.id.layout_view11).setVisibility(8);
        findViewById(R.id.layout_view12).setVisibility(8);
        findViewById(R.id.layout_view13).setVisibility(8);
        findViewById(R.id.layout_view14).setVisibility(8);
        findViewById(R.id.layout_view15).setVisibility(8);
        findViewById(R.id.layout_view16).setVisibility(8);
        findViewById(R.id.layout_view17).setVisibility(8);
        findViewById(R.id.layout_view18).setVisibility(8);
        findViewById(R.id.layout_view19).setVisibility(8);
        findViewById(R.id.layout_view20).setVisibility(8);
        findViewById(R.id.layout_view21).setVisibility(8);
        findViewById(R.id.layout_view22).setVisibility(8);
        findViewById(R.id.layout_view23).setVisibility(8);
        findViewById(R.id.layout_view24).setVisibility(8);
        findViewById(R.id.layout_view25).setVisibility(8);
        findViewById(R.id.layout_view26).setVisibility(8);
        findViewById(R.id.layout_view27).setVisibility(8);
        findViewById(R.id.layout_view28).setVisibility(8);
        findViewById(R.id.layout_view29).setVisibility(8);
        findViewById(R.id.layout_view31).setVisibility(8);
        findViewById(R.id.layout_view32).setVisibility(8);
        findViewById(R.id.layout_view33).setVisibility(8);
        findViewById(R.id.layout_view34).setVisibility(8);
        findViewById(R.id.layout_view35).setVisibility(8);
        findViewById(R.id.layout_view36).setVisibility(8);
        findViewById(R.id.layout_view37).setVisibility(8);
        findViewById(R.id.layout_view38).setVisibility(8);
        findViewById(R.id.layout_view39).setVisibility(8);
        findViewById(R.id.layout_view40).setVisibility(8);
        findViewById(R.id.layout_view41).setVisibility(8);
        findViewById(R.id.layout_view42).setVisibility(8);
        findViewById(R.id.layout_view43).setVisibility(8);
        findViewById(R.id.layout_view44).setVisibility(8);
        findViewById(R.id.layout_view45).setVisibility(8);
        findViewById(R.id.layout_view46).setVisibility(8);
        findViewById(R.id.layout_view47).setVisibility(8);
        findViewById(R.id.layout_view48).setVisibility(8);
        findViewById(R.id.layout_view49).setVisibility(8);
        findViewById(R.id.layout_view50).setVisibility(8);
        findViewById(R.id.layout_view51).setVisibility(8);
        findViewById(R.id.layout_view52).setVisibility(8);
        findViewById(R.id.layout_view53).setVisibility(8);
        findViewById(R.id.layout_view54).setVisibility(8);
        findViewById(R.id.layout_view55).setVisibility(8);
        findViewById(R.id.layout_view56).setVisibility(8);
        findViewById(R.id.layout_view57).setVisibility(8);
        findViewById(R.id.layout_view58).setVisibility(8);
        findViewById(R.id.layout_view59).setVisibility(8);
        findViewById(R.id.layout_view60).setVisibility(8);
        findViewById(R.id.layout_view61).setVisibility(8);
        findViewById(R.id.layout_view62).setVisibility(8);
        findViewById(R.id.layout_view63).setVisibility(8);
        findViewById(R.id.layout_view64).setVisibility(8);
        findViewById(R.id.layout_view65).setVisibility(8);
        findViewById(R.id.layout_view66).setVisibility(8);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_YuanJingX6 /* 131211 */:
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV /* 721035 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV /* 917643 */:
            case FinalCanbus.CAR_RZC_XP1_16YuanJingSUV_H /* 983179 */:
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_YuanJingX1 /* 196747 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3 /* 524427 */:
            case FinalCanbus.CAR_RZC_Jili_19Dihao /* 1310859 */:
            case FinalCanbus.CAR_RZC_Jili_18Dihao /* 1507467 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_S1_18 /* 1704075 */:
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS /* 589963 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL /* 655499 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_18 /* 1573003 */:
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_16 /* 1638539 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18YuanJingSUV_H /* 852107 */:
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_18YuanJing /* 1114251 */:
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view30).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view46).setVisibility(0);
                findViewById(R.id.layout_view47).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_19 /* 1769611 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_YuanJingX3_19_20 /* 1835147 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_19 /* 1966219 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view27).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_20YuanJingSUV /* 2031755 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_DiHao_GL_20 /* 2097291 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view29).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Boyue_Pro_20 /* 2162827 */:
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view35).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Bingyue_19 /* 2228363 */:
            case FinalCanbus.CAR_RZC_XP1_BingyuePro_19 /* 2949259 */:
            case FinalCanbus.CAR_RZC_XP1_Bingyue_21_RS /* 3276939 */:
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view40).setVisibility(0);
                findViewById(R.id.layout_view39).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_DiHao_GS_20 /* 2293899 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_GSe_20 /* 2359435 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Jiaji_21 /* 2424971 */:
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view42).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Binrui_20 /* 2490507 */:
                findViewById(R.id.layout_view36).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view43).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Haoyue_20 /* 2556043 */:
                findViewById(R.id.layout_view66).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Dihaoe_22 /* 2621579 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Xingrui_22 /* 2687115 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view33).setVisibility(0);
                findViewById(R.id.layout_view24).setVisibility(0);
                findViewById(R.id.layout_view25).setVisibility(0);
                findViewById(R.id.layout_view28).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view34).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view54).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view41).setVisibility(0);
                findViewById(R.id.layout_view31).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                findViewById(R.id.layout_view63).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_Jili_TX5 /* 2883723 */:
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view26).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view38).setVisibility(0);
                findViewById(R.id.layout_view45).setVisibility(0);
                findViewById(R.id.layout_view55).setVisibility(0);
                findViewById(R.id.layout_view57).setVisibility(0);
                findViewById(R.id.layout_view58).setVisibility(0);
                findViewById(R.id.layout_view59).setVisibility(0);
                findViewById(R.id.layout_view60).setVisibility(0);
                findViewById(R.id.layout_view61).setVisibility(0);
                findViewById(R.id.layout_view62).setVisibility(0);
                break;
            case FinalCanbus.CAR_RZC_XP1_Dihao_23 /* 3342475 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view32).setVisibility(0);
                findViewById(R.id.layout_view37).setVisibility(0);
                findViewById(R.id.layout_view44).setVisibility(0);
                findViewById(R.id.layout_view48).setVisibility(0);
                findViewById(R.id.layout_view49).setVisibility(0);
                findViewById(R.id.layout_view50).setVisibility(0);
                findViewById(R.id.layout_view51).setVisibility(0);
                findViewById(R.id.layout_view52).setVisibility(0);
                findViewById(R.id.layout_view53).setVisibility(0);
                findViewById(R.id.layout_view56).setVisibility(0);
                findViewById(R.id.layout_view64).setVisibility(0);
                findViewById(R.id.layout_view65).setVisibility(0);
                break;
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext17)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v) {
                    YuanJingX1CarSettingsAct.this.sendCmd(40, 1);
                }
            });
        }
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), 0, 151);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), 1, 152);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), 2, 153);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), 3, 154);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), 4, 155);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), 8, 156);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), 20, 157);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), 38, 179);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), 30, 175);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), 31, 176);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), 32, 177);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), 33, 166);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), 35, 172);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), 34, 173);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), 36, 174);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), 8, 178);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), 9, 115);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), 10, 167);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), 43, 184);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext21)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[185];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(4, new int[]{value}, null, null);
            }
        });
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), 128, 187);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), 27, 188);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), 45, 190);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), 46, 191);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), 47, 192);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext27), 48, 193);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext28)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
            }
        });
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), 0, 98);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), 1, 99);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext31), 2, 100);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext32), 3, 101);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext33), 4, 102);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext34), 5, 111);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext35), 17, 117);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext36), 20, 130);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext37), 1, 131);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext38), 3, 132);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext39), 2, 133);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext40), 4, 134);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext41), 0, 135);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext42), 19, 136);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext43), 50, 198);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext44), 51, 199);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext45), 53, 201);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext46), 54, 202);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext47), 55, 203);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext48), 56, 204);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext49), 57, 205);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext50), 59, 207);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext51), 60, 208);
        sendClick((CheckedTextView) findViewById(R.id.ctv_checkedtext52), 61, 209);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext53)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(YuanJingX1CarSettingsAct.this, RZCJiliSkySetActi.class);
                    YuanJingX1CarSettingsAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[181] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{39, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[181] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{39, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[158] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{28, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[183] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{42, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[183] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{42, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value > 1) {
                    value--;
                }
                DataCanbus.PROXY.cmd(1, new int[]{41, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[182];
                if (value < 10) {
                    value++;
                }
                DataCanbus.PROXY.cmd(1, new int[]{41, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[195] - 1;
                if (value < 0) {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[195] + 1;
                if (value > 9) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(6, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[197] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{49, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[197] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{49, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[206] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{58, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[206] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{58, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[210] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{62, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[210] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{62, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[211] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{63, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[211] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{63, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[212];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                        if (value2 == 9) {
                            value = 4;
                            break;
                        } else {
                            value = 9;
                            break;
                        }
                    default:
                        value = value2 - 1;
                        if (value < 0) {
                            value = 9;
                            break;
                        }
                }
                DataCanbus.PROXY.cmd(1, new int[]{64, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[212];
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_RZC_Xiongmao_Mini_23 /* 2818187 */:
                        if (value2 == 9) {
                            value = 4;
                            break;
                        } else {
                            value = 9;
                            break;
                        }
                    default:
                        value = value2 + 1;
                        if (value > 9) {
                            value = 0;
                            break;
                        }
                }
                DataCanbus.PROXY.cmd(1, new int[]{64, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[213] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{65, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[213] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{65, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[156] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus13)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[156] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value}, null, null);
            }
        });
    }

    private void sendClick(View v, final int cmd, final int id) {
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() { 
                @Override
                public void onClick(View v2) {
                    int value = DataCanbus.DATA[id];
                    YuanJingX1CarSettingsAct.this.sendCmd(cmd, value == 0 ? 1 : 0);
                }
            });
        }
    }

    
    public void setCheckView(CheckedTextView v, boolean b) {
        if (v != null) {
            v.setChecked(b);
        }
    }

    
    public void sendCmd(int cmd, int value) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, value}, null, null);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
