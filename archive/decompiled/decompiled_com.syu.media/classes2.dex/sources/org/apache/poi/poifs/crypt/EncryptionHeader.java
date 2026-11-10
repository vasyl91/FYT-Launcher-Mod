package org.apache.poi.poifs.crypt;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class EncryptionHeader implements Cloneable {
    private int blockSize;
    private ChainingMode chainingMode;
    private CipherAlgorithm cipherAlgorithm;
    private String cspName;
    private int flags;
    private HashAlgorithm hashAlgorithm;
    private int keyBits;
    private byte[] keySalt;
    private CipherProvider providerType;
    private int sizeExtra;
    public static final int ALGORITHM_RC4 = CipherAlgorithm.rc4.ecmaId;
    public static final int ALGORITHM_AES_128 = CipherAlgorithm.aes128.ecmaId;
    public static final int ALGORITHM_AES_192 = CipherAlgorithm.aes192.ecmaId;
    public static final int ALGORITHM_AES_256 = CipherAlgorithm.aes256.ecmaId;
    public static final int HASH_NONE = HashAlgorithm.none.ecmaId;
    public static final int HASH_SHA1 = HashAlgorithm.sha1.ecmaId;
    public static final int HASH_SHA256 = HashAlgorithm.sha256.ecmaId;
    public static final int HASH_SHA384 = HashAlgorithm.sha384.ecmaId;
    public static final int HASH_SHA512 = HashAlgorithm.sha512.ecmaId;
    public static final int PROVIDER_RC4 = CipherProvider.rc4.ecmaId;
    public static final int PROVIDER_AES = CipherProvider.aes.ecmaId;
    public static final int MODE_ECB = ChainingMode.ecb.ecmaId;
    public static final int MODE_CBC = ChainingMode.cbc.ecmaId;
    public static final int MODE_CFB = ChainingMode.cfb.ecmaId;

    protected EncryptionHeader() {
    }

    public ChainingMode getChainingMode() {
        return this.chainingMode;
    }

    protected void setChainingMode(ChainingMode chainingMode) {
        this.chainingMode = chainingMode;
    }

    public int getFlags() {
        return this.flags;
    }

    protected void setFlags(int i) {
        this.flags = i;
    }

    public int getSizeExtra() {
        return this.sizeExtra;
    }

    protected void setSizeExtra(int i) {
        this.sizeExtra = i;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    protected void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
        if (cipherAlgorithm.allowedKeySize.length == 1) {
            setKeySize(cipherAlgorithm.defaultKeySize);
        }
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    @Removal(version = "3.18")
    public HashAlgorithm getHashAlgorithmEx() {
        return this.hashAlgorithm;
    }

    protected void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public int getKeySize() {
        return this.keyBits;
    }

    protected void setKeySize(int i) {
        this.keyBits = i;
        for (int i2 : getCipherAlgorithm().allowedKeySize) {
            if (i2 == i) {
                return;
            }
        }
        throw new EncryptedDocumentException("KeySize " + i + " not allowed for cipher " + getCipherAlgorithm());
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    protected void setBlockSize(int i) {
        this.blockSize = i;
    }

    public byte[] getKeySalt() {
        return this.keySalt;
    }

    protected void setKeySalt(byte[] bArr) {
        this.keySalt = bArr == null ? null : (byte[]) bArr.clone();
    }

    public CipherProvider getCipherProvider() {
        return this.providerType;
    }

    protected void setCipherProvider(CipherProvider cipherProvider) {
        this.providerType = cipherProvider;
    }

    public String getCspName() {
        return this.cspName;
    }

    protected void setCspName(String str) {
        this.cspName = str;
    }

    @Override // 
    public EncryptionHeader clone() throws CloneNotSupportedException {
        EncryptionHeader encryptionHeader = (EncryptionHeader) super.clone();
        byte[] bArr = this.keySalt;
        encryptionHeader.keySalt = bArr == null ? null : (byte[]) bArr.clone();
        return encryptionHeader;
    }
}
