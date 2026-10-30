# canbus_library

Builds a **canbus library** for the FYT launcher: for every car id, the class of the screen FYT's canbus app opens
(`com.syu.canbus`) and, for the cars that need it, the **requests** the fuel/range screens send when they open.

## 1. What it is and why you may want to build one

The launcher ships with a library made from the `com.syu.canbus` it was developed against. Fuel statistics uses it to

* name the class that serves your car (the summary under *Fuel statistics*, and where to look for the codes), and
* send your car the request its original fuel screen sends when it opens. Most canbus boxes report fuel consumption and
  range on their own; only some wait for that request. For such cars (and only for them) the launcher shows the
  *cmdInt* / *cmdArr* fields in the *Canbus codes* window, and sends the request after connecting and after waking up.

A newer or different build of `com.syu.canbus` may know cars the shipped library does not, or map a car id to another
class. In that case build a library from **your own** decompiled `com.syu.canbus` and import it in the launcher. Your file
is merged with the built-in library per car id: cars missing from yours stay as they were, identical records are skipped
as duplicates, and for the same car id **your file wins**.

## 2. Requirements

* Windows 10 or 11 (any system with Python 3 works; the `.bat` is for Windows).
* Python 3.8 or newer from <https://www.python.org/downloads/>. Tick **Add python.exe to PATH** in the installer
  (the `py` launcher is installed with it).
* A decompiled `com.syu.canbus`: the folder `...\javaCode\classes.dex\sources`. How to get it is described in steps 10-12
  of the main [README](../README.MD) (export the APK, unpack it with APKRepatcher).

## 3. Step by step

1. Download the `canbus_library` folder (keep `build_canbus_library.bat` and `build_canbus_library.py` together).
2. **Drag your `sources` folder onto `build_canbus_library.bat`**, or open `cmd` in the folder with the files and run:

   ```
   build_canbus_library.bat "C:\APKRepatcher\Projects\com.syu.canbus.apk\javaCode\classes.dex\sources"
   ```

   (Without an argument the file asks for the path.)
3. Read the summary:

   | line | meaning |
   |---|---|
   | `Mapping: ... (method launchCanbus)` | the file and method the car id to class mapping was read from |
   | `IDs in the mapping` | car ids found in the `switch` |
   | `C records` | lines and car ids with a class (portrait / firmware variants are counted separately) |
   | `R records` | car ids that have fuel pages with requests, groups of cars sharing the same pages, distinct pages |
   | `Requests` | calls it could not represent (not a literal number) and were skipped |
   | `Groups with an ambiguous main page` | groups where two pages looked equally like the first one; the first of them is used |
   | `main page changed by the fuel rule` | groups of cars whose first page is another one because of the fuel and electric-car rules (section 7) |
   | `Warnings` | conditions it did not understand (treated as false) and labels it could not resolve |

4. The result is `canbus_library_<date>_<time>.txt` in the folder you ran the file from; the last line printed
   (`Written: ...`) is its full path. Use `--out FILE` to choose another name.

## 4. Moving the file to the radio and importing it

Copy the file to the radio: a USB stick, a cloud drive, or `adb push canbus_library_....txt /sdcard/Download/`.

In the launcher open *Settings > Layout creator > Canbus reader* (the group appears when *Display Canbus reader* is on) and tap
**Import a canbus library**; pick the file. A progress window shows the phase (validation, merging, saving) and the line
being read. **Cancel** stops the import without changing anything (until saving starts, then the button is disabled);
**Run in background** closes the window and shows a toast when it is finished. A dialog (or the toast) tells you the result and where the report is.

The report is saved to `Download/Launcher66_Logs` as `canbus_library_success_<date>.txt` or `canbus_library_failed_<date>.txt`
(if that folder is not available, the full path is shown). It lists the file, the result, how many records were new,
skipped as duplicates or replaced (with the old and the new value), the numbers of cars before and after and, for a rejected
file, every error with its line number.

A file is accepted only as a whole: if a single line is wrong, nothing is imported. **Remove the imported libraries** returns to the built-in one.

**Export a library.** *Export the canbus library* (the same group) saves the library the launcher really uses, the built-in one merged with everything
imported, to `Download/Launcher66_Logs` as `canbus_library_export_<date>_<time>.txt` (a toast shows the full path, or the reason it failed). It is a valid
library file (a comment after the header says when it was written), so `--check` accepts it and it can be imported on another radio.

To compare it with another library, for example the built-in one of a newer launcher, copy the export to the PC and run

```
py build_canbus_library.py --diff canbus_library_export_....txt app/src/main/assets/canbus_library.txt --ids 1507667
```

(*only in A* is what only the radio has, *only in B* what only the other library has, *different* what both have but not the same; `--ids` prints the whole state of a car in both).
To see what an import would do before you do it, `--merge <base> <file>` gives the result and the numbers of new, duplicate and replaced records.

## 5. Troubleshooting

