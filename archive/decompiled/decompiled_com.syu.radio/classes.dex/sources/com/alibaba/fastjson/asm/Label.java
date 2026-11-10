package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Label {
    static final int RESOLVED = 2;
    public Object info;
    int inputStackTop;
    int line;
    Label next;
    int outputStackMax;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int status;
    Label successor;

    void put(MethodWriter owner, ByteVector out, int source) {
        if ((this.status & 2) == 0) {
            addReference(source, out.length);
            out.putShort(-1);
        } else {
            out.putShort(this.position - source);
        }
    }

    private void addReference(int sourcePosition, int referencePosition) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        if (this.referenceCount >= this.srcAndRefPositions.length) {
            int[] a = new int[this.srcAndRefPositions.length + 6];
            System.arraycopy(this.srcAndRefPositions, 0, a, 0, this.srcAndRefPositions.length);
            this.srcAndRefPositions = a;
        }
        int[] iArr = this.srcAndRefPositions;
        int i = this.referenceCount;
        this.referenceCount = i + 1;
        iArr[i] = sourcePosition;
        int[] iArr2 = this.srcAndRefPositions;
        int i2 = this.referenceCount;
        this.referenceCount = i2 + 1;
        iArr2[i2] = referencePosition;
    }

    void resolve(MethodWriter owner, int position, byte[] data) {
        this.status |= 2;
        this.position = position;
        int i = 0;
        while (i < this.referenceCount) {
            int i2 = i + 1;
            int source = this.srcAndRefPositions[i];
            i = i2 + 1;
            int reference = this.srcAndRefPositions[i2];
            int offset = position - source;
            data[reference] = (byte) (offset >>> 8);
            data[reference + 1] = (byte) offset;
        }
    }
}
