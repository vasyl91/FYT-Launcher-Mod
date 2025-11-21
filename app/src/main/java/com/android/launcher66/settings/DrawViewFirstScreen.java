package com.android.launcher66.settings;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.android.launcher66.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawViewFirstScreen extends View implements View.OnClickListener {

    // Core
    private final SharedPreferences sharedPrefs;
    private LayoutInflater mInflater;
    private View mRootView;
    private WeakReference<Context> mContextWeakRef;
    private Helpers helpers;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mInvalidateRunnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    // Rectangles
    private final List<RectangleConfig> rectangleConfigs = new ArrayList<>();
    private final Map<String, Paint> rectanglePaints = new HashMap<>();
    private final Map<String, Integer[]> rectangleBallIds = new HashMap<>();

    // Points & handles
    private final ArrayList<ColorBall> colorballs = new ArrayList<>();
    private final Point[] point = new Point[400];
    private int nextBallId = 0;

    // UI
    private GestureDetector gestureDetector;
    private Button mTopDown, mBottomUp, mLeftToLeft, mLeftToRight, mRightToLeft, mRightToRight, mTopUp, mBottomDown, mConfirmLayout;
    private TextView rectangleName;
    private AlertDialog alertDialog;

    // Sizing / prefs
    private final int margin;
    private final int nameTextSize;
    private float handleRadiusPx;
    private float coordinatesMargin;

    // Interaction
    private String selectedWidgetKey = null;
    private int activeBallId = -1;
    private String activeRectKey = null;
    private boolean draggingWholeRect = false;
    private boolean draggingEdge = false;
    private int activeEdgeIndex = -1; // 0=top, 1=right, 2=bottom, 3=left
    private int lastX = 0, lastY = 0;

    // Bounds
    private int minBorderX, minBorderY, maxBorderX, maxBorderY;

    private static boolean firstPip = false;
    private static boolean secondPip = false;
    private static boolean thirdPip = false;
    private static boolean fourthPip = false;

    public DrawViewFirstScreen(LayoutInflater inflater, View rootView, Context context) {
        super(context);
        this.mContextWeakRef = new WeakReference<>(context);
        this.mInflater = inflater;
        this.mRootView = rootView;
        this.sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.margin = Integer.parseInt(sharedPrefs.getString("layout_margin", "10"));
        this.nameTextSize = SettingsActivity.adaptiveNameTextSize;        
        firstPip = sharedPrefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = sharedPrefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = sharedPrefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = sharedPrefs.getBoolean(Keys.PIP_FOURTH, false);
        initUi(rootView);
    }

    public DrawViewFirstScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContextWeakRef = new WeakReference<>(context);
        this.sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.margin = Integer.parseInt(sharedPrefs.getString("layout_margin", "10"));
        this.nameTextSize = SettingsActivity.adaptiveNameTextSize;     
        firstPip = sharedPrefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = sharedPrefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = sharedPrefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = sharedPrefs.getBoolean(Keys.PIP_FOURTH, false);
        initUi(null);
    }

    public DrawViewFirstScreen(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContextWeakRef = new WeakReference<>(context);
        this.sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.margin = Integer.parseInt(sharedPrefs.getString("layout_margin", "10"));
        this.nameTextSize = SettingsActivity.adaptiveNameTextSize;     
        firstPip = sharedPrefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = sharedPrefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = sharedPrefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = sharedPrefs.getBoolean(Keys.PIP_FOURTH, false);
        initUi(null);
    }

    private Context getSafeContext() {
        return mContextWeakRef != null ? mContextWeakRef.get() : null;
    }

    public void addRectangle(String name, String key, String color, boolean shouldIntersect) {
        int minWidth = SettingsActivity.calculatedPipMinWidth;
        int minHeight = SettingsActivity.calculatedPipMinHeight;
        boolean enabled = false;
        boolean pip = sharedPrefs.getBoolean(Keys.DISPLAY_PIP, false);
        boolean dualPip = sharedPrefs.getBoolean(Keys.PIP_DUAL, false);

        switch (key) {
            case "pipDual":
                if (compareScreens(Keys.PIP_DUAL_SCREEN)) {
                    minWidth = SettingsActivity.calculatedPipMinWidth;
                    minHeight = SettingsActivity.calculatedPipMinHeight;
                    if (pip && dualPip && !firstPip && !secondPip) {
                        enabled = true;
                    }
                }
                break;
            case "pipFirst":
                if (compareScreens(Keys.PIP_FIRST_SCREEN)) {
                    minWidth = SettingsActivity.calculatedPipMinWidth / countEnabledPips();
                    minHeight = SettingsActivity.calculatedPipMinHeight;
                    if (pip && firstPip && !dualPip) {
                        enabled = true;
                    }
                }
                break;
            case "pipSecond":
                if (compareScreens(Keys.PIP_SECOND_SCREEN)) {
                    minWidth = SettingsActivity.calculatedPipMinWidth / countEnabledPips();
                    minHeight = SettingsActivity.calculatedPipMinHeight;
                    if (pip && secondPip && !dualPip) {
                        enabled = true;
                    }
                }
                break;
            case "pipThird":
                if (compareScreens(Keys.PIP_THIRD_SCREEN)) {
                    minWidth = SettingsActivity.calculatedPipMinWidth / countEnabledPips();
                    minHeight = SettingsActivity.calculatedPipMinHeight;                
                    if (pip && thirdPip) {
                        enabled = true;
                    }
                }
                break;
            case "pipFourth":
                if (compareScreens(Keys.PIP_FOURTH_SCREEN)) {
                    minWidth = SettingsActivity.calculatedPipMinWidth / countEnabledPips();
                    minHeight = SettingsActivity.calculatedPipMinHeight;
                    if (pip && fourthPip) {
                        enabled = true;
                    }
                }
                break;
            case "date":
                if (compareScreens(Keys.DATE_SCREEN)) {
                    minWidth = SettingsActivity.calculatedDateMinWidth;
                    minHeight = SettingsActivity.calculatedDateMinHeight;
                    enabled = sharedPrefs.getBoolean(Keys.USER_DATE, false);
                }
                break;
            case "music":
                if (compareScreens(Keys.MUSIC_SCREEN)) {
                    minWidth = SettingsActivity.calculatedMusicMinWidth;
                    minHeight = SettingsActivity.calculatedMusicMinHeight;
                    enabled = sharedPrefs.getBoolean(Keys.USER_MUSIC, false);
                }
                break;
            case "radio":
                if (compareScreens(Keys.RADIO_SCREEN)) {
                    minWidth = SettingsActivity.calculatedRadioMinWidth;
                    minHeight = SettingsActivity.calculatedRadioMinHeight;
                    enabled = sharedPrefs.getBoolean(Keys.USER_RADIO, false);
                }
                break;
            case "stats":
                if (compareScreens(Keys.STATS_SCREEN)) {
                    minWidth = SettingsActivity.calculatedStatsWidth;
                    minHeight = SettingsActivity.calculatedStatsHeight;
                    enabled = sharedPrefs.getBoolean(Keys.USER_STATS, true);
                }
                break;
            default:
                minWidth = SettingsActivity.calculatedDateMinWidth;
                minHeight = SettingsActivity.calculatedDateMinHeight;
                enabled = true;
        }

        RectangleConfig config = new RectangleConfig(name, key, color, shouldIntersect, minWidth, minHeight, enabled);
        rectangleConfigs.add(config);

        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.parseColor(color));
        p.setStyle(Paint.Style.FILL);
        p.setAlpha(128);
        rectanglePaints.put(key, p);

        Integer[] ballIds = new Integer[]{nextBallId++, nextBallId++, nextBallId++, nextBallId++};
        rectangleBallIds.put(key, ballIds);

        if (config.enabled) {
            initRectangle(config);
        }
        invalidate();
    }

    // Never returns 0, max value is 2
    private static int countEnabledPips() {
        int count = 0;
        if (firstPip) count++;
        if (secondPip) count++;
        if (thirdPip) count++;
        if (fourthPip) count++;
        return Math.min(Math.max(1, count), 2);
    }

    private void initUi(View rootView) {
        helpers = new Helpers();
        helpers.checkAndResetIfOverlappingOnScreen(-1); 
        helpers.setUserOpenedCreator(true);
        helpers.setBarSettingsChanged(false);

        handleRadiusPx = 20f * getResources().getDisplayMetrics().density;

        if (rootView != null) {
            rectangleName = rootView.findViewById(R.id.rectangle_name);

            if (sharedPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false)) {
                View creatorBar = rootView.findViewById(R.id.creator_bar); 
                View creatorBarAutoHide = rootView.findViewById(R.id.creator_bar_auto_hide); 
                View creatorView = rootView.findViewById(R.id.creator_first_screen);   
                gestureDetector = new GestureDetector(getSafeContext(), new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onDoubleTap(MotionEvent e) {
                        if (creatorBar.getVisibility() == View.VISIBLE) {
                            creatorBar.setVisibility(View.GONE); 
                            creatorBarAutoHide.setVisibility(View.VISIBLE); 
                        } else {
                            creatorBar.setVisibility(View.VISIBLE); 
                            creatorBarAutoHide.setVisibility(View.GONE); 
                        }
                        return true; 
                    }
                });

                creatorView.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        boolean gestureHandled = gestureDetector.onTouchEvent(event);
                        if (gestureHandled) return true; 
                        return true; 
                    }
                });                
            }

            mTopUp = rootView.findViewById(R.id.top_up);
            mTopDown = rootView.findViewById(R.id.top_down);
            mBottomUp = rootView.findViewById(R.id.bottom_up);
            mBottomDown = rootView.findViewById(R.id.bottom_down);
            mLeftToLeft = rootView.findViewById(R.id.left_to_left);
            mLeftToRight = rootView.findViewById(R.id.left_to_right);
            mRightToLeft = rootView.findViewById(R.id.right_to_left);
            mRightToRight = rootView.findViewById(R.id.right_to_right);
            mConfirmLayout = rootView.findViewById(R.id.confirm_layout);

            if (mTopUp != null) { mTopUp.setOnClickListener(this); setCalculatedButtonSizes(mTopUp, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim); }
            if (mTopDown != null) { mTopDown.setOnClickListener(this); setCalculatedButtonSizes(mTopDown, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim); }
            if (mBottomUp != null) { mBottomUp.setOnClickListener(this); setCalculatedButtonSizes(mBottomUp, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim); }
            if (mBottomDown != null) { mBottomDown.setOnClickListener(this); setCalculatedButtonSizes(mBottomDown, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim); }
            if (mLeftToLeft != null) { mLeftToLeft.setOnClickListener(this); setCalculatedButtonSizes(mLeftToLeft, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim); }
            if (mLeftToRight != null) { mLeftToRight.setOnClickListener(this); setCalculatedButtonSizes(mLeftToRight, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim); }
            if (mRightToLeft != null) { mRightToLeft.setOnClickListener(this); setCalculatedButtonSizes(mRightToLeft, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim); }
            if (mRightToRight != null) { mRightToRight.setOnClickListener(this); setCalculatedButtonSizes(mRightToRight, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim); }
            if (mConfirmLayout != null) { mConfirmLayout.setOnClickListener(this); mConfirmLayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, SettingsActivity.confirmTextSize); }

            setCalculatedTextSize(rootView, R.id.selected_widget_string, SettingsActivity.selectionTextSize);
            setCalculatedTextSize(rootView, R.id.rectangle_name, SettingsActivity.selectionTextSize);
            setCalculatedTextSize(rootView, R.id.top_button_string, SettingsActivity.arrowTextSize);
            setCalculatedTextSize(rootView, R.id.bottom_button_string, SettingsActivity.arrowTextSize);
            setCalculatedTextSize(rootView, R.id.left_button_string, SettingsActivity.arrowTextSize);
            setCalculatedTextSize(rootView, R.id.right_button_string, SettingsActivity.arrowTextSize);

            TextView rectangleName = rootView.findViewById(R.id.rectangle_name);
            rectangleName.setSelected(true);
        }

        for (RectangleConfig cfg : rectangleConfigs) {
            if (cfg.enabled) initRectangle(cfg);
        }
    }

    private void initRectangle(RectangleConfig config) {
        int topLeftX = sharedPrefs.getInt(config.key + "TopLeftX", margin);
        int topLeftY = sharedPrefs.getInt(config.key + "TopLeftY", margin);
        int topRightX = sharedPrefs.getInt(config.key + "TopRightX", margin + config.minWidth);
        int topRightY = sharedPrefs.getInt(config.key + "TopRightY", margin);
        int bottomRightX = sharedPrefs.getInt(config.key + "BottomRightX", margin + config.minWidth);
        int bottomRightY = sharedPrefs.getInt(config.key + "BottomRightY", margin + config.minHeight);
        int bottomLeftX = sharedPrefs.getInt(config.key + "BottomLeftX", margin);
        int bottomLeftY = sharedPrefs.getInt(config.key + "BottomLeftY", margin + config.minHeight);

        int orientation = getResources().getConfiguration().orientation;
        if ((config.key).contains("pip") && !sharedPrefs.contains(config.key + "TopLeftX")) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                topLeftY = margin + getMinHeight("date") + margin;
                bottomRightY = topLeftY + config.minHeight;
                topRightX = margin + config.minWidth;
                bottomRightX = topRightX;
                bottomLeftY = bottomRightY;
            }
        }

        Integer[] ids = rectangleBallIds.get(config.key);
        if (ids == null) return;

        ensurePoint(ids[0], new Point(topLeftX, topLeftY));
        ensurePoint(ids[1], new Point(topRightX, topRightY));
        ensurePoint(ids[2], new Point(bottomRightX, bottomRightY));
        ensurePoint(ids[3], new Point(bottomLeftX, bottomLeftY));

        ensureBall(ids[0], point[ids[0]]);
        ensureBall(ids[1], point[ids[1]]);
        ensureBall(ids[2], point[ids[2]]);
        ensureBall(ids[3], point[ids[3]]);
    }

    private void ensurePoint(int id, Point p) { point[id] = p; }

    private void ensureBall(int id, Point p) {
        int resId = 0;
        try { resId = R.drawable.gray_circle; } catch (Throwable ignored) {}
        while (colorballs.size() <= id) colorballs.add(null);
        colorballs.set(id, new ColorBall(getSafeContext(), resId, p, id));
    }

    private int getMinWidth(String key) {
        for (RectangleConfig c : rectangleConfigs) if (c.key.equals(key)) return c.minWidth;
        return 0;
    }

    private int getMinHeight(String key) {
        for (RectangleConfig c : rectangleConfigs) if (c.key.equals(key)) return c.minHeight;
        return 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Background
        Paint bg = new Paint(Paint.ANTI_ALIAS_FLAG);
        bg.setColor(Color.parseColor("#8c8b8b"));
        bg.setStyle(Paint.Style.FILL);
        canvas.drawPaint(bg);

        // Screen hint
        Paint hint = new Paint(Paint.ANTI_ALIAS_FLAG);
        hint.setColor(Color.parseColor("#cccccc"));
        hint.setTextSize(nameTextSize * 1.2f);
        hint.setTextAlign(Paint.Align.CENTER);
        hint.setShadowLayer(2, 1, 1, Color.WHITE);
        float centerX = getWidth() / 2f;
        if (sharedPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false)) {
            float centerY = SettingsActivity.screenHeight / 2f;
            float lineHeight = hint.getTextSize() * 1.2f; 
            String centerText = getSafeContext().getString(R.string.double_tap, "1");
            String[] lines = centerText.split("\\n");
            float startY = centerY - ((lines.length - 1) * lineHeight / 2f);
            for (int i = 0; i < lines.length; i++) {
                canvas.drawText(lines[i], centerX, startY + (i * lineHeight), hint);
            }
        } else {
            float centerY = getHeight() / 2f;
            String centerText = getSafeContext().getString(R.string.screen_first);
            canvas.drawText(centerText, centerX, centerY, hint);
        }

        // Draw rectangles (and glare if both opted-in and overlapping)
        for (RectangleConfig config : rectangleConfigs) {
            if (!config.enabled) continue;
            drawRectangle(canvas, config);
        }
    }

    private void drawRectangle(Canvas canvas, RectangleConfig config) {
        Integer[] ids = rectangleBallIds.get(config.key);
        Paint p = rectanglePaints.get(config.key);
        if (ids == null || p == null) return;

        RectF r = rectFromBallIds(ids[0], ids[1], ids[2], ids[3]);
        if (r.isEmpty()) return;

        // base fill
        canvas.drawRect(r, p);

        // red glare only when BOTH rectangles opted-in and overlap
        if (config.shouldIntersect) {
            boolean overlapsWithOptIn = false;
            for (RectangleConfig other : rectangleConfigs) {
                if (other == config || !other.enabled) continue;
                if (!other.shouldIntersect) continue;
                Integer[] oids = rectangleBallIds.get(other.key);
                if (oids == null) continue;
                RectF or = rectFromBallIds(oids[0], oids[1], oids[2], oids[3]);
                if (!or.isEmpty() && RectF.intersects(r, or)) { overlapsWithOptIn = true; break; }
            }
            if (overlapsWithOptIn) {
                Paint overlay = new Paint(Paint.ANTI_ALIAS_FLAG);
                overlay.setStyle(Paint.Style.FILL);
                overlay.setColor(Color.RED);
                overlay.setAlpha(255);
                canvas.drawRect(r, overlay);
            }
        }

        // border
        Paint border = new Paint(Paint.ANTI_ALIAS_FLAG);
        border.setColor(Color.BLACK);
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeWidth(2f);
        canvas.drawRect(r, border);

        // coordinates overlay
        drawCoordinates(canvas, r);

        // center label
        drawLabel(canvas, r, config.name);
    }

    private void drawLabel(Canvas canvas, RectF r, String label) {
        if (label == null) return;
        
        // Create text paint
        Paint txt = new Paint(Paint.ANTI_ALIAS_FLAG);
        txt.setColor(Color.BLACK);
        txt.setTextSize(nameTextSize);
        txt.setShadowLayer(2, 1, 1, Color.WHITE);
        
        float textWidth = txt.measureText(label);
        float rectWidth = r.width();
        float maxTextWidth = rectWidth - (coordinatesMargin * 1.5f);
        float cx = (r.left + r.right) / 2f;
        float cy = (r.top + r.bottom) / 2f + nameTextSize / 3f;
        
        // Check if text width exceeds 60% of rectangle width
        if (textWidth > maxTextWidth) {
            // Calculate scroll parameters
            float scrollWidth = textWidth - maxTextWidth;
            float scrollProgress = (System.currentTimeMillis() % 5000) / 5000f; // 5 second cycle
            float xOffset = scrollWidth * scrollProgress;
            
            // Create clipping rectangle that is 60% of the original rectangle width, centered
            float clipLeft = cx - maxTextWidth / 2f;
            float clipRight = cx + maxTextWidth / 2f;
            RectF clipRect = new RectF(clipLeft, r.top, clipRight, r.bottom);
            
            // Clip to the 80% width area and draw scrolling text
            canvas.save();
            canvas.clipRect(clipRect);
            canvas.drawText(label, cx - textWidth / 2f - xOffset, cy, txt);
            canvas.restore();
            
            // Invalidate to trigger redraw for animation
            mHandler.postDelayed(mInvalidateRunnable, 16); // ~60 FPS
        } else {
            // Center text if it fits
            canvas.drawText(label, cx - textWidth / 2f, cy, txt);
        }
    }

    // Draw numeric coordinates around the rectangle (top, left, bottom, right)
    private void drawCoordinates(Canvas canvas, RectF r) {
        if (r == null || r.isEmpty()) return;

        // Text paint for coordinates
        Paint coordinatesText = new Paint(Paint.ANTI_ALIAS_FLAG);
        coordinatesText.setColor(Color.BLACK);
        // Slightly smaller than the name text size for readability
        float size = Math.max(10f, nameTextSize * 0.6f);
        coordinatesText.setTextSize(size);
        coordinatesText.setShadowLayer(2, 1, 1, Color.WHITE);

        // Values to display
        String topVal = String.valueOf((int) r.top);
        String leftVal = String.valueOf((int) r.left);
        String bottomVal = String.valueOf((int) r.bottom);
        String rightVal = String.valueOf((int) r.right);

        // Basic padding in dp
        float pad = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());

        // Common positions
        float cx = (r.left + r.right) / 2f;
        float midY = (r.top + r.bottom) / 2f + coordinatesText.getTextSize() / 3f; // vertical centering tweak

        // --- Top --- (centered on top edge, slightly inside)
        float topW = coordinatesText.measureText(topVal);
        canvas.drawText(topVal, cx - topW / 2f, r.top + coordinatesText.getTextSize() - pad, coordinatesText);

        // --- Bottom --- (centered on bottom edge, slightly above the border)
        float bottomW = coordinatesText.measureText(bottomVal);
        canvas.drawText(bottomVal, cx - bottomW / 2f, r.bottom - pad, coordinatesText);

        // --- Left --- (inside left edge with padding)
        float leftW = coordinatesText.measureText(leftVal);
        canvas.drawText(leftVal, r.left + pad, midY, coordinatesText);

        // --- Right --- (inside right edge with padding)
        float rightW = coordinatesText.measureText(rightVal);
        canvas.drawText(rightVal, r.right - rightW - pad, midY, coordinatesText);

        coordinatesMargin = leftW + rightW;
    }

    private RectF rectFromBallIds(int tl, int tr, int br, int bl) {
        Point ptl = (tl >= 0 && tl < point.length) ? point[tl] : null;
        Point ptr = (tr >= 0 && tr < point.length) ? point[tr] : null;
        Point pbr = (br >= 0 && br < point.length) ? point[br] : null;
        Point pbl = (bl >= 0 && bl < point.length) ? point[bl] : null;
        if (ptl == null || ptr == null || pbr == null || pbl == null) return new RectF();
        float left = Math.min(ptl.x, pbl.x);
        float right = Math.max(ptr.x, pbr.x);
        float top = Math.min(ptl.y, ptr.y);
        float bottom = Math.max(pbl.y, pbr.y);
        if (right <= left || bottom <= top) return new RectF();
        return new RectF(left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int X = (int) event.getX();
        final int Y = (int) event.getY();

        if (sharedPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false) && gestureDetector.onTouchEvent(event)) {
            return true;
        }

        minBorderX = margin;
        minBorderY = margin;
        maxBorderX = getWidth() - margin;
        maxBorderY = getHeight() - margin;

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN: {
                // First, check for corner ball hit
                activeBallId = hitTestBall(X, Y);
                if (activeBallId >= 0) {
                    activeRectKey = findRectKeyByBall(activeBallId);
                    selectedWidgetKey = activeRectKey;
                    updateSelectedLabel();
                    draggingWholeRect = false;
                    draggingEdge = false;
                    lastX = X; lastY = Y;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }

                // Check if inside a rectangle
                String insideKey = hitTestRect(X, Y);
                if (insideKey != null) {
                    // Check for edge hit first
                    int edgeIdx = hitTestEdge(X, Y, insideKey);
                    if (edgeIdx >= 0) {
                        activeRectKey = insideKey;
                        selectedWidgetKey = activeRectKey;
                        updateSelectedLabel();
                        draggingEdge = true;
                        activeEdgeIndex = edgeIdx;
                        draggingWholeRect = false;
                        lastX = X; lastY = Y;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        invalidate();
                        return true;
                    }
                    
                    // Otherwise, drag whole rectangle
                    activeRectKey = insideKey;
                    selectedWidgetKey = activeRectKey;
                    updateSelectedLabel();
                    draggingWholeRect = true;
                    draggingEdge = false;
                    lastX = X; lastY = Y;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    invalidate();
                    return true;
                }
                return false;
            }
            case MotionEvent.ACTION_MOVE: {
                if (activeRectKey == null) return false;
                
                if (activeBallId >= 0) {
                    Integer[] ids = rectangleBallIds.get(activeRectKey);
                    RectangleConfig cfg = getConfig(activeRectKey);
                    if (ids == null || cfg == null) return false;

                    int cornerIndex = cornerIndexOf(ids, activeBallId);
                    if (cornerIndex >= 0) {
                        moveCorner(ids, cfg, cornerIndex, X, Y);
                        invalidate();
                    }
                    lastX = X; lastY = Y;
                    return true;
                } else if (draggingEdge) {
                    Integer[] ids = rectangleBallIds.get(activeRectKey);
                    RectangleConfig cfg = getConfig(activeRectKey);
                    if (ids == null || cfg == null) return false;

                    moveEdge(ids, cfg, activeEdgeIndex, X, Y);
                    invalidate();
                    lastX = X; lastY = Y;
                    return true;
                } else if (draggingWholeRect) {
                    Integer[] ids = rectangleBallIds.get(activeRectKey);
                    if (ids == null) return false;

                    int dx = X - lastX;
                    int dy = Y - lastY;
                    if (dx == 0 && dy == 0) return true;

                    // clamp to margins
                    RectF before = rectFromBallIds(ids[0], ids[1], ids[2], ids[3]);
                    if (before.isEmpty()) return true;
                    RectF after = new RectF(before);
                    after.offset(dx, dy);

                    float clampedDx = dx;
                    float clampedDy = dy;
                    if (after.left < minBorderX) clampedDx += (minBorderX - after.left);
                    if (after.right > maxBorderX) clampedDx -= (after.right - maxBorderX);
                    if (after.top < minBorderY) clampedDy += (minBorderY - after.top);
                    if (after.bottom > maxBorderY) clampedDy -= (after.bottom - maxBorderY);

                    // Apply clamped offset
                    RectF clampedRect = new RectF(before);
                    clampedRect.offset(clampedDx, clampedDy);
                    
                    // Clamp away from auto-hide bar
                    RectF finalRect = clampAwayFromAutoHideBar(clampedRect);
                    float finalDx = finalRect.left - before.left;
                    float finalDy = finalRect.top - before.top;

                    for (int id : ids) {
                        point[id].x += (int) finalDx;
                        point[id].y += (int) finalDy;
                    }
                    lastX = X; lastY = Y;
                    invalidate();
                    return true;
                }
                return false;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                savePrefs();
                activeBallId = -1;
                activeRectKey = null;
                draggingWholeRect = false;
                draggingEdge = false;
                activeEdgeIndex = -1;
                getParent().requestDisallowInterceptTouchEvent(false);
                invalidate();
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    private int hitTestBall(int x, int y) {
        // Invisible handles but generous hit radius at corner points
        final float radius = Math.max(handleRadiusPx, 40f * getResources().getDisplayMetrics().density);
        final float r2 = radius * radius;
        for (ColorBall b : colorballs) {
            if (b == null) continue;
            float dx = x - b.getX();
            float dy = y - b.getY();
            if (dx * dx + dy * dy <= r2) return b.getID();
        }
        return -1;
    }

    private String hitTestRect(int x, int y) {
        for (int i = rectangleConfigs.size() - 1; i >= 0; i--) {
            RectangleConfig cfg = rectangleConfigs.get(i);
            if (!cfg.enabled) continue;
            Integer[] ids = rectangleBallIds.get(cfg.key);
            if (ids == null) continue;
            RectF r = rectFromBallIds(ids[0], ids[1], ids[2], ids[3]);
            if (!r.isEmpty() && r.contains(x, y)) return cfg.key;
        }
        return null;
    }

    private int hitTestEdge(int x, int y, String rectKey) {
        Integer[] ids = rectangleBallIds.get(rectKey);
        if (ids == null) return -1;
        
        RectF r = rectFromBallIds(ids[0], ids[1], ids[2], ids[3]);
        if (r.isEmpty()) return -1;
        
        // Edge hit detection with generous touch area
        float edgeTolerance = Math.max(30f * getResources().getDisplayMetrics().density, handleRadiusPx);
        
        // Check if inside the rectangle bounds (with tolerance)
        if (x < r.left - edgeTolerance || x > r.right + edgeTolerance ||
            y < r.top - edgeTolerance || y > r.bottom + edgeTolerance) {
            return -1;
        }
        
        // Determine which edge is closest
        float distToTop = Math.abs(y - r.top);
        float distToBottom = Math.abs(y - r.bottom);
        float distToLeft = Math.abs(x - r.left);
        float distToRight = Math.abs(x - r.right);
        
        float minDist = Math.min(Math.min(distToTop, distToBottom), Math.min(distToLeft, distToRight));
        
        if (minDist > edgeTolerance) {
            return -1; // Not close enough to any edge
        }
        
        // Return edge index: 0=top, 1=right, 2=bottom, 3=left
        if (minDist == distToTop) return 0;
        if (minDist == distToRight) return 1;
        if (minDist == distToBottom) return 2;
        if (minDist == distToLeft) return 3;
        
        return -1;
    }

    private RectangleConfig getConfig(String key) {
        for (RectangleConfig c : rectangleConfigs) if (c.key.equals(key)) return c;
        return null;
    }

    private String findRectKeyByBall(int ballId) {
        for (Map.Entry<String, Integer[]> e : rectangleBallIds.entrySet()) {
            Integer[] arr = e.getValue();
            for (int id : arr) if (id == ballId) return e.getKey();
        }
        return null;
    }

    private int cornerIndexOf(Integer[] ids, int ballId) {
        for (int i = 0; i < ids.length; i++) if (ids[i] == ballId) return i;
        return -1;
    }

    private void moveCorner(Integer[] ids, RectangleConfig cfg, int cornerIndex, int x, int y) {
        int tl = ids[0], tr = ids[1], br = ids[2], bl = ids[3];

        // Current corners
        int tlx = point[tl].x, tly = point[tl].y;
        int trx = point[tr].x, try_ = point[tr].y;
        int brx = point[br].x, bry = point[br].y;
        int blx = point[bl].x, bly = point[bl].y;

        int nx = Math.max(minBorderX, Math.min(x, maxBorderX));
        int ny = Math.max(minBorderY, Math.min(y, maxBorderY));

        switch (cornerIndex) {
            case 0: // TL
                nx = Math.min(nx, brx - cfg.minWidth);
                ny = Math.min(ny, bry - cfg.minHeight);
                tlx = nx; tly = ny;
                trx = Math.max(trx, tlx + cfg.minWidth);
                try_ = ny;
                blx = nx;
                bly = Math.max(bly, tly + cfg.minHeight);
                break;
            case 1: // TR
                nx = Math.max(nx, blx + cfg.minWidth);
                ny = Math.min(ny, bly - cfg.minHeight);
                trx = nx; try_ = ny;
                tlx = Math.min(tlx, trx - cfg.minWidth);
                tly = ny;
                brx = nx;
                bry = Math.max(bry, tly + cfg.minHeight);
                break;
            case 2: // BR
                nx = Math.max(nx, tlx + cfg.minWidth);
                ny = Math.max(ny, tly + cfg.minHeight);
                brx = nx; bry = ny;
                trx = nx;
                try_ = Math.min(try_, bry - cfg.minHeight);
                blx = Math.min(blx, brx - cfg.minWidth);
                bly = ny;
                break;
            case 3: // BL
                nx = Math.min(nx, trx - cfg.minWidth);
                ny = Math.max(ny, try_ + cfg.minHeight);
                blx = nx; bly = ny;
                tlx = nx;
                tly = Math.min(tly, bly - cfg.minHeight);
                brx = Math.max(brx, blx + cfg.minWidth);
                bry = ny;
                break;
        }

        // Clamp to margins after edit
        RectF cand = new RectF(Math.min(tlx, blx), Math.min(tly, try_), Math.max(trx, brx), Math.max(bly, bry));
        float dx = 0, dy = 0;
        if (cand.left < minBorderX) dx = minBorderX - cand.left;
        if (cand.right > maxBorderX) dx = Math.min(dx, maxBorderX - cand.right);
        if (cand.top < minBorderY) dy = minBorderY - cand.top;
        if (cand.bottom > maxBorderY) dy = Math.min(dy, maxBorderY - cand.bottom);
        if (dx != 0 || dy != 0) {
            tlx += dx; trx += dx; brx += dx; blx += dx;
            tly += dy; try_ += dy; bry += dy; bly += dy;
        }

        // Check if the new position would collide with auto-hide bar
        RectF finalRect = new RectF(Math.min(tlx, blx), Math.min(tly, try_), Math.max(trx, brx), Math.max(bly, bry));
        
        // If it would collide, don't commit the move
        if (collidesWithAutoHideBar(finalRect)) {
            return;
        }

        // Commit
        point[tl].x = tlx; point[tl].y = tly;
        point[tr].x = trx; point[tr].y = try_;
        point[br].x = brx; point[br].y = bry;
        point[bl].x = blx; point[bl].y = bly;
    }

    private void moveEdge(Integer[] ids, RectangleConfig cfg, int edgeIndex, int x, int y) {
        int tl = ids[0], tr = ids[1], br = ids[2], bl = ids[3];

        // Current corners
        int tlx = point[tl].x, tly = point[tl].y;
        int trx = point[tr].x, try_ = point[tr].y;
        int brx = point[br].x, bry = point[br].y;
        int blx = point[bl].x, bly = point[bl].y;

        int nx = Math.max(minBorderX, Math.min(x, maxBorderX));
        int ny = Math.max(minBorderY, Math.min(y, maxBorderY));

        switch (edgeIndex) {
            case 0: // Top edge
                ny = Math.min(ny, bry - cfg.minHeight);
                tly = ny;
                try_ = ny;
                break;
            case 1: // Right edge
                nx = Math.max(nx, tlx + cfg.minWidth);
                trx = nx;
                brx = nx;
                break;
            case 2: // Bottom edge
                ny = Math.max(ny, tly + cfg.minHeight);
                bly = ny;
                bry = ny;
                break;
            case 3: // Left edge
                nx = Math.min(nx, trx - cfg.minWidth);
                tlx = nx;
                blx = nx;
                break;
        }

        // Clamp to margins
        RectF cand = new RectF(Math.min(tlx, blx), Math.min(tly, try_), Math.max(trx, brx), Math.max(bly, bry));
        float dx = 0, dy = 0;
        if (cand.left < minBorderX) dx = minBorderX - cand.left;
        if (cand.right > maxBorderX) dx = Math.min(dx, maxBorderX - cand.right);
        if (cand.top < minBorderY) dy = minBorderY - cand.top;
        if (cand.bottom > maxBorderY) dy = Math.min(dy, maxBorderY - cand.bottom);
        if (dx != 0 || dy != 0) {
            tlx += dx; trx += dx; brx += dx; blx += dx;
            tly += dy; try_ += dy; bry += dy; bly += dy;
        }

        // Check and clamp away from auto-hide bar
        RectF finalRect = new RectF(Math.min(tlx, blx), Math.min(tly, try_), Math.max(trx, brx), Math.max(bly, bry));
        RectF clampedRect = clampAwayFromAutoHideBar(finalRect);
        
        // If the rectangle had to be moved away, don't commit the edge move
        if (!clampedRect.equals(finalRect)) {
            return;
        }

        // Commit
        point[tl].x = tlx; point[tl].y = tly;
        point[tr].x = trx; point[tr].y = try_;
        point[br].x = brx; point[br].y = bry;
        point[bl].x = blx; point[bl].y = bly;
    }
    
    @Override
    public void onClick(View v) {
        if (selectedWidgetKey == null) return;
        Integer[] ids = rectangleBallIds.get(selectedWidgetKey);
        RectangleConfig cfg = getConfig(selectedWidgetKey);
        if (ids == null || cfg == null) return;

        maxBorderX = getWidth();
        maxBorderY = getHeight();

        final int STEP = 1;
        RectF r = rectFromBallIds(ids[0], ids[1], ids[2], ids[3]);
        if (r.isEmpty()) return;

        RectF cand = null;

        switch (v.getId()) {
            case R.id.top_up: {
                cand = new RectF(r.left, r.top - STEP, r.right, r.bottom);
                if (cand.top < margin) cand = null;
                break;
            }
            case R.id.top_down: {
                cand = new RectF(r.left, r.top + STEP, r.right, r.bottom);
                if (cand.height() < cfg.minHeight) cand = null;
                break;
            }
            case R.id.bottom_up: {
                float newBottom = Math.max(r.top + cfg.minHeight, r.bottom - STEP);
                cand = new RectF(r.left, r.top, r.right, newBottom);
                break;
            }
            case R.id.bottom_down: {
                cand = new RectF(r.left, r.top, r.right, r.bottom + STEP);
                if (cand.bottom > (maxBorderY - margin)) cand = null;
                break;
            }
            case R.id.left_to_left: {
                cand = new RectF(r.left - STEP, r.top, r.right, r.bottom);
                if (cand.left < minBorderX) cand = null;
                break;
            }
            case R.id.left_to_right: {
                float newLeft = Math.min(r.right - cfg.minWidth, r.left + STEP);
                cand = new RectF(newLeft, r.top, r.right, r.bottom);
                break;
            }
            case R.id.right_to_left: {
                float newRight = Math.max(r.left + cfg.minWidth, r.right - STEP);
                cand = new RectF(r.left, r.top, newRight, r.bottom);
                break;
            }
            case R.id.right_to_right: {
                cand = new RectF(r.left, r.top, r.right + STEP, r.bottom);
                if (cand.right > (maxBorderX - margin)) cand = null;
                break;
            }
            case R.id.confirm_layout: {
                if (hasAnyIntersection()) {
                    displayDialog();
                } else {
                    savePrefs();
                    String message = getSafeContext().getString(R.string.layout_set);
                    if (mInflater != null && mRootView != null) {
                        View toastLayout = mInflater.inflate(R.layout.toast, mRootView.findViewById(R.id.toast_layout));
                        TextView text = toastLayout.findViewById(R.id.toast_text);
                        text.setText(message);
                        text.setTextSize(30);
                        Toast toast = Toast.makeText(getSafeContext(), message, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.setView(toastLayout);
                        toast.show();
                    } else {
                        Toast.makeText(getSafeContext(), message, Toast.LENGTH_LONG).show();
                    }
                }
                return;
            }
        }

        // Apply the movement if valid and doesn't collide
        if (cand != null) {
            RectF clampedCand = clampAwayFromAutoHideBar(cand);
            // Only apply if the clamping didn't change the rectangle (no collision)
            if (clampedCand.equals(cand)) {
                candToPoints(ids, cand);
                saveAndRedraw();
            }
        }
    }

    private boolean collidesWithAutoHideBar(float left, float top, float right, float bottom) {
        if (mRootView == null) return false;
        
        View creatorBarAutoHide = mRootView.findViewById(R.id.creator_bar_auto_hide);
        if (creatorBarAutoHide == null) {
            return false;
        }
        
        // Get auto-hide bar position and dimensions
        int[] location = new int[2];
        creatorBarAutoHide.getLocationOnScreen(location);
        int[] viewLocation = new int[2];
        getLocationOnScreen(viewLocation);
        
        float barLeft = location[0] - viewLocation[0];
        float barTop = location[1] - viewLocation[1];
        float barRight = barLeft + creatorBarAutoHide.getWidth();
        float barBottom = barTop + creatorBarAutoHide.getHeight();
        
        // Add margins around the auto-hide bar
        barLeft -= margin;
        barTop -= margin;
        barRight += margin;
        barBottom += margin;
        
        // Check if rectangles overlap
        return !(right <= barLeft || left >= barRight || bottom <= barTop || top >= barBottom);
    }

    private boolean collidesWithAutoHideBar(RectF rect) {
        return collidesWithAutoHideBar(rect.left, rect.top, rect.right, rect.bottom);
    }

    private RectF clampAwayFromAutoHideBar(RectF rect) {
        if (mRootView == null) return rect;
        
        View creatorBarAutoHide = mRootView.findViewById(R.id.creator_bar_auto_hide);
        if (creatorBarAutoHide == null) {
            return rect;
        }
        
        // Get auto-hide bar position and dimensions
        int[] location = new int[2];
        creatorBarAutoHide.getLocationOnScreen(location);
        int[] viewLocation = new int[2];
        getLocationOnScreen(viewLocation);
        
        float barLeft = location[0] - viewLocation[0] - margin;
        float barTop = location[1] - viewLocation[1] - margin;
        float barRight = barLeft + creatorBarAutoHide.getWidth() + (2 * margin);
        float barBottom = barTop + creatorBarAutoHide.getHeight() + (2 * margin);
        
        RectF result = new RectF(rect);
        
        // Check if rectangles overlap
        if (!(rect.right <= barLeft || rect.left >= barRight || rect.bottom <= barTop || rect.top >= barBottom)) {
            // They overlap - find the smallest displacement to separate them
            float pushLeft = barLeft - rect.right;    // negative = move rect left
            float pushRight = barRight - rect.left;   // positive = move rect right
            float pushUp = barTop - rect.bottom;      // negative = move rect up
            float pushDown = barBottom - rect.top;    // positive = move rect down
            
            // Find the smallest absolute displacement
            float minDisplacement = Float.MAX_VALUE;
            float chosenDx = 0, chosenDy = 0;
            
            if (Math.abs(pushLeft) < minDisplacement && rect.left + pushLeft >= minBorderX) {
                minDisplacement = Math.abs(pushLeft);
                chosenDx = pushLeft;
                chosenDy = 0;
            }
            if (Math.abs(pushRight) < minDisplacement && rect.right + pushRight <= maxBorderX) {
                minDisplacement = Math.abs(pushRight);
                chosenDx = pushRight;
                chosenDy = 0;
            }
            if (Math.abs(pushUp) < minDisplacement && rect.top + pushUp >= minBorderY) {
                minDisplacement = Math.abs(pushUp);
                chosenDx = 0;
                chosenDy = pushUp;
            }
            if (Math.abs(pushDown) < minDisplacement && rect.bottom + pushDown <= maxBorderY) {
                minDisplacement = Math.abs(pushDown);
                chosenDx = 0;
                chosenDy = pushDown;
            }
            
            result.offset(chosenDx, chosenDy);
        }
        
        return result;
    }

    private void candToPoints(Integer[] ids, RectF cand) {
        point[ids[0]].x = (int) cand.left;  point[ids[0]].y = (int) cand.top;
        point[ids[1]].x = (int) cand.right; point[ids[1]].y = (int) cand.top;
        point[ids[2]].x = (int) cand.right; point[ids[2]].y = (int) cand.bottom;
        point[ids[3]].x = (int) cand.left;  point[ids[3]].y = (int) cand.bottom;
    }

    private void setCalculatedTextSize(View view, int textViewId, int textSizeSp) {
        if (view == null) return;
        TextView tv = view.findViewById(textViewId);
        if (tv != null) tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeSp);
    }

    private void setCalculatedButtonSizes(Button button, int width, int height) {
        if (button == null) return;
        ViewGroup.LayoutParams params = button.getLayoutParams();
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams mp = (ViewGroup.MarginLayoutParams) params;
            mp.width = width; mp.height = height;
            button.setLayoutParams(mp);
        } else {
            ViewGroup.MarginLayoutParams mp = new ViewGroup.MarginLayoutParams(width, height);
            button.setLayoutParams(mp);
        }
    }

    private AppCompatActivity getActivity() {
        Context context = getSafeContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == View.VISIBLE) {
            //onResume() called
            if(changedView == null){
                return;
            }
            changedView.setFocusableInTouchMode(true);
            changedView.requestFocus();
            changedView.setOnKeyListener((v, keyCode, event) -> {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    // handle back button's click listener
                    if (hasAnyIntersection()) {
                        displayDialog();
                    } else {
                        savePrefs();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentSecond()).commit();
                    }
                    return true;
                }
                return false;
            });
        }
        else {
            //onPause() called
        } 
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mHandler.removeCallbacks(mInvalidateRunnable);
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        alertDialog = null;
        setOnKeyListener(null);
        mContextWeakRef = null;
        mInflater = null;
        mRootView = null;
    }

    private void displayDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getSafeContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(getSafeContext().getString(R.string.overlapping));
        builder.setMessage(getSafeContext().getString(R.string.wont_save));
        builder.setPositiveButton(getSafeContext().getString(R.string.proceed_and_reset), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                helpers.checkAndResetIfOverlappingOnScreen(-1); 
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentSecond()).commit();
            }
        });
        builder.setNegativeButton(getSafeContext().getString(R.string.dismiss), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog = builder.create();
        alertDialog.show();
        Button negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 80, 0);
        negativeButton.setLayoutParams(params);
    }

    private void saveAndRedraw() { savePrefs(); invalidate(); }

    private void updateSelectedLabel() {
        RectangleConfig cfg = getConfig(selectedWidgetKey);
        if (cfg != null && rectangleName != null) rectangleName.setText(cfg.name);
    }

    private void savePrefs() {
        SharedPreferences.Editor e = sharedPrefs.edit();
        for (RectangleConfig cfg : rectangleConfigs) {
            if (!cfg.enabled) continue;
            Integer[] ids = rectangleBallIds.get(cfg.key);
            if (ids == null) continue;
            e.putInt(cfg.key + "TopLeftX", point[ids[0]].x);
            e.putInt(cfg.key + "TopLeftY", point[ids[0]].y);
            e.putInt(cfg.key + "TopRightX", point[ids[1]].x);
            e.putInt(cfg.key + "TopRightY", point[ids[1]].y);
            e.putInt(cfg.key + "BottomRightX", point[ids[2]].x);
            e.putInt(cfg.key + "BottomRightY", point[ids[2]].y);
            e.putInt(cfg.key + "BottomLeftX", point[ids[3]].x);
            e.putInt(cfg.key + "BottomLeftY", point[ids[3]].y);
        }
        e.apply();
    }

    /** Returns true if any two enabled rectangles intersect (overlap or touch). */
    public boolean hasAnyIntersection() {
        for (int i = 0; i < rectangleConfigs.size(); i++) {
            RectangleConfig a = rectangleConfigs.get(i);
            if (!a.enabled) continue;

            Integer[] ia = rectangleBallIds.get(a.key);
            if (ia == null) continue;

            RectF ra = rectFromBallIds(ia[0], ia[1], ia[2], ia[3]);
            if (ra.isEmpty()) continue;

            for (int j = i + 1; j < rectangleConfigs.size(); j++) {
                RectangleConfig b = rectangleConfigs.get(j);
                if (!b.enabled) continue;
                if (!b.shouldIntersect) continue;

                Integer[] ib = rectangleBallIds.get(b.key);
                if (ib == null) continue;

                RectF rb = rectFromBallIds(ib[0], ib[1], ib[2], ib[3]);
                if (rb.isEmpty()) continue;

                if (overlapsOrTouches(ra, rb)) {
                    return true;
                }
            }
        }
        return false;
    }

    /** Inclusive overlap check: counts edge/corner touching as intersection. */
    private static boolean overlapsOrTouches(RectF a, RectF b) {
        // If there is any separating gap, they don't intersect.
        return !(a.right < b.left || b.right < a.left || a.bottom < b.top || b.bottom < a.top);
    }

    private boolean compareScreens(String pipScreenKey) {
        int pipScreen = sharedPrefs.getInt(pipScreenKey, 1) - 1;
        int screen = 0;
        if (screen == pipScreen) {
            return true;
        } else {
            return false;
        }
    }

    public static class ColorBall {
        private final Bitmap bitmap;
        private final Point point;
        private final int id;

        public ColorBall(Context context, int resId, Point point, int id) {
            this.id = id;
            this.point = point;
            Bitmap bmp = null;
            if (resId != 0) {
                try { bmp = BitmapFactory.decodeResource(context.getResources(), resId); }
                catch (Throwable ignored) {}
            }
            this.bitmap = bmp;
        }

        public int getWidthOfBall() { return bitmap == null ? 0 : bitmap.getWidth(); }
        public int getHeightOfBall() { return bitmap == null ? 0 : bitmap.getHeight(); }
        public Bitmap getBitmap() { return bitmap; }
        public int getX() { return point.x; }
        public int getY() { return point.y; }
        public int getID() { return id; }
    }
}
