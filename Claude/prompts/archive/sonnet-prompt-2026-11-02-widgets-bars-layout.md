# Launcher Mod: PiP i widgety a paski – przesunięcie, przycięcie, reset w wolne miejsce; skalowanie widgetów

## Kontekst

Zadanie „PiP zmniejsza się o tyle, o ile nachodzi na niego pasek” jest już zrobione (commit `ce915a2`,
gałąź bazowa `testBranch` ≥ `6c45bba`). Celowo objęło **tylko** klucze PiP. Ten dokument zawiera cztery zadania:
1. Przycinanie ma objąć również widgety **date, music, radio** na ekranie 0. **Stats** i `appStats` zostają bez zmian.
2. Tekst w widgetach ma się mieścić (date: „Monday” nie mieści się w kolumnie; rozwiązanie: autosize z AppCompat).
   Do sprawdzenia również radio i music.
3. Nowa kolejność reakcji na pasek: **przesunięcie** (z uwzględnieniem bazy danych launchera) → **przycięcie**
   → **przycięcie elementów stojących na drodze** → **reset** (tylko konieczny, w wolne miejsce).
   Układ faktyczny jest zawsze liczony od zapamiętanego **prostokąta użytkownika**, więc wraca, gdy pasek się
   zmniejszy albo zniknie.
4. Dual PiP: suwak podziału zachowuje proporcję, a żaden panel nie robi się węższy od minimum.

Kolejność wykonania: 1 → 2 → 3 → 4. Zadanie 3 wchłania logikę przycinania z zadania 1.

Infrastruktura już istnieje i ma być użyta ponownie – nic nowego od zera:
- `settings/PipEdgeTrim.java` – czysta klasa: `trim(...)`, `maxBottom(barTop, margin)`,
  `maxRight(rootWidth, leftBarWidth, margin)`, `computeLeftBarWidth(...)`, `pipMinWidth(...)`, `isPipKey(...)`.
- `settings/BottomBarDimensions.computeLeftBarWidth(...)` – spójna szerokość lewego paska (już używana w
  `Helpers` i `CreatorFirstScreen`). **Nie ruszać.**
- `Helpers.trimPipsCoveredByBars(...)` (Helpers.java ~640–710), wywoływane w
  `checkAndResetIfOverlappingOnScreen()` przed kontrolą kolizji; filtr `PipEdgeTrim.isPipKey(key)`.
- `DrawViewFirstScreen.fitIntoCanvas()` (~507) – przycięcie tylko gdy `PipEdgeTrim.isPipKey(cfg.key)`.
- `PipEdgeTrimTest` – istniejące testy; test `pipKeys()` sprawdza, że date/music/radio NIE są kluczami PiP.
- Minima widgetów: jedno źródło prawdy już jest – `WidgetMetrics.compute(screenWidth, screenHeight)`; z niego
  ustawiane są `Launcher.calculated{Date,Music,Radio}Min{Width,Height}` (Launcher ~1872) i identyczne pola w
  `SettingsActivity` (~265). Kreator (`DrawViewFirstScreen.addRectangle()`) wpisuje je do
  `RectangleConfig.minWidth/minHeight`; `Helpers.resetOverlappingRectangles()` czyta wersje z `Launcher`.
- Propagacja do launchera: po zmianie prefs `processPendingUpdateOnResume()` woła `checkAndResetIfOverlappingOnScreen(-1)`,
  a potem `recreateView()` przebudowuje stronę i `CellLayout.addCustomWidgetToGrid()` (~4380) czyta nowe narożniki.
  Ścieżka jest ta sama, którą dziś idzie reset widgetu – nie trzeba nic dodawać. Music/radio skalują zawartość z
  rozmiaru (`MusicWidgetSizer`, `RadioWidgetSizer`); date nie ma sizera, ale przycięcie nigdy nie schodzi poniżej
  minimum, więc zawartość mieści się jak w widgecie narysowanym przez użytkownika w tym rozmiarze.

---

## Prompt dla Sonnet

### 0. Zasady ogólne

- Zmiany minimalne i celowane; nie refaktoryzuj kodu, którego zadanie nie dotyczy. **Nie zmieniaj nazwy klasy
  `PipEdgeTrim`** (tylko zaktualizuj jej javadoc, by mówił o PiP i widgetach).
- Komentarze w kodzie po **angielsku**, w stylu repo (komentarz wyjaśnia *dlaczego*, nie *co*).
- Nie dodawaj zależności. Od AGP 9 identyfikatory zasobów nie są stałymi – nie używaj ich w `switch/case`.
- Logika obliczeniowa w czystych klasach bez importów Androida, testy JUnit 5 w `app/src/test/java/...`
  (w testach `unitTests.isReturnDefaultValues = true` → `RectF/Rect` zwracają 0; w testowanej logice operuj na `int`).
- Współrzędne: domyślne `SharedPreferences`, `<klucz>TopLeftX/Y`, `TopRightX/Y`, `BottomRightX/Y`, `BottomLeftX/Y`;
  przestrzeń = box `user_layout` bez lewego paska i bez status bara. Ekran: `Keys.*_SCREEN` (1-based).
- Pasek dolny tylko na ekranie 0 (`Helpers.getBarGeometry()`, `barTop = rootHeight - barHeight`); płótno kreatora
  ma wysokość `barTop`.
- Bazą jest `testBranch`; pracuj na gałęzi przydzielonej w sesji. Jeden commit po angielsku na zadanie
  (przyczyna i skutek). Bez PR.
