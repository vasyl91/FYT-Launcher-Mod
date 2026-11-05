package org.apache.poi;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.extractor.HPSFPropertiesExtractor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class POIOLE2TextExtractor extends POITextExtractor {
    protected POIDocument document;

    public POIOLE2TextExtractor(POIDocument pOIDocument) {
        this.document = pOIDocument;
        setFilesystem(pOIDocument);
    }

    protected POIOLE2TextExtractor(POIOLE2TextExtractor pOIOLE2TextExtractor) {
        this.document = pOIOLE2TextExtractor.document;
    }

    public DocumentSummaryInformation getDocSummaryInformation() {
        return this.document.getDocumentSummaryInformation();
    }

    public SummaryInformation getSummaryInformation() {
        return this.document.getSummaryInformation();
    }

    @Override // org.apache.poi.POITextExtractor
    public POITextExtractor getMetadataTextExtractor() {
        return new HPSFPropertiesExtractor(this);
    }

    public DirectoryEntry getRoot() {
        return this.document.getDirectory();
    }

    public POIDocument getDocument() {
        return this.document;
    }
}
