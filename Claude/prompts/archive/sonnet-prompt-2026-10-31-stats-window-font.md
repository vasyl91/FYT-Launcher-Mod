# Launcher Mod: czcionka i szerokości okna statystyk: instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Ostatni commit kodu: `5fe28bad` (rampa 3,5 s). Numery linii są orientacyjne (≈).

Pracę dzielisz na **dwa commity** w kolejności **J → F**:
- każdy commit ma swoje testy;
- każdy wypychasz osobno na tę gałąź, dopiero gdy poprzedni run CI jest zielony;
- **nie twórz pull requesta**.

## 0. Skąd te zmiany

### 0.1 Błąd
Duże okno statystyk nadal zmniejsza czcionkę, a przerwa między „Fuel consumption:” a wartością jest za duża.

Przyczyna jest w samym liczeniu czcionki, nie w szerokości okna:
- `StatsWindowSize.requiredWidthPx()` (≈ l. 174) i `CanbusService.fitStatsText()` (≈ l. 1689, `rowWidth` ≈ l. 1712) mierzą najszersze warianty wartości: `WIDEST_PER_100_KM = "188.8"`, czyli „~188.8 L/100km ”, z jednostką w pełnym rozmiarze. Wiersz ma przy tym wypełniać najwyżej 95 % okna (`ROW_FILL`).
- Przy limicie +15 % (commit `71b4dea8`) taki wiersz się nie mieści, więc `fitStatsText` zmniejsza czcionkę wszystkich czterech pól.
- Wiersz to flexbox `space_between` (`res/layout/absolute_stats.xml`): etykieta przy lewej krawędzi, wartość przy prawej. Przy mniejszej czcionce przerwa między nimi rośnie.
- Wcześniejsze +35 % (`fd29a66d`) tylko ukrywało ten błąd.

### 0.2 Czego chce właściciel
1. **Reguła szerokości** dużego i średniego okna. W wierszu ma się zmieścić:
   - etykieta;
   - **dwie spacje** (jedna to zapas na przecinek w spalaniu albo na czwartą cyfrę zasięgu);
   - **trzy cyfry**;
   - **najdłuższa jednostka** danej linii.

   Decyduje dłuższa z dwóch linii. W innych językach linia „Cruising range:” bywa dłuższa niż „Fuel consumption:” (np. bg: „Запас на хода:” wobec „Разход:”).
2. **Jednostki** w dużym i średnim oknie są o 25 % mniejsze niż reszta tekstu.
3. **Średnie okno** stosuje tę samą regułę przerwy co duże, ze swoimi krótkimi etykietami („ C:”, „ R:”).
4. **Małe okno** jest o 5 % węższe niż dziś i **nie pokazuje jednostek wcale**. Dziś pokazują się w nim jednostki z modelu szacunkowego: `instantaneous_consumption_idle_mini` i `_per_hour_mini` mają „L/h”.
5. **Czcionka** jest jedna dla trzech okien i liczona z **małego okna**. Małe okno ma dwie linie, obie bez jednostek:
   - spalanie z tyldą i trzema cyframi, w tym jedną po przecinku: „~88.8”;
   - zasięg: najwyżej 4 cyfry, „8888”.
6. **Szerokości** dużego i średniego okna (i czcionka):
   - liczone raz, przy pierwszym starcie, i zapisywane w SharedPreferences, gdy klucza nie ma;
   - używane i na ekranie głównym (okno w `CanbusService`, rezerwacja komórek w `CellLayout`), i w kreatorze (trzy `DrawView*`).

### 0.3 Decyzje właściciela (pytania zadane przed briefem)
- Czcionka jest **nie większa** niż dzisiejsza standardowa (`Launcher.textSizeBasic`). Małe okno może ją tylko zmniejszyć.
- **Tylda wliczana** do linii spalania w dużym i średnim oknie. Oszacowanie „~18.8 L/100km” nie może przeskoczyć do drugiej linii (w układzie jest `flexWrap="wrap"`).
- **Przeliczenie przy zmianie języka lub ekranu**: zapisany znacznik geometrii. Gdy się zmieni, wartości liczone są od nowa; poza tym raz.