- Na koniec `./gradlew :app:testDebugUnitTest` (i jeśli się da `:app:assembleDebug`). Jeśli build jest
  niemożliwy – napisz to wprost; nie twierdź, że coś działa, jeśli tego nie sprawdziłeś.

### Zadanie – widgety date/music/radio przycinane jak PiP

#### Stan obecny (potwierdź przed zmianą)
- `Helpers.trimPipsCoveredByBars()` pomija klucze inne niż PiP, więc widget `date`/`music`/`radio` na ekranie 0,
  który nachodzi na pasek dolny (bez auto-hide) lub na lewy pasek (`overlapsOrTouchesBorder`), dostaje
  `needsReset = true` w `checkAndResetIfOverlappingOnScreen()` i wraca na domyślną pozycję w
  `resetOverlappingRectangles()`.
- `DrawViewFirstScreen.fitIntoCanvas()` dla widgetów od razu przesuwa i zmniejsza prostokąt do minimum.

#### Wymaganie
Dotyczy kluczy `pipDual, pipFirst, pipSecond, pipThird, pipFourth` (bez zmian) **oraz `date, music, radio`**
na ekranie 0. `stats` / `appStats` zachowują obecne zachowanie.

1. Reguły przycięcia identyczne jak dla PiP (użyj istniejących `PipEdgeTrim.trim/maxBottom/maxRight`):
   pasek dolny → tylko dolna krawędź do `barTop - max(margin, 1)`; pasek boczny → tylko prawa krawędź do
   `PipEdgeTrim.maxRight(rootWidth, leftBarWidth, margin)`; oba naraz możliwe; lewa i górna krawędź bez zmian.
2. Minimum widgetu = to, które kreator wpisuje w `RectangleConfig` dla danego klucza:
   `date` → `calculatedDateMinWidth/Height`, `music` → `calculatedMusicMin*`, `radio` → `calculatedRadioMin*`.
   W `Helpers` czytaj z `Launcher.calculated*` (tak jak `resetOverlappingRectangles()`), w kreatorze z
   `cfg.minWidth/minHeight`. Obie wartości pochodzą z `WidgetMetrics` – nie twórz nowego źródła.
   Poniżej minimum (w którejkolwiek osi) albo gdy widget leży cały pod paskiem → `trim` zwraca `null` →
   **fallback: reset jak dotychczas** (bez zapisu przycięcia). Nie zmieniaj logiki samego resetu.
3. Udane przycięcie zapisz od razu do wszystkich ośmiu wartości narożników (istniejący kod w
   `trimPipsCoveredByBars`) – dalsze kontrole kolizji widzą przycięty prostokąt. Kolizje widget–PiP /
   widget–widget nadal prowadzą do resetu jak dziś.
4. Wartość zwracana `checkAndResetIfOverlappingOnScreen()` bez zmian semantyki (`foundOverlap || trimmedAny`).

#### Kroki implementacji
1. **`PipEdgeTrim`**: dodaj `isTrimmableKey(String key)` = `isPipKey(key) || "date"/"music"/"radio"`.
   Zostaw `isPipKey` bez zmian (używa go `pipMinWidth`/inne miejsca). Zaktualizuj javadoc klasy
   (PiP i widgety; reset, który restartuje aplikację PiP lub gubi układ widgetu).
2. **`Helpers.trimPipsCoveredByBars()`** → zmień nazwę na `trimRectsCoveredByBars()` (prywatna, jedno wywołanie)
   i javadoc. Filtr `PipEdgeTrim.isPipKey(key)` → `PipEdgeTrim.isTrimmableKey(key)`. Minimum wybierz
   prywatną metodą w `Helpers`, np.:
   - PiP → dotychczasowe `PipEdgeTrim.pipMinWidth(...)` / `Launcher.calculatedPipMinHeight`,
   - `date`/`music`/`radio` → odpowiednie `Launcher.calculated*Min*`.
   (`if/else` na stringach lub `switch` na `String` – to nie są ID zasobów, więc `switch` jest OK.)
   Zaktualizuj komentarz przy wywołaniu („A PiP or widget that only reaches under…”) i log.
3. **`DrawViewFirstScreen.fitIntoCanvas()`**: warunek `PipEdgeTrim.isPipKey(cfg.key)` →
   `PipEdgeTrim.isTrimmableKey(cfg.key)`; komentarz „A PiP or widget…”. Nic więcej –
   `cfg.minWidth/minHeight` dla widgetów są już poprawne z `addRectangle()`.
4. Upewnij się, że nic innego nie filtruje po `isPipKey` w kontekście przycinania
   (`grep -rn isPipKey app/src/main`).

#### Testy (JUnit 5, `PipEdgeTrimTest`)
- Zmień `pipKeys()`: date/music/radio nadal **nie** są `isPipKey`; dodaj test `isTrimmableKey`:
  true dla 5 kluczy PiP + `date, music, radio`; false dla `stats, appStats`, `null`-bezpieczne? (jeśli
  implementacja używa `"x".equals(key)`, dodaj przypadek `null` → false).
- Przypadki z wartościami referencyjnymi widgetów (`WidgetMetrics.*_REF`, short edge 1200):
  - `date` (528×144) przycięty dołem przez pasek, wysokość ≥ 144 → przycięty dół;
  - `radio` (301×144) po przycięciu wysokość 143 → `null`;
  - `music` (301×360) przycięty prawą krawędzią przez lewy pasek w granicach minimum → przycięta prawa;
    poniżej 301 → `null`;
  - widget cały pod paskiem → `null`.
  (Opcjonalnie: przez `WidgetMetrics.compute(2000, 1200)` zamiast stałych, żeby testy szły za źródłem minimów.)

