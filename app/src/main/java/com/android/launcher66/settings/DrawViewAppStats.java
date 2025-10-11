package com.android.launcher66.settings;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import com.android.launcher66.R;

import java.lang.ref.WeakReference;

public class DrawViewAppStats extends View implements View.OnClickListener {
    
    private View barTop;
    private View barBottom;

    private Point[] point = new Point[4];
    private int diffX = -1, diffY = -1;
    private Paint paint;
    private Paint statsWindowPaint;
    private Canvas canvas;  
    private boolean isInsideStats = false;

    private int margin;
    private int statsTopLeftX, statsTopLeftY, statsTopRightX, statsTopRightY, statsBottomRightX, statsBottomRightY, statsBottomLeftX, statsBottomLeftY, statsWidth, statsHeight;

    private int minBorderX, minBorderY, maxBorderX, maxBorderY;

    private int statsMinX = -1, statsMaxX = -1, statsMinY = -1, statsMaxY = -1;
    private int coordinatesSize, nameTextSize;
    private float coordinatesMargin;

    private SharedPreferences sharedPrefs;
    private Button mConfirmLayout;
    private Button mConfirmLayoutBottom;
    private View mRootView;
    private LayoutInflater mInflater;
    private WeakReference<Context> mContextWeakRef;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mInvalidateRunnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    public DrawViewAppStats(LayoutInflater inflater, View rootView, Context context) {
        super(context);
        this.mContextWeakRef = new WeakReference<>(context);
        this.mInflater = inflater;
        this.mRootView = rootView;
        initUi(rootView);
    }


    public DrawViewAppStats(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawViewAppStats(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Context getSafeContext() {
        return mContextWeakRef != null ? mContextWeakRef.get() : null;
    }
    
    private void initUi(View rootView) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getSafeContext());

        margin = Integer.parseInt(sharedPrefs.getString("layout_margin", "10"));

        paint = new Paint();
        setFocusable(true); // necessary for getting the touch events
        canvas = new Canvas();

        coordinatesSize = SettingsActivity.adaptiveCoordinatesSize;
        nameTextSize = SettingsActivity.adaptiveNameTextSize;
        statsWidth = SettingsActivity.calculatedStatsWidth;
        statsHeight = SettingsActivity.calculatedStatsHeight;
        
        barTop = rootView.findViewById(R.id.creator_bar_top);       
        barBottom = rootView.findViewById(R.id.creator_bar_bottom);
        
        Button mUp = rootView.findViewById(R.id.top_up);
        mUp.setOnClickListener(this);
        setCalculatedButtonSizes(mUp, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim);
        
        Button mDown = rootView.findViewById(R.id.bottom_down);
        mDown.setOnClickListener(this);
        setCalculatedButtonSizes(mDown, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim);
        
        Button mLeft = rootView.findViewById(R.id.left_to_left);
        mLeft.setOnClickListener(this);
        setCalculatedButtonSizes(mLeft, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim); 
        
        Button mRight = rootView.findViewById(R.id.right_to_right); 
        mRight.setOnClickListener(this); 
        setCalculatedButtonSizes(mRight, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim);  
        
        Button mUpBottom = rootView.findViewById(R.id.top_up_bottom);
        mUpBottom.setOnClickListener(this);
        setCalculatedButtonSizes(mUpBottom, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim);
        
        Button mDownBottom = rootView.findViewById(R.id.bottom_down_bottom);
        mDownBottom.setOnClickListener(this);
        setCalculatedButtonSizes(mDownBottom, SettingsActivity.arrowLongDim, SettingsActivity.arrowShortDim);
        
        Button mLeftBottom = rootView.findViewById(R.id.left_to_left_bottom);
        mLeftBottom.setOnClickListener(this);
        setCalculatedButtonSizes(mLeftBottom, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim);
        
        Button mRightBottom = rootView.findViewById(R.id.right_to_right_bottom); 
        mRightBottom.setOnClickListener(this); 
        setCalculatedButtonSizes(mRightBottom, SettingsActivity.arrowShortDim, SettingsActivity.arrowLongDim);    

        setCalculatedTextSize(rootView, R.id.stats_name_string, SettingsActivity.selectionTextSize);
        setCalculatedTextSize(rootView, R.id.stats_name_string_bottom, SettingsActivity.selectionTextSize);
        
        mConfirmLayout = rootView.findViewById(R.id.confirm_layout);
        mConfirmLayout.setOnClickListener(this);
        mConfirmLayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, SettingsActivity.confirmTextSize);
        mConfirmLayoutBottom = rootView.findViewById(R.id.confirm_layout_bottom);
        mConfirmLayoutBottom.setOnClickListener(this);
        mConfirmLayoutBottom.setTextSize(TypedValue.COMPLEX_UNIT_SP, SettingsActivity.confirmTextSize);  

