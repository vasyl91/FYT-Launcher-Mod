package com.android.launcher66.colorpicker

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.InputFilter
import android.util.DisplayMetrics
import android.view.KeyEvent
import android.view.View
import android.view.WindowInsets
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.core.view.updatePadding
import androidx.fragment.app.DialogFragment
import com.android.launcher66.ColorAlpha
import com.android.launcher66.R
import com.google.android.flexbox.FlexboxLayout

/**
 * The colour picker of the settings, in two modes that share everything but the transparency:
 *
 *  - the text mode ([newTextInstance]): red, green and blue, an opaque colour, as the picker always was. It can
 *    offer "Default", which reports that no colour is wanted (the look without a tint);
 *  - the background mode ([newBackgroundInstance]): a fourth slider below the three, "Alpha: NN%", in steps of
 *    exactly 1 % (ColorAlpha), and the colour comes back with that transparency.
 *
 * The rule for both: nothing is reported while the sliders move. The colour goes to the callback only when
 * "Select" is pressed; closing the picker any other way reports nothing, so the caller keeps what it had.
 */
class ColorPicker : DialogFragment(), OnSeekBarChangeListener {
    private var colorView: View? = null
    private var alphaLabel: TextView? = null
    private var defaultCallback: Runnable? = null
    private var allowDefault = false
    private var alphaSeekBar: SeekBar? = null
    private var redSeekBar: SeekBar? = null
    private var greenSeekBar: SeekBar? = null
    private var blueSeekBar: SeekBar? = null
    private var textView: TextView? = null
    private var hexCode: EditText? = null
    private var alpha = 255
    private var alphaPercent = 100
    private var red = 0
    private var green = 0
    private var blue = 0
    private var callback: ColorPickerCallback? = null

    private var withAlpha = false
    private var autoclose = false

