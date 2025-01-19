@file:Suppress("unused")

package com.android.launcher66.colorpicker

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.InputFilter
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import com.android.launcher66.colorpicker.ColorFormatHelper.formatColorValues
import com.android.launcher66.R

class ColorPicker(private val activity: Activity) : Dialog(activity), OnSeekBarChangeListener {
    private var colorView: View? = null
    private var alphaSeekBar: SeekBar? = null
    private var redSeekBar: SeekBar? = null
    private var greenSeekBar: SeekBar? = null
    private var blueSeekBar: SeekBar? = null
    private var hexCode: EditText? = null
    private var alpha = 255
    private var red = 0
    private var green = 0
    private var blue = 0
    private var callback: ColorPickerCallback? = null

    private var withAlpha = false
    private var autoclose = false

    init {
        if (activity is ColorPickerCallback) {
            callback = activity
        }
    }

    constructor(activity: Activity,
                @IntRange(from = 0, to = 255) red: Int,
                @IntRange(from = 0, to = 255) green: Int,
                @IntRange(from = 0, to = 255) blue: Int) : this(activity) {
        this.red = assertColorValueInRange(red)
        this.green = assertColorValueInRange(green)
        this.blue = assertColorValueInRange(blue)
    }

    constructor(activity: Activity,
                @ColorInt color: Int) : this(activity) {
        this.alpha = Color.alpha(color)
        this.red = Color.red(color)
        this.green = Color.green(color)
        this.blue = Color.blue(color)
        this.withAlpha = this.alpha < 255
    }

    constructor(activity: Activity,
                @IntRange(from = 0, to = 255) alpha: Int,
                @IntRange(from = 0, to = 255) red: Int,
                @IntRange(from = 0, to = 255) green: Int,
                @IntRange(from = 0, to = 255) blue: Int) : this(activity) {
        this.alpha = assertColorValueInRange(alpha)
        this.red = assertColorValueInRange(red)
        this.green = assertColorValueInRange(green)
        this.blue = assertColorValueInRange(blue)
        this.withAlpha = true
    }

    private fun assertColorValueInRange(value: Int): Int {
        return value.coerceIn(0, 255)
    }

    fun enableAutoClose() {
        this.autoclose = true
    }

    fun disableAutoClose() {
        this.autoclose = false
    }

    fun setCallback(listener: ColorPickerCallback?) {
        callback = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.materialcolorpicker__layout_color_picker)

        colorView = findViewById(R.id.colorView)

        hexCode = findViewById(R.id.hexCode)

        alphaSeekBar = findViewById(R.id.alphaSeekBar)
        redSeekBar = findViewById(R.id.redSeekBar)
        greenSeekBar = findViewById(R.id.greenSeekBar)
        blueSeekBar = findViewById(R.id.blueSeekBar)

        alphaSeekBar?.setOnSeekBarChangeListener(this)
        redSeekBar?.setOnSeekBarChangeListener(this)
        greenSeekBar?.setOnSeekBarChangeListener(this)
        blueSeekBar?.setOnSeekBarChangeListener(this)

        hexCode?.filters = arrayOf(InputFilter.LengthFilter(if (withAlpha) 8 else 6))

        hexCode?.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) {
                updateColorView(v.text.toString())
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(hexCode?.windowToken, 0)

                true
            } else {
                false
            }
        }

        val okColor = findViewById<Button>(R.id.okColorButton)
        okColor.setOnClickListener {
            sendColor()
        }
    }

    private fun initUi() {
        colorView?.setBackgroundColor(getColor())

        alphaSeekBar?.progress = alpha
        redSeekBar?.progress = red
        greenSeekBar?.progress = green
        blueSeekBar?.progress = blue

        if (!withAlpha) {
            alphaSeekBar?.visibility = View.GONE
        }

        hexCode?.setText(if (withAlpha) formatColorValues(alpha, red, green, blue) else formatColorValues(red, green, blue))
    }

    private fun sendColor() {
        callback?.onColorChosen(getColor())
        if (autoclose) {
            dismiss()
        }
    }

    fun setColor(@ColorInt color: Int) {
        alpha = Color.alpha(color)
        red = Color.red(color)
        green = Color.green(color)
        blue = Color.blue(color)
    }

    private fun updateColorView(input: String) {
        try {
            val color = Color.parseColor("#$input")
            alpha = Color.alpha(color)
            red = Color.red(color)
            green = Color.green(color)
            blue = Color.blue(color)

            colorView?.setBackgroundColor(getColor())

            alphaSeekBar?.progress = alpha
            redSeekBar?.progress = red
            greenSeekBar?.progress = green
            blueSeekBar?.progress = blue
        } catch (ignored: IllegalArgumentException) {
            hexCode?.error = activity.resources.getText(R.string.materialcolorpicker__errHex)
        }
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        when (seekBar.id) {
            R.id.alphaSeekBar -> alpha = progress
            R.id.redSeekBar -> red = progress
            R.id.greenSeekBar -> green = progress
            R.id.blueSeekBar -> blue = progress
        }

        colorView?.setBackgroundColor(getColor())

        // Setting the inputText hex color
        hexCode?.setText(
            if (withAlpha) formatColorValues(alpha, red, green, blue)
            else formatColorValues(red, green, blue)
        )
    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {}

    override fun onStartTrackingTouch(seekBar: SeekBar) {}

    fun getAlpha(): Int {
        return alpha
    }

    fun getRed(): Int {
        return red
    }

    fun getGreen(): Int {
        return green
    }

    fun getBlue(): Int {
        return blue
    }

    fun setAlpha(alpha: Int) {
        this.alpha = alpha
    }

    fun setRed(red: Int) {
        this.red = red
    }

    fun setGreen(green: Int) {
        this.green = green
    }

    fun setBlue(blue: Int) {
        this.blue = blue
    }

    fun setAll(alpha: Int, red: Int, green: Int, blue: Int) {
        this.alpha = alpha
        this.red = red
        this.green = green
        this.blue = blue
    }

    fun setColors(red: Int, green: Int, blue: Int) {
        this.red = red
        this.green = green
        this.blue = blue
    }

    fun getColor(): Int {
        return if (withAlpha) Color.argb(alpha, red, green, blue) else Color.rgb(red, green, blue)
    }

    override fun show() {
        super.show()
        initUi()
    }
}
