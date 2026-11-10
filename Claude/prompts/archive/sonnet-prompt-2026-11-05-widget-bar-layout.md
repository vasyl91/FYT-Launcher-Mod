# Launcher Mod: poprawki rundy 2 i układ muzyki w pasku z widżetami — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `8c1ca9d6`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

Błędy z §2.1 są już znalezione i potwierdzone. Naprawiasz dokładnie je. Reszty kodu rundy 2 nie przerabiasz.

## 0. Kolejność commitów i jej powód

| # | Temat commita | Źródło | Dlaczego tutaj |
|---|---|---|---|
| C1 | `Widget bar: large weather text from the layout's own shares, not grown at every refresh` | §2.1 a | Błąd, który narasta z każdym wybudzeniem. Niezależny. |
| C2 | `Bottom bar on every page: the band is kept free with the left bar too, and only in the user layout` | §2.1 b–c | Niezależny. |
| C3 | `VD host: readFile names what it opened when it refuses, and knows the other names of the shared storage` | §2.1 d | Host i moduł Magisk osobno. |
| C4 | `Music widget files: a file over its limit is an answer too` | §2.1 e | Mały, niezależny. |
| C5 | `Widget bar: one or two lines is the user's choice, the 12% rule is gone` | uwagi właściciela | Podstawa dla C6 i C7. |
| C6 | `Widget bar: the cover keeps its place, the room of hidden widgets goes to the text and the buttons` | uwagi właściciela | Nowy przełącznik układu, podział 65/35, przyciski zawsze w 2 rzędach. |
| C7 | `Widget bar: one line is centred and large text fills the height` | uwagi właściciela | Na geometrii z C6. |
| C8 | `Docs: README for the widget bar switches` | wszystkie | Tylko to, co widzi użytkownik. |

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
- JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `MusicWidgetPlanTest`, `WidgetBarPlanTest`, `BottomBarPlacementTest`, `HostFilePolicyTest`.
- `unitTests.isReturnDefaultValues = true`.
- Logikę decyzyjną pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:**
- Bez nowych zależności.
- Bez zmiany schematu bazy launchera.
- Bez zmiany numeru protokołu VD hosta.
- Nowe klucze prefów dodawaj w `settings/Keys.java`.

