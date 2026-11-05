package org.apache.poi;

import java.io.IOException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.util.ZipSecureFile;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class POIXMLTextExtractor extends POITextExtractor {
    private final POIXMLDocument _document;

    public POIXMLTextExtractor(POIXMLDocument pOIXMLDocument) {
        this._document = pOIXMLDocument;
    }

    public POIXMLProperties.CoreProperties getCoreProperties() {
        return this._document.getProperties().getCoreProperties();
    }

    public POIXMLProperties.ExtendedProperties getExtendedProperties() {
        return this._document.getProperties().getExtendedProperties();
    }

    public POIXMLProperties.CustomProperties getCustomProperties() {
        return this._document.getProperties().getCustomProperties();
    }

    public final POIXMLDocument getDocument() {
        return this._document;
    }

    public OPCPackage getPackage() {
        return this._document.getPackage();
    }

    @Override // org.apache.poi.POITextExtractor
    public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
        return new POIXMLPropertiesTextExtractor(this._document);
    }

    @Override // org.apache.poi.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OPCPackage oPCPackage;
        POIXMLDocument pOIXMLDocument = this._document;
        if (pOIXMLDocument != null && (oPCPackage = pOIXMLDocument.getPackage()) != null) {
            oPCPackage.revert();
        }
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkMaxTextSize(StringBuffer stringBuffer, String str) {
        if (str == null) {
            return;
        }
        int length = stringBuffer.length() + str.length();
        if (length > ZipSecureFile.getMaxTextSize()) {
            throw new IllegalStateException("The text would exceed the max allowed overall size of extracted text. By default this is prevented as some documents may exhaust available memory and it may indicate that the file is used to inflate memory usage and thus could pose a security risk. You can adjust this limit via ZipSecureFile.setMaxTextSize() if you need to work with files which have a lot of text. Size: " + length + ", limit: MAX_TEXT_SIZE: " + ZipSecureFile.getMaxTextSize());
        }
    }
}