* **`mapping not found`**: the script could not find `ActivityLauncher.java` with `switch (DataCanbus.DATA[1000])`. Point it at the file:
  `build_canbus_library.bat "<sources>" --mapping "<sources>\com\syu\canbus\ActivityLauncher.java"`.
* **Python was not found**: install it from python.org (see section 2) and run the file again. If only the Microsoft Store stub is present, install the real Python.
* **Import rejected**: open the report in `Download/Launcher66_Logs`; it lists the errors with line numbers. Check the file on the PC with
  `build_canbus_library.bat --check canbus_library_....txt` (exit code 2 = invalid, the same rules as the launcher).
* **You edited the file by hand** (for example to add `N 123` for a car that must not get a request, or to fix a class name): run
  `build_canbus_library.bat --seal canbus_library_....txt` to recompute the footer (record count and CRC32), then import it.

Other modes of the script (`py build_canbus_library.py ...`):

```
py build_canbus_library.py <src> [--out FILE] [--mapping FILE]   from a decompiled com.syu.canbus
py build_canbus_library.py --launcher <repo> [--out FILE]        the library built into the launcher (its asset for the classes + decompiled_carinfo/)
py build_canbus_library.py --seal FILE                           recompute the footer of an edited file
py build_canbus_library.py --check FILE                          validate a file like the launcher does
py build_canbus_library.py --diff A B [--ids 1507667,163]        what differs between two library files
py build_canbus_library.py --merge BASE FILE [--out OUT]         BASE merged with FILE the way the launcher's import does
```

Exit code: 0 success, 1 bad input, 2 an invalid file in `--check`, `--diff` or `--merge`, 3 differences found by `--diff`.

* **`--diff A B`** checks both files like `--check`, then lists per car id what is only in A, only in B and different (A to B): `C` per car id,
  `R` per car id and page, `N` and `S` per car id, and the ids whose first page or order of pages differs. It prints the numbers, then
  up to 50 examples of each kind. `--ids 1507667,163` also prints the whole state of those cars (class, pages in order, codes) from A and from B.
  Use it to compare two libraries, for example the one you built with the built-in one, before importing.
* **`--merge BASE FILE`** writes `BASE` merged with `FILE` exactly like the import in the launcher (section 6, *Merging*), sealed, and prints how many
  records of each kind were new, duplicate and replaced. The default `--out` is `canbus_library_merged_<date>_<time>.txt`.

## 6. File format (version 2)

A UTF-8 text file. The first significant line is `canbus_library 2`. Files in version 1 (`canbus_library 1`, without `S` records) are still read, by the launcher and by `--check`. Empty lines and lines starting with `#` are ignored
(a BOM at the start is allowed). Records (fields are separated by `|`, spaces around fields are allowed):

```
C <ids> | <class>                                      screen class of the car
C <ids> | <class> | <alt> | portrait                   <alt> when the screen is in portrait (getConfiguration() == 1)
C <ids> | <class> | <alt> | fytver:<tok>[,<tok>...]    <alt> when /sys/fytver/fyt_bin_version contains one of the tokens
R <ids> | <page> | <req>[; <req>...]                   a fuel page and the requests it sends, in order
N <ids>                                                the car needs no request (switches off a false match)
S <ids> | <fuel> | <range>                             version 2 only: the codes of the car's fuel consumption and range
end <records> <crc32>                                  footer, the last significant line
```

* `<ids>`: decimal `int`s from 1 to 2147483647 separated by commas, 1-5000 of them, no repeats within a line.
* `<class>`, `<page>`: a full class name matching `com\.syu(\.[A-Za-z_$][A-Za-z0-9_$]*)+`, at most 200 characters.
* `<alt>`: the same, or `-` (then the car has no class when the condition is met).
* `<tok>`: `[A-Za-z0-9]{1,16}`, 1-8 tokens.
* `<req>`: `cmd` or `cmd:i,i,...`; `cmd` is 0..9999, each `i` is -65536..65536, at most 8 numbers. At most 8 requests in an `R` line.
  A request is what the original screen sends with `DataCanbus.PROXY.cmd(cmd, new int[]{i, ...}, null, null)`.

* `<fuel>`, `<range>`: the `DataCanbus.DATA` index the car reports the momentary fuel consumption and the range under,
  `0..1199` (the whole canbus module), or `-` if unknown. `S 5 | - | -` is an error ("nothing to say"). In a version 1 file an `S` is an error
  (`S records need version 2`).

**Consistency inside one file**

* one car id has at most one `C` record;
* `R` pages are unique per (id, page), at most 10 pages per id;
* `N` and `R` for the same id exclude each other;
* one car id has at most one `S` record;
* an identical record repeated is a *duplicate* (skipped and counted), a contradicting one is an error.

**Footer.** `<records>` is the number of `C`/`R`/`N`/`S` lines. `<crc32>` is 8 lowercase hex digits: the CRC-32
(Java `java.util.zip.CRC32` = Python `zlib.crc32`) over the UTF-8 bytes of all lines from the header line up to and including the line
before `end`, each line without its `\r`/`\n` and followed by one `\n` (a BOM is not counted). Only empty lines may follow `end`.

