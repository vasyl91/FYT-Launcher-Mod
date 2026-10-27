# Launcher Mod: poprawki dla FYT 7870 (Shizuku) — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz` (najpierw `git pull origin ccr-087eed00-gbqsuz`). Masz wprowadzić poprawki opisane niżej, każdą jako osobny commit, i wypchnąć je na tę gałąź. **Nie twórz pull requesta.**

Przeczytaj najpierw `docs/log-analysis-2026-10-26.md`: to analiza logów z 7870, ale powstała z samego grepa. Poniższe sekcje mówią, co z niej potwierdzono w kodzie, co obalono i co dochodzi. **Gdy ten dokument i analiza się różnią, obowiązuje ten dokument.** Numery linii są orientacyjne (stan z 27-10-2026): sprawdzaj je w kodzie.

## 0. Kontekst urządzeń — najważniejsza zasada

| Urządzenie | Android | Jak zainstalowany | Uprawnienia | Status |
|---|---|---|---|---|
| FYT 7862 | 10 | wariant `fyt`, aplikacja systemowa (uid 1000) | system | działa, **błędów z analizy brak** |
| Xiaomi Redmi Note 8T | 14 | `standard` | root (moduł FYT VDHost) | działa, błędów brak |
| Samsung Galaxy A55 | 16 | `standard` | Shizuku Next (już działa przy starcie launchera) | działa, błędów brak |
| **FYT UNISOC 7870** (`uis7870sc_2h10_nosec`) | 13 | `standard`, **build debug** | Shizuku Next przez bezprzewodowe ADB (shell, uid 2000), **startuje minuty po launcherze albo ręcznie**; brak roota, nie da się zainstalować jako systemowa | źródło logów |

Błędy z analizy występują tylko na 7870. Poprawki mają działać **tylko w warunkach, które je wywołują** (brak hosta VD, ale Shizuku zainstalowane i w drodze; Shizuku jako shell; konkretny canbus id; konkretna zmiana konfiguracji z ROM-u). Gdzie zmiana dotyka wszystkich urządzeń, musi to być ścisła poprawa: na pozostałych trzech urządzeniach no-op albo zachowanie identyczne z obecnym. Każdą zmianę, która mogłaby zmienić coś na 7862/Redmi/A55, uzasadnij w treści commita („on the 7862 … stays as before because …”).

Wariant `fyt` i `standard` uruchamiają **ten sam kod** (różnią się tylko manifestem `app/src/fyt/AndroidManifest.xml`). Nie ma `src/standard`.

## 1. Zasady pracy i konwencje repo

- **Komentarze i commity po angielsku**, w stylu otaczającego kodu: pełne zdania, wyjaśniają *dlaczego*, często nazywają urządzenie i nagranie („capture 26-10-2026 19:45:55, 7870”). Gęstość komentarzy jak w sąsiednim kodzie.
- **Logowanie**: zwykłe `android.util.Log` z `private static final String TAG` danej klasy. Rutynowe zdarzenia na `I`/`D`, nie na `E`.
- **Commity**: temat w trybie rozkazującym `<Obszar>: <co>` (np. `LogcatWorker: read the launcher's own log while the VD host is on its way`), treść zawinięta na ~72 znaki, wyjaśnia przyczynę i skutek. Zakończ dokładnie tymi trailerami, które poda Ci system-reminder sesji. **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Jeden commit = jedna logiczna zmiana** (lista w §3). Push po każdym commicie albo po kilku: `git push -u origin ccr-087eed00-gbqsuz` (przy błędzie sieci ponów 4× z odstępem 2/4/8/16 s).
- **StrictMode** (`LauncherApplication.enableStrictMode()`, tylko debug: disk read/write, network, leaked closables/SQLite): na wątku głównym nic nie czyta dysku ani sieci. Wywołań `PackageManager` i binderów do hosta VD **nie wykonuj na wątku głównym w czasie boot-stallu** (kod robi to konsekwentnie: zob. komentarze „off the main thread” w `LauncherApplication`).
- **Bez pollingu, gdy istnieje zdarzenie.** Przyjście/odejście hosta VD ogłasza `WindowHostVdClient.addListener(Listener)` → `onHostChanged(boolean available)` (wątek główny). Każde czekanie ma **jawny, rozsądny limit czasu**, po którym kod przechodzi na zachowanie obecne (fallback) i loguje jedną linię `I`. Nic nie wisi bez końca.
- **Brak uprawnień nigdy nie jest błędem**: brak Shizuku, odmowa uprawnienia, Shizuku, które nie wstało → zachowanie jak dziś plus jedna linia informacyjna. Bez wyjątków, bez toastów o błędzie.
- **Testy**: JUnit 5 na JVM (`app/src/test/java`, `unitTests.isReturnDefaultValues = true`). Wzorzec repo: logikę decyzyjną wydziel do **czystych, package-private metod statycznych** i testuj je (zob. `LogcatWorkerTimingTest`, `HeadlightNightModeTest`, `WakeSignalsTest`). Dla każdej nowej decyzji dopisz test.
- **Budowanie**: w kontenerze zwykle nie ma Android SDK (`ANDROID_HOME` pusty). Jeśli SDK jest, uruchom `./gradlew :app:testFytDebugUnitTest :app:assembleFytDebug :app:assembleStandardDebug`. Jeśli nie ma, polegaj na CI: workflow `.github/workflows/build.yml` przy każdym pushu uruchamia `:app:testFytDebugUnitTest` i `:app:assembleFytDebug`. Po pushu sprawdź wynik narzędziami GitHub MCP (`actions_list`, `get_job_logs`) i napraw każdą czerwoną budowę, zanim pójdziesz dalej. Bez lokalnego kompilatora pisz szczególnie starannie: importy, Java 21, sygnatury istniejących metod.
- Nie dodawaj nowych zależności. Nie zmieniaj schematu bazy LitePal/Room.

