# Runda 28 — brief dla Sonnet (implementacja w innym czacie)

Po zatwierdzeniu:
- ten plan trafia do `claude/prompts/active/sonnet-prompt-2026-11-25-round-28.md` (commit `Docs: brief for round 28`, z wierszem
  w `claude/prompts/README.md`) i do pliku do pobrania;
- plan rundy 27 idzie do archiwum (z transkryptu, pkt „Po zatwierdzeniu”).

**Rola Sonnet:** wyłącznie kod, commit po commicie, w kolejności z tego briefu. Decyzje projektowe są tutaj.
- Fakt z briefu, którego kod nie potwierdza (nazwa, linia, zachowanie): dopasować do kodu, zapisać w raporcie i nie
  wymyślać innego zachowania.
- Numery linii są przybliżone (stan `cf5d112a9`).

---

## 0. Kontekst i decyzje właściciela

Właściciel (2026-11-25) przysłał 25 punktów, logi i 20 crash logów. Logi:
- A55 po restarcie (Android 17);
- 7862: runda 25 oraz „screen off and on”;
- A55: pasek pionowy przesunięty przy swipe.

Decyzje z pytań planu (właściciel, 2026-11-25):
1. **„Stock layout” wyłącza wszystko z LAYOUT CREATOR**, także nowe opcje tej rundy: obowiązują wartości domyślne. Wiersze
   tych funkcji są wyszarzone.
2. **Czarne okno przy starcie (A55):** launcher dostaje tryb „przed odblokowaniem” (direct boot) i pokazuje wtedy tapetę.
3. **Double tap „Turn off screen”:** ponowny double tap przywraca ekran.
   - FYT: komenda `C_BLACKSCREEN`; przywraca sam system, na 7862 double tapem.
   - Inne urządzenia: czarne okno launchera; przywraca double tap na nim.
4. Plan ma być bardzo dokładny; Sonnet tylko implementuje.

## 1. Zasady obowiązujące w każdym commicie
- **Git:**
  - tylko `testBranch`; na start `git pull origin testBranch`;
  - bez PR, bez `--amend`, bez force-push;
  - jeden krok = jeden commit o temacie z tego briefu, treść po angielsku („dlaczego” + fakty);
  - trailery z przypomnienia sesji; nigdy nazwy modelu w treści repozytorium.
- **CI tylko po zmianie kodu:**
  - commit z kodem: lokalnie `:app:testSystemDebugUnitTest :app:assembleSystemDebug :app:assembleStandardDebug`, push,
    **zielone CI przed następnym commitem z kodem**;
  - czerwone CI naprawia nowy commit; błąd infrastruktury (Maven 429, pobranie jara Robolectrica) = ponowne uruchomienie
    zadania;
  - commity dokumentacji: bez Gradle i CI, push od razu.
- **StrictMode cicho** na wątku głównym: bez I/O plików, bazy, `ContentResolver`, sieci i blokujących wywołań hosta;
  `SharedPreferences.apply()`, nigdy `commit()`.
- **Logika w czystych klasach Java bez `android.*`**, z testami JUnit 5 w `app/src/test/java/…`; widoki testowane Robolectricem
  (D-68). Każda reguła opisana w Javadoc klasy, która jej pilnuje.
- **Napisy:**
  - nowy napis do **wszystkich 59** `res/values*/strings.xml`, przetłumaczony; ton profesjonalny, jak w ustawieniach Androida;
    pisownia US („color”);
  - zmiana znaczenia = nowy klucz, stary usunięty wszędzie (po `rg`);
  - teksty EN w tabeli w §6.
- **Preferencje i zasoby:**
  - klucze preferencji zachowują zapisane wartości;
  - bez arytmetyki na `R.*`, bez id zasobów w `switch`/`case`;
  - bez nowych zależności (wszystko z androidx już w projekcie: RecyclerView, ItemTouchHelper, ConstraintLayout).
- **Usuwanie** dopiero po `rg` całego repozytorium (bez `claude/` i `archive/`).
- **Nie ruszać:**
  - `archive/`, `android_jar/android-36.jar`, `keystore.properties` (nie czytać);
  - `app/src/main/generated/baselineProfiles/`, poza usuwaniem linii usuniętych klas.
- **Duże pliki** (`Launcher.java`, `Workspace.java`, `SettingsFragment*`, `LogcatWorker`, `CanbusService`,
  `NotificationListener.kt`): tylko celowane edycje; nowa logika w nowych klasach.
- **Urządzenia:**
  - 7862 bez zmian poza tym, czego dotyczy punkt;
  - D-28: launcher nie cofa działań użytkownika; D-29: nie zmienia ustawień systemu użytkownika.
- **Uprawnienia** (pkt 21): w manifeście; prośby o brakujące przez `LauncherPermissionFlow`. Nowy krok dodaje się tak:
  1. wartość enum `PermissionStep` (kolejność = pozycja);
  2. `isPermissionStepNeeded`, `startPermissionStep`;
  3. `REQUEST_CODE_*` w `Launcher.java:509-514`;
  4. `isPermissionFlowRequest`, `onPermissionScreenResult`.
- **Nowe ekrany i dialogi** w stylu ustawień:
  - `SettingsDialogs.builder`, kategorie, odstępy;
  - `preference_separator` między kategoriami, `preference_separator_within` w kategorii;
  - przejście na nowy ekran przez `replace(android.R.id.content, …)` i `OnBackPressedCallback` w `onAttach`, jak `CanbusGuide`;
  - tytuł paska akcji w `onCreateView`, jak `SettingsFragmentSecond:306-309`;
  - na urządzeniach innych niż FYT `PreferenceScaleHelper.applySystemBarInsets`, jak `SettingsFragmentSecond:342-347`.
- **„Stock layout”:** każdy nowy klucz z ekranu twórcy (`creator_preferences.xml`) trafia do `CreatorKeys` (C3) i jest czytany
  przez `CreatorPrefs`. Pilnuje test.
- **Akcent:** każdy nowy widok w kolorze akcentu bierze go z `ThemeAccent` (C1), nie z `R.color.colorAccent`.
- **`claude/ARCHITECTURE.md`:** commit, który zmienia opisany tam fragment, poprawia go w tym samym commicie.
- **Raport końcowy** (po polsku, w czacie):
  - commity z numerami CI, odstępstwa z powodem;
  - co sprawdzone tylko testami, czego nie sprawdzono na urządzeniu.

## 2. Przegląd rundy 27 i logów [V w logach i kodzie]
- **7862, log rundy 25** (zegar urządzenia na 2024-12-07; 70 s, dwa otwarcia karty widżetów, zmiany paneli PiP):
  - 0 raportów StrictMode, 0 `LeakedClosableViolation`; `WindowHostAvReaper` zwalnia zużyte `ActivityView`;
  - wniosek: **KI-46 zamknięte**;
  - właściciel: panele, kolejność paska (D-77) i ciemne dialogi (D-78) działają.
- **A55 na Androidzie 17:** launcher działa jak dotąd [H].
- **7862, wyłączenie ekranu:**
  - kafelek SystemUI wysyła do com.syu.ms `CMD [16 2]` (moduł main, `cmd cmdid = 16 [2]`), a com.syu.ms raportuje
    `U_BLACK_SCREEN = 1`;
  - launcher loguje `WakeSignals: Black screen on (not a sleep)`;
  - przywrócenie: `U_BLACK_SCREEN = 0`, „Black screen off (not a sleep)”;
  - w kodzie: `FinalMain.C_BLACKSCREEN = 16` (`com/syu/ipc/data/FinalMain.java:42`); `DataMain.PROXY.cmd(int, int[])` jest
    używane w `com/syu/module/main/HandlerMain.java:12`.
- **com.syu.music:** przewijania nie da się ustawić z zewnątrz [V w `archive/decompiled/com.syu.music.zip`].
  - `MService` (eksportowany) przyjmuje tylko playpause/stop/next/prev/path/widget.
  - `MediaManager` ma `MediaSession` tylko z `onMediaButtonEvent`: bez `setPlaybackState`, metadanych i `onSeekTo`.
  - Przewija wyłącznie z własnych ekranów (`Page_Player`, `Page_Id3`, `Page_Player_HalfScreen` → `App_Music.seekTo`).
  - Wniosek: na 7862 suwak dla com.syu.music pokazuje pozycję bez uchwytu. To trafia do dokumentacji (D-81, KI-50).
- **Crash logi:**
  - (a) A55, Android 17, **standard release** 1.2.1: `InflateException CustomPipRestartPreference`,
    `NoSuchMethodException <init>(Context, AttributeSet)` w `SettingsFragmentSecond.onCreatePreferences:387`. Konstruktor jest
    w źródle (`CustomPipRestartPreference.java:48`), więc przyczyną jest R8 [A].
  - (b) A55, uptime 1,3 s: NPE w `Workspace.determineScrollingStart:5012`. `mPrefs` jest ustawiane dopiero w budowie strony
    (`Workspace:884`).
  - (c) A55 Android 16, 12 razy: `PackageChangedReceiver.onReceive` → `LauncherAppState.getInstance()` →
    `LauncherModel.<init>:235` → `Utilities.createIconBitmap:271`, „width and height must be > 0”.
    `sIconTextureWidth = -1` (`Utilities:59`), bo proces wystartował dla odbiornika bez launchera.
  - (d) 11-16: `ClassCastException` w `LauncherAppWidgetHostView.onLayout`. Naprawione przez `f860da64d`; tylko sprawdzić, że
    nie wróciło.
- **Pasek pionowy (A55, 11-24 15:43, pkt 12):**
  - ramka „frame 952,89,128,1986”; przy `onPageBeginMoving()` (18.840) `VRI[VerticalBarWindow] Relayout returned:
    old=(952,89,1080,2075) new=(824,89,952,2075)`, czyli dokładnie jedna szerokość paska do środka; zostaje tak do restartu;
  - w kodzie: `onPageBeginMoving()` (`Workspace:5084-5117`) → `updateEdgeHandle("page moving")` → `updatePersistentBar` →
    `updateVerticalBarWindow` (gałąź `default:` 3567-3570) → `placeVerticalWindow()` (3639) → `verticalWindowFrame()` →
    `barBoxOnScreen()` (1642) → `measurePageVerticalBar()` (1686-1699);
  - pomiar strony 0 bierze się w trakcie ruchu: `PageBox.atRest` (`PageBox.java:48-51`) sprawdza tylko skalę, nie ruch,
    `rotationY` (overscroll strony 0, `Workspace.screenScrolled:5654-5667`) ani translację;
  - `VerticalBarWindow.checkPlacement()` (397-416) poprawia położenie tylko raz;
  - `Launcher.screenWidth` bywa nadpisywany przez `pipOverview()` (`Launcher:3711`) wartością `widthPixels`.
- **Czarne okno przy starcie (A55):**
  - log kończy się przed odblokowaniem; system uruchamia `com.android.settings/.FallbackHome` („User not yet unlocked”);
  - launcher nie jest `directBootAware`; jego motyw `AppTheme` jest już przezroczysty z tapetą (`styles.xml:3-15`);
  - na FYT (bez szyfrowania) użytkownik jest odblokowany od startu [A].
- **Logcat:**
  - stop kończy zapis „drenażem” (`LogcatWorker.beginDrain` 1822, `drainWatch` 1845-1868): czyta, aż logcat dogoni chwilę
    stopu, do `DRAIN_MAX_MS = 120 s` (216);
  - po restarcie zapis startowy czyta całe bufory (8M × 5) przez Shizuku, stąd długie „Saving the log…” i duży plik [A].
