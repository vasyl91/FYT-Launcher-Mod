package org.codehaus.stax2;

import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.validation.XMLValidationProblem;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface XMLReporter2 extends XMLReporter {
    void report(XMLValidationProblem xMLValidationProblem) throws XMLStreamException;
}
