package org.apache.poi.poifs.crypt.dsig;

import java.security.Key;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class KeyInfoKeySelector extends KeySelector implements KeySelectorResult {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) KeyInfoKeySelector.class);
    private List<X509Certificate> certChain = new ArrayList();

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.KeySelectorException */
    public KeySelectorResult select(KeyInfo keyInfo, KeySelector.Purpose purpose, AlgorithmMethod algorithmMethod, XMLCryptoContext xMLCryptoContext) throws KeySelectorException {
        LOG.log(1, "select key");
        if (keyInfo == null) {
            throw new KeySelectorException("no ds:KeyInfo present");
        }
        List<X509Data> content = keyInfo.getContent();
        this.certChain.clear();
        for (X509Data x509Data : content) {
            if (x509Data instanceof X509Data) {
                for (Object obj : x509Data.getContent()) {
                    if (obj instanceof X509Certificate) {
                        X509Certificate x509Certificate = (X509Certificate) obj;
                        LOG.log(1, "certificate", x509Certificate.getSubjectX500Principal());
                        this.certChain.add(x509Certificate);
                    }
                }
            }
        }
        if (this.certChain.isEmpty()) {
            throw new KeySelectorException("No key found!");
        }
        return this;
    }

    public Key getKey() {
        if (this.certChain.isEmpty()) {
            return null;
        }
        return this.certChain.get(0).getPublicKey();
    }

    public X509Certificate getSigner() {
        if (this.certChain.isEmpty()) {
            return null;
        }
        return this.certChain.get(0);
    }

    public List<X509Certificate> getCertChain() {
        return this.certChain;
    }
}
