#!/system/bin/sh
# FYT VDHost: the launcher's boot log keeps the start of the boot.
#
# The boot log sets persist.logd.size (8M) and logd's per-buffer sizes, but logd starts before
# the persistent properties are loaded and runs with its default sizes until the launcher
# enlarges them, by which time "main" had lost the first ~20 s of the boot. post-fs-data runs
# before zygote: the buffers grow here, to the size the launcher asked for. Nothing happens while
# the boot log is off (no persist.logd.size).

SIZE=$(getprop persist.logd.size)
if [ -z "$SIZE" ] && command -v resetprop >/dev/null 2>&1; then
  # Not loaded yet at this point of the boot: read it from the persistent storage.
  SIZE=$(resetprop -p persist.logd.size 2>/dev/null)
fi

# In the background: post-fs-data holds the boot while it runs.
[ -n "$SIZE" ] && /system/bin/logcat -b all -G "$SIZE" >/dev/null 2>&1 &
