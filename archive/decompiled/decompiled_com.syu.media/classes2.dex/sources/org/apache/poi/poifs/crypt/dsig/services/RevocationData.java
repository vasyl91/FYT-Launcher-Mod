package org.apache.poi.poifs.crypt.dsig.services;

import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RevocationData {
    private final List<byte[]> crls = new ArrayList();
    private final List<byte[]> ocsps = new ArrayList();

    public void addCRL(byte[] bArr) {
        this.crls.add(bArr);
    }

    public void addCRL(X509CRL x509crl) {
        try {
            addCRL(x509crl.getEncoded());
        } catch (CRLException e) {
            throw new IllegalArgumentException("CRL coding error: " + e.getMessage(), e);
        }
    }

    public void addOCSP(byte[] bArr) {
        this.ocsps.add(bArr);
    }

    public List<byte[]> getCRLs() {
        return this.crls;
    }

    public List<byte[]> getOCSPs() {
        return this.ocsps;
    }

    public boolean hasOCSPs() {
        return !this.ocsps.isEmpty();
    }

    public boolean hasCRLs() {
        return !this.crls.isEmpty();
    }

    public boolean hasRevocationDataEntries() {
        return hasOCSPs() || hasCRLs();
    }
}
