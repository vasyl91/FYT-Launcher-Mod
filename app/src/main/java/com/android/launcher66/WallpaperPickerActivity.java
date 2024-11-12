package com.android.launcher66;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.app.ActionBar;
import android.app.Activity;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Pair;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.android.launcher66.CropView;
import com.android.launcher66.WallpaperCropActivity;
import com.android.photos.BitmapRegionTileSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import share.ResValue;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class WallpaperPickerActivity extends WallpaperCropActivity {
    public static final int IMAGE_PICK = 5;
    public static final int PICK_LIVE_WALLPAPER = 7;
    public static final int PICK_WALLPAPER_THIRD_PARTY_ACTIVITY = 6;
    static final String TAG = "Launcher.WallpaperPickerActivity";
    private static final String TEMP_WALLPAPER_TILES = "TEMP_WALLPAPER_TILES";
    public static String mWallResName;
    private ActionMode mActionMode;
    private ActionMode.Callback mActionModeCallback;
    private boolean mIgnoreNextTap;
    private WallpaperInfo mLiveWallpaperInfoOnPickerLaunch;
    private View.OnLongClickListener mLongClickListener;
    private boolean mNightMode;
    private SavedWallpaperImages mSavedImages;
    private View mSelectedThumb;
    private View.OnClickListener mThumbnailOnClickListener;
    private View mWallpaperStrip;
    private LinearLayout mWallpapersView;
    int mliveWallpaper = 1;
    ArrayList<Uri> mTempWallpaperTiles = new ArrayList<>();

    public static abstract class WallpaperTileInfo {
        protected View mView;

        public void setView(View v) {
            this.mView = v;
        }

        public void onClick(WallpaperPickerActivity a) {
        }

        public void onSave(WallpaperPickerActivity a) {
        }

        public void onDelete(WallpaperPickerActivity a) {
        }

        public boolean isSelectable() {
            return false;
        }

        public boolean isNamelessWallpaper() {
            return false;
        }

        public void onIndexUpdated(CharSequence label) {
            if (isNamelessWallpaper()) {
                this.mView.setContentDescription(label);
            }
        }
    }

    public static class PickImageInfo extends WallpaperTileInfo {
        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onClick(WallpaperPickerActivity a) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            Utilities.startActivityForResultSafely(a, intent, 5);
        }
    }

    public static class UriWallpaperInfo extends WallpaperTileInfo {
        private Uri mUri;

        public UriWallpaperInfo(Uri uri) {
            this.mUri = uri;
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onClick(WallpaperPickerActivity a) {
            CropView v = a.getCropView();
            int rotation = WallpaperCropActivity.getRotationFromExif(a, this.mUri);
            v.setTileSource(new BitmapRegionTileSource(a, this.mUri, 1024, rotation), null);
            v.setTouchEnabled(true);
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onSave(final WallpaperPickerActivity a) {
            WallpaperCropActivity.OnBitmapCroppedHandler h = new WallpaperCropActivity.OnBitmapCroppedHandler() { // from class: com.android.launcher66.WallpaperPickerActivity.UriWallpaperInfo.1
                @Override // com.android.launcher66.WallpaperCropActivity.OnBitmapCroppedHandler
                public void onBitmapCropped(byte[] imageBytes) {
                    Point thumbSize = WallpaperPickerActivity.getDefaultThumbnailSize(a.getResources());
                    Bitmap thumb = WallpaperPickerActivity.createThumbnail(thumbSize, null, null, imageBytes, null, 0, 0, true);
                    a.getSavedImages().writeImage(thumb, imageBytes);
                }
            };
            a.cropImageAndSetWallpaper(this.mUri, h, true);
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public boolean isSelectable() {
            return true;
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public boolean isNamelessWallpaper() {
            return true;
        }
    }

    public static class ResourceWallpaperInfo extends WallpaperTileInfo {
        private int mResId;
        private String mResName;
        private Resources mResources;
        private Drawable mThumb;

        public ResourceWallpaperInfo(Resources res, int resId, Drawable thumb, String resName) {
            this.mResources = res;
            this.mResId = resId;
            this.mThumb = thumb;
            this.mResName = resName;
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onClick(WallpaperPickerActivity a) {
            WallpaperPickerActivity.mWallResName = this.mResName;
            int rotation = WallpaperCropActivity.getRotationFromExif(this.mResources, this.mResId);
            BitmapRegionTileSource source = new BitmapRegionTileSource(this.mResources, a, this.mResId, 1024, rotation);
            CropView v = a.getCropView();
            v.setTileSource(source, null);
            Point wallpaperSize = WallpaperCropActivity.getDefaultWallpaperSize(a.getResources(), a.getWindowManager());
            WallpaperCropActivity.getMaxCropRect(source.getImageWidth(), source.getImageHeight(), wallpaperSize.x, wallpaperSize.y, false);
            v.setTouchEnabled(false);
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public void onSave(WallpaperPickerActivity a) {
            a.cropImageAndSetWallpaper(this.mResources, this.mResId, true, WallpaperPickerActivity.mWallResName);
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public boolean isSelectable() {
            return true;
        }

        @Override // com.android.launcher66.WallpaperPickerActivity.WallpaperTileInfo
        public boolean isNamelessWallpaper() {
            return true;
        }
    }

    @Override // com.android.launcher66.WallpaperCropActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        this.mliveWallpaper = intent.getIntExtra("live_wallpaper", 0);
        super.onCreate(savedInstanceState);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mliveWallpaper = intent.getIntExtra("live_wallpaper", 0);
        View v = findViewById(R.id.live_wallpaper_list);
        View sv = findViewById(R.id.wallpaper_list);
        Log.e("TAAA", "onNewIntent mliveWallpaper == " + this.mliveWallpaper);
        if (sv != null) {
            Log.e("TAAA", "onNewIntent mliveWallpaper 11== " + this.mliveWallpaper);
            sv.setVisibility(this.mliveWallpaper == 1 ? View.GONE : View.VISIBLE);
        }
        if (v != null) {
            Log.e("TAAA", "onNewIntent mliveWallpaper 22== " + this.mliveWallpaper);
            v.setVisibility(this.mliveWallpaper != 0 ? View.VISIBLE : View.GONE);
        }
    }

    public void setWallpaperStripYOffset(float offset) {
        this.mWallpaperStrip.setPadding(0, 0, 0, (int) offset);
    }

    @Override // com.android.launcher66.WallpaperCropActivity
    protected void init() {
        setContentView(R.layout.wallpaper_picker);
        this.mCropView = (CropView) findViewById(R.id.cropView);
        this.mWallpaperStrip = findViewById(R.id.wallpaper_strip);
        this.mCropView.setTouchCallback(new CropView.TouchCallback() { // from class: com.android.launcher66.WallpaperPickerActivity.1
            LauncherViewPropertyAnimator mAnim;

            @Override // com.android.launcher66.CropView.TouchCallback
            public void onTouchDown() {
                if (this.mAnim != null) {
                    this.mAnim.cancel();
                }
                if (WallpaperPickerActivity.this.mWallpaperStrip.getAlpha() == 1.0f) {
                    WallpaperPickerActivity.this.mIgnoreNextTap = true;
                }
                this.mAnim = new LauncherViewPropertyAnimator(WallpaperPickerActivity.this.mWallpaperStrip);
                this.mAnim.alpha(0.0f).setDuration(150L).addListener(new Animator.AnimatorListener() { // from class: com.android.launcher66.WallpaperPickerActivity.1.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        WallpaperPickerActivity.this.mWallpaperStrip.setVisibility(View.INVISIBLE);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                this.mAnim.setInterpolator(new AccelerateInterpolator(0.75f));
                this.mAnim.start();
            }

            @Override // com.android.launcher66.CropView.TouchCallback
            public void onTouchUp() {
                WallpaperPickerActivity.this.mIgnoreNextTap = false;
            }

            @Override // com.android.launcher66.CropView.TouchCallback
            public void onTap() {
                boolean ignoreTap = WallpaperPickerActivity.this.mIgnoreNextTap;
                WallpaperPickerActivity.this.mIgnoreNextTap = false;
                if (!ignoreTap) {
                    if (this.mAnim != null) {
                        this.mAnim.cancel();
                    }
                    WallpaperPickerActivity.this.mWallpaperStrip.setVisibility(android.view.View.VISIBLE);
                    this.mAnim = new LauncherViewPropertyAnimator(WallpaperPickerActivity.this.mWallpaperStrip);
                    this.mAnim.alpha(1.0f).setDuration(150L).setInterpolator(new DecelerateInterpolator(0.75f));
                    this.mAnim.start();
                }
            }
        });
        this.mThumbnailOnClickListener = new View.OnClickListener() { // from class: com.android.launcher66.WallpaperPickerActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WallpaperPickerActivity.this.mActionMode != null) {
                    if (v.isLongClickable()) {
                        WallpaperPickerActivity.this.mLongClickListener.onLongClick(v);
                        return;
                    }
                    return;
                }
                WallpaperTileInfo info = (WallpaperTileInfo) v.getTag();
                if (info.isSelectable()) {
                    if (WallpaperPickerActivity.this.mSelectedThumb != null) {
                        WallpaperPickerActivity.this.mSelectedThumb.setSelected(false);
                        WallpaperPickerActivity.this.mSelectedThumb = null;
                    }
                    WallpaperPickerActivity.this.mSelectedThumb = v;
                    v.setSelected(true);
                    v.announceForAccessibility(WallpaperPickerActivity.this.getString(R.string.announce_selection, new Object[]{v.getContentDescription()}));
                }
                info.onClick(WallpaperPickerActivity.this);
            }
        };
        this.mLongClickListener = new View.OnLongClickListener() { // from class: com.android.launcher66.WallpaperPickerActivity.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                CheckableFrameLayout c = (CheckableFrameLayout) view;
                c.toggle();
                if (WallpaperPickerActivity.this.mActionMode != null) {
                    WallpaperPickerActivity.this.mActionMode.invalidate();
                    return true;
                }
                WallpaperPickerActivity.this.mActionMode = WallpaperPickerActivity.this.startActionMode(WallpaperPickerActivity.this.mActionModeCallback);
                int childCount = WallpaperPickerActivity.this.mWallpapersView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    WallpaperPickerActivity.this.mWallpapersView.getChildAt(i).setSelected(false);
                }
                return true;
            }
        };
        ArrayList<ResourceWallpaperInfo> wallpapers = findBundledWallpapers();
        this.mWallpapersView = (LinearLayout) findViewById(R.id.wallpaper_list);
        BuiltInWallpapersAdapter ia = new BuiltInWallpapersAdapter(this, wallpapers);
        populateWallpapersFromAdapter(this.mWallpapersView, ia, false, true);
        this.mSavedImages = new SavedWallpaperImages(this);
        this.mSavedImages.loadThumbnailsAndImageIdList();
        populateWallpapersFromAdapter(this.mWallpapersView, this.mSavedImages, true, true);
        final LinearLayout liveWallpapersView = (LinearLayout) findViewById(R.id.live_wallpaper_list);
        final LiveWallpaperListAdapter a = new LiveWallpaperListAdapter(this);
        a.registerDataSetObserver(new DataSetObserver() { // from class: com.android.launcher66.WallpaperPickerActivity.4
            @Override // android.database.DataSetObserver
            public void onChanged() {
                liveWallpapersView.removeAllViews();
                WallpaperPickerActivity.this.populateWallpapersFromAdapter(liveWallpapersView, a, false, false);
                WallpaperPickerActivity.this.initializeScrollForRtl();
                WallpaperPickerActivity.this.updateTileIndices();
            }
        });
        Log.e("TAAA", "init mliveWallpaper == " + this.mliveWallpaper);
        this.mWallpapersView.setVisibility(this.mliveWallpaper == 1 ? android.view.View.GONE : android.view.View.VISIBLE);
        liveWallpapersView.setVisibility(this.mliveWallpaper == 0 ? View.GONE : View.VISIBLE);
        LinearLayout thirdPartyWallpapersView = (LinearLayout) findViewById(R.id.third_party_wallpaper_list);
        ThirdPartyWallpaperPickerListAdapter ta = new ThirdPartyWallpaperPickerListAdapter(this);
        populateWallpapersFromAdapter(thirdPartyWallpapersView, ta, false, false);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.master_wallpaper_list);
        FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.wallpaper_picker_image_picker_item, (ViewGroup) linearLayout, false);
        setWallpaperItemPaddingToZero(frameLayout);
        linearLayout.addView(frameLayout, 0);
        PickImageInfo pickImageInfo = new PickImageInfo();
        frameLayout.setTag(pickImageInfo);
        pickImageInfo.setView(frameLayout);
        frameLayout.setOnClickListener(this.mThumbnailOnClickListener);
        pickImageInfo.setView(frameLayout);
        updateTileIndices();
        initializeScrollForRtl();
        LayoutTransition transitioner = new LayoutTransition();
        transitioner.setDuration(200L);
        transitioner.setStartDelay(1, 0L);
        transitioner.setAnimator(3, null);
        this.mWallpapersView.setLayoutTransition(transitioner);
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_set_wallpaper)) {
            TextView wallpaperSetView = (TextView) findViewById(ResValue.getInstance().btn_setwallpaper);
            if (wallpaperSetView != null) {
                wallpaperSetView.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.WallpaperPickerActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (WallpaperPickerActivity.this.mSelectedThumb != null) {
                            WallpaperTileInfo info = (WallpaperTileInfo) WallpaperPickerActivity.this.mSelectedThumb.getTag();
                            info.onSave(WallpaperPickerActivity.this);
                        }
                    }
                });
            }
        } else {
            ActionBar actionBar = getActionBar();
            actionBar.setCustomView(R.layout.actionbar_set_wallpaper);
            if (actionBar.getCustomView() != null) {
                actionBar.getCustomView().setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.WallpaperPickerActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (WallpaperPickerActivity.this.mSelectedThumb != null) {
                            WallpaperTileInfo info = (WallpaperTileInfo) WallpaperPickerActivity.this.mSelectedThumb.getTag();
                            info.onSave(WallpaperPickerActivity.this);
                        }
                    }
                });
            }
        }
        this.mActionModeCallback = new ActionMode.Callback() { // from class: com.android.launcher66.WallpaperPickerActivity.7
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.cab_delete_wallpapers, menu);
                return true;
            }

            private int numCheckedItems() {
                int childCount = WallpaperPickerActivity.this.mWallpapersView.getChildCount();
                int numCheckedItems = 0;
                for (int i = 0; i < childCount; i++) {
                    CheckableFrameLayout c = (CheckableFrameLayout) WallpaperPickerActivity.this.mWallpapersView.getChildAt(i);
                    if (c.isChecked()) {
                        numCheckedItems++;
                    }
                }
                return numCheckedItems;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                int numCheckedItems = numCheckedItems();
                if (numCheckedItems == 0) {
                    mode.finish();
                } else {
                    mode.setTitle(WallpaperPickerActivity.this.getResources().getQuantityString(R.plurals.number_of_items_selected, numCheckedItems, Integer.valueOf(numCheckedItems)));
                }
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == 2131624087) {
                    int childCount = WallpaperPickerActivity.this.mWallpapersView.getChildCount();
                    ArrayList<View> viewsToRemove = new ArrayList<>();
                    for (int i = 0; i < childCount; i++) {
                        CheckableFrameLayout c = (CheckableFrameLayout) WallpaperPickerActivity.this.mWallpapersView.getChildAt(i);
                        if (c.isChecked()) {
                            WallpaperTileInfo info = (WallpaperTileInfo) c.getTag();
                            info.onDelete(WallpaperPickerActivity.this);
                            viewsToRemove.add(c);
                        }
                    }
                    Iterator<View> it = viewsToRemove.iterator();
                    while (it.hasNext()) {
                        View v = it.next();
                        WallpaperPickerActivity.this.mWallpapersView.removeView(v);
                    }
                    WallpaperPickerActivity.this.updateTileIndices();
                    mode.finish();
                    return true;
                }
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                int childCount = WallpaperPickerActivity.this.mWallpapersView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    CheckableFrameLayout c = (CheckableFrameLayout) WallpaperPickerActivity.this.mWallpapersView.getChildAt(i);
                    c.setChecked(false);
                }
                WallpaperPickerActivity.this.mSelectedThumb.setSelected(true);
                WallpaperPickerActivity.this.mActionMode = null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeScrollForRtl() {
    }

    @Override // com.android.launcher66.WallpaperCropActivity
    public boolean enableRotation() {
        return super.enableRotation() || Launcher.sForceEnableRotation;
    }

    protected Bitmap getThumbnailOfLastPhoto() {
        Cursor cursor = MediaStore.Images.Media.query(getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "datetaken"}, null, null, "datetaken DESC LIMIT 1");
        Bitmap thumb = null;
        if (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            thumb = MediaStore.Images.Thumbnails.getThumbnail(getContentResolver(), id, 1, null);
        }
        cursor.close();
        return thumb;
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mWallpaperStrip = findViewById(R.id.wallpaper_strip);
        if (this.mWallpaperStrip.getAlpha() < 1.0f) {
            this.mWallpaperStrip.setAlpha(1.0f);
            this.mWallpaperStrip.setVisibility(View.VISIBLE);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(TEMP_WALLPAPER_TILES, this.mTempWallpaperTiles);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ArrayList<Uri> uris = savedInstanceState.getParcelableArrayList(TEMP_WALLPAPER_TILES);
        Iterator<Uri> it = uris.iterator();
        while (it.hasNext()) {
            Uri uri = it.next();
            addTemporaryWallpaperTile(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void populateWallpapersFromAdapter(ViewGroup viewGroup, BaseAdapter adapter, boolean addLongPressHandler, boolean selectFirstTile) {
        for (int i = 0; i < adapter.getCount(); i++) {
            FrameLayout frameLayout = (FrameLayout) adapter.getView(i, null, viewGroup);
            viewGroup.addView(frameLayout, i);
            WallpaperTileInfo wallpaperTileInfo = (WallpaperTileInfo) adapter.getItem(i);
            frameLayout.setTag(wallpaperTileInfo);
            wallpaperTileInfo.setView(frameLayout);
            if (addLongPressHandler) {
                addLongPressHandler(frameLayout);
            }
            frameLayout.setOnClickListener(this.mThumbnailOnClickListener);
            if (i == 0 && selectFirstTile) {
                this.mThumbnailOnClickListener.onClick(frameLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTileIndices() {
        LinearLayout subList;
        int subListStart;
        int subListEnd;
        LinearLayout masterWallpaperList = (LinearLayout) findViewById(R.id.master_wallpaper_list);
        int childCount = masterWallpaperList.getChildCount();
        Resources res = getResources();
        int numTiles = 0;
        for (int passNum = 0; passNum < 2; passNum++) {
            int tileIndex = 0;
            for (int i = 0; i < childCount; i++) {
                View child = masterWallpaperList.getChildAt(i);
                if (child.getTag() instanceof WallpaperTileInfo) {
                    subList = masterWallpaperList;
                    subListStart = i;
                    subListEnd = i + 1;
                } else {
                    subList = (LinearLayout) child;
                    subListStart = 0;
                    subListEnd = subList.getChildCount();
                }
                for (int j = subListStart; j < subListEnd; j++) {
                    WallpaperTileInfo info = (WallpaperTileInfo) subList.getChildAt(j).getTag();
                    if (info.isNamelessWallpaper()) {
                        if (passNum == 0) {
                            numTiles++;
                        } else {
                            tileIndex++;
                            CharSequence label = res.getString(R.string.wallpaper_accessibility_name, Integer.valueOf(tileIndex), Integer.valueOf(numTiles));
                            info.onIndexUpdated(label);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Point getDefaultThumbnailSize(Resources res) {
        return new Point(res.getDimensionPixelSize(R.dimen.wallpaperThumbnailWidth), res.getDimensionPixelSize(R.dimen.wallpaperThumbnailHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap createThumbnail(Point size, Context context, Uri uri, byte[] imageBytes, Resources res, int resId, int rotation, boolean leftAligned) {
        WallpaperCropActivity.BitmapCropTask cropTask;
        int width = size.x;
        int height = size.y;
        if (uri != null) {
            cropTask = new WallpaperCropActivity.BitmapCropTask(context, uri, (RectF) null, rotation, width, height, false, true, (Runnable) null);
        } else if (imageBytes != null) {
            cropTask = new WallpaperCropActivity.BitmapCropTask(imageBytes, null, rotation, width, height, false, true, null);
        } else {
            cropTask = new WallpaperCropActivity.BitmapCropTask(context, res, resId, null, rotation, width, height, false, true, null);
        }
        Point bounds = cropTask.getImageBounds();
        if (bounds == null || bounds.x == 0 || bounds.y == 0) {
            return null;
        }
        Matrix rotateMatrix = new Matrix();
        rotateMatrix.setRotate(rotation);
        float[] rotatedBounds = {bounds.x, bounds.y};
        rotateMatrix.mapPoints(rotatedBounds);
        rotatedBounds[0] = Math.abs(rotatedBounds[0]);
        rotatedBounds[1] = Math.abs(rotatedBounds[1]);
        RectF cropRect = WallpaperCropActivity.getMaxCropRect((int) rotatedBounds[0], (int) rotatedBounds[1], width, height, leftAligned);
        cropTask.setCropBounds(cropRect);
        if (cropTask.cropBitmap()) {
            return cropTask.getCroppedBitmap();
        }
        return null;
    }

    private void addTemporaryWallpaperTile(Uri uri) {
        this.mTempWallpaperTiles.add(uri);
        FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.wallpaper_picker_item, this.mWallpapersView, false);
        setWallpaperItemPaddingToZero(frameLayout);
        ImageView image = (ImageView) frameLayout.findViewById(R.id.wallpaper_image);
        Point defaultSize = getDefaultThumbnailSize(getResources());
        int rotation = WallpaperCropActivity.getRotationFromExif(this, uri);
        Bitmap thumb = createThumbnail(defaultSize, this, uri, null, null, 0, rotation, false);
        if (thumb != null) {
            image.setImageBitmap(thumb);
            Drawable thumbDrawable = image.getDrawable();
            thumbDrawable.setDither(true);
        } else {
            Log.e(TAG, "Error loading thumbnail for uri=" + uri);
        }
        this.mWallpapersView.addView(frameLayout, 0);
        UriWallpaperInfo uriWallpaperInfo = new UriWallpaperInfo(uri);
        frameLayout.setTag(uriWallpaperInfo);
        uriWallpaperInfo.setView(frameLayout);
        addLongPressHandler(frameLayout);
        updateTileIndices();
        frameLayout.setOnClickListener(this.mThumbnailOnClickListener);
        this.mThumbnailOnClickListener.onClick(frameLayout);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 5 && resultCode == -1) {
            if (data != null && data.getData() != null) {
                Uri uri = data.getData();
                addTemporaryWallpaperTile(uri);
                return;
            }
            return;
        }
        if (requestCode == 6) {
            setResult(-1);
            finish();
            return;
        }
        if (requestCode == 7) {
            WallpaperManager wm = WallpaperManager.getInstance(this);
            WallpaperInfo oldLiveWallpaper = this.mLiveWallpaperInfoOnPickerLaunch;
            WallpaperInfo newLiveWallpaper = wm.getWallpaperInfo();
            if (newLiveWallpaper != null) {
                if (oldLiveWallpaper == null || !oldLiveWallpaper.getComponent().equals(newLiveWallpaper.getComponent())) {
                    setResult(-1);
                    finish();
                }
            }
        }
    }

    static void setWallpaperItemPaddingToZero(FrameLayout frameLayout) {
        frameLayout.setPadding(0, 0, 0, 0);
        frameLayout.setForeground(new ZeroPaddingDrawable(frameLayout.getForeground()));
    }

    private void addLongPressHandler(View v) {
        v.setOnLongClickListener(this.mLongClickListener);
    }

    private ArrayList<ResourceWallpaperInfo> findBundledWallpapers() {
        ArrayList<ResourceWallpaperInfo> bundledWallpapers = new ArrayList<>(24);
        Pair<ApplicationInfo, Integer> r = getWallpaperArrayResourceId();
        if (r != null) {
            try {
                Resources wallpaperRes = getPackageManager().getResourcesForApplication((ApplicationInfo) r.first);
                return addWallpapers(wallpaperRes, ((ApplicationInfo) r.first).packageName, ((Integer) r.second).intValue());
            } catch (PackageManager.NameNotFoundException e) {
                return bundledWallpapers;
            }
        }
        return bundledWallpapers;
    }

    private ResourceWallpaperInfo getDefaultWallpaperInfo() {
        Bitmap thumb;
        Resources sysRes = Resources.getSystem();
        int resId = sysRes.getIdentifier("default_wallpaper", "drawable", "android");
        File defaultThumbFile = new File(getFilesDir(), "default_thumb.jpg");
        boolean defaultWallpaperExists = false;
        if (defaultThumbFile.exists()) {
            thumb = BitmapFactory.decodeFile(defaultThumbFile.getAbsolutePath());
            defaultWallpaperExists = true;
        } else {
            Resources res = getResources();
            Point defaultThumbSize = getDefaultThumbnailSize(res);
            int rotation = WallpaperCropActivity.getRotationFromExif(res, resId);
            thumb = createThumbnail(defaultThumbSize, this, null, null, sysRes, resId, rotation, false);
            if (thumb != null) {
                try {
                    defaultThumbFile.createNewFile();
                    FileOutputStream thumbFileStream = openFileOutput(defaultThumbFile.getName(), 0);
                    thumbFileStream.close();
                    defaultWallpaperExists = true;
                } catch (IOException e) {
                    Log.e(TAG, "Error while writing default wallpaper thumbnail to file " + e);
                    defaultThumbFile.delete();
                }
            }
        }
        if (defaultWallpaperExists) {
            return new ResourceWallpaperInfo(sysRes, resId, new BitmapDrawable(thumb), "");
        }
        return null;
    }

    public Pair<ApplicationInfo, Integer> getWallpaperArrayResourceId() {
        String packageName;
        if (this.mNightMode) {
            packageName = getResources().getResourcePackageName(R.array.wallpapers_n);
        } else {
            packageName = getResources().getResourcePackageName(R.array.wallpapers);
        }
        try {
            ApplicationInfo info = getPackageManager().getApplicationInfo(packageName, 0);
            return new Pair<>(info, Integer.valueOf(this.mNightMode ? R.array.wallpapers_n : R.array.wallpapers));
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private ArrayList<ResourceWallpaperInfo> addWallpapers(Resources res, String packageName, int listResId) {
        int thumbRes;
        ArrayList<ResourceWallpaperInfo> bundledWallpapers = new ArrayList<>(24);
        String[] extras = res.getStringArray(listResId);
        for (String extra : extras) {
            int resId = res.getIdentifier(extra, "drawable", packageName);
            if (resId != 0) {
                if (this.mNightMode) {
                    thumbRes = res.getIdentifier(String.valueOf(extra) + "_small", "drawable", packageName);
                } else {
                    thumbRes = res.getIdentifier(String.valueOf(extra) + "_small", "drawable", packageName);
                }
                if (thumbRes != 0) {
                    ResourceWallpaperInfo wallpaperInfo = new ResourceWallpaperInfo(res, resId, res.getDrawable(thumbRes), extra);
                    bundledWallpapers.add(wallpaperInfo);
                }
            } else {
                Log.e(TAG, "Couldn't find wallpaper " + extra);
            }
        }
        return bundledWallpapers;
    }

    public CropView getCropView() {
        return this.mCropView;
    }

    public SavedWallpaperImages getSavedImages() {
        return this.mSavedImages;
    }

    public void onLiveWallpaperPickerLaunch() {
        this.mLiveWallpaperInfoOnPickerLaunch = WallpaperManager.getInstance(this).getWallpaperInfo();
    }

    static class ZeroPaddingDrawable extends LevelListDrawable {
        public ZeroPaddingDrawable(Drawable d) {
            addLevel(0, 0, d);
            setLevel(0);
        }

        @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
        public boolean getPadding(Rect padding) {
            padding.set(0, 0, 0, 0);
            return true;
        }
    }

    private static class BuiltInWallpapersAdapter extends BaseAdapter implements ListAdapter {
        private LayoutInflater mLayoutInflater;
        private ArrayList<ResourceWallpaperInfo> mWallpapers;

        BuiltInWallpapersAdapter(Activity activity, ArrayList<ResourceWallpaperInfo> wallpapers) {
            this.mLayoutInflater = activity.getLayoutInflater();
            this.mWallpapers = wallpapers;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mWallpapers.size();
        }

        @Override // android.widget.Adapter
        public ResourceWallpaperInfo getItem(int position) {
            return this.mWallpapers.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Drawable thumb = this.mWallpapers.get(position).mThumb;
            if (thumb == null) {
                Log.e(WallpaperPickerActivity.TAG, "Error decoding thumbnail for wallpaper #" + position);
            }
            return WallpaperPickerActivity.createImageTileView(this.mLayoutInflater, position, convertView, parent, thumb);
        }
    }

    public static View createImageTileView(LayoutInflater layoutInflater, int position, View convertView, ViewGroup parent, Drawable thumb) {
        View view;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.wallpaper_picker_item, parent, false);
        } else {
            view = convertView;
        }
        setWallpaperItemPaddingToZero((FrameLayout) view);
        ImageView image = (ImageView) view.findViewById(R.id.wallpaper_image);
        if (thumb != null) {
            image.setImageDrawable(thumb);
            thumb.setDither(true);
        }
        return view;
    }
}
