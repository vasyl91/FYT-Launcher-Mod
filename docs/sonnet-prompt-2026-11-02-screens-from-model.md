# Launcher Mod: strony i elementy własne planowane przez model (DB) zamiast stanu widoków, porządek w logach — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `testBranch`. Zacznij od `git pull origin testBranch`.

Zrób sześć commitów w kolejności C1 → C6. **Każdy commit musi się budować samodzielnie i przechodzić testy.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.**

Numery linii to stan z `4c0e9d0` i są orientacyjne (≈). Zawsze sprawdzaj je w kodzie. Ścieżki bez prefiksu są względem
`app/src/main/java/com/android/launcher66/`.

## 0. Cel, fakty i decyzje właściciela

### 0.1 Co widać w logu
Właściciel złapał log zimnego powrotu z ustawień (telefon 1080×2340, `user_layout` włączony). Kolejność zdarzeń:

| czas | zdarzenie |
|---|---|
| 43,884 | `Launcher.Model`: `orderedScreens: {1=3, 2=4, 3=5, 4=6}`, `customScreens: [2, 2, 2, -1, -1, 1]`, `Preserving custom widget screenId=5/4` |
| 43,935–43,941 | `bindAddScreens`, osiem linii `insertNewWorkspaceScreen: adding …/final mScreenOrder=…`, `bindScreens order: [3, 4, 5, 6]` |
| 44,181 | `finishBindingItems` |
| 44,387 | `Custom elements setup requested: afterBind:cellSizeChanged` (potem jeszcze 2× `setupRecyclerView`) |
| 45,759 | `HomeLayoutRecovery`: „Custom elements still being set up …, hurrying it” |
| 45,766 | `CellLayout`: `Current pages: 5, max needed: 3`, `Required screens: [0, 2, 3]` (krok „ensure”) |
| 46,267 | `addWidgetsToAllExistingPages START`, pętla po stronach 0…4, dla każdej `checkAndAddWidgetsView`/`checkAndAddPipPlaceholders`, `handleConflictingViews` |
| 46,314–46,385 | 7× `triggerStripEmptyScreens called in: CellLayout, …`, `stripEmptyScreens called in: …` |

Elementy własne (data, muzyka, radio, placeholdery 5 PiP, placeholder statystyk) pojawiają się **≈2,1 s po** zakończeniu bindu.
Strony i ich zawartość są wyliczane „od strony widoków”: `CellLayout` sprawdza liczbę dzieci `Workspace`, dla każdego indeksu
czyta prefy `*_SCREEN`, sam tworzy brakujące strony, a pustość strony ocenia się po liczbie widoków.

### 0.2 Numeracja stron (obowiązuje wszędzie)
- Pref `*_SCREEN` (`int`) i `start_page` (`String`) to **numer strony od 1**.
- Strona 1 to **strona użytkownika** z paskiem dolnym: `Workspace.createUserPage()` (≈937), id `CUSTOM_CONTENT_SCREEN_ID1 = -302`
  (≈325). Nie ma jej w tabeli `workspaceScreens`. `numCustomPages()` liczy tylko −301, więc zwraca 0.
- Indeks dziecka `Workspace` = pref − 1. Indeks w `LauncherModel.sBgWorkspaceScreens` = pref − 2.
- **Każdy konsument** zakłada `indeks dziecka == pref − 1`:
  - `com/syu/util/WindowUtil.java`: `pageOf()` (≈1034), `getInitialPipBounds()` (≈1635–1692), `boundsToApply()` (≈1878–1899),
    pozycja X = indeks × szerokość strony; `PINNED_PIP_SCREEN` (≈2281, ≈2355, ≈2442);
  - `settings/CanbusService.java` (≈889, ≈1070) dla statystyk;
  - kreator (`SettingsFragmentSecond` ≈2378, `Creator*`, `DrawView*`, `Helpers`);
  - `start_page`: `Workspace.createUserPage()` ≈1060, `moveToDefaultScreen()` ≈7568, `Launcher.getStartPageIndex()` ≈1337.
- `CustomLayoutDb.read()` + `settings/WorkspaceOccupancy.pageForScreenId()` (z poprzedniej rundy, używane przez `Helpers` ≈648 do wolnego
  miejsca w kreatorze) liczą stronę jako 1 + pozycja id w tabeli `workspaceScreens` wg rangi. Zakładają więc, że **tabela ma kolejność
  stron `Workspace`** – to dziś nie zawsze prawda (§0.4), a po tej rundzie jest (decyzja 7).

### 0.3 Fakty z kodu: dziś o stronach decydują cztery niezgodne miejsca
1. **`LauncherModel.loadWorkspace()`** (≈2176–2249, worker):
   - chroni strony elementów jako `pref - 2`, **bez `STATS_SCREEN`**;
   - domyślne `USER_DATE/MUSIC/RADIO = false`, choć `res/xml/creator_preferences.xml` (≈83–96) ma `true`;
   - usuwa puste ekrany, **ale nie przesuwa prefów**. Gdy pusta strona leży przed stroną z elementem, element „przeskakuje” na sąsiedni ekran;
   - `placeOverlappingWidget()` (≈1712) może dodać ekran już po tym stripie;
   - `needRetainScreens` (≈1914) bierze wiersze bez sprawdzania kontenera, więc pozycja w hotseacie trafia tam jako „id ekranu”.
2. **`CellLayout`**:
   - `triggerAddCustomElements()` (≈1154): 1,5 s, potem `ensurePagesExistForCustomElements()` (≈4023), potem 0,5 s, potem
     `addWidgetsToAllExistingPages()` (≈3861);
   - `ensurePagesExistForCustomElements()` tworzy strony `Workspace.ensurePageExists()` (≈666) → `createPersistedWorkspaceScreen()`
     (≈722: zapytanie + INSERT **na wątku głównym**, ranga = indeks strony), a potem robi **drugi INSERT tego samego `_id`**.
     Gdy `getScreenIdForPageIndex()` zwróci −1, zapisuje wiersz `_id=-1`;
   - `addWidgetsToPagesImmediately()` iteruje dzieci `Workspace`, `checkIfPageNeedsWidgets(pageIndex)` porównuje `pref - 1` z indeksem;
   - po każdym elemencie `workspace.triggerStripEmptyScreens(…)`; `handleConflictingViews()` w `postDelayed` 100/150/200 ms.
3. **`Workspace.stripEmptyScreens()`** (≈3137):
   - pusta strona = `getShortcutsAndWidgets().getChildCount() == 0` (stan widoków);
   - chroni `pref - 1` łącznie z STATS, ale z domyślnymi `false`;
   - przesuwa prefy (`maybeShiftPref`, ≈3262), ale nie `start_page` ani `PINNED_PIP_SCREEN`;
   - potem drugi raz zapisuje rangi (`resolver.update`, ≈3296) **na wątku głównym**, z rangą = indeks strony (z user page),
     w wyścigu z `updateWorkspaceScreenOrder()` (rangi od 0). Stąd w logu `{1=3, 2=4, …}`.
