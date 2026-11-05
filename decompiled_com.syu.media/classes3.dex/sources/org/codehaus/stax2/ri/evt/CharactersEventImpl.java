package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class CharactersEventImpl extends BaseEventImpl implements Characters {
    final String mContent;
    final boolean mIgnorableWS;
    final boolean mIsCData;
    boolean mIsWhitespace;
    boolean mWhitespaceChecked;

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public Characters asCharacters() {
        return this;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isCharacters() {
        return true;
    }

    public CharactersEventImpl(Location location, String str, boolean z) {
        super(location);
        this.mWhitespaceChecked = false;
        this.mIsWhitespace = false;
        this.mContent = str;
        this.mIsCData = z;
        this.mIgnorableWS = false;
    }

    private CharactersEventImpl(Location location, String str, boolean z, boolean z2, boolean z3) {
        super(location);
        this.mWhitespaceChecked = false;
        this.mContent = str;
        this.mIsCData = z;
        this.mIsWhitespace = z2;
        if (z2) {
            this.mWhitespaceChecked = true;
            this.mIgnorableWS = z3;
        } else {
            this.mWhitespaceChecked = false;
            this.mIgnorableWS = false;
        }
    }

    public static final CharactersEventImpl createIgnorableWS(Location location, String str) {
        return new CharactersEventImpl(location, str, false, true, true);
    }

    public static final CharactersEventImpl createNonIgnorableWS(Location location, String str) {
        return new CharactersEventImpl(location, str, false, true, false);
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return this.mIsCData ? 12 : 4;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            if (this.mIsCData) {
                writer.write("<![CDATA[");
                writer.write(this.mContent);
                writer.write("]]>");
            } else {
                writeEscapedXMLText(writer, this.mContent);
            }
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        if (this.mIsCData) {
            xMLStreamWriter2.writeCData(this.mContent);
        } else {
            xMLStreamWriter2.writeCharacters(this.mContent);
        }
    }

    public String getData() {
        return this.mContent;
    }

    public boolean isCData() {
        return this.mIsCData;
    }

    public boolean isIgnorableWhiteSpace() {
        return this.mIgnorableWS;
    }

    public boolean isWhiteSpace() {
        if (!this.mWhitespaceChecked) {
            this.mWhitespaceChecked = true;
            String str = this.mContent;
            int length = str.length();
            int i = 0;
            while (i < length && str.charAt(i) <= ' ') {
                i++;
            }
            this.mIsWhitespace = i == length;
        }
        return this.mIsWhitespace;
    }

    public void setWhitespaceStatus(boolean z) {
        this.mWhitespaceChecked = true;
        this.mIsWhitespace = z;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Characters)) {
            return false;
        }
        Characters characters = (Characters) obj;
        return this.mContent.equals(characters.getData()) && isCData() == characters.isCData();
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        return this.mContent.hashCode();
    }

    protected static void writeEscapedXMLText(Writer writer, String str) throws IOException {
        int i;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2 = i + 1) {
            char cCharAt = 0;
            i = i2;
            while (i < length && (cCharAt = str.charAt(i)) != '<' && cCharAt != '&' && (cCharAt != '>' || i < 2 || str.charAt(i - 1) != ']' || str.charAt(i - 2) != ']')) {
                i++;
            }
            int i3 = i - i2;
            if (i3 > 0) {
                writer.write(str, i2, i3);
            }
            if (i < length) {
                if (cCharAt == '<') {
                    writer.write("&lt;");
                } else if (cCharAt == '&') {
                    writer.write("&amp;");
                } else if (cCharAt == '>') {
                    writer.write("&gt;");
                }
            }
        }
    }
}
