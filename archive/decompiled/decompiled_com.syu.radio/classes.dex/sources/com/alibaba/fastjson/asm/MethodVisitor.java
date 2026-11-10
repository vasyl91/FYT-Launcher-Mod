package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface MethodVisitor {
    void visitEnd();

    void visitFieldInsn(int i, String str, String str2, String str3);

    void visitIincInsn(int i, int i2);

    void visitInsn(int i);

    void visitIntInsn(int i, int i2);

    void visitJumpInsn(int i, Label label);

    void visitLabel(Label label);

    void visitLdcInsn(Object obj);

    void visitMaxs(int i, int i2);

    void visitMethodInsn(int i, String str, String str2, String str3);

    void visitTypeInsn(int i, String str);

    void visitVarInsn(int i, int i2);
}
