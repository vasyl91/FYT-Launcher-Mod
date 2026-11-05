# Launcher Mod: poprawki rundy 3 i rozmiary muzyki w pasku z widżetami — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `48b4ac3f`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

Błędy z §2.1 są już znalezione i potwierdzone. Naprawiasz dokładnie je. Reszty kodu rundy 3 nie przerabiasz.

## 0. Kolejność commitów i jej powód

| # | Temat commita | Źródło | Dlaczego tutaj |
|---|---|---|---|
| C1 | `Widget bar: the title and artist arrangement applies to both layouts and is always shown` | §2.1 a–b, uwagi właściciela | Przywraca dwie linijki w układzie piętrowym; porządkuje ustawienia. |
| C2 | `Widget bar: one line below the text is centred between the top and the buttons` | §2.1 c–d | Rozmiar jednej linii z tego układu jest wzorcem dla C3. |
| C3 | `Widget bar: smaller text beside the buttons, large text as the usual one was` | uwagi właściciela | Korzysta z rozmiaru z C2. |
| C4 | `Widget bar: buttons in one line take half the room in portrait, 40% in landscape, and are larger` | uwagi właściciela | Niezależny od C3. |
| C5 | `Widget bar: the album cover can be hidden, its room goes to the text and the buttons` | uwagi właściciela | Na geometrii z C1–C4. |
| C6 | `Weather: the manager stops while no weather is shown, and starts again when it is` | uwagi właściciela | Niezależny. |
| C7 | `Docs: README for the widget bar arrangement` | wszystkie | Tylko to, co widzi użytkownik. |

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
- Przed pushem uruchom lokalnie `./gradlew :app:testSystemDebugUnitTest` (runda 3 miała commit, który się nie kompilował).

**StrictMode jest włączony.** W nowym kodzie na wątku głównym nie może być:
- I/O plików;
- zapytań do bazy;
- zapytań do `ContentResolver`;
- sieci;
- `su`;
- blokujących wywołań hosta VD.

Prefy zapisuj przez `apply()`.

**Testy:**
- JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `MusicWidgetPlanTest`, `WidgetBarLinesTest`, `WidgetBarPlanTest`.
- `unitTests.isReturnDefaultValues = true`.
- Logikę decyzyjną pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:** bez nowych zależności; bez zmiany schematu bazy launchera; nowe klucze prefów w `settings/Keys.java`.

