package com.syu.entity;

import android.app.Fragment;
import android.content.SharedPreferences;

public class CarInfo {
    private int VehicleIdentifyValue;
    private Class<?> cls;
    private int cmdCode;
    private int cmdType;
    private String[] diplsys;
    private boolean hasDiableOptionForWC;
    private Fragment mFragment;
    private SharedPreferences sp1;
    private String title;
    private int titleId;
    public int type;
    private int updateCode;
    private int value;
    private int showValue = 1;
    int moveLeft = 0;
    private boolean showable = true;
    private boolean canCycleChange = false;

    public int getTitleId() {
        return this.titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public CarInfo(int type, int updateCode, String title) {
        this.type = type;
        this.updateCode = updateCode;
        this.title = title;
    }

    public CarInfo(int type, int updateCode, int titleId) {
        this.type = type;
        this.updateCode = updateCode;
        this.titleId = titleId;
    }

    public CarInfo(int type) {
        this.type = type;
    }

    public void setCmd(int cmdType, int cmdCode) {
        this.cmdType = cmdType;
        this.cmdCode = cmdCode;
    }

    public void setUpdateCode(int updateCode) {
        this.updateCode = updateCode;
        this.moveLeft = -1;
    }

    public void setUpdateCode(int updateCode, int moveLeft) {
        this.updateCode = updateCode;
        this.moveLeft = moveLeft;
    }

    public int getMoveLeft() {
        return this.moveLeft;
    }

    public Class<?> getCls() {
        return this.cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public int getShowValue() {
        return this.showValue;
    }

    public void setShowValue(int showValue) {
        this.showValue = showValue;
    }

    public int getType() {
        return this.type;
    }

    public int getUpdateCode() {
        return this.updateCode;
    }

    public int getCmdType() {
        return this.cmdType;
    }

    public int getCmdCode() {
        return this.cmdCode;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getDiplsys() {
        return this.diplsys;
    }

    public void setDiplsys(String[] diplsys) {
        this.diplsys = diplsys;
    }

    public boolean isShowable() {
        return this.showable;
    }

    public void setShowable(boolean showable) {
        this.showable = showable;
    }

    public void setSharedPreferences(SharedPreferences sp1) {
        this.sp1 = sp1;
    }

    public SharedPreferences getSharedPreferences() {
        return this.sp1;
    }

    public void setVehicleIdentifyValue(int VehicleIdentifyValue) {
        this.VehicleIdentifyValue = VehicleIdentifyValue;
    }

    public int getVehicleIdentifyValue() {
        return this.VehicleIdentifyValue;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    public boolean isCanCycleChange() {
        return this.canCycleChange;
    }

    public void setCanCycleChange(boolean canCycleChange) {
        this.canCycleChange = canCycleChange;
    }

    public boolean isHasDiableOptionForWC() {
        return this.hasDiableOptionForWC;
    }

    public void setHasDiableOptionForWC(boolean hasDiableOptionForWC) {
        this.hasDiableOptionForWC = hasDiableOptionForWC;
    }
}
