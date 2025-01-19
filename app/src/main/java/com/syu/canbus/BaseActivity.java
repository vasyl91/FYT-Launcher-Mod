package com.syu.canbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.entity.CarInfo;

public class BaseActivity extends Activity {
    public View.OnClickListener mClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    protected void finalize() throws Throwable {
        removeNotify();
    }

    public void init() {
    }

    public void addNotify() {
    }

    public void removeNotify() {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }

    public void setClick(View v) {
        if (v != null && this.mClick != null) {
            v.setOnClickListener(this.mClick);
        }
    }

    public void setCheck(CheckedTextView v, boolean on) {
        if (v != null) {
            v.setChecked(on);
        }
    }

    public void setViewVisible(View v, boolean on) {
        if (v != null) {
            v.setVisibility(on ? 0 : 8);
        }
    }

    public void setViewVisible(View v, int state) {
        if (v != null) {
            v.setVisibility(state == 1 ? 0 : 8);
        }
    }

    public void setSelfClick(View v, View.OnClickListener l) {
        if (v != null && l != null) {
            v.setOnClickListener(l);
        }
    }

    public void setSelfTouch(View v, View.OnTouchListener l) {
        if (v != null && l != null) {
            v.setOnTouchListener(l);
        }
    }

    public <T extends View> T bindViewOnClick(int i, View.OnClickListener onClickListener) {
        T t = findViewById(i);
        setSelfClick(t, onClickListener);
        return t;
    }

    public CarInfo newCarInfoSwitch(int update, int name, int cmd, int para0) {
        CarInfo carInfo = new CarInfo(0, update, name);
        carInfo.setCmd(cmd, para0);
        return carInfo;
    }

    public CarInfo newCarInfoSwitchDisplay(int update, int name, int cmd, int para0, String[] display) {
        CarInfo carInfo = new CarInfo(3, update, name);
        carInfo.setCmd(cmd, para0);
        carInfo.setDiplsys(display);
        return carInfo;
    }

    public CarInfo newCarInfoButton(int update, int name, int cmd, int para0, String[] display) {
        CarInfo carInfo = new CarInfo(1, update, name);
        carInfo.setCmd(cmd, para0);
        carInfo.setDiplsys(display);
        return carInfo;
    }
}
