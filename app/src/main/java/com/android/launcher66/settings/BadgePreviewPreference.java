package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

import com.android.launcher66.BadgePreview;
import com.android.launcher66.R;

/**
 * The preview of the notification badge: the launcher's own icon, in the size of the icons of the home screen and without a
 * name, centred between two separators, with a badge of "4" made from the settings below it, and in the icon text
 * colour of the home screen. Every change of a badge setting, of the accent or of the icon text colour shows at once:
 * the row listens to the preferences while it is on a screen.
 */
public class BadgePreviewPreference extends Preference {

    private final SharedPreferences.OnSharedPreferenceChangeListener mListener = (prefs, key) -> notifyChanged();

    public BadgePreviewPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.badge_preview);
        setSelectable(false);
        setPersistent(false);
    }

    @Override
    public void onAttached() {
        super.onAttached();
        PreferenceManager.getDefaultSharedPreferences(getContext()).registerOnSharedPreferenceChangeListener(mListener);
    }

    @Override
    public void onDetached() {
        PreferenceManager.getDefaultSharedPreferences(getContext()).unregisterOnSharedPreferenceChangeListener(mListener);
        super.onDetached();
    }

    @Override
    public void onBindViewHolder(@NonNull PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        ImageView icon = (ImageView) holder.findViewById(R.id.badge_preview_icon);
        int size = BadgePreview.iconSizePx(getContext());
        ViewGroup.LayoutParams lp = icon.getLayoutParams();
        lp.width = size;
        lp.height = size;
        icon.setLayoutParams(lp);
        BadgePreview.show(icon, size);
    }
}
