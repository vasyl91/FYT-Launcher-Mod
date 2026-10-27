# Launcher Mod: Pinned PiP po przełączeniu z Window, revert 66961f2, nazwy plików logów z wyzwalaczem i zakresem — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`. Wprowadź zmiany opisane niżej, każdą jako osobny commit, w kolejności R → D → S → P1 → P2 → P3 → L → I → T. Wypchnij je na tę gałąź. **Nie twórz pull requesta.**

Ta runda następuje po `docs/sonnet-prompt-2026-10-27-bar-pip.md` (commity do `4f94b19`). Zmian z tamtej rundy nie cofaj. Numery linii to stan z `4f94b19`, są orientacyjne. Zawsze sprawdzaj je w kodzie.

## 0. Urządzenia i najważniejsza zasada

| Urządzenie | Android | Wariant | Uprawnienia | Pinned PiP |
|---|---|---|---|---|
| FYT 7862 (`sprd ums512_1h10_Natv`) | 10 | `fyt`, aplikacja systemowa (uid 1000) | system | **tak**, tego dotyczą logi |
| FYT 8581 | 10 | `fyt` | system | tak |
| FYT UNISOC 7870 | 13 | `standard` | Shizuku | nie (`supportsPinnedPip()` = false) |
| Redmi Note 8T / Galaxy A55 | 14 / 16 | `standard` | root / Shizuku | nie |

Pinned PiP istnieje tylko tam, gdzie `LauncherApplication.supportsPinnedPip()` zwraca true. Zmiany P1–P3 muszą być no-opem wszędzie indziej: każda nowa ścieżka zaczyna się od tej bramki albo leży w kodzie, do którego bez niej się nie dochodzi. Zmiany R, D, S, L, I i T dotyczą wszystkich urządzeń.

## 1. Zasady pracy i konwencje repo (jak w poprzednich rundach)

- **Komentarze i commity po angielsku**, w stylu otaczającego kodu: pełne zdania, które wyjaśniają *dlaczego*. Gęstość komentarzy jak w sąsiednim kodzie.
- **Commity**:
  - temat w trybie rozkazującym `<Obszar>: <co>`, treść zawinięta na ~72 znaki;
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push**: `git push -u origin ccr-087eed00-gbqsuz`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
- **Nie ruszaj commita `57e3600 [BRANCH-ONLY] CI: …` ani plików `.github/workflows/*.yml`.**
- **Logowanie**: `android.util.Log` z `TAG` danej klasy. Rutynowe zdarzenia na poziomie `I`/`D`. Każda nowa decyzja (pominięcie, odroczenie, restart) ma jedną linię `Log.i`, z której w capture widać, co się stało i dlaczego.
- **StrictMode** (po zmianie S działa w debugu i w release): nic z dysku ani sieci na wątku głównym. Wywołania binderowe (`getRunningTasks`) są dozwolone, robi je już otaczający kod.
- **Testy**: JUnit 5 na JVM (`app/src/test/java`, `unitTests.isReturnDefaultValues = true`). Logikę decyzyjną wydziel do **czystych klas bez `android.*`** i przetestuj ją.
- **Bez nowych zależności i bez zmian schematu baz.** Nowe stringi wolno dodać wyłącznie w kroku I (legenda), a ich tłumaczenia w kroku T.
- **Budowanie**: w kontenerze zwykle nie ma Android SDK. CI (`build.yml`) przy każdym pushu uruchamia:
  - `:app:testFytDebugUnitTest`;
  - `:app:assembleFytDebug`;
  - `:app:assembleStandardDebug`.

  Workflow ma `cancel-in-progress`, więc sprawdzaj run **ostatniego** commita (GitHub MCP `actions_list`/`get_job_logs`). Czerwoną budowę naprawiaj od razu.
- **Kontrola bez SDK**: klasy bez androidx skompilujesz poleceniem `javac -proc:none -cp android_jar/android-36.jar -d <tmp> <pliki>`. Stuby klas projektu trzymaj w katalogu tymczasowym, nie w repo. Ten jar zawiera też API ukryte. To, że coś się kompiluje, nie znaczy, że istnieje na API 29: wszystko ukryte czytaj refleksją z fallbackiem.
- `Workspace.java` (>7000 linii) i `WindowUtil.java` (>2700) edytuj punktowo i nie przenoś istniejącego kodu.

---

## R — Revert `66961f2` („Logcat: force every capture on in debug builds, one place reads the settings”)

### Decyzja właściciela
Commit ma zostać cofnięty w całości.

### Co ten commit zrobił (do odwrócenia)
- Dodał `settings/LogcatSettings.java` i `test/.../settings/LogcatSettingsTest.java`. W debugu wymuszały one wszystkie 4 ustawienia logcat.
- Przepiął odczyty `Keys.LOGCAT_SERVICE`, `LOGCAT_SERVICE_WAKE`, `LOGCAT_FULL` i `BOOT_LOGCAT` w tych miejscach:
  - `ColdStart.startLogcat`;
  - `WakeDetection` (≈310);
  - `LogcatWorker` (≈491, ≈515);
  - `SettingsFragmentFirst` (≈461, ≈471, ≈946, ≈955).
- W `SettingsFragmentFirst` (≈501–514) dodał blok `if (LogcatSettings.isForced())`: przełączniki nietrwałe, zaznaczone i wyłączone.
- W `LogcatWorker`:
  - wydzielił `restoreLogdSizes(prefs, viaHost)` i dodał `public static restoreLogdSizesIfOff(Context)` (≈860–910), wołane z `ColdStart.startLogcat`;
  - dodał parametr `viaHost` do `runCommand` i przeciążenie `startProcess(cmd, viaHost)` (≈1173–1201);
  - w `shouldWriteAppLine` dodał wyjątek dla StrictMode w debugu (≈1935).

