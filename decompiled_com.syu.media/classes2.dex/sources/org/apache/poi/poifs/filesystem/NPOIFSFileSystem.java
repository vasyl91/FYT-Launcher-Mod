package org.apache.poi.poifs.filesystem;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EmptyFileException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.nio.ByteArrayBackedDataSource;
import org.apache.poi.poifs.nio.DataSource;
import org.apache.poi.poifs.nio.FileBackedDataSource;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.NPropertyTable;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.BlockAllocationTableWriter;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.HeaderBlockWriter;
import org.apache.poi.util.CloseIgnoringInputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class NPOIFSFileSystem extends BlockStore implements POIFSViewable, Closeable {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) NPOIFSFileSystem.class);
    private List<BATBlock> _bat_blocks;
    private DataSource _data;
    private HeaderBlock _header;
    private NPOIFSMiniStore _mini_store;
    private NPropertyTable _property_table;
    private DirectoryNode _root;
    private List<BATBlock> _xbat_blocks;
    private POIFSBigBlockSize bigBlockSize;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return "POIFS FileSystem";
    }

    public static InputStream createNonClosingInputStream(InputStream inputStream) {
        return new CloseIgnoringInputStream(inputStream);
    }

    private NPOIFSFileSystem(boolean z) {
        this.bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        this._header = new HeaderBlock(this.bigBlockSize);
        this._property_table = new NPropertyTable(this._header);
        this._mini_store = new NPOIFSMiniStore(this, this._property_table.getRoot(), new ArrayList(), this._header);
        this._xbat_blocks = new ArrayList();
        this._bat_blocks = new ArrayList();
        this._root = null;
        if (z) {
            this._data = new ByteArrayBackedDataSource(new byte[this.bigBlockSize.getBigBlockSize() * 3]);
        }
    }

    public NPOIFSFileSystem() {
        this(true);
        this._header.setBATCount(1);
        this._header.setBATArray(new int[]{1});
        BATBlock bATBlockCreateEmptyBATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, false);
        bATBlockCreateEmptyBATBlock.setOurBlockIndex(1);
        this._bat_blocks.add(bATBlockCreateEmptyBATBlock);
        setNextBlock(0, -2);
        setNextBlock(1, -3);
        this._property_table.setStartBlock(0);
    }

    public NPOIFSFileSystem(File file) throws IOException {
        this(file, true);
    }

    public NPOIFSFileSystem(File file, boolean z) throws IOException {
        this(null, file, z, true);
    }

    public NPOIFSFileSystem(FileChannel fileChannel) throws IOException {
        this(fileChannel, true);
    }

    public NPOIFSFileSystem(FileChannel fileChannel, boolean z) throws IOException {
        this(fileChannel, null, z, false);
    }

    private NPOIFSFileSystem(FileChannel fileChannel, File file, boolean z, boolean z2) throws IOException {
        this(false);
        try {
            if (file == null) {
                this._data = new FileBackedDataSource(fileChannel, z);
            } else {
                if (file.length() == 0) {
                    throw new EmptyFileException();
                }
                FileBackedDataSource fileBackedDataSource = new FileBackedDataSource(file, z);
                fileChannel = fileBackedDataSource.getChannel();
                this._data = fileBackedDataSource;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
            IOUtils.readFully(fileChannel, byteBufferAllocate);
            this._header = new HeaderBlock(byteBufferAllocate);
            readCoreContents();
        } catch (IOException e) {
            if (z2 && fileChannel != null) {
                fileChannel.close();
            }
            throw e;
        } catch (RuntimeException e2) {
            if (z2 && fileChannel != null) {
                fileChannel.close();
            }
            throw e2;
        }
    }

    public NPOIFSFileSystem(InputStream inputStream) throws Throwable {
        ReadableByteChannel readableByteChannelNewChannel;
        this(false);
        try {
            readableByteChannelNewChannel = Channels.newChannel(inputStream);
            try {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
                IOUtils.readFully(readableByteChannelNewChannel, byteBufferAllocate);
                HeaderBlock headerBlock = new HeaderBlock(byteBufferAllocate);
                this._header = headerBlock;
                BlockAllocationTableReader.sanityCheckBlockCount(headerBlock.getBATCount());
                long jCalculateMaximumSize = BATBlock.calculateMaximumSize(this._header);
                if (jCalculateMaximumSize > 2147483647L) {
                    throw new IllegalArgumentException("Unable read a >2gb file via an InputStream");
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((int) jCalculateMaximumSize);
                byteBufferAllocate.position(0);
                byteBufferAllocate2.put(byteBufferAllocate);
                byteBufferAllocate2.position(byteBufferAllocate.capacity());
                IOUtils.readFully(readableByteChannelNewChannel, byteBufferAllocate2);
                this._data = new ByteArrayBackedDataSource(byteBufferAllocate2.array(), byteBufferAllocate2.position());
                if (readableByteChannelNewChannel != null) {
                    readableByteChannelNewChannel.close();
                }
                closeInputStream(inputStream, true);
                readCoreContents();
            } catch (Throwable th) {
                th = th;
                if (readableByteChannelNewChannel != null) {
                    readableByteChannelNewChannel.close();
                }
                closeInputStream(inputStream, false);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            readableByteChannelNewChannel = null;
        }
    }

    private void closeInputStream(InputStream inputStream, boolean z) {
        try {
            inputStream.close();
        } catch (IOException e) {
            if (z) {
                throw new RuntimeException(e);
            }
            LOG.log(7, "can't close input stream", e);
        }
    }

    @Removal(version = "4.0")
    @Deprecated
    public static boolean hasPOIFSHeader(InputStream inputStream) throws IOException {
        return FileMagic.valueOf(inputStream) == FileMagic.OLE2;
    }

    @Removal(version = "4.0")
    @Deprecated
    public static boolean hasPOIFSHeader(byte[] bArr) {
        try {
            return hasPOIFSHeader(new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            throw new RuntimeException("invalid header check", e);
        }
    }

    private void readCoreContents() throws IOException {
        this.bigBlockSize = this._header.getBigBlockSize();
        BlockStore.ChainLoopDetector chainLoopDetector = getChainLoopDetector();
        for (int i : this._header.getBATArray()) {
            readBAT(i, chainLoopDetector);
        }
        int bATCount = this._header.getBATCount() - this._header.getBATArray().length;
        int xBATIndex = this._header.getXBATIndex();
        for (int i2 = 0; i2 < this._header.getXBATCount(); i2++) {
            chainLoopDetector.claim(xBATIndex);
            BATBlock bATBlockCreateBATBlock = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(xBATIndex));
            bATBlockCreateBATBlock.setOurBlockIndex(xBATIndex);
            xBATIndex = bATBlockCreateBATBlock.getValueAt(this.bigBlockSize.getXBATEntriesPerBlock());
            this._xbat_blocks.add(bATBlockCreateBATBlock);
            int iMin = Math.min(bATCount, this.bigBlockSize.getXBATEntriesPerBlock());
            for (int i3 = 0; i3 < iMin; i3++) {
                int valueAt = bATBlockCreateBATBlock.getValueAt(i3);
                if (valueAt == -1 || valueAt == -2) {
                    break;
                }
                readBAT(valueAt, chainLoopDetector);
            }
            bATCount -= iMin;
        }
        this._property_table = new NPropertyTable(this._header, this);
        ArrayList arrayList = new ArrayList();
        this._mini_store = new NPOIFSMiniStore(this, this._property_table.getRoot(), arrayList, this._header);
        int sBATStart = this._header.getSBATStart();
        for (int i4 = 0; i4 < this._header.getSBATCount() && sBATStart != -2; i4++) {
            chainLoopDetector.claim(sBATStart);
            BATBlock bATBlockCreateBATBlock2 = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(sBATStart));
            bATBlockCreateBATBlock2.setOurBlockIndex(sBATStart);
            arrayList.add(bATBlockCreateBATBlock2);
            sBATStart = getNextBlock(sBATStart);
        }
    }

    private void readBAT(int i, BlockStore.ChainLoopDetector chainLoopDetector) throws IOException {
        chainLoopDetector.claim(i);
        BATBlock bATBlockCreateBATBlock = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(i));
        bATBlockCreateBATBlock.setOurBlockIndex(i);
        this._bat_blocks.add(bATBlockCreateBATBlock);
    }

    private BATBlock createBAT(int i, boolean z) throws IOException {
        BATBlock bATBlockCreateEmptyBATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, !z);
        bATBlockCreateEmptyBATBlock.setOurBlockIndex(i);
        this._data.write(ByteBuffer.allocate(this.bigBlockSize.getBigBlockSize()), (i + 1) * this.bigBlockSize.getBigBlockSize());
        return bATBlockCreateEmptyBATBlock;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected ByteBuffer getBlockAt(int i) throws IOException {
        try {
            return this._data.read(this.bigBlockSize.getBigBlockSize(), (((long) i) + 1) * ((long) this.bigBlockSize.getBigBlockSize()));
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Block " + i + " not found");
            indexOutOfBoundsException.initCause(e);
            throw indexOutOfBoundsException;
        }
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected ByteBuffer createBlockIfNeeded(int i) throws IOException {
        try {
            return getBlockAt(i);
        } catch (IndexOutOfBoundsException unused) {
            long bigBlockSize = (((long) i) + 1) * ((long) this.bigBlockSize.getBigBlockSize());
            this._data.write(ByteBuffer.allocate(getBigBlockSize()), bigBlockSize);
            return getBlockAt(i);
        }
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected BATBlock.BATBlockAndIndex getBATBlockAndIndex(int i) {
        return BATBlock.getBATBlockAndIndex(i, this._header, this._bat_blocks);
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
        BATBlock next;
        int bATEntriesPerBlock = this.bigBlockSize.getBATEntriesPerBlock();
        int i = 0;
        for (BATBlock bATBlock : this._bat_blocks) {
            if (bATBlock.hasFreeSectors()) {
                for (int i2 = 0; i2 < bATEntriesPerBlock; i2++) {
                    if (bATBlock.getValueAt(i2) == -1) {
                        return i + i2;
                    }
                }
            }
            i += bATEntriesPerBlock;
        }
        BATBlock bATBlockCreateBAT = createBAT(i, true);
        bATBlockCreateBAT.setValueAt(0, -3);
        this._bat_blocks.add(bATBlockCreateBAT);
        if (this._header.getBATCount() >= 109) {
            Iterator<BATBlock> it = this._xbat_blocks.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.hasFreeSectors());
            if (next == null) {
                int i3 = i + 1;
                BATBlock bATBlockCreateBAT2 = createBAT(i3, false);
                bATBlockCreateBAT2.setValueAt(0, i);
                bATBlockCreateBAT.setValueAt(1, -4);
                if (this._xbat_blocks.size() == 0) {
                    this._header.setXBATStart(i3);
                } else {
                    List<BATBlock> list = this._xbat_blocks;
                    list.get(list.size() - 1).setValueAt(this.bigBlockSize.getXBATEntriesPerBlock(), i3);
                }
                this._xbat_blocks.add(bATBlockCreateBAT2);
                this._header.setXBATCount(this._xbat_blocks.size());
                i = i3;
            } else {
                for (int i4 = 0; i4 < this.bigBlockSize.getXBATEntriesPerBlock(); i4++) {
                    if (next.getValueAt(i4) == -1) {
                        next.setValueAt(i4, i);
                        break;
                    }
                }
            }
        } else {
            int bATCount = this._header.getBATCount() + 1;
            int[] iArr = new int[bATCount];
            int i5 = bATCount - 1;
            System.arraycopy(this._header.getBATArray(), 0, iArr, 0, i5);
            iArr[i5] = i;
            this._header.setBATArray(iArr);
        }
        this._header.setBATCount(this._bat_blocks.size());
        return i + 1;
    }

    protected long size() throws IOException {
        return this._data.size();
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected BlockStore.ChainLoopDetector getChainLoopDetector() throws IOException {
        return new BlockStore.ChainLoopDetector(this._data.size());
    }

    NPropertyTable _get_property_table() {
        return this._property_table;
    }

    public NPOIFSMiniStore getMiniStore() {
        return this._mini_store;
    }

    void addDocument(NPOIFSDocument nPOIFSDocument) {
        this._property_table.addProperty(nPOIFSDocument.getDocumentProperty());
    }

    void addDirectory(DirectoryProperty directoryProperty) {
        this._property_table.addProperty(directoryProperty);
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

    public DocumentEntry createOrUpdateDocument(InputStream inputStream, String str) throws IOException {
        return getRoot().createOrUpdateDocument(str, inputStream);
    }

    public boolean isInPlaceWriteable() {
        DataSource dataSource = this._data;
        return (dataSource instanceof FileBackedDataSource) && ((FileBackedDataSource) dataSource).isWriteable();
    }

    public void writeFilesystem() throws IOException {
        DataSource dataSource = this._data;
        if (!(dataSource instanceof FileBackedDataSource)) {
            throw new IllegalArgumentException("POIFS opened from an inputstream, so writeFilesystem() may not be called. Use writeFilesystem(OutputStream) instead");
        }
        if (!((FileBackedDataSource) dataSource).isWriteable()) {
            throw new IllegalArgumentException("POIFS opened in read only mode, so writeFilesystem() may not be called. Open the FileSystem in read-write mode first");
        }
        syncWithDataSource();
    }

    public void writeFilesystem(OutputStream outputStream) throws IOException {
        syncWithDataSource();
        this._data.copyTo(outputStream);
    }

    private void syncWithDataSource() throws IOException {
        this._mini_store.syncWithDataSource();
        NPOIFSStream nPOIFSStream = new NPOIFSStream(this, this._header.getPropertyStart());
        this._property_table.preWrite();
        this._property_table.write(nPOIFSStream);
        new HeaderBlockWriter(this._header).writeBlock(getBlockAt(-1));
        for (BATBlock bATBlock : this._bat_blocks) {
            BlockAllocationTableWriter.writeBlock(bATBlock, getBlockAt(bATBlock.getOurBlockIndex()));
        }
        for (BATBlock bATBlock2 : this._xbat_blocks) {
            BlockAllocationTableWriter.writeBlock(bATBlock2, getBlockAt(bATBlock2.getOurBlockIndex()));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._data.close();
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 2) {
            System.err.println("two arguments required: input filename and output filename");
            System.exit(1);
        }
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1]);
            try {
                NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(fileInputStream);
                try {
                    nPOIFSFileSystem.writeFilesystem(fileOutputStream);
                    nPOIFSFileSystem.close();
                    fileOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th) {
                    nPOIFSFileSystem.close();
                    throw th;
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            fileInputStream.close();
            throw th3;
        }
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

    void remove(EntryNode entryNode) throws IOException {
        if (entryNode instanceof DocumentEntry) {
            new NPOIFSDocument((DocumentProperty) entryNode.getProperty(), this).free();
        }
        this._property_table.removeProperty(entryNode.getProperty());
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

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    protected int getBlockStoreBlockSize() {
        return getBigBlockSize();
    }

    @Internal
    public NPropertyTable getPropertyTable() {
        return this._property_table;
    }

    @Internal
    public HeaderBlock getHeaderBlock() {
        return this._header;
    }
}
