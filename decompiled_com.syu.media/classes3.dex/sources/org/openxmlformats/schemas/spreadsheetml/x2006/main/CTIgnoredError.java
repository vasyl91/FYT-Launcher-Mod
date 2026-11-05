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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTIgnoredError extends XmlObject {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTIgnoredError.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctignorederrorc51ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTIgnoredError newInstance() {
            return (CTIgnoredError) POIXMLTypeLoader.newInstance(CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError newInstance(XmlOptions xmlOptions) {
            return (CTIgnoredError) POIXMLTypeLoader.newInstance(CTIgnoredError.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIgnoredError.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(File file) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(file, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(file, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(InputStream inputStream) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(inputStream, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(inputStream, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(Reader reader) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(reader, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(reader, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(String str) throws XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(str, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(str, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(URL url) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(url, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(url, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(xMLStreamReader, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(xMLStreamReader, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(xMLInputStream, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(xMLInputStream, CTIgnoredError.type, xmlOptions);
        }

        public static CTIgnoredError parse(Node node) throws XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(node, CTIgnoredError.type, (XmlOptions) null);
        }

        public static CTIgnoredError parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (CTIgnoredError) POIXMLTypeLoader.parse(node, CTIgnoredError.type, xmlOptions);
        }
    }

    boolean getCalculatedColumn();

    boolean getEmptyCellReference();

    boolean getEvalError();

    boolean getFormula();

    boolean getFormulaRange();

    boolean getListDataValidation();

    boolean getNumberStoredAsText();

    List getSqref();

    boolean getTwoDigitTextYear();

    boolean getUnlockedFormula();

    boolean isSetCalculatedColumn();

    boolean isSetEmptyCellReference();

    boolean isSetEvalError();

    boolean isSetFormula();

    boolean isSetFormulaRange();

    boolean isSetListDataValidation();

    boolean isSetNumberStoredAsText();

    boolean isSetTwoDigitTextYear();

    boolean isSetUnlockedFormula();

    void setCalculatedColumn(boolean z);

    void setEmptyCellReference(boolean z);

    void setEvalError(boolean z);

    void setFormula(boolean z);

    void setFormulaRange(boolean z);

    void setListDataValidation(boolean z);

    void setNumberStoredAsText(boolean z);

    void setSqref(List list);

    void setTwoDigitTextYear(boolean z);

    void setUnlockedFormula(boolean z);

    void unsetCalculatedColumn();

    void unsetEmptyCellReference();

    void unsetEvalError();

    void unsetFormula();

    void unsetFormulaRange();

    void unsetListDataValidation();

    void unsetNumberStoredAsText();

    void unsetTwoDigitTextYear();

    void unsetUnlockedFormula();

    XmlBoolean xgetCalculatedColumn();

    XmlBoolean xgetEmptyCellReference();

    XmlBoolean xgetEvalError();

    XmlBoolean xgetFormula();

    XmlBoolean xgetFormulaRange();

    XmlBoolean xgetListDataValidation();

    XmlBoolean xgetNumberStoredAsText();

    STSqref xgetSqref();

    XmlBoolean xgetTwoDigitTextYear();

    XmlBoolean xgetUnlockedFormula();

    void xsetCalculatedColumn(XmlBoolean xmlBoolean);

    void xsetEmptyCellReference(XmlBoolean xmlBoolean);

    void xsetEvalError(XmlBoolean xmlBoolean);

    void xsetFormula(XmlBoolean xmlBoolean);

    void xsetFormulaRange(XmlBoolean xmlBoolean);

    void xsetListDataValidation(XmlBoolean xmlBoolean);

    void xsetNumberStoredAsText(XmlBoolean xmlBoolean);

    void xsetSqref(STSqref sTSqref);

    void xsetTwoDigitTextYear(XmlBoolean xmlBoolean);

    void xsetUnlockedFormula(XmlBoolean xmlBoolean);
}
