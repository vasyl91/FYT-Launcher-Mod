# Launcher Mod: poprawki rundy 1, poprawki z logów 7870, pasek dolny (uchwyt, pasek z widżetami, pasek na każdej stronie) — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `429ce279`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

Błędy z §2.2 są już znalezione i potwierdzone. Naprawiasz dokładnie je, według instrukcji z commitów. Reszty kodu rundy 1 nie przerabiasz.

## 0. Kolejność commitów i jej powód

| # | Temat commita | Źródło | Dlaczego tutaj |
|---|---|---|---|
| C1 | `Settings: info rows show their whole text` | §2.2 a | Mały, widoczny błąd. Niezależny. |
| C2 | `StrictMode: pane displays without a disk write on the main thread, favorite states read early` | §2.1 1–2 | Zasada „bez naruszeń StrictMode”. |
| C3 | `PiP: the watchdog leaves the panes alone after the sleep signal` | §2.1 3 | Mały, niezależny. |
| C4 | `Logs: the renamed capture's note uses the shift the lines show, the stall report names every place` | §2.1 4–5 | Tylko diagnostyka. |
| C5 | `Music widget: a missing com.syu.media file is not a refused one` | §2.2 b–e | Okładka BT z rundy 1. |
| C6 | `VD host: readFile checks the file it opened, CI keeps the Magisk module` | §2.2 f, i | Dotyczy hosta i modułu Magisk. |
| C7 | `FYT code: the fuse costs nothing on the CAN path, the config diff without reflection` | §2.2 g–h | Mały, niezależny. |
| C8 | `Bottom bar: a wider edge handle that takes only a swipe to the right` | nowa funkcja | C11 pokazuje ten uchwyt także na innych stronach. |
| C9 | `Widget bar: the date and the weather can be hidden, the music widget takes their room` | nowa funkcja | Nowy układ muzyki, z którego korzysta C10. |
| C10 | `Widget bar: large text option` | nowa funkcja | Dotyczy obu układów muzyki z C9. |
| C11 | `Bottom bar: on every page` | nowa funkcja | Największy. Korzysta z C8–C10. |
| C12 | `Docs: README for the new bar options` | wszystkie | Tylko to, co widzi użytkownik. |

**Każdy commit buduje się samodzielnie i przechodzi testy.** Wypychaj go od razu. Przed następnym commitem poczekaj na zielone CI.

## 1. Zasady pracy (obowiązują w każdym commicie)

**Język i treść:**
- Komentarze, Javadoc, `Log.*` i opisy commitów piszesz **wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, które wyjaśniają *dlaczego*.
- **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.

**Commity:**
- Temat `<Obszar>: <co>` (tematy z tabeli §0). Treść zawijaj na ~72 znaki i wpisz do niej fakty z §2.
- Zakończ commit dokładnie trailerami z system-remindera sesji.
- Push: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy, z odstępem 2/4/8/16 s.

**CI:**
- Workflow to `.github/workflows/build.yml`, z `cancel-in-progress`. Sprawdzaj run **ostatniego** commita przez GitHub MCP (`actions_list`, `get_job_logs`).
- Czerwony build naprawiasz kolejnym commitem. Bez amend i bez force-push.

**StrictMode jest włączony.** W nowym kodzie na wątku głównym nie może być:
- I/O plików;
- zapytań do bazy;
- zapytań do `ContentResolver`;
- sieci;
- `su`;
- blokujących wywołań hosta VD.

Prefy zapisuj przez `apply()`.

**Testy:**
- JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `BarSwipeGestureTest`, `MusicWidgetPlanTest`, `settings/CrashLoopPolicyTest`.
- `unitTests.isReturnDefaultValues = true`.
- Logikę decyzyjną pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:**
- Bez nowych zależności (Flexbox już jest).
- Bez zmiany schematu bazy launchera.
- Bez zmiany numeru protokołu VD hosta.
- Nowe klucze prefów dodawaj w `settings/Keys.java`.

