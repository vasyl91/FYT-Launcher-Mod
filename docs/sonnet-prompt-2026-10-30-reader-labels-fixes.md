# Launcher Mod: czytelne nazwy kategorii czytnika i drobne poprawki po jeździe próbnej — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Ostatnie commity kodu: `98bf89fa` (eksport), `ca201326` (pary kodów S), `6e6a2a51` (asset z dwóch wersji). Numery linii są orientacyjne (≈), więc sprawdzaj je w kodzie.

Zrób **jeden commit** (punkty H1–H5 razem). Wypchnij go na tę gałąź. **Nie twórz pull requesta.**

## 0. Fakty z jazdy 30-10-2026 (auto `1507667`, stary `com.syu.ms`)

**Zapis czytnika** (`CanbusCodes20261030_093752.txt`, 300 s, 74–113 km/h; nie ma go w repo):
- 91 = spalanie chwilowe, 269 zmian, 0–89 (×10), w ramce 0x33 BE16;
- 92 = zasięg, stale 210;
- 102 = 2 i 103 = 62, po jednym zdarzeniu bez zmian. `CodePairChooser` ich nie potwierdzi i na tym radiu wybierze 91/92, tak jak trzeba;
- 510 = prędkość ×100 (r=0,99 z GPS), 512 = przebieg (+1), 1033 = kurs.

Linie z raportu, które trzeba poprawić:
```
Code 91 - fuel consumption, instant (0.1-8.9 L/100 km as value/10, 269 changes)
Not found: fuel consumption, average, RPM, coolant temperature, ...
Code 1033 - heading, degrees (119-168 degrees, ...)
Code 513 - range, value/10 km (8 changes)
```
- Przecinek w nazwie kategorii czyta się jak dwie pozycje listy.
- **Kod 513** na tym aucie nie jest zasięgiem. Wartości: `118, 1399, 120, 121, 122, 123, 124, 125, 46462`, każda zmiana w tej samej chwili co krok przebiegu 512. To licznik trasy z dwiema śmieciowymi wartościami. Nazwa pochodzi z tabeli `ConstRzcAddData` (`CanbusCodeEstimator.java` ≈ l. 834).

**Raport importu** (`canbus_library_success_30-10-2026_09-21-55.txt`):
- `File: canbus_library_2026-10-30_08-48-14.txt (0 bytes)`: dostawca dokumentów podał `OpenableColumns.SIZE` = 0;
- `Header: canbus_library 2`: to stała `CanbusLibrary.HEADER`, a nie nagłówek importowanego pliku (`CanbusLibraryImport.java` ≈ l. 316).

**Eksport** (`canbus_library_export_2026-10-30_09-22-38.txt`): komentarz `# Exported ... 8472 records, ...` stoi przy stopce `end 631 ...`. 8472 to `Library.recordCount()` (C, N i S per auto, R per auto i stronę), a 631 to linie rekordów. Dwie różne liczby pod tą samą nazwą mylą.

**Widżet spalania:** poniżej ~30–40 km/h przed wartością stoi `≈` (oszacowanie FuelModel, `values/strings.xml` ≈ l. 226–229). Czcionka radia rysuje ten znak jak „=”, więc właściciel czyta go jako błąd.

**Zasady** (jak w `docs/sonnet-prompt-2026-10-30-canbus-library-update.md`, sekcja „Zasady”):
- commit po angielsku, z trailerami sesji, bez nazwy modelu w treści;
- tylko do odczytu: `.github/workflows/*`, `app/src/main/generated/baselineProfiles/`, `decompiled_*/**`, `fuel_stats_example/`;
- nowe stringi tylko w `values/strings.xml`;
- logika w czystej Javie z testami JVM;
- StrictMode: bez I/O na wątku głównym.

## H1. Nawiasy w nazwach kategorii (`settings/CanbusCodeEstimator.java`)

1. W `enum Category` (≈ l. 30–40):
   - `fuel consumption, instant` → `fuel consumption (instant)`;
   - `fuel consumption, average` → `fuel consumption (average)`;
   - `heading, degrees` → `heading (degrees)`.
2. W `ADD_ON_NAMES` (≈ l. 834–837):
   - 520 → `fuel consumption (instant)`;
   - 521 → `fuel consumption (average)`;
   - 510 `speed, value/100 km/h` → `speed (value/100 km/h)`;
   - 513 `range, value/10 km` → `range (value/10 km)`.

   Przejrzyj całą tabelę i zamień każdy przecinek wewnątrz jednej nazwy na nawias.
3. W `Guess.toString()` (≈ l. 103) uzasadnienie idzie po dwukropku, żeby nawias nie stał obok nawiasu:
   `Code 91 - fuel consumption (instant): 0.1-8.9 L/100 km as value/10, 269 changes`.
   Linie bloku add-on (≈ l. 1009) zmieniają się tak samo: `Code 510 - speed (value/100 km/h): 247 changes`.
