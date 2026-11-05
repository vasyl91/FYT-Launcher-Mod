package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFImportFromXML {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFImportFromXML.class);
    private final XSSFMap _map;

    public XSSFImportFromXML(XSSFMap xSSFMap) {
        this._map = xSSFMap;
    }

    public void importFromXML(String str) throws XPathExpressionException, SAXException, IOException {
        String str2;
        Document document = DocumentHelper.newDocumentBuilder().parse(new InputSource(new StringReader(str.trim())));
        List<XSSFSingleXmlCell> relatedSingleXMLCell = this._map.getRelatedSingleXMLCell();
        List<XSSFTable> relatedTables = this._map.getRelatedTables();
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        xPathNewXPath.setNamespaceContext(new DefaultNamespaceContext(document));
        Iterator<XSSFSingleXmlCell> it = relatedSingleXMLCell.iterator();
        while (true) {
            str2 = " in sheet ";
            if (!it.hasNext()) {
                break;
            }
            XSSFSingleXmlCell next = it.next();
            STXmlDataType.Enum xmlDataType = next.getXmlDataType();
            String xpath = next.getXpath();
            Node node = (Node) xPathNewXPath.evaluate(xpath, document, XPathConstants.NODE);
            if (node != null) {
                String textContent = node.getTextContent();
                POILogger pOILogger = logger;
                pOILogger.log(1, "Extracting with xpath " + xpath + " : value is '" + textContent + "'");
                XSSFCell referencedCell = next.getReferencedCell();
                pOILogger.log(1, "Setting '" + textContent + "' to cell " + referencedCell.getColumnIndex() + "-" + referencedCell.getRowIndex() + " in sheet " + referencedCell.getSheet().getSheetName());
                setCellValue(textContent, referencedCell, xmlDataType);
            }
            it = it;
            document = document;
            xPathNewXPath = xPathNewXPath;
        }
        Document document2 = document;
        XPath xPath = xPathNewXPath;
        Iterator<XSSFTable> it2 = relatedTables.iterator();
        while (it2.hasNext()) {
            XSSFTable next2 = it2.next();
            Document document3 = document2;
            XPath xPath2 = xPath;
            NodeList nodeList = (NodeList) xPath2.evaluate(next2.getCommonXpath(), document3, XPathConstants.NODESET);
            int row = next2.getStartCellReference().getRow() + 1;
            int col = next2.getStartCellReference().getCol() - 1;
            Iterator<XSSFTable> it3 = it2;
            int i = 0;
            while (i < nodeList.getLength()) {
                NodeList nodeList2 = nodeList;
                Node nodeCloneNode = nodeList.item(i).cloneNode(true);
                Iterator<XSSFXmlColumnPr> it4 = next2.getXmlColumnPrs().iterator();
                while (it4.hasNext()) {
                    XSSFXmlColumnPr next3 = it4.next();
                    Document document4 = document3;
                    String str3 = str2;
                    int i2 = row + i;
                    int id = ((int) next3.getId()) + col;
                    Iterator<XSSFXmlColumnPr> it5 = it4;
                    String localXPath = next3.getLocalXPath();
                    int i3 = row;
                    int i4 = col;
                    String strSubstring = localXPath.substring(localXPath.substring(1).indexOf(47) + 2);
                    String str4 = (String) xPath2.evaluate(strSubstring, nodeCloneNode, XPathConstants.STRING);
                    POILogger pOILogger2 = logger;
                    Node node2 = nodeCloneNode;
                    XPath xPath3 = xPath2;
                    pOILogger2.log(1, "Extracting with xpath " + strSubstring + " : value is '" + str4 + "'");
                    XSSFRow row2 = next2.getXSSFSheet().getRow(i2);
                    if (row2 == null) {
                        row2 = next2.getXSSFSheet().createRow(i2);
                    }
                    XSSFCell cell = row2.getCell(id);
                    if (cell == null) {
                        cell = row2.createCell(id);
                    }
                    str2 = str3;
                    pOILogger2.log(1, "Setting '" + str4 + "' to cell " + cell.getColumnIndex() + "-" + cell.getRowIndex() + str2 + next2.getXSSFSheet().getSheetName());
                    setCellValue(str4, cell, next3.getXmlDataType());
                    document3 = document4;
                    it4 = it5;
                    row = i3;
                    col = i4;
                    nodeCloneNode = node2;
                    xPath2 = xPath3;
                }
                i++;
                nodeList = nodeList2;
                xPath2 = xPath2;
            }
            document2 = document3;
            xPath = xPath2;
            it2 = it3;
        }
    }

    private enum DataType {
        BOOLEAN(STXmlDataType.BOOLEAN),
        DOUBLE(STXmlDataType.DOUBLE),
        INTEGER(STXmlDataType.INT, STXmlDataType.UNSIGNED_INT, STXmlDataType.INTEGER),
        STRING(STXmlDataType.STRING),
        DATE(STXmlDataType.DATE);

        private Set<STXmlDataType.Enum> xmlDataTypes;

        DataType(STXmlDataType.Enum... enumArr) {
            this.xmlDataTypes = new HashSet(Arrays.asList(enumArr));
        }

        public static DataType getDataType(STXmlDataType.Enum r5) {
            for (DataType dataType : values()) {
                if (dataType.xmlDataTypes.contains(r5)) {
                    return dataType;
                }
            }
            return null;
        }
    }

    private void setCellValue(String str, XSSFCell xSSFCell, STXmlDataType.Enum r11) {
        DataType dataType = DataType.getDataType(r11);
        try {
            if (!str.isEmpty() && dataType != null) {
                int i = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[dataType.ordinal()];
                if (i == 1) {
                    xSSFCell.setCellValue(Boolean.parseBoolean(str));
                    return;
                }
                if (i == 2) {
                    xSSFCell.setCellValue(Double.parseDouble(str));
                    return;
                }
                if (i == 3) {
                    xSSFCell.setCellValue(Integer.parseInt(str));
                    return;
                }
                if (i == 4) {
                    xSSFCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd", LocaleUtil.getUserLocale()).parse(str));
                    if (DateUtil.isValidExcelDate(xSSFCell.getNumericCellValue())) {
                        return;
                    }
                    xSSFCell.setCellValue(str);
                    return;
                }
                xSSFCell.setCellValue(str.trim());
                return;
            }
            xSSFCell.setCellValue((String) null);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(String.format(LocaleUtil.getUserLocale(), "Unable to format value '%s' as %s for cell %s", str, dataType, new CellReference(xSSFCell).formatAsString()));
        } catch (ParseException unused2) {
            throw new IllegalArgumentException(String.format(LocaleUtil.getUserLocale(), "Unable to format value '%s' as %s for cell %s", str, dataType, new CellReference(xSSFCell).formatAsString()));
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.extractor.XSSFImportFromXML$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType;

        static {
            int[] iArr = new int[DataType.values().length];
            $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType = iArr;
            try {
                iArr[DataType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$extractor$XSSFImportFromXML$DataType[DataType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static final class DefaultNamespaceContext implements NamespaceContext {
        private final Element _docElem;

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<?> getPrefixes(String str) {
            return null;
        }

        public DefaultNamespaceContext(Document document) {
            this._docElem = document.getDocumentElement();
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            return getNamespaceForPrefix(str);
        }

        private String getNamespaceForPrefix(String str) {
            if (str.equals("xml")) {
                return XMLConstants.XML_NS_URI;
            }
            Node parentNode = this._docElem;
            while (parentNode != null) {
                short nodeType = parentNode.getNodeType();
                if (nodeType == 1) {
                    if (parentNode.getNodeName().startsWith(str + ":")) {
                        return parentNode.getNamespaceURI();
                    }
                    NamedNodeMap attributes = parentNode.getAttributes();
                    for (int i = 0; i < attributes.getLength(); i++) {
                        Node nodeItem = attributes.item(i);
                        String nodeName = nodeItem.getNodeName();
                        boolean zStartsWith = nodeName.startsWith("xmlns:");
                        if (zStartsWith || nodeName.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
                            if ((zStartsWith ? nodeName.substring(nodeName.indexOf(58) + 1) : "").equals(str)) {
                                return nodeItem.getNodeValue();
                            }
                        }
                    }
                    parentNode = parentNode.getParentNode();
                } else if (nodeType != 5) {
                    return null;
                }
            }
            return null;
        }
    }
}
