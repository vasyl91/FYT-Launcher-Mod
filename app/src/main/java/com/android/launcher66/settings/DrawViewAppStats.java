package com.android.launcher66.settings;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import com.android.launcher66.R;

public class DrawViewAppStats extends View implements View.OnClickListener {

    private Context mContext;
    private final Helpers helpers = new Helpers();
    private View barTop;
    private View barBottom;

    Point[] point = new Point[4];
    int diffX = -1, diffY = -1;
    Paint paint;
    Paint textStatsPaint;
    Paint statsPaint;
    Paint statsWindowPaint;
    Canvas canvas;  
    boolean isInsideStats = false;

    int margin;
    int statsTopLeftX, statsTopLeftY, statsTopRightX, statsTopRightY, statsBottomRightX, statsBottomRightY, statsBottomLeftX, statsBottomLeftY, statsWidth, statsHeight;

    int minBorderX, minBorderY, maxBorderX, maxBorderY, barHeight;

    int statsMinX = -1, statsMaxX = -1, statsMinY = -1, statsMaxY = -1;
    int coordinatesSize, nameTextSize;

    private SharedPreferences sharedPrefs;
    private Button mConfirmLayout;
    private Button mConfirmLayoutBottom;
    private View mRootView;
    private LayoutInflater mInflater;

    public DrawViewAppStats(LayoutInflater inflater, View rootView, Context context) {
        super(context);
        this.mInflater = inflater;
        this.mRootView = rootView;
        this.mContext = context;
        init(inflater, rootView, context);
    }


