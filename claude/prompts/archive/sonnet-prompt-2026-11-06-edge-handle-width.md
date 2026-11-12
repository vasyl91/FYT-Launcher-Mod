# Launcher Mod: uchwyt paska dolnego (auto-hide) szeroki jak pasek boczny — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `5e3fb395`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

## 0. Commit

| # | Temat commita | Źródło |
|---|---|---|
| C1 | `Edge handle: the swipe is caught across the width of the left bar` | prośba właściciela |

**Commit buduje się samodzielnie i przechodzi testy.** Po wypchnięciu poczekaj na zielone CI.

## 1. Zasady pracy

**Język i treść:**
- Komentarze, Javadoc, `Log.*` i opis commita piszesz **wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, które wyjaśniają *dlaczego*.
- **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.

**Commit:**
- Temat z tabeli §0. Treść zawijaj na ~72 znaki i wpisz do niej fakty z §2.
- Zakończ commit dokładnie trailerami z system-remindera sesji.
- Push: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy, z odstępem 2/4/8/16 s.

**CI:**
- Workflow to `.github/workflows/build.yml`. Sprawdzaj run commita przez GitHub MCP (`actions_list`, `get_job_logs`).
- Czerwony build naprawiasz kolejnym commitem. Bez amend i bez force-push.
- Przed pushem uruchom lokalnie `./gradlew :app:testSystemDebugUnitTest`.

**StrictMode jest włączony:** bez I/O, bazy, `ContentResolver`, sieci, `su` i blokujących wywołań hosta VD na wątku głównym.

