package org.apache.xmlbeans.impl.schema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.common.XmlEncodingSniffer;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StscImporter {
    private static final String PROJECT_URL_PREFIX = "project://local";

    public static SchemaToProcess[] resolveImportsAndIncludes(SchemaDocument.Schema[] schemaArr, boolean z) {
        return new DownloadTable(schemaArr).resolveImportsAndIncludes(z);
    }

    public static class SchemaToProcess {
        private String chameleonNamespace;
        private List includes;
        private Set indirectIncludedBy;
        private Set indirectIncludes;
        private List redefineObjects;
        private List redefines;
        private SchemaDocument.Schema schema;

        public SchemaToProcess(SchemaDocument.Schema schema, String str) {
            this.schema = schema;
            this.chameleonNamespace = str;
        }

        public SchemaDocument.Schema getSchema() {
            return this.schema;
        }

        public String getSourceName() {
            return this.schema.documentProperties().getSourceName();
        }

        public String getChameleonNamespace() {
            return this.chameleonNamespace;
        }

        public List getRedefines() {
            return this.redefines;
        }

        public List getRedefineObjects() {
            return this.redefineObjects;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addInclude(SchemaToProcess schemaToProcess) {
            if (this.includes == null) {
                this.includes = new ArrayList();
            }
            this.includes.add(schemaToProcess);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRedefine(SchemaToProcess schemaToProcess, RedefineDocument.Redefine redefine) {
            if (this.redefines == null || this.redefineObjects == null) {
                this.redefines = new ArrayList();
                this.redefineObjects = new ArrayList();
            }
            this.redefines.add(schemaToProcess);
            this.redefineObjects.add(redefine);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void buildIndirectReferences() {
            if (this.includes != null) {
                for (int i = 0; i < this.includes.size(); i++) {
                    addIndirectIncludes((SchemaToProcess) this.includes.get(i));
                }
            }
            if (this.redefines != null) {
                for (int i2 = 0; i2 < this.redefines.size(); i2++) {
                    addIndirectIncludes((SchemaToProcess) this.redefines.get(i2));
                }
            }
        }

        private void addIndirectIncludes(SchemaToProcess schemaToProcess) {
            if (this.indirectIncludes == null) {
                this.indirectIncludes = new HashSet();
            }
            this.indirectIncludes.add(schemaToProcess);
            if (schemaToProcess.indirectIncludedBy == null) {
                schemaToProcess.indirectIncludedBy = new HashSet();
            }
            schemaToProcess.indirectIncludedBy.add(this);
            addIndirectIncludesHelper(this, schemaToProcess);
            Set<SchemaToProcess> set = this.indirectIncludedBy;
            if (set != null) {
                for (SchemaToProcess schemaToProcess2 : set) {
                    schemaToProcess2.indirectIncludes.add(schemaToProcess);
                    schemaToProcess.indirectIncludedBy.add(schemaToProcess2);
                    addIndirectIncludesHelper(schemaToProcess2, schemaToProcess);
                }
            }
        }

        private static void addIndirectIncludesHelper(SchemaToProcess schemaToProcess, SchemaToProcess schemaToProcess2) {
            Set<SchemaToProcess> set = schemaToProcess2.indirectIncludes;
            if (set != null) {
                for (SchemaToProcess schemaToProcess3 : set) {
                    schemaToProcess.indirectIncludes.add(schemaToProcess3);
                    schemaToProcess3.indirectIncludedBy.add(schemaToProcess);
                }
            }
        }

        public boolean indirectIncludes(SchemaToProcess schemaToProcess) {
            Set set = this.indirectIncludes;
            return set != null && set.contains(schemaToProcess);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SchemaToProcess)) {
                return false;
            }
            SchemaToProcess schemaToProcess = (SchemaToProcess) obj;
            String str = this.chameleonNamespace;
            if (str == null ? schemaToProcess.chameleonNamespace == null : str.equals(schemaToProcess.chameleonNamespace)) {
                return this.schema == schemaToProcess.schema;
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = this.schema.hashCode() * 29;
            String str = this.chameleonNamespace;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String baseURLForDoc(XmlObject xmlObject) {
        String sourceName = xmlObject.documentProperties().getSourceName();
        if (sourceName == null) {
            return null;
        }
        if (sourceName.startsWith("/")) {
            return PROJECT_URL_PREFIX + sourceName.replace('\\', '/');
        }
        int iIndexOf = sourceName.indexOf(58);
        return (iIndexOf <= 1 || !sourceName.substring(0, iIndexOf).matches("^\\w+$")) ? "project://local/" + sourceName.replace('\\', '/') : sourceName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URI parseURI(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static URI resolve(URI uri, String str) throws URISyntaxException {
        URI uri2 = new URI(str);
        URI uriResolve = uri.resolve(uri2);
        if (uri2.equals(uriResolve) && !uri2.isAbsolute() && (uri.getScheme().equals("jar") || uri.getScheme().equals("zip"))) {
            String string = uri.toString();
            String strConcat = string.substring(0, string.lastIndexOf(47)) + "/" + uri2;
            int iLastIndexOf = strConcat.lastIndexOf("!/");
            if (iLastIndexOf > 0) {
                for (int iIndexOf = strConcat.indexOf("/..", iLastIndexOf); iIndexOf > 0; iIndexOf = strConcat.indexOf("/..", iLastIndexOf)) {
                    int iLastIndexOf2 = strConcat.lastIndexOf("/", iIndexOf - 1);
                    if (iLastIndexOf2 >= iLastIndexOf) {
                        strConcat = strConcat.substring(0, iLastIndexOf2).concat(strConcat.substring(iIndexOf + 3));
                    }
                }
            }
            return URI.create(strConcat);
        }
        if (!"file".equals(uriResolve.getScheme()) || str.equals(uriResolve) || !uri.getPath().startsWith("//") || uriResolve.getPath().startsWith("//")) {
            return uriResolve;
        }
        try {
            return new URI("file", null, "///".concat(uriResolve.getPath()), uriResolve.getQuery(), uriResolve.getFragment());
        } catch (URISyntaxException unused) {
            return uriResolve;
        }
    }

    public static class DownloadTable {
        private Map schemaByNsLocPair = new HashMap();
        private Map schemaByDigestKey = new HashMap();
        private LinkedList scanNeeded = new LinkedList();
        private Set emptyNamespaceSchemas = new HashSet();
        private Map scannedAlready = new HashMap();
        private Set failedDownloads = new HashSet();

        private static String emptyStringIfNull(String str) {
            return str == null ? "" : str;
        }

        private static class NsLocPair {
            private String locationURL;
            private String namespaceURI;

            public NsLocPair(String str, String str2) {
                this.namespaceURI = str;
                this.locationURL = str2;
            }

            public String getNamespaceURI() {
                return this.namespaceURI;
            }

            public String getLocationURL() {
                return this.locationURL;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NsLocPair)) {
                    return false;
                }
                NsLocPair nsLocPair = (NsLocPair) obj;
                String str = this.locationURL;
                if (str == null ? nsLocPair.locationURL != null : !str.equals(nsLocPair.locationURL)) {
                    return false;
                }
                String str2 = this.namespaceURI;
                String str3 = nsLocPair.namespaceURI;
                return str2 == null ? str3 == null : str2.equals(str3);
            }

            public int hashCode() {
                String str = this.namespaceURI;
                int iHashCode = (str != null ? str.hashCode() : 0) * 29;
                String str2 = this.locationURL;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }
        }

        private static class DigestKey {
            byte[] _digest;
            int _hashCode;

            DigestKey(byte[] bArr) {
                this._digest = bArr;
                for (int i = 0; i < 4 && i < bArr.length; i++) {
                    this._hashCode = (this._hashCode << 8) + bArr[i];
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DigestKey) {
                    return Arrays.equals(this._digest, ((DigestKey) obj)._digest);
                }
                return false;
            }

            public int hashCode() {
                return this._hashCode;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
        private SchemaDocument.Schema downloadSchema(XmlObject xmlObject, String str, String str2) {
            SchemaDocument.Schema schema;
            SchemaDocument.Schema schema2;
            SchemaDocument.Schema schema3;
            if (str2 == null) {
                return null;
            }
            StscState stscState = StscState.get();
            URI uri = StscImporter.parseURI(StscImporter.baseURLForDoc(xmlObject));
            if (uri != null) {
                try {
                    str2 = StscImporter.resolve(uri, str2).toString();
                } catch (URISyntaxException e) {
                    stscState.error("Could not find resource - invalid location URL: " + e.getMessage(), 56, xmlObject);
                    return null;
                }
            }
            if (stscState.isFileProcessed(str2)) {
                return null;
            }
            if (str2 != null && str != null && (schema3 = (SchemaDocument.Schema) this.schemaByNsLocPair.get(new NsLocPair(str, str2))) != null) {
                return schema3;
            }
            if (str != null && !str.equals("")) {
                if (!stscState.shouldDownloadURI(str2) && (schema2 = (SchemaDocument.Schema) this.schemaByNsLocPair.get(new NsLocPair(str, null))) != null) {
                    return schema2;
                }
                if (stscState.linkerDefinesNamespace(str)) {
                    return null;
                }
            }
            if (str2 != null && (schema = (SchemaDocument.Schema) this.schemaByNsLocPair.get(new NsLocPair(null, str2))) != null) {
                return schema;
            }
            if (str2 == null) {
                stscState.error("Could not find resource - no valid location URL.", 56, xmlObject);
                return null;
            }
            if (previouslyFailedToDownload(str2)) {
                return null;
            }
            if (!stscState.shouldDownloadURI(str2)) {
                stscState.error("Could not load resource \"" + str2 + "\" (network downloads disabled).", 56, xmlObject);
                addFailedDownload(str2);
                return null;
            }
            try {
                XmlObject xmlObjectDownloadDocument = downloadDocument(stscState.getS4SLoader(), str, str2);
                SchemaDocument.Schema schemaFindMatchByDigest = findMatchByDigest(xmlObjectDownloadDocument);
                String strRelativize = stscState.relativize(str2);
                if (schemaFindMatchByDigest != null) {
                    String strRelativize2 = stscState.relativize(schemaFindMatchByDigest.documentProperties().getSourceName());
                    if (strRelativize2 != null) {
                        stscState.info(strRelativize + " is the same as " + strRelativize2 + " (ignoring the duplicate file)");
                    } else {
                        stscState.info(strRelativize + " is the same as another schema");
                    }
                } else {
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setErrorListener(stscState.getErrorListener());
                    if ((xmlObjectDownloadDocument instanceof SchemaDocument) && xmlObjectDownloadDocument.validate(xmlOptions)) {
                        schemaFindMatchByDigest = ((SchemaDocument) xmlObjectDownloadDocument).getSchema();
                        stscState.info("Loading referenced file " + strRelativize);
                    }
                    stscState.error("Referenced document is not a valid schema", 56, xmlObject);
                    addFailedDownload(str2);
                    return null;
                }
                addSuccessfulDownload(new NsLocPair(emptyStringIfNull(schemaFindMatchByDigest.getTargetNamespace()), str2), schemaFindMatchByDigest);
                return schemaFindMatchByDigest;
            } catch (XmlException e2) {
                stscState.error("Problem parsing referenced XML resource - " + e2.getMessage(), 56, xmlObject);
            } catch (MalformedURLException unused) {
                stscState.error("URL \"" + str2 + "\" is not well-formed", 56, xmlObject);
            } catch (IOException e3) {
                stscState.error(e3.toString(), 56, xmlObject);
            }
        }

        static XmlObject downloadDocument(SchemaTypeLoader schemaTypeLoader, String str, String str2) throws XmlException, IOException {
            StscState stscState = StscState.get();
            EntityResolver entityResolver = stscState.getEntityResolver();
            if (entityResolver != null) {
                try {
                    InputSource inputSourceResolveEntity = entityResolver.resolveEntity(str, str2);
                    if (inputSourceResolveEntity != null) {
                        stscState.addSourceUri(str2, null);
                        Reader characterStream = inputSourceResolveEntity.getCharacterStream();
                        if (characterStream != null) {
                            Reader readerCopySchemaSource = copySchemaSource(str2, characterStream, stscState);
                            XmlOptions xmlOptions = new XmlOptions();
                            xmlOptions.setLoadLineNumbers();
                            xmlOptions.setDocumentSourceName(str2);
                            return schemaTypeLoader.parse(readerCopySchemaSource, (SchemaType) null, xmlOptions);
                        }
                        InputStream byteStream = inputSourceResolveEntity.getByteStream();
                        if (byteStream != null) {
                            InputStream inputStreamCopySchemaSource = copySchemaSource(str2, byteStream, stscState);
                            String encoding = inputSourceResolveEntity.getEncoding();
                            XmlOptions xmlOptions2 = new XmlOptions();
                            xmlOptions2.setLoadLineNumbers();
                            xmlOptions2.setLoadMessageDigest();
                            xmlOptions2.setDocumentSourceName(str2);
                            if (encoding != null) {
                                xmlOptions2.setCharacterEncoding(encoding);
                            }
                            return schemaTypeLoader.parse(inputStreamCopySchemaSource, (SchemaType) null, xmlOptions2);
                        }
                        String systemId = inputSourceResolveEntity.getSystemId();
                        if (systemId == null) {
                            throw new IOException("EntityResolver unable to resolve " + str2 + " (for namespace " + str + ")");
                        }
                        copySchemaSource(str2, stscState, false);
                        XmlOptions xmlOptions3 = new XmlOptions();
                        xmlOptions3.setLoadLineNumbers();
                        xmlOptions3.setLoadMessageDigest();
                        xmlOptions3.setDocumentSourceName(str2);
                        return schemaTypeLoader.parse(new URL(systemId), (SchemaType) null, xmlOptions3);
                    }
                } catch (SAXException e) {
                    throw new XmlException(e);
                }
            }
            stscState.addSourceUri(str2, null);
            copySchemaSource(str2, stscState, false);
            XmlOptions xmlOptions4 = new XmlOptions();
            xmlOptions4.setLoadLineNumbers();
            xmlOptions4.setLoadMessageDigest();
            return schemaTypeLoader.parse(new URL(str2), (SchemaType) null, xmlOptions4);
        }

        private void addSuccessfulDownload(NsLocPair nsLocPair, SchemaDocument.Schema schema) {
            byte[] messageDigest = schema.documentProperties().getMessageDigest();
            if (messageDigest == null) {
                StscState.get().addSchemaDigest(null);
            } else {
                if (!this.schemaByDigestKey.containsKey(new DigestKey(messageDigest))) {
                    this.schemaByDigestKey.put(new DigestKey(messageDigest), schema);
                    StscState.get().addSchemaDigest(messageDigest);
                }
            }
            this.schemaByNsLocPair.put(nsLocPair, schema);
            NsLocPair nsLocPair2 = new NsLocPair(nsLocPair.getNamespaceURI(), null);
            if (!this.schemaByNsLocPair.containsKey(nsLocPair2)) {
                this.schemaByNsLocPair.put(nsLocPair2, schema);
            }
            NsLocPair nsLocPair3 = new NsLocPair(null, nsLocPair.getLocationURL());
            if (this.schemaByNsLocPair.containsKey(nsLocPair3)) {
                return;
            }
            this.schemaByNsLocPair.put(nsLocPair3, schema);
        }

        private SchemaDocument.Schema findMatchByDigest(XmlObject xmlObject) {
            byte[] messageDigest = xmlObject.documentProperties().getMessageDigest();
            if (messageDigest == null) {
                return null;
            }
            return (SchemaDocument.Schema) this.schemaByDigestKey.get(new DigestKey(messageDigest));
        }

        private void addFailedDownload(String str) {
            this.failedDownloads.add(str);
        }

        private boolean previouslyFailedToDownload(String str) {
            return this.failedDownloads.contains(str);
        }

        private static boolean nullableStringsMatch(String str, String str2) {
            if (str == null && str2 == null) {
                return true;
            }
            if (str == null || str2 == null) {
                return false;
            }
            return str.equals(str2);
        }

        private SchemaToProcess addScanNeeded(SchemaToProcess schemaToProcess) {
            if (!this.scannedAlready.containsKey(schemaToProcess)) {
                this.scannedAlready.put(schemaToProcess, schemaToProcess);
                this.scanNeeded.add(schemaToProcess);
                return schemaToProcess;
            }
            return (SchemaToProcess) this.scannedAlready.get(schemaToProcess);
        }

        private void addEmptyNamespaceSchema(SchemaDocument.Schema schema) {
            this.emptyNamespaceSchemas.add(schema);
        }

        private void usedEmptyNamespaceSchema(SchemaDocument.Schema schema) {
            this.emptyNamespaceSchemas.remove(schema);
        }

        private boolean fetchRemainingEmptyNamespaceSchemas() {
            if (this.emptyNamespaceSchemas.isEmpty()) {
                return false;
            }
            Iterator it = this.emptyNamespaceSchemas.iterator();
            while (it.hasNext()) {
                addScanNeeded(new SchemaToProcess((SchemaDocument.Schema) it.next(), null));
            }
            this.emptyNamespaceSchemas.clear();
            return true;
        }

        private boolean hasNextToScan() {
            return !this.scanNeeded.isEmpty();
        }

        private SchemaToProcess nextToScan() {
            return (SchemaToProcess) this.scanNeeded.removeFirst();
        }

        public DownloadTable(SchemaDocument.Schema[] schemaArr) {
            for (int i = 0; i < schemaArr.length; i++) {
                String targetNamespace = schemaArr[i].getTargetNamespace();
                addSuccessfulDownload(new NsLocPair(targetNamespace, StscImporter.baseURLForDoc(schemaArr[i])), schemaArr[i]);
                if (targetNamespace != null) {
                    addScanNeeded(new SchemaToProcess(schemaArr[i], null));
                } else {
                    addEmptyNamespaceSchema(schemaArr[i]);
                }
            }
        }

        public SchemaToProcess[] resolveImportsAndIncludes(boolean z) {
            StscState stscState = StscState.get();
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            while (true) {
                if (hasNextToScan()) {
                    SchemaToProcess schemaToProcessNextToScan = nextToScan();
                    String sourceName = schemaToProcessNextToScan.getSourceName();
                    String str = null;
                    stscState.addSourceUri(sourceName, null);
                    arrayList.add(schemaToProcessNextToScan);
                    copySchemaSource(sourceName, stscState, z);
                    ImportDocument.Import[] importArray = schemaToProcessNextToScan.getSchema().getImportArray();
                    for (int i = 0; i < importArray.length; i++) {
                        ImportDocument.Import r10 = importArray[i];
                        SchemaDocument.Schema schemaDownloadSchema = downloadSchema(r10, emptyStringIfNull(r10.getNamespace()), importArray[i].getSchemaLocation());
                        if (schemaDownloadSchema != null) {
                            if (!nullableStringsMatch(schemaDownloadSchema.getTargetNamespace(), importArray[i].getNamespace())) {
                                StscState.get().error("Imported schema has a target namespace \"" + schemaDownloadSchema.getTargetNamespace() + "\" that does not match the specified \"" + importArray[i].getNamespace() + "\"", 4, importArray[i]);
                            } else {
                                addScanNeeded(new SchemaToProcess(schemaDownloadSchema, null));
                            }
                        }
                    }
                    IncludeDocument.Include[] includeArray = schemaToProcessNextToScan.getSchema().getIncludeArray();
                    String chameleonNamespace = schemaToProcessNextToScan.getChameleonNamespace();
                    if (chameleonNamespace == null) {
                        chameleonNamespace = emptyStringIfNull(schemaToProcessNextToScan.getSchema().getTargetNamespace());
                    }
                    int i2 = 0;
                    while (i2 < includeArray.length) {
                        IncludeDocument.Include include = includeArray[i2];
                        SchemaDocument.Schema schemaDownloadSchema2 = downloadSchema(include, str, include.getSchemaLocation());
                        if (schemaDownloadSchema2 != null) {
                            if (emptyStringIfNull(schemaDownloadSchema2.getTargetNamespace()).equals(chameleonNamespace)) {
                                schemaToProcessNextToScan.addInclude(addScanNeeded(new SchemaToProcess(schemaDownloadSchema2, str)));
                            } else if (schemaDownloadSchema2.getTargetNamespace() == null) {
                                schemaToProcessNextToScan.addInclude(addScanNeeded(new SchemaToProcess(schemaDownloadSchema2, chameleonNamespace)));
                                usedEmptyNamespaceSchema(schemaDownloadSchema2);
                            } else {
                                StscState.get().error("Included schema has a target namespace \"" + schemaDownloadSchema2.getTargetNamespace() + "\" that does not match the source namespace \"" + chameleonNamespace + "\"", 4, includeArray[i2]);
                            }
                        }
                        i2++;
                        str = null;
                    }
                    RedefineDocument.Redefine[] redefineArray = schemaToProcessNextToScan.getSchema().getRedefineArray();
                    String chameleonNamespace2 = schemaToProcessNextToScan.getChameleonNamespace();
                    if (chameleonNamespace2 == null) {
                        chameleonNamespace2 = emptyStringIfNull(schemaToProcessNextToScan.getSchema().getTargetNamespace());
                    }
                    for (int i3 = 0; i3 < redefineArray.length; i3++) {
                        RedefineDocument.Redefine redefine = redefineArray[i3];
                        SchemaDocument.Schema schemaDownloadSchema3 = downloadSchema(redefine, null, redefine.getSchemaLocation());
                        if (schemaDownloadSchema3 != null) {
                            if (emptyStringIfNull(schemaDownloadSchema3.getTargetNamespace()).equals(chameleonNamespace2)) {
                                schemaToProcessNextToScan.addRedefine(addScanNeeded(new SchemaToProcess(schemaDownloadSchema3, null)), redefineArray[i3]);
                            } else if (schemaDownloadSchema3.getTargetNamespace() == null) {
                                schemaToProcessNextToScan.addRedefine(addScanNeeded(new SchemaToProcess(schemaDownloadSchema3, chameleonNamespace2)), redefineArray[i3]);
                                usedEmptyNamespaceSchema(schemaDownloadSchema3);
                            } else {
                                StscState.get().error("Redefined schema has a target namespace \"" + schemaDownloadSchema3.getTargetNamespace() + "\" that does not match the source namespace \"" + chameleonNamespace2 + "\"", 4, redefineArray[i3]);
                            }
                            z2 = true;
                        }
                    }
                } else if (!fetchRemainingEmptyNamespaceSchemas()) {
                    break;
                }
            }
            if (z2) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    ((SchemaToProcess) arrayList.get(i4)).buildIndirectReferences();
                }
            }
            return (SchemaToProcess[]) arrayList.toArray(new SchemaToProcess[arrayList.size()]);
        }

        private static Reader copySchemaSource(String str, Reader reader, StscState stscState) {
            if (stscState.getSchemasDir() == null) {
                return reader;
            }
            File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
            if (file.exists()) {
                return reader;
            }
            try {
                IOUtil.createDir(new File(file.getParent()), null);
                CharArrayReader charArrayReaderCopy = copy(reader);
                IOUtil.copyCompletely(charArrayReaderCopy, new OutputStreamWriter(new FileOutputStream(file), new XmlEncodingSniffer(charArrayReaderCopy, (String) null).getXmlEncoding()));
                charArrayReaderCopy.reset();
                return charArrayReaderCopy;
            } catch (IOException e) {
                System.err.println("IO Error " + e);
                return reader;
            }
        }

        private static InputStream copySchemaSource(String str, InputStream inputStream, StscState stscState) {
            if (stscState.getSchemasDir() == null) {
                return inputStream;
            }
            File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
            if (file.exists()) {
                return inputStream;
            }
            try {
                IOUtil.createDir(new File(file.getParent()), null);
                ByteArrayInputStream byteArrayInputStreamCopy = copy(inputStream);
                IOUtil.copyCompletely(byteArrayInputStreamCopy, new FileOutputStream(file));
                byteArrayInputStreamCopy.reset();
                return byteArrayInputStreamCopy;
            } catch (IOException e) {
                System.err.println("IO Error " + e);
                return inputStream;
            }
        }

        private static void copySchemaSource(String str, StscState stscState, boolean z) {
            if (stscState.getSchemasDir() != null) {
                File file = new File(stscState.getSchemasDir(), stscState.sourceNameForUri(str));
                if (z || !file.exists()) {
                    try {
                        InputStream inputStreamOpenStream = null;
                        IOUtil.createDir(new File(file.getParent()), null);
                        try {
                            inputStreamOpenStream = new URL(str).openStream();
                        } catch (FileNotFoundException e) {
                            if (z && file.exists()) {
                                file.delete();
                            } else {
                                throw e;
                            }
                        }
                        if (inputStreamOpenStream != null) {
                            IOUtil.copyCompletely(inputStreamOpenStream, new FileOutputStream(file));
                        }
                    } catch (IOException e2) {
                        System.err.println("IO Error " + e2);
                    }
                }
            }
        }

        private static ByteArrayInputStream copy(InputStream inputStream) throws IOException {
            byte[] bArr = new byte[XMLEvent.START_PREFIX_MAPPING];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = inputStream.read(bArr, 0, XMLEvent.START_PREFIX_MAPPING);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
            }
        }

        private static CharArrayReader copy(Reader reader) throws IOException {
            char[] cArr = new char[XMLEvent.START_PREFIX_MAPPING];
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                int i = reader.read(cArr, 0, XMLEvent.START_PREFIX_MAPPING);
                if (i > 0) {
                    charArrayWriter.write(cArr, 0, i);
                } else {
                    return new CharArrayReader(charArrayWriter.toCharArray());
                }
            }
        }
    }
}
