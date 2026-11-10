# Analiza logów Launcher66 (FYT, UNISOC 7870, Android 13) — brief dla Opus

Cel: jedno źródło prawdy z 4 przejrzanych logów logcat (`LogcatWorker`, okno 60 s). Poniżej błędy, anomalie i rzeczy do poprawy, od najważniejszych. Oznaczenia: **[OBS]** = widać w logu, **[HIP]** = wniosek/hipoteza do potwierdzenia w kodzie. Ścieżki źródeł to wyniki `grep` po komunikatach (katalog `app/src/main/java/com/...`), samych implementacji nie czytałem.

## 0. Przejrzane logi

| Plik | PID | Co to jest | Uwagi |
|---|---|---|---|
| `…19-38-06.txt` (A) | 2680 | zimny start procesu launchera 26-10, ~60 s | zegar +1 h na starcie (20:38 → 19:38), 2 przeładowania Activity przy zmianie świateł |
| `…19-45-55.txt` (B) | 2680 | cykl ACC off → sleep → ACC on, ~60 s po wake | zawiera też pre-roll z bufora logcat (19:42:55–19:43:36), potem luka 2 min snu |
| `reboot2` (C) | 2174 | zimny start po reboocie, zegar 24-10 04:35 | skok zegara o +2d16h38m po ~46 s |
| `reboot3` (D) | 2136 | to samo, drugi reboot | skok zegara +2d16h47m; przebieg niemal identyczny jak C |

C i D wyglądają na starszy build (brak rozbicia `first frame` na `shareHandler/model/loader`, `onCreate` 892 ms zamiast 238 ms).
Logi C/D/A zawierają zdublowane stacktrace'y `System.err` (patrz P3) — to ok. 40 % linii.

---

## P1 (wysoki) — PiP „gave up after 5 attempts" po wake + przeładowanie Activity w trakcie

**[OBS]** (log B)
- 19:45:55.877 ACC on → `Device awakened from sleep`.
- W 16 s **6 cykli onPause/onResume** (55.9, 56.1, 58.96, 59.22, 02.33, 02.54), każdy wyzwala `removePinnedPip` / `startMapPip` / `Widget bar refreshed` / `Wake home recycler restore` (fastHome, newIntent:retry0, focus:now, focus:retry0).
- `pipWatchdog(onResume): no VD host yet, the panes start when it attaches` — host wirtualnego wyświetlacza nigdy się nie podpiął w tym oknie.
- `PiP ensure: PiP not up, calling openPip` próby 0–4 → 19:46:09.587 `PiP ensure: gave up after 5 attempts` (13,7 s po wake).
- 19:46:11.836 `Lights on (U_LAMPLET=1)` → **72 ms później** `onPause/onStop/onDestroy` Launchera i `onCreate` od nowa (pełny rebind).
- PiP wstał dopiero po rebindzie: `initializeAppList(): openPinnedPip()` 19:46:15.142 → **~19 s po wake**.

**Wniosek [HIP]:** budżet prób `WakeDetection` jest wypalany w okresie „wake-stormu" i tuż przed nieuniknionym recreate; po recreate licznik nie jest resetowany, a ostateczny sukces zapewnia przypadkowo inna ścieżka (`initializeAppList`).

**Do zrobienia**
- `WakeDetection.java` (~l.111–120, 686–770; stałe `MAX_PIP_ENSURE_*`): zresetować `attempt` przy zmianie instancji Launchera (onDestroy→onCreate) lub liczyć próby dopiero gdy host VD istnieje i lifecycle jest stabilny (brak pause/resume przez N ms). Zamiast „gave up" po 5 próbach — jawny retry po `VD host attached`.
- `LauncherPipStarter.java`, `WindowUtil.java` (`pipWatchdog`): zdarzenie „VD host attached" jako wyzwalacz zamiast pollingu.
- Metryka akceptacji: czas wake → pierwsze widoczne PiP < 5 s, bez `gave up` w logu.

## P2 (wysoki) — pełne `onDestroy/onCreate` Launchera przy każdej zmianie świateł (night/day)

**[OBS]** (A: 19:38:36 lights on, 19:38:47 lights off — 11 s odstępu; B: 19:46:11)
Każdy toggle = destroy + create: `bindAddScreens`, `bindAllApplications`, ponowny `startMapPip → openPinnedPip` (~2,5 s), `Custom elements still being set up … hurrying it` (watchdog 750 ms), `Wake home recycler restore: watchdog…`, 5× `triggerStripEmptyScreens`, `RecyclerView: No adapter attached`, `Parcel: Expecting binder but got null!`, `setApplicationContext called twice` (ten sam obiekt), `getTextBeforeCursor on inactive InputConnection`. Do tego `NightModeService` jest niszczony razem z Activity (`Service destroyed`) i w A wstaje dopiero 7,4 s później.

