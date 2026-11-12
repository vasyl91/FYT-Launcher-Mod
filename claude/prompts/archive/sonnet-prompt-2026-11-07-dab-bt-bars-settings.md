# Launcher Mod: DABdream po Home, widget BT, dotyk uchwytu na Androidzie 10, próg spalania, Spotify i fYT Rating, paski poziomy i pionowy, kategoria „Bars” — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `3191a484` (kod jak w `4677b990`). Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`. `settings/` to `…/launcher66/settings/`, a `S/` to `app/src/main/java/com/syu/util/`.

## 0. Commity (w tej kolejności)

| # | Temat commita | Źródło |
|---|---|---|
| C1 | `Panes: an app opened full screen comes back to its pane as it is` | DABdream (raport, pkt 3) |
| C2 | `Music widget: the BT play symbol and cover follow the BT source` | widget BT (raport, pkt 2) |
| C3 | `Edge handle: a tap over a pane reaches its app on Android 10` | właściciel |
| C4 | `Fuel estimate: the speed threshold is learned while accelerating` | właściciel |
| C5 | `Spotify: the sign-in state is shown as soon as it changes` | właściciel |
| C6 | `fYT Rating: the bridge is started with every launcher start, its state shown once known` | właściciel |
| C7 | `Bars: the bottom bar is the horizontal bar, the left bar the vertical bar` | właściciel (sama zmiana nazw) |
| C8 | `Settings: a Bars category, the margins under the widget colors, a vertical bar background` | właściciel |
| C9 | `Bars: the horizontal bar at the top or bottom, the vertical bar on the left or right` | właściciel |
| C10 | `Edge handle: on the left or the right edge, opened with a swipe inwards` | właściciel |

- **Każdy commit buduje się samodzielnie i przechodzi testy.** Po każdym pushu poczekaj na zielone CI, zanim zaczniesz następny.
- C7 to wyłącznie zmiana nazw, bez zmiany zachowania. C8–C10 stoją na C7.

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
- I/O, w tym `SharedPreferences.commit()` (używaj `apply()`);
- operacji na bazie, wywołań `ContentResolver` ani dostępu do sieci;
- wywołań `su` ani blokujących wywołań hosta VD.

**Testy:** JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `EdgeHandleGeometryTest`, `BottomBarEdgeGestureTest`, `settings/FuelModelTest`, `settings/PipEdgeTrimTest`. Logikę pisz w **czystych klasach bez `android.*`**.

