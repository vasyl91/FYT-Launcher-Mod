package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.poifs.property.RootProperty;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.BlockAllocationTableWriter;
import org.apache.poi.poifs.storage.HeaderBlock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NPOIFSMiniStore extends BlockStore {
    private NPOIFSFileSystem _filesystem;
    private HeaderBlock _header;
    private NPOIFSStream _mini_stream;
    private RootProperty _root;
    private List<BATBlock> _sbat_blocks;

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected int getBlockStoreBlockSize() {
        return 64;
    }

    protected NPOIFSMiniStore(NPOIFSFileSystem nPOIFSFileSystem, RootProperty rootProperty, List<BATBlock> list, HeaderBlock headerBlock) {
        this._filesystem = nPOIFSFileSystem;
        this._sbat_blocks = list;
        this._header = headerBlock;
        this._root = rootProperty;
        this._mini_stream = new NPOIFSStream(nPOIFSFileSystem, rootProperty.getStartBlock());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected ByteBuffer getBlockAt(int i) throws IOException {
        int i2 = i * 64;
        int bigBlockSize = i2 / this._filesystem.getBigBlockSize();
        int bigBlockSize2 = i2 % this._filesystem.getBigBlockSize();
        Iterator<ByteBuffer> blockIterator = this._mini_stream.getBlockIterator();
        for (int i3 = 0; i3 < bigBlockSize; i3++) {
            blockIterator.next();
        }
        ByteBuffer next = blockIterator.next();
        if (next == null) {
            throw new IndexOutOfBoundsException("Big block " + bigBlockSize + " outside stream");
        }
        next.position(next.position() + bigBlockSize2);
        ByteBuffer byteBufferSlice = next.slice();
        byteBufferSlice.limit(64);
        return byteBufferSlice;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected ByteBuffer createBlockIfNeeded(int i) throws IOException {
        boolean z = this._mini_stream.getStartBlock() == -2;
        if (!z) {
            try {
                return getBlockAt(i);
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        int freeBlock = this._filesystem.getFreeBlock();
        this._filesystem.createBlockIfNeeded(freeBlock);
        if (z) {
            this._filesystem._get_property_table().getRoot().setStartBlock(freeBlock);
            this._mini_stream = new NPOIFSStream(this._filesystem, freeBlock);
        } else {
            BlockStore.ChainLoopDetector chainLoopDetector = this._filesystem.getChainLoopDetector();
            int startBlock = this._mini_stream.getStartBlock();
            while (true) {
                chainLoopDetector.claim(startBlock);
                int nextBlock = this._filesystem.getNextBlock(startBlock);
                if (nextBlock == -2) {
                    break;
                }
                startBlock = nextBlock;
            }
            this._filesystem.setNextBlock(startBlock, freeBlock);
        }
        this._filesystem.setNextBlock(freeBlock, -2);
        return createBlockIfNeeded(i);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected BATBlock.BATBlockAndIndex getBATBlockAndIndex(int i) {
        return BATBlock.getSBATBlockAndIndex(i, this._header, this._sbat_blocks);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected int getNextBlock(int i) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i);
        return bATBlockAndIndex.getBlock().getValueAt(bATBlockAndIndex.getIndex());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected void setNextBlock(int i, int i2) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i);
        bATBlockAndIndex.getBlock().setValueAt(bATBlockAndIndex.getIndex(), i2);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected int getFreeBlock() throws IOException {
        int bATEntriesPerBlock = this._filesystem.getBigBlockSizeDetails().getBATEntriesPerBlock();
        int i = 0;
        for (int i2 = 0; i2 < this._sbat_blocks.size(); i2++) {
            BATBlock bATBlock = this._sbat_blocks.get(i2);
            if (bATBlock.hasFreeSectors()) {
                for (int i3 = 0; i3 < bATEntriesPerBlock; i3++) {
                    if (bATBlock.getValueAt(i3) == -1) {
                        return i + i3;
                    }
                }
            }
            i += bATEntriesPerBlock;
        }
        BATBlock bATBlockCreateEmptyBATBlock = BATBlock.createEmptyBATBlock(this._filesystem.getBigBlockSizeDetails(), false);
        int freeBlock = this._filesystem.getFreeBlock();
        bATBlockCreateEmptyBATBlock.setOurBlockIndex(freeBlock);
        if (this._header.getSBATCount() == 0) {
            this._header.setSBATStart(freeBlock);
            this._header.setSBATBlockCount(1);
        } else {
            BlockStore.ChainLoopDetector chainLoopDetector = this._filesystem.getChainLoopDetector();
            int sBATStart = this._header.getSBATStart();
            while (true) {
                chainLoopDetector.claim(sBATStart);
                int nextBlock = this._filesystem.getNextBlock(sBATStart);
                if (nextBlock == -2) {
                    break;
                }
                sBATStart = nextBlock;
            }
            this._filesystem.setNextBlock(sBATStart, freeBlock);
            HeaderBlock headerBlock = this._header;
            headerBlock.setSBATBlockCount(headerBlock.getSBATCount() + 1);
        }
        this._filesystem.setNextBlock(freeBlock, -2);
        this._sbat_blocks.add(bATBlockCreateEmptyBATBlock);
        return i;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected BlockStore.ChainLoopDetector getChainLoopDetector() throws IOException {
        return new BlockStore.ChainLoopDetector(this._root.getSize());
    }

    protected void syncWithDataSource() throws IOException {
        int usedSectors;
        int i = 0;
        for (BATBlock bATBlock : this._sbat_blocks) {
            BlockAllocationTableWriter.writeBlock(bATBlock, this._filesystem.getBlockAt(bATBlock.getOurBlockIndex()));
            if (!bATBlock.hasFreeSectors()) {
                usedSectors = this._filesystem.getBigBlockSizeDetails().getBATEntriesPerBlock();
            } else {
                usedSectors = bATBlock.getUsedSectors(false);
            }
            i += usedSectors;
        }
        this._filesystem._get_property_table().getRoot().setSize(i);
    }
}
