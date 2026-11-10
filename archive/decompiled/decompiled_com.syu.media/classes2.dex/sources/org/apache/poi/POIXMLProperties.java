package org.apache.poi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.openxml4j.util.Nullable;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.PropertiesDocument;
import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class POIXMLProperties {
    private static final PropertiesDocument NEW_CUST_INSTANCE;
    private static final org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument NEW_EXT_INSTANCE;
    private CoreProperties core;
    private CustomProperties cust;
    private PackagePart custPart;
    private ExtendedProperties ext;
    private PackagePart extPart;
    private OPCPackage pkg;

    static {
        org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument propertiesDocumentNewInstance = org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument.Factory.newInstance();
        NEW_EXT_INSTANCE = propertiesDocumentNewInstance;
        propertiesDocumentNewInstance.addNewProperties();
        PropertiesDocument propertiesDocumentNewInstance2 = PropertiesDocument.Factory.newInstance();
        NEW_CUST_INSTANCE = propertiesDocumentNewInstance2;
        propertiesDocumentNewInstance2.addNewProperties();
    }

    public POIXMLProperties(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        this.pkg = oPCPackage;
        this.core = new CoreProperties((PackagePropertiesPart) this.pkg.getPackageProperties());
        PackageRelationshipCollection relationshipsByType = this.pkg.getRelationshipsByType(PackageRelationshipTypes.EXTENDED_PROPERTIES);
        if (relationshipsByType.size() == 1) {
            PackagePart part = this.pkg.getPart(relationshipsByType.getRelationship(0));
            this.extPart = part;
            this.ext = new ExtendedProperties(org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument.Factory.parse(part.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
        } else {
            this.extPart = null;
            this.ext = new ExtendedProperties(NEW_EXT_INSTANCE.copy());
        }
        PackageRelationshipCollection relationshipsByType2 = this.pkg.getRelationshipsByType(PackageRelationshipTypes.CUSTOM_PROPERTIES);
        if (relationshipsByType2.size() == 1) {
            PackagePart part2 = this.pkg.getPart(relationshipsByType2.getRelationship(0));
            this.custPart = part2;
            this.cust = new CustomProperties(PropertiesDocument.Factory.parse(part2.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
        } else {
            this.custPart = null;
            this.cust = new CustomProperties(NEW_CUST_INSTANCE.copy());
        }
    }

    public CoreProperties getCoreProperties() {
        return this.core;
    }

    public ExtendedProperties getExtendedProperties() {
        return this.ext;
    }

    public CustomProperties getCustomProperties() {
        return this.cust;
    }

    protected PackagePart getThumbnailPart() {
        PackageRelationshipCollection relationshipsByType = this.pkg.getRelationshipsByType(PackageRelationshipTypes.THUMBNAIL);
        if (relationshipsByType.size() == 1) {
            return this.pkg.getPart(relationshipsByType.getRelationship(0));
        }
        return null;
    }

    public String getThumbnailFilename() {
        PackagePart thumbnailPart = getThumbnailPart();
        if (thumbnailPart == null) {
            return null;
        }
        String name = thumbnailPart.getPartName().getName();
        return name.substring(name.lastIndexOf(47));
    }

    public InputStream getThumbnailImage() throws IOException {
        PackagePart thumbnailPart = getThumbnailPart();
        if (thumbnailPart == null) {
            return null;
        }
        return thumbnailPart.getInputStream();
    }

    public void setThumbnail(String str, InputStream inputStream) throws IOException {
        PackagePart thumbnailPart = getThumbnailPart();
        if (thumbnailPart == null) {
            this.pkg.addThumbnail(str, inputStream);
            return;
        }
        String contentTypeFromFileExtension = ContentTypes.getContentTypeFromFileExtension(str);
        if (!contentTypeFromFileExtension.equals(thumbnailPart.getContentType())) {
            throw new IllegalArgumentException("Can't set a Thumbnail of type " + contentTypeFromFileExtension + " when existing one is of a different type " + thumbnailPart.getContentType());
        }
        StreamHelper.copyStream(inputStream, thumbnailPart.getOutputStream());
    }

    public void commit() throws IOException {
        if (this.extPart == null && !NEW_EXT_INSTANCE.toString().equals(this.ext.props.toString())) {
            try {
                PackagePartName packagePartNameCreatePartName = PackagingURIHelper.createPartName("/docProps/app.xml");
                this.pkg.addRelationship(packagePartNameCreatePartName, TargetMode.INTERNAL, PackageRelationshipTypes.EXTENDED_PROPERTIES);
                this.extPart = this.pkg.createPart(packagePartNameCreatePartName, "application/vnd.openxmlformats-officedocument.extended-properties+xml");
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }
        if (this.custPart == null && !NEW_CUST_INSTANCE.toString().equals(this.cust.props.toString())) {
            try {
                PackagePartName packagePartNameCreatePartName2 = PackagingURIHelper.createPartName("/docProps/custom.xml");
                this.pkg.addRelationship(packagePartNameCreatePartName2, TargetMode.INTERNAL, PackageRelationshipTypes.CUSTOM_PROPERTIES);
                this.custPart = this.pkg.createPart(packagePartNameCreatePartName2, "application/vnd.openxmlformats-officedocument.custom-properties+xml");
            } catch (InvalidFormatException e2) {
                throw new POIXMLException(e2);
            }
        }
        PackagePart packagePart = this.extPart;
        if (packagePart != null) {
            OutputStream outputStream = packagePart.getOutputStream();
            if (this.extPart.getSize() > 0) {
                this.extPart.clear();
            }
            this.ext.props.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            outputStream.close();
        }
        PackagePart packagePart2 = this.custPart;
        if (packagePart2 != null) {
            OutputStream outputStream2 = packagePart2.getOutputStream();
            this.cust.props.save(outputStream2, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            outputStream2.close();
        }
    }

    public static class CoreProperties {
        private PackagePropertiesPart part;

        private CoreProperties(PackagePropertiesPart packagePropertiesPart) {
            this.part = packagePropertiesPart;
        }

        public String getCategory() {
            return this.part.getCategoryProperty().getValue();
        }

        public void setCategory(String str) {
            this.part.setCategoryProperty(str);
        }

        public String getContentStatus() {
            return this.part.getContentStatusProperty().getValue();
        }

        public void setContentStatus(String str) {
            this.part.setContentStatusProperty(str);
        }

        public String getContentType() {
            return this.part.getContentTypeProperty().getValue();
        }

        public void setContentType(String str) {
            this.part.setContentTypeProperty(str);
        }

        public Date getCreated() {
            return this.part.getCreatedProperty().getValue();
        }

        public void setCreated(Nullable<Date> nullable) {
            this.part.setCreatedProperty(nullable);
        }

        public void setCreated(String str) {
            this.part.setCreatedProperty(str);
        }

        public String getCreator() {
            return this.part.getCreatorProperty().getValue();
        }

        public void setCreator(String str) {
            this.part.setCreatorProperty(str);
        }

        public String getDescription() {
            return this.part.getDescriptionProperty().getValue();
        }

        public void setDescription(String str) {
            this.part.setDescriptionProperty(str);
        }

        public String getIdentifier() {
            return this.part.getIdentifierProperty().getValue();
        }

        public void setIdentifier(String str) {
            this.part.setIdentifierProperty(str);
        }

        public String getKeywords() {
            return this.part.getKeywordsProperty().getValue();
        }

        public void setKeywords(String str) {
            this.part.setKeywordsProperty(str);
        }

        public Date getLastPrinted() {
            return this.part.getLastPrintedProperty().getValue();
        }

        public void setLastPrinted(Nullable<Date> nullable) {
            this.part.setLastPrintedProperty(nullable);
        }

        public void setLastPrinted(String str) {
            this.part.setLastPrintedProperty(str);
        }

        public String getLastModifiedByUser() {
            return this.part.getLastModifiedByProperty().getValue();
        }

        public void setLastModifiedByUser(String str) {
            this.part.setLastModifiedByProperty(str);
        }

        public Date getModified() {
            return this.part.getModifiedProperty().getValue();
        }

        public void setModified(Nullable<Date> nullable) {
            this.part.setModifiedProperty(nullable);
        }

        public void setModified(String str) {
            this.part.setModifiedProperty(str);
        }

        public String getSubject() {
            return this.part.getSubjectProperty().getValue();
        }

        public void setSubjectProperty(String str) {
            this.part.setSubjectProperty(str);
        }

        public void setTitle(String str) {
            this.part.setTitleProperty(str);
        }

        public String getTitle() {
            return this.part.getTitleProperty().getValue();
        }

        public String getRevision() {
            return this.part.getRevisionProperty().getValue();
        }

        public void setRevision(String str) {
            try {
                Long.valueOf(str);
                this.part.setRevisionProperty(str);
            } catch (NumberFormatException unused) {
            }
        }

        public PackagePropertiesPart getUnderlyingProperties() {
            return this.part;
        }
    }

    public static class ExtendedProperties {
        private org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument props;

        private ExtendedProperties(org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.PropertiesDocument propertiesDocument) {
            this.props = propertiesDocument;
        }

        public CTProperties getUnderlyingProperties() {
            return this.props.getProperties();
        }

        public String getTemplate() {
            if (this.props.getProperties().isSetTemplate()) {
                return this.props.getProperties().getTemplate();
            }
            return null;
        }

        public String getManager() {
            if (this.props.getProperties().isSetManager()) {
                return this.props.getProperties().getManager();
            }
            return null;
        }

        public String getCompany() {
            if (this.props.getProperties().isSetCompany()) {
                return this.props.getProperties().getCompany();
            }
            return null;
        }

        public String getPresentationFormat() {
            if (this.props.getProperties().isSetPresentationFormat()) {
                return this.props.getProperties().getPresentationFormat();
            }
            return null;
        }

        public String getApplication() {
            if (this.props.getProperties().isSetApplication()) {
                return this.props.getProperties().getApplication();
            }
            return null;
        }

        public String getAppVersion() {
            if (this.props.getProperties().isSetAppVersion()) {
                return this.props.getProperties().getAppVersion();
            }
            return null;
        }

        public int getPages() {
            if (this.props.getProperties().isSetPages()) {
                return this.props.getProperties().getPages();
            }
            return -1;
        }

        public int getWords() {
            if (this.props.getProperties().isSetWords()) {
                return this.props.getProperties().getWords();
            }
            return -1;
        }

        public int getCharacters() {
            if (this.props.getProperties().isSetCharacters()) {
                return this.props.getProperties().getCharacters();
            }
            return -1;
        }

        public int getCharactersWithSpaces() {
            if (this.props.getProperties().isSetCharactersWithSpaces()) {
                return this.props.getProperties().getCharactersWithSpaces();
            }
            return -1;
        }

        public int getLines() {
            if (this.props.getProperties().isSetLines()) {
                return this.props.getProperties().getLines();
            }
            return -1;
        }

        public int getParagraphs() {
            if (this.props.getProperties().isSetParagraphs()) {
                return this.props.getProperties().getParagraphs();
            }
            return -1;
        }

        public int getSlides() {
            if (this.props.getProperties().isSetSlides()) {
                return this.props.getProperties().getSlides();
            }
            return -1;
        }

        public int getNotes() {
            if (this.props.getProperties().isSetNotes()) {
                return this.props.getProperties().getNotes();
            }
            return -1;
        }

        public int getTotalTime() {
            if (this.props.getProperties().isSetTotalTime()) {
                return this.props.getProperties().getTotalTime();
            }
            return -1;
        }

        public int getHiddenSlides() {
            if (this.props.getProperties().isSetHiddenSlides()) {
                return this.props.getProperties().getHiddenSlides();
            }
            return -1;
        }

        public int getMMClips() {
            if (this.props.getProperties().isSetMMClips()) {
                return this.props.getProperties().getMMClips();
            }
            return -1;
        }

        public String getHyperlinkBase() {
            if (this.props.getProperties().isSetHyperlinkBase()) {
                return this.props.getProperties().getHyperlinkBase();
            }
            return null;
        }
    }

    public static class CustomProperties {
        public static final String FORMAT_ID = "{D5CDD505-2E9C-101B-9397-08002B2CF9AE}";
        private PropertiesDocument props;

        private CustomProperties(PropertiesDocument propertiesDocument) {
            this.props = propertiesDocument;
        }

        public org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties getUnderlyingProperties() {
            return this.props.getProperties();
        }

        private CTProperty add(String str) {
            if (contains(str)) {
                throw new IllegalArgumentException("A property with this name already exists in the custom properties");
            }
            CTProperty cTPropertyAddNewProperty = this.props.getProperties().addNewProperty();
            cTPropertyAddNewProperty.setPid(nextPid());
            cTPropertyAddNewProperty.setFmtid(FORMAT_ID);
            cTPropertyAddNewProperty.setName(str);
            return cTPropertyAddNewProperty;
        }

        public void addProperty(String str, String str2) {
            add(str).setLpwstr(str2);
        }

        public void addProperty(String str, double d) {
            add(str).setR8(d);
        }

        public void addProperty(String str, int i) {
            add(str).setI4(i);
        }

        public void addProperty(String str, boolean z) {
            add(str).setBool(z);
        }

        protected int nextPid() {
            int pid = 1;
            for (CTProperty cTProperty : this.props.getProperties().getPropertyArray()) {
                if (cTProperty.getPid() > pid) {
                    pid = cTProperty.getPid();
                }
            }
            return pid + 1;
        }

        public boolean contains(String str) {
            for (CTProperty cTProperty : this.props.getProperties().getPropertyArray()) {
                if (cTProperty.getName().equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public CTProperty getProperty(String str) {
            for (CTProperty cTProperty : this.props.getProperties().getPropertyArray()) {
                if (cTProperty.getName().equals(str)) {
                    return cTProperty;
                }
            }
            return null;
        }
    }
}
