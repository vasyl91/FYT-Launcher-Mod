package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class AnimatedImageDecoder {
    private final ArrayPool arrayPool;
    private final List<ImageHeaderParser> imageHeaderParsers;

    public static ResourceDecoder<InputStream, Drawable> streamDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool) {
        return new StreamAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    public static ResourceDecoder<ByteBuffer, Drawable> byteBufferDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool) {
        return new ByteBufferAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    private AnimatedImageDecoder(List<ImageHeaderParser> list, ArrayPool arrayPool) {
        this.imageHeaderParsers = list;
        this.arrayPool = arrayPool;
    }

    boolean handles(ByteBuffer byteBuffer) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, byteBuffer));
    }

    boolean handles(InputStream inputStream) throws IOException {
        return isHandled(ImageHeaderParserUtils.getType(this.imageHeaderParsers, inputStream, this.arrayPool));
    }

    private boolean isHandled(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF);
    }

    Resource<Drawable> decode(ImageDecoder.Source source, int i, int i2, Options options) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(i, i2, options));
        if (!(drawableDecodeDrawable instanceof AnimatedImageDrawable)) {
            throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
        }
        return new AnimatedImageDrawableResource((AnimatedImageDrawable) drawableDecodeDrawable);
    }

    private static final class AnimatedImageDrawableResource implements Resource<Drawable> {
        private static final int ESTIMATED_NUMBER_OF_FRAMES = 2;
        private final AnimatedImageDrawable imageDrawable;

        AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable) {
            this.imageDrawable = animatedImageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class<Drawable> getResourceClass() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Drawable get() {
            return this.imageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return this.imageDrawable.getIntrinsicWidth() * this.imageDrawable.getIntrinsicHeight() * Util.getBytesPerPixel(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
            this.imageDrawable.stop();
            this.imageDrawable.clearAnimationCallbacks();
        }
    }

    private static final class StreamAnimatedImageDecoder implements ResourceDecoder<InputStream, Drawable> {
        private final AnimatedImageDecoder delegate;

        StreamAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(InputStream inputStream, Options options) throws IOException {
            return this.delegate.handles(inputStream);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public Resource<Drawable> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(ByteBufferUtil.fromStream(inputStream)), i, i2, options);
        }
    }

    private static final class ByteBufferAnimatedImageDecoder implements ResourceDecoder<ByteBuffer, Drawable> {
        private final AnimatedImageDecoder delegate;

        ByteBufferAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.delegate = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
            return this.delegate.handles(byteBuffer);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        public Resource<Drawable> decode(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
            return this.delegate.decode(ImageDecoder.createSource(byteBuffer), i, i2, options);
        }
    }
}