## 2. Ustalone fakty (z kodu, nie z logów)

### 2.1 Dlaczego w logach `pidFlag=true` — odpowiedź na pytanie użytkownika
`LogcatWorker.runLogging()` (`app/src/main/java/com/android/launcher66/settings/LogcatWorker.java` ≈436–470) ustala zakres **raz na przechwycenie**:
```java
boolean wantsFullLog = prefs.getBoolean(Keys.LOGCAT_FULL, false);
boolean viaHost = wantsFullLog && !hasSystemPrivileges()
        && (canHostPanes() || isShizukuInstalled(ctx)) && awaitPrivilegedHost(coldStart);
if (wantsFullLog && !hasSystemPrivileges() && !viaHost)
    writeLine("===== everything: no VD host (root or Shizuku) attached, only the launcher's own log =====");
...
boolean usePidFlag = !fullLog;
```
`awaitPrivilegedHost` przed czekaniem zapisuje `===== waiting up to N s for the VD host (root or Shizuku) =====`, a po sukcesie `===== VD host attached after N s =====`. Zatem:
- **brak jakiejkolwiek linii `=====` między `===== device=…` a `----- logcat start #1`** → „Log everything” było wyłączone;
- tylko `everything: no VD host` → „Log everything” włączone, ale Shizuku niezainstalowane/nieużywalne;
- `waiting up to …` + `everything: no VD host` → włączone, ale Shizuku nie wstało w limicie (15 s, przy zimnym starcie 180 s);
- `VD host attached` → pełny log, `pidFlag=false`.

Wszystkie nagłówki od użytkownika wyglądają tak:
```
===== STREAM (PID=2174, buffer=main, timeout=60s, mode=FROM_APP_START) =====
===== device=UNISOC uis7870sc_2h10_nosec, android=13 (API 33) =====
----- logcat start #1 (pidFlag=true, sinceFlag=false) -----
```
Mówią więc jednoznacznie: **opcja była wyłączona**. Dłuższy brak Shizuku też daje `pidFlag=true`, ale zawsze zostawia w pliku linię-znacznik. Uprawnienie `READ_LOGS` nie gra roli, kod go nigdy nie sprawdza. Opisz to w raporcie końcowym.

Przy okazji wyszły trzy prawdziwe wady LogcatWorkera (naprawiasz je w C3):
1. Przy zimnym starcie, z Shizuku zainstalowanym, worker **czeka do 180 s i w tym czasie niczego nie czyta**. Jeśli Shizuku nie wstanie, czyta potem bufor `main`, a przy domyślnych buforach FYT (128 KiB, ~160 KB/s logów przy starcie) początek startu launchera jest już nadpisany.
2. Gdy Shizuku przyjdzie po upływie limitu (użytkownik uruchamia je ręcznie po kilku minutach), bieżące przechwycenie zostaje „tylko launcher” i nic go nie uzupełnia. To jest „pełen log nie zadziałał”.
3. `LogcatWorker.canCaptureAllLogs()` (≈844) = `hasSystemPrivileges() || canHostPanes()`, a `canHostPanes()` liczy Shizuku dopiero po `pingBinder()`. W release opcja „Log scope” jest więc ukryta, dopóki Shizuku nie działa. `SettingsFragmentSecond` (≈279) dla PiP już liczy „Shizuku zainstalowane” — niespójność.

Dodatkowo: przechwycenie „tylko launcher” odrzuca każdą linię z `StrictMode` (`shouldWriteAppLine`, ≈1569–1576), więc naruszeń StrictMode nie widać bez pełnego logu.

### 2.2 Model uprawnień i Shizuku
- `LauncherApplication.hasSystemPrivileges()` (≈747): uid 1000 albo `FLAG_SYSTEM`.
- `com.syu.util.WindowHostVdClient` (cały plik ~394 linie): źródła hosta `LOCAL` (system), `DAEMON` (moduł Magisk FYT VDHost), `SHIZUKU`. `hasPrivilegedHost()` = host podpięty i nie LOCAL; `HostProcess.isAvailable()` zwraca dokładnie to. `canHostPanes()` = `current()!=null || isSystemUid() || isModuleInstalled() || WindowHostVdShizuku.isUsable()`. `isShizukuInstalled(ctx)` = `getPackageInfo("moe.shizuku.privileged.api")` (forki, w tym Shizuku Next, zachowują tę nazwę; jest `QUERY_ALL_PACKAGES`). `panesAwaitHost()` = panele VD bez hosta. Listener: `addListener/removeListener`, `notifyListeners` wołane na wątku głównym; `attach()` po pierwszym podpięciu woła `openPanesIfMissing()` → `WindowUtil.startMapPip(false)`.
- `com.syu.util.WindowHostVdShizuku` (168 linii): `addBinderReceivedListenerSticky(maybeBind)`, więc bind przy przyjściu Shizuku jest zdarzeniowy, bez limitu. `isUsable()` = `pingBinder() && !isPreV11() && (permission granted || !shouldShowRequestPermissionRationale())`. Uprawnienie prosi raz na proces. Usługa użytkownika `.daemon(false)`, czyli ginie z procesem launchera.
- **Nie zmieniaj semantyki `canHostPanes()` / `canHostPips()`.** Używają ich `shouldUse()` (API 30), `WindowHostActivityView`, `openPip()` i inne. Panel VD utworzony bez hosta czeka na niego tylko 15 s (commit `fee2455`), a `openPanesIfMissing()` nie restartuje istniejących, pustych paneli. Rozszerzenie tych predykatów o „Shizuku w drodze” mogłoby zostawić puste panele na A55/Redmi. Nowe zachowanie dodajesz **osobnym predykatem** (C2) i tylko u wskazanych konsumentów.