**Napisy:**
- Nowy string dodaj do **każdego** z 59 plików `res/values*/strings.xml`, które mają `logcat_names_info_summary` (w tym domyślny `res/values/strings.xml`).
- Tłumaczenie ma być naturalne w języku pliku, nie dosłowne.
- Apostrofy i cudzysłowy escapuj jak w sąsiednich wpisach.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/` (`--glob '!**/generated/**'`, Java, Kotlin, XML, gradle, workflowy, skrypty).

## 2. Fakty

### 2.1 Błędy w kodzie rundy 2 (znalezione w przeglądzie, do naprawy)

**a) `Workspace.enlargeWeatherTexts` (≈1071) powiększa pogodę przy każdym wywołaniu.**
- Nowe udziały liczy od bieżących `matchConstraintPercentHeight` widoków:
  - `largeRow = usualRow * 1.15`;
  - `largeIcon` od bieżącego udziału ikony.
- `setWidgetBarTextView` (≈1017) woła ją za każdym razem, gdy pasek wbudowany jest ponownie podpinany:
  - `refreshWidgetBarAfterWake` (każde wybudzenie);
  - `finishPersistentHide` → `refreshWidgetBarAfterWake("persistent bar removed")`, czyli każdy powrót na pierwszą stronę przy „Bottom bar on every page”.
- Na `workspaceView`, który żyje dłużej, wiersze pogody rosną więc o kolejne 15%, a ikona maleje.

**b) `settings/Helpers`, domyślne pozycje elementów (≈978–1245) i pasek na każdej stronie.**
- Domyślne pozycje omijają pas paska tylko pod warunkiem `barPage(...) && !leftBar && !autoHideBottomBar`.
- Na ekranach >0 lewego paska nie ma. Z włączonym lewym paskiem domyślne pozycje na innych stronach ignorują więc pas trwałej nakładki.
- `checkAndResetIfOverlappingOnScreen` (≈645) dla tych stron pas sprawdza (`bottomBar` bez warunku `leftBar`).
- Skutek: element ustawiony domyślnie w pasie jest za chwilę resetowany do tej samej złej pozycji. To pętla resetów, przed którą ostrzega komentarz przy ≈962.

**c) Rezerwacja na wszystkich stronach bez układu użytkownika.**
- `CellLayout.shouldExcludeLastRow` / `shouldExcludeFirstBottomCell` (≈1586–1600), `isBarRowExcluded` / `isFirstBottomCellExcluded` (≈4549–4560) i `Helpers.barPage` (≈1318) patrzą tylko na `BOTTOM_BAR_EVERY_PAGE`.
- Trwała nakładka i uchwyt na innych stronach istnieją tylko w układzie użytkownika: `Workspace.updatePersistentBar` (≈2684) wymaga `USER_LAYOUT`, a gałąź bez niego zeruje `mEveryPage`.
- Przy wyłączonym układzie użytkownika i pozostawionym przełączniku każda strona traci więc ostatni wiersz (albo komórkę) bez żadnego paska.

**d) `vdhost/shared/.../HostServices.readFile` (≈286).**
- Odmowa po otwarciu loguje tylko `readFile refused: <path>`, bez tego, dokąd prowadzi deskryptor (`/proc/self/fd/N`), czy to zwykły plik i jaki ma rozmiar.
- Demon Magisk może działać w innej przestrzeni montowań niż aplikacje. Wtedy ten sam plik z `/storage/emulated/<u>/…` może się rozwiązać jako `/data/media/<u>/…` albo `/mnt/…/emulated/<u>/…`, a dzisiejsza reguła „deskryptor = żądana ścieżka” odrzuca każde logo radia. Bez ścieżki w logu nie da się tego rozpoznać.

**e) `com/fyt/car/SyuMediaFiles.direct` (≈273).** Plik większy niż limit rodziny zwraca `DENIED`, więc runda próbuje jeszcze `su` (do 3 s) i hosta. Oba odmówią z tego samego powodu (limit).

**f) Zgłoszenia właściciela z testów (naprawiane w C5–C7):**
- **Jedna linijka w układzie z przyciskami z boku nie jest wyśrodkowana.**
  - `MusicWidgetSizer.applyText` daje wierszowi tylko górny margines (`gapPx`), a kolumna `music_bar_column` ma `gravity=center_vertical`.
  - Przy jednym widocznym wierszu (`tv_artist_two` jest `GONE` w trybie jednej linii, `LauncherMusicWidget.renderPair`) cały blok przesuwa się w dół o połowę marginesu.
- **„Large text” prawie nic nie zmienia w jednej linijce.**
  - `planBarWide` liczy `textPx = rowPx / LINE_FACTOR` (1,3 albo 1,2), przy `includeFontPadding=true`.
  - Przy 0,7 H i 0,8 H wysokości wiersza litery zajmują mniej więcej 0,38 H i 0,47 H, a nie całą dostępną wysokość.
- **Miejsce okładki zmienia się po ukryciu daty lub pogody.** `planBar` i `planBarWide` liczą okładkę i odstęp z szerokości poszerzonego widżetu: `min(0,86 H, 0,25 W)` i `BAR_COLUMN_GAP · W`.
- Przyciski z boku w trybie jednej linii są w jednym rzędzie (40%). Właściciel chce zawsze dwa rzędy.

Reszta rundy 2 jest poprawna i zostaje. Sprawdzone:
- `InfoPreference`;
- polityka IME na wątku `vdhost-ime`;
- wczytanie prefów z wyprzedzeniem;
- watchdog PiP;
- `LogClockShift` i `MainStallPlaces`;
- `SyuMediaReadPolicy` (`MISSING` / `DENIED`, bez blokady dla `bt-cover`) oraz strumieniowa kopia paczki ikon;
- `O_NOFOLLOW` i `readlink` w hoście;
- artefakt modułu Magisk;
- bezpiecznik bez alokacji;
- `Configuration.diff` bez refleksji;
- `BottomBarEdgeGesture` i przekazywanie dotyku;
- `WidgetBarLayout` / `WidgetBarPlan`;
- trwała nakładka i jej punkty chowania.

### 2.2 Pasek z widżetami po rundzie 2

**Ustawienia** (`res/xml/creator_preferences.xml` ≈146–168) pod `widget_bar`: zagnieżdżone `widget_bar_no_date` (tylko w poziomie), `widget_bar_no_weather` i `widget_bar_large_text`. Widoczność ustawia `SettingsFragmentSecond.updateWidgetBarRows` (≈1141).

**Szerokości:**
- `WidgetBarPlan`: `MUSIC_LAND 0.28`, `DATE_LAND 0.05`, `WEATHER_LAND 0.12`, `MUSIC_PORT 0.295`, `WEATHER_PORT 0.15`, `musicShare(...)`, `wide(...)`.
- `WidgetBarLayout.apply` (≈37) poszerza `rl_music_two` i przy dowolnym ukrytym widżecie wstawia `music_bar_content_wide.xml` (te same ID, przyciski w `FlexboxLayout`).
- Nakładka robi to samo w `forceOriginalSizes`.

**Plan i rozmiary:**
- `MusicWidgetPlan.barCompact` (≈130): pasek ≤ 12% krótszego boku daje jedną linijkę.
- Układ zwykły: `planBar` (≈197), z `BAR_STANDARD` / `BAR_COMPACT` i ich wariantami `_LARGE`.
- Układ szeroki: `planBarWide` (≈237):
  - przyciski 30% W w 2×2 albo 40% W w jednym rzędzie;
  - wiersze `BAR_WIDE_STANDARD {0.45, 0.45, 0.10}`, `BAR_WIDE_COMPACT {0.70, 0.30}` i warianty `_LARGE`.
- `MusicWidgetSizer.apply` (≈105) wybiera plan po typie `music_bar_buttons` (`FlexboxLayout` oznacza układ szeroki), a `applyBar` (≈192) i `applyBarWide` (≈224) ustawiają widoki.
- Wynik trybu jednej linii trafia do `LauncherMusicWidget.onCompactChanged` → `renderPair`:
  - jedna linia: `MusicWidgetText.compactLine` („artist – title”), drugi widok `GONE`;
  - dwie linie: tytuł nad wykonawcą.

## C1 — `Widget bar: large weather text from the layout's own shares, not grown at every refresh`
1. `enlargeWeatherTexts` liczy udziały zawsze od **wartości z XML**, nie od bieżących.
   - Przy pierwszym wywołaniu dla danego widoku zapamiętaj oryginalne `matchConstraintPercentHeight` wierszy i ikony, np. w tagu widoku (`setTag(R.id.…, Float)`; ID tagu w `res/values/ids.xml`).
   - Każde kolejne wywołanie ustawia te same wartości: `oryginał × 1,15` dla wierszy i `max(oryginał × 0,6, oryginał − 2 × przyrost)` dla ikony.