#### Weryfikacja
1. `./gradlew :app:testDebugUnitTest` – wszystkie testy zielone (w tym istniejące `PipEdgeTrimTest`,
   `WidgetMetricsTest`).
2. `./gradlew :app:assembleDebug`, jeśli środowisko pozwala.
3. Przegląd ścieżki ręcznie (bez urządzenia nie da się uruchomić): po przycięciu `processPendingUpdateOnResume()`
   → `recreateView()` → `CellLayout.addCustomWidgetToGrid()` czyta nowe narożniki; w kreatorze `onSizeChanged`
   → `fitRectanglesIntoCanvas()` → `fitIntoCanvas()` przycina widget zamiast go przesuwać.
4. Raport: co zmieniono, wynik testów/buildu (dosłownie), czego nie dało się sprawdzić.

#### Pliki do zmiany
- `app/src/main/java/com/android/launcher66/settings/PipEdgeTrim.java`
- `app/src/main/java/com/android/launcher66/settings/Helpers.java`
- `app/src/main/java/com/android/launcher66/settings/DrawViewFirstScreen.java`
- `app/src/test/java/com/android/launcher66/settings/PipEdgeTrimTest.java`

---

### Zadanie 2 – tekst w widgetach ma się mieścić w dostępnej szerokości (osobny commit)

Cel: tylko **dopasowanie**. Maksymalne rozmiary czcionek zostają bez zmian (`Launcher.widgetTextSizeBasic`
dla date; `maxText` w `MusicWidgetSizer`; brak górnego limitu w `RadioWidgetPlan` – nie dodawaj go).
Tekst może być tylko *mniejszy* od maksimum, gdy się nie mieści – nigdy większy.

#### 2a. Widget date (`res/layout/absolute_time.xml`, `com/fyt/widget/Date.java`, `com/fyt/widget/WeekDay.java`)
Układ: `ll_time` (Flexbox w wierszu) → kolumna zegara `constraint_layout_clock` (70 %) i kolumna daty
`constraint_layout_date` (30 %) → wewnątrz Flexbox w kolumnie z `com.fyt.widget.Date` (data) nad
`com.fyt.widget.WeekDay` (dzień tygodnia). Oba TextView mają w XML `textSize="0sp"` i same ustawiają rozmiar w
`setDate()` → `adjustTextSize()`.

Błędy w obecnym kodzie (`Date` i `WeekDay` mają identyczny, zduplikowany kod):
1. **Dopasowanie tylko raz** (`isTextSizeAdjusted`). `TimeUpdateReceiver` wywołuje `setDate()` o północy z nowym
   tekstem, ale rozmiar nie jest przeliczany. Jeśli start był w dniu o krótkiej nazwie (np. „Friday”),
   dłuższa nazwa („Monday”, „Wednesday”, a po polsku „Poniedziałek”) wychodzi poza kolumnę.
2. **Zła szerokość odniesienia.** `maxWidth = parent.getWidth() - 16dp`, gdzie parent to wewnętrzny Flexbox
   z `layout_width="wrap_content"` + `layout_constraintDimensionRatio="1:1"`. Jego szerokość zależy od samego
   tekstu albo od wysokości (kwadrat), a nie od miejsca w kolumnie `constraint_layout_date` (30 % widgetu).
3. **Pomiar innym fontem.** `new TextPaint()` ma domyślny krój zamiast kroju i letter-spacingu widoku.
4. **Wysokość nie jest brana pod uwagę.**

Rozwiązanie (decyzja właściciela): **wbudowany autosize z AppCompat** zamiast własnego mierzenia, tylko w
`absolute_time.xml` (widget date układu użytkownika). `Date` i `WeekDay` dziedziczą z `AppCompatTextView`, więc
autosize jest dostępny. Autosize dopasowuje tekst do szerokości **i** wysokości widoku przy każdej zmianie tekstu
i rozmiaru, co usuwa błędy 1–4.
- `absolute_time.xml`: wewnętrzny kontener kolumny daty ma wypełniać kolumnę, czyli szerokość i wysokość z
  ograniczeń zamiast `wrap_content` + ratio 1:1. Obie linie dostają **określony** rozmiar: szerokość kolumny i po
  połowie wysokości (np. `0dp` z wagą/łańcuchem). Autosize nie działa poprawnie z `wrap_content`.
  `android:singleLine="true"` zamień na `android:maxLines="1"`, bo autosize nie współpracuje z `singleLine`.
  Ustaw `app:autoSizeTextType="uniform"`.
- Maksimum zostaje `Launcher.widgetTextSizeBasic` (sp, jak dziś), minimum 8 sp (jak `RadioWidgetPlan.MIN_TEXT_SP`).
  Ustaw je w kodzie, bo maksimum jest dynamiczne: `TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(
  view, 8, Launcher.widgetTextSizeBasic, 1, TypedValue.COMPLEX_UNIT_SP)`. Zrób to w `Date`/`WeekDay` raz, gdy
  widok ma autosize włączony z XML (`TextViewCompat.getAutoSizeTextType(this) != AUTO_SIZE_TEXT_TYPE_NONE`).
  Jeśli `widgetTextSizeBasic` < 8, użyj go jako minimum i maksimum.
- **Uwaga:** `setTextSize()` **wyłącza** autosize. W trybie autosize `setDate()` ustawia tylko tekst: bez
  `setTextSize()`, bez `adjustTextSize()`, bez onPreDraw.
