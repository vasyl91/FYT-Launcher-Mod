# Launcher Mod: okno paska pionowego po prawej na innych stronach, jeden kreator dla wszystkich stron, okno statystyk przesuwane przez paski — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `8a0229d5`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

## 0. Commity (w tej kolejności)

| # | Temat commita | Źródło |
|---|---|---|
| F1 | `Bars: the window of the vertical bar lies where the first page's bar lies` | właściciel, launcher |
| F2 | `Creators: one creator for every page` | właściciel, kreator i ujednolicenie |
| F3 | `Stats window: the bars move it out of their way, never resize it` | właściciel |

F3 stoi na F2 (kreator).

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

**Testy:** JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `BarLayoutTest`, `CreatorBarsTest`, `PageBoxTest`. Logikę pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:** bez nowych zależności i bez nowych stringów.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/`.

## 2. Fakty

### 2.1 Przegląd rundy 10 (`752222ec`, `6961a9ca`, `8a0229d5`)
CI jest zielone, a właściciel potwierdza, że zmiany działają. Wyjątki to §2.2–§2.4. Kodu E1 i E2 poza F1 nie zmieniasz.

### 2.2 Okno paska pionowego na innych stronach stoi po lewej, choć ustawiony jest prawy bok
- **Ścieżka ramki** czyta prawą stronę poprawnie:
  - `Workspace.verticalWindowFrame` (≈3215–3236) → `BarLayouts.of(…)` (czyta `VERTICAL_BAR_RIGHT`) → `BarLayout.verticalWindow` → `verticalBarBand`: `left = right ? rootWidth − verticalBarWidth : 0`;
  - `x = box.left + left`, przy `box` z `barBoxOnScreen()` (≈1588, `PageBox`);
  - `VerticalBarWindow.build` (≈68–150) / `setFrame` (≈200–214) ustawiają `gravity TOP|LEFT` i `x`;
  - okno jest usuwane przy każdej przebudowie strony (`cleanupAllResources` ≈3602).
- **Wniosek:** z samego kodu nie widać, skąd okno bierze lewą stronę. Właściciel to widzi: pasek po prawej, opcja „na każdej stronie”, przejście ze strony 0 na inną → pasek po lewej.
- **Pomiar i log:** nigdzie nie jest logowane, gdzie okno faktycznie leży (`x` z parametrów ani położenie na ekranie po układzie). Pasek strony 0 (`rl_vertical_bar`) ma dokładny prostokąt na ekranie, ale okno go nie używa.

### 2.3 Kreator innych stron (`settings/CreatorOtherScreens`, `settings/DrawViewOtherScreens`)
- **Wysokość paska poziomego:**
  - `CreatorFirstScreen.applyResizableHorizontalBar` (≈283–360, wołane ≈130) daje `creator_bar` dokładną wysokość z ustawień (`HorizontalBarDimensions.applyExactHeight`);
  - `CreatorOtherScreens` tego nie robi i `creator_bar` ma wysokość z XML (`creator_other.xml`), stąd „nieadekwatnie wysoki”.
- **Kolejność rysowania:** `addVerticalBarBand` (≈200–235) dodaje pas paska pionowego przez `root.addView(band, …)` jako **ostatnie** dziecko. Rysuje się więc nad `creator_bar`, a pasek poziomy jest „pod paskiem bocznym”.
- **Odsuwanie prostokątów od paska:**
  - `DrawViewFirstScreen` ma `fitIntoCanvas`, `fitRectanglesIntoCanvas`, `moveRectanglesInsideCanvas`, `collidesWithAutoHideBar`, `clampAwayFromAutoHideBar`, `resolveAutoHideBarBounds`, `onMeasure` (proporcje launchera), `setWorkspaceArea` i górny inset;
  - `DrawViewOtherScreens` nie ma żadnej z nich. Ma tylko `setTopInset` (≈105), ustawiane wyłącznie przy pasku na każdej stronie bez auto-hide (`CreatorOtherScreens` ≈121–126), a dół ogranicza `maxBorderY = getHeight() − margin` (≈621).
  - Pasek u góry nie przesuwa więc prostokątów, a pasek na dole przesuwa tylko dzięki temu, że płótno kończy się nad nim.

### 2.4 Kreator pierwszej strony: przycisk ze strzałką w złym miejscu
- **Pozycja przycisku:** jest nim `creator_bar_auto_hide` z układu (`creator.xml` / `creator_vertical.xml`). Strzałkę dokłada `CreatorBarMarks.addArrow` (E3).
  - W układach poziomych (`layout-land/creator.xml` ≈262–270, `layout-land/creator_vertical.xml` ≈274–282) ten widok **nie ma żadnego wiązania w poziomie**, tylko `Bottom_toBottomOf=parent`, więc ConstraintLayout stawia go przy lewej krawędzi.
  - `BarConstraints.flipHorizontally` nie ma czego odwrócić. Przy pasku pionowym po prawej przycisk i strzałka zostają po lewej.
  - W układach pionowych wisi na `guideline_horizontal_bar_height` i `rl_vertical_bar` / `guideline_auto_hide_width`, a jego położenie zależy od odwracania linii pomocniczych.
- **Kreator innych stron** rysuje przycisk przez `CreatorBarMarks.install(…, withButtonView=true, …)`, przy krawędzi strony paska pionowego, i tam stoi dobrze (właściciel).

### 2.5 Dwa kreatory to w większości ta sama klasa
- **Kanwy:**
  - `DrawViewFirstScreen` (1436 linii) i `DrawViewOtherScreens` (1131) mają 39 wspólnych metod.
  - Tylko w pierwszej: `onMeasure`, `onSizeChanged`, `setWorkspaceArea`, `fitIntoCanvas`, `fitRectanglesIntoCanvas`, `moveRectanglesInsideCanvas`, `collidesWithAutoHideBar`, `clampAwayFromAutoHideBar`, `resolveAutoHideBarBounds`, `pipMinWidthFor`.
  - Tylko w drugiej: `applyStep`, `countEnabledPips`, `setBarMarks`.
- **Fragmenty:** `CreatorFirstScreen` (590) i `CreatorOtherScreens` (335). Otwiera je `SettingsFragmentSecond` ≈2597 / ≈2600.
- **Paski strony** opisuje już `CreatorBars.of(BarLayout, autoHide)` (E3), a `BarLayouts.verticalOnPage` i `HorizontalBarPlacement.reserve` mówią, co jest na danej stronie.

### 2.6 Paski nie ruszają okna statystyk spalania
- **Jak paski działają na PiP i widżety:** `Helpers.checkAndResetIfOverlappingOnScreen` (≈543) buduje dla każdej strony listę `CustomLayoutResolver.Element` z prostokątów użytkownika (`getUserRect`, klucze `<key>UserLeft/Top/Right/Bottom`, `putUserRect` ≈881). Następnie:
  - ustawia `Env` z pasków strony: `minTop` / `minTopBottomLimit` dla paska u góry, `maxBottom` / `bottomTrigger` dla paska na dole (strona 0 albo pasek na każdej stronie), `maxRight` / `rightTrigger` / `verticalBarOffset` dla paska pionowego (`BarLayouts.verticalOnPage`), ≈646–664;
  - woła `CustomLayoutResolver.resolve` (`moveBelowTopBar`, `fitOverlapping`, `resolveAxis`);
  - zapisuje wynik w ośmiu kluczach narożników (`<key>TopLeftX` …).
  Gdy paski się cofną, element wraca do prostokąta użytkownika.
- **Okno statystyk w tym schemacie:**
  - Wchodzi do listy jako `Element("stats", …, fixed = true, …)` z narożników `stats…` (`Helpers` ≈635–641) i z indeksem `-1`. Jego wyniku Helpers więc nie zapisuje (≈700: `if (i < 0) continue`).
  - `fixed` znaczy w `CustomLayoutResolver` (≈58–59) „nigdy nie przesuwane ani przycinane, ale nic nie wchodzi na nie”: pomija je `moveBelowTopBar` (≈160), `fitOverlapping` (≈195) i `computeReach` (≈394), a `minLength` (≈462) bierze jego pełny rozmiar.
  - Okno statystyk nie ma prostokąta użytkownika: `ensureUserRects` (≈905) i klucze `User*` obejmują tylko `RECTANGLE_KEYS`.
- **Skutek:** przy pasku u góry, na dole, po lewej albo po prawej okno statystyk zostaje tam, gdzie było, i może leżeć na pasku.
- **Położenie na ekranie:** `CanbusService` (≈895–960) stawia okno statystyk według narożnika z `CellLayout.getStatsPlaceholderPosition` (≈4459, ≈4530), z przesunięciem o szerokość paska pionowego po lewej (≈840). Rozmiar okna liczy z własnych ustawień statystyk.
- **Kreatory:**
  - kreatory stron pokazują statystyki jako prostokąt `"stats"` bez zmiany rozmiaru (`addRectangle("Stats", "stats", …, false)`);
  - kreator statystyk (`settings/DrawViewAppStats`, ≈181) nie rysuje pasków i po zapisie woła `checkAndResetIfOverlappingOnScreen(-1)` (≈759).

---

## F1 — `Bars: the window of the vertical bar lies where the first page's bar lies`
1. **Położenie w poziomie z prawdziwego paska.** Okno bierze `x` i szerokość z prostokątu `rl_vertical_bar` strony 0 na ekranie:
   - mierzonego jak `PageBox` (`getLocationOnScreen` paska minus strona, plus lewa krawędź `Workspace`, czyli niezależnie od przewinięcia);
   - zapamiętanego po każdym układzie strony 0 (ten sam `OnLayoutChangeListener` co E1).
   - Wysokość i `y` zostają z `BarLayout.verticalWindow` + `box.top`.
   - Przed pierwszym pomiarem paska: obecna ścieżka (`BarLayout`).
