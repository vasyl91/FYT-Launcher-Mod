package org.apache.poi.poifs.storage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SmallDocumentBlock implements BlockWritable, ListManagedBlock {
    private static final int BLOCK_MASK = 63;
    private static final int BLOCK_SHIFT = 6;
    private static final int _block_size = 64;
    private static final byte _default_fill = -1;
    private final POIFSBigBlockSize _bigBlockSize;
    private final int _blocks_per_big_block;
    private byte[] _data;

    public static int calcSize(int i) {
        return i * 64;
    }

    private SmallDocumentBlock(POIFSBigBlockSize pOIFSBigBlockSize, byte[] bArr, int i) {
        this(pOIFSBigBlockSize);
        System.arraycopy(bArr, i * 64, this._data, 0, 64);
    }

    protected SmallDocumentBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        this._bigBlockSize = pOIFSBigBlockSize;
        this._blocks_per_big_block = getBlocksPerBigBlock(pOIFSBigBlockSize);
        this._data = new byte[64];
    }

    private static int getBlocksPerBigBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        return pOIFSBigBlockSize.getBigBlockSize() / 64;
    }

    public static SmallDocumentBlock[] convert(POIFSBigBlockSize pOIFSBigBlockSize, byte[] bArr, int i) {
        int i2 = ((i + 64) - 1) / 64;
        SmallDocumentBlock[] smallDocumentBlockArr = new SmallDocumentBlock[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            SmallDocumentBlock smallDocumentBlock = new SmallDocumentBlock(pOIFSBigBlockSize);
            smallDocumentBlockArr[i4] = smallDocumentBlock;
            if (i3 < bArr.length) {
                int iMin = Math.min(64, bArr.length - i3);
                System.arraycopy(bArr, i3, smallDocumentBlockArr[i4]._data, 0, iMin);
                if (iMin != 64) {
                    Arrays.fill(smallDocumentBlockArr[i4]._data, iMin, 64, (byte) -1);
                }
            } else {
                Arrays.fill(smallDocumentBlock._data, (byte) -1);
            }
            i3 += 64;
        }
        return smallDocumentBlockArr;
    }

    public static int fill(POIFSBigBlockSize pOIFSBigBlockSize, List<SmallDocumentBlock> list) {
        int blocksPerBigBlock = getBlocksPerBigBlock(pOIFSBigBlockSize);
        int size = list.size();
        int i = ((size + blocksPerBigBlock) - 1) / blocksPerBigBlock;
        int i2 = blocksPerBigBlock * i;
        while (size < i2) {
            list.add(makeEmptySmallDocumentBlock(pOIFSBigBlockSize));
            size++;
        }
        return i;
    }

    public static SmallDocumentBlock[] convert(POIFSBigBlockSize pOIFSBigBlockSize, BlockWritable[] blockWritableArr, int i) throws IOException, ArrayIndexOutOfBoundsException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (BlockWritable blockWritable : blockWritableArr) {
            blockWritable.writeBlocks(byteArrayOutputStream);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int iConvertToBlockCount = convertToBlockCount(i);
        SmallDocumentBlock[] smallDocumentBlockArr = new SmallDocumentBlock[iConvertToBlockCount];
        for (int i2 = 0; i2 < iConvertToBlockCount; i2++) {
            smallDocumentBlockArr[i2] = new SmallDocumentBlock(pOIFSBigBlockSize, byteArray, i2);
        }
        return smallDocumentBlockArr;
    }

    public static List<SmallDocumentBlock> extract(POIFSBigBlockSize pOIFSBigBlockSize, ListManagedBlock[] listManagedBlockArr) throws IOException {
        int blocksPerBigBlock = getBlocksPerBigBlock(pOIFSBigBlockSize);
        ArrayList arrayList = new ArrayList();
        for (ListManagedBlock listManagedBlock : listManagedBlockArr) {
            byte[] data = listManagedBlock.getData();
            for (int i = 0; i < blocksPerBigBlock; i++) {
                arrayList.add(new SmallDocumentBlock(pOIFSBigBlockSize, data, i));
            }
        }
        return arrayList;
    }

    public static DataInputBlock getDataInputBlock(SmallDocumentBlock[] smallDocumentBlockArr, int i) {
        return new DataInputBlock(smallDocumentBlockArr[i >> 6]._data, i & 63);
    }

    protected int getSmallBlocksPerBigBlock() {
        return this._blocks_per_big_block;
    }

    private static SmallDocumentBlock makeEmptySmallDocumentBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        SmallDocumentBlock smallDocumentBlock = new SmallDocumentBlock(pOIFSBigBlockSize);
        Arrays.fill(smallDocumentBlock._data, (byte) -1);
        return smallDocumentBlock;
    }

    private static int convertToBlockCount(int i) {
        return ((i + 64) - 1) / 64;
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        outputStream.write(this._data);
    }

    @Override // org.apache.poi.poifs.storage.ListManagedBlock
    public byte[] getData() {
        return this._data;
    }

    public POIFSBigBlockSize getBigBlockSize() {
        return this._bigBlockSize;
    }
}
