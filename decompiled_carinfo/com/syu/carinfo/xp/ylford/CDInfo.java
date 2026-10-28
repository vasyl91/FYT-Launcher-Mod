package com.syu.carinfo.xp.ylford;

@SuppressWarnings({"deprecation", "unchecked"})
public class CDInfo {
    int index;
    String str;

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public CDInfo(int index, String str) {
        this.index = index;
        this.str = str;
    }
}
