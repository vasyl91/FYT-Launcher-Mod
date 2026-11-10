package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ScrollerCompat {
    static final int CHASE_FRAME_TIME = 16;
    private static final String TAG = "ScrollerCompat";
    ScrollerCompatImpl mImpl;
    Object mScroller;

    interface ScrollerCompatImpl {
        void abortAnimation(Object obj);

        boolean computeScrollOffset(Object obj);

        Object createScroller(Context context, Interpolator interpolator);

        void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void fling(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        float getCurrVelocity(Object obj);

        int getCurrX(Object obj);

        int getCurrY(Object obj);

        int getFinalX(Object obj);

        int getFinalY(Object obj);

        boolean isFinished(Object obj);

        boolean isOverScrolled(Object obj);

        void notifyHorizontalEdgeReached(Object obj, int i, int i2, int i3);

        void notifyVerticalEdgeReached(Object obj, int i, int i2, int i3);

        void startScroll(Object obj, int i, int i2, int i3, int i4);

        void startScroll(Object obj, int i, int i2, int i3, int i4, int i5);
    }

    static class ScrollerCompatImplBase implements ScrollerCompatImpl {
        ScrollerCompatImplBase() {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public Object createScroller(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isFinished(Object scroller) {
            return ((Scroller) scroller).isFinished();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrX(Object scroller) {
            return ((Scroller) scroller).getCurrX();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrY(Object scroller) {
            return ((Scroller) scroller).getCurrY();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(Object scroller) {
            return 0.0f;
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean computeScrollOffset(Object scroller) {
            Scroller s = (Scroller) scroller;
            return s.computeScrollOffset();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy) {
            ((Scroller) scroller).startScroll(startX, startY, dx, dy);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy, int duration) {
            ((Scroller) scroller).startScroll(startX, startY, dx, dy, duration);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object scroller, int startX, int startY, int velX, int velY, int minX, int maxX, int minY, int maxY) {
            ((Scroller) scroller).fling(startX, startY, velX, velY, minX, maxX, minY, maxY);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object scroller, int startX, int startY, int velX, int velY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
            ((Scroller) scroller).fling(startX, startY, velX, velY, minX, maxX, minY, maxY);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void abortAnimation(Object scroller) {
            ((Scroller) scroller).abortAnimation();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyHorizontalEdgeReached(Object scroller, int startX, int finalX, int overX) {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyVerticalEdgeReached(Object scroller, int startY, int finalY, int overY) {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isOverScrolled(Object scroller) {
            return false;
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalX(Object scroller) {
            return ((Scroller) scroller).getFinalX();
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalY(Object scroller) {
            return ((Scroller) scroller).getFinalY();
        }
    }

    static class ScrollerCompatImplGingerbread implements ScrollerCompatImpl {
        ScrollerCompatImplGingerbread() {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public Object createScroller(Context context, Interpolator interpolator) {
            return ScrollerCompatGingerbread.createScroller(context, interpolator);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isFinished(Object scroller) {
            return ScrollerCompatGingerbread.isFinished(scroller);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrX(Object scroller) {
            return ScrollerCompatGingerbread.getCurrX(scroller);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getCurrY(Object scroller) {
            return ScrollerCompatGingerbread.getCurrY(scroller);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(Object scroller) {
            return 0.0f;
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean computeScrollOffset(Object scroller) {
            return ScrollerCompatGingerbread.computeScrollOffset(scroller);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy) {
            ScrollerCompatGingerbread.startScroll(scroller, startX, startY, dx, dy);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void startScroll(Object scroller, int startX, int startY, int dx, int dy, int duration) {
            ScrollerCompatGingerbread.startScroll(scroller, startX, startY, dx, dy, duration);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object scroller, int startX, int startY, int velX, int velY, int minX, int maxX, int minY, int maxY) {
            ScrollerCompatGingerbread.fling(scroller, startX, startY, velX, velY, minX, maxX, minY, maxY);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void fling(Object scroller, int startX, int startY, int velX, int velY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
            ScrollerCompatGingerbread.fling(scroller, startX, startY, velX, velY, minX, maxX, minY, maxY, overX, overY);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void abortAnimation(Object scroller) {
            ScrollerCompatGingerbread.abortAnimation(scroller);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyHorizontalEdgeReached(Object scroller, int startX, int finalX, int overX) {
            ScrollerCompatGingerbread.notifyHorizontalEdgeReached(scroller, startX, finalX, overX);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public void notifyVerticalEdgeReached(Object scroller, int startY, int finalY, int overY) {
            ScrollerCompatGingerbread.notifyVerticalEdgeReached(scroller, startY, finalY, overY);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public boolean isOverScrolled(Object scroller) {
            return ScrollerCompatGingerbread.isOverScrolled(scroller);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalX(Object scroller) {
            return ScrollerCompatGingerbread.getFinalX(scroller);
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public int getFinalY(Object scroller) {
            return ScrollerCompatGingerbread.getFinalY(scroller);
        }
    }

    static class ScrollerCompatImplIcs extends ScrollerCompatImplGingerbread {
        ScrollerCompatImplIcs() {
        }

        @Override // android.support.v4.widget.ScrollerCompat.ScrollerCompatImplGingerbread, android.support.v4.widget.ScrollerCompat.ScrollerCompatImpl
        public float getCurrVelocity(Object scroller) {
            return ScrollerCompatIcs.getCurrVelocity(scroller);
        }
    }

    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    ScrollerCompat(Context context, Interpolator interpolator) {
        this(Build.VERSION.SDK_INT, context, interpolator);
    }

    private ScrollerCompat(int apiVersion, Context context, Interpolator interpolator) {
        if (apiVersion >= 14) {
            this.mImpl = new ScrollerCompatImplIcs();
        } else if (apiVersion >= 9) {
            this.mImpl = new ScrollerCompatImplGingerbread();
        } else {
            this.mImpl = new ScrollerCompatImplBase();
        }
        this.mScroller = this.mImpl.createScroller(context, interpolator);
    }

    public boolean isFinished() {
        return this.mImpl.isFinished(this.mScroller);
    }

    public int getCurrX() {
        return this.mImpl.getCurrX(this.mScroller);
    }

    public int getCurrY() {
        return this.mImpl.getCurrY(this.mScroller);
    }

    public int getFinalX() {
        return this.mImpl.getFinalX(this.mScroller);
    }

    public int getFinalY() {
        return this.mImpl.getFinalY(this.mScroller);
    }

    public float getCurrVelocity() {
        return this.mImpl.getCurrVelocity(this.mScroller);
    }

    public boolean computeScrollOffset() {
        return this.mImpl.computeScrollOffset(this.mScroller);
    }

    public void startScroll(int startX, int startY, int dx, int dy) {
        this.mImpl.startScroll(this.mScroller, startX, startY, dx, dy);
    }

    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        this.mImpl.startScroll(this.mScroller, startX, startY, dx, dy, duration);
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
        this.mImpl.fling(this.mScroller, startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
        this.mImpl.fling(this.mScroller, startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, overX, overY);
    }

    public void abortAnimation() {
        this.mImpl.abortAnimation(this.mScroller);
    }

    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        this.mImpl.notifyHorizontalEdgeReached(this.mScroller, startX, finalX, overX);
    }

    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        this.mImpl.notifyVerticalEdgeReached(this.mScroller, startY, finalY, overY);
    }

    public boolean isOverScrolled() {
        return this.mImpl.isOverScrolled(this.mScroller);
    }
}
