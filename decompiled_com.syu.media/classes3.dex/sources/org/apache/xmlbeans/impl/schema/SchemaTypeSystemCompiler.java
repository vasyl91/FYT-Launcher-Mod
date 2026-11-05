package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class SchemaTypeSystemCompiler {

    public static class Parameters {
        private URI baseURI;
        private BindingConfig config;
        private Collection errorListener;
        private SchemaTypeSystem existingSystem;
        private boolean javaize;
        private SchemaTypeLoader linkTo;
        private String name;
        private XmlOptions options;
        private SchemaDocument.Schema[] schemas;
        private File schemasDir;
        private Map sourcesToCopyMap;

        public SchemaTypeSystem getExistingTypeSystem() {
            return this.existingSystem;
        }

        public void setExistingTypeSystem(SchemaTypeSystem schemaTypeSystem) {
            this.existingSystem = schemaTypeSystem;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public SchemaDocument.Schema[] getSchemas() {
            return this.schemas;
        }

        public void setSchemas(SchemaDocument.Schema[] schemaArr) {
            this.schemas = schemaArr;
        }

        public BindingConfig getConfig() {
            return this.config;
        }

        public void setConfig(BindingConfig bindingConfig) {
            this.config = bindingConfig;
        }

        public SchemaTypeLoader getLinkTo() {
            return this.linkTo;
        }

        public void setLinkTo(SchemaTypeLoader schemaTypeLoader) {
            this.linkTo = schemaTypeLoader;
        }

        public XmlOptions getOptions() {
            return this.options;
        }

        public void setOptions(XmlOptions xmlOptions) {
            this.options = xmlOptions;
        }

        public Collection getErrorListener() {
            return this.errorListener;
        }

        public void setErrorListener(Collection collection) {
            this.errorListener = collection;
        }

        public boolean isJavaize() {
            return this.javaize;
        }

        public void setJavaize(boolean z) {
            this.javaize = z;
        }

        public URI getBaseURI() {
            return this.baseURI;
        }

        public void setBaseURI(URI uri) {
            this.baseURI = uri;
        }

        public Map getSourcesToCopyMap() {
            return this.sourcesToCopyMap;
        }

        public void setSourcesToCopyMap(Map map) {
            this.sourcesToCopyMap = map;
        }

        public File getSchemasDir() {
            return this.schemasDir;
        }

        public void setSchemasDir(File file) {
            this.schemasDir = file;
        }
    }

    public static SchemaTypeSystem compile(Parameters parameters) {
        return compileImpl(parameters.getExistingTypeSystem(), parameters.getName(), parameters.getSchemas(), parameters.getConfig(), parameters.getLinkTo(), parameters.getOptions(), parameters.getErrorListener(), parameters.isJavaize(), parameters.getBaseURI(), parameters.getSourcesToCopyMap(), parameters.getSchemasDir());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    public static SchemaTypeSystemImpl compile(String str, SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, Filer filer, XmlOptions xmlOptions) throws XmlException {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        ArrayList arrayList = new ArrayList();
        if (xmlObjectArr != null) {
            for (int i = 0; i < xmlObjectArr.length; i++) {
                XmlObject xmlObject = xmlObjectArr[i];
                if (xmlObject instanceof SchemaDocument.Schema) {
                    arrayList.add(xmlObject);
                } else if ((xmlObject instanceof SchemaDocument) && ((SchemaDocument) xmlObject).getSchema() != null) {
                    arrayList.add(((SchemaDocument) xmlObjectArr[i]).getSchema());
                } else {
                    throw new XmlException("Thread " + Thread.currentThread().getName() + ": The " + i + "th supplied input is not a schema document: its type is " + xmlObjectArr[i].schemaType());
                }
            }
        }
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher((Collection) xmlOptionsMaskNull.get("ERROR_LISTENER"));
        SchemaTypeSystemImpl schemaTypeSystemImplCompileImpl = compileImpl(schemaTypeSystem, str, (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[arrayList.size()]), bindingConfig, schemaTypeLoader, xmlOptionsMaskNull, xmlErrorWatcher, filer != null, (URI) xmlOptionsMaskNull.get("BASE_URI"), null, null);
        if (xmlErrorWatcher.hasError() && schemaTypeSystemImplCompileImpl == null) {
            throw new XmlException(xmlErrorWatcher.firstError());
        }
        if (schemaTypeSystemImplCompileImpl != null && !schemaTypeSystemImplCompileImpl.isIncomplete() && filer != null) {
            schemaTypeSystemImplCompileImpl.save(filer);
            generateTypes(schemaTypeSystemImplCompileImpl, filer, xmlOptionsMaskNull);
        }
        return schemaTypeSystemImplCompileImpl;
    }

    static SchemaTypeSystemImpl compileImpl(SchemaTypeSystem schemaTypeSystem, String str, SchemaDocument.Schema[] schemaArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection collection, boolean z, URI uri, Map map, File file) {
        if (schemaTypeLoader == null) {
            throw new IllegalArgumentException("Must supply linkTo");
        }
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
        boolean z2 = schemaTypeSystem != null;
        StscState stscStateStart = StscState.start();
        boolean z3 = xmlOptions == null || !xmlOptions.hasOption("COMPILE_NO_VALIDATION");
        try {
            stscStateStart.setErrorListener(xmlErrorWatcher);
            stscStateStart.setBindingConfig(bindingConfig);
            stscStateStart.setOptions(xmlOptions);
            stscStateStart.setGivenTypeSystemName(str);
            stscStateStart.setSchemasDir(file);
            if (uri != null) {
                stscStateStart.setBaseUri(uri);
            }
            stscStateStart.setImportingTypeLoader(SchemaTypeLoaderImpl.build(new SchemaTypeLoader[]{BuiltinSchemaTypeSystem.get(), schemaTypeLoader}, null, null));
            ArrayList arrayList = new ArrayList(schemaArr.length);
            if (z3) {
                XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
                if (xmlOptions.hasOption("VALIDATE_TREAT_LAX_AS_SKIP")) {
                    errorListener.setValidateTreatLaxAsSkip();
                }
                for (int i = 0; i < schemaArr.length; i++) {
                    if (schemaArr[i].validate(errorListener)) {
                        arrayList.add(schemaArr[i]);
                    }
                }
            } else {
                arrayList.addAll(Arrays.asList(schemaArr));
            }
            SchemaDocument.Schema[] schemasToRecompile = (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[arrayList.size()]);
            if (z2) {
                HashSet hashSet = new HashSet();
                schemasToRecompile = getSchemasToRecompile((SchemaTypeSystemImpl) schemaTypeSystem, schemasToRecompile, hashSet);
                stscStateStart.initFromTypeSystem((SchemaTypeSystemImpl) schemaTypeSystem, hashSet);
            } else {
                stscStateStart.setDependencies(new SchemaDependencies());
            }
            StscTranslator.addAllDefinitions(StscImporter.resolveImportsAndIncludes(schemasToRecompile, z2));
            StscResolver.resolveAll();
            StscChecker.checkAll();
            StscJavaizer.javaizeAllTypes(z);
            StscState.get().sts().loadFromStscState(stscStateStart);
            if (map != null) {
                map.putAll(stscStateStart.sourceCopyMap());
            }
            if (xmlErrorWatcher.hasError()) {
                if (!stscStateStart.allowPartial() || stscStateStart.getRecovered() != xmlErrorWatcher.size()) {
                    return null;
                }
                StscState.get().sts().setIncomplete(true);
            }
            if (schemaTypeSystem != null) {
                ((SchemaTypeSystemImpl) schemaTypeSystem).setIncomplete(true);
            }
            return StscState.get().sts();
        } finally {
            StscState.end();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.xmlbeans.XmlException */
    private static SchemaDocument.Schema[] getSchemasToRecompile(SchemaTypeSystemImpl schemaTypeSystemImpl, SchemaDocument.Schema[] schemaArr, Set set) {
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < schemaArr.length; i++) {
            String sourceName = schemaArr[i].documentProperties().getSourceName();
            if (sourceName == null) {
                throw new IllegalArgumentException("One of the Schema files passed in doesn't have the source set, which prevents it to be incrementally compiled");
            }
            hashSet.add(sourceName);
            map.put(sourceName, schemaArr[i]);
            arrayList.add(schemaArr[i]);
        }
        SchemaDependencies dependencies = schemaTypeSystemImpl.getDependencies();
        set.addAll(dependencies.computeTransitiveClosure(dependencies.getNamespacesTouched(hashSet)));
        List filesTouched = dependencies.getFilesTouched(set);
        StscState.get().setDependencies(new SchemaDependencies(dependencies, set));
        for (int i2 = 0; i2 < filesTouched.size(); i2++) {
            String str = (String) filesTouched.get(i2);
            if (((SchemaDocument.Schema) map.get(str)) == null) {
                try {
                    XmlObject xmlObjectDownloadDocument = StscImporter.DownloadTable.downloadDocument(StscState.get().getS4SLoader(), null, str);
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setErrorListener(StscState.get().getErrorListener());
                    if (!(xmlObjectDownloadDocument instanceof SchemaDocument) || !xmlObjectDownloadDocument.validate(xmlOptions)) {
                        StscState.get().error("Referenced document is not a valid schema, URL = " + str, 56, (XmlObject) null);
                    } else {
                        arrayList.add(((SchemaDocument) xmlObjectDownloadDocument).getSchema());
                    }
                } catch (XmlException e) {
                    StscState.get().error("exception.loading.url", new Object[]{"XmlException", str, e.getMessage()}, (XmlObject) null);
                } catch (MalformedURLException e2) {
                    StscState.get().error("exception.loading.url", new Object[]{"MalformedURLException", str, e2.getMessage()}, (XmlObject) null);
                } catch (IOException e3) {
                    StscState.get().error("exception.loading.url", new Object[]{"IOException", str, e3.getMessage()}, (XmlObject) null);
                }
            }
        }
        return (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[arrayList.size()]);
    }

    public static boolean generateTypes(SchemaTypeSystem schemaTypeSystem, Filer filer, XmlOptions xmlOptions) {
        if ((schemaTypeSystem instanceof SchemaTypeSystemImpl) && ((SchemaTypeSystemImpl) schemaTypeSystem).isIncomplete()) {
            return false;
        }
        ArrayList<SchemaType> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(schemaTypeSystem.globalTypes()));
        arrayList.addAll(Arrays.asList(schemaTypeSystem.documentTypes()));
        arrayList.addAll(Arrays.asList(schemaTypeSystem.attributeTypes()));
        boolean z = true;
        for (SchemaType schemaType : arrayList) {
            if (!schemaType.isBuiltinType() && schemaType.getFullJavaName() != null) {
                Writer writerCreateSourceFile = null;
                try {
                    try {
                        writerCreateSourceFile = filer.createSourceFile(schemaType.getFullJavaName());
                        SchemaTypeCodePrinter.printType(writerCreateSourceFile, schemaType, xmlOptions);
                        if (writerCreateSourceFile != null) {
                            try {
                                writerCreateSourceFile.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("IO Error " + e);
                        if (writerCreateSourceFile != null) {
                            try {
                                writerCreateSourceFile.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z = false;
                    }
                    try {
                        try {
                            writerCreateSourceFile = filer.createSourceFile(schemaType.getFullJavaImplName());
                            SchemaTypeCodePrinter.printTypeImpl(writerCreateSourceFile, schemaType, xmlOptions);
                            if (writerCreateSourceFile != null) {
                                try {
                                    writerCreateSourceFile.close();
                                } catch (IOException unused3) {
                                }
                            }
                        } catch (IOException e2) {
                            System.err.println("IO Error " + e2);
                            if (writerCreateSourceFile != null) {
                                try {
                                    writerCreateSourceFile.close();
                                } catch (IOException unused4) {
                                }
                            }
                            z = false;
                        }
                    } catch (Throwable th) {
                        if (writerCreateSourceFile != null) {
                            try {
                                writerCreateSourceFile.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (writerCreateSourceFile != null) {
                        try {
                            writerCreateSourceFile.close();
                        } catch (IOException unused6) {
                        }
                    }
                    throw th2;
                }
            }
        }
        return z;
    }
}