Konsumenci, którzy dziś sprawdzają hosta raz i odpadają (pełna lista z kodu):

| Miejsce | Co robi bez hosta | Akcja |
|---|---|---|
| `LogcatWorker` ≈441–470, 856–895 | polling `SystemClock.sleep(250)`, 15/180/60 s, bez upgrade'u | C3 |
| `WakeDetection.schedulePipEnsureAttempt` ≈684–775 | 5 prób `startMapPip` → `openPip()` po cichu wychodzi (`!canHostPips()`, `WindowUtil.java` ≈588) → „gave up” | C4 |
| `CanbusService.openAccessibilitySettingsIfNeeded` ≈235–241 | przy starcie, przed Shizuku, **otwiera ustawienia dostępności** nad launcherem | C5 |
| `LauncherPermissionFlow` WRITE_SETTINGS ≈114–146 | raz na proces; bez hosta odsyła do systemowego ekranu `ACTION_MANAGE_WRITE_SETTINGS` | C5 |
| `BaselineProfileCompiler.kt` ≈240, 473, 571 (tylko release) | czeka do następnej sesji, nie reaguje na podpięcie hosta | C5 (opcjonalnie) |
| `SettingsFragmentFirst` ≈455–500 | widoczność opcji liczona raz przy otwarciu ekranu | C1/C3 |
| `ForegroundAppTracker` ≈135–168, `PaneYieldWatcher`, `WindowHostVdView` | już na listenerze | bez zmian |
| `ColdStart` BOOT_COMPLETED, `SyuMusicLibrary` (root), `WindowHostActivityView` (API 30) | nie dotyczy Shizuku-shell / API 33 | bez zmian |

## 3. Commity do wykonania (w tej kolejności)

### C1 — Debug: wszystkie przechwycenia logcat wymuszone (osobny commit, pierwszy)
**Cel:** w buildzie debug następne logi z 7870 mają zawierać wszystko, a tester nie może tego wyłączyć. W release zachowuje się zgodnie z ustawieniami, domyślnie `false`.

1. Nowa klasa `app/src/main/java/com/android/launcher66/settings/LogcatSettings.java` (final, prywatny konstruktor), jedno źródło prawdy dla czterech kluczy z `Keys.java` (≈68–73):
   - `static boolean captureAtStart(SharedPreferences p)` → `Keys.LOGCAT_SERVICE`
   - `static boolean captureAtWake(SharedPreferences p)` → `Keys.LOGCAT_SERVICE_WAKE`
   - `static boolean fullLog(SharedPreferences p)` → `Keys.LOGCAT_FULL`
   - `static boolean bootLog(SharedPreferences p)` → `Keys.BOOT_LOGCAT`
   - każda = `effective(isForced(), p.getBoolean(key, false))`; `static boolean isForced() { return BuildConfig.DEBUG; }`; czysta `static boolean effective(boolean forced, boolean stored) { return forced || stored; }`.
   - Domyślnie `false` wszędzie, zgodnie z `res/xml/launcher_preferences.xml` (≈312–343). Pole `IS_DEBUG_FEATURES_ENABLED` nie jest nigdzie używane; użyj `BuildConfig.DEBUG`, tak jak `LauncherApplication.showsPrivilegedOption()`.
2. Podmień odczyty: `ColdStart.startLogcat` (≈117, dziś `getBoolean(LOGCAT_SERVICE, true)`), `WakeDetection` (≈227, dziś `getBoolean(LOGCAT_SERVICE_WAKE, true)`), `LogcatWorker` (≈441 i ≈455), `SettingsFragmentFirst` (≈461, ≈471 i obsługa zmian ≈931–941). **W release zmienia to domyślną wartość start/wake z `true` na `false`** — decyzja użytkownika; napisz to w treści commita.
3. Ustawienia w debug (`SettingsFragmentFirst`, blok ≈345–500): cztery preferencje widoczne, zaznaczone i **wyłączone** (`setEnabled(false)`), bez zapisu do SharedPreferences. Wywołaj `setPersistent(false)` przed `setChecked(true)`, żeby instalacja release na debug (ten sam klucz podpisu, dirty install) zachowała własny wybór użytkownika. `boot_logcat` widoczne niezależnie od `canCaptureAllLogs()`. Przycisk „Run” i timeout działają jak dotąd. Nie dodawaj nowych stringów (repo właśnie wyrównało tłumaczenia): wyszarzony, zaznaczony przełącznik wystarczy. Uważaj na `CustomNoSwitchPreference` (wywołuje change listener dwa razy przy kliknięciu, ale wyłączona preferencja nie dostaje kliknięć).
4. **Bez błędów przy braku uprawnień**: przejdź ścieżki debug z wymuszonym full+boot: (a) system app (7862) → `-b all` jako uid 1000, `setprop persist.logd.size*` 8M; (b) root/moduł → przez hosta; (c) Shizuku shell → `setprop` może się nie udać, wtedy jest tylko linia-notatka (≈749–753), `logcat -G` działa; (d) brak Shizuku → linia `everything: no VD host…`, przechwycenie tylko launchera, toast sukcesu. Żadna ścieżka nie może skończyć się wyjątkiem ani toastem błędu.
5. **Sprzątanie skutku ubocznego**: boot log w debug ustawia trwale `persist.logd.size*` = 8M, a przywraca je dopiero `syncLogdBufferSize(false)` na początku *przechwycenia*. W release z wyłączonym przechwyceniem nic by ich nie przywróciło. Dodaj: przy starcie procesu w release, poza wątkiem głównym (np. z `ColdStart` albo z warm-upu), jeśli istnieje któryś klucz `logcat_boot_log_logd_size_before*` i `LogcatSettings.bootLog()` jest false, uruchom część „restore” z `syncLogdBufferSize` (wydziel ją do metody). System app: od razu; przez hosta: tylko gdy host jest podpięty, inaczej przy następnej okazji. Bez hosta i bez systemu nic nie rób (klucze zostają).
6. W debug **nie odrzucaj linii `StrictMode`** w przechwyceniu tylko-launcher (`shouldWriteAppLine` ≈1569). StrictMode działa tylko w debug, a użytkownik chce widzieć naruszenia. W release filtr bez zmian.
7. Test: `LogcatSettingsTest` dla `effective`.