- Pozostałe layouty z tymi klasami (`custom_layout_one`, `fyt_xml_dt_time_widget`) zostają przy dotychczasowym
  `adjustTextSize()`, z poprawkami 1 (przeliczanie przy każdej zmianie tekstu, zawsze od maksimum) i 3 (pomiar
  kopią `getPaint()`), żeby nie zostawić tam tego samego błędu. Tam bez zmian w XML.
- Data i dzień tygodnia mogą mieć różne rozmiary czcionki: autosize liczy każdy widok osobno. Właściciel to
  zaakceptował.
- Komentarze po angielsku, dlaczego (np. „setTextSize() would switch autosize off, so the size is left to it”).

#### 2b. Widget radio – sprawdzenie (oczekiwany wynik: bez zmian w kodzie)
`RadioWidgetSizer` + `RadioWidgetPlan` już robią to poprawnie: mierzą najszersze możliwe teksty (`LABELS`,
`"108.00"`) fontem widoku, przeliczają przy każdym `onLayoutChange`, etykieta jest zmniejszana do szerokości
kolumny, a częstotliwość do min(wysokość, pozostała szerokość). Jedyne ryzyko to dolny limit `MIN_TEXT_SP` (8 sp),
który przy bardzo małym widgecie może dać tekst szerszy niż kolumna. Dodaj test w
istniejącym `app/src/test/java/com/android/launcher66/RadioWidgetPlanTest.java`: dla minimum z
kreatora (`WidgetMetrics.compute(...)` → `radioMinWidth × radioMinHeight`, short edge 720/1080/1200,
density 1.5/2.0, `labelPerPx ≈ 2.0`, `freqPerPx ≈ 3.3`) sprawdź, że
`labelTextPx * labelPerPx <= columnPx` i `freqTextPx * freqPerPx <= innerW - 2*columnPx - 2*gapPx`.
Popraw `RadioWidgetPlan` **tylko jeśli test nie przejdzie**, i tylko w zakresie dopasowania (bez zmiany maksimum).

#### 2c. Widget music – sprawdzenie (oczekiwany wynik: bez zmian w kodzie)
Tytuł i artysta w `music_widget_content.xml` są `singleLine` + `ellipsize="marquee"`, więc długi tytuł
przewija się z założenia i nie jest dopasowywany do szerokości. Nie zmieniaj tego. Wysokość tekstu, okładka i
przyciski pochodzą z `MusicWidgetPlan.planHome()`: okładka ≤ 0,9 w, przycisk ≤ w/4 × 0,8 dla 4 przycisków.
Dopisz test w istniejącym `MusicWidgetPlanTest`: dla minimum `musicMinWidth × musicMinHeight` przy tych
samych short edge/density suma wysokości części ≤ h oraz `4 * buttonSidePx <= w`, `coverPx <= w`.
Poprawka tylko przy niezdanym teście.

#### Testy do Zadania 2
- Autosize to kod frameworka, więc dla date nie ma czystej logiki do testu JVM. Nie dopisuj sztucznej klasy
  tylko po to, żeby mieć test. Jeśli dla ścieżki bez autosize wydzielisz obliczenie rozmiaru (poprawka 1/3), pokryj
  je testem: mieści się → maksimum; za szeroki → mniejszy i mieści się; krótszy tekst po dłuższym → wraca do maksimum.
- Testy radia/music jak wyżej.

#### Weryfikacja Zadania 2
- `./gradlew :app:testDebugUnitTest`, a jeśli się da, `:app:assembleDebug`.
- Bez urządzenia nie da się sprawdzić wyglądu. W raporcie wypisz, co wymaga sprawdzenia na urządzeniu: widget date
  przy minimalnej szerokości i wysokości, dzień „Monday”/„Wednesday”, polski locale, zmiana dnia o północy,
  zmiana rozmiaru widgetu w kreatorze.

#### Pliki (Zadanie 2)
- `app/src/main/res/layout/absolute_time.xml`
- `app/src/main/java/com/fyt/widget/Date.java`, `app/src/main/java/com/fyt/widget/WeekDay.java`
- testy: dopiski w `RadioWidgetPlanTest` / `MusicWidgetPlanTest` (+ ewentualny test obliczenia bez autosize)
- Commit osobny od Zadania 1, np. „Date widget: autosize the date and week day to their column”.

---

### Zadanie 3 – kolejność: przesunięcie → przycięcie → przycięcie blokujących → reset (tylko konieczny, w wolne miejsce)

Cel właściciela: gdy pasek dolny urośnie albo pojawi się pasek boczny, PiP i widget mają w pierwszej kolejności
**przesunąć się** w wolne miejsce, w drugiej **przyciąć**, a dopiero na końcu **zresetować**. Reset dotyczy tylko
elementów, które absolutnie tego wymagają. Zresetowany element trafia tam, gdzie się mieści w bieżącym układzie,
a nie na sztywną pozycję domyślną.

#### 3.0 Stan obecny (potwierdź przed zmianą)
- `Helpers.checkAndResetIfOverlappingOnScreen()`: po zadaniu 1 najpierw `trimRectsCoveredByBars()`, potem
  `needsReset` za pasek dolny, prawą krawędź (lewy pasek) i nachodzenie dwóch prostokątów. Przy nachodzeniu
  resetowane są **oba** (`needsReset[i]` i `needsReset[j]`).
