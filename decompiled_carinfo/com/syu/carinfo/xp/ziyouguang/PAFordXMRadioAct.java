package com.syu.carinfo.xp.ziyouguang;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAFordXMRadioAct extends BaseActivity implements View.OnTouchListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 420:
                case 425:
                    int band = DataCanbus.DATA[420];
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                    switch (band) {
                        case 2:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                            ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text1)).setText("AM " + Callback_0374_XP1_ZiYouGuang.XMRadio_Band);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus24).setVisibility(0);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus26).setVisibility(0);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus27).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus28).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view6).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                            break;
                        case 3:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus4).setVisibility(0);
                            ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text1)).setText("XM " + Callback_0374_XP1_ZiYouGuang.XMRadio_Band);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus24).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus26).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus27).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus28).setVisibility(0);
                            if (DataCanbus.DATA[421] == 1) {
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view6).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view5).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view1).setVisibility(8);
                                break;
                            } else {
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view6).setVisibility(8);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                                break;
                            }
                        default:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                            ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text1)).setText("FM " + Callback_0374_XP1_ZiYouGuang.XMRadio_Band);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus24).setVisibility(0);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus26).setVisibility(0);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus27).setVisibility(0);
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus28).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view6).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                            break;
                    }
                case 421:
                    if (DataCanbus.DATA[420] == 3) {
                        switch (value) {
                            case 1:
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view6).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view5).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view1).setVisibility(8);
                                ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus28)).setTextColor(Color.parseColor("#666666"));
                                PAFordXMRadioAct.this.findViewById(R.id.btn_plus28).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_replay_p);
                                PAFordXMRadioAct.this.RefreshImageView5_delay();
                                PAFordXMRadioAct.this.RefreshImageView6_delay();
                                break;
                            default:
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view6).setVisibility(8);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                                PAFordXMRadioAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                                ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus28)).setTextColor(Color.parseColor("#ffffff"));
                                PAFordXMRadioAct.this.findViewById(R.id.btn_plus28).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_replay_n);
                                break;
                        }
                    }
                    break;
                case 422:
                    switch (value) {
                        case 1:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_tune_pause_p);
                            break;
                        default:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_tune_play_n);
                            break;
                    }
                case 423:
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    PAFordXMRadioAct.this.findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_p);
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus7)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus8)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus11)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus12)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus13)).setTextColor(Color.parseColor("#ffffff"));
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus14)).setTextColor(Color.parseColor("#ffffff"));
                    switch (value) {
                        case 1:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus5).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus5)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 2:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 3:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus7).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus7)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 4:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus8).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus8)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 5:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus9).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus9)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 6:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus10).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus10)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 7:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus11)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 8:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus12)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 9:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus13)).setTextColor(Color.parseColor("#666666"));
                            break;
                        case 10:
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_pa_toyota_xmradio_frq_n);
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus14)).setTextColor(Color.parseColor("#666666"));
                            break;
                    }
                case 424:
                    int min = value / 60;
                    int sec = value % 60;
                    ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text6)).setText("- " + (min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                    break;
                case 426:
                    ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text2)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_Freq);
                    break;
                case 427:
                    ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text3)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_RDS1);
                    break;
                case 428:
                    ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text4)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_RDS2);
                    break;
                case 429:
                    ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text5)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_RDS3);
                    break;
                case 430:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus5)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName1);
                    break;
                case 431:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus6)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName2);
                    break;
                case 432:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus7)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName3);
                    break;
                case 433:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus8)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName4);
                    break;
                case 434:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus9)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName5);
                    break;
                case 435:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus10)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName6);
                    break;
                case 436:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus11)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName7);
                    break;
                case 437:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus12)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName8);
                    break;
                case 438:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus13)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName9);
                    break;
                case 439:
                    ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus14)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_FreqName10);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B3 /* 491 */:
                    switch (value) {
                        case 1:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus24)).setTextColor(Color.parseColor("#666666"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus24).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            break;
                        default:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus24)).setTextColor(Color.parseColor("#ffffff"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus24).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                            break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B4 /* 492 */:
                    switch (value) {
                        case 1:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus25)).setTextColor(Color.parseColor("#666666"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus25).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            break;
                        default:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus25)).setTextColor(Color.parseColor("#ffffff"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus25).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                            break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B5 /* 493 */:
                    switch (value) {
                        case 1:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus26)).setTextColor(Color.parseColor("#666666"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus26).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            break;
                        default:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus26)).setTextColor(Color.parseColor("#ffffff"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus26).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                            break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B6 /* 494 */:
                    switch (value) {
                        case 1:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus27)).setTextColor(Color.parseColor("#666666"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus27).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            break;
                        default:
                            ((Button) PAFordXMRadioAct.this.findViewById(R.id.btn_plus27)).setTextColor(Color.parseColor("#ffffff"));
                            PAFordXMRadioAct.this.findViewById(R.id.btn_plus27).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                            break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B7 /* 495 */:
                    switch (value) {
                        case 1:
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                            break;
                        default:
                            PAFordXMRadioAct.this.findViewById(R.id.layout_view3).setVisibility(8);
                            break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D1A_RDS4 /* 496 */:
                    ((TextView) PAFordXMRadioAct.this.findViewById(R.id.tv_text7)).setText(Callback_0374_XP1_ZiYouGuang.XMRadio_RDS4);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D4_B70 /* 497 */:
                    PAFordXMRadioAct.this.RefreshImageView5(value);
                    break;
                case Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D5_B70 /* 498 */:
                    PAFordXMRadioAct.this.RefreshImageView6(value);
                    break;
            }
        }
    };
    private PAFordDirectTuneWindow mPaFordDirctTuneWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_ford_xmradio);
        init();
    }

    @Override
    public void init() {
        this.mPaFordDirctTuneWindow = new PAFordDirectTuneWindow(this);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_plus8).setOnTouchListener(this);
        findViewById(R.id.btn_plus9).setOnTouchListener(this);
        findViewById(R.id.btn_plus10).setOnTouchListener(this);
        findViewById(R.id.btn_plus11).setOnTouchListener(this);
        findViewById(R.id.btn_plus12).setOnTouchListener(this);
        findViewById(R.id.btn_plus13).setOnTouchListener(this);
        findViewById(R.id.btn_plus14).setOnTouchListener(this);
        findViewById(R.id.btn_plus15).setOnTouchListener(this);
        findViewById(R.id.btn_plus16).setOnTouchListener(this);
        findViewById(R.id.btn_plus17).setOnTouchListener(this);
        findViewById(R.id.btn_plus18).setOnTouchListener(this);
        findViewById(R.id.btn_plus19).setOnTouchListener(this);
        findViewById(R.id.btn_plus20).setOnTouchListener(this);
        findViewById(R.id.btn_plus21).setOnTouchListener(this);
        findViewById(R.id.btn_plus22).setOnTouchListener(this);
        findViewById(R.id.btn_plus23).setOnTouchListener(this);
        findViewById(R.id.btn_plus24).setOnTouchListener(this);
        findViewById(R.id.btn_plus25).setOnTouchListener(this);
        findViewById(R.id.btn_plus26).setOnTouchListener(this);
        findViewById(R.id.btn_plus27).setOnTouchListener(this);
        findViewById(R.id.btn_plus28).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 32;
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 33;
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 34;
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                if (event.getAction() == 0) {
                    this.mPaFordDirctTuneWindow.showWindow(v);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                data0 = 11;
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                data0 = 12;
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                data0 = 13;
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                data0 = 14;
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                data0 = 15;
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                data0 = 16;
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                data0 = 17;
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                data0 = 18;
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                data0 = 19;
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                data0 = 20;
                break;
            case R.id.btn_plus15 /* 2131427517 */:
            case R.id.btn_plus20 /* 2131427906 */:
                data0 = 6;
                break;
            case R.id.btn_plus16 /* 2131427520 */:
            case R.id.btn_plus21 /* 2131427899 */:
                data0 = 3;
                break;
            case R.id.btn_plus17 /* 2131427523 */:
                data0 = 7;
                break;
            case R.id.btn_plus18 /* 2131427895 */:
            case R.id.btn_plus22 /* 2131427901 */:
                data0 = 4;
                break;
            case R.id.btn_plus19 /* 2131427897 */:
            case R.id.btn_plus23 /* 2131427931 */:
                data0 = 5;
                break;
            case R.id.btn_plus25 /* 2131427926 */:
                data0 = 38;
                break;
            case R.id.btn_plus24 /* 2131427927 */:
                data0 = 35;
                break;
            case R.id.btn_plus26 /* 2131427928 */:
                data0 = 36;
                break;
            case R.id.btn_plus27 /* 2131427929 */:
                data0 = 37;
                break;
            case R.id.btn_plus28 /* 2131427930 */:
                data0 = 9;
                break;
        }
        if (data0 != 0) {
            if (event.getAction() == 0) {
                DataCanbus.PROXY.cmd(12, new int[]{data0, 1}, null, null);
            } else if (event.getAction() == 1) {
                DataCanbus.PROXY.cmd(12, new int[]{data0}, null, null);
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[420] == 2) {
            DataCanbus.PROXY.cmd(21, new int[]{2}, null, null);
        } else if (DataCanbus.DATA[420] == 3) {
            DataCanbus.PROXY.cmd(21, new int[]{3}, null, null);
        } else {
            DataCanbus.PROXY.cmd(21, new int[]{1}, null, null);
        }
        FuncMain.setChannel(11);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    
    public void RefreshImageView5_delay() {
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                PAFordXMRadioAct.this.RefreshImageView5(DataCanbus.DATA[497]);
            }
        }, 50L);
    }

    
    public void RefreshImageView6_delay() {
        HandlerUI.getInstance().postDelayed(new Runnable() { 
            @Override
            public void run() {
                PAFordXMRadioAct.this.RefreshImageView6(DataCanbus.DATA[498]);
            }
        }, 50L);
    }

    
    public void RefreshImageView5(int value) {
        ImageView mIvImageview5 = (ImageView) findViewById(R.id.layout_view5);
        if (LauncherApplication.getScreenWidth() == 768) {
            mIvImageview5.layout(((value * Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B3) / 100) + 138, mIvImageview5.getTop(), 629, mIvImageview5.getBottom());
        } else if (LauncherApplication.getScreenWidth() == 1080) {
            mIvImageview5.layout(((value * 768) / 100) + 156, mIvImageview5.getTop(), 924, mIvImageview5.getBottom());
        } else {
            mIvImageview5.layout(((value * 768) / 100) + 216, mIvImageview5.getTop(), 984, mIvImageview5.getBottom());
        }
    }

    
    public void RefreshImageView6(int value) {
        ImageView mIvImageview6 = (ImageView) findViewById(R.id.layout_view6);
        if (LauncherApplication.getScreenWidth() == 768) {
            mIvImageview6.layout(((value * Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B3) / 100) + 113, mIvImageview6.getTop(), ((value * Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B3) / 100) + 164, mIvImageview6.getBottom());
        } else if (LauncherApplication.getScreenWidth() == 1080) {
            mIvImageview6.layout(((value * 768) / 100) + 116, mIvImageview6.getTop(), ((value * 768) / 100) + 196, mIvImageview6.getBottom());
        } else {
            mIvImageview6.layout(((value * 768) / 100) + 176, mIvImageview6.getTop(), ((value * 768) / 100) + 256, mIvImageview6.getBottom());
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[420].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[421].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[422].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[423].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[424].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[425].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[426].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[427].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[428].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[429].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[430].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[431].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[432].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[433].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[434].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[435].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[436].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[437].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[438].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[439].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[491].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[492].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[493].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[494].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[495].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[496].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[497].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[498].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[420].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[421].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[422].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[423].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[424].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[425].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[426].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[427].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[428].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[429].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[430].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[431].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[432].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[433].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[434].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[435].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[436].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[437].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[438].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[439].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[491].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[492].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[493].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[494].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[495].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[496].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[497].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[498].removeNotify(this.mNotifyCanbus);
    }
}
