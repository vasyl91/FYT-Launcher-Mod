# Launcher Mod: pasek u góry według pudełka strony, pasek pionowy w pustym rogu, kreatory jak ekran główny — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `4b63a077`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

## 0. Commity (w tej kolejności)

| # | Temat commita | Źródło |
|---|---|---|
| E1 | `Bars: the top bar and its handle take the box of the page, not of the workspace` | właściciel; przegląd D1 |
| E2 | `Bars: the vertical bar fills the corner where the collapsed bar has no button` | właściciel |
| E3 | `Creators: the bars look as they do on the home screen` | właściciel; przegląd D2 |

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
- I/O;
- operacji na bazie, wywołań `ContentResolver` ani dostępu do sieci;
- wywołań `su` ani blokujących wywołań hosta VD.

**Testy:** JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `BarLayoutTest`, `TopBarFrameTest`, `HorizontalBarPlacementTest`. Logikę pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:** bez nowych zależności i bez nowych stringów.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/`.

## 2. Fakty

### 2.1 Przegląd rundy 9 (`a4f522bf`…`4b63a077`)
- **D4 działa** u właściciela (dotyk przechodzi, swipe otwiera pasek). D4 nie zmieniasz.
- D2 (reguła przycisk albo uchwyt, obrót strzałki, komórka narożna ze strony uchwytu, `BarLayouts`) i D3 (pasek pionowy na każdej stronie) działają według właściciela, poza tym, co niżej.

### 2.2 D1 mierzy pudełko na `Workspace`, a ten leży od samej góry okna
- **Pomiar:** `Workspace.barBoxOnScreen()` (D1) bierze `getLocationOnScreen` i padding samego `Workspace`.
- **Dlaczego `Workspace` leży od y=0:**
  - `Workspace` jest `Insettable`, a jego `setInsets` (≈572) tylko zapisuje insety w `mInsets`.
  - `DragLayer.fitSystemWindows` (≈95–106) dzieciom `Insettable` nie dodaje marginesów.
  - `Workspace` leży więc od góry okna. Jego górna krawędź to 0, a padding też 0.
- **Skutek:**
  - Po pierwszym pomiarze `box.top = 0` i `box.left = 0` na **każdym** urządzeniu. Wstawki z insetów (gałąź `else`) działają tylko przed pierwszym układem.
  - Nakładka paska u góry i uchwyt zaczynają się od rogu ekranu, także na FYT z Androidem 10. Tam przed D1 `topBarOffset()` dawał w poziomie wysokość paska statusu, więc to regres.
  - Okno paska statusu leży nad oknami `TYPE_APPLICATION_OVERLAY`. Zakrywa górną część paska, więc paska nie widać w całości. Na zrzucie A55 widać tylko pas w obszarze paska statusu.
- **Gdzie zaczyna się strona:** pod paskiem statusu. Pozycje w `CellLayout` liczą się jako `lp.y + mLauncher.getStatusBarHeight()` (≈4265, ≈4350, ≈4459, ≈4530).
- **Dlaczego pasek u góry na samej stronie (bez auto-hide) jest dobrze:** wisi na korzeniu układu strony 0 (`workspaceView`, ConstraintLayout z `iv_list_bg`). Ten korzeń leży poniżej paska statusu.

### 2.3 Pusty róg przy pasku pionowym i uchwycie po różnych stronach
- **Pasmo w `BarLayout`:** `verticalBarBand()` (≈66–71) zawsze kończy pasek pionowy na paśmie paska poziomego, gdy ten jest na stronie (`bandHeight()`). Nie patrzy na to, czy w rogu coś jest.
- **Układ strony 0:** `rl_vertical_bar` ma `Bottom_toTopOf="@id/iv_list_bg"` (u góry po `BarConstraints`: `Top_toBottomOf`).
- **Skutek przy auto-hide z uchwytem po drugiej stronie** (`buttonShown() == false`):
  - `hideNormalHorizontalBar` (D2) chowa zwinięty pasek razem z tłem;
  - pasek pionowy kończy się nad pustym rogiem.
  - To samo dotyczy okna paska pionowego na innych stronach (`verticalWindow`, ≈93–106).
- **Pojemność listy paska pionowego:** liczy ją `Launcher` z wysokości widoku (`BarCapacity.leftCapacity(mHost.getHeight(), …)` ≈8963 i ≈9167).

### 2.4 Kreatory nie idą za regułami pasków
- **`settings/DrawViewFirstScreen` ≈302:** `mCollapsedBarReserved = AUTO_HIDE_HORIZONTAL_BAR && VERTICAL_BAR`. Nie korzysta z `BarLayout.buttonShown()`.
  - Przy stronach różnych kreator pokazuje i rezerwuje przycisk w rogu, a ekran główny ma uchwyt.
- **Brak uchwytu w kreatorze:** kreator nigdzie nie rysuje uchwytu, ani jego strony, ani położenia góra/dół.
- **`creator_bar_auto_hide`** (`creator_vertical.xml` land ≈275–282) to sam kolorowy prostokąt (`colorPrimaryDark`), bez strzałki.
- **`resolveAutoHideBarBounds`** (≈1010–1045) kotwiczy oczekującą wysokość przy dolnej krawędzi („the bar is bottom-aligned in every creator layout”). U góry to już nieprawda.
- **Pasek pionowy w kreatorach** kończy się na pasku poziomym tak jak na stronie (§2.3).
- **Pasek pionowy w kreatorze innych stron:** `CreatorOtherScreens` ≈126 rysuje go według `BarLayouts.verticalOnPage`.

---

## E1 — `Bars: the top bar and its handle take the box of the page, not of the workspace`
1. **`barBoxOnScreen()` mierzy korzeń układu strony 0** (`workspaceView`, rodzic `iv_list_bg`), nie `Workspace`:
   - `top` = jego górna krawędź na ekranie (nie zmienia się przy przewijaniu stron w poziomie);
   - `left` i `right` = jego krawędzie, jakby strona 0 była pokazana: położenie w obrębie swojej strony plus lewa krawędź `Workspace` na ekranie, niezależnie od przewinięcia;
   - przed pierwszym układem: insety okna jak dziś.
   - Usuń pomiar `Workspace` (`getLocationOnScreen(mBarBoxAt)` na `this`) po `rg`.
2. **Nowy pomiar** po każdym układzie korzenia (`OnLayoutChangeListener` na `workspaceView`, ten sam mechanizm `scheduleBarBoxCheck` / `applyBarBoxChange`) oraz po przebudowie strony (`createUserPage`).
3. **Zgodność z paskiem na stronie.** Okno nakładki u góry ma ten sam prostokąt na ekranie co `iv_list_bg` na stronie 0 przy pasku u góry bez auto-hide: x, y, szerokość i wysokość. Dzieci (`rl_allapps`, `recycler_view`, `show_bar`, widżety paska) mają te same rozmiary co na stronie.
   - Raz, po pierwszym narysowaniu nakładki u góry, zaloguj oba prostokąty: `Top bar: page <l,t,r,b>, overlay <l,t,r,b>` (nakładka z `getLocationOnScreen` `iv_list_bg` w oknie).
   - Gdy się różnią, popraw rozmiary w `forceOriginalSizesLayoutOne` / `forceOriginalSizesLayoutTwo` tak, żeby były równe. Przyczynę różnicy opisz w commicie.
4. **Uchwyt u góry:** `y = box.top`; `x` jak w `TopBarFrame.handle`. Wysokość = wysokość paska, czyli cały pasek uchwytu poniżej paska statusu.
5. **Okno paska pionowego z D3** bierze ten sam `barBoxOnScreen()`, więc E1 poprawia i jego.
6. **Test:**
   - `TopBarFrameTest` zostaje.
   - Nowy czysty `PageBox.of(rootLeftInPage, rootTopOnScreen, rootWidth, workspaceLeftOnScreen)` → prostokąt.
   - Przypadki:
     - FYT w poziomie (top = pasek statusu, left = 0);
     - A55 w pionie (top = pasek statusu z wycięciem);
     - przewinięcie stron nie zmienia wyniku.
7. **Log** `Horizontal bar at the top: box …` zostaje, raz na zmianę.

## E2 — `Bars: the vertical bar fills the corner where the collapsed bar has no button`
1. **`BarLayout` dostaje `autoHide`** (`BarLayouts` czyta `AUTO_HIDE_HORIZONTAL_BAR`). Nowa reguła:
   - `cornerTaken() = horizontalOnPage && (!autoHide || buttonShown())`;
   - `verticalBarBand()` kończy pasek pionowy na paśmie paska poziomego tylko przy `cornerTaken()`, a w innym wypadku daje pełną wysokość pudełka;
   - `verticalWindow()` liczy z tego samego pasma.
   - Testy `BarLayoutTest`: pasek u góry i u dołu × strony zgodne i różne × auto-hide wł./wył. × pasek poziomy na stronie tak/nie.
2. **Układ strony 0** (`Workspace.applyBarConstraints` ≈1662 → `BarConstraints`):
   - gdy `!cornerTaken()`, `rl_vertical_bar` sięga krawędzi `parent` po stronie paska poziomego (zamiast `iv_list_bg`);
   - gdy `cornerTaken()`, zostaje jak dziś.
   - `BarConstraints.apply` dostaje parametr `verticalFullHeight`.
3. **Wysunięty pasek poziomy** (nakładka) przykrywa róg jak dziś, bo okno leży nad stroną. Bez zmian.
4. **Pojemność listy:** po wydłużeniu paska lista paska pionowego mieści więcej ikon. Sprawdź, że `BarCapacity.leftCapacity` dostaje nową wysokość po przebudowie (≈8963, ≈9167). Wynik dla 1280×720 i 1080×2340 wpisz do raportu.
5. **Komórki i prostokąty:** kolumna paska pionowego jest wyłączona już przez przesunięcie i `maxRight`, więc nic nie zmieniasz. Komórka narożna zostaje po stronie uchwytu (D2).

## E3 — `Creators: the bars look as they do on the home screen`
1. **Czysta klasa `CreatorBars.of(BarLayout layout, boolean autoHide)`** → co rysuje kreator danej strony:
   - pasmo paska poziomego (góra/dół; przy auto-hide pokazywane i chowane dwuklikiem jak dziś);
   - pasmo paska pionowego według `verticalBarBand()` z E2;
   - prostokąt przycisku (tylko `buttonShown()` i auto-hide) z obrotem strzałki (180° po prawej);
   - pasek uchwytu (tylko przy auto-hide bez przycisku na tej stronie): strona uchwytu, góra/dół, szerokość widocznego paska `HorizontalBarEdgeHandle.STRIP_WIDTH_FRACTION` w skali podglądu, wysokość paska.
   - Test `CreatorBarsTest`: 4 kombinacje stron × góra/dół × auto-hide × strona 0 i inna (z paskami na każdej stronie i bez).
2. **`DrawViewFirstScreen`:**
   - `mCollapsedBarReserved` (≈302) = przycisk z `CreatorBars`;
   - `creator_bar_auto_hide` stoi po stronie paska pionowego i pokazuje strzałkę `show_bar` (jak na stronie, z obrotem);
   - `resolveAutoHideBarBounds` (≈1010) kotwiczy oczekującą wysokość przy krawędzi, przy której jest pasek (góra albo dół).
3. **Pasek uchwytu w podglądzie** to tylko obraz. Jak na ekranie głównym nie rezerwuje miejsca dla prostokątów (uchwyt przepuszcza dotyk), ale widać, gdzie jest.
4. **Pasek pionowy** we wszystkich kreatorach ma pełną wysokość według E2:
   - `creator_vertical.xml` przez `BarConstraints` z `verticalFullHeight`;
   - `CreatorOtherScreens` przy pasku pionowym na każdej stronie.
5. **`CreatorOtherScreens` / `DrawViewOtherScreens`:** przycisk w rogu albo pasek uchwytu na innych stronach według `CreatorBars`, czyli tak, jak `HorizontalBarPlacement.bar` decyduje dla innych stron.
6. **`DrawViewAppStats`** (≈181): paski, jeśli je rysuje, według `CreatorBars`.
7. **Napis i dwuklik** (`CreatorBarToggle`) bez zmian.

## 3. Czego NIE zmieniać
- D4 (monitor, tryb okna, `EdgeMonitorTracker`), reguł gestu ani widocznego paska uchwytu.
- Paska poziomego na dole (nakładka, insety dolne).
- Reguły przycisk albo uchwyt i komórki narożnej z D2.
- Wartości kluczy prefów i prostokątów użytkownika.

## 4. Weryfikacja
1. CI zielone po każdym commicie, a nowe testy przechodzą: `PageBoxTest`, rozszerzony `BarLayoutTest`, `CreatorBarsTest`.
2. `rg -n 'getLocationOnScreen\(mBarBoxAt\)' app/src/main/java` → zero.
3. **Scenariusze dla testera.** Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) FYT Android 10 (poziom) i A55 Android 16 (pion i poziom), pasek u góry + auto-hide:
     - uchwyt zaczyna się pod paskiem statusu;
     - wysunięty pasek leży dokładnie tam, gdzie pasek u góry bez auto-hide, w całości widoczny i tej samej wielkości;
     - w logu `Top bar: page …, overlay …` z równymi prostokątami.
     Ten sam test z paskiem na każdej stronie.
   - b) Pasek pionowy po prawej + uchwyt po lewej + auto-hide (i odwrotnie): pasek pionowy sięga krawędzi ekranu, bez pustego rogu. Lista mieści więcej ikon. Wysunięty pasek poziomy przykrywa róg.
   - c) Strony zgodne: przycisk w rogu jak dotąd, pasek pionowy kończy się nad nim.
   - d) Kreatory (strona 0, inne strony, statystyki) dla każdej kombinacji z a–c:
     - pasek poziomy u góry lub u dołu jak na ekranie;
     - pasek pionowy po swojej stronie i tej samej wysokości;
     - przycisk ze strzałką tylko przy zgodnych stronach;
     - pasek uchwytu po jego stronie, gdy przycisku nie ma.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Każdy commit (hash i temat) z wynikiem CI.
- Prostokąty z logu `Top bar: page …, overlay …`, jeśli masz log, i pojemność listy z E2 pkt 4.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.3.