### Implementacja
1. `git revert --no-commit 66961f2`. **Nie zastosuje się czysto**: konflikty w `LogcatWorker.java` i `SettingsFragmentFirst.java`, bo później zmieniły je `cf7b175`, `02a13c5` i inne. Rozwiązuj konflikty tak, żeby **zostały wszystkie późniejsze zmiany** (plan startu `StartPlan`, `HOST_ON_ITS_WAY`, `upgradeToHost`, late dump, linie scope/notes, `Trigger`). Znikają wyłącznie elementy wprowadzone przez `66961f2`.
2. Każde wywołanie `LogcatSettings.*` zastąp odczytem sprzed commita:
   - `LogcatWorker`: `prefs.getBoolean(Keys.LOGCAT_FULL, false)` i `prefs.getBoolean(Keys.BOOT_LOGCAT, false)`. Dotyczy to **także linii ≈554 w `upgradeRequested`**, którą dodał dopiero `cf7b175` (`bootLog = LogcatSettings.bootLog(prefs);` → `prefs.getBoolean(Keys.BOOT_LOGCAT, false)`).
   - `ColdStart`: `settings.getBoolean(Keys.LOGCAT_SERVICE, true)`. Usuń wywołanie `LogcatWorker.restoreLogdSizesIfOff(app)` i jego komentarz oraz import `LogcatSettings`.
   - `WakeDetection`: `prefs.getBoolean(Keys.LOGCAT_SERVICE_WAKE, true)`.
   - `SettingsFragmentFirst`: `sharedPrefs.getBoolean(Keys.LOGCAT_SERVICE, false)` / `(Keys.LOGCAT_SERVICE_WAKE, false)`. Usuń cały blok `isForced()`. Jeśli import `TwoStatePreference` służył tylko temu blokowi, usuń i jego.
3. W `LogcatWorker`:
   - przywróć inline’owy blok `else { … }` z `runQuietly("setprop", prop, before)` w `syncLogdBufferSize`;
   - usuń `restoreLogdSizes` i `restoreLogdSizesIfOff`;
   - przywróć `runCommand(String[] cmd, List<String> output)` i jedno `startProcess(List<String> cmd)` z `if (sViaHost) return HostProcess.start(...)`;
   - przywróć `if (line.contains("StrictMode")) return false;`.
4. Usuń `LogcatSettings.java` i `LogcatSettingsTest.java`.
5. Kontrola: `grep -rn "LogcatSettings\|restoreLogdSizesIfOff\|isForced()" app/src` ma dać pusty wynik. Wszystkie pozostałe testy `settings/LogcatWorker*Test` muszą przejść.
6. Commit: `Revert "Logcat: force every capture on in debug builds, one place reads the settings"`. W treści:
   - „This reverts commit 66961f2 at the owner's request.”;
   - co wraca: start/wake capture domyślnie `true` w ColdStart/WakeDetection, przełączniki edytowalne w debugu, logd sizes przywracane tylko na starcie capture, StrictMode znów odfiltrowany;
   - że domyślne wartości i StrictMode ustawiają na nowo następne commity (D, S);
   - konflikty rozwiązano na korzyść późniejszych commitów, łącznie z linią z `cf7b175`.

R ma być czystym revertem. Nowe zachowanie wprowadzają dopiero D i S, każdy w osobnym commicie.

---

## D — Ustawienia logcat: domyślne wartości zależne od builda, w obu buildach zmienialne

### Wymaganie właściciela
| Ustawienie (klucz) | release | debug |
|---|---|---|
| „Logcat service on startup” (`Keys.LOGCAT_SERVICE`, `logcat_service`) | false | true |
| „Logcat service when the device wakes” (`Keys.LOGCAT_SERVICE_WAKE`) | false | true |
| „Log scope” (`Keys.LOGCAT_FULL`, false = „Log only for launcher”) | false | true („Log everything”) |
| „Include boot logs” (`Keys.BOOT_LOGCAT`) | false | true |

W obu buildach każde z tych ustawień użytkownik zmienia swobodnie: nic nie jest wymuszane ani blokowane (inaczej niż w cofniętym `66961f2`).

### Fakty
- `res/xml/launcher_preferences.xml` (≈315–332): wszystkie cztery mają `android:defaultValue="false"`. `logcat_full` to `CustomNoSwitchPreference` (summaryOn/Off = „Log everything” / „Log only for launcher”).
- `PreferenceManager.setDefaultValues` nie jest nigdzie wołane. Wartość z XML zapisuje się dopiero przy pierwszym pokazaniu ekranu ustawień. Do tego czasu decydują wartości domyślne w `getBoolean(key, def)` w kodzie. Po revercie R kod podaje inne domyślne wartości niż XML: ColdStart i WakeDetection `true`, reszta `false`.
- Source sety `app/src/debug` i `app/src/release` istnieją (dziś tylko `LeakCanaryInit.java`). Typy buildów `nonMinifiedRelease`/`benchmarkRelease` dodaje plugin Baseline Profile z `release` i mają zachowywać się jak release.
- `app/src/main/res/values/bools.xml` już istnieje.

### Implementacja
1. Jedno źródło prawdy, czyli zasób:
   - w `app/src/main/res/values/bools.xml` dopisz `<bool name="logcat_on_by_default">false</bool>` z komentarzem XML: release false, nadpisywane w debugu;
   - utwórz `app/src/debug/res/values/bools.xml` z `<bool name="logcat_on_by_default">true</bool>`;
   - typy `nonMinifiedRelease`/`benchmarkRelease` biorą wartość z `main`, czyli false.
2. W `launcher_preferences.xml` ustaw `android:defaultValue="@bool/logcat_on_by_default"` dla `logcat_service`, `logcat_service_wake`, `logcat_full` i `boot_logcat`. Bez `enabled`/`persistent`, tak jak dziś.
3. W kodzie: mała klasa `settings/LogcatDefaults.java` (final, prywatny konstruktor), np. `static boolean on(Context ctx)` = `ctx.getResources().getBoolean(R.bool.logcat_on_by_default)`. **Każdy** odczyt czterech kluczy podaje ją jako domyślną wartość: `getBoolean(Keys.X, LogcatDefaults.on(ctx))`. Miejsca (sprawdź `grep -rn "LOGCAT_SERVICE\b\|LOGCAT_SERVICE_WAKE\|LOGCAT_FULL\|BOOT_LOGCAT" app/src/main/java`):
   - `ColdStart.startLogcat`;
   - `WakeDetection` (≈310, kontekst `LauncherApplication.sApp`);
   - `LogcatWorker` (≈491, ≈515, ≈554);
   - `SettingsFragmentFirst` (≈461, ≈471, ≈946, ≈955, a także widoczność `logcatBoot`, która dziś czyta `logcatFull.isChecked()`, co jest w porządku).

   Żadnego wymuszania, żadnego `isForced`, żadnych `setEnabled(false)`.