- `Helpers.resetOverlappingRectangles()` stawia zresetowane elementy w stałym wzorze pozycji domyślnych,
  w rozmiarach minimalnych. Nie patrzy ani na elementy standardowe (ikony, foldery, widgety systemowe), ani na
  inne elementy niestandardowe, ani na lewy pasek. Unikanie paska dolnego ma warunek `!leftBar && ...`, choć
  z lewym paskiem pasek dolny też istnieje (`bottomBarRect` jest tworzony niezależnie od `leftBar`). Element
  zresetowany pod paskiem dolny może więc być resetowany przy każdym wznowieniu. Nowe wyszukiwanie wolnego
  miejsca (3.3) usuwa ten błąd.
- **Lewy pasek a kierunek ruchu.** Współrzędne w prefs są liczone w boxie bez lewego paska. `CellLayout`
  (`addCustomWidgetToGrid`, `isLeftBarOffsetActive`) i `WindowUtil` (~2623) dodają `calculatedLeftBarWidth` na
  ekranie 0, więc „przesunięcie w prawo” robi już samo przesunięcie układu o szerokość paska. Kolizja powstaje
  przy **prawej krawędzi** (`right + leftBarWidth > rootWidth - margin`). Rozwiązaniem w osi poziomej jest
  przesunięcie elementu w **lewo we współrzędnych boxu**, w miejsce zwolnione obok paska. Na ekranie element
  zostaje po prawej stronie paska.
- Pasek dolny: granica `maxBottom = PipEdgeTrim.maxBottom(barTop, margin)`, ruch w górę.
- `stats` to element niestandardowy z własnym prostokątem (`stats*` w prefs, `Keys.STATS_SCREEN`,
  `Keys.USER_STATS` domyślnie true). Ma zostać przeszkodą: **nie jest przesuwany ani przycinany**, ale inni nie
  mogą na niego wejść. `appStats` nie leży na ekranie launchera i jest pomijany.

#### 3.1 Elementy standardowe z bazy danych, nie z siatki
Na stronie w trakcie budowy część ikon, folderów i widgetów może nie być jeszcze związana z widokami. Dlatego
wolne miejsce bierzemy z **bazy danych launchera**:
- `LauncherModel.getItemsInLocalCoordinates(Context)` (LauncherModel ~795) czyta `cellX/cellY/spanX/spanY/
  container/screen` z `Favorites`. Bierz tylko `container == LauncherSettings.Favorites.CONTAINER_DESKTOP`
  (bez hotseatu i zawartości folderów).
- Strona → `screenId`: przy układzie użytkownika strona 0 to `Workspace.CUSTOM_CONTENT_SCREEN_ID1` (−302;
  `apps_customepage_count` = 1). Strony ≥ 1 mają id z `LauncherModel.loadWorkspaceScreensDb()` w kolejności
  rang. **Zweryfikuj** zgodność z `Workspace.mScreenOrder`, `getIdForScreen()` i tym, co zapisuje
  `updateItemLocationsInDatabase()`. Kolejność opisz w komentarzu.
- **Zajętość sprawdzana w komórkach, nie w pikselach.** Launcher przypisuje element niestandardowy do komórek
  wzorem `CellLayout.pointToCellExact()`: `(x − paddingLeft) / (cellWidth + widthGap)`, czyli przerwa należy do
  komórki poprzedniej. `addCustomWidgetToGrid()` liczy komórki z `(topLeftX + leftBarOffset, topLeftY)` i
  `(right − 1, bottom − 1)`. Wystarczy przesunięcie o kilka pikseli, które zahaczy o rząd z ikoną, i
  `handleConflictingViews()` przeniesie tę ikonę, choć w pikselach „było wolne”. Dlatego:
  - czysta klasa `settings/GridGeometry` (paddingLeft, paddingTop, pitchX = cellWidth + widthGap,
    pitchY = cellHeight + heightGap, countX, countY, leftBarOffset dla strony 0) z metodą
    `cellsOf(left, top, right, bottom)` = **dokładnie** wzór z `pointToCellExact` (z clampem do siatki) oraz
    metodami granic rzędów/kolumn w px, np. „najmniejszy `top`, który mapuje się na rząd `r`” = `paddingTop + r·pitchY`.
    Potrzebne do wyliczenia, jak daleko można się przesunąć;
  - `CellLayout` publikuje te wartości po pomiarze (gdy `mCellWidth > 0`) do statycznego `volatile` holdera, na
    wzór `BottomBarDimensions.publishBarRootSize()` (Workspace ~1313). Wszystkie strony mają tę samą siatkę;
  - siatka zajętości z DB per ekran `boolean[countX][countY]`, budowana raz na wywołanie;
  - przeszkodą jest zajęta komórka, w którą element **wszedłby**, a nie zajmował jej już w pozycji wyjściowej.
    Komórki pod pozycją wyjściową (prostokąt użytkownika z 3.2) ignoruj: `handleConflictingViews()` już je
    obsłużył, bo element niestandardowy ma pierwszeństwo nad standardowymi;
  - gdy geometria nie jest opublikowana (np. kreator bez launchera w procesie), nie zgaduj. Wtedy **nie ma
    przesunięć**: działa przycięcie i reset (z logiem), a reset idzie na dawną pozycję domyślną.
- Zapytanie do ContentResolvera na wątku głównym jest akceptowalne (mała tabela), raz na wywołanie
  `checkAndReset...`. **Nie** wołaj `flushWorkerThread()` z wątku głównego, bo blokuje w trakcie ładowania.

