# Launcher Mod: widget muzyki, jasność nocna, moduł canbus, klucz OpenWeather — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz` (najpierw `git pull origin ccr-087eed00-gbqsuz`). Wprowadź zmiany opisane niżej, każdą jako osobny commit, i wypchnij je na tę gałąź. **Nie twórz pull requesta.**

Ta runda następuje po poprzedniej (`docs/sonnet-prompt-2026-10-27.md`, commity `66961f2`…`22bb4f9`). Jej zmian nie cofaj i nie powtarzaj. Właściciel sprawdził je na FYT 7862: działa bez zmian, tak jak miało być. Numery linii poniżej to stan z 27-10-2026 (commit `22bb4f9`) i są orientacyjne. Zawsze sprawdzaj je w kodzie.

## 0. Urządzenia i najważniejsza zasada

| Urządzenie | Android | Wariant | Uprawnienia | Uwagi |
|---|---|---|---|---|
| FYT 7862 | 10 | `fyt`, aplikacja systemowa | system | działa; jasność nocna ma zostać **0** |
| FYT UNISOC 7870 (`uis7870sc_2h10_nosec`) | 13 | `standard`, debug | Shizuku przez bezprzewodowe ADB | odtwarzacz stockowy `com.syu.media` (`StockSources.isSyuMediaUnit()`) |
| Xiaomi Redmi Note 8T | 14 | `standard` | root (moduł VDHost) | telefon, jasność przez `Settings.System` |
| Samsung Galaxy A55 | 16 | `standard` | Shizuku Next | telefon, jasność przez `Settings.System` |

Zmiany w widgecie muzyki dotyczą **wszystkich** urządzeń, bo o to prosi tester. Pozostałe zmiany (jasność, canbus, log) mają działać tylko tam, gdzie opisano. Na 7862 poza widgetem muzyki wszystko ma zostać identyczne. Każdą zmianę, która dotyka 7862, uzasadnij w treści commita.

## 1. Zasady pracy i konwencje repo (jak w poprzedniej rundzie)

- **Komentarze i commity po angielsku**, w stylu otaczającego kodu: pełne zdania, wyjaśniają *dlaczego*. Gęstość komentarzy jak w sąsiednim kodzie.
- **Commity**: temat w trybie rozkazującym `<Obszar>: <co>`, treść zawinięta na ~72 znaki. Zakończ dokładnie trailerami z system-remindera sesji. **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Jeden commit = jedna logiczna zmiana** (lista w §3, w tej kolejności). Push: `git push -u origin ccr-087eed00-gbqsuz` (przy błędzie sieci ponów 4× z odstępem 2/4/8/16 s).
- **Nie ruszaj commita `57e3600 [BRANCH-ONLY] CI: …` ani pliku `.github/workflows/build.yml`.** Ten commit zostanie wycięty przed PR na `main`, więc nic nie może od niego zależeć.
- **Logowanie**: `android.util.Log` z `private static final String TAG`. Rutynowe zdarzenia na `I`/`D`.
- **StrictMode** (debug): nic z dysku ani sieci na wątku głównym. Na wątku głównym nie wołaj `PackageManager` i binderów.
- **Testy**: JUnit 5 na JVM (`app/src/test/java`, `unitTests.isReturnDefaultValues = true`). Logikę decyzyjną wydziel do **czystych metod statycznych** w klasach **bez zależności od Androida** (ani `View`, ani `Context` w polach statycznych) i przetestuj ją.
- **Bez nowych zależności.** Nie zmieniaj schematu baz.
- **Stringi**: nie dodawaj nowych zasobów `strings.xml` (repo ma wyrównane tłumaczenia). Wyjątek opisany w D1: wartość angielska `music_author`. Teksty stałe (`"Live"`, myślnik) trzymaj jako stałe w kodzie, jak dotąd `"Live"`.
- **Budowanie**: w kontenerze zwykle nie ma Android SDK. CI (`.github/workflows/build.yml`) przy każdym pushu uruchamia `:app:testFytDebugUnitTest`, `:app:assembleFytDebug` i `:app:assembleStandardDebug`. Workflow ma `concurrency: cancel-in-progress`, więc szybki kolejny push anuluje poprzedni run. Sprawdzaj wynik runu **ostatniego** commita: narzędziami GitHub MCP (`actions_list`, `get_job_logs`) albo anonimowo `curl -s "https://api.github.com/repos/vasyl91/FYT-Launcher-Mod/actions/runs?branch=ccr-087eed00-gbqsuz&per_page=1"` (działa przez proxy). Czerwoną budowę naprawiaj od razu.
- **Kontrola bez SDK**: klasy bez zależności od androidx da się skompilować lokalnie: `javac -proc:none -cp android_jar/android-36.jar -d <katalog tymczasowy> <pliki>`. Do klas z `com.android.launcher66` zrób w katalogu tymczasowym (nie w repo) minimalne stuby (`LauncherApplication`, `R` itd.). Kompilacja z `-cp android_jar/android-36.jar` łapie błędy typów, których sama analiza składni nie widzi. Uwaga: ten jar zawiera też API ukryte, więc niczego, co nie jest w publicznym SDK, nie zakładaj tylko dlatego, że się kompiluje.

## 2. Ustalone fakty (z kodu)

### 2.1 Gdzie są widgety muzyki
Wszystkie widoki widgetu muzyki obsługuje jedna klasa: `app/src/main/java/com/android/launcher66/LauncherMusicWidget.java` (1511 linii). Pola:
- widget na pulpicie: `tvMusicName`, `tvAritst` (sic), `ivALbumBg`, `musicProgress`, przyciski `mMusicPrevButton`/`mPlayPauseButton`/`mMusicNextButton`/`mMusicFavoriteButton` oraz komórki `prevLayout`/`playPauseLayout`/`nextLayout`/`favoriteLayout` (typ `ConstraintLayout`, ≈151–157);
- widget paska dolnego: te same z sufiksem `Two`.