- **Okno statystyk w aplikacjach:**
  - ustawienia launchera mają ten sam pakiet co ekran główny;
  - `StatsWindowRule` (javadoc): „gdy launcher jest na wierzchu, niczego nie zabieram”;
  - `CanbusService.currentForegroundApplication` (676-) nie zeruje `curForegroundApp` dla pakietu spoza listy.

## 3. Kolejność commitów
Grupy A–J, 36 commitów; każdy z kodem z zielonym CI przed następnym:
- A1–A8: naprawy;
- B1–B2: suwak;
- C1–C3: akcent, przełączniki, stock;
- D1–D7: ekran główny;
- E1–E3: paski;
- F1–F6: szuflada;
- G1: widżety;
- H1–H2: plakietki;
- I1–I2: autostart i napisy;
- J1–J2: dokumentacja.

---

## A. Naprawy

### A1 `Crashes: the package receiver no longer builds the launcher's state`
- **Plik:** `PackageChangedReceiver.java`.
- **Kroki:**
  1. Bez `LauncherAppState.getInstance()`. Gdy instancja już jest (statyczny getter bez tworzenia, dodać jeśli trzeba
     `LauncherAppState.getInstanceNoCreate()`), użyć jej bazy podglądów.
  2. Inaczej `goAsync()` i na wątku roboczym otworzyć bazę podglądów tą samą nazwą pliku co `WidgetPreviewLoader`, usunąć
     wiersze pakietu (`WidgetPreviewLoader.removePackageFromDb` przenieść na statyczną metodę przyjmującą `SQLiteOpenHelper`
     lub ścieżkę), `finish()`.
  3. Żadnego zapisu bazy na wątku głównym.
- `Utilities.createIconBitmap`: przy `sIconTextureWidth <= 0` rozmiar z zasobów (ta sama droga co `initStatics`, wymiar
  `app_icon_size`).
- **Test JUnit:** czysta reguła `IconTextureSize.or(width, fallback)`.
- **Robolectric:** `PackageChangedReceiver.onReceive` bez launchera nie rzuca.

### A2 `Crashes: the workspace has its settings before the first touch`
- `Workspace`: `mPrefs = PreferenceManager.getDefaultSharedPreferences(context)` w konstruktorze.
  - Instancja jest już w pamięci, bo `LauncherApplication.attachBaseContext:120` ją wczytuje; nie ma odczytu dysku.
- Pole `mUserLayout` odświeżane przy budowie strony i z `OnSharedPreferenceChangeListener` (klucz `USER_LAYOUT`).
  `determineScrollingStart` czyta pole, nie preferencje przy każdym ruchu.
- **Robolectric:** dotyk przed `createUserPage` nie rzuca.

### A3 `Build: the settings' preferences keep their constructors in release`
- `app/proguard-rules.pro`:
  ```
  # Preferences are created from XML by reflection (androidx PreferenceInflater): crash on the A55, 2026-11-23
  -keep public class * extends androidx.preference.Preference {
      public <init>(android.content.Context, android.util.AttributeSet);
  }
  ```
- Release lokalnie się nie zbuduje (podpis, `keystore.properties` zakazany): w raporcie „nie sprawdzone, sprawdzić release na
  A55”.

### A4 `Bars: the persistent vertical bar is placed only at rest and put back if moved`
- **`PageBox.atRest`** dostaje warunki: strony się nie przesuwają (`!isPageMoving()`), stan dotyku `REST`, `rotationY == 0`
  oraz `translationX == 0` strony 0.
  - Poza spoczynkiem `placeVerticalWindow()` nie mierzy i nie zmienia ramki: zostaje ostatnia dobra.
  - Gałąź `default:` w `updateVerticalBarWindow` (3567) nie woła `placeVerticalWindow()` w trakcie ruchu stron; po
    `onPageEndMoving` tak.
- **`VerticalBarWindow`:**
  - `checkPlacement()` po każdym układzie okna (`ViewTreeObserver.OnGlobalLayoutListener` korzenia) i po każdym `update()`,
    nie tylko raz;
  - przy różnicy > 1 px poprawka liczona od nowa: `correction = correction + (oczekiwane − zmierzone)` z uwzględnieniem
    grawitacji;
  - log `Persistent vertical bar window moved by the system to x,y (launcher window at …, width …), put back at …`;
  - szerokość ekranu do `offset()` z rzeczywistego wymiaru okna (`WindowManager.getCurrentWindowMetrics()` na 30+, inaczej
    `getRealSize`), nie ze statycznego `Launcher.screenWidth`.
- **Czysta klasa `WindowPlacement`:** zmierzone, oczekiwane, prawa/lewa → nowe `x`.
  - Test: prawa strona przesunięta o szerokość paska, lewa strona, brak różnicy, powtórna korekta bez kumulacji.
- **Test `PageBox`:** ruch, obrót, translacja = nie w spoczynku.
- D-67 bez zmian.

### A5 `Stats: the in-app window never over the launcher's own screens`
- **`StatsWindowRule`:** nowe pojęcie „własny ekran launchera, nie ekran główny” = własny pakiet, gdy `Launcher` nie jest
  `RESUMED`.
  - W tym stanie okno aplikacji i okno ekranu głównego znikają.
  - Okno aplikacji wraca dopiero przy raporcie aplikacji z listy.
- **`CanbusService`:**
  - `currentForegroundApplication`: pakiet spoza listy, który nie jest launcherem, zeruje `curForegroundApp`;
  - `enforceWindowOwner` używa nowej reguły.
- **`SettingsActivity.onResume`:** bezpośrednio powiadamia `CanbusService` (statyczna metoda lub lokalny broadcast
  `Keys.ACCESIBILITY_SERVICE` z pakietem launchera i flagą „own screen”). Okno znika nawet wtedy, gdy po restarcie
  dostępność i `ForegroundAppTracker` jeszcze milczą.
- **Po starcie procesu** okno w aplikacji pokazuje się dopiero po pierwszym raporcie aplikacji z listy (flaga
  „foreground known”).
- **`StateAccessibilityService`** dokłada `className` do broadcastu (do logu).
- **Testy JUnit reguły:** ustawienia launchera, aplikacja z listy, aplikacja spoza listy, pierwszy raport po starcie, powrót na
  ekran główny.

### A6 `Logcat: a stop ends the capture within seconds`
- **Czysta klasa `DrainPlan`** (test):
  - po stopie dociąga linie starsze niż chwila stopu najwyżej **10 s** (`DRAIN_MAX_MS`);
  - logcat bezczynny 1,5 s = koniec (jak dziś);
  - linie nowsze niż stop nigdy.
- **Po przekroczeniu:**
  - `killProcess()`, a następnie sprawdzenie, że proces zniknął (także przez hosta);
  - stopka w pliku: `===== stopped N s after the end; logcat was M s behind, the rest of the buffers not read =====`;
  - log `LogcatWorker: stop: logcat M s behind`.
- **Komentarz przy `beginDrain`:** reguła „boot log do końca, do 2 min” przestaje obowiązywać, bo właściciel chce końca o
  czasie (D-84).
- Test istniejących `LogcatWorker*Test` nie może się zmienić poza tym punktem.

### A7 `Start: before the first unlock the launcher shows the wallpaper`
- **Manifest:** `android:directBootAware="true"` tylko na aktywności `Launcher`.
- **Czysta klasa `DirectBootPlan`** (test): odblokowany → pełny start; zablokowany → tylko tryb tapety; odblokowanie →
  dokończenie.
- **`LauncherApplication`:**
  - `attachBaseContext`: przy `!UserManager.isUserUnlocked()` bez wstępnego wczytywania preferencji (linie 120-128);
  - `onCreate`: przy zablokowanym tylko `CrashLogger.install`; reszta obecnej treści przeniesiona do `startAfterUnlock()`;
  - odbiornik `Intent.ACTION_USER_UNLOCKED` (rejestrowany dynamicznie) woła `startAfterUnlock()` raz;
  - wszystko, co czyta preferencje, bazę lub pliki CE albo startuje usługi (lista: raport kodu, linie 137-277), jest w
    `startAfterUnlock()`.
- **`Launcher`:**
  - pole `mLockedBoot`;
  - `onCreate` przy zablokowanym: `super.onCreate(null)`, `setContentView(new FrameLayout(this))`, odbiornik
    `ACTION_USER_UNLOCKED` → `recreate()`; nic więcej;
  - każde nadpisanie cyklu życia i zdarzeń (`onStart`, `onResume`, `onPostResume`, `onPause`, `onStop`, `onDestroy`,
    `onNewIntent`, `onWindowFocusChanged`, `onActivityResult`, `onConfigurationChanged`, `dispatchTouchEvent`,
    `dispatchKeyEvent`, `onBackPressed` i pozostałe, znalezione przez `rg "@Override" Launcher.java`) zaczyna się od
    `if (mLockedBoot) { super…; return; }`.
- **Log:** `Launcher: direct boot, waiting for the user's unlock` / `LauncherApplication: unlocked, starting`.
- **Robolectric:** w trybie zablokowanym (shadow `UserManager`) nie ma odczytu preferencji; `ShadowSharedPreferences` lub
  licznik w teście.
- FYT: ścieżka bez zmian, bo `isUserUnlocked()` jest prawdą [A]; linia logu do sprawdzenia na 7862.

### A8 `Widgets: the launcher's four own app widgets removed`
Lista z kodu [V], każdą nazwę najpierw `rg`:
- **Manifest:**
  - receivery `com.syu.widget.DateMusicProvider`, `DateTimeProvider`, `DateRadioProvider`, `DateNaviProvider` (387-441);
  - pusta usługa `com.syu.widget.RestartService` (451-458), jeśli nic jej nie używa.
- **Java `com/syu/widget/`:**
  - `WidgetProvider`, `Date*Provider`, `DateTimeProvider1`, `Widget`, `Date*Widget`, `DateTimeWidget1`, `RestartService`,
    `Snippet`;
  - **zostają** `TimeUpdateReceiver` (odświeża też `DateTwo`, `WeekDayTwo`; usunąć z niego wywołania `Widget.check`) i
    `util/TimeUtil`;
  - `util/BootReceiver` tylko po `rg`.
- **Zasoby:**
  - `res/xml/fyt_dt_provider*.xml`; układy `fyt_xml_dt_*` (wszystkie warianty);
  - `drawable-nodpi/fyt_dtwidget_preview*.png`, `fyt_ic_date.png`;
  - wymiary `DT*min*` (`values/dimens.xml:44-47`);
  - napisy `dt_*_widget` we wszystkich plikach.
- **Odwołania:**
  - `share/ResValue.java:374-376`;
  - `Launcher.java`: importy, `TimeUpdateReceiver.register`, `requestWidgetUpdate` i inne miejsca z raportu: 669-670, 1041,
    1101-1127, 1279, 3290, 9217-9218;
  - `LauncherMusicWidget:507,518,1726,1818`, `LauncherRadioWidget:126`;
  - `MediaTransportReceiver:32-36`, `MediaFavoriteReceiver:27-29`, `MediaFavoriteController:728,2023,2205`;
  - `MyAutoMapReceiver:75`, `NotificationListener.kt:1817-1818`, `StockSources:351-352`;
  - `MediaTransportController:434` (stałą `APP_WIDGET_START` przenieść tam, jeśli jest potrzebna);
  - `LauncherWake:10`;
  - `AppsCustomizePagedView:255`: filtr `DateTimeProvider` usunąć, `com.syu.music.MAppWidget` zostaje.
- **Build i profil:**
  - `app/proguard-widgets.pro` i jego wpis w `build.gradle.kts:89`;
  - reguła `AppWidgetProvider` w `proguard-rules.pro:24` zostaje, jeśli w kodzie zostaje jakikolwiek provider (sprawdzić);
  - linie `com/syu/widget` usuniętych klas w obu plikach Baseline Profile.
