# Launcher Mod: okno statystyk i płynne przejścia między wartością auta a oszacowaniem: instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Ostatni commit kodu: `495fb7f1` (prostokąt okna statystyk zgodny z oknem). Numery linii są orientacyjne (≈).

Pracę dzielisz na **trzy commity** w kolejności **W2 → P → R**:
- każdy commit ma swoje testy;
- każdy wypychasz osobno na tę gałąź, dopiero gdy poprzedni run CI jest zielony;
- **nie twórz pull requesta**.

## 0. Skąd te zmiany

Właściciel po jeździe z modelem v3 zgłosił trzy rzeczy:

1. **Duże okno statystyk jest za szerokie.** Dziś rośnie do +35 % (`StatsWindowSize.MAX_GROWTH = 1.35`). Wystarczy +15 %. Średnie i małe okno **miały nie być ruszane wcale**: małe nie pokazuje nawet jednostek. To, co commit `fd29a66d` zmienił w ich szerokości i czcionce, trzeba cofnąć.
2. **Skok przy powrocie wartości auta (przyspieszanie).** Przy przejściu z oszacowania na wartość z canbus różnica ≥ 2,5 L/100 km ma być rozbita na mniejsze kroki, żeby nie było widać przeskoku. Model uczący się krawędzi (F3) zostaje; to dodatkowe, czysto graficzne rozmycie.
3. **Skok przy zwalnianiu pod progiem.** Np. ~4,5 L/100 km przy 30 km/h, a zaraz po zejściu pod próg od razu ~0,7 L/h. Ma być płynne przejście do celu w 3–4 s, niezależnie od ostatniej wartości auta i od tego, czy RPM jest dostępne (hamowanie silnikiem też).

### 0.1 Przyczyna punktu 3 (znaleziona w kodzie)
- `FuelModel.estimate()` (≈ l. 696) startuje od ostatniej wartości auta tylko wtedy, gdy `now - lastCarT <= NO_UPDATE_MS` (5 s).
- Auto właściciela pod progiem zwykle **przestaje wysyłać kod** (65535 przychodzi rzadko, kilka razy na nagranie). `carGivesNoValue()` robi się wtedy prawdą dopiero po > 5 s ciszy (`now - lastFuelT > NO_UPDATE_MS`).
- W chwili pierwszego oszacowania warunek przejścia już nie zachodzi, więc oszacowanie startuje od razu od celu (~0,7 L/h). Przez te 5 s widżet pokazuje jeszcze starą wartość auta, potem przeskakuje.
- Do tego samo przejście jest wykładnicze (`HANDOVER_TAU_MS = 3_000`), a na nim działa jeszcze wygładzanie `SMOOTH_FALL`.

### 0.2 Decyzje właściciela
- Limit +15 % tylko dla **dużego** okna; średnie i małe dokładnie jak przed `fd29a66d` (szerokość = udział ekranu, czcionka liczona jak dawniej).
- Wartości pośrednie przy powrocie wartości auta pokazujemy **z tyldą** (jak oszacowanie: „~6.4 L/100km”), bo nie są wartością auta. Tylda znika, gdy pokazana jest prawdziwa wartość auta.
- Płynne przejście przy zwalnianiu: 3–4 s, zawsze, z RPM i bez RPM.

### 0.3 Zasady (jak w poprzednich briefach)
- commity po angielsku, z trailerami sesji, bez nazwy modelu w treści;
- tylko do odczytu: `.github/workflows/*`, `app/src/main/generated/baselineProfiles/`, `decompiled_*/**`, `fuel_stats_example/`;
- `FuelModel` i czysta część `StatsWindowSize` (`baseWidth`, `windowWidth`, `fitRectangle`, `textSizeSp(int)`) zostają bez `android.*` w logice, z testami JVM;
- StrictMode: bez I/O na wątku głównym;
- nie commituj nagrań właściciela;
- czerwony build naprawiaj nowym commitem, bez amend i force-push.