**Testy:** JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `settings/PipEdgeTrimTest`, `BottomBarEdgeGestureTest`. Logikę pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:** bez nowych zależności, bez nowych stringów i bez nowych kluczy prefów.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/`.

## 2. Fakty

### 2.1 Przegląd rundy 6 (`ea203541`, `cced3912`, `5e3fb395`): bez błędów do naprawy
CI wszystkich trzech commitów jest zielone, a właściciel potwierdza, że działają. Sprawdzone i poprawne:
- **Kreatory:**
  - `touchedKeys` przy strzałkach w obu kreatorach;
  - prostokąt użytkownika w `DrawViewOtherScreens` zapisywany tylko dla zmienionych prostokątów.
- **Napis o podwójnym tapnięciu:**
  - `CreatorBarToggle` w tapnięciu i w napisie;
  - `screen_number` w 51 plikach.
- **Callbacki canbus:**
  - statyczne `RecorderCallback` i `StatsCallback`;
  - `release()` po wyrejestrowaniu we wszystkich ścieżkach `CanbusAutoCheck` i czytnika, a `fixes()` i `freeze()` to kopie;
  - `detach()` w `CanbusService.onDestroy`;
  - Toast z kontekstu aplikacji.

Kodu rundy 6 nie zmieniasz.

### 2.2 Szerokość uchwytu dziś
- `Workspace.applyEdgeHandleGeometry` (≈2716) liczy szerokość okna uchwytu, czyli pas, który łapie swipe w prawo:
  - `stripWidth = max(1, round(longerEdge · STRIP_WIDTH_FRACTION))`, gdzie `STRIP_WIDTH_FRACTION = 0,01` (widoczny pasek);
  - `touchMargin = max(MIN_TOUCH_MARGIN_DP · density, round(longerEdge · TOUCH_MARGIN_FRACTION))`, gdzie `MIN_TOUCH_MARGIN_DP = 24` i `TOUCH_MARGIN_FRACTION = 0,035`;
  - `touchWidth = stripWidth + touchMargin`, przekazywane do `BottomBarEdgeHandle.setGeometry` (≈104).
- Stałe są w `BottomBarEdgeHandle` (≈50–56). Javadoc klasy (≈26–45) i README (wiersz ≈24: „The handle has a wider transparent margin…”) opisują ten margines.
- **Szerokość paska bocznego** jest liczona procentowo:
  - poziomo: 7,1% szerokości (`layout_constraintWidth_percent="0.071"`);
  - pionowo: 7,1% wysokości od góry do paska dolnego (`layout_constraintDimensionRatio="W,0.071"`).
  - Launcher trzyma ją w `Launcher.calculatedLeftBarWidth` (≈1849 / ≈1855), z której korzystają `CellLayout` i panele PiP.
  - Czysta funkcja `settings/PipEdgeTrim.computeLeftBarWidth(portrait, rootWidth, rootHeight, barHeight)` (≈62) liczy ją z tych samych reguł i ma test.
  - `Helpers` (≈583) wybiera jedną z nich: `Launcher.calculatedLeftBarWidth > 0 ? ta wartość : BottomBarDimensions.computeLeftBarWidth(…)`.

## C1 — `Edge handle: the swipe is caught across the width of the left bar`
1. **Szerokość okna uchwytu = szerokość paska bocznego** dla bieżącej orientacji.
   - Źródło jak w `Helpers` ≈583: `Launcher.calculatedLeftBarWidth`, a gdy jest 0, `PipEdgeTrim.computeLeftBarWidth(portrait, Launcher.screenWidth, Launcher.screenHeight, getBottomBarHeight(…))`.
   - Ta sama szerokość obowiązuje na każdej stronie z uchwytem: na pierwszej bez lewego paska i na pozostałych przy „Bottom bar on every page”.
2. **Czysta klasa `EdgeHandleGeometry`** (bez `android.*`) z `static int touchWidth(int stripWidth, float leftBarWidth)`:
   - zwraca `max(stripWidth, round(leftBarWidth))`;
   - widoczny pasek zawsze mieści się w oknie.
3. **`applyEdgeHandleGeometry`** liczy `stripWidth` jak dziś i przekazuje `EdgeHandleGeometry.touchWidth(stripWidth, leftBarWidth)`.
   - `TOUCH_MARGIN_FRACTION` i `MIN_TOUCH_MARGIN_DP` usuń po `rg`.
   - Widoczny pasek (`STRIP_WIDTH_FRACTION`), wykluczenie gestów systemowych i reguły `BottomBarEdgeGesture` (OPEN_BAR / PASS) zostają bez zmian.
4. **Opisy.**
   - Javadoc `BottomBarEdgeHandle` i komentarz w `applyEdgeHandleGeometry` mówią, że okno (pas, który łapie swipe) jest tak szerokie jak pasek boczny, liczony procentowo jak ten pasek.
   - README, wiersz ≈24: „The handle catches the swipe across the width of the left bar (7.1 % of the screen)…”. Reszta zdania o przekazywaniu tapnięcia i przeciągnięcia zostaje.
5. **Test `EdgeHandleGeometryTest`:**
   - `touchWidth` dla 1280×720 poziomo: pasek boczny ≈91 px (`PipEdgeTrim.computeLeftBarWidth(false, 1280, 720, …)`), pasek 13 px → 91;
   - pionowo dla 1080×2340 z paskiem 105 px;
   - `leftBarWidth` mniejsze niż pasek → szerokość paska.
6. **Log raz przy zmianie geometrii:** `Edge handle geometry: strip <s> px, touch <t> px (left bar width)`.

## 3. Czego NIE zmieniać
- Widocznego paska uchwytu (szerokość, kolor, zaokrąglenia, alpha).
- Reguł gestu (`BottomBarEdgeGesture`), przekazywania dotyku i odroczonego ukrycia (`EdgeHandlePass`).
- Kodu rund 5 i 6.

## 4. Weryfikacja
1. CI zielone, `EdgeHandleGeometryTest` przechodzi.
2. `rg 'TOUCH_MARGIN_FRACTION|MIN_TOUCH_MARGIN_DP'` → zero.
3. Scenariusze dla testera. Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Auto-hide, bez lewego paska, poziomo: swipe w prawo zaczęty w dowolnym miejscu pasa szerokiego jak pasek boczny (ok. 7% szerokości ekranu) otwiera pasek. Zaczęty dalej w prawo nie otwiera.
   - b) To samo pionowo.
   - c) Tapnięcie, przeciągnięcie w pionie i długie przytrzymanie w tym pasie trafiają do widżetu albo panelu pod spodem jak dotąd.
   - d) „Bottom bar on every page” z auto-hide i z lewym paskiem: uchwyt na stronach 2…n ma tę samą szerokość.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commit (hash i temat) z wynikiem CI.
- Szerokości z logu na urządzeniu właściciela, jeśli masz log, albo wyliczone dla 1280×720 i 1080×2340.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.3.