- **Docs:** `claude/ARCHITECTURE.md:54`.
- Postawione wcześniej takie widżety model usunie jako brakujących dostawców: sprawdzić w raporcie, że ścieżka nie rzuca.

---

## B. Suwak widżetu muzyki (pkt 1, 2)

### B1 `Music widget: the slider in the bar's colour, centred on its line`
**Fakty:**
- Tor `music_position` (`res/layout/music_widget_content.xml:55-64`) to bitmapy `music_slide_bar.png` / `music_slide_bg.png`
  (553×30), których linia leży w wierszach 12–16, nad środkiem obrazka. Dlatego uchwyt wygląda „pod paskiem”.
- Uchwyt to `GradientDrawable` w `R.color.colorAccent` (`MusicWidgetSizer.sizeKnob:404-417`), bez tintu.
- `applyStyle` (`LauncherMusicWidget:1843-1862`) tintuje `musicProgress`, nie `musicPosition`.

**Kroki:**
1. Kolory toru:
   - odczytać z PNG kolor linii niezagranej (`music_slide_bar`) i zagranej (`music_slide_bg`), np. narzędziem Read do obrazu
     albo skryptem Python ze `zlib`;
   - zapisać w `colors.xml` jako `music_track_unplayed` / `music_track_played`.
2. Nowy rysunek toru tylko dla `music_position`: `layer-list` z `@android:id/background` i `@android:id/progress` jako
   zaokrąglone `shape`.
3. Grubość linii = ¼ średnicy uchwytu, min 2 dp. SeekBar `setMinHeight`/`setMaxHeight` = grubość (API 29+; niżej przez
   refleksję na `mMinHeight`/`mMaxHeight` jak AppCompat), więc tor i uchwyt leżą na środku rzędu.
4. Kolor:
   - zagrana część i uchwyt = tint widżetu (`WidgetStyle.Role.WIDGET_PROGRESS`), a bez tintu `music_track_played`;
   - niezagrana = `music_track_unplayed`;
   - `applyStyle` obejmuje `musicPosition` i uchwyt (zmiana koloru w ustawieniach od razu).
5. SHOW i GREY: bez uchwytu (jak dziś, `setAlpha(0)`). GREY: progress 0.
6. Cienki `music_progress` i jego bitmapy bez zmian (skórki).

**Testy:**
- Robolectric: środek toru = środek uchwytu = środek widoku;
- kolor uchwytu = tint; po zmianie stylu nowy kolor.

### B2 `Music widget: the slider owns its touches, in a larger touch area`
**Fakty:**
- SeekBar wierzy, że jest w przewijanym kontenerze (`ViewGroup.shouldDelayChildPressedState` = true w `PagedView`). Przejmuje
  gest dopiero po 8 dp, a `Workspace` zaczyna przesuwanie po 8 px (`PagedView:357`, `persist.sys.la_touch_slop`).
- Przy „układaniu się” stron `PagedView` przechwytuje już DOWN (1543-1553).

**Kroki:**
1. Nowa klasa `PositionSeekBar extends SeekBar` (`music_widget_content.xml` używa jej dla `music_position`).
   - Obszar trafienia (czysta klasa `SliderHitArea`, test): pas toru na całej szerokości plus koło uchwytu, oba powiększone
     o 30% średnicy uchwytu (po 15% z każdej strony).
   - Obszar wychodzi poza widok: `TouchDelegate` na rodzicu `rl_music` / treści widżetu.
2. W trybie SEEK, na DOWN w obszarze:
   - `getParent().requestDisallowInterceptTouchEvent(true)`;
   - rejestracja „właściciela dotyku” (`TouchOwner.claim(view)`), zwolnienie na UP/CANCEL.
3. `Workspace.onInterceptTouchEvent` / `PagedView.onInterceptTouchEvent`:
   - gdy `TouchOwner` ma właściciela, nie przechwytują (także przy układaniu się stron);
   - `determineScrollingStart` wraca od razu.
4. SHOW/GREY i dotyk poza obszarem: suwak `setEnabled(false)` i nie rejestruje się; dotyk idzie do widżetu i stron jak dziś.
5. Ruch suwaka zmienia tylko pozycję (`onStopTrackingTouch` → `seekTo`, bez zmian).

**Testy:** Robolectric, przeciągnięcie suwaka na stronie nie zmienia strony; dotyk obok suwaka przesuwa strony.

- **com.syu.music:** bez kodu; dokumentacja w J1/J2 (fakty z §2).

---

## C. Akcent, przełączniki, „Stock layout”

### C1 `Theme: one accent colour, chosen in "Set global theme color"`
**Fakty:**
- `colorAccent = #ff4285f4` (`values/colors.xml:18`).
- Kolor na sztywno także w:
  - `CreatorScreen.java:175`;
  - `seekbar_preference_correction.xml:19`, `seekbar_preference_brightness.xml:19`, `seekbar_preference_autohide.xml:28`;
  - `drawable/custom_seekbar_thumb.xml:16`, `drawable/toast_bg.xml:6-7`.
- `SettingsTheme` ustawia tylko `android:colorAccent`.

**Kroki:**
1. Wszystkie kolory na sztywno → `@color/colorAccent`; w kodzie `ThemeAccent.color(ctx)`.
2. **Czysta klasa `ThemeAccent`** (test):
   - kolor zapisany pod `theme_accent_color` (int), brak = `colorAccent`;
   - przy „Stock layout” zawsze domyślny (C3);
   - `lighter(color)`: jasność HSL +0,25 z obcięciem, dla toru przełącznika i tła zaznaczenia.
3. **Klasa `AccentPainter`** (android) maluje drzewo widoków. Koloruje to, co ma domyślny akcent albo tag
   `@string/tag_accent` (dodać do układów, gdzie akcent jest przez drawable):
   - `TextView` z kolorem = domyślny akcent;
   - `SwitchCompat` (C2);
   - `SeekBar`: progress i thumb;
   - `CheckBox` / `RadioButton`: `buttonTint`;
   - `ProgressBar`;
   - tła znane z akcentu: `bar_order_tile`, `pip_mode_cover`, `custom_seekbar_thumb`.

   Tag zapamiętuje, że widok był w akcencie, żeby kolejne przemalowanie działało.
4. Wywołania `AccentPainter`:
   - lista preferencji obu ekranów i nowych ekranów przez `RecyclerView.OnChildAttachStateChangeListener`;
   - pasek akcji: tło `ColorDrawable(accent)`;
   - dialogi `SettingsDialogs.builder` przez `setOnShowListener` (przyciski i tło);
   - `ColorPicker.kt`, `BackgroundSelectorDialog`, listy aplikacji, `BarOrderDialog`;
   - toast z `toast_bg`.
5. `SettingsTheme`: dopisać `<item name="colorAccent">@color/colorAccent</item>` (app namespace), żeby AppCompat brał akcent
   jako domyślny.
6. **Wiersz** `theme_accent_color` „Set global theme color” na końcu „Home screen layout”:
   - okno koloru `ColorPicker.newTextInstance(color, allowDefault=true)`, tag `ColorPickerTargets.TAG_ACCENT`, bind i rebind
     jak `bindTint` („Default” usuwa klucz);
   - po „Select” zapis (`apply`) i natychmiast: `AccentPainter.paint(getListView())`, `notifyDataSetChanged()` adaptera,
     przemalowanie paska akcji; bez `recreate()`;
   - launcher odświeża swoje widoki z akcentem przy powrocie z ustawień (`helpers.setBarSettingsChanged(true)`).
7. Plakietki (H2) mają własny kolor; akcent jest dla nich tylko domyślny.

**Robolectric:** po zmianie koloru przełącznik, tytuł kategorii i przycisk dialogu mają nowy kolor.

### C2 `Settings: every switch in the accent colour`
- **Fakt:** dziś żaden przełącznik nie ma akcentu (teal AppCompat), bo brakuje app `colorAccent`.
- `AccentPainter` dla `SwitchCompat`:
  - kciuk włączony = akcent, tor włączony = `lighter(akcent)` z alfą 0x80;
  - wyłączony: kciuk `#ECECEC`, tor `#808080` z alfą 0x60.
- Dotyczy wszystkich klas:
  - `SwitchPreferenceCompat`, `CustomSwitchPreference`, `CustomNoSwitchPreference`, `CustomNestedNoSwitchPreference`,
    `CustomPipSwitchPreference`, `CustomDualPipPreference`, `CustomWidgetSwitchPreference`, `CustomWidgetPreference`;
  - przełączniki w dialogach.
- `pipModeSwitch` (przezroczysty nad `pip_mode_cover`): tylko tło przez `AccentPainter`.
- **Robolectric:** na obu ekranach każdy włączony przełącznik ma kciuk w kolorze akcentu.

### C3 `Layout: "Stock layout" applies none of the creator's settings`
- **Czysta klasa `CreatorKeys`:** zbiór kluczy z `creator_preferences.xml` + nowe klucze tej rundy.
  - Test parsuje XML (`app/src/main/res/xml/creator_preferences.xml`) i porównuje.
  - Klucze `persistent=false` wpisane ręcznie z uzasadnieniem.
  - Do zbioru należą też klucze zapisywane przez wiersze bez własnego klucza: `WORKSPACE_GRID_LONG/SHORT`, `*_tint_color`,
    `*_selected_background`, `*_custom_background_color`, kolejność paska.
- **`CreatorPrefs.of(prefs)`:** opakowanie `SharedPreferences`. Przy `USER_LAYOUT == false` każdy klucz z `CreatorKeys` daje
  wartość domyślną wołającego (`getBoolean(key, def)` → `def`).
- **Odczyty w launcherze przez `CreatorPrefs`** (lista z kodu [V], dopisać znalezione):
  - `Workspace.applyBarConstraints` (978 → 1783-1801: `HORIZONTAL_BAR_TOP`, `VERTICAL_BAR_RIGHT`);
  - `applyVerticalBarBackground` (979 → `BarBackground.vertical`), `applyBarBackgrounds` (1152);
  - `Workspace:892` `WidgetStyler.barTint`;
  - `LauncherMusicWidget.initMusicWidgetView:1413-1417` (`widgetsTint`), `Launcher.mWidgetStyleListener:1427-1431`;
  - `BubbleTextView.onFinishInflate:77`, `CellLayout.iconLabelHeight:453`, `DynamicGrid:51` (rozmiary tekstu);
  - `WorkspaceGrids.longCells/shortCells/rows/columns` (siatka; przy stock 10×6);
  - nowe klucze tej rundy (każdy commit dopisuje swoje).
- **Bez zmiany:** `LauncherAppBars.shouldUseLeftRecycler` (stock ma zawsze lewy pasek, to projekt stock).
- **Ustawienia:** wiersz „LAYOUT CREATOR” już jest wyszarzony (`SettingsFragmentFirst:390, 754-780`). Wiersze ekranu twórcy są
  osiągalne tylko przez niego. „Notification badges” (ekran launchera) działa zawsze.
- **Testy:**
  - JUnit `CreatorPrefs`;
  - Robolectric: „Stock layout” z zapisanym kolorem paska, siatką 12×8 i rozmiarem tekstu 40 daje wartości domyślne.
- **Dokumentacja:** KI-33 → accepted (reguła właściciela), D-85.

---

## D. „Home screen layout” (pkt 4)
Na końcu kategorii, w tej kolejności:
1. kolor tekstu ikon (D1);
2. kolor motywu (C1);
3. HSL1, HSL2 (D2);
4. double tap (D3);
5. tło folderów (D4);
6. HSL3 (D5);
7. HSL4 (D6);
8. HSL5 (D7).

