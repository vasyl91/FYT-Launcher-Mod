# Launcher Mod: płynne przejście między spalaniem z canbusa a oszacowaniem — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Ostatnie commity kodu: `8153720b` (katalog Launcher66_Canbus, tłumaczenia), `83d8ac10` (nazwy kategorii czytnika). Numery linii są orientacyjne (≈), więc sprawdzaj je w kodzie.

Zrób **jeden commit** (punkty F1–F4 razem). Wypchnij go na tę gałąź. **Nie twórz pull requesta.**

## 0. Problem (jazda właściciela, auto `1507667`, PSA)

Poniżej ~30 km/h auto przestaje wysyłać spalanie chwilowe („no value”) i widżet pokazuje oszacowanie `FuelModel` z `~` przed wartością.

- **Zwalnianie:** ostatnia wartość auta to np. `4.4` L/100 km, a pierwsze oszacowanie po przejściu to `~5.7`. Przy zwalnianiu spalanie powinno spadać, więc skok w górę wygląda jak błąd.
- **Przyspieszanie:** oszacowanie, np. `~6`, przechodzi w wartość auta, np. `9`. Skok zależy od tego, jak mocno kierowca przyspiesza.

Przyczyna (`settings/FuelModel.java`):
- `onFuel()` (≈ l. 225) przy każdej poprawnej wartości auta ustawia `smoothedLph = Double.NaN`, więc pierwsze `estimate()` (≈ l. 290) pokazuje „goły” model z `litresPerHour()`, bez związku z ostatnią wartością auta;
- model jest dopasowany średnio, a przy ~28 km/h błąd 0,3–0,5 L/h to ponad 1 L/100 km.

**Decyzje właściciela:**
- przy zwalnianiu oszacowanie nie może przekroczyć ostatniej wartości auta **przez całe zwalnianie**, a nie tylko w pierwszej chwili;
- przy przyspieszaniu **wartości auta nie zmieniamy** (to prawda), ale model ma się uczyć błędu na krawędzi, żeby skok z czasem malał (F3).

**Zasady** (jak w poprzednich briefach):
- commit po angielsku, z trailerami sesji, bez nazwy modelu w treści;
- tylko do odczytu: `.github/workflows/*`, `app/src/main/generated/baselineProfiles/`, `decompiled_*/**`, `fuel_stats_example/`;
- `FuelModel` zostaje czystą Javą (bez `android.*`), z testami JVM;
- `CanbusService` się nie zmienia: korzysta tylko z `estimate()` i `carGivesNoValue()`;
- StrictMode: bez I/O na wątku głównym (model i tak nic nie zapisuje sam).

## F1. Ciągłość: oszacowanie zaczyna się od ostatniej wartości auta

1. Nowe pola chwili (niezapisywane), ustawiane w `onFuel()` dla poprawnej wartości (`value > 0 && value < 3001`, albo `0` przy zwalnianiu w ruchu):
   - `lastCarT` = t;
   - `lastCarL100` = `value / 10.0`;
   - `lastCarLph` = `value / 10.0 * kmh() / 100.0`.
2. W `estimate()`, gdy `smoothedLph` jest NaN (pierwsze oszacowanie po zamilknięciu auta) i `now - lastCarT <= NO_UPDATE_MS`, auto jest w ruchu, a `lastCarT >= 0`:
   - `handoverOffset = lastCarLph - litresPerHour(now)`;
   - `handoverT = now`;
   - `smoothedLph = lastCarLph`.

   W innym przypadku (start z postoju, stara wartość auta) `handoverOffset = 0`, jak dotąd.
3. Model z przesunięciem: `lph = litresPerHour(now) + handoverOffset * Math.exp(-(now - handoverT) / HANDOVER_TAU_MS)`, gdzie `HANDOVER_TAU_MS = 15_000`. Na to idzie dotychczasowe wygładzanie (`SMOOTH_RISE` / `SMOOTH_FALL`). Wynik nie może spaść poniżej 0.
4. Przesunięcie dotyczy tylko jazdy. Na postoju (L/h) zostaje bieg jałowy z modelu, bez przesunięcia.

## F2. Zwalnianie: nie wyżej niż ostatnia wartość auta

1. Od chwili przejścia z F1 trzymaj `handoverMinKmh` (najmniejsza prędkość od przejścia) i flagę `slowingSinceHandover = true`.
2. Flaga gaśnie na stałe (do następnego przejścia), gdy:
   - prędkość wzrośnie o ponad 2 km/h ponad `handoverMinKmh`;
   - albo `accel(now) > 0.3` m/s² (kierowca przyspiesza);
   - albo auto stoi (`!isMoving()`; wtedy i tak pokazywane jest L/h).
3. Dopóki flaga jest zapalona, pokazywane L/100 km (`Estimate.value` dla `perHour == false`) wynosi `min(oszacowanie, lastCarL100)`. Wygładzanie liczy dalej w L/h bez zmian, a ograniczenie dotyczy tylko wyniku.
4. Auto, które przy hamowaniu silnikiem wysyła `0` (odcięcie paliwa, `lastCarL100 == 0`), dostaje `0.0` aż do zgaśnięcia flagi. Tak samo pokazywałoby to auto.
5. Ograniczenie działa tylko wtedy, gdy przejście nastąpiło przy zwalnianiu (`accel(now) < 0` w chwili przejścia). Gdy auto zamilkło przy stałej prędkości albo przy przyspieszaniu, flaga się nie zapala; zostaje samo F1.

## F3. Przyspieszanie: nauka błędu na krawędzi

Wartość auta po powrocie pokazujemy jak dotąd, od razu. Zmniejszamy sam skok, ucząc model, o ile średnio zaniża spalanie tuż pod progiem przy rozpędzaniu.