### C2 — `HostAwait`: czekanie na hosta VD, który jest w drodze
Nowa klasa `app/src/main/java/com/syu/util/HostAwait.java` (pakiet `com.syu.util`, bo potrzebuje package-private `WindowHostVdClient.current()/isSystemUid()`). Specyfikacja:
- `public static boolean isExpected(Context)`: hosta jeszcze nie ma, ale może przyjść. Czysta `static boolean expected(boolean systemUid, boolean attached, boolean moduleInstalled, boolean shizukuInstalled, boolean shizukuDeniedForGood)` = `!systemUid && !attached && (moduleInstalled || (shizukuInstalled && !shizukuDeniedForGood))`.
- `shizukuDeniedForGood`: dodaj w `WindowHostVdShizuku` `static boolean isDeniedForGood()` = Shizuku działa, uprawnienie nie przyznane i `shouldShowRequestPermissionRationale()`; gdy Shizuku nie działa → false (nie wiadomo).
- „Shizuku zainstalowane” **z cache** (volatile Boolean) wypełnianego poza wątkiem głównym przy starcie (`LauncherApplication.warmUpOffMainThread()` albo równoważne). Jeśli na wątku głównym cache jest jeszcze pusty: uruchom odczyt w tle i potraktuj host jako oczekiwany. Okno jest ograniczone, więc to bezpieczne. Nie wołaj `PackageManager` na wątku głównym.
- `public static Handle await(long timeoutMs, String what, Callback cb)`, tylko wątek główny: host już jest → `cb.onResult(true)` (post); nieoczekiwany → `cb.onResult(false)` (post); inaczej `WindowHostVdClient.addListener` + `postDelayed(timeout)`. Na `available==true` usuń listener i timeout, `cb(true)`; na timeout usuń listener, `cb(false)`. Jedna linia `I` na start („<what>: waiting up to N s for the VD host (Shizuku)”) i jedna na koniec (czas albo „not within N s”). `Handle.cancel()` usuwa wszystko.
- `public static boolean awaitBlocking(long timeoutMs, BooleanSupplier stillWanted)`, tylko wątek roboczy (na głównym `Log.w` i natychmiast `false`): `CountDownLatch` zwalniany przez listener (rejestrowany przez post na główny), `latch.await` w krokach ~500 ms tylko po to, żeby sprawdzać `stillWanted`. To nie polling stanu hosta.
- Stałe okien: `WAIT_COLD_BOOT_MS = 180_000` (Shizuku przez bezprzewodowe ADB po boocie), `WAIT_WAKE_MS = 60_000`, `WAIT_SHORT_MS = 15_000`. Wybór okna należy do wołającego.
- Test `HostAwaitTest` dla `expected(...)` (wszystkie kombinacje istotne dla tabeli z §0: system → false; moduł → true; Shizuku zainstalowane i nieodrzucone → true; odrzucone na stałe → false; host podpięty → false).

### C3 — LogcatWorker: nie czekać bezczynnie, uzupełnić log, gdy Shizuku przyjdzie
Dotyczy tylko przypadku `fullLog wanted && !hasSystemPrivileges() && host not attached && HostAwait.isExpected()`. Na 7862 (system), Redmi i A55 (host od razu) ścieżka się nie zmienia.
1. **Czytaj od razu**: zamiast blokującego `awaitPrivilegedHost` zapisz `===== the VD host (Shizuku) is on its way: the launcher's own log until it attaches (up to N s) =====` i od razu uruchom przechwycenie tylko-launcher (jak dziś po fallbacku). N = 180 s przy `coldStart`, 60 s po wake, 15 s ręcznie (dodaj parametr „trigger”, zob. C11).
2. **Upgrade w miejscu**: zarejestruj `HostAwait.await(N)`. Gdy host przyjdzie, a przechwycenie jeszcze trwa (także w trakcie `draining`): ustaw volatile `upgradeRequested`, zniszcz bieżący proces logcat (odblokowuje `readLine`), a pętla po wyjściu z odczytu przełącza `fullLog=true`, `sViaHost=true`, `usePidFlag=false`, uruchamia `syncLogdBufferSize(bootLog)` i restartuje logcat przez hosta od początku przechwycenia (`-T` czasu startu przechwycenia albo całe bufory dla `isBootCapture`). Przed restartem zapisz `===== VD host attached after N s: everything since <czas> follows (the launcher's own lines above repeat) =====`. Wykorzystaj istniejący mechanizm restartu pętli (`sinceMs`, ≈601–607) i `drainKilled`. Uważaj, żeby upgrade nie liczył się jako `failedRuns`.
3. **Późny zrzut**: gdy przechwycenie skończyło się w trybie tylko-launcher, bo hosta nie było, a host przyjdzie w ciągu `LATE_HOST_WINDOW_MS` (10 min od startu przechwycenia przy zimnym starcie, 60 s w pozostałych przypadkach), wykonaj w tle jednorazowe `logcat -d -b all -v threadtime` (z `-T` startu przechwycenia, dla zimnego startu bez `-T`) przez `HostProcess` do **osobnego pliku** obok oryginału: `<nazwa>_full.txt`, nagłówek `===== LATE FULL DUMP for <nazwa oryginału>: the VD host attached N s after the capture started =====`. Ten sam mechanizm katalogów, przenoszenia i poprawy nazwy co zwykłe pliki. Jeden zrzut na przechwycenie; po oknie wyrejestruj listener. Bez hosta nic się nie dzieje i nie ma błędu.
4. `awaitHostBack` (host zniknął w trakcie, ≈880–895): zamień polling na `HostAwait.awaitBlocking(60 s, () -> running)`.
5. `canCaptureAllLogs()` = `hasSystemPrivileges() || canHostPanes() || HostAwait.isExpected(ctx)` (dodaj parametr `Context`), żeby w release „Log scope” było widoczne, gdy Shizuku jest zainstalowane, ale jeszcze nie działa (zgodnie z `SettingsFragmentSecond` ≈279).
6. Dopisz linię zakresu po decyzji (nagłówek `buffer=main` jest mylący przy `-b all`): `===== scope: everything (-b all, through the VD host) =====` / `… (as system)` / `===== scope: the launcher's own log (--pid) =====`.
7. Testy: wydziel czystą decyzję „co zrobić na starcie” (system / host jest / host w drodze / brak) i okna (cold/wake/manual → ms) i przetestuj.