4. **`settings/WidgetPageManager`** (≈72–375):
   - liczba stron = `workspace.getChildCount()`, „strony z treścią” z widoków (`isUserWidget`);
   - liczy też **wyłączone** elementy;
   - `getUserWidgetKey()` zwraca `"null"` dla PiP i statystyk, więc strażnik „sam na ostatniej stronie” działa tylko dla daty/muzyki/radia;
   - `checkCustomElements()` (≈480) zawsze zwraca false.

### 0.4 Fakty z kodu: tabela `workspaceScreens` i id ekranów
- `LauncherProvider` ≈333: `CREATE TABLE workspaceScreens (_id INTEGER, screenRank INTEGER, modified …)`, **bez klucza** →
  duplikaty wierszy są możliwe. `loadWorkspaceScreensDb()` (`LauncherModel` ≈1287) robi `TreeMap<rank,id>`: ta sama ranga gubi ekran,
  to samo id z dwiema rangami daje id dwa razy.
- Zapisy tabeli:

  | # | gdzie | ranga | uwagi |
  |---|---|---|---|
  | W1 | `LauncherModel.updateWorkspaceScreenOrder()` ≈1002 | 0-based | batch w jednej transakcji, worker; −201 → nowe id **tylko w DB** |
  | W2 | `Workspace.createPersistedWorkspaceScreen()` ≈722 | indeks strony | wątek główny, własne id max+1 |
  | W3 | `CellLayout.ensurePagesExistForCustomElements()` ≈4086 | indeks strony | duplikat W2, może `_id < 0` |
  | W4 | `Workspace.insertNewWorkspaceScreen()` gałąź EXTRA ≈902 | indeks strony | id `abs(max)+1` albo „302 → 1” |
  | W5 | `Workspace.stripEmptyScreens()` ≈3296 | indeks strony | wątek główny, wyścig z W1 |

- Dwa generatory id: `LauncherProvider.generateNewScreenId()` (≈701, nie `synchronized`) i Workspace (W2, W4,
  `getIdForScreen()` krok 4 ≈3075 – „wirtualne” id dopisywane do `mScreenOrder`). Workspace nie przesuwa `mMaxScreenId` → kolizje id.
  `initializeMaxScreenId()` (≈722) rzuca wyjątek, gdy `MAX(_id) == -1`.
- `Workspace.onEndReordering()` (≈4695, przestawianie stron w overview): czyści `mScreenOrder` i odbudowuje przez `getIdForScreen()`
  (wirtualne id trafia tam dwa razy). Prefy elementów zostają na starych numerach. Zakres przestawiania
  (`getOverviewModePages()` ≈4680) zaczyna się od 0, więc **strona użytkownika też da się przestawić**.
- Przy `user_layout` = off `bindWorkspace()` (≈2512) nie wiąże żadnych ekranów, a strip, przestawienie i strona tworzona przy
  przeciąganiu wołają `updateWorkspaceScreenOrder(mScreenOrder)` z samym `[-302]` → **czyszczą tabelę ekranów**.
- `stripEmptyScreensBaseOnDB()`/`isEmptyScreenBaseDB()` (≈7647–7725): martwe (wywołanie w `Launcher` ≈3935 zakomentowane), zapytanie na wątku głównym.
- `WorkspaceScreensPreload` + `Workspace.loadWorkspaceScreensFromProvider()` (≈634): strony z odczytu z wyprzedzeniem znikają w
  `Launcher.startBinding()` → `removeAllWorkspaceScreens()`. Zostaw je.

### 0.5 Fakty z kodu: wyzwalacze elementów własnych i zdrowie układu
- `Launcher.requestCustomElementsSetup()` (≈1438): debounce 150 ms; żądanie przy otwartym All Apps jest porzucane **bez powtórki**;
  w trakcie ładowania odkładane i powtarzane w `finishBindingItems` (≈8527) i w watchdogu (≈1402).
  Źródła: `cellSizeChanged` (`CellLayout.onSizeChanged` ≈1140), `setupRecyclerView` (`LauncherAppBars` ≈644),
  `onResumePendingFreshCreate` (`Launcher` ≈2468), `CellLayout: …` (≈5131), `HomeLayoutRecovery` (≈295, ≈458).
- Gospodarz setupu: `Launcher.getCustomElementsSetupHost()` (≈1496) musi zgadzać się z `CellLayout.isCustomElementSetupHost()` (≈1251).
- `HomeLayoutRecovery.isLauncherLayoutHealthy()` (≈250): `CellLayout.hasHealthyCustomElements()` (≈4211) zwraca false dla **każdej**
  niezmierzonej strony, także bez elementów → pilne ponowienia; `isCustomElementsSetupInFlight()` (≈182) patrzy na flagi Launchera i CellLayout.
- Rozmiary `Launcher.calculated*` (≈571–581) są liczone w `onCreate` (`calculateLayoutDimensions()` ≈1840), więc są gotowe przed bindem.
- `cleanupGeneratedCustomElementRowsIfNeeded()` (≈1264) kasuje wiersze `favorites` bez tytułu i intencji. Loader i tak je usuwa
  (`itemsToRemove` dla pustej/null intencji, `LauncherModel` ≈1888–1898).
- Martwe: `mActiveFullWidgets` i `isUserWidget(this)` w `handleConflictingViews()` (≈5403), `hasStoredPipBounds()`,
  `LauncherModel.updateScreens()`, komentarz „For CanbusService” (≈4942).
- `getStatsPlaceholderPosition()` (≈5070) zwraca null, dopóki widok nie jest dodany. PiP ma fallback z prefów
  (`computePipPlaceholderPosition()` ≈4868). `CanbusService` ma wtedy własny fallback z inną arytmetyką (lewy pasek na każdej stronie,
  Y = margin + 10), więc okno statystyk przeskakuje.

### 0.6 Decyzje właściciela (nie zmieniaj ich)
1. **Jedno źródło prawdy: `LauncherModel`.** Kolejność ekranów, ekrany z treścią i strony elementów liczy model na wątku workera
   z bazy (`workspaceScreens`, `favorites` przez `sBgItemsIdMap`) i prefów. Widoki niczego nie wyliczają z własnego stanu,
   tylko wykonują plan. Stan widoku służy wyłącznie jako siatka bezpieczeństwa przy stosowaniu planu.
2. **Semantyka stron bez zmian dla użytkownika**: numer strony od 1, strona 1 = strona użytkownika; puste strony bez elementu
   znikają, a numery stron za nimi maleją (tak jak dziś po `stripEmptyScreens()` i jak kompaktuje `WidgetPageManager`).
   Strona elementu „za końcem” dostaje nowy ekran **na końcu**, bez pustych stron pomiędzy (dziś: ensure tworzy puste, strip je zabiera).
