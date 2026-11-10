package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTWorkbook extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTWorkbook.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworkbook83c3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTWorkbook newInstance() {
            return (CTWorkbook) POIXMLTypeLoader.newInstance(CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook newInstance(XmlOptions xmlOptions) {
            return (CTWorkbook) POIXMLTypeLoader.newInstance(CTWorkbook.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorkbook.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(File file) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(file, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(file, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(InputStream inputStream) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(inputStream, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(inputStream, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(Reader reader) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(reader, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(reader, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(String str) throws XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(str, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(str, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(URL url) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(url, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbook) POIXMLTypeLoader.parse(url, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(xMLStreamReader, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(xMLStreamReader, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(xMLInputStream, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(xMLInputStream, CTWorkbook.type, xmlOptions);
        }

        public static CTWorkbook parse(Node node) throws XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(node, CTWorkbook.type, (XmlOptions) null);
        }

        public static CTWorkbook parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbook) POIXMLTypeLoader.parse(node, CTWorkbook.type, xmlOptions);
        }
    }

    CTBookViews addNewBookViews();

    CTCalcPr addNewCalcPr();

    CTCustomWorkbookViews addNewCustomWorkbookViews();

    CTDefinedNames addNewDefinedNames();

    CTExtensionList addNewExtLst();

    CTExternalReferences addNewExternalReferences();

    CTFileRecoveryPr addNewFileRecoveryPr();

    CTFileSharing addNewFileSharing();

    CTFileVersion addNewFileVersion();

    CTFunctionGroups addNewFunctionGroups();

    CTOleSize addNewOleSize();

    CTPivotCaches addNewPivotCaches();

    CTSheets addNewSheets();

    CTSmartTagPr addNewSmartTagPr();

    CTSmartTagTypes addNewSmartTagTypes();

    CTWebPublishObjects addNewWebPublishObjects();

    CTWebPublishing addNewWebPublishing();

    CTWorkbookPr addNewWorkbookPr();

    CTWorkbookProtection addNewWorkbookProtection();

    CTBookViews getBookViews();

    CTCalcPr getCalcPr();

    CTCustomWorkbookViews getCustomWorkbookViews();

    CTDefinedNames getDefinedNames();

    CTExtensionList getExtLst();

    CTExternalReferences getExternalReferences();

    CTFileRecoveryPr getFileRecoveryPrArray(int i);

    CTFileRecoveryPr[] getFileRecoveryPrArray();

    List<CTFileRecoveryPr> getFileRecoveryPrList();

    CTFileSharing getFileSharing();

    CTFileVersion getFileVersion();

    CTFunctionGroups getFunctionGroups();

    CTOleSize getOleSize();

    CTPivotCaches getPivotCaches();

    CTSheets getSheets();

    CTSmartTagPr getSmartTagPr();

    CTSmartTagTypes getSmartTagTypes();

    CTWebPublishObjects getWebPublishObjects();

    CTWebPublishing getWebPublishing();

    CTWorkbookPr getWorkbookPr();

    CTWorkbookProtection getWorkbookProtection();

    CTFileRecoveryPr insertNewFileRecoveryPr(int i);

    boolean isSetBookViews();

    boolean isSetCalcPr();

    boolean isSetCustomWorkbookViews();

    boolean isSetDefinedNames();

    boolean isSetExtLst();

    boolean isSetExternalReferences();

    boolean isSetFileSharing();

    boolean isSetFileVersion();

    boolean isSetFunctionGroups();

    boolean isSetOleSize();

    boolean isSetPivotCaches();

    boolean isSetSmartTagPr();

    boolean isSetSmartTagTypes();

    boolean isSetWebPublishObjects();

    boolean isSetWebPublishing();

    boolean isSetWorkbookPr();

    boolean isSetWorkbookProtection();

    void removeFileRecoveryPr(int i);

    void setBookViews(CTBookViews cTBookViews);

    void setCalcPr(CTCalcPr cTCalcPr);

    void setCustomWorkbookViews(CTCustomWorkbookViews cTCustomWorkbookViews);

    void setDefinedNames(CTDefinedNames cTDefinedNames);

    void setExtLst(CTExtensionList cTExtensionList);

    void setExternalReferences(CTExternalReferences cTExternalReferences);

    void setFileRecoveryPrArray(int i, CTFileRecoveryPr cTFileRecoveryPr);

    void setFileRecoveryPrArray(CTFileRecoveryPr[] cTFileRecoveryPrArr);

    void setFileSharing(CTFileSharing cTFileSharing);

    void setFileVersion(CTFileVersion cTFileVersion);

    void setFunctionGroups(CTFunctionGroups cTFunctionGroups);

    void setOleSize(CTOleSize cTOleSize);

    void setPivotCaches(CTPivotCaches cTPivotCaches);

    void setSheets(CTSheets cTSheets);

    void setSmartTagPr(CTSmartTagPr cTSmartTagPr);

    void setSmartTagTypes(CTSmartTagTypes cTSmartTagTypes);

    void setWebPublishObjects(CTWebPublishObjects cTWebPublishObjects);

    void setWebPublishing(CTWebPublishing cTWebPublishing);

    void setWorkbookPr(CTWorkbookPr cTWorkbookPr);

    void setWorkbookProtection(CTWorkbookProtection cTWorkbookProtection);

    int sizeOfFileRecoveryPrArray();

    void unsetBookViews();

    void unsetCalcPr();

    void unsetCustomWorkbookViews();

    void unsetDefinedNames();

    void unsetExtLst();

    void unsetExternalReferences();

    void unsetFileSharing();

    void unsetFileVersion();

    void unsetFunctionGroups();

    void unsetOleSize();

    void unsetPivotCaches();

    void unsetSmartTagPr();

    void unsetSmartTagTypes();

    void unsetWebPublishObjects();

    void unsetWebPublishing();

    void unsetWorkbookPr();

    void unsetWorkbookProtection();
}
