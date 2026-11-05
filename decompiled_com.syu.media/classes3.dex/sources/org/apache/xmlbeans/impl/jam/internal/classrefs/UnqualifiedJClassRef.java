package org.apache.xmlbeans.impl.jam.internal.classrefs;

import java.io.StringWriter;
import org.apache.xmlbeans.impl.jam.JClass;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class UnqualifiedJClassRef implements JClassRef {
    private static final String PREFIX = "[UnqualifiedJClassRef]";
    private static final boolean VERBOSE = false;
    private JClassRefContext mContext;
    private String mQualifiedClassname = null;
    private String mUnqualifiedClassname;

    public static JClassRef create(String str, JClassRefContext jClassRefContext) {
        throw new IllegalStateException("Unqualified names currently disabled.");
    }

    private UnqualifiedJClassRef(String str, JClassRefContext jClassRefContext) {
        if (jClassRefContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        if (str == null) {
            throw new IllegalArgumentException("null ucname");
        }
        this.mContext = jClassRefContext;
        this.mUnqualifiedClassname = str;
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public JClass getRefClass() {
        return this.mContext.getClassLoader().loadClass(getQualifiedName());
    }

    @Override // org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef
    public String getQualifiedName() {
        String strSubstring;
        int i;
        String str = this.mQualifiedClassname;
        if (str != null) {
            return str;
        }
        int iIndexOf = this.mUnqualifiedClassname.indexOf(91);
        if (iIndexOf != -1) {
            strSubstring = this.mUnqualifiedClassname.substring(0, iIndexOf);
            i = 0;
            do {
                i++;
                iIndexOf = this.mUnqualifiedClassname.indexOf(91, iIndexOf + 1);
            } while (iIndexOf != -1);
        } else {
            strSubstring = this.mUnqualifiedClassname;
            i = 0;
        }
        String strQualifyName = qualifyName(strSubstring);
        if (strQualifyName == null) {
            throw new IllegalStateException("unable to handle unqualified java type reference '" + strSubstring + " [" + this.mUnqualifiedClassname + "]'. This is still partially NYI.");
        }
        if (i > 0) {
            StringWriter stringWriter = new StringWriter();
            for (int i2 = 0; i2 < i; i2++) {
                stringWriter.write(91);
            }
            stringWriter.write(76);
            stringWriter.write(strQualifyName);
            stringWriter.write(59);
            this.mQualifiedClassname = stringWriter.toString();
        } else {
            this.mQualifiedClassname = strQualifyName;
        }
        return this.mQualifiedClassname;
    }

    private String qualifyName(String str) {
        String strCheckExplicitImport = checkExplicitImport(str);
        if (strCheckExplicitImport != null) {
            return strCheckExplicitImport;
        }
        String strCheckJavaLang = checkJavaLang(str);
        if (strCheckJavaLang != null) {
            return strCheckJavaLang;
        }
        String strCheckSamePackage = checkSamePackage(str);
        if (strCheckSamePackage != null) {
            return strCheckSamePackage;
        }
        String strCheckAlreadyQualified = checkAlreadyQualified(str);
        if (strCheckAlreadyQualified != null) {
            return strCheckAlreadyQualified;
        }
        return null;
    }

    private String checkSamePackage(String str) {
        JClass jClassLoadClass = this.mContext.getClassLoader().loadClass(this.mContext.getPackageName() + "." + str);
        if (jClassLoadClass.isUnresolvedType()) {
            return null;
        }
        return jClassLoadClass.getQualifiedName();
    }

    private String checkJavaLang(String str) {
        JClass jClassLoadClass = this.mContext.getClassLoader().loadClass("java.lang." + str);
        if (jClassLoadClass.isUnresolvedType()) {
            return null;
        }
        return jClassLoadClass.getQualifiedName();
    }

    private String checkAlreadyQualified(String str) {
        JClass jClassLoadClass = this.mContext.getClassLoader().loadClass(str);
        if (jClassLoadClass.isUnresolvedType()) {
            return null;
        }
        return jClassLoadClass.getQualifiedName();
    }

    private String checkExplicitImport(String str) {
        String[] importSpecs = this.mContext.getImportSpecs();
        for (int i = 0; i < importSpecs.length; i++) {
            if (lastSegment(importSpecs[i]).equals(str)) {
                return importSpecs[i];
            }
        }
        return null;
    }

    private static String lastSegment(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    private static String firstSegment(String str) {
        int iIndexOf = str.indexOf(".");
        return iIndexOf == -1 ? str : str.substring(0, iIndexOf);
    }
}
