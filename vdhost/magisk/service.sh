#!/system/bin/sh
# FYT VDHost: starts the VD host daemon as uid 1000 once the system has booted.
MODDIR=${0%/*}
RUNDIR=/dev/fyt_vdhost
LOG=$RUNDIR/server.log

until [ "$(getprop sys.boot_completed)" = "1" ]; do sleep 1; done

# uid 1000 cannot enter /data/adb (0700 root), so the APK runs from a root-owned copy in /dev,
# where nothing but root can replace it.
mkdir -p "$RUNDIR"
cp -f "$MODDIR/vdhost.apk" "$RUNDIR/vdhost.apk"
chown -R 0:0 "$RUNDIR"
chmod 0755 "$RUNDIR"
chmod 0644 "$RUNDIR/vdhost.apk"

PACKAGES=""
if [ -f "$MODDIR/packages.txt" ]; then
  for p in $(sed -e 's/#.*//' "$MODDIR/packages.txt"); do
    PACKAGES="$PACKAGES --package $p"
  done
fi
[ -z "$PACKAGES" ] && PACKAGES="--package com.android.launcher66"

CMD="CLASSPATH=$RUNDIR/vdhost.apk exec app_process /system/bin --nice-name=fyt_vdhost com.syu.vdhost.server.VdHostServer$PACKAGES"

(
  while true; do
    # Keep the log small: it lives in RAM.
    [ -f "$LOG" ] && [ "$(wc -c < "$LOG")" -gt 262144 ] && mv -f "$LOG" "$LOG.old"
    echo "--- $(date) starting" >> "$LOG"
    # The daemon has to be uid 1000 from the start: binder records the caller's uid when the
    # process opens the driver, so switching later would not help.
    su 1000 -c "$CMD" >> "$LOG" 2>&1
    echo "--- $(date) exited with $?" >> "$LOG"
    sleep 5
  done
) &
