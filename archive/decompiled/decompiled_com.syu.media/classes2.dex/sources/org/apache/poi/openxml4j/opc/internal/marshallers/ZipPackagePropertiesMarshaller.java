package org.apache.poi.openxml4j.opc.internal.marshallers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ZipPackagePropertiesMarshaller extends PackagePropertiesMarshaller {
    @Override // org.apache.poi.openxml4j.opc.internal.marshallers.PackagePropertiesMarshaller, org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart packagePart, OutputStream outputStream) throws OpenXML4JException {
        if (!(outputStream instanceof ZipOutputStream)) {
            throw new IllegalArgumentException("ZipOutputStream expected!");
        }
        ZipOutputStream zipOutputStream = (ZipOutputStream) outputStream;
        try {
            zipOutputStream.putNextEntry(new ZipEntry(ZipHelper.getZipItemNameFromOPCName(packagePart.getPartName().getURI().toString())));
            super.marshall(packagePart, outputStream);
            if (!StreamHelper.saveXmlInStream(this.xmlDoc, outputStream)) {
                return false;
            }
            zipOutputStream.closeEntry();
            return true;
        } catch (IOException e) {
            throw new OpenXML4JException(e.getLocalizedMessage(), e);
        }
    }
}
