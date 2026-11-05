package org.apache.poi.poifs.crypt.dsig.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.bind.DatatypeConverter;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.DefaultCMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.cms.SignerId;
import org.bouncycastle.cms.bc.BcRSASignerInfoVerifierBuilder;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcDigestCalculatorProvider;
import org.bouncycastle.tsp.TimeStampRequest;
import org.bouncycastle.tsp.TimeStampRequestGenerator;
import org.bouncycastle.tsp.TimeStampResponse;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class TSPTimeStampService implements TimeStampService {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) TSPTimeStampService.class);
    private SignatureConfig signatureConfig;

    /* JADX INFO: renamed from: org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService$1, reason: invalid class name */
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
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ASN1ObjectIdentifier mapDigestAlgoToOID(HashAlgorithm hashAlgorithm) {
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[hashAlgorithm.ordinal()];
        if (i == 1) {
            return X509ObjectIdentifiers.id_SHA1;
        }
        if (i == 2) {
            return NISTObjectIdentifiers.id_sha256;
        }
        if (i == 3) {
            return NISTObjectIdentifiers.id_sha384;
        }
        if (i == 4) {
            return NISTObjectIdentifiers.id_sha512;
        }
        throw new IllegalArgumentException("unsupported digest algo: " + hashAlgorithm);
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampService
    public byte[] timeStamp(byte[] bArr, RevocationData revocationData) throws Exception {
        POILogger pOILogger;
        byte[] bArrDigest = CryptoFunctions.getMessageDigest(this.signatureConfig.getTspDigestAlgo()).digest(bArr);
        BigInteger bigInteger = new BigInteger(128, new SecureRandom());
        TimeStampRequestGenerator timeStampRequestGenerator = new TimeStampRequestGenerator();
        timeStampRequestGenerator.setCertReq(true);
        String tspRequestPolicy = this.signatureConfig.getTspRequestPolicy();
        if (tspRequestPolicy != null) {
            timeStampRequestGenerator.setReqPolicy(new ASN1ObjectIdentifier(tspRequestPolicy));
        }
        TimeStampRequest timeStampRequestGenerate = timeStampRequestGenerator.generate(mapDigestAlgoToOID(this.signatureConfig.getTspDigestAlgo()), bArrDigest, bigInteger);
        byte[] encoded = timeStampRequestGenerate.getEncoded();
        Proxy proxy = Proxy.NO_PROXY;
        if (this.signatureConfig.getProxyUrl() != null) {
            URL url = new URL(this.signatureConfig.getProxyUrl());
            String host = url.getHost();
            int port = url.getPort();
            Proxy.Type type = Proxy.Type.HTTP;
            InetAddress byName = InetAddress.getByName(host);
            if (port == -1) {
                port = 80;
            }
            proxy = new Proxy(type, new InetSocketAddress(byName, port));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.signatureConfig.getTspUrl()).openConnection(proxy);
        if (this.signatureConfig.getTspUser() != null) {
            httpURLConnection.setRequestProperty("Authorization", "Basic " + DatatypeConverter.printBase64Binary((this.signatureConfig.getTspUser() + ":" + this.signatureConfig.getTspPass()).getBytes(Charset.forName("iso-8859-1"))));
        }
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("User-Agent", this.signatureConfig.getUserAgent());
        httpURLConnection.setRequestProperty("Content-Type", this.signatureConfig.isTspOldProtocol() ? "application/timestamp-request" : "application/timestamp-query");
        httpURLConnection.getOutputStream().write(encoded);
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            LOG.log(7, "Error contacting TSP server ", this.signatureConfig.getTspUrl() + ", had status code " + responseCode + "/" + httpURLConnection.getResponseMessage());
            throw new IOException("Error contacting TSP server " + this.signatureConfig.getTspUrl() + ", had status code " + responseCode + "/" + httpURLConnection.getResponseMessage());
        }
        String headerField = httpURLConnection.getHeaderField("Content-Type");
        if (headerField == null) {
            throw new RuntimeException("missing Content-Type header");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(httpURLConnection.getInputStream(), byteArrayOutputStream);
        POILogger pOILogger2 = LOG;
        pOILogger2.log(1, "response content: ", HexDump.dump(byteArrayOutputStream.toByteArray(), 0L, 0));
        if (!headerField.startsWith(this.signatureConfig.isTspOldProtocol() ? "application/timestamp-response" : "application/timestamp-reply")) {
            throw new RuntimeException("invalid Content-Type: " + headerField + ": " + HexDump.dump(byteArrayOutputStream.toByteArray(), 0L, 0, 200));
        }
        if (byteArrayOutputStream.size() == 0) {
            throw new RuntimeException("Content-Length is zero");
        }
        TimeStampResponse timeStampResponse = new TimeStampResponse(byteArrayOutputStream.toByteArray());
        timeStampResponse.validate(timeStampRequestGenerate);
        if (timeStampResponse.getStatus() != 0) {
            pOILogger2.log(1, "status: " + timeStampResponse.getStatus());
            pOILogger2.log(1, "status string: " + timeStampResponse.getStatusString());
            PKIFailureInfo failInfo = timeStampResponse.getFailInfo();
            if (failInfo != null) {
                pOILogger2.log(1, "fail info int value: " + failInfo.intValue());
                if (256 == failInfo.intValue()) {
                    pOILogger2.log(1, "unaccepted policy");
                }
            }
            throw new RuntimeException("timestamp response status != 0: " + timeStampResponse.getStatus());
        }
        TimeStampToken timeStampToken = timeStampResponse.getTimeStampToken();
        SignerId sid = timeStampToken.getSID();
        BigInteger serialNumber = sid.getSerialNumber();
        X500Name issuer = sid.getIssuer();
        pOILogger2.log(1, "signer cert serial number: " + serialNumber);
        pOILogger2.log(1, "signer cert issuer: " + issuer);
        X509CertificateHolder x509CertificateHolder = null;
        Collection<X509CertificateHolder> matches = timeStampToken.getCertificates().getMatches((Selector) null);
        HashMap map = new HashMap();
        for (X509CertificateHolder x509CertificateHolder2 : matches) {
            if (issuer.equals(x509CertificateHolder2.getIssuer()) && serialNumber.equals(x509CertificateHolder2.getSerialNumber())) {
                x509CertificateHolder = x509CertificateHolder2;
            }
            map.put(x509CertificateHolder2.getSubject(), x509CertificateHolder2);
        }
        if (x509CertificateHolder == null) {
            throw new RuntimeException("TSP response token has no signer certificate");
        }
        ArrayList arrayList = new ArrayList();
        JcaX509CertificateConverter jcaX509CertificateConverter = new JcaX509CertificateConverter();
        jcaX509CertificateConverter.setProvider("BC");
        do {
            pOILogger = LOG;
            pOILogger.log(1, "adding to certificate chain: " + x509CertificateHolder.getSubject());
            arrayList.add(jcaX509CertificateConverter.getCertificate(x509CertificateHolder));
            if (x509CertificateHolder.getSubject().equals(x509CertificateHolder.getIssuer())) {
                break;
            }
            x509CertificateHolder = (X509CertificateHolder) map.get(x509CertificateHolder.getIssuer());
        } while (x509CertificateHolder != null);
        timeStampToken.validate(new BcRSASignerInfoVerifierBuilder(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), new DefaultDigestAlgorithmIdentifierFinder(), new BcDigestCalculatorProvider()).build(new X509CertificateHolder(((X509Certificate) arrayList.get(0)).getEncoded())));
        if (this.signatureConfig.getTspValidator() != null) {
            this.signatureConfig.getTspValidator().validate(arrayList, revocationData);
        }
        pOILogger.log(1, "time-stamp token time: " + timeStampToken.getTimeStampInfo().getGenTime());
        return timeStampToken.getEncoded();
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureConfig.SignatureConfigurable
    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }
}
