# Launcher Mod: swipe z paska auto-hide, PiP w tempie stron, Pinned PiP tylko na 7862/8581 — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz` (najpierw `git pull origin ccr-087eed00-gbqsuz`). Wprowadź zmiany opisane niżej, każdą jako osobny commit, i wypchnij je na tę gałąź. **Nie twórz pull requesta.**

Ta runda następuje po `docs/sonnet-prompt-2026-10-27-music-widget.md` (commity do `8cc9e48`). Jej zmian nie cofaj. Numery linii to stan z `8cc9e48` i są orientacyjne. Zawsze sprawdzaj je w kodzie.

## 0. Urządzenia i najważniejsza zasada

| Urządzenie | Android | Wariant | Uprawnienia | Panele PiP | Uwagi |
|---|---|---|---|---|---|
| FYT 7862 | 10 | `fyt`, aplikacja systemowa | system | `ActivityView` frameworku | Pinned PiP **działa i ma działać** |
| FYT 8581 | 10 | `fyt` | system | jak 7862 | Pinned PiP ma działać |
| FYT UNISOC 7870 | 13 | `standard` | Shizuku (bezprzewodowe ADB) | VD (`WindowHostVdView`) | `StockSources.isSyuMediaUnit()`; Pinned PiP **wyłączyć** |
| Xiaomi Redmi Note 8T | 14 | `standard` | root (VDHost) | VD | telefon |
| Samsung Galaxy A55 | 16 | `standard` | Shizuku Next | VD | 120 Hz; tu PiP zostaje w tyle |

Na 7862 każda zmiana jest no-opem albo ścisłą poprawą: E1 (swipe z nakładki) zmienia tylko pasek auto-hide, E2 (panele) usuwa wyłącznie zbędną pracę. Wyjątek to celowo E3, które na 7862 nie zmienia niczego. Każdą zmianę, która dotyka 7862, uzasadnij w treści commita („on the 7862 … stays as before because …”).

## 1. Zasady pracy i konwencje repo (jak w poprzednich rundach)

- **Komentarze i commity po angielsku**, w stylu otaczającego kodu: pełne zdania, wyjaśniają *dlaczego*. Gęstość komentarzy jak w sąsiednim kodzie.
- **Commity**: temat w trybie rozkazującym `<Obszar>: <co>`, treść zawinięta na ~72 znaki. Zakończ dokładnie trailerami z system-remindera sesji. **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Jeden commit = jedna logiczna zmiana** (E1, E2, E3 w tej kolejności). Push: `git push -u origin ccr-087eed00-gbqsuz` (przy błędzie sieci ponów 4× z odstępem 2/4/8/16 s).
- **Nie ruszaj commita `57e3600 [BRANCH-ONLY] CI: …` ani plików `.github/workflows/*.yml`.**
- **Logowanie**: `android.util.Log` z `TAG` danej klasy. Rutynowe zdarzenia na `I`/`D`.
- **StrictMode** (debug): nic z dysku ani sieci na wątku głównym.
- **Testy**: JUnit 5 na JVM (`app/src/test/java`, `unitTests.isReturnDefaultValues = true`). Logikę decyzyjną wydziel do **czystych klas bez `android.*`** i przetestuj ją.
- **Bez nowych zależności.** Nie zmieniaj schematu baz ani nowych `strings.xml`.
- **Budowanie**: w kontenerze zwykle nie ma Android SDK. CI (`build.yml`) przy każdym pushu uruchamia `:app:testFytDebugUnitTest`, `:app:assembleFytDebug` i `:app:assembleStandardDebug`. Workflow ma `cancel-in-progress`, więc sprawdzaj run **ostatniego** commita (GitHub MCP `actions_list`/`get_job_logs` albo `curl -s "https://api.github.com/repos/vasyl91/FYT-Launcher-Mod/actions/runs?branch=ccr-087eed00-gbqsuz&per_page=1"`). Czerwoną budowę naprawiaj od razu.
- **Kontrola bez SDK**: klasy bez androidx skompilujesz `javac -proc:none -cp android_jar/android-36.jar -d <tmp> <pliki>` (stuby klas projektu w katalogu tymczasowym, nie w repo). Ten jar zawiera też API ukryte. Że coś się kompiluje, nie znaczy, że jest w publicznym SDK (compileSdk 37). Czyste klasy i ich testy kompiluj samym `javac` z JUnit z cache Gradle (jeśli jest) albo starannie przeczytaj.
- `Workspace.java` ma ponad 7000 linii. Edytuj punktowo i nie przenoś istniejącego kodu.

---

## E1 — Workspace: przeciągnięcie po pasku auto-hide przewija strony i chowa pasek

