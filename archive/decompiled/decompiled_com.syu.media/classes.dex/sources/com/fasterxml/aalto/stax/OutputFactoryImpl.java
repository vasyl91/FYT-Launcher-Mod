package com.fasterxml.aalto.stax;

import com.fasterxml.aalto.dom.DOMWriterImpl;
import com.fasterxml.aalto.impl.IoStreamException;
import com.fasterxml.aalto.impl.StreamExceptionBase;
import com.fasterxml.aalto.out.AsciiXmlWriter;
import com.fasterxml.aalto.out.CharXmlWriter;
import com.fasterxml.aalto.out.Latin1XmlWriter;
import com.fasterxml.aalto.out.NonRepairingStreamWriter;
import com.fasterxml.aalto.out.RepairingStreamWriter;
import com.fasterxml.aalto.out.Utf8XmlWriter;
import com.fasterxml.aalto.out.WNameTable;
import com.fasterxml.aalto.out.WriterConfig;
import com.fasterxml.aalto.out.XmlWriter;
import com.fasterxml.aalto.util.CharsetNames;
import com.fasterxml.aalto.util.URLUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import org.codehaus.stax2.XMLOutputFactory2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.io.Stax2Result;
import org.codehaus.stax2.ri.Stax2EventWriterImpl;
import org.codehaus.stax2.ri.Stax2WriterAdapter;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class OutputFactoryImpl extends XMLOutputFactory2 {
    protected final WriterConfig _config = new WriterConfig();

    public XMLEventWriter createXMLEventWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLEventWriter(outputStream, (String) null);
    }

    public XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str) throws XMLStreamException {
        return new Stax2EventWriterImpl(createSW(outputStream, null, str, false));
    }

    public XMLEventWriter createXMLEventWriter(Result result) throws XMLStreamException {
        return new Stax2EventWriterImpl(createSW(result));
    }

    public XMLEventWriter createXMLEventWriter(Writer writer) throws XMLStreamException {
        return new Stax2EventWriterImpl(createSW(null, writer, null, false));
    }

    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLStreamWriter(outputStream, (String) null);
    }

    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str) throws XMLStreamException {
        return createSW(outputStream, null, str, false);
    }

    public XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException {
        return createSW(result);
    }

    public XMLStreamWriter createXMLStreamWriter(Writer writer) throws XMLStreamException {
        return createSW(null, writer, null, false);
    }

    public Object getProperty(String str) {
        return this._config.getProperty(str, true);
    }

    public boolean isPropertySupported(String str) {
        return this._config.isPropertySupported(str);
    }

    public void setProperty(String str, Object obj) {
        this._config.setProperty(str, obj);
    }

    public XMLEventWriter createXMLEventWriter(Writer writer, String str) throws XMLStreamException {
        return new Stax2EventWriterImpl(createSW(null, writer, str, false));
    }

    public XMLEventWriter createXMLEventWriter(XMLStreamWriter xMLStreamWriter) throws XMLStreamException {
        return new Stax2EventWriterImpl(Stax2WriterAdapter.wrapIfNecessary(xMLStreamWriter));
    }

    public XMLStreamWriter2 createXMLStreamWriter(Writer writer, String str) throws XMLStreamException {
        return createSW(null, writer, str, false);
    }

    public void configureForXmlConformance() {
        this._config.configureForXmlConformance();
    }

    public void configureForRobustness() {
        this._config.configureForRobustness();
    }

    public void configureForSpeed() {
        this._config.configureForSpeed();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    /* JADX WARN: Code duplicated, block: B:36:0x008d  */
    private XMLStreamWriter2 createSW(OutputStream outputStream, Writer writer, String str, boolean z) throws XMLStreamException {
        CharXmlWriter charXmlWriter;
        WNameTable charSymbols;
        XmlWriter asciiXmlWriter;
        WNameTable asciiSymbols;
        WriterConfig writerConfigCreateNonShared = this._config.createNonShared();
        if (z) {
            writerConfigCreateNonShared.doAutoCloseOutput(true);
        }
        if (writer == null) {
            if (str == null) {
                str = "UTF-8";
            } else if (str != "UTF-8" && str != CharsetNames.CS_ISO_LATIN1 && str != CharsetNames.CS_US_ASCII) {
                str = CharsetNames.normalize(str);
            }
            writerConfigCreateNonShared.setActualEncodingIfNotSet(str);
            try {
                if (str == "UTF-8") {
                    asciiXmlWriter = new Utf8XmlWriter(writerConfigCreateNonShared, outputStream);
                    asciiSymbols = this._config.getUtf8Symbols(asciiXmlWriter);
                } else if (str == CharsetNames.CS_ISO_LATIN1) {
                    asciiXmlWriter = new Latin1XmlWriter(writerConfigCreateNonShared, outputStream);
                    asciiSymbols = this._config.getLatin1Symbols(asciiXmlWriter);
                } else if (str == CharsetNames.CS_US_ASCII) {
                    asciiXmlWriter = new AsciiXmlWriter(writerConfigCreateNonShared, outputStream);
                    asciiSymbols = this._config.getAsciiSymbols(asciiXmlWriter);
                } else {
                    charXmlWriter = new CharXmlWriter(writerConfigCreateNonShared, new OutputStreamWriter(outputStream, str));
                    charSymbols = this._config.getCharSymbols(charXmlWriter);
                }
                if (writerConfigCreateNonShared.willRepairNamespaces()) {
                    return new RepairingStreamWriter(writerConfigCreateNonShared, asciiXmlWriter, asciiSymbols);
                }
                return new NonRepairingStreamWriter(writerConfigCreateNonShared, asciiXmlWriter, asciiSymbols);
            } catch (IOException e) {
                throw new XMLStreamException(e);
            }
        }
        if (str == null) {
            str = CharsetNames.findEncodingFor(writer);
        }
        if (str != null) {
            writerConfigCreateNonShared.setActualEncodingIfNotSet(str);
        }
        charXmlWriter = new CharXmlWriter(writerConfigCreateNonShared, writer);
        charSymbols = this._config.getCharSymbols(charXmlWriter);
        WNameTable wNameTable = charSymbols;
        asciiXmlWriter = charXmlWriter;
        asciiSymbols = wNameTable;
        if (writerConfigCreateNonShared.willRepairNamespaces()) {
            return new RepairingStreamWriter(writerConfigCreateNonShared, asciiXmlWriter, asciiSymbols);
        }
        return new NonRepairingStreamWriter(writerConfigCreateNonShared, asciiXmlWriter, asciiSymbols);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private XMLStreamWriter2 createSW(Result result) throws XMLStreamException {
        String str;
        boolean z;
        Writer writer;
        OutputStream outputStreamConstructOutputStream;
        if (result instanceof Stax2Result) {
            Stax2Result stax2Result = (Stax2Result) result;
            try {
                outputStreamConstructOutputStream = stax2Result.constructOutputStream();
                writer = outputStreamConstructOutputStream == null ? stax2Result.constructWriter() : null;
                z = true;
                str = null;
            } catch (IOException e) {
                throw new StreamExceptionBase(e);
            }
        } else if (result instanceof StreamResult) {
            StreamResult streamResult = (StreamResult) result;
            String systemId = streamResult.getSystemId();
            OutputStream outputStream = streamResult.getOutputStream();
            writer = outputStream == null ? streamResult.getWriter() : null;
            z = false;
            str = systemId;
            outputStreamConstructOutputStream = outputStream;
        } else if (result instanceof SAXResult) {
            String systemId2 = ((SAXResult) result).getSystemId();
            if (systemId2 == null || systemId2.length() == 0) {
                throw new StreamExceptionBase("Can not create a stream writer for a SAXResult that does not have System Id (support for using SAX input source not implemented)");
            }
            str = systemId2;
            z = true;
            writer = null;
            outputStreamConstructOutputStream = null;
        } else {
            if (result instanceof DOMResult) {
                return DOMWriterImpl.createFrom(this._config.createNonShared(), (DOMResult) result);
            }
            throw new IllegalArgumentException("Can not create XMLStreamWriter for Result type " + result.getClass() + " (unrecognized type)");
        }
        if (outputStreamConstructOutputStream != null) {
            return createSW(outputStreamConstructOutputStream, null, null, z);
        }
        if (writer != null) {
            return createSW(null, writer, null, z);
        }
        if (str != null && str.length() > 0) {
            try {
                return createSW(URLUtil.outputStreamFromURL(URLUtil.urlFromSystemId(str)), null, null, true);
            } catch (IOException e2) {
                throw new IoStreamException(e2);
            }
        }
        throw new StreamExceptionBase("Can not create XMLStreamWriter for passed-in Result -- neither writer, output stream nor system id (to create one) was accessible");
    }
}