### C4 — PiP ensure po wake: czekać na hosta zamiast palić próby (P1)
`app/src/main/java/com/android/launcher66/settings/WakeDetection.java`. Pętla jest per proces (singleton), więc recreate jej nie restartuje. Czeka już na launcher (`MAX_PIP_ENSURE_LAUNCHER_WAITS`) i na rebuild (`MAX_PIP_ENSURE_REBUILD_WAITS`), ale nie na hosta VD.
1. W `schedulePipEnsureAttempt`, gdy PiP nie stoi: jeśli konfiguracja ma panele VD (dual/first/second, albo third/fourth nie w trybie pinned; patrz `isPipUp` ≈798–828) i `WindowHostVdClient.panesAwaitHost()`:
   - `HostAwait.isExpected()` → **stan „host wait”**, który nie zużywa próby: jeden `HostAwait.await(WAIT_WAKE_MS, "PiP ensure", …)` na generację. Po `true`, jeśli generacja aktualna: `schedulePipEnsureAttempt(generation, attempt, 500)` (najpierw rusza `openPanesIfMissing`; debounce w `WindowUtil` łapie duplikaty, a pętla potem sprawdza zdrowie). Po `false`: `Log.i("PiP ensure: no VD host within 60 s; the panes come up when it attaches")` i koniec. **Bez „gave up”.**
   - host nieoczekiwany (brak Shizuku/modułu, nie system) → `Log.i` raz i koniec, bez 5 bezsensownych prób.
   - Handle anuluj przy nowej generacji (sleep/wake/restartPip).
2. Ostatnia próba nie jest dziś weryfikowana: „gave up” loguje się w chwili wywołania 5. `openPip`. Po ostatniej próbie zaplanuj jeszcze jedno *sprawdzenie* (bez nowego `openPip`) po `PIP_ENSURE_DELAYS_MS[last]` i dopiero wtedy loguj `healthy after N retries` albo `gave up`.
3. Diagnostyka „wake-stormu” (6 cykli onPause/onResume w 16 s po wake na 7870, przyczyna w ROM-ie): w `Launcher.onPause`, w oknie `WAKE_HOME_RECOVERY_WINDOW_MS` po wake, jedna linia `I`: `onPause N s after the wake, in front: <pakiet albo unknown>`. Pakiet z `ForegroundAppTracker` (ostatni znany) albo `unknown`. Żadnych nowych zapytań do systemu na wątku głównym. Zachowania przy pause/resume **nie zmieniaj**.
4. Test: czysta decyzja `hostWait(boolean vdPanesConfigured, boolean panesAwaitHost, boolean hostExpected)` → `NONE / WAIT / NO_HOST`.

### C5 — Pozostali konsumenci Shizuku
1. `CanbusService.openAccessibilitySettingsIfNeeded()` (≈235): jeśli `HostAwait.isExpected()` → `HostAwait.await(okno: 180 s, jeśli uptime < 3 min, inaczej 60 s)`; po wyniku sprawdź ponownie `ForegroundAppTracker.isActive()` (tracker sam przejmuje po podpięciu, ≈135–168) i dopiero wtedy ewentualnie otwórz ustawienia. Anuluj przy `onDestroy` serwisu.
2. `LauncherPermissionFlow` krok WRITE_SETTINGS (≈114–146): jeśli hosta brak, ale jest oczekiwany, **nie oznaczaj kroku jako obsłużonego** (`sPermissionStepsHandled`); przejdź do następnych kroków, a po `HostAwait.await(60 s)` (albo do końca okna zimnego startu) przeplanuj flow (`schedulePermissionFlow`). Dopiero po upływie okna fallback na ekran systemowy. `allowWriteSettingsThroughHost()` to blokujące wywołanie bindera na wątku głównym. Jeśli przeniesienie poza wątek główny jest proste (wynik → post), zrób to; jeśli wymaga przebudowy flow, zostaw i opisz w raporcie.
3. (Opcjonalnie, tylko release) `BaselineProfileCompiler.kt`: przy `!canCompileNow()` i `HostAwait.isExpected()` zamiast czekać na następną sesję zarejestruj jednorazowe `await` (do 10 min od startu procesu) i uruchom to samo zadanie po podpięciu. Bez zmian w liczeniu prób.