### Jak jest dziś (fakty z kodu)
- **Zwykły pasek** to widok wewnątrz strony 0. `Workspace.createUserPage()` (≈901–1053) wstawia `custom_layout_{one,two}_user` do `customScreen[0]`. Poziome przeciągnięcie przejmuje `PagedView.onInterceptTouchEvent` (≈1424–1538): po przekroczeniu slopu (`persist.sys.la_touch_slop`, domyślnie 8 px) i przy kącie z `Workspace.determineScrollingStart` (≈3560–3602) dzieci dostają `ACTION_CANCEL`. Gdy dziecko wywoła `requestDisallowInterceptTouchEvent(true)` (RecyclerView robi to dopiero, kiedy faktycznie przewinął treść), rodzic przestaje przechwytywać (`PagedView.requestDisallowInterceptTouchEvent` ≈1382 woła `super`).
- **Nakładka auto-hide**: `Workspace.showOverlayBottomBar()` (≈1633–1733) pompuje ten sam układ drugi raz (`overlayBottomBar = inflater.inflate(...)`, ≈1676–1680). Dodaje go jako osobne okno `TYPE_APPLICATION_OVERLAY`, `MATCH_PARENT × wysokość paska`, z flagami `FLAG_NOT_FOCUSABLE | FLAG_NOT_TOUCH_MODAL | FLAG_WATCH_OUTSIDE_TOUCH | FLAG_LAYOUT_IN_SCREEN` (≈1651–1671, `addView` ≈1713). Dotknięcia z tego okna **nigdy** nie trafiają do Workspace.
- **Chowanie przy przewijaniu siatki**: dotknięcie siatki daje nakładce `ACTION_OUTSIDE`. Listener w `setupOverlayView()` (≈1772–1778) woła wtedy `hideOverlayBottomBar()`. Ta metoda (`hideOverlayBottomBar(boolean)`, ≈2222–2281):
  - wywołuje `cancelPendingAutoHide()`;
  - wywołuje `setOverlayTouchable(false)`, które dodaje `FLAG_NOT_TOUCHABLE` (≈2313–2341);
  - zsuwa pasek przez `translationY` w `BAR_HIDE_DURATION_MS = 180` z `AccelerateInterpolator(1.5f)`;
  - na końcu woła `finishOverlayHide()`, które robi `removeView` (≈2284–2311);
  - wywołuje `setCollapsedBarShown(true, 180)` i postuje `launcher::disableRecycler`.
- **Gotowe API**: `Workspace.handleExternalSwipe(MotionEvent)` (≈3414–3478) przepuszcza zdarzenie z dowolnego okna przez stronicowanie Workspace. Robi to jak `ViewGroup`: `onInterceptTouchEvent`, aż przejmie gest, potem `onTouchEvent`. Pozycję X bierze 1:1 (z `getRawX`). Pozycję Y kotwiczy w środku Workspace. UP, które nie stało się przewijaniem, zamienia na CANCEL (bez „tapnięcia w tapetę”). DOWN na jeszcze osiadających stronach je łapie. Zwraca `false`, gdy stron nie da się teraz przewijać (`canPageFromExternalSwipe()` ≈3498). Stan trzyma w polach `mExternalSwipeTracking` i `mExternalSwipeScrolling`. Wzór użycia: `settings/StatusBarSwipeDetector.java` (`onStripTouch` ≈111–137, syntetyczny CANCEL w `onDestroy` ≈179–186).
- **Timer auto-hide**: `scheduleAutoHide()` (≈2660) chowa pasek po `Keys.AUTO_HIDE_TIMEOUT` sekundach także wtedy, gdy palec leży na pasku.

### Wymagania właściciela
1. Poziome przeciągnięcie zaczęte na nakładce przewija strony tak samo jak na zwykłym pasku: strona idzie za palcem i dociąga się z prędkością rzutu.
2. W chwili, gdy strony zaczynają się przesuwać, pasek się chowa: ta sama animacja zsuwania co dziś, a uchwyt lub zwinięty przycisk wraca jak dziś.
3. **Okno nakładki (obszar, który łapie dotyk) znika dopiero przy podniesieniu palca.** Palec może stać w miejscu, gdzie był pasek, a strony nadal mają za nim iść. Zdjęcie okna w trakcie gestu przerwałoby przewijanie (`ACTION_CANCEL`).
4. Bez wpływu na zwykłą obsługę paska: tapnięcia w ikony, przycisk wszystkich aplikacji, przyciski widgetu muzyki, przytrzymanie ikony (otwiera wybór aplikacji, `AppListAdapter` ≈354) i pionowe ruchy działają jak dziś.

