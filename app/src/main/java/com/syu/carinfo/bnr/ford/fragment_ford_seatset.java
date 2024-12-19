package com.syu.carinfo.bnr.ford;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.lang.ref.WeakReference;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class fragment_ford_seatset extends BaseFragment implements View.OnClickListener {
    private int cmd;
    int l0;
    int l1;
    int l2;
    int l3;
    int l4;
    int l5;
    int l6;
    int r0;
    int r1;
    int r2;
    int r3;
    int r4;
    int r5;
    int r6;
    private int val;
    int[] callids = {66, 67};
    boolean isPress = false;
    private View.OnTouchListener mTouch = new View.OnTouchListener() { // from class: com.syu.carinfo.bnr.ford.fragment_ford_seatset.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case 0:
                    fragment_ford_seatset.this.isPress = true;
                    Thread t = new Thread(fragment_ford_seatset.this.new LongClickedRunner(v));
                    t.start();
                    break;
                case 1:
                case 3:
                    fragment_ford_seatset.this.isPress = false;
                    switch (fragment_ford_seatset.this.cmd) {
                        case 188:
                        case 189:
                        case 190:
                        case 191:
                            break;
                        default:
                            fragment_ford_seatset.this.sendCMD(fragment_ford_seatset.this.cmd, 0);
                            break;
                    }
            }
            v.setPressed(fragment_ford_seatset.this.isPress);
            return true;
        }
    };
    int[] warnSoundCtrl = {R.string.klc_onstar_close, R.string.xp_ylford_set_voice_mode1, R.string.xp_ylford_set_voice_mode2, R.string.xp_ylford_set_voice_mode3, R.string.klc_air_auto};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.ford.fragment_ford_seatset.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            fragment_ford_seatset.this.val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 66:
                    fragment_ford_seatset.this.uLeft(fragment_ford_seatset.this.val);
                    break;
                case 67:
                    fragment_ford_seatset.this.uRight(fragment_ford_seatset.this.val);
                    break;
            }
        }
    };
    String[] strs = {"OFF", "LO", "HI"};

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
        View btnL0M = this.mView.findViewById(R.id.str_403_leftseat_0_m);
        View btnL0P = this.mView.findViewById(R.id.str_403_leftseat_0_p);
        View btnL1M = this.mView.findViewById(R.id.str_403_leftseat_1_m);
        View btnL1P = this.mView.findViewById(R.id.str_403_leftseat_1_p);
        View btnL2M = this.mView.findViewById(R.id.str_403_leftseat_2_m);
        View btnL2P = this.mView.findViewById(R.id.str_403_leftseat_2_p);
        View btnL3M = this.mView.findViewById(R.id.str_403_leftseat_3_m);
        View btnL3P = this.mView.findViewById(R.id.str_403_leftseat_3_p);
        View btnL4M = this.mView.findViewById(R.id.str_403_leftseat_4_m);
        View btnL4P = this.mView.findViewById(R.id.str_403_leftseat_4_p);
        View btnL5M = this.mView.findViewById(R.id.str_403_leftseat_5_m);
        View btnL5P = this.mView.findViewById(R.id.str_403_leftseat_5_p);
        View btnL6M = this.mView.findViewById(R.id.str_403_leftseat_6_m);
        View btnL6P = this.mView.findViewById(R.id.str_403_leftseat_6_p);
        View btnR0M = this.mView.findViewById(R.id.str_403_rightseat_0_m);
        View btnR0P = this.mView.findViewById(R.id.str_403_rightseat_0_p);
        View btnR1M = this.mView.findViewById(R.id.str_403_rightseat_1_m);
        View btnR1P = this.mView.findViewById(R.id.str_403_rightseat_1_p);
        View btnR2M = this.mView.findViewById(R.id.str_403_rightseat_2_m);
        View btnR2P = this.mView.findViewById(R.id.str_403_rightseat_2_p);
        View btnR3M = this.mView.findViewById(R.id.str_403_rightseat_3_m);
        View btnR3P = this.mView.findViewById(R.id.str_403_rightseat_3_p);
        View btnR4M = this.mView.findViewById(R.id.str_403_rightseat_4_m);
        View btnR4P = this.mView.findViewById(R.id.str_403_rightseat_4_p);
        View btnR5M = this.mView.findViewById(R.id.str_403_rightseat_5_m);
        View btnR5P = this.mView.findViewById(R.id.str_403_rightseat_5_p);
        View btnR6M = this.mView.findViewById(R.id.str_403_rightseat_6_m);
        View btnR6P = this.mView.findViewById(R.id.str_403_rightseat_6_p);
        setOnTouch(btnL0M);
        setOnTouch(btnL0P);
        setOnTouch(btnL1M);
        setOnTouch(btnL1P);
        setOnTouch(btnL2M);
        setOnTouch(btnL2P);
        setOnTouch(btnL3M);
        setOnTouch(btnL3P);
        setOnTouch(btnL4M);
        setOnTouch(btnL4P);
        setOnTouch(btnL5M);
        setOnTouch(btnL5P);
        setOnTouch(btnL6M);
        setOnTouch(btnL6P);
        setOnTouch(btnR0M);
        setOnTouch(btnR0P);
        setOnTouch(btnR1M);
        setOnTouch(btnR1P);
        setOnTouch(btnR2M);
        setOnTouch(btnR2P);
        setOnTouch(btnR3M);
        setOnTouch(btnR3P);
        setOnTouch(btnR4M);
        setOnTouch(btnR4P);
        setOnTouch(btnR5M);
        setOnTouch(btnR5P);
        setOnTouch(btnR6M);
        setOnTouch(btnR6P);
    }

    private void setOnTouch(View v) {
        if (v != null) {
            v.setOnTouchListener(this.mTouch);
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return R.layout.layout_0403_bnr_ford_seatset;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        for (int i : this.callids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        for (int i : this.callids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(1, new int[]{cmd, val}, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    private class LongClickedRunner implements Runnable {
        private WeakReference<View> mReference;
        private int type;

        public LongClickedRunner(View v) {
            this.mReference = new WeakReference<>(v);
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.mReference.get();
            this.type = 0;
            switch (view.getId()) {
                case R.id.str_403_leftseat_0_m /* 2131428050 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l0;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 178;
                    break;
                case R.id.str_403_leftseat_0_p /* 2131428052 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l0;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 178;
                    break;
                case R.id.str_403_leftseat_1_m /* 2131428053 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l1;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 179;
                    break;
                case R.id.str_403_leftseat_1_p /* 2131428055 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l1;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 179;
                    break;
                case R.id.str_403_leftseat_2_m /* 2131428056 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l2;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 180;
                    break;
                case R.id.str_403_leftseat_2_p /* 2131428058 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l2;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 180;
                    break;
                case R.id.str_403_leftseat_3_m /* 2131428059 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l3;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 181;
                    break;
                case R.id.str_403_leftseat_3_p /* 2131428061 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l3;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 181;
                    break;
                case R.id.str_403_leftseat_4_m /* 2131428062 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l4;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 182;
                    break;
                case R.id.str_403_leftseat_4_p /* 2131428064 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l4;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 182;
                    break;
                case R.id.str_403_leftseat_5_m /* 2131428065 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l5;
                    fragment_ford_seatset fragment_ford_seatsetVar = fragment_ford_seatset.this;
                    fragment_ford_seatsetVar.val--;
                    if (fragment_ford_seatset.this.val < 0) {
                        fragment_ford_seatset.this.val = 2;
                    }
                    fragment_ford_seatset.this.cmd = 188;
                    break;
                case R.id.str_403_leftseat_5_p /* 2131428067 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l5;
                    fragment_ford_seatset.this.val++;
                    if (fragment_ford_seatset.this.val > 2) {
                        fragment_ford_seatset.this.val = 0;
                    }
                    fragment_ford_seatset.this.cmd = 188;
                    break;
                case R.id.str_403_leftseat_6_m /* 2131428068 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l6;
                    fragment_ford_seatset fragment_ford_seatsetVar2 = fragment_ford_seatset.this;
                    fragment_ford_seatsetVar2.val--;
                    if (fragment_ford_seatset.this.val < 0) {
                        fragment_ford_seatset.this.val = 2;
                    }
                    fragment_ford_seatset.this.cmd = 189;
                    break;
                case R.id.str_403_leftseat_6_p /* 2131428070 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.l6;
                    fragment_ford_seatset.this.val++;
                    if (fragment_ford_seatset.this.val > 2) {
                        fragment_ford_seatset.this.val = 0;
                    }
                    fragment_ford_seatset.this.cmd = 189;
                    break;
                case R.id.str_403_rightseat_0_m /* 2131428071 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r0;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 183;
                    break;
                case R.id.str_403_rightseat_0_p /* 2131428073 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r0;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 183;
                    break;
                case R.id.str_403_rightseat_1_m /* 2131428074 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r1;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 184;
                    break;
                case R.id.str_403_rightseat_1_p /* 2131428076 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r1;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 184;
                    break;
                case R.id.str_403_rightseat_2_m /* 2131428077 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r2;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 185;
                    break;
                case R.id.str_403_rightseat_2_p /* 2131428079 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r2;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 185;
                    break;
                case R.id.str_403_rightseat_3_m /* 2131428080 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r3;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 186;
                    break;
                case R.id.str_403_rightseat_3_p /* 2131428082 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r3;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 186;
                    break;
                case R.id.str_403_rightseat_4_m /* 2131428083 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r4;
                    this.type = 10;
                    fragment_ford_seatset.this.cmd = 187;
                    break;
                case R.id.str_403_rightseat_4_p /* 2131428085 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r4;
                    this.type = 11;
                    fragment_ford_seatset.this.cmd = 187;
                    break;
                case R.id.str_403_rightseat_5_m /* 2131428086 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r5;
                    fragment_ford_seatset fragment_ford_seatsetVar3 = fragment_ford_seatset.this;
                    fragment_ford_seatsetVar3.val--;
                    if (fragment_ford_seatset.this.val < 0) {
                        fragment_ford_seatset.this.val = 2;
                    }
                    fragment_ford_seatset.this.cmd = 190;
                    break;
                case R.id.str_403_rightseat_5_p /* 2131428088 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r5;
                    fragment_ford_seatset.this.val++;
                    if (fragment_ford_seatset.this.val > 2) {
                        fragment_ford_seatset.this.val = 0;
                    }
                    fragment_ford_seatset.this.cmd = 190;
                    break;
                case R.id.str_403_rightseat_6_m /* 2131428089 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r6;
                    fragment_ford_seatset fragment_ford_seatsetVar4 = fragment_ford_seatset.this;
                    fragment_ford_seatsetVar4.val--;
                    if (fragment_ford_seatset.this.val < 0) {
                        fragment_ford_seatset.this.val = 2;
                    }
                    fragment_ford_seatset.this.cmd = 191;
                    break;
                case R.id.str_403_rightseat_6_p /* 2131428091 */:
                    fragment_ford_seatset.this.val = fragment_ford_seatset.this.r6;
                    fragment_ford_seatset.this.val++;
                    if (fragment_ford_seatset.this.val > 2) {
                        fragment_ford_seatset.this.val = 0;
                    }
                    fragment_ford_seatset.this.cmd = 191;
                    break;
            }
            while (fragment_ford_seatset.this.isPress) {
                if (this.type != 10) {
                    if (this.type != 11) {
                        fragment_ford_seatset.this.sendCMD(fragment_ford_seatset.this.cmd, fragment_ford_seatset.this.val);
                        return;
                    }
                    fragment_ford_seatset.this.val = 1;
                } else {
                    fragment_ford_seatset.this.val = 2;
                }
                fragment_ford_seatset.this.sendCMD(fragment_ford_seatset.this.cmd, fragment_ford_seatset.this.val);
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setText(TextView v, String str) {
        if (v != null) {
            v.setText(str);
        }
    }

    protected void uLeft(int val) {
        this.l0 = val & 15;
        this.l1 = (val >> 4) & 15;
        this.l2 = (val >> 8) & 15;
        this.l3 = (val >> 12) & 15;
        this.l4 = (val >> 16) & 15;
        this.l5 = (val >> 20) & 15;
        this.l6 = (this.l5 >> 2) & 3;
        this.l5 &= 3;
        setText((TextView) this.mView.findViewById(R.id.str_403_leftseat_0_txt), new StringBuilder(String.valueOf(this.l0)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_leftseat_1_txt), new StringBuilder(String.valueOf(this.l1)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_leftseat_2_txt), new StringBuilder(String.valueOf(this.l2)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_leftseat_3_txt), new StringBuilder(String.valueOf(this.l3)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_leftseat_4_txt), new StringBuilder(String.valueOf(this.l4)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_leftseat_5_txt), this.strs[this.l5]);
        setText((TextView) this.mView.findViewById(R.id.str_403_leftseat_6_txt), this.strs[this.l6]);
    }

    protected void uRight(int val) {
        this.r0 = val & 15;
        this.r1 = (val >> 4) & 15;
        this.r2 = (val >> 8) & 15;
        this.r3 = (val >> 12) & 15;
        this.r4 = (val >> 16) & 15;
        this.r5 = (val >> 20) & 15;
        this.r6 = (this.r5 >> 2) & 3;
        this.r5 &= 3;
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_0_txt), new StringBuilder(String.valueOf(this.r0)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_1_txt), new StringBuilder(String.valueOf(this.r1)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_2_txt), new StringBuilder(String.valueOf(this.r2)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_3_txt), new StringBuilder(String.valueOf(this.r3)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_4_txt), new StringBuilder(String.valueOf(this.r4)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_5_txt), new StringBuilder(String.valueOf(this.r5)).toString());
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_5_txt), this.strs[this.r5]);
        setText((TextView) this.mView.findViewById(R.id.str_403_rightseat_6_txt), this.strs[this.r6]);
    }
}