3. **Tylko włączone elementy trzymają strony** (jak model i strip dziś). Wyłączony element nie trzyma strony i jego pref nie jest przesuwany.
4. **`start_page` i `PINNED_PIP_SCREEN` idą za stronami**: przy usunięciu stron przed nimi maleją; przy przestawieniu stron idą
   za swoim ekranem. Same nie trzymają stron.
5. **Po przestawieniu stron w overview elementy idą za swoim ekranem** (widoki już to robią, teraz także prefy). Strony użytkownika
   nie da się przestawić.
6. **Inwariant**: prefy numerów stron zmieniają się na wątku głównym w tym samym kroku co lista stron `Workspace`
   (bind, zastosowanie stripu, koniec przestawiania). Dzięki temu `pref − 1 == indeks dziecka` zawsze, a `WindowUtil`,
   `CanbusService` i kreator **zostają bez zmian logiki**.
7. **Jeden zapis tabeli ekranów**: wyłącznie `LauncherModel.updateWorkspaceScreenOrder()` (rangi 0..n−1). Id nowego ekranu
   wyłącznie z `LauncherProvider.generateNewScreenId()`.
8. Elementy własne są stawiane **od razu po bindzie** (1–2 klatki), bez opóźnień 1,5 s/0,5 s/100–200 ms i bez „gospodarza setupu”.
9. Logi: `logCustomLayout()` i `DEBUG_CUSTOM_LAYOUT` znikają. Zostaje jedna linia na decyzję (plan, strona z elementami, strip,
   przestawienie, konflikt z przeniesieniem). Szczegóły w C6.

## 1. Zasady pracy i konwencje repo

- **Komentarze, Javadoc, `Log.*` i opisy commitów wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, wyjaśniają *dlaczego*.
- **Commity**:
  - temat `<Obszar>: <co>` (tematy przy krokach), treść zawinięta na ~72 znaki, w treści fakty z §0;
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push** po każdym commicie: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
  Przed następnym commitem poczekaj na wynik CI (`.github/workflows/build.yml`: `:app:testFytDebugUnitTest`, `:app:assembleFytDebug`,
  `:app:assembleStandardDebug`; `cancel-in-progress`, więc sprawdzaj run **ostatniego** commita przez GitHub MCP `actions_list`/`get_job_logs`).
  Czerwony build naprawiaj kolejnym commitem, bez amend i force-push.
- **Testy JVM**: JUnit 5 jak `MusicWidgetPlanTest` (`app/src/test/java/com/android/launcher66/`). `unitTests.isReturnDefaultValues = true`.
  Logikę decyzyjną pisz w **czystych klasach bez `android.*`** (`settings/Keys.java` to same stałe, wolno go używać).
- **StrictMode** jest włączony (`LauncherApplication.enableStrictMode()`): żadnego `ContentResolver`, I/O ani zapytań do DB na wątku głównym.
  Wszystkie decyzje oparte na bazie liczysz na workerze modelu (`runOnWorkerThread`), wynik wysyłasz na wątek główny przez `mHandler`
  (jak `bindWorkspace()`).
- **Bez nowych zależności, bez zmiany schematu DB i bez migracji prefów.** Naprawa tabeli ekranów to zwykły zapis W1.
- **Usuwaj dopiero po `rg`** w całym `app/src` (wszystkie source sety, Java i XML, `--glob '!**/generated/**'`).
- Duże pliki (`Launcher` ≈9200 linii, `Workspace` ≈7700, `CellLayout` ≈5400, `LauncherModel` ≈3600) edytuj punktowo.
- Kontrola bez SDK (opcjonalnie): `javac -proc:none -cp android_jar/android-36.jar -d <tmp> …` ze stubami w katalogu tymczasowym
  (nie w repo). Czyste klasy i ich testy możesz skompilować samym `javac` z JUnit z cache Gradle, jeśli jest.

## C1 — `Screens: a plan of the pages and the custom elements in plain Java`

Bez zmian zachowania. Tylko nowe klasy i test.

### C1.1 `CustomElement.java` (pakiet `com.android.launcher66`, czysta Java)
Enum dziewięciu elementów w kolejności, w jakiej dziś są dodawane:

| stała | `label` (logi, `pipType`, prefiks geometrii) | klucz włączenia | domyślnie | klucz strony | prefiks prefów geometrii |
|---|---|---|---|---|---|
| `DATE` | `date` | `Keys.USER_DATE` | `true` | `Keys.DATE_SCREEN` | `date` |
| `MUSIC` | `music` | `Keys.USER_MUSIC` | `true` | `Keys.MUSIC_SCREEN` | `music` |
| `RADIO` | `radio` | `Keys.USER_RADIO` | `true` | `Keys.RADIO_SCREEN` | `radio` |
| `PIP_DUAL` | `dual` | `Keys.PIP_DUAL` | `false` | `Keys.PIP_DUAL_SCREEN` | `Keys.PIP_DUAL_KEY` |
| `PIP_FIRST` | `first` | `Keys.PIP_FIRST` | `false` | `Keys.PIP_FIRST_SCREEN` | `Keys.PIP_FIRST_KEY` |
| `PIP_SECOND` | `second` | `Keys.PIP_SECOND` | `false` | `Keys.PIP_SECOND_SCREEN` | `Keys.PIP_SECOND_KEY` |
| `PIP_THIRD` | `third` | `Keys.PIP_THIRD` | `false` | `Keys.PIP_THIRD_SCREEN` | `Keys.PIP_THIRD_KEY` |
| `PIP_FOURTH` | `fourth` | `Keys.PIP_FOURTH` | `false` | `Keys.PIP_FOURTH_SCREEN` | `Keys.PIP_FOURTH_KEY` |
| `STATS` | `stats` | `Keys.USER_STATS` | `false` | `Keys.STATS_SCREEN` | `stats` |

- Domyślne muszą odpowiadać `res/xml/creator_preferences.xml`. Komentarz po angielsku: model, strip i `CellLayout` miały różne
  domyślne i to jest jedyne miejsce, gdzie one żyją.
- Metody: `isPip()`, `static CustomElement fromLabel(String)` (null dla nieznanej), `static CustomElement fromScreenKey(String)`.
- Odczyt prefów **nie** w tym enumie (czysta Java). Dodaj osobną, małą klasę `CustomElementPrefs` (może używać `SharedPreferences`):
  - `static EnumMap<CustomElement, Integer> requestedPages(SharedPreferences)`: tylko włączone (z domyślną z enumu), wartość `getInt(screenKey, 1)`;
  - `static LinkedHashMap<String, Integer> pageRefs(SharedPreferences)`: `Keys.START_PAGE` (String → `int`; pusty/niepoprawny pomijasz)
    i `Keys.PINNED_PIP_SCREEN` (tylko gdy `contains`);
  - `static void apply(SharedPreferences, List<WorkspaceScreenPlan.PrefChange>)`: jeden `edit()…apply()`. Zmianę stosujesz tylko,
    gdy bieżąca wartość == `from` (idempotencja przy ponownym bindzie). `START_PAGE` zapisujesz jako `String`.