4. Nie zmieniaj zapisanych wartości. Domyślne działają tylko tam, gdzie klucz nie był jeszcze zapisany (nowa instalacja, wyczyszczone dane). Napisz to w treści commita: na urządzeniu, na którym przełączniki już były ruszane albo ekran ustawień był otwarty, zostaje to, co zapisane.
5. Commit `Logcat settings: off by default in release, on in debug, free to change in both`. W treści:
   - tabela;
   - zasób `@bool/logcat_on_by_default` z nadpisaniem w `src/debug`;
   - kod i XML czytają ten sam zasób (wcześniej ColdStart i WakeDetection miały `true`, a XML `false`);
   - że to nie przywraca blokady z `66961f2`.

---

## S — StrictMode także w release, jego linie w plikach logów

### Fakty
- `LauncherApplication`: `enableStrictMode()` (≈304–317, tylko `penaltyLog()`) jest wołane wyłącznie `if (BuildConfig.DEBUG)` w dwóch miejscach: `onCreate` ≈227 i `initWallpaperPickerProcess` ≈285.
- `LogcatWorker.shouldWriteAppLine` (po revercie R) ma `if (line.contains("StrictMode")) return false;`. Filtr działa tylko dla capture „launcher only”. Capture „everything” zapisuje wszystko.

### Implementacja
1. Wołaj `enableStrictMode()` bez warunku `BuildConfig.DEBUG` w obu miejscach. Zmień komentarz/javadoc: tylko `penaltyLog()`, nic nie jest przerywane; w release po to, żeby capture pokazywał naruszenia z urządzeń właściciela.
2. Usuń w `shouldWriteAppLine` linię odrzucającą `StrictMode`. Jeśli nad nią jest komentarz, dopasuj go.
3. Sprawdź `grep -rn "BuildConfig.DEBUG" app/src/main/java`, czy nic innego nie wiąże StrictMode z debugiem (np. `allowThreadDiskReads` warunkowane debugiem). Zmieniaj tylko to, co dotyczy StrictMode.
4. Commit `StrictMode: on in release too, and kept in the launcher's own capture`. W treści:
   - `penaltyLog` only;
   - koszt: stos na każde naruszenie, tylko do logu;
   - po co: capture z release pokazuje te same naruszenia co debug.

---

## Analiza logów (fakty, na nich opierają się P1–P3)

### Log B — `27-10-2026_22-03-43.txt`: pierwsze uruchomienie pełnoekranowe
- 22:03:49.078: powrót z ustawień (`Home Receiver: home clicked`) po przełączeniu panelu YouTube (`app.revanced.android.youtube`) z Window na Pinned.
- Zadanie YouTube nadal żyje w stosie 69 na wirtualnym wyświetlaczu emerytowanego `ActivityView` dawnego okna PiP. `WindowHostAvReaper: retired ActivityView, displayId=61..64` (51.255) zwalnia je dopiero, gdy wyświetlacz jest pusty.
- 51.143: `initializeAppList(): openPinnedPip()`. `openAsPinnedPip` wybiera gałąź **bez restartu**: `persist.launcher.packagename` jest już YouTube, a `checkIfMapSizeChanged` = false. Dlatego od razu woła `startPinnedPip`.
- 51.422: `START … app.revanced.android.youtube … (has extras)`. Framework FYT robi wtedy:
  - `moveTopStack toVDisplay:false toTopDefault:true`;
  - `wm_stack_removed: 69`;
  - `am_focused_stack … reparent`;
  - `am_pause_activity … Launcher`.

  **Istniejące zadanie zostaje przeniesione na wyświetlacz 0 jako pełnoekranowe**, bez tworzenia stosu pinned. Launcher się chowa.
- 54.370: kolejne uruchomienie, gdy zadania już nie ma. Tym razem `wm_stack_created: 74` i `Ignoring move of always-on-top stack` dają właściwy pinned. Kolejne uruchomienia (58.058) używają tego stosu i działają.

**Wniosek**: Pinned start działa tylko wtedy, gdy pakiet nie ma zadania poza stosem pinned. Restart (force-stop) zależy dziś wyłącznie od zmiany pakietu lub rozmiaru, a nie od tego, gdzie żyje zadanie.

### Log A — `27-10-2026_21-51-41.txt`: Pinned PiP nie pojawił się wcale
- 44.624: `openPinnedPip()`. Pakiet się zmienił, więc działa ścieżka restartu:
  - 44.670 `HomeFrontGuard: Expecting [app.revanced.android.youtube] within 3000 ms (pinned PiP restart)`;
  - force-stop, zadanie 6 usunięte;
  - `startPinnedPip` 1000 ms później, a jego `startActivity` po kolejnych 100 ms.
- Launcher w tym czasie jeszcze się przebudowuje po ustawieniach (`Recreate page`, `CloseSystemDialogs: startMapPip`, ponowne `pane launch`).
- 46.224: `START … youtube (has extras)` daje `wm_stack_created: 24`, czyli pinned, always-on-top. Proces jest zimny: `am_proc_start` 46.298, `am_proc_bound` dopiero 46.542.
- 46.476: `HomeFrontGuard: launcher covered by app.revanced.android.youtube/…MainActivity`. Guard bierze **własny pinned launchera** za aplikację przykrywającą ekran główny. Uratował go tylko przypadek: „was opened by the user, left in front”. Bez dotyku w ciągu 3 s cofnąłby launcher na wierzch.
- 46.525: `Launcher.Workspace: onPageBeginMoving()` (strony dosuwają się po przebudowie), potem `removePinnedPip()`. Framework robi wtedy:
  - `setMpip`, `lsec pin stack forcehidden:true`;
  - `E ActivityTaskManager: Trying to pause when nothing is resumed` (wtf);
  - `am_add_to_stopping … youtube … makeInvisible`.

  **Stos pinned został schowany, zanim jego aktywność zdążyła się wznowić.** Launcher nie odzyskał już `top resumed`.
