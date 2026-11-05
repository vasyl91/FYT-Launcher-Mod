package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.jvm.internal.LongCompanionObject;
import module.canbus.FinalCanbus;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.xmlbeans.XmlValidationError;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    Cookie(Builder builder) {
        if (builder.name == null) {
            throw new NullPointerException("builder.name == null");
        }
        if (builder.value == null) {
            throw new NullPointerException("builder.value == null");
        }
        if (builder.domain == null) {
            throw new NullPointerException("builder.domain == null");
        }
        this.name = builder.name;
        this.value = builder.value;
        this.expiresAt = builder.expiresAt;
        this.domain = builder.domain;
        this.path = builder.path;
        this.secure = builder.secure;
        this.httpOnly = builder.httpOnly;
        this.persistent = builder.persistent;
        this.hostOnly = builder.hostOnly;
    }

    public String name() {
        return this.name;
    }

    public String value() {
        return this.value;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public String domain() {
        return this.domain;
    }

    public String path() {
        return this.path;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean secure() {
        return this.secure;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean zDomainMatch;
        if (this.hostOnly) {
            zDomainMatch = httpUrl.host().equals(this.domain);
        } else {
            zDomainMatch = domainMatch(httpUrl.host(), this.domain);
        }
        if (zDomainMatch && pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String strEncodedPath = httpUrl.encodedPath();
        if (strEncodedPath.equals(str)) {
            return true;
        }
        if (strEncodedPath.startsWith(str)) {
            return str.endsWith("/") || strEncodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[PHI: r0
  0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    @Nullable
    static Cookie parse(long j, HttpUrl httpUrl, String str) {
        long j2;
        Cookie cookie;
        String str2;
        String strSubstring;
        int length = str.length();
        char c = ';';
        int iDelimiterOffset = Util.delimiterOffset(str, 0, length, ';');
        char c2 = '=';
        int iDelimiterOffset2 = Util.delimiterOffset(str, 0, iDelimiterOffset, '=');
        if (iDelimiterOffset2 == iDelimiterOffset) {
            return null;
        }
        String strTrimSubstring = Util.trimSubstring(str, 0, iDelimiterOffset2);
        if (strTrimSubstring.isEmpty() || Util.indexOfControlOrNonAscii(strTrimSubstring) != -1) {
            return null;
        }
        String strTrimSubstring2 = Util.trimSubstring(str, iDelimiterOffset2 + 1, iDelimiterOffset);
        if (Util.indexOfControlOrNonAscii(strTrimSubstring2) != -1) {
            return null;
        }
        int i = iDelimiterOffset + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String domain = null;
        boolean z4 = true;
        long maxAge = -1;
        long expires = 253402300799999L;
        String str3 = null;
        while (i < length) {
            int iDelimiterOffset3 = Util.delimiterOffset(str, i, length, c);
            int iDelimiterOffset4 = Util.delimiterOffset(str, i, iDelimiterOffset3, c2);
            String strTrimSubstring3 = Util.trimSubstring(str, i, iDelimiterOffset4);
            String strTrimSubstring4 = iDelimiterOffset4 < iDelimiterOffset3 ? Util.trimSubstring(str, iDelimiterOffset4 + 1, iDelimiterOffset3) : "";
            if (strTrimSubstring3.equalsIgnoreCase("expires")) {
                try {
                    expires = parseExpires(strTrimSubstring4, 0, strTrimSubstring4.length());
                    z3 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strTrimSubstring3.equalsIgnoreCase("max-age")) {
                maxAge = parseMaxAge(strTrimSubstring4);
                z3 = true;
            } else if (strTrimSubstring3.equalsIgnoreCase("domain")) {
                domain = parseDomain(strTrimSubstring4);
                z4 = false;
            } else if (strTrimSubstring3.equalsIgnoreCase("path")) {
                str3 = strTrimSubstring4;
            } else if (strTrimSubstring3.equalsIgnoreCase("secure")) {
                z = true;
            } else if (strTrimSubstring3.equalsIgnoreCase("httponly")) {
                z2 = true;
            }
            i = iDelimiterOffset3 + 1;
            c = ';';
            c2 = '=';
        }
        long j3 = Long.MIN_VALUE;
        if (maxAge == Long.MIN_VALUE) {
            j2 = j3;
        } else if (maxAge != -1) {
            j3 = j + (maxAge <= 9223372036854775L ? maxAge * 1000 : LongCompanionObject.MAX_VALUE);
            if (j3 < j || j3 > HttpDate.MAX_DATE) {
                j2 = 253402300799999L;
            } else {
                j2 = j3;
            }
        } else {
            j2 = expires;
        }
        String strHost = httpUrl.host();
        if (domain == null) {
            str2 = strHost;
            cookie = null;
        } else {
            if (!domainMatch(strHost, domain)) {
                return null;
            }
            cookie = null;
            str2 = domain;
        }
        if (strHost.length() != str2.length() && PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
            return cookie;
        }
        if (str3 == null || !str3.startsWith("/")) {
            String strEncodedPath = httpUrl.encodedPath();
            int iLastIndexOf = strEncodedPath.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strEncodedPath.substring(0, iLastIndexOf) : "/";
        } else {
            strSubstring = str3;
        }
        return new Cookie(strTrimSubstring, strTrimSubstring2, j2, str2, strSubstring, z, z2, z4, z3);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    private static long parseExpires(String str, int i, int i2) {
        int iDateCharacterOffset = dateCharacterOffset(str, i, i2, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iDateCharacterOffset < i2) {
            int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i2, true);
            matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
            if (i4 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i6 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = MONTH_PATTERN;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 != -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else if (i3 != -1) {
            }
            iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += XmlValidationError.LIST_INVALID;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i6);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long parseMaxAge(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (str.startsWith("-")) {
                    return Long.MIN_VALUE;
                }
                return LongCompanionObject.MAX_VALUE;
            }
            throw e;
        }
    }

    private static String parseDomain(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strCanonicalizeHost = Util.canonicalizeHost(str);
        if (strCanonicalizeHost != null) {
            return strCanonicalizeHost;
        }
        throw new IllegalArgumentException();
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> listValues = headers.values("Set-Cookie");
        int size = listValues.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Cookie cookie = parse(httpUrl, listValues.get(i));
            if (cookie != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(cookie);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static final class Builder {

        @Nullable
        String domain;
        boolean hostOnly;
        boolean httpOnly;

        @Nullable
        String name;
        boolean persistent;
        boolean secure;

        @Nullable
        String value;
        long expiresAt = HttpDate.MAX_DATE;
        String path = "/";

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = str;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = str;
            return this;
        }

        public Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > HttpDate.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        private Builder domain(String str, boolean z) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String strCanonicalizeHost = Util.canonicalizeHost(str);
            if (strCanonicalizeHost == null) {
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            this.domain = strCanonicalizeHost;
            this.hostOnly = z;
            return this;
        }

        public Builder path(String str) {
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = str;
            return this;
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Cookie build() {
            return new Cookie(this);
        }
    }

    public String toString() {
        return toString(false);
    }

    String toString(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=").append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public int hashCode() {
        int iHashCode = (((((((FinalCanbus.U_CAR_LIGHT_NEAR_ENABLE + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31;
        long j = this.expiresAt;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
    }
}
