# Launcher Mod: ikony pasków poza wątkiem głównym, pompa bounds paneli, lżejszy zimny start — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `testBranch`. Zacznij od `git pull origin testBranch`.
Zrób trzy commity w kolejności C1 → C3. **Każdy commit musi się budować samodzielnie i przechodzić testy.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.**

Numery linii to stan z `ac2e02a` i są orientacyjne (≈). Zawsze sprawdzaj je w kodzie.
Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`.
Źródło: `docs/opus-analysis-2026-11-03-remaining-log-findings.md`. Logów nie masz; potrzebne fakty są poniżej.

## 0. Fakty i diagnoza

### 0.1 Ikony pasków z PackageManagera na wątku głównym (analiza §1 i większość §3 12:26:15–20)
- `LauncherAppBars.loadLeftBarIconStrict()` (≈2170) ma w nazwie „Strict”, bo zwraca `null` (wiersz znika) zamiast placeholdera „+”,
  którego używa dolny pasek. **Nie ma to nic wspólnego ze StrictMode.**
- Paski sięgają do PM, gdy wiersza nie ma w `AllAppsList`:
  - lewy: `initializeLeftAppData()` ≈890 i `refreshLeftBar()` ≈1773 → `loadLeftBarIconStrict()`;
  - dolny: `buildBottomAppBeans()` ≈1368 → `loadAppIconFromPackageManager()` ≈2133.

  Wszystko to biegnie na wątku głównym (`getActivityIcon` → `getLiveIcon`/`PathClassLoader`, `getTopLevelResources` dla każdego pakietu).
- Poza FYT `initAppData()` (≈486) woła `forceInitializeWithDefaults()`, a potem ≈531–535 `setupRecyclerView` + post `setupLeftRecyclerView`.
  Oba paski powstają więc **przed** listą aplikacji, a model ładuje ją dopiero po `waitForIdle`. W logu Samsunga (reboot):
  - `waitForIdle: main thread still busy after 3579ms` (12:26:18.389);
  - LogcatWorker: wątek główny w `ApplicationPackageManager.getDrawable ← PackageItemInfo.loadIcon` (2138 → 2491 ms);
  - StrictMode 146 ms w `loadLeftBarIconStrict` (12:26:19.200);
  - `Skipped 218 frames` (12:26:19.227);
  - `Long monitor contention with owner main … DisplayManagerGlobal.getDisplayInfo`.

  To jedna przyczyna: każda ikona obu pasków jest ładowana z PM na wątku głównym, gdy `AllAppsList` jest jeszcze puste.
- Poza FYT nic nie przebudowuje pasków po `Launcher.bindAllApplications()` (≈8570). Robi to tylko gałąź `mAwaitingAllAppsBind`, czyli FYT.
  Ikony z PM zostają do następnego odświeżenia.
- `mAppIconBitmapCache` (≈157) to `HashMap`, używany tylko na wątku głównym. `mLauncher.bg` to jednowątkowy executor (`Launcher` ≈561);
  `runPostResumeAppDataRefresh()` (≈365) pokazuje wzorzec: odczyt w tle, potem `refreshCycle(data)` + `refreshLeftBar(left)` na UI.
- Adaptery (`AppListAdapter` ≈285, `LeftAppListAdapter` ≈102) robią tylko `setImageBitmap(bean.icon)`, więc `null` daje pustą ikonę.

### 0.2 `WindowHostDualPane: LEFT/RIGHT: bounds update never arrived` (analiza §2)
- `WindowHostDualPane.show()` (≈233) biegnie w `postNextFrame`. Gdy `launchBounds(s)` nie są „prawdziwe”
  (`WindowHostActivityView.hasRealLaunchBounds` ≈830), strona czeka (`setStartDeferred(s, true)`).
  Zwalnia ją dopiero `updateBounds()` (≈316–341), a ostatnią deską jest watchdog `DEFERRED_START_WATCHDOG_MS = 2500` (≈364).
- Bounds podaje `WindowUtil.pumpPipBoundsUntilReady()` (≈1605). Startuje go tylko:
  - jeden post 100 ms po `runOrdered(launches)` (≈1591);
  - gałąź „awaiting bounds” w `openPip()` (≈550).

  Pompa **kończy się przy pierwszym sprawdzeniu, w którym żaden panel nie czeka** (≈1616).
- Panele startują jednak po kolei i rozłożone w czasie (`launchNextPane` → `awaitPaneUp`, do `PANE_LAUNCH_MAX_WAIT_MS`), a `show()` jeszcze przez `postNextFrame`.
  Gdy pompa sprawdzi stan przed wejściem dual w oczekiwanie (wątek główny zajęty po `recreateView()`), kończy pracę.
  Potem nikt nie przesyła bounds, więc po 2,5 s strzela watchdog (log 12:18:08.784: 2,5 s po `show()`).
  Wyścig zależy od czasu: w logu 5 minut później go nie ma.
- To samo dotyczy `WindowHostSinglePane.show()` (≈210, `armDeferredStartWatchdog`, ≈312).
- Dwie pompy mogą dziś też biec równolegle (≈550 i ≈1591), bo nic tego nie pilnuje.

### 0.3 Zimny start (analiza §3)
- **`LauncherWidgetSort`** (`Launcher.onCreate` ≈1687–1701):
  - wątek `MIN_PRIORITY` startuje w `onCreate` i woła `LauncherModel.getSortedWidgetsAndShortcuts()` (≈3119);
  - `getInstalledProviders()` rozpakowuje setki parcelables pod globalnym lockiem `Parcel.readParcelableCreatorInternal`;
  - komparator ładuje etykiety, czyli tworzy Resources każdego pakietu;
  - wątek o najniższym priorytecie trzyma lock, na który czekają main, RenderThread i loader (4× `Long monitor contention`, do 609 ms, 12:26:23–31).

  Lista jest potrzebna tylko pickerowi widżetów (`showAllApps(true, ContentType.Widgets, true)`, ≈4393 i ≈6279). Gdy pakiety się zmienią,
  `bindPackagesUpdated()` (≈8658) i `LauncherAppWidgetHost` ≈48 dostarczają ją i tak.
- **Weryfikacja klas na wątku głównym**: `Verification of … ConstraintLayout.setChildrenConstraints() took 1.109s` na tid = pid (main).
  ConstraintLayout jest w `res/layout/absolute_time.xml`, `music_widget_content.xml` i w `Workspace` (≈1782). Weryfikacja odbywa się
  przy pierwszym użyciu klasy. Zrobiona wcześniej na innym wątku, nie obciąża głównego.
- **Profil bazowy**:
  - nic przy starcie nie loguje, czy kod procesu jest skompilowany;
  - `perf/BaselineProfileCompiler.statusText()` (≈348) jest tylko w ustawieniach;
  - `isSupported()` (≈218) jest false w każdym buildzie debug (debug nie ma profilu). Build z CI to debug.

  „Verification … took” i „failed lock verification” wskazują na brak skompilowanego kodu.
- **Przestój 12:26:40–43** (`Main thread not responding for 2232 ms, busy, 3 different places`, `Skipped 413 frames`):
  stosów „it is at:” nie ma w briefie. **Nie zgaduj poprawki.** Wymień to w raporcie jako otwarte.

## 1. Decyzje właściciela (nie zmieniaj ich)
1. Na wątku głównym nie ma żadnego wywołania PM po ikonę paska. Brakująca ikona jest ładowana w tle; do tego czasu pozycja ma pustą ikonę
   (`null`), a po załadowaniu pasek przebudowuje się raz.
2. Semantyka bez zmian:
   - lewy pasek usuwa wiersz, którego komponentu/pakietu nie da się rozwiązać;
   - dolny pokazuje „+” przy błędzie ładowania;
   - snapshot paska nie zapisuje się, gdy użyto ikony zastępczej (`usedFallbackIcon`).
3. Gdy pasek zbudowano z ikon zastępczych, po `bindAllApplications()` przebudowuje się raz z ikon launchera (wszystkie urządzenia).
4. Pompa bounds startuje wtedy, gdy panel zaczyna czekać, a nie w stałym momencie. Działa najwyżej jedna naraz. Watchdog 2,5 s zostaje.
5. Lista widżetów jest liczona po starcie, gdy model skończył ładowanie, albo od razu, gdy użytkownik otworzy picker widżetów.
6. Mechanizm snapshotów pasków (tylko FYT) i czekanie na listę aplikacji na FYT zostają bez zmian.

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
- **Testy JVM**: JUnit 5 (`app/src/test/java/…`), `unitTests.isReturnDefaultValues = true`. Jeśli wydzielisz logikę decyzyjną, rób to w czystych
  klasach bez `android.*` i ją przetestuj.
- **StrictMode** jest włączony: żadnego I/O, zapytań do DB ani wywołań PM po ikony na wątku głównym w nowym kodzie.
- **Bez nowych zależności, bez zmiany schematu DB, bez migracji prefów, bez nowych stringów.**
- **Usuwaj dopiero po `rg`** w całym `app/src` (`--glob '!**/generated/**'`).

## C1 — `Bars: icons the app list does not have are loaded off the main thread`

### C1.1 Cache i stan
- `LauncherAppBars.mAppIconBitmapCache` (≈157) → `ConcurrentHashMap` (nie wkładaj `null`).
- Nowe pole `final Set<String> mUnresolvableIcons = ConcurrentHashMap.newKeySet();` przechowuje klucze (`appIconCacheKey`), których lewy pasek nie
  rozwiązał. `clearAppIconBitmapCache()` (≈2233) czyści oba (woła go już `bindAppsAdded`/`bindAppsUpdated`/`bindAppsRemoved`).
- Pola tylko dla wątku głównego:
  - `LinkedHashMap<String, String[]> mPendingFallbackIcons` (klucz → `{pkg, cls, "strict"|"plain"}`);
  - `boolean mFallbackIconFlushPosted`;
  - `boolean mBottomUsedFallbackIcon, mLeftUsedFallbackIcon` (ostatnia przebudowa danego paska użyła ikony zastępczej).

### C1.2 Wątek główny tylko czyta cache
- Lewy pasek, `initializeLeftAppData()` ≈887 i `refreshLeftBar()` ≈1772, zamiast `loadLeftBarIconStrict(...)`:
  - `key` w `mUnresolvableIcons` → `continue` (wiersz znika jak dziś);
  - inaczej `icon = mAppIconBitmapCache.get(key)`; jeśli `null`, `queueFallbackIcon(pkg, cls, true)`;
  - bean powstaje zawsze (ikona może być `null`), `usedFallbackIcon = true`.
- Dolny pasek, `buildBottomAppBeans()` ≈1365: to samo z `queueFallbackIcon(pkg, cls, false)`; bean z ikoną z cache albo `null`.
- Ustaw `mBottomUsedFallbackIcon`/`mLeftUsedFallbackIcon` z `snapshot.usedFallbackIcon` po każdej przebudowie danego paska
  (`initializeAppList`, `refreshCycle`, `initializeLeftAppData`, `refreshLeftBar`).
- Sprawdź przez `rg "loadLeftBarIconStrict|loadAppIconFromPackageManager"`, że na wątku głównym nie zostało żadne wywołanie.

### C1.3 Ładowanie w tle
- `queueFallbackIcon(...)`: dodaje do `mPendingFallbackIcons` (bez duplikatów), a jeśli `!mFallbackIconFlushPosted`, postuje
  `flushFallbackIcons()` (`mLauncher.mHandler.post`), żeby jedna przebudowa zebrała całą partię.
- `flushFallbackIcons()`: kopia i wyczyszczenie mapy, potem `mLauncher.bg.execute(...)`:
  - każda pozycja „strict” to dotychczasowe ciało `loadLeftBarIconStrict` (`getApplicationInfo`, `getActivityIcon`, fallback na launch intent,
    rysowanie do bitmapy); `null` → `mUnresolvableIcons.add(key)`;
  - każda „plain” to dotychczasowe `loadAppIconFromPackageManager` (błąd → `icon_add`, jak dziś);
  - wynik do cache;
  - jeden `Log.d(Launcher.TAG, "Bar icons loaded off the main thread: " + n + " (" + missing + " not found) in " + ms + " ms")`;
  - potem jak w `runPostResumeAppDataRefresh()`: w tym samym zadaniu tła `ensureBottomRows(BarRows.bottom(), capacity)` i
    `BarRows.left(BarCapacity.LEFT_MEMORY)`;
  - na UI (`mLauncher.runOnUiThread`): jeśli aktywność nie jest zniszczona, wyzeruj `mLastAppListSourceSignature` i
    `mLastLeftAppListSourceSignature` (wartością, która na pewno wymusi przebudowę), potem `refreshCycle(data)` i `refreshLeftBar(left)`.
- Oznacz obie metody ładujące `@WorkerThread`, zostaw nazwy. Javadoc `loadLeftBarIconStrict` uzupełnij: „Strict: null instead of the '+'
  placeholder… unrelated to StrictMode; worker thread only (getActivityIcon creates a class loader and the package's Resources)”.
- Pętla: przebudowa po załadowaniu znajduje ikony w cache, więc nic nie kolejkuje ponownie. Pozycja, której nie da się załadować, trafia do
  cache jako `icon_add` (dolny) albo do `mUnresolvableIcons` (lewy), więc też się nie powtarza.

### C1.4 Przebudowa po liście aplikacji (decyzja 3)
- `Launcher.bindAllApplications()` (≈8570): po istniejącym bloku `mAwaitingAllAppsBind`, jeśli nie wywołał on `triggerAppData()`,
  a `mAppBars.barsUseFallbackIcons()` (`mBottomUsedFallbackIcon || mLeftUsedFallbackIcon`), wywołaj `mAppBars.triggerAppData()`
  z `Log.d` „Bars were built before the app list, rebuilding them with the launcher's icons”.

### C1.5 Inne ikony na wątku głównym przy starcie
- `rg "getActivityIcon|getApplicationIcon|\.loadIcon\(|getDrawable\(" app/src/main/java` i wypisz w raporcie miejsca, które mogą biec na
  wątku głównym przy starcie. Nie zmieniaj ich w tym commicie, chyba że to oczywiście ta sama ścieżka pasków.

## C2 — `Panes: the bounds pump starts when a pane begins to wait`

### C2.1 `WindowUtil`
- Pole `private static boolean sBoundsPumpRunning;` (wątek główny).
- Nowa `public static void requestPaneBoundsPump(String reason)` (wątek główny):
  - `forcePipBoundsUpdate = true`;
  - jeśli `!sBoundsPumpRunning`: ustaw `sBoundsPumpRunning = true`, `Log.d(TAG, "Pane bounds pump started (" + reason + ")")`,
    `launcher.handler.post(() -> pumpPipBoundsUntilReady(32))`.
- `pumpPipBoundsUntilReady()` (≈1605): każde wyjście bez ponownego zaplanowania (brak launchera lub hosta, nikt nie czeka, gave up, wyjątek)
  ustawia `sBoundsPumpRunning = false`.
- Zamień oba dotychczasowe starty: ≈550 → `requestPaneBoundsPump("openPip, panes awaiting bounds")`; ≈1591 (`postDelayed(…, 100)`) →
  `postDelayed(() -> requestPaneBoundsPump("panes launched"), 100)`.

### C2.2 Panele
- `WindowHostDualPane.show()` (≈302–304): po `setStartDeferred(s, true)` i `armDeferredStartWatchdog(...)` wywołaj
  `WindowUtil.requestPaneBoundsPump("dual " + s)` oraz `Log.d(TAG, s + ": launch bounds " + launchBounds(s) + " not usable yet, waiting for a bounds update")`.
- `WindowHostSinglePane.show()` (≈210–212): to samo z `name`.
- Watchdogi (≈364 dual, ≈312 single): dopisz do istniejącego `Log.w` ostatnie bounds (`… anyway (last bounds " + pendingBounds + ")"`).
  Nic więcej w nich nie zmieniaj.