Układy widgetu na pulpicie (identyczna struktura: `FlexboxLayout` kolumnowy z `flexWrap="wrap"`):
1. `res/layout/absolute_music.xml`: układ użytkownika (`Keys.USER_LAYOUT`). Pozycję i rozmiar ustawia użytkownik w kreatorze (`musicTopLeftX`… w `CellLayout.addCustomWidgetToGrid`, ≈4405–4420). Pompuje go `CellLayout` (≈4359), a inicjalizuje `CellLayout` ≈4538 (`initMusicWidgetView`, `bindMusicWidgetOnclickListener`, `preSetMusicWidgets`).
2. `res/layout-land/custom_layout_one.xml` i `res/layout-port/custom_layout_one.xml`, blok `@+id/rl_music` (≈114–255): układ domyślny. Land: 0.33 × 0.5545 ekranu. Port: 0.8795 × 0.29, czyli szeroki i niski. Inicjalizacja: `Workspace` ≈989–997.

Układ widgetu paska: blok `@+id/rl_music_two` (`FlexboxLayout` wierszowy: okładka 25% + kolumna 70%; w kolumnie teksty 50% i przyciski 45%) w czterech plikach: `res/layout-{land,port}/custom_layout_two_user{,_left}.xml`. Wersje `_left` mają ten blok identyczny z wersjami bez `_left`. Pasek auto-hide (overlay) pompuje `custom_layout_two_user` drugi raz (`Workspace` ≈1681) i wywołuje `initMusicBarView` (≈1788). `initMusicBarView` zawsze trzyma referencje do **ostatnio** zainicjalizowanego paska. `Workspace.forceOriginalSizesLayoutTwo` (≈1996–2010) ustawia `rl_music_two` w overlayu na `ConstraintLayout.LayoutParams` (szerokość, wysokość = wysokość paska).

Rozmiary tekstu dziś:
- pulpit: `Launcher.textSizeTitle = calculateAdaptiveTextSize(orientationDimension, 22)` i `textSizeArtist = …16` (`Launcher.java` ≈1884). Zależą od wielkości **ekranu**, nie widgetu. Ustawiają je `CellLayout.setCalculatedTextSizeAndColor` (≈4418–4419, również kolor czarny przy `Keys.BLACK_WIDGETS`) i `Workspace` ≈989–992 (układ domyślny). Dlatego artysta ma zawsze mniejszą czcionkę. Przy małym widgecie `flexWrap="wrap"` przenosi wiersze do drugiej, niewidocznej kolumny, i stąd „nie zawsze wszystko wyświetla”.
- pasek: `Workspace.setWidgetBarTextView` (≈1059) → `adjustTextSize(…, 1.0f)` → `fitBarText` (≈1187). Dopasowuje wysokość do rodzica podzielonej przez liczbę `TextView` w rodzicu, a liczy **także niewidoczne** (≈1209–1215). Mechanizm `mBarTextFits`, `verifyWidgetBarText`, `refreshWidgetBarAfterWake` obsługuje też teksty pogody (`weather_city1`, `weather_weather1`, `weather_temp1`) i **tych nie ruszaj**.

### 2.2 Skąd jest „Live”
`LauncherMusicWidget.refreshMusic.onRefresh` (≈160–447), gałąź `"true".equals(mLauncher.state)`, ≈378–390:
```java
if (curProgress == 0 && totalProgress == 0) {
    ...
    String liveLine = StockSources.radioShown() && artist != null && !artist.trim().isEmpty() ? artist : "Live";
    tvAritst.setText(liveLine); tvAritstTwo.setText(liveLine);
}
```
`lngs = {duration, position}` z `NotificationListener.mediaControllerStatus()` (`NotificationListener.kt` ≈1619–1700): `totalMinutes = METADATA_KEY_DURATION`, a przy duration 0 także `curMinutes = 0`. **Każda** aplikacja, która nie podaje długości utworu (radia internetowe, część odtwarzaczy, BT na 7870), dostaje więc w drugim wierszu „Live” zamiast artysty. To jest zgłoszenie testera. Pakiet sesji: `strs[5]` → `activeController` (≈200).

Tytuł i artysta z sesji: `song = METADATA_KEY_TITLE ?: ""`, `artist` = ARTIST → ALBUM_ARTIST → AUTHOR → WRITER → COMPOSER → `" "`. Nie ma fallbacku na `METADATA_KEY_DISPLAY_TITLE` / `METADATA_KEY_DISPLAY_SUBTITLE`, których część aplikacji używa zamiast TITLE/ARTIST. Ta sama kolejność jest w `updateExternalMediaWidgetState` (≈1716).

Wszystkie miejsca, które piszą teksty widgetu (każde trzeba przepiąć w D1):
- `LauncherMusicWidget`: ≈218–237 (brak sesji aplikacji: placeholdery), ≈342–343 (`applyMusicTitle`/`applyMusicArtist`), ≈378–390 („Live”), ≈398–421 (stockowe FYT: `Utils.setTextStr/setTextId`), ≈446–475 (gałąź „nie gra”), `showMusicTitle`/`showMusicArtist` (≈882–913, w tym restart marquee przy zmianie źródła), `preSetMusicWidgets` (≈810–850);
- `Launcher.initViews()` ≈4597–4665 (tytuł ze stockowego `MusicService` i placeholder artysty).

Placeholdery: `R.string.music_name` (EN „Song”) i `R.string.music_author` (EN „Author”, PL „Wykonawca”, 51 plików z tłumaczeniami). `music_author` używają też `com.syu.widget.DateMusicWidget` i `DateRadioWidget` (systemowe AppWidgety; poza zakresem, ale zmiana wartości EN działa także tam).

Radio: `StockSources.radioShown()`. Drugi wiersz to wtedy miejsce strojenia („FM 101.50 MHz”), a przy pustym: „Live”. **Radio zostaje dokładnie tak jak jest.**

Pakiety YouTube w repo: `com.google.android.youtube` i `app.revanced.android.youtube` (`MediaFavoriteController` ≈66–67, prywatne). Do tego dochodzi fork `app.rvx.android.youtube`. YouTube Music (`com.google.android.apps.youtube.music`) **nie** jest YouTube w sensie „Live”.

