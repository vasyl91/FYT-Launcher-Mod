# Launcher Mod: model spalania v3 (fizyka, dane auta, nachylenie, RPM, kody, jednostki): instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Ostatnie commity kodu: `43ea9093` (pułap malejący z prędkością), `bd86cfbd` (przejście F1–F3). Numery linii są orientacyjne (≈).

Pracę dzielisz na **siedem commitów** w kolejności **B → K → E → D → W → A → C**:
- każdy commit ma swoje testy;
- każdy wypychasz osobno na tę gałąź, dopiero gdy poprzedni run CI jest zielony;
- **nie twórz pull requesta**.

## 0. Skąd te zmiany

### 0.1 Dane z auta właściciela (9 nagrań czytnika, auto `1507667`, PSA)
Kod 91 to spalanie (L/100 km × 10, ~1 Hz, 65535 poniżej ~30 km/h). Kod 510 to prędkość (km/h × 100, pełne km/h, do 5 Hz). Nagrania nie mają RPM ani wysokości GPS.

Średnie L/h (w nawiasie L/100 km):

| prędkość | zwalnianie (a < −0,3) | stała | przyspieszanie (a > 0,3) |
|---|---|---|---|
| 27–32 km/h | 0,87 (3,0) | 1,21 (4,1) | 1,77 (5,8) |
| 32–38 km/h | 0,94 (2,7) | 1,35 (3,9) | 2,47 (7,2) |
| 38–45 km/h | 1,01 (2,5) | 1,74 (4,3) | 3,32 (8,1) |

Wnioski (przybliżona analiza w Pythonie; ucz na 8 nagraniach, testuj na 9., błąd średni w L/h przy 28–45 km/h):
1. **Przy zwalnianiu poniżej ~45 km/h auto nie odcina paliwa.** Spala ~0,9 L/h, czyli tyle co na biegu jałowym. Obecny model zwalniania `c0 + c1·v` uczy się z całego zakresu, a dane to głównie autostrada. Przy 10 km/h daje przez to 0,42 L/h, a przy 20 km/h 0,62 L/h. Fizycznie przy v → 0 spalanie dąży do biegu jałowego (~0,80). Poziom zakotwiczony w biegu jałowym (B3) daje 0,81 i 0,82 L/h. Błąd w chwili zamilknięcia auta spada z 0,38 do 0,33 L/h.
2. **Osobne opory toczenia i powietrza plus człon a²·v** (B2) zmniejszają błąd: ogółem 0,48 → 0,46, przyspieszanie 0,72 → 0,70, stała prędkość 0,39 → 0,36, a skok przy powrocie wartości auta 0,67 → 0,60 L/h. Wersja z `a·v` ze znakiem jest gorsza (stała prędkość 0,40), więc zostaje `max(a, 0)·v`.
3. **Kolejne wartości auta przy progu różnią się średnio o 0,62 L/h (1,5 L/100 km) z sekundy na sekundę.** To dolna granica skoku przy powrocie wartości: o tyle zmienia się samo auto.
4. **Okno 2 s do liczenia przyspieszenia pasuje najlepiej** (korelacja z wartościami auta 0,74, okno 1 s 0,59). Zostaje.

### 0.2 Wiedza ogólna
- **Model mocowy Akçelika** (ARRB; aaSIDRA/aaMOTION, Akçelik i Besley 2003):
  - `f = α + β1·P + β2·M·a²·v` dla P > 0 i `f = α` dla P ≤ 0;
  - P = (toczenie + powietrze + M·a + M·g·nachylenie)·v;
  - dla lekkiego pojazdu β1 = 0,09 mL/kJ (0,324 L/h na kW) i β2 = 0,03 mL/(kJ·m/s²).
- **Bieg jałowy rośnie z pojemnością silnika.** Argonne National Laboratory zmierzyło 0,61 L/h dla 2,0 L (Ford Focus) i 1,48 L/h dla 4,6 L. Tabela ANL bez obciążenia podaje 0,61 L/h na litr pojemności, co traktujemy jako górną granicę.
- **Tarcie silnika** (Heywood, silniki ZI): FMEP [bar] ≈ 0,97 + 0,15·n + 0,05·n², gdzie n = obr/min / 1000.
- **Odcięcie paliwa przy hamowaniu silnikiem** działa powyżej ~1100–1500 obr/min, zależnie od silnika. Przy obrotach biegu jałowego silnik zawsze dostaje paliwo. Bieg jałowy to 650–1000 obr/min, zależnie od auta, temperatury i klimatyzacji, więc model uczy się go na postoju zamiast przyjmować 900 na stałe.
- **Komputery, które przełączają jednostkę, podają ją dokładnie:**
  - Škoda i SEAT: l/h na postoju i przy małej prędkości;
  - Opel Antara: l/h poniżej 13 km/h;
  - Łada: l/h poniżej 10 km/h;
  - PSA właściciela: „-.-” poniżej ~30 km/h, w canbusie 65535.
- **Jednostka w canbusie:** tylko kilka protokołów aplikacji canbus przekazuje radiu jednostkę spalania chwilowego (etap E).

### 0.3 Decyzje właściciela
- **Zwalnianie poniżej progu:** oszacowanie w L/h („~0.9 L/h”), nie w L/100 km.
- **Poniżej 10 km/h zawsze L/h**, przy zwalnianiu i przy przyspieszaniu. Powrót do L/100 km powyżej 13 km/h (histereza z progów Łady i Opla).
- **Pierwszeństwo jednostki:**
  1. auto korzysta z modułu (auto z progiem): decyduje moduł;
  2. w przeciwnym razie protokół canbus podaje jednostkę: wygrywa protokół;
  3. w ostatniej kolejności reguła 10/13 km/h z przeliczeniem (etap D).
