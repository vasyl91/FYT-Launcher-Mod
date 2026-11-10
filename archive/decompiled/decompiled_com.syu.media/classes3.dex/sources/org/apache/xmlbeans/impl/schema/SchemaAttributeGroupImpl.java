package org.apache.xmlbeans.impl.schema;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaAttributeGroupImpl implements SchemaAttributeGroup {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _filename;
    private String _formDefault;
    private QName _name;
    private XmlObject _parseObject;
    private String _parseTNS;
    private boolean _redefinition;
    private SchemaAttributeGroup.Ref _selfref = new SchemaAttributeGroup.Ref(this);
    private Object _userData;

    public int getComponentType() {
        return 4;
    }

    public SchemaAttributeGroupImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public SchemaAttributeGroupImpl(SchemaContainer schemaContainer, QName qName) {
        this._container = schemaContainer;
        this._name = qName;
    }

    public void init(QName qName, String str, boolean z, String str2, boolean z2, XmlObject xmlObject, SchemaAnnotation schemaAnnotation, Object obj) {
        this._name = qName;
        this._parseTNS = str;
        this._chameleon = z;
        this._formDefault = str2;
        this._redefinition = z2;
        this._parseObject = xmlObject;
        this._annotation = schemaAnnotation;
        this._userData = obj;
    }

    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    SchemaContainer getContainer() {
        return this._container;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public String getSourceName() {
        return this._filename;
    }

    public QName getName() {
        return this._name;
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

    public String getFormDefault() {
        return this._formDefault;
    }

    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public SchemaAttributeGroup.Ref getRef() {
        return this._selfref;
    }

    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    public boolean isRedefinition() {
        return this._redefinition;
    }

    public Object getUserData() {
        return this._userData;
    }
}
