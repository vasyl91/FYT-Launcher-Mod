package com.syu.carinfo.xp.ziyouguang;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class PAFordDirectTuneWindow extends BaseActivity implements View.OnClickListener {
    private View mRootView;
    private PopupWindow mWindow;
    StringBuffer mTvCurrPasswordBuffer = new StringBuffer();
    int pagenum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAFordDirectTuneWindow.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };

    public PAFordDirectTuneWindow(PAFordXMRadioAct act) {
        initView();
        initPop();
    }

    private void initPop() {
        if (this.mWindow == null) {
            this.mWindow = new PopupWindow(TheApp.getInstance());
            this.mWindow.setContentView(this.mRootView);
            this.mWindow.setAnimationStyle(R.style.contextMenuAnim);
            this.mWindow.setWidth(-1);
            this.mWindow.setHeight(-1);
            this.mWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.mWindow.setOutsideTouchable(false);
            try {
                Field mLayoutInScreen = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                mLayoutInScreen.setAccessible(true);
                mLayoutInScreen.set(this.mWindow, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mRootView = View.inflate(TheApp.getInstance(), R.layout.layout_0374_pa_ford_directune_num, null);
        ((Button) this.mRootView.findViewById(R.id.pop_close)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus5)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus9)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus10)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus11)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus12)).setOnClickListener(this);
        ((Button) this.mRootView.findViewById(R.id.btn_plus13)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus13 /* 2131427470 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    switch (DataCanbus.DATA[408]) {
                        case 1:
                            if (this.mTvCurrPasswordBuffer.length() == 4 && this.mTvCurrPasswordBuffer.codePointAt(0) != 46 && this.mTvCurrPasswordBuffer.codePointAt(1) != 46 && this.mTvCurrPasswordBuffer.codePointAt(2) == 46 && this.mTvCurrPasswordBuffer.codePointAt(3) != 46) {
                                int n1 = (this.mTvCurrPasswordBuffer.codePointAt(0) - 48) * 100;
                                int n2 = (this.mTvCurrPasswordBuffer.codePointAt(1) - 48) * 10;
                                int n3 = this.mTvCurrPasswordBuffer.codePointAt(3) - 48;
                                int value = n1 + n2 + n3;
                                if (value >= 860) {
                                    DataCanbus.PROXY.cmd(23, new int[]{(value >> 8) & 255, value & 255}, null, null);
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                    hideWindow();
                                } else {
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Error");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                }
                            } else if (this.mTvCurrPasswordBuffer.length() == 5 && this.mTvCurrPasswordBuffer.codePointAt(0) != 46 && this.mTvCurrPasswordBuffer.codePointAt(1) != 46 && this.mTvCurrPasswordBuffer.codePointAt(2) != 46 && this.mTvCurrPasswordBuffer.codePointAt(3) == 46 && this.mTvCurrPasswordBuffer.codePointAt(4) != 46) {
                                int n4 = (this.mTvCurrPasswordBuffer.codePointAt(0) - 48) * 1000;
                                int n5 = (this.mTvCurrPasswordBuffer.codePointAt(1) - 48) * 100;
                                int n6 = (this.mTvCurrPasswordBuffer.codePointAt(2) - 48) * 10;
                                int n7 = this.mTvCurrPasswordBuffer.codePointAt(4) - 48;
                                int value2 = n4 + n5 + n6 + n7;
                                if (value2 >= 1000 && value2 <= 1080) {
                                    DataCanbus.PROXY.cmd(23, new int[]{(value2 >> 8) & 255, value2 & 255}, null, null);
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                    hideWindow();
                                } else {
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Error");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                }
                            } else {
                                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Error");
                                this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                            }
                            break;
                        case 2:
                            if (this.mTvCurrPasswordBuffer.length() == 3 && this.mTvCurrPasswordBuffer.codePointAt(0) != 46 && this.mTvCurrPasswordBuffer.codePointAt(1) != 46 && this.mTvCurrPasswordBuffer.codePointAt(2) != 46) {
                                int n8 = (this.mTvCurrPasswordBuffer.codePointAt(0) - 48) * 100;
                                int n9 = (this.mTvCurrPasswordBuffer.codePointAt(1) - 48) * 10;
                                int n10 = this.mTvCurrPasswordBuffer.codePointAt(2) - 48;
                                int value3 = n8 + n9 + n10;
                                if (value3 >= 520) {
                                    DataCanbus.PROXY.cmd(23, new int[]{(value3 >> 8) & 255, value3 & 255}, null, null);
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                    hideWindow();
                                } else {
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Error");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                }
                            } else if (this.mTvCurrPasswordBuffer.length() == 4 && this.mTvCurrPasswordBuffer.codePointAt(0) != 46 && this.mTvCurrPasswordBuffer.codePointAt(1) != 46 && this.mTvCurrPasswordBuffer.codePointAt(2) != 46 && this.mTvCurrPasswordBuffer.codePointAt(3) != 46) {
                                int n11 = (this.mTvCurrPasswordBuffer.codePointAt(0) - 48) * 1000;
                                int n12 = (this.mTvCurrPasswordBuffer.codePointAt(1) - 48) * 100;
                                int n13 = (this.mTvCurrPasswordBuffer.codePointAt(2) - 48) * 10;
                                int n14 = this.mTvCurrPasswordBuffer.codePointAt(3) - 48;
                                int value4 = n11 + n12 + n13 + n14;
                                if (value4 >= 1000 && value4 <= 1720) {
                                    DataCanbus.PROXY.cmd(23, new int[]{(value4 >> 8) & 255, value4 & 255}, null, null);
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                    hideWindow();
                                } else {
                                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Error");
                                    this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                }
                            } else {
                                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Error");
                                this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                            }
                            break;
                        case 3:
                            if (this.mTvCurrPasswordBuffer.length() == 3 && this.mTvCurrPasswordBuffer.codePointAt(0) != 46 && this.mTvCurrPasswordBuffer.codePointAt(1) != 46 && this.mTvCurrPasswordBuffer.codePointAt(2) != 46) {
                                int n15 = (this.mTvCurrPasswordBuffer.codePointAt(0) - 48) * 100;
                                int n16 = (this.mTvCurrPasswordBuffer.codePointAt(1) - 48) * 10;
                                int n17 = this.mTvCurrPasswordBuffer.codePointAt(2) - 48;
                                int value5 = n15 + n16 + n17;
                                DataCanbus.PROXY.cmd(23, new int[]{(value5 >> 8) & 255, value5 & 255}, null, null);
                                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("");
                                this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                hideWindow();
                            } else if (this.mTvCurrPasswordBuffer.length() == 2 && this.mTvCurrPasswordBuffer.codePointAt(0) != 46 && this.mTvCurrPasswordBuffer.codePointAt(1) != 46) {
                                int n18 = (this.mTvCurrPasswordBuffer.codePointAt(0) - 48) * 10;
                                int n19 = this.mTvCurrPasswordBuffer.codePointAt(1) - 48;
                                int value6 = n18 + n19;
                                DataCanbus.PROXY.cmd(23, new int[]{(value6 >> 8) & 255, value6 & 255}, null, null);
                                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("");
                                this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                hideWindow();
                            } else if (this.mTvCurrPasswordBuffer.length() == 1 && this.mTvCurrPasswordBuffer.codePointAt(0) != 46) {
                                int n20 = this.mTvCurrPasswordBuffer.codePointAt(0) - 48;
                                DataCanbus.PROXY.cmd(23, new int[]{(n20 >> 8) & 255, n20 & 255}, null, null);
                                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("");
                                this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                                hideWindow();
                            } else {
                                ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText("Error");
                                this.mTvCurrPasswordBuffer.delete(0, this.mTvCurrPasswordBuffer.length());
                            }
                            break;
                    }
                }
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('1');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('2');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('3');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('4');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('5');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null && this.mTvCurrPasswordBuffer.length() >= 1) {
                    this.mTvCurrPasswordBuffer.deleteCharAt(this.mTvCurrPasswordBuffer.length() - 1);
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                    break;
                }
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('6');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('7');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('8');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('9');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('0');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                if (((TextView) this.mRootView.findViewById(R.id.tv_text1)) != null) {
                    this.mTvCurrPasswordBuffer.append('.');
                    ((TextView) this.mRootView.findViewById(R.id.tv_text1)).setText(this.mTvCurrPasswordBuffer);
                }
                break;
            case R.id.pop_close /* 2131427922 */:
                hideWindow();
                break;
        }
    }

    public void showWindow(View Parent) {
        this.mWindow.showAtLocation(Parent, 48, 0, TheApp.getScreenHeight());
        addNotify();
    }

    public void hideWindow() {
        this.mWindow.dismiss();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[408].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[408].removeNotify(this.mNotifyCanbus);
    }
}
