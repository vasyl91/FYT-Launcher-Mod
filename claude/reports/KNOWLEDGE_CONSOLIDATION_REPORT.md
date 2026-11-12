# Knowledge consolidation report (2026-11-12)

The final consolidation of the project's knowledge base: every available source was read, compared with the
code and git, and the existing documents in `claude/` were updated. No application code was changed.

State of the repository: `testBranch` at `ee8e4f91`, plus two documentation commits: `e3ba694e` (the folder
rename) and the one this report belongs to. CI was green on `ee8e4f91` (run 468), the last commit that
touched the build.

> **Update, later on 2026-11-12:** the owner answered five of the open questions after reading this report.
> The answers are in the addendum at the end. Sections E, G, H and I below are kept as first written; where
> they call something open that the addendum closes, the addendum holds.

Evidence tags: [V] verified in code, git or CI · [H] historical, from the owner, a brief or a chat report ·
[P] planned · [A] assumed · [U] unknown.

## A. Source inventory

| Source | Path | Count | Inspected | Relevance | Limits |
|---|---|---|---|---|---|
| Conversation reports | `claude/chat_archive/CHAT_01.MD` … `CHAT_15.MD` | 15 | all, in full | history from 2026-10-05 to 11-08: requirements, decisions, rejected ideas, device results | they report what a conversation said; `CHAT_10.MD` has lost characters (pipes, slashes, comparison signs) |
| Core documents | `claude/CLAUDE.md`, `PROJECT_STATE.md`, `ARCHITECTURE.md`, `DECISIONS.md`, `ROADMAP.md`, `KNOWN_ISSUES.md` | 6 | all, in full | the knowledge base as of 2026-11-10, with the owner's path edits | — |
| Indexes and template | `claude/prompts/README.md`, `claude/chat_archive/README.md`, `CHAT_EXTRACTION_TEMPLATE.md` | 3 | all | catalogue of briefs; archive index | — |
| Earlier audits | `claude/reports/implementation_audit.md`, `documentation_audit.md` | 2 | all | findings of 2026-11-10 | — |
| Implementation briefs | `claude/prompts/archive/sonnet-prompt-*.md` | 33 | all read on 2026-11-10 (structure, commit tables, rules, deferred items); on 2026-11-12 their status was re-checked against git and passages were re-read where a report referred to them | intended work and owner instructions | Polish; not re-read line by line in the second pass |
| Analyses | `claude/prompts/archive/analysis/*.md` | 4 | as above | log findings, the `com.syu.canbus` comparison | the largest (170 KB of log excerpts) was read in its summary sections |
| User documentation | `README.MD`, `vdhost/README.md`, `baselineProfile/README.md`, `canbus_library/README.md`, `archive/decompiled/decompiled_carinfo/README.md`, `MagiskWiFiADB.MD` | 6 | yes | features, supported devices, build and tools | — |
| Git history | `testBranch`, `main`, tags | 796 commits at `ee8e4f91` | yes: log, authors, session trailers, pickaxe searches, the owner's four latest commits | chronology and what was really changed | — |
| CI | GitHub Actions, workflow `build.yml` | runs 464–468 | yes | build and unit-test status | — |
| Source code and build files | `app/`, `vdhost/`, `hiddenapi-stubs/`, `canbus_library/`, Gradle files, manifests | — | claim by claim (several dozen checks), not reviewed as a whole | the truth about current behaviour | no Android SDK here: nothing built or run except `javac` on two small modules and the Python library script |
| Reference material | `archive/decompiled/`, `archive/fuel_stats_example/` | about 21,000 files | existence and layout only | reference for FYT firmware behaviour | not read |

**Could not be accessed or verified:**

- Behaviour on any device.
- The owner's words quoted in reports and briefs (taken as the reports give them).
- Uploaded logs that reports cite (they are not in the repository).
- `decompiled_FYT_jars/` in its extracted form (removed from the tree; the zips remain in git history and
  were not unpacked).
- The stock-sources brief and the 7870 test guide of 2026-10-23/26 (a local commit that was never pushed).

## B. Archive inventory

The files present in `claude/chat_archive/` on 2026-11-12, besides `README.md` and the template:

| File | Covers |
|---|---|
| `CHAT_01.MD` | 2026-10-05. A bug review and its fixes; the workspace-load watchdog; a preference layout. Local session; the owner committed the work |
| `CHAT_02.MD` | 2026-10-05 → 10-06. Log-driven fixes: pane launch, sound channel, fYT Rating, CI; `Launcher.java` split; v1.2.1 |
| `CHAT_03.MD` | 2026-10-08 → 10-09. Navigation app; last-app restore at cold boot and wake; ACC wake signal; settings split |
| `CHAT_04.MD` | 2026-10-12 → 10-13. Wake detection for the whole process; `HomeFrontGuard` |
| `CHAT_05.MD` | 2026-10-18 → 10-19. StrictMode; music widget; stock players; panes with a late host; Shizuku boot analysis |
| `CHAT_06.MD` | 2026-10-23 → 10-26. FYT stock sources behind the music widget; review fixes; a 7870 test guide |
| `CHAT_07.MD` | 2026-10-28. Removal of the dead `Cling` code |
| `CHAT_08.MD` | 2026-10-28. Keyboard focus beside the pinned PiP |
| `CHAT_09.MD` | 2026-11-01. Left bar capacity |
| `CHAT_10.MD` | 2026-10-27 → 10-28. Pinned PiP fixes; pane and stats movement while pages scroll |
| `CHAT_11.MD` | 2026-10-28. Device-identity round; icon plate regression; StrictMode; platform-first location |
| `CHAT_12.MD` | 2026-11-04. Log legend, screen numbers, overlapping elements, Spotify browser start |
| `CHAT_13.MD` | 2026-11-02. Widgets and bars layout; the resolver; dual-PiP split; date widget |
| `CHAT_14.MD` | 2026-11-07 → 11-08. **Planning and review:** the briefs for rounds 8–12 |
| `CHAT_15.MD` | 2026-11-06 → 11-08. **Implementation** of rounds 8–12 |

Fourteen are implementation or analysis reports and one (CHAT_14) is a planning report. CHAT_14 and CHAT_15
describe the same rounds from the two sides. The index (`../chat_archive/README.md`) gives, for each report,
its session, its commits, what was taken into the main documents, and what stays unverified.

## C. Historical reconstruction

Stages, from git and the reports:

1. **2024-11 → 2026-03: the owner's project** [V]. Releases v1.0.2 to v1.2.0 for FYT 7862/8581 on Android 10.
   Git names the commits after versions only; what each release added is not in the sources read [U].
2. **2026-07 → 09: outside contributions and stabilisation** [V]. Pull requests #4–#7 (media favorites, the
   Maps window, a Chinese translation), then the owner's work on leaks, PiP, logcat, Gradle flavors, the
   resizable bar and the Baseline Profile.
3. **2026-10-05 → 10-06: first work with Claude; v1.2.1** [V][H]. A code review with fixes (CHAT_01), then
   log-driven work on a cloud branch: adaptive pane launch, sound-channel handling, CI, and the split of
   `Launcher.java` into ten helpers (CHAT_02). Released as v1.2.1 on 10-06.
4. **2026-10-08 → 10-13: behaviour at wake and cold boot** [V][H]. The launcher stops overwriting the
   navigation app, restores the last app, and gets a guard that keeps the home screen in front only against
   what the device itself opens. The owner's objections shaped the guard through several rejected versions
   (CHAT_03, CHAT_04).
5. **2026-10-13 → 10-19: beyond the 7862** [V][H]. The FYT VDHost brings panes to Android 11+ and to a normal
   install with root or Shizuku; the "phone" flavor becomes "standard". The music widget gains covers, YT
   Music likes and the stock players (CHAT_05). The first half of this period is known from git only.
6. **2026-10-23 → 10-26: the 7870** [V][H]. Stock sources of `com.syu.media` and the radio overlay, from an
   owner's brief that is not in the repository (CHAT_06); all strings translated into 59 locales.