**Napisy:**
- Nowy albo zmieniony string popraw w **każdym** z 59 plików `res/values*/strings.xml`, które mają `logcat_names_info_summary` (w tym domyślny `res/values/strings.xml`).
- Tłumaczenie ma być naturalne w języku pliku, nie dosłowne.
- Apostrofy i cudzysłowy escapuj jak w sąsiednich wpisach.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/` (`--glob '!**/generated/**'`, Java, Kotlin, XML, gradle, workflowy, skrypty).

## 2. Fakty

### 2.1 Błędy w kodzie rundy 3 (znalezione w przeglądzie, do naprawy)

**a) Regresja: w układzie piętrowym nie da się mieć dwóch linijek.**
- `WidgetBarLines.effective` (≈57) bez przycisków z boku zamienia `TWO_LINES` na `ARTIST_TITLE`.
- `SettingsFragmentSecond.updateWidgetBarRows` (≈1173) pokazuje wiersz `widget_bar_line_mode` tylko przy przyciskach z boku, czyli tylko gdy coś jest ukryte.
- Bez ukrytych widżetów pasek ma więc zawsze jedną linię i nie ma wiersza, którym da się to zmienić, na każdym urządzeniu i każdej wysokości paska.
- Decyzja właściciela: wybór działa w pełni w obu układach.

**b) Podsumowanie „Buttons beside the title” kłamie przy „Buttons in one line”.** `widget_bar_buttons_beside_on` mówi „Two rows of buttons to the right of the title and artist”, a przy włączonym „Buttons in one line” jest jeden rząd.

**c) Jedna linia w układzie piętrowym jest za blisko górnej krawędzi** (zgłoszenie właściciela, z „Large text” i bez). W `MusicWidgetPlan.planBar` (≈264) wiersz jednej linii to `h − buttonRowPx − gapPx` od góry, a `MusicWidgetSizer.applyText` (≈300) centruje w nim pudełko fontu (`includeFontPadding=false`, `gravity=CENTER`). Dwie przyczyny:
- **Puste miejsce nad przyciskami.** Widoczny przycisk (`buttonSidePx = min(row, R/4) · 0,8`) jest niższy niż jego rząd (`buttonRowPx`) i stoi na jego środku. Nad widocznymi przyciskami jest więc dodatkowo `(buttonRowPx − buttonSidePx) / 2` pustego miejsca, którego wyśrodkowanie nie widzi.
  - Na 66 px: rząd 34, przycisk 27, wiersz tekstu 31, odstęp 1.
  - Od tekstu do przycisków jest ~10 px, od góry do tekstu ~6 px.
- **Litery siedzą wysoko w pudełku fontu.** Pudełko `ascent..descent` jest wyśrodkowane, ale litery bez ogonków (`g`, `p`) leżą nad linią bazową, a dolna część pudełka (`descent`) jest pusta. Litery wyglądają przez to na przesunięte w górę.

**d) Drobiazgi w `MusicWidgetSizer`:**
- `applyText` woła `plan.withFontRatio(...)` dwa razy z rzędu (≈306);
- `apply` (≈110) ma dwa sprzeczne komentarze nad `oneLine` („on every bar height” / „one line always without”) i zbędną zmienną `portrait = portraitBar`.

Reszta rundy 3 jest poprawna i zostaje. Sprawdzone:
- udziały pogody z tagu (bez narastania);
- `keepsBarBand` i `userLayout` w `BottomBarPlacement`;
- aliasy pamięci w `HostFilePolicy`;
- `TOO_LARGE`;
- okładka z `W0`;
- komórki przycisków w całych px;
- migracja `widget_bar_one_line` → `widget_bar_line_mode`;
- `MusicWidgetText.compactLine(…, titleFirst)`;
- 59 plików stringów.

### 2.2 Stan po rundzie 3

**Ustawienia** (`res/xml/creator_preferences.xml` ≈146–188), kolejność dziś: `widget_bar`, `widget_bar_no_date`, `widget_bar_no_weather`, `widget_bar_buttons_beside`, `widget_bar_large_text`, `widget_bar_line_mode`, `widget_bar_buttons_one_line`.
- `widget_bar_line_mode` to `CustomNestedThreePreference` z wartościami `two` / `artist_title` / `title_artist` i tytułem `@string/widget_bar_one_line`.

**Plan układu z boku (`planBarWide` ≈310):**
- dwie linie: `BAR_WIDE_STANDARD {0.45, 0.45, 0.10}` z `LINE_FACTOR` 1,3, a przy „Large text” `BAR_WIDE_STANDARD_LARGE {0.50, 0.50, 0}` z 1,2;
- jedna linia: wiersz = `H`, pudełko `ONE_LINE_BOX` 0,60 (`_LARGE` 0,95) · H;
- przyciski: `BAR_BESIDE_BUTTONS_SHARE` 0,35 (2×2) albo `BAR_BESIDE_BUTTONS_ONE_ROW_SHARE` 0,40 (1×4) z `R`, bok `min(cell, row) · BUTTON_FILL (0,8)`.

**Plan układu piętrowego (`planBar` ≈264):**
- dwie linie: `BAR_STANDARD` / `_LARGE`;
- jedna linia: wiersz nad przyciskami, pudełko 0,60 / 0,95 wiersza.

## C1 — `Widget bar: the title and artist arrangement applies to both layouts and is always shown`
1. **Wybór w obu układach.** `WidgetBarLines.effective` usuń (po `rg`) albo niech zwraca wybór bez zmian. `WidgetBarLayout.lineText` (≈43) daje to, co użytkownik wybrał, w każdym układzie.
   - W układzie piętrowym `TWO_LINES` to dwie linijki nad rzędem przycisków (dzisiejszy `planBar` z `oneLine=false`).
   - Bez ukrytych widżetów pasek z `TWO_LINES` wygląda jak przed rundą 3.
   - Zaktualizuj `WidgetBarLinesTest` i komentarze klasy.
2. **Widoczność i kolejność** (`updateWidgetBarRows`, `creator_preferences.xml`). Pod `widget_bar`, wszystkie zagnieżdżone:

   | # | Wiersz | Widoczny, gdy |
   |---|---|---|
   | 0 | (`widget_bar_no_cover` z C5, pierwszy) | `widget_bar` |
   | 1 | `widget_bar_no_date` | `widget_bar` i orientacja pozioma |
   | 2 | `widget_bar_no_weather` | `widget_bar` |
   | 3 | `widget_bar_buttons_beside` | `widget_bar` i coś jest ukryte |
   | 4 | `widget_bar_buttons_one_line` | `widget_bar` i przyciski są z boku (`WidgetBarPlan.buttonsBeside`) |
   | 5 | `widget_bar_line_mode` | **zawsze przy `widget_bar`** |
   | 6 | `widget_bar_large_text` | `widget_bar`, **na samym dole sekcji** |

3. **Nowa nazwa wiersza.** Nowy string `widget_bar_line_mode` zastępuje tytuł `widget_bar_one_line`. Stary string usuń z 59 plików po `rg`.

   | | EN | PL |
   |---|---|---|
   | Tytuł | „Title and artist arrangement” | „Układ tytułu i wykonawcy” |

   - Pozostałe języki naturalnie: „układ / ustawienie tytułu i wykonawcy”, a nie „w jednej linii”.
   - Nazwy wpisów (`widget_bar_one_line_off/on/reversed`) zostają, bo ich treści pasują: „The title above the artist”, „One line: artist – title”, „One line: title – artist”.
4. **Podsumowanie „Buttons beside the title”.** `widget_bar_buttons_beside_on` dostaje treść EN „Buttons to the right of the title and artist”, PL „Przyciski na prawo od tytułu i wykonawcy”. Bez liczby rzędów, bo ją mówi „Buttons in one line”. Popraw we wszystkich 59 plikach.
5. Zmiany ustawień nadal wołają `helpers.setBarSettingsChanged(true)`. Migracja w `LauncherApplication` zostaje.

## C2 — `Widget bar: one line below the text is centred between the top and the buttons`
1. **Obszar jednej linii w układzie piętrowym.** Od górnej krawędzi widżetu do **górnej krawędzi widocznych przycisków**, nie do ich rzędu.
   - Widoczne przyciski zostają tam, gdzie są dziś. Ich środek leży w `h − buttonRowPx / 2`, więc górna krawędź to `yButtons = h − (buttonRowPx + buttonSidePx) / 2`.
   - W kolumnie:
     - wiersz tekstu ma wysokość `yButtons` i margines górny 0;
     - rząd przycisków ma wysokość `buttonSidePx`, margines górny 0 i margines dolny `(buttonRowPx − buttonSidePx) / 2`;
     - suma wynosi `h`.
   - Pudełko fontu liczy się z nowej wysokości wiersza (0,60 albo 0,95 przy „Large text”).
2. **Wyśrodkowanie liter, nie pudełka.** Dotyczy jednej linii w obu układach.
   - Linia bazowa ma leżeć tak, żeby pas od wierzchołka wielkich liter do linii bazowej był na środku wiersza: `baseline = (rowH + capH) / 2` od góry wiersza.
   - `capH` zmierz raz z `Paint.getTextBounds("H", …)` dla typeface i rozmiaru tego TextView.
   - Ustaw to przez górny padding TextView (`includeFontPadding=false`, `gravity=CENTER_HORIZONTAL|TOP`): `paddingTop = max(0, baseline − |ascent|)`, a padding dolny tak, żeby suma dała `rowH`.
   - Czysta funkcja `MusicWidgetPlan.oneLineTopPadding(rowH, capH, ascent)` z testem.
3. Test w `MusicWidgetPlanTest` (układ piętrowy, jedna linia, 66 i 110 px, zwykły i duży tekst): odstęp od góry do wierzchołka liter równa się odstępowi od linii bazowej do górnej krawędzi widocznych przycisków (±1 px).
4. Popraw drobiazgi z §2.1 d.
5. Log planu dopisuje `yButtons=` i `capTop=`.

## C3 — `Widget bar: smaller text beside the buttons, large text as the usual one was`
Właściciel: w układzie z przyciskami z boku tekst jest za duży, w dwóch liniach i w jednej. Ma być tak:

| Układ z boku | Rozmiar tekstu (`textPx`) |
|---|---|
| zwykły tekst, dwie linie | = `textPx` jednej linii układu piętrowego **bez** „Large text” dla tego samego `h` (z C2) |
| zwykły tekst, jedna linia | to samo |
| „Large text”, dwie linie | = dzisiejszy zwykły: wiersz `part(h, 0.45)`, `textPx = rowPx / LINE_FACTOR (1,3)` |
| „Large text”, jedna linia | = dzisiejszy zwykły: pudełko `ONE_LINE_BOX (0,60) · H` |

1. Wysokości wierszy i odstępy dwóch linii zostają jak dziś (`BAR_WIDE_STANDARD`). Zmienia się tylko rozmiar czcionki.
2. Rozmiar „zwykłego” liczy **ta sama funkcja**, która daje `textPx` jednej linii w `planBar(…, large=false, oneLine=true)`, z tym samym zmierzonym stosunkiem fontu (`withFontRatio`). Wydziel ją (np. `MusicWidgetPlan.belowOneLineTextPx(w, h, baseW, density, ratio)`), żeby oba układy nie mogły się rozjechać.
3. `BAR_WIDE_STANDARD_LARGE` i użycie `ONE_LINE_BOX_LARGE` w układzie z boku usuń (po `rg`). `ONE_LINE_BOX_LARGE` zostaje dla układu piętrowego.
4. Testy:
   - zwykły z boku = jedna linia piętrowa bez „Large text” (ten sam `h`, ten sam stosunek);
   - „Large text” z boku = dawny zwykły z boku (dwie linie i jedna);
   - „Large text” ≥ zwykły;
   - tekst mieści się w wierszu.
5. Raport: liczby `MusicWidgetSizer` dla 359×66 i 359×110, z boku × (1 / 2 linie) × (zwykły / duży).

## C4 — `Widget bar: buttons in one line take half the room in portrait, 40% in landscape, and are larger`
1. **Podział przy „Buttons in one line”** (układ z boku, jeden rząd czterech):

   | Orientacja | Tekst | Przyciski |
   |---|---|---|
   | pionowa | 50% `R` | 50% `R` |
   | pozioma | 60% `R` | 40% `R` |

   - Dwa rzędy (2×2) zostają 65/35.
   - Wydziel `WidgetBarPlan.besideButtonsShare(portrait, oneRow)` z testem. `planBarWide` dostaje orientację albo gotowy udział.
   - Komórki dalej w całych px (bez `flexBasisPercent`), reszta zaokrągleń do tekstu.
2. **Przyciski ~10% większe w tym trybie.** Bok przycisku to `min(szerokość komórki, wysokość rzędu) · BUTTON_FILL_ONE_ROW`, gdzie `BUTTON_FILL_ONE_ROW = 0,88` (0,8 × 1,1). Nigdy nie większy niż komórka. Dwa rzędy zostają przy 0,8.
3. Testy:
   - 50/50 i 60/40 (±1 px);
   - bok przycisku = 1,1 × dzisiejszy, o ile mieści się w komórce;
   - suma części ≤ W.
4. Log planu pokazuje udział: `buttons=…(1x4, 50%|40%)`.

## C5 — `Widget bar: the album cover can be hidden, its room goes to the text and the buttons`
1. **Ustawienie.**
   - `CustomSwitchPreference` (zagnieżdżony) `widget_bar_no_cover` (`Keys.WIDGET_BAR_NO_COVER`), domyślnie `false`, w `creator_preferences.xml` jako **pierwszy** wiersz pod `widget_bar`, nad `widget_bar_no_date`.
   - Widoczny przy włączonym `widget_bar`, w obu orientacjach.
   - Zmiana: `updateWidgetBarRows()` i `helpers.setBarSettingsChanged(true)`.
   - Stringi:

     | Klucz | EN | PL |
     |---|---|---|
     | `widget_bar_no_cover` | „Hide the album cover” | „Ukryj okładkę albumu” |
     | `widget_bar_no_cover_on` | „The title, artist and buttons take its place” | „Jej miejsce zajmują tytuł, wykonawca i przyciski” |

   - Pozostałe języki naturalnie, we wszystkich 59 plikach.
2. **Te same zasady co przy ukryciu daty i pogody:**
   - Ukryta okładka liczy się jako „coś ukryte”: `WidgetBarPlan.wide(dateHidden, weatherHidden, coverHidden)`. Pojawia się wtedy „Buttons beside the title” i może działać układ z przyciskami z boku, także gdy data i pogoda są widoczne.
   - Zmień wszystkie miejsca, które pytają o `wide` / `buttonsBeside`: `WidgetBarLayout`, `forceOriginalSizes` nakładki, `updateWidgetBarRows`, `MusicWidgetSizer`.
   - Szerokość `rl_music_two` się nie zmienia: okładka nie jest osobnym widżetem paska.
3. **Geometria** (`placeCover` w `MusicWidgetPlan`):
   - przy ukrytej okładce `coverPx = 0`;
   - odstęp `coverGapPx = BAR_COLUMN_GAP · W0` zostaje jako margines od listy aplikacji;
   - `R = W − coverGapPx` jest całym miejscem na tekst i przyciski, dalej według reguł z C1–C4 (65/35, 50/50, 60/40, rozmiary tekstu z C3).
   - Rozmiar tekstu „zwykłego” z boku (C3) liczy się dla tego samego `h`: nie zależy od szerokości.
4. **Widok:**
   - `iv_album_bg_two` dostaje `GONE` w obu układach i w obu egzemplarzach paska (wbudowany i nakładka);
   - `LauncherMusicWidget` nie dekoduje ani nie ustawia okładki dla ukrytego widoku paska; okładka widżetu na ekranie głównym bez zmian.
5. Testy:
   - `R` bez okładki = `W − odstęp`;
   - `wide` prawdziwe przy samej okładce;
   - podziały z C1–C4 liczone od nowego `R`.

## C6 — `Weather: the manager stops while no weather is shown, and starts again when it is`
**Fakty:**
- Pogodę pokazuje tylko:
  - pasek z widżetami (`bar_widget_weather`: `weatherImg1`, `weatherCity1`, …), w układzie użytkownika przy `widget_bar` i bez `widget_bar_no_weather`;
  - hotseat (`weatherImg`, `weatherCity`, …), wiązany tylko przy `R.bool.weather_show`, które domyślnie jest `false` (`res/values/bools.xml`).
- `WeatherManager` tworzy `LauncherWeather.ensureWeatherManager` (≈79). Wołają ją:
  - `periodicWeatherCheck` (z `scheduleWeatherCheckAfterHome` przy każdym powrocie na ekran główny: Launcher ≈2803, ≈2814, ≈2872);
  - `updateWeather` (Launcher ≈4615, ≈9222; Workspace ≈992, ≈1782; `WakeDetection` ≈397 po wybudzeniu przy `widget_bar`).
- Konstruktor rejestruje `NetworkCheck` (odbiornik), a `start()` prosi o lokalizację, w razie potrzeby o uprawnienie, i włącza GPS co 30 s.
- `stop()` wyłącza tylko GPS, a samej instancji (`WeatherManager.instance`) nic nie zwalnia.

**Zmiany:**
1. **Warunek.** Czysta funkcja `WeatherNeed.needed(userLayout, widgetBar, noWeather, hotseatWeather)` z testem.
   - Pogoda jest potrzebna, gdy pokazuje ją pasek (`userLayout && widgetBar && !noWeather`) albo hotseat (`R.bool.weather_show` i powiązane widoki).
   - Przed zmianą sprawdź `rg 'getThisWeather|OnWeatherChangedListener|WeatherManager\.getInstance'`. Każdego innego odbiorcę pogody dolicz do warunku i wymień w commicie.
2. **Zatrzymanie.** Nowa metoda `WeatherManager.shutdown()`:
   - `stop()`;
   - wyrejestrowanie `NetworkCheck` (dodaj `unregister`, jeśli go nie ma);
   - `clearListeners()`;
   - anulowanie zaplanowanych pobrań i timerów;
   - `instance = null`;
   - log raz: `WeatherManager stopped: no weather is shown`.
3. **`LauncherWeather`.**
   - `ensureWeatherManager` przy niespełnionym warunku nie tworzy menedżera i nie planuje ponowienia. Działający menedżer wyłącza (`shutdown()`, `weatherManager = null`, zdjęty słuchacz) i zwraca `false`.
   - `scheduleWeatherCheckAfterHome` i `periodicWeatherCheck` nic nie planują, gdy pogoda nie jest potrzebna (także `setForeground(true)` tylko wtedy, gdy jest).
4. **Start i wybudzenie.** Bez potrzeby pogody nic nie tworzy menedżera:
   - `WakeDetection` (≈389) woła `updateWeather` tylko przy `widget_bar && !widget_bar_no_weather` (albo pyta `LauncherWeather`);
   - `Workspace` ≈992 / ≈1782 / ≈1851 przechodzą przez bramkę w `LauncherWeather`.
5. **Ponowne włączenie.** Wyłączenie „Hide the weather” albo włączenie „Widget bottom bar” przebudowuje pasek (`setBarSettingsChanged`). Po przebudowie wywołaj raz `mHomeWeather.updateWeather()`:
   - menedżer tworzy się znowu, wiąże słuchacza i pokazuje pogodę;
   - przy wyłączeniu pogody to samo wywołanie go zatrzymuje.
   - Log: `WeatherManager started: the weather is shown again`.
6. Bez zmian: pobieranie, częstotliwość, cache pogody i `SunTask` (nie korzysta z `WeatherManager`).

## C7 — `Docs: README for the widget bar arrangement`
README, sekcja paska z widżetami, ma opisać:
- „Hide the album cover”;
- „Title and artist arrangement” (trzy wybory, w obu układach);
- kolejność wierszy;
- „Buttons in one line” (50/50 w pionie, 60/40 w poziomie);
- „Large text” w układzie z boku;
- to, że bez pokazywanej pogody launcher nie pobiera pogody i nie używa do niej GPS.

Usuń zdanie, że w układzie piętrowym tekst jest zawsze w jednej linii.

## 3. Czego NIE zmieniać
- Kodu rundy 3 poza §2.1 i C1–C5.
- Okładki i odstępu za nią (z `W0`), poza ich ukryciem w C5.
- Pobierania pogody, jej częstotliwości i cache, poza zatrzymaniem w C6.
- Podziału 65/35 i 2×2 bez „Buttons in one line”.
- Wysokości wierszy dwóch linii w układzie z boku.
- Rozmiarów w układzie piętrowym poza wyśrodkowaniem jednej linii (C2).
- Widżetu muzyki na ekranie głównym (`planHome`).

## 4. Weryfikacja
1. Po każdym commicie CI jest zielone, a nowe testy przechodzą.
2. Sprawdzenia `rg`:
   - `@string/widget_bar_one_line"` → zero;
   - `widget_bar_line_mode` (string) jest w 59 plikach;
   - `BAR_WIDE_STANDARD_LARGE` → zero.
