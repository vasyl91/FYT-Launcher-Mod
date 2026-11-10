package org.codehaus.stax2;

import java.io.IOException;
import java.io.Writer;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.typed.TypedXMLStreamReader;
import org.codehaus.stax2.validation.Validatable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XMLStreamReader2 extends TypedXMLStreamReader, Validatable {

    @Deprecated
    public static final String FEATURE_DTD_OVERRIDE = "org.codehaus.stax2.propDtdOverride";

    void closeCompletely() throws XMLStreamException;

    AttributeInfo getAttributeInfo() throws XMLStreamException;

    DTDInfo getDTDInfo() throws XMLStreamException;

    int getDepth();

    @Deprecated
    Object getFeature(String str);

    LocationInfo getLocationInfo();

    NamespaceContext getNonTransientNamespaceContext();

    String getPrefixedName();

    int getText(Writer writer, boolean z) throws XMLStreamException, IOException;

    boolean isEmptyElement() throws XMLStreamException;

    boolean isPropertySupported(String str);

    @Deprecated
    void setFeature(String str, Object obj);

    boolean setProperty(String str, Object obj);

    void skipElement() throws XMLStreamException;
}