#### 3.2 Zapamiętany układ użytkownika (decyzja właściciela)
Dziś każde przycięcie i przesunięcie nadpisuje prostokąt na stałe. Gdy pasek się zmniejszy albo lewy pasek
zniknie, element nie wraca, a kolejne zmiany paska kumulują zniekształcenia. Teraz:
- Każdy element ma **prostokąt użytkownika** (ustawiony w kreatorze albo przez reset) w nowych kluczach
  `<key>UserLeft/UserTop/UserRight/UserBottom`. Istniejące 8 kluczy narożników to **układ faktyczny**. Launcher,
  `CellLayout`, `WindowUtil` i PiP czytają je jak dziś, bez zmian po ich stronie.
- Migracja: brak kluczy `User*` → przy pierwszym uruchomieniu zainicjuj je z bieżących narożników.
- `Helpers` liczy układ faktyczny **zawsze od prostokątów użytkownika** (funkcja czysta: prostokąty użytkownika +
  paski + siatka z DB → układ faktyczny). Zapisuje narożniki tylko, gdy się zmieniły. Ten sam stan wejściowy daje
  ten sam wynik (idempotencja), a po powrocie paska do poprzedniej wysokości wraca układ użytkownika.
- Prostokąt użytkownika ma zawsze pierwszeństwo przed elementami standardowymi (tak jak dziś przy dodaniu w
  kreatorze). Jeśli po powrocie na swoje miejsce zajmie komórki z ikonami, przeniesie je `handleConflictingViews()`.
  Reguła „tylko wolne miejsce z DB” dotyczy **przesunięć i resetu**, nie powrotu na własne miejsce.
- Kreator pokazuje układ faktyczny. Element, który użytkownik przeciągnął, zmienił mu rozmiar albo dodał
  (śledź to zbiorem „dotkniętych” kluczy w `DrawViewFirstScreen`), dostaje przy zapisie nowy prostokąt
  użytkownika = to, co widać. Pozostałe zachowują swój dotychczasowy prostokąt użytkownika. Automatyczne
  dopasowanie (`fitRectanglesIntoCanvas`) **nie** zmienia prostokątów użytkownika.
- Reset ustawia nowy prostokąt użytkownika (reset to świadoma relokacja).
- Przy zmianie ekranu elementu w ustawieniach prostokąt użytkownika zostaje ten sam.

#### 3.3 Czysty resolver: `settings/CustomLayoutResolver.java` (bez importów Androida, tylko `int`)
Model: element `{key, left, top, right, bottom (prostokąt użytkownika), minW, minH, isPip, fixed}`. `fixed`
dotyczy stats. Do tego siatka zajętości z DB + `GridGeometry`, granice (`minLeft = minTop = margin`, `maxRight`,
`maxBottom`) i odstęp `gap = max(margin, 1)` między elementami niestandardowymi (`overlapsOrTouches()` traktuje
styk jako kolizję).

Kroki dla ekranu:
1. **Nachodzenie prostokątów użytkownika na siebie** (bez udziału paska) → reset **tylko jednego**: pusty
   (nigdy nie ustawiony) zawsze; widget ustępuje PiP (reset PiP restartuje aplikację); między równymi późniejszy
   w `RECTANGLE_KEYS`. Zresetowane wypadają z dalszych kroków (trafiają do 3.4).
2. **Oś pozioma** (lewy pasek, ruch w lewo we współrzędnych boxu), potem **oś pionowa** (pasek dolny, ruch w
   górę) na wyniku osi poziomej. Opis dla osi pionowej; pozioma jest symetryczna („nad” → „na lewo od”,
   `maxBottom` → `maxRight`).
   - Graf: B jest **nad** A, gdy ich rzuty poziome kolidują z uwzględnieniem `gap`
     (`B.left < A.right + gap && A.left < B.right + gap`) i `B.top < A.top`.
   - `ceilDb(E)` = najmniejszy `top`, przy którym E nie wchodzi w zajętą komórkę DB nad sobą w swoich
     kolumnach (z `GridGeometry`; komórki pod pozycją wyjściową E się nie liczą). `fixed` jest dla
     wszystkich zwykłą przeszkodą.
   - **Przejście 1, od góry** (kolejność rosnącego `top`):
     - `minTopKeep(E) = max(margin, ceilDb(E), max_B nad E (minTopKeep(B) + h(B) + gap))`: najwyżej, gdzie E
       może stanąć, gdy blokujący zostają przy obecnym rozmiarze i są tylko spychani;
     - `minTopMin(E)`: to samo, ale z `minH(B)`, czyli z blokującymi przyciętymi do minimum.
   - **Wykonalność:** E da się zmieścić iff `minTopMin(E) + minH(E) ≤ maxBottom`. Jeśli kilka elementów jest
     niewykonalnych, do resetu idzie ten z **największym `bottom`** (ten wypychany przez pasek, nie blokujący).
     Potem przelicz przejście 1 i powtarzaj. Blokujący nie są resetowani z powodu cudzego ruchu.
   - **Przejście 2, od paska w górę** (kolejność malejącego `bottom`). Dla E:
     `allowedBottom = min(maxBottom, min_A pod E (newTop(A) − gap))`. Jeśli `bottom ≤ allowedBottom` → bez zmian.
     Inaczej, w tej kolejności:
     1. **ruch:** `newTop = max(top − over, minTopKeep(E))`, rozmiar bez zmian;
     2. **przycięcie E:** jeśli nadal `newTop + h > allowedBottom`, zmniejsz `h` do `allowedBottom − newTop`,
        nie poniżej `minH(E)` (przesuń ile się da, resztę przytnij). Krawędź przycinana to ta przy pasku;
     3. **przycięcie blokujących:** jeśli E jest na minimum i nadal nie mieści się, `newTop = allowedBottom −
        minH(E)`. Wykonalność gwarantuje `newTop ≥ minTopMin(E)`. Blokujący nad E dostają przez to mniejszy
        `allowedBottom` i w swoim kroku przejścia 2 przesuwają się, a potem przycinają, według tych samych reguł.
   - Wynik nie wymaga wycofywania zmian, bo niewykonalne elementy są usuwane przed przejściem 2.
