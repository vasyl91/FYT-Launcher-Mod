# Documentation audit (2026-11-10)

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

- everything for Claude goes in one folder, `Claude/`;
- the last brief is archived;
- English for the new documents;
- a short README update;
- the briefs' new location, with the catalogue updated together with each brief;
- commit and push.

**Created**
- `CLAUDE.md` (repository root): a five-line stub. Claude Code loads project instructions only from the
  root `CLAUDE.md` or from `.claude/`, so this one file stays at the root. It imports `Claude/CLAUDE.md`.
- `Claude/CLAUDE.md`, `PROJECT_STATE.md`, `ARCHITECTURE.md`, `DECISIONS.md`, `ROADMAP.md`, `KNOWN_ISSUES.md`.
- `Claude/prompts/README.md` (the catalogue) and `Claude/prompts/active/.gitkeep`.
- `Claude/chat_archive/README.md` and `CHAT_EXTRACTION_TEMPLATE.md`.
- `Claude/reports/implementation_audit.md` and this file.

**Moved** with `git mv`, contents unchanged:
- `docs/sonnet-prompt-*.md` (33) → `Claude/prompts/archive/`;
- the four analyses → `Claude/prompts/archive/analysis/`;
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

- *(none yet)*

## Keeping the documentation healthy

- `PROJECT_STATE.md` is updated at the end of every round, by the planning session (`../CLAUDE.md`).
- A brief's catalogue row is added in the same commit as the brief, and its status changes when it is
  archived.
- A user-visible change gets a `Docs: README for …` commit, as the briefs already did.
- Use the tags [V]/[H]/[P]/[A]/[U] everywhere; an [A] becomes [V] only with a file or commit as evidence.
