package com.fasterxml.aalto.impl;

import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public abstract class CommonConfig {
    protected static final String IMPL_NAME = "aalto";
    protected static final String IMPL_VERSION = "0.9";
    static final int PROP_IMPL_NAME = 1;
    static final int PROP_IMPL_VERSION = 2;
    static final int PROP_SUPPORTS_XML11 = 3;
    static final int PROP_SUPPORTS_XMLID = 4;
    static final HashMap<String, Integer> sStdProperties;
    protected int _flagMods;
    protected int _flags;

    public abstract String getActualEncoding();

    public abstract String getExternalEncoding();

    public abstract boolean isXml11();

    static {
        HashMap<String, Integer> map = new HashMap<>(16);
        sStdProperties = map;
        map.put("org.codehaus.stax2.implName", 1);
        map.put("org.codehaus.stax2.implVersion", 2);
        map.put("org.codehaus.stax2.supportsXml11", 3);
        map.put("org.codehaus.stax2.supportXmlId", 4);
        map.put("http://java.sun.com/xml/stream/properties/implementation-name", 1);
    }

    protected CommonConfig(int i, int i2) {
        this._flags = i;
        this._flagMods = i2;
    }

    public Object getProperty(String str, boolean z) {
        Integer num = sStdProperties.get(str);
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                return IMPL_NAME;
            }
            if (iIntValue == 2) {
                return IMPL_VERSION;
            }
            if (iIntValue == 3) {
                return Boolean.FALSE;
            }
            if (iIntValue == 4) {
                return Boolean.FALSE;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Unrecognized property '" + str + "'");
        }
        return null;
    }

    public boolean isPropertySupported(String str) {
        return sStdProperties.containsKey(str);
    }

    public boolean setProperty(String str, Object obj) {
        if (sStdProperties.get(str) != null) {
            return false;
        }
        throw new IllegalArgumentException("Unrecognized property '" + str + "'");
    }

    protected final boolean hasFlag(int i) {
        return (i & this._flags) != 0;
    }

    protected final boolean hasExplicitFlag(int i) {
        return hasFlag(i) && hasFlagBeenModified(i);
    }

    protected final void setFlag(int i, boolean z) {
        if (z) {
            this._flags |= i;
        } else {
            this._flags &= ~i;
        }
        this._flagMods = i | this._flagMods;
    }

    protected final boolean hasFlagBeenModified(int i) {
        return (i & this._flagMods) != 0;
    }
}