4. Popraw Javadoc z przykładami (≈ l. 100, 127) i testy, które sprawdzają teksty:
   - `CanbusCodeEstimatorTest.java` ≈ l. 54 i 146;
   - grep po `fuel consumption, ` i `heading, ` w `app/src/test`.
5. Sprawdź grepem, że nazwy kategorii nie są nigdzie parsowane (`ReaderGuesses`, `CanbusCodeInspector`, `SettingsFragmentSecond`). Przy pisaniu briefu były tylko do wyświetlania.

## H2. Wartości kodu add-on, które nie pasują do nazwy (513)

W `CanbusCodeEstimator`, przy budowaniu linii bloku add-on (≈ l. 1004–1013), dla kodu nazwanego zasięgiem (513) dopisz uwagę, gdy wartości nie wyglądają na zasięg:
- `(not like a range: rises by 1 with the mileage)`, gdy kolejne wartości poza odstającymi tylko rosną o 1. Odstająca wartość różni się od mediany zapisu o ponad 1000;
- `(not like a range: values jump, e.g. 46462)`, gdy są skoki ponad 2000 bez takiego wzorca.

Zasada jest ogólna: dotyczy każdego auta, nie tylko 1507667. Potrzebne dane (próbki kodu) są już w metodzie, z której powstaje `Result`. Nie zmieniaj zgadywania kategorii, tylko tekst linii add-on.

**Test JVM:** próbki 513 z faktów (`118, 1399, 120..125, 46462`) dają uwagę o liczniku. Zasięg malejący co 10 (`310, 300, 290`) uwagi nie dostaje.

## H3. Raport importu (`settings/CanbusLibraryImport.java`, `CanbusLibrary.ParseResult`)

1. Rozmiar `<= 0` → `size unknown` (≈ l. 311). Sprawdź też, że `fileSize` 0 nie trafia do `parse` jako 0 bajtów. `MAX_BYTES` i postęp mają wtedy dostać -1 (≈ l. 159–160: `size > 0 ? size : -1`).
2. `ParseResult` dostaje pole `version` (nagłówek pliku 1/2/3; 0, gdy nagłówka nie było):
   - wypełnij je w `CanbusLibrary.Parser.result()` (≈ l. 942);
   - zaktualizuj drugie wywołanie konstruktora w `CanbusLibraryImport` (`new CanbusLibrary.ParseResult(null, errors, 0, 0, -1, null, null)` i drugie przy błędzie zapisu).
3. Linia raportu: `Header: canbus_library <version>`, a bez nagłówka `Header: none`.
4. **Test JVM:** `parse` pliku w wersji 1, 2 i 3 daje `version` 1, 2 i 3.

## H4. Komentarz eksportu (`CanbusLibrary.exportText`, ≈ l. 720)

Zmień tekst na:

`Exported by the launcher on <data>: <L> record lines (<N> records per car), <C> cars with a class, <R> with a request.`

- `<L>` to liczba linii `C`/`R`/`N`/`S`, którą policzy `seal`, czyli to samo co w stopce. Policz je z wyniku `serialize()` (linie zaczynające się od `C `, `R `, `N `, `S `) albo dodaj w `Library` metodę liczącą linie tak samo jak `serialize`.
- Test `theExportHasACommentAfterTheHeaderAndReadsBackAsTheSameLibrary` sprawdza, że `<L>` równa się `ParseResult.recordLines` i liczbie w stopce.

## H5. Znak oszacowania (`values/strings.xml` ≈ l. 226–229)

W czterech stringach zamień `≈` na `~`:
- `instantaneous_consumption_estimated`;
- `instantaneous_consumption_estimated_mini`;
- `instantaneous_consumption_idle`;
- `instantaneous_consumption_idle_mini`.

`~` jest w każdej czcionce i nie myli się z „=”. Sprawdź, czy `≈` nie stoi gdzieś jeszcze (`grep -rn "≈" app/src/main`): w kodzie zostaje, w tekstach widocznych na radiu zmień.

**Commit:** `Canbus reader: readable category names; small fixes of the import report, the export and the estimate sign`

## Weryfikacja i raport końcowy

- **Przed pushem:**
  - lokalnie testy JVM: `CanbusCodeEstimatorTest`, `CanbusLibraryTest`, `CodePairChooserTest`, `CanbusFramesTest`, `FuelModelTest`, `ReaderGuessesTest`;
  - `py canbus_library/build_canbus_library.py --check app/src/main/assets/canbus_library.txt`.
- **CI:** push dopiero na zielonym poprzednim runie. Czerwony build naprawiaj nowym commitem, bez amend i force-push.
- **Raport dla właściciela (po polsku):**
  - numer runu CI z APK;
  - przykładowe nowe linie raportu czytnika;
  - przypomnienie, czego się spodziewać na aucie: po kilku minutach jazdy okno „Kody canbus” pokazuje `Library: 102/103, 91/92 — in use: 91/92 (confirmed)`, zapytanie nadal `70:51; 29:0`, a oszacowanie poniżej ~30 km/h ma przed sobą `~`.