- Sprawdź, czy `WindowHostDualPane`/`WindowHostSinglePane` mogą wołać `WindowUtil` (pakiet `com.syu.util`, ta sama paczka). Wołania są na
  wątku głównym (`postNextFrame`).

## C3 — `Start: widget list after the start, class verification off the main thread, profile status logged`

### C3.1 `LauncherWidgetSort` po starcie (decyzja 5)
- `Launcher.onCreate` ≈1687–1701: zamiast startu wątku wydziel `private void startWidgetSort(String reason)`:
  - działa raz na instancję (`mWidgetSortStarted`);
  - `mAppsCustomizeContent == null` → nic;
  - w środku ten sam wątek i ta sama logika generacji co dziś, plus `Log.d(TAG, "Widget list sorted (" + reason + ") in " + ms + " ms")`.
- Kiedy:
  - w `bindAllApplications()` → `mHandler.postDelayed(mStartWidgetSortRunnable, Math.max(WIDGET_SORT_DELAY_MS, bootStallDelayMs()))`,
    `WIDGET_SORT_DELAY_MS = 5000`;
  - zapas w `onCreate`: `mHandler.postDelayed(mStartWidgetSortRunnable, WIDGET_SORT_BACKSTOP_MS)`, `= 30_000`;
  - picker: w `showAllApps(...)`, gdy `contentType == ContentType.Widgets` → `startWidgetSort("widget picker opened")` od razu.