**Napisy:**
- Nowy string dodaj do **każdego** z 59 plików `res/values*/strings.xml`, które mają `logcat_names_info_summary` (w tym domyślny `res/values/strings.xml`).
- Tłumaczenie ma być naturalne w języku pliku, nie dosłowne.
- Apostrofy i cudzysłowy escapuj jak w sąsiednich wpisach.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/` (`--glob '!**/generated/**'`, Java, Kotlin, XML, gradle, workflowy, skrypty).

## 2. Fakty

### 2.1 Logi 7870 (05-11-2026, wersja standard z hostem Shizuku, sprzed rundy 1): co zostało do naprawy

**1. StrictMode, `createDisplay` przez hosta.** 3 razy przy starcie: DiskRead, DiskRead i DiskWrite, każdy 70–88 ms, na wątku głównym launchera.
- Ścieżka wywołania:
  - `WindowHostVdView.SurfaceCallback.surfaceCreated` → `createDisplayIfPossible` (≈469) → `VdHostProtocol.Proxy.createDisplay`;
  - w hoście `VdHostStub` → `VdHostCore.createDisplay` (≈228) → `applyImePolicy` (≈448);
  - `IWindowManager.setDisplayImePolicy` → system_server `DisplayWindowSettingsProvider.writeSettings`, czyli zapis pliku.
- Polityka StrictMode wątku idzie razem z wywołaniem binder, więc system_server zgłasza naruszenie launcherowi („# via Binder call”). Wątek główny czeka na ten zapis.
- Przejęcie wyświetlacza dawcy (wybudzenie) nie woła `createDisplay`, więc tam naruszenia nie ma.

**2. StrictMode, pierwszy odczyt `media_favorite_state`.** DiskRead 19 ms.
- Ścieżka: `DataNotifier.run` → `LauncherMusicWidget.updateFavoriteButtonState` (≈1344) → `MediaFavoriteController.getCachedPublicFavoriteState` (≈2414) → `getSharedPreferences("media_favorite_state")`.
- Plik nie jest wczytywany z wyprzedzeniem w `LauncherApplication.attachBaseContext` (≈115). Inne pliki są.

**3. Watchdog PiP po ACC off.**
- Przebieg:
  - ACC off;
  - `WakeDetection.pressHomeButton` przenosi launcher na wierzch (celowo);
  - `onWorkspaceShown` planuje `pipWatchdog`;
  - watchdog dwa razy wymusza `initPip(…, true)`;
  - kończy `E Launcher: pipWatchdog(...): PiP still did not start after 2 attempts - giving up`.
- `LauncherPipStarter.schedulePipWatchdog/runPipWatchdog` (≈39/59) nie pyta `WakeDetection.skipPipWork()` (≈93). `openPinnedPip` już pyta.

**4. Notatka o zmianie nazwy pliku logu.**
- Nagłówek mówi `CLOCK CHANGED (was behind by 12d 03:38:16)`, a stopka `the clock was behind by 12d 04:38:17 … times logged before it was corrected are off by the same amount`.
- Różnica 1 h to zmiana czasu (25-10-2026).
- `LogcatWorker.fixNameForClock` (≈1520) liczy w ms epoki, a linie logcata są w czasie lokalnym. Stopka myli się więc o 1 h.

**5. Raport zawieszenia wątku głównego.** `Main thread not responding for 2003 ms, busy, 3 different places in 3 samples, it is at:` pokazuje tylko ostatni stos. Watcher w `LogcatWorker` (≈1742) pamięta tylko `lastStack`.

**Nie do naprawy w launcherze** (nie zmieniaj, opisz w raporcie):
- `dev.igor.fytcustomservice` wywołuje HOME 4 razy po wybudzeniu;
- `Choreographer … in the future`, `ziparchive … .dm`, `OnBackInvokedCallback` i powolny cold boot to framework i urządzenie;
- `Parcel` i `SurfaceSyncer` (wyjaśnione w rundzie 1).

### 2.2 Błędy w kodzie rundy 1 (znalezione w przeglądzie, do naprawy)

**a) Ucięta legenda logów.**
- `logcat_names_info` i `logcat_locations_info` w `res/xml/launcher_preferences.xml` (≈317–326) to zwykłe `Preference`. Układ AndroidX daje podsumowaniu `maxLines=10`.
- Po dodaniu linii `compat – …` legenda ma 8 długich linii. Na wąskim ekranie przekracza 10 wierszy i ucina się po „…failed on this unit or”.

**b) `com/fyt/car/SyuMediaFiles.read`: brak pliku traktowany jak odmowa.**
- Brak pliku uruchamia wszystkie drogi (direct, potem `su` do 3 s, potem host) i blokuje ścieżkę na 30 s (`sFailedAt`).
- Okładka BT (`/data/blink/Id3_CoverArt.JPEG`) pojawia się około sekundy po zmianie utworu. Odczyty po 1,5/3/6 s (`StockBtSource.readCover`) trafiają wtedy w blokadę.
- Przy niepowodzeniu zapamiętanej drogi pętla próbuje jej drugi raz (np. `su` dwa razy).

**c) Paczka ikon `/odm/app/cabinet.data`.**
- `SyuMediaFiles.copyTo` czyta cały plik do pamięci z limitem `HostFilePolicy.MAX_BYTES` = 2 MB.
- Paczka większa niż 2 MB nigdy nie przejdzie przez root ani host. Rozmiaru nikt nie loguje.

**d) `StockCoverLoader.toPng(Resources,int)`.** `BitmapFactory.decodeResource` daje null dla drawable wektorowego lub XML. Typ `radio1..3` com.syu.media jest nieznany.

**e) Toast `syu_media_favorite_note` „raz na proces”.** Proces launchera żyje od startu do startu, więc komunikat wraca przy każdym uruchomieniu auta. Ma być jednorazowy.

**f) `vdhost/shared/.../HostServices.readFile`: sprawdzenie i otwarcie to dwa kroki.**
- Najpierw `getCanonicalPath` i `isFile`, potem `ParcelFileDescriptor.open(file)`.
- `/storage/emulated/0/radio_logo/` może zapisać każda aplikacja z dostępem do pamięci. Między krokami plik da się podmienić na dowiązanie, a host (root, shell, system) otworzy jego cel.

**g) `FytCompat.run(...)` na gorących ścieżkach.**
- `UiNotifyEvent.dispatch`, `Callback.Massage.refesh` oraz `update()` w `ModuleCallbackMain`, `ModuleCallbackSound`, `ModuleCallbackCanbusProxy`, `ModuleCallbackCanUpProxy` i `CanbusService.statsCallback` budują `"… code " + code` i lambdę przy każdym zdarzeniu i każdym słuchaczu.
- Przy częstotliwości danych CAN daje to dużo śmieci dla GC.

**h) `ConfigChanges.diff` woła `Configuration.diff` refleksją** z komentarzem „not in the public SDK”. To publiczne API od API 1.

**i) CI buduje moduł Magisk (`:vdhost-server:magiskZip`), ale go nie wysyła.** Właściciel nie ma skąd pobrać modułu po zmianach hosta. Wynik: `vdhost/server/build/outputs/magisk/FYT-VDHost-<version>.zip`.

### 2.3 Pasek dolny dziś

**Pasek wbudowany i nakładka:**
- Pasek wbudowany jest częścią pierwszej strony: `Workspace.createUserPage` (≈880–970) wstawia `workspaceView` z `rl_allapps`, `iv_list_bg`, `recycler_view` oraz widżetami paska.
- Auto-hide (`Keys.AUTO_HIDE_BOTTOM_BAR`):
  - pasek wbudowany się zwija;
  - odsłonięty pasek to drugi egzemplarz układu w oknie `TYPE_APPLICATION_OVERLAY` (`Workspace.showOverlayBottomBar` ≈1559, w `BarSwipeFrame`);
  - nakładka chowa się po `AUTO_HIDE_TIMEOUT`.
- Poziomy swipe na nakładce przewija strony (`BarSwipeFrame` → `Workspace.handleExternalSwipe`, reguły w `BarSwipeGesture`), a sama nakładka wtedy znika (`HIDE_BAR`).

**Kiedy nakładka się chowa:**
- dotyk poza nią (`ACTION_OUTSIDE`, Workspace ≈1701);
- swipe po pasku stanu (`StatusBarSwipeDetector` ≈127);
- licznik (`scheduleAutoHide` ≈2669, `hideOverlayUnlessTouched` ≈2279);
- `Launcher.onPause` (≈2954 `hideAutoHideBarIfShown`; `cleanWidgetBar` ≈5670 robi to tylko przy `autoHide && widgetBar`);
- `onDetachedFromWindow`.

**Uchwyt `BottomBarEdgeHandle`:**
- Jest tylko bez lewego paska (`mEdgeHandleMode = autoHide && !leftBar`, ≈894) i tylko na pierwszej stronie (`shouldShowEdgeHandle` ≈2451).
- Odświeżają go `showWorkspace` (≈7583), `showOverviewMode` (≈7600), `showAllApps` (≈7649) i pauza (≈2961).
- Z lewym paskiem zamiast uchwytu jest przycisk `show_bar`.
- Geometria:
  - pasek widoczny 1% dłuższej krawędzi;
  - przezroczysty margines 1%, przycięty do `Helpers.getBottomBandLeftClearance` (`applyEdgeHandleGeometry` ≈2462);
  - razem ≈25 px na 1280 px.
- **Każde dotknięcie okna jest zjadane**: tap i swipe w prawo otwierają pasek, ruch pionowy jest ignorowany, a pod spód nic nie trafia.
- Pod uchwytem są wyłącznie okna launchera:
  - okno aktywności (DragLayer);
  - okna paneli PiP (`WindowHostSinglePane`, `TYPE_APPLICATION_PANEL`, ≈579), które same przekazują dotyk do wirtualnego wyświetlacza.

**Rezerwacja pasa (tylko pierwsza strona):**
- `CellLayout`: `isBarRowExcluded` / `isFirstBottomCellExcluded` (≈4534/4540), `shouldExcludeLastRow` / `shouldExcludeFirstBottomCell` (≈1586/1590), przeniesienie elementów spod paska (≈4700–4780);
- prostokąty elementów: `Helpers.checkAndResetIfOverlappingOnScreen` (≈555) i domyślne pozycje (≈962), tylko ekran 0;
- kreator: `DrawViewFirstScreen` (≈290, `creator_bar`, `creator_bar_auto_hide`). `DrawViewOtherScreens` pasa nie zna.

**Pasek z widżetami (`Keys.WIDGET_BAR`), układy `custom_layout_two_user{,_left}.xml` w `layout-land` i `layout-port`:**

| Element | Poziom | Pion |
|---|---|---|
| `recycler_view` | 0,4395 | 0,4385 |
| `rl_music_two` | 0,28 | 0,295 |
| `bar_widget_date` | 0,05 | brak |
| `bar_widget_weather` | 0,12 | 0,15 |

- Wartości to `constraintWidth_percent`.
- Łańcuch ograniczeń: `rl_music_two` → `bar_widget_date` → `bar_widget_weather` → prawa krawędź.

**Muzyka w pasku:**
- `res/layout/music_bar_content.xml`: okładka `iv_album_bg_two`, potem kolumna `music_bar_column` z `tv_musicName_two`, `tv_artist_two` i rzędem `music_bar_buttons` (kolejno prev, play/pause, next, favorite).
- Rozmiary liczy `MusicWidgetSizer.applyBar` z `MusicWidgetPlan.planBar` (≈147):
  - `BAR_STANDARD {0.25, 0.25, 0.45, 0.05}`, `BAR_COMPACT {0.42, 0.52, 0.06}`;
  - `textPx = rowPx / LINE_FACTOR (1.3)`;
  - jedna linijka, gdy `barCompact`: pasek ≤ 12% krótszego boku. **Ten próg zostaje.**
- Na 7870: `bar 359x66 -> compact=true … row=27 text=20.77`.

**Tekst pogody i daty:**
- `weather_city1`, `weather_weather1`, `weather_temp1`: `Workspace.adjustTextSize(tv, 0.65f)` → `fitBarText` (≈1104).
- `date` / `curWeek` (`DateTwo`, `WeekDayTwo`) mają `textSize=0sp` i dopasowanie we własnych klasach widżetów (sprawdź).

**Ustawienia:**
- `res/xml/creator_preferences.xml` (≈107–147): `start_page`, `auto_hide_bottom_bar`, `auto_hide_timeout`, `resizable_bottom_bar`, `bottom_bar_height`, `choose_bar_background`, `black_bar`, `widget_bar`, `left_bar`, `layout_margin`.
- Obsługa w `settings/SettingsFragmentSecond`:
  - widoczność zależnych wierszy jak `autoHideSeekBar.setVisible(autoHideBool)` (≈523, ≈721);
  - zmiana paska przez `helpers.setBarSettingsChanged(true)`;
  - `widget_bar` ma już click listener (≈544).
- Zagnieżdżony przełącznik to `settings/CustomSwitchPreference`: sam ustawia `nested_preference_category_switch` i wcięcie `SettingsActivity.nestedPaddingStart`. Wzorzec: `fab_overlay_button_left/right`.

## C1 — `Settings: info rows show their whole text`
1. Dodaj `settings/InfoPreference extends Preference`. W `onBindViewHolder` ustaw podsumowaniu:
   - `setSingleLine(false)`;
   - `setMaxLines(Integer.MAX_VALUE)`;
   - `setEllipsize(null)`.

   Wzorzec: `VersionPreferenceCategory`.
2. Użyj jej dla `logcat_names_info` i `logcat_locations_info`.
3. Zamień też inne niewybieralne wiersze informacyjne z wielowierszowym podsumowaniem (`rg 'selectable="false"' app/src/main/res/xml`). Wymień je w commicie.
4. Treści stringów nie zmieniaj.

## C2 — `StrictMode: pane displays without a disk write on the main thread, favorite states read early`
1. **`VdHostCore.createDisplay` (≈228).** `applyImePolicy(displayId)` ma iść na nowy jednowątkowy `HandlerThread` „vdhost-ime”.
   - Nie używaj `mFocusHandler`: `scheduleFocusRestore` (≈645) czyści go przez `removeCallbacksAndMessages(null)`.
   - Przed wywołaniem sprawdź, czy wyświetlacz nadal jest w `mDisplays`. Zwolniony pomiń.
   - Log: `ime policy for display N applied in X ms`.
   - Komentarz ma wyjaśniać, że system zapisuje przy tym ustawienia na dysk, a wywołujący (wątek główny launchera) nie może na to czekać.
   - Zmiana jest w `vdhost/shared`, więc obejmuje host lokalny, Shizuku i Magisk.
2. **Wczytanie z wyprzedzeniem.** W `LauncherApplication.attachBaseContext` (≈115) dopisz `getSharedPreferences(MediaFavoriteController.PREFS_NAME, MODE_PRIVATE)`. Stałą zrób package-private albo public.
   - Dopisz też inne nazwane pliki prefów czytane w ścieżce startu z wątku głównego (`rg 'getSharedPreferences\("' app/src/main/java`). Wymień je w commicie.
3. Numer protokołu bez zmian.

## C3 — `PiP: the watchdog leaves the panes alone after the sleep signal`
1. W `LauncherPipStarter.schedulePipWatchdog` i na początku `runPipWatchdog`: gdy `WakeDetection.skipPipWork("pipWatchdog")`, wyzeruj `mPipWatchdogRetries` i wyjdź bez logu E.
2. W ścieżce snu `WakeDetection` (tam, gdzie po ACC off jest `removePip`) wywołaj `cancelPipWatchdog()` przez `Launcher`.

## C4 — `Logs: the renamed capture's note uses the shift the lines show, the stall report names every place`
1. **Notatka o zmianie nazwy.**
   - W `fixNameForClock` policz przesunięcie tak, jak widzą je linie logcata: `offBy + tz.getOffset(realStartMs) - tz.getOffset(shownMs)`.
   - Gdy różni się od przesunięcia epoki, dopisz `(<epoch offset> in real time; a daylight-saving change lies in between)`.
   - Wydziel czystą funkcję. Test: Europe/Warsaw, 24-10-2026 04:35:44 → 05-11-2026 08:14:01 daje `12d 03:38:17` dla linii i `12d 04:38:17` w czasie rzeczywistym.
