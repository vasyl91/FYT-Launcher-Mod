package org.apache.poi.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class PackageHelper {
    public static OPCPackage open(InputStream inputStream) throws IOException {
        try {
            return OPCPackage.open(inputStream);
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public static OPCPackage clone(OPCPackage oPCPackage, File file) throws OpenXML4JException, IOException {
        String absolutePath = file.getAbsolutePath();
        OPCPackage oPCPackageCreate = OPCPackage.create(absolutePath);
        for (PackageRelationship packageRelationship : oPCPackage.getRelationships()) {
            PackagePart part = oPCPackage.getPart(packageRelationship);
            if (packageRelationship.getRelationshipType().equals(PackageRelationshipTypes.CORE_PROPERTIES)) {
                copyProperties(oPCPackage.getPackageProperties(), oPCPackageCreate.getPackageProperties());
            } else {
                oPCPackageCreate.addRelationship(part.getPartName(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType());
                PackagePart packagePartCreatePart = oPCPackageCreate.createPart(part.getPartName(), part.getContentType());
                OutputStream outputStream = packagePartCreatePart.getOutputStream();
                IOUtils.copy(part.getInputStream(), outputStream);
                outputStream.close();
                if (part.hasRelationships()) {
                    copy(oPCPackage, part, oPCPackageCreate, packagePartCreatePart);
                }
            }
        }
        oPCPackageCreate.close();
        new File(absolutePath).deleteOnExit();
        return OPCPackage.open(absolutePath);
    }

    private static void copy(OPCPackage oPCPackage, PackagePart packagePart, OPCPackage oPCPackage2, PackagePart packagePart2) throws OpenXML4JException, IOException {
        PackageRelationshipCollection relationships = packagePart.getRelationships();
        if (relationships != null) {
            for (PackageRelationship packageRelationship : relationships) {
                if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
                    packagePart2.addExternalRelationship(packageRelationship.getTargetURI().toString(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                } else {
                    URI targetURI = packageRelationship.getTargetURI();
                    if (targetURI.getRawFragment() != null) {
                        packagePart2.addRelationship(targetURI, packageRelationship.getTargetMode(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                    } else {
                        PackagePart part = oPCPackage.getPart(PackagingURIHelper.createPartName(packageRelationship.getTargetURI()));
                        packagePart2.addRelationship(part.getPartName(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                        if (!oPCPackage2.containPart(part.getPartName())) {
                            PackagePart packagePartCreatePart = oPCPackage2.createPart(part.getPartName(), part.getContentType());
                            OutputStream outputStream = packagePartCreatePart.getOutputStream();
                            IOUtils.copy(part.getInputStream(), outputStream);
                            outputStream.close();
                            copy(oPCPackage, part, oPCPackage2, packagePartCreatePart);
                        }
                    }
                }
            }
        }
    }

    private static void copyProperties(PackageProperties packageProperties, PackageProperties packageProperties2) {
        packageProperties2.setCategoryProperty(packageProperties.getCategoryProperty().getValue());
        packageProperties2.setContentStatusProperty(packageProperties.getContentStatusProperty().getValue());
        packageProperties2.setContentTypeProperty(packageProperties.getContentTypeProperty().getValue());
        packageProperties2.setCreatorProperty(packageProperties.getCreatorProperty().getValue());
        packageProperties2.setDescriptionProperty(packageProperties.getDescriptionProperty().getValue());
        packageProperties2.setIdentifierProperty(packageProperties.getIdentifierProperty().getValue());
        packageProperties2.setKeywordsProperty(packageProperties.getKeywordsProperty().getValue());
        packageProperties2.setLanguageProperty(packageProperties.getLanguageProperty().getValue());
        packageProperties2.setRevisionProperty(packageProperties.getRevisionProperty().getValue());
        packageProperties2.setSubjectProperty(packageProperties.getSubjectProperty().getValue());
        packageProperties2.setTitleProperty(packageProperties.getTitleProperty().getValue());
        packageProperties2.setVersionProperty(packageProperties.getVersionProperty().getValue());
    }
}