- **Kody mają się znajdować same.** Użytkownik wpisuje kod tylko wtedy, gdy chce zmienić znaleziony, a każdy kod jest sprawdzany (0.5).
- **Dane auta w ustawieniach:** masa (kg) i pojemność silnika (cm³), obie opcjonalne. Bez nich model działa jak dziś, tak jak bez RPM. Ich obecność ma model uwiarygodnić.
- **Odcięcie paliwa (0 L/h) rozpoznajemy tylko z RPM.** Obroty wyraźnie powyżej biegu jałowego przy zwalnianiu to hamowanie silnikiem. Obroty biegu jałowego to toczenie się na luzie.
- **Oszacowanie tylko dla aut, które podają spalanie od pewnego progu prędkości.**
- **Wartość auta to prawda:** pokazujemy ją od razu. Przy małej prędkości zmienia się najwyżej jej jednostka.

### 0.4 Zasady (jak w poprzednich briefach)
- commity po angielsku, z trailerami sesji, bez nazwy modelu w treści;
- tylko do odczytu: `.github/workflows/*`, `app/src/main/generated/baselineProfiles/`, `decompiled_*/**`, `fuel_stats_example/`; czytanie `decompiled_*` przez skrypt biblioteki jest dozwolone;
- `FuelModel`, `RoadGrade` i `ConsumptionUnits` to czysta Java (bez `android.*`), z testami JVM;
- StrictMode: bez I/O na wątku głównym (odczyt `SharedPreferences`, które są już w pamięci, jest OK jak dotąd);
- nie commituj nagrań właściciela.

### 0.5 Skąd moduł bierze kody (po tej pracy)

| kod | skąd, w tej kolejności | kontrola |
|---|---|---|
| spalanie, zasięg | ustawienia → biblioteka canbus (para kodów wybrana przez `CodePairChooser`) | jak dziś |
| prędkość | ustawienia → czytnik canbus (`ReaderGuesses.speed`, ze skalą) → GPS | K3: kod niezgodny z GPS jest odrzucany i wraca GPS |
| RPM | ustawienia → czytnik canbus (`ReaderGuesses.rpm`, **nowe**, dziś tylko ustawienia) → brak | K2: wartości niepodobne do obrotów są pomijane |
| jednostka spalania | tylko biblioteka canbus (etap E), bez pola w ustawieniach | odczyt wprost z protokołu |
| masa, pojemność | tylko ustawienia (canbus ich nie podaje) | zakresy 500–4000 kg, 600–8000 cm³ |

## Etap B: model v3 (commit 1)

Pliki: `settings/FuelModel.java`, `FuelModelTest.java`. Publiczne API zostaje: `onSpeed`, `onRpm`, `onFuel`, `estimate`, `carGivesNoValue`, `Estimate(value, perHour, text())`. `CanbusService` w tym etapie się nie zmienia.

**Przed zmianą modelu** wygeneruj obecnym kodem dwa teksty referencyjne do testu B11.9:
- tekst `2;` z `drive(m, new Random(9), 0, 900, 30, 0.9)`;
- tekst `1;` zrobiony z niego tak jak w `theEdgeCorrectionReadsBack`.

Zapisz też `litresPerHour` starego modelu w kilku punktach (30, 36, 42 km/h × a = 0 i 0,8). Wklej to wszystko do testu jako stałe.

### B1. Stan auta i tryby
- `aEff = a + 9,81·sinθ`. Do etapu C sinθ = 0. Wszędzie, gdzie dziś jest `a` (tryby, cechy, nauka), używaj `aEff`.
- Tryby (prywatny `enum Mode`), sprawdzane w tej kolejności:
  1. `STANDING`: `!isMoving()`;
  2. `ENGINE_OFF`: RPM znane i wiarygodne (K2), świeże (≤ 5 s) i równe 0; spalanie 0 (start-stop, hybryda);
  3. `IDLE_ROLL`: RPM wiarygodne i świeże, |RPM − `idleRpm`| ≤ max(150, 0,15·`idleRpm`) i `aEff ≤ 0,3`; silnik na biegu jałowym (luz, sprzęgło, automat bez blokady), spalanie = bieg jałowy;
  4. `OVERRUN`: `aEff < COAST_ACCEL` (−0,3);
  5. `DRIVING`: wszystko inne.
- `idleRpm`: średnia wykładnicza (α = 0,05) RPM > 300 na postoju, domyślnie 800 do 20 próbek. Zapisywana (B9).

### B2. Jazda (`DRIVING`): moc na kilogram, cechy niezależne od masy

Cechy WLS (n = 6):

| cecha | wzór | znaczenie |
|---|---|---|
| `f0` | 1 | bieg jałowy i stałe straty |
| `f1` | 0,108·v | toczenie (g·Crr·v, Crr = 0,011) |
| `f2` | v³/1000 | opór powietrza |
| `f3` | max(aEff, 0)·v | bezwładność i podjazd |
| `f4` | max(aEff, 0)²·v | mocne przyspieszanie (β2 Akçelika) |
| `f5` | n·(1 + 0,15·n + 0,05·n²), n = RPM/1000 | tarcie silnika; 0 bez wiarygodnego RPM (zastępuje `rpm/1000`) |

`lph = c0 + max(0, c1·f1 + c2·f2 + c3·f3 + c4·f4) + c5·f5`

Cechy nie zależą od masy, więc dane auta zmieniają tylko priory, a wyuczone sumy WLS zostają ważne.

Priory: β = 3,24·10⁻⁴ L/h na W, m = masa z ustawień albo 1300 kg, V = pojemność w litrach albo brak.