3. Szerokość/wysokość nigdy nie spada poniżej minimum elementu (minima jak w zadaniu 1).

#### 3.4 Reset w wolne miejsce (tylko dla resetu)
- Najpierw **obecny rozmiar** elementu (prostokąt użytkownika przycięty do granic), potem rozmiar resetu
  (dzisiejsze minima z `resetOverlappingRectangles()`, łącznie z `pipMinWidth / count - margin / 2`).
- Dla każdego rozmiaru: najpierw dawna pozycja domyślna (dzisiejsze wzory), potem kandydaci `x ∈ {margin} ∪
  {r.right + gap}`, `y ∈ {margin} ∪ {r.bottom + gap}` dla wszystkich zajętych prostokątów. Sortuj po `(y, x)`.
  Kandydat musi mieścić się w granicach i paskach, nie kolidować (z `gap`) z elementami niestandardowymi (wynik
  3.3, wcześniej zresetowane, stats) i nie wchodzić w zajęte komórki DB (`GridGeometry.cellsOf`).
- Nic się nie mieści → dawna pozycja domyślna w rozmiarze resetu, czyli dzisiejsze zachowanie: launcher przesunie
  standardowe elementy przez `handleConflictingViews()`.
- Kolejność resetów: najpierw PiP, potem date, music, radio. Każdy postawiony staje się przeszkodą dla
  następnych. Postawienie zapisuje też nowy prostokąt użytkownika (3.2).
- Dodawanie elementu w kreatorze, który nachodzi na standardowe elementy siatki, działa **jak dziś**. Nie
  zmieniaj tego (poza 3.7, jeśli potwierdzisz błąd).

#### 3.5 Integracja
- `Helpers.checkAndResetIfOverlappingOnScreen(int)`: sygnatura i semantyka zwracanej wartości bez zmian
  (`true`, gdy zapisano cokolwiek w narożnikach). Zbuduj model z prefs, odczytaj DB raz, uruchom resolver dla
  ekranu 0 (paski + nachodzenie) i pozostałych (tylko nachodzenie + reset), zapisz tylko zmienione narożniki.
  `trimRectsCoveredByBars()` z zadania 1 zastępujesz resolverem, bez dwóch równoległych ścieżek. `PipEdgeTrim`
  zostaje dostawcą `maxBottom`/`maxRight`/minimów.
- `resetOverlappingRectangles()`: rozmiary jak dziś, pozycja z 3.4.
- `DrawViewFirstScreen.fitRectanglesIntoCanvas()` dziś sam przesuwa i zmniejsza prostokąty **przed** `Helpers`,
  więc logika z DB nigdy by nie zadziałała w kreatorze. Nowa kolejność:
  1. jeśli któryś włączony prostokąt wystaje poza płótno → zapisz bez zmiany prostokątów użytkownika →
     `helpers.checkAndResetIfOverlappingOnScreen(-1)` → `initRectangle()` dla włączonych,
  2. dopiero potem `moveRectanglesInsideCanvas()` jako siatka bezpieczeństwa. Jeśli jeszcze coś zmienia,
     zaloguj ostrzeżenie (to rozjazd geometrii płótna i `getBarGeometry()`).
- Launcher: `processPendingUpdateOnResume()` woła `checkAndReset...` przed przebudową paneli PiP (bez zmian).
  Przesunięcia i przycięcia PiP idą istniejącą nieniszczącą ścieżką `WindowUtil.onPipGeometryChanged()`, bez
  restartu aplikacji.

#### 3.6 Testy (JUnit 5)
`CustomLayoutResolverTest`:
- wolne miejsce nad elementem → przesunięty o całe nachodzenie, rozmiar bez zmian,
- częściowo wolne → przesunięty o dostępne miejsce + przycięty o resztę,
- zajęta komórka DB w kolumnach elementu → stop na granicy rzędu, przy czym granica wynika ze wzoru
  `pointToCellExact`, łącznie z przerwą między komórkami; komórki pod pozycją wyjściową ignorowane,
- łańcuch: B nad A zepchnięty; B dochodzi do górnej granicy → A przycięte; A na minimum → B przycięte do minimum
  → A przesuwa się dalej; niewykonalne → reset tylko A, B nietknięte,
- kilka niewykonalnych → reset tego z największym `bottom`, reszta przeliczona,
- lewy pasek: wystaje z prawej → przesunięty w lewo, z przeszkodami po lewej,
- stats (`fixed`) nigdy nie jest ruszany i blokuje ruch,
- nachodzenie bez paska: widget vs PiP → reset widgetu; dwa widgety → późniejszy; pusty → reset,
- **odwracalność:** pasek rośnie → przesunięcie/przycięcie; pasek wraca → układ faktyczny == prostokąty
  użytkownika; dwukrotne uruchomienie daje ten sam wynik,
- `margin == 0` → elementy nigdy się nie stykają.

