package org.apache.poi.poifs.crypt.dsig.facets;

import java.security.Key;
import java.security.KeyException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import org.apache.jcp.xml.dsig.internal.dom.DOMKeyInfo;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class KeyInfoSignatureFacet extends SignatureFacet {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) KeyInfoSignatureFacet.class);

    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(Document document) throws MarshalException {
        LOG.log(1, "postSign");
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, "Object");
        Node nodeItem = elementsByTagNameNS.getLength() == 0 ? null : elementsByTagNameNS.item(0);
        KeyInfoFactory keyInfoFactory = this.signatureConfig.getKeyInfoFactory();
        ArrayList arrayList = new ArrayList();
        X509Certificate x509Certificate = this.signatureConfig.getSigningCertificateChain().get(0);
        ArrayList arrayList2 = new ArrayList();
        if (this.signatureConfig.isIncludeKeyValue()) {
            try {
                arrayList2.add(keyInfoFactory.newKeyValue(x509Certificate.getPublicKey()));
            } catch (KeyException e) {
                throw new RuntimeException("key exception: " + e.getMessage(), e);
            }
        }
        if (this.signatureConfig.isIncludeIssuerSerial()) {
            arrayList.add(keyInfoFactory.newX509IssuerSerial(x509Certificate.getIssuerX500Principal().toString(), x509Certificate.getSerialNumber()));
        }
        if (this.signatureConfig.isIncludeEntireCertificateChain()) {
            arrayList.addAll(this.signatureConfig.getSigningCertificateChain());
        } else {
            arrayList.add(x509Certificate);
        }
        if (!arrayList.isEmpty()) {
            arrayList2.add(keyInfoFactory.newX509Data(arrayList));
        }
        DOMKeyInfo dOMKeyInfoNewKeyInfo = keyInfoFactory.newKeyInfo(arrayList2);
        Key key = new Key() { // from class: org.apache.poi.poifs.crypt.dsig.facets.KeyInfoSignatureFacet.1
            private static final long serialVersionUID = 1;

            @Override // java.security.Key
            public String getAlgorithm() {
                return null;
            }

            @Override // java.security.Key
            public byte[] getEncoded() {
                return null;
            }

            @Override // java.security.Key
            public String getFormat() {
                return null;
            }
        };
        Element documentElement = document.getDocumentElement();
        DOMSignContext dOMSignContext = nodeItem == null ? new DOMSignContext(key, documentElement) : new DOMSignContext(key, documentElement, nodeItem);
        for (Map.Entry<String, String> entry : this.signatureConfig.getNamespacePrefixes().entrySet()) {
            dOMSignContext.putNamespacePrefix(entry.getKey(), entry.getValue());
        }
        dOMKeyInfoNewKeyInfo.marshal(new DOMStructure(documentElement), dOMSignContext);
        if (nodeItem != null) {
            NodeList elementsByTagNameNS2 = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, "KeyInfo");
            if (elementsByTagNameNS2.getLength() != 1) {
                throw new RuntimeException("KeyInfo wasn't set");
            }
            nodeItem.getParentNode().insertBefore(elementsByTagNameNS2.item(0), nodeItem);
        }
    }
}