1. Pole chwili `lastEstimateLph` (ostatnie pokazane oszacowanie w L/h, po wszystkich poprawkach) i `lastEstimateT`, ustawiane w `estimate()` przy jeździe.
2. W `onFuel()`, gdy przychodzi pierwsza poprawna wartość po oszacowaniu, liczy się „powrót”. Warunki: `lastEstimateT >= 0`, `t - lastEstimateT <= 3000`, auto w ruchu, `accel(t) > 0`. Wtedy:
   - `r = carLph - lastEstimateLph`;
   - `edgeUpLph = edgeUpLph + (r - edgeUpLph) / Math.min(++edgeUpCount, EDGE_MEMORY)`, gdzie `EDGE_MEMORY = 10`; najpierw zwykła średnia, potem wykładnicza z ~10 ostatnich;
   - ogranicz `edgeUpLph` do ±1.5 L/h;
   - wyzeruj `lastEstimateT` (jeden powrót = jedna próbka).
3. W `litresPerHour()` albo w `estimate()` (tam, gdzie łatwiej, ale tylko dla oszacowania przy jeździe z `a >= COAST_ACCEL` i `a > 0`) dodaj `edgeUpLph * Math.exp(-Math.max(0, thresholdKmh - kmh()) / EDGE_SCALE_KMH)` z `EDGE_SCALE_KMH = 10`: pełna poprawka tuż pod progiem, zanikająca przy niższych prędkościach.
4. Poprawka nie wpływa na `learn()` ani na współczynniki WLS, bo jest osobną warstwą.
5. **Zapis:** `serialize()` pisze format `2;`: dotychczasowe pola, a dalej `edgeUpLph` i `edgeUpCount`. `parse()` czyta `2;` i nadal `1;` (wtedy `edgeUpLph = 0`, `edgeUpCount = 0`). Tekst w nieznanym formacie daje nowy model, jak dotąd.

## F4. Dokumentacja w kodzie

- Javadoc klasy `FuelModel` (≈ l. 7–26): krótki akapit o przejściu. Pierwsze oszacowanie to ostatnia wartość auta, różnica do modelu zanika z τ = 15 s, przy zwalnianiu wynik ≤ ostatnia wartość auta, a przy rozpędzaniu pod progiem działa wyuczona poprawka krawędzi.
- Stałe z F1–F3 jako `static final` obok pozostałych, z jednozdaniowymi komentarzami w stylu pliku.

**Commit:** `Fuel estimate: start from the car's last value, never above it while slowing down, learn the jump on speeding up`

## Testy JVM (`FuelModelTest`)

Użyj istniejących helperów `drive()`, `hold()`, `trueLph()`. Gdzie trzeba, dopisz mały helper „przejechania przez próg”: kilka sekund z wartościami auta nad progiem, potem zwalnianie albo przyspieszanie z `65535`.

1. `slowingDownTheEstimateStartsFromTheCarsLastValue`: model skalibrowany (`drive` ~15 min), potem zwalnianie z 35 do 10 km/h (−0,8 m/s²). Auto do 30 km/h wysyła wartość o 0,5 L/h niższą od `trueLph`. Pierwsze `estimate()` po zamilknięciu = ostatnia wartość auta (±0.1), a każde kolejne aż do 10 km/h ≤ tej wartości.
2. `aCarThatCutsTheFuelShowsZeroUntilItSpeedsUp`: ostatnia wartość auta `0` przy zwalnianiu, potem `65535`. Oszacowanie `0.0` aż do przyspieszenia (> 0,3 m/s²), potem > 0.
3. `theDifferenceToTheModelFadesAway`: przejście przy stałej prędkości 28 km/h. Po 60 s oszacowanie różni się od modelu bez przesunięcia o mniej niż 0,1 L/100 km.
4. `speedingUpTheJumpShrinksAsTheEdgeIsLearned`: auto, które pod progiem przy rozpędzaniu pali o 1 L/h więcej niż `trueLph`. 20 przejść 20→35 km/h z przyspieszeniem +0,8 m/s². Średni skok (pierwsza wartość auta − ostatnie oszacowanie) z ostatnich 5 przejść jest mniejszy o ≥ 50 % od skoku z pierwszego.
5. `theEdgeCorrectionReadsBack`: `serialize()` → `parse()` daje tę samą poprawkę (te same oszacowania), a tekst `1;…` z dotychczasowego `serialize()` czyta się z poprawką 0.
6. Wszystkie dotychczasowe testy `FuelModelTest` przechodzą bez zmian.

## Weryfikacja i raport końcowy

- **Przed pushem:**
  - Gradle w tym środowisku nie działa (brak toolchaina i SDK). Testy uruchamiaj przez `javac` + JUnit console standalone 1.10.2 z katalogu `app/`, z classpath `android_jar/android-36.jar`;
  - uruchom co najmniej `FuelModelTest`, `CanbusCodeEstimatorTest`, `CanbusLibraryTest`, `CodePairChooserTest`.
- **CI:** push dopiero na zielonym poprzednim runie. Czerwony build naprawiaj nowym commitem, bez amend i force-push.
- **Raport dla właściciela (po polsku):**
  - numer runu CI z APK;
  - wynik testów;
  - czego się spodziewać na aucie:
    - przy zwalnianiu przez ~30 km/h `~` zaczyna od ostatniej wartości auta i nie rośnie, dopóki auto zwalnia;
    - przy przyspieszaniu przez próg skok na początku zostaje, ale po kilkunastu przejściach powinien wyraźnie zmaleć;
    - stary zapisany model wczyta się bez utraty nauki (format 1 → 2).