2. **Pomiar bez nakładki.** Pasek strony 0 jest wtedy mierzony bez nakładki, czyli zawsze tam, gdzie stawia go układ z `BarConstraints` (po prawej przy `VERTICAL_BAR_RIGHT`).
3. **Log przy każdym ułożeniu okna** (`build`, `ACTIVATE`, gałąź `default`): `Persistent vertical bar frame: side <left|right>, page bar <l,t,r,b>, frame <x,y,w,h>`.
   - Raz po pierwszym układzie okna: jego położenie na ekranie (`getLocationOnScreen` korzenia okna).
   - Gdy różni się od `frame`, `Log.w`: `… placed at <x,y> instead of <x,y>`.
4. **Przyczyna:** odtwórz scenariusz właściciela w teście czystej funkcji `VerticalWindowFrame.of(pageBarRect, bandFromLayout, haveMeasurement)` → `{x, y, w, h}`.
   - Przypadki: obie strony, przed pomiarem i po nim.
   - W commicie opisz, co dawało lewą stronę: wartość, miejsce w kodzie, warunki. Jeśli przyczyna leży poza ramką (inne okno, inny widok), napraw ją tam i opisz.
5. **Strzałka i róg okna** (`VerticalBarWindow`) bez zmian.

## F2 — `Creators: one creator for every page`
1. **Jedna klasa fragmentu `settings/CreatorScreen`** (zamiast `CreatorFirstScreen` i `CreatorOtherScreens`) z `newInstance(int page)`.
   - **Jedna kanwa `settings/DrawViewScreen`** (zamiast `DrawViewFirstScreen` i `DrawViewOtherScreens`).
   - **Jeden układ `creator_screen.xml`** (land/port): kanwa + pasek z kontrolkami (`creator_bar`).
   - `SettingsFragmentSecond` ≈2597 / ≈2600 otwiera `CreatorScreen.newInstance(page)` (strona 0 = pierwsza).
   - Stare klasy i układy (`creator.xml`, `creator_vertical.xml`, `creator_other.xml`) usuń po `rg`.
