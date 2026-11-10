package com.alibaba.fastjson.asm;

import android.support.v4.view.accessibility.AccessibilityEventCompat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
final class FieldWriter implements FieldVisitor {
    private final int access;
    private final int desc;
    private final int name;
    FieldWriter next;

    FieldWriter(ClassWriter cw, int access, String name, String desc) {
        if (cw.firstField == null) {
            cw.firstField = this;
        } else {
            cw.lastField.next = this;
        }
        cw.lastField = this;
        this.access = access;
        this.name = cw.newUTF8(name);
        this.desc = cw.newUTF8(desc);
    }

    @Override // com.alibaba.fastjson.asm.FieldVisitor
    public void visitEnd() {
    }

    int getSize() {
        return 8;
    }

    void put(ByteVector out) {
        int mask = 393216 | ((this.access & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) / 64);
        out.putShort(this.access & (mask ^ (-1))).putShort(this.name).putShort(this.desc);
        out.putShort(0);
    }
}
