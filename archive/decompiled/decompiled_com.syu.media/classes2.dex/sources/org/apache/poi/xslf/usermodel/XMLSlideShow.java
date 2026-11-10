package org.apache.poi.xslf.usermodel;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.Resources;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.PackageHelper;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XMLSlideShow extends POIXMLDocument implements SlideShow<XSLFShape, XSLFTextParagraph> {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XMLSlideShow.class);
    private XSLFCommentAuthors _commentAuthors;
    private List<XSLFSlideMaster> _masters;
    private XSLFNotesMaster _notesMaster;
    private List<XSLFPictureData> _pictures;
    private CTPresentation _presentation;
    private List<XSLFSlide> _slides;
    private XSLFTableStyles _tableStyles;

    public XMLSlideShow() {
        this(empty());
    }

    public XMLSlideShow(OPCPackage oPCPackage) {
        super(oPCPackage);
        try {
            if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
                rebase(getPackage());
            }
            load(XSLFFactory.getInstance());
        } catch (Exception e) {
            throw new POIXMLException(e);
        }
    }

    public XMLSlideShow(InputStream inputStream) throws IOException {
        this(PackageHelper.open(inputStream));
    }

    static OPCPackage empty() {
        InputStream resourceAsStream = XMLSlideShow.class.getResourceAsStream("empty.pptx");
        try {
            if (resourceAsStream == null) {
                throw new POIXMLException("Missing resource 'empty.pptx'");
            }
            try {
                OPCPackage oPCPackageOpen = OPCPackage.open(resourceAsStream);
                IOUtils.closeQuietly(resourceAsStream);
                return oPCPackageOpen;
            } catch (Exception e) {
                throw new POIXMLException(e);
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(resourceAsStream);
            throw th;
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        try {
            this._presentation = PresentationDocument.Factory.parse(getCorePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getPresentation();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                if (documentPart instanceof XSLFSlide) {
                    map2.put(relationPart.getRelationship().getId(), (XSLFSlide) documentPart);
                } else if (documentPart instanceof XSLFSlideMaster) {
                    map.put(getRelationId(documentPart), (XSLFSlideMaster) documentPart);
                } else if (documentPart instanceof XSLFTableStyles) {
                    this._tableStyles = (XSLFTableStyles) documentPart;
                } else if (documentPart instanceof XSLFNotesMaster) {
                    this._notesMaster = (XSLFNotesMaster) documentPart;
                } else if (documentPart instanceof XSLFCommentAuthors) {
                    this._commentAuthors = (XSLFCommentAuthors) documentPart;
                }
            }
            this._masters = new ArrayList(map.size());
            Iterator it = this._presentation.getSldMasterIdLst().getSldMasterIdList().iterator();
            while (it.hasNext()) {
                this._masters.add((XSLFSlideMaster) map.get(((CTSlideMasterIdListEntry) it.next()).getId2()));
            }
            this._slides = new ArrayList(map2.size());
            if (this._presentation.isSetSldIdLst()) {
                for (CTSlideIdListEntry cTSlideIdListEntry : this._presentation.getSldIdLst().getSldIdList()) {
                    XSLFSlide xSLFSlide = (XSLFSlide) map2.get(cTSlideIdListEntry.getId2());
                    if (xSLFSlide == null) {
                        LOG.log(5, "Slide with r:id " + cTSlideIdListEntry.getId() + " was defined, but didn't exist in package, skipping");
                    } else {
                        this._slides.add(xSLFSlide);
                    }
                }
            }
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        this._presentation.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        outputStream.close();
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
        return Collections.unmodifiableList(getPackage().getPartsByName(Pattern.compile("/ppt/embeddings/.*?")));
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFPictureData> getPictureData() {
        if (this._pictures == null) {
            List<PackagePart> partsByName = getPackage().getPartsByName(Pattern.compile("/ppt/media/.*?"));
            this._pictures = new ArrayList(partsByName.size());
            Iterator<PackagePart> it = partsByName.iterator();
            while (it.hasNext()) {
                XSLFPictureData xSLFPictureData = new XSLFPictureData(it.next());
                xSLFPictureData.setIndex(this._pictures.size());
                this._pictures.add(xSLFPictureData);
            }
        }
        return Collections.unmodifiableList(this._pictures);
    }

    public XSLFSlide createSlide(XSLFSlideLayout xSLFSlideLayout) {
        CTSlideIdList sldIdLst;
        boolean z;
        int iMax = 256;
        int i = 1;
        if (!this._presentation.isSetSldIdLst()) {
            sldIdLst = this._presentation.addNewSldIdLst();
        } else {
            sldIdLst = this._presentation.getSldIdLst();
            int i2 = 1;
            for (CTSlideIdListEntry cTSlideIdListEntry : sldIdLst.getSldIdArray()) {
                iMax = (int) Math.max(cTSlideIdListEntry.getId() + 1, iMax);
                i2++;
            }
            while (true) {
                String fileName = XSLFRelation.SLIDE.getFileName(i2);
                Iterator<POIXMLDocumentPart> it = getRelations().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    POIXMLDocumentPart next = it.next();
                    if (next.getPackagePart() != null && fileName.equals(next.getPackagePart().getPartName().getName())) {
                        z = true;
                        break;
                    }
                }
                if (!z && getPackage().getPartsByName(Pattern.compile(Pattern.quote(fileName))).size() > 0) {
                    z = true;
                }
                if (!z) {
                    break;
                }
                i2++;
            }
            i = i2;
        }
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(XSLFRelation.SLIDE, XSLFFactory.getInstance(), i, false);
        XSLFSlide xSLFSlide = (XSLFSlide) relationPartCreateRelationship.getDocumentPart();
        CTSlideIdListEntry cTSlideIdListEntryAddNewSldId = sldIdLst.addNewSldId();
        cTSlideIdListEntryAddNewSldId.setId(iMax);
        cTSlideIdListEntryAddNewSldId.setId2(relationPartCreateRelationship.getRelationship().getId());
        xSLFSlideLayout.copyLayout(xSLFSlide);
        xSLFSlide.addRelation(null, XSLFRelation.SLIDE_LAYOUT, xSLFSlideLayout);
        this._slides.add(xSLFSlide);
        return xSLFSlide;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFSlide createSlide() {
        XSLFSlideMaster xSLFSlideMaster = this._masters.get(0);
        XSLFSlideLayout layout = xSLFSlideMaster.getLayout(SlideLayout.BLANK);
        if (layout == null) {
            LOG.log(5, "Blank layout was not found - defaulting to first slide layout in master");
            XSLFSlideLayout[] slideLayouts = xSLFSlideMaster.getSlideLayouts();
            if (slideLayouts.length == 0) {
                throw new POIXMLException("SlideMaster must contain a SlideLayout.");
            }
            layout = slideLayouts[0];
        }
        return createSlide(layout);
    }

    public XSLFNotes getNotesSlide(XSLFSlide xSLFSlide) {
        XSLFNotes notes = xSLFSlide.getNotes();
        return notes == null ? createNotesSlide(xSLFSlide) : notes;
    }

    private XSLFNotes createNotesSlide(XSLFSlide xSLFSlide) {
        boolean z;
        if (this._notesMaster == null) {
            createNotesMaster();
        }
        Integer fileNameIndex = XSLFRelation.SLIDE.getFileNameIndex(xSLFSlide);
        while (true) {
            String fileName = XSLFRelation.NOTES.getFileName(fileNameIndex.intValue());
            Iterator<POIXMLDocumentPart> it = getRelations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                POIXMLDocumentPart next = it.next();
                if (next.getPackagePart() != null && fileName.equals(next.getPackagePart().getPartName().getName())) {
                    z = true;
                    break;
                }
            }
            if (!z && getPackage().getPartsByName(Pattern.compile(Pattern.quote(fileName))).size() > 0) {
                z = true;
            }
            if (z) {
                fileNameIndex = Integer.valueOf(fileNameIndex.intValue() + 1);
            } else {
                XSLFNotes xSLFNotes = (XSLFNotes) createRelationship(XSLFRelation.NOTES, XSLFFactory.getInstance(), fileNameIndex.intValue());
                xSLFSlide.addRelation(null, XSLFRelation.NOTES, xSLFNotes);
                xSLFNotes.addRelation(null, XSLFRelation.NOTES_MASTER, this._notesMaster);
                xSLFNotes.addRelation(null, XSLFRelation.SLIDE, xSLFSlide);
                xSLFNotes.importContent(this._notesMaster);
                return xSLFNotes;
            }
        }
    }

    public void createNotesMaster() {
        Integer numValueOf = 1;
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(XSLFRelation.NOTES_MASTER, XSLFFactory.getInstance(), 1, false);
        this._notesMaster = (XSLFNotesMaster) relationPartCreateRelationship.getDocumentPart();
        this._presentation.addNewNotesMasterIdLst().addNewNotesMasterId().setId(relationPartCreateRelationship.getRelationship().getId());
        ArrayList arrayList = new ArrayList();
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFTheme) {
                arrayList.add(XSLFRelation.THEME.getFileNameIndex(pOIXMLDocumentPart));
            }
        }
        if (!arrayList.isEmpty()) {
            Boolean bool = false;
            Integer num = numValueOf;
            while (numValueOf.intValue() <= arrayList.size()) {
                if (!arrayList.contains(numValueOf)) {
                    bool = true;
                    num = numValueOf;
                }
                numValueOf = Integer.valueOf(numValueOf.intValue() + 1);
            }
            numValueOf = !bool.booleanValue() ? Integer.valueOf(arrayList.size() + 1) : num;
        }
        XSLFTheme xSLFTheme = (XSLFTheme) createRelationship(XSLFRelation.THEME, XSLFFactory.getInstance(), numValueOf.intValue());
        xSLFTheme.importTheme(getSlides().get(0).getTheme());
        this._notesMaster.addRelation(null, XSLFRelation.THEME, xSLFTheme);
    }

    public XSLFNotesMaster getNotesMaster() {
        return this._notesMaster;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFSlideMaster> getSlideMasters() {
        return this._masters;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<XSLFSlide> getSlides() {
        return this._slides;
    }

    public XSLFCommentAuthors getCommentAuthors() {
        return this._commentAuthors;
    }

    public void setSlideOrder(XSLFSlide xSLFSlide, int i) {
        int iIndexOf = this._slides.indexOf(xSLFSlide);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Slide not found");
        }
        if (iIndexOf == i) {
            return;
        }
        List<XSLFSlide> list = this._slides;
        list.add(i, list.remove(iIndexOf));
        CTSlideIdList sldIdLst = this._presentation.getSldIdLst();
        CTSlideIdListEntry[] sldIdArray = sldIdLst.getSldIdArray();
        CTSlideIdListEntry cTSlideIdListEntry = sldIdArray[iIndexOf];
        if (iIndexOf < i) {
            System.arraycopy(sldIdArray, iIndexOf + 1, sldIdArray, iIndexOf, i - iIndexOf);
        } else {
            System.arraycopy(sldIdArray, i, sldIdArray, i + 1, iIndexOf - i);
        }
        sldIdArray[i] = cTSlideIdListEntry;
        sldIdLst.setSldIdArray(sldIdArray);
    }

    public XSLFSlide removeSlide(int i) {
        XSLFSlide xSLFSlideRemove = this._slides.remove(i);
        removeRelation(xSLFSlideRemove);
        this._presentation.getSldIdLst().removeSldId(i);
        return xSLFSlideRemove;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public Dimension getPageSize() {
        CTSlideSize sldSz = this._presentation.getSldSz();
        return new Dimension((int) Units.toPoints(sldSz.getCx()), (int) Units.toPoints(sldSz.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public void setPageSize(Dimension dimension) {
        CTSlideSize cTSlideSizeNewInstance = CTSlideSize.Factory.newInstance();
        cTSlideSizeNewInstance.setCx(Units.toEMU(dimension.getWidth()));
        cTSlideSizeNewInstance.setCy(Units.toEMU(dimension.getHeight()));
        this._presentation.setSldSz(cTSlideSizeNewInstance);
    }

    @Internal
    public CTPresentation getCTPresentation() {
        return this._presentation;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData addPicture(byte[] bArr, PictureData.PictureType pictureType) {
        XSLFPictureData xSLFPictureDataFindPictureData = findPictureData(bArr);
        if (xSLFPictureDataFindPictureData != null) {
            return xSLFPictureDataFindPictureData;
        }
        int size = this._pictures.size();
        XSLFRelation relationForType = XSLFPictureData.getRelationForType(pictureType);
        if (relationForType == null) {
            throw new IllegalArgumentException("Picture type " + pictureType + " is not supported.");
        }
        XSLFPictureData xSLFPictureData = (XSLFPictureData) createRelationship(relationForType, XSLFFactory.getInstance(), size + 1, true).getDocumentPart();
        xSLFPictureData.setIndex(size);
        this._pictures.add(xSLFPictureData);
        try {
            OutputStream outputStream = xSLFPictureData.getPackagePart().getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            return xSLFPictureData;
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData addPicture(InputStream inputStream, PictureData.PictureType pictureType) throws IOException {
        return addPicture(IOUtils.toByteArray(inputStream), pictureType);
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData addPicture(File file, PictureData.PictureType pictureType) throws IOException {
        byte[] bArr = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            IOUtils.readFully(fileInputStream, bArr);
            return addPicture(bArr, pictureType);
        } finally {
            fileInputStream.close();
        }
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public XSLFPictureData findPictureData(byte[] bArr) {
        long jCalculateChecksum = IOUtils.calculateChecksum(bArr);
        byte[] bArr2 = new byte[8];
        LittleEndian.putLong(bArr2, 0, jCalculateChecksum);
        for (XSLFPictureData xSLFPictureData : getPictureData()) {
            if (Arrays.equals(xSLFPictureData.getChecksum(), bArr2)) {
                return xSLFPictureData;
            }
        }
        return null;
    }

    public XSLFSlideLayout findLayout(String str) {
        Iterator<XSLFSlideMaster> it = getSlideMasters().iterator();
        while (it.hasNext()) {
            XSLFSlideLayout layout = it.next().getLayout(str);
            if (layout != null) {
                return layout;
            }
        }
        return null;
    }

    public XSLFTableStyles getTableStyles() {
        return this._tableStyles;
    }

    CTTextParagraphProperties getDefaultParagraphStyle(int i) {
        CTTextParagraphProperties[] cTTextParagraphPropertiesArrSelectPath = this._presentation.selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:defaultTextStyle/a:lvl" + (i + 1) + "pPr");
        if (cTTextParagraphPropertiesArrSelectPath.length == 1) {
            return cTTextParagraphPropertiesArrSelectPath[0];
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public MasterSheet<XSLFShape, XSLFTextParagraph> createMasterSheet() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public Resources getResources() {
        throw new UnsupportedOperationException();
    }
}
