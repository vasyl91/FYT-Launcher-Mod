/*
 * Copyright (C) 2013 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.android.gallery3d.exif;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel.MapMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseIntArray;

public class ExifInterface {
    public static final int TAG_NULL = -1;
    public static final int IFD_NULL = -1;
    public static final int DEFINITION_NULL = 0;


    public static final int TAG_IMAGE_WIDTH = defineTag(IfdId.TYPE_IFD_0, (short) 0x0100);
    public static final int TAG_IMAGE_LENGTH = defineTag(IfdId.TYPE_IFD_0, (short) 0x0101); // Image
                                                                                            // height
    public static final int TAG_BITS_PER_SAMPLE = defineTag(IfdId.TYPE_IFD_0, (short) 0x0102);
    public static final int TAG_COMPRESSION = defineTag(IfdId.TYPE_IFD_0, (short) 0x0103);
    public static final int TAG_PHOTOMETRIC_INTERPRETATION = defineTag(IfdId.TYPE_IFD_0, (short) 0x0106);
    public static final int TAG_IMAGE_DESCRIPTION = defineTag(IfdId.TYPE_IFD_0, (short) 0x010E);
    public static final int TAG_MAKE = defineTag(IfdId.TYPE_IFD_0, (short) 0x010F);
    public static final int TAG_MODEL = defineTag(IfdId.TYPE_IFD_0, (short) 0x0110);
    public static final int TAG_STRIP_OFFSETS = defineTag(IfdId.TYPE_IFD_0, (short) 0x0111);
    public static final int TAG_ORIENTATION = defineTag(IfdId.TYPE_IFD_0, (short) 0x0112);
    public static final int TAG_SAMPLES_PER_PIXEL = defineTag(IfdId.TYPE_IFD_0, (short) 0x0115);
    public static final int TAG_ROWS_PER_STRIP = defineTag(IfdId.TYPE_IFD_0, (short) 0x0116);
    public static final int TAG_STRIP_BYTE_COUNTS = defineTag(IfdId.TYPE_IFD_0, (short) 0x0117);
    public static final int TAG_X_RESOLUTION = defineTag(IfdId.TYPE_IFD_0, (short) 0x011A);
    public static final int TAG_Y_RESOLUTION = defineTag(IfdId.TYPE_IFD_0, (short) 0x011B);
    public static final int TAG_PLANAR_CONFIGURATION = defineTag(IfdId.TYPE_IFD_0, (short) 0x011C);
    public static final int TAG_RESOLUTION_UNIT = defineTag(IfdId.TYPE_IFD_0, (short) 0x0128);
    public static final int TAG_TRANSFER_FUNCTION = defineTag(IfdId.TYPE_IFD_0, (short) 0x012D);
    public static final int TAG_SOFTWARE = defineTag(IfdId.TYPE_IFD_0, (short) 0x0131);
    public static final int TAG_DATE_TIME = defineTag(IfdId.TYPE_IFD_0, (short) 0x0132);
    public static final int TAG_ARTIST = defineTag(IfdId.TYPE_IFD_0, (short) 0x013B);
    public static final int TAG_WHITE_POINT = defineTag(IfdId.TYPE_IFD_0, (short) 0x013E);
    public static final int TAG_PRIMARY_CHROMATICITIES = defineTag(IfdId.TYPE_IFD_0, (short) 0x013F);
    public static final int TAG_Y_CB_CR_COEFFICIENTS = defineTag(IfdId.TYPE_IFD_0, (short) 0x0211);
    public static final int TAG_Y_CB_CR_SUB_SAMPLING = defineTag(IfdId.TYPE_IFD_0, (short) 0x0212);
    public static final int TAG_Y_CB_CR_POSITIONING = defineTag(IfdId.TYPE_IFD_0, (short) 0x0213);
    public static final int TAG_REFERENCE_BLACK_WHITE = defineTag(IfdId.TYPE_IFD_0, (short) 0x0214);
    public static final int TAG_COPYRIGHT = defineTag(IfdId.TYPE_IFD_0, (short) 0x8298);
    public static final int TAG_EXIF_IFD = defineTag(IfdId.TYPE_IFD_0, (short) 0x8769);
    public static final int TAG_GPS_IFD = defineTag(IfdId.TYPE_IFD_0, (short) 0x8825);
    // IFD 1
    public static final int TAG_JPEG_INTERCHANGE_FORMAT = defineTag(IfdId.TYPE_IFD_1, (short) 0x0201);
    public static final int TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = defineTag(IfdId.TYPE_IFD_1, (short) 0x0202);
    // IFD Exif Tags
    public static final int TAG_EXPOSURE_TIME = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x829A);
    public static final int TAG_F_NUMBER = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x829D);
    public static final int TAG_EXPOSURE_PROGRAM = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x8822);
    public static final int TAG_SPECTRAL_SENSITIVITY = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x8824);
    public static final int TAG_ISO_SPEED_RATINGS = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x8827);
    public static final int TAG_OECF = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x8828);
    public static final int TAG_EXIF_VERSION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9000);
    public static final int TAG_DATE_TIME_ORIGINAL = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9003);
    public static final int TAG_DATE_TIME_DIGITIZED = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9004);
    public static final int TAG_COMPONENTS_CONFIGURATION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9101);
    public static final int TAG_COMPRESSED_BITS_PER_PIXEL = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9102);
    public static final int TAG_SHUTTER_SPEED_VALUE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9201);
    public static final int TAG_APERTURE_VALUE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9202);
    public static final int TAG_BRIGHTNESS_VALUE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9203);
    public static final int TAG_EXPOSURE_BIAS_VALUE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9204);
    public static final int TAG_MAX_APERTURE_VALUE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9205);
    public static final int TAG_SUBJECT_DISTANCE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9206);
    public static final int TAG_METERING_MODE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9207);
    public static final int TAG_LIGHT_SOURCE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9208);
    public static final int TAG_FLASH = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9209);
    public static final int TAG_FOCAL_LENGTH = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x920A);
    public static final int TAG_SUBJECT_AREA = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9214);
    public static final int TAG_MAKER_NOTE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x927C);
    public static final int TAG_USER_COMMENT = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9286);
    public static final int TAG_SUB_SEC_TIME = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9290);
    public static final int TAG_SUB_SEC_TIME_ORIGINAL = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9291);
    public static final int TAG_SUB_SEC_TIME_DIGITIZED = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0x9292);
    public static final int TAG_FLASHPIX_VERSION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA000);
    public static final int TAG_COLOR_SPACE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA001);
    public static final int TAG_PIXEL_X_DIMENSION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA002);
    public static final int TAG_PIXEL_Y_DIMENSION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA003);
    public static final int TAG_RELATED_SOUND_FILE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA004);
    public static final int TAG_INTEROPERABILITY_IFD = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA005);
    public static final int TAG_FLASH_ENERGY = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA20B);
    public static final int TAG_SPATIAL_FREQUENCY_RESPONSE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA20C);
    public static final int TAG_FOCAL_PLANE_X_RESOLUTION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA20E);
    public static final int TAG_FOCAL_PLANE_Y_RESOLUTION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA20F);
    public static final int TAG_FOCAL_PLANE_RESOLUTION_UNIT = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA210);
    public static final int TAG_SUBJECT_LOCATION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA214);
    public static final int TAG_EXPOSURE_INDEX = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA215);
    public static final int TAG_SENSING_METHOD = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA217);
    public static final int TAG_FILE_SOURCE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA300);
    public static final int TAG_SCENE_TYPE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA301);
    public static final int TAG_CFA_PATTERN = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA302);
    public static final int TAG_CUSTOM_RENDERED = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA401);
    public static final int TAG_EXPOSURE_MODE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA402);
    public static final int TAG_WHITE_BALANCE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA403);
    public static final int TAG_DIGITAL_ZOOM_RATIO = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA404);
    public static final int TAG_FOCAL_LENGTH_IN_35_MM_FILE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA405);
    public static final int TAG_SCENE_CAPTURE_TYPE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA406);
    public static final int TAG_GAIN_CONTROL = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA407);
    public static final int TAG_CONTRAST = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA408);
    public static final int TAG_SATURATION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA409);
    public static final int TAG_SHARPNESS = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA40A);
    public static final int TAG_DEVICE_SETTING_DESCRIPTION = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA40B);
    public static final int TAG_SUBJECT_DISTANCE_RANGE = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA40C);
    public static final int TAG_IMAGE_UNIQUE_ID = defineTag(IfdId.TYPE_IFD_EXIF, (short) 0xA420);
    // IFD GPS tags
    public static final int TAG_GPS_VERSION_ID = defineTag(IfdId.TYPE_IFD_GPS, (short) 0);
    public static final int TAG_GPS_LATITUDE_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 1);
    public static final int TAG_GPS_LATITUDE = defineTag(IfdId.TYPE_IFD_GPS, (short) 2);
    public static final int TAG_GPS_LONGITUDE_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 3);
    public static final int TAG_GPS_LONGITUDE = defineTag(IfdId.TYPE_IFD_GPS, (short) 4);
    public static final int TAG_GPS_ALTITUDE_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 5);
    public static final int TAG_GPS_ALTITUDE = defineTag(IfdId.TYPE_IFD_GPS, (short) 6);
    public static final int TAG_GPS_TIME_STAMP = defineTag(IfdId.TYPE_IFD_GPS, (short) 7);
    public static final int TAG_GPS_SATTELLITES = defineTag(IfdId.TYPE_IFD_GPS, (short) 8);
    public static final int TAG_GPS_STATUS = defineTag(IfdId.TYPE_IFD_GPS, (short) 9);
    public static final int TAG_GPS_MEASURE_MODE = defineTag(IfdId.TYPE_IFD_GPS, (short) 10);
    public static final int TAG_GPS_DOP = defineTag(IfdId.TYPE_IFD_GPS, (short) 11);
    public static final int TAG_GPS_SPEED_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 12);
    public static final int TAG_GPS_SPEED = defineTag(IfdId.TYPE_IFD_GPS, (short) 13);
    public static final int TAG_GPS_TRACK_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 14);
    public static final int TAG_GPS_TRACK = defineTag(IfdId.TYPE_IFD_GPS, (short) 15);
    public static final int TAG_GPS_IMG_DIRECTION_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 16);
    public static final int TAG_GPS_IMG_DIRECTION = defineTag(IfdId.TYPE_IFD_GPS, (short) 17);
    public static final int TAG_GPS_MAP_DATUM = defineTag(IfdId.TYPE_IFD_GPS, (short) 18);
    public static final int TAG_GPS_DEST_LATITUDE_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 19);
    public static final int TAG_GPS_DEST_LATITUDE = defineTag(IfdId.TYPE_IFD_GPS, (short) 20);
    public static final int TAG_GPS_DEST_LONGITUDE_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 21);
    public static final int TAG_GPS_DEST_LONGITUDE = defineTag(IfdId.TYPE_IFD_GPS, (short) 22);
    public static final int TAG_GPS_DEST_BEARING_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 23);
    public static final int TAG_GPS_DEST_BEARING = defineTag(IfdId.TYPE_IFD_GPS, (short) 24);
    public static final int TAG_GPS_DEST_DISTANCE_REF = defineTag(IfdId.TYPE_IFD_GPS, (short) 25);
    public static final int TAG_GPS_DEST_DISTANCE = defineTag(IfdId.TYPE_IFD_GPS, (short) 26);
    public static final int TAG_GPS_PROCESSING_METHOD = defineTag(IfdId.TYPE_IFD_GPS, (short) 27);
    public static final int TAG_GPS_AREA_INFORMATION = defineTag(IfdId.TYPE_IFD_GPS, (short) 28);
    public static final int TAG_GPS_DATE_STAMP = defineTag(IfdId.TYPE_IFD_GPS, (short) 29);
    public static final int TAG_GPS_DIFFERENTIAL = defineTag(IfdId.TYPE_IFD_GPS, (short) 30);
    // IFD Interoperability tags
    public static final int TAG_INTEROPERABILITY_INDEX = defineTag(IfdId.TYPE_IFD_INTEROPERABILITY, (short) 1);

    private static HashSet<Short> sOffsetTags = new HashSet<>();
    static {
        sOffsetTags.add(getTrueTagKey(TAG_GPS_IFD));
        sOffsetTags.add(getTrueTagKey(TAG_EXIF_IFD));
        sOffsetTags.add(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT));
        sOffsetTags.add(getTrueTagKey(TAG_INTEROPERABILITY_IFD));
        sOffsetTags.add(getTrueTagKey(TAG_STRIP_OFFSETS));
    }

    protected static HashSet<Short> sBannedDefines = new HashSet<>(sOffsetTags);
    static {
        sBannedDefines.add(getTrueTagKey(TAG_NULL));
        sBannedDefines.add(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
        sBannedDefines.add(getTrueTagKey(TAG_STRIP_BYTE_COUNTS));
    }

    public static int defineTag(int ifdId, short tagId) {
        return (tagId & 0x0000ffff) | (ifdId << 16);
    }

    public static short getTrueTagKey(int tag) {
        // Truncate
        return (short) tag;
    }

    public static int getTrueIfd(int tag) {
        return tag >>> 16;
    }

    public static interface Orientation {
        public static final short TOP_LEFT = 1;
        public static final short TOP_RIGHT = 2;
        public static final short BOTTOM_LEFT = 3;
        public static final short BOTTOM_RIGHT = 4;
        public static final short LEFT_TOP = 5;
        public static final short RIGHT_TOP = 6;
        public static final short LEFT_BOTTOM = 7;
        public static final short RIGHT_BOTTOM = 8;
    }

    public static interface YCbCrPositioning {
        public static final short CENTERED = 1;
        public static final short CO_SITED = 2;
    }

    public static interface Compression {
        public static final short UNCOMPRESSION = 1;
        public static final short JPEG = 6;
    }

    public static interface ResolutionUnit {
        public static final short INCHES = 2;
        public static final short CENTIMETERS = 3;
    }

    public static interface PhotometricInterpretation {
        public static final short RGB = 2;
        public static final short YCBCR = 6;
    }

    public static interface PlanarConfiguration {
        public static final short CHUNKY = 1;
        public static final short PLANAR = 2;
    }

    public static interface ExposureProgram {
        public static final short NOT_DEFINED = 0;
        public static final short MANUAL = 1;
        public static final short NORMAL_PROGRAM = 2;
        public static final short APERTURE_PRIORITY = 3;
        public static final short SHUTTER_PRIORITY = 4;
        public static final short CREATIVE_PROGRAM = 5;
        public static final short ACTION_PROGRAM = 6;
        public static final short PROTRAIT_MODE = 7;
        public static final short LANDSCAPE_MODE = 8;
    }

    public static interface MeteringMode {
        public static final short UNKNOWN = 0;
        public static final short AVERAGE = 1;
        public static final short CENTER_WEIGHTED_AVERAGE = 2;
        public static final short SPOT = 3;
        public static final short MULTISPOT = 4;
        public static final short PATTERN = 5;
        public static final short PARTAIL = 6;
        public static final short OTHER = 255;
    }

    public static interface Flash {
        // LSB
        public static final short DID_NOT_FIRED = 0;
        public static final short FIRED = 1;
        // 1st~2nd bits
        public static final short RETURN_NO_STROBE_RETURN_DETECTION_FUNCTION = 0 << 1;
        public static final short RETURN_STROBE_RETURN_LIGHT_NOT_DETECTED = 2 << 1;
        public static final short RETURN_STROBE_RETURN_LIGHT_DETECTED = 3 << 1;
        // 3rd~4th bits
        public static final short MODE_UNKNOWN = 0 << 3;
        public static final short MODE_COMPULSORY_FLASH_FIRING = 1 << 3;
        public static final short MODE_COMPULSORY_FLASH_SUPPRESSION = 2 << 3;
        public static final short MODE_AUTO_MODE = 3 << 3;
        // 5th bit
        public static final short FUNCTION_PRESENT = 0 << 5;
        public static final short FUNCTION_NO_FUNCTION = 1 << 5;
        // 6th bit
        public static final short RED_EYE_REDUCTION_NO_OR_UNKNOWN = 0 << 6;
        public static final short RED_EYE_REDUCTION_SUPPORT = 1 << 6;
    }

    public static interface ColorSpace {
        public static final short SRGB = 1;
        public static final short UNCALIBRATED = (short) 0xFFFF;
    }

    public static interface ExposureMode {
        public static final short AUTO_EXPOSURE = 0;
        public static final short MANUAL_EXPOSURE = 1;
        public static final short AUTO_BRACKET = 2;
    }

    public static interface WhiteBalance {
        public static final short AUTO = 0;
        public static final short MANUAL = 1;
    }

    public static interface SceneCapture {
        public static final short STANDARD = 0;
        public static final short LANDSCAPE = 1;
        public static final short PROTRAIT = 2;
        public static final short NIGHT_SCENE = 3;
    }

    public static interface ComponentsConfiguration {
        public static final short NOT_EXIST = 0;
        public static final short Y = 1;
        public static final short CB = 2;
        public static final short CR = 3;
        public static final short R = 4;
        public static final short G = 5;
        public static final short B = 6;
    }

    public static interface LightSource {
        public static final short UNKNOWN = 0;
        public static final short DAYLIGHT = 1;
        public static final short FLUORESCENT = 2;
        public static final short TUNGSTEN = 3;
        public static final short FLASH = 4;
        public static final short FINE_WEATHER = 9;
        public static final short CLOUDY_WEATHER = 10;
        public static final short SHADE = 11;
        public static final short DAYLIGHT_FLUORESCENT = 12;
        public static final short DAY_WHITE_FLUORESCENT = 13;
        public static final short COOL_WHITE_FLUORESCENT = 14;
        public static final short WHITE_FLUORESCENT = 15;
        public static final short STANDARD_LIGHT_A = 17;
        public static final short STANDARD_LIGHT_B = 18;
        public static final short STANDARD_LIGHT_C = 19;
        public static final short D55 = 20;
        public static final short D65 = 21;
        public static final short D75 = 22;
        public static final short D50 = 23;
        public static final short ISO_STUDIO_TUNGSTEN = 24;
        public static final short OTHER = 255;
    }

    public static interface SensingMethod {
        public static final short NOT_DEFINED = 1;
        public static final short ONE_CHIP_COLOR = 2;
        public static final short TWO_CHIP_COLOR = 3;
        public static final short THREE_CHIP_COLOR = 4;
        public static final short COLOR_SEQUENTIAL_AREA = 5;
        public static final short TRILINEAR = 7;
        public static final short COLOR_SEQUENTIAL_LINEAR = 8;
    }

    public static interface FileSource {
        public static final short DSC = 3;
    }

    public static interface SceneType {
        public static final short DIRECT_PHOTOGRAPHED = 1;
    }

    public static interface GainControl {
        public static final short NONE = 0;
        public static final short LOW_UP = 1;
        public static final short HIGH_UP = 2;
        public static final short LOW_DOWN = 3;
        public static final short HIGH_DOWN = 4;
    }

    public static interface Contrast {
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
        public static final short HARD = 2;
    }

    public static interface Saturation {
        public static final short NORMAL = 0;
        public static final short LOW = 1;
        public static final short HIGH = 2;
    }

    public static interface Sharpness {
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
        public static final short HARD = 2;
    }

    public static interface SubjectDistance {
        public static final short UNKNOWN = 0;
        public static final short MACRO = 1;
        public static final short CLOSE_VIEW = 2;
        public static final short DISTANT_VIEW = 3;
    }

    public static interface GpsLatitudeRef {
        public static final String NORTH = "N";
        public static final String SOUTH = "S";
    }

    public static interface GpsLongitudeRef {
        public static final String EAST = "E";
        public static final String WEST = "W";
    }

    public static interface GpsAltitudeRef {
        public static final short SEA_LEVEL = 0;
        public static final short SEA_LEVEL_NEGATIVE = 1;
    }

    public static interface GpsStatus {
        public static final String IN_PROGRESS = "A";
        public static final String INTEROPERABILITY = "V";
    }

    public static interface GpsMeasureMode {
        public static final String MODE_2_DIMENSIONAL = "2";
        public static final String MODE_3_DIMENSIONAL = "3";
    }

    public static interface GpsSpeedRef {
        public static final String KILOMETERS = "K";
        public static final String MILES = "M";
        public static final String KNOTS = "N";
    }

    public static interface GpsTrackRef {
        public static final String TRUE_DIRECTION = "T";
        public static final String MAGNETIC_DIRECTION = "M";
    }

    public static interface GpsDifferential {
        public static final short WITHOUT_DIFFERENTIAL_CORRECTION = 0;
        public static final short DIFFERENTIAL_CORRECTION_APPLIED = 1;
    }

    private static final String NULL_ARGUMENT_STRING = "Argument is null";
    private ExifData mData = new ExifData(DEFAULT_BYTE_ORDER);
    public static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;

    public ExifInterface() {
        mGPSDateStampFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public void readExif(byte[] jpeg) throws IOException {
        readExif(new ByteArrayInputStream(jpeg));
    }

    public void readExif(InputStream inStream) throws IOException {
        if (inStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        ExifData d;
        try {
            d = new ExifReader(this).read(inStream);
        } catch (ExifInvalidFormatException e) {
            throw new IOException("Invalid exif format : " + e);
        }
        mData = d;
    }

    public void readExif(String inFileName) throws FileNotFoundException, IOException {
        if (inFileName == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(inFileName));
            readExif(is);
        } catch (IOException e) {
            closeSilently(is);
            throw e;
        }
        is.close();
    }

    public void setExif(Collection<ExifTag> tags) {
        clearExif();
        setTags(tags);
    }

    public void clearExif() {
        mData = new ExifData(DEFAULT_BYTE_ORDER);
    }

    /**
     * Writes the tags from this ExifInterface object into a jpeg image, removing prior exif tags.
     *
     * @param jpeg a byte array containing a jpeg compressed image.
     * @param exifOutStream an OutputStream to which the jpeg image with added exif tags will be
     *        written.
     * @throws IOException
     */
    public void writeExif(byte[] jpeg, OutputStream exifOutStream) throws IOException {
        if (jpeg == null || exifOutStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream s = getExifWriterStream(exifOutStream);
        s.write(jpeg, 0, jpeg.length);
        s.flush();
    }

    public void writeExif(Bitmap bmap, OutputStream exifOutStream) throws IOException {
        if (bmap == null || exifOutStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream s = getExifWriterStream(exifOutStream);
        bmap.compress(Bitmap.CompressFormat.JPEG, 90, s);
        s.flush();
    }

    public void writeExif(InputStream jpegStream, OutputStream exifOutStream) throws IOException {
        if (jpegStream == null || exifOutStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream s = getExifWriterStream(exifOutStream);
        doExifStreamIO(jpegStream, s);
        s.flush();
    }

    public void writeExif(byte[] jpeg, String exifOutFileName) throws IOException {
        if (jpeg == null || exifOutFileName == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream s = null;
        try {
            s = getExifWriterStream(exifOutFileName);
            s.write(jpeg, 0, jpeg.length);
            s.flush();
        } catch (IOException e) {
            closeSilently(s);
            throw e;
        }
        s.close();
    }

    public void writeExif(Bitmap bmap, String exifOutFileName) throws IOException {
        if (bmap == null || exifOutFileName == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream s = null;
        try {
            s = getExifWriterStream(exifOutFileName);
            bmap.compress(Bitmap.CompressFormat.JPEG, 90, s);
            s.flush();
        } catch (IOException e) {
            closeSilently(s);
            throw e;
        }
        s.close();
    }

    public void writeExif(InputStream jpegStream, String exifOutFileName) throws IOException {
        if (jpegStream == null || exifOutFileName == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream s = null;
        try {
            s = getExifWriterStream(exifOutFileName);
            doExifStreamIO(jpegStream, s);
            s.flush();
        } catch (IOException e) {
            closeSilently(s);
            throw e;
        }
        s.close();
    }

    public void writeExif(String jpegFileName, String exifOutFileName) throws IOException {
        if (jpegFileName == null || exifOutFileName == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        InputStream is = null;
        try {
            is = new FileInputStream(jpegFileName);
            writeExif(is, exifOutFileName);
        } catch (IOException e) {
            closeSilently(is);
            throw e;
        }
        is.close();
    }

    public OutputStream getExifWriterStream(OutputStream outStream) {
        if (outStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        ExifOutputStream eos = new ExifOutputStream(outStream, this);
        eos.setExifData(mData);
        return eos;
    }

    public OutputStream getExifWriterStream(String exifOutFileName) throws FileNotFoundException {
        if (exifOutFileName == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream out = null;
        try {
            out = new FileOutputStream(exifOutFileName);
        } catch (FileNotFoundException e) {
            closeSilently(out);
            throw e;
        }
        return getExifWriterStream(out);
    }

    public boolean rewriteExif(String filename, Collection<ExifTag> tags) throws IOException {
        RandomAccessFile file = null;
        InputStream is = null;
        boolean ret;
        try {
            File temp = new File(filename);
            is = new BufferedInputStream(new FileInputStream(temp));

            // Parse beginning of APP1 in exif to find size of exif header.
            ExifParser parser = null;
            try {
                parser = ExifParser.parse(is, this);
            } catch (ExifInvalidFormatException e) {
                throw new IOException("Invalid exif format : ", e);
            }
            long exifSize = parser.getOffsetToExifEndFromSOF();

            // Free up resources
            is.close();
            is = null;

            // Open file for memory mapping.
            file = new RandomAccessFile(temp, "rw");
            long fileLength = file.length();
            if (fileLength < exifSize) {
                throw new IOException("Filesize changed during operation");
            }

            // Map only exif header into memory.
            ByteBuffer buf = file.getChannel().map(MapMode.READ_WRITE, 0, exifSize);

            // Attempt to overwrite tag values without changing lengths (avoids
            // file copy).
            ret = rewriteExif(buf, tags);
        } catch (IOException e) {
            closeSilently(file);
            throw e;
        } finally {
            closeSilently(is);
        }
        file.close();
        return ret;
    }

    public boolean rewriteExif(ByteBuffer buf, Collection<ExifTag> tags) throws IOException {
        ExifModifier mod;
        try {
            mod = new ExifModifier(buf, this);
            for (ExifTag t : tags) {
                mod.modifyTag(t);
            }
            return mod.commit();
        } catch (ExifInvalidFormatException e) {
            throw new IOException("Invalid exif format : " + e);
        }
    }

    public void forceRewriteExif(String filename, Collection<ExifTag> tags) throws IOException {
        // Attempt in-place write
        if (!rewriteExif(filename, tags)) {
            // Fall back to doing a copy
            ExifData tempData = mData;
            mData = new ExifData(DEFAULT_BYTE_ORDER);
            FileInputStream is = null;
            ByteArrayOutputStream bytes;
            try {
                is = new FileInputStream(filename);
                bytes = new ByteArrayOutputStream();
                doExifStreamIO(is, bytes);
                byte[] imageBytes = bytes.toByteArray();
                readExif(imageBytes);
                setTags(tags);
                writeExif(imageBytes, filename);
            } catch (IOException e) {
                closeSilently(is);
                throw e;
            } finally {
                is.close();
                // Prevent clobbering of mData
                mData = tempData;
            }
        }
    }

    public void forceRewriteExif(String filename) throws IOException {
        forceRewriteExif(filename, getAllTags());
    }

    public List<ExifTag> getAllTags() {
        return mData.getAllTags();
    }

    public List<ExifTag> getTagsForTagId(short tagId) {
        return mData.getAllTagsForTagId(tagId);
    }

    public List<ExifTag> getTagsForIfdId(int ifdId) {
        return mData.getAllTagsForIfd(ifdId);
    }

    public ExifTag getTag(int tagId, int ifdId) {
        if (!ExifTag.isValidIfd(ifdId)) {
            return null;
        }
        return mData.getTag(getTrueTagKey(tagId), ifdId);
    }

    public ExifTag getTag(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTag(tagId, ifdId);
    }

    public Object getTagValue(int tagId, int ifdId) {
        ExifTag t = getTag(tagId, ifdId);
        return (t == null) ? null : t.getValue();
    }

    public Object getTagValue(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagValue(tagId, ifdId);
    }

    public String getTagStringValue(int tagId, int ifdId) {
        ExifTag t = getTag(tagId, ifdId);
        if (t == null) {
            return null;
        }
        return t.getValueAsString();
    }

    public String getTagStringValue(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagStringValue(tagId, ifdId);
    }

    public Long getTagLongValue(int tagId, int ifdId) {
        long[] l = getTagLongValues(tagId, ifdId);
        if (l == null || l.length <= 0) {
            return null;
        }
        return l[0];
    }

    public Long getTagLongValue(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagLongValue(tagId, ifdId);
    }

    public Integer getTagIntValue(int tagId, int ifdId) {
        int[] l = getTagIntValues(tagId, ifdId);
        if (l == null || l.length <= 0) {
            return null;
        }
        return l[0];
    }

    public Integer getTagIntValue(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagIntValue(tagId, ifdId);
    }

    public Byte getTagByteValue(int tagId, int ifdId) {
        byte[] l = getTagByteValues(tagId, ifdId);
        if (l == null || l.length <= 0) {
            return null;
        }
        return l[0];
    }

    public Byte getTagByteValue(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagByteValue(tagId, ifdId);
    }

    public Rational getTagRationalValue(int tagId, int ifdId) {
        Rational[] l = getTagRationalValues(tagId, ifdId);
        if (l == null || l.length == 0) {
            return null;
        }
        return new Rational(l[0]);
    }

    public Rational getTagRationalValue(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagRationalValue(tagId, ifdId);
    }

    public long[] getTagLongValues(int tagId, int ifdId) {
        ExifTag t = getTag(tagId, ifdId);
        if (t == null) {
            return null;
        }
        return t.getValueAsLongs();
    }

    public long[] getTagLongValues(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagLongValues(tagId, ifdId);
    }

    public int[] getTagIntValues(int tagId, int ifdId) {
        ExifTag t = getTag(tagId, ifdId);
        if (t == null) {
            return null;
        }
        return t.getValueAsInts();
    }

    public int[] getTagIntValues(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagIntValues(tagId, ifdId);
    }

    public byte[] getTagByteValues(int tagId, int ifdId) {
        ExifTag t = getTag(tagId, ifdId);
        if (t == null) {
            return null;
        }
        return t.getValueAsBytes();
    }

    public byte[] getTagByteValues(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagByteValues(tagId, ifdId);
    }

    public Rational[] getTagRationalValues(int tagId, int ifdId) {
        ExifTag t = getTag(tagId, ifdId);
        if (t == null) {
            return null;
        }
        return t.getValueAsRationals();
    }

    public Rational[] getTagRationalValues(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return getTagRationalValues(tagId, ifdId);
    }

    public boolean isTagCountDefined(int tagId) {
        int info = getTagInfo().get(tagId);
        // No value in info can be zero, as all tags have a non-zero type
        if (info == 0) {
            return false;
        }
        return getComponentCountFromInfo(info) != ExifTag.SIZE_UNDEFINED;
    }

    public int getDefinedTagCount(int tagId) {
        int info = getTagInfo().get(tagId);
        if (info == 0) {
            return ExifTag.SIZE_UNDEFINED;
        }
        return getComponentCountFromInfo(info);
    }

    public int getActualTagCount(int tagId, int ifdId) {
        ExifTag t = getTag(tagId, ifdId);
        if (t == null) {
            return 0;
        }
        return t.getComponentCount();
    }

    public int getDefinedTagDefaultIfd(int tagId) {
        int info = getTagInfo().get(tagId);
        if (info == DEFINITION_NULL) {
            return IFD_NULL;
        }
        return getTrueIfd(tagId);
    }

    public short getDefinedTagType(int tagId) {
        int info = getTagInfo().get(tagId);
        if (info == 0) {
            return -1;
        }
        return getTypeFromInfo(info);
    }

    protected static boolean isOffsetTag(short tag) {
        return sOffsetTags.contains(tag);
    }

    public ExifTag buildTag(int tagId, int ifdId, Object val) {
        int info = getTagInfo().get(tagId);
        if (info == 0 || val == null) {
            return null;
        }
        short type = getTypeFromInfo(info);
        int definedCount = getComponentCountFromInfo(info);
        boolean hasDefinedCount = (definedCount != ExifTag.SIZE_UNDEFINED);
        if (!ExifInterface.isIfdAllowed(info, ifdId)) {
            return null;
        }
        ExifTag t = new ExifTag(getTrueTagKey(tagId), type, definedCount, ifdId, hasDefinedCount);
        if (!t.setValue(val)) {
            return null;
        }
        return t;
    }

    public ExifTag buildTag(int tagId, Object val) {
        int ifdId = getTrueIfd(tagId);
        return buildTag(tagId, ifdId, val);
    }

    protected ExifTag buildUninitializedTag(int tagId) {
        int info = getTagInfo().get(tagId);
        if (info == 0) {
            return null;
        }
        short type = getTypeFromInfo(info);
        int definedCount = getComponentCountFromInfo(info);
        boolean hasDefinedCount = (definedCount != ExifTag.SIZE_UNDEFINED);
        int ifdId = getTrueIfd(tagId);
        return new ExifTag(getTrueTagKey(tagId), type, definedCount, ifdId, hasDefinedCount);
    }

    public boolean setTagValue(int tagId, int ifdId, Object val) {
        ExifTag t = getTag(tagId, ifdId);
        if (t == null) {
            return false;
        }
        return t.setValue(val);
    }

    public boolean setTagValue(int tagId, Object val) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        return setTagValue(tagId, ifdId, val);
    }

    public ExifTag setTag(ExifTag tag) {
        return mData.addTag(tag);
    }

    public void setTags(Collection<ExifTag> tags) {
        for (ExifTag t : tags) {
            setTag(t);
        }
    }

    public void deleteTag(int tagId, int ifdId) {
        mData.removeTag(getTrueTagKey(tagId), ifdId);
    }

    public void deleteTag(int tagId) {
        int ifdId = getDefinedTagDefaultIfd(tagId);
        deleteTag(tagId, ifdId);
    }

    public int setTagDefinition(short tagId, int defaultIfd, short tagType, short defaultComponentCount,
            int[] allowedIfds) {
        if (sBannedDefines.contains(tagId)) {
            return TAG_NULL;
        }
        if (ExifTag.isValidType(tagType) && ExifTag.isValidIfd(defaultIfd)) {
            int tagDef = defineTag(defaultIfd, tagId);
            if (tagDef == TAG_NULL) {
                return TAG_NULL;
            }
            int[] otherDefs = getTagDefinitionsForTagId(tagId);
            SparseIntArray infos = getTagInfo();
            // Make sure defaultIfd is in allowedIfds
            boolean defaultCheck = false;
            for (int i : allowedIfds) {
                if (defaultIfd == i) {
                    defaultCheck = true;
                }
                if (!ExifTag.isValidIfd(i)) {
                    return TAG_NULL;
                }
            }
            if (!defaultCheck) {
                return TAG_NULL;
            }

            int ifdFlags = getFlagsFromAllowedIfds(allowedIfds);
            // Make sure no identical tags can exist in allowedIfds
            if (otherDefs != null) {
                for (int def : otherDefs) {
                    int tagInfo = infos.get(def);
                    int allowedFlags = getAllowedIfdFlagsFromInfo(tagInfo);
                    if ((ifdFlags & allowedFlags) != 0) {
                        return TAG_NULL;
                    }
                }
            }
            getTagInfo().put(tagDef, ifdFlags << 24 | (tagType << 16) | defaultComponentCount);
            return tagDef;
        }
        return TAG_NULL;
    }

    protected int getTagDefinition(short tagId, int defaultIfd) {
        return getTagInfo().get(defineTag(defaultIfd, tagId));
    }

    protected int[] getTagDefinitionsForTagId(short tagId) {
        int[] ifds = IfdData.getIfds();
        int[] defs = new int[ifds.length];
        int counter = 0;
        SparseIntArray infos = getTagInfo();
        for (int i : ifds) {
            int def = defineTag(i, tagId);
            if (infos.get(def) != DEFINITION_NULL) {
                defs[counter++] = def;
            }
        }
        if (counter == 0) {
            return new int[0];
        }

        return Arrays.copyOfRange(defs, 0, counter);
    }

    protected int getTagDefinitionForTag(ExifTag tag) {
        short type = tag.getDataType();
        int count = tag.getComponentCount();
        int ifd = tag.getIfd();
        return getTagDefinitionForTag(tag.getTagId(), type, count, ifd);
    }

    protected int getTagDefinitionForTag(short tagId, short type, int count, int ifd) {
        int[] defs = getTagDefinitionsForTagId(tagId);
        if (defs == null) {
            return TAG_NULL;
        }
        SparseIntArray infos = getTagInfo();
        int ret = TAG_NULL;
        for (int i : defs) {
            int info = infos.get(i);
            short def_type = getTypeFromInfo(info);
            int def_count = getComponentCountFromInfo(info);
            int[] def_ifds = getAllowedIfdsFromInfo(info);
            boolean valid_ifd = false;
            for (int j : def_ifds) {
                if (j == ifd) {
                    valid_ifd = true;
                    break;
                }
            }
            if (valid_ifd && type == def_type && (count == def_count || def_count == ExifTag.SIZE_UNDEFINED)) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    public void removeTagDefinition(int tagId) {
        getTagInfo().delete(tagId);
    }

    public void resetTagDefinitions() {
        mTagInfo = null;
    }

    public Bitmap getThumbnailBitmap() {
        if (mData.hasCompressedThumbnail()) {
            byte[] thumb = mData.getCompressedThumbnail();
            return BitmapFactory.decodeByteArray(thumb, 0, thumb.length);
        } else if (mData.hasUncompressedStrip()) {
            // TODO: implement uncompressed
        }
        return null;
    }

    public byte[] getThumbnailBytes() {
        if (mData.hasCompressedThumbnail()) {
            return mData.getCompressedThumbnail();
        } else if (mData.hasUncompressedStrip()) {
            // TODO: implement this
        }
        return null;
    }

    public byte[] getThumbnail() {
        return mData.getCompressedThumbnail();
    }

    public boolean isThumbnailCompressed() {
        return mData.hasCompressedThumbnail();
    }

    public boolean hasThumbnail() {
        // TODO: add back in uncompressed strip
        return mData.hasCompressedThumbnail();
    }

    public boolean setCompressedThumbnail(byte[] thumb) {
        mData.clearThumbnailAndStrips();
        mData.setCompressedThumbnail(thumb);
        return true;
    }

    public boolean setCompressedThumbnail(Bitmap thumb) {
        ByteArrayOutputStream thumbnail = new ByteArrayOutputStream();
        if (!thumb.compress(Bitmap.CompressFormat.JPEG, 90, thumbnail)) {
            return false;
        }
        return setCompressedThumbnail(thumbnail.toByteArray());
    }

    public void removeCompressedThumbnail() {
        mData.setCompressedThumbnail(null);
    }

    public String getUserComment() {
        return mData.getUserComment();
    }

    public static short getOrientationValueForRotation(int degrees) {
        degrees %= 360;
        if (degrees < 0) {
            degrees += 360;
        }
        if (degrees < 90) {
            return Orientation.TOP_LEFT; // 0 degrees
        } else if (degrees < 180) {
            return Orientation.RIGHT_TOP; // 90 degrees cw
        } else if (degrees < 270) {
            return Orientation.BOTTOM_LEFT; // 180 degrees
        } else {
            return Orientation.RIGHT_BOTTOM; // 270 degrees cw
        }
    }

    public static int getRotationForOrientationValue(short orientation) {
        return switch (orientation) {
            case Orientation.TOP_LEFT -> 0;
            case Orientation.RIGHT_TOP -> 90;
            case Orientation.BOTTOM_LEFT -> 180;
            case Orientation.RIGHT_BOTTOM -> 270;
            default -> 0;
        };
    }

    public static double convertLatOrLongToDouble(Rational[] coordinate, String reference) {
        try {
            double degrees = coordinate[0].toDouble();
            double minutes = coordinate[1].toDouble();
            double seconds = coordinate[2].toDouble();
            double result = degrees + minutes / 60.0 + seconds / 3600.0;
            if ((reference.equals("S") || reference.equals("W"))) {
                return -result;
            }
            return result;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    public double[] getLatLongAsDoubles() {
        Rational[] latitude = getTagRationalValues(TAG_GPS_LATITUDE);
        String latitudeRef = getTagStringValue(TAG_GPS_LATITUDE_REF);
        Rational[] longitude = getTagRationalValues(TAG_GPS_LONGITUDE);
        String longitudeRef = getTagStringValue(TAG_GPS_LONGITUDE_REF);
        if (latitude == null || longitude == null || latitudeRef == null || longitudeRef == null || latitude.length < 3
                || longitude.length < 3) {
            return new double[0];
        }
        double[] latLon = new double[2];
        latLon[0] = convertLatOrLongToDouble(latitude, latitudeRef);
        latLon[1] = convertLatOrLongToDouble(longitude, longitudeRef);
        return latLon;
    }

    private static final String GPS_DATE_FORMAT_STR = "yyyy:MM:dd";
    private static final String DATETIME_FORMAT_STR = "yyyy:MM:dd kk:mm:ss";
    private final DateFormat mDateTimeStampFormat = new SimpleDateFormat(DATETIME_FORMAT_STR);
    private final DateFormat mGPSDateStampFormat = new SimpleDateFormat(GPS_DATE_FORMAT_STR);
    private final Calendar mGPSTimeStampCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    public boolean addDateTimeStampTag(int tagId, long timestamp, TimeZone timezone) {
        if (tagId == TAG_DATE_TIME || tagId == TAG_DATE_TIME_DIGITIZED || tagId == TAG_DATE_TIME_ORIGINAL) {
            mDateTimeStampFormat.setTimeZone(timezone);
            ExifTag t = buildTag(tagId, mDateTimeStampFormat.format(timestamp));
            if (t == null) {
                return false;
            }
            setTag(t);
        } else {
            return false;
        }
        return true;
    }

    public boolean addGpsTags(double latitude, double longitude) {
        ExifTag latTag = buildTag(TAG_GPS_LATITUDE, toExifLatLong(latitude));
        ExifTag longTag = buildTag(TAG_GPS_LONGITUDE, toExifLatLong(longitude));
        ExifTag latRefTag =
                buildTag(TAG_GPS_LATITUDE_REF, latitude >= 0
                        ? ExifInterface.GpsLatitudeRef.NORTH
                        : ExifInterface.GpsLatitudeRef.SOUTH);
        ExifTag longRefTag =
                buildTag(TAG_GPS_LONGITUDE_REF, longitude >= 0
                        ? ExifInterface.GpsLongitudeRef.EAST
                        : ExifInterface.GpsLongitudeRef.WEST);
        if (latTag == null || longTag == null || latRefTag == null || longRefTag == null) {
            return false;
        }
        setTag(latTag);
        setTag(longTag);
        setTag(latRefTag);
        setTag(longRefTag);
        return true;
    }

    public boolean addGpsDateTimeStampTag(long timestamp) {
        ExifTag t = buildTag(TAG_GPS_DATE_STAMP, mGPSDateStampFormat.format(timestamp));
        if (t == null) {
            return false;
        }
        setTag(t);
        mGPSTimeStampCalendar.setTimeInMillis(timestamp);
        t =
                buildTag(TAG_GPS_TIME_STAMP,
                        new Rational[] {new Rational(mGPSTimeStampCalendar.get(Calendar.HOUR_OF_DAY), 1),
                                new Rational(mGPSTimeStampCalendar.get(Calendar.MINUTE), 1),
                                new Rational(mGPSTimeStampCalendar.get(Calendar.SECOND), 1)});
        if (t == null) {
            return false;
        }
        setTag(t);
        return true;
    }

    private static Rational[] toExifLatLong(double value) {
        // convert to the format dd/1 mm/1 ssss/100
        value = Math.abs(value);
        int degrees = (int) value;
        value = (value - degrees) * 60;
        int minutes = (int) value;
        value = (value - minutes) * 6000;
        int seconds = (int) value;
        return new Rational[] {new Rational(degrees, 1), new Rational(minutes, 1), new Rational(seconds, 100)};
    }

    private void doExifStreamIO(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[1024];
        int ret = is.read(buf, 0, 1024);
        while (ret != -1) {
            os.write(buf, 0, ret);
            ret = is.read(buf, 0, 1024);
        }
    }

    protected static void closeSilently(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (Throwable e) {
                // ignored
            }
        }
    }

    private SparseIntArray mTagInfo = null;

    protected SparseIntArray getTagInfo() {
        if (mTagInfo == null) {
            mTagInfo = new SparseIntArray();
            initTagInfo();
        }
        return mTagInfo;
    }

    private void initTagInfo() {

        int[] ifdAllowedIfds = {IfdId.TYPE_IFD_0, IfdId.TYPE_IFD_1};
        int ifdFlags = getFlagsFromAllowedIfds(ifdAllowedIfds) << 24;
        mTagInfo.put(ExifInterface.TAG_MAKE, ifdFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_IMAGE_WIDTH, ifdFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_IMAGE_LENGTH, ifdFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_BITS_PER_SAMPLE, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 3);
        mTagInfo.put(ExifInterface.TAG_COMPRESSION, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_ORIENTATION, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SAMPLES_PER_PIXEL, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_PLANAR_CONFIGURATION, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_Y_CB_CR_POSITIONING, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_X_RESOLUTION, ifdFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_Y_RESOLUTION, ifdFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_RESOLUTION_UNIT, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_STRIP_OFFSETS, ifdFlags | ExifTag.TYPE_UNSIGNED_LONG << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_ROWS_PER_STRIP, ifdFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_STRIP_BYTE_COUNTS, ifdFlags | ExifTag.TYPE_UNSIGNED_LONG << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_TRANSFER_FUNCTION, ifdFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 3 * 256);
        mTagInfo.put(ExifInterface.TAG_WHITE_POINT, ifdFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_PRIMARY_CHROMATICITIES, ifdFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 6);
        mTagInfo.put(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, ifdFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 3);
        mTagInfo.put(ExifInterface.TAG_REFERENCE_BLACK_WHITE, ifdFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 6);
        mTagInfo.put(ExifInterface.TAG_DATE_TIME, ifdFlags | ExifTag.TYPE_ASCII << 16 | 20);
        mTagInfo.put(ExifInterface.TAG_IMAGE_DESCRIPTION, ifdFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_MAKE, ifdFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_MODEL, ifdFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_SOFTWARE, ifdFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_ARTIST, ifdFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_COPYRIGHT, ifdFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_EXIF_IFD, ifdFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_IFD, ifdFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        // IFD1 tags
        int[] ifd1AllowedIfds = {IfdId.TYPE_IFD_1};
        int ifdFlags1 = getFlagsFromAllowedIfds(ifd1AllowedIfds) << 24;
        mTagInfo.put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ifdFlags1 | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ifdFlags1 | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        // Exif tags
        int[] exifAllowedIfds = {IfdId.TYPE_IFD_EXIF};
        int exifFlags = getFlagsFromAllowedIfds(exifAllowedIfds) << 24;
        mTagInfo.put(ExifInterface.TAG_EXIF_VERSION, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | 4);
        mTagInfo.put(ExifInterface.TAG_FLASHPIX_VERSION, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | 4);
        mTagInfo.put(ExifInterface.TAG_COLOR_SPACE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_COMPONENTS_CONFIGURATION, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | 4);
        mTagInfo.put(ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_PIXEL_X_DIMENSION, exifFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_PIXEL_Y_DIMENSION, exifFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_MAKER_NOTE, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_USER_COMMENT, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_RELATED_SOUND_FILE, exifFlags | ExifTag.TYPE_ASCII << 16 | 13);
        mTagInfo.put(ExifInterface.TAG_DATE_TIME_ORIGINAL, exifFlags | ExifTag.TYPE_ASCII << 16 | 20);
        mTagInfo.put(ExifInterface.TAG_DATE_TIME_DIGITIZED, exifFlags | ExifTag.TYPE_ASCII << 16 | 20);
        mTagInfo.put(ExifInterface.TAG_SUB_SEC_TIME, exifFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, exifFlags | ExifTag.TYPE_ASCII << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_SUB_SEC_TIME_DIGITIZED, exifFlags | ExifTag.TYPE_ASCII << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_IMAGE_UNIQUE_ID, exifFlags | ExifTag.TYPE_ASCII << 16 | 33);
        mTagInfo.put(ExifInterface.TAG_EXPOSURE_TIME, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_F_NUMBER, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_EXPOSURE_PROGRAM, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SPECTRAL_SENSITIVITY, exifFlags | ExifTag.TYPE_ASCII << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_ISO_SPEED_RATINGS, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_OECF, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_SHUTTER_SPEED_VALUE, exifFlags | ExifTag.TYPE_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_APERTURE_VALUE, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_BRIGHTNESS_VALUE, exifFlags | ExifTag.TYPE_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, exifFlags | ExifTag.TYPE_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_MAX_APERTURE_VALUE, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SUBJECT_DISTANCE, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_METERING_MODE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_LIGHT_SOURCE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_FLASH, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_FOCAL_LENGTH, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SUBJECT_AREA, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_FLASH_ENERGY, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, exifFlags | ExifTag.TYPE_UNDEFINED << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SUBJECT_LOCATION, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_EXPOSURE_INDEX, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SENSING_METHOD, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_FILE_SOURCE, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SCENE_TYPE, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_CFA_PATTERN, exifFlags | ExifTag.TYPE_UNDEFINED << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_CUSTOM_RENDERED, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_EXPOSURE_MODE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_WHITE_BALANCE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_DIGITAL_ZOOM_RATIO, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_FOCAL_LENGTH_IN_35_MM_FILE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SCENE_CAPTURE_TYPE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GAIN_CONTROL, exifFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_CONTRAST, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SATURATION, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_SHARPNESS, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, exifFlags | ExifTag.TYPE_UNDEFINED << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, exifFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_INTEROPERABILITY_IFD, exifFlags | ExifTag.TYPE_UNSIGNED_LONG << 16 | 1);
        // GPS tag
        int[] gpsAllowedIfds = {IfdId.TYPE_IFD_GPS};
        int gpsFlags = getFlagsFromAllowedIfds(gpsAllowedIfds) << 24;
        mTagInfo.put(ExifInterface.TAG_GPS_VERSION_ID, gpsFlags | ExifTag.TYPE_UNSIGNED_BYTE << 16 | 4);
        mTagInfo.put(ExifInterface.TAG_GPS_LATITUDE_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_LONGITUDE_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_LATITUDE, gpsFlags | ExifTag.TYPE_RATIONAL << 16 | 3);
        mTagInfo.put(ExifInterface.TAG_GPS_LONGITUDE, gpsFlags | ExifTag.TYPE_RATIONAL << 16 | 3);
        mTagInfo.put(ExifInterface.TAG_GPS_ALTITUDE_REF, gpsFlags | ExifTag.TYPE_UNSIGNED_BYTE << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_ALTITUDE, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_TIME_STAMP, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 3);
        mTagInfo.put(ExifInterface.TAG_GPS_SATTELLITES, gpsFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_GPS_STATUS, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_MEASURE_MODE, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_DOP, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_SPEED_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_SPEED, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_TRACK_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_TRACK, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_IMG_DIRECTION, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_MAP_DATUM, gpsFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_GPS_DEST_LATITUDE_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_DEST_LATITUDE, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_DEST_BEARING_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_DEST_BEARING, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, gpsFlags | ExifTag.TYPE_ASCII << 16 | 2);
        mTagInfo.put(ExifInterface.TAG_GPS_DEST_DISTANCE, gpsFlags | ExifTag.TYPE_UNSIGNED_RATIONAL << 16 | 1);
        mTagInfo.put(ExifInterface.TAG_GPS_PROCESSING_METHOD, gpsFlags | ExifTag.TYPE_UNDEFINED << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_GPS_AREA_INFORMATION, gpsFlags | ExifTag.TYPE_UNDEFINED << 16
                | ExifTag.SIZE_UNDEFINED);
        mTagInfo.put(ExifInterface.TAG_GPS_DATE_STAMP, gpsFlags | ExifTag.TYPE_ASCII << 16 | 11);
        mTagInfo.put(ExifInterface.TAG_GPS_DIFFERENTIAL, gpsFlags | ExifTag.TYPE_UNSIGNED_SHORT << 16 | 11);
        // Interoperability tag
        int[] interopAllowedIfds = {IfdId.TYPE_IFD_INTEROPERABILITY};
        int interopFlags = getFlagsFromAllowedIfds(interopAllowedIfds) << 24;
        mTagInfo.put(TAG_INTEROPERABILITY_INDEX, interopFlags | ExifTag.TYPE_ASCII << 16 | ExifTag.SIZE_UNDEFINED);
    }

    protected static int getAllowedIfdFlagsFromInfo(int info) {
        return info >>> 24;
    }

    protected static int[] getAllowedIfdsFromInfo(int info) {
        int ifdFlags = getAllowedIfdFlagsFromInfo(info);
        int[] ifds = IfdData.getIfds();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < IfdId.TYPE_IFD_COUNT; i++) {
            int flag = (ifdFlags >> i) & 1;
            if (flag == 1) {
                l.add(ifds[i]);
            }
        }
        if (l.size() <= 0) {
            return null;
        }
        int[] ret = new int[l.size()];
        int j = 0;
        for (int i : l) {
            ret[j++] = i;
        }
        return ret;
    }

    protected static boolean isIfdAllowed(int info, int ifd) {
        int[] ifds = IfdData.getIfds();
        int ifdFlags = getAllowedIfdFlagsFromInfo(info);
        for (int i = 0; i < ifds.length; i++) {
            if (ifd == ifds[i] && ((ifdFlags >> i) & 1) == 1) {
                return true;
            }
        }
        return false;
    }

    protected static int getFlagsFromAllowedIfds(int[] allowedIfds) {
        if (allowedIfds == null || allowedIfds.length == 0) {
            return 0;
        }
        int flags = 0;
        int[] ifds = IfdData.getIfds();
        for (int i = 0; i < IfdId.TYPE_IFD_COUNT; i++) {
            for (int j : allowedIfds) {
                if (ifds[i] == j) {
                    flags |= 1 << i;
                    break;
                }
            }
        }
        return flags;
    }

    protected static short getTypeFromInfo(int info) {
        return (short) ((info >> 16) & 0x0ff);
    }

    protected static int getComponentCountFromInfo(int info) {
        return info & 0x0ffff;
    }

}