### C1.2 `WorkspaceScreenPlan.java` (czysta Java)
- `public static final long USER_PAGE_ID = -302L;` W C2 `Workspace.CUSTOM_CONTENT_SCREEN_ID1` będzie równe tej stałej.
- `final class PrefChange { String key; int from; int to; }` (niezmienna, `equals`/`toString` do logów i testów).
- `final class Input` (builder albo konstruktor, kopie defensywne):
  - `List<Long> order`: ekrany w kolejności (z DB albo z `Workspace`), bez strony użytkownika;
  - `Set<Long> screensWithContent`;
  - `Set<Long> keep`: ekrany chronione chwilowo (np. ekran, na który jedzie element z szuflady);
  - `Map<CustomElement, Integer> requestedPages` (tylko włączone, od 1);
  - `Map<String, Integer> pageRefs` (`START_PAGE`, `PINNED_PIP_SCREEN`; tylko przesuwane, nie trzymają stron);
  - `boolean createMissing` i `LongSupplier newScreenId` (używany tylko przy `createMissing`).
- `final class Result` (niezmienna): `List<Long> order`, `List<Long> removed`, `List<Long> created`,
  `EnumMap<CustomElement, Integer> elementPages`, `EnumMap<CustomElement, Long> elementScreens`, `List<PrefChange> prefChanges`,
  `boolean orderChanged()`, `boolean changed()`, `String describe()` (jedna linia do logu).
- `static Result plan(Input)`. Algorytm:
  1. `pages = [USER_PAGE_ID] + order` po odfiltrowaniu id < 0 i duplikatów (zostaje pierwsze wystąpienie).
  2. Żądana strona < 1 → 1, z `PrefChange` (naprawa).
  3. `createMissing`: dopóki `pages.size() <` największej żądanej strony, dopisz stronę „wirtualną” (bez id).
     Bez `createMissing` element ze stroną za końcem nie dostaje id ani `PrefChange` (wywołujący loguje `Log.w`).
  4. Strona zostaje, gdy: indeks 0, albo jej id jest w `screensWithContent` lub `keep`, albo jakiś element jej żąda.
     Pozostałe (także wirtualne) znikają.
  5. Nowy numer strony = stary − liczba usuniętych stron przed nią. Dla elementów: `elementPages`, `PrefChange` gdy się zmienił.
  6. `pageRefs`: wartość `r` z zakresu `1..pages.size()` → `max(1, r − liczba usuniętych stron o indeksie ≤ r − 1)`
     (usunięta strona startowa przechodzi na najbliższą zachowaną przed nią); wartość poza zakresem bez zmian.
  7. Zachowane strony wirtualne dostają id z `newScreenId` w kolejności → `created`. `order` = zachowane id bez `USER_PAGE_ID`.
     `removed` = usunięte id z wejścia. `elementScreens`: `USER_PAGE_ID` dla strony 1, w pozostałych id strony.
- `static List<PrefChange> remapAfterReorder(List<Long> oldPages, List<Long> newPages, Map<String, Integer> refs)`:
  listy stron **z** `USER_PAGE_ID` na indeksie 0; dla każdej referencji `r` w zakresie: id = `oldPages[r−1]`, nowy numer = indeks
  tego id w `newPages` + 1; `PrefChange`, gdy inny. Referencje = strony włączonych elementów + `pageRefs`.
- `final class Snapshot` (niezmienna, dla wątku głównego i ustawień): `order`, `screensWithContent`, `elementScreens`;
  `static final Snapshot EMPTY`; `boolean isReady()`; `int pageCount()` (= `order.size() + 1`);
  `boolean pageHasContent(int pageIndex)` (indeks 0 → true; inaczej czy `order[pageIndex−1]` ma treść).

### C1.3 `app/src/test/java/com/android/launcher66/WorkspaceScreenPlanTest.java`
Przypadki (nazwy metod opisowe, po angielsku):
- **Log właściciela**: `order = [3, 4, 5, 6]`, treść `{3, 6}`, `PIP_DUAL`, `PIP_THIRD`, `STATS` na 1, `PIP_FOURTH` na 3, `DATE`, `MUSIC`, `RADIO` na 4
  → `order` bez zmian, `removed`/`created`/`prefChanges` puste, `elementScreens`: dual/third/stats → −302, fourth → 4, date/music/radio → 5.
- Pusta strona przed stroną z elementem: `[3, 4, 5]`, treść `{3}`, `MUSIC` na 4 (id 5) → `removed = [4]`, `MUSIC` na 3, `PrefChange(music_screen, 4, 3)`.
- To samo bez elementu na 4 → usunięte 4 i 5.
- Strona za końcem: `[3]`, treść `{3}`, `MUSIC` na 4, `createMissing` z `newScreenId` = 10 → `order = [3, 10]`, `created = [10]`, `MUSIC` na 3.
- Dwa elementy za końcem na 3 i 5 → dwa nowe ekrany, strony 3 i 4.
- Bez `createMissing` strona za końcem: brak id, brak `PrefChange`, kolejność bez zmian.
- `keep` chroni pusty ekran.
- Wyłączony element (brak w `requestedPages`) nie trzyma strony.
- `START_PAGE = 4` przy usunięciu strony 2 → 3; usunięta strona startowa → poprzednia zachowana; `START_PAGE = 9` (poza zakresem) bez zmian.
- `PINNED_PIP_SCREEN` przesuwa się jak `START_PAGE`.
- Duplikaty i ujemne id w wejściu: `[3, 3, -201, 4]` → `[3, 4]`.
- Idempotencja: plan wyniku (z tymi samymi danymi) nie zmienia niczego.
- Strona < 1 → 1 z `PrefChange`.
- `remapAfterReorder`: `[−302, 3, 4, 5] → [−302, 5, 3, 4]`, `MUSIC` na 4 (id 5) → 2, `START_PAGE = 2` (id 3) → 3.
- `Snapshot.pageCount()` i `pageHasContent()`.

## C2 — `Model: the screens and the custom elements' pages come from the database`

### C2.1 `LauncherModel`: stan
- Nowe pola statyczne pod `sBgLock`: `sBgCustomElementScreens` (`EnumMap<CustomElement, Long>`) i `sBgRetainedScreens` (`HashSet<Long>`).
  Czyść je w `clearSBgDataStructures()` (≈1785).
- `private static volatile WorkspaceScreenPlan.Snapshot sScreenSnapshot = Snapshot.EMPTY;` i `public static Snapshot getScreenSnapshot()`.
  Metoda `publishScreenSnapshotLocked()` buduje migawkę z `sBgWorkspaceScreens`, ekranów z treścią i `sBgCustomElementScreens`.
- Metoda `screensWithContentLocked()`: `container == CONTAINER_DESKTOP` z `sBgItemsIdMap` (ikony, foldery, widżety) ∪ `sBgRetainedScreens`.
  To jest definicja „ekran ma treść” dla loadera i dla stripu (C4). Komentarz: wiersze, których loader nie wiąże (poza siatką,
  nakładające się, odrzucone), nie trzymają strony, tak jak dziś.
