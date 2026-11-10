package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.usermodel.Name;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ExternalLinksTable extends POIXMLDocumentPart {
    private CTExternalLink link;

    public ExternalLinksTable() {
        CTExternalLink cTExternalLinkNewInstance = CTExternalLink.Factory.newInstance();
        this.link = cTExternalLinkNewInstance;
        cTExternalLinkNewInstance.addNewExternalBook();
    }

    public ExternalLinksTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.link = ExternalLinkDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getExternalLink();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        ExternalLinkDocument externalLinkDocumentNewInstance = ExternalLinkDocument.Factory.newInstance();
        externalLinkDocumentNewInstance.setExternalLink(this.link);
        externalLinkDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public CTExternalLink getCTExternalLink() {
        return this.link;
    }

    public String getLinkedFileName() {
        PackageRelationship relationship = getPackagePart().getRelationship(this.link.getExternalBook().getId());
        if (relationship == null || relationship.getTargetMode() != TargetMode.EXTERNAL) {
            return null;
        }
        return relationship.getTargetURI().toString();
    }

    public void setLinkedFileName(String str) {
        String id = this.link.getExternalBook().getId();
        if (id != null && !id.isEmpty()) {
            getPackagePart().removeRelationship(id);
        }
        this.link.getExternalBook().setId(getPackagePart().addExternalRelationship(str, PackageRelationshipTypes.EXTERNAL_LINK_PATH).getId());
    }

    public List<String> getSheetNames() {
        CTExternalSheetName[] sheetNameArray = this.link.getExternalBook().getSheetNames().getSheetNameArray();
        ArrayList arrayList = new ArrayList(sheetNameArray.length);
        for (CTExternalSheetName cTExternalSheetName : sheetNameArray) {
            arrayList.add(cTExternalSheetName.getVal());
        }
        return arrayList;
    }

    public List<Name> getDefinedNames() {
        CTExternalDefinedName[] definedNameArray = this.link.getExternalBook().getDefinedNames().getDefinedNameArray();
        ArrayList arrayList = new ArrayList(definedNameArray.length);
        for (CTExternalDefinedName cTExternalDefinedName : definedNameArray) {
            arrayList.add(new ExternalName(cTExternalDefinedName));
        }
        return arrayList;
    }

    protected class ExternalName implements Name {
        private CTExternalDefinedName name;

        @Override // org.apache.poi.ss.usermodel.Name
        public String getComment() {
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public boolean isDeleted() {
            return false;
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public boolean isFunctionName() {
            return false;
        }

        protected ExternalName(CTExternalDefinedName cTExternalDefinedName) {
            this.name = cTExternalDefinedName;
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public String getNameName() {
            return this.name.getName();
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setNameName(String str) {
            this.name.setName(str);
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public String getSheetName() {
            int sheetIndex = getSheetIndex();
            if (sheetIndex >= 0) {
                return ExternalLinksTable.this.getSheetNames().get(sheetIndex);
            }
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public int getSheetIndex() {
            if (this.name.isSetSheetId()) {
                return (int) this.name.getSheetId();
            }
            return -1;
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setSheetIndex(int i) {
            this.name.setSheetId(i);
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public String getRefersToFormula() {
            return this.name.getRefersTo().substring(1);
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setRefersToFormula(String str) {
            this.name.setRefersTo("=" + str);
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setComment(String str) {
            throw new IllegalStateException("Not Supported");
        }

        @Override // org.apache.poi.ss.usermodel.Name
        public void setFunction(boolean z) {
            throw new IllegalStateException("Not Supported");
        }
    }
}
