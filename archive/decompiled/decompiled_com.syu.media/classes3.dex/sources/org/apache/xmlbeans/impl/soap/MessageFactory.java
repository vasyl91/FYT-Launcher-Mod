package org.apache.xmlbeans.impl.soap;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class MessageFactory {
    private static final String DEFAULT_MESSAGE_FACTORY = "org.apache.axis.soap.MessageFactoryImpl";
    private static final String MESSAGE_FACTORY_PROPERTY = "javax.xml.soap.MessageFactory";

    public abstract SOAPMessage createMessage() throws SOAPException;

    public abstract SOAPMessage createMessage(MimeHeaders mimeHeaders, InputStream inputStream) throws SOAPException, IOException;

    public static MessageFactory newInstance() throws SOAPException {
        try {
            return (MessageFactory) FactoryFinder.find(MESSAGE_FACTORY_PROPERTY, DEFAULT_MESSAGE_FACTORY);
        } catch (Exception e) {
            throw new SOAPException("Unable to create message factory for SOAP: " + e.getMessage());
        }
    }
}
