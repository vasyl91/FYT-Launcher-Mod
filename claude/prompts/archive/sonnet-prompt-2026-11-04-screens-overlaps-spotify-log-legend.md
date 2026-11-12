# Launcher Mod: numer ekranu za ostatnią stroną, nachodzące elementy na każdej stronie, start przeglądarki Spotify, legenda logów — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `testBranch`. Zacznij od `git pull origin testBranch`.
Zrób cztery commity w kolejności C1 → C4. **Każdy commit musi się budować samodzielnie i przechodzić testy.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.**

Numery linii to stan z `e6cf49b` i są orientacyjne (≈). Zawsze sprawdzaj je w kodzie.
Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`.
Logów nie masz. Fakty z nich są poniżej.

## 0. Fakty i diagnoza

### 0.1 Legenda nazw logów (`res/values*/strings.xml`)
- `logcat_names_info` („Log file names”) i `logcat_locations_info` („Where to find the logs and crash reports”) to tytuły dwóch `Preference` w `res/xml/launcher_preferences.xml` ≈317–326. Nie mają dwukropka.
- `logcat_names_info_summary` (`values/strings.xml` ≈358) zawiera dwie linie, które się gryzą:
  - „start – started with the launcher after it restarted on its own (crash, update)”;
  - „crash – written when the launcher crashed …”.

  Wygląda to, jakby crash miał dwa pliki.
- **Jak jest naprawdę:**
  - `start_` = każde utworzenie głównego procesu z włączonym `logcat_service`, które nie jest pierwszym po bootcie (`ColdStart.java` ≈101, ≈171–190: uptime > 3 min albo ten sam `boot_id`) → `LogcatWorker.Trigger.PROCESS_START` (`LogcatWorker.java` ≈111–128, ≈364).
  - Scenariusze `start_`:
    - po crashu Javy (CrashLogger zabija proces, system wznawia HOME);
    - po aktualizacji: brak odbiornika `MY_PACKAGE_REPLACED`, ale PM zabija proces, a HOME startuje ponownie;
    - po zabiciu przez system (pamięć, ANR, crash natywny), po force stop;
    - po starcie procesu przez broadcast lub usługę widżetu.
  - `crash_pid_…` zapisuje **umierający** proces (`CrashLogger.java` ≈93–120).
  - W pętli crashy raport N zawiera „The previous run crashed” i „Opening log file: …/start_pid_…” (raport z 03-11 20:29:44).

  Obie linie są więc prawdziwe: `crash` to raport samej awarii, a `start` to log kolejnego uruchomienia.
- Komentarz nad stringami (`values/strings.xml` ≈354–356) mówi o „six words … reboot, start, wake, user, full and pid”. Słów jest siedem: brakuje `crash` (`LogFileName.CRASH_LABEL`).
- Pliki: każdy `strings.xml`, który ma te klucze. `rg -l 'name="logcat_names_info"' app/src/main/res` daje 59 plików, w tym `values-en-rGB`, `values-en-rIN`, `values-fr-rCA`, `values-zh-rHK`, `values-pt-rPT`, `values-es-rUS`, `values-et-rEE`, `values-ms-rMY`.

### 0.2 Numer ekranu powyżej liczby ekranów (`settings/WidgetPageManager.java`)
- Log właściciela:
  ```
  Current value: 6, page count: 5, highest index: 3 → New current value: 5 → saved pip_third_screen to page 5
  (13 ms później, drugie wywołanie) Current value: 5, page count: 5, highest index: 4 → saved to page 5
  Current value: 9, page count: 5, highest index: 4 → New current value: 6 → saved to page 6
  ```
- Przyczyna (≈76–79):
  ```java
  if (value > pageCount && value > highestIndex && pageCount >= highestIndex) value = highestIndex + 2;
  ```
  - `highestIndex` (≈380–394) to najwyższa strona (0-based) **elementów własnych** (włączone + ten edytowany), a nie stron launchera.
  - Gdy ostatnie strony mają tylko ikony lub widżety, wynik to „ostatnia strona z elementem + 1”. Bywa równy `pageCount` albo jest w środku.
  - Za drugim razem wynik „działa” tylko dlatego, że edytowany element sam stał się najwyższy.
  - Porównania mieszają 1-based z 0-based (`value > highestIndex`, `pageCount >= highestIndex`).
- `pageCount` = `Snapshot.pageCount()` (`WorkspaceScreenPlan.java` ≈193, strona użytkownika wliczona). W trakcie sesji ustawień się nie zmienia (snapshot publikuje tylko model: `LauncherModel` ≈1067, ≈1096, ≈2394).
- **Podwójny zapis:** w `CustomPipSwitchPreference` overlay IME (≈622–631) woła `saveScreenNumberFromInput()`, a potem `clearFocus()`. Focus listener (≈224–231) woła go drugi raz. Ten sam wzorzec jest w:
  - `CustomDualPipPreference` (≈414–449, overlay ≈494–503);
  - `CustomWidgetSwitchPreference` (≈392–427, ≈475);
  - `CustomWidgetPreference` (≈402–437, ≈485).
- Pole po zapisie pokazuje to, co zapisano (`saveScreenNumberFromInput` ≈572–576 czyta pref). Wyświetlanie jest więc poprawne: zła jest wartość.
- Reguła „element sam na ostatniej stronie” (≈84–106) i kompaktowanie luk (`applyAndRelocateWidgets` ≈116–189) zostają.
  - Przykład: element sam na stronie 5, wpisane 9 → cel 6 → luka na 5 → kompaktowanie wraca na 5, a listener odświeża pole.
  - To zamierzone: nie powstają puste strony.
- Testów `WidgetPageManager` nie ma (Android `SharedPreferences`).

### 0.3 Nachodzące elementy po zmianie numeru ekranu bez kreatora
- Log powrotu z ustawień (03-11 20:31:45; wcześniej `pip_third_screen` zmieniony z 5 na 4 w drugim ekranie ustawień):
  ```
  D Recreate page: Started (onResume pending)
  D Helpers : Bottom bar area 1080x2116, bar 151px from y=1965.0, left bar
  I Helpers : Rectangle music has no room beside the bars or the others, resetting it
  I Helpers : Rectangle music reset to 5,797,275,1121
  I Launcher.Model: Screen plan (load): order=[3, 4, 5] … pages={date=4, music=4, radio=4, dual=1, third=4, fourth=3, stats=1}
  I CellLayout: Custom elements on page 4 (screen 5): date [0,0 3x1], music [0,3 2x3], radio [1,0 3x2], third [0,1 4x4]
  ```
- Ścieżka:
  1. `Custom*Preference.saveScreenNumberFromInput()` → `WidgetPageManager` zapisuje tylko `*_screen`.
  2. Powrót do launchera: `Launcher.processPendingUpdateOnResume()` (≈2408) → `helpers.checkAndResetIfOverlappingOnScreen(-1)` (≈2434), **przed** restartem paneli i `recreateView()`.
  3. To samo przy Home w ustawieniach: `SettingsActivity` ≈453.
- `Helpers.checkAndResetIfOverlappingOnScreen()` (`settings/Helpers.java` ≈534–716):
  - grupuje elementy po stronie z prefów `*_screen`;
  - na każdej stronie woła czysty `settings/CustomLayoutResolver.resolve()`.
- `CustomLayoutResolver`:
  - **krok 1** `resetOverlapping` (≈131–144): dwa nachodzące lub stykające się prostokąty użytkownika → jeden **od razu reset**, bez przesunięcia i bez przycięcia. Widżet ustępuje PiP; przy równych przegrywa późniejszy klucz `RECTANGLE_KEYS`.
  - **krok 2** `resolveAxis` (≈157–236): przesuń → przytnij → pchnij łańcuch → reset. Działa tylko na stronie 0, bo tylko tam są limity pasków.
- **Błąd:** `env.grid` i `env.occupied` są ustawiane tylko na stronie 0 i tylko z paskiem (`Helpers` ≈633–658). `placeReset` (≈372–397) zaczyna od `if (!env.canMove()) return fallback;`.
  - Na każdej innej stronie zresetowany element trafia na **stałą domyślną pozycję** bez sprawdzenia elementów, które zostają, choć `resolution.obstacles` jest dla nich wypełnione.
  - Music zresetowane na `5,797,275,1121` nachodzi na third.
  - Reset zapisuje też `User*`, więc przy każdym powrocie to się powtarza.
- Log „has no room beside the bars or the others” (≈678) jest wypisywany przy każdym resecie, także zwykłego nakładania bez pasków.
- `Helpers.getEnabledStates()` (≈497–518) ma inne domyślne wartości niż to, co launcher rzeczywiście kładzie:
  - date/music/radio mają tu domyślnie `false`, a w `CustomElement` (`CustomElement.java` ≈15–23) `true`;
  - PiP wymagają tu `DISPLAY_PIP` z domyślnym `false`, a launcher pokazuje PiP z domyślnym `true` (`Launcher.java` ≈2430, `LauncherPipStarter` ≈42).

  Element nigdy nieprzełączony może więc leżeć na stronie, a Helpers go nie widzi.
- Linie „Custom elements on page …” są w komórkach. Elementy są rysowane w pikselach, a przerwa między komórkami należy do komórki wcześniej (`GridGeometry.cellsOf`). Nakładanie komórek w tym logu nie musi więc oznaczać nakładania w pikselach. **Strona 1 (screen -302):** `dual` i `stats` dzielą komórki celowo (stats jest `fixed`).
- `WindowUtil.onPipGeometryChanged()` (≈2567, tylko czyści cache bounds) jest wołane na resume tylko przy flagach `layoutTypeChanged`/`barSettingsChanged`/`userOpenedCreator` (`Launcher` ≈2442). Zmiana numeru strony nie ustawia żadnej z nich.
- Czyste i testowane klasy:
  - `CustomLayoutResolver` (`settings/CustomLayoutResolverTest`, `settings/ResetPlacementTest`);
  - `GridGeometry`, `WorkspaceOccupancy`, `PipEdgeTrim`, `WidgetMetrics`.
- `CustomLayoutDb.read()` (`CustomLayoutDb.java`) zwraca zajętość wszystkich stron ze snapshotu modelu, więc odczyt dla każdej strony nic nie kosztuje.

### 0.4 Start przeglądarki przy logowaniu Spotify
- Obserwacja właściciela (FYT, Android 10, launcher z `sharedUserId="android.uid.system"`, `app/src/fyt/AndroidManifest.xml`; Firefox):
  - zaraz po wyczyszczeniu danych i cache launchera tapnięcie „Zaloguj” uruchamiało Firefoksa: jego ikona pojawiła się na pasku FYT, który pokazuje aplikację na wierzchu tak, jak widzi ją com.syu.ms, czyli `getRunningTasks(1)` ze **wszystkich** ekranów;
  - na ekranie nic się nie pokazało, a ekran główny cały czas pokazywał ustawienia;
  - później, bez czyszczenia, działa.

  Loga nie ma.
- Kod: `settings/SpotifyRating.startLogin()` (≈342–403) to `ACTION_VIEW` + `CATEGORY_BROWSABLE` + `FLAG_ACTIVITY_NEW_TASK`, `context.startActivity(browser)` **bez `ActivityOptions`**. Wołane z `handlePreferenceClick()` (≈1134–1149) z `SettingsFragmentFirst` ≈773.
- **Hipoteza**, której nie da się potwierdzić bez logu:
  - Firefox (singleTask) miał już zadanie na innym ekranie niż domyślny, np. na wirtualnym ekranie panelu;
  - start z `NEW_TASK` użył tego zadania tam, gdzie było;
  - Firefox stał się więc „top” dla `getRunningTasks(1)`, ale nie dla ekranu głównego.

  `DefaultDisplayTask` (≈83 `displayId(task)`, ≈125 `topActivity(am)`, ≈176 `knowsDisplays()`) umie to odczytać z uprawnieniami systemowymi.
- `ActivityOptions.setLaunchDisplayId(Display.DEFAULT_DISPLAY)` (API 26, `minSdk` = 26) to udokumentowany sposób, żeby zażądać ekranu głównego. Start na ekranie domyślnym nie wymaga uprawnień.

## 1. Decyzje właściciela (nie zmieniaj ich)
1. Linia `start` zostaje z przykładem „(update, crash)” (jedno słowo na przykład). Linia `crash` mówi wprost, że to raport samej awarii, a dalszy przebieg jest w logu `start`. Oba tytuły kończą się dwukropkiem we wszystkich tłumaczeniach.
2. Wpisanie numeru większego niż liczba istniejących ekranów daje **zawsze** liczbę istniejących ekranów + 1. Reguła „bez pustych stron” (element sam na ostatniej stronie, kompaktowanie luk) zostaje bez zmian.
   - „Istniejące ekrany” to także te, które w tej samej sesji ustawień utworzył inny **włączony** element.
   - Użytkownik może dokładać nowe ekrany jeden po drugim. Przykład przy 3 istniejących ekranach:
     - music → 4: zapisuje się 4 i pole pokazuje 4;
     - potem PiP 1 → 5: zapisuje się 5, bo ekran 4 już tworzy music;
     - PiP 1 → 8: zmienia się na 5.
   - Element wyłączony nie tworzy ekranu (planer też go pomija), więc się nie liczy.
3. Gdy elementy własne (PiP, date/music/radio) nachodzą na siebie na **dowolnej** stronie, działa ten sam proces co przy paskach:
   - najpierw dopasowanie rozmiaru do wolnego miejsca (przycięcie, nie poniżej minimum);
   - potem przeniesienie w miejsce, gdzie się zmieści, w swoim rozmiarze;
   - w ostateczności reset rozmiaru i położenia (w wolne miejsce, a gdy go nie ma, na pozycję domyślną).

   Reguła „kto ustępuje” bez zmian: widżet ustępuje PiP, przy równych późniejszy klucz.
4. Spotify: tylko hardening startu przeglądarki i diagnostyka w logu. **Żadnych nowych toastów, dialogów ani innych widocznych promptów.** Istniejący toast `spotify_opening_browser` zostaje.
5. Kreator (`Creator*`, `DrawView*`) bez zmian.

## 2. Zasady pracy i konwencje repo
- **Komentarze, Javadoc, `Log.*` i opisy commitów wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, wyjaśniają *dlaczego*.
- **Commity:**
  - temat `<Obszar>: <co>` (tematy przy krokach), treść zawinięta na ~72 znaki, w treści fakty z §0;
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push** po każdym commicie: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
  - Przed następnym commitem poczekaj na wynik CI: `.github/workflows/build.yml`, czyli `:app:testFytDebugUnitTest`, `:app:assembleFytDebug`, `:app:assembleStandardDebug`.
  - Workflow ma `cancel-in-progress`, więc sprawdzaj run **ostatniego** commita przez GitHub MCP `actions_list`/`get_job_logs`.
  - Czerwony build naprawiaj kolejnym commitem, bez amend i force-push.
- **Testy JVM:** JUnit 5 (`app/src/test/java/…`), `unitTests.isReturnDefaultValues = true`. Logikę decyzyjną wydzielaj do czystych klas bez `android.*` i ją testuj.
- **StrictMode** jest włączony: w nowym kodzie żadnego I/O, zapytań do DB ani `getRunningTasks` na wątku głównym. Pojedyncze `resolveActivity`/`queryIntentActivities` przy kliknięciu są dozwolone.
- **Bez nowych zależności, bez zmiany schematu DB, bez migracji prefów.** Nowe stringi: żadnych. C1 zmienia tylko istniejące.
- **Usuwaj dopiero po `rg`** w całym `app/src` (`--glob '!**/generated/**'`).
- **Nie usuwaj istniejących testów.** Jeśli zmiana zachowania je łamie, dostosuj dane wejściowe tak, żeby zachowały swój zamiar, i dopisz nowe.

## C1 — `Logs: colons after the legend titles, the start and crash lines agree`

### C1.1 Dwukropki w tytułach
- W każdym z 59 plików dopisz znak dwukropka na końcu `logcat_names_info` i `logcat_locations_info`, w formie, jakiej ten język już używa (sprawdzone na `stats_dialog_title`/`fuel_code_text`):

  | locale | końcówka |
  |---|---|
  | wszystkie poza poniższymi (także `ja`, `ko`, `ar`, `fa`, `hi`, `th`, `lo-rLA`, `ka-rGE`, `mn-rMN`, `el`, `ru`…) | `:` bez spacji |
  | `fr`, `fr-rCA` | ` :` (spacja przed, jak `fuel_code_text` w `values-fr`) |
  | `zh-rCN`, `zh-rTW`, `zh-rHK` | `：` (pełna szerokość) |
  | `am` | `፦` |
  | `km-rKH` | `៖` |
  | `hy-rAM` | `՝` |

- EN: „Log file names:”, „Where to find the logs and crash reports:”. PL: „Nazwy plików logów:”, „Gdzie szukać logów i raportów crashy:”.

### C1.2 Linie `start` i `crash` w `logcat_names_info_summary`
- EN (`values`, `values-en-rGB`, `values-en-rIN`; zachowaj cudzysłowy, jakich używa dany plik):
  - `start – started with the launcher when it started again without a device restart (update, crash)`
  - `crash – written the moment the launcher crashed: the error and the last log lines (what follows the restart is in the start log)`
- PL:
  - `start – uruchomiony wraz z launcherem, gdy ten uruchomił się ponownie bez restartu urządzenia (aktualizacja, awaria)`
  - `crash – zapisany w chwili awarii launchera: błąd i ostatnie linie logu (to, co działo się po restarcie, jest w logu start)`
- Pozostałe języki: przetłumacz te dwie linie tak samo:
  - słowa-etykiety `reboot/start/wake/user/full/pid/crash` i słowo „start” w nawiasie końcowym **zostają nieprzetłumaczone**;
  - zachowaj myślnik ` – `, separatory `\n`, escapowanie (`\'`, `\"`) i styl cudzysłowów pliku;
  - przykłady w nawiasie to dwa słowa w kolejności „aktualizacja, awaria”, w terminologii, której plik już używa w tej linii.