    companion object {
        private const val ARG_ALPHA = "alpha"
        private const val ARG_RED = "red"
        private const val ARG_GREEN = "green"
        private const val ARG_BLUE = "blue"
        private const val ARG_WITH_ALPHA = "with_alpha"
        private const val ARG_COLOR = "color"
        private const val ARG_ALLOW_DEFAULT = "allow_default"

        /** The text mode: an opaque colour; with [allowDefault] the picker also offers "Default". */
        @JvmStatic
        fun newTextInstance(@ColorInt color: Int, allowDefault: Boolean): ColorPicker {
            val args = Bundle().apply {
                putInt(ARG_RED, Color.red(color))
                putInt(ARG_GREEN, Color.green(color))
                putInt(ARG_BLUE, Color.blue(color))
                putBoolean(ARG_WITH_ALPHA, false)
                putBoolean(ARG_ALLOW_DEFAULT, allowDefault)
            }
            return ColorPicker().apply { arguments = args }
        }

        /** The background mode: the colour with its transparency, chosen in percent. */
        @JvmStatic
        fun newBackgroundInstance(@ColorInt color: Int): ColorPicker {
            val args = Bundle().apply {
                putInt(ARG_ALPHA, Color.alpha(color))
                putInt(ARG_RED, Color.red(color))
                putInt(ARG_GREEN, Color.green(color))
                putInt(ARG_BLUE, Color.blue(color))
                putBoolean(ARG_WITH_ALPHA, true)
            }
            return ColorPicker().apply { arguments = args }
        }

        @JvmStatic
        fun newInstance(): ColorPicker {
            return ColorPicker()
        }

        @JvmStatic
        fun newInstance(
            @IntRange(from = 0, to = 255) red: Int,
            @IntRange(from = 0, to = 255) green: Int,
            @IntRange(from = 0, to = 255) blue: Int
        ): ColorPicker {
            val args = Bundle().apply {
                putInt(ARG_RED, assertColorValueInRange(red))
                putInt(ARG_GREEN, assertColorValueInRange(green))
                putInt(ARG_BLUE, assertColorValueInRange(blue))
            }
            return ColorPicker().apply { arguments = args }
        }

        @JvmStatic
        fun newInstance(@ColorInt color: Int): ColorPicker {
            val args = Bundle().apply {
                putInt(ARG_COLOR, color)
                putInt(ARG_ALPHA, Color.alpha(color))
                putInt(ARG_RED, Color.red(color))
                putInt(ARG_GREEN, Color.green(color))
                putInt(ARG_BLUE, Color.blue(color))
                putBoolean(ARG_WITH_ALPHA, Color.alpha(color) < 255)
            }
            return ColorPicker().apply { arguments = args }
        }

        @JvmStatic
        fun newInstance(
            @IntRange(from = 0, to = 255) alpha: Int,
            @IntRange(from = 0, to = 255) red: Int,
            @IntRange(from = 0, to = 255) green: Int,
            @IntRange(from = 0, to = 255) blue: Int
        ): ColorPicker {
            val args = Bundle().apply {
                putInt(ARG_ALPHA, assertColorValueInRange(alpha))
                putInt(ARG_RED, assertColorValueInRange(red))
                putInt(ARG_GREEN, assertColorValueInRange(green))
                putInt(ARG_BLUE, assertColorValueInRange(blue))
                putBoolean(ARG_WITH_ALPHA, true)
            }
            return ColorPicker().apply { arguments = args }
        }

        private fun assertColorValueInRange(value: Int): Int {
            return value.coerceIn(0, 255)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Only set callback from context if it wasn't already set programmatically
        if (callback == null) {
            callback = when {
                context is ColorPickerCallback -> context
                parentFragment is ColorPickerCallback -> parentFragment as ColorPickerCallback
                else -> null
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            if (args.containsKey(ARG_COLOR)) {
                val color = args.getInt(ARG_COLOR)
                alpha = Color.alpha(color)
                red = Color.red(color)
                green = Color.green(color)
                blue = Color.blue(color)
                withAlpha = Color.alpha(color) < 255
            } else {
                red = args.getInt(ARG_RED, 0)
                green = args.getInt(ARG_GREEN, 0)
                blue = args.getInt(ARG_BLUE, 0)
                alpha = args.getInt(ARG_ALPHA, 255)
                withAlpha = args.getBoolean(ARG_WITH_ALPHA, false)
            }
            allowDefault = args.getBoolean(ARG_ALLOW_DEFAULT, false)
        }
        // The slider counts in percent; the colour is kept at the alpha of that percent from the start
        alphaPercent = ColorAlpha.toPercent(alpha)
        alpha = ColorAlpha.toAlpha(alphaPercent)
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.materialcolorpicker__layout_color_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var textSize = 0
        var padding = 0

        activity?.let { activity ->
            val metrics = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val windowMetrics = activity.windowManager.currentWindowMetrics
                val insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
                windowMetrics.bounds.let {
                    // Adjust for system bars if needed
                    val screenWidth = it.width() + insets.left + insets.right
                    val screenHeight = it.height() + insets.top + insets.bottom
                    DisplayMetrics().apply {
                        widthPixels = screenWidth
                        heightPixels = screenHeight
                    }
                }
            } else {
                @Suppress("DEPRECATION")
                activity.windowManager.defaultDisplay.let { display ->
                    DisplayMetrics().also { display.getRealMetrics(it) }
                }
            }

            var deviceWidth = metrics.widthPixels
            val configuration = context?.resources?.configuration
            if (configuration?.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                deviceWidth = metrics.heightPixels
            }

            textSize = (deviceWidth * 0.015).toInt()
            padding = (deviceWidth * 0.02).toInt()
        }

        val pickerContainer = view.findViewById<FlexboxLayout>(R.id.pickerContainer)
        pickerContainer?.updatePadding(
            left = padding,
            right = padding
        )

        val pickerContainerBottom = view.findViewById<FlexboxLayout>(R.id.pickerContainerBottom)
        pickerContainerBottom?.updatePadding(
            bottom = padding
        )

        colorView = view.findViewById(R.id.colorView)

        alphaSeekBar = view.findViewById(R.id.alphaSeekBar)
        alphaSeekBar?.updatePadding(
            right = padding * 2
        )
        redSeekBar = view.findViewById(R.id.redSeekBar)
        redSeekBar?.updatePadding(
            right = padding * 2
        )
        greenSeekBar = view.findViewById(R.id.greenSeekBar)
        greenSeekBar?.updatePadding(
            right = padding * 2
        )
        blueSeekBar = view.findViewById(R.id.blueSeekBar)
        blueSeekBar?.updatePadding(
            right = padding * 2
        )

        alphaLabel = view.findViewById(R.id.alphaLabel)
        alphaLabel?.textSize = textSize.toFloat()

        alphaSeekBar?.setOnSeekBarChangeListener(this)
        redSeekBar?.setOnSeekBarChangeListener(this)
        greenSeekBar?.setOnSeekBarChangeListener(this)
        blueSeekBar?.setOnSeekBarChangeListener(this)

        textView = view.findViewById(R.id.textView)
        textView?.textSize = textSize.toFloat()

        hexCode = view.findViewById(R.id.hexCode)
        activity?.let {
            hexCode?.setTextColor(ContextCompat.getColor(it, R.color.black))
        }
        hexCode?.textSize = textSize.toFloat()
        hexCode?.filters = arrayOf(InputFilter.LengthFilter(6))
        hexCode?.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)
            ) {
                updateColorView(v.text.toString())
                val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(hexCode?.windowToken, 0)

                true
            } else {
                false
            }
        }

        val okColor = view.findViewById<Button>(R.id.okColorButton)
        okColor?.textSize = textSize.toFloat()
        okColor?.setOnClickListener {
            sendColor()
        }
        okColor?.updatePadding(
            left = textSize,
            right = textSize
        )

        val defaultColor = view.findViewById<Button>(R.id.defaultColorButton)
        defaultColor?.textSize = textSize.toFloat()
        defaultColor?.updatePadding(
            left = textSize,
            right = textSize
        )
        defaultColor?.visibility = if (allowDefault && !withAlpha) View.VISIBLE else View.GONE
        defaultColor?.setOnClickListener {
            defaultCallback?.run()
            if (autoclose) {
                dismiss()
            }
        }

        initUi()
    }

    override fun onStart() {
        super.onStart()
        activity?.let { activity ->
            val metrics = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val windowMetrics = activity.windowManager.currentWindowMetrics
                val insets = windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
                windowMetrics.bounds.let {
                    DisplayMetrics().apply {
                        widthPixels = it.width() + insets.left + insets.right
                        heightPixels = it.height() + insets.top + insets.bottom
                    }
                }
            } else {
                @Suppress("DEPRECATION")
                activity.windowManager.defaultDisplay.let { display ->
                    DisplayMetrics().also { display.getRealMetrics(it) }
                }
            }

            val width = (metrics.widthPixels * 0.7).toInt()
            val height = (metrics.heightPixels * 0.6).toInt()
            
            dialog?.window?.apply {
                setLayout(width, height)
                setBackgroundDrawableResource(android.R.color.transparent) // Add this
            }
        }
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

    /** What "Default" does (text mode with allowDefault): the caller forgets its colour. */
    fun setDefaultCallback(listener: Runnable?) {
        defaultCallback = listener
    }

    private fun initUi() {
        colorView?.setBackgroundColor(getColor())

        alphaSeekBar?.progress = alphaPercent
        redSeekBar?.progress = red
        greenSeekBar?.progress = green
        blueSeekBar?.progress = blue

        alphaSeekBar?.visibility = if (withAlpha) View.VISIBLE else View.GONE
        alphaLabel?.visibility = if (withAlpha) View.VISIBLE else View.GONE
        showAlphaPercent()

        // The hex field holds red, green and blue in both modes; the transparency has its own slider
        hexCode?.setText(ColorFormatHelper.formatColorValues(red, green, blue))
    }

    private fun showAlphaPercent() {
        alphaLabel?.text = getString(R.string.color_picker_alpha, alphaPercent)
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
            val color = "#$input".toColorInt()
            red = Color.red(color)
            green = Color.green(color)
            blue = Color.blue(color)

            colorView?.setBackgroundColor(getColor())

            redSeekBar?.progress = red
            greenSeekBar?.progress = green
            blueSeekBar?.progress = blue
        } catch (ignored: IllegalArgumentException) {
            activity?.resources?.getText(R.string.materialcolorpicker__errHex)?.let {
                hexCode?.error = it
            }
        }
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        when (seekBar.id) {
            R.id.alphaSeekBar -> {
                alphaPercent = progress
                alpha = ColorAlpha.toAlpha(progress)
                showAlphaPercent()
            }
            R.id.redSeekBar -> red = progress
            R.id.greenSeekBar -> green = progress
            R.id.blueSeekBar -> blue = progress
        }

        colorView?.setBackgroundColor(getColor())

        // Setting the inputText hex color
        hexCode?.setText(ColorFormatHelper.formatColorValues(red, green, blue))
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

    fun isShowing(): Boolean {
        return dialog?.isShowing == true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear all view references
        colorView = null
        alphaSeekBar = null
        redSeekBar = null
        greenSeekBar = null
        blueSeekBar = null
        textView = null
        hexCode = null
        alphaLabel = null
        defaultCallback = null
        callback = null  
    }
}