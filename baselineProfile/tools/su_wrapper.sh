#!/system/bin/sh
# TEST UNIT ONLY. Installed by prepare_device.sh as /sbin/su; gone after a reboot (/sbin is a tmpfs).
# Macrobenchmark runs root commands as "su root <cmd>" (the su syntax of userdebug builds).
# Magisk's su misinterprets that syntax and hangs, so it is translated to "magisk su -c".
if [ "$1" = "root" ] || [ "$1" = "0" ]; then
  shift
  [ $# -eq 0 ] && exec /sbin/magisk su
  exec /sbin/magisk su -c "$*"
fi
exec /sbin/magisk su "$@"