2. Funkcja ma być idempotentna. Ten sam wynik po 1 i po 10 wywołaniach sprawdź testem czystej funkcji udziałów (wydziel ją, np. `WidgetBarPlan.largeWeatherShares(usualRow, usualIcon)`).
3. Wyłączony „Large text” przywraca oryginalne udziały, jeśli widok był wcześniej powiększony (zmiana przełącznika i tak przebudowuje pasek, ale nie polegaj na tym).

## C2 — `Bottom bar on every page: the band is kept free with the left bar too, and only in the user layout`
1. **Domyślne pozycje (`Helpers` ≈978–1245).** Warunek omijania pasa ma brzmieć `barPage(screen, everyPage) && !(leftBar && screen == 0) && !autoHideBottomBar`. Lewy pasek istnieje tylko na ekranie 0.
   - Dla ekranu 0 zachowanie bez zmian.
   - Ten sam warunek w każdym z miejsc (`pipScreen`, `dateScreen`, `musicScreen`, `radioScreen`, `screenToCompare`) wydziel do jednej metody, żeby się nie rozjechały.
2. **„Every page” tylko w układzie użytkownika.** `BottomBarPlacement.reserve` / `bar` dostają parametr `userLayout`. Bez niego ekrany >0 nie mają paska ani rezerwacji, a ekran 0 jak dziś.
   - Użyj go w `CellLayout` (te cztery metody), w `Helpers.barPage` i w `Workspace.shouldShowEdgeHandle` / `updatePersistentBar`.
   - Test w `BottomBarPlacementTest`.
