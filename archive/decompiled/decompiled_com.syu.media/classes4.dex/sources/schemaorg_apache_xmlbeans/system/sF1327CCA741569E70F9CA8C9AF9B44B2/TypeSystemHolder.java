package schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2;

import java.lang.reflect.Constructor;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class TypeSystemHolder {
    static /* synthetic */ Class class$java$lang$Class;
    static /* synthetic */ Class class$schemaorg_apache_xmlbeans$system$sF1327CCA741569E70F9CA8C9AF9B44B2$TypeSystemHolder;
    public static final SchemaTypeSystem typeSystem = loadTypeSystem();

    private TypeSystemHolder() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static final SchemaTypeSystem loadTypeSystem() throws Throwable {
        try {
            Class clsClass$ = class$schemaorg_apache_xmlbeans$system$sF1327CCA741569E70F9CA8C9AF9B44B2$TypeSystemHolder;
            if (clsClass$ == null) {
                clsClass$ = class$("schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2.TypeSystemHolder");
                class$schemaorg_apache_xmlbeans$system$sF1327CCA741569E70F9CA8C9AF9B44B2$TypeSystemHolder = clsClass$;
            }
            Class<?> cls = Class.forName("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl", true, clsClass$.getClassLoader());
            Class<?>[] clsArr = new Class[1];
            Class<?> clsClass$2 = class$java$lang$Class;
            if (clsClass$2 == null) {
                clsClass$2 = class$("java.lang.Class");
                class$java$lang$Class = clsClass$2;
            }
            clsArr[0] = clsClass$2;
            Constructor<?> constructor = cls.getConstructor(clsArr);
            Object[] objArr = new Object[1];
            Class clsClass$3 = class$schemaorg_apache_xmlbeans$system$sF1327CCA741569E70F9CA8C9AF9B44B2$TypeSystemHolder;
            if (clsClass$3 == null) {
                clsClass$3 = class$("schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2.TypeSystemHolder");
                class$schemaorg_apache_xmlbeans$system$sF1327CCA741569E70F9CA8C9AF9B44B2$TypeSystemHolder = clsClass$3;
            }
            objArr[0] = clsClass$3;
            return (SchemaTypeSystem) constructor.newInstance(objArr);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load org.apache.xmlbeans.impl.SchemaTypeSystemImpl: make sure xbean.jar is on the classpath.", e);
        } catch (Exception e2) {
            throw new RuntimeException(new StringBuffer("Could not instantiate SchemaTypeSystemImpl (").append(e2.toString()).append("): is the version of xbean.jar correct?").toString(), e2);
        }
    }
}
