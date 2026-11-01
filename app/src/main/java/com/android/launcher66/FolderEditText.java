package com.android.launcher66;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class FolderEditText extends EditText {

    private Folder mFolder;

    public FolderEditText(Context context) {
        super(context);
    }

    public FolderEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FolderEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setFolder(Folder folder) {
        mFolder = folder;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        // While the pinned PiP is shown, Back reaches this only through PinnedPipFocus's window
        // (its dispatchKeyEventPreIme()), i.e. while that window has the focus: after a touch on
        // the PiP it is the PiP app's.
        // Catch the back button on the soft keyboard so that we can just close the activity
        if (event.getKeyCode() == android.view.KeyEvent.KEYCODE_BACK) {
            mFolder.doneEditingFolderName(true);
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