- `needRetainScreens` (≈1833, ≈1914) zastąp `sBgRetainedScreens` i dodawaj **tylko** wiersze z `CONTAINER_DESKTOP` (dziś trafiają tam też hotseatowe).

### C2.2 `LauncherModel.loadWorkspace()`: jeden plan zamiast `customScreens`/`unusedScreens`
W obu gałęziach (import ≈2150 i zwykła ≈2175) najpierw powstaje lista ekranów, potem **jeden** plan:
1. Gałąź importu: jak dziś (ekrany z elementów, `updateMaxScreenId`), ale bez zapisu tabeli w tym miejscu.
2. Gałąź zwykła: odczyt tabeli (patrz C2.3), potem `restoreMissingScreens()` (≈1693) **bez** własnego zapisu tabeli
   (tylko `sBgWorkspaceScreens.addAll(missing)` i `Log.w` jak dziś).
3. Pętla `placeOverlappingWidget()` (≈2251) przenieś **przed** plan i usuń z niej zapis tabeli (ekran dopisany do `sBgWorkspaceScreens` wystarczy).
4. Plan: `order = sBgWorkspaceScreens`, treść = `screensWithContentLocked()`, `keep` puste, `requestedPages`/`pageRefs` z
   `CustomElementPrefs` (prefy domyślne `PreferenceManager.getDefaultSharedPreferences(mContext)`), `createMissing = true`,
   `newScreenId = LauncherAppState.getLauncherProvider()::generateNewScreenId`.
5. Gdy wynik różni się od tabeli (C2.3) → `updateWorkspaceScreenOrder(mContext, plan.order)`. `sBgWorkspaceScreens = plan.order`.
6. `sBgCustomElementScreens = plan.elementScreens`; zachowaj plan w polu `LoaderTask` (`mScreenPlan`) dla `bindWorkspace()`.
7. `publishScreenSnapshotLocked()`, jedna linia logu (C6).
- Usuń cały blok `customScreens`/`unusedScreens`/`Preserving …` (≈2183–2249).
- Gdy `loadWorkspace()` jest pominięte (`mWorkspaceLoaded`), `bindWorkspace()` bierze ostatni plan. Dlatego `PrefChange` ma `from`
  i stosuje się tylko przy zgodnej wartości (C1.1).

### C2.3 Tabela ekranów: odczyt i samonaprawa
- Rozszerz odczyt (np. nowa `readWorkspaceScreens(Context)` obok `loadWorkspaceScreensDb()`, która zostaje dla `addAndBindAddedApps()`):
  kolejność po randze i liczba wierszy. Tabela jest **kanoniczna**, gdy liczba wierszy == liczba różnych id, rangi to dokładnie 0..n−1,
  a kolejność == `plan.order`. Inaczej przepisz ją przez W1. To naprawia `{1=3, 2=4, …}`, duplikaty z W2/W3 i ujemne id.
- `updateWorkspaceScreenOrder()` (≈1002): pomijaj **wszystkie** id < 0 (także −201: usuń podmianę na nowe id, ≈1014–1018)
  i duplikaty (pierwsze wystąpienie). Komentarz: Workspace nadaje prawdziwe id przed zapisem (`commitExtraEmptyScreen()`).
- `LauncherProvider.generateNewScreenId()` (≈701): `synchronized`; usuń gałąź „302”, zostaw pomijanie id z `sBgWorkspaceScreens`
  pętlą `do { ++mMaxScreenId; } while (…)`.
- `initializeMaxScreenId()` (≈722): `SELECT MAX(_id) FROM workspaceScreens WHERE _id >= 0`; NULL → 0; nie rzucaj wyjątku.
- Usuń `LauncherModel.updateScreens()` (bez wywołań).

### C2.4 Przekazanie planu do Launchera
- `LauncherModel.Callbacks`: nowa metoda `void bindScreenPlan(WorkspaceScreenPlan.Result plan)`. Implementuje ją tylko `Launcher`.
- `bindWorkspace()` (≈2486): tuż przed `bindWorkspaceScreens()` wyślij `bindScreenPlan(mScreenPlan)` jako `MAIN_THREAD_BINDING_RUNNABLE`
  (ta sama kolejka co `startBinding()` i `bindScreens()`), także gdy `user_layout` jest wyłączony.
- `Launcher.bindScreenPlan(plan)`: `CustomElementPrefs.apply(mPrefs, plan.prefChanges)`, zapamiętaj `mCustomElementScreens =
  new EnumMap<>(plan.elementScreens)`. Prefy zmieniają się tu, zanim `bindScreens()` zbuduje strony (decyzja 6).

### C2.5 Usunięcia w Workspace i CellLayout
- `Workspace.ensurePageExists()` (≈666) i `createPersistedWorkspaceScreen()` (≈722): usuń (jedyny wołający to CellLayout).
- `CellLayout.ensurePagesExistForCustomElements()` (≈4023) i krok 1 w `triggerAddCustomElements()` (≈1203): usuń. Strony istnieją po bindzie.
- `CellLayout.cleanupGeneratedCustomElementRowsIfNeeded()`, `mGeneratedCustomRowsCleanupDone`, `CUSTOM_ELEMENT_CLEANUP_EXECUTOR`: usuń
  (loader usuwa te wiersze, §0.5).
- `Workspace.CUSTOM_CONTENT_SCREEN_ID1 = WorkspaceScreenPlan.USER_PAGE_ID;`
- Stare stawianie elementów (`addWidgetsToAllExistingPages()`) w tym commicie jeszcze działa: dzięki C2.4 `pref − 1` wskazuje właściwe strony.

## C3 — `Custom elements: placed on the screens the model names`

### C3.1 `CellLayout`: nowe API stawiania
- `void setCustomElements(EnumSet<CustomElement> elements)`: zapamiętuje przydział strony (`mAssignedElements`) i wywołuje
  `scheduleCustomElementPlacement()`.
- `scheduleCustomElementPlacement()`: gdy `mCellWidth/mCellHeight/mCountX/mCountY > 0` i strona jest w `Workspace` → **jeden** `post()`
  na stronę (flaga `mPlacementPosted`); inaczej czeka na `onSizeChanged()`, które woła tę metodę zamiast
  `mLauncher.requestCustomElementsSetup("cellSizeChanged")` (usuń `mNeedsWidgetSetup`). `post`, bo `onSizeChanged` biegnie w przebiegu layoutu.
