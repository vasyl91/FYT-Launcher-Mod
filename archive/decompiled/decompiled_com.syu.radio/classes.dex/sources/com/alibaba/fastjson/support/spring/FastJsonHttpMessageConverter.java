package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    public static final Charset UTF8 = null;
    private Charset charset;
    private SerializerFeature[] features;

    public FastJsonHttpMessageConverter() {
        throw new Error("Unresolved compilation problems: \n\tThe import org.springframework cannot be resolved\n\tThe import org.springframework cannot be resolved\n\tThe import org.springframework cannot be resolved\n\tThe import org.springframework cannot be resolved\n\tThe import org.springframework cannot be resolved\n\tThe import org.springframework cannot be resolved\n\tAbstractHttpMessageConverter cannot be resolved to a type\n\tMediaType cannot be resolved to a type\n\tMediaType cannot be resolved to a type\n\tThe method supports(Class<?>) of type FastJsonHttpMessageConverter must override or implement a supertype method\n\tHttpInputMessage cannot be resolved to a type\n\tHttpMessageNotReadableException cannot be resolved to a type\n\tHttpOutputMessage cannot be resolved to a type\n\tHttpMessageNotWritableException cannot be resolved to a type\n");
    }

    protected boolean supports(Class<?> cls) {
        throw new Error("Unresolved compilation problem: \n\tThe method supports(Class<?>) of type FastJsonHttpMessageConverter must override or implement a supertype method\n");
    }

    public Charset getCharset() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setCharset(Charset charset) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public SerializerFeature[] getFeatures() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws HttpMessageNotReadableException, IOException {
        throw new Error("Unresolved compilation problems: \n\tHttpInputMessage cannot be resolved to a type\n\tHttpMessageNotReadableException cannot be resolved to a type\n");
    }

    protected void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws HttpMessageNotWritableException, IOException {
        throw new Error("Unresolved compilation problems: \n\tHttpOutputMessage cannot be resolved to a type\n\tHttpMessageNotWritableException cannot be resolved to a type\n");
    }
}
