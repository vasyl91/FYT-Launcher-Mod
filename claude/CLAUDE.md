# Instructions for Claude: FYT Launcher Mod

A reverse-engineered home-screen launcher (`com.android.launcher66`) for FYT car head units. It runs on
Android 8–16 as a system app on FYT units (the `system` flavor) or as a normal app anywhere (the
`standard` flavor). It is written in Java with some Kotlin, built with Gradle, and has JVM unit tests only.

This file is imported by the root `CLAUDE.md`. Paths in it are relative to `claude/`, except those starting
with `../` (the repository root), `app/`, `.github/` or another top-level folder. The folder name is
lower case: `claude/`. On Linux (cloud sessions, CI) `Claude/` would be a different folder.

## Read first

1. **[`PROJECT_STATE.md`](PROJECT_STATE.md)** is the authoritative entry point: where the project stands,
   what is blocked and what comes next. Read it before any substantial work.
2. [`ARCHITECTURE.md`](ARCHITECTURE.md): modules, subsystems and the classes behind them.
3. [`DECISIONS.md`](DECISIONS.md): owner decisions you must not undo without asking.
4. [`KNOWN_ISSUES.md`](KNOWN_ISSUES.md) and [`ROADMAP.md`](ROADMAP.md): open problems and plans.
5. [`prompts/README.md`](prompts/README.md): the catalogue of implementation briefs and their status.
6. [`chat_archive/README.md`](chat_archive/README.md): the index of reports from earlier conversations.
   Read a report when you work on its topic.

**Check before you rely on a document.** These files describe the code at the date each one states. Before
you decide something or change code, confirm the statement you depend on in the current code or in git. If
the code and a document disagree, the code is right: fix the document in the same commit and say so.

User-facing documentation stays outside this folder: [`README.MD`](../README.MD),
[`vdhost/README.md`](../vdhost/README.md), [`baselineProfile/README.md`](../baselineProfile/README.md),
[`canbus_library/README.md`](../canbus_library/README.md).

Status tags used in all of these files: **[V]** verified in code or git · **[H]** historical, stated by the
owner, a brief or a chat report · **[P]** planned, not built · **[A]** assumed · **[U]** unknown. Never
present [A] as [V]. A report that says something was implemented is [H] until a commit or the code shows it.

## Commands

```bash
./gradlew :app:testSystemDebugUnitTest      # JVM unit tests (run before every push)
./gradlew :app:assembleSystemDebug          # system flavor, debug
./gradlew :app:assembleStandardDebug        # standard flavor, debug
./gradlew :vdhost-server:magiskZip          # FYT VDHost Magisk module -> vdhost/server/build/outputs/magisk/
```

- Release variants are `systemRelease` and `standardRelease`. Output files are named
  `<flavor>_<buildType>_<version>.apk`.
- Cloud sessions usually have no Android SDK, so CI (`.github/workflows/build.yml`) is the build check.
  It runs the unit tests, both debug builds and the Magisk zip on every push. Read its result with the
  GitHub MCP tools (`actions_list`, `get_job_logs`).
- Without an SDK you can still test plain-Java classes with `javac` and the JUnit console jar. That checks
  those classes only; it is not a build.
- To regenerate the CAN bus library, run `build_canbus_library.py --launcher .` (see
  `canbus_library/README.md`). A rebuild must give the committed assets byte for byte unless the sources
  changed. The Baseline Profile procedure is in `baselineProfile/README.md` and needs a device.

## Branch and commits

- Work only on `testBranch`. Start with `git pull origin testBranch`. Never open a pull request unless asked.
- Commits are in English. The subject is `<Area>: <what changed>`, e.g. `Bars: the vertical bar on every page`.
  The body is wrapped at ~72 characters and says *why*, with the facts behind the change.
- One step, one commit. Every commit builds and passes the tests on its own.
- After each push, wait for green CI before the next commit. Fix a red build with a new commit. Never use
  `--amend` and never force-push. If the branch moved, merge or fast-forward; do not undo the owner's commits.
- End commits with the trailers from the session's system reminder, exactly as given.
- **Never write a model name or model ID in repository content** (code, comments, docs, commit subjects and
  bodies). The trailer lines the session requires are the one exception.

## Coding rules (repeated in every brief; they still hold)

- **StrictMode is on in release builds too and must stay silent.** The main thread must not do:
  - file or asset I/O (`SharedPreferences.apply()`, never `commit()`);
  - database work, `ContentResolver` calls or network access;
  - `su` calls or blocking calls into the VD host.
- **Put logic in plain Java classes without `android.*`, with JUnit 5 tests** in `app/src/test/java/…`
  (`unitTests.isReturnDefaultValues = true`). Good examples: `BarLayoutTest`, `CustomLayoutResolverTest`,
  `WorkspaceLoadWatchTest`, `FuelModelTest`.
