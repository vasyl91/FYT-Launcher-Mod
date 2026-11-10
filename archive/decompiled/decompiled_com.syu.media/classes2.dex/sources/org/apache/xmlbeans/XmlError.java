package org.apache.xmlbeans;

import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.xml.stream.Location;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XmlError implements Serializable {
    public static final int SEVERITY_ERROR = 0;
    public static final int SEVERITY_INFO = 2;
    public static final int SEVERITY_WARNING = 1;
    private static final ResourceBundle _bundle = PropertyResourceBundle.getBundle("org.apache.xmlbeans.message");
    private static final long serialVersionUID = 1;
    private String _code;
    private int _column;
    private transient XmlCursor _cursor;
    private int _line;
    private String _message;
    private int _offset;
    private int _severity;
    private String _source;

    public XmlError(XmlError xmlError) {
        this._severity = 0;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        this._message = xmlError.getMessage();
        this._code = xmlError.getErrorCode();
        this._severity = xmlError.getSeverity();
        this._source = xmlError.getSourceName();
        this._line = xmlError.getLine();
        this._column = xmlError.getColumn();
        this._offset = xmlError.getOffset();
        this._cursor = xmlError.getCursorLocation();
    }

    private XmlError(String str, String str2, int i, String str3, int i2, int i3, int i4, XmlCursor xmlCursor) {
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = str3;
        this._line = i2;
        this._column = i3;
        this._offset = i4;
        this._cursor = xmlCursor;
    }

    private XmlError(String str, Object[] objArr, int i, String str2, int i2, int i3, int i4, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i, str2, i2, i3, i4, xmlCursor);
    }

    protected XmlError(String str, String str2, int i, XmlCursor xmlCursor) {
        String sourceName;
        int offset;
        int column;
        this._severity = 0;
        int line = -1;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        if (xmlCursor != null) {
            sourceName = xmlCursor.documentProperties().getSourceName();
            XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
            XmlLineNumber xmlLineNumber = (XmlLineNumber) xmlCursorNewCursor.getBookmark(XmlLineNumber.class);
            xmlLineNumber = xmlLineNumber == null ? (XmlLineNumber) xmlCursorNewCursor.toPrevBookmark(XmlLineNumber.class) : xmlLineNumber;
            if (xmlLineNumber != null) {
                line = xmlLineNumber.getLine();
                column = xmlLineNumber.getColumn();
                offset = xmlLineNumber.getOffset();
            } else {
                offset = -1;
                column = -1;
            }
            xmlCursorNewCursor.dispose();
        } else {
            sourceName = null;
            offset = -1;
            column = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = sourceName;
        this._line = line;
        this._column = column;
        this._offset = offset;
        this._cursor = xmlCursor;
    }

    protected XmlError(String str, Object[] objArr, int i, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i, xmlCursor);
    }

    protected XmlError(String str, String str2, int i, Location location) {
        String publicId;
        int columnNumber;
        this._severity = 0;
        int lineNumber = -1;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        if (location != null) {
            lineNumber = location.getLineNumber();
            columnNumber = location.getColumnNumber();
            publicId = location.getPublicId();
            if (publicId == null) {
                publicId = location.getSystemId();
            }
        } else {
            publicId = null;
            columnNumber = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = publicId;
        this._line = lineNumber;
        this._column = columnNumber;
    }

    protected XmlError(String str, Object[] objArr, int i, Location location) {
        this(formattedMessage(str, objArr), str, i, location);
    }

    public static XmlError forMessage(String str) {
        return forMessage(str, 0);
    }

    public static XmlError forMessage(String str, int i) {
        return forSource(str, i, null);
    }

    public static XmlError forMessage(String str, Object[] objArr) {
        return forSource(str, objArr, 0, null);
    }

    public static XmlError forMessage(String str, Object[] objArr, int i) {
        return forSource(str, objArr, i, null);
    }

    public static XmlError forSource(String str, String str2) {
        return forLocation(str, 0, str2, -1, -1, -1);
    }

    public static XmlError forSource(String str, int i, String str2) {
        return forLocation(str, i, str2, -1, -1, -1);
    }

    public static XmlError forSource(String str, Object[] objArr, int i, String str2) {
        return forLocation(str, objArr, i, str2, -1, -1, -1);
    }

    public static XmlError forLocation(String str, String str2, Location location) {
        return new XmlError(str, (String) null, 0, str2, location.getLineNumber(), location.getColumnNumber(), -1, (XmlCursor) null);
    }

    public static XmlError forLocation(String str, String str2, int i, int i2, int i3) {
        return new XmlError(str, (String) null, 0, str2, i, i2, i3, (XmlCursor) null);
    }

    public static XmlError forLocation(String str, Object[] objArr, int i, String str2, int i2, int i3, int i4) {
        return new XmlError(str, objArr, i, str2, i2, i3, i4, (XmlCursor) null);
    }

    public static XmlError forLocation(String str, int i, String str2, int i2, int i3, int i4) {
        return new XmlError(str, (String) null, i, str2, i2, i3, i4, (XmlCursor) null);
    }

    public static XmlError forLocationAndCursor(String str, int i, String str2, int i2, int i3, int i4, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i, str2, i2, i3, i4, xmlCursor);
    }

    public static XmlError forObject(String str, XmlObject xmlObject) {
        return forObject(str, 0, xmlObject);
    }

    public static XmlError forObject(String str, Object[] objArr, XmlObject xmlObject) {
        return forObject(str, objArr, 0, xmlObject);
    }

    public static XmlError forObject(String str, int i, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, i);
        }
        return forCursor(str, i, xmlObject.newCursor());
    }

    public static XmlError forObject(String str, Object[] objArr, int i, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, objArr, i);
        }
        return forCursor(str, objArr, i, xmlObject.newCursor());
    }

    public static XmlError forCursor(String str, XmlCursor xmlCursor) {
        return forCursor(str, 0, xmlCursor);
    }

    public static XmlError forCursor(String str, Object[] objArr, XmlCursor xmlCursor) {
        return forCursor(str, objArr, 0, xmlCursor);
    }

    public static XmlError forCursor(String str, int i, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i, xmlCursor);
    }

    public static XmlError forCursor(String str, Object[] objArr, int i, XmlCursor xmlCursor) {
        return new XmlError(str, objArr, i, xmlCursor);
    }

    protected static String formattedFileName(String str, URI uri) {
        URI uriRelativize = null;
        if (str == null) {
            return null;
        }
        try {
            URI uri2 = new URI(str);
            if (uri2.isAbsolute()) {
                uriRelativize = uri2;
            }
        } catch (URISyntaxException unused) {
        }
        if (uriRelativize == null) {
            uriRelativize = new File(str).toURI();
        }
        if (uri != null) {
            uriRelativize = uri.relativize(uriRelativize);
        }
        if (!uriRelativize.isAbsolute() ? !(uri == null || !uri.isAbsolute() || uri.getScheme().compareToIgnoreCase("file") != 0) : uriRelativize.getScheme().compareToIgnoreCase("file") == 0) {
            try {
                return new File(uriRelativize).toString();
            } catch (Exception unused2) {
            }
        }
        return uriRelativize.toString();
    }

    public static String formattedMessage(String str, Object[] objArr) {
        if (str == null) {
            return null;
        }
        try {
            return MessageFormat.format(_bundle.getString(str), objArr);
        } catch (IllegalArgumentException e) {
            return MessageFormat.format(_bundle.getString("message.pattern.invalid"), e.getMessage());
        } catch (MissingResourceException e2) {
            return MessageFormat.format(_bundle.getString("message.missing.resource"), e2.getMessage());
        }
    }

    public int getSeverity() {
        return this._severity;
    }

    public String getMessage() {
        return this._message;
    }

    public String getErrorCode() {
        return this._code;
    }

    public String getSourceName() {
        return this._source;
    }

    public int getLine() {
        return this._line;
    }

    public int getColumn() {
        return this._column;
    }

    public int getOffset() {
        return this._offset;
    }

    public Object getLocation(Object obj) {
        XmlCursor xmlCursor;
        if (obj == XmlCursor.class) {
            return this._cursor;
        }
        if (obj != XmlObject.class || (xmlCursor = this._cursor) == null) {
            return null;
        }
        return xmlCursor.getObject();
    }

    public XmlCursor getCursorLocation() {
        return (XmlCursor) getLocation(XmlCursor.class);
    }

    public XmlObject getObjectLocation() {
        return (XmlObject) getLocation(XmlObject.class);
    }

    public String toString() {
        return toString(null);
    }

    public String toString(URI uri) {
        StringBuffer stringBuffer = new StringBuffer();
        String str = formattedFileName(getSourceName(), uri);
        if (str != null) {
            stringBuffer.append(str);
            int line = getLine();
            if (line < 0) {
                line = 0;
            }
            stringBuffer.append(':');
            stringBuffer.append(line);
            stringBuffer.append(':');
            if (getColumn() > 0) {
                stringBuffer.append(getColumn());
                stringBuffer.append(':');
            }
            stringBuffer.append(" ");
        }
        int severity = getSeverity();
        if (severity == 0) {
            stringBuffer.append("error: ");
        } else if (severity == 1) {
            stringBuffer.append("warning: ");
        }
        if (getErrorCode() != null) {
            stringBuffer.append(getErrorCode()).append(": ");
        }
        String message = getMessage();
        if (message == null) {
            message = "<Unspecified message>";
        }
        stringBuffer.append(message);
        return stringBuffer.toString();
    }

    public static String severityAsString(int i) {
        if (i == 0) {
            return "error";
        }
        if (i == 1) {
            return "warning";
        }
        if (i == 2) {
            return "info";
        }
        throw new IllegalArgumentException("unknown severity");
    }
}
