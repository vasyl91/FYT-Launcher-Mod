# Launcher Mod: pętla restartów na FYT, raport crashy, ochrona przed pętlą i poprawki z logów — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `testBranch`. Zacznij od `git pull origin testBranch`.

Zrób siedem commitów w kolejności C1 → C7. **Każdy commit musi się budować samodzielnie i przechodzić testy.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.**

Numery linii to stan z `56418db` i są orientacyjne (≈). Zawsze sprawdzaj je w kodzie. Ścieżki bez prefiksu są względem
`app/src/main/java/com/android/launcher66/`.

C1 jest pilny: bez niego launcher na FYT restartuje się co kilka sekund. Wypchnij go i poczekaj na CI, zanim zaczniesz C2.

## 0. Fakty

### 0.1 Pętla restartów na FYT (log właściciela `start_pid_03-11-2026_09-35-31.txt`, sprd ums512, Android 10, launcher systemowy)
```
09:35:33.264 Launcher: finishBindingItems
09:35:33.266 Launcher: Custom elements placed (finishBindingItems): 3 pages
09:35:33.480 E CrashHandler: FATAL EXCEPTION: main (process 29064)
  android.view.InflateException: Binary XML file line #75 in com.android.launcher66:layout/absolute_time: Error inflating class com.fyt.widget.Date
  Caused by: java.lang.NumberFormatException: For input string: "oxFit"
    at java.lang.Integer.parseInt(Integer.java:615)
    at com.fyt.skin.SkinAttribute.loadView(SkinAttribute.java:43)
    at com.fyt.skin.SkinFactory.onCreateView(SkinFactory.java:29)
    …
    at com.android.launcher66.CellLayout.placeCustomWidget(CellLayout.java:3893)
    at com.android.launcher66.CellLayout.placeAssignedElements(CellLayout.java:1218)
```
- `res/layout/absolute_time.xml` (≈65, ≈83): `com.fyt.widget.Date` i `com.fyt.widget.WeekDay` mają `android:tag="boxFit"` (commit `3eb7798`, `BoxTextFit`). `Date.java`/`WeekDay.java` porównują `getTag()` z `"boxFit"`.
- `com/fyt/skin/SkinAttribute.loadView(View, AttributeSet)` (≈38–70) dla atrybutu `tag` robi `Integer.parseInt(attrs.getAttributeValue(i).substring(1))`, czyli zakłada referencję `@<id>`. Dosłowny tekst `"boxFit"` daje `"oxFit"` → wyjątek. To samo `parseInt(substring(1))` jest dalej dla atrybutów z listy (`background`, `src`, `textColor`, `drawable*`), bez ochrony.
- `SkinFactory` jest fabryką `LayoutInflater` tylko na FYT z uprawnieniami systemowymi (`com/fyt/skin/SkinActivityLifecycleCallbacks.onActivityCreated`, warunek `isFytDevice() && hasSystemPrivileges()`). Dlatego Samsung i Xiaomi nie padają.
- `CellLayout.placeAssignedElements()` (≈1186) stawia elementy w jednym poście tuż po bindzie. Inflacja daty pada przy każdym starcie, więc launcher restartuje się w kółko.
- **Potwierdzenie z raportu crasha**, który właściciel znalazł na FYT w `/sdcard/crash/crash-2026-11-03-09-35-33-com_android_launcher66.txt`
  (`versionName=1.2.1`, `versionCode=10201`):
  - ten sam łańcuch wyjątków i ten sam stos co w logcacie: `NumberFormatException: "oxFit"` w `SkinAttribute.loadView:43`, wołane z
    `CellLayout.placeCustomWidget:3893` ← `placeAssignedElements:1218` ← `CellLayout$1.run:203` (post stawiania);
  - `Binary XML file line #75` to linia, na której kończy się znacznik startowy `<com.fyt.widget.Date … />` w obecnym
    `absolute_time.xml` (linie 64–75, `android:tag="boxFit"` w 65). Przed `3eb7798` `Date` zaczynał się w linii 59 i nie miał taga;
  - `"oxFit"` to `"boxFit".substring(1)`. Jedynym takim tagiem w tym layoucie jest `boxFit` (`Date`, `WeekDay`).

### 0.2 Raport crashy nie powstaje
- `LauncherApplication.onCreate()` (≈126–145):
  - najpierw `settings.CrashLogger.install(this)` (≈130). Ten handler zapisuje `crash_<czas>.txt` ze stosem i 600 ostatnimi liniami logu procesu do `Download/Launcher66_Logs` (albo do folderu zapasowego `LogcatWorker.resolveFallbackDir()`), a potem woła poprzedni handler;
  - potem `initData()` (≈388) woła `CrashHandler.getInstance(getApplicationContext())`. Konstruktor `com/android/launcher66/CrashHandler` robi `Thread.setDefaultUncaughtExceptionHandler(this)` i **zastępuje CrashLogger**;
  - to samo w `initWallpaperPickerProcess()` (≈280–284).
