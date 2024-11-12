package com.android.launcher66;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.core.widget.AutoScrollHelper;
import android.text.Selection;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.launcher66.CellLayout;
import com.android.launcher66.DragLayer;
import com.android.launcher66.DropTarget;
import com.android.launcher66.FolderInfo;
import com.syu.log.LogPreview;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class Folder extends LinearLayout implements DragSource, View.OnClickListener, View.OnLongClickListener, DropTarget, FolderInfo.FolderListener, TextView.OnEditorActionListener, View.OnFocusChangeListener {
    private static final int ON_EXIT_CLOSE_DELAY = 800;
    private static final int REORDER_ANIMATION_DURATION = 230;
    private static final int REORDER_DELAY = 250;
    static final int STATE_ANIMATING = 1;
    static final int STATE_NONE = -1;
    static final int STATE_OPEN = 2;
    static final int STATE_SMALL = 0;
    private static final String TAG = "Launcher.Folder";
    private static String sDefaultFolderName;
    private static String sHintText;
    private int DRAG_MODE_NONE;
    private int DRAG_MODE_REORDER;
    private ActionMode.Callback mActionModeCallback;
    private AutoScrollHelper mAutoScrollHelper;
    protected CellLayout mContent;
    private ShortcutInfo mCurrentDragInfo;
    private View mCurrentDragView;
    private boolean mDeferDropAfterUninstall;
    private Runnable mDeferredAction;
    private boolean mDeleteFolderOnDropCompleted;
    private boolean mDestroyed;
    protected DragController mDragController;
    private boolean mDragInProgress;
    private int mDragMode;
    private int[] mEmptyCell;
    private int mExpandDuration;
    private FolderIcon mFolderIcon;
    private float mFolderIconPivotX;
    private float mFolderIconPivotY;
    FolderEditText mFolderName;
    private int mFolderNameHeight;
    private final IconCache mIconCache;
    private Drawable mIconDrawable;
    private final LayoutInflater mInflater;
    protected FolderInfo mInfo;
    private InputMethodManager mInputMethodManager;
    private boolean mIsEditingName;
    private boolean mItemAddedBackToSelfViaIcon;
    private ArrayList<View> mItemsInReadingOrder;
    boolean mItemsInvalidated;
    protected Launcher mLauncher;
    private int mMaxCountX;
    private int mMaxCountY;
    private int mMaxNumItems;
    private Alarm mOnExitAlarm;
    OnAlarmListener mOnExitAlarmListener;
    private int[] mPreviousTargetCell;
    private boolean mRearrangeOnClose;
    private Alarm mReorderAlarm;
    OnAlarmListener mReorderAlarmListener;
    private ScrollView mScrollView;
    private int mState;
    private boolean mSuppressFolderDeletion;
    boolean mSuppressOnAdd;
    private int[] mTargetCell;
    private Rect mTempRect;
    private boolean mUninstallSuccessful;

    public Folder(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mState = -1;
        this.mRearrangeOnClose = false;
        this.mItemsInReadingOrder = new ArrayList<>();
        this.mItemsInvalidated = false;
        this.mSuppressOnAdd = false;
        this.mTargetCell = new int[2];
        this.mPreviousTargetCell = new int[2];
        this.mEmptyCell = new int[2];
        this.mReorderAlarm = new Alarm();
        this.mOnExitAlarm = new Alarm();
        this.mTempRect = new Rect();
        this.mDragInProgress = false;
        this.mDeleteFolderOnDropCompleted = false;
        this.mSuppressFolderDeletion = false;
        this.mItemAddedBackToSelfViaIcon = false;
        this.mIsEditingName = false;
        this.DRAG_MODE_NONE = 0;
        this.DRAG_MODE_REORDER = 1;
        this.mDragMode = this.DRAG_MODE_NONE;
        this.mActionModeCallback = new ActionMode.Callback() { // from class: com.android.launcher66.Folder.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
        };
        this.mReorderAlarmListener = new OnAlarmListener() { // from class: com.android.launcher66.Folder.2
            @Override // com.android.launcher66.OnAlarmListener
            public void onAlarm(Alarm alarm) {
                Folder.this.realTimeReorder(Folder.this.mEmptyCell, Folder.this.mTargetCell);
            }
        };
        this.mOnExitAlarmListener = new OnAlarmListener() { // from class: com.android.launcher66.Folder.3
            @Override // com.android.launcher66.OnAlarmListener
            public void onAlarm(Alarm alarm) {
                Folder.this.completeDragExit();
            }
        };
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        setAlwaysDrawnWithCacheEnabled(false);
        this.mInflater = LayoutInflater.from(context);
        this.mIconCache = app.getIconCache();
        Resources res = getResources();
        this.mMaxCountX = (int) grid.numColumns;
        this.mMaxCountY = (int) grid.numRows;
        this.mMaxNumItems = this.mMaxCountX * this.mMaxCountY;
        this.mInputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        this.mExpandDuration = res.getInteger(R.integer.config_folderAnimDuration);
        if (sDefaultFolderName == null) {
            sDefaultFolderName = res.getString(R.string.folder_name);
        }
        if (sHintText == null) {
            sHintText = res.getString(R.string.folder_hint_text);
        }
        this.mLauncher = (Launcher) context;
        setFocusableInTouchMode(true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mScrollView = (ScrollView) findViewById(R.id.scroll_view);
        this.mContent = (CellLayout) findViewById(R.id.folder_content);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        this.mContent.setCellDimensions(grid.folderCellWidthPx, grid.folderCellHeightPx);
        this.mContent.setGridSize(0, 0);
        this.mContent.getShortcutsAndWidgets().setMotionEventSplittingEnabled(false);
        this.mContent.setInvertIfRtl(true);
        this.mFolderName = (FolderEditText) findViewById(R.id.folder_name);
        this.mFolderName.setFolder(this);
        this.mFolderName.setOnFocusChangeListener(this);
        this.mFolderName.measure(0, 0);
        this.mFolderNameHeight = this.mFolderName.getMeasuredHeight();
        this.mFolderName.setCustomSelectionActionModeCallback(this.mActionModeCallback);
        this.mFolderName.setOnEditorActionListener(this);
        this.mFolderName.setSelectAllOnFocus(true);
        this.mFolderName.setInputType(this.mFolderName.getInputType() | 524288 | 8192);
        this.mAutoScrollHelper = new FolderAutoScrollHelper(this.mScrollView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Object tag = v.getTag();
        if (tag instanceof ShortcutInfo) {
            this.mLauncher.onClick(v);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        if (!this.mLauncher.isDraggingEnabled()) {
            return true;
        }
        Object tag = v.getTag();
        if (tag instanceof ShortcutInfo) {
            ShortcutInfo item = (ShortcutInfo) tag;
            if (!v.isInTouchMode()) {
                return false;
            }
            this.mLauncher.dismissFolderCling(null);
            this.mLauncher.getWorkspace().onDragStartedWithItem(v);
            this.mLauncher.getWorkspace().beginDragShared(v, this);
            this.mIconDrawable = ((TextView) v).getCompoundDrawables()[1];
            this.mCurrentDragInfo = item;
            this.mEmptyCell[0] = item.cellX;
            this.mEmptyCell[1] = item.cellY;
            this.mCurrentDragView = v;
            this.mContent.removeView(this.mCurrentDragView);
            this.mInfo.remove(this.mCurrentDragInfo);
            this.mDragInProgress = true;
            this.mItemAddedBackToSelfViaIcon = false;
        }
        return true;
    }

    public boolean isEditingName() {
        return this.mIsEditingName;
    }

    public void startEditingFolderName() {
        this.mFolderName.setHint("");
        this.mIsEditingName = true;
    }

    public void dismissEditingName() {
        this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        doneEditingFolderName(true);
    }

    public void doneEditingFolderName(boolean commit) {
        this.mFolderName.setHint(sHintText);
        String newTitle = this.mFolderName.getText().toString();
        this.mInfo.setTitle(newTitle);
        LauncherModel.updateItemInDatabase(this.mLauncher, this.mInfo);
        if (commit) {
            sendCustomAccessibilityEvent(32, String.format(getContext().getString(R.string.folder_renamed), newTitle));
        }
        requestFocus();
        Selection.setSelection(this.mFolderName.getText(), 0, 0);
        this.mIsEditingName = false;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId != 6) {
            return false;
        }
        dismissEditingName();
        return true;
    }

    public View getEditTextRegion() {
        return this.mFolderName;
    }

    public Drawable getDragDrawable() {
        return this.mIconDrawable;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    public void setDragController(DragController dragController) {
        this.mDragController = dragController;
    }

    void setFolderIcon(FolderIcon icon) {
        this.mFolderIcon = icon;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return true;
    }

    FolderInfo getInfo() {
        return this.mInfo;
    }

    private class GridComparator implements Comparator<ShortcutInfo> {
        int mNumCols;

        public GridComparator(int numCols) {
            this.mNumCols = numCols;
        }

        @Override // java.util.Comparator
        public int compare(ShortcutInfo lhs, ShortcutInfo rhs) {
            int lhIndex = (lhs.cellY * this.mNumCols) + lhs.cellX;
            int rhIndex = (rhs.cellY * this.mNumCols) + rhs.cellX;
            return lhIndex - rhIndex;
        }
    }

    private void placeInReadingOrder(ArrayList<ShortcutInfo> items) {
        int maxX = 0;
        int count = items.size();
        for (int i = 0; i < count; i++) {
            ShortcutInfo item = items.get(i);
            if (item.cellX > maxX) {
                maxX = item.cellX;
            }
        }
        GridComparator gridComparator = new GridComparator(maxX + 1);
        Collections.sort(items, gridComparator);
        int countX = this.mContent.getCountX();
        for (int i2 = 0; i2 < count; i2++) {
            int x = i2 % countX;
            int y = i2 / countX;
            ShortcutInfo item2 = items.get(i2);
            item2.cellX = x;
            item2.cellY = y;
        }
    }

    void bind(FolderInfo info) {
        this.mInfo = info;
        ArrayList<ShortcutInfo> children = info.contents;
        ArrayList<ShortcutInfo> overflow = new ArrayList<>();
        setupContentForNumItems(children.size());
        placeInReadingOrder(children);
        int count = 0;
        for (int i = 0; i < children.size(); i++) {
            ShortcutInfo child = children.get(i);
            if (!createAndAddShortcut(child)) {
                overflow.add(child);
            } else {
                count++;
            }
        }
        setupContentForNumItems(count);
        Iterator<ShortcutInfo> it = overflow.iterator();
        while (it.hasNext()) {
            ShortcutInfo item = it.next();
            this.mInfo.remove(item);
            LauncherModel.deleteItemFromDatabase(this.mLauncher, item);
        }
        this.mItemsInvalidated = true;
        updateTextViewFocus();
        this.mInfo.addListener(this);
        if (!sDefaultFolderName.contentEquals(this.mInfo.title)) {
            this.mFolderName.setText(this.mInfo.title);
        } else {
            this.mFolderName.setText("");
        }
        updateItemLocationsInDatabase();
    }

    static Folder fromXml(Context context) {
        return (Folder) LayoutInflater.from(context).inflate(R.layout.user_folder, (ViewGroup) null);
    }

    private void positionAndSizeAsIcon() {
        if (getParent() instanceof DragLayer) {
            setScaleX(0.8f);
            setScaleY(0.8f);
            setAlpha(0.0f);
            this.mState = 0;
        }
    }

    public void animateOpen() {
        positionAndSizeAsIcon();
        if (getParent() instanceof DragLayer) {
            centerAboutIcon();
            PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1.0f);
            PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f);
            PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f);
            ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(this, alpha, scaleX, scaleY);
            oa.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.Folder.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Folder.this.sendCustomAccessibilityEvent(32, String.format(Folder.this.getContext().getString(R.string.folder_opened), Integer.valueOf(Folder.this.mContent.getCountX()), Integer.valueOf(Folder.this.mContent.getCountY())));
                    Folder.this.mState = 1;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Folder.this.mState = 2;
                    Folder.this.setLayerType(View.LAYER_TYPE_NONE, null);
                    Cling cling = Folder.this.mLauncher.showFirstRunFoldersCling();
                    if (cling != null) {
                        cling.bringScrimToFront();
                        Folder.this.bringToFront();
                        cling.bringToFront();
                    }
                    Folder.this.setFocusOnFirstChild();
                }
            });
            oa.setDuration(this.mExpandDuration);
            setLayerType(View.LAYER_TYPE_HARDWARE, null);
            oa.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCustomAccessibilityEvent(int type, String text) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent event = AccessibilityEvent.obtain(type);
            onInitializeAccessibilityEvent(event);
            event.getText().add(text);
            accessibilityManager.sendAccessibilityEvent(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusOnFirstChild() {
        View firstChild = this.mContent.getChildAt(0, 0);
        if (firstChild != null) {
            firstChild.requestFocus();
        }
    }

    public void animateClosed() {
        if (getParent() instanceof DragLayer) {
            PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.0f);
            PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.9f);
            PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.9f);
            ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(this, alpha, scaleX, scaleY);
            oa.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.Folder.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Folder.this.onCloseComplete();
                    Folder.this.setLayerType(View.LAYER_TYPE_NONE, null);
                    Folder.this.mState = 0;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Folder.this.sendCustomAccessibilityEvent(32, Folder.this.getContext().getString(R.string.folder_closed));
                    Folder.this.mState = 1;
                }
            });
            oa.setDuration(this.mExpandDuration);
            setLayerType(View.LAYER_TYPE_HARDWARE, null);
            oa.start();
        }
    }

    @Override // com.android.launcher66.DropTarget
    public boolean acceptDrop(DropTarget.DragObject d) {
        ItemInfo item = (ItemInfo) d.dragInfo;
        int itemType = item.itemType;
        return (itemType == 0 || itemType == 1) && !isFull();
    }

    protected boolean findAndSetEmptyCells(ShortcutInfo item) {
        int[] emptyCell = new int[2];
        if (!this.mContent.findCellForSpan(emptyCell, item.spanX, item.spanY)) {
            return false;
        }
        item.cellX = emptyCell[0];
        item.cellY = emptyCell[1];
        return true;
    }

    protected boolean createAndAddShortcut(ShortcutInfo item) {
        BubbleTextView textView = (BubbleTextView) this.mInflater.inflate(R.layout.application, (ViewGroup) this, false);
        textView.setCompoundDrawables(null, Utilities.createIconDrawable(item.getIcon(this.mIconCache)), null, null);
        textView.setText(item.title);
        textView.setTag(item);
        textView.setTextColor(getResources().getColor(R.color.folder_items_text_color));
        textView.setShadowsEnabled(false);
        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
        if (this.mContent.getChildAt(item.cellX, item.cellY) != null || item.cellX < 0 || item.cellY < 0 || item.cellX >= this.mContent.getCountX() || item.cellY >= this.mContent.getCountY()) {
            Log.e(TAG, "Folder order not properly persisted during bind");
            if (!findAndSetEmptyCells(item)) {
                return false;
            }
        }
        CellLayout.LayoutParams lp = new CellLayout.LayoutParams(item.cellX, item.cellY, item.spanX, item.spanY);
        textView.setOnKeyListener(new FolderKeyEventListener());
        this.mContent.addViewToCellLayout(textView, 0 == 0 ? -1 : 0, (int) item.id, lp, true);
        return true;
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragEnter(DropTarget.DragObject d) {
        this.mPreviousTargetCell[0] = -1;
        this.mPreviousTargetCell[1] = -1;
        this.mOnExitAlarm.cancelAlarm();
    }

    boolean readingOrderGreaterThan(int[] v1, int[] v2) {
        return v1[1] > v2[1] || (v1[1] == v2[1] && v1[0] > v2[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realTimeReorder(int[] empty, int[] target) {
        int delay = 0;
        float delayAmount = 30.0f;
        if (readingOrderGreaterThan(target, empty)) {
            boolean wrap = empty[0] >= this.mContent.getCountX() + (-1);
            int startY = wrap ? empty[1] + 1 : empty[1];
            int y = startY;
            while (y <= target[1]) {
                int startX = y == empty[1] ? empty[0] + 1 : 0;
                int endX = y < target[1] ? this.mContent.getCountX() - 1 : target[0];
                for (int x = startX; x <= endX; x++) {
                    View v = this.mContent.getChildAt(x, y);
                    if (this.mContent.animateChildToPosition(v, empty[0], empty[1], 230, delay, true, true)) {
                        empty[0] = x;
                        empty[1] = y;
                        delay = (int) (delay + delayAmount);
                        delayAmount = (float) (delayAmount * 0.9d);
                    }
                }
                y++;
            }
            return;
        }
        boolean wrap2 = empty[0] == 0;
        int startY2 = wrap2 ? empty[1] - 1 : empty[1];
        int y2 = startY2;
        while (y2 >= target[1]) {
            int startX2 = y2 == empty[1] ? empty[0] - 1 : this.mContent.getCountX() - 1;
            int endX2 = y2 > target[1] ? 0 : target[0];
            for (int x2 = startX2; x2 >= endX2; x2--) {
                View v2 = this.mContent.getChildAt(x2, y2);
                if (this.mContent.animateChildToPosition(v2, empty[0], empty[1], 230, delay, true, true)) {
                    empty[0] = x2;
                    empty[1] = y2;
                    delay = (int) (delay + delayAmount);
                    delayAmount = (float) (delayAmount * 0.9d);
                }
            }
            y2--;
        }
    }

    public boolean isLayoutRtl() {
        return getLayoutDirection() == android.view.View.LAYOUT_DIRECTION_RTL;
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragOver(DropTarget.DragObject d) {
        LogPreview.show("onDragOver(DragObject d)...");
        DragView dragView = d.dragView;
        int scrollOffset = this.mScrollView.getScrollY();
        float[] r = getDragViewVisualCenter(d.x, d.y, d.xOffset, d.yOffset, dragView, null);
        r[0] = r[0] - getPaddingLeft();
        r[1] = r[1] - getPaddingTop();
        long downTime = SystemClock.uptimeMillis();
        MotionEvent translatedEv = MotionEvent.obtain(downTime, downTime, 2, d.x, d.y, 0);
        if (!this.mAutoScrollHelper.isEnabled()) {
            this.mAutoScrollHelper.setEnabled(true);
        }
        boolean handled = this.mAutoScrollHelper.onTouch(this, translatedEv);
        translatedEv.recycle();
        if (handled) {
            this.mReorderAlarm.cancelAlarm();
            return;
        }
        this.mTargetCell = this.mContent.findNearestArea((int) r[0], ((int) r[1]) + scrollOffset, 1, 1, this.mTargetCell);
        if (isLayoutRtl()) {
            this.mTargetCell[0] = (this.mContent.getCountX() - this.mTargetCell[0]) - 1;
        }
        if (this.mTargetCell[0] != this.mPreviousTargetCell[0] || this.mTargetCell[1] != this.mPreviousTargetCell[1]) {
            this.mReorderAlarm.cancelAlarm();
            this.mReorderAlarm.setOnAlarmListener(this.mReorderAlarmListener);
            this.mReorderAlarm.setAlarm(250L);
            this.mPreviousTargetCell[0] = this.mTargetCell[0];
            this.mPreviousTargetCell[1] = this.mTargetCell[1];
            this.mDragMode = this.DRAG_MODE_REORDER;
            return;
        }
        this.mDragMode = this.DRAG_MODE_NONE;
    }

    private float[] getDragViewVisualCenter(int x, int y, int xOffset, int yOffset, DragView dragView, float[] recycle) {
        float[] res;
        if (recycle == null) {
            res = new float[2];
        } else {
            res = recycle;
        }
        int left = x - xOffset;
        int top = y - yOffset;
        res[0] = (dragView.getDragRegion().width() / 2) + left;
        res[1] = (dragView.getDragRegion().height() / 2) + top;
        return res;
    }

    public void completeDragExit() {
        this.mLauncher.closeFolder();
        this.mCurrentDragInfo = null;
        this.mCurrentDragView = null;
        this.mSuppressOnAdd = false;
        this.mRearrangeOnClose = true;
    }

    @Override // com.android.launcher66.DropTarget
    public void onDragExit(DropTarget.DragObject d) {
        this.mAutoScrollHelper.setEnabled(false);
        if (!d.dragComplete) {
            this.mOnExitAlarm.setOnAlarmListener(this.mOnExitAlarmListener);
            this.mOnExitAlarm.setAlarm(800L);
        }
        this.mReorderAlarm.cancelAlarm();
        this.mDragMode = this.DRAG_MODE_NONE;
    }

    @Override // com.android.launcher66.DragSource
    public void onDropCompleted(final View target, final DropTarget.DragObject d, final boolean isFlingToDelete, final boolean success) {
        if (this.mDeferDropAfterUninstall) {
            Log.d(TAG, "Deferred handling drop because waiting for uninstall.");
            this.mDeferredAction = new Runnable() { // from class: com.android.launcher66.Folder.6
                @Override // java.lang.Runnable
                public void run() {
                    Folder.this.onDropCompleted(target, d, isFlingToDelete, success);
                    Folder.this.mDeferredAction = null;
                }
            };
            return;
        }
        boolean beingCalledAfterUninstall = this.mDeferredAction != null;
        boolean successfulDrop = success && (!beingCalledAfterUninstall || this.mUninstallSuccessful);
        if (successfulDrop) {
            if (this.mDeleteFolderOnDropCompleted && !this.mItemAddedBackToSelfViaIcon) {
                replaceFolderWithFinalItem();
            }
        } else {
            setupContentForNumItems(getItemCount());
            this.mFolderIcon.onDrop(d);
        }
        if (target != this && this.mOnExitAlarm.alarmPending()) {
            this.mOnExitAlarm.cancelAlarm();
            if (!successfulDrop) {
                this.mSuppressFolderDeletion = true;
            }
            completeDragExit();
        }
        this.mDeleteFolderOnDropCompleted = false;
        this.mDragInProgress = false;
        this.mItemAddedBackToSelfViaIcon = false;
        this.mCurrentDragInfo = null;
        this.mCurrentDragView = null;
        this.mSuppressOnAdd = false;
        updateItemLocationsInDatabaseBatch();
    }

    public void deferCompleteDropAfterUninstallActivity() {
        this.mDeferDropAfterUninstall = true;
    }

    public void onUninstallActivityReturned(boolean success) {
        this.mDeferDropAfterUninstall = false;
        this.mUninstallSuccessful = success;
        if (this.mDeferredAction != null) {
            this.mDeferredAction.run();
        }
    }

    @Override // com.android.launcher66.DragSource
    public boolean supportsFlingToDelete() {
        return true;
    }

    @Override // com.android.launcher66.DropTarget
    public void onFlingToDelete(DropTarget.DragObject d, int x, int y, PointF vec) {
    }

    @Override // com.android.launcher66.DragSource
    public void onFlingToDeleteCompleted() {
    }

    private void updateItemLocationsInDatabase() {
        ArrayList<View> list = getItemsInReadingOrder();
        for (int i = 0; i < list.size(); i++) {
            View v = list.get(i);
            ItemInfo info = (ItemInfo) v.getTag();
            LauncherModel.moveItemInDatabase(this.mLauncher, info, this.mInfo.id, 0L, info.cellX, info.cellY);
        }
    }

    private void updateItemLocationsInDatabaseBatch() {
        ArrayList<View> list = getItemsInReadingOrder();
        ArrayList<ItemInfo> items = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            View v = list.get(i);
            ItemInfo info = (ItemInfo) v.getTag();
            items.add(info);
        }
        LauncherModel.moveItemsInDatabase(this.mLauncher, items, this.mInfo.id, 0);
    }

    public void addItemLocationsInDatabase() {
        ArrayList<View> list = getItemsInReadingOrder();
        for (int i = 0; i < list.size(); i++) {
            View v = list.get(i);
            ItemInfo info = (ItemInfo) v.getTag();
            LauncherModel.addItemToDatabase(this.mLauncher, info, this.mInfo.id, 0L, info.cellX, info.cellY, false);
        }
    }

    public void notifyDrop() {
        if (this.mDragInProgress) {
            this.mItemAddedBackToSelfViaIcon = true;
        }
    }

    @Override // com.android.launcher66.DropTarget
    public boolean isDropEnabled() {
        return true;
    }

    private void setupContentDimensions(int count) {
        ArrayList<View> list = getItemsInReadingOrder();
        int countX = this.mContent.getCountX();
        int countY = this.mContent.getCountY();
        boolean done = false;
        while (!done) {
            int oldCountX = countX;
            int oldCountY = countY;
            if (countX * countY < count) {
                if ((countX <= countY || countY == this.mMaxCountY) && countX < this.mMaxCountX) {
                    countX++;
                } else if (countY < this.mMaxCountY) {
                    countY++;
                }
                if (countY == 0) {
                    countY++;
                }
            } else if ((countY - 1) * countX >= count && countY >= countX) {
                countY = Math.max(0, countY - 1);
            } else if ((countX - 1) * countY >= count) {
                countX = Math.max(0, countX - 1);
            }
            done = countX == oldCountX && countY == oldCountY;
        }
        this.mContent.setGridSize(countX, countY);
        arrangeChildren(list);
    }

    public boolean isFull() {
        return getItemCount() >= this.mMaxNumItems;
    }

    private void centerAboutIcon() {
        DragLayer.LayoutParams lp = (DragLayer.LayoutParams) getLayoutParams();
        DragLayer parent = (DragLayer) this.mLauncher.findViewById(R.id.drag_layer);
        int width = getPaddingLeft() + getPaddingRight() + this.mContent.getDesiredWidth();
        int height = getFolderHeight();
        float scale = parent.getDescendantRectRelativeToSelf(this.mFolderIcon, this.mTempRect);
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        int centerX = (int) (this.mTempRect.left + ((this.mTempRect.width() * scale) / 2.0f));
        int centerY = (int) (this.mTempRect.top + ((this.mTempRect.height() * scale) / 2.0f));
        int centeredLeft = centerX - (width / 2);
        int centeredTop = centerY - (height / 2);
        int currentPage = this.mLauncher.getWorkspace().getNextPage();
        this.mLauncher.getWorkspace().setFinalScrollForPageChange(currentPage);
        CellLayout currentLayout = (CellLayout) this.mLauncher.getWorkspace().getChildAt(currentPage);
        ShortcutAndWidgetContainer boundingLayout = currentLayout.getShortcutsAndWidgets();
        Rect bounds = new Rect();
        parent.getDescendantRectRelativeToSelf(boundingLayout, bounds);
        this.mLauncher.getWorkspace().resetFinalScrollForPageChange(currentPage);
        int left = Math.min(Math.max(bounds.left, centeredLeft), (bounds.left + bounds.width()) - width);
        int top = Math.min(Math.max(bounds.top, centeredTop), (bounds.top + bounds.height()) - height);
        if (grid.isPhone() && grid.availableWidthPx - width < grid.iconSizePx) {
            left = (grid.availableWidthPx - width) / 2;
        } else if (width >= bounds.width()) {
            left = bounds.left + ((bounds.width() - width) / 2);
        }
        if (height >= bounds.height()) {
            top = bounds.top + ((bounds.height() - height) / 2);
        }
        int folderPivotX = (width / 2) + (centeredLeft - left);
        int folderPivotY = (height / 2) + (centeredTop - top);
        setPivotX(folderPivotX);
        setPivotY(folderPivotY);
        this.mFolderIconPivotX = (int) (this.mFolderIcon.getMeasuredWidth() * ((1.0f * folderPivotX) / width));
        this.mFolderIconPivotY = (int) (this.mFolderIcon.getMeasuredHeight() * ((1.0f * folderPivotY) / height));
        lp.width = width;
        lp.height = height;
        lp.x = left;
        lp.y = top;
    }

    float getPivotXForIconAnimation() {
        return this.mFolderIconPivotX;
    }

    float getPivotYForIconAnimation() {
        return this.mFolderIconPivotY;
    }

    private void setupContentForNumItems(int count) {
        setupContentDimensions(count);
        if (((DragLayer.LayoutParams) getLayoutParams()) == null) {
            DragLayer.LayoutParams lp = new DragLayer.LayoutParams(0, 0);
            lp.customPosition = true;
            setLayoutParams(lp);
        }
        centerAboutIcon();
    }

    private int getContentAreaHeight() {
        LauncherAppState app = LauncherAppState.getInstance();
        DeviceProfile grid = app.getDynamicGrid().getDeviceProfile();
        Rect workspacePadding = grid.getWorkspacePadding(grid.isLandscape ? 0 : 1);
        int maxContentAreaHeight = (((((grid.availableHeightPx - (grid.edgeMarginPx * 4)) - workspacePadding.top) - workspacePadding.bottom) - getPaddingTop()) - getPaddingBottom()) - this.mFolderNameHeight;
        return Math.min(maxContentAreaHeight, this.mContent.getDesiredHeight());
    }

    private int getFolderHeight() {
        int height = getPaddingTop() + getPaddingBottom() + getContentAreaHeight() + this.mFolderNameHeight;
        return height;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getPaddingLeft() + getPaddingRight() + this.mContent.getDesiredWidth();
        int height = getFolderHeight();
        int contentAreaWidthSpec = View.MeasureSpec.makeMeasureSpec(this.mContent.getDesiredWidth(), MeasureSpec.EXACTLY);
        int contentAreaHeightSpec = View.MeasureSpec.makeMeasureSpec(getContentAreaHeight(), MeasureSpec.EXACTLY);
        this.mContent.setFixedSize(this.mContent.getDesiredWidth(), this.mContent.getDesiredHeight());
        this.mScrollView.measure(contentAreaWidthSpec, contentAreaHeightSpec);
        this.mFolderName.measure(contentAreaWidthSpec, View.MeasureSpec.makeMeasureSpec(this.mFolderNameHeight, View.MeasureSpec.EXACTLY));
        setMeasuredDimension(width, height);
    }

    private void arrangeChildren(ArrayList<View> list) {
        int[] vacant = new int[2];
        if (list == null) {
            list = getItemsInReadingOrder();
        }
        this.mContent.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            View v = list.get(i);
            this.mContent.getVacantCell(vacant, 1, 1);
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) v.getLayoutParams();
            lp.cellX = vacant[0];
            lp.cellY = vacant[1];
            ItemInfo info = (ItemInfo) v.getTag();
            if (info.cellX != vacant[0] || info.cellY != vacant[1]) {
                info.cellX = vacant[0];
                info.cellY = vacant[1];
                LauncherModel.addOrMoveItemInDatabase(this.mLauncher, info, this.mInfo.id, 0L, info.cellX, info.cellY);
            }
            this.mContent.addViewToCellLayout(v, 0 != 0 ? 0 : -1, (int) info.id, lp, true);
        }
        this.mItemsInvalidated = true;
    }

    public int getItemCount() {
        return this.mContent.getShortcutsAndWidgets().getChildCount();
    }

    public View getItemAt(int index) {
        return this.mContent.getShortcutsAndWidgets().getChildAt(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseComplete() {
        DragLayer parent = (DragLayer) getParent();
        if (parent != null) {
            parent.removeView(this);
        }
        this.mDragController.removeDropTarget(this);
        clearFocus();
        this.mFolderIcon.requestFocus();
        if (this.mRearrangeOnClose) {
            setupContentForNumItems(getItemCount());
            this.mRearrangeOnClose = false;
        }
        if (getItemCount() <= 1) {
            if (!this.mDragInProgress && !this.mSuppressFolderDeletion) {
                replaceFolderWithFinalItem();
            } else if (this.mDragInProgress) {
                this.mDeleteFolderOnDropCompleted = true;
            }
        }
        this.mSuppressFolderDeletion = false;
    }

    private void replaceFolderWithFinalItem() {
        Runnable onCompleteRunnable = new Runnable() { // from class: com.android.launcher66.Folder.7
            @Override // java.lang.Runnable
            public void run() {
                CellLayout cellLayout = Folder.this.mLauncher.getCellLayout(Folder.this.mInfo.container, Folder.this.mInfo.screenId);
                View child = null;
                if (Folder.this.getItemCount() == 1) {
                    ShortcutInfo finalItem = Folder.this.mInfo.contents.get(0);
                    View child2 = Folder.this.mLauncher.createShortcut(R.layout.application, cellLayout, finalItem);
                    LauncherModel.addOrMoveItemInDatabase(Folder.this.mLauncher, finalItem, Folder.this.mInfo.container, Folder.this.mInfo.screenId, Folder.this.mInfo.cellX, Folder.this.mInfo.cellY);
                    child = child2;
                }
                if (Folder.this.getItemCount() <= 1) {
                    LauncherModel.deleteItemFromDatabase(Folder.this.mLauncher, Folder.this.mInfo);
                    cellLayout.removeView(Folder.this.mFolderIcon);
                    if (Folder.this.mFolderIcon instanceof DropTarget) {
                        Folder.this.mDragController.removeDropTarget((DropTarget) Folder.this.mFolderIcon);
                    }
                    Folder.this.mLauncher.removeFolder(Folder.this.mInfo);
                }
                if (child != null) {
                    Folder.this.mLauncher.getWorkspace().addInScreenFromBind(child, Folder.this.mInfo.container, Folder.this.mInfo.screenId, Folder.this.mInfo.cellX, Folder.this.mInfo.cellY, Folder.this.mInfo.spanX, Folder.this.mInfo.spanY);
                }
            }
        };
        View finalChild = getItemAt(0);
        if (finalChild != null) {
            this.mFolderIcon.performDestroyAnimation(finalChild, onCompleteRunnable);
        }
        this.mDestroyed = true;
    }

    boolean isDestroyed() {
        return this.mDestroyed;
    }

    private void updateTextViewFocus() {
        View lastChild = getItemAt(getItemCount() - 1);
        getItemAt(getItemCount() - 1);
        if (lastChild != null) {
            this.mFolderName.setNextFocusDownId(lastChild.getId());
            this.mFolderName.setNextFocusRightId(lastChild.getId());
            this.mFolderName.setNextFocusLeftId(lastChild.getId());
            this.mFolderName.setNextFocusUpId(lastChild.getId());
        }
    }

    @Override // com.android.launcher66.DropTarget
    public void onDrop(DropTarget.DragObject d) {
        ShortcutInfo item;
        if (d.dragInfo instanceof AppInfo) {
            item = ((AppInfo) d.dragInfo).makeShortcut();
            item.spanX = 1;
            item.spanY = 1;
        } else {
            item = (ShortcutInfo) d.dragInfo;
        }
        if (item == this.mCurrentDragInfo) {
            ShortcutInfo si = (ShortcutInfo) this.mCurrentDragView.getTag();
            CellLayout.LayoutParams lp = (CellLayout.LayoutParams) this.mCurrentDragView.getLayoutParams();
            int i = this.mEmptyCell[0];
            lp.cellX = i;
            si.cellX = i;
            int i2 = this.mEmptyCell[1];
            lp.cellY = i2;
            si.cellX = i2;
            this.mContent.addViewToCellLayout(this.mCurrentDragView, -1, (int) item.id, lp, true);
            if (d.dragView.hasDrawn()) {
                this.mLauncher.getDragLayer().animateViewIntoPosition(d.dragView, this.mCurrentDragView);
            } else {
                d.deferDragViewCleanupPostAnimation = false;
                this.mCurrentDragView.setVisibility(View.VISIBLE);
            }
            this.mItemsInvalidated = true;
            setupContentDimensions(getItemCount());
            this.mSuppressOnAdd = true;
        }
        this.mInfo.add(item);
    }

    public void hideItem(ShortcutInfo info) {
        View v = getViewForInfo(info);
        v.setVisibility(android.view.View.INVISIBLE);
    }

    public void showItem(ShortcutInfo info) {
        View v = getViewForInfo(info);
        v.setVisibility(android.view.View.VISIBLE);
    }

    @Override // com.android.launcher66.FolderInfo.FolderListener
    public void onAdd(ShortcutInfo item) {
        this.mItemsInvalidated = true;
        if (!this.mSuppressOnAdd) {
            if (!findAndSetEmptyCells(item)) {
                setupContentForNumItems(getItemCount() + 1);
                findAndSetEmptyCells(item);
            }
            createAndAddShortcut(item);
            LauncherModel.addOrMoveItemInDatabase(this.mLauncher, item, this.mInfo.id, 0L, item.cellX, item.cellY);
        }
    }

    @Override // com.android.launcher66.FolderInfo.FolderListener
    public void onRemove(ShortcutInfo item) {
        this.mItemsInvalidated = true;
        if (item != this.mCurrentDragInfo) {
            View v = getViewForInfo(item);
            this.mContent.removeView(v);
            if (this.mState == 1) {
                this.mRearrangeOnClose = true;
            } else {
                setupContentForNumItems(getItemCount());
            }
            if (getItemCount() <= 1) {
                replaceFolderWithFinalItem();
            }
        }
    }

    private View getViewForInfo(ShortcutInfo item) {
        for (int j = 0; j < this.mContent.getCountY(); j++) {
            for (int i = 0; i < this.mContent.getCountX(); i++) {
                View v = this.mContent.getChildAt(i, j);
                if (v.getTag() == item) {
                    return v;
                }
            }
        }
        return null;
    }

    @Override // com.android.launcher66.FolderInfo.FolderListener
    public void onItemsChanged() {
        updateTextViewFocus();
    }

    @Override // com.android.launcher66.FolderInfo.FolderListener
    public void onTitleChanged(CharSequence title) {
    }

    public ArrayList<View> getItemsInReadingOrder() {
        if (this.mItemsInvalidated) {
            this.mItemsInReadingOrder.clear();
            for (int j = 0; j < this.mContent.getCountY(); j++) {
                for (int i = 0; i < this.mContent.getCountX(); i++) {
                    View v = this.mContent.getChildAt(i, j);
                    if (v != null) {
                        this.mItemsInReadingOrder.add(v);
                    }
                }
            }
            this.mItemsInvalidated = false;
        }
        return this.mItemsInReadingOrder;
    }

    @Override // com.android.launcher66.DropTarget
    public void getLocationInDragLayer(int[] loc) {
        this.mLauncher.getDragLayer().getLocationInDragLayer(this, loc);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v, boolean hasFocus) {
        if (v == this.mFolderName && hasFocus) {
            startEditingFolderName();
        }
    }

    @Override // com.android.launcher66.DropTarget
    public void getHitRectRelativeToDragLayer(Rect outRect) {
        getHitRect(outRect);
    }
}