7. **2026-10-26 → 11-08: the brief workflow** [V]. Opus writes Polish briefs, Sonnet implements them commit
   by commit, the owner tests. 33 briefs, all implemented. Themes: Shizuku on the 7870, pinned PiP, CAN bus
   library and fuel model, stats window, screens and layout fitting, crash safety, `com.syu.media` covers,
   VD host protocol 3, bars at either side and on every page, one creator, workspace load restart
   (CHAT_07 … CHAT_15).
8. **2026-11-10 → 11-12: knowledge base** [V]. Documentation in `claude/`; reference material in `archive/`;
   15 conversation reports archived and consolidated.

## D. Important recovered knowledge

Recovered from the reports, or clarified by them. Each is recorded in the document named.

**Decisions and requirements of the owner [H]**

| Knowledge | Source | Recorded in |
|---|---|---|
| The OpenWeather key stays hardcoded; a move to `BuildConfig` was made and reverted | CHAT_01, CHAT_02 | D-26, KI-01 |
| The launcher never undoes what the user did; no app is special-cased; never "any app" | CHAT_04 | D-28 |
| FYT's black screen is not a sleep; `ACTION_SCREEN_ON` does not work on FYT | CHAT_03, CHAT_04 | D-27 |
| The launcher never overwrites the navigation app chosen in the system | CHAT_03 | D-29 |
| With "home screen on top" off the last app comes back, as on the stock launcher; delays only for `com.syu.*`/`com.fyt.*` at a cold boot | CHAT_03 | D-30 |
| A tapped app must be told from one that came up by itself | CHAT_02 | D-31 |
| The stock-player path on the 7862 must not change; the launcher never starts `com.syu.media` | CHAT_06 | D-32 |
| YT Music likes through the session's own button, in any language | CHAT_05 | D-33 |
| Location: the platform first, Play services only as a way out | CHAT_11 | D-19 |
| Keep the 250/100 ms pinned-PiP waits; no jump on the launcher's own restart | CHAT_10 | D-34 |
| The handle catches only the swipe; the stats window is only moved; the horizontal bar is drawn above the vertical one | CHAT_14 | D-16, D-18 |
| Review scope; `isNewerVersion` in debug builds is intentional | CHAT_01 | D-35 |
| The `Launcher.java` split stops after ten helpers | CHAT_02 | D-36 |
| The Magisk module version stays 1.0.0 | CHAT_05 | D-37 |
| Rejected: parking-light night mode, persisted weather, embedding the pane host, and others | CHAT_02, CHAT_05, CHAT_10, CHAT_14 | D-49 |

**Technical knowledge and lessons [H], checked in the code where possible [V]**

| Knowledge | Source | Recorded in |
|---|---|---|
| On Android 10 a tap on a pane never reaches the launcher's views; an input monitor sees it | CHAT_02 | D-31, ARCHITECTURE §8 |
| `com.syu.ms` notes its "top app" 0.8–1.0 s after ACC off; the launcher goes to the top at 300 ms so that note is empty | CHAT_04 | D-28, ARCHITECTURE §11 |
| Android calls `onUserInteraction` whenever an activity starts over the launcher, so it cannot stand for a touch | CHAT_04 | D-28 |
| MCU sound channels: 1 radio, 3 BT, 8 FYT music, 10 third party, 7 internet radio (7870) | CHAT_02, CHAT_05, CHAT_06 | ARCHITECTURE §8 |
| Resource ids shift when a resource is removed: `R.drawable.icon_bg + 1` broke every icon | CHAT_11 | D-38, `CLAUDE.md` |
| A color filter on a resource drawable without `mutate()` spreads to every user of that drawable | CHAT_14, CHAT_15 | D-17 (R2) |
| Window mode 6 is FYT's pinned stack only up to Android 10 | CHAT_10 | D-34 |
| On Android 14+ window relayout is asynchronous; sending more than the system handles builds a backlog | CHAT_10 | ARCHITECTURE §7 |
| Shizuku (shell) cannot read another app's private database | CHAT_05 | D-05 |
| The head unit reports one light signal only | CHAT_02 | D-49 |
| A rename script once edited the decompiled reference trees by accident | CHAT_15 | `CLAUDE.md` ("exclude `archive/`") |
| `android_jar/android-36.jar` is needed by two modules | the broken build of 2026-11-12 [V] | KI-19, ARCHITECTURE §1–2 |