- `CrashHandler` loguje `FATAL EXCEPTION` (stąd ta linia w logu) i zapisuje plik tylko do `/sdcard/crash`
  (`crash-<yyyy-MM-dd-HH-mm-ss>-com_android_launcher66.txt`): wersja i stos, bez urządzenia, bez platformy, bez linii logu.
  - Na FYT (Android 10, `requestLegacyExternalStorage`) ten plik powstaje: właściciel znalazł go tam dopiero po wskazaniu folderu.
    Żadne ustawienie ani komunikat nie mówi, że tam jest.
  - Na Androidzie 11+ zapis do `/sdcard/crash` wymaga dostępu do wszystkich plików (`MANAGE_EXTERNAL_STORAGE`); bez niego nie powstaje nic.
  - Bogatszy raport `CrashLogger` (urządzenie, stos, 600 linii logu procesu) w `Download/Launcher66_Logs`, czyli tam, gdzie właściciel
    szuka logów, nie powstaje nigdy, bo jego handler jest wyparty.
- Brak jakiejkolwiek ochrony przed pętlą: każdy start powtarza to samo.
- W repo są jeszcze `com/syu/crash/CrashHandler.java` i `com/syu/canbus/CrashHandler.java` (zdekompilowane, nigdzie nieużywane). Nie ruszaj ich.

### 0.3 Fakty z poprzednich logów (plik analizy właściciela)
- **§0 pusty ekran po usunięciu widżetu zostaje.** `Workspace.onDropCompleted()` (≈6836) woła `triggerStripEmptyScreens(…, true)` od razu po upuszczeniu na kosz. `LauncherModel.planScreenStrip()` liczy plan na workerze z `sBgItemsIdMap`. `DeleteDropTarget.completeDrop()` (≈400–420) woła `LauncherModel.deleteItemFromDatabase()` dopiero po animacji kosza, 250–600 ms później. Plan widzi więc widżet jako obecny. Log: `23:10:23.318 Screen strip (onDropCompleted()): removed=[13]`, potem `23:10:23.593 deleteAppWidgetId() 38`, a pusty ekran 7 usuwa dopiero reload (`Screen plan (load): removed=[7]`).
- **§0a zdublowane listenery przeciągania.** Po każdym `recreateView()` (`Launcher` ≈2636) woła się `setupViews()` (≈4315), który dodaje od nowa:
  - `dragController.addDragListener(mWorkspace)` (≈4394);
  - `addDropTarget(mWorkspace)` (≈4418);
  - `SearchDropTargetBar.setup()` (≈40–43, listener i cel `DeleteDropTarget`).

  `DragController.addDragListener()`/`addDropTarget()` (≈912, ≈926) nie sprawdzają duplikatów. W logach `onDragStart` przychodzi 6–11 razy: `insertNewWorkspaceScreen: empty screen already exists …` ×8 (`Workspace` ≈782) i `DeleteDropTarget: true` ×8–11 (`DeleteDropTarget` ≈250, `Log.i("DeleteDropTarget", String.valueOf(isVisible))`).
- **§1 342 ms blokady wątku głównego** (Samsung, reboot): StrictMode `File.exists` w `com/syu/util/WindowHostVdClient.hasRoot()` (≈164), wołane z `settings/StatsOverlayAlpha.applyBeforeAdd()` (≈116–137) przed każdym `addView` okna statystyk. `applyBeforeAdd()` działa tylko przy trasie `TRUSTED`, ale `route(...)` liczy wszystkie argumenty od razu, w tym `hasRoot()` (5× `File.exists`).
- **§4/§8/§14 alfa okna statystyk.**
  - `StatsOverlayAlpha` podnosi `Settings.Global maximum_obscuring_opacity_for_touch` do 1 tylko przy `onWindowShown()`/zmianie hosta, a przywraca 3 s po `onWindowHidden()`.
  - Nic nie pilnuje wartości, gdy okno jest widoczne. Właściciel (Samsung A55 + Shizuku) widzi, że okno z czasem traci pełną alfę, choć wciąż jest na ekranie. Przyczyny w logach nie widać.
  - `CanbusService.onCreate()` (≈238) woła `onWindowHiddenNow()`, które przy niedostępnym hoście (start przed Shizuku) kończy się `RESTORE: route UNAVAILABLE, the limit stays 1` i nie jest ponawiane po pojawieniu się hosta.
- **§3** `View: requestLayout() improperly called by com.fyt.widget.Date/WeekDay during layout` przy każdym postawieniu daty. `com/fyt/widget/BoxTextFit.onLayoutChange()` (≈51) woła `fit()` → `setTextSize()` w trakcie przebiegu layoutu rodzica.
- **§5** `W System.err: FileNotFoundException: /sys/fytver/fyt_bin_version` ze stosem na urządzeniach bez FYT: `settings/CanbusClasses.readFile()` (≈86–106) robi `e.printStackTrace()`.
- **§9** `E Launcher: RecyclerView not found in workspace! Waiting for layout...` (`LauncherAppBars` ≈503) przy każdym zimnym starcie. To oczekiwane czekanie na stronę użytkownika, a nie błąd.
- **§10** StrictMode 15 + 12 ms przy powrocie z ustawień (Xiaomi): `Launcher.processPendingUpdateOnResume()` (≈2381) → `settings/Helpers.checkAndResetIfOverlappingOnScreen()` (≈648) → `CustomLayoutDb.read()` (≈33) → `LauncherModel.loadWorkspaceScreensDb()` i `getItemsInLocalCoordinates()` na wątku głównym.
- **§12** przycisk `shizuku_download` (`res/xml/launcher_preferences.xml` ≈363, `settings/SettingsFragmentFirst.updateShizukuDownload()` ≈1542) pokazuje się wersji standard zawsze, gdy brak Shizuku, także na urządzeniu z rootem.
- **§13** przełącznik „dopasuj widżet do komórek” w ramce zmiany rozmiaru (`AppWidgetResizeFrame` ≈103–111, `mFitToggle`) ma stałe 40 dp i padding 8 dp:
  - na telefonie 1080x2340 przy 450 dpi daje to ok. 112 px, czyli ok. 10,4% krótszego boku, i wygląda dobrze;
  - na FYT 1200x2000 przy 240 dpi daje to 60 px (5%) i jest za mały.

