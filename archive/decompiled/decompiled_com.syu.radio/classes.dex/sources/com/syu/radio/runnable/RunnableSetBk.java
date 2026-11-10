package com.syu.radio.runnable;

import android.util.Log;
import android.widget.ImageView;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.FuncUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RunnableSetBk implements Runnable {
    ImageView imgView;
    String strFreq;

    public RunnableSetBk(String strFreq, ImageView imgView) {
        this.strFreq = strFreq;
        this.imgView = imgView;
    }

    public class RunnableSetImgView implements Runnable {
        ImageView imgView;
        String path;
        String strFreq;

        public RunnableSetImgView(String path, String strFreq, ImageView imgView) {
            this.path = path;
            this.strFreq = strFreq;
            this.imgView = imgView;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.imgView != null) {
                Log.d("gdy5", " 01 RunnableSetBk strFreq = " + this.strFreq);
                if (!FuncUtils.isFileExist(this.path)) {
                    Log.d("gdy5", " 02 RunnableSetBk strFreq = " + this.strFreq);
                    String pathDiy = "/mnt/sdcard/RadioPC/" + this.strFreq + ".png";
                    if (FuncUtils.isFileExist(pathDiy)) {
                        Log.d("gdy5", " 03 RunnableSetBk pathDiy = " + pathDiy);
                        ImageLoader.getInstance().displayImage("file://" + pathDiy, new ImageViewAware(this.imgView), Act_Radio.optionsRadioBk);
                        return;
                    } else {
                        this.imgView.setImageDrawable(null);
                        return;
                    }
                }
                ImageLoader.getInstance().displayImage("file://" + this.path, new ImageViewAware(this.imgView), Act_Radio.optionsRadioBk);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.imgView != null) {
            String path = App_Radio.getInstance().mRadioFreqBkManager.queryFreqBk(this.strFreq);
            Main.postRunnable_Ui(false, new RunnableSetImgView(path, this.strFreq, this.imgView));
        }
    }
}
