# FYT VDHost installer.

if [ "$API" -lt 26 ]; then
  ui_print "! Android 8 or newer is required (this is API $API)."
  abort "! Installation aborted"
fi

ui_print "- FYT VDHost for Android API $API"
ui_print "- The service starts after boot as uid 1000 (system)."
ui_print "- Log: /dev/fyt_vdhost/server.log, logcat tag FytVdHost"
ui_print "- With the launcher's boot log on, logd's buffers grow before zygote."

set_perm_recursive "$MODPATH" 0 0 0755 0644
