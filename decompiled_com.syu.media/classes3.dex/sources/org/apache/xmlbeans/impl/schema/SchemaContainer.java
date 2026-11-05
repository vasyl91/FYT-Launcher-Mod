package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class SchemaContainer {
    boolean _immutable;
    private String _namespace;
    private SchemaTypeSystem _typeSystem;
    private List _globalElements = new ArrayList();
    private List _globalAttributes = new ArrayList();
    private List _modelGroups = new ArrayList();
    private List _redefinedModelGroups = new ArrayList();
    private List _attributeGroups = new ArrayList();
    private List _redefinedAttributeGroups = new ArrayList();
    private List _globalTypes = new ArrayList();
    private List _redefinedGlobalTypes = new ArrayList();
    private List _documentTypes = new ArrayList();
    private List _attributeTypes = new ArrayList();
    private List _identityConstraints = new ArrayList();
    private List _annotations = new ArrayList();

    SchemaContainer(String str) {
        this._namespace = str;
    }

    String getNamespace() {
        return this._namespace;
    }

    synchronized SchemaTypeSystem getTypeSystem() {
        return this._typeSystem;
    }

    synchronized void setTypeSystem(SchemaTypeSystem schemaTypeSystem) {
        this._typeSystem = schemaTypeSystem;
    }

    synchronized void setImmutable() {
        this._immutable = true;
    }

    synchronized void unsetImmutable() {
        this._immutable = false;
    }

    private void check_immutable() {
        if (this._immutable) {
            throw new IllegalStateException("Cannot add components to immutable SchemaContainer");
        }
    }

    void addGlobalElement(SchemaGlobalElement.Ref ref) {
        check_immutable();
        this._globalElements.add(ref);
    }

    List globalElements() {
        return getComponentList(this._globalElements);
    }

    void addGlobalAttribute(SchemaGlobalAttribute.Ref ref) {
        check_immutable();
        this._globalAttributes.add(ref);
    }

    List globalAttributes() {
        return getComponentList(this._globalAttributes);
    }

    void addModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._modelGroups.add(ref);
    }

    List modelGroups() {
        return getComponentList(this._modelGroups);
    }

    void addRedefinedModelGroup(SchemaModelGroup.Ref ref) {
        check_immutable();
        this._redefinedModelGroups.add(ref);
    }

    List redefinedModelGroups() {
        return getComponentList(this._redefinedModelGroups);
    }

    void addAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._attributeGroups.add(ref);
    }

    List attributeGroups() {
        return getComponentList(this._attributeGroups);
    }

    void addRedefinedAttributeGroup(SchemaAttributeGroup.Ref ref) {
        check_immutable();
        this._redefinedAttributeGroups.add(ref);
    }

    List redefinedAttributeGroups() {
        return getComponentList(this._redefinedAttributeGroups);
    }

    void addGlobalType(SchemaType.Ref ref) {
        check_immutable();
        this._globalTypes.add(ref);
    }

    List globalTypes() {
        return getComponentList(this._globalTypes);
    }

    void addRedefinedType(SchemaType.Ref ref) {
        check_immutable();
        this._redefinedGlobalTypes.add(ref);
    }

    List redefinedGlobalTypes() {
        return getComponentList(this._redefinedGlobalTypes);
    }

    void addDocumentType(SchemaType.Ref ref) {
        check_immutable();
        this._documentTypes.add(ref);
    }

    List documentTypes() {
        return getComponentList(this._documentTypes);
    }

    void addAttributeType(SchemaType.Ref ref) {
        check_immutable();
        this._attributeTypes.add(ref);
    }

    List attributeTypes() {
        return getComponentList(this._attributeTypes);
    }

    void addIdentityConstraint(SchemaIdentityConstraint.Ref ref) {
        check_immutable();
        this._identityConstraints.add(ref);
    }

    List identityConstraints() {
        return getComponentList(this._identityConstraints);
    }

    void addAnnotation(SchemaAnnotation schemaAnnotation) {
        check_immutable();
        this._annotations.add(schemaAnnotation);
    }

    List annotations() {
        return Collections.unmodifiableList(this._annotations);
    }

    private List getComponentList(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(((SchemaComponent.Ref) list.get(i)).getComponent());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
