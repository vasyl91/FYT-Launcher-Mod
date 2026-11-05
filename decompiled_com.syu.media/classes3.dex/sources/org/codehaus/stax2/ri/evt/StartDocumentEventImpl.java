package org.codehaus.stax2.ri.evt;

import java.io.IOException;
import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartDocument;
import org.codehaus.stax2.XMLStreamWriter2;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class StartDocumentEventImpl extends BaseEventImpl implements StartDocument {
    private final String mEncodingScheme;
    private final boolean mEncodingSet;
    private final boolean mIsStandalone;
    private final boolean mStandaloneSet;
    private final String mSystemId;
    private final String mVersion;

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int getEventType() {
        return 7;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean isStartDocument() {
        return true;
    }

    public StartDocumentEventImpl(Location location, XMLStreamReader xMLStreamReader) {
        super(location);
        this.mStandaloneSet = xMLStreamReader.standaloneSet();
        this.mIsStandalone = xMLStreamReader.isStandalone();
        String version = xMLStreamReader.getVersion();
        this.mVersion = (version == null || version.length() == 0) ? "1.0" : version;
        String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
        this.mEncodingScheme = characterEncodingScheme;
        this.mEncodingSet = characterEncodingScheme != null && characterEncodingScheme.length() > 0;
        this.mSystemId = location != null ? location.getSystemId() : "";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StartDocumentEventImpl(Location location) {
        this(location, (String) null);
    }

    public StartDocumentEventImpl(Location location, String str) {
        this(location, str, null);
    }

    public StartDocumentEventImpl(Location location, String str, String str2) {
        this(location, str, str2, false, false);
    }

    public StartDocumentEventImpl(Location location, String str, String str2, boolean z, boolean z2) {
        super(location);
        this.mEncodingScheme = str;
        this.mEncodingSet = str != null && str.length() > 0;
        this.mVersion = str2;
        this.mStandaloneSet = z;
        this.mIsStandalone = z2;
        this.mSystemId = "";
    }

    public boolean encodingSet() {
        return this.mEncodingSet;
    }

    public String getCharacterEncodingScheme() {
        return this.mEncodingScheme;
    }

    public String getSystemId() {
        return this.mSystemId;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public boolean isStandalone() {
        return this.mIsStandalone;
    }

    public boolean standaloneSet() {
        return this.mStandaloneSet;
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException {
        try {
            writer.write("<?xml version=\"");
            String str = this.mVersion;
            if (str == null || str.length() == 0) {
                writer.write("1.0");
            } else {
                writer.write(this.mVersion);
            }
            writer.write(34);
            if (this.mEncodingSet) {
                writer.write(" encoding=\"");
                writer.write(this.mEncodingScheme);
                writer.write(34);
            }
            if (this.mStandaloneSet) {
                if (this.mIsStandalone) {
                    writer.write(" standalone=\"yes\"");
                } else {
                    writer.write(" standalone=\"no\"");
                }
            }
            writer.write(" ?>");
        } catch (IOException e) {
            throwFromIOE(e);
        }
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl, org.codehaus.stax2.evt.XMLEvent2
    public void writeUsing(XMLStreamWriter2 xMLStreamWriter2) throws XMLStreamException {
        xMLStreamWriter2.writeStartDocument();
    }

    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof StartDocument)) {
            return false;
        }
        StartDocument startDocument = (StartDocument) obj;
        return encodingSet() == startDocument.encodingSet() && isStandalone() == startDocument.isStandalone() && standaloneSet() == startDocument.standaloneSet() && stringsWithNullsEqual(getCharacterEncodingScheme(), startDocument.getCharacterEncodingScheme()) && stringsWithNullsEqual(getSystemId(), startDocument.getSystemId()) && stringsWithNullsEqual(getVersion(), startDocument.getVersion());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    @Override // org.codehaus.stax2.ri.evt.BaseEventImpl
    public int hashCode() {
        ?? EncodingSet = encodingSet();
        ?? r0 = EncodingSet;
        if (isStandalone()) {
            r0 = EncodingSet - 1;
        }
        ?? r1 = r0;
        if (standaloneSet()) {
            r1 = ~r0;
        }
        String str = this.mVersion;
        ?? HashCode = r1;
        if (str != null) {
            HashCode = (r1 == true ? 1 : 0) ^ str.hashCode();
        }
        String str2 = this.mEncodingScheme;
        ?? HashCode2 = HashCode;
        if (str2 != null) {
            HashCode2 = (HashCode == true ? 1 : 0) ^ str2.hashCode();
        }
        String str3 = this.mSystemId;
        return str3 != null ? HashCode2 ^ str3.hashCode() : HashCode2;
    }
}
