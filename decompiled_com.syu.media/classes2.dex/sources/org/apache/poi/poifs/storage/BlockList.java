package org.apache.poi.poifs.storage;

import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public interface BlockList {
    int blockCount();

    ListManagedBlock[] fetchBlocks(int i, int i2) throws IOException;

    ListManagedBlock remove(int i) throws IOException;

    void setBAT(BlockAllocationTableReader blockAllocationTableReader) throws IOException;

    void zap(int i);
}
