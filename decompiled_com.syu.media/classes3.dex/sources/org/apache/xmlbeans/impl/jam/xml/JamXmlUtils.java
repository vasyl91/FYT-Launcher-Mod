package org.apache.xmlbeans.impl.jam.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JamService;
import org.apache.xmlbeans.impl.jam.JamServiceFactory;
import org.apache.xmlbeans.impl.jam.JamServiceParams;
import org.apache.xmlbeans.impl.jam.internal.CachedClassBuilder;
import org.apache.xmlbeans.impl.jam.internal.JamServiceImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JamXmlUtils {
    private static final JamXmlUtils INSTANCE = new JamXmlUtils();

    public static final JamXmlUtils getInstance() {
        return INSTANCE;
    }

    private JamXmlUtils() {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public JamService createService(InputStream inputStream) throws XMLStreamException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("null stream");
        }
        JamServiceFactory jamServiceFactory = JamServiceFactory.getInstance();
        JamServiceParams jamServiceParamsCreateServiceParams = jamServiceFactory.createServiceParams();
        CachedClassBuilder cachedClassBuilder = new CachedClassBuilder();
        jamServiceParamsCreateServiceParams.addClassBuilder(cachedClassBuilder);
        JamService jamServiceCreateService = jamServiceFactory.createService(jamServiceParamsCreateServiceParams);
        new JamXmlReader(cachedClassBuilder, inputStream, (ElementContext) jamServiceParamsCreateServiceParams).read();
        List listAsList = Arrays.asList(cachedClassBuilder.getClassNames());
        listAsList.addAll(Arrays.asList(jamServiceCreateService.getClassNames()));
        String[] strArr = new String[listAsList.size()];
        listAsList.toArray(strArr);
        ((JamServiceImpl) jamServiceCreateService).setClassNames(strArr);
        return jamServiceCreateService;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void toXml(JClass[] jClassArr, Writer writer) throws XMLStreamException, IOException {
        if (jClassArr == null) {
            throw new IllegalArgumentException("null classes");
        }
        if (writer == null) {
            throw new IllegalArgumentException("null writer");
        }
        JamXmlWriter jamXmlWriter = new JamXmlWriter(writer);
        jamXmlWriter.begin();
        for (JClass jClass : jClassArr) {
            jamXmlWriter.write(jClass);
        }
        jamXmlWriter.end();
    }
}
