# Launcher Mod: crash uchwytu paska, ikony i szarpanie paska „na każdej stronie” — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `11e49736`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`.

Wszystkie przyczyny poniżej są już znalezione i potwierdzone w logach. Naprawiasz dokładnie je.

## 0. Kolejność commitów i jej powód

| # | Temat commita | Źródło | Dlaczego tutaj |
|---|---|---|---|
| C1 | `Edge handle: a gesture handed on to the launcher survives the handle being hidden` | §2.2, crash | Crash, niezależny od reszty. |
| C2 | `Bottom bar: the bar on every page gets the apps when they arrive after it` | §2.3, Bug 2 | Mały. C3 korzysta z niego, bo okno w gotowości też może powstać przed adapterem. |
| C3 | `Bottom bar: the bar on every page is ready before the first page starts to move` | §2.4, Bug 1 | Największy, na C2. |

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
- Przed pushem uruchom lokalnie `./gradlew :app:testSystemDebugUnitTest`.

**StrictMode jest włączony.** W nowym kodzie na wątku głównym nie może być:
- I/O plików;
- zapytań do bazy;
- zapytań do `ContentResolver`;
- sieci;
- `su`;
- blokujących wywołań hosta VD.

Prefy zapisuj przez `apply()`.

**Testy:**
- JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `BottomBarPlacementTest`, `BottomBarEdgeGestureTest`.
- `unitTests.isReturnDefaultValues = true`.
- Logikę decyzyjną pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:** bez nowych zależności; bez zmiany schematu bazy launchera; bez nowych stringów.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/` (`--glob '!**/generated/**'`, Java, Kotlin, XML, gradle, workflowy, skrypty).

## 2. Fakty

### 2.1 Przegląd rundy 4 (`0767fd7a..11e49736`): bez błędów do naprawy
CI wszystkich 7 commitów jest zielone. Sprawdzone i poprawne:
- `WidgetBarLines.effective` usunięty;
- wiersze ustawień w kolejności z briefu i z ich widocznością;
- 59 plików stringów (`widget_bar_line_mode`, `widget_bar_no_cover(_on)`, nowe `widget_bar_buttons_beside_on`);
- środkowanie jednej linii: `yButtons`, `oneLineTopPadding`, `FontShape`, jeden `withFont` na plan;
- rozmiary z boku przez `belowOneLine`;
- `besideButtonsShare` 35 / 50 / 40 i `BUTTON_FILL_ONE_ROW`;
- ukryta okładka: `placeCover`, `wide(…, coverHidden)`, `widensMusic` dla szerokości;
- `WeatherNeed`, `WeatherManager.shutdown()` oraz bramki w `LauncherWeather`, `WakeDetection` i `Workspace`.

Logi właściciela potwierdzają nowy układ, np. `layout=beside oneLine=true … buttons=236(1x4, 50%) … capTop=42`. Kodu rundy 4 nie zmieniasz.

### 2.2 Crash: `ConcurrentModificationException` w uchwycie paska
Log `crash_pid_05-11-2026_23-40-18`: SM-A556B, Android 16, app 1.2.1 (10201), flavor standard, auto-hide z uchwytem.
```
java.util.ConcurrentModificationException
  at java.util.ArrayList$Itr.next
  at BottomBarEdgeHandle$StripView.startPassing(BottomBarEdgeHandle.java:469)
  at BottomBarEdgeHandle$StripView.decided(:445)
  at BottomBarEdgeHandle$StripView.onTimeout(:430)
