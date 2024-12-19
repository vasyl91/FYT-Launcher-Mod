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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAFordSeatSetAct extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static PAFordSeatSetAct mInit;
    int pagenum = 0;
    int pagenum1 = 0;
    int pagenum_massage = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAFordSeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 390:
                    if (PAFordSeatSetAct.this.pagenum == 1) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 391:
                    if (PAFordSeatSetAct.this.pagenum == 1) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 464:
                    if (PAFordSeatSetAct.this.pagenum == 0) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 465:
                    if (PAFordSeatSetAct.this.pagenum == 0) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B74 /* 466 */:
                    if (PAFordSeatSetAct.this.pagenum == 1) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D50_D2_B30 /* 467 */:
                    if (PAFordSeatSetAct.this.pagenum == 0) {
                        ((TextView) PAFordSeatSetAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 468:
                    if (PAFordSeatSetAct.this.pagenum_massage == 0 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case 469:
                    if (PAFordSeatSetAct.this.pagenum_massage == 1 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case 470:
                    if (PAFordSeatSetAct.this.pagenum_massage == 2 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D1_B76 /* 471 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 3 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B10 /* 472 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 4 && PAFordSeatSetAct.this.pagenum == 0) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B32 /* 473 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 0 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B54 /* 474 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 1 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B76 /* 475 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 2 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B10 /* 476 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 3 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
                case Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D3_B32 /* 477 */:
                    if (PAFordSeatSetAct.this.pagenum_massage == 4 && PAFordSeatSetAct.this.pagenum == 1) {
                        PAFordSeatSetAct.this.updateMassageState(value);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_ford_seatset);
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
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus13 /* 2131427470 */:
                    this.pagenum_massage = 2;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[475]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[470]);
                        break;
                    }
                case R.id.btn_plus14 /* 2131427473 */:
                    this.pagenum_massage = 3;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[476]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[471]);
                        break;
                    }
                case R.id.btn_plus15 /* 2131427476 */:
                    this.pagenum_massage = 4;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[477]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[472]);
                        break;
                    }
                case R.id.btn_plus1 /* 2131427482 */:
                    this.pagenum = 0;
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[464])).toString());
                    ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[465])).toString());
                    ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[467])).toString());
                    switch (this.pagenum_massage) {
                        case 0:
                            updateMassageState(DataCanbus.DATA[468]);
                            break;
                        case 1:
                            updateMassageState(DataCanbus.DATA[469]);
                            break;
                        case 2:
                            updateMassageState(DataCanbus.DATA[470]);
                            break;
                        case 3:
                            updateMassageState(DataCanbus.DATA[471]);
                            break;
                        case 4:
                            updateMassageState(DataCanbus.DATA[472]);
                            break;
                    }
                case R.id.btn_plus2 /* 2131427486 */:
                    this.pagenum = 1;
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                    ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[466])).toString());
                    ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[391])).toString());
                    ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[390])).toString());
                    switch (this.pagenum_massage) {
                        case 0:
                            updateMassageState(DataCanbus.DATA[473]);
                            break;
                        case 1:
                            updateMassageState(DataCanbus.DATA[474]);
                            break;
                        case 2:
                            updateMassageState(DataCanbus.DATA[475]);
                            break;
                        case 3:
                            updateMassageState(DataCanbus.DATA[476]);
                            break;
                        case 4:
                            updateMassageState(DataCanbus.DATA[477]);
                            break;
                    }
                case R.id.btn_plus3 /* 2131427490 */:
                    this.pagenum1 = 0;
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.layout_view1).setVisibility(0);
                    findViewById(R.id.layout_view2).setVisibility(8);
                    break;
                case R.id.btn_plus4 /* 2131427494 */:
                    this.pagenum1 = 1;
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.layout_view2).setVisibility(0);
                    findViewById(R.id.layout_view1).setVisibility(8);
                    break;
                case R.id.btn_plus5 /* 2131427498 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{83}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{80}, null, null);
                        break;
                    }
                case R.id.btn_plus6 /* 2131427503 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{84}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{81}, null, null);
                        break;
                    }
                case R.id.btn_plus7 /* 2131427507 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{85}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{82}, null, null);
                        break;
                    }
                case R.id.btn_plus8 /* 2131427511 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{83, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{80, 1}, null, null);
                        break;
                    }
                case R.id.btn_plus9 /* 2131427515 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{84, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{81, 1}, null, null);
                        break;
                    }
                case R.id.btn_plus10 /* 2131427519 */:
                    if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(0, new int[]{85, 1}, null, null);
                        break;
                    } else {
                        DataCanbus.PROXY.cmd(0, new int[]{82, 1}, null, null);
                        break;
                    }
                case R.id.btn_plus11 /* 2131427523 */:
                    this.pagenum_massage = 0;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[473]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[468]);
                        break;
                    }
                case R.id.btn_plus12 /* 2131427527 */:
                    this.pagenum_massage = 1;
                    updateMassageState1(this.pagenum_massage);
                    if (this.pagenum == 1) {
                        updateMassageState(DataCanbus.DATA[474]);
                        break;
                    } else {
                        updateMassageState(DataCanbus.DATA[469]);
                        break;
                    }
                case R.id.btn_plus18 /* 2131427879 */:
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
                case R.id.btn_plus19 /* 2131427881 */:
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
                case R.id.btn_plus16 /* 2131427889 */:
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
                case R.id.btn_plus17 /* 2131427891 */:
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
            }
        }
        return false;
    }

    @Override // android.app.Activity
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
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[466])).toString());
                ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[391])).toString());
                ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[390])).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[464])).toString());
                ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[465])).toString());
                ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(DataCanbus.DATA[467])).toString());
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
                    updateMassageState(DataCanbus.DATA[473]);
                    break;
                case 1:
                    updateMassageState(DataCanbus.DATA[474]);
                    break;
                case 2:
                    updateMassageState(DataCanbus.DATA[475]);
                    break;
                case 3:
                    updateMassageState(DataCanbus.DATA[476]);
                    break;
                case 4:
                    updateMassageState(DataCanbus.DATA[477]);
                    break;
            }
        }
        switch (this.pagenum_massage) {
            case 0:
                updateMassageState(DataCanbus.DATA[468]);
                break;
            case 1:
                updateMassageState(DataCanbus.DATA[469]);
                break;
            case 2:
                updateMassageState(DataCanbus.DATA[470]);
                break;
            case 3:
                updateMassageState(DataCanbus.DATA[471]);
                break;
            case 4:
                updateMassageState(DataCanbus.DATA[472]);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[464].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[465].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[467].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[466].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[391].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[390].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[468].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[469].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[470].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[471].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[472].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[473].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[474].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[475].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[476].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[477].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[464].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[465].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[467].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[466].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[391].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[390].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[468].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[469].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[470].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[471].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[472].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[473].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[474].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[475].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[476].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[477].removeNotify(this.notifyCanbus);
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

    /* JADX INFO: Access modifiers changed from: private */
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
