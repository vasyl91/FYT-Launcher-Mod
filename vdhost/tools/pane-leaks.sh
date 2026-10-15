#!/usr/bin/env bash
# Counts the pane surfaces SurfaceFlinger still holds after their panes went (offscreen
# SurfaceView[PipWindowHost:*](BLAST) layers) and the launcher's virtual displays it knows.
# Runs on the PC (Git Bash, Linux, macOS); needs only adb, no root.
#
#   ./pane-leaks.sh            the only connected device
#   ./pane-leaks.sh SERIAL     a given device (adb devices)
set -euo pipefail

adb ${1:+-s "$1"} shell dumpsys SurfaceFlinger | tr -d '\r' | awk '
    /^Offscreen Hierarchy/       { offscreen = 1; next }
    /HWC layers/                 { offscreen = 0 }
    offscreen && /PipWindowHost.*BLAST/ {
        leaked++
        if (match($0, /PipWindowHost:[A-Za-z]+/)) pane[substr($0, RSTART + 14, RLENGTH - 14)]++
    }
    /\(virtual, "WindowHostVd/   { displays++ }
    END {
        printf "offscreen pane layers: %d", leaked
        if (leaked) { sep = " ("; for (p in pane) { printf "%s%s %d", sep, p, pane[p]; sep = ", " } printf ")" }
        printf "\nvirtual displays:      %d\n", displays
    }'
