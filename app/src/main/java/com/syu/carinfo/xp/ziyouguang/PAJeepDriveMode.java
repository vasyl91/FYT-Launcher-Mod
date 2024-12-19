package com.syu.carinfo.xp.ziyouguang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAJeepDriveMode extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 315:
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_track_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_sport_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_auto_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_snow_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_tow_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_custom_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_mudsand_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_rock_n);
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_baja_n);
                    switch (value) {
                        case 1:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_sport_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Sport Setup");
                            break;
                        case 2:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_tow_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Tow Setup");
                            break;
                        case 3:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_snow_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Snow Setup");
                            break;
                        case 4:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_auto_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Auto Setup");
                            break;
                        case 5:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_custom_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Custom Setup");
                            break;
                        case 6:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_mudsand_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Mud/Sand Setup");
                            break;
                        case 7:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_rock_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Rock Setup");
                            break;
                        case 8:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_baja_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Baja Setup");
                            break;
                        case 9:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_track_p);
                            ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text7)).setText("Track Setup");
                            break;
                    }
                case 316:
                    PAJeepDriveMode.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_eco_n);
                    if (((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Sport");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom1);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission1);
                                break;
                            case 2:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Tow");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom5);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission4);
                                break;
                            case 3:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Snow");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission5);
                                break;
                            case 4:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Auto");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission0);
                                break;
                            case 5:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Custom");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission0);
                                break;
                            case 6:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Mud/Sand");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission0);
                                break;
                            case 7:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Rock");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission0);
                                break;
                            case 8:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Baja");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission0);
                                break;
                            case 9:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Track");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission2);
                                break;
                            case 10:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Eco");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom7);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission0);
                                break;
                            case 11:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("Street");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom3);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission3);
                                break;
                            default:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text1)).setText("----");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view1).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_transmission0);
                                break;
                        }
                    }
                    break;
                case 317:
                    if (((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text2)).setText("Off");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_paddle0);
                                break;
                            case 1:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text2)).setText("On");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_paddle1);
                                break;
                            default:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text2)).setText("----");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view2).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_paddle0);
                                break;
                        }
                    }
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D57_D1_B30 /* 318 */:
                    if (((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text3)).setText("Track");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_awd2);
                                break;
                            case 2:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text3)).setText("Sport");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom1);
                                PAJeepDriveMode.this.findViewById(R.id.id_image5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_awd1);
                                break;
                            case 3:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text3)).setText("Street");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom3);
                                PAJeepDriveMode.this.findViewById(R.id.id_image5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_awd3);
                                break;
                            case 4:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text3)).setText("50/50");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_awd4);
                                break;
                            default:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text3)).setText("----");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view3).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_awd0);
                                break;
                        }
                    }
                    break;
                case 319:
                    if (((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text4)).setText("Track");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_stability2);
                                break;
                            case 2:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text4)).setText("Sport");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom1);
                                PAJeepDriveMode.this.findViewById(R.id.id_image6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_stability1);
                                break;
                            case 3:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text4)).setText("Street");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom3);
                                PAJeepDriveMode.this.findViewById(R.id.id_image6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_stability3);
                                break;
                            case 4:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text4)).setText("Full");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_stability4);
                                break;
                            case 5:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text4)).setText("Rock");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_stability5);
                                break;
                            default:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text4)).setText("----");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view4).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_stability0);
                                break;
                        }
                    }
                    break;
                case 320:
                    if (((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text5)).setText("Track");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image7).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_suspension2);
                                break;
                            case 2:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text5)).setText("Sport");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom1);
                                PAJeepDriveMode.this.findViewById(R.id.id_image7).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_suspension1);
                                break;
                            case 3:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text5)).setText("Street");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom3);
                                PAJeepDriveMode.this.findViewById(R.id.id_image7).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_suspension3);
                                break;
                            case 4:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text5)).setText("Bajia");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image7).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_suspension0);
                                break;
                            default:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text5)).setText("----");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view5).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image7).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_suspension0);
                                break;
                        }
                    }
                    break;
                case 321:
                    if (((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text6)).setText("Track");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom2);
                                PAJeepDriveMode.this.findViewById(R.id.id_image8).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_steer2);
                                break;
                            case 2:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text6)).setText("Sport");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom1);
                                PAJeepDriveMode.this.findViewById(R.id.id_image8).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_steer1);
                                break;
                            case 3:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text6)).setText("Street");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom3);
                                PAJeepDriveMode.this.findViewById(R.id.id_image8).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_steer3);
                                break;
                            case 4:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text6)).setText("Rock");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom4);
                                PAJeepDriveMode.this.findViewById(R.id.id_image8).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_steer4);
                                break;
                            default:
                                ((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text6)).setText("----");
                                PAJeepDriveMode.this.findViewById(R.id.layout_view6).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_bottom6);
                                PAJeepDriveMode.this.findViewById(R.id.id_image8).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_steer0);
                                break;
                        }
                    }
                    break;
                case 322:
                    if (((TextView) PAJeepDriveMode.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 1:
                                PAJeepDriveMode.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_eco_p);
                                PAJeepDriveMode.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_auto7);
                                break;
                            default:
                                PAJeepDriveMode.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_eco_n);
                                PAJeepDriveMode.this.findViewById(R.id.id_image2).setBackgroundResource(R.drawable.ic_pa_jeep_drivemode_auto);
                                break;
                        }
                    }
                    break;
                case 371:
                    switch (value) {
                        case 1:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_jeep_tracksport_1);
                            break;
                        case 2:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_jeep_tracksport_2);
                            break;
                        default:
                            PAJeepDriveMode.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_jeep_tracksport_0);
                            break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_drive_mode);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 9}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 1}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 4}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 3}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 2}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 5}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 6}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 7}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{1, 8}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[322];
                if (value == 1) {
                    DataCanbus.PROXY.cmd(16, new int[]{8}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(16, new int[]{8, 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(PAJeepDriveMode.this, PAJeepDriveModeSetup.class);
                    PAJeepDriveMode.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDriveMode.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(16, new int[]{9}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{87}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[315].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[316].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[317].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[318].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[319].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[320].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[321].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[322].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[371].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[315].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[316].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[317].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[318].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[319].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[320].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[321].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[322].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[371].removeNotify(this.mNotifyCanbus);
    }
}
