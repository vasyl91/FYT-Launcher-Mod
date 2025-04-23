package com.android.launcher66.settings;

import java.util.ArrayList;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import com.android.launcher66.R;

public class DrawView extends View implements View.OnClickListener {

    private Context mContext;

    Point[] point = new Point[20];
    int groupId;
    private ArrayList<ColorBall> colorballs;
    // array that holds the balls
    private int balID = 0;
    int diffX = -1, diffY = -1;
    // variable to know what ball is being dragged
    Paint paint;
    Paint paintMap;
    Paint paintDate;    
    Paint paintMusic;    
    Paint paintRadio;
    Paint textPaint;
    Paint textStatsPaint;
    Paint namePaint;
    Paint statsPaint;
    Paint statsWindowPaint;
    Canvas canvas;
    boolean isInsideMap = false;
    boolean isInsideDate = false;
    boolean isInsideMusic = false;    
    boolean isInsideRadio = false;   
    boolean isInsideStats = false;

    int selectedWidget = 1; // 1 - map, 2 - date, 3 - music, 4 - radio, 5 - stats

    boolean intersectionMapDate = false;
    boolean intersectionMapMusic = false;
    boolean intersectionMapRadio = false;  

    boolean intersectionDateMusic = false;
    boolean intersectionDateMap = false;
    boolean intersectionDateRadio = false;
    
    boolean intersectionMusicDate = false;
    boolean intersectionMusicMap = false; 
    boolean intersectionMusicRadio = false;

    boolean intersectionRadioDate = false;
    boolean intersectionRadioMap = false; 
    boolean intersectionRadioMusic = false;

    boolean intersectionMaster = false;

    boolean map = false;
    boolean date = false;
    boolean music = false;
    boolean radio = false;
    boolean stats = false;
    boolean mainScreenStats = true;
    int margin;

    int mapMinWidth, mapMinHeight, dateMinWidth, dateMinHeight, musicMinWidth, musicMinHeight, radioMinWidth, radioMinHeight;
    int mapTopLeftX, mapTopLeftY, mapTopRightX, mapTopRightY, mapBottomRightX, mapBottomRightY, mapBottomLeftX, mapBottomLeftY;
    int dateTopLeftX, dateTopLeftY, dateTopRightX, dateTopRightY, dateBottomRightX, dateBottomRightY, dateBottomLeftX, dateBottomLeftY;
    int musicTopLeftX, musicTopLeftY, musicTopRightX, musicTopRightY, musicBottomRightX, musicBottomRightY, musicBottomLeftX, musicBottomLeftY;
    int radioTopLeftX, radioTopLeftY, radioTopRightX, radioTopRightY, radioBottomRightX, radioBottomRightY, radioBottomLeftX, radioBottomLeftY;
    int statsTopLeftX, statsTopLeftY, statsTopRightX, statsTopRightY, statsBottomRightX, statsBottomRightY, statsBottomLeftX, statsBottomLeftY, statsWidth, statsHeight;

    int minBorderX, minBorderY, maxBorderX, maxBorderY;

    int mapMinX = -1, mapMaxX = -1, mapMinY = -1, mapMaxY = -1;
    int dateMinX = -1, dateMaxX = -1, dateMinY = -1, dateMaxY = -1;
    int musicMinX = -1, musicMaxX = -1, musicMinY = -1, musicMaxY = -1;
    int radioMinX = -1, radioMaxX = -1, radioMinY = -1, radioMaxY = -1;
    int statsMinX = -1, statsMaxX = -1, statsMinY = -1, statsMaxY = -1;

    private final int none = -1;
    private final int mapTopTouch = 0, mapBottomTouch = 1, mapLeftTouch = 2, mapRightTouch = 3;
    private final int dateTopTouch = 4, dateBottomTouch = 5, dateLeftTouch = 6, dateRightTouch = 7;
    private final int musicTopTouch = 8, musicBottomTouch = 9, musicLeftTouch = 10, musicRightTouch = 11;
    private final int radioTopTouch = 12, radioBottomTouch = 13, radioLeftTouch = 14, radioRightTouch = 15;
    int currentTouch = none;
    float sizeOfRect, ballDiameter;
    int coordinatesSize, nameTextSize;

    private String mapColor = "#55FFFFFF";
    private String dateColor = "#ff4285f4";
    private String musicColor = "#FFBB86FC";
    private String radioColor = "#e2e732";

    private Rectangle rectMap = null;
    private Rectangle rectDate = null;
    private Rectangle rectMusic = null;
    private Rectangle rectRadio = null;

    private TextView rectangleName;

    private SharedPreferences sharedPrefs;
    private Button mTopDown;
    private Button mBottomUp;
    private Button mLeftToRight;
    private Button mRightToLeft;
    private Button mConfirmLayout;
    private View mRootView;
    private LayoutInflater mInflater;

