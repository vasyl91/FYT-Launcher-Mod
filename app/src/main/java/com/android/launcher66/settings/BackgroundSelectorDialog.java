package com.android.launcher66.settings;

import android.app.Activity;
import android.app.Dialog;
import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
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
import com.android.launcher66.Launcher;
import com.android.launcher66.colorpicker.ColorPicker;
import com.android.launcher66.R;

import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private static final int REQ_PICK_WALLPAPER = 5001;
    /** The colour the picker starts from the first time: a dark grey that lets a fifth of the wallpaper through. */
    private static final int DEFAULT_CUSTOM_COLOR = 0xCC212121;
    private static final String PREF_KEY_SELECTED_BG_URI = "selected_background_uri";

    private GridLayout gridLayout;
    private View rootView;
    private Button pickButton;

    private List<String> backgroundNames;

    private boolean userPickedUri = false;
    private boolean hasPreloadedBackground = false;
    private Bitmap preloadedBackgroundBitmap = null;

    private int orientation;
    private int dialogWidthPx = 0;
    private int dialogHeightPx = 0;

    private static final ExecutorService loaderExecutor = Executors.newSingleThreadExecutor();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static void showWithLoadedBackground(@NonNull FragmentManager fm, @NonNull Context ctx, @NonNull String tag, @NonNull String bgs) {
        final String choiceKey;
        final String choiceDefault;
        if (tag.equals("widgets")) {
            choiceKey = Keys.WIDGETS_SELECTED_BACKGROUND;
            choiceDefault = null;
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
        loaderExecutor.submit(() -> {
            Bitmap bmp = null;
            try {
                WallpaperManager wm = WallpaperManager.getInstance(ctx);

                // 1) reflective getBitmap()
                try {
                    Method m = wm.getClass().getMethod("getBitmap");
                    Object o = m.invoke(wm);
                    if (o instanceof Bitmap) bmp = (Bitmap) o;
                } catch (NoSuchMethodException ignored) {
                } catch (InvocationTargetException ite) {
                    Throwable cause = ite.getCause();
                    if (cause instanceof SecurityException) {
                        Log.w(TAG, "Loader: SecurityException from getBitmap(): " + cause.getMessage());
                    } else {
                        Log.w(TAG, "Loader: getBitmap() threw: " + cause);
                    }
                } catch (Throwable t) {
                    Log.w(TAG, "Loader: error invoking getBitmap(): ", t);
                }

                // 2) getWallpaperFile()
                if (bmp == null) {
                    try (ParcelFileDescriptor pfd = wm.getWallpaperFile(WallpaperManager.FLAG_SYSTEM)) {
                        if (pfd != null) {
                            FileDescriptor fd = pfd.getFileDescriptor();
                            if (fd != null) bmp = BitmapFactory.decodeFileDescriptor(fd);
                        }
                    } catch (SecurityException se) {
                        Log.w(TAG, "Loader: SecurityException reading wallpaper file: " + se.getMessage());
                    } catch (Throwable t) {
                        Log.w(TAG, "Loader: failed to decode wallpaper file: ", t);
                    }
                }

                // 3) getDrawable() -> render
                if (bmp == null) {
                    try {
                        Drawable d = wm.getDrawable();
                        if (d != null) {
                            int targetW = Math.max(300, Math.round(Launcher.screenWidth * 0.8f));
                            int targetH = Math.max(300, Math.round(Launcher.screenHeight * 0.7f));
                            bmp = drawableToBitmapForSizeStatic(d, targetW, targetH);
                        }
                    } catch (SecurityException se) {
                        Log.w(TAG, "Loader: SecurityException getting drawable: " + se.getMessage());
                    } catch (Throwable t) {
                        Log.w(TAG, "Loader: failed rendering drawable: ", t);
                    }
                }
            } catch (Throwable t) {
                Log.w(TAG, "Loader: unexpected error: ", t);
            }

            final Bitmap finalBmp = bmp;
            mainHandler.post(() -> {
                try {
                    BackgroundSelectorDialog dlg = new BackgroundSelectorDialog();
                    Bundle args = new Bundle();
                    args.putString(ARG_BACKGROUNDS, bgs);
                    args.putString(ARG_NAME, tag);
                    args.putString(ARG_KEY, choiceKey);
                    args.putString(ARG_DEFAULT, choiceDefault);
                    dlg.setArguments(args);
                    if (finalBmp != null) dlg.setPreloadedBackground(finalBmp);
                    fm.beginTransaction().add(dlg, tag).commitAllowingStateLoss();
                } catch (Throwable t) {
                    Log.w(TAG, "Failed to show dialog after load: " + t.getMessage(), t);
                }
            });
        });
    }

    private static Bitmap drawableToBitmapForSizeStatic(Drawable drawable, int targetW, int targetH) {
        if (drawable == null || targetW <= 0 || targetH <= 0) return null;
        int intrinsicW = drawable.getIntrinsicWidth();
        int intrinsicH = drawable.getIntrinsicHeight();
        Bitmap out = Bitmap.createBitmap(targetW, targetH, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(out);
        if (intrinsicW > 0 && intrinsicH > 0) {
            float scale = Math.max((float) targetW / intrinsicW, (float) targetH / intrinsicH);
            int drawW = Math.round(intrinsicW * scale);
            int drawH = Math.round(intrinsicH * scale);
            int left = (targetW - drawW) / 2;
            int top = (targetH - drawH) / 2;
            drawable.setBounds(left, top, left + drawW, top + drawH);
        } else {
            drawable.setBounds(0, 0, targetW, targetH);
        }
        drawable.draw(canvas);
        return out;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        int rootViewId = getResId(name + "_background_selector", R.layout.class);
        rootView = inflater.inflate(rootViewId, null);

        if (hasPreloadedBackground && preloadedBackgroundBitmap != null) {
            try {
                rootView.setBackground(new BitmapDrawable(getResources(), preloadedBackgroundBitmap));
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
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            dialogWidthPx = (int) (Launcher.screenWidth * 0.8);
        } else {
            dialogWidthPx = (int) (Launcher.screenWidth * 0.7);
        }
        dialogHeightPx = (int) (Launcher.screenHeight * 0.8);

        Window window = getDialog() != null ? getDialog().getWindow() : null;
        if (window != null) window.setLayout(dialogWidthPx, dialogHeightPx);

        // If preloaded background was applied already, avoid reloading system wallpaper.
        String persistedUri = PreferenceManager.getDefaultSharedPreferences(requireContext())
                .getString(PREF_KEY_SELECTED_BG_URI, null);
        if (hasPreloadedBackground) {
            if (persistedUri != null) {
                userPickedUri = true;
                showPickButton(true);
            } else {
                showPickButton(false);
            }
        } else {
            // If user previously picked a URI use it; otherwise start async load (dialog already shown but will be updated)
            if (persistedUri != null) {
                Uri uri = Uri.parse(persistedUri);
                userPickedUri = true;
                mainHandler.post(() -> {
                    int w = rootView.getWidth() > 0 ? rootView.getWidth() : dialogWidthPx;
                    int h = rootView.getHeight() > 0 ? rootView.getHeight() : dialogHeightPx;
                    boolean applied = applyPickedImageAsBackground(uri, w, h);
                    Log.i(TAG, "Applied persisted picked wallpaper? " + applied);
                    showPickButton(true);
                });
            } else {
                // Try to load system wallpaper async and update the dialog when ready
                mainHandler.post(() -> loadWallpaperAsync(rootView.getWidth() > 0 ? rootView.getWidth() : dialogWidthPx,
                        rootView.getHeight() > 0 ? rootView.getHeight() : dialogHeightPx));
            }
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

    private void showPickButton(boolean show) {
        if (pickButton == null) return;
        pickButton.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void loadWallpaperAsync(int targetW, int targetH) {
        loaderExecutor.submit(() -> {
            if (userPickedUri) return;

            final WallpaperManager wm = WallpaperManager.getInstance(requireContext());
            Bitmap bmp = null;

            // reflection getBitmap()
            try {
                Method m = wm.getClass().getMethod("getBitmap");
                Object o = m.invoke(wm);
                if (o instanceof Bitmap) bmp = (Bitmap) o;
            } catch (NoSuchMethodException ignored) {
            } catch (InvocationTargetException ite) {
                Throwable cause = ite.getCause();
                if (cause instanceof SecurityException) {
                    Log.w(TAG, "SecurityException from getBitmap(): " + cause.getMessage());
                } else {
                    Log.w(TAG, "getBitmap invocation failed: " + cause);
                }
            } catch (Throwable t) {
                Log.w(TAG, "Error invoking getBitmap reflectively: ", t);
            }

            // getWallpaperFile
            if (bmp == null) {
                try (ParcelFileDescriptor pfd = wm.getWallpaperFile(WallpaperManager.FLAG_SYSTEM)) {
                    if (pfd != null) {
                        FileDescriptor fd = pfd.getFileDescriptor();
                        if (fd != null) bmp = BitmapFactory.decodeFileDescriptor(fd);
                    }
                } catch (SecurityException se) {
                    Log.w(TAG, "SecurityException reading wallpaper file: " + se.getMessage());
                } catch (Throwable t) {
                    Log.w(TAG, "Failed to decode wallpaper file: ", t);
                }
            }

            // drawable render
            if (bmp == null) {
                try {
                    Drawable d = wm.getDrawable();
                    if (d != null) bmp = drawableToBitmapForSizeStatic(d, targetW, targetH);
                } catch (SecurityException se) {
                    Log.w(TAG, "SecurityException getting drawable: " + se.getMessage());
                } catch (Throwable t) {
                    Log.w(TAG, "Failed to render drawable: ", t);
                }
            }

            final Bitmap finalBmp = bmp;
            mainHandler.post(() -> {
                if (finalBmp != null) {
                    Bitmap cropped = getCenterCroppedBitmap(finalBmp, targetW, targetH);
                    rootView.setBackground(new BitmapDrawable(getResources(), cropped));
                    showPickButton(false);
                    return;
                }

                // fallback to colors & show pick button
                boolean colors = applyWallpaperColorsFallback(rootView);
                showPickButton(colors);
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

    private void launchPickWallpaper() {
        try {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            startActivityForResult(intent, REQ_PICK_WALLPAPER);
        } catch (ActivityNotFoundException e) {
            Log.w(TAG, "No picker available: " + e.getMessage());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_PICK_WALLPAPER && resultCode == Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            if (uri != null) {
                int takeFlags = data.getFlags() & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                if ((takeFlags & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION)) == 0) {
                    takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                }
                try {
                    // Attempt to take persistable permission (may or may not be provided by the picker)
                    requireContext().getContentResolver().takePersistableUriPermission(uri, takeFlags);
                } catch (Exception e) {
                    Log.w(TAG, "Failed to take persistable permission: " + e.getMessage());
                }

                userPickedUri = true;
                PreferenceManager.getDefaultSharedPreferences(requireContext())
                        .edit().putString(PREF_KEY_SELECTED_BG_URI, uri.toString()).apply();

                int w = rootView.getWidth() > 0 ? rootView.getWidth() : dialogWidthPx;
                int h = rootView.getHeight() > 0 ? rootView.getHeight() : dialogHeightPx;

                // Use background loader thread for decoding large images to avoid stalling UI.
                loaderExecutor.submit(() -> {
                    boolean applied = applyPickedImageAsBackground(uri, w, h);
                    Log.i(TAG, "Applied picked wallpaper? " + applied);
                    mainHandler.post(() -> {
                        if (applied) showPickButton(true);
                    });
                });
            }
        }
    }
    
    private boolean applyPickedImageAsBackground(@NonNull Uri uri, int targetW, int targetH) {
        try (ParcelFileDescriptor pfd = requireContext().getContentResolver().openFileDescriptor(uri, "r")) {
            if (pfd == null) return false;
            FileDescriptor fd = pfd.getFileDescriptor();
            if (fd == null) return false;

            Bitmap decoded = BitmapFactory.decodeFileDescriptor(fd);
            if (decoded == null) return false;

            Bitmap cropped = getCenterCroppedBitmap(decoded, targetW, targetH);

            // Update UI on main thread (caller may already be on main thread)
            if (Looper.myLooper() == Looper.getMainLooper()) {
                rootView.setBackground(new BitmapDrawable(getResources(), cropped));
            } else {
                final Bitmap finalCropped = cropped;
                mainHandler.post(() -> rootView.setBackground(new BitmapDrawable(getResources(), finalCropped)));
            }
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Failed to load picked image: " + e.getMessage(), e);
            return false;
        }
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
     * colour and its transparency; a tap chooses it, and a tap on it while it is the chosen one, or a long
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
            imageView.setImageDrawable(new ColorTileDrawable(color, cornerRadiusPx, dpToPx(10)));
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

    /** The tile for no background at all: the chequered ground of a fully transparent colour. */
    private View noBackgroundTile(SharedPreferences sharedPreferences, BackgroundChoice chosen, int itemSize,
                                  int halfGap, int cornerRadiusPx) {
        CardView cardView = new CardView(requireContext());
        cardView.setCardBackgroundColor(Color.TRANSPARENT);
        cardView.setRadius(cornerRadiusPx);
        cardView.setCardElevation(0);
        cardView.setUseCompatPadding(false);
        cardView.setPreventCornerOverlap(false);
        ImageView imageView = new ImageView(requireContext());
        imageView.setImageDrawable(new ColorTileDrawable(Color.TRANSPARENT, cornerRadiusPx, dpToPx(10)));
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
        picker.setCallback(color -> {
            PreferenceManager.getDefaultSharedPreferences(app).edit()
                    .putInt(colorKey, color)
                    .putString(choiceKey, BackgroundChoice.CUSTOM)
                    .apply();
            Log.i(TAG, "Own background colour stored under " + colorKey + ": #" + String.format("%08X", color));
        });
        picker.show(fragments, "BackgroundColorPicker");
    }

    private Bitmap getCenterCroppedBitmap(Bitmap src, int targetW, int targetH) {
        if (src == null || targetW <= 0 || targetH <= 0) return src;
        int srcW = src.getWidth();
        int srcH = src.getHeight();
        float scale = Math.max((float) targetW / srcW, (float) targetH / srcH);
        int scaledW = Math.round(srcW * scale);
        int scaledH = Math.round(srcH * scale);
        Bitmap scaled = Bitmap.createScaledBitmap(src, scaledW, scaledH, true);
        int x = Math.max(0, (scaledW - targetW) / 2);
        int y = Math.max(0, (scaledH - targetH) / 2);
        Bitmap result = Bitmap.createBitmap(scaled, x, y, targetW, targetH);
        if (result != scaled && !scaled.isRecycled()) {
            try { scaled.recycle(); } catch (Exception ignored) {}
        }
        return result;
    }

    private int dpToPx(int dp) {
        float density = requireContext().getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}