2. **Różnice między stronami tylko tam, gdzie są na ekranie głównym** (nazwij każdą w Javadoc klasy):
   - **Klucze i zapis prostokątów** każdej strony jak dziś: strona 0 jak w `DrawViewFirstScreen`, inne z numerem strony jak w `DrawViewOtherScreens`. To samo dla `touchedKeys` i `Helpers.putUserRect`.
   - **Które elementy są na stronie** (data, muzyka, radio, statystyki, PiP): `compareScreens` jak dziś.
   - **Które paski są na stronie:** `CreatorBars.of(BarLayouts.of(…, BarLayouts.verticalOnPage(prefs, page), HorizontalBarPlacement.reserve(page, …) != NONE), autoHide)`.
   - Napis i dwuklik: `CreatorBarToggle.canToggle(page == 0, …)` jak dziś.
3. **Wszystko inne jest wspólne i działa jak dziś na stronie 0** (wzorzec: zachowanie `DrawViewFirstScreen`, które właściciel potwierdza):
   - proporcje launchera (`onMeasure`, `setWorkspaceArea`);
   - dokładna wysokość paska poziomego z ustawień (`applyResizableHorizontalBar`, `HorizontalBarDimensions.applyExactHeight`) na **każdej** stronie;
   - odsuwanie prostokątów od pasma paska poziomego **u góry i u dołu** (górny inset i `maxBorderY` liczone z `BarLayout`), od przycisku w rogu (`collidesWithAutoHideBar` / `clampAwayFromAutoHideBar`) i od pasa paska pionowego;
   - kroki strzałek (`applyStep`), liczenie PiP (`countEnabledPips`), `pipMinWidthFor`.
