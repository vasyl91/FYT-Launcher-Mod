package org.apache.poi.sl.draw.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.xssf.usermodel.XSSFRelation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_EmbeddedWAVAudioFile", namespace = XSSFRelation.NS_DRAWINGML)
public class CTEmbeddedWAVAudioFile {

    @XmlAttribute
    protected Boolean builtIn;

    @XmlAttribute(namespace = PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, required = true)
    protected String embed;

    @XmlAttribute
    protected String name;

    public String getEmbed() {
        return this.embed;
    }

    public void setEmbed(String str) {
        this.embed = str;
    }

    public boolean isSetEmbed() {
        return this.embed != null;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public boolean isSetName() {
        return this.name != null;
    }

    public boolean isBuiltIn() {
        Boolean bool = this.builtIn;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void setBuiltIn(boolean z) {
        this.builtIn = Boolean.valueOf(z);
    }

    public boolean isSetBuiltIn() {
        return this.builtIn != null;
    }

    public void unsetBuiltIn() {
        this.builtIn = null;
    }
}
