package org.apache.poi.openxml4j.opc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.internal.ContentType;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class PackagePart implements RelationshipSource, Comparable<PackagePart> {
    protected OPCPackage _container;
    protected ContentType _contentType;
    private boolean _isDeleted;
    private boolean _isRelationshipPart;
    protected PackagePartName _partName;
    private PackageRelationshipCollection _relationships;

    public void clear() {
    }

    public abstract void close();

    public abstract void flush();

    protected abstract InputStream getInputStreamImpl() throws IOException;

    protected abstract OutputStream getOutputStreamImpl();

    public long getSize() {
        return -1L;
    }

    public abstract boolean load(InputStream inputStream) throws InvalidFormatException;

    public abstract boolean save(OutputStream outputStream) throws OpenXML4JException;

    protected PackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, ContentType contentType) throws InvalidFormatException {
        this(oPCPackage, packagePartName, contentType, true);
    }

    protected PackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, ContentType contentType, boolean z) throws InvalidFormatException {
        this._partName = packagePartName;
        this._contentType = contentType;
        this._container = oPCPackage;
        this._isRelationshipPart = packagePartName.isRelationshipPartURI();
        if (z) {
            loadRelationships();
        }
    }

    public PackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str) throws InvalidFormatException {
        this(oPCPackage, packagePartName, new ContentType(str));
    }

    public PackageRelationship findExistingRelation(PackagePart packagePart) {
        return this._relationships.findExistingInternalRelation(packagePart);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addExternalRelationship(String str, String str2) {
        return addExternalRelationship(str, str2, null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addExternalRelationship(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException("target is null for type " + str2);
        }
        if (str2 == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this._relationships == null) {
            this._relationships = new PackageRelationshipCollection();
        }
        try {
            return this._relationships.addRelationship(new URI(str), TargetMode.EXTERNAL, str2, str3);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid target - " + e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str) {
        return addRelationship(packagePartName, targetMode, str, (String) null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str, String str2) {
        this._container.throwExceptionIfReadOnly();
        if (packagePartName == null) {
            throw new IllegalArgumentException("targetPartName");
        }
        if (targetMode == null) {
            throw new IllegalArgumentException("targetMode");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this._isRelationshipPart || packagePartName.isRelationshipPartURI()) {
            throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        if (this._relationships == null) {
            this._relationships = new PackageRelationshipCollection();
        }
        return this._relationships.addRelationship(packagePartName.getURI(), targetMode, str, str2);
    }

    public PackageRelationship addRelationship(URI uri, TargetMode targetMode, String str) {
        return addRelationship(uri, targetMode, str, (String) null);
    }

    public PackageRelationship addRelationship(URI uri, TargetMode targetMode, String str, String str2) {
        this._container.throwExceptionIfReadOnly();
        if (uri == null) {
            throw new IllegalArgumentException("targetPartName");
        }
        if (targetMode == null) {
            throw new IllegalArgumentException("targetMode");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this._isRelationshipPart || PackagingURIHelper.isRelationshipPartURI(uri)) {
            throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        if (this._relationships == null) {
            this._relationships = new PackageRelationshipCollection();
        }
        return this._relationships.addRelationship(uri, targetMode, str, str2);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public void clearRelationships() {
        PackageRelationshipCollection packageRelationshipCollection = this._relationships;
        if (packageRelationshipCollection != null) {
            packageRelationshipCollection.clear();
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public void removeRelationship(String str) {
        this._container.throwExceptionIfReadOnly();
        PackageRelationshipCollection packageRelationshipCollection = this._relationships;
        if (packageRelationshipCollection != null) {
            packageRelationshipCollection.removeRelationship(str);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationshipCollection getRelationships() throws InvalidFormatException {
        return getRelationshipsCore(null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship getRelationship(String str) {
        return this._relationships.getRelationshipByID(str);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationshipCollection getRelationshipsByType(String str) throws InvalidFormatException {
        this._container.throwExceptionIfWriteOnly();
        return getRelationshipsCore(str);
    }

    private PackageRelationshipCollection getRelationshipsCore(String str) throws InvalidFormatException {
        this._container.throwExceptionIfWriteOnly();
        if (this._relationships == null) {
            throwExceptionIfRelationship();
            this._relationships = new PackageRelationshipCollection(this);
        }
        return new PackageRelationshipCollection(this._relationships, str);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public boolean hasRelationships() {
        PackageRelationshipCollection packageRelationshipCollection;
        return (this._isRelationshipPart || (packageRelationshipCollection = this._relationships) == null || packageRelationshipCollection.size() <= 0) ? false : true;
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public boolean isRelationshipExists(PackageRelationship packageRelationship) {
        return this._relationships.getRelationshipByID(packageRelationship.getId()) != null;
    }

    public PackagePart getRelatedPart(PackageRelationship packageRelationship) throws InvalidFormatException {
        if (!isRelationshipExists(packageRelationship)) {
            throw new IllegalArgumentException("Relationship " + packageRelationship + " doesn't start with this part " + this._partName);
        }
        URI targetURI = packageRelationship.getTargetURI();
        if (targetURI.getFragment() != null) {
            String string = targetURI.toString();
            try {
                targetURI = new URI(string.substring(0, string.indexOf(35)));
            } catch (URISyntaxException unused) {
                throw new InvalidFormatException("Invalid target URI: " + targetURI);
            }
        }
        PackagePart part = this._container.getPart(PackagingURIHelper.createPartName(targetURI));
        if (part != null) {
            return part;
        }
        throw new IllegalArgumentException("No part found for relationship " + packageRelationship);
    }

    public InputStream getInputStream() throws IOException {
        InputStream inputStreamImpl = getInputStreamImpl();
        if (inputStreamImpl != null) {
            return inputStreamImpl;
        }
        throw new IOException("Can't obtain the input stream from " + this._partName.getName());
    }

    public OutputStream getOutputStream() {
        if (this instanceof ZipPackagePart) {
            this._container.removePart(this._partName);
            PackagePart packagePartCreatePart = this._container.createPart(this._partName, this._contentType.toString(), false);
            if (packagePartCreatePart == null) {
                throw new InvalidOperationException("Can't create a temporary part !");
            }
            packagePartCreatePart._relationships = this._relationships;
            return packagePartCreatePart.getOutputStreamImpl();
        }
        return getOutputStreamImpl();
    }

    private void throwExceptionIfRelationship() throws InvalidOperationException {
        if (this._isRelationshipPart) {
            throw new InvalidOperationException("Can do this operation on a relationship part !");
        }
    }

    private void loadRelationships() throws InvalidFormatException {
        if (this._relationships != null || this._isRelationshipPart) {
            return;
        }
        throwExceptionIfRelationship();
        this._relationships = new PackageRelationshipCollection(this);
    }

    public PackagePartName getPartName() {
        return this._partName;
    }

    public String getContentType() {
        return this._contentType.toString();
    }

    public ContentType getContentTypeDetails() {
        return this._contentType;
    }

    public void setContentType(String str) throws InvalidFormatException {
        OPCPackage oPCPackage = this._container;
        if (oPCPackage == null) {
            this._contentType = new ContentType(str);
            return;
        }
        oPCPackage.unregisterPartAndContentType(this._partName);
        this._contentType = new ContentType(str);
        this._container.registerPartAndContentType(this);
    }

    public OPCPackage getPackage() {
        return this._container;
    }

    public boolean isRelationshipPart() {
        return this._isRelationshipPart;
    }

    public boolean isDeleted() {
        return this._isDeleted;
    }

    public void setDeleted(boolean z) {
        this._isDeleted = z;
    }

    public String toString() {
        return "Name: " + this._partName + " - Content Type: " + this._contentType;
    }

    @Override // java.lang.Comparable
    public int compareTo(PackagePart packagePart) {
        if (packagePart == null) {
            return -1;
        }
        return PackagePartName.compare(this._partName, packagePart._partName);
    }
}
