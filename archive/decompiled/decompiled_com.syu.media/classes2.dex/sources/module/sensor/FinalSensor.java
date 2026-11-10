package module.sensor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FinalSensor {

    public final class Options {
        public static final int GYROSENSOR_ANGLE2UI = 6;
        public static final int GYROSENSOR_CALI = 0;
        public static final int GYROSENSOR_CHIP_TEMP = 8;
        public static final int GYROSENSOR_DELAY_TIME = 4;
        public static final int GYROSENSOR_GRAVITY = 1;
        public static final int GYROSENSOR_LINEAR_ACCELERATION = 3;
        public static final int GYROSENSOR_OK_DATA = 5;
        public static final int GYROSENSOR_PODU = 9;
        public static final int GYROSENSOR_REVERSE = 10;
        public static final int GYROSENSOR_SCOPE = 2;
        public static final int GYROSENSOR_VIBRATIONLEVEL = 7;

        public Options(FinalSensor finalSensor) {
        }
    }

    public final class Sensor {
        public static final int GYRO = 1;
        public static final int SYSTEM_GYRO = 2;
        public static final int UNKNOW = 0;

        public Sensor(FinalSensor finalSensor) {
        }
    }

    public final class Store {
        public static final int GYROSENSOR_CALI_ACC_ABS_DATA = 4;
        public static final int GYROSENSOR_CALI_ANGLE_DATA = 1;
        public static final int GYROSENSOR_CALI_COOR_DATA = 0;
        public static final int GYROSENSOR_CALI_PODU_DATA = 2;
        public static final int GYROSENSOR_REVERSE = 3;

        public Store(FinalSensor finalSensor) {
        }
    }
}