## 1. Decyzje właściciela (nie zmieniaj ich)
1. Literalny `android:tag` (np. `"boxFit"`) jest dozwolony w layoutach. Skórki FYT obsługują tylko referencje `@<id>`/`?<id>`; wszystko inne pomijają. Skórka nigdy nie może przerwać inflacji.
2. Jeden handler crashy: `settings/CrashLogger`. Raport ląduje w `Download/Launcher66_Logs` (albo w folderze zapasowym, który `LogcatWorker` potem przenosi), a nazwa pasuje do konwencji `LogFileName`: `crash_pid_<dd-MM-yyyy_HH-mm-ss>.txt`.
   `/sdcard/crash` przestaje być zapisywany (Android 11+ i tak na to nie pozwala); stare pliki tam zostają, a C7 mówi, gdzie ich szukać.
3. Ochrona przed pętlą:
   - po **3 crashach w ciągu 120 s** kolejny start jest „bezpieczny”: nie stawia elementów własnych (data, muzyka, radio, placeholdery PiP i statystyk), nie otwiera paneli PiP i nie dodaje okna statystyk;
   - tryb trwa do wyjścia z ustawień launchera albo do restartu procesu;
   - historia crashy czyści się po 120 s pracy bez crashu.
4. Po starcie, który nastąpił po crashu, użytkownik dostaje Toast z jedną linią wyjątku i ścieżką raportu; w trybie bezpiecznym także informację, że elementy są wyłączone do wyjścia z ustawień.
5. Jeden element własny, który nie da się postawić (wyjątek), nie zabija launchera: zostaje pominięty, zalogowany (`Log.e` ze stosem) i nie jest ponawiany w kółko przez `HomeLayoutRecovery`.
6. Pełna alfa okna statystyk ma być utrzymywana przez cały czas jego widoczności: gdy wartość limitu spadnie poniżej 1, launcher ją podnosi ponownie i przekłada okno (`updateViewLayout`).
7. `shizuku_download` widoczny tylko dla niesystemowej aplikacji (flavor standard, bez uprawnień systemowych) na urządzeniu **bez roota**, gdy Shizuku nie jest zainstalowane.
8. Przełącznik dopasowania widżetu ma na każdym ekranie wyglądać jak na telefonie 1080x2340 przy 450 dpi: ten sam udział krótszego boku ekranu.
9. Sekcja logcata w ustawieniach mówi, gdzie szukać logów i raportów crashy (wszystkie miejsca, łącznie z `/sdcard/crash` z wersji
   do 1.2.1), i pokazuje ostatni raport crasha, jeśli jest. Teksty we wszystkich językach.

## 2. Zasady pracy i konwencje repo
- **Komentarze, Javadoc, `Log.*` i opisy commitów wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, wyjaśniają *dlaczego*.
- **Commity**:
  - temat `<Obszar>: <co>` (tematy przy krokach), treść zawinięta na ~72 znaki, w treści fakty z §0;
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push** po każdym commicie: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
  Przed następnym commitem poczekaj na wynik CI (`.github/workflows/build.yml`: `:app:testFytDebugUnitTest`, `:app:assembleFytDebug`,
  `:app:assembleStandardDebug`; `cancel-in-progress`, więc sprawdzaj run **ostatniego** commita przez GitHub MCP `actions_list`/`get_job_logs`).
  Czerwony build naprawiaj kolejnym commitem, bez amend i force-push.
- **Testy JVM**: JUnit 5 (`app/src/test/java/…`, wzorce `MusicWidgetPlanTest`, `settings/StatsOverlayAlphaTest`, `settings/LogFileNameTest`).
  `unitTests.isReturnDefaultValues = true`. Logikę decyzyjną pisz w **czystych klasach bez `android.*`**.
- **StrictMode** jest włączony: żadnego I/O ani zapytań do DB na wątku głównym w nowym kodzie. Wyjątek: zapis raportu i historii
  crashy w handlerze crashu (proces i tak ginie).
- **Bez nowych zależności, bez zmiany schematu DB, bez migracji prefów.**
- **Napisy**: nowe stringi dodaj do **każdego** `res/values*/strings.xml`, który ma `logcat_names_info_summary` (59 plików, w tym
  domyślny `res/values/strings.xml`), z tłumaczeniem na język pliku. Tak jak dotąd (`shizuku_download_button`).
- **Usuwaj dopiero po `rg`** w całym `app/src` (wszystkie source sety, Java i XML, `--glob '!**/generated/**'`).
- Kontrola bez SDK (opcjonalnie): `javac -proc:none -cp android_jar/android-36.jar …` w katalogu tymczasowym. Porównuj listę błędów
  przed i po zmianie: brak androidx daje dużo błędów niezwiązanych z Twoją zmianą.

## C1 — `Skin: a literal tag no longer crashes the inflation`

### C1.1 `com/fyt/skin/SkinAttrRef.java` (nowa, czysta Java)
- `static Integer resourceRef(String value)`: dla `"@<cyfry>"` lub `"?<cyfry>"` zwraca liczbę (`Integer.valueOf`, z przechwyceniem
  `NumberFormatException` dla przepełnienia); dla wszystkiego innego (`null`, `""`, `"#fff"`, `"boxFit"`, `"@null"`, `"@android:color/white"`) `null`.
