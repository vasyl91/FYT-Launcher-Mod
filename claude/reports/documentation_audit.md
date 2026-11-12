# Documentation audit (2026-11-10, updated 2026-11-12)

> **Latest verification: 2026-11-12.** The audit of 2026-11-10 below is kept as written (the owner later
> changed its folder name from `Claude/` to `claude/` in the text). The addendum at the end records what
> the second pass found and changed. Where the two disagree, the addendum holds.

An audit of the project's documentation, and the reorganisation that followed it, approved by the owner on
2026-11-10.

## Before the audit

| Location | Content | Assessment |
|---|---|---|
| `docs/` (37 files, about 1.1 MB) | 33 implementation briefs `sonnet-prompt-*.md` (Polish), 2026-10-27 → 11-08; 4 analyses (`log-analysis-2026-10-26.md`, `canbus-app-comparison-2026-10-30.md`, `opus-analysis-2026-11-03-…`, `opus-logs-2026-11-07-…`) | All implemented (see `../prompts/README.md`). They held owner decisions, the device and platform maps, and the working rules found nowhere else. No index, and no way to tell done from pending |
| `README.MD` | User-facing features, installation, supported devices, versions and updates, fuel statistics guide, debugging, building | Accurate, except the bar features of 2026-11-08 (fixed, see below) |
| `vdhost/README.md` | VD host design, protocol, daemon, troubleshooting, the Android 8–10 test checklist | Accurate (protocol 3/2 matches the code) |
| `baselineProfile/README.md` | Generating and deploying the Baseline Profile | Accurate as far as can be checked without a device |
| `canbus_library/README.md` | The library script and file format v4 | Accurate |
| `decompiled_carinfo/README.md` | Why the decompiled carinfo is kept | Accurate |
| `MagiskWiFiADB.MD` | ADB over Wi-Fi on Android 10 with Magisk | Kept, linked from README |
| `CLAUDE.md` | — | **Did not exist**, and never had in git history |
| A state, architecture, decisions, roadmap or issues document | — | **Missing** |

## Contradictions found

1. **README vs code.** README described the auto-hide handle only on the left edge with a swipe to the right.
   It did not mention:
   - the horizontal bar at the top;
   - the vertical bar on the right or on every page;
   - the handle on the right edge;
   - the Bars category.

   All of these exist since `9bc0faa5`, `5604d116` and `6080ce99` (2026-11-07/08). **Fixed** by a short README
   update.
2. **Briefs vs later briefs.** Each brief was right when written; later briefs changed:
   - the string rule: English only (2026-10-28) → all 59 files (2026-11-07);
   - the flavor: `fyt` → `system` (2026-11-05);
   - the CI task: `testFytDebugUnitTest` → `testSystemDebugUnitTest`;
   - the bars: bottom/left → horizontal/vertical (2026-11-07);
   - the branch: `ccr-087eed00-gbqsuz` → `testBranch` (2026-11-01);
   - the rule for pinned PiP: by music package (2026-10-27 E3) → by chipset (2026-10-28).

   **Resolution:** the archived briefs stay unchanged as history. `../CLAUDE.md` and `../DECISIONS.md` state
   the current rule and say that it replaced the old one.
3. **`log-analysis-2026-10-26.md` vs brief #1.** The analysis was written from grep alone; brief #1
   confirms or refutes each item and says it wins where they differ. Nothing to fix; this is noted in the
   catalogue.
4. **The briefs' own links** say `docs/<name>.md`, which moved. Noted in `../prompts/README.md`; the files
   were not edited.

No contradiction was found between `vdhost/README.md`, `baselineProfile/README.md`,
`canbus_library/README.md` and the code where they could be compared (protocol versions, module names, file
format version, build tasks).

## Changes made

The owner's decisions on 2026-11-10:

- everything for Claude goes in one folder, `claude/`;
- the last brief is archived;
- English for the new documents;
- a short README update;
- the briefs' new location, with the catalogue updated together with each brief;
- commit and push.

**Created**
- `CLAUDE.md` (repository root): a five-line stub. Claude Code loads project instructions only from the
  root `CLAUDE.md` or from `.claude/`, so this one file stays at the root. It imports `claude/CLAUDE.md`.
- `claude/CLAUDE.md`, `PROJECT_STATE.md`, `ARCHITECTURE.md`, `DECISIONS.md`, `ROADMAP.md`, `KNOWN_ISSUES.md`.
- `claude/prompts/README.md` (the catalogue) and `claude/prompts/active/.gitkeep`.
- `claude/chat_archive/README.md` and `CHAT_EXTRACTION_TEMPLATE.md`.
- `claude/reports/implementation_audit.md` and this file.

**Moved** with `git mv`, contents unchanged:
- `docs/sonnet-prompt-*.md` (33) → `claude/prompts/archive/`;
- the four analyses → `claude/prompts/archive/analysis/`;
- `docs/` no longer exists.

**Modified**
- `README.MD`: the auto-hide line and one new line on the bar positions, the Bars category and the vertical
  bar on every page.

**Deleted:** nothing. **Recommended for deletion:** nothing. All the old material is either history the owner
wants kept (`docs/`) or reference material by the owner's rules (`decompiled_*`, `fuel_stats_example/`,
`android_jar/`). KI-07 and R-5 leave the size question to the owner.

## Remaining gaps

