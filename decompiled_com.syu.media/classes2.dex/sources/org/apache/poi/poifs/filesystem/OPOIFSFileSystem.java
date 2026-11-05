package org.apache.poi.poifs.filesystem;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.BlockAllocationTableWriter;
import org.apache.poi.poifs.storage.BlockList;
import org.apache.poi.poifs.storage.BlockWritable;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.HeaderBlockWriter;
import org.apache.poi.poifs.storage.RawDataBlockList;
import org.apache.poi.poifs.storage.SmallBlockTableReader;
import org.apache.poi.poifs.storage.SmallBlockTableWriter;
import org.apache.poi.util.CloseIgnoringInputStream;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class OPOIFSFileSystem implements POIFSViewable {
    private static final POILogger _logger = POILogFactory.getLogger((Class<?>) OPOIFSFileSystem.class);
    private List<OPOIFSDocument> _documents;
    private PropertyTable _property_table;
    private DirectoryNode _root;
    private POIFSBigBlockSize bigBlockSize;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return "POIFS FileSystem";
    }

    public static InputStream createNonClosingInputStream(InputStream inputStream) {
        return new CloseIgnoringInputStream(inputStream);
    }

    public OPOIFSFileSystem() {
        this.bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        this._property_table = new PropertyTable(new HeaderBlock(this.bigBlockSize));
        this._documents = new ArrayList();
        this._root = null;
    }

    public OPOIFSFileSystem(InputStream inputStream) throws IOException {
        this();
        try {
            HeaderBlock headerBlock = new HeaderBlock(inputStream);
            this.bigBlockSize = headerBlock.getBigBlockSize();
            RawDataBlockList rawDataBlockList = new RawDataBlockList(inputStream, this.bigBlockSize);
            closeInputStream(inputStream, true);
            new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), rawDataBlockList);
            PropertyTable propertyTable = new PropertyTable(headerBlock, rawDataBlockList);
            processProperties(SmallBlockTableReader.getSmallDocumentBlocks(this.bigBlockSize, rawDataBlockList, propertyTable.getRoot(), headerBlock.getSBATStart()), rawDataBlockList, propertyTable.getRoot().getChildren(), null, headerBlock.getPropertyStart());
            getRoot().setStorageClsid(propertyTable.getRoot().getStorageClsid());
        } catch (Throwable th) {
            closeInputStream(inputStream, false);
            throw th;
        }
    }

    protected void closeInputStream(InputStream inputStream, boolean z) {
        if (inputStream.markSupported() && !(inputStream instanceof ByteArrayInputStream)) {
            _logger.log(5, "POIFS is closing the supplied input stream of type (" + inputStream.getClass().getName() + ") which supports mark/reset.  This will be a problem for the caller if the stream will still be used.  If that is the case the caller should wrap the input stream to avoid this close logic.  This warning is only temporary and will not be present in future versions of POI.");
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            if (z) {
                throw new RuntimeException(e);
            }
            _logger.log(7, "can't close input stream", e);
        }
    }

    @Removal(version = "4.0")
    @Deprecated
    public static boolean hasPOIFSHeader(InputStream inputStream) throws IOException {
        return NPOIFSFileSystem.hasPOIFSHeader(inputStream);
    }

    @Removal(version = "4.0")
    @Deprecated
    public static boolean hasPOIFSHeader(byte[] bArr) {
        return NPOIFSFileSystem.hasPOIFSHeader(bArr);
    }

    public DocumentEntry createDocument(InputStream inputStream, String str) throws IOException {
        return getRoot().createDocument(str, inputStream);
    }

    public DocumentEntry createDocument(String str, int i, POIFSWriterListener pOIFSWriterListener) throws IOException {
        return getRoot().createDocument(str, i, pOIFSWriterListener);
    }

    public DirectoryEntry createDirectory(String str) throws IOException {
        return getRoot().createDirectory(str);
    }

    public void writeFilesystem(OutputStream outputStream) throws IOException {
        this._property_table.preWrite();
        SmallBlockTableWriter smallBlockTableWriter = new SmallBlockTableWriter(this.bigBlockSize, this._documents, this._property_table.getRoot());
        BlockAllocationTableWriter blockAllocationTableWriter = new BlockAllocationTableWriter(this.bigBlockSize);
        ArrayList<BATManaged> arrayList = new ArrayList();
        arrayList.addAll(this._documents);
        arrayList.add(this._property_table);
        arrayList.add(smallBlockTableWriter);
        arrayList.add(smallBlockTableWriter.getSBAT());
        for (BATManaged bATManaged : arrayList) {
            int iCountBlocks = bATManaged.countBlocks();
            if (iCountBlocks != 0) {
                bATManaged.setStartBlock(blockAllocationTableWriter.allocateSpace(iCountBlocks));
            }
        }
        int iCreateBlocks = blockAllocationTableWriter.createBlocks();
        HeaderBlockWriter headerBlockWriter = new HeaderBlockWriter(this.bigBlockSize);
        BATBlock[] bATBlocks = headerBlockWriter.setBATBlocks(blockAllocationTableWriter.countBlocks(), iCreateBlocks);
        headerBlockWriter.setPropertyStart(this._property_table.getStartBlock());
        headerBlockWriter.setSBATStart(smallBlockTableWriter.getSBAT().getStartBlock());
        headerBlockWriter.setSBATBlockCount(smallBlockTableWriter.getSBATBlockCount());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(headerBlockWriter);
        arrayList2.addAll(this._documents);
        arrayList2.add(this._property_table);
        arrayList2.add(smallBlockTableWriter);
        arrayList2.add(smallBlockTableWriter.getSBAT());
        arrayList2.add(blockAllocationTableWriter);
        for (BATBlock bATBlock : bATBlocks) {
            arrayList2.add(bATBlock);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((BlockWritable) it.next()).writeBlocks(outputStream);
        }
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 2) {
            System.err.println("two arguments required: input filename and output filename");
            System.exit(1);
        }
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(strArr[1]);
        new OPOIFSFileSystem(fileInputStream).writeFilesystem(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
    }

    public DirectoryNode getRoot() {
        if (this._root == null) {
            this._root = new DirectoryNode(this._property_table.getRoot(), this, (DirectoryNode) null);
        }
        return this._root;
    }

    public DocumentInputStream createDocumentInputStream(String str) throws IOException {
        return getRoot().createDocumentInputStream(str);
    }

    void addDocument(OPOIFSDocument oPOIFSDocument) {
        this._documents.add(oPOIFSDocument);
        this._property_table.addProperty(oPOIFSDocument.getDocumentProperty());
    }

    void addDirectory(DirectoryProperty directoryProperty) {
        this._property_table.addProperty(directoryProperty);
    }

    void remove(EntryNode entryNode) {
        this._property_table.removeProperty(entryNode.getProperty());
        if (entryNode.isDocumentEntry()) {
            this._documents.remove(((DocumentNode) entryNode).getDocument());
        }
    }

    private void processProperties(BlockList blockList, BlockList blockList2, Iterator<Property> it, DirectoryNode directoryNode, int i) throws IOException {
        OPOIFSDocument oPOIFSDocument;
        while (it.hasNext()) {
            Property next = it.next();
            String name = next.getName();
            DirectoryNode root = directoryNode == null ? getRoot() : directoryNode;
            if (next.isDirectory()) {
                DirectoryNode directoryNode2 = (DirectoryNode) root.createDirectory(name);
                directoryNode2.setStorageClsid(next.getStorageClsid());
                processProperties(blockList, blockList2, ((DirectoryProperty) next).getChildren(), directoryNode2, i);
            } else {
                int startBlock = next.getStartBlock();
                int size = next.getSize();
                if (next.shouldUseSmallBlocks()) {
                    oPOIFSDocument = new OPOIFSDocument(name, blockList.fetchBlocks(startBlock, i), size);
                } else {
                    oPOIFSDocument = new OPOIFSDocument(name, blockList2.fetchBlocks(startBlock, i), size);
                }
                root.createDocument(oPOIFSDocument);
            }
        }
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return preferArray() ? getRoot().getViewableArray() : new Object[0];
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        if (!preferArray()) {
            return getRoot().getViewableIterator();
        }
        return Collections.emptyList().iterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return getRoot().preferArray();
    }

    public int getBigBlockSize() {
        return this.bigBlockSize.getBigBlockSize();
    }

    public POIFSBigBlockSize getBigBlockSizeDetails() {
        return this.bigBlockSize;
    }
}
