package org.apache.poi.poifs.property;

import org.apache.poi.poifs.filesystem.OPOIFSDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class DocumentProperty extends Property {
    private OPOIFSDocument _document;

    @Override // org.apache.poi.poifs.property.Property
    public boolean isDirectory() {
        return false;
    }

    @Override // org.apache.poi.poifs.property.Property
    protected void preWrite() {
    }

    public DocumentProperty(String str, int i) {
        this._document = null;
        setName(str);
        setSize(i);
        setNodeColor((byte) 1);
        setPropertyType((byte) 2);
    }

    protected DocumentProperty(int i, byte[] bArr, int i2) {
        super(i, bArr, i2);
        this._document = null;
    }

    public void setDocument(OPOIFSDocument oPOIFSDocument) {
        this._document = oPOIFSDocument;
    }

    public OPOIFSDocument getDocument() {
        return this._document;
    }

    @Override // org.apache.poi.poifs.property.Property
    public boolean shouldUseSmallBlocks() {
        return super.shouldUseSmallBlocks();
    }

    public void updateSize(int i) {
        setSize(i);
    }
}
