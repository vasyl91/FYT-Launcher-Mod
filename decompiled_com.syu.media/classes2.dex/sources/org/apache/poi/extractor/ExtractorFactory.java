package org.apache.poi.extractor;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIOLE2TextExtractor;
import org.apache.poi.POITextExtractor;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hsmf.datatypes.AttachmentChunks;
import org.apache.poi.hsmf.extractor.OutlookTextExtactor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.NotOLE2FileException;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xdgf.extractor.XDGFVisioExtractor;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xslf.usermodel.XSLFSlideShow;
import org.apache.poi.xssf.extractor.XSSFBEventBasedExcelExtractor;
import org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ExtractorFactory {
    public static final String CORE_DOCUMENT_REL = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
    protected static final String STRICT_DOCUMENT_REL = "http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument";
    protected static final String VISIO_DOCUMENT_REL = "http://schemas.microsoft.com/visio/2010/relationships/document";
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) ExtractorFactory.class);

    public static boolean getThreadPrefersEventExtractors() {
        return OLE2ExtractorFactory.getThreadPrefersEventExtractors();
    }

    public static Boolean getAllThreadsPreferEventExtractors() {
        return OLE2ExtractorFactory.getAllThreadsPreferEventExtractors();
    }

    public static void setThreadPrefersEventExtractors(boolean z) {
        OLE2ExtractorFactory.setThreadPrefersEventExtractors(z);
    }

    public static void setAllThreadsPreferEventExtractors(Boolean bool) {
        OLE2ExtractorFactory.setAllThreadsPreferEventExtractors(bool);
    }

    protected static boolean getPreferEventExtractor() {
        return OLE2ExtractorFactory.getPreferEventExtractor();
    }

    public static POITextExtractor createExtractor(File file) throws XmlException, OpenXML4JException, IOException {
        NPOIFSFileSystem nPOIFSFileSystem = null;
        try {
            NPOIFSFileSystem nPOIFSFileSystem2 = new NPOIFSFileSystem(file);
            try {
                if (nPOIFSFileSystem2.getRoot().hasEntry(Decryptor.DEFAULT_POIFS_ENTRY)) {
                    return createEncyptedOOXMLExtractor(nPOIFSFileSystem2);
                }
                POIOLE2TextExtractor pOIOLE2TextExtractorCreateExtractor = createExtractor(nPOIFSFileSystem2);
                pOIOLE2TextExtractorCreateExtractor.setFilesystem(nPOIFSFileSystem2);
                return pOIOLE2TextExtractorCreateExtractor;
            } catch (Error e) {
                e = e;
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw e;
            } catch (OpenXML4JException e3) {
                e = e3;
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw e;
            } catch (NotOLE2FileException unused) {
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw new IllegalArgumentException("Your File was neither an OLE2 file, nor an OOXML file");
            } catch (IOException e4) {
                e = e4;
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw e;
            } catch (OfficeXmlFileException unused2) {
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                return createExtractor(OPCPackage.open(file.toString(), PackageAccess.READ));
            } catch (XmlException e5) {
                e = e5;
                nPOIFSFileSystem = nPOIFSFileSystem2;
                IOUtils.closeQuietly(nPOIFSFileSystem);
                throw e;
            }
        } catch (IOException e6) {
            e = e6;
        } catch (Error e7) {
            e = e7;
        } catch (OfficeXmlFileException unused3) {
        } catch (RuntimeException e8) {
            e = e8;
        } catch (OpenXML4JException e9) {
            e = e9;
        } catch (NotOLE2FileException unused4) {
        } catch (XmlException e10) {
            e = e10;
        }
    }

    public static POITextExtractor createExtractor(InputStream inputStream) throws XmlException, OpenXML4JException, IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.valueOf(inputStreamPrepareToCheckMagic).ordinal()];
        if (i == 1) {
            NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(inputStreamPrepareToCheckMagic);
            return nPOIFSFileSystem.getRoot().hasEntry(Decryptor.DEFAULT_POIFS_ENTRY) ? createEncyptedOOXMLExtractor(nPOIFSFileSystem) : createExtractor(nPOIFSFileSystem);
        }
        if (i == 2) {
            return createExtractor(OPCPackage.open(inputStreamPrepareToCheckMagic));
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

    /* JADX INFO: renamed from: org.apache.poi.extractor.ExtractorFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic;

        static {
            int[] iArr = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = iArr;
            try {
                iArr[FileMagic.OLE2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.OOXML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static POIXMLTextExtractor createExtractor(OPCPackage oPCPackage) throws XmlException, OpenXML4JException, IOException {
        try {
            PackageRelationshipCollection relationshipsByType = oPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
            if (relationshipsByType.size() == 0) {
                relationshipsByType = oPCPackage.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument");
            }
            if (relationshipsByType.size() == 0) {
                relationshipsByType = oPCPackage.getRelationshipsByType("http://schemas.microsoft.com/visio/2010/relationships/document");
                if (relationshipsByType.size() == 1) {
                    return new XDGFVisioExtractor(oPCPackage);
                }
            }
            if (relationshipsByType.size() != 1) {
                throw new IllegalArgumentException("Invalid OOXML Package received - expected 1 core document, found " + relationshipsByType.size());
            }
            String contentType = oPCPackage.getPart(relationshipsByType.getRelationship(0)).getContentType();
            for (XSSFRelation xSSFRelation : XSSFExcelExtractor.SUPPORTED_TYPES) {
                if (xSSFRelation.getContentType().equals(contentType)) {
                    if (getPreferEventExtractor()) {
                        return new XSSFEventBasedExcelExtractor(oPCPackage);
                    }
                    return new XSSFExcelExtractor(oPCPackage);
                }
            }
            for (XWPFRelation xWPFRelation : XWPFWordExtractor.SUPPORTED_TYPES) {
                if (xWPFRelation.getContentType().equals(contentType)) {
                    return new XWPFWordExtractor(oPCPackage);
                }
            }
            for (XSLFRelation xSLFRelation : XSLFPowerPointExtractor.SUPPORTED_TYPES) {
                if (xSLFRelation.getContentType().equals(contentType)) {
                    return new XSLFPowerPointExtractor(oPCPackage);
                }
            }
            if (XSLFRelation.THEME_MANAGER.getContentType().equals(contentType)) {
                return new XSLFPowerPointExtractor(new XSLFSlideShow(oPCPackage));
            }
            for (XSSFRelation xSSFRelation2 : XSSFBEventBasedExcelExtractor.SUPPORTED_TYPES) {
                if (xSSFRelation2.getContentType().equals(contentType)) {
                    return new XSSFBEventBasedExcelExtractor(oPCPackage);
                }
            }
            throw new IllegalArgumentException("No supported documents found in the OOXML package (found " + contentType + ")");
        } catch (IOException e) {
            oPCPackage.revert();
            throw e;
        } catch (Error e2) {
            oPCPackage.revert();
            throw e2;
        } catch (RuntimeException e3) {
            oPCPackage.revert();
            throw e3;
        } catch (OpenXML4JException e4) {
            oPCPackage.revert();
            throw e4;
        } catch (XmlException e5) {
            oPCPackage.revert();
            throw e5;
        }
    }

    public static POIOLE2TextExtractor createExtractor(POIFSFileSystem pOIFSFileSystem) throws XmlException, OpenXML4JException, IOException {
        return OLE2ExtractorFactory.createExtractor(pOIFSFileSystem);
    }

    public static POIOLE2TextExtractor createExtractor(NPOIFSFileSystem nPOIFSFileSystem) throws XmlException, OpenXML4JException, IOException {
        return OLE2ExtractorFactory.createExtractor(nPOIFSFileSystem);
    }

    public static POIOLE2TextExtractor createExtractor(OPOIFSFileSystem oPOIFSFileSystem) throws XmlException, OpenXML4JException, IOException {
        return OLE2ExtractorFactory.createExtractor(oPOIFSFileSystem);
    }

    public static POITextExtractor createExtractor(DirectoryNode directoryNode) throws XmlException, OpenXML4JException, IOException {
        Iterator<String> it = directoryNode.getEntryNames().iterator();
        while (it.hasNext()) {
            if (it.next().equals("Package")) {
                return createExtractor(OPCPackage.open(directoryNode.createDocumentInputStream("Package")));
            }
        }
        return OLE2ExtractorFactory.createExtractor(directoryNode);
    }

    public static POITextExtractor[] getEmbededDocsTextExtractors(POIOLE2TextExtractor pOIOLE2TextExtractor) throws XmlException, OpenXML4JException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        DirectoryEntry root = pOIOLE2TextExtractor.getRoot();
        if (root == null) {
            throw new IllegalStateException("The extractor didn't know which POIFS it came from!");
        }
        if (pOIOLE2TextExtractor instanceof ExcelExtractor) {
            Iterator<Entry> entries = root.getEntries();
            while (entries.hasNext()) {
                Entry next = entries.next();
                if (next.getName().startsWith("MBD")) {
                    arrayList.add(next);
                }
            }
        } else if (pOIOLE2TextExtractor instanceof WordExtractor) {
            try {
                Iterator<Entry> entries2 = ((DirectoryEntry) root.getEntry("ObjectPool")).getEntries();
                while (entries2.hasNext()) {
                    Entry next2 = entries2.next();
                    if (next2.getName().startsWith("_")) {
                        arrayList.add(next2);
                    }
                }
            } catch (FileNotFoundException e) {
                logger.log(3, "Ignoring FileNotFoundException while extracting Word document", e.getLocalizedMessage());
            }
        } else if (pOIOLE2TextExtractor instanceof OutlookTextExtactor) {
            for (AttachmentChunks attachmentChunks : ((OutlookTextExtactor) pOIOLE2TextExtractor).getMAPIMessage().getAttachmentFiles()) {
                if (attachmentChunks.getAttachData() != null) {
                    arrayList2.add(new ByteArrayInputStream(attachmentChunks.getAttachData().getValue()));
                } else if (attachmentChunks.getAttachmentDirectory() != null) {
                    arrayList.add(attachmentChunks.getAttachmentDirectory().getDirectory());
                }
            }
        }
        if (arrayList.size() == 0 && arrayList2.size() == 0) {
            return new POITextExtractor[0];
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(createExtractor((DirectoryNode) ((Entry) it.next())));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            try {
                arrayList3.add(createExtractor((InputStream) it2.next()));
            } catch (IllegalArgumentException e2) {
                logger.log(3, "Format not supported yet", e2.getLocalizedMessage());
            } catch (OpenXML4JException e3) {
                throw new IOException(e3.getMessage(), e3);
            } catch (XmlException e4) {
                throw new IOException(e4.getMessage(), e4);
            }
        }
        return (POITextExtractor[]) arrayList3.toArray(new POITextExtractor[arrayList3.size()]);
    }

    @NotImplemented
    public static POITextExtractor[] getEmbededDocsTextExtractors(POIXMLTextExtractor pOIXMLTextExtractor) {
        throw new IllegalStateException("Not yet supported");
    }

    private static POIXMLTextExtractor createEncyptedOOXMLExtractor(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        String currentUserPassword = Biff8EncryptionKey.getCurrentUserPassword();
        if (currentUserPassword == null) {
            currentUserPassword = Decryptor.DEFAULT_PASSWORD;
        }
        Decryptor decryptor = new EncryptionInfo(nPOIFSFileSystem).getDecryptor();
        try {
            try {
                if (!decryptor.verifyPassword(currentUserPassword)) {
                    throw new EncryptedDocumentException("Invalid password specified - use Biff8EncryptionKey.setCurrentUserPassword() before calling extractor");
                }
                InputStream dataStream = decryptor.getDataStream(nPOIFSFileSystem);
                POIXMLTextExtractor pOIXMLTextExtractorCreateExtractor = createExtractor(OPCPackage.open(dataStream));
                IOUtils.closeQuietly(dataStream);
                return pOIXMLTextExtractorCreateExtractor;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new EncryptedDocumentException(e2);
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(null);
            throw th;
        }
    }
}