### 2.3 Wysokość paska dolnego
`Launcher.getBottomBarHeight()` (≈3451) = `BottomBarDimensions.computeBarHeight(prefs, portrait, screenWidth, screenHeight, statusBarHeight)`. To ta sama wartość, której używa `Workspace` (`getBottomBarHeight`, ≈1303) dla paska i overlayu. Domyślnie (bez `Keys.RESIZABLE_BOTTOM_BAR`) w pionie wychodzi `0.142 × szerokość` (14,2% krótszego boku), a w poziomie `0.1638 × (wysokość − status bar)` (~15% krótszego boku). Z `Keys.RESIZABLE_BOTTOM_BAR` użytkownik może pasek zmniejszyć (`BottomBarHeightSeekBarPreference`). `Launcher.screenWidth/screenHeight` są statyczne.

### 2.4 Jasność nocna
`settings/DayNightBrightness.java`: `apply()` (≈145) liczy `value` 0–255 z `Keys.DAY_SEEK_BAR/NIGHT_SEEK_BAR` (`DEFAULT_NIGHT = 0`):
- na FYT `level = round(value × 100 / 255)`, a potem `sendToFyt(level)` na wątku głównym z ponowieniami (`FYT_MAX_RETRIES = 10`, co 1 s);
- poza FYT `writeSystemBrightness(value)` na wątku roboczym.

7870 rozpoznaje `StockSources.isSyuMediaUnit()`. Ustawia to `StockSources.probeDevice()` na osobnym wątku po `StockSources.init` (`LauncherApplication` ≈227); do tego czasu metoda zwraca `false`.

### 2.5 Moduł canbus
`ModuleCallbackCanbusProxy.setCallbackCanbus` (≈20–31) woła `out()` starego i `in()` nowego modułu. Zmiana id canbus (`HandlerCanbus.NTF_CANBUS_ID`) dzieje się bez żadnej ochrony. `update(...)` (≈43) przekazuje dane do modułu z wątku bindera. Analogicznie działa `module/canbus/up/ModuleCallbackCanUpProxy` (≈25). Kod modułów jest dekompilowany (`HandlerCanbus`: „Code decompiled incorrectly”). Po poprzedniej rundzie (`43d89b4`) `Callback_0080_RZC_XP1_QiJun.in()` niczego już nie buduje. `DoorHelper`/`AirHelper` mają UI wykomentowane.

### 2.6 Klucz OpenWeather
`WeatherManager.OPEN_WEATHER_APPID` (≈51) zostaje w źródle (decyzja właściciela: może być publiczny, dopóki działa). URL jest logowany w trzech miejscach. Od commita `771f938` wszystkie przechodzą przez `redactUrl()`, a odpowiedź logowana jest tylko jako długość.

## 3. Commity do wykonania (w tej kolejności)

### D1 — MusicWidget: tytuł i artysta w dwóch wierszach, „Live” tylko dla transmisji na żywo z YouTube
Zgłoszenie testera: drugi wiersz zawiera samo „Live”, pierwszy czasem artystę, czasem tytuł. Ma być: wiersz 1 = tytuł, wiersz 2 = artysta.

1. **Nowa czysta klasa** `app/src/main/java/com/android/launcher66/MusicWidgetText.java` (final, package-private, bez importów `android.*`):
   - `static final Set<String> YOUTUBE_PACKAGES = Set.of("com.google.android.youtube", "app.revanced.android.youtube", "app.rvx.android.youtube");`
   - `static final long LIVE_CONFIRM_MS = 1500L;` Na początku zwykłego filmu YouTube przez chwilę podaje duration 0, więc „Live” pokazuje się dopiero, gdy duration 0 utrzymuje się tyle czasu przy tym samym tytule.
   - `static final String LIVE = "Live";`, `static final String SEPARATOR = " – ";` (spacja, półpauza, spacja), `static final String LIVE_JOIN = " · ";`
   - `static boolean isYoutubeLive(String pkg, long durationMs, long zeroDurationForMs)` = `pkg != null && YOUTUBE_PACKAGES.contains(pkg) && durationMs <= 0 && zeroDurationForMs >= LIVE_CONFIRM_MS`.
   - `static String secondLine(boolean radio, String artist, boolean live)`, gdzie `artist` jest już po `LauncherMusicWidget.normalizeMediaText` (pusty = brak):
     - `radio` → `artist` niepusty ? `artist` : `LIVE` (bez zmian względem dziś);
     - `live` → `artist` niepusty ? `artist + LIVE_JOIN + LIVE` : `LIVE`;
     - w pozostałych przypadkach → `artist` (może być pusty: placeholder dobiera renderowanie, pkt 3).
   - `static String compactLine(String title, String second, String titlePlaceholder)` (tryb jednowierszowy z D2):
     - oba niepuste → `second + SEPARATOR + title`;
     - tylko tytuł → `title`;
     - tylko drugi wiersz → `second`;
     - żaden → `titlePlaceholder`.

     W trybie jednowierszowym **nie** wstawiaj placeholdera artysty, bo „Artist – Song” nic nie mówi.
   - Test `app/src/test/java/com/android/launcher66/MusicWidgetTextTest.java`: wszystkie gałęzie powyżej, w tym granica `LIVE_CONFIRM_MS` (1499 → false, 1500 → true), YouTube Music → nigdy live, `null` pakiet → false, radio z pustym i niepustym artystą.

2. **`R.string.music_author` w `res/values/strings.xml`**: zmień wartość z `Author` na `Artist`, bo tester chce widzieć „Artist”, gdy artysty brak. Tłumaczeń nie ruszaj (PL „Wykonawca” itd. już znaczą „artysta”). Napisz w commicie, że zmiana działa też w AppWidgetach `DateMusicWidget`/`DateRadioWidget`.

