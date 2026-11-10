package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgClass;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STCryptProv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class XWPFSettings extends POIXMLDocumentPart {
    private CTSettings ctSettings;

    public XWPFSettings(PackagePart packagePart) throws IOException {
        super(packagePart);
    }

    public XWPFSettings() {
        this.ctSettings = CTSettings.Factory.newInstance();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void onDocumentRead() throws IOException {
        super.onDocumentRead();
        readFrom(getPackagePart().getInputStream());
    }

    public long getZoomPercent() {
        CTZoom zoom;
        if (!this.ctSettings.isSetZoom()) {
            zoom = this.ctSettings.addNewZoom();
        } else {
            zoom = this.ctSettings.getZoom();
        }
        BigInteger percent = zoom.getPercent();
        if (percent == null) {
            return 100L;
        }
        return percent.longValue();
    }

    public void setZoomPercent(long j) {
        if (!this.ctSettings.isSetZoom()) {
            this.ctSettings.addNewZoom();
        }
        this.ctSettings.getZoom().setPercent(BigInteger.valueOf(j));
    }

    public boolean isEnforcedWith() {
        CTDocProtect documentProtection = this.ctSettings.getDocumentProtection();
        if (documentProtection == null) {
            return false;
        }
        return documentProtection.getEnforcement().equals(STOnOff.X_1);
    }

    public boolean isEnforcedWith(STDocProtect.Enum r5) {
        CTDocProtect documentProtection = this.ctSettings.getDocumentProtection();
        return documentProtection != null && documentProtection.getEnforcement().equals(STOnOff.X_1) && documentProtection.getEdit().equals(r5);
    }

    public void setEnforcementEditValue(STDocProtect.Enum r3) {
        safeGetDocumentProtection().setEnforcement(STOnOff.X_1);
        safeGetDocumentProtection().setEdit(r3);
    }

    public void setEnforcementEditValue(STDocProtect.Enum r5, String str, HashAlgorithm hashAlgorithm) {
        STCryptProv.Enum r6;
        int i;
        safeGetDocumentProtection().setEnforcement(STOnOff.X_1);
        safeGetDocumentProtection().setEdit(r5);
        if (str == null) {
            if (safeGetDocumentProtection().isSetCryptProviderType()) {
                safeGetDocumentProtection().unsetCryptProviderType();
            }
            if (safeGetDocumentProtection().isSetCryptAlgorithmClass()) {
                safeGetDocumentProtection().unsetCryptAlgorithmClass();
            }
            if (safeGetDocumentProtection().isSetCryptAlgorithmType()) {
                safeGetDocumentProtection().unsetCryptAlgorithmType();
            }
            if (safeGetDocumentProtection().isSetCryptAlgorithmSid()) {
                safeGetDocumentProtection().unsetCryptAlgorithmSid();
            }
            if (safeGetDocumentProtection().isSetSalt()) {
                safeGetDocumentProtection().unsetSalt();
            }
            if (safeGetDocumentProtection().isSetCryptSpinCount()) {
                safeGetDocumentProtection().unsetCryptSpinCount();
            }
            if (safeGetDocumentProtection().isSetHash()) {
                safeGetDocumentProtection().unsetHash();
                return;
            }
            return;
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[hashAlgorithm.ordinal()]) {
            case 1:
                r6 = STCryptProv.RSA_FULL;
                i = 1;
                break;
            case 2:
                r6 = STCryptProv.RSA_FULL;
                i = 2;
                break;
            case 3:
                r6 = STCryptProv.RSA_FULL;
                i = 3;
                break;
            case 4:
                r6 = STCryptProv.RSA_FULL;
                i = 4;
                break;
            case 5:
                r6 = STCryptProv.RSA_AES;
                i = 12;
                break;
            case 6:
                r6 = STCryptProv.RSA_AES;
                i = 13;
                break;
            case 7:
                r6 = STCryptProv.RSA_AES;
                i = 14;
                break;
            default:
                throw new EncryptedDocumentException("Hash algorithm '" + hashAlgorithm + "' is not supported for document write protection.");
        }
        byte[] bArrGenerateSeed = new SecureRandom().generateSeed(16);
        byte[] bArrHashPassword = CryptoFunctions.hashPassword(CryptoFunctions.xorHashPasswordReversed(str), hashAlgorithm, bArrGenerateSeed, 100000, false);
        safeGetDocumentProtection().setSalt(bArrGenerateSeed);
        safeGetDocumentProtection().setHash(bArrHashPassword);
        safeGetDocumentProtection().setCryptSpinCount(BigInteger.valueOf(100000));
        safeGetDocumentProtection().setCryptAlgorithmType(STAlgType.TYPE_ANY);
        safeGetDocumentProtection().setCryptAlgorithmClass(STAlgClass.HASH);
        safeGetDocumentProtection().setCryptProviderType(r6);
        safeGetDocumentProtection().setCryptAlgorithmSid(BigInteger.valueOf(i));
    }

    /* JADX INFO: renamed from: org.apache.poi.xwpf.usermodel.XWPFSettings$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm;

        static {
            int[] iArr = new int[HashAlgorithm.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm = iArr;
            try {
                iArr[HashAlgorithm.md2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.md4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.md5.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha256.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha384.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha512.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public boolean validateProtectionPassword(String str) {
        HashAlgorithm hashAlgorithm;
        BigInteger cryptAlgorithmSid = safeGetDocumentProtection().getCryptAlgorithmSid();
        byte[] hash = safeGetDocumentProtection().getHash();
        byte[] salt = safeGetDocumentProtection().getSalt();
        BigInteger cryptSpinCount = safeGetDocumentProtection().getCryptSpinCount();
        if (cryptAlgorithmSid == null || hash == null || salt == null || cryptSpinCount == null) {
            return false;
        }
        int iIntValue = cryptAlgorithmSid.intValue();
        if (iIntValue == 1) {
            hashAlgorithm = HashAlgorithm.md2;
        } else if (iIntValue == 2) {
            hashAlgorithm = HashAlgorithm.md4;
        } else if (iIntValue == 3) {
            hashAlgorithm = HashAlgorithm.md5;
        } else if (iIntValue == 4) {
            hashAlgorithm = HashAlgorithm.sha1;
        } else {
            switch (iIntValue) {
                case 12:
                    hashAlgorithm = HashAlgorithm.sha256;
                    break;
                case 13:
                    hashAlgorithm = HashAlgorithm.sha384;
                    break;
                case 14:
                    hashAlgorithm = HashAlgorithm.sha512;
                    break;
                default:
                    return false;
            }
        }
        return Arrays.equals(hash, CryptoFunctions.hashPassword(CryptoFunctions.xorHashPasswordReversed(str), hashAlgorithm, salt, cryptSpinCount.intValue(), false));
    }

    public void removeEnforcement() {
        safeGetDocumentProtection().setEnforcement(STOnOff.X_0);
    }

    public void setUpdateFields() {
        CTOnOff cTOnOffNewInstance = CTOnOff.Factory.newInstance();
        cTOnOffNewInstance.setVal(STOnOff.TRUE);
        this.ctSettings.setUpdateFields(cTOnOffNewInstance);
    }

    boolean isUpdateFields() {
        return this.ctSettings.isSetUpdateFields() && this.ctSettings.getUpdateFields().getVal() == STOnOff.TRUE;
    }

    public boolean isTrackRevisions() {
        return this.ctSettings.isSetTrackRevisions();
    }

    public void setTrackRevisions(boolean z) {
        if (z) {
            if (this.ctSettings.isSetTrackRevisions()) {
                return;
            }
            this.ctSettings.addNewTrackRevisions();
        } else if (this.ctSettings.isSetTrackRevisions()) {
            this.ctSettings.unsetTrackRevisions();
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    protected void commit() throws IOException {
        if (this.ctSettings == null) {
            throw new IllegalStateException("Unable to write out settings that were never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTSettings.type.getName().getNamespaceURI(), "settings"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctSettings.save(outputStream, xmlOptions);
        outputStream.close();
    }

    private CTDocProtect safeGetDocumentProtection() {
        if (this.ctSettings.getDocumentProtection() == null) {
            this.ctSettings.setDocumentProtection(CTDocProtect.Factory.newInstance());
        }
        return this.ctSettings.getDocumentProtection();
    }

    private void readFrom(InputStream inputStream) {
        try {
            this.ctSettings = SettingsDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSettings();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
