package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ConnectsType;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import com.microsoft.schemas.office.visio.x2012.main.ShapesType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class PageContentsTypeImpl extends XmlComplexContentImpl implements PageContentsType {
    private static final QName SHAPES$0 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Shapes");
    private static final QName CONNECTS$2 = new QName("http://schemas.microsoft.com/office/visio/2012/main", "Connects");

    public PageContentsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ConnectsType addNewConnects() {
        ConnectsType connectsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            connectsTypeAdd_element_user = get_store().add_element_user(CONNECTS$2);
        }
        return connectsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ShapesType addNewShapes() {
        ShapesType shapesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            shapesTypeAdd_element_user = get_store().add_element_user(SHAPES$0);
        }
        return shapesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ConnectsType getConnects() {
        synchronized (monitor()) {
            check_orphaned();
            ConnectsType connectsTypeFind_element_user = get_store().find_element_user(CONNECTS$2, 0);
            if (connectsTypeFind_element_user == null) {
                return null;
            }
            return connectsTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ShapesType getShapes() {
        synchronized (monitor()) {
            check_orphaned();
            ShapesType shapesTypeFind_element_user = get_store().find_element_user(SHAPES$0, 0);
            if (shapesTypeFind_element_user == null) {
                return null;
            }
            return shapesTypeFind_element_user;
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public boolean isSetConnects() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONNECTS$2) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public boolean isSetShapes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SHAPES$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void setConnects(ConnectsType connectsType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = CONNECTS$2;
            ConnectsType connectsTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (connectsTypeFind_element_user == null) {
                connectsTypeFind_element_user = (ConnectsType) get_store().add_element_user(qName);
            }
            connectsTypeFind_element_user.set(connectsType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void setShapes(ShapesType shapesType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName qName = SHAPES$0;
            ShapesType shapesTypeFind_element_user = typeStore.find_element_user(qName, 0);
            if (shapesTypeFind_element_user == null) {
                shapesTypeFind_element_user = (ShapesType) get_store().add_element_user(qName);
            }
            shapesTypeFind_element_user.set(shapesType);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void unsetConnects() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONNECTS$2, 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void unsetShapes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SHAPES$0, 0);
        }
    }
}