2. **Raport zawieszenia** (≈1742–1790).
   - Zbieraj do 5 różnych miejsc próbek: pierwsza ramka z `com.android.launcher66`, `com.syu.` albo `com.fyt.`, a bez takiej ramki pierwsza ramka stosu.
   - Do linii `Main thread not responding …` dopisz `places: <a>; <b>; …`. Pełny ostatni stos zostaje.

## C5 — `Music widget: a missing com.syu.media file is not a refused one`
1. **Polityka odczytu.** Czysta klasa `com/fyt/car/SyuMediaReadPolicy` z testem. Wynik każdej drogi to `OK`, `MISSING` albo `DENIED`.
   - Droga direct używa `Os.stat`:
     - `ENOENT` daje `MISSING`: koniec bez `su` i hosta, bez blokady;
     - `EACCES` / `EPERM` daje `DENIED`: następna droga.
   - Blokada 30 s działa tylko wtedy, gdy wszystkie drogi dały `DENIED` albo błąd. Dla rodziny `bt-cover` blokady nie ma wcale.
   - Zapamiętana droga, która zawiodła, nie jest próbowana drugi raz w tej samej pętli.
2. **Limit per rodzina.**
   - `icon-pack`: do 64 MB, kopia strumieniowa (bez całego pliku w pamięci) przez direct, root (`su -c cat` do pliku tymczasowego w `cache/stock_res/`) i host (deskryptor z `readFile`).
   - Pozostałe rodziny: 2 MB jak dziś.
   - Raz na proces zaloguj `StockCovers: icon pack <bytes> bytes, <way>`.
   - W `HostFilePolicy` dodaj osobny limit dla `ICON_PACK`. Test w `HostFilePolicyTest`.
