# Roadmap

As of 2026-11-10. **Confirmed** items come from the owner, the briefs or the user-facing docs, with a source.
**Recommendations** are from the 2026-11-10 audit and are not decided. Move an item to "Completed" when it
ships; do not delete it.

## Current phase

The owner runs short device-driven rounds on `testBranch`: logs → Opus brief → Sonnet commits → device test.
Each round fixes what the last test found and adds the features the owner asks for. The work since `v1.2.1`
(532 commits) is unreleased. **No brief is active.** Round G (2026-11-08) waits for the owner's device review.

## Completed milestones [V] (git history)

| When | Milestone |
|---|---|
| 2024-11 → 2025-03 | First public versions, v1.0.2 … v1.1.0. The commits are named after the versions only; what each release added is in the GitHub release notes, not in git [U] |
| 2025-04 → 2025-12 | v1.1.2 … v1.1.7. Since 1.1.7 no modified `android.jar` is needed (`README.MD`) |
| 2026-01 → 2026-03 | v1.1.8, v1.1.9, v1.2.0 |
| 2026-07 → 2026-08 | External PRs #4–#7: media favorites, the Maps window, `zh-rCN` |
| 2026-08 → 2026-10 | Owner's stabilisation: leaks, PiP, logcat, Gradle flavors (09-01), resizable bar, Baseline Profile (09-23). **v1.2.1** on 2026-10-06 |
| 2026-10-05 → 10-19 | First Claude Code sessions: wake and bind fixes, **FYT VDHost** (Android 11+ panes, the standard flavor through root or Shizuku), "phone" renamed "standard" |
| 2026-10-26 | All strings translated into 59 locales |
| 2026-10-27 → 11-08 | 33 implemented briefs (`prompts/README.md`), in themes: 7870/Shizuku fixes; pinned PiP; CAN bus library, code reader, automatic check and fuel model v3; stats window; screens planned by the model and layout fitting; crash loop and compat reports; `com.syu.media` covers and hearts; VD host protocol 3; widget bar options; bars at either side and on every page; one creator for every page; workspace load watchdog |

## Next: confirmed

| # | Item | Source | Depends on / blocked by |
|---|---|---|---|
| P-1 | **Owner's device review of round G** (workspace load, widget colors, creator overlap) | the workflow; the next brief opens with it | owner |
| P-2 | **Release 1.2.2.** README, the updater and `release-assets.yml` already use the 1.2.2 file names | `README.MD` [V]; release date [U] | P-3; `versionName` bump; merge to `main` |
| P-3 | **Regenerate the Baseline Profile** before a release | Cling brief: "the owner will regenerate them later"; `baselineProfile/README.md` §10 [H] | a test device on ADB |
| P-4 | Owner actions when moving to the new names: publish the new Magisk module (protocol 3; the old one still hosts panes), and update the file names inside `installer.zip` (outside the repository) | media brief 2026-11-05 §6 [H] | — |
| P-5 | **Test Android 8–10 through the VD host** (module and Shizuku) | `vdhost/README.md` checklist [H] | one device each of 8.0, 8.1/9, 10 |
| P-6 | *Idea, needs a brief:* pin the current day/night mode to the PiP virtual displays (`updateDisplayOverrideConfiguration`), so the apps in panes are not restarted by a dark-mode switch | media brief §7 [H] | the owner decides the trade-off (apps stay in their opening theme); check `CHANGE_CONFIGURATION` under Shizuku |
| P-7 | *Idea, needs a brief:* FYT skins in the standard flavor (install the factory before AppCompat) | media brief C9 [H] | AppCompat inflation risk |
| P-8 | Cold-start profiling (plan → `finishBindingItems` took 3.2 s on Samsung, 9.3 s on Xiaomi). Partly addressed in `69aac3b1` | crash-loop brief §3, `opus-analysis-2026-11-03` §3 [H] | profiling on a device |
| P-9 | A build for custom ROMs signed with their own platform key | `README.MD`: "No such build exists yet" [V] | only the ROM's maintainer has the key |

## Recommendations (from the audit, not decided)

| # | Recommendation | Why | Issue |
|---|---|---|---|
| R-1 | Move the OpenWeather key out of the source (e.g. `local.properties` → `BuildConfig`) and rotate it | the key is public in the repository and was in shared logs | KI-01 |
| R-2 | Remove Room (runtime + KSP compiler) and Compose (BOM, plugin, `compose = true`) unless they are planned | no imports anywhere; build-time cost | KI-03 |
| R-3 | Fill `chat_archive/` from the 18 older conversations, then fold the confirmed facts into these docs | knowledge older than 2026-10-26 exists only there | — |
| R-4 | Merge `testBranch` into `main` when 1.2.2 is released | `main` is 137 commits behind | — |
| R-5 | Decide whether the 305 MB of `decompiled_*` and the 176 MB of README videos belong in Git (Git LFS or release assets) | clone and CI checkout size | KI-07 |