### 0.4 Zasady (jak w poprzednich briefach)
- commity po angielsku, z trailerami sesji, bez nazwy modelu w treści;
- tylko do odczytu: `.github/workflows/*`, `app/src/main/generated/baselineProfiles/`, `decompiled_*/**`, `fuel_stats_example/`;
- arytmetyka `StatsWindowSize` w **czystych** metodach statycznych (liczby na wejściu i wyjściu, bez `android.*`, bez `Paint`), z testami JVM. Pomiar tekstu (`TextPaint`, `Resources`) tylko w cienkiej warstwie z `Context`;
- StrictMode: bez I/O na wątku głównym. SharedPreferences są już wczytane; zapis tylko przez `apply()`;
- czerwony build naprawiaj nowym commitem, bez amend i force-push.

## Etap J: jednostki (commit 1)

Pliki:
- `settings/CanbusService.java`: teksty startowe ≈ l. 785–791, `setFuelBlendedText` ≈ l. 1387, `setFuelText` ≈ l. 1397, `showFuelEstimate` ≈ l. 1418, `mUpdaterDrivingMileage` ≈ l. 1498;
- `settings/StatsWindowSize.java`;
- `res/values*/strings.xml`;
- `StatsWindowSizeTest.java`.

1. **Czysta funkcja w `StatsWindowSize`.**
   - `static final float UNIT_SCALE = 0.75f;`
   - `static int unitStart(String formatted, String number)`: indeks pierwszego znaku **po** liczbie w sformatowanym tekście albo −1, gdy liczby nie ma.
   - Liczbę szukaj przez `indexOf(number)`.
   - Wszystko od `unitStart` do końca to jednostka: separator, jednostka i końcowe `\u0020`, np. „ L/100km ”, „ L/h ”, „ km ”, „ l/100 km ”, „ λ./100 χλμ. ”, „ لتر/100 كم ”.
   - Tylda przed liczbą nie jest jednostką i zostaje w pełnym rozmiarze.
2. **Jeden prywatny helper w `CanbusService`**, np. `private void setValueText(TextView view, @StringRes int resId, String number)`:
   - formatuje `getString(resId, number)`;
   - dla `statsWidthSelector` 0 i 1, gdy `unitStart >= 0` i nie jest końcem tekstu: `SpannableString` z `RelativeSizeSpan(UNIT_SCALE)` od `unitStart` do końca, flaga `SPAN_EXCLUSIVE_EXCLUSIVE`;
   - w przeciwnym razie zwykły tekst;
   - używaj go **wszędzie**, gdzie dziś jest `setText(getString(R.string.…_val…, …))` dla wartości spalania i zasięgu (lista plików wyżej), także dla „-.-” i „0.0” na starcie.
3. **Małe okno (rozmiar 2) bez jednostek**, zawsze:
   - L/100 km: `instantaneous_consumption_val_mini` (jak dziś);
   - L/h od auta (`setFuelText`, gałąź `fuelShownPerHour`): `instantaneous_consumption_val_mini`;
   - oszacowanie w L/100 km i wartość pośrednia (`setFuelBlendedText`): `instantaneous_consumption_estimated_mini` (jak dziś);
   - oszacowanie w L/h (`showFuelEstimate`, `e.perHour`): `instantaneous_consumption_estimated_mini`. Tylda zostaje, żeby było widać, że to oszacowanie;
   - zasięg: `driving_mileage_val_mini` (jak dziś).
4. **Usuń** nieużywane `instantaneous_consumption_idle_mini` i `instantaneous_consumption_per_hour_mini`:
   - z `values/strings.xml` i ze **wszystkich** `values-*/strings.xml` (jest ich 50; skrypt w scratchpadzie, nie w repo);
   - wcześniej `grep -rn` w `app/src`, że nic ich już nie używa;
   - `StatsWindowSize.consumptionVariants()` ich używa: w tym etapie usuń z niego te dwie pozycje dla rozmiaru 2. W etapie F cała metoda i tak zniknie.
