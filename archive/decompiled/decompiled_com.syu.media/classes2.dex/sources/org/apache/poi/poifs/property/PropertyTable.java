package org.apache.poi.poifs.property;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.storage.BlockWritable;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.PropertyBlock;
import org.apache.poi.poifs.storage.RawDataBlockList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PropertyTable extends PropertyTableBase implements BlockWritable {
    private POIFSBigBlockSize _bigBigBlockSize;
    private BlockWritable[] _blocks;

    public PropertyTable(HeaderBlock headerBlock) {
        super(headerBlock);
        this._bigBigBlockSize = headerBlock.getBigBlockSize();
        this._blocks = null;
    }

    public PropertyTable(HeaderBlock headerBlock, RawDataBlockList rawDataBlockList) throws IOException {
        super(headerBlock, PropertyFactory.convertToProperties(rawDataBlockList.fetchBlocks(headerBlock.getPropertyStart(), -1)));
        this._bigBigBlockSize = headerBlock.getBigBlockSize();
        this._blocks = null;
    }

    public void preWrite() {
        Property[] propertyArr = (Property[]) this._properties.toArray(new Property[this._properties.size()]);
        for (int i = 0; i < propertyArr.length; i++) {
            propertyArr[i].setIndex(i);
        }
        this._blocks = PropertyBlock.createPropertyBlockArray(this._bigBigBlockSize, this._properties);
        for (Property property : propertyArr) {
            property.preWrite();
        }
    }

    @Override // org.apache.poi.poifs.filesystem.BATManaged
    public int countBlocks() {
        BlockWritable[] blockWritableArr = this._blocks;
        if (blockWritableArr == null) {
            return 0;
        }
        return blockWritableArr.length;
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        BlockWritable[] blockWritableArr = this._blocks;
        if (blockWritableArr != null) {
            for (BlockWritable blockWritable : blockWritableArr) {
                blockWritable.writeBlocks(outputStream);
            }
        }
    }
}