- Pozostałych linii legendy nie zmieniaj.
- Komentarz w `values/strings.xml` ≈354–356: „The seven words reboot, start, wake, user, full, pid and crash …” (crash = `LogFileName.CRASH_LABEL`).

## C2 — `Settings: a screen number past the last page always gives a new page`

### C2.1 Czysta reguła
- Nowa klasa `settings/ScreenNumberRule.java` (bez `android.*`):
  ```java
  /** 1-based pages. highestOtherPage: highest page of the other elements that are on, 0 if none. */
  static int target(int typed, int pageCount, int highestOtherPage) {
      int lastPage = Math.max(pageCount, highestOtherPage);
      return typed > lastPage ? lastPage + 1 : typed;
  }
  ```
  W Javadoc wyjaśnij, po co `max`:
  - snapshot się w sesji ustawień nie zmienia;
  - włączony element przeniesiony wcześniej w tej samej sesji poza ostatnią stronę tworzy ekran, którego snapshot jeszcze nie zna;
  - dzięki temu kolejne nowe ekrany dokłada się jeden po drugim (decyzja 2).
- Test `settings/ScreenNumberRuleTest.java`:
  - przypadki z logu: `(6,5,4)→6`, `(9,5,4)→6`;
  - `(99,5,0)→6`;
  - `(3,5,4)→3`;
  - `(6,5,4)→6` (już równa +1);
  - inny element za snapshotem: `(9,5,6)→7`;
  - wartość między `pageCount` a `highestOtherPage`: `(6,5,7)→6`.
  - Przykład właściciela (3 ekrany, pozostałe elementy najwyżej na 3), osobne testy:
    - `musicOnTheFirstNewPageIsKept`: `(4,3,3)→4`;
    - `aPipRightAfterItIsKept`: `(5,3,4)→5`, bo music jest już na 4;
    - `aPipFurtherOutComesRightAfterIt`: `(8,3,4)→5`.