## Etap W2: okno statystyk (commit 1)

Pliki: `settings/StatsWindowSize.java`, `settings/CanbusService.java` (`fitStatsText`, `rowWidth`, tworzenie okna ≈ l. 740–800), `StatsWindowSizeTest.java`.

1. `StatsWindowSize`:
   - `MAX_GROWTH = 1.15`;
   - `widthFor()`: dla rozmiaru **0** jak dziś (`windowWidth(baseWidth, requiredWidthPx, …)`); dla **1 i 2** zwraca dokładnie `baseWidth(selector, fullWidth)` przycięte do `screenWidth − 2·margin` (jak przed `fd29a66d`), bez `requiredWidthPx`;
   - poprawić Javadoc klasy: rośnie tylko duże okno, najwyżej o 15 %.
2. `CanbusService.fitStatsText()`:
   - rozmiar 0: mierzy najszersze warianty (`consumptionVariants`/`rangeVariants`), jak dziś;
   - rozmiary 1 i 2: przywróć pomiar sprzed `fd29a66d` (bieżący tekst wartości + `"88"`), żeby czcionka średniego i małego była taka jak dawniej. Stary kod: `git show fd29a66d^:app/src/main/java/com/android/launcher66/settings/CanbusService.java` (`fitStatsText`, `rowWidth`);
   - czcionka nadal liczona raz, przy tworzeniu okna.
3. `syncSavedRectangle()` się nie zmienia: z nowym `widthFor()` sam naprawi prostokąty średniego i małego zapisane w międzyczasie (szerokość = udział ekranu). Sprawdź, że edytory (`saveStatsPrefs()` w trzech `DrawView*`) korzystają z tego samego `widthFor()`.
4. Testy `StatsWindowSizeTest`:
   - `windowWidth`: limit 1,15 (np. udział 400 → najwyżej 460; wąski ekran → ekran − 2·marginesy);
   - dostosuj istniejące asercje 1,35 → 1,15 (opisz w commicie).
   - `widthFor` dla 1 i 2 wymaga `Context`; jeśli wydzielisz czysty pomocnik (np. `static int widthForSize(int selector, int fullWidth, int requiredPx, int screenWidth, int margin)`), przetestuj, że 1 i 2 dają udział ekranu niezależnie od `requiredPx`.

**Commit:** `Stats window: only the large window grows, by at most 15 %; the medium and small ones are as they were`

## Etap P: rozmycie skoku przy powrocie wartości auta (commit 2)

Pliki: `settings/FuelModel.java` (`onFuel`, `learnEdge`, `estimate`), `settings/CanbusService.java` (`showFuel`, `setFuelText`), `FuelModelTest.java`.

1. Stan w `FuelModel` (nie zapisywany):
   - `lastEstimateL100`: w `estimate()` przy każdym oszacowaniu w ruchu: wartość pokazana w L/100 km; gdy pokazane było w L/h, przelicz `lph / kmh · 100` przy prędkości z tej chwili, ograniczone `MAX_L_PER_100KM`;
   - `blendL100` (NaN = brak rozmycia), liczba wartości pośrednich, czas pierwszej.
2. Reguła w `onFuel()` dla poprawnej wartości w ruchu, **przed** `learnEdge()` (który zeruje `lastEstimateT`):
   - rozmycie zaczyna się tylko wtedy, gdy oszacowanie było pokazane przed chwilą (`lastEstimateT` ≤ `EDGE_RETURN_MS` temu); trwa, dopóki `blendL100` nie jest NaN;
   - `prev` = `blendL100`, gdy rozmycie trwa, inaczej `lastEstimateL100`;
   - gdy `|car − prev| ≥ BLEND_MIN_STEP_L100 = 2.5` → `blendL100 = (prev + car) / 2`;
   - inaczej `blendL100 = NaN` (pokazuj wartość auta);
   - bezpiecznik: najwyżej `BLEND_MAX_STEPS = 3` wartości pośrednie i `BLEND_MAX_MS = 5_000` od pierwszej, potem NaN;
   - działa w obie strony (auto wyżej i niżej od oszacowania), ale tylko przy przejściu z oszacowania na wartość auta;
   - wartość 0 auta (odcięcie paliwa) i „brak wartości” kończą rozmycie.
