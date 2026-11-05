package org.apache.poi.poifs.crypt.dsig;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.facets.KeyInfoSignatureFacet;
import org.apache.poi.poifs.crypt.dsig.facets.OOXMLSignatureFacet;
import org.apache.poi.poifs.crypt.dsig.facets.Office2010SignatureFacet;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.poi.poifs.crypt.dsig.facets.XAdESSignatureFacet;
import org.apache.poi.poifs.crypt.dsig.services.RevocationDataService;
import org.apache.poi.poifs.crypt.dsig.services.SignaturePolicyService;
import org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampService;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampServiceValidator;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.events.EventListener;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class SignatureConfig {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) SignatureConfig.class);
    private PrivateKey key;
    private String proxyUrl;
    private RevocationDataService revocationDataService;
    private SignaturePolicyService signaturePolicyService;
    private List<X509Certificate> signingCertificateChain;
    private String tspPass;
    private String tspUrl;
    private String tspUser;
    private TimeStampServiceValidator tspValidator;
    private ThreadLocal<OPCPackage> opcPackage = new ThreadLocal<>();
    private ThreadLocal<XMLSignatureFactory> signatureFactory = new ThreadLocal<>();
    private ThreadLocal<KeyInfoFactory> keyInfoFactory = new ThreadLocal<>();
    private ThreadLocal<Provider> provider = new ThreadLocal<>();
    private List<SignatureFacet> signatureFacets = new ArrayList();
    private HashAlgorithm digestAlgo = HashAlgorithm.sha1;
    private Date executionTime = new Date();
    private URIDereferencer uriDereferencer = null;
    private String canonicalizationMethod = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    private boolean includeEntireCertificateChain = true;
    private boolean includeIssuerSerial = false;
    private boolean includeKeyValue = false;
    private TimeStampService tspService = new TSPTimeStampService();
    private boolean tspOldProtocol = false;
    private HashAlgorithm tspDigestAlgo = null;
    private String tspRequestPolicy = "1.3.6.1.4.1.13762.3";
    private String userAgent = "POI XmlSign Service TSP Client";
    private HashAlgorithm xadesDigestAlgo = null;
    private String xadesRole = null;
    private String xadesSignatureId = "idSignedProperties";
    private boolean xadesSignaturePolicyImplied = true;
    private String xadesCanonicalizationMethod = "http://www.w3.org/2001/10/xml-exc-c14n#";
    private boolean xadesIssuerNameNoReverseOrder = true;
    private String packageSignatureId = "idPackageSignature";
    private String signatureDescription = "Office OpenXML Document";
    EventListener signatureMarshalListener = null;
    Map<String, String> namespacePrefixes = new HashMap();

    public interface SignatureConfigurable {
        void setSignatureConfig(SignatureConfig signatureConfig);
    }

    protected static <T> T nvl(T t, T t2) {
        return t == null ? t2 : t;
    }

    protected void init(boolean z) {
        if (this.opcPackage == null) {
            throw new EncryptedDocumentException("opcPackage is null");
        }
        if (this.uriDereferencer == null) {
            this.uriDereferencer = new OOXMLURIDereferencer();
        }
        SignatureConfigurable signatureConfigurable = this.uriDereferencer;
        if (signatureConfigurable instanceof SignatureConfigurable) {
            signatureConfigurable.setSignatureConfig(this);
        }
        if (this.namespacePrefixes.isEmpty()) {
            this.namespacePrefixes.put("http://schemas.openxmlformats.org/package/2006/digital-signature", "mdssi");
            this.namespacePrefixes.put(SignatureFacet.XADES_132_NS, "xd");
        }
        if (z) {
            return;
        }
        if (this.signatureMarshalListener == null) {
            this.signatureMarshalListener = new SignatureMarshalListener();
        }
        SignatureConfigurable signatureConfigurable2 = this.signatureMarshalListener;
        if (signatureConfigurable2 instanceof SignatureConfigurable) {
            signatureConfigurable2.setSignatureConfig(this);
        }
        TimeStampService timeStampService = this.tspService;
        if (timeStampService != null) {
            timeStampService.setSignatureConfig(this);
        }
        if (this.signatureFacets.isEmpty()) {
            addSignatureFacet(new OOXMLSignatureFacet());
            addSignatureFacet(new KeyInfoSignatureFacet());
            addSignatureFacet(new XAdESSignatureFacet());
            addSignatureFacet(new Office2010SignatureFacet());
        }
        Iterator<SignatureFacet> it = this.signatureFacets.iterator();
        while (it.hasNext()) {
            it.next().setSignatureConfig(this);
        }
    }

    public void addSignatureFacet(SignatureFacet signatureFacet) {
        this.signatureFacets.add(signatureFacet);
    }

    public List<SignatureFacet> getSignatureFacets() {
        return this.signatureFacets;
    }

    public void setSignatureFacets(List<SignatureFacet> list) {
        this.signatureFacets = list;
    }

    public HashAlgorithm getDigestAlgo() {
        return this.digestAlgo;
    }

    public void setDigestAlgo(HashAlgorithm hashAlgorithm) {
        this.digestAlgo = hashAlgorithm;
    }

    public OPCPackage getOpcPackage() {
        return this.opcPackage.get();
    }

    public void setOpcPackage(OPCPackage oPCPackage) {
        this.opcPackage.set(oPCPackage);
    }

    public PrivateKey getKey() {
        return this.key;
    }

    public void setKey(PrivateKey privateKey) {
        this.key = privateKey;
    }

    public List<X509Certificate> getSigningCertificateChain() {
        return this.signingCertificateChain;
    }

    public void setSigningCertificateChain(List<X509Certificate> list) {
        this.signingCertificateChain = list;
    }

    public Date getExecutionTime() {
        return this.executionTime;
    }

    public void setExecutionTime(Date date) {
        this.executionTime = date;
    }

    public SignaturePolicyService getSignaturePolicyService() {
        return this.signaturePolicyService;
    }

    public void setSignaturePolicyService(SignaturePolicyService signaturePolicyService) {
        this.signaturePolicyService = signaturePolicyService;
    }

    public URIDereferencer getUriDereferencer() {
        return this.uriDereferencer;
    }

    public void setUriDereferencer(URIDereferencer uRIDereferencer) {
        this.uriDereferencer = uRIDereferencer;
    }

    public String getSignatureDescription() {
        return this.signatureDescription;
    }

    public void setSignatureDescription(String str) {
        this.signatureDescription = str;
    }

    public String getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public void setCanonicalizationMethod(String str) {
        this.canonicalizationMethod = str;
    }

    public String getPackageSignatureId() {
        return this.packageSignatureId;
    }

    public void setPackageSignatureId(String str) {
        this.packageSignatureId = (String) nvl(str, "xmldsig-" + UUID.randomUUID());
    }

    public String getTspUrl() {
        return this.tspUrl;
    }

    public void setTspUrl(String str) {
        this.tspUrl = str;
    }

    public boolean isTspOldProtocol() {
        return this.tspOldProtocol;
    }

    public void setTspOldProtocol(boolean z) {
        this.tspOldProtocol = z;
    }

    public HashAlgorithm getTspDigestAlgo() {
        return (HashAlgorithm) nvl(this.tspDigestAlgo, this.digestAlgo);
    }

    public void setTspDigestAlgo(HashAlgorithm hashAlgorithm) {
        this.tspDigestAlgo = hashAlgorithm;
    }

    public String getProxyUrl() {
        return this.proxyUrl;
    }

    public void setProxyUrl(String str) {
        this.proxyUrl = str;
    }

    public TimeStampService getTspService() {
        return this.tspService;
    }

    public void setTspService(TimeStampService timeStampService) {
        this.tspService = timeStampService;
    }

    public String getTspUser() {
        return this.tspUser;
    }

    public void setTspUser(String str) {
        this.tspUser = str;
    }

    public String getTspPass() {
        return this.tspPass;
    }

    public void setTspPass(String str) {
        this.tspPass = str;
    }

    public TimeStampServiceValidator getTspValidator() {
        return this.tspValidator;
    }

    public void setTspValidator(TimeStampServiceValidator timeStampServiceValidator) {
        this.tspValidator = timeStampServiceValidator;
    }

    public RevocationDataService getRevocationDataService() {
        return this.revocationDataService;
    }

    public void setRevocationDataService(RevocationDataService revocationDataService) {
        this.revocationDataService = revocationDataService;
    }

    public HashAlgorithm getXadesDigestAlgo() {
        return (HashAlgorithm) nvl(this.xadesDigestAlgo, this.digestAlgo);
    }

    public void setXadesDigestAlgo(HashAlgorithm hashAlgorithm) {
        this.xadesDigestAlgo = hashAlgorithm;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public String getTspRequestPolicy() {
        return this.tspRequestPolicy;
    }

    public void setTspRequestPolicy(String str) {
        this.tspRequestPolicy = str;
    }

    public boolean isIncludeEntireCertificateChain() {
        return this.includeEntireCertificateChain;
    }

    public void setIncludeEntireCertificateChain(boolean z) {
        this.includeEntireCertificateChain = z;
    }

    public boolean isIncludeIssuerSerial() {
        return this.includeIssuerSerial;
    }

    public void setIncludeIssuerSerial(boolean z) {
        this.includeIssuerSerial = z;
    }

    public boolean isIncludeKeyValue() {
        return this.includeKeyValue;
    }

    public void setIncludeKeyValue(boolean z) {
        this.includeKeyValue = z;
    }

    public String getXadesRole() {
        return this.xadesRole;
    }

    public void setXadesRole(String str) {
        this.xadesRole = str;
    }

    public String getXadesSignatureId() {
        return (String) nvl(this.xadesSignatureId, "idSignedProperties");
    }

    public void setXadesSignatureId(String str) {
        this.xadesSignatureId = str;
    }

    public boolean isXadesSignaturePolicyImplied() {
        return this.xadesSignaturePolicyImplied;
    }

    public void setXadesSignaturePolicyImplied(boolean z) {
        this.xadesSignaturePolicyImplied = z;
    }

    public boolean isXadesIssuerNameNoReverseOrder() {
        return this.xadesIssuerNameNoReverseOrder;
    }

    public void setXadesIssuerNameNoReverseOrder(boolean z) {
        this.xadesIssuerNameNoReverseOrder = z;
    }

    public EventListener getSignatureMarshalListener() {
        return this.signatureMarshalListener;
    }

    public void setSignatureMarshalListener(EventListener eventListener) {
        this.signatureMarshalListener = eventListener;
    }

    public Map<String, String> getNamespacePrefixes() {
        return this.namespacePrefixes;
    }

    public void setNamespacePrefixes(Map<String, String> map) {
        this.namespacePrefixes = map;
    }

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.dsig.SignatureConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm;

        static {
            int[] iArr = new int[HashAlgorithm.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm = iArr;
            try {
                iArr[HashAlgorithm.sha1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.ripemd128.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.ripemd160.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public byte[] getHashMagic() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[getDigestAlgo().ordinal()]) {
            case 1:
                return new byte[]{48, NumberPtg.sid, 48, 7, 6, 5, AreaErrPtg.sid, NotEqualPtg.sid, 3, 2, 26, 4, PercentPtg.sid};
            case 2:
                return new byte[]{48, AreaErrPtg.sid, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 4, 4, 28};
            case 3:
                return new byte[]{48, 47, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 1, 4, 32};
            case 4:
                return new byte[]{48, 63, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 2, 4, 48};
            case 5:
                return new byte[]{48, 79, 48, 11, 6, 9, 96, -122, 72, 1, 101, 3, 4, 2, 3, 4, Ptg.CLASS_ARRAY};
            case 6:
                return new byte[]{48, 27, 48, 7, 6, 5, AreaErrPtg.sid, RefPtg.sid, 3, 2, 2, 4, UnionPtg.sid};
            case 7:
                return new byte[]{48, NumberPtg.sid, 48, 7, 6, 5, AreaErrPtg.sid, RefPtg.sid, 3, 2, 1, 4, PercentPtg.sid};
            default:
                throw new EncryptedDocumentException("Hash algorithm " + getDigestAlgo() + " not supported for signing.");
        }
    }

    public String getSignatureMethodUri() {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[getDigestAlgo().ordinal()];
        if (i == 1) {
            return "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
        }
        if (i == 2) {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha224";
        }
        if (i == 3) {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
        }
        if (i == 4) {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384";
        }
        if (i == 5) {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512";
        }
        if (i == 7) {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-ripemd160";
        }
        throw new EncryptedDocumentException("Hash algorithm " + getDigestAlgo() + " not supported for signing.");
    }

    public String getDigestMethodUri() {
        return getDigestMethodUri(getDigestAlgo());
    }

    public static String getDigestMethodUri(HashAlgorithm hashAlgorithm) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[hashAlgorithm.ordinal()];
        if (i == 1) {
            return "http://www.w3.org/2000/09/xmldsig#sha1";
        }
        if (i == 2) {
            return "http://www.w3.org/2001/04/xmldsig-more#sha224";
        }
        if (i == 3) {
            return "http://www.w3.org/2001/04/xmlenc#sha256";
        }
        if (i == 4) {
            return "http://www.w3.org/2001/04/xmldsig-more#sha384";
        }
        if (i == 5) {
            return "http://www.w3.org/2001/04/xmlenc#sha512";
        }
        if (i == 7) {
            return "http://www.w3.org/2001/04/xmlenc#ripemd160";
        }
        throw new EncryptedDocumentException("Hash algorithm " + hashAlgorithm + " not supported for signing.");
    }

    public void setSignatureFactory(XMLSignatureFactory xMLSignatureFactory) {
        this.signatureFactory.set(xMLSignatureFactory);
    }

    public XMLSignatureFactory getSignatureFactory() {
        XMLSignatureFactory xMLSignatureFactory = this.signatureFactory.get();
        if (xMLSignatureFactory != null) {
            return xMLSignatureFactory;
        }
        XMLSignatureFactory xMLSignatureFactory2 = XMLSignatureFactory.getInstance("DOM", getProvider());
        setSignatureFactory(xMLSignatureFactory2);
        return xMLSignatureFactory2;
    }

    public void setKeyInfoFactory(KeyInfoFactory keyInfoFactory) {
        this.keyInfoFactory.set(keyInfoFactory);
    }

    public KeyInfoFactory getKeyInfoFactory() {
        KeyInfoFactory keyInfoFactory = this.keyInfoFactory.get();
        if (keyInfoFactory != null) {
            return keyInfoFactory;
        }
        KeyInfoFactory keyInfoFactory2 = KeyInfoFactory.getInstance("DOM", getProvider());
        setKeyInfoFactory(keyInfoFactory2);
        return keyInfoFactory2;
    }

    public Provider getProvider() {
        Provider provider = this.provider.get();
        if (provider == null) {
            String[] strArr = {System.getProperty("jsr105Provider"), "org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI", "org.jcp.xml.dsig.internal.dom.XMLDSigRI"};
            for (int i = 0; i < 3; i++) {
                String str = strArr[i];
                if (str != null) {
                    try {
                        provider = (Provider) Class.forName(str).newInstance();
                        break;
                    } catch (Exception unused) {
                        LOG.log(1, "XMLDsig-Provider '" + str + "' can't be found - trying next.");
                    }
                }
            }
        }
        if (provider != null) {
            return provider;
        }
        throw new RuntimeException("JRE doesn't support default xml signature provider - set jsr105Provider system property!");
    }

    public String getXadesCanonicalizationMethod() {
        return this.xadesCanonicalizationMethod;
    }

    public void setXadesCanonicalizationMethod(String str) {
        this.xadesCanonicalizationMethod = str;
    }
}
