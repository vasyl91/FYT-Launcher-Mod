package com.android.launcher66.settings;

import android.app.Activity;
import android.app.Dialog;
import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import com.android.launcher66.BackgroundChoice;
import com.android.launcher66.BarBackground;
import com.android.launcher66.colorpicker.ColorPicker;
import com.android.launcher66.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * "Choose background for …": the backgrounds of a part of the home screen as tiles over the wallpaper.
 *
 * <p>The rule for its size and its backdrop (the owner, 2026-11-21): <b>the dialog is sized for the orientation it is
 * shown in, and the wallpaper behind the tiles is never stretched.</b> Its size is {@link SettingsDialogSize}'s (since
 * 2026-11-27: 0.7 x 0.9 of the settings' window in landscape, as the colour picker and the lists of apps, and 0.8 x 0.8
 * in portrait), from the window as it is now (a turn on a phone creates the dialog again); the wallpaper is drawn
 * center-crop at the size the dialog has at each draw (CenterCropDrawable).
 */
public class BackgroundSelectorDialog extends DialogFragment {
    private static final String TAG = "BgWidgetsSelector";
    private static final String ARG_BACKGROUNDS = "backgrounds";
    private static final String ARG_NAME = "name";
    private static final String ARG_KEY = "key";
    private static final String ARG_DEFAULT = "default_background";
    // What the dialog shows and where it stores the choice: arguments of the fragment, set on the main thread before
    // it is shown (they were statics written on the loader thread and read on the main one, so the key could be that
    // of another selector), and read again if the system recreates the fragment.
    private String backgrounds;
    private String name;
    private String key;
    /** The background the choice starts from when none was chosen; null = the name given to show(). */
    private String defaultBackground;
    /** The colour the picker starts from the first time: a dark grey that lets a fifth of the wallpaper through. */
    private static final int DEFAULT_CUSTOM_COLOR = 0xCC212121;
    /** Where an older version kept an image picked as the backdrop of this dialog; removed when found. */
    private static final String OLD_KEY_PICKED_IMAGE = "selected_background_uri";

    private GridLayout gridLayout;
    private View rootView;
    private Button pickButton;

    private List<String> backgroundNames;

    /** The wallpaper picker was opened from the button: the wallpaper is read again on the way back. */
    private boolean pickerOpened = false;
    private boolean hasPreloadedBackground = false;
    private Bitmap preloadedBackgroundBitmap = null;

    private int orientation;
    private int dialogWidthPx = 0;
    private int dialogHeightPx = 0;

    private static final ExecutorService loaderExecutor = Executors.newSingleThreadExecutor();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static void showWithLoadedBackground(@NonNull FragmentManager fm, @NonNull Context ctx, @NonNull String tag, @NonNull String bgs) {
        loaderExecutor.submit(() -> {
            // The home screen's wallpaper, by the best way this device has (HomeWallpaperSource); null
            // where it cannot be read, and the dialog then shows its colours and the "Pick wallpaper" button
            Point screen = HomeWallpaperSource.screenSize(ctx);
            Bitmap bmp = HomeWallpaperSource.read(ctx, screen.x, screen.y);

            final Bitmap finalBmp = bmp;
            mainHandler.post(() -> {
                try {
                    BackgroundSelectorDialog dlg = create(tag, bgs);
                    if (finalBmp != null) dlg.setPreloadedBackground(finalBmp);
                    fm.beginTransaction().add(dlg, tag).commitAllowingStateLoss();
                } catch (Throwable t) {
                    Log.w(TAG, "Failed to show dialog after load: " + t.getMessage(), t);
                }
            });
        });
    }

    /** The selector for one of the settings' backgrounds ("widgets", "folders", "stats", "bar", "vertical_bar"). */
    static BackgroundSelectorDialog create(@NonNull String tag, @NonNull String bgs) {
        final String choiceKey;
        final String choiceDefault;
        if (tag.equals("widgets")) {
            choiceKey = Keys.WIDGETS_SELECTED_BACKGROUND;
            choiceDefault = null;
        } else if (tag.equals("folders")) {
            // the open folder's background: the pictures of the widgets, the user's colour, and the one the folder has
            choiceKey = Keys.FOLDERS_SELECTED_BACKGROUND;
            choiceDefault = BarBackground.FOLDERS_DEFAULT;
        } else if (tag.equals("stats")) {
            // the statistics window: the widgets' pictures, and a tile for no background (what it starts from)
            choiceKey = Keys.STATS_SELECTED_BACKGROUND;
            choiceDefault = null;
        } else if (tag.equals("vertical_bar")) {
            // hotseat_bg (the one the bar has) and the backgrounds of the horizontal bar
            choiceKey = Keys.VERTICAL_BAR_SELECTED_BACKGROUND;
            choiceDefault = "hotseat_bg";
        } else {
            choiceKey = Keys.BAR_SELECTED_BACKGROUND;
            choiceDefault = null;
        }
        BackgroundSelectorDialog dlg = new BackgroundSelectorDialog();
        Bundle args = new Bundle();
        args.putString(ARG_BACKGROUNDS, bgs);
        args.putString(ARG_NAME, tag);
        args.putString(ARG_KEY, choiceKey);
        args.putString(ARG_DEFAULT, choiceDefault);
        dlg.setArguments(args);
        return dlg;
    }