3. **`StockCoverLoader.toPng(Resources,int)`.** Gdy `decodeResource` da null, użyj `ResourcesCompat.getDrawable(r, id, null)` i narysuj go na `Bitmap` o wymiarach własnych, najwyżej `MAX_PX`.
4. **Toast `syu_media_favorite_note`** ma się pokazać raz na zawsze: flaga w prefach `Keys.SYU_MEDIA_FAVORITE_NOTE_SHOWN`, zapis przez `apply()`. Statyczna flaga zostaje jako ochrona w obrębie procesu.

## C6 — `VD host: readFile checks the file it opened, CI keeps the Magisk module`
1. W `HostServices.readFile` kolejno:
   1. `Os.open(path, O_RDONLY | O_NOFOLLOW | O_CLOEXEC)`;
   2. `Os.fstat(fd)`: `S_ISREG` i rozmiar w limicie z C5;
   3. `Os.readlink("/proc/self/fd/" + fd)` musi być równy `path`;
   4. dopiero wtedy `ParcelFileDescriptor.dup(fd)` i zamknięcie oryginału.
2. Kontrole ścieżki w `HostFilePolicy` zostają jako pierwsze sito. Decyzję po `fstat` i `readlink` wydziel do `HostFilePolicy` i przetestuj (dowiązanie, katalog, za duży plik, inna ścieżka po `readlink`).
3. W `build.yml` po kroku `magiskZip` dodaj `upload-artifact` `vdhost-magisk-module` z `vdhost/server/build/outputs/magisk/*.zip`.
4. Bez zmiany protokołu.