4. **Paski w kreatorze dodawane w kodzie, z `CreatorBars`, na każdej stronie tak samo:**
   - **pas paska pionowego:** strona, pełna wysokość według E2, tło `VERTICAL_BAR_SELECTED_BACKGROUND`;
   - **przycisk w rogu:** `CreatorBarMarks.install(…, withButtonView = true, …)` przy krawędzi paska pionowego, ze strzałką obróconą o 180° po prawej. Zastępuje `creator_bar_auto_hide`, więc wiązanie układu przestaje mieć znaczenie (§2.4). Kolizje (`resolveAutoHideBarBounds`) liczą się z tego widoku, przy krawędzi, przy której jest pasek;
   - **pasek uchwytu:** `CreatorBarMarks`, jak dziś, tylko obraz.
5. **Kolejność rysowania:** pasek poziomy (`creator_bar`, kontrolki) jest **zawsze nad** pasem paska pionowego, przyciskiem i paskiem uchwytu. Pasy wstawiasz pod `creator_bar` (indeks przed nim), a nie na końcu. Napis i kanwa pod paskami jak dziś.
6. **Testy:**
   - czysta klasa `CreatorPage.of(page, prefsSnapshot)` → klucze zapisu, `firstScreen` dla `CreatorBarToggle`, paski z `CreatorBars`;
   - test `CreatorPageTest`: strona 0 i 2 × pasek u góry i u dołu × auto-hide × pasek pionowy po obu stronach, na każdej stronie i bez;
   - `CreatorBarsTest` bez zmian albo rozszerzony.
7. **`DrawViewAppStats` / `CreatorAppStats`** bez zmian w F2. Paski dostają w F3.

## F3 — `Stats window: the bars move it out of their way, never resize it`
1. **Reguła właściciela:** okno statystyk leży zawsze nad wszystkimi elementami siatki launchera, więc z nimi nigdy nie koliduje. Paski, poziomy i pionowy, tylko je **przesuwają**, tak żeby na nie nie nachodziło.
   - Bez zmiany rozmiaru, bez przycinania i bez resetu.
   - Żadnej logiki kolizji z PiP, widżetami ani ikonami: nie ma skracania, przestawiania innych elementów ani szukania wolnego miejsca.
2. **Okno statystyk wychodzi z `CustomLayoutResolver`.**
   - `Helpers.checkAndResetIfOverlappingOnScreen` nie dodaje już elementu `"stats"` (≈635–641) ani do listy, ani do `resolution.obstacles`.
   - Inne elementy przestają go omijać, bo okno leży nad nimi. Opisz to w commicie.
   - Gdy nic innego nie używa `Element.fixed`, usuń je po `rg`.
   - Testy resolvera, które dotyczą statystyk, dostosuj albo usuń.
3. **Czysta klasa `StatsBarFit.move(rect, bounds)`** → nowy prostokąt tej samej szerokości i wysokości.
   - `bounds` to wolny obszar strony statystyk poza paskami. Liczysz go z tego samego `Env`, który `Helpers` buduje dla tej strony (≈646–664):
     - lewa = `margin`;
     - góra = `minTop` przy pasku u góry, inaczej `margin`;
     - prawa = `maxRight` przy pasku pionowym, inaczej `rootWidth − margin`;
     - dół = `maxBottom` przy pasku na dole, inaczej `rootHeight − margin`.
     Dotknięcie paska liczy się jako nachodzenie, jak dla innych elementów.
   - **Przesunięcie:** w każdej osi o najmniejszy odcinek, który wprowadza okno w `bounds`. Okno, które nie nachodzi na pasek, zostaje dokładnie na miejscu.
   - **Okno większe niż `bounds` w danej osi:** staje przy wewnętrznej krawędzi, bez zmiany rozmiaru, czyli lewa = lewa `bounds`, a w pionie góra = góra `bounds`. Log: `Stats window larger than the room beside the bars, aligned to <edge>`.
   - **Test `StatsBarFitTest`:**
     - pasek u góry, na dole, pionowy po lewej i po prawej, każdy osobno i razem;
     - rozmiar zawsze bez zmian;
     - okno większe niż obszar;
     - okno poza paskami stoi w miejscu.