- 48.223: `onPageEndMoving: openPinnedPip()` niczego nie uruchamia: brak `START` i brak `setMpip`. Kolejne `openPip()` (49.144) pokazują `Utils.topApp(): false`. Bramka `openPinnedPip` (`launcher.allowPip && Utils.topApp() && …`) odpada po cichu i nic więcej tego nie ponawia.

  W logu B ukrycie (56.279) przyszło **po** wznowieniu YouTube. Launcher wtedy odzyskał top (56.339), a `openPinnedPip` przy końcu ruchu (57.858) zadziałało.

---

## P1 — Pinned PiP: restart aplikacji, której zadanie żyje poza stosem pinned (log B)

### Implementacja
1. **`DefaultDisplayTask`** (`app/src/main/java/com/android/launcher66/DefaultDisplayTask.java`). Dodaj, w stylu `findDisplayIdField()`:
   - `public static final int WINDOWING_MODE_PINNED = 2;` (wartość `WindowConfiguration.WINDOWING_MODE_PINNED` na API 29);
   - `public static int windowingMode(TaskInfo task)`: refleksją `TaskInfo.configuration` (ukryte) → `Configuration.windowConfiguration` (ukryte) → `getWindowingMode()`. Pola i metodę rozwiązuj raz, statycznie. Przy każdym błędzie zwracaj `-1` („nieznany”);
   - `public static int displayId(TaskInfo task)` przez istniejące `DISPLAY_ID` (`-1`, gdy nieczytelne);
   - `public static RunningTaskInfo taskOutsidePinnedStack(ActivityManager am, String pkg)`: przegląda `am.getRunningTasks(Integer.MAX_VALUE)`. Zwraca pierwsze zadanie, którego `baseActivity` lub `topActivity` należy do `pkg` i które jest **poza stosem pinned**: tryb znany i różny od `WINDOWING_MODE_PINNED` albo `displayId` znany i różny od `Display.DEFAULT_DISPLAY`. W przeciwnym razie zwraca `null`.

   Decyzję „poza pinned” z dwóch liczb wydziel do czystej klasy (patrz pkt 4), a `DefaultDisplayTask` niech ją woła.
2. **`WindowUtil.openAsPinnedPip`** (≈2108–2154). Warunek restartu `!packageName.equals(currentPackage) || checkIfMapSizeChanged(pipKey)` rozszerz o trzeci człon: zadanie pakietu żyje poza stosem pinned. Odczyt zrób w `try/catch RuntimeException`; przy błędzie przyjmij „nie”. Gdy tylko ten człon przesądza o restarcie, zaloguj:
   `Log.i(TAG, "openAsPinnedPip(" + pkg + "): task " + id + " outside the pinned stack (display " + d + ", mode " + m + "), restarting it first")`.

   Reszta gałęzi restartu zostaje bez zmian: zapis prev*, `setPinnedPipBounds`, `persist.launcher.packagename`, `restartPinnedPipApp()`, `postDelayed(startPinnedPip, 1000)`. To ta sama ścieżka, która w logu A stworzyła poprawny stos pinned (`wm_stack_created: 24`).
3. **Wyjątek**: jeśli ten sam pakiet jest jednocześnie ustawiony w innym, **włączonym** slocie PiP w trybie Window (np. pierwszy PiP okno, trzeci pinned z tą samą aplikacją), nie restartuj. Force-stop zabijałby wtedy okno na każdym powrocie do domu. Zaloguj `…: also shown in a window pane, not restarted` i zostaw zachowanie jak dziś. Pakiety slotów wyznacz tak, jak robi to `openPinnedPip`/`openPip` (`firstPkg`, `secondPkg`, `Keys.PIP_THIRD_PACKAGE`, `Keys.PIP_FOURTH_PACKAGE`, flagi `Keys.PIP_*` i `LauncherApplication.isPinnedMode`). Sprawdź w kodzie, skąd biorą się `firstPkg`/`secondPkg`, i nie zgaduj.
4. **Czysta klasa** `app/src/main/java/com/syu/util/PinnedPipLaunch.java` (final, package-private, bez `android.*`; `WindowUtil` leży w `com.syu.util`, a `com.android.launcher66.PinnedPip` jest package-private w innym pakiecie). Zaczynasz ją tutaj, a P2 ją rozszerzy:
   - `static boolean outsidePinned(int windowingMode, int displayId)`: `(windowingMode >= 0 && windowingMode != PINNED) || (displayId >= 0 && displayId != 0)`;
   - `static boolean needsRestart(boolean packageChanged, boolean sizeChanged, boolean taskOutsidePinned, boolean alsoInWindowPane)`: `packageChanged || sizeChanged || (taskOutsidePinned && !alsoInWindowPane)`.

   `DefaultDisplayTask` jest w innym pakiecie, więc albo zrób te dwie metody publiczne i klasę publiczną, albo zostaw `outsidePinned` w `DefaultDisplayTask` jako `static` z testem w `com.android.launcher66`. Wybierz jedno i trzymaj się tego.

   Test `app/src/test/java/com/syu/util/PinnedPipLaunchTest.java` (lub odpowiednik), przypadki:
   - tryb pinned na wyświetlaczu 0 → false;
   - tryb fullscreen (1) na 0 → true;
   - tryb nieznany na VD 61 → true;
   - oba nieznane → false;
   - `needsRestart` dla wszystkich istotnych kombinacji, w tym `alsoInWindowPane` blokujący tylko trzeci człon.
