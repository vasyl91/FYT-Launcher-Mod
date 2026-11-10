package org.apache.poi.poifs.eventfilesystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.OPOIFSDocument;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.Property;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.property.RootProperty;
import org.apache.poi.poifs.storage.BlockAllocationTableReader;
import org.apache.poi.poifs.storage.BlockList;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.poifs.storage.RawDataBlockList;
import org.apache.poi.poifs.storage.SmallBlockTableReader;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSReader {
    private boolean notifyEmptyDirectories = false;
    private final POIFSReaderRegistry registry = new POIFSReaderRegistry();
    private boolean registryClosed = false;

    public void read(InputStream inputStream) throws IOException {
        this.registryClosed = true;
        HeaderBlock headerBlock = new HeaderBlock(inputStream);
        RawDataBlockList rawDataBlockList = new RawDataBlockList(inputStream, headerBlock.getBigBlockSize());
        new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), rawDataBlockList);
        RootProperty root = new PropertyTable(headerBlock, rawDataBlockList).getRoot();
        processProperties(SmallBlockTableReader.getSmallDocumentBlocks(headerBlock.getBigBlockSize(), rawDataBlockList, root, headerBlock.getSBATStart()), rawDataBlockList, root.getChildren(), new POIFSDocumentPath());
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener) {
        pOIFSReaderListener.getClass();
        if (this.registryClosed) {
            throw new IllegalStateException();
        }
        this.registry.registerListener(pOIFSReaderListener);
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, String str) {
        registerListener(pOIFSReaderListener, null, str);
    }

    public void registerListener(POIFSReaderListener pOIFSReaderListener, POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (pOIFSReaderListener == null || str == null || str.length() == 0) {
            throw null;
        }
        if (this.registryClosed) {
            throw new IllegalStateException();
        }
        POIFSReaderRegistry pOIFSReaderRegistry = this.registry;
        if (pOIFSDocumentPath == null) {
            pOIFSDocumentPath = new POIFSDocumentPath();
        }
        pOIFSReaderRegistry.registerListener(pOIFSReaderListener, pOIFSDocumentPath, str);
    }

    public void setNotifyEmptyDirectories(boolean z) {
        this.notifyEmptyDirectories = z;
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            System.err.println("at least one argument required: input filename(s)");
            System.exit(1);
        }
        for (String str : strArr) {
            POIFSReader pOIFSReader = new POIFSReader();
            pOIFSReader.registerListener(new SampleListener());
            System.out.println("reading " + str);
            FileInputStream fileInputStream = new FileInputStream(str);
            pOIFSReader.read(fileInputStream);
            fileInputStream.close();
        }
    }

    private void processProperties(BlockList blockList, BlockList blockList2, Iterator<Property> it, POIFSDocumentPath pOIFSDocumentPath) throws IOException {
        OPOIFSDocument oPOIFSDocument;
        if (!it.hasNext() && this.notifyEmptyDirectories) {
            Iterator<POIFSReaderListener> listeners = this.registry.getListeners(pOIFSDocumentPath, ".");
            while (listeners.hasNext()) {
                listeners.next().processPOIFSReaderEvent(new POIFSReaderEvent(null, pOIFSDocumentPath, null));
            }
            return;
        }
        while (it.hasNext()) {
            Property next = it.next();
            String name = next.getName();
            if (next.isDirectory()) {
                processProperties(blockList, blockList2, ((DirectoryProperty) next).getChildren(), new POIFSDocumentPath(pOIFSDocumentPath, new String[]{name}));
            } else {
                int startBlock = next.getStartBlock();
                Iterator<POIFSReaderListener> listeners2 = this.registry.getListeners(pOIFSDocumentPath, name);
                if (listeners2.hasNext()) {
                    int size = next.getSize();
                    if (next.shouldUseSmallBlocks()) {
                        oPOIFSDocument = new OPOIFSDocument(name, blockList.fetchBlocks(startBlock, -1), size);
                    } else {
                        oPOIFSDocument = new OPOIFSDocument(name, blockList2.fetchBlocks(startBlock, -1), size);
                    }
                    while (listeners2.hasNext()) {
                        listeners2.next().processPOIFSReaderEvent(new POIFSReaderEvent(new DocumentInputStream(oPOIFSDocument), pOIFSDocumentPath, name));
                    }
                } else if (next.shouldUseSmallBlocks()) {
                    blockList.fetchBlocks(startBlock, -1);
                } else {
                    blockList2.fetchBlocks(startBlock, -1);
                }
            }
        }
    }

    private static class SampleListener implements POIFSReaderListener {
        SampleListener() {
        }

        @Override // org.apache.poi.poifs.eventfilesystem.POIFSReaderListener
        public void processPOIFSReaderEvent(POIFSReaderEvent pOIFSReaderEvent) {
            DocumentInputStream stream = pOIFSReaderEvent.getStream();
            POIFSDocumentPath path = pOIFSReaderEvent.getPath();
            String name = pOIFSReaderEvent.getName();
            try {
                byte[] byteArray = IOUtils.toByteArray(stream);
                int length = path.length();
                for (int i = 0; i < length; i++) {
                    System.out.print("/" + path.getComponent(i));
                }
                System.out.println("/" + name + ": " + byteArray.length + " bytes read");
            } catch (IOException unused) {
            } finally {
                IOUtils.closeQuietly(stream);
            }
        }
    }
}
