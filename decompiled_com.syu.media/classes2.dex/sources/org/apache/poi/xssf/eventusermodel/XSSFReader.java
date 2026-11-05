package org.apache.poi.xssf.eventusermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSSFReader {
    protected OPCPackage pkg;
    protected PackagePart workbookPart;
    private static final Set<String> WORKSHEET_RELS = Collections.unmodifiableSet(new HashSet(Arrays.asList(XSSFRelation.WORKSHEET.getRelation(), XSSFRelation.CHARTSHEET.getRelation())));
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) XSSFReader.class);

    public XSSFReader(OPCPackage oPCPackage) throws OpenXML4JException, IOException {
        this.pkg = oPCPackage;
        PackageRelationship relationship = oPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument").getRelationship(0);
        if (relationship == null) {
            if (this.pkg.getRelationshipsByType(PackageRelationshipTypes.STRICT_CORE_DOCUMENT).getRelationship(0) != null) {
                throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
            }
            throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
        }
        this.workbookPart = this.pkg.getPart(relationship);
    }

    public SharedStringsTable getSharedStringsTable() throws InvalidFormatException, IOException {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFRelation.SHARED_STRINGS.getContentType());
        if (partsByContentType.size() == 0) {
            return null;
        }
        return new SharedStringsTable(partsByContentType.get(0));
    }

    public StylesTable getStylesTable() throws InvalidFormatException, IOException {
        ArrayList<PackagePart> partsByContentType = this.pkg.getPartsByContentType(XSSFRelation.STYLES.getContentType());
        if (partsByContentType.size() == 0) {
            return null;
        }
        StylesTable stylesTable = new StylesTable(partsByContentType.get(0));
        ArrayList<PackagePart> partsByContentType2 = this.pkg.getPartsByContentType(XSSFRelation.THEME.getContentType());
        if (partsByContentType2.size() != 0) {
            stylesTable.setTheme(new ThemesTable(partsByContentType2.get(0)));
        }
        return stylesTable;
    }

    public InputStream getSharedStringsData() throws InvalidFormatException, IOException {
        return XSSFRelation.SHARED_STRINGS.getContents(this.workbookPart);
    }

    public InputStream getStylesData() throws InvalidFormatException, IOException {
        return XSSFRelation.STYLES.getContents(this.workbookPart);
    }

    public InputStream getThemesData() throws InvalidFormatException, IOException {
        return XSSFRelation.THEME.getContents(this.workbookPart);
    }

    public InputStream getWorkbookData() throws InvalidFormatException, IOException {
        return this.workbookPart.getInputStream();
    }

    public InputStream getSheet(String str) throws InvalidFormatException, IOException {
        PackageRelationship relationship = this.workbookPart.getRelationship(str);
        if (relationship == null) {
            throw new IllegalArgumentException("No Sheet found with r:id " + str);
        }
        PackagePart part = this.pkg.getPart(PackagingURIHelper.createPartName(relationship.getTargetURI()));
        if (part == null) {
            throw new IllegalArgumentException("No data found for Sheet with r:id " + str);
        }
        return part.getInputStream();
    }

    public Iterator<InputStream> getSheetsData() throws InvalidFormatException, IOException {
        return new SheetIterator(this.workbookPart);
    }

    public static class SheetIterator implements Iterator<InputStream> {
        final Iterator<XSSFSheetRef> sheetIterator;
        private final Map<String, PackagePart> sheetMap;
        XSSFSheetRef xssfSheetRef;

        SheetIterator(PackagePart packagePart) throws IOException {
            try {
                this.sheetMap = new HashMap();
                OPCPackage oPCPackage = packagePart.getPackage();
                Set<String> sheetRelationships = getSheetRelationships();
                for (PackageRelationship packageRelationship : packagePart.getRelationships()) {
                    if (sheetRelationships.contains(packageRelationship.getRelationshipType())) {
                        this.sheetMap.put(packageRelationship.getId(), oPCPackage.getPart(PackagingURIHelper.createPartName(packageRelationship.getTargetURI())));
                    }
                }
                this.sheetIterator = createSheetIteratorFromWB(packagePart);
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }

        Iterator<XSSFSheetRef> createSheetIteratorFromWB(PackagePart packagePart) throws IOException {
            XMLSheetRefReader xMLSheetRefReader = new XMLSheetRefReader();
            try {
                XMLReader xMLReaderNewXMLReader = SAXHelper.newXMLReader();
                xMLReaderNewXMLReader.setContentHandler(xMLSheetRefReader);
                try {
                    xMLReaderNewXMLReader.parse(new InputSource(packagePart.getInputStream()));
                    ArrayList arrayList = new ArrayList();
                    for (XSSFSheetRef xSSFSheetRef : xMLSheetRefReader.getSheetRefs()) {
                        String id = xSSFSheetRef.getId();
                        if (id != null && id.length() > 0) {
                            arrayList.add(xSSFSheetRef);
                        }
                    }
                    return arrayList.iterator();
                } catch (SAXException e) {
                    throw new POIXMLException(e);
                }
            } catch (ParserConfigurationException e2) {
                throw new POIXMLException(e2);
            } catch (SAXException e3) {
                throw new POIXMLException(e3);
            }
        }

        Set<String> getSheetRelationships() {
            return XSSFReader.WORKSHEET_RELS;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.sheetIterator.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public InputStream next() {
            XSSFSheetRef next = this.sheetIterator.next();
            this.xssfSheetRef = next;
            try {
                return this.sheetMap.get(next.getId()).getInputStream();
            } catch (IOException e) {
                throw new POIXMLException(e);
            }
        }

        public String getSheetName() {
            return this.xssfSheetRef.getName();
        }

        public CommentsTable getSheetComments() {
            PackagePart sheetPart = getSheetPart();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.SHEET_COMMENTS.getRelation());
                if (relationshipsByType.size() > 0) {
                    return new CommentsTable(sheetPart.getPackage().getPart(PackagingURIHelper.createPartName(relationshipsByType.getRelationship(0).getTargetURI())));
                }
            } catch (IOException | InvalidFormatException unused) {
            }
            return null;
        }

        public List<XSSFShape> getShapes() {
            PackagePart sheetPart = getSheetPart();
            LinkedList linkedList = new LinkedList();
            try {
                PackageRelationshipCollection relationshipsByType = sheetPart.getRelationshipsByType(XSSFRelation.DRAWINGS.getRelation());
                for (int i = 0; i < relationshipsByType.size(); i++) {
                    PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(relationshipsByType.getRelationship(i).getTargetURI());
                    PackagePart part = sheetPart.getPackage().getPart(packagePartNameCreatePartName);
                    if (part == null) {
                        XSSFReader.LOGGER.log(5, "Missing drawing: " + packagePartNameCreatePartName + ". Skipping it.");
                    } else {
                        linkedList.addAll(new XSSFDrawing(part).getShapes());
                    }
                }
                return linkedList;
            } catch (IOException | InvalidFormatException | XmlException unused) {
                return null;
            }
        }

        public PackagePart getSheetPart() {
            return this.sheetMap.get(this.xssfSheetRef.getId());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException("Not supported");
        }
    }

    protected static final class XSSFSheetRef {
        private final String id;
        private final String name;

        public XSSFSheetRef(String str, String str2) {
            this.id = str;
            this.name = str2;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    private static class XMLSheetRefReader extends DefaultHandler {
        private static final String ID = "id";
        private static final String NAME = "name";
        private static final String SHEET = "sheet";
        private final List<XSSFSheetRef> sheetRefs;

        private XMLSheetRefReader() {
            this.sheetRefs = new LinkedList();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str2.equalsIgnoreCase(SHEET)) {
                String value = null;
                String value2 = null;
                for (int i = 0; i < attributes.getLength(); i++) {
                    String localName = attributes.getLocalName(i);
                    if (localName.equalsIgnoreCase(NAME)) {
                        value = attributes.getValue(i);
                    } else if (localName.equalsIgnoreCase(ID)) {
                        value2 = attributes.getValue(i);
                    }
                    if (value != null && value2 != null) {
                        this.sheetRefs.add(new XSSFSheetRef(value2, value));
                        return;
                    }
                }
            }
        }

        List<XSSFSheetRef> getSheetRefs() {
            return Collections.unmodifiableList(this.sheetRefs);
        }
    }
}