**[HIP]** recreate wynika ze zmiany `uiMode` (night) bez `configChanges="uiMode"` w manifeście albo z jawnego `recreate()` (w grepie `recreate()` jest tylko w `SettingsActivity.java:125`, więc raczej konfiguracja systemowa).

**Do zrobienia**
- Sprawdzić `AndroidManifest.xml` dla `Launcher`: dodać `uiMode` do `android:configChanges` i obsłużyć `onConfigurationChanged` (podmiana tapety/kolorów bez rebinda), albo przynajmniej **debounce** przełączeń świateł (np. 1–2 s; 11-sekundowe mignięcie świateł w A to realny przypadek: tunel/auto-światła).
- Nie niszczyć `NightModeService` razem z Activity.
- `Launcher.java`: usunąć/zabezpieczyć drugie `setApplicationContext`.

## P3 (średni, łatwa wygrana) — 13 wyjątków `FileNotFoundException` z assetów parkingu przy każdym starcie

**[OBS]** (A, C, D identycznie) `gandy: CanBus initDrawable iParkPage = 0`, potem 13 stacktrace'ów z `ToolkitRes.loadDrawable(ToolkitRes.java:15)` ← `Parking_RZC_QiJun.initDrawable(:94-…)` ← `ParkingBase.init` ← `Callback_0080_RZC_XP1_QiJun.in(:95)` ← `HandlerCanbus` (wątek główny, `UiNotifyEvent`):
`parking/parking_null.png`, `parking/qijun/parking_00{1..6}.webp`, `parking/qijun/parking_00{1..6}_p.webp`.
Zalewa log (~270 linii z ~730), kosztuje czas na main thread przy starcie.

**Do zrobienia**
- Sprawdzić, czy pliki powinny być w `assets/parking/qijun/` (mod mógł je usunąć/źle spakować) — jeśli tak, dodać.
- W `com.syu.util.ToolkitRes.loadDrawable`: łapać brak assetu, zwracać `null`, logować **raz** jednolinijkowo zamiast `printStackTrace`; w `Parking_RZC_QiJun` tolerować `null`.
- Rozważyć, czy moduł canbus `0080_RZC_XP1_QiJun` jest właściwy dla tego auta (czy to nie błędna konfiguracja canbusa) — **do potwierdzenia z użytkownikiem**.

## P4 (średni) — start na zimno wolny: first frame 4,3–5,4 s, main thread zablokowany 2–4 s