    public void setPreloadedBackground(@NonNull Bitmap bmp) {
        this.preloadedBackgroundBitmap = bmp;
        this.hasPreloadedBackground = true;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Inflate and apply preloaded background synchronously so dialog appears with proper BG
        Bundle args = getArguments();
        backgrounds = args == null ? "" : args.getString(ARG_BACKGROUNDS, "");
        name = args == null ? "" : args.getString(ARG_NAME, "");
        key = args == null ? Keys.BAR_SELECTED_BACKGROUND : args.getString(ARG_KEY, Keys.BAR_SELECTED_BACKGROUND);
        defaultBackground = args == null ? null : args.getString(ARG_DEFAULT);
        AlertDialog.Builder builder = SettingsDialogs.builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        int rootViewId = getResId(name + "_background_selector", R.layout.class);
        rootView = inflater.inflate(rootViewId, null);

        if (hasPreloadedBackground && preloadedBackgroundBitmap != null) {
            try {
                // The middle of the wallpaper at the view's proportions, never stretched (CenterCrop)
                rootView.setBackground(new CenterCropDrawable(preloadedBackgroundBitmap));
            } catch (Throwable t) {
                Log.w(TAG, "Failed to set preloaded background: " + t.getMessage());
            }
        }

        int gridId = getResId(name + "_background_grid", R.id.class);
        gridLayout = rootView.findViewById(gridId);
        int cancelButtonId = getResId(name + "_background_cancel_button", R.id.class);
        Button cancelButton = rootView.findViewById(cancelButtonId);

        // Prepare pick button (initially GONE) and insert left of Cancel
        pickButton = new Button(requireContext());
        pickButton.setText(R.string.pick_image_manually);
        pickButton.setVisibility(View.GONE);
        try {
            if (cancelButton.getBackgroundTintList() != null) pickButton.setBackgroundTintList(cancelButton.getBackgroundTintList());
            pickButton.setTextColor(cancelButton.getTextColors());
        } catch (Exception ignored) {}

        try {
            if (rootView instanceof LinearLayout parent && cancelButton != null) {
                int cancelIndex = parent.indexOfChild(cancelButton);
                if (cancelIndex == -1) cancelIndex = parent.getChildCount();
                parent.removeView(cancelButton);

                LinearLayout h = new LinearLayout(requireContext());
                h.setOrientation(LinearLayout.HORIZONTAL);
                h.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                h.setGravity(Gravity.END);

                LinearLayout.LayoutParams btnLp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                btnLp.setMarginEnd(dpToPx(8));
                h.addView(pickButton, btnLp);
                h.addView(cancelButton, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));

                parent.addView(h, cancelIndex);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to insert pick button: " + e.getMessage());
        }

        pickButton.setOnClickListener(v -> launchPickWallpaper());
        cancelButton.setOnClickListener(v -> dismiss());

        // Load palette of built-in backgrounds
        loadBackgrounds();
        // Grid will be populated in onStart when sizing is known

        builder.setView(rootView);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        orientation = requireContext().getResources().getConfiguration().orientation;
        int[] window = windowSize(requireActivity());
        // As large as the colour picker and the lists of apps in landscape, as wide in portrait (SettingsDialogSize)
        int[] size = SettingsDialogSize.pixels(SettingsDialogSize.Kind.BACKGROUND, window[0], window[1]);
        dialogWidthPx = size[0];
        dialogHeightPx = size[1];

        Window dialogWindow = getDialog() != null ? getDialog().getWindow() : null;
        if (dialogWindow != null) dialogWindow.setLayout(dialogWidthPx, dialogHeightPx);

        // An image picked for this dialog alone by an older version is no longer used: the backdrop is the wallpaper
        SharedPreferences stored = PreferenceManager.getDefaultSharedPreferences(requireContext());
        if (stored.contains(OLD_KEY_PICKED_IMAGE)) {
            stored.edit().remove(OLD_KEY_PICKED_IMAGE).apply();
        }
        if (hasPreloadedBackground) {
            showPickButton(false);
        } else {
            // The wallpaper could not be read before the dialog came up: once more, and with nothing still
            // its colours and the button that opens the wallpaper picker
            mainHandler.post(this::reloadWallpaper);
        }

        if (gridLayout != null) {
            gridLayout.post(() -> {
                int totalWidth = gridLayout.getWidth();
                int innerWidth = totalWidth - gridLayout.getPaddingLeft() - gridLayout.getPaddingRight();
                if (innerWidth <= 0) innerWidth = Math.max(0, dialogWidthPx - dpToPx(48));
                setupGrid(innerWidth);
            });
        }
    }

