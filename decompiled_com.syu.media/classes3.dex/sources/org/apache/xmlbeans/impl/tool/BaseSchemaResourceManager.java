package org.apache.xmlbeans.impl.tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class BaseSchemaResourceManager extends SchemaImportResolver {
    private static final String USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";
    private String _defaultCopyDirectory;
    private DownloadedSchemasDocument _importsDoc;
    private Map _resourceForFilename = new HashMap();
    private Map _resourceForURL = new HashMap();
    private Map _resourceForNamespace = new HashMap();
    private Map _resourceForDigest = new HashMap();
    private Map _resourceForCacheEntry = new HashMap();
    private Set _redownloadSet = new HashSet();

    protected abstract void deleteFile(String str);

    protected abstract boolean fileExists(String str);

    protected abstract String[] getAllXSDFilenames();

    protected String getDefaultSchemaDir() {
        return "./schema";
    }

    protected String getIndexFilename() {
        return "./xsdownload.xml";
    }

    protected abstract InputStream inputStreamForFile(String str) throws IOException;

    protected abstract void warning(String str);

    protected abstract void writeInputStreamToFile(InputStream inputStream, String str) throws IOException;

    protected BaseSchemaResourceManager() {
    }

    protected final void init() {
        if (fileExists(getIndexFilename())) {
            try {
                this._importsDoc = DownloadedSchemasDocument.Factory.parse(inputStreamForFile(getIndexFilename()));
            } catch (IOException unused) {
                this._importsDoc = null;
            } catch (Exception e) {
                throw ((IllegalStateException) new IllegalStateException("Problem reading xsdownload.xml: please fix or delete this file").initCause(e));
            }
        }
        if (this._importsDoc == null) {
            try {
                this._importsDoc = DownloadedSchemasDocument.Factory.parse("<dls:downloaded-schemas xmlns:dls='http://www.bea.com/2003/01/xmlbean/xsdownload' defaultDirectory='" + getDefaultSchemaDir() + "'/>");
            } catch (Exception e2) {
                throw ((IllegalStateException) new IllegalStateException().initCause(e2));
            }
        }
        String defaultDirectory = this._importsDoc.getDownloadedSchemas().getDefaultDirectory();
        if (defaultDirectory == null) {
            defaultDirectory = getDefaultSchemaDir();
        }
        this._defaultCopyDirectory = defaultDirectory;
        for (DownloadedSchemaEntry downloadedSchemaEntry : this._importsDoc.getDownloadedSchemas().getEntryArray()) {
            updateResource(downloadedSchemaEntry);
        }
    }

    public final void writeCache() throws IOException {
        writeInputStreamToFile(this._importsDoc.newInputStream(new XmlOptions().setSavePrettyPrint()), getIndexFilename());
    }

    public final void processAll(boolean z, boolean z2, boolean z3) {
        if (z2) {
            this._redownloadSet = new HashSet();
        } else {
            this._redownloadSet = null;
        }
        String[] allXSDFilenames = getAllXSDFilenames();
        if (z) {
            syncCacheWithLocalXsdFiles(allXSDFilenames, false);
        }
        SchemaResource[] schemaResourceArr = (SchemaResource[]) this._resourceForFilename.values().toArray(new SchemaResource[0]);
        if (z2) {
            redownloadEntries(schemaResourceArr);
        }
        if (z3) {
            resolveImports(schemaResourceArr);
        }
        this._redownloadSet = null;
    }

    public final void process(String[] strArr, String[] strArr2, boolean z, boolean z2, boolean z3) {
        if (z2) {
            this._redownloadSet = new HashSet();
        } else {
            this._redownloadSet = null;
        }
        if (strArr2.length > 0) {
            syncCacheWithLocalXsdFiles(strArr2, true);
        } else if (z) {
            syncCacheWithLocalXsdFiles(getAllXSDFilenames(), false);
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            SchemaResource schemaResource = (SchemaResource) lookupResource(null, str);
            if (schemaResource != null) {
                hashSet.add(schemaResource);
            }
        }
        for (int i = 0; i < strArr2.length; i++) {
            SchemaResource schemaResource2 = (SchemaResource) this._resourceForFilename.get(strArr2);
            if (schemaResource2 != null) {
                hashSet.add(schemaResource2);
            }
        }
        SchemaResource[] schemaResourceArr = (SchemaResource[]) hashSet.toArray(new SchemaResource[0]);
        if (z2) {
            redownloadEntries(schemaResourceArr);
        }
        if (z3) {
            resolveImports(schemaResourceArr);
        }
        this._redownloadSet = null;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0085 A[PHI: r5
  0x0085: PHI (r5v4 java.lang.String) = (r5v3 java.lang.String), (r5v5 java.lang.String), (r5v5 java.lang.String), (r5v5 java.lang.String) binds: [B:23:0x0084, B:33:0x0085, B:13:0x0037, B:15:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a0  */
    public final void syncCacheWithLocalXsdFiles(String[] strArr, boolean z) {
        String strShaDigestForFile;
        DownloadedSchemaEntry downloadedSchemaEntryAddNewEntry;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str : strArr) {
            SchemaResource schemaResource = (SchemaResource) this._resourceForFilename.get(str);
            if (schemaResource != null) {
                if (fileExists(str)) {
                    hashSet.add(schemaResource);
                } else {
                    hashSet2.add(schemaResource);
                }
            } else {
                try {
                    strShaDigestForFile = shaDigestForFile(str);
                    try {
                        SchemaResource schemaResource2 = (SchemaResource) this._resourceForDigest.get(strShaDigestForFile);
                        if (schemaResource2 != null) {
                            String filename = schemaResource2.getFilename();
                            if (!fileExists(filename)) {
                                warning("File " + str + " is a rename of " + filename);
                                schemaResource2.setFilename(str);
                                hashSet.add(schemaResource2);
                                if (this._resourceForFilename.get(filename) == schemaResource2) {
                                    this._resourceForFilename.remove(filename);
                                }
                                if (this._resourceForFilename.containsKey(str)) {
                                    this._resourceForFilename.put(str, schemaResource2);
                                }
                            } else {
                                downloadedSchemaEntryAddNewEntry = addNewEntry();
                                downloadedSchemaEntryAddNewEntry.setFilename(str);
                                warning("Caching information on new local file " + str);
                                if (strShaDigestForFile != null) {
                                    downloadedSchemaEntryAddNewEntry.setSha1(strShaDigestForFile);
                                }
                                hashSet.add(updateResource(downloadedSchemaEntryAddNewEntry));
                            }
                        } else {
                            downloadedSchemaEntryAddNewEntry = addNewEntry();
                            downloadedSchemaEntryAddNewEntry.setFilename(str);
                            warning("Caching information on new local file " + str);
                            if (strShaDigestForFile != null) {
                                downloadedSchemaEntryAddNewEntry.setSha1(strShaDigestForFile);
                            }
                            hashSet.add(updateResource(downloadedSchemaEntryAddNewEntry));
                        }
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    strShaDigestForFile = null;
                }
            }
        }
        if (z) {
            deleteResourcesInSet(hashSet2, true);
        } else {
            deleteResourcesInSet(hashSet, false);
        }
    }

    private void redownloadEntries(SchemaResource[] schemaResourceArr) {
        for (SchemaResource schemaResource : schemaResourceArr) {
            redownloadResource(schemaResource);
        }
    }

    private void deleteResourcesInSet(Set set, boolean z) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((SchemaResource) it.next())._cacheEntry);
        }
        DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = this._importsDoc.getDownloadedSchemas();
        int i = 0;
        while (i < downloadedSchemas.sizeOfEntryArray()) {
            DownloadedSchemaEntry entryArray = downloadedSchemas.getEntryArray(i);
            if (hashSet.contains(entryArray) == z) {
                SchemaResource schemaResource = (SchemaResource) this._resourceForCacheEntry.get(entryArray);
                warning("Removing obsolete cache entry for " + schemaResource.getFilename());
                if (schemaResource != null) {
                    this._resourceForCacheEntry.remove(entryArray);
                    if (schemaResource == this._resourceForFilename.get(schemaResource.getFilename())) {
                        this._resourceForFilename.remove(schemaResource.getFilename());
                    }
                    if (schemaResource == this._resourceForDigest.get(schemaResource.getSha1())) {
                        this._resourceForDigest.remove(schemaResource.getSha1());
                    }
                    if (schemaResource == this._resourceForNamespace.get(schemaResource.getNamespace())) {
                        this._resourceForNamespace.remove(schemaResource.getNamespace());
                    }
                    String[] schemaLocationArray = schemaResource.getSchemaLocationArray();
                    for (int i2 = 0; i2 < schemaLocationArray.length; i2++) {
                        if (schemaResource == this._resourceForURL.get(schemaLocationArray[i2])) {
                            this._resourceForURL.remove(schemaLocationArray[i2]);
                        }
                    }
                }
                downloadedSchemas.removeEntry(i);
                i--;
            }
            i++;
        }
    }

    private SchemaResource updateResource(DownloadedSchemaEntry downloadedSchemaEntry) {
        String filename = downloadedSchemaEntry.getFilename();
        if (filename == null) {
            return null;
        }
        SchemaResource schemaResource = new SchemaResource(downloadedSchemaEntry);
        this._resourceForCacheEntry.put(downloadedSchemaEntry, schemaResource);
        if (!this._resourceForFilename.containsKey(filename)) {
            this._resourceForFilename.put(filename, schemaResource);
        }
        String sha1 = schemaResource.getSha1();
        if (sha1 != null && !this._resourceForDigest.containsKey(sha1)) {
            this._resourceForDigest.put(sha1, schemaResource);
        }
        String namespace = schemaResource.getNamespace();
        if (namespace != null && !this._resourceForNamespace.containsKey(namespace)) {
            this._resourceForNamespace.put(namespace, schemaResource);
        }
        String[] schemaLocationArray = schemaResource.getSchemaLocationArray();
        for (int i = 0; i < schemaLocationArray.length; i++) {
            if (!this._resourceForURL.containsKey(schemaLocationArray[i])) {
                this._resourceForURL.put(schemaLocationArray[i], schemaResource);
            }
        }
        return schemaResource;
    }

    private static DigestInputStream digestInputStream(InputStream inputStream) {
        try {
            return new DigestInputStream(inputStream, MessageDigest.getInstance("SHA"));
        } catch (NoSuchAlgorithmException e) {
            throw ((IllegalStateException) new IllegalStateException().initCause(e));
        }
    }

    private DownloadedSchemaEntry addNewEntry() {
        return this._importsDoc.getDownloadedSchemas().addNewEntry();
    }

    private class SchemaResource implements SchemaImportResolver.SchemaResource {
        DownloadedSchemaEntry _cacheEntry;

        SchemaResource(DownloadedSchemaEntry downloadedSchemaEntry) {
            this._cacheEntry = downloadedSchemaEntry;
        }

        public void setFilename(String str) {
            this._cacheEntry.setFilename(str);
        }

        public String getFilename() {
            return this._cacheEntry.getFilename();
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public SchemaDocument.Schema getSchema() {
            if (!BaseSchemaResourceManager.this.fileExists(getFilename())) {
                BaseSchemaResourceManager.this.redownloadResource(this);
            }
            try {
                return SchemaDocument.Factory.parse(BaseSchemaResourceManager.this.inputStreamForFile(getFilename())).getSchema();
            } catch (Exception unused) {
                return null;
            }
        }

        public String getSha1() {
            return this._cacheEntry.getSha1();
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public String getNamespace() {
            return this._cacheEntry.getNamespace();
        }

        public void setNamespace(String str) {
            this._cacheEntry.setNamespace(str);
        }

        @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver.SchemaResource
        public String getSchemaLocation() {
            if (this._cacheEntry.sizeOfSchemaLocationArray() > 0) {
                return this._cacheEntry.getSchemaLocationArray(0);
            }
            return null;
        }

        public String[] getSchemaLocationArray() {
            return this._cacheEntry.getSchemaLocationArray();
        }

        public int hashCode() {
            return getFilename().hashCode();
        }

        public boolean equals(Object obj) {
            return this == obj || getFilename().equals(((SchemaResource) obj).getFilename());
        }

        public void addSchemaLocation(String str) {
            this._cacheEntry.addSchemaLocation(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver
    public SchemaImportResolver.SchemaResource lookupResource(String str, String str2) {
        SchemaResource schemaResourceFetchFromCache = fetchFromCache(str, str2);
        if (schemaResourceFetchFromCache != null) {
            if (this._redownloadSet != null) {
                redownloadResource(schemaResourceFetchFromCache);
            }
            return schemaResourceFetchFromCache;
        }
        if (str2 == null) {
            warning("No cached schema for namespace '" + str + "', and no url specified");
            return null;
        }
        SchemaResource schemaResourceCopyOrIdentifyDuplicateURL = copyOrIdentifyDuplicateURL(str2, str);
        Set set = this._redownloadSet;
        if (set != null) {
            set.add(schemaResourceCopyOrIdentifyDuplicateURL);
        }
        return schemaResourceCopyOrIdentifyDuplicateURL;
    }

    private SchemaResource fetchFromCache(String str, String str2) {
        SchemaResource schemaResource;
        SchemaResource schemaResource2;
        if (str2 != null && (schemaResource2 = (SchemaResource) this._resourceForURL.get(str2)) != null) {
            return schemaResource2;
        }
        if (str == null || (schemaResource = (SchemaResource) this._resourceForNamespace.get(str)) == null) {
            return null;
        }
        return schemaResource;
    }

    private String uniqueFilenameForURI(String str) throws URISyntaxException, IOException {
        String rawPath = new URI(str).getRawPath();
        int iLastIndexOf = rawPath.lastIndexOf(47);
        int i = 1;
        if (iLastIndexOf >= 0) {
            rawPath = rawPath.substring(iLastIndexOf + 1);
        }
        if (rawPath.endsWith(".xsd")) {
            rawPath = rawPath.substring(0, rawPath.length() - 4);
        }
        if (rawPath.length() == 0) {
            rawPath = "schema";
        }
        String str2 = rawPath;
        while (i < 1000) {
            String str3 = this._defaultCopyDirectory + "/" + str2 + ".xsd";
            if (!fileExists(str3)) {
                return str3;
            }
            i++;
            str2 = rawPath + i;
        }
        throw new IOException("Problem with filename " + rawPath + ".xsd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redownloadResource(SchemaResource schemaResource) {
        Set set = this._redownloadSet;
        if (set != null) {
            if (set.contains(schemaResource)) {
                return;
            } else {
                this._redownloadSet.add(schemaResource);
            }
        }
        String filename = schemaResource.getFilename();
        String schemaLocation = schemaResource.getSchemaLocation();
        if (schemaLocation == null || filename == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            URLConnection uRLConnectionOpenConnection = new URL(schemaLocation).openConnection();
            uRLConnectionOpenConnection.addRequestProperty("User-Agent", USER_AGENT);
            uRLConnectionOpenConnection.addRequestProperty("Accept", "application/xml, text/xml, */*");
            DigestInputStream digestInputStream = digestInputStream(uRLConnectionOpenConnection.getInputStream());
            IOUtil.copyCompletely(digestInputStream, byteArrayOutputStream);
            if (HexBin.bytesToString(digestInputStream.getMessageDigest().digest()).equals(schemaResource.getSha1()) && fileExists(filename)) {
                warning("Resource " + filename + " is unchanged from " + schemaLocation + ".");
                return;
            }
            try {
                writeInputStreamToFile(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), filename);
                warning("Refreshed " + filename + " from " + schemaLocation);
            } catch (IOException e) {
                warning("Could not write to file " + filename + " for " + schemaLocation + ":" + e.getMessage());
            }
        } catch (Exception e2) {
            warning("Could not copy remote resource " + schemaLocation + ":" + e2.getMessage());
        }
    }

    private SchemaResource copyOrIdentifyDuplicateURL(String str, String str2) {
        try {
            String strUniqueFilenameForURI = uniqueFilenameForURI(str);
            try {
                DigestInputStream digestInputStream = digestInputStream(new URL(str).openStream());
                writeInputStreamToFile(digestInputStream, strUniqueFilenameForURI);
                String strBytesToString = HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
                SchemaResource schemaResource = (SchemaResource) this._resourceForDigest.get(strBytesToString);
                if (schemaResource != null) {
                    deleteFile(strUniqueFilenameForURI);
                    schemaResource.addSchemaLocation(str);
                    if (!this._resourceForURL.containsKey(str)) {
                        this._resourceForURL.put(str, schemaResource);
                    }
                    return schemaResource;
                }
                warning("Downloaded " + str + " to " + strUniqueFilenameForURI);
                DownloadedSchemaEntry downloadedSchemaEntryAddNewEntry = addNewEntry();
                downloadedSchemaEntryAddNewEntry.setFilename(strUniqueFilenameForURI);
                downloadedSchemaEntryAddNewEntry.setSha1(strBytesToString);
                if (str2 != null) {
                    downloadedSchemaEntryAddNewEntry.setNamespace(str2);
                }
                downloadedSchemaEntryAddNewEntry.addSchemaLocation(str);
                return updateResource(downloadedSchemaEntryAddNewEntry);
            } catch (Exception e) {
                warning("Could not copy remote resource " + str + ":" + e.getMessage());
                return null;
            }
        } catch (IOException e2) {
            warning("Could not create local file for " + str + ":" + e2.getMessage());
            return null;
        } catch (URISyntaxException e3) {
            warning("Invalid URI '" + str + "':" + e3.getMessage());
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.tool.SchemaImportResolver
    public void reportActualNamespace(SchemaImportResolver.SchemaResource schemaResource, String str) {
        SchemaResource schemaResource2 = (SchemaResource) schemaResource;
        String namespace = schemaResource2.getNamespace();
        if (namespace != null && this._resourceForNamespace.get(namespace) == schemaResource2) {
            this._resourceForNamespace.remove(namespace);
        }
        if (!this._resourceForNamespace.containsKey(str)) {
            this._resourceForNamespace.put(str, schemaResource2);
        }
        schemaResource2.setNamespace(str);
    }

    private String shaDigestForFile(String str) throws IOException {
        DigestInputStream digestInputStream = digestInputStream(inputStreamForFile(str));
        byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
        for (int i = 1; i > 0; i = digestInputStream.read(bArr)) {
        }
        digestInputStream.close();
        return HexBin.bytesToString(digestInputStream.getMessageDigest().digest());
    }
}
