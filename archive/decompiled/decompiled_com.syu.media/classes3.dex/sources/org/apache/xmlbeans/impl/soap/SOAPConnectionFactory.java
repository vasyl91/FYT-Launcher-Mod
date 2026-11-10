package org.apache.xmlbeans.impl.soap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class SOAPConnectionFactory {
    private static final String DEFAULT_SOAP_CONNECTION_FACTORY = "org.apache.axis.soap.SOAPConnectionFactoryImpl";
    private static final String SF_PROPERTY = "javax.xml.soap.SOAPConnectionFactory";

    public abstract SOAPConnection createConnection() throws SOAPException;

    public static SOAPConnectionFactory newInstance() throws UnsupportedOperationException, SOAPException {
        try {
            return (SOAPConnectionFactory) FactoryFinder.find(SF_PROPERTY, DEFAULT_SOAP_CONNECTION_FACTORY);
        } catch (Exception e) {
            throw new SOAPException("Unable to create SOAP connection factory: " + e.getMessage());
        }
    }
}
