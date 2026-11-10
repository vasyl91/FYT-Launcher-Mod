package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.MastersDocument;
import com.microsoft.schemas.office.visio.x2012.main.MastersType;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XDGFMasters extends XDGFXMLDocumentPart {
    protected Map<Long, XDGFMaster> _masters;
    MastersType _mastersObject;

    public XDGFMasters(PackagePart packagePart, XDGFDocument xDGFDocument) {
        super(packagePart, xDGFDocument);
        this._masters = new HashMap();
    }

    @Internal
    protected MastersType getXmlObject() {
        return this._mastersObject;
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() {
        try {
            try {
                this._mastersObject = MastersDocument.Factory.parse(getPackagePart().getInputStream()).getMasters();
                HashMap map = new HashMap();
                for (MasterType masterType : this._mastersObject.getMasterArray()) {
                    map.put(masterType.getRel().getId(), masterType);
                }
                for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                    POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                    String id = relationPart.getRelationship().getId();
                    MasterType masterType2 = (MasterType) map.get(id);
                    if (masterType2 == null) {
                        throw new POIXMLException("Master relationship for " + id + " not found");
                    }
                    if (!(documentPart instanceof XDGFMasterContents)) {
                        throw new POIXMLException("Unexpected masters relationship for " + id + ": " + documentPart);
                    }
                    XDGFMasterContents xDGFMasterContents = (XDGFMasterContents) documentPart;
                    xDGFMasterContents.onDocumentRead();
                    XDGFMaster xDGFMaster = new XDGFMaster(masterType2, xDGFMasterContents, this._document);
                    this._masters.put(Long.valueOf(xDGFMaster.getID()), xDGFMaster);
                }
            } catch (IOException e) {
                throw new POIXMLException(e);
            } catch (XmlException e2) {
                throw new POIXMLException(e2);
            }
        } catch (POIXMLException e3) {
            throw XDGFException.wrap(this, e3);
        }
    }

    public Collection<XDGFMaster> getMastersList() {
        return Collections.unmodifiableCollection(this._masters.values());
    }

    public XDGFMaster getMasterById(long j) {
        return this._masters.get(Long.valueOf(j));
    }
}