3. **Jedno miejsce renderowania w `LauncherMusicWidget`**:
   - Pola `private String mTitle = ""; private String mSecond = "";` (stan widgetu, już znormalizowany) oraz `boolean mHomeCompact, mBarCompact` (ustawia je D2, w D1 zawsze `false`).
   - `void setTrack(String title, String second)` zapisuje pola i woła `render()`.
   - `void render()`: dla pary (pulpit: `tvMusicName`, `tvAritst`) i pary (pasek: `tvMusicNameTwo`, `tvAritstTwo`):
     - tryb zwykły: wiersz 1 = `mTitle` albo `R.string.music_name`, wiersz 2 = `mSecond` albo `R.string.music_author`, wiersz 2 `VISIBLE`;
     - tryb jednowierszowy: wiersz 1 = `MusicWidgetText.compactLine(mTitle, mSecond, getString(R.string.music_name))`, wiersz 2 `GONE`.
     - `setText` tylko gdy tekst się różni (inaczej marquee startuje od początku), `setSelected(true)` na widocznych.
     - Zachowaj obecny trik restartu marquee przy zmianie źródła (`showMusicTitle` ≈889–893: `helpers.returnMediaSourcePre()`/`setMediaSourcePre`).
   - `showMusicTitle(String)` i `showMusicArtist(String)` zostają jako cienkie wrappery (ustawiają odpowiednie pole i `render()`). Dzięki temu `preSetMusicWidgets` i `applyMusic*` działają bez zmian w logice zapisu do preferencji (`saveTitleToPreferences`/`saveArtistToPreferences` zostają, jak są).
   - Przepnij **każde** miejsce z §2.2 na `setTrack`/wrappery. Nie może zostać żaden bezpośredni `setText` na tych czterech `TextView` poza `render()`. Dotyczy to także `Launcher.initViews()` (≈4597–4665): tam wylicz tytuł stockowy tak jak dziś i wywołaj `mMusicWidget.setTrack(title, "")`. Na koniec zrób grep `tvMusicName\|tvAritst` po całym `app/src/main/java`.

4. **„Live” w `onRefresh`** (≈378–390): zamiast `curProgress == 0 && totalProgress == 0 → "Live"`:
   - Śledź `private String mZeroDurationKey; private long mZeroDurationSinceMs;`. Klucz to pakiet + tytuł. Przy `totalProgress <= 0` i tym samym kluczu licz czas od pierwszego zera (`SystemClock.elapsedRealtime()`). Przy `totalProgress > 0` albo zmianie klucza zresetuj licznik.
   - `boolean live = "mediaController".equals(mediaSource) && MusicWidgetText.isYoutubeLive(activeController, totalProgress, zeroFor)`.
   - Gdy pakiet jest YouTube, duration 0, a czas jeszcze < `LIVE_CONFIRM_MS`: zaplanuj **jedno** ponowne rysowanie po brakującym czasie (`mLauncher.mHandler.postDelayed(...)`; Runnable jako pole, `removeCallbacks` przed `postDelayed`). Wywołaj w nim `refreshMusic.onRefresh` z argumentami `mLastRefresh`, tak jak robi to `isId3Read` (≈694–701). Nie licz na to, że YouTube sam przyśle kolejną aktualizację.
   - Drugi wiersz = `MusicWidgetText.secondLine(StockSources.radioShown(), normalizeMediaText(artist), live)`.
   - Na pasek postępu (`musicProgress.setProgress(0)` przy zerach) i czasy nie wpływaj.
   - Gałąź FYT stockowa (`MusicService.author_name`) i gałąź „nie gra” (≈446–475) używają `secondLine(radio, artist, false)`.

5. **Fallback metadanych w `NotificationListener.kt`**: w `mediaControllerStatus()` i w `updateExternalMediaWidgetState`:
   - jeśli `TITLE` jest pusty, użyj `METADATA_KEY_DISPLAY_TITLE`;
   - jeśli cały łańcuch artysty jest pusty, przed `" "` spróbuj `METADATA_KEY_DISPLAY_SUBTITLE`.

   Nie zmieniaj niczego innego w tym pliku: logika „live” w `onPlaybackStateChanged` (≈1528–1545) dotyczy liczników, nie tekstu.

6. Kolejność wierszy: wiersz 1 = tytuł, wiersz 2 = artysta. Nigdzie nie zamieniaj ich miejscami.

7. Treść commita: przyczyna („Live” dla każdej aplikacji bez długości utworu), zasada YouTube + potwierdzenie po 1,5 s, radio bez zmian, placeholder „Artist”. Zachowanie na 7862: odtwarzacz stockowy i radio wyglądają tak jak dziś; aplikacje bez długości utworu pokazują artystę zamiast „Live”.

### D2 — MusicWidget: rozmiar tekstu i przycisków z rozmiaru widgetu, tryb jednowierszowy
Wymagania właściciela:
- (a) dwa wiersze tekstu **tą samą czcionką**, dopasowaną do wielkości widgetu;
- (b) przyciski pod spodem też dopasowane;
- (c) widget paska: gdy wysokość paska ≤ **12% krótszego boku ekranu**, zamiast trzech wierszy (tytuł, artysta, przyciski) są dwa: „artysta – tytuł” i pod spodem przyciski;
- (d) widget pulpitu dostosuj podobnie, bo dziś nie zawsze wszystko się mieści.

