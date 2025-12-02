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
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.SearchManager;
import android.app.Service;
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
import android.content.pm.ApplicationInfo;
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
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.Selection;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.text.style.RelativeSizeSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
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
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Advanceable;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.async.AsyncTask;
import com.android.launcher66.settings.CanbusAsyncTask;
import com.android.launcher66.settings.CanbusService;
import com.android.launcher66.settings.Helpers;
import com.android.launcher66.settings.Keys;
import com.android.launcher66.settings.MainViewModel;
import com.android.launcher66.settings.NightModeService;
import com.android.launcher66.settings.SettingsActivity;
import com.android.launcher66.settings.WakeDetectionService;
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
import com.google.android.gms.location.FusedLocationProviderClient;
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

import org.litepal.LitePal;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import cn.kuwo.autosdk.api.KWAPI;
import cn.kuwo.autosdk.api.OnPlayerStatusListener;
import cn.kuwo.autosdk.api.PlayState;
import cn.kuwo.autosdk.api.PlayerStatus;
import cn.kuwo.autosdk.bean.Music;
import share.Config;
import share.ResValue;
import share.ShareHandler;

public class Launcher extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, LauncherModel.Callbacks, View.OnTouchListener, PropertyChangeListener, LauncherAppWidgetHost.OnWidgetClickListener {
    private ViewTreeObserver.OnDrawListener onDrawListener;
    private static final int MAX_LEFT = 5;
    static final boolean DEBUG_RESUME_TIME = false;
    static final boolean DEBUG_WIDGETS = true;
    static final String DUMP_STATE_PROPERTY = "launcher_dump_state";
    private static final int EXIT_SPRINGLOADED_MODE_LONG_TIMEOUT = 600;
    static final String INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION = "com.android.launcher66.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION";
    static final boolean LOGD = false;
    private static final String PREFERENCES = "launcher.preferences";
    private static final int REQUEST_BIND_APPWIDGET = 11;
    private static final int REQUEST_CREATE_APPWIDGET = 5;
    private static final int REQUEST_CREATE_SHORTCUT = 1;
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
    private static final String RUNTIME_STATE_PENDING_ADD_WIDGET_ID = "launcher.add_widget_id";
    static final int SCREEN_COUNT = 5;
    public static final String SHOW_WEIGHT_WATCHER = "debug.show_mem";
    static final String TAG = "Launcher";
    private static final String TOOLBAR_ICON_METADATA_NAME = "com.android.launcher.toolbar_icon";
    private static final String TOOLBAR_VOICE_SEARCH_ICON_METADATA_NAME = "com.android.launcher.toolbar_voice_search_icon";
    private String mediaSource = "fyt";
    private AudioManager mAudioManager;
    private String activeController;
    private String state;
    private boolean userLayout;
    private boolean leftBar;
    private String musictitle = null;
    private static KWAPI kwAPi;
    public static TextView mAllAppView;
    public static Launcher mLauncher;
    public static LauncherModel mModel;
    public static Workspace mWorkspace;
    public static boolean sNightMode;
    public static View wallpaperButton;
    public static View widgetButton;
    public static View settingsButton;
    public static View wallpaperButtonWidgets;
    public static View settingsButtonWidgets;
    LauncherApplication app;
    private ProgressBar btavProgress;
    public int carSpeed;
    RelativeLayout firstLayout;
    private RadioRuler img_freq_point;
    public ImageView ivALbumBg;
    public ImageView ivALbumBgTwo;
    public ImageView ivMusicScore;
    public ImageView ivMusicScore2;
    private Button kuwomusic_next;
    private Button kuwomusic_playpause;
    private Button kuwomusic_prev;
    View mAllAppsButton;
    private AppListAdapter mAppListAdapter;
    private List<AppListBean> mAppListData;
    private LauncherAppWidgetHost mAppWidgetHost;
    private AppWidgetManager mAppWidgetManager;
    private AppsCustomizePagedView mAppsCustomizeContent;
    public static AppsCustomizeTabHost mAppsCustomizeTabHost;
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
    public DragController mDragController;
    private DragLayer mDragLayer;
    private ImageView mDynamicTrailView;
    private Bitmap mFolderIconBitmap;
    private Canvas mFolderIconCanvas;
    private ImageView mFolderIconImageView;
    private FolderInfo mFolderInfo;
    private View.OnTouchListener mHapticFeedbackTouchListener;
    public Hotseat mHotseat;
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
    private boolean mPaused;
    private AppWidgetProviderInfo mPendingAddWidgetInfo;    
    private int mPendingAddWidgetId = -1;
    private MediaPlayer mPlayer;
    private View mQsbBar;
    private Button mRadioBandButton;
    private View mRadioIcon;
    private Button mRadioNextButton;
    private Button mRadioPauseButton;
    private Button mRadioPrevButton;
    private boolean mRestoring;
    private Bundle mSavedInstanceState;
    private Bundle mSavedState;
    private SearchDropTargetBar mSearchDropTargetBar;
    private SharedPreferences mSharedPrefs;
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
    public WeatherManager weatherManager;
    private Handler weatherHandler = new Handler(Looper.getMainLooper());
    private static final long WEATHER_INTERVAL = 5 * 60 * 1000; // 5 minutes.
    private ProgressBar musicProgress;
    private SeekBar musicSeekBar;
    private Button mPlayPauseButton;
    private Button mPlayPauseButtonTwo;
    public View pipViews;
    long preOnResumeTime;
    public boolean showKuwoContent;
    RemoteTools tools;
    private TextView tvAlbum;
    private TextView tvAritst;
    private TextView tvAritstTwo;
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
    public TextView weatherCity1;
    private ImageView weatherImg;
    public ImageView weatherImg1;
    private TextView weatherTemp;
    public TextView weatherTemp1;
    private TextView weatherTempRange;
    private TextView weatherTempRange1;
    private TextView weatherWeather;
    public TextView weatherWeather1;
    private TextView weatherWind;
    static final int APPWIDGET_HOST_ID = LauncherApplication.appWidget_Host_Id;
    private static final Object sLock = new Object();
    private static int sScreen = 0;
    private static int NEW_APPS_PAGE_MOVE_DELAY = HttpURLConnection.HTTP_INTERNAL_ERROR;
    private static int NEW_APPS_ANIMATION_INACTIVE_TIMEOUT_SECONDS = 5;
    private static int NEW_APPS_ANIMATION_DELAY = HttpURLConnection.HTTP_INTERNAL_ERROR;
    private static boolean sPausedFromUserAction = false;
    private static LocaleConfiguration sLocaleConfiguration = null;
    private static HashMap<Long, FolderInfo> sFolders = new HashMap<>();
    private static Drawable.ConstantState[] sGlobalSearchIcon = new Drawable.ConstantState[2];
    private static Drawable.ConstantState[] sVoiceSearchIcon = new Drawable.ConstantState[2];
    private static Drawable.ConstantState[] sAppMarketIcon = new Drawable.ConstantState[2];
    static final ArrayList<String> sDumpLogs = new ArrayList<>();
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
    public State mState = State.WORKSPACE;
    private final String colsePipAction = "com.lsec.tyz.action.voice.launcher";
    private final String camera360Action = "FOURCAMERA2_BROADCAST_SEND";
    private final BroadcastReceiver mCloseSystemDialogsReceiver = new CloseSystemDialogsIntentReceiver(this, null);
    private final ContentObserver mWidgetObserver = new AppWidgetResetObserver();
    public Handler handler = new Handler(Looper.getMainLooper());
    private ItemInfo mPendingAddInfo = new ItemInfo();
    private int[] mTmpAddItemCellCoordinates = new int[2];
    private Map<String, View> customViewMap = new HashMap<>();
    private boolean mAutoAdvanceRunning = false;
    private State mOnResumeState = State.NONE;
    private SpannableStringBuilder mDefaultKeySsb = null;
    private boolean mWorkspaceLoading = true;
    private boolean closePop = LauncherApplication.sApp.getResources().getBoolean(R.bool.close_popwindow);
    private ArrayList<Runnable> mBindOnResumeCallbacks = new ArrayList<>();
    private ArrayList<Runnable> mOnResumeCallbacks = new ArrayList<>();
    private boolean mUserPresent = true;
    private boolean mVisible = false;
    public boolean mHasFocus = false;
    private boolean mAttached = false;
    private long mAutoAdvanceTimeLeft = -1;
    private HashMap<View, AppWidgetProviderInfo> mWidgetsToAdvance = new HashMap<>();
    private final ArrayList<Integer> mSynchronouslyBoundPages = new ArrayList<>();
    private Rect mRectForFolderAnimation = new Rect();
    private HideFromAccessibilityHelper mHideFromAccessibilityHelper = new HideFromAccessibilityHelper();
    private SharedPreferences mPrefs;
	private boolean fytData = true;  
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private FusedLocationProviderClient fusedLocationClient;
    private Helpers helpers = new Helpers();
    private LinearLayout bottomButtons;
    private LinearLayout bottomButtonsWidgets;
    private boolean temporarilyDisablePlayPauseButton = false;
    private MainViewModel mViewModel;
    private final AtomicBoolean atomicOnCreate = new AtomicBoolean(false);
    private final AtomicBoolean atomicInitAppData = new AtomicBoolean(false);
    private Handler appDataHandler = new Handler(Looper.getMainLooper());
    private Runnable pendingAction;
    private static final long APP_DATA_DELAY = 1500;
    private static final int MAX_INIT_RETRIES = 10;
    private int mInitRetryCount = 0;
    private boolean mIsInitializingAppData = false;
    public boolean onResumePip = false;
    public boolean allowPip = false;
    private boolean onBackPip = false;
    private boolean onWorkspacePip = false;
    private boolean isRecreateActive = false;
    private boolean mHomeButtonPressed = false;
    private boolean mSkipPostResume = false;
    private boolean widgetBar = false;
    private boolean barTint = false;
    private boolean widgetTint = false;
    private DeviceProfile grid;
    private static final AtomicLong LAST_PROCESSED_NONCE = new AtomicLong(-1L);
    private final Executor bg = Executors.newSingleThreadExecutor();
    private static final String PREF_LAST_ALBUM_ART = "last_album_art_bitmap";
    private static final String PREF_LAST_ALBUM_PATH = "last_album_path";
    private static final String MUSIC_TITLE_PREF = "music_title_pref";
    private static final String ARTIST_PREF = "artist_pref";
    private String lastProcessedPath = null;
    private String lastMusictitle = null;
    private String lastArtist = null;
    private ConstraintLayout prevLayout;
    private ConstraintLayout playPauseLayout;
    private ConstraintLayout nextLayout;
    private ConstraintLayout prevLayoutTwo ;
    private ConstraintLayout playPauseLayoutTwo;
    private ConstraintLayout nextLayoutTwo;
    private int orientation;

    public static int calculatedStatsWidth;
    public static int calculatedStatsHeight;
    public static int calculatedPipMinHeight;
    public static int calculatedPipMinWidth;
    public static int calculatedDateMinHeight; 
    public static int calculatedDateMinWidth;
    public static int calculatedMusicMinHeight;
    public static int calculatedMusicMinWidth;
    public static int calculatedRadioMinHeight;
    public static int calculatedRadioMinWidth;
    public static int calculatedLeftBarWidth;
    public static int orientationDimension;
    public static int orientedWidth;
    public static int screenWidth;
    public static int screenHeight;
    public static int textSizeBasic;
    public static int textSizeTitle;
    public static int textSizeArtist;
    public static int textSizeWorkspace;
    public static int radioButtonHeight;
    public static int radioButtonWidth;
    public static int radioTextFrequency;
    public static int analogwidth;
    public static int analogheight;
    public static int digit_clock_width;
    public static int digit_clock_height;
    public static int dot_clock_width;
    public static int dot_clock_height;
    public static int app_icon_size;
    public static int icon_size;
    public static int apps_customize_page_view_margin_top;
    public static int apps_customize_page_view_margin_bottom;
    public static int leftBarIconMargin;
    public static int bottomBarIconMargin;
    public static int workspaceIconAndFolderSize;
    public static int workspaceTopPadding;    
    public static int allAppsIconTextSize;
    public static int mainScreenIconTextSize;

    public DeviceProfile getDeviceProfile() {
        return grid;
    }

    private Runnable mBuildLayersRunnable = new Runnable() { 
        @Override
        public void run() {
            if (Launcher.mWorkspace != null) {
                Launcher.mWorkspace.buildPageHardwareLayers();
            }
        }
    };

    Runnable runnable_register = new Runnable() { 
        @Override
        public void run() {
            TimeUpdateReceiver.register(Launcher.mLauncher);
            Launcher.this.sendBroadcast(new Intent(TimeUpdateReceiver.SHOW_TIME));
        }
    };