**Stringi:**
- Nowy string dodajesz do **wszystkich 59** plików `res/values*/strings.xml`, z tłumaczeniem na język danego pliku.
- Zmieniony tekst zmieniasz w każdym pliku, który ma ten string.
- Bez nowych zależności.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/`.

## 2. Fakty

### 2.1 Przegląd rundy 7 (`4677b990`): bez błędów do naprawy
CI jest zielone. `EdgeHandleGeometry.touchWidth`, log geometrii i pole `orientation` (`Workspace` ≈453/≈877) są poprawne. Kodu rundy 7 nie zmieniasz poza C7, C9 i C10.

### 2.2 DABdream ginie, bo po Home panel uruchamia jego `MainActivity` z `CLEAR_TOP` (3 z 3 prób)
**Odpowiedź na pytanie 1 z raportu:** skrót „already runs” (`S/WindowHostVdView.startActivitySafely` ≈194–199) nie zawodzi przez `getPackage()` ani przez `null`. Zawodzi, bo display panelu jest **pusty**: zadanie DAB stało wtedy na displayu 0.

**Oś zdarzeń (plik A):**

| Linia | Zdarzenie |
|---|---|
| 3510 | `removePip() pane: dismissed` |
| 3541 | `START … MAIN/LAUNCHER flg=0x10000000 … MainActivity from uid 10199` (launcher, użytkownik otworzył DAB na pełny ekran) |
| 3575–3579 | `bringingFoundTaskToFront`, `START_TASK_TO_FRONT` |
| 3605 | `PlayerActivity t101 d0` |

- Zadanie przeszło z displayu 8 na 0 **w stanie, w jakim było**, bez nowej aktywności i bez crashu.
- Po Home panel przejmuje display (`display N with com.thf.dabplayer taken over…`). `isDisplayEmpty(N)` jest wtedy `TRUE`, więc kod idzie dalej i uruchamia intencję.
- Ta intencja pochodzi z `WindowHostActivityView.createCompatibleIntent` (≈975–986) → `applyStatePreservingFlags`. Daje to `flg=0x34720000`:
  - `NEW_TASK`, `SINGLE_TOP`, `CLEAR_TOP`, `RESET_TASK_IF_NEEDED`;
  - `REORDER_TO_FRONT`, `BROUGHT_TO_FRONT`, `LAUNCHED_FROM_HISTORY`.

**Skutek (plik B):**

| Linia | Zdarzenie |
|---|---|
| 8379 | start z hosta |
| 8398 | system przenosi zadanie t58 na display panelu (`PlayerActivity,reparent`) |
| 8427 | `MainActivity … t58 d3 START_SUCCESS` |
| 8677 | `MainActivity.onCreate` uruchamia `PlayerActivity` z `0x14000000` |
| 8679 | `clear-task-stack` kończy `MainActivity` przed jej wznowieniem |
| 8726 | `Duplicate finish request` |
| 8727–8747 | system wznawia zakończoną `MainActivity` → `NullPointerException … Window.getDecorView()` w `handleResumeActivity:5049`, `am_crash`, SIG 9; muzyka staje |

- `CLEAR_TOP` szuka w zadaniu `MainActivity`. Nie znajduje jej, bo DAB to trampolina, która kończy się po starcie `PlayerActivity`, więc system kładzie nową `MainActivity` na `PlayerActivity`.
- AIMP nie ginie, bo jego aktywność startowa jest korzeniem zadania.
- Linia A 3541 pokazuje dobrą drogę: start z samym `NEW_TASK` (+ `RESET_TASK_IF_NEEDED`, jak robi ekran główny) przenosi istniejące zadanie na display z `ActivityOptions` w stanie nienaruszonym. Bez zadania zakłada nowe.

### 2.3 Widget BT: ‖ oznacza, że widget uważa BT za grający; obie drogi odświeżania są dla BT martwe
**Symbol:**
- ‖ to `music_playpause_icon` → `@drawable/music_pause`, rysowany, gdy `isMediaPlayingNow()` zwraca true (`LauncherMusicWidget` ≈621–638).
- ▶ to `music_pause_icon` → `@drawable/music_play`.
- „Always pause symbol” znaczy więc, że widget uważa BT za grający. Hipoteza z raportu (`playing=false` → „pauza”) jest odwrócona.

**Stan na żywo:**
- Dla nakładki BT `isMediaPlayingNow` → `StockSources.isShownPlaying()` (≈253–262) = `btPlaying && CarStates.mAppID == 3`.
- Kod 13 modułu 2 to `U_BTAV_PLAY_STATE` (1 = gra). `com.syu.media` czyta go tak samo (`BluetoothObserver`, `isBtAvPlaying = ints[0] == 1`).

**Widget rysuje ikonę i okładkę tylko w `refreshMusic`** (≈189), czyli po `LauncherNotify.NOTIFIER_MUSIC.set` w `NotificationListener.fytStatus()` (`NotificationListener.kt` ≈1576–1613). Dla BT `fytStatus()` biegnie tylko trzema drogami:
- **(a) Pierwszy status tytułu** (`applyFytMeta` → `setStatus(1)`, gdy `!fytSet`, ≈746–753). Kolejne publikacje tego samego tytułu (okładka, pozycja, stan) już go nie wołają.
- **(b) Pętla 500 ms `UpdateFytTimeRunnable`** (≈1420–1433). Woła `setStatus(1)` tylko `if (MusicService.state)`, czyli przy stanie odtwarzacza `com.syu.music` / `com.syu.media`, a nie BT.
  - Gdy gra BT, ten odtwarzacz stoi i pętla nic nie rysuje.
  - Okładka BT przychodzi 1,5–6 s po zmianie tytułu (`StockBtSource.readCover`, `StockBtCover`), więc nigdy nie trafia do widgetu. Stąd „okładka raz, potem już nie”: raz zdążyła przed pierwszym statusem.
- **(c) Pauza** (`handleStockSourcePaused`, ≈680–698). Kończy się bez rysowania, gdy `source != "fyt"` albo gdy `!helpers.isFytMusicAllowed()` (false przez 1,8 s po utworze z sesji, ≈1567). Ikona zostaje wtedy na ostatnim ‖.

**Klik:**
- Gałąź `"fyt"` (≈1486–1508) ustawia ikonę przeciwną do `stockPlayingForIcon()` i wysyła komendę.
- Ikonę z powrotem na ‖ przestawia `redrawLastRefresh`, który powtarza ostatni `refreshMusic` i czyta stan na żywo, zanim przyjdzie kod 13 = 0. Pauza z (c) potem już nie dochodzi.

**Logi:** raport nie ma żadnej linii z tagów muzyki, a `StockBtSource` loguje tylko zmianę tytułu i pierwszą ścieżkę z kodu 51.

### 2.4 Uchwyt auto-hide na Androidzie 10 (flavor system): tapnięcie nad panelem ginie
- **Jak uchwyt przekazuje dotyk:** odtwarza zdarzenia programowo. `BottomBarEdgeHandle.startPassing` (≈492–527) i `forward` (≈530–544) wołają `target.view.dispatchTouchEvent(copy)`.
  - Celem jest `WindowHost.paneRootAt` (`S/WindowHost.java` ≈122, `rootAt` w `WindowHostSinglePane` ≈164, `WindowHostDualPane` ≈223).
  - Gdy pod uchwytem nie ma panelu, celem jest dekor launchera (`Workspace` ≈2752–2761).
- **Co trzyma panel:** poniżej API 30 `WindowHostVdClient.shouldUse` (≈93) zwraca `!isSystemUid()`. Flavor system (uid 1000) ma więc na Androidzie 10 framework `ActivityView`.
- **Dlaczego tapnięcie ginie:** `ActivityView` na Androidzie 10 nie ma forwardera wejścia. Dyspozytor wejścia wysyła dotyk prosto do okna na wirtualnym displayu (`S/UserTouches.java` ≈30–31, `vdhost/README.md` ≈30–35). `dispatchTouchEvent` do drzewa widoków nie dociera więc do aplikacji.
- **Gdzie działa:**
  - na widżetach launchera;
  - w panelach `WindowHostVdView`, gdzie `dispatchTouchEvent` (≈376–390) wstrzykuje zdarzenie przez host (`TX_INJECT_INPUT`);
  - na Androidzie 8–9, gdzie `ActivityView` sam przekazuje dotyk z `onTouchEvent`.
- Uid 1000 przechodzi sprawdzenie `INJECT_EVENTS`.
- `WindowHostActivityView.getVirtualDisplayId(av)` (≈604) zwraca display panelu.

### 2.5 Model spalania: próg rośnie od hamowania silnikiem, a cisza przy hamowaniu włącza szacowanie
**Jak działa dziś:**
- Próg startuje z 30 km/h (`settings/FuelModel.java` ≈86).
- Każdy jawny „brak wartości” przesuwa go: +0,9 powyżej progu, −0,1 poniżej, w zakresie 5–150 (≈533–536). Kierunek ruchu się nie liczy: hamowanie silnikiem przy 80 km/h, gdy auto nie daje spalania albo daje 65535, podnosi próg o ~0,9 na komunikat.
- `carGivesNoValue()` (≈741–743) to „brak wartości” **albo** cisza dłuższa niż 5 s w ruchu (`NO_UPDATE_MS`, ≈66).
- `com.syu.ms` wysyła kod tylko przy zmianie (`CanbusService` ≈159). Przy hamowaniu silnikiem auto nie wysyła spalania, więc po 5 s model uznaje „brak wartości”.
- `estimate()` (≈746–803) szacuje przy `v ≤ próg + 8` (≈751). Z podniesionym progiem szacowanie włącza się przy hamowaniu silnikiem powyżej rzeczywistego progu auta.
- Auto „z progiem” to dziś ≥20 braków przy `v ≤ próg + 5` (`noValueBelow`, ≈530–532, ≈731–733). Licznik nigdy nie maleje.
- Zapis: `fuel_model_<carId>_<fuelCode>`, format `3;…` (≈1099–1202). Formaty 1 i 2 są migrowane.
- Testy (`FuelModelTest` ≈62–66) podają `onFuel` co sekundę, więc nie odwzorowują wysyłania tylko przy zmianie.

### 2.6 Spotify: nic nie odświeża stanu po wymianie tokenu
- **Przekierowanie:** `launcher66://spotify-callback` trafia do `SpotifyAuthCallbackActivity` (manifest ≈168–185: `singleTask`, `taskAffinity=""`, `noHistory`).
  - Aktywność woła `SpotifyRating.handleAuthorizationResponse` (≈598–681) i od razu robi `finish()`.
  - Token POST biegnie na wątku `spotify-rating`. Po sukcesie pokazuje się tylko toast (`SpotifyAuthCallbackActivity` ≈51–53).