- `placeAssignedElements()` (w poście): dla każdego przydzielonego elementu, który nie jest dołączony, w kolejności enumu:
  - `DATE/MUSIC/RADIO` → dzisiejsza `addCustomWidgetToGrid()` (≈4396), PiP → `addPipPlaceholder()` (≈4717), `STATS` → `addStatsPlaceholder()` (≈4943);
  - w tych metodach zamień sprawdzenia „indeks strony == pref − 1” na „element jest w `mAssignedElements`”; zostaw `canResolveScreenId()`
    i powrót, gdy strony nie ma w `Workspace`;
  - `handleConflictingViews()` **synchronicznie** (bez `postDelayed` 100/150/200 ms) i `addViewToCellLayout()` synchronicznie
    (bez `mLauncher.handler.post`), także statystyki bez `postDelayed(…, 200)` i bez `mPendingStatsPlaceholderAdd`;
  - **bez** `workspace.triggerStripEmptyScreens(…)` (model już uwzględnił strony elementów);
  - geometria i arytmetyka piksel→komórka **bez zmian** (`pointToCellExact`, prefy rogów, margines, `isLeftBarOffsetActive()`, `calculated*`).
  - elementy stawiasz dopiero po `finishBindingItems`, więc `handleConflictingViews()` widzi już wszystkie ikony, foldery i widżety strony.
    To zamyka punkt 3.7 z `docs/sonnet-prompt-2026-11-02-widgets-bars-layout.md` (element wiązany po elemencie niestandardowym).
- `boolean hostsCustomElements()` = przydział niepusty.
- `boolean isCustomElementPlacementPending()` = jest przydział, a któryś element nie jest jeszcze dołączony (czeka na rozmiar albo na post).
  Zastępuje `isCustomElementSetupPending()`.
- `hasHealthyCustomElements()`: strona bez przydziału → zawsze true (także niezmierzona); z przydziałem → każdy element dołączony
  albo czeka na post. Nie czytaj już prefów stron.
- `moveItemToAnotherPage()` (≈5218): przebieg „strony bez elementów najpierw” przez `target.hostsCustomElements()` zamiast `checkIfPageNeedsWidgets(i)`.
- `getStatsPlaceholderPosition()`: gdy widoku nie ma, a strona ma przydzielone `STATS`, zwróć `computeStatsPlaceholderPosition()`
  z tą samą arytmetyką co `addStatsPlaceholder()` (bez wołania `StatsWindowSize.syncSavedRectangle()`, które zapisuje prefy),
  jak `computePipPlaceholderPosition()` dla PiP. `CanbusService` zostaje bez zmian.
- Usuń: `triggerAddCustomElements()` (obie), `retryCustomElementSetup()`, `isCustomElementSetupHost()`, `addWidgetsToAllExistingPages()`,
  `addWidgetsToPagesImmediately()`, `checkIfPageNeedsWidgets()`, `addWidgetsToPage()`, `checkAndAddWidgetsView()`, `checkAndAddPipPlaceholders()`,
  `deferCustomElementSetupWhileLoading()`, `hasStoredPipBounds()`, martwy blok `mActiveFullWidgets` w `handleConflictingViews()`,
  pola `mCustomElementSetup*`, `mCustomElementAdd*`, `CUSTOM_ELEMENT_*` i `userDate…fourthPip`, `mHasUserWidgets`
  (po `rg`, że nikt spoza CellLayout ich nie czyta), komentarz „For CanbusService”.
- `onDetachedFromWindow()`: zdejmij oczekujący post stawiania.
- `computePipPlaceholderPosition()` zostaw z dzisiejszym warunkiem `pref − 1 == indexOfChild(this)`: `WindowUtil` może pytać przed
  przydziałem, a inwariant z decyzji 6 czyni go równoważnym.

### C3.2 `Launcher`
- Nowa `void placeCustomElements(String source)`: nic, gdy `mWorkspace == null`, `user_layout` wyłączony, `mWorkspaceLoading`
  albo brak `mCustomElementScreens`. Inaczej grupuje elementy po id ekranu, dla każdej grupy `mWorkspace.getScreenWithId(id)`
  → `setCustomElements(set)`; brak strony → `Log.w` (model i strony się rozjechały). **Otwarte All Apps nie blokuje.**
- Wołaj ją:
  - w `finishBindingItems()` (≈8527) zamiast `replayCustomElementsSetupAfterBind()`;
  - w watchdogu ładowania (≈1402) zamiast powtórki;
  - na końcu `Workspace.createUserPage()`, gdy `!mLauncher.isWorkspaceLoading()` (`recreateView()` bez `forceReload()` ≈2669 buduje nową stronę 1);
  - w `onResume` zamiast `requestCustomElementsSetup("onResumePendingFreshCreate")` (≈2468).
- Usuń: `requestCustomElementsSetup()` (obie), `requestCustomElementsHealthRetry()`, `replayCustomElementsSetupAfterBind()`,
  `getCustomElementsSetupHost()`, `mCustomElementsSetupRunnable`, `mCustomElementsSetupAfterBind*`, `CUSTOM_ELEMENTS_SETUP_DEBOUNCE_MS`.
- `LauncherAppBars` ≈644: usuń żądanie `setupRecyclerView` (rozmiary `calculated*` są gotowe od `onCreate`).

### C3.3 `HomeLayoutRecovery`
- `isCustomElementsSetupInFlight()`: true, gdy któraś strona ma `isCustomElementPlacementPending()`. Bez pól Launchera.
- `isLauncherLayoutHealthy()` i `repairWorkspaceChromeAfterHome()`: zamiast `requestCustomElementsHealthRetry`/`requestCustomElementsSetup`
  wołaj `mLauncher.placeCustomElements(source)` (idempotentne, tanie).
- Pętle po stronach z `hasHealthyCustomElements()` zostają. Strony bez elementów nie psują już zdrowia.

## C4 — `Workspace: empty screens judged by the model`

### C4.1 Strip: wejście w Workspace, decyzja w modelu
- `triggerStripEmptyScreens(source, instant)` zostaje jako jedyne wejście (debounce `STRIP_DELAY`).
- `stripEmptyScreens(source)`:
  - odroczenie przy ładowaniu (`mStripScreensAfterLoad`) i przy przewijaniu (`mStripScreensOnPageStopMoving`) jak dziś;
  - **no-op przy wyłączonym `user_layout`** (strony nie są wtedy związane z tabelą, §0.4);
  - `uiOrder` = `mScreenOrder` bez id < 0; `keep` = `mScreenAwaitingAdd`, dopóki nie minęło `SCREEN_AWAITING_ADD_MAX_MS` (≈3166);
  - `mLauncher.getModel().planScreenStrip(mLauncher, uiOrder, keep, source)`.
- `LauncherModel.planScreenStrip(Callbacks, List<Long> uiOrder, Set<Long> keep, String source)`: na workerze (po zapisach już
  w kolejce FIFO, więc ostatni drop jest w `sBgItemsIdMap`), pod `sBgLock`: treść = `screensWithContentLocked()`, prefy przez
  `CustomElementPrefs`, plan z `createMissing = false`, `publishScreenSnapshotLocked()`. Gdy plan coś zmienia → na wątek główny
  `callbacks.bindScreenStrip(plan, uiOrder, source)` (nowa metoda `Callbacks`, Launcher deleguje do Workspace).