### C6 — Recreate przy zmianie świateł (P2), decyzja: `uiMode` + diagnostyka
Fakty: launcher sam nigdy nie zmienia trybu nocnego (brak `UiModeManager`/`setDefaultNightMode`). `HeadlightNightMode` stosuje zmianę świateł po 1500 ms, a Activity ginie 72 ms po „Lights on”, więc to ROM 7870 zmienia konfigurację. `AppTheme` dziedziczy po `Theme.MaterialComponents.DayNight.NoActionBar.Bridge` (`res/values/styles.xml:3`), folderów `-night` nie ma, Launcher to `AppCompatActivity` z `configChanges="mcc|mnc"` (`AndroidManifest.xml` ≈133).
1. Manifest, tylko activity `com.android.launcher66.Launcher`: `android:configChanges="mcc|mnc|uiMode"`. Istniejące `Launcher.onConfigurationChanged` (≈4713–4722) zostaje; dopisz `Log.i` z nowym `uiMode & UI_MODE_NIGHT_MASK`, gdy się zmienił. Nie wołaj `recreate()`. W commicie wyjaśnij: na A55 przełączenie ciemnego motywu przestaje odtwarzać launcher; widoki launchera nie używają zasobów `-night`; AppCompat aktualizuje konfigurację zasobów dla dialogów tworzonych później.
2. Diagnostyka: w `Launcher.onDestroy` jedna linia `I`: `isChangingConfigurations()` i `getChangingConfigurations()` jako hex plus nazwy. Czysta `static String configChangeNames(int)` (mapuje `ActivityInfo.CONFIG_*`, nieznane bity jako hex) z testem. Jeśli po poprawce 7870 nadal odtwarza (np. zmiana assets/overlay, której nie da się zadeklarować), następny log to pokaże.
3. `stopServicesOnDestroy()` (≈3269): przy `isChangingConfigurations()` **nie zatrzymuj `NightModeService`**. Jego `onDestroy` (≈214–223) anuluje SunTask całego procesu (także ten od świateł i joba), a nowa instancja i tak woła `startService`, które jest idempotentne (komentarz `NightModeService` ≈82). `CanbusService` i `FabOverlayService` zostaw, chyba że sprawdzisz w kodzie, że ich `onStartCommand` jest idempotentne (FabOverlay dodaje widoki overlay, ryzyko podwójnego dodania).
4. `LauncherAppState.setApplicationContext` (≈56–60): gdy `context.getApplicationContext() == sContext`, wyjdź bez ostrzeżenia; ostrzeżenie zostaw dla innego kontekstu.

### C7 — Assety parkingu (P3)
Fakty: `assets/` ma tylko `Can_Back.ogg`, `firenze.apk`, `litepal.xml`, katalogu `parking/` nigdy nie było. `Callback_0080_RZC_XP1_QiJun.in()` (≈94–95) dla canbus id 458832 (0x70050 = `CAR_RZC_XP1_17QiJun_H`) buduje `Parking_RZC_QiJun`, który ładuje 13 assetów. Wynik i tak trafia do `ParkingHelper.buildUi()`, który jest pusty (≈133–136), więc widok jest budowany i wyrzucany. Kod mod robił to samo z Door/Air: `DoorHelper.buildUi`, `AirHelper.buildUi` puste, konstruktory `Air_*` zakomentowane w `Callback_0080` (≈86–90). 7862 ma inny canbus id, dlatego tam błędów nie ma.
1. `com.syu.util.ToolkitRes.loadDrawable` (≈13–20): strumień w try-with-resources (dziś nie jest zamykany, StrictMode wykrywa leaked closable); zamiast `printStackTrace` jedna linia `Log.w(TAG, "asset missing: " + fileName)` **raz na nazwę** (`ConcurrentHashMap.newKeySet()`, które pamięta brakujące nazwy i pomija ponowne `open`); zwracaj dalej `new ColorDrawable(0)`, bo wołający nie obsługują `null`.
2. Nie buduj widoków parkingu, które idą do pustego `ParkingHelper.buildUi`: `Callback_0080_RZC_XP1_QiJun` ≈94–95, `Callback_0143_XP1_QiJun` ≈36, `Callback_0101_WC1_QiJun` ≈53, `Callback_0443_WC2_YingFeiNiDi_GX50` ≈145. Zakomentuj tak samo jak Air, z jednym zdaniem dlaczego. Najpierw sprawdź, że konstruktory `ParkingBase` i podklas nie rejestrują niczego używanego gdzie indziej (callbacki danych canbus potrzebne np. dla statystyk paliwa). Jeśli rejestrują, zostaw konstrukcję, wtedy wystarczy pkt 1.
3. Nie dodawaj assetów. To, czy moduł canbus `0080_RZC_XP1_QiJun` jest właściwy dla auta, to pytanie do użytkownika, nie zmiana w kodzie (dopisz do raportu).

### C8 — Klucz API i współrzędne w logach (P10)
`com/syu/weather/WeatherManager.java`: URL z `appid` i pełnymi `lat/lon` logowany w ≈570 (`Log.d("hzq", "getWeatherNew url = " + url)`), ≈671 (`HTTP error … for URL`), ≈680 (`Network error`); ≈572 loguje pełną odpowiedź (zawiera współrzędne). Dodaj czystą `static String redactUrl(String url)`: `appid=` → `appid=***`, `lat`/`lon` zaokrąglone do 2 miejsc. Użyj jej we wszystkich trzech miejscach. Zamiast pełnej odpowiedzi loguj tylko kod i długość. Test w `WeatherManagerDistanceTest` albo nowym `WeatherManagerRedactTest`. **Klucza nie przenoś ani nie zmieniaj**: jest w publicznym źródle, rotacja to decyzja użytkownika (napisz to w raporcie).

