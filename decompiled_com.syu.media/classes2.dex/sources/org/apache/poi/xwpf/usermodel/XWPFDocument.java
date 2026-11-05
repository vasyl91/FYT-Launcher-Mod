package org.apache.poi.xwpf.usermodel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.IdentifierManager;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.PackageHelper;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CommentsDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.DocumentDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.NumberingDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFDocument extends POIXMLDocument implements Document, IBody {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XWPFDocument.class);
    protected List<IBodyElement> bodyElements;
    protected List<XWPFComment> comments;
    protected List<XWPFSDT> contentControls;
    private CTDocument1 ctDocument;
    private IdentifierManager drawingIdManager;
    protected Map<Integer, XWPFFootnote> endnotes;
    protected List<XWPFFooter> footers;
    protected XWPFFootnotes footnotes;
    private XWPFHeaderFooterPolicy headerFooterPolicy;
    protected List<XWPFHeader> headers;
    protected List<XWPFHyperlink> hyperlinks;
    protected XWPFNumbering numbering;
    protected Map<Long, List<XWPFPictureData>> packagePictures;
    protected List<XWPFParagraph> paragraphs;
    protected List<XWPFPictureData> pictures;
    private XWPFSettings settings;
    protected XWPFStyles styles;
    protected List<XWPFTable> tables;

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this;
    }

    public XWPFDocument(OPCPackage oPCPackage) throws IOException {
        super(oPCPackage);
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.comments = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.endnotes = new HashMap();
        this.drawingIdManager = new IdentifierManager(0L, 4294967295L);
        load(XWPFFactory.getInstance());
    }

    public XWPFDocument(InputStream inputStream) throws IOException {
        super(PackageHelper.open(inputStream));
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.comments = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.endnotes = new HashMap();
        this.drawingIdManager = new IdentifierManager(0L, 4294967295L);
        load(XWPFFactory.getInstance());
    }

    public XWPFDocument() {
        super(newPackage());
        this.footers = new ArrayList();
        this.headers = new ArrayList();
        this.comments = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.contentControls = new ArrayList();
        this.bodyElements = new ArrayList();
        this.pictures = new ArrayList();
        this.packagePictures = new HashMap();
        this.endnotes = new HashMap();
        this.drawingIdManager = new IdentifierManager(0L, 4294967295L);
        onDocumentCreate();
    }

    protected static OPCPackage newPackage() {
        try {
            OPCPackage oPCPackageCreate = OPCPackage.create(new ByteArrayOutputStream());
            PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(XWPFRelation.DOCUMENT.getDefaultFileName());
            oPCPackageCreate.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
            oPCPackageCreate.createPart(packagePartNameCreatePartName, XWPFRelation.DOCUMENT.getContentType());
            oPCPackageCreate.getPackageProperties().setCreatorProperty(POIXMLDocument.DOCUMENT_CREATOR);
            return oPCPackageCreate;
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            DocumentDocument documentDocument = DocumentDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            this.ctDocument = documentDocument.getDocument();
            initFootnotes();
            XmlCursor xmlCursorNewCursor = this.ctDocument.newCursor();
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTBody) {
                    XmlCursor xmlCursorNewCursor2 = object.newCursor();
                    xmlCursorNewCursor2.selectPath("./*");
                    while (xmlCursorNewCursor2.toNextSelection()) {
                        CTSdtBlock object2 = xmlCursorNewCursor2.getObject();
                        if (object2 instanceof CTP) {
                            XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object2, this);
                            this.bodyElements.add(xWPFParagraph);
                            this.paragraphs.add(xWPFParagraph);
                        } else if (object2 instanceof CTTbl) {
                            XWPFTable xWPFTable = new XWPFTable((CTTbl) object2, this);
                            this.bodyElements.add(xWPFTable);
                            this.tables.add(xWPFTable);
                        } else if (object2 instanceof CTSdtBlock) {
                            XWPFSDT xwpfsdt = new XWPFSDT(object2, this);
                            this.bodyElements.add(xwpfsdt);
                            this.contentControls.add(xwpfsdt);
                        }
                    }
                    xmlCursorNewCursor2.dispose();
                }
            }
            xmlCursorNewCursor.dispose();
            if (documentDocument.getDocument().getBody().getSectPr() != null) {
                this.headerFooterPolicy = new XWPFHeaderFooterPolicy(this);
            }
            for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                String relationshipType = relationPart.getRelationship().getRelationshipType();
                if (relationshipType.equals(XWPFRelation.STYLES.getRelation())) {
                    XWPFStyles xWPFStyles = (XWPFStyles) documentPart;
                    this.styles = xWPFStyles;
                    xWPFStyles.onDocumentRead();
                } else if (relationshipType.equals(XWPFRelation.NUMBERING.getRelation())) {
                    XWPFNumbering xWPFNumbering = (XWPFNumbering) documentPart;
                    this.numbering = xWPFNumbering;
                    xWPFNumbering.onDocumentRead();
                } else if (relationshipType.equals(XWPFRelation.FOOTER.getRelation())) {
                    XWPFFooter xWPFFooter = (XWPFFooter) documentPart;
                    this.footers.add(xWPFFooter);
                    xWPFFooter.onDocumentRead();
                } else if (relationshipType.equals(XWPFRelation.HEADER.getRelation())) {
                    XWPFHeader xWPFHeader = (XWPFHeader) documentPart;
                    this.headers.add(xWPFHeader);
                    xWPFHeader.onDocumentRead();
                } else if (relationshipType.equals(XWPFRelation.COMMENT.getRelation())) {
                    for (CTComment cTComment : CommentsDocument.Factory.parse(documentPart.getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getComments().getCommentArray()) {
                        this.comments.add(new XWPFComment(cTComment, this));
                    }
                } else if (relationshipType.equals(XWPFRelation.SETTINGS.getRelation())) {
                    XWPFSettings xWPFSettings = (XWPFSettings) documentPart;
                    this.settings = xWPFSettings;
                    xWPFSettings.onDocumentRead();
                } else if (relationshipType.equals(XWPFRelation.IMAGES.getRelation())) {
                    XWPFPictureData xWPFPictureData = (XWPFPictureData) documentPart;
                    xWPFPictureData.onDocumentRead();
                    registerPackagePictureData(xWPFPictureData);
                    this.pictures.add(xWPFPictureData);
                } else if (relationshipType.equals(XWPFRelation.GLOSSARY_DOCUMENT.getRelation())) {
                    Iterator<POIXMLDocumentPart> it = documentPart.getRelations().iterator();
                    while (it.hasNext()) {
                        POIXMLDocumentPart._invokeOnDocumentRead(it.next());
                    }
                }
            }
            initHyperlinks();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    private void initHyperlinks() {
        try {
            for (PackageRelationship packageRelationship : getPackagePart().getRelationshipsByType(XWPFRelation.HYPERLINK.getRelation())) {
                this.hyperlinks.add(new XWPFHyperlink(packageRelationship.getId(), packageRelationship.getTargetURI().toString()));
            }
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    private void initFootnotes() throws XmlException, IOException {
        for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
            POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
            String relationshipType = relationPart.getRelationship().getRelationshipType();
            if (relationshipType.equals(XWPFRelation.FOOTNOTE.getRelation())) {
                XWPFFootnotes xWPFFootnotes = (XWPFFootnotes) documentPart;
                this.footnotes = xWPFFootnotes;
                xWPFFootnotes.onDocumentRead();
            } else if (relationshipType.equals(XWPFRelation.ENDNOTE.getRelation())) {
                for (CTFtnEdn cTFtnEdn : EndnotesDocument.Factory.parse(documentPart.getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getEndnotes().getEndnoteArray()) {
                    this.endnotes.put(Integer.valueOf(cTFtnEdn.getId().intValue()), new XWPFFootnote(this, cTFtnEdn));
                }
            }
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentCreate() {
        CTDocument1 cTDocument1NewInstance = CTDocument1.Factory.newInstance();
        this.ctDocument = cTDocument1NewInstance;
        cTDocument1NewInstance.addNewBody();
        this.settings = (XWPFSettings) createRelationship(XWPFRelation.SETTINGS, XWPFFactory.getInstance());
        getProperties().getExtendedProperties().getUnderlyingProperties().setApplication(POIXMLDocument.DOCUMENT_CREATOR);
    }

    @Internal
    public CTDocument1 getDocument() {
        return this.ctDocument;
    }

    IdentifierManager getDrawingIdManager() {
        return this.drawingIdManager;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public Iterator<IBodyElement> getBodyElementsIterator() {
        return this.bodyElements.iterator();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return Collections.unmodifiableList(this.paragraphs);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return Collections.unmodifiableList(this.tables);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i) {
        if (i < 0 || i >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i);
    }

    public List<XWPFFooter> getFooterList() {
        return Collections.unmodifiableList(this.footers);
    }

    public XWPFFooter getFooterArray(int i) {
        if (i < 0 || i >= this.footers.size()) {
            return null;
        }
        return this.footers.get(i);
    }

    public List<XWPFHeader> getHeaderList() {
        return Collections.unmodifiableList(this.headers);
    }

    public XWPFHeader getHeaderArray(int i) {
        if (i < 0 || i >= this.headers.size()) {
            return null;
        }
        return this.headers.get(i);
    }

    public String getTblStyle(XWPFTable xWPFTable) {
        return xWPFTable.getStyleID();
    }

    public XWPFHyperlink getHyperlinkByID(String str) {
        for (XWPFHyperlink xWPFHyperlink : this.hyperlinks) {
            if (xWPFHyperlink.getId().equals(str)) {
                return xWPFHyperlink;
            }
        }
        return null;
    }

    public XWPFFootnote getFootnoteByID(int i) {
        XWPFFootnotes xWPFFootnotes = this.footnotes;
        if (xWPFFootnotes == null) {
            return null;
        }
        return xWPFFootnotes.getFootnoteById(i);
    }

    public XWPFFootnote getEndnoteByID(int i) {
        Map<Integer, XWPFFootnote> map = this.endnotes;
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public List<XWPFFootnote> getFootnotes() {
        XWPFFootnotes xWPFFootnotes = this.footnotes;
        if (xWPFFootnotes == null) {
            return Collections.emptyList();
        }
        return xWPFFootnotes.getFootnotesList();
    }

    public XWPFHyperlink[] getHyperlinks() {
        List<XWPFHyperlink> list = this.hyperlinks;
        return (XWPFHyperlink[]) list.toArray(new XWPFHyperlink[list.size()]);
    }

    public XWPFComment getCommentByID(String str) {
        for (XWPFComment xWPFComment : this.comments) {
            if (xWPFComment.getId().equals(str)) {
                return xWPFComment;
            }
        }
        return null;
    }

    public XWPFComment[] getComments() {
        List<XWPFComment> list = this.comments;
        return (XWPFComment[]) list.toArray(new XWPFComment[list.size()]);
    }

    public PackagePart getPartById(String str) {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(str));
        } catch (InvalidFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public XWPFHeaderFooterPolicy getHeaderFooterPolicy() {
        return this.headerFooterPolicy;
    }

    public XWPFHeaderFooterPolicy createHeaderFooterPolicy() {
        if (this.headerFooterPolicy == null) {
            this.headerFooterPolicy = new XWPFHeaderFooterPolicy(this);
        }
        return this.headerFooterPolicy;
    }

    public XWPFHeader createHeader(HeaderFooterType headerFooterType) {
        XWPFHeaderFooterPolicy xWPFHeaderFooterPolicyCreateHeaderFooterPolicy = createHeaderFooterPolicy();
        if (headerFooterType == HeaderFooterType.FIRST) {
            CTSectPr section = getSection();
            if (!section.isSetTitlePg()) {
                section.addNewTitlePg().setVal(STOnOff.ON);
            }
        }
        return xWPFHeaderFooterPolicyCreateHeaderFooterPolicy.createHeader(STHdrFtr.Enum.forInt(headerFooterType.toInt()));
    }

    public XWPFFooter createFooter(HeaderFooterType headerFooterType) {
        XWPFHeaderFooterPolicy xWPFHeaderFooterPolicyCreateHeaderFooterPolicy = createHeaderFooterPolicy();
        if (headerFooterType == HeaderFooterType.FIRST) {
            CTSectPr section = getSection();
            if (!section.isSetTitlePg()) {
                section.addNewTitlePg().setVal(STOnOff.ON);
            }
        }
        return xWPFHeaderFooterPolicyCreateHeaderFooterPolicy.createFooter(STHdrFtr.Enum.forInt(headerFooterType.toInt()));
    }

    private CTSectPr getSection() {
        CTBody body = getDocument().getBody();
        return body.isSetSectPr() ? body.getSectPr() : body.addNewSectPr();
    }

    @Internal
    public CTStyles getStyle() throws XmlException, IOException {
        try {
            PackagePart[] relatedByType = getRelatedByType(XWPFRelation.STYLES.getRelation());
            if (relatedByType.length != 1) {
                throw new IllegalStateException("Expecting one Styles document part, but found " + relatedByType.length);
            }
            return StylesDocument.Factory.parse(relatedByType[0].getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getStyles();
        } catch (InvalidFormatException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
        LinkedList linkedList = new LinkedList();
        PackagePart packagePart = getPackagePart();
        Iterator<PackageRelationship> it = getPackagePart().getRelationshipsByType(POIXMLDocument.OLE_OBJECT_REL_TYPE).iterator();
        while (it.hasNext()) {
            linkedList.add(packagePart.getRelatedPart(it.next()));
        }
        Iterator<PackageRelationship> it2 = getPackagePart().getRelationshipsByType(POIXMLDocument.PACK_OBJECT_REL_TYPE).iterator();
        while (it2.hasNext()) {
            linkedList.add(packagePart.getRelatedPart(it2.next()));
        }
        return linkedList;
    }

    private int getBodyElementSpecificPos(int i, List<? extends IBodyElement> list) {
        if (list.size() != 0 && i >= 0 && i < this.bodyElements.size()) {
            IBodyElement iBodyElement = this.bodyElements.get(i);
            if (iBodyElement.getElementType() != list.get(0).getElementType()) {
                return -1;
            }
            for (int iMin = Math.min(i, list.size() - 1); iMin >= 0; iMin--) {
                if (list.get(iMin) == iBodyElement) {
                    return iMin;
                }
            }
        }
        return -1;
    }

    public int getParagraphPos(int i) {
        return getBodyElementSpecificPos(i, this.paragraphs);
    }

    public int getTablePos(int i) {
        return getBodyElementSpecificPos(i, this.tables);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject object = null;
        if (!isCursorInBody(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("p", CTP.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTP ctp2 = (CTP) xmlCursor.getObject();
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp2, this);
        while (true) {
            z = object instanceof CTP;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i = 0;
        if (!z || (ctp = (CTP) object) == ctp2) {
            this.paragraphs.add(0, xWPFParagraph);
        } else {
            this.paragraphs.add(this.paragraphs.indexOf(getParagraph(ctp)) + 1, xWPFParagraph);
        }
        XmlCursor xmlCursorNewCursor = ctp2.newCursor();
        try {
            xmlCursor.toCursor(xmlCursorNewCursor);
            while (xmlCursor.toPrevSibling()) {
                XmlObject object2 = xmlCursor.getObject();
                if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                    i++;
                }
            }
            this.bodyElements.add(i, xWPFParagraph);
            xmlCursor.toCursor(xmlCursorNewCursor);
            xmlCursor.toEndToken();
            return xWPFParagraph;
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z;
        XmlObject object = null;
        if (!isCursorInBody(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("tbl", CTTbl.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTTbl object2 = xmlCursor.getObject();
        XWPFTable xWPFTable = new XWPFTable(object2, this);
        while (true) {
            z = object instanceof CTTbl;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i = 0;
        if (!z) {
            this.tables.add(0, xWPFTable);
        } else {
            this.tables.add(this.tables.indexOf(getTable((CTTbl) object)) + 1, xWPFTable);
        }
        XmlCursor xmlCursorNewCursor = object2.newCursor();
        try {
            xmlCursor.toCursor(xmlCursorNewCursor);
            while (xmlCursor.toPrevSibling()) {
                XmlObject object3 = xmlCursor.getObject();
                if ((object3 instanceof CTP) || (object3 instanceof CTTbl)) {
                    i++;
                }
            }
            this.bodyElements.add(i, xWPFTable);
            xmlCursor.toCursor(xmlCursorNewCursor);
            xmlCursor.toEndToken();
            return xWPFTable;
        } finally {
            xmlCursorNewCursor.dispose();
        }
    }

    private boolean isCursorInBody(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        xmlCursorNewCursor.toParent();
        boolean z = xmlCursorNewCursor.getObject() == this.ctDocument.getBody();
        xmlCursorNewCursor.dispose();
        return z;
    }

    private int getPosOfBodyElement(IBodyElement iBodyElement) {
        BodyElementType elementType = iBodyElement.getElementType();
        for (int i = 0; i < this.bodyElements.size(); i++) {
            IBodyElement iBodyElement2 = this.bodyElements.get(i);
            if (iBodyElement2.getElementType() == elementType && iBodyElement2.equals(iBodyElement)) {
                return i;
            }
        }
        return -1;
    }

    public int getPosOfParagraph(XWPFParagraph xWPFParagraph) {
        return getPosOfBodyElement(xWPFParagraph);
    }

    public int getPosOfTable(XWPFTable xWPFTable) {
        return getPosOfBodyElement(xWPFTable);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTDocument1.type.getName().getNamespaceURI(), "document"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctDocument.save(outputStream, xmlOptions);
        outputStream.close();
    }

    private int getRelationIndex(XWPFRelation xWPFRelation) {
        Iterator<POIXMLDocumentPart.RelationPart> it = getRelationParts().iterator();
        int i = 1;
        while (it.hasNext()) {
            if (it.next().getRelationship().getRelationshipType().equals(xWPFRelation.getRelation())) {
                i++;
            }
        }
        return i;
    }

    public XWPFParagraph createParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctDocument.getBody().addNewP(), this);
        this.bodyElements.add(xWPFParagraph);
        this.paragraphs.add(xWPFParagraph);
        return xWPFParagraph;
    }

    public XWPFNumbering createNumbering() {
        if (this.numbering == null) {
            NumberingDocument numberingDocumentNewInstance = NumberingDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.NUMBERING;
            XWPFNumbering xWPFNumbering = (XWPFNumbering) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFNumbering.setNumbering(numberingDocumentNewInstance.addNewNumbering());
            this.numbering = xWPFNumbering;
        }
        return this.numbering;
    }

    public XWPFStyles createStyles() {
        if (this.styles == null) {
            StylesDocument stylesDocumentNewInstance = StylesDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.STYLES;
            XWPFStyles xWPFStyles = (XWPFStyles) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFStyles.setStyles(stylesDocumentNewInstance.addNewStyles());
            this.styles = xWPFStyles;
        }
        return this.styles;
    }

    public XWPFFootnotes createFootnotes() {
        if (this.footnotes == null) {
            FootnotesDocument footnotesDocumentNewInstance = FootnotesDocument.Factory.newInstance();
            XWPFRelation xWPFRelation = XWPFRelation.FOOTNOTE;
            XWPFFootnotes xWPFFootnotes = (XWPFFootnotes) createRelationship(xWPFRelation, XWPFFactory.getInstance(), getRelationIndex(xWPFRelation));
            xWPFFootnotes.setFootnotes(footnotesDocumentNewInstance.addNewFootnotes());
            this.footnotes = xWPFFootnotes;
        }
        return this.footnotes;
    }

    public XWPFFootnote addFootnote(CTFtnEdn cTFtnEdn) {
        return this.footnotes.addFootnote(cTFtnEdn);
    }

    public XWPFFootnote addEndnote(CTFtnEdn cTFtnEdn) {
        XWPFFootnote xWPFFootnote = new XWPFFootnote(this, cTFtnEdn);
        this.endnotes.put(Integer.valueOf(cTFtnEdn.getId().intValue()), xWPFFootnote);
        return xWPFFootnote;
    }

    public boolean removeBodyElement(int i) {
        if (i < 0 || i >= this.bodyElements.size()) {
            return false;
        }
        BodyElementType elementType = this.bodyElements.get(i).getElementType();
        if (elementType == BodyElementType.TABLE) {
            int tablePos = getTablePos(i);
            this.tables.remove(tablePos);
            this.ctDocument.getBody().removeTbl(tablePos);
        }
        if (elementType == BodyElementType.PARAGRAPH) {
            int paragraphPos = getParagraphPos(i);
            this.paragraphs.remove(paragraphPos);
            this.ctDocument.getBody().removeP(paragraphPos);
        }
        this.bodyElements.remove(i);
        return true;
    }

    public void setParagraph(XWPFParagraph xWPFParagraph, int i) {
        this.paragraphs.set(i, xWPFParagraph);
        this.ctDocument.getBody().setPArray(i, xWPFParagraph.getCTP());
    }

    public XWPFParagraph getLastParagraph() {
        return this.paragraphs.get(this.paragraphs.toArray().length - 1);
    }

    public XWPFTable createTable() {
        XWPFTable xWPFTable = new XWPFTable(this.ctDocument.getBody().addNewTbl(), this);
        this.bodyElements.add(xWPFTable);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public XWPFTable createTable(int i, int i2) {
        XWPFTable xWPFTable = new XWPFTable(this.ctDocument.getBody().addNewTbl(), this, i, i2);
        this.bodyElements.add(xWPFTable);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public void createTOC() {
        TOC toc = new TOC(getDocument().getBody().addNewSdt());
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            String style = xWPFParagraph.getStyle();
            if (style != null && style.startsWith("Heading")) {
                try {
                    toc.addRow(Integer.parseInt(style.substring(7)), xWPFParagraph.getText(), 1, "112723803");
                } catch (NumberFormatException e) {
                    LOG.log(7, "can't format number in TOC heading", e);
                }
            }
        }
    }

    public void setTable(int i, XWPFTable xWPFTable) {
        this.tables.set(i, xWPFTable);
        this.ctDocument.getBody().setTblArray(i, xWPFTable.getCTTbl());
    }

    public boolean isEnforcedProtection() {
        return this.settings.isEnforcedWith();
    }

    public boolean isEnforcedReadonlyProtection() {
        return this.settings.isEnforcedWith(STDocProtect.READ_ONLY);
    }

    public boolean isEnforcedFillingFormsProtection() {
        return this.settings.isEnforcedWith(STDocProtect.FORMS);
    }

    public boolean isEnforcedCommentsProtection() {
        return this.settings.isEnforcedWith(STDocProtect.COMMENTS);
    }

    public boolean isEnforcedTrackedChangesProtection() {
        return this.settings.isEnforcedWith(STDocProtect.TRACKED_CHANGES);
    }

    public boolean isEnforcedUpdateFields() {
        return this.settings.isUpdateFields();
    }

    public void enforceReadonlyProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.READ_ONLY);
    }

    public void enforceReadonlyProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.READ_ONLY, str, hashAlgorithm);
    }

    public void enforceFillingFormsProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.FORMS);
    }

    public void enforceFillingFormsProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.FORMS, str, hashAlgorithm);
    }

    public void enforceCommentsProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.COMMENTS);
    }

    public void enforceCommentsProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.COMMENTS, str, hashAlgorithm);
    }

    public void enforceTrackedChangesProtection() {
        this.settings.setEnforcementEditValue(STDocProtect.TRACKED_CHANGES);
    }

    public void enforceTrackedChangesProtection(String str, HashAlgorithm hashAlgorithm) {
        this.settings.setEnforcementEditValue(STDocProtect.TRACKED_CHANGES, str, hashAlgorithm);
    }

    public boolean validateProtectionPassword(String str) {
        return this.settings.validateProtectionPassword(str);
    }

    public void removeProtectionEnforcement() {
        this.settings.removeEnforcement();
    }

    public void enforceUpdateFields() {
        this.settings.setUpdateFields();
    }

    public boolean isTrackRevisions() {
        return this.settings.isTrackRevisions();
    }

    public void setTrackRevisions(boolean z) {
        this.settings.setTrackRevisions(z);
    }

    public long getZoomPercent() {
        return this.settings.getZoomPercent();
    }

    public void setZoomPercent(long j) {
        this.settings.setZoomPercent(j);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i, XWPFTable xWPFTable) {
        this.bodyElements.add(i, xWPFTable);
        CTTbl[] tblArray = this.ctDocument.getBody().getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length && tblArray[i3] != xWPFTable.getCTTbl(); i3++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
    }

    public List<XWPFPictureData> getAllPictures() {
        return Collections.unmodifiableList(this.pictures);
    }

    public List<XWPFPictureData> getAllPackagePictures() {
        ArrayList arrayList = new ArrayList();
        Iterator<List<XWPFPictureData>> it = this.packagePictures.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    void registerPackagePictureData(XWPFPictureData xWPFPictureData) {
        List<XWPFPictureData> arrayList = this.packagePictures.get(xWPFPictureData.getChecksum());
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            this.packagePictures.put(xWPFPictureData.getChecksum(), arrayList);
        }
        if (arrayList.contains(xWPFPictureData)) {
            return;
        }
        arrayList.add(xWPFPictureData);
    }

    XWPFPictureData findPackagePictureData(byte[] bArr, int i) {
        List<XWPFPictureData> list = this.packagePictures.get(Long.valueOf(IOUtils.calculateChecksum(bArr)));
        XWPFPictureData xWPFPictureData = null;
        if (list != null) {
            Iterator<XWPFPictureData> it = list.iterator();
            while (it.hasNext() && xWPFPictureData == null) {
                XWPFPictureData next = it.next();
                if (Arrays.equals(bArr, next.getData())) {
                    xWPFPictureData = next;
                }
            }
        }
        return xWPFPictureData;
    }

    public String addPictureData(byte[] bArr, int i) throws InvalidFormatException {
        XWPFPictureData xWPFPictureDataFindPackagePictureData = findPackagePictureData(bArr, i);
        POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[i];
        OutputStream outputStream = null;
        if (xWPFPictureDataFindPackagePictureData == null) {
            XWPFPictureData xWPFPictureData = (XWPFPictureData) createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), getNextPicNameNumber(i));
            try {
                try {
                    outputStream = xWPFPictureData.getPackagePart().getOutputStream();
                    outputStream.write(bArr);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    registerPackagePictureData(xWPFPictureData);
                    this.pictures.add(xWPFPictureData);
                    return getRelationId(xWPFPictureData);
                } catch (IOException e) {
                    throw new POIXMLException(e);
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
        if (!getRelations().contains(xWPFPictureDataFindPackagePictureData)) {
            return addRelation(null, XWPFRelation.IMAGES, xWPFPictureDataFindPackagePictureData).getRelationship().getId();
        }
        return getRelationId(xWPFPictureDataFindPackagePictureData);
    }

    public String addPictureData(InputStream inputStream, int i) throws InvalidFormatException {
        try {
            return addPictureData(IOUtils.toByteArray(inputStream), i);
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public int getNextPicNameNumber(int i) throws InvalidFormatException {
        int size = getAllPackagePictures().size() + 1;
        PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName(XWPFPictureData.RELATIONS[i].getFileName(size));
        while (getPackage().getPart(packagePartNameCreatePartName) != null) {
            size++;
            packagePartNameCreatePartName = PackagingURIHelper.createPartName(XWPFPictureData.RELATIONS[i].getFileName(size));
        }
        return size;
    }

    public XWPFPictureData getPictureDataByID(String str) {
        POIXMLDocumentPart relationById = getRelationById(str);
        if (relationById instanceof XWPFPictureData) {
            return (XWPFPictureData) relationById;
        }
        return null;
    }

    public XWPFNumbering getNumbering() {
        return this.numbering;
    }

    public XWPFStyles getStyles() {
        return this.styles;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (int i = 0; i < getParagraphs().size(); i++) {
            if (getParagraphs().get(i).getCTP() == ctp) {
                return getParagraphs().get(i);
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        for (int i = 0; i < this.tables.size(); i++) {
            if (getTables().get(i).getCTTbl() == cTTbl) {
                return getTables().get(i);
            }
        }
        return null;
    }

    public Iterator<XWPFTable> getTablesIterator() {
        return this.tables.iterator();
    }

    public Iterator<XWPFParagraph> getParagraphsIterator() {
        return this.paragraphs.iterator();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i) {
        if (i < 0 || i >= this.paragraphs.size()) {
            return null;
        }
        return this.paragraphs.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.DOCUMENT;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XWPFTableRow row;
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
        xmlCursorNewCursor.toParent();
        XmlObject object = xmlCursorNewCursor.getObject();
        if (!(object instanceof CTRow)) {
            return null;
        }
        CTRow cTRow = (CTRow) object;
        xmlCursorNewCursor.toParent();
        XmlObject object2 = xmlCursorNewCursor.getObject();
        xmlCursorNewCursor.dispose();
        if (!(object2 instanceof CTTbl) || (table = getTable((CTTbl) object2)) == null || (row = table.getRow(cTRow)) == null) {
            return null;
        }
        return row.getTableCell(cTTc);
    }
}