3. Opis commita wymienia oba scenariusze:
   - lewy pasek + każda strona → elementy na stronie 2 nie lądują w pasie i nie są resetowane w kółko;
   - układ domyślny → ostatni wiersz innych stron wolny.

## C3 — `VD host: readFile names what it opened when it refuses, and knows the other names of the shared storage`
1. Log odmowy po otwarciu: `readFile refused: <path> (opened <readlink>, regular=<bool>, size=<n>)`.
2. **Aliasy pamięci współdzielonej.** Czysta funkcja `HostFilePolicy.sameSharedStorageFile(requested, opened)` (test).
   - Dla żądania pod `/storage/emulated/<u>/` deskryptor może prowadzić także do `/data/media/<u>/`, `/mnt/user/<u>/emulated/<u>/`, `/mnt/pass_through/<u>/emulated/<u>/` albo `/storage/self/primary/`, **z identyczną resztą ścieżki**.
   - Każdy inny cel jest odmową, jak dziś.
   - `allowedOpened` używa tej funkcji zamiast `equals`. Kontrola `pathAllowed` na żądanej ścieżce zostaje.
3. Bez zmiany protokołu.

## C4 — `Music widget files: a file over its limit is an answer too`
1. W `SyuMediaReadPolicy` dodaj wynik `TOO_LARGE` (albo równoważny), który kończy rundę jak `MISSING`. `SyuMediaFiles.direct` zwraca go, gdy `st_size > max`.
2. Brak blokady 30 s dla tego wyniku. Log raz na rodzinę: `<family> -> the file is over <max> bytes`.
3. Test w `SyuMediaReadPolicyTest`.

## C5 — `Widget bar: one or two lines is the user's choice, the 12% rule is gone`
1. **Ustawienie.**
   - `CustomSwitchPreference` (zagnieżdżony, jak pozostałe) `widget_bar_one_line` (`Keys.WIDGET_BAR_ONE_LINE`), w `creator_preferences.xml` zaraz **pod** `widget_bar_large_text`.
   - Domyślnie `false`, czyli dwie linijki. Tak samo na każdym urządzeniu: żadnych warunków od jednostki, wysokości paska ani rozmiaru ekranu.
   - Widoczny, gdy włączony jest `widget_bar`: dopisz go do `updateWidgetBarRows`.
   - Zmiana przełącznika: `helpers.setBarSettingsChanged(true)`.
   - Stringi:

     | Klucz | EN | PL |
     |---|---|---|
     | `widget_bar_one_line` | „Title and artist in one line” | „Tytuł i wykonawca w jednej linii” |
     | `widget_bar_one_line_on` | „One line: artist – title” | „Jedna linia: wykonawca – tytuł” |
     | `widget_bar_one_line_off` | „The title above the artist” | „Tytuł nad wykonawcą” |

   - Pozostałe języki naturalnie, we wszystkich 59 plikach.
