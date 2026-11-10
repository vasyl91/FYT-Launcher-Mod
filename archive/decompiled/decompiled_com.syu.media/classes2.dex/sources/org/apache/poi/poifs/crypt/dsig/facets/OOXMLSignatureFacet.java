package org.apache.poi.poifs.crypt.dsig.facets;

import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.Manifest;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureProperty;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class OOXMLSignatureFacet extends SignatureFacet {
    private static final String ID_PACKAGE_OBJECT = "idPackageObject";
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) OOXMLSignatureFacet.class);
    private static final Set<String> signed = Collections.unmodifiableSet(new HashSet(Arrays.asList("activeXControlBinary", "aFChunk", "attachedTemplate", "attachedToolbars", "audio", "calcChain", "chart", "chartColorStyle", "chartLayout", "chartsheet", "chartStyle", "chartUserShapes", "commentAuthors", "comments", "connections", "connectorXml", "control", "ctrlProp", "customData", "customData", "customProperty", "customXml", "diagram", "diagramColors", "diagramColorsHeader", "diagramData", "diagramDrawing", "diagramLayout", "diagramLayoutHeader", "diagramQuickStyle", "diagramQuickStyleHeader", "dialogsheet", "dictionary", "documentParts", "downRev", "drawing", "endnotes", "externalLink", "externalLinkPath", CellUtil.FONT, "fontTable", "footer", "footnotes", "functionPrototypes", "glossaryDocument", "graphicFrameDoc", "groupShapeXml", "handoutMaster", "hdphoto", "header", "hyperlink", "image", "ink", "inkXml", "keyMapCustomizations", "legacyDiagramText", "legacyDocTextInfo", "mailMergeHeaderSource", "mailMergeRecipientData", "mailMergeSource", "media", "notesMaster", "notesSlide", "numbering", "officeDocument", "officeDocument", "oleObject", "package", "pictureXml", "pivotCacheDefinition", "pivotCacheRecords", "pivotTable", "powerPivotData", "presProps", "printerSettings", "queryTable", "recipientData", "settings", "shapeXml", "sharedStrings", "sheetMetadata", "slicer", "slicer", "slicerCache", "slicerCache", "slide", "slideLayout", "slideMaster", "slideUpdateInfo", "slideUpdateUrl", "smartTags", "styles", "stylesWithEffects", "table", "tableSingleCells", "tableStyles", "tags", "theme", "themeOverride", "timeline", "timelineCache", "transform", "ui/altText", "ui/buttonSize", "ui/controlID", "ui/description", "ui/enabled", "ui/extensibility", "ui/extensibility", "ui/helperText", "ui/imageID", "ui/imageMso", "ui/keyTip", "ui/label", "ui/lcid", "ui/loud", "ui/pressed", "ui/progID", "ui/ribbonID", "ui/showImage", "ui/showLabel", "ui/supertip", "ui/target", "ui/text", "ui/title", "ui/tooltip", "ui/userCustomization", "ui/visible", "userXmlData", "vbaProject", "video", "viewProps", "vmlDrawing", "volatileDependencies", "webSettings", "wordVbaData", "worksheet", "wsSortMap", "xlBinaryIndex", "xlExternalLinkPath/xlAlternateStartup", "xlExternalLinkPath/xlLibrary", "xlExternalLinkPath/xlPathMissing", "xlExternalLinkPath/xlStartup", "xlIntlMacrosheet", "xlMacrosheet", "xmlMaps")));

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        LOG.log(1, "pre sign");
        addManifestObject(document, list, list2);
        addSignatureInfo(document, list, list2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    protected void addManifestObject(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        ArrayList arrayList = new ArrayList();
        addManifestReferences(arrayList);
        Manifest manifestNewManifest = getSignatureFactory().newManifest(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(manifestNewManifest);
        addSignatureTime(document, arrayList2);
        list2.add(getSignatureFactory().newXMLObject(arrayList2, ID_PACKAGE_OBJECT, (String) null, (String) null));
        list.add(newReference("#idPackageObject", null, "http://www.w3.org/2000/09/xmldsig#Object", null, null));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    protected void addManifestReferences(List<Reference> list) throws XMLSignatureException {
        OPCPackage opcPackage = this.signatureConfig.getOpcPackage();
        ArrayList<PackagePart> partsByContentType = opcPackage.getPartsByContentType(ContentTypes.RELATIONSHIPS_PART);
        HashSet hashSet = new HashSet();
        for (PackagePart packagePart : partsByContentType) {
            String strReplaceFirst = packagePart.getPartName().getName().replaceFirst("(.*)/_rels/.*", "$1");
            try {
                PackageRelationshipCollection packageRelationshipCollection = new PackageRelationshipCollection(opcPackage);
                packageRelationshipCollection.parseRelationshipsPart(packagePart);
                RelationshipTransformService.RelationshipTransformParameterSpec relationshipTransformParameterSpec = new RelationshipTransformService.RelationshipTransformParameterSpec();
                for (PackageRelationship packageRelationship : packageRelationshipCollection) {
                    String relationshipType = packageRelationship.getRelationshipType();
                    if (TargetMode.EXTERNAL != packageRelationship.getTargetMode() && isSignedRelationship(relationshipType)) {
                        relationshipTransformParameterSpec.addRelationshipReference(packageRelationship.getId());
                        String strNormalizePartName = normalizePartName(packageRelationship.getTargetURI(), strReplaceFirst);
                        if (hashSet.contains(strNormalizePartName)) {
                            continue;
                        } else {
                            hashSet.add(strNormalizePartName);
                            try {
                                String contentType = opcPackage.getPart(PackagingURIHelper.createPartName(strNormalizePartName)).getContentType();
                                if (relationshipType.endsWith("customXml") && !contentType.equals("inkml+xml") && !contentType.equals(ContentTypes.XML)) {
                                    LOG.log(1, "skipping customXml with content type: " + contentType);
                                } else {
                                    list.add(newReference(strNormalizePartName + "?ContentType=" + contentType, null, null, null, null));
                                }
                            } catch (InvalidFormatException e) {
                                throw new XMLSignatureException(e);
                            }
                        }
                    }
                }
                if (relationshipTransformParameterSpec.hasSourceIds()) {
                    List<Transform> arrayList = new ArrayList<>();
                    arrayList.add(newTransform(RelationshipTransformService.TRANSFORM_URI, relationshipTransformParameterSpec));
                    arrayList.add(newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315"));
                    list.add(newReference(normalizePartName(packagePart.getPartName().getURI(), strReplaceFirst) + "?ContentType=application/vnd.openxmlformats-package.relationships+xml", arrayList, null, null, null));
                }
            } catch (InvalidFormatException e2) {
                throw new XMLSignatureException("Invalid relationship descriptor: " + packagePart.getPartName().getName(), e2);
            }
        }
        Collections.sort(list, new Comparator<Reference>() { // from class: org.apache.poi.poifs.crypt.dsig.facets.OOXMLSignatureFacet.1
            @Override // java.util.Comparator
            public int compare(Reference reference, Reference reference2) {
                return reference.getURI().compareTo(reference2.getURI());
            }
        });
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.XMLSignatureException */
    private static String normalizePartName(URI uri, String str) throws XMLSignatureException {
        String aSCIIString = uri.toASCIIString();
        if (!aSCIIString.startsWith(str)) {
            aSCIIString = str + aSCIIString;
        }
        try {
            String strReplace = new URI(aSCIIString).normalize().getPath().replace('\\', '/');
            LOG.log(1, "part name: " + strReplace);
            return strReplace;
        } catch (URISyntaxException e) {
            throw new XMLSignatureException(e);
        }
    }

    protected void addSignatureTime(Document document, List<XMLStructure> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
        simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
        String str = simpleDateFormat.format(this.signatureConfig.getExecutionTime());
        LOG.log(1, "now: " + str);
        CTSignatureTime cTSignatureTimeAddNewSignatureTime = SignatureTimeDocument.Factory.newInstance().addNewSignatureTime();
        cTSignatureTimeAddNewSignatureTime.setFormat("YYYY-MM-DDThh:mm:ssTZD");
        cTSignatureTimeAddNewSignatureTime.setValue(str);
        Element element = (Element) document.importNode(cTSignatureTimeAddNewSignatureTime.getDomNode(), true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DOMStructure(element));
        SignatureProperty signaturePropertyNewSignatureProperty = getSignatureFactory().newSignatureProperty(arrayList, "#" + this.signatureConfig.getPackageSignatureId(), "idSignatureTime");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(signaturePropertyNewSignatureProperty);
        list.add(getSignatureFactory().newSignatureProperties(arrayList2, (String) null));
    }

    protected void addSignatureInfo(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        ArrayList arrayList = new ArrayList();
        CTSignatureInfoV1 cTSignatureInfoV1AddNewSignatureInfoV1 = SignatureInfoV1Document.Factory.newInstance().addNewSignatureInfoV1();
        cTSignatureInfoV1AddNewSignatureInfoV1.setManifestHashAlgorithm(this.signatureConfig.getDigestMethodUri());
        Element element = (Element) document.importNode(cTSignatureInfoV1AddNewSignatureInfoV1.getDomNode(), true);
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", XMLConstants.XMLNS_ATTRIBUTE, SignatureFacet.MS_DIGSIG_NS);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new DOMStructure(element));
        SignatureProperty signaturePropertyNewSignatureProperty = getSignatureFactory().newSignatureProperty(arrayList2, "#" + this.signatureConfig.getPackageSignatureId(), "idOfficeV1Details");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(signaturePropertyNewSignatureProperty);
        arrayList.add(getSignatureFactory().newSignatureProperties(arrayList3, (String) null));
        list2.add(getSignatureFactory().newXMLObject(arrayList, "idOfficeObject", (String) null, (String) null));
        list.add(newReference("#idOfficeObject", null, "http://www.w3.org/2000/09/xmldsig#Object", null, null));
    }

    protected static String getRelationshipReferenceURI(String str) {
        return "/" + str + "?ContentType=application/vnd.openxmlformats-package.relationships+xml";
    }

    protected static String getResourceReferenceURI(String str, String str2) {
        return "/" + str + "?ContentType=" + str2;
    }

    protected static boolean isSignedRelationship(String str) {
        LOG.log(1, "relationship type: " + str);
        String strReplaceFirst = str.replaceFirst(".*/relationships/", "");
        return signed.contains(strReplaceFirst) || strReplaceFirst.endsWith("customXml");
    }
}
