package com.android.launcher66.settings;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

/**
 * Opens a releases page in the browser. A head unit may have no browser at all; then the link is
 * put on the clipboard, to be opened from another device, as the patches link is.
 */
final class ReleasesPage {

    private ReleasesPage() {}

    /** @param tag the caller's log tag */
    static void open(Context context, String url, String tag) {
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browser.addCategory(Intent.CATEGORY_BROWSABLE);
        browser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(browser);
        } catch (ActivityNotFoundException e) {
            copyToClipboard(context, url, tag);
        }
    }

    private static void copyToClipboard(Context context, String url, String tag) {
        try {
            ClipboardManager clipboard =
                    (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard == null) {
                Log.w(tag, "No browser to open " + url + " and no clipboard");
                return;
            }
            clipboard.setPrimaryClip(ClipData.newPlainText("URL", url));
            // Shown on Android 13+ too, where the system confirms a copy by itself: the owner
            // wants the message, as with the patches link.
            Toast.makeText(LauncherApplication.sApp, R.string.url_copied, Toast.LENGTH_SHORT).show();
            Log.w(tag, "No browser to open " + url + ", copied to the clipboard");
        } catch (RuntimeException e) {
            Log.w(tag, "No browser to open " + url + ", and copying it failed", e);
        }
    }
}