| wsp. | prior (dla 1300 kg) | waga bez danych | waga z danymi |
|---|---|---|---|
| c0 | V ? clamp(0,2 + 0,30·V; 0,4; 2,0) : 0,8 | 200 | 400 (z pojemnością) |
| c1 | β·m (0,42) | 5 | 20 (z masą) |
| c2 | β·0,6·CdA·1000, CdA = 0,45 + 0,00015·m (0,126) | 5 | 20 (z masą) |
| c3 | 1,05·β·m (0,44) | 5 | 20 (z masą) |
| c4 | 1,08·10⁻⁴·m (0,14) | 5 | 20 (z masą) |
| c5 | 0 | 5 | 5 |

Granice zastępują obecne `clampDrive`:
- c0 ∈ [0,3; 2,5];
- c1, c2, c3 ∈ [0; 3·prior];
- c4 ∈ [−c3/6; 3·prior], żeby spalanie rosło z przyspieszeniem do 3 m/s² (dane PSA dają c4 lekko ujemne);
- c5 ∈ [0; 2].

Próbki `IDLE_ROLL` z wartością auta uczą WLS jazdy cechami `[1, 0, 0, 0, 0, f5]`: silnik nie napędza kół.

### B3. Zwalnianie (`OVERRUN`) zakotwiczone w biegu jałowym
- WLS `coast` zostaje jak dziś (`{1, v}`). Uczy się z próbek `OVERRUN`, a z RPM tylko z tych z obrotami powyżej pasma biegu jałowego (hamowanie silnikiem).
- Poziom do oszacowania (`coastLevel`):
  - **z RPM** powyżej pasma: `coast(v)` wprost (auto z odcięciem paliwa da ~0); RPM w paśmie oznacza tryb `IDLE_ROLL`;
  - **bez RPM**, `v ≥ v_th` (v_th = `thresholdKmh`): `coast(v)`;
  - **bez RPM**, `v < v_th`: `idle + (coast(v_th) − idle)·v/v_th`, czyli liniowo od poziomu auta na progu do biegu jałowego na postoju.
- `coastAt(kmh)` (dla testów) zwraca `coastLevel`.

### B4. Poprawka z ostatnich wartości auta (zastępuje przesunięcie z F1)
- W `onFuel()`, dla poprawnej wartości w ruchu, **przed** `learn()`:
  - `r = carLph − modelLph(t)`, model z B2/B3 bez żadnych poprawek;
  - osobno dla `DRIVING` i `OVERRUN` (inne tryby pomijasz): `bias += 0,15·(r − bias)`, ograniczone do ±1,0 L/h, z zapamiętanym czasem.
- W oszacowaniu dodaj `bias·exp(−(now − tBias) / BIAS_TAU_MS)` swojego trybu, `BIAS_TAU_MS = 60_000`.
- Na postoju dodaj tylko dodatnią część poprawki jazdy: klimatyzacja albo zimny silnik tak, zjazd z górki nie.
- Poprawka krawędzi z F3 (`edgeUpLph`) zostaje bez zmian i działa po tej poprawce.

### B5. Przejście i wygładzanie
- Pierwsze oszacowanie po zamilknięciu auta (warunki jak w F1) startuje od `lastCarLph`. Różnica do celu (model + poprawka + krawędź) zanika z `HANDOVER_TAU_MS = 3_000` (było 15 s, bo trwałą część różnicy niesie teraz B4).
- Usuń pułap z F2 i z `43ea9093`, a także `lastCarKmh`, jeśli przestanie być potrzebne.
- Wygładzanie w L/h (`SMOOTH_RISE`/`SMOOTH_FALL`) zostaje.

### B6. Jednostka oszacowania (`Estimate.perHour`); tu zawsze decyduje moduł
`perHour = true`, gdy zachodzi któreś z poniższych:
- **postój**;
- **stan zwalniania:**
  - zapala się, gdy `aEff < SLOWING_ENTER_ACCEL = −0,2`, albo w chwili przejścia, gdy `aEff < 0`;
  - gaśnie, gdy prędkość wzrośnie o ponad 2 km/h ponad najmniejszą od zapalenia albo `aEff > 0,3` (logika `slowingSinceHandover`, ale bez pułapu);
- **stan małej prędkości:**
  - zapala się poniżej `LOW_SPEED_ENTER_KMH = 10`, gaśnie powyżej `LOW_SPEED_EXIT_KMH = 13`;
  - liczony w `onSpeed()`, dostępny jako `public boolean lowSpeed()`, bo potrzebuje go etap D.

W pozostałych przypadkach L/100 km jak dziś (z `MAX_L_PER_100KM`).

### B7. Tylko auta z progiem
- `noValueBelow`: licznik „braku wartości” w ruchu przy `kmh ≤ thresholdKmh + 5`. Zapisywany.
- `public boolean thresholdCar()`: `noValueBelow ≥ NO_VALUE_MIN = 20` i `calibrated()`. Etap D używa go do pierwszeństwa jednostek.
- `estimate()` zwraca null, gdy:
  - `!thresholdCar()`;
  - albo `kmh > thresholdKmh + 8`: cisza auta przy wyższej prędkości to usterka, a nie próg, więc oszacowania nie ma.

### B8. Dane auta: API
- `public void setCar(int massKg, int displacementCc)`. Masa poza 500–4000 albo pojemność poza 600–8000 oznacza „nieznane”.
- Zmienia tylko priory i progi kalibracji, nie naukę. Nie trafia do tekstu modelu (jest w ustawieniach).
- Z masą **i** pojemnością `calibrated()` wymaga 30 próbek i 90 s jazdy zamiast 60 próbek i 180 s.