## C7 — `FYT code: the fuse costs nothing on the CAN path, the config diff without reflection`
1. **`FytCompat`.** Dodaj przeciążenie, które buduje nazwę obszaru tylko przy błędzie, np. `run(String prefix, int code, Runnable r)` z `report(prefix + code, e)` w `catch`.
   - Na ścieżkach z §2.2 g) nie twórz lambdy ani tekstu na zdarzenie: `try`/`catch` w miejscu albo jedna lambda w polu.
   - Klucze raportów i liczniki bez zmian.
2. **`ConfigChanges.diff`.** Zamień refleksję na `before.diff(after)` i usuń błędny komentarz. Dla null zostaje `-1`.

## C8 — `Bottom bar: a wider edge handle that takes only a swipe to the right`
Cel właściciela:
- przezroczysty obszar dotyku przy uchwycie ma być szerszy;
- ma łapać tylko swipe w prawo, który otwiera pasek;
- tap w ten obszar ma trafić do tego, co jest pod nim.

1. **Geometria.**
   - `TOUCH_MARGIN_FRACTION` = 0,035 dłuższej krawędzi, nie mniej niż 24 dp. Na 1280 px okno ma ≈58 px.
   - Pasek widoczny zostaje 1%.
   - Usuń przycięcie do `getBottomBandLeftClearance`: tap i tak trafia do widżetu.
   - Wysokość bez zmian.
2. **Arbiter gestu.** Czysta klasa `BottomBarEdgeGesture` z testem, wzorem `BarSwipeGesture`.

   | Sytuacja | Decyzja |
   |---|---|
   | `dx ≥ touchSlop` i `dx ≥ 1,5·|dy|` | `OPEN_BAR`: pasek się otwiera, reszta gestu jest zjadana |
   | `|dy| ≥ touchSlop` i `|dy| > |dx|`, albo `dx ≤ −touchSlop` | `PASS` |
   | Bez decyzji dłużej niż `ViewConfiguration.getTapTimeout()` | `PASS` (długie przytrzymanie działa pod spodem) |
   | UP bez decyzji, DOWN na widocznym pasku | `OPEN_BAR` (tap w sam pasek otwiera jak dziś) |
   | UP bez decyzji, DOWN na marginesie | `PASS` (DOWN i UP odtworzone pod spód) |

3. **Przekazanie (`PASS`).** `StripView` buforuje zdarzenia od DOWN. Przy `PASS` odtwarza je do celu z oryginalnym `downTime`, a potem przekazuje kolejne na żywo aż do UP lub CANCEL.
   - Cel to okno launchera pod punktem `getRawX/Y`:
     - widoczne okna paneli (`WindowHostSinglePane` i dual; root przyłączony, prostokąt z `getLocationOnScreen` zawiera punkt; od wierzchu);
     - w innym razie `launcher.getWindow().getDecorView()`.
   - Zdarzenie: `MotionEvent.obtain(ev)`, `setLocation(rawX - celX, rawY - celY)`, `dispatchTouchEvent`, `recycle`.
   - Wzorzec przekazywania z własnego okna: `BarSwipeFrame` → `Workspace.handleExternalSwipe`.
   - Uprawnienia nie są potrzebne, bo wszystkie okna pod uchwytem należą do launchera. Bez wstrzykiwania wejścia.
4. `setSystemGestureExclusionRects` obejmuje całe, szersze okno.
5. Log D raz na gest: `Edge handle: open|pass (<target>)`.

