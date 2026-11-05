package org.apache.poi.poifs.storage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.property.Property;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PropertyBlock extends BigBlock {
    private Property[] _properties;

    @Override // org.apache.poi.poifs.storage.BigBlock, org.apache.poi.poifs.storage.BlockWritable
    public /* bridge */ /* synthetic */ void writeBlocks(OutputStream outputStream) throws IOException {
        super.writeBlocks(outputStream);
    }

    private PropertyBlock(POIFSBigBlockSize pOIFSBigBlockSize, Property[] propertyArr, int i) {
        super(pOIFSBigBlockSize);
        this._properties = new Property[pOIFSBigBlockSize.getPropertiesPerBlock()];
        int i2 = 0;
        while (true) {
            Property[] propertyArr2 = this._properties;
            if (i2 >= propertyArr2.length) {
                return;
            }
            propertyArr2[i2] = propertyArr[i2 + i];
            i2++;
        }
    }

    public static BlockWritable[] createPropertyBlockArray(POIFSBigBlockSize pOIFSBigBlockSize, List<Property> list) {
        int propertiesPerBlock = pOIFSBigBlockSize.getPropertiesPerBlock();
        int size = ((list.size() + propertiesPerBlock) - 1) / propertiesPerBlock;
        int i = size * propertiesPerBlock;
        Property[] propertyArr = new Property[i];
        System.arraycopy(list.toArray(new Property[0]), 0, propertyArr, 0, list.size());
        for (int size2 = list.size(); size2 < i; size2++) {
            propertyArr[size2] = new Property() { // from class: org.apache.poi.poifs.storage.PropertyBlock.1
                @Override // org.apache.poi.poifs.property.Property
                public boolean isDirectory() {
                    return false;
                }

                @Override // org.apache.poi.poifs.property.Property
                protected void preWrite() {
                }
            };
        }
        BlockWritable[] blockWritableArr = new BlockWritable[size];
        for (int i2 = 0; i2 < size; i2++) {
            blockWritableArr[i2] = new PropertyBlock(pOIFSBigBlockSize, propertyArr, i2 * propertiesPerBlock);
        }
        return blockWritableArr;
    }

    @Override // org.apache.poi.poifs.storage.BigBlock
    void writeData(OutputStream outputStream) throws IOException {
        int propertiesPerBlock = this.bigBlockSize.getPropertiesPerBlock();
        for (int i = 0; i < propertiesPerBlock; i++) {
            this._properties[i].writeData(outputStream);
        }
    }
}