### C2.2 `WidgetPageManager.validateAndSavePage()`
- Zamień ≈76–79 na `value = ScreenNumberRule.target(value, pageCount, getHighestOtherPage())`. Nowa prywatna `getHighestOtherPage()` (1-based) to jak `getHighestPageIndex()`, ale bez `mWidgetKey`: najwyższa strona pozostałych **włączonych** elementów, 0 gdy ich brak.
- Sprawdź na przykładzie z decyzji 2, że `applyAndRelocateWidgets` nie widzi luki. Ekran 4 z music jest w `widgetPositions`, bo music jest włączony. PiP 1 na 5 zostaje więc na 5, a nie wraca na 4. Jeśli jednak wraca, popraw tak, żeby przykład przeszedł, i opisz to w raporcie.
- `Log.i(TAG, "New current value: …")` tylko, gdy wartość się zmieniła. W logu „Current value…” dopisz `highest other page`.
- Jeśli `getHighestPageIndex()` przestanie być używane, usuń je po `rg`.
- Reguła „alone on page” (≈84–106) i `applyAndRelocateWidgets` bez zmian.

### C2.3 Bez podwójnego zapisu
- We wszystkich czterech `saveScreenNumberFromInput()` (§0.2), po `if (mPageManager == null) return;`, wróć bez niczego, gdy `value == mPageManager.getCurrentWidgetPageIndex() + 1`. Komentarz: overlay IME i utrata fokusu zapisują tę samą wartość dwa razy.
- Listenerów i overlayów nie ruszaj.