### Implementacja
1. **Czysta klasa** `app/src/main/java/com/android/launcher66/BarSwipeGesture.java` (final, package-private, bez `android.*`). To maszyna stanów jednego gestu na nakładce. Stałe akcji mają te same wartości co w `MotionEvent`, więc ramka podaje `getActionMasked()` wprost: `DOWN = 0, UP = 1, MOVE = 2, CANCEL = 3`; każda inna wartość (np. `POINTER_DOWN = 5`, `POINTER_UP = 6`) to „inne”. Fazy:
   - `WATCHING`: widoki paska dostają zdarzenia, Workspace je obserwuje;
   - `PAGING`: gest należy do stron;
   - `BAR_ONLY`: Workspace odpadł, gest należy do paska.

   Wynik to maska bitów: `DISPATCH` (podaj zdarzenie widokom paska), `CANCEL_CHILDREN` (widoki paska dostają jeden `ACTION_CANCEL`), `HIDE_BAR` (strony ruszyły: schowaj pasek; najwyżej raz na gest), `STOP_FEEDING` (zakończ udział Workspace syntetycznym `ACTION_CANCEL`).

   Dwie metody: `boolean shouldFeed(int action, long sinceDownMs, long longPressMs, boolean childDisallowed)`, wołana **przed** podaniem zdarzenia do Workspace, i `int afterFeed(int action, boolean fed, boolean paging, boolean childDisallowed)`, wołana **po** nim (`paging` = `Workspace.isExternalSwipePaging()`). Reguły:

   | Zdarzenie | Faza / warunek | Wynik | Nowa faza |
   |---|---|---|---|
   | DOWN | Workspace odmówił (`fed == false`) | `DISPATCH` | `BAR_ONLY` |
   | DOWN | `paging` (złapane osiadające strony, tak jak `ViewGroup` przechwytuje DOWN) | brak `DISPATCH` | `PAGING` |
   | DOWN | pozostałe | `DISPATCH`; po dispatchu przy `childDisallowed` → `STOP_FEEDING` | `WATCHING` / `BAR_ONLY` |
   | MOVE/inne | `BAR_ONLY` | `DISPATCH` (bez karmienia Workspace) | — |
   | MOVE/inne | `WATCHING`, a `childDisallowed` albo `sinceDownMs >= longPressMs` (`shouldFeed` = false) | `STOP_FEEDING \| DISPATCH` | `BAR_ONLY` |
   | MOVE | `WATCHING`, `paging` po karmieniu | `CANCEL_CHILDREN \| HIDE_BAR` | `PAGING` |
   | inne | `WATCHING`, `paging` po karmieniu | `CANCEL_CHILDREN` (bez HIDE, ukryje go najbliższy MOVE) | `PAGING` |
   | MOVE/inne | `WATCHING`, bez `paging` | `DISPATCH` | — |
   | MOVE | `PAGING`, pasek jeszcze nie ukryty | `HIDE_BAR` | — |
   | MOVE/inne | `PAGING` | nic (bez `DISPATCH`) | — |
   | UP/CANCEL | `BAR_ONLY` | `DISPATCH` | koniec |
   | UP/CANCEL | `WATCHING` | karm Workspace (UP zamieni na cichy CANCEL) i `DISPATCH` (tapnięcie dochodzi do ikony) | koniec |
   | UP/CANCEL | `PAGING` | karm Workspace (dociąga strony), bez `DISPATCH` | koniec |

   Uzasadnienie reguły długiego przytrzymania (komentarz w kodzie): przytrzymana ikona otwiera wybór aplikacji, więc gest, który przez `ViewConfiguration.getLongPressTimeout()` nie stał się przewijaniem, należy do paska. Inaczej strony przewijałyby się pod dialogiem. `childDisallowed` odwzorowuje semantykę `ViewGroup`: gdy widok paska (RecyclerView, który faktycznie przewinął listę) poprosi o brak przechwytywania, strony nie przejmują gestu, dokładnie jak na zwykłym pasku.

   Test `app/src/test/java/com/android/launcher66/BarSwipeGestureTest.java`:
   - tapnięcie: same `DISPATCH`, nigdy `HIDE_BAR`;
   - poziome przeciągnięcie: `paging` na k-tym MOVE daje raz `CANCEL_CHILDREN | HIDE_BAR`, potem bez `DISPATCH`, UP bez `DISPATCH`;
   - przytrzymanie ≥ `longPressMs`, potem ruch: `STOP_FEEDING`, nigdy `HIDE_BAR`;
   - `childDisallowed` w trakcie: `STOP_FEEDING`;
   - `fed == false` przy DOWN: sam pasek;
   - DOWN na osiadających stronach: brak `DISPATCH` przy DOWN; UP bez ruchu: brak `HIDE_BAR`; pierwszy MOVE: `HIDE_BAR`;
   - `HIDE_BAR` najwyżej raz;
   - DOWN zeruje stan poprzedniego gestu.