5. Commit `Pinned PiP: restart an app whose task still lives outside the pinned stack`. W treści:
   - log B: `moveTopStack toVDisplay:false toTopDefault:true` przy 22:03:51.422, zadanie z emerytowanego VD okna PiP na pełnym ekranie;
   - dlaczego force-stop (ta sama ścieżka co zmiana pakietu, sprawdzona w logu A);
   - wyjątek dla pakietu, który jest też w oknie;
   - „on the 7870 and the phones nothing changes: openAsPinnedPip is only reached with supportsPinnedPip()”.

---

## P2 — Pinned PiP: nie chowaj stosu pinned, zanim jego aplikacja się wznowi; nie startuj w trakcie ruchu stron (log A)

### Implementacja
1. **Stan startu w `WindowUtil`** (wątek główny):
   - `private static long sPinnedStartUptimeMs` ustawiane w `startPinnedPip` tuż przed `LauncherApplication.sApp.startActivity(intent)` (wewnątrz runnable ze 100 ms);
   - `private static final long PINNED_START_SETTLE_MS = 1500L`. Uzasadnienie w komentarzu: ciepły start YouTube to ~0.4–0.5 s do `top resumed` (log B: 51.422 → 51.948, 54.370 → 54.794); zimny po force-stop jest dłuższy (log A: `am_proc_bound` 0.32 s po START).
2. **`removePinnedPip()`** (≈2242). Po istniejących bramkach (`supportsPinnedPip`, `USER_LAYOUT`), jeśli `PinnedPipLaunch.isSettling(nowUptime, sPinnedStartUptimeMs, PINNED_START_SETTLE_MS)`:
   - **nie** wołaj teraz `setPinnedStackVisible(false)`;
   - zaplanuj jedno (zbite) odroczone ukrycie na `sPinnedStartUptimeMs + PINNED_START_SETTLE_MS` przez `launcher.handler` (`postAtTime` lub `postDelayed`) z jednym współdzielonym `Runnable`, który najpierw zdejmuje swoje poprzednie wystąpienie;
   - zaloguj `removePinnedPip(): the pinned app is still starting, hidden in N ms`.

   Odroczony runnable woła właściwe ukrycie (wydziel je do `private static void hidePinnedStackNow()` z dotychczasowym ciałem i logiem `removePinnedPip() pane: dismissed`). Ukrycie jest bezwarunkowe, bo ma działać jak dziś, tylko nie przed wznowieniem. Ponowne pokazanie zostaje zadaniem istniejących ścieżek (`onPageEndMoving` → `openPinnedPip`).
3. **`startPinnedPip`**: na początku zdejmij oczekujące odroczone ukrycie, bo nowszy start wygrywa. Inaczej ukrycie zaplanowane przy `onPageBeginMoving` schowałoby PiP pokazany chwilę później przez `onPageEndMoving`.
4. **Kontrola tuż przed `startActivity`** (w runnable ze 100 ms, ścieżka bez restartu i ścieżka z restartem po 1000 ms). Jeśli `PinnedPipLaunch.mayStartNow(pagesMoving, currentPage, pipScreen, allAppsVisible)` = false, nie startuj. Zaloguj `startPinnedPip(pkg): not started (pages moving | not on page N | all apps open), left to onPageEndMoving`. Dane:
   - `pagesMoving = workspace.isPageMoving()` (publiczne w `PagedView` ≈647);
   - `currentPage = workspace.getCurrentPage()`;
   - `pipScreen = prefs.getInt(Keys.PINNED_PIP_SCREEN, 1) - 1`;
   - `allAppsVisible` jak w `openAsPinnedPip`.

   `Workspace.onPageEndMoving` (≈3810–3832) i tak woła `openPinnedPip()`.
5. **Diagnostyka bramki `openPinnedPip`** (≈2056–2065): dziś odpada po cichu. Gdy warunek jest fałszywy, zaloguj jedną linię `Log.d(TAG, "openPinnedPip(): skipped, allowPip=… topApp=… inWidgets=… …")` z wartościami składników. **Samego warunku nie zmieniaj**: po pkt 2 sytuacja z logu A (`topApp` false po ukryciu przed wznowieniem) nie powinna się powtórzyć, a log powie, jeśli jednak się powtórzy.
6. `checkIfOpenedOnTheRightScreen` (500/1500/2000 ms) zostaje. Jego wywołania `removePinnedPip()` przechodzą przez nową logikę z pkt 2, więc te w oknie 1.5 s są odraczane, a nie gubione.
7. Rozszerz `PinnedPipLaunch` i test:
   - `static boolean isSettling(long now, long startedAt, long settleMs)`: `startedAt > 0 && now - startedAt < settleMs`;
   - `static boolean mayStartNow(boolean pagesMoving, int currentPage, int pipScreen, boolean allAppsVisible)`: `!pagesMoving && currentPage == pipScreen && !allAppsVisible`.

   Przypadki testowe: granice `settleMs`, `startedAt == 0`, każda z trzech przeszkód osobno.
8. Commit `Pinned PiP: no hiding before the pinned app has resumed, no start while the pages move`. W treści:
   - log A: `forcehidden:true` 0.3 s po START, `Trying to pause when nothing is resumed`, launcher bez top, cicha bramka przy `onPageEndMoving`;
   - log B, gdzie ukrycie po wznowieniu działało;
   - „on the 7862/8581 the PiP is hidden as before, at most 1.5 s later and only right after its own start; elsewhere none of this runs”.

---

## P3 — HomeFrontGuard: stos pinned nie „przykrywa” ekranu głównego

### Fakty
- `restartPinnedPipApp()` woła `HomeFrontGuard.expectSystemLaunch(…, "pinned PiP restart")` (3000 ms), bo com.syu.ms bywa, że sam ponownie otwiera zatrzymaną aplikację.
- Własny start pinned launchera przychodzi ~1.1 s później w tym samym oknie oczekiwania. `HomeFrontGuard.front()` → `DefaultDisplayTask.topTask()` zwraca zadanie pinned (wyświetlacz 0), czyli „launcher covered by …”.
- Gdyby nie dotyk użytkownika, guard uznałby je za oczekiwane i wywołał `bringLauncherToFront`.