**Process knowledge [H]**

- The owner's rules from the first sessions: never undo the owner's commits; no PR unless asked; replies in
  Polish; nothing may crash as a plain user app (CHAT_03, CHAT_05) → D-25, D-01.
- Model names are kept out of repository content; the session's commit trailers are the exception (noted as
  an open contradiction in CHAT_03 and CHAT_07) → `CLAUDE.md`, D-25.
- The 7870 belongs to a non-technical tester; logs come from the launcher's own Logcat tool (CHAT_06) →
  `PROJECT_STATE.md`.

## E. Contradictions

| # | Contradiction | Resolution |
|---|---|---|
| 1 | The 2026-11-10 documents rated the hardcoded weather key High and recommended rotating it. The reports show the owner decided to keep it | **Resolved** for the owner's decision: D-26 active, KI-01 accepted, R-1 withdrawn. The earlier wording is kept in the audits as history |
| 2 | The 2026-11-10 documents called `android_jar/` obsolete. Two Gradle modules compile against `android-36.jar` | **Resolved:** the documents are corrected; the owner moved the jar back (`ee8e4f91`); CI green |
| 3 | The owner's rename left `Claude/` and `claude/` as two folders on Linux, with a root import that pointed nowhere | **Resolved:** all files are under `claude/` |
| 4 | The chat index expected "18 older conversations" as `CHAT_NN.md`; 15 files exist as `CHAT_NN.MD` | **Resolved:** the index describes what exists |
| 5 | CHAT_14 (planning) lists G1–G3 as proposals; CHAT_15 (implementation) lists them as done | **Resolved** by git: `e3136f45`, `b1fe254c`, `3dd71894` exist. Implemented, not device-tested (KI-24) |
| 6 | "No model name in the repository" versus commit trailers that name the model | **Resolved** as a rule: content, not trailers (`CLAUDE.md`). The history is not rewritten |
| 7 | "Do not migrate preferences" versus the `launcher_home` migration, the `_v2` keys and the user rectangles | **Resolved:** these are the recorded exceptions, each asked for by the owner or a brief (D-09) |
| 8 | "Strings in all 59 files" versus CHAT_03, which translated three locales, and the six regional files that lack older keys | **Resolved:** the rule dates from later (D-10, D-46); regional files hold overrides only |
| 9 | CHAT_01 (2026-10-05): "no Android 11+ device". Later logs come from Android 14 and 16 phones | **Resolved** by the owner on 2026-11-12: both phones are the owner's. The earlier remark is taken as true for its date [A] |
| 10 | Briefs disagree with later briefs (flavor, branch, bar names, pinned-PiP rule, stats window as an obstacle, autosize, touch injection) | **Documented**, not changed: `../prompts/README.md`, "Instructions that later briefs replaced" |
| 11 | CHAT_06 reports five commits; one (`0b722649`, the brief and a test guide) is not in the repository | **Documented:** never pushed; the code commits exist. The brief is lost to the repository |
| 12 | CHAT_01 reports a deferred screen strip (`mStripScreensBaseOnDBAfterLoad`); the code has none | **Resolved** by git: added in `eed91b73`, removed by `660bad7d` when the model took over the strip |
| 13 | CHAT_10: the 7862 stats window still lagged, and a third fix was pushed untested. Git: the owner reverted it the same night, with no reason | **Unresolved** [U]: why, and whether the lag remains (KI-21, D-24) |
| 14 | CHAT_14 quotes the owner that changes worked "except those on the 7870" | **Unresolved** [U]: no source says which (KI-29) |
| 15 | CHAT_12 found `display_pip` read with two defaults; one session changed some readers, not all | **Documented** as a confirmed inconsistency in the code (KI-20). Not changed: this task does not touch code |

## F. Documentation changes

**Moved with `git mv`, contents byte-identical (commit `e3ba694e`):** every tracked file under `Claude/` to `claude/` (the six
core documents, both indexes, the template, both reports, the 33 briefs, the 4 analyses, `.gitkeep`).

