package com.fasterxml.aalto.in;

import com.fasterxml.aalto.impl.CommonConfig;
import com.fasterxml.aalto.util.BufferRecycler;
import com.fasterxml.aalto.util.CharsetNames;
import com.fasterxml.aalto.util.IllegalCharHandler;
import com.fasterxml.aalto.util.UriCanonicalizer;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlConsts;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ReaderConfig extends CommonConfig {
    public static final int DEFAULT_CHAR_BUFFER_LEN = 4000;
    static final int DEFAULT_FLAGS = 7957;
    public static final int DEFAULT_SMALL_BUFFER_LEN = 60;
    static final int F_AUTO_CLOSE_INPUT = 8192;
    static final int F_COALESCING = 2;
    static final int F_DTD_AWARE = 4;
    static final int F_DTD_VALIDATING = 8;
    static final int F_EXPAND_ENTITIES = 16;
    static final int F_INTERN_NAMES = 512;
    static final int F_INTERN_NS_URIS = 1024;
    static final int F_LAZY_PARSING = 256;
    static final int F_NS_AWARE = 1;
    static final int F_PRESERVE_LOCATION = 4096;
    static final int F_REPORT_CDATA = 2048;
    public static final int STANDALONE_NO = 2;
    public static final int STANDALONE_UNKNOWN = 0;
    public static final int STANDALONE_YES = 1;
    static final ThreadLocal<SoftReference<BufferRecycler>> _recyclerRef;
    private static final HashMap<String, Object> sProperties;
    protected BufferRecycler _currRecycler;
    private IllegalCharHandler illegalCharHandler;
    private String mActualEncoding;
    private final UriCanonicalizer mCanonicalizer;
    private final EncodingContext mEncCtxt;
    private final String mExtEncoding;
    private final String mPublicId;
    private XMLReporter mReporter;
    private XMLResolver mResolver;
    private final String mSystemId;
    private String mXmlDeclEncoding;
    private int mXmlDeclStandalone;
    private String mXmlDeclVersion;

    public void configureForXmlConformance() {
    }

    @Override // com.fasterxml.aalto.impl.CommonConfig
    public boolean isXml11() {
        return false;
    }

    public boolean willSupportNamespaces() {
        return true;
    }

    static {
        HashMap<String, Object> map = new HashMap<>();
        sProperties = map;
        map.put("javax.xml.stream.isNamespaceAware", Boolean.TRUE);
        map.put("javax.xml.stream.isValidating", 8);
        map.put("javax.xml.stream.isCoalescing", 2);
        map.put("javax.xml.stream.isReplacingEntityReferences", 16);
        map.put("javax.xml.stream.isSupportingExternalEntities", Boolean.FALSE);
        map.put("javax.xml.stream.supportDTD", 4);
        map.put("javax.xml.stream.reporter", null);
        map.put("javax.xml.stream.resolver", null);
        map.put("javax.xml.stream.allocator", null);
        map.put("com.ctc.wstx.lazyParsing", 256);
        map.put("org.codehaus.stax2.internNames", 512);
        map.put("org.codehaus.stax2.internNsUris", 1024);
        map.put("org.codehaus.stax2.closeInputSource", 8192);
        map.put("org.codehaus.stax2.preserveLocation", 4096);
        map.put("org.codehaus.stax2.reportPrologWhitespace", Boolean.FALSE);
        map.put("http://java.sun.com/xml/stream/properties/report-cdata-event", 2048);
        map.put("org.codehaus.stax2.preserveLocation", Boolean.TRUE);
        map.put("org.codehaus.stax2.propDtdOverride", null);
        _recyclerRef = new ThreadLocal<>();
    }

    private ReaderConfig(String str, String str2, String str3, EncodingContext encodingContext, int i, int i2, XMLReporter xMLReporter, XMLResolver xMLResolver, UriCanonicalizer uriCanonicalizer) {
        super(i, i2);
        this.mActualEncoding = null;
        this.mXmlDeclVersion = null;
        this.mXmlDeclEncoding = null;
        this.mXmlDeclStandalone = 0;
        this._currRecycler = null;
        this.mPublicId = str;
        this.mSystemId = str2;
        this.mExtEncoding = str3;
        SoftReference<BufferRecycler> softReference = _recyclerRef.get();
        if (softReference != null) {
            this._currRecycler = softReference.get();
        }
        this.mEncCtxt = encodingContext;
        this._flags = i;
        this._flagMods = i2;
        this.mReporter = xMLReporter;
        this.mResolver = xMLResolver;
        this.mCanonicalizer = uriCanonicalizer;
    }

    public ReaderConfig() {
        this(null, null, null, new EncodingContext(), DEFAULT_FLAGS, 0, null, null, new UriCanonicalizer());
    }

    public void setActualEncoding(String str) {
        this.mActualEncoding = str;
    }

    public void setXmlDeclInfo(int i, String str, String str2) {
        if (i == 256) {
            this.mXmlDeclVersion = "1.0";
        } else if (i == 272) {
            this.mXmlDeclVersion = XmlConsts.XML_V_11_STR;
        } else {
            this.mXmlDeclVersion = null;
        }
        this.mXmlDeclEncoding = str;
        if (str2 == XmlConsts.XML_SA_YES) {
            this.mXmlDeclStandalone = 1;
        } else if (str2 == XmlConsts.XML_SA_NO) {
            this.mXmlDeclStandalone = 2;
        } else {
            this.mXmlDeclStandalone = 0;
        }
    }

    public final void setXmlVersion(String str) {
        this.mXmlDeclVersion = str;
    }

    public final void setXmlEncoding(String str) {
        this.mXmlDeclEncoding = str;
    }

    public final void setXmlStandalone(Boolean bool) {
        if (bool == null) {
            this.mXmlDeclStandalone = 0;
        } else {
            this.mXmlDeclStandalone = bool.booleanValue() ? 1 : 2;
        }
    }

    public void setXMLReporter(XMLReporter xMLReporter) {
        this.mReporter = xMLReporter;
    }

    public void setXMLResolver(XMLResolver xMLResolver) {
        this.mResolver = xMLResolver;
    }

    public void doCoalesceText(boolean z) {
        setFlag(2, z);
    }

    public void doAutoCloseInput(boolean z) {
        setFlag(8192, z);
    }

    public void doPreserveLocation(boolean z) {
        setFlag(4096, z);
    }

    public void doParseLazily(boolean z) {
        setFlag(256, z);
    }

    public void doReportCData(boolean z) {
        setFlag(2048, z);
    }

    public ReaderConfig createNonShared(String str, String str2, String str3) {
        return new ReaderConfig(str, str2, str3, this.mEncCtxt, this._flags, this._flagMods, this.mReporter, this.mResolver, this.mCanonicalizer);
    }

    @Override // com.fasterxml.aalto.impl.CommonConfig
    public String getExternalEncoding() {
        return this.mExtEncoding;
    }

    @Override // com.fasterxml.aalto.impl.CommonConfig
    public String getActualEncoding() {
        return this.mActualEncoding;
    }

    protected int findPropertyId(String str) {
        Integer num = (Integer) sProperties.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.fasterxml.aalto.impl.CommonConfig
    public final Object getProperty(String str, boolean z) {
        HashMap<String, Object> map = sProperties;
        Object obj = map.get(str);
        if (obj == null) {
            if (map.containsKey(str)) {
                return null;
            }
            return super.getProperty(str, z);
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(((Boolean) obj).booleanValue());
        }
        if (!(obj instanceof Integer)) {
            throw new RuntimeException("Internal error: unrecognized property value type: " + obj.getClass().getName());
        }
        return Boolean.valueOf(hasFlag(((Integer) obj).intValue()));
    }

    @Override // com.fasterxml.aalto.impl.CommonConfig
    public boolean setProperty(String str, Object obj) {
        HashMap<String, Object> map = sProperties;
        Object obj2 = map.get(str);
        if (obj2 == null) {
            if (map.containsKey(str)) {
                return false;
            }
            return super.setProperty(str, obj);
        }
        if (obj2 instanceof Boolean) {
            return false;
        }
        if (!(obj2 instanceof Integer)) {
            throw new RuntimeException("Internal error");
        }
        setFlag(((Integer) obj2).intValue(), ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.fasterxml.aalto.impl.CommonConfig
    public boolean isPropertySupported(String str) {
        return sProperties.containsKey(str) || super.isPropertySupported(str);
    }

    public XMLReporter getXMLReporter() {
        return this.mReporter;
    }

    public XMLResolver getXMLResolver() {
        return this.mResolver;
    }

    public boolean willExpandEntities() {
        return hasFlag(16);
    }

    public boolean willCoalesceText() {
        return hasFlag(2);
    }

    public boolean willParseLazily() {
        return hasFlag(256);
    }

    public boolean willInternNames() {
        return hasFlag(512);
    }

    public boolean willInternNsURIs() {
        return hasFlag(1024);
    }

    public boolean willReportCData() {
        return hasFlag(2048);
    }

    public boolean willPreserveLocation() {
        return hasFlag(4096);
    }

    public boolean willAutoCloseInput() {
        return hasFlag(8192);
    }

    public boolean hasInternNamesBeenEnabled() {
        return hasExplicitFlag(512);
    }

    public boolean hasInternNsURIsBeenEnabled() {
        return hasExplicitFlag(1024);
    }

    public String getPublicId() {
        return this.mPublicId;
    }

    public String getSystemId() {
        return this.mSystemId;
    }

    public String getXmlDeclVersion() {
        return this.mXmlDeclVersion;
    }

    public String getXmlDeclEncoding() {
        return this.mXmlDeclEncoding;
    }

    public int getXmlDeclStandalone() {
        return this.mXmlDeclStandalone;
    }

    public void configureForConvenience() {
        doCoalesceText(true);
        doPreserveLocation(true);
    }

    public void configureForSpeed() {
        doCoalesceText(false);
        doPreserveLocation(false);
    }

    public void configureForLowMemUsage() {
        doCoalesceText(false);
        doPreserveLocation(false);
    }

    public void configureForRoundTripping() {
        doCoalesceText(false);
    }

    public String canonicalizeURI(char[] cArr, int i) {
        return this.mCanonicalizer.canonicalizeURI(cArr, i);
    }

    public char[] allocSmallCBuffer(int i) {
        char[] smallCBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (smallCBuffer = bufferRecycler.getSmallCBuffer(i)) == null) ? new char[i] : smallCBuffer;
    }

    public void freeSmallCBuffer(char[] cArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnSmallCBuffer(cArr);
    }

    public char[] allocMediumCBuffer(int i) {
        char[] mediumCBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (mediumCBuffer = bufferRecycler.getMediumCBuffer(i)) == null) ? new char[i] : mediumCBuffer;
    }

    public void freeMediumCBuffer(char[] cArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnMediumCBuffer(cArr);
    }

    public char[] allocFullCBuffer(int i) {
        char[] fullCBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (fullCBuffer = bufferRecycler.getFullCBuffer(i)) == null) ? new char[i] : fullCBuffer;
    }

    public void freeFullCBuffer(char[] cArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnFullCBuffer(cArr);
    }

    public byte[] allocFullBBuffer(int i) {
        byte[] fullBBuffer;
        BufferRecycler bufferRecycler = this._currRecycler;
        return (bufferRecycler == null || (fullBBuffer = bufferRecycler.getFullBBuffer(i)) == null) ? new byte[i] : fullBBuffer;
    }

    public void freeFullBBuffer(byte[] bArr) {
        if (this._currRecycler == null) {
            this._currRecycler = createRecycler();
        }
        this._currRecycler.returnFullBBuffer(bArr);
    }

    private BufferRecycler createRecycler() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        _recyclerRef.set(new SoftReference<>(bufferRecycler));
        return bufferRecycler;
    }

    public ByteBasedPNameTable getBBSymbols() {
        String str = this.mActualEncoding;
        if (str == "UTF-8") {
            return this.mEncCtxt.getUtf8Symbols();
        }
        if (str == CharsetNames.CS_ISO_LATIN1) {
            return this.mEncCtxt.getLatin1Symbols();
        }
        if (str == CharsetNames.CS_US_ASCII) {
            return this.mEncCtxt.getAsciiSymbols();
        }
        throw new Error("Internal error, unknown encoding '" + this.mActualEncoding + "'");
    }

    public CharBasedPNameTable getCBSymbols() {
        return this.mEncCtxt.getSymbols();
    }

    public void updateBBSymbols(ByteBasedPNameTable byteBasedPNameTable) {
        String str = this.mActualEncoding;
        if (str == "UTF-8") {
            this.mEncCtxt.updateUtf8Symbols(byteBasedPNameTable);
        } else if (str == CharsetNames.CS_ISO_LATIN1) {
            this.mEncCtxt.updateLatin1Symbols(byteBasedPNameTable);
        } else {
            if (str == CharsetNames.CS_US_ASCII) {
                this.mEncCtxt.updateAsciiSymbols(byteBasedPNameTable);
                return;
            }
            throw new Error("Internal error, unknown encoding '" + this.mActualEncoding + "'");
        }
    }

    public void updateCBSymbols(CharBasedPNameTable charBasedPNameTable) {
        this.mEncCtxt.updateSymbols(charBasedPNameTable);
    }

    public XmlCharTypes getCharTypes() {
        String str = this.mActualEncoding;
        if (str == "UTF-8") {
            return InputCharTypes.getUtf8CharTypes();
        }
        if (str == CharsetNames.CS_ISO_LATIN1) {
            return InputCharTypes.getLatin1CharTypes();
        }
        if (str == CharsetNames.CS_US_ASCII) {
            return InputCharTypes.getAsciiCharTypes();
        }
        throw new Error("Internal error, unknown encoding '" + this.mActualEncoding + "'");
    }

    static final class EncodingContext {
        ByteBasedPNameTable mAsciiTable;
        CharBasedPNameTable mGeneralTable;
        ByteBasedPNameTable mLatin1Table;
        ByteBasedPNameTable mUtf8Table;

        EncodingContext() {
        }

        public synchronized ByteBasedPNameTable getUtf8Symbols() {
            if (this.mUtf8Table == null) {
                this.mUtf8Table = new ByteBasedPNameTable(64);
            }
            return new ByteBasedPNameTable(this.mUtf8Table);
        }

        public synchronized void updateUtf8Symbols(ByteBasedPNameTable byteBasedPNameTable) {
            this.mUtf8Table.mergeFromChild(byteBasedPNameTable);
        }

        public synchronized ByteBasedPNameTable getLatin1Symbols() {
            if (this.mLatin1Table == null) {
                this.mLatin1Table = new ByteBasedPNameTable(64);
            }
            return new ByteBasedPNameTable(this.mLatin1Table);
        }

        public synchronized void updateLatin1Symbols(ByteBasedPNameTable byteBasedPNameTable) {
            this.mLatin1Table.mergeFromChild(byteBasedPNameTable);
        }

        public synchronized ByteBasedPNameTable getAsciiSymbols() {
            if (this.mAsciiTable == null) {
                this.mAsciiTable = new ByteBasedPNameTable(64);
            }
            return new ByteBasedPNameTable(this.mAsciiTable);
        }

        public synchronized void updateAsciiSymbols(ByteBasedPNameTable byteBasedPNameTable) {
            this.mAsciiTable.mergeFromChild(byteBasedPNameTable);
        }

        public synchronized CharBasedPNameTable getSymbols() {
            if (this.mGeneralTable == null) {
                this.mGeneralTable = new CharBasedPNameTable(64);
            }
            return new CharBasedPNameTable(this.mGeneralTable);
        }

        public synchronized void updateSymbols(CharBasedPNameTable charBasedPNameTable) {
            this.mGeneralTable.mergeFromChild(charBasedPNameTable);
        }
    }

    public void setIllegalCharHandler(IllegalCharHandler illegalCharHandler) {
        this.illegalCharHandler = illegalCharHandler;
    }

    public IllegalCharHandler getIllegalCharHandler() {
        return this.illegalCharHandler;
    }
}