## C3 — `Layout: overlapping elements are cut, moved or reset on every page`

### C3.1 `CustomLayoutResolver`: krok 1 dopasowuje, zamiast od razu resetować
- `resetOverlapping` → `fitOverlapping(els, r, reset, env)`:
  - kolejność jak podana (kolejność `RECTANGLE_KEYS`: PiP przed widżetami, wcześniejszy klucz wygrywa), czyli ta sama reguła „kto ustępuje”;
  - lista `kept`, element `fixed` (stats) pomijany jak dziś (może nachodzić, nie jest konfliktem);
  - dla każdego niezresetowanego elementu: `conflicts` = elementy z `kept`, z którymi `overlapsOrTouches`:
    - brak → do `kept`;
    - jest → `int[] cut = cutAway(r[e], kept-rects, minW, minH, env.gap())`:
      - nie `null` → `r[e] = cut`, `cut[e] = true`, do `kept`;
      - inaczej `reset[e] = true`, a dalej jak dziś: Helpers → `placeReset`, czyli najpierw własny rozmiar w wolnym miejscu (= przeniesienie), potem rozmiar resetu, na końcu pozycja domyślna.
- `cutAway(rect, obstacles, minW, minH, gap)`:
  - szuka największego (pole) prostokąta zawartego w `rect`, który ma co najmniej `gap` odstępu od **każdej** przeszkody z `kept`;
  - krawędzie kandydatów: `left ∈ {rect.left} ∪ {o.right+gap}`, `right ∈ {rect.right} ∪ {o.left−gap}`, analogicznie `top`/`bottom`; pełne przejrzenie kombinacji (≤ 9 elementów, tanio);
  - minimum jak w `minLength`: `min(el.minWidth, szerokość)` i `min(el.minHeight, wysokość)`;
  - remis: mniejszy `left`, potem mniejszy `top`;
  - wynik jest podzbiorem dotychczasowych komórek, więc komórek bazy nie trzeba sprawdzać (launcher i tak przesuwa ikony spod elementu, ≈277–280).
