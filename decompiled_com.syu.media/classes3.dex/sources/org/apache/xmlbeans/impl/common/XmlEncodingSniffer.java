package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XmlEncodingSniffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String _javaencoding;
    private Reader _reader;
    private InputStream _stream;
    private String _xmlencoding;

    public XmlEncodingSniffer(InputStream inputStream, String str) throws IOException {
        this._stream = inputStream;
        if (str != null) {
            this._xmlencoding = EncodingMap.getJava2IANAMapping(str);
        }
        if (this._xmlencoding == null) {
            this._xmlencoding = str;
        }
        if (this._xmlencoding == null) {
            SniffedXmlInputStream sniffedXmlInputStream = new SniffedXmlInputStream(this._stream);
            this._xmlencoding = sniffedXmlInputStream.getXmlEncoding();
            this._stream = sniffedXmlInputStream;
        }
        String iANA2JavaMapping = EncodingMap.getIANA2JavaMapping(this._xmlencoding);
        this._javaencoding = iANA2JavaMapping;
        if (iANA2JavaMapping == null) {
            this._javaencoding = this._xmlencoding;
        }
    }

    public XmlEncodingSniffer(Reader reader, String str) throws IOException {
        str = str == null ? "UTF-8" : str;
        SniffedXmlReader sniffedXmlReader = new SniffedXmlReader(reader);
        this._reader = sniffedXmlReader;
        String xmlEncoding = sniffedXmlReader.getXmlEncoding();
        this._xmlencoding = xmlEncoding;
        if (xmlEncoding == null) {
            String java2IANAMapping = EncodingMap.getJava2IANAMapping(str);
            this._xmlencoding = java2IANAMapping;
            if (java2IANAMapping != null) {
                this._javaencoding = str;
            } else {
                this._xmlencoding = str;
            }
        }
        if (this._xmlencoding == null) {
            this._xmlencoding = "UTF-8";
        }
        String iANA2JavaMapping = EncodingMap.getIANA2JavaMapping(this._xmlencoding);
        this._javaencoding = iANA2JavaMapping;
        if (iANA2JavaMapping == null) {
            this._javaencoding = this._xmlencoding;
        }
    }

    public String getXmlEncoding() {
        return this._xmlencoding;
    }

    public String getJavaEncoding() {
        return this._javaencoding;
    }

    public InputStream getStream() throws UnsupportedEncodingException {
        InputStream inputStream = this._stream;
        if (inputStream != null) {
            this._stream = null;
            return inputStream;
        }
        if (this._reader == null) {
            return null;
        }
        ReaderInputStream readerInputStream = new ReaderInputStream(this._reader, this._javaencoding);
        this._reader = null;
        return readerInputStream;
    }

    public Reader getReader() throws UnsupportedEncodingException {
        Reader reader = this._reader;
        if (reader != null) {
            this._reader = null;
            return reader;
        }
        if (this._stream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(this._stream, this._javaencoding);
        this._stream = null;
        return inputStreamReader;
    }
}
