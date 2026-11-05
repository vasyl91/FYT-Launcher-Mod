package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class RemoteInputCompatApi20 {
    RemoteInputCompatApi20() {
    }

    static RemoteInputCompatBase.RemoteInput[] toCompat(android.app.RemoteInput[] srcArray, RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (srcArray == null) {
            return null;
        }
        RemoteInputCompatBase.RemoteInput[] result = factory.newArray(srcArray.length);
        for (int i = 0; i < srcArray.length; i++) {
            android.app.RemoteInput src = srcArray[i];
            result[i] = factory.build(src.getResultKey(), src.getLabel(), src.getChoices(), src.getAllowFreeFormInput(), src.getExtras());
        }
        return result;
    }

    static android.app.RemoteInput[] fromCompat(RemoteInputCompatBase.RemoteInput[] srcArray) {
        if (srcArray == null) {
            return null;
        }
        android.app.RemoteInput[] result = new android.app.RemoteInput[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            RemoteInputCompatBase.RemoteInput src = srcArray[i];
            result[i] = new android.app.RemoteInput.Builder(src.getResultKey()).setLabel(src.getLabel()).setChoices(src.getChoices()).setAllowFreeFormInput(src.getAllowFreeFormInput()).addExtras(src.getExtras()).build();
        }
        return result;
    }

    static Bundle getResultsFromIntent(Intent intent) {
        return android.app.RemoteInput.getResultsFromIntent(intent);
    }

    static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] remoteInputs, Intent intent, Bundle results) {
        android.app.RemoteInput.addResultsToIntent(fromCompat(remoteInputs), intent, results);
    }
}