2. **Ramka** `app/src/main/java/com/android/launcher66/BarSwipeFrame.java` (`final class BarSwipeFrame extends FrameLayout`, package-private). Jest korzeniem okna nakładki, a napompowany układ paska jest jej jedynym dzieckiem.
   - `interface Host { boolean feed(MotionEvent e); boolean isPaging(); void onTouchStarted(); void onPagingStarted(); void onTouchEnded(); }`
   - `dispatchTouchEvent(ev)`:
     - `ACTION_OUTSIDE` → od razu `super.dispatchTouchEvent(ev)` (listener z `setupOverlayView()` chowa pasek jak dziś);
     - DOWN: wyzeruj `childDisallowed`, zapamiętaj `downTime = ev.getEventTime()`, wywołaj `host.onTouchStarted()`;
     - potem `shouldFeed` → `host.feed(ev)` → `afterFeed(...)` i wykonaj maskę:
       - `STOP_FEEDING`: kopia `MotionEvent.obtain(ev)` z `setAction(ACTION_CANCEL)` do `host.feed`, potem recycle;
       - `CANCEL_CHILDREN`: kopia z `ACTION_CANCEL` do `super.dispatchTouchEvent`;
       - `HIDE_BAR`: `host.onPagingStarted()`;
       - `DISPATCH`: `super.dispatchTouchEvent(ev)`.
     - Przy DOWN w fazie `WATCHING`, jeśli po dispatchu `childDisallowed`, to `STOP_FEEDING` (druga runda `afterFeed` albo osobna metoda, ale logika ma być w czystej klasie).
     - Przy UP/CANCEL na końcu `host.onTouchEnded()`.
     - Zwracaj `true` dla DOWN, który przyjął Workspace albo któreś dziecko. Inaczej okno nie dostanie reszty gestu. Prościej: zawsze `true` dla DOWN, bo okno i tak w całości należy do paska.
   - `requestDisallowInterceptTouchEvent(boolean d)`: zapisz `childDisallowed = d` i wywołaj `super`.
   - `onDetachedFromWindow()`: jeśli gest trwa i Workspace był karmiony, podaj mu syntetyczny `ACTION_CANCEL` (ostatnia pozycja, jak `StatusBarSwipeDetector.onDestroy`), żeby strony się dociągnęły zamiast stanąć w pół drogi. Potem `host.onTouchEnded()`.
   - Wszystko działa na wątku głównym: okno nakładki dodaje `Workspace` na wątku głównym.

3. **Zmiany w `Workspace`**:
   - `boolean isExternalSwipePaging() { return mExternalSwipeTracking && mExternalSwipeScrolling; }`.
   - `showOverlayBottomBar()`: utwórz `BarSwipeFrame frame = new BarSwipeFrame(getContext(), mBarSwipeHost)`, napompuj układ (`inflate(layout, null)` jak dziś), `frame.addView(content, new FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))` i `overlayBottomBar = frame`. Reszta zostaje bez zmian, bo działa na korzeniu okna albo przez `findViewById`, a oba przechodzą przez ramkę:
     - listener insetów (≈1682–1699: wysokość i dolny padding korzenia; padding ramki przesuwa treść tak jak dziś padding `ConstraintLayout`);
     - `prepareOverlayForShow`, `startOverlayShowTransition` (animacje `translationY`/`alpha` korzenia), `setupOverlayView`, `setOverlayTouchable`, `finishOverlayHide`, `cleanupOverlayImmediately`;
     - listener `ACTION_OUTSIDE`.

     Grepem po `overlayBottomBar` sprawdź, czy nic nie rzutuje go na `ConstraintLayout` ani nie czyta jego dzieci po indeksie (dziś nic).
   - `mBarSwipeHost`: pole z implementacją `Host`:
     - `feed` → `handleExternalSwipe(e)`;
     - `isPaging` → `isExternalSwipePaging()`;
     - `onTouchStarted` → `mOverlayTouchHeld = true`;
     - `onPagingStarted` → `hideOverlayForSwipe()`;
     - `onTouchEnded` → `onOverlayTouchEnded()`.
   - Nowe pola (dostęp pod `overlayLock` tam, gdzie reszta stanu nakładki):
     - `mOverlayTouchHeld`: palec na oknie nakładki;
     - `mOverlayRemoveAtUp`: zsuwanie skończone, okno czeka na UP;
     - `mOverlayHideAtUp`: timer wybił w trakcie dotyku.

     Zeruj je w `finishOverlayHide`, `cleanupOverlayImmediately` i `clearOverlayReferences`.
   - **Chowanie na swipe**: wydziel z `hideOverlayBottomBar(boolean animate)` wariant `hideOverlay(boolean animate, boolean keepWindowUntilUp)`, a stara metoda niech woła `hideOverlay(animate, false)`. Dla `keepWindowUntilUp == true`:
     - **nie** wołaj `setOverlayTouchable(false)`, bo zmiana flag okna w trakcie gestu może go anulować;
     - akcja końcowa animacji (i ścieżka bez animacji) woła `onOverlaySlideOutEnded(bar, wm)`. Ta metoda przy `mOverlayTouchHeld && bar == overlayBottomBar` ustawia tylko `mOverlayRemoveAtUp = true`. Pasek jest już przesunięty poza okno, więc nic nie widać. W przeciwnym razie woła `finishOverlayHide(bar, wm)`.
     - Reszta jak dziś: `cancelPendingAutoHide()`, `mOverlayHideAnimating`/`isOverlayAnimating`, `mBarRevealed = false`, `setCollapsedBarShown(true, BAR_HIDE_DURATION_MS)`, post `launcher::disableRecycler`.

     `hideOverlayForSwipe()` wywołuje `hideOverlay(true, true)` i jedną linię `Log.d(TAG, "Hiding the auto-hide bar: page swipe on the bar")`.
   - `onOverlayTouchEnded()`:
     - `mOverlayTouchHeld = false`;
     - jeśli `mOverlayRemoveAtUp` → **post** (nie wprost, bo jesteśmy w dispatchu tego okna) `finishOverlayHide(bar, wm)` z kontrolą `bar == overlayBottomBar`;
     - w przeciwnym razie, jeśli `mOverlayHideAtUp && isOverlayShowing && !mOverlayHideAnimating` → `hideOverlayBottomBar()`.
   - **Timer**: Runnable w `scheduleAutoHide()` postuje `hideOverlayUnlessTouched()`. Przy `mOverlayTouchHeld` ta metoda ustawia `mOverlayHideAtUp = true`, a w przeciwnym razie woła `hideOverlayBottomBar()`. Timer nie zabiera więc paska spod palca, tylko chowa go przy UP.
   - Kolizje są już obsłużone przez dzisiejsze flagi i to zostaje:
     - `ACTION_OUTSIDE` (drugi palec na siatce) albo `hideAutoHideBarIfShown()` w trakcie zsuwania wracają przez `mOverlayHideAnimating`;
     - `hideOverlayBottomBar(false)` (np. `Launcher.cleanWidgetBar()`) zdejmuje okno od razu, a ramka w `onDetachedFromWindow` kończy gest Workspace CANCEL-em.
   - Uchwyt krawędzi i zwinięty przycisk nie wymagają zmian. W trakcie przewijania `shouldShowEdgeHandle()` daje `false` (`isPageMoving()`), a po osiadnięciu na stronie 0 `updateEdgeHandle("page settled")` je przywraca.
   - Jednoczesny gest na nakładce i na pasku stanu (`StatusBarSwipeDetector`) dzieli stan `handleExternalSwipe`. Nie obsługuj go: drugi DOWN resetuje stan, tak jak dziś.

