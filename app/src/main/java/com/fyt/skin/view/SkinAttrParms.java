package com.fyt.skin.view;

public class SkinAttrParms {
    private String attrName;
    private int id;

    public SkinAttrParms(String attrName, int id) {
        this.attrName = attrName;
        this.id = id;
    }

    public String getAttrName() {
        return this.attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
