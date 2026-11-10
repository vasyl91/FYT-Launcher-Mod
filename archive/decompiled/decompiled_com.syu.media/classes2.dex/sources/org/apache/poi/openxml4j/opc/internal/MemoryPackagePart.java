package org.apache.poi.openxml4j.opc.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class MemoryPackagePart extends PackagePart {
    protected byte[] data;

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void close() {
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void flush() {
    }

    public MemoryPackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str) throws InvalidFormatException {
        super(oPCPackage, packagePartName, str);
    }

    public MemoryPackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str, boolean z) throws InvalidFormatException {
        super(oPCPackage, packagePartName, new ContentType(str), z);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected InputStream getInputStreamImpl() {
        if (this.data == null) {
            this.data = new byte[0];
        }
        return new ByteArrayInputStream(this.data);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    protected OutputStream getOutputStreamImpl() {
        return new MemoryPackagePartOutputStream(this);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0L;
        }
        return bArr.length;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void clear() {
        this.data = null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) throws OpenXML4JException {
        return new ZipPartMarshaller().marshall(this, outputStream);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean load(InputStream inputStream) throws InvalidFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copy(inputStream, byteArrayOutputStream);
            this.data = byteArrayOutputStream.toByteArray();
            return true;
        } catch (IOException e) {
            throw new InvalidFormatException(e.getMessage());
        }
    }
}
