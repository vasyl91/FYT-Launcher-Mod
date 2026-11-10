package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.filesystem.BATManaged;
import org.apache.poi.poifs.filesystem.OPOIFSDocument;
import org.apache.poi.poifs.property.RootProperty;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SmallBlockTableWriter implements BlockWritable, BATManaged {
    private int _big_block_count;
    private RootProperty _root;
    private BlockAllocationTableWriter _sbat;
    private List<SmallDocumentBlock> _small_blocks = new ArrayList();

    public SmallBlockTableWriter(POIFSBigBlockSize pOIFSBigBlockSize, List<OPOIFSDocument> list, RootProperty rootProperty) {
        this._sbat = new BlockAllocationTableWriter(pOIFSBigBlockSize);
        this._root = rootProperty;
        for (OPOIFSDocument oPOIFSDocument : list) {
            SmallDocumentBlock[] smallBlocks = oPOIFSDocument.getSmallBlocks();
            if (smallBlocks.length != 0) {
                oPOIFSDocument.setStartBlock(this._sbat.allocateSpace(smallBlocks.length));
                for (SmallDocumentBlock smallDocumentBlock : smallBlocks) {
                    this._small_blocks.add(smallDocumentBlock);
                }
            } else {
                oPOIFSDocument.setStartBlock(-2);
            }
        }
        this._sbat.simpleCreateBlocks();
        this._root.setSize(this._small_blocks.size());
        this._big_block_count = SmallDocumentBlock.fill(pOIFSBigBlockSize, this._small_blocks);
    }

    public int getSBATBlockCount() {
        return (this._big_block_count + 15) / 16;
    }

    public BlockAllocationTableWriter getSBAT() {
        return this._sbat;
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public int countBlocks() {
        return this._big_block_count;
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public void setStartBlock(int i) {
        this._root.setStartBlock(i);
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        Iterator<SmallDocumentBlock> it = this._small_blocks.iterator();
        while (it.hasNext()) {
            it.next().writeBlocks(outputStream);
        }
    }
}