2. **Usuń regułę 12% całkowicie:** `MusicWidgetPlan.barCompact`, `BAR_COMPACT_MAX_FRACTION` i każde użycie (plany paska, testy, komentarze, README). Tryb jednej linii (`plan.compact` dla paska) bierze się **tylko** z przełącznika, przekazanego do planu jako parametr.
3. Plan widżetu na ekranie głównym (`planHome`, `MIN_TEXT_SP`) **się nie zmienia**. Dotyczy to wyłącznie paska.
4. `rg 'barCompact|BAR_COMPACT_MAX_FRACTION'` → zero. Testy z granicą 12% zastąp testami parametru.

## C6 — `Widget bar: the cover keeps its place, the room of hidden widgets goes to the text and the buttons`
1. **Ustawienie układu.**
   - `CustomSwitchPreference` (zagnieżdżony) `widget_bar_buttons_beside` (`Keys.WIDGET_BAR_BUTTONS_BESIDE`), domyślnie `true`, w `creator_preferences.xml` zaraz **nad** `widget_bar_large_text`.
   - Kolejność pod `widget_bar`:
     1. `widget_bar_no_date` (tylko w poziomie);
     2. `widget_bar_no_weather`;
     3. `widget_bar_buttons_beside`;
     4. `widget_bar_large_text`;
     5. `widget_bar_one_line`.
   - Widoczny tylko przy włączonym `widget_bar`, gdy coś jest ukryte: `WidgetBarPlan.wide(dateHidden(noDate, portrait), noWeather)`.
   - Kliknięcia `widget_bar_no_date` i `widget_bar_no_weather` też wołają `updateWidgetBarRows`, żeby wiersz pojawiał się i znikał od razu.
   - Zmiana: `helpers.setBarSettingsChanged(true)`.
   - Stringi:

     | Klucz | EN | PL |
     |---|---|---|
     | `widget_bar_buttons_beside` | „Buttons beside the title” | „Przyciski obok tytułu” |
     | `widget_bar_buttons_beside_on` | „Two rows of buttons to the right of the title and artist” | „Dwa rzędy przycisków na prawo od tytułu i wykonawcy” |
     | `widget_bar_buttons_beside_off` | „Buttons below the title and artist” | „Przyciski pod tytułem i wykonawcą” |

   - Pozostałe języki naturalnie, we wszystkich 59 plikach.
2. **Który układ.**
   - Układ z przyciskami z boku (`music_bar_content_wide`): gdy coś jest ukryte **i** `widget_bar_buttons_beside` jest włączony.
   - W każdym innym wypadku zwykły `music_bar_content`, także gdy coś jest ukryte i przełącznik jest wyłączony. Wtedy zwykły układ (tekst, pod nim przyciski) dostaje całą poszerzoną szerokość.
   - Poszerzenie `rl_music_two` o ukryte widżety zostaje bez zmian, w obu układach.
   - Decyzja w jednym miejscu: `WidgetBarPlan.buttonsBeside(dateHidden, weatherHidden, switchOn)`, z testem, używana przez `WidgetBarLayout.apply` i nakładkę (`forceOriginalSizes`).
3. **Okładka zawsze ta sama.** `W0` to szerokość widżetu muzyki bez ukrytych widżetów: `W × WidgetBarPlan.baseShare(portrait) / WidgetBarPlan.musicShare(portrait, noDate, noWeather)`. Dodaj `baseShare`, czyli `MUSIC_LAND` / `MUSIC_PORT`. Bez ukrytych `W0 = W`.
   - Okładka: `coverPx = min(BAR_COVER_HEIGHT · H, BAR_COVER_WIDTH · W0)`.
   - Odstęp za okładką: `BAR_COLUMN_GAP · W0`.
   - Obie wartości są identyczne we wszystkich układach i przy każdym ustawieniu.
   - `R = W − coverPx − odstęp` to cała reszta na tekst i przyciski.