- `static boolean isThemeRef(String value)`: `value != null && value.startsWith("?")`.

### C1.2 `com/fyt/skin/SkinAttribute.loadView(View, AttributeSet)`
- Atrybut `tag`: reguła „skin_ruleless” (porównanie z `R.string.skin_ruleless`, wtedy `return`) tylko gdy `resourceRef(value) != null`.
  Dosłowny tag jest pomijany (żadnego `parseInt`).
- Atrybuty z `list`: id liczone przez `resourceRef`; `null` → pomiń atrybut. Dla `?` bez zmian: `SkinThemeUitls.getThemeResid(…)`.
- Każdy atrybut w osobnym `try/catch (RuntimeException e)` (`NumberFormatException`, `Resources.NotFoundException`): pomiń atrybut.
  Bez logu na atrybut (inflacja jest gorąca); jeden `Log.w` na klasę widoku w procesie (statyczny `Set<String>`).
- Zachowanie dla poprawnych referencji bez zmian.

### C1.3 `com/fyt/skin/SkinFactory.onCreateView(View, String, Context, AttributeSet)` (≈23)
- `mSkinAttribute.loadView(view, attrs)` w `try/catch (RuntimeException e)` z `Log.w(TAG, "Skin skipped for " + name + ": " + e)`.
  Widok zwracany zawsze. To samo dla `onCreateView(String, Context, AttributeSet)` (≈111), jeśli woła `loadView`.

### C1.4 `CellLayout`: jeden element nie zabija launchera
- Pole `private final EnumSet<CustomElement> mFailedElements = EnumSet.noneOf(CustomElement.class);`.
- `placeAssignedElements()` (≈1186): ciało `switch` dla każdego elementu w `try { … } catch (RuntimeException e)`:
  - `Log.e(TAG, "Custom element " + element.label + " could not be placed on page " + (pageIndex + 1) + ", skipped", e)`;
  - `mFailedElements.add(element)`;
  - wyczyść referencję widoku, jeśli została ustawiona (np. `mUserDateWidget = null`), i `clearDetachedViewState`.
- Pętla pomija elementy z `mFailedElements`.
- `areAssignedElementsPlaced()` (≈1161): element z `mFailedElements` liczy się jako postawiony. Dzięki temu `isCustomElementPlacementPending()`
  i `hasHealthyCustomElements()` nie wymuszają w nieskończoność ponowień z `HomeLayoutRecovery`.
- `setCustomElements()` (≈1117): `mFailedElements.clear()`, żeby nowy przydział (np. po powrocie z ustawień) spróbował jeszcze raz.

### C1.5 Test `app/src/test/java/com/fyt/skin/SkinAttrRefTest.java`
`"boxFit"` → null, `"@2131755"` → 2131755, `"?123"` → 123, `"#ffffff"` → null, `""` → null, `null` → null, `"@null"` → null,
`"@99999999999"` → null, `isThemeRef("?1")` true, `isThemeRef("@1")` false.

## C2 — `Crashes: one report in Launcher66_Logs and a guard against crash loops`

### C2.1 Jeden handler
- `LauncherApplication`: usuń `CrashHandler.getInstance(getApplicationContext())` z `initData()` (≈390) i z `initWallpaperPickerProcess()` (≈284).
  `CrashLogger.install(this)` (≈130) zostaje pierwszą linią po `super.onCreate()`.
- Usuń `com/android/launcher66/CrashHandler.java` po `rg "CrashHandler"` (komentarze w `ColdStart`, `HomeFrontGuard`,
  `AppListAutostartDialogFragment` mówiące „(CrashHandler)” zmień na „(CrashLogger)”). Nie ruszaj `com/syu/crash` ani `com/syu/canbus`.
- `settings/CrashLogger.uncaughtException()`:
  - pierwsza linia `Log.e("CrashLogger", "FATAL EXCEPTION: " + thread.getName() + " (process " + pid + ")", throwable)` (przejęta z CrashHandler; logcat ją pokazuje);
  - potem zapis raportu i historii (C2.2), w `try/catch(Throwable)`;
  - na końcu, w `finally`, zawsze `Process.killProcess(myPid()); System.exit(10)`, **bez** wołania `mPrevious` (handlera platformy).
    Tak robił `CrashHandler`: system restartuje launcher bez okna „aplikacja przestała działać”. Wątek główny nie może zostać
    „żywy i martwy”. Pole `mPrevious` usuń, jeśli nic go już nie czyta.
- Druga instalacja (`install()` już był) dalej nic nie robi.

### C2.2 Raport
- Nazwa: `LogFileName.name(LogFileName.prefix("crash", false), <dd-MM-yyyy_HH-mm-ss>, LogFileName.TXT)` → `crash_pid_03-11-2026_09-35-33.txt`.
  Dopisz w `LogFileName` stałą `static final String CRASH_LABEL = "crash";`.
