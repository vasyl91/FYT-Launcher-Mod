package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class PAFordSeatSetAct extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static PAFordSeatSetAct mInit;
    int pagenum = 0;
    int pagenum1 = 0;
    int pagenum_massage = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 402:
                    if (PAFordSeatSetAct.this.pagenum == 1) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 403:
                    if (PAFordSeatSetAct.this.pagenum == 1) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D1_B30 /* 476 */:
                    if (PAFordSeatSetAct.this.pagenum == 0) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D1_B74 /* 477 */:
                    if (PAFordSeatSetAct.this.pagenum == 0) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B74 /* 478 */:
                    if (PAFordSeatSetAct.this.pagenum == 1) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B30 /* 479 */:
                    if (PAFordSeatSetAct.this.pagenum == 0) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B10 /* 480 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 0 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B32 /* 481 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 1 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B54 /* 482 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 2 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B76 /* 483 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 3 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B10 /* 484 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 4 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B32 /* 485 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 0 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B54 /* 486 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 1 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B76 /* 487 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 2 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B10 /* 488 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 3 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B32 /* 489 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 4 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_ford_seatset);
        init();
    }

    public void init() {
        mInit = this;
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
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427457 */:
                    this.pagenum = 0;
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[476])).toString());
                    ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[477])).toString());
                    ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[479])).toString());
                    switch (this.pagenum_massage) {
                        case 0:
                            updateMassageState(DataCanbus.DATA[480]);
                            break;
                        case 1:
                            updateMassageState(DataCanbus.DATA[481]);
                            break;
                        case 2:
                            updateMassageState(DataCanbus.DATA[482]);
                            break;
                        case 3:
                            updateMassageState(DataCanbus.DATA[483]);
                            break;
                        case 4:
                            updateMassageState(DataCanbus.DATA[484]);
                            break;
                    }
                case R.id.btn_plus2 /* 2131427460 */:
                    this.pagenum = 1;
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[478])).toString());
                    ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[403])).toString());
                    ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[402])).toString());
                    switch (this.pagenum_massage) {
                        case 0:
                            updateMassageState(DataCanbus.DATA[485]);
                            break;
                        case 1:
                            updateMassageState(DataCanbus.DATA[486]);
                            break;
                        case 2:
                            updateMassageState(DataCanbus.DATA[487]);
                            break;
                        case 3:
                            updateMassageState(DataCanbus.DATA[488]);
                            break;
                        case 4:
                            updateMassageState(DataCanbus.DATA[489]);
                            break;
                    }
                case R.id.btn_plus3 /* 2131427463 */:
                    this.pagenum1 = 0;
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.layout_view1).setVisibility(0);
                    findViewById(R.id.layout_view2).setVisibility(8);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    this.pagenum1 = 1;
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.layout_view2).setVisibility(0);
                    findViewById(R.id.layout_view1).setVisibility(8);
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{83}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{80}, null, null);
                        break;
                    }
                case R.id.btn_plus6 /* 2131427472 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{84}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{81}, null, null);
                        break;
                    }
                case R.id.btn_plus7 /* 2131427475 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{85}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{82}, null, null);
                        break;
                    }
                case R.id.btn_plus8 /* 2131427478 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{83, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{80, 1}, null, null);
                        break;
                    }
                case R.id.btn_plus9 /* 2131427481 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{84, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{81, 1}, null, null);
                        break;
                    }
                case R.id.btn_plus10 /* 2131427484 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{85, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{82, 1}, null, null);
                        break;
                    }
                case R.id.btn_plus11 /* 2131427487 */:
                    this.pagenum_massage = 0;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[485]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[480]);
                        break;
                    }
                case R.id.btn_plus12 /* 2131427490 */:
                    this.pagenum_massage = 1;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[486]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[481]);
                        break;
                    }
                case R.id.btn_plus13 /* 2131427493 */:
                    this.pagenum_massage = 2;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[487]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[482]);
                        break;
                    }
                case R.id.btn_plus14 /* 2131427496 */:
                    this.pagenum_massage = 3;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[488]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[483]);
                        break;
                    }
                case R.id.btn_plus15 /* 2131427517 */:
                    this.pagenum_massage = 4;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[489]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[484]);
                        break;
                    }
                case R.id.btn_plus16 /* 2131427520 */:
                    if (this.pagenum == 1) {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{91, 1}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{92, 1}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{93, 1}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{94, 1}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{95, 1}, null, null);
                                break;
                        }
                    } else {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{86, 1}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{87, 1}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{88, 1}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{89, 1}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{90, 1}, null, null);
                                break;
                        }
                    }
                case R.id.btn_plus17 /* 2131427523 */:
                    if (this.pagenum == 1) {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{91, 2}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{92, 2}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{93, 2}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{94, 2}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{95, 2}, null, null);
                                break;
                        }
                    } else {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{86, 2}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{87, 2}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{88, 2}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{89, 2}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{90, 2}, null, null);
                                break;
                        }
                    }
                case R.id.btn_plus18 /* 2131427895 */:
                    if (this.pagenum == 1) {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{91, 3}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{92, 3}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{93, 3}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{94, 3}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{95, 3}, null, null);
                                break;
                        }
                    } else {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{86, 3}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{87, 3}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{88, 3}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{89, 3}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{90, 3}, null, null);
                                break;
                        }
                    }
                case R.id.btn_plus19 /* 2131427897 */:
                    if (this.pagenum == 1) {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{91}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{92}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{93}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{94}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{95}, null, null);
                                break;
                        }
                    } else {
                        switch (this.pagenum_massage) {
                            case 0:
                                DataCanbus.PROXY.cmd(0, new int[]{86}, null, null);
                                break;
                            case 1:
                                DataCanbus.PROXY.cmd(0, new int[]{87}, null, null);
                                break;
                            case 2:
                                DataCanbus.PROXY.cmd(0, new int[]{88}, null, null);
                                break;
                            case 3:
                                DataCanbus.PROXY.cmd(0, new int[]{89}, null, null);
                                break;
                            case 4:
                                DataCanbus.PROXY.cmd(0, new int[]{90}, null, null);
                                break;
                        }
                    }
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        isFront = true;
        if (this.pagenum == 0) {
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
            ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
        } else if (this.pagenum == 1) {
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
            ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
        }
        if (this.pagenum1 == 0) {
            findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
            findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
            ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
            findViewById(R.id.layout_view1).setVisibility(0);
            findViewById(R.id.layout_view2).setVisibility(8);
            if (this.pagenum == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[478])).toString());
                ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[403])).toString());
                ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[402])).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[476])).toString());
                ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[477])).toString());
                ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[479])).toString());
            }
        } else if (this.pagenum1 == 1) {
            findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
            findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
            ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
            findViewById(R.id.layout_view2).setVisibility(0);
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        updateMassageState1(this.pagenum_massage);
        if (this.pagenum == 1) {
            switch (this.pagenum_massage) {
                case 0:
                    updateMassageState(DataCanbus.DATA[485]);
                    break;
                case 1:
                    updateMassageState(DataCanbus.DATA[486]);
                    break;
                case 2:
                    updateMassageState(DataCanbus.DATA[487]);
                    break;
                case 3:
                    updateMassageState(DataCanbus.DATA[488]);
                    break;
                case 4:
                    updateMassageState(DataCanbus.DATA[489]);
                    break;
            }
        }
        switch (this.pagenum_massage) {
            case 0:
                updateMassageState(DataCanbus.DATA[480]);
                break;
            case 1:
                updateMassageState(DataCanbus.DATA[481]);
                break;
            case 2:
                updateMassageState(DataCanbus.DATA[482]);
                break;
            case 3:
                updateMassageState(DataCanbus.DATA[483]);
                break;
            case 4:
                updateMassageState(DataCanbus.DATA[484]);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[476].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[477].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[479].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[478].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[403].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[402].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[480].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[481].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[482].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[483].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[484].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[485].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[486].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[487].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[488].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[489].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[476].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[477].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[479].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[478].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[403].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[402].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[480].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[481].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[482].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[483].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[484].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[485].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[486].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[487].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[488].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[489].removeNotify(this.notifyCanbus);
    }

    private void updateMassageState1(int value) {
        ((Button) findViewById(R.id.btn_plus11)).setTextColor(Color.parseColor("#ffffff"));
        ((Button) findViewById(R.id.btn_plus13)).setTextColor(Color.parseColor("#ffffff"));
        ((Button) findViewById(R.id.btn_plus13)).setTextColor(Color.parseColor("#ffffff"));
        ((Button) findViewById(R.id.btn_plus14)).setTextColor(Color.parseColor("#ffffff"));
        ((Button) findViewById(R.id.btn_plus15)).setTextColor(Color.parseColor("#ffffff"));
        findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        findViewById(R.id.btn_plus15).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.btn_plus11)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus11).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
            case 1:
                ((Button) findViewById(R.id.btn_plus12)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus12).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
            case 2:
                ((Button) findViewById(R.id.btn_plus13)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus13).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
            case 3:
                ((Button) findViewById(R.id.btn_plus14)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus14).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
            case 4:
                ((Button) findViewById(R.id.btn_plus15)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus15).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
        }
    }

    
    public void updateMassageState(int value) {
        ((Button) findViewById(R.id.btn_plus16)).setTextColor(Color.parseColor("#ffffff"));
        ((Button) findViewById(R.id.btn_plus17)).setTextColor(Color.parseColor("#ffffff"));
        ((Button) findViewById(R.id.btn_plus18)).setTextColor(Color.parseColor("#ffffff"));
        ((Button) findViewById(R.id.btn_plus19)).setTextColor(Color.parseColor("#ffffff"));
        findViewById(R.id.btn_plus16).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        findViewById(R.id.btn_plus18).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        findViewById(R.id.btn_plus19).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
        switch (value) {
            case 0:
                ((Button) findViewById(R.id.btn_plus19)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus19).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
            case 1:
                ((Button) findViewById(R.id.btn_plus16)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus16).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
            case 2:
                ((Button) findViewById(R.id.btn_plus17)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus17).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
            case 3:
                ((Button) findViewById(R.id.btn_plus18)).setTextColor(Color.parseColor("#666666"));
                findViewById(R.id.btn_plus18).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                break;
        }
    }
}