        int topY = sharedPrefs.getInt("topY", 10);
        if (topY < SettingsActivity.statusBarHeight + SettingsActivity.barHeight) {
            barTop.setVisibility(View.GONE);
            statsTopLeftY = sharedPrefs.getInt("appStatsTopLeftY", margin + 10);
        } else {
            barBottom.setVisibility(View.GONE);
            statsTopLeftY = sharedPrefs.getInt("appStatsTopLeftY", margin + 10) - SettingsActivity.barHeight;
        }         
        
        statsTopLeftX = sharedPrefs.getInt("appStatsTopLeftX", margin + 10);     
        statsTopRightX = statsTopLeftX + statsWidth;    
        statsTopRightY = statsTopLeftY;
        statsBottomRightX = statsTopRightX;
        statsBottomRightY = statsTopRightY + statsHeight;
        statsBottomLeftX = statsTopLeftX;
        statsBottomLeftY = statsTopLeftY + statsHeight;

        initStatsRect(getSafeContext(), new int[]{statsTopLeftX, statsTopLeftY, statsTopRightX, statsTopRightY, statsBottomRightX, statsBottomRightY, statsBottomLeftX, statsBottomLeftY, 0, 1, 2, 3});
    }

    public int calculateAdaptiveTextSize(int screenWidth, double baseSize) {
        if (screenWidth <= 0 || baseSize <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        double ratio = screenWidth / 2000.0;
        double scaleFactor = Math.pow(ratio, 0.5); 
        
        return (int) (baseSize * scaleFactor);
    }

    private void setCalculatedTextSize(View view, int dateId, int textSize) {
        TextView textView = (TextView) view.findViewById(dateId);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    private void setCalculatedButtonSizes(Button button, int width, int height) {
        // Get the current LayoutParams
        ViewGroup.LayoutParams params = button.getLayoutParams();

        // Check if the LayoutParams is an instance of MarginLayoutParams
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) params;
            marginParams.width = width;
            marginParams.height = height;
            button.setLayoutParams(marginParams);
        } else {
            // Handle cases where MarginLayoutParams aren't supported and create new LayoutParams if necessary
            ViewGroup.MarginLayoutParams newParams = new ViewGroup.MarginLayoutParams(width, height);
            button.setLayoutParams(newParams);
        }
    }

    private AppCompatActivity getActivity() {
        Context context = mContext;
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
                    savePrefs();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentSecond()).commit();
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
        setOnKeyListener(null);
        mContextWeakRef = null;
        mInflater = null;
        mRootView = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.parseColor("#8c8b8b"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(5);

        canvas.drawPaint(paint);

        statsWindowPaint = new Paint();
        statsWindowPaint.setColor(Color.parseColor("#0ca7f5"));
        statsWindowPaint.setAlpha(128);

        statsMinX = Math.min(point[0].x, point[2].x);
        statsMaxX = Math.max(point[0].x, point[2].x);
        statsMinY = Math.min(point[0].y, point[2].y);
        statsMaxY = Math.max(point[0].y, point[2].y);
        canvas.drawRect(point[0].x, point[2].y, point[2].x, point[0].y, statsWindowPaint); 
        
        RectF r = rectFromPoints(point[0], point[1], point[2], point[3]);
        
        // coordinates overlay
        drawCoordinates(canvas, r);

        // center label
        drawLabel(canvas, r, mContext.getString(R.string.stats_category));
    }

    private void drawLabel(Canvas canvas, RectF r, String label) {
        if (label == null) return;
        
        // Create text paint
        Paint txt = new Paint(Paint.ANTI_ALIAS_FLAG);
        txt.setColor(Color.BLACK);
        txt.setTextSize(nameTextSize);
        txt.setShadowLayer(2, 1, 1, Color.WHITE);
        
        float textWidth = txt.measureText(label);
        float cx = (r.left + r.right) / 2f;
        float cy = (r.top + r.bottom) / 2f + nameTextSize / 3f;
        
        // Center text if it fits
        canvas.drawText(label, cx - textWidth / 2f, cy, txt);
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

    private RectF rectFromPoints(Point ptl, Point ptr, Point pbr, Point pbl) {
        if (ptl == null || ptr == null || pbr == null || pbl == null) return new RectF();
        float left = Math.min(ptl.x, pbl.x);
        float right = Math.max(ptr.x, pbr.x);
        float top = Math.min(ptl.y, ptr.y);
        float bottom = Math.max(pbl.y, pbr.y);
        if (right <= left || bottom <= top) return new RectF();
        return new RectF(left, top, right, bottom);
    }    

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();

        int X = (int) event.getX();
        int Y = (int) event.getY();

        minBorderX = margin;
        minBorderY = margin;
        maxBorderX = getWidth() - margin;
        maxBorderY = getHeight() - margin;

        diffX = -1;
        diffY = -1;

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN: 
                if ((statsMinX < X && X < statsMaxX) && (statsMinY < Y && Y < statsMaxY)) {
                    diffX = 0;
                    diffY = 0;
                    isInsideStats = true;  
                    break;
                }  
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                if (isInsideStats) {
                    diffX = (int) event.getX() - (statsMinX + (statsMaxX - statsMinX) / 2);
                    diffY = (int) event.getY() - (statsMinY + (statsMaxY - statsMinY) / 2);
                    moveStatsRect(0, 1, 2, 3);
                    canvas.drawRect(point[0].x, point[2].y, point[2].x, point[0].y, statsWindowPaint); 
                    invalidate();                    
                }
                break;

            case MotionEvent.ACTION_UP:
                isInsideStats = false;
                break;
            }
        invalidate();
        return true;
    }

    @Override
    public void onClick(View v) {
        maxBorderX = getWidth();
        maxBorderY = getHeight();
        switch (v.getId()) {
            case R.id.top_up:
                up(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.bottom_down:
                down(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.left_to_left:
                left(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.right_to_right:
                right(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.confirm_layout:
                showToast();
                break;
            case R.id.top_up_bottom:
                up(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.bottom_down_bottom:
                down(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.left_to_left_bottom:
                left(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.right_to_right_bottom:
                right(0, 1, 2, 3);
                invalidate();  
                break;
            case R.id.confirm_layout_bottom:
                showToast();
                break;
            default:
                break;
        }
    }

    private void showToast() {
        savePrefs();
        View toastLayout = mInflater.inflate(R.layout.toast, mRootView.findViewById(R.id.toast_layout));
        TextView text = toastLayout.findViewById(R.id.toast_text);
        String message = mContext.getString(R.string.stats_pos_set);
        text.setText(message);
        text.setTextSize(30);
        Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(toastLayout);
        toast.show();
    }

    private void savePrefs() {
        int topLeftY = point[0].y;
        if (barBottom.getVisibility() == View.GONE) {
            topLeftY = point[0].y + SettingsActivity.barHeight;
        } else {
            topLeftY = point[0].y;
        }
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("appStatsTopLeftX", point[0].x);  
        editor.putInt("appStatsTopLeftY", topLeftY);   
        editor.putInt("topY", topLeftY);   
        editor.apply();
    }

    private void initStatsRect(Context context, int[] values) {
        int topLeftX = values[0];
        int topLeftY = values[1];         
        int topRightX = values[2];         
        int topRightY = values[3];
        int bottomRightX = values[4];
        int bottomRightY = values[5];
        int bottomLeftX = values[6];
        int bottomLeftY = values[7];

        point[values[8]] = new Point();
        point[values[8]].x = topLeftX;
        point[values[8]].y = topLeftY;

        point[values[9]] = new Point();
        point[values[9]].x = topRightX;
        point[values[9]].y = topRightY;

        point[values[10]] = new Point();
        point[values[10]].x = bottomRightX;
        point[values[10]].y = bottomRightY;

        point[values[11]] = new Point();
        point[values[11]].x = bottomLeftX; 
        point[values[11]].y = bottomLeftY;
    }

    private void moveStatsRect(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        // allow to move only within the layout borders
        if (point[topLeft].x >= minBorderX 
            || point[topLeft].y >= minBorderY 
            || point[bottomRight].x >= maxBorderX 
            || point[bottomRight].y >= maxBorderY) {
            point[topLeft].x = point[topLeft].x + diffX;
            point[topRight].x = point[topRight].x + diffX;
            point[bottomRight].x = point[bottomRight].x + diffX;
            point[bottomLeft].x = point[bottomLeft].x + diffX;
            point[topLeft].y = point[topLeft].y + diffY;
            point[topRight].y = point[topRight].y + diffY;
            point[bottomRight].y = point[bottomRight].y + diffY;
            point[bottomLeft].y = point[bottomLeft].y + diffY;
            if (point[topLeft].x < minBorderX) {
                int toZeroX = Math.abs(point[topLeft].x) + margin;
                point[topLeft].x = point[topLeft].x + toZeroX;
                point[topRight].x = point[topRight].x + toZeroX;
                point[bottomRight].x = point[bottomRight].x + toZeroX;
                point[bottomLeft].x = point[bottomLeft].x + toZeroX;
            }  
            if (point[topLeft].y < minBorderY) {
                barTop.setVisibility(View.GONE);
                barBottom.setVisibility(View.VISIBLE);
                int toZeroY = Math.abs(point[topLeft].y) + margin;
                point[topLeft].y = point[topLeft].y + toZeroY;
                point[topRight].y = point[topRight].y + toZeroY;
                point[bottomRight].y = point[bottomRight].y + toZeroY;
                point[bottomLeft].y = point[bottomLeft].y + toZeroY;
            } 
            if (point[bottomRight].x > maxBorderX) {
                int toMaxX = Math.abs(point[bottomRight].x) - maxBorderX;
                point[topLeft].x = point[topLeft].x - toMaxX;
                point[topRight].x = point[topRight].x - toMaxX;
                point[bottomRight].x = point[bottomRight].x - toMaxX;
                point[bottomLeft].x = point[bottomLeft].x - toMaxX;
            }  
            if (point[bottomRight].y > maxBorderY) {
                barTop.setVisibility(View.VISIBLE);
                barBottom.setVisibility(View.GONE);
                int toMaxY = Math.abs(point[bottomRight].y) - maxBorderY;
                point[topLeft].y = point[topLeft].y - toMaxY;
                point[topRight].y = point[topRight].y - toMaxY;
                point[bottomRight].y = point[bottomRight].y - toMaxY;
                point[bottomLeft].y = point[bottomLeft].y - toMaxY;
            }                                
        }
    }

    private void up(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        if (point[topLeft].y > (minBorderY + margin)) {
            point[topLeft].y = point[topLeft].y - 1;
            point[topRight].y = point[topRight].y - 1;
            point[bottomRight].y = point[bottomRight].y - 1;
            point[bottomLeft].y = point[bottomLeft].y - 1;
        }  
        if (point[topLeft].y <= (minBorderY + margin) && barBottom.getVisibility() == View.GONE && barTop.getVisibility() == View.VISIBLE) {
            barTop.setVisibility(View.GONE);
            barBottom.setVisibility(View.VISIBLE);
            point[topLeft].y = point[topLeft].y + SettingsActivity.barHeight;
            point[topRight].y = point[topRight].y + SettingsActivity.barHeight;
            point[bottomRight].y = point[bottomRight].y + SettingsActivity.barHeight;
            point[bottomLeft].y = point[bottomLeft].y + SettingsActivity.barHeight;
        }
    }

    private void down(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        if (point[bottomRight].y < (maxBorderY - margin)) {
            point[topLeft].y = point[topLeft].y + 1;
            point[topRight].y = point[topRight].y + 1;
            point[bottomRight].y = point[bottomRight].y + 1;
            point[bottomLeft].y = point[bottomLeft].y + 1;
        }   
        if (point[bottomRight].y >= (maxBorderY - margin) && barBottom.getVisibility() == View.VISIBLE && barTop.getVisibility() == View.GONE) {
            barTop.setVisibility(View.VISIBLE);
            barBottom.setVisibility(View.GONE);
            point[topLeft].y = point[topLeft].y - SettingsActivity.barHeight;
            point[topRight].y = point[topRight].y - SettingsActivity.barHeight;
            point[bottomRight].y = point[bottomRight].y - SettingsActivity.barHeight;
            point[bottomLeft].y = point[bottomLeft].y - SettingsActivity.barHeight;
        } 
    }

    private void left(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        if (point[topLeft].x > (minBorderX + margin)) {
            point[topLeft].x = point[topLeft].x - 1;
            point[topRight].x = point[topRight].x - 1;
            point[bottomRight].x = point[bottomRight].x - 1;
            point[bottomLeft].x = point[bottomLeft].x - 1;
        } 
    }

    private void right(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        if (point[bottomRight].x < (maxBorderX - margin)) {
            point[topLeft].x = point[topLeft].x + 1;
            point[topRight].x = point[topRight].x + 1;
            point[bottomRight].x = point[bottomRight].x + 1;
            point[bottomLeft].x = point[bottomLeft].x + 1;
        }  
    }
}
