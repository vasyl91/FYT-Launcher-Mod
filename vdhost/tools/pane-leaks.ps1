# Counts the pane surfaces SurfaceFlinger still holds after their panes went (offscreen
# SurfaceView[PipWindowHost:*](BLAST) layers) and the launcher's virtual displays it knows.
# Runs on the PC; needs only adb, no root.
#
#   powershell -ExecutionPolicy Bypass -File .\pane-leaks.ps1            the only connected device
#   powershell -ExecutionPolicy Bypass -File .\pane-leaks.ps1 SERIAL     a given device (adb devices)
param([string]$Serial)

$adbArgs = @()
if ($Serial) { $adbArgs += @('-s', $Serial) }
$lines = & adb @adbArgs shell dumpsys SurfaceFlinger
if ($LASTEXITCODE -ne 0) { Write-Error "adb failed"; exit 1 }

$offscreen = $false
$leaked = 0
$displays = 0
$panes = [ordered]@{}
foreach ($line in $lines) {
    if ($line -match '^Offscreen Hierarchy') { $offscreen = $true; continue }
    if ($line -match 'HWC layers') { $offscreen = $false }
    if ($offscreen -and $line -match 'PipWindowHost:([A-Za-z]+).*BLAST') {
        $leaked++
        $panes[$Matches[1]] = 1 + [int]$panes[$Matches[1]]
    }
    if ($line -match '\(virtual, "WindowHostVd') { $displays++ }
}

$detail = ''
if ($leaked -gt 0) { $detail = ' (' + (($panes.GetEnumerator() | ForEach-Object { "$($_.Key) $($_.Value)" }) -join ', ') + ')' }
"offscreen pane layers: $leaked$detail"
"virtual displays:      $displays"
