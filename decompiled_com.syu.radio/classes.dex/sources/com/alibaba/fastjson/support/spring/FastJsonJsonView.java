package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FastJsonJsonView {
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final Charset UTF8 = null;
    private Charset charset;
    private boolean disableCaching;
    private boolean extractValueFromSingleKeyModel;
    private Set<String> renderedAttributes;
    private SerializerFeature[] serializerFeatures;
    private boolean updateContentLength;

    public FastJsonJsonView() {
        throw new Error("Unresolved compilation problems: \n\tThe import org.springframework cannot be resolved\n\tThe import org.springframework cannot be resolved\n\tThe import org.springframework cannot be resolved\n\tThe import javax.servlet cannot be resolved\n\tThe import javax.servlet cannot be resolved\n\tAbstractView cannot be resolved to a type\n\tThe method setContentType(String) is undefined for the type FastJsonJsonView\n\tThe method setExposePathVariables(boolean) is undefined for the type FastJsonJsonView\n\tHttpServletRequest cannot be resolved to a type\n\tHttpServletResponse cannot be resolved to a type\n\tThe method createTemporaryOutputStream() is undefined for the type FastJsonJsonView\n\tHttpServletRequest cannot be resolved to a type\n\tHttpServletResponse cannot be resolved to a type\n\tCollectionUtils cannot be resolved\n\tBindingResult cannot be resolved to a type\n");
    }

    public void setRenderedAttributes(Set<String> set) {
        throw new Error("Unresolved compilation problem: \n");
    }

    @Deprecated
    public void setSerializerFeature(SerializerFeature... serializerFeatureArr) {
        throw new Error("Unresolved compilation problem: \n");
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

    public boolean isExtractValueFromSingleKeyModel() {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setExtractValueFromSingleKeyModel(boolean z) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        throw new Error("Unresolved compilation problems: \n\tHttpServletRequest cannot be resolved to a type\n\tHttpServletResponse cannot be resolved to a type\n\tThe method createTemporaryOutputStream() is undefined for the type FastJsonJsonView\n");
    }

    protected void prepareResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        throw new Error("Unresolved compilation problems: \n\tHttpServletRequest cannot be resolved to a type\n\tHttpServletResponse cannot be resolved to a type\n");
    }

    public void setDisableCaching(boolean z) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public void setUpdateContentLength(boolean z) {
        throw new Error("Unresolved compilation problem: \n");
    }

    protected Object filterModel(Map<String, Object> map) {
        throw new Error("Unresolved compilation problems: \n\tCollectionUtils cannot be resolved\n\tBindingResult cannot be resolved to a type\n");
    }
}
