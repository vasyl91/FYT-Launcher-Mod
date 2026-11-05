package org.apache.poi.poifs.crypt.dsig;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import javax.xml.crypto.Data;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.URIReference;
import javax.xml.crypto.URIReferenceException;
import javax.xml.crypto.XMLCryptoContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class OOXMLURIDereferencer implements URIDereferencer, SignatureConfig.SignatureConfigurable {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) OOXMLURIDereferencer.class);
    private URIDereferencer baseUriDereferencer;
    private SignatureConfig signatureConfig;

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureConfig.SignatureConfigurable
    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.URIReferenceException */
    public Data dereference(URIReference uRIReference, XMLCryptoContext xMLCryptoContext) throws URIReferenceException {
        if (this.baseUriDereferencer == null) {
            this.baseUriDereferencer = this.signatureConfig.getSignatureFactory().getURIDereferencer();
        }
        if (uRIReference == null) {
            throw new NullPointerException("URIReference cannot be null");
        }
        if (xMLCryptoContext == null) {
            throw new NullPointerException("XMLCrytoContext cannot be null");
        }
        try {
            URI uri = new URI(uRIReference.getURI());
            PackagePart packagePartFindPart = findPart(uri);
            if (packagePartFindPart == null) {
                LOG.log(1, "cannot resolve, delegating to base DOM URI dereferencer", uri);
                return this.baseUriDereferencer.dereference(uRIReference, xMLCryptoContext);
            }
            try {
                InputStream inputStream = packagePartFindPart.getInputStream();
                if (packagePartFindPart.getPartName().toString().endsWith(".rels")) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int i = inputStream.read();
                        if (i == -1) {
                            break;
                        }
                        if (i != 10 && i != 13) {
                            byteArrayOutputStream.write(i);
                        }
                    }
                    inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
                return new OctetStreamData(inputStream, uri.toString(), (String) null);
            } catch (IOException e) {
                throw new URIReferenceException("I/O error: " + e.getMessage(), e);
            }
        } catch (URISyntaxException e2) {
            throw new URIReferenceException("could not URL decode the uri: " + uRIReference.getURI(), e2);
        }
    }

    private PackagePart findPart(URI uri) {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "dereference", uri);
        String path = uri.getPath();
        if (path == null || "".equals(path)) {
            pOILogger.log(1, "illegal part name (expected)", uri);
            return null;
        }
        try {
            return this.signatureConfig.getOpcPackage().getPart(PackagingURIHelper.createPartName(path));
        } catch (InvalidFormatException unused) {
            LOG.log(5, "illegal part name (not expected)", uri);
            return null;
        }
    }
}
