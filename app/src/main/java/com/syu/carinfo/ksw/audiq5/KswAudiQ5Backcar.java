package com.syu.carinfo.ksw.audiq5;

import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class KswAudiQ5Backcar extends BaseActivity {
    public static KswAudiQ5Backcar mInstance;
    public static boolean mIsFront = false;
    int touchMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        //setContentView(R.layout.layout_ksw_audiq5_backcar);
        initUI();
        mInstance = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
        mIsFront = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.PROXY.cmd(10, new int[1], null, null);
        mIsFront = false;
    }

    private void initUI() {
        findViewById(R.id.layout_main).setOnTouchListener(new View.OnTouchListener() { 
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
            
                return true;
             */
            @Override
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
                /*
                    r10 = this;
                    r9 = 2
                    r5 = 0
                    r8 = 4
                    r7 = 0
                    r6 = 1
                    float r2 = r12.getX()
                    int r0 = (int) r2
                    float r2 = r12.getY()
                    int r1 = (int) r2
                    int r2 = r12.getAction()
                    switch(r2) {
                        case 0: goto L35;
                        case 1: goto L17;
                        default: goto L16;
                    }
                L16:
                    return r6
                L17:
                    com.syu.ipc.RemoteModuleProxy r2 = com.syu.module.canbus.DataCanbus.PROXY
                    r3 = 5
                    int[] r3 = new int[r3]
                    int r4 = r0 >> 8
                    r4 = r4 & 255(0xff, float:3.57E-43)
                    r3[r5] = r4
                    r4 = r0 & 255(0xff, float:3.57E-43)
                    r3[r6] = r4
                    int r4 = r1 >> 8
                    r4 = r4 & 255(0xff, float:3.57E-43)
                    r3[r9] = r4
                    r4 = 3
                    r5 = r1 & 255(0xff, float:3.57E-43)
                    r3[r4] = r5
                    r2.cmd(r8, r3, r7, r7)
                    goto L16
                L35:
                    com.syu.ipc.RemoteModuleProxy r2 = com.syu.module.canbus.DataCanbus.PROXY
                    r3 = 5
                    int[] r3 = new int[r3]
                    int r4 = r0 >> 8
                    r4 = r4 & 255(0xff, float:3.57E-43)
                    r3[r5] = r4
                    r4 = r0 & 255(0xff, float:3.57E-43)
                    r3[r6] = r4
                    int r4 = r1 >> 8
                    r4 = r4 & 255(0xff, float:3.57E-43)
                    r3[r9] = r4
                    r4 = 3
                    r5 = r1 & 255(0xff, float:3.57E-43)
                    r3[r4] = r5
                    r3[r8] = r6
                    r2.cmd(r8, r3, r7, r7)
                    goto L16
                */
                throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }
}