5. **`fitStatsText` zostaje w tym etapie bez zmian.** Mierzy jednostki w pełnym rozmiarze, więc liczy zachowawczo. Właściwa poprawka czcionki to etap F.
6. **Testy `StatsWindowSizeTest`**:
   - `unitStart`: „4.5 L/100km ” → 3; „~4.5 L/100km ” → 4; „12 km ” → 2; „~0.9 L/h ” → 4;
   - tekst grecki, arabski (RTL, „%1$s لتر/100 كم ”) i polski (`values-pl`): indeks po liczbie;
   - liczby nie ma → −1;
   - tekst kończy się liczbą („~4.5”) → indeks równy długości (helper wtedy nie nakłada spana).

**Commit:** `Stats window: the units 25 % smaller in the large and medium windows, none in the small one`

## Etap F: jedna czcionka z małego okna, szerokości z najdłuższej linii, zapis w prefs (commit 2)

Pliki:
- `settings/StatsWindowSize.java`;
- `settings/Keys.java`;
- `settings/CanbusService.java`: tworzenie okna ≈ l. 736–800, `fitStatsText`, `rowWidth`;
- `Launcher.java`: `calculateLayoutDimensions()` ≈ l. 1838, wołane ≈ l. 1675 po `mPrefs`;
- `settings/SettingsActivity.java`: `calculateLayoutDimensions()` ≈ l. 237, wołane ≈ l. 180;
- `StatsWindowSizeTest.java`.

Bez zmian (tylko sprawdź):
- `syncSavedRectangle()`;
- `saveStatsPrefs()` w `DrawViewAppStats` ≈ l. 819, `DrawViewFirstScreen` ≈ l. 1222, `DrawViewOtherScreens` ≈ l. 921;
- `CellLayout` ≈ l. 4967.

Oznaczenia:
- `fullWidth` = `Launcher.calculatedStatsWidth` albo `SettingsActivity.calculatedStatsWidth` (21,75 % `orientationDimension`), jak dziś przekazywane do `widthFor`;
- `statsHeight` = `calculatedStatsHeight`;
- `padding` = `backgroundPadding(context)` (≈ l. 167, jak dziś).

### F1. Małe okno
- `static final double SMALL_FACTOR = 0.95;`
- `static int smallWidth(int fullWidth) { return (int) Math.round(baseWidth(2, fullWidth) * SMALL_FACTOR); }`. Przykład: 278 → 69 → 66.

### F2. Czcionka (px), wspólna dla trzech rozmiarów
- `basePx` = `TypedValue.applyDimension(COMPLEX_UNIT_SP, textSizeSp(), metrics)`. `textSizeSp()` już istnieje (≈ l. 151): `Launcher.textSizeBasic` albo to samo liczone dla ustawień.
- Paint jak w `measuringPaint()` (≈ l. 156): krój z layoutu (bold), rozmiar `basePx`.
- `widestSmall` = szerszy z:
  - `getString(instantaneous_consumption_estimated_mini, "88.8")` → „~88.8 ”;
  - `getString(driving_mileage_val_mini, "8888")` → „8888 ”.
- `lineHeight` = `fm.bottom − fm.top` przy `basePx` (jak w `fitStatsText`).
- Czysta funkcja:
  ```java
  static float fontScale(float widestSmallPx, float lineHeightPx, int smallWidth, int padding, int statsHeight)
  // = min(1, ROW_FILL * (smallWidth - padding) / widestSmallPx, 0.9 * statsHeight / 2 / lineHeightPx)
  // dzielnik <= 0 -> pomiń ten warunek
  ```