### C9 — Noc/dzień (P8)
1. **Błysk pełnej jasności po wake w nocy**: `HeadlightNightMode.sLightsOn` (≈30) przeżywa sen. Przy ACC off światła gasną, więc przy wake `applyForSavedTimes(…, "wake")` (`WakeDetection` ≈284) bierze „światła zgaszone = dzień = 255”, a noc wraca dopiero przy następnym raporcie MCU (w logu B po 16 s). Dodaj `HeadlightNightMode.onSleep()`: `sLightsOn = UNKNOWN`, `MAIN.removeCallbacks(APPLY)`. Wołaj ją z `WakeDetection.onSleep`. Po wake decydują wtedy zapisane wschód/zachód, dopóki MCU nie zgłosi świateł; to dokładnie udokumentowana semantyka klasy („as long as the MCU has not reported the input yet, the sunrise/sunset times decide”). Sprawdź w `CarStates`, czy `U_LAMPLET` jest ponownie dostarczane po wake, i opisz to w komentarzu. Rozszerz `HeadlightNightModeTest`.
2. `SunTask.useFallbackCalculation()` (≈231–244) nie ustawia `dayLength` (pole ≈71), stąd w logach `day length (in ms): 0`. Ustaw `dayLength = sunset - sunrise` (przed korektami). `dayLength` służy tylko do logów i cache, więc zmiana jest kosmetyczna i bezpieczna.
3. **Nie zmieniaj** `DEFAULT_NIGHT = 0` ani mapowania 0/255 → poziom FYT 0. To wybór użytkownika i zachowanie z 7862; ewentualny minimalny poziom to pytanie do użytkownika (raport).
4. Powtarzane `JOB: Scheduled job successfully` to ten sam `JOB_ID = 123` nadpisywany przy każdym uruchomieniu SunTask; tapety są już deduplikowane (`alreadyApplied` ≈405–412). Bez zmian, najwyżej obniż poziom logu.

### C10 — Praca po sygnale uśpienia i podwójne przebudowy szuflady (P7)
1. Po ACC off ROM wysyła `CloseSystemDialogs` → `moveToDefaultScreen` → `onPageBeginMoving`/`removePinnedPip` → `onPageEndMoving`/`openPinnedPip` (`Workspace.java` ≈3610–3667). Żadna ścieżka PiP nie sprawdza `WakeDetection.isAsleep()` (≈178, używane tylko w `ColdStart` ≈560). Dodaj czystą `static boolean skipPipForSleep(boolean asleep, long sinceSleepMs)` = `asleep && sinceSleepMs < 30_000`, z akcesorem czasu uśpienia w `WakeDetection` (elapsedRealtime). Pomijaj `WindowUtil.startMapPip` i `openPinnedPip` tylko w tych 30 s po sygnale uśpienia, jedna linia `I` na sen. Limit chroni przed sytuacją, w której przegapiony wake blokowałby PiP na zawsze. `pressHomeButton` ×2 (300 ms i 5 s) jest celowe, nie ruszaj. Test dla `skipPipForSleep`.
2. `AppsCustomizePagedView.onPackagesUpdated` (≈457–504) przebudowuje listę widgetów i strony bez sprawdzenia zmian, a `LauncherModel.PackageUpdatedTask` (≈2932–2941) zawsze woła `bindPackagesUpdated` (bluetooth/gms/wellbeing „aktualizują się” przy każdym wake). Policz sygnaturę nowej listy (kolejne `ComponentName` providerów widgetów i aktywności skrótów) i wyjdź wcześnie, gdy jest równa bieżącej (`Log.d`). Nie zmieniaj `LauncherModel`: zmiana listy widgetów bez zmiany aplikacji ma dalej przebudowywać.

### C11 — LogcatWorker: czytelność plików (P9)
1. Do nagłówka `STREAM` dopisz `trigger=cold start|process start|wake|manual` (wartość `mode=` zostaw bez zmian, testy i czytelnicy jej używają). Wołający podają trigger: `ColdStart` (cold/process), `WakeDetection.startForWake` (wake), przycisk w ustawieniach (manual, `SettingsFragmentFirst` ≈1130). Przy `startForWake` przedłużającym trwające przechwycenie wpisz w plik `===== wake at N s of uptime: capture extended =====`.
2. Znacznik skoku zegara w środku pliku: na czas przechwycenia zarejestruj (wątek główny) odbiornik `ACTION_TIME_CHANGED`/`TIMEZONE_CHANGED`. Przy zmianie policz przesunięcie `(currentTimeMillis − elapsedRealtime)` względem wartości ze startu i ustaw volatile znacznik, który wątek roboczy wpisze przed następną linią: `===== CLOCK CHANGED by <describeOffset> at N s of uptime: the lines below use the new time =====`. Wykorzystaj istniejące `describeOffset()`. Istniejący odbiornik po przechwyceniu (rename, ≈1250–1283) zostaje. Wyrejestruj w `finally`/`finishOnce`.
3. Położenie banera `moved here from` — kosmetyka, nie ruszaj.

