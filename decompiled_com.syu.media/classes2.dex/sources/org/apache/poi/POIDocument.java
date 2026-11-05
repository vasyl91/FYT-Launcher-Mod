package org.apache.poi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.List;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.WritingNotSupportedException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIDecryptor;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class POIDocument implements Closeable {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) POIDocument.class);
    private DirectoryNode directory;
    private DocumentSummaryInformation dsInf;
    private boolean initialized;
    private SummaryInformation sInf;

    protected String getEncryptedPropertyStreamName() {
        return "encryption";
    }

    public EncryptionInfo getEncryptionInfo() throws IOException {
        return null;
    }

    public abstract void write() throws IOException;

    public abstract void write(File file) throws IOException;

    public abstract void write(OutputStream outputStream) throws IOException;

    protected POIDocument(DirectoryNode directoryNode) {
        this.directory = directoryNode;
    }

    protected POIDocument(OPOIFSFileSystem oPOIFSFileSystem) {
        this(oPOIFSFileSystem.getRoot());
    }

    protected POIDocument(NPOIFSFileSystem nPOIFSFileSystem) {
        this(nPOIFSFileSystem.getRoot());
    }

    protected POIDocument(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem.getRoot());
    }

    public DocumentSummaryInformation getDocumentSummaryInformation() {
        if (!this.initialized) {
            readProperties();
        }
        return this.dsInf;
    }

    public SummaryInformation getSummaryInformation() {
        if (!this.initialized) {
            readProperties();
        }
        return this.sInf;
    }

    public void createInformationProperties() {
        if (!this.initialized) {
            readProperties();
        }
        if (this.sInf == null) {
            this.sInf = PropertySetFactory.newSummaryInformation();
        }
        if (this.dsInf == null) {
            this.dsInf = PropertySetFactory.newDocumentSummaryInformation();
        }
    }

    protected void readProperties() {
        if (this.initialized) {
            return;
        }
        DocumentSummaryInformation documentSummaryInformation = (DocumentSummaryInformation) readPropertySet(DocumentSummaryInformation.class, DocumentSummaryInformation.DEFAULT_STREAM_NAME);
        if (documentSummaryInformation != null) {
            this.dsInf = documentSummaryInformation;
        }
        SummaryInformation summaryInformation = (SummaryInformation) readPropertySet(SummaryInformation.class, SummaryInformation.DEFAULT_STREAM_NAME);
        if (summaryInformation != null) {
            this.sInf = summaryInformation;
        }
        this.initialized = true;
    }

    private <T> T readPropertySet(Class<T> cls, String str) {
        String strSubstring = cls.getName().substring(cls.getName().lastIndexOf(46) + 1);
        try {
            T t = (T) getPropertySet(str);
            if (cls.isInstance(t)) {
                return t;
            }
            if (t != null) {
                logger.log(5, strSubstring + " property set came back with wrong class - " + t.getClass().getName());
            } else {
                logger.log(5, strSubstring + " property set came back as null");
            }
            return null;
        } catch (IOException e) {
            logger.log(7, "can't retrieve property set", e);
            return null;
        }
    }

    protected PropertySet getPropertySet(String str) throws IOException {
        return getPropertySet(str, getEncryptionInfo());
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    protected PropertySet getPropertySet(String str, EncryptionInfo encryptionInfo) throws Throwable {
        String str2;
        POIFSFileSystem summaryEntries;
        DirectoryNode root = this.directory;
        POIFSFileSystem pOIFSFileSystem = null;
        String str3 = "getting";
        try {
            if (encryptionInfo == null) {
                summaryEntries = null;
                str2 = "getting";
                if (root != null) {
                }
                IOUtils.closeQuietly(summaryEntries);
                return null;
            }
            try {
                try {
                    if (encryptionInfo.isDocPropsEncrypted()) {
                        str2 = "getting encrypted";
                        try {
                            String encryptedPropertyStreamName = getEncryptedPropertyStreamName();
                            if (!root.hasEntry(encryptedPropertyStreamName)) {
                                throw new EncryptedDocumentException("can't find encrypted property stream '" + encryptedPropertyStreamName + "'");
                            }
                            summaryEntries = ((CryptoAPIDecryptor) encryptionInfo.getDecryptor()).getSummaryEntries(root, encryptedPropertyStreamName);
                            try {
                                try {
                                    root = summaryEntries.getRoot();
                                } catch (Exception e) {
                                    e = e;
                                    str3 = str2;
                                }
                            } catch (IOException e2) {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                pOIFSFileSystem = summaryEntries;
                                IOUtils.closeQuietly(pOIFSFileSystem);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str3 = str2;
                        }
                    } else {
                        summaryEntries = null;
                        str2 = "getting";
                    }
                    if (root != null || !root.hasEntry(str)) {
                        IOUtils.closeQuietly(summaryEntries);
                        return null;
                    }
                    try {
                        DocumentInputStream documentInputStreamCreateDocumentInputStream = root.createDocumentInputStream(root.getEntry(str));
                        try {
                            PropertySet propertySetCreate = PropertySetFactory.create(documentInputStreamCreateDocumentInputStream);
                            documentInputStreamCreateDocumentInputStream.close();
                            IOUtils.closeQuietly(summaryEntries);
                            return propertySetCreate;
                        } catch (Throwable th2) {
                            documentInputStreamCreateDocumentInputStream.close();
                            throw th2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (IOException e6) {
                throw e6;
            }
            throw new IOException("Error " + str3 + " property set with name " + str, e);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    protected void writeProperties() throws IOException {
        validateInPlaceWritePossible();
        writeProperties(this.directory.getFileSystem(), null);
    }

    protected void writeProperties(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        writeProperties(nPOIFSFileSystem, null);
    }

    protected void writeProperties(NPOIFSFileSystem nPOIFSFileSystem, List<String> list) throws IOException {
        EncryptionInfo encryptionInfo = getEncryptionInfo();
        boolean z = encryptionInfo != null && encryptionInfo.isDocPropsEncrypted();
        NPOIFSFileSystem nPOIFSFileSystem2 = z ? new NPOIFSFileSystem() : nPOIFSFileSystem;
        SummaryInformation summaryInformation = getSummaryInformation();
        if (summaryInformation != null) {
            writePropertySet(SummaryInformation.DEFAULT_STREAM_NAME, summaryInformation, nPOIFSFileSystem2);
            if (list != null) {
                list.add(SummaryInformation.DEFAULT_STREAM_NAME);
            }
        }
        DocumentSummaryInformation documentSummaryInformation = getDocumentSummaryInformation();
        if (documentSummaryInformation != null) {
            writePropertySet(DocumentSummaryInformation.DEFAULT_STREAM_NAME, documentSummaryInformation, nPOIFSFileSystem2);
            if (list != null) {
                list.add(DocumentSummaryInformation.DEFAULT_STREAM_NAME);
            }
        }
        if (z) {
            writePropertySet(DocumentSummaryInformation.DEFAULT_STREAM_NAME, PropertySetFactory.newDocumentSummaryInformation(), nPOIFSFileSystem);
            if (nPOIFSFileSystem.getRoot().hasEntry(SummaryInformation.DEFAULT_STREAM_NAME)) {
                nPOIFSFileSystem.getRoot().getEntry(SummaryInformation.DEFAULT_STREAM_NAME).delete();
            }
            Encryptor encryptor = encryptionInfo.getEncryptor();
            if (!(encryptor instanceof CryptoAPIEncryptor)) {
                throw new EncryptedDocumentException("Using " + encryptionInfo.getEncryptionMode() + " encryption. Only CryptoAPI encryption supports encrypted property sets!");
            }
            try {
                try {
                    ((CryptoAPIEncryptor) encryptor).setSummaryEntries(nPOIFSFileSystem.getRoot(), getEncryptedPropertyStreamName(), nPOIFSFileSystem2);
                    nPOIFSFileSystem2.close();
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            } catch (Throwable th) {
                nPOIFSFileSystem2.close();
                throw th;
            }
        }
    }

    protected void writePropertySet(String str, PropertySet propertySet, NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        try {
            PropertySet propertySet2 = new PropertySet(propertySet);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            propertySet2.write(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            nPOIFSFileSystem.createOrUpdateDocument(new ByteArrayInputStream(byteArray), str);
            logger.log(3, "Wrote property set " + str + " of size " + byteArray.length);
        } catch (WritingNotSupportedException unused) {
            logger.log(7, "Couldn't write property set with name " + str + " as not supported by HPSF yet");
        }
    }

    protected void validateInPlaceWritePossible() throws IllegalStateException {
        DirectoryNode directoryNode = this.directory;
        if (directoryNode == null) {
            throw new IllegalStateException("Newly created Document, cannot save in-place");
        }
        if (directoryNode.getParent() != null) {
            throw new IllegalStateException("This is not the root Document, cannot save embedded resource in-place");
        }
        if (this.directory.getFileSystem() == null || !this.directory.getFileSystem().isInPlaceWriteable()) {
            throw new IllegalStateException("Opened read-only or via an InputStream, a Writeable File is required");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        DirectoryNode directoryNode = this.directory;
        if (directoryNode == null || directoryNode.getNFileSystem() == null) {
            return;
        }
        this.directory.getNFileSystem().close();
        clearDirectory();
    }

    @Internal
    public DirectoryNode getDirectory() {
        return this.directory;
    }

    @Internal
    protected void clearDirectory() {
        this.directory = null;
    }

    @Internal
    protected boolean initDirectory() {
        if (this.directory != null) {
            return false;
        }
        this.directory = new NPOIFSFileSystem().getRoot();
        return true;
    }

    @Internal
    protected DirectoryNode replaceDirectory(DirectoryNode directoryNode) {
        DirectoryNode directoryNode2 = this.directory;
        this.directory = directoryNode;
        return directoryNode2;
    }
}