3. Przykład (do testu): oszacowanie 4,6 → auto 8,2: pokazuj ~6,4; auto 9,6: ~8,0 (|9,6 − 6,4| = 3,2); auto 10,2: 10,2 (|10,2 − 8,0| = 2,2 < 2,5).
4. Nauka (WLS, bias z B4, krawędź z F3) **zawsze na prawdziwej wartości auta**. Rozmycie dotyczy tylko wyświetlania.
5. API: `public double blendedCarL100()`, NaN = pokazuj wartość auta.
6. `CanbusService.showFuel()`:
   - dla wartości auta `0 < value < 3001`, gdy `carValueShown(value)` daje null albo `L100` i `fuelModel.blendedCarL100()` nie jest NaN: tekst przez `instantaneous_consumption_estimated` / `_mini` (z tyldą), wartość z jednym miejscem po przecinku (`Locale.ROOT`, jak `Estimate.text()`);
   - w innych przypadkach jak dziś;
   - po wartości pośredniej następna wartość auta przychodzi z kolejnym `onFuel`, więc nic więcej nie trzeba odświeżać.
7. Testy `FuelModelTest`:
   - sekwencja z punktu 3 (oszacowanie, potem trzy wartości auta przy przyspieszaniu przez próg);
   - różnica < 2,5 → od razu wartość auta;
   - auto mówi cały czas (bez wcześniejszego oszacowania) → brak rozmycia;
   - bezpiecznik 3 kroków (np. auto rośnie o 6 L/100 km co sekundę);
   - nauka krawędzi liczona z prawdziwej wartości: `speedingUpTheJumpShrinksAsTheEdgeIsLearned` przechodzi bez zmian.

**Commit:** `Fuel widget: a jump of 2.5 L/100 km or more from the estimate to the car's value is shown in steps`

## Etap R: płynne przejście z wartości auta na oszacowanie (commit 3)

Pliki: `settings/FuelModel.java` (`estimate`, stałe przejścia, Javadoc klasy), `FuelModelTest.java`.

1. Okno przejścia: zamiast `now - lastCarT <= NO_UPDATE_MS` warunek `now - lastCarT <= HANDOVER_WINDOW_MS`, `HANDOVER_WINDOW_MS = NO_UPDATE_MS + 5_000`. Przejście zaczyna się więc też po ciszy bez 65535 (0.1).
2. Zamiast wykładniczego zaniku przejście liniowe:
   - `lph = max(0, target + handoverOffset · max(0, 1 − (now − handoverT) / HANDOVER_MS))`, `HANDOVER_MS = 3_500` (zastępuje `HANDOVER_TAU_MS`);
   - w czasie przejścia bez `SMOOTH_RISE`/`SMOOTH_FALL`: pokazana wartość = rampa;
   - po przejściu wygładzanie jak dziś (bez skoku na końcu rampy: `smoothedLph` startuje od wartości rampy).
3. Obowiązuje przy każdym przejściu:
   - niezależnie od ostatniej wartości auta (wysokiej i niskiej);
   - niezależnie od trybu (`OVERRUN`, `IDLE_ROLL`, `ENGINE_OFF`, `DRIVING`);
   - niezależnie od tego, czy RPM jest wiarygodne: przy hamowaniu silnikiem cel to ~0, a i tak trwa 3,5 s rampy.
   - Jednostka bez zmian (B6): przy zwalnianiu L/h od pierwszego oszacowania; start = ostatnia wartość auta w L/h.