4. **Układ z przyciskami z boku.**
   - Tekst (tytuł i wykonawca albo jedna linia) dostaje **65% R**, a blok przycisków **35% R** (reszta zaokrągleń idzie do tekstu).
   - Przyciski są **zawsze w 2 rzędach × 2**, niezależnie od wysokości paska i od `widget_bar_one_line`: góra prev, next; dół play/pause, favorite.
   - Komórka ma `(35% R / 2) × (H / 2)`, bok przycisku `min(szerokość, wysokość komórki) · BUTTON_FILL`.
   - Usuń wariant jednego rzędu (40%, `flexBasisPercent` 25%, kolejność 1×4).
   - Dwie linijki zachowują dzisiejsze wysokości wierszy (`BAR_WIDE_STANDARD` / `_LARGE`): właściciel ocenił ten wygląd jako bardzo dobry.
5. **Układ zwykły** (tekst, pod nim jeden rząd przycisków prev, play/pause, next, favorite): jak dzisiejszy `planBar`, ale w kolumnie o szerokości `R`. Bok przycisku `min(buttonRowPx, R / 4) · BUTTON_FILL`. Bez ukrytych widżetów wygląda dokładnie jak dziś, poza tym, że tryb jednej linii daje przełącznik (C5).
6. **Plan.** `MusicWidgetPlan.planBar(w, h, baseW, density, largeText, oneLine, buttonsBeside)` albo dwie metody z tymi parametrami (bez `barHeightPx` / `shortSidePx`, skoro reguła 12% znikła).
   - `MusicWidgetSizer` liczy `baseW` z prefów (`WidgetBarLayout.dateHidden/weatherHidden`, orientacja).
   - Testy w `MusicWidgetPlanTest`:
     - okładka i odstęp równe dla `W = W0` i `W > W0` przy tym samym `H`;
     - tekst / przyciski = 65/35 `R` (±1 px);
     - zawsze 2 rzędy przycisków w układzie z boku;
     - suma części ≤ W i ≤ H;
     - układ zwykły przy `W = W0` równy dzisiejszemu planowi.
7. Log: `bar WxH -> layout=beside|below oneLine=… large=… cover=…+gap R=… text=… buttons=…(2x2|1x4) …`.

## C7 — `Widget bar: one line is centred and large text fills the height`
1. **Wyśrodkowanie.** Dotyczy obu układów.
   - W trybie jednej linii wiersz tekstu nie ma marginesu górnego. Wysokość wiersza to cała wysokość jego obszaru:
     - z boku: `H`;
     - w zwykłym układzie: wysokość nad rzędem przycisków po odjęciu odstępów.
   - Kolumna (`gravity=center_vertical`) wyśrodkowuje go wtedy symetrycznie.
   - `includeFontPadding=false` i `gravity=CENTER`, żeby litery były na środku, a nie przesunięte o wypełnienie fontu.
2. **Rozmiar czcionki z metryk, nie ze stałego współczynnika.**
   - Dla jednej linii plan podaje dozwoloną wysokość „pudełka” fontu (`ascent..descent`):

     | Tekst | Pudełko |
     |---|---|
     | zwykły | 0,60 wysokości wiersza |
     | „Large text” | 0,95 wysokości wiersza (wypełnia całą dostępną wysokość) |

   - `MusicWidgetSizer` przelicza to na px raz zmierzonym stosunkiem `(descent − ascent) / textSize` dla `Typeface` tego TextView (`Paint.getFontMetrics` przy rozmiarze testowym).
   - Dwie linijki w układzie z boku zostają jak dziś (dobry wygląd). W zwykłym układzie dwie linijki też bez zmian.
3. Czysta część (udziały, pudełko) w `MusicWidgetPlan` z testem:
   - duże pudełko > zwykłego;
   - pudełko ≤ wiersz;
   - wiersz jednej linii wyśrodkowany: odstęp górny = dolny (±1 px).
