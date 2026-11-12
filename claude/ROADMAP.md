# Roadmap

As of 2026-11-12.

- **Completed milestones** are backed by git (commits, tags) and, where given, a chat report.
- **Confirmed** items come from the owner, the briefs or the user-facing docs, with a source.
- **Recommendations** come from the audits of 2026-11-10 and 2026-11-12. They are not decided and not
  commitments.

Move an item to "Completed" when it ships; do not delete it.

## Current phase

The owner runs short device-driven rounds on `testBranch`: logs → Opus brief → Sonnet commits → device test.
Each round fixes what the last test found and adds the features the owner asks for. The work since `v1.2.1`
(536 commits at `ee8e4f91`) is unreleased. **No brief is active**, and every round is reviewed: the
owner confirmed round 12 on 2026-11-12.

## Completed milestones

| When | Milestone | Evidence |
|---|---|---|
| 2024-11 → 2025-03 | First public versions, v1.0.2 … v1.1.0. What each release added is in the GitHub release notes, not in git [U] | tags |
| 2025-04 → 2025-12 | v1.1.2 … v1.1.7. Since 1.1.7 no modified `android.jar` is needed | tags, `README.MD` |
| 2026-01 → 2026-03 | v1.1.8, v1.1.9, v1.2.0 | tags |
| 2026-07 → 2026-08 | External PRs #4–#7: media favorites, the Maps window, `zh-rCN` | merge commits |
| 2026-08 → 2026-10 | Owner's stabilisation: leaks, PiP, logcat, Gradle flavors (09-01), resizable bar, Baseline Profile (09-23) | git log |
| 2026-10-05 | First code review with Claude and its fixes (receivers, weather, Spotify redirect, splash, workspace-load watchdog), committed by the owner | `eed91b73`, `3f4d96da`; CHAT_01 |
| 2026-10-05 → 10-06 | Log-driven fixes on `main-6mxprj`: adaptive pane launch, sound-channel handling with the input monitor, return from the settings, fYT Rating timing, CI workflow, `Launcher.java` split into ten helpers. **v1.2.1 released 2026-10-06** | `dbfac7a` … `1039775`, tag `v1.2.1`; CHAT_02 |
| 2026-10-08 → 10-09 | Navigation app no longer overwritten; last app restored at a cold boot and a wake; ACC as a wake signal; "home screen on top" split in two settings | `44833aa0` … `36359b61`; CHAT_03 |
| 2026-10-12 | Wake detection for the whole process from every signal; `HomeFrontGuard` | `ffba656` … `10c9b3b`; CHAT_04 |
| 2026-10-13 → 10-19 | **FYT VDHost**: panes on Android 11+, the standard flavor on root or Shizuku ("phone" renamed "standard" 10-17); StrictMode clean-up; music widget (covers, YT Music likes, stock players) | 139 commits of one session; CHAT_05 |
| 2026-10-23 → 10-26 | FYT stock sources behind the music widget (7870 `com.syu.media`, radio on both families); all strings translated into 59 locales | `ded0e6ef` … `f1773cc1`; CHAT_06; 60 translation commits |
| 2026-10-27 → 11-08 | 33 implemented briefs (`prompts/README.md`), in themes: 7870/Shizuku fixes; pinned PiP; CAN bus library, code reader, automatic check and fuel model v3; stats window; screens planned by the model and layout fitting; crash loop and compat reports; `com.syu.media` covers and hearts; VD host protocol 3; widget bar options; bars at either side and on every page; one creator for every page; workspace load restart | catalogue; CHAT_07 … CHAT_15 |
| 2026-11-10 → 11-12 | Knowledge base in `claude/`; reference material gathered in `archive/`; 15 conversation reports archived and consolidated | `a30c9a72`, `8bfc5a8d`, `754c8258`, `e3ba694e` and the commit after it |

## Next: confirmed