- `Workspace.applyScreenStrip(plan, basedOn, source)` na wątku głównym:
  - gdy `mScreenOrder` bez id < 0 różni się od `basedOn` → nic nie zmieniaj, `triggerStripEmptyScreens(source, false)` (limit 3 kolejnych prób, potem `Log.w`);
  - **siatka bezpieczeństwa**: gdy któraś strona z `plan.removed` ma dziecko, które `CellLayout.isMovableLauncherItem()` (≈5136,
    uczyń ją widoczną w pakiecie) uznaje za element launchera (ikona, folder, widżet) → nic nie zmieniaj i poproś o strip ponownie
    (ta sama granica). Nie stosuj planu częściowo, bo prefy liczono dla całości;
  - usuń strony z `plan.removed` (z `mWorkspaceScreens`, `mScreenOrder`, `removeView`, `pageShift` jak dziś ≈3229–3248, bez gałęzi
    „zamień ostatnią na −201”, której strona użytkownika nie dopuszcza);
  - `CustomElementPrefs.apply(prefs, plan.prefChanges)` w tym samym kroku (decyzja 6);
  - `mLauncher.getModel().updateWorkspaceScreenOrder(mLauncher, mScreenOrder)`; `setCurrentPage(currentPage − pageShift)`;
  - `WindowUtil.startMapPip(false)` po 250 ms jak dziś (≈3317–3325).
- Usuń z `stripEmptyScreens()`: wykrywanie pustych po widokach, listę `customScreens`, `maybeShiftPref`, pętlę rang (W5).
- Usuń `stripEmptyScreensBaseOnDB()`, `isEmptyScreenBaseDB()`, `mStripScreensBaseOnDBAfterLoad` i jego obsługę w `onWorkspaceLoadFinished()`.

### C4.2 Ekran tworzony przy przeciąganiu i id
- `insertNewWorkspaceScreen()` gałąź `EXTRA_EMPTY_SCREEN_ID` (≈902): id z `LauncherAppState.getLauncherProvider().generateNewScreenId()`,
  bez własnego INSERT (W4); po dodaniu strony `updateWorkspaceScreenOrder(mLauncher, mScreenOrder)`, ale tylko przy włączonym `user_layout`.
  Zachowanie (strona powstaje od razu przy starcie przeciągania) bez zmian.
- `getIdForScreen()` (≈3047): nie dopisuj nic do `mScreenOrder`. Krok 4 („wirtualne” id) zastąp `generateNewScreenId()`, wpisem tylko do
  `mWorkspaceScreens` i `Log.e` (to się nie powinno zdarzać).
- `commitExtraEmptyScreen()` zostaje (już używa generatora i W1).

### C4.3 Przestawianie stron w overview
- Nowa `protected void getReorderablePages(int[] range)` w `PagedView`, domyślnie `getOverviewModePages(range)`. Wołaj ją w
  `startReordering()` (≈2649) i w obsłudze najechania przy przestawianiu (≈1948) zamiast `getOverviewModePages()`.
  `Workspace` nadpisuje: początek o 1 dalej, gdy `hasMyCustomContent()` (strona użytkownika stoi na 0). `getOverviewModePages()`
  bez zmian (przewijanie w overview dalej obejmuje stronę 1).
- `onEndReordering()` (≈4695):
  - stara lista stron = `[USER_PAGE_ID] + mScreenOrder` sprzed zmiany, nowa = id dzieci przez `mWorkspaceScreens` (bez `getIdForScreen()`);
  - gdy indeks 0 nie jest stroną użytkownika → `Log.e` i przywróć ją na 0;
  - referencje: strony włączonych elementów + `CustomElementPrefs.pageRefs()`; `remapAfterReorder()` → `CustomElementPrefs.apply()`;
  - `mScreenOrder` = nowa lista; zapis przez W1 tylko przy włączonym `user_layout`;
  - `mCustomElementScreens` się nie zmienia (id ekranów te same), widoki elementów jadą ze swoimi stronami.
- Po zapisie model odświeża migawkę (`updateWorkspaceScreenOrder()` na workerze może zawołać `publishScreenSnapshotLocked()` po udanym batchu).

## C5 — `Settings: page numbers checked against the model`

`settings/WidgetPageManager.java`: reguły UX bez zmian (zakres 1..99, `highestIndex + 2`, strażnik „sam na ostatniej stronie”,
kompaktowanie przerw), zmieniają się tylko źródła danych:
- liczba stron = `LauncherModel.getScreenSnapshot().pageCount()` zamiast `workspace.getChildCount()`;
  gdy migawka nie jest gotowa → `return false` (jak dziś bez Launchera);
- `getPagesWithRegularContent()` = indeksy `i`, dla których `snapshot.pageHasContent(i)` (bez strony 0, która i tak jest „zajęta” w kodzie);
- `ALL_WIDGET_KEYS` i `addWidgetPages()`: tylko **włączone** elementy (`CustomElement` z domyślną włączenia), decyzja 3;
- strażnik „sam na ostatniej stronie”: zamiast przeglądać widoki (`isUserWidget`, `getUserWidgetKey`, które dla PiP i statystyk daje `"null"`):
  strona jest „sama”, gdy nie ma treści w migawce i żaden **inny** włączony element nie ma tego numeru strony; usuń martwe `checkCustomElements()`;
- usuń importy `CellLayout`, `Workspace`, `View`, `ViewGroup`, jeśli przestaną być potrzebne.
- `CellLayout.getUserWidgetKey()`: usuń, gdy `rg` nie pokaże innych użyć. `isUserWidget()` zostaje (`ShortcutAndWidgetContainer`, `handleConflictingViews`).

## C6 — `Logs: one line per decision on the screens and the custom elements`

### C6.1 Zostają (lub powstają), po jednej linii
- Model, plan przy ładowaniu (`Log.i`, tag `Launcher.Model`), np.
  `Screen plan (load): order=[3, 4, 5, 6] removed=[] created=[] pages={dual=1, third=1, fourth=3, date=4, music=4, radio=4, stats=1} prefs=[]`.
  Bez zmian może być krócej (`… no change`), ale zawsze jedna linia.
- Workspace, wynik stripu (`Log.i`) tylko gdy coś usunięto: `Screen strip (<source>): removed=[…] order=[…] prefs=[…]`;
  odroczenia i ponowienia `Log.d`; porzucenie po 3 próbach `Log.w`.
- Workspace, przestawienie: `Screens reordered: order=[…] prefs=[…]`.
- `Launcher.bindScreens order: […]` zostaje; dodaj `Log.i` w `bindScreenPlan()` tylko gdy zastosowano zmiany prefów.
- CellLayout, jedna linia na stronę po postawieniu (`Log.i`):
  `Custom elements on page 4 (screen 5): date [0,0 3x1], music [0,0 2x3], radio [1,0 3x2]`.
- `handleConflictingViews()`: `Log.i` tylko gdy coś przeniesiono (`relocated`, `moved to another page`); `Log.w` przy braku miejsca (już jest).
- Launcher: `Log.d(TAG, "Custom elements placed (" + source + "): " + pages + " pages")` tylko gdy coś przydzielono.

