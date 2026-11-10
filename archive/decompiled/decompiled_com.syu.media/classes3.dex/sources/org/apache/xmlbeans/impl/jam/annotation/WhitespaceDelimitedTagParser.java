package org.apache.xmlbeans.impl.jam.annotation;

import com.sun.javadoc.Tag;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class WhitespaceDelimitedTagParser extends JavadocTagParser {
    private boolean isBlank(char c) {
        return c == ' ' || c == '\t' || c == '\n';
    }

    @Override // org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser
    public void parse(MAnnotatedElement mAnnotatedElement, Tag tag) {
        MAnnotation[] mAnnotationArrCreateAnnotations = createAnnotations(mAnnotatedElement, tag);
        String strText = tag.text();
        if (strText == null) {
            return;
        }
        String strTrim = strText.trim();
        if (strTrim.length() == 0) {
            return;
        }
        Properties properties = new Properties();
        parseAssignments(properties, strTrim);
        if (properties.size() > 0) {
            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
            while (enumerationPropertyNames.hasMoreElements()) {
                String str = (String) enumerationPropertyNames.nextElement();
                setValue(mAnnotationArrCreateAnnotations, str, properties.getProperty(str));
            }
            return;
        }
        setSingleValueText(mAnnotationArrCreateAnnotations, tag);
    }

    private void parseAssignments(Properties properties, String str) {
        int i;
        getLogger().verbose("PARSING LINE " + str, this);
        String strRemoveComments = removeComments(str);
        while (strRemoveComments != null && -1 != strRemoveComments.indexOf("=")) {
            int i2 = 0;
            char cCharAt = strRemoveComments.charAt(0);
            while (isBlank(cCharAt)) {
                i2++;
                cCharAt = strRemoveComments.charAt(i2);
            }
            int i3 = i2;
            while (isLegal(strRemoveComments.charAt(i3))) {
                i3++;
            }
            String strSubstring = strRemoveComments.substring(i2, i3);
            int iIndexOf = strRemoveComments.indexOf("=");
            if (iIndexOf == -1) {
                return;
            }
            int i4 = iIndexOf + 1;
            try {
                cCharAt = strRemoveComments.charAt(i4);
            } catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            while (isBlank(cCharAt)) {
                i4++;
                cCharAt = strRemoveComments.charAt(i4);
            }
            if (cCharAt == '\"') {
                i4++;
                i = i4;
                while ('\"' != strRemoveComments.charAt(i)) {
                    i++;
                    if (i >= strRemoveComments.length()) {
                        getLogger().verbose("missing double quotes on line " + strRemoveComments, this);
                    }
                }
            } else {
                i = i4 + 1;
                while (i < strRemoveComments.length() && isLegal(strRemoveComments.charAt(i))) {
                    i++;
                }
            }
            String strSubstring2 = strRemoveComments.substring(i4, i);
            strRemoveComments = i < strRemoveComments.length() ? strRemoveComments.substring(i + 1) : null;
            getLogger().verbose("SETTING KEY:" + strSubstring + " VALUE:" + strSubstring2, this);
            properties.setProperty(strSubstring, strSubstring2);
        }
    }

    private String removeComments(String str) {
        int length = str.length();
        int iIndexOf = str.indexOf("//");
        int iIndexOf2 = str.indexOf("\"");
        if (-1 == iIndexOf2 || iIndexOf2 >= iIndexOf) {
            String str2 = "";
            int i = 0;
            String strSubstring = str;
            while (i < length && iIndexOf != -1) {
                iIndexOf = str.indexOf("//", i);
                if (-1 != iIndexOf) {
                    if (iIndexOf <= 0 || str.charAt(iIndexOf - 1) != ':') {
                        int iIndexOf3 = str.indexOf(10, iIndexOf);
                        if (-1 == iIndexOf3) {
                            iIndexOf3 = length;
                        }
                        str2 = str2 + str.substring(i, iIndexOf).trim() + "\n";
                        int i2 = iIndexOf3;
                        strSubstring = str.substring(iIndexOf3);
                        i = i2;
                    } else {
                        i = iIndexOf + 2;
                    }
                }
            }
            str = str2 + strSubstring;
        }
        return str.trim();
    }

    private boolean isLegal(char c) {
        return (isBlank(c) || c == '=') ? false : true;
    }
}
