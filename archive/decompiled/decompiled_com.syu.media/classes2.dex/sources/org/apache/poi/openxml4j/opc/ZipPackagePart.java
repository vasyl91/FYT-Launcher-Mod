package org.apache.poi.openxml4j.opc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.util.NotImplemented;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ZipPackagePart extends PackagePart {
    private ZipEntry zipEntry;

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected OutputStream getOutputStreamImpl() {
        return null;
    }

    public ZipPackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str) throws InvalidFormatException {
        super(oPCPackage, packagePartName, str);
    }

    public ZipPackagePart(OPCPackage oPCPackage, ZipEntry zipEntry, PackagePartName packagePartName, String str) throws InvalidFormatException {
        super(oPCPackage, packagePartName, str);
        this.zipEntry = zipEntry;
    }

    public ZipEntry getZipArchive() {
        return this.zipEntry;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected InputStream getInputStreamImpl() throws IOException {
        return ((ZipPackage) this._container).getZipArchive().getInputStream(this.zipEntry);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        return this.zipEntry.getSize();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) throws OpenXML4JException {
        return new ZipPartMarshaller().marshall(this, outputStream);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public boolean load(InputStream inputStream) {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public void close() {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public void flush() {
        throw new InvalidOperationException("Method not implemented !");
    }
}