1. **Czysty planer** `app/src/main/java/com/android/launcher66/MusicWidgetPlan.java` (final, bez `android.*`). Wszystkie stałe są tutaj, w jednym miejscu, z komentarzem, że to wartości do strojenia po zrzutach od testera:
   ```java
   static final float LINE_FACTOR = 1.3f;          // wysokość wiersza / rozmiar czcionki w px (font metrics + padding)
   static final float BAR_COMPACT_MAX_FRACTION = 0.12f;
   static final float MIN_TEXT_SP = 12f;           // poniżej tego pulpit przechodzi w tryb jednowierszowy
   static final float MIN_TEXT_SP_FLOOR = 8f;      // nigdy mniej (jak BAR_TEXT_MIN_SP w Workspace)
   static final float BUTTON_FILL = 0.8f;          // przycisk = 80% mniejszego boku komórki
   // Pulpit, udziały wysokości (sumują się do 1):
   static final float[] HOME_STANDARD = {0.38f /*okładka*/, 0.13f, 0.13f /*2 wiersze*/, 0.04f /*postęp*/, 0.24f /*przyciski*/, 0.08f /*odstępy*/};
   static final float[] HOME_COMPACT  = {0.44f, 0.17f /*1 wiersz*/, 0.04f, 0.27f, 0.08f};
   static final float[] HOME_NO_COVER = {0.30f /*1 wiersz*/, 0.06f, 0.52f, 0.12f};
   // Pasek, kolumna po prawej od okładki, udziały wysokości:
   static final float[] BAR_STANDARD = {0.25f, 0.25f /*2 wiersze*/, 0.45f /*przyciski*/, 0.05f};
   static final float[] BAR_COMPACT  = {0.42f /*1 wiersz*/, 0.52f, 0.06f};
   ```
   - `static final class Plan { boolean compact; boolean cover; int coverPx; int rowPx; float textPx; int progressPx; int buttonRowPx; int buttonSidePx; int gapPx; }` (pola publiczne w obrębie pakietu, bez getterów; `toString()` do logu).
   - `static boolean barCompact(int barHeightPx, int shortSidePx)` = `shortSidePx > 0 && barHeightPx <= shortSidePx * BAR_COMPACT_MAX_FRACTION`. Porównanie w liczbach całkowitych: `barHeightPx * 100 <= shortSidePx * 12`, bo float 0.12 daje błędy na granicy.
   - `static Plan planHome(int w, int h, float density, float maxTextPx)` (density = `DisplayMetrics.scaledDensity`, czyli px na sp):
     1. Wszystkie udziały licz z obcięciem (`(int)(h × udział)`), nie z zaokrągleniem, żeby suma nigdy nie przekroczyła `h`. Policz wariant STANDARD: `rowPx = (int)(h × 0.13)`, `textPx = min(rowPx / LINE_FACTOR, maxTextPx)`.
     2. Jeśli `textPx < MIN_TEXT_SP × density`, policz COMPACT.
     3. Jeśli i tam `textPx < MIN_TEXT_SP × density`, policz NO_COVER (compact bez okładki).
     4. `textPx` nigdy < `MIN_TEXT_SP_FLOOR × density`.
     5. Okładka: kwadrat `coverPx = min((int)(h × udział), (int)(w × 0.9f))`.
     6. Przyciski: `buttonSidePx = round(min(buttonRowPx, w / 4f) × BUTTON_FILL)`.
     7. `gapPx = (int)(h × udział odstępów / liczba elementów)`; `topMargin = gapPx` przed każdym elementem (STANDARD 5 elementów, COMPACT 4, NO_COVER 3).
   - `static Plan planBar(int w, int h, int barHeightPx, int shortSidePx, float density)`:
     1. `compact = barCompact(barHeightPx, shortSidePx)`.
     2. Okładka: kwadrat `coverPx = min((int)(h × 0.86f), (int)(w × 0.25f))`, a kolumna ma szerokość `w − coverPx − (int)(w × 0.03f)`.
     3. Wiersze i przyciski z `BAR_STANDARD`/`BAR_COMPACT` liczone od `h`.
     4. `textPx = max(rowPx / LINE_FACTOR, MIN_TEXT_SP_FLOOR × density)`, bez górnego limitu (pasek ma wysokość z ustawień).
     5. `buttonSidePx = round(min(buttonRowPx, kolumna / 4f) × BUTTON_FILL)`.
   - Test `MusicWidgetPlanTest`:
     - `barCompact`: krótszy bok 600, pasek 72 → true, 73 → false; krótszy bok 0 → false.
     - Domyślne paski nie są kompaktowe: poziomo 1024×600 ze status barem 40 → `(int)(560 × 0.1638) = 91` → false; pionowo 600×1024 → `(int)(600 × 0.142) = 85` → false.
     - `planHome` (density 1.0, więc 1 sp = 1 px; maxTextPx 22): 338×333 → STANDARD (`rowPx` 43) z `textPx == 22`; 338×100 → STANDARD dałby 13/1,3 = 10 px < 12, więc `compact == true && cover == true` (`rowPx` 17); 338×60 → również COMPACT < 12 px, więc `cover == false` (`rowPx` 18); `textPx` nigdy < 8.
     - `planBar`: `compact` tylko przy ≤ 12%; `buttonSidePx > 0`.
     - W każdym planie suma wysokości wierszy, okładki, postępu, przycisków i odstępów ≤ `h`.

