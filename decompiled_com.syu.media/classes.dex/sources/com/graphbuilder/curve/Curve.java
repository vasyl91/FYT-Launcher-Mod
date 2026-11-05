package com.graphbuilder.curve;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class Curve {
    protected boolean connect = false;
    protected ControlPath cp;
    protected GroupIterator gi;

    public abstract void appendTo(MultiPath multiPath);

    public void resetMemory() {
    }

    public Curve(ControlPath controlPath, GroupIterator groupIterator) {
        setControlPath(controlPath);
        setGroupIterator(groupIterator);
    }

    public ControlPath getControlPath() {
        return this.cp;
    }

    public void setControlPath(ControlPath controlPath) {
        if (controlPath == null) {
            throw new IllegalArgumentException("ControlPath cannot be null.");
        }
        this.cp = controlPath;
    }

    public GroupIterator getGroupIterator() {
        return this.gi;
    }

    public void setGroupIterator(GroupIterator groupIterator) {
        if (groupIterator == null) {
            throw new IllegalArgumentException("GroupIterator cannot be null.");
        }
        this.gi = groupIterator;
    }

    public boolean getConnect() {
        return this.connect;
    }

    public void setConnect(boolean z) {
        this.connect = z;
    }
}