- `onDestroy`: `mHandler.removeCallbacks(mStartWidgetSortRunnable)`.
- Komentarz po angielsku: fakty z §0.3 (lock Parcel creatorów, 4× contention do 609 ms, MIN_PRIORITY trzyma lock).

### C3.2 Weryfikacja ConstraintLayout poza wątkiem głównym
- `LauncherApplication.warmUpOffMainThread()` (≈354): nowy osobny wątek `"ClassWarmUp"` (żeby nie opóźniać `StartupWarmUp`), który robi
  `Class.forName("androidx.constraintlayout.widget.ConstraintLayout", true, getClassLoader())` i `Log.d(TAG, "Class warm-up: " + ms + " ms")`.
  Wyjątki łapane (`Log.w`).
- Komentarz: przy niekompilowanym kodzie weryfikacja klasy przy pierwszym użyciu trwała 1,1 s na wątku głównym (reboot Samsunga). Gdy kod
  jest skompilowany, to prawie nic nie kosztuje.
- Nie dodawaj innych klas „na zapas”; tylko tę, którą pokazuje log.

### C3.3 Status profilu w logu
- `perf/BaselineProfileCompiler`: nowa `@JvmStatic @WorkerThread fun logProcessStatus(context: Context)`, jedna linia `Log.i(TAG, …)`:
  - `build=<BuildConfig.BUILD_TYPE>, debug=<DEBUG>, supported=<isSupported()>`;
  - wynik `ProfileVerifier.getCompilationStatusAsync().get()` (`code`, `compiledWithProfile`, `enqueued`, jak w `statusText`);
  - ostatni status (`KEY_LAST_STATUS`).

  W debug: „debug build: no Baseline Profile, the code is verified and JIT-compiled at every start”.