### C6.2 Usuń
- `logCustomLayout()` i `DEBUG_CUSTOM_LAYOUT` (≈62, ≈158) wraz ze wszystkimi wywołaniami, które nie trafiły do C6.1 (≈58 wywołań):
  START/END sekcji, „Total pages/children…”, „Workspace post() executed…”, „Page N needs/does not need…”, „PiP states…”,
  „-> Should add …”, „shouldAddWidgets…”, „Creating … widget…”, „addCustomWidgetToGrid called…”, „addPipPlaceholder START…”,
  „Custom element wants cells…”, „Total views to process…”, „✓ Widgets added…”.
- `LauncherModel`: `orderedScreens`, `sBgWorkspaceScreens`, `unusedScreens`, `customScreens`, `Preserving custom widget…`;
  „valuse put CELLX…” w `moveItemInDatabase()` (≈684), `moveItemsInDatabase()` (≈718), `modifyItemInDatabase()` (≈750),
  oraz `updateItemInDatabase()` (≈767) i `addItemToDatabase()` (≈893) z „CELLX = …;SCREEN = …”.
- `Workspace`: `insertNewWorkspaceScreen: adding …` i `… final mScreenOrder=…` (≈891, ≈933), `Persisted workspace screen…` (≈917),
  `createPersistedWorkspaceScreen…` (znika z metodą), `triggerStripEmptyScreens called in:` (≈3111), `stripEmptyScreens called in:` (≈3138),
  `Updated screenId=… → rank=…` (≈3307), `Shifted pref …` (≈3280), `Screen order onDrop(): …` (≈5653).
  `insertNewWorkspaceScreen: DUPLICATE!` i `… already in mWorkspaceScreens` zostają (`Log.e`/`Log.w` anomalii).
- `Launcher`: `JLog.getInstance().e("Launcher bindItems")` (≈8128, duplikat `Log.d(TAG, "bindItems")`),
  `Custom elements setup requested/deferred …` (znikają z kodem C3).
- `CellLayout`: `Custom element setup deferred/skipped…`, `Custom element setup waits for the workspace to load…` (znikają z kodem C3).
- Nie ruszaj logów innych obszarów (PiP, paski, `WindowUtil`, `HomeLayoutRecovery` poza zmienionymi wywołaniami).

## 4. Czego NIE zmieniać

- Geometrii elementów: prefów rogów (`dateTopLeftX`…, `pipDualTopLeftX`…, `statsTopLeftX`…), marginesu, przesunięcia o lewy pasek
  na stronie 1, `calculated*`, `pointToCellExact()` i `ShortcutAndWidgetContainer` (pozycje pikselowe elementów).
- `WindowUtil`, `CanbusService` (korzystają z inwariantu z decyzji 6 i z fallbacku statystyk z C3.1).
- Kreatora, `Helpers`, `Creator*`, `DrawView*`, `SettingsFragmentSecond` (ich własne domyślne włączenia to znana rozbieżność na osobną rundę).
- `CustomLayoutDb`, `WorkspaceOccupancy`, `GridGeometry`, `CustomLayoutResolver` i publikacji siatki w `CellLayout.onMeasure()`
  (`publishGridGeometry()`): czytają tabelę ekranów i `favorites` po swojemu (świadomie na wątku głównym, decyzja poprzedniej rundy);
  po C2/C4 dostają tabelę zgodną z kolejnością stron.
- Zasad UX `WidgetPageManager` (tylko źródła danych, C5).
- Schematu DB, `WorkspaceScreensPreload`, `addAndBindAddedApps()` (dopisuje ekrany na końcu przez W1, więc numery stron elementów się nie zmieniają),
  `Workspace.addInScreen()` (ekran w pamięci dla zgubionego id zostaje jako awaryjny, z `Log.w`).
- `.github/workflows/*`, `app/src/main/generated/baselineProfiles/`, `decompiled_*`, `fuel_stats_example/`.

## 5. Weryfikacja

1. Po każdym commicie: CI zielone; w C1 nowe testy przechodzą.
2. Kontrola końcowa (`rg` w `app/src`, `--glob '!**/generated/**'`):
   - `logCustomLayout|DEBUG_CUSTOM_LAYOUT|ensurePageExists|createPersistedWorkspaceScreen|ensurePagesExistForCustomElements|stripEmptyScreensBaseOnDB|isEmptyScreenBaseDB|triggerAddCustomElements|requestCustomElementsSetup|cleanupGeneratedCustomElementRows|maybeShiftPref|valuse` → zero;
   - `WorkspaceScreens.CONTENT_URI` → tylko `LauncherModel`, `LauncherProvider`, `WorkspaceScreensPreload`, `LauncherSettings`;
   - `getChildCount\(\)|isUserWidget|getUserWidgetKey` w `settings/WidgetPageManager.java` → zero;
   - `DATE_SCREEN|MUSIC_SCREEN|RADIO_SCREEN|STATS_SCREEN|PIP_.*_SCREEN` w `LauncherModel.java` i `Workspace.java` → tylko przez `CustomElement`.
3. Scenariusze dla właściciela (telefon i FYT), wypisz je w raporcie:
   - a) powrót z ustawień jak w logu właściciela: jedna linia `Screen plan (load)`, elementy na stronach 1, 3, 4 w 1–2 klatki po
     `finishBindingItems`, brak serii `triggerStripEmptyScreens`, brak `insertNewWorkspaceScreen: adding …`;
   - b) stara baza z rangami `{1=3, 2=4, 3=5, 4=6}` → po pierwszym starcie tabela 0..3, kolejny start bez zapisu tabeli;
   - c) pusta strona przed stroną z PiP (przenieś ostatnią ikonę ze strony 2, PiP na 3): strona 2 znika, PiP zostaje na swoim ekranie,
     pref `pip_*_screen` = 2, okno PiP na właściwym miejscu bez restartu;
   - d) w kreatorze element na stronie 9 przy 3 stronach → po powrocie nowa strona 4 z elementem, pref = 4;
   - e) przeciągnięcie ikony na nową stronę i z powrotem; dodanie widżetu z ekranem konfiguracji na nową stronę (ekran „w drodze” zostaje);
   - f) odinstalowanie aplikacji, której ikona była jedyna na stronie;
   - g) przestawienie stron w overview: elementy i `start_page` idą za ekranem; strony 1 nie da się przenieść;
   - h) `start_page` = 3 i usunięcie strony 2 → start na właściwej stronie;
   - i) `user_layout` off → on: tabela ekranów i prefy nietknięte, elementy wracają na swoje strony;
   - j) statystyki: okno nie przeskakuje przy starcie;
   - k) wyłączony element na pustej stronie: strona znika, pref elementu bez zmian.

## 6. Raport końcowy (w odpowiedzi, po polsku)

- Commity (hash + temat) i wynik CI każdego.
- Lista usuniętych metod/pól i miejsc, gdzie zostało coś z dawnej logiki (z powodem).
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z pkt 5.3 z tym, czego właściciel ma szukać w logu.