4. Treść commita:
   - dlaczego nakładka nie przewijała (osobne okno);
   - że ta sama ścieżka co pasek stanu (`handleExternalSwipe`) daje to samo zachowanie co zwykły pasek;
   - okno żyje do UP;
   - reguły nieingerencji (tap, przytrzymanie, `requestDisallowInterceptTouchEvent`);
   - timer w trakcie dotyku;
   - na 7862 i wszędzie bez auto-hide nic się nie zmienia.

---

## E2 — PiP: okna paneli bez animacji przesunięcia i bez zbędnej pracy na klatkę

### Jak jest dziś (fakty z kodu)
- Panel PiP to osobne okno potomne launchera: `TYPE_APPLICATION_PANEL` z tokenem launchera (`WindowHostSinglePane.ensureWindow()` ≈534–588, `WindowHostDualPane` ≈718–743). Startuje w `x = y = -10000`, rozmiar 1×1. Treść paneli VD to `SurfaceView` w `WindowHostVdView`. Na 7862 (A10, system) to `ActivityView` frameworku.
- Przy przewijaniu `WindowUtil.updatePipPositionsForScroll(mUnboundedScrollX)` (≈1684) liczy pozycję 1:1 z przesunięcia stron (`updatePipPosition` ≈1721) i przesuwa okno: `updateBounds` → `setPendingBoundsFast` → `wm.updateViewLayout(root, lp)` (single ≈591–608, dual ≈758–775). Wywołują to `PagedView.notifyPageSwitchListener`/`computeScrollHelper`, `Workspace.computeScroll` (≈3926) i `screenScrolled` (≈4150), a filtr pomija tylko identyczne przesunięcie. **Nie ma animacji, opóźnienia ani limitu klatek.**
- **Przyczyna opóźnienia na A55**: okna paneli nie mają `PRIVATE_FLAG_NO_MOVE_ANIMATION` (0x40). WindowManager (`WindowState.handleWindowMovedIfNeeded` → `startMoveAnimation`) przy włączonych animacjach okien animuje każdą zmianę pozycji okna, które nie zmieniło rozmiaru. Każda klatka przewijania zaczyna tę animację od nowa, więc panel stale goni stronę i „jedzie wolniej”. Na Samsungu skala animacji jest domyślnie 1×, a ekran ma 120 Hz. Ten sam mechanizm animuje też pierwszy skok okna z −10000 na ekran. Od API 34 publiczny `WindowManager.LayoutParams.setCanPlayMoveAnimation(false)` ustawia tę flagę, a niżej trzeba ją ustawić w polu `privateFlags`.
- **Zbędna praca na klatkę**: przy samym przesunięciu `updateBounds` woła `syncTapRegionOnly()` (single ≈263) / `syncTapRegionsOnly()` (dual ≈445). Każde wywołanie idzie przez `postAfterLayout()` (single ≈1357–1389, dual analogicznie) i dla każdego panelu przy każdej klatce:
  - dodaje listener pre-draw;
  - woła `requestLayout()` + `invalidate()` okna panelu (wymusza pełny measure, layout i draw z `SurfaceView`; w dual przez `OnGlobalLayoutListener` dodatkowo `applySplit(false)`);
  - tworzy **nowy `Handler`** z Runnable na 250 ms.

  Dla paneli VD wywoływana na końcu `WindowHostActivityView.syncGeometryWithoutIme(av)` od razu wraca (`if (isHosted(av)) return …;`, ≈471). Cała ta praca idzie więc na nic, a na słabszym sprzęcie zjada klatki. Dla `ActivityView` (7862) synchronizacja jest potrzebna (`updateDisplayContentLocation`), ale wystarczy jedna oczekująca na panel.

