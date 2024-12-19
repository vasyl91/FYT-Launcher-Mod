package com.syu.carinfo.hava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ActivityHava18H6Index extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hava.ActivityHava18H6Index.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 144:
                    if (value == 1) {
                        ActivityHava18H6Index.this.findViewById(R.id.layout_view2).setVisibility(0);
                        break;
                    } else {
                        ActivityHava18H6Index.this.findViewById(R.id.layout_view2).setVisibility(8);
                        break;
                    }
                case 145:
                    if (1310964 == DataCanbus.DATA[1000] || 1638644 == DataCanbus.DATA[1000] || 2097396 == DataCanbus.DATA[1000] || 2162932 == DataCanbus.DATA[1000]) {
                        if (value == 1) {
                            ActivityHava18H6Index.this.findViewById(R.id.layout_view1).setVisibility(0);
                            break;
                        } else {
                            ActivityHava18H6Index.this.findViewById(R.id.layout_view1).setVisibility(8);
                            break;
                        }
                    } else {
                        ActivityHava18H6Index.this.findViewById(R.id.layout_view1).setVisibility(8);
                        break;
                    }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_index_rzc_havalh6);
        if (1310964 == DataCanbus.DATA[1000] || 1638644 == DataCanbus.DATA[1000] || 2097396 == DataCanbus.DATA[1000] || 2162932 == DataCanbus.DATA[1000]) {
            if (DataCanbus.DATA[145] == 1) {
                findViewById(R.id.layout_view1).setVisibility(0);
            } else {
                findViewById(R.id.layout_view1).setVisibility(8);
            }
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        if (DataCanbus.DATA[144] == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
        } else {
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        ((Button) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.ActivityHava18H6Index.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityHava18H6Index.this.startActivity(new Intent(ActivityHava18H6Index.this, (Class<?>) ActivityHava18H6SetAct.class));
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.ActivityHava18H6Index.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityHava18H6Index.this.startActivity(new Intent(ActivityHava18H6Index.this, (Class<?>) ActivityHavaRZCH2SCarInfo.class));
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.ActivityHava18H6Index.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityHava18H6Index.this.startActivity(new Intent(ActivityHava18H6Index.this, (Class<?>) ActivityHavaH7CarCD.class));
            }
        });
        ((Button) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.hava.ActivityHava18H6Index.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ActivityHava18H6Index.this.startActivity(new Intent(ActivityHava18H6Index.this, (Class<?>) ActivityHavaEQSetAct.class));
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
    }
}