- **Knowledge older than 2026-10-26** (the project's original objectives, early design choices, what each
  1.x release added) is not in the repository. It must come from the 18 older conversations
  (`../chat_archive/`) or from the GitHub release notes.
- **Reasons not recorded** for some decisions: revert `b38f1286`; the OpenWeather key never moved; the Room
  and Compose dependencies. Listed in `implementation_audit.md` → "Unresolved questions".
- **Device results** for most rounds appear only in the next brief's review section, in Polish. The catalogue
  does not repeat them.

## Open questions

Add here any contradiction found while incorporating chat reports (see
`../chat_archive/CHAT_EXTRACTION_TEMPLATE.md`), with the evidence on both sides.

Recorded on 2026-11-12 (details in `KNOWLEDGE_CONSOLIDATION_REPORT.md`, section E):

- **Resolved by the owner on 2026-11-12:** `b38f1286` reverted the 7862 stats-window fix because it did not
  work as it should; the state after the revert is acceptable (CHAT_10 had said the fix was untested).
- **Open:** CHAT_14 quotes the owner that changes worked "za wyjątkiem tych z urządzenia 7870". The owner,
  2026-11-12: the tester did not say which; a reply is awaited.
- **Resolved:** the key, the location reason, the device ownership, and planned-versus-implemented for round
  12 (see the addendum below).

## Keeping the documentation healthy

- `PROJECT_STATE.md` is updated at the end of every round, by the planning session (`../CLAUDE.md`).
- A brief's catalogue row is added in the same commit as the brief, and its status changes when it is
  archived.
- A user-visible change gets a `Docs: README for …` commit, as the briefs already did.
- Use the tags [V]/[H]/[P]/[A]/[U] everywhere; an [A] becomes [V] only with a file or commit as evidence.

---

## Addendum: second pass of 2026-11-12

### What the first pass got wrong or could not know

| 2026-11-10 | 2026-11-12 |
|---|---|
| The chat archive was set up for "18 older conversations" with files `CHAT_NN.md` | The owner supplied 15 reports, `CHAT_01.MD` … `CHAT_15.MD`. The index now describes the files that exist and assumes no number |
| "Recommended for deletion: nothing … `android_jar/` (obsolete)" | Wrong about `android_jar/`: the build needs `android-36.jar`. See `implementation_audit.md`, addendum, and KI-19 |
| `KNOWN_ISSUES.md` rated the hardcoded weather key High | The owner had decided to keep it (D-26). Now an accepted limitation |
| `DECISIONS.md` had 26 entries, some with "reason not recorded" | 49 entries with a status and who decided; the reports supplied several reasons |
| Knowledge before 2026-10-26 "is not in the repository" | The reports cover 2026-10-05 → 11-08. What each 1.x release added is still only in the GitHub release notes |

### Problems found in the documentation itself

1. **Two folders on Linux.** The rename to lower case was made on a case-insensitive file system, so git
   tracked `Claude/` (49 files) and `claude/` (15 files), and the root `CLAUDE.md` imported
   `@claude/CLAUDE.md`, which did not exist on Linux. A cloud session would have loaded no project
   instructions. **Fixed** in `e3ba694e`: all 49 files moved to `claude/` with `git mv` (contents unchanged).
2. **Stale paths** after the move to `archive/`: the repository layout in `ARCHITECTURE.md`, the "do not
   touch" list in `CLAUDE.md`, four links in `README.MD`, and the library script and its README. **Fixed.**
3. **State out of date:** CI status, commit counts, device ownership. **Fixed** in `PROJECT_STATE.md`.
4. **Confirmed and unconfirmed mixed** in `KNOWN_ISSUES.md`. **Fixed:** three parts (confirmed, accepted,
   unverified).

### Changes made on 2026-11-12

**Moved (`git mv`, byte-identical):** `Claude/*` → `claude/*`: the six core documents, both indexes, the
template, the 37 prompt files and both reports.

**Updated:**
- `claude/CLAUDE.md`, `PROJECT_STATE.md`, `ARCHITECTURE.md`, `DECISIONS.md`, `ROADMAP.md`, `KNOWN_ISSUES.md`;
- `claude/prompts/README.md` (path map, device results on record, superseded instructions, the brief that
  is not in the repository);
- `claude/chat_archive/README.md` (rewritten from the files present) and `CHAT_EXTRACTION_TEMPLATE.md`
  (file name, plain-text rule);
- `claude/reports/implementation_audit.md` and this file (addenda);
- outside `claude/`, with the owner's approval: `README.MD` (four links), `canbus_library/README.md` and
  `canbus_library/build_canbus_library.py` (source root).

**Created:** `claude/reports/KNOWLEDGE_CONSOLIDATION_REPORT.md`.

**Not modified:** the 15 chat reports, the 33 archived briefs, the 4 archived analyses, and all application
code, manifests, resources, Gradle files and workflows.

**Deleted:** nothing.

### Remaining gaps

- What each release before 1.2.1 added. The owner decided on 2026-11-12 not to reconstruct it (D-50), so
  this is no longer a gap to fill.
- The stock-sources brief of 2026-10-23 and its 7870 test guide (a local commit that was never pushed). A
  session note about the work was supplied by the owner and stored as
  `../prompts/archive/analysis/memory-2026-10-26-stock-sources-7870.md`.
- Device results for the rounds listed as "none on record" in `../prompts/README.md`.
- The open questions in `implementation_audit.md`, addendum.

