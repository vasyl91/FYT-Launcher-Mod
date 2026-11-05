package org.apache.poi.poifs.storage;

import java.io.IOException;
import org.apache.poi.util.Internal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
abstract class BlockListImpl implements BlockList {
    private ListManagedBlock[] _blocks = new ListManagedBlock[0];
    private BlockAllocationTableReader _bat = null;

    protected BlockListImpl() {
    }

    protected void setBlocks(ListManagedBlock[] listManagedBlockArr) {
        this._blocks = (ListManagedBlock[]) listManagedBlockArr.clone();
    }

    @Override // org.apache.poi.poifs.storage.BlockList
    public void zap(int i) {
        if (i >= 0) {
            ListManagedBlock[] listManagedBlockArr = this._blocks;
            if (i < listManagedBlockArr.length) {
                listManagedBlockArr[i] = null;
            }
        }
    }

    @Internal
    public ListManagedBlock get(int i) {
        return this._blocks[i];
    }

    @Override // org.apache.poi.poifs.storage.BlockList
    public ListManagedBlock remove(int i) throws IOException {
        try {
            ListManagedBlock[] listManagedBlockArr = this._blocks;
            ListManagedBlock listManagedBlock = listManagedBlockArr[i];
            if (listManagedBlock == null) {
                throw new IOException("block[ " + i + " ] already removed - does your POIFS have circular or duplicate block references?");
            }
            listManagedBlockArr[i] = null;
            return listManagedBlock;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IOException("Cannot remove block[ " + i + " ]; out of range[ 0 - " + (this._blocks.length - 1) + " ]");
        }
    }

    @Override // org.apache.poi.poifs.storage.BlockList
    public ListManagedBlock[] fetchBlocks(int i, int i2) throws IOException {
        BlockAllocationTableReader blockAllocationTableReader = this._bat;
        if (blockAllocationTableReader == null) {
            throw new IOException("Improperly initialized list: no block allocation table provided");
        }
        return blockAllocationTableReader.fetchBlocks(i, i2, this);
    }

    @Override // org.apache.poi.poifs.storage.BlockList
    public void setBAT(BlockAllocationTableReader blockAllocationTableReader) throws IOException {
        if (this._bat != null) {
            throw new IOException("Attempt to replace existing BlockAllocationTable");
        }
        this._bat = blockAllocationTableReader;
    }

    @Override // org.apache.poi.poifs.storage.BlockList
    public int blockCount() {
        return this._blocks.length;
    }

    protected int remainingBlocks() {
        int i = 0;
        int i2 = 0;
        while (true) {
            ListManagedBlock[] listManagedBlockArr = this._blocks;
            if (i >= listManagedBlockArr.length) {
                return i2;
            }
            if (listManagedBlockArr[i] != null) {
                i2++;
            }
            i++;
        }
    }
}
