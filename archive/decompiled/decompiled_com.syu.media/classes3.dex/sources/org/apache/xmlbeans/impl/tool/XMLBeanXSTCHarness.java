package org.apache.xmlbeans.impl.tool;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class XMLBeanXSTCHarness implements XSTCTester.Harness {
    @Override // org.apache.xmlbeans.impl.tool.XSTCTester.Harness
    public void runTestCase(XSTCTester.TestCaseResult testCaseResult) {
        SchemaTypeLoader schemaTypeLoaderTypeLoaderUnion;
        boolean z;
        XSTCTester.TestCase testCase = testCaseResult.getTestCase();
        ArrayList arrayList = new ArrayList();
        if (testCase.getSchemaFile() == null) {
            return;
        }
        boolean zValidate = false;
        try {
            XmlObject xmlObject = XmlObject.Factory.parse(testCase.getSchemaFile(), new XmlOptions().setErrorListener(arrayList).setLoadLineNumbers());
            XmlObject xmlObject2 = testCase.getResourceFile() != null ? XmlObject.Factory.parse(testCase.getResourceFile(), new XmlOptions().setErrorListener(arrayList).setLoadLineNumbers()) : null;
            schemaTypeLoaderTypeLoaderUnion = XmlBeans.typeLoaderUnion(new SchemaTypeLoader[]{XmlBeans.compileXsd(xmlObject2 == null ? new XmlObject[]{xmlObject} : new XmlObject[]{xmlObject, xmlObject2}, XmlBeans.getBuiltinTypeSystem(), new XmlOptions().setErrorListener(arrayList)), XmlBeans.getBuiltinTypeSystem()});
            z = true;
        } catch (Exception e) {
            if (!(e instanceof XmlException) || arrayList.isEmpty()) {
                testCaseResult.setCrash(true);
                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                testCaseResult.addSvMessages(Collections.singleton(stringWriter.toString()));
            }
            schemaTypeLoaderTypeLoaderUnion = null;
            z = false;
        }
        testCaseResult.addSvMessages(arrayList);
        testCaseResult.setSvActual(z);
        arrayList.clear();
        if (schemaTypeLoaderTypeLoaderUnion == null || testCase.getInstanceFile() == null) {
            return;
        }
        try {
            zValidate = schemaTypeLoaderTypeLoaderUnion.parse(testCase.getInstanceFile(), (SchemaType) null, new XmlOptions().setErrorListener(arrayList).setLoadLineNumbers()).validate(new XmlOptions().setErrorListener(arrayList));
        } catch (Exception e2) {
            if (!(e2 instanceof XmlException) || arrayList.isEmpty()) {
                testCaseResult.setCrash(true);
                StringWriter stringWriter2 = new StringWriter();
                e2.printStackTrace(new PrintWriter(stringWriter2));
                testCaseResult.addIvMessages(Collections.singleton(stringWriter2.toString()));
            }
        }
        testCaseResult.addIvMessages(arrayList);
        testCaseResult.setIvActual(zValidate);
    }
}
