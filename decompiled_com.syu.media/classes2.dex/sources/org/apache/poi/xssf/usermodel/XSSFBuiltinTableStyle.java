package org.apache.poi.xssf.usermodel;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.EnumMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DifferentialStyleProvider;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleType;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.model.StylesTable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum XSSFBuiltinTableStyle {
    TableStyleDark1,
    TableStyleDark2,
    TableStyleDark3,
    TableStyleDark4,
    TableStyleDark5,
    TableStyleDark6,
    TableStyleDark7,
    TableStyleDark8,
    TableStyleDark9,
    TableStyleDark10,
    TableStyleDark11,
    TableStyleLight1,
    TableStyleLight2,
    TableStyleLight3,
    TableStyleLight4,
    TableStyleLight5,
    TableStyleLight6,
    TableStyleLight7,
    TableStyleLight8,
    TableStyleLight9,
    TableStyleLight10,
    TableStyleLight11,
    TableStyleLight12,
    TableStyleLight13,
    TableStyleLight14,
    TableStyleLight15,
    TableStyleLight16,
    TableStyleLight17,
    TableStyleLight18,
    TableStyleLight19,
    TableStyleLight20,
    TableStyleLight21,
    TableStyleMedium1,
    TableStyleMedium2,
    TableStyleMedium3,
    TableStyleMedium4,
    TableStyleMedium5,
    TableStyleMedium6,
    TableStyleMedium7,
    TableStyleMedium8,
    TableStyleMedium9,
    TableStyleMedium10,
    TableStyleMedium11,
    TableStyleMedium12,
    TableStyleMedium13,
    TableStyleMedium14,
    TableStyleMedium15,
    TableStyleMedium16,
    TableStyleMedium17,
    TableStyleMedium18,
    TableStyleMedium19,
    TableStyleMedium20,
    TableStyleMedium21,
    TableStyleMedium22,
    TableStyleMedium23,
    TableStyleMedium24,
    TableStyleMedium25,
    TableStyleMedium26,
    TableStyleMedium27,
    TableStyleMedium28,
    PivotStyleMedium1,
    PivotStyleMedium2,
    PivotStyleMedium3,
    PivotStyleMedium4,
    PivotStyleMedium5,
    PivotStyleMedium6,
    PivotStyleMedium7,
    PivotStyleMedium8,
    PivotStyleMedium9,
    PivotStyleMedium10,
    PivotStyleMedium11,
    PivotStyleMedium12,
    PivotStyleMedium13,
    PivotStyleMedium14,
    PivotStyleMedium15,
    PivotStyleMedium16,
    PivotStyleMedium17,
    PivotStyleMedium18,
    PivotStyleMedium19,
    PivotStyleMedium20,
    PivotStyleMedium21,
    PivotStyleMedium22,
    PivotStyleMedium23,
    PivotStyleMedium24,
    PivotStyleMedium25,
    PivotStyleMedium26,
    PivotStyleMedium27,
    PivotStyleMedium28,
    PivotStyleLight1,
    PivotStyleLight2,
    PivotStyleLight3,
    PivotStyleLight4,
    PivotStyleLight5,
    PivotStyleLight6,
    PivotStyleLight7,
    PivotStyleLight8,
    PivotStyleLight9,
    PivotStyleLight10,
    PivotStyleLight11,
    PivotStyleLight12,
    PivotStyleLight13,
    PivotStyleLight14,
    PivotStyleLight15,
    PivotStyleLight16,
    PivotStyleLight17,
    PivotStyleLight18,
    PivotStyleLight19,
    PivotStyleLight20,
    PivotStyleLight21,
    PivotStyleLight22,
    PivotStyleLight23,
    PivotStyleLight24,
    PivotStyleLight25,
    PivotStyleLight26,
    PivotStyleLight27,
    PivotStyleLight28,
    PivotStyleDark1,
    PivotStyleDark2,
    PivotStyleDark3,
    PivotStyleDark4,
    PivotStyleDark5,
    PivotStyleDark6,
    PivotStyleDark7,
    PivotStyleDark8,
    PivotStyleDark9,
    PivotStyleDark10,
    PivotStyleDark11,
    PivotStyleDark12,
    PivotStyleDark13,
    PivotStyleDark14,
    PivotStyleDark15,
    PivotStyleDark16,
    PivotStyleDark17,
    PivotStyleDark18,
    PivotStyleDark19,
    PivotStyleDark20,
    PivotStyleDark21,
    PivotStyleDark22,
    PivotStyleDark23,
    PivotStyleDark24,
    PivotStyleDark25,
    PivotStyleDark26,
    PivotStyleDark27,
    PivotStyleDark28;

    private static final Map<XSSFBuiltinTableStyle, TableStyle> styleMap = new EnumMap(XSSFBuiltinTableStyle.class);

    public TableStyle getStyle() {
        init();
        return styleMap.get(this);
    }

    public static boolean isBuiltinStyle(TableStyle tableStyle) {
        if (tableStyle == null) {
            return false;
        }
        try {
            valueOf(tableStyle.getName());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static final synchronized void init() {
        if (styleMap.isEmpty()) {
            try {
                InputStream resourceAsStream = XSSFBuiltinTableStyle.class.getResourceAsStream("presetTableStyles.xml");
                try {
                    NodeList childNodes = DocumentHelper.readDocument(resourceAsStream).getDocumentElement().getChildNodes();
                    for (int i = 0; i < childNodes.getLength(); i++) {
                        Node nodeItem = childNodes.item(i);
                        if (nodeItem.getNodeType() == 1) {
                            Element element = (Element) nodeItem;
                            String tagName = element.getTagName();
                            XSSFBuiltinTableStyle xSSFBuiltinTableStyleValueOf = valueOf(tagName);
                            Node nodeItem2 = element.getElementsByTagName("dxfs").item(0);
                            Node nodeItem3 = element.getElementsByTagName("tableStyles").item(0);
                            StylesTable stylesTable = new StylesTable();
                            stylesTable.readFrom(new ByteArrayInputStream(styleXML(nodeItem2, nodeItem3).getBytes(Charset.forName("UTF-8"))));
                            styleMap.put(xSSFBuiltinTableStyleValueOf, new XSSFBuiltinTypeStyleStyle(xSSFBuiltinTableStyleValueOf, stylesTable.getExplicitTableStyle(tagName)));
                        }
                    }
                    IOUtils.closeQuietly(resourceAsStream);
                } catch (Throwable th) {
                    IOUtils.closeQuietly(resourceAsStream);
                    throw th;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String styleXML(Node node, Node node2) {
        node.insertBefore(node.getOwnerDocument().createElement("dxf"), node.getFirstChild());
        LSSerializer lSSerializerCreateLSSerializer = ((DOMImplementationLS) node.getOwnerDocument().getImplementation().getFeature("LS", "3.0")).createLSSerializer();
        lSSerializerCreateLSSerializer.getDomConfig().setParameter("xml-declaration", false);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<styleSheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:x14ac=\"http://schemas.microsoft.com/office/spreadsheetml/2009/9/ac\" xmlns:x16r2=\"http://schemas.microsoft.com/office/spreadsheetml/2015/02/main\" mc:Ignorable=\"x14ac x16r2\">\n" + lSSerializerCreateLSSerializer.writeToString(node) + lSSerializerCreateLSSerializer.writeToString(node2) + "</styleSheet>";
    }

    protected static class XSSFBuiltinTypeStyleStyle implements TableStyle {
        private final XSSFBuiltinTableStyle builtIn;
        private final TableStyle style;

        @Override // org.apache.poi.ss.usermodel.TableStyle
        public boolean isBuiltin() {
            return true;
        }

        protected XSSFBuiltinTypeStyleStyle(XSSFBuiltinTableStyle xSSFBuiltinTableStyle, TableStyle tableStyle) {
            this.builtIn = xSSFBuiltinTableStyle;
            this.style = tableStyle;
        }

        @Override // org.apache.poi.ss.usermodel.TableStyle
        public String getName() {
            return this.style.getName();
        }

        @Override // org.apache.poi.ss.usermodel.TableStyle
        public int getIndex() {
            return this.builtIn.ordinal();
        }

        @Override // org.apache.poi.ss.usermodel.TableStyle
        public DifferentialStyleProvider getStyle(TableStyleType tableStyleType) {
            return this.style.getStyle(tableStyleType);
        }
    }
}