- **Kiedy odświeża się stan:** `SpotifyRating.syncPreference` (≈1303–1331) jest wołane tylko z `SettingsFragmentFirst.onResume` (≈617–629), po wylogowaniu (≈778–788) i po zapisie Client ID. Fragment nie ma słuchacza prefów.
  - Ustawienia wznowione przed końcem wymiany pokazują „Not signed in” aż do następnego `onResume`.
  - Widget nie dostaje odświeżenia po zalogowaniu; po wylogowaniu dostaje (`MediaFavoriteController.refreshWidget`, ≈783).
- **StrictMode:** `commit()` na wątku głównym w `startLogin` (≈379–382), `clearPendingAuth` (≈634) i `logout` (≈318–334, ≈810–815).

### 2.7 fYT Rating: stan „nieznany” wygląda jak „niezalogowany”, a mostek budzi tylko `Launcher.onResume`
- **Stan w ustawieniach:**
  - `FytRating.applyState` (≈1059–1087) ignoruje `statusKnown`. Przed pierwszą odpowiedzią i przy milczącym mostku ustawienia pokazują „Not logged in – open fYT Rating and sign in”.
  - `syncPreference` (≈1044–1057) rysuje z cache, a odświeżenie (`refreshStatus`) idzie bez wymuszenia.
- **Mostek** to broadcast z odpowiedzią przez PendingIntent (`exchange` ≈703–779).
  - Jedyny regularny wyzwalacz to `Launcher.onResume` → `scheduleFytRatingWake` (≈2191) → `LauncherWake.mFytRatingWake` (≈86–137).
  - `mFytRatingWake` pomija budzenie, gdy launcher jest w pauzie. W trybie aktywności czeka do 90 s uptime.
  - Potem woła `wakeIfNeeded` (≈807–842), najwyżej co 5 min.
- **Słabe miejsca:**
  - `allowBroadcastLaunch` (≈849–883) działa raz na proces;
  - `broadcastLaunchFailed` i `autoLaunchState` nigdy się nie zerują;
  - `InterruptedException` w `exchange` (≈759–761) nie liczy się jako brak odpowiedzi;
  - `isBridgeRunning` (≈960–993) odpowiada true przy każdym błędzie;
  - `wake()` z watchdoga używa kontekstu aplikacji.

### 2.8 Paski: gdzie dziś zakładają dół i lewo
- **Klasy:**
  - `BottomBarEdgeHandle`, `BottomBarEdgeGesture`, `BottomBarPlacement`;
  - `settings/BottomBarDimensions`, `settings/BottomBarHeightSeekBarPreference`;
  - `com.android.recycler.LeftAppListAdapter`.
  - Testy: `BottomBarPlacementTest`, `BottomBarEdgeGestureTest`.
- **Pasek poziomy:**
  - `iv_list_bg` jest przyczepiony do `parent` od dołu (land: `height_percent 0.1638`, port: `H,0.142`).
  - Nakładka: `Workspace.showOverlayBottomBar` (≈1695) z `Gravity.BOTTOM` (≈1732), dolnym insetem (≈1752–1769) i wysuwaniem po Y (`startOverlayShowTransition` ≈2336, `hideOverlay` ≈2458).
  - Uchwyt: `Gravity.BOTTOM|Gravity.LEFT` (`BottomBarEdgeHandle` ≈227), pasek rysowany od x=0 z prawymi zaokrągleniami (≈392–398), `onStrip = x < stripWidth` (≈410).
  - Gest: otwarcie przy swipe w prawo, `dx ≥ slop` (`BottomBarEdgeGesture` ≈59); przekazanie przy `dx ≤ −slop` (≈61).
  - Wykluczenie gestów: ≈375–381.
- **Pasek pionowy:**
  - `rl_left_bar` w `custom_layout_one_user_left.xml`, `custom_layout_two_user_left.xml`, `custom_layout_one.xml` (land i port) oraz w `creator_left.xml`.
  - Przyczepienie: `Left_toLeftOf=parent`, `Top_toTopOf=parent`, `Bottom_toTopOf=@id/iv_list_bg`; land `Width_percent 0.071`, port `W,0.071`.
  - Tło: stałe `@drawable/hotseat_bg`.
- **Przesunięcie X o `calculatedLeftBarWidth` na stronie 0:**
  - `CellLayout.isLeftBarOffsetActive` (≈4446), używane w ≈3961–4008, ≈4175–4183, ≈4299–4306, ≈4382–4390, ≈4492;
  - `S/WindowUtil` ≈2654–2668, `settings/CanbusService` ≈808–840;
  - `GridGeometry.cellsOf` ≈70, `CustomLayoutResolver.leftBarOffset` ≈95/≈391/≈522/≈543.
- **Pasma i granice:**
  - `Helpers.BarGeometry` (`barTop = rootHeight − barHeight`, ≈1300), `maxBottom` / `maxRight` (≈646–656);
  - `PipEdgeTrim.maxBottom` ≈48 / `maxRight` ≈53;
  - domyślne pozycje sprawdzane względem `bottomBarTop` (≈972–1247).
