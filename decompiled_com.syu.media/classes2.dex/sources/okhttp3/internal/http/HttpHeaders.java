package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Objects.equals(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> setEmptySet = Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String strValue = headers.value(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strValue.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> setVaryFields = varyFields(headers2);
        if (setVaryFields.isEmpty()) {
            return Util.EMPTY_HEADERS;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            if (setVaryFields.contains(strName)) {
                builder.add(strName, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                parseChallengeHeader(arrayList, new Buffer().writeUtf8(headers.value(i)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008a  */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:61:0x007f A[EDGE_INSN: B:61:0x007f->B:28:0x007f BREAK  A[LOOP:2: B:22:0x006c->B:51:0x00c7], SYNTHETIC] */
    private static void parseChallengeHeader(List<Challenge> list, Buffer buffer) {
        String token;
        while (true) {
            String token2 = null;
            while (true) {
                if (token2 == null) {
                    skipWhitespaceAndCommas(buffer);
                    token2 = readToken(buffer);
                    if (token2 == null) {
                        return;
                    }
                }
                boolean zSkipWhitespaceAndCommas = skipWhitespaceAndCommas(buffer);
                String token3 = readToken(buffer);
                if (token3 == null) {
                    if (buffer.exhausted()) {
                        list.add(new Challenge(token2, (Map<String, String>) Collections.emptyMap()));
                        return;
                    }
                    return;
                }
                int iSkipAll = skipAll(buffer, DeletedArea3DPtg.sid);
                boolean zSkipWhitespaceAndCommas2 = skipWhitespaceAndCommas(buffer);
                if (!zSkipWhitespaceAndCommas && (zSkipWhitespaceAndCommas2 || buffer.exhausted())) {
                    list.add(new Challenge(token2, (Map<String, String>) Collections.singletonMap(null, token3 + repeat('=', iSkipAll))));
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iSkipAll2 = iSkipAll + skipAll(buffer, DeletedArea3DPtg.sid);
                    while (true) {
                        if (token3 == null) {
                            token3 = readToken(buffer);
                            if (skipWhitespaceAndCommas(buffer)) {
                                break;
                            }
                            iSkipAll2 = skipAll(buffer, DeletedArea3DPtg.sid);
                            if (iSkipAll2 == 0) {
                                break;
                            }
                            if (iSkipAll2 <= 1 || skipWhitespaceAndCommas(buffer)) {
                                return;
                            }
                            if (buffer.exhausted() && buffer.getByte(0L) == 34) {
                                token = readQuotedString(buffer);
                            } else {
                                token = readToken(buffer);
                            }
                            if (token != null || ((String) linkedHashMap.put(token3, token)) != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(buffer) && !buffer.exhausted()) {
                                return;
                            } else {
                                token3 = null;
                            }
                        } else {
                            if (iSkipAll2 == 0) {
                                break;
                                break;
                            }
                            if (iSkipAll2 <= 1) {
                                return;
                            }
                            if (buffer.exhausted()) {
                                token = readToken(buffer);
                            } else {
                                token = readToken(buffer);
                            }
                            if (token != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(buffer)) {
                            }
                            token3 = null;
                        }
                    }
                    list.add(new Challenge(token2, linkedHashMap));
                    token2 = token3;
                }
            }
        }
    }

    private static boolean skipWhitespaceAndCommas(Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            if (b != 44) {
                if (b != 32 && b != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    private static int skipAll(Buffer buffer, byte b) {
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    private static String readQuotedString(Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException();
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == 34) {
                buffer2.write(buffer, jIndexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == jIndexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, jIndexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    private static String readToken(Buffer buffer) {
        try {
            long jIndexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (jIndexOfElement == -1) {
                jIndexOfElement = buffer.size();
            }
            if (jIndexOfElement != 0) {
                return buffer.readUtf8(jIndexOfElement);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