### B9. Zapis: format `3;`
- `3;samples;drivingMs;thresholdKmh;rpmSeen;rpmValid;idleRpm;noValueBelow;edgeUpLph;edgeUpCount`, potem WLS jazdy (6) i WLS `coast` (2).
- `1;` i `2;` czytaj z przeniesieniem nauki:
  1. Starego WLS jazdy (n = 4, priory `{0.8, 0.45, 0.1, 0}`, wagi `{200, 5, 5, 5}`) nie da się przenieść wprost. Rozwiąż go starym wzorem (prywatny pomocnik `legacyDriveLph`).
  2. Dodaj do nowego WLS 35 pseudo-próbek: v ∈ {28, 32, 36, 40, 44, 50, 60} km/h × a ∈ {−0,25; 0; 0,4; 0,8; 1,2}, y = stary model, łączna waga = min(samples, 60).
  3. `coast` przepisz wprost (te same cechy).
  4. `samples = min(samples, MIN_SAMPLES)`, `drivingMs = min(drivingMs, MIN_DRIVING_MS)`, `thresholdKmh` bez zmian.
  5. `noValueBelow = NO_VALUE_MIN`, jeśli `thresholdKmh ≠ 30` (był brak wartości), inaczej 0.
  6. Krawędź = 0, bo była liczona względem starego modelu.
  7. `rpmValid` nieznane (K2 sprawdzi je od nowa).
- Nieznany format daje nowy model, jak dotąd.

### B10. Stałe i Javadoc
- Stałe dodaj jako `static final` obok obecnych, z jednozdaniowymi komentarzami w stylu pliku.
- Javadoc klasy przepisz pod v3: model mocowy, tryby, priory z danych auta, zwalnianie zakotwiczone w biegu jałowym, poprawka z ostatnich wartości, jednostki, tylko auta z progiem, wyniki z 0.1.

### B11. Testy (`FuelModelTest`)
Helpery `drive()`, `hold()` i `ride()` zostają. Dopisz helper jazdy z RPM.

Nowe testy:
1. `slowingDownBelowTheThresholdGoesToTheIdleInLitresPerHour`: auto jak właściciela (zwalnianie 0,9 L/h powyżej 30 km/h), zwalnianie z 35 do 8 km/h. Oczekiwane:
   - `perHour` od pierwszego oszacowania;
   - pierwsze oszacowanie = ostatnia wartość auta w L/h (±0,1);
   - przy 10 km/h wynik w odległości ≤ 0,15 od `idle()`.
2. `aCarThatCutsTheFuelIsNearZeroAtTheThresholdAndRisesToTheIdle`: przy progu < 0,2 L/h, przy 8 km/h > 0,5·`idle()`.
3. `withTheRpmTheIdleWhileRollingIsTheIdleAndEngineBrakingIsZero`:
   - toczenie z RPM ≈ `idleRpm` daje `idle()` (±0,15);
   - auto z odcięciem paliwa przy zwalnianiu z 1800 obr/min daje < 0,2 L/h.
4. `theEngineOffIsZero`: RPM 0 na postoju → `0.0` L/h.
5. `theCarDataMovesThePriorsNotTheLearning`:
   - `setCar(1000, 1000)` kontra `setCar(2000, 3000)`: `idle()` odpowiednio mniejsze i większe, `serialize()` identyczne;
   - przed nauką cięższe auto przy 20 km/h i +0,5 m/s² pali więcej.
6. `theBiasOfTheLastValuesCarriesBelowTheThreshold`: auto przez minutę 0,5 L/h ponad model, potem cisza przy stałych 25 km/h. Oczekiwane:
   - po 10 s i po 60 s oszacowanie ≈ model + 0,5·exp(−t/60 s) (±0,1);
   - po 5 minutach ≈ model (±0,05).
7. `aSilenceAtSpeedIsNoThreshold`: cisza przy 80 km/h → null; auto bez ciszy pod progiem → null, `thresholdCar() == false`.
8. `theUnitFollowsTheSpeedWithAHysteresis`: 9 → L/h, potem 12 → L/h, 14 → L/100 km, potem 12 → L/100 km.
9. `theOldFormatsReadBackCalibrated`: teksty referencyjne `2;` i `1;` z początku etapu dają `calibrated()`, ten sam `thresholdKmh()` i `litresPerHour` w tych punktach różne od zapisanych o mniej niż 0,3 L/h; `4;…` → nowy model.

Testy zmienione (w commicie napisz, co i dlaczego):
- `slowingDownTheEstimateStartsFromTheCarsLastValue` i `aCarThatCutsTheFuelShowsZeroUntilItSpeedsUp`: zastępują je testy 1 i 2;
- `theDifferenceToTheModelFadesAway`: τ poprawki to teraz 60 s, sprawdzaj po 5 minutach;
- `theLevelWhileSlowingDownIsLearned`: ostatnia asercja (poziom przed nauką) według zakotwiczenia;
- `atAStopTheEstimateIsInLitresPerHour`: 3 km/h z kodu to jazda, ale poniżej 10 km/h, czyli L/h;
- `theEdgeCorrectionReadsBack`: prefiks `3;`;
- `theRpmJoinsTheModelWhenTheCarReportsIt`: dodaj przedtem kilka sekund postoju z RPM ~800, żeby RPM przeszło K2.

Pozostałe testy przechodzą bez zmian.

**Commit:** `Fuel estimate v3: power-based model, coasting anchored to the idle, RPM states, the bias of the car's last values, L/h while slowing down and below 10 km/h`

