package org.codehaus.stax2.ri;

import java.util.NoSuchElementException;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.XMLEventAllocator;
import org.codehaus.stax2.XMLEventReader2;
import org.codehaus.stax2.XMLStreamReader2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public abstract class Stax2EventReaderImpl implements XMLEventReader2, XMLStreamConstants {
    protected static final int ERR_GETELEMTEXT_NON_TEXT_EVENT = 2;
    protected static final int ERR_GETELEMTEXT_NOT_START_ELEM = 1;
    protected static final int ERR_NEXTTAG_NON_WS_TEXT = 3;
    protected static final int ERR_NEXTTAG_WRONG_TYPE = 4;
    protected static final int STATE_CONTENT = 3;
    protected static final int STATE_END_OF_INPUT = 2;
    protected static final int STATE_INITIAL = 1;
    protected final XMLEventAllocator mAllocator;
    protected final XMLStreamReader2 mReader;
    protected XMLEvent mPeekedEvent = null;
    protected int mState = 1;
    protected int mPrePeekEvent = 7;

    protected abstract String getErrorDesc(int i, int i2);

    @Override // org.codehaus.stax2.XMLEventReader2
    public abstract boolean isPropertySupported(String str);

    @Override // org.codehaus.stax2.XMLEventReader2
    public abstract boolean setProperty(String str, Object obj);

    protected Stax2EventReaderImpl(XMLEventAllocator xMLEventAllocator, XMLStreamReader2 xMLStreamReader2) {
        this.mAllocator = xMLEventAllocator;
        this.mReader = xMLStreamReader2;
    }

    public void close() throws XMLStreamException {
        this.mReader.close();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public String getElementText() throws XMLStreamException {
        XMLEvent xMLEventNextEvent = this.mPeekedEvent;
        if (xMLEventNextEvent == null) {
            return this.mReader.getElementText();
        }
        StringBuffer stringBuffer = null;
        this.mPeekedEvent = null;
        int i = this.mPrePeekEvent;
        if (i != 1) {
            reportProblem(findErrorDesc(1, i));
        }
        String str = null;
        while (!xMLEventNextEvent.isEndElement()) {
            int eventType = xMLEventNextEvent.getEventType();
            if (eventType != 5 && eventType != 3) {
                if (!xMLEventNextEvent.isCharacters()) {
                    reportProblem(findErrorDesc(2, eventType));
                }
                String data = xMLEventNextEvent.asCharacters().getData();
                if (str == null) {
                    str = data;
                } else {
                    if (stringBuffer == null) {
                        stringBuffer = new StringBuffer(str.length() + data.length());
                        stringBuffer.append(str);
                    }
                    stringBuffer.append(data);
                }
            }
            xMLEventNextEvent = nextEvent();
        }
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return str == null ? "" : str;
    }

    public Object getProperty(String str) {
        return this.mReader.getProperty(str);
    }

    public boolean hasNext() {
        return this.mState != 2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public XMLEvent nextEvent() throws XMLStreamException {
        int i = this.mState;
        if (i == 2) {
            throwEndOfInput();
        } else if (i == 1) {
            this.mState = 3;
            return createStartDocumentEvent();
        }
        XMLEvent xMLEvent = this.mPeekedEvent;
        if (xMLEvent != null) {
            this.mPeekedEvent = null;
            if (xMLEvent.isEndDocument()) {
                updateStateEndDocument();
            }
            return xMLEvent;
        }
        return createNextEvent(true, this.mReader.next());
    }

    public Object next() {
        try {
            return nextEvent();
        } catch (XMLStreamException e) {
            throwUnchecked(e);
            return null;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    public XMLEvent nextTag() throws XMLStreamException {
        Characters characters = this.mPeekedEvent;
        if (characters != null) {
            this.mPeekedEvent = null;
            int eventType = characters.getEventType();
            if (eventType != 12) {
                switch (eventType) {
                    case 1:
                    case 2:
                        return characters;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                        break;
                    case 4:
                        if (!characters.isWhiteSpace()) {
                            reportProblem(findErrorDesc(3, eventType));
                        }
                        break;
                    case 8:
                        return null;
                    default:
                        reportProblem(findErrorDesc(4, eventType));
                        break;
                }
            } else if (!characters.isWhiteSpace()) {
                reportProblem(findErrorDesc(3, eventType));
            }
        } else if (this.mState == 1) {
            this.mState = 3;
        }
        while (true) {
            int next = this.mReader.next();
            if (next == 8) {
                return null;
            }
            if (next != 12) {
                switch (next) {
                    case 1:
                    case 2:
                        return createNextEvent(false, next);
                    case 3:
                    case 5:
                    case 6:
                        continue;
                    case 4:
                        break;
                    default:
                        reportProblem(findErrorDesc(4, next));
                        continue;
                }
            }
            if (!this.mReader.isWhiteSpace()) {
                reportProblem(findErrorDesc(3, next));
            }
        }
    }

    public XMLEvent peek() throws XMLStreamException {
        if (this.mPeekedEvent == null) {
            int i = this.mState;
            if (i == 2) {
                return null;
            }
            if (i == 1) {
                this.mPrePeekEvent = 7;
                this.mPeekedEvent = createStartDocumentEvent();
                this.mState = 3;
            } else {
                this.mPrePeekEvent = this.mReader.getEventType();
                this.mPeekedEvent = createNextEvent(false, this.mReader.next());
            }
        }
        return this.mPeekedEvent;
    }

    public void remove() {
        throw new UnsupportedOperationException("Can not remove events from XMLEventReader.");
    }

    protected void updateStateEndDocument() throws XMLStreamException {
        this.mState = 2;
    }

    @Override // org.codehaus.stax2.XMLEventReader2
    public boolean hasNextEvent() throws XMLStreamException {
        return this.mState != 2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected XMLEvent createNextEvent(boolean z, int i) throws XMLStreamException {
        try {
            XMLEvent xMLEventAllocate = this.mAllocator.allocate(this.mReader);
            if (z && i == 8) {
                updateStateEndDocument();
            }
            return xMLEventAllocate;
        } catch (RuntimeException e) {
            throw _checkUnwrap(e);
        }
    }

    protected XMLStreamException _checkUnwrap(RuntimeException runtimeException) {
        for (Throwable cause = runtimeException.getCause(); cause != null; cause = cause.getCause()) {
            if (cause instanceof XMLStreamException) {
                return (XMLStreamException) cause;
            }
        }
        throw runtimeException;
    }

    protected XMLEvent createStartDocumentEvent() throws XMLStreamException {
        return this.mAllocator.allocate(this.mReader);
    }

    protected void throwEndOfInput() {
        throw new NoSuchElementException();
    }

    protected void throwUnchecked(XMLStreamException xMLStreamException) {
        if (xMLStreamException.getNestedException() != null) {
            xMLStreamException = xMLStreamException.getNestedException();
        }
        if (xMLStreamException instanceof RuntimeException) {
            throw ((RuntimeException) xMLStreamException);
        }
        if (xMLStreamException instanceof Error) {
            throw ((Error) xMLStreamException);
        }
        throw new RuntimeException("[was " + xMLStreamException.getClass() + "] " + xMLStreamException.getMessage(), xMLStreamException);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportProblem(String str) throws XMLStreamException {
        reportProblem(str, this.mReader.getLocation());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    protected void reportProblem(String str, Location location) throws XMLStreamException {
        if (location == null) {
            throw new XMLStreamException(str);
        }
        throw new XMLStreamException(str, location);
    }

    protected XMLStreamReader getStreamReader() {
        return this.mReader;
    }

    protected final String findErrorDesc(int i, int i2) {
        String errorDesc = getErrorDesc(i, i2);
        if (errorDesc != null) {
            return errorDesc;
        }
        if (i == 1) {
            return "Current state not START_ELEMENT when calling getElementText()";
        }
        if (i == 2) {
            return "Expected a text token";
        }
        if (i != 3) {
            return i != 4 ? "Internal error (unrecognized error type: " + i + ")" : "Should only encounter START_ELEMENT/END_ELEMENT, SPACE, or all-white-space CHARACTERS";
        }
        return "Only all-whitespace CHARACTERS/CDATA (or SPACE) allowed for nextTag()";
    }
}