- **Wykluczenia w `CellLayout`:** ostatni rząd (`excludeLastRow` ≈178, ≈1586–1595) i lewa dolna komórka `[0][mCountY-1]` (≈1677, ≈1825, ≈3260, ≈4578).
- **Przycisk zwiniętego paska:** lewy dolny róg, szerokość paska pionowego (`Workspace` ≈1595–1599, ≈1675–1684).
- **Kreatory:**
  - `DrawViewFirstScreen` ≈287–316, ≈480, ≈997–1035;
  - `DrawViewOtherScreens` ≈269–277, ≈409; `DrawViewAppStats` ≈181;
  - `CreatorFirstScreen` ≈270–322 (`guideline_bottom_bar_height`).
- **`StatusBarSwipeDetector`** (≈59–75) leży w pasie paska statusu (`y = statusBar − 2/3·statusBar`). Pasek poziomy u góry, poniżej paska statusu, z nim nie koliduje.

### 2.9 Ustawienia
- **Kategoria „Widgets”** (`res/xml/creator_preferences.xml` ≈8–206, `widgets_category`) ma w tej kolejności:
  1. PiP itd.;
  2. `choose_widgets_background`;
  3. `black_widgets`;
  4. `start_page`;
  5. `bottom_bar_every_page`, `auto_hide_bottom_bar`, `auto_hide_timeout`, `resizable_bottom_bar`, `bottom_bar_height`;
  6. `choose_bar_background`, `black_bar`;
  7. `widget_bar` + 7 opcji;
  8. `left_bar`;
  9. `layout_margin` („Margins (max. 25)”).
- **Separator:** `<Preference android:layout="@layout/preference_separator" android:selectable="false"/>` między `PreferenceCategory`.
- **Kod zależny od kolejności:** `SettingsFragmentSecond.hideWithSeparator` (≈2404) chowa separator o indeksie i−1. `updateWidgetBarRows` (≈1180) polega na kolejności z XML.
- **Opcja dwustanowa bez przełącznika:** `CustomNoSwitchPreference` z `summaryOn` / `summaryOff` (wzór: `black_widgets`).
- **Wybór tła:**
  - `checkAndShowBarBackgroundSelector` (≈1022) → `BackgroundSelectorDialog.showWithLoadedBackground(fm, ctx, "bar", "app_list_bg")` (≈86);
  - klucz `bar_selected_background` (≈90–94), układ `<tag>_background_selector` (≈193);
  - stosowane w `Workspace` ≈927–930 i ≈1861–1864.
- Klucze kodu barów rebuildują stronę po powrocie: `helpers.setBarSettingsChanged(true)` (≈757–806), `Launcher` ≈2454.

---

## C1 — `Panes: an app opened full screen comes back to its pane as it is`
1. **Flagi startu na displayu panelu** (`S/WindowHostVdView.startActivitySafely`, ≈202).
   - Intencja dostaje flagi **zastąpione** przez `FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_RESET_TASK_IF_NEEDED`, a nie dodane do flag z `applyStatePreservingFlags`.
   - Stałą trzyma czysta klasa `PaneLaunchFlags` (stałe jako literały z nazwą w komentarzu).
   - Ten sam `Intent` idzie do hosta i do startu bezpośredniego (≈207, ≈218).
   - `mLastIntent` i restart (≈484) przechodzą przez tę samą metodę.
2. **Skrót „already runs” zostaje.** Gdy display przejęty z tym pakietem jest pusty, dopisz log przed startem: `<pkg> is not on display N (moved or gone), brought to it as it is`.
3. **Ścieżka `ActivityView` bez zmian:** `applyStatePreservingFlags`, `getLaunchIntentForPackage`, PendingIntent.
4. **Test `PaneLaunchFlagsTest`:**
   - wynik = `0x10200000`;
   - nie zawiera `CLEAR_TOP` (`0x04000000`), `SINGLE_TOP` (`0x20000000`), `REORDER_TO_FRONT` (`0x00020000`), `BROUGHT_TO_FRONT` (`0x00400000`) ani `LAUNCHED_FROM_HISTORY` (`0x00100000`).
5. W opisie commita: fakty z §2.2 z numerami linii z logów.

## C2 — `Music widget: the BT play symbol and cover follow the BT source`
1. **Czysta reguła `StockRedraw.needsRedraw(prev, next)`** (bez `android.*`, na polach `StockTrack`):
   - true, gdy zmienia się `playing`, `cover`, `title`, `artist`, `album`, `durationMs` albo `kind`;
   - przy samej zmianie `positionMs` true tylko, gdy `next.playing`.
2. **`handleStockSourceUpdate` i `handleStockSourcePaused`** (`NotificationListener.kt` ≈657, ≈680). Dla nakładki, czyli gdy `StockSources.shownOverlay() == t.kind` (RADIO, MEDIA_BT):
   - po zapisaniu toru wołają `fytStatus()` zawsze, gdy `needsRedraw(poprzedni, t)`;
   - nie wracają przez `source != "fyt"` ani `!helpers.isFytMusicAllowed()`. Te warunki zostają dla `com.syu.music` i odtwarzaczy `com.syu.media`.
3. **Pętla `UpdateFytTimeRunnable`** (≈1420): gdy widget pokazuje nakładkę (`stockTrack` z kluczem `fytMusicPath` i `shownOverlay() != null`), warunkiem jest `fytState` tej nakładki, a nie `MusicService.state`.
4. **Po kliknięciu** (≈1486) ikona ustawiona na przeciwną zostaje, aż przyjdzie publikacja ze zmienionym `playing` albo minie 2 s. Potem decyduje stan na żywo.
   - `redrawLastRefresh` w tym oknie nie przestawia ikony.
   - Okno trzymaj jako `mPlayPauseOverrideUntilMs`.
5. **Logi** (jedna linia na zmianę, nie na tick):
   - `StockBtSource`: `bt play state <0|1>` przy każdej zmianie kodu 13;
   - `bt cover <path>: modified <ms> song changed <ms> -> fresh|stale|missing|same` przy każdym odczycie;
   - `LauncherMusicWidget`: `icon <playing|paused> via <session|overlay|syu-media|audio> (src <mediaSource>, shown <kind>, bt <0|1>, channel <n>)`, gdy zmienia się wynik albo gałąź `isMediaPlayingNow`.
