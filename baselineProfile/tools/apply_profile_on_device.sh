#!/system/bin/sh
# =============================================================================
# apply_profile_on_device.sh - DEV UNIT ONLY (needs root). Manually applies the Baseline
# Profile after installing a new APK, doing by hand what BaselineProfileCompiler does
# automatically on user units. Useful to measure / verify without waiting 90 s.
#
#   adb push apply_profile_on_device.sh /data/local/tmp/
#   adb shell su -c sh /data/local/tmp/apply_profile_on_device.sh
# =============================================================================
PKG=com.android.launcher66

# 1) Drop profiles and compiled code of the previous APK
cmd package compile --reset $PKG

# 2) Force-write baseline.prof (assets/dexopt in the APK) into the ART profile
am broadcast -a androidx.profileinstaller.action.INSTALL_PROFILE \
  -n $PKG/androidx.profileinstaller.ProfileInstallReceiver
sleep 5

# 3) AOT-compile what the profile lists
cmd package compile -m speed-profile -f $PKG

# 4) Restart the launcher so it uses the new code
am force-stop $PKG
am start -a android.intent.action.MAIN -c android.intent.category.HOME

# 5) Verify - expected: [status=speed-profile] (or speed)
dumpsys package dexopt | grep -A 3 "\[$PKG\]"
