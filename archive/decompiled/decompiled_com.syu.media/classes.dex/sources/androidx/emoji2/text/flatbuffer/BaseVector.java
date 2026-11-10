package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class BaseVector {
    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;

    protected int __vector() {
        return this.vector;
    }

    protected int __element(int i) {
        return this.vector + (i * this.element_size);
    }

    protected void __reset(int i, int i2, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i;
            this.length = byteBuffer.getInt(i - 4);
            this.element_size = i2;
        } else {
            this.vector = 0;
            this.length = 0;
            this.element_size = 0;
        }
    }

    public void reset() {
        __reset(0, 0, null);
    }

    public int length() {
        return this.length;
    }
}