4. Podaj w raporcie liczby z logu `MusicWidgetSizer` dla 359×66 i dla wyższego paska (np. 359×110, z ustawień „Resizable bottom bar”) dla kombinacji układ (z boku / pod spodem) × linie (1 / 2) × tekst (zwykły / duży).

## C8 — `Docs: README for the widget bar switches`
README, sekcja paska z widżetami, ma opisać:
- ukrywanie daty i pogody (okładka zostaje na miejscu, reszta miejsca dla tekstu i przycisków);
- „Buttons beside the title” (65/35, zawsze dwa rzędy przycisków);
- „Large text”;
- „Title and artist in one line”, wybierane przez użytkownika na każdym urządzeniu (reguła 12% zniknęła).

Usuń z README wszystkie wzmianki o progu 12% i o układzie 40% w jednym rzędzie.

## 3. Czego NIE zmieniać
- Kodu rundy 2 poza §2.1.
- Widżetu muzyki na ekranie głównym (`planHome`).
- Szerokości `rl_music_two` i widżetów daty i pogody (`WidgetBarPlan`).
- Wysokości wierszy dwóch linijek w układzie z przyciskami z boku.
- Ostrzeżeń `Parcel` / `SurfaceSyncer`.
- Numeru protokołu VD hosta.

## 4. Weryfikacja
1. Po każdym commicie CI jest zielone, a nowe testy przechodzą.
2. Sprawdzenia `rg`:
   - `barCompact|BAR_COMPACT_MAX_FRACTION|BAR_WIDE_BUTTONS_COMPACT` → zero;
   - `widget_bar_one_line` i `widget_bar_buttons_beside` są w 59 plikach `strings.xml`.
3. Scenariusze dla testera. Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Pod „Widget bottom bar” są wcięte kolejno: „Hide the date” (tylko w poziomie), „Hide the weather”, „Buttons beside the title” (tylko gdy coś jest ukryte), „Large text”, „Title and artist in one line”. Wszystkie znikają po odznaczeniu „Widget bottom bar”.
   - b) Okładka ma to samo miejsce i rozmiar przy każdej kombinacji ukrytych widżetów i obu układach. Porównaj zrzuty.
   - c) Ukryta data lub pogoda i „Buttons beside the title” włączony:
     - tekst zajmuje 65%, przyciski 35% miejsca na prawo od okładki;
     - przyciski zawsze w dwóch rzędach (prev / next nad play-pause / favorite), także na niskim pasku i przy jednej linii.
   - d) Ukryta data lub pogoda i „Buttons beside the title” wyłączony: zwykły układ (tekst, pod nim jeden rząd przycisków) na całej poszerzonej szerokości.
   - e) „Title and artist in one line”:
     - jedna linia „artist – title”, wyśrodkowana w pionie w obu układach;
     - z „Large text” litery wypełniają dostępną wysokość, a różnica wobec zwykłego tekstu jest wyraźna;
     - wyłączony daje dwie linijki na każdej wysokości paska.
   - f) Po kilku wybudzeniach i (z „Bottom bar on every page”) kilku powrotach na pierwszą stronę tekst pogody z „Large text” ma ciągle ten sam rozmiar, a ikona się nie zmniejsza.
   - g) „Bottom bar on every page” z lewym paskiem: panele i widżety na stronie 2 nie lądują pod paskiem i nie są resetowane przy każdym powrocie. Przy wyłączonym układzie użytkownika inne strony mają pełną siatkę.
4. Dla właściciela (moduł Magisk z artefaktu CI): przy odmowie odczytu logo log hosta pokazuje `opened …`, a logo radia z `/storage/emulated/0/radio_logo` jest czytane także przez demona Magisk.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash i temat) z wynikiem CI każdego.
- Liczby `MusicWidgetSizer` z C7.4.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.
