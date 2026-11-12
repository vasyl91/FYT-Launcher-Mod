# Chat archive

## Purpose

Before 2026-10-26, and alongside the brief workflow, the project was discussed in **18 older Claude
conversations**. Their history is not in the repository and cannot be read by a new session. This folder
keeps one structured report per conversation, so that requirements, decisions, rejected approaches and
problems solved there survive.

The two current conversations (the Opus planning one and the Sonnet implementation one) left their work in
git and in `../prompts/`. Reports for them are optional (`CHAT_19.md`, `CHAT_20.md`).

## Adding a report

1. Open the old conversation and paste the prompt from
   [`CHAT_EXTRACTION_TEMPLATE.md`](CHAT_EXTRACTION_TEMPLATE.md), the part between the lines.
2. Save the answer as `CHAT_NN.md` in this folder (`CHAT_01.md` … `CHAT_18.md`, two digits). Fill in the
   header fields the template asks for. Keep the conversation's answer as it is; do not edit its claims.
3. Update the tracking table below: the subject and status `extracted`.
4. Incorporating a report is a separate step, by a Claude session:
   - check each claim against the code and git;
   - move what holds into `../DECISIONS.md`, `../ARCHITECTURE.md`, `../KNOWN_ISSUES.md` or `../ROADMAP.md`,
     citing `CHAT_NN`;
   - set the status to `incorporated` and list the files that changed.

## Historical vs verified

A report says what a conversation **said**, not what the code **does**. Everything taken from a report is
**[H] historical** until a session checks it:

- confirmed in the current code or git → cite as [V] with the file or commit, plus `CHAT_NN` as the source of
  the reason;
- contradicted by the code → record the contradiction (usually the code changed later); do not "fix" the code
  to match an old chat;
- impossible to check (a reason, a rejected idea, a device test) → keep as [H] with `CHAT_NN` as the source;
- a report's "Suggestions" and "Unverified claims" sections never become [V] by themselves.

Never fabricate a report for a conversation that has not been supplied.

## Tracking table

| Chat | Main subject | Extraction status | Report | Incorporated into docs |
|---|---|---|---|---|
| CHAT_01 | — | not started | — | no |
| CHAT_02 | — | not started | — | no |
| CHAT_03 | — | not started | — | no |
| CHAT_04 | — | not started | — | no |
| CHAT_05 | — | not started | — | no |
| CHAT_06 | — | not started | — | no |
| CHAT_07 | — | not started | — | no |
| CHAT_08 | — | not started | — | no |
| CHAT_09 | — | not started | — | no |
| CHAT_10 | — | not started | — | no |
| CHAT_11 | — | not started | — | no |
| CHAT_12 | — | not started | — | no |
| CHAT_13 | — | not started | — | no |
| CHAT_14 | — | not started | — | no |
| CHAT_15 | — | not started | — | no |
| CHAT_16 | — | not started | — | no |
| CHAT_17 | — | not started | — | no |
| CHAT_18 | — | not started | — | no |
| CHAT_19 (optional) | current Opus planning conversation | not started | — | no |
| CHAT_20 (optional) | current Sonnet implementation conversation | not started | — | no |

Statuses: `not started` → `extracted` → `incorporated` (or `nothing new`).

## A hint for matching: Claude Code sessions in the git history

Commits made with Claude Code carry a `Claude-Session` trailer. These sessions are **not necessarily** the 20
conversations: some of those may be claude.ai chats without commits [A]. The table may still help you date a
conversation and find its commits (`git log --grep=<session id>`). Counts are commits; "Opus" and "Sonnet"
come from the commit co-author line.

| First → last commit | Commits | Commits by role | Session | First commit of the session |
|---|---|---|---|---|
| 2026-10-05 → 10-06 | 24 | Opus: 24 | `session_01XJFQ2J9hp7tXEzML48Cd3Z` | Weather by distance/age, wake and bind fixes from device logs |
| 2026-10-12 | 10 | Opus: 10 | `session_019ijirifzjb1fxfQDDxkApX` | Wake: every signal, for the whole process |
| 2026-10-13 → 10-19 | 139 | Opus: 139 | `session_019sm7LnhdFzQAC5is3J8b4E` | Add FYT VDHost: Android 11+ replacement for ActivityView panes |
| 2026-10-26 | 60 | Sonnet: 60 | `session_01R6kYaADc9PqUwyUMcsFB7F` | Polish English strings and drop unused ones (the translations) |
| 2026-10-26 → 10-28 | 52 | Opus: 19, Sonnet: 33 | `session_01QUq7jCJ1Ck7Wotj3zNQQUs` | Add log analysis brief for Launcher66 logs of 2026-10-26 |
| 2026-10-28 | 19 | Opus: 2, Sonnet: 17 | `session_0142a81ECW5Abkr9EArb3fBY` | docs: brief for the chipset-based device identity … |
| 2026-10-28 | 1 | Opus: 1 | `session_0142a81FB52cB8MraNzBwcR3` | Pinned PiP: the launcher takes the focus back when it is touched |
| 2026-10-28 | 6 | Opus: 3, Sonnet: 3 | `session_0142a81FjuUhN4N8Ur5Y6kPX` | docs: brief for removing the Cling leftovers |
| 2026-10-28 → 11-02 | 55 | Opus: 18, Sonnet: 37 | `session_0142a81G9yq8pk8VbFqyTyoB` | docs: brief for the canbus requests table … |
| 2026-10-30 → 11-01 | 3 | Opus: 1, Sonnet: 2 | `session_0142a81DHyCgzXndvQ5SeamD` | Bars: slot count follows the room the icons need |
| 2026-11-01 | 4 | Opus: 4 | `session_0142a81EfUoMoFWvZEKrQ67q` | Merge branch 'ccr-087eed00-gbqsuz' into testBranch |
| 2026-11-01 | 1 | Sonnet: 1 | `session_0142a81FzpAH7VQUdn5b6uE2` | Fall back to Android settings when com.syu.settings is missing |
| 2026-11-02 → 11-04 | 29 | Opus: 5, Sonnet: 24 | `session_0142a81EpifZuFpaBxCecTPR` | Docs: brief for the screens and the custom elements planned by the model |
| 2026-11-02 | 9 | Opus: 1, Sonnet: 8 | `session_0142a81DsEDFR79QsCmvxnzc` | Docs: Sonnet prompt for widget trimming, text fit and bar layout resolution |
| 2026-11-05 → 11-08 | 16 | Opus: 16 | `session_0142a81Eq3Gq9xVgbLZQ1kRV` | Docs: brief for com.syu.media covers and hearts … (probably the current Opus planning conversation [A]) |
| 2026-11-05 → 11-08 | 75 | Sonnet: 75 | `session_0142a81ESLme1Sb2pFN966C6` | Build: the fyt flavor is now system (probably the current Sonnet implementation conversation [A]) |

Also: 14 Opus commits from 2026-10 have no session trailer, and 275 commits have no Claude trailer at all.
The latter are the owner's own work, plus the external PRs #4–#7 (2026-07/08).
