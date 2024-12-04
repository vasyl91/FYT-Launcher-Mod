package com.android.launcher66;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.SearchManager;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import androidx.core.view.ViewCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.text.Selection;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Advanceable;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.kuwo.autosdk.api.KWAPI;
import cn.kuwo.autosdk.api.OnPlayerStatusListener;
import cn.kuwo.autosdk.api.PlayState;
import cn.kuwo.autosdk.api.PlayerStatus;
import cn.kuwo.autosdk.bean.Music;

import com.android.launcher66.settings.Helpers;
import com.android.recycler.AppListAdapter;
import com.android.recycler.AppListBean;
import com.android.recycler.AppMultiple;
import com.android.recycler.LeftAppListAdapter;
import com.android.recycler.LeftAppMultiple;
import com.android.recycler.SimpleDividerDecoration;
import com.fyt.car.IUiRefresher;
import com.fyt.car.LauncherNotify;
import com.fyt.car.MapConfig;
import com.fyt.car.MusicService;
import com.fyt.flow.TrifficReceiver;
import com.fyt.skin.SkinUtils;
import com.fyt.widget.RadioRuler;
import com.fyt.widget.TurntableView3;
import com.syu.car.CarStates;
import com.syu.log.LogPreview;
import com.syu.popwindow.PopWindowBright;
import com.syu.remote.Callback;
import com.syu.remote.RemoteTools;
import com.syu.util.AppUtil;
import com.syu.util.FytPackage;
import com.syu.util.Id3Info;
import com.syu.util.JLog;
import com.syu.util.Lrc;
import com.syu.util.Utils;
import com.syu.util.WeatherUtils;
import com.syu.util.WindowUtil;
import com.syu.utils.W3Utils;
import com.syu.weather.WeatherDescription;
import com.syu.weather.WeatherManager;
import com.syu.widget.DateMusicProvider;
import com.syu.widget.DateTimeProvider;
import com.syu.widget.TimeUpdateReceiver;
import com.syu.widget.Widget;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.HttpStatus;
import org.litepal.LitePal;
import share.Config;
import share.ResValue;
import share.ShareHandler;