### Implementacja
1. W `DefaultDisplayTask.topTask()` i `defaultDisplayTasks()` pomijaj zadania z `windowingMode(task) == WINDOWING_MODE_PINNED` (gdy tryb nieznany, zachowanie jak dziś). Uzasadnij w javadoc klasy: „what is shown full screen” — pinned okno pływa nad ekranem głównym i nie jest jego przykryciem.
2. Przejrzyj **wszystkich** wołających `DefaultDisplayTask.topTask/topActivity/defaultDisplayTasks` (`grep -rn "DefaultDisplayTask\." app/src/main/java`). Dla każdego napisz w treści commita jednym zdaniem, czy pominięcie pinned jest dla niego poprawne. Jeśli któryś musi widzieć pinned, zostaw mu starą semantykę (np. parametr `skipPinned`), a nie zmieniaj zachowania na ślepo.
3. Bez zmian w `WindowUtil.reassertLauncherTop()` i `LauncherApplication.isAppTop()`: celowo używają `getRunningTasks(1)` (javadoc `DefaultDisplayTask`).
4. Test: jeśli `HomeFrontGuardTest` testuje czyste fragmenty, dopisz przypadek dla „pinned nie jest przykryciem” na poziomie czystej funkcji (np. `PinnedPipLaunch`/`DefaultDisplayTask.isFullScreenCandidate(int mode, int display)`). Jeśli nie da się tego wydzielić bez `android.*`, opisz to w commicie.
5. Commit `HomeFrontGuard: the pinned PiP does not cover the home screen`. W treści log A 21:51:46.476–477 i to, co by się stało bez dotyku.

---

## L — LogcatWorker: nazwa pliku zaczyna się od wyzwalacza i zakresu

### Wymaganie właściciela
Przed dotychczasową nazwą (`dd-MM-yyyy_HH-mm-ss.txt`) mają być dwie adnotacje:
- co uruchomiło capture: reboot / wake / użytkownik / …;
- czy plik zawiera wszystkie logi, czy tylko launchera.

Przykłady: `reboot_full_27-10-2026_21-51-41.txt`, `wake_pid_…`, `user_full_…`.

### Słownik (stałe w kodzie, małe litery)
| `Trigger` | prefiks | znaczenie |
|---|---|---|
| `COLD_START` | `reboot` | pierwszy start po restarcie urządzenia |
| `PROCESS_START` | `start` | inny start procesu launchera (crash, aktualizacja) |
| `WAKE` | `wake` | wybudzenie (`startForWake`, także start odroczony przez `wakeStartPending`) |
| `MANUAL` | `user` | przycisk „uruchom” w ustawieniach |

| Zakres | prefiks | kiedy |
|---|---|---|
| wszystko (`-b all`, jako system albo przez host VD) | `full` | `fullLog == true` |
| tylko launcher (`--pid` lub ręczny filtr pid) | `pid` | `fullLog == false`, w tym `NO_HOST` i czekanie na host |

Format: `<trigger>_<scope>_<dd-MM-yyyy_HH-mm-ss>[_N].txt`, gdzie `_N` dokłada `uniqueFile`.

