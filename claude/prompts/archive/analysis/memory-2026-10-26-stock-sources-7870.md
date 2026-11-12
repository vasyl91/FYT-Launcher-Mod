---
name: project-stock-sources-7870
description: "Status and design of the StockSources work (7870 com.syu.media + radio/BT overlays in the music widget); committed 2026-10-26, verified on 7862, awaiting 7870 logs"
metadata:
  node_type: memory
  type: project
  originSessionId: eabfb0ac-9035-484c-8527-dd27147e2519
  modified: 2026-10-26T21:46:37.892Z
---

Implemented 2026-10-23 from the owner's brief (`docs/prompts/sonnet_stock_media_sources.md`, WP1-WP12, D1-D13, N1):
`com.fyt.car.StockSources` (facade), `StockKindArbiter` (pure, which source the widget shows from the MCU channel),
`SyuMediaClient` (IPlayer binder client, music + online radio), `StockRadioSource` / `StockBtSource` (overlays read
from com.syu.ms modules 1 / 2), `StockTrack`, `StockFreq`, `StockTitles`, `StockResumePolicy`.
Entry points in NotificationListener: `onStockSourceUpdate/Paused/OverlayHidden`.

2026-10-26: owner confirmed the 7862 works unchanged and the com.syu.radio overlay works. Reviewed and fixed
(player may not take the widget off radio/BT while the MCU is on their channel; 1.5 s settle after a channel
change; `isFytMusicAllowed` gate back on the com.syu.media path), then committed on branch ccr-087eed00-gbqsuz.
The 7870 tester is not technical: `docs/7870-stock-sources-test.md` is the plain-English guide (logs via the
launcher's own Logcat service -> Download/Launcher66_Logs, no adb).

**Why:** the 7870 has com.syu.media instead of com.syu.music/com.syu.radio; the widget only followed USB music.
**How to apply:** the com.syu.music path (7862/8581) must behave identically: new behavior is gated by
`StockSources.isSyuMediaUnit()` or `shownOverlay()`/`radioShown()`. Open questions for the 7870 logs: does
com.syu.ms push current values on `notify` (first radio/BT display), does com.syu.media give its channel up
(8 -> 0) when it pauses for a pane app (then `isStockPlayerLeaving` blocks the resume), BT times in ms vs
`Launcher.refreshBtInfo` expecting seconds (left untouched).
