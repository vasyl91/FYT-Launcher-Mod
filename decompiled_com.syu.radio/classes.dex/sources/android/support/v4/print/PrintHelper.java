package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    PrintHelperVersionImpl mImpl;

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap);

        void printBitmap(String str, Uri uri) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    private static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        private PrintHelperStubImpl() {
            this.mScaleMode = 2;
            this.mColorMode = 2;
            this.mOrientation = 1;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int scaleMode) {
            this.mScaleMode = scaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.mColorMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int colorMode) {
            this.mColorMode = colorMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int orientation) {
            this.mOrientation = orientation;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            return this.mOrientation;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.mScaleMode;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String jobName, Bitmap bitmap) {
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String jobName, Uri imageFile) {
        }
    }

    private static final class PrintHelperKitkatImpl implements PrintHelperVersionImpl {
        private final PrintHelperKitkat mPrintHelper;

        PrintHelperKitkatImpl(Context context) {
            this.mPrintHelper = new PrintHelperKitkat(context);
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int scaleMode) {
            this.mPrintHelper.setScaleMode(scaleMode);
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.mPrintHelper.getScaleMode();
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int colorMode) {
            this.mPrintHelper.setColorMode(colorMode);
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.mPrintHelper.getColorMode();
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int orientation) {
            this.mPrintHelper.setOrientation(orientation);
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            return this.mPrintHelper.getOrientation();
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String jobName, Bitmap bitmap) {
            this.mPrintHelper.printBitmap(jobName, bitmap);
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String jobName, Uri imageFile) throws FileNotFoundException {
            this.mPrintHelper.printBitmap(jobName, imageFile);
        }
    }

    public PrintHelper(Context context) {
        if (systemSupportsPrint()) {
            this.mImpl = new PrintHelperKitkatImpl(context);
        } else {
            this.mImpl = new PrintHelperStubImpl();
        }
    }

    public void setScaleMode(int scaleMode) {
        this.mImpl.setScaleMode(scaleMode);
    }

    public int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public void setColorMode(int colorMode) {
        this.mImpl.setColorMode(colorMode);
    }

    public int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public void setOrientation(int orientation) {
        this.mImpl.setOrientation(orientation);
    }

    public int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public void printBitmap(String jobName, Bitmap bitmap) {
        this.mImpl.printBitmap(jobName, bitmap);
    }

    public void printBitmap(String jobName, Uri imageFile) throws FileNotFoundException {
        this.mImpl.printBitmap(jobName, imageFile);
    }
}