- **When a change sets up a rule** (e.g. "touching rectangles do not overlap"), write it in the Javadoc of the
  class that enforces it.
- Comments, Javadoc and `Log.*` messages are in English: full sentences that explain *why*.
- **Strings:**
  - A new string goes into **all 59** `res/values*/strings.xml` files, translated.
  - When the meaning of a string changes, add a new key and remove the old one everywhere.
  - (This rule replaced an older "English only" one on 2026-11-07.)
- **Preference keys keep their stored values** even when the constant is renamed (`Keys.java`), e.g.
  `HORIZONTAL_BAR_EVERY_PAGE` is still `"bottom_bar_every_page"`. Do not migrate users' preferences
  unless a brief says so.
- **Never do arithmetic on an `R.*` id** (`R.drawable.x + n`). The ids shift whenever a resource is added
  or removed; `ResourceIdArithmeticTest` guards this.
- No resource ids in `switch`/`case` (they are not constants with this AGP).
- No new dependencies without the owner's approval.
- Delete code or resources only after an `rg` search of the whole repository (excluding `claude/` and
  `archive/`) shows nothing else uses them.
- Large files (`Launcher.java`, `Workspace.java`, `SettingsFragment*`, `LogcatWorker`, `CanbusService`)
  get targeted edits only. No drive-by refactors.
- Do not touch:
  - `archive/` (the decompiled FYT apps, `fuel_stats_example/`, old `android.jar` material): reference
    only, read it, never edit it. Run rename or replace scripts with `archive/` excluded;
  - `android_jar/android-36.jar`: two modules compile against it (`KNOWN_ISSUES.md` KI-19);
  - `app/src/main/generated/baselineProfiles/`, except removing lines for classes you delete. The owner
    regenerates it on a device;
  - `keystore.properties`: do not read or print it.
- In a code review, skip `Callback_*.java` in `com/syu/module/canbus` and the folders `com/syu/canbus/warn`
  and `com/syu/ui` unless the task is about them (owner's rule, `DECISIONS.md` D-35).

## Devices: the first principle

Nothing may change on the owner's **FYT 7862** (Android 10, system flavor) unless the task is about it. Most
work targets the other units and phones. Platform-dependent behaviour follows the decisions in
`DECISIONS.md` (by chipset vs by installed package). The device matrix is in `PROJECT_STATE.md`.

Two product rules come up in almost every task (details in `DECISIONS.md`):

- The launcher never undoes what the user did: an app the user opened stays in front, and no app gets
  special treatment by name (D-28).
- The launcher never changes a setting the user made in the system, such as the navigation app (D-29).

## How Opus and Sonnet work together

The loop has been in use since 2026-10-26:

1. When the owner's logs need sifting first, **Sonnet** extracts the facts and log excerpts for Opus into
   `claude/prompts/active/` (`opus-logs-YYYY-MM-DD-<topic>.md`, `opus-analysis-…`).
2. **Opus (planning)** checks those facts and the owner's requests against the code, then writes a brief
   in Polish to `claude/prompts/active/sonnet-prompt-YYYY-MM-DD-<topic>.md`. Every brief:
   - starts with a review of the previous round, including the owner's device result;
   - lists its commits with their exact subjects;
   - gives the facts, the rules, what not to change, how to verify, and the report to write.

   **Update the catalogue first:** add the brief's row to `prompts/README.md` in the same commit
   (`Docs: brief for …`).
3. **Sonnet (implementation)** implements the brief in `prompts/active/` commit by commit, with the subjects
   it gives:
   - never edit the brief;
   - report every deviation and its reason in the final report, written as the brief asks;
   - say plainly what was not tested on a device; do not report an untested change as working;
   - if a commit changes something `ARCHITECTURE.md` describes, update that file in the same commit.
4. **The owner** tests on the devices and sends the logs.
5. The next brief records the result. Then Opus:
   - moves the finished brief and its analyses to `prompts/archive/` (and `archive/analysis/`) with `git mv`;
   - sets its status in the catalogue;
   - updates `PROJECT_STATE.md`, and `ROADMAP.md`/`DECISIONS.md`/`KNOWN_ISSUES.md` where the round changed them.

Both roles:

- Work from the code, not from memory of earlier chats. A line number in a brief is approximate; check it in
  the code.
- Archived briefs and chat reports are history: do not edit them. Where an old brief or report contradicts
  the current docs (old flavors `fyt`/`phone`, branches `main-6mxprj` and `ccr-…`, "bottom/left bar"), the
  current docs win.
- A proposal made in a conversation is not a decision. Only the owner's stated choice goes into
  `DECISIONS.md` as an owner decision.

## After significant changes

Update the docs in `claude/` that the change makes wrong, in the same commit or as the last `Docs:` commit
of the round. Update `README.MD` when a user-visible feature or setting changes; the briefs have done this
with `Docs: README for …` commits. When a conversation ends, its report can be added to `chat_archive/`
with the template there; update the index in the same commit.
