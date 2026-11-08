# Launcher Mod: ładowanie, które przestaje wiązać, kolory i tło widżetów, prostokąty stykające się w kreatorze — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `f791b67e`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

## 0. Commity (w tej kolejności)

| # | Temat commita | Źródło |
|---|---|---|
| G1 | `Workspace load: a load that stops binding is started again, and a skipped reload is not lost` | log właściciela |
| G2 | `Widgets: colors and backgrounds follow the settings on the widgets already shown` | właściciel, log |
| G3 | `Creators: touching rectangles do not overlap, and overlapping ones are fitted the way the bars fit them` | właściciel |

**Każdy commit buduje się samodzielnie i przechodzi testy.** Po każdym pushu poczekaj na zielone CI, zanim zaczniesz następny.

## 1. Zasady pracy

**Język i treść:**
- Komentarze, Javadoc, `Log.*` i opisy commitów piszesz **wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, które wyjaśniają *dlaczego*.
- **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.

**Commity:**
- Tematy z tabeli §0. Treść zawijaj na ~72 znaki i wpisz do niej fakty z §2 dotyczące danego commita.
- Zakończ każdy commit dokładnie trailerami z system-remindera sesji.
- Push: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy, z odstępem 2/4/8/16 s.

**CI:**
- Workflow to `.github/workflows/build.yml`. Sprawdzaj run commita przez GitHub MCP (`actions_list`, `get_job_logs`).
- Czerwony build naprawiasz kolejnym commitem. Bez amend i bez force-push.
- Przed każdym pushem uruchom lokalnie `./gradlew :app:testSystemDebugUnitTest`.

**StrictMode jest włączony i nie może zgłaszać naruszeń.** Na wątku głównym nie wolno robić:
- I/O (`SharedPreferences.commit()` → `apply()`);
- operacji na bazie, wywołań `ContentResolver` ani dostępu do sieci;
- wywołań `su` ani blokujących wywołań hosta VD.

`Thread.getStackTrace()` innego wątku jest dozwolone.