    public DrawViewAppStats(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawViewAppStats(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    private void init(LayoutInflater inflater, View rootView, Context context) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        margin = Integer.parseInt(sharedPrefs.getString("layout_margin", "10"));

        paint = new Paint();
        setFocusable(true); // necessary for getting the touch events
        canvas = new Canvas();

        if (getResources().getDisplayMetrics().widthPixels == 1024
            || getResources().getDisplayMetrics().heightPixels == 1024) { 
            coordinatesSize = 40;
            nameTextSize = 30;
            statsWidth = 245;
            statsHeight = 55;
            barHeight = 128;
        } else if (getResources().getDisplayMetrics().heightPixels == 720) {
            coordinatesSize = 45;
            nameTextSize = 35;
            statsWidth = 245;
            statsHeight = 55;
            barHeight = 160;
        } else {
            coordinatesSize = 50;
            nameTextSize = 40;
            statsWidth = 435;
            statsHeight = 100;
            barHeight = 220;
        }    
        
        barTop = rootView.findViewById(R.id.creator_bar_top);
        barBottom = rootView.findViewById(R.id.creator_bar_bottom);
        Button mUp = rootView.findViewById(R.id.top_up);
        mUp.setOnClickListener(this);
        Button mDown = rootView.findViewById(R.id.bottom_down);
        mDown.setOnClickListener(this);
        Button mLeft = rootView.findViewById(R.id.left_to_left);
        mLeft.setOnClickListener(this);
        Button mRight = rootView.findViewById(R.id.right_to_right); 
        mRight.setOnClickListener(this);  
        Button mUpBottom = rootView.findViewById(R.id.top_up_bottom);
        mUpBottom.setOnClickListener(this);
        Button mDownBottom = rootView.findViewById(R.id.bottom_down_bottom);
        mDownBottom.setOnClickListener(this);
        Button mLeftBottom = rootView.findViewById(R.id.left_to_left_bottom);
        mLeftBottom.setOnClickListener(this);
        Button mRightBottom = rootView.findViewById(R.id.right_to_right_bottom); 
        mRightBottom.setOnClickListener(this);     
        
        mConfirmLayout = rootView.findViewById(R.id.confirm_layout);
        mConfirmLayout.setOnClickListener(this);
        mConfirmLayoutBottom = rootView.findViewById(R.id.confirm_layout_bottom);
        mConfirmLayoutBottom.setOnClickListener(this);            
    
        
        int bottomY = sharedPrefs.getInt("bottomY", 10);
        if (bottomY > helpers.returnWindowHeight() - barHeight) {
            barBottom.setVisibility(View.GONE);
            statsTopLeftY = sharedPrefs.getInt("appStatsTopLeftY", margin + 10) - barHeight;
        } else {
            barTop.setVisibility(View.GONE);
            statsTopLeftY = sharedPrefs.getInt("appStatsTopLeftY", margin + 10);
        }
        statsTopLeftX = sharedPrefs.getInt("appStatsTopLeftX", margin + 10);     
        statsTopRightX = statsTopLeftX + statsWidth;    
        statsTopRightY = statsTopLeftY;
        statsBottomRightX = statsTopRightX;
        statsBottomRightY = statsTopRightY + statsHeight;
        statsBottomLeftX = statsTopLeftX;
        statsBottomLeftY = statsTopLeftY + statsHeight;
        initStatsRect(context, new int[]{statsTopLeftX, statsTopLeftY, statsTopRightX, statsTopRightY, statsBottomRightX, statsBottomRightY, statsBottomLeftX, statsBottomLeftY, 0, 1, 2, 3});
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
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentFirst()).commit();
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

        textStatsPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        textStatsPaint.setColor(Color.WHITE); 
        textStatsPaint.setTextSize(coordinatesSize - 8); 
        textStatsPaint.setTextAlign(Paint.Align.CENTER);

        statsPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        statsPaint.setColor(Color.WHITE); 
        statsPaint.setTextSize(nameTextSize - 8); 
        statsPaint.setTextAlign(Paint.Align.CENTER);
        statsPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        statsMinX = Math.min(point[0].x, point[2].x);
        statsMaxX = Math.max(point[0].x, point[2].x);
        statsMinY = Math.min(point[0].y, point[2].y);
        statsMaxY = Math.max(point[0].y, point[2].y);
        canvas.drawRect(point[0].x, point[2].y, point[2].x, point[0].y, statsWindowPaint); 
        drawStatsCoordinates(canvas, 0, 1, 2, 3, mContext.getString(R.string.stats_category));
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
        int adjustedY = point[3].y;
        if (barBottom.getVisibility() == View.GONE) {
            topLeftY = point[0].y + barHeight;
            adjustedY = point[3].y + barHeight;
        } else {
            topLeftY = point[0].y;
            adjustedY = point[3].y;
        }
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("appStatsTopLeftX", point[0].x);  
        editor.putInt("appStatsTopLeftY", topLeftY);   
        editor.putInt("bottomY", adjustedY);   
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

    private void drawStatsCoordinates(Canvas canvas, int topLeft, int topRight, int bottomRight, int bottomLeft, String name) {
        // top
        String adjustedTop = String.valueOf(point[topLeft].y);
        if (barBottom.getVisibility() == View.GONE) {
            adjustedTop = String.valueOf(point[topLeft].y + barHeight);
        } else {
            adjustedTop = String.valueOf(point[topLeft].y);
        }
        canvas.drawText(adjustedTop, 
            (point[topLeft].x + (point[topRight].x - point[topLeft].x) / 2.0f), 
            (point[topLeft].y + (coordinatesSize - 15)), 
            textStatsPaint);
        // left
        int padL;
        if (point[bottomLeft].x < 9) {
            padL = coordinatesSize / 2;
        } else if (10 <= point[bottomLeft].x && point[bottomLeft].x < 99) {
            padL = (coordinatesSize / 2) + 5;
        } else if (100 <= point[bottomLeft].x && point[bottomLeft].x < 999) {
            padL = (coordinatesSize / 2) + 20;
        } else {
            padL = (coordinatesSize / 2) + 25;
        }
        canvas.drawText(String.valueOf(point[bottomLeft].x), 
            (point[bottomLeft].x + padL),
            (point[bottomLeft].y - (point[bottomLeft].y - point[topLeft].y) / 2.0f) + coordinatesSize / 2.5f, 
            textStatsPaint);
        // bottom
        String adjustedBottom = String.valueOf(point[bottomLeft].y);
        if (barBottom.getVisibility() == View.GONE) {
            adjustedBottom = String.valueOf(point[bottomLeft].y + barHeight);
        } else {
            adjustedBottom = String.valueOf(point[bottomLeft].y);
        }
        canvas.drawText(adjustedBottom, 
            (point[bottomRight].x - (point[bottomRight].x - point[bottomLeft].x) / 2.0f), 
            (point[bottomLeft].y), 
            textStatsPaint);
        // right
        int padR = (coordinatesSize / 2) + 25;
        canvas.drawText(String.valueOf(point[bottomRight].x), 
            point[bottomRight].x - padR, 
            (point[bottomRight].y - (point[bottomRight].y - point[topRight].y) / 2.0f) + coordinatesSize / 2.5f, 
            textStatsPaint);
        // widget name
        canvas.drawText(name, 
            (point[bottomRight].x - (point[bottomRight].x - point[bottomLeft].x) / 2.0f), 
            (point[bottomLeft].y - (point[bottomLeft].y - point[topLeft].y) / 2.0f) + coordinatesSize / 3.5f, 
            statsPaint);
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
            point[topLeft].y = point[topLeft].y + barHeight;
            point[topRight].y = point[topRight].y + barHeight;
            point[bottomRight].y = point[bottomRight].y + barHeight;
            point[bottomLeft].y = point[bottomLeft].y + barHeight;
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
            point[topLeft].y = point[topLeft].y - barHeight;
            point[topRight].y = point[topRight].y - barHeight;
            point[bottomRight].y = point[bottomRight].y - barHeight;
            point[bottomLeft].y = point[bottomLeft].y - barHeight;
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
