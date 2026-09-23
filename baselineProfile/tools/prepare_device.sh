#!/usr/bin/env bash
# =============================================================================
# prepare_device.sh - prepares a ROOTED FYT test unit for Baseline Profile generation.
#
# Run from Git Bash (MINGW64) on the PC, with exactly one device connected over ADB:
#   cd baselineprofile/tools
#   ./prepare_device.sh            # prepare the device
#   ./prepare_device.sh --restore  # remove the su wrapper (a reboot does the same)
#
# Re-run after EVERY reboot of the head unit: the su wrapper lives in /sbin (tmpfs).
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
sh_dev() { adb shell "$@" 2>/dev/null | tr -d '\r'; }

# Returns 0 if "su root id" answers with uid=0 within 5 s (Magisk without the wrapper hangs).
su_root_works() { sh_dev "timeout 5 su root id" | grep -q "uid=0"; }

# ---------------------------------------------------------------------------
if [ "${1:-}" = "--restore" ]; then
  echo "== Restoring the original su =="
  if sh_dev "su -c 'test -e /sbin/su.orig && echo yes'" | grep -q yes; then
    sh_dev "su -c 'mv -f /sbin/su.orig /sbin/su'"
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
[ "$API" = "29" ] || warn "This setup was validated on Android 10 (API 29)"

echo "== Launcher package =="
DUMP=$(sh_dev dumpsys package $PKG)
echo "$DUMP" | grep -q "userId=1000" && ok "userId=1000 (android.uid.system)" || warn "userId is not 1000"
echo "$DUMP" | grep -E "codePath=" | head -n 2 | sed 's/^ */         /'
if echo "$DUMP" | grep -q "codePath=/data/app"; then
  warn "An update of the launcher is installed in /data/app (left over from a test run)."
  warn "Remove it with: adb uninstall $PKG   (reverts to the system version)"
fi

echo "== Root for Macrobenchmark =="
if sh_dev id | grep -q "uid=0"; then
  ok "adbd runs as root"
elif su_root_works; then
  ok "\"su root <cmd>\" works"
elif sh_dev "su -c id" | grep -q "uid=0"; then
  echo "  Magisk su detected; it does not understand \"su root <cmd>\" - installing the wrapper"
  [ -f "$WRAPPER" ] || fail "$WRAPPER not found next to this script"
  sh_dev "su -c 'test -e /sbin/magisk && echo yes'" | grep -q yes || fail "/sbin/magisk not found"

  # The wrapper must have LF line endings, whatever Git checked out on Windows.
  tr -d '\r' < "$WRAPPER" > .su_wrapper.lf
  adb push .su_wrapper.lf /data/local/tmp/su_wrapper.sh >/dev/null || fail "adb push failed"
  rm -f .su_wrapper.lf

  LABEL=$(sh_dev "su -c 'ls -Z /sbin/magisk'" | awk '{for(i=1;i<=NF;i++) if ($i ~ /^u:object_r:/) print $i}' | head -n 1)
  [ -n "$LABEL" ] || LABEL="u:object_r:system_file:s0"

  # Keep the original only once - never move the wrapper over su.orig.
  sh_dev "su -c 'mount -o rw,remount /sbin; test -e /sbin/su.orig || mv /sbin/su /sbin/su.orig; cp /data/local/tmp/su_wrapper.sh /sbin/su; chmod 755 /sbin/su; chcon $LABEL /sbin/su'"
  su_root_works && ok "Wrapper installed (label $LABEL), \"su root id\" works" || fail "Wrapper installed but \"su root id\" still fails"
  echo "  Accept the root request for \"Shell\" on the head unit screen if it appears (choose: forever)."
else
  fail "No usable root. Root the test unit with Magisk first (allow root for Shell)."
fi

echo "== Launcher as the default HOME app =="
sh_dev cmd role add-role-holder android.app.role.HOME $PKG >/dev/null
HOME_ACT=$(sh_dev cmd package resolve-activity --brief -a android.intent.action.MAIN -c android.intent.category.HOME | tail -n 1)
echo "$HOME_ACT" | grep -q "^$PKG/" && ok "HOME -> $HOME_ACT" || fail "HOME resolves to: $HOME_ACT"

echo "== System Settings package (the test closes it after each cold start) =="
ok "$(sh_dev cmd package resolve-activity --brief -a android.settings.SETTINGS | tail -n 1)"

echo "== Test conditions =="
sh_dev svc power stayon true >/dev/null   # FYT's svc prints debug noise - discarded
ok "Screen stays on"
sh_dev settings put global verifier_verify_adb_installs 0
ok "ADB install verification disabled (no Play Protect dialog during APK installs)"

echo
echo "Device ready. Generate the profile from the project root:"
echo "  ./gradlew :app:generateFytReleaseBaselineProfile \"-Pandroid.testInstrumentationRunnerArguments.androidx.benchmark.enabledRules=BaselineProfile\""