- Folder jak dziś: `LogcatWorker.usablePublicDir(ctx)`, inaczej `LogcatWorker.resolveFallbackDir(ctx)`; przy kolizji nazwy dopisz `_2`, `_3`.
- Nagłówek (każda linia `===== … =====`, jak w capture):
  - `CRASH <czas> pid=<pid> thread=<nazwa>`;
  - `device=<producent> <model>, android=<release> (API <sdk>)`;
  - `app=<versionName> (<versionCode>), flavor=<BuildConfig.FLAVOR>, platform=<DeviceIdentity.deviceLine()>, system=<hasSystemPrivileges()>`;
  - `uptime=<SystemClock.uptimeMillis() - Process.getStartUptimeMillis()> ms, crashes in the last 120 s: <n>`.

  Każde pole w osobnym `try`; brak wartości → `?`.
- Pełny stos z przyczynami (`printStackTrace`), potem 600 ostatnich linii logu procesu (bez zmian, z limitem 2 s).
- Po zapisie `Log.e(TAG, "Crash report: " + file)`.
- Retencja: w folderze raportu zostaje najwyżej 20 plików `crash_*.txt` (usuń najstarsze po nazwie/czasie modyfikacji). Robione w handlerze
  po zapisie; błąd ignorowany.

### C2.3 Ochrona przed pętlą
- `settings/CrashLoopPolicy.java` (czysta Java):
  - `static final long WINDOW_MS = 120_000; static final int CRASHES = 3; static final int MAX_ENTRIES = 10;`
  - `static List<Long> parse(String text)`: linie `<wallMillis> …`, uszkodzone pomijane;
  - `static String append(List<Long> history, long now, String oneLine)` (przycina do `MAX_ENTRIES`);
  - `static int recent(List<Long> history, long now)` (wpisy z `now - WINDOW_MS .. now`, przyszłe też liczone, bo zegar mógł się cofnąć);
  - `static boolean safeMode(List<Long> history, long now)` (`recent >= CRASHES`);
  - `static String lastOneLine(String text)`.
- `settings/CrashLoopGuard.java` (cienka warstwa):
  - plik `new File(ctx.getFilesDir(), "crash_history")`;
  - `static void recordCrash(Context, Throwable)` z CrashLogger: dopisuje linię `<now> <Klasa>: <message do 200 znaków>`, `FileOutputStream` + `getFD().sync()`;
  - `static void onProcessStart(Context)` z `LauncherApplication.onCreate()` zaraz po `CrashLogger.install` (poza procesem pickera tapet).
    Czyta plik (kilkaset bajtów; `onCreate` włącza StrictMode dopiero na końcu, `enableStrictMode()` ≈231, więc ten odczyt go nie
    narusza) i liczy `sSafeMode`, `sPreviousCrash` (jedna linia ostatniego wpisu, jeśli był w ciągu
    `WINDOW_MS`) i `sReportPath` (najnowszy `crash_*.txt` w folderze logów; szukanie przenieś do wątku `StartupWarmUp`, a do Toast weź wynik).
  - Po 120 s od startu procesu (`LauncherApplication.sHandler.postDelayed`) usuwa plik historii na wątku tła (`Log.i` „No crash for 120 s, crash history cleared”).
  - `static boolean isSafeMode()`, `static void leaveSafeMode(String reason)` (`Log.i`).
  - Gdy tryb włączony: jeden `Log.w(TAG, "Safe mode: " + n + " crashes within 120 s; custom elements, PiP panes and the stats window are off until the settings are left")`.
- Gdzie tryb działa (jedna linia na początku metody, bez dodatkowych logów):
  - `Launcher.placeCustomElements(String)` (≈1431): `if (CrashLoopGuard.isSafeMode()) return;`;
  - `com/syu/util/WindowUtil.startMapPip(boolean, int)` (≈365): to samo;
  - `settings/CanbusService.addStatsViewMainScreen()` (≈723): to samo.
- Wyjście z trybu: w `Launcher.processPendingUpdateOnResume()` (≈2361), tylko przy faktycznym przetwarzaniu (po sprawdzeniu duplikatu),
  `if (CrashLoopGuard.isSafeMode()) { CrashLoopGuard.leaveSafeMode("settings left"); }`. Dalsza część metody już przebudowuje stronę
  i panele. Po niej wywołaj `placeCustomElements("safeModeLeft")`.
- Informacja dla użytkownika: w `Launcher.onResume()`, raz na proces (statyczna flaga), jeśli `sPreviousCrash != null`, pokaż `Toast.LENGTH_LONG`:
  - `R.string.crash_restarted_toast` („Launcher was restarted after an error: %1$s. Report: %2$s”);
  - w trybie bezpiecznym zamiast niego `R.string.crash_safe_mode_toast` („Launcher crashed %1$d times in a row (%2$s). Custom widgets, PiP panes and the stats window are off until you leave the settings. Report: %3$s”).

  Ścieżka to sama nazwa folderu i pliku (`Launcher66_Logs/crash_pid_….txt`).
- Legenda `logcat_names_info_summary` we wszystkich 59 plikach `strings.xml`, które ją mają (w tym domyślny): dopisz linię
  „crash – written when the launcher crashed (the error and the last log lines)”, przetłumaczoną.

### C2.4 Testy
- `settings/CrashLoopPolicyTest`:
  - dwa crashe w 120 s → brak trybu;
  - trzy → tryb;
  - trzy, ale najstarszy 121 s temu → brak;
  - `append` przycina do 10;
  - uszkodzone linie pomijane;
  - `lastOneLine`.
- `settings/LogFileNameTest`: `prefix(CRASH_LABEL, false)` daje `crash_pid_`, a `parse("crash_pid_03-11-2026_09-35-33.txt")` zwraca timestamp.

## C3 — `Screens: a strip after the model deletes an item; drag listeners registered once`