```

**Mechanizm:**
1. `startPassing` (≈453) w pętli po `held` przekazuje zdarzenia synchronicznie do `DecorView` launchera (`forward` ≈483 → `dispatchTouchEvent`).
2. Odtworzone ruchy zaczynają przesuwanie stron: `Workspace.onPageBeginMoving` (≈3917) → `updateEdgeHandle("page moving")` (≈3952) → `BottomBarEdgeHandle.hide` (≈143) → `StripView.cancelGesture` (≈309).
3. `cancelGesture` przekazuje launcherowi `ACTION_CANCEL`, a `endGesture` (≈320) recyklinguje i czyści `held` w trakcie tej samej pętli.

Log: `23:40:18.027 Edge handle: pass (launcher)` → `.029 onPageBeginMoving()` → `.030 Edge handle hidden (page moving)` → `.031 FATAL EXCEPTION`.

**Wariant bez crasha (23:40:11).** Decyzja PASS zapada na żywym ruchu i to samo ukrycie wysyła `ACTION_CANCEL` do launchera. Przesuwanie strony zostaje anulowane przy pierwszym ruchu. Reszta gestu jest zjadana (`tracking=false`, `passing=null`, ≈392). Swipe zaczęty na marginesie uchwytu nie przesuwa więc strony.

### 2.3 Bug 2: pasek „na każdej stronie” bez ikon po powrocie z ustawień (home ≠ pierwsza strona)
**Kod:**
- `createUserPage` (≈844) woła najpierw `cleanupAllResources` (≈2941): stara nakładka znika, a adapter recyclera paska wbudowanego dostaje `null` (≈2961).
- Nowy pasek wbudowany ma recycler bez adaptera.
- `setCurrentPage(START_PAGE − 1)` (≈977) i `updateEdgeHandle("createUserPage", 0)` (≈1007) od razu budują trwałą nakładkę na stronie N.
- `setupOverlayView` podpina adapter tylko, gdy pasek wbudowany już go ma (≈1812: `if (bottomBarRecycler.getAdapter() != null) setupRecyclerView(…)`).
- `LauncherAppBars.initAppData` (≈456) → `setupRecyclerView` (≈623, adapter ≈642) przychodzi chwilę później i podpina adapter **tylko do paska wbudowanego**.
- Nakładka zostaje pusta, dopóki nie zostanie zbudowana od nowa, czyli po wizycie na pierwszej stronie.

**Log `user_pid_05-11-2026_23-47-06`:**
- `19.486 Persistent bottom bar shown (createUserPage) on page 1`
- `19.506 addView BarSwipeFrame`
- `19.553 RecyclerView: No adapter attached; skipping layout`
- `19.558 initAppData() started`, `setupRecyclerView … ItemCount: 5`
- `23.190 Persistent bottom bar hidden (page settled)`, czyli dopiero na pierwszej stronie.

### 2.4 Bug 1: pasek szarpie i wyjeżdża poza ekran przy przesuwaniu z pierwszej strony
Dotyczy tylko pierwszej strony (tej z paskiem wbudowanym), także gdy nie jest home screenem. Tylko tam trwała nakładka powstaje w chwili ruchu; na pozostałych stronach już stoi. Dwa mechanizmy, oba w logu `user_pid_05-11-2026_23-42-18` (A55, z lewym paskiem).

**a) Nakładka jest budowana w środku gestu.**
- `onPageBeginMoving` → `updatePersistentBar` (≈2700) → `showPersistentOverlay` (≈2741) → `showOverlayBottomBar` (≈1675) robi synchronicznie:
  - inflację `custom_layout_two_user`;
  - `WidgetBarLayout.apply`;
  - `setupOverlayView` (recycler, `forceOriginalSizes`);
  - `setupOverlayWidgetBar`: wiązanie muzyki, pogody i dopasowanie tekstów;
  - `addView`.
- Potem pierwszy przebieg okna i jeszcze posty `updateWeather` / `enableRecycler`.
- Na A55:

  | Czas | Zdarzenie |
  |---|---|
  | 21.003 | `onPageBeginMoving()` |
  | 21.042 | `addView` |
  | 21.147 | pierwsza klatka nakładki (**144 ms** po starcie ruchu) |
  | 21.316–21.317 | `Recycler enabled` i `MusicWidgetSizer` nakładki |

- Strona (pozycje paneli PiP w logu) w tym czasie stoi i skacze o 424 px (21.151→21.162), a potem o 492 px (21.169→21.320). `WindowUtil: pane moves: 15 in 589 ms, … max 74.5 ms`.
- Na jednostkach FYT jest to kilka razy wolniejsze. Przy szybkim swipe pasek wbudowany odjeżdża ze stroną, zanim nakładka się narysuje.

**b) Ruch zaczęty podczas crossfade'u po powrocie na pierwszą stronę nie dostaje nakładki wcale.**
- Z lewym paskiem `hidePersistentOverlay` (≈2759) wygasza nakładkę przez `PERSISTENT_CROSSFADE_MS` (150 ms, ≈366).
- W tym czasie `showPersistentOverlay` wychodzi od razu (`isOverlayAnimating || overlayBottomBar != null`, ≈2743).
- Log:

  | Czas | Zdarzenie |
  |---|---|
  | 32.837 | `Persistent bottom bar hidden (page settled)` |
  | 32.985 | `onPageBeginMoving()`, bez `shown` |
  | 33.001 | `removeView` |
  | 33.660 | `Persistent bottom bar shown (page settled) on page 1` |

- Przez cały ruch nie ma nakładki: pasek wyjeżdża z pierwszą stroną poza ekran i wraca dopiero po zatrzymaniu.

## C1 — `Edge handle: a gesture handed on to the launcher survives the handle being hidden`
1. **Odtwarzanie z własnej kopii.**
   - `startPassing` przed pierwszym `forward` przenosi zdarzenia do lokalnej listy (`List<MotionEvent> replay = new ArrayList<>(held); held.clear();`).
   - Przekazuje je, dopóki `passing` jest tym samym celem.
   - Na końcu recyklinguje je w `finally`.
   - Gest zakończony w odtworzeniu (UP / CANCEL) kończy przekazywanie jak dziś.
2. **Ukrycie w trakcie przekazywania nie przerywa gestu.**
   - `hide()` przy `passing != null` nie woła `cancelGesture()`.
   - Pasek tylko wygasza się do alpha 0. Okno zostaje `VISIBLE` i dotykalne do końca przekazanego gestu (UP albo systemowy CANCEL), bo inaczej system może odciąć gest od tego okna.
   - Potem ukrycie się kończy (`setTouchable(false)`, `INVISIBLE`), chyba że w międzyczasie przyszło `show()`.
   - Log raz: `Edge handle: hidden after the gesture handed on ended`.
3. **Pozostałe przypadki bez zmian.** Gest jeszcze nierozstrzygnięty (`tracking`, nic nie przekazano) `hide()` dalej anuluje. `release()` dalej anuluje wszystko, bo okno znika.
4. **Czysta klasa `EdgeHandlePass`** (bez `android.*`) z regułami z p. 2–3. Test JUnit 5:
   - ukrycie w trakcie przekazywania jest odroczone, a koniec gestu je kończy;
   - `show()` w międzyczasie odwołuje odroczone ukrycie;
   - ukrycie przy nierozstrzygniętym geście anuluje od razu;
   - odtworzenie z kopii (generyczne `List<T>`) przechodzi wszystkie elementy, nawet gdy w trakcie lista źródłowa zostanie wyczyszczona i zapełniona.

## C2 — `Bottom bar: the bar on every page gets the apps when they arrive after it`
1. **Nowa metoda `Workspace.onBottomBarAdapterReady()`** (publiczna).
   - Woła ją `LauncherAppBars.setupRecyclerView` (≈623) zaraz po ustawieniu adaptera na pasku wbudowanym. Przez tę metodę idą też `initAppData` i `forceInitializeWithDefaults`.
   - Jeśli istnieje okno nakładki (trwałe albo auto-hide), a jego recycler nie ma tego samego adaptera co pasek wbudowany, wywołuje `setupRecyclerView(bottomBarRecycler, overlayRecycler)` (≈2146; dekoracje dodaje tylko raz, po tagu).
   - Log raz na okno: `Overlay bar: apps attached after it was built`.
   - Przy tym samym adapterze nic nie robi.
2. `setupOverlayView` zostaje jak jest: bez adaptera ustawia tylko `LayoutManager`, a adapter dojdzie przez p. 1.
3. Bez zmian w danych paska, `AppListAdapter` i opóźnieniach `initAppData`.

## C3 — `Bottom bar: the bar on every page is ready before the first page starts to move`
**Zasada:** okno trwałej nakładki istnieje przez cały czas, gdy launcher jest na wierzchu w trybie „na każdej stronie” (bez auto-hide, w układzie użytkownika). Nakładka, która ma się pokazać w chwili ruchu, jest już zbudowana i narysowana. Pokazanie jej to tylko zmiana alpha i dotykalności, bez inflacji i bez `addView` w geście.

1. **Stany okna.** Czysta klasa `PersistentBarWindow` z testem:
   - stany:

     | Stan | Okno |
     |---|---|
     | `NONE` | brak okna |
     | `STANDBY` | okno jest, alpha 0, `FLAG_NOT_TOUCHABLE`, widżety paska związane z paskiem wbudowanym |
     | `SHOWN` | alpha 1, dotykalne, widżety związane z nakładką |

   - cel: `target(mode, inFront, permitted, bar, free)`, gdzie:
     - `mode` to warunek z `updatePersistentBar` ≈2701;
     - `inFront` to `mEdgeHandleHostVisible`;
     - `permitted` to `!mPersistentFailed && canDrawOverlays`;
     - `bar` to `BottomBarPlacement.bar(…)`;
     - `free` to reszta `persistentBarAllowed` ≈2723: stan NORMAL, WORKSPACE, bez przeciągania, folderu i dialogu listy.
   - reguły celu:
     - `NONE`, gdy `!mode || !inFront || !permitted`;
     - `SHOWN`, gdy `bar == PERSISTENT_OVERLAY && free`;
     - w każdym innym przypadku `STANDBY` (pierwsza strona w spoczynku, wszystkie aplikacje, przegląd, przeciąganie, folder, dialog).
   - akcja: `action(current, target, pageMovingFromFirst)` daje jedną z:

     | Akcja | Kiedy |
     |---|---|
     | `BUILD_LATER` | `NONE` → `STANDBY` |
     | `BUILD_NOW` | `NONE` → `SHOWN` |
     | `ACTIVATE` | `STANDBY` → `SHOWN` |
     | `PARK` | `SHOWN` → `STANDBY` |
     | `REMOVE` | cokolwiek → `NONE` |
     | `NOTHING` | bez zmiany |

   - Test obejmuje każdy wiersz obu tabel.
2. **`updatePersistentBar(reason)`** (≈2700) liczy cel i wykonuje akcję.
   - `BUILD_LATER`: `mainHandler.postDelayed(…, PERSISTENT_STANDBY_DELAY_MS = 250)`. Przy wykonaniu sprawdza cel jeszcze raz i nie buduje, gdy strony się przesuwają.
   - `BUILD_NOW` w geście (początek ruchu z pierwszej strony bez gotowego okna, np. tuż po `onResume`) buduje jak dziś i loguje `Persistent bottom bar: no standby window yet, built now`. To jedyny przypadek budowy w geście.
3. **Budowa okna w gotowości.** Ten sam kod co dziś (`showOverlayBottomBar` dla trwałej nakładki), z różnicami:
   - `FLAG_NOT_TOUCHABLE` od razu w `overlayWindowParams`;
   - alpha 0;
   - bez `updateWeather` i bez `enableRecycler` po dodaniu.
   - Po pierwszym layoucie okna jedno wiązanie widżetów z nakładką (`setupOverlayWidgetBar`, ≈1844), a zaraz potem powrót wiązania do paska wbudowanego. Dzięki temu `MusicWidgetSizer` i dopasowania tekstów są już policzone dla nakładki, a pokazanie nie zmienia żadnych rozmiarów.
   - Recycler dostaje adapter jak dziś albo przez C2.
4. **`ACTIVATE`** (synchronicznie, także w `onPageBeginMoving`):
   1. anuluj trwające wygaszanie z p. 5. Jego akcja końcowa nie może się wykonać, użyj licznika generacji;
   2. zwiąż widżety z nakładką (`setupOverlayWidgetBar` i `updateFavoriteButtonState`);
   3. alpha 1 i `setOverlayTouchable(true)` (≈2478);
   4. log `Persistent bottom bar shown (<reason>) on page <n>, from standby in <ms> ms`.

   Bez inflacji, `addView`, pobierania pogody i postów `enableRecycler`.
5. **`PARK`:**
   1. `setOverlayTouchable(false)` od razu;
   2. alpha → 0: z lewym paskiem przy powrocie na pierwszą stronę przez `PERSISTENT_CROSSFADE_MS`, inaczej od razu;
   3. po wygaszeniu powrót wiązania do paska wbudowanego przez `refreshWidgetBarAfterWake("persistent bar parked")` (≈1490).
   4. Okno i adapter zostają.
   5. Log `Persistent bottom bar parked (<reason>)`.
6. **`REMOVE`.** Jak dziś: `finishPersistentHide` (≈2800) albo `cleanupOverlayImmediately` przy `onPause`, `createUserPage`, odłączeniu i wyłączeniu opcji. Na powrocie (`onResume`, przebudowa) znów `BUILD_LATER`.
7. **Flagi.**
   - `isOverlayShowing` znaczy dalej „okno istnieje”: `cleanupAllResources` ≈2946 musi usunąć także okno w gotowości.
   - Nowe pole `mPersistentShown` znaczy „nakładka pokazuje pasek”.
   - `refreshWidgetBarAfterWake` (≈1503) wraca wcześniej tylko wtedy, gdy pasek pokazuje nakładka: auto-hide albo `mPersistentShown`.
   - Przejrzyj wszystkie miejsca `rg -n 'isOverlayShowing|mOverlayPersistent' app/src/main/java` i w opisie commita wymień te, których znaczenie się zmieniło.
8. **Mechanizm 2.4 b znika.** Ruch zaczęty w trakcie wygaszania to `ACTIVATE` na istniejącym oknie, a nie wczesny powrót.
9. **Okno w gotowości nie przeszkadza.** `FLAG_NOT_TOUCHABLE` przepuszcza dotyk (to okno tego samego UID). Ikony, przyciski muzyki i lista aplikacji pierwszej strony działają jak bez niego.

## 3. Czego NIE zmieniać
- Reguł `BottomBarPlacement` i rezerwacji wierszy.
- Nakładki auto-hide: wjazdu, licznika, `ACTION_OUTSIDE`.
- Decyzji `BottomBarEdgeGesture` (OPEN_BAR / PASS) ani geometrii uchwytu.
- Geometrii nakładki (z lewym paskiem dalej na pełną szerokość) ani crossfade'u przy powrocie.
- Kodu rundy 4.

## 4. Weryfikacja
1. Po każdym commicie CI jest zielone, a nowe testy (`EdgeHandlePassTest`, `PersistentBarWindowTest`) przechodzą.
2. Oczekiwane logi (właściciel nagra je na A55):
   - C1: bez crasha. Po przytrzymaniu palca na marginesie uchwytu i swipe na stronę: `Edge handle: pass (launcher)`, `onPageBeginMoving()`, `Edge handle: hidden after the gesture handed on ended`.
   - C2: po powrocie z ustawień z home screenem na stronie 2: `Overlay bar: apps attached after it was built` zaraz po `initAppData`.
   - C3:
     - między `onPageBeginMoving()` z pierwszej strony a `onPageEndMoving` nie ma `addView … BarSwipeFrame`;
     - jest `shown … from standby in ≤10 ms`;
     - `pane moves … max` jak przy ruchu między innymi stronami (bez skoków 70+ ms);
     - przy powrocie na pierwszą stronę i natychmiastowym odejściu (w ciągu 150 ms) nakładka pokazuje się na początku ruchu.
3. Scenariusze dla testera. Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Auto-hide z uchwytem: przytrzymaj palec na przezroczystym marginesie uchwytu ~0,5 s i przesuń na następną stronę, potem to samo szybkim swipe'em. Strona się przesuwa, launcher się nie zamyka.
   - b) „Bottom bar on every page”, bez auto-hide, bez lewego paska: 10 razy wolno i 10 razy szybko z pierwszej strony na drugą. Pasek stoi w miejscu, nie szarpie i nigdy nie wyjeżdża poza ekran.
   - c) To samo z lewym paskiem, także powrót na pierwszą stronę i natychmiastowe odejście.
   - d) Home screen ustawiony na stronę 2 (i 3): po powrocie z ustawień pasek na tej stronie od razu ma ikony.
   - e) Pierwsza strona w spoczynku: ikony paska, przyciski muzyki i lista aplikacji z przytrzymania reagują normalnie.
   - f) Ze strony 2: wszystkie aplikacje, przegląd, folder, przeciąganie ikony i powrót. Pasek wraca od razu z ikonami i bieżącym utworem.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash i temat) z wynikiem CI każdego.
- Lista miejsc z `isOverlayShowing` / `mOverlayPersistent` i decyzja dla każdego.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.3.
