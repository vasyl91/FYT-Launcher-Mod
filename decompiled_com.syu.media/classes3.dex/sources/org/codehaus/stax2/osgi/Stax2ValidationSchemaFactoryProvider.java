package org.codehaus.stax2.osgi;

import org.codehaus.stax2.validation.XMLValidationSchemaFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface Stax2ValidationSchemaFactoryProvider {
    public static final String OSGI_SVC_PROP_IMPL_NAME = "org.codehaus.stax2.implName";
    public static final String OSGI_SVC_PROP_IMPL_VERSION = "org.codehaus.stax2.implVersion";
    public static final String OSGI_SVC_PROP_SCHEMA_TYPE = "org.codehaus.stax2.validation.schemaType";

    XMLValidationSchemaFactory createValidationSchemaFactory();

    String getSchemaType();
}