**Testy:** JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `CustomLayoutResolverTest`, `StatsBarFitTest`, `CreatorPageTest`. Logikę pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:**
- Bez nowych zależności. `androidx.core` (`ViewCompat`, `ImageViewCompat`) już jest.
- Nowe stringi tylko dwa, z G3, **we wszystkich 59 plikach `res/values*/strings.xml`**.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/`.

**Reguły, które wprowadzają te commity.** Zapisz je w Javadoc klas, które je egzekwują, żeby obowiązywały w przyszłości:
- **R1 (G1).** Stan „trwa ładowanie” należy do modelu.
  - Launcher ustawia i zdejmuje swoją flagę w jednym miejscu.
  - Ładowanie, które utknęło, jest uruchamiane ponownie, a nie tylko zwalniane.
  - Pominięte żądanie przeładowania nie przepada.
  - Każde zatrzymanie ładowania podaje powód w logu.
- **R2 (G2).** Ustawienie wyglądu (kolor tekstu i przycisków, tło) działa na widokach, które już są na ekranie, przez jedno miejsce w kodzie.
  - Nie zależy od pełnej przebudowy ekranu.
  - Kolor ustawia się w obie strony.
  - Żaden kod nie zmienia filtra koloru na drawable z zasobów (jego stan jest współdzielony). Kolor jest właściwością widoku (tint widoku).
- **R3 (G3).** Jedna reguła nachodzenia elementów na siebie, dla kreatora i dla `Helpers`.
  - Stykanie się krawędziami albo rogami to nie nachodzenie.
  - Dotknięcie paska nadal liczy się jako kolizja, bez zmian.

## 2. Fakty

### 2.1 Przegląd rundy 11 (`fc5cac17`, `76c1c110`, `f791b67e`)
- CI jest zielone, a właściciel potwierdza, że zmiany działają.
- Do poprawy są tylko pozostałości po F3 w komentarzach `settings/CustomLayoutResolver`, które nadal mówią o oknie statystyk jako przeszkodzie (≈47, ≈180, ≈489). Poprawiasz je w G3.

### 2.2 Ładowanie z bazy, które nie wykonało żadnego kroku (log 08-11 15:03)
**Przebieg z logu:**
- **15:03:18.236** — ustawienia zapisują `updateOnce=53031187`, czyli czas działania w ms.
- **15:03:18.321** — `CAS attempt: true, prev: 53005708`. Poprzedni powrót z ustawień był więc ≈25,5 s wcześniej, o **≈15:02:52.8**.
- **15:03:18.323** — `recreateView: loader already in flight, skipping forceReload()`.
  - Próg `FORCE_RELOAD_THROTTLE_MS = 1500` (`Launcher` ≈598) nie wchodzi w grę, więc `mWorkspaceLoading` było `true`.
  - Nie ma `Starting workspace loader from onResumeNeedsLoad`, więc `mOnResumeNeedsLoad` było `false`. Ładowanie z 15:02:52.8 nie zostało odłożone przez `setLoadOnResume()` (≈8061): `LoaderTask` trafił na `sWorker` (`LauncherModel.startLoader` ≈1302–1330).
- **15:03:22.821** — `Workspace loading made no progress for 30000 ms, the bind never finished: releasing the loading state`. To dokładnie 30,0 s po uzbrojeniu watchdoga w `recreateView` poprzedniego powrotu (≈2687).
  - Przez te 30 s nie było żadnego `startBinding` (uzbraja watchdoga, ≈8087), żadnego `bindScreens`, `bindItems` ani `bindAppWidget` (`noteWorkspaceBindProgress`, ≈8120/8204/8372/8444) i żadnego `finishBindingItems` (≈8597).
- **Po zwolnieniu:**
  - watchdog woła tylko `placeCustomElements` i `onWorkspaceLoadFinished` (≈1421–1442);
  - nic nie ładuje bazy ponownie, więc ikony i widżety z bazy nie wracają do restartu.
- **Ograniczenie logu:** zaczyna się o 15:03:07, 14 s po starcie ładowania. Nie pokazuje, gdzie ono stanęło.

**Gdzie w kodzie ładowanie może zgasnąć bez śladu:**
- `LoaderTask.tryGetCallbacks` (≈1744–1765) zwraca `null` po `stopLocked()` albo przy innym obiekcie callbacks. Każdy krok wiązania w kolejce (`startBinding`, `bindScreens`, `bindItems`, `finishBindingItems`, ≈2548–2807) przepada wtedy bez logu.
- `loadAndBindWorkspace` (≈1531–1553) wraca przed `bindWorkspace`, gdy zadanie zatrzymano.
- `LoaderTask` czeka za każdą inną pracą na jedynym wątku `sWorker`: zapisami do bazy z `runOnWorkerThread`, `PackageUpdatedTask`, krokiem 2 poprzedniego zadania.
- **Kto zatrzymuje ładowanie:**
  - `stopLoaderLocked` (≈1290) w `startLoader`, gdy zastępuje je nowe zadanie;
  - `resetLoadedState` (≈1258), wołane przez `forceReload` (≈1250), obserwatora `Favorites` w `LauncherAppState` (≈33–38) i broadcasty pakietów;
  - `stopLoader()` w `onDestroy` (≈3152/3160).
- **Logi ładowania** są tylko przy `DEBUG_LOADERS` (eng/userdebug, ≈68), więc na buildzie user log nic o ładowaniu nie mówi.

**Flaga po stronie launchera:**
- `mWorkspaceLoading` jest własną flagą launchera. Ustawiają ją `recreateView` (≈2687), `requestWorkspaceLoader` (≈1454) i `startBinding` (≈8087), a zdejmują `finishBindingItems` (≈8597) i watchdog (≈1439).
- `recreateView` (≈2676–2679) pomija `forceReload`, gdy flaga jest ustawiona:
  - nie pyta modelu, czy jakieś ładowanie naprawdę trwa;
  - nie zapamiętuje pominiętego żądania.

### 2.3 Kolor tekstu i przycisków widżetów oraz ich tło
**Ustawienia:**
- „Widget text and button color” to `Keys.BLACK_WIDGETS` (`SettingsFragmentSecond` ≈364).
- „Choose background for widgets” otwiera `BackgroundSelectorDialog`, który zapisuje `Keys.WIDGETS_SELECTED_BACKGROUND` (≈600).

**Gdzie się je stosuje:**
- **Data i dzień tygodnia** (`com/fyt/widget/Date`, `WeekDay`) słuchają zmian ustawienia i ustawiają czarny albo domyślny kolor, na żywo. To działa.
- **`DigitClock`:**
  - czyta `BLACK_WIDGETS` raz, w konstruktorze (≈84);
  - co sekundę nakłada albo zdejmuje filtr na `getBackground()` cyfr bez `mutate()` (≈110–119, ≈270/276).
- **Widżet muzyki** (`LauncherMusicWidget`):
  - `setWidgetButtonsTint` (≈1665–1672) i `setBarButtonsTint` (≈1654–1662) tylko **nakładają** czarny przez `Helpers.applyColorFilterToButton` (≈1478) i nigdy go nie zdejmują;
  - są wołane przy inicjalizacji (≈1205–1209: play/pause, poprzedni, następny) i przy każdej zmianie stanu favorite (`setFavoriteButtonBackground` ≈1430–1442, za każdym razem nowy drawable z `SkinUtils.getDrawable`);
  - pasek postępu dostaje kolor tylko przy inicjalizacji (≈1223–1231);
  - teksty: `CellLayout.setCalculatedTextColor` (≈4539, wołane ≈4031, ≈4050) tylko ustawia czarny przy umieszczaniu.
- **Widżet radia** (`LauncherRadioWidget`):
  - poprzedni i następny dostają kolor przez `setWidgetButtonsTint` (≈132–135);
  - przycisk pauzy zmienia tło przy kliknięciu bez koloru (≈172–175);
  - przycisk pasma (`radio_btn_band`) nie dostaje go wcale.
- **Tło** ustawia się tylko przy tworzeniu widoku:
  - `CellLayout.placeCustomWidget` (≈3954) i zastępniki PiP (≈4241);
  - przy `"bg_custom"` nie ustawia się nic, zostaje domyślne `@drawable/bg_custom` z układu.

**Dlaczego filtr zmienia też inne przyciski:**
- `Helpers.applyColorFilterToButton`, `applyColorFilterToImageView` i `removeColorFilterFromImageView` (≈1478–1498) wołają `setColorFilter` / `clearColorFilter` na drawable **bez `mutate()`**.
- Drawable z zasobów dzielą `ConstantState`. `BitmapDrawable` trzyma `Paint` z filtrem w stanie, a selektor `btn_ic_favorite.xml` w swoich dzieciach.
- Filtr nałożony na jeden przycisk trafia więc na każdy drawable tego zasobu w procesie: na inne przyciski widżetów, na przyciski paska (`BLACK_BAR`, `Workspace` ≈935/1868/2012/2894, `VerticalBarWindow` ≈190) i na każdy późniejszy `getDrawable()`. Znika dopiero, gdy cache go zwolni albo proces wystartuje od nowa.
- **To tłumaczy objawy:**
  - favorite zostaje czarny po powrocie na biały: nowy drawable ma współdzielony stan, a koloru nikt nie zdejmuje;
  - kolor zmieniają tylko niektóre przyciski: te, których kod uruchamia się ponownie, czyli favorite przy odświeżeniu stanu;
  - po restarcie wszystko działa.

**Zależność od przebudowy:**
- Kolory i tło przychodzą tylko z nowymi widokami, czyli z pełnej przebudowy po ustawieniach (`recreateView` → `forceReload` → bind → `placeCustomElements`).
- O 15:03:18 przebudowa została pominięta (§2.2). Widżety na stronie siatki zostały tymi samymi widokami: ze starym tłem i starym kolorem.
- Pasek przebudował się (`createUserPage` 15:03:18.363).

**`BackgroundSelectorDialog`:**
- Statyczne `backgrounds`, `name`, `key` i `defaultBackground` (≈63–66) są zapisywane na `loaderExecutor` (≈88–100), a czytane na wątku głównym przy kliknięciu karty (≈600).
- Klucz, pod którym zapisuje się wybór, zależy od ostatniego wywołania któregokolwiek z trzech selektorów, bez synchronizacji.

**Uprawnienia:** `SecurityException` przy odczycie tapety (log 15:03:12) to brak `READ_EXTERNAL_STORAGE` na Androidzie 16. Kolory zastępcze są zastosowane poprawnie, to nie błąd.

### 2.4 Kreator: prostokąty, które się stykają
**Dwie reguły dla tego samego** (`settings/DrawViewScreen`):
- czerwone podświetlenie (≈679–695) używa `RectF.intersects`, czyli ściśle: wspólna krawędź to nie nachodzenie;
- sprawdzenie przed zapisem `hasAnyIntersection` (≈1388–1416) używa `overlapsOrTouches` (≈1419–1422), czyli włącznie: wspólna krawędź to nachodzenie.

Stąd przypadek właściciela: lewa krawędź A i prawa krawędź B na 348 nie świecą na czerwono (dobrze), a zapis pokazuje dialog (źle). Ta sama para reguł jest w `settings/DrawViewAppStats` (≈370 / ≈903–936).

**Krok 1 resolvera** (`CustomLayoutResolver.fitOverlapping`, ≈175–212):
- używa `overlapsOrTouches` (≈281);
- dla stykających się prostokątów użytkownika przycina ustępujący do odstępu `max(margin, 1)` od drugiego (`cutAway` ≈229) albo go resetuje;
- nawet zapisane stykające się prostokąty zostałyby więc przycięte przy następnym przebiegu `Helpers`.

**Kolejność w kroku 1:** przycięcie, a potem reset, bez przesuwania. Paski (krok 2, `resolveAxis`; Javadoc klasy ≈16–25) robią po kolei:
1. przesunięcie w wolne miejsce;
2. przycięcie;
3. łańcuch przesunięć;
4. reset, z umieszczeniem przez `placeReset` (≈500).

**Dialog** `displayDialog` (≈1246–1271):
- tytuł `overlapping`, treść `wont_save` („The current layout will not be saved. Proceeding will reset the layout.”);
- przycisk `proceed_and_reset` woła `helpers.checkAndResetIfOverlappingOnScreen(-1)` **bez `savePrefs()`**. To, co narysowano, przepada, a stary zapisany układ jest dopasowywany od nowa. Potem kreator przechodzi do `SettingsFragmentSecond`;
- dialog pokazują `confirm_layout` (≈1008–1010) i klawisz wstecz (≈1214–1218).

**Na ekranie głównym** elementy stykające się ze sobą nie przeszkadzają: `CellLayout.handleConflictingViews` przesuwa tylko elementy launchera, nie elementy niestandardowe. Dotknięcie paska jest kolizją i tak zostaje (`PipEdgeTrimTest` ≈48, `StatsBarFit`).

---

## G1 — `Workspace load: a load that stops binding is started again, and a skipped reload is not lost`
1. **Numer i stan ładowania w modelu.**
   - `LauncherModel` nadaje każdemu `LoaderTask` rosnący numer i udostępnia `loadSnapshot()` z polami:
     - `loadId`;
     - czy zadanie istnieje, czy jest zatrzymane i czy działa (`mIsLoaderTaskRunning`);
     - `mWorkspaceLoaded` i `mAllAppsLoaded`;
     - liczbę kroków wiązania w kolejce `DeferredHandler`. Dodaj licznik, jeśli go nie ma.
   - Odczyt odbywa się pod `mLock`, bez I/O.
2. **Logi ładowania zawsze, nie tylko przy `DEBUG_LOADERS`** (`Log.i`, najwyżej ~5 linii na ładowanie):
   - `Loader <id> started (<reason>)`;
   - `Loader <id> workspace loaded: <n> items, <m> widgets in <ms> ms`;
   - `Loader <id> bind started`, `Loader <id> bind finished in <ms> ms`;
   - `Loader <id> stopped by <reason>`: każdy wołający `stopLoaderLocked` / `resetLoadedState` / `stopLoader` podaje krótki powód, np. `forceReload`, `favorites changed`, `package update`, `destroy`;
   - `Loader <id> dropped <k> bind steps (<stopped|other launcher>)`: raz na zadanie, licznik w `tryGetCallbacks`.
3. **Czysta klasa `WorkspaceLoadWatch`** podejmuje decyzję, gdy watchdog się odpala. Dostaje snapshot, liczbę dotychczasowych restartów i liczbę dodatkowych oczekiwań, a zwraca:
   - `WAIT_MORE`, gdy zadanie istnieje, nie jest zatrzymane i działa albo ma kroki w kolejce. Najwyżej jedno dodatkowe oczekiwanie na powrót do launchera;
   - `RESTART`, gdy nie ma żywego zadania, jest zatrzymane albo nie ma kroków i nic nie działa. Także po wyczerpaniu `WAIT_MORE`;
   - `RELEASE` po 2 restartach dla tego samego powrotu, czyli zachowanie dzisiejsze.

   Test `WorkspaceLoadWatchTest` obejmuje każdą gałąź.
4. **Watchdog** (`Launcher` ≈1421–1442):
   - przed decyzją jeden `Log.w` ze snapshotem i z 8 górnymi ramkami stosu `sWorker` (`getStackTrace()` wątku workera);
   - **RESTART:**
     - log `Workspace load <id> made no progress for 30000 ms, starting it again`;
     - jedna metoda `restartWorkspaceLoad(reason)`: `resetLoadedState(false, true)` + `startLoader(true, -1)`, z flagą i watchdogiem. Bez ładowania wszystkich aplikacji od nowa, jeśli są już załadowane;
   - **WAIT_MORE:** ponowne uzbrojenie, log `… still running on the worker thread, waiting`;
   - **RELEASE:** to, co dziś, plus `Log.e` ze snapshotem.
5. **`recreateView`** (≈2676–2690):
   - pomija `forceReload` tylko wtedy, gdy snapshot mówi o żywym ładowaniu;
   - przy fladze ustawionej bez żywego ładowania: log `Loading flag set without a live load, reloading` i `forceReload`;
   - przy żywym ładowaniu zapamiętuje pominięte żądanie z czasem;
     - w `finishBindingItems` tego ładowania: jeśli jego `startBinding` był **wcześniej** niż pominięte żądanie, wykonuje `forceReload` raz (`Running the reload skipped while load <id> was binding`);
     - w przeciwnym razie odrzuca je z logiem, bo to wiązanie widziało już nowe ustawienia;
   - regułę „wcześniej / później” liczy `WorkspaceLoadWatch` (test).
   - `FORCE_RELOAD_THROTTLE_MS` zostaje.
6. **Jedno miejsce flagi:** `beginWorkspaceLoading(reason)` i `endWorkspaceLoading(reason)`, z logiem D.
   - `rg -n "mWorkspaceLoading\s*=" app/src/main/java` → tylko w tych dwóch metodach (i w deklaracji pola).
7. **W commicie:**
   - opisz przebieg z §2.2 i to, że log nie pokazuje miejsca zatrzymania;
   - napisz, które nowe linie logu wskażą je przy następnym wystąpieniu.

## G2 — `Widgets: colors and backgrounds follow the settings on the widgets already shown`
1. **Czysta klasa `WidgetStyle.of(blackWidgets, blackBar, widgetsBackground)`.**
   - Dla ról `WIDGET_TEXT`, `WIDGET_BUTTON`, `WIDGET_PROGRESS`, `BAR_TEXT`, `BAR_BUTTON` zwraca czarny albo domyślny.
   - Dla tła zwraca nazwę zasobu albo `DEFAULT` (`bg_custom`).
   - Test `WidgetStyleTest`, także przejście czarny → biały → czarny.
2. **`ViewTint`, jedyne miejsce koloru widoków.** Kolor jest właściwością widoku, nie drawable:
   - przyciski i tła: `ViewCompat.setBackgroundTintList(v, black ? ColorStateList.valueOf(Color.BLACK) : null)` + `ViewCompat.setBackgroundTintMode(v, PorterDuff.Mode.SRC_IN)`;
   - `ImageView`: `ImageViewCompat.setImageTintList` + `setImageTintMode`;
   - pasek postępu: `setProgressTintList` + `setProgressTintMode`;
   - tekst: czarny albo kolor domyślny zapamiętany przy pierwszym wywołaniu (tag widoku).

   Framework nakłada tint widoku na każde nowe tło i obraz (`setBackground`, `setBackgroundResource`, `setImageResource`) i sam robi `mutate()`. Ikony favorite, play/pause, pauzy radia i cyfry zegara nie potrzebują więc dodatkowych wywołań, a współdzielony stan zasobów zostaje nietknięty.
   - Przenieś do `ViewTint` wszystkich wołających: `LauncherMusicWidget`, `LauncherRadioWidget`, `Workspace` (≈935/1868/1870/2012/2894/2896), `VerticalBarWindow` (≈190), `DigitClock` (≈110–119, ≈270/276), pasek postępu (≈1223–1231) i `CellLayout.setCalculatedTextColor`.
   - Usuń `Helpers.applyColorFilterToButton`, `applyColorFilterToImageView` i `removeColorFilterFromImageView` (po `rg`).
3. **Jeden `WidgetStyler.apply(reason)`** nakłada `WidgetStyle` na widoki widżetów, które są teraz pokazane:
   - **widżet muzyki:** play/pause, poprzedni, następny, favorite, pasek postępu, tytuł, wykonawca;
   - **muzyka w pasku** (widoki `_two`, `BLACK_BAR`);
   - **radio:** poprzedni, następny, pauza, pasmo, `tv_unit`, `tv_band`, `tv_freq`;
   - **cyfry `DigitClock`;**
   - **tło** korzeni daty, muzyki i radia oraz zastępników PiP. `"bg_custom"` oznacza `setBackgroundResource(R.drawable.bg_custom)`, czyli domyślne tło z układu.

   **Kiedy jest wołany:**
   - przy tworzeniu widoków: zastępuje `setWidgetButtonsTint`, `setBarButtonsTint`, `setCalculatedTextColor` i kod tła w `CellLayout` ≈3954 / ≈4241;
   - z jednego `OnSharedPreferenceChangeListener` w `Launcher` dla `BLACK_WIDGETS`, `BLACK_BAR` i `WIDGETS_SELECTED_BACKGROUND`.
     - Słuchacz jest trzymany w polu, rejestrowany w `onCreate` i wyrejestrowywany w `onDestroy`.
     - Działa na wątku głównym, także gdy launcher jest wstrzymany.

   **Inne:**
   - `Date` i `WeekDay` mogą zostać ze swoimi słuchaczami, ale kolor ustawiają przez `ViewTint`.
   - Log: `Widget style applied (<reason>): widgets <black|default>, bar <black|default>, background <name>, <n> views`.
4. **`BackgroundSelectorDialog`:**
   - `name`, `key`, `backgrounds` i `defaultBackground` przechodzą do argumentów fragmentu (`Bundle`), ustawianych na wątku głównym przed `show`;
   - statyczne pola tych wartości znikają;
   - wczytywanie tapety w tle zostaje bez zmian.
5. **W commicie:** opisz przyczyny z §2.3, czyli brak zdejmowania koloru, współdzielony stan drawable i zależność od przebudowy, oraz to, jak R2 je wyklucza.

## G3 — `Creators: touching rectangles do not overlap, and overlapping ones are fitted the way the bars fit them`
1. **Czysta reguła `RectOverlap.overlaps(l1, t1, r1, b1, l2, t2, r2, b2)`.**
   - Zwraca `true` tylko przy wspólnym polu > 0: `l1 < r2 && l2 < r1 && t1 < b2 && t2 < b1`.
   - Wspólna krawędź albo róg to nie nachodzenie.
   - Używają jej:
     - podświetlenie i `hasAnyIntersection` w `DrawViewScreen` i `DrawViewAppStats`;
     - krok 1 `CustomLayoutResolver`.
   - Trzy metody `overlapsOrTouches` usuwasz.
   - Kolizje z paskami (`Env`, `PipEdgeTrim`, `StatsBarFit`) zostają bez zmian.
   - Test `RectOverlapTest`: krawędź, róg, nachodzenie o 1 px, zawieranie.
2. **Krok 1 resolvera z logiką pasków.** Element ustępujący wybierasz jak dziś: PiP wygrywa z widżetem, a z dwóch równych wygrywa wcześniejszy. Następnie:
   1. **Przesunięcie** najkrótszą drogą, w tym samym rozmiarze, w wolne miejsce:
      - wolne miejsce jak w `fits` (≈539): w obszarze obok pasków (te same `Bounds`, które `Helpers` daje `placeReset`), co najmniej `gap` od zachowanych elementów, bez komórek z bazy przy `canMove`;
      - kandydaci: jak w `candidates` (≈556) oraz pozycje tuż obok każdego zachowanego elementu z czterech stron;
      - wybór: najmniejsze |dx|+|dy|; przy remisie najpierw ruch w poziomie, potem mniejsze y, potem mniejsze x.
   2. **Przycięcie**, gdy nie ma gdzie przesunąć (`cutAway` jak dziś).
   3. **Reset**, gdy nie da się przyciąć (`placeReset` w `Helpers` jak dziś).

   **Wynik i log:**
   - `Result` dostaje `moved[]` obok `cut[]`.
   - `Helpers` loguje dla strony: `Overlap on page <n>: <key> moved by <dx,dy> | cut to <l,t,r,b> | reset, beside <key>`.
   - Wynik nadal liczy się z prostokątów użytkownika.

   **Testy w `CustomLayoutResolverTest`:**
   - stykające się zostają jak narysowane, przy marginesie 0 i 5;
   - widżet na widżecie jest przesunięty najkrótszą drogą, w tym samym rozmiarze;
   - PiP wygrywa z widżetem;
   - brak miejsca → przycięcie;
   - niemożliwe przycięcie → reset;
   - przesunięty element zostaje w obszarze obok pasków i poza komórkami z bazy;
   - to samo wejście daje ten sam wynik.
3. **Dialog** (`DrawViewScreen` ≈1246 i `DrawViewAppStats` ≈769):
   - pojawia się tylko przy `RectOverlap.overlaps`;
   - tytuł `overlapping` zostaje;
   - **treść, nowy string `overlap_fit_message`:**
     - EN: „Overlapping widgets will be moved apart the way the bars move them: made smaller only where there is no room, and reset only if they cannot fit at all.”
     - PL: „Nachodzące widgety zostaną rozsunięte tak, jak przesuwają je paski: zmniejszone tylko tam, gdzie brakuje miejsca, i zresetowane tylko wtedy, gdy się nie zmieszczą.”
   - **przycisk, nowy string `proceed_and_fit`:** EN „Proceed and fit”, PL „Kontynuuj i dopasuj”;
   - oba stringi trafiają do 59 plików; `wont_save` i `proceed_and_reset` usuwasz po `rg`;
   - **„Proceed and fit”:**
     1. `savePrefs()`, czyli to, co narysowano, tak jak przy zwykłym zapisie (prostokąty użytkownika dotkniętych kluczy);
     2. `helpers.checkAndResetIfOverlappingOnScreen(-1)`;
     3. prostokąty wczytane od nowa z zapisanych narożników (`initRectangle` dla włączonych, jak `fitRectanglesIntoCanvas` ≈530–536) i `invalidate()`;
     4. dalej jak ścieżka, która otworzyła dialog: z `confirm_layout` toast `layout_set` i kreator zostaje otwarty, z klawisza wstecz przejście do `SettingsFragmentSecond`;
   - „Dismiss” bez zmian.
4. **Komentarze `CustomLayoutResolver`** (≈6–33, ≈47, ≈175–181, ≈489) opisują nowy krok 1 i nie mówią już o oknie statystyk jako przeszkodzie.

## 3. Czego NIE zmieniać
- Pasków, uchwytu, D4, E1–E3 ani F1–F3, w tym reguł okna statystyk.
- Tego, że dotknięcie paska to kolizja.
- Kluczy prefów i prostokątów oraz odstępu `gap = max(margin, 1)` dla elementów przesuwanych i przycinanych.
- `WORKSPACE_LOADING_WATCHDOG_MS = 30000`, `FORCE_RELOAD_THROTTLE_MS` i `MAX_IDLE_WAIT_MS`.
- Kolorów zastępczych tapety w `BackgroundSelectorDialog`.

## 4. Weryfikacja
1. CI zielone po każdym commicie, a nowe testy przechodzą: `WorkspaceLoadWatchTest`, `WidgetStyleTest`, `RectOverlapTest`, rozszerzony `CustomLayoutResolverTest`.
2. **Sprawdzenia `rg`:**
   - `rg -n "mWorkspaceLoading\s*=" app/src/main/java` → tylko `beginWorkspaceLoading` i `endWorkspaceLoading` (i deklaracja pola);
   - `rg -n "setColorFilter\(|clearColorFilter\(" app/src/main/java/com/android/launcher66/{LauncherMusicWidget,LauncherRadioWidget,Workspace,VerticalBarWindow,CellLayout}.java app/src/main/java/com/fyt/widget app/src/main/java/com/android/launcher66/settings/Helpers.java` → zero;
   - `rg -n "overlapsOrTouches|applyColorFilterTo|removeColorFilterFrom|wont_save|proceed_and_reset" app/src` → zero;
   - `rg -c 'name="proceed_and_fit"' app/src/main/res` → 59.
3. **Scenariusze dla testera.** Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Strona z widżetami muzyki, radia i daty oraz pasek z widżetami.
     - „Widget text and button color” na czarny → po powrocie do launchera czarne są wszystkie teksty i przyciski: play/pause, poprzedni, następny, favorite, pasek postępu, radio (poprzedni, następny, pauza, pasmo) i cyfry zegara. Pasek się nie zmienia.
     - Z powrotem na biały → wszystko białe, także favorite po zmianie jego stanu.
     - Powtórz 3× bez restartu.
     - To samo z ustawieniem paska: widżety się nie zmieniają.
   - b) Tło widżetów:
     - wybór tła → po powrocie mają je wszystkie widżety i zastępniki PiP;
     - wybór domyślnego → wraca domyślne;
     - bez restartu.
   - c) Ładowanie:
     - kilka szybkich powrotów z ustawień: dwa w ciągu kilku sekund oraz wejście do ustawień zaraz po powrocie;
     - ikony i widżety z bazy są zawsze;
     - w logu jest `Loader <id> started … bind finished`;
     - jeśli watchdog się odpali, log pokazuje snapshot i `starting it again`, a ikony pojawiają się potem.
   - d) Kreator, prostokąty stykające się:
     - prawa krawędź A i lewa krawędź B na 348 → nie świecą na czerwono, zapis bez dialogu;
     - na launcherze oba stoją jak narysowane (`Layout of page …`).
   - e) Kreator, prostokąty nachodzące:
     - nachodzenie o 1 px → czerwone podświetlenie i dialog;
     - „Proceed and fit” → ustępujący przesuwa się najkrótszą drogą, w swoim rozmiarze, a kreator pokazuje wynik;
     - bez miejsca → ustępujący jest mniejszy;
     - PiP nigdy nie ustępuje widżetowi;
     - klawisz wstecz przy nachodzeniu → dialog → „Proceed and fit” → ustawienia, a launcher pokazuje dopasowany układ.
   - f) Kreator statystyk: ta sama reguła dialogu.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Każdy commit (hash i temat) z wynikiem CI.
- G1: czy udało się odtworzyć zatrzymane ładowanie, a jeśli tak, co pokazały nowe linie logu.
- Wyniki `rg` z §4.2.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.3.
