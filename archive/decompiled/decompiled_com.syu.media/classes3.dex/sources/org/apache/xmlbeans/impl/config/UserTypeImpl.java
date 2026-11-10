package org.apache.xmlbeans.impl.config;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.UserType;
import org.apache.xmlbeans.impl.jam.JamClassLoader;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class UserTypeImpl implements UserType {
    private String _javaName;
    private QName _name;
    private String _staticHandler;

    static UserTypeImpl newInstance(JamClassLoader jamClassLoader, Usertypeconfig usertypeconfig) {
        UserTypeImpl userTypeImpl = new UserTypeImpl();
        userTypeImpl._name = usertypeconfig.getName();
        userTypeImpl._javaName = usertypeconfig.getJavaname();
        userTypeImpl._staticHandler = usertypeconfig.getStaticHandler();
        return userTypeImpl;
    }

    public String getJavaName() {
        return this._javaName;
    }

    public QName getName() {
        return this._name;
    }

    public String getStaticHandler() {
        return this._staticHandler;
    }
}
