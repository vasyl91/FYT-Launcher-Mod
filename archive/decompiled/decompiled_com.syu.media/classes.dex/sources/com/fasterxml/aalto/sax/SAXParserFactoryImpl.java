package com.fasterxml.aalto.sax;

import com.fasterxml.aalto.stax.InputFactoryImpl;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class SAXParserFactoryImpl extends SAXParserFactory {
    final InputFactoryImpl mStaxFactory = new InputFactoryImpl();

    public static SAXParserFactory newInstance() {
        return new SAXParserFactoryImpl();
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        SAXFeature sAXFeatureFindStdFeature = SAXUtil.findStdFeature(str);
        if (sAXFeatureFindStdFeature != null) {
            Boolean fixedStdFeatureValue = SAXUtil.getFixedStdFeatureValue(sAXFeatureFindStdFeature);
            if (fixedStdFeatureValue != null) {
                return fixedStdFeatureValue.booleanValue();
            }
            if (AnonymousClass1.$SwitchMap$com$fasterxml$aalto$sax$SAXFeature[sAXFeatureFindStdFeature.ordinal()] == 1) {
                return true;
            }
        }
        SAXUtil.reportUnknownFeature(str);
        return false;
    }

    /* JADX INFO: renamed from: com.fasterxml.aalto.sax.SAXParserFactoryImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$aalto$sax$SAXFeature;

        static {
            int[] iArr = new int[SAXFeature.values().length];
            $SwitchMap$com$fasterxml$aalto$sax$SAXFeature = iArr;
            try {
                iArr[SAXFeature.IS_STANDALONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.EXTERNAL_GENERAL_ENTITIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$aalto$sax$SAXFeature[SAXFeature.EXTERNAL_PARAMETER_ENTITIES.ordinal()] = 3;
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

    @Override // javax.xml.parsers.SAXParserFactory
    public SAXParser newSAXParser() {
        return new SAXParserImpl(this.mStaxFactory);
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        SAXFeature sAXFeatureFindStdFeature = SAXUtil.findStdFeature(str);
        if (sAXFeatureFindStdFeature == null) {
            SAXUtil.reportUnknownFeature(str);
            return;
        }
        boolean z2 = false;
        switch (AnonymousClass1.$SwitchMap$com$fasterxml$aalto$sax$SAXFeature[sAXFeatureFindStdFeature.ordinal()]) {
            case 1:
            case 4:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
                z2 = true;
                break;
            case 2:
            case 3:
            case 6:
            case 13:
            case 15:
                z2 = !z;
                break;
            case 5:
                z2 = z;
                break;
        }
        if (!z2) {
            throw new SAXNotSupportedException("Setting std feature " + sAXFeatureFindStdFeature + " to " + z + " not supported");
        }
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public void setNamespaceAware(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Non-namespace-aware mode not implemented");
        }
        super.setNamespaceAware(z);
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public void setValidating(boolean z) {
        if (z) {
            throw new IllegalArgumentException("Validating mode not implemented");
        }
        super.setValidating(z);
    }
}
