# Chat extraction template

How to use it:

1. Copy everything between the two lines below into the old conversation, as one message.
2. Save the answer as `CHAT_NN.md` in this folder.
3. Update the tracking table in `README.md`.

The answer is a historical record: it is checked against the code later, not edited to fit it.

---

**Request: an archive report of this conversation for the FYT Launcher Mod project**

The project (`vasyl91/FYT-Launcher-Mod`) is building a knowledge base so that future sessions do not depend on
the memory of individual conversations. Please write a report of **this conversation only**, in English, in the
exact format below.

Don't continue the previous task if anything is unfinished, and don't modify any files. Just generate an archive 
report of this conversation.

Rules. Please follow them strictly:

1. **Use only what is in this conversation.** Do not add knowledge about the project from anywhere else, and
   do not guess what happened after the conversation ended.
2. **Do not invent.** If something is unclear or was never settled, say so. "Not discussed" is a valid answer
   for any section.
3. **Do not claim that code was changed unless the conversation shows it.** Shown means a commit hash, a diff,
   a tool result or the user's confirmation. A plan, a suggestion or code you wrote in a reply is not a
   change; mark it as a suggestion.
4. **Label every item** with exactly one of:
   - **[Confirmed]**: established in this conversation by evidence (code shown, a tool result, a log, the
     user's confirmation that it works or was done);
   - **[Historical]**: a statement of fact or a decision by the user (the owner), not checked further here;
   - **[Suggestion]**: a proposal made in this conversation, by you or the user, with no sign it was carried
     out;
   - **[Unverified]**: a claim made here without evidence, including your own earlier assumptions.
5. Quote the user's own words where a decision or requirement matters (short quotes, in their original
   language).
6. Give file paths, class names, commit hashes, branch names, dates and device names exactly as they appear.
   Write "unknown" rather than reconstructing them.
7. Do not include secrets (API keys, tokens, passwords) even if they appear in the conversation. Write
   "[secret omitted]".

Format:

```markdown
# CHAT_NN — <one-line subject>

| Field | Value |
|---|---|
| Conversation title | <as shown, or unknown> |
| Approximate dates | <first and last message, or unknown> |
| Model / role | <e.g. planning, implementation, analysis, or unknown> |
| Repository branch(es) mentioned | <or none> |
| Report written | <date> |

## 1. Aspect of the project discussed
## 2. Work performed
(What was actually done, with its evidence. Separate done from only planned.)
## 3. Requirements discovered
## 4. Architectural and technical decisions
(For each: the decision, the reason given, who decided, the label.)
## 5. Rejected decisions and why
## 6. Problems encountered and their solutions
(Symptom → cause → solution → whether the solution was confirmed to work.)
## 7. Features implemented or discussed
(Name, state: implemented / partly / discussed only, the label.)
## 8. Important constraints
(Devices, Android versions, permissions, firmware, owner's rules.)
## 9. Unresolved questions
## 10. Information that may be missing from the repository
(Reasons, measurements, device results, owner preferences that would not be visible in the code.)
## 11. Relevant file paths and references
(Files, classes, commits, logs, external links, exactly as mentioned.)

## Summary by label
- Confirmed: <count>, Historical: <count>, Suggestion: <count>, Unverified: <count>
```

---

## Notes for the session that incorporates a report

- Read `README.md` → "Historical vs verified" first.
- A "[Confirmed]" in a report means "confirmed in that conversation", which may be months old. Check it again
  in the current code before calling it [V] in the docs.
- Where a report contradicts the current docs, do not silently overwrite either. Record the contradiction
  and the evidence on both sides in `../reports/documentation_audit.md` (section "Open questions"), and ask
  the owner when it matters.