6. **Test `StockRedrawTest`:** każda zmiana z pkt 1 osobno, sama pozycja przy pauzie (false) i przy graniu (true).
7. **Bez zmian:** `StockBtCover`, `SyuMediaFiles`, kody 13 i 51, FM (okładki FM działają, zostają).

## C3 — `Edge handle: a tap over a pane reaches its app on Android 10`
1. **Trasa wybierana raz przy DOWN, dla całej sekwencji aż do UP/CANCEL.** Czysta klasa `EdgePassRoute.of(int sdk, TargetKind kind)`:
   - `LAUNCHER` → `VIEW_TREE`;
   - `VD_VIEW` (`WindowHostVdView`) → `VIEW_TREE` (jego `dispatchTouchEvent` już wstrzykuje przez host);
   - `ACTIVITY_VIEW` przy `sdk ≤ 28` → `VIEW_TREE`;
   - `ACTIVITY_VIEW` przy `sdk ≥ 29` → `DISPLAY_INJECT`.
2. **`DISPLAY_INJECT`** w `BottomBarEdgeHandle.forward` (≈530) i przy odtworzeniu (≈492):
   - kopia zdarzenia z położeniem względem `ActivityView` (`getLocationOnScreen`) i `source = SOURCE_TOUCHSCREEN`;
   - `MotionEvent.setDisplayId(WindowHostActivityView.getVirtualDisplayId(av))` (refleksja, API 29+);
   - `InputManager.getInstance().injectInputEvent(ev, 0 /* ASYNC */)` (refleksja; uid 1000);
   - czasy `downTime` / `eventTime` z `SystemClock.uptimeMillis()`, rosnące.
   - Gdy refleksja albo wstrzyknięcie się nie uda, raz zaloguj błąd i przejdź na `VIEW_TREE`.
3. **Log raz na przekazanie:** `Edge handle: pass to <launcher|pane vd|pane av display N> via <view|inject>`.
4. **Test `EdgePassRouteTest`:** API 26–36 × trzy rodzaje celu.
5. **Bez zmian:** reguły gestu, `EdgeHandlePass`, widoczny pasek, `UserTouches`.

## C4 — `Fuel estimate: the speed threshold is learned while accelerating`
1. **Czysta klasa `FuelSpeedThreshold`** (w `settings/`, bez `android.*`):
   - **Wejście:** `onAccelerating(double speedKmh, boolean carValue)`, wołane **tylko** gdy przyspieszenie jest znane i ≥ +0,3 m/s².
     - `carValue = true`: ważna wartość auta.
     - `carValue = false`: jawny „brak wartości” albo brak kodu ≥ 3 s podczas przyspieszania (`ACCEL_SILENCE_MS = 3000`). Przy przyspieszaniu prawdziwe spalanie zmienia się co komunikat.
   - **Kosze** po 5 km/h w zakresie 0–150, z licznikami `value[b]` i `none[b]`. Gdy suma w koszu przekroczy 200, oba liczniki dzielisz przez 2, żeby model uczył się na bieżąco.
   - **Próg** to krawędź `e`, która minimalizuje `Σ value[b<e] + Σ none[b≥e]`. Obowiązuje tylko, gdy:
     - `Σ none[b<e] ≥ 20`;
     - `Σ value[b≥e] ≥ 20`;
     - błędne wpisy to ≤ 10 % sumy.
     W innym wypadku progu nie ma: auto daje wartości przy każdej prędkości albo nie daje ich wcale.
   - Zapis i odczyt koszy do i z tekstu modelu.
2. **`FuelModel`:**
   - Uczenie z §2.5 (≈533–536) i `noValueBelow` zastępuje `FuelSpeedThreshold`.
   - Komunikaty, cisza i 65535 przy hamowaniu albo toczeniu (tryb OVERRUN, `aEff < −0,3`) oraz przy nieznanym przyspieszeniu **nie dotykają progu**.
3. **Szacowanie** (`estimate()` ≈746):
   - tylko gdy próg istnieje, `v < próg` i auto nie daje wartości;
   - margines `+8` usuwasz;
   - ważna wartość auta zawsze wygrywa od razu.
4. **Cisza:**
   - `carGivesNoValue()` liczy ciszę ≥ 5 s jako brak wartości tylko przy `v < próg` i nie w trybie OVERRUN.
   - Powyżej progu wartość auta trwa do następnego kodu, bo `com.syu.ms` wysyła tylko zmiany.
   - Powyżej progu w trybie OVERRUN cisza ≥ 2 s to odcięcie paliwa przy hamowaniu silnikiem: pokazujesz 0 (L/h, reguła jednostek z ≈806–821 zostaje). Następny kod auta zastępuje 0.
5. **Zapis:**
   - format `4;…` pod tym samym kluczem `fuel_model_<carId>_<fuelCode>`, z koszami progu;
   - migracja z 3 zachowuje kalibrację, a kosze startują puste: stary próg jest skażony hamowaniem.
   - Testy migracji 1, 2 i 3 → 4.
6. **Testy `FuelSpeedThresholdTest` i w `FuelModelTest`** podają kody **tylko przy zmianie**, jak `com.syu.ms`:
   - a) auto z progiem 30: przy przyspieszaniu brak < 30, wartości > 30 → próg 30 (±5);
   - b) po (a) 200 komunikatów 65535 i cisza 20 s przy 80 km/h w hamowaniu → próg bez zmian, brak szacowania, pokazane 0;
   - c) auto bez progu (wartości przy każdej prędkości) → progu nie ma, brak szacowania;
   - d) stała wartość auta przez 10 s przy 90 km/h → nie jest „brakiem”, brak szacowania;
   - e) zapis i odczyt koszy;
   - f) próg przesuwa się po 400 nowych próbkach z innym progiem.
   Istniejące testy z ≈571, ≈756 i ≈1008 dostosuj do nowych reguł i opisz zmianę w commicie.

## C5 — `Spotify: the sign-in state is shown as soon as it changes`
1. **Słuchacz prefów w `SettingsFragmentFirst`:**
   - `OnSharedPreferenceChangeListener` rejestrowany w `onResume`, wyrejestrowany w `onPause`;
   - dla `spotify_refresh_token`, `spotify_access_token`, `spotify_token_expiry` i `spotify_client_id` woła `SpotifyRating.syncPreference(...)`.