**Updated**

| File | What changed | Why |
|---|---|---|
| `claude/CLAUDE.md` | Folder name; "check before you rely on a document"; the chat archive in the reading list; the model-name rule with its exception; rules on `R.*` ids, `archive/`, `android-36.jar`, `keystore.properties`, review scope; two product rules; "a proposal is not a decision"; say what was not device-tested | new sessions need the recovered rules, and the paths had moved |
| `claude/PROJECT_STATE.md` | Snapshot of 2026-11-12; purpose with the owner's aims; device table with ownership; features with "device on record"; active tasks; blockers; critical issues without the key | the state had changed and the first version mixed "implemented" with "working" |
| `claude/ARCHITECTURE.md` | Repository layout (`archive/`, the jar); home guard, last-app restore, navigation; wake signals; sound channel; pane lifecycle rules; the helper classes; cross-cutting rules | subsystems of 2026-10-05 → 10-26 were missing, and paths were stale |
| `claude/DECISIONS.md` | 49 entries (was 26) with status ACTIVE / SUPERSEDED / REJECTED / UNDER_REVIEW, who decided, and sources; superseded and rejected decisions kept as their own entries | decisions from the reports; explicit statuses and relations |
| `claude/ROADMAP.md` | Milestones for 2026-10-05 → 10-26 with evidence; R-1 withdrawn, R-3 done; new deferred items; long-term section | completed work was missing; one recommendation contradicted an owner decision |
| `claude/KNOWN_ISSUES.md` | Three parts: confirmed, accepted, unverified; KI-01 accepted; new KI-19 … KI-29 | confirmed problems were mixed with reports and risks |
| `claude/prompts/README.md` | Path map for old paths; device results on record; instructions later briefs replaced; the brief that is not in the repository; statuses of rounds 8–11 | the catalogue said "implemented" but not what is known from devices |
| `claude/chat_archive/README.md` | Rewritten from the files present: what each report covers, verification, what was taken, what stays historical, coverage of the git history | the index described an empty archive of a different size |
| `claude/chat_archive/CHAT_EXTRACTION_TEMPLATE.md` | File name `CHAT_NN.MD`; a rule to give plain Markdown | two reports came wrapped in a code fence, one lost characters |
| `claude/reports/implementation_audit.md`, `documentation_audit.md` | A dated banner and an addendum each; the 2026-11-10 text kept | new findings kept apart from the old |
| `README.MD` | Four links to `fuel_stats_example/` now point to `archive/fuel_stats_example/` | the folder moved (owner approved) |
| `canbus_library/build_canbus_library.py`, `canbus_library/README.md` | The built-in library's sources are read under `archive/decompiled/` | the folders moved (owner approved). Checked: both libraries rebuild byte-identical to the committed assets |

**Created:** `claude/reports/KNOWLEDGE_CONSOLIDATION_REPORT.md` (this file).

**Preserved without modification:**

- all 15 conversation reports, `CHAT_01.MD` … `CHAT_15.MD`;
- all 33 archived briefs and all 4 archived analyses (moved, not edited);
- all application code, resources, manifests, Gradle files and workflows.

**Deleted:** nothing.

## G. Implementation verification

**Confirmed in code or git [V]**

| Claim | Evidence |
|---|---|
| All 33 briefs were implemented | every prescribed commit subject is in `testBranch`, in order (`../prompts/README.md`) |
| The reports' commits exist | 156 distinct commits cited, all ancestors of `testBranch` |
| CHAT_01's fixes are in the code | `eed91b73`, `3f4d96da`; 14 of 15 spot checks present, the fifteenth removed later by `660bad7d` |
| Settings split and migration | `Keys.LAUNCHER_HOME_WAKE`, `LAUNCHER_HOME_COLD_START`, `COLD_START_LAST_APP_DELAY`; migration in `LauncherApplication` |
| Guard rules | no `ANY_APP` in `HomeFrontGuard`; `SLEEP_HOME_EARLY_MS = 300` in `WakeDetection` |
| Navigation fix | `setDefaultNavigationPackage` gone; `CarStates.mNaviPkg`; `FytPackage.resolveNavigationPackage` |
| Input monitor | `UserTouches` uses `monitorGestureInput` |
| Media | `SyuMusicLibrary`; the `yt_fill` icon rule; `StockSources.PLAYER_SETTLE_MS`; `HOST_WAIT_TIMEOUT_MS` |
| Pinned PiP focus overlay | `PinnedPipFocus.java` |
| The reverted surface mover | `WindowSurfaceMover.java` absent; `b38f1286` by the owner |
| Regression guard | `ResourceIdArithmeticTest.java` |
| Round 12 | `WorkspaceLoadWatch`, `WidgetStyle`/`ViewTint`/`WidgetStyler`, `RectOverlap` and their tests |
| Build | CI run 468 green on `ee8e4f91`; the library script reproduces both assets |