## Etap K: kody znajdowane i sprawdzane same (commit 2)
Dziś prędkość z czytnika jest używana sama, a RPM z czytnika jest zapisany (`ReaderGuesses.rpm`), ale nieużywany. Z RPM trzeba więc wpisywać kod ręcznie. Ujednolicamy to i dokładamy kontrole, żeby błędny kod nie psuł modelu.
1. **RPM jak prędkość:**
   - w `CanbusService` (≈ l. 445–449, przy wyborze `speedCode`) ustaw `rpmCode = rpm > 0 ? rpm : reader != null && reader.rpm > 0 ? reader.rpm : 0`;
   - używaj `rpmCode` zamiast `rpm` w `registerStatsCodes()` (zbiór `wanted`) i w `statsCallback` (`updateCode == rpm`);
   - w oknie kodów pokaż kod czytnika jako podpowiedź: `showCode(rpmCodeInt, rpmCodeStr, reader != null ? reader.rpm : -1)`;
   - podsumowanie oznacza RPM z czytnika tak jak prędkość (`stats_codes_reader_code`).
2. **Wiarygodność RPM w `FuelModel`** (`rpmValid`, zapisywane):
   - sprawdzaj każdą wartość: 0–8000; na postoju (≥ 3 s) 0 albo 450–1500; w ruchu powyżej 20 km/h 600–7000;
   - po 30 sprawdzeniach RPM jest wiarygodne, jeśli ≥ 80 % przeszło, inaczej pomijane;
   - do tego czasu model RPM nie używa;
   - `rpmSeen` w trybach i cechach oznacza teraz `rpmValid`.
3. **Zgodność kodu prędkości z GPS** (`FuelModel.SpeedScale.scale()`):
   - po ≥ 10 porównaniach z GPS, gdy |ln(r / skala)| > ln 1,25 dla wybranej skali, zwróć 0, także dla skali znanej z czytnika (`fixed`);
   - serwis wróci wtedy do GPS (warunek `speedScale.scale() == 0` już istnieje).
4. Testy JVM:
   - `SpeedScale` z kodem, który nie idzie za GPS (np. obroty) → 0;
   - kod RPM o wartościach 0–255 → `rpmValid == false`, a model działa jak bez RPM;
   - wiarygodne RPM → używane.

**Commit:** `Fuel estimate: the RPM code from the code reader like the speed; implausible RPM and speed codes are ignored`

## Etap E: jednostka spalania z protokołu canbus (commit 3)
Kilka protokołów aplikacji canbus przekazuje jednostkę spalania chwilowego (to ten „switch 0–1”). Dla tych aut wygrywa protokół (0.3), bez pola w ustawieniach:

| klasa (decompiled) | skąd jednostka | wartości |
|---|---|---|
| `FordFalconCarInfo` | bit 5 kodów 115 i 116 (wartość to `& 31`) | 0 = L/100 km, 1 = L/h |
| `GmAndraCarInfo` | kod 184 | 1 = l/100 km, 2 = gal/h, w innych przypadkach L/h |
| `Infiniti_XinCheng_CarInfo` | kod 109 | 0 = L/h, 1 = L/100 km |
| `TdTuleCarInfo` | kod 129 | 1 = L/100 km, w innych przypadkach L/h |
| `ActFuel_GM_SiBo` | stała | zawsze L/H |

1. Skrypt `canbus_library/build_canbus_library.py`: w metodzie spalania (ta sama, z której `extract_codes()` bierze kod) rozpoznaj trzy wzorce. Jednostkę gałęzi rozpoznaj po literale w `setText(...)`: `L/H`, `l/h`, `L/h` → `LH`; `L/100km`, `l/100km` → `L100`; inne (gal/h, mpg, km/L) → `OTHER`.
   - zmienna jednostki z osobnego `DataCanbus.DATA[x]` i gałęzie `if`/`switch` po jej wartości → `U <ids> | code <x> | <v>=<jedn.>,…[,*=<jedn.>]`;
   - bit kodu spalania (`(DATA[x] >> b) & 1`) i maska wartości (`DATA[x] & m`) → `U <ids> | bit <b> | mask <m> | 0=<jedn.>,1=<jedn.>`;
   - wszystkie literały metody w jednej jednostce → `U <ids> | fixed <jedn.>`.
   
   Format: wersja `canbus_library 4`, gdy jest choć jeden rekord `U`; bez `U` zostaje 3 (jak reguła wersji 2/3). `--check`, `--diff` i `--merge` znają `U`. Opisz `U` w `canbus_library/README.md`.
2. Przebuduj bibliotekę wbudowaną (`--launcher <repo>`, jak opisano w skrypcie) do `app/src/main/assets/canbus_library.txt`. W raporcie podaj, ile aut dostało `U`. Oczekiwane minimum to klasy z tabeli.
3. Launcher (`CanbusLibrary`):
   - czytaj wersję 4 (1–3 nadal);
   - nowa klasa `FuelUnit` na auto: rodzaj (`code`, `bit`, `fixed`), kod albo bit, maska, mapa wartość → `L100`/`LH`/`OTHER`;
   - spójnie obsłuż import, scalanie, eksport i diff;
   - rozszerz `CanbusLibraryTest`.
4. `CanbusService`:
   - dla `code` rejestruj kod jednostki (zbiór `wanted`) i trzymaj jego ostatnią wartość;
   - dla `bit` dekoduj wartość spalania maską przed `onFuel()` i przed wyświetleniem (to poprawia też dzisiejszy odczyt tych aut);
   - jednostka chwili to `L100`, `LH` albo brak (`OTHER` = brak).

**Commit:** `Canbus library: the unit of the instant consumption where the protocol reports it (format 4)`