2. **Stan w trakcie wymiany:** `SpotifyRating` trzyma `volatile boolean sExchanging`.
   - Ustawia go w `handleAuthorizationResponse` przed kolejką, a zeruje w sukcesie i w błędzie.
   - W trakcie podsumowanie to nowy string `spotify_state_signing_in` „Signing in…”.
   - Po wyzerowaniu post na wątek główny → `syncPreference`, jeśli preferencja jest podpięta.
3. **Po sukcesie:** `MediaFavoriteController.refreshWidget`, jak przy wylogowaniu (≈783).
4. **Powrót do ustawień:** po obsłudze `SpotifyAuthCallbackActivity` przywraca ustawienia, gdy logowanie zaczęło się z ustawień (flaga ustawiona w `startLogin`).
   - Ma to być ta sama instancja, bez drugiej (sprawdź `launchMode` / `taskAffinity` `SettingsActivity` w manifeście). Wzór: `FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_REORDER_TO_FRONT`.
5. **StrictMode:** `commit()` → `apply()` w ≈318–334, ≈379–382, ≈634 i ≈810–815. Weryfikator jest w pamięci od razu, a callback idzie w tym samym procesie.

## C6 — `fYT Rating: the bridge is started with every launcher start, its state shown once known`
1. **Stan w ustawieniach** (`FytRating.applyState` ≈1059):
   - `!statusKnown` → nowy string `fyt_rating_state_checking` „Checking the connection to fYT Rating…”;
   - po nieudanej sekwencji z pkt 3 → nowy `fyt_rating_state_no_answer` „fYT Rating does not answer – open it once”;
   - reszta stanów bez zmian.
2. **Powrót z fYT Rating:** `handlePreferenceClick` (≈1001) ustawia flagę oczekiwania. Następny `SettingsFragmentFirst.onResume`:
   - wymusza status z pominięciem cache;
   - rysuje po każdej odpowiedzi;
   - bez odpowiedzi uruchamia sekwencję z pkt 3.
3. **Starter mostka `FytRatingBridgeStarter`** z czystą polityką `BridgeStartPolicy` (kroki i odstępy, test).
   - **Wyzwalacze:**
     - start procesu (`LauncherApplication.onCreate`, po przestoju po boocie, jak czeka `LauncherWake` dziś);
     - każdy `Launcher.onResume`;
     - koniec wybudzenia ekranu (`WakeDetection`);
     - powrót do ustawień z pkt 2.
   - **Sekwencja:**
     1. Ping statusu (kolejka foreground).
     2. Odpowiedź → `READY`. Zerujesz liczniki, `broadcastLaunchFailed` i `autoLaunchState`.
     3. Brak odpowiedzi:
        - `allowBroadcastLaunch()` ponownie (nie raz na proces, najwyżej raz na minutę);
        - `wake()`: aktywność `WakeActivity` przez **aktywność launchera**, gdy jest wznowiona; inaczej broadcast;
        - ping po 1,5 s.
     4. Kolejne próby po 5 s, 15 s i 60 s, potem co 5 min, dopóki launcher jest wznowiony.
   - Jedna sekwencja naraz: nowy wyzwalacz jej nie dubluje. Gdy aplikacji nie ma, starter nic nie robi.
   - Bramka 90 s uptime (`LauncherWake` ≈86–137) dotyczy tylko budzenia aktywnością, nie pingu.
4. **Poprawki:**
   - `InterruptedException` w `exchange` (≈759) liczy się jako brak odpowiedzi;
   - `isBridgeRunning` (≈960) przy błędzie zwraca „nieznane”, a starter traktuje to jak „nie działa”;
   - po `wake()` idzie `resetTransport()`.
5. **Log jednej linii na krok:** `bridge start (<trigger>): ping -> <answered|no answer>, wake <activity|broadcast|none>, next in <n> s`.
6. **Test `BridgeStartPolicyTest`:** odstępy, zerowanie po odpowiedzi, brak dubli, brak bramki dla pingu.

## C7 — `Bars: the bottom bar is the horizontal bar, the left bar the vertical bar`
Wyłącznie zmiana nazw. Zachowanie, układ i wartości zapisane w prefach są bez zmian.

1. **Klasy i testy:**

   | Stara nazwa | Nowa nazwa |
   |---|---|
   | `BottomBarEdgeHandle` | `HorizontalBarEdgeHandle` |
   | `BottomBarEdgeGesture` | `HorizontalBarEdgeGesture` |
   | `BottomBarPlacement` | `HorizontalBarPlacement` |
   | `settings/BottomBarDimensions` | `settings/HorizontalBarDimensions` |
   | `settings/BottomBarHeightSeekBarPreference` | `settings/HorizontalBarHeightSeekBarPreference` (także w XML) |
   | `com.android.recycler.LeftAppListAdapter` | `VerticalAppListAdapter` |

   Testy dostają nazwy odpowiadające klasom.
2. **Kod:** w metodach, polach, stałych, logach i komentarzach `BottomBar` → `HorizontalBar`, a `LeftBar` → `VerticalBar`. Przykłady:
   - `getBottomBarHeight` → `getHorizontalBarHeight`;
   - `showOverlayBottomBar` → `showOverlayHorizontalBar`;
   - `calculatedLeftBarWidth` → `calculatedVerticalBarWidth`;
   - `computeLeftBarWidth` → `computeVerticalBarWidth`;
   - `LEFT_BAR_FRACTION` → `VERTICAL_BAR_FRACTION`;
   - `isLeftBarOffsetActive` → `isVerticalBarOffsetActive`.
3. **Klucze prefów:**
   - nazwy stałych w `Keys` zmieniasz (np. `HORIZONTAL_BAR_EVERY_PAGE`, `AUTO_HIDE_HORIZONTAL_BAR`, `VERTICAL_BAR`);
   - **wartości zostają** (`"bottom_bar_every_page"`, `"auto_hide_bottom_bar"`, `"left_bar"` …), także `android:key` w XML. To dane użytkowników; dopisz komentarz, że to dawne nazwy.
