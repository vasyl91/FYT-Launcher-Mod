package org.apache.xmlbeans.impl.schema;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaGlobalElementImpl extends SchemaLocalElementImpl implements SchemaGlobalElement {
    private static final QName[] _namearray = new QName[0];
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalRest;
    private String _parseTNS;
    private SchemaGlobalElement.Ref _sg;
    private Set _sgMembers = new LinkedHashSet();
    private SchemaGlobalElement.Ref _selfref = new SchemaGlobalElement.Ref(this);

    public int getComponentType() {
        return 1;
    }

    public SchemaGlobalElementImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    public String getSourceName() {
        return this._filename;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    void setFinal(boolean z, boolean z2) {
        mutate();
        this._finalExt = z;
        this._finalRest = z2;
    }

    public SchemaGlobalElement substitutionGroup() {
        SchemaGlobalElement.Ref ref = this._sg;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setSubstitutionGroup(SchemaGlobalElement.Ref ref) {
        this._sg = ref;
    }

    public QName[] substitutionGroupMembers() {
        return (QName[]) this._sgMembers.toArray(_namearray);
    }

    public void addSubstitutionGroupMember(QName qName) {
        mutate();
        this._sgMembers.add(qName);
    }

    public boolean finalExtension() {
        return this._finalExt;
    }

    public boolean finalRestriction() {
        return this._finalRest;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    public SchemaGlobalElement.Ref getRef() {
        return this._selfref;
    }

    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }
}