    /**
     * The size in pixels of the settings' window, in the orientation it has now. The dialog was sized from
     * Launcher.screenWidth/Height, the launcher's, which never turns (nosensor): on a phone in landscape that was
     * 0.7 of the short side, a narrow dialog.
     */
    private static int[] windowSize(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
            return new int[] {bounds.width(), bounds.height()};
        }
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return new int[] {metrics.widthPixels, metrics.heightPixels};
    }

    private void showPickButton(boolean show) {
        if (pickButton == null) return;
        pickButton.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /** Reads the wallpaper again and shows it behind the tiles; without a picture its colours and the button. */
    private void reloadWallpaper() {
        if (rootView == null) {
            return;
        }
        loadWallpaperAsync();
    }

    /** Back from the wallpaper picker the button opened: the wallpaper may be another one now. */
    @Override
    public void onResume() {
        super.onResume();
        if (pickerOpened) {
            pickerOpened = false;
            reloadWallpaper();
        }
    }

    private void loadWallpaperAsync() {
        loaderExecutor.submit(() -> {
            final Context context = getContext();
            if (context == null) return;
            Point screen = HomeWallpaperSource.screenSize(context);
            Bitmap bmp = HomeWallpaperSource.read(context, screen.x, screen.y);

            final Bitmap finalBmp = bmp;
            mainHandler.post(() -> {
                if (!isAdded() || rootView == null) return;
                if (finalBmp != null) {
                    // The whole wallpaper, drawn at the size the view has at each draw (CenterCrop): it was cut to
                    // the size the view had before its layout and then stretched to the final one
                    rootView.setBackground(new CenterCropDrawable(finalBmp));
                    showPickButton(false);
                    return;
                }

                // No picture could be had: the wallpaper's colours as the backdrop where the system gives
                // them, and the button to pick an image in any case (it used to stay hidden when the colours
                // failed too, which left nothing to do)
                applyWallpaperColorsFallback(rootView);
                showPickButton(true);
            });
        });
    }

    private boolean applyWallpaperColorsFallback(@NonNull View targetView) {
        try {
            WallpaperManager wm = WallpaperManager.getInstance(requireContext());
            WallpaperColors colors = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                colors = wm.getWallpaperColors(WallpaperManager.FLAG_SYSTEM);
            }
            if (colors == null) return false;

            Integer primaryArgb = null;
            Integer secondaryArgb = null;
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                    colors.getPrimaryColor();
                    primaryArgb = colors.getPrimaryColor().toArgb();
                }
            } catch (Throwable ignored) {}
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                    if (colors.getSecondaryColor() != null) secondaryArgb = colors.getSecondaryColor().toArgb();
                }
            } catch (Throwable ignored) {}

            if (primaryArgb == null) return false;
            int p = primaryArgb;
            int s = secondaryArgb != null ? secondaryArgb : darkenColor(p);

            GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{p, s});
            gd.setCornerRadius(0f);
            gd.setAlpha(230);
            targetView.setBackground(gd);
            Log.i(TAG, "Applied colors fallback (primary=" + String.format("#%08X", p) + ", secondary=" + String.format("#%08X", s) + ")");
            return true;
        } catch (Throwable t) {
            Log.w(TAG, "Failed to apply colors fallback: ", t);
            return false;
        }
    }

    private int darkenColor(int color) {
        int a = Color.alpha(color);
        int r = Math.max(0, Math.round(Color.red(color) * (float) 0.85));
        int g = Math.max(0, Math.round(Color.green(color) * (float) 0.85));
        int b = Math.max(0, Math.round(Color.blue(color) * (float) 0.85));
        return Color.argb(a, r, g, b);
    }

    /** "Pick wallpaper": the wallpaper picker of the settings, the same one as the row under "Miscellaneous". */
    private void launchPickWallpaper() {
        pickerOpened = WallpaperPickerLauncher.open(requireContext(), pickButton);
    }

    private void loadBackgrounds() {
        // populate backgroundNames with drawables named bg_custom*
        backgroundNames = new ArrayList<>();
        if (defaultBackground != null) {
            backgroundNames.add(defaultBackground);   // first
        }
        Field[] drawables = R.drawable.class.getFields();
        for (Field field : drawables) {
            try {
                String name = field.getName();
                if (name.contains(backgrounds)) backgroundNames.add(name);
            } catch (Exception ignored) {}
        }
    }

    private void setupGrid(int contentInnerWidthPx) {
        if (gridLayout == null) return;
        gridLayout.removeAllViews();
        int columns;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            columns = 2;
        } else {
            columns = 4;
        }
        gridLayout.setColumnCount(columns);
        int gapPx = dpToPx(8);
        int halfGap = gapPx / 2;
        int cornerRadiusPx = dpToPx(12);
        int totalGaps = gapPx * (columns + 1);
        int available = Math.max(0, contentInnerWidthPx - totalGaps);
        int itemSize = available / columns;
        int minItem = dpToPx(56);
        if (itemSize < minItem) itemSize = minItem;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        // What is chosen now, read the way the home screen reads it (BackgroundChoice): a picture, or the
        // user's own colour, which has a tile of its own before the pictures
        final boolean offersNone = Keys.STATS_SELECTED_BACKGROUND.equals(key);
        BackgroundChoice chosen = offersNone ? BarBackground.statsChoice(sharedPreferences)
                : BarBackground.choice(sharedPreferences, key,
                        defaultBackground != null ? defaultBackground : backgrounds);
        String selectedBackground = chosen.kind == BackgroundChoice.Kind.PICTURE ? chosen.picture : null;

        gridLayout.addView(customColorTile(sharedPreferences, chosen, itemSize, halfGap, cornerRadiusPx));
        if (offersNone) {
            gridLayout.addView(noBackgroundTile(sharedPreferences, chosen, itemSize, halfGap, cornerRadiusPx));
        }

        for (String bgName : backgroundNames) {
            CardView cardView = new CardView(requireContext());
            cardView.setCardBackgroundColor(Color.TRANSPARENT);
            cardView.setRadius(cornerRadiusPx);
            cardView.setCardElevation(0);
            cardView.setUseCompatPadding(false);
            cardView.setPreventCornerOverlap(false);

            ImageView imageView = new ImageView(requireContext());
            int resId = getResId(bgName, R.drawable.class);
            Drawable background = null;
            if (resId != 0) background = ContextCompat.getDrawable(requireContext(), resId);

            if (background instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) background).getBitmap();
                if (bitmap != null) {
                    RoundedBitmapDrawable rounded = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                    rounded.setCornerRadius(cornerRadiusPx);
                    rounded.setAntiAlias(true);
                    imageView.setImageDrawable(rounded);
                } else {
                    imageView.setImageDrawable(background);
                }
            } else {
                imageView.setImageDrawable(background);
                imageView.setClipToOutline(true);
                imageView.setOutlineProvider(new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View v, Outline outline) {
                        outline.setRoundRect(0, 0, v.getWidth(), v.getHeight(), cornerRadiusPx);
                    }
                });
            }

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            cardView.addView(imageView);

            GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
            lp.width = itemSize;
            lp.height = itemSize;
            lp.setMargins(halfGap, halfGap, halfGap, halfGap);
            cardView.setLayoutParams(lp);

            FrameLayout.LayoutParams imageParams = new FrameLayout.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(imageParams);

            if (bgName.equals(selectedBackground)) addFrame(cardView);

            cardView.setOnClickListener(v -> {
                sharedPreferences.edit().putString(key, bgName).apply();
                dismiss();
            });

            gridLayout.addView(cardView);
        }
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    /** The chosen tile, whatever it shows: the same frame in every selector (SelectedFrameDrawable). */
    private void addFrame(CardView cardView) {
        float density = requireContext().getResources().getDisplayMetrics().density;
        cardView.setForeground(new SelectedFrameDrawable(cardView.getRadius(), 5f * density, 1.5f * density));
    }

    /**
     * The first tile: the user's own colour for this component. Without one it is the "+" of an empty place in
     * the horizontal bar, and a tap closes the selector and opens the colour picker. With one it shows the
     * colour with its transparency over what is behind the selector; a tap chooses it, and a tap on it while it is the chosen one, or a long
     * press, opens the picker to change it. The colour is stored only when "Select" is pressed in the picker.
     */
    private View customColorTile(SharedPreferences sharedPreferences, BackgroundChoice chosen, int itemSize,
                                 int halfGap, int cornerRadiusPx) {
        final String colorKey = BackgroundChoice.colorKey(key);
        final boolean hasColor = sharedPreferences.contains(colorKey);
        final int color = hasColor ? sharedPreferences.getInt(colorKey, DEFAULT_CUSTOM_COLOR) : DEFAULT_CUSTOM_COLOR;
        final boolean selected = chosen.kind == BackgroundChoice.Kind.CUSTOM;

        CardView cardView = new CardView(requireContext());
        cardView.setCardBackgroundColor(Color.TRANSPARENT);
        cardView.setRadius(cornerRadiusPx);
        cardView.setCardElevation(0);
        cardView.setUseCompatPadding(false);
        cardView.setPreventCornerOverlap(false);

        ImageView imageView = new ImageView(requireContext());
        if (hasColor) {
            imageView.setImageDrawable(new ColorTileDrawable(color, cornerRadiusPx, dpToPx(1), false));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            GradientDrawable ground = new GradientDrawable();
            ground.setColor(0x66000000);
            ground.setCornerRadius(cornerRadiusPx);
            imageView.setBackground(ground);
            imageView.setImageResource(R.drawable.icon_add);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int pad = itemSize / 4;
            imageView.setPadding(pad, pad, pad, pad);
        }
        cardView.addView(imageView, new FrameLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));

        GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
        lp.width = itemSize;
        lp.height = itemSize;
        lp.setMargins(halfGap, halfGap, halfGap, halfGap);
        cardView.setLayoutParams(lp);

        if (selected) addFrame(cardView);

        cardView.setOnClickListener(v -> {
            if (!hasColor || selected) {
                openColorPicker(colorKey, color);
            } else {
                sharedPreferences.edit().putString(key, BackgroundChoice.CUSTOM).apply();
                dismiss();
            }
        });
        if (hasColor) {
            cardView.setOnLongClickListener(v -> {
                openColorPicker(colorKey, color);
                return true;
            });
        }
        return cardView;
    }

    /** The tile for no background at all: what is behind the selector, in an outline with a line across it. */
    private View noBackgroundTile(SharedPreferences sharedPreferences, BackgroundChoice chosen, int itemSize,
                                  int halfGap, int cornerRadiusPx) {
        CardView cardView = new CardView(requireContext());
        cardView.setCardBackgroundColor(Color.TRANSPARENT);
        cardView.setRadius(cornerRadiusPx);
        cardView.setCardElevation(0);
        cardView.setUseCompatPadding(false);
        cardView.setPreventCornerOverlap(false);
        ImageView imageView = new ImageView(requireContext());
        imageView.setImageDrawable(new ColorTileDrawable(Color.TRANSPARENT, cornerRadiusPx, dpToPx(1), true));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        cardView.addView(imageView, new FrameLayout.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
        GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
        lp.width = itemSize;
        lp.height = itemSize;
        lp.setMargins(halfGap, halfGap, halfGap, halfGap);
        cardView.setLayoutParams(lp);
        if (chosen.kind == BackgroundChoice.Kind.NONE) addFrame(cardView);
        cardView.setOnClickListener(v -> {
            sharedPreferences.edit().putString(key, BackgroundChoice.NONE).apply();
            dismiss();
        });
        return cardView;
    }

    /**
     * Closes the selector and opens the picker of a background colour. Nothing is stored until "Select": a
     * picker that is closed any other way leaves the choice and the colour as they were.
     */
    private void openColorPicker(String colorKey, int startColor) {
        final FragmentManager fragments = getParentFragmentManager();
        final Context app = requireContext().getApplicationContext();
        final String choiceKey = key;
        dismiss();
        ColorPicker picker = ColorPicker.newBackgroundInstance(startColor);
        picker.enableAutoClose();
        // Bound again after a turn of the screen by the settings' second screen (ColorPickerTargets)
        ColorPickerTargets.bindBackground(picker, app, colorKey, choiceKey);
        picker.show(fragments, ColorPickerTargets.TAG_BACKGROUND);
    }

    private int dpToPx(int dp) {
        float density = requireContext().getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}