| # | Item | Source | Depends on / blocked by |
|---|---|---|---|
| P-1 | ~~Owner's device review of round 12~~ **Done 2026-11-12:** "It works as intended." | the owner | — |
| P-2 | **Release 1.2.2.** README, the updater and `release-assets.yml` already use the 1.2.2 file names | `README.MD` [V]; release date [U] | P-3; `versionName` bump; merge to `main` |
| P-3 | **Regenerate the Baseline Profile** before a release | Cling brief and CHAT_07: "właściciel wygeneruje profile na nowo"; `baselineProfile/README.md` §10 [H] | a test device on ADB |
| P-4 | Owner actions when moving to the new names: publish the new Magisk module (protocol 3; the old one still hosts panes), and update the file names inside `installer.zip` (outside the repository) | brief 2026-11-05 media §6 [H] | — |
| P-5 | **Test Android 8–10 through the VD host** (module and Shizuku) | `vdhost/README.md` checklist [H] | one device each of 8.0, 8.1/9, 10 |
| P-6 | *Idea, needs a brief:* pin the current day/night mode to the PiP virtual displays, so the apps in panes are not restarted by a dark-mode switch | brief 2026-11-05 media §7 [H] | the owner decides the trade-off (apps stay in their opening theme); check `CHANGE_CONFIGURATION` under Shizuku |
| P-7 | *Idea, needs a brief:* FYT skins in the standard flavor (install the factory before AppCompat) | brief 2026-11-05 media C9 [H] | AppCompat inflation risk |
| P-8 | Cold-start profiling. Partly addressed in `69aac3b1` | brief 2026-11-03 crash-loop §3, analysis 2026-11-03 §3 [H] | profiling on a device |
| P-9 | A build for custom ROMs signed with their own platform key | `README.MD`: "No such build exists yet" [V] | only the ROM's maintainer has the key |
| P-10 | *Deferred by the owner:* Shizuku Next start-up fixes ("temat na później"); a "stopped" state for the "Display media Titles" app ("zajmiemy się kiedy indziej") | CHAT_05 [H] | other projects' code |
| P-11 | *Said by the owner, no result on record:* a wake test after a long sleep ("Sprawdzę później jak to wygląda przy dłuższym okresie uśpienia") | CHAT_03 [H] | owner |
| P-12 | **Remove the unused Room and Compose set-up** (Room runtime and its KSP processor; the Compose BOM, runtime, tooling, plugin and `compose = true`). KSP stays for Glide | the owner, 2026-11-12: "Not planned, might be removed if it is unused"; KI-03, D-51 | a brief or a direct request; CI is the check |
| P-13 | The tester's answer on what did not work on the 7870 | the owner, 2026-11-12 | the tester |

## Recommendations (not decided)

| # | Recommendation | Why | Issue |
|---|---|---|---|
| R-1 | ~~Move the OpenWeather key out of the source and rotate it~~ **Withdrawn 2026-11-12.** | The owner decided to keep the key hardcoded (D-26). The 2026-11-10 audit did not know that. | KI-01 |
| R-2 | ~~Remove Room and Compose unless they are planned~~ **Approved by the owner 2026-11-12;** now P-12 | — | KI-03 |
| R-3 | ~~Fill `chat_archive/` from the older conversations~~ **Done 2026-11-12** with the 15 reports supplied | — | — |
| R-4 | Merge `testBranch` into `main` when 1.2.2 is released | `main` is more than 140 commits behind | KI-10 |
| R-5 | Decide whether `archive/` (about 300 MB) and the README videos (176 MB) belong in Git, or in Git LFS or release assets | clone and CI checkout size. The move into `archive/` tidied the tree but not the history | KI-07 |
| R-6 | Give `display_pip` one default everywhere | three readers use `false`, nine use `true` | KI-20 |
| R-7 | Ask the owner about the remaining items that never got a device result | the stats window and the pinned-PiP keyboard were answered on 2026-11-12; the rest of the list is open | KI-25 |

## Long-term objectives

Nothing beyond the items above is recorded as an owner plan [U]. The direction visible in the history is:
the same launcher on more FYT platforms and on ordinary Android devices, without regressions on the 7862.
