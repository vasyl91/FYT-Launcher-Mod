# FYT VDHost installer.

if [ "$API" -lt 30 ]; then
  ui_print "! Android 11 or newer is required (this is API $API)."
  ui_print "! On Android 10 the launcher uses the system's own ActivityView."
  abort "! Installation aborted"
fi

ui_print "- FYT VDHost for Android API $API"
ui_print "- The service starts after boot as uid 1000 (system)."
ui_print "- Log: /dev/fyt_vdhost/server.log, logcat tag FytVdHost"

set_perm_recursive "$MODPATH" 0 0 0755 0644