**Planned but not implemented [P]:** day/night mode pinned to the PiP displays; FYT skins in the standard
flavor; a build for ROMs with their own key; everything in D-49 (rejected).

**Partly implemented:** the optional part of the stock-sources brief (covers and logos) was not done on
2026-10-26 and came later with brief 22 (`b574e758`) [V]; cold-start work (`69aac3b1`) without the profiling
the briefs left out [H].

**Implemented, with no device confirmation on record [U]:** listed in `KNOWN_ISSUES.md` KI-22, KI-24 and
KI-25, with the commit and the report for each.

**Historical claims that could not be verified:** every statement about behaviour on a device; log timings;
the owner's quoted words; CI results of individual runs before run 464 (taken from the reports).

## H. Remaining knowledge gaps

**Genuine gaps in project knowledge** (someone knows, or a device would show):

1. Does round 12 work on the devices? Is "Proceed and fit" the wanted button text? (KI-24)
2. Why was the 7862 stats-window fix reverted, and does the lag remain? (KI-21)
3. Does the pinned-PiP keyboard fix work, and is Back going to the launcher acceptable? (KI-22)
4. Which changes "did not work on the 7870"? (KI-29)
5. Are Room and Compose planned? When is 1.2.2 due? When was the Baseline Profile last generated?
6. Why does the Magisk module version stay 1.0.0? (D-37)
7. Root causes never found: the vertical bar's window on the wrong side; the workspace load that bound
   nothing (KI-28).

**Not available in the current source set** (not a defect of the archive):

- What each release before 1.2.1 added. The GitHub release notes hold it.
- The stock-sources brief and its test guide, which never reached the repository.
- The logs the reports analysed.
- The first half of the VDHost work (2026-10-13 → 10-17) beyond its commits.

## I. Recommended next steps

**Owner-approved priorities (from the briefs and reports)**

1. Review round 12 on the devices; the next brief opens with the result.
2. Regenerate the Baseline Profile before a release.
3. Release 1.2.2 (bump `versionName`, merge `testBranch` into `main`), when the owner decides.
4. Deferred ideas, each as its own brief when wanted: day/night mode on the PiP displays; FYT skins in the
   standard flavor.

**Technical recommendations (not decided)**

1. Give `display_pip` one default everywhere (KI-20). It is a small, testable change.
2. When reviewing round 12, also check the items with no device result on record (KI-21, KI-22, KI-25).
3. Remove the unused Room and Compose set-up, if they are not planned (KI-03).
4. Before moving or deleting a top-level folder, search the Gradle files and scripts for its name (KI-19).
5. Decide whether `archive/` and the README videos stay in Git or move to Git LFS or release assets (KI-07).

**Decisions that need the owner**

1. The questions in section H, part 1 (items 1–6).
2. Whether new conversation reports should keep being added after each round. The template and the index
   are ready for it.

## J. Readiness assessment

Can a fresh Opus or Sonnet session work from these documents alone?

