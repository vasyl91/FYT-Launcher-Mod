package com.syu.carinfo.aiying.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JeepCarCD extends BaseActivity {
    public static JeepCarCD mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 128:
                case 129:
                case 130:
                    JeepCarCD.this.mUpdaterStatus();
                    break;
                case 131:
                case 132:
                    JeepCarCD.this.mUpdaterTrack();
                    break;
                case 133:
                case 134:
                    JeepCarCD.this.mUpdaterTrackTime();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_jeep_365_carcd);
        mInstance = this;
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.jeep_btn_play)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_ff)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_fr)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_pause)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_loop)).setOnTouchListener(new ButtonListener());
        ((Button) findViewById(R.id.jeep_btn_random)).setOnTouchListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener, View.OnTouchListener {
        ButtonListener() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
        
            return false;
         */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
            /*
                r6 = this;
                r5 = 0
                r4 = 3
                r2 = 1
                r3 = 0
                int r0 = r7.getId()
                switch(r0) {
                    case 2131427585: goto Lc;
                    case 2131427586: goto L64;
                    case 2131427622: goto L46;
                    case 2131427623: goto L29;
                    case 2131427737: goto L82;
                    case 2131427740: goto La1;
                    default: goto Lb;
                }
            Lb:
                return r5
            Lc:
                int r0 = r8.getAction()
                if (r0 != r2) goto L19
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r0.cmd(r4, r1, r3, r3)
            L19:
                int r0 = r8.getAction()
                if (r0 != 0) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r1[r5] = r2
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            L29:
                int r0 = r8.getAction()
                if (r0 != r2) goto L36
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r0.cmd(r4, r1, r3, r3)
            L36:
                int r0 = r8.getAction()
                if (r0 != 0) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r1[r5] = r4
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            L46:
                int r0 = r8.getAction()
                if (r0 != r2) goto L53
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r0.cmd(r4, r1, r3, r3)
            L53:
                int r0 = r8.getAction()
                if (r0 != 0) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r2 = 5
                r1[r5] = r2
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            L64:
                int r0 = r8.getAction()
                if (r0 != r2) goto L71
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r0.cmd(r4, r1, r3, r3)
            L71:
                int r0 = r8.getAction()
                if (r0 != 0) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r2 = 2
                r1[r5] = r2
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            L82:
                int r0 = r8.getAction()
                if (r0 != r2) goto L8f
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r0.cmd(r4, r1, r3, r3)
            L8f:
                int r0 = r8.getAction()
                if (r0 != 0) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r2 = 7
                r1[r5] = r2
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            La1:
                int r0 = r8.getAction()
                if (r0 != r2) goto Lae
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r0.cmd(r4, r1, r3, r3)
            Lae:
                int r0 = r8.getAction()
                if (r0 != 0) goto Lb
                com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                int[] r1 = new int[r2]
                r2 = 8
                r1[r5] = r2
                r0.cmd(r4, r1, r3, r3)
                goto Lb
            */
            throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.aiying.ziyouguang.JeepCarCD.ButtonListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        @Override
        public void onClick(View v) {
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(3, new int[]{51}, null, null);
        addNotify();
        FuncMain.setChannel(13);
        DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterStatus() {
        int value = DataCanbus.DATA[128];
        int value1 = DataCanbus.DATA[129];
        int value2 = DataCanbus.DATA[130];
        StringBuffer sb = new StringBuffer();
        switch (value) {
            case 0:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate11));
                break;
            case 1:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate5));
                break;
            case 2:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate10));
                break;
            case 3:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate4));
                break;
            case 4:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate6));
                break;
            case 15:
                sb.append(LauncherApplication.getInstance().getResources().getString(R.string.jeep_playstate2));
                break;
        }
        if (value2 == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_on));
        } else {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_loop_off));
        }
        if (value1 == 0) {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_on));
        } else {
            sb.append("  " + LauncherApplication.getInstance().getResources().getString(R.string.jeep_random_off));
        }
        ((TextView) findViewById(R.id.jeep_tv_state)).setText(sb.toString());
    }

    
    public void mUpdaterTrack() {
        int track = DataCanbus.DATA[131];
        int tarckTotal = DataCanbus.DATA[132];
        if (track == 16777215 || tarckTotal == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText("--/--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_track)).setText(String.format("%d/%d", Integer.valueOf(track), Integer.valueOf(tarckTotal)));
        }
    }

    
    public void mUpdaterTrackTime() {
        int value = DataCanbus.DATA[133];
        int valueall = DataCanbus.DATA[134];
        if (value == 16777215) {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText("--:-- / --:--");
        } else {
            ((TextView) findViewById(R.id.jeep_tv_time)).setText(String.format("%02d:%02d / %02d:%02d", Integer.valueOf(value / 60), Integer.valueOf(value % 60), Integer.valueOf(valueall / 60), Integer.valueOf(valueall % 60)));
        }
        if (valueall > 0) {
            int progress = (value * 100) / valueall;
            if (progress > 100) {
                progress = 100;
            }
            ((ProgressBar) findViewById(R.id.jeep_progress)).setProgress(progress);
        }
    }
}
