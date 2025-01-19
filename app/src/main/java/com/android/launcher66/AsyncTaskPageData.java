package com.android.launcher66;

import android.graphics.Bitmap;
import java.util.ArrayList;

class AsyncTaskPageData {
    AsyncTaskCallback doInBackgroundCallback;
    ArrayList<Bitmap> generatedImages = new ArrayList<>();
    ArrayList<Object> items;
    int maxImageHeight;
    int maxImageWidth;
    int page;
    AsyncTaskCallback postExecuteCallback;
    ArrayList<Bitmap> sourceImages;
    WidgetPreviewLoader widgetPreviewLoader;

    enum Type {
        LoadWidgetPreviewData;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] valuesCustom = values();
            int length = valuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(valuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    AsyncTaskPageData(int p, ArrayList<Object> l, int cw, int ch, AsyncTaskCallback bgR, AsyncTaskCallback postR, WidgetPreviewLoader w) {
        this.page = p;
        this.items = l;
        this.maxImageWidth = cw;
        this.maxImageHeight = ch;
        this.doInBackgroundCallback = bgR;
        this.postExecuteCallback = postR;
        this.widgetPreviewLoader = w;
    }

    void cleanup(boolean cancelled) {
        if (this.generatedImages != null) {
            if (cancelled) {
                for (int i = 0; i < this.generatedImages.size(); i++) {
                    this.widgetPreviewLoader.recycleBitmap(this.items.get(i), this.generatedImages.get(i));
                }
            }
            this.generatedImages.clear();
        }
    }
}
