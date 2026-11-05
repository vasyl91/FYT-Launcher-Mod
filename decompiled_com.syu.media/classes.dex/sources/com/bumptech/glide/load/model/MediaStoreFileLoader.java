package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context context;

    public MediaStoreFileLoader(Context context) {
        this.context = context;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<File> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new FilePathFetcher(this.context, uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return MediaStoreUtil.isMediaStoreUri(uri);
    }

    private static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] PROJECTION = {"_data"};
        private final Context context;
        private final Uri uri;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        FilePathFetcher(Context context, Uri uri) {
            this.context = context;
            this.uri = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor cursorQuery = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            String string = null;
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (TextUtils.isEmpty(string)) {
                dataCallback.onLoadFailed(new FileNotFoundException("Failed to find file path for: " + this.uri));
            } else {
                dataCallback.onDataReady(new File(string));
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.context);
        }
    }
}