2. **Nowe układy** (ID zachowaj bez zmian, bo kod i `share.ResValue` szukają ich po nazwie).
   - `res/layout/music_widget_content.xml` (`<merge>`), w kolejności z góry:
     - `ImageView @+id/iv_album_bg` (`tag @string/skin_ruleless`, `src @drawable/music_album_def`, `adjustViewBounds="true"`, `scaleType="fitCenter"`, `layout_width/height` = `0dp`, ustawiane w kodzie);
     - `TextView @+id/tv_musicName`;
     - `TextView @+id/tv_artist`. Oba z atrybutami jak dziś: `singleLine`, `ellipsize="marquee"`, `marqueeRepeatLimit="marquee_forever"`, `gravity="center_horizontal"`, kolory `@android:color/white` i `#aaffffff`, `textSize="0sp"`, `layout_width="match_parent"`, `layout_height="wrap_content"`. Domyślny tekst `tv_artist` = `@string/music_author` (dziś omyłkowo `music_name`).
     - `ProgressBar @+id/music_progress` (atrybuty jak dziś, `layout_width="match_parent"`, poziome marginesy 10% ustawiane w kodzie);
     - `LinearLayout @+id/music_buttons` (nowe ID, `orientation="horizontal"`, `layout_width="match_parent"`, `layout_height="0dp"`), w nim 4 komórki `androidx.constraintlayout.widget.ConstraintLayout` (`@+id/constraint_layout_prev`, `_playpause`, `_next`, `_favorite`; `layout_width="0dp"`, `layout_weight="1"`, `layout_height="match_parent"`). W każdej komórce `Button` (`@+id/music_prev`, `music_playpause`, `music_next`, `music_favorite`; tła jak dziś: `btn_ic_prev`, `music_pause_icon`, `btn_ic_next`, `btn_ic_favorite`) z `layout_width="0dp"`, `layout_height="0dp"` i czterema więzami do rodzica. Kwadratowy rozmiar ustawia kod.
   - `res/layout/absolute_music.xml`: korzeń `AbsoluteLayout @+id/absolute_music` bez zmian. W środku zamiast `FlexboxLayout @+id/rl_music` wstaw `LinearLayout @+id/rl_music` (`fill_parent` × `fill_parent`, `orientation="vertical"`, `gravity="center_horizontal"`) z `<include layout="@layout/music_widget_content"/>`.
   - `res/layout-land/custom_layout_one.xml` i `res/layout-port/custom_layout_one.xml`: blok `FlexboxLayout @+id/rl_music` zamień na `LinearLayout @+id/rl_music` (vertical, center_horizontal) z tym samym `include`. **Wszystkie atrybuty `layout_*`/`app:layout_constraint*` tego bloku przepisz bez zmian.**
   - `res/layout/music_bar_content.xml` (`<merge>`):
     - `ImageView @+id/iv_album_bg_two` (atrybuty jak wyżej);
     - `LinearLayout @+id/music_bar_column` (vertical, `layout_width="0dp"`, `layout_weight="1"`, `layout_height="match_parent"`, `gravity="center_vertical"`) z `tv_musicName_two`, `tv_artist_two` (atrybuty jak dziś, `match_parent`/`wrap_content`, domyślny tekst artysty `@string/music_author`) i `LinearLayout @+id/music_bar_buttons` (horizontal, `match_parent` × `0dp`). W nim 4 komórki `ConstraintLayout` (`constraint_layout_prev_two`, `_playpause_two`, `_next_two`, `_favorite_two`) z przyciskami `music_prev_two`, `music_playpause_two`, `music_next_two`, `music_favorite_two`, ułożone jak wyżej.
   - We wszystkich czterech `custom_layout_two_user{,_left}.xml` (land i port): `FlexboxLayout @+id/rl_music_two` zamień na `LinearLayout @+id/rl_music_two` (`orientation="horizontal"`, `gravity="center_vertical"`) z `<include layout="@layout/music_bar_content"/>`. **Atrybuty `layout_*`/`app:layout_constraint*` przepisz bez zmian**, bo `BottomBarDimensions.getXmlSpec`, `applyScaledHeight` i `forceOriginalSizesLayoutTwo` czytają i nadpisują właśnie je.
   - Po zmianie sprawdź grepem, czy żaden kod nie rzutuje tych widoków na `FlexboxLayout` (dziś nie rzutuje; `FlexboxLayout` używa tylko `ColorPicker.kt`) ani nie odwołuje się do dzieci przez indeks.

3. **Klasa wykonawcza** `app/src/main/java/com/android/launcher66/MusicWidgetSizer.java`:
   - `static MusicWidgetSizer attach(View root, boolean bar, Callback cb)`, gdzie `interface Callback { void onCompactChanged(boolean bar, boolean compact); }`. Rejestruje `View.OnLayoutChangeListener` na `root` i od razu `root.post(this::apply)`. Jeśli na tym `root` jest już sizer (trzymaj go w `root.setTag(R.id.music_buttons, sizer)` albo w `WeakHashMap`), podmień go, nie dubluj listenerów.
   - `apply()`: pomiń, gdy `root` nie jest laid out, `w` lub `h` ≤ 0, albo wymiary są przejściowe (pasek: `h < 0.25 × mLauncher.getBottomBarHeight()`, tak jak `BAR_TEXT_MIN_PARENT_FRACTION` w `Workspace`). Pomiń też, gdy `w`, `h`, `compact` i wysokość paska są takie same jak przy ostatnim przeliczeniu. Bez tego ustawianie rozmiarów dzieci wywoła kolejny layout i pętlę.
   - Wymiary wewnętrzne = `getWidth/getHeight` minus padding. `shortSidePx = Math.min(Launcher.screenWidth, Launcher.screenHeight)`. `barHeightPx = launcher.getBottomBarHeight()` (to samo co `Workspace`). `maxTextPx` (pulpit) = `TypedValue.applyDimension(COMPLEX_UNIT_SP, Launcher.textSizeTitle, dm)`, czyli duży widget wygląda jak dziś, a artysta dostaje rozmiar tytułu.
   - Ustawianie rozmiarów:
     - `LinearLayout.LayoutParams.height` (i `width` okładki), `weight = 0` dla okładki, wierszy, paska postępu i rzędu przycisków;
     - `topMargin = gapPx` między nimi;
     - `textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textPx)` **dla obu** `TextView`;
     - `setIncludeFontPadding(true)`;
     - przyciski: `ConstraintLayout.LayoutParams` z `width = height = buttonSidePx`.

     Zmieniaj `LayoutParams` tylko wtedy, gdy wartość naprawdę się różni.
   - W trybie bez okładki ustaw `iv_album_bg` na `GONE`, w pozostałych `VISIBLE`.
   - Przy zmianie `compact` wywołaj `cb.onCompactChanged(...)`. `LauncherMusicWidget` ustawia wtedy `mHomeCompact`/`mBarCompact` i woła `render()` (D1): wiersz 2 `GONE`, wiersz 1 „artysta – tytuł”.
   - Jedna linia `Log.d(TAG, …plan…)` przy zmianie planu, `Log.i` przy przełączeniu trybu jednowierszowego.