| Aspect | Assessment |
|---|---|
| Project understanding | **Good.** `PROJECT_STATE.md` gives purpose, state, devices, blockers and next steps on two pages |
| Architectural clarity | **Good for navigation.** `ARCHITECTURE.md` maps every subsystem to its classes. It is a map, not a specification: the class Javadoc and the briefs hold the detail |
| Requirements traceability | **Good since 2026-10-05.** Each decision names its source (report, brief, commit). **Weak before that:** the original requirements of the 1.x releases are not recorded |
| Implementation accuracy | **Good for "exists in the code".** Every claim of implementation was checked against git. **Limited for "works":** device results exist for some rounds only, and the documents now say which |
| Decision history | **Good.** 49 decisions with status and who decided; superseded and rejected ones kept |
| Known limitations | **Good.** Confirmed, accepted and unverified are separated |
| Development instructions | **Good.** `CLAUDE.md` holds the rules of every brief plus those recovered from the reports |
| Historical context | **Good from 2026-10-05; thin before.** |

**What could still mislead a new session**

1. **"Implemented" is not "working".** CI builds and runs JVM tests only. A session must not report a change
   as working without the owner's device result.
2. **The documents are a snapshot of 2026-11-12.** Line counts, commit counts and CI status go stale with
   the next commit. `CLAUDE.md` tells sessions to check before relying on them.
3. **Old names in old sources.** Briefs and reports say `fyt`, `phone`, "bottom/left bar", `docs/…`,
   `decompiled_*` at the root, and three former branches. The path map in `../prompts/README.md` translates
   them.
4. **Reports are not uniform.** Some were written from a compacted conversation, one has lost characters,
   and each labels its own confidence. The index says which.
5. **The 7870 is seen second-hand.** Results come from a tester, later and through the owner.
6. **Decisions by an assistant are weaker than decisions by the owner.** `DECISIONS.md` marks who decided;
   a session should not treat an assistant's choice as untouchable, nor an owner's as open.

---

## Addendum: the owner's answers (2026-11-12)

Given after the report was first committed (`5ba38ec2`). Each answer is [H]: the owner's statement.

| Question (section H) | Answer | Recorded in |
|---|---|---|
| 1. Does round 12 work on the devices? Is "Proceed and fit" wanted? | "It works as intended." | KI-24 fixed; D-17; catalogue row 33; P-1 done |
| 2. Why was the 7862 stats-window fix reverted; does the lag remain? | "It didn't work as it should. Reverted it to acceptable state." | D-24; KI-21 moved to accepted limitations |
| 3. Does the pinned-PiP keyboard fix work; is Back to the launcher acceptable? | "Works and it is acceptable." | D-44 UNDER_REVIEW → ACTIVE; KI-22 reduced to two unchecked side effects |
| 4. Which changes did not work on the 7870? | "Tester didn't specify. Still waiting for the reply." | KI-29; P-13 |
| 5. Are Room and Compose planned? | "Not planned, might be removed if it is unused." | D-51; KI-03; R-2 became the confirmed item P-12 |
| What each release before 1.2.1 added | "too much digging as there are plenty of commits. We work on what we currently have." | D-50; removed from the gaps |

**A source added:** the owner supplied a session's memory note on the stock-sources work of 2026-10-23/26.
It is stored unchanged as `../prompts/archive/analysis/memory-2026-10-26-stock-sources-7870.md`. It confirms
what CHAT_06 reports (the classes built, the owner's result on the 7862, the three review fixes) and lists
the questions the 7870's logs were meant to answer; those are now in KI-29. The brief itself and the 7870
test guide are still not in the repository.

**What changes in the sections above**

- **E, rows 13 and 14:** row 13 is resolved (the fix did not work; the reverted state is acceptable). Row 14
  is still open, now with a named reason: the tester has not replied.
- **G, "implemented, with no device confirmation on record":** round 12 and the pinned-PiP keyboard fix are
  confirmed. KI-25 still lists the rest.
- **H, genuine gaps:** items 1, 2, 3 and 5 are answered. Still open: which changes fail on the 7870; when
  1.2.2 is due; when the Baseline Profile was last generated; why the Magisk module version stays 1.0.0;
  the two root causes of KI-28.
- **H, "not available":** the history before 1.2.1 is out of scope by the owner's decision (D-50).
- **I, owner-approved priorities:** "review round 12" is done. Removing the unused Room and Compose set-up
  moves from a recommendation to an approved item (P-12).
- **J:** `DECISIONS.md` now has 51 entries. No decision is UNDER_REVIEW.