- `F = basePx · fontScale(...)`. Szerokość tekstu rośnie liniowo z rozmiarem czcionki, więc pomiar przy `basePx` i skala wystarczą.
- Nigdy powyżej `basePx` (decyzja właściciela).
- `ROW_FILL` (0,95) zostaje **tylko** dla małego okna. Margines od tła jest tu ważny, bo okno ma ~66 px.

### F3. Linia rozmiaru s ∈ {0, 1} przy czcionce F
- **Etykiety** jak w `label()` (≈ l. 99):
  - s = 0: `instantaneous_consumption` / `driving_mileage`;
  - s = 1: `_mini`;
  - z wiodącym `\u0020` z zasobu.
- **Jednostka** to sufiks z `unitStart` (etap J): `getString(id, "888")`, potem `substring(unitStart(text, "888"))`.
  - Spalanie: dłuższy po zmierzeniu z sufiksów `instantaneous_consumption_val` i `instantaneous_consumption_per_hour`. Oszacowania (`_estimated`, `_idle`) mają te same jednostki co one, a tyldę liczymy osobno.
  - Zasięg: sufiks `driving_mileage_val`.
- **Pomiar** przy rozmiarze F (`paint.setTextSize(F)`):
  - `labelPx` = szerokość etykiety;
  - `spacePx` = `"\u0020"`: pierwsza spacja to przerwa między etykietą a wartością;
  - `reservePx` = szerokość znaku, na który jest zapas: `"."` dla spalania, `"8"` dla zasięgu (czwarta cyfra);
  - `tildePx` = `"~"` (tylko spalanie; dla zasięgu 0);
  - `digitsPx` = `"888"`;
  - `unitPx` = szerokość sufiksu **przy rozmiarze F**, mnożona w funkcji czystej przez `UNIT_SCALE`.
- **Druga spacja to zapas:** w funkcji czystej liczy się jako `max(spacePx, reservePx)`. Powód:
  - w Roboto spacja ma ~0,25 em, a cyfra ~0,56 em, więc „dwie spacje + 888” (2,18 em) to mniej niż „8888” (2,24 em);
  - zasięg czterocyfrowy (do 2000) nie zmieściłby się wtedy w linii, która o szerokości decyduje, i flexbox przeniósłby wartość do drugiego wiersza;
  - zapas ma więc co najmniej szerokość spacji, a gdy znak zapasu jest szerszy, jego szerokość. Tak rozumiemy intencję właściciela (zapas na przecinek albo czwartą cyfrę). Opisz to w commicie.
- Czysta funkcja:
  ```java
  static float lineWidth(float labelPx, float spacePx, float reservePx, float tildePx, float digitsPx, float unitPx)
  // = labelPx + spacePx + Math.max(spacePx, reservePx) + tildePx + digitsPx + UNIT_SCALE * unitPx
  ```

### F4. Szerokość dużego i średniego okna
- Czysta funkcja:
  ```java
  static int textWidth(float consumptionLine, float rangeLine, int padding) {
      return (int) Math.ceil(Math.max(consumptionLine, rangeLine)) + padding;
  }
  ```
- **Bez** `ROW_FILL` i **bez** limitu wzrostu. Dwie spacje to już cały zapas; dodatkowe 5 % przywróciłoby za dużą przerwę.
- Przycięcie do ekranu jest dopiero w `widthFor` (F6), bo zależy od marginesu, który użytkownik może zmienić.
- Usuń, jeśli nic już nie używa (sprawdź grepem):
  - `MAX_GROWTH`, `windowWidth()` z rośnięciem;
  - `WIDEST_PER_100_KM`, `WIDEST_PER_HOUR`, `WIDEST_RANGE`;
  - `consumptionVariants()`, `rangeVariants()`, `valueVariants()`, `rowWidth(TextPaint…)`, `requiredWidthPx()`, `widthForSize()`.
- W ich miejsce: pomiar z F2–F4, wołany z `ensureSaved` (F5) i z bezpiecznika w `fitStatsText` (F7).

