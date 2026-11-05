package org.apache.poi.hpsf.extractor;

import java.io.File;
import java.io.IOException;
import org.apache.poi.POIDocument;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.POITextExtractor;
import org.apache.poi.hpsf.CustomProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.HPSFPropertiesOnlyDocument;
import org.apache.poi.hpsf.Property;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class HPSFPropertiesExtractor extends POIOLE2TextExtractor {
    public HPSFPropertiesExtractor(POIOLE2TextExtractor pOIOLE2TextExtractor) {
        super(pOIOLE2TextExtractor);
    }

    public HPSFPropertiesExtractor(POIDocument pOIDocument) {
        super(pOIDocument);
    }

    public HPSFPropertiesExtractor(POIFSFileSystem pOIFSFileSystem) {
        super(new HPSFPropertiesOnlyDocument(pOIFSFileSystem));
    }

    public HPSFPropertiesExtractor(NPOIFSFileSystem nPOIFSFileSystem) {
        super(new HPSFPropertiesOnlyDocument(nPOIFSFileSystem));
    }

    public String getDocumentSummaryInformationText() {
        if (this.document == null) {
            return "";
        }
        DocumentSummaryInformation documentSummaryInformation = this.document.getDocumentSummaryInformation();
        StringBuilder sb = new StringBuilder();
        sb.append(getPropertiesText(documentSummaryInformation));
        CustomProperties customProperties = documentSummaryInformation == null ? null : documentSummaryInformation.getCustomProperties();
        if (customProperties != null) {
            for (String str : customProperties.nameSet()) {
                sb.append(str).append(" = ").append(getPropertyValueText(customProperties.get(str))).append("\n");
            }
        }
        return sb.toString();
    }

    public String getSummaryInformationText() {
        return this.document == null ? "" : getPropertiesText(this.document.getSummaryInformation());
    }

    private static String getPropertiesText(PropertySet propertySet) {
        if (propertySet == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        PropertyIDMap propertySetIDMap = propertySet.getPropertySetIDMap();
        for (Property property : propertySet.getProperties()) {
            String string = Long.toString(property.getID());
            String str = propertySetIDMap == null ? null : propertySetIDMap.get((Object) Long.valueOf(property.getID()));
            if (str != null) {
                string = str.toString();
            }
            sb.append(string).append(" = ").append(getPropertyValueText(property.getValue())).append("\n");
        }
        return sb.toString();
    }

    @Override // org.apache.poi.POITextExtractor
    public String getText() {
        return getSummaryInformationText() + getDocumentSummaryInformationText();
    }

    @Override // org.apache.poi.POIOLE2TextExtractor, org.apache.poi.POITextExtractor
    public POITextExtractor getMetadataTextExtractor() {
        throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
    }

    private static String getPropertyValueText(Object obj) {
        return obj == null ? "(not set)" : PropertySet.getPropertyStringValue(obj);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] strArr) throws IOException {
        for (String str : strArr) {
            HPSFPropertiesExtractor hPSFPropertiesExtractor = new HPSFPropertiesExtractor(new NPOIFSFileSystem(new File(str)));
            try {
                System.out.println(hPSFPropertiesExtractor.getText());
                hPSFPropertiesExtractor.close();
            } catch (Throwable th) {
                hPSFPropertiesExtractor.close();
                throw th;
            }
        }
    }
}
