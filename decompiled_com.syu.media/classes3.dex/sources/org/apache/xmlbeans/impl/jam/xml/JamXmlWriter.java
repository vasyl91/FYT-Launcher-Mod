package org.apache.xmlbeans.impl.jam.xml;

import java.io.Writer;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.apache.xmlbeans.impl.jam.JAnnotatedElement;
import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JComment;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.apache.xmlbeans.impl.jam.JField;
import org.apache.xmlbeans.impl.jam.JInvokable;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.apache.xmlbeans.impl.jam.JSourcePosition;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
class JamXmlWriter implements JamXmlElements {
    private XMLStreamWriter mOut;
    private boolean mInBody = false;
    private boolean mWriteSourceURI = false;

    public JamXmlWriter(Writer writer) throws XMLStreamException {
        if (writer == null) {
            throw new IllegalArgumentException("null out");
        }
        this.mOut = XMLOutputFactory.newInstance().createXMLStreamWriter(writer);
    }

    public JamXmlWriter(XMLStreamWriter xMLStreamWriter) {
        if (xMLStreamWriter == null) {
            throw new IllegalArgumentException("null out");
        }
        this.mOut = xMLStreamWriter;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void begin() throws XMLStreamException {
        if (this.mInBody) {
            throw new XMLStreamException("begin() already called");
        }
        this.mOut.writeStartElement(JamXmlElements.JAMSERVICE);
        this.mInBody = true;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void end() throws XMLStreamException {
        if (!this.mInBody) {
            throw new XMLStreamException("begin() never called");
        }
        this.mOut.writeEndElement();
        this.mInBody = false;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    public void write(JClass jClass) throws XMLStreamException {
        assertStarted();
        this.mOut.writeStartElement(JamXmlElements.CLASS);
        writeValueElement("name", jClass.getFieldDescriptor());
        writeValueElement(JamXmlElements.ISINTERFACE, jClass.isInterface());
        writeModifiers(jClass.getModifiers());
        JClass superclass = jClass.getSuperclass();
        if (superclass != null) {
            writeValueElement(JamXmlElements.SUPERCLASS, superclass.getFieldDescriptor());
        }
        writeClassList(JamXmlElements.INTERFACE, jClass.getInterfaces());
        for (JField jField : jClass.getDeclaredFields()) {
            write(jField);
        }
        for (JConstructor jConstructor : jClass.getConstructors()) {
            write(jConstructor);
        }
        for (JMethod jMethod : jClass.getDeclaredMethods()) {
            write(jMethod);
        }
        writeAnnotatedElement(jClass);
        this.mOut.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void write(JMethod jMethod) throws XMLStreamException {
        this.mOut.writeStartElement(JamXmlElements.METHOD);
        writeValueElement("name", jMethod.getSimpleName());
        writeValueElement(JamXmlElements.RETURNTYPE, jMethod.getReturnType().getFieldDescriptor());
        writeInvokable(jMethod);
        this.mOut.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void write(JConstructor jConstructor) throws XMLStreamException {
        this.mOut.writeStartElement(JamXmlElements.CONSTRUCTOR);
        writeInvokable(jConstructor);
        this.mOut.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void write(JField jField) throws XMLStreamException {
        this.mOut.writeStartElement(JamXmlElements.FIELD);
        writeValueElement("name", jField.getSimpleName());
        writeModifiers(jField.getModifiers());
        writeValueElement(JamXmlElements.TYPE, jField.getType().getFieldDescriptor());
        writeAnnotatedElement(jField);
        this.mOut.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void writeInvokable(JInvokable jInvokable) throws XMLStreamException {
        writeModifiers(jInvokable.getModifiers());
        JParameter[] parameters = jInvokable.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            this.mOut.writeStartElement(JamXmlElements.PARAMETER);
            writeValueElement("name", parameters[i].getSimpleName());
            writeValueElement(JamXmlElements.TYPE, parameters[i].getType().getFieldDescriptor());
            writeAnnotatedElement(parameters[i]);
            this.mOut.writeEndElement();
        }
        writeAnnotatedElement(jInvokable);
    }

    private void writeClassList(String str, JClass[] jClassArr) throws XMLStreamException {
        for (JClass jClass : jClassArr) {
            this.mOut.writeStartElement(str);
            this.mOut.writeCharacters(jClass.getFieldDescriptor());
            this.mOut.writeEndElement();
        }
    }

    private void writeModifiers(int i) throws XMLStreamException {
        this.mOut.writeStartElement(JamXmlElements.MODIFIERS);
        this.mOut.writeCharacters(String.valueOf(i));
        this.mOut.writeEndElement();
    }

    private void writeValueElement(String str, boolean z) throws XMLStreamException {
        this.mOut.writeStartElement(str);
        this.mOut.writeCharacters(String.valueOf(z));
        this.mOut.writeEndElement();
    }

    private void writeValueElement(String str, int i) throws XMLStreamException {
        this.mOut.writeStartElement(str);
        this.mOut.writeCharacters(String.valueOf(i));
        this.mOut.writeEndElement();
    }

    private void writeValueElement(String str, String str2) throws XMLStreamException {
        this.mOut.writeStartElement(str);
        this.mOut.writeCharacters(str2);
        this.mOut.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void writeValueElement(String str, String[] strArr) throws XMLStreamException {
        for (String str2 : strArr) {
            writeValueElement(str, str2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void writeAnnotatedElement(JAnnotatedElement jAnnotatedElement) throws XMLStreamException {
        String text;
        for (JAnnotation jAnnotation : jAnnotatedElement.getAnnotations()) {
            writeAnnotation(jAnnotation);
        }
        JComment comment = jAnnotatedElement.getComment();
        if (comment != null && (text = comment.getText()) != null && text.trim().length() > 0) {
            this.mOut.writeStartElement(JamXmlElements.COMMENT);
            this.mOut.writeCData(comment.getText());
            this.mOut.writeEndElement();
        }
        JSourcePosition sourcePosition = jAnnotatedElement.getSourcePosition();
        if (sourcePosition != null) {
            this.mOut.writeStartElement(JamXmlElements.SOURCEPOSITION);
            if (sourcePosition.getLine() != -1) {
                writeValueElement(JamXmlElements.LINE, sourcePosition.getLine());
            }
            if (sourcePosition.getColumn() != -1) {
                writeValueElement(JamXmlElements.COLUMN, sourcePosition.getColumn());
            }
            if (this.mWriteSourceURI && sourcePosition.getSourceURI() != null) {
                writeValueElement(JamXmlElements.SOURCEURI, sourcePosition.getSourceURI().toString());
            }
            this.mOut.writeEndElement();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void writeAnnotation(JAnnotation jAnnotation) throws XMLStreamException {
        this.mOut.writeStartElement(JamXmlElements.ANNOTATION);
        writeValueElement("name", jAnnotation.getQualifiedName());
        for (JAnnotationValue jAnnotationValue : jAnnotation.getValues()) {
            writeAnnotationValue(jAnnotationValue);
        }
        this.mOut.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void writeAnnotationValue(JAnnotationValue jAnnotationValue) throws XMLStreamException {
        this.mOut.writeStartElement(JamXmlElements.ANNOTATIONVALUE);
        writeValueElement("name", jAnnotationValue.getName());
        writeValueElement(JamXmlElements.TYPE, jAnnotationValue.getType().getFieldDescriptor());
        if (jAnnotationValue.getType().isArrayType()) {
            writeValueElement("value", jAnnotationValue.asStringArray());
        } else {
            writeValueElement("value", jAnnotationValue.asString());
        }
        this.mOut.writeEndElement();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    private void assertStarted() throws XMLStreamException {
        if (!this.mInBody) {
            throw new XMLStreamException("begin() not called");
        }
    }
}