- Przycięcie jest **wyprowadzane** z prostokątów użytkownika (`User*` się nie zmienia, Helpers zapisuje tylko rogi). Dlatego jest odwracalne i idempotentne: Home w ustawieniach i resume launchera dają ten sam wynik. Reset nadal zapisuje `User*` (świadome przeniesienie, jak dziś).
- `Result` dostaje `boolean[] cut` i `int[] conflictWith` (indeks zwycięzcy albo -1), do logów.
- Javadoc klasy: zaktualizuj opis kroku 1.

### C3.2 `placeReset` bez znanej siatki
- Gdy `!env.canMove()`, nie zwracaj od razu fallbacku:
  - `fits()` sprawdza granice i przeszkody, a komórki bazy pomija, gdy `env.grid == null`;
  - `candidates()` bez linii siatki;
  - pozycja domyślna nadal jest pierwszym kandydatem i ostatecznym fallbackiem.
- `resolveAxis` dalej używa `canMove()` (bez siatki nie przesuwa).

### C3.3 `Helpers.checkAndResetIfOverlappingOnScreen()`
- Zajętość czytaj raz (`CustomLayoutDb.read`, jak dziś), gdy jest `GridGeometry.published()`, i ustawiaj `env.grid`/`env.occupied = occupancy.page(screen)` na **każdej** stronie z elementami, nie tylko na 0 z paskiem. `env.leftBarOffset` tylko na stronie 0 z lewym paskiem (jak dziś). Komentarz przy ≈583 popraw.
- `getEnabledStates()`: element się liczy, gdy launcher go pokazuje.
  - Widżety: `prefs.getBoolean(e.enabledKey, e.defaultEnabled)` z `CustomElement`.
  - PiP: to samo i `DISPLAY_PIP` z domyślnym `true`; wzajemne wykluczenia dual/first/second zostają.
  - Wydziel `CustomElementPrefs.isShown(SharedPreferences, CustomElement)` i użyj go tutaj.
  - Sprawdź w `CellLayout.placeAssignedElements()`/`addPipPlaceholder()` i w `WindowUtil`, że to ta sama reguła. Jeśli nie, wypisz różnice w raporcie.
