package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.DocumentHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class ContentTypeManager {
    public static final String CONTENT_TYPES_PART_NAME = "[Content_Types].xml";
    private static final String CONTENT_TYPE_ATTRIBUTE_NAME = "ContentType";
    private static final String DEFAULT_TAG_NAME = "Default";
    private static final String EXTENSION_ATTRIBUTE_NAME = "Extension";
    private static final String OVERRIDE_TAG_NAME = "Override";
    private static final String PART_NAME_ATTRIBUTE_NAME = "PartName";
    public static final String TYPES_NAMESPACE_URI = "http://schemas.openxmlformats.org/package/2006/content-types";
    private static final String TYPES_TAG_NAME = "Types";
    protected OPCPackage container;
    private TreeMap<String, String> defaultContentType = new TreeMap<>();
    private TreeMap<PackagePartName, String> overrideContentType;

    public abstract boolean saveImpl(Document document, OutputStream outputStream);

    public ContentTypeManager(InputStream inputStream, OPCPackage oPCPackage) throws InvalidFormatException {
        this.container = oPCPackage;
        if (inputStream != null) {
            try {
                parseContentTypesFile(inputStream);
            } catch (InvalidFormatException e) {
                InvalidFormatException invalidFormatException = new InvalidFormatException("Can't read content types part !");
                invalidFormatException.initCause(e);
                throw invalidFormatException;
            }
        }
    }

    public void addContentType(PackagePartName packagePartName, String str) {
        boolean zContainsValue = this.defaultContentType.containsValue(str);
        String lowerCase = packagePartName.getExtension().toLowerCase(Locale.ROOT);
        if (lowerCase.length() == 0 || (this.defaultContentType.containsKey(lowerCase) && !zContainsValue)) {
            addOverrideContentType(packagePartName, str);
        } else {
            if (zContainsValue) {
                return;
            }
            addDefaultContentType(lowerCase, str);
        }
    }

    private void addOverrideContentType(PackagePartName packagePartName, String str) {
        if (this.overrideContentType == null) {
            this.overrideContentType = new TreeMap<>();
        }
        this.overrideContentType.put(packagePartName, str);
    }

    private void addDefaultContentType(String str, String str2) {
        this.defaultContentType.put(str.toLowerCase(Locale.ROOT), str2);
    }

    public void removeContentType(PackagePartName packagePartName) throws InvalidOperationException {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null && treeMap.get(packagePartName) != null) {
            this.overrideContentType.remove(packagePartName);
            return;
        }
        String extension = packagePartName.getExtension();
        OPCPackage oPCPackage = this.container;
        boolean z = true;
        if (oPCPackage != null) {
            try {
                for (PackagePart packagePart : oPCPackage.getParts()) {
                    if (!packagePart.getPartName().equals(packagePartName) && packagePart.getPartName().getExtension().equalsIgnoreCase(extension)) {
                        z = false;
                        break;
                    }
                }
            } catch (InvalidFormatException e) {
                throw new InvalidOperationException(e.getMessage());
            }
        }
        if (z) {
            this.defaultContentType.remove(extension);
        }
        OPCPackage oPCPackage2 = this.container;
        if (oPCPackage2 != null) {
            try {
                for (PackagePart packagePart2 : oPCPackage2.getParts()) {
                    if (!packagePart2.getPartName().equals(packagePartName) && getContentType(packagePart2.getPartName()) == null) {
                        throw new InvalidOperationException("Rule M2.4 is not respected: Nor a default element or override element is associated with the part: " + packagePart2.getPartName().getName());
                    }
                }
            } catch (InvalidFormatException e2) {
                throw new InvalidOperationException(e2.getMessage());
            }
        }
    }

    public boolean isContentTypeRegister(String str) {
        TreeMap<PackagePartName, String> treeMap;
        if (str != null) {
            return this.defaultContentType.values().contains(str) || ((treeMap = this.overrideContentType) != null && treeMap.values().contains(str));
        }
        throw new IllegalArgumentException("contentType");
    }

    public String getContentType(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null && treeMap.containsKey(packagePartName)) {
            return this.overrideContentType.get(packagePartName);
        }
        String lowerCase = packagePartName.getExtension().toLowerCase(Locale.ROOT);
        if (this.defaultContentType.containsKey(lowerCase)) {
            return this.defaultContentType.get(lowerCase);
        }
        OPCPackage oPCPackage = this.container;
        if (oPCPackage == null || oPCPackage.getPart(packagePartName) == null) {
            return null;
        }
        throw new OpenXML4JRuntimeException("Rule M2.4 exception : this error should NEVER happen! If you can provide the triggering file, then please raise a bug at https://bz.apache.org/bugzilla/enter_bug.cgi?product=POI and attach the file that triggers it, thanks!");
    }

    public void clearAll() {
        this.defaultContentType.clear();
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null) {
            treeMap.clear();
        }
    }

    public void clearOverrideContentTypes() {
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null) {
            treeMap.clear();
        }
    }

    private void parseContentTypesFile(InputStream inputStream) throws InvalidFormatException {
        try {
            Document document = DocumentHelper.readDocument(inputStream);
            NodeList elementsByTagNameNS = document.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", DEFAULT_TAG_NAME);
            int length = elementsByTagNameNS.getLength();
            for (int i = 0; i < length; i++) {
                Element element = (Element) elementsByTagNameNS.item(i);
                addDefaultContentType(element.getAttribute(EXTENSION_ATTRIBUTE_NAME), element.getAttribute(CONTENT_TYPE_ATTRIBUTE_NAME));
            }
            NodeList elementsByTagNameNS2 = document.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", OVERRIDE_TAG_NAME);
            int length2 = elementsByTagNameNS2.getLength();
            for (int i2 = 0; i2 < length2; i2++) {
                Element element2 = (Element) elementsByTagNameNS2.item(i2);
                addOverrideContentType(PackagingURIHelper.createPartName(new URI(element2.getAttribute(PART_NAME_ATTRIBUTE_NAME))), element2.getAttribute(CONTENT_TYPE_ATTRIBUTE_NAME));
            }
        } catch (IOException e) {
            throw new InvalidFormatException(e.getMessage());
        } catch (URISyntaxException e2) {
            throw new InvalidFormatException(e2.getMessage());
        } catch (SAXException e3) {
            throw new InvalidFormatException(e3.getMessage());
        }
    }

    public boolean save(OutputStream outputStream) {
        Document documentCreateDocument = DocumentHelper.createDocument();
        Element elementCreateElementNS = documentCreateDocument.createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", TYPES_TAG_NAME);
        documentCreateDocument.appendChild(elementCreateElementNS);
        Iterator<Map.Entry<String, String>> it = this.defaultContentType.entrySet().iterator();
        while (it.hasNext()) {
            appendDefaultType(elementCreateElementNS, it.next());
        }
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null) {
            Iterator<Map.Entry<PackagePartName, String>> it2 = treeMap.entrySet().iterator();
            while (it2.hasNext()) {
                appendSpecificTypes(elementCreateElementNS, it2.next());
            }
        }
        documentCreateDocument.normalize();
        return saveImpl(documentCreateDocument, outputStream);
    }

    private void appendSpecificTypes(Element element, Map.Entry<PackagePartName, String> entry) {
        Element elementCreateElementNS = element.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", OVERRIDE_TAG_NAME);
        elementCreateElementNS.setAttribute(PART_NAME_ATTRIBUTE_NAME, entry.getKey().getName());
        elementCreateElementNS.setAttribute(CONTENT_TYPE_ATTRIBUTE_NAME, entry.getValue());
        element.appendChild(elementCreateElementNS);
    }

    private void appendDefaultType(Element element, Map.Entry<String, String> entry) {
        Element elementCreateElementNS = element.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", DEFAULT_TAG_NAME);
        elementCreateElementNS.setAttribute(EXTENSION_ATTRIBUTE_NAME, entry.getKey());
        elementCreateElementNS.setAttribute(CONTENT_TYPE_ATTRIBUTE_NAME, entry.getValue());
        element.appendChild(elementCreateElementNS);
    }
}
