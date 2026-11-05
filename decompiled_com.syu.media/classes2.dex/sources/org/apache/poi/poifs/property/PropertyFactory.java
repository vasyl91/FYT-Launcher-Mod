package org.apache.poi.poifs.property;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.poifs.storage.ListManagedBlock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class PropertyFactory {
    private PropertyFactory() {
    }

    static List<Property> convertToProperties(ListManagedBlock[] listManagedBlockArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (ListManagedBlock listManagedBlock : listManagedBlockArr) {
            convertToProperties(listManagedBlock.getData(), arrayList);
        }
        return arrayList;
    }

    static void convertToProperties(byte[] bArr, List<Property> list) throws IOException {
        int length = bArr.length / 128;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            byte b = bArr[i + 66];
            if (b == 1) {
                list.add(new DirectoryProperty(list.size(), bArr, i));
            } else if (b == 2) {
                list.add(new DocumentProperty(list.size(), bArr, i));
            } else if (b == 5) {
                list.add(new RootProperty(list.size(), bArr, i));
            } else {
                list.add(null);
            }
            i += 128;
        }
    }
}