4. **Zasoby:**
   - pliki `*_left.xml` → `*_vertical.xml` (`custom_layout_one_user_*`, `custom_layout_two_user_*`, `creator_*`);
   - id `rl_left_bar` → `rl_vertical_bar`, `left_recycler_view` → `vertical_recycler_view`, `guideline_bottom_bar_height` → `guideline_horizontal_bar_height`.
5. **Stringi, w 59 plikach:**
   - nazwy `*bottom_bar*` → `*horizontal_bar*` i `left_bar*` → `vertical_bar*`;
   - teksty w każdym języku: „bottom bar” → „horizontal bar”, „left bar” → „vertical bar”, także w `bar_background_preference`, `bar_background_dialog_title`, `black_bar`, `widget_bar`, `double_tap`, `left_bar_on` („Vertical bar + horizontal bar”), `left_bar_off` („Only horizontal bar”);
   - `bottom` („BOTTOM”, strzałka kreatora) zostaje;
   - README też.
6. **Kontrola:** `rg -i 'bottom.?bar|left.?bar' app/src vdhost README.MD` zwraca tylko wartości kluczy z pkt 3 i ich komentarze. Wynik wklej do raportu.

## C8 — `Settings: a Bars category, the margins under the widget colors, a vertical bar background`
1. **„Widgets”** kończy się na `choose_widgets_background`, `black_widgets` i `layout_margin` („Margins (max. 25)”), w tej kolejności.
2. Pod nią dodaj **separator** (`preference_separator`) i nową `PreferenceCategory` z kluczem `bars_category` i tytułem nowego stringa `bars_category` „Bars”.
3. **Kolejność w „Bars”:**
   1. `start_page`.
   2. Pasek poziomy:
      - pozycja (C9);
      - na każdej stronie;
      - auto-hide, czas auto-hide i strona uchwytu (C10);
      - zmienna wysokość i suwak wysokości;
      - tło paska poziomego i kolor tekstu oraz przycisków;
      - widget na pasku i jego 7 opcji.
   3. Pasek pionowy:
      - `left_bar` („Use vertical bar”);
      - strona (C9);
      - nowe „Choose background for vertical bar”.
4. **Kod zależny od kolejności:**
   - `hideWithSeparator` i `updateWidgetBarRows` sprawdź i popraw, żeby działały w nowej kategorii;
   - `findPreference` ze starych kategorii, jeśli jest, przenieś;
   - klucze barów nadal wołają `setBarSettingsChanged(true)`.
5. **„Choose background for vertical bar”:**
   - klucz `choose_vertical_bar_background`; stringi `vertical_bar_background_preference` i `vertical_bar_background_dialog_title` „Select background for vertical bar:”;
   - `BackgroundSelectorDialog` z tagiem `vertical_bar`, kluczem `vertical_bar_selected_background` i nowym układem `vertical_bar_background_selector.xml` (kopia układu paska);
   - lista: `hotseat_bg` (domyślne, pierwsze) i drawable z przedrostkiem `app_list_bg`;
   - tapeta tak, jak robi to wybór dla paska poziomego, z własnym kluczem URI, jeśli tamten ma własny;
   - stosowane do `rl_vertical_bar` w `Workspace.createUserPage` i w podglądzie kreatora (`creator_vertical.xml`);
   - pozycja widoczna tylko z włączonym paskiem pionowym.

## C9 — `Bars: the horizontal bar at the top or bottom, the vertical bar on the left or right`
1. **Dwie opcje `CustomNoSwitchPreference`** w „Bars”, z opisem pokazującym wybór:
   - `horizontal_bar_top` (domyślnie false):
     - tytuł `horizontal_bar_position` „Horizontal bar position”;
     - `summaryOff` `horizontal_bar_position_bottom` „At the bottom of the screen”;
     - `summaryOn` `horizontal_bar_position_top` „At the top of the screen”.
   - `vertical_bar_right` (domyślnie false, widoczna z paskiem pionowym):
     - tytuł `vertical_bar_side` „Vertical bar side”;
     - `summaryOff` `vertical_bar_side_left` „On the left side of the screen”;
     - `summaryOn` `vertical_bar_side_right` „On the right side of the screen”.
   - Obie wołają `setBarSettingsChanged(true)`.
2. **Czysta klasa `BarLayout`.**
   - **Wejście:** `rootW`, `rootH`, wysokość paska poziomego, szerokość paska pionowego, `top`, `right`, czy jest pasek pionowy (strona 0), czy pasek na każdej stronie.
   - **Wyjście:**
     - pasmo paska poziomego (top/bottom);
     - pasmo paska pionowego (left/right, między paskiem poziomym a krawędzią);
     - obszar widżetów strony 0 i stron 2…n jako insety (left/top/right/bottom);
     - róg przycisku zwiniętego paska;
     - indeks wykluczonego rzędu i komórki narożnej `CellLayout`.
   - Test `BarLayoutTest`: 4 kombinacje × 2 orientacje × (strona 0 z i bez paska pionowego, strony 2…n z paskiem i bez).
3. **Wszystkie miejsca z §2.8 biorą geometrię z `BarLayout`:**
   - `Helpers.BarGeometry` i `maxBottom` / `maxRight` (+ `minTop` / `minLeft`);
   - `PipEdgeTrim`, `CellLayout` (offset X, rząd i komórka narożna), `GridGeometry`, `CustomLayoutResolver`;
   - `S/WindowUtil` (pinned PiP) i `CanbusService` (statystyki);
   - domyślne pozycje w `Helpers`, kreatory i przycisk zwiniętego paska.
   - Stałe `+calculatedVerticalBarWidth` zastępuje inset z `BarLayout`.
4. **Układ:** jedna funkcja `BarConstraints.apply(ConstraintLayout root, boolean top, boolean right)` po inflacji (strona, nakładka, kreatory) przestawia `ConstraintSet`.
   - `iv_list_bg`: góra albo dół `parent`.
   - `rl_vertical_bar`: lewa albo prawa krawędź `parent`; od strony paska poziomego do `iv_list_bg`, od drugiej do `parent`.
   - Procenty 0,1638 / 0,142 / 0,071 bez zmian. Bez nowych plików XML na kombinacje.
