package com.graphbuilder.struc;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class Stack extends LinkedList {
    public Object peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.userObject;
    }

    public Object pop() {
        return removeHead();
    }

    public void push(Object obj) {
        addToHead(obj);
    }
}
