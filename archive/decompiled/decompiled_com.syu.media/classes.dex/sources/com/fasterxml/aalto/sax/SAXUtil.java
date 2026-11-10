package com.fasterxml.aalto.sax;

import java.util.HashMap;
import org.xml.sax.SAXNotRecognizedException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class SAXUtil {
    static final HashMap<String, SAXFeature> sStdFeatures;
    static final HashMap<String, SAXProperty> sStdProperties;

    static {
        SAXFeature[] sAXFeatureArrValues = SAXFeature.values();
        sStdFeatures = new HashMap<>(sAXFeatureArrValues.length);
        for (SAXFeature sAXFeature : sAXFeatureArrValues) {
            sStdFeatures.put(sAXFeature.getSuffix(), sAXFeature);
        }
        SAXProperty[] sAXPropertyArrValues = SAXProperty.values();
        sStdProperties = new HashMap<>(sAXPropertyArrValues.length);
        for (SAXProperty sAXProperty : sAXPropertyArrValues) {
            sStdProperties.put(sAXProperty.getSuffix(), sAXProperty);
        }
    }

    private SAXUtil() {
    }

    public static SAXFeature findStdFeature(String str) {
        if (!str.startsWith(SAXFeature.STD_FEATURE_PREFIX)) {
            return null;
        }
        return sStdFeatures.get(str.substring(28));
    }

    public static SAXProperty findStdProperty(String str) {
        if (!str.startsWith(SAXProperty.STD_PROPERTY_PREFIX)) {
            return null;
        }
        return sStdProperties.get(str.substring(30));
    }

    /* JADX INFO: renamed from: com.fasterxml.aalto.sax.SAXUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$aalto$sax$SAXFeature;

        static {
            int[] iArr = new int[SAXFeature.values().length];
            $SwitchMap$com$fasterxml$aalto$sax$SAXFeature = iArr;
            try {
                iArr[SAXFeature.EXTERNAL_GENERAL_ENTITIES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.EXTERNAL_PARAMETER_ENTITIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.IS_STANDALONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.LEXICAL_HANDLER_PARAMETER_ENTITIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.NAMESPACES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.NAMESPACE_PREFIXES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.RESOLVE_DTD_URIS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.STRING_INTERNING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.UNICODE_NORMALIZATION_CHECKING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.USE_ATTRIBUTES2.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.USE_LOCATOR2.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.USE_ENTITY_RESOLVER2.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.VALIDATION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.XMLNS_URIS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.XML_1_1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static Boolean getFixedStdFeatureValue(SAXFeature sAXFeature) {
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$aalto$sax$SAXFeature[sAXFeature.ordinal()]) {
            case 1:
                return Boolean.FALSE;
            case 2:
                return Boolean.FALSE;
            case 3:
            default:
                return null;
            case 4:
                return Boolean.TRUE;
            case 5:
                return Boolean.TRUE;
            case 6:
                return Boolean.FALSE;
            case 7:
                return Boolean.FALSE;
            case 8:
                return Boolean.TRUE;
            case 9:
                return Boolean.FALSE;
            case 10:
            case 11:
            case 12:
                return Boolean.TRUE;
            case 13:
                return Boolean.FALSE;
            case 14:
                return Boolean.TRUE;
            case 15:
                return Boolean.FALSE;
        }
    }

    public static void reportUnknownFeature(String str) throws SAXNotRecognizedException {
        throw new SAXNotRecognizedException("Feature '" + str + "' not recognized");
    }

    public static void reportUnknownProperty(String str) throws SAXNotRecognizedException {
        throw new SAXNotRecognizedException("Property '" + str + "' not recognized");
    }
}
