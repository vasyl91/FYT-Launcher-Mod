package org.apache.xmlbeans.impl.jam.annotation;

import com.sun.javadoc.Tag;
import java.io.StringWriter;
import java.util.StringTokenizer;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class LineDelimitedTagParser extends JavadocTagParser {
    private static final String LINE_DELIMS = "\n\f\r";
    private static final String VALUE_QUOTE = "\"";

    @Override // org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser
    public void parse(MAnnotatedElement mAnnotatedElement, Tag tag) {
        if (mAnnotatedElement == null) {
            throw new IllegalArgumentException("null tagText");
        }
        if (tag == null) {
            throw new IllegalArgumentException("null tagName");
        }
        MAnnotation[] mAnnotationArrCreateAnnotations = createAnnotations(mAnnotatedElement, tag);
        StringTokenizer stringTokenizer = new StringTokenizer(tag.text(), LINE_DELIMS);
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf(61);
            if (iIndexOf > 0) {
                String strTrim = strNextToken.substring(0, iIndexOf).trim();
                if (iIndexOf < strNextToken.length() - 1) {
                    String strTrim2 = strNextToken.substring(iIndexOf + 1).trim();
                    if (strTrim2.startsWith(VALUE_QUOTE)) {
                        strTrim2 = parseQuotedValue(strTrim2.substring(1), stringTokenizer);
                    }
                    setValue(mAnnotationArrCreateAnnotations, strTrim, strTrim2);
                }
            }
        }
    }

    private String parseQuotedValue(String str, StringTokenizer stringTokenizer) {
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int iIndexOf = str.indexOf(VALUE_QUOTE);
            if (iIndexOf == -1) {
                stringWriter.write(str);
                if (!stringTokenizer.hasMoreTokens()) {
                    return stringWriter.toString();
                }
                stringWriter.write(10);
                str = stringTokenizer.nextToken().trim();
            } else {
                stringWriter.write(str.substring(0, iIndexOf).trim());
                return stringWriter.toString();
            }
        }
    }
}
