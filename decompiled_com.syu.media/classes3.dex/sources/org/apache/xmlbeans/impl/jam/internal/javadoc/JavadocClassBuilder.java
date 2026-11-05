package org.apache.xmlbeans.impl.jam.internal.javadoc;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ProgramElementDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import com.sun.javadoc.Type;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.jam.annotation.JavadocTagParser;
import org.apache.xmlbeans.impl.jam.internal.JamServiceContextImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.internal.elements.PrimitiveClassImpl;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MElement;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;
import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class JavadocClassBuilder extends JamClassBuilder implements JamClassPopulator {
    public static final String ARGS_PROPERTY = "javadoc.args";
    public static final String PARSETAGS_PROPERTY = "javadoc.parsetags";
    private RootDoc mRootDoc = null;
    private JavadocTigerDelegate mTigerDelegate = null;
    private JavadocTagParser mTagParser = null;
    private boolean mParseTags = true;

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public void init(ElementContext elementContext) {
        if (elementContext == null) {
            throw new IllegalArgumentException("null context");
        }
        super.init(elementContext);
        getLogger().verbose("init()", this);
        initDelegate(elementContext);
        initJavadoc((JamServiceContext) elementContext);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        ArrayList arrayList;
        assertInitialized();
        if (getLogger().isVerbose(this)) {
            getLogger().verbose("trying to build '" + str + "' '" + str2 + "'");
        }
        String str3 = str.trim().length() > 0 ? str + NameUtil.PERIOD + str2 : str2;
        ClassDoc classDocClassNamed = this.mRootDoc.classNamed(str3);
        String[] strArr = null;
        if (classDocClassNamed == null) {
            if (getLogger().isVerbose(this)) {
                getLogger().verbose("no ClassDoc for " + str3);
            }
            return null;
        }
        Type[] typeArrImportedClasses = classDocClassNamed.importedClasses();
        if (typeArrImportedClasses != null) {
            arrayList = new ArrayList();
            for (Type type : typeArrImportedClasses) {
                arrayList.add(getFdFor(type));
            }
        } else {
            arrayList = null;
        }
        PackageDoc[] packageDocArrImportedPackages = classDocClassNamed.importedPackages();
        if (packageDocArrImportedPackages != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (PackageDoc packageDoc : packageDocArrImportedPackages) {
                arrayList.add(packageDoc.name() + ".*");
            }
        }
        if (arrayList != null) {
            strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
        }
        MClass mClassCreateClassToBuild = createClassToBuild(str, str2, strArr, this);
        mClassCreateClassToBuild.setArtifact(classDocClassNamed);
        return mClassCreateClassToBuild;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassPopulator
    public void populate(MClass mClass) {
        if (mClass == null) {
            throw new IllegalArgumentException("null dest");
        }
        assertInitialized();
        ProgramElementDoc programElementDoc = (ClassDoc) mClass.getArtifact();
        if (programElementDoc == null) {
            throw new IllegalStateException("null artifact");
        }
        mClass.setModifiers(programElementDoc.modifierSpecifier());
        mClass.setIsInterface(programElementDoc.isInterface());
        JavadocTigerDelegate javadocTigerDelegate = this.mTigerDelegate;
        if (javadocTigerDelegate != null) {
            mClass.setIsEnumType(javadocTigerDelegate.isEnum(programElementDoc));
        }
        ClassDoc classDocSuperclass = programElementDoc.superclass();
        if (classDocSuperclass != null) {
            mClass.setSuperclass(getFdFor(classDocSuperclass));
        }
        for (Type type : programElementDoc.interfaces()) {
            mClass.addInterface(getFdFor(type));
        }
        for (FieldDoc fieldDoc : programElementDoc.fields()) {
            populate(mClass.addNewField(), fieldDoc);
        }
        for (ExecutableMemberDoc executableMemberDoc : programElementDoc.constructors()) {
            populate(mClass.addNewConstructor(), executableMemberDoc);
        }
        for (MethodDoc methodDoc : programElementDoc.methods()) {
            populate(mClass.addNewMethod(), methodDoc);
        }
        JavadocTigerDelegate javadocTigerDelegate2 = this.mTigerDelegate;
        if (javadocTigerDelegate2 != null) {
            javadocTigerDelegate2.populateAnnotationTypeIfNecessary(programElementDoc, mClass, this);
        }
        addAnnotations(mClass, programElementDoc);
        addSourcePosition((MElement) mClass, (Doc) programElementDoc);
        ClassDoc[] classDocArrInnerClasses = programElementDoc.innerClasses();
        if (classDocArrInnerClasses != null) {
            for (int i = 0; i < classDocArrInnerClasses.length; i++) {
                MClass mClassAddNewInnerClass = mClass.addNewInnerClass(classDocArrInnerClasses[i].typeName());
                mClassAddNewInnerClass.setArtifact(classDocArrInnerClasses[i]);
                populate(mClassAddNewInnerClass);
            }
        }
    }

    public MMethod addMethod(MClass mClass, MethodDoc methodDoc) {
        MMethod mMethodAddNewMethod = mClass.addNewMethod();
        populate(mMethodAddNewMethod, methodDoc);
        return mMethodAddNewMethod;
    }

    private void initDelegate(ElementContext elementContext) {
        this.mTigerDelegate = JavadocTigerDelegate.create(elementContext);
    }

    private void initJavadoc(JamServiceContext jamServiceContext) {
        this.mTagParser = jamServiceContext.getTagParser();
        String property = jamServiceContext.getProperty(PARSETAGS_PROPERTY);
        if (property != null) {
            this.mParseTags = Boolean.valueOf(property).booleanValue();
            getLogger().verbose("mParseTags=" + this.mParseTags, this);
        }
        try {
            File[] sourceFiles = jamServiceContext.getSourceFiles();
            if (sourceFiles == null || sourceFiles.length == 0) {
                throw new IllegalArgumentException("No source files in context.");
            }
            String string = jamServiceContext.getInputSourcepath() == null ? null : jamServiceContext.getInputSourcepath().toString();
            String string2 = jamServiceContext.getInputClasspath() == null ? null : jamServiceContext.getInputClasspath().toString();
            if (getLogger().isVerbose(this)) {
                getLogger().verbose("sourcePath =" + string);
                getLogger().verbose("classPath =" + string2);
                for (File file : sourceFiles) {
                    getLogger().verbose("including '" + file + "'");
                }
            }
            try {
                RootDoc rootDocRun = JavadocRunner.newInstance().run(sourceFiles, getLogger().isVerbose(this) ? new PrintWriter(System.out) : null, string, string2, getJavadocArgs(jamServiceContext), getLogger());
                this.mRootDoc = rootDocRun;
                if (rootDocRun == null) {
                    getLogger().error("Javadoc returned a null root");
                    return;
                }
                if (getLogger().isVerbose(this)) {
                    getLogger().verbose(" received " + this.mRootDoc.classes().length + " ClassDocs from javadoc: ");
                }
                ClassDoc[] classDocArrClasses = this.mRootDoc.classes();
                for (int i = 0; i < classDocArrClasses.length; i++) {
                    if (classDocArrClasses[i].containingClass() == null) {
                        if (getLogger().isVerbose(this)) {
                            getLogger().verbose("..." + classDocArrClasses[i].qualifiedName());
                        }
                        ((JamServiceContextImpl) jamServiceContext).includeClass(getFdFor(classDocArrClasses[i]));
                    }
                }
            } catch (FileNotFoundException e) {
                getLogger().error(e);
            } catch (IOException e2) {
                getLogger().error(e2);
            }
        } catch (IOException e3) {
            getLogger().error(e3);
        }
    }

    private void populate(MField mField, FieldDoc fieldDoc) {
        mField.setArtifact(fieldDoc);
        mField.setSimpleName(fieldDoc.name());
        mField.setType(getFdFor(fieldDoc.type()));
        mField.setModifiers(fieldDoc.modifierSpecifier());
        addAnnotations(mField, fieldDoc);
        addSourcePosition((MElement) mField, (Doc) fieldDoc);
    }

    private void populate(MMethod mMethod, MethodDoc methodDoc) {
        if (mMethod == null) {
            throw new IllegalArgumentException("null dest");
        }
        if (methodDoc == null) {
            throw new IllegalArgumentException("null src");
        }
        populate((MInvokable) mMethod, (ExecutableMemberDoc) methodDoc);
        mMethod.setReturnType(getFdFor(methodDoc.returnType()));
    }

    private void populate(MInvokable mInvokable, ExecutableMemberDoc executableMemberDoc) {
        if (mInvokable == null) {
            throw new IllegalArgumentException("null dest");
        }
        if (executableMemberDoc == null) {
            throw new IllegalArgumentException("null src");
        }
        mInvokable.setArtifact(executableMemberDoc);
        mInvokable.setSimpleName(executableMemberDoc.name());
        mInvokable.setModifiers(executableMemberDoc.modifierSpecifier());
        for (Type type : executableMemberDoc.thrownExceptions()) {
            mInvokable.addException(getFdFor(type));
        }
        for (Parameter parameter : executableMemberDoc.parameters()) {
            populate(mInvokable.addNewParameter(), executableMemberDoc, parameter);
        }
        addAnnotations(mInvokable, executableMemberDoc);
        addSourcePosition((MElement) mInvokable, (Doc) executableMemberDoc);
    }

    private void populate(MParameter mParameter, ExecutableMemberDoc executableMemberDoc, Parameter parameter) {
        mParameter.setArtifact(parameter);
        mParameter.setSimpleName(parameter.name());
        mParameter.setType(getFdFor(parameter.type()));
        JavadocTigerDelegate javadocTigerDelegate = this.mTigerDelegate;
        if (javadocTigerDelegate != null) {
            javadocTigerDelegate.extractAnnotations(mParameter, executableMemberDoc, parameter);
        }
    }

    private String[] getJavadocArgs(JamServiceContext jamServiceContext) {
        String property = jamServiceContext.getProperty(ARGS_PROPERTY);
        if (property == null) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property);
        String[] strArr = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i] = stringTokenizer.nextToken();
            i++;
        }
        return strArr;
    }

    private void addAnnotations(MAnnotatedElement mAnnotatedElement, ProgramElementDoc programElementDoc) {
        String strCommentText = programElementDoc.commentText();
        if (strCommentText != null) {
            mAnnotatedElement.createComment().setText(strCommentText);
        }
        Tag[] tagArrTags = programElementDoc.tags();
        for (int i = 0; i < tagArrTags.length; i++) {
            if (getLogger().isVerbose(this)) {
                getLogger().verbose("...'" + tagArrTags[i].name() + "' ' " + tagArrTags[i].text());
            }
            this.mTagParser.parse(mAnnotatedElement, tagArrTags[i]);
        }
        JavadocTigerDelegate javadocTigerDelegate = this.mTigerDelegate;
        if (javadocTigerDelegate != null) {
            javadocTigerDelegate.extractAnnotations(mAnnotatedElement, programElementDoc);
        }
    }

    public static String getFdFor(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("null type");
        }
        String strDimension = type.dimension();
        if (strDimension == null || strDimension.length() == 0) {
            ClassDoc classDocAsClassDoc = type.asClassDoc();
            if (classDocAsClassDoc != null) {
                ClassDoc classDocContainingClass = classDocAsClassDoc.containingClass();
                if (classDocContainingClass == null) {
                    return classDocAsClassDoc.qualifiedName();
                }
                String strName = classDocAsClassDoc.name();
                return classDocContainingClass.qualifiedName() + '$' + strName.substring(strName.lastIndexOf(46) + 1);
            }
            return type.qualifiedTypeName();
        }
        StringWriter stringWriter = new StringWriter();
        int length = strDimension.length() / 2;
        for (int i = 0; i < length; i++) {
            stringWriter.write("[");
        }
        String primitiveClassForName = PrimitiveClassImpl.getPrimitiveClassForName(type.qualifiedTypeName());
        if (primitiveClassForName != null) {
            stringWriter.write(primitiveClassForName);
        } else {
            stringWriter.write("L");
            if (type.asClassDoc() != null) {
                stringWriter.write(type.asClassDoc().qualifiedName());
            } else {
                stringWriter.write(type.qualifiedTypeName());
            }
            stringWriter.write(";");
        }
        return stringWriter.toString();
    }

    public static void addSourcePosition(MElement mElement, Doc doc) {
        SourcePosition sourcePositionPosition = doc.position();
        if (sourcePositionPosition != null) {
            addSourcePosition(mElement, sourcePositionPosition);
        }
    }

    public static void addSourcePosition(MElement mElement, SourcePosition sourcePosition) {
        MSourcePosition mSourcePositionCreateSourcePosition = mElement.createSourcePosition();
        mSourcePositionCreateSourcePosition.setColumn(sourcePosition.column());
        mSourcePositionCreateSourcePosition.setLine(sourcePosition.line());
        File file = sourcePosition.file();
        if (file != null) {
            mSourcePositionCreateSourcePosition.setSourceURI(file.toURI());
        }
    }
}
