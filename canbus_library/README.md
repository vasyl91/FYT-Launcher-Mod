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
py build_canbus_library.py --launcher <repo> [--out FILE]        the library built into the launcher (CanbusClasses.java + decompiled_carinfo/)
py build_canbus_library.py --seal FILE                           recompute the footer of an edited file
py build_canbus_library.py --check FILE                          validate a file like the launcher does
```

Exit code: 0 success, 1 bad input, 2 an invalid file in `--check`.

## 6. File format (version 1)

A UTF-8 text file. The first significant line is `canbus_library 1`. Empty lines and lines starting with `#` are ignored
(a BOM at the start is allowed). Records (fields are separated by `|`, spaces around fields are allowed):

```
C <ids> | <class>                                      screen class of the car
C <ids> | <class> | <alt> | portrait                   <alt> when the screen is in portrait (getConfiguration() == 1)
C <ids> | <class> | <alt> | fytver:<tok>[,<tok>...]    <alt> when /sys/fytver/fyt_bin_version contains one of the tokens
R <ids> | <page> | <req>[; <req>...]                   a fuel page and the requests it sends, in order
N <ids>                                                the car needs no request (switches off a false match)
end <records> <crc32>                                  footer, the last significant line
```

* `<ids>`: decimal `int`s from 1 to 2147483647 separated by commas, 1-5000 of them, no repeats within a line.
* `<class>`, `<page>`: a full class name matching `com\.syu(\.[A-Za-z_$][A-Za-z0-9_$]*)+`, at most 200 characters.
* `<alt>`: the same, or `-` (then the car has no class when the condition is met).
* `<tok>`: `[A-Za-z0-9]{1,16}`, 1-8 tokens.
* `<req>`: `cmd` or `cmd:i,i,...`; `cmd` is 0..9999, each `i` is -65536..65536, at most 8 numbers. At most 8 requests in an `R` line.
  A request is what the original screen sends with `DataCanbus.PROXY.cmd(cmd, new int[]{i, ...}, null, null)`.

**Consistency inside one file**

* one car id has at most one `C` record;
* `R` pages are unique per (id, page), at most 10 pages per id;
* `N` and `R` for the same id exclude each other;
* an identical record repeated is a *duplicate* (skipped and counted), a contradicting one is an error.

**Footer.** `<records>` is the number of `C`/`R`/`N` lines. `<crc32>` is 8 lowercase hex digits: the CRC-32
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
* Records for different car ids never affect each other.

Example (the footer values are only an example; the script computes the real ones):

```
canbus_library 1
C 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi
C 274 | com.syu.carinfo.accord.ActivityAccord7Index | com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi | portrait
R 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti | 70:51; 29:0
R 19 | com.syu.carinfo.honda.HondaTripActi | 100:1; 100:3
N 1
end 5 1a2b3c4d
```

## 7. How the script decides

* **Classes.** It finds the `switch (DataCanbus.DATA[1000])` of `ActivityLauncher.launchCanbus()` and runs it for every car id, with fall-through,
  for the four combinations (portrait yes/no, firmware matches yes/no). A result that depends on the orientation becomes `| alt | portrait`,
  one that depends on `/sys/fytver/fyt_bin_version` becomes `| alt | fytver:...`. Conditions it does not know are treated as false and listed as warnings.
* **Pages.** Starting from the car's class it follows `X.class` references (3 levels). A class whose name contains `oil`, `mile`, `trip`, `fuel`, `consum`
  or `drivinginfo` and that sends `DataCanbus.PROXY.cmd(...)` directly in `onCreate`, `onStart` or `onResume` is a fuel page. Calls inside click listeners,
  anonymous classes and lambdas are not requests of the page. Pages are ordered: name with `_<id & 0xFFFF>_`, then `Page1`, then `Index`, then the shallower, then by name.
* The same repeated request in one page is kept once; a page with more than 8 requests is cut to the first 8.