4. **Podpięcie i usunięcie starego dopasowania**:
   - `LauncherMusicWidget.initMusicWidgetView(view)`: `View root = view.findViewById(ResValue.getInstance().rl_music)` (dla `absolute_music` to dziecko; dla układu domyślnego `Workspace` podaje sam `rl_music`, a `findViewById` zwraca wtedy jego samego). Następnie `MusicWidgetSizer.attach(root, false, …)`.
   - `initMusicBarView(view)`: `attach(view, true, …)` (to `rl_music_two`, inline albo overlay).
   - Nowe przyciski i komórki mają te same ID, więc `bindMusic*OnclickListener` działa bez zmian.
   - `CellLayout.addCustomWidgetToGrid`, `case "music"` (≈4418–4419): zamiast `setCalculatedTextSizeAndColor(...)` zostaw **tylko kolor** (czarny przy `Keys.BLACK_WIDGETS`). Wydziel `setCalculatedTextColor(view, id)` albo dodaj parametr; rozmiar ustawia sizer.
   - `Workspace` ≈989–992: usuń ustawianie rozmiaru `tv_musicName`/`tv_artist` (zostaw `tv_map`, `date`, `curWeek`).
   - `Workspace.setWidgetBarTextView` (≈1059): usuń `adjustTextSize` dla `tv_musicName_two`/`tv_artist_two`, bo tymi tekstami zarządza teraz sizer. Czarny kolor (`blackTintBar`) zostaw. Pogoda bez zmian. Pola `titleText`/`artistText` zostają tylko do koloru, sprawdź ich użycia (≈371, 2690).
   - Jeśli zostawiasz `fitBarText` dla innych tekstów, zmień liczenie w ≈1209–1215 tak, żeby liczyło tylko `TextView` o `getVisibility() != GONE`. To ścisła poprawa: dziś w tych rodzicach nic nie jest `GONE`.
   - Po wybudzeniu i odbudowie paska (`Workspace.refreshWidgetBarAfterWake`, `verifyWidgetBarText`) wywołaj `apply()` sizerów: dodaj w `LauncherMusicWidget` `void refreshSizes()` (przelicza oba sizery, `force = true`) i wołaj je stamtąd. Zmiana wysokości paska w ustawieniach przebudowuje układ, więc nowy layout sam wywoła listener.
   - Kreatora układu (`settings/CreatorFirstScreen`, `DrawViewFirstScreen`) nie zmieniaj: rysuje prostokąty, nie ten widok.

5. Radio korzysta z tego samego widgetu, więc tryb jednowierszowy dotyczy też jego: „FM 101.50 MHz – Stacja”. Napisz to w commicie.

6. Treść commita: dlaczego artysta był mniejszy (stałe 22/16 sp z rozmiaru ekranu); dlaczego pulpit gubił wiersze (`flexWrap`); progi i stałe; tryb jednowierszowy paska ≤ 12% krótszego boku (domyślne paski 14,2% i ~15%, więc bez `RESIZABLE_BOTTOM_BAR` niczego nie zmienia); pulpit przechodzi w ten tryb, gdy dwa wiersze nie mieszczą się w 12 sp.

### D3 — Jasność nocna: minimum poza FYT 7862
Decyzja właściciela: na FYT 7862 jasność nocna może być 0 (bez zmian). Na pozostałych urządzeniach ma obowiązywać minimum, wartość do mojego wyboru. Wybrane wartości:
- **7870** (FYT z `StockSources.isSyuMediaUnit()`): poziom FYT **≥ 10/100**. Pod poziomem 0 podświetlenie 7870 może zgasnąć zupełnie, a 10% to najniższy poziom, przy którym ekran jest na pewno czytelny w nocy.
- **Telefony** (`!LauncherApplication.isFytDevice()`): `Settings.System.SCREEN_BRIGHTNESS` **≥ 10/255**.
- **Inne FYT bez `com.syu.media`** (7862 i podobne): bez minimum, czyli jak dziś.

1. Czyste metody w `DayNightBrightness`, statyczne i package-private, bez Androida w sygnaturze:
   - `static int floorFytLevel(int level, boolean syuMediaUnit)` = `syuMediaUnit ? max(level, FYT_LEVEL_FLOOR_7870) : level`;
   - `static int floorSystemValue(int value)` = `max(value, SYSTEM_VALUE_FLOOR)`.
   - Stałe `FYT_LEVEL_FLOOR_7870 = 10`, `SYSTEM_VALUE_FLOOR = 10`.
2. FYT: w `sendToFyt` (wątek główny) przed wysłaniem poczekaj, aż `StockSources` zakończy rozpoznawanie urządzenia. Dodaj w `StockSources` `private static volatile boolean sProbed`, ustawiane na końcu `probeDevice()` w `finally`, oraz `public static boolean isProbed()`. Dopóki `!isProbed()` i `attempt < FYT_MAX_RETRIES`, ponawiaj tak samo jak przy braku `tools`. Po wyczerpaniu prób wyślij bez minimum (jak dziś). Dopiero potem `level = floorFytLevel(level, StockSources.isSyuMediaUnit())`.
3. Telefony: `writeSystemBrightness(appContext, floorSystemValue(value))`.
4. W obu przypadkach, gdy minimum podniosło wartość, dopisz do istniejącej linii `Applying … brightness …` informację `(raised to the minimum N of this device)`. Logi są dziś w `apply()`, a poziom FYT liczony jest wcześniej, więc dla FYT dopisz osobną linię `Log.i` w `sendToFyt` tylko wtedy, gdy minimum zadziałało.
5. Nie zmieniaj `DEFAULT_NIGHT`, `BrightnessSeekBarPreference` ani zapisanych preferencji: minimum działa w chwili ustawiania jasności.
6. Test `DayNightBrightnessFloorTest`: 7862 (`syuMediaUnit = false`) poziom 0 → 0; 7870 0 → 10, 50 → 50; telefon 0 → 10, 255 → 255.
7. Treść commita: dlaczego 7862 bez zmian (decyzja właściciela; rozpoznanie po `com.syu.media`); wybrane wartości i dlaczego; czekanie na rozpoznanie urządzenia, żeby 7870 tuż po starcie nie dostał 0.

### D4 — Canbus: moduł nie może zaszkodzić launcherowi, nawet jeśli jest niewłaściwy dla auta
Decyzja właściciela: nie wiadomo, czy `0080_RZC_XP1_QiJun` (id 458832) to właściwy moduł. Niezależnie od tego nie może przeszkadzać w działaniu launchera.

