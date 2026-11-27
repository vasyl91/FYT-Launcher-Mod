package com.android.launcher66;

/**
 * How the icons inside an open folder are drawn: the size of their pictures, the colour of their labels and whether the
 * labels have the home screen's shadow.
 *
 * <p>The rules (the owner on the A55, 2026-11-27):
 * <ul>
 *   <li>With "Follow home screen grid inside folders" (D-92) an icon in the folder looks as on the home screen: the
 *       picture in the size the current page gives its icons ({@code IconFit}, smaller than the standard one on a
 *       dense grid), the label in the colour of "Set icon text color" and with the page's shadow. The label's text
 *       size is the home screen's either way ({@code BubbleTextView} takes it when it is made).</li>
 *   <li>Without it, as it always was: the standard picture, no shadow, and the dark grey made for the folder's light
 *       picture; a folder background chosen by the user gives the labels the icon text colour (it would not be read
 *       on it otherwise).</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class FolderItemLook {

    /** The size of the picture, 0 for the standard one. */
    final int iconPx;
    final int textColor;
    final boolean shadows;

    private FolderItemLook(int iconPx, int textColor, boolean shadows) {
        this.iconPx = iconPx;
        this.textColor = textColor;
        this.shadows = shadows;
    }

    /**
     * @param followHome      "Follow home screen grid inside folders" is on
     * @param ownBackground   the folders have a background the user chose
     * @param pageIconPx      the size the current page gives its icons, 0 for the standard one
     * @param homeTextColor   the colour of the home screen's labels
     * @param folderTextColor the dark grey of the folder's own picture
     */
    static FolderItemLook of(boolean followHome, boolean ownBackground, int pageIconPx, int homeTextColor,
                             int folderTextColor) {
        if (followHome) {
            return new FolderItemLook(Math.max(0, pageIconPx), homeTextColor, true);
        }
        return new FolderItemLook(0, ownBackground ? homeTextColor : folderTextColor, false);
    }
}
