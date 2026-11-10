package org.apache.poi.ss.extractor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.Ole10NativeException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.ObjectData;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.ss.usermodel.ShapeContainer;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFObjectData;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EmbeddedExtractor implements Iterable<EmbeddedExtractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CONTENT_TYPE_BYTES = "binary/octet-stream";
    private static final String CONTENT_TYPE_DOC = "application/msword";
    private static final String CONTENT_TYPE_PDF = "application/pdf";
    private static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) EmbeddedExtractor.class);

    public boolean canExtract(DirectoryNode directoryNode) {
        return false;
    }

    public boolean canExtract(Picture picture) {
        return false;
    }

    protected EmbeddedData extract(Picture picture) throws IOException {
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<EmbeddedExtractor> iterator() {
        return Arrays.asList(new Ole10Extractor(), new PdfExtractor(), new BiffExtractor(), new OOXMLExtractor(), new FsExtractor()).iterator();
    }

    public EmbeddedData extractOne(DirectoryNode directoryNode) throws IOException {
        for (EmbeddedExtractor embeddedExtractor : this) {
            if (embeddedExtractor.canExtract(directoryNode)) {
                return embeddedExtractor.extract(directoryNode);
            }
        }
        return null;
    }

    public EmbeddedData extractOne(Picture picture) throws IOException {
        for (EmbeddedExtractor embeddedExtractor : this) {
            if (embeddedExtractor.canExtract(picture)) {
                return embeddedExtractor.extract(picture);
            }
        }
        return null;
    }

    public List<EmbeddedData> extractAll(Sheet sheet) throws IOException {
        Drawing<?> drawingPatriarch = sheet.getDrawingPatriarch();
        if (drawingPatriarch == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        extractAll(drawingPatriarch, arrayList);
        return arrayList;
    }

    protected void extractAll(ShapeContainer<?> shapeContainer, List<EmbeddedData> list) throws IOException {
        EmbeddedData embeddedData;
        Iterator<?> it = shapeContainer.iterator();
        while (it.hasNext()) {
            Shape shape = (Shape) it.next();
            EmbeddedData embeddedDataExtractOne = null;
            if (shape instanceof ObjectData) {
                ObjectData objectData = (ObjectData) shape;
                try {
                    if (objectData.hasDirectoryEntry()) {
                        embeddedData = extractOne((DirectoryNode) objectData.getDirectory());
                    } else {
                        String contentType = CONTENT_TYPE_BYTES;
                        if (objectData instanceof XSSFObjectData) {
                            contentType = ((XSSFObjectData) objectData).getObjectPart().getContentType();
                        }
                        embeddedData = new EmbeddedData(objectData.getFileName(), objectData.getObjectData(), contentType);
                    }
                    embeddedDataExtractOne = embeddedData;
                } catch (Exception e) {
                    LOG.log(5, "Entry not found / readable - ignoring OLE embedding", e);
                }
            } else if (shape instanceof Picture) {
                embeddedDataExtractOne = extractOne((Picture) shape);
            } else if (shape instanceof ShapeContainer) {
                extractAll((ShapeContainer) shape, list);
            }
            if (embeddedDataExtractOne != null) {
                embeddedDataExtractOne.setShape(shape);
                String filename = embeddedDataExtractOne.getFilename();
                String strSubstring = (filename == null || filename.lastIndexOf(46) == -1) ? ".bin" : filename.substring(filename.lastIndexOf(46));
                if ((filename == null || "".equals(filename) || filename.startsWith("MBD") || filename.startsWith("Root Entry")) && (filename = shape.getShapeName()) != null) {
                    filename = filename + strSubstring;
                }
                if (filename == null || "".equals(filename)) {
                    filename = "picture_" + list.size() + strSubstring;
                }
                embeddedDataExtractOne.setFilename(filename.trim());
                list.add(embeddedDataExtractOne);
            }
        }
    }

    protected EmbeddedData extract(DirectoryNode directoryNode) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(20000);
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        try {
            copyNodes(directoryNode, pOIFSFileSystem.getRoot());
            pOIFSFileSystem.writeFilesystem(byteArrayOutputStream);
            return new EmbeddedData(directoryNode.getName(), byteArrayOutputStream.toByteArray(), CONTENT_TYPE_BYTES);
        } finally {
            pOIFSFileSystem.close();
        }
    }

    public static class Ole10Extractor extends EmbeddedExtractor {
        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return ClassID.OLE10_PACKAGE.equals(directoryNode.getStorageClsid());
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) throws IOException {
            try {
                Ole10Native ole10NativeCreateFromEmbeddedOleObject = Ole10Native.createFromEmbeddedOleObject(directoryNode);
                return new EmbeddedData(ole10NativeCreateFromEmbeddedOleObject.getFileName(), ole10NativeCreateFromEmbeddedOleObject.getDataBuffer(), EmbeddedExtractor.CONTENT_TYPE_BYTES);
            } catch (Ole10NativeException e) {
                throw new IOException(e);
            }
        }
    }

    static class PdfExtractor extends EmbeddedExtractor {
        static ClassID PdfClassID = new ClassID("{B801CA65-A1FC-11D0-85AD-444553540000}");

        PdfExtractor() {
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return PdfClassID.equals(directoryNode.getStorageClsid()) || directoryNode.hasEntry("CONTENTS");
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream("CONTENTS");
            IOUtils.copy(documentInputStreamCreateDocumentInputStream, byteArrayOutputStream);
            documentInputStreamCreateDocumentInputStream.close();
            return new EmbeddedData(directoryNode.getName() + ".pdf", byteArrayOutputStream.toByteArray(), EmbeddedExtractor.CONTENT_TYPE_PDF);
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(Picture picture) {
            PictureData pictureData = picture.getPictureData();
            return pictureData != null && pictureData.getPictureType() == 2;
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        protected EmbeddedData extract(Picture picture) throws IOException {
            int iIndexOf;
            PictureData pictureData = picture.getPictureData();
            if (pictureData == null || pictureData.getPictureType() != 2) {
                return null;
            }
            byte[] data = pictureData.getData();
            int iIndexOf2 = EmbeddedExtractor.indexOf(data, 0, "%PDF-".getBytes(LocaleUtil.CHARSET_1252));
            if (iIndexOf2 == -1 || (iIndexOf = EmbeddedExtractor.indexOf(data, iIndexOf2, "%%EOF".getBytes(LocaleUtil.CHARSET_1252))) == -1) {
                return null;
            }
            int i = (iIndexOf - iIndexOf2) + 6;
            byte[] bArr = new byte[i];
            System.arraycopy(data, iIndexOf2, bArr, 0, i);
            String strTrim = picture.getShapeName().trim();
            if (!StringUtil.endsWithIgnoreCase(strTrim, ".pdf")) {
                strTrim = strTrim + ".pdf";
            }
            return new EmbeddedData(strTrim, bArr, EmbeddedExtractor.CONTENT_TYPE_PDF);
        }
    }

    static class OOXMLExtractor extends EmbeddedExtractor {
        OOXMLExtractor() {
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return directoryNode.hasEntry("package");
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) throws IOException {
            String str;
            String str2;
            ClassID storageClsid = directoryNode.getStorageClsid();
            if (ClassID.WORD2007.equals(storageClsid)) {
                str = ".docx";
                str2 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            } else if (ClassID.WORD2007_MACRO.equals(storageClsid)) {
                str = ".docm";
                str2 = "application/vnd.ms-word.document.macroEnabled.12";
            } else if (ClassID.EXCEL2007.equals(storageClsid) || ClassID.EXCEL2003.equals(storageClsid) || ClassID.EXCEL2010.equals(storageClsid)) {
                str = ".xlsx";
                str2 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            } else if (ClassID.EXCEL2007_MACRO.equals(storageClsid)) {
                str = ".xlsm";
                str2 = "application/vnd.ms-excel.sheet.macroEnabled.12";
            } else if (ClassID.EXCEL2007_XLSB.equals(storageClsid)) {
                str = ".xlsb";
                str2 = "application/vnd.ms-excel.sheet.binary.macroEnabled.12";
            } else if (ClassID.POWERPOINT2007.equals(storageClsid)) {
                str = ".pptx";
                str2 = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
            } else if (ClassID.POWERPOINT2007_MACRO.equals(storageClsid)) {
                str = ".ppsm";
                str2 = "application/vnd.ms-powerpoint.slideshow.macroEnabled.12";
            } else {
                str = ".zip";
                str2 = "application/zip";
            }
            DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream("package");
            byte[] byteArray = IOUtils.toByteArray(documentInputStreamCreateDocumentInputStream);
            documentInputStreamCreateDocumentInputStream.close();
            return new EmbeddedData(directoryNode.getName() + str, byteArray, str2);
        }
    }

    static class BiffExtractor extends EmbeddedExtractor {
        BiffExtractor() {
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return canExtractExcel(directoryNode) || canExtractWord(directoryNode);
        }

        protected boolean canExtractExcel(DirectoryNode directoryNode) {
            ClassID storageClsid = directoryNode.getStorageClsid();
            return ClassID.EXCEL95.equals(storageClsid) || ClassID.EXCEL97.equals(storageClsid) || directoryNode.hasEntry("Workbook");
        }

        protected boolean canExtractWord(DirectoryNode directoryNode) {
            ClassID storageClsid = directoryNode.getStorageClsid();
            return ClassID.WORD95.equals(storageClsid) || ClassID.WORD97.equals(storageClsid) || directoryNode.hasEntry("WordDocument");
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) throws IOException {
            EmbeddedData embeddedDataExtract = super.extract(directoryNode);
            if (canExtractExcel(directoryNode)) {
                embeddedDataExtract.setFilename(directoryNode.getName() + ".xls");
                embeddedDataExtract.setContentType(EmbeddedExtractor.CONTENT_TYPE_XLS);
            } else if (canExtractWord(directoryNode)) {
                embeddedDataExtract.setFilename(directoryNode.getName() + ".doc");
                embeddedDataExtract.setContentType(EmbeddedExtractor.CONTENT_TYPE_DOC);
            }
            return embeddedDataExtract;
        }
    }

    static class FsExtractor extends EmbeddedExtractor {
        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public boolean canExtract(DirectoryNode directoryNode) {
            return true;
        }

        FsExtractor() {
        }

        @Override // org.apache.poi.ss.extractor.EmbeddedExtractor
        public EmbeddedData extract(DirectoryNode directoryNode) throws IOException {
            EmbeddedData embeddedDataExtract = super.extract(directoryNode);
            embeddedDataExtract.setFilename(directoryNode.getName() + ".ole");
            return embeddedDataExtract;
        }
    }

    protected static void copyNodes(DirectoryNode directoryNode, DirectoryNode directoryNode2) throws IOException {
        for (Entry entry : directoryNode) {
            if (entry instanceof DirectoryNode) {
                DirectoryNode directoryNode3 = (DirectoryNode) entry;
                DirectoryNode directoryNode4 = (DirectoryNode) directoryNode2.createDirectory(directoryNode3.getName());
                directoryNode4.setStorageClsid(directoryNode3.getStorageClsid());
                copyNodes(directoryNode3, directoryNode4);
            } else {
                DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(entry);
                try {
                    directoryNode2.createDocument(entry.getName(), documentInputStreamCreateDocumentInputStream);
                    documentInputStreamCreateDocumentInputStream.close();
                } catch (Throwable th) {
                    documentInputStreamCreateDocumentInputStream.close();
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(byte[] bArr, int i, byte[] bArr2) {
        int[] iArrComputeFailure = computeFailure(bArr2);
        if (bArr.length == 0) {
            return -1;
        }
        int i2 = 0;
        while (i < bArr.length) {
            while (i2 > 0 && bArr2[i2] != bArr[i]) {
                i2 = iArrComputeFailure[i2 - 1];
            }
            if (bArr2[i2] == bArr[i]) {
                i2++;
            }
            if (i2 == bArr2.length) {
                return (i - bArr2.length) + 1;
            }
            i++;
        }
        return -1;
    }

    private static int[] computeFailure(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i = 0;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            while (i > 0 && bArr[i] != bArr[i2]) {
                i = iArr[i - 1];
            }
            if (bArr[i] == bArr[i2]) {
                i++;
            }
            iArr[i2] = i;
        }
        return iArr;
    }
}
