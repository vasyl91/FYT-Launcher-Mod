package org.apache.xmlbeans.impl.soap;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class SOAPMessage {
    public static final String CHARACTER_SET_ENCODING = "javax.xml.soap.character-set-encoding";
    public static final String WRITE_XML_DECLARATION = "javax.xml.soap.write-xml-declaration";

    public abstract void addAttachmentPart(AttachmentPart attachmentPart);

    public abstract int countAttachments();

    public abstract AttachmentPart createAttachmentPart();

    public abstract Iterator getAttachments();

    public abstract Iterator getAttachments(MimeHeaders mimeHeaders);

    public abstract String getContentDescription();

    public abstract MimeHeaders getMimeHeaders();

    public abstract Object getProperty(String str) throws SOAPException;

    public abstract SOAPBody getSOAPBody() throws SOAPException;

    public abstract SOAPHeader getSOAPHeader() throws SOAPException;

    public abstract SOAPPart getSOAPPart();

    public abstract void removeAllAttachments();

    public abstract void saveChanges() throws SOAPException;

    public abstract boolean saveRequired();

    public abstract void setContentDescription(String str);

    public abstract void setProperty(String str, Object obj) throws SOAPException;

    public abstract void writeTo(OutputStream outputStream) throws SOAPException, IOException;

    public AttachmentPart createAttachmentPart(Object obj, String str) {
        AttachmentPart attachmentPartCreateAttachmentPart = createAttachmentPart();
        attachmentPartCreateAttachmentPart.setContent(obj, str);
        return attachmentPartCreateAttachmentPart;
    }
}