4. Javadoc klasy: przejście liniowe 3,5 s zamiast „fades with 3 s”.
5. Testy `FuelModelTest`:
   - zwalnianie 35 → 10 km/h (−0,8 m/s²); auto daje wartości powyżej 30 km/h, a pod progiem **przestaje wysyłać** (żadnego 65535, `onFuel` nie jest wołane). Oczekiwane: pierwsze oszacowanie (po > 5 s ciszy) = ostatnia wartość auta w L/h (±0,1), w połowie rampy ≈ połowa drogi do celu (±0,1), po ≥ 3,5 s ≈ cel (±0,1);
   - to samo z wiarygodnym RPM i hamowaniem silnikiem (auto z odcięciem paliwa, helper `driveRpm`): start od wartości auta, po 3,5 s < 0,2 L/h;
   - cisza dłuższa niż 10 s (np. postój z wyłączonym radiem) → start od celu, bez rampy;
   - zaktualizuj testy, które zakładały τ 3 s (`theDifferenceToTheModelFadesAway`, `slowingDownBelowTheThresholdGoesToTheIdleInLitresPerHour` i inne, które pękną); w commicie napisz, co i dlaczego.

**Commit:** `Fuel estimate: from the car's last value to the estimate in a straight line over 3.5 s, also after a silence with no "no value"`

## Weryfikacja i raport
- **Testy lokalne.** Gradle w tym środowisku nie działa. Uruchamiaj `javac` i JUnit console standalone 1.10.2 z katalogu `app/`:
  - classpath `../android_jar/android-36.jar`;
  - stuby w scratchpadzie dla `androidx.preference.PreferenceManager`, `com.syu.module.canbus.DataCanbus`, `com.android.launcher66.Launcher` (`textSizeBasic`, `calculatedStatsWidth`), `com.android.launcher66.R`, `SettingsActivity` (`orientationDimension`, `calculatedStatsWidth`), `androidx.core.content.ContextCompat`;
  - w kodzie testowanym lokalnie unikaj przekazywania `TextPaint` tam, gdzie oczekiwany jest `Paint`: surowy `android-36.jar` nie ładuje tych klas;
  - uruchom co najmniej `FuelModelTest`, `StatsWindowSizeTest`, `ConsumptionUnitsTest`, `CanbusLibraryTest`, `RoadGradeTest`.
- **Odtworzenie nagrań** (scratch, nie commituj), jeśli są pliki `/root/.claude/uploads/113ab8c6-8f22-5568-95ab-103f6faca20b/*CanbusCodes*.txt`:
  - czas każdego nagrania znormalizuj (pierwsze zdarzenie = 0, nagrania godzinę po sobie); inaczej `onSpeed` odrzuca prędkości „z przeszłości”;
  - każde nagranie testuj na modelu uczonym na pozostałych;
  - podaj skok przy powrocie wartości liczony z **pokazanej** wartości (z rozmyciem) i bez niego, oraz pokazaną wartość 1, 2 i 4 s po zamilknięciu auta (rampa);
  - błędy MAE modelu (28–45 km/h) mają się nie zmienić: P i R nie dotykają modelu.
- **CI:** push dopiero na zielonym poprzednim runie.
- **Raport dla właściciela (po polsku):**
  - numery runów CI z APK i wyniki testów;
  - liczby z odtworzenia nagrań;
  - czego się spodziewać w aucie:
    - duże okno statystyk najwyżej 15 % dłuższe niż udział ekranu, średnie i małe jak przed zmianą;
    - przy przyspieszaniu przez próg, przy dużej różnicy: „~6.4”, „~8.0”, potem wartość auta;
    - przy zwalnianiu pod progiem: od ostatniej wartości auta (w L/h) przez 3,5 s płynnie do ~0.7 L/h, także gdy auto po prostu przestaje wysyłać spalanie i także przy hamowaniu silnikiem.