### Implementacja
1. **Pomocnik** w `com.syu.util` (np. nowa klasa `PaneWindows`, final, package-private):
   ```java
   private static final int PRIVATE_FLAG_NO_MOVE_ANIMATION = 0x00000040; // WindowManager.LayoutParams, hidden before API 34
   /** @return how it was done, for the log: "api", "privateFlags" or "unavailable: …" */
   static String disableMoveAnimation(WindowManager.LayoutParams p)
   ```
   - `Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE` → `p.setCanPlayMoveAnimation(false)`;
   - niżej: refleksja `WindowManager.LayoutParams.class.getField("privateFlags")`, `setInt(p, getInt(p) | PRIVATE_FLAG_NO_MOVE_ANIMATION)`, a `catch (Throwable)` zwraca `"unavailable: " + t`.

     Pole jest na szarej liście, czyli dostępne także dla aplikacji użytkownika (7870, A13). Na 7862 aplikacja systemowa i tak nie ma ograniczeń. Wartość 0x40 jest stała od lat; sprawdzono ją w `android_jar/android-36.jar` (`javap -constants`).
   - Komentarz w kodzie: dlaczego (WindowState animuje przesunięcia okien bez zmiany rozmiaru, panel przesuwany co klatkę goniłby stronę), A55 jako źródło zgłoszenia i że skok z −10000 też już nie jest animowany.

2. Wywołaj go w `WindowHostSinglePane.ensureWindow()` i `WindowHostDualPane.ensureWindow()` na `p` **przed** `wm.addView`. Flaga zostaje w `lp` i przechodzi przez każdy `updateViewLayout`. Dodaj jedną linię `Log.i(TAG, name + ": window move animation off (" + how + ")")` na tworzone okno (dual: `"Dual"`).

3. **`syncTapRegionOnly()`** (single):
   - na początku `if (WindowHostActivityView.isHosted(av)) return;` z komentarzem: panel VD dostaje dotyk z widoku, nie ma czego synchronizować, a dotychczasowy post co klatkę wymuszał relayout okna panelu;
   - dla `ActivityView` koalescencja: pole `private boolean tapSyncPending;`. Jeśli `true`, wyjdź. W przeciwnym razie ustaw `true`, a w Runnable `postAfterLayout` **pierwszą instrukcją** ustaw `tapSyncPending = false`, potem dotychczasowe sprawdzenia i `syncGeometryWithoutIme`. Synchronizacja biegnie po najbliższym przebiegu okna panelu i czyta wtedy aktualną pozycję, więc obejmuje też przesunięcia zgłoszone, gdy czekała. Ostateczna pozycja jest zawsze zsynchronizowana.

   To samo w `WindowHostDualPane.syncTapRegionsOnly()`: `isHosted` per strona i flaga per strona (`leftTapSyncPending`/`rightTapSyncPending` albo `EnumMap`).

4. **Sprzęt**: nie wprowadzaj limitu klatek, timera ani dławienia, bo każde z nich rozjedzie panel ze stroną. Dostosowanie do sprzętu zapewnia sam mechanizm, co opisz w komentarzu przy `setPendingBoundsFast`:
   - `ViewRootImpl` łączy kolejne `updateViewLayout` w jeden przebieg na klatkę panelu, więc słabsze urządzenie przesuwa panel w swoim tempie klatek, zawsze do najnowszej pozycji, bez kolejki;
   - po tej zmianie na klatkę zostaje jeden relayout okna na panel; znikają wymuszony layout i draw, Handlery i Runnable, a ze strony WM animacja.

   Na 7862 (ActivityView) zostaje jedna synchronizacja na przebieg zamiast jednej na każde przesunięcie, z tym samym wynikiem.

5. **Diagnostyka** (jedna linia na przewinięcie):
   - w `WindowUtil` licznik przesunięć okien paneli (`updatePipBounds`, tylko faktycznie wysłane) i czas od `Workspace.onPageBeginMoving`;
   - w `onPageEndMoving` `Log.d(TAG, "pane moves: N in M ms")`, gdy N > 0;
   - dodaj publiczne `WindowUtil.onPagesBeginMoving()` / `onPagesSettled()` i wołaj je z tych metod `Workspace`.

   Porównanie A55, 7870 i 7862 pokaże liczbę klatek na przewinięcie.

6. Test: `PaneWindows` decyduje tylko po SDK. Wydziel `static boolean usesPublicApi(int sdkInt)` (≥ 34) i przetestuj granicę 33/34 w `app/src/test/java/com/syu/util/PaneWindowsTest.java`. `PaneWindows` nie może mieć statycznych pól z typami Androida; samo `Build.VERSION` czytaj w `disableMoveAnimation`.

