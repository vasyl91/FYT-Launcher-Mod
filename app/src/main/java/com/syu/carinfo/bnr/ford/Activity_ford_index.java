package com.syu.carinfo.bnr.ford;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.module.canbus.DataCanbus;

import java.util.ArrayList;
import java.util.Iterator;

public class Activity_ford_index extends BaseActivity implements View.OnClickListener {
    private ArrayList<String> mFragmentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0403_bnr_ford_index);
        init();
    }

    @Override
    public void init() {
        View carset = findViewById(R.id.id_carset);
        View sync = findViewById(R.id.ctv_ylfocus_sync);
        View seatset = findViewById(R.id.id_seatset);
        setSelfClick(carset, this);
        setSelfClick(sync, this);
        setSelfClick(seatset, this);
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        if (197011 != DataCanbus.DATA[1000]) {
            findViewById(R.id.layout_view1).setVisibility(8);
            findViewById(R.id.layout_view2).setVisibility(8);
        }
        this.mFragmentlist = new ArrayList<>();
        this.mFragmentlist.add(fragment_ford_carset.class.getCanonicalName());
        this.mFragmentlist.add(fragment_ford_seatset.class.getCanonicalName());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            Iterator<String> it = this.mFragmentlist.iterator();
            while (it.hasNext()) {
                String str = it.next();
                Fragment findFragmentByTag = getFragmentManager().findFragmentByTag(str);
                if (findFragmentByTag != null && findFragmentByTag.isAdded()) {
                    beginTransaction.remove(findFragmentByTag).commitAllowingStateLoss();
                    return true;
                }
            }
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                try {
                    Intent intent = new Intent(this, (Class<?>) KXMDOCarTire.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                try {
                    Intent intent2 = new Intent(this, (Class<?>) KXMDOEQSetAct.class);
                    startActivity(intent2);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.id_carset /* 2131428046 */:
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.replace(R.id.container, new fragment_ford_carset(), this.mFragmentlist.get(0)).commitAllowingStateLoss();
                break;
            case R.id.ctv_ylfocus_sync /* 2131428048 */:
                try {
                    Intent intent3 = new Intent(this, (Class<?>) FocusSyncBtActi.class);
                    startActivity(intent3);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.id_seatset /* 2131428049 */:
                FragmentTransaction beginTransaction2 = getFragmentManager().beginTransaction();
                beginTransaction2.replace(R.id.container, new fragment_ford_seatset(), this.mFragmentlist.get(1)).commitAllowingStateLoss();
                break;
        }
    }
}