3. Scenariusze dla testera. Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Pod „Widget bottom bar” kolejno: „Hide the album cover”, „Hide the date” (poziomo), „Hide the weather”, „Buttons beside the title” (gdy coś ukryte), „Buttons in one line” (gdy przyciski z boku), „Title and artist arrangement” (zawsze), „Large text” (zawsze, na dole).
   - b) Bez ukrytych widżetów „The title above the artist” daje dwie linijki nad przyciskami, a obie opcje „One line” dają jedną linię.
   - c) Układ piętrowy, jedna linia, z „Large text” i bez: odległość od górnej krawędzi paska do liter jest taka sama jak od liter do przycisków.
   - d) Przyciski z boku:
     - zwykły tekst ma rozmiar jednej linii układu piętrowego;
     - „Large text” ma rozmiar dawnego zwykłego, w dwóch liniach i w jednej.
   - e) „Buttons in one line”: w pionie tekst i przyciski po połowie, w poziomie 60/40; przyciski wyraźnie (≈10%) większe niż w 2×2.
   - f) Podsumowanie „Buttons beside the title” nie mówi o liczbie rzędów.
   - g) „Hide the album cover” (pierwszy wiersz pod „Widget bottom bar”):
     - okładka znika, a tytuł, wykonawca i przyciski zajmują jej miejsce;
     - „Buttons beside the title” pojawia się także wtedy, gdy data i pogoda są widoczne.
   - h) Pogoda:
     - przy „Hide the weather” (albo bez „Widget bottom bar”) log ma `WeatherManager stopped`;
     - po restarcie i wybudzeniu nie ma logów `WeatherManager` ani prośby o GPS pogody;
     - po wyłączeniu „Hide the weather” pogoda wraca bez restartu launchera (`WeatherManager started`).

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash i temat) z wynikiem CI każdego.
- Liczby `MusicWidgetSizer` z C3.5 i wartości `yButtons` / `capTop` z C2 dla 66 i 110 px.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.
