package org.apache.poi.openxml4j.opc.internal.marshallers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackageNamespaces;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ZipPartMarshaller implements PartMarshaller {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) ZipPartMarshaller.class);

    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart packagePart, OutputStream outputStream) throws OpenXML4JException {
        int i;
        if (!(outputStream instanceof ZipOutputStream)) {
            logger.log(7, "Unexpected class " + outputStream.getClass().getName());
            throw new OpenXML4JException("ZipOutputStream expected !");
        }
        if (packagePart.getSize() == 0 && packagePart.getPartName().getName().equals(XSSFRelation.SHARED_STRINGS.getDefaultFileName())) {
            return true;
        }
        ZipOutputStream zipOutputStream = (ZipOutputStream) outputStream;
        try {
            zipOutputStream.putNextEntry(new ZipEntry(ZipHelper.getZipItemNameFromOPCName(packagePart.getPartName().getURI().getPath())));
            InputStream inputStream = packagePart.getInputStream();
            byte[] bArr = new byte[8192];
            while (inputStream.available() > 0 && (i = inputStream.read(bArr)) != -1) {
                zipOutputStream.write(bArr, 0, i);
            }
            zipOutputStream.closeEntry();
            if (packagePart.hasRelationships()) {
                marshallRelationshipPart(packagePart.getRelationships(), PackagingURIHelper.getRelationshipPartName(packagePart.getPartName()), zipOutputStream);
            }
            return true;
        } catch (IOException e) {
            logger.log(7, "Cannot write: " + packagePart.getPartName() + ": in ZIP", e);
            return false;
        }
    }

    public static boolean marshallRelationshipPart(PackageRelationshipCollection packageRelationshipCollection, PackagePartName packagePartName, ZipOutputStream zipOutputStream) {
        String string;
        Document documentCreateDocument = DocumentHelper.createDocument();
        Element elementCreateElementNS = documentCreateDocument.createElementNS(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIPS_TAG_NAME);
        documentCreateDocument.appendChild(elementCreateElementNS);
        URI sourcePartUriFromRelationshipPartUri = PackagingURIHelper.getSourcePartUriFromRelationshipPartUri(packagePartName.getURI());
        for (PackageRelationship packageRelationship : packageRelationshipCollection) {
            Element elementCreateElementNS2 = documentCreateDocument.createElementNS(PackageNamespaces.RELATIONSHIPS, PackageRelationship.RELATIONSHIP_TAG_NAME);
            elementCreateElementNS.appendChild(elementCreateElementNS2);
            elementCreateElementNS2.setAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, packageRelationship.getId());
            elementCreateElementNS2.setAttribute(PackageRelationship.TYPE_ATTRIBUTE_NAME, packageRelationship.getRelationshipType());
            URI targetURI = packageRelationship.getTargetURI();
            if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
                string = targetURI.toString();
                elementCreateElementNS2.setAttribute(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME, "External");
            } else {
                string = PackagingURIHelper.relativizeURI(sourcePartUriFromRelationshipPartUri, packageRelationship.getTargetURI(), true).toString();
            }
            elementCreateElementNS2.setAttribute(PackageRelationship.TARGET_ATTRIBUTE_NAME, string);
        }
        documentCreateDocument.normalize();
        try {
            zipOutputStream.putNextEntry(new ZipEntry(ZipHelper.getZipURIFromOPCName(packagePartName.getURI().toASCIIString()).getPath()));
            if (!StreamHelper.saveXmlInStream(documentCreateDocument, zipOutputStream)) {
                return false;
            }
            zipOutputStream.closeEntry();
            return true;
        } catch (IOException e) {
            logger.log(7, "Cannot create zip entry " + packagePartName, e);
            return false;
        }
    }
}