### F5. Zapis w SharedPreferences (domyślne prefs, jak reszta `Keys`)
1. **Nowe klucze w `Keys`:**
   ```java
   public static final String STATS_FONT_PX = "stats_font_px";               // float
   public static final String STATS_WIDTH_LARGE_PX = "stats_width_large_px"; // int
   public static final String STATS_WIDTH_MEDIUM_PX = "stats_width_medium_px"; // int
   public static final String STATS_GEOMETRY_TAG = "stats_geometry_tag";     // String
   ```
2. **Znacznik:** czysta funkcja `static String geometryTag(String languageTag, int orientationDimension, int statsHeight, int densityDpi, float fontScale)`:
   - wynik: `"v1|" + languageTag + "|" + orientationDimension + "|" + statsHeight + "|" + densityDpi + "|" + fontScale`;
   - `languageTag` = `Locale.getDefault().toLanguageTag()`;
   - `fontScale` = `getConfiguration().fontScale` (systemowe powiększenie czcionki zmienia px z sp);
   - „v1” podbij, jeśli kiedyś zmieni się reguła.
3. **Czysta decyzja:** `static boolean needsRecompute(boolean hasFont, boolean hasLarge, boolean hasMedium, String savedTag, String tag)`. Prawda, gdy brakuje któregoś klucza albo tag jest inny.
4. **`public static void ensureSaved(Context context, SharedPreferences prefs)`:**
   - gdy `needsRecompute`: liczy F2–F4 i zapisuje cztery klucze jednym `edit()…apply()`;
   - poza tym nic nie robi (szybkie: kilka odczytów prefs);
   - `Log.i("StatsWindowSize", …)` z wartościami do sprawdzenia w aucie: F (px), duże, średnie, małe (px), padding, tag.
5. **Gdzie wołana:**
   - na końcu `Launcher.calculateLayoutDimensions()`, po `textSizeBasic` (≈ l. 1877), z `mPrefs` (ustawione ≈ l. 1668, przed wywołaniem ≈ l. 1675);
   - na końcu `SettingsActivity.calculateLayoutDimensions()`, bo ustawienia mogą działać same, z `PreferenceManager.getDefaultSharedPreferences(this)`;
   - leniwie w getterach z F6, gdyby klucze były puste (np. serwis wstał przed launcherem);
   - przy zmianie języka `Launcher` i `SettingsActivity` są odtwarzane, więc `calculateLayoutDimensions()` przeliczy wartości samo.
6. **Wątek:** główny. Pomiar to inflacja `absolute_stats` i `measureText`, bez I/O.
7. **Gettery:**
   - `static float fontPx(Context, SharedPreferences)`;
   - `static int savedWidth(Context, SharedPreferences, int selector)`;
   - oba najpierw `ensureSaved`, potem odczyt.

### F6. `widthFor` (sygnatura może zostać, z dodanym `SharedPreferences` albo z prefs pobieranymi wewnątrz)
- `selector 0` → `STATS_WIDTH_LARGE_PX`;
- `selector 1` → `STATS_WIDTH_MEDIUM_PX`;
- `selector 2` → `smallWidth(fullWidth)`;
- wszystko przycięte do `max(0, screenWidth − 2·margin)`. Czysta funkcja `static int clampToScreen(int width, int screenWidth, int margin)`.

Bez zmian zostają te wywołania; z nowym `widthFor` dostaną zapisane szerokości:
- `syncSavedRectangle()` (≈ l. 192): sam naprawi zapisane prostokąty `stats…` i `appStats…` oraz `STATS_WIDTH` / `APP_STATS_WIDTH`;
- trzy `saveStatsPrefs()`;
- `CellLayout` (przez `syncSavedRectangle` ≈ l. 4967).

Sprawdź w `DrawView*.addRectangle()`: `minWidth = SettingsActivity.calculatedStatsWidth` (≈ l. 133 w `DrawViewAppStats`) nie może poszerzać ani blokować prostokąta małego okna w kreatorze. Jeśli `minWidth` dotyczy tylko przeciągania krawędzi, zostaw i napisz to w commicie.