- Wołaj ją w wątku `StartupWarmUp` zaraz po `BaselineProfileCompiler.warmUp(this)` (≈381).

## 3. Czego NIE zmieniać
- Snapshotów pasków (`prefetchBarSnapshots`, `BarSnapshotStore`, warunki `isFytDevice()` przy nich) i czekania na listę aplikacji na FYT (≈455).
- Czasów watchdogów paneli, `hasRealLaunchBounds`, kolejności i odstępów startu paneli (`runOrdered`, `awaitPaneUp`).
- `LogcatWorker`, `LauncherModel.waitForIdle`/`MAX_IDLE_WAIT_MS`.
- Przestoju 12:26:40–43 (brak stosów) i szumu systemowego z „Other notes”.

## 4. Weryfikacja
1. Po każdym commicie CI zielone.
2. `rg` (`--glob '!**/generated/**'`):
   - `loadLeftBarIconStrict\(|loadAppIconFromPackageManager\(` → tylko w zadaniu tła C1.3 i w definicjach;
   - `pumpPipBoundsUntilReady\(32\)` → tylko w `requestPaneBoundsPump`;
   - `"LauncherWidgetSort"` → tylko w `startWidgetSort`.
3. Scenariusze dla właściciela (wypisz je w raporcie):
   - a) Samsung, reboot:
     - brak StrictMode z `LauncherAppBars` (`getActivityIcon`);
     - jest linia `Bar icons loaded off the main thread: …`;
     - `waitForIdle: main thread still busy` krótszy albo brak;
     - brak stosu LogcatWorker w `PackageItemInfo.loadIcon` z paska.
   - b) Po starcie oba paski mają wszystkie ikony. Na urządzeniu innym niż FYT jest linia „rebuilding them with the launcher's icons”.
   - c) Odinstalowanie aplikacji z lewego paska: wiersz znika, pozostałe się przesuwają (bez pustej ikony na stałe).
   - d) Kilka powrotów z ustawień z panelem dual:
     - `Pane bounds pump started (dual LEFT)`;
     - brak `bounds update never arrived`;
     - jeśli jednak wystąpi, linia ma `last bounds …` (do dalszej analizy).
   - e) Reboot:
     - brak `Long monitor contention with owner LauncherWidgetSort` w pierwszych sekundach;
     - jest `Widget list sorted (…) in … ms`;
     - picker widżetów otwarty zaraz po starcie pokazuje widżety.
   - f) `Class warm-up: … ms` i brak `Verification of … ConstraintLayout.setChildrenConstraints` na wątku głównym (pid == tid).
   - g) Linia `BaselineProfile` ze statusem procesu. Właściciel podaje, czy testuje build debug z CI (wtedy „Verification … took” jest oczekiwane).

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash + temat) i wynik CI każdego.
- Lista z C1.5 (inne ładowania ikon, które mogą być na wątku głównym).
- Każde odstępstwo od instrukcji i jego powód.
- Otwarte: przestój 12:26:40–43. Poproś o linie po `Main thread not responding for 2232 ms … it is at:` z `reboot_pid_03-11-2026_12-26-13.txt`
  i o linię `onCreate(): …ms (…)` oraz linie `StartupSteps` Launchera z tego logu.
- Scenariusze z pkt 4.3 z tym, czego właściciel ma szukać w logu.
