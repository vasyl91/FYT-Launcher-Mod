package org.apache.poi.openxml4j.opc.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class ContentType {
    private final Map<String, String> parameters;
    private final String subType;
    private final String type;
    private static final Pattern patternTypeSubType = Pattern.compile("^([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)$");
    private static final Pattern patternTypeSubTypeParams = Pattern.compile("^([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)(;([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)=(\"?[\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+\"?))*$");
    private static final Pattern patternParams = Pattern.compile(";([\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+)=(\"?[\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]+\"?)");

    public ContentType(String str) throws InvalidFormatException {
        Matcher matcher = patternTypeSubType.matcher(str);
        matcher = matcher.matches() ? matcher : patternTypeSubTypeParams.matcher(str);
        if (!matcher.matches()) {
            throw new InvalidFormatException("The specified content type '" + str + "' is not compliant with RFC 2616: malformed content type.");
        }
        if (matcher.groupCount() >= 2) {
            this.type = matcher.group(1);
            this.subType = matcher.group(2);
            this.parameters = new HashMap();
            if (matcher.groupCount() >= 5) {
                Matcher matcher2 = patternParams.matcher(str.substring(matcher.end(2)));
                while (matcher2.find()) {
                    this.parameters.put(matcher2.group(1), matcher2.group(2));
                }
                return;
            }
            return;
        }
        this.type = "";
        this.subType = "";
        this.parameters = Collections.emptyMap();
    }

    public final String toString() {
        return toString(true);
    }

    public final String toString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getType());
        stringBuffer.append("/");
        stringBuffer.append(getSubType());
        if (z) {
            for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
                stringBuffer.append(";");
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
            }
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        return !(obj instanceof ContentType) || toString().equalsIgnoreCase(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public boolean hasParameters() {
        Map<String, String> map = this.parameters;
        return (map == null || map.isEmpty()) ? false : true;
    }

    public String[] getParameterKeys() {
        Map<String, String> map = this.parameters;
        return map == null ? new String[0] : (String[]) map.keySet().toArray(new String[this.parameters.size()]);
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }
}
