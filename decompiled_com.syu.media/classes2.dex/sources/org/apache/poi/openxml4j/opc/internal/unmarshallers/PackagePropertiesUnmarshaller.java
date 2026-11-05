package org.apache.poi.openxml4j.opc.internal.unmarshallers;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.XMLConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.openxml4j.opc.internal.PartUnmarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.util.DocumentHelper;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PackagePropertiesUnmarshaller implements PartUnmarshaller {
    protected static final String KEYWORD_CATEGORY = "category";
    protected static final String KEYWORD_CONTENT_STATUS = "contentStatus";
    protected static final String KEYWORD_CONTENT_TYPE = "contentType";
    protected static final String KEYWORD_CREATED = "created";
    protected static final String KEYWORD_CREATOR = "creator";
    protected static final String KEYWORD_DESCRIPTION = "description";
    protected static final String KEYWORD_IDENTIFIER = "identifier";
    protected static final String KEYWORD_KEYWORDS = "keywords";
    protected static final String KEYWORD_LANGUAGE = "language";
    protected static final String KEYWORD_LAST_MODIFIED_BY = "lastModifiedBy";
    protected static final String KEYWORD_LAST_PRINTED = "lastPrinted";
    protected static final String KEYWORD_MODIFIED = "modified";
    protected static final String KEYWORD_REVISION = "revision";
    protected static final String KEYWORD_SUBJECT = "subject";
    protected static final String KEYWORD_TITLE = "title";
    protected static final String KEYWORD_VERSION = "version";

    @Override // org.apache.poi.openxml4j.opc.internal.PartUnmarshaller
    public PackagePart unmarshall(UnmarshallContext unmarshallContext, InputStream inputStream) throws InvalidFormatException, IOException {
        PackagePropertiesPart packagePropertiesPart = new PackagePropertiesPart(unmarshallContext.getPackage(), unmarshallContext.getPartName());
        if (inputStream == null) {
            if (unmarshallContext.getZipEntry() != null) {
                inputStream = ((ZipPackage) unmarshallContext.getPackage()).getZipArchive().getInputStream(unmarshallContext.getZipEntry());
            } else if (unmarshallContext.getPackage() != null) {
                inputStream = ((ZipPackage) unmarshallContext.getPackage()).getZipArchive().getInputStream(ZipHelper.getCorePropertiesZipEntry((ZipPackage) unmarshallContext.getPackage()));
            } else {
                throw new IOException("Error while trying to get the part input stream.");
            }
        }
        try {
            Document document = DocumentHelper.readDocument(inputStream);
            checkElementForOPCCompliance(document.getDocumentElement());
            packagePropertiesPart.setCategoryProperty(loadCategory(document));
            packagePropertiesPart.setContentStatusProperty(loadContentStatus(document));
            packagePropertiesPart.setContentTypeProperty(loadContentType(document));
            packagePropertiesPart.setCreatedProperty(loadCreated(document));
            packagePropertiesPart.setCreatorProperty(loadCreator(document));
            packagePropertiesPart.setDescriptionProperty(loadDescription(document));
            packagePropertiesPart.setIdentifierProperty(loadIdentifier(document));
            packagePropertiesPart.setKeywordsProperty(loadKeywords(document));
            packagePropertiesPart.setLanguageProperty(loadLanguage(document));
            packagePropertiesPart.setLastModifiedByProperty(loadLastModifiedBy(document));
            packagePropertiesPart.setLastPrintedProperty(loadLastPrinted(document));
            packagePropertiesPart.setModifiedProperty(loadModified(document));
            packagePropertiesPart.setRevisionProperty(loadRevision(document));
            packagePropertiesPart.setSubjectProperty(loadSubject(document));
            packagePropertiesPart.setTitleProperty(loadTitle(document));
            packagePropertiesPart.setVersionProperty(loadVersion(document));
            return packagePropertiesPart;
        } catch (SAXException e) {
            throw new IOException(e.getMessage());
        }
    }

    private String readElement(Document document, String str, String str2) {
        Element element = (Element) document.getDocumentElement().getElementsByTagNameNS(str2, str).item(0);
        if (element == null) {
            return null;
        }
        return element.getTextContent();
    }

    private String loadCategory(Document document) {
        return readElement(document, KEYWORD_CATEGORY, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadContentStatus(Document document) {
        return readElement(document, KEYWORD_CONTENT_STATUS, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadContentType(Document document) {
        return readElement(document, KEYWORD_CONTENT_TYPE, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadCreated(Document document) {
        return readElement(document, KEYWORD_CREATED, "http://purl.org/dc/terms/");
    }

    private String loadCreator(Document document) {
        return readElement(document, KEYWORD_CREATOR, "http://purl.org/dc/elements/1.1/");
    }

    private String loadDescription(Document document) {
        return readElement(document, KEYWORD_DESCRIPTION, "http://purl.org/dc/elements/1.1/");
    }

    private String loadIdentifier(Document document) {
        return readElement(document, KEYWORD_IDENTIFIER, "http://purl.org/dc/elements/1.1/");
    }

    private String loadKeywords(Document document) {
        return readElement(document, KEYWORD_KEYWORDS, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadLanguage(Document document) {
        return readElement(document, KEYWORD_LANGUAGE, "http://purl.org/dc/elements/1.1/");
    }

    private String loadLastModifiedBy(Document document) {
        return readElement(document, KEYWORD_LAST_MODIFIED_BY, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadLastPrinted(Document document) {
        return readElement(document, KEYWORD_LAST_PRINTED, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadModified(Document document) {
        return readElement(document, KEYWORD_MODIFIED, "http://purl.org/dc/terms/");
    }

    private String loadRevision(Document document) {
        return readElement(document, KEYWORD_REVISION, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadSubject(Document document) {
        return readElement(document, KEYWORD_SUBJECT, "http://purl.org/dc/elements/1.1/");
    }

    private String loadTitle(Document document) {
        return readElement(document, KEYWORD_TITLE, "http://purl.org/dc/elements/1.1/");
    }

    private String loadVersion(Document document) {
        return readElement(document, KEYWORD_VERSION, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    public void checkElementForOPCCompliance(Element element) throws InvalidFormatException {
        NamedNodeMap attributes = element.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Attr attr = (Attr) attributes.item(0);
            if (attr.getNamespaceURI().equals("http://www.w3.org/2000/xmlns/") && attr.getValue().equals(PackageNamespaces.MARKUP_COMPATIBILITY)) {
                throw new InvalidFormatException("OPC Compliance error [M4.2]: A format consumer shall consider the use of the Markup Compatibility namespace to be an error.");
            }
        }
        String localName = element.getLocalName();
        if (element.getNamespaceURI().equals("http://purl.org/dc/terms/") && !localName.equals(KEYWORD_CREATED) && !localName.equals(KEYWORD_MODIFIED)) {
            throw new InvalidFormatException("OPC Compliance error [M4.3]: Producers shall not create a document element that contains refinements to the Dublin Core elements, except for the two specified in the schema: <dcterms:created> and <dcterms:modified> Consumers shall consider a document element that violates this constraint to be an error.");
        }
        if (element.getAttributeNodeNS(XMLConstants.XML_NS_URI, "lang") != null) {
            throw new InvalidFormatException("OPC Compliance error [M4.4]: Producers shall not create a document element that contains the xml:lang attribute. Consumers shall consider a document element that violates this constraint to be an error.");
        }
        if (element.getNamespaceURI().equals("http://purl.org/dc/terms/")) {
            if (!localName.equals(KEYWORD_CREATED) && !localName.equals(KEYWORD_MODIFIED)) {
                throw new InvalidFormatException("Namespace error : " + localName + " shouldn't have the following naemspace -> http://purl.org/dc/terms/");
            }
            Attr attributeNodeNS = element.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (attributeNodeNS == null) {
                throw new InvalidFormatException("The element '" + localName + "' must have the 'xsi:type' attribute present !");
            }
            if (!attributeNodeNS.getValue().equals(element.getPrefix() + ":W3CDTF")) {
                throw new InvalidFormatException("The element '" + localName + "' must have the 'xsi:type' attribute with the value '" + element.getPrefix() + ":W3CDTF', but had '" + attributeNodeNS.getValue() + "' !");
            }
        }
        NodeList elementsByTagName = element.getElementsByTagName("*");
        int length2 = elementsByTagName.getLength();
        for (int i2 = 0; i2 < length2; i2++) {
            checkElementForOPCCompliance((Element) elementsByTagName.item(i2));
        }
    }
}
