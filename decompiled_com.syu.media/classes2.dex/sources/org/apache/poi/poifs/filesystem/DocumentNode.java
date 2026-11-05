package org.apache.poi.poifs.filesystem;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.property.DocumentProperty;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DocumentNode extends EntryNode implements DocumentEntry, POIFSViewable {
    private OPOIFSDocument _document;

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return new Object[0];
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode
    protected boolean isDeleteOK() {
        return true;
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode, org.apache.poi.poifs.filesystem.Entry
    public boolean isDocumentEntry() {
        return true;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return false;
    }

    DocumentNode(DocumentProperty documentProperty, DirectoryNode directoryNode) {
        super(documentProperty, directoryNode);
        this._document = documentProperty.getDocument();
    }

    OPOIFSDocument getDocument() {
        return this._document;
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentEntry
    public int getSize() {
        return getProperty().getSize();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getProperty());
        OPOIFSDocument oPOIFSDocument = this._document;
        if (oPOIFSDocument != null) {
            arrayList.add(oPOIFSDocument);
        }
        return arrayList.iterator();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return getName();
    }
}
