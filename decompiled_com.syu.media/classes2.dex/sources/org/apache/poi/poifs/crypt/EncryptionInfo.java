package org.apache.poi.poifs.crypt;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class EncryptionInfo implements Cloneable {
    private Decryptor decryptor;
    private final int encryptionFlags;
    private final EncryptionMode encryptionMode;
    private Encryptor encryptor;
    private EncryptionHeader header;
    private EncryptionVerifier verifier;
    private final int versionMajor;
    private final int versionMinor;
    public static final BitField flagCryptoAPI = BitFieldFactory.getInstance(4);
    public static final BitField flagDocProps = BitFieldFactory.getInstance(8);
    public static final BitField flagExternal = BitFieldFactory.getInstance(16);
    public static final BitField flagAES = BitFieldFactory.getInstance(32);

    public EncryptionInfo(POIFSFileSystem pOIFSFileSystem) throws IOException {
        this(pOIFSFileSystem.getRoot());
    }

    public EncryptionInfo(OPOIFSFileSystem oPOIFSFileSystem) throws IOException {
        this(oPOIFSFileSystem.getRoot());
    }

    public EncryptionInfo(NPOIFSFileSystem nPOIFSFileSystem) throws IOException {
        this(nPOIFSFileSystem.getRoot());
    }

    public EncryptionInfo(DirectoryNode directoryNode) throws IOException {
        this(directoryNode.createDocumentInputStream("EncryptionInfo"), null);
    }

    public EncryptionInfo(LittleEndianInput littleEndianInput, EncryptionMode encryptionMode) throws IOException {
        if (encryptionMode == EncryptionMode.xor) {
            this.versionMajor = EncryptionMode.xor.versionMajor;
            this.versionMinor = EncryptionMode.xor.versionMinor;
        } else {
            this.versionMajor = littleEndianInput.readUShort();
            this.versionMinor = littleEndianInput.readUShort();
        }
        if (this.versionMajor == EncryptionMode.xor.versionMajor && this.versionMinor == EncryptionMode.xor.versionMinor) {
            this.encryptionMode = EncryptionMode.xor;
            this.encryptionFlags = -1;
        } else if (this.versionMajor == EncryptionMode.binaryRC4.versionMajor && this.versionMinor == EncryptionMode.binaryRC4.versionMinor) {
            this.encryptionMode = EncryptionMode.binaryRC4;
            this.encryptionFlags = -1;
        } else {
            int i = this.versionMajor;
            if (2 <= i && i <= 4 && this.versionMinor == 2) {
                int i2 = littleEndianInput.readInt();
                this.encryptionFlags = i2;
                this.encryptionMode = (encryptionMode == EncryptionMode.cryptoAPI || !flagAES.isSet(i2)) ? EncryptionMode.cryptoAPI : EncryptionMode.standard;
            } else if (i == EncryptionMode.agile.versionMajor && this.versionMinor == EncryptionMode.agile.versionMinor) {
                this.encryptionMode = EncryptionMode.agile;
                this.encryptionFlags = littleEndianInput.readInt();
            } else {
                int i3 = littleEndianInput.readInt();
                this.encryptionFlags = i3;
                throw new EncryptedDocumentException("Unknown encryption: version major: " + this.versionMajor + " / version minor: " + this.versionMinor + " / fCrypto: " + flagCryptoAPI.isSet(i3) + " / fExternal: " + flagExternal.isSet(i3) + " / fDocProps: " + flagDocProps.isSet(i3) + " / fAES: " + flagAES.isSet(i3));
            }
        }
        try {
            getBuilder(this.encryptionMode).initialize(this, littleEndianInput);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public EncryptionInfo(EncryptionMode encryptionMode) {
        this(encryptionMode, null, null, -1, -1, null);
    }

    public EncryptionInfo(EncryptionMode encryptionMode, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i, int i2, ChainingMode chainingMode) {
        this.encryptionMode = encryptionMode;
        this.versionMajor = encryptionMode.versionMajor;
        this.versionMinor = encryptionMode.versionMinor;
        this.encryptionFlags = encryptionMode.encryptionFlags;
        try {
            getBuilder(encryptionMode).initialize(this, cipherAlgorithm, hashAlgorithm, i, i2, chainingMode);
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    protected static EncryptionInfoBuilder getBuilder(EncryptionMode encryptionMode) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (EncryptionInfoBuilder) Thread.currentThread().getContextClassLoader().loadClass(encryptionMode.builder).newInstance();
    }

    public int getVersionMajor() {
        return this.versionMajor;
    }

    public int getVersionMinor() {
        return this.versionMinor;
    }

    public int getEncryptionFlags() {
        return this.encryptionFlags;
    }

    public EncryptionHeader getHeader() {
        return this.header;
    }

    public EncryptionVerifier getVerifier() {
        return this.verifier;
    }

    public Decryptor getDecryptor() {
        return this.decryptor;
    }

    public Encryptor getEncryptor() {
        return this.encryptor;
    }

    public void setHeader(EncryptionHeader encryptionHeader) {
        this.header = encryptionHeader;
    }

    public void setVerifier(EncryptionVerifier encryptionVerifier) {
        this.verifier = encryptionVerifier;
    }

    public void setDecryptor(Decryptor decryptor) {
        this.decryptor = decryptor;
    }

    public void setEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    public EncryptionMode getEncryptionMode() {
        return this.encryptionMode;
    }

    public boolean isDocPropsEncrypted() {
        return !flagDocProps.isSet(getEncryptionFlags());
    }

    public EncryptionInfo clone() throws CloneNotSupportedException {
        EncryptionInfo encryptionInfo = (EncryptionInfo) super.clone();
        encryptionInfo.header = this.header.clone();
        encryptionInfo.verifier = this.verifier.clone();
        Decryptor decryptorMo1569clone = this.decryptor.clone();
        encryptionInfo.decryptor = decryptorMo1569clone;
        decryptorMo1569clone.setEncryptionInfo(encryptionInfo);
        Encryptor encryptorMo1573clone = this.encryptor.clone();
        encryptionInfo.encryptor = encryptorMo1573clone;
        encryptorMo1573clone.setEncryptionInfo(encryptionInfo);
        return encryptionInfo;
    }
}