Wszystkie są w `CreatorKeys`.

### D1 `Home: an icon text colour of its own`
- **Wiersz** `workspace_text_color`, napis `icon_text_color` „Set icon text color”:
  - okno koloru tekstu, „Default” = dzisiejszy biały `R.color.workspace_icon_text_color`;
  - tag `ColorPickerTargets.TAG_ICON_TEXT`, bind i rebind jak `bindTint`.
- **Zastosowanie przez `CreatorPrefs`:**
  - `BubbleTextView.onFinishInflate:79` (ekran główny, paski z `BubbleTextView`);
  - nazwa `FolderIcon` (`folder_icon_name`).
- Zawartość otwartego folderu: kolor `#333333` zostaje, chyba że wybrano własne tło folderów (D4); wtedy kolor z D1.
- Zmiana działa po powrocie z ustawień: przebudowa stron przez `helpers.setBarSettingsChanged(true)` albo odświeżenie
  `BubbleTextView` stron; wybrać tańsze i opisać.

### D2 `Home: swipe up opens the app drawer, swipe down the notifications`
- **HSL1** `swipe_up_app_drawer` (domyślnie false), **HSL2** `swipe_down_notifications` (domyślnie false); przełączniki
  `CustomSwitchPreference` z opisami on/off.
  - Opis HSL2 „on” na FYT: wariant `swipe_down_notifications_on_fyt` (z kodu, `LauncherApplication.isFytDevice()`).
- **Czysta klasa `HomeGesture`** (test): wejście `dx, dy, czas, prędkość`; wynik `UP`, `DOWN`, `NONE`.
  - Kąt > 60° od poziomu, dystans ≥ 12% krótszego boku ekranu albo prędkość ≥ 1000 dp/s.
  - Gest nie startuje, gdy DOWN był na widżecie aplikacji (`LauncherAppWidgetHostView`), elemencie użytkownika
    (`CellLayout.isUserWidget`), suwaku (`TouchOwner`), w trybie przeglądu, w szufladzie, w otwartym folderze ani podczas
    przeciągania.
- **`Workspace.onInterceptTouchEvent`:**
  - pionowy ruch powyżej slopu (dziś ignorowany w `determineScrollingStart` dla `theta > MAX_SWIPE_ANGLE`), przy włączonym
    HSL1 lub HSL2: przechwycenie i śledzenie do UP;
  - na UP decyzja `HomeGesture`.
- **UP → szuflada:** `Launcher.showAllApps(true, Applications, true, /*fromSwipe*/ true)`.
  - Nowa animacja w `showAppsCustomizeHelper` przy `fromSwipe`: `translationY` od wysokości ekranu do 0 i alfa 0→1, 300 ms,
    `DecelerateInterpolator`.
  - Zamykanie bez zmian.
- **DOWN → panel (`StatusBarPanel.expand(ctx)`):**
  1. `getSystemService("statusbar")` i refleksja `expandNotificationsPanel` (uprawnienie `android.permission.EXPAND_STATUS_BAR`,
     normal, do manifestu);
  2. przy błędzie, gdy usługa dostępności działa: `performGlobalAction(GLOBAL_ACTION_NOTIFICATIONS)`. Statyczna instancja
     `StateAccessibilityService.sInstance` ustawiana w `onServiceConnected`, czyszczona w `onUnbind`;
  3. log, która droga zadziałała;
  4. 7862 pokazuje tylko pasek szybkiego wyboru (FYT blokuje powiadomienia), zgodnie z opisem.
- HSL1 może być wymuszony przez E1/E2 (`DrawerAccess.swipeUpRequired`).

### D3 `Home: a double tap does nothing, locks or turns the screen off`
- **Wiersz** `double_tap_action` (lista, opis = wybór): `none` (domyślnie), `lock`, `screen_off`.
  - Na API < 28 bez `lock` (`GLOBAL_ACTION_LOCK_SCREEN` od API 28).
- **Rozpoznanie** (czysta klasa `DoubleTap`, test): dwa dotknięcia pustego miejsca (droga `onWallpaperTap`, `Workspace` UP
  przy `TOUCH_STATE_REST` bez zajętej komórki) w czasie `ViewConfiguration.getDoubleTapTimeout()` i w odległości
  `getScaledDoubleTapSlop()`.
- **`lock`:**
  - `StateAccessibilityService.sInstance.performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)`;
  - gdy usługa wyłączona: toast `double_tap_needs_accessibility` i krok `ACCESSIBILITY` w `LauncherPermissionFlow`
    (potrzebny, gdy wybrano `lock` i usługa wyłączona; otwiera `Settings.ACTION_ACCESSIBILITY_SETTINGS`).
- **`screen_off` na FYT** (`isFytDevice()`):
  - `DataMain.PROXY.cmd(FinalMain.C_BLACKSCREEN, new int[]{2})`, dokładnie to, co wysyła kafelek 7862;
  - ekran przywraca sam system (na 7862 double tap), bez snu i bez wybudzenia (`WakeSignals`: „not a sleep”);
  - gdy com.syu.ms nie jest podłączony: droga dla innych urządzeń;
  - log `Home double tap: black screen through com.syu.ms`;
  - 7870: ta sama komenda [A], sprawdzi tester.
- **`screen_off` na innych urządzeniach — klasa `ScreenOffOverlay`:**
  - okno `TYPE_APPLICATION_OVERLAY` (uprawnienie nakładki jest już w przepływie, krok OVERLAY), cały ekran, czarne;
  - flagi `FLAG_LAYOUT_IN_SCREEN | FLAG_KEEP_SCREEN_ON | FLAG_FULLSCREEN`, okno focusowalne (inaczej jasność nie działa),
    `screenBrightness = 0f`;
  - paski systemowe schowane (`WindowInsetsController.hide`);
  - pojedyncze dotknięcia pochłonięte, **double tap (`DoubleTap`) zamyka okno**;
  - okno znika też przy `ACTION_SCREEN_OFF` (użytkownik uśpił urządzenie przyciskiem), żeby po wybudzeniu nie było czarno;
  - bez blokady, snu i wake;
  - log otwarcia i zamknięcia.
- **Robolectric:** dwa dotknięcia w czasie i odległości wywołują akcję; jedno nie.

### D4 `Folders: a background of their own`
Wzór istniejący [V w kodzie]:
1. `Keys.FOLDERS_SELECTED_BACKGROUND = "folders_selected_background"`; kolor własny przez
   `BackgroundChoice.colorKey(...)`; klucz wiersza `choose_folders_background`.
2. `BackgroundSelectorDialog.create()`: gałąź `"folders"` (tag), filtr obrazków jak dla `"widgets"` (`bg_custom`), domyślnie
   `null`, czyli dzisiejszy `portal_container_holo`.
3. Układ `res/layout/folders_background_selector.xml`: kopia `bar_background_selector.xml` z id `folders_background_grid`,
   `folders_background_cancel_button`.
4. W `SettingsFragmentSecond`: metoda `checkAndShow…` i wartość `PendingDialog` (90-96, 1249-1262).
5. Akcesor `BarBackground.folders(ctx, prefs)`; klucz w `WidgetStyler.isLookSetting` (31-39).
6. Zastosowanie: tło `user_folder.xml` (`Folder.onFinishInflate` lub `fromXml`); kolor tekstu zawartości wg D1, gdy tło
   własne.
- Ikona folderu (pierścień) bez zmian.

### D5 `Folders: the home screen's grid inside, if chosen`
- **HSL3** `folder_follow_grid` (domyślnie false), opisy on/off.
- **`Folder`** (konstruktor 137-140, `setupContentDimensions` 908-935):
  - przy HSL3: `mMaxCountX/Y = WorkspaceGrids.columns/rows` bieżącej orientacji (przez `CreatorPrefs`);
  - `countX` = kolumny ekranu głównego zawsze, `countY = ceil(n / countX)`;
  - szerokość komórki = szerokość komórki strony (`CellLayout.getCellWidth()` bieżącej strony), szerokość folderu obcięta do
    szerokości strony; powyżej wysokości strony przewijanie jak dziś.
- Bez HSL3 bez zmian (dzisiejsze „prawie kwadratowe” rośnięcie).
- **Czysta klasa `FolderGrid`** (test): oba tryby, n = 1, 5, 40.

### D6 `Widgets: free placement and size on the home screen`
- **HSL4** `widget_freeform` (domyślnie false).
- **Fakty:**
  - elementy użytkownika (data, muzyka, radio, PiP, statystyki) już mają dokładne piksele: `lp.isLockedToGrid = false`, `lp.x/y`
    (`CellLayout.addPipPlaceholder 4337-4450`, `addCustomWidgetToGrid 4129-4262`);
  - `ShortcutAndWidgetContainer.setupLp/measureChild/onLayout` (126-141, 209-215, 266-271) honoruje je dla
    `CellLayout.isUserWidget(view)`.
- **Model:** czysta klasa `WidgetFrame` (test) — ułamki strony (`l, t, r, b` względem obszaru `ShortcutAndWidgetContainer`) ↔
  piksele; przyciąganie do najbliższych komórek.
- **Magazyn:** plik preferencji `widget_frames`, klucz = `appWidgetId`, wartość `"l,t,r,b"`.
  - Wczytanie z wyprzedzeniem w `LauncherApplication.warmUpOffMainThread` (obok innych plików preferencji).
  - Zapis `apply()`.
  - Baza bez zmiany schematu: `cellX/cellY/spanX/spanY` zapisywane jako najbliższe komórki (na wypadek wyłączenia).
- **Ułożenie:** przy HSL4 widżet z ramką = `isLockedToGrid = false` + piksele. `CellLayout.isUserWidget` lub nowe
  `isFreeformWidget(view)` obejmuje go w `ShortcutAndWidgetContainer`.
- **Przeciągnięcie istniejącego widżetu** (`Workspace.onDrop`): przy HSL4 pozycja z lewego górnego rogu widoku przeciąganego
  względem `CellLayout`, obcięta do strony; zapis ramki.
- **Nowy widżet z listy:** ramka startowa = prostokąt komórek z `createArea`, dalej swobodnie.
- **Zmiana rozmiaru:** `AppWidgetResizeFrame` w trybie pikselowym przy HSL4.
  - `resizeWidgetIfNeeded` liczy piksele z przeciągnięcia uchwytów, obcina do strony i do minimum
    `minResizeWidth/minResizeHeight` (albo `minWidth/minHeight`).
  - `commitResize` zapisuje ramkę i aktualizuje opcje rozmiaru widżetu (istniejące `updateWidgetSizeRanges`).
- **Zajętość:**
  - przy HSL5 wyłączonym widżet swobodny zaznacza komórki, które pokrywa (jak elementy użytkownika, `pointToCellExact` →
    `markCellsForView`), więc ikony go omijają;
  - przy HSL5 włączonym nie zaznacza.
- **Wyłączenie HSL4:**
  - każdy widżet przyciągnięty do najbliższych komórek (`WidgetFrame.snap`); zajęte → najbliższe wolne
    (`findCellForSpan`/`findNearestVacantArea`);
  - brak miejsca przy HSL5 wyłączonym → ten sam dialog i usuwanie co D7;
  - przy HSL5 włączonym zostaje na najbliższych komórkach.
- **Testy:**
  - JUnit `WidgetFrame`;
  - Robolectric: widżet z ramką leży w swoich pikselach, po wyłączeniu na komórkach.

