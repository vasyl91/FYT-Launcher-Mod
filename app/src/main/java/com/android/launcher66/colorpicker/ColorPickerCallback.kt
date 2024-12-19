package com.android.launcher66.colorpicker

import androidx.annotation.ColorInt

interface ColorPickerCallback {
    fun onColorChosen(@ColorInt color: Int)
}