### C12 — Higiena (P6, P11) i drobne błędy
1. `WakeDetection`: `Log.e` → `Log.i` dla rutynowych zdarzeń (≈236 „Device awakened”, ≈330 „Device put to sleep”, ≈278 „Sleep duration exceeded”, ≈628 „AppListDialogFragment dismissed”).
2. `Launcher.initVariable` ≈2037 „Not the system launcher of an FYT unit, KWAPI can not be created.”: na 7870 warunek jest poprawny (`hasSystemPrivileges()` = false; `isFytDevice()` = true, bo działają tam `StockSources`). Zmień na `Log.d` raz na proces (static flag).
3. `Hotseat.java` ≈55 i ≈129: `JLog.getInstance().e(...)` → `Log.d`. Wartość `-1/0` przy ≈129 bierze się z odczytu przed pierwszym layoutem i jest nieszkodliwa.
4. `Workspace.triggerStripEmptyScreens` (≈2996–3009) jest już debounced (`removeCallbacks` + `postDelayed`); log przy każdym wywołaniu (≈2997) zmień na `Log.d`.
5. **SQL `"index"`** (`BarRows.java:41`, `LitePal.order("\"index\" asc")`): ostrzeżenie SQLite „(28) double-quoted string literal” znaczy, że nie ma kolumny o nazwie `index`, więc SQLite potraktował `"index"` jako literał i `ORDER BY` jest stałą: dolny pasek idzie w kolejności rowid. Sprawdź w źródłach LitePal (`com.github.guolindev:LitePal`, commit `8ad8322cc6`; `DBUtility` — konwersja nazw kolumn będących słowami kluczowymi i klauzul order/where), jak naprawdę nazywa się kolumna i czy `order("index asc")` bez cudzysłowów jest przepisywane. Popraw zapytanie zgodnie z tym, co ustalisz, oraz komentarze w `AppMultiple.java` (≈27–29) i `AppListAdapter.java` (≈228). Schematu nie zmieniaj. Jeśli nie możesz zweryfikować w źródle, **nie zmieniaj** i opisz w raporcie.
6. `SystemUiBridgeService` (≈14–18) to stub dla FYT SystemUI (akcje wifi/bt/signal; nikt w repo go nie startuje). `stopSelf(startId)` przy każdej komendzie daje na 7870 pary create/destroy co ~8 s (plus wymuszony GC LeakCanary w debug). Zatrzymuj go dopiero 30 s po ostatniej komendzie (`Handler` na głównym: `removeCallbacks` + `postDelayed(stopSelf)`, ponownie uzbrajane przy każdym `onStartCommand`). Na 7862 (pojedynczy start) usługa po prostu żyje 30 s dłużej.

## 4. Czego NIE zmieniać (z uzasadnieniem do raportu)
- **P4 (wolny zimny start)**: logi pochodzą z buildu debug (brak Baseline Profile, JIT, weryfikacja klas, `-Xcheck:jni`, LeakCanary ~600 ms). W tej rundzie tylko usuwamy zbędną pracę (C7) i niczego nie dokładamy na wątek główny. Pomiar na release w osobnej rundzie.
- **P5**: LeakCanary to `debugImplementation`, a debug na 7870 jest celowy (testy). Bez zmian.
- `android:enableOnBackInvokedCallback`: na A13/A14 zmieniłby dostarczanie BACK (`onKeyDown`/`onBackPressed`) w całej aplikacji. Ostrzeżenie to tylko szum.
- `avc: denied … calculator2`, `.dm`, ANGLE, `NetworkSecurityConfig`, `Parcel: Expecting binder`, `PeopleSpaceWidgetProvider gives no size` — szum systemowy.
- Ścieżka „Shizuku Next na 7870 startuje dopiero po przełączeniu bezprzewodowego debugowania i Wi-Fi” — **nie badaj** (decyzja użytkownika). Kod ma jedynie poprawnie czekać (C2–C5).
- Semantyka `canHostPanes()`/`canHostPips()` (zob. §2.2).

## 5. Weryfikacja
1. Testy JVM: nowe (`LogcatSettingsTest`, `HostAwaitTest`, testy decyzji LogcatWorker, `hostWait`, `configChangeNames`, `redactUrl`, `skipPipForSleep`, `HeadlightNightModeTest`) i wszystkie istniejące zielone (`:app:testFytDebugUnitTest`).
2. CI `Build` zielone na ostatnim commicie (sprawdź przez GitHub MCP). Jeśli masz SDK, zbuduj też `assembleStandardDebug`.
3. Przegląd własnego diffu pod kątem: wątek główny (brak I/O i binderów przy starcie), wycieki listenerów (każde `addListener` ma `removeListener` po wyniku, timeoucie lub anulowaniu), generacje w `WakeDetection`, zachowanie na system app (7862) i przy hoście od razu (A55) — **identyczne jak przed zmianą**.
4. Scenariusze dla użytkownika do powtórzenia na 7870 (spisz w raporcie): (a) zimny reboot bez ręcznego startu Shizuku; (b) zimny reboot i Shizuku włączone po ~1 min oraz po ~5 min; (c) ACC off → ACC on przy włączonych światłach; (d) szybki toggle świateł ×3. Kryteria: w pliku są linie `scope:` i `trigger=`; przy (b) w środku pliku jest `VD host attached …` albo powstaje `_full.txt`; brak `FileNotFoundException` z parkingu; brak `gave up after` przy braku hosta (zamiast tego jedna linia `no VD host within…`); przy (c)/(d) jedno `onCreate` Launchera albo w `onDestroy` widać, która zmiana konfiguracji je wymusiła; brak `appid=` z kluczem; brak błysku jasności 255 po wake po zmroku; brak otwierania ustawień dostępności przy starcie, gdy Shizuku jest w drodze.

## 6. Raport końcowy (w odpowiedzi, po polsku)
- lista commitów (hash + temat) i dla każdego punktu analizy P1–P11: zrobione / pominięte / nie dotyczy, z jednym zdaniem dlaczego;
- odpowiedź na pytanie o `pidFlag=true` (§2.1);
- pytania do użytkownika: właściwy moduł canbus (0080 RZC XP1 QiJun?), minimalna jasność nocna, rotacja klucza OpenWeather, ewentualnie WRITE_SETTINGS poza wątkiem głównym (jeśli pominięte);
- czego szukać w następnych logach z 7870.