## C9 — `Widget bar: the date and the weather can be hidden, the music widget takes their room`
1. **Ustawienia.** Dwa `CustomSwitchPreference` (zagnieżdżone, jak `fab_overlay_button_left`) w `creator_preferences.xml` zaraz pod `widget_bar`. Oba domyślnie `false`.

   | Klucz (`Keys.*`) | Tytuł EN | Tytuł PL | Widoczny |
   |---|---|---|---|
   | `widget_bar_no_date` (`WIDGET_BAR_NO_DATE`) | „Hide the date” | „Ukryj datę” | `widget_bar` włączony **i** orientacja pozioma (w pionie pasek nie ma daty) |
   | `widget_bar_no_weather` (`WIDGET_BAR_NO_WEATHER`) | „Hide the weather” | „Ukryj pogodę” | `widget_bar` włączony |

   - Wspólny `summaryOn` `widget_bar_hidden_on`: EN „The music widget takes its place”, PL „Jego miejsce zajmuje widżet muzyki”.
   - Pozostałe języki naturalnie, we wszystkich 59 plikach.
   - Widoczność ustaw przy starcie (wzorzec ≈523) i w obsłudze kliknięcia `widget_bar` (listener ≈544): odznaczenie `widget_bar` chowa oba wiersze, zaznaczenie je pokazuje.
   - Zmiana przełącznika: `helpers.setBarSettingsChanged(true)`.
2. **Układ paska.** Jedna funkcja pomocnicza w kodzie (bez kopii plików XML), wołana dla paska wbudowanego (`createUserPage`) i dla nakładki (`showOverlayBottomBar`), w czterech układach `custom_layout_two_user{,_left}` (poziom, pion):
   - ukryty widżet dostaje `GONE`;
   - `rl_music_two` dostaje szerokość własną plus szerokości ukrytych: poziom 0,28 + 0,05 (data) + 0,12 (pogoda), pion 0,295 + 0,15;
   - muzyka kończy się tam, gdzie kończył się ostatni widoczny widżet. Przy ukrytej pogodzie to prawa krawędź rodzica (`ConstraintSet` albo `LayoutParams` z podpiętymi na nowo ograniczeniami);
   - ukrytych widżetów nie dopasowuj (`adjustTextSize` / `fitBarText` pomijają je, bez logów W o „transient layout”).
3. **Szeroki układ muzyki** (decyzja właściciela: gdy ukryty jest **którykolwiek** z widżetów). `W` to szerokość, a `H` wysokość widżetu muzyki.

   | Tryb | Tekst (między okładką a przyciskami) | Blok przycisków (po prawej) |
   |---|---|---|
   | Zwykły (pasek > 12% krótszego boku) | dwie linijki: tytuł, pod nim artysta; razem wyśrodkowane w pionie | **30% W**, 2 rzędy × 2: góra prev, next; dół play/pause, favorite |
   | Kompaktowy (`barCompact`, próg 12% bez zmian) | jedna linijka jak dziś w trybie kompaktowym, wyśrodkowana | **40% W**, jeden rząd w zwykłej kolejności: prev, play/pause, next, favorite |

   - Okładka jak dziś (≤ `BAR_COVER_HEIGHT`·H).
   - Bok przycisku = `min(szerokość, wysokość komórki) · BUTTON_FILL`.
   - **Plan:** `MusicWidgetPlan.planBarWide(w, h, barHeightPx, shortSidePx, density)` (albo `planBar` z flagą `wide`). Zwraca szerokość bloku przycisków, liczbę rzędów (2 lub 1), szerokość kolumny tekstu, wysokość wierszy i `textPx`. Bez przycisków pod tekstem wiersze mogą zająć całą wysokość kolumny (2 × ~0,45 H; w trybie kompaktowym ~0,7 H).
   - Testy w `MusicWidgetPlanTest`:
     - blok 30% / 40% W (±1 px);
     - suma części ≤ W i ≤ H;
     - przełączenie trybu na tej samej granicy co `barCompact`.
   - **Widoki:** nowy `res/layout/music_bar_content_wide.xml` z tymi samymi ID (`iv_album_bg_two`, `music_bar_column`, `tv_musicName_two`, `tv_artist_two`, `music_bar_buttons`, `constraint_layout_*_two`, `music_*_two`).
     - `music_bar_buttons` jest tam `FlexboxLayout` obok kolumny, z `flexWrap=wrap`.
     - Komórki mają `flexBasisPercent` 50% (2×2) albo 25% (1×4). Kolejność ustawiaj w kodzie (`order`): 2×2 to prev, next, play/pause, favorite; 1×4 to prev, play/pause, next, favorite.
     - Dzięki temu zmiana trybu przy zmianie wysokości paska nie wymaga ponownego inflate.
   - Wariant szeroki wstaw do `rl_music_two` przy budowie paska, **zanim** widoki muzyki zostaną wyszukane i podpięte (`LauncherMusicWidget`, `mBarMusicWidget`, `setupOverlayWidgetBar`, `rebindBarWidgetsAfterWake`). Zmiana przełączników i tak przebudowuje pasek.
   - `MusicWidgetSizer.applyBar` obsługuje oba warianty. Log: `bar WxH -> wide=… compact=… buttons=30%|40% rows=2|1 …`.
4. Bez ukrytych widżetów pasek wygląda dokładnie jak dziś.

## C10 — `Widget bar: large text option`
1. **Ustawienie.**
   - `CustomSwitchPreference` (zagnieżdżony) `widget_bar_large_text` (`Keys.WIDGET_BAR_LARGE_TEXT`), domyślnie `false`, zaraz pod przełącznikami z C9.
   - Widoczny tylko przy włączonym `widget_bar`, jak tamte.
   - Stringi:

     | Klucz | EN | PL |
     |---|---|---|
     | `widget_bar_large_text` | „Large text” | „Duży tekst” |
     | `widget_bar_large_text_on` | „As large as the bar has room for” | „Tak duży, jak pozwala miejsce na pasku” |
     | `widget_bar_large_text_off` | „Usual text size” | „Zwykły rozmiar tekstu” |

   - Pozostałe języki naturalnie, we wszystkich 59 plikach.
   - Zmiana: `helpers.setBarSettingsChanged(true)`.
