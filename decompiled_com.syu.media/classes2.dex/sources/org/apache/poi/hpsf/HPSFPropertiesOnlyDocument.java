package org.apache.poi.hpsf;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.POIDocument;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HPSFPropertiesOnlyDocument extends POIDocument {
    public HPSFPropertiesOnlyDocument(NPOIFSFileSystem nPOIFSFileSystem) {
        super(nPOIFSFileSystem.getRoot());
    }

    public HPSFPropertiesOnlyDocument(OPOIFSFileSystem oPOIFSFileSystem) {
        super(oPOIFSFileSystem);
    }

    public HPSFPropertiesOnlyDocument(POIFSFileSystem pOIFSFileSystem) {
        super(pOIFSFileSystem);
    }

    @Override // org.apache.poi.POIDocument
    public void write() throws IOException {
        NPOIFSFileSystem fileSystem = getDirectory().getFileSystem();
        validateInPlaceWritePossible();
        writeProperties(fileSystem, null);
        fileSystem.writeFilesystem();
    }

    @Override // org.apache.poi.POIDocument
    public void write(File file) throws IOException {
        POIFSFileSystem pOIFSFileSystemCreate = POIFSFileSystem.create(file);
        try {
            write(pOIFSFileSystemCreate);
            pOIFSFileSystemCreate.writeFilesystem();
        } finally {
            pOIFSFileSystemCreate.close();
        }
    }

    @Override // org.apache.poi.POIDocument
    public void write(OutputStream outputStream) throws IOException {
        NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem();
        try {
            write(nPOIFSFileSystem);
            nPOIFSFileSystem.writeFilesystem(outputStream);
        } finally {
            nPOIFSFileSystem.close();
        }
    }

    private void write(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        ArrayList arrayList = new ArrayList(2);
        writeProperties(nPOIFSFileSystem, arrayList);
        EntryUtils.copyNodes(new FilteringDirectoryNode(getDirectory(), arrayList), new FilteringDirectoryNode(nPOIFSFileSystem.getRoot(), arrayList));
    }
}
