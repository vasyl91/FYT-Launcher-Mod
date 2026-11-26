package com.android.launcher66;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

/**
 * The search field of the app drawer (and of the widget list): at the top of the drawer's content, always in view whatever the
 * list has scrolled to, in rounded colours of the settings with a magnifying glass on its left. The keyboard comes only
 * when the field is touched (it takes the focus no sooner), and the filter follows every change of the text
 * ({@link AppSearch}). Closing the drawer clears it ({@link #clear}). Main thread.
 */
public final class AppSearchBar extends FrameLayout {

    /** Told every change of the text. */
    interface Listener {
        void onQuery(String query);
    }

    private final EditText mField;
    private Listener mListener;
    private boolean mSilent;

    public AppSearchBar(Context context) {
        this(context, null);
    }

    public AppSearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        float density = context.getResources().getDisplayMetrics().density;
        int pad = Math.round(8f * density);
        setPadding(pad * 2, pad, pad * 2, pad);
        GradientDrawable background = new GradientDrawable();
        background.setColor(ContextCompat.getColor(context, R.color.dark_surface));
        background.setStroke(Math.max(1, Math.round(density)), ContextCompat.getColor(context, R.color.gray_medium));
        background.setCornerRadius(24f * density);
        FrameLayout box = new FrameLayout(context);
        box.setBackground(background);
        addView(box, new LayoutParams(LayoutParams.MATCH_PARENT, Math.round(48f * density)));

        ImageView glass = new ImageView(context);
        glass.setImageResource(R.drawable.ic_search);
        glass.setColorFilter(ContextCompat.getColor(context, R.color.gray_medium));
        LayoutParams glassParams = new LayoutParams(Math.round(24f * density), Math.round(24f * density),
                Gravity.CENTER_VERTICAL | Gravity.START);
        glassParams.setMarginStart(Math.round(14f * density));
        box.addView(glass, glassParams);

        mField = new EditText(context);
        mField.setBackground(null);
        mField.setSingleLine(true);
        mField.setHint(R.string.search_apps_hint);
        mField.setHintTextColor(ContextCompat.getColor(context, R.color.gray_medium));
        mField.setTextColor(Color.WHITE);
        mField.setTextSize(16f);
        mField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        mField.setImeOptions(EditorInfo.IME_ACTION_SEARCH | EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        // No focus, and so no keyboard, until the field is touched
        mField.setFocusableInTouchMode(false);
        mField.setOnTouchListener((v, event) -> {
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                mField.setFocusableInTouchMode(true);
                mField.requestFocus();
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(mField, InputMethodManager.SHOW_IMPLICIT);
                }
            }
            return false;
        });
        mField.setOnEditorActionListener((v, actionId, event) -> {
            hideKeyboard();
            return true;
        });
        mField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!mSilent && mListener != null) {
                    mListener.onQuery(s.toString());
                }
            }
        });
        LayoutParams fieldParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        fieldParams.setMarginStart(Math.round(46f * density));
        fieldParams.setMarginEnd(Math.round(14f * density));
        box.addView(mField, fieldParams);
    }

    void setListener(Listener listener) {
        mListener = listener;
    }

    /** The hint of the field: applications or widgets. */
    void setHint(int resource) {
        mField.setHint(resource);
    }

    String query() {
        return mField.getText().toString();
    }

    /** Empties the field (without telling the listener twice) and takes the keyboard away. */
    void clear() {
        if (mField.getText().length() > 0) {
            mField.setText("");
        }
        hideKeyboard();
        mField.setFocusableInTouchMode(false);
        mField.clearFocus();
    }

    /** For a test: types without the keyboard. */
    void type(String text) {
        mField.setText(text);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(mField.getWindowToken(), 0);
        }
    }
}