2. **Reguła właściciela:** czcionka ma być największa, na jaką pozwala wolne miejsce. Jeśli już jest największa, kontener tekstu dostaje nieco więcej wysokości kosztem sąsiadów. Wyłączony przełącznik daje dokładnie dzisiejszy wygląd.
   - **Pogoda i data:**
     - `adjustTextSize` z udziałem 0,95 zamiast 0,65;
     - jeden wiersz z `ellipsize=end`;
     - gdy tekst sięga wysokości swojego TextView, kontener tekstu dostaje +15% wysokości kosztem ikony obok (ikona nie mniejsza niż 60% dzisiejszej);
     - dla `date` / `curWeek` to samo we własnych klasach dopasowania.
   - **Muzyka, układ zwykły** (`planBar(…, largeText)`):
     - `BAR_STANDARD_LARGE {0.30, 0.30, 0.35, 0.05}`, `BAR_COMPACT_LARGE {0.50, 0.44, 0.06}`;
     - `LINE_FACTOR` 1,2;
     - przyciski nie mniejsze niż w dzisiejszym planie po `BUTTON_FILL`.
   - **Muzyka, układ szeroki z C9:** wiersze zajmują całą wysokość kolumny (2 × 0,5 H; kompaktowy 0,8 H), `LINE_FACTOR` 1,2. Szerokości bloku przycisków (30% / 40%) **się nie zmieniają**.
   - Testy w `MusicWidgetPlanTest`:
     - duży tekst ≥ zwykły;
     - przyciski ≥ minimum;
     - suma udziałów ≤ 1.
   - Podaj w raporcie liczby z logu `MusicWidgetSizer` na 359×66 dla czterech kombinacji (zwykły / szeroki × zwykły / duży tekst).
3. Działa w pasku wbudowanym i w nakładce (`setWidgetBarTextView(overlayBottomBar)` ≈1723).

## C11 — `Bottom bar: on every page`
1. **Ustawienie.**
   - `SwitchPreferenceCompat` `bottom_bar_every_page` (`Keys.BOTTOM_BAR_EVERY_PAGE`), domyślnie `false`, zaraz **nad** `auto_hide_bottom_bar`.
   - Stringi:

     | Klucz | EN | PL |
     |---|---|---|
     | `bottom_bar_every_page` | „Bottom bar on every page” | „Pasek dolny na każdej stronie” |
     | `bottom_bar_every_page_on` | „Shown on every page of the home screen” | „Widoczny na każdej stronie ekranu głównego” |
     | `bottom_bar_every_page_off` | „Only on the first page” | „Tylko na pierwszej stronie” |

   - Pozostałe języki naturalnie, we wszystkich 59 plikach.
   - Zmiana: `helpers.setBarSettingsChanged(true)`.
2. **Bez auto-hide: jaki pasek gdzie.** Na stronach innych niż pierwsza pasek to egzemplarz z nakładki auto-hide, w jej oknie, ale **trwały**:
   - bez licznika;
   - nie chowa go `ACTION_OUTSIDE`, swipe po pasku stanu ani `BarSwipeGesture.HIDE_BAR`.

   Jednocześnie podpięty jest tylko jeden egzemplarz, jak dziś.

   | Sytuacja | Pasek |
   |---|---|
   | Pierwsza strona w spoczynku | wbudowany, jak dziś |
   | Początek przesuwania z pierwszej strony (`onPageBeginMoving` ≈3600) | nakładka wchodzi od razu; ma tę samą geometrię, więc przykrywa odjeżdżający pasek wbudowany bez skoku |
   | Między stronami 2…n | nakładka stoi, nie chowa się przy przesuwaniu |
   | Powrót na pierwszą stronę (`onPageEndMoving` ≈3638) | nakładka znika, gdy strona się zatrzyma |
   | Z lewym paskiem pasek wbudowany ma inną szerokość | krótki crossfade (≤150 ms) w chwili zatrzymania strony; bez podwójnego paska i bez migania |

3. **Kiedy chować trwałą nakładkę.** Leży nad oknami launchera, więc chowaj ją, a potem przywróć:

   | Chowanie | Przywrócenie |
   |---|---|
   | `onPause` (≈2954; `cleanWidgetBar` ≈5670 musi uwzględnić nową opcję) | `onResume` |
   | `showAllApps` (≈7649) | `showWorkspace` (≈7583) |
   | `showOverviewMode` (≈7600) | `showWorkspace` |
   | start przeciągania (`DragController`) | koniec przeciągania |
   | otwarcie folderu | zamknięcie folderu |
   | dialog launchera otwarty z paska (wybór aplikacji przy przytrzymaniu ikony) | zamknięcie dialogu |
   | `onDetachedFromWindow` | — |

   - Bez uprawnienia nakładki (wersja standard bez zgody): zachowanie jak auto-hide bez niego (sprawdź w kodzie). Podsumowanie przełącznika mówi wtedy, czego brakuje.
4. **Bez auto-hide: rezerwacja pasa na każdej stronie.**
   - `CellLayout`: `isBarRowExcluded(pageIndex)` i `shouldExcludeLastRow` są prawdziwe na każdej stronie. Przeniesienie spod paska (≈4700–4780) po włączeniu działa na wszystkich stronach.
   - Prostokąty elementów (panele PiP, widżety) na ekranach >0 omijają pas tym samym mechanizmem co ekran 0 (`Helpers.checkAndResetIfOverlappingOnScreen`, domyślne pozycje ≈962). Bez nowych reguł resetu.
   - `DrawViewOtherScreens` rysuje pas jak `DrawViewFirstScreen` (`creator_bar`).