### C3.1 Strip po usunięciu z modelu (§0)
- `LauncherModel`: nowa `private static void requestStripAfterDelete(long container, String what)`. Jeśli
  `container == LauncherSettings.Favorites.CONTAINER_DESKTOP`, postuje na wątek główny (`LauncherApplication.sHandler` albo `new Handler(Looper.getMainLooper())`):
  `Launcher l = Launcher.getLauncher(); if (l != null && l.getWorkspace() != null) l.getWorkspace().triggerStripEmptyScreens("Model, " + what + " deleted", true);`.
- Wołaj ją na końcu runnable w `deleteItemFromDatabase()` (≈960, po bloku `synchronized (sBgLock)`), z `item.container`, i w
  `deleteFolderContentsFromDatabase()` (≈1093) z `info.container`.
- Komentarz po angielsku: plan stripu liczony na workerze po tym runnable (kolejka FIFO) widzi już usunięcie. Strip z `onDropCompleted()`
  przychodzi przed usunięciem, bo `DeleteDropTarget` usuwa dopiero po animacji kosza.
- Nie zmieniaj `planScreenStrip`/`applyScreenStrip`. Debounce w `triggerStripEmptyScreens` łączy nadmiarowe wywołania.

### C3.2 Listenery przeciągania raz (§0a)
- `DragController.addDragListener()` (≈912): `if (!mListeners.contains(l)) mListeners.add(l);`. To samo w `addDropTarget()` (≈926)
  dla `mDropTargets`. Komentarz: `recreateView()` → `setupViews()` rejestruje Workspace, `SearchDropTargetBar` i `DeleteDropTarget`
  ponownie przy każdym powrocie z ustawień.
- `DeleteDropTarget` ≈250: usuń `Log.i("DeleteDropTarget", String.valueOf(isVisible));`.
- `Workspace` ≈782: `insertNewWorkspaceScreen: empty screen already exists …` z `Log.i` na `Log.d`.

## C4 — `Stats window: no disk on the main thread, full alpha kept`

### C4.1 `applyBeforeAdd()` bez I/O (§1)
- `settings/StatsOverlayAlpha.applyBeforeAdd()` (≈116): zamiast `route(...)` licz tylko
  `boolean trusted = Build.VERSION.SDK_INT >= 31 && currentLimit(context) < 1f && (myUid == SYSTEM_UID || granted(INTERNAL_SYSTEM_WINDOW))`.
  Dalej bez zmian (`setTrustedOverlay`). Pure `route()` zostaje (używa go `sync()` na executorze i testy).
- `com/syu/util/WindowHostVdClient.hasRoot()` (≈164): wynik sprawdzenia plików `su` w `private static volatile Boolean sSuBinary`, liczony
  raz (pierwsze wywołanie). Dodaj `public static void warmUpRootCheck()` i wołaj ją w wątku `StartupWarmUp` (`LauncherApplication` ≈384).
  `canSendBootCompleted()` i `isModuleInstalled()` dalej liczone na bieżąco (bez dysku).

### C4.2 Utrzymanie pełnej alfy (§8, §14, decyzja 6)
- Pure: `static boolean needsRaise(boolean windowShown, boolean trustedApplied, float currentLimit)` = `windowShown && !trustedApplied && currentLimit < 1f`
  (test w `StatsOverlayAlphaTest`).
- Gdy okno jest pokazane (`onWindowShown`), zarejestruj `ContentObserver` (handler główny) na `Settings.Global.getUriFor(LIMIT_KEY)`;
  `onChange` → `submit()`. Wyrejestruj w `HIDE_TASK` po faktycznym ukryciu i w `onWindowHiddenNow`.
- Okresowe sprawdzenie, gdy okno jest pokazane: co 60 s na wątku głównym `MainHolder.MAIN.postDelayed(CHECK_TASK, 60_000)`;
  `CHECK_TASK` robi `submit()` i planuje się ponownie, dopóki `desiredShown`. Zdejmij go przy ukryciu.
- `sync()`, akcja RAISE przy `raised == true` (już raz podnosiliśmy, a wartość spadła):
  `Log.w(TAG, "RAISE again: the limit was " + current + " while the window was shown")`. Oryginał zostaje ten zapisany przy pierwszym podniesieniu.
- Po każdym udanym RAISE (także ponownym) `onRaised` (`CanbusService.onStatsWindowAdded` ≈1009 → `updateViewLayout`) przelicza alfę okna.
  Dziś już tak jest; upewnij się, że ponowne podniesienie też go woła.
- Okno dodane w trakcie oczekiwania na RESTORE (log 00:01:26, bez własnego RAISE): `onWindowShown` zdejmuje `HIDE_TASK`, a nowy observer i
  sprawdzenie okresowe pilnują wartości. Dodatkowej logiki nie trzeba.

### C4.3 RESTORE po pojawieniu się hosta (§4)
- `onWindowHiddenNow()` (≈157): `addHostListener()` (dziś tylko w `onWindowShown`), żeby RESTORE pominięty jako `UNAVAILABLE` przy starcie
  zrobił się, gdy Shizuku/host się podłączy (`HOST_LISTENER` → `submit()`).
- `RESTORE: route UNAVAILABLE` z `Log.w` na `Log.i` z tekstem „…, deferred until a host is available”.

## C5 — `Logs and main thread: date fit after layout, quiet reads, occupancy from the model`