7. Treść commita: przyczyna (animacja przesunięcia okna w WM, każda klatka zaczyna ją od nowa, widoczna przy włączonych animacjach, A55 120 Hz), dlaczego bez dławienia, co ubyło z pracy na klatkę. Na 7862: panele przesuwają się tak samo albo bez animacji, jeśli była; synchronizacja `ActivityView` daje ten sam wynik przy mniejszej liczbie wywołań.

8. **Nie zmieniaj**: wzoru pozycji (`updatePipPosition`), zmiany rozmiaru (`applyPaneGeometry`/`applySplit`), protokołu hosta VD ani okna statystyk `CanbusService` (osobny temat; wspomnij w raporcie, że ten sam pomocnik można tam później zastosować).

---

## E3 — Pinned PiP: tylko jednostki FYT z `com.syu.music` (7862, 8581), ukryty gdzie indziej

### Jak jest dziś (fakty z kodu)
- `LauncherApplication.supportsPinnedPip()` (≈759) zwraca `isFytDevice()` (commit `660d1e8`). Dlatego Pinned PiP działa także na 7870 (wariant standard). Odnosi się to do wersji standard tylko na FYT; na telefonach jest wyłączony.
- Bramki:
  - reset preferencji `PIP_{FIRST,SECOND,THIRD,FOURTH}_MODE` w `LauncherApplication.onCreate` (≈169–177);
  - `CustomPipSwitchPreference.setModeChecked` (≈89–94) i `onBindViewHolder` (≈175–179), które **ukrywają przełącznik Window/PiP** (`mModeContainer` GONE);
  - bezpośrednie `isFytDevice()` w `WindowUtil`: `openPip` ≈683 i `removePip` ≈829 (`setPinnedStackVisible(false)`), `openPinnedPip` ≈1997, `restartPinnedPipApp` ≈2155 (force-stop), `removePinnedPip` ≈2194.
- Odczyty flag pinned bez bramki:
  - `WindowUtil.checkIfPinned()` (≈2052–2055), `swapAllPanes` (≈2272–2273), ≈2404, ≈2694;
  - `settings/FabOverlayService.readSettings()` (≈250–253);
  - `settings/WakeDetection` (≈892–893, ≈961–962).
- Rozróżnienie jednostek: `com.fyt.car.StockSources.isSyuMediaUnit()` (7870 = `com.syu.media`) ustawia asynchronicznie `probeDevice()`. Do tego czasu zwraca `false`. `isProbed()` mówi, czy już wiadomo. Na wątku głównym `onDeviceResolved(boolean unit)` (≈170) dostaje wynik. `StockSources.init` startuje dopiero po resecie w `onCreate` (≈227).

### Decyzja właściciela
Pinned PiP ma działać na jednostkach FYT z `com.syu.music` (7862, 8581 i starsze FYT) w **obu** wersjach (fyt i standard). Na 7870 i poza FYT ma być wyłączony, a przełącznik Window/PiP ukryty.

### Implementacja
1. Czysta klasa `app/src/main/java/com/android/launcher66/PinnedPip.java` (final, bez `android.*`):
   - `static boolean supported(boolean fytUnit, boolean syuMediaUnit)` = `fytUnit && !syuMediaUnit`;
   - `static boolean mode(boolean supported, boolean saved)` = `supported && saved`.

   Test `PinnedPipTest`: (false, \*) → false; (true, false) → true; (true, true) → false; `mode` dla czterech kombinacji.
2. `LauncherApplication.supportsPinnedPip()` = `PinnedPip.supported(isFytDevice(), StockSources.isSyuMediaUnit())`. Popraw javadoc:
   - FYT z `com.syu.music` (7862/8581), wersja fyt i standard;
   - nie 7870, gdzie launcher nie ma przypiętego stosu (decyzja właściciela);
   - przed zakończeniem rozpoznania urządzenia na FYT zwraca `true` jak dotąd, więc 7862/8581 nigdy go nie tracą, a 7870 łapie reset z pkt 4.
3. Dodaj `public static boolean isPinnedMode(SharedPreferences prefs, String modeKey)` = `PinnedPip.mode(supportsPinnedPip(), prefs.getBoolean(modeKey, false))` i przepnij na nią **wszystkie** odczyty `Keys.PIP_*_MODE` z listy wyżej (WindowUtil ×4 miejsca, FabOverlayService, WakeDetection ×2). Grep `_MODE, false)` po `app/src/main/java` na końcu: poza `CustomPipSwitchPreference` (stan przełącznika) i resetem nie może zostać żaden bezpośredni odczyt flag pinned.
4. Reset trwały:
   - wydziel `static void clearPinnedPipModes(SharedPreferences prefs, String why)`, która zapisuje cztery `false`, tylko jeśli któraś jest `true`, i daje wtedy jedną linię `Log.i`;
   - wołaj ją w `onCreate` jak dziś (`!supportsPinnedPip()`; tam działa tylko poza FYT, bo rozpoznanie jeszcze nie skończone);
   - wołaj ją także w `StockSources.onDeviceResolved(unit)`, gdy `unit == true` (7870), z `why = "7870"`, przez `PreferenceManager.getDefaultSharedPreferences(sApp)`. Wątek główny, zapis `apply()`.