5. **Z auto-hide.**
   - Pas nie jest rezerwowany na żadnej stronie, jak dziś.
   - Pierwsza strona z lewym paskiem: przycisk `show_bar`, jak dziś.
   - Pozostałe strony, oraz pierwsza bez lewego paska: uchwyt z C8. `mEdgeHandleMode` i `shouldShowEdgeHandle` biorą pod uwagę stronę i nową opcję.
   - `isFirstBottomCellExcluded` jest prawdziwe na każdej stronie z uchwytem.
   - Odsłonięty pasek to nakładka z licznikiem, jak dziś.
6. Reguły wydziel do czystej klasy `BottomBarPlacement` z testem.
   - Wejście: strona, `everyPage`, `autoHide`, `leftBar`, czy strona się przesuwa i dokąd.
   - Wyjście: wbudowany / trwała nakładka / uchwyt / przycisk / nic, oraz rezerwacja (wiersz, komórka, nic).
7. Wyłączony przełącznik daje dokładnie dzisiejsze zachowanie we wszystkich gałęziach.

## C12 — `Docs: README for the new bar options`
README, sekcja paska dolnego, ma opisać:
- szerszy uchwyt, który otwiera pasek tylko swipe w prawo (tap w sam pasek też otwiera) i przepuszcza dotyk;
- ukrywanie daty i pogody z szerokim układem muzyki (30% / 40%);
- duży tekst;
- pasek na każdej stronie i jego zachowanie z auto-hide i lewym paskiem.

## 3. Czego NIE zmieniać
- Kodu rundy 1 poza §2.2. W szczególności:
  - ścieżek com.syu.music i com.syu.radio (7862);
  - FM com.syu.media tylko do odczytu;
  - polityki raportów compat.
- Ostrzeżeń `Parcel` i `SurfaceSyncer`.
- Numeru protokołu VD hosta.
- Progu jednej linijki muzyki w pasku (12%).
- Wyglądu i zachowania paska przy wyłączonych nowych przełącznikach.
- Treści stringów legendy logów (C1 zmienia tylko wyświetlanie).

## 4. Weryfikacja
1. Po każdym commicie CI jest zielone, a nowe testy przechodzą.
2. Sprawdzenia `rg`:
   - `getMethod("diff"` → zero;
   - `FytCompat.run("` w `UiNotifyEvent`, `Callback`, `ModuleCallback*` → zero;
   - `TOUCH_MARGIN_FRACTION` → 0,035;
   - w `build.yml` jest artefakt `vdhost-magisk-module`.
3. Scenariusze dla testera 7870 (standard + Shizuku). Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Restart: brak `StrictMode policy violation` z pid launchera. Jest `ime policy for display N applied`.
   - b) ACC off na ekranie głównym: brak `pipWatchdog … giving up`. Po ACC on panele wracają jak dziś.
   - c) Ustawienia, sekcja logów, na telefonie i na jednostce: legenda widoczna w całości, z linią `compat – …`.
   - d) BT: okładka przychodzi także przy szybkim przeskakiwaniu utworów. Brak `bt-cover via any -> fail` dla brakującego pliku.
   - e) Auto-hide bez lewego paska:
     - swipe w prawo od krawędzi otwiera pasek;
     - tap w przezroczysty margines trafia do widżetu lub panelu pod nim;
     - przewijanie pionowe i długie przytrzymanie pod marginesem działają;
     - tap w sam widoczny pasek otwiera pasek.
   - f) Pasek z widżetami:
     - pod „Widget bottom bar” są wcięte „Hide the date” (tylko w poziomie), „Hide the weather” i „Large text”;
     - znikają po odznaczeniu „Widget bottom bar”;
     - po ukryciu daty lub pogody muzyka zajmuje ich miejsce;
     - pasek wyższy niż 12% krótszego boku: dwie linijki i przyciski 2×2 (30%);
     - na 7870 (≈9%): jedna linijka i przyciski w jednym rzędzie (40%).
   - g) „Large text”: tekst muzyki i pogody wyraźnie większy w obu układach, nic nie wychodzi poza pasek. Wyłączony przełącznik daje wygląd jak wcześniej.
   - h) „Bottom bar on every page”:
     - bez auto-hide pasek widoczny na każdej stronie;
     - przesuwanie bez skoku i podwójnego paska;
     - ikony i panele nie leżą pod paskiem;
     - pasek znika w All Apps, overview, przy przeciąganiu i w folderze;
     - z auto-hide uchwyt na każdej stronie (z lewym paskiem na pierwszej przycisk).
4. Scenariusz dla właściciela (7862, wersja system): c), e), f), g) i h) jak wyżej. Moduł Magisk z artefaktu CI po C2 i C6 (ten sam numer protokołu).

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash i temat) z wynikiem CI każdego.
- Zamienione wiersze informacyjne (C1) i pliki prefów wczytywane z wyprzedzeniem (C2).
- Liczby `MusicWidgetSizer` na 359×66 dla czterech kombinacji (C10).
- Lista miejsc, w których trwała nakładka się chowa i wraca (C11.3), z plikiem i linią.
- Każde odstępstwo od instrukcji i jego powód.
- Rzeczy spoza launchera z §2.1 dla testera (`dev.igor.fytcustomservice`).
- Scenariusze z §4.
