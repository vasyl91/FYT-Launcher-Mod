package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XSLFSlideShow extends POIXMLDocument {
    private List<PackagePart> embedds;
    private PresentationDocument presentationDoc;

    public XSLFSlideShow(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        super(oPCPackage);
        if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
            rebase(getPackage());
        }
        this.presentationDoc = PresentationDocument.Factory.parse(getCorePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        this.embedds = new LinkedList();
        for (CTSlideIdListEntry cTSlideIdListEntry : getSlideReferences().getSldIdArray()) {
            PackagePart corePart = getCorePart();
            PackagePart relatedPart = corePart.getRelatedPart(corePart.getRelationship(cTSlideIdListEntry.getId2()));
            for (PackageRelationship packageRelationship : relatedPart.getRelationshipsByType(POIXMLDocument.OLE_OBJECT_REL_TYPE)) {
                if (TargetMode.EXTERNAL != packageRelationship.getTargetMode()) {
                    this.embedds.add(relatedPart.getRelatedPart(packageRelationship));
                }
            }
            Iterator<PackageRelationship> it = relatedPart.getRelationshipsByType(POIXMLDocument.PACK_OBJECT_REL_TYPE).iterator();
            while (it.hasNext()) {
                this.embedds.add(relatedPart.getRelatedPart(it.next()));
            }
        }
    }

    public XSLFSlideShow(String str) throws XmlException, OpenXML4JException, IOException {
        this(openPackage(str));
    }

    @Internal
    public CTPresentation getPresentation() {
        return this.presentationDoc.getPresentation();
    }

    @Internal
    public CTSlideIdList getSlideReferences() {
        if (!getPresentation().isSetSldIdLst()) {
            getPresentation().setSldIdLst(CTSlideIdList.Factory.newInstance());
        }
        return getPresentation().getSldIdLst();
    }

    @Internal
    public CTSlideMasterIdList getSlideMasterReferences() {
        return getPresentation().getSldMasterIdLst();
    }

    public PackagePart getSlideMasterPart(CTSlideMasterIdListEntry cTSlideMasterIdListEntry) throws XmlException, IOException {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(cTSlideMasterIdListEntry.getId2()));
        } catch (InvalidFormatException e) {
            throw new XmlException(e);
        }
    }

    @Internal
    public CTSlideMaster getSlideMaster(CTSlideMasterIdListEntry cTSlideMasterIdListEntry) throws XmlException, IOException {
        return SldMasterDocument.Factory.parse(getSlideMasterPart(cTSlideMasterIdListEntry).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSldMaster();
    }

    public PackagePart getSlidePart(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException, IOException {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(cTSlideIdListEntry.getId2()));
        } catch (InvalidFormatException e) {
            throw new XmlException(e);
        }
    }

    @Internal
    public CTSlide getSlide(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException, IOException {
        return SldDocument.Factory.parse(getSlidePart(cTSlideIdListEntry).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSld();
    }

    public PackagePart getNodesPart(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException, IOException {
        PackagePart slidePart = getSlidePart(cTSlideIdListEntry);
        try {
            PackageRelationshipCollection relationshipsByType = slidePart.getRelationshipsByType(XSLFRelation.NOTES.getRelation());
            if (relationshipsByType.size() == 0) {
                return null;
            }
            if (relationshipsByType.size() > 1) {
                throw new IllegalStateException("Expecting 0 or 1 notes for a slide, but found " + relationshipsByType.size());
            }
            try {
                return slidePart.getRelatedPart(relationshipsByType.getRelationship(0));
            } catch (InvalidFormatException e) {
                throw new IllegalStateException(e);
            }
        } catch (InvalidFormatException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Internal
    public CTNotesSlide getNotes(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException, IOException {
        PackagePart nodesPart = getNodesPart(cTSlideIdListEntry);
        if (nodesPart == null) {
            return null;
        }
        return NotesDocument.Factory.parse(nodesPart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotes();
    }

    @Internal
    public CTCommentList getSlideComments(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException, IOException {
        PackagePart slidePart = getSlidePart(cTSlideIdListEntry);
        try {
            PackageRelationshipCollection relationshipsByType = slidePart.getRelationshipsByType(XSLFRelation.COMMENTS.getRelation());
            if (relationshipsByType.size() == 0) {
                return null;
            }
            if (relationshipsByType.size() > 1) {
                throw new IllegalStateException("Expecting 0 or 1 comments for a slide, but found " + relationshipsByType.size());
            }
            try {
                return CmLstDocument.Factory.parse(slidePart.getRelatedPart(relationshipsByType.getRelationship(0)).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCmLst();
            } catch (InvalidFormatException e) {
                throw new IllegalStateException(e);
            }
        } catch (InvalidFormatException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
        return this.embedds;
    }
}
