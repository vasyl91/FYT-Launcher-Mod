package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class DirectResourceLoader<DataT> implements ModelLoader<Integer, DataT> {
    private final Context context;
    private final ResourceOpener<DataT> resourceOpener;

    private interface ResourceOpener<DataT> {
        void close(DataT datat) throws IOException;

        Class<DataT> getDataClass();

        DataT open(Resources.Theme theme, Resources resources, int i);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Integer num) {
        return true;
    }

    public static ModelLoaderFactory<Integer, InputStream> inputStreamFactory(Context context) {
        return new InputStreamFactory(context);
    }

    public static ModelLoaderFactory<Integer, AssetFileDescriptor> assetFileDescriptorFactory(Context context) {
        return new AssetFileDescriptorFactory(context);
    }

    public static ModelLoaderFactory<Integer, Drawable> drawableFactory(Context context) {
        return new DrawableFactory(context);
    }

    DirectResourceLoader(Context context, ResourceOpener<DataT> resourceOpener) {
        this.context = context.getApplicationContext();
        this.resourceOpener = resourceOpener;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<DataT> buildLoadData(Integer num, int i, int i2, Options options) {
        Resources resources;
        Resources.Theme theme = (Resources.Theme) options.get(ResourceDrawableDecoder.THEME);
        if (theme != null) {
            resources = theme.getResources();
        } else {
            resources = this.context.getResources();
        }
        return new ModelLoader.LoadData<>(new ObjectKey(num), new ResourceDataFetcher(theme, resources, this.resourceOpener, num.intValue()));
    }

    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor>, ResourceOpener<AssetFileDescriptor> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        AssetFileDescriptorFactory(Context context) {
            this.context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public AssetFileDescriptor open(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResourceFd(i);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public void close(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class<AssetFileDescriptor> getDataClass() {
            return AssetFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.context, this);
        }
    }

    private static final class InputStreamFactory implements ModelLoaderFactory<Integer, InputStream>, ResourceOpener<InputStream> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        InputStreamFactory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.context, this);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public InputStream open(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResource(i);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public void close(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    private static final class DrawableFactory implements ModelLoaderFactory<Integer, Drawable>, ResourceOpener<Drawable> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public void close(Drawable drawable) throws IOException {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        DrawableFactory(Context context) {
            this.context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Drawable open(Resources.Theme theme, Resources resources, int i) {
            return DrawableDecoderCompat.getDrawable(this.context, i, theme);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class<Drawable> getDataClass() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, Drawable> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.context, this);
        }
    }

    private static final class ResourceDataFetcher<DataT> implements DataFetcher<DataT> {
        private DataT data;
        private final int resourceId;
        private final ResourceOpener<DataT> resourceOpener;
        private final Resources resources;
        private final Resources.Theme theme;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        ResourceDataFetcher(Resources.Theme theme, Resources resources, ResourceOpener<DataT> resourceOpener, int i) {
            this.theme = theme;
            this.resources = resources;
            this.resourceOpener = resourceOpener;
            this.resourceId = i;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [DataT, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataT datatOpen = this.resourceOpener.open(this.theme, this.resources, this.resourceId);
                this.data = datatOpen;
                dataCallback.onDataReady(datatOpen);
            } catch (Resources.NotFoundException e) {
                dataCallback.onLoadFailed(e);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            DataT datat = this.data;
            if (datat != null) {
                try {
                    this.resourceOpener.close(datat);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class<DataT> getDataClass() {
            return this.resourceOpener.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }
}
