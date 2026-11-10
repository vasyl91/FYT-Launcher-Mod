package org.apache.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIXMLTypeLoader {
    public static final XmlOptions DEFAULT_XML_OPTIONS;
    private static final String MS_EXCEL_URN = "urn:schemas-microsoft-com:office:excel";
    private static final String MS_OFFICE_URN = "urn:schemas-microsoft-com:office:office";
    private static final String MS_VML_URN = "urn:schemas-microsoft-com:vml";
    private static final String MS_WORD_URN = "urn:schemas-microsoft-com:office:word";
    private static ThreadLocal<SchemaTypeLoader> typeLoader = new ThreadLocal<>();

    @Removal(version = "4.0")
    @Deprecated
    public static void setClassLoader(ClassLoader classLoader) {
    }

    static {
        XmlOptions xmlOptions = new XmlOptions();
        DEFAULT_XML_OPTIONS = xmlOptions;
        xmlOptions.setSaveOuter();
        xmlOptions.setUseDefaultNamespace();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setCharacterEncoding("UTF-8");
        HashMap map = new HashMap();
        map.put(XSSFRelation.NS_DRAWINGML, "a");
        map.put(XSSFRelation.NS_CHART, "c");
        map.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
        map.put(PackageNamespaces.MARKUP_COMPATIBILITY, "ve");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
        map.put(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "r");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vt");
        map.put("http://schemas.openxmlformats.org/presentationml/2006/main", "p");
        map.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        map.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
        map.put(MS_OFFICE_URN, "o");
        map.put(MS_EXCEL_URN, "x");
        map.put(MS_WORD_URN, "w10");
        map.put(MS_VML_URN, "v");
        xmlOptions.setSaveSuggestedPrefixes(Collections.unmodifiableMap(map));
    }

    private static XmlOptions getXmlOptions(XmlOptions xmlOptions) {
        return xmlOptions == null ? DEFAULT_XML_OPTIONS : xmlOptions;
    }

    private static SchemaTypeLoader getTypeLoader(SchemaType schemaType) {
        SchemaTypeLoader schemaTypeLoader = typeLoader.get();
        if (schemaTypeLoader != null) {
            return schemaTypeLoader;
        }
        SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(schemaType.getClass().getClassLoader());
        typeLoader.set(schemaTypeLoaderTypeLoaderForClassLoader);
        return schemaTypeLoaderTypeLoaderForClassLoader;
    }

    public static XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        return getTypeLoader(schemaType).newInstance(schemaType, getXmlOptions(xmlOptions));
    }

    public static XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        try {
            return parse(new StringReader(str), schemaType, xmlOptions);
        } catch (IOException e) {
            throw new XmlException("Unable to parse xml bean", e);
        }
    }

    public static XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream, schemaType, xmlOptions);
        } finally {
            fileInputStream.close();
        }
    }

    public static XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            return parse(inputStreamOpenStream, schemaType, xmlOptions);
        } finally {
            inputStreamOpenStream.close();
        }
    }

    public static XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        try {
            return getTypeLoader(schemaType).parse(DocumentHelper.readDocument(inputStream).getDocumentElement(), schemaType, getXmlOptions(xmlOptions));
        } catch (SAXException e) {
            throw new IOException("Unable to parse xml bean", e);
        }
    }

    public static XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        return getTypeLoader(schemaType).parse(xMLStreamReader, schemaType, getXmlOptions(xmlOptions));
    }

    public static XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        try {
            return getTypeLoader(schemaType).parse(DocumentHelper.readDocument(new InputSource(reader)).getDocumentElement(), schemaType, getXmlOptions(xmlOptions));
        } catch (SAXException e) {
            throw new XmlException("Unable to parse xml bean", e);
        }
    }

    public static XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        return getTypeLoader(schemaType).parse(node, schemaType, getXmlOptions(xmlOptions));
    }

    public static XmlObject parse(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
        return getTypeLoader(schemaType).parse(xMLInputStream, schemaType, getXmlOptions(xmlOptions));
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException, XmlException {
        return getTypeLoader(schemaType).newValidatingXMLInputStream(xMLInputStream, schemaType, getXmlOptions(xmlOptions));
    }
}