- Logi:
  - zamiast jednego „has no room beside the bars or the others” trzy warianty:
    - `Rectangle X overlaps Y, cut to l,t,r,b`;
    - `Rectangle X overlaps Y and cannot be cut, placing it elsewhere`;
    - `Rectangle X has no room beside the bars, resetting it` (gdy reset wymusił krok 2);
  - w `placeResetsInFreeSpace` dopisz, czy wyszło `own size`, `reset size` czy `default, nothing free`;
  - na końcu jedna linia `Log.d` na stronę: `Layout of page N: key l,t,r,b[ (cut|moved|reset)]; …`.
- Zwracana wartość bez zmian (`foundOverlap || changedAny`); przycięcie liczy się jako zmiana.

### C3.4 Launcher na resume
- `Launcher.processPendingUpdateOnResume()` ≈2434: `boolean layoutChanged = helpers.checkAndResetIfOverlappingOnScreen(-1);` i dopisz `|| layoutChanged` do warunku `onPipGeometryChanged()` (≈2442), żeby panele dostały nowe rogi po samej zmianie numeru strony. Komentarz po angielsku.

### C3.5 Testy
- `CustomLayoutResolverTest`:
  - `aWidgetOverlappingAPipIsReset`, `ofTwoWidgetsTheLaterOneIsReset`, `onlyOneOfTwoOverlappingElementsIsReset`: dostosuj dane tak, żeby przycięcie łamało minimum (zamiar „reset” zostaje), a nazwy uzupełnij o „…WhenItCannotBeCut”;
  - nowe:
    - `aWidgetOverlappingAPipIsCutBesideIt`;
    - `theCutKeepsTheGapToEveryKeptElement`;
    - `theCutKeepsTheLargestFreePart`;
    - `aCutNeverGoesBelowTheMinimum`;
    - `theSameInputGivesTheSameCut`;
    - `theStatsWindowIsNoConflict`.
