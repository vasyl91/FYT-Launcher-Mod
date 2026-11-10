package com.lsec.core.frame.camera2;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.autonavi.amapauto.gdarcameraservice.IGDCameraStateCallBack;
import com.autonavi.amapauto.gdarcameraservice.constant.MemoryFileFlag;
import com.autonavi.amapauto.gdarcameraservice.model.ArCameraOpenResultParam;
import com.autonavi.amapauto.gdarcameraservice.utils.MemoryFileUtil;
import com.autonavi.amapauto.gdarcameraservice.utils.SharedMemUtils;
import com.lsec.core.frame.camera.MyCamera;
import com.lsec.core.frame.camera.MyCameraUtil;
import com.lsec.core.sharememory.MemoryFileHelper;
import com.lsec.core.util.data.FinalChip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyCamera2 {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static MyCamera2 mCameraInst;
    public static int mFormat;
    public static int mMaxImages;
    public Point extraPreviewSize;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    public MyCamera2Interface mCamera2Interface;
    private CameraDevice mCameraDevice;
    private CameraManager mCameraManager;
    private CameraCaptureSession mCaptureSession;
    public IGDCameraStateCallBack mGDCameraStateCallBack;
    private ImageReader mImageReader;
    private ImageReader mImageReaderExtra;
    public MemoryFile mMemoryFile;
    public ParcelFileDescriptor mParcelFileDescriptor;
    private Size mPreviewSize;
    private String mSpecificCameraId;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceTexture mSurfaceTexture;
    private TextureView mTexture;
    public Point maxPreviewSize;
    public Point minPreviewSize;
    public Point previewViewSize;
    public Point specificPreviewSize;
    public boolean bShutDown = false;
    private Semaphore mCameraOpenCloseLock = new Semaphore(1);
    public boolean bShareMemory2Other = false;
    public byte[] mHeader = new byte[20];
    List<Surface> mTargetSurfaces = new ArrayList();
    private CameraDevice.StateCallback mDeviceStateCallback = new CameraDevice.StateCallback() { // from class: com.lsec.core.frame.camera2.MyCamera2.1
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Log.d("HJT", "MyCamera2  onOpened(CameraDevice cameraDevice)  Camera ID: " + MyCamera2.this.mSpecificCameraId);
            MyCamera2.this.mCameraOpenCloseLock.release();
            MyCamera2.this.mCameraDevice = cameraDevice;
            MyCamera2.this.configure();
            if (MyCamera2.this.mCamera2Interface != null) {
                MyCamera2.this.mCamera2Interface.onOpened();
            }
            int[] size = MyCameraUtil.getSystemPropSize();
            if (size[0] == 990) {
                size[0] = 960;
            }
            if (MyCamera2.this.mGDCameraStateCallBack != null || MyCamera2.this.bShareMemory2Other) {
                SharedMemUtils.initHeader(MyCamera2.this.mHeader);
                Log.d("GD", "2memory-x:" + size[0] + "2memory-y:" + size[1]);
                MyCamera2.this.mMemoryFile = MemoryFileHelper.createMemoryFile(MemoryFileUtil.MEMORY_NAME, (size[0] * size[1] * 2) + 20);
                if (MyCamera2.this.mMemoryFile != null) {
                    MyCamera2.this.mParcelFileDescriptor = MemoryFileHelper.getParcelFileDescriptor(MyCamera2.this.mMemoryFile);
                }
            }
            try {
                if (MyCamera2.this.mGDCameraStateCallBack != null) {
                    int w_img = size[0];
                    int h_img = size[1];
                    if (w_img == MyCameraUtil.mWidth_FourCamera360 && h_img == MyCameraUtil.mHeight_FourCamera360 && h_img > 1920) {
                        h_img >>= 2;
                    }
                    int size_img = ((w_img * h_img) * 3) / 2;
                    Log.d("GD", "2ParcelFile-x:" + w_img + "2ParcelFile-y:" + h_img + "2size:" + size_img);
                    MyCamera2.this.mGDCameraStateCallBack.onOpened(MyCamera2.this.mParcelFileDescriptor, new ArCameraOpenResultParam(0, 0, 0, w_img, h_img, size_img, MyCamera2.this.mSpecificCameraId), MemoryFileUtil.MEMORY_NAME);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Log.d("HJT", "MyCamera2  onDisconnected(CameraDevice cameraDevice)  Camera ID: " + MyCamera2.this.mSpecificCameraId);
            try {
                if (MyCamera2.this.mGDCameraStateCallBack != null) {
                    MyCamera2.this.mGDCameraStateCallBack.onDisconnected();
                }
            } catch (Exception e) {
            }
            MyCamera2.this.mCameraOpenCloseLock.release();
            cameraDevice.close();
            MyCamera2.this.mCameraDevice = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int error) {
            Log.d("HJT", "MyCamera2  onError(CameraDevice cameraDevice, error)  Camera ID: " + MyCamera2.this.mSpecificCameraId + " error: " + error);
            try {
                if (MyCamera2.this.mGDCameraStateCallBack != null) {
                    MyCamera2.this.mGDCameraStateCallBack.onError(error, "onError:" + error);
                }
            } catch (Exception e) {
            }
            MyCamera2.this.mCameraOpenCloseLock.release();
            cameraDevice.close();
            MyCamera2.this.mCameraDevice = null;
        }
    };
    private final CameraCaptureSession.StateCallback mCaptureStateCallback = new CameraCaptureSession.StateCallback() { // from class: com.lsec.core.frame.camera2.MyCamera2.2
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            try {
                if (MyCamera2.this.mCameraDevice != null) {
                    MyCamera2.this.mCaptureSession = cameraCaptureSession;
                    if (MyCamera2.this.mCaptureSession != null) {
                        CaptureRequest.Builder builder = MyCamera2.this.getRequestBuilder(1);
                        for (Surface targetSurface : MyCamera2.this.mTargetSurfaces) {
                            if (targetSurface != null) {
                                Log.d("HJT", "!=null:");
                                builder.addTarget(targetSurface);
                            } else {
                                return;
                            }
                        }
                        Log.d("HJT", "mTargetSurfaces:" + MyCamera2.this.mTargetSurfaces.size());
                        MyCamera2.this.mCaptureSession.setRepeatingRequest(builder.build(), null, MyCamera2.this.mBackgroundHandler);
                    }
                }
            } catch (Exception e) {
                Log.d("HJT", "e:" + e.toString());
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        }
    };
    int i = 0;
    Runnable_setPreviewSurfHolder2 runnable_setPreviewSurfHolder = null;
    Runnable_setPreviewSurfTexture2 runnable_setPreviewSurfTexture = null;

    static {
        $assertionsDisabled = !MyCamera2.class.desiredAssertionStatus();
        mFormat = 35;
        mMaxImages = 2;
        mCameraInst = null;
    }

    private MyCamera2() {
    }

    public static synchronized MyCamera2 getInstance() {
        if (mCameraInst == null) {
            mCameraInst = new MyCamera2();
        }
        return mCameraInst;
    }

    public void setCamera2Interface(MyCamera2Interface camera2Interface) {
        Log.d("HJT", "setCamera2Interface");
        this.mCamera2Interface = camera2Interface;
    }

    public void writeBytes_GDAR(byte[] nv21) {
        if (this.mMemoryFile != null && nv21 != null) {
            try {
                this.mMemoryFile.readBytes(this.mHeader, 0, 0, 1);
                if (this.mHeader[0] == MemoryFileFlag.CAN_WRITE.getFlag()) {
                    int contentSize = nv21.length;
                    SharedMemUtils.setContentSize(this.mHeader, contentSize);
                    SharedMemUtils.setOffset(this.mHeader, 0);
                    SharedMemUtils.setLength(this.mHeader, contentSize + 20);
                    this.mMemoryFile.writeBytes(nv21, 0, 20, nv21.length);
                    this.mHeader[0] = MemoryFileFlag.CAN_READ.getFlag();
                    this.mMemoryFile.writeBytes(this.mHeader, 0, 0, 20);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Size getBestSupportedSize(List<Size> sizes) {
        float previewViewRatio;
        Size defaultSize = sizes.get(0);
        Size[] tempSizes = (Size[]) sizes.toArray(new Size[0]);
        Arrays.sort(tempSizes, new Comparator<Size>() { // from class: com.lsec.core.frame.camera2.MyCamera2.3
            @Override // java.util.Comparator
            public int compare(Size o1, Size o2) {
                if (o1.getWidth() > o2.getWidth()) {
                    return -1;
                }
                return (o1.getWidth() != o2.getWidth() || o1.getHeight() <= o2.getHeight()) ? 1 : -1;
            }
        });
        List<Size> sizes2 = new ArrayList<>(Arrays.asList(tempSizes));
        for (int i = sizes2.size() - 1; i >= 0; i--) {
            if (this.maxPreviewSize != null && (sizes2.get(i).getWidth() > this.maxPreviewSize.x || sizes2.get(i).getHeight() > this.maxPreviewSize.y)) {
                sizes2.remove(i);
            } else if (this.minPreviewSize != null && (sizes2.get(i).getWidth() < this.minPreviewSize.x || sizes2.get(i).getHeight() < this.minPreviewSize.y)) {
                sizes2.remove(i);
            }
        }
        if (sizes2.size() != 0) {
            Size bestSize = sizes2.get(0);
            if (this.previewViewSize != null) {
                previewViewRatio = this.previewViewSize.x / this.previewViewSize.y;
            } else {
                previewViewRatio = bestSize.getWidth() / bestSize.getHeight();
            }
            if (previewViewRatio > 1.0f) {
                previewViewRatio = 1.0f / previewViewRatio;
            }
            for (Size s : sizes2) {
                if (this.specificPreviewSize != null && this.specificPreviewSize.x == s.getWidth() && this.specificPreviewSize.y == s.getHeight()) {
                    return s;
                }
                if (Math.abs((s.getHeight() / s.getWidth()) - previewViewRatio) < Math.abs((bestSize.getHeight() / bestSize.getWidth()) - previewViewRatio)) {
                    bestSize = s;
                }
            }
            Size defaultSize2 = bestSize;
            return defaultSize2;
        }
        return defaultSize;
    }

    public synchronized void start(String specificCameraId, SurfaceTexture surfaceTexture) {
        Log.d("HJT", "MyCamera2  Camera ID: " + specificCameraId + "  mCameraDevice : " + this.mCameraDevice);
        if (this.mCameraDevice == null) {
            startBackgroundThread();
            open(specificCameraId, surfaceTexture);
        }
    }

    public synchronized void start(String specificCameraId, TextureView texture) {
        Log.d("HJT", "MyCamera2  Camera ID: " + specificCameraId + "  mCameraDevice : " + this.mCameraDevice);
        if (this.mCameraDevice == null) {
            Log.d("HJT", "--------------------texture");
            startBackgroundThread();
            open(specificCameraId, texture);
        }
    }

    public synchronized void start(String specificCameraId, SurfaceHolder surfaceHolder) {
        if (this.mCameraDevice == null) {
            startBackgroundThread();
            open(specificCameraId, surfaceHolder);
        }
    }

    public synchronized void stop() {
        this.mCamera2Interface = null;
        if (this.mCameraDevice != null) {
            closeCamera();
            stopBackgroundThread();
        }
    }

    public void open(String specificCameraId, TextureView texture) {
        MyCamera.setSystemProp();
        this.mSpecificCameraId = specificCameraId;
        this.mTexture = texture;
        this.mSurfaceTexture = null;
        this.mSurfaceHolder = null;
        try {
            if (this.mCameraOpenCloseLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                Log.d("HJT", "MyCamera2  open(cameraid, SurfaceTexture)  Camera ID: " + specificCameraId);
                this.mCameraManager.openCamera(this.mSpecificCameraId, this.mDeviceStateCallback, this.mBackgroundHandler);
            }
        } catch (Exception e) {
            Log.d("HJT", "MyCamera2  open(cameraid, SurfaceTexture)  Camera ID: " + specificCameraId + " Exception!!");
        }
    }

    public void open(String specificCameraId, SurfaceTexture surfaceTexture) {
        MyCamera.setSystemProp();
        this.mSpecificCameraId = specificCameraId;
        this.mSurfaceTexture = surfaceTexture;
        this.mSurfaceHolder = null;
        this.mTexture = null;
        try {
            if (this.mCameraOpenCloseLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                Log.d("HJT", "MyCamera2  open(cameraid, SurfaceTexture)  Camera ID: " + specificCameraId);
                this.mCameraManager.openCamera(this.mSpecificCameraId, this.mDeviceStateCallback, this.mBackgroundHandler);
            }
        } catch (Exception e) {
            Log.d("HJT", "MyCamera2  open(cameraid, SurfaceTexture)  Camera ID: " + specificCameraId + " Exception!!");
        }
    }

    public void open(String specificCameraId, SurfaceHolder surfaceHolder) {
        MyCamera.setSystemProp();
        this.mSpecificCameraId = specificCameraId;
        this.mSurfaceHolder = surfaceHolder;
        this.mSurfaceTexture = null;
        this.mTexture = null;
        try {
            if (this.mCameraOpenCloseLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                Log.d("HJT", "MyCamera2  open(cameraid, SurfaceHolder)  Camera ID: " + specificCameraId);
                this.mCameraManager.openCamera(this.mSpecificCameraId, this.mDeviceStateCallback, this.mBackgroundHandler);
            }
        } catch (Exception e) {
            Log.d("HJT", "MyCamera2  open(cameraid, SurfaceHolder)  Camera ID: " + specificCameraId + " Exception!!");
        }
    }

    private void closeCamera() {
        Log.d("HJT", "MyCamera2  closeCamera  Camera ID: " + this.mSpecificCameraId);
        try {
            this.mCameraOpenCloseLock.acquire();
            if (this.mCaptureSession != null) {
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
            if (this.mCameraDevice != null) {
                this.mCameraDevice.close();
                this.mCameraDevice = null;
            }
            if (this.mImageReader != null) {
                this.mImageReader.close();
                this.mImageReader = null;
            }
            if (this.mImageReaderExtra != null) {
                this.mImageReaderExtra.close();
                this.mImageReaderExtra = null;
            }
        } catch (Exception e) {
        } finally {
            this.mCameraOpenCloseLock.release();
        }
    }

    private void startBackgroundThread() {
        String plat = SystemProperties.get("sys.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        if (TextUtils.isEmpty(plat)) {
            SystemProperties.get("ro.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        }
        this.mBackgroundThread = new HandlerThread("CameraBackground");
        this.mBackgroundThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        this.mBackgroundThread.quitSafely();
        try {
            this.mBackgroundThread.join();
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void configure() {
        try {
            int[] size = MyCameraUtil.getSystemPropSize();
            if (size[0] == 990) {
                size[0] = 960;
            }
            Log.d("HJT", "mPreviewSize-X:" + size[0] + "mPreviewSize-Y:" + size[1]);
            this.mPreviewSize = new Size(size[0], size[1]);
            this.mTargetSurfaces.clear();
            Surface surface = null;
            if (this.mSurfaceTexture != null) {
                Log.d("HJT", "---------------add mSurfaceTexture");
                this.mSurfaceTexture.setDefaultBufferSize(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
                surface = new Surface(this.mSurfaceTexture);
            } else if (this.mTexture != null) {
                Log.d("HJT", "------------------add texture");
                SurfaceTexture texture = this.mTexture.getSurfaceTexture();
                if (!$assertionsDisabled && texture == null) {
                    throw new AssertionError();
                }
                texture.setDefaultBufferSize(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
                surface = new Surface(texture);
            } else if (this.mSurfaceHolder != null) {
                Log.d("HJT", "--------------add mSurfaceHolder");
                surface = this.mSurfaceHolder.getSurface();
            }
            if (surface != null) {
                this.mTargetSurfaces.add(surface);
            }
            if (MyCameraUtil.bAddImageReader) {
                this.mImageReader = ImageReader.newInstance(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight(), mFormat, mMaxImages);
                this.mImageReader.setOnImageAvailableListener(new OnImageAvailableListenerImpl(this, null), this.mBackgroundHandler);
                if (this.mImageReader.getSurface() != null) {
                    this.mTargetSurfaces.add(this.mImageReader.getSurface());
                }
                if (this.extraPreviewSize != null) {
                    this.mImageReaderExtra = ImageReader.newInstance(this.extraPreviewSize.x, this.extraPreviewSize.y, mFormat, 1);
                    this.mImageReaderExtra.setOnImageAvailableListener(new OnImageAvailableListenerImplExtra(this, null), this.mBackgroundHandler);
                    if (this.mImageReaderExtra.getSurface() != null) {
                        this.mTargetSurfaces.add(this.mImageReaderExtra.getSurface());
                    }
                }
            }
            Log.d("HJT", "mTargetSurfaces Size:" + this.mTargetSurfaces.size());
            if (this.mTargetSurfaces.size() > 0) {
                this.mCameraDevice.createCaptureSession(this.mTargetSurfaces, this.mCaptureStateCallback, this.mBackgroundHandler);
            } else if (this.mCaptureSession != null) {
                this.mCaptureSession.close();
                this.mCaptureSession = null;
            }
        } catch (Exception e) {
        }
    }

    public CaptureRequest.Builder getRequestBuilder(int template) {
        CaptureRequest.Builder request = null;
        if (this.mCameraDevice == null) {
            return null;
        }
        try {
            request = this.mCameraDevice.createCaptureRequest(template);
            request.set(CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE, 1);
            return request;
        } catch (Exception e) {
            return request;
        }
    }

    private class OnImageAvailableListenerImpl implements ImageReader.OnImageAvailableListener {
        private OnImageAvailableListenerImpl() {
        }

        /* synthetic */ OnImageAvailableListenerImpl(MyCamera2 myCamera2, OnImageAvailableListenerImpl onImageAvailableListenerImpl) {
            this();
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader reader) {
            if (MyCamera2.this.mCamera2Interface != null) {
                MyCamera2.this.mCamera2Interface.onImageAvailable(reader);
            }
        }
    }

    private class OnImageAvailableListenerImplExtra implements ImageReader.OnImageAvailableListener {
        private OnImageAvailableListenerImplExtra() {
        }

        /* synthetic */ OnImageAvailableListenerImplExtra(MyCamera2 myCamera2, OnImageAvailableListenerImplExtra onImageAvailableListenerImplExtra) {
            this();
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader reader) {
            if (MyCamera2.this.mCamera2Interface != null) {
                MyCamera2.this.mCamera2Interface.onImageAvailableExtra(reader);
            }
        }
    }

    public boolean isCameraOpen() {
        return this.mCameraDevice != null;
    }

    public void shutDown() {
        this.bShutDown = true;
        stop();
    }

    public void setMaxImages(int max) {
        mMaxImages = max;
    }

    public void setPreview(CameraManager cameraManager, SurfaceHolder holder, int idVideo, int iDegree) {
        this.mCameraManager = cameraManager;
        Log.d("HJT", "setPreview6:" + idVideo);
        MyCameraUtil.idVideo = idVideo;
        MyCameraUtil.iDegree = iDegree;
        this.bShutDown = false;
        try {
            if (this.runnable_setPreviewSurfHolder != null) {
                this.runnable_setPreviewSurfHolder.stopRun();
            }
            this.runnable_setPreviewSurfHolder = new Runnable_setPreviewSurfHolder2(holder);
            this.runnable_setPreviewSurfHolder.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPreview(CameraManager cameraManager, SurfaceTexture surface, int idVideo, int iDegree) {
        this.mCameraManager = cameraManager;
        Log.d("HJT", "setPreview4:" + idVideo);
        MyCameraUtil.idVideo = idVideo;
        MyCameraUtil.iDegree = iDegree;
        this.bShutDown = false;
        try {
            if (this.runnable_setPreviewSurfTexture != null) {
                this.runnable_setPreviewSurfTexture.stopRun();
            }
            this.runnable_setPreviewSurfTexture = new Runnable_setPreviewSurfTexture2(surface);
            this.runnable_setPreviewSurfTexture.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPreview(CameraManager cameraManager, TextureView texture, int idVideo, int iDegree) {
        this.mCameraManager = cameraManager;
        Log.d("HJT", "setPreview4:" + idVideo);
        MyCameraUtil.idVideo = idVideo;
        MyCameraUtil.iDegree = iDegree;
        this.bShutDown = false;
        try {
            if (this.runnable_setPreviewSurfTexture != null) {
                this.runnable_setPreviewSurfTexture.stopRun();
            }
            this.runnable_setPreviewSurfTexture = new Runnable_setPreviewSurfTexture2(texture);
            this.runnable_setPreviewSurfTexture.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPreviewSize(Point val) {
        this.specificPreviewSize = val;
    }

    public void setPreviewSizeExtra(Point val) {
        this.extraPreviewSize = val;
    }

    public void setMaxPreviewSize(Point val) {
        this.maxPreviewSize = val;
    }

    public void setMinPreviewSize(Point val) {
        this.minPreviewSize = val;
    }
}