### D7 `Widgets: may overlap other items`
- **HSL5** `widget_overlap` (domyślnie false).
- **Włączony:**
  - widżety nie zajmują komórek ani dla ikon, ani dla innych widżetów;
  - upuszczenie widżetu na zajęte miejsce nie przestawia innych (bez reorder w `createArea`);
  - `CellOverlap.resolveOverlappingItems` (~4924-4990) pomija widżety;
  - widżety rysowane nad ikonami (kolejność dzieci); dotyk trafia w wierzchni.
- **Wyłączenie** (`OnPreferenceChangeListener` zwraca false do decyzji):
  - dialog `widget_overlap_off_title` / `widget_overlap_off_message`, Cancel / OK;
  - **Cancel:** przełącznik zostaje włączony;
  - **OK:**
    1. czysta klasa `GridRefit` (test): ikony i foldery stoją; widżety po kolei (od lewej-górnej strony) zostają, jeśli ich
       komórki wolne, inaczej najbliższy wolny prostokąt tej samej wielkości, inaczej usunięcie;
    2. zastosowanie na wątku roboczym: `LauncherModel.moveItemInDatabase` / `deleteItemFromDatabase` i
       `mAppWidgetHost.deleteAppWidgetId`;
    3. przeładowanie stron;
    4. log każdego usuniętego widżetu.
- **Testy:** JUnit `GridRefit` (miejsce jest, przesunięcie, usunięcie).

---

## E. Paski (pkt 5)

### E1 `Bars: "Display horizontal bar" and "Display vertical bar"`
- **B1** `display_horizontal_bar` (domyślnie true): przełącznik bez opisu, nad `horizontal_bar_top`.
- **B1 wyłączony, w ustawieniach** (nowa metoda `updateHorizontalBarRows()` w `SettingsFragmentSecond`): ukryte
  - wiersze paska poziomego (2–11 z listy: od `bottom_bar_every_page` do `horizontal_bar_order`);
  - separator `preference_separator_within` przed `widget_bar`;
  - cała sekcja „Widget horizontal bar”.
- **B1 wyłączony, w launcherze** (przez `CreatorPrefs`):
  - na stronach widoki paska poziomego `GONE`;
  - okno paska nie powstaje (`showOverlayHorizontalBar` wraca);
  - auto-hide, uchwyt i `BarSwipeFrame` wyłączone;
  - `HorizontalBarPlacement.reserve` = `NONE`, więc siatka (`WorkspaceGrids.reserve`) dostaje miejsce;
  - Overview / `PageBarGhost` bez paska.
- **„Use vertical bar” → „Display vertical bar”** (nowy klucz napisu `display_vertical_bar`), bez opisu:
  - usunięte `summaryOn/summaryOff`;
  - napisy `vertical_bar_on` / `vertical_bar_off` i stary tytuł usunięte po `rg`;
  - klucz `left_bar` zostaje.
- **Czysta klasa `DrawerAccess`** (test): `swipeUpRequired(displayHorizontal, drawerHidden) = !displayHorizontal ||
  drawerHidden`.
  - Ustawienia: przy wymaganym HSL1 zapis `true`, wiersz wyłączony (`setEnabled(false)`), opis
    `swipe_up_app_drawer_required`.
  - Launcher: HSL1 = zapisane ‖ wymagane.

### E2 `Bars: the app drawer button may be hidden`
- **B2** `horizontal_bar_no_drawer` (domyślnie false, czyli przycisk widoczny), pod B1, wzór „Hide the date”; opisy on/off.
- Przycisk `rl_allapps` `GONE`; jego miejsce wg reguły E3 (data 10%, pogoda 10%, aplikacje 40%, muzyka 40%).
- Bez paska widżetów (szuflada + aplikacje): aplikacje dostają całość.
- Wymusza HSL1 (E1). `BarOrder.shown` bez przycisku.

### E3 `Bars: the music widget may be hidden, the room shared by one rule`
- **B3** `widget_bar_no_music` (domyślnie false) w „Widget horizontal bar”: chowa też „Hide the album cover”
  (`updateWidgetBarRows`).
- **Czysta klasa `BarShares`** (test) zastępuje `WidgetBarPlan.shares` / `appsShare`; `WidgetBarPlan` zostaje jako fasada dla
  wywołań, z testami.
- Elementy: szuflada `D`, aplikacje `A`, muzyka `M`, data `T` (tylko poziom), pogoda `W`. Udziały zwykłe z dzisiejszych
  stałych i XML:
  - poziom: D 0,09, A 0,4395, M 0,28, T 0,05, W 0,12;
  - pion: D 0,10, A 0,4385, M 0,295, W 0,15.
- **Reguły oddawania** (właściciel):

  | Ukryty / oddaje | Odbiorcy |
  |---|---|
  | T (data) | M 100% (dzisiejsza reguła) |
  | W (pogoda) | M 100% (dzisiejsza reguła) |
  | A (ukryte lub dopasowane: wolne miejsce) | T 10%, W 10%, M reszta (runda 26) |
  | D (przycisk szuflady) | T 10%, W 10%, A 40%, M 40% |
  | M (muzyka) | T 10%, W 10%, A 80% |

- **Algorytm** (kolejność dawców: T, W, A, M, D; dawca oddaje swój zwykły udział, ukryty element nic nie dostaje):
  1. Część dla odbiorcy niewidocznego idzie do odbiorcy „reszty” danej reguły, jeśli widoczny (M dla T/W/A, A dla M, M i A po
     równo dla D).
  2. Gdy żaden odbiorca reguły nie jest widoczny: po równo między wszystkie widoczne elementy.
  3. Podział nieokreślony przez właściciela = po równo między widoczne.
  4. Suma udziałów stała.
- **Jeden widoczny element:** dostaje całość, a jego zawartość jest wyśrodkowana.
- **Wszystkie elementy paska widżetów ukryte:** zostaje przycisk szuflady, wyśrodkowany.
- **Ukryty i przycisk:** brak elementów.
  - Ustawienia (przy każdym wyłączeniu części paska; czysta `BarShares.empty(...)`) zapisują B1 = false.
  - Toast `horizontal_bar_turned_off`.
  - Wiersze odświeżone.
- **Zastosowanie wszędzie, gdzie dziś są udziały:**
  - `WidgetBarLayout` (strona; procenty `rl_allapps`, `recycler_view`, `rl_music_two`, daty, pogody);
  - `Workspace.forceOriginalSizesLayoutOne/Two` (okno);
  - `BarCapacity` (pokój listy aplikacji);
  - `AppListAdapter.applyTileMetrics`;
  - `MusicWidgetSizer` (`musicShare`);
  - `BarOrder.shown` / `anchors` bez ukrytych.
- **Robolectric** (wzór `WidgetBarFitViewTest`), w obu orientacjach: przypadki B2, B3, B2+B3, tylko szuflada, pusty pasek.
  Sprawdzane: bez nakładania, strona = okno, wyśrodkowanie.

---

## F. Szuflada aplikacji (pkt 6, 7, 8)

**Fakty:**
- Szuflada to `AppsCustomizeTabHost` + `AppsCustomizePagedView` (`res/layout/apps_customize_pane.xml`; karty ukryte, typ
  treści wybiera wołający).
- Siatka na sztywno: `DeviceProfile.updateFromConfiguration:184-191` (pion 7×4, poziom 4×7); `AppsCustomizePagedView`
  `onDataReady:382`.
- Ikona: `apps_customize_application.xml` (`PagedViewIcon`, tekst `#ffffffff`); rozmiar tekstu `DeviceProfile.labelTextSizeSp`
  z `all_apps_textSize`.
- Kolejność: `LauncherModel.getAppNameComparator()`.
- Przeciąganie: `PagedViewWithDraggableItems.onLongClick` → `beginDragging` → `beginDraggingApplication` →
  `workspace.beginDragShared`.
- Otwieranie: `Launcher.showAllApps` 7907, `showAppsCustomizeHelper` 7617.

### F1 `Settings: an "App drawer" section under "Bars"`
- Nowa kategoria `all_apps_category` „App drawer” pod „Bars” (separator `preference_separator` przed nią), kolejno:
  1. **Rows / Columns:** tytuły „Rows: %1$d” / „Columns: %1$d” (istniejące napisy), suwaki bez opisu, bez notatek.
     - Klasa `GridSeekBarPreference` uogólniona atrybutami `gridLongKey` / `gridShortKey` / limity.
     - Nowe klucze `all_apps_grid_long` (domyślnie 7), `all_apps_grid_short` (domyślnie 4), limity 3–12 / 2–8.
     - `DeviceProfile.updateFromConfiguration` bierze z nich `allAppsNumRows/Cols` (przez `CreatorPrefs`).
     - `AppsCustomizePagedView` przelicza strony po zmianie (`setCellCount` + `invalidatePageData`).
  2. **„Set icon text size”** przeniesiony z „Home screen layout” (`all_apps_textSize`, ta sama klasa `IconTextSizeRows`).
     - Wspólny napis `icon_text_size` dla szuflady i ekranu głównego (`workspace_textSize` zostaje w „Home screen layout” z nowym
       napisem); klucze preferencji bez zmian.
     - Stare napisy `all_apps_textSize_str`, `workspace_textSize_str` usunięte.
  3. **„Set icon text color”** (`icon_text_color`): klucz `all_apps_text_color`; `PagedViewIcon` i lista pionowa (F2).
  4. **Przełącznik `all_apps_search`** „Search bar” (domyślnie false), opisy on/off.
  5. **`all_apps_scroll`** „Scrolling direction”: lista bez przełącznika, wybór w opisie; `vertical` (domyślnie) /
     `horizontal`.
  6. **`drawer_tabs`** „Tabs”: przejście do twórcy zakładek (F5), opis `drawer_tabs_summary`; w F1 wiersz już jest, a ekran
     dochodzi w F5 (do tego czasu wiersz ukryty).
- **Robolectric** `PreferenceScreensTest`: kolejność kategorii i wierszy.

### F2 `App drawer: vertical scrolling with a letter bubble`
- **Tryb `vertical` (domyślny):** w `apps_customize_pane.xml` obok `AppsCustomizePagedView` widok `AppsVerticalView`
  (`RecyclerView` + `GridLayoutManager`, liczba kolumn = kolumny z F1).
  - Widoczny przy treści `Applications` i trybie pionowym; `AppsCustomizePagedView` przy poziomym oraz dla widżetów (do G1).
  - Elementy: ten sam układ `apps_customize_application.xml` (`PagedViewIcon.applyFromApplicationInfo`), ten sam wygląd i
    rozmiar tekstu.
  - Dane: `mApps` z `AppsCustomizePagedView` (posortowane; jedno źródło).
- **Klik:** to samo co `AppsCustomizePagedView.onClick` (525-575), wydzielone do wspólnej metody.
- **Przeciąganie:** długie przytrzymanie → ta sama droga co `beginDraggingApplication`.
  - `AppsVerticalView` implementuje `DragSource`; wspólny kod z `AppsCustomizePagedView` wydzielony do klasy `DrawerDragSource`.
  - Potem `enterSpringLoadedDragMode()`, jak dziś.
- **`LetterScroller` (szybkie przewijanie po prawej):**
  - cienki tor, uchwyt w kolorze `ThemeAccent`;
  - chwycenie (dotyk na torze) pokazuje dymek w kolorze akcentu z białą literą;
  - dymek: koło z dzióbkiem skierowanym do uchwytu, symetryczne w przekroju poziomym, bez nieregularnych kształtów
    (`Path`: okrąg + trójkąt równoramienny);
  - dymek podąża za uchwytem w pionie, znika po puszczeniu (krótkie zanikanie);
  - przesuwanie uchwytu przewija listę do pozycji litery.