### C5.1 `com/fyt/widget/BoxTextFit` (§3)
- `onLayoutChange()` (≈51): zamiast `fit()` → `mView.removeCallbacks(mFitRunnable); mView.post(mFitRunnable);` (pole
  `private final Runnable mFitRunnable = this::fit;`). `detach()` zdejmuje oczekujący runnable. Bezpośrednie `fit()` z `Date.setDate()`/`WeekDay`
  zostaje (nie biegnie w layoucie).

### C5.2 `settings/CanbusClasses.readFile()` (≈86) (§5)
- `File` nie istnieje albo nie da się go czytać → `""` bez stosu. Inne wyjątki: `Log.d(TAG, "Cannot read " + path + ": " + e)`. Użyj
  try-with-resources. Bez `printStackTrace`.

### C5.3 `LauncherAppBars` ≈503 (§9)
- `Log.e(… "RecyclerView not found in workspace! Waiting for layout...")` → `Log.d(… "Bottom bar not built yet, waiting for the layout")`.

### C5.4 `CustomLayoutDb.read()` (≈33) z modelu (§10)
- `LauncherModel`: nowa `static ArrayList<int[]> desktopItemCells()`: pod `sBgLock` kopia `{screenId (long w dwóch intach albo osobna klasa), cellX, cellY, spanX, spanY}`
  dla `container == CONTAINER_DESKTOP` z `sBgItemsIdMap`. Lepiej mała klasa `static final class DesktopCell { final long screenId; final int x, y, spanX, spanY; }`.
- `CustomLayoutDb.read()`: jeśli `LauncherModel.getScreenSnapshot().isReady()`, to `rankedIds` = `snapshot.order` (bez strony użytkownika, w kolejności stron),
  a komórki z `desktopItemCells()`. Bez zapytań. Inaczej (model jeszcze nie załadowany) jak dziś z bazy.
