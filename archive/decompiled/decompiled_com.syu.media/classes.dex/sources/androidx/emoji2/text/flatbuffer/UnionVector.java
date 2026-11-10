package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i, int i2, ByteBuffer byteBuffer) {
        __reset(i, i2, byteBuffer);
        return this;
    }

    public Table get(Table table, int i) {
        return Table.__union(table, __element(i), this.bb);
    }
}