- **Czysta klasa `LetterIndex`** (test):
  - litera = pierwszy znak tytułu po normalizacji (`Normalizer` NFD, bez znaków diakrytycznych, wielkie litery; cyfry i
    symbole jako „#”);
  - pozycja ↔ litera, granice.
- **Tryb `horizontal`:** dzisiejszy `AppsCustomizePagedView`.
- **Robolectric:** tryb pionowy pokazuje wszystkie aplikacje w kolumnach z F1; `LetterScroller` ustawia pozycję.

### F3 `App drawer: a search bar`
- Przy `all_apps_search`: u góry treści szuflady (nad zakładkami z F6, jeśli są na górze) pole wyszukiwania, zawsze widoczne
  niezależnie od przewinięcia.
  - Zaokrąglone tło w kolorach ustawień; lupa po lewej (wektor `ic_search`); podpowiedź `search_apps_hint` „Search
    applications”.
  - Klawiatura dopiero po dotknięciu pola.
- **Czysta klasa `AppSearch`** (test): filtr po nazwach, bez wielkości liter i znaków diakrytycznych, w czasie rzeczywistym.
  Wynik zawęża listę pionową i strony poziome (`AppsCustomizePagedView` dostaje przefiltrowane `mApps`).
- Zamknięcie szuflady czyści pole.

### F4 `Settings: the drawer tabs' model and the lists of apps`
**Czysta klasa `DrawerTabs`** (JSON w preferencjach `drawer_tabs`; test pokrywa wszystkie reguły niżej):
- **Zakładki:**
  - główna: id 0, nazwa domyślna `drawer_tab_main` „Apps”, nieusuwalna, zawsze pierwsza na liście;
  - dodatkowe: nazwa domyślna „Tab%d” (`drawer_tab_default`, numer = pozycja; główna to 1), kolejność, zbiór pakietów;
  - flaga `keepInMain` („Keep apps in main app tab”).
- **Ukryte aplikacje** (`hidden`): nie ma ich w żadnej zakładce szuflady.
- **Reguła powtórzeń** `drawer_tabs_repeat`:
  - `all` (domyślnie): aplikacja może być w wielu zakładkach dodatkowych;
  - `except_main`: jak `all`, ale aplikacja z zakładki dodatkowej nigdy nie jest w głównej;
  - `none`: aplikacja w najwyżej jednej zakładce.
- **Zakładka główna pokazuje** wszystkie nieukryte aplikacje poza tymi z zakładek dodatkowych. Wyjątek: przy `all` aplikacje
  zakładek z `keepInMain` zostają też w głównej.
  - Przy `except_main` i `none` flaga `keepInMain` nie działa: checkbox wyszarzony z dopiskiem `keep_in_main_inactive`.
  - Opis reguły pokazuje zakładki z flagą w osobnych liniach.
  - [Decyzja planu: zasada pogodzenia obu ustawień.]
- **Lista L1 kandydatów zakładki** wg reguły:
  - `all` / `except_main`: wszystkie nieukryte (+ ukryte przy „Show hidden apps”);
  - `none`: nieukryte, które nie są w innej zakładce dodatkowej, plus już przypisane do tej.
- **Nazwa:**
  - dowolne znaki, maks. 50 (wklejenie dłuższej obcina do 50; `InputFilter.LengthFilter(50)`);
  - pusta lub same białe znaki (`trim().isEmpty()`, także znaki niewidoczne Unicode) = brak zmiany / brak dodania.
- **Usunięcie zakładki:** jej aplikacje wracają tam, gdzie wynika z reguł (do głównej, jeśli nie ma ich gdzie indziej).
- **Odinstalowana aplikacja** znika z modelu przy następnym odczycie.

**Ekrany list** (fragmenty ustawień, wejście z D1/D2/F5):
- **L1** `DrawerTabAppsFragment`: tytuł = nazwa zakładki.
- **L2** `DrawerHiddenAppsFragment`: tytuł `hide_apps` „Hide apps”.
- **Nagłówek:** tytuł po lewej, po prawej przycisk z trzema pionowymi kropkami. Otwiera `PopupWindow` w prawym górnym rogu:
  - wiersz „Show hidden apps” z checkboxem po prawej; czarny tekst na jasnym tle; okno niewiele większe od treści, odstępy jak
    w ustawieniach;
  - klik w dowolną część wiersza przełącza, zamyka okno i pokazuje lub chowa ukryte aplikacje na liście (tylko na listach; w
    szufladzie ukryte zostają ukryte).
- **Lista:** `RecyclerView`; w wierszu tylko nazwa (po lewej) i checkbox (po prawej), bez ikony, jak opisał właściciel.
  - Wiersze wysokie (min 64 dp), subtelne linie podziału (1 dp `settings_divider` z alfą 0x40).
  - Klik w wiersz przełącza checkbox i na chwilę lekko podświetla wiersz (`RippleDrawable` / `foreground`, ~150 ms).
  - Checkbox zaznaczony w kolorze akcentu.
- **L2 przy wyłączonym „Show hidden apps”:** zaznaczona aplikacja zostaje na liście do włączenia i wyłączenia opcji albo do
  ponownego otwarcia ekranu.
- **Powrót:** do miejsca otwarcia (twórca zakładek albo szuflada z dialogu D1).
  - Fragment z `OnBackPressedCallback`.
  - Z szuflady: L1/L2 w `SettingsActivity`, otwarte intencją z argumentami, a powrót zamyka aktywność i wraca do szuflady.
- **Robolectric:** zaznaczenie zapisuje model; L2 zachowanie przy „Show hidden apps”; obcięcie nazwy do 50.

### F5 `Settings: the tab creator`
- Fragment `DrawerTabsFragment` (wejście z F1), styl ustawień.
- **Kategoria „Tabs”:**
  - lista jak `BarOrderDialog` (`item_bar_order.xml`, `ItemTouchHelper`, `bar_order_tile`, `ic_drag_handle`);
  - przy nagłówku kategorii po prawej, góra do góry z tytułem: przycisk „+” — kafelek `bar_order_tile` w rozmiarze uchwytu
    (40 dp), biały krzyżyk (nowy wektor `ic_add_tile`).
- **Wiersz zakładki głównej:**
  - kafelek z „*” zajmującym obszar trzech pasków (tekst biały, pogrubiony, rozmiar = wysokość ikony uchwytu);
  - nazwa (marquee przy długiej);
  - po prawej zębatka (wektor `ic_settings_gear`) → D1;
  - nie da się jej przeciągnąć poza pierwsze miejsce ani usunąć.
- **Wiersz zakładki dodatkowej:**
  - uchwyt z trzema paskami, nazwa (marquee);
  - po prawej kosz (`ic_delete`) → dialog `delete_drawer_tab_title` / `delete_drawer_tab_message` (Cancel / Delete);
  - skrajnie po prawej zębatka → D1.
- **Wyrównanie:** uchwyt, początek nazwy i zębatka licują w pionie między wierszami; marginesy boczne i odstępy jak w
  ustawieniach (16 dp).
- **D2 „Add drawer tab”** (z „+”):
  - pole nazwy z podpowiedzią;
  - „Keep apps in main app tab” z checkboxem (tekst i checkbox działają tak samo);
  - Cancel / OK; OK dodaje zakładkę z nazwą (pusta nazwa nic nie dodaje).
- **D1 „Edit drawer tab”:**
  - pole z bieżącą nazwą;
  - „Keep apps in main app tab” z checkboxem; dla głównej brak;
  - po lewej „Select apps” (dodatkowe) → L1, a dla głównej „Hide apps” → L2;
  - po prawej Cancel i OK; OK zapisuje nazwę (pusta = bez zmiany);
  - dismiss w inny sposób (tło, back) = Cancel.
  - D1 jest wspólną klasą `DrawerTabDialogs`, używaną też w szufladzie (F6).
- **Kategoria „Miscellaneous”:**
  - **`drawer_tabs_repeat`:** lista trzech opcji; opis = wybór, a pod nim w osobnych liniach
    `drawer_tabs_keep_line` dla zakładek z `keepInMain`;
  - **`drawer_tab_bar_position`** „Tab bar placement”: `top` (domyślnie) / `bottom`.
- **Robolectric:** dodanie, zmiana nazwy, usunięcie z potwierdzeniem, przeciągnięcie kolejności, główna stoi pierwsza.

### F6 `App drawer: tabs`
- **Pasek zakładek w szufladzie** (`DrawerTabStrip`), gdy zakładek ≥ 2:
  - nad lub pod aplikacjami wg `drawer_tab_bar_position`;
  - wysokość 14% krótszego boku ekranu;
  - szara linia 1 dp (`settings_divider`) na całą szerokość ekranu między paskiem a aplikacjami.
- **Zakładka wybrana:** nazwa w akcencie, pogrubiona; pasek podkreślenia 2 dp (2× szara linia):
  - pasek na górze: dół podkreślenia = dół szarej linii;
  - pasek na dole: góra podkreślenia = góra linii, a podkreślenie i linia są nad nazwami;
  - szerokość = 80% szerokości zakładki, wyśrodkowane.
- **Niewybrana:** biała, bez pogrubienia i podkreślenia.
- **Podkreślenie przesuwa się płynnie** (`ValueAnimator` 200 ms, interpolacja pozycji i szerokości; przy przeciąganiu stron
  podąża za ułamkiem przesunięcia).
- **Widoczne:** maks. 2 zakładki w pionie, 4 w poziomie (szerokość zakładki = szerokość paska / 2 lub 4); więcej =
  przewijanie paska w poziomie (`HorizontalScrollView`). Samo przewijanie nie zmienia wyboru, klik zmienia.
- **Nazwa dłuższa niż miejsce:** marquee.
- **Przesuwanie ekranów w poziomie:**
  - tryb pionowy: gest w poziomie na liście (fling lub > 25% szerokości) zmienia zakładkę w stronę gestu; lista podąża
    animacją, podkreślenie też; pasek przewija się, żeby wybrana była widoczna;
  - tryb poziomy: następna zakładka dopiero po końcu stron bieżącej, w obie strony (`AppsCustomizePagedView`: przeciągnięcie
    poza ostatnią / pierwszą stronę → zmiana zakładki i strona pierwsza / ostatnia).
- **Klik na zakładkę niewybraną** wybiera ją; klik na wybraną otwiera D1 (z F5).
- **Treść zakładki** = `DrawerTabs.appsOf(tab)`; ukryte nigdy; wyszukiwanie (F3) w bieżącej zakładce.
- **Przy jednej zakładce** pasek nie istnieje, a szuflada wygląda jak bez zakładek.
- **Robolectric:** klik zmienia zakładkę i treść; swipe w trybie pionowym zmienia zakładkę; pozycja podkreślenia.

---

## G. Lista widżetów (pkt 9)

### G1 `Widgets: a list of apps with their widgets and shortcuts, with search`
- **Treść `Widgets`:** zamiast stron `PagedViewGridLayout` widok `WidgetsListView` (`RecyclerView`) w tym samym
  `apps_customize_pane.xml`.
- **Dane:** `mWidgets` z `AppsCustomizePagedView.onPackagesUpdated` (już przefiltrowane), grupowane wg pakietu.
  - Czysta klasa `WidgetGroups` (test): grupowanie, kolejność alfabetyczna wg nazwy aplikacji (`Collator`), liczenie
    widżetów i skrótów, filtr wyszukiwania po nazwie aplikacji i widżetu.
- **Wiersz aplikacji** (wysokość 17% krótszego boku):
  - ikona aplikacji po lewej;
  - obok dwie linie: nazwa aplikacji; liczba „1 widget, 3 shortcuts” (plurals `widget_count`, `shortcut_count` łączone
    przecinkiem, pomijane zera);
  - po prawej „⌃” rozwinięty / „⌄” zwinięty (wektory);
  - klik zwija lub rozwija; rozwinięty jest najwyżej jeden (rozwinięcie zwija poprzedni).
- **Rozwinięty wiersz:**
  - widżety jeden pod drugim, wyśrodkowane, w kolumnie na całą szerokość;
  - podgląd skalowany do maks. 70% szerokości i 40% wysokości ekranu, z zachowaniem proporcji;
  - pod podglądem, każde wyśrodkowane w osobnej linii i tylko gdy jest: nazwa (`info.label`), rozmiar (`%1$d × %2$d` z
    `Launcher.getSpanForWidget`), opis (`AppWidgetProviderInfo.loadDescription(ctx)`, API 31+);
  - pod widżetami skróty w rzędach na całą szerokość, maks. 3 w pionie i 6 w poziomie, rozłożone równo; ikona, nazwa,
    „Shortcut” w kolorze akcentu.
- **Przeciąganie bez nowej drogi:** każdy widżet i skrót w rozwinięciu to `PagedViewWidget`
  (`res/layout/apps_customize_widget.xml`) z tagiem `PendingAddWidgetInfo` / `PendingAddShortcutInfo`, tak jak w
  `syncWidgetPageItems` (1301-1399).
  - Długie przytrzymanie i krótkie naciśnięcie obsługuje `AppsCustomizePagedView` (`setOnLongClickListener`,
    `setShortPressListener`): `onShortPress` → `preloadWidget`, `beginDraggingWidget`.
  - Upuszczenie jak dziś.
- **Podglądy:** `WidgetPreviewLoader.getPreview` poza wątkiem głównym (zasada z rundy 25, KI-46) — `AsyncTask`/`Executor`
  jak `prepareLoadWidgetPreviewsTask`; wynik nakładany na widok, jeśli nadal ten sam.
- **Nad listą pasek wyszukiwania** jak F3, podpowiedź `search_widgets_hint` „Search widgets”; zawsze widoczny.
- **Szybkie przewijanie** z literą: `LetterScroller` z F2.
- **Wygląd:** tło systemowe jak dziś (przyciemnienie przez `Workspace`), kolory ustawień, zaokrąglone karty wierszy (12 dp),
  nowocześnie.
- **Robolectric:** grupy i liczby; rozwinięcie jednego zwija drugi; filtr.

---

## H. Plakietki powiadomień (pkt 15)

### H1 `Badges: notification counts on the icons`
- **`NotificationListener.kt`** (celowana edycja):
  - `onListenerConnected` → pełne `activeNotifications`;
  - `onNotificationPosted` / `onNotificationRemoved` → `BadgeCounts`.
- **Czysta klasa `BadgeCounts`** (test):
  - liczba na pakiet = suma `notification.number` (> 0) albo 1 na powiadomienie;
  - pomijane: `FLAG_GROUP_SUMMARY`, trwałe (`FLAG_ONGOING_EVENT`, `FLAG_FOREGROUND_SERVICE`), kanały bez plakietki
    (`Ranking.canShowBadge() == false`).
- **`BadgeModel`:** singleton, zdarzenia na wątek główny, odbiorcy dostają zbiór zmienionych pakietów.
- **`BadgeDrawer`** (android): rysuje plakietkę w rogu prostokąta ikony wg ustawień z H2.
  - Kolor cyfry i obrysu: na ekranie głównym, w folderach i na paskach = kolor tekstu ikon ekranu głównego (D1); w szufladzie
    = kolor tekstu szuflady (F1).
  - Tło = kolor plakietek (H2, domyślnie akcent).
  - Liczba > 99 → „99+”.
- **Gdzie:**
  - `BubbleTextView.draw` (ekran główny, foldery: zawartość; ikona folderu = suma pakietów w folderze);
  - `PagedViewIcon.draw` (szuflada pozioma i pionowa);
  - ikony pasków (`BarIconImage`, adaptery `AppListAdapter` / `VerticalAppListAdapter`: nakładka `getOverlay()` albo rysowanie
    w widoku).
- **Odświeżanie:** tylko widoki zmienionych pakietów (`Launcher.onBadgesChanged(Set<String>)`: strony, paski
  `notifyItemChanged`, widoczne ikony szuflady).
- **Uprawnienie:** dostęp do powiadomień już jest w `LauncherPermissionFlow` (krok `NOTIFICATION_ACCESS`).
- **Plakietki wyłączone** (H2): nic nie jest rysowane ani liczone (listener nie zapisuje).
- **Robolectric:** ikona z liczbą 4 rysuje plakietkę w rogu; bez plakietki przy wyłączonej opcji.

### H2 `Settings: "Notification badges"`
- **Wiersz** `notification_badges` „Notification badges” w „Launcher settings” → „Miscellaneous”, **nad**
  `wallpaper_picker`; przejście do ekranu `NotificationBadgesFragment` (`res/xml/badge_preferences.xml`).
- Ekran ma jedną kategorię „Notification badges”, kolejno:
  1. **`badges_enabled`** „Enable notification badges” (domyślnie true). Wyłączony: wszystko niżej `setEnabled(false)`
     (wyszarzone, nieaktywne, widoczne).
  2. **Podgląd** (`BadgePreviewPreference`):
     - ikona launchera (`@mipmap/ic_launcher_home`) w rozmiarze ikony ekranu głównego (`DeviceProfile.iconSizePx`), bez nazwy,
       wyśrodkowana;
     - `preference_separator_within` nad i pod;
     - plakietka z „4”;
     - każda zmiana niżej i koloru tekstu ikon (D1) widoczna od razu (`OnSharedPreferenceChangeListener`).
  3. **`badges_position`** „Position”: `top_left`, `top_right` (domyślnie), `bottom_left`, `bottom_right`; opis = wybór.
  4. **`badges_size`** „Size”: `small` (1/5 wysokości ikony), `medium` (1/4, domyślnie), `large` (1/3). Liczone dla rozmiaru
     ikony w miejscu, gdzie leży (paski mają inne).
  5. **`badges_corner`** „Corner radius”: tytuł, a pod nim suwak 0–100, domyślnie 50; 0 = kwadrat, 100 = koło (promień =
     połowa wysokości).
  6. **`badges_color`** „Badge color”: okno koloru, „Default” = akcent (C1); tag `TAG_BADGE` w `ColorPickerTargets`.
  7. **`badges_outline`** „Outline” (domyślnie false): subtelny obrys 1 dp w kolorze cyfry; opisy on/off.
- **Czysta klasa `BadgeGeometry`** (test):
  - wysokość wg rozmiaru; szerokość = max(wysokość, tekst + padding);
  - promień wg suwaka;
  - prostokąt w rogu wewnątrz granic ikony.
- Klucze plakietek nie należą do `CreatorKeys`: działają także przy „Stock layout”.

---

## I. Pozostałe

### I1 `Autostart: BOOT_COMPLETED for "Start on wake" too, the note per device`
- **`ColdStart.runWakeAutostart`:** dla aplikacji z odbiornikiem BOOT_COMPLETED (`hasBootCompletedReceiver`), gdy przełącznik
  `AUTOSTART_APPS_BY_BOOT_COMPLETED` włączony i `canSendBootCompleted()`:
  - `sendBootCompleted(pkg)`, jak przy starcie urządzenia;
  - inaczej aktywność startowa;
  - Display Media Titles i JamesDSP: `wake…(pkg, true)` jak przy starcie.
- Komentarz `:341` poprawiony.
- **Opis przełącznika:** nowy `autostart_apps_by_boot_completed_summary`.
- **Opis „Start on boot” z kodu** (`SettingsFragmentFirst`): `isFytDevice()` → `autostart_apps_summary_fyt`, inaczej
  `autostart_apps_summary_other`. Stary `autostart_apps_summary` i `android:summary` w XML usunięte.
- **Dokumentacja:** D-83 zmieniona (właściciel, 2026-11-25).
- **Test:** `WakeAutostartPlan` / nowa czysta reguła wyboru drogi startu.

### I2 `Strings: "Launcher Mod" and a shorter welcome per device`
- `tv_map_str` (`res/layout-land|port/custom_layout_one.xml`) → trzy nowe klucze wybierane z kodu przy budowie strony stock;
  stary klucz usunięty ze wszystkich plików.
- Wybór urządzenia:
  - `DeviceIdentity.is7870()` → `welcome_7870`;
  - inne FYT → `welcome_fyt`;
  - inne urządzenia → `welcome_other`.
- Teksty EN w §6. Sonnet sprawdza fakty (pinned PiP tylko 7862 — D-34; okna w wersji standard przez root/Shizuku — README)
  i może skrócić, nie wydłużać.

---

## J. Dokumentacja (bez CI)

### J1 `Docs: README for round 28`
- Wszystkie widoczne zmiany rundy w `README.MD` (sekcje: funkcje, pasek, szuflada, widżety, plakietki, ustawienia).
- Suwak: com.syu.music bez przewijania (brak takiej możliwości w aplikacji FYT).
- Android 17 przetestowany na A55.

### J2 `Docs: round 28 in the project library`
- **KNOWN_ISSUES:**
  - nowe KI rundy (watching), od KI-51;
  - KI-33 accepted.
- **DECISIONS:**
  - D-84 logcat kończy o czasie;
  - D-85 „Stock layout” wyłącza całego twórcę;
  - D-86 kolor motywu;
  - D-87 paski bez elementów i reguła podziału;
  - D-88 szuflada (pion domyślnie, wyszukiwanie, zakładki i reguły modelu);
  - D-89 lista widżetów;
  - D-90 plakietki;
  - D-91 gesty i double tap;
  - D-92 widżety swobodne i nakładanie;
  - D-81 i D-83 zmienione.
- **ARCHITECTURE, PROJECT_STATE:** stan rundy.
- **Raport:** sekcja „Round 28” w `claude/reports/implementation_report_2026-11-15.md`: commity, CI, odstępstwa, niesprawdzone.

---

## 6. Napisy (EN; wszystkie do 59 plików, tłumaczone)

| Klucz | EN |
|---|---|
| `theme_accent_color` | Set global theme color |
| `icon_text_color` | Set icon text color |
| `icon_text_size` | Set icon text size |
| `swipe_up_app_drawer` | Swipe up to open the app drawer |
| `swipe_up_app_drawer_on` / `_off` | Swiping up on the home screen opens the app drawer / Swiping up does nothing |
| `swipe_up_app_drawer_required` | Always on while the horizontal bar or its app drawer button is hidden |
| `swipe_down_notifications` | Swipe down for notifications |
| `swipe_down_notifications_on` / `_off` | Swiping down on the home screen opens the notification shade / Swiping down does nothing |
| `swipe_down_notifications_on_fyt` | Swiping down on the home screen opens the quick settings panel |
| `double_tap_action` | Double-tap action |
| `double_tap_none` / `_lock` / `_screen_off` | None / Lock screen / Turn off screen |
| `double_tap_screen_off_hint` | Double-tap the screen again to turn it back on |
| `double_tap_needs_accessibility` | To lock the screen with a double tap, turn on the launcher's accessibility service. |
| `choose_folders_background` | Choose background for folders |
| `folder_follow_grid` | Follow home screen grid inside folders |
| `folder_follow_grid_on` / `_off` | Folders arrange icons in the home screen's rows and columns / Folders use their own grid |
| `widget_freeform` | Free widget placement |
| `widget_freeform_on` / `_off` | Widgets can be moved and resized freely, independent of the grid / Widgets snap to the home screen grid |
| `widget_overlap` | Allow widgets to overlap |
| `widget_overlap_on` / `_off` | Widgets may cover icons and other widgets / Widgets keep to free cells |
| `widget_overlap_off_title` | Fit widgets to the grid? |
| `widget_overlap_off_message` | Some widgets may not fit the grid. Widgets that cannot be placed will be removed from the home screen. |
| `display_horizontal_bar` | Display horizontal bar |
| `display_vertical_bar` | Display vertical bar |
| `horizontal_bar_no_drawer` | Hide the app drawer button |
| `horizontal_bar_no_drawer_on` / `_off` | The bar shows no app drawer button; its room goes to the other elements / The bar shows the app drawer button |
| `widget_bar_no_music` | Hide the music widget |
| `widget_bar_no_music_on` / `_off` | The bar shows no music widget; its room goes to the other elements / The bar shows the music widget |
| `horizontal_bar_turned_off` | The horizontal bar has nothing left to show and was turned off. |
| `all_apps_category` | App drawer |
| `all_apps_search` | Search bar |
| `all_apps_search_on` / `_off` | A search bar is shown above the apps / No search bar |
| `all_apps_scroll` | Scrolling direction |
| `all_apps_scroll_vertical` / `_horizontal` | Vertical / Horizontal |
| `drawer_tabs` | Tabs |
| `drawer_tabs_summary` | Add, rename and arrange the app drawer's tabs |
| `search_apps_hint` | Search applications |
| `search_widgets_hint` | Search widgets |
| `drawer_tab_main` | Apps |
| `drawer_tab_default` | Tab%1$d |
| `edit_drawer_tab` / `add_drawer_tab` | Edit drawer tab / Add drawer tab |
| `drawer_tab_name_hint` | Tab name |
| `keep_in_main_tab` | Keep apps in main app tab |
| `keep_in_main_inactive` | Not applied with the current “Apps in several tabs” setting |
| `select_apps` / `hide_apps` | Select apps / Hide apps |
| `show_hidden_apps` | Show hidden apps |
| `delete_drawer_tab_title` | Delete tab? |
| `delete_drawer_tab_message` | “%1$s” will be deleted. Its apps return to the main tab unless they are in another tab. |
| `delete_drawer_tab_button` | Delete |
| `drawer_tabs_category` | Tabs |
| `drawer_tabs_repeat` | Apps in several tabs |
| `drawer_tabs_repeat_all` / `_except_main` / `_none` | Allow in all tabs / Allow in all tabs except the main tab / Do not allow |
| `drawer_tabs_keep_line` | “%1$s” also keeps its apps in the main tab |
| `drawer_tab_bar_position` | Tab bar placement |
| `drawer_tab_bar_top` / `_bottom` | Top / Bottom |
| `widget_count` (plurals) | %d widget / %d widgets |
| `shortcut_count` (plurals) | %d shortcut / %d shortcuts |
| `widget_list_shortcut` | Shortcut |
| `notification_badges` | Notification badges |
| `notification_badges_summary` | The number of notifications on app icons |
| `badges_enabled` | Enable notification badges |
| `badges_position` | Position |
| `badges_top_left` / `_top_right` / `_bottom_left` / `_bottom_right` | Top left corner / Top right corner / Bottom left corner / Bottom right corner |
| `badges_size` | Size |
| `badges_small` / `_medium` / `_large` | Small / Medium / Large |
| `badges_corner` | Corner radius |
| `badges_color` | Badge color |
| `badges_outline` | Outline |
| `badges_outline_on` / `_off` | A thin outline in the color of the number / No outline |
| `autostart_apps_summary_fyt` | Apps launched by the system's autostart feature may slow down the launcher's startup. The launcher's built-in option will launch them only after the launcher has completed its cold start. When using this list, remember to disable these apps in the FYT settings and anywhere else they are set to start automatically; otherwise, they will be launched twice. |
| `autostart_apps_summary_other` | Apps launched by the system's autostart feature may slow down the launcher's startup. The launcher's built-in option will launch them only after the launcher has completed its cold start. When using this list, remember to turn off automatic start for these apps anywhere else it is enabled; otherwise, they will be launched twice. |
| `autostart_apps_by_boot_completed_summary` | Applies to “Start on boot” and “Start on wake” |
| `welcome_fyt` | Welcome to Launcher Mod!\nCreate your own layout in the settings to show navigation and other apps in windows on the home screen. If an app keeps opening over the home screen, turn off its window in the settings. |
| `welcome_7870` | Welcome to Launcher Mod!\nCreate your own layout in the settings. Apps can be shown in windows on the home screen where the unit supports it; if one keeps opening over the home screen, turn off its window in the settings. |
| `welcome_other` | Welcome to Launcher Mod!\nCreate your own layout in the settings. Showing apps in windows on the home screen needs root or Shizuku; without them the launcher works as a regular home screen. |

Usuwane po `rg`: `tv_map_str`, `autostart_apps_summary`, `all_apps_textSize_str`, `workspace_textSize_str`, stary tytuł
„Use vertical bar”, `vertical_bar_on`, `vertical_bar_off`, `dt_*_widget`.

## 7. Czego nie zmieniać
- Zachowania przy „Stock layout” poza regułą C3.
- D-67: pasek na każdej stronie stoi.
- Kolejności elementów (`BarOrder`) poza pomijaniem ukrytych.
- Ścieżek mediów 7870 poza suwakiem.
- Listy i czasów „Start on boot”.
- Kluczy preferencji z zapisanymi wartościami.
- Okna koloru poza akcentem.
- Cienkiego `music_progress` (skórki).
- Panelu PiP i `sys.lsec.pip_rect`.

## 8. Ryzyka [A]
- A7 (direct boot): nic w trybie zablokowanym nie może czytać pamięci CE. Robolectric plus log z A55 (z PIN-em i bez).
- D6/D7 (widżety swobodne): największa zmiana modelu. Przy wątpliwości mniej funkcji, nigdy utrata widżetów bez dialogu.
- C1 (akcent): kolory z XML trzeba malować w kodzie; pominięte miejsca do raportu.
- F2–F6 (szuflada): duży zakres; przeciąganie z listy pionowej tylko na urządzeniu.
- D3: komenda `C_BLACKSCREEN` na 7870 nieznana; `screenBrightness = 0` na niektórych telefonach nie gasi podświetlenia całkiem.
- D2: `expandNotificationsPanel` przez refleksję może być zablokowane na Androidzie 17; wtedy droga przez dostępność.
- Napisy tłumaczone maszynowo (KI-23).

## 9. Weryfikacja
- **Każdy commit z kodem:** lokalne testy i oba buildy, zielone CI.
- **Robolectric i JUnit:** jak przy commitach.
- **Release (A3):** nie da się zbudować w sesji; do sprawdzenia przez właściciela.
- **Urządzenia:** listy niżej.

## 10. Listy dla właściciela (pkt 25)

**1. Do sprawdzenia (A55 i 7862; 7870 osobno w `claude/checks/7870.md`)**
- **A55, runda 27 (bez wyniku):**
  - suwak: aplikacja strumieniowa przewija, aplikacja bez przewijania pokazuje postęp, live YouTube pusty;
  - „Start on wake”: 1–2 aplikacje, sen i wybudzenie; „Start on boot” po restarcie.
- **A55, runda 28:**
  - crashe (A1–A3, w tym ustawienia w wersji release), pasek pionowy przy swipe (A4);
  - okno statystyk nad ustawieniami tuż po restarcie (A5), stop logcatu po restarcie (A6);
  - czarne okno przed i po odblokowaniu, z PIN-em i bez (A7);
  - suwak: kolor, środek, dotyk, obszar (B1, B2);
  - kolor motywu i przełączniki (C1, C2), „Stock layout” (C3);
  - kolor tekstu ikon, gesty, double tap: blokada, wyłączenie i włączenie double tapem (D1–D3);
  - foldery (D4, D5), widżety swobodne i nakładanie z dialogiem (D6, D7);
  - paski B1–B3 i podział miejsca (E);
  - szuflada: pion, litery, wyszukiwanie, zakładki, twórca, listy (F);
  - lista widżetów (G), plakietki (H), BOOT_COMPLETED przy wybudzeniu (I1), powitanie (I2).
- **7862, runda 28:**
  - double tap „Turn off screen” = kafelek (`U_BLACK_SCREEN`), powrót double tapem;
  - swipe down = panel szybkiego wyboru;
  - suwak com.syu.music bez uchwytu, inne źródła z sesją, wygląd z wyższym rzędem (runda 27);
  - paski, szuflada, lista widżetów, plakietki, „Stock layout”;
  - linia logu A7 (start bez zmian).
- **Starsze otwarte:**
  - KI-22: klawiatura z pinned PiP na 7862;
  - KI-37: log, jeśli widżet znów wejdzie na ikony; KI-28: log, jeśli wczytanie stoi 30 s;
  - KI-44: jednostka, której sprawdzenie kodów czeka na jazdę;
  - P-11: wybudzenie po długim śnie;
  - P-3 / KI-04: Baseline Profile przed wydaniem (Ty);
  - P-5: Android 8–10 przez hosta.

**2. Jeszcze niewdrożone**
- P-2 wydanie 1.2.2 (po P-3).
- P-6 dzień/noc przypięte do wyświetlaczy PiP.
- P-7 skórki FYT w wersji standard.
- P-9 build dla ROM-ów z własnym kluczem.
- P-10 Shizuku Next i stan „stopped” Display Media Titles.
- KI-17 lint, KI-23 przegląd tłumaczeń, KI-26 cztery obserwacje z przeglądu, KI-31 StrictMode z frameworka.
- KI-11 / P-8 ciężki zimny start, KI-07 rozmiar repozytorium.
- Niemożliwe bez zmian systemu FYT:
  - KI-15 pinned PiP podążający za stronami;
  - przewijanie com.syu.music (pkt 2).

**3. Sugerowane (pamięć i szybkość) [A: zmierzyć przed wdrożeniem]**
1. Stan w polach zamiast odczytu preferencji przy każdym ruchu palca (częściowo A2).
2. Pamięć podglądów widżetów i ikon: `LruCache` liczony w bajtach, czyszczony w `onTrimMemory`.
3. Tapeta w wyborze tła i trybie nocnym dekodowana do rozmiaru ekranu (`inSampleSize`).
4. Przy szufladzie pionowej (F2) domyślnej: strony `AppsCustomizePagedView` tworzone dopiero w trybie poziomym.
5. Pomiar `largeHeap` (`config_largeHeap`): mniejsza sterta = krótsze pauzy GC.
6. Rozmiar APK: ile klas `Callback_*` / `com.syu.ui` zostaje po R8; nieużywane wyłączyć z buildu.
7. Logcat: duże bufory startowe tylko przy włączonym „boot log” (częściowo jest).
8. Świeży Baseline Profile (P-3): największy zysk dla startu bez zmiany kodu.

## 11. Po zatwierdzeniu (Opus, w tym czacie, commity dokumentacji bez CI)
1. **`Docs: round 27 results and the 7870 checks`:**
   - KI-46 zamknięte; KI-50: com.syu.music [V];
   - D-77/D-78 potwierdzone; Android 17 na A55;
   - nowy `claude/checks/7870.md`: KI-48, KI-29, runda 26 i 28 na 7870 (double tap `C_BLACKSCREEN`, suwak plików, kolor i
     dotyk suwaka);
   - plan rundy 27 (z transkryptu tej sesji) do `claude/prompts/archive/plan-2026-11-22-round-27.md` z wierszem w katalogu;
   - PROJECT_STATE.
2. **`Docs: brief for round 28`:** ten plan jako `claude/prompts/active/sonnet-prompt-2026-11-25-round-28.md`, wiersz w
   katalogu.
3. **Push** obu. Brief jako plik do pobrania i trzy listy w czacie.
