package org.codehaus.stax2;

import org.codehaus.stax2.validation.DTDValidationSchema;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public interface DTDInfo {
    String getDTDInternalSubset();

    String getDTDPublicId();

    String getDTDRootName();

    String getDTDSystemId();

    Object getProcessedDTD();

    DTDValidationSchema getProcessedDTDSchema();
}
