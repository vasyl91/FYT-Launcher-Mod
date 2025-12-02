package com.syu.carinfo.ford;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class LZFordDoornumSetAct extends Activity implements View.OnTouchListener {
    public static StringBuffer mTvCurrPasswordBuffer = new StringBuffer();
    private LZFordDoornumWindow mPaFordDoorNumWindow;
    int Keypad_code = 0;
    int NewKeypad_code = 0;
    View view_doornum = null;
    StringBuffer mTvCurrPasswordBuffer1 = new StringBuffer();
    StringBuffer mTvCurrPasswordBuffer2 = new StringBuffer();
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 168:
                    if (LZFordDoornumSetAct.this.view_doornum != null) {
                        switch (value) {
                            case 1:
                                LZFordDoornumSetAct.this.mPaFordDoorNumWindow.showWindow(LZFordDoornumSetAct.this.view_doornum, 14);
                                break;
                            case 3:
                                LZFordDoornumSetAct.this.mPaFordDoorNumWindow.showWindow(LZFordDoornumSetAct.this.view_doornum, 5);
                                break;
                            case 4:
                                LZFordDoornumSetAct.this.mPaFordDoorNumWindow.showWindow(LZFordDoornumSetAct.this.view_doornum, 2);
                                break;
                            case 5:
                                LZFordDoornumSetAct.this.mPaFordDoorNumWindow.showWindow(LZFordDoornumSetAct.this.view_doornum, 3);
                                break;
                            case 6:
                                LZFordDoornumSetAct.this.mPaFordDoorNumWindow.showWindow(LZFordDoornumSetAct.this.view_doornum, 1);
                                break;
                        }
                    }
                    break;
                case 169:
                    if (LZFordDoornumSetAct.this.view_doornum != null) {
                        if (value == 2 || value == 15) {
                            LZFordDoornumSetAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                            LZFordDoornumSetAct.this.findViewById(R.id.layout_view1).setVisibility(8);
                            LZFordDoornumSetAct.this.findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang_p);
                            LZFordDoornumSetAct.this.findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang);
                            LZFordDoornumSetAct.this.Keypad_code = 1;
                            break;
                        } else if (value == 14) {
                            LZFordDoornumSetAct.this.findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang_p);
                            LZFordDoornumSetAct.this.findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang);
                            LZFordDoornumSetAct.this.NewKeypad_code = 0;
                            LZFordDoornumSetAct.this.mPaFordDoorNumWindow.showWindow(LZFordDoornumSetAct.this.view_doornum, value);
                            break;
                        } else if (value == 13) {
                            LZFordDoornumSetAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                            LZFordDoornumSetAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                            LZFordDoornumSetAct.this.Keypad_code = 0;
                            LZFordDoornumSetAct.this.NewKeypad_code = 0;
                            break;
                        } else if (value == 1) {
                            LZFordDoornumSetAct.this.mPaFordDoorNumWindow.showWindow(LZFordDoornumSetAct.this.view_doornum, 4);
                            break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0374_pa_ford_doornum);
        init();
    }

    public void init() {
        this.mPaFordDoorNumWindow = new LZFordDoornumWindow(this);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
        findViewById(R.id.btn_plus5).setOnTouchListener(this);
        findViewById(R.id.btn_plus6).setOnTouchListener(this);
        findViewById(R.id.btn_plus7).setOnTouchListener(this);
        findViewById(R.id.btn_plus8).setOnTouchListener(this);
        findViewById(R.id.btn_plus9).setOnTouchListener(this);
    }

    void UpdatePassWord(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text1)).setText("");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText("*");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText("**");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText("***");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText("****");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text1)).setText("*****");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_s);
                break;
        }
    }

    void UpdatePassWord1(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText("");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText("*");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText("**");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText("***");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text2)).setText("****");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text2)).setText("*****");
                this.NewKeypad_code = 1;
                findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang_p);
                findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang);
                break;
        }
    }

    void UpdatePassWord2(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText("");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText("*");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText("**");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text3)).setText("***");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text3)).setText("****");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text3)).setText("*****");
                findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_s);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.view_doornum = v;
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427457 */:
                    if (this.Keypad_code == 0) {
                        if (((TextView) findViewById(R.id.tv_text1)) != null && mTvCurrPasswordBuffer.length() < 5) {
                            mTvCurrPasswordBuffer.append('0');
                            UpdatePassWord(mTvCurrPasswordBuffer.length());
                        }
                    } else if (this.Keypad_code == 1) {
                        if (this.NewKeypad_code == 0) {
                            if (((TextView) findViewById(R.id.tv_text2)) != null && this.mTvCurrPasswordBuffer1.length() < 5) {
                                this.mTvCurrPasswordBuffer1.append('0');
                                UpdatePassWord1(this.mTvCurrPasswordBuffer1.length());
                            }
                        } else if (this.NewKeypad_code == 1 && ((TextView) findViewById(R.id.tv_text3)) != null && this.mTvCurrPasswordBuffer2.length() < 5) {
                            this.mTvCurrPasswordBuffer2.append('0');
                            UpdatePassWord2(this.mTvCurrPasswordBuffer2.length());
                        }
                    }
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    if (this.Keypad_code == 0) {
                        if (((TextView) findViewById(R.id.tv_text1)) != null && mTvCurrPasswordBuffer.length() < 5) {
                            mTvCurrPasswordBuffer.append('1');
                            UpdatePassWord(mTvCurrPasswordBuffer.length());
                        }
                    } else if (this.Keypad_code == 1) {
                        if (this.NewKeypad_code == 0) {
                            if (((TextView) findViewById(R.id.tv_text2)) != null && this.mTvCurrPasswordBuffer1.length() < 5) {
                                this.mTvCurrPasswordBuffer1.append('1');
                                UpdatePassWord1(this.mTvCurrPasswordBuffer1.length());
                            }
                        } else if (this.NewKeypad_code == 1 && ((TextView) findViewById(R.id.tv_text3)) != null && this.mTvCurrPasswordBuffer2.length() < 5) {
                            this.mTvCurrPasswordBuffer2.append('1');
                            UpdatePassWord2(this.mTvCurrPasswordBuffer2.length());
                        }
                    }
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    if (this.Keypad_code == 0) {
                        if (((TextView) findViewById(R.id.tv_text1)) != null && mTvCurrPasswordBuffer.length() < 5) {
                            mTvCurrPasswordBuffer.append('2');
                            UpdatePassWord(mTvCurrPasswordBuffer.length());
                        }
                    } else if (this.Keypad_code == 1) {
                        if (this.NewKeypad_code == 0) {
                            if (((TextView) findViewById(R.id.tv_text2)) != null && this.mTvCurrPasswordBuffer1.length() < 5) {
                                this.mTvCurrPasswordBuffer1.append('2');
                                UpdatePassWord1(this.mTvCurrPasswordBuffer1.length());
                            }
                        } else if (this.NewKeypad_code == 1 && ((TextView) findViewById(R.id.tv_text3)) != null && this.mTvCurrPasswordBuffer2.length() < 5) {
                            this.mTvCurrPasswordBuffer2.append('2');
                            UpdatePassWord2(this.mTvCurrPasswordBuffer2.length());
                        }
                    }
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    if (this.Keypad_code == 0) {
                        if (((TextView) findViewById(R.id.tv_text1)) != null && mTvCurrPasswordBuffer.length() < 5) {
                            mTvCurrPasswordBuffer.append('3');
                            UpdatePassWord(mTvCurrPasswordBuffer.length());
                        }
                    } else if (this.Keypad_code == 1) {
                        if (this.NewKeypad_code == 0) {
                            if (((TextView) findViewById(R.id.tv_text2)) != null && this.mTvCurrPasswordBuffer1.length() < 5) {
                                this.mTvCurrPasswordBuffer1.append('3');
                                UpdatePassWord1(this.mTvCurrPasswordBuffer1.length());
                            }
                        } else if (this.NewKeypad_code == 1 && ((TextView) findViewById(R.id.tv_text3)) != null && this.mTvCurrPasswordBuffer2.length() < 5) {
                            this.mTvCurrPasswordBuffer2.append('3');
                            UpdatePassWord2(this.mTvCurrPasswordBuffer2.length());
                        }
                    }
                    break;
                case R.id.btn_plus5 /* 2131427469 */:
                    if (this.Keypad_code == 0) {
                        if (((TextView) findViewById(R.id.tv_text1)) != null && mTvCurrPasswordBuffer.length() < 5) {
                            mTvCurrPasswordBuffer.append('4');
                            UpdatePassWord(mTvCurrPasswordBuffer.length());
                        }
                    } else if (this.Keypad_code == 1) {
                        if (this.NewKeypad_code == 0) {
                            if (((TextView) findViewById(R.id.tv_text2)) != null && this.mTvCurrPasswordBuffer1.length() < 5) {
                                this.mTvCurrPasswordBuffer1.append('4');
                                UpdatePassWord1(this.mTvCurrPasswordBuffer1.length());
                            }
                        } else if (this.NewKeypad_code == 1 && ((TextView) findViewById(R.id.tv_text3)) != null && this.mTvCurrPasswordBuffer2.length() < 5) {
                            this.mTvCurrPasswordBuffer2.append('4');
                            UpdatePassWord2(this.mTvCurrPasswordBuffer2.length());
                        }
                    }
                    break;
                case R.id.btn_plus6 /* 2131427472 */:
                    if (this.Keypad_code == 0) {
                        if (mTvCurrPasswordBuffer.length() == 5) {
                            findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_p);
                            ((Button) findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#666666"));
                            DataCanbus.PROXY.cmd(22, new int[]{0, mTvCurrPasswordBuffer.codePointAt(0) - 48, mTvCurrPasswordBuffer.codePointAt(1) - 48, mTvCurrPasswordBuffer.codePointAt(2) - 48, mTvCurrPasswordBuffer.codePointAt(3) - 48, mTvCurrPasswordBuffer.codePointAt(4) - 48}, null, null);
                        } else {
                            findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                            ((Button) findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                        }
                    } else if (this.Keypad_code == 1 && this.mTvCurrPasswordBuffer1.length() == 5 && this.mTvCurrPasswordBuffer2.length() == 5) {
                        if (this.mTvCurrPasswordBuffer1.codePointAt(0) == this.mTvCurrPasswordBuffer2.codePointAt(0) && this.mTvCurrPasswordBuffer1.codePointAt(1) == this.mTvCurrPasswordBuffer2.codePointAt(1) && this.mTvCurrPasswordBuffer1.codePointAt(2) == this.mTvCurrPasswordBuffer2.codePointAt(2) && this.mTvCurrPasswordBuffer1.codePointAt(3) == this.mTvCurrPasswordBuffer2.codePointAt(3) && this.mTvCurrPasswordBuffer1.codePointAt(4) == this.mTvCurrPasswordBuffer2.codePointAt(4)) {
                            DataCanbus.PROXY.cmd(22, new int[]{1, this.mTvCurrPasswordBuffer2.codePointAt(0) - 48, this.mTvCurrPasswordBuffer2.codePointAt(1) - 48, this.mTvCurrPasswordBuffer2.codePointAt(2) - 48, this.mTvCurrPasswordBuffer2.codePointAt(3) - 48, this.mTvCurrPasswordBuffer2.codePointAt(4) - 48}, null, null);
                        } else {
                            RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                            int[] iArr = new int[6];
                            iArr[0] = 14;
                            remoteModuleProxy.cmd(22, iArr, null, null);
                            findViewById(R.id.ctv_checkedtext1).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang_p);
                            findViewById(R.id.ctv_checkedtext2).setBackgroundResource(R.drawable.ic_pa_toyota_radio_kuang);
                            this.NewKeypad_code = 0;
                        }
                    }
                    break;
                case R.id.btn_plus7 /* 2131427475 */:
                    if (((TextView) findViewById(R.id.tv_text1)) != null && mTvCurrPasswordBuffer.length() > 0) {
                        mTvCurrPasswordBuffer.deleteCharAt(mTvCurrPasswordBuffer.length() - 1);
                        UpdatePassWord(mTvCurrPasswordBuffer.length());
                    }
                    break;
                case R.id.btn_plus8 /* 2131427478 */:
                    if (((TextView) findViewById(R.id.tv_text2)) != null && this.mTvCurrPasswordBuffer1.length() > 0) {
                        this.mTvCurrPasswordBuffer1.deleteCharAt(this.mTvCurrPasswordBuffer2.length() - 1);
                        UpdatePassWord1(this.mTvCurrPasswordBuffer1.length());
                    }
                    break;
                case R.id.btn_plus9 /* 2131427481 */:
                    if (((TextView) findViewById(R.id.tv_text3)) != null && this.mTvCurrPasswordBuffer2.length() > 0) {
                        this.mTvCurrPasswordBuffer2.deleteCharAt(this.mTvCurrPasswordBuffer2.length() - 1);
                        UpdatePassWord2(this.mTvCurrPasswordBuffer2.length());
                    }
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.btn_plus6 /* 2131427472 */:
                    if (this.Keypad_code == 0) {
                        if (mTvCurrPasswordBuffer.length() == 5) {
                            findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                            ((TextView) findViewById(R.id.tv_text1)).setText("");
                            mTvCurrPasswordBuffer.delete(0, mTvCurrPasswordBuffer.length());
                            ((Button) findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                        }
                    } else if (this.Keypad_code == 1 && this.mTvCurrPasswordBuffer1.length() == 5 && this.mTvCurrPasswordBuffer2.length() == 5) {
                        findViewById(R.id.btn_plus6).setBackgroundResource(R.drawable.ic_pa_ford_xmradio_channels_n);
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        ((TextView) findViewById(R.id.tv_text3)).setText("");
                        this.mTvCurrPasswordBuffer1.delete(0, this.mTvCurrPasswordBuffer1.length());
                        this.mTvCurrPasswordBuffer2.delete(0, this.mTvCurrPasswordBuffer2.length());
                        ((Button) findViewById(R.id.btn_plus6)).setTextColor(Color.parseColor("#ffffff"));
                    }
                    break;
                default:
                    return false;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.layout_view1).setVisibility(0);
        findViewById(R.id.layout_view2).setVisibility(8);
        this.Keypad_code = 0;
        this.NewKeypad_code = 0;
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.notifyCanbus);
    }
}