5. W `WindowUtil` zamień bramki specyficzne dla Pinned PiP z `isFytDevice()` na `supportsPinnedPip()`:
   - `openPinnedPip`;
   - `removePinnedPip`;
   - część force-stop w `restartPinnedPipApp` (odbudowa paneli nad nią zostaje bez warunku);
   - oba `setPinnedStackVisible(false)` w `openPip`/`removePip`.

   **`initDefaultApp()` zostaw z `isFytDevice()`**: ustawia `persist.launcher.packagename`, którego używa też `CanbusService` (≈427), więc to nie jest wyłącznie Pinned PiP.
6. Ustawienia: `CustomPipSwitchPreference` już używa `supportsPinnedPip()`, więc na 7870 przełącznik Window/PiP zniknie, a zapisany tryb spadnie na `false`. Sprawdź tylko, że `SettingsFragmentSecond.enforceSinglePiP`/`enforceDualPiP` (≈2163–2200) nie pokazują go ponownie (dziś nie pokazują).
7. `README.MD`:
   - linia 7: „pinned PiP works on FYT units” → na jednostkach FYT 7862/8581 (odtwarzacz `com.syu.music`), nie na 7870;
   - tabela (≈51–59): „✅ on FYT units” → „✅ on FYT 7862/8581”;
   - uwaga w linii 13 („some FYT devices do not support pinned PiP”): dopisz, że na 7870 launcher go nie oferuje.
8. Treść commita: dlaczego (właściciel: Pinned PiP działa tylko na 7862/8581), kryterium (`com.syu.music` vs `com.syu.media`), reset po rozpoznaniu urządzenia i dlaczego nie w `onCreate` (rozpoznanie jest asynchroniczne, a przed nim 7862 nie może stracić trybu). Na 7862/8581 zachowanie jest identyczne (`isSyuMediaUnit()` = false).

---

## 4. Czego NIE zmieniać
- Zwykłego paska (bez auto-hide), `StatusBarSwipeDetector`, `BottomBarEdgeHandle` ani progów stronicowania `PagedView` (`persist.sys.la_*`).
- Wzoru pozycji paneli, zmiany ich rozmiaru, hosta VD, `CanbusService`.
- `initDefaultApp()` i właściwości `persist.launcher.packagename`.
- Plików `.github/workflows/*` i commita `[BRANCH-ONLY]`.

## 5. Weryfikacja
1. Testy JVM: nowe (`BarSwipeGestureTest`, `PaneWindowsTest`, `PinnedPipTest`) i wszystkie dotychczasowe zielone (`:app:testFytDebugUnitTest` w CI).
2. CI `Build` zielone na ostatnim commicie (obie wersje debug).
3. Przegląd własnego diffu:
   - żadnej zmiany flag okna nakładki w trakcie gestu;
   - okno zdejmowane tylko w `finishOverlayHide`/`cleanupOverlayImmediately`;
   - każdy `MotionEvent.obtain` ma `recycle`;
   - `ACTION_OUTSIDE` nie trafia do Workspace;
   - grep `_MODE, false)` jak w E3.3;
   - flaga ruchu ustawiana przed `addView` w obu panelach.
4. Scenariusze dla testera (spisz w raporcie):
   - (a) Auto-hide: otworzyć pasek, przeciągnąć po nim w lewo lub w prawo. Strony idą za palcem, pasek się zsuwa. Palec zatrzymany w miejscu paska nadal prowadzi strony, a po puszczeniu strony się dociągają.
   - (b) Auto-hide: tapnięcie ikony, przycisku wszystkich aplikacji i przycisków muzyki działa. Przytrzymanie ikony otwiera wybór aplikacji, a późniejszy ruch nie przewija stron. Ruch pionowy nie przewija.
   - (c) Auto-hide: palec trzymany na pasku dłużej niż timeout nie traci paska. Pasek chowa się po puszczeniu.
   - (d) A55 (i 7870, Redmi): przewijanie stron z panelami PiP. Panel idzie równo ze stroną i placeholderem. W logu jest `window move animation off (api)` (A13: `privateFlags`) oraz `pane moves: N in M ms`.
   - (e) 7862: przewijanie z panelami bez zmian albo równiej; Pinned PiP działa jak dotąd, przełącznik Window/PiP widoczny.
   - (f) 7870: brak przełącznika Window/PiP w ustawieniach paneli; zapisany wcześniej tryb pinned wraca do Window (log `I` z resetu).

## 6. Raport końcowy (w odpowiedzi, po polsku)
- Lista commitów (hash + temat) i dla E1–E3: zrobione / pominięte, z jednym zdaniem dlaczego.
- Jak potwierdzić przyczynę na A55 bez nowej wersji: Opcje programisty → „Skala animacji okna” → wyłączona. Jeśli PiP wtedy idzie równo, przyczyną była animacja przesunięcia.
- Co na 7862 się zmieniło (tylko mniej pracy przy synchronizacji `ActivityView`) i dlaczego.
- Pytania do właściciela, jeśli coś zostało niejasne.
