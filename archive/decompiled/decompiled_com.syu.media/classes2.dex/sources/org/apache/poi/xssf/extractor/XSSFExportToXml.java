package org.apache.poi.xssf.extractor;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.SchemaFactory;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.poi.xssf.usermodel.helpers.XSSFXmlColumnPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFExportToXml implements Comparator<String> {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XSSFExportToXml.class);
    private XSSFMap map;

    public XSSFExportToXml(XSSFMap xSSFMap) {
        this.map = xSSFMap;
    }

    public void exportToXML(OutputStream outputStream, boolean z) throws TransformerException, SAXException {
        exportToXML(outputStream, "UTF-8", z);
    }

    public void exportToXML(OutputStream outputStream, String str, boolean z) throws TransformerException, SAXException {
        Element elementCreateElementNS;
        HashMap map;
        boolean z2;
        XSSFCell referencedCell;
        List<XSSFSingleXmlCell> relatedSingleXMLCell = this.map.getRelatedSingleXMLCell();
        List<XSSFTable> relatedTables = this.map.getRelatedTables();
        String rootElement = this.map.getCtMap().getRootElement();
        Document documentCreateDocument = DocumentHelper.createDocument();
        if (isNamespaceDeclared()) {
            elementCreateElementNS = documentCreateDocument.createElementNS(getNamespace(), rootElement);
        } else {
            elementCreateElementNS = documentCreateDocument.createElementNS("", rootElement);
        }
        documentCreateDocument.appendChild(elementCreateElementNS);
        Vector vector = new Vector();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (XSSFSingleXmlCell xSSFSingleXmlCell : relatedSingleXMLCell) {
            vector.add(xSSFSingleXmlCell.getXpath());
            map2.put(xSSFSingleXmlCell.getXpath(), xSSFSingleXmlCell);
        }
        for (XSSFTable xSSFTable : relatedTables) {
            String commonXpath = xSSFTable.getCommonXpath();
            vector.add(commonXpath);
            map3.put(commonXpath, xSSFTable);
        }
        Collections.sort(vector, this);
        Iterator it = vector.iterator();
        while (true) {
            boolean z3 = true;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            XSSFSingleXmlCell xSSFSingleXmlCell2 = (XSSFSingleXmlCell) map2.get(str2);
            XSSFTable xSSFTable2 = (XSSFTable) map3.get(str2);
            if (!str2.matches(".*\\[.*")) {
                if (xSSFSingleXmlCell2 != null && (referencedCell = xSSFSingleXmlCell2.getReferencedCell()) != null) {
                    Node nodeByXPath = getNodeByXPath(str2, documentCreateDocument.getFirstChild(), documentCreateDocument, false);
                    mapCellOnNode(referencedCell, nodeByXPath);
                    if ("".equals(nodeByXPath.getTextContent()) && nodeByXPath.getParentNode() != null) {
                        nodeByXPath.getParentNode().removeChild(nodeByXPath);
                    }
                }
                if (xSSFTable2 != null) {
                    List tableColumnList = xSSFTable2.getCTTable().getTableColumns().getTableColumnList();
                    XSSFSheet xSSFSheet = xSSFTable2.getXSSFSheet();
                    int row = xSSFTable2.getStartCellReference().getRow() + 1;
                    int row2 = xSSFTable2.getEndCellReference().getRow();
                    while (row <= row2) {
                        XSSFRow row3 = xSSFSheet.getRow(row);
                        Node nodeByXPath2 = getNodeByXPath(xSSFTable2.getCommonXpath(), documentCreateDocument.getFirstChild(), documentCreateDocument, z3);
                        short col = xSSFTable2.getStartCellReference().getCol();
                        int i = col;
                        while (i <= xSSFTable2.getEndCellReference().getCol()) {
                            XSSFCell cell = row3.getCell(i);
                            Iterator it2 = it;
                            if (cell != null) {
                                int i2 = i - col;
                                map = map2;
                                if (i2 < tableColumnList.size()) {
                                    CTTableColumn cTTableColumn = (CTTableColumn) tableColumnList.get(i2);
                                    if (cTTableColumn.getXmlColumnPr() != null) {
                                        tableColumnList = tableColumnList;
                                        z2 = false;
                                        mapCellOnNode(cell, getNodeByXPath(new XSSFXmlColumnPr(xSSFTable2, cTTableColumn, cTTableColumn.getXmlColumnPr()).getLocalXPath(), nodeByXPath2, documentCreateDocument, false));
                                    }
                                    i++;
                                    it = it2;
                                    map2 = map;
                                    tableColumnList = tableColumnList;
                                }
                            } else {
                                map = map2;
                            }
                            z2 = false;
                            i++;
                            it = it2;
                            map2 = map;
                            tableColumnList = tableColumnList;
                        }
                        row++;
                        tableColumnList = tableColumnList;
                        z3 = true;
                    }
                }
            }
            it = it;
            map2 = map2;
        }
        if (z ? isValid(documentCreateDocument) : true) {
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", "yes");
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("encoding", str);
            transformerNewTransformer.transform(new DOMSource(documentCreateDocument), new StreamResult(outputStream));
        }
    }

    private boolean isValid(Document document) throws SAXException {
        try {
            SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(new DOMSource(this.map.getSchema())).newValidator().validate(new DOMSource(document));
            return true;
        } catch (IOException e) {
            LOG.log(7, "document is not valid", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: org.apache.poi.xssf.extractor.XSSFExportToXml$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void mapCellOnNode(XSSFCell xSSFCell, Node node) {
        String stringCellValue;
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[xSSFCell.getCellTypeEnum().ordinal()];
        if (i != 1) {
            stringCellValue = "";
            if (i == 2) {
                stringCellValue = "" + xSSFCell.getBooleanCellValue();
            } else if (i == 3) {
                stringCellValue = xSSFCell.getErrorCellString();
            } else if (i != 4) {
                if (i == 5) {
                    if (DateUtil.isCellDateFormatted(xSSFCell)) {
                        stringCellValue = getFormattedDate(xSSFCell);
                    } else {
                        stringCellValue = "" + xSSFCell.getRawValue();
                    }
                }
            } else if (xSSFCell.getCachedFormulaResultTypeEnum() == CellType.STRING) {
                stringCellValue = xSSFCell.getStringCellValue();
            } else if (DateUtil.isCellDateFormatted(xSSFCell)) {
                stringCellValue = getFormattedDate(xSSFCell);
            } else {
                stringCellValue = "" + xSSFCell.getNumericCellValue();
            }
        } else {
            stringCellValue = xSSFCell.getStringCellValue();
        }
        if (node instanceof Element) {
            ((Element) node).setTextContent(stringCellValue);
        } else {
            node.setNodeValue(stringCellValue);
        }
    }

    private String removeNamespace(String str) {
        return str.matches(".*:.*") ? str.split(":")[1] : str;
    }

    private String getFormattedDate(XSSFCell xSSFCell) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
        return simpleDateFormat.format(xSSFCell.getDateCellValue());
    }

    private Node getNodeByXPath(String str, Node node, Document document, boolean z) {
        String[] strArrSplit = str.split("/");
        int i = 2;
        while (i < strArrSplit.length) {
            String strRemoveNamespace = removeNamespace(strArrSplit[i]);
            if (!strRemoveNamespace.startsWith("@")) {
                Node nodeSelectNode = (z && i == strArrSplit.length + (-1)) ? null : selectNode(strRemoveNamespace, node.getChildNodes());
                if (nodeSelectNode == null) {
                    nodeSelectNode = createElement(document, node, strRemoveNamespace);
                }
                node = nodeSelectNode;
            } else {
                node = createAttribute(document, node, strRemoveNamespace);
            }
            i++;
        }
        return node;
    }

    private Node createAttribute(Document document, Node node, String str) {
        String strSubstring = str.substring(1);
        NamedNodeMap attributes = node.getAttributes();
        Node namedItem = attributes.getNamedItem(strSubstring);
        if (namedItem != null) {
            return namedItem;
        }
        Attr attrCreateAttributeNS = document.createAttributeNS("", strSubstring);
        attributes.setNamedItem(attrCreateAttributeNS);
        return attrCreateAttributeNS;
    }

    private Node createElement(Document document, Node node, String str) {
        Element elementCreateElementNS;
        if (isNamespaceDeclared()) {
            elementCreateElementNS = document.createElementNS(getNamespace(), str);
        } else {
            elementCreateElementNS = document.createElementNS("", str);
        }
        node.appendChild(elementCreateElementNS);
        return elementCreateElementNS;
    }

    private Node selectNode(String str, NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeItem = nodeList.item(i);
            if (nodeItem.getNodeName().equals(str)) {
                return nodeItem;
            }
        }
        return null;
    }

    private boolean isNamespaceDeclared() {
        String namespace = getNamespace();
        return (namespace == null || namespace.equals("")) ? false : true;
    }

    private String getNamespace() {
        return this.map.getCTSchema().getNamespace();
    }

    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        Node schema = this.map.getSchema();
        String[] strArrSplit = str.split("/");
        String[] strArrSplit2 = str2.split("/");
        int length = strArrSplit.length < strArrSplit2.length ? strArrSplit.length : strArrSplit2.length;
        Node complexTypeForElement = schema;
        for (int i = 1; i < length; i++) {
            String str3 = strArrSplit[i];
            String str4 = strArrSplit2[i];
            if (str3.equals(str4)) {
                complexTypeForElement = getComplexTypeForElement(str3, schema, complexTypeForElement);
            } else {
                int iIndexOfElementInComplexType = indexOfElementInComplexType(str3, complexTypeForElement);
                int iIndexOfElementInComplexType2 = indexOfElementInComplexType(str4, complexTypeForElement);
                if (iIndexOfElementInComplexType != -1 && iIndexOfElementInComplexType2 != -1) {
                    if (iIndexOfElementInComplexType < iIndexOfElementInComplexType2) {
                        return -1;
                    }
                    if (iIndexOfElementInComplexType > iIndexOfElementInComplexType2) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private int indexOfElementInComplexType(String str, Node node) {
        if (node == null) {
            return -1;
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if ((nodeItem instanceof Element) && nodeItem.getLocalName().equals("element") && getNameOrRefElement(nodeItem).getNodeValue().equals(removeNamespace(str))) {
                return i;
            }
        }
        return -1;
    }

    private Node getNameOrRefElement(Node node) {
        Node namedItem = node.getAttributes().getNamedItem("name");
        return namedItem != null ? namedItem : node.getAttributes().getNamedItem("ref");
    }

    private Node getComplexTypeForElement(String str, Node node, Node node2) {
        String complexTypeNameFromChildren = getComplexTypeNameFromChildren(node2, removeNamespace(str));
        if ("".equals(complexTypeNameFromChildren)) {
            return null;
        }
        return getComplexTypeNodeFromSchemaChildren(node, null, complexTypeNameFromChildren);
    }

    private String getComplexTypeNameFromChildren(Node node, String str) {
        Node namedItem;
        if (node == null) {
            return "";
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if ((nodeItem instanceof Element) && nodeItem.getLocalName().equals("element") && getNameOrRefElement(nodeItem).getNodeValue().equals(str) && (namedItem = nodeItem.getAttributes().getNamedItem("type")) != null) {
                return namedItem.getNodeValue();
            }
        }
        return "";
    }

    private Node getComplexTypeNodeFromSchemaChildren(Node node, Node node2, String str) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if ((nodeItem instanceof Element) && nodeItem.getLocalName().equals("complexType") && getNameOrRefElement(nodeItem).getNodeValue().equals(str)) {
                NodeList childNodes2 = nodeItem.getChildNodes();
                for (int i2 = 0; i2 < childNodes2.getLength(); i2++) {
                    Node nodeItem2 = childNodes2.item(i2);
                    if ((nodeItem2 instanceof Element) && (nodeItem2.getLocalName().equals("sequence") || nodeItem2.getLocalName().equals("all"))) {
                        node2 = nodeItem2;
                        break;
                    }
                }
                if (node2 != null) {
                    break;
                }
            }
        }
        return node2;
    }
}
