package org.apache.poi.poifs.eventfilesystem;

import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIFSReaderEvent {
    private final String documentName;
    private final POIFSDocumentPath path;
    private final DocumentInputStream stream;

    POIFSReaderEvent(DocumentInputStream documentInputStream, POIFSDocumentPath pOIFSDocumentPath, String str) {
        this.stream = documentInputStream;
        this.path = pOIFSDocumentPath;
        this.documentName = str;
    }

    public DocumentInputStream getStream() {
        return this.stream;
    }

    public POIFSDocumentPath getPath() {
        return this.path;
    }

    public String getName() {
        return this.documentName;
    }
}
