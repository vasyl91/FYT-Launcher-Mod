package org.apache.poi.openxml4j.opc.internal.marshallers;

import java.io.OutputStream;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.events.Namespace;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.util.Nullable;
import org.apache.poi.util.DocumentHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class PackagePropertiesMarshaller implements PartMarshaller {
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
    private static final Namespace namespaceCoreProperties;
    private static final Namespace namespaceDC;
    private static final Namespace namespaceDcTerms;
    private static final Namespace namespaceXSI;
    PackagePropertiesPart propsPart;
    Document xmlDoc = null;

    static {
        XMLEventFactory xMLEventFactoryNewInstance = XMLEventFactory.newInstance();
        namespaceDC = xMLEventFactoryNewInstance.createNamespace("dc", "http://purl.org/dc/elements/1.1/");
        namespaceCoreProperties = xMLEventFactoryNewInstance.createNamespace("cp", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
        namespaceDcTerms = xMLEventFactoryNewInstance.createNamespace("dcterms", "http://purl.org/dc/terms/");
        namespaceXSI = xMLEventFactoryNewInstance.createNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    }

    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart packagePart, OutputStream outputStream) throws OpenXML4JException {
        if (!(packagePart instanceof PackagePropertiesPart)) {
            throw new IllegalArgumentException("'part' must be a PackagePropertiesPart instance.");
        }
        this.propsPart = (PackagePropertiesPart) packagePart;
        Document documentCreateDocument = DocumentHelper.createDocument();
        this.xmlDoc = documentCreateDocument;
        Namespace namespace = namespaceCoreProperties;
        Element elementCreateElementNS = documentCreateDocument.createElementNS(namespace.getNamespaceURI(), getQName("coreProperties", namespace));
        DocumentHelper.addNamespaceDeclaration(elementCreateElementNS, namespace);
        DocumentHelper.addNamespaceDeclaration(elementCreateElementNS, namespaceDC);
        DocumentHelper.addNamespaceDeclaration(elementCreateElementNS, namespaceDcTerms);
        DocumentHelper.addNamespaceDeclaration(elementCreateElementNS, namespaceXSI);
        this.xmlDoc.appendChild(elementCreateElementNS);
        addCategory();
        addContentStatus();
        addContentType();
        addCreated();
        addCreator();
        addDescription();
        addIdentifier();
        addKeywords();
        addLanguage();
        addLastModifiedBy();
        addLastPrinted();
        addModified();
        addRevision();
        addSubject();
        addTitle();
        addVersion();
        return true;
    }

    private Element setElementTextContent(String str, Namespace namespace, Nullable<String> nullable) {
        return setElementTextContent(str, namespace, nullable, nullable.getValue());
    }

    private String getQName(String str, Namespace namespace) {
        return namespace.getPrefix().isEmpty() ? str : namespace.getPrefix() + ':' + str;
    }

    private Element setElementTextContent(String str, Namespace namespace, Nullable<?> nullable, String str2) {
        if (!nullable.hasValue()) {
            return null;
        }
        Element documentElement = this.xmlDoc.getDocumentElement();
        Element elementCreateElementNS = (Element) documentElement.getElementsByTagNameNS(namespace.getNamespaceURI(), str).item(0);
        if (elementCreateElementNS == null) {
            elementCreateElementNS = this.xmlDoc.createElementNS(namespace.getNamespaceURI(), getQName(str, namespace));
            documentElement.appendChild(elementCreateElementNS);
        }
        elementCreateElementNS.setTextContent(str2);
        return elementCreateElementNS;
    }

    private Element setElementTextContent(String str, Namespace namespace, Nullable<?> nullable, String str2, String str3) {
        Element elementTextContent = setElementTextContent(str, namespace, nullable, str2);
        if (elementTextContent != null) {
            Namespace namespace2 = namespaceXSI;
            elementTextContent.setAttributeNS(namespace2.getNamespaceURI(), getQName("type", namespace2), str3);
        }
        return elementTextContent;
    }

    private void addCategory() {
        setElementTextContent(KEYWORD_CATEGORY, namespaceCoreProperties, this.propsPart.getCategoryProperty());
    }

    private void addContentStatus() {
        setElementTextContent(KEYWORD_CONTENT_STATUS, namespaceCoreProperties, this.propsPart.getContentStatusProperty());
    }

    private void addContentType() {
        setElementTextContent(KEYWORD_CONTENT_TYPE, namespaceCoreProperties, this.propsPart.getContentTypeProperty());
    }

    private void addCreated() {
        setElementTextContent(KEYWORD_CREATED, namespaceDcTerms, this.propsPart.getCreatedProperty(), this.propsPart.getCreatedPropertyString(), "dcterms:W3CDTF");
    }

    private void addCreator() {
        setElementTextContent(KEYWORD_CREATOR, namespaceDC, this.propsPart.getCreatorProperty());
    }

    private void addDescription() {
        setElementTextContent(KEYWORD_DESCRIPTION, namespaceDC, this.propsPart.getDescriptionProperty());
    }

    private void addIdentifier() {
        setElementTextContent(KEYWORD_IDENTIFIER, namespaceDC, this.propsPart.getIdentifierProperty());
    }

    private void addKeywords() {
        setElementTextContent(KEYWORD_KEYWORDS, namespaceCoreProperties, this.propsPart.getKeywordsProperty());
    }

    private void addLanguage() {
        setElementTextContent(KEYWORD_LANGUAGE, namespaceDC, this.propsPart.getLanguageProperty());
    }

    private void addLastModifiedBy() {
        setElementTextContent(KEYWORD_LAST_MODIFIED_BY, namespaceCoreProperties, this.propsPart.getLastModifiedByProperty());
    }

    private void addLastPrinted() {
        setElementTextContent(KEYWORD_LAST_PRINTED, namespaceCoreProperties, this.propsPart.getLastPrintedProperty(), this.propsPart.getLastPrintedPropertyString());
    }

    private void addModified() {
        setElementTextContent(KEYWORD_MODIFIED, namespaceDcTerms, this.propsPart.getModifiedProperty(), this.propsPart.getModifiedPropertyString(), "dcterms:W3CDTF");
    }

    private void addRevision() {
        setElementTextContent(KEYWORD_REVISION, namespaceCoreProperties, this.propsPart.getRevisionProperty());
    }

    private void addSubject() {
        setElementTextContent(KEYWORD_SUBJECT, namespaceDC, this.propsPart.getSubjectProperty());
    }

    private void addTitle() {
        setElementTextContent(KEYWORD_TITLE, namespaceDC, this.propsPart.getTitleProperty());
    }

    private void addVersion() {
        setElementTextContent(KEYWORD_VERSION, namespaceCoreProperties, this.propsPart.getVersionProperty());
    }
}
