package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Options;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class ResourceUriLoader<DataT> implements ModelLoader<Uri, DataT> {
    private static final int INVALID_RESOURCE_ID = 0;
    private static final String TAG = "ResourceUriLoader";
    private final Context context;
    private final ModelLoader<Integer, DataT> delegate;

    public static ModelLoaderFactory<Uri, InputStream> newStreamFactory(Context context) {
        return new InputStreamFactory(context);
    }

    public static ModelLoaderFactory<Uri, AssetFileDescriptor> newAssetFileDescriptorFactory(Context context) {
        return new AssetFileDescriptorFactory(context);
    }

    ResourceUriLoader(Context context, ModelLoader<Integer, DataT> modelLoader) {
        this.context = context.getApplicationContext();
        this.delegate = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<DataT> buildLoadData(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return parseResourceIdUri(uri, i, i2, options);
        }
        if (pathSegments.size() == 2) {
            return parseResourceNameUri(uri, i, i2, options);
        }
        if (!Log.isLoggable(TAG, 5)) {
            return null;
        }
        Log.w(TAG, "Failed to parse resource uri: " + uri);
        return null;
    }

    private ModelLoader.LoadData<DataT> parseResourceNameUri(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.context.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.context.getPackageName());
        if (identifier == 0) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Failed to find resource id for: " + uri);
            return null;
        }
        return this.delegate.buildLoadData(Integer.valueOf(identifier), i, i2, options);
    }

    private ModelLoader.LoadData<DataT> parseResourceIdUri(Uri uri, int i, int i2, Options options) {
        try {
            int i3 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i3 == 0) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Failed to parse a valid non-0 resource id from: " + uri);
                }
                return null;
            }
            return this.delegate.buildLoadData(Integer.valueOf(i3), i, i2, options);
        } catch (NumberFormatException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.context.getPackageName().equals(uri.getAuthority());
    }

    private static final class InputStreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        InputStreamFactory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.context, multiModelLoaderFactory.build(Integer.class, InputStream.class));
        }
    }

    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor> {
        private final Context context;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        AssetFileDescriptorFactory(Context context) {
            this.context = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.context, multiModelLoaderFactory.build(Integer.class, AssetFileDescriptor.class));
        }
    }
}