    private OnPlayerStatusListener onRefreshKwStatus = new OnPlayerStatusListener() { 
        private int[] $SWITCH_TABLE$cn$kuwo$autosdk$api$PlayerStatus;

            int[] $SWITCH_TABLE$cn$kuwo$autosdk$api$PlayerStatus() {
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

        @Override
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
    private BroadcastReceiver removeMusic = new BroadcastReceiver() { 
        @Override 
        public void onReceive(Context arg0, Intent intent) {
            String action = intent.getAction();
            if ((mediaSource == "fyt" || activeController == null) && "com.fyt.systemui.remove".equals(action)) {
                Bundle bundle = intent.getExtras();
                String packageName = bundle.getString("pkg");
                if ("com.syu.music".equals(packageName)) {
                    MusicService.state = false;
                    Launcher.this.handler.postDelayed(new Runnable() { 
                        @Override 
                        public void run() {
                            String[] strArr = new String[5];
                            if (MusicService.music_path != null && !MusicService.music_path.isEmpty() && MusicService.music_path.lastIndexOf("/") >= 0) {
                                if (fytData) { // from metadata
                                    strArr[0] = MusicService.music_name;
                                } else { // from file title
                                    File file = new File(MusicService.music_path);
                                    String filename = file.getName();
                                    musictitle = filename.substring(0, filename.lastIndexOf("."));
                                    strArr[0] = musictitle;
                                }
                                strArr[1] = MusicService.author_name;
                                strArr[2] = MusicService.state.toString();
                                strArr[3] = MusicService.album;
                                strArr[4] = MusicService.music_path;                                
                            } else {
                                strArr[0] = LauncherApplication.sApp.getResources().getString(R.string.music_name);
                                strArr[1] = LauncherApplication.sApp.getResources().getString(R.string.music_author);
                                strArr[2] = MusicService.state.toString();
                                strArr[4] = "/" + LauncherApplication.sApp.getResources().getString(R.string.music_author);             
                            }
                            LauncherNotify.NOTIFIER_MUSIC.set(null, new long[2], new float[]{0.0f, 0.0f}, strArr, MusicService.album_cover, mediaSource);
                        }
                    }, 1000L);
                } else if (FytPackage.GaodeACTION.equals(packageName)) {
                    Launcher.this.handler.postDelayed(new Runnable() { 
                        @Override
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
    private IUiRefresher refreshBtav = new IUiRefresher() { 
        @Override
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
    IUiRefresher refreshDvr = new IUiRefresher() { 
        @Override
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            if (ints != null && ints.length > 0) {
                int mDvrRecState = ints[0];
                if (mDvrRecState == 1) {
                    if (Launcher.this.getCustomView(Config.WS_Dvr_Rec) != null) {
                        Launcher.this.getCustomView(Config.WS_Dvr_Rec).setBackgroundResource(ResValue.getInstance().dvr_stop_btn);
                    }
                } else if (mDvrRecState == 0 && Launcher.this.getCustomView(Config.WS_Dvr_Rec) != null) {
                    Launcher.this.getCustomView(Config.WS_Dvr_Rec).setBackgroundResource(ResValue.getInstance().dvr_rec_btn);
                }
            }
        }
    };
    private IUiRefresher refreshNaviState = new IUiRefresher() { 
        @Override
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            Launcher.this.handleNaviState();
        }
    };
    private IUiRefresher refreshNaviView = new IUiRefresher() { 
        @Override
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
    QSBScroller mQsbScroller = new QSBScroller() { 
        int scrollY = 0;

        @Override
        public void setScrollY(int scroll) {
            scrollY = scroll;
            if (Launcher.mWorkspace.isOnOrMovingToCustomContent()) {
                Launcher.this.mSearchDropTargetBar.setTranslationY(-scrollY);
                Launcher.this.getQsbBar().setTranslationY(-scrollY);
            }
        }
    };
    private int[] images = {ResValue.getInstance().num00, ResValue.getInstance().num01, ResValue.getInstance().num02, ResValue.getInstance().num03, ResValue.getInstance().num04, ResValue.getInstance().num05, ResValue.getInstance().num06, ResValue.getInstance().num07, ResValue.getInstance().num08, ResValue.getInstance().num09};
    String lastpath = null;
    public IUiRefresher refreshMusic = new IUiRefresher() {
        @Override
        public void onRefresh(int[] ints, long[] lngs, float[] flts, String[] strs, byte[] byts, String source) {
            mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            mediaSource = source; 
            if (mediaSource == null) {
                mediaSource = "fyt";
            }
            state = null;
            String artist = null;
            String album = null;
            String path = null;
            if (strs != null && strs.length > 5) {
                musictitle = strs[0];
                artist = strs[1];   
                if (artist == "null") {
                    artist = strs[3];
                }
                if (artist == "null") {
                    artist = "\u0020";
                }
                state = strs[2];
                album = strs[3];
                path = strs[4];
                activeController = strs[5];
            }
            if (path == null || path.isEmpty()) {
                // Some apps produce null path - we need a value to properly save a bitmap
                path = String.valueOf(Arrays.hashCode(byts));
            }
            if (mediaSource == "mediaController") {
                boolean activeControllerAppRunning = false;
                ActivityManager activityManager = (ActivityManager) getSystemService( Context.ACTIVITY_SERVICE );
                List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();                        
                for(ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                    if (appProcess.processName.contains(activeController)) {
                        activeControllerAppRunning = true;
                    } 
                }
                if (!activeControllerAppRunning) {
                    if (Launcher.this.tvMusicName != null) {
                        Launcher.this.tvMusicName.setText(R.string.music_name);
                    }
                    if (Launcher.this.tvMusicNameTwo != null) {
                        Launcher.this.tvMusicNameTwo.setText(R.string.music_name);
                    }
                    if (Launcher.this.mPlayPauseButton != null) {
                        Launcher.this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setWidgetButtonsTint(mPlayPauseButton);
                    }
                    if (Launcher.this.mPlayPauseButtonTwo != null) {
                        Launcher.this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                        setBarButtonsTint(mPlayPauseButtonTwo);
                    }
                    if (Launcher.this.tvAritst != null) {
                        Launcher.this.tvAritst.setText(R.string.music_author);
                    }
                    if (Launcher.this.tvAritstTwo != null) {
                        Launcher.this.tvAritstTwo.setText(R.string.music_author);
                    }
                    if (Launcher.this.tvAlbum != null) {
                        Launcher.this.tvAlbum.setText(R.string.music_album);
                    }  
                    if (Launcher.this.tvCurTime != null) {
                        Launcher.this.tvCurTime.setText("00:00");
                    }
                    if (Launcher.this.tvTotalTime != null) {
                        Launcher.this.tvTotalTime.setText("00:00");
                    }
                    if (Launcher.this.musicProgress != null) {
                        Launcher.this.musicProgress.setProgress(0);
                    }
                    if (Launcher.this.musicSeekBar != null) {
                        Launcher.this.musicSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListenerImp(Launcher.this, null));
                    } 
                    return;         
                }
            }

            setPlayPauseIcon(false);

            if ("true".equals(state)) {
                Lrc lrc = new Lrc();
                Id3Info info = lrc.getId3Info(path);
                byte[] dataPic =  info.dataPic;
                if (dataPic == null) {
                    dataPic = byts;
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
                        
                        // Only save if this is a new path
                        if (!path.equals(lastProcessedPath)) {
                            saveBitmapToPreferences(bp, path);
                        }
                        
                        Drawable drawable = new BitmapDrawable(getApplicationContext().getResources(), bp);
                        if (Launcher.this.ivALbumBg != null) {
                            Launcher.this.ivALbumBg.setImageDrawable(drawable);
                        }
                        if (Launcher.this.ivALbumBgTwo != null) {
                            Launcher.this.ivALbumBgTwo.setImageDrawable(drawable);
                        }
                    }
                } else {
                    Launcher.this.lastpath = null;
                    lastProcessedPath = null; // Reset when no image data
                    
                    // Try to load the last saved bitmap
                    Bitmap savedBitmap = getBitmapFromPreferences();
                    if (savedBitmap != null) {
                        Drawable drawable = new BitmapDrawable(getApplicationContext().getResources(), savedBitmap);
                        if (Launcher.this.ivALbumBg != null) {
                            Launcher.this.ivALbumBg.setImageDrawable(drawable);
                        }
                        if (Launcher.this.ivALbumBgTwo != null) {
                            Launcher.this.ivALbumBgTwo.setImageDrawable(drawable);
                        }
                    } else {
                        // Use default if no saved bitmap
                        if (Launcher.this.ivALbumBg != null) {
                            Launcher.this.ivALbumBg.setImageResource(ResValue.getInstance().music_album_def);
                        }
                        if (Launcher.this.ivALbumBgTwo != null) {
                            Launcher.this.ivALbumBgTwo.setImageResource(ResValue.getInstance().music_album_def);
                        }
                    }
                }
                if (Launcher.this.ivMusicScore != null) {
                    ((AnimationDrawable) Launcher.this.ivMusicScore.getDrawable()).start();
                }
                if (Launcher.this.ivMusicScore2 != null) {
                    ((AnimationDrawable) Launcher.this.ivMusicScore2.getDrawable()).start();
                }

                if (musictitle != null && !musictitle.isEmpty() && !musictitle.trim().isEmpty()) {
                    saveTitleToPreferences(musictitle);
                    if (Launcher.this.tvMusicName != null) {
                        if (!(Launcher.this.tvMusicName.getText().toString()).equals(musictitle)) {
                            Launcher.this.tvMusicName.setText(musictitle); 
                        } else {
                            if (!mediaSource.equals(helpers.returnMediaSourcePre())) {
                                helpers.setMediaSourcePre(mediaSource);
                                Launcher.this.tvMusicName.setText("\u0020" + musictitle + "\u0020"); 
                            }                       
                        }
                        Launcher.this.tvMusicName.setSelected(true);
                    }
                    if (Launcher.this.tvMusicNameTwo != null) {
                        if (!(Launcher.this.tvMusicNameTwo.getText().toString()).equals(musictitle)) {
                            Launcher.this.tvMusicNameTwo.setText(musictitle); 
                        } else {
                            if (!mediaSource.equals(helpers.returnMediaSourcePre())) {
                                helpers.setMediaSourcePre(mediaSource);
                                Launcher.this.tvMusicNameTwo.setText("\u0020" + musictitle + "\u0020"); 
                            }                           
                        }
                        Launcher.this.tvMusicNameTwo.setSelected(true);  
                    }
                }
                if (artist != null && !artist.isEmpty()) {
                    saveArtistToPreferences(artist);
                    if (Launcher.this.tvAritst != null) {
                        if (!(Launcher.this.tvAritst.getText().toString()).equals(artist)) {
                            Launcher.this.tvAritst.setText(artist);                         
                        }
                        Launcher.this.tvAritst.setSelected(true); 
                    }  
                    if (Launcher.this.tvAritstTwo != null) {
                        if (!(Launcher.this.tvAritstTwo.getText().toString()).equals(artist)) {
                            Launcher.this.tvAritstTwo.setText(artist);                         
                        }
                        Launcher.this.tvAritstTwo.setSelected(true); 
                    }                  
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
                        int progressPercent = (int) ((1000 * curProgress) / totalProgress);
                        if (progressPercent < 5) {
                            if (Launcher.this.musicSeekBar != null) {
                                Launcher.this.musicSeekBar.setProgress(5);
                            }
                            if (Launcher.this.musicProgress != null) {
                                Launcher.this.musicProgress.setProgress(progressPercent);
                            }
                        } else {
                            if (Launcher.this.musicSeekBar != null) {
                                Launcher.this.musicSeekBar.setProgress(progressPercent);
                            }
                            if (Launcher.this.musicProgress != null) {
                                Launcher.this.musicProgress.setProgress(progressPercent);
                            }
                        }
                    }
                    if (curProgress == 0 && totalProgress == 0) {
                        if (Launcher.this.musicProgress != null) {
                            Launcher.this.musicProgress.setProgress(0);
                        }  
                        if (Launcher.this.tvAritst != null) {
                            Launcher.this.tvAritst.setText("Live");
                        }    
                        if (Launcher.this.tvAritstTwo != null) {
                            Launcher.this.tvAritstTwo.setText("Live");
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
            if (CarStates.mAppID != 8 && (mediaSource == "fyt" || activeController == null)) {
                if (MusicService.music_path != null && !MusicService.music_path.isEmpty() && MusicService.music_path.lastIndexOf("/") >= 0) {
                    if (fytData) { // from metadata
                        musictitle = MusicService.music_name;
                    } else { // from file title
                        File file = new File(MusicService.music_path);
                        String filename = file.getName();
                        musictitle = filename.substring(0, filename.lastIndexOf("."));
                    }
                    Utils.setTextStr(Launcher.this.tvMusicName, musictitle);
                    Utils.setTextStr(Launcher.this.tvMusicNameTwo, musictitle); 
                    if (MusicService.author_name != null && !MusicService.author_name.isEmpty()) {
                        Utils.setTextStr(Launcher.this.tvAritst, MusicService.author_name);
                        Utils.setTextStr(Launcher.this.tvAritstTwo, MusicService.author_name);
                    } else {
                        Utils.setTextId(Launcher.this.tvAritst, R.string.music_author);
                        Utils.setTextId(Launcher.this.tvAritstTwo, R.string.music_author);
                    }                            
                } else {
                    Utils.setTextId(Launcher.this.tvMusicName, R.string.music_name);
                    Utils.setTextId(Launcher.this.tvMusicNameTwo, R.string.music_name); 
                    Utils.setTextId(Launcher.this.tvAritst, R.string.music_author);
                    Utils.setTextId(Launcher.this.tvAritstTwo, R.string.music_author);         
                }

                Utils.setTextStr(Launcher.this.tvCurTime, "00:00");
                Utils.setTextStr(Launcher.this.tvTotalTime, "00:00");
                if (Launcher.this.musicSeekBar != null) {
                    Launcher.this.musicSeekBar.setProgress(0);
                }
                if (Launcher.this.musicProgress != null) {
                    Launcher.this.musicProgress.setProgress(0);
                }
                if (Launcher.this.mPlayPauseButton != null) {
                    Launcher.this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                    setWidgetButtonsTint(mPlayPauseButton);
                    return;
                }
                if (Launcher.this.mPlayPauseButtonTwo != null) {
                    Launcher.this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                    setBarButtonsTint(mPlayPauseButtonTwo);
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
            /*if (Launcher.this.mPlayPauseButton != null) {
                Launcher.this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }
            if (Launcher.this.mPlayPauseButtonTwo != null) {
                Launcher.this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }*/
            if (musictitle != null && !musictitle.isEmpty() && !musictitle.trim().isEmpty()) {
                if (Launcher.this.tvMusicName != null) {
                    if (!(Launcher.this.tvMusicName.getText().toString()).equals(musictitle)) {
                        Launcher.this.tvMusicName.setText(musictitle);                                                  
                    }
                    Launcher.this.tvMusicName.setSelected(true);
                }
                if (Launcher.this.tvMusicNameTwo != null) {
                    if (!(Launcher.this.tvMusicNameTwo.getText().toString()).equals(musictitle)) {
                        Launcher.this.tvMusicNameTwo.setText(musictitle);                       
                    }
                    Launcher.this.tvMusicNameTwo.setSelected(true); 
                }
            }
            if (artist != null && !artist.isEmpty() && Launcher.this.tvAritst != null) {
                if (Launcher.this.tvAritst != null) {
                    if (!(Launcher.this.tvAritst.getText().toString()).equals(artist)) {
                        Launcher.this.tvAritst.setText(artist);              
                    }
                    Launcher.this.tvAritst.setSelected(true);
                }                   
            }
            if (artist != null && !artist.isEmpty() && Launcher.this.tvAritstTwo != null) {
                if (Launcher.this.tvAritstTwo != null) {
                    if (!(Launcher.this.tvAritstTwo.getText().toString()).equals(artist)) {
                        Launcher.this.tvAritstTwo.setText(artist);              
                    }
                    Launcher.this.tvAritstTwo.setSelected(true);
                }                   
            }
            Widget.update(LauncherApplication.sApp);
        }
    };

    // set play/pause icon for stock and other music players
    public void setPlayPauseIcon(boolean wait) {
        if (wait) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    setPlayPauseIcon();
                    Widget.update(LauncherApplication.sApp);   
                }
            }, 500);
        } else {
           setPlayPauseIcon();
        }
    }

    public void setPlayPauseIcon() {
        if (Launcher.this.mPlayPauseButton != null && !temporarilyDisablePlayPauseButton) {
            if (MusicService.state.booleanValue() || mAudioManager.isMusicActive()) {
                Launcher.this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            } else {
                Launcher.this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            }
        }
        if (Launcher.this.mPlayPauseButtonTwo != null && !temporarilyDisablePlayPauseButton) {
            if (MusicService.state.booleanValue() || mAudioManager.isMusicActive()) {
                Launcher.this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            } else {
                Launcher.this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            }
        }         
    }

    private boolean isRadioPlaying() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            return false;
        }

        boolean isRadioRunning = false;
        if (activityManager.getRunningAppProcesses() != null) {
            for (ActivityManager.RunningAppProcessInfo processInfo : activityManager.getRunningAppProcesses()) {
                if (processInfo.processName.equals("com.syu.radio")) {
                    isRadioRunning = true;
                    break;
                }
            }
        }
        return isRadioRunning;
    }

    public void preSetMusicWidgets() {
        Bitmap savedBitmap = getBitmapFromPreferences();
        if (savedBitmap != null) {
            Drawable drawable = new BitmapDrawable(getApplicationContext().getResources(), savedBitmap);
            if (Launcher.this.ivALbumBg != null) {
                Launcher.this.ivALbumBg.setImageDrawable(drawable);
            }
            if (Launcher.this.ivALbumBgTwo != null) {
                Launcher.this.ivALbumBgTwo.setImageDrawable(drawable);
            }
        } else {
            // Use default if no saved bitmap
            if (Launcher.this.ivALbumBg != null) {
                Launcher.this.ivALbumBg.setImageResource(ResValue.getInstance().music_album_def);
            }
            if (Launcher.this.ivALbumBgTwo != null) {
                Launcher.this.ivALbumBgTwo.setImageResource(ResValue.getInstance().music_album_def);
            }
        }

        String musictitle = mPrefs.getString(MUSIC_TITLE_PREF, null);
        if (musictitle != null && !musictitle.isEmpty() && !musictitle.trim().isEmpty()) {
            if (Launcher.this.tvMusicName != null) {
                if (!(Launcher.this.tvMusicName.getText().toString()).equals(musictitle)) {
                    Launcher.this.tvMusicName.setText(musictitle); 
                } else {
                    if (!mediaSource.equals(helpers.returnMediaSourcePre())) {
                        helpers.setMediaSourcePre(mediaSource);
                        Launcher.this.tvMusicName.setText("\u0020" + musictitle + "\u0020"); 
                    }                       
                }
                Launcher.this.tvMusicName.setSelected(true);
            }
            if (Launcher.this.tvMusicNameTwo != null) {
                if (!(Launcher.this.tvMusicNameTwo.getText().toString()).equals(musictitle)) {
                    Launcher.this.tvMusicNameTwo.setText(musictitle); 
                } else {
                    if (!mediaSource.equals(helpers.returnMediaSourcePre())) {
                        helpers.setMediaSourcePre(mediaSource);
                        Launcher.this.tvMusicNameTwo.setText("\u0020" + musictitle + "\u0020"); 
                    }                           
                }
                Launcher.this.tvMusicNameTwo.setSelected(true);  
            }
        }

        String artist = mPrefs.getString(ARTIST_PREF, null);
        if (artist != null && !artist.isEmpty()) {
            if (Launcher.this.tvAritst != null) {
                if (!(Launcher.this.tvAritst.getText().toString()).equals(artist)) {
                    Launcher.this.tvAritst.setText(artist);                         
                }
                Launcher.this.tvAritst.setSelected(true); 
            }  
            if (Launcher.this.tvAritstTwo != null) {
                if (!(Launcher.this.tvAritstTwo.getText().toString()).equals(artist)) {
                    Launcher.this.tvAritstTwo.setText(artist);                         
                }
                Launcher.this.tvAritstTwo.setSelected(true); 
            }                  
        }

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (Launcher.this.mPlayPauseButton != null) {
            if (MusicService.state.booleanValue() || mAudioManager.isMusicActive()) {
                Launcher.this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            } else {
                Launcher.this.mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
            }
        }
        if (Launcher.this.mPlayPauseButtonTwo != null) {
            if (MusicService.state.booleanValue() || mAudioManager.isMusicActive()) {
                Launcher.this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            } else {
                Launcher.this.mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            }
        }    
    }

    private void saveTitleToPreferences(String currentTitle) {
        if (currentTitle.equals(lastMusictitle)) {
            return;
        }

        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(MUSIC_TITLE_PREF, currentTitle);
        editor.apply();        
    }

    private void saveArtistToPreferences(String currentArtist) {
        if (currentArtist.equals(lastArtist)) {
            return;
        }

        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(ARTIST_PREF, currentArtist);
        editor.apply();        
    }

    private void saveBitmapToPreferences(Bitmap bitmap, String currentPath) {
        if (bitmap == null || currentPath == null) return;
        
        // Check if this is the same path we just processed
        if (currentPath.equals(lastProcessedPath)) {
            return;
        }
        
        new AsyncTask<Object, Void, Void>() {
            @Override
            protected void onProgress(Void[] progress) {
                //
            }

            @Override
            protected Void doInBackground(Object... params) {
                Bitmap bitmapToSave = (Bitmap) params[0];
                String path = (String) params[1];
                
                try {
                    // Double-check with persisted path
                    String lastSavedPath = mPrefs.getString(PREF_LAST_ALBUM_PATH, "");
                    
                    if (path.equals(lastSavedPath)) {
                        return null; // Already saved for this path
                    }
                    
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmapToSave.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String encodedBitmap = Base64.encodeToString(byteArray, Base64.DEFAULT);
                    
                    SharedPreferences.Editor editor = mPrefs.edit();
                    editor.putString(PREF_LAST_ALBUM_ART, encodedBitmap);
                    editor.putString(PREF_LAST_ALBUM_PATH, path);
                    editor.apply();
                    
                    // Update in-memory cache
                    lastProcessedPath = path;
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onBackgroundError(Exception e) {
                Log.e(TAG, "saveBitmapToPreferences: " + e.getMessage());
            }
        }.execute(bitmap, currentPath);
    }

    private Bitmap getBitmapFromPreferences() {
        try {
            String encodedBitmap = mPrefs.getString(PREF_LAST_ALBUM_ART, null);
            
            if (encodedBitmap != null) {
                byte[] decodedBytes = Base64.decode(encodedBitmap, Base64.DEFAULT);
                return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private int radioBand = -1;
    Callback.OnRefreshLisenter refreshRadioBand = new Callback.OnRefreshLisenter() { 
        @Override
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 0 && ints != null && ints.length > 0) {
                int band = ints[0];
                Log.d(TAG, "-------->>> FinalRadio.U_BAND" + band);
                if (band == 65536 || band == 65537 || band == 65538) {
                    Launcher.this.radioBand = 0;
                } else if (band == 0 || band == 1) {
                    Launcher.this.radioBand = 1;
                }
            }
        }
    };
    Callback.OnRefreshLisenter refreshRadioFreq = new Callback.OnRefreshLisenter() { 
        @Override
        public void onRefresh(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 1 && ints != null && ints.length > 0) {
                mHandler.postDelayed(() -> {
                    if (isRadioPlaying()) stopMusic();
                }, 500);
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
    private IUiRefresher refreshVideo = new IUiRefresher() { 
        @Override
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
    Callback.OnRefreshLisenter refreshBtInfo = new Callback.OnRefreshLisenter() { 
        @Override
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
                        int progressPercent = (Launcher.btCurTime * 1000) / Launcher.btTotalTime;
                        if (progressPercent < 5) {
                            if (Launcher.this.btavProgress != null) {
                                Launcher.this.btavProgress.setProgress(5);
                            }
                        } else if (Launcher.this.btavProgress != null) {
                            Launcher.this.btavProgress.setProgress(progressPercent);
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

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { 
        @Override 
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                switch (intent.getAction()) {
                    case "android.intent.action.SCREEN_OFF":
                        Launcher.this.mUserPresent = false;
                        Launcher.this.mDragLayer.clearAllResizeFrames();
                        Launcher.this.updateRunning();
                        if (Launcher.this.mAppsCustomizeTabHost != null && Launcher.this.mPendingAddInfo.container == -1) {
                            Launcher.this.showWorkspace(true);
                        }
                        break;  
                    case Intent.ACTION_USER_PRESENT:
                        Launcher.this.mUserPresent = true;
                        Launcher.this.updateRunning();
                        break;                     
                    case Intent.ACTION_CLOSE_SYSTEM_DIALOGS:
                        String reason = intent.getStringExtra(Keys.SYSTEM_DIALOG_REASON_KEY);
                        if (reason != null) {
                            if (reason.equals(Keys.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                                mHomeButtonPressed = true;
                                if (isOnMainWorkspaceScreen()) {
                                    // Already where we should be, no action needed
                                    return;
                                }
                                // Only run the complex logic if we're not already on main workspace
                                if (!helpers.isInRecent() && !helpers.isListOpen()) {
                                    helpers.setPipStarted(true);
                                } 
                                helpers.setInAllApps(false);
                                helpers.setInWidgets(false);
                                helpers.setForegroundAppOpened(false);
                                if (helpers.isListOpen() || helpers.isInOverviewMode()) {
                                    helpers.setWasInRecents(false);
                                } else {
                                    helpers.setWasInRecents(true);
                                }
                                LauncherNotify.NOTIFIER_MUSIC.addUiRefresher(Launcher.this.refreshMusic, true);
                                
                                if (mWorkspace.isInOverviewMode()) {
                                    showHotseat(true, true);
                                    mWorkspace.exitOverviewMode(true);
                                    updateWallpaperVisibility(true);
                                }
                            } else if (reason.equals(Keys.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                                helpers.setPipStarted(false);
                                helpers.setInAllApps(false);
                                helpers.setInWidgets(false);
                                LauncherNotify.NOTIFIER_MUSIC.addUiRefresher(Launcher.this.refreshMusic, true);
                            }                        
                        }
                        break; 
                    case "pause.button":
                        setPlayPauseIcon(true);   
                        break;          
                }
            }
        }
    };

    private boolean isOnMainWorkspaceScreen() {
        int startPage = Integer.parseInt(mPrefs.getString("start_page", "1"));
        return mState == State.WORKSPACE && 
               !mWorkspace.isInOverviewMode() && 
               !isAllAppsVisible() && 
               mWorkspace.getOpenFolder() == null &&
               !mDragController.isDragging() &&
               mWorkspace.getCurrentPage() == startPage;
    }

    private final Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int i = 0;
                for (View key : Launcher.this.mWidgetsToAdvance.keySet()) {
                    final View v = key.findViewById(((AppWidgetProviderInfo) Launcher.this.mWidgetsToAdvance.get(key)).autoAdvanceViewId);
                    int delay = i * 250;
                    if (v instanceof Advanceable) {
                        postDelayed(new Runnable() { 
                            @Override
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
    private Runnable mBindPackagesUpdatedRunnable = new Runnable() { 
        @Override
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

    public enum State {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate", "onCreate----->");
        allowPip = true;
        atomicOnCreate.set(true);

        if (customViewMap == null) {
            customViewMap = new HashMap<>();
        }

        getSharedPreferences("HelpersPrefs", 0).edit().clear().apply();
        helpers = new Helpers();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);  

        calculateLayoutDimensions();       

        if (mPrefs.getBoolean("transparent_statusbar", false)) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        checkNotificationPermission();      

        fytData = mPrefs.getBoolean("fyt_data", true);   
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        widgetBar = mPrefs.getBoolean(Keys.WIDGET_BAR, false); 

        if (!userLayout) {
            WindowUtil.restartPinnedPipApp();
        }

        getWindow().addFlags(Integer.MIN_VALUE);

        float density = getResources().getDisplayMetrics().density;
        LogPreview.show("------------------->>> density:" + density);

        checkForLocaleChange();

        initVariable();

        mAppWidgetManager = AppWidgetManager.getInstance(LauncherApplication.sApp);
        mAppWidgetHost = new LauncherAppWidgetHost(LauncherApplication.sApp, this, APPWIDGET_HOST_ID);
        mAppWidgetHost.setOnWidgetClickListener(this);
        mAppWidgetHost.startListening();

        registerContentObservers();

        mSavedState = savedInstanceState;
        restoreState(mSavedState);

        // Update customization drawer _after_ restoring the states
        if (mAppsCustomizeContent != null) {
            mAppsCustomizeContent.onPackagesUpdated(
                LauncherModel.getSortedWidgetsAndShortcuts(this));
        }

        if (!mRestoring) {
            if (sPausedFromUserAction) {
                // If the user leaves launcher, then we should just load items asynchronously when
                // they return.
                mModel.startLoader(true, -1);
            } else {
                // We only load the page synchronously if the user rotates (or triggers a
                // configuration change) while launcher is in the foreground
                mModel.startLoader(true, mWorkspace.getCurrentPage());
            }
        }

        // For handling default keys
        mDefaultKeySsb = new SpannableStringBuilder();
        Selection.setSelection(mDefaultKeySsb, 0);
        
        mHandler.post(this.runnable_register);
        
        updateGlobalIcons();
        
        // On large interfaces, we want the screen to auto-rotate based on the current orientation
        unlockScreenOrientation(true);
        
        initRegisterReceiver();
        
        Widget.update(LauncherApplication.sApp);
		
        onBackPressedX();
    }

    private void calculateLayoutDimensions() {
        screenWidth = getResources().getDisplayMetrics().widthPixels; 
        screenHeight = getResources().getDisplayMetrics().heightPixels; 

        orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            orientationDimension = screenHeight;
            calculatedLeftBarWidth = calculateDimension(orientationDimension - getStatusBarHeight(), 7.1);
            orientedWidth = screenWidth;
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            orientationDimension = screenWidth - getStatusBarHeight();
            calculatedLeftBarWidth = calculateDimension(orientationDimension, 7.1);
            orientedWidth = screenHeight + getStatusBarHeight();
        } 

        calculatedStatsWidth = calculateDimension(orientationDimension, 21.75);
        calculatedStatsHeight = calculateDimension(orientationDimension, 5.0);
        calculatedPipMinHeight = calculateDimension(orientationDimension, 18.0);
        calculatedPipMinWidth = calculateDimension(orientedWidth, 44.0);
        calculatedDateMinHeight = calculateDimension(orientationDimension, 7.2);
        calculatedDateMinWidth = calculateDimension(orientedWidth, 44.0);
        calculatedMusicMinHeight = calculateDimension(orientationDimension, 18.0);
        calculatedMusicMinWidth = calculateDimension(orientedWidth, 25.1);
        calculatedRadioMinHeight = calculateDimension(orientationDimension, 7.2);
        calculatedRadioMinWidth = calculateDimension(orientedWidth, 25.1);    
        
        // Text size
        textSizeBasic = calculateAdaptiveTextSize(orientationDimension, 18);
        textSizeTitle = calculateAdaptiveTextSize(orientationDimension, 22);
        textSizeArtist = calculateAdaptiveTextSize(orientationDimension, 16);
        textSizeWorkspace = calculateAdaptiveTextSize(orientationDimension, 32);

        // RecyclerView
        leftBarIconMargin = calculateDimension(screenHeight, 3.2);
        bottomBarIconMargin = calculateDimension(screenWidth, 2.0);

        // Radio widget
        radioButtonHeight = calculateDimension(orientationDimension, 3.5);
        radioButtonWidth = calculateDimension(orientationDimension, 3.0);      
        radioTextFrequency = calculateAdaptiveTextSize(orientationDimension, 30);

        // Integers
        analogwidth = calculateDimension(orientationDimension, 13.8);
        analogheight = calculateDimension(orientationDimension, 13.8);
        digit_clock_width = calculateDimension(orientationDimension, 4.1);
        digit_clock_height = calculateDimension(orientationDimension, 5.5);
        dot_clock_width = calculateDimension(orientationDimension, 2.6);
        dot_clock_height = calculateDimension(orientationDimension, 5.5);

        // Dimens
        app_icon_size = calculateDimension(orientationDimension, 6.6);
        icon_size = calculateDimension(orientationDimension, 3.5);
        apps_customize_page_view_margin_top = calculateDimension(orientationDimension, 2.0);
        apps_customize_page_view_margin_bottom = calculateDimension(orientationDimension, 2.0);

        // Workspace
        workspaceIconAndFolderSize = calculateDimension(orientationDimension, 6.5);
        workspaceTopPadding = calculateDimension(orientationDimension, 0.8);

        // Icons - different sizes on different resolutions
        SharedPreferences.Editor editor = mPrefs.edit();
        editor = mPrefs.edit();
        if (!helpers.allAppsTextSizeBoolean()) {
            allAppsIconTextSize = calculateAdaptiveTextSize(orientationDimension, 18);
            editor.putString("all_apps_textSize", String.valueOf(allAppsIconTextSize));
        }
        if (!helpers.workspaceTextSizeBoolean()) {
            mainScreenIconTextSize = calculateAdaptiveTextSize(orientationDimension, 28);
            editor.putString("workspace_textSize", String.valueOf(mainScreenIconTextSize));
        }
        editor.apply();
    }

    public int calculateDimension(int dimension, double percentage) {
        if (dimension <= 0 || percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid input: dimension must be positive, and percentage must be between 0 and 100.");
        }
        double result = (percentage / 100.0) * dimension;
        return (int) result;
    }

    public int calculateAdaptiveTextSize(int screenWidth, double baseSize) {
        if (screenWidth <= 0 || baseSize <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        double ratio = screenWidth / 2000.0;
        double scaleFactor = Math.pow(ratio, 0.5); 
        
        return (int) (baseSize * scaleFactor);
    }

    private void initVariable() {
        mLauncher = this;
        app = LauncherApplication.sApp;
                
        W3Utils.addFilterApp(FytPackage.browserAction);

        LauncherAppState.setApplicationContext(getApplicationContext());
        LauncherAppState app = LauncherAppState.getInstance();

        ContentResolver resolver = getApplicationContext().getContentResolver();       
        Config.PLATFORM_ID = ShareHandler.getInt(resolver, 10, 0);
        Config.CUSTOMER_ID = ShareHandler.getInt(resolver, 9, 0);
        Config.USER_UIID = ShareHandler.getInt(resolver, 11, 0);
        Config.CHIP_UIID = ShareHandler.getInt(resolver, 13, 0);
        
        // Determine the dynamic grid properties
        Point smallestSize = new Point();
        Point largestSize = new Point();
        Point realSize = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getCurrentSizeRange(smallestSize, largestSize);
        display.getRealSize(realSize);
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        // Lazy-initialize the dynamic grid
        grid = app.initDynamicGrid(this,
                Math.min(smallestSize.x, smallestSize.y),
                Math.min(largestSize.x, largestSize.y),
                realSize.x, realSize.y,
                dm.widthPixels, dm.heightPixels);

        // the LauncherApplication should call this, but in case of Instrumentation it might not be present yet
        mSharedPrefs = getSharedPreferences(LauncherAppState.getSharedPreferencesKey(),
                Context.MODE_PRIVATE);

        mModel = app.setLauncher(this);
        mIconCache = app.getIconCache();
        mIconCache.flushInvalidIcons(grid);
        mDragController = new DragController(this);
        mInflater = getLayoutInflater();

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.setFirstUse(mModel.mFirstUse);
        
        setContentView(R.layout.launcher);
        
        setupViews();
        grid.layout(this);

        mStats = new Stats(this);
        
        kwAPi = KWAPI.createKWAPI(this, "fangyitong");
        if (kwAPi != null) {
            kwAPi.registerPlayerStatusListener(this, onRefreshKwStatus);
        }
    }

    private void onBackPressedX() {
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Log.d(TAG, "onBackPressed----->");
                if (isAllAppsVisible()) {
                    if (Launcher.this.mAppsCustomizeContent.getContentType() == AppsCustomizePagedView.ContentType.Applications || Launcher.this.mAppsCustomizeContent.getContentType() == AppsCustomizePagedView.ContentType.Widgets) {
                        helpers.setInAllApps(false);
                        onBackPip = true;
                        showWorkspace(true);
                        initPip("showWorkspace", null, false);
                    } else {
                        setButtonVisible(true);
                        Launcher.this.mAllAppsButton.setVisibility(android.view.View.VISIBLE);
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
                    mWorkspace.showOutlinesTemporarily(true);
                }
                if (ResValue.getInstance().clickapp_cling > 0) {
                    Cling cling = (Cling) findViewById(ResValue.getInstance().clickapp_cling);
                    cling.setVisibility(android.view.View.GONE);
                    Launcher.this.stopVoice();
                    if (Launcher.this.mWaitingForResume != null) {
                        Launcher.this.mWaitingForResume.setStayPressed(false);
                    }
                    if (Launcher.this.mAppsCustomizeContent != null) {
                        Launcher.this.mAppsCustomizeContent.resetDrawableState();
                    }
                }
                if (Launcher.this.firstLayout != null) {
                    Launcher.this.firstLayout.setVisibility(android.view.View.VISIBLE);
                }
            }
        });        
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "---->>> onStart");
        bg.execute(() -> {
            runOnUiThread(() -> {                
                Log.d("Launcher", "onStart: registering dynamic receiver");
                IntentFilter filter = new IntentFilter();
                filter.addAction("android.intent.action.SCREEN_OFF");
                filter.addAction(Intent.ACTION_USER_PRESENT);
                filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
                filter.addAction(Keys.UPDATE_USER_PAGE);
                filter.addAction("pause.button");
                IntentFilter filterCloseSystemDialogs = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                filterCloseSystemDialogs.addAction("com.lsec.pipdie");
                filterCloseSystemDialogs.addAction(colsePipAction);
                filterCloseSystemDialogs.addAction(camera360Action);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    registerReceiver(mReceiver, filter, Context.RECEIVER_EXPORTED);
                    registerReceiver(mCloseSystemDialogsReceiver, filterCloseSystemDialogs, Context.RECEIVER_EXPORTED);
                } else {
                    registerReceiver(mReceiver, filter);
                    registerReceiver(mCloseSystemDialogsReceiver, filterCloseSystemDialogs);
                }
            });
        });
        boolean userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        if (userLayout) {
            WindowUtil.initDefaultApp();
        }
        FirstFrameAnimatorHelper.setIsVisible(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        allowPip = true;
        if (mHomeButtonPressed && isOnMainWorkspaceScreen()) {
            Log.d(TAG, "Home button resume - minimal processing");
            mHomeButtonPressed = false;
            mSkipPostResume = true; // Set flag for onPostResume
            return;
        }
        mSkipPostResume = false;
        isRecreateActive = false;
        Log.d(TAG, "onResume----->");

        // broadcast for CanbusService
        if (mAppsCustomizeTabHost.getVisibility() == View.VISIBLE) {
            Intent intent = new Intent(Keys.ALL_APPS_VISIBLE);
            sendBroadcast(intent);
        }
        helpers = new Helpers();
        helpers.setOpenedFromOverviewBoolean(false);
        helpers.setSettingsOpenedBoolean(false);
        fytData = mPrefs.getBoolean("fyt_data", true); 
        preOnResumeTime = System.currentTimeMillis();
        if (helpers.shouldAllAppsBeVisible()) {
            Launcher.mAppsCustomizeTabHost.setVisibility(View.VISIBLE);
            helpers.setAllAppsShouldBeVisible(false);
        }
        handleView();
        if (Config.CHIP_UIID == 6 && !LauncherApplication.isHaveDvd) {
        }
        if (mOnResumeState == State.WORKSPACE) {
            LogPreview.show("mOnResumeState == State.WORKSPACE");
            showWorkspace(true);
        } else if (mOnResumeState == State.APPS_CUSTOMIZE) {
            showAllApps(true, AppsCustomizePagedView.ContentType.Applications, false);
        }
        mOnResumeState = State.NONE;
        setWorkspaceBackground(mState == State.WORKSPACE);
        mPaused = false;
        sPausedFromUserAction = false;
        if (mRestoring || mOnResumeNeedsLoad) {
            mWorkspaceLoading = true;
            mModel.startLoader(true, -1);        
            mRestoring = false;
            mOnResumeNeedsLoad = false;
        }
        if (mBindOnResumeCallbacks.size() > 0) {
            if (mAppsCustomizeContent != null) {
                mAppsCustomizeContent.setBulkBind(true);
            }
            for (int i = 0; i < mBindOnResumeCallbacks.size(); i++) {
                try {
                    mBindOnResumeCallbacks.get(i).run();
                } catch (Exception e) {
                    Log.e(TAG, "Error BindOnResumeCallbacks: " + e.getMessage());
                }
            }
            if (mAppsCustomizeContent != null) {
                mAppsCustomizeContent.setBulkBind(false);
            }
            mBindOnResumeCallbacks.clear();
        }
        if (mOnResumeCallbacks.size() > 0) {
            for (int i2 = 0; i2 < mOnResumeCallbacks.size(); i2++) {
                mOnResumeCallbacks.get(i2).run();
            }
            mOnResumeCallbacks.clear();
        }
        if (mWaitingForResume != null) {
            mWaitingForResume.setStayPressed(false);
        }
        if (mAppsCustomizeContent != null) {
            mAppsCustomizeContent.resetDrawableState();
        }
        InstallShortcutReceiver.disableAndFlushInstallQueue(this);
        updateVoiceButtonProxyVisible(false);
        updateGlobalIcons();
        if (mWorkspace != null) {
            mWorkspace.reinflateWidgetsIfNecessary();
        } else {
            Log.e(TAG, "Workspace is null in onResume");
        }
        if (mWorkspace.getCustomContentCallbacks() != null && mWorkspace.isOnOrMovingToCustomContent()) {
            mWorkspace.getCustomContentCallbacks().onShow();
        }
        mWorkspace.updateInteractionForState();
        mWorkspace.onResume();
        LauncherNotify.NOTIFIER_MUSIC.addUiRefresher(refreshMusic, true);
        LauncherNotify.NOTIFIER_VIDEO.addUiRefresher(refreshVideo, true);
        LauncherNotify.NOTIFIER_BTAV.addUiRefresher(refreshBtav, true);
        LauncherNotify.NOTIFIER_DVR.addUiRefresher(refreshDvr, true);
        LauncherNotify.NOTIFIER_NAVIVIEW.addUiRefresher(refreshNaviView, false);
        LauncherNotify.NOTIFIER_NAVISTATE.addUiRefresher(refreshNaviState, false);
        tools = CarStates.getCar(app).getTools();
        tools.addRefreshLisenter(1, refreshRadioBand, 0);
        tools.addRefreshLisenter(1, refreshRadioFreq, 1, 2);
        tools.addRefreshLisenter(0, refreshMain, 0, 50, 60, 101, 31, 4);
        tools.addRefreshLisenter(4, refreshMain, 2, 3);
        tools.addRefreshLisenter(7, refreshMain, 1000);
        tools.addRefreshLisenter(2, refreshBtInfo, 0, 1, 2, 28, 26, 13, 9, 7);
        tools.notify(0, 0, 50, 60, 101, 31);
        tools.notify(1, 0);
        tools.notify(1, 1);
        tools.notify(7, 1000);
        tools.notify(2, 0, 1, 2, 28, 26, 13, 9, 7);
        if (firstLayout != null && !isfirstlayout) {
            firstLayout.setVisibility(View.VISIBLE);
        }
        isfirstlayout = false;
        lastpath = null;
        if (showKuwoContent && !AppUtil.isInTheTaskbar(getApplicationContext(), FytPackage.KWACTION)) {
            showKuwoContent = false;
            if (kuwomusic_playpause != null) {
                kuwomusic_playpause.setBackgroundResource(ResValue.getInstance().music_pause_icon);
            }
            if (mKwMusicName != null) {
                mKwMusicName.setText(R.string.car_kuwo);
            }
            if (mKwArtist != null) {
                mKwArtist.setText(R.string.music_author);
            }
        }
        if (mPlayer == null) {
            mPlayer = new MediaPlayer();
        }

        setPlayPauseIcon(true);

        // Poll any pending updateOnce that the app-level receiver saved while launcher was stopped.
        long pending = PendingUpdateStore.pollPendingAndClear(this);
        if (pending > 0) {
            Log.d("onResume", "Found pending updateOnce: " + pending);
            if (!shouldProcessUpdateOnce(pending)) {
                Log.d("Recreate page", "Started (onResume pending)");
                isRecreateActive = true;
                userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false); 
                boolean displayPip = mPrefs.getBoolean(Keys.DISPLAY_PIP, true);
                if (userLayout && displayPip && (helpers.hasLayoutTypeChanged() || helpers.hasBarSettingsChanged() || helpers.hasUserOpenedCreator())) {
                    Log.i("Recreate page", "user layout");
                    WindowUtil.restartMultiplePips();
                    WindowUtil.restartPinnedPipApp();
                }
                helpers.checkAndResetIfOverlappingOnScreen(-1);

                if (mPrefs.getBoolean(Keys.NIGHT_MODE, false)) {
                    Intent nightModeServiceIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                    if (isServiceRunning(NightModeService.class)) {
                        stopService(nightModeServiceIntent);
                    }
                    startService(nightModeServiceIntent);
                }

                if (helpers.hasCorrectionChanged()) {
                    sendBroadcast(new Intent(Keys.RECREATE));
                    helpers.setCorrectionChanged(false);
                }

                helpers.setUserOpenedCreator(false);
                helpers.setBarSettingsChanged(false);

                getWindow().addFlags(Integer.MIN_VALUE);       
                if (mPrefs.getBoolean("transparent_statusbar", false)) {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); 
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                } else {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); 
                }

                recreateView(userLayout);
            } else {
                Log.d("onResume", "Pending updateOnce was duplicate/older; skipping.");
            }
        }

        if (isAllAppsVisible()) {
            WindowUtil.removePip(null);
        } else {
            if (atomicOnCreate.get()) {
                atomicOnCreate.set(false);
                // Proceed without initPip because it starts inside initializeAppList()
                triggerAppData(); 
            } else {
                if (!onWorkspacePip) {
                    onResumePip = true;
                    if (!isRecreateActive || !helpers.onWidgetDropPipBool()) {
                        initPip("onResume", null, false);
                    }
                }
                onWorkspacePip = false;
                onBackPip = false;
            }
        }
    }

    private boolean shouldProcessUpdateOnce(long updateOnce) {
        if (updateOnce < 0) {
            return false; // no updateOnce supplied -> let caller decide (not a duplicate)
        }

        long prev = LAST_PROCESSED_NONCE.get();
        if (updateOnce <= prev) {
            // duplicate/older -> skip
            android.util.Log.d("shouldProcessUpdateOnce", "Duplicate/older updateOnce, skipping. prev: " + prev + " updateOnce: " + updateOnce);
            return true;
        }

        // Try to CAS the new updateOnce; if CAS succeeds, this thread should process it.
        while (true) {
            boolean cas = LAST_PROCESSED_NONCE.compareAndSet(prev, updateOnce);
            android.util.Log.d("shouldProcessUpdateOnce", "CAS attempt: " + cas + ", prev: " + prev + ", updateOnce: " + updateOnce);
            if (cas) {
                // we recorded the new updateOnce -> this is the processor
                return false;
            }
            prev = LAST_PROCESSED_NONCE.get();
            if (updateOnce <= prev) {
                android.util.Log.d("shouldProcessUpdateOnce", "After retry, updateOnce <= prev. skipping. prev: " + prev + " updateOnce: " + updateOnce);
                return true;
            }
            // else retry CAS
        }
    }

    void recreateView(boolean userLayout) {
        Log.d(TAG, "recreateView");

        if (mModel == null || mWorkspace == null) {
            Log.w(TAG, "recreateView: model or workspace null — aborting reload");
            return;
        }

        try {
            Log.d(TAG, "recreateView: forceReload()");
            mModel.forceReload();
        } catch (Exception e) {
            Log.e(TAG, "recreateView: forceReload failed", e);
        }

        mIsInitializingAppData = false;

        try {
            mWorkspace.createUserPage();
            mAppWidgetHost.startListening();
            initViews();
            setupViews();
            bindOnclickListener();
            restoreState(mSavedState);
        } catch (Exception e) {
            Log.e(TAG, "recreateView: setup failed", e);
        }

        // --- Restore visibility of bottom panels ---
        if (userLayout) {
            bottomButtons.setVisibility(View.GONE);
            bottomButtonsWidgets.setVisibility(View.VISIBLE);
        } else {
            bottomButtons.setVisibility(View.VISIBLE);
            bottomButtonsWidgets.setVisibility(View.GONE);
        }

        // --- Restore interaction (fix for immovable shortcuts/widgets) ---
        try {
            // Make workspace focusable & touch-enabled
            mWorkspace.setFocusable(true);
            mWorkspace.setClickable(true);
            mWorkspace.setLongClickable(true);

            // Reattach workspace to drag layer / drag controller if they exist
            if (mDragLayer != null && mWorkspace.getParent() != mDragLayer) {
                mDragLayer.removeAllViews();
                mDragLayer.addView(mWorkspace);
                Log.d(TAG, "recreateView: workspace reattached to drag layer");
            }

            if (mDragController != null) {
                mDragController.setDragScoller(mWorkspace);
                mDragController.setScrollView(mDragLayer);
                mDragController.setMoveTarget(mWorkspace);
                Log.d(TAG, "recreateView: drag controller relinked");
            }
        } catch (Exception e) {
            Log.w(TAG, "recreateView: drag setup skipped", e);
        }

        // --- Re-register your UI elements ---
        LauncherNotify.NOTIFIER_MUSIC.addUiRefresher(Launcher.this.refreshMusic, true);

        Log.d("recreateView", "remove and open Pip");

        mHandler.postDelayed(() -> {
            helpers.setFirstPreferenceWindow(false);
            helpers.setWallpaperWindow(false);
            helpers.setWasInRecents(false);
            closeSystemDialogs();
        }, 250);

        mHandler.postDelayed(() -> {
            getSharedPreferences("HelpersPrefs", 0).edit().clear().commit();
        }, 350);

        triggerAppData();

        // --- Post layout stabilization ---
        mHandler.postDelayed(() -> {
            try {
                mWorkspace.requestLayout();
                mWorkspace.invalidate();
                Log.d(TAG, "recreateView: layout refresh done");
            } catch (Exception e) {
                Log.w(TAG, "recreateView: post layout refresh failed", e);
            }
        }, 200);
    }

    private void initPip(String whereInitiated, View view, boolean forceOpen) {
        // mWorkspace.getCurrentPage() is determined with slight delay
        mHandler.postDelayed(()-> {
            if (helpers.displayStateBoolean()
                && !helpers.isFirstPreferenceWindow() 
                && !helpers.isWallpaperWindow() 
                && !helpers.isInOverviewMode()
                && !mDragController.isDragging()
                && !helpers.allAppsVisibility(mAppsCustomizeTabHost.getVisibility())
                || (!helpers.userWasInRecents() && helpers.isListOpen()) || forceOpen) {

                    Log.d(whereInitiated, "startMapPip");
                    WindowUtil.startMapPip(view, forceOpen);

            }
            helpers.setFirstPreferenceWindow(false);
            helpers.setWallpaperWindow(false);
            helpers.setWasInRecents(false);
        }, 250);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        helpers.setWidgetDropPip(false);
        if (mSkipPostResume) {
            mSkipPostResume = false;
            Log.d(TAG, "Skipping onPostResume due to home button");
            return;
        }

        SharedPreferences.Editor editor = mPrefs.edit();
        editor = mPrefs.edit();
        editor.putBoolean("user_init_layout", mPrefs.getBoolean(Keys.USER_LAYOUT, false));
        editor.apply();

        if (!isServiceRunning(NightModeService.class) && mPrefs.getBoolean(Keys.NIGHT_MODE, false) && helpers.displayStateBoolean()) {
            mHandler.postDelayed(() -> {
                Intent nightModeServiceIntent = new Intent(LauncherApplication.sApp, NightModeService.class);
                startService(nightModeServiceIntent);
            }, 7000);
        }

        if (!isServiceRunning(CanbusService.class)) {
            mHandler.postDelayed(() -> {
                new CanbusAsyncTask(LauncherApplication.sApp).execute();
            }, 7000); 
        }
        final boolean alreadyOnHome = mHasFocus;

        if (mWorkspace == null) {
            // Can be cases where mWorkspace is null, this prevents a NPE
            return;
        }
        Folder openFolder = mWorkspace.getOpenFolder();
        // In all these cases, only animate if we're already on home
        mWorkspace.exitWidgetResizeMode();
        if (alreadyOnHome && mState == State.WORKSPACE && !mWorkspace.isTouchActive() &&
                openFolder == null) {
            mWorkspace.moveToDefaultScreen(true);
        }

        if (atomicInitAppData.get()) {
            bg.execute(() -> {
                List<AppMultiple> data = LitePal.findAll(AppMultiple.class, new long[0]);
                List<LeftAppMultiple> left = LitePal.findAll(LeftAppMultiple.class, new long[0]);
                // process data off main thread if possible
                runOnUiThread(() -> {
                    refreshCycle(data);
                    refreshLeftBar(left);
                });
            });
        } 

        weatherHandler.post(periodicWeatherCheck);

        mHandler.postDelayed(()-> {
            closeSystemDialogs();
        }, 250);

        mHandler.postDelayed(() -> {
            onBackPip = false;
            onResumePip = false; 
        }, 1500); 
    }

    @Override 
    protected void onPause() {
        super.onPause();
        allowPip = false;
        cleanWidgetBar();
        if (mHomeButtonPressed && isOnMainWorkspaceScreen()) return;
        Log.d(TAG, "---->>> onPause");
        mHandler.postDelayed(()-> {
            if (Utils.topApp(FytPackage.hicarAction)
                || Utils.topApp(FytPackage.fourcamera2Action)) {
                WindowUtil.removePip(this.pipViews);
            }
        }, 100);        
        InstallShortcutReceiver.enableInstallQueue();
        mPaused = true;
        mDragController.cancelDrag();
        mDragController.resetLastGestureUpTime();
        LauncherNotify.NOTIFIER_MUSIC.removeUiRefresher(refreshMusic);
        LauncherNotify.NOTIFIER_VIDEO.removeUiRefresher(refreshVideo);
        LauncherNotify.NOTIFIER_BTAV.removeUiRefresher(refreshBtav);
        LauncherNotify.NOTIFIER_DVR.removeUiRefresher(refreshDvr);
        LauncherNotify.NOTIFIER_NAVIVIEW.removeUiRefresher(refreshNaviView);
        LauncherNotify.NOTIFIER_NAVISTATE.removeUiRefresher(refreshNaviState);
        clearGaoDeData();
        if (mWorkspace.getCustomContentCallbacks() != null) {
            mWorkspace.getCustomContentCallbacks().onHide();
        }
        if(mPlayer != null) {
            if(mPlayer.isPlaying()) {
                mPlayer.stop();
            }
            mPlayer.reset();
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "---->>> onStop");
        Log.d("onStop", "removePip");
        WindowUtil.removePip(pipViews);
        isfirstlayout = true;
        FirstFrameAnimatorHelper.setIsVisible(false);
        if(mPlayer != null) {
            if(mPlayer.isPlaying()) {
                mPlayer.stop();
            }
            mPlayer.reset();
            mPlayer.release();
            mPlayer = null;
        }
        Log.d("Launcher", "onStop: unregistering dynamic receiver");
        try {
            unregisterReceiver(mReceiver);
            unregisterReceiver(mCloseSystemDialogsReceiver);
        } catch (Exception e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
        }
        weatherHandler.removeCallbacks(periodicWeatherCheck);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "---->>> onDestroy");
        Log.d("onDestroy", "removePip");
        WindowUtil.removePip(pipViews);
        tools.removeRefreshLisenter(0, refreshMain);
        tools.removeRefreshLisenter(4, refreshMain);
        tools.removeRefreshLisenter(7, refreshMain);
        tools.removeRefreshLisenter(2, refreshBtInfo);
        unregisterReceiver(removeMusic);
        unregisterReceiver(mAutoMap);
        unregisterReceiver(mTrifficReceiver);
        mHandler.removeMessages(1);
        mHandler.removeMessages(0);
        mWorkspace.removeCallbacks(mBuildLayersRunnable);
        LauncherAppState app = LauncherAppState.getInstance();
        if (isChangingConfigurations()) {
            // Check if the loader should be stopped (using ViewModel logic)
            if (mViewModel.shouldStopLoader()) {
                mModel.stopLoader();
            }
            // Release UI resources
            if (mAppsCustomizeContent != null) {
                mAppsCustomizeContent.surrender();
            }
        } else {
            // Activity is permanently destroyed
            mModel.stopLoader();
            if (mAppsCustomizeContent != null) {
                mAppsCustomizeContent.surrender();
            }
        }
        app.setLauncher(null);
        try {
            mAppWidgetHost.stopListening();
            mAppWidgetHost = null;
        } catch (NullPointerException ex) {
            Log.w(TAG, "problem while stopping AppWidgetHost during Launcher destruction", ex);
        }
        mWidgetsToAdvance.clear();
        TextKeyListener.getInstance().release();
        if (mModel != null) {
            mModel.unbindItemInfosAndClearQueuedBindRunnables();
        }
        getContentResolver().unregisterContentObserver(mWidgetObserver);
        mDragLayer.clearAllResizeFrames();
        ((ViewGroup) mWorkspace.getParent()).removeAllViews();
        mWorkspace.removeAllViews();
        mWorkspace.onWorkspaceDestroy();
        mDragController = null;
        mWorkspace = null;
        ivALbumBg = null;
        ivALbumBgTwo = null;
        tvMusicNameTwo = null;
        tvAritstTwo = null;
        weatherImg1 = null;
        weatherCity1 = null;
        weatherTemp = null;
        weatherWeather1 = null;
        clearAllCustomViews();
        LauncherAnimUtils.onDestroyActivity();
        stopServicesOnDestroy();
    }    

    public static boolean isServiceRunning(Class<? extends Service> serviceClass) {
        ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            for (ActivityManager.RunningServiceInfo service : runningServices) {
                if (serviceClass.getName().equals(service.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void stopServicesOnDestroy() {
        stopService(new Intent(LauncherApplication.sApp, WakeDetectionService.class));
        stopService(new Intent(LauncherApplication.sApp, NightModeService.class));  
        stopService(new Intent(LauncherApplication.sApp, CanbusService.class));   
    }

    // Handle widget click events
    @Override
    public void onWidgetClicked(int appWidgetId) {
        helpers.setWidgetClicked(true);
        handler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                String widgetPkgName = Launcher.this.getWidgetPackageName(appWidgetId);
                
                ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
                for(ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                    if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND 
                    && appProcess.importanceReasonCode == ActivityManager.RunningAppProcessInfo.REASON_UNKNOWN) { 
                        if (appProcess.processName.contains(":")) {
                            appProcess.processName = appProcess.processName.substring(0, appProcess.processName.indexOf(":"));
                        }

                        if (widgetPkgName.contains(appProcess.processName)) {
                            //Log.d("WidgetClick", "Clicked Widget ID: " + appWidgetId + " package name: " + widgetPkgName + " foreground activity: " + appProcess.processName);
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(widgetPkgName);
                            try {
                                ComponentName componentName = launchIntent.getComponent();
                                PackageManager pm = getPackageManager();
                                ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                                String appTitle = appInfo.loadLabel(pm).toString();
                                AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                                Launcher.this.refreshLeftCycle(bean);
                                cleanWidgetBar();
                            } catch (PackageManager.NameNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
                helpers.setWidgetClicked(false);
            }
        }, 1000);
    }

    public String getWidgetPackageName(int widgetId) {
        AppWidgetProviderInfo providerInfo = mAppWidgetManager.getAppWidgetInfo(widgetId);
        
        if (providerInfo != null) {
            ComponentName provider = providerInfo.provider;
            if (provider != null) {
                return provider.getPackageName();
            }
        }
        return ""; 
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

    public void pipOverview() {
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        boolean userStats = mPrefs.getBoolean(Keys.USER_STATS, false);
        if (userLayout && userStats) {
            helpers.setPipStarted(true);
            helpers.setForegroundAppOpened(false);
            helpers.setInAllApps(false);
            helpers.setInWidgets(false);
            helpers.setInRecent(false);
            helpers.setInOverviewMode(false);
            Intent intentpip = new Intent(Keys.PIP_STARTED);
            sendBroadcast(intentpip);
        }
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private void initRegisterReceiver() {
        IntentFilter musicFilter = new IntentFilter();
        musicFilter.addAction("com.fyt.systemui.remove");
        this.mAutoMap = new MyAutoMapReceiver();
        IntentFilter amapFilter = new IntentFilter();
        amapFilter.addAction("AUTONAVI_STANDARD_BROADCAST_SEND");
        this.mTrifficReceiver = new TrifficReceiver();
        IntentFilter trifficFilter = new IntentFilter();
        trifficFilter.addAction("intent.action.mapgoo.simtool.info.triffic.v2");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(this.removeMusic, musicFilter, Context.RECEIVER_EXPORTED);
            registerReceiver(this.mAutoMap, amapFilter, Context.RECEIVER_EXPORTED);
            registerReceiver(this.mTrifficReceiver, trifficFilter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(this.removeMusic, musicFilter);
            registerReceiver(this.mAutoMap, amapFilter);
            registerReceiver(this.mTrifficReceiver, trifficFilter);
        }
    }

    public void updateView() {
        if (mTvSettings != null) {
            mTvSettings.setText(R.string.car_settings);
        }
        if (mTvCar != null) {
            mTvCar.setText(R.string.car_car);
        }
        if (mTvNavi != null) {
            mTvNavi.setText(R.string.car_navi);
        }
        if (mTvMusic != null) {
            mTvMusic.setText(R.string.car_music);
        }
        if (mTvRadio != null) {
            mTvRadio.setText(R.string.car_radio);
        }
        if (mMiuDrive != null) {
            mMiuDrive.setText(R.string.car_miu_drive);
        }
        if (mTvAux != null) {
            mTvAux.setText(R.string.car_aux);
        }
        if (mTvBt != null) {
            mTvBt.setText(R.string.car_bt);
        }
        if (mTvMovie != null) {
            mTvMovie.setText(R.string.car_video);
        }
        if (mTvFile != null) {
            mTvFile.setText(R.string.car_file);
        }
        if (mTvGallery != null) {
            mTvGallery.setText(R.string.car_gallery);
        }
        if (mTvDVR != null) {
            mTvDVR.setText(R.string.car_dvr);
        }
        if (mTvApps != null) {
            mTvApps.setText(R.string.car_app);
        }
        if (mKwMusicName != null) {
            mKwMusicName.setText(R.string.car_kuwo);
        }
        if (mKwArtist != null) {
            mKwArtist.setText(R.string.music_author);
        }
        if (mTvBtPhoneName != null) {
            mTvBtPhoneName.setText(R.string.car_bt_notconnect);
        }
        if (mTvCanbus != null) {
            mTvCanbus.setText(R.string.car_canbus);
        }
        if (mTvGuide != null) {
            mTvGuide.setText(Utils.getNameToStr("car_guide"));
        }
        if (mTvCalculator != null) {
            mTvCalculator.setText(Utils.getNameToStr("car_calculator"));
        }
        if (mTvEq != null) {
            mTvEq.setText(R.string.car_eq);
        }
    }

    private Runnable periodicWeatherCheck = new Runnable() {
        @Override
        public void run() {
            updateWeather();
            
            weatherHandler.postDelayed(this, WEATHER_INTERVAL);
        }
    };

    public void updateWeather() {
        if (weatherManager == null) {
            weatherManager = WeatherManager.initialize(this);
        }
        weatherManager.updateWeather();
        showWeatherInfo();
    }

    public void showWeatherInfo() {
        if (this.weatherManager != null) {
            this.weatherManager.addOnWeatherChangedListener(new WeatherManager.OnWeatherChangedListener() { 
                @Override 
                public void onWeatherChanged(WeatherDescription weather) {
                    if (weather != null) {
                        if (Launcher.this.weatherImg != null) {
                            Launcher.this.weatherImg.setImageResource(WeatherUtils.getResId("weather" + weather.getIconCode()));
                        }
                        String range = weather.getTemDescription().replaceAll("\\.\\d", "");
                        String temp = weather.getCurTem().replaceAll("\\.\\d", "");
                        if (Launcher.this.weatherCity != null) {
                            Launcher.this.weatherCity.setText(new StringBuilder(String.valueOf(weather.getCity())).toString());
                        }
                        if (Launcher.this.weatherWeather != null) {
                            Launcher.this.weatherWeather.setText(new StringBuilder(WeatherUtils.translateDescription(String.valueOf(weather.getWeather()))).toString());
                        }
                        if (Launcher.this.weatherTemp != null) {
                            Launcher.this.weatherTemp.setText(new StringBuilder(String.valueOf(temp)).toString());
                        }
                        if (Launcher.this.weatherTempRange != null) {
                            Launcher.this.weatherTempRange.setText(new StringBuilder(String.valueOf(range)).toString());
                        }
                        if (Launcher.this.weatherImg1 != null) {
                            Launcher.this.weatherImg1.setImageResource(WeatherUtils.getResId("weather" + weather.getIconCode()));
                        }
                        if (Launcher.this.weatherCity1 != null) {
                            Launcher.this.weatherCity1.setText(new StringBuilder(String.valueOf(weather.getCity())).toString());
                        }
                        if (Launcher.this.weatherWeather1 != null) {
                            Launcher.this.weatherWeather1.setText(new StringBuilder(WeatherUtils.translateDescription(String.valueOf(weather.getWeather()))).toString());
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

    @Override
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
        if (mSearchDropTargetBar != null) {
            mSearchDropTargetBar.onSearchPackagesChanged(searchVisible, voiceVisible);
        }
    }

    private void checkForLocaleChange() {
        if (sLocaleConfiguration == null) {
            new AsyncTask<Void, Void, LocaleConfiguration>() {
                @Override
                protected LocaleConfiguration doInBackground(Void[] unused) {
                    LocaleConfiguration localeConfiguration = new LocaleConfiguration();
                    readConfiguration(Launcher.this, localeConfiguration);
                    return localeConfiguration;
                }

                @Override
                protected void onProgress(Void[] progress) {
                    //
                }

                @Override
                protected void onPostExecute(LocaleConfiguration result) {
                    sLocaleConfiguration = result;
                    checkForLocaleChange();  // recursive, but now with a locale configuration
                }

                @Override
                protected void onBackgroundError(Exception e) {
                    //
                }
            }.execute();
            return;
        }

        final Configuration configuration = getResources().getConfiguration();

        final String previousLocale = sLocaleConfiguration.locale;
        final String locale = configuration.locale.toString();

        final int previousMcc = sLocaleConfiguration.mcc;
        final int mcc = configuration.mcc;

        final int previousMnc = sLocaleConfiguration.mnc;
        final int mnc = configuration.mnc;

        boolean localeChanged = !locale.equals(previousLocale) || mcc != previousMcc || mnc != previousMnc;

        if (localeChanged) {
            sLocaleConfiguration.locale = locale;
            sLocaleConfiguration.mcc = mcc;
            sLocaleConfiguration.mnc = mnc;

            mIconCache.flush();

            final LocaleConfiguration localeConfiguration = sLocaleConfiguration;
            new Thread("WriteLocaleConfiguration") {
                @Override
                public void run() {
                    writeConfiguration(Launcher.this, localeConfiguration);
                }
            }.start();
        }
    }

    private static class LocaleConfiguration {
        public String locale;
        public int mcc = -1;
        public int mnc = -1;
    }

    private static void readConfiguration(Context context, LocaleConfiguration configuration) {
        DataInputStream in = null;
        try {
            in = new DataInputStream(context.openFileInput(PREFERENCES));
            configuration.locale = in.readUTF();
            configuration.mcc = in.readInt();
            configuration.mnc = in.readInt();
        } catch (FileNotFoundException e) {
            // Ignore
        } catch (IOException e) {
            // Ignore
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }

    private static void writeConfiguration(Context context, LocaleConfiguration configuration) {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(context.openFileOutput(PREFERENCES, MODE_PRIVATE));
            out.writeUTF(configuration.locale);
            out.writeInt(configuration.mcc);
            out.writeInt(configuration.mnc);
            out.flush();
        } catch (FileNotFoundException e) {
            // Ignore
        } catch (IOException e) {
            //noinspection ResultOfMethodCallIgnored
            context.getFileStreamPath(PREFERENCES).delete();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }

    public Stats getStats() {
        return mStats;
    }

    public LayoutInflater getInflater() {
        return mInflater;
    }

    public View getAllAppsButton() {
        return mAllAppsButton;
    }

    public DragLayer getDragLayer() {
        return mDragLayer;
    }

    public static boolean isDraggingEnabled() {
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

    /**
     * Returns whether we should delay spring loaded mode -- for shortcuts and widgets that have
     * a configuration step, this allows the proper animations to run after other transitions.
     */
    private boolean completeAdd(PendingAddArguments args) {
        boolean result = false;
        switch (args.requestCode) {
            case REQUEST_PICK_APPLICATION:
                completeAddApplication(args.intent, args.container, args.screenId, args.cellX,
                        args.cellY);
                break;
            case REQUEST_PICK_SHORTCUT:
                processShortcut(args.intent);
                break;
            case REQUEST_CREATE_SHORTCUT:
                completeAddShortcut(args.intent, args.container, args.screenId, args.cellX,
                        args.cellY);
                result = true;
                break;
            case REQUEST_CREATE_APPWIDGET:
                Log.i("WIDGET", "REQUEST_CREATE_APPWIDGET");
                int appWidgetId = args.intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
                completeAddAppWidget(appWidgetId, args.container, args.screenId, null, null);
                result = true;
                break;
        }
        // Before adding this resetAddInfo(), after a shortcut was added to a workspace screen,
        // if you turned the screen off and then back while in All Apps, Launcher would not
        // return to the workspace. Clearing mAddInfo.container here fixes this issue
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mWaitingForResult = false;
        int pendingAddWidgetId = mPendingAddWidgetId;
        mPendingAddWidgetId = -1;

        if (requestCode == REQUEST_BIND_APPWIDGET) {
            Log.i("WIDGET", "REQUEST_BIND_APPWIDGET");
            int appWidgetId = data != null ?
                    data.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1) : -1;


            if (resultCode == RESULT_CANCELED) {
                completeTwoStageWidgetDrop(RESULT_CANCELED, appWidgetId);
            } else if (resultCode == RESULT_OK) {
                addAppWidgetImpl(appWidgetId, mPendingAddInfo, null, mPendingAddWidgetInfo);
            }
            return;
        } else if (requestCode == REQUEST_PICK_WALLPAPER) {
            if (resultCode == RESULT_OK && mWorkspace.isInOverviewMode()) {
                mWorkspace.exitOverviewMode(false);
            }
            return;
        }

        boolean delayExitSpringLoadedMode = false;
        boolean isWidgetDrop = (requestCode == REQUEST_PICK_APPWIDGET ||
                requestCode == REQUEST_CREATE_APPWIDGET);

        // We have special handling for widgets
        if (isWidgetDrop) {
            Log.i("WIDGET", "isWidgetDrop");
            int appWidgetId = data != null ?
                    data.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, -1) : -1;
            if (appWidgetId < 0) {
                appWidgetId = pendingAddWidgetId;
                try {
                    completeTwoStageWidgetDrop(resultCode, appWidgetId);
                } catch (Exception e) {
                    Log.e(TAG, "appWidgetId (EXTRA_APPWIDGET_ID) was not returned from the widget configuration activity. Error: " + e.getMessage());
                    completeTwoStageWidgetDrop(RESULT_CANCELED, appWidgetId);                    
                }
            } else {
                completeTwoStageWidgetDrop(resultCode, appWidgetId);
            }
            mWorkspace.triggerStripEmptyScreens("Launcher, onActivityResult(), 1", false);
            return;
        }

        // The pattern used here is that a user PICKs a specific application,
        // which, depending on the target, might need to CREATE the actual target.

        // For example, the user would PICK_SHORTCUT for "Music playlist", and we
        // launch over to the Music app to actually CREATE_SHORTCUT.
        if (resultCode == RESULT_OK && mPendingAddInfo.container != ItemInfo.NO_ID) {
            final PendingAddArguments args = new PendingAddArguments();
            args.requestCode = requestCode;
            args.intent = data;
            args.container = mPendingAddInfo.container;
            args.screenId = mPendingAddInfo.screenId;
            args.cellX = mPendingAddInfo.cellX;
            args.cellY = mPendingAddInfo.cellY;
            if (isWorkspaceLocked()) {
                sPendingAddList.add(args);
            } else {
                delayExitSpringLoadedMode = completeAdd(args);
            }
        } else if (resultCode == RESULT_CANCELED) {
            mWorkspace.triggerStripEmptyScreens("Launcher, onActivityResult(), 2", false);
        }
        mDragLayer.clearAnimatedView();
        // Exit spring loaded mode if necessary after cancelling the configuration of a widget
        exitSpringLoadedDragModeDelayed((resultCode != RESULT_CANCELED), delayExitSpringLoadedMode,
                null);
    }
    
    private void completeTwoStageWidgetDrop(final int resultCode, final int appWidgetId) {
        CellLayout cellLayout =
                (CellLayout) mWorkspace.getScreenWithId(mPendingAddInfo.screenId);
        Runnable onCompleteRunnable = null;
        int animationType = 0;

        AppWidgetHostView boundWidget = null;
        if (resultCode == RESULT_OK) {
            animationType = Workspace.COMPLETE_TWO_STAGE_WIDGET_DROP_ANIMATION;
            final AppWidgetHostView layout = mAppWidgetHost.createView(LauncherApplication.sApp, appWidgetId,
                    mPendingAddWidgetInfo);
            boundWidget = layout;
            onCompleteRunnable = new Runnable() {
                @Override
                public void run() {
                    Log.i("WIDGET", "completeTwoStageWidgetDrop");
                    completeAddAppWidget(appWidgetId, mPendingAddInfo.container,
                            mPendingAddInfo.screenId, layout, null);
                    exitSpringLoadedDragModeDelayed((resultCode != RESULT_CANCELED), false,
                            null);
                }
            };
        } else if (resultCode == RESULT_CANCELED) {
            animationType = Workspace.CANCEL_TWO_STAGE_WIDGET_DROP_ANIMATION;
            onCompleteRunnable = new Runnable() {
                @Override
                public void run() {
                    //mWorkspace.stripEmptyScreensBaseOnDB();
                    exitSpringLoadedDragModeDelayed((resultCode != RESULT_CANCELED), false,
                            null);
                }
            };
        }
        if (mDragLayer.getAnimatedView() != null) {
            mWorkspace.animateWidgetDrop(mPendingAddInfo, cellLayout,
                    (DragView) mDragLayer.getAnimatedView(), onCompleteRunnable,
                    animationType, boundWidget, true);
        } else {
            // The animated view may be null in the case of a rotation during widget configuration
            if (onCompleteRunnable != null) {
                final Runnable completeR = onCompleteRunnable;
                Runnable r = new Runnable() {
                    private int mCountDown = 20;
                    @Override
                    public void run() {
                        if (mCountDown-- > 0) {
                            if (mWorkspace != null) {
                                if (mWorkspace.getScreenWithId(mPendingAddInfo.screenId) == null) {
                                    mWorkspace.postDelayed(this, 200);
                                } else {
                                    completeR.run();
                                }
                            }
                        } else {
                            Log.e(TAG, String.format("after about %d ms, workspace still not ready for insert widget."
                                    , 20 * 200));
                        }
                    }
                };
                r.run();
            }
        }
    }

    public void setSoundBtn() {
        if (getCustomView(Config.SOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.SOUND)).setBackgroundResource(R.drawable.car_sound_icon);
        }
        if (getCustomView(Config.CLOLSESOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.CLOLSESOUND)).setBackgroundResource(R.drawable.car_sound_icon);
        }
        if (getCustomView(Config.WS_SOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.WS_SOUND)).setBackgroundResource(R.drawable.car_sound_icon);
        }
        if (getCustomView(Config.WS_CLOSESOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.WS_CLOSESOUND)).setBackgroundResource(R.drawable.car_sound_icon);
        }
    }

    public void setSoundCloseBtn() {
        if (getCustomView(Config.SOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.SOUND)).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
        if (getCustomView(Config.CLOLSESOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.CLOLSESOUND)).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
        if (getCustomView(Config.WS_SOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.WS_SOUND)).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
        if (getCustomView(Config.WS_CLOSESOUND) != null) {
            Objects.requireNonNull(getCustomView(Config.WS_CLOSESOUND)).setBackgroundResource(R.drawable.car_sound_close_icon);
        }
    }

    protected void onFinishBindingItems() {
        if (mWorkspace != null && hasCustomContentToLeft() && mWorkspace.hasCustomContent()) {
            addCustomContentToLeft();
        }
    }

    public void resetQSBScroll() {
        mSearchDropTargetBar.animate().translationY(0.0f).start();
        getQsbBar().animate().translationY(0.0f).start();
    }

    protected void startSettings() {
    }

    public QSBScroller addToCustomContentPage(View customContent, CustomContentCallbacks callbacks, String description) {
        mWorkspace.addToCustomContentPage(customContent, callbacks, description);
        return mQsbScroller;
    }

    public int getTopOffsetForCustomContent() {
        return mWorkspace.getPaddingTop();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mHasFocus = hasFocus;
    }

    private boolean acceptFilter() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        return !inputManager.isFullscreenMode();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int uniChar = event.getUnicodeChar();
        boolean handled = super.onKeyDown(keyCode, event);
        boolean isKeyNotWhitespace = uniChar > 0 && !Character.isWhitespace(uniChar);
        if (!handled && acceptFilter() && isKeyNotWhitespace) {
            boolean gotKey = TextKeyListener.getInstance().onKeyDown(mWorkspace, mDefaultKeySsb, keyCode, event);
            if (gotKey && mDefaultKeySsb != null && mDefaultKeySsb.length() > 0) {
                return onSearchRequested();
            }
        }
        if (keyCode == 82 && event.isLongPress()) {
            return true;
        }
        return handled;
    }

    private String getTypedText() {
        return mDefaultKeySsb.toString();
    }

    private void clearTypedText() {
        mDefaultKeySsb.clear();
        mDefaultKeySsb.clearSpans();
        Selection.setSelection(mDefaultKeySsb, 0);
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
                mOnResumeState = State.APPS_CUSTOMIZE;
            }
            int currentScreen = savedState.getInt(RUNTIME_STATE_CURRENT_SCREEN, PagedView.INVALID_RESTORE_PAGE);
            if (currentScreen != -1001) {
                mWorkspace.setRestorePage(currentScreen);
            }
            long pendingAddContainer = savedState.getLong(RUNTIME_STATE_PENDING_ADD_CONTAINER, -1L);
            long pendingAddScreen = savedState.getLong(RUNTIME_STATE_PENDING_ADD_SCREEN, -1L);
            if (pendingAddContainer != -1 && pendingAddScreen > -1) {
                mPendingAddInfo.container = pendingAddContainer;
                mPendingAddInfo.screenId = pendingAddScreen;
                mPendingAddInfo.cellX = savedState.getInt(RUNTIME_STATE_PENDING_ADD_CELL_X);
                mPendingAddInfo.cellY = savedState.getInt(RUNTIME_STATE_PENDING_ADD_CELL_Y);
                mPendingAddInfo.spanX = savedState.getInt(RUNTIME_STATE_PENDING_ADD_SPAN_X);
                mPendingAddInfo.spanY = savedState.getInt(RUNTIME_STATE_PENDING_ADD_SPAN_Y);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                    mPendingAddWidgetInfo = savedState.getParcelable(
                        RUNTIME_STATE_PENDING_ADD_WIDGET_INFO, 
                        AppWidgetProviderInfo.class
                    );
                } else {
                    mPendingAddWidgetInfo = savedState.getParcelable(
                        RUNTIME_STATE_PENDING_ADD_WIDGET_INFO
                    );
                }
                mPendingAddWidgetId = savedState.getInt(RUNTIME_STATE_PENDING_ADD_WIDGET_ID);
                mWaitingForResult = true;
                mRestoring = true;
            }
            boolean renameFolder = savedState.getBoolean(RUNTIME_STATE_PENDING_FOLDER_RENAME, false);
            if (renameFolder) {
                long id = savedState.getLong(RUNTIME_STATE_PENDING_FOLDER_RENAME_ID);
                mFolderInfo = mModel.getFolderById(this, sFolders, id);
                mRestoring = true;
            }
            if (mAppsCustomizeTabHost != null) {
                String curTab = savedState.getString("apps_customize_currentTab");
                if (curTab != null) {
                    mAppsCustomizeTabHost.setContentTypeImmediate(mAppsCustomizeTabHost.getContentTypeForTabTag(curTab));
                    mAppsCustomizeContent.loadAssociatedPages(mAppsCustomizeContent.getCurrentPage());
                }
                int currentIndex = savedState.getInt("apps_customize_currentIndex");
                mAppsCustomizeContent.restorePageForIndex(currentIndex);
            }
        }
    }

    public void putCustomView(String key, View view) {
        if (view == null) return;
        customViewMap.put(key, view);
    }

    @Nullable
    public View getCustomView(String key) {
        if (customViewMap == null) return null; 
        return customViewMap.get(key);
    }

    public void clearAllCustomViews() {
        try {
            Map<String, View> map = this.customViewMap;
            if (map == null || map.isEmpty()) return;
            for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String, View> e = it.next();
                View v = e.getValue();
                if (v != null) {
                    try {
                        v.setOnClickListener(null);
                        v.setOnLongClickListener(null);
                        v.setOnTouchListener(null);
                    } catch (Throwable ignored) {}
                    if (v.getParent() instanceof ViewGroup) {
                        try {
                            ((ViewGroup) v.getParent()).removeView(v);
                        } catch (Throwable ignored) {}
                    }
                }
                it.remove();
            }
            map.clear();
        } catch (Throwable t) {
            Log.w("Launcher", "clearAllCustomViews failed", t);
        }
    }

    public void removeCustomView(String key) {
        if (key == null) return;
        try {
            Map<String, View> map = this.customViewMap; // adjust name if different
            if (map == null) return;
            View v = map.remove(key);
            if (v != null) {
                // detach listeners we may have added from Launcher side (best-effort)
                try {
                    v.setOnClickListener(null);
                    v.setOnLongClickListener(null);
                    v.setOnTouchListener(null);
                } catch (Throwable ignored) {}

                // remove from parent if any
                if (v.getParent() instanceof ViewGroup) {
                    try {
                        ((ViewGroup) v.getParent()).removeView(v);
                    } catch (Throwable ignored) {}
                }
            }
        } catch (Throwable t) {
            Log.w("Launcher", "removeCustomView failed for key=" + key, t);
        }
    }

    private void initHashMap() {
        if (mHotseat != null) {
            putCustomView(Config.NAVI, mHotseat.findViewById(ResValue.getInstance().m_navi_btn));
            putCustomView(Config.VOICE, mHotseat.findViewById(ResValue.getInstance().m_voice_btn));
            putCustomView(Config.SETTING, mHotseat.findViewById(ResValue.getInstance().m_set_btn));
            putCustomView(Config.VIDEO, mHotseat.findViewById(ResValue.getInstance().m_video_btn));
            putCustomView(Config.BT, mHotseat.findViewById(ResValue.getInstance().m_bt_btn));
            putCustomView(Config.RADIO, mHotseat.findViewById(ResValue.getInstance().m_radio_btn));
            putCustomView(Config.MUSIC, mHotseat.findViewById(ResValue.getInstance().m_music_btn));
            putCustomView(Config.BTAV, mHotseat.findViewById(ResValue.getInstance().m_btav_btn));
            putCustomView(Config.ECAR, mHotseat.findViewById(ResValue.getInstance().m_ecar_btn));
            putCustomView(Config.SOS, mHotseat.findViewById(ResValue.getInstance().m_sos_btn));
            putCustomView(Config.KUWO, mHotseat.findViewById(ResValue.getInstance().m_kuwo_btn));
            putCustomView(Config.UNICAR, mHotseat.findViewById(ResValue.getInstance().m_unicar_btn));
            putCustomView(Config.KLFM, mHotseat.findViewById(ResValue.getInstance().m_klfm_btn));
            putCustomView(Config.HONGFANS, mHotseat.findViewById(ResValue.getInstance().m_hongfans_btn));
            putCustomView(Config.DVR, mHotseat.findViewById(ResValue.getInstance().m_dvr_btn));
            putCustomView(Config.LIGHT, mHotseat.findViewById(ResValue.getInstance().m_light_btn));
            putCustomView(Config.CLOLSESCREEN, mHotseat.findViewById(ResValue.getInstance().m_screen_btn));
            putCustomView(Config.WIFI, mHotseat.findViewById(ResValue.getInstance().m_wifi_btn));
            putCustomView(Config.SOUND, mHotseat.findViewById(ResValue.getInstance().m_sound_btn));
            putCustomView(Config.CLOLSESOUND, mHotseat.findViewById(ResValue.getInstance().m_closesound_btn));
            putCustomView(Config.BRIGHT, mHotseat.findViewById(ResValue.getInstance().m_bright_btn));
            putCustomView(Config.EQ, mHotseat.findViewById(ResValue.getInstance().m_eq_btn));
            putCustomView(Config.TIME, mHotseat.findViewById(ResValue.getInstance().m_time_btn));
            putCustomView(Config.ALLAPP, mHotseat.findViewById(ResValue.getInstance().m_allapp_btn));
            putCustomView(Config.BROWSER, mHotseat.findViewById(ResValue.getInstance().m_browser_btn));
            putCustomView(Config.NEWEYE, mHotseat.findViewById(ResValue.getInstance().m_neweye_btn));
            putCustomView(Config.CANBUS, mHotseat.findViewById(ResValue.getInstance().m_canbus_btn));
            putCustomView(Config.FILE, mHotseat.findViewById(ResValue.getInstance().m_file_btn));
            mHotseatApps = (TextView) mHotseat.findViewById(ResValue.getInstance().hotseat_apps);
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.weather_show)) {
                weatherImg = (ImageView) mHotseat.findViewById(ResValue.getInstance().weather_imge);
                weatherCity = (TextView) mHotseat.findViewById(ResValue.getInstance().weather_city);
                weatherWeather = (TextView) mHotseat.findViewById(ResValue.getInstance().weather_weather);
                weatherTemp = (TextView) mHotseat.findViewById(ResValue.getInstance().weather_temp);
                weatherTempRange = (TextView) mHotseat.findViewById(ResValue.getInstance().weather_temp_range);
                weatherTempRange1 = (TextView) mHotseat.findViewById(ResValue.getInstance().weather_temp_range1);
                weatherWind = (TextView) mHotseat.findViewById(ResValue.getInstance().weather_wind);
            }
            if (getCustomView(Config.NAVI) != null) {
                getCustomView(Config.NAVI).setOnClickListener(this);
            }
            if (getCustomView(Config.VOICE) != null) {
                getCustomView(Config.VOICE).setOnClickListener(this);
            }
            if (getCustomView(Config.SETTING) != null) {
                getCustomView(Config.SETTING).setOnClickListener(this);
            }
            if (getCustomView(Config.VIDEO) != null) {
                getCustomView(Config.VIDEO).setOnClickListener(this);
            }
            if (getCustomView(Config.BRIGHT) != null) {
                getCustomView(Config.BRIGHT).setOnClickListener(this);
            }
            if (getCustomView(Config.BT) != null) {
                getCustomView(Config.BT).setOnClickListener(this);
            }
            if (getCustomView(Config.RADIO) != null) {
                getCustomView(Config.RADIO).setOnClickListener(this);
            }
            if (getCustomView(Config.MUSIC) != null) {
                getCustomView(Config.MUSIC).setOnClickListener(this);
            }
            if (getCustomView(Config.BTAV) != null) {
                getCustomView(Config.BTAV).setOnClickListener(this);
            }
            if (getCustomView(Config.ECAR) != null) {
                getCustomView(Config.ECAR).setOnClickListener(this);
            }
            if (getCustomView(Config.SOS) != null) {
                getCustomView(Config.SOS).setOnClickListener(this);
            }
            if (getCustomView(Config.KUWO) != null) {
                getCustomView(Config.KUWO).setOnClickListener(this);
            }
            if (getCustomView(Config.UNICAR) != null) {
                getCustomView(Config.UNICAR).setOnClickListener(this);
            }
            if (getCustomView(Config.KLFM) != null) {
                getCustomView(Config.KLFM).setOnClickListener(this);
            }
            if (getCustomView(Config.HONGFANS) != null) {
                getCustomView(Config.HONGFANS).setOnClickListener(this);
            }
            if (getCustomView(Config.DVR) != null) {
                getCustomView(Config.DVR).setOnClickListener(this);
            }
            if (getCustomView(Config.LIGHT) != null) {
                getCustomView(Config.LIGHT).setOnClickListener(this);
            }
            if (getCustomView(Config.CLOLSESCREEN) != null) {
                getCustomView(Config.CLOLSESCREEN).setOnClickListener(this);
            }
            if (getCustomView(Config.WIFI) != null) {
                getCustomView(Config.WIFI).setOnClickListener(this);
            }
            if (getCustomView(Config.SOUND) != null) {
                getCustomView(Config.SOUND).setOnClickListener(this);
            }
            if (getCustomView(Config.CLOLSESOUND) != null) {
                getCustomView(Config.CLOLSESOUND).setOnClickListener(this);
            }
            if (getCustomView(Config.EQ) != null) {
                getCustomView(Config.EQ).setOnClickListener(this);
            }
            if (getCustomView(Config.TIME) != null) {
                getCustomView(Config.TIME).setOnClickListener(this);
            }
            if (getCustomView(Config.ALLAPP) != null) {
                getCustomView(Config.ALLAPP).setOnClickListener(this);
            }
            if (getCustomView(Config.BROWSER) != null) {
                getCustomView(Config.BROWSER).setOnClickListener(this);
            }
            if (getCustomView(Config.CANBUS) != null) {
                getCustomView(Config.CANBUS).setOnClickListener(this);
            }
            if (getCustomView(Config.FILE) != null) {
                getCustomView(Config.FILE).setOnClickListener(this);
            }
            if (getCustomView(Config.NEWEYE) != null) {
                getCustomView(Config.NEWEYE).setOnClickListener(this);
            }
        }
    }

    public void initBarWeatherView(View barWeatherView) {
        weatherImg1 = (ImageView) barWeatherView.findViewById(ResValue.getInstance().weather_imge1);
        weatherCity1 = (TextView) barWeatherView.findViewById(ResValue.getInstance().weather_city1);
        weatherWeather1 = (TextView) barWeatherView.findViewById(ResValue.getInstance().weather_weather1);
        weatherTemp1 = (TextView) barWeatherView.findViewById(ResValue.getInstance().weather_temp1);
    }

    private void setupViews() {
        final DragController dragController = mDragController;

        mLauncherView = findViewById(R.id.launcher);
        mDragLayer = (DragLayer) findViewById(R.id.drag_layer);
        mWorkspace = (Workspace) mDragLayer.findViewById(R.id.workspace);

        mLauncherView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        // Setup the drag layer
        mDragLayer.setup(this, dragController);

        // Setup the hotseat
        mHotseat = (Hotseat) findViewById(R.id.hotseat);
        if (mHotseat != null) {
            mHotseat.setup(this);
            mHotseat.setOnLongClickListener(this);
            mAllAppsButton = mHotseat.findViewById(ResValue.getInstance().syu_app_button);
        }

        mOverviewPanel = findViewById(R.id.overview_panel);
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        bottomButtons = findViewById(R.id.bottom_buttons);
        bottomButtonsWidgets = findViewById(R.id.bottom_buttons_widgets);
        if (userLayout) {
            bottomButtons.setVisibility(android.view.View.GONE); 
            bottomButtonsWidgets.setVisibility(android.view.View.VISIBLE); 
        } else {
            bottomButtons.setVisibility(android.view.View.VISIBLE); 
            bottomButtonsWidgets.setVisibility(android.view.View.GONE);
        }

        initHashMap();

        if (mAllAppsButton != null) {
            mAllAppsButton.setOnClickListener(arg0 -> onClickAllAppsButton());
            mAllAppsButton.setOnTouchListener(getHapticFeedbackTouchListener());
        } 

        wallpaperButton = findViewById(ResValue.getInstance().wallpaper_button);
        if (wallpaperButton != null) {
            wallpaperButton.setOnClickListener(arg0 -> onClickWallpaperPicker(arg0));
            wallpaperButton.setOnTouchListener(getHapticFeedbackTouchListener());
        }

        widgetButton = findViewById(R.id.widget_button);
        if (widgetButton != null) {
            widgetButton.setOnClickListener(arg0 -> showAllApps(true, AppsCustomizePagedView.ContentType.Widgets, true));
            widgetButton.setOnTouchListener(getHapticFeedbackTouchListener());
        }
        
        settingsButton = findViewById(ResValue.getInstance().settings_button);
        if (settingsButton != null) {
            settingsButton.setOnClickListener(arg0 -> {
                onClickSettingsButton(arg0); //Launcher.this.startSettings();
            });
            settingsButton.setOnTouchListener(getHapticFeedbackTouchListener());
        }

        wallpaperButtonWidgets = findViewById(ResValue.getInstance().wallpaper_button_widgets);
        if (wallpaperButtonWidgets != null) {
            wallpaperButtonWidgets.setOnClickListener(arg0 -> onClickWallpaperPicker(arg0));
            wallpaperButtonWidgets.setOnTouchListener(getHapticFeedbackTouchListener());
        }

        
        settingsButtonWidgets = findViewById(ResValue.getInstance().settings_button_widgets);
        if (settingsButtonWidgets != null) {
            settingsButtonWidgets.setOnClickListener(arg0 -> onClickSettingsButton(arg0));
            settingsButtonWidgets.setOnTouchListener(getHapticFeedbackTouchListener());
        }

        mOverviewPanel.setAlpha(0f);

        // Setup the workspace
        mWorkspace.setHapticFeedbackEnabled(false);
        mWorkspace.setOnLongClickListener(this);
        mWorkspace.setup(dragController);
        dragController.addDragListener(mWorkspace);

        // Get the search/delete bar
        mSearchDropTargetBar = (SearchDropTargetBar) mDragLayer.findViewById(R.id.qqsb_bar);

        // Setup AppsCustomize
        mAppsCustomizeTabHost = (AppsCustomizeTabHost) findViewById(R.id.apps_customize_pane);
        mAppsCustomizeContent = (AppsCustomizePagedView) mAppsCustomizeTabHost.findViewById(R.id.apps_customize_pane_content);
        if (mAppsCustomizeContent != null) {
            FrameLayout.LayoutParams appsCustomizeLayoutParams = (FrameLayout.LayoutParams) mAppsCustomizeContent.getLayoutParams();

            int marginLeft = getResources().getDimensionPixelSize(R.dimen.apps_customize_page_view_margin_left);
            int marginRight = getResources().getDimensionPixelSize(R.dimen.apps_customize_page_view_margin_right);

            appsCustomizeLayoutParams.setMargins(marginLeft, apps_customize_page_view_margin_top, marginRight, apps_customize_page_view_margin_bottom);

            mAppsCustomizeContent.setLayoutParams(appsCustomizeLayoutParams);
        }
        mAppsCustomizeContent.setup(this, dragController);

        // Setup the drag controller (drop targets have to be added in reverse order in priority)
        dragController.setDragScoller(mWorkspace);
        dragController.setScrollView(mDragLayer);
        dragController.setMoveTarget(mWorkspace);
        dragController.addDropTarget(mWorkspace);
        if (mSearchDropTargetBar != null) {
            mSearchDropTargetBar.setup(this, dragController);
        }

        if (getResources().getBoolean(R.bool.debug_memory_enabled)) {
            Log.v(TAG, "adding WeightWatcher");
            mWeightWatcher = new WeightWatcher(this);
            mWeightWatcher.setAlpha(0.5f);
            ((FrameLayout) mLauncherView).addView(mWeightWatcher,
                    new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT,
                            Gravity.BOTTOM)
            );

            boolean show = shouldShowWeightWatcher();
            mWeightWatcher.setVisibility(show ? View.VISIBLE : View.GONE);
        }
        
        firstLayout = (RelativeLayout) findViewById(ResValue.getInstance().first_layout);
        ImageView firstClickApp = (ImageView) findViewById(ResValue.getInstance().first_app);
        if (firstClickApp != null) {
            firstClickApp.setOnClickListener(arg0 -> {
                if (Launcher.this.firstLayout != null) {
                    Launcher.this.firstLayout.setVisibility(View.GONE);
                }
            });
        }
        if (firstLayout != null) {
            firstLayout.setOnClickListener(arg0 -> {
            });
        }
    }

    public void onClickWallpaperPicker(View v) {
        helpers.setOpenedFromOverviewBoolean(true);
        if (mWorkspace.isInOverviewMode()) {
            mWorkspace.exitOverviewMode(true);
        }
        WindowUtil.removePip(null);
        if (mPrefs.getBoolean("wallpaper_picker_source", false)) {
            startWallpaperSystem(v);
        } else {
            startWallpaperInApp();
        }
    }

    protected void startWallpaperSystem(View v) {
        final Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);

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
            helpers.setWallpaperWindow(true);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "activity_not_found", Toast.LENGTH_SHORT).show();
        }
    }

    protected void startWallpaperInApp() {
        final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
        pickWallpaper.setComponent(getWallpaperPickerComponent());
        startActivity(pickWallpaper);
    }

    protected ComponentName getWallpaperPickerComponent() {
        return new ComponentName(getPackageName(), WallpaperPickerActivity.class.getName());
    }

    public Rect getViewBounds(View v) {
        int[] pos = new int[2];
        v.getLocationOnScreen(pos);
        return new Rect(pos[0], pos[1], pos[0] + v.getWidth(), pos[1] + v.getHeight());
    }

    public void onClickSettingsButton(View v) {
        if (LOGD) Log.d(TAG, "onClickSettingsButton");
        helpers.setOpenedFromOverviewBoolean(true);
        if (mWorkspace.isInOverviewMode()) {
            mWorkspace.exitOverviewMode(true);
        }
        WindowUtil.removePip(null);
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        try {
            ComponentName componentName = settingsIntent.getComponent();
            PackageManager pm = getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
            String appTitle = appInfo.loadLabel(pm).toString();
            AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
            refreshLeftCycle(bean);
            cleanWidgetBar();
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
        settingsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(settingsIntent);
    }

    public void initDateWidgetView(View dateWidgeView) {
        if (dateWidgeView != null) {
            putCustomView(Config.WS_Time, dateWidgeView.findViewById(ResValue.getInstance().ll_time));
            if (getCustomView(Config.WS_Time) != null) {
                getCustomView(Config.WS_Time).setOnClickListener(this);
            }
        }
    }

    public void initMusicWidgetView(View musicWidgetView) {
        if (musicWidgetView != null) {
            mPlayPauseButton = musicWidgetView.findViewById(ResValue.getInstance().musicbutton_playpause);
            mMusicPrevButton = musicWidgetView.findViewById(ResValue.getInstance().musicbutton_prev);
            mMusicNextButton = musicWidgetView.findViewById(ResValue.getInstance().musicbutton_next);
            setWidgetButtonsTint(mPlayPauseButton);
            setWidgetButtonsTint(mMusicPrevButton);
            setWidgetButtonsTint(mMusicNextButton);          
            tvMusicName = musicWidgetView.findViewById(ResValue.getInstance().tv_musicName);
            ivALbumBg = musicWidgetView.findViewById(ResValue.getInstance().iv_album_bg);
            ivMusicScore = musicWidgetView.findViewById(ResValue.getInstance().music_score);
            ivMusicScore2 = musicWidgetView.findViewById(ResValue.getInstance().music_score2);
            tvAritst = musicWidgetView.findViewById(ResValue.getInstance().tv_artist);
            tvAlbum = musicWidgetView.findViewById(ResValue.getInstance().tv_album);
            tvCurTime = musicWidgetView.findViewById(ResValue.getInstance().music_cur_time);
            tvTotalTime = musicWidgetView.findViewById(ResValue.getInstance().music_total_time);
            mTvMusic = musicWidgetView.findViewById(ResValue.getInstance().tv_music);
            musicSeekBar = musicWidgetView.findViewById(ResValue.getInstance().music_seekbar);
            musicProgress = musicWidgetView.findViewById(ResValue.getInstance().music_progress);
            widgetTint = mPrefs.getBoolean(Keys.BLACK_WIDGETS, false);
            if (widgetTint && musicProgress != null) {
                musicProgress.getProgressDrawable().setColorFilter(
                    Color.BLACK, 
                    PorterDuff.Mode.SRC_IN
                );
            } else if (musicProgress != null) {
                musicProgress.getProgressDrawable().clearColorFilter();
            }
            putCustomView(Config.WS_Music, musicWidgetView.findViewById(ResValue.getInstance().rl_music));
            if (getCustomView(Config.WS_Music) != null) {
                getCustomView(Config.WS_Music).setOnClickListener(this);
            }
        }
    }

    public void initMusicBarView(View musicBarView) {
        if (musicBarView != null) {
            mPlayPauseButtonTwo = musicBarView.findViewById(ResValue.getInstance().musicbutton_playpause_two);
            mMusicPrevButtonTwo = musicBarView.findViewById(ResValue.getInstance().musicbutton_prev_two);
            mMusicNextButtonTwo = musicBarView.findViewById(ResValue.getInstance().musicbutton_next_two);
            setBarButtonsTint(mPlayPauseButtonTwo);
            setBarButtonsTint(mMusicPrevButtonTwo);
            setBarButtonsTint(mMusicNextButtonTwo);
            tvMusicNameTwo = musicBarView.findViewById(ResValue.getInstance().tv_musicName_two);
            ivALbumBgTwo = musicBarView.findViewById(ResValue.getInstance().iv_album_bg_two);
            tvAritstTwo = musicBarView.findViewById(ResValue.getInstance().tv_artist_two);
            putCustomView(Config.WS_Music_Two, musicBarView.findViewById(ResValue.getInstance().rl_music_two));
            if (getCustomView(Config.WS_Music_Two) != null) {
                getCustomView(Config.WS_Music_Two).setOnClickListener(this);
            }
        }
    }

    public void initRadioWidgetView(View radioWidgetView) {
        if (radioWidgetView != null) {
            mRadioPrevButton = radioWidgetView.findViewById(ResValue.getInstance().Radiobutton_prev);
            mRadioNextButton = radioWidgetView.findViewById(ResValue.getInstance().Radiobutton_next);
            setWidgetButtonsTint(mRadioPrevButton);
            setWidgetButtonsTint(mRadioNextButton);
            mRadioPauseButton = radioWidgetView.findViewById(ResValue.getInstance().Radiobutton_pause);
            mRadioBandButton = radioWidgetView.findViewById(ResValue.getInstance().radio_btn_band);
            mRadioIcon = radioWidgetView.findViewById(ResValue.getInstance().mRadioIcon);
            tvBand = radioWidgetView.findViewById(ResValue.getInstance().tv_band);
            tvUnit = radioWidgetView.findViewById(ResValue.getInstance().tv_unit);
            img_freq_point = radioWidgetView.findViewById(ResValue.getInstance().radio_point);
            tvCurFreq = radioWidgetView.findViewById(ResValue.getInstance().tv_freq);
            mTvRadio = radioWidgetView.findViewById(ResValue.getInstance().tv_radio);
            putCustomView(Config.WS_Radio, radioWidgetView.findViewById(ResValue.getInstance().rl_radio));
            if (getCustomView(Config.WS_Radio) != null) {
                getCustomView(Config.WS_Radio).setOnClickListener(this);
            }
        }
    }

    public void initViews() {
        if (mWorkspace != null) {
            if (mPlayer == null) {
                mPlayer = new MediaPlayer();
            }
            mTvNavi = mWorkspace.findViewById(ResValue.getInstance().tv_navi);
            mTvSettings = mWorkspace.findViewById(ResValue.getInstance().tv_settings);
            mTvCar = mWorkspace.findViewById(ResValue.getInstance().tv_car);
            mMiuDrive = mWorkspace.findViewById(ResValue.getInstance().tv_miudrive);
            mTvAux = mWorkspace.findViewById(ResValue.getInstance().tv_aux);
            mTvApps = mWorkspace.findViewById(ResValue.getInstance().tv_apps);
            mTvBt = mWorkspace.findViewById(ResValue.getInstance().tv_bt);
            mTvBtPhoneName = mWorkspace.findViewById(ResValue.getInstance().tv_btphone_name);
            mTvCanbus = mWorkspace.findViewById(ResValue.getInstance().tv_canbus);
            mTvMovie = mWorkspace.findViewById(ResValue.getInstance().tv_video);
            mTvFile = mWorkspace.findViewById(ResValue.getInstance().tv_file);
            mTvGallery = mWorkspace.findViewById(ResValue.getInstance().tv_gallery);
            mTvDVR = mWorkspace.findViewById(ResValue.getInstance().tv_dvr);
            mTvPerson = mWorkspace.findViewById(ResValue.getInstance().tv_person);
            mTvGuide = mWorkspace.findViewById(ResValue.getInstance().tv_guide);
            mTvCalculator = mWorkspace.findViewById(ResValue.getInstance().tv_calculator);
            mTvEq = mWorkspace.findViewById(ResValue.getInstance().tv_eq);
            mTurntableView = mWorkspace.findViewById(ResValue.getInstance().turntableview);
            mTvSpeed = mWorkspace.findViewById(ResValue.getInstance().tv_speed);
            putCustomView(Config.WS_Video, mWorkspace.findViewById(ResValue.getInstance().rl_video));
            putCustomView(Config.WS_Bt, mWorkspace.findViewById(ResValue.getInstance().rl_bt));
            putCustomView(Config.WS_Navi, mWorkspace.findViewById(ResValue.getInstance().rl_navi));
            putCustomView(Config.WS_Settings, mWorkspace.findViewById(ResValue.getInstance().rl_settings));
            putCustomView(Config.WS_Time, mWorkspace.findViewById(ResValue.getInstance().ll_time));
            putCustomView(Config.WS_Allapps, mWorkspace.findViewById(ResValue.getInstance().rl_allapps));
            putCustomView(Config.WS_Showbar, mWorkspace.findViewById(ResValue.getInstance().show_bar));
        }
        if (tvMusicName != null) {
            if (MusicService.music_path != null && !MusicService.music_path.isEmpty() && MusicService.music_path.lastIndexOf("/") >= 0) {
                if (fytData) { // from metadata
                    if (!(Launcher.this.tvMusicName.getText().toString()).equals(MusicService.music_name)) {
                        tvMusicName.setText(MusicService.music_name);                        
                    }
                } else { // from file title
                    File file = new File(MusicService.music_path);
                    String filename = file.getName();
                    musictitle = filename.substring(0, filename.lastIndexOf("."));
                    if (!(Launcher.this.tvMusicName.getText().toString()).equals(musictitle)) {
                        tvMusicName.setText(musictitle);                        
                    }
                }
                tvMusicName.setSelected(true);
            } else {
                tvMusicName.setText(R.string.music_name);
                tvMusicName.setSelected(true);
            }
        }
        if (tvMusicNameTwo != null) {
            if (MusicService.music_path != null && !MusicService.music_path.isEmpty() && MusicService.music_path.lastIndexOf("/") >= 0) {
                if (fytData) { // from metadata
                    if (!(Launcher.this.tvMusicNameTwo.getText().toString()).equals(MusicService.music_name)) {
                        tvMusicNameTwo.setText(MusicService.music_name);                        
                    }
                } else { // from file title
                    File file = new File(MusicService.music_path);
                    String filename = file.getName();
                    musictitle = filename.substring(0, filename.lastIndexOf("."));
                    if (!(Launcher.this.tvMusicNameTwo.getText().toString()).equals(musictitle)) {
                        tvMusicNameTwo.setText(musictitle);                        
                    }
                }
                tvMusicNameTwo.setSelected(true);
            } else {
                tvMusicNameTwo.setText(R.string.music_name);
                tvMusicNameTwo.setSelected(true);
            }
        }
        if (tvCurTime != null) {
            tvCurTime.setText("00:00");
        }
        if (tvTotalTime != null) {
            tvTotalTime.setText("00:00");
        }
        if (musicSeekBar != null) {
            musicSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListenerImp(this, null));
        }
        /*if (mPlayPauseButton != null) {
            if (MusicService.state.booleanValue()) {
                mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
            } else {
                mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
            }
        }*/
        if (tvAritst != null) {
            tvAritst.setText(R.string.music_author);
        }
        if (tvAritstTwo != null) {
            tvAritstTwo.setText(R.string.music_author);
        }
        if (tvAlbum != null) {
            tvAlbum.setText(R.string.music_album);
        }
        if (mBtavView != null) {
            mBtavView.setOnClickListener(this);
        }
        if (mBtavName != null) {
            mBtavName.setText(R.string.car_bt_music);
        }
        if (mBtavAritst != null) {
            mBtavAritst.setText(R.string.music_unknown);
        }
        if (tvCurFreq != null) {
            tvCurFreq.setText("87.50");
        }
        if (tvUnit != null) {
            tvUnit.setText("MHz");
        }
        if (tvBand != null) {
            if (tvBand.getBackground() != null) {
                tvBand.setBackgroundResource(ResValue.getInstance().fm);
            } else {
                tvBand.setText("FM");
            }
        }
        if (getCustomView(Config.WS_Bt) != null) {
            getCustomView(Config.WS_Bt).setOnClickListener(this);
        }
        if (getCustomView(Config.WS_Navi) != null) {
            getCustomView(Config.WS_Navi).setOnClickListener(this);
        }
        if (getCustomView(Config.WS_Settings) != null) {
            getCustomView(Config.WS_Settings).setOnClickListener(this);
        }
        if (getCustomView(Config.WS_Allapps) != null) {
            getCustomView(Config.WS_Allapps).setOnClickListener(this);
        }
        if (getCustomView(Config.WS_Showbar) != null) {
            getCustomView(Config.WS_Showbar).setOnClickListener(this);
        }
        if (getCustomView(Config.WS_Time) != null) {
            getCustomView(Config.WS_Time).setOnClickListener(this);
        }
        updateView();
    }

    public void triggerAppData() {
        if (pendingAction != null) {
            appDataHandler.removeCallbacks(pendingAction);
        }
        
        pendingAction = new Runnable() {
            @Override
            public void run() {
                initAppData();
            }
        };
        
        appDataHandler.postDelayed(pendingAction, APP_DATA_DELAY);
    }

    public void initAppData() {
        // Prevent re-entrant calls
        if (mIsInitializingAppData) {
            Log.i(TAG, "initAppData() already in progress, skipping duplicate call");
            return;
        }
        
        mIsInitializingAppData = true;
        mInitRetryCount++;
        Log.i(TAG, "initAppData() started (attempt " + mInitRetryCount + ")");
        
        if (!checkDependenciesReady()) {
            Log.w(TAG, "Dependencies not ready, will retry...");
            mIsInitializingAppData = false;
            
            if (mInitRetryCount < MAX_INIT_RETRIES) {
                mHandler.postDelayed(() -> initAppData(), 1000);
            } else {
                Log.e(TAG, "Max retries reached, initializing with defaults");
                mInitRetryCount = 0;
                forceInitializeWithDefaults();
            }
            return;
        }
        
        // bottom recycler
        if (mWorkspace == null) {
            Log.i(TAG, "mWorkspace null on initAppData(), reinitializing workspace");
            mWorkspace = (Workspace) mDragLayer.findViewById(R.id.workspace);
        }
        
        // Ensure adapter is created before finding RecyclerView
        if (mAppListAdapter == null) {
            mAppListAdapter = new AppListAdapter(this, Collections.emptyList());
        }
        
        RecyclerView mRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.recycler_view);
        if (mRecyclerView == null) {
            Log.e(TAG, "RecyclerView not found in workspace! Waiting for layout...");
            
            // Reset flag before early return so retry can work
            mIsInitializingAppData = false;
            
            if (mInitRetryCount < MAX_INIT_RETRIES) {
                // Wait for the workspace to be laid out properly
                if (mWorkspace.getViewTreeObserver().isAlive()) {
                    mWorkspace.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            mWorkspace.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            initAppData();
                        }
                    });
                } else {
                    mHandler.postDelayed(() -> initAppData(), 1000);
                }
            } else {
                Log.e(TAG, "Max retries reached for RecyclerView, resetting");
                mInitRetryCount = 0;
            }
            return; 
        }
        
        Log.d(TAG, "All dependencies ready, proceeding with setup");
        setupRecyclerView(mRecyclerView);
        mHandler.post(() -> setupLeftRecyclerView());
        
        // Reset retry count on success
        mInitRetryCount = 0;
    }

    private boolean checkDependenciesReady() {
        // Check if AllAppsList is populated
        if (AllAppsList.data == null || AllAppsList.data.isEmpty()) {
            Log.w(TAG, "AllAppsList not ready");
            return false;
        }
        
        // Check if database is accessible
        try {
            List<AppMultiple> testQuery = LitePal.limit(1).find(AppMultiple.class);
            // Query succeeded, database is ready
        } catch (Exception e) {
            Log.w(TAG, "Database not ready: " + e.getMessage());
            return false;
        }
        
        // Check if PackageManager is ready
        try {
            PackageManager pm = getPackageManager();
            if (pm == null) {
                Log.w(TAG, "PackageManager not ready");
                return false;
            }
        } catch (Exception e) {
            Log.w(TAG, "PackageManager error: " + e.getMessage());
            return false;
        }
        
        // Check if workspace is laid out
        if (mWorkspace == null || !mWorkspace.isLaidOut()) {
            Log.w(TAG, "Workspace not laid out yet");
            return false;
        }
        
        return true;
    }

    private void forceInitializeWithDefaults() {
        // Last resort: initialize with empty data and let user configure
        mIsInitializingAppData = true;
        
        if (mAppListAdapter == null) {
            mAppListAdapter = new AppListAdapter(this, Collections.emptyList());
        }
        
        mHandler.postDelayed(() -> {
            RecyclerView mRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.recycler_view);
            if (mRecyclerView != null) {
                setupRecyclerView(mRecyclerView);
                setupLeftRecyclerView();
            }
            mIsInitializingAppData = false;
        }, 500);
    }

    private void setupRecyclerView(RecyclerView mRecyclerView) {
        Log.d(TAG, "setupRecyclerView started");
        
        // Force visibility
        mRecyclerView.setVisibility(View.VISIBLE);
        
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(androidx.recyclerview.widget.RecyclerView.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        
        // Check if decoration already added to prevent duplicates
        if (mRecyclerView.getTag() == null) {
            mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                        if (userLayout && widgetBar) {
                            outRect.left = (int) (-bottomBarIconMargin * 1.1f);
                            outRect.right = (int) (-bottomBarIconMargin * 1.1f);
                        } else {
                            outRect.left = -bottomBarIconMargin;
                            outRect.right = -bottomBarIconMargin; 
                        }
                    } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        if (userLayout && widgetBar) {
                            outRect.left = (int) (bottomBarIconMargin / 2.0f);
                            outRect.right = (int) (bottomBarIconMargin / 2.0f);
                        } else {
                            outRect.left = bottomBarIconMargin;
                            outRect.right = bottomBarIconMargin;
                        }
                    }
                }
            });
            mRecyclerView.addItemDecoration(new SimpleDividerDecoration());
            mRecyclerView.setTag(1);
        }
        
        mRecyclerView.setAdapter(mAppListAdapter);
        
        Log.d(TAG, "RecyclerView setup complete - Adapter: " + (mAppListAdapter != null) + 
              ", ItemCount: " + (mAppListAdapter != null ? mAppListAdapter.getItemCount() : 0) +
              ", Visibility: " + mRecyclerView.getVisibility());
        
        // Initialize app data
        initializeAppList();

        Intent intentCustomElements = new Intent(Keys.START_ADDING_CUSTOM_ELEMETNS);
        Bundle bundle = new Bundle();
        bundle.putBoolean("instant", true);
        intentCustomElements.putExtras(bundle);
        sendBroadcast(intentCustomElements);

        // Force a layout pass
        mRecyclerView.requestLayout();
    }

    private void setupLeftRecyclerView() {
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        
        if (!(userLayout && leftBar || !userLayout)) {
            return;
        }
        
        RecyclerView mLeftRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.left_recycler_view);
        
        if (mLeftRecyclerView == null) {
            Log.e("Launcher", "Left RecyclerView not found! Waiting for layout...");
            if (mWorkspace.getViewTreeObserver().isAlive()) {
                mWorkspace.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        mWorkspace.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        setupLeftRecyclerView();
                    }
                });
            } else {
                mHandler.postDelayed(() -> setupLeftRecyclerView(), 500);
            }
            return;
        }
        
        Log.d(TAG, "Setting up left RecyclerView");

        mLeftRecyclerView.setVisibility(View.VISIBLE);
        
        // Initialize adapter FIRST, before any layout might occur
        if (mLeftAppListAdapter == null) {
            mLeftAppListAdapter = new LeftAppListAdapter(this, Collections.emptyList());
        }

        // Then setup layout manager
        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(getApplicationContext());
        leftLayoutManager.setOrientation(androidx.recyclerview.widget.RecyclerView.VERTICAL); 
        mLeftRecyclerView.setLayoutManager(leftLayoutManager);
        
        // Check if decoration already added to prevent duplicates
        if (mLeftRecyclerView.getTag() == null) {
            mLeftRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                @Override
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    super.getItemOffsets(outRect, view, parent, state);
                    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                        outRect.top = (int) (leftBarIconMargin * 1.5f);
                        outRect.bottom = (int) (leftBarIconMargin * 1.5f);
                    } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        outRect.top = leftBarIconMargin;
                        outRect.bottom = leftBarIconMargin;
                    }
                }
            });
            mLeftRecyclerView.addItemDecoration(new SimpleDividerDecoration());
            mLeftRecyclerView.setTag(1);
        }

        mLeftRecyclerView.setAdapter(mLeftAppListAdapter);
        
        // Initialize left app data
        initializeLeftAppData();

        mLeftRecyclerView.requestLayout();
    }

    private void initializeLeftAppData() {
        if (mLeftAppListData == null) {
            mLeftAppListData = new ArrayList<AppListBean>();
        } else {
            mLeftAppListData.clear();  // Make sure this is mLeftAppListData, not mAppListData
        }
        
        // Ensure adapter exists
        if (mLeftAppListAdapter == null) {
            mLeftAppListAdapter = new LeftAppListAdapter(this, mLeftAppListData);
            
            RecyclerView mLeftRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.left_recycler_view);
            if (mLeftRecyclerView != null) {
                mLeftRecyclerView.setAdapter(mLeftAppListAdapter);
            }
        }

        List<AppInfo> allAppsListCopy = null;
        if (AllAppsList.data != null) {
            synchronized (AllAppsList.data) {
                allAppsListCopy = new ArrayList<>(AllAppsList.data);
            }
        }        
        
        List<LeftAppMultiple> leftAppData = LitePal.order("id asc").limit(MAX_LEFT).find(LeftAppMultiple.class);
        
        if (leftAppData != null && !leftAppData.isEmpty()) {
            for (LeftAppMultiple multiple : leftAppData) {
                if (!helpers.isPackageInstalled(multiple.packageName) || 
                    multiple.packageName.isEmpty() || multiple.name.isEmpty()) {
                    continue;
                }
                
                boolean found = false;
                if (allAppsListCopy != null) {
                    for (AppInfo allApp : allAppsListCopy) {
                        if (allApp.getPackageName().equals(multiple.packageName) 
                            && allApp.getClassName().equals(multiple.className)) {
                            AppListBean ab = new AppListBean(
                                allApp.title.toString(), 
                                allApp.iconBitmap, 
                                multiple.packageName, 
                                multiple.className
                            );
                            mLeftAppListData.add(ab);
                            found = true;
                            break;
                        }
                    }
                }
                
                // If not found in AllAppsList but package is installed, load icon from package manager
                if (!found && helpers.isPackageInstalled(multiple.packageName)) {
                    Bitmap icon = loadAppIconFromPackageManager(multiple.packageName, multiple.className);
                    if (icon != null) {
                        AppListBean ab = new AppListBean(
                            multiple.name, 
                            icon, 
                            multiple.packageName, 
                            multiple.className
                        );
                        mLeftAppListData.add(ab);
                    }
                }
            }
        }
        
        if (mLeftAppListData != null && mLeftAppListAdapter != null) {
            mLeftAppListAdapter.notifyDataSetChanged(mLeftAppListData);
            Log.d(TAG, "Left app data initialized with " + mLeftAppListData.size() + " items");
        }
    }

    private void initializeAppList() {
        Log.d(TAG, "initializeAppList");

        if (mAppListData == null) {
            mAppListData = new ArrayList<AppListBean>();
        } else {
            mAppListData.clear();
        }
        
        List<AppMultiple> appData = null;
        try {
            appData = LitePal.findAll(AppMultiple.class, new long[0]);
        } catch (Exception e) {
            Log.e(TAG, "Database error in initializeAppList: " + e.getMessage());
        }
        
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);   
        widgetBar = mPrefs.getBoolean(Keys.WIDGET_BAR, false);

        // Create a defensive copy of AllAppsList.data to avoid ConcurrentModificationException
        List<AppInfo> allAppsListCopy = null;
        if (AllAppsList.data != null) {
            synchronized (AllAppsList.data) {
                allAppsListCopy = new ArrayList<>(AllAppsList.data);
            }
        }
        
        if (appData != null && !appData.isEmpty()) {
            for (int i2 = 0; i2 < appData.size(); i2++) {
                AppMultiple multiple2 = appData.get(i2);
                
                // Skip apps that shouldn't be shown when widgetBar is true
                if (userLayout && widgetBar) {
                    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        if (i2 == 0 || i2 == 2 || i2 == 3) {
                            continue;
                        }
                    } else {
                        if (i2 == 0 || i2 == 2 || i2 == 3 || i2 == 4) {
                            continue;
                        }
                    }
                }
                
                if (multiple2.packageName.equals(FytPackage.AppAction)) {
                    Bitmap bmp = helpers.glideLoader(R.drawable.ic_apps);
                    AppListBean ab2 = new AppListBean(Utils.getNameToStr("car_app"), bmp, multiple2.packageName, multiple2.className);
                    mAppListData.add(ab2);
                } else if (multiple2.packageName.equals(FytPackage.AddAction) || !helpers.isPackageInstalled(multiple2.packageName)) {
                    Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
                    AppListBean ab3 = new AppListBean(multiple2.name, bmp2, multiple2.packageName, multiple2.className);
                    mAppListData.add(ab3);
                } else {
                    boolean found = false;
                    // Use the copy instead of the original list
                    if (allAppsListCopy != null) {
                        for (AppInfo allApp2 : allAppsListCopy) {
                            if (allApp2.getPackageName().equals(multiple2.packageName) && allApp2.getClassName().equals(multiple2.className)) {
                                AppListBean ab4 = new AppListBean(allApp2.title.toString(), allApp2.iconBitmap, multiple2.packageName, multiple2.className);
                                mAppListData.add(ab4);
                                found = true;
                                break;
                            }
                        }
                    }
                    
                    // If not found in AllAppsList but package is installed, load from package manager
                    if (!found && helpers.isPackageInstalled(multiple2.packageName)) {
                        Bitmap icon = loadAppIconFromPackageManager(multiple2.packageName, multiple2.className);
                        AppListBean ab = new AppListBean(multiple2.name, icon, multiple2.packageName, multiple2.className);
                        mAppListData.add(ab);
                    } else if (!found) {
                        // Not installed and not found
                        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
                        AppListBean ab = new AppListBean(multiple2.name, bmp, multiple2.packageName, multiple2.className);
                        mAppListData.add(ab);
                    }
                }
            }
        } else {
            Log.w(TAG, "Creating default app entries (appData or AllAppsList not ready)");
            createDefaultAppEntries(); 
        }
        
        if (mAppListAdapter != null) {
            mAppListAdapter.notifyDataSetChanged(mAppListData);
        }
        
        atomicInitAppData.set(true);
        if (!onResumePip) {
            onResumePip = false;
            userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
            if (userLayout) {
                initPip("initializeAppList()", null, false);
                mHandler.postDelayed(() -> {
                    Log.d("initializeAppList()", "openPinnedPip()");
                    WindowUtil.openPinnedPip();
                }, 1500); 
            }
        }

        mHandler.postDelayed(() -> {
            mIsInitializingAppData = false;
        }, 3000);  
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
        // Refresh decorations when orientation changes
        refreshRecyclerViewDecorations();
    }

    private void refreshRecyclerViewDecorations() {
        // Refresh main recycler view
        RecyclerView mRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.recycler_view);
        if (mRecyclerView != null && mAppListAdapter != null) {
            mAppListAdapter.notifyDataSetChanged();
        }
        
        // Refresh left recycler view
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        if (userLayout && leftBar || !userLayout) {
            RecyclerView mLeftRecyclerView = (RecyclerView) mWorkspace.findViewById(R.id.left_recycler_view);
            if (mLeftRecyclerView != null && mLeftAppListAdapter != null) {
                mLeftAppListAdapter.notifyDataSetChanged();
            }
        }
    }

    public void refreshCycle(List<AppMultiple> data) {
        mAppListData.clear();
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);   
        widgetBar = mPrefs.getBoolean(Keys.WIDGET_BAR, false);

        // Create defensive copy
        List<AppInfo> allAppsListCopy = null;
        if (AllAppsList.data != null) {
            synchronized (AllAppsList.data) {
                allAppsListCopy = new ArrayList<>(AllAppsList.data);
            }
        }

        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                AppMultiple multiple = data.get(i);

                // Skip apps that shouldn't be shown when widgetBar is true
                if (userLayout && widgetBar) {
                    // Only show 2nd, 5th, 6th, 7th and 8th apps (indices 1, 4, 5, 6, 7)
                    // Skip 1st, 3rd, and 4th apps (indices 0, 2, 3 + 4 for portrait)
                    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        if (i == 0 || i == 2 || i == 3) {
                            continue;
                        }
                    } else {
                        if (i == 0 || i == 2 || i == 3 || i == 4) {
                            continue;
                        }
                    }
                }

                // Check if app is uninstalled and update database if needed
                if (!multiple.packageName.equals(FytPackage.AddAction) && 
                    !multiple.packageName.equals(FytPackage.AppAction) && 
                    !helpers.isPackageInstalled(multiple.packageName)) {
                    
                    // Update the database entry to AddAction placeholder
                    multiple.packageName = FytPackage.AddAction;
                    multiple.className = "";
                    multiple.name = "";
                    multiple.save(); // Persist the change to database
                }

                if (multiple.packageName.equals(FytPackage.AppAction)) {
                    Bitmap bmp = helpers.glideLoader(R.drawable.ic_apps);
                    AppListBean ab = new AppListBean(
                            Utils.getNameToStr("car_app"),
                            bmp,
                            multiple.packageName,
                            multiple.className
                    );
                    mAppListData.add(ab);

                } else if (multiple.packageName.equals(FytPackage.AddAction)) {
                    Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
                    AppListBean ab2 = new AppListBean(
                            multiple.name != null ? multiple.name : "",
                            bmp2,
                            FytPackage.AddAction,
                            ""
                    );
                    mAppListData.add(ab2);

                } else {
                    if (allAppsListCopy != null) {
                        for (AppInfo allApp : allAppsListCopy) {
                            if (allApp.getPackageName().equals(multiple.packageName)
                                    && allApp.getClassName().equals(multiple.className)) {
                                AppListBean ab3 = new AppListBean(
                                        allApp.title.toString(),
                                        allApp.iconBitmap,
                                        multiple.packageName,
                                        multiple.className
                                );
                                mAppListData.add(ab3);
                                break;
                            }
                        }
                    }
                }
            }
        }
        mAppListAdapter.notifyDataSetChanged(mAppListData);
    }

    public void refreshLeftCycle(AppListBean bean) {
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        if (!(userLayout && leftBar || !userLayout)) return;
        
        Log.d(TAG, "--------------->>>   refreshLeftCycle");
        
        // Get all physical rows from database
        List<LeftAppMultiple> physical = LitePal.order("id asc").find(LeftAppMultiple.class);
        
        // Ensure we have enough placeholder rows
        if (physical.size() < MAX_LEFT) {
            int need = MAX_LEFT - physical.size();
            for (int i = 0; i < need; i++) {
                new LeftAppMultiple(0, "", "", "").save();
            }
            physical = LitePal.order("id asc").find(LeftAppMultiple.class);
        }
        
        // Create a list of currently installed apps (excluding placeholders)
        List<LeftAppMultiple> currentInstalled = new ArrayList<>();
        for (LeftAppMultiple row : physical) {
            if (helpers.isPackageInstalled(row.packageName) && 
                !row.packageName.isEmpty() && !row.name.isEmpty()) {
                currentInstalled.add(row);
            }
        }
        
        // Remove the app if it already exists in current list
        Iterator<LeftAppMultiple> iterator = currentInstalled.iterator();
        while (iterator.hasNext()) {
            LeftAppMultiple existing = iterator.next();
            if (bean.packageName.equals(existing.packageName) && 
                bean.className.equals(existing.className)) {
                iterator.remove();
                break;
            }
        }
        
        // Create new desired order: new app at position 0, then existing apps
        List<LeftAppMultiple> desired = new ArrayList<>(MAX_LEFT);
        desired.add(new LeftAppMultiple(0, bean.name, bean.packageName, bean.className));
        
        // Add existing installed apps until we reach MAX_LEFT
        for (LeftAppMultiple existing : currentInstalled) {
            if (desired.size() >= MAX_LEFT) break;
            desired.add(existing);
        }
        
        // Fill remaining slots with empty placeholders if needed
        while (desired.size() < MAX_LEFT) {
            desired.add(new LeftAppMultiple(0, "", "", ""));
        }
        
        // Update database with new order
        for (int i = 0; i < MAX_LEFT; i++) {
            LeftAppMultiple src = desired.get(i);
            LeftAppMultiple dst = physical.get(i);
            
            ContentValues v = new ContentValues();
            v.put("name", src.name);
            v.put("packageName", src.packageName);
            v.put("className", src.className);
            LitePal.update(LeftAppMultiple.class, v, dst.id);
        }
        
        // Refresh the display
        List<LeftAppMultiple> topRows = LitePal.order("id asc").limit(MAX_LEFT).find(LeftAppMultiple.class);
        refreshLeftBar(topRows);
    }

    public void refreshLeftBar(@Nullable List<LeftAppMultiple> leftAppData) {
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        leftBar = mPrefs.getBoolean(Keys.LEFT_BAR, false);
        if (!(userLayout && leftBar || !userLayout)) return;

        Log.d(TAG, "--------------->>>   refreshLeftBar");

        if (mLeftAppListData == null) mLeftAppListData = new ArrayList<>();
        else mLeftAppListData.clear();

        List<AppInfo> allAppsListCopy = null;
        if (AllAppsList.data != null) {
            synchronized (AllAppsList.data) {
                allAppsListCopy = new ArrayList<>(AllAppsList.data);
            }
        }

        final List<LeftAppMultiple> src = (leftAppData != null && !leftAppData.isEmpty())
                ? leftAppData
                : LitePal.order("id asc").limit(MAX_LEFT).find(LeftAppMultiple.class);

        int added = 0;
        for (LeftAppMultiple row : src) {
            if (added == MAX_LEFT) break;
            if (!helpers.isPackageInstalled(row.packageName)) continue;

            if (allAppsListCopy != null) {
                for (AppInfo app : allAppsListCopy) {
                    if (row.packageName.equals(app.getPackageName())
                            && row.className.equals(app.getClassName())) {
                        mLeftAppListData.add(new AppListBean(
                                app.title != null ? app.title.toString() : "",
                                app.iconBitmap,
                                row.packageName,
                                row.className
                        ));
                        added++;
                        break;
                    }
                }
            }
        }
        if (mLeftAppListAdapter != null) mLeftAppListAdapter.notifyDataSetChanged(mLeftAppListData);
    }

    private void createDefaultAppEntries() {
        String appName1 = Utils.getNameToStr("car_navi");
        String appName2 = Utils.getNameToStr("car_music");
        String appName3 = Utils.getNameToStr("car_video");
        String appName4 = Utils.getNameToStr("car_radio");
        String appName5 = Utils.getNameToStr("car_bt");
        String appName6 = Utils.getNameToStr("car_eq");
        String appName7 = Utils.getNameToStr("car_settings");
        String appName8 = Utils.getNameToStr("");
        
        Bitmap icon1 = loadAppIconFromPackageManager(FytPackage.naviAction, "com.syu.onekeynavi.MainActivity");
        Bitmap icon2 = loadAppIconFromPackageManager("com.syu.music", "com.syu.app.Activity_All");
        Bitmap icon3 = loadAppIconFromPackageManager("com.syu.video", "com.syu.video.main.VideoListActivity");
        Bitmap icon4 = loadAppIconFromPackageManager("com.syu.radio", "com.syu.radio.Launch");
        Bitmap icon5 = loadAppIconFromPackageManager("com.syu.bt", "com.syu.bt.BtAct");
        Bitmap icon6 = helpers.glideLoader(R.drawable.icon_settings);
        Bitmap icon7 = loadAppIconFromPackageManager("com.syu.settings", "com.syu.settings.MainActivity");
        Bitmap icon8 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);

        // AppListBean entries for UI
        AppListBean ab1, ab22, ab32, ab42, ab5, ab6, ab7, ab8;
        
        if (helpers.isPackageInstalled(FytPackage.naviAction)) {
            ab1 = new AppListBean(appName1, icon1, FytPackage.naviAction, "com.syu.onekeynavi.MainActivity");
            new AppMultiple(0, appName1, FytPackage.naviAction, "com.syu.onekeynavi.MainActivity").save();
        } else {
            ab1 = new AppListBean("", BitmapFactory.decodeResource(getResources(), R.drawable.icon_add), FytPackage.AddAction, "");
            new AppMultiple(0, "", FytPackage.AddAction, "").save();
        }
        
        if (helpers.isPackageInstalled("com.syu.music")) {
            ab22 = new AppListBean(appName2, icon2, "com.syu.music", "com.syu.app.Activity_All");
            new AppMultiple(1, appName2, "com.syu.music", "com.syu.app.Activity_All").save();
        } else {
            ab22 = new AppListBean("", BitmapFactory.decodeResource(getResources(), R.drawable.icon_add), FytPackage.AddAction, "");
            new AppMultiple(1, "", FytPackage.AddAction, "").save();
        }
        
        if (helpers.isPackageInstalled("com.syu.video")) {
            ab32 = new AppListBean(appName3, icon3, "com.syu.video", "com.syu.video.main.VideoListActivity");
            new AppMultiple(2, appName3, "com.syu.video", "com.syu.video.main.VideoListActivity").save();
        } else {
            ab32 = new AppListBean("", BitmapFactory.decodeResource(getResources(), R.drawable.icon_add), FytPackage.AddAction, "");
            new AppMultiple(2, "", FytPackage.AddAction, "").save();
        }
        
        if (helpers.isPackageInstalled("com.syu.radio")) {
            ab42 = new AppListBean(appName4, icon4, "com.syu.radio", "com.syu.radio.Launch");
            new AppMultiple(3, appName4, "com.syu.radio", "com.syu.radio.Launch").save();
        } else {
            ab42 = new AppListBean("", BitmapFactory.decodeResource(getResources(), R.drawable.icon_add), FytPackage.AddAction, "");
            new AppMultiple(3, "", FytPackage.AddAction, "").save();
        }

        if (helpers.isPackageInstalled("com.syu.bt")) {
            ab5 = new AppListBean(appName5, icon5, "com.syu.bt", "com.syu.bt.BtAct");
            new AppMultiple(4, appName5, "com.syu.bt", "com.syu.bt.BtAct").save();
        } else {
            ab5 = new AppListBean("", BitmapFactory.decodeResource(getResources(), R.drawable.icon_add), FytPackage.AddAction, "");
            new AppMultiple(4, "", FytPackage.AddAction, "").save();
        }

        if (helpers.isPackageInstalled("com.android.launcher66")) {
            ab6 = new AppListBean(appName6, icon6, "com.android.launcher66", "com.android.launcher66.settings.SettingsActivity");
            new AppMultiple(5, appName6, "com.android.launcher66", "com.android.launcher66.settings.SettingsActivity").save();
        } else {
            ab6 = new AppListBean("", BitmapFactory.decodeResource(getResources(), R.drawable.icon_add), FytPackage.AddAction, "");
            new AppMultiple(5, "", FytPackage.AddAction, "").save();
        }
        
        ab7 = new AppListBean(appName7, icon7, "com.syu.settings", "com.syu.settings.MainActivity");
        new AppMultiple(6, appName7, "com.syu.settings", "com.syu.settings.MainActivity").save();

        ab8 = new AppListBean(appName8, icon8, FytPackage.AddAction, "");
        new AppMultiple(7, appName8, FytPackage.AddAction, "").save();
        
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);   
        widgetBar = mPrefs.getBoolean(Keys.WIDGET_BAR, false);

        // Add all beans to the list
        if (userLayout && widgetBar) {
            mAppListData.add(ab22);
            mAppListData.add(ab5);
            mAppListData.add(ab6);
            mAppListData.add(ab7);
            mAppListData.add(ab8); 
        } else {
            mAppListData.add(ab1);
            mAppListData.add(ab22);
            mAppListData.add(ab32);
            mAppListData.add(ab42);
            mAppListData.add(ab5);
            mAppListData.add(ab6);
            mAppListData.add(ab7);
            mAppListData.add(ab8);            
        }
    }

    private Bitmap loadAppIconFromPackageManager(String packageName, String className) {
        try {
            PackageManager pm = getPackageManager();
            ComponentName component = new ComponentName(packageName, className);
            Drawable drawable = pm.getActivityIcon(component);
            
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            } else {
                // Convert drawable to bitmap
                Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), 
                        drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return bitmap;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error loading icon for " + packageName + ": " + e.getMessage());
            return BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
        }
    }

    private void initAnim() {
    }

    private class OnSeekBarChangeListenerImp implements SeekBar.OnSeekBarChangeListener {
        private OnSeekBarChangeListenerImp() {
        }

        OnSeekBarChangeListenerImp(Launcher launcher, OnSeekBarChangeListenerImp onSeekBarChangeListenerImp) {
            this();
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                Launcher.this.mPlayer.seekTo(progress);
                Launcher.this.musicSeekBar.setProgress(progress);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    
    public void needStartKuwo() {
        if (!AppUtil.isInTheTaskbar(getApplicationContext(), FytPackage.KWACTION)) {
            startActivitySafely(getCustomView(Config.WS_Kuwo), FytPackage.getIntent(this, FytPackage.KWACTION), "music");
        }
        switchSoundChannelThirdPlayer();
    }

    private void switchSoundChannelThirdPlayer() {
        int currentChanne = CarStates.getCar(getApplicationContext()).getTools().getInt(0, 0, 0, 0);
        if (currentChanne != 10) {
            CarStates.getCar(getApplicationContext()).getTools().sendInt(0, 0, 10);
        }
    }

    public void bindMusicWidgetOnclickListener(View musicWidgetView) {
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        prevLayout = musicWidgetView.findViewById(R.id.constraint_layout_prev);
        playPauseLayout = musicWidgetView.findViewById(R.id.constraint_layout_playpause);
        nextLayout = musicWidgetView.findViewById(R.id.constraint_layout_next);
        
        // Set up previous button
        View.OnClickListener prevClickListener = v -> onPrevButtonClicked(false);
        prevLayout.setOnClickListener(prevClickListener);
        if (mMusicPrevButton != null) {
            mMusicPrevButton.setOnClickListener(prevClickListener);
        }
        
        // Set up play/pause button
        View.OnClickListener playPauseClickListener = v -> onPlayPauseButtonClicked(mPlayPauseButton, false);
        playPauseLayout.setOnClickListener(playPauseClickListener);
        if (mPlayPauseButton != null) {
            mPlayPauseButton.setOnClickListener(playPauseClickListener);
        }
        
        // Set up next button
        View.OnClickListener nextClickListener = v -> onNextButtonClicked(false);
        nextLayout.setOnClickListener(nextClickListener);
        if (mMusicNextButton != null) {
            mMusicNextButton.setOnClickListener(nextClickListener);
        }
        
        // Make layouts clickable
        prevLayout.setClickable(true);
        playPauseLayout.setClickable(true);
        nextLayout.setClickable(true);
        
        prevLayout.setFocusable(true);
        playPauseLayout.setFocusable(true);
        nextLayout.setFocusable(true);
    }

    public void bindMusicBarOnclickListener(View musicBarView) {
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        prevLayoutTwo = musicBarView.findViewById(R.id.constraint_layout_prev_two);
        playPauseLayoutTwo = musicBarView.findViewById(R.id.constraint_layout_playpause_two);
        nextLayoutTwo = musicBarView.findViewById(R.id.constraint_layout_next_two);
        
        // Set up previous button
        View.OnClickListener prevClickListener = v -> onPrevButtonClicked(true);
        prevLayoutTwo.setOnClickListener(prevClickListener);
        if (mMusicPrevButtonTwo != null) {
            mMusicPrevButtonTwo.setOnClickListener(prevClickListener);
        }
        
        // Set up play/pause button
        View.OnClickListener playPauseClickListener = v -> onPlayPauseButtonClicked(mPlayPauseButtonTwo, true);
        playPauseLayoutTwo.setOnClickListener(playPauseClickListener);
        if (mPlayPauseButtonTwo != null) {
            mPlayPauseButtonTwo.setOnClickListener(playPauseClickListener);
        }
        
        // Set up next button
        View.OnClickListener nextClickListener = v -> onNextButtonClicked(true);
        nextLayoutTwo.setOnClickListener(nextClickListener);
        if (mMusicNextButtonTwo != null) {
            mMusicNextButtonTwo.setOnClickListener(nextClickListener);
        }
        
        // Make LayoutTwos clickable
        prevLayoutTwo.setClickable(true);
        playPauseLayoutTwo.setClickable(true);
        nextLayoutTwo.setClickable(true);
        
        prevLayoutTwo.setFocusable(true);
        playPauseLayoutTwo.setFocusable(true);
        nextLayoutTwo.setFocusable(true);
    }
    
    public void onPrevButtonClicked(boolean barView) {
        if (barView) {
            mWorkspace.scheduleAutoHide();
        }
        if (mediaSource == "fyt") {
            Intent intent = new Intent();
            intent.setAction("com.syu.music.prev");
            intent.setPackage("com.syu.music");
            Launcher.this.startService(intent);
        } else if (mediaSource == "mediaController") {
            boolean activeControllerAppRunning = false;
            MediaSessionManager msm = (MediaSessionManager) getSystemService(Context.MEDIA_SESSION_SERVICE);
            List<MediaController> controllers = msm.getActiveSessions(null);
            for (MediaController controller : controllers) {
                if (controller.getPackageName().equals(activeController)) {
                    activeControllerAppRunning = true;
                    if (activeController != null && !activeController.isEmpty()) {
                        sendBroadcast(new Intent("media.play.previous"));
                    }
                    break; 
                }
            }
            if (!activeControllerAppRunning || isRadioPlaying()) {
                WindowUtil.removePip(Launcher.this.pipViews);
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(activeController);
                try {
                    ComponentName componentName = launchIntent.getComponent();
                    PackageManager pm = getPackageManager();
                    ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                    String appTitle = appInfo.loadLabel(pm).toString();
                    AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                    Launcher.this.refreshLeftCycle(bean);
                    cleanWidgetBar();
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException(e);
                }
                startActivity(launchIntent);
            }
        }
    }

    public void onPlayPauseButtonClicked(Button playPauseButton, boolean barView) {
        if (barView) {
            mWorkspace.scheduleAutoHide();
        }
        if (!temporarilyDisablePlayPauseButton) {
            if (mediaSource == "fyt") {
                if (MusicService.state.booleanValue()) {
                    playPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                    if (barView) {
                        setBarButtonsTint(playPauseButton);
                    } else {
                        setWidgetButtonsTint(playPauseButton);
                    }
                } else {
                    playPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                    if (barView) {
                        setBarButtonsTint(playPauseButton);
                    } else {
                        setWidgetButtonsTint(playPauseButton);
                    }
                }
                Intent intent = new Intent();
                intent.setAction("com.syu.music.playpause");
                intent.setPackage("com.syu.music");
                Launcher.this.startService(intent);
            } else if (mediaSource == "mediaController") {
                boolean activeControllerAppRunning = false;
                MediaSessionManager msm = (MediaSessionManager) getSystemService(Context.MEDIA_SESSION_SERVICE);
                List<MediaController> controllers = msm.getActiveSessions(null);
                for (MediaController controller : controllers) {
                    if (controller.getPackageName().equals(activeController)) {
                        activeControllerAppRunning = true;
                        PlaybackState state = controller.getPlaybackState();
                        int playbackState = (state != null) ? state.getState() : PlaybackState.STATE_NONE;
                        if (playbackState == PlaybackState.STATE_PLAYING) {
                            playPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                            if (barView) {
                                setBarButtonsTint(playPauseButton);
                            } else {
                                setWidgetButtonsTint(playPauseButton);
                            }
                            sendBroadcast(new Intent("media.play.pause"));
                        } else {
                            playPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_playpause_icon));
                            if (barView) {
                                setBarButtonsTint(playPauseButton);
                            } else {
                                setWidgetButtonsTint(playPauseButton);
                            }
                            sendBroadcast(new Intent("media.play.play"));
                        }
                        break;
                    }
                }
                if (!activeControllerAppRunning || isRadioPlaying()) {
                    WindowUtil.removePip(Launcher.this.pipViews);
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage(activeController);
                    try {
                        ComponentName componentName = launchIntent.getComponent();
                        PackageManager pm = getPackageManager();
                        ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                        String appTitle = appInfo.loadLabel(pm).toString();
                        AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                        Launcher.this.refreshLeftCycle(bean);
                        cleanWidgetBar();
                    } catch (PackageManager.NameNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    startActivity(launchIntent);
                }
            }
        }

        temporarilyDisablePlayPauseButton = true;

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                temporarilyDisablePlayPauseButton = false;
            }
        }, 500);
    }

    public void onNextButtonClicked(boolean barView) {
        if (barView) {
            mWorkspace.scheduleAutoHide();
        }
        if (mediaSource == "fyt") {
            Intent intent = new Intent();
            intent.setAction("com.syu.music.next");
            intent.setPackage("com.syu.music");
            Launcher.this.startService(intent);
        } else if (mediaSource == "mediaController") {
            boolean activeControllerAppRunning = false;
            MediaSessionManager msm = (MediaSessionManager) getSystemService(Context.MEDIA_SESSION_SERVICE);
            List<MediaController> controllers = msm.getActiveSessions(null);
            for (MediaController controller : controllers) {
                if (controller.getPackageName().equals(activeController)) {
                    activeControllerAppRunning = true;
                    if (activeController != null && !activeController.isEmpty()) {
                        sendBroadcast(new Intent("media.play.next"));
                    }
                    break; 
                }
            }
            if (!activeControllerAppRunning || isRadioPlaying()) {
                WindowUtil.removePip(Launcher.this.pipViews);
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(activeController);
                try {
                    ComponentName componentName = launchIntent.getComponent();
                    PackageManager pm = getPackageManager();
                    ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                    String appTitle = appInfo.loadLabel(pm).toString();
                    AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                    Launcher.this.refreshLeftCycle(bean);
                    cleanWidgetBar();
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException(e);
                }
                startActivity(launchIntent);
            }
        }
    }

    private void setBarButtonsTint(Button button) {
        barTint = mPrefs.getBoolean(Keys.BLACK_BAR, false);
        if (barTint) {
            helpers.applyColorFilterToButton(button);
        }
    }

    private void setWidgetButtonsTint(Button button) {
        widgetTint = mPrefs.getBoolean(Keys.BLACK_WIDGETS, false);
        if (widgetTint) {
            helpers.applyColorFilterToButton(button);
        }
    }

    public void bindRadioWidgetOnclickListener() {
        if (mRadioPrevButton != null) {
            mRadioPrevButton.setOnClickListener(v -> {
                if (CarStates.mAppID == 1 && Launcher.this.tools != null) {
                    Launcher.this.tools.sendInt(1, 1, 0);
                }
            });
        }
        if (mRadioBandButton != null) {
            mRadioBandButton.setOnClickListener(v -> {
                if (CarStates.mAppID == 1 && Launcher.this.tools != null) {
                    Log.d(TAG, "---------------------->>> mRadioBandButton");
                    Launcher.this.tools.sendInt(1, 11, -1);
                }
            });
        }
        if (mRadioPauseButton != null) {
            mRadioPauseButton.setOnClickListener(v -> {
                if (Launcher.this.tools != null) {
                    if (CarStates.mAppID == 1) {
                        Launcher.this.tools.sendInt(0, 0, 0);
                        Launcher.this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_pause_icon);
                    } else {
                        Launcher.this.tools.sendInt(0, 0, 1);
                        Launcher.this.mRadioPauseButton.setBackgroundResource(ResValue.getInstance().radio_playpause_icon);
                    }
                }
            });
        }
        if (mRadioNextButton != null) {
            mRadioNextButton.setOnClickListener(v -> {
                if (CarStates.mAppID == 1 && Launcher.this.tools != null) {
                    Launcher.this.tools.sendInt(1, 0, 0);
                }
            });
        }
    }

    public void bindOnclickListener() {
        if (kuwomusic_playpause != null) {
            kuwomusic_playpause.setOnClickListener(v -> {
                if (Launcher.kwAPi != null) {
                    Launcher.this.needStartKuwo();
                    if (Launcher.this.mKwPlayState) {
                        Launcher.kwAPi.setPlayState(Launcher.mLauncher, PlayState.STATE_PAUSE);
                    } else {
                        Launcher.kwAPi.setPlayState(Launcher.mLauncher, PlayState.STATE_PLAY);
                    }
                }
            });
        }
        if (kuwomusic_prev != null) {
            kuwomusic_prev.setOnClickListener(v -> {
                if (Launcher.kwAPi != null) {
                    Launcher.this.needStartKuwo();
                    Launcher.kwAPi.setPlayState(Launcher.this.getApplicationContext(), PlayState.STATE_PRE);
                }
            });
        }
        if (kuwomusic_next != null) {
            kuwomusic_next.setOnClickListener(v -> {
                if (Launcher.kwAPi != null) {
                    Launcher.this.needStartKuwo();
                    Launcher.kwAPi.setPlayState(Launcher.this.getApplicationContext(), PlayState.STATE_NEXT);
                }
            });
        }
        if (mBtavPrevButton != null) {
            mBtavPrevButton.setOnClickListener(v -> {
                Intent intent = new Intent();
                intent.setAction("com.syu.bt.byav.widgetPrev");
                intent.setPackage("com.syu.bt");
                Launcher.this.startService(intent);
            });
        }
        if (mBtavNextButton != null) {
            mBtavNextButton.setOnClickListener(v -> {
                Intent intent = new Intent();
                intent.setAction("com.syu.bt.byav.widgetNext");
                intent.setPackage("com.syu.bt");
                Launcher.this.startService(intent);
            });
        }
        if (mBtavPlayPauseButton != null) {
            mBtavPlayPauseButton.setOnClickListener(v -> {
                Intent intent = new Intent();
                intent.setAction("com.syu.bt.byav.widgetPlayPause");
                intent.setPackage("com.syu.bt");
                Launcher.this.startService(intent);
            });
        }
        if (mBtavIcon != null) {
            mBtavIcon.setOnClickListener(v -> {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
                Launcher.this.startActivity(intent);
            });
        }
        if (mRadioIcon != null) {
            mRadioIcon.setOnClickListener(v -> Launcher.this.startActivitySafely(v, FytPackage.getIntent(Launcher.mLauncher, "com.syu.radio"), "bt"));
        }
        if (mMusicIcon != null) {
            mMusicIcon.setOnClickListener(v -> Launcher.this.startActivitySafely(v, FytPackage.getIntent(Launcher.mLauncher, "com.syu.music"), "bt"));
        }
        if (mNaviView != null) {
            mNaviView.setOnClickListener(v -> {
                Intent launchIntent = new Intent();
                launchIntent.setComponent(new ComponentName(FytPackage.GaodeACTION, "com.autonavi.auto.remote.fill.UsbFillActivity"));
                Launcher.this.startActivitySafely(v, launchIntent, "bt");
            });
        }
        if (video_playpause != null) {
            video_playpause.setOnClickListener(v -> {
                if (Launcher.this.mVideoPlayState != null) {
                    if (Launcher.this.mVideoPlayState.equals("true")) {
                        CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 2);
                    } else {
                        CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 1);
                    }
                }
            });
        }
        if (video_prev != null) {
            video_prev.setOnClickListener(v -> CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 10));
        }
        if (video_next != null) {
            video_next.setOnClickListener(v -> CarStates.getCar(Launcher.this.getApplicationContext()).mTools.sendInt(0, 20, 11));
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
                    if (mInitNaviInfoView != null) {
                        mInitNaviInfoView.setVisibility(android.view.View.GONE);
                    }
                    if (mNaviRunView != null) {
                        mNaviRunView.setVisibility(android.view.View.VISIBLE);
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
        if (mCurCityView != null) {
            mCurCityView.setText("");
        }
        if (mInitNaviInfoView != null) {
            mInitNaviInfoView.setVisibility(android.view.View.VISIBLE);
        }
        if (mNaviRunView != null) {
            mNaviRunView.setVisibility(android.view.View.GONE);
        }
        if (mTurnIconView != null) {
            mTurnIconView.setImageResource(ResValue.getInstance().default_icon);
        }
        if (mCurDis_RemainView != null) {
            mCurDis_RemainView.setText(Utils.getNameToStr("car_distance"));
        }
        if (mCurRemainTimeView != null) {
            mCurRemainTimeView.setText("");
        }
        if (mCurDis_AllView != null) {
            mCurDis_AllView.setText("0");
        }
        if (mCurDis_SurplusView != null) {
            mCurDis_SurplusView.setText("0km");
        }
        if (mCamera_DisView != null) {
            mCamera_DisView.setText("");
        }
        if (mCamera_DisImageView != null) {
            mCamera_DisImageView.setVisibility(android.view.View.GONE);
        }
        if (mCurRemainTimeView != null) {
            mCurRemainTimeView.setText("");
        }
        if (mNextRoadNameView != null) {
            mNextRoadNameView.setText(Utils.getNameToStr("car_realnavi"));
        }
        if (mNaviMycar != null) {
            mNaviMycar.setVisibility(android.view.View.VISIBLE);
        }
        if (mCurSpeedView != null) {
            mCurSpeedView.setText("0km/h");
        }
    }

    private void needStartAmap() {
        if (!AppUtil.isInTheTaskbar(getApplicationContext(), FytPackage.GaodeACTION)) {
            startActivitySafely(getCustomView(Config.WS_Gaode), FytPackage.getIntent(this, FytPackage.GaodeACTION), "amap");
        }
    }

    public void updateLoadAnima() {
        if (mDynamicTrailView != null) {
            if (MyAutoMapReceiver.mCurSpeed >= 10) {
                mDynamicTrailView.setBackgroundResource(ResValue.getInstance().map_bg1 + count);
                count++;
                if (count == getResources().getInteger(R.integer.apps_widget_pic_sum)) {
                    count = 0;
                    return;
                }
                return;
            }
            mDynamicTrailView.setBackgroundResource(ResValue.getInstance().map_bg1);
        }
    }

    public void handleView() {
        String str;
        if (CarStates.mAccState != 0) {
            if (mInitNaviInfoView != null && mNaviRunView != null) {
                mInitNaviInfoView.setVisibility(android.view.View.GONE);
                mNaviRunView.setVisibility(android.view.View.VISIBLE);
            }
            if (MyAutoMapReceiver.mTurnIcon <= 0) {
                clearGaoDeData();
                return;
            }
            if (mTurnIconView != null) {
                switch (MyAutoMapReceiver.mTurnIcon) {
                    case 2:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_left);
                        break;
                    case 3:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_right);
                        break;
                    case 4:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_left_up);
                        break;
                    case 5:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_right_up);
                        break;
                    case 6:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_leftdown);
                        break;
                    case 7:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_rightdown);
                        break;
                    case 8:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_leftback);
                        break;
                    case 9:
                        mTurnIconView.setImageResource(ResValue.getInstance().straight);
                        break;
                    case 10:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_mid_dest);
                        break;
                    case 11:
                        mTurnIconView.setImageResource(ResValue.getInstance().trun_island_right);
                        break;
                    case 12:
                        mTurnIconView.setImageResource(ResValue.getInstance().trun_island_right_line);
                        break;
                    case 13:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_park);
                        break;
                    case 14:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_charge);
                        break;
                    case 15:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_dest);
                        break;
                    case 16:
                        mTurnIconView.setImageResource(ResValue.getInstance().tunnel);
                        break;
                    case 17:
                        mTurnIconView.setImageResource(ResValue.getInstance().trun_island_left);
                        break;
                    case 18:
                        mTurnIconView.setImageResource(ResValue.getInstance().trun_island_left_line);
                        break;
                    case 19:
                        mTurnIconView.setImageResource(ResValue.getInstance().turn_rightback);
                        break;
                    case 20:
                        mTurnIconView.setImageResource(ResValue.getInstance().truen_slow_down);
                        break;
                }
            }
            if (mMapbgUnitView != null) {
                if (MyAutoMapReceiver.mCurDis_Remain > 1500) {
                    mMapbgUnitView.setImageResource(ResValue.getInstance().map_distance_bgunit2);
                } else {
                    mMapbgUnitView.setImageResource(ResValue.getInstance().map_distance_bgunit);
                }
            }
            if (mCurDis_RemainView != null) {
                if (MyAutoMapReceiver.mCurDis_Remain > 1500) {
                    float dis = MyAutoMapReceiver.mCurDis_Remain / 1000.0f;
                    str = String.format("%1$.1f", Float.valueOf(dis));
                    if (mMapbgUnitView == null) {
                        str = String.valueOf(str) + "KM";
                    }
                } else {
                    str = new StringBuilder(String.valueOf(MyAutoMapReceiver.mCurDis_Remain)).toString();
                    if (mMapbgUnitView == null) {
                        str = String.valueOf(str) + "M";
                    }
                }
                LogPreview.show("str:" + str);
                mCurDis_RemainView.setText(str);
            }
            if (mCurSpeedView != null) {
                mCurSpeedView.setText(String.valueOf(MyAutoMapReceiver.mCurSpeed) + "km/h");
            }
            if (mCurDis_AllView != null) {
                float dis2 = MyAutoMapReceiver.mCurDis_All / 1000.0f;
                String str2 = String.format("%1$.1f", Float.valueOf(dis2));
                mCurDis_AllView.setText(String.valueOf(str2) + "km");
            }
            if (mCurDis_SurplusView != null) {
                float dis3 = MyAutoMapReceiver.mREMAINDis / 1000.0f;
                String str3 = String.format("%1$.1f", Float.valueOf(dis3));
                mCurDis_SurplusView.setText(String.valueOf(str3) + "km");
            }
            if (mCamera_DisView != null) {
                if (MyAutoMapReceiver.mCameraDis == -1) {
                    mCamera_DisView.setText("");
                } else {
                    mCamera_DisView.setText(String.valueOf(MyAutoMapReceiver.mCameraDis) + "m");
                }
            }
            if (mCamera_DisImageView != null) {
                if (MyAutoMapReceiver.mCameraDis == -1) {
                    mCamera_DisImageView.setVisibility(android.view.View.GONE);
                } else {
                    mCamera_DisImageView.setVisibility(android.view.View.VISIBLE);
                }
            }
            if (mCurRemainTimeView != null) {
                int mREMAINTime = MyAutoMapReceiver.mREMAINTime;
                String time = formatDuration(mREMAINTime);
                mCurRemainTimeView.setText(String.valueOf(time) + getApplicationContext().getResources().getString(ResValue.getInstance().getId("tv_road", "string")));
            }
            if (mCurRoadNameView != null) {
                mCurRoadNameView.setText(MyAutoMapReceiver.mCurRoadName);
                mCurRoadNameView.setVisibility(android.view.View.VISIBLE);
            }
            if (mNextRoadNameView != null) {
                mNextRoadNameView.setText("进入  " + MyAutoMapReceiver.mNextRoadName);
                mNextRoadNameView.setVisibility(android.view.View.VISIBLE);
            }
            if (mNaviMycar != null) {
                mNaviMycar.setVisibility(android.view.View.GONE);
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
        BubbleTextView favorite = (BubbleTextView) mInflater.inflate(layoutResId, parent, false);
        favorite.applyFromShortcutInfo(info, mIconCache);
        favorite.setOnClickListener(this);
        return favorite;
    }

    void completeAddApplication(Intent data, long container, long screenId, int cellX, int cellY) {
        final int[] cellXY = mTmpAddItemCellCoordinates;
        final CellLayout layout = getCellLayout(container, screenId);

        // First we check if we already know the exact location where we want to add this item.
        if (cellX >= 0 && cellY >= 0) {
            cellXY[0] = cellX;
            cellXY[1] = cellY;
        } else if (!layout.findCellForSpan(cellXY, 1, 1)) {
            showOutOfSpaceMessage(isHotseatLayout(layout));
            return;
        }

        final ShortcutInfo info = mModel.getShortcutInfo(getPackageManager(), data, this);

        if (info != null) {
            info.setActivity(this, data.getComponent(), Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            info.container = ItemInfo.NO_ID;
            mWorkspace.addApplicationShortcut(info, layout, container, screenId, cellXY[0], cellXY[1],
                    isWorkspaceLocked(), cellX, cellY);
        } else {
            Log.e(TAG, "Couldn't find ActivityInfo for selected application: " + data);
        }
    }

    private void completeAddShortcut(Intent data, long container, long screenId, int cellX,
            int cellY) {
        int[] cellXY = mTmpAddItemCellCoordinates;
        int[] touchXY = mPendingAddInfo.dropPos;
        CellLayout layout = getCellLayout(container, screenId);

        boolean foundCellSpan = false;

        ShortcutInfo info = mModel.infoFromShortcutIntent(this, data, null);
        if (info == null) {
            return;
        }
        final View view = createShortcut(info);

        // First we check if we already know the exact location where we want to add this item.
        if (cellX >= 0 && cellY >= 0) {
            cellXY[0] = cellX;
            cellXY[1] = cellY;
            foundCellSpan = true;

            // If appropriate, either create a folder or add to an existing folder
            if (mWorkspace.createUserFolderIfNecessary(view, container, layout, cellXY, 0,
                    true, null,null)) {
                return;
            }
            DropTarget.DragObject dragObject = new DropTarget.DragObject();
            dragObject.dragInfo = info;
            if (mWorkspace.addToExistingFolderIfNecessary(view, layout, cellXY, 0, dragObject,
                    true)) {
                return;
            }
        } else if (touchXY != null) {
            // when dragging and dropping, just find the closest free spot
            int[] result = layout.findNearestVacantArea(touchXY[0], touchXY[1], 1, 1, cellXY);
            foundCellSpan = (result != null);
        } else {
            foundCellSpan = layout.findCellForSpan(cellXY, 1, 1);
        }

        if (!foundCellSpan) {
            showOutOfSpaceMessage(isHotseatLayout(layout));
            return;
        }

        LauncherModel.addItemToDatabase(this, info, container, screenId, cellXY[0], cellXY[1], false);

        if (!mRestoring) {
            mWorkspace.addInScreen(view, container, screenId, cellXY[0], cellXY[1], 1, 1,
                    isWorkspaceLocked());
        }
    }

    static int[] getSpanForWidget(Context context, ComponentName component, int minWidth,
            int minHeight) {
        Rect padding = AppWidgetHostView.getDefaultPaddingForWidget(LauncherApplication.sApp, component, null);
        // We want to account for the extra amount of padding that we are adding to the widget
        // to ensure that it gets the full amount of space that it has requested
        int requiredWidth = minWidth + padding.left + padding.right;
        int requiredHeight = minHeight + padding.top + padding.bottom;
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
        return getSpanForWidget(context, info.componentName, info.minResizeWidth,
                info.minResizeHeight);
    }

    private void completeAddAppWidget(final int appWidgetId, long container, long screenId, AppWidgetHostView hostView, AppWidgetProviderInfo appWidgetInfo) {
        Log.i("WIDGET", "completeAddAppWidget");
        if (appWidgetInfo == null) {
            Log.e("WIDGET", "AppWidgetProviderInfo is null for ID: " + appWidgetId);
            appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId);
        }

        // Calculate the grid spans needed to fit this widget
        CellLayout layout = getCellLayout(container, screenId);

        int[] minSpanXY = getMinSpanForWidget(this, appWidgetInfo);
        int[] spanXY = getSpanForWidget(this, appWidgetInfo);

        // Try finding open space on Launcher screen
        // We have saved the position to which the widget was dragged-- this really only matters
        // if we are placing widgets on a "spring-loaded" screen
        int[] cellXY = mTmpAddItemCellCoordinates;
        int[] touchXY = mPendingAddInfo.dropPos;
        int[] finalSpan = new int[2];
        boolean foundCellSpan = false;
        if (mPendingAddInfo.cellX >= 0 && mPendingAddInfo.cellY >= 0) {
            cellXY[0] = mPendingAddInfo.cellX;
            cellXY[1] = mPendingAddInfo.cellY;
            spanXY[0] = mPendingAddInfo.spanX;
            spanXY[1] = mPendingAddInfo.spanY;
            foundCellSpan = true;
        } else if (touchXY != null) {
            // when dragging and dropping, just find the closest free spot
            int[] result = layout.findNearestVacantArea(
                    touchXY[0], touchXY[1], minSpanXY[0], minSpanXY[1], spanXY[0],
                    spanXY[1], cellXY, finalSpan);
            spanXY[0] = finalSpan[0];
            spanXY[1] = finalSpan[1];
            foundCellSpan = (result != null);
        } else {
            foundCellSpan = layout.findCellForSpan(cellXY, minSpanXY[0], minSpanXY[1]);
        }

        if (!foundCellSpan) {
            if (appWidgetId != -1) {
                // Deleting an app widget ID is a void call but writes to disk before returning
                // to the caller...
                new Thread("deleteAppWidgetId") {
                    public void run() {
                        mAppWidgetHost.deleteAppWidgetId(appWidgetId);
                    }
                }.start();
            }
            showOutOfSpaceMessage(isHotseatLayout(layout));
            return;
        }

        // Build Launcher-specific widget info and save to database
        LauncherAppWidgetInfo launcherInfo = new LauncherAppWidgetInfo(appWidgetId,
                appWidgetInfo.provider);
        launcherInfo.spanX = spanXY[0];
        launcherInfo.spanY = spanXY[1];
        launcherInfo.minSpanX = mPendingAddInfo.minSpanX;
        launcherInfo.minSpanY = mPendingAddInfo.minSpanY;
        Log.d("WIDGET_SPAN", "Min Span: " + minSpanXY[0] + "x" + minSpanXY[1]);
        Log.d("WIDGET_SPAN", "Target Span: " + spanXY[0] + "x" + spanXY[1]);

        try {
            LauncherModel.addItemToDatabase(this, launcherInfo,
                container, screenId, cellXY[0], cellXY[1], false);
        } catch (Exception e) {
            Log.e("WIDGET_DB", "Failed to add widget to database", e);
        }

        if (!mRestoring) {
            if (hostView == null) {
                // Perform actual inflation because we're live
                launcherInfo.hostView = mAppWidgetHost.createView(LauncherApplication.sApp, appWidgetId, appWidgetInfo);
                launcherInfo.hostView.setAppWidget(appWidgetId, appWidgetInfo);
            } else {
                // The AppWidgetHostView has already been inflated and instantiated
                launcherInfo.hostView = hostView;
            }

            launcherInfo.hostView.setTag(launcherInfo);
            launcherInfo.hostView.setVisibility(View.VISIBLE);
            launcherInfo.notifyWidgetSizeChanged(this);

            mWorkspace.addInScreen(launcherInfo.hostView, container, screenId, cellXY[0], cellXY[1],
                    launcherInfo.spanX, launcherInfo.spanY, isWorkspaceLocked());

            addWidgetToAutoAdvanceIfNeeded(launcherInfo.hostView, appWidgetInfo);
        }
        resetAddInfo();
        WindowUtil.removePip(null);
        mWorkspace.triggerStripEmptyScreens("Launcher, completeAddAppWidget()", true);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FirstFrameAnimatorHelper.initializeDrawListener(getWindow().getDecorView());
        mAttached = true;
        mVisible = true;
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mVisible = false;
        mAttached = false;
        updateRunning();
        cleanWidgetBar();
    }

    public void cleanWidgetBar() {
        boolean autoHideBottomBar = mPrefs.getBoolean(Keys.AUTO_HIDE_BOTTOM_BAR, false);
        if (autoHideBottomBar && widgetBar) {
            if (mWorkspace != null) {
                mWorkspace.hideOverlayBottomBar();
                mWorkspace.cancelPendingAutoHide();
                mWorkspace.clearWidgetReferences();
            }
            ivALbumBgTwo = null;
            tvMusicNameTwo = null;
            tvAritstTwo = null;
            weatherImg1 = null;
            weatherCity1 = null;
            weatherTemp = null;
            weatherWeather1 = null;
            cleanupViewRecursively(prevLayoutTwo);
            cleanupViewRecursively(playPauseLayoutTwo);
            cleanupViewRecursively(nextLayoutTwo);
            cleanupViewRecursively(mMusicNextButtonTwo);
            cleanupViewRecursively(mMusicPrevButtonTwo);
            cleanupViewRecursively(mPlayPauseButtonTwo);
            prevLayoutTwo = null;
            playPauseLayoutTwo = null;
            nextLayoutTwo = null;
            mMusicNextButtonTwo = null;
            mMusicPrevButtonTwo = null;
            mPlayPauseButtonTwo = null;
            removeCustomView("WS_Music_Two");
        }
    }    

    private void cleanupViewRecursively(View view) {
        if (view == null) return;
        
        // Clear listeners from the parent
        view.setOnClickListener(null);
        view.setOnTouchListener(null);
        view.setOnLongClickListener(null);
    }

    public void onWindowVisibilityChanged(int visibility) {
        mVisible = visibility == 0;
        updateRunning();
        if (mVisible) {
            mAppsCustomizeTabHost.onWindowVisible();
            if (!mWorkspaceLoading) {
                ViewTreeObserver observer = mWorkspace.getViewTreeObserver();
                onDrawListener = new ViewTreeObserver.OnDrawListener() {
                    private boolean mStarted = false;

                    @Override
                    public void onDraw() {
                        if (!mStarted) {
                            mStarted = true;
                            Launcher.mWorkspace.postDelayed(Launcher.this.mBuildLayersRunnable, 500L);
                            //final ViewTreeObserver.OnDrawListener listener = this;
                            Launcher.mWorkspace.post(new Runnable() { 
                                @Override
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

    
    public void sendAdvanceMessage(long delay) {
        mHandler.removeMessages(1);
        Message msg = mHandler.obtainMessage(1);
        mHandler.sendMessageDelayed(msg, delay);
        mAutoAdvanceSentTime = System.currentTimeMillis();
    }

    
    public void updateRunning() {
        boolean autoAdvanceRunning = mVisible && mUserPresent && !mWidgetsToAdvance.isEmpty();
        if (autoAdvanceRunning != mAutoAdvanceRunning) {
            mAutoAdvanceRunning = autoAdvanceRunning;
            if (autoAdvanceRunning) {
                long delay = mAutoAdvanceTimeLeft != -1 ? mAutoAdvanceTimeLeft : 20000L;
                sendAdvanceMessage(delay);
            } else {
                if (!mWidgetsToAdvance.isEmpty()) {
                    mAutoAdvanceTimeLeft = Math.max(0L, 20000 - (System.currentTimeMillis() - mAutoAdvanceSentTime));
                }
                mHandler.removeMessages(1);
                mHandler.removeMessages(0);
            }
        }
    }

    void addWidgetToAutoAdvanceIfNeeded(View hostView, AppWidgetProviderInfo appWidgetInfo) {
        if (appWidgetInfo == null || appWidgetInfo.autoAdvanceViewId == -1) return;
        View v = hostView.findViewById(appWidgetInfo.autoAdvanceViewId);
        if (v instanceof Advanceable) {
            mWidgetsToAdvance.put(hostView, appWidgetInfo);
            ((Advanceable) v).fyiWillBeAdvancedByHostKThx();
            updateRunning();
        }
    }

    void removeWidgetToAutoAdvance(View hostView) {
        if (mWidgetsToAdvance.containsKey(hostView)) {
            mWidgetsToAdvance.remove(hostView);
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
        return mAppWidgetHost;
    }

    public static LauncherModel getModel() {
        return mModel;
    }

    public void closeSystemDialogs() {
        getWindow().closeAllPanels();
        mWaitingForResult = false;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        long startTime = 0;
        if (DEBUG_RESUME_TIME) {
            startTime = System.currentTimeMillis();
        }
        super.onNewIntent(intent);

        // Close the menu
        if (Intent.ACTION_MAIN.equals(intent.getAction())) {
            // also will cancel mWaitingForResult.
            closeSystemDialogs();

            final boolean alreadyOnHome = mHasFocus && ((intent.getFlags() &
                    Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT)
                    != Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);

            if (mWorkspace == null) {
                // Can be cases where mWorkspace is null, this prevents a NPE
                return;
            }
            Folder openFolder = mWorkspace.getOpenFolder();
            // In all these cases, only animate if we're already on home
            mWorkspace.exitWidgetResizeMode();
            if (alreadyOnHome && mState == State.WORKSPACE && !mWorkspace.isTouchActive() &&
                    openFolder == null) {
                mWorkspace.moveToDefaultScreen(true);
            }

            closeFolder();
            exitSpringLoadedDragMode();

            // If we are already on home, then just animate back to the workspace,
            // otherwise, just wait until onResume to set the state back to Workspace
            if (alreadyOnHome) {
                showWorkspace(true);
            } else {
                mOnResumeState = State.WORKSPACE;
            }

            final View v = getWindow().peekDecorView();
            if (v != null && v.getWindowToken() != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

            // Reset the apps customize page
            if (mAppsCustomizeTabHost != null) {
                mAppsCustomizeTabHost.reset();
            }
        }

        if (DEBUG_RESUME_TIME) {
            Log.d(TAG, "Time spent in onNewIntent: " + (System.currentTimeMillis() - startTime));
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        Iterator<Integer> it = mSynchronouslyBoundPages.iterator();
        while (it.hasNext()) {
            int page = it.next().intValue();
            mWorkspace.restoreInstanceStateForChild(page);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (mWorkspace != null && mWorkspace.getChildCount() > 0) {
            outState.putInt(RUNTIME_STATE_CURRENT_SCREEN, mWorkspace.getRestorePage());
        }
        super.onSaveInstanceState(outState);
        outState.putInt(RUNTIME_STATE, mState.ordinal());
        closeFolder();
        if (mPendingAddInfo.container != -1 && mPendingAddInfo.screenId > -1 && mWaitingForResult) {
            outState.putLong(RUNTIME_STATE_PENDING_ADD_CONTAINER, mPendingAddInfo.container);
            outState.putLong(RUNTIME_STATE_PENDING_ADD_SCREEN, mPendingAddInfo.screenId);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_CELL_X, mPendingAddInfo.cellX);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_CELL_Y, mPendingAddInfo.cellY);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_X, mPendingAddInfo.spanX);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_Y, mPendingAddInfo.spanY);
            outState.putParcelable(RUNTIME_STATE_PENDING_ADD_WIDGET_INFO, mPendingAddWidgetInfo);
            outState.putInt(RUNTIME_STATE_PENDING_ADD_WIDGET_ID, mPendingAddWidgetId);
        }
        if (mFolderInfo != null && mWaitingForResult) {
            outState.putBoolean(RUNTIME_STATE_PENDING_FOLDER_RENAME, true);
            outState.putLong(RUNTIME_STATE_PENDING_FOLDER_RENAME_ID, mFolderInfo.id);
        }
        if (mAppsCustomizeTabHost != null) {
            String currentTabTag = mAppsCustomizeTabHost.getCurrentTabTag();
            if (currentTabTag != null) {
                outState.putString("apps_customize_currentTab", currentTabTag);
            }
            int currentIndex = mAppsCustomizeContent.getSaveInstanceStateIndex();
            outState.putInt("apps_customize_currentIndex", currentIndex);
        }
    }

    public DragController getDragController() {
        return mDragController;
    }

    @Override
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
        if (mSearchDropTargetBar != null) {
            sourceBounds = mSearchDropTargetBar.getSearchBarBounds();
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

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (!mWorkspace.isInOverviewMode()) {
            mWorkspace.enterOverviewMode();
            return false;
        }
        return false;
    }

    @Override
    public boolean onSearchRequested() {
        startSearch((String) null, false, (Bundle) null, true);
        return true;
    }

    public boolean isWorkspaceLocked() {
        return mWorkspaceLoading || mWaitingForResult;
    }

    public void resetAddInfo() {
        mPendingAddInfo.container = -1L;
        mPendingAddInfo.screenId = -1L;
        ItemInfo itemInfo = mPendingAddInfo;
        mPendingAddInfo.cellY = -1;
        itemInfo.cellX = -1;
        ItemInfo itemInfo2 = mPendingAddInfo;
        mPendingAddInfo.spanY = -1;
        itemInfo2.spanX = -1;
        ItemInfo itemInfo3 = mPendingAddInfo;
        mPendingAddInfo.minSpanY = -1;
        itemInfo3.minSpanX = -1;
        mPendingAddInfo.dropPos = null;
    }

    void addAppWidgetImpl(final int appWidgetId, ItemInfo info, AppWidgetHostView boundWidget,
                          AppWidgetProviderInfo appWidgetInfo) {
        if (appWidgetInfo.configure != null) {
            mPendingAddWidgetInfo = appWidgetInfo;
            mPendingAddWidgetId = appWidgetId;

            // Launch over to configure widget, if needed
            Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_CONFIGURE);
            intent.setComponent(appWidgetInfo.configure);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            Utilities.startActivityForResultSafely(this, intent, REQUEST_CREATE_APPWIDGET);

            // prepared for Android 14 and higher in case the function above fails
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                ActivityOptions options = ActivityOptions.makeBasic()
                        .setPendingIntentBackgroundActivityStartMode(
                                ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOWED);
                Bundle bundle = options.toBundle();
                mAppWidgetHost.startAppWidgetConfigureActivityForResult(this, appWidgetId, 0, REQUEST_CREATE_APPWIDGET, bundle);
            } else {
                Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_CONFIGURE);
                intent.setComponent(appWidgetInfo.configure);
                intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
                Utilities.startActivityForResultSafely(this, intent, REQUEST_CREATE_APPWIDGET);
            }*/
        } else {
            // Otherwise just add it
            completeAddAppWidget(appWidgetId, info.container, info.screenId, boundWidget,
                    appWidgetInfo);
            // Exit spring loaded mode if necessary after adding the widget
            exitSpringLoadedDragModeDelayed(true, false, null);
        }
    }

    protected void moveToCustomContentScreen(boolean animate) {
        closeFolder();
        mWorkspace.moveToCustomContentScreen(animate);
    }

    void processShortcutFromDrop(ComponentName componentName, long container, long screenId, int[] cell, int[] loc) {
        resetAddInfo();
        mPendingAddInfo.container = container;
        mPendingAddInfo.screenId = screenId;
        mPendingAddInfo.dropPos = loc;
        if (cell != null) {
            mPendingAddInfo.cellX = cell[0];
            mPendingAddInfo.cellY = cell[1];
        }
        Intent createShortcutIntent = new Intent("android.intent.action.CREATE_SHORTCUT");
        createShortcutIntent.setComponent(componentName);
        processShortcut(createShortcutIntent);
    }

    void addAppWidgetFromDrop(PendingAddWidgetInfo info, long container, long screenId, int[] cell, int[] span, int[] loc) {
        Log.i("WIDGET", "addAppWidgetFromDrop");
        resetAddInfo();
        mPendingAddInfo.container = info.container = container;
        mPendingAddInfo.screenId = info.screenId = screenId;
        mPendingAddInfo.dropPos = loc;
        mPendingAddInfo.minSpanX = info.minSpanX;
        mPendingAddInfo.minSpanY = info.minSpanY;

        if (cell != null) {
            mPendingAddInfo.cellX = cell[0];
            mPendingAddInfo.cellY = cell[1];
        }
        if (span != null) {
            mPendingAddInfo.spanX = span[0];
            mPendingAddInfo.spanY = span[1];
        }

        AppWidgetHostView hostView = info.boundWidget;
        int appWidgetId;
        if (hostView != null) {
            appWidgetId = hostView.getAppWidgetId();
            addAppWidgetImpl(appWidgetId, info, hostView, info.info);
        } else {
            // In this case, we either need to start an activity to get permission to bind
            // the widget, or we need to start an activity to configure the widget, or both.
            appWidgetId = getAppWidgetHost().allocateAppWidgetId();
            Bundle options = info.bindOptions;

            boolean success = false;
            if (options != null) {
                success = mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId,
                        info.componentName, options);
            } else {
                success = mAppWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId,
                        info.componentName);
            }
            if (success) {
                addAppWidgetImpl(appWidgetId, info, null, info.info);
            } else {
                mPendingAddWidgetInfo = info.info;
                Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_BIND);
                intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
                intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_PROVIDER, info.componentName);
                // TODO: we need to make sure that this accounts for the options bundle.
                // intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_OPTIONS, options);
                startActivityForResult(intent, REQUEST_BIND_APPWIDGET);
            }
        }
    }

    void processShortcut(Intent intent) {
        // Handle case where user selected "Applications"
        String applicationName = getResources().getString(R.string.group_applications);
        String shortcutName = intent.getStringExtra(Intent.EXTRA_SHORTCUT_NAME);

        if (applicationName != null && applicationName.equals(shortcutName)) {
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            Intent pickIntent = new Intent(Intent.ACTION_PICK_ACTIVITY);
            pickIntent.putExtra(Intent.EXTRA_INTENT, mainIntent);
            pickIntent.putExtra(Intent.EXTRA_TITLE, getText(R.string.title_select_application));
            Utilities.startActivityForResultSafely(this, pickIntent, REQUEST_PICK_APPLICATION);
        } else {
            Utilities.startActivityForResultSafely(this, intent, REQUEST_CREATE_SHORTCUT);
        }
    }

    void processWallpaper(Intent intent) {
        startActivityForResult(intent, REQUEST_PICK_WALLPAPER);
    }

    FolderIcon addFolder(CellLayout layout, long container, final long screenId, int cellX,
            int cellY) {
        final FolderInfo folderInfo = new FolderInfo();
        folderInfo.title = getText(R.string.folder_name);

        // Update the model
        LauncherModel.addItemToDatabase(Launcher.this, folderInfo, container, screenId, cellX, cellY,
                false);
        sFolders.put(folderInfo.id, folderInfo);

        // Create the view
        FolderIcon newFolder =
            FolderIcon.fromXml(R.layout.folder_icon, this, layout, folderInfo, mIconCache);
        mWorkspace.addInScreen(newFolder, container, screenId, cellX, cellY, 1, 1,
                isWorkspaceLocked());
        // Force measure the new folder icon
        CellLayout parent = mWorkspace.getParentCellLayoutForView(newFolder);
        parent.getShortcutsAndWidgets().measureChild(newFolder);
        return newFolder;
    }

    void removeFolder(FolderInfo folder) {
        sFolders.remove(folder.id);
    }

    /**
     * Registers various content observers. The current implementation registers
     * only a favorites observer to keep track of the favorites applications.
     */
    private void registerContentObservers() {
        ContentResolver resolver = getContentResolver();
        resolver.registerContentObserver(LauncherProvider.CONTENT_APPWIDGET_RESET_URI,
                true, mWidgetObserver);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_HOME:
                    return true;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    if (isPropertyEnabled(DUMP_STATE_PROPERTY)) {
                        dumpState();
                        return true;
                    }
                    break;
            }
        } else if (event.getAction() == KeyEvent.ACTION_UP) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_HOME:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }

    public void setButtonVisible(boolean flag) {
        if (wallpaperButton == null || widgetButton == null || settingsButton == null || wallpaperButtonWidgets == null || settingsButtonWidgets == null) { 
            wallpaperButton = findViewById(ResValue.getInstance().wallpaper_button);
            widgetButton = findViewById(ResValue.getInstance().widget_button);
            settingsButton = findViewById(ResValue.getInstance().settings_button);
            
            wallpaperButtonWidgets = findViewById(ResValue.getInstance().wallpaper_button_widgets);
            settingsButtonWidgets = findViewById(ResValue.getInstance().settings_button_widgets);
        }
        if (flag) {
            if (wallpaperButton != null) {
                wallpaperButton.setVisibility(View.VISIBLE);
            }
            if (widgetButton != null) {
                widgetButton.setVisibility(View.VISIBLE);
            }
            if (settingsButton != null) {
                settingsButton.setVisibility(View.VISIBLE);
            }
            if (wallpaperButtonWidgets != null) {
                wallpaperButtonWidgets.setVisibility(View.VISIBLE);
            }
            if (settingsButtonWidgets != null) {
                settingsButtonWidgets.setVisibility(View.VISIBLE);
            }
            return;
        }
        if (wallpaperButton != null) {
            wallpaperButton.setVisibility(android.view.View.GONE);
        }
        if (widgetButton != null) {
            widgetButton.setVisibility(android.view.View.GONE);
        }
        if (settingsButton != null) {
            settingsButton.setVisibility(android.view.View.GONE);
        }
        if (wallpaperButtonWidgets != null) {
            wallpaperButtonWidgets.setVisibility(android.view.View.GONE);
        }
        if (settingsButtonWidgets != null) {
            settingsButtonWidgets.setVisibility(android.view.View.GONE);
        }
    }
    
    public void onAppWidgetReset() {
        if (mAppWidgetHost != null) {
            mAppWidgetHost.startListening();
        }
    }

    @Override
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
            if (tag instanceof ShortcutInfo shortcut) {
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
                        onClickAllAppsButton();
                        return;
                    } else if (shortcutClass.contains("com.syu.radio")) {
                        stopMusic();
                    } 
                }
                int[] pos = new int[2];
                v.getLocationOnScreen(pos);
                intent.setSourceBounds(new Rect(pos[0], pos[1], pos[0] + v.getWidth(), pos[1] + v.getHeight()));
                try {
                    ComponentName componentName = intent.getComponent();
                    PackageManager pm = getPackageManager();
                    ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                    String appTitle = appInfo.loadLabel(pm).toString();
                    AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                    refreshLeftCycle(bean);
                    if (componentName.getClassName().equals("com.android.launcher66.settings.SettingsActivity")) {
                        Intent settingsIntent = new Intent(this, SettingsActivity.class);
                        settingsIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(settingsIntent);
                    }
                    cleanWidgetBar();
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException(e);
                }
                boolean successShortcut = startActivitySafely(v, intent, tag);
                if (successShortcut && (v instanceof BubbleTextView mBubbleTextView)) {
                    mBubbleTextView.setStayPressed(false);
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
            if (v == mAllAppsButton || v == getCustomView(Config.WS_Allapps) || v == getCustomView(Config.ALLAPP)) {
                if (isAllAppsVisible()) {
                    showWorkspace(true);
                    return;
                } else {
                    onClickAllAppsButton();
                    return;
                }
            }
            if (v == getCustomView(Config.WS_Showbar)) {
                onClickShowBarButton();
            }
            if (v == getCustomView(Config.NAVI)) {
                CarStates.getCar(getApplicationContext()).mTools.sendInt(0, 24, 0);
                return;
            }
            if (v == getCustomView(Config.VOICE)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.voiceAction), "bt");
                return;
            }
            if (v == getCustomView(Config.BT)) {
                startActivitySafely(v, getIntent("com.syu.bt", "com.syu.bt.BtAct"), "bt");
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.RADIO)) {
                if (CarStates.mExistCarRadio == 1) {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.CARRADIOACTION), "bt");
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.radio"), "bt");
                }
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.WS_Radio)) {
                stopMusic();
                if (CarStates.mExistCarRadio == 1) {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.CARRADIOACTION), "bt");
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.radio"), "music");
                }
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.WS_Music) || v == getCustomView(Config.WS_Music_Two) || v == getCustomView(Config.WS_Music3)) {
                if (mediaSource == "fyt") {
                    WindowUtil.removePip(pipViews);
                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.syu.music");
                    try {
                        ComponentName componentName = launchIntent.getComponent();
                        PackageManager pm = getPackageManager();
                        ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                        String appTitle = appInfo.loadLabel(pm).toString();
                        AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                        refreshLeftCycle(bean);
                        cleanWidgetBar();
                    } catch (PackageManager.NameNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.music"), "music");
                } else if (mediaSource == "mediaController" && activeController != null) {
                    if (!activeController.isEmpty()) { 
                        WindowUtil.removePip(pipViews);
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(activeController);
                        try {
                            ComponentName componentName = launchIntent.getComponent();
                            PackageManager pm = getPackageManager();
                            ApplicationInfo appInfo = pm.getApplicationInfo(componentName.getPackageName(), 0);
                            String appTitle = appInfo.loadLabel(pm).toString();
                            AppListBean bean = new AppListBean(appTitle, componentName.getPackageName(), componentName.getClassName());
                            refreshLeftCycle(bean);
                            cleanWidgetBar();
                        } catch (PackageManager.NameNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        startActivity(launchIntent);
                    }
                }         
                return;
            }
            if (v == getCustomView(Config.WS_Maps)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.mapsAction), "maps");
                return;
            }
            if (v == getCustomView(Config.WS_Spotify)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.spotifyAction), "spotify");
                return;
            }
            if (v == getCustomView(Config.WS_YouTube)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.youtubeAction), "youtube");
                return;
            }
            if (v == getCustomView(Config.WS_Chrome)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.chromeAction), "chrome");
                return;
            }
            if (v == getCustomView(Config.WS_MusicIV)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.music"), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Video)) {
                WindowUtil.removePip(pipViews);
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.video"), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Gallery)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.galleryAction), "galleryAction");
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.WS_Miudrive)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.miudriveAction), "miudriveAction");
                return;
            }
            if (v == getCustomView(Config.WS_Aux)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.auxAction), "auxAction");
                return;
            }
            if (v == getCustomView(Config.WS_Bt) || v == mBtavView) {
                startActivitySafely(v, getIntent("com.syu.bt", "com.syu.bt.BtAct"), "bt");
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.WS_Navi)) {
                CarStates.getCar(getApplicationContext()).mTools.sendInt(0, 24, 0);
                return;
            }
            if (v == getCustomView(Config.WS_Gaode)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.GaodeACTION), "music");
                return;
            }
            if (v == getCustomView(Config.WS_KLFM)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KLFMACTION), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Kuwo)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KWACTION), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Dvr)) {
                if (Utils.getNameToBool("iscamera360")) {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.camera360"), "camera360");
                    return;
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.INNER_DVR), "music");
                    return;
                }
            }
            if (v == getCustomView(Config.WS_Dvd)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.dvdAction), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Steer)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.steerACTION), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Easyconn)) {
                startActivitySafely(v, FytPackage.getIntent(this, "net.easyconn"), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Recharge)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.unicar"), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Voice)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.voiceAction), "music");
                return;
            }
            if (v == getCustomView(Config.WS_File) || v == getCustomView(Config.FILE)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.filemanagerAction), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Car)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.carAction), "music");
                return;
            }
            if (v == getCustomView(Config.WS_Tire)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.extireAction), "music");
                return;
            }
            if (v == getCustomView(Config.SETTING) || v == getCustomView(Config.WS_Settings)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.settings"), "music");
                return;
            }
            if (v == getCustomView(Config.VIDEO)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.video"), "music");
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.BTAV)) {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
                startActivity(intent2);
                return;
            }
            if (v == getCustomView(Config.ECAR)) {
                Intent intent3 = new Intent();
                intent3.setComponent(new ComponentName(FytPackage.ecarAction, FytPackage.ecarOnlineClassName));
                intent3.addCategory("android.intent.category.MAIN");
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(intent3);
                return;
            }
            if (v == getCustomView(Config.SOS)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.sosAction), "music");
                return;
            }
            if (v == getCustomView(Config.KUWO)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KWACTION), "music");
                return;
            }
            if (v == getCustomView(Config.UNICAR)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.unicar"), "unicar");
                return;
            }
            if (v == getCustomView(Config.MUSIC)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.syu.music"), "music");
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.KLFM)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.KLFMACTION), "music");
                return;
            }
            if (v == getCustomView(Config.HONGFANS)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.hongfansAction), "hongfansAction");
                return;
            }
            if (v == getCustomView(Config.DVR)) {
                if (Utils.getNameToBool("iscamera360")) {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.camera360"), "camera360");
                    return;
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.INNER_DVR), "INNER_DVR");
                    return;
                }
            }
            if (v == getCustomView(Config.LIGHT)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(0, 10, -3);
                return;
            }
            if (v == getCustomView(Config.CLOLSESCREEN) || v == getCustomView(Config.WS_CLOLSESCREEN)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(0, 18, 1);
                return;
            }
            if (v == getCustomView(Config.WIFI)) {
                startActivitySafely(v, new Intent("android.settings.WIFI_SETTINGS"), "settings");
                return;
            }
            if (v == getCustomView(Config.SOUND) || v == getCustomView(Config.WS_SOUND)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(4, 0, -6);
                return;
            }
            if (v == getCustomView(Config.CLOLSESOUND) || v == getCustomView(Config.WS_CLOSESOUND)) {
                CarStates.getCar(getApplicationContext()).getTools().sendInt(4, 0, -6);
                CarStates.getCar(getApplicationContext()).getTools().sendInt(4, 0, -5);
                return;
            }
            if (v == getCustomView(Config.EQ) || v == getCustomView(Config.WS_EQ)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.eqACTION), "eq");
                WindowUtil.removePip(pipViews);
                return;
            }
            if (v == getCustomView(Config.WS_Time) || v == getCustomView(Config.WS_Time_Two)) {
                Intent mIntent = new Intent("android.settings.DATE_SETTINGS");
                startActivitySafely(v, mIntent, "date");
                return;
            }
            if (v == getCustomView(Config.TIME)) {
                Intent mIntent2 = new Intent("android.settings.DATE_SETTINGS");
                startActivitySafely(v, mIntent2, "date");
                return;
            }
            if (v == getCustomView(Config.WS_Dvr_Rec)) {
                Intent intent4 = new Intent(FytPackage.DVRSERVICE);
                intent4.setAction(FytPackage.RECACTION);
                intent4.setPackage(FytPackage.INNER_DVR);
                startService(intent4);
                return;
            }
            if (v == getCustomView(Config.WS_Dvr_Lock)) {
                Intent intent5 = new Intent(FytPackage.DVRSERVICE);
                intent5.setAction(FytPackage.LOCKACTION);
                intent5.setPackage(FytPackage.INNER_DVR);
                startService(intent5);
                return;
            }
            if (v == getCustomView(Config.WS_Dvr_Catch)) {
                Intent intent6 = new Intent(FytPackage.DVRSERVICE);
                intent6.setAction(FytPackage.PHOTOACTION);
                intent6.setPackage(FytPackage.INNER_DVR);
                startService(intent6);
                return;
            }
            if (v == getCustomView(Config.WS_BRIGHT) || v == getCustomView(Config.BRIGHT)) {
                new PopWindowBright(mLauncher, mBrightLevel).showPopupWindow(mDragLayer);
                return;
            }
            if (v == getCustomView(Config.WS_BROWSER) || v == getCustomView(Config.BROWSER)) {
                LogPreview.show("Config.WS_BROWSER");
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.browserAction), "music");
                return;
            }
            if (v == getCustomView(Config.WS_GUIDE)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.guideAction), "music");
                return;
            }
            if (v == getCustomView(Config.WS_CALCULATOR)) {
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.calculatorAction), "music");
                return;
            }
            if (v == getCustomView(Config.NEWEYE)) {
                startActivitySafely(v, FytPackage.getIntent(this, "com.newsmy.ncarmanagerclient"), "newsmy");
                return;
            }
            if (v == getCustomView(Config.WS_CANBUS) || v == getCustomView(Config.CANBUS)) {
                LogPreview.show("Config.WS_CANBUS");
                startActivitySafely(v, FytPackage.getIntent(this, FytPackage.carBus), "canbus");
            } else if (v == getCustomView(Config.WS_360)) {
                if (SystemProperties.getInt("persist.sys.inner360", 0) == 0) {
                    startActivitySafely(v, FytPackage.getIntent(this, FytPackage.INNER360), "360");
                } else {
                    startActivitySafely(v, FytPackage.getIntent(this, "com.syu.camera360"), "360");
                }
            }
        }
    }

    public void stopMusic() {
        if (mediaSource == "mediaController") {
            if (Launcher.this.mPlayPauseButton != null) {
                mPlayPauseButton.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setWidgetButtonsTint(mPlayPauseButton);
                mPlayPauseButtonTwo.setBackground(SkinUtils.getDrawable(ResValue.getInstance().music_pause_icon));
                setBarButtonsTint(mPlayPauseButtonTwo);
            }
            sendBroadcast(new Intent("media.play.pause")); 
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

    @Override
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

    public void onClickAllAppsButton() {
        Launcher.this.showAllApps(true, AppsCustomizePagedView.ContentType.Applications, true);
    }

    public void onClickShowBarButton() {
        mWorkspace.toggleBottomBar();
    }

    public void onTouchDownAllAppsButton(View v) {
        v.performHapticFeedback(1);
    }

    public void performHapticFeedbackOnTouchDown(View v) {
        v.performHapticFeedback(1);
    }

    public View.OnTouchListener getHapticFeedbackTouchListener() {
        if (mHapticFeedbackTouchListener == null) {
            mHapticFeedbackTouchListener = new View.OnTouchListener() { 
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if ((event.getAction() & 255) == 0) {
                        v.performHapticFeedback(1);
                        return false;
                    }
                    return false;
                }
            };
        }
        return mHapticFeedbackTouchListener;
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
        ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> task = mActivityManager.getRunningTasks(32);
        for (ActivityManager.RunningTaskInfo amTask : task) {
            Log.i("test", "RunningTaskInfo " + amTask.baseActivity);
            String pkg = amTask.baseActivity.getPackageName();
            if (pkg.startsWith(packagename)) {
                mActivityManager.moveTaskToFront(amTask.id, ActivityManager.MOVE_TASK_NO_USER_ACTION);
            }
        }
    }

    public boolean startActivitySafely(final View v, final Intent intent, final Object tag) {
        if (intent == null) {
            Toast.makeText(getApplicationContext(), R.string.activity_not_found, Toast.LENGTH_LONG).show();
            return success;
        }
        if (intent.getComponent() == null && ((v == getCustomView(Config.WS_Dvr) || v == getCustomView(Config.DVR)) && !Utils.getNameToBool("iscamera360"))) {
            Toast.makeText(getApplicationContext(), R.string.dvr_switch, android.widget.Toast.LENGTH_LONG).show();
            return success;
        }
        if (intent != null && intent.getComponent() != null) {
            if ("net.easyconn".equals(intent.getComponent().getPackageName())) {
                if (SystemProperties.get("sys.bdcl.enable").equals("0") && SystemProperties.get("service.adbec.enable").equals("1")) {
                    boolean start = start(v, intent, tag);
                    success = start;
                    return start;
                }
                testRemoveTask("com.baidu.carlifevehicle");
                SystemProperties.set("sys.bdcl.enable", "0");
                handler.postDelayed(new Runnable() { 
                    @Override
                    public void run() {
                        LogPreview.show("easyconnACTION");
                        Launcher.this.success = Launcher.this.start(v, intent, tag);
                    }
                }, 500L);
                SystemProperties.set("service.adbec.enable", "1");
            } else if ("com.baidu.carlifevehicle".equals(intent.getComponent().getPackageName())) {
                if (SystemProperties.get("sys.bdcl.enable").equals("1") && SystemProperties.get("service.adbec.enable").equals("0")) {
                    boolean start2 = start(v, intent, tag);
                    success = start2;
                    return start2;
                }
                testRemoveTask("net.easyconn");
                SystemProperties.set("service.adbec.enable", "0");
                handler.postDelayed(new Runnable() { 
                    @Override
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
        if (str1.equals("true") || ResValue.getInstance().clickapp_cling <= 0 || intent.getComponent() == null || !Config.EXISTVOICE || !closePop) {
            success = start(v, intent, tag);
        } else {
            if (findViewById(ResValue.getInstance().clickapp) != null) {
                findViewById(ResValue.getInstance().clickapp).setOnClickListener(arg0 -> {
                    Cling cling = (Cling) Launcher.this.findViewById(ResValue.getInstance().clickapp_cling);
                    Runnable cb = () -> {
                    };
                    Launcher.this.dismissClingApp(cling, cb, intent, 200, true);
                    Launcher.this.success = Launcher.this.start(v, intent, tag);
                    Launcher.this.stopVoice();
                });
            }
            findViewById(ResValue.getInstance().clickapp_cancel).setOnClickListener(arg0 -> {
                Cling cling = (Cling) Launcher.this.findViewById(ResValue.getInstance().clickapp_cling);
                Runnable cb = new Runnable() {
                    @Override
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
                    success = start(v, intent, tag);
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
                    success = start(v, intent, tag);
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
                    success = start(v, intent, tag);
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
                    success = start(v, intent, tag);
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
                    success = start(v, intent, tag);
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
                    success = start(v, intent, tag);
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
                    success = start(v, intent, tag);
                }
            } else {
                success = start(v, intent, tag);
            }
        }
        return success;
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
        if (mFolderIconImageView == null) {
            mFolderIconImageView = new ImageView(this);
        }
        if (mFolderIconBitmap == null || mFolderIconBitmap.getWidth() != width || mFolderIconBitmap.getHeight() != height) {
            mFolderIconBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            mFolderIconCanvas = new Canvas(mFolderIconBitmap);
        }
        if (mFolderIconImageView.getLayoutParams() instanceof DragLayer.LayoutParams) {
            lp = (DragLayer.LayoutParams) mFolderIconImageView.getLayoutParams();
        } else {
            lp = new DragLayer.LayoutParams(width, height);
        }
        float scale = mDragLayer.getDescendantRectRelativeToSelf(fi, mRectForFolderAnimation);
        lp.customPosition = true;
        lp.x = mRectForFolderAnimation.left;
        lp.y = mRectForFolderAnimation.top;
        lp.width = (int) (width * scale);
        lp.height = (int) (height * scale);
        mFolderIconCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        fi.draw(mFolderIconCanvas);
        mFolderIconImageView.setImageBitmap(mFolderIconBitmap);
        if (fi.getFolder() != null) {
            mFolderIconImageView.setPivotX(fi.getFolder().getPivotXForIconAnimation());
            mFolderIconImageView.setPivotY(fi.getFolder().getPivotYForIconAnimation());
        }
        if (mDragLayer.indexOfChild(mFolderIconImageView) != -1) {
            mDragLayer.removeView(mFolderIconImageView);
        }
        mDragLayer.addView(mFolderIconImageView, lp);
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
            ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(mFolderIconImageView, alpha, scaleX, scaleY);
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
            mDragLayer.removeView(mFolderIconImageView);
            copyFolderIconToImage(fi);
            ObjectAnimator oa = LauncherAnimUtils.ofPropertyValuesHolder(mFolderIconImageView, alpha, scaleX, scaleY);
            oa.setDuration(getResources().getInteger(R.integer.config_folderAnimDuration));
            oa.addListener(new AnimatorListenerAdapter() { 
                @Override
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
            mDragLayer.addView(folder);
            mDragController.addDropTarget(folder);
        } else {
            Log.w(TAG, "Opening folder (" + folder + ") which already has a parent (" + folder.getParent() + ").");
        }
        folder.animateOpen();
        growAndFadeOutFolderIcon(folderIcon);

        // Notify the accessibility manager that this folder "window" has appeared and occluded
        // the workspace items
        folder.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        getDragLayer().sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
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

        // Notify the accessibility manager that this folder "window" has disappeard and no
        // longer occludeds the workspace items
        getDragLayer().sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
    }

    @Override
    public boolean onLongClick(View v) {
        if (!isDraggingEnabled()) return false;
        if (isWorkspaceLocked()) return false;
        if (mState != State.WORKSPACE) return false;

        if (v instanceof Workspace) {
            if (!mWorkspace.isInOverviewMode()) {
                if (mWorkspace.enterOverviewMode()) {
                    hideHotseat(true, true);
                    mWorkspace.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS,
                            HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
                    return true;
                }
                showHotseat(true, true);
                updateWallpaperVisibility(true);
                return false;
            }
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
        // This happens when long clicking an item with the dpad/trackball
        if (longClickCellInfo == null) {
            return true;
        }

        // The hotseat touch handling does not go through Workspace, and we always allow long press
        // on hotseat items.
        final View itemUnderLongClick = longClickCellInfo.cell;
        boolean allowLongPress = isHotseatLayout(v) || mWorkspace.allowLongPress();
        if (allowLongPress && !mDragController.isDragging()) {
            if (itemUnderLongClick == null) {
                // User long pressed on empty space
                mWorkspace.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS,
                        HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
                // Disabling reordering until we sort out some issues.
                if (mWorkspace.isInOverviewMode()) {
                    mWorkspace.startReordering(v);
                } else {
                    mWorkspace.enterOverviewMode();
                }
            } else {
                if (!(itemUnderLongClick instanceof Folder)) {
                    // User long pressed on an item
                    mWorkspace.startDrag(longClickCellInfo);
                    hideHotseat(true, true);
                }
            }
        }

        return true;
    }

    boolean isHotseatLayout(View layout) {
        return false;
    }

    Hotseat getHotseat() {
        return mHotseat;
    }

    View getOverviewPanel() {
        return mOverviewPanel;
    }

    public static Launcher getLauncher() {
        return mLauncher;
    }

    SearchDropTargetBar getSearchBar() {
        return mSearchDropTargetBar;
    }

    CellLayout getCellLayout(long container, long screenId) {
        if (container != -101) {
            return mWorkspace.getScreenWithId(screenId);
        }
        if (mHotseat != null) {
        }
        return null;
    }

    public static Workspace getWorkspace() {
        return mWorkspace;
    }

    public boolean isAllAppsVisible() {
        return mState == State.APPS_CUSTOMIZE || mOnResumeState == State.APPS_CUSTOMIZE;
    }

    
    public void setPivotsForZoom(View view, float scaleFactor) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
    }

    private void setWorkspaceBackground(boolean workspace) {
    }

    public void updateWallpaperVisibility(boolean visible) {
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
        AppsCustomizePagedView.ContentType contentType = mAppsCustomizeContent.getContentType();
        showAppsCustomizeHelper(animated, springLoaded, contentType);
    }

    private void showAppsCustomizeHelper(final boolean animated, boolean springLoaded, AppsCustomizePagedView.ContentType contentType) {
        if (mStateAnimation != null) {
            mStateAnimation.setDuration(0L);
            mStateAnimation.cancel();
            mStateAnimation = null;
        }
        Resources res = getResources();
        int duration = res.getInteger(R.integer.config_appsCustomizeZoomInTime);
        int fadeDuration = res.getInteger(R.integer.config_appsCustomizeFadeInTime);
        final float scale = res.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        final View fromView = mWorkspace;
        final AppsCustomizeTabHost toView = mAppsCustomizeTabHost;
        int startDelay = res.getInteger(R.integer.config_workspaceAppsCustomizeAnimationStagger);
        setPivotsForZoom(toView, scale);
        hideHotseat(animated);
        Animator workspaceAnim = mWorkspace.getChangeStateAnimation(Workspace.State.SMALL, animated);
        if (!AppsCustomizePagedView.DISABLE_ALL_APPS) {
            mAppsCustomizeTabHost.setContentTypeImmediate(contentType);
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
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { 
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    if (animation == null) {
                        throw new RuntimeException("animation is null");
                    }
                    float t = ((Float) animation.getAnimatedValue()).floatValue();
                    Launcher.this.dispatchOnLauncherTransitionStep(fromView, t);
                    Launcher.this.dispatchOnLauncherTransitionStep(toView, t);
                }
            });
            mStateAnimation = LauncherAnimUtils.createAnimatorSet();
            mStateAnimation.play(scaleAnim).after(startDelay);
            mStateAnimation.play(alphaAnim).after(startDelay);
            mStateAnimation.addListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationStart(Animator animation) {
                    toView.setTranslationX(0.0f);
                    toView.setTranslationY(0.0f);
                    toView.setVisibility(android.view.View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Launcher.this.dispatchOnLauncherTransitionEnd(fromView, animated, false);
                    Launcher.this.dispatchOnLauncherTransitionEnd(toView, animated, false);
                    if (Launcher.this.mSearchDropTargetBar != null) {
                        Launcher.this.mSearchDropTargetBar.hideSearchBar(false);
                    }
                }
            });
            if (workspaceAnim != null) {
                mStateAnimation.play(workspaceAnim);
            }
            boolean delayAnim = false;
            dispatchOnLauncherTransitionPrepare(fromView, animated, false);
            dispatchOnLauncherTransitionPrepare(toView, animated, false);
            if (toView.getContent().getMeasuredWidth() == 0 || mWorkspace.getMeasuredWidth() == 0 || toView.getMeasuredWidth() == 0) {
                delayAnim = true;
            }
            final AnimatorSet stateAnimation = mStateAnimation;
            final Runnable startAnimRunnable = new Runnable() { 
                @Override
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
                observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { 
                    @Override
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
            if (!springLoaded && !LauncherAppState.getInstance().isScreenLarge() && mSearchDropTargetBar != null) {
                mSearchDropTargetBar.hideSearchBar(false);
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

    
    public void hideAppsCustomizeHelper(Workspace.State toState, final boolean animated, boolean springLoaded, Runnable onCompleteRunnable) {
        if (mStateAnimation != null) {
            mStateAnimation.setDuration(0L);
            mStateAnimation.cancel();
            mStateAnimation = null;
        }
        Resources res = getResources();
        int duration = res.getInteger(R.integer.config_appsCustomizeZoomOutTime);
        int fadeOutDuration = res.getInteger(R.integer.config_appsCustomizeFadeOutTime);
        float scaleFactor = res.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        final float scale = res.getInteger(R.integer.config_appsCustomizeZoomScaleFactor);
        final View fromView = mAppsCustomizeTabHost;
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
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { 
                @Override
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
            mStateAnimation = LauncherAnimUtils.createAnimatorSet();
            mStateAnimation.play(scaleAnim).after(startDelay);
            mStateAnimation.play(alphaAnim).after(startDelay);
            mStateAnimation.addListener(new AnimatorListenerAdapter() { 
                @Override
                public void onAnimationStart(Animator animation) {
                    fromView.setVisibility(android.view.View.GONE);
                    workspace.setTranslationX(0.0f);
                    workspace.setTranslationY(0.0f);
                }
            });
            dispatchOnLauncherTransitionEnd(fromView, animated, true);
            dispatchOnLauncherTransitionEnd(workspace, animated, true);
            if (mSearchDropTargetBar != null) {
                mSearchDropTargetBar.showSearchBar(false);
            }
            if (workspaceAnim != null) {
                mStateAnimation.play(workspaceAnim);
            }
            boolean delayAnim = false;
            if (workspace.getContent().getMeasuredWidth() == 0 || mWorkspace.getMeasuredWidth() == 0 || workspace.getMeasuredWidth() == 0) {
                delayAnim = true;
            }
            final AnimatorSet stateAnimation = mStateAnimation;
            final Runnable startAnimRunnable = () -> {
                if (Launcher.this.mStateAnimation == stateAnimation) {
                    Launcher.this.setPivotsForZoom(workspace, scale);
                    Launcher.this.dispatchOnLauncherTransitionStart(fromView, animated, true);
                    Launcher.this.dispatchOnLauncherTransitionStart(workspace, animated, true);
                    LauncherAnimUtils.startAnimationAfterNextDraw(Launcher.this.mStateAnimation, workspace);
                }
            };
            if (delayAnim) {
                ViewTreeObserver observer = workspace.getViewTreeObserver();
                observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { 
                    @Override
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

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level >= 60) {
            mAppsCustomizeTabHost.onTrimMemory();
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
        if (mState != State.WORKSPACE) {
            boolean wasInSpringLoadedMode = mState != State.WORKSPACE;
            mWorkspace.setVisibility(android.view.View.VISIBLE);
            hideAppsCustomizeHelper(Workspace.State.NORMAL, false, false, onCompleteRunnable);

            // Show the search bar (only animate if we were showing the drop target bar in spring
            // loaded mode)
            if (mSearchDropTargetBar != null) {
                mSearchDropTargetBar.showSearchBar(animated && wasInSpringLoadedMode);
            }

            // Set focus to the AppsCustomize button
            if (mAllAppsButton != null) {
                mAllAppsButton.requestFocus();
            }
        }

        // Change the state *after* we've called all the transition code
        mState = State.WORKSPACE;

        // Resume the auto-advance of widgets
        mUserPresent = true;
        updateRunning();

        // Send an accessibility event to announce the context change
        getWindow().getDecorView()
                .sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);

        onWorkspaceShown(animated);
    }

    void showOverviewMode(boolean animated) {
        mWorkspace.setVisibility(android.view.View.VISIBLE);
        hideAppsCustomizeHelper(Workspace.State.OVERVIEW, false, false, null);
        mState = State.WORKSPACE;
        onWorkspaceShown(animated);
    }

    public void onWorkspaceShown(boolean animated) {  
        if (((!onResumePip || onBackPip) && !isRecreateActive) || helpers.isInWidgets()) {
            onWorkspacePip = true;
            helpers.setInWidgets(false);
            initPip("onWorkspaceShown()", null, false);
        }
    }

    void showAllApps(boolean animated, AppsCustomizePagedView.ContentType contentType, boolean resetPageToZero) {
        if (mState == State.WORKSPACE) {
            Log.d("showAllApps", String.valueOf(contentType) + ": removePip");
            WindowUtil.removePip(pipViews, 0);
            helpers.setForegroundAppOpened(false);
            if (contentType == AppsCustomizePagedView.ContentType.Applications) {
                helpers.setInAllApps(true);
                helpers.setInWidgets(false);
            } else {
                helpers.setInAllApps(false);
            }
            if (contentType == AppsCustomizePagedView.ContentType.Widgets) {
                helpers.setInWidgets(true);
                helpers.setInAllApps(false);
            } else {
                helpers.setInWidgets(false);
            }
            helpers.setInOverviewMode(false);
            helpers.setListOpen(false);
            Intent intent = new Intent(Keys.ALL_APPS);
            sendBroadcast(intent);
            if (resetPageToZero) {
                mAppsCustomizeTabHost.reset();
            }
            hideHotseat(true);
            LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_hotseat_hide);
            showAppsCustomizeHelper(animated, true, contentType);
            mAppsCustomizeTabHost.requestFocus();
            mState = State.APPS_CUSTOMIZE;
            mUserPresent = false;
            updateRunning();
            closeFolder();

            // Send an accessibility event to announce the context change
            getWindow().getDecorView()
                    .sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        }
    }

    void enterSpringLoadedDragMode() {
        if (isAllAppsVisible()) {
            hideAppsCustomizeHelper(Workspace.State.SPRING_LOADED, false, true, null);
            mState = State.APPS_CUSTOMIZE_SPRING_LOADED;
            showHotseat(true);
        }
    }

    void exitSpringLoadedDragModeDelayed(final boolean successfulDrop, boolean extendedDelay, final Runnable onCompleteRunnable) {
        if (mState == State.APPS_CUSTOMIZE_SPRING_LOADED) {
            mHandler.postDelayed(new Runnable() { 
                @Override
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
        if (!onResumePip) {
            helpers.setInAllApps(false);
            initPip("exitSpringLoadedDragModeDelayed()", null, false);
        }
    }

    void exitSpringLoadedDragMode() {
        if (mState == State.APPS_CUSTOMIZE_SPRING_LOADED) {
            showAppsCustomizeHelper(false, true);
            mState = State.APPS_CUSTOMIZE;
        }
    }

    void showHotseat(boolean animated) {
        showHotseat(animated, false);
    }

    public void showHotseat(boolean animated, boolean hide) {
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_hotseat_hide) || hide) {
            if (!LauncherAppState.getInstance().isScreenLarge()) {
                if (animated) {
                    int duration = 0;
                    if (mSearchDropTargetBar != null) {
                        duration = mSearchDropTargetBar.getTransitionInDuration();
                    }
                    mHotseat.animate().alpha(1.0f).setDuration(duration);
                    mHotseat.setVisibility(android.view.View.VISIBLE);
                } else {
                    mHotseat.setAlpha(1.0f);
                }
            }
            if (mHotseat.getAlpha() != 1.0f || mHotseat.getVisibility() != android.view.View.VISIBLE) {
                mHotseat.setAlpha(1.0f);
                mHotseat.setVisibility(android.view.View.VISIBLE);
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
                    if (mHotseat.getAlpha() != 0.0f) {
                        int duration = 0;
                        if (mSearchDropTargetBar != null) {
                            duration = mSearchDropTargetBar.getTransitionOutDuration();
                        }
                        mHotseat.animate().alpha(0.0f).setDuration(duration);
                    }
                    mHotseat.setVisibility(android.view.View.GONE);
                } else {
                    mHotseat.setAlpha(0.0f);
                }
            }
            mHotseat.setVisibility(android.view.View.GONE);
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
                return ContextCompat.getDrawable(getApplicationContext(), iconResId);
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
            Drawable toolbarIcon2 = ContextCompat.getDrawable(getApplicationContext(), fallbackDrawableId);
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
        if (mQsbBar == null) {
            mQsbBar = mInflater.inflate(R.layout.search_bar, (ViewGroup) mSearchDropTargetBar, false);
            if (mSearchDropTargetBar != null) {
                mSearchDropTargetBar.addView(mQsbBar);
            }
        }
        return mQsbBar;
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

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        boolean result = super.dispatchPopulateAccessibilityEvent(event);
        List<CharSequence> text = event.getText();
        text.clear();
        if (mState == State.APPS_CUSTOMIZE) {
            text.add(mAppsCustomizeTabHost.getCurrentTabView().getContentDescription());
        } else {
            text.add(getString(R.string.all_apps_home_button_label));
        }
        return result;
    }

    private class CloseSystemDialogsIntentReceiver extends BroadcastReceiver {
        private CloseSystemDialogsIntentReceiver() {
        }

        CloseSystemDialogsIntentReceiver(Launcher launcher, CloseSystemDialogsIntentReceiver closeSystemDialogsIntentReceiver) {
            this();
        }

        @Override 
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "CloseSystemDialogsIntentReceiver");
            mWorkspace.moveToDefaultScreen(true);
            Intent i = new Intent();
            i.setAction("android.intent.action.MAIN");
            i.addCategory("android.intent.category.HOME");
            if (Launcher.this.getPackageManager().resolveActivity(i, PackageManager.MATCH_DEFAULT_ONLY).activityInfo.packageName.equals(Launcher.this.getPackageName()) && !helpers.settingsOpenedBoolean()) {
                if (colsePipAction.equals(intent.getAction())) {
                    WindowUtil.removePip(null);
                    return;
                } else {
                    if (!camera360Action.equals(intent.getAction()) && "com.lsec.pipdie".equals(intent.getAction()) && CarStates.mAccState == 1) {
                        initPip("CloseSystemDialogs", null, false);
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
            super(new Handler(Looper.getMainLooper()));
        }

        @Override
        public void onChange(boolean selfChange) {
            Launcher.this.onAppWidgetReset();
        }
    }

    private boolean waitUntilResume(Runnable run, boolean deletePreviousRunnables) {
        if (!mPaused) {
            return false;
        }
        Log.i(TAG, "Deferring update until onResume");
        if (deletePreviousRunnables) {
            while (mBindOnResumeCallbacks.remove(run)) {
            }
        }
        mBindOnResumeCallbacks.add(run);
        return true;
    }

    private boolean waitUntilResume(Runnable run) {
        return waitUntilResume(run, false);
    }

    public void addOnResumeCallback(Runnable run) {
        mOnResumeCallbacks.add(run);
    }

    @Override
    public boolean setLoadOnResume() {
        if (!mPaused) {
            return false;
        }
        Log.i(TAG, "setLoadOnResume");
        mOnResumeNeedsLoad = true;
        return true;
    }

    @Override
    public int getCurrentWorkspaceScreen() {
        if (mWorkspace != null) {
            return mWorkspace.getCurrentPage();
        }
        return 2;
    }

    @Override
    public void startBinding() {
        mBindOnResumeCallbacks.clear();
        mWorkspace.clearDropTargets();
        mWorkspace.removeAllWorkspaceScreens();
        mWidgetsToAdvance.clear();
    }

    @Override
    public void bindScreens(ArrayList<Long> orderedScreenIds) {
        bindAddScreens(orderedScreenIds);
        Log.i(TAG, "bindScreens order: " + orderedScreenIds);
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

    @Override
    public void bindAddScreens(ArrayList<Long> orderedScreenIds) {
        Log.d(TAG, "bindAddScreens");
        int count2 = orderedScreenIds.size();
        userLayout = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
        if (userLayout) {
            for (int i = 0; i < count2; i++) {
                mWorkspace.insertNewWorkspaceScreenBeforeEmptyScreen(orderedScreenIds.get(i).longValue());
            }
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
        editor.apply();
        if (mWeightWatcher != null) {
            mWeightWatcher.setVisibility(show ? android.view.View.VISIBLE : android.view.View.GONE);
        }
    }

    @Override
    public void bindAppsAdded(final ArrayList<Long> newScreens, final ArrayList<ItemInfo> addNotAnimated, final ArrayList<ItemInfo> addAnimated, final ArrayList<AppInfo> addedApps) {
        Log.d(TAG, "bindAppsAdded");
        Runnable r = new Runnable() { 
            @Override
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
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && addedApps != null && mAppsCustomizeContent != null) {
                mAppsCustomizeContent.addApps(addedApps);
            }
        }
    }

    @Override
    public void bindItems(final ArrayList<ItemInfo> shortcuts, final int start, final int end, final boolean forceAnimateIcons) {
        CellLayout cl;
        Log.d(TAG, "bindItems");
        Runnable r = new Runnable() { 
            @Override
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
                if ((item.container != -101 || getResources().getBoolean(R.bool.hotseat_load_defualt_workspace)) && (item.container != -101 || mHotseat != null)) {
                    switch (item.itemType) {
                        case 0:
                        case 1:
                            try {
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
                            } catch (RuntimeException e) {
                                Log.e(TAG, "Invalid Item Type in bindItems, ShortcutInfo: " + e);
                                break;
                            }
                        case 2:
                            try {
                                FolderIcon newFolder = FolderIcon.fromXml(R.layout.folder_icon, this, (ViewGroup) workspace.getChildAt(workspace.getCurrentPage()), (FolderInfo) item, mIconCache);
                                workspace.addInScreenFromBind(newFolder, item.container, item.screenId, item.cellX, item.cellY, 1, 1);
                                break;
                            } catch (RuntimeException e) {
                                Log.e(TAG, "Invalid Item Type in bindItems, FolderIcon: " + e);
                                break;
                            }
                        default:
                            Log.e(TAG, String.valueOf(new RuntimeException("Invalid Item Type")));
                    }
                }
            }
            if (animateIcons && newShortcutsScreenId > -1) {
                long currentScreenId = mWorkspace.getScreenIdForPageIndex(mWorkspace.getNextPage());
                final int newScreenIndex = mWorkspace.getPageIndexForScreenId(newShortcutsScreenId);
                final Runnable startBounceAnimRunnable = new Runnable() { 
                    @Override
                    public void run() {
                        anim.playTogether(bounceAnims);
                        anim.start();
                    }
                };
                if (newShortcutsScreenId != currentScreenId) {
                    mWorkspace.postDelayed(new Runnable() { 
                        @Override
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

    @Override
    public void bindFolders(final HashMap<Long, FolderInfo> folders) {
        Runnable r = new Runnable() { 
            @Override
            public void run() {
                Launcher.this.bindFolders(folders);
            }
        };
        if (!waitUntilResume(r)) {
            sFolders.clear();
            sFolders.putAll(folders);
        }
    }

    /**
     * Add the views for a widget to the workspace.
     *
     * Implementation of the method from LauncherModel.Callbacks.
     */
    public void bindAppWidget(final LauncherAppWidgetInfo item) {
        Runnable r = new Runnable() {
            public void run() {
                bindAppWidget(item);
            }
        };
        if (waitUntilResume(r)) {
            return;
        }

        final long start = DEBUG_WIDGETS ? SystemClock.uptimeMillis() : 0;
        if (DEBUG_WIDGETS) {
            Log.d(TAG, "bindAppWidget: " + item);
        }
        final Workspace workspace = mWorkspace;

        final int appWidgetId = item.appWidgetId;
        final AppWidgetProviderInfo appWidgetInfo = mAppWidgetManager.getAppWidgetInfo(appWidgetId);

        if (appWidgetInfo == null) {
            Log.d(TAG, "bindAppWidget, can not get appWidgetInfo from widget id: " + appWidgetId + ", retrying...");
            mHandler.postDelayed(() -> bindAppWidget(item), 5000); 
            return;
        }

        if (DEBUG_WIDGETS) {
            Log.d(TAG, "bindAppWidget: id=" + item.appWidgetId + " belongs to component " + appWidgetInfo.provider);
        }

        item.hostView = mAppWidgetHost.createView(LauncherApplication.sApp, appWidgetId, appWidgetInfo);

        item.hostView.setTag(item);
        item.onBindAppWidget(this);

        workspace.addInScreen(item.hostView, item.container, item.screenId, item.cellX,
                item.cellY, item.spanX, item.spanY, false);
        addWidgetToAutoAdvanceIfNeeded(item.hostView, appWidgetInfo);

        workspace.requestLayout();

        if (DEBUG_WIDGETS) {
            Log.d(TAG, "bound widget id="+item.appWidgetId+" in "
                    + (SystemClock.uptimeMillis()-start) + "ms, to screen ID: " + item.screenId);
        }
    }

    @Override
    public void onPageBoundSynchronously(int page) {
        mSynchronouslyBoundPages.add(Integer.valueOf(page));
    }

    @Override
    public void finishBindingItems(final boolean upgradePath) {
        Log.d(TAG, "finishBindingItems");
        Runnable r = new Runnable() { 
            @Override
            public void run() {
                Launcher.this.finishBindingItems(upgradePath);
            }
        };
        if (!waitUntilResume(r)) {
            if (mSavedState != null) {
                if (!mWorkspace.hasFocus()) {
                    mWorkspace.getChildAt(mWorkspace.getCurrentPage()).requestFocus();
                }
                mSavedState = null;
            }
            mWorkspace.restoreInstanceStateForRemainingPages();
            for (int i = 0; i < sPendingAddList.size(); i++) {
                completeAdd(sPendingAddList.get(i));
            }
            sPendingAddList.clear();
            mWorkspaceLoading = false;
            if (upgradePath) {
                mWorkspace.getUniqueComponents(true, null);
                mIntentsOnWorkspaceFromUpgradePath = mWorkspace.getUniqueComponents(true, null);
            }
            mWorkspace.post(new Runnable() { 
                @Override
                public void run() {
                    Launcher.this.onFinishBindingItems();
                }
            });
        }
    }

    @Override
    public boolean isAllAppsButtonRank(int rank) {
        if (mHotseat != null) {
        }
        return false;
    }

    private boolean canRunNewAppsAnimation() {
        long diff = System.currentTimeMillis() - mDragController.getLastGestureUpTime();
        return diff > ((long) (NEW_APPS_ANIMATION_INACTIVE_TIMEOUT_SECONDS * 1000));
    }

    private ValueAnimator createNewAppBounceAnimation(View v, int i) {
        ValueAnimator bounceAnim = LauncherAnimUtils.ofPropertyValuesHolder(v, PropertyValuesHolder.ofFloat("alpha", 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        bounceAnim.setDuration(450L);
        bounceAnim.setStartDelay(i * 85);
        bounceAnim.setInterpolator(new SmoothPagedView.OvershootInterpolator());
        return bounceAnim;
    }

    @Override
    public void bindSearchablesChanged() {
        boolean searchVisible = updateGlobalSearchIcon();
        boolean voiceVisible = updateVoiceSearchIcon(searchVisible);
        if (mSearchDropTargetBar != null) {
            mSearchDropTargetBar.onSearchPackagesChanged(searchVisible, voiceVisible);
        }
    }

    @Override
    public void bindAllApplications(ArrayList<AppInfo> apps) {
        Log.d(TAG, "bindAllApplications");
        if (AppsCustomizePagedView.DISABLE_ALL_APPS) {
            if (mIntentsOnWorkspaceFromUpgradePath != null) {
                mIntentsOnWorkspaceFromUpgradePath = null;
            }
        } else if (mAppsCustomizeContent != null) {
            mAppsCustomizeContent.setApps(apps);
        }
    }

    @Override
    public void bindAppsUpdated(final ArrayList<AppInfo> apps) {
        Runnable r = new Runnable() {
            public void run() {
                bindAppsUpdated(apps);
            }
        };
        if (waitUntilResume(r)) {
            return;
        }

        if (mWorkspace != null) {
            mWorkspace.updateShortcuts(apps);
        }

        if (!AppsCustomizePagedView.DISABLE_ALL_APPS &&
                mAppsCustomizeContent != null) {
            mAppsCustomizeContent.updateApps(apps);
        }
    }

    @Override
    public void bindComponentsRemoved(final ArrayList<String> packageNames, final ArrayList<AppInfo> appInfos, final boolean packageRemoved) {
        Runnable r = new Runnable() { 
            @Override
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
            mDragController.onAppsRemoved(appInfos, this);
            if (!AppsCustomizePagedView.DISABLE_ALL_APPS && mAppsCustomizeContent != null) {
                mAppsCustomizeContent.removeApps(appInfos);
            }
        }
    }

    @Override
    public void bindPackagesUpdated(ArrayList<Object> widgetsAndShortcuts) {
        if (waitUntilResume(mBindPackagesUpdatedRunnable, true)) {
            mWidgetsAndShortcuts = widgetsAndShortcuts;
        } else if (!AppsCustomizePagedView.DISABLE_ALL_APPS && mAppsCustomizeContent != null) {
            mAppsCustomizeContent.onPackagesUpdated(widgetsAndShortcuts);
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
                mHandler.postDelayed(new Runnable() { 
                    @Override
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
                    new Thread("dismissClingThread") { 
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
                            editor.apply();
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
            parent.post(new Runnable() { 
                @Override
                public void run() {
                    parent.removeView(cling);
                }
            });
            mHideFromAccessibilityHelper.restoreImportantForAccessibility(mDragLayer);
        }
    }

    private boolean skipCustomClingIfNoAccounts() {
        AccountManager mAccountManager;
        Cling cling = (Cling) findViewById(R.id.workspace_cling);
        boolean customCling = cling.getDrawIdentifier().equals("workspace_custom");
        if (!customCling || (mAccountManager = AccountManager.get(this)) == null) {
            return false;
        }
        Account[] accounts = mAccountManager.getAccountsByType("com.google");
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
                ccHint.animate().alpha(0.0f).setDuration(250L).setListener(new AnimatorListenerAdapter() { 
                    @Override
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
        if (isClingsEnabled() && !mSharedPrefs.getBoolean("cling_gel.first_run.dismissed", false) && !skipCustomClingIfNoAccounts()) {
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
        if (isClingsEnabled() && !mSharedPrefs.getBoolean("cling_gel.workspace.dismissed", false)) {
            Cling c = initCling(R.id.workspace_cling, 0, false, true);
            c.setFocusedHotseatApp(getFirstRunFocusedHotseatAppDrawableId(), getFirstRunFocusedHotseatAppRank(), getFirstRunFocusedHotseatAppComponentName(), getFirstRunFocusedHotseatAppBubbleTitle(), getFirstRunFocusedHotseatAppBubbleDescription());
        } else {
            removeCling(R.id.workspace_cling);
        }
    }

    public void setDefaultWallpaper() {
        WallpaperManager mWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        LauncherApplication.mAppWallPaper = true;
        SharedPreferences.Editor editor = Utils.getSp().edit();
        editor.putBoolean("mAppWallPaper", LauncherApplication.mAppWallPaper);
        editor.apply();
        try {
            if (ResValue.getInstance().def_bg != 0) {
                mWallpaperManager.setResource(ResValue.getInstance().def_bg);
            } else if (ResValue.getInstance().fyt_home_bk_00 != 0) {
                mWallpaperManager.setResource(ResValue.getInstance().fyt_home_bk_00);
            } else if (ResValue.getInstance().fyt_home_bk_01 != 0) {
                mWallpaperManager.setResource(ResValue.getInstance().fyt_home_bk_01);
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
                editor.apply();
                WallpaperManager mWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                int resid = getResId(resName);
                mWallpaperManager.setStream(new BufferedInputStream(getResources().openRawResource(resid)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setWallpaper(String name) {
        new Thread() { 
            @Override
            public void run() {
                Launcher.this.setDefaultWallpaper(name);
            }
        }.start();
    }

    public int getResId(String resName) {
        try {
            Field idField = R.drawable.class.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    public Cling showFirstRunFoldersCling() {
        if (isClingsEnabled() && !mSharedPrefs.getBoolean("cling_gel.folder.dismissed", false)) {
            return initCling(R.id.folder_cling, R.id.cling_scrim, true, true);
        }
        removeCling(R.id.folder_cling);
        return null;
    }

    protected SharedPreferences getSharedPrefs() {
        return mSharedPrefs;
    }

    public boolean isFolderClingVisible() {
        Cling cling = (Cling) findViewById(R.id.folder_cling);
        return cling != null && cling.getVisibility() == android.view.View.VISIBLE;
    }

    public void dismissFirstRunCling(View v) {
        Cling cling = (Cling) findViewById(R.id.first_run_cling);
        Runnable cb = new Runnable() { 
            @Override
            public void run() {
                Launcher.this.showFirstRunWorkspaceCling();
            }
        };
        dismissCling(cling, cb, "cling_gel.first_run.dismissed", 200, false);
        mSearchDropTargetBar.hideSearchBar(true);
    }

    public void dismissWorkspaceCling(View v) {
        Cling cling = (Cling) findViewById(R.id.workspace_cling);
        Runnable cb = null;
        if (v == null) {
            cb = new Runnable() { 
                @Override
                public void run() {
                    Launcher.mWorkspace.enterOverviewMode();
                }
            };
        }
        dismissCling(cling, cb, "cling_gel.workspace.dismissed", 200, true);
        mSearchDropTargetBar.showSearchBar(true);
    }

    public void dismissFolderCling(View v) {
        Cling cling = (Cling) findViewById(R.id.folder_cling);
        dismissCling(cling, null, "cling_gel.folder.dismissed", 200, true);
    }

    public void dumpState() {
        Log.d(TAG, "BEGIN launcher66 dump state for launcher " + this);
        Log.d(TAG, "mSavedState=" + mSavedState);
        Log.d(TAG, "mWorkspaceLoading=" + mWorkspaceLoading);
        Log.d(TAG, "mRestoring=" + mRestoring);
        Log.d(TAG, "mWaitingForResult=" + mWaitingForResult);
        Log.d(TAG, "mSavedInstanceState=" + mSavedInstanceState);
        Log.d(TAG, "sFolders.size=" + sFolders.size());
        mModel.dumpState();
        if (mAppsCustomizeContent != null) {
            mAppsCustomizeContent.dumpState();
        }
        Log.d(TAG, "END launcher66 dump state");
    }

    public void appTextVisible(boolean visible) {
        if (mHotseatApps != null) {
            mHotseatApps.setVisibility(visible ? android.view.View.VISIBLE : android.view.View.INVISIBLE);
        }
    }

    @Override
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

    @Override
    public void dumpLogsToLocalData() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Widget.widgetUpdate(LauncherApplication.sApp, DateTimeProvider.class);
        Widget.widgetUpdate(LauncherApplication.sApp, DateMusicProvider.class);
    }
}