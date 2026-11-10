package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_OfficeArtExtension", namespace = XSSFRelation.NS_DRAWINGML, propOrder = {Languages.ANY})
public class CTOfficeArtExtension {

    @XmlAnyElement(lax = true)
    protected Object any;

    @XmlSchemaType(name = "token")
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String uri;

    public Object getAny() {
        return this.any;
    }

    public void setAny(Object obj) {
        this.any = obj;
    }

    public boolean isSetAny() {
        return this.any != null;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public boolean isSetUri() {
        return this.uri != null;
    }
}