4. **Prostokąt użytkownika dla statystyk**, jak dla PiP i widżetów, żeby po cofnięciu pasków okno wracało tam, gdzie je postawił użytkownik:
   - klucz `"stats"` w `putUserRect` / `getUserRect` i w migracji `ensureUserRects` (dziś obecne narożniki);
   - kreator statystyk (`DrawViewAppStats`) i kreator stron (F2) zapisują go przy zmianie położenia przez użytkownika, jak `touchedKeys` dla innych;
   - `Helpers` bierze prostokąt użytkownika statystyk, przepuszcza go przez `StatsBarFit.move` i zapisuje wynik w narożnikach `stats…`, tylko gdy się zmienił.
5. **Okno na ekranie:** po zmianie narożników `stats…` okno w `CanbusService` staje w nowym miejscu tak, jak dziś po zapisie kreatora statystyk.
   - Przesunięcie o pasek pionowy po lewej (≈840) zostaje, bo współrzędne prostokątów są w pudełku bez paska.
   - Log raz na zmianę: `Stats window moved by the bars: <l,t,r,b> -> <l,t,r,b>`.
6. **Kreatory:**
   - W kreatorze stron (F2) prostokąt `"stats"` jest odsuwany od pasków tą samą funkcją `StatsBarFit.move` (tylko przesunięcie). Inne prostokąty go nie omijają ani on ich.
   - Kreator statystyk (`DrawViewAppStats`) rysuje paski strony statystyk z `CreatorBars` (pasy poziomy i pionowy, przycisk, pasek uchwytu, jak F2) i przy przeciąganiu odsuwa od nich okno funkcją `StatsBarFit.move`, bez zmiany rozmiaru.
7. **Bez zmian:** rozmiar okna statystyk i jego ustawienia, przezroczystość, czcionka. Nakładanie się na widżety jest dozwolone jak dziś.

## 3. Czego NIE zmieniać
- Ekranu głównego poza F1 i F3: pasków, uchwytu, D4, E1, E2.
- Kluczy prefów, kluczy prostokątów i prostokątów użytkownika.
- Zachowania kreatora strony 0, które właściciel potwierdza: pasek poziomy, odsuwanie prostokątów, napis, dwuklik.

## 4. Weryfikacja
1. CI zielone po każdym commicie, a nowe testy przechodzą: `VerticalWindowFrameTest`, `CreatorPageTest`, `StatsBarFitTest`.
2. `rg -n 'CreatorFirstScreen|CreatorOtherScreens|DrawViewFirstScreen|DrawViewOtherScreens|creator_bar_auto_hide|R\.layout\.creator(_vertical|_other)?\b' app/src` → zero.
3. **Scenariusze dla testera.** Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Pasek pionowy po prawej + „na każdej stronie” (z auto-hide i bez):
     - przejście ze strony 0 na każdą inną i z powrotem → pasek zawsze po prawej, nieruchomy;
     - w logu `Persistent vertical bar frame: side right …` bez ostrzeżenia `placed at`.
   - b) Kreator każdej strony (0, 2, 3…), pasek u góry i u dołu, z auto-hide i bez, pasek pionowy po obu stronach, na każdej stronie i bez:
     - pasek poziomy tej samej wysokości co w kreatorze strony 0 i na ekranie;
     - widoczny pasek poziomy zawsze nad paskiem pionowym;
     - prostokąty odsuwają się od paska u góry i u dołu, od przycisku i od paska pionowego;
     - po ukryciu paska (dwuklik) przycisk ze strzałką stoi w rogu paska pionowego, ze strzałką do środka.
   - c) Zapisane prostokąty każdej strony po otwarciu i zapisaniu kreatora bez zmian są takie same jak przed F2.
   - d) Okno statystyk przy krawędzi, na której potem stawiasz pasek (u góry, na dole, pasek pionowy po lewej i po prawej, także na innej stronie z paskami na każdej stronie):
     - okno odsuwa się od paska i ma ten sam rozmiar;
     - po cofnięciu paska wraca na swoje miejsce;
     - kreator statystyk pokazuje paski i to samo położenie;
     - w logu `Stats window moved by the bars: …`.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Każdy commit (hash i temat) z wynikiem CI.
- Przyczyna lewej strony okna z F1 pkt 4.
- Wynik `rg` z §4.2 i lista różnic między stronami z F2 pkt 2.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.3.
