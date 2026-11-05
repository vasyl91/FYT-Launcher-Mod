package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "3.18")
public class SpecialPropertySet extends MutablePropertySet {
    public SpecialPropertySet() {
    }

    public SpecialPropertySet(PropertySet propertySet) throws UnexpectedPropertySetTypeException {
        super(propertySet);
    }

    SpecialPropertySet(InputStream inputStream) throws MarkUnsupportedException, NoPropertySetStreamException, IOException {
        super(inputStream);
    }
}