5. **Nakładka i pasek na każdej stronie** (`HorizontalBarPlacement.reserve()`):
   - przy `top` `Gravity.TOP` z górnym insetem paska statusu (lustro ≈1752–1769);
   - wysuwanie z góry (`translationY` ujemne w pokazaniu i chowaniu).
   - Pasek u góry zawsze leży poniżej paska statusu, więc `StatusBarSwipeDetector` zostaje bez zmian.
6. **Kreatory** (`DrawViewFirstScreen`, `DrawViewOtherScreens`, `DrawViewAppStats`, `CreatorFirstScreen`) rysują i odejmują paski według `BarLayout`. Napis podwójnego tapnięcia i `CreatorBarToggle` bez zmian.
7. **Zapisane prostokąty widżetów:** przy zmianie pozycji lub strony istniejąca reguła dopasowania do miejsca (`checkAndResetIfOverlappingOnScreen` ≈542) przesuwa nachodzące prostokąty na nowe pasmo. Nie kasujesz prostokątów użytkownika.

## C10 — `Edge handle: on the left or the right edge, opened with a swipe inwards`
1. **Opcja `edge_handle_right`** (`CustomNoSwitchPreference`, domyślnie false, w „Bars” pod czasem auto-hide, widoczna z auto-hide):
   - tytuł `edge_handle_side` „Auto-hide handle”;
   - `summaryOff` `edge_handle_side_left` „Left edge, opened with a swipe to the right”;
   - `summaryOn` `edge_handle_side_right` „Right edge, opened with a swipe to the left”.
   - Niezależna od strony paska pionowego.
2. **`HorizontalBarEdgeGesture` dostaje stronę.**
   - Lewa: otwarcie przy `dx ≥ slop`, przekazanie przy `dx ≤ −slop` (jak dziś).
   - Prawa: otwarcie przy `dx ≤ −slop`, przekazanie przy `dx ≥ slop`.
   - Przewaga poziomu (`HORIZONTAL_DOMINANCE`) bez zmian. Tapnięcia, przeciągnięcia i długie przytrzymanie przechodzą do aplikacji pod spodem jak dziś (i jak po C3).
   - Test: przypadki obecne lustrzanie dla prawej strony.
3. **`HorizontalBarEdgeHandle`:**
   - grawitacja to (`TOP` | `BOTTOM` według C9) | (`LEFT` | `RIGHT`);
   - widoczny pasek rysowany przy tej krawędzi, zaokrąglony od środka ekranu;
   - `onStrip` liczony od tej krawędzi;
   - wykluczenie gestów przy tej krawędzi;
   - szerokość okna z `EdgeHandleGeometry` bez zmian;
   - trasa przekazania z C3 liczy współrzędne z położenia okna.
4. **Log geometrii** (`Workspace.applyEdgeHandleGeometry`) dostaje stronę i pozycję: `Edge handle geometry: <left|right> <top|bottom>, strip <s> px, touch <t> px`.

## 3. Czego NIE zmieniać
- Ścieżki startu `ActivityView` (PendingIntent, `applyStatePreservingFlags`) ani zachowania recents.
- `StockBtCover`, `SyuMediaFiles`, kodów 13 i 51, okładek FM.
- Reguł gestu poza stroną (C10), widocznego paska uchwytu (szerokość, kolor, alpha), `EdgeHandlePass`, `PersistentBarWindow`.
- Wartości kluczy prefów (C7 pkt 3) ani prostokątów użytkownika.
- Kodu rund 5–7 poza miejscami wskazanymi w C7, C9 i C10.

## 4. Weryfikacja
1. CI zielone po każdym commicie, a nowe testy przechodzą:
   - `PaneLaunchFlagsTest`, `StockRedrawTest`, `EdgePassRouteTest`;
   - `FuelSpeedThresholdTest`, `BridgeStartPolicyTest`, `BarLayoutTest`;
   - testy gestu dla obu stron.
2. `rg` z C7 pkt 6. Nowe stringi są w 59 plikach: `rg -c 'name="bars_category"' app/src/main/res | wc -l` → 59, tak samo dla każdego nowego stringa.
3. **Scenariusze dla testera.** Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) DAB w panelu → otwórz go ikoną na pełny ekran → Home. DAB gra dalej, a panel pokazuje odtwarzacz. W logu jest `… brought to it as it is` i nie ma `am_crash`. Powtórz 3×. Sygic, Torque i AIMP jak dotąd.
   - b) BT z telefonu:
     - zmień utwór 3× → okładka przychodzi przy każdym;
     - pauza w telefonie → ▶ w widgecie, wznowienie → ‖;
     - klik w widgecie → symbol się zmienia i zostaje.
     W logu są `bt play state`, `bt cover … -> fresh` i `icon … via overlay`. FM jak dotąd.
   - c) Android 10, launcher systemowy, auto-hide: tapnięcie i przeciągnięcie w pasie uchwytu nad panelem PiP trafia do aplikacji w panelu. Nad widżetem trafia do widżetu. Swipe do środka otwiera pasek. To samo na 8–9 i 11+.
   - d) Spalanie:
     - przyspieszanie przez próg auta → próg w logu;
     - hamowanie silnikiem przy 80 km/h → brak szacowania, pokazane 0;
     - poniżej progu → szacowanie jak dotąd.
   - e) Spotify: zaloguj się, wróć do ustawień przed końcem wymiany → „Signing in…”, potem „Signed in”, bez ponownego wejścia.
   - f) fYT Rating:
     - zaloguj się w fYT Rating, wróć → „Checking…”, potem stan właściwy;
     - wymuszone zatrzymanie fYT Rating, potem Home → w logu kroki `bridge start` aż do `answered`.
   - g) Ustawienia: „Margins” pod kolorem widżetów, separator, kategoria „Bars” w kolejności z C8, tło paska pionowego działa.
   - h) Cztery kombinacje pozycji pasków na stronie 0 i na stronach 2…n z „every page”: widżety, PiP, statystyki i kreatory nie nachodzą na paski. Przycisk zwiniętego paska jest w rogu.
   - i) Uchwyt z prawej: otwiera swipe w lewo, tapnięcia przechodzą, pasek u góry i u dołu.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Każdy commit (hash i temat) z wynikiem CI.
- Wynik `rg` z C7 pkt 6 i liczniki stringów.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.3.