**A file is valid only as a whole.** The import collects all errors (up to 200, each with a line number and a reason) and fails if there is even one.
Limits: 2 MB and 200 000 lines.

**Merging** `base + file` (the built-in library + the imported one, and a previous import + a new one). Every record of the file counts exactly once
as *new*, *duplicate* or *replaced*:

* `C`, per car id: not in the base = new; identical = duplicate; different = replaced (the file wins).
* `R`, per (id, page): not in the base = new; same requests = duplicate; different requests = replaced. The pages of an id are ordered
  with the pages of the file first (in the file's order), then the pages of the base that the file does not mention.
  If the base has `N` for that id, the `N` is dropped.
* `N`, per id: the base has `N` = duplicate; the base has `R` pages = replaced (the pages are dropped); otherwise new.
* `S`, per car id: not in the base = new; identical = duplicate; different = replaced (the file wins; the report shows the old and the new value).
* Records for different car ids never affect each other.

Example (the footer values are only an example; the script computes the real ones):

```
canbus_library 2
C 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi
C 274 | com.syu.carinfo.accord.ActivityAccord7Index | com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi | portrait
R 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti | 70:51; 29:0
R 19 | com.syu.carinfo.honda.HondaTripActi | 100:1; 100:3
N 1
S 163,221 | 102 | 103
end 6 1a2b3c4d
```

## 7. How the script decides

* **The launcher's own library (`--launcher`).** The classes are not simulated: the `C` and `N` records are taken, unchanged, from
  `app/src/main/assets/canbus_library.txt` (validated like `--check`; a missing or invalid asset ends with exit code 1). Only the pages (`R`)
  are computed again, from `decompiled_carinfo/`, with the rules below. The result overwrites the asset by default.
  **To add a car to the built-in library**: add its `C` line in the asset, then run `py build_canbus_library.py --seal app/src/main/assets/canbus_library.txt`
  (or `--launcher .` to compute its pages as well).
* **Classes (from a decompiled `com.syu.canbus`).** It finds the `switch (DataCanbus.DATA[1000])` of `ActivityLauncher.launchCanbus()` and runs it for every car id, with fall-through,
  for the four combinations (portrait yes/no, firmware matches yes/no). A result that depends on the orientation becomes `| alt | portrait`,
  one that depends on `/sys/fytver/fyt_bin_version` becomes `| alt | fytver:...`. Conditions it does not know are treated as false and listed as warnings.
* **Pages.** Starting from the car's class it follows `X.class` references (3 levels). A class whose name contains `oil`, `mile`, `trip`, `fuel`, `consum`
  or `drivinginfo` and that sends `DataCanbus.PROXY.cmd(...)` directly in `onCreate`, `onStart` or `onResume` is a fuel page. Calls inside click listeners,
  anonymous classes and lambdas are not requests of the page. Pages are ordered as described under *The main page* below.
* **Fuel and range codes (`S`).** The candidate pages are the ones of the `R` rule (same search, same order) but they do not have to send a request:
  most cars report their values without one. In each page the script reads the methods of the class and decides the role by the method's name:
  *fuel* = `(oil|fuel).*(expend|consum|cost)`, `consum.*(oil|fuel)` or `cur.*oil`, but not a name with `ave`, `avg`, `average`, `history`, `total`, `trip`, `unit`, `max`, `min` or `mark`;
  *range* = `driving.?mile`, `drivable`, `drivenable`, `remain`, `endurance`, `range`, `last.?mile` or `can.?run`, but not `total`, `trip`, `unit`, `history`, `dived` or `driven`
  (`drivenable` is read as a range name although it contains `driven`). The code of a method is the first `DataCanbus.DATA[n]` with `n < 1000` in its body
  (1000 and above are general codes, such as the car id). A car gets the fuel code from the first page that has one and the range code from the first page that has one,
  independently. Two methods of the same role in one page with different codes: the first in the source is used and the script warns.
  The codes are those of the source: the library built from `decompiled_carinfo` knows `102 | 103` for the PSA CAN box (`RZC_BZ408OilMilePage1Acti`),
  the one built from your `com.syu.canbus` knows `91 | 92`.
* **The main page.** The launcher sends only the requests of the first page of a car. Among the pages of a car the first is: a page named after the car
  (`_<id & 0xFFFF>_`); then a page from which the script reads a fuel or range code; then a page whose name has no electric-car word (`EV`, `Electric` or `Battery`
  as a whole CamelCase word: `EVMile` yes, `Level` no); then `Page1`, then `Index`, then the shallower, then by name. The first two steps stop the screen of an electric
  car (`..EVMilePage1..`) from being the first page of a combustion car. The summary lists the groups of cars whose main page changed because of them
  (`main page changed by the fuel rule`).
* The same repeated request in one page is kept once; a page with more than 8 requests is cut to the first 8.
