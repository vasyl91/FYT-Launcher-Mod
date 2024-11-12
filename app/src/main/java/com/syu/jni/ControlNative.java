package com.syu.jni;

public class ControlNative {
    public static ControlNative INSTANCE;
    public static boolean bLoadLibOk;

    public native int fytSetLedColor(int i);

    public native int fyt_Clone_Screen_Ratio(int i, int i2, int i3);

    public native int fyt_Get_Clone_Ratio(int[] iArr);

    public native int fyt_Save_Clone_Ratio(int[] iArr);

    public native int fyt_audio_status();

    public native int fyt_backcar_get_settings(char[] cArr);

    public native int fyt_backcar_setdefault();

    public native int fyt_backcar_settings(char c, char c2, char c3, char c4);

    public native int fyt_backtype_get();

    public native int fyt_backtype_set(int i);

    public native int fyt_car_image_get_on();

    public native int fyt_car_image_set_on(int i);

    public native int fyt_encryption_result();

    public native int fyt_get8288_NP();

    public native int fyt_get8288_signal();

    public native byte[] fyt_get_ui_time();

    public native int fyt_gpio_read(int i);

    public native int fyt_gpio_setup(int i, int i2, int i3);

    public native int fyt_gpio_write(int i, int i2);

    public native int fyt_gps_sound_status_listen();

    public native int fyt_lightoff_timeout_listen();

    public native int fyt_lightoff_timeout_set(int i);

    public native int fyt_logo_write(byte[] bArr, int i);

    public native char fyt_multicolour_light_read();

    public native int fyt_multicolour_light_set(char c);

    public native int fyt_sound_control(char c);

    public native int fyt_sound_spectrogram_close(int i);

    public native int fyt_sound_spectrogram_open();

    public native int fyt_sound_spectrogram_read(int i);

    public native int fyt_sound_spectrogram_write(int i, int i2);

    public native int fyt_update_clear();

    public native int fyt_update_get();

    public native int fyt_usb_speed_get();

    public native char fyt_usb_speed_set(int i);

    static {
        bLoadLibOk = true;
        try {
            System.loadLibrary("sqlcontrol");
        } catch (Throwable th) {
            bLoadLibOk = false;
        }
        INSTANCE = new ControlNative();
    }
}
