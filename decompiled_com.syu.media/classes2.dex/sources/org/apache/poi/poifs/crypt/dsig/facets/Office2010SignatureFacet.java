package org.apache.poi.poifs.crypt.dsig.facets;

import javax.xml.crypto.MarshalException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.XmlException;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Office2010SignatureFacet extends SignatureFacet {
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.MarshalException */
    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(Document document) throws MarshalException {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XADES_132_NS, "QualifyingProperties");
        if (elementsByTagNameNS.getLength() != 1) {
            throw new MarshalException("no XAdES-BES extension present");
        }
        try {
            QualifyingPropertiesType qualifyingPropertiesType = QualifyingPropertiesType.Factory.parse(elementsByTagNameNS.item(0), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            UnsignedPropertiesType unsignedProperties = qualifyingPropertiesType.getUnsignedProperties();
            if (unsignedProperties == null) {
                unsignedProperties = qualifyingPropertiesType.addNewUnsignedProperties();
            }
            if (unsignedProperties.getUnsignedSignatureProperties() == null) {
                unsignedProperties.addNewUnsignedSignatureProperties();
            }
            elementsByTagNameNS.item(0).getParentNode().replaceChild(document.importNode(qualifyingPropertiesType.getDomNode().getFirstChild(), true), elementsByTagNameNS.item(0));
        } catch (XmlException e) {
            throw new MarshalException(e);
        }
    }
}
