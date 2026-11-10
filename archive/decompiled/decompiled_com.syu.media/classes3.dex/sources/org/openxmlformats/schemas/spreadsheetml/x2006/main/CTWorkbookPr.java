package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTWorkbookPr extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTWorkbookPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworkbookpr03a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTWorkbookPr newInstance() {
            return (CTWorkbookPr) POIXMLTypeLoader.newInstance(CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr newInstance(XmlOptions xmlOptions) {
            return (CTWorkbookPr) POIXMLTypeLoader.newInstance(CTWorkbookPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(File file) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(file, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(file, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(InputStream inputStream) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(inputStream, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(inputStream, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(Reader reader) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(reader, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(reader, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(String str) throws XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(str, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(str, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(URL url) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(url, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(url, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(xMLStreamReader, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(xMLStreamReader, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(xMLInputStream, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(xMLInputStream, CTWorkbookPr.type, xmlOptions);
        }

        public static CTWorkbookPr parse(Node node) throws XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(node, CTWorkbookPr.type, (XmlOptions) null);
        }

        public static CTWorkbookPr parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTWorkbookPr) POIXMLTypeLoader.parse(node, CTWorkbookPr.type, xmlOptions);
        }
    }

    boolean getAllowRefreshQuery();

    boolean getAutoCompressPictures();

    boolean getBackupFile();

    boolean getCheckCompatibility();

    String getCodeName();

    boolean getDate1904();

    long getDefaultThemeVersion();

    boolean getFilterPrivacy();

    boolean getHidePivotFieldList();

    boolean getPromptedSolutions();

    boolean getPublishItems();

    boolean getRefreshAllConnections();

    boolean getSaveExternalLinkValues();

    boolean getShowBorderUnselectedTables();

    boolean getShowInkAnnotation();

    STObjects$Enum getShowObjects();

    boolean getShowPivotChartFilter();

    STUpdateLinks$Enum getUpdateLinks();

    boolean isSetAllowRefreshQuery();

    boolean isSetAutoCompressPictures();

    boolean isSetBackupFile();

    boolean isSetCheckCompatibility();

    boolean isSetCodeName();

    boolean isSetDate1904();

    boolean isSetDefaultThemeVersion();

    boolean isSetFilterPrivacy();

    boolean isSetHidePivotFieldList();

    boolean isSetPromptedSolutions();

    boolean isSetPublishItems();

    boolean isSetRefreshAllConnections();

    boolean isSetSaveExternalLinkValues();

    boolean isSetShowBorderUnselectedTables();

    boolean isSetShowInkAnnotation();

    boolean isSetShowObjects();

    boolean isSetShowPivotChartFilter();

    boolean isSetUpdateLinks();

    void setAllowRefreshQuery(boolean z);

    void setAutoCompressPictures(boolean z);

    void setBackupFile(boolean z);

    void setCheckCompatibility(boolean z);

    void setCodeName(String str);

    void setDate1904(boolean z);

    void setDefaultThemeVersion(long j);

    void setFilterPrivacy(boolean z);

    void setHidePivotFieldList(boolean z);

    void setPromptedSolutions(boolean z);

    void setPublishItems(boolean z);

    void setRefreshAllConnections(boolean z);

    void setSaveExternalLinkValues(boolean z);

    void setShowBorderUnselectedTables(boolean z);

    void setShowInkAnnotation(boolean z);

    void setShowObjects(STObjects$Enum sTObjects$Enum);

    void setShowPivotChartFilter(boolean z);

    void setUpdateLinks(STUpdateLinks$Enum sTUpdateLinks$Enum);

    void unsetAllowRefreshQuery();

    void unsetAutoCompressPictures();

    void unsetBackupFile();

    void unsetCheckCompatibility();

    void unsetCodeName();

    void unsetDate1904();

    void unsetDefaultThemeVersion();

    void unsetFilterPrivacy();

    void unsetHidePivotFieldList();

    void unsetPromptedSolutions();

    void unsetPublishItems();

    void unsetRefreshAllConnections();

    void unsetSaveExternalLinkValues();

    void unsetShowBorderUnselectedTables();

    void unsetShowInkAnnotation();

    void unsetShowObjects();

    void unsetShowPivotChartFilter();

    void unsetUpdateLinks();

    XmlBoolean xgetAllowRefreshQuery();

    XmlBoolean xgetAutoCompressPictures();

    XmlBoolean xgetBackupFile();

    XmlBoolean xgetCheckCompatibility();

    XmlString xgetCodeName();

    XmlBoolean xgetDate1904();

    XmlUnsignedInt xgetDefaultThemeVersion();

    XmlBoolean xgetFilterPrivacy();

    XmlBoolean xgetHidePivotFieldList();

    XmlBoolean xgetPromptedSolutions();

    XmlBoolean xgetPublishItems();

    XmlBoolean xgetRefreshAllConnections();

    XmlBoolean xgetSaveExternalLinkValues();

    XmlBoolean xgetShowBorderUnselectedTables();

    XmlBoolean xgetShowInkAnnotation();

    STObjects xgetShowObjects();

    XmlBoolean xgetShowPivotChartFilter();

    STUpdateLinks xgetUpdateLinks();

    void xsetAllowRefreshQuery(XmlBoolean xmlBoolean);

    void xsetAutoCompressPictures(XmlBoolean xmlBoolean);

    void xsetBackupFile(XmlBoolean xmlBoolean);

    void xsetCheckCompatibility(XmlBoolean xmlBoolean);

    void xsetCodeName(XmlString xmlString);

    void xsetDate1904(XmlBoolean xmlBoolean);

    void xsetDefaultThemeVersion(XmlUnsignedInt xmlUnsignedInt);

    void xsetFilterPrivacy(XmlBoolean xmlBoolean);

    void xsetHidePivotFieldList(XmlBoolean xmlBoolean);

    void xsetPromptedSolutions(XmlBoolean xmlBoolean);

    void xsetPublishItems(XmlBoolean xmlBoolean);

    void xsetRefreshAllConnections(XmlBoolean xmlBoolean);

    void xsetSaveExternalLinkValues(XmlBoolean xmlBoolean);

    void xsetShowBorderUnselectedTables(XmlBoolean xmlBoolean);

    void xsetShowInkAnnotation(XmlBoolean xmlBoolean);

    void xsetShowObjects(STObjects sTObjects);

    void xsetShowPivotChartFilter(XmlBoolean xmlBoolean);

    void xsetUpdateLinks(STUpdateLinks sTUpdateLinks);
}
