package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class UriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));
    private final LocalUriFetcherFactory<Data> factory;

    public interface LocalUriFetcherFactory<Data> {
        DataFetcher<Data> build(Uri uri);
    }

    public UriLoader(LocalUriFetcherFactory<Data> localUriFetcherFactory) {
        this.factory = localUriFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), this.factory.build(uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {
        private final ContentResolver contentResolver;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public StreamFactory(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher<InputStream> build(Uri uri) {
            return new StreamLocalUriFetcher(this.contentResolver, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {
        private final ContentResolver contentResolver;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher<ParcelFileDescriptor> build(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.contentResolver, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {
        private final ContentResolver contentResolver;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher<AssetFileDescriptor> build(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.contentResolver, uri);
        }
    }
}