**[OBS]**
- A: `first frame 5420 ms` (instantiate 1116, inflate 712, untilDraw 714); `onCreate` Activity 1652 ms; `Main thread not responding for 2064 ms… responding again after 3990 ms`, stack: `Launcher.initVariable(Launcher.java:2014)` → `setContentView` → `installDecor/generateLayout`; `Choreographer: Skipped 230 frames`.
- C/D: first frame 4346/4703 ms; `application classloader create took 1312/1359 ms`; `installContentProviders 906/834 ms`; `Skipped 117/143 frames`; w D `LauncherApplication.onCreate()` 892 ms, z czego **LeakCanary 604 ms**.
- `Verification of HandlerCanbus.getCallbackCanbusById(int) took 189–220 ms` (676 KB alloc) — ogromna metoda weryfikowana przy starcie.
- `Verification of MediaFavoriteController.currentStockTrackKey() took 105 ms`.
- Dziesiątki `Method … com.google.android.gms.* failed lock verification and will run slower` (+ „non-optimized dex code and incorrect proguard optimizations").
- `ProfileInstaller: Installing profile` dopiero ~10 s po starcie; `Unable to open base.dm` → brak profilu przy pierwszym uruchomieniu.
- `Compiler allocated 11MB to compile LogcatWorker.runLogging` — JIT kompiluje pętlę logowania.

**Do zrobienia**
- `Launcher.initVariable`/`setContentView`: zmierzyć, co robi nadmierną hierarchię (inflate 700 ms, decor 1,6 s); odroczyć widgety/„custom elements" poza pierwszą klatkę.
- Rozbić `HandlerCanbus.getCallbackCanbusById` (wielki `switch`) albo dodać do baseline profile (`perf/BaselineProfileCompiler.kt` już istnieje — sprawdzić, czy obejmuje te klasy).
- Przejrzeć reguły R8/proguard dla `com.google.android.gms.*` (lock verification) lub usunąć zbędną zależność.

## P5 (średni) — LeakCanary i `-Xcheck:jni` w buildzie na jednostce

**[OBS]** `Late-enabling -Xcheck:jni` (typowe dla `debuggable`), `LeakCanary: Updated config…`, `Watching instance of…` w każdym logu; po każdym `Watching` po ~5,0 s pojawia się `Explicit concurrent copying GC` (19:42:55→43:00.53, 43:03.0→43:08.04, 38:36.5→38:41.5 freed 17 MB itd.) — to wymuszone GC-e LeakCanary.

**[HIP]** zainstalowany jest wariant debug/debuggable. **Do zrobienia:** upewnić się, że LeakCanary jest tylko `debugImplementation`, a dla jednostki budować release bez `debuggable` (CheckJNI + wymuszone GC + 100–600 ms w `Application.onCreate`).

## P6 (średni) — `SystemUiBridgeService` tworzony i niszczony w pętli

**[OBS]** (B) pary `LeakCanary: Watching instance of …SystemUiBridgeService (received Service#onDestroy())` co ~8 s: 19:42:55.495/.503, 43:03.006/.017, 43:28.0, 43:35.5, 45:59.733/.749, 46:04.540/.547 — zawsze **dwie instancje w odstępie ≤ 14 ms**; w C/D i A pojedynczo przy starcie.

**[HIP]** pętla start/stop usługi (np. `startService` + natychmiastowe `stopSelf`, lub dwóch klientów). **Do zrobienia:** znaleźć miejsca startu `SystemUiBridgeService`, ustalić, czemu powstają dwie instancje i dlaczego co kilka sekund; utrzymać usługę długo żyjącą albo startować tylko na zdarzenie.

## P7 (średni) — praca UI/PiP po sygnale uśpienia + zdublowane przebudowy

**[OBS]** (B) po `ACC off` (19:43:28) i `U_ARM_SLEEP_WAKEUP = 0 (asleep)` (43:30.2) system dalej: `CloseSystemDialogs → removePinnedPip` (30.75), `onPageEndMoving: openPinnedPip()` (31.62), `PackageUpdatedTask … [com.android.bluetooth]`, przebudowa szuflady `AppsCustomizePagedView` page 0‥2 **dwukrotnie pod rząd** (08.9–09.04 i 31.64–31.69; podobnie 46:03.4, 46:27.2–27.4), `pressHomeButton` dwa razy (28.4 i 33.1), a `onPause/onStop` dopiero 43:35.9 (7,8 s po ACC off).

**Do zrobienia**
- Gdy `WakeSignals` mówi „asleep", pomijać `startMapPip/openPinnedPip`.
- `AppsCustomizePagedView`: usunąć podwójne budowanie stron; w `LauncherModel.java` (`PackageUpdatedTask, no launcher activity left after update`) nie przebudowywać siatki, jeśli lista aplikacji się nie zmieniła (bluetooth/wellbeing/gms „aktualizują się" przy każdym wake/boocie).

## P8 (średni) — noc/dzień: jasność 0/255, powtarzane SunTask i tapety, dzień-długość 0

**[OBS]**
- `Applying night brightness 0/255 as FYT level 0/100` (A 19:38:37, B 19:46:13). **[HIP]** poziom 0 może wygasić podświetlenie; sprawdzić minimalny dopuszczalny poziom (clamp ≥ 1–5 %) w `DayNightBrightness`.
- Przy wake `Applying day brightness 255/255 (wake, lights)` o 19:45:55 (po zachodzie 17:14), noc dopiero po `Lights on` 16 s później → błysk pełnej jasności w ciemności. Rozważyć użycie ostatniego stanu świateł/nocy przy wake.
- `SunTask` przeliczany i `JOB: Scheduled job successfully` 4× w 36 s (A: 19:38:12, :20, :37, :48) i 2× w B; tapeta ustawiana przy każdym toggle (`Default wallpaper set: Night/Day`) — deduplikować, gdy wynik identyczny; `WallpaperManager.set*` jest drogie i powoduje przerysowanie.
- Dla C/D (zegar zły) ścieżka `TwilightCalculator` zwraca `day length (in ms): 0 (00:00:00)`, a ścieżka „today's answer" ~36,5 Ms — niespójność w `SunTask.java`; naprawić wypełnianie długości dnia.
- Pozytywne: `NightModeService: Clock changed (TIME_SET …) → refreshing` poprawnie przelicza po korekcie zegara.

## P9 (niski/średni) — `LogcatWorker` i zegar

**[OBS]**
- Zegar RTC po reboocie jest ~2d16h za późno; `LogcatWorker` poprawnie przemianował plik i dopisał stopkę, ale **wewnątrz pliku nie ma znacznika w miejscu skoku** (C: 04:36:31 → 20:14:34; A: 20:38:07 → 19:38:08 w kolejnych liniach) — czytelnik logu musi domyślać się skoku. Dodać inline `===== CLOCK JUMP +X at <uptime> =====` przy `TIME_SET`.
- `Directory not usable: /storage/emulated/0/Download/Launcher66_Logs (Operation not permitted)` wczesnym boocie + fallback do katalogu app-private i późniejsze przeniesienie — **działa dobrze**; baner `moved here from…` ląduje raz w środku (C), raz w nagłówku (D) — kosmetyka.
- Nagłówek `mode=FROM_APP_START` także dla przechwycenia wywołanego przez wake (B) — mylące; rozważyć osobny tryb (`FROM_WAKE`). Plik B zawiera pre-roll z bufora (pożądany, ale warto go opisać w nagłówku).
- Watchdog `Main thread not responding …` + stacktrace jest bardzo użyteczny — zostawić.

## P10 (bezpieczeństwo/prywatność) — klucz API i współrzędne w logach

**[OBS]** `hzq: getWeatherNew url = https://api.openweathermap.org/data/2.5/weather?appid=<KLUCZ>&units=metric&lat=…&lon=…` w pełnym brzmieniu w logu zapisywanym do publicznego `Download/Launcher66_Logs`. Klucz jest też stałą `OPEN_WEATHER_APPID` w `app/src/main/java/com/syu/weather/WeatherManager.java:52`.
**Do zrobienia:** nie logować URL z `appid` (redakcja) ani dokładnych współrzędnych (zaokrąglić do 2 miejsc) ; klucz przenieść do `BuildConfig`/`local.properties` i **zrotować** (jest już w logach przekazanych poza urządzenie). `WeatherManager`: odświeżanie przy starcie idzie ze „starą" pozycją i złym zegarem — OK, ale odpowiedź w C przyszła dopiero po korekcie zegara (~14 s opóźnienia); można poczekać na `TIME_SET`/łączność.

## P11 (niski) — higiena logów i konfiguracji

- `OnBackInvokedCallback is not enabled` (przy każdym `onStart`): dodać `android:enableOnBackInvokedCallback="true"` i przetestować przycisk wstecz.
- `SQLiteLog: (28) double-quoted string literal: "index"` — zapytanie używa `"index"` jako literału; użyć apostrofów/backticków (przy starcie, wątek DB).
- `JLog E: Hotseat orientation mIsLandscape == true` / `Cell width = -1 Cell Height = 0` — poziom E dla zwykłej informacji; `-1/0` sugeruje liczenie przed pomiarem (sprawdzić, czy nie wpływa na układ).
- `WakeDetection E: Device put to sleep (acc)` / `Device awakened from sleep (acc)` — normalne zdarzenia logowane jako ERROR → zmienić na I.
- `Launcher W: Not the system launcher of an FYT unit, KWAPI can not be created.` przy każdym `onCreate` — upewnić się, czy warunek jest poprawny (czy KWAPI jest oczekiwane) i zdegradować do jednorazowego D, jeśli to zamierzone.
- `triggerStripEmptyScreens` 5× w jednej klatce — scalić.
- `avc: denied { getattr } … /odm/app/190000000_com.android.calculator2/…` (C, D) — nieszkodliwe odmowy SELinux przy skanowaniu; zignorować lub pominąć ten pakiet w skanerze.
- `Widget …PeopleSpaceWidgetProvider gives no size, sized 136x95 px` — widget systemowy bez rozmiaru; sprawdzić, czy ma być w ogóle osadzany.
- `Unable to open …unisoc-framework.dm / unipnp-framework.dm / base.dm`, ANGLE, `NetworkSecurityConfig`, `Parcel Expecting binder` — szum systemowy, bez akcji (poza `Parcel` — sprawdzić `putBinder(null)` przy starcie, jeśli łatwo).

---

## Co jest w porządku (nie ruszać)
Pamięć stabilna (≈8,5–10 MB / 33–43 MB, brak OOM), brak crashy/ANR (watchdog wykrywa tylko krótkie blokady), fallback katalogu logów i rename po skoku zegara działają, `startMapPip coalesced` dedupuje wywołania, w śnie brak aktywności (2 min ciszy w B), pogoda i SunTask po `TIME_SET` liczą poprawnie.

## Sugerowana kolejność prac
1. P3 (szybko, zdejmuje 40 % szumu i koszt z main thread) → 2. P1+P2 (realny problem UX po wake/zmianie świateł) → 3. P5+P6 (build/usługa) → 4. P4 (start) → 5. P8, P7 → 6. P10 (klucz API — niezależnie, najlepiej od razu) → 7. P9, P11.

## Weryfikacja po poprawkach
Powtórzyć te same scenariusze z `LogcatWorker`: (a) zimny reboot, (b) ACC off → ACC on z włączonymi światłami, (c) szybki toggle świateł ×3. Kryteria: brak `FileNotFoundException`, brak `gave up after`, jedno `onCreate` Launchera na scenariusz (a)/(b), `first frame` < 3 s, brak `Explicit … GC` z LeakCanary, brak `appid=` w logu, jasność nocna ≥ ustalonego minimum.