### F7. `CanbusService`: tworzenie okna (≈ l. 736–800)
1. **Szerokość:** `statsWidth = StatsWindowSize.widthFor(…)` (już jest).
2. **Rozmiar tekstu:** dla wszystkich czterech pól (etykiety i wartości) i wszystkich rozmiarów `setTextSize(TypedValue.COMPLEX_UNIT_PX, StatsWindowSize.fontPx(this, prefs))`. To zastępuje `COMPLEX_UNIT_SP, Launcher.textSizeBasic` (≈ l. 780–781 i 794–795).
3. **`fitStatsText` zostaje wyłącznie jako bezpiecznik**, na wypadek okna przyciętego do ekranu (F6) albo zmienionego marginesu. Musi liczyć tymi samymi funkcjami co F2–F4:
   - rozmiar 0 i 1: `lineWidth(...)` dla obu linii przy bieżącym rozmiarze czcionki widoku, porównane z `width − padding`, **bez** 0,95 i **bez** wariantów 188.8;
   - rozmiar 2: reguła małego okna (`"~88.8 "`, `"8888 "`, `ROW_FILL`);
   - wysokość jak dziś (0,9 · wysokość / 2);
   - zmniejsza tylko, gdy `scale < 1`;
   - w normalnym przypadku z zapisaną szerokością `scale ≥ 1` i nic się nie dzieje. Ten przypadek ma test (F8), bo właśnie tu wracał błąd.
   - Usuń stare `rowWidth(TextView, TextView, String[])`.
4. **Pomiar:** wspólny kod pomiaru linii (paint, sufiksy jednostek) jest w `StatsWindowSize` w metodzie z `Context` i rozmiarem czcionki (px) jako parametrami. `CanbusService` i `ensureSaved` używają tej samej metody. Nie licz dwa razy różnymi sposobami.

### F8. Testy `StatsWindowSizeTest` (czyste liczby, JVM)
1. **`smallWidth`:** 278 → 66; 420 → 100 (105 · 0,95 = 99,75 → 100); 0 → 0.
2. **`fontScale`:**
   - zmieszczone w obu wymiarach → 1 (nigdy > 1, nawet gdy jest dużo miejsca);
   - za szeroko → `ROW_FILL·(w − padding)/widest`;
   - za nisko → `0,9·h/2/lineHeight`;
   - mniejszy z dwóch warunków wygrywa;
   - dzielnik 0 nie wysypuje.
3. **`lineWidth`:**
   - suma z jednostką × 0,75: `lineWidth(100, 5, 3, 9, 27, 40)` → 100 + 5 + 5 + 9 + 27 + 30 = 176;
   - zapas szerszy od spacji (cyfra): `lineWidth(100, 5, 11, 0, 33, 20)` → 100 + 5 + 11 + 0 + 33 + 15 = 164.
4. **`textWidth`:** dłuższa linia decyduje:
   - zasięg dłuższy od spalania (jak bg) → szerokość z zasięgu;
   - zaokrąglenie w górę;
   - padding dodany.
5. **`clampToScreen`:** szerokość większa niż ekran − 2·margines → ekran − 2·margines; wąski ekran → 0.
6. **`geometryTag` / `needsRecompute`:**
   - inny język, wymiar, gęstość albo `fontScale` → przeliczyć;
   - wszystko takie samo i trzy klucze są → nie;
   - brak któregoś klucza → tak.
7. **Prawdziwe wartości mieszczą się w linii z regułą.** Przy typowych proporcjach Roboto Bold w em: cyfra 0,56, kropka 0,27, tylda 0,59, spacja 0,25.
   - Spalanie: `lineWidth(L, 0,25, 0,27, 0,59, 3·0,56, U)` ≥ L + „~18.8” (0,59 + 3·0,56 + 0,27) + `UNIT_SCALE·U`.
   - Zasięg: `lineWidth(L, 0,25, 0,56, 0, 3·0,56, U)` ≥ L + „1999” (4·0,56) + `UNIT_SCALE·U`.
   - Ten drugi przypadek bez `max(spacePx, reservePx)` by nie przeszedł: to jest test na powód z F3.
