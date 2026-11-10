package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import java.util.ArrayList;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class TestsDocumentImpl extends XmlComplexContentImpl implements TestsDocument {
    private static final QName TESTS$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "tests");
    private static final long serialVersionUID = 1;

    public TestsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument
    public TestsDocument.Tests getTests() {
        synchronized (monitor()) {
            check_orphaned();
            TestsDocument.Tests tests = (TestsDocument.Tests) get_store().find_element_user(TESTS$0, 0);
            if (tests == null) {
                return null;
            }
            return tests;
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument
    public void setTests(TestsDocument.Tests tests) {
        generatedSetterHelperImpl(tests, TESTS$0, 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument
    public TestsDocument.Tests addNewTests() {
        TestsDocument.Tests tests;
        synchronized (monitor()) {
            check_orphaned();
            tests = (TestsDocument.Tests) get_store().add_element_user(TESTS$0);
        }
        return tests;
    }

    public static class TestsImpl extends XmlComplexContentImpl implements TestsDocument.Tests {
        private static final QName TEST$0 = new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "test");
        private static final long serialVersionUID = 1;

        public TestsImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase[] getTestArray() {
            TestCase[] testCaseArr;
            synchronized (monitor()) {
                check_orphaned();
                ArrayList arrayList = new ArrayList();
                get_store().find_all_element_users(TEST$0, arrayList);
                testCaseArr = new TestCase[arrayList.size()];
                arrayList.toArray(testCaseArr);
            }
            return testCaseArr;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase getTestArray(int i) {
            TestCase testCase;
            synchronized (monitor()) {
                check_orphaned();
                testCase = (TestCase) get_store().find_element_user(TEST$0, i);
                if (testCase == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return testCase;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public int sizeOfTestArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(TEST$0);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public void setTestArray(TestCase[] testCaseArr) {
            check_orphaned();
            arraySetterHelper(testCaseArr, TEST$0);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public void setTestArray(int i, TestCase testCase) {
            generatedSetterHelperImpl(testCase, TEST$0, i, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase insertNewTest(int i) {
            TestCase testCase;
            synchronized (monitor()) {
                check_orphaned();
                testCase = (TestCase) get_store().insert_element_user(TEST$0, i);
            }
            return testCase;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase addNewTest() {
            TestCase testCase;
            synchronized (monitor()) {
                check_orphaned();
                testCase = (TestCase) get_store().add_element_user(TEST$0);
            }
            return testCase;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public void removeTest(int i) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(TEST$0, i);
            }
        }
    }
}