## Etap D: jednostka wartości auta (commit 4)
1. Nowa czysta klasa `settings/ConsumptionUnits.java`: `static Shown forCarValue(int value, Unit protocolUnit /* null = nieznana */, boolean thresholdCar, boolean lowSpeed, boolean speedKnown, double kmh, boolean moving)`. Zwraca `{double value, Unit unit}` albo `null`, co znaczy „pokaż jak dziś”.

   Pierwszeństwo (0.3):
   1. `thresholdCar`: decyduje moduł. Wartość auta (jest tylko nad progiem) pokazuj w L/100 km, a poniżej 10 km/h stosuj regułę z punktu 3; oszacowanie ma swoje B6.
   2. `protocolUnit != null`: wartość w jednostce z protokołu (`LH` → L/h, `L100` → L/100 km), bez przeliczania i bez reguły 10/13.
   3. W pozostałych przypadkach, gdy `lowSpeed && speedKnown`, przelicz wartość na L/h:
      - postój, `0 < value ≤ 30`: `value/10` (na postoju L/100 km nie istnieje, więc auto podaje L/h);
      - postój, `value > 30`: `null` (auto mogło zostawić starą wartość L/100 km);
      - `value == 0`: 0;
      - w ruchu `lph = value/10 · kmh/100`; gdy `lph < 0,25` (mniej niż pracujący silnik) i `value ≤ 50`, auto podaje już L/h, więc `value/10`; inaczej `lph`.
   4. Inaczej `null`.
2. `CanbusService.mUpdaterOilExpend()`:
   - użyj `forCarValue()` tam, gdzie dziś widżet pokazuje wartość auta (`0 < value < 3001`), oraz dla 0, gdy nie ma oszacowania;
   - `L/h` → nowy string `instantaneous_consumption_per_hour` / `_mini`, `L/100 km` → jak dziś;
   - po każdej nowej prędkości (`onSpeedCode()`, `onLocation()`) i po zmianie jednostki z protokołu odśwież wartość auta, gdy działa `lowSpeed()`.
3. Stringi `instantaneous_consumption_per_hour` = `%1$s L/h\u0020` oraz `_mini` w `values` i 51 tłumaczeniach. Jednostkę weź z `instantaneous_consumption_idle` danego języka, bez `~`.
4. Testy `ConsumptionUnitsTest`:
   - protokół `LH` przy 50 km/h → L/h bez przeliczenia; protokół `L100` przy 8 km/h → L/100 km;
   - `thresholdCar` z protokołem `LH` → decyduje moduł;
   - bez protokołu: postój 8 → 0,8 L/h; postój 63 → null; 6 km/h i 150 → 0,9; 6 km/h i 8 → 0,8; 9 km/h i 35 → 0,315;
   - bez źródła prędkości → null.

**Commit:** `Fuel widget: the unit the protocol reports wins; else below 10 km/h every car's consumption in L/h`

## Etap W: okno statystyk, ta sama i stała czcionka (commit 5)
Dziś szerokości okna wynoszą: duże `calculatedStatsWidth` (21,75 % `orientationDimension`), średnie 2/3 tej szerokości, małe 1/4. Wysokość wszystkich to `calculatedStatsHeight`.

`CanbusService.fitStatsText()` (≈ l. 1440) zmniejsza `Launcher.textSizeBasic`, aż wiersz „etykieta + wartość + "88"” zmieści się w 95 % szerokości.
- W dużym oknie długie etykiety (`instantaneous_consumption` = „ Fuel consumption:”, `driving_mileage` = „ Cruising range:”) wymuszają mniejszą czcionkę niż w średnim (etykiety „C:” i „R:”) i małym (bez etykiet).
- Czcionka jest liczona raz, z tekstu startowego `0.0 L/100km`. Napisy L/h z etapów B i D są inne (w małym oknie `~0.9 L/h` jest szersze od `0.088`), więc trzeba je uwzględnić.
- Rozmiar czcionki musi być stały: nie może się zmieniać przy zmianie jednostki ani wartości, także gdy nagle robi się więcej miejsca.

1. Nowy pomocnik `settings/StatsWindowSize.java`:
   - `static String[] valueVariants(Resources res, int selector)`: wszystkie napisy wartości danego rozmiaru, sformatowane najszerszą liczbą:
     - `instantaneous_consumption_val`, `_estimated`, `_idle` i `_per_hour` (albo ich wersje `_mini` dla rozmiaru 2), dla L/100 km z liczbą `188.8`, dla L/h z `88.8`;
     - zasięg: `driving_mileage_val` (albo `_mini`) z `8888`;
   - `static int requiredWidthPx(...)`: przy `Launcher.textSizeBasic`, szerokość najszerszego wiersza (etykieta danego rozmiaru + najszerszy wariant), podzielona przez 0,95, plus poziomy padding tła okna;
   - czysta funkcja testowalna w JVM: `static int windowWidth(int baseWidth, int requiredPx, int screenWidth, int margin)` = `clamp(max(base, required), base, min(screenWidth − 2·margin, round(1,35·base)))`.
2. Szerokość okna dla każdego z trzech rozmiarów to `windowWidth(udział jak dziś, requiredWidthPx(…), …)`:
   - w `saveStatsPrefs()` wszystkich trzech edytorów (`DrawViewOtherScreens`, `DrawViewFirstScreen`, `DrawViewAppStats`), zamiast dzisiejszego `switch`;
   - w `CanbusService` przy tworzeniu okna, z rozmiaru (`STATS_WIDTH_SELECTOR` / `APP_STATS_WIDTH_SELECTOR`) zamiast zapisanej szerokości, żeby stare zapisy też się poprawiły;
   - lewą krawędź przesuń tak, żeby okno zostało w ekranie;
   - podgląd w edytorze i okno na ekranie mają tę samą szerokość.

   W praktyce duże okno będzie nieco dłuższe, aż napis zmieści się w standardowej czcionce (najwyżej o 35 %). Średnie i małe zmienią się tylko wtedy, gdy nie mieszczą wariantu L/h.
