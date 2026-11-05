package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class EscherDggRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtDgg";
    public static final short RECORD_ID = -4090;
    private int field_1_shapeIdMax;
    private int field_3_numShapesSaved;
    private int field_4_drawingsSaved;
    private final List<FileIdCluster> field_5_fileIdClusters = new ArrayList();
    private int maxDgId;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Dgg";
    }

    public static class FileIdCluster {
        private int field_1_drawingGroupId;
        private int field_2_numShapeIdsUsed;

        public FileIdCluster(int i, int i2) {
            this.field_1_drawingGroupId = i;
            this.field_2_numShapeIdsUsed = i2;
        }

        public int getDrawingGroupId() {
            return this.field_1_drawingGroupId;
        }

        public int getNumShapeIdsUsed() {
            return this.field_2_numShapeIdsUsed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incrementUsedShapeId() {
            this.field_2_numShapeIdsUsed++;
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int header = readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_shapeIdMax = LittleEndian.getInt(bArr, i2 + 0);
        this.field_3_numShapesSaved = LittleEndian.getInt(bArr, i2 + 8);
        this.field_4_drawingsSaved = LittleEndian.getInt(bArr, i2 + 12);
        this.field_5_fileIdClusters.clear();
        int i3 = (header - 16) / 8;
        int i4 = 16;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i2 + i4;
            int i7 = LittleEndian.getInt(bArr, i6);
            this.field_5_fileIdClusters.add(new FileIdCluster(i7, LittleEndian.getInt(bArr, i6 + 4)));
            this.maxDgId = Math.max(this.maxDgId, i7);
            i4 += 8;
        }
        int i8 = header - i4;
        if (i8 == 0) {
            return i4 + 8;
        }
        throw new RecordFormatException("Expecting no remaining data but got " + i8 + " byte(s).");
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        int i2 = i + 2;
        LittleEndian.putShort(bArr, i2, getRecordId());
        int i3 = i2 + 2;
        LittleEndian.putInt(bArr, i3, getRecordSize() - 8);
        int i4 = i3 + 4;
        LittleEndian.putInt(bArr, i4, this.field_1_shapeIdMax);
        int i5 = i4 + 4;
        LittleEndian.putInt(bArr, i5, getNumIdClusters());
        int i6 = i5 + 4;
        LittleEndian.putInt(bArr, i6, this.field_3_numShapesSaved);
        int i7 = i6 + 4;
        LittleEndian.putInt(bArr, i7, this.field_4_drawingsSaved);
        int i8 = i7 + 4;
        for (FileIdCluster fileIdCluster : this.field_5_fileIdClusters) {
            LittleEndian.putInt(bArr, i8, fileIdCluster.getDrawingGroupId());
            int i9 = i8 + 4;
            LittleEndian.putInt(bArr, i9, fileIdCluster.getNumShapeIdsUsed());
            i8 = i9 + 4;
        }
        escherSerializationListener.afterRecordSerialize(i8, getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return (this.field_5_fileIdClusters.size() * 8) + 24;
    }

    public int getShapeIdMax() {
        return this.field_1_shapeIdMax;
    }

    public void setShapeIdMax(int i) {
        this.field_1_shapeIdMax = i;
    }

    public int getNumIdClusters() {
        if (this.field_5_fileIdClusters.isEmpty()) {
            return 0;
        }
        return this.field_5_fileIdClusters.size() + 1;
    }

    public int getNumShapesSaved() {
        return this.field_3_numShapesSaved;
    }

    public void setNumShapesSaved(int i) {
        this.field_3_numShapesSaved = i;
    }

    public int getDrawingsSaved() {
        return this.field_4_drawingsSaved;
    }

    public void setDrawingsSaved(int i) {
        this.field_4_drawingsSaved = i;
    }

    public int getMaxDrawingGroupId() {
        return this.maxDgId;
    }

    public FileIdCluster[] getFileIdClusters() {
        List<FileIdCluster> list = this.field_5_fileIdClusters;
        return (FileIdCluster[]) list.toArray(new FileIdCluster[list.size()]);
    }

    public void setFileIdClusters(FileIdCluster[] fileIdClusterArr) {
        this.field_5_fileIdClusters.clear();
        if (fileIdClusterArr != null) {
            this.field_5_fileIdClusters.addAll(Arrays.asList(fileIdClusterArr));
        }
    }

    public FileIdCluster addCluster(int i, int i2) {
        return addCluster(i, i2, true);
    }

    public FileIdCluster addCluster(int i, int i2, boolean z) {
        FileIdCluster fileIdCluster = new FileIdCluster(i, i2);
        this.field_5_fileIdClusters.add(fileIdCluster);
        this.maxDgId = Math.min(this.maxDgId, i);
        if (z) {
            sortCluster();
        }
        return fileIdCluster;
    }

    private void sortCluster() {
        Collections.sort(this.field_5_fileIdClusters, new Comparator<FileIdCluster>() { // from class: org.apache.poi.ddf.EscherDggRecord.1
            @Override // java.util.Comparator
            public int compare(FileIdCluster fileIdCluster, FileIdCluster fileIdCluster2) {
                int drawingGroupId = fileIdCluster.getDrawingGroupId() - fileIdCluster2.getDrawingGroupId();
                return drawingGroupId != 0 ? drawingGroupId : fileIdCluster2.getNumShapeIdsUsed() - fileIdCluster.getNumShapeIdsUsed();
            }
        });
    }

    public short findNewDrawingGroupId() {
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        Iterator<FileIdCluster> it = this.field_5_fileIdClusters.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().getDrawingGroupId());
        }
        return (short) bitSet.nextClearBit(0);
    }

    public int allocateShapeId(EscherDgRecord escherDgRecord, boolean z) {
        FileIdCluster fileIdClusterAddCluster;
        short drawingGroupId = escherDgRecord.getDrawingGroupId();
        this.field_3_numShapesSaved++;
        Iterator<FileIdCluster> it = this.field_5_fileIdClusters.iterator();
        int i = 1;
        while (true) {
            if (!it.hasNext()) {
                fileIdClusterAddCluster = null;
                break;
            }
            fileIdClusterAddCluster = it.next();
            if (fileIdClusterAddCluster.getDrawingGroupId() == drawingGroupId && fileIdClusterAddCluster.getNumShapeIdsUsed() < 1024) {
                break;
            }
            i++;
        }
        if (fileIdClusterAddCluster == null) {
            fileIdClusterAddCluster = addCluster(drawingGroupId, 0, z);
            this.maxDgId = Math.max(this.maxDgId, (int) drawingGroupId);
        }
        int numShapeIdsUsed = (i * 1024) + fileIdClusterAddCluster.getNumShapeIdsUsed();
        fileIdClusterAddCluster.incrementUsedShapeId();
        escherDgRecord.setNumShapes(escherDgRecord.getNumShapes() + 1);
        escherDgRecord.setLastMSOSPID(numShapeIdsUsed);
        this.field_1_shapeIdMax = Math.max(this.field_1_shapeIdMax, numShapeIdsUsed + 1);
        return numShapeIdsUsed;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    protected Object[][] getAttributeMap() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("FileId Clusters");
        arrayList.add(Integer.valueOf(this.field_5_fileIdClusters.size()));
        for (FileIdCluster fileIdCluster : this.field_5_fileIdClusters) {
            arrayList.add("Group" + fileIdCluster.field_1_drawingGroupId);
            arrayList.add(Integer.valueOf(fileIdCluster.field_2_numShapeIdsUsed));
        }
        return new Object[][]{new Object[]{"ShapeIdMax", Integer.valueOf(this.field_1_shapeIdMax)}, new Object[]{"NumIdClusters", Integer.valueOf(getNumIdClusters())}, new Object[]{"NumShapesSaved", Integer.valueOf(this.field_3_numShapesSaved)}, new Object[]{"DrawingsSaved", Integer.valueOf(this.field_4_drawingsSaved)}, arrayList.toArray()};
    }
}