public class Launcher extends Activity implements View.OnClickListener, View.OnLongClickListener, LauncherModel.Callbacks, View.OnTouchListener, Observer {
    private static Throwable th;
    private ViewTreeObserver.OnDrawListener onDrawListener;
    public static final int launcher = 0x7f040024;
    static final String CORRUPTION_EMAIL_SENT_KEY = "corruptionEmailSent";
    static final boolean DEBUG_DUMP_LOG = false;
    static final boolean DEBUG_RESUME_TIME = false;
    static final boolean DEBUG_STRICT_MODE = false;
    static final boolean DEBUG_WIDGETS = true;
    static final int DEFAULT_SCREEN = 0;
    private static final boolean DISABLE_CLINGS = true;
    private static final boolean DISABLE_CUSTOM_CLINGS = true;
    private static final boolean DISABLE_MARKET_BUTTON = true;
    private static final int DISMISS_CLING_DURATION = 200;
    static final String DUMP_STATE_PROPERTY = "launcher_dump_state";
    private static final int EXIT_SPRINGLOADED_MODE_LONG_TIMEOUT = 600;
    private static final int EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT = 300;
    static final String EXTRA_SHORTCUT_DUPLICATE = "duplicate";
    static final String INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION = "com.android.launcher66.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION";
    static final boolean LOGD = false;
    private static final String PREFERENCES = "launcher.preferences";
    static final boolean PROFILE_STARTUP = false;
    private static final int REQUEST_BIND_APPWIDGET = 11;
    private static final int REQUEST_CREATE_APPWIDGET = 5;
    private static final int REQUEST_CREATE_SHORTCUT = 1;
    protected static final int REQUEST_LAST = 100;
    private static final int REQUEST_PICK_APPLICATION = 6;
    private static final int REQUEST_PICK_APPWIDGET = 9;
    private static final int REQUEST_PICK_SHORTCUT = 7;
    private static final int REQUEST_PICK_WALLPAPER = 10;
    private static final String RUNTIME_STATE = "launcher.state";
    private static final String RUNTIME_STATE_CURRENT_SCREEN = "launcher.current_screen";
    private static final String RUNTIME_STATE_PENDING_ADD_CELL_X = "launcher.add_cell_x";
    private static final String RUNTIME_STATE_PENDING_ADD_CELL_Y = "launcher.add_cell_y";
    private static final String RUNTIME_STATE_PENDING_ADD_CONTAINER = "launcher.add_container";
    private static final String RUNTIME_STATE_PENDING_ADD_SCREEN = "launcher.add_screen";
    private static final String RUNTIME_STATE_PENDING_ADD_SPAN_X = "launcher.add_span_x";
    private static final String RUNTIME_STATE_PENDING_ADD_SPAN_Y = "launcher.add_span_y";
    private static final String RUNTIME_STATE_PENDING_ADD_WIDGET_INFO = "launcher.add_widget_info";
    private static final String RUNTIME_STATE_PENDING_FOLDER_RENAME = "launcher.rename_folder";
    private static final String RUNTIME_STATE_PENDING_FOLDER_RENAME_ID = "launcher.rename_folder_id";
    static final int SCREEN_COUNT = 5;
    private static final int SHOW_CLING_DURATION = 250;
    public static final String SHOW_WEIGHT_WATCHER = "debug.show_mem";
    public static final boolean SHOW_WEIGHT_WATCHER_DEFAULT = false;
    public static final String SP_LANGUAGE = "SP_LANGUAGE";
    public static final String SP_WALLPAPER = "sp_wallpaper";
    public static final String SP_WIDGET_SCALE = "widget_scale";
    static final String TAG = "Launcher";
    private static final String TOOLBAR_ICON_METADATA_NAME = "com.android.launcher.toolbar_icon";
    private static final String TOOLBAR_SEARCH_ICON_METADATA_NAME = "com.android.launcher.toolbar_search_icon";
    private static final String TOOLBAR_VOICE_SEARCH_ICON_METADATA_NAME = "com.android.launcher.toolbar_voice_search_icon";
    public static final int WALLPAPER_RRESULT_CODE = 202;
    private String mediaSource = "fyt";
    private AudioManager am;
    private KeyEvent event;
    private String activeController;
    private String state;
    private boolean userLayout;
    private boolean leftBar;
    private static KWAPI kwAPi;
    public static TextView mAllAppView;
    public static Launcher mLauncher;
    public static LauncherModel mModel;
    private static Workspace mWorkspace;
    public static boolean sNightMode;
    public static View wallpaperButton;
    public static View settingsButton;
    LauncherApplication app;
    private ProgressBar btavProgress;
    public int carSpeed;
    RelativeLayout firstLayout;
    private RadioRuler img_freq_point;
    public ImageView ivALbumBg;
    public ImageView ivMusicScore;
    public ImageView ivMusicScore2;
    public ImageView ivPhoto;
    public ImageView iv_map1;
    private Button kuwomusic_next;
    private Button kuwomusic_playpause;
    private Button kuwomusic_prev;
    Animation loadAnimation;
    ObjectAnimator mAlbumRotate;
    View mAllAppsButton;
    private AppListAdapter mAppListAdapter;
    private List<AppListBean> mAppListData;
    private LauncherAppWidgetHost mAppWidgetHost;
    private AppWidgetManager mAppWidgetManager;
    private AppsCustomizePagedView mAppsCustomizeContent;
    private AppsCustomizeTabHost mAppsCustomizeTabHost;
    private long mAutoAdvanceSentTime;
    private MyAutoMapReceiver mAutoMap;
    private int mBrightLevel;
    private TextView mBtavAlbum;
    private TextView mBtavAritst;
    private View mBtavIcon;
    private TextView mBtavName;
    private Button mBtavNextButton;
    private Button mBtavPlayPauseButton;
    private Button mBtavPrevButton;
    private View mBtavView;
    private ImageView mCamera_DisImageView;
    private TextView mCamera_DisView;
    private ImageView mCarLightView;
    private TextView mCurCityView;
    public WeatherDescription mCurDescription;
    private TextView mCurDis_AllView;
    private TextView mCurDis_RemainView;
    private TextView mCurDis_SurplusView;
    private TextView mCurRemainTimeView;
    private TextView mCurRoadNameView;
    private TextView mCurSpeedView;
    private String mCurrWallpaperRes;
    private DragController mDragController;
    private DragLayer mDragLayer;
    private ImageView mDynamicTrailView;
    private Bitmap mFolderIconBitmap;
    private Canvas mFolderIconCanvas;
    private ImageView mFolderIconImageView;
    private FolderInfo mFolderInfo;
    private View.OnTouchListener mHapticFeedbackTouchListener;
    public View mHotseat;
    private TextView mHotseatApps;
    private IconCache mIconCache;
    private LayoutInflater mInflater;
    private View mInitNaviInfoView;
    private TextView mKwArtist;
    private TextView mKwMusicName;
    public boolean mKwPlayState;
    private View mLauncherView;
    private LeftAppListAdapter mLeftAppListAdapter;
    private List<AppListBean> mLeftAppListData;
    private RecyclerView mLeftRecyclerView;
    private ImageView mMapbgUnitView;
    private TextView mMiuDrive;
    private View mMusicIcon;
    private Button mMusicNextButton;
    private Button mMusicNextButtonTwo;
    private Button mMusicPrevButton;
    private Button mMusicPrevButtonTwo;
    private ImageView mNaviMycar;
    private View mNaviRunView;
    private View mNaviView;
    private TextView mNextRoadNameView;
    private boolean mOnResumeNeedsLoad;
    private View mOverviewPanel;
    private View mPageBTAV;
    private View mPageMusic;
    private View mPageRadio;
    private View mPageTime;
    private ArrayList<View> mPagerList;
    private boolean mPaused;
    private AppWidgetProviderInfo mPendingAddWidgetInfo;
    private MediaPlayer mPlayer;
    private View mQsbBar;
    private Button mRadioBandButton;
    private View mRadioIcon;
    private Button mRadioNextButton;
    private Button mRadioPauseButton;
    private Button mRadioPrevButton;
    private RecyclerView mRecyclerView;
    private boolean mRestoring;
    private Bundle mSavedInstanceState;
    private Bundle mSavedState;
    private SearchDropTargetBar mSearchDropTargetBar;
    private SharedPreferences mSharedPrefs;
    private ImageView mSpeedView1;
    private ImageView mSpeedView2;
    private ImageView mSpeedView3;
    private ImageView mSpeedView4;
    private AnimatorSet mStateAnimation;
    private Stats mStats;
    private TrifficReceiver mTrifficReceiver;
    private ImageView mTurnIconView;
    private TurntableView3 mTurntableView;
    private TextView mTvApps;
    private TextView mTvAux;
    private TextView mTvBt;
    private TextView mTvBtPhoneName;
    private TextView mTvCalculator;
    private TextView mTvCanbus;
    private TextView mTvCar;
    private TextView mTvDVR;
    private TextView mTvEq;
    private TextView mTvFile;
    private TextView mTvGallery;
    private TextView mTvGuide;
    private TextView mTvMovie;
    private TextView mTvMusic;
    private TextView mTvNavi;
    private TextView mTvPerson;
    private TextView mTvRadio;
    private TextView mTvSettings;
    private TextView mTvSpeed;
    private String mVideoPlayState;
    private boolean mWaitingForResult;
    private BubbleTextView mWaitingForResume;
    private View mWeather;
    private View mWeightWatcher;
    private ArrayList<Object> mWidgetsAndShortcuts;
    public WeatherManager manager;
    private ProgressBar musicProgress;
    private SeekBar musicSeekBar;
    private Button music_playpause;
    private Button music_playpause_two;
    private View pipViews;
    long preOnResumeTime;
    public boolean showKuwoContent;
    RemoteTools tools;
    private TextView tvAlbum;
    private TextView tvAritst;
    private TextView tvBand;
    private TextView tvBtavCurTime;
    private TextView tvBtavTotalTime;
    private TextView tvCurFreq;
    private TextView tvCurTime;
    private TextView tvMusicName;
    private TextView tvMusicNameTwo;
    private TextView tvTotalTime;
    private TextView tvUnit;
    private Button video_next;
    private Button video_playpause;
    private Button video_prev;
    private TextView weatherCity;
    private TextView weatherCity1;
    private ImageView weatherImg;
    private ImageView weatherImg1;
    private TextView weatherTemp;
    private TextView weatherTemp1;
    private TextView weatherTempRange;
    private TextView weatherTempRange1;
    private TextView weatherWeather;
    private TextView weatherWeather1;
    private TextView weatherWind;
    static final int APPWIDGET_HOST_ID = LauncherApplication.appWidget_Host_Id;
    private static final Object sLock = new Object();
    private static int sScreen = 0;
    private static int NEW_APPS_PAGE_MOVE_DELAY = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private static int NEW_APPS_ANIMATION_INACTIVE_TIMEOUT_SECONDS = 5;
    private static int NEW_APPS_ANIMATION_DELAY = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private static boolean sPausedFromUserAction = false;
    private static LocaleConfiguration sLocaleConfiguration = null;
    private static HashMap<Long, FolderInfo> sFolders = new HashMap<>();
    private static Drawable.ConstantState[] sGlobalSearchIcon = new Drawable.ConstantState[2];
    private static Drawable.ConstantState[] sVoiceSearchIcon = new Drawable.ConstantState[2];
    private static Drawable.ConstantState[] sAppMarketIcon = new Drawable.ConstantState[2];
    static final ArrayList<String> sDumpLogs = new ArrayList<>();
    static Date sDateStamp = new Date();
    static DateFormat sDateFormat = DateFormat.getDateTimeInstance(3, 3);
    static long sRunStart = System.currentTimeMillis();
    private static ArrayList<ComponentName> mIntentsOnWorkspaceFromUpgradePath = null;
    private static ArrayList<PendingAddArguments> sPendingAddList = new ArrayList<>();
    static final String FORCE_ENABLE_ROTATION_PROPERTY = "launcher_force_rotate";
    public static boolean sForceEnableRotation = isPropertyEnabled(FORCE_ENABLE_ROTATION_PROPERTY);
    public static int mainState = 0;
    private static int count = 0;
    public static String freq = "87.50";
    public static int radioFreqState = 0;
    public static String radioFreq = "87.50";
    public static int btTotalTime = 0;
    public static int btCurTime = 0;
    public static String btName = null;
    public static String btArtist = null;
    public static int btavState = 0;
    public static int phoneState = 0;
    boolean isfirstlayout = false;
    private State mState = State.WORKSPACE;
    private final String colsePipAction = "com.lsec.tyz.action.voice.launcher";
    private final String camera360Action = "FOURCAMERA2_BROADCAST_SEND";
    private final BroadcastReceiver mCloseSystemDialogsReceiver = new CloseSystemDialogsIntentReceiver(this, null);
    private final ContentObserver mWidgetObserver = new AppWidgetResetObserver();
    public Handler handler = new Handler(Looper.getMainLooper());
    private ItemInfo mPendingAddInfo = new ItemInfo();
    private int[] mTmpAddItemCellCoordinates = new int[2];
    public HashMap<String, View> customView = new HashMap<>();
    private boolean mAutoAdvanceRunning = false;
    private State mOnResumeState = State.NONE;
    private SpannableStringBuilder mDefaultKeySsb = null;
    private boolean mWorkspaceLoading = true;
    private boolean closePop = LauncherApplication.sApp.getResources().getBoolean(R.bool.close_popwindow);
    private ArrayList<Runnable> mBindOnResumeCallbacks = new ArrayList<>();
    private ArrayList<Runnable> mOnResumeCallbacks = new ArrayList<>();
    private boolean mUserPresent = true;
    private boolean mVisible = false;
    private boolean mHasFocus = false;
    private boolean mAttached = false;
    private final int ADVANCE_MSG = 1;
    private final int mAdvanceInterval = 20000;
    private final int mAdvanceStagger = 250;
    private long mAutoAdvanceTimeLeft = -1;
    private HashMap<View, AppWidgetProviderInfo> mWidgetsToAdvance = new HashMap<>();
    private final int mRestoreScreenOrientationDelay = HttpStatus.SC_INTERNAL_SERVER_ERROR;
    private Intent mAppMarketIntent = null;
    private final ArrayList<Integer> mSynchronouslyBoundPages = new ArrayList<>();
    private Rect mRectForFolderAnimation = new Rect();
    private HideFromAccessibilityHelper mHideFromAccessibilityHelper = new HideFromAccessibilityHelper();
    private Runnable mBuildLayersRunnable = new Runnable() { // from class: com.android.launcher66.Launcher.1
        @Override // java.lang.Runnable
        public void run() {
            if (Launcher.mWorkspace != null) {
                Launcher.mWorkspace.buildPageHardwareLayers();
            }
        }
    };
    Runnable runnable_register = new Runnable() { // from class: com.android.launcher66.Launcher.2
        @Override // java.lang.Runnable
        public void run() {
            TimeUpdateReceiver.register(Launcher.mLauncher);
            Launcher.this.sendBroadcast(new Intent(TimeUpdateReceiver.SHOW_TIME));
        }
    };
    private OnPlayerStatusListener onRefreshKwStatus = new OnPlayerStatusListener() { // from class: com.android.launcher66.Launcher.3
        private /* synthetic */ int[] $SWITCH_TABLE$cn$kuwo$autosdk$api$PlayerStatus;

        /* synthetic */ int[] $SWITCH_TABLE$cn$kuwo$autosdk$api$PlayerStatus() {
            int[] iArr = $SWITCH_TABLE$cn$kuwo$autosdk$api$PlayerStatus;
            if (iArr == null) {
                iArr = new int[PlayerStatus.values().length];
                try {
                    iArr[PlayerStatus.BUFFERING.ordinal()] = 3;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[PlayerStatus.INIT.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[PlayerStatus.PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[PlayerStatus.PLAYING.ordinal()] = 2;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[PlayerStatus.STOP.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                $SWITCH_TABLE$cn$kuwo$autosdk$api$PlayerStatus = iArr;
            }
            return iArr;
        }

        @Override // cn.kuwo.autosdk.api.OnPlayerStatusListener
        public void onPlayerStatus(PlayerStatus status, Music music) {
            if (status != null) {
                switch ($SWITCH_TABLE$cn$kuwo$autosdk$api$PlayerStatus()[status.ordinal()]) {
                    case 2:
                        Launcher.this.mKwPlayState = true;
                        Launcher.this.showKuwoContent = true;
                        break;
                    case 3:
                    default:
                        Launcher.this.mKwPlayState = false;
                        Launcher.this.showKuwoContent = false;
                        break;
                    case 4:
                        Launcher.this.mKwPlayState = false;
                        Launcher.this.showKuwoContent = true;
                        break;
                }
            }
            if (Launcher.this.kuwomusic_playpause != null) {
                if (Launcher.this.mKwPlayState) {
                    Launcher.this.kuwomusic_playpause.setBackgroundResource(ResValue.getInstance().music_playpause_icon);
                } else {
                    Launcher.this.kuwomusic_playpause.setBackgroundResource(ResValue.getInstance().music_pause_icon);
                }
            }
            if (music == null) {
                return;
            }
            if (Launcher.this.mKwMusicName != null) {
                if (Launcher.this.showKuwoContent) {
                    Launcher.this.mKwMusicName.setText(music.name);
                } else {
                    Launcher.this.mKwMusicName.setText(R.string.car_kuwo);
                }
            }
            if (Launcher.this.mKwArtist != null) {
                if (Launcher.this.showKuwoContent) {
                    Launcher.this.mKwArtist.setText(music.artist);
                } else {
                    Launcher.this.mKwArtist.setText(R.string.music_author);
                }
            }
        }
    };
    public String str_toast = "";
    private BroadcastReceiver removeMusic = new BroadcastReceiver() { // from class: com.android.launcher66.Launcher.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context arg0, Intent intent) {
            String action = intent.getAction();
            if (mediaSource == "fyt" && "com.fyt.systemui.remove".equals(action)) {
                Bundle bundle = intent.getExtras();
                String packageName = bundle.getString("pkg");
                if ("com.syu.music".equals(packageName)) {
                    MusicService.state = false;
                    Launcher.this.handler.postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String[] strArr = new String[5];
                            File file = new File(MusicService.music_path);
                            String filename = file.getName();
                            String musictitle = filename.substring(0, filename.lastIndexOf("."));
                            strArr[0] = musictitle; //LauncherApplication.sApp.getResources().getString(R.string.music_name);
                            strArr[1] = MusicService.author_name; //LauncherApplication.sApp.getResources().getString(R.string.music_author);
                            strArr[2] = MusicService.state.toString();
                            strArr[3] = MusicService.album;
                            strArr[4] = MusicService.music_path; //"/" + LauncherApplication.sApp.getResources().getString(R.string.music_name);
                            LauncherNotify.NOTIFIER_MUSIC.set(null, new long[2], new float[]{0.0f, 0.0f}, strArr, MusicService.album_cover, mediaSource);
                        }
                    }, 1000L);
                } else if (FytPackage.GaodeACTION.equals(packageName)) {
                    Launcher.this.handler.postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Launcher.this.mInitNaviInfoView != null && Launcher.this.mNaviRunView != null) {
                                Launcher.this.mInitNaviInfoView.setVisibility(View.VISIBLE);
                                Launcher.this.mNaviRunView.setVisibility(View.GONE);
                            }
                            if (Launcher.this.mTurnIconView != null) {
                                Launcher.this.mTurnIconView.setImageResource(ResValue.getInstance().default_icon);
                            }
                            if (Launcher.this.mCurCityView != null) {
                                Launcher.this.mCurCityView.setText("");
                            }
                            if (Launcher.this.mCurDis_RemainView != null) {
                                Launcher.this.mCurDis_RemainView.setText(Utils.getNameToStr("car_distance"));
                            }
                            if (Launcher.this.mCurDis_AllView != null) {
                                Launcher.this.mCurDis_AllView.setText("0");
                            }
                            if (Launcher.this.mCurDis_SurplusView != null) {
                                Launcher.this.mCurDis_SurplusView.setText("0km");
                            }
                            if (Launcher.this.mCamera_DisView != null) {
                                Launcher.this.mCamera_DisView.setText("");
                            }
                            if (Launcher.this.mCamera_DisImageView != null) {
                                Launcher.this.mCamera_DisImageView.setVisibility(View.GONE);
                            }
                            if (Launcher.this.mCurRemainTimeView != null) {
                                Launcher.this.mCurRemainTimeView.setText("");
                            }
                            if (Launcher.this.mNextRoadNameView != null) {
                                Launcher.this.mNextRoadNameView.setText(Utils.getNameToStr("car_realnavi"));
                            }
                            if (Launcher.this.mNaviMycar != null) {
                                Launcher.this.mNaviMycar.setVisibility(View.VISIBLE);
                            }
                            if (Launcher.this.mCurSpeedView != null) {
                                Launcher.this.mCurSpeedView.setText("0km/h");
                            }
                        }
                    }, 1000L);
                }
            }
        }
    };
    private IUiRefresher refreshBtav = new IUiRefresher() { // from class: com.android.launcher66.Launcher.5
        @Override // com.fyt.car.IUiRefresher
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            String musicName = null;
            String artist = null;
            if (strs != null && strs.length > 1) {
                musicName = strs[0];
                artist = strs[1];
            }
            if (musicName != null && !musicName.equals("") && !musicName.trim().equals("") && Launcher.this.mBtavName != null) {
                Launcher.this.mBtavName.setText(musicName);
            }
            if (artist != null && !artist.equals("") && Launcher.this.mBtavAritst != null) {
                Launcher.this.mBtavAritst.setText(artist);
            }
        }
    };
    IUiRefresher refreshDvr = new IUiRefresher() { // from class: com.android.launcher66.Launcher.6
        @Override // com.fyt.car.IUiRefresher
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            if (ints != null && ints.length > 0) {
                int mDvrRecState = ints[0];
                if (mDvrRecState == 1) {
                    if (Launcher.this.customView.get(Config.WS_Dvr_Rec) != null) {
                        Launcher.this.customView.get(Config.WS_Dvr_Rec).setBackgroundResource(ResValue.getInstance().dvr_stop_btn);
                    }
                } else if (mDvrRecState == 0 && Launcher.this.customView.get(Config.WS_Dvr_Rec) != null) {
                    Launcher.this.customView.get(Config.WS_Dvr_Rec).setBackgroundResource(ResValue.getInstance().dvr_rec_btn);
                }
            }
        }
    };
    private IUiRefresher refreshNaviState = new IUiRefresher() { // from class: com.android.launcher66.Launcher.7
        @Override // com.fyt.car.IUiRefresher
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            Launcher.this.handleNaviState();
        }
    };
    private IUiRefresher refreshNaviView = new IUiRefresher() { // from class: com.android.launcher66.Launcher.8
        @Override // com.fyt.car.IUiRefresher
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            Launcher.this.handleView();
        }
    };
    private int volume = -1;
    private Callback.OnRefreshLisenter refreshMain = new Callback.OnRefreshLisenter() {
        @Override 
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 0) {
                if (ints != null && ints.length > 0) {
                    if (Launcher.this.mRadioPauseButton != null) {
                        if (ints[0] == 1) {
                            Launcher.this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_playpause_icon);
                        } else {
                            Launcher.this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_pause_icon);
                        }
                    }
                    if (LauncherApplication.sApp.getResources().getBoolean(R.bool.worksapce_switch_widget)) {
                        switch (ints[0]) {
                            case 1:
                                if (Launcher.this.mPageRadio != null && Launcher.this.mPageRadio.getVisibility() != View.VISIBLE) {
                                    LogPreview.show("mPageRadio != null");
                                    Launcher.this.mPageRadio.setVisibility(View.VISIBLE);
                                    if (Launcher.this.mPageTime != null) {
                                        Launcher.this.mPageTime.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageMusic != null) {
                                        Launcher.this.mPageMusic.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageBTAV != null) {
                                        Launcher.this.mPageBTAV.setVisibility(View.GONE);
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                if (Launcher.this.mPageBTAV != null && Launcher.this.mPageBTAV.getVisibility() != View.VISIBLE) {
                                    LogPreview.show("mPageBTAV != null");
                                    Launcher.this.mPageBTAV.setVisibility(View.VISIBLE);
                                    if (Launcher.this.mPageTime != null) {
                                        Launcher.this.mPageTime.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageRadio != null) {
                                        Launcher.this.mPageRadio.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageMusic != null) {
                                        Launcher.this.mPageMusic.setVisibility(View.GONE);
                                        break;
                                    }
                                }
                                break;
                            case 8:
                                if (Launcher.this.mPageMusic != null && Launcher.this.mPageMusic.getVisibility() != View.VISIBLE) {
                                    LogPreview.show("mPageMusic != null");
                                    Launcher.this.mPageMusic.setVisibility(View.VISIBLE);
                                    if (Launcher.this.mPageTime != null) {
                                        Launcher.this.mPageTime.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageRadio != null) {
                                        Launcher.this.mPageRadio.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageBTAV != null) {
                                        Launcher.this.mPageBTAV.setVisibility(View.GONE);
                                        break;
                                    }
                                }
                                break;
                            default:
                                if (Launcher.this.mPageTime != null && Launcher.this.mPageTime.getVisibility() != View.VISIBLE) {
                                    Launcher.this.mPageTime.setVisibility(View.VISIBLE);
                                    if (Launcher.this.mPageRadio != null) {
                                        Launcher.this.mPageRadio.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageMusic != null) {
                                        Launcher.this.mPageMusic.setVisibility(View.GONE);
                                    }
                                    if (Launcher.this.mPageBTAV != null) {
                                        Launcher.this.mPageBTAV.setVisibility(View.GONE);
                                        break;
                                    }
                                }
                                break;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (updateCode == 50) {
                if (ints != null && ints.length > 0 && ints[0] == 0) {
                    if (Launcher.this.mInitNaviInfoView != null && Launcher.this.mNaviRunView != null) {
                        Launcher.this.mInitNaviInfoView.setVisibility(View.VISIBLE);
                        Launcher.this.mNaviRunView.setVisibility(View.GONE);
                    }
                    if (Launcher.this.mTurnIconView != null) {
                        Launcher.this.mTurnIconView.setImageResource(ResValue.getInstance().default_icon);
                    }
                    if (Launcher.this.mCurCityView != null) {
                        Launcher.this.mCurCityView.setText("");
                    }
                    if (Launcher.this.mCurDis_RemainView != null) {
                        Launcher.this.mCurDis_RemainView.setText(Utils.getNameToStr("car_distance"));
                    }
                    if (Launcher.this.mCurDis_AllView != null) {
                        Launcher.this.mCurDis_AllView.setText("0");
                    }
                    if (Launcher.this.mCurDis_SurplusView != null) {
                        Launcher.this.mCurDis_SurplusView.setText("0km");
                    }
                    if (Launcher.this.mCamera_DisView != null) {
                        Launcher.this.mCamera_DisView.setText("");
                    }
                    if (Launcher.this.mCurRemainTimeView != null) {
                        Launcher.this.mCurRemainTimeView.setText("");
                    }
                    if (Launcher.this.mCurRemainTimeView != null) {
                        Launcher.this.mCurRemainTimeView.setText("");
                    }
                    if (Launcher.this.mNextRoadNameView != null) {
                        Launcher.this.mNextRoadNameView.setText(Utils.getNameToStr("car_realnavi"));
                    }
                    if (Launcher.this.mNaviMycar != null) {
                        Launcher.this.mNaviMycar.setVisibility(View.VISIBLE);
                    }
                    if (Launcher.this.mCurSpeedView != null) {
                        Launcher.this.mCurSpeedView.setText("0km/h");
                        return;
                    }
                    return;
                }
                return;
            }
            if (updateCode == 4) {
                if (ints != null && ints.length > 0) {
                    Launcher.sNightMode = ints[0] == 1;
                    if (ints[0] == 1) {
                        if (Launcher.this.mCarLightView != null) {
                            Launcher.this.mCarLightView.setBackgroundResource(ResValue.getInstance().navi_mycar2);
                            return;
                        }
                        return;
                    } else {
                        if (Launcher.this.mCarLightView != null) {
                            Launcher.this.mCarLightView.setBackgroundResource(ResValue.getInstance().navi_mycar1);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (updateCode == 101) {
                if (ints != null && ints.length > 0) {
                    Launcher.this.carSpeed = ints[0];
                    if (Launcher.this.carSpeed == 1) {
                        Launcher.this.carSpeed = 0;
                    }
                    if (Launcher.this.mTurntableView != null) {
                        Launcher.this.mTurntableView.setTargetWithAnim(Launcher.this.carSpeed * 100);
                    }
                    if (Launcher.this.mTvSpeed != null) {
                        Launcher.this.mTvSpeed.setText(String.valueOf(LauncherApplication.sApp.getResources().getString(R.string.car_speed)) + Launcher.this.carSpeed);
                    }
                    Widget.update(LauncherApplication.sApp);
                    return;
                }
                return;
            }
            if (updateCode == 3) {
                if (ints != null && ints.length > 0) {
                    if (ints[0] == 0 && Launcher.this.volume > 0) {
                        Launcher.this.setSoundBtn();
                        return;
                    } else {
                        Launcher.this.setSoundCloseBtn();
                        return;
                    }
                }
                return;
            }
            if (updateCode == 2) {
                if (ints != null && ints.length > 0) {
                    Launcher.this.volume = ints[0];
                    if (Launcher.this.volume > 0) {
                        Launcher.this.setSoundBtn();
                        return;
                    } else {
                        Launcher.this.setSoundCloseBtn();
                        return;
                    }
                }
                return;
            }
            if (updateCode == 1000) {
                if (ints != null && ints.length > 0) {
                    int i = ints[0];
                    return;
                }
                return;
            }
            if (updateCode == 31 && ints != null && ints.length > 0) {
                Launcher.this.mBrightLevel = ints[0];
            }
        }
    };
    QSBScroller mQsbScroller = new QSBScroller() { // from class: com.android.launcher66.Launcher.10
        int scrollY = 0;

        @Override // com.android.launcher66.Launcher.QSBScroller
        public void setScrollY(int scroll) {
            this.scrollY = scroll;
            if (Launcher.mWorkspace.isOnOrMovingToCustomContent()) {
                Launcher.this.mSearchDropTargetBar.setTranslationY(-this.scrollY);
                Launcher.this.getQsbBar().setTranslationY(-this.scrollY);
            }
        }
    };
    private int[] images = {ResValue.getInstance().num00, ResValue.getInstance().num01, ResValue.getInstance().num02, ResValue.getInstance().num03, ResValue.getInstance().num04, ResValue.getInstance().num05, ResValue.getInstance().num06, ResValue.getInstance().num07, ResValue.getInstance().num08, ResValue.getInstance().num09};
    String lastpath = null;
    String musicNamePre = "";
    private IUiRefresher refreshMusic = new IUiRefresher() {
        @Override
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            mediaSource = source; 
            String musicName = "";
            state = null;
            String artist = null;
            String album = null;
            String path = null;
            String musictitle = null;
            if (strs != null && strs.length > 5) {
                musicName = strs[0];
                artist = strs[1];
                if (artist == "null") {
                    artist = strs[3];
                }
                if (artist == "null") {
                    artist = "";
                }
                state = strs[2];
                album = strs[3];
                path = strs[4];
                activeController = strs[5];
            }
            musictitle = musicName;
            if (Launcher.this.music_playpause != null) {
                if (MusicService.state.booleanValue() || am.isMusicActive()) {
                    Launcher.this.music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                } else {
                    Launcher.this.music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                }
            }
            if (Launcher.this.music_playpause_two != null) {
                if (MusicService.state.booleanValue() || am.isMusicActive()) {
                    Launcher.this.music_playpause_two.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                } else {
                    Launcher.this.music_playpause_two.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                }
            }
            if (!musicName.equals(Launcher.this.musicNamePre)) {
                Launcher.this.musicNamePre = musicName;
                Lrc lrc = new Lrc();
                Id3Info info = lrc.getId3Info(path);
                byte[] dataPic =  info.dataPic;
                if (dataPic == null) {
                    dataPic =  byts;
                }
                if (dataPic != null && dataPic.length > 0) {
                    Bitmap bp = BitmapFactory.decodeByteArray(dataPic, 0, dataPic.length);
                    if (bp != null) {
                        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.music_bitmap_circular)) {
                            if (Utils.getNameToBool("isRoundedCorner")) {
                                bp = Launcher.GetRoundedCornerBitmap(bp);
                            } else {
                                bp = Launcher.makeRoundCorner(bp);
                            }
                        }
                        Drawable drawable = new BitmapDrawable(bp);
                        if (Launcher.this.ivALbumBg != null) {
                            Launcher.this.ivALbumBg.setImageDrawable(drawable);
                        }
                    }
                } else {
                    Launcher.this.lastpath = null;
                    if (Launcher.this.ivALbumBg != null) {
                        Launcher.this.ivALbumBg.setImageResource(ResValue.getInstance().music_album_def);
                    }
                }
            }
            if ("true".equals(state)) {
                if (Launcher.this.ivMusicScore != null) {
                    ((AnimationDrawable) Launcher.this.ivMusicScore.getDrawable()).start();
                }
                if (Launcher.this.ivMusicScore2 != null) {
                    ((AnimationDrawable) Launcher.this.ivMusicScore2.getDrawable()).start();
                }


                if (musictitle != null && !musictitle.isEmpty() && !musictitle.trim().isEmpty()) {
                    if (Launcher.this.tvMusicName != null) {
                        Launcher.this.tvMusicName.setText(musictitle);
                    }
                    if (Launcher.this.tvMusicNameTwo != null) {
                        Launcher.this.tvMusicNameTwo.setText(musictitle);
                    }
                }
                if (artist != null && !artist.isEmpty() && !artist.trim().isEmpty() && Launcher.this.tvAritst != null) {
                    Launcher.this.tvAritst.setText(artist);
                }
                if (album != null && !album.isEmpty() && !album.trim().isEmpty() && Launcher.this.tvAlbum != null) {
                    Launcher.this.tvAlbum.setText(album);
                }
                if (lngs != null && lngs.length > 1) {
                    long curProgress = lngs[1];
                    long totalProgress = lngs[0];
                    if (totalProgress > 0) {
                        if (curProgress < 0) {
                            curProgress = 0;
                        }
                        int precent = (int) ((1000 * curProgress) / totalProgress);
                        if (precent < 5) {
                            if (Launcher.this.musicSeekBar != null) {
                                Launcher.this.musicSeekBar.setProgress(5);
                            }
                            if (Launcher.this.musicProgress != null) {
                                Launcher.this.musicProgress.setProgress(precent);
                            }
                        } else {
                            if (Launcher.this.musicSeekBar != null) {
                                Launcher.this.musicSeekBar.setProgress(precent);
                            }
                            if (Launcher.this.musicProgress != null) {
                                Launcher.this.musicProgress.setProgress(precent);
                            }
                        }
                    }
                    String cur = Launcher.this.timeParse(curProgress);
                    String total = Launcher.this.timeParse(totalProgress);
                    if (Launcher.this.tvCurTime != null && cur != null) {
                        Launcher.this.tvCurTime.setText(cur);
                    }
                    if (Launcher.this.tvTotalTime != null && total != null) {
                        Launcher.this.tvTotalTime.setText(total);
                        return;
                    }
                    return;
                }
                return;
            }
            if (CarStates.mAppID != 8  && mediaSource == "fyt") {
                Utils.setTextId(Launcher.this.tvMusicName, R.string.music_name);
                Utils.setTextId(Launcher.this.tvAritst, R.string.music_author);
                Utils.setTextId(Launcher.this.tvMusicNameTwo, R.string.music_name);
                Utils.setTextStr(Launcher.this.tvCurTime, "00:00");
                Utils.setTextStr(Launcher.this.tvTotalTime, "00:00");
                if (Launcher.this.musicSeekBar != null) {
                    Launcher.this.musicSeekBar.setProgress(0);
                }
                if (Launcher.this.musicProgress != null) {
                    Launcher.this.musicProgress.setProgress(0);
                }
                if (Launcher.this.music_playpause != null) {
                    Launcher.this.music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                    return;
                }
                return;
            }
            if (Launcher.this.ivMusicScore != null) {
                ((AnimationDrawable) Launcher.this.ivMusicScore.getDrawable()).selectDrawable(0);
                ((AnimationDrawable) Launcher.this.ivMusicScore.getDrawable()).stop();
            }
            if (Launcher.this.ivMusicScore2 != null) {
                ((AnimationDrawable) Launcher.this.ivMusicScore2.getDrawable()).selectDrawable(0);
                ((AnimationDrawable) Launcher.this.ivMusicScore2.getDrawable()).stop();
            }
            /*if (Launcher.this.music_playpause != null) {
                Launcher.this.music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }
            if (Launcher.this.music_playpause_two != null) {
                Launcher.this.music_playpause_two.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }*/
            if (musictitle != null && !musictitle.isEmpty() && !musictitle.trim().isEmpty()) {
                if (Launcher.this.tvMusicName != null) {
                    Launcher.this.tvMusicName.setText(musictitle);
                }
                if (Launcher.this.tvMusicNameTwo != null) {
                    Launcher.this.tvMusicNameTwo.setText(musictitle);
                }
            }
            if (artist != null && !artist.isEmpty() && !artist.trim().isEmpty() && Launcher.this.tvAritst != null) {
                Launcher.this.tvAritst.setText(artist);
            }
            Widget.update(LauncherApplication.sApp);
        }
    };
    private int radioBand = -1;
    Callback.OnRefreshLisenter refreshRadioBand = new Callback.OnRefreshLisenter() { // from class: com.android.launcher66.Launcher.12
        @Override // com.syu.remote.Callback.OnRefreshLisenter
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 0 && ints != null && ints.length > 0) {
                int band = ints[0];
                Log.d("LZP", "-------->>> FinalRadio.U_BAND" + band);
                if (band == 65536 || band == 65537 || band == 65538) {
                    Launcher.this.radioBand = 0;
                } else if (band == 0 || band == 1) {
                    Launcher.this.radioBand = 1;
                }
            }
        }
    };
    Callback.OnRefreshLisenter refreshRadioFreq = new Callback.OnRefreshLisenter() { // from class: com.android.launcher66.Launcher.13
        @Override // com.syu.remote.Callback.OnRefreshLisenter
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 1 && ints != null && ints.length > 0) {
                Launcher.radioFreqState = ints[0];
                if (ints[0] > 5000) {
                    int fmFreq = ints[0];
                    Launcher.freq = Launcher.this.freqToString(fmFreq);
                    String str = Launcher.this.freqToString(ints[0]);
                    String freqs = String.valueOf(str.substring(0, str.length() - 2)) + "." + str.substring(str.length() - 2, str.length());
                    Launcher.radioFreq = freqs;
                    if (Launcher.this.tvCurFreq != null) {
                        Launcher.this.tvCurFreq.setText(freqs);
                    }
                    if (Launcher.this.tvBand != null) {
                        if (Launcher.this.tvBand.getBackground() != null) {
                            Launcher.this.tvBand.setBackgroundResource(ResValue.getInstance().fm);
                        } else {
                            Launcher.this.tvBand.setText("FM");
                        }
                    }
                    if (Launcher.this.tvUnit != null) {
                        Launcher.this.tvUnit.setText("MHz");
                    }
                    if (Launcher.this.img_freq_point != null) {
                        Launcher.this.img_freq_point.setTargetMarkAnim(fmFreq, 8750, 10800);
                    }
                } else if (ints[0] < 5000 && ints[0] > 500) {
                    Launcher.freq = Launcher.this.freqToString(ints[0]);
                    Launcher.radioFreq = Launcher.freq;
                    if (Launcher.this.tvCurFreq != null) {
                        Launcher.this.tvCurFreq.setText(Launcher.freq);
                    }
                    if (Launcher.this.tvBand != null) {
                        if (Launcher.this.tvBand.getBackground() != null) {
                            Launcher.this.tvBand.setBackgroundResource(ResValue.getInstance().am);
                        } else {
                            Launcher.this.tvBand.setText("AM");
                        }
                    }
                    if (Launcher.this.tvUnit != null) {
                        Launcher.this.tvUnit.setText("KHz");
                    }
                    if (Launcher.this.img_freq_point != null) {
                        Launcher.this.img_freq_point.setTargetMarkAnim(ints[0], 522, 1620);
                    }
                }
            }
            Widget.update(LauncherApplication.sApp);
        }
    };
    private IUiRefresher refreshVideo = new IUiRefresher() { // from class: com.android.launcher66.Launcher.14
        @Override // com.fyt.car.IUiRefresher
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) { 
            if (strs != null && strs.length > 0) {
                Launcher.this.mVideoPlayState = strs[0];
                if (Launcher.this.video_playpause != null && Launcher.this.mVideoPlayState != null) {
                    if ("true".equals(Launcher.this.mVideoPlayState)) {
                        Launcher.this.video_playpause.setBackgroundResource(ResValue.getInstance().music_playpause_icon);
                    } else if ("false".equals(Launcher.this.mVideoPlayState)) {
                        Launcher.this.video_playpause.setBackgroundResource(ResValue.getInstance().music_pause_icon);
                    }
                }
            }
        }
    };
    boolean bClear = false;
    Callback.OnRefreshLisenter refreshBtInfo = new Callback.OnRefreshLisenter() { // from class: com.android.launcher66.Launcher.15
        @Override // com.syu.remote.Callback.OnRefreshLisenter
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 0) {
                if (strs != null && strs.length > 0) {
                    Launcher.btName = strs[0];
                    if (Launcher.this.mBtavName != null) {
                        if (Launcher.btName == null || Launcher.btName.isEmpty()) {
                            Launcher.this.mBtavName.setText(R.string.car_bt_music);
                        } else {
                            Launcher.this.mBtavName.setText(Launcher.btName);
                        }
                    }
                }
            } else if (updateCode == 1) {
                if (strs != null && strs.length > 0) {
                    Launcher.btArtist = strs[0];
                    if (Launcher.this.mBtavAritst != null) {
                        if (Launcher.btArtist == null || Launcher.btArtist.isEmpty()) {
                            Launcher.this.mBtavAritst.setText(R.string.music_author);
                        } else {
                            Launcher.this.mBtavAritst.setText(Launcher.btArtist);
                        }
                    }
                }
            } else if (updateCode == 26) {
                if (strs != null && strs.length > 0) {
                    String btAlbum = strs[0];
                    if (Launcher.this.mBtavAlbum != null) {
                        if (btAlbum == null || btAlbum.isEmpty()) {
                            Launcher.this.mBtavAlbum.setText(R.string.music_album);
                        } else {
                            Launcher.this.mBtavAlbum.setText(btAlbum);
                        }
                    }
                }
            } else if (updateCode == 2) {
                if (ints != null && ints.length > 0) {
                    Launcher.btTotalTime = ints[0];
                    String bttotal = Launcher.this.timeChangeParse(Launcher.btTotalTime);
                    if (Launcher.this.tvBtavTotalTime != null) {
                        if (bttotal == null || bttotal.isEmpty()) {
                            Launcher.this.tvBtavTotalTime.setText("00:00:00");
                        } else {
                            Launcher.this.tvBtavTotalTime.setText(bttotal);
                        }
                    }
                }
            } else if (updateCode == 28) {
                if (ints != null && ints.length > 0) {
                    Launcher.btCurTime = ints[0];
                    String btcur = Launcher.this.timeChangeParse(Launcher.btCurTime);
                    if (Launcher.this.tvBtavCurTime != null) {
                        if (btcur == null || btcur.equals("")) {
                            Launcher.this.tvBtavCurTime.setText("00:00:00");
                        } else {
                            Launcher.this.tvBtavCurTime.setText(btcur);
                        }
                    }
                    if (Launcher.btTotalTime <= 0) {
                        if (Launcher.this.btavProgress != null) {
                            Launcher.this.btavProgress.setProgress(0);
                        }
                    } else {
                        if (Launcher.btCurTime < 0) {
                            Launcher.btCurTime = 0;
                        }
                        int precent = (Launcher.btCurTime * 1000) / Launcher.btTotalTime;
                        if (precent < 5) {
                            if (Launcher.this.btavProgress != null) {
                                Launcher.this.btavProgress.setProgress(5);
                            }
                        } else if (Launcher.this.btavProgress != null) {
                            Launcher.this.btavProgress.setProgress(precent);
                        }
                    }
                }
            } else if (updateCode == 13) {
                if (ints != null && ints.length > 0) {
                    Launcher.btavState = ints[0];
                    if (Launcher.btavState == 1) {
                        if (Launcher.this.mBtavPlayPauseButton != null) {
                            Launcher.this.mBtavPlayPauseButton.setBackgroundResource(ResValue.getInstance().btav_playpause_icon);
                        }
                    } else if (Launcher.this.mBtavPlayPauseButton != null) {
                        Launcher.this.mBtavPlayPauseButton.setBackgroundResource(ResValue.getInstance().btav_pause_icon);
                    }
                }
            } else if (updateCode == 9) {
                if (ints != null && ints.length > 0) {
                    Launcher.phoneState = ints[0];
                    if (ints[0] == 0) {
                        Launcher.this.bClear = true;
                        if (Launcher.this.btavProgress != null) {
                            Launcher.this.btavProgress.setProgress(0);
                        }
                        if (Launcher.this.tvBtavCurTime != null) {
                            Launcher.this.tvBtavCurTime.setText("00:00:00");
                        }
                        if (Launcher.this.tvBtavTotalTime != null) {
                            Launcher.this.tvBtavTotalTime.setText("00:00:00");
                        }
                    } else if (Launcher.this.bClear) {
                        Launcher.this.tools.notify(2, 2, 28);
                        Launcher.this.bClear = false;
                    }
                }
            } else if (updateCode == 7 && strs != null && strs.length > 0) {
                String btName2 = strs[0];
                if (Launcher.this.mTvBtPhoneName != null) {
                    if (btName2 == null || btName2.equals("")) {
                        Launcher.this.mTvBtPhoneName.setText(R.string.car_bt_notconnect);
                    } else {
                        String btNameend = String.valueOf(Launcher.this.getResources().getString(R.string.car_bt_connected)) + "\n" + btName2;
                        Launcher.this.mTvBtPhoneName.setText(btNameend);
                    }
                }
            }
            Widget.update(LauncherApplication.sApp);
        }
    };
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.android.launcher66.Launcher.16
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                Launcher.this.mUserPresent = false;
                Launcher.this.mDragLayer.clearAllResizeFrames();
                Launcher.this.updateRunning();
                if (Launcher.this.mAppsCustomizeTabHost != null && Launcher.this.mPendingAddInfo.container == -1) {
                    Launcher.this.showWorkspace(true);
                    return;
                }
                return;
            }
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                Launcher.this.mUserPresent = true;
                Launcher.this.updateRunning();
            }
        }
    };
    private final Handler mHandler = new Handler() { // from class: com.android.launcher66.Launcher.17
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int i = 0;
                for (View key : Launcher.this.mWidgetsToAdvance.keySet()) {
                    final View v = key.findViewById(((AppWidgetProviderInfo) Launcher.this.mWidgetsToAdvance.get(key)).autoAdvanceViewId);
                    int delay = i * 250;
                    if (v instanceof Advanceable) {
                        postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((Advanceable) v).advance();
                            }
                        }, delay);
                    }
                    i++;
                }
                Launcher.this.sendAdvanceMessage(20000L);
            }
        }
    };
    boolean success = false;
    private Runnable mBindPackagesUpdatedRunnable = new Runnable() { // from class: com.android.launcher66.Launcher.18
        @Override // java.lang.Runnable
        public void run() {
            Launcher.this.bindPackagesUpdated(Launcher.this.mWidgetsAndShortcuts);
            Launcher.this.mWidgetsAndShortcuts = null;
        }
    };

    public interface CustomContentCallbacks {
        void onHide();

        void onScrollProgressChanged(float f);

        void onShow();
    }

    public interface QSBScroller {
        void setScrollY(int i);
    }

    private enum State {
        NONE,
        WORKSPACE,
        APPS_CUSTOMIZE,
        APPS_CUSTOMIZE_SPRING_LOADED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] valuesCustom = values();
            int length = valuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(valuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    private static class PendingAddArguments {
        int cellX;
        int cellY;
        long container;
        Intent intent;
        int requestCode;
        long screenId;

        private PendingAddArguments() {
        }

        /* synthetic */ PendingAddArguments(PendingAddArguments pendingAddArguments) {
            this();
        }
    }

    private SpannableString setSpan(String str) {
        SpannableString msp = new SpannableString(str);
        msp.setSpan(new RelativeSizeSpan(1.0f), str.length() - 1, str.length(), 33);
        return msp;
    }

    public String getPrintSize(long size) {
        if (size < 1000) {
            return String.valueOf(size) + "M";
        }
        if (size >= 1000 && size < 1048576) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            float num = ((float) size) / 1024.0f;
            return String.valueOf(decimalFormat.format(num)) + "G";
        }
        if (size >= 1048576 && size < 1073741824) {
            DecimalFormat decimalFormat2 = new DecimalFormat("0.00");
            float num2 = (((float) size) / 1024.0f) / 1024.0f;
            return String.valueOf(decimalFormat2.format(num2)) + "t";
        }
        return "";
    }

    private static boolean isPropertyEnabled(String propertyName) {
        return Log.isLoggable(propertyName, Log.VERBOSE);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean("transparent_statusbar", false)) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        checkNotificationPermission();        
        userLayout = prefs.getBoolean("user_layout", false);
        leftBar = prefs.getBoolean("left_bar", false); 
        if (userLayout) {
            setWindowLocUser();
        } else {
            setWindowLocDefault();
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        float density = getResources().getDisplayMetrics().density;
        LogPreview.show("------------------->>> density:" + density);
        checkForLocaleChange();
        initVariable();
        registerContentObservers();
        lockAllApps();
        this.mSavedState = savedInstanceState;
        restoreState(this.mSavedState);
        if (this.mAppsCustomizeContent != null) {
            this.mAppsCustomizeContent.onPackagesUpdated(LauncherModel.getSortedWidgetsAndShortcuts(this));
        }
        if (!this.mRestoring) {
            if (sPausedFromUserAction) {
                mModel.startLoader(true, -1);
            } else {
                mModel.startLoader(true, mWorkspace.getCurrentPage());
            }
        }
        this.mDefaultKeySsb = new SpannableStringBuilder();
        Selection.setSelection(this.mDefaultKeySsb, 0);
        this.mHandler.post(this.runnable_register);
        updateGlobalIcons();
        unlockScreenOrientation(true);
        showFirstRunCling();
        if (!this.mSharedPrefs.getBoolean("cling_gel.first_run.dismissed", false)) {
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.isdefaultwallpaper)) {
                setDefaultWallpaper();
            }
            SharedPreferences.Editor editor = this.mSharedPrefs.edit();
            editor.putBoolean("cling_gel.first_run.dismissed", true);
            editor.commit();
        }
        initRegisterReceiver();
        Widget.update(LauncherApplication.sApp);
    }

    private void checkNotificationPermission() {
        // Notifications access permission
        String notificationListenerString = Settings.Secure.getString(this.getContentResolver(), "enabled_notification_listeners");
        if (notificationListenerString == null || !notificationListenerString.contains(getPackageName())) {
            Intent intentNoti = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            intentNoti.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentNoti.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intentNoti.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            startActivity(intentNoti);
        }
    }

    public int getStatusBarHeight() { 
          int result = 0;
          int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
          if (resourceId > 0) {
              result = getResources().getDimensionPixelSize(resourceId);
          } 
          return result;
    } 

    private void setWindowLocDefault() {
        SystemProperties.set("persist.syu.launcher.haspip", "true");
        SystemProperties.set("persist.lsec.radius", "14");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY).activityInfo.packageName.equals(getPackageName())) {
            View iv_map = this.findViewById(R.id.iv_map1);
            if (getResources().getDisplayMetrics().widthPixels == 1024) {
                SystemProperties.set("sys.lsec.pip_rect", "114 74 677 522");
            } else if (getResources().getDisplayMetrics().widthPixels == 1280) {
                SystemProperties.set("sys.lsec.pip_rect", "124 74 852 606");
            } else if (getResources().getDisplayMetrics().widthPixels == 1920) {
                SystemProperties.set("sys.lsec.pip_rect", "124 74 1497 611");
            } else {
                if (getResources().getDisplayMetrics().heightPixels == 1100) {
                    SystemProperties.set("sys.lsec.pip_rect", "162 120 1302 960");
                } else if (getResources().getDisplayMetrics().heightPixels == 1200) {
                    SystemProperties.set("sys.lsec.pip_rect", "162 120 1302 1060");
                }           
            }   
        }
    }

    private void setWindowLocUser() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int mapTopLeftX, mapBottomRightX, leftBarSize;
        if (getResources().getDisplayMetrics().widthPixels == 1024) {
            leftBarSize = 100;
        } else if (getResources().getDisplayMetrics().widthPixels == 1280
                || getResources().getDisplayMetrics().widthPixels == 1920) {
            leftBarSize = 110;
        } else {
            leftBarSize = 142;               
        }  
        if (leftBar) {
            mapTopLeftX = prefs.getInt("mapTopLeftX", 114) + leftBarSize;
            mapBottomRightX = prefs.getInt("mapBottomRightX", 677) + leftBarSize;   
        } else {
            mapTopLeftX = prefs.getInt("mapTopLeftX", 114);
            mapBottomRightX = prefs.getInt("mapBottomRightX", 677);
        }
        int mapTopLeftY = prefs.getInt("mapTopLeftY", 74) + getStatusBarHeight();
        int mapBottomRightY = prefs.getInt("mapBottomRightY", 522) + getStatusBarHeight();
        SystemProperties.set("persist.syu.launcher.haspip", "true");
        SystemProperties.set("persist.lsec.radius", "14");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY).activityInfo.packageName.equals(getPackageName())) {
            View iv_map = this.findViewById(R.id.iv_map1);
            // top-left x, top left y, bottom right x, bottom right y
            SystemProperties.set("sys.lsec.pip_rect", String.valueOf(mapTopLeftX + " " + mapTopLeftY + " " + mapBottomRightX + " " + mapBottomRightY));
        }
    }

    private void initVariable() {
        mLauncher = this;
        this.app = LauncherApplication.sApp;
        this.mInflater = getLayoutInflater();
        W3Utils.addFilterApp(FytPackage.browserAction);
        LauncherAppState.setApplicationContext(getApplicationContext());
        LauncherAppState app = LauncherAppState.getInstance();
        ContentResolver resolver = getApplicationContext().getContentResolver();
        Config.PLATFORM_ID = ShareHandler.getInt(resolver, 10, 0);
        Config.CUSTOMER_ID = ShareHandler.getInt(resolver, 9, 0);
        Config.USER_UIID = ShareHandler.getInt(resolver, 11, 0);
        Config.CHIP_UIID = ShareHandler.getInt(resolver, 13, 0);
        Point smallestSize = new Point();
        Point largestSize = new Point();
        Point realSize = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getCurrentSizeRange(smallestSize, largestSize);
        display.getRealSize(realSize);
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        DeviceProfile grid = app.initDynamicGrid(this, dm.widthPixels, dm.heightPixels, realSize.x, realSize.y, dm.widthPixels, dm.heightPixels);
        this.mSharedPrefs = getSharedPreferences(LauncherAppState.getSharedPreferencesKey(), 0);
        mModel = app.setLauncher(this);
        this.mIconCache = app.getIconCache();
        this.mIconCache.flushInvalidIcons(grid);
        this.mDragController = new DragController(this);
        setContentView(R.layout.launcher);
        setupViews();
        grid.layout(this);
        this.mStats = new Stats(this);
        this.mCurrWallpaperRes = this.mSharedPrefs.getString(SP_WALLPAPER, "");
        if (TextUtils.isEmpty(this.mCurrWallpaperRes)) {
            this.mCurrWallpaperRes = "def_bg";
        }
        this.mAppWidgetManager = AppWidgetManager.getInstance(this);
        this.mAppWidgetHost = new LauncherAppWidgetHost(this, APPWIDGET_HOST_ID);
        this.mAppWidgetHost.startListening();
        this.manager = WeatherManager.initialize(this);
        kwAPi = KWAPI.createKWAPI(this, "fangyitong");
        if (kwAPi != null) {
            kwAPi.registerPlayerStatusListener(this, this.onRefreshKwStatus);
        }
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private void initRegisterReceiver() {
        IntentFilter filter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        filter.addAction("com.lsec.pipdie");
        filter.addAction("com.lsec.tyz.action.voice.launcher");
        filter.addAction("FOURCAMERA2_BROADCAST_SEND");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.mCloseSystemDialogsReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.mCloseSystemDialogsReceiver, filter);
        }
        IntentFilter musicFilter = new IntentFilter();
        musicFilter.addAction("com.fyt.systemui.remove");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.removeMusic, musicFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.removeMusic, musicFilter);
        }
        this.mAutoMap = new MyAutoMapReceiver();
        IntentFilter amapFilter = new IntentFilter();
        amapFilter.addAction("AUTONAVI_STANDARD_BROADCAST_SEND");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.mAutoMap, amapFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.mAutoMap, amapFilter);
        }
        this.mTrifficReceiver = new TrifficReceiver();
        IntentFilter trifficFilter = new IntentFilter();
        trifficFilter.addAction("intent.action.mapgoo.simtool.info.triffic.v2");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.mTrifficReceiver, trifficFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.mTrifficReceiver, trifficFilter);
        }
    }

    public void updateView() {
        if (this.mTvSettings != null) {
            this.mTvSettings.setText(R.string.car_settings);
        }
        if (this.mTvCar != null) {
            this.mTvCar.setText(R.string.car_car);
        }
        if (this.mTvNavi != null) {
            this.mTvNavi.setText(R.string.car_navi);
        }
        if (this.mTvMusic != null) {
            this.mTvMusic.setText(R.string.car_music);
        }
        if (this.mTvRadio != null) {
            this.mTvRadio.setText(R.string.car_radio);
        }
        if (this.mMiuDrive != null) {
            this.mMiuDrive.setText(R.string.car_miu_drive);
        }
        if (this.mTvAux != null) {
            this.mTvAux.setText(R.string.car_aux);
        }
        if (this.mTvBt != null) {
            this.mTvBt.setText(R.string.car_bt);
        }
        if (this.mTvMovie != null) {
            this.mTvMovie.setText(R.string.car_video);
        }
        if (this.mTvFile != null) {
            this.mTvFile.setText(R.string.car_file);
        }
        if (this.mTvGallery != null) {
            this.mTvGallery.setText(R.string.car_gallery);
        }
        if (this.mTvDVR != null) {
            this.mTvDVR.setText(R.string.car_dvr);
        }
        if (this.mTvApps != null) {
            this.mTvApps.setText(R.string.car_app);
        }
        if (this.mKwMusicName != null) {
            this.mKwMusicName.setText(R.string.car_kuwo);
        }
        if (this.mKwArtist != null) {
            this.mKwArtist.setText(R.string.music_author);
        }
        if (this.mTvBtPhoneName != null) {
            this.mTvBtPhoneName.setText(R.string.car_bt_notconnect);
        }
        if (this.mTvCanbus != null) {
            this.mTvCanbus.setText(R.string.car_canbus);
        }
        if (this.mTvGuide != null) {
            this.mTvGuide.setText(Utils.getNameToStr("car_guide"));
        }
        if (this.mTvCalculator != null) {
            this.mTvCalculator.setText(Utils.getNameToStr("car_calculator"));
        }
        if (this.mTvEq != null) {
            this.mTvEq.setText(R.string.car_eq);
        }
    }

    public void showWeatherInfo() {
        if (this.manager != null) {
            this.manager.addOnWeatherChangedListener(new WeatherManager.OnWeatherChangedListener() { // from class: com.android.launcher66.Launcher.19
                @Override // com.syu.weather.WeatherManager.OnWeatherChangedListener
                public void onWeatherChanged(WeatherDescription weather) {
                    if (weather != null) {
                        if (Launcher.this.weatherImg != null) {
                            Launcher.this.weatherImg.setImageResource(WeatherUtils.getWeatherImagId(Launcher.this.getApplicationContext(), weather.getWeather()));
                        }
                        String range = weather.getTemDescription().replaceAll("\\.\\d", "");
                        String temp = weather.getCurTem().replaceAll("\\.\\d", "");
                        if (Launcher.this.weatherCity != null) {
                            Launcher.this.weatherCity.setText(new StringBuilder(String.valueOf(weather.getCity())).toString());
                        }
                        if (Launcher.this.weatherWeather != null) {
                            Launcher.this.weatherWeather.setText(new StringBuilder(String.valueOf(weather.getWeather())).toString());
                        }
                        if (Launcher.this.weatherTemp != null) {
                            Launcher.this.weatherTemp.setText(new StringBuilder(String.valueOf(temp)).toString());
                        }
                        if (Launcher.this.weatherTempRange != null) {
                            Launcher.this.weatherTempRange.setText(new StringBuilder(String.valueOf(range)).toString());
                        }
                        if (Launcher.this.weatherImg1 != null) {
                            Launcher.this.weatherImg1.setImageResource(WeatherUtils.getWeatherImagId(Launcher.this.getApplicationContext(), weather.getWeather()));
                        }
                        if (Launcher.this.weatherCity1 != null) {
                            Launcher.this.weatherCity1.setText(new StringBuilder(String.valueOf(weather.getCity())).toString());
                        }
                        if (Launcher.this.weatherWeather1 != null) {
                            Launcher.this.weatherWeather1.setText(new StringBuilder(String.valueOf(weather.getWeather())).toString());
                        }
                        if (Launcher.this.weatherTemp1 != null) {
                            Launcher.this.weatherTemp1.setText(new StringBuilder(String.valueOf(temp)).toString());
                        }
                        if (Launcher.this.weatherTempRange1 != null) {
                            Launcher.this.weatherTempRange1.setText(new StringBuilder(String.valueOf(range)).toString());
                        }
                        if (Launcher.this.weatherWind != null) {
                            Launcher.this.weatherWind.setText(new StringBuilder(String.valueOf(weather.getWind())).toString());
                        }
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        sPausedFromUserAction = true;
    }

    protected boolean hasCustomContentToLeft() {
        return false;
    }

    protected void addCustomContentToLeft() {
    }

    protected void invalidateHasCustomContentToLeft() {
        if (mWorkspace != null && !mWorkspace.getScreenOrder().isEmpty()) {
            if (!mWorkspace.hasCustomContent() && hasCustomContentToLeft()) {
                mWorkspace.createCustomContentPage();
                addCustomContentToLeft();
            } else if (mWorkspace.hasCustomContent() && !hasCustomContentToLeft()) {
                mWorkspace.removeCustomContentPage();
            }
        }
    }

    private void updateGlobalIcons() {
        boolean searchVisible = false;
        boolean voiceVisible = false;
        int coi = getCurrentOrientationIndexForGlobalIcons();
        if (sGlobalSearchIcon[coi] == null || sVoiceSearchIcon[coi] == null || sAppMarketIcon[coi] == null) {
            searchVisible = updateGlobalSearchIcon();
            voiceVisible = updateVoiceSearchIcon(searchVisible);
        }
        if (sGlobalSearchIcon[coi] != null) {
            updateGlobalSearchIcon(sGlobalSearchIcon[coi]);
            searchVisible = true;
        }
        if (sVoiceSearchIcon[coi] != null) {
            updateVoiceSearchIcon(sVoiceSearchIcon[coi]);
            voiceVisible = true;
        }
        if (this.mSearchDropTargetBar != null) {
            this.mSearchDropTargetBar.onSearchPackagesChanged(searchVisible, voiceVisible);
        }
    }


    public void checkForLocaleChange() {
        boolean localeChanged = false;
        if (sLocaleConfiguration == null) {
            new AsyncTask<Void, Void, LocaleConfiguration>() {
                
                public LocaleConfiguration doInBackground(Void... unused) {
                    LocaleConfiguration localeConfiguration = new LocaleConfiguration((LocaleConfiguration) null);
                    Launcher.readConfiguration(Launcher.this, localeConfiguration);
                    return localeConfiguration;
                }

                public void onPostExecute(LocaleConfiguration result) {
                    Launcher.sLocaleConfiguration = result;
                    Launcher.this.checkForLocaleChange();
                }
            }.execute(new Void[0]);
            return;
        }
        Configuration configuration = getResources().getConfiguration();
        String previousLocale = sLocaleConfiguration.locale;
        String locale = configuration.locale.toString();
        int previousMcc = sLocaleConfiguration.mcc;
        int mcc = configuration.mcc;
        int previousMnc = sLocaleConfiguration.mnc;
        int mnc = configuration.mnc;
        if (!(locale.equals(previousLocale) && mcc == previousMcc && mnc == previousMnc)) {
            localeChanged = true;
        }
        if (localeChanged) {
            sLocaleConfiguration.locale = locale;
            sLocaleConfiguration.mcc = mcc;
            sLocaleConfiguration.mnc = mnc;
            this.mIconCache.flush();
            final LocaleConfiguration localeConfiguration = sLocaleConfiguration;
            new Thread("WriteLocaleConfiguration") {
                public void run() {
                    try {
                        Launcher.writeConfiguration(Launcher.this, localeConfiguration);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        }
    }

    private static class LocaleConfiguration {
        public String locale;
        public int mcc;
        public int mnc;

        private LocaleConfiguration() {
            this.mcc = -1;
            this.mnc = -1;
        }

        /* synthetic */ LocaleConfiguration(LocaleConfiguration localeConfiguration) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readConfiguration(Context context, LocaleConfiguration configuration) {
        DataInputStream in = null;
        try {
            DataInputStream in2 = new DataInputStream(context.openFileInput(PREFERENCES));
            try {
                configuration.locale = in2.readUTF();
                configuration.mcc = in2.readInt();
                configuration.mnc = in2.readInt();
                if (in2 != null) {
                    try {
                        in2.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                in = in2;
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                in = in2;
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                in = in2;
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
        } catch (IOException e8) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeConfiguration(Context context, LocaleConfiguration configuration) throws Throwable {
        DataOutputStream out = null;
        DataOutputStream out2 = null;
        try {
            out = new DataOutputStream(context.openFileOutput(PREFERENCES, 0));
        } catch (Throwable th) {
            th = th;
        }
        try {
            out.writeUTF(configuration.locale);
            out.writeInt(configuration.mcc);
            out.writeInt(configuration.mnc);
            out.flush();
            if (out != null) {
                try {
                    out.close();
                    out2 = out;
                } catch (IOException e3) {
                    out2 = out;
                }
            } else {
                out2 = out;
            }
        } catch (FileNotFoundException e4) {
            out2 = out;
            if (out2 != null) {
                try {
                    out2.close();
                } catch (IOException e5) {
                }
            }
        } catch (IOException e6) {
            out2 = out;
            context.getFileStreamPath(PREFERENCES).delete();
            if (out2 != null) {
                try {
                    out2.close();
                } catch (IOException e7) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            out2 = out;
            if (out2 != null) {
                try {
                    out2.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
    }

    public Stats getStats() {
        return this.mStats;
    }

    public LayoutInflater getInflater() {
        return this.mInflater;
    }

    public View getAllAppsButton() {
        return this.mAllAppsButton;
    }

    public DragLayer getDragLayer() {
        return this.mDragLayer;
    }

    boolean isDraggingEnabled() {
        return !mModel.isLoadingWorkspace();
    }

    static int getScreen() {
        int i;
        synchronized (sLock) {
            i = sScreen;
        }
        return i;
    }

    static void setScreen(int screen) {
        synchronized (sLock) {
            sScreen = screen;
        }
    }

    private boolean completeAdd(PendingAddArguments args) {
        boolean result = false;
        switch (args.requestCode) {
            case 1:
                completeAddShortcut(args.intent, args.container, args.screenId, args.cellX, args.cellY);
                result = true;
                break;
            case 5:
                int appWidgetId = args.intent.getIntExtra("appWidgetId", -1);
                completeAddAppWidget(appWidgetId, args.container, args.screenId, null, null);
                result = true;
                break;
            case 6:
                completeAddApplication(args.intent, args.container, args.screenId, args.cellX, args.cellY);
                break;
            case 7:
                processShortcut(args.intent);
                break;
        }
        resetAddInfo();
        return result;
    }

    public byte[] getbyte(String str) {
        byte[] b_return = new byte[32];
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            b_return[i] = (byte) a;
        }
        return b_return;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.mWaitingForResult = false;
        if (requestCode == 11) {
            int appWidgetId = data != null ? data.getIntExtra("appWidgetId", -1) : -1;
            if (resultCode == 0) {
                completeTwoStageWidgetDrop(0, appWidgetId);
                return;
            } else {
                if (resultCode == -1) {
                    addAppWidgetImpl(appWidgetId, this.mPendingAddInfo, null, this.mPendingAddWidgetInfo);
                    return;
                }
                return;
            }
        }
        if (requestCode == 10) {
            if (resultCode == 202 && mWorkspace.isInOverviewMode()) {
                showHotseat(true);
                updateWallpaperVisibility(true);
                mWorkspace.exitOverviewMode(false);
            }
            if (resultCode == 202 && data != null) {
                this.mCurrWallpaperRes = data.getStringExtra("wallpaperRes");
                Log.d("LZP", "resultCode == WALLPAPER_RRESULT_CODE");
                SharedPreferences.Editor editor = this.mSharedPrefs.edit();
                editor.putString(SP_WALLPAPER, this.mCurrWallpaperRes);
                editor.commit();
                return;
            }
            return;
        }
        boolean delayExitSpringLoadedMode = false;
        boolean isWidgetDrop = requestCode == 9 || requestCode == 5;
        if (isWidgetDrop) {
            int appWidgetId2 = data != null ? data.getIntExtra("appWidgetId", -1) : -1;
            if (appWidgetId2 < 0) {
                Log.e(TAG, "Error: appWidgetId (EXTRA_APPWIDGET_ID) was not returned from the \\widget configuration activity.");
                completeTwoStageWidgetDrop(0, appWidgetId2);
                mWorkspace.stripEmptyScreens();
                return;
            }
            completeTwoStageWidgetDrop(resultCode, appWidgetId2);
            return;
        }
        if (resultCode == -1 && this.mPendingAddInfo.container != -1) {
            PendingAddArguments args = new PendingAddArguments(null);
            args.requestCode = requestCode;
            args.intent = data;
            args.container = this.mPendingAddInfo.container;
            args.screenId = this.mPendingAddInfo.screenId;
            args.cellX = this.mPendingAddInfo.cellX;
            args.cellY = this.mPendingAddInfo.cellY;
            if (isWorkspaceLocked()) {
                sPendingAddList.add(args);
            } else {
                delayExitSpringLoadedMode = completeAdd(args);
            }
        } else if (resultCode == 0) {
            mWorkspace.stripEmptyScreens();
        }
        this.mDragLayer.clearAnimatedView();
        exitSpringLoadedDragModeDelayed(resultCode != 0, delayExitSpringLoadedMode, null);
    }

    private void completeTwoStageWidgetDrop(final int resultCode, final int appWidgetId) {
        CellLayout cellLayout = mWorkspace.getScreenWithId(this.mPendingAddInfo.screenId);
        Runnable onCompleteRunnable = null;
        int animationType = 0;
        AppWidgetHostView boundWidget = null;
        if (resultCode == -1) {
            animationType = 3;
            final AppWidgetHostView layout = this.mAppWidgetHost.createView(this, appWidgetId, this.mPendingAddWidgetInfo);
            boundWidget = layout;
            onCompleteRunnable = new Runnable() { // from class: com.android.launcher66.Launcher.22
                @Override // java.lang.Runnable
                public void run() {
                    Launcher.this.completeAddAppWidget(appWidgetId, Launcher.this.mPendingAddInfo.container, Launcher.this.mPendingAddInfo.screenId, layout, null);
                    Launcher.this.exitSpringLoadedDragModeDelayed(resultCode != 0, false, null);
                }
            };
        } else if (resultCode == 0) {
            animationType = 4;
            onCompleteRunnable = new Runnable() { // from class: com.android.launcher66.Launcher.23
                @Override // java.lang.Runnable
                public void run() {
                    Launcher.this.exitSpringLoadedDragModeDelayed(resultCode != 0, false, null);
                }
            };
        }
        if (this.mDragLayer.getAnimatedView() != null) {
            mWorkspace.animateWidgetDrop(this.mPendingAddInfo, cellLayout, (DragView) this.mDragLayer.getAnimatedView(), onCompleteRunnable, animationType, boundWidget, true);
        } else {
            onCompleteRunnable.run();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        Log.d("LZP", "---->>> onStop");
        WindowUtil.removePip(this.pipViews);
        super.onStop();
        this.isfirstlayout = true;
        FirstFrameAnimatorHelper.setIsVisible(false);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        WindowUtil.initDefaultApp();
        FirstFrameAnimatorHelper.setIsVisible(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.preOnResumeTime = System.currentTimeMillis();
        LogPreview.show("onResume----->");
        if (isAllAppsVisible()) {
            WindowUtil.removePip(null);
        } else {
            if (!Helpers.firstPreferenceWindow) {
                Log.d("LZP", "startMapPip");
                WindowUtil.startMapPip(null, false, 250);
            }
            Helpers.firstPreferenceWindow = false;
        }
        handleView();
        if (Config.CHIP_UIID == 6 && !LauncherApplication.isHaveDvd) {
        }
        if (this.mOnResumeState == State.WORKSPACE) {
            LogPreview.show("mOnResumeState == State.WORKSPACE");
            showWorkspace(true);
        } else if (this.mOnResumeState == State.APPS_CUSTOMIZE) {
            showAllApps(true, AppsCustomizePagedView.ContentType.Applications, false);
        }
        this.mOnResumeState = State.NONE;
        setWorkspaceBackground(this.mState == State.WORKSPACE);
        this.mPaused = false;
        sPausedFromUserAction = false;
        if (this.mRestoring || this.mOnResumeNeedsLoad) {
            this.mWorkspaceLoading = true;
            mModel.startLoader(true, -1);
            this.mRestoring = false;
            this.mOnResumeNeedsLoad = false;
        }
        if (this.mBindOnResumeCallbacks.size() > 0) {
            if (this.mAppsCustomizeContent != null) {
                this.mAppsCustomizeContent.setBulkBind(true);
            }
            for (int i = 0; i < this.mBindOnResumeCallbacks.size(); i++) {
                this.mBindOnResumeCallbacks.get(i).run();
            }
            if (this.mAppsCustomizeContent != null) {
                this.mAppsCustomizeContent.setBulkBind(false);
            }
            this.mBindOnResumeCallbacks.clear();
        }
        if (this.mOnResumeCallbacks.size() > 0) {
            for (int i2 = 0; i2 < this.mOnResumeCallbacks.size(); i2++) {
                this.mOnResumeCallbacks.get(i2).run();
            }
            this.mOnResumeCallbacks.clear();
        }
        if (this.mWaitingForResume != null) {
            this.mWaitingForResume.setStayPressed(false);
        }
        if (this.mAppsCustomizeContent != null) {
            this.mAppsCustomizeContent.resetDrawableState();
        }
        getWorkspace().reinflateWidgetsIfNecessary();
        InstallShortcutReceiver.disableAndFlushInstallQueue(this);
        updateVoiceButtonProxyVisible(false);
        updateGlobalIcons();
        if (mWorkspace.getCustomContentCallbacks() != null && mWorkspace.isOnOrMovingToCustomContent()) {
            mWorkspace.getCustomContentCallbacks().onShow();
        }
        mWorkspace.updateInteractionForState();
        mWorkspace.onResume();
        LauncherNotify.NOTIFIER_MUSIC.addUiRefresher(this.refreshMusic, true);
        LauncherNotify.NOTIFIER_VIDEO.addUiRefresher(this.refreshVideo, true);
        LauncherNotify.NOTIFIER_BTAV.addUiRefresher(this.refreshBtav, true);
        LauncherNotify.NOTIFIER_DVR.addUiRefresher(this.refreshDvr, true);
        LauncherNotify.NOTIFIER_NAVIVIEW.addUiRefresher(this.refreshNaviView, false);
        LauncherNotify.NOTIFIER_NAVISTATE.addUiRefresher(this.refreshNaviState, false);
        this.tools = CarStates.getCar(this.app).getTools();
        this.tools.addRefreshLisenter(1, this.refreshRadioBand, 0);
        this.tools.addRefreshLisenter(1, this.refreshRadioFreq, 1, 2);
        this.tools.addRefreshLisenter(0, this.refreshMain, 0, 50, 60, 101, 31, 4);
        this.tools.addRefreshLisenter(4, this.refreshMain, 2, 3);
        this.tools.addRefreshLisenter(7, this.refreshMain, 1000);
        this.tools.addRefreshLisenter(2, this.refreshBtInfo, 0, 1, 2, 28, 26, 13, 9, 7);
        this.tools.notify(0, 0, 50, 60, 101, 31);
        this.tools.notify(1, 0);
        this.tools.notify(1, 1);
        this.tools.notify(7, 1000);
        this.tools.notify(2, 0, 1, 2, 28, 26, 13, 9, 7);
        if (this.firstLayout != null && !this.isfirstlayout) {
            this.firstLayout.setVisibility(View.VISIBLE);
        }
        this.isfirstlayout = false;
        showWeatherInfo();
        this.lastpath = null;
        if (CarStates.mAppID != 8 && mediaSource == "fyt") {
            /*Utils.setTextId(this.tvMusicName, R.string.music_name);
            Utils.setTextId(this.tvAritst, R.string.music_author);
            Utils.setTextId(this.tvMusicNameTwo, R.string.music_name);*/
            Utils.setTextId(this.tvAlbum, R.string.music_author);
            //Utils.setTextStr(this.tvCurTime, "00:00");
            //Utils.setTextStr(this.tvTotalTime, "00:00");
            if (this.musicProgress != null) {
                this.musicProgress.setProgress(0);
            }
            if (this.music_playpause != null) {
                this.music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }
        }
        if (this.showKuwoContent && !AppUtil.isInTheTaskbar(getApplicationContext(), FytPackage.KWACTION)) {
            this.showKuwoContent = false;
            if (this.kuwomusic_playpause != null) {
                this.kuwomusic_playpause.setBackgroundResource(ResValue.getInstance().music_pause_icon);
            }
            if (this.mKwMusicName != null) {
                this.mKwMusicName.setText(R.string.car_kuwo);
            }
            if (this.mKwArtist != null) {
                this.mKwArtist.setText(R.string.music_author);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSoundBtn() {
        if (this.customView.get(Config.SOUND) != null) {
            this.customView.get(Config.SOUND).setBackgroundResource(R.drawable.car_sound_icon);
        }
        if (this.customView.get(Config.CLOLSESOUND) != null) {
            this.customView.get(Config.CLOLSESOUND).setBackgroundResource(R.drawable.car_sound_icon);
        }
        if (this.customView.get(Config.WS_SOUND) != null) {
            this.customView.get(Config.WS_SOUND).setBackgroundResource(R.drawable.car_sound_icon);
        }
        if (this.customView.get(Config.WS_CLOSESOUND) != null) {
            this.customView.get(Config.WS_CLOSESOUND).setBackgroundResource(R.drawable.car_sound_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSoundCloseBtn() {
        if (this.customView.get(Config.SOUND) != null) {
            this.customView.get(Config.SOUND).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
        if (this.customView.get(Config.CLOLSESOUND) != null) {
            this.customView.get(Config.CLOLSESOUND).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
        if (this.customView.get(Config.WS_SOUND) != null) {
            this.customView.get(Config.WS_SOUND).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
        if (this.customView.get(Config.WS_CLOSESOUND) != null) {
            this.customView.get(Config.WS_CLOSESOUND).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        Log.d("LZP", "---->>> onPause");
        if (AppUtil.topApp(this, FytPackage.hicarAction)) {
            WindowUtil.removePip(this.pipViews);
        }
        InstallShortcutReceiver.enableInstallQueue();
        super.onPause();
        this.mPaused = true;
        this.mDragController.cancelDrag();
        this.mDragController.resetLastGestureUpTime();
        LauncherNotify.NOTIFIER_MUSIC.removeUiRefresher(this.refreshMusic);
        LauncherNotify.NOTIFIER_VIDEO.removeUiRefresher(this.refreshVideo);
        LauncherNotify.NOTIFIER_BTAV.removeUiRefresher(this.refreshBtav);
        LauncherNotify.NOTIFIER_DVR.removeUiRefresher(this.refreshDvr);
        LauncherNotify.NOTIFIER_NAVIVIEW.removeUiRefresher(this.refreshNaviView);
        LauncherNotify.NOTIFIER_NAVISTATE.removeUiRefresher(this.refreshNaviState);
        clearGaoDeData();
        if (mWorkspace.getCustomContentCallbacks() != null) {
            mWorkspace.getCustomContentCallbacks().onHide();
        }
    }

    protected void onFinishBindingItems() {
        if (mWorkspace != null && hasCustomContentToLeft() && mWorkspace.hasCustomContent()) {
            addCustomContentToLeft();
        }
    }

    public void resetQSBScroll() {
        this.mSearchDropTargetBar.animate().translationY(0.0f).start();
        getQsbBar().animate().translationY(0.0f).start();
    }

    protected void startSettings() {
    }

    public QSBScroller addToCustomContentPage(View customContent, CustomContentCallbacks callbacks, String description) {
        mWorkspace.addToCustomContentPage(customContent, callbacks, description);
        return this.mQsbScroller;
    }

    public int getTopOffsetForCustomContent() {
        return mWorkspace.getPaddingTop();
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        int delay = mModel.mFirstUse ? 300000 : 0;
        if (SystemClock.elapsedRealtime() > delay) {
            mModel.stopLoader();
        }
        if (this.mAppsCustomizeContent != null) {
            this.mAppsCustomizeContent.surrender();
        }
        return Boolean.TRUE;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        this.mHasFocus = hasFocus;
    }

    private boolean acceptFilter() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        return !inputManager.isFullscreenMode();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int uniChar = event.getUnicodeChar();
        boolean handled = super.onKeyDown(keyCode, event);
        boolean isKeyNotWhitespace = uniChar > 0 && !Character.isWhitespace(uniChar);
        if (!handled && acceptFilter() && isKeyNotWhitespace) {
            boolean gotKey = TextKeyListener.getInstance().onKeyDown(mWorkspace, this.mDefaultKeySsb, keyCode, event);
            if (gotKey && this.mDefaultKeySsb != null && this.mDefaultKeySsb.length() > 0) {
                return onSearchRequested();
            }
        }
        if (keyCode == 82 && event.isLongPress()) {
            return true;
        }
        return handled;
    }

    private String getTypedText() {
        return this.mDefaultKeySsb.toString();
    }

    private void clearTypedText() {
        this.mDefaultKeySsb.clear();
        this.mDefaultKeySsb.clearSpans();
        Selection.setSelection(this.mDefaultKeySsb, 0);
    }

    private static State intToState(int stateOrdinal) {
        State state = State.WORKSPACE;
        State[] stateValues = State.valuesCustom();
        for (int i = 0; i < stateValues.length; i++) {
            if (stateValues[i].ordinal() == stateOrdinal) {
                State state2 = stateValues[i];
                return state2;
            }
        }
        return state;
    }

    private void restoreState(Bundle savedState) {
        if (savedState != null) {
            State state = intToState(savedState.getInt(RUNTIME_STATE, State.WORKSPACE.ordinal()));
            if (state == State.APPS_CUSTOMIZE) {
                this.mOnResumeState = State.APPS_CUSTOMIZE;
            }
            int currentScreen = savedState.getInt(RUNTIME_STATE_CURRENT_SCREEN, PagedView.INVALID_RESTORE_PAGE);
            if (currentScreen != -1001) {
                mWorkspace.setRestorePage(currentScreen);
            }
            long pendingAddContainer = savedState.getLong(RUNTIME_STATE_PENDING_ADD_CONTAINER, -1L);
            long pendingAddScreen = savedState.getLong(RUNTIME_STATE_PENDING_ADD_SCREEN, -1L);
            if (pendingAddContainer != -1 && pendingAddScreen > -1) {
                this.mPendingAddInfo.container = pendingAddContainer;
                this.mPendingAddInfo.screenId = pendingAddScreen;
                this.mPendingAddInfo.cellX = savedState.getInt(RUNTIME_STATE_PENDING_ADD_CELL_X);
                this.mPendingAddInfo.cellY = savedState.getInt(RUNTIME_STATE_PENDING_ADD_CELL_Y);
                this.mPendingAddInfo.spanX = savedState.getInt(RUNTIME_STATE_PENDING_ADD_SPAN_X);
                this.mPendingAddInfo.spanY = savedState.getInt(RUNTIME_STATE_PENDING_ADD_SPAN_Y);
                this.mPendingAddWidgetInfo = (AppWidgetProviderInfo) savedState.getParcelable(RUNTIME_STATE_PENDING_ADD_WIDGET_INFO);
                this.mWaitingForResult = true;
                this.mRestoring = true;
            }
            boolean renameFolder = savedState.getBoolean(RUNTIME_STATE_PENDING_FOLDER_RENAME, false);
            if (renameFolder) {
                long id = savedState.getLong(RUNTIME_STATE_PENDING_FOLDER_RENAME_ID);
                this.mFolderInfo = mModel.getFolderById(this, sFolders, id);
                this.mRestoring = true;
            }
            if (this.mAppsCustomizeTabHost != null) {
                String curTab = savedState.getString("apps_customize_currentTab");
                if (curTab != null) {
                    this.mAppsCustomizeTabHost.setContentTypeImmediate(this.mAppsCustomizeTabHost.getContentTypeForTabTag(curTab));
                    this.mAppsCustomizeContent.loadAssociatedPages(this.mAppsCustomizeContent.getCurrentPage());
                }
                int currentIndex = savedState.getInt("apps_customize_currentIndex");
                this.mAppsCustomizeContent.restorePageForIndex(currentIndex);
            }
        }
    }

    private void initHashMap() {
        if (this.mHotseat != null) {
            this.customView.put(Config.NAVI, this.mHotseat.findViewById(ResValue.getInstance().m_navi_btn));
            this.customView.put(Config.VOICE, this.mHotseat.findViewById(ResValue.getInstance().m_voice_btn));
            this.customView.put(Config.SETTING, this.mHotseat.findViewById(ResValue.getInstance().m_set_btn));
            this.customView.put(Config.VIDEO, this.mHotseat.findViewById(ResValue.getInstance().m_video_btn));
            this.customView.put(Config.BT, this.mHotseat.findViewById(ResValue.getInstance().m_bt_btn));
            this.customView.put(Config.RADIO, this.mHotseat.findViewById(ResValue.getInstance().m_radio_btn));
            this.customView.put(Config.MUSIC, this.mHotseat.findViewById(ResValue.getInstance().m_music_btn));
            this.customView.put(Config.BTAV, this.mHotseat.findViewById(ResValue.getInstance().m_btav_btn));
            this.customView.put(Config.ECAR, this.mHotseat.findViewById(ResValue.getInstance().m_ecar_btn));
            this.customView.put(Config.SOS, this.mHotseat.findViewById(ResValue.getInstance().m_sos_btn));
            this.customView.put(Config.KUWO, this.mHotseat.findViewById(ResValue.getInstance().m_kuwo_btn));
            this.customView.put(Config.UNICAR, this.mHotseat.findViewById(ResValue.getInstance().m_unicar_btn));
            this.customView.put(Config.KLFM, this.mHotseat.findViewById(ResValue.getInstance().m_klfm_btn));
            this.customView.put(Config.HONGFANS, this.mHotseat.findViewById(ResValue.getInstance().m_hongfans_btn));
            this.customView.put(Config.DVR, this.mHotseat.findViewById(ResValue.getInstance().m_dvr_btn));
            this.customView.put(Config.LIGHT, this.mHotseat.findViewById(ResValue.getInstance().m_light_btn));
            this.customView.put(Config.CLOLSESCREEN, this.mHotseat.findViewById(ResValue.getInstance().m_screen_btn));
            this.customView.put(Config.WIFI, this.mHotseat.findViewById(ResValue.getInstance().m_wifi_btn));
            this.customView.put(Config.SOUND, this.mHotseat.findViewById(ResValue.getInstance().m_sound_btn));
            this.customView.put(Config.CLOLSESOUND, this.mHotseat.findViewById(ResValue.getInstance().m_closesound_btn));
            this.customView.put(Config.BRIGHT, this.mHotseat.findViewById(ResValue.getInstance().m_bright_btn));
            this.customView.put(Config.EQ, this.mHotseat.findViewById(ResValue.getInstance().m_eq_btn));
            this.customView.put(Config.TIME, this.mHotseat.findViewById(ResValue.getInstance().m_time_btn));
            this.customView.put(Config.ALLAPP, this.mHotseat.findViewById(ResValue.getInstance().m_allapp_btn));
            this.customView.put(Config.BROWSER, this.mHotseat.findViewById(ResValue.getInstance().m_browser_btn));
            this.customView.put(Config.NEWEYE, this.mHotseat.findViewById(ResValue.getInstance().m_neweye_btn));
            this.customView.put(Config.CANBUS, this.mHotseat.findViewById(ResValue.getInstance().m_canbus_btn));
            this.customView.put(Config.FILE, this.mHotseat.findViewById(ResValue.getInstance().m_file_btn));
            this.mHotseatApps = (TextView) this.mHotseat.findViewById(ResValue.getInstance().hotseat_apps);
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.weather_show)) {
                this.weatherImg = (ImageView) this.mHotseat.findViewById(ResValue.getInstance().weather_imge);
                this.weatherCity = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_city);
                this.weatherWeather = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_weather);
                this.weatherTemp = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_temp);
                this.weatherTempRange = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_temp_range);
                this.weatherImg1 = (ImageView) this.mHotseat.findViewById(ResValue.getInstance().weather_imge1);
                this.weatherCity1 = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_city1);
                this.weatherWeather1 = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_weather1);
                this.weatherTemp1 = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_temp1);
                this.weatherTempRange1 = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_temp_range1);
                this.weatherWind = (TextView) this.mHotseat.findViewById(ResValue.getInstance().weather_wind);
            }
            if (this.customView.get(Config.NAVI) != null) {
                this.customView.get(Config.NAVI).setOnClickListener(this);
            }
            if (this.customView.get(Config.VOICE) != null) {
                this.customView.get(Config.VOICE).setOnClickListener(this);
            }
            if (this.customView.get(Config.SETTING) != null) {
                this.customView.get(Config.SETTING).setOnClickListener(this);
            }
            if (this.customView.get(Config.VIDEO) != null) {
                this.customView.get(Config.VIDEO).setOnClickListener(this);
            }
            if (this.customView.get(Config.BRIGHT) != null) {
                this.customView.get(Config.BRIGHT).setOnClickListener(this);
            }
            if (this.customView.get(Config.BT) != null) {
                this.customView.get(Config.BT).setOnClickListener(this);
            }
            if (this.customView.get(Config.RADIO) != null) {
                this.customView.get(Config.RADIO).setOnClickListener(this);
            }
            if (this.customView.get(Config.MUSIC) != null) {
                this.customView.get(Config.MUSIC).setOnClickListener(this);
            }
            if (this.customView.get(Config.BTAV) != null) {
                this.customView.get(Config.BTAV).setOnClickListener(this);
            }
            if (this.customView.get(Config.ECAR) != null) {
                this.customView.get(Config.ECAR).setOnClickListener(this);
            }
            if (this.customView.get(Config.SOS) != null) {
                this.customView.get(Config.SOS).setOnClickListener(this);
            }
            if (this.customView.get(Config.KUWO) != null) {
                this.customView.get(Config.KUWO).setOnClickListener(this);
            }
            if (this.customView.get(Config.UNICAR) != null) {
                this.customView.get(Config.UNICAR).setOnClickListener(this);
            }
            if (this.customView.get(Config.KLFM) != null) {
                this.customView.get(Config.KLFM).setOnClickListener(this);
            }
            if (this.customView.get(Config.HONGFANS) != null) {
                this.customView.get(Config.HONGFANS).setOnClickListener(this);
            }
            if (this.customView.get(Config.DVR) != null) {
                this.customView.get(Config.DVR).setOnClickListener(this);
            }
            if (this.customView.get(Config.LIGHT) != null) {
                this.customView.get(Config.LIGHT).setOnClickListener(this);
            }
            if (this.customView.get(Config.CLOLSESCREEN) != null) {
                this.customView.get(Config.CLOLSESCREEN).setOnClickListener(this);
            }
            if (this.customView.get(Config.WIFI) != null) {
                this.customView.get(Config.WIFI).setOnClickListener(this);
            }
            if (this.customView.get(Config.SOUND) != null) {
                this.customView.get(Config.SOUND).setOnClickListener(this);
            }
            if (this.customView.get(Config.CLOLSESOUND) != null) {
                this.customView.get(Config.CLOLSESOUND).setOnClickListener(this);
            }
            if (this.customView.get(Config.EQ) != null) {
                this.customView.get(Config.EQ).setOnClickListener(this);
            }
            if (this.customView.get(Config.TIME) != null) {
                this.customView.get(Config.TIME).setOnClickListener(this);
            }
            if (this.customView.get(Config.ALLAPP) != null) {
                this.customView.get(Config.ALLAPP).setOnClickListener(this);
            }
            if (this.customView.get(Config.BROWSER) != null) {
                this.customView.get(Config.BROWSER).setOnClickListener(this);
            }
            if (this.customView.get(Config.CANBUS) != null) {
                this.customView.get(Config.CANBUS).setOnClickListener(this);
            }
            if (this.customView.get(Config.FILE) != null) {
                this.customView.get(Config.FILE).setOnClickListener(this);
            }
            if (this.customView.get(Config.NEWEYE) != null) {
                this.customView.get(Config.NEWEYE).setOnClickListener(this);
            }
        }
    }

    private void setupViews() {
        DragController dragController = this.mDragController;
        this.mLauncherView = findViewById(R.id.launcher);
        this.mDragLayer = (DragLayer) findViewById(R.id.drag_layer);
        mWorkspace = (Workspace) this.mDragLayer.findViewById(R.id.workspace);
        this.mLauncherView.setSystemUiVisibility(1536);
        this.mDragLayer.setup(this, dragController);
        this.mHotseat = findViewById(R.id.hotseat);
        this.mOverviewPanel = findViewById(R.id.overview_panel);
        wallpaperButton = findViewById(ResValue.getInstance().wallpaper_button);
        if (this.mHotseat != null) {
            this.mAllAppsButton = this.mHotseat.findViewById(ResValue.getInstance().syu_app_button);
        }
        initHashMap();
        if (this.mAllAppsButton != null) {
            this.mAllAppsButton.setOnTouchListener(getHapticFeedbackTouchListener());
            this.mAllAppsButton.setOnClickListener(this);
        }
        if (wallpaperButton != null) {
            wallpaperButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.25
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    onClickWallpaperPicker(arg0);
                }
            });
            wallpaperButton.setOnTouchListener(getHapticFeedbackTouchListener());
        }
        settingsButton = findViewById(ResValue.getInstance().settings_button);
        if (settingsButton != null) {
            settingsButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.27
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    onClickSettingsButton(arg0); //Launcher.this.startSettings();
                }
            });
            settingsButton.setOnTouchListener(getHapticFeedbackTouchListener());
        }
        this.mOverviewPanel.setAlpha(0.0f);
        mWorkspace.setHapticFeedbackEnabled(false);
        mWorkspace.setOnLongClickListener(this);
        mWorkspace.setup(dragController);
        dragController.addDragListener(mWorkspace);
        this.mSearchDropTargetBar = (SearchDropTargetBar) this.mDragLayer.findViewById(R.id.qqsb_bar);
        this.mAppsCustomizeTabHost = (AppsCustomizeTabHost) findViewById(R.id.apps_customize_pane);
        this.mAppsCustomizeContent = (AppsCustomizePagedView) this.mAppsCustomizeTabHost.findViewById(R.id.apps_customize_pane_content);
        this.mAppsCustomizeContent.setup(this, dragController);
        dragController.setDragScoller(mWorkspace);
        dragController.setScrollView(this.mDragLayer);
        dragController.setMoveTarget(mWorkspace);
        dragController.addDropTarget(mWorkspace);
        if (this.mSearchDropTargetBar != null) {
            this.mSearchDropTargetBar.setup(this, dragController);
        }
        if (getResources().getBoolean(R.bool.debug_memory_enabled)) {
            Log.v(TAG, "adding WeightWatcher");
            this.mWeightWatcher = new WeightWatcher(this);
            this.mWeightWatcher.setAlpha(0.5f);
            ((FrameLayout) this.mLauncherView).addView(this.mWeightWatcher, new FrameLayout.LayoutParams(-1, -2, 80));
            boolean show = shouldShowWeightWatcher();
            this.mWeightWatcher.setVisibility(show ? android.view.View.VISIBLE : android.view.View.GONE);
        }
        this.firstLayout = (RelativeLayout) findViewById(ResValue.getInstance().first_layout);
        ImageView firstClickApp = (ImageView) findViewById(ResValue.getInstance().first_app);
        if (firstClickApp != null) {
            firstClickApp.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.28
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    if (Launcher.this.firstLayout != null) {
                        Launcher.this.firstLayout.setVisibility(android.view.View.GONE);
                    }
                }
            });
        }
        if (this.firstLayout != null) {
            this.firstLayout.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.29
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                }
            });
        }
    }

    public void onClickWallpaperPicker(View v) {
        int pageScroll = mWorkspace.getScrollForPage(mWorkspace.getPageNearestToCenterOfScreen());
        Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);

        String pickerPackage = "com.android.wallpaper";
        boolean hasTargetPackage = !TextUtils.isEmpty(pickerPackage);
        try {
            if (hasTargetPackage && getPackageManager().getApplicationInfo(pickerPackage, 0).enabled) {
                intent.setPackage(pickerPackage);
            }
        } catch (PackageManager.NameNotFoundException ex) {
        }

        intent.setSourceBounds(getViewBounds(v));
        try {
            startActivityForResult(intent, REQUEST_PICK_WALLPAPER);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "activity_not_found", Toast.LENGTH_SHORT).show();
        }
    }

    public Rect getViewBounds(View v) {
        int[] pos = new int[2];
        v.getLocationOnScreen(pos);
        return new Rect(pos[0], pos[1], pos[0] + v.getWidth(), pos[1] + v.getHeight());
    }

    public void onClickSettingsButton(View v) {
        if (LOGD) Log.d(TAG, "onClickSettingsButton");
        Intent intent = new Intent(Intent.ACTION_APPLICATION_PREFERENCES)
                .setPackage(getPackageName());
        intent.setSourceBounds(getViewBounds(v));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initViews() {
        if (mWorkspace != null) {
            this.mRadioPrevButton = mWorkspace.findViewById(ResValue.getInstance().Radiobutton_prev);
            this.mRadioPauseButton = mWorkspace.findViewById(ResValue.getInstance().Radiobutton_pause);
            this.mRadioNextButton = mWorkspace.findViewById(ResValue.getInstance().Radiobutton_next);
            this.mRadioBandButton = mWorkspace.findViewById(ResValue.getInstance().radio_btn_band);
            this.mMusicPrevButton = mWorkspace.findViewById(ResValue.getInstance().musicbutton_prev);
            this.mMusicPrevButtonTwo = mWorkspace.findViewById(ResValue.getInstance().musicbutton_prev_two);
            this.mMusicNextButton = mWorkspace.findViewById(ResValue.getInstance().musicbutton_next);
            this.mMusicNextButtonTwo = mWorkspace.findViewById(ResValue.getInstance().musicbutton_next_two);
            this.music_playpause = mWorkspace.findViewById(ResValue.getInstance().musicbutton_playpause);
            this.mRadioIcon = mWorkspace.findViewById(ResValue.getInstance().mRadioIcon);
            this.tvMusicName = mWorkspace.findViewById(ResValue.getInstance().tv_musicName);
            this.tvMusicNameTwo = mWorkspace.findViewById(ResValue.getInstance().tv_musicName_two);
            this.ivALbumBg = mWorkspace.findViewById(ResValue.getInstance().iv_album_bg);
            this.ivMusicScore = mWorkspace.findViewById(ResValue.getInstance().music_score);
            this.ivMusicScore2 = mWorkspace.findViewById(ResValue.getInstance().music_score2);
            this.tvAritst = mWorkspace.findViewById(ResValue.getInstance().tv_artist);
            this.tvAlbum = mWorkspace.findViewById(ResValue.getInstance().tv_album);
            this.tvCurTime = mWorkspace.findViewById(ResValue.getInstance().music_cur_time);
            this.tvTotalTime = mWorkspace.findViewById(ResValue.getInstance().music_total_time);
            this.musicSeekBar = mWorkspace.findViewById(ResValue.getInstance().music_seekbar);
            this.musicProgress = mWorkspace.findViewById(ResValue.getInstance().music_progress);
            this.mPlayer = new MediaPlayer();
            this.mTvNavi = mWorkspace.findViewById(ResValue.getInstance().tv_navi);
            this.mTvSettings = mWorkspace.findViewById(ResValue.getInstance().tv_settings);
            this.mTvCar = mWorkspace.findViewById(ResValue.getInstance().tv_car);
            this.mTvMusic = mWorkspace.findViewById(ResValue.getInstance().tv_music);
            this.mTvRadio = mWorkspace.findViewById(ResValue.getInstance().tv_radio);
            this.mMiuDrive = mWorkspace.findViewById(ResValue.getInstance().tv_miudrive);
            this.mTvAux = mWorkspace.findViewById(ResValue.getInstance().tv_aux);
            this.mTvApps = mWorkspace.findViewById(ResValue.getInstance().tv_apps);
            this.mTvBt = mWorkspace.findViewById(ResValue.getInstance().tv_bt);
            this.mTvBtPhoneName = mWorkspace.findViewById(ResValue.getInstance().tv_btphone_name);
            this.mTvCanbus = mWorkspace.findViewById(ResValue.getInstance().tv_canbus);
            this.mTvMovie = mWorkspace.findViewById(ResValue.getInstance().tv_video);
            this.mTvFile = mWorkspace.findViewById(ResValue.getInstance().tv_file);
            this.mTvGallery = mWorkspace.findViewById(ResValue.getInstance().tv_gallery);
            this.mTvDVR = mWorkspace.findViewById(ResValue.getInstance().tv_dvr);
            this.mTvPerson = mWorkspace.findViewById(ResValue.getInstance().tv_person);
            this.mTvGuide = mWorkspace.findViewById(ResValue.getInstance().tv_guide);
            this.mTvCalculator = mWorkspace.findViewById(ResValue.getInstance().tv_calculator);
            this.mTvEq = mWorkspace.findViewById(ResValue.getInstance().tv_eq);
            this.mTurntableView = mWorkspace.findViewById(ResValue.getInstance().turntableview);
            this.mTvSpeed = mWorkspace.findViewById(ResValue.getInstance().tv_speed);
            this.customView.put(Config.WS_Music, mWorkspace.findViewById(ResValue.getInstance().rl_music));
            this.customView.put(Config.WS_Radio, mWorkspace.findViewById(ResValue.getInstance().rl_radio));
            this.customView.put(Config.WS_Video, mWorkspace.findViewById(ResValue.getInstance().rl_video));
            this.customView.put(Config.WS_Bt, mWorkspace.findViewById(ResValue.getInstance().rl_bt));
            this.customView.put(Config.WS_Navi, mWorkspace.findViewById(ResValue.getInstance().rl_navi));
            this.customView.put(Config.WS_Settings, mWorkspace.findViewById(ResValue.getInstance().rl_settings));
            this.customView.put(Config.WS_Time, mWorkspace.findViewById(ResValue.getInstance().ll_time));
            this.customView.put(Config.WS_Allapps, mWorkspace.findViewById(ResValue.getInstance().rl_allapps));
            this.tvBand = mWorkspace.findViewById(ResValue.getInstance().tv_band);
            this.tvUnit = mWorkspace.findViewById(ResValue.getInstance().tv_unit);
            this.img_freq_point = mWorkspace.findViewById(ResValue.getInstance().radio_point);
            this.tvCurFreq = mWorkspace.findViewById(ResValue.getInstance().tv_freq);
        }
        if (this.tvMusicName != null) {
            if (MusicService.music_path != null && !MusicService.music_path.equals("") && MusicService.music_path.lastIndexOf("/") >= 0) {
                File file = new File(MusicService.music_path);
                String filename = file.getName();
                String musictitle = filename.substring(0, filename.lastIndexOf("."));
                //String musictitle = MusicService.music_path.substring(MusicService.music_path.lastIndexOf("/") + 1);
                this.tvMusicName.setText(musictitle);
            } else {
                this.tvMusicName.setText(R.string.music_name);
            }
        }
        if (this.tvMusicNameTwo != null) {
            if (MusicService.music_path != null && !MusicService.music_path.equals("") && MusicService.music_path.lastIndexOf("/") >= 0) {
                File file = new File(MusicService.music_path);
                String filename = file.getName();
                String musictitle2 = filename.substring(0, filename.lastIndexOf("."));
                //String musictitle2 = MusicService.music_path.substring(MusicService.music_path.lastIndexOf("/") + 1);
                this.tvMusicNameTwo.setText(musictitle2);
            } else {
                this.tvMusicNameTwo.setText(R.string.music_name);
            }
        }
        if (this.tvCurTime != null) {
            this.tvCurTime.setText("00:00");
        }
        if (this.tvTotalTime != null) {
            this.tvTotalTime.setText("00:00");
        }
        if (this.musicSeekBar != null) {
            this.musicSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListenerImp(this, null));
        }
        /*if (this.music_playpause != null) {
            if (MusicService.state.booleanValue()) {
                this.music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
            } else {
                this.music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }
        }*/
        if (this.tvAritst != null) {
            this.tvAritst.setText(R.string.music_author);
        }
        if (this.tvAlbum != null) {
            this.tvAlbum.setText(R.string.music_album);
        }
        if (this.mBtavView != null) {
            this.mBtavView.setOnClickListener(this);
        }
        if (this.mBtavName != null) {
            this.mBtavName.setText(R.string.car_bt_music);
        }
        if (this.mBtavAritst != null) {
            this.mBtavAritst.setText(R.string.music_unknown);
        }
        if (this.tvCurFreq != null) {
            this.tvCurFreq.setText("87.50");
        }
        if (this.tvUnit != null) {
            this.tvUnit.setText("MHz");
        }
        if (this.tvBand != null) {
            if (this.tvBand.getBackground() != null) {
                this.tvBand.setBackgroundResource(ResValue.getInstance().fm);
            } else {
                this.tvBand.setText("FM");
            }
        }
        if (this.customView.get(Config.WS_Radio) != null) {
            this.customView.get(Config.WS_Radio).setOnClickListener(this);
        }
        if (this.customView.get(Config.WS_Music) != null) {
            this.customView.get(Config.WS_Music).setOnClickListener(this);
        }
        if (this.customView.get(Config.WS_Bt) != null) {
            this.customView.get(Config.WS_Bt).setOnClickListener(this);
        }
        if (this.customView.get(Config.WS_Navi) != null) {
            this.customView.get(Config.WS_Navi).setOnClickListener(this);
        }
        if (this.customView.get(Config.WS_Settings) != null) {
            this.customView.get(Config.WS_Settings).setOnClickListener(this);
        }
        if (this.customView.get(Config.WS_Allapps) != null) {
            this.customView.get(Config.WS_Allapps).setOnClickListener(this);
        }
        if (this.customView.get(Config.WS_Time) != null) {
            this.customView.get(Config.WS_Time).setOnClickListener(this);
        }
        updateView();
    }

    public void initAppData() {
        this.mRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.recycler_view);
        this.mLeftRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.left_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(androidx.recyclerview.widget.RecyclerView.HORIZONTAL);
        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(this);
        leftLayoutManager.setOrientation(androidx.recyclerview.widget.RecyclerView.VERTICAL);
        this.mLeftAppListData = new ArrayList();
        List<LeftAppMultiple> leftAppData = LitePal.findAll(LeftAppMultiple.class, new long[0]);
        if (leftAppData != null && !leftAppData.isEmpty()) {
            for (int i = 0; i < leftAppData.size(); i++) {
                LeftAppMultiple multiple = leftAppData.get(i);
                Iterator<AppInfo> it = AllAppsList.data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AppInfo allApp = it.next();
                    if (allApp.getPackageName().equals(multiple.packageName) && allApp.getClassName().equals(multiple.className)) {
                        AppListBean ab = new AppListBean(allApp.title.toString(), allApp.iconBitmap, multiple.packageName, multiple.className);
                        this.mLeftAppListData.add(ab);
                        break;
                    }
                }
            }
        }
        this.mAppListData = new ArrayList();
        List<AppMultiple> appData = LitePal.findAll(AppMultiple.class, new long[0]);
        if (appData != null && !appData.isEmpty()) {
            for (int i2 = 0; i2 < appData.size(); i2++) {
                AppMultiple multiple2 = appData.get(i2);
                if (multiple2.packageName.equals(FytPackage.AppAction)) {
                    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_apps);
                    AppListBean ab2 = new AppListBean(Utils.getNameToStr("car_app"), bmp, multiple2.packageName, multiple2.className);
                    this.mAppListData.add(ab2);
                } else if (multiple2.packageName.equals(FytPackage.AddAction)) {
                    Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
                    AppListBean ab3 = new AppListBean(multiple2.name, bmp2, multiple2.packageName, multiple2.className);
                    this.mAppListData.add(ab3);
                } else {
                    Iterator<AppInfo> it2 = AllAppsList.data.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            AppInfo allApp2 = it2.next();
                            if (allApp2.getPackageName().equals(multiple2.packageName) && allApp2.getClassName().equals(multiple2.className)) {
                                AppListBean ab4 = new AppListBean(allApp2.title.toString(), allApp2.iconBitmap, multiple2.packageName, multiple2.className);
                                this.mAppListData.add(ab4);
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            String appName1 = Utils.getNameToStr("car_navi");
            String appName2 = Utils.getNameToStr("car_music");
            String appName3 = Utils.getNameToStr("car_video");
            String appName4 = Utils.getNameToStr("car_radio");
            String appName5 = Utils.getNameToStr("car_bt");
            String appName6 = Utils.getNameToStr("car_eq");
            String appName7 = Utils.getNameToStr("car_settings");
            String appName8 = Utils.getNameToStr("");
            Bitmap icon1 = BitmapFactory.decodeResource(getResources(), R.drawable.com_syu_navi);
            Bitmap icon2 = BitmapFactory.decodeResource(getResources(), R.drawable.com_syu_music);
            Bitmap icon3 = BitmapFactory.decodeResource(getResources(), R.drawable.com_syu_video);
            Bitmap icon4 = BitmapFactory.decodeResource(getResources(), R.drawable.com_syu_radio);
            Bitmap icon5 = BitmapFactory.decodeResource(getResources(), R.drawable.com_syu_bt);
            Bitmap icon6 = BitmapFactory.decodeResource(getResources(), R.drawable.com_syu_eq);
            Bitmap icon7 = BitmapFactory.decodeResource(getResources(), R.drawable.com_syu_settings);
            Bitmap icon8 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
            AppListBean ab1 = new AppListBean(appName1, icon1, FytPackage.naviAction, "com.syu.onekeynavi.MainActivity");
            AppListBean ab22 = new AppListBean(appName2, icon2, "com.syu.music", "com.syu.app.Activity_All");
            AppListBean ab32 = new AppListBean(appName3, icon3, "com.syu.video", "com.syu.video.main.VideoListActivity");
            AppListBean ab42 = new AppListBean(appName4, icon4, "com.syu.radio", "com.syu.radio.Launch");
            AppListBean ab5 = new AppListBean(appName5, icon5, "com.syu.bt", "com.syu.bt.BtAct");
            AppListBean ab6 = new AppListBean(appName6, icon6, FytPackage.eqACTION, "com.syu.eq.activity.MainActivity");
            AppListBean ab7 = new AppListBean(appName7, icon7, "com.syu.settings", "com.syu.settings.MainActivity");
            AppListBean ab8 = new AppListBean(appName8, icon8, FytPackage.AddAction, "");
            this.mAppListData.add(ab1);
            this.mAppListData.add(ab22);
            this.mAppListData.add(ab32);
            this.mAppListData.add(ab42);
            this.mAppListData.add(ab5);
            this.mAppListData.add(ab6);
            this.mAppListData.add(ab7);
            this.mAppListData.add(ab8);
            new AppMultiple(0, appName1, FytPackage.naviAction, "com.syu.onekeynavi.MainActivity").save();
            new AppMultiple(1, appName2, "com.syu.music", "com.syu.app.Activity_All").save();
            new AppMultiple(2, appName3, "com.syu.video", "com.syu.video.main.VideoListActivity").save();
            new AppMultiple(3, appName4, "com.syu.radio", "com.syu.radio.Launch").save();
            new AppMultiple(4, appName5, "com.syu.bt", "com.syu.bt.BtAct").save();
            new AppMultiple(5, appName6, FytPackage.eqACTION, "com.syu.eq.activity.MainActivity").save();
            new AppMultiple(6, appName7, "com.syu.settings", "com.syu.settings.MainActivity").save();
            new AppMultiple(7, appName8, FytPackage.AddAction, "").save();
        }
        this.mAppListAdapter = new AppListAdapter(this, this.mAppListData);
        this.mLeftAppListAdapter = new LeftAppListAdapter(this, this.mLeftAppListData);
        this.mRecyclerView.setLayoutManager(layoutManager);
        if (userLayout) {
            if (leftBar) {
                this.mLeftRecyclerView.setLayoutManager(leftLayoutManager);
                this.mLeftRecyclerView.setAdapter(this.mLeftAppListAdapter);
            }
        } else {
            this.mLeftRecyclerView.setLayoutManager(leftLayoutManager);
            this.mLeftRecyclerView.setAdapter(this.mLeftAppListAdapter);
        }
        if (this.mRecyclerView.getTag() == null) {
            this.mRecyclerView.setTag(1);
            this.mRecyclerView.addItemDecoration(new SimpleDividerDecoration());
        }
        this.mRecyclerView.setAdapter(this.mAppListAdapter);
    }

    public void refreshCycle(List<AppMultiple> data) {
        this.mAppListData.clear();
        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                AppMultiple multiple = data.get(i);
                if (multiple.packageName.equals(FytPackage.AppAction)) {
                    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_apps);
                    AppListBean ab = new AppListBean(Utils.getNameToStr("car_app"), bmp, multiple.packageName, multiple.className);
                    this.mAppListData.add(ab);
                } else if (multiple.packageName.equals(FytPackage.AddAction)) {
                    Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
                    AppListBean ab2 = new AppListBean(multiple.name, bmp2, multiple.packageName, multiple.className);
                    this.mAppListData.add(ab2);
                } else {
                    Iterator<AppInfo> it = AllAppsList.data.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            AppInfo allApp = it.next();
                            if (allApp.getPackageName().equals(multiple.packageName) && allApp.getClassName().equals(multiple.className)) {
                                AppListBean ab3 = new AppListBean(allApp.title.toString(), allApp.iconBitmap, multiple.packageName, multiple.className);
                                this.mAppListData.add(ab3);
                                break;
                            }
                        }
                    }
                }
            }
        }
        this.mAppListAdapter.notifyDataSetChanged(this.mAppListData);
    }

    public void refreshLeftCycle(AppListBean bean) {
        Log.d("LZP", "--------------->>>   refreshLeftCycle");
        LeftAppMultiple appMultiple = (LeftAppMultiple) LitePal.where("packageName = ?", bean.packageName).findFirst(LeftAppMultiple.class);
        if (appMultiple != null) {
            LeftAppMultiple firstData = (LeftAppMultiple) LitePal.findFirst(LeftAppMultiple.class);
            ContentValues v1 = new ContentValues();
            v1.put("name", appMultiple.name);
            v1.put("packageName", appMultiple.packageName);
            v1.put("className", appMultiple.className);
            LitePal.update(LeftAppMultiple.class, v1, firstData.id);
            ContentValues v2 = new ContentValues();
            v2.put("name", firstData.name);
            v2.put("packageName", firstData.packageName);
            v2.put("className", firstData.className);
            LitePal.update(LeftAppMultiple.class, v2, appMultiple.id);
        } else {
            List<LeftAppMultiple> leftData = LitePal.findAll(LeftAppMultiple.class, new long[0]);
            LeftAppMultiple am = new LeftAppMultiple(0, bean.name, bean.packageName, bean.className);
            leftData.add(0, am);
            int count2 = leftData.size() > 4 ? leftData.size() - 1 : leftData.size();
            if (leftData.size() <= 4) {
                am.save();
            }
            for (int i = 0; i < count2; i++) {
                LeftAppMultiple multiple = leftData.get(i);
                Log.d("LZP", "refreshLeftCycle id:" + multiple.id + ",packageName" + multiple.packageName + ",className" + multiple.className);
                ContentValues values = new ContentValues();
                values.put("name", multiple.name);
                values.put("packageName", multiple.packageName);
                values.put("className", multiple.className);
                LitePal.update(LeftAppMultiple.class, values, i + 1);
            }
        }
        this.mLeftAppListData.clear();
        List<LeftAppMultiple> leftAppData = LitePal.findAll(LeftAppMultiple.class, new long[0]);
        if (leftAppData != null && !leftAppData.isEmpty()) {
            for (int i2 = 0; i2 < leftAppData.size(); i2++) {
                LeftAppMultiple multiple2 = leftAppData.get(i2);
                Log.d("LZP", "refreshLeftCycle index111:" + multiple2.index + ",packageName" + multiple2.packageName + ",className" + multiple2.className);
                Iterator<AppInfo> it = AllAppsList.data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AppInfo allApp = it.next();
                    if (allApp.getPackageName().equals(multiple2.packageName) && allApp.getClassName().equals(multiple2.className)) {
                        AppListBean ab = new AppListBean(allApp.title.toString(), allApp.iconBitmap, multiple2.packageName, multiple2.className);
                        this.mLeftAppListData.add(ab);
                        break;
                    }
                }
            }
        }
        this.mLeftAppListAdapter.notifyDataSetChanged(this.mLeftAppListData);
    }

    private void initAnim() {
    }

    private class OnSeekBarChangeListenerImp implements SeekBar.OnSeekBarChangeListener {
        private OnSeekBarChangeListenerImp() {
        }

        /* synthetic */ OnSeekBarChangeListenerImp(Launcher launcher, OnSeekBarChangeListenerImp onSeekBarChangeListenerImp) {
            this();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                Launcher.this.mPlayer.seekTo(progress);
                Launcher.this.musicSeekBar.setProgress(progress);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needStartKuwo() {
        if (!AppUtil.isInTheTaskbar(getApplicationContext(), FytPackage.KWACTION)) {
            startActivitySafely(this.customView.get(Config.WS_Kuwo), FytPackage.getIntent(this, FytPackage.KWACTION), "music");
        }
        switchSoundChannelThirdPlayer();
    }

    private void switchSoundChannelThirdPlayer() {
        int currentChanne = CarStates.getCar(getApplicationContext()).getTools().getInt(0, 0, 0, 0);
        if (currentChanne != 10) {
            CarStates.getCar(getApplicationContext()).getTools().sendInt(0, 0, 10);
        }
    }

    private void bindOnclickListener() {
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (this.mRadioPrevButton != null) {
            this.mRadioPrevButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.30
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (CarStates.mAppID == 1 && Launcher.this.tools != null) {
                        Launcher.this.tools.sendInt(1, 1, 0);
                    }
                }
            });
        }
        if (this.mRadioBandButton != null) {
            this.mRadioBandButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.31
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (CarStates.mAppID == 1 && Launcher.this.tools != null) {
                        Log.d("LZP", "---------------------->>> mRadioBandButton");
                        Launcher.this.tools.sendInt(1, 11, -1);
                    }
                }
            });
        }
        if (this.mRadioPauseButton != null) {
            this.mRadioPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.32
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Launcher.this.tools != null) {
                        if (CarStates.mAppID == 1) {
                            Launcher.this.tools.sendInt(0, 0, 0);
                            Launcher.this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_pause_icon);
                        } else {
                            Launcher.this.tools.sendInt(0, 0, 1);
                            Launcher.this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_playpause_icon);
                        }
                    }
                }
            });
        }
        if (this.mRadioNextButton != null) {
            this.mRadioNextButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.33
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (CarStates.mAppID == 1 && Launcher.this.tools != null) {
                        Launcher.this.tools.sendInt(1, 0, 0);
                    }
                }
            });
        }
        if (this.mMusicPrevButton != null) {
            this.mMusicPrevButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.34
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (mediaSource == "fyt") {
                        Log.i("prev", "pressed");
                        Intent intent = new Intent();
                        intent.setAction("com.syu.music.prev");
                        intent.setPackage("com.syu.music");
                        Launcher.this.startService(intent);
                    } else if (mediaSource == "mediaController" && !MusicService.state) {
                        event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS);
                        am.dispatchMediaKeyEvent(event);  
                    }
                }
            });
        }
        if (this.mMusicPrevButtonTwo != null) {
            this.mMusicPrevButtonTwo.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.35
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (mediaSource == "fyt") {
                        Intent intent = new Intent();
                        intent.setAction("com.syu.music.prev");
                        intent.setPackage("com.syu.music");
                        Launcher.this.startService(intent);
                    } else if (mediaSource == "mediaController" && !MusicService.state) {
                        event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PREVIOUS);
                        am.dispatchMediaKeyEvent(event);                        
                    }
                }
            });
        }
        if (this.mMusicNextButton != null) {
            this.mMusicNextButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.36
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (mediaSource == "fyt") {
                        Intent intent = new Intent();
                        intent.setAction("com.syu.music.next");
                        intent.setPackage("com.syu.music");
                        Launcher.this.startService(intent);
                    } else if (mediaSource == "mediaController" && !MusicService.state) {
                        event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT);
                        am.dispatchMediaKeyEvent(event);                             
                    }
                }
            });
        }
        if (this.mMusicNextButtonTwo != null) {
            this.mMusicNextButtonTwo.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.37
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (mediaSource == "fyt") {
                        Intent intent = new Intent();
                        intent.setAction("com.syu.music.next");
                        intent.setPackage("com.syu.music");
                        Launcher.this.startService(intent);
                    } else if (mediaSource == "mediaController" && !MusicService.state) {
                        event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT);
                        am.dispatchMediaKeyEvent(event);                        
                    }
                }
            });
        }
        if (this.music_playpause != null) {
            this.music_playpause.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.38
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (mediaSource == "fyt") {
                        if (MusicService.state.booleanValue()) {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));                        
                        } else {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));                      
                        }     
                        Intent intent = new Intent();
                        intent.setAction("com.syu.music.playpause");
                        intent.setPackage("com.syu.music");
                        Launcher.this.startService(intent);                 
                    } else if (mediaSource == "mediaController") {
                        if (am.isMusicActive() && !MusicService.state) {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                            event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE);
                            am.dispatchMediaKeyEvent(event);                            
                        } else {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                            event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY);
                            am.dispatchMediaKeyEvent(event);                           
                        }
                    }
                }
            });
        }
        if (this.music_playpause_two != null) {
            this.music_playpause_two.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.39
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (mediaSource == "fyt") { 
                        if (MusicService.state.booleanValue()) {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));                        
                        } else {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));                      
                        } 
                        Intent intent = new Intent();
                        intent.setAction("com.syu.music.playpause");
                        intent.setPackage("com.syu.music");
                        Launcher.this.startService(intent);                               
                    } else if (mediaSource == "mediaController") {
                        if (am.isMusicActive() && !MusicService.state) {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                            event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PAUSE);
                            am.dispatchMediaKeyEvent(event);                            
                        } else {
                            music_playpause.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                            event = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY);
                            am.dispatchMediaKeyEvent(event);                           
                        }                        
                    }
                }
            });
        }
        if (this.kuwomusic_playpause != null) {
            this.kuwomusic_playpause.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.40
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Launcher.kwAPi != null) {
                        Launcher.this.needStartKuwo();
                        if (Launcher.this.mKwPlayState) {
                            Launcher.kwAPi.setPlayState(Launcher.mLauncher, PlayState.STATE_PAUSE);
                        } else {
                            Launcher.kwAPi.setPlayState(Launcher.mLauncher, PlayState.STATE_PLAY);
                        }
                    }
                }
            });
        }
        if (this.kuwomusic_prev != null) {
            this.kuwomusic_prev.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.41
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Launcher.kwAPi != null) {
                        Launcher.this.needStartKuwo();
                        Launcher.kwAPi.setPlayState(Launcher.this.getApplicationContext(), PlayState.STATE_PRE);
                    }
                }
            });
        }
        if (this.kuwomusic_next != null) {
            this.kuwomusic_next.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.42
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Launcher.kwAPi != null) {
                        Launcher.this.needStartKuwo();
                        Launcher.kwAPi.setPlayState(Launcher.this.getApplicationContext(), PlayState.STATE_NEXT);
                    }
                }
            });
        }
        if (this.mBtavPrevButton != null) {
            this.mBtavPrevButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.43
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction("com.syu.bt.byav.widgetPrev");
                    intent.setPackage("com.syu.bt");
                    Launcher.this.startService(intent);
                }
            });
        }
        if (this.mBtavNextButton != null) {
            this.mBtavNextButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.44
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction("com.syu.bt.byav.widgetNext");
                    intent.setPackage("com.syu.bt");
                    Launcher.this.startService(intent);
                }
            });
        }
        if (this.mBtavPlayPauseButton != null) {
            this.mBtavPlayPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.45
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction("com.syu.bt.byav.widgetPlayPause");
                    intent.setPackage("com.syu.bt");
                    Launcher.this.startService(intent);
                }
            });
        }
        if (this.mBtavIcon != null) {
            this.mBtavIcon.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.46
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
                    Launcher.this.startActivity(intent);
                }
            });
        }
        if (this.mRadioIcon != null) {
            this.mRadioIcon.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.47
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Launcher.this.startActivitySafely(v, FytPackage.getIntent(Launcher.mLauncher, "com.syu.radio"), "bt");
                }
            });
        }
        if (this.mMusicIcon != null) {
            this.mMusicIcon.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.48
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Launcher.this.startActivitySafely(v, FytPackage.getIntent(Launcher.mLauncher, "com.syu.music"), "bt");
                }
            });
        }
        if (this.mNaviView != null) {
            this.mNaviView.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.49
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intent launchIntent = new Intent();
                    launchIntent.setComponent(new ComponentName(FytPackage.GaodeACTION, "com.autonavi.auto.remote.fill.UsbFillActivity"));
                    Launcher.this.startActivitySafely(v, launchIntent, "bt");
                }
            });
        }
        if (this.video_playpause != null) {
            this.video_playpause.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.50
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Launcher.this.mVideoPlayState != null) {
                        if (Launcher.this.mVideoPlayState.equals("true")) {
                            CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 2);
                        } else {
                            CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 1);
                        }
                    }
                }
            });
        }
        if (this.video_prev != null) {
            this.video_prev.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.51
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 10);
                }
            });
        }
        if (this.video_next != null) {
            this.video_next.setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.52
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 11);
                }
            });
        }
    }

    public void handleNaviState() {
        if (CarStates.mAccState != 0) {
            switch (MyAutoMapReceiver.mCurState) {
                case 2:
                case 12:
                    clearGaoDeData();
                    return;
                case 3:
                case 5:
                case 6:
                case 7:
                case 11:
                default:
                    return;
                case 4:
                    MyAutoMapReceiver.mCurSpeed = 0;
                    break;
                case 8:
                case 10:
                    if (this.mInitNaviInfoView != null) {
                        this.mInitNaviInfoView.setVisibility(android.view.View.GONE);
                    }
                    if (this.mNaviRunView != null) {
                        this.mNaviRunView.setVisibility(android.view.View.VISIBLE);
                        return;
                    }
                    return;
                case 9:
                    break;
            }
            MyAutoMapReceiver.mCurSpeed = 0;
        }
    }

    private void clearGaoDeData() {
        if (this.mCurCityView != null) {
            this.mCurCityView.setText("");
        }
        if (this.mInitNaviInfoView != null) {
            this.mInitNaviInfoView.setVisibility(android.view.View.VISIBLE);
        }
        if (this.mNaviRunView != null) {
            this.mNaviRunView.setVisibility(android.view.View.GONE);
        }
        if (this.mTurnIconView != null) {
            this.mTurnIconView.setImageResource(ResValue.getInstance().default_icon);
        }
        if (this.mCurDis_RemainView != null) {
            this.mCurDis_RemainView.setText(Utils.getNameToStr("car_distance"));
        }
        if (this.mCurRemainTimeView != null) {
            this.mCurRemainTimeView.setText("");
        }
        if (this.mCurDis_AllView != null) {
            this.mCurDis_AllView.setText("0");
        }
        if (this.mCurDis_SurplusView != null) {
            this.mCurDis_SurplusView.setText("0km");
        }
        if (this.mCamera_DisView != null) {
            this.mCamera_DisView.setText("");
        }
        if (this.mCamera_DisImageView != null) {
            this.mCamera_DisImageView.setVisibility(android.view.View.GONE);
        }
        if (this.mCurRemainTimeView != null) {
            this.mCurRemainTimeView.setText("");
        }
        if (this.mNextRoadNameView != null) {
            this.mNextRoadNameView.setText(Utils.getNameToStr("car_realnavi"));
        }
        if (this.mNaviMycar != null) {
            this.mNaviMycar.setVisibility(android.view.View.VISIBLE);
        }
        if (this.mCurSpeedView != null) {
            this.mCurSpeedView.setText("0km/h");
        }
    }

    private void needStartAmap() {
        if (!AppUtil.isInTheTaskbar(getApplicationContext(), FytPackage.GaodeACTION)) {
            startActivitySafely(this.customView.get(Config.WS_Gaode), FytPackage.getIntent(this, FytPackage.GaodeACTION), "amap");
        }
    }

    public void updateLoadAnima() {
        if (this.mDynamicTrailView != null) {
            if (MyAutoMapReceiver.mCurSpeed >= 10) {
                this.mDynamicTrailView.setBackgroundResource(ResValue.getInstance().map_bg1 + count);
                count++;
                if (count == getResources().getInteger(R.integer.apps_widget_pic_sum)) {
                    count = 0;
                    return;
                }
                return;
            }
            this.mDynamicTrailView.setBackgroundResource(ResValue.getInstance().map_bg1);
        }
    }

    public void handleView() {
        String str;
        if (CarStates.mAccState != 0) {
            if (this.mInitNaviInfoView != null && this.mNaviRunView != null) {
                this.mInitNaviInfoView.setVisibility(android.view.View.GONE);
                this.mNaviRunView.setVisibility(android.view.View.VISIBLE);
            }
            if (MyAutoMapReceiver.mTurnIcon <= 0) {
                clearGaoDeData();
                return;
            }
            if (this.mTurnIconView != null) {
                switch (MyAutoMapReceiver.mTurnIcon) {
                    case 2:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_left);
                        break;
                    case 3:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_right);
                        break;
                    case 4:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_left_up);
                        break;
                    case 5:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_right_up);
                        break;
                    case 6:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_leftdown);
                        break;
                    case 7:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_rightdown);
                        break;
                    case 8:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_leftback);
                        break;
                    case 9:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().straight);
                        break;
                    case 10:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_mid_dest);
                        break;
                    case 11:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().trun_island_right);
                        break;
                    case 12:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().trun_island_right_line);
                        break;
                    case 13:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_park);
                        break;
                    case 14:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_charge);
                        break;
                    case 15:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_dest);
                        break;
                    case 16:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().tunnel);
                        break;
                    case 17:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().trun_island_left);
                        break;
                    case 18:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().trun_island_left_line);
                        break;
                    case 19:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().turn_rightback);
                        break;
                    case 20:
                        this.mTurnIconView.setImageResource(ResValue.getInstance().truen_slow_down);
                        break;
                }
            }
            if (this.mMapbgUnitView != null) {
                if (MyAutoMapReceiver.mCurDis_Remain > 1500) {
                    this.mMapbgUnitView.setImageResource(ResValue.getInstance().map_distance_bgunit2);
                } else {
                    this.mMapbgUnitView.setImageResource(ResValue.getInstance().map_distance_bgunit);
                }
            }
            if (this.mCurDis_RemainView != null) {
                if (MyAutoMapReceiver.mCurDis_Remain > 1500) {
                    float dis = MyAutoMapReceiver.mCurDis_Remain / 1000.0f;
                    str = String.format("%1$.1f", Float.valueOf(dis));
                    if (this.mMapbgUnitView == null) {
                        str = String.valueOf(str) + "KM";
                    }
                } else {
                    str = new StringBuilder(String.valueOf(MyAutoMapReceiver.mCurDis_Remain)).toString();
                    if (this.mMapbgUnitView == null) {
                        str = String.valueOf(str) + "M";
                    }
                }
                LogPreview.show("str:" + str);
                this.mCurDis_RemainView.setText(str);
            }
            if (this.mCurSpeedView != null) {
                this.mCurSpeedView.setText(String.valueOf(MyAutoMapReceiver.mCurSpeed) + "km/h");
            }
            if (this.mCurDis_AllView != null) {
                float dis2 = MyAutoMapReceiver.mCurDis_All / 1000.0f;
                String str2 = String.format("%1$.1f", Float.valueOf(dis2));
                this.mCurDis_AllView.setText(String.valueOf(str2) + "km");
            }
            if (this.mCurDis_SurplusView != null) {
                float dis3 = MyAutoMapReceiver.mREMAINDis / 1000.0f;
                String str3 = String.format("%1$.1f", Float.valueOf(dis3));
                this.mCurDis_SurplusView.setText(String.valueOf(str3) + "km");
            }
            if (this.mCamera_DisView != null) {
                if (MyAutoMapReceiver.mCameraDis == -1) {
                    this.mCamera_DisView.setText("");
                } else {
                    this.mCamera_DisView.setText(String.valueOf(MyAutoMapReceiver.mCameraDis) + "m");
                }
            }
            if (this.mCamera_DisImageView != null) {
                if (MyAutoMapReceiver.mCameraDis == -1) {
                    this.mCamera_DisImageView.setVisibility(android.view.View.GONE);
                } else {
                    this.mCamera_DisImageView.setVisibility(android.view.View.VISIBLE);
                }
            }
            if (this.mCurRemainTimeView != null) {
                int mREMAINTime = MyAutoMapReceiver.mREMAINTime;
                String time = formatDuration(mREMAINTime);
                this.mCurRemainTimeView.setText(String.valueOf(time) + getApplicationContext().getResources().getString(ResValue.getInstance().getId("tv_road", "string")));
            }
            if (this.mCurRoadNameView != null) {
                this.mCurRoadNameView.setText(MyAutoMapReceiver.mCurRoadName);
                this.mCurRoadNameView.setVisibility(android.view.View.VISIBLE);
            }
            if (this.mNextRoadNameView != null) {
                this.mNextRoadNameView.setText("进入  " + MyAutoMapReceiver.mNextRoadName);
                this.mNextRoadNameView.setVisibility(android.view.View.VISIBLE);
            }
            if (this.mNaviMycar != null) {
                this.mNaviMycar.setVisibility(android.view.View.GONE);
            }
        }
    }

    public static String formatDuration(int duration) {
        if (duration <= 0) {
            return "00:00:00";
        }
        int min = (duration / 60) % 60;
        int hour = (duration / 60) / 60;
        int second = duration % 60;
        return String.format("%02d:%02d:%02d", Integer.valueOf(hour), Integer.valueOf(min), Integer.valueOf(second));
    }

    public String timeParse(long duration) {
        String time = "";
        long minute = duration / 60000;
        long seconds = duration % 60000;
        long second = Math.round(((float) seconds) / 1000.0f);
        if (minute < 10) {
            time = String.valueOf("") + "0";
        }
        String time2 = String.valueOf(time) + minute + ":";
        if (second < 10) {
            time2 = String.valueOf(time2) + "0";
        }
        return String.valueOf(time2) + second;
    }

    public static Bitmap makeRoundCorner(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int left = 0;
        int top = 0;
        int right = width;
        int bottom = height;
        float roundPx = height / 2;
        if (width > height) {
            left = (width - height) / 2;
            top = 0;
            right = left + height;
            bottom = height;
        } else if (height > width) {
            left = 0;
            top = (height - width) / 2;
            right = width;
            bottom = top + width;
            roundPx = width / 2;
        }
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Rect rect = new Rect(left, top, right, bottom);
        RectF rectF = new RectF(rect);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#ffffffff"));
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static Bitmap GetRoundedCornerBitmap(Bitmap bitmap) {
        try {
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRoundRect(rectF, 35.0f, 35.0f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, src, rect, paint);
            return output;
        } catch (Exception e) {
            return bitmap;
        }
    }

    private String freqToString(String freq2) {
        float vals = Float.parseFloat(freq2);
        float val = vals / 1.0f;
        BigDecimal bd = new BigDecimal(val);
        return bd.setScale(0, 4).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String freqToString(int freq2) {
        float val = freq2 / 1.0f;
        BigDecimal bd = new BigDecimal(val);
        return bd.setScale(0, 4).toString();
    }

    public String timeChangeParse(long duration) {
        long hour = duration / 3600;
        long min = (duration / 60) % 60;
        long sec = duration % 60;
        String time = String.format("%02d:%02d:%02d", Long.valueOf(hour), Long.valueOf(min), Long.valueOf(sec));
        return time;
    }

    protected void startLiveWallpaper() {
        Intent pickWallpaper = new Intent("android.intent.action.SET_WALLPAPER");
        pickWallpaper.setComponent(getWallpaperPickerComponent());
        pickWallpaper.putExtra("live_wallpaper", 1);
        startActivityForResult(pickWallpaper, 10);
    }

    View createShortcut(ShortcutInfo info) {
        return createShortcut(R.layout.application, (ViewGroup) mWorkspace.getChildAt(mWorkspace.getCurrentPage()), info);
    }

    View createShortcut(int layoutResId, ViewGroup parent, ShortcutInfo info) {
        BubbleTextView favorite = (BubbleTextView) this.mInflater.inflate(layoutResId, parent, false);
        favorite.applyFromShortcutInfo(info, this.mIconCache);
        favorite.setOnClickListener(this);
        return favorite;
    }

    void completeAddApplication(Intent data, long container, long screenId, int cellX, int cellY) {
        int[] cellXY = this.mTmpAddItemCellCoordinates;
        CellLayout layout = getCellLayout(container, screenId);
        if (cellX >= 0 && cellY >= 0) {
            cellXY[0] = cellX;
            cellXY[1] = cellY;
        } else if (!layout.findCellForSpan(cellXY, 1, 1)) {
            showOutOfSpaceMessage(isHotseatLayout(layout));
            return;
        }
        ShortcutInfo info = mModel.getShortcutInfo(getPackageManager(), data, this);
        if (info != null) {
            info.setActivity(this, data.getComponent(), Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            info.container = -1L;
            mWorkspace.addApplicationShortcut(info, layout, container, screenId, cellXY[0], cellXY[1], isWorkspaceLocked(), cellX, cellY);
            return;
        }
        Log.e(TAG, "Couldn't find ActivityInfo for selected application: " + data);
    }

    private void completeAddShortcut(Intent data, long container, long screenId, int cellX, int cellY) {
        boolean foundCellSpan;
        int[] cellXY = this.mTmpAddItemCellCoordinates;
        int[] touchXY = this.mPendingAddInfo.dropPos;
        CellLayout layout = getCellLayout(container, screenId);
        ShortcutInfo info = mModel.infoFromShortcutIntent(this, data, null);
        if (info != null) {
            View view = createShortcut(info);
            if (cellX >= 0 && cellY >= 0) {
                cellXY[0] = cellX;
                cellXY[1] = cellY;
                foundCellSpan = true;
                if (!mWorkspace.createUserFolderIfNecessary(view, container, layout, cellXY, 0.0f, true, null, null)) {
                    DropTarget.DragObject dragObject = new DropTarget.DragObject();
                    dragObject.dragInfo = info;
                    if (mWorkspace.addToExistingFolderIfNecessary(view, layout, cellXY, 0.0f, dragObject, true)) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (touchXY != null) {
                int[] result = layout.findNearestVacantArea(touchXY[0], touchXY[1], 1, 1, cellXY);
                foundCellSpan = result != null;
            } else {
                foundCellSpan = layout.findCellForSpan(cellXY, 1, 1);
            }
            if (!foundCellSpan) {
                showOutOfSpaceMessage(isHotseatLayout(layout));
                return;
            }
            LauncherModel.addItemToDatabase(this, info, container, screenId, cellXY[0], cellXY[1], false);
            if (!this.mRestoring) {
                mWorkspace.addInScreen(view, container, screenId, cellXY[0], cellXY[1], 1, 1, isWorkspaceLocked());
            }
        }
    }

    static int[] getSpanForWidget(Context context, ComponentName component, int minWidth, int minHeight) {
        Rect padding = AppWidgetHostView.getDefaultPaddingForWidget(context, component, null);
        int requiredWidth = padding.left + minWidth + padding.right;
        int requiredHeight = padding.top + minHeight + padding.bottom;
        return CellLayout.rectToCell(requiredWidth, requiredHeight, null);
    }

    static int[] getSpanForWidget(Context context, AppWidgetProviderInfo info) {
        return getSpanForWidget(context, info.provider, info.minWidth, info.minHeight);
    }

    static int[] getMinSpanForWidget(Context context, AppWidgetProviderInfo info) {
        return getSpanForWidget(context, info.provider, info.minResizeWidth, info.minResizeHeight);
    }

    static int[] getSpanForWidget(Context context, PendingAddWidgetInfo info) {
        return getSpanForWidget(context, info.componentName, info.minWidth, info.minHeight);
    }

    static int[] getMinSpanForWidget(Context context, PendingAddWidgetInfo info) {
        return getSpanForWidget(context, info.componentName, info.minResizeWidth, info.minResizeHeight);
    }

    public void completeAddAppWidget(final int appWidgetId, long container, long screen, AppWidgetHostView hostView, AppWidgetProviderInfo appWidgetInfo) {
        boolean foundCellSpan;
        if (appWidgetInfo == null) {
            appWidgetInfo = this.mAppWidgetManager.getAppWidgetInfo(appWidgetId);
        }
        CellLayout layout = getCellLayout(container, screen);
        int[] minSpanXY = getMinSpanForWidget((Context) this, appWidgetInfo);
        int[] spanXY = getSpanForWidget((Context) this, appWidgetInfo);
        int[] cellXY = this.mTmpAddItemCellCoordinates;
        int[] touchXY = this.mPendingAddInfo.dropPos;
        int[] finalSpan = new int[2];
        if (this.mPendingAddInfo.cellX >= 0 && this.mPendingAddInfo.cellY >= 0) {
            cellXY[0] = this.mPendingAddInfo.cellX;
            cellXY[1] = this.mPendingAddInfo.cellY;
            spanXY[0] = this.mPendingAddInfo.spanX;
            spanXY[1] = this.mPendingAddInfo.spanY;
            foundCellSpan = true;
        } else if (touchXY != null) {
            int[] result = layout.findNearestVacantArea(touchXY[0], touchXY[1], minSpanXY[0], minSpanXY[1], spanXY[0], spanXY[1], cellXY, finalSpan);
            spanXY[0] = finalSpan[0];
            spanXY[1] = finalSpan[1];
            foundCellSpan = result != null;
        } else {
            foundCellSpan = layout.findCellForSpan(cellXY, minSpanXY[0], minSpanXY[1]);
        }
        if (!foundCellSpan) {
            if (appWidgetId != -1) {
                final int i = appWidgetId;
                new Thread("deleteAppWidgetId") {
                    public void run() {
                        Launcher.this.mAppWidgetHost.deleteAppWidgetId(i);
                    }
                }.start();
            }
            showOutOfSpaceMessage(isHotseatLayout(layout));
            return;
        }
        LauncherAppWidgetInfo launcherInfo = new LauncherAppWidgetInfo(appWidgetId, appWidgetInfo.provider);
        launcherInfo.spanX = spanXY[0];
        launcherInfo.spanY = spanXY[1];
        launcherInfo.minSpanX = this.mPendingAddInfo.minSpanX;
        launcherInfo.minSpanY = this.mPendingAddInfo.minSpanY;
        LauncherModel.addItemToDatabase(this, launcherInfo, container, screen, cellXY[0], cellXY[1], false);
        if (!this.mRestoring) {
            if (hostView == null) {
                launcherInfo.hostView = this.mAppWidgetHost.createView(this, appWidgetId, appWidgetInfo);
                launcherInfo.hostView.setAppWidget(appWidgetId, appWidgetInfo);
            } else {
                launcherInfo.hostView = hostView;
            }
            launcherInfo.hostView.setTag(launcherInfo);
            launcherInfo.hostView.setVisibility(View.VISIBLE);
            launcherInfo.notifyWidgetSizeChanged(this);
            this.mWorkspace.addInScreen(launcherInfo.hostView, container, screen, cellXY[0], cellXY[1], launcherInfo.spanX, launcherInfo.spanY, isWorkspaceLocked());
            addWidgetToAutoAdvanceIfNeeded(launcherInfo.hostView, appWidgetInfo);
        }
        resetAddInfo();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.mReceiver, filter);
        FirstFrameAnimatorHelper.initializeDrawListener(getWindow().getDecorView());
        this.mAttached = true;
        this.mVisible = true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mVisible = false;
        if (this.mAttached) {
            unregisterReceiver(this.mReceiver);
            this.mAttached = false;
        }
        updateRunning();
    }

    public void onWindowVisibilityChanged(int visibility) {
        this.mVisible = visibility == 0;
        updateRunning();
        if (this.mVisible) {
            this.mAppsCustomizeTabHost.onWindowVisible();
            if (!this.mWorkspaceLoading) {
                ViewTreeObserver observer = mWorkspace.getViewTreeObserver();
                onDrawListener = new ViewTreeObserver.OnDrawListener() {
                    private boolean mStarted = false;

                    @Override
                    public void onDraw() {
                        if (!this.mStarted) {
                            this.mStarted = true;
                            Launcher.mWorkspace.postDelayed(Launcher.this.mBuildLayersRunnable, 500L);
                            //final ViewTreeObserver.OnDrawListener listener = this;
                            Launcher.mWorkspace.post(new Runnable() { // from class: com.android.launcher66.Launcher.54.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (Launcher.mWorkspace != null && Launcher.mWorkspace.getViewTreeObserver() != null) {
                                        Launcher.mWorkspace.getViewTreeObserver().removeOnDrawListener(onDrawListener);
                                    }
                                }
                            });
                        }
                    }
                };
                observer.addOnDrawListener(onDrawListener);
            }
            clearTypedText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAdvanceMessage(long delay) {
        this.mHandler.removeMessages(1);
        Message msg = this.mHandler.obtainMessage(1);
        this.mHandler.sendMessageDelayed(msg, delay);
        this.mAutoAdvanceSentTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRunning() {
        boolean autoAdvanceRunning = this.mVisible && this.mUserPresent && !this.mWidgetsToAdvance.isEmpty();
        if (autoAdvanceRunning != this.mAutoAdvanceRunning) {
            this.mAutoAdvanceRunning = autoAdvanceRunning;
            if (autoAdvanceRunning) {
                long delay = this.mAutoAdvanceTimeLeft != -1 ? this.mAutoAdvanceTimeLeft : 20000L;
                sendAdvanceMessage(delay);
            } else {
                if (!this.mWidgetsToAdvance.isEmpty()) {
                    this.mAutoAdvanceTimeLeft = Math.max(0L, 20000 - (System.currentTimeMillis() - this.mAutoAdvanceSentTime));
                }
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
            }
        }
    }

    void addWidgetToAutoAdvanceIfNeeded(View hostView, AppWidgetProviderInfo appWidgetInfo) {
        if (appWidgetInfo != null && appWidgetInfo.autoAdvanceViewId != -1) {
            KeyEvent.Callback findViewById = hostView.findViewById(appWidgetInfo.autoAdvanceViewId);
            if (findViewById instanceof Advanceable) {
                this.mWidgetsToAdvance.put(hostView, appWidgetInfo);
                ((Advanceable) findViewById).fyiWillBeAdvancedByHostKThx();
                updateRunning();
            }
        }
    }

    void removeWidgetToAutoAdvance(View hostView) {
        if (this.mWidgetsToAdvance.containsKey(hostView)) {
            this.mWidgetsToAdvance.remove(hostView);
            updateRunning();
        }
    }

    public void removeAppWidget(LauncherAppWidgetInfo launcherInfo) {
        removeWidgetToAutoAdvance(launcherInfo.hostView);
        launcherInfo.hostView = null;
    }

    void showOutOfSpaceMessage(boolean isHotseatLayout) {
        int strId = isHotseatLayout ? R.string.hotseat_out_of_space : R.string.out_of_space;
        Toast.makeText(this, getString(strId), Toast.LENGTH_SHORT).show();
    }

    public LauncherAppWidgetHost getAppWidgetHost() {
        return this.mAppWidgetHost;
    }

    public static LauncherModel getModel() {
        return mModel;
    }

    public void closeSystemDialogs() {
        getWindow().closeAllPanels();
        this.mWaitingForResult = false;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if ("android.intent.action.MAIN".equals(intent.getAction())) {
            boolean alreadyOnHome = this.mHasFocus && (intent.getFlags() & 4194304) != 4194304;
            if (mWorkspace != null) {
                Folder openFolder = mWorkspace.getOpenFolder();
                mWorkspace.exitWidgetResizeMode();
                if (alreadyOnHome && this.mState == State.WORKSPACE && !mWorkspace.isTouchActive() && openFolder == null) {
                    mWorkspace.moveToDefaultScreen(true);
                }
                closeFolder();
                exitSpringLoadedDragMode();
                if (alreadyOnHome) {
                    showWorkspace(true);
                } else {
                    this.mOnResumeState = State.WORKSPACE;
                }
                View v = getWindow().peekDecorView();
                if (v != null && v.getWindowToken() != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                if (this.mAppsCustomizeTabHost != null) {
                    this.mAppsCustomizeTabHost.reset();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        Iterator<Integer> it = this.mSynchronouslyBoundPages.iterator();
        while (it.hasNext()) {
            int page = it.next().intValue();
            mWorkspace.restoreInstanceStateForChild(page);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        if (mWorkspace.getChildCount() > 0) {
            outState.putInt(RUNTIME_STATE_CURRENT_SCREEN, mWorkspace.getRestorePage());
        }
        super.onSaveInstanceState(outState);
        outState.putInt(RUNTIME_STATE, this.mState.ordinal());
        closeFolder();
        if (this.mPendingAddInfo.container != -1 && this.mPendingAddInfo.screenId > -1 && this.mWaitingForResult) {
            outState.putLong(RUNTIME_STATE_PENDING_ADD_CONTAINER, this.mPendingAddInfo.container);
            outState.putLong(RUNTIME_STATE_PENDING_ADD_SCREEN, this.mPendingAddInfo.screenId);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_CELL_X, this.mPendingAddInfo.cellX);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_CELL_Y, this.mPendingAddInfo.cellY);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_X, this.mPendingAddInfo.spanX);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_Y, this.mPendingAddInfo.spanY);
            outState.putParcelable(RUNTIME_STATE_PENDING_ADD_WIDGET_INFO, this.mPendingAddWidgetInfo);
        }
        if (this.mFolderInfo != null && this.mWaitingForResult) {
            outState.putBoolean(RUNTIME_STATE_PENDING_FOLDER_RENAME, true);
            outState.putLong(RUNTIME_STATE_PENDING_FOLDER_RENAME_ID, this.mFolderInfo.id);
        }
        if (this.mAppsCustomizeTabHost != null) {
            String currentTabTag = this.mAppsCustomizeTabHost.getCurrentTabTag();
            if (currentTabTag != null) {
                outState.putString("apps_customize_currentTab", currentTabTag);
            }
            int currentIndex = this.mAppsCustomizeContent.getSaveInstanceStateIndex();
            outState.putInt("apps_customize_currentIndex", currentIndex);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        WindowUtil.removePip(this.pipViews);
        super.onDestroy();
        this.tools.removeRefreshLisenter(0, this.refreshMain);
        this.tools.removeRefreshLisenter(4, this.refreshMain);
        this.tools.removeRefreshLisenter(7, this.refreshMain);
        this.tools.removeRefreshLisenter(2, this.refreshBtInfo);
        unregisterReceiver(this.removeMusic);
        unregisterReceiver(this.mAutoMap);
        unregisterReceiver(this.mTrifficReceiver);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(0);
        mWorkspace.removeCallbacks(this.mBuildLayersRunnable);
        LauncherAppState app = LauncherAppState.getInstance();
        mModel.stopLoader();
        app.setLauncher(null);
        try {
            this.mAppWidgetHost.stopListening();
        } catch (NullPointerException ex) {
            Log.w(TAG, "problem while stopping AppWidgetHost during Launcher destruction", ex);
        }
        this.mAppWidgetHost = null;
        this.mWidgetsToAdvance.clear();
        TextKeyListener.getInstance().release();
        if (mModel != null) {
            mModel.unbindItemInfosAndClearQueuedBindRunnables();
        }
        getContentResolver().unregisterContentObserver(this.mWidgetObserver);
        unregisterReceiver(this.mCloseSystemDialogsReceiver);
        this.mDragLayer.clearAllResizeFrames();
        ((ViewGroup) mWorkspace.getParent()).removeAllViews();
        mWorkspace.removeAllViews();
        mWorkspace = null;
        this.mDragController = null;
        LauncherAnimUtils.onDestroyActivity();
    }

    public DragController getDragController() {
        return this.mDragController;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int requestCode) {
        if (requestCode >= 0) {
            this.mWaitingForResult = true;
        }
        super.startActivityForResult(intent, requestCode);
    }

    @Override // android.app.Activity
    public void startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {
        showWorkspace(true);
        if (initialQuery == null) {
            initialQuery = getTypedText();
        }
        if (appSearchData == null) {
            appSearchData = new Bundle();
            appSearchData.putString("source", "launcher-search");
        }
        Rect sourceBounds = new Rect();
        if (this.mSearchDropTargetBar != null) {
            sourceBounds = this.mSearchDropTargetBar.getSearchBarBounds();
        }
        startSearch(initialQuery, selectInitialQuery, appSearchData, sourceBounds);
    }

    public void startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, Rect sourceBounds) {
        startGlobalSearch(initialQuery, selectInitialQuery, appSearchData, sourceBounds);
    }

    private void startGlobalSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, Rect sourceBounds) {
        Bundle appSearchData2;
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        ComponentName globalSearchActivity = searchManager.getGlobalSearchActivity();
        if (globalSearchActivity == null) {
            Log.w(TAG, "No global search activity found.");
            return;
        }
        Intent intent = new Intent("android.search.action.GLOBAL_SEARCH");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(globalSearchActivity);
        if (appSearchData == null) {
            appSearchData2 = new Bundle();
        } else {
            appSearchData2 = new Bundle(appSearchData);
        }
        if (!appSearchData2.containsKey("source")) {
            appSearchData2.putString("source", getPackageName());
        }
        intent.putExtra("app_data", appSearchData2);
        if (!TextUtils.isEmpty(initialQuery)) {
            intent.putExtra("query", initialQuery);
        }
        if (selectInitialQuery) {
            intent.putExtra("select_query", selectInitialQuery);
        }
        intent.setSourceBounds(sourceBounds);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "Global search activity not found: " + globalSearchActivity);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (!mWorkspace.isInOverviewMode()) {
            mWorkspace.enterOverviewMode();
            return false;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        startSearch((String) null, false, (Bundle) null, true);
        return true;
    }

    public boolean isWorkspaceLocked() {
        return this.mWorkspaceLoading || this.mWaitingForResult;
    }

    private void resetAddInfo() {
        this.mPendingAddInfo.container = -1L;
        this.mPendingAddInfo.screenId = -1L;
        ItemInfo itemInfo = this.mPendingAddInfo;
        this.mPendingAddInfo.cellY = -1;
        itemInfo.cellX = -1;
        ItemInfo itemInfo2 = this.mPendingAddInfo;
        this.mPendingAddInfo.spanY = -1;
        itemInfo2.spanX = -1;
        ItemInfo itemInfo3 = this.mPendingAddInfo;
        this.mPendingAddInfo.minSpanY = -1;
        itemInfo3.minSpanX = -1;
        this.mPendingAddInfo.dropPos = null;
    }

    void addAppWidgetImpl(int appWidgetId, ItemInfo info, AppWidgetHostView boundWidget, AppWidgetProviderInfo appWidgetInfo) {
        if (appWidgetInfo.configure != null) {
            this.mPendingAddWidgetInfo = appWidgetInfo;
            Log.e("LauncherModel", "appWidgetInfo:====" + appWidgetInfo);
            Intent intent = new Intent("android.appwidget.action.APPWIDGET_CONFIGURE");
            intent.setComponent(appWidgetInfo.configure);
            intent.putExtra("appWidgetId", appWidgetId);
            Utilities.startActivityForResultSafely(this, intent, 5);
            return;
        }
        Log.e("LauncherModel", "appwdigetId:====" + appWidgetId);
        completeAddAppWidget(appWidgetId, info.container, info.screenId, boundWidget, appWidgetInfo);
        exitSpringLoadedDragModeDelayed(true, false, null);
    }

    protected void moveToCustomContentScreen(boolean animate) {
        closeFolder();
        mWorkspace.moveToCustomContentScreen(animate);
    }

    void processShortcutFromDrop(ComponentName componentName, long container, long screenId, int[] cell, int[] loc) {
        resetAddInfo();
        this.mPendingAddInfo.container = container;
        this.mPendingAddInfo.screenId = screenId;
        this.mPendingAddInfo.dropPos = loc;
        if (cell != null) {
            this.mPendingAddInfo.cellX = cell[0];
            this.mPendingAddInfo.cellY = cell[1];
        }
        Intent createShortcutIntent = new Intent("android.intent.action.CREATE_SHORTCUT");
        createShortcutIntent.setComponent(componentName);
        processShortcut(createShortcutIntent);
    }

    void addAppWidgetFromDrop(PendingAddWidgetInfo info, long container, long screenId, int[] cell, int[] span, int[] loc) {
        boolean success;
        resetAddInfo();
        ItemInfo itemInfo = this.mPendingAddInfo;
        info.container = container;
        itemInfo.container = container;
        ItemInfo itemInfo2 = this.mPendingAddInfo;
        info.screenId = screenId;
        itemInfo2.screenId = screenId;
        this.mPendingAddInfo.dropPos = loc;
        this.mPendingAddInfo.minSpanX = info.minSpanX;
        this.mPendingAddInfo.minSpanY = info.minSpanY;
        if (cell != null) {
            this.mPendingAddInfo.cellX = cell[0];
            this.mPendingAddInfo.cellY = cell[1];
        }
        if (span != null) {
            this.mPendingAddInfo.spanX = span[0];
            this.mPendingAddInfo.spanY = span[1];
        }
        AppWidgetHostView hostView = info.boundWidget;
        if (hostView != null) {
            addAppWidgetImpl(hostView.getAppWidgetId(), info, hostView, info.info);
            return;
        }
        int appWidgetId = getAppWidgetHost().allocateAppWidgetId();
        Bundle options = info.bindOptions;
        if (options != null) {
            success = this.mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, info.componentName, options);
        } else {
            success = this.mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, info.componentName);
        }
        if (success) {
            addAppWidgetImpl(appWidgetId, info, null, info.info);
            return;
        }
        this.mPendingAddWidgetInfo = info.info;
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_BIND");
        intent.putExtra("appWidgetId", appWidgetId);
        intent.putExtra(LauncherSettings.Favorites.APPWIDGET_PROVIDER, info.componentName);
        startActivityForResult(intent, 11);
    }

    void processShortcut(Intent intent) {
        String applicationName = getResources().getString(R.string.group_applications);
        String shortcutName = intent.getStringExtra("android.intent.extra.shortcut.NAME");
        if (applicationName != null && applicationName.equals(shortcutName)) {
            Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
            mainIntent.addCategory("android.intent.category.LAUNCHER");
            Intent pickIntent = new Intent("android.intent.action.PICK_ACTIVITY");
            pickIntent.putExtra("android.intent.extra.INTENT", mainIntent);
            pickIntent.putExtra("android.intent.extra.TITLE", getText(R.string.title_select_application));
            Utilities.startActivityForResultSafely(this, pickIntent, 6);
            return;
        }
        Utilities.startActivityForResultSafely(this, intent, 1);
    }

    void processWallpaper(Intent intent) {
        startActivityForResult(intent, 10);
    }

    FolderIcon addFolder(CellLayout layout, long container, long screenId, int cellX, int cellY) {
        FolderInfo folderInfo = new FolderInfo();
        folderInfo.title = getText(R.string.folder_name);
        LauncherModel.addItemToDatabase(this, folderInfo, container, screenId, cellX, cellY, false);
        sFolders.put(Long.valueOf(folderInfo.id), folderInfo);
        FolderIcon newFolder = FolderIcon.fromXml(R.layout.folder_icon, this, layout, folderInfo, this.mIconCache);
        mWorkspace.addInScreen(newFolder, container, screenId, cellX, cellY, 1, 1, isWorkspaceLocked());
        CellLayout parent = mWorkspace.getParentCellLayoutForView(newFolder);
        parent.getShortcutsAndWidgets().measureChild(newFolder);
        return newFolder;
    }

    void removeFolder(FolderInfo folder) {
        sFolders.remove(Long.valueOf(folder.id));
    }

    protected ComponentName getWallpaperPickerComponent() {
        return new ComponentName(getPackageName(), WallpaperPickerActivity.class.getName());
    }

    private void registerContentObservers() {
        ContentResolver resolver = getContentResolver();
        resolver.registerContentObserver(LauncherProvider.CONTENT_APPWIDGET_RESET_URI, true, this.mWidgetObserver);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == 0) {
            switch (event.getKeyCode()) {
                case 3:
                    return true;
                case 25:
                    if (isPropertyEnabled(DUMP_STATE_PROPERTY)) {
                        dumpState();
                        return true;
                    }
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (event.getKeyCode()) {
                case 3:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public void setButtonVisible(boolean flag) {
        if (settingsButton == null || wallpaperButton == null) { 
            settingsButton = findViewById(ResValue.getInstance().widget_button);
            wallpaperButton = findViewById(ResValue.getInstance().wallpaper_button);
        }
        if (flag) {
            if (settingsButton != null) {
                settingsButton.setVisibility(View.VISIBLE);
            }
            wallpaperButton.setVisibility(android.view.View.VISIBLE);
            return;
        }
        if (settingsButton != null) {
            settingsButton.setVisibility(android.view.View.GONE);
        }
        wallpaperButton.setVisibility(android.view.View.GONE);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (isAllAppsVisible()) {
            if (this.mAppsCustomizeContent.getContentType() == AppsCustomizePagedView.ContentType.Applications || this.mAppsCustomizeContent.getContentType() == AppsCustomizePagedView.ContentType.Widgets) {
                showWorkspace(true);
            } else {
                setButtonVisible(true);
                this.mAllAppsButton.setVisibility(android.view.View.VISIBLE);
                showOverviewMode(true);
            }
        } else if (mWorkspace.isInOverviewMode()) {
            showHotseat(true, true);
            mWorkspace.exitOverviewMode(true);
            updateWallpaperVisibility(true);
        } else if (mWorkspace.getOpenFolder() != null) {
            Folder openFolder = mWorkspace.getOpenFolder();
            if (openFolder.isEditingName()) {
                openFolder.dismissEditingName();
            } else {
                closeFolder();
            }
        } else {
            mWorkspace.exitWidgetResizeMode();
            mWorkspace.showOutlinesTemporarily();
        }
        if (ResValue.getInstance().clickapp_cling > 0) {
            Cling cling = (Cling) findViewById(ResValue.getInstance().clickapp_cling);
            cling.setVisibility(android.view.View.GONE);
            stopVoice();
            LogPreview.show("onBackPressed");
            if (this.mWaitingForResume != null) {
                this.mWaitingForResume.setStayPressed(false);
            }
            if (this.mAppsCustomizeContent != null) {
                this.mAppsCustomizeContent.resetDrawableState();
            }
        }
        if (this.firstLayout != null) {
            this.firstLayout.setVisibility(android.view.View.VISIBLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppWidgetReset() {
        if (this.mAppWidgetHost != null) {
            this.mAppWidgetHost.startListening();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getWindowToken() != null && mWorkspace.isFinishedSwitchingState()) {
            if (v instanceof Workspace) {
                showHotseat(true, true);
                updateWallpaperVisibility(true);
                if (mWorkspace.isInOverviewMode()) {
                    mWorkspace.exitOverviewMode(true);
                    return;
                }
                return;
            }
            if (v instanceof CellLayout) {
                if (mWorkspace.isInOverviewMode()) {
                    mWorkspace.exitOverviewMode(mWorkspace.indexOfChild(v), true);
                }
                showHotseat(true, true);
                updateWallpaperVisibility(true);
            }
            Object tag = v.getTag();
            if (tag instanceof ShortcutInfo) {
                ShortcutInfo shortcut = (ShortcutInfo) tag;
                Intent intent = shortcut.intent;
                if (intent.getComponent() != null) {
                    String shortcutClass = intent.getComponent().getClassName();
                    if (shortcutClass.equals(WidgetAdder.class.getName())) {
                        showAllApps(true, AppsCustomizePagedView.ContentType.Widgets, true);
                        return;
                    }
                    if (shortcutClass.equals(MemoryDumpActivity.class.getName())) {
                        MemoryDumpActivity.startDump(this);
                        return;
                    } else if (shortcutClass.equals(ToggleWeightWatcher.class.getName())) {
                        toggleShowWeightWatcher();
                        return;
                    } else if (shortcutClass.equals(AppAct.class.getName())) {
                        onClickAllAppsButton(v);
                        return;
                    }
                }
                int[] pos = new int[2];
                v.getLocationOnScreen(pos);
                intent.setSourceBounds(new Rect(pos[0], pos[1], pos[0] + v.getWidth(), pos[1] + v.getHeight()));
                boolean success = startActivitySafely(v, intent, tag);
                this.mStats.recordLaunch(intent, shortcut);
                if (success && (v instanceof BubbleTextView)) {
                    this.mWaitingForResume = (BubbleTextView) v;
                    this.mWaitingForResume.setStayPressed(true);
                    return;
                }
                return;
            }
            if (tag instanceof FolderInfo) {
                if (v instanceof FolderIcon) {
                    FolderIcon fi = (FolderIcon) v;
                    handleFolderClick(fi);
                    return;
                }
                return;
            }
            if (v == this.mAllAppsButton || v == this.customView.get(Config.WS_Allapps) || v == this.customView.get(Config.ALLAPP)) {
                if (isAllAppsVisible()) {
                    showWorkspace(true);
                    return;
                } else {
                    onClickAllAppsButton(v);
                    return;
                }
            }
            if (v == this.customView.get(Config.NAVI)) {
                CarStates.getCar(getApplicationContext()).mTools.sendInt(0, 24, 0);
                return;
            }
            if (v == this.customView.get(Config.VOICE)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.voiceAction), "bt");
                return;
            }
            if (v == this.customView.get(Config.BT)) {
                startActivitySafely(v, getIntent("com.syu.bt", "com.syu.bt.BtAct"), "bt");
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.RADIO)) {
                if (CarStates.mExistCarRadio == 1) {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.CARRADIOACTION), "bt");
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.radio"), "bt");
                }
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.WS_Radio)) {
                if (CarStates.mExistCarRadio == 1) {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.CARRADIOACTION), "bt");
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.radio"), "music");
                }
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.WS_Music) || v == this.customView.get(Config.WS_Music_Two) || v == this.customView.get(Config.WS_Music3)) {
                if (mediaSource == "fyt") {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.music"), "music");
                } else if (mediaSource == "mediaController" && activeController != null) {
                    if (!activeController.isEmpty()) {
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(activeController);
                        startActivity(launchIntent);
                    }
                }
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.WS_Maps)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.mapsAction), "maps");
                return;
            }
            if (v == this.customView.get(Config.WS_Spotify)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.spotifyAction), "spotify");
                return;
            }
            if (v == this.customView.get(Config.WS_YouTube)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.youtubeAction), "youtube");
                return;
            }
            if (v == this.customView.get(Config.WS_Chrome)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.chromeAction), "chrome");
                return;
            }
            if (v == this.customView.get(Config.WS_MusicIV)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.music"), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Video)) {
                WindowUtil.removePip(this.pipViews);
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.video"), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Gallery)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.galleryAction), "galleryAction");
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.WS_Miudrive)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.miudriveAction), "miudriveAction");
                return;
            }
            if (v == this.customView.get(Config.WS_Aux)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.auxAction), "auxAction");
                return;
            }
            if (v == this.customView.get(Config.WS_Bt) || v == this.mBtavView) {
                startActivitySafely(v, getIntent("com.syu.bt", "com.syu.bt.BtAct"), "bt");
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.WS_Navi)) {
                CarStates.getCar(getApplicationContext()).mTools.sendInt(0, 24, 0);
                return;
            }
            if (v == this.customView.get(Config.WS_Gaode)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.GaodeACTION), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_KLFM)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KLFMACTION), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Kuwo)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KWACTION), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Dvr)) {
                if (Utils.getNameToBool("iscamera360")) {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.camera360"), "camera360");
                    return;
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.INNER_DVR), "music");
                    return;
                }
            }
            if (v == this.customView.get(Config.WS_Dvd)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.dvdAction), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Steer)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.steerACTION), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Easyconn)) {
                startActivitySafely(v, FytPackage.getIntent(this, "net.easyconn"), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Recharge)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.unicar"), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Voice)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.voiceAction), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_File) || v == this.customView.get(Config.FILE)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.filemanagerAction), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Car)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.carAction), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Tire)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.extireAction), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_Time) || v == this.customView.get(Config.WS_Time_Two)) {
                Intent mIntent = new Intent("android.settings.DATE_SETTINGS");
                startActivitySafely(v, mIntent, "date");
                return;
            }
            if (v == this.customView.get(Config.SETTING) || v == this.customView.get(Config.WS_Settings)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.settings"), "music");
                return;
            }
            if (v == this.customView.get(Config.VIDEO)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.video"), "music");
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.BTAV)) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
                startActivity(intent2);
                return;
            }
            if (v == this.customView.get(Config.ECAR)) {
                Intent intent3 = new Intent();
                intent3.setComponent(new ComponentName(FytPackage.ecarAction, FytPackage.ecarOnlineClassName));
                intent3.addCategory("android.intent.category.MAIN");
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(intent3);
                return;
            }
            if (v == this.customView.get(Config.SOS)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.sosAction), "music");
                return;
            }
            if (v == this.customView.get(Config.KUWO)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KWACTION), "music");
                return;
            }
            if (v == this.customView.get(Config.UNICAR)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.unicar"), "unicar");
                return;
            }
            if (v == this.customView.get(Config.MUSIC)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.music"), "music");
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.KLFM)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KLFMACTION), "music");
                return;
            }
            if (v == this.customView.get(Config.HONGFANS)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.hongfansAction), "hongfansAction");
                return;
            }
            if (v == this.customView.get(Config.DVR)) {
                if (Utils.getNameToBool("iscamera360")) {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.camera360"), "camera360");
                    return;
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.INNER_DVR), "INNER_DVR");
                    return;
                }
            }
            if (v == this.customView.get(Config.LIGHT)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(0, 10, -3);
                return;
            }
            if (v == this.customView.get(Config.CLOLSESCREEN) || v == this.customView.get(Config.WS_CLOLSESCREEN)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(0, 18, 1);
                return;
            }
            if (v == this.customView.get(Config.WIFI)) {
                startActivitySafely(v, new Intent("android.settings.WIFI_SETTINGS"), "settings");
                return;
            }
            if (v == this.customView.get(Config.SOUND) || v == this.customView.get(Config.WS_SOUND)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(4, 0, -6);
                return;
            }
            if (v == this.customView.get(Config.CLOLSESOUND) || v == this.customView.get(Config.WS_CLOSESOUND)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(4, 0, -6);
                CarStates.getCar(getApplicationContext()).getTools().sendInt(4, 0, -5);
                return;
            }
            if (v == this.customView.get(Config.EQ) || v == this.customView.get(Config.WS_EQ)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.eqACTION), "eq");
                WindowUtil.removePip(this.pipViews);
                return;
            }
            if (v == this.customView.get(Config.TIME)) {
                Intent mIntent2 = new Intent("android.settings.DATE_SETTINGS");
                startActivitySafely(v, mIntent2, "date");
                return;
            }
            if (v == this.customView.get(Config.WS_Dvr_Rec)) {
                Intent intent4 = new Intent(FytPackage.DVRSERVICE);
                intent4.setAction(FytPackage.RECACTION);
                intent4.setPackage(FytPackage.INNER_DVR);
                startService(intent4);
                return;
            }
            if (v == this.customView.get(Config.WS_Dvr_Lock)) {
                Intent intent5 = new Intent(FytPackage.DVRSERVICE);
                intent5.setAction(FytPackage.LOCKACTION);
                intent5.setPackage(FytPackage.INNER_DVR);
                startService(intent5);
                return;
            }
            if (v == this.customView.get(Config.WS_Dvr_Catch)) {
                Intent intent6 = new Intent(FytPackage.DVRSERVICE);
                intent6.setAction(FytPackage.PHOTOACTION);
                intent6.setPackage(FytPackage.INNER_DVR);
                startService(intent6);
                return;
            }
            if (v == this.customView.get(Config.WS_BRIGHT) || v == this.customView.get(Config.BRIGHT)) {
                new PopWindowBright(mLauncher, this.mBrightLevel).showPopupWindow(this.mDragLayer);
                return;
            }
            if (v == this.customView.get(Config.WS_BROWSER) || v == this.customView.get(Config.BROWSER)) {
                LogPreview.show("Config.WS_BROWSER");
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.browserAction), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_GUIDE)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.guideAction), "music");
                return;
            }
            if (v == this.customView.get(Config.WS_CALCULATOR)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.calculatorAction), "music");
                return;
            }
            if (v == this.customView.get(Config.NEWEYE)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.newsmy.ncarmanagerclient"), "newsmy");
                return;
            }
            if (v == this.customView.get(Config.WS_CANBUS) || v == this.customView.get(Config.CANBUS)) {
                LogPreview.show("Config.WS_CANBUS");
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.carBus), "canbus");
            } else if (v == this.customView.get(Config.WS_360)) {
                if (SystemProperties.getInt("persist.sys.inner360", 0) == 0) {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.INNER360), "360");
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.camera360"), "360");
                }
            }
        }
    }

    private Intent getIntent(String packageName, String className) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        ComponentName cn2 = new ComponentName(packageName, className);
        intent.setComponent(cn2);
        return intent;
    }

    private void startTrafficApp(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.mapgoo.broadcast.recv.renchexing");
        intent.putExtra(MapConfig.KEY_TYPE, 10000);
        intent.putExtra("EXTRA_TAB", 1);
        intent.putExtra("SOURCE_APP", "qingcheji");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        context.sendBroadcast(intent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void onClickSearchButton(View v) {
        v.performHapticFeedback(1);
        onSearchRequested();
    }

    public void onClickVoiceButton(View v) {
        v.performHapticFeedback(1);
        startVoice();
    }

    public void startVoice() {
        try {
            SearchManager searchManager = (SearchManager) getSystemService(android.content.Context.SEARCH_SERVICE);
            ComponentName activityName = searchManager.getGlobalSearchActivity();
            Intent intent = new Intent("android.speech.action.WEB_SEARCH");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (activityName != null) {
                intent.setPackage(activityName.getPackageName());
            }
            startActivity(null, intent, "onClickVoiceButton");
        } catch (ActivityNotFoundException e) {
            Intent intent2 = new Intent("android.speech.action.WEB_SEARCH");
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivitySafely(null, intent2, "onClickVoiceButton");
        }
    }

    public void onClickAllAppsButton(View v) {
        showAllApps(true, AppsCustomizePagedView.ContentType.Applications, true);
    }

    public void onTouchDownAllAppsButton(View v) {
        v.performHapticFeedback(1);
    }

    public void performHapticFeedbackOnTouchDown(View v) {
        v.performHapticFeedback(1);
    }

    public View.OnTouchListener getHapticFeedbackTouchListener() {
        if (this.mHapticFeedbackTouchListener == null) {
            this.mHapticFeedbackTouchListener = new View.OnTouchListener() { // from class: com.android.launcher66.Launcher.55
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    if ((event.getAction() & 255) == 0) {
                        v.performHapticFeedback(1);
                        return false;
                    }
                    return false;
                }
            };
        }
        return this.mHapticFeedbackTouchListener;
    }

    public void onClickAppMarketButton(View v) {
    }

    protected void onInteractionEnd() {
    }

    protected void onInteractionBegin() {
    }

    void startApplicationDetailsActivity(ComponentName componentName) {
        String packageName = componentName.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", packageName, null));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivitySafely(null, intent, "startApplicationDetailsActivity");
    }

    boolean startApplicationUninstallActivity(ComponentName componentName, int flags) {
        if ((flags & 1) == 0) {
            Toast.makeText(this, R.string.uninstall_system_app_text, android.widget.Toast.LENGTH_SHORT).show();
            return false;
        }
        String packageName = componentName.getPackageName();
        String className = componentName.getClassName();
        Intent intent = new Intent("android.intent.action.DELETE", Uri.fromParts("package", packageName, className));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(intent);
        return true;
    }

    // UnsupportedOperationException
    boolean startActivity(View v, Intent intent, Object tag) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            // Only launch using the new animation if the shortcut has not opted out (this is a
            // private contract between launcher and may be ignored in the future).
            boolean useLaunchAnimation = (v != null) &&
                    !intent.hasExtra(INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION);
            if (useLaunchAnimation) {
                ActivityOptions opts = ActivityOptions.makeScaleUpAnimation(v, 0, 0,
                        v.getMeasuredWidth(), v.getMeasuredHeight());

                startActivity(intent, opts.toBundle());
            } else {
                startActivity(intent);
            }
            return true;
        } catch (SecurityException e) {
            Toast.makeText(this, R.string.activity_not_found, Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Launcher does not have the permission to launch " + intent +
                    ". Make sure to create a MAIN intent-filter for the corresponding activity " +
                    "or use the exported attribute for this activity. "
                    + "tag="+ tag + " intent=" + intent, e);
        }
        return false;
    }

    private void testRemoveTask(String packagename) {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> task = am.getRunningTasks(32);
        for (ActivityManager.RunningTaskInfo amTask : task) {
            Log.i("test", "RunningTaskInfo " + amTask.baseActivity);
            String pkg = amTask.baseActivity.getPackageName();
            if (pkg.startsWith(packagename)) {
                am.moveTaskToFront(amTask.id, ActivityManager.MOVE_TASK_NO_USER_ACTION);
            }
        }
    }

    public boolean startActivitySafely(final View v, final Intent intent, final Object tag) {
        if (intent == null) {
            Toast.makeText(getApplicationContext(), R.string.activity_not_found, Toast.LENGTH_LONG).show();
            return this.success;
        }
        if (intent.getComponent() == null && ((v == this.customView.get(Config.WS_Dvr) || v == this.customView.get(Config.DVR)) && !Utils.getNameToBool("iscamera360"))) {
            Toast.makeText(getApplicationContext(), R.string.dvr_switch, android.widget.Toast.LENGTH_LONG).show();
            return this.success;
        }
        if (intent != null && intent.getComponent() != null) {
            if ("net.easyconn".equals(intent.getComponent().getPackageName())) {
                if (SystemProperties.get("sys.bdcl.enable").equals("0") && SystemProperties.get("service.adbec.enable").equals("1")) {
                    boolean start = start(v, intent, tag);
                    this.success = start;
                    return start;
                }
                testRemoveTask("com.baidu.carlifevehicle");
                SystemProperties.set("sys.bdcl.enable", "0");
                this.handler.postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.56
                    @Override // java.lang.Runnable
                    public void run() {
                        LogPreview.show("easyconnACTION");
                        Launcher.this.success = Launcher.this.start(v, intent, tag);
                    }
                }, 500L);
                SystemProperties.set("service.adbec.enable", "1");
            } else if ("com.baidu.carlifevehicle".equals(intent.getComponent().getPackageName())) {
                if (SystemProperties.get("sys.bdcl.enable").equals("1") && SystemProperties.get("service.adbec.enable").equals("0")) {
                    boolean start2 = start(v, intent, tag);
                    this.success = start2;
                    return start2;
                }
                testRemoveTask("net.easyconn");
                SystemProperties.set("service.adbec.enable", "0");
                this.handler.postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.57
                    @Override // java.lang.Runnable
                    public void run() {
                        LogPreview.show("carlifeACTION");
                        Launcher.this.success = Launcher.this.start(v, intent, tag);
                    }
                }, 500L);
                SystemProperties.set("sys.bdcl.enable", "1");
            }
        }
        TextView clingTitleText = (TextView) findViewById(ResValue.getInstance().clingtitletext);
        TextView clingText = (TextView) findViewById(ResValue.getInstance().clingtext);
        String str1 = SystemProperties.get("ro.client.foreign", "false");
        if (str1.equals("true") || ResValue.getInstance().clickapp_cling <= 0 || intent.getComponent() == null || !Config.EXISTVOICE || !this.closePop) {
            this.success = start(v, intent, tag);
        } else {
            if (findViewById(ResValue.getInstance().clickapp) != null) {
                findViewById(ResValue.getInstance().clickapp).setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.58
                    @Override // android.view.View.OnClickListener
                    public void onClick(View arg0) {
                        Cling cling = (Cling) Launcher.this.findViewById(ResValue.getInstance().clickapp_cling);
                        Runnable cb = new Runnable() { // from class: com.android.launcher66.Launcher.58.1
                            @Override // java.lang.Runnable
                            public void run() {
                            }
                        };
                        Launcher.this.dismissClingApp(cling, cb, intent, 200, true);
                        Launcher.this.success = Launcher.this.start(v, intent, tag);
                        Launcher.this.stopVoice();
                    }
                });
            }
            findViewById(ResValue.getInstance().clickapp_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.android.launcher66.Launcher.59
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    Cling cling = (Cling) Launcher.this.findViewById(ResValue.getInstance().clickapp_cling);
                    Runnable cb = new Runnable() { // from class: com.android.launcher66.Launcher.59.1
                        @Override // java.lang.Runnable
                        public void run() {
                        }
                    };
                    Launcher.this.dismissClingApp(cling, cb, intent, 200, true);
                    Launcher.this.stopVoice();
                    if (Launcher.this.mWaitingForResume != null) {
                        Launcher.this.mWaitingForResume.setStayPressed(false);
                    }
                    if (Launcher.this.mAppsCustomizeContent != null) {
                        Launcher.this.mAppsCustomizeContent.resetDrawableState();
                    }
                }
            });
            if (intent.getComponent().getPackageName().equals("com.syu.music")) {
                LogPreview.show("SystemProperties" + SystemProperties.getInt("persist.sys.clingmusic", 0));
                if (SystemProperties.getInt("persist.sys.clingmusic", 0) < 3) {
                    showClickappCling();
                    String clingMusicTitle = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingmusictitle", "string"));
                    String clingMusicText = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingmusictext", "string"));
                    clingTitleText.setText(clingMusicTitle);
                    clingText.setText(clingMusicText);
                    wakeVoice(String.valueOf(clingMusicTitle) + clingMusicText);
                } else {
                    this.success = start(v, intent, tag);
                }
            } else if (intent.getComponent().getPackageName().equals("com.syu.video")) {
                LogPreview.show("SystemProperties" + SystemProperties.getInt("persist.fyt.clingvideo", 0));
                if (SystemProperties.getInt("persist.sys.clingvideo", 0) < 3) {
                    showClickappCling();
                    String clingVideoTitle = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingvideotitle", "string"));
                    String clingVideoText = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingvideotext", "string"));
                    clingTitleText.setText(clingVideoTitle);
                    clingText.setText(clingVideoText);
                    wakeVoice(String.valueOf(clingVideoTitle) + clingVideoText);
                } else {
                    this.success = start(v, intent, tag);
                }
            } else if (intent.getComponent().getPackageName().equals(FytPackage.GaodeACTION)) {
                if (SystemProperties.getInt("persist.sys.clinggaode", 0) < 3) {
                    showClickappCling();
                    String clingNaveTitle = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingnavetitle", "string"));
                    String clingNaveText = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingnavetext", "string"));
                    clingTitleText.setText(clingNaveTitle);
                    clingText.setText(clingNaveText);
                    wakeVoice(String.valueOf(clingNaveTitle) + clingNaveText);
                } else {
                    this.success = start(v, intent, tag);
                }
            } else if (intent.getComponent().getPackageName().equals("com.syu.radio")) {
                if (SystemProperties.getInt("persist.sys.clingradio", 0) < 3) {
                    showClickappCling();
                    String clingRadioTitle = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingradiotitle", "string"));
                    String clingRadioText = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingradiotext", "string"));
                    clingTitleText.setText(clingRadioTitle);
                    clingText.setText(clingRadioText);
                    wakeVoice(String.valueOf(clingRadioTitle) + clingRadioText);
                } else {
                    this.success = start(v, intent, tag);
                }
            } else if (intent.getComponent().getPackageName().equals("com.syu.bt")) {
                if (SystemProperties.getInt("persist.sys.clingbt", 0) < 3) {
                    showClickappCling();
                    String clingBtTitle = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingbttitle", "string"));
                    String clingBtText = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingbttext", "string"));
                    clingTitleText.setText(clingBtTitle);
                    clingText.setText(clingBtText);
                    wakeVoice(String.valueOf(clingBtTitle) + clingBtText);
                } else {
                    this.success = start(v, intent, tag);
                }
            } else if (intent.getComponent().getPackageName().equals(FytPackage.KWACTION)) {
                if (SystemProperties.getInt("persist.sys.clingkuwo", 0) < 3) {
                    showClickappCling();
                    String clingKuwoTitle = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingkuwotitle", "string"));
                    String clingKuwoText = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingkuwotext", "string"));
                    clingTitleText.setText(clingKuwoTitle);
                    clingText.setText(clingKuwoText);
                    wakeVoice(String.valueOf(clingKuwoTitle) + clingKuwoText);
                } else {
                    this.success = start(v, intent, tag);
                }
            } else if (intent.getComponent().getPackageName().equals(FytPackage.KLFMACTION)) {
                if (SystemProperties.getInt("persist.sys.clingkaola", 0) < 3) {
                    showClickappCling();
                    String clingKaoLaTitle = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingkaolatitle", "string"));
                    String clingKaoLaText = getApplicationContext().getResources().getString(ResValue.getInstance().getId("clingkaolatext", "string"));
                    clingTitleText.setText(clingKaoLaTitle);
                    clingText.setText(clingKaoLaText);
                    wakeVoice(String.valueOf(clingKaoLaTitle) + clingKaoLaText);
                } else {
                    this.success = start(v, intent, tag);
                }
            } else {
                this.success = start(v, intent, tag);
            }
        }
        return this.success;
    }

    public void wakeVoice(String value) {
        Intent intent = new Intent("com.syu.execute_tts");
        intent.putExtra("raw_text", value);
        intent.setPackage(FytPackage.voiceAction);
        startService(intent);
    }

    public void stopVoice() {
        LogPreview.show("stopVoice");
        Intent intent = new Intent("com.syu.cancle_tts");
        intent.setPackage(FytPackage.voiceAction);
        startService(intent);
    }

    boolean start(View v, Intent intent, Object tag) {
        try {
            boolean success2 = startActivity(v, intent, tag);
            return success2;
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.activity_not_found, android.widget.Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Unable to launch. tag=" + tag + " intent=" + intent, e);
            return false;
        }
    }

    private void handleFolderClick(FolderIcon folderIcon) {
        FolderInfo info = folderIcon.getFolderInfo();
        Folder openFolder = mWorkspace.getFolderForTag(info);
        if (info.opened && openFolder == null) {
            Log.d(TAG, "Folder info marked as open, but associated folder is not open. Screen: " + info.screenId + " (" + info.cellX + ", " + info.cellY + ")");
            info.opened = false;
        }
        if (!info.opened && !folderIcon.getFolder().isDestroyed()) {
            closeFolder();
            openFolder(folderIcon);
        } else if (openFolder != null) {
            int folderScreen = mWorkspace.getPageForView(openFolder);
            closeFolder(openFolder);
            if (folderScreen != mWorkspace.getCurrentPage()) {
                closeFolder();
                openFolder(folderIcon);
            }
        }
    }

    private void copyFolderIconToImage(FolderIcon fi) {
        DragLayer.LayoutParams lp;
        int width = fi.getMeasuredWidth();
        int height = fi.getMeasuredHeight();
        if (this.mFolderIconImageView == null) {
            this.mFolderIconImageView = new ImageView(this);
        }
        if (this.mFolderIconBitmap == null || this.mFolderIconBitmap.getWidth() != width || this.mFolderIconBitmap.getHeight() != height) {
            this.mFolderIconBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            this.mFolderIconCanvas = new Canvas(this.mFolderIconBitmap);
        }
        if (this.mFolderIconImageView.getLayoutParams() instanceof DragLayer.LayoutParams) {
            lp = (DragLayer.LayoutParams) this.mFolderIconImageView.getLayoutParams();
        } else {
            lp = new DragLayer.LayoutParams(width, height);
        }
        float scale = this.mDragLayer.getDescendantRectRelativeToSelf(fi, this.mRectForFolderAnimation);
        lp.customPosition = true;
        lp.x = this.mRectForFolderAnimation.left;
        lp.y = this.mRectForFolderAnimation.top;
        lp.width = (int) (width * scale);
        lp.height = (int) (height * scale);
        this.mFolderIconCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        fi.draw(this.mFolderIconCanvas);
        this.mFolderIconImageView.setImageBitmap(this.mFolderIconBitmap);
        if (fi.getFolder() != null) {
            this.mFolderIconImageView.setPivotX(fi.getFolder().getPivotXForIconAnimation());
            this.mFolderIconImageView.setPivotY(fi.getFolder().getPivotYForIconAnimation());
        }
        if (this.mDragLayer.indexOfChild(this.mFolderIconImageView) != -1) {
            this.mDragLayer.removeView(this.mFolderIconImageView);
        }
        this.mDragLayer.addView(this.mFolderIconImageView, lp);
        if (fi.getFolder() != null) {
            fi.getFolder().bringToFront();
        }
    }

    private void growAndFadeOutFolderIcon(FolderIcon fi) {
        if (fi != null) {
            PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.0f);
            PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.5f);
            PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.5f);
            FolderInfo info = (FolderInfo) fi.getTag();
            if (info.container == -101) {
                CellLayout cl = (CellLayout) fi.getParent().getParent();
                CellLayout.LayoutParams lp = (CellLayout.LayoutParams) fi.getLayoutParams();
                cl.setFolderLeaveBehindCell(lp.cellX, lp.cellY);
            }
            copyFolderIconToImage(fi);
            fi.setVisibility(android.view.View.INVISIBLE);
            ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(this.mFolderIconImageView, alpha, scaleX, scaleY);
            oa.setDuration(getResources().getInteger(R.integer.config_folderAnimDuration));
            oa.start();
        }
    }

    private void shrinkAndFadeInFolderIcon(final FolderIcon fi) {
        if (fi != null) {
            PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1.0f);
            PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f);
            PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f);
            final CellLayout cl = (CellLayout) fi.getParent().getParent();
            this.mDragLayer.removeView(this.mFolderIconImageView);
            copyFolderIconToImage(fi);
            ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(this.mFolderIconImageView, alpha, scaleX, scaleY);
            oa.setDuration(getResources().getInteger(R.integer.config_folderAnimDuration));
            oa.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.Launcher.60
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (cl != null) {
                        cl.clearFolderLeaveBehind();
                        Launcher.this.mDragLayer.removeView(Launcher.this.mFolderIconImageView);
                        fi.setVisibility(android.view.View.VISIBLE);
                    }
                }
            });
            oa.start();
        }
    }

    public void openFolder(FolderIcon folderIcon) {
        Folder folder = folderIcon.getFolder();
        FolderInfo info = folder.mInfo;
        info.opened = true;
        if (folder.getParent() == null) {
            this.mDragLayer.addView(folder);
            this.mDragController.addDropTarget(folder);
        } else {
            Log.w(TAG, "Opening folder (" + folder + ") which already has a parent (" + folder.getParent() + ").");
        }
        folder.animateOpen();
        growAndFadeOutFolderIcon(folderIcon);
        folder.sendAccessibilityEvent(AccessibilityEvent.CONTENT_CHANGE_TYPE_PANE_DISAPPEARED);
        getDragLayer().sendAccessibilityEvent(AccessibilityEvent.CONTENT_CHANGE_TYPE_ERROR);
    }

    public void closeFolder() {
        Folder folder = mWorkspace.getOpenFolder();
        if (folder != null) {
            if (folder.isEditingName()) {
                folder.dismissEditingName();
            }
            closeFolder(folder);
            dismissFolderCling(null);
        }
    }

    void closeFolder(Folder folder) {
        folder.getInfo().opened = false;
        ViewGroup parent = (ViewGroup) folder.getParent().getParent();
        if (parent != null) {
            FolderIcon fi = (FolderIcon) mWorkspace.getViewForTag(folder.mInfo);
            shrinkAndFadeInFolderIcon(fi);
        }
        folder.animateClosed();
        getDragLayer().sendAccessibilityEvent(AccessibilityEvent.CONTENT_CHANGE_TYPE_PANE_DISAPPEARED);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        LogPreview.show("onLongClick");
        if (!isDraggingEnabled() || isWorkspaceLocked() || this.mState != State.WORKSPACE) {
            return false;
        }
        if ((v instanceof Workspace) && !mWorkspace.isInOverviewMode()) {
            if (mWorkspace.enterOverviewMode()) {
                hideHotseat(true, true);
                mWorkspace.performHapticFeedback(0, 1);
                return true;
            }
            showHotseat(true, true);
            updateWallpaperVisibility(true);
            return false;
        }
        if (!(v instanceof CellLayout)) {
            v = (View) v.getParent().getParent();
        } else if (!mWorkspace.isInOverviewMode()) {
            if (mWorkspace.enterOverviewMode()) {
                hideHotseat(true, true);
                mWorkspace.performHapticFeedback(0, 1);
                return true;
            }
            showHotseat(true, true);
            updateWallpaperVisibility(true);
            return false;
        }
        resetAddInfo();
        CellLayout.CellInfo longClickCellInfo = (CellLayout.CellInfo) v.getTag();
        if (longClickCellInfo == null) {
            return true;
        }
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.widget_isfix) && longClickCellInfo.cell != null && longClickCellInfo.cell.toString().contains("com.android.launcher66.LauncherAppWidgetHost")) {
            return false;
        }
        View itemUnderLongClick = longClickCellInfo.cell;
        boolean allowLongPress = isHotseatLayout(v) || mWorkspace.allowLongPress();
        if (allowLongPress && !this.mDragController.isDragging()) {
            if (itemUnderLongClick == null) {
                mWorkspace.performHapticFeedback(0, 1);
                if (mWorkspace.isInOverviewMode()) {
                    mWorkspace.startReordering(v);
                } else {
                    mWorkspace.enterOverviewMode();
                }
            } else {
                if (!(itemUnderLongClick instanceof Folder)) {
                    mWorkspace.startDrag(longClickCellInfo);
                    WindowUtil.removePip(this.pipViews);
                    hideHotseat(true, true);
                }
                new Handler().postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.61
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!Launcher.this.getDragController().isDragging() || Launcher.this.mState != State.WORKSPACE) {
                            return;
                        }
                        Launcher.this.hideAppsCustomizeHelper(Workspace.State.SPRING_LOADED, false, true, null);
                        Launcher.this.mState = State.APPS_CUSTOMIZE_SPRING_LOADED;
                    }
                }, 150L);
            }
        }
        return true;
    }

    boolean isHotseatLayout(View layout) {
        return false;
    }

    View getHotseat() {
        return this.mHotseat;
    }

    View getOverviewPanel() {
        return this.mOverviewPanel;
    }

    public static Workspace getWorkSpace() {
        return mWorkspace;
    }

    public static Launcher getLauncher() {
        return mLauncher;
    }

    SearchDropTargetBar getSearchBar() {
        return this.mSearchDropTargetBar;
    }

    CellLayout getCellLayout(long container, long screenId) {
        if (container != -101) {
            return mWorkspace.getScreenWithId(screenId);
        }
        if (this.mHotseat != null) {
        }
        return null;
    }

    Workspace getWorkspace() {
        return mWorkspace;
    }

    public boolean isAllAppsVisible() {
        return this.mState == State.APPS_CUSTOMIZE || this.mOnResumeState == State.APPS_CUSTOMIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPivotsForZoom(View view, float scaleFactor) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
    }

    private void setWorkspaceBackground(boolean workspace) {
    }

    void updateWallpaperVisibility(boolean visible) {
        int wpflags = visible ? WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER : 0;
        int curflags = getWindow().getAttributes().flags & WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER;
        if (wpflags != curflags) {
            getWindow().setFlags(wpflags, WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER);
        }
        setWorkspaceBackground(visible);
    }

    private void dispatchOnLauncherTransitionPrepare(View v, boolean animated, boolean toWorkspace) {
        if (v instanceof LauncherTransitionable) {
            ((LauncherTransitionable) v).onLauncherTransitionPrepare(this, animated, toWorkspace);
        }
    }

    private void dispatchOnLauncherTransitionStart(View v, boolean animated, boolean toWorkspace) {
        if (v instanceof LauncherTransitionable) {
            ((LauncherTransitionable) v).onLauncherTransitionStart(this, animated, toWorkspace);
        }

        // Update the workspace transition step as well
        dispatchOnLauncherTransitionStep(v, 0f);
    }

    private void dispatchOnLauncherTransitionStep(View v, float t) {
        if (v instanceof LauncherTransitionable) {
            ((LauncherTransitionable) v).onLauncherTransitionStep(this, t);
        }
    }

    private void dispatchOnLauncherTransitionEnd(View v, boolean animated, boolean toWorkspace) {
        if (v instanceof LauncherTransitionable) {
            ((LauncherTransitionable) v).onLauncherTransitionEnd(this, animated, toWorkspace);
        }

        // Update the workspace transition step as well
        dispatchOnLauncherTransitionStep(v, 1f);
    }

    private void showAppsCustomizeHelper(boolean animated, boolean springLoaded) {
        AppsCustomizePagedView.ContentType contentType = this.mAppsCustomizeContent.getContentType();
        showAppsCustomizeHelper(animated, springLoaded, contentType);
    }

    private void showAppsCustomizeHelper(final boolean animated, boolean springLoaded, AppsCustomizePagedView.ContentType contentType) {
        if (this.mStateAnimation != null) {
            this.mStateAnimation.setDuration(0L);
            this.mStateAnimation.cancel();
            this.mStateAnimation = null;
        }
        Resources res = getResources();
        int duration = res.getInteger(R.integer.config_appsCustomizeZoomInTime);
        int fadeDuration = res.getInteger(R.integer.config_appsCustomizeFadeInTime);
        final float scale = res.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        final View fromView = mWorkspace;
        final AppsCustomizeTabHost toView = this.mAppsCustomizeTabHost;
        int startDelay = res.getInteger(R.integer.config_workspaceAppsCustomizeAnimationStagger);
        setPivotsForZoom(toView, scale);
        hideHotseat(animated);
        Animator workspaceAnim = mWorkspace.getChangeStateAnimation(Workspace.State.SMALL, animated, contentType);
        if (!AppsCustomizePagedView.DISABLE_ALL_APPS) {
            this.mAppsCustomizeTabHost.setContentTypeImmediate(contentType);
        }
        if (animated) {
            toView.setScaleX(scale);
            toView.setScaleY(scale);
            LauncherViewPropertyAnimator scaleAnim = new LauncherViewPropertyAnimator(toView);
            scaleAnim.scaleX(1.0f).scaleY(1.0f).setDuration(duration).setInterpolator(new Workspace.ZoomOutInterpolator());
            toView.setVisibility(android.view.View.VISIBLE);
            toView.setAlpha(0.0f);
            ObjectAnimator alphaAnim = LauncherAnimUtils.ofFloat(toView, "alpha", 0.0f, 1.0f).setDuration(fadeDuration);
            alphaAnim.setInterpolator(new DecelerateInterpolator(1.5f));
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.Launcher.62
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator animation) {
                    if (animation == null) {
                        throw new RuntimeException("animation is null");
                    }
                    float t = ((Float) animation.getAnimatedValue()).floatValue();
                    Launcher.this.dispatchOnLauncherTransitionStep(fromView, t);
                    Launcher.this.dispatchOnLauncherTransitionStep(toView, t);
                }
            });
            this.mStateAnimation = LauncherAnimUtils.createAnimatorSet();
            this.mStateAnimation.play(scaleAnim).after(startDelay);
            this.mStateAnimation.play(alphaAnim).after(startDelay);
            this.mStateAnimation.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.Launcher.63
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    toView.setTranslationX(0.0f);
                    toView.setTranslationY(0.0f);
                    toView.setVisibility(android.view.View.VISIBLE);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Launcher.this.dispatchOnLauncherTransitionEnd(fromView, animated, false);
                    Launcher.this.dispatchOnLauncherTransitionEnd(toView, animated, false);
                    if (Launcher.this.mSearchDropTargetBar != null) {
                        Launcher.this.mSearchDropTargetBar.hideSearchBar(false);
                    }
                }
            });
            if (workspaceAnim != null) {
                this.mStateAnimation.play(workspaceAnim);
            }
            boolean delayAnim = false;
            dispatchOnLauncherTransitionPrepare(fromView, animated, false);
            dispatchOnLauncherTransitionPrepare(toView, animated, false);
            if (toView.getContent().getMeasuredWidth() == 0 || mWorkspace.getMeasuredWidth() == 0 || toView.getMeasuredWidth() == 0) {
                delayAnim = true;
            }
            final AnimatorSet stateAnimation = this.mStateAnimation;
            final Runnable startAnimRunnable = new Runnable() { // from class: com.android.launcher66.Launcher.64
                @Override // java.lang.Runnable
                public void run() {
                    if (Launcher.this.mStateAnimation == stateAnimation) {
                        Launcher.this.setPivotsForZoom(toView, scale);
                        Launcher.this.dispatchOnLauncherTransitionStart(fromView, animated, false);
                        Launcher.this.dispatchOnLauncherTransitionStart(toView, animated, false);
                        LauncherAnimUtils.startAnimationAfterNextDraw(Launcher.this.mStateAnimation, toView);
                    }
                }
            };
            if (delayAnim) {
                ViewTreeObserver observer = toView.getViewTreeObserver();
                observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.android.launcher66.Launcher.65
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        startAnimRunnable.run();
                        toView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            } else {
                startAnimRunnable.run();
            }
        } else {
            toView.setTranslationX(0.0f);
            toView.setTranslationY(0.0f);
            toView.setScaleX(1.0f);
            toView.setScaleY(1.0f);
            toView.setAlpha(1.0f);
            toView.setVisibility(android.view.View.VISIBLE);
            if (!springLoaded && !LauncherAppState.getInstance().isScreenLarge() && this.mSearchDropTargetBar != null) {
                this.mSearchDropTargetBar.hideSearchBar(false);
            }
            dispatchOnLauncherTransitionPrepare(fromView, animated, false);
            dispatchOnLauncherTransitionStart(fromView, animated, false);
            dispatchOnLauncherTransitionEnd(fromView, animated, false);
            dispatchOnLauncherTransitionPrepare(toView, animated, false);
            dispatchOnLauncherTransitionStart(toView, animated, false);
            dispatchOnLauncherTransitionEnd(toView, animated, false);
        }
        if (contentType == AppsCustomizePagedView.ContentType.Widgets) {
            getOverviewPanel().setVisibility(android.view.View.VISIBLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAppsCustomizeHelper(Workspace.State toState, final boolean animated, boolean springLoaded, Runnable onCompleteRunnable) {
        if (this.mStateAnimation != null) {
            this.mStateAnimation.setDuration(0L);
            this.mStateAnimation.cancel();
            this.mStateAnimation = null;
        }
        Resources res = getResources();
        int duration = res.getInteger(R.integer.config_appsCustomizeZoomOutTime);
        int fadeOutDuration = res.getInteger(R.integer.config_appsCustomizeFadeOutTime);
        float scaleFactor = res.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        final float scale = res.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        final View fromView = this.mAppsCustomizeTabHost;
        final Workspace workspace = mWorkspace;
        int startDelay = res.getInteger(R.integer.config_workspaceAppsCustomizeAnimationStagger);
        Animator workspaceAnim = null;
        if (toState == Workspace.State.NORMAL) {
            int stagger = res.getInteger(R.integer.config_appsCustomizeWorkspaceAnimationStagger);
            workspaceAnim = mWorkspace.getChangeStateAnimation(toState, animated, stagger, -1);
        } else if (toState == Workspace.State.SPRING_LOADED || toState == Workspace.State.OVERVIEW) {
            workspaceAnim = mWorkspace.getChangeStateAnimation(toState, animated);
        }
        setPivotsForZoom(fromView, scaleFactor);
        showHotseat(animated);
        if (animated) {
            workspace.setScaleX(scale);
            workspace.setScaleY(scale);
            LauncherViewPropertyAnimator scaleAnim = new LauncherViewPropertyAnimator(workspace);
            scaleAnim.scaleX(1.0f).scaleY(1.0f).setDuration(duration).setInterpolator(new Workspace.ZoomOutInterpolator());
            workspace.setAlpha(0.0f);
            ObjectAnimator alphaAnim = LauncherAnimUtils.ofFloat(workspace, "alpha", 0.0f, 1.0f).setDuration(fadeOutDuration);
            alphaAnim.setInterpolator(new DecelerateInterpolator(1.5f));
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.Launcher.66
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator animation) {
                    if (animation == null) {
                        throw new RuntimeException("animation is null");
                    }
                    float t = ((Float) animation.getAnimatedValue()).floatValue();
                    Launcher.this.dispatchOnLauncherTransitionStep(fromView, t);
                    Launcher.this.dispatchOnLauncherTransitionStep(workspace, t);
                }
            });
            dispatchOnLauncherTransitionPrepare(fromView, animated, true);
            dispatchOnLauncherTransitionPrepare(workspace, animated, true);
            this.mStateAnimation = LauncherAnimUtils.createAnimatorSet();
            this.mStateAnimation.play(scaleAnim).after(startDelay);
            this.mStateAnimation.play(alphaAnim).after(startDelay);
            this.mStateAnimation.addListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.Launcher.67
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    fromView.setVisibility(android.view.View.GONE);
                    workspace.setTranslationX(0.0f);
                    workspace.setTranslationY(0.0f);
                }
            });
            dispatchOnLauncherTransitionEnd(fromView, animated, true);
            dispatchOnLauncherTransitionEnd(workspace, animated, true);
            if (this.mSearchDropTargetBar != null) {
                this.mSearchDropTargetBar.showSearchBar(false);
            }
            if (workspaceAnim != null) {
                this.mStateAnimation.play(workspaceAnim);
            }
            boolean delayAnim = false;
            if (workspace.getContent().getMeasuredWidth() == 0 || mWorkspace.getMeasuredWidth() == 0 || workspace.getMeasuredWidth() == 0) {
                delayAnim = true;
            }
            final AnimatorSet stateAnimation = this.mStateAnimation;
            final Runnable startAnimRunnable = new Runnable() { // from class: com.android.launcher66.Launcher.68
                @Override // java.lang.Runnable
                public void run() {
                    if (Launcher.this.mStateAnimation == stateAnimation) {
                        Launcher.this.setPivotsForZoom(workspace, scale);
                        Launcher.this.dispatchOnLauncherTransitionStart(fromView, animated, true);
                        Launcher.this.dispatchOnLauncherTransitionStart(workspace, animated, true);
                        LauncherAnimUtils.startAnimationAfterNextDraw(Launcher.this.mStateAnimation, workspace);
                    }
                }
            };
            if (delayAnim) {
                ViewTreeObserver observer = workspace.getViewTreeObserver();
                observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.android.launcher66.Launcher.69
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        startAnimRunnable.run();
                        workspace.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
                return;
            } else {
                startAnimRunnable.run();
                return;
            }
        }
        fromView.setVisibility(android.view.View.GONE);
        dispatchOnLauncherTransitionPrepare(fromView, animated, true);
        dispatchOnLauncherTransitionStart(fromView, animated, true);
        dispatchOnLauncherTransitionEnd(fromView, animated, true);
        dispatchOnLauncherTransitionPrepare(workspace, animated, true);
        dispatchOnLauncherTransitionStart(workspace, animated, true);
        dispatchOnLauncherTransitionEnd(workspace, animated, true);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level >= 60) {
            this.mAppsCustomizeTabHost.onTrimMemory();
        }
    }

    public void showWorkspace(boolean animated) {
        showWorkspace(animated, null);
        showHotseat(true, true);
        updateWallpaperVisibility(true);
    }

    protected void showWorkspace() {
        showWorkspace(true);
    }

    void showWorkspace(boolean animated, Runnable onCompleteRunnable) {
        if (mWorkspace.isInOverviewMode()) {
            mWorkspace.exitOverviewMode(animated);
        }
        showHotseat(animated);
        LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_hotseat_hide);
        if (this.mState != State.WORKSPACE) {
            boolean wasInSpringLoadedMode = this.mState != State.WORKSPACE;
            mWorkspace.setVisibility(android.view.View.VISIBLE);
            hideAppsCustomizeHelper(Workspace.State.NORMAL, false, false, onCompleteRunnable);
            if (this.mSearchDropTargetBar != null) {
                this.mSearchDropTargetBar.showSearchBar(animated && wasInSpringLoadedMode);
            }
            if (this.mAllAppsButton != null) {
                this.mAllAppsButton.requestFocus();
            }
        }
        this.mState = State.WORKSPACE;
        this.mUserPresent = true;
        updateRunning();
        WindowUtil.startMapPip(this.pipViews, false);
        getWindow().getDecorView().sendAccessibilityEvent(AccessibilityEvent.CONTENT_CHANGE_TYPE_PANE_DISAPPEARED);
        onWorkspaceShown(animated);
    }

    void showOverviewMode(boolean animated) {
        mWorkspace.setVisibility(android.view.View.VISIBLE);
        hideAppsCustomizeHelper(Workspace.State.OVERVIEW, false, false, null);
        this.mState = State.WORKSPACE;
        onWorkspaceShown(animated);
    }

    public void onWorkspaceShown(boolean animated) {
    }

    void showAllApps(boolean animated, AppsCustomizePagedView.ContentType contentType, boolean resetPageToZero) {
        if (this.mState == State.WORKSPACE) {
            if (resetPageToZero) {
                this.mAppsCustomizeTabHost.reset();
            }
            hideHotseat(true);
            LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_hotseat_hide);
            showAppsCustomizeHelper(animated, true, contentType);
            this.mAppsCustomizeTabHost.requestFocus();
            this.mState = State.APPS_CUSTOMIZE;
            this.mUserPresent = false;
            updateRunning();
            closeFolder();
            WindowUtil.removePip(this.pipViews, 0);
            getWindow().getDecorView().sendAccessibilityEvent(AccessibilityEvent.CONTENT_CHANGE_TYPE_PANE_DISAPPEARED);
        }
    }

    void enterSpringLoadedDragMode() {
        if (isAllAppsVisible()) {
            hideAppsCustomizeHelper(Workspace.State.SPRING_LOADED, false, true, null);
            this.mState = State.APPS_CUSTOMIZE_SPRING_LOADED;
            showHotseat(true);
        }
    }

    void exitSpringLoadedDragModeDelayed(final boolean successfulDrop, boolean extendedDelay, final Runnable onCompleteRunnable) {
        if (this.mState == State.APPS_CUSTOMIZE_SPRING_LOADED) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.70
                @Override // java.lang.Runnable
                public void run() {
                    if (successfulDrop) {
                        Launcher.this.mAppsCustomizeTabHost.setVisibility(android.view.View.GONE);
                        Launcher.this.showWorkspace(true, onCompleteRunnable);
                        Launcher.this.showHotseat(true, true);
                        return;
                    }
                    Launcher.this.exitSpringLoadedDragMode();
                }
            }, extendedDelay ? EXIT_SPRINGLOADED_MODE_LONG_TIMEOUT : 300);
        }
    }

    void exitSpringLoadedDragMode() {
        if (this.mState == State.APPS_CUSTOMIZE_SPRING_LOADED) {
            showAppsCustomizeHelper(false, true);
            this.mState = State.APPS_CUSTOMIZE;
        }
    }

    void lockAllApps() {
    }

    void unlockAllApps() {
    }

    void showHotseat(boolean animated) {
        showHotseat(animated, false);
    }

    void showHotseat(boolean animated, boolean hide) {
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_hotseat_hide) || hide) {
            if (!LauncherAppState.getInstance().isScreenLarge()) {
                if (animated) {
                    int duration = 0;
                    if (this.mSearchDropTargetBar != null) {
                        duration = this.mSearchDropTargetBar.getTransitionInDuration();
                    }
                    this.mHotseat.animate().alpha(1.0f).setDuration(duration);
                    this.mHotseat.setVisibility(android.view.View.VISIBLE);
                } else {
                    this.mHotseat.setAlpha(1.0f);
                }
            }
            if (this.mHotseat.getAlpha() != 1.0f || this.mHotseat.getVisibility() != android.view.View.VISIBLE) {
                this.mHotseat.setAlpha(1.0f);
                this.mHotseat.setVisibility(android.view.View.VISIBLE);
            }
        }
    }

    void hideHotseat(boolean animated) {
        hideHotseat(animated, false);
    }

    void hideHotseat(boolean animated, boolean hide) {
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_hotseat_hide) || hide) {
            if (!LauncherAppState.getInstance().isScreenLarge()) {
                if (animated) {
                    if (this.mHotseat.getAlpha() != 0.0f) {
                        int duration = 0;
                        if (this.mSearchDropTargetBar != null) {
                            duration = this.mSearchDropTargetBar.getTransitionOutDuration();
                        }
                        this.mHotseat.animate().alpha(0.0f).setDuration(duration);
                    }
                    this.mHotseat.setVisibility(android.view.View.GONE);
                } else {
                    this.mHotseat.setAlpha(0.0f);
                }
            }
            this.mHotseat.setVisibility(android.view.View.GONE);
        }
    }

    void addExternalItemToScreen(ItemInfo itemInfo, CellLayout layout) {
        if (!mWorkspace.addExternalItemToScreen(itemInfo, layout)) {
            showOutOfSpaceMessage(isHotseatLayout(layout));
        }
    }

    private int getCurrentOrientationIndexForGlobalIcons() {
        switch (getResources().getConfiguration().orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:
                return 1;
            default:
                return 0;
        }
    }

    private Drawable getExternalPackageToolbarIcon(ComponentName activityName, String resourceName) {
        int iconResId;
        try {
            PackageManager packageManager = getPackageManager();
            Bundle metaData = packageManager.getActivityInfo(activityName, 128).metaData;
            if (metaData != null && (iconResId = metaData.getInt(resourceName)) != 0) {
                Resources res = packageManager.getResourcesForActivity(activityName);
                return res.getDrawable(iconResId);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "Failed to load toolbar icon; " + activityName.flattenToShortString() + " not found", e);
        } catch (Resources.NotFoundException nfe) {
            Log.w(TAG, "Failed to load toolbar icon from " + activityName.flattenToShortString(), nfe);
        }
        return null;
    }

    private Drawable.ConstantState updateTextButtonWithIconFromExternalActivity(int buttonId, ComponentName activityName, int fallbackDrawableId, String toolBaresourceName) {
        Drawable toolbarIcon = getExternalPackageToolbarIcon(activityName, toolBaresourceName);
        Resources r = getResources();
        int w = r.getDimensionPixelSize(R.dimen.toolbar_external_icon_width);
        int h = r.getDimensionPixelSize(R.dimen.toolbar_external_icon_height);
        TextView button = (TextView) findViewById(buttonId);
        if (toolbarIcon == null) {
            Drawable toolbarIcon2 = r.getDrawable(fallbackDrawableId);
            toolbarIcon2.setBounds(0, 0, w, h);
            if (button == null) {
                return null;
            }
            button.setCompoundDrawables(toolbarIcon2, null, null, null);
            return null;
        }
        toolbarIcon.setBounds(0, 0, w, h);
        if (button != null) {
            button.setCompoundDrawables(toolbarIcon, null, null, null);
        }
        return toolbarIcon.getConstantState();
    }

    private Drawable.ConstantState updateButtonWithIconFromExternalActivity(int buttonId, ComponentName activityName, int fallbackDrawableId, String toolBaresourceName) {
        ImageView button = (ImageView) findViewById(buttonId);
        Drawable toolbarIcon = getExternalPackageToolbarIcon(activityName, toolBaresourceName);
        if (button != null) {
            if (toolbarIcon == null) {
                button.setImageResource(fallbackDrawableId);
            } else {
                button.setImageDrawable(toolbarIcon);
            }
        }
        if (toolbarIcon != null) {
            return toolbarIcon.getConstantState();
        }
        return null;
    }

    private void updateTextButtonWithDrawable(int buttonId, Drawable d) {
        TextView button = (TextView) findViewById(buttonId);
        button.setCompoundDrawables(d, null, null, null);
    }

    private void updateButtonWithDrawable(int buttonId, Drawable.ConstantState d) {
        ImageView button = (ImageView) findViewById(buttonId);
        button.setImageDrawable(d.newDrawable(getResources()));
    }

    private void invalidatePressedFocusedStates(View container, View button) {
        if (container instanceof HolographicLinearLayout) {
            HolographicLinearLayout layout = (HolographicLinearLayout) container;
            layout.invalidatePressedFocusedStates();
        } else if (button instanceof HolographicImageView) {
            HolographicImageView view = (HolographicImageView) button;
            view.invalidatePressedFocusedStates();
        }
    }

    public View getQsbBar() {
        if (this.mQsbBar == null) {
            this.mQsbBar = this.mInflater.inflate(R.layout.search_bar, (ViewGroup) this.mSearchDropTargetBar, false);
            if (this.mSearchDropTargetBar != null) {
                this.mSearchDropTargetBar.addView(this.mQsbBar);
            }
        }
        return this.mQsbBar;
    }

    protected boolean updateGlobalSearchIcon() {
        View searchButtonContainer = findViewById(R.id.search_button_container);
        ImageView searchButton = (ImageView) findViewById(R.id.search_button);
        View voiceButtonContainer = findViewById(R.id.voice_button_container);
        View voiceButton = findViewById(R.id.voice_button);
        SearchManager searchManager = (SearchManager) getSystemService(android.content.Context.SEARCH_SERVICE);
        searchManager.getGlobalSearchActivity();
        if (searchButtonContainer != null) {
            searchButtonContainer.setVisibility(View.GONE);
        }
        if (voiceButtonContainer != null) {
            voiceButtonContainer.setVisibility(android.view.View.GONE);
        }
        if (searchButton != null) {
            searchButton.setVisibility(android.view.View.GONE);
        }
        if (voiceButton != null) {
            voiceButton.setVisibility(android.view.View.GONE);
        }
        updateVoiceButtonProxyVisible(false);
        return false;
    }

    protected void updateGlobalSearchIcon(Drawable.ConstantState d) {
        View searchButtonContainer = findViewById(R.id.search_button_container);
        View searchButton = (ImageView) findViewById(R.id.search_button);
        updateButtonWithDrawable(R.id.search_button, d);
        invalidatePressedFocusedStates(searchButtonContainer, searchButton);
    }

    protected boolean updateVoiceSearchIcon(boolean searchVisible) {
        View voiceButtonContainer = findViewById(R.id.voice_button_container);
        View voiceButton = findViewById(R.id.voice_button);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        ComponentName globalSearchActivity = searchManager.getGlobalSearchActivity();
        ComponentName activityName = null;
        if (globalSearchActivity != null) {
            Intent intent = new Intent("android.speech.action.WEB_SEARCH");
            intent.setPackage(globalSearchActivity.getPackageName());
            activityName = intent.resolveActivity(getPackageManager());
        }
        if (activityName == null) {
            activityName = new Intent("android.speech.action.WEB_SEARCH").resolveActivity(getPackageManager());
        }
        if (searchVisible && activityName != null) {
            int coi = getCurrentOrientationIndexForGlobalIcons();
            sVoiceSearchIcon[coi] = updateButtonWithIconFromExternalActivity(R.id.voice_button, activityName, R.drawable.ic_home_voice_search_holo, TOOLBAR_VOICE_SEARCH_ICON_METADATA_NAME);
            if (sVoiceSearchIcon[coi] == null) {
                sVoiceSearchIcon[coi] = updateButtonWithIconFromExternalActivity(R.id.voice_button, activityName, R.drawable.ic_home_voice_search_holo, TOOLBAR_ICON_METADATA_NAME);
            }
            if (voiceButtonContainer != null) {
                voiceButtonContainer.setVisibility(android.view.View.VISIBLE);
            }
            voiceButton.setVisibility(android.view.View.VISIBLE);
            updateVoiceButtonProxyVisible(false);
            invalidatePressedFocusedStates(voiceButtonContainer, voiceButton);
            return true;
        }
        if (voiceButtonContainer != null) {
            voiceButtonContainer.setVisibility(android.view.View.GONE);
        }
        if (voiceButton != null) {
            voiceButton.setVisibility(android.view.View.GONE);
        }
        updateVoiceButtonProxyVisible(false);
        return false;
    }

    protected void updateVoiceSearchIcon(Drawable.ConstantState d) {
        View voiceButtonContainer = findViewById(R.id.voice_button_container);
        View voiceButton = findViewById(R.id.voice_button);
        updateButtonWithDrawable(R.id.voice_button, d);
        invalidatePressedFocusedStates(voiceButtonContainer, voiceButton);
    }

    public void updateVoiceButtonProxyVisible(boolean forceDisableVoiceButtonProxy) {
        View voiceButtonProxy = findViewById(R.id.voice_button_proxy);
        if (voiceButtonProxy != null) {
            boolean visible = !forceDisableVoiceButtonProxy && mWorkspace.shouldVoiceButtonProxyBeVisible();
            voiceButtonProxy.setVisibility(visible ? android.view.View.VISIBLE : android.view.View.GONE);
            voiceButtonProxy.bringToFront();
        }
    }

    public void disableVoiceButtonProxy(boolean disabled) {
        updateVoiceButtonProxyVisible(disabled);
    }

    private void updateAppMarketIcon() {
    }

    private void updateAppMarketIcon(Drawable.ConstantState d) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        boolean result = super.dispatchPopulateAccessibilityEvent(event);
        List<CharSequence> text = event.getText();
        text.clear();
        if (this.mState == State.APPS_CUSTOMIZE) {
            text.add(this.mAppsCustomizeTabHost.getCurrentTabView().getContentDescription());
        } else {
            text.add(getString(R.string.all_apps_home_button_label));
        }
        return result;
    }

    private class CloseSystemDialogsIntentReceiver extends BroadcastReceiver {
        private CloseSystemDialogsIntentReceiver() {
        }

        /* synthetic */ CloseSystemDialogsIntentReceiver(Launcher launcher, CloseSystemDialogsIntentReceiver closeSystemDialogsIntentReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d("LZP", "CloseSystemDialogsIntentReceiver");
            Intent i = new Intent();
            i.setAction("android.intent.action.MAIN");
            i.addCategory("android.intent.category.HOME");
            if (Launcher.this.getPackageManager().resolveActivity(i, PackageManager.MATCH_DEFAULT_ONLY).activityInfo.packageName.equals(Launcher.this.getPackageName())) {
                if ("com.lsec.tyz.action.voice.launcher".equals(intent.getAction())) {
                    WindowUtil.removePip(null);
                    return;
                } else {
                    if (!"FOURCAMERA2_BROADCAST_SEND".equals(intent.getAction()) && "com.lsec.pipdie".equals(intent.getAction()) && WindowUtil.visible && CarStates.mAccState == 1) {
                        new Thread(new Runnable() { // from class: com.android.launcher66.Launcher.CloseSystemDialogsIntentReceiver.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Intent i2 = FytPackage.getIntent(Launcher.getLauncher(), WindowUtil.AppPackageName);
                                SystemProperties.set("sys.lsec.force_pip", "true");
                                i2.putExtra("force_pip", true);
                                Log.i("mql", "--- com.lsec.pipdie");
                                Launcher.mLauncher.startActivity(i2);
                                if (WindowUtil.AppPackageName.equals("com.syu.camera360")) {
                                    Launcher.mLauncher.sendBroadcast(new Intent("com.syu.camera360.show"));
                                }
                            }
                        }).start();
                        return;
                    }
                    return;
                }
            }
            Launcher.this.closeSystemDialogs();
        }
    }

    private class AppWidgetResetObserver extends ContentObserver {
        public AppWidgetResetObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            Launcher.this.onAppWidgetReset();
        }
    }

    private boolean waitUntilResume(Runnable run, boolean deletePreviousRunnables) {
        if (!this.mPaused) {
            return false;
        }
        Log.i(TAG, "Deferring update until onResume");
        if (deletePreviousRunnables) {
            while (this.mBindOnResumeCallbacks.remove(run)) {
            }
        }
        this.mBindOnResumeCallbacks.add(run);
        return true;
    }

    private boolean waitUntilResume(Runnable run) {
        return waitUntilResume(run, false);
    }

    public void addOnResumeCallback(Runnable run) {
        this.mOnResumeCallbacks.add(run);
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public boolean setLoadOnResume() {
        if (!this.mPaused) {
            return false;
        }
        Log.i(TAG, "setLoadOnResume");
        this.mOnResumeNeedsLoad = true;
        return true;
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public int getCurrentWorkspaceScreen() {
        if (mWorkspace != null) {
            return mWorkspace.getCurrentPage();
        }
        return 2;
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void startBinding() {
        this.mBindOnResumeCallbacks.clear();
        mWorkspace.clearDropTargets();
        mWorkspace.removeAllWorkspaceScreens();
        this.mWidgetsToAdvance.clear();
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindScreens(ArrayList<Long> orderedScreenIds) {
        bindAddScreens(orderedScreenIds);
        Log.d("LZP", "bindScreens");
        if (orderedScreenIds.size() == 0 && LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_add_extarscreen)) {
            mWorkspace.addExtraEmptyScreen();
        }
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_custom_page) && !mWorkspace.hasMyCustomContent()) {
            mWorkspace.createUserPage();
            initViews();
            bindOnclickListener();
        }
        if (!mWorkspace.hasCustomContent() && hasCustomContentToLeft()) {
            mWorkspace.createCustomContentPage();
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindAddScreens(ArrayList<Long> orderedScreenIds) {
        Log.d("LZP", "bindAddScreens");
        int count2 = orderedScreenIds.size();
        for (int i = 0; i < count2; i++) {
            mWorkspace.insertNewWorkspaceScreenBeforeEmptyScreen(orderedScreenIds.get(i).longValue());
        }
    }

    private boolean shouldShowWeightWatcher() {
        String spKey = LauncherAppState.getSharedPreferencesKey();
        SharedPreferences sp = getSharedPreferences(spKey, 0);
        boolean show = sp.getBoolean(SHOW_WEIGHT_WATCHER, false);
        return show;
    }

    private void toggleShowWeightWatcher() {
        String spKey = LauncherAppState.getSharedPreferencesKey();
        SharedPreferences sp = getSharedPreferences(spKey, 0);
        boolean show = !sp.getBoolean(SHOW_WEIGHT_WATCHER, true);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(SHOW_WEIGHT_WATCHER, show);
        editor.commit();
        if (this.mWeightWatcher != null) {
            this.mWeightWatcher.setVisibility(show ? android.view.View.VISIBLE : android.view.View.GONE);
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindAppsAdded(final ArrayList<Long> newScreens, final ArrayList<ItemInfo> addNotAnimated, final ArrayList<ItemInfo> addAnimated, final ArrayList<AppInfo> addedApps) {
        Log.d("LZP", "bindAppsAdded");
        Runnable r = new Runnable() { // from class: com.android.launcher66.Launcher.71
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.bindAppsAdded(newScreens, addNotAnimated, addAnimated, addedApps);
            }
        };
        if (!waitUntilResume(r)) {
            bindAddScreens(newScreens);
            if (!addNotAnimated.isEmpty()) {
                bindItems(addNotAnimated, 0, addNotAnimated.size(), false);
            }
            if (!addAnimated.isEmpty()) {
                bindItems(addAnimated, 0, addAnimated.size(), true);
            }
            mWorkspace.removeExtraEmptyScreen();
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && addedApps != null && this.mAppsCustomizeContent != null) {
                this.mAppsCustomizeContent.addApps(addedApps);
            }
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindItems(final ArrayList<ItemInfo> shortcuts, final int start, final int end, final boolean forceAnimateIcons) {
        CellLayout cl;
        Log.d("LZP", "bindItems");
        Runnable r = new Runnable() { // from class: com.android.launcher66.Launcher.72
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.bindItems(shortcuts, start, end, forceAnimateIcons);
            }
        };
        JLog.getInstance().e("Launcher bindItems");
        if (!waitUntilResume(r)) {
            final AnimatorSet anim = LauncherAnimUtils.createAnimatorSet();
            final Collection<Animator> bounceAnims = new ArrayList<>();
            boolean animateIcons = forceAnimateIcons && canRunNewAppsAnimation();
            Workspace workspace = mWorkspace;
            long newShortcutsScreenId = -1;
            for (int i = start; i < end; i++) {
                ItemInfo item = shortcuts.get(i);
                if ((item.container != -101 || getResources().getBoolean(R.bool.hotseat_load_defualt_workspace)) && (item.container != -101 || this.mHotseat != null)) {
                    switch (item.itemType) {
                        case 0:
                        case 1:
                            ShortcutInfo info = (ShortcutInfo) item;
                            View shortcut = createShortcut(info);
                            if (item.container == -100 && (cl = mWorkspace.getScreenWithId(item.screenId)) != null && cl.isOccupied(item.cellX, item.cellY)) {
                                throw new RuntimeException("OCCUPIED");
                            }
                            workspace.addInScreenFromBind(shortcut, item.container, item.screenId, item.cellX, item.cellY, 1, 1);
                            if (animateIcons) {
                                shortcut.setAlpha(0.0f);
                                shortcut.setScaleX(0.0f);
                                shortcut.setScaleY(0.0f);
                                bounceAnims.add(createNewAppBounceAnimation(shortcut, i));
                                newShortcutsScreenId = item.screenId;
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            FolderIcon newFolder = FolderIcon.fromXml(R.layout.folder_icon, this, (ViewGroup) workspace.getChildAt(workspace.getCurrentPage()), (FolderInfo) item, this.mIconCache);
                            workspace.addInScreenFromBind(newFolder, item.container, item.screenId, item.cellX, item.cellY, 1, 1);
                            break;
                        default:
                            throw new RuntimeException("Invalid Item Type");
                    }
                }
            }
            if (animateIcons && newShortcutsScreenId > -1) {
                long currentScreenId = mWorkspace.getScreenIdForPageIndex(mWorkspace.getNextPage());
                final int newScreenIndex = mWorkspace.getPageIndexForScreenId(newShortcutsScreenId);
                final Runnable startBounceAnimRunnable = new Runnable() { // from class: com.android.launcher66.Launcher.73
                    @Override // java.lang.Runnable
                    public void run() {
                        anim.playTogether(bounceAnims);
                        anim.start();
                    }
                };
                if (newShortcutsScreenId != currentScreenId) {
                    mWorkspace.postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.74
                        @Override // java.lang.Runnable
                        public void run() {
                            Launcher.mWorkspace.snapToPage(newScreenIndex);
                            Launcher.mWorkspace.postDelayed(startBounceAnimRunnable, Launcher.NEW_APPS_ANIMATION_DELAY);
                        }
                    }, NEW_APPS_PAGE_MOVE_DELAY);
                } else {
                    mWorkspace.postDelayed(startBounceAnimRunnable, NEW_APPS_ANIMATION_DELAY);
                }
            }
            workspace.requestLayout();
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindFolders(final HashMap<Long, FolderInfo> folders) {
        Runnable r = new Runnable() { // from class: com.android.launcher66.Launcher.75
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.bindFolders(folders);
            }
        };
        if (!waitUntilResume(r)) {
            sFolders.clear();
            sFolders.putAll(folders);
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindAppWidget(final LauncherAppWidgetInfo item) {
        Runnable r = new Runnable() { // from class: com.android.launcher66.Launcher.76
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.bindAppWidget(item);
            }
        };
        if (!waitUntilResume(r)) {
            long start = SystemClock.uptimeMillis();
            Log.d(TAG, "bindAppWidget: " + item);
            Workspace workspace = mWorkspace;
            int appWidgetId = item.appWidgetId;
            AppWidgetProviderInfo appWidgetInfo = this.mAppWidgetManager.getAppWidgetInfo(appWidgetId);
            Log.d(TAG, "bindAppWidget: id=" + item.appWidgetId + " belongs to component " + appWidgetInfo.provider);
            item.hostView = this.mAppWidgetHost.createView(this, appWidgetId, appWidgetInfo);
            item.hostView.setTag(item);
            item.onBindAppWidget(this);
            workspace.addInScreen(item.hostView, item.container, item.screenId, item.cellX, item.cellY, item.spanX, item.spanY, false);
            addWidgetToAutoAdvanceIfNeeded(item.hostView, appWidgetInfo);
            workspace.requestLayout();
            Log.d(TAG, "bound widget id=" + item.appWidgetId + " in " + (SystemClock.uptimeMillis() - start) + "ms");
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void onPageBoundSynchronously(int page) {
        this.mSynchronouslyBoundPages.add(Integer.valueOf(page));
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void finishBindingItems(final boolean upgradePath) {
        Log.d("LZP", "finishBindingItems");
        Runnable r = new Runnable() { // from class: com.android.launcher66.Launcher.77
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.finishBindingItems(upgradePath);
            }
        };
        if (!waitUntilResume(r)) {
            if (this.mSavedState != null) {
                if (!mWorkspace.hasFocus()) {
                    mWorkspace.getChildAt(mWorkspace.getCurrentPage()).requestFocus();
                }
                this.mSavedState = null;
            }
            mWorkspace.restoreInstanceStateForRemainingPages();
            for (int i = 0; i < sPendingAddList.size(); i++) {
                completeAdd(sPendingAddList.get(i));
            }
            sPendingAddList.clear();
            this.mWorkspaceLoading = false;
            if (upgradePath) {
                mWorkspace.getUniqueComponents(true, null);
                mIntentsOnWorkspaceFromUpgradePath = mWorkspace.getUniqueComponents(true, null);
            }
            mWorkspace.post(new Runnable() { // from class: com.android.launcher66.Launcher.78
                @Override // java.lang.Runnable
                public void run() {
                    Launcher.this.onFinishBindingItems();
                }
            });
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public boolean isAllAppsButtonRank(int rank) {
        if (this.mHotseat != null) {
        }
        return false;
    }

    private boolean canRunNewAppsAnimation() {
        long diff = System.currentTimeMillis() - this.mDragController.getLastGestureUpTime();
        return diff > ((long) (NEW_APPS_ANIMATION_INACTIVE_TIMEOUT_SECONDS * 1000));
    }

    private ValueAnimator createNewAppBounceAnimation(View v, int i) {
        ValueAnimator bounceAnim = LauncherAnimUtils.ofPropertyValuesHolder(v, PropertyValuesHolder.ofFloat("alpha", 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        bounceAnim.setDuration(450L);
        bounceAnim.setStartDelay(i * 85);
        bounceAnim.setInterpolator(new SmoothPagedView.OvershootInterpolator());
        return bounceAnim;
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindSearchablesChanged() {
        boolean searchVisible = updateGlobalSearchIcon();
        boolean voiceVisible = updateVoiceSearchIcon(searchVisible);
        if (this.mSearchDropTargetBar != null) {
            this.mSearchDropTargetBar.onSearchPackagesChanged(searchVisible, voiceVisible);
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindAllApplications(ArrayList<AppInfo> apps) {
        Log.d("LZP", "bindAllApplications");
        initAppData();
        if (AppsCustomizePagedView.DISABLE_ALL_APPS) {
            if (mIntentsOnWorkspaceFromUpgradePath != null) {
                mIntentsOnWorkspaceFromUpgradePath = null;
            }
        } else if (this.mAppsCustomizeContent != null) {
            this.mAppsCustomizeContent.setApps(apps);
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindAppsUpdated(final ArrayList<AppInfo> apps) {
        Log.d("LZP", "bindAppsUpdated");
        Runnable r = new Runnable() { // from class: com.android.launcher66.Launcher.79
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.bindAppsUpdated(apps);
            }
        };
        if (!waitUntilResume(r)) {
            if (mWorkspace != null) {
                mWorkspace.updateShortcuts(apps);
            }
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && this.mAppsCustomizeContent != null) {
                this.mAppsCustomizeContent.updateApps(apps);
            }
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindComponentsRemoved(final ArrayList<String> packageNames, final ArrayList<AppInfo> appInfos, final boolean packageRemoved) {
        Runnable r = new Runnable() { // from class: com.android.launcher66.Launcher.80
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.bindComponentsRemoved(packageNames, appInfos, packageRemoved);
            }
        };
        if (!waitUntilResume(r)) {
            if (packageRemoved) {
                mWorkspace.removeItemsByPackageName(packageNames);
            } else {
                mWorkspace.removeItemsByApplicationInfo(appInfos);
            }
            this.mDragController.onAppsRemoved(appInfos, this);
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && this.mAppsCustomizeContent != null) {
                this.mAppsCustomizeContent.removeApps(appInfos);
            }
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void bindPackagesUpdated(ArrayList<Object> widgetsAndShortcuts) {
        if (waitUntilResume(this.mBindPackagesUpdatedRunnable, true)) {
            this.mWidgetsAndShortcuts = widgetsAndShortcuts;
        } else if (!AppsCustomizePagedView.DISABLE_ALL_APPS && this.mAppsCustomizeContent != null) {
            this.mAppsCustomizeContent.onPackagesUpdated(widgetsAndShortcuts);
        }
    }

    private int mapConfigurationOriActivityInfoOri(int configOri) {
        Display d = getWindowManager().getDefaultDisplay();
        int naturalOri = 2;
        switch (d.getRotation()) {
            case Surface.ROTATION_0:
            case Surface.ROTATION_180:
                naturalOri = configOri;
                break;
            case Surface.ROTATION_90:
            case Surface.ROTATION_270:
                if (configOri != 2) {
                    naturalOri = 2;
                    break;
                } else {
                    naturalOri = 1;
                    break;
                }
        }
        int[] oriMap = {1, 0, 9, 8};
        int indexOffset = 0;
        if (naturalOri == 2) {
            indexOffset = 1;
        }
        return oriMap[(d.getRotation() + indexOffset) % 4];
    }

    public boolean isRotationEnabled() {
        return sForceEnableRotation || getResources().getBoolean(R.bool.allow_rotation);
    }

    public void lockScreenOrientation() {
        if (isRotationEnabled()) {
            setRequestedOrientation(mapConfigurationOriActivityInfoOri(getResources().getConfiguration().orientation));
        }
    }

    public void unlockScreenOrientation(boolean immediate) {
        if (isRotationEnabled()) {
            if (immediate) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.android.launcher66.Launcher.81
                    @Override // java.lang.Runnable
                    public void run() {
                        Launcher.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                    }
                }, 500L);
            }
        }
    }

    private boolean isClingsEnabled() {
        return false;
    }

    private Cling initCling(int clingId, int scrimId, boolean animate, boolean dimNavBarVisibilty) {
        Cling cling = (Cling) findViewById(clingId);
        View scrim = null;
        if (scrimId > 0) {
            scrim = findViewById(R.id.cling_scrim);
        }
        if (cling != null) {
            cling.init(this, scrim);
            cling.show(animate, 250);
            if (dimNavBarVisibilty) {
                cling.setSystemUiVisibility(cling.getSystemUiVisibility() | 1);
            }
        }
        return cling;
    }

    public void dismissClingApp(final Cling cling, final Runnable postAnimationCb, final Intent intent, int duration, boolean restoreNavBarVisibilty) {
        if (cling != null && cling.getVisibility() != View.GONE) {
            final Runnable cleanUpClingCb = new Runnable() { 
                public void run() {
                    cling.cleanup();
                    final Intent intent2 = intent;
                    new Thread("dismissClingThread") { // from class: com.android.launcher66.Launcher.82.1
                        public void run() {
                            if (intent2.getComponent().getPackageName().equals("com.syu.music")) {
                                int a = SystemProperties.getInt("persist.sys.clingmusic", 0);
                                String value = new StringBuilder(String.valueOf(a + 1)).toString();
                                LogPreview.show("dismissClingApp" + value);
                                SystemProperties.set("persist.sys.clingmusic", value);
                                return;
                            }
                            if (intent2.getComponent().getPackageName().equals("com.syu.video")) {
                                int a2 = SystemProperties.getInt("persist.sys.clingvideo", 0);
                                String value2 = new StringBuilder(String.valueOf(a2 + 1)).toString();
                                LogPreview.show("dismissClingAppvideo" + value2);
                                SystemProperties.set("persist.sys.clingvideo", value2);
                                return;
                            }
                            if (intent2.getComponent().getPackageName().equals(FytPackage.GaodeACTION)) {
                                int a3 = SystemProperties.getInt("persist.sys.clinggaode", 0);
                                String value3 = new StringBuilder(String.valueOf(a3 + 1)).toString();
                                SystemProperties.set("persist.sys.clinggaode", value3);
                                return;
                            }
                            if (intent2.getComponent().getPackageName().equals("com.syu.radio")) {
                                int a4 = SystemProperties.getInt("persist.sys.clingradio", 0);
                                String value4 = new StringBuilder(String.valueOf(a4 + 1)).toString();
                                SystemProperties.set("persist.sys.clingradio", value4);
                                return;
                            }
                            if (intent2.getComponent().getPackageName().equals("com.syu.bt")) {
                                int a5 = SystemProperties.getInt("persist.sys.clingbt", 0);
                                String value5 = new StringBuilder(String.valueOf(a5 + 1)).toString();
                                SystemProperties.set("persist.sys.clingbt", value5);
                            } else if (intent2.getComponent().getPackageName().equals(FytPackage.KWACTION)) {
                                int a6 = SystemProperties.getInt("persist.sys.clingkuwo", 0);
                                String value6 = new StringBuilder(String.valueOf(a6 + 1)).toString();
                                SystemProperties.set("persist.sys.clingkuwo", value6);
                            } else if (intent2.getComponent().getPackageName().equals(FytPackage.KLFMACTION)) {
                                int a7 = SystemProperties.getInt("persist.sys.clingkaola", 0);
                                String value7 = new StringBuilder(String.valueOf(a7 + 1)).toString();
                                SystemProperties.set("persist.sys.clingkaola", value7);
                            }
                        }
                    }.start();
                    if (postAnimationCb != null) {
                        postAnimationCb.run();
                    }
                }
            };
            if (duration <= 0) {
                cleanUpClingCb.run();
            } else {
                cling.hide(duration, cleanUpClingCb);
            }
            mHideFromAccessibilityHelper.restoreImportantForAccessibility(mDragLayer);

            if (restoreNavBarVisibilty) {
                cling.setSystemUiVisibility(cling.getSystemUiVisibility() &
                        ~View.SYSTEM_UI_FLAG_LOW_PROFILE);
            }
        }
    }

    private void dismissCling(final Cling cling, final Runnable postAnimationCb,
                              final String flag, int duration, boolean restoreNavBarVisibilty) {
        // To catch cases where siblings of top-level views are made invisible, just check whether
        // the cling is directly set to GONE before dismissing it.
        if (cling != null && cling.getVisibility() != View.GONE) {
            final Runnable cleanUpClingCb = new Runnable() {
                public void run() {
                    cling.cleanup();
                    // We should update the shared preferences on a background thread
                    new Thread("dismissClingThread") {
                        public void run() {
                            SharedPreferences.Editor editor = mSharedPrefs.edit();
                            editor.putBoolean(flag, true);
                            editor.commit();
                        }
                    }.start();
                    if (postAnimationCb != null) {
                        postAnimationCb.run();
                    }
                }
            };
            if (duration <= 0) {
                cleanUpClingCb.run();
            } else {
                cling.hide(duration, cleanUpClingCb);
            }
            mHideFromAccessibilityHelper.restoreImportantForAccessibility(mDragLayer);

            if (restoreNavBarVisibilty) {
                cling.setSystemUiVisibility(cling.getSystemUiVisibility() &
                        ~View.SYSTEM_UI_FLAG_LOW_PROFILE);
            }
        }
    }

    private void removeCling(int id) {
        final View cling = findViewById(id);
        if (cling != null) {
            final ViewGroup parent = (ViewGroup) cling.getParent();
            parent.post(new Runnable() { // from class: com.android.launcher66.Launcher.84
                @Override // java.lang.Runnable
                public void run() {
                    parent.removeView(cling);
                }
            });
            this.mHideFromAccessibilityHelper.restoreImportantForAccessibility(this.mDragLayer);
        }
    }

    private boolean skipCustomClingIfNoAccounts() {
        AccountManager am;
        Cling cling = (Cling) findViewById(R.id.workspace_cling);
        boolean customCling = cling.getDrawIdentifier().equals("workspace_custom");
        if (!customCling || (am = AccountManager.get(this)) == null) {
            return false;
        }
        Account[] accounts = am.getAccountsByType("com.google");
        return accounts.length == 0;
    }

    public void updateCustomContentHintVisibility() {
        Cling cling = (Cling) findViewById(R.id.first_run_cling);
        String ccHintStr = getFirstRunCustomContentHint();
        if (mWorkspace.hasCustomContent()) {
            if (cling != null) {
                setCustomContentHintVisibility(cling, ccHintStr, true, true);
            }
        } else if (cling != null) {
            setCustomContentHintVisibility(cling, ccHintStr, false, true);
        }
    }

    private void setCustomContentHintVisibility(Cling cling, String ccHintStr, boolean visible, boolean animate) {
        final TextView ccHint = (TextView) cling.findViewById(R.id.custom_content_hint);
        if (ccHint != null) {
            if (visible && !ccHintStr.isEmpty()) {
                ccHint.setText(ccHintStr);
                ccHint.setVisibility(android.view.View.VISIBLE);
                if (animate) {
                    ccHint.setAlpha(0.0f);
                    ccHint.animate().alpha(1.0f).setDuration(250L).start();
                    return;
                } else {
                    ccHint.setAlpha(1.0f);
                    return;
                }
            }
            if (animate) {
                ccHint.animate().alpha(0.0f).setDuration(250L).setListener(new AnimatorListenerAdapter() { // from class: com.android.launcher66.Launcher.85
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ccHint.setVisibility(android.view.View.GONE);
                    }
                }).start();
            } else {
                ccHint.setAlpha(0.0f);
                ccHint.setVisibility(android.view.View.GONE);
            }
        }
    }

    public void showFirstRunCling() {
        if (isClingsEnabled() && !this.mSharedPrefs.getBoolean("cling_gel.first_run.dismissed", false) && !skipCustomClingIfNoAccounts()) {
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.isdefaultwallpaper)) {
                setDefaultWallpaper();
            }
            Cling cling = (Cling) findViewById(R.id.first_run_cling);
            if (cling != null) {
                String sbHintStr = getFirstRunClingSearchBarHint();
                String ccHintStr = getFirstRunCustomContentHint();
                if (!sbHintStr.isEmpty()) {
                    TextView sbHint = (TextView) cling.findViewById(R.id.search_bar_hint);
                    sbHint.setText(sbHintStr);
                    sbHint.setVisibility(android.view.View.VISIBLE);
                }
                setCustomContentHintVisibility(cling, ccHintStr, true, false);
            }
            initCling(R.id.first_run_cling, 0, false, true);
            return;
        }
        removeCling(R.id.first_run_cling);
    }

    protected String getFirstRunClingSearchBarHint() {
        return "";
    }

    protected String getFirstRunCustomContentHint() {
        return "";
    }

    protected int getFirstRunFocusedHotseatAppDrawableId() {
        return -1;
    }

    protected ComponentName getFirstRunFocusedHotseatAppComponentName() {
        return null;
    }

    protected int getFirstRunFocusedHotseatAppRank() {
        return -1;
    }

    protected String getFirstRunFocusedHotseatAppBubbleTitle() {
        return "";
    }

    protected String getFirstRunFocusedHotseatAppBubbleDescription() {
        return "";
    }

    public void showClickappCling() {
        if (ResValue.getInstance().clickapp_cling > 0) {
            Cling c = initCling(ResValue.getInstance().clickapp_cling, 0, false, true);
            c.setFocusedHotseatApp(getFirstRunFocusedHotseatAppDrawableId(), getFirstRunFocusedHotseatAppRank(), getFirstRunFocusedHotseatAppComponentName(), getFirstRunFocusedHotseatAppBubbleTitle(), getFirstRunFocusedHotseatAppBubbleDescription());
        }
    }

    public void showFirstRunWorkspaceCling() {
        if (isClingsEnabled() && !this.mSharedPrefs.getBoolean("cling_gel.workspace.dismissed", false)) {
            Cling c = initCling(R.id.workspace_cling, 0, false, true);
            c.setFocusedHotseatApp(getFirstRunFocusedHotseatAppDrawableId(), getFirstRunFocusedHotseatAppRank(), getFirstRunFocusedHotseatAppComponentName(), getFirstRunFocusedHotseatAppBubbleTitle(), getFirstRunFocusedHotseatAppBubbleDescription());
        } else {
            removeCling(R.id.workspace_cling);
        }
    }

    public void setDefaultWallpaper() {
        WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());
        LauncherApplication.mAppWallPaper = true;
        SharedPreferences.Editor editor = Utils.getSp().edit();
        editor.putBoolean("mAppWallPaper", LauncherApplication.mAppWallPaper);
        editor.commit();
        try {
            if (ResValue.getInstance().def_bg != 0) {
                wm.setResource(ResValue.getInstance().def_bg);
            } else if (ResValue.getInstance().fyt_home_bk_00 != 0) {
                wm.setResource(ResValue.getInstance().fyt_home_bk_00);
            } else if (ResValue.getInstance().fyt_home_bk_01 != 0) {
                wm.setResource(ResValue.getInstance().fyt_home_bk_01);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultWallpaper(String resName) {
        if (LauncherApplication.mWallPaperUpdate) {
            try {
                LauncherApplication.mAppWallPaper = true;
                SharedPreferences.Editor editor = Utils.getSp().edit();
                editor.putBoolean("mAppWallPaper", LauncherApplication.mAppWallPaper);
                editor.commit();
                WallpaperManager wm = WallpaperManager.getInstance(getApplicationContext());
                int resid = getResources().getIdentifier(resName, "drawable", getPackageName());
                wm.setStream(new BufferedInputStream(getResources().openRawResource(resid)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Cling showFirstRunFoldersCling() {
        if (isClingsEnabled() && !this.mSharedPrefs.getBoolean("cling_gel.folder.dismissed", false)) {
            return initCling(R.id.folder_cling, R.id.cling_scrim, true, true);
        }
        removeCling(R.id.folder_cling);
        return null;
    }

    protected SharedPreferences getSharedPrefs() {
        return this.mSharedPrefs;
    }

    public boolean isFolderClingVisible() {
        Cling cling = (Cling) findViewById(R.id.folder_cling);
        return cling != null && cling.getVisibility() == android.view.View.VISIBLE;
    }

    public void dismissFirstRunCling(View v) {
        Cling cling = (Cling) findViewById(R.id.first_run_cling);
        Runnable cb = new Runnable() { // from class: com.android.launcher66.Launcher.86
            @Override // java.lang.Runnable
            public void run() {
                Launcher.this.showFirstRunWorkspaceCling();
            }
        };
        dismissCling(cling, cb, "cling_gel.first_run.dismissed", 200, false);
        this.mSearchDropTargetBar.hideSearchBar(true);
    }

    public void dismissWorkspaceCling(View v) {
        Cling cling = (Cling) findViewById(R.id.workspace_cling);
        Runnable cb = null;
        if (v == null) {
            cb = new Runnable() { // from class: com.android.launcher66.Launcher.87
                @Override // java.lang.Runnable
                public void run() {
                    Launcher.mWorkspace.enterOverviewMode();
                }
            };
        }
        dismissCling(cling, cb, "cling_gel.workspace.dismissed", 200, true);
        this.mSearchDropTargetBar.showSearchBar(true);
    }

    public void dismissFolderCling(View v) {
        Cling cling = (Cling) findViewById(R.id.folder_cling);
        dismissCling(cling, null, "cling_gel.folder.dismissed", 200, true);
    }

    public void dumpState() {
        Log.d(TAG, "BEGIN launcher3 dump state for launcher " + this);
        Log.d(TAG, "mSavedState=" + this.mSavedState);
        Log.d(TAG, "mWorkspaceLoading=" + this.mWorkspaceLoading);
        Log.d(TAG, "mRestoring=" + this.mRestoring);
        Log.d(TAG, "mWaitingForResult=" + this.mWaitingForResult);
        Log.d(TAG, "mSavedInstanceState=" + this.mSavedInstanceState);
        Log.d(TAG, "sFolders.size=" + sFolders.size());
        mModel.dumpState();
        if (this.mAppsCustomizeContent != null) {
            this.mAppsCustomizeContent.dumpState();
        }
        Log.d(TAG, "END launcher3 dump state");
    }

    public void appTextVisible(boolean visible) {
        if (this.mHotseatApps != null) {
            this.mHotseatApps.setVisibility(visible ? android.view.View.VISIBLE : android.view.View.INVISIBLE);
        }
    }

    @Override // android.app.Activity
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        synchronized (sDumpLogs) {
            writer.println(" ");
            writer.println("Debug logs: ");
            for (int i = 0; i < sDumpLogs.size(); i++) {
                writer.println("  " + sDumpLogs.get(i));
            }
        }
    }

    public static void dumpDebugLogsToConsole() {
    }

    public static void addDumpLog(String tag, String log, boolean debugLog) {
        if (debugLog) {
            Log.d(tag, log);
        }
    }

    @Override // com.android.launcher66.LauncherModel.Callbacks
    public void dumpLogsToLocalData() {
    }

    @Override // java.util.Observer
    public void update(Observable arg0, Object arg1) {
        Widget.widgetUpdate(LauncherApplication.sApp, DateTimeProvider.class);
        Widget.widgetUpdate(LauncherApplication.sApp, DateMusicProvider.class);
    }
}