3. `fitStatsText()`:
   - mierzy najszerszy wariant (punkt 1) zamiast bieżącego tekstu;
   - liczy czcionkę raz, przy tworzeniu okna, tak jak dziś;
   - poza tworzeniem okna nic nie wywołuje `setTextSize` na tych widokach (sprawdź `mUpdaterOilExpend`, `showFuelEstimate`, `mUpdaterDrivingMileage`).

   Czcionka zostaje stała przy zmianie L/100 km ↔ L/h i przy każdej wartości. W tych samych warunkach jest taka sama we wszystkich trzech rozmiarach. Zmniejsza się tylko wtedy, gdy nawet 1,35 szerokości nie wystarcza, i wtedy też jest stała.
4. Testy JVM `StatsWindowSizeTest` dla `windowWidth`: wymagana < bazowej → bazowa; między → wymagana; ponad limit → limit; wąski ekran → ekran − 2·marginesy.
5. Kontrola ręczna:
   - FYT 1024×600, 1280×720, 1920×720 i telefon, po polsku i po angielsku, wszystkie trzy rozmiary;
   - czcionka jest taka sama, a napisy mieszczą się w jednej linii;
   - przy przełączeniu `L/100km` ↔ `L/h` (postój, < 10 km/h, zwalnianie pod progiem) nie zmienia się ani czcionka, ani okno;
   - okno nie wychodzi poza ekran.

**Commit:** `Stats window: the widths follow the widest text of each size, so the font is the same in all three and does not change with the unit`

## Etap A: dane auta w ustawieniach (commit 6)
1. Przywróć z `1e5cbd27^` (`git show 1e5cbd27^:<ścieżka>`):
   - `Keys.EXTRA_STATS_CODES = "extra_stats_codes"`;
   - preferencję `extra_stats_codes` w `creator_preferences.xml`, zaraz po `stats_codes`;
   - widoczność jak dawniej: `extraStatsCodes.setVisible(userStatsBool)` i przełącznik `user_stats` (stary `SettingsFragmentSecond` ≈ l. 568, 1456, 1487);
   - stringi słowo w słowo, w `values` i 51 tłumaczeniach: `extra_stats_codes`, `canbus_optional`, `canbus_optional_description`, `vehicle_mass_code_text`.
2. Okno: odbuduj `dialog_extra_codes_layout.xml` i `displayExtraCodesDialog()` (stare ≈ l. 1821) według **obecnego** `displayCodesDialog()`, nie starego:
   - `lightDialog()` + `LayoutInflater.from(builder.getContext())`;
   - etykiety `setMaxWidth(40 % dialogWidth())`, `fitDialogWindow()`, czarny tekst;
   - Set, Done i anulowanie zapisują wszystkie pola (`Runnable` jak `saveCodesWindow`).

   Zawartość okna:
   - pola: `vehicle_mass_code_int` (kg, przywrócony klucz) i `engine_displacement_code_int` (cm³, nowy), `inputType="number"`, zapis jak `saveCode()` (klucz = nazwa id);
   - pod polami `canbus_optional_description` i `car_data_source`;
   - bez RPM (jest w oknie kodów) i bez mocy.
3. Nowe stringi z prawdziwymi tłumaczeniami, w `values` i 51 językach:
   - `engine_displacement_code_text`: „Engine displacement (in cm³):” / pl „Pojemność silnika (cm³):”;
   - `extra_stats_codes_summary` (nowe argumenty): „Car data for the fuel estimate where the car shows none. Mass: %1$s, engine displacement: %2$s” / pl „Dane auta do szacowania spalania tam, gdzie auto go nie podaje. Masa: %1$s, pojemność silnika: %2$s”. Argumenty to „1300 kg”, „1598 cm³” albo `stats_codes_not_set`;
   - `car_data_source`: „Both are in the registration certificate: the mass in running order (field G) and the engine capacity (field P.1).” / pl „Obie wartości są w dowodzie rejestracyjnym: masa własna (pole G) i pojemność silnika (pole P.1).”
4. `CanbusService`:
   - w `loadFuelModel()` wywołaj `fuelModel.setCar(…)` z prefs (puste albo 0 = brak, `NumberFormatException` = 0);
   - dodaj statyczną `carDataChanged()` (wzór: `resendRequestAfterWake()`, `sInstance`, wątek główny) i wołaj ją po zapisie okna, żeby zmiana działała bez restartu.
5. Kontrola ręczna:
   - okno czytelne na telefonie i na FYT, pola się mieszczą;
   - podsumowanie pokazuje wartości;
   - zmiana masy działa bez restartu.

**Commit:** `Fuel estimate: the car's mass and engine displacement in the settings (optional)`

## Etap C: nachylenie drogi z wysokości (commit 7)
1. Nowa czysta klasa `settings/RoadGrade.java`:
   - `onAltitude(long t, double distanceM, double altitudeM, double sigmaM)`, pomija punkty z σ > 25 m;
   - `double grade(long now, double distanceM)` zwraca sinθ ≈ dh/ds:
     - bierze punkty z ostatnich 150 m drogi i ≤ 120 s;
     - potrzebuje ≥ 3 punktów i rozpiętości ≥ 50 m, inaczej 0;
     - liczy ważoną regresję h(s) (wagi 1/σ²) i jej wariancję z reszt;
     - kurczy wynik do zera: `ĝ·τ²/(τ² + var)`, τ = 0,04;
     - ogranicza do ±0,12;
     - zwraca 0, gdy ostatni punkt jest starszy niż 10 s albo dalej niż 100 m.