- Komentarz klasy: zaktualizuj („reads the model's in-memory copy when it is loaded; the database only before that”).
- `WorkspaceOccupancy`, `GridGeometry`, `Helpers` bez zmian.

## C6 — `Settings and widgets: Shizuku button only without root, fit toggle sized to the screen`

### C6.1 `shizuku_download` (§12, decyzja 7)
- `SettingsFragmentFirst.updateShizukuDownload()` (≈1542): w wątku tła licz
  `boolean show = !LauncherApplication.hasSystemPrivileges() && !WindowHostVdClient.hasRoot() && !WindowHostVdClient.isShizukuInstalled(appContext);`.
  Warunek flavor `standard` zostaje. Javadoc zaktualizuj (root/system nie potrzebują Shizuku).

### C6.2 Przełącznik dopasowania widżetu (§13, decyzja 8)
- `ScreenScale`: nowa `public static int referencePx(Context context, float dpOnReference)`
  = `Math.round(dpOnReference * REFERENCE_DENSITY_DPI / 160f * shortSidePx / REFERENCE_SHORT_SIDE_PX)`, gdzie `REFERENCE_DENSITY_DPI = 450`,
  a `shortSidePx` to `Math.min(widthPixels, heightPixels)` z `context.getResources().getDisplayMetrics()`. Działa także na FYT
  (to celowo nie zależy od `applies()`). Javadoc: 1080x2340 przy 450 dpi to telefon, na którym rozmiar wygląda dobrze.
- `AppWidgetResizeFrame` ≈103–111: `toggleSize = ScreenScale.referencePx(context, 40f)`, `togglePadding = ScreenScale.referencePx(context, 8f)`.
  Dla 1080x2340/450 dpi wynik ≈ 112/22 px jak dziś, dla FYT 1200x2000/240 dpi ≈ 125/25 px.
- Uchwyty krawędzi i `mBackgroundPadding` bez zmian.
- Test czystej arytmetyki: wydziel `static int referencePx(float dp, int shortSidePx)` i przetestuj w `app/src/test/java/com/android/launcher66/ScreenScaleTest.java`
  (1080 → 113, 1200 → 125, 720 → 75).

## C7 — `Settings: where to find the logs and the crash reports`

Po C2 (nazwa `crash_pid_…`, jedno miejsce zapisu). Decyzja 9.

### C7.1 Nowa pozycja w sekcji logcata
- `res/xml/launcher_preferences.xml`, `PreferenceCategory app:key="logcat_category"` (≈314): zaraz po `logcat_names_info` (≈317–321)
  dodaj
  ```xml
  <Preference
      android:key="logcat_locations_info"
      android:selectable="false"
      android:title="@string/logcat_locations_info"
      android:summary="@string/logcat_locations_info_summary" />
  ```
  i stałą `Keys.LOGCAT_LOCATIONS_INFO = "logcat_locations_info"`.
- Teksty (po angielsku w `values`, przetłumaczone w każdym z 59 plików `strings.xml`, jak w §2):
  - `logcat_locations_info`: „Where to find the logs and crash reports”;
  - `logcat_locations_info_summary`, każde miejsce w osobnej linii (`\n`), ścieżki bez tłumaczenia:
    - „Download/Launcher66_Logs – the logs and the crash reports (crash_pid_…)”;
    - „Android/data/com.android.launcher66/files/Download/Launcher66_Logs – used while Download cannot be written (e.g. right after
      a restart); moved to Download later”;
    - „/sdcard/crash – crash reports of versions up to 1.2.1”.
  - `logcat_last_crash`: „Last crash report: %1$s”, z czasem i nazwą pliku;
  - `logcat_no_crash`: „No crash reports”.
- Ścieżka zapasowa ma być prawdziwa: sprawdź ją w `LogcatWorker.resolveFallbackDir()` (≈1366, `getExternalFilesDir(DIRECTORY_DOWNLOADS)` +
  `Launcher66_Logs`). Jeśli się różni, popraw tekst, nie kod.

### C7.2 Ostatni raport w podsumowaniu
- `settings/SettingsFragmentFirst`: w miejscu, gdzie są pozycje logcata (≈360–369), `findPreference(Keys.LOGCAT_LOCATIONS_INFO)`.
- W `onResume()` (≈612), jak `updateShizukuDownload()`, nowa `updateLastCrashReport()`. W wątku tła szuka najnowszego pliku
  `crash_*.txt` w kolejnych folderach:
  - `LogcatWorker.usablePublicDir(ctx)`;
  - `LogcatWorker.resolveFallbackDir(ctx)`;
  - `/sdcard/crash` (stary format `crash-…-com_android_launcher66.txt`; brak dostępu → pomiń).

  Najnowszy wybierz po `lastModified()`. Wynik na wątek główny przez `mHandler.post`, gdy `isAdded()`.
- Podsumowanie: `getString(R.string.logcat_locations_info_summary) + "\n\n" + (plik != null ? getString(R.string.logcat_last_crash,
  <czas "dd-MM-yyyy HH:mm"> + " " + <folder względny>/<nazwa>) : getString(R.string.logcat_no_crash))`.
  Folder względny to `Download/Launcher66_Logs`, `Android/data/…/Launcher66_Logs` albo `/sdcard/crash`.
- Bez I/O na wątku głównym. Wyjątki w wątku tła łapane (`Log.w`).

### C7.3 Legenda nazw
- Linia „crash – …” w `logcat_names_info_summary` dochodzi już w C2.3; tu tylko sprawdź, że obie pozycje (nazwy i lokalizacje)
  mówią to samo (`crash_pid_`).

## 3. Czego NIE zmieniać
- `com/syu/crash/*`, `com/syu/canbus/CrashHandler.java`, `LogcatWorker` (poza użyciem jego istniejących `usablePublicDir`/`resolveFallbackDir`).
- Logiki planu ekranów (`WorkspaceScreenPlan`, `planScreenStrip`, `applyScreenStrip`), geometrii elementów i PiP.
- `res/layout/absolute_time.xml` (tagi `boxFit` zostają, decyzja 1).
- §2 analizy (wolny zimny start: plan → `finishBindingItems` 3,2 s na Samsungu, 9,3 s na Xiaomi) — wymaga profilowania, poza zakresem.
  §6, §7, §11 (szum systemowy) — bez działania.

## 4. Weryfikacja
1. Po każdym commicie CI zielone; nowe testy przechodzą.
2. `rg` w `app/src` (`--glob '!**/generated/**'`):
   - `CrashHandler.getInstance` → zero; `/sdcard/crash` → tylko w `strings.xml` (C7) i w `SettingsFragmentFirst.updateLastCrashReport()`;
   - `Log.i\("DeleteDropTarget"` → zero;
   - `substring\(1\)\)` w `com/fyt/skin/SkinAttribute.java` → zero.
3. Scenariusze dla właściciela (wypisz je w raporcie):
   - a) FYT: start bez pętli; w logu `Custom elements on page …: date …` i brak `NumberFormatException`.
   - b) Wymuszony crash (np. tymczasowo w buildzie debug): w `Download/Launcher66_Logs` pojawia się `crash_pid_<czas>.txt` z nagłówkiem,
     stosem i logiem. Po restarcie Toast z jedną linią i ścieżką.
   - c) Trzy crashe w 2 min: start w trybie bezpiecznym (`Log.w Safe mode: …`), bez elementów, PiP i statystyk, Toast. Wejście
     i wyjście z ustawień → elementy wracają.
   - d) Usunięcie jedynego widżetu ze strony do kosza: `Screen strip (Model, item deleted): removed=[<id>]` bez reloadu.
   - e) Kilka powrotów z ustawień, potem przeciągnięcie ikony: jedna linia `insertNewWorkspaceScreen` (`Log.d`) zamiast 6–11.
   - f) Samsung + Shizuku: okno statystyk przez kilka minut z pełną alfą; jeśli coś obniży limit, w logu `RAISE again: …`.
   - g) Zimny start na Samsungu: brak StrictMode `hasRoot` w `applyBeforeAdd`.
   - h) Data/dzień tygodnia: brak `requestLayout() improperly called by com.fyt.widget.Date/WeekDay`.
   - i) Xiaomi z rootem: brak przycisku Shizuku. Telefon bez roota bez Shizuku: przycisk jest.
   - j) FYT: przełącznik dopasowania widżetu w ramce zmiany rozmiaru wyraźnie większy (≈125 px).
   - k) Powrót z ustawień na Xiaomi: brak StrictMode z `CustomLayoutDb.read`.
   - l) Ustawienia → Logcat: pozycja „Where to find the logs and crash reports” z trzema miejscami i ostatnim raportem. Na FYT to
     dziś `/sdcard/crash/crash-2026-11-03-09-35-33-…`, a po crashu na nowej wersji `Download/Launcher66_Logs/crash_pid_…`.
     Sprawdź język polski i jeden inny.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash + temat) i wynik CI każdego.
- Lista usuniętych klas/metod/logów.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z pkt 4.3 z tym, czego właściciel ma szukać w logu.
