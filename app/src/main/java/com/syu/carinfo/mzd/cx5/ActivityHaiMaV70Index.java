package com.syu.carinfo.mzd.cx5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.R;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHaiMaV70Index extends Activity {
    CheckedTextView mCtvAirControl;
    CheckedTextView mCtvInfo;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_237_index);
        this.mCtvInfo = (CheckedTextView) findViewById(R.id.haima_car_settings);
        this.mCtvAirControl = (CheckedTextView) findViewById(R.id.haima_air_control);
        this.mCtvInfo.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.carinfo.mzd.cx5.ActivityHaiMaV70Index.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
            
                return true;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
                /*
                    r4 = this;
                    r3 = 176(0xb0, float:2.47E-43)
                    r2 = 1
                    r1 = 0
                    int r0 = r6.getAction()
                    switch(r0) {
                        case 0: goto Lc;
                        case 1: goto L12;
                        default: goto Lb;
                    }
                Lb:
                    return r2
                Lc:
                    com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                    r0.cmd(r1, r3, r2)
                    goto Lb
                L12:
                    com.syu.ipc.RemoteModuleProxy r0 = com.syu.module.canbus.DataCanbus.PROXY
                    r0.cmd(r1, r3, r1)
                    goto Lb
                */
                throw new UnsupportedOperationException("Method not decompiled: com.syu.carinfo.mzd.cx5.ActivityHaiMaV70Index.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        this.mCtvAirControl.setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.mzd.cx5.ActivityHaiMaV70Index.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHaiMaV70Index.this, (Class<?>) HaiMaV70AirControl.class);
                ActivityHaiMaV70Index.this.startActivity(intent);
            }
        });
    }
}