    public DrawView(LayoutInflater inflater, View rootView, Context context) {
        super(context);
        this.mInflater = inflater;
        this.mRootView = rootView;
        this.mContext = context;
        init(inflater, rootView, context);
    }


    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    private void init(LayoutInflater inflater, View rootView, Context context) {
        // System.out.println("test");
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        /**
        * prevents from reseting prefs when user has chosen to use the left bar 
        * and proceed to creator to set the layout
        */
        Helpers helpers = new Helpers();
        helpers.setUserOpenedCreator(true);
        helpers.setLeftBarChanged(false);

        map = sharedPrefs.getBoolean("user_map", false);
        date = sharedPrefs.getBoolean("user_date", false);
        music = sharedPrefs.getBoolean("user_music", false);
        radio = sharedPrefs.getBoolean("user_radio", false); 
        stats = sharedPrefs.getBoolean("user_stats", false); 
        mainScreenStats = sharedPrefs.getBoolean("main_screen_stats", true);
        
        margin = Integer.parseInt(sharedPrefs.getString("layout_margin", "10"));
        boolean leftBar = sharedPrefs.getBoolean("left_bar", false);

        paint = new Paint();
        setFocusable(true); // necessary for getting the touch events
        canvas = new Canvas();

        mapMinWidth = 561;      
        dateMinWidth = 561;
        dateMinHeight = 145;
        musicMinWidth = 320;
        radioMinWidth = 320;
        radioMinHeight = 145;

        if (getResources().getDisplayMetrics().widthPixels == 1024
            || getResources().getDisplayMetrics().heightPixels == 1024) {           
            ballDiameter = 26.0f;
            coordinatesSize = 40;
            nameTextSize = 30;
            statsWidth = 245;
            statsHeight = 55;
            mapMinHeight = 284;
            musicMinHeight = 284;
        } else if (getResources().getDisplayMetrics().heightPixels == 720) {
            ballDiameter = 50.0f;
            coordinatesSize = 45;
            nameTextSize = 35;
            statsWidth = 245;
            statsHeight = 55;
            mapMinHeight = 340;
            musicMinHeight = 340;
        } else {
            ballDiameter = 75.0f;
            coordinatesSize = 50;
            nameTextSize = 40;
            statsWidth = 435;
            statsHeight = 100;
            mapMinHeight = 340;
            musicMinHeight = 340;
        }     
        sizeOfRect = ballDiameter / 2.0f;

        colorballs = new ArrayList<>();

        rectangleName = rootView.findViewById(R.id.rectangle_name);
        rectangleName.setText(mContext.getString(R.string.creator_map));

        Button mTopUp = rootView.findViewById(R.id.top_up);
        mTopUp.setOnClickListener(this);
        mTopDown = rootView.findViewById(R.id.top_down);
        mTopDown.setOnClickListener(this);
        mBottomUp = rootView.findViewById(R.id.bottom_up);
        mBottomUp.setOnClickListener(this);
        Button mBottomDown = rootView.findViewById(R.id.bottom_down);
        mBottomDown.setOnClickListener(this);
        Button mLeftToLeft = rootView.findViewById(R.id.left_to_left);
        mLeftToLeft.setOnClickListener(this);
        mLeftToRight = rootView.findViewById(R.id.left_to_right);
        mLeftToRight.setOnClickListener(this);
        mRightToLeft = rootView.findViewById(R.id.right_to_left);
        mRightToLeft.setOnClickListener(this);
        Button mRightToRight = rootView.findViewById(R.id.right_to_right); 
        mRightToRight.setOnClickListener(this);      
        
        mConfirmLayout = rootView.findViewById(R.id.confirm_layout);
        mConfirmLayout.setOnClickListener(this);

        mapTopLeftX = sharedPrefs.getInt("mapTopLeftX", margin);
        mapTopLeftY = sharedPrefs.getInt("mapTopLeftY", margin + dateMinHeight + margin);  
        mapTopRightX = sharedPrefs.getInt("mapTopRightX", margin + mapMinWidth);    
        mapTopRightY = sharedPrefs.getInt("mapTopRightY", margin + dateMinHeight + margin); 
        mapBottomRightX = sharedPrefs.getInt("mapBottomRightX", margin + mapMinWidth); 
        mapBottomRightY = sharedPrefs.getInt("mapBottomRightY", margin + dateMinHeight + margin + mapMinHeight);  
        mapBottomLeftX = sharedPrefs.getInt("mapBottomLeftX", margin);  
        mapBottomLeftY = sharedPrefs.getInt("mapBottomLeftY", margin + dateMinHeight + margin + mapMinHeight);
        initRect(context, new int[]{mapTopLeftX, mapTopLeftY, mapTopRightX, mapTopRightY, mapBottomRightX, mapBottomRightY, mapBottomLeftX, mapBottomLeftY, 0, 1, 2, 3});

        dateTopLeftX = sharedPrefs.getInt("dateTopLeftX", margin);
        dateTopLeftY = sharedPrefs.getInt("dateTopLeftY", margin);          
        dateTopRightX = sharedPrefs.getInt("dateTopRightX", margin + dateMinWidth);    
        dateTopRightY = sharedPrefs.getInt("dateTopRightY", margin);  
        dateBottomRightX = sharedPrefs.getInt("dateBottomRightX", margin + dateMinWidth);  
        dateBottomRightY = sharedPrefs.getInt("dateBottomRightY", margin + dateMinHeight); 
        dateBottomLeftX = sharedPrefs.getInt("dateBottomLeftX", margin);  
        dateBottomLeftY = sharedPrefs.getInt("dateBottomLeftY", margin + dateMinHeight);
        initRect(context, new int[]{dateTopLeftX, dateTopLeftY, dateTopRightX, dateTopRightY, dateBottomRightX, dateBottomRightY, dateBottomLeftX, dateBottomLeftY, 4, 5, 6, 7});

        musicTopLeftX = sharedPrefs.getInt("musicTopLeftX", margin + mapMinWidth + margin);  
        musicTopLeftY = sharedPrefs.getInt("musicTopLeftY", margin + radioMinHeight + margin);            
        musicTopRightX = sharedPrefs.getInt("musicTopRightX", margin + mapMinWidth + margin + musicMinWidth);  
        musicTopRightY = sharedPrefs.getInt("musicTopRightY", margin + radioMinHeight + margin); 
        musicBottomRightX = sharedPrefs.getInt("musicBottomRightX", margin + mapMinWidth + margin + musicMinWidth);  
        musicBottomRightY = sharedPrefs.getInt("musicBottomRightY", margin + radioMinHeight + margin + musicMinHeight); 
        musicBottomLeftX = sharedPrefs.getInt("musicBottomLeftX", margin + mapMinWidth + margin);  
        musicBottomLeftY = sharedPrefs.getInt("musicBottomLeftY", margin + radioMinHeight + margin + musicMinHeight);     
        initRect(context, new int[]{musicTopLeftX, musicTopLeftY, musicTopRightX, musicTopRightY, musicBottomRightX, musicBottomRightY, musicBottomLeftX, musicBottomLeftY, 8, 9, 10, 11});

        radioTopLeftX = sharedPrefs.getInt("radioTopLeftX", margin + dateMinWidth + margin);
        radioTopLeftY = sharedPrefs.getInt("radioTopLeftY", margin);      
        radioTopRightX = sharedPrefs.getInt("radioTopRightX", margin + dateMinWidth + margin  + radioMinWidth);     
        radioTopRightY = sharedPrefs.getInt("radioTopRightY", margin); 
        radioBottomRightX = sharedPrefs.getInt("radioBottomRightX", margin + dateMinWidth + margin  + radioMinWidth);  
        radioBottomRightY = sharedPrefs.getInt("radioBottomRightY", margin + radioMinHeight); 
        radioBottomLeftX = sharedPrefs.getInt("radioBottomLeftX", margin + dateMinWidth + margin); 
        radioBottomLeftY = sharedPrefs.getInt("radioBottomLeftY", margin + radioMinHeight);   
        initRect(context, new int[]{radioTopLeftX, radioTopLeftY, radioTopRightX, radioTopRightY, radioBottomRightX, radioBottomRightY, radioBottomLeftX, radioBottomLeftY, 12, 13, 14, 15});               
    
        statsTopLeftX = sharedPrefs.getInt("statsTopLeftX", margin + 10);
        statsTopLeftY = sharedPrefs.getInt("statsTopLeftY", margin + 10);          
        statsTopRightX = statsTopLeftX + statsWidth;    
        statsTopRightY = statsTopLeftY;
        statsBottomRightX = statsTopRightX;
        statsBottomRightY = statsTopRightY + statsHeight;
        statsBottomLeftX = statsTopLeftX;
        statsBottomLeftY = statsTopLeftY + statsHeight;
        initStatsRect(context, new int[]{statsTopLeftX, statsTopLeftY, statsTopRightX, statsTopRightY, statsBottomRightX, statsBottomRightY, statsBottomLeftX, statsBottomLeftY, 16, 17, 18, 19});
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
                    if (intersectionMaster) {
                        displayDialog();
                    } else {
                        savePrefs();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentFirst()).commit();
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

    private void displayDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(mContext.getString(R.string.overlapping));
        builder.setMessage(mContext.getString(R.string.wont_save));
        builder.setPositiveButton(mContext.getString(R.string.proceed_and_reset), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Helpers helpers = new Helpers();
                helpers.resetPrefs();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CreatorFragmentFirst()).commit();
            }
        });
        builder.setNegativeButton(mContext.getString(R.string.dismiss), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Button negativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 80, 0);
        negativeButton.setLayoutParams(params);
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
        paintMap = new Paint();
        paintMap.setColor(Color.parseColor(mapColor));
        paintMap.setAlpha(128);

        paintDate = new Paint();
        paintDate.setColor(Color.parseColor(dateColor));
        paintDate.setAlpha(128);

        paintMusic = new Paint();
        paintMusic.setColor(Color.parseColor(musicColor));
        paintMusic.setAlpha(128);

        paintRadio = new Paint();
        paintRadio.setColor(Color.parseColor(radioColor));
        paintRadio.setAlpha(128);

        statsWindowPaint = new Paint();
        statsWindowPaint.setColor(Color.parseColor("#0ca7f5"));
        statsWindowPaint.setAlpha(128);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        textPaint.setColor(Color.BLACK); 
        textPaint.setTextSize(coordinatesSize); 
        textPaint.setTextAlign(Paint.Align.CENTER);

        textStatsPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        textStatsPaint.setColor(Color.BLACK); 
        textStatsPaint.setTextSize(coordinatesSize - 8); 
        textStatsPaint.setTextAlign(Paint.Align.CENTER);

        namePaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        namePaint.setColor(Color.BLACK); 
        namePaint.setTextSize(nameTextSize); 
        namePaint.setTextAlign(Paint.Align.CENTER);
        namePaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        statsPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        statsPaint.setColor(Color.BLACK); 
        statsPaint.setTextSize(nameTextSize - 8); 
        statsPaint.setTextAlign(Paint.Align.CENTER);
        statsPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        if (map) {
            mapMinX = Math.min(point[0].x, point[2].x);
            mapMaxX = Math.max(point[0].x, point[2].x);
            mapMinY = Math.min(point[0].y, point[2].y);
            mapMaxY = Math.max(point[0].y, point[2].y);
            if (groupId == 1) {
                drawRectFirstGroup(canvas, 0, 2, paintMap);
            } else {
                drawRectSecondGroup(canvas, 1, 2, 3, paintMap);
            }
            drawCoordinates(canvas, 0, 1, 2, 3, mContext.getString(R.string.creator_map));
            rectMap = new Rectangle(point[0], point[1], point[2], point[3]);            
        }

        if (date) {   
            dateMinX = Math.min(point[4].x, point[6].x);
            dateMaxX = Math.max(point[4].x, point[6].x);
            dateMinY = Math.min(point[4].y, point[6].y);
            dateMaxY = Math.max(point[4].y, point[6].y);   
            if (groupId == 3) {
                drawRectFirstGroup(canvas, 4, 6, paintDate);
            } else {
                drawRectSecondGroup(canvas, 5, 6, 7, paintDate);
            }
            drawCoordinates(canvas, 4, 5, 6, 7, mContext.getString(R.string.creator_date)); 
            rectDate = new Rectangle(point[4], point[5], point[6], point[7]);
        }  
  
        if (music) {    
            musicMinX = Math.min(point[8].x, point[10].x);
            musicMaxX = Math.max(point[8].x, point[10].x);
            musicMinY = Math.min(point[8].y, point[10].y);
            musicMaxY = Math.max(point[8].y, point[10].y);
            if (groupId == 5) {
                drawRectFirstGroup(canvas, 8, 10, paintMusic);
            } else {
                drawRectSecondGroup(canvas, 9, 10, 11, paintMusic);
            }
            drawCoordinates(canvas, 8, 9, 10, 11, mContext.getString(R.string.creator_music));
            rectMusic = new Rectangle(point[8], point[9], point[10], point[11]); 
        }        

        if (radio) {    
            radioMinX = Math.min(point[12].x, point[14].x);
            radioMaxX = Math.max(point[12].x, point[14].x);
            radioMinY = Math.min(point[12].y, point[14].y);
            radioMaxY = Math.max(point[12].y, point[14].y);
            if (groupId == 7) {
                drawRectFirstGroup(canvas, 12, 14, paintRadio);
            } else {
                drawRectSecondGroup(canvas, 13, 14, 15, paintRadio);
            }
            drawCoordinates(canvas, 12, 13, 14, 15, mContext.getString(R.string.creator_radio));
            rectRadio = new Rectangle(point[12], point[13], point[14], point[15]); 
        }

        if (stats && mainScreenStats) {
            statsMinX = Math.min(point[16].x, point[18].x);
            statsMaxX = Math.max(point[16].x, point[18].x);
            statsMinY = Math.min(point[16].y, point[18].y);
            statsMaxY = Math.max(point[16].y, point[18].y);
            canvas.drawRect(point[16].x, point[18].y, point[18].x, point[16].y, statsWindowPaint); 
            drawStatsCoordinates(canvas, 16, 17, 18, 19, mContext.getString(R.string.stats_category));
        }

        // draw the balls on the canvas
        for (ColorBall ball : colorballs) {
            canvas.drawBitmap(ball.getBitmap(), ball.getX(), ball.getY(),
                    new Paint());
        }
        checkIntersection();
    }

    // events when touching the screen
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int cnt;

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
                // a ball
                balID = -1;
                groupId = -1;
                cnt = 0;

                // check if touch is inside the bounds of the ball or horizontal/vertical area
                for (ColorBall ball : colorballs) { 
                    int centerX = ball.getX() + ball.getWidthOfBall();
                    int centerY = ball.getY() + ball.getHeightOfBall();

                    // calculate the radius from the touch to the center of the ball
                    double radCircle = Math.sqrt((double) (((centerX - X) * (centerX - X)) + (centerY - Y) * (centerY - Y)));

                    if (radCircle < ball.getWidthOfBall() * ballDiameter) {
                        balID = ball.getID();
                        if (map) { 
                            if (balID == 1 || balID == 3) {
                                groupId = 2;
                                canvas.drawRect(point[0].x, point[2].y, point[2].x, point[0].y,
                                        paintMap);
                            } else if (balID == 0 || balID == 2) {
                                groupId = 1;
                                canvas.drawRect(point[1].x, point[3].y, point[3].x, point[1].y,
                                        paintMap);
                            } 
                        }  
                        if (date) {                        
                            if (balID == 5 || balID == 7) {
                                groupId = 4;
                                canvas.drawRect(point[4].x, point[6].y, point[6].x, point[4].y,
                                        paintDate);
                            } else if (balID == 4 || balID == 6) {
                                groupId = 3;
                                canvas.drawRect(point[5].x, point[7].y, point[7].x, point[5].y,
                                        paintDate);
                            }                            
                        }
                        if (music) {
                            if (balID == 9 || balID == 11) {
                                groupId = 6;
                                canvas.drawRect(point[8].x, point[10].y, point[10].x, point[8].y,
                                        paintMusic);
                            } else if (balID == 8 || balID == 10) {
                                groupId = 5;
                                canvas.drawRect(point[9].x, point[11].y, point[11].x, point[9].y,
                                        paintMusic);
                            }                            
                        }
                        if (radio) {
                            if (balID == 13 || balID == 15) {
                                groupId = 8;
                                canvas.drawRect(point[12].x, point[14].y, point[14].x, point[12].y,
                                        paintRadio);
                            } else if (balID == 12 || balID == 14) {
                                groupId = 7;
                                canvas.drawRect(point[13].x, point[15].y, point[15].x, point[13].y,
                                        paintRadio);
                            }                            
                        }

                        invalidate();
                        break;
                    } else {
                        cnt++;
                    }
                    invalidate();
                }
                if (map) { 
                    RectF mapTopArea = horizontalArea(point[0], point[1]);
                    if (mapTopArea.contains(event.getX(), event.getY())) {
                        currentTouch = mapTopTouch;
                    }
                    RectF mapBottomArea = horizontalArea(point[3], point[2]);
                    if (mapBottomArea.contains(event.getX(), event.getY())) {
                        currentTouch = mapBottomTouch;
                    }
                    RectF mapLeftArea = verticalArea(point[0], point[3]);  
                    if (mapLeftArea.contains(event.getX(), event.getY())) {
                        currentTouch = mapLeftTouch;
                    }      
                    RectF mapRightArea = verticalArea(point[1], point[2]);
                    if (mapRightArea.contains(event.getX(), event.getY())) {
                        currentTouch = mapRightTouch;
                    }
                }
                if (date) {
                    RectF dateTopArea = horizontalArea(point[4], point[5]);
                    if (dateTopArea.contains(event.getX(), event.getY())) {
                        currentTouch = dateTopTouch;
                    }
                    RectF dateBottomArea = horizontalArea(point[7], point[6]);
                    if (dateBottomArea.contains(event.getX(), event.getY())) {
                        currentTouch = dateBottomTouch;
                    }
                    RectF dateLeftArea = verticalArea(point[4], point[7]);  
                    if (dateLeftArea.contains(event.getX(), event.getY())) {
                        currentTouch = dateLeftTouch;
                    }      
                    RectF dateRightArea = verticalArea(point[5], point[6]);
                    if (dateRightArea.contains(event.getX(), event.getY())) {
                        currentTouch = dateRightTouch;
                    }                    
                }
                if (music) {
                    RectF musicTopArea = horizontalArea(point[8], point[9]);
                    if (musicTopArea.contains(event.getX(), event.getY())) {
                        currentTouch = musicTopTouch;
                    }
                    RectF musicBottomArea = horizontalArea(point[11], point[10]);
                    if (musicBottomArea.contains(event.getX(), event.getY())) {
                        currentTouch = musicBottomTouch;
                    }
                    RectF musicLeftArea = verticalArea(point[8], point[11]);  
                    if (musicLeftArea.contains(event.getX(), event.getY())) {
                        currentTouch = musicLeftTouch;
                    }      
                    RectF musicRightArea = verticalArea(point[9], point[10]);
                    if (musicRightArea.contains(event.getX(), event.getY())) {
                        currentTouch = musicRightTouch;
                    }
                }
                if (radio) {
                    RectF radioTopArea = horizontalArea(point[12], point[13]);
                    if (radioTopArea.contains(event.getX(), event.getY())) {
                        currentTouch = radioTopTouch;
                    }
                    RectF radioBottomArea = horizontalArea(point[15], point[14]);
                    if (radioBottomArea.contains(event.getX(), event.getY())) {
                        currentTouch = radioBottomTouch;
                    }
                    RectF radioLeftArea = verticalArea(point[12], point[15]);  
                    if (radioLeftArea.contains(event.getX(), event.getY())) {
                        currentTouch = radioLeftTouch;
                    }      
                    RectF radioRightArea = verticalArea(point[13], point[14]);
                    if (radioRightArea.contains(event.getX(), event.getY())) {
                        currentTouch = radioRightTouch;
                    }
                }

                if (cnt > 0) {
                    if (stats && mainScreenStats) {
                        if ((statsMinX < X && X < statsMaxX) && (statsMinY < Y && Y < statsMaxY)) {
                            diffX = 0;
                            diffY = 0;
                            rectangleName.setText(mContext.getString(R.string.stats_category));
                            selectedWidget = 5;
                            isInsideStats = true;                            
                            isInsideMap = false;
                            isInsideDate = false;
                            isInsideMusic = false;
                            isInsideRadio = false;
                            mTopDown.setAlpha(.5f);
                            mTopDown.setClickable(false);
                            mBottomUp.setAlpha(.5f);
                            mBottomUp.setClickable(false);
                            mLeftToRight.setAlpha(.5f);
                            mLeftToRight.setClickable(false);
                            mRightToLeft.setAlpha(.5f);
                            mRightToLeft.setClickable(false);
                            currentTouch = none;
                            break;
                        }  
                    }

                    if (map) { 
                        if ((mapMinX + sizeOfRect < X && X < mapMaxX - sizeOfRect) && (mapMinY + sizeOfRect < Y && Y < mapMaxY - sizeOfRect)) {
                            diffX = 0;
                            diffY = 0;
                            rectangleName.setText(mContext.getString(R.string.creator_map));
                            selectedWidget = 1;                        
                            mTopDown.setAlpha(1.0f);
                            mTopDown.setClickable(true);
                            mBottomUp.setAlpha(1.0f);
                            mBottomUp.setClickable(true);
                            mLeftToRight.setAlpha(1.0f);
                            mLeftToRight.setClickable(true);
                            mRightToLeft.setAlpha(1.0f);
                            mRightToLeft.setClickable(true);
                            isInsideMap = true;
                            break;
                        }
                    } 

                    if (date) {
                        if ((dateMinX + sizeOfRect < X && X < dateMaxX - sizeOfRect) && (dateMinY + sizeOfRect < Y && Y < dateMaxY - sizeOfRect)) {
                            diffX = 0;
                            diffY = 0;
                            rectangleName.setText(mContext.getString(R.string.creator_date));
                            selectedWidget = 2;                        
                            mTopDown.setAlpha(1.0f);
                            mTopDown.setClickable(true);
                            mBottomUp.setAlpha(1.0f);
                            mBottomUp.setClickable(true);
                            mLeftToRight.setAlpha(1.0f);
                            mLeftToRight.setClickable(true);
                            mRightToLeft.setAlpha(1.0f);
                            mRightToLeft.setClickable(true);
                            isInsideDate = true;
                            break;
                        }  
                    }

                    if (music) {
                        if ((musicMinX + sizeOfRect < X && X < musicMaxX - sizeOfRect) && (musicMinY + sizeOfRect < Y && Y < musicMaxY - sizeOfRect)) {
                            diffX = 0;
                            diffY = 0;
                            rectangleName.setText(mContext.getString(R.string.creator_music));
                            selectedWidget = 3;                        
                            mTopDown.setAlpha(1.0f);
                            mTopDown.setClickable(true);
                            mBottomUp.setAlpha(1.0f);
                            mBottomUp.setClickable(true);
                            mLeftToRight.setAlpha(1.0f);
                            mLeftToRight.setClickable(true);
                            mRightToLeft.setAlpha(1.0f);
                            mRightToLeft.setClickable(true);
                            isInsideMusic = true;
                            break;
                        }  
                    }

                    if (radio) {
                        if ((radioMinX + sizeOfRect < X && X < radioMaxX - sizeOfRect) && (radioMinY + sizeOfRect < Y && Y < radioMaxY - sizeOfRect)) {
                            diffX = 0;
                            diffY = 0;
                            rectangleName.setText(mContext.getString(R.string.creator_radio));
                            selectedWidget = 4;                        
                            mTopDown.setAlpha(1.0f);
                            mTopDown.setClickable(true);
                            mBottomUp.setAlpha(1.0f);
                            mBottomUp.setClickable(true);
                            mLeftToRight.setAlpha(1.0f);
                            mLeftToRight.setClickable(true);
                            mRightToLeft.setAlpha(1.0f);
                            mRightToLeft.setClickable(true);
                            isInsideRadio = true;
                            break;
                        }  
                    }
                }
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                switch (currentTouch) {
                    case mapTopTouch:
                        topTouch(event, 0, 1, 2, 3, mapMinHeight);
                        invalidate();
                        break;
                    case mapBottomTouch:
                        bottomTouch(event, 0, 1, 2, 3, mapMinHeight);
                        invalidate();
                        break;
                    case mapLeftTouch:
                        leftTouch(event, 0, 1, 2, 3, mapMinWidth);
                        invalidate();
                        break;
                    case mapRightTouch:
                        rightTouch(event, 0, 1, 2, 3, mapMinWidth);
                        invalidate();
                        break;
                    case dateTopTouch:
                        topTouch(event, 4, 5, 6, 7, dateMinHeight);
                        invalidate();
                        break;
                    case dateBottomTouch:
                        bottomTouch(event, 4, 5, 6, 7, dateMinHeight);
                        invalidate();
                        break;
                    case dateLeftTouch:
                        leftTouch(event, 4, 5, 6, 7, dateMinWidth);
                        invalidate();
                        break;
                    case dateRightTouch:
                        rightTouch(event, 4, 5, 6, 7, dateMinWidth);
                        invalidate();
                        break;
                    case musicTopTouch:
                        topTouch(event, 8, 9, 10, 11, musicMinHeight);
                        invalidate();
                        break;
                    case musicBottomTouch:
                        bottomTouch(event, 8, 9, 10, 11, musicMinHeight);
                        invalidate();
                        break;
                    case musicLeftTouch:
                        leftTouch(event, 8, 9, 10, 11, musicMinWidth);
                        invalidate();
                        break;
                    case musicRightTouch:
                        rightTouch(event, 8, 9, 10, 11, musicMinWidth);
                        invalidate();
                        break;
                    case radioTopTouch:
                        topTouch(event, 12, 13, 14, 15, radioMinHeight);
                        invalidate();
                        break;
                    case radioBottomTouch:
                        bottomTouch(event, 12, 13, 14, 15, radioMinHeight);
                        invalidate();
                        break;
                    case radioLeftTouch:
                        leftTouch(event, 12, 13, 14, 15, radioMinWidth);
                        invalidate();
                        break;
                    case radioRightTouch:
                        rightTouch(event, 12, 13, 14, 15, radioMinWidth);
                        invalidate();
                        break;
                }
                // move the balls the same as the finger
                if (balID > -1) {
                    colorballs.get(balID).setX(X);
                    colorballs.get(balID).setY(Y);

                    if (map) { 
                        if (groupId == 1 || groupId == 2) {
                            //diffX = (int) event.getX() - (mapMinX + (mapMaxX - mapMinX) / 2);
                            //diffY = (int) event.getY() - (mapMinY + (mapMaxY - mapMinY) / 2);
                            if (groupId == 1) {
                                moveBallsFirstGroup(0, 1, 2, 3, mapMinWidth, mapMinHeight);
                                canvas.drawRect(point[0].x, point[2].y, point[2].x, point[0].y,
                                        paintMap);
                            } else if (groupId == 2) {
                                moveBallsSecondGroup(0, 1, 2, 3, mapMinWidth, mapMinHeight);                            
                                canvas.drawRect(point[1].x, point[3].y, point[3].x, point[1].y,
                                        paintMap);
                            }                        
                        }
                    }

                    if (date) {
                        if (groupId == 3 || groupId == 4) {
                            //diffX = (int) event.getX() - (dateMinX + (dateMaxX - dateMinX) / 2);
                            //diffY = (int) event.getY() - (dateMinY + (dateMaxY - dateMinY) / 2);
                            if (groupId == 3) {
                                moveBallsFirstGroup(4, 5, 6, 7, dateMinWidth, dateMinHeight);
                                canvas.drawRect(point[4].x, point[6].y, point[6].x, point[4].y,
                                        paintDate);
                            } else if (groupId == 4) {
                                moveBallsSecondGroup(4, 5, 6, 7, dateMinWidth, dateMinHeight);
                                canvas.drawRect(point[5].x, point[7].y, point[7].x, point[5].y,
                                        paintDate);
                            }
                        }
                    }

                    if (music) {
                        if (groupId == 5 || groupId == 6) {
                            //diffX = (int) event.getX() - (musicMinX + (musicMaxX - musicMinX) / 2);
                            //diffY = (int) event.getY() - (musicMinY + (musicMaxY - musicMinY) / 2);
                            if (groupId == 5) {
                                moveBallsFirstGroup(8, 9, 10, 11, musicMinWidth, musicMinHeight);
                                canvas.drawRect(point[8].x, point[10].y, point[10].x, point[8].y,
                                        paintMusic);
                            } else if (groupId == 6) {
                                moveBallsSecondGroup(8, 9, 10, 11, musicMinWidth, musicMinHeight);
                                canvas.drawRect(point[9].x, point[11].y, point[11].x, point[9].y,
                                        paintMusic);
                            }
                        }
                    }

                    if (radio) {
                        if (groupId == 7 || groupId == 8) {
                            //diffX = (int) event.getX() - (radioMinX + (radioMaxX - radioMinX) / 2);
                            //diffY = (int) event.getY() - (radioMinY + (radioMaxY - radioMinY) / 2);
                            if (groupId == 7) {
                                moveBallsFirstGroup(12, 13, 14, 15, radioMinWidth, radioMinHeight);
                                canvas.drawRect(point[12].x, point[14].y, point[14].x, point[12].y,
                                        paintRadio);
                            } else if (groupId == 8) {
                                moveBallsSecondGroup(12, 13, 14, 15, radioMinWidth, radioMinHeight);
                                canvas.drawRect(point[13].x, point[15].y, point[15].x, point[13].y,
                                        paintRadio);
                            }
                        }
                    }
                    invalidate();
                }else{
                    if (isInsideMap) {
                        if (map) { 
                            diffX = (int) event.getX() - (mapMinX + (mapMaxX - mapMinX) / 2);
                            diffY = (int) event.getY() - (mapMinY + (mapMaxY - mapMinY) / 2);
                            moveRect(0, 1, 2, 3);
                            if (groupId == 1) {
                                canvas.drawRect(point[0].x, point[2].y, point[2].x, point[0].y,
                                        paintMap);
                            } else {
                                canvas.drawRect(point[1].x, point[3].y, point[3].x, point[1].y,
                                        paintMap);
                            }
                        }
                        invalidate();
                    } else if (isInsideDate) {
                        if (date) {
                            diffX = (int) event.getX() - (dateMinX + (dateMaxX - dateMinX) / 2);
                            diffY = (int) event.getY() - (dateMinY + (dateMaxY - dateMinY) / 2);
                            moveRect(4, 5, 6, 7);
                            if (groupId == 3) {
                                canvas.drawRect(point[4].x, point[6].y, point[6].x, point[4].y,
                                        paintDate);
                            } else {
                                canvas.drawRect(point[5].x, point[7].y, point[7].x, point[5].y,
                                        paintDate);
                            }
                        }         
                        invalidate();
                    } else if (isInsideMusic) {
                        if (music) {
                            diffX = (int) event.getX() - (musicMinX + (musicMaxX - musicMinX) / 2);
                            diffY = (int) event.getY() - (musicMinY + (musicMaxY - musicMinY) / 2);
                            moveRect(8, 9, 10, 11);
                            if (groupId == 5) {
                                canvas.drawRect(point[8].x, point[10].y, point[10].x, point[8].y,
                                        paintMusic);
                            } else {
                                canvas.drawRect(point[9].x, point[11].y, point[11].x, point[9].y,
                                        paintMusic);
                            }
                        }         
                        invalidate();
                    } else if (isInsideRadio) {
                        if (radio) {
                            diffX = (int) event.getX() - (radioMinX + (radioMaxX - radioMinX) / 2);
                            diffY = (int) event.getY() - (radioMinY + (radioMaxY - radioMinY) / 2);
                            moveRect(12, 13, 14, 15);
                            if (groupId == 7) {
                                canvas.drawRect(point[12].x, point[14].y, point[14].x, point[12].y,
                                        paintRadio);
                            } else {
                                canvas.drawRect(point[13].x, point[15].y, point[15].x, point[13].y,
                                        paintRadio);
                            }
                        }         
                        invalidate();
                    } else if (isInsideStats) {
                        if (stats && mainScreenStats) {
                            diffX = (int) event.getX() - (statsMinX + (statsMaxX - statsMinX) / 2);
                            diffY = (int) event.getY() - (statsMinY + (statsMaxY - statsMinY) / 2);
                            moveStatsRect(16, 17, 18, 19);
                            canvas.drawRect(point[16].x, point[18].y, point[18].x, point[16].y, statsWindowPaint); 
                        }         
                        invalidate();
                    }

                }

                break;

            case MotionEvent.ACTION_UP:
                // touch drop - just do things here after dropping
                isInsideMap = false;
                isInsideDate = false;
                isInsideMusic = false;
                isInsideRadio = false;
                isInsideStats = false;

                currentTouch = none;

                checkIntersection();
                break;
            }
        // redraw the canvas
        invalidate();
        return true;
    }

    @Override
    public void onClick(View v) {
        maxBorderX = getWidth();
        maxBorderY = getHeight();
        switch (v.getId()) {
            case R.id.top_up:
                if (selectedWidget == 1) {
                    topUp(0, 1, 2, mapMinHeight);
                } else if (selectedWidget == 2) {
                    topUp(4, 5, 6, dateMinHeight);
                } else if (selectedWidget == 3) {
                    topUp(8, 9, 10, musicMinHeight);
                } else if (selectedWidget == 4) {
                    topUp(12, 13, 14, radioMinHeight);
                } else if (selectedWidget == 5) {
                    up(16, 17, 18, 19);
                }
                invalidate();  
                break;
            case R.id.top_down:
                if (selectedWidget == 1) {
                    topDown(0, 1, 2, mapMinHeight);
                } else if (selectedWidget == 2) {
                    topDown(4, 5, 6, dateMinHeight);
                } else if (selectedWidget == 3) {
                    topDown(8, 9, 10, musicMinHeight);
                } else if (selectedWidget == 4) {
                    topDown(12, 13, 14, radioMinHeight);
                } 
                invalidate();  
                break;
            case R.id.bottom_up:
                if (selectedWidget == 1) {
                    bottomUp(0, 2, 3, mapMinHeight);
                } else if (selectedWidget == 2) {
                    bottomUp(4, 6, 7, dateMinHeight);
                } else if (selectedWidget == 3) {
                    bottomUp(8, 10, 11, musicMinHeight);
                } else if (selectedWidget == 4) {
                    bottomUp(12, 14, 15, radioMinHeight);
                }
                invalidate();  
                break;
            case R.id.bottom_down:
                if (selectedWidget == 1) {
                    bottomDown(2, 3);
                } else if (selectedWidget == 2) {
                    bottomDown(6, 7);
                } else if (selectedWidget == 3) {
                    bottomDown(10, 11);
                } else if (selectedWidget == 4) {
                    bottomDown(14, 15);
                } else if (selectedWidget == 5) {
                    down(16, 17, 18, 19);
                }
                invalidate();  
                break;
            case R.id.left_to_left:
                if (selectedWidget == 1) {
                    leftToLeft(0, 1, 3, mapMinWidth);
                } else if (selectedWidget == 2) {
                    leftToLeft(4, 5, 7, dateMinWidth);
                } else if (selectedWidget == 3) {
                    leftToLeft(8, 9, 11, musicMinWidth);
                } else if (selectedWidget == 4) {
                    leftToLeft(12, 13, 15, radioMinWidth);
                } else if (selectedWidget == 5) {
                    left(16, 17, 18, 19);
                }
                invalidate();  
                break;
            case R.id.left_to_right:
                if (selectedWidget == 1) {
                    leftToRight(0, 1, 3, mapMinWidth);
                } else if (selectedWidget == 2) {
                    leftToRight(4, 5, 7, dateMinWidth);
                } else if (selectedWidget == 3) {
                    leftToRight(8, 9, 11, musicMinWidth);
                } else if (selectedWidget == 4) {
                    leftToRight(12, 13, 15, radioMinWidth);
                }
                invalidate();  
                break;
            case R.id.right_to_left:
                if (selectedWidget == 1) {
                    rightToLeft(0, 1, 2, mapMinWidth);
                } else if (selectedWidget == 2) {
                    rightToLeft(4, 5, 6, dateMinWidth);
                } else if (selectedWidget == 3) {
                    rightToLeft(8, 9, 10, musicMinWidth);
                } else if (selectedWidget == 4) {
                    rightToLeft(12, 13, 14, radioMinWidth);
                }
                invalidate();  
                break;
            case R.id.right_to_right:
                if (selectedWidget == 1) {
                    rightToRight(1, 2);
                } else if (selectedWidget == 2) {
                    rightToRight(5, 6);
                } else if (selectedWidget == 3) {
                    rightToRight(9, 10);
                } else if (selectedWidget == 4) {
                    rightToRight(13, 14);
                } else if (selectedWidget == 5) {
                    right(16, 17, 18, 19);
                }
                invalidate();  
                break;
            case R.id.confirm_layout:
                savePrefs();
                View toastLayout = mInflater.inflate(R.layout.toast, mRootView.findViewById(R.id.toast_layout));
                TextView text = toastLayout.findViewById(R.id.toast_text);
                String message = mContext.getString(R.string.layout_set);
                text.setText(message);
                text.setTextSize(30);
                Toast toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setView(toastLayout);
                toast.show();
                break;
            default:
                break;
        }
    }

    //RectF(float left, float top, float right, float bottom) 
    private RectF horizontalArea(Point left, Point right) {
        RectF areaH = new RectF(left.x + sizeOfRect, left.y - sizeOfRect, right.x - sizeOfRect, right.y + sizeOfRect);
        return areaH;
    } 

    private RectF verticalArea(Point top, Point bottom) {
        RectF areaV = new RectF(top.x - sizeOfRect, top.y + sizeOfRect, bottom.x + sizeOfRect, bottom.y - sizeOfRect);
        return areaV;
    } 

    private void topTouch(MotionEvent event, int topLeft, int topRight, int bottomRight, int bottomLeft, int minHeight) {
        if (colorballs.get(topLeft).getY() >= minBorderY && colorballs.get(topLeft).getY() <= (colorballs.get(bottomLeft).getY() - minHeight)) {
            colorballs.get(topLeft).setY((int) event.getY());
            colorballs.get(topRight).setY((int) event.getY());  
        } 
        if (colorballs.get(topLeft).getY() < minBorderY) {
            colorballs.get(topLeft).setY(minBorderY);
            colorballs.get(topRight).setY(minBorderY); 
        }
        if (colorballs.get(topLeft).getY() > (colorballs.get(bottomLeft).getY() - minHeight)) {
            int toMaxHeight = Math.abs(colorballs.get(bottomLeft).getY() - minHeight);
            colorballs.get(topLeft).setY(toMaxHeight);
            colorballs.get(topRight).setY(toMaxHeight); 
        }
    } 

    private void bottomTouch(MotionEvent event, int topLeft, int topRight, int bottomRight, int bottomLeft, int minHeight) {                      
        if (colorballs.get(bottomRight).getY() <= maxBorderY && colorballs.get(bottomRight).getY() >= (colorballs.get(topLeft).getY() + minHeight)) {
            colorballs.get(bottomRight).setY((int) event.getY());
            colorballs.get(bottomLeft).setY((int) event.getY());  
        } 
        if (colorballs.get(bottomRight).getY() > maxBorderY) {
            colorballs.get(bottomRight).setY(maxBorderY);
            colorballs.get(bottomLeft).setY(maxBorderY); 
        }
        if (colorballs.get(bottomRight).getY() < (colorballs.get(topLeft).getY() + minHeight)) {
            int toMaxHeight = Math.abs(colorballs.get(topLeft).getY() + minHeight);
            colorballs.get(bottomRight).setY(toMaxHeight);
            colorballs.get(bottomLeft).setY(toMaxHeight); 
        }        
    } 

    private void leftTouch(MotionEvent event, int topLeft, int topRight, int bottomRight, int bottomLeft, int minWidth) {                        
        if (colorballs.get(topLeft).getX() >= minBorderX && colorballs.get(topLeft).getX() <= (colorballs.get(topRight).getX() - minWidth)) {
            colorballs.get(topLeft).setX((int) event.getX());
            colorballs.get(bottomLeft).setX((int) event.getX());  
        } 
        if (colorballs.get(topLeft).getX() < minBorderX) {
            colorballs.get(topLeft).setX(minBorderX);
            colorballs.get(bottomLeft).setX(minBorderX); 
        }
        if (colorballs.get(topLeft).getX() > (colorballs.get(topRight).getX() - minWidth)) {
            int toMaxWidth = Math.abs(colorballs.get(topRight).getX() - minWidth);
            colorballs.get(topLeft).setX(toMaxWidth);
            colorballs.get(bottomLeft).setX(toMaxWidth); 
        }       
    } 

    private void rightTouch(MotionEvent event, int topLeft, int topRight, int bottomRight, int bottomLeft, int minWidth) {
        if (colorballs.get(topRight).getX() <= maxBorderX && colorballs.get(topRight).getX() >= (colorballs.get(topLeft).getX() + minWidth)) {
            colorballs.get(topRight).setX((int) event.getX());
            colorballs.get(bottomRight).setX((int) event.getX());  
        } 
        if (colorballs.get(topRight).getX() > maxBorderX) {
            colorballs.get(topRight).setX(maxBorderX);
            colorballs.get(bottomRight).setX(maxBorderX); 
        }
        if (colorballs.get(topRight).getX() < (colorballs.get(topLeft).getX() + minWidth)) {
            int toMaxWidth = Math.abs(colorballs.get(topLeft).getX() + minWidth);
            colorballs.get(topRight).setX(toMaxWidth);
            colorballs.get(bottomRight).setX(toMaxWidth); 
        }        
    }

    private void topUp(int topLeft, int topRight, int bottomRight, int minHeight) {
        if (colorballs.get(topLeft).getY() > minBorderY && colorballs.get(topLeft).getY() < (colorballs.get(bottomRight).getY() - minHeight + 1)) {
            colorballs.get(topLeft).subtractY(1);
            colorballs.get(topRight).subtractY(1);                         
        }
    }

    private void topDown(int topLeft, int topRight, int bottomRight, int minHeight) {
        if (colorballs.get(topLeft).getY() < (colorballs.get(bottomRight).getY() - minHeight)) {
            colorballs.get(topLeft).addY(1);
            colorballs.get(topRight).addY(1);                         
        }
    }

    private void bottomUp(int topLeft, int bottomRight, int bottomLeft, int minHeight) {
        if (colorballs.get(bottomRight).getY() > (colorballs.get(topLeft).getY() + minHeight)) {
            colorballs.get(bottomRight).subtractY(1);
            colorballs.get(bottomLeft).subtractY(1);                         
        }
    }

    private void bottomDown(int bottomRight, int bottomLeft) {
        if (colorballs.get(bottomRight).getY() < (getHeight() - margin)) {
            colorballs.get(bottomRight).addY(1);
            colorballs.get(bottomLeft).addY(1);                         
        }
    }

    private void leftToLeft(int topLeft, int topRight, int bottomLeft, int minWidth) {
        if (colorballs.get(topLeft).getX() > minBorderX && colorballs.get(topLeft).getX() < (colorballs.get(topRight).getX() - minWidth + 1)) {
            colorballs.get(topLeft).subtractX(1);
            colorballs.get(bottomLeft).subtractX(1);                         
        }
    }

    private void leftToRight(int topLeft, int topRight, int bottomLeft, int minWidth) {
        if (colorballs.get(topLeft).getX() < (colorballs.get(topRight).getX() - minWidth)) {
            colorballs.get(topLeft).addX(1);
            colorballs.get(bottomLeft).addX(1);                         
        }
    }

    private void rightToLeft(int topLeft, int topRight, int bottomRight, int minWidth) {
        if (colorballs.get(topRight).getX() > (colorballs.get(topLeft).getX() + minWidth)) {
            colorballs.get(topRight).subtractX(1);
            colorballs.get(bottomRight).subtractX(1);                         
        }
    }

    private void rightToRight(int topRight, int bottomRight) {
        if (colorballs.get(topRight).getX() < (getWidth() - margin)) {
            colorballs.get(topRight).addX(1);
            colorballs.get(bottomRight).addX(1);                         
        }
    }

    private void up(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        if (point[topLeft].y > minBorderY) {
            point[topLeft].y = point[topLeft].y - 1;
            point[topRight].y = point[topRight].y - 1;
            point[bottomRight].y = point[bottomRight].y - 1;
            point[bottomLeft].y = point[bottomLeft].y - 1;
        } 
    }

    private void down(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        if (point[bottomRight].y < (maxBorderY - margin)) {
            point[topLeft].y = point[topLeft].y + 1;
            point[topRight].y = point[topRight].y + 1;
            point[bottomRight].y = point[bottomRight].y + 1;
            point[bottomLeft].y = point[bottomLeft].y + 1;
        }  
    }

    private void left(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        if (point[topLeft].x > minBorderX) {
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

    private void savePrefs() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if (map) { 
            editor.putInt("mapTopLeftX", colorballs.get(0).getX());  
            editor.putInt("mapTopLeftY", colorballs.get(0).getY()); 
            editor.putInt("mapTopRightX", colorballs.get(1).getX());    
            editor.putInt("mapTopRightY", colorballs.get(1).getY()); 
            editor.putInt("mapBottomRightX", colorballs.get(2).getX());   
            editor.putInt("mapBottomRightY", colorballs.get(2).getY());  
            editor.putInt("mapBottomLeftX", colorballs.get(3).getX());  
            editor.putInt("mapBottomLeftY", colorballs.get(3).getY());
        }
        if (date) {
            editor.putInt("dateTopLeftX", colorballs.get(4).getX());  
            editor.putInt("dateTopLeftY", colorballs.get(4).getY());          
            editor.putInt("dateTopRightX", colorballs.get(5).getX());    
            editor.putInt("dateTopRightY", colorballs.get(5).getY()); 
            editor.putInt("dateBottomRightX", colorballs.get(6).getX());  
            editor.putInt("dateBottomRightY", colorballs.get(6).getY()); 
            editor.putInt("dateBottomLeftX", colorballs.get(7).getX());  
            editor.putInt("dateBottomLeftY", colorballs.get(7).getY());
        }
        if (music) {
            editor.putInt("musicTopLeftX", colorballs.get(8).getX());  
            editor.putInt("musicTopLeftY", colorballs.get(8).getY());         
            editor.putInt("musicTopRightX", colorballs.get(9).getX());  
            editor.putInt("musicTopRightY", colorballs.get(9).getY()); 
            editor.putInt("musicBottomRightX", colorballs.get(10).getX());  
            editor.putInt("musicBottomRightY", colorballs.get(10).getY()); 
            editor.putInt("musicBottomLeftX", colorballs.get(11).getX());  
            editor.putInt("musicBottomLeftY", colorballs.get(11).getY());            
        }
        if (radio) {
            editor.putInt("radioTopLeftX", colorballs.get(12).getX());  
            editor.putInt("radioTopLeftY", colorballs.get(12).getY());         
            editor.putInt("radioTopRightX", colorballs.get(13).getX());  
            editor.putInt("radioTopRightY", colorballs.get(13).getY()); 
            editor.putInt("radioBottomRightX", colorballs.get(14).getX());  
            editor.putInt("radioBottomRightY", colorballs.get(14).getY()); 
            editor.putInt("radioBottomLeftX", colorballs.get(15).getX());  
            editor.putInt("radioBottomLeftY", colorballs.get(15).getY());            
        }          
        if (stats && mainScreenStats) {
            editor.putInt("statsTopLeftX", point[16].x);  
            editor.putInt("statsTopLeftY", point[16].y);            
        } 
        editor.apply();
    }

    private void initRect(Context context, int[] values) {
        int topLeftX = values[0];
        int topLeftY = values[1];         
        int topRightX = values[2];         
        int topRightY = values[3];
        int bottomRightX = values[4];
        int bottomRightY = values[5];
        int bottomLeftX = values[6];
        int bottomLeftY = values[7];

        // setting the start point for the balls
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
        point[values[11]].x = bottomLeftX; //50;
        point[values[11]].y = bottomLeftY;

        // declare each ball with the ColorBall class
        colorballs.add(values[8], new ColorBall(context, R.drawable.gray_circle, point[values[8]], values[8]));
        colorballs.add(values[9], new ColorBall(context, R.drawable.gray_circle, point[values[9]], values[9]));
        colorballs.add(values[10], new ColorBall(context, R.drawable.gray_circle, point[values[10]], values[10]));
        colorballs.add(values[11], new ColorBall(context, R.drawable.gray_circle, point[values[11]], values[11]));
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

        // setting the start point for the balls
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
        point[values[11]].x = bottomLeftX; //50;
        point[values[11]].y = bottomLeftY;
    }

    private void drawRectFirstGroup(Canvas canvas, int topLeft, int bottomRight, Paint paint) {
        int size = colorballs.get(bottomRight).getWidthOfBall() /2;
        canvas.drawRect(point[topLeft].x + size, point[bottomRight].y + size, point[bottomRight].x + size, point[topLeft].y + size, paint);        
    }

    private void drawRectSecondGroup(Canvas canvas, int topRight, int bottomRight, int bottomLeft, Paint paint) {
        int size = colorballs.get(bottomRight).getWidthOfBall() /2;
        canvas.drawRect(point[topRight].x + size, point[bottomLeft].y + size, point[bottomLeft].x + size, point[topRight].y + size, paint);
    }

    private void drawCoordinates(Canvas canvas, int topLeft, int topRight, int bottomRight, int bottomLeft, String name) {
        // top
        canvas.drawText(String.valueOf(colorballs.get(topLeft).getY()), 
            (colorballs.get(topLeft).getX() + (colorballs.get(topRight).getX() - colorballs.get(topLeft).getX()) / 2.0f), 
            (colorballs.get(topLeft).getY() + (coordinatesSize - 5)), 
            textPaint);
        // left
        int padL;
        if (colorballs.get(bottomLeft).getX() < 9) {
            padL = coordinatesSize / 2;
        } else if (10 <= colorballs.get(bottomLeft).getX() && colorballs.get(bottomLeft).getX() < 99) {
            padL = (coordinatesSize / 2) + 15;
        } else if (100 <= colorballs.get(bottomLeft).getX() && colorballs.get(bottomLeft).getX() < 999) {
            padL = (coordinatesSize / 2) + 30;
        } else {
            padL = (coordinatesSize / 2) + 35;
        }
        canvas.drawText(String.valueOf(colorballs.get(bottomLeft).getX()), 
            (colorballs.get(bottomLeft).getX() + padL),
            (colorballs.get(bottomLeft).getY() - (colorballs.get(bottomLeft).getY() - colorballs.get(topLeft).getY()) / 2.0f) + coordinatesSize / 2.5f, 
            textPaint);
        // bottom
        canvas.drawText(String.valueOf(colorballs.get(bottomLeft).getY()), 
            (colorballs.get(bottomRight).getX() - (colorballs.get(bottomRight).getX() - colorballs.get(bottomLeft).getX()) / 2.0f), 
            (colorballs.get(bottomLeft).getY()), 
            textPaint);
        // right
        int padR = (coordinatesSize / 2) + 30;
        canvas.drawText(String.valueOf(colorballs.get(bottomRight).getX()), 
            (colorballs.get(bottomRight).getX() - colorballs.get(topRight).getWidthOfBall() / 2.0f) - padR, 
            (colorballs.get(bottomRight).getY() - (colorballs.get(bottomRight).getY() - colorballs.get(topRight).getY()) / 2.0f) + coordinatesSize / 2.5f, 
            textPaint);
        // widget name
        canvas.drawText(name, 
            (colorballs.get(bottomRight).getX() - (colorballs.get(bottomRight).getX() - colorballs.get(bottomLeft).getX()) / 2.0f), 
            (colorballs.get(bottomLeft).getY() - (colorballs.get(bottomLeft).getY() - colorballs.get(topLeft).getY()) / 2.0f) + coordinatesSize / 2.5f, 
            namePaint);
    }

    private void drawStatsCoordinates(Canvas canvas, int topLeft, int topRight, int bottomRight, int bottomLeft, String name) {
        // top
        canvas.drawText(String.valueOf(point[topLeft].y), 
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
        canvas.drawText(String.valueOf(point[bottomLeft].y), 
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

    private void moveRect(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        // allow to move only within layout borders
        if (colorballs.get(topLeft).getX() >= minBorderX 
            || colorballs.get(topLeft).getY() >= minBorderY 
            || colorballs.get(bottomRight).getX() >= maxBorderX 
            || colorballs.get(bottomRight).getY() >= maxBorderY) {
            colorballs.get(topLeft).addX(diffX);
            colorballs.get(topRight).addX(diffX);
            colorballs.get(bottomRight).addX(diffX);
            colorballs.get(bottomLeft).addX(diffX);
            colorballs.get(topLeft).addY(diffY);
            colorballs.get(topRight).addY(diffY);
            colorballs.get(bottomRight).addY(diffY);
            colorballs.get(bottomLeft).addY(diffY);
            if (colorballs.get(topLeft).getX() < minBorderX) {
                int toZeroX = Math.abs(colorballs.get(topLeft).getX()) + margin;
                colorballs.get(topLeft).addX(toZeroX);
                colorballs.get(topRight).addX(toZeroX);
                colorballs.get(bottomRight).addX(toZeroX);
                colorballs.get(bottomLeft).addX(toZeroX);
            }  
            if (colorballs.get(topLeft).getY() < minBorderY) {
                int toZeroY = Math.abs(colorballs.get(topLeft).getY()) + margin;
                colorballs.get(topLeft).addY(toZeroY);
                colorballs.get(topRight).addY(toZeroY);
                colorballs.get(bottomRight).addY(toZeroY);
                colorballs.get(bottomLeft).addY(toZeroY);
            } 
            if (colorballs.get(bottomRight).getX() > maxBorderX) {
                int toMaxX = Math.abs(colorballs.get(bottomRight).getX()) - maxBorderX;
                colorballs.get(topLeft).subtractX(toMaxX);
                colorballs.get(topRight).subtractX(toMaxX);
                colorballs.get(bottomRight).subtractX(toMaxX);
                colorballs.get(bottomLeft).subtractX(toMaxX);
            }  
            if (colorballs.get(bottomRight).getY() > maxBorderY) {
                int toMaxY = Math.abs(colorballs.get(bottomRight).getY()) - maxBorderY;
                colorballs.get(topLeft).subtractY(toMaxY);
                colorballs.get(topRight).subtractY(toMaxY);
                colorballs.get(bottomRight).subtractY(toMaxY);
                colorballs.get(bottomLeft).subtractY(toMaxY);
            }                                
        }
    }

    private void moveStatsRect(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        // allow to move only within layout borders
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
                int toMaxY = Math.abs(point[bottomRight].y) - maxBorderY;
                point[topLeft].y = point[topLeft].y - toMaxY;
                point[topRight].y = point[topRight].y - toMaxY;
                point[bottomRight].y = point[bottomRight].y - toMaxY;
                point[bottomLeft].y = point[bottomLeft].y - toMaxY;
            }                                
        }
    }

    private void moveBallsFirstGroup(int topLeft, int topRight, int bottomRight, int bottomLeft, int minWidth, int minHeight) {
        // do not allow to move the ball beyond layout borders
        if (colorballs.get(topLeft).getX() <= minBorderX) {
            colorballs.get(topLeft).setX(margin);
        } 
        if (colorballs.get(topLeft).getY() <= minBorderY) {
            colorballs.get(topLeft).setY(margin);
        } 
        if (colorballs.get(bottomRight).getX() >= maxBorderX) {
            colorballs.get(bottomRight).setX(maxBorderX);
        } 
        if (colorballs.get(bottomRight).getY() >= maxBorderY) {
            colorballs.get(bottomRight).setY(maxBorderY);
        } 
        // transform rect
        if ((colorballs.get(bottomRight).getX() - colorballs.get(topLeft).getX()) >= minWidth && (colorballs.get(bottomRight).getY() - colorballs.get(topLeft).getY()) >= minHeight) {
            colorballs.get(topRight).setX(colorballs.get(bottomRight).getX());
            colorballs.get(topRight).setY(colorballs.get(topLeft).getY());
            colorballs.get(bottomLeft).setX(colorballs.get(topLeft).getX());
            colorballs.get(bottomLeft).setY(colorballs.get(bottomRight).getY());
        } 
        if ((colorballs.get(bottomRight).getY() - colorballs.get(topLeft).getY()) < minHeight) {
            if (balID == 0 || balID == 4 || balID == 8 || balID == 12) {
                colorballs.get(topLeft).setY(colorballs.get(bottomRight).getY() - minHeight);
                colorballs.get(topRight).setY(colorballs.get(bottomRight).getY() - minHeight);
                if ((colorballs.get(bottomRight).getX() - colorballs.get(topLeft).getX()) > minWidth) {
                    colorballs.get(bottomLeft).setX(colorballs.get(topLeft).getX());
                } else {
                    colorballs.get(topLeft).setX(colorballs.get(topRight).getX() - minWidth);
                    colorballs.get(bottomLeft).setX(colorballs.get(bottomRight).getX() - minWidth);
                }
            } else if (balID == 2 || balID == 6 || balID == 10 || balID == 14) {
                colorballs.get(bottomRight).setY(colorballs.get(topLeft).getY() + minHeight);
                colorballs.get(bottomLeft).setY(colorballs.get(topLeft).getY() + minHeight);
                if ((colorballs.get(bottomRight).getX() - colorballs.get(topLeft).getX()) > minWidth) {
                    colorballs.get(topRight).setX(colorballs.get(bottomRight).getX());
                } else {
                    colorballs.get(topRight).setX(colorballs.get(topLeft).getX() + minWidth);
                    colorballs.get(bottomRight).setX(colorballs.get(bottomLeft).getX() + minWidth);
                }
            }
        } else if ((colorballs.get(bottomRight).getX() - colorballs.get(topLeft).getX()) < minWidth) {
            if (balID == 0 || balID == 4 || balID == 8 || balID == 12) {
                colorballs.get(topLeft).setX(colorballs.get(topRight).getX() - minWidth);
                colorballs.get(bottomLeft).setX(colorballs.get(bottomRight).getX() - minWidth);
                colorballs.get(topRight).setY(colorballs.get(topLeft).getY());
            } else if (balID == 2 || balID == 6 || balID == 10 || balID == 14) {
                colorballs.get(bottomRight).setX(colorballs.get(bottomLeft).getX() + minWidth);
                colorballs.get(topRight).setX(colorballs.get(topLeft).getX() + minWidth);
                colorballs.get(bottomLeft).setY(colorballs.get(bottomRight).getY());
            }
        }
        
    }

    private void moveBallsSecondGroup(int topLeft, int topRight, int bottomRight, int bottomLeft, int minWidth, int minHeight) {
        // do not allow to move the ball beyond layout borders
        if (colorballs.get(topRight).getX() >= maxBorderX) {
            colorballs.get(topRight).setX(maxBorderX);
        } 
        if (colorballs.get(topRight).getY() <= minBorderY) {
            colorballs.get(topRight).setY(margin);
        }
        if (colorballs.get(bottomLeft).getX() <= minBorderX) {
            colorballs.get(bottomLeft).setX(margin);
        } 
        if (colorballs.get(bottomLeft).getY() >= maxBorderY) {
            colorballs.get(bottomLeft).setY(maxBorderY);
        }
        // transform rect
        if ((colorballs.get(topRight).getX() - colorballs.get(bottomLeft).getX()) >= minWidth && (colorballs.get(bottomLeft).getY() - colorballs.get(topRight).getY()) >= minHeight) {
            colorballs.get(topLeft).setX(colorballs.get(bottomLeft).getX());
            colorballs.get(topLeft).setY(colorballs.get(topRight).getY());
            colorballs.get(bottomRight).setX(colorballs.get(topRight).getX());
            colorballs.get(bottomRight).setY(colorballs.get(bottomLeft).getY());
        } 
        if ((colorballs.get(bottomLeft).getY() - colorballs.get(topRight).getY()) < minHeight) {
            if (balID == 1 || balID == 5 || balID == 9 || balID == 13) {
                colorballs.get(topRight).setY(colorballs.get(bottomLeft).getY() - minHeight);
                colorballs.get(topLeft).setY(colorballs.get(bottomLeft).getY() - minHeight);
                if ((colorballs.get(topRight).getX() - colorballs.get(bottomLeft).getX()) > minWidth) {
                    colorballs.get(bottomRight).setX(colorballs.get(topRight).getX());
                } else {
                    colorballs.get(topRight).setX(colorballs.get(topLeft).getX() + minWidth);
                    colorballs.get(bottomRight).setX(colorballs.get(bottomLeft).getX() + minWidth);
                }
            } else if (balID == 3 || balID == 7 || balID == 11 || balID == 15) {
                colorballs.get(bottomLeft).setY(colorballs.get(topLeft).getY() + minHeight);
                colorballs.get(bottomRight).setY(colorballs.get(topLeft).getY() + minHeight);
                if ((colorballs.get(topRight).getX() - colorballs.get(bottomLeft).getX()) > minWidth) {
                    colorballs.get(topLeft).setX(colorballs.get(bottomLeft).getX());
                } else {
                    colorballs.get(topLeft).setX(colorballs.get(topRight).getX() - minWidth);
                    colorballs.get(bottomLeft).setX(colorballs.get(bottomRight).getX() - minWidth);
                }
            }
        } else if ((colorballs.get(topRight).getX() - colorballs.get(bottomLeft).getX()) < minWidth) {
            if (balID == 1 || balID == 5 || balID == 9 || balID == 13) {
                colorballs.get(topRight).setX(colorballs.get(topLeft).getX() + minWidth);
                colorballs.get(bottomRight).setX(colorballs.get(bottomLeft).getX() + minWidth);
                colorballs.get(topLeft).setY(colorballs.get(topRight).getY());
            } else if (balID == 3 || balID == 7 || balID == 11 || balID == 15) {
                colorballs.get(topLeft).setX(colorballs.get(topRight).getX() - minWidth);
                colorballs.get(bottomLeft).setX(colorballs.get(bottomRight).getX() - minWidth);
                colorballs.get(bottomRight).setY(colorballs.get(bottomLeft).getY());
            }
        }
        //System.out.println(minWidth);
        //System.out.println((colorballs.get(topRight).getX() - colorballs.get(bottomLeft).getX()));
    }

    private void checkIntersection() {
        int pipScreen = Integer.parseInt(sharedPrefs.getString("pip_screen", "1")) - 1;
        // pip won't intersect if user chooses it to display on different screen
        if (pipScreen == 0) {
            if (date && map) {
                intersectionMapDate = rectMap.intersect(rectDate);
                intersectionDateMap = rectDate.intersect(rectMap);
            }
            if (music && map) {
                intersectionMapMusic = rectMap.intersect(rectMusic);
                intersectionMusicMap = rectMusic.intersect(rectMap);
            }
            if (radio && map) {
                intersectionMapRadio = rectMap.intersect(rectRadio);
                intersectionRadioMap = rectRadio.intersect(rectMap);
            }            
        }
        if (date && music) {
            intersectionDateMusic = rectDate.intersect(rectMusic);
            intersectionMusicDate = rectMusic.intersect(rectDate);
        } 
        if (date && radio) {
            intersectionRadioDate = rectRadio.intersect(rectDate);
            intersectionDateRadio = rectDate.intersect(rectRadio);
        }  
        if (radio && music) {
            intersectionRadioMusic = rectRadio.intersect(rectMusic);
            intersectionMusicRadio = rectMusic.intersect(rectRadio);
        }
        // map <=> date
        if (intersectionMapDate || intersectionDateMap) {
            mapColor = "#FF0000";
            dateColor = "#FF0000"; 
        } else {
            if (!intersectionMusicMap && !intersectionMapMusic && !intersectionRadioMap && !intersectionMapRadio) {
                mapColor = "#55FFFFFF"; 
            }
            if (!intersectionMusicDate && !intersectionDateMusic && !intersectionRadioDate && !intersectionDateRadio) {
                dateColor = "#ff4285f4"; 
            }
        }
        // music <=> date
        if (intersectionMusicDate || intersectionDateMusic) {
            dateColor = "#FF0000";
            musicColor = "#FF0000";             
        } else {
            if (!intersectionMapDate && !intersectionDateMap && !intersectionRadioDate && !intersectionDateRadio) {
                dateColor = "#ff4285f4";
            }
            if (!intersectionMapMusic && !intersectionMusicMap && !intersectionRadioMusic && !intersectionMusicRadio) {
                musicColor = "#FFBB86FC";
            }
        }
        // radio <=> date
        if (intersectionRadioDate || intersectionDateRadio) {
            dateColor = "#FF0000";   
            radioColor = "#FF0000";  
        } else {
            if (!intersectionMapDate && !intersectionDateMap && !intersectionMusicDate && !intersectionDateMusic) {
                dateColor = "#ff4285f4";
            }
            if (!intersectionMapRadio && !intersectionRadioMap && !intersectionRadioMusic && !intersectionMusicRadio) {
                radioColor = "#e2e732"; 
            }
        }
        // radio <=> music
        if (intersectionRadioMusic || intersectionMusicRadio) {
            radioColor = "#FF0000"; 
            musicColor = "#FF0000";
        } else {
            if (!intersectionRadioMap && !intersectionMapRadio && !intersectionRadioDate && !intersectionDateRadio) {
                radioColor = "#e2e732";
            }
            if (!intersectionDateMusic && !intersectionMusicDate && !intersectionMapMusic && !intersectionMusicMap) {
                musicColor = "#FFBB86FC";
            }
        }
        // map <=> music
        if (intersectionMapMusic || intersectionMusicMap) {
            mapColor = "#FF0000";
            musicColor = "#FF0000";       
        } else {
            if (!intersectionDateMap && !intersectionMapDate && !intersectionRadioMap && !intersectionMapRadio) {
                mapColor = "#55FFFFFF";
            }
            if (!intersectionDateMusic && !intersectionMusicDate && !intersectionRadioMusic && !intersectionMusicRadio) {
                musicColor = "#FFBB86FC";
            }
        }
        // map <=> radio
        if (intersectionMapRadio || intersectionRadioMap) {
            mapColor = "#FF0000";
            radioColor = "#FF0000";       
        } else {
            if (!intersectionDateMap && !intersectionMapDate && !intersectionMapMusic && !intersectionMusicMap) {
                mapColor = "#55FFFFFF";
            }
            if (!intersectionDateRadio && !intersectionRadioDate && !intersectionRadioMusic && !intersectionMusicRadio) {
                radioColor = "#e2e732"; 
            }
        }

        if(intersectionMapDate || intersectionMapMusic || intersectionMapRadio 
            || intersectionDateMusic || intersectionDateMap || intersectionDateRadio 
            || intersectionMusicDate || intersectionMusicMap || intersectionMusicRadio
            || intersectionRadioDate || intersectionRadioMap || intersectionRadioMusic) {
            intersectionMaster = true;
        } else {
            intersectionMaster = false;
        }        
        mConfirmLayout.setClickable(!intersectionMaster);
        if (intersectionMaster) {
            mConfirmLayout.setBackgroundColor(Color.GRAY);
        } else {
            mConfirmLayout.setBackgroundColor(Color.parseColor("#ff4285f4"));
        }
        invalidate();        
    }

    public static class ColorBall {

        private final Bitmap bitmap;
        private final Point point;
        private final int id;

        public ColorBall(Context context, int resourceId, Point point, int id) {
            this.id = id;
            bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
            this.point = point;
        }

        public int getWidthOfBall() {
            return bitmap.getWidth();
        }

        public int getHeightOfBall() {
            return bitmap.getHeight();
        }

        public Bitmap getBitmap() {
            return bitmap;
        }

        public int getX() {
            return point.x;
        }

        public int getY() {
            return point.y;
        }

        public int getID() {
            return id;
        }

        public void setX(int x) {
            point.x = x;
        }

        public void setY(int y) {
            point.y = y;
        }

        public void addY(int y){
            point.y = point.y + y;
        }

        public void addX(int x){
            point.x = point.x + x;
        }

        public void subtractY(int y){
            point.y = point.y - y;
        }

        public void subtractX(int x){
            point.x = point.x - x;
        }
    }
}