1. `module/canbus/ModuleCallbackCanbusProxy.setCallbackCanbus`: `out()` starego i `in()` nowego modułu wywołuj każde w osobnym `try { … } catch (RuntimeException e)`. Przy wyjątku daj jedno `Log.w(TAG, "canbus module <klasa> failed in in()/out()", e)` na klasę i metodę (zbiór już zalogowanych nazw). Moduł, którego `in()` rzucił, zostaje ustawiony (`mCallback`), bo jego `update()` może dalej działać.
2. Zmierz czas `in()` (`SystemClock.elapsedRealtime()`). Przy ≥ 100 ms daj jedną linię `Log.i`: nazwa klasy modułu, id canbus, czas. Następne logi z 7870 pokażą, czy moduł kosztuje coś przy starcie.
3. `ModuleCallbackCanbusProxy.update(...)`: `callback.update(...)` w `try/catch (RuntimeException)`, jedno `Log.w` na klasę modułu. Wątek bindera nie wywróci procesu, ale zalewałby log.
4. To samo dla `module/canbus/up/ModuleCallbackCanUpProxy` (`in()`/`out()`/`update`).
5. Nie zmieniaj logiki modułów ani `HandlerCanbus.getCallbackCanbusById`.
6. Treść commita: stan po `43d89b4` (parking nie jest budowany, `DoorHelper`/`AirHelper` mają wykomentowane UI), czyli dla `0080_RZC_XP1_QiJun` zostają tylko powiadomienia o danych. Osłona dotyczy każdego modułu. Na 7862 zachowanie jest identyczne, dopóki moduł nie rzuca wyjątku.

### D5 — OpenWeather: klucz nigdy w logach (weryfikacja i test)
Decyzja właściciela: klucz może zostać publiczny w źródle, dopóki działa. Ma tylko nie pojawiać się w logach.

1. Zrób grep po `app/src/main/java`: `OPEN_WEATHER_APPID`, `OPEN_WEATHER_CURRENT_URL`, `appid`, `openweathermap`. Zrób też grep wszystkich `Log.*`/`printStackTrace` w `com/syu/weather/` i w klasach, które wołają `WeatherManager.sendGet`. Każde miejsce, które może wypisać URL zapytania pogodowego (także w komunikacie wyjątku), musi przechodzić przez `redactUrl()`. Stan na `22bb4f9`: trzy miejsca, wszystkie już objęte.
2. Dopisz do `app/src/test/java/com/syu/weather/WeatherManagerRedactTest.java` test z prawdziwą stałą: `redactUrl(WeatherManager.OPEN_WEATHER_CURRENT_URL + "&lat=52.123&lon=16.987")` nie zawiera `WeatherManager.OPEN_WEATHER_APPID`. Taki test pilnuje, żeby przyszła zmiana formatu URL nie odsłoniła klucza.
3. Jeśli grep niczego nowego nie znajdzie, commit zawiera tylko test, a treść mówi wprost, co sprawdzono. Klucza nie przenoś i nie zmieniaj.

## 4. Czego NIE zmieniać
- Radia w widgecie muzyki: jego drugi wiersz (miejsce strojenia, „Live” przy pustym) zostaje bez zmian. Zmienia się tylko rozmiar czcionki i układ (D2).
- AppWidgetów `com.syu.widget.DateMusicWidget`/`DateRadioWidget` poza wartością EN `music_author`.
- Logiki odtwarzania, przycisków, ulubionych (`MediaFavoriteController`), okładek, zapisu do preferencji i przywracania po restarcie.
- Mechanizmu dopasowania tekstów pogody w pasku.
- `DEFAULT_NIGHT`, mapowania 0–255 → 0–100 i zachowania na 7862.
- Pliku `build.yml` i commita `[BRANCH-ONLY]`.

## 5. Weryfikacja
1. Testy JVM: nowe (`MusicWidgetTextTest`, `MusicWidgetPlanTest`, `DayNightBrightnessFloorTest`, rozszerzony `WeatherManagerRedactTest`) i wszystkie istniejące są zielone (`:app:testFytDebugUnitTest` w CI).
2. CI `Build` zielone na ostatnim commicie (obie wersje debug).
3. Przegląd własnego diffu:
   - żaden bezpośredni `setText` na tekstach widgetu poza `render()`;
   - żaden sizer bez ochrony przed pętlą layoutu;
   - ID z `share/ResValue.java` (`tv_musicName`, `tv_artist`, `tv_musicName_two`, `tv_artist_two`, `iv_album_bg`, `iv_album_bg_two`, `rl_music`, `rl_music_two`, `music_prev`…`music_favorite_two`, `music_progress`) istnieją we wszystkich nowych układach;
   - typy pól w `LauncherMusicWidget` (`ConstraintLayout` dla komórek, `Button`, `ProgressBar`) zgadzają się z XML;
   - ten sam efekt w overlayu auto-hide.
4. Scenariusze dla testera (spisz w raporcie):
   - (a) YouTube: zwykły film, potem transmisja na żywo. W drugim wierszu kanał, a „Live” tylko przy transmisji.
   - (b) Spotify, YT Music, radio internetowe bez długości utworu: tytuł w wierszu 1, artysta albo „Artist” w wierszu 2, nigdy „Live”.
   - (c) Radio FYT: jak dotąd.
   - (d) Ustawienia → pasek dolny: zmniejszyć wysokość poniżej 12%. Widget paska pokazuje „artysta – tytuł” i przyciski, przyciski są kwadratowe i mieszczą się w pasku.
   - (e) Kreator układu: zmniejszyć widget muzyki na pulpicie. Najpierw maleje czcionka (oba wiersze równo), potem widget przechodzi na jeden wiersz, a przy bardzo małym znika okładka. Przyciski zawsze widoczne.
   - (f) Noc na 7870 i na telefonie: jasność nie spada poniżej minimum; na 7862 nadal 0.
   - (g) W logu nie ma `appid=` z kluczem.

## 6. Raport końcowy (w odpowiedzi, po polsku)
- Lista commitów (hash + temat) i dla każdego punktu D1–D5: zrobione / pominięte, z jednym zdaniem dlaczego.
- Wybrane wartości stałych (`MusicWidgetPlan`, minima jasności) z prośbą o zrzuty ekranu od testera do strojenia.
- Co z zachowania na 7862 się zmieniło (tylko widget muzyki) i dlaczego.
- Pytania do właściciela, jeśli coś zostało niejasne (np. czy w trybie jednowierszowym ma być placeholder artysty).
