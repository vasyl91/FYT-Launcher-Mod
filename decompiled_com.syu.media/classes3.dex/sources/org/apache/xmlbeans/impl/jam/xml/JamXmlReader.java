package org.apache.xmlbeans.impl.jam.xml;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.CachedClassBuilder;
import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;
import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class JamXmlReader implements JamXmlElements {
    private CachedClassBuilder mCache;
    private ElementContext mContext;
    private XMLStreamReader mIn;

    public JamXmlReader(CachedClassBuilder cachedClassBuilder, InputStream inputStream, ElementContext elementContext) throws XMLStreamException {
        this(cachedClassBuilder, XMLInputFactory.newInstance().createXMLStreamReader(inputStream), elementContext);
    }

    public JamXmlReader(CachedClassBuilder cachedClassBuilder, Reader reader, ElementContext elementContext) throws XMLStreamException {
        this(cachedClassBuilder, XMLInputFactory.newInstance().createXMLStreamReader(reader), elementContext);
    }

    public JamXmlReader(CachedClassBuilder cachedClassBuilder, XMLStreamReader xMLStreamReader, ElementContext elementContext) {
        if (cachedClassBuilder == null) {
            throw new IllegalArgumentException("null cache");
        }
        if (xMLStreamReader == null) {
            throw new IllegalArgumentException("null cache");
        }
        if (elementContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        this.mIn = xMLStreamReader;
        this.mCache = cachedClassBuilder;
        this.mContext = elementContext;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void read() throws XMLStreamException {
        nextElement();
        assertStart(JamXmlElements.JAMSERVICE);
        nextElement();
        while (JamXmlElements.CLASS.equals(getElementName())) {
            readClass();
        }
        assertEnd(JamXmlElements.JAMSERVICE);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void readClass() throws XMLStreamException {
        String strSubstring;
        assertStart(JamXmlElements.CLASS);
        nextElement();
        String strAssertCurrentString = assertCurrentString("name");
        int iLastIndexOf = strAssertCurrentString.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = strAssertCurrentString.substring(0, iLastIndexOf);
            strAssertCurrentString = strAssertCurrentString.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "";
        }
        MClass mClassCreateClassToBuild = this.mCache.createClassToBuild(strSubstring, strAssertCurrentString, null);
        mClassCreateClassToBuild.setIsInterface(assertCurrentBoolean(JamXmlElements.ISINTERFACE));
        mClassCreateClassToBuild.setModifiers(assertCurrentInt(JamXmlElements.MODIFIERS));
        String strCheckCurrentString = checkCurrentString(JamXmlElements.SUPERCLASS);
        if (strCheckCurrentString != null) {
            mClassCreateClassToBuild.setSuperclass(strCheckCurrentString);
        }
        while (true) {
            String strCheckCurrentString2 = checkCurrentString(JamXmlElements.INTERFACE);
            if (strCheckCurrentString2 == null) {
                break;
            } else {
                mClassCreateClassToBuild.addInterface(strCheckCurrentString2);
            }
        }
        while (JamXmlElements.FIELD.equals(getElementName())) {
            readField(mClassCreateClassToBuild);
        }
        while (JamXmlElements.CONSTRUCTOR.equals(getElementName())) {
            readConstructor(mClassCreateClassToBuild);
        }
        while (JamXmlElements.METHOD.equals(getElementName())) {
            readMethod(mClassCreateClassToBuild);
        }
        readAnnotatedElement(mClassCreateClassToBuild);
        assertEnd(JamXmlElements.CLASS);
        ((ClassImpl) mClassCreateClassToBuild).setState(6);
        nextElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void readField(MClass mClass) throws XMLStreamException {
        assertStart(JamXmlElements.FIELD);
        MField mFieldAddNewField = mClass.addNewField();
        nextElement();
        mFieldAddNewField.setSimpleName(assertCurrentString("name"));
        mFieldAddNewField.setModifiers(assertCurrentInt(JamXmlElements.MODIFIERS));
        mFieldAddNewField.setType(assertCurrentString(JamXmlElements.TYPE));
        readAnnotatedElement(mFieldAddNewField);
        assertEnd(JamXmlElements.FIELD);
        nextElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void readConstructor(MClass mClass) throws XMLStreamException {
        assertStart(JamXmlElements.CONSTRUCTOR);
        MConstructor mConstructorAddNewConstructor = mClass.addNewConstructor();
        nextElement();
        readInvokableContents(mConstructorAddNewConstructor);
        assertEnd(JamXmlElements.CONSTRUCTOR);
        nextElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void readMethod(MClass mClass) throws XMLStreamException {
        assertStart(JamXmlElements.METHOD);
        MMethod mMethodAddNewMethod = mClass.addNewMethod();
        nextElement();
        mMethodAddNewMethod.setSimpleName(assertCurrentString("name"));
        mMethodAddNewMethod.setReturnType(assertCurrentString(JamXmlElements.RETURNTYPE));
        readInvokableContents(mMethodAddNewMethod);
        assertEnd(JamXmlElements.METHOD);
        nextElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void readSourcePosition(MAnnotatedElement mAnnotatedElement) throws XMLStreamException {
        assertStart(JamXmlElements.SOURCEPOSITION);
        MSourcePosition mSourcePositionCreateSourcePosition = mAnnotatedElement.createSourcePosition();
        nextElement();
        if (JamXmlElements.LINE.equals(getElementName())) {
            mSourcePositionCreateSourcePosition.setLine(assertCurrentInt(JamXmlElements.LINE));
        }
        if (JamXmlElements.COLUMN.equals(getElementName())) {
            mSourcePositionCreateSourcePosition.setColumn(assertCurrentInt(JamXmlElements.COLUMN));
        }
        if (JamXmlElements.SOURCEURI.equals(getElementName())) {
            try {
                mSourcePositionCreateSourcePosition.setSourceURI(new URI(assertCurrentString(JamXmlElements.SOURCEURI)));
            } catch (URISyntaxException e) {
                throw new XMLStreamException(e);
            }
        }
        assertEnd(JamXmlElements.SOURCEPOSITION);
        nextElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void readInvokableContents(MInvokable mInvokable) throws XMLStreamException {
        mInvokable.setModifiers(assertCurrentInt(JamXmlElements.MODIFIERS));
        while (JamXmlElements.PARAMETER.equals(getElementName())) {
            nextElement();
            MParameter mParameterAddNewParameter = mInvokable.addNewParameter();
            mParameterAddNewParameter.setSimpleName(assertCurrentString("name"));
            mParameterAddNewParameter.setType(assertCurrentString(JamXmlElements.TYPE));
            readAnnotatedElement(mParameterAddNewParameter);
            assertEnd(JamXmlElements.PARAMETER);
            nextElement();
        }
        readAnnotatedElement(mInvokable);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void readAnnotatedElement(MAnnotatedElement mAnnotatedElement) throws XMLStreamException {
        while (JamXmlElements.ANNOTATION.equals(getElementName())) {
            nextElement();
            MAnnotation mAnnotationAddLiteralAnnotation = mAnnotatedElement.addLiteralAnnotation(assertCurrentString("name"));
            while (JamXmlElements.ANNOTATIONVALUE.equals(getElementName())) {
                nextElement();
                String strAssertCurrentString = assertCurrentString("name");
                JClass jClassLoadClass = this.mContext.getClassLoader().loadClass(assertCurrentString(JamXmlElements.TYPE));
                if (jClassLoadClass.isArrayType()) {
                    ArrayList arrayList = new ArrayList();
                    while ("value".equals(getElementName())) {
                        arrayList.add(assertCurrentString("value"));
                    }
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    mAnnotationAddLiteralAnnotation.setSimpleValue(strAssertCurrentString, strArr, jClassLoadClass);
                } else {
                    mAnnotationAddLiteralAnnotation.setSimpleValue(strAssertCurrentString, assertCurrentString("value"), jClassLoadClass);
                }
                assertEnd(JamXmlElements.ANNOTATIONVALUE);
                nextElement();
            }
            assertEnd(JamXmlElements.ANNOTATION);
            nextElement();
        }
        if (JamXmlElements.COMMENT.equals(getElementName())) {
            mAnnotatedElement.createComment().setText(this.mIn.getElementText());
            assertEnd(JamXmlElements.COMMENT);
            nextElement();
        }
        if (JamXmlElements.SOURCEPOSITION.equals(getElementName())) {
            readSourcePosition(mAnnotatedElement);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void assertStart(String str) throws XMLStreamException {
        if (this.mIn.isStartElement() && str.equals(getElementName())) {
            return;
        }
        error("expected to get a <" + str + ">, ");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void assertEnd(String str) throws XMLStreamException {
        if (this.mIn.isEndElement() && str.equals(getElementName())) {
            return;
        }
        error("expected to get a </" + str + ">, ");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private String checkCurrentString(String str) throws XMLStreamException {
        if (!str.equals(getElementName())) {
            return null;
        }
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return elementText;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private String assertCurrentString(String str) throws XMLStreamException {
        assertStart(str);
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return elementText;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private int assertCurrentInt(String str) throws XMLStreamException {
        assertStart(str);
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return Integer.valueOf(elementText).intValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private boolean assertCurrentBoolean(String str) throws XMLStreamException {
        assertStart(str);
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return Boolean.valueOf(elementText).booleanValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void error(String str) throws XMLStreamException {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("<");
        stringWriter.write(this.mIn.getLocalName());
        stringWriter.write("> line:");
        stringWriter.write("" + this.mIn.getLocation().getLineNumber());
        stringWriter.write(" col:");
        stringWriter.write("" + this.mIn.getLocation().getColumnNumber());
        stringWriter.write("]");
        throw new XMLStreamException(str + ":\n " + stringWriter.toString());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void nextElement() throws XMLStreamException {
        while (this.mIn.next() != -1) {
            if (this.mIn.isEndElement() || this.mIn.isStartElement()) {
                return;
            }
        }
        throw new XMLStreamException("Unexpected end of file");
    }

    private String getElementName() {
        return this.mIn.getLocalName();
    }
}