2. `FuelModel`:
   - `onSpeed()` całkuje drogę (s += v·dt, dt ≤ 2 s);
   - `onAltitude(t, altitudeM, sigmaM)` przekazuje punkt do `RoadGrade`;
   - `aEff` używa `grade(now, s)` w trybach, cechach i nauce.
3. `CanbusService.onLocation()`: gdy `hasAltitude()`, przekaż `getAltitude()` i `getVerticalAccuracyMeters()` (bez `hasVerticalAccuracy()` przyjmij 10 m), także gdy prędkość idzie z kodu.
4. Barometr, jeśli jest (`Sensor.TYPE_PRESSURE`):
   - wysokość `SensorManager.getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, p)`, średnia z ~1 s, σ = 0,5 m;
   - gdy barometr jest świeży (≤ 5 s), model nie bierze wysokości z GPS;
   - wyrejestruj w `onDestroy()`.
5. Czytnik (`CanbusCodeInspector`, `CanbusCodeEstimator.GpsFix`):
   - fix zapisuje wysokość i dokładność (nowy konstruktor, stare zostają);
   - nagłówek: `GPS speed: N fixes, with bearing: N, with altitude: N`;
   - po kodach nowa sekcja `GPS:`, jedna linia na fix: `yyyy-MM-dd HH:mm:ss.SSS: <km/h> km/h, <kurs>°, <wys.> m ±<σ> m`;
   - **bez szerokości i długości geograficznej** (prywatność).

   Obecne nagrania nie mają wysokości, a dzięki temu da się sprawdzić nachylenie na kolejnych.
6. Testy JVM (`RoadGradeTest`, `FuelModelTest`):
   - górka 5 % z szumem σ = 3 m → 0,05 ± 0,015;
   - płasko z σ = 10 m → |g| < 0,01;
   - za krótki odcinek → 0;
   - pod górę przy stałych 20 km/h model pali więcej niż płasko;
   - zjazd −6 % przy stałych 25 km/h daje tryb `OVERRUN`;
   - `CanbusCodeEstimatorTest` przechodzi bez zmian.

**Commit:** `Fuel estimate: the road grade from the GPS altitude or the barometer; the code reader records the altitude`

## Weryfikacja i raport
- **Testy lokalne.** Gradle w tym środowisku nie działa. Uruchamiaj `javac` i JUnit console standalone 1.10.2 z katalogu `app/`:
  - classpath `../android_jar/android-36.jar`;
  - stub `androidx.preference.PreferenceManager` dla `CanbusLibrary` (jeśli go nie ma, napisz jednolinijkowy stub w scratchpadzie);
  - uruchom co najmniej `FuelModelTest`, `RoadGradeTest`, `ConsumptionUnitsTest`, `StatsWindowSizeTest`, `CanbusCodeEstimatorTest`, `CanbusLibraryTest` i `CodePairChooserTest`.
- **Skrypt biblioteki:** `py build_canbus_library.py --check` na nowej bibliotece wbudowanej, `--diff` ze starą (różnią się tylko rekordy `U` i nagłówek).
- **Odtworzenie nagrań** (scratch, nie commituj), jeśli są pliki `/root/.claude/uploads/113ab8c6-8f22-5568-95ab-103f6faca20b/*CanbusCodes*.txt`:
  - wzór: `/tmp/claude-0/-home-user-FYT-Launcher-Mod/113ab8c6-8f22-5568-95ab-103f6faca20b/scratchpad/FuelReplayScratchTest.java` (kod 91 = spalanie, 510 = prędkość/100);
  - każde nagranie testuj na modelu uczonym na pozostałych;
  - podaj błąd średni L/h przy 28–45 km/h (przyspieszanie / stała / zwalnianie), skok przy powrocie wartości i błąd w chwili zamilknięcia;
  - punkt odniesienia z 0.1: 0,48 (0,72 / 0,39 / 0,31), skok 0,67, zamilknięcie 0,38;
  - v3 nie może być w żadnej grupie gorszy o więcej niż 0,03 L/h;
  - jeśli plików nie ma, napisz to w raporcie.
- **CI:** push dopiero na zielonym poprzednim runie. Czerwony build naprawiaj nowym commitem, bez amend i force-push.
- **Raport dla właściciela (po polsku):**
  - numery runów CI z APK i wyniki testów;
  - liczby z odtworzenia nagrań i liczba aut z jednostką z protokołu;
  - czego się spodziewać w aucie:
    - przy zwalnianiu poniżej ~30 km/h widżet pokazuje „~0.9 L/h”, potem wartość schodzi powoli do biegu jałowego (~0.8), bez rosnących L/100 km;
    - poniżej 10 km/h zawsze L/h, powyżej 13 km/h znów L/100 km;
    - auta, których protokół podaje jednostkę, pokazują ją tak, jak podaje auto;
    - duże okno statystyk jest nieco dłuższe i ma tę samą czcionkę co średnie i małe; czcionka nie zmienia się przy zmianie jednostki;
    - przy ruszaniu i przyspieszaniu pod progiem widżet pokazuje L/100 km z modelu; skok na progu jest mniej więcej taki, jak zwykła zmiana wartości auta z sekundy na sekundę (~1,5 L/100 km), i maleje z czasem;
    - kod RPM z czytnika działa bez wpisywania, a błędne kody prędkości i RPM są pomijane;
    - po wpisaniu masy i pojemności oszacowanie pojawia się szybciej, a bieg jałowy pasuje do silnika;
    - nachylenie działa od razu, ale jego skuteczność sprawdzimy dopiero na nowych nagraniach, bo czytnik zapisuje teraz wysokość;
    - stary model wczyta się z przeniesioną nauką (format 1/2 → 3).