- `ResetPlacementTest`:
  - `withoutAKnownGridTheDefaultIsKept` ma przejść bez zmian (przeszkoda pokrywa wszystko);
  - nowe: `withoutAKnownGridTheObstaclesAreStillAvoided` oraz `onAPageWithoutBarsTheResetGoesBesideThePip` (schemat logu: music 270×324 nachodzi na PiP third; wynik nie nachodzi na third, date ani radio).

## C4 — `Spotify: the sign-in page opens on the main display`

### C4.1 `SpotifyRating.startLogin()`
- Po zbudowaniu `browser`:
  - `pm.resolveActivity(browser, MATCH_DEFAULT_ONLY)` i `queryIntentActivities(…)`:
    - konkretna przeglądarka (nie `ResolverActivity` z pakietu `android`) → `browser.setPackage(pkg)`;
    - dokładnie jedna obsługująca → `setPackage`;
    - inaczej zostaw niejawny (systemowy wybór jak dziś).
  - Jedna linia `Log.i`: domyślna, liczba obsługujących, `hasSystemPrivileges()`, SDK.
- `context.startActivity(browser, ActivityOptions.makeBasic().setLaunchDisplayId(Display.DEFAULT_DISPLAY).toBundle())`. Komentarz po angielsku z §0.4 (zadanie przeglądarki na innym ekranie, obserwacja po wyczyszczeniu danych na FYT).
- Obsługa `ActivityNotFoundException` bez zmian. Dodatkowo `SecurityException` → `Log.w` i ponowienie bez opcji.

