# Launcher Mod: pasek u góry pod paskiem statusu, przycisk albo uchwyt, strzałka po prawej, pasek pionowy na każdej stronie, dotyk pod uchwytem na Androidzie 10 — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `6080ce99`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`. `settings/` to `…/launcher66/settings/`, a `S/` to `app/src/main/java/com/syu/util/`.

## 0. Commity (w tej kolejności)

| # | Temat commita | Źródło |
|---|---|---|
| D1 | `Bars: the horizontal bar and its handle at the top start below the status bar on every device` | właściciel, pkt 1 |
| D2 | `Bars: the collapsed bar's button only on the handle's side, its arrow turned on the right` | właściciel, pkt 2 i 4; przegląd C9/C10 |
| D3 | `Bars: the vertical bar on every page` | właściciel, nowa opcja |
| D4 | `Edge handle: every touch but the opening swipe goes to what is under it, as under the stats window` | właściciel, pkt 5 |

- **Każdy commit buduje się samodzielnie i przechodzi testy.** Po każdym pushu poczekaj na zielone CI, zanim zaczniesz następny.
- D3 stoi na D2.

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

**Testy:** JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `BarLayoutTest`, `HorizontalBarPlacementTest`, `HorizontalBarEdgeGestureTest`, `PersistentBarWindowTest`. Logikę pisz w **czystych klasach bez `android.*`**.

