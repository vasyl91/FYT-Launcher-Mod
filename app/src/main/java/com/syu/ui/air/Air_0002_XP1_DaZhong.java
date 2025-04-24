package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.os.SystemProperties;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitMath;

@SuppressWarnings({"deprecation", "unchecked"})
public class Air_0002_XP1_DaZhong extends AirBase {
    public Air_0002_XP1_DaZhong(Context context) {
        super(context);
    }

    @Override
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override
    protected void initDrawable() {
        this.mPathNormal = "0002_xp_dazhong/air_xp1_dazhong.webp";
        this.mPathHighlight = "0002_xp_dazhong/air_xp1_dazhong_p.webp";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.save(2);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.clipRect(this.mRectEmpty);
        if (this.DATA[20] != 0) {
            c.clipRect(162.0f, 26.0f, 268.0f, 70.0f, Region.Op.UNION);
        }
        if (this.DATA[35] != 0) {
            c.clipRect(537.0f, 45.0f, 584.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[16] != 0) {
            c.clipRect(537.0f, 45.0f, 584.0f, 66.0f, Region.Op.UNION);
            c.clipRect(586.0f, 42.0f, 606.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[15] != 0) {
            c.clipRect(537.0f, 45.0f, 584.0f, 66.0f, Region.Op.UNION);
            c.clipRect(586.0f, 42.0f, 606.0f, 66.0f, Region.Op.UNION);
            c.clipRect(607.0f, 40.0f, 634.0f, 68.0f, Region.Op.UNION);
        }
        if (this.DATA[19] == 0) {
            c.clipRect(434.0f, 31.0f, 536.0f, 71.0f, Region.Op.UNION);
        }
        if (this.DATA[17] != 0) {
            c.clipRect(686.0f, 27.0f, 744.0f, 64.0f, Region.Op.UNION);
        }
        if (this.DATA[29] != 0) {
            c.clipRect(437.0f, 16.0f, 472.0f, 31.0f, Region.Op.UNION);
        }
        if (this.DATA[14] != 0) {
            c.clipRect(154.0f, 106.0f, 281.0f, 148.0f, Region.Op.UNION);
        }
        if (this.DATA[32] != 0) {
            c.clipRect(788.0f, 100.0f, 855.0f, 151.0f, Region.Op.UNION);
        }
        if (this.DATA[18] != 0) {
            c.clipRect(643.0f, 37.0f, 681.0f, 66.0f, Region.Op.UNION);
        }
        if (this.DATA[31] != 0) {
            c.clipRect(785.0f, 17.0f, 860.0f, 73.0f, Region.Op.UNION);
        }
        if (this.DATA[21] != 0) {
            c.clipRect(328.0f, 126.0f, 388.0f, 155.0f, Region.Op.UNION);
        }
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        if (this.DATA[22] != 0) {
            c.clipRect(319.0f, 25.0f, 336.0f, 49.0f, Region.Op.UNION);
        }
        if (this.DATA[23] != 0) {
            c.clipRect(340.0f, 49.0f, 367.0f, 62.0f, Region.Op.UNION);
        }
        if (this.DATA[25] != 0) {
            c.clipRect(320.0f, 64.0f, 340.0f, 88.0f, Region.Op.UNION);
        }
        int value = ToolkitMath.clamp(this.DATA[26], 0, 7);
        this.mRectTmp.set(433, 110, (value * 39) + 433, 154);
        c.clipRect(this.mRectTmp, Region.Op.UNION);
        this.mDrawableHighlight.draw(c);
        c.clipRect(this.mRectDrawable, Region.Op.XOR);
        this.mDrawableNormal.draw(c);
        int tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        this.mPaint.setTextSize(25.0f);
        int value2 = this.DATA[30];
        c.drawText(String.valueOf(value2), 98.0f, 148.0f, this.mPaint);
        int value3 = this.DATA[33];
        c.drawText(String.valueOf(value3), 986.0f, 148.0f, this.mPaint);
        this.mPaint.setTextSize(30.0f);
        int value4 = ToolkitMath.clamp(this.DATA[27], 0, 255);
        int carid = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (DataCanbus.DATA[1000] == 196659 || DataCanbus.DATA[1000] == 262195) {
            if (value4 == 0) {
                c.drawText("NO", 71.0f, 60.0f, this.mPaint);
            } else if (value4 <= 15 && value4 >= 1) {
                c.drawText("LO", 71.0f, 60.0f, this.mPaint);
            } else if (value4 <= 63 && value4 >= 49) {
                c.drawText("HI", 71.0f, 60.0f, this.mPaint);
            } else if (value4 >= 16 && value4 <= 48) {
                c.drawText(((((value4 - 16) * 5) + 160) / 10.0f) + " ℃", 71.0f, 60.0f, this.mPaint);
            }
        } else if (DataCanbus.DATA[1000] == 2424883 || DataCanbus.DATA[1000] == 2490419 || DataCanbus.DATA[1000] == 2883635 || DataCanbus.DATA[1000] == 2555955) {
            if (value4 == 0) {
                c.drawText("LO", 71.0f, 60.0f, this.mPaint);
            } else if (value4 == 254) {
                c.drawText("HI", 71.0f, 60.0f, this.mPaint);
            } else if (value4 >= 30 && value4 <= 64) {
                c.drawText((value4 / 2.0f) + " ℃", 71.0f, 60.0f, this.mPaint);
            } else {
                c.drawText("NO", 71.0f, 60.0f, this.mPaint);
            }
        } else if ((carid >= 46 && carid <= 59) || carid == 63 || carid == 67) {
            if (value4 == 0) {
                c.drawText("LO", 71.0f, 60.0f, this.mPaint);
            } else if (value4 == 254) {
                c.drawText("HI", 71.0f, 60.0f, this.mPaint);
            } else if (value4 >= 30 && value4 <= 64) {
                if (tempunit == 1) {
                    float num = (value4 * 5) / 10.0f;
                    c.drawText((((18.0f * num) + 320.0f) / 10.0f) + " ℉", 71.0f, 60.0f, this.mPaint);
                } else {
                    c.drawText(((value4 * 5) / 10.0f) + " ℃", 71.0f, 60.0f, this.mPaint);
                }
            } else {
                c.drawText("NO", 71.0f, 60.0f, this.mPaint);
            }
        } else if (value4 == 0) {
            c.drawText("LO", 71.0f, 60.0f, this.mPaint);
        } else if (value4 == 31) {
            c.drawText("HI", 71.0f, 60.0f, this.mPaint);
        } else if (value4 >= 1 && value4 <= 17) {
            if (tempunit == 1) {
                c.drawText(((value4 * 9) + 635) / 10 + " ℉", 71.0f, 60.0f, this.mPaint);
            } else {
                c.drawText((((value4 * 5) + 175) / 10.0f) + " ℃", 71.0f, 60.0f, this.mPaint);
            }
        } else {
            c.drawText("NO", 71.0f, 60.0f, this.mPaint);
        }
        int value5 = ToolkitMath.clamp(this.DATA[28], 0, 255);
        if (DataCanbus.DATA[1000] == 196659 || DataCanbus.DATA[1000] == 262195) {
            if (value5 == 0) {
                c.drawText("NO", 960.0f, 60.0f, this.mPaint);
            } else if (value5 <= 15 && value5 >= 1) {
                c.drawText("LO", 960.0f, 60.0f, this.mPaint);
            } else if (value5 <= 63 && value5 >= 49) {
                c.drawText("HI", 960.0f, 60.0f, this.mPaint);
            } else if (value5 >= 16 && value5 <= 48) {
                c.drawText(((((value5 - 16) * 5) + 160) / 10.0f) + " ℃", 960.0f, 60.0f, this.mPaint);
            }
        } else if (DataCanbus.DATA[1000] == 2424883 || DataCanbus.DATA[1000] == 2490419 || DataCanbus.DATA[1000] == 2883635 || DataCanbus.DATA[1000] == 2555955) {
            if (value5 == 0) {
                c.drawText("LO", 960.0f, 60.0f, this.mPaint);
            } else if (value5 == 254) {
                c.drawText("HI", 960.0f, 60.0f, this.mPaint);
            } else if (value5 >= 30 && value5 <= 64) {
                c.drawText((value5 / 2.0f) + " ℃", 960.0f, 60.0f, this.mPaint);
            } else {
                c.drawText("NO", 960.0f, 60.0f, this.mPaint);
            }
        } else if ((carid >= 46 && carid <= 59) || carid == 63 || carid == 67) {
            if (value5 == 0) {
                c.drawText("LO", 960.0f, 60.0f, this.mPaint);
            } else if (value5 == 254) {
                c.drawText("HI", 960.0f, 60.0f, this.mPaint);
            } else if (value5 >= 30 && value5 <= 64) {
                if (tempunit == 1) {
                    float num2 = (value5 * 5) / 10.0f;
                    c.drawText((((18.0f * num2) + 320.0f) / 10.0f) + " ℉", 960.0f, 60.0f, this.mPaint);
                } else {
                    c.drawText(((value5 * 5) / 10.0f) + " ℃", 960.0f, 60.0f, this.mPaint);
                }
            } else {
                c.drawText("NO", 960.0f, 60.0f, this.mPaint);
            }
        } else if (value5 == 0) {
            c.drawText("LO", 960.0f, 60.0f, this.mPaint);
        } else if (value5 == 31) {
            c.drawText("HI", 960.0f, 60.0f, this.mPaint);
        } else if (value5 >= 1 && value5 <= 17) {
            if (tempunit == 1) {
                c.drawText(((value5 * 9) + 635) / 10 + " ℉", 960.0f, 60.0f, this.mPaint);
            } else {
                c.drawText((((value5 * 5) + 175) / 10.0f) + " ℃", 960.0f, 60.0f, this.mPaint);
            }
        } else {
            c.drawText("NO", 960.0f, 60.0f, this.mPaint);
        }
        c.restore();
        canvas.save();
        if (LauncherApplication.getConfiguration() == 1) {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(LauncherApplication.getScreenWidth() / 1024.0f, LauncherApplication.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
    }
}
