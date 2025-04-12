package com.syu.module.canbus.up;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;

public class CanbusUpIndexActi extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchCanbus();
        finish();
    }

    public void launchCanbus() {
        Class<?> cls = null;
        switch (DataCanUp.DATA[100]) {
            case 1:
                cls = SbdUpdateActi.class;
                break;
            case 2:
            case 5:
            case 7:
            case 8:
            case 10:
            case 19:
                cls = WcUpdateActi.class;
                break;
            case 3:
            case 9:
            case 12:
            case 13:
            case 14:
            case 15:
            case 17:
            case 18:
            case 20:
                cls = XpUpdateActi.class;
                break;
            case 4:
                cls = ActivityAiYingUpgrade.class;
                break;
            case 6:
                cls = WcUpdateActi.class;
                break;
            case 11:
            case 16:
                cls = XpUpdateActi.class;
                break;
        }
        if (cls != null) {
            startActivity(new Intent(LauncherApplication.getInstance(), cls));
        } else {
            Toast.makeText(getApplication(), getApplication().getResources().getString(R.string.canbus_update_unsport), 0).show();
        }
    }
}