`ResetPlacementTest` (może być w tym samym pliku): obecny rozmiar mieści się → obecny rozmiar; nie mieści się →
minimum; domyślna wolna → domyślna; zajęta → pierwszy kandydat `(y, x)`; nic → domyślna w rozmiarze resetu.

`GridGeometryTest`: `cellsOf` zgodne z `pointToCellExact` (padding, pitch, przerwa, clamp, przesunięcie lewego
paska); granice rzędów/kolumn.

#### 3.7 (Do weryfikacji) elementy wiązane po elemencie niestandardowym
`handleConflictingViews()` (CellLayout ~5276) widzi tylko widoki dołączone w chwili wywołania (`postDelayed`
100–200 ms w `addCustomWidgetToGrid()`). `Workspace.addInScreen()` nie sprawdza obszarów elementów
niestandardowych. Ikona, folder albo widget związany później może więc wylądować pod widgetem/PiP. Ustal z kodu
kolejność (`bindItems`/`finishBindingItems` vs dodawanie elementów niestandardowych). Jeśli problem się
potwierdzi, po zakończeniu wiązania uruchom ponownie rozwiązywanie konfliktów dla elementów niestandardowych
strony (komórki są w `mUserWidgetCells` / placeholderach PiP), w **osobnym commicie**. Jeśli się nie potwierdzi,
opisz to w raporcie bez zmian w kodzie.

#### Pliki (Zadanie 3)
- nowe: `settings/CustomLayoutResolver.java`, `settings/GridGeometry.java` + testy
- `settings/Helpers.java`, `settings/DrawViewFirstScreen.java`
- `CellLayout.java` (publikacja geometrii; ewentualnie 3.7)
- bez zmian w API `LauncherModel` (używasz istniejących `getItemsInLocalCoordinates`, `loadWorkspaceScreensDb`)

#### Commity (Zadanie 3), każdy z testami i zielonym `testDebugUnitTest`
1. `GridGeometry` + publikacja z `CellLayout` + odczyt siatki zajętości z DB (bez zmiany zachowania).
2. Prostokąty użytkownika (klucze `User*`, migracja, zapis w kreatorze tylko dla dotkniętych elementów).
3. `CustomLayoutResolver` + integracja w `Helpers` (zastępuje przycinanie z zadania 1) + kolejność w kreatorze.
4. Reset w wolne miejsce (3.4).
5. (Tylko jeśli potwierdzone) 3.7.

---

### Zadanie 4 – dual PiP: proporcja suwaka + minimum panelu

Stan: `WindowHostDualPane` trzyma podział jako proporcję (`dual_split_ratio` w `pip_window_host_prefs`,
domyślnie 0.5, `MIN_SPLIT_RATIO` 0.25 / `MAX_SPLIT_RATIO` 0.75). Szerokość lewego panelu
`leftW = clamp(round(total * ratio), round(total * 0.25), round(total * 0.75))` w `applySplit()` (~1077), ~1243,
~1554 i w przeciąganiu (`onTouch` ACTION_DOWN ~1953). Po zmianie szerokości PiP suwak przesuwa się więc
proporcjonalnie. Przy przyciętym do minimum dual PiP panel 25% może jednak być bardzo wąski.

Wymaganie:
1. **Proporcja zostaje.** Sprawdź, że po przesunięciu, przycięciu i resecie (zadanie 3) panel faktycznie dostaje
   nowe granice: `onPipGeometryChanged()` → `updateBounds()` → `applySplit(true)`, liczone od proporcji. Jeśli
   któraś ścieżka zmienia granice bez `applySplit`, napraw ją.
2. **Minimum panelu.** Żaden panel nie może być węższy niż minimum pojedynczego PiP przy dwóch włączonych,
   czyli `PipEdgeTrim.pipMinWidth("pipFirst", calculatedPipMinWidth, true, true, false, false)` = połowa minimum
   dual, ale nie więcej niż `total / 2`. Czysta funkcja, np. `DualSplitBounds.bounds(total, minPanePx)` → `{minW,
   maxW}` z `minW = max(round(total * MIN_SPLIT_RATIO), minPanePx)`, `maxW = total − minW`. Użyj jej we wszystkich
   czterech miejscach.
3. **Zapisana proporcja się nie zmienia** przez samo ograniczenie, tylko przez przeciągnięcie. Gdy PiP znów się
   poszerzy, wraca podział użytkownika.
4. Testy JUnit 5: szeroki PiP → ograniczenie 25/75 bez zmian; PiP o minimalnej szerokości → oba panele
   ≥ `minPanePx`; `minPanePx > total/2` → oba po `total/2`; proporcja zapisana nie jest nadpisywana.

#### Pliki (Zadanie 4)
- `app/src/main/java/com/syu/util/WindowHostDualPane.java`
- nowa czysta klasa (np. `com/syu/util/DualSplitBounds.java`) + test

---

### Weryfikacja całości
- `./gradlew :app:testDebugUnitTest` po każdym zadaniu, na końcu `:app:assembleDebug`, jeśli się da.
- Raport: commity, wyniki testów i buildu (dosłownie). Wypisz, co wymaga sprawdzenia na urządzeniu:
  - zwiększenie paska dolnego przy widgetach i PiP z wolnym / częściowo wolnym / zajętym miejscem nad nimi,
  - włączenie lewego paska,
  - ikony, które wczytują się po elementach niestandardowych (3.7),
  - reset w wolne miejsce,
  - dual PiP przy minimalnej szerokości.