**Stringi:** nowy string dodajesz do **wszystkich 59** plików `res/values*/strings.xml`, z tłumaczeniem na język danego pliku. Bez nowych zależności.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/`.

## 2. Fakty

### 2.1 Przegląd rundy 8 (`a64a2e90`…`6080ce99`)
CI wszystkich 10 commitów jest zielone. Właściciel potwierdza, że wszystko działa poza zgłoszeniami z tej rundy, a zmian dla 7870 nie ma jak sprawdzić.

**Poprawne:**
- C1 (`PaneLaunchFlags`, flagi zastąpione, log przejęcia);
- C2 (`StockRedraw`, ścieżki pauzy i aktualizacji dla nakładki, pętla 500 ms według `fytLoopPlaying()`, okno 2 s po kliknięciu, logi);
- C6 (`FytRatingBridgeStarter`, `BridgeStartPolicy`).

**Do poprawy:**
- **C3 nie działa** (zgłoszenie 5): na FYT z Androidem 10 dotyk pod uchwytem dalej nie dochodzi do aplikacji. D4 zastępuje tę drogę.
- **C9: `BarLayout` nie jest używana.** Nie ma żadnego `new BarLayout(` poza testem, a reguły pasków czytają prefy osobno w 8 plikach:
  - `CellLayout` ≈1588, ≈1594, ≈4477;
  - `Workspace` (8 miejsc);
  - `settings/Helpers` ≈660, ≈1332;
  - `settings/CanbusService` ≈840;
  - `S/WindowUtil` ≈2667;
  - `settings/CreatorFirstScreen`, `settings/CreatorOtherScreens` ≈114;
  - `settings/SettingsFragmentSecond`.
  Brief C9 kazał, żeby geometria szła z `BarLayout`. D2 i D3 to naprawiają dla reguł, które zmieniają.
- **C10: komórka narożna stoi nie tam, gdzie uchwyt.** `CellLayout.cornerCellX()` (≈1592) bierze stronę **paska pionowego** (`VERTICAL_BAR && VERTICAL_BAR_RIGHT`). Przy uchwycie po prawej bez paska pionowego (albo z paskiem pionowym po lewej):
  - zarezerwowana komórka jest w lewym rogu;
  - prawy róg, nad którym leży uchwyt, przyjmuje ikony.

### 2.2 Pasek u góry z auto-hide wchodzi na pasek statusu (A55, Android 16)
- **Wiersze, które o tym decydują:**
  - `Workspace.topBarOffset()` (≈1557) zwraca **0 w pionie** („nothing in portrait”), a w poziomie wymiar `status_bar_height` (`Launcher.getStatusBarHeight()` ≈3505).
  - Nakładka (`showOverlayHorizontalBar`) ma `gravity = TOP`, `y = topBarOffset()` (≈1773–1774), szerokość `MATCH_PARENT` i `LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES`.
  - Uchwyt dostaje tę samą wartość: `setPlacement(top, right, topBarOffset())` (≈2803 → `HorizontalBarEdgeHandle` ≈116–131, ≈250–262).
- **Skutek:**
  - W pionie oba okna zaczynają się od y=0, pod paskiem statusu i wycięciem aparatu.
  - W poziomie zaczynają się od x=0, czyli także w bocznym wycięciu (`SHORT_EDGES`), a y bierze wymiar zasobu zamiast prawdziwego insetu.
  - Tę samą nakładkę dostaje pasek na każdej stronie u góry.
- **Dlaczego pasek bez auto-hide jest dobrze:** leży w drzewie widoków strony, więc układ stawia go od góry pudełka strony, poniżej paska statusu. Na FYT w poziomie `topBarOffset()` zgadza się z tą górą.

### 2.3 Przycisk zwiniętego paska kontra uchwyt
- **Kiedy jest przycisk:** `HorizontalBarPlacement.bar` (≈38–56) przy auto-hide zwraca `page == 0 && verticalBar ? BUTTON : HANDLE`. Strona uchwytu (`EDGE_HANDLE_RIGHT`) i strona paska pionowego (`VERTICAL_BAR_RIGHT`) się nie liczą.
  - `Workspace` ≈947: `mEdgeHandleMode = autoHide && (!verticalBar || mEveryPage)`.
  - `hideNormalHorizontalBar` (≈1677) chowa całość tylko przy `mEdgeHandleMode && !mVerticalBar`, a inaczej zostawia przycisk.
  - Przy pasku pionowym po prawej i uchwycie po lewej (albo odwrotnie) strona 0 ma więc przycisk, a uchwytu nie ma.
- **Gdzie jest przycisk:** `show_bar` (`@drawable/show_bar`) jest wyśrodkowany na `iv_list_bg` (`Start/End_toStartOf/EndOf iv_list_bg` w `custom_layout_*_user_vertical.xml`).
  - `BarConstraints.apply` (≈60–66) przesuwa zwinięty `iv_list_bg` na stronę paska pionowego, a strzałka zostaje bez obrotu.
  - Przycisk na stronie: `show_bar` ≈1606, ≈1668, ≈2659. W nakładce: ≈2016, ≈2125, ≈2352.

### 2.4 Pasek pionowy dziś jest tylko na stronie 0
- **Układ:** `rl_vertical_bar` należy do układu strony 0 (`custom_layout_*_user_vertical.xml`, `custom_layout_one.xml`).
- **Wymiary i przesunięcia tylko dla strony 0:**
  - `CellLayout.isVerticalBarOffsetActive` (≈4468, `currentScreen != 0 → false`);
  - `S/WindowUtil` ≈2667 (`pipScreen == 0`);
  - `settings/CanbusService` ≈840, `settings/Helpers` ≈660;
  - `GridGeometry.cellsOf`, `settings/CustomLayoutResolver.verticalBarOffset`, `settings/PipEdgeTrim`;
  - kreatory: `CreatorFirstScreen` ma pasek pionowy, `CreatorOtherScreens` / `DrawViewOtherScreens` go nie mają.
- **Wzór dla paska poziomego na każdej stronie:**
  - reguły: `HorizontalBarPlacement` (EMBEDDED / PERSISTENT_OVERLAY / HANDLE / BUTTON / NONE, `reserve`);
  - stan okna: `PersistentBarWindow` (NONE / STANDBY / SHOWN; BUILD_LATER / BUILD_NOW / ACTIVATE / PARK / REMOVE);
  - obsługa: `Workspace.updatePersistentBar` (≈2870), `showPersistentOverlay` (≈2949), `activatePersistentOverlay` (≈2980), `parkPersistentOverlay` (≈3010), `persistentBarFree`.
  - Przełącznik w ustawieniach: `SettingsFragmentSecond` ≈369, ≈786, ≈1231 (opis „no overlay” bez uprawnienia).
- **`BarLayout`** zakłada pasek pionowy tylko na stronie 0 (`pageInsets(firstPage, …)`) i pasek poziomy zawsze obecny (`verticalBarBand` kończy się na pasku poziomym).

### 2.5 Dotyk pod uchwytem na Androidzie 10: dlaczego okno statystyk przepuszcza, a uchwyt nie
- **Okno statystyk** (`settings/CanbusService` ≈895–905) ma stale `FLAG_NOT_TOUCHABLE`. Dyspozytor wejścia w ogóle go nie bierze pod uwagę i daje dotyk oknu pod spodem: także oknu aplikacji na wirtualnym displayu panelu, bez żadnego przekazywania przez launcher.
- **Uchwyt** łapie dotyk sam (okno klikalne) i oddaje go programowo:
  - `dispatchTouchEvent` do drzewa widoków;
  - od C3 `EdgeInject` dla `ActivityView` (`EdgePassRoute`, `EdgeInject`).
  - Na FYT z Androidem 10 (launcher systemowy, panele `ActivityView`) to nie dociera do aplikacji.
- **Monitor wejścia:** `S/UserTouches` (≈149–196) ma działający monitor na displayu 0.
  - Ukryte `InputManager.monitorGestureInput(name, displayId)`, `InputEventReceiver` na własnym `HandlerThread`, `finishInputEvent` zawsze.
  - Wymaga uprawnień systemowych (`LauncherApplication.hasSystemPrivileges()`, `MONITOR_INPUT`).
  - Monitor widzi każdy dotyk na ekranie, nie zabierając go.
  - `InputMonitor.pilferPointers()` (API 29+) odbiera trwający gest oknom pod spodem (dostają `ACTION_CANCEL`). Tak działa gest wstecz SystemUI.
- **Wykluczenie gestów:** okno z `FLAG_NOT_TOUCHABLE` nie daje wykluczenia gestów systemowych. Uchwyt traci je w tym trybie.

---

## D1 — `Bars: the horizontal bar and its handle at the top start below the status bar on every device`
1. **`Workspace.barBoxOnScreen()` → `Rect`:** prostokąt na ekranie widoku, który wypełniają układy stron. Jego góra to miejsce, od którego zaczyna się pasek u góry na stronie, a ten według właściciela jest dobrze na obu urządzeniach.
   - Liczony z `getLocationOnScreen` + rozmiaru, po układzie.
   - Przed pierwszym układem: z `getRootWindowInsets()` okna launchera (pasek statusu + wycięcie: góra, lewo, prawo).
2. **Pasek u góry (auto-hide i pasek na każdej stronie):** okno nakładki ma `gravity = TOP | LEFT`, `x = box.left`, `y = box.top`, `width = box.width()` (zamiast `MATCH_PARENT`). Przy pasku na dole nic się nie zmienia.
3. **Uchwyt u góry:** `y = box.top`.
   - Po lewej `x = box.left`.
   - Po prawej (`gravity RIGHT`, `x` liczone od prawej krawędzi) `x = szerokośćEkranu − box.right`.
   - `setPlacement` dostaje prostokąt zamiast `topOffset`.
4. **`topBarOffset()` usuń** po `rg`.
5. **Ponowne ułożenie:** gdy pudełko się zmienia (obrót, zmiana insetów, `onLayout` widoku pudełka), nakładka u góry i uchwyt układają się od nowa.
6. **Czysta klasa `TopBarFrame`:**
   - `overlay(boxLeft, boxTop, boxRight)` → x, y, szerokość;
   - `handle(boxLeft, boxTop, boxRight, screenWidth, right)` → x, y.
   - Test `TopBarFrameTest`:
     - pion z wycięciem u góry (box.top = pasek statusu) → y = box.top;
     - poziom z wycięciem z lewej (box.left > 0) → x = box.left, a po prawej x liczone od prawej;
     - FYT w poziomie (box.top = pasek statusu, box.left = 0).
7. **Log raz na zmianę:** `Horizontal bar at the top: box <l,t,r,b> on screen`.

## D2 — `Bars: the collapsed bar's button only on the handle's side, its arrow turned on the right`
1. **`HorizontalBarPlacement.bar` dostaje stronę paska pionowego i stronę uchwytu.**
   - Przy auto-hide wynik to **BUTTON tylko wtedy**, gdy na tej stronie jest pasek pionowy **i** `VERTICAL_BAR_RIGHT == EDGE_HANDLE_RIGHT`.
   - W każdym innym wypadku (także przy pasku pionowym po drugiej stronie) wynik to **HANDLE**.
   - W D2 „na tej stronie jest pasek pionowy” znaczy strona 0 z włączonym paskiem. D3 rozszerza to na inne strony.
   - Test `HorizontalBarPlacementTest`: obie strony × pasek pionowy wł./wył. × strona 0 i inna × ruch stron.
2. **`Workspace` bierze tryb tylko z tej reguły:**
   - `mEdgeHandleMode` (≈947) i `shouldShowEdgeHandle` (≈2748);
   - `hideNormalHorizontalBar` (≈1677): gdy na stronie 0 jest HANDLE, z zwiniętego paska nie zostaje nic, ani tło, ani `show_bar`, jak dziś bez paska pionowego. Pasek pionowy zostaje w swoim miejscu i wysokości, bez przycisku;
   - `setCollapsedBarShown` (≈2643).
3. **Strzałka:** `show_bar` przy pasku pionowym po prawej ma `setRotation(180f)`, a po lewej `0f`.
   - Ustaw raz po inflacji, razem z `BarConstraints` (`applyBarConstraints` ≈1563).
   - Dotyczy strony i nakładki, wszędzie tam, gdzie `show_bar` widać w rogu paska pionowego.
4. **Komórka narożna:** strona komórki zarezerwowanej przy auto-hide to **strona uchwytu** (`EDGE_HANDLE_RIGHT`). Przy przycisku to ta sama strona, bo przycisk jest tylko przy zgodnych stronach.
   - `CellLayout.cornerCellX` (≈1592) i `cornerCellY` idą przez `BarLayout`.
   - `BarLayout` dostaje `handleRight`; `cornerCellX` liczy ze strony uchwytu, a `collapsedButton()` ze strony paska pionowego.
   - `BarLayoutTest`: róg dla 4 kombinacji stron.
5. **Jedno źródło reguł:**
   - Fabryka `BarLayouts.of(SharedPreferences, …)` w `settings/` (czyta prefy raz) buduje `BarLayout`.
   - Reguły zmieniane w D2 (komórka narożna, przycisk albo uchwyt, obrót strzałki) czytają ją, a nie prefy wprost.

## D3 — `Bars: the vertical bar on every page`
1. **Ustawienie:** `SwitchPreferenceCompat` z kluczem `vertical_bar_every_page` (`Keys.VERTICAL_BAR_EVERY_PAGE`, domyślnie false) w „Bars”.
   - Miejsce: między `vertical_bar_right` a `choose_vertical_bar_background`, czyli tak, jak pasek poziomy ma „na każdej stronie” pod swoją pozycją. Widoczne tylko z włączonym paskiem pionowym.
   - Tytuł: nowy string `vertical_bar_every_page` „Vertical bar on every page”.
   - `summaryOn` / `summaryOff` / opis bez uprawnienia: istniejące `horizontal_bar_every_page_on`, `_off` i `_no_overlay`. Mają ogólną treść, więc nie tworzysz kopii; sprawdzanie uprawnienia tak jak ≈1231.
   - Klucz woła `setBarSettingsChanged(true)`.
2. **Czysta klasa `VerticalBarPlacement.bar(page, everyPage, pageMoving, userLayout)`** (lustro `HorizontalBarPlacement`):
   - strona 0 w spoczynku → EMBEDDED;
   - z opcją: inne strony i każda strona w ruchu → PERSISTENT_OVERLAY (pasek strony 0 odjeżdża ze stroną, więc okno jest od pierwszej chwili ruchu);
   - bez opcji: inne strony → NONE.
   - `verticalOnPage = verticalBar && (page == 0 || (everyPage && userLayout))`.
   - Test `VerticalBarPlacementTest`.
3. **`HorizontalBarPlacement.bar`** (D2) używa `verticalOnPage`. Na innych stronach przy auto-hide, pasku pionowym i zgodnej stronie jest więc BUTTON (pkt 5).
4. **`BarLayout`:**
   - `verticalBar` znaczy „pasek pionowy na tej stronie”;
   - nowy parametr `horizontalOnPage`: bez paska poziomego na stronie pasek pionowy ma pełną wysokość i nie ma rogu.
   - Testy: 4 kombinacje stron × poziomy na stronie tak/nie × pionowy na stronie tak/nie.
5. **Okno paska pionowego** na innych stronach i w ruchu.
   - Drugi egzemplarz stanu `PersistentBarWindow`, sterowany z tego samego miejsca co pasek poziomy (`updatePersistentBar`). Te same wyzwalacze i te same reguły zajętości (`persistentBarFree`, wszystkie aplikacje, przegląd, przeciąganie, folder, launcher w tle) oraz standby, aktywacja i odstawienie.
   - Typ i flagi jak nakładka paska poziomego (`TYPE_APPLICATION_OVERLAY`, `NOT_FOCUSABLE`, `NOT_TOUCH_MODAL`, `LAYOUT_IN_SCREEN`, `NOT_TOUCHABLE` w standby).
   - Bez animacji przesuwania (`PaneWindows.disableMoveAnimation`).
   - Położenie: pasmo z `BarLayout` przesunięte o `barBoxOnScreen()` z D1.
   - Treść: pasek pionowy z tą samą listą aplikacji, kliknięciami i długim przytrzymaniem co na stronie 0 (`LauncherAppBars`) i z tłem `VERTICAL_BAR_SELECTED_BACKGROUND`. Czego nie da się zrobić w osobnym oknie (przeciąganie do paska), jest jak w oknie paska poziomego na każdej stronie; opisz to w commicie.
   - Gdy na stronie wychodzi BUTTON (pkt 3), okno obejmuje też róg i pokazuje tam `show_bar` (obrót z D2).
     - Tapnięcie robi to samo, co uchwyt (`onEdgeHandleTriggered`).
     - Przycisk gaśnie i wraca razem z wysuwaniem paska jak `setCollapsedBarShown`.
6. **Inne strony z paskiem pionowym** mają geometrię jak strona 0: przesunięcia, `maxRight`, komórki i prostokąty widżetów, PiP, statystyki i kreator.
   - Wszystkie miejsca z §2.4, które dziś sprawdzają „strona 0”, pytają `BarLayout` o „pasek pionowy na tej stronie”.
   - `CreatorOtherScreens` / `DrawViewOtherScreens` rysują pasmo paska pionowego po jego stronie, jak `CreatorFirstScreen`.
   - Prostokątów użytkownika nie kasujesz: istniejące dopasowanie (`checkAndResetIfOverlappingOnScreen`) przesuwa te, które wchodzą w pasmo.
7. **Log:**
   - `Persistent vertical bar: <action> (<reason>)` przy każdej akcji;
   - `Vertical bar on page <n>: <embedded|overlay|none>` raz na zmianę.

## D4 — `Edge handle: every touch but the opening swipe goes to what is under it, as under the stats window`
1. **Tryb monitora**, gdy launcher ma uprawnienia systemowe, API ≥ 29 i monitor wystartuje.
   - Okno uchwytu ma **stale `FLAG_NOT_TOUCHABLE`**, jak okno statystyk (≈895–905): tylko pokazuje pasek.
   - Gest wykrywa osobny monitor `EdgeSwipeMonitor` (wzór `S/UserTouches` ≈149–196): własny `HandlerThread`, nazwa `launcher66-edge-handle`.
     - Tworzony, gdy uchwyt się pokazuje; usuwany (`dispose()`, `quit()`), gdy się chowa albo jest zwalniany.
     - Każde zdarzenie kończy `finishInputEvent(event, false)`.
2. **Zasada właściciela: w całym obszarze uchwytu (widoczny pasek + przezroczysty pas) uchwyt łapie wyłącznie swipe do środka. Kliknięcie i cała reszta przechodzą do tego, co jest pod spodem.**
   - Decyzje w monitorze: zdarzenia w współrzędnych displayu 0; prostokąt okna podaje wątek główny przez pola `volatile`.
   - **DOWN w obszarze okna** → obserwacja według `HorizontalBarEdgeGesture` (te same progi co dziś: `dx ≥ slop` do środka i przewaga poziomu `HORIZONTAL_DOMINANCE`, strona z C10):
     - **OPEN_BAR** → natychmiast `pilferPointers()` i otwarcie paska na wątku głównym (to samo, co dziś przy swipe).
       - Aplikacja pod spodem dostaje `ACTION_CANCEL` zamiast `UP`, więc nie powstaje u niej ani kliknięcie, ani dalsze przeciąganie.
       - Do chwili decyzji widziała tylko DOWN i ruch nie dłuższy niż `slop`. Tak samo działa gest wstecz SystemUI.
       - Reszta gestu (MOVE / UP) idzie dalej do monitora i nic już nie robi.
     - **PASS** (ruch w pionie, ruch do krawędzi) → koniec obserwacji, bez `pilferPointers()`.
     - **UP przed decyzją** (kliknięcie) i **długie przytrzymanie bez ruchu** → koniec obserwacji, bez `pilferPointers()`.
   - **Aplikacja pod spodem dostaje wszystko poza rozpoznanym swipe'em**, bez pośrednictwa launchera: kliknięcia (także na samym widocznym pasku), przeciągnięcia w pionie, długie przytrzymanie, wielopalcowe gesty.
   - **Zmiana zachowania w trybie monitora:** kliknięcie na widocznym pasku nie otwiera już paska, tylko przechodzi pod spód; pasek otwiera swipe. W trybie okna (pkt 3) zostaje jak dziś. Opisz to w Javadoc i w commicie.
   - Śledzisz tylko pierwszy wskaźnik. Drugi palec przed decyzją kończy obserwację (PASS).
   - DOWN poza oknem → nic.
   - Wywołania przez refleksję: `monitorGestureInput`, `getInputChannel`, `pilferPointers`, `dispose`, jak w `UserTouches`.
3. **Tryb okna (bez zmian),** gdy monitor nie wystartuje albo nie ma uprawnień systemowych (wersja standard, Android 8–9): obecne klikalne okno z przekazywaniem (`EdgePassRoute`, `EdgeInject`, `EdgeHandlePass`).
4. **Czyste klasy:**
   - `EdgeHandleInput.mode(sdk, systemPrivileges, monitorStarted)` → MONITOR / WINDOW.
   - `EdgeMonitorTracker` (stan obserwacji jednego gestu) przyjmuje kolejne zdarzenia (akcja, x, y, czas, liczba wskaźników) i zwraca NONE / PILFER_AND_OPEN / STOP. W środku korzysta z `HorizontalBarEdgeGesture`.
   - Testy:
     - `mode`: API 26–36 × uprawnienia × start monitora;
     - tracker, dla obu stron, u góry i u dołu:
       - kliknięcie w pasie i na pasku → STOP, nigdy PILFER;
       - długie przytrzymanie bez ruchu → STOP;
       - ruch w pionie → STOP;
       - ruch do krawędzi → STOP;
       - swipe do środka → PILFER_AND_OPEN dokładnie raz, przy przekroczeniu progu;
       - drugi palec → STOP;
       - DOWN poza oknem → NONE.
5. **Wykluczenie gestów:** w trybie monitora okno nie daje wykluczenia gestów systemowych (okno nieklikalne). Opisz to w Javadoc i w commicie. Tryb okna zachowuje wykluczenie jak dziś.
6. **Logi:**
   - raz przy każdym pokazaniu: `Edge handle input: <monitor|window> (<powód>)`;
   - przy decyzji: `Edge handle: swipe -> open (pilfered)` (innych decyzji nie logujesz, żeby nie było linii na każde kliknięcie).

## 3. Czego NIE zmieniać
- Paska poziomego na dole (nakładka, uchwyt, insety dolne).
- Widocznego paska uchwytu (szerokość, kolor, alpha) ani reguł `HorizontalBarEdgeGesture` poza wejściem z monitora.
- Wartości kluczy prefów i prostokątów użytkownika.
- C1, C2, C4–C6 rundy 8.

## 4. Weryfikacja
1. CI zielone po każdym commicie, a nowe testy przechodzą: `TopBarFrameTest`, rozszerzone `HorizontalBarPlacementTest` i `BarLayoutTest`, `VerticalBarPlacementTest`, `EdgeHandleInputTest`.
2. `rg -n 'getBoolean\(Keys\.(VERTICAL_BAR_RIGHT|EDGE_HANDLE_RIGHT|VERTICAL_BAR_EVERY_PAGE)' app/src/main/java` → tylko fabryka `BarLayouts` i ustawienia. Wynik wklej do raportu.
3. `rg -c 'name="vertical_bar_every_page"' app/src/main/res | wc -l` → 59.
4. **Scenariusze dla testera.** Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) A55, pion i poziom, pasek u góry + auto-hide: uchwyt i wysunięty pasek zaczynają się pod paskiem statusu i nie wchodzą w wycięcie. Ten sam test z paskiem na każdej stronie. FYT jak dotąd.
   - b) Pasek pionowy po prawej + uchwyt po prawej + auto-hide: przycisk w prawym rogu, strzałka odwrócona.
   - c) Pasek pionowy po prawej + uchwyt po lewej (i odwrotnie): uchwyt po lewej działa, pasek pionowy jest bez przycisku, a lewy róg nie przyjmuje ikon.
   - d) Pasek pionowy na każdej stronie:
     - wszystkie strony mają pasek po wybranej stronie, nieruchomy przy przesuwaniu;
     - widżety, PiP, statystyki i kreator innych stron nie nachodzą na pasek;
     - z auto-hide i zgodną stroną inne strony mają przycisk;
     - bez uprawnienia nakładki opis ustawienia o tym mówi.
   - e) FYT z Androidem 10, launcher systemowy, auto-hide, uchwyt po lewej i po prawej, pasek u góry i u dołu:
     - kliknięcie (także na samym widocznym pasku), przeciągnięcie w pionie i długie przytrzymanie w obszarze uchwytu nad panelem PiP i nad widżetem trafiają w aplikację albo widżet;
     - swipe do środka otwiera pasek, a aplikacja pod spodem nie reaguje na niego ani kliknięciem, ani przewinięciem (dostaje CANCEL);
     - w logu jest `Edge handle input: monitor` i przy swipe `Edge handle: swipe -> open (pilfered)`.
     To samo na 11+ z launcherem systemowym. Wersja standard jak dotąd (tryb okna).

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Każdy commit (hash i temat) z wynikiem CI.
- Wyniki `rg` z §4.2 i §4.3.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.4.
