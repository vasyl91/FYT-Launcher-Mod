package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Activity_374_LEDSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_LEDSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED1_VALUE /* 525 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text1)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED2_VALUE /* 526 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text2)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED3_VALUE /* 527 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text3)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED4_VALUE /* 528 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text4)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED5_VALUE /* 529 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text5)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED6_VALUE /* 530 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text6)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED7_VALUE /* 531 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text7)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED8_VALUE /* 532 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text8)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D86_LED9_VALUE /* 533 */:
                    if (((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText(R.string.crv_source_null);
                                break;
                            case 1:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("ON/OFF");
                                break;
                            case 2:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("AC");
                                break;
                            case 3:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("CYCLE");
                                break;
                            case 4:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("Front Defog");
                                break;
                            case 5:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("Rear Defog");
                                break;
                            case 6:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("AUTO");
                                break;
                            case 7:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("SYNC");
                                break;
                            case 8:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("STEER HOT");
                                break;
                            case 9:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 10:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText(R.string.str_320_h6_smart_startstop);
                                break;
                            case 11:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("HDC");
                                break;
                            case 12:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText(R.string.parking_assist);
                                break;
                            case 13:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("ECO");
                                break;
                            case 14:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("SPORT");
                                break;
                            case 15:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("FCW");
                                break;
                            case 16:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("Lane deviation");
                                break;
                            case 17:
                                ((TextView) Activity_374_LEDSet.this.findViewById(R.id.tv_text9)).setText("Automatic parking");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_xp_doge_led_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427417 */:
                int value1 = DataCanbus.DATA[525];
                int value2 = DataCanbus.DATA[526];
                int value3 = DataCanbus.DATA[527];
                int value4 = DataCanbus.DATA[528];
                int value5 = DataCanbus.DATA[529];
                int value6 = DataCanbus.DATA[530];
                int value7 = DataCanbus.DATA[531];
                int value8 = DataCanbus.DATA[532];
                int value9 = DataCanbus.DATA[533];
                int value10 = value1 - 1;
                if (value10 < 0) {
                    value10 = 17;
                }
                setCarInfo(value10, value2, value3, value4, value5, value6, value7, value8, value9);
                break;
            case R.id.btn_plus1 /* 2131427419 */:
                int value11 = DataCanbus.DATA[525];
                int value12 = DataCanbus.DATA[526];
                int value13 = DataCanbus.DATA[527];
                int value14 = DataCanbus.DATA[528];
                int value15 = DataCanbus.DATA[529];
                int value16 = DataCanbus.DATA[530];
                int value17 = DataCanbus.DATA[531];
                int value18 = DataCanbus.DATA[532];
                int value19 = DataCanbus.DATA[533];
                int value20 = value11 + 1;
                if (value20 > 17) {
                    value20 = 0;
                }
                setCarInfo(value20, value12, value13, value14, value15, value16, value17, value18, value19);
                break;
            case R.id.btn_minus2 /* 2131427421 */:
                int value21 = DataCanbus.DATA[525];
                int value22 = DataCanbus.DATA[526];
                int value23 = DataCanbus.DATA[527];
                int value24 = DataCanbus.DATA[528];
                int value25 = DataCanbus.DATA[529];
                int value26 = DataCanbus.DATA[530];
                int value27 = DataCanbus.DATA[531];
                int value28 = DataCanbus.DATA[532];
                int value29 = DataCanbus.DATA[533];
                int value30 = value22 - 1;
                if (value30 < 0) {
                    value30 = 17;
                }
                setCarInfo(value21, value30, value23, value24, value25, value26, value27, value28, value29);
                break;
            case R.id.btn_plus2 /* 2131427423 */:
                int value31 = DataCanbus.DATA[525];
                int value32 = DataCanbus.DATA[526];
                int value33 = DataCanbus.DATA[527];
                int value34 = DataCanbus.DATA[528];
                int value35 = DataCanbus.DATA[529];
                int value36 = DataCanbus.DATA[530];
                int value37 = DataCanbus.DATA[531];
                int value38 = DataCanbus.DATA[532];
                int value39 = DataCanbus.DATA[533];
                int value40 = value32 + 1;
                if (value40 > 17) {
                    value40 = 0;
                }
                setCarInfo(value31, value40, value33, value34, value35, value36, value37, value38, value39);
                break;
            case R.id.btn_minus3 /* 2131427425 */:
                int value41 = DataCanbus.DATA[525];
                int value42 = DataCanbus.DATA[526];
                int value43 = DataCanbus.DATA[527];
                int value44 = DataCanbus.DATA[528];
                int value45 = DataCanbus.DATA[529];
                int value46 = DataCanbus.DATA[530];
                int value47 = DataCanbus.DATA[531];
                int value48 = DataCanbus.DATA[532];
                int value49 = DataCanbus.DATA[533];
                int value50 = value43 - 1;
                if (value50 < 0) {
                    value50 = 17;
                }
                setCarInfo(value41, value42, value50, value44, value45, value46, value47, value48, value49);
                break;
            case R.id.btn_plus3 /* 2131427427 */:
                int value51 = DataCanbus.DATA[525];
                int value52 = DataCanbus.DATA[526];
                int value53 = DataCanbus.DATA[527];
                int value54 = DataCanbus.DATA[528];
                int value55 = DataCanbus.DATA[529];
                int value56 = DataCanbus.DATA[530];
                int value57 = DataCanbus.DATA[531];
                int value58 = DataCanbus.DATA[532];
                int value59 = DataCanbus.DATA[533];
                int value60 = value53 + 1;
                if (value60 > 17) {
                    value60 = 0;
                }
                setCarInfo(value51, value52, value60, value54, value55, value56, value57, value58, value59);
                break;
            case R.id.btn_plus4 /* 2131427428 */:
                int value61 = DataCanbus.DATA[525];
                int value62 = DataCanbus.DATA[526];
                int value63 = DataCanbus.DATA[527];
                int value64 = DataCanbus.DATA[528];
                int value65 = DataCanbus.DATA[529];
                int value66 = DataCanbus.DATA[530];
                int value67 = DataCanbus.DATA[531];
                int value68 = DataCanbus.DATA[532];
                int value69 = DataCanbus.DATA[533];
                int value70 = value64 + 1;
                if (value70 > 17) {
                    value70 = 0;
                }
                setCarInfo(value61, value62, value63, value70, value65, value66, value67, value68, value69);
                break;
            case R.id.btn_plus5 /* 2131427429 */:
                int value71 = DataCanbus.DATA[525];
                int value72 = DataCanbus.DATA[526];
                int value73 = DataCanbus.DATA[527];
                int value74 = DataCanbus.DATA[528];
                int value75 = DataCanbus.DATA[529];
                int value76 = DataCanbus.DATA[530];
                int value77 = DataCanbus.DATA[531];
                int value78 = DataCanbus.DATA[532];
                int value79 = DataCanbus.DATA[533];
                int value80 = value75 + 1;
                if (value80 > 17) {
                    value80 = 0;
                }
                setCarInfo(value71, value72, value73, value74, value80, value76, value77, value78, value79);
                break;
            case R.id.btn_plus6 /* 2131427430 */:
                int value81 = DataCanbus.DATA[525];
                int value82 = DataCanbus.DATA[526];
                int value83 = DataCanbus.DATA[527];
                int value84 = DataCanbus.DATA[528];
                int value85 = DataCanbus.DATA[529];
                int value86 = DataCanbus.DATA[530];
                int value87 = DataCanbus.DATA[531];
                int value88 = DataCanbus.DATA[532];
                int value89 = DataCanbus.DATA[533];
                int value90 = value86 + 1;
                if (value90 > 17) {
                    value90 = 0;
                }
                setCarInfo(value81, value82, value83, value84, value85, value90, value87, value88, value89);
                break;
            case R.id.btn_plus7 /* 2131427431 */:
                int value91 = DataCanbus.DATA[525];
                int value92 = DataCanbus.DATA[526];
                int value93 = DataCanbus.DATA[527];
                int value94 = DataCanbus.DATA[528];
                int value95 = DataCanbus.DATA[529];
                int value96 = DataCanbus.DATA[530];
                int value97 = DataCanbus.DATA[531];
                int value98 = DataCanbus.DATA[532];
                int value99 = DataCanbus.DATA[533];
                int value100 = value97 + 1;
                if (value100 > 17) {
                    value100 = 0;
                }
                setCarInfo(value91, value92, value93, value94, value95, value96, value100, value98, value99);
                break;
            case R.id.btn_plus8 /* 2131427432 */:
                int value101 = DataCanbus.DATA[525];
                int value102 = DataCanbus.DATA[526];
                int value103 = DataCanbus.DATA[527];
                int value104 = DataCanbus.DATA[528];
                int value105 = DataCanbus.DATA[529];
                int value106 = DataCanbus.DATA[530];
                int value107 = DataCanbus.DATA[531];
                int value108 = DataCanbus.DATA[532];
                int value109 = DataCanbus.DATA[533];
                int value110 = value108 + 1;
                if (value110 > 17) {
                    value110 = 0;
                }
                setCarInfo(value101, value102, value103, value104, value105, value106, value107, value110, value109);
                break;
            case R.id.btn_plus9 /* 2131427433 */:
                int value111 = DataCanbus.DATA[525];
                int value112 = DataCanbus.DATA[526];
                int value113 = DataCanbus.DATA[527];
                int value114 = DataCanbus.DATA[528];
                int value115 = DataCanbus.DATA[529];
                int value116 = DataCanbus.DATA[530];
                int value117 = DataCanbus.DATA[531];
                int value118 = DataCanbus.DATA[532];
                int value119 = DataCanbus.DATA[533] + 1;
                if (value119 > 17) {
                    value119 = 0;
                }
                setCarInfo(value111, value112, value113, value114, value115, value116, value117, value118, value119);
                break;
            case R.id.btn_minus4 /* 2131427473 */:
                int value120 = DataCanbus.DATA[525];
                int value121 = DataCanbus.DATA[526];
                int value122 = DataCanbus.DATA[527];
                int value123 = DataCanbus.DATA[528];
                int value124 = DataCanbus.DATA[529];
                int value125 = DataCanbus.DATA[530];
                int value126 = DataCanbus.DATA[531];
                int value127 = DataCanbus.DATA[532];
                int value128 = DataCanbus.DATA[533];
                int value129 = value123 - 1;
                if (value129 < 0) {
                    value129 = 17;
                }
                setCarInfo(value120, value121, value122, value129, value124, value125, value126, value127, value128);
                break;
            case R.id.btn_minus5 /* 2131427474 */:
                int value130 = DataCanbus.DATA[525];
                int value131 = DataCanbus.DATA[526];
                int value132 = DataCanbus.DATA[527];
                int value133 = DataCanbus.DATA[528];
                int value134 = DataCanbus.DATA[529];
                int value135 = DataCanbus.DATA[530];
                int value136 = DataCanbus.DATA[531];
                int value137 = DataCanbus.DATA[532];
                int value138 = DataCanbus.DATA[533];
                int value139 = value134 - 1;
                if (value139 < 0) {
                    value139 = 17;
                }
                setCarInfo(value130, value131, value132, value133, value139, value135, value136, value137, value138);
                break;
            case R.id.btn_minus6 /* 2131427476 */:
                int value140 = DataCanbus.DATA[525];
                int value141 = DataCanbus.DATA[526];
                int value142 = DataCanbus.DATA[527];
                int value143 = DataCanbus.DATA[528];
                int value144 = DataCanbus.DATA[529];
                int value145 = DataCanbus.DATA[530];
                int value146 = DataCanbus.DATA[531];
                int value147 = DataCanbus.DATA[532];
                int value148 = DataCanbus.DATA[533];
                int value149 = value145 - 1;
                if (value149 < 0) {
                    value149 = 17;
                }
                setCarInfo(value140, value141, value142, value143, value144, value149, value146, value147, value148);
                break;
            case R.id.btn_minus7 /* 2131427478 */:
                int value150 = DataCanbus.DATA[525];
                int value151 = DataCanbus.DATA[526];
                int value152 = DataCanbus.DATA[527];
                int value153 = DataCanbus.DATA[528];
                int value154 = DataCanbus.DATA[529];
                int value155 = DataCanbus.DATA[530];
                int value156 = DataCanbus.DATA[531];
                int value157 = DataCanbus.DATA[532];
                int value158 = DataCanbus.DATA[533];
                int value159 = value156 - 1;
                if (value159 < 0) {
                    value159 = 17;
                }
                setCarInfo(value150, value151, value152, value153, value154, value155, value159, value157, value158);
                break;
            case R.id.btn_minus8 /* 2131427480 */:
                int value160 = DataCanbus.DATA[525];
                int value161 = DataCanbus.DATA[526];
                int value162 = DataCanbus.DATA[527];
                int value163 = DataCanbus.DATA[528];
                int value164 = DataCanbus.DATA[529];
                int value165 = DataCanbus.DATA[530];
                int value166 = DataCanbus.DATA[531];
                int value167 = DataCanbus.DATA[532];
                int value168 = DataCanbus.DATA[533];
                int value169 = value167 - 1;
                if (value169 < 0) {
                    value169 = 17;
                }
                setCarInfo(value160, value161, value162, value163, value164, value165, value166, value169, value168);
                break;
            case R.id.btn_minus9 /* 2131427482 */:
                int value170 = DataCanbus.DATA[525];
                int value171 = DataCanbus.DATA[526];
                int value172 = DataCanbus.DATA[527];
                int value173 = DataCanbus.DATA[528];
                int value174 = DataCanbus.DATA[529];
                int value175 = DataCanbus.DATA[530];
                int value176 = DataCanbus.DATA[531];
                int value177 = DataCanbus.DATA[532];
                int value178 = DataCanbus.DATA[533] - 1;
                if (value178 < 0) {
                    value178 = 17;
                }
                setCarInfo(value170, value171, value172, value173, value174, value175, value176, value177, value178);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5, int value6, int value7, int value8, int value9) {
        DataCanbus.PROXY.cmd(26, new int[]{value1, value2, value3, value4, value5, value6, value7, value8, value9}, null, null);
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[525].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[526].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[527].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[528].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[529].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[530].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[531].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[532].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[533].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[525].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[526].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[527].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[528].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[529].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[530].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[531].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[532].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[533].removeNotify(this.mNotifyCanbus);
    }
}
