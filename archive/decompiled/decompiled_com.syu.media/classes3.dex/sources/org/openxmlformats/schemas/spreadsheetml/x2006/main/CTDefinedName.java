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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface CTDefinedName extends STFormula {
    public static final SchemaType type = XmlBeans.typeSystemForClassLoader(CTDefinedName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdefinedname9413type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDefinedName newInstance() {
            return POIXMLTypeLoader.newInstance(CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName newInstance(XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newInstance(CTDefinedName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDefinedName.type, (XmlOptions) null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(File file) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(file, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(InputStream inputStream) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(inputStream, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(Reader reader) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(reader, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(String str) throws XmlException {
            return POIXMLTypeLoader.parse(str, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(String str, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(str, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(URL url) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return POIXMLTypeLoader.parse(url, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(xMLStreamReader, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(XMLInputStream xMLInputStream) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
            return POIXMLTypeLoader.parse(xMLInputStream, CTDefinedName.type, xmlOptions);
        }

        public static CTDefinedName parse(Node node) throws XmlException {
            return POIXMLTypeLoader.parse(node, CTDefinedName.type, (XmlOptions) null);
        }

        public static CTDefinedName parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return POIXMLTypeLoader.parse(node, CTDefinedName.type, xmlOptions);
        }
    }

    String getComment();

    String getCustomMenu();

    String getDescription();

    boolean getFunction();

    long getFunctionGroupId();

    String getHelp();

    boolean getHidden();

    long getLocalSheetId();

    String getName();

    boolean getPublishToServer();

    String getShortcutKey();

    String getStatusBar();

    boolean getVbProcedure();

    boolean getWorkbookParameter();

    boolean getXlm();

    boolean isSetComment();

    boolean isSetCustomMenu();

    boolean isSetDescription();

    boolean isSetFunction();

    boolean isSetFunctionGroupId();

    boolean isSetHelp();

    boolean isSetHidden();

    boolean isSetLocalSheetId();

    boolean isSetPublishToServer();

    boolean isSetShortcutKey();

    boolean isSetStatusBar();

    boolean isSetVbProcedure();

    boolean isSetWorkbookParameter();

    boolean isSetXlm();

    void setComment(String str);

    void setCustomMenu(String str);

    void setDescription(String str);

    void setFunction(boolean z);

    void setFunctionGroupId(long j);

    void setHelp(String str);

    void setHidden(boolean z);

    void setLocalSheetId(long j);

    void setName(String str);

    void setPublishToServer(boolean z);

    void setShortcutKey(String str);

    void setStatusBar(String str);

    void setVbProcedure(boolean z);

    void setWorkbookParameter(boolean z);

    void setXlm(boolean z);

    void unsetComment();

    void unsetCustomMenu();

    void unsetDescription();

    void unsetFunction();

    void unsetFunctionGroupId();

    void unsetHelp();

    void unsetHidden();

    void unsetLocalSheetId();

    void unsetPublishToServer();

    void unsetShortcutKey();

    void unsetStatusBar();

    void unsetVbProcedure();

    void unsetWorkbookParameter();

    void unsetXlm();

    STXstring xgetComment();

    STXstring xgetCustomMenu();

    STXstring xgetDescription();

    XmlBoolean xgetFunction();

    XmlUnsignedInt xgetFunctionGroupId();

    STXstring xgetHelp();

    XmlBoolean xgetHidden();

    XmlUnsignedInt xgetLocalSheetId();

    STXstring xgetName();

    XmlBoolean xgetPublishToServer();

    STXstring xgetShortcutKey();

    STXstring xgetStatusBar();

    XmlBoolean xgetVbProcedure();

    XmlBoolean xgetWorkbookParameter();

    XmlBoolean xgetXlm();

    void xsetComment(STXstring sTXstring);

    void xsetCustomMenu(STXstring sTXstring);

    void xsetDescription(STXstring sTXstring);

    void xsetFunction(XmlBoolean xmlBoolean);

    void xsetFunctionGroupId(XmlUnsignedInt xmlUnsignedInt);

    void xsetHelp(STXstring sTXstring);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetLocalSheetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);

    void xsetPublishToServer(XmlBoolean xmlBoolean);

    void xsetShortcutKey(STXstring sTXstring);

    void xsetStatusBar(STXstring sTXstring);

    void xsetVbProcedure(XmlBoolean xmlBoolean);

    void xsetWorkbookParameter(XmlBoolean xmlBoolean);

    void xsetXlm(XmlBoolean xmlBoolean);
}
