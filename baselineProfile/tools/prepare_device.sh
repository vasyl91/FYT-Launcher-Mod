#!/usr/bin/env bash
# =============================================================================
# prepare_device.sh - prepares a test device for Baseline Profile generation: a ROOTED FYT
# unit (fyt build, a system app) or a phone (phone build; Android 13+ needs no root).
#
# Run from Git Bash (MINGW64) on the PC, with exactly one device connected over ADB:
#   cd baselineprofile/tools
#   ./prepare_device.sh            # prepare the device
#   ./prepare_device.sh --restore  # remove the su wrapper (a reboot does the same)
#
# Re-run after EVERY reboot of the device: the su wrapper lives in /sbin (tmpfs).
# =============================================================================
set -u

PKG=com.android.launcher66
WRAPPER=su_wrapper.sh
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SCRIPT_DIR" || exit 1

# Git Bash rewrites arguments starting with "/" into Windows paths (e.g. /data -> C:/Program Files/Git/data).
# Device paths must reach adb untouched.
export MSYS_NO_PATHCONV=1

ok()   { echo "  [OK]   $*"; }
warn() { echo "  [WARN] $*"; }
fail() { echo "  [FAIL] $*"; exit 1; }
# stdin from /dev/null: nothing on the device may wait for input from this terminal.
sh_dev() { adb shell "$@" </dev/null 2>/dev/null | tr -d '\r'; }

# Returns 0 if "su root id" answers with uid=0.
# Magisk's su does not understand this syntax: it opens an interactive root shell that waits for
# input. The device-side timeout alone is not enough - it kills su, but the root shell it spawned
# keeps the adb session open. So: stdin from /dev/null on the device (the shell exits at EOF),
# plus a timeout for the whole adb call on the PC as a last resort.
su_root_works() {
  timeout 15 adb shell "timeout 5 su root id </dev/null" </dev/null 2>/dev/null \
    | tr -d '\r' | grep -q "uid=0"
}

# ---------------------------------------------------------------------------
if [ "${1:-}" = "--restore" ]; then
  echo "== Restoring the original su =="
  if sh_dev "su -c 'test -e /sbin/su.orig && echo yes'" | grep -q yes; then
    sh_dev "su -c 'mount -o rw,remount /sbin; mv -f /sbin/su.orig /sbin/su'"
    ok "Original su restored"
  else
    ok "Nothing to restore (wrapper not installed)"
  fi
  exit 0
fi

echo "== Device =="
DEVICES=$(adb devices | tr -d '\r' | awk 'NR>1 && $2=="device"' | wc -l)
[ "$DEVICES" -eq 1 ] || fail "Expected exactly 1 connected device, found $DEVICES"
API=$(sh_dev getprop ro.build.version.sdk)
ok "$(sh_dev getprop ro.product.model) - API $API ($(sh_dev getprop ro.build.type))"
[ "$API" -ge 28 ] 2>/dev/null || fail "Baseline Profiles need Android 9 (API 28) or later"

echo "== Launcher package =="
DUMP=$(sh_dev dumpsys package $PKG)
# The system app's build is fyt; anything else (or none yet: Gradle installs it) gets phone.
if echo "$DUMP" | grep -q "userId=1000"; then
  FLAVOR=Fyt
  ok "userId=1000 (android.uid.system): the fyt build"
else
  FLAVOR=Phone
  ok "Not the system app: the phone build"
fi
echo "$DUMP" | grep -E "codePath=" | head -n 2 | sed 's/^ */         /'
if [ "$FLAVOR" = Fyt ] && echo "$DUMP" | grep -q "codePath=/data/app"; then
  warn "An update of the launcher is installed in /data/app (left over from a test run)."
  warn "Remove it with: adb uninstall $PKG   (reverts to the system version)"
fi

echo "== Root for Macrobenchmark =="
if sh_dev id | grep -q "uid=0"; then
  ok "adbd runs as root"
elif su_root_works; then
  ok "\"su root <cmd>\" works"
elif sh_dev "su -c id" | grep -q "uid=0"; then
  echo "  Magisk su detected; it does not understand \"su root <cmd>\""
  if ! sh_dev "su -c 'test -e /sbin/magisk && echo yes'" | grep -q yes; then
    # Magisk on Android 11+ keeps no /sbin: the wrapper cannot go there.
    if [ "$API" -ge 33 ]; then
      warn "Magisk su without /sbin: Android 13+ needs no root, so deny root to Shell in Magisk"
      warn "while generating, or Macrobenchmark may stop at 0/N on \"su root\"."
      SKIP_WRAPPER=1
    else
      fail "/sbin/magisk not found"
    fi
  fi

  if [ -z "${SKIP_WRAPPER:-}" ]; then
    echo "  Installing the wrapper"
    [ -f "$WRAPPER" ] || fail "$WRAPPER not found next to this script"
    # The wrapper must have LF line endings, whatever Git checked out on Windows.
    tr -d '\r' < "$WRAPPER" > .su_wrapper.lf
    adb push .su_wrapper.lf /data/local/tmp/su_wrapper.sh >/dev/null || fail "adb push failed"
    rm -f .su_wrapper.lf

    LABEL=$(sh_dev "su -c 'ls -Z /sbin/magisk'" | awk '{for(i=1;i<=NF;i++) if ($i ~ /^u:object_r:/) print $i}' | head -n 1)
    [ -n "$LABEL" ] || LABEL="u:object_r:system_file:s0"

    # Keep the original only once - never move the wrapper over su.orig.
    sh_dev "su -c 'mount -o rw,remount /sbin; test -e /sbin/su.orig || mv /sbin/su /sbin/su.orig; cp /data/local/tmp/su_wrapper.sh /sbin/su; chmod 755 /sbin/su; chcon $LABEL /sbin/su'"
    if su_root_works; then
      ok "Wrapper installed (label $LABEL), \"su root id\" works"
    else
      fail "Wrapper installed but \"su root id\" still fails"
    fi
    echo "  Accept the root request for \"Shell\" on the device's screen if it appears (choose: forever)."
  fi
elif [ "$API" -ge 33 ]; then
  ok "No root: Android 13+ needs none for the profile"
else
  fail "No usable root. Android 9-12 need it: root the device with Magisk (allow root for Shell)."
fi

echo "== Launcher as the default HOME app =="
sh_dev cmd role add-role-holder android.app.role.HOME $PKG >/dev/null
HOME_ACT=$(sh_dev cmd package resolve-activity --brief -a android.intent.action.MAIN -c android.intent.category.HOME | tail -n 1)
if echo "$HOME_ACT" | grep -q "^$PKG/"; then ok "HOME -> $HOME_ACT"; else fail "HOME resolves to: $HOME_ACT"; fi

echo "== System Settings package (the test closes it after each cold start) =="
ok "$(sh_dev cmd package resolve-activity --brief -a android.settings.SETTINGS | tail -n 1)"

echo "== Test conditions =="
sh_dev svc power stayon true >/dev/null   # FYT's svc prints debug noise - discarded
ok "Screen stays on"
sh_dev settings put global verifier_verify_adb_installs 0
ok "ADB install verification disabled (no Play Protect dialog during APK installs)"
sh_dev setprop persist.traced.enable 1
ok "Perfetto tracing enabled (needed by StartupBenchmark)"

echo
echo "Device ready. Generate the profile from the project root:"
echo "  ./gradlew :app:generate${FLAVOR}ReleaseBaselineProfile \"-Pandroid.testInstrumentationRunnerArguments.androidx.benchmark.enabledRules=BaselineProfile\""
