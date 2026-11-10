package android.support.v4.app;

import android.os.Bundle;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class RemoteInputCompatBase {

    public static abstract class RemoteInput {

        public interface Factory {
            RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle);

            RemoteInput[] newArray(int i);
        }

        protected abstract boolean getAllowFreeFormInput();

        protected abstract CharSequence[] getChoices();

        protected abstract Bundle getExtras();

        protected abstract CharSequence getLabel();

        protected abstract String getResultKey();
    }

    RemoteInputCompatBase() {
    }
}