8. **Stare testy:**
   - `whatTheTextNeeds…`, `aNarrowScreen…`, `theLargeWindowGrows…` dotyczą usuniętego `windowWidth()` z limitem 1,15: usuń albo przepisz na `clampToScreen` / `textWidth`;
   - `theMediumAndTheSmallWindow…` przepisz: małe = `smallWidth`, średnie z linii;
   - w commicie napisz, co i dlaczego.

**Commit:** `Stats window: one font from the small window, the large and medium widths from their longest line, saved once per language and screen`

## Weryfikacja i raport
- **Testy lokalne.** Gradle w tym środowisku nie działa. Uruchamiaj `javac` i JUnit console standalone 1.10.2 z katalogu `app/`:
  - classpath `../android_jar/android-36.jar`;
  - kompiluj testy z `-sourcepath <stuby>:app/src/main/java`, żeby javac sam dociągnął zależności;
  - stuby w scratchpadzie:
    - `androidx.preference.PreferenceManager`;
    - `com.syu.module.canbus.DataCanbus`;
    - `com.android.launcher66.Launcher` (`textSizeBasic`, `calculatedStatsWidth`, `calculatedLeftBarWidth`);
    - `com.android.launcher66.R` (wszystkie użyte `string`, `layout.absolute_stats`, `id.instantaneous_consumption_val`, `drawable.bg_custom`; po etapie J **bez** dwóch usuniętych napisów);
    - `SettingsActivity` (`orientationDimension`, `calculatedStatsWidth`);
    - `androidx.core.content.ContextCompat`;
    - `androidx.annotation.StringRes`, jeśli go użyjesz;
  - w kodzie testowanym lokalnie nie przekazuj `TextPaint` tam, gdzie oczekiwany jest `Paint`. Surowy `android-36.jar` nie ładuje tych klas, a testy wołają tylko czyste metody;
  - uruchom co najmniej `StatsWindowSizeTest`, `FuelModelTest`, `ConsumptionUnitsTest`, `CanbusLibraryTest`, `RoadGradeTest`.
- **Przegląd własnego diffu przed pushem:**
  - grep, że żaden `R.string.instantaneous_consumption_idle_mini` / `_per_hour_mini` nie został;
  - żadne `setTextSize(…SP, Launcher.textSizeBasic)` w oknie statystyk;
  - `fitStatsText` nie używa 0,95 dla rozmiarów 0 i 1.
- **CI:** push J, potem F dopiero na zielonym runie J.
- **Raport dla właściciela (po polsku):**
  - numery runów CI z APK i wyniki testów;
  - czego się spodziewać w aucie:
    - jedna czcionka w trzech oknach, **nie większa** niż dotąd; mniejsza tylko, gdy małe okno tego wymaga;
    - w dużym i średnim oknie przerwa między etykietą a wartością to mniej więcej dwie spacje przy trzech cyfrach;
    - jednostki o 25 % mniejsze; szerokość z dłuższej linii (w niektórych językach z „zasięgu”);
    - małe okno o 5 % węższe niż dotąd i bez żadnych jednostek (oszacowanie z tyldą, np. „~0.9”);
    - szerokości liczone raz i zapisane (te same w kreatorze i na ekranie głównym), przeliczane po zmianie języka, rozdzielczości albo systemowego powiększenia czcionki;
    - prostokąty zapisane wcześniej poprawią się same przy otwarciu kreatora albo ekranu głównego;
    - w logcat (`StatsWindowSize`) jest wiersz z czcionką (px) i szerokościami trzech okien: przyda się, jeśli coś nadal się nie zmieści.