### C4.2 Kontrola po starcie (tylko log + jedno ponowienie, nic widocznego)
- Tylko gdy `LauncherApplication.hasSystemPrivileges() && DefaultDisplayTask.knowsDisplays()`. Inaczej `Log.d` „task stack not visible, check skipped”.
- Na wątku tła (`new Thread(…, "SpotifyBrowserCheck")`, application context), po 1500 ms:
  - zadanie przeglądarki (`getRunningTasks(16)`, pakiet `topActivity`/`baseActivity` == pkg) i jego `DefaultDisplayTask.displayId`;
  - `DefaultDisplayTask.topActivity(am)`.
  - Jedna linia `Log.i`: `Spotify browser check: <pkg> task <id> on display <d>, main display shows <top>`.
- Jeśli zadanie przeglądarki jest na ekranie ≠ domyślny, a ekran główny pokazuje nasz pakiet:
  - jedno ponowienie `appContext.startActivity(kopia intentu z FLAG_ACTIVITY_NEW_TASK, te same opcje)`; ten sam URI, verifier i state się nie zmieniają;
  - `Log.w` „…started again on the main display”;
  - po kolejnych 1500 ms jedna linia z wynikiem.
- Wszystko w `try/catch (RuntimeException)` z `Log.w`, bo wyjątek z wątku zamknąłby launcher (CrashLogger).

## 3. Czego NIE zmieniać
- Kreatora (`Creator*`, `DrawView*`, `RectangleTouchHelper`) i `SettingsFragmentSecond`.
- `resolveAxis` (logika pasków), reguły „kto ustępuje”, `WorkspaceScreenPlan`, kompaktowania stron w `WidgetPageManager`.
- Przepływu PKCE i callbacku (`SpotifyAuthCallbackActivity`), istniejących toastów Spotify.
- Pozostałych linii legendy logów i `LogcatWorker`/`LogFileName`.

## 4. Weryfikacja
1. Po każdym commicie CI zielone.
2. `rg` (`--glob '!**/generated/**'`):
   - `highestIndex \+ 2` → brak;
   - `rg -c 'name="logcat_(names|locations)_info">[^<]*[:：፦៖՝]</string>' app/src/main/res` → 59 plików × 2;
   - `has no room beside the bars or the others` → brak;
   - `setLaunchDisplayId` → `SpotifyRating`.
3. Scenariusze dla właściciela (wypisz je w raporcie):
   - a) Ustawienia → Logcat: oba tytuły z dwukropkiem (sprawdź PL, FR, ZH); linie `start`/`crash` zgodne.
   - b) 5 ekranów, wpisz 9 dla dowolnego PiP lub widżetu:
     - pole pokazuje 6 za pierwszym razem;
     - `WidgetPageManager: … New current value: 6` i jedno wywołanie (brak drugiego po 13 ms);
     - element sam na ostatniej stronie: pole wraca na ten sam numer.
   - b2) 3 ekrany, bez wychodzenia z ustawień:
     - music → 4: pole 4;
     - PiP 1 → 5: pole 5;
     - PiP 1 → 8: pole 5;
     - po powrocie do launchera są ekrany 4 (music) i 5 (PiP 1).
   - c) Bez kreatora przenieś PiP third na stronę z music/date/radio i wróć do launchera:
     - brak nakładania w pikselach;
     - linie `Rectangle … overlaps …` i `Layout of page N: …`;
     - drugi powrót bez zmian (te same linie, bez nowego „reset”).
   - d) Przenieś third z powrotem: przycięty widżet wraca do swojego rozmiaru.
   - e) FYT: logowanie Spotify:
     - linia z rozwiązaną przeglądarką;
     - `Spotify browser check: … on display 0`;
     - Firefox na ekranie.

     Jeśli objaw wróci (np. po wyczyszczeniu danych), właściciel daje log z linią `browser check`.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash + temat) i wynik CI każdego.
- Różnice reguły „pokazany” między Helpers, `CellLayout`/`WindowUtil` i kreatorem (C3.3).
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z pkt 4.3 z tym, czego właściciel ma szukać w logu.