### Fakty z kodu (`settings/LogcatWorker.java`)
- Nazwa powstaje w `runLogging` (≈469–474): `uniqueFile(dir, timestamp + LOG_FILE_SUFFIX)`. Dzieje się to **przed** ustaleniem zakresu: `startPlan`/`fullLog` (≈486–518) liczone są po otwarciu pliku.
- Zakres zmienia się w trakcie: `upgradeRequested` (≈546–563) przełącza na `fullLog = true`, gdy host VD dołączy. Plik ma wtedy od tego miejsca wszystko od początku capture („the launcher's own lines above repeat”).
- `fixNameForClock` (≈1488–1522) parsuje `NAME_PATTERN` **od początku nazwy** (`name.substring(0, NAME_PATTERN.length())`). Z prefiksem każda nazwa byłaby uznana za „not a name this class gave” i korekta zegara przestałaby działać. Przy zmianie nazwy odtwarza tylko `ts + suffix`, więc prefiks by zginął.
- Late dump (`runLateDump` ≈1072): `base + LATE_DUMP_SUFFIX` (`"_full.txt"`). Z nowym prefiksem dałoby to mylące `reboot_pid_…_full.txt`.
- `moveLeftoversInto` filtruje `endsWith(LOG_FILE_SUFFIX)`, więc działa bez zmian. `watchClockFor`/`NameCheck` trzymają `File` i przy rename aktualizują go w `fixPendingNames`.

### Implementacja
1. **Czysta klasa** `app/src/main/java/com/android/launcher66/settings/LogFileName.java` (final, package-private, bez `android.*`; `SimpleDateFormat` z `java.text` jest dozwolony):
   - stałe `NAME_PATTERN = "dd-MM-yyyy_HH-mm-ss"` (przenieś z `LogcatWorker` albo współdziel), `TXT = ".txt"`, `LATE_SUFFIX = "_late.txt"`;
   - `static String prefix(String triggerLabel, boolean full)` → np. `"wake_pid_"`;
   - `static String name(String prefix, String timestamp, String suffix)`;
   - `static Parts parse(String fileName)`: zwraca `prefix` (może być `""` dla starych nazw bez prefiksu), `timestamp` (pierwsze wystąpienie wzorca `\d{2}-\d{2}-\d{4}_\d{2}-\d{2}-\d{2}`) i `suffix` (`LATE_SUFFIX` albo `TXT`, bez `_N`); `null`, gdy wzorca nie ma;
   - `static String withScope(String fileName, boolean full)`: ta sama nazwa z podmienionym `_pid_`↔`_full_` w prefiksie (dla starych nazw bez prefiksu nie robi nic).
2. **`Trigger`**: dodaj pole `fileLabel` (`reboot`/`start`/`wake`/`user`) obok `label`. `label` zostaje bez zmian, bo używa go nagłówek STREAM.
3. **`runLogging`**:
   - przenieś wyliczenie `wantsFullLog`/`system`/`hostAttached`/`plan`/`viaHost`/`fullLog` **przed** utworzenie pliku. Te wartości nie zależą od pliku. Zostaw po otwarciu pliku tylko zapisy `writeLine(...)` i efekty uboczne (`awaitingHost = true`, `mainHandler.post(awaitHostOnMain)`, `syncLogdBufferSize`) w dotychczasowej kolejności;
   - nazwa to `uniqueFile(dir, LogFileName.name(LogFileName.prefix(trigger.fileLabel, fullLog), timestamp, LOG_FILE_SUFFIX))`;
   - zapamiętaj `boolean upgraded`, ustawiane w gałęzi `upgradeRequested`;
   - w `finally`, **przed** `fixNameForClock`: jeśli `upgraded`, zmień nazwę pliku na `LogFileName.withScope(name, true)` (`uniqueFile` + `renameTo`; przy porażce `Log.w` i zostaw starą). Uwaga na kolejność: po ewentualnym przeniesieniu do publicznego `Downloads` (`moveFileInto`), przed `fixNameForClock`/`watchClockFor`, przed toastem (żeby toast pokazał końcową ścieżkę) i przed `lateFor`.
4. **`fixNameForClock`**: parsuj przez `LogFileName.parse`. Nowa nazwa to `prefix + fmt.format(realStart) + suffix`, więc prefiks i rodzaj (zwykły/late) zostają. Stare nazwy bez prefiksu nadal są poprawiane jak dotąd.
5. **Late dump**: nazwa to `LogFileName.name(LogFileName.prefix(trigger.fileLabel, true), <timestamp z nazwy capture>, LATE_SUFFIX)`, np. obok `reboot_pid_27-10-2026_08-00-01.txt` powstaje `reboot_full_27-10-2026_08-00-01_late.txt`. Nagłówek `===== LATE FULL DUMP for <capture> …` zostaje, więc powiązanie z capture jest w treści. Usuń `LATE_DUMP_SUFFIX = "_full.txt"` i zastąp jego użycia.
6. Capture przedłużony przez wake (`startForWake` → `wakeExtendedLine`) zachowuje prefiks swojego wyzwalacza. Wpis „===== wake at … capture extended =====” w treści już to opisuje. Opisz to zdaniem w javadoc klasy (punkt o nazwie pliku ≈60).
7. Zaktualizuj javadoc klasy (lista ≈60–80): nazwa = wyzwalacz + zakres + czas startu; zakres może zmienić się z `pid` na `full` po dołączeniu hosta; late dump `_late`.
8. **Test** `app/src/test/java/com/android/launcher66/settings/LogFileNameTest.java`:
   - `prefix` dla 4 wyzwalaczy × 2 zakresów;
   - `parse` nowej nazwy, nazwy z `_1`, nazwy late i starej nazwy bez prefiksu;
   - nazwa bez wzorca → `null`;
   - `withScope` `pid`→`full` i no-op dla starej nazwy;
   - rename zegarowy zachowuje prefiks (`prefix + nowy ts + suffix`).

   Istniejące testy `LogcatWorker*Test` mają przejść bez zmian. Jeśli któryś zakłada starą nazwę, popraw go zgodnie z nową regułą i opisz to w commicie.
9. Commit `LogcatWorker: file names say what started the capture and what it holds`. W treści:
   - słownik prefiksów;
   - zmiana zakresu przy dołączeniu hosta;
   - `_late` zamiast `_full` dla late dump;
   - korekta zegara działa dalej (parsowanie po prefiksie);
   - stare pliki bez prefiksu są nadal rozpoznawane.

---

## I — Ustawienia: legenda nazw plików logów nad „Logcat service on startup”

### Wymaganie właściciela
Nad „Logcat service on startup” ma być preference tylko informacyjne. Wyjaśnia ono, co znaczą części nazw plików: `start`, `reboot`, `wake`, `user`, `full`, `pid`, każda w osobnej linii.

### Implementacja
1. W `res/xml/launcher_preferences.xml`, w `PreferenceCategory logcat_category`, **przed** `logcat_service` dodaj:
   ```xml
   <Preference
       android:key="logcat_names_info"
       android:selectable="false"
       android:title="@string/logcat_names_info"
       android:summary="@string/logcat_names_info_summary" />
   ```
   Klucz dopisz do `Keys` tylko wtedy, gdy kod go potrzebuje (nie powinien).
2. W `res/values/strings.xml`, tuż przed `logcat_service` (≈384), dodaj:
   ```xml
   <string name="logcat_names_info">Log file names</string>
   <string name="logcat_names_info_summary">reboot – started with the launcher after the device restarted\nstart – started with the launcher after it restarted on its own (crash, update)\nwake – started when the device woke up\nuser – started by hand with \"Logcat service\"\nfull – holds all of the device\'s logs\npid – holds the launcher\'s logs only</string>
   ```
   Sześć słów musi być **identycznych** z prefiksami z kroku L (`Trigger.fileLabel`, `LogFileName`): `reboot`, `start`, `wake`, `user`, `full`, `pid`. Zaznacz to w komentarzu XML nad stringami. Kolejność zgodna z nazwą pliku: najpierw wyzwalacze, potem zakres. Nie dopisuj innych (np. `_late`); właściciel wymienił sześć.
3. Sprawdź, czy summary pokaże 6 linii bez ucinania. Standardowy układ androidx ma `maxLines="10"`. Jeśli kategoria lub motyw używa własnego układu z mniejszym limitem, ustaw na tym jednym preference układ albo limit tak, żeby wszystkie linie były widoczne. Nie zmieniaj limitu globalnie.
4. Sprawdź, że `SettingsFragmentFirst` nie nadpisuje summary ani widoczności preferencji w tej kategorii hurtem (np. pętlą po wszystkich preferencjach). Jeśli nadpisuje, wyłącz z tego nową legendę.
5. Commit `Settings: explain the parts of the log file names above the logcat switches` (tylko angielski `values/strings.xml`, XML i ewentualny układ).

---

## T — Tłumaczenia legendy (osobny commit)

1. Dodaj oba stringi do **wszystkich 58** plików `app/src/main/res/values-*/strings.xml`. Katalogi `values-land` i `values-port` nie mają stringów. Lista: `ls app/src/main/res/values-*/strings.xml`. Pliki mają strukturę zgodną z domyślnym, więc wstaw je w tym samym miejscu: tuż przed `logcat_service`.
2. Zasady tłumaczenia:
   - **nie tłumacz** sześciu słów `reboot`, `start`, `wake`, `user`, `full`, `pid` (są częścią nazwy pliku) ani nazwy folderu;
   - tłumacz opisy po myślniku i tytuł;
   - „Logcat service” w opisie `user` zastąp tekstem, który w danym pliku ma `logcat_service_run` (tak widzi go użytkownik);
   - zachowaj `\n` jako separatory linii, dokładnie 6 linii;
   - escapuj apostrofy (`\'`) i cudzysłowy (`\"`), zwłaszcza w fr, it, ca, en-*;
   - nie wprowadzaj `%`;
   - `values-en-rGB`/`values-en-rIN`: tekst angielski (dostosuj pisownię, jeśli plik tak robi gdzie indziej);
   - język docelowy rozpoznaj po kwalifikatorze (`in` = indonezyjski, `tl` = filipiński, `rm` = retoromański, `zu` = zulu, `km-rKH`, `lo-rLA`, `mn-rMN`, `ka-rGE`, `hy-rAM`, `zh-rHK`/`zh-rTW` = chiński tradycyjny, `zh-rCN` = uproszczony).
3. Kontrola: skrypt (poza repo) sprawdza, że każdy plik ma oba klucze dokładnie raz, że summary ma 5 znaków `\n`, że każda linia zaczyna się od właściwego słowa w kolejności reboot, start, wake, user, full, pid, i że każdy plik jest poprawnym XML-em (`python3 -I -c "import xml.dom.minidom,sys; …"`). Nieescapowany apostrof psuje budowę zasobów (aapt2), więc to też sprawdź.
4. Commit `Translations: the log file name legend in every language`.

---

## 4. Czego NIE zmieniać
- Warunku bramki `openPinnedPip` (tylko logowanie), `initDefaultApp()`, `reassertLauncherTop()`, `LauncherApplication.isAppTop()`.
- Ścieżki pane’ów okiennych (`openPip`, `WindowHost*`), z wyjątkiem tego, co P1 czyta (`getRunningTasks`).
- Formatu znacznika czasu w nazwie, folderów (`Launcher66_Logs`), przenoszenia do `Downloads`, treści nagłówków capture.
- Logiki ustawień logcat poza tym, co przywraca revert R i co zmienia D (domyślne wartości). Żadnego blokowania przełączników.
- Zapisanych już wartości ustawień (żadnych migracji preferencji).

## 5. Weryfikacja
1. Po każdym commicie skompiluj zmienione czyste klasy i ich testy (`javac`, JUnit z cache Gradle, jeśli jest). Klasy z `android.*` skompiluj z `android_jar/android-36.jar` i stubami w katalogu tymczasowym.
2. `grep`:
   - po R: zero `LogcatSettings`;
   - po D: każdy odczyt czterech kluczy logcat ma domyślną `LogcatDefaults.on(...)`, a cztery wpisy XML mają `@bool/logcat_on_by_default`;
   - po S: zero `BuildConfig.DEBUG` przy `enableStrictMode()` i zero filtra `"StrictMode"` w `shouldWriteAppLine`;
   - po T: skrypt kontrolny z kroku T przechodzi dla 58 plików;
   - po P2: każde `setPinnedStackVisible(false)` w `removePinnedPip` idzie przez `hidePinnedStackNow()`;
   - po L: zero `LATE_DUMP_SUFFIX` i `"_full.txt"`.
3. Po pushu sprawdź CI ostatniego commita (`testFytDebugUnitTest`, `assembleFytDebug`, `assembleStandardDebug`). Czerwone napraw.
4. Scenariusze do sprawdzenia przez właściciela na 7862 (wypisz je w raporcie):
   - a) panel Window z YouTube → przełącz na Pinned → Home: PiP pinned od razu, bez pełnego ekranu. W logu `outside the pinned stack … restarting it first`;
   - b) to samo z przesuwaniem stron zaraz po powrocie: PiP pojawia się po zatrzymaniu stron. W logu ewentualnie `still starting, hidden in N ms` / `not started (pages moving)`;
   - c) zwykłe przewijanie z pinned PiP na swojej stronie: chowa się i wraca jak dotąd;
   - d) capture ręczny z „log everything”: plik `user_full_<ts>.txt`. Capture po wybudzeniu bez „everything”: `wake_pid_<ts>.txt`. Po restarcie urządzenia: `reboot_full_…` lub `reboot_pid_…`;
   - e) 7870 z Shizuku startującym później: `reboot_pid_<ts>.txt` zmienia nazwę na `reboot_full_<ts>.txt`, gdy host dołączy w trakcie, albo powstaje `reboot_full_<ts>_late.txt`, gdy dołączy po końcu;
   - f) świeża instalacja (lub wyczyszczone dane) release: cztery ustawienia wyłączone, „Log only for launcher”, żaden capture przy starcie i wybudzeniu. Debug: wszystkie włączone, „Log everything”. W obu przełączniki można zmieniać;
   - g) release, capture `user_pid_…`: linie `StrictMode` są w pliku;
   - h) ekran ustawień: legenda nad „Logcat service on startup”, 6 linii, sprawdzona po angielsku, po polsku i w jednym języku z apostrofami (np. francuskim).

## 6. Raport końcowy (w odpowiedzi, po polsku)
- Lista commitów (hash + temat).
- Jak rozwiązano konflikty revertu.
- Wynik CI.
- Odpowiedź na pytanie, czy któryś wołający `DefaultDisplayTask` wymagał zachowania starej semantyki (P3).
- Lista miejsc przepiętych na `LogcatDefaults` (D) i informacja, czy legenda wymagała zmiany układu (I).
- Scenariusze z pkt 5.4 do sprawdzenia.
