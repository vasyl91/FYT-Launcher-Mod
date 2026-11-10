package org.apache.poi.poifs.storage;

import java.io.IOException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.property.RootProperty;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class SmallBlockTableReader {
    private static BlockList prepareSmallDocumentBlocks(POIFSBigBlockSize pOIFSBigBlockSize, RawDataBlockList rawDataBlockList, RootProperty rootProperty, int i) throws IOException {
        return new SmallDocumentBlockList(SmallDocumentBlock.extract(pOIFSBigBlockSize, rawDataBlockList.fetchBlocks(rootProperty.getStartBlock(), -1)));
    }

    private static BlockAllocationTableReader prepareReader(POIFSBigBlockSize pOIFSBigBlockSize, RawDataBlockList rawDataBlockList, BlockList blockList, RootProperty rootProperty, int i) throws IOException {
        return new BlockAllocationTableReader(pOIFSBigBlockSize, rawDataBlockList.fetchBlocks(i, -1), blockList);
    }

    public static BlockAllocationTableReader _getSmallDocumentBlockReader(POIFSBigBlockSize pOIFSBigBlockSize, RawDataBlockList rawDataBlockList, RootProperty rootProperty, int i) throws IOException {
        return prepareReader(pOIFSBigBlockSize, rawDataBlockList, prepareSmallDocumentBlocks(pOIFSBigBlockSize, rawDataBlockList, rootProperty, i), rootProperty, i);
    }

    public static BlockList getSmallDocumentBlocks(POIFSBigBlockSize pOIFSBigBlockSize, RawDataBlockList rawDataBlockList, RootProperty rootProperty, int i) throws IOException {
        BlockList blockListPrepareSmallDocumentBlocks = prepareSmallDocumentBlocks(pOIFSBigBlockSize, rawDataBlockList, rootProperty, i);
        prepareReader(pOIFSBigBlockSize, rawDataBlockList, blockListPrepareSmallDocumentBlocks, rootProperty, i);
        return blockListPrepareSmallDocumentBlocks;
    }
}
