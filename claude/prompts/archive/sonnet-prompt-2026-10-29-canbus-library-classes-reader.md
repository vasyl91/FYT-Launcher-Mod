# Launcher Mod: CanbusClasses tylko z biblioteki, kody spalania i zasięgu w bibliotece, skaner bez zer, lepsze oszacowania i ramki CAN-boxa — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`
(ostatni commit właściciela to `d2902de3`).

Zrób pięć commitów w kolejności D1 → D5. **Każdy commit musi się budować samodzielnie.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.**

Numery linii to stan z `d2902de3` i są orientacyjne (≈). Zawsze sprawdzaj je w kodzie.

## 0. Cel, fakty i decyzje właściciela

Poprzednia runda (`9a05cfce..ee0e7a0e`) dodała bibliotekę canbus (`app/src/main/assets/canbus_library.txt`, skrypt
`canbus_library/build_canbus_library.py`, `settings/CanbusLibrary.java`, import `CanbusLibraryImport.java`), skaner kodów
z oszacowaniami (`CanbusCodeInspector`, `CanbusCodeEstimator`) i przycisk „Stop logcat”. Działa na aucie właściciela.
Format biblioteki, reguły scalania i skrypt opisuje `canbus_library/README.md`. Przeczytaj go, zanim zaczniesz.

**Auto właściciela i jego logi** (4 zapisy skanera po 300 s, 29-10-2026; nie ma ich w repo, potrzebne liczby są niżej):
- `Car: id 1507667 (protocol 339, car 23)`, klasa `com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi`, callback
  `Callback_0339_RZC4_PSA_ALL`, wysłane zapytanie `70:51; 29:0`, GPS: 91–300 odczytów na zapis.
- `com.syu.ms` zgłasza 309 kodów, z czego **270–289 przez cały zapis tylko 0**. To ogromna część każdego pliku.
- `FinalCanbus.U_CNT_MAX = 1200`, tak samo w launcherze i w `decompiled_com.syu.canbus`, więc **0..1199 to cały moduł canbus**.
  Najwyższy kod w logach to 1037. Zakresu skanera nie zmieniaj.
- Kody pewne (potwierdził właściciel):
  - **91**: chwilowe spalanie, L/100 km ×10. **65535 = brak wartości**, co zdarza się poniżej ~40 km/h. Średnie |Δ| wynosi 6–23,
    a kroki o ±1 to tylko 4–18 % zmian;
  - **92**: zasięg w km, zmienia się **co 10 km** (310→300→290, raz 300→310), w 5 minut zero, jedna albo dwie zmiany;
  - **512**: przebieg całkowity w km, kroki dokładnie **+1**. Pierwsza wartość po rejestracji bywa **0** (0 → 108782).
- **510 to prędkość ×100 km/h**: wartości są wielokrotnościami 100, w mieście 0–4300, na autostradzie 8400–12400.
- Blok 500–560 to dane „add-on” CAN-boxów RZC (`decompiled_com.syu.canbus/classes.dex/sources/com/syu/carinfo/rzc/addcan/ConstRzcAddData.java`):

  | kod | nazwa | kod | nazwa |
  |---|---|---|---|
  | 501 | numer nadwozia (VIN) | 513 | zasięg (wartość/10 km) |
  | 502 | światła pozycyjne | 514 | pas kierowcy |
  | 503 | światła mijania | 515 | pas pasażera |
  | 504 | światła drogowe | 516 | ACC |
  | 505 | kierunkowskaz lewy | 517 | światła |
  | 506 | kierunkowskaz prawy | 518 | bieg wsteczny |
  | 507 | przeciwmgielne przednie | 519 | hamulec ręczny |
  | 508 | przeciwmgielne tylne | 520 | spalanie chwilowe |
  | 509 | wycieraczki | 521 | spalanie średnie |
  | 510 | prędkość (wartość/100 km/h) | 522 | temperatura płynu |
  | 511 | średnia prędkość | 523 | temperatura oleju |
  | 512 | przebieg | 524 | obroty silnika |
  | 553–558 | drzwi | 525 | napięcie |
  | 559 | jednostka prędkości | | |

  W logach 518 zmienia się dokładnie przy wstecznym, a 524 przez cały czas wynosi 0.
- **Kod 1019 u tego auta niesie surowe ramki CAN-boxa RZC.** Każde zdarzenie to `ints` = `[0xFD, len, cmd, dane…, suma]`:
  - `len` to liczba bajtów po `0xFD`, a `suma = (len + cmd + dane) & 0xFF`;
  - ramka bywa rozbita na dwa zdarzenia, a jedno zdarzenie może zawierać kilka ramek po sobie.

  Typy ramek z logów:
  - `0x7D`, `dane[0]=3`, len 8: `dane[1..2]` LE16 = **kod 510**, np. `[253,8,125,3,184,11,0,0,75]` → 3000;
  - `0x7D`, `dane[0]=4`, len 7: `dane[1..3]` LE24 = **kod 512**, np. `[253,7,125,4,238,168,1,31]` → 108782;
  - `0x33`, len 12: BE16 `dane[0..1]` = **kod 91** (`255,255` = 65535), BE16 `dane[2..3]` = **kod 92**,
    np. `[253,12,51,0,70,1,54,0,0,0,0,0,188]` → 70 i 310;
  - pozostałe: `0x7D/8` (małe liczby ze znakiem, 16-bit), `0x7D/1`, `0x7D/6`, `0x3A`, `0x36` (11–14), `0x02`;
  - podczas cofania dochodzą `0x29` (16-bit ze znakiem, prawdopodobnie kąt kierownicy) i `0x32` (prawdopodobnie czujniki parkowania).

  **Żadna ramka nie zawiera obrotów**: ten CAN-box nie wysyła RPM dla tego auta.
- **1019 nie jest kodem uniwersalnym.** `FinalCanbus` nazywa z zakresu ≥ 1000 tylko 1000–1008, 1015 i 1021, a 1019 nie występuje
  ani w aplikacji canbus, ani w jarach FYT. Treść zależy od protokołu CAN-boxa (XP/Raise, Hiworld i inne mają inne ramki).
  **Kanał ramek wykrywa się po treści, nigdy po numerze** (decyzja 6).
- **1033** nie jest używany w żadnym kodzie aplikacji. Wygląda na L/100 km ×10:
  - w mieście skacze (3,2–35,5, |Δ| ≈ 21–29);
  - na autostradzie jest gładki (8,8–11,0 i 11,9–17,9; kroki ±1 to 62–82 %);
  - hipoteza L/h się nie potwierdziła (stosunek ≈ 3).

  Znaczenie pozostaje nieznane, prawdopodobnie to jakaś średnia.
- **Obecny estymator myli się na tych logach:**
  - 91 przepada przez 65535 (`max > 3000`);
  - 510 dostaje etykietę „RPM (0-4300)” z braku skali, a na autostradzie nie ma żadnej;
  - 92 przepada (kroki 10, mniej niż 3 zmiany);
  - 512 przepada przez wiodące 0;
  - kody 0/1 (502, 503, 99, 100, 518) dostają etykietę „outside temperature”;
  - 1033 trafia jako spalanie chwilowe.
- **Strony spalania w źródłach:**
  - `decompiled_carinfo/.../rzc/biaozhi408/RZC_BZ408OilMilePage1Acti.java` czyta `DATA[102]` w `mUpdaterOilExpend()`
    i `DATA[103]` w `mUpdaterDrivingMileage()`;
  - ta sama klasa w `decompiled_com.syu.canbus/classes.dex/sources/...` czyta `DATA[91]` i `DATA[92]`, czyli kody auta właściciela;
  - wbudowana biblioteka da więc temu autu 102/103, a biblioteka zbudowana z aplikacji właściciela 91/92 (scalenie: wygrywa plik).
- Inne nazwy metod w stronach z biblioteki to m.in.:
  - `currentOilConsumption` (Honda, 98), `updaterOilConsumption` (Xp_374, 98);
  - `lastMile` (Honda, 103), `updaterDrivingMileage` (Xp_374, 99);
  - `mUpdaterAverageOil` (Golf7, średnia, 97), `mUpdaterDivedMile` (RzcFYT, przejechany dystans).
- Właściciel widział w polach cmd okna „Kody canbus” **podpowiedzi** (`setHint`, pierwsze zapytanie), a nie wpisane wartości.

**Decyzje właściciela (nie zmieniaj ich):**
1. `CanbusClasses` traci przełącznik (`className(int)`, ≈94–5111). **Jedynym źródłem klas jest biblioteka.**
2. Dla `--launcher` **wzorcem klas jest obecny asset**: rekordy C i N skrypt czyta z niego, a strony (R) i kody (S, D2)
   liczy na nowo z `decompiled_carinfo/`.
3. Biblioteka zna kody spalania i zasięgu auta.
   - W oknie „Kody canbus” pola Fuel i Range dostają podpowiedź z biblioteki, gdy w ustawieniach jest pusto albo „0”.
   - Puste albo „0” oznacza „kod z biblioteki”: tak liczy statystyki serwis.
   - Pola zostają edytowalne, a wpisany kod zawsze wygrywa.
4. Skaner dostaje przełącznik **„pomiń kody, które przysłały tylko 0”**, **domyślnie włączony**. Nagłówek pliku podaje, ile kodów pominięto.
5. Oszacowania poprawić na podstawie faktów powyżej (D5).
6. **Ramki CAN-boxa rozpoznawać po treści, dla każdego kodu.** Tylko kod rozpoznany jako kanał ramek wypada z oszacowań
   i dostaje sekcję z rozbiorem ramek. Każdy inny kod, w tym 1019 w innym aucie, zostaje zwykłym kodem.
7. **Nowe stringi tylko w `app/src/main/res/values/strings.xml`.** Tłumaczeniami zajmie się właściciel.

## 1. Zasady pracy i konwencje repo (jak w poprzednich rundach)

- **Commity po angielsku**:
  - temat `<Obszar>: <co>` (tematy przy krokach), treść zawinięta na ~72 znaki;
  - w treści napisz *dlaczego* (fakty z §0);
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push** po każdym commicie: `git push -u origin ccr-087eed00-gbqsuz`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
  - **Następny commit wypychaj dopiero po wyniku CI poprzedniego.** Workflow ma `cancel-in-progress`, więc nowy push anuluje trwający run
    (w poprzedniej rundzie stracił się tak wynik jednego commita). Możesz commitować lokalnie, ale pushuj dopiero po wyniku.
  - CI: `.github/workflows/build.yml` (`testFytDebugUnitTest`, `assembleFytDebug`, `assembleStandardDebug`), ok. 6 min.
  - Sprawdzaj przez GitHub MCP: `actions_list`, `actions_get` (`get_workflow_job`) i `get_job_logs` z `tail_lines` ≤ 150
    (szukaj `error:`; większe porcje to głównie stack trace Gradle).
  - Czerwony build naprawiaj kolejnym commitem, bez amend i force-push.
- **Nie ruszaj**:
  - `.github/workflows/*` ani commita `[BRANCH-ONLY]`;
  - `app/src/main/generated/baselineProfiles/`;
  - `decompiled_carinfo/com/**`, `decompiled_com.syu.canbus/**`, `decompiled_FYT_jars/`, `fuel_stats_example/` (tylko do czytania).
- **Stringi**:
  - nowe klucze tylko w `values/` (EN);
  - klucz, który przestaje być używany, usuń w `values/` i we **wszystkich** `values-*/` w tym samym commicie (skryptem, cały element);
  - poza tym nie edytuj `values-*/`.
- **Usuwaj dopiero po `rg`** w całym `app/src` (`--glob '!**/generated/**'`). Wynik oglądaj **bez `head`** i bez filtrów, które mogą coś ukryć:
  w poprzedniej rundzie przez to został w kodzie usunięty symbol i build padł.
- **Testy JVM**: JUnit 5, `unitTests.isReturnDefaultValues = true`. Parser, scalanie, estymator i dekoder ramek pisz w **czystej Javie**.
- **Kontrola lokalna (bez Android SDK).** Działa i oszczędza cykle CI:
  - pobierz `junit-platform-console-standalone-1.11.4.jar` z Maven Central (przez proxy) do scratchpada;
  - kompiluj `javac -proc:none -cp android_jar/android-36.jar:<junit>` z małymi stubami w scratchpadzie
    (np. `LauncherApplication`, `DataCanbus`, `PreferenceManager`, `AsyncTask`);
  - uruchamiaj `java -jar <junit> execute --class-path <out>:android_jar/android-36.jar --scan-class-path <out>` z katalogu `app/`
    (test assetu czyta `src/main/assets/...`).
  - Stub `LauncherApplication` niech **nie** dziedziczy po `Application`: ładowanie klas z `android-36.jar` w JVM kończy się
    „Absent Code attribute”.
- **StrictMode jest włączony także w release.** Żadnego I/O plików, assetów ani `ContentResolver` na wątku głównym. Bibliotekę czytasz
  przez `CanbusLibrary.loadBlocking()` (nie na wątku głównym), `cached()` albo `whenLoaded()`.
- Bez nowych zależności. Duże pliki (`SettingsFragmentSecond` ≈2300 linii, `CanbusService` ≈1400, `CanbusLibrary` ≈1270) edytuj punktowo.

## D1 — `Canbus: the library is the only list of the cars' classes`

1. **Skrypt, tryb `--launcher`** (`build_canbus_library.py`, `main()` ≈1352, `build()` ≈1113, `build_mapping()` ≈470):
   - zamiast symulacji przełącznika `CanbusClasses.className` czytaj `app/src/main/assets/canbus_library.txt` tą samą walidacją co
     `--check` (`check_text()` ≈940). Niepoprawny asset albo brak pliku → komunikat i kod wyjścia 1;
   - rekordy **C** (z alternatywą i warunkiem) i **N** bierz z assetu bez zmian;
   - rekordy **R** licz od nowa z `decompiled_carinfo/` jak dotąd: BFS od klas C, ten sam `PAGE_NAME_RE`, ta sama kolejność;
   - komentarz nagłówka: `# Source: app/src/main/assets/canbus_library.txt (classes) + decompiled_carinfo (pages)`;
   - plik wynikowy w tym trybie domyślnie nadpisuje asset, jak dotąd;
   - tryb `<src>` z dekompilatu `com.syu.canbus` się nie zmienia (dalej symuluje `switch (DataCanbus.DATA[1000])` w `ActivityLauncher`);
   - usuń z trybu `--launcher` wszystko, co czytało `CanbusClasses.java` i `FinalCanbus.java`, ale symulację przełącznika zostaw
     (potrzebna dla `<src>` i `--mapping`).
2. **Asset**: wygeneruj go raz w tym commicie (`--launcher .`). Różnić się może tylko komentarz nagłówka. Sprawdź to `diff`em
   przed i po (rekordy C/R/N identyczne, ten sam CRC poza zmianą komentarza).
3. **`CanbusClasses.java`**:
   - usuń `className(int)` z całym przełącznikiem (≈88–5111) i niepotrzebne importy;
   - zostają `determineClassName()`, `refresh()`, `saveClassName()`, `hasNoScreenOfItsOwn()` (411/LandRover) i `readFile()`;
   - komentarz klasy: nazwa pochodzi wyłącznie z biblioteki (wbudowanej i zaimportowanej); wbudowaną buduje
     `build_canbus_library.py --launcher` z assetu i `decompiled_carinfo/`.
4. **Testy**:
   - usuń `CanbusClassesTest.java`;
   - w `CanbusLibraryTest` (`theAssetAgreesWithCanbusClasses` ≈425, `theAssetHandlesTheOrientationAndTheFirmware` ≈437) zamień
     wywołania `CanbusClasses.className(...)` na stałe nazwy:

     | ID | warunek | oczekiwana klasa |
     |---|---|---|
     | 1 | | `com.syu.carinfo.dasauto.DasAutoWcAct` |
     | 273 | | `com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengIndex` |
     | 16384453 | | `com.syu.carinfo.rzc.sanlin.ODModerninIndexAct` |
     | 16646583 | | `com.syu.carinfo.rzc.sanlin.ODBMWCarInfo` |
     | 274 | pionowo | `com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi` |
     | 999999999 | | `null` |

   - przemianuj test na `theAssetHasTheKnownClasses`.
5. **Dokumentacja**:
   - `canbus_library/README.md`: tryb `--launcher` to „asset (klasy) + `decompiled_carinfo/` (strony)”, z instrukcją, jak dodać
     auto do wbudowanej biblioteki: dopisać C w assecie, `--seal` albo `--launcher .`;
   - `decompiled_carinfo/README.md`: dwa zdania, które mówią o `CanbusClasses.className()` i „made from CanbusClasses.java”;
   - komentarze w skrypcie (≈403, ≈471).
6. Kontrole:
   - `rg -n 'className\(' app/src --glob '!**/generated/**'`: tylko `classNameFor`;
   - `rg -n 'CanbusClasses\.java' .`: zero poza `docs/`;
   - `--launcher . --out x && diff x app/src/main/assets/canbus_library.txt`: brak różnic.

## D2 — `Canbus: the library knows each car's fuel and range codes`

### D2.1 Format w wersji 2

- Nagłówek `canbus_library 2`. Parser w Javie i `--check` w Pythonie przyjmują **1 albo 2**.
  - Pliki w wersji 1 nadal wczytują się bez zmian: nakładka użytkownika z poprzedniej rundy jest w v1.
  - `serialize()` i skrypt piszą v2; `--seal` zachowuje wersję z nagłówka.
- Nowy rekord (tylko w v2; w v1 to błąd `S records need version 2`):
  ```
  S <ids> | <fuel> | <range>      kody statystyk auta: spalanie chwilowe i zasięg; każdy 0..1199 albo "-" (nieznany)
  ```
  Przykład: `S 163,221 | 102 | 103`. Rekord `S 5 | - | -` jest błędem („nothing to say”).
- Spójność w pliku: jedno ID ma najwyżej jeden rekord S. Identyczny powtórzony to duplikat, inny to błąd.
- Scalanie per ID jak C: brak → nowy, identyczny → duplikat, inny → zastąpiony (wygrywa plik, stara → nowa wartość w raporcie).
  Każdy rekord pliku liczy się dokładnie raz.
- Stopka bez zmian: `<records>` liczy linie C/R/N/**S**.
- Uzupełnij `canbus_library/README.md` (specyfikacja, przykład, scalanie) i §Format w nagłówku skryptu.

### D2.2 Skrypt: skąd kody

- Strony kandydujące jak dla R: BFS od klas C (głębokość ≤ 3), `PAGE_NAME_RE`, ta sama kolejność stron.
  **Nie wymagaj zapytań w `onCreate`**: kody ma większość aut, a zapytania tylko część.
- W każdej stronie przejdź metody klasy (głębokość 1, jak w `extract_requests`). Nazwa metody decyduje o roli:
  - **spalanie**: `(?i)(oil|fuel).*(expend|consum|cost)|consum.*(oil|fuel)|cur.*oil`, ale **nie** `(?i)ave|avg|average|history|total|trip|unit|max|min|mark`;
  - **zasięg**: `(?i)driving.?mile|drivable|drivenable|remain|endurance|range|last.?mile|can.?run`, ale **nie** `(?i)total|trip|unit|history|dived|driven`.
- Kod = pierwsze `DataCanbus.DATA[n]` w ciele tej metody z `n < 1000` (1000+ to kody ogólne, np. ID auta).
  Gdy strona ma dwie metody tej samej roli z różnymi kodami, weź pierwszą w kolejności źródła i wypisz ostrzeżenie.
- Dla ID: spalanie z pierwszej strony (w kolejności stron), która je daje; zasięg tak samo, niezależnie. Bez obu → bez rekordu S.
- Grupowanie i wyjście jak C: jedna linia na identyczną parę, ID rosnąco. Na konsolę: liczba ID z S, z samym spalaniem,
  z samym zasięgiem, ostrzeżenia.
- Oczekiwane (sprawdź i wpisz do raportu):
  - `--launcher`: ID 163 (i grupa RZC_BZ408) → `102 | 103`;
  - `decompiled_com.syu.canbus/classes.dex/sources`: ID 1507667 → `91 | 92`;
  - Honda (19) → spalanie 98, zasięg 103.

### D2.3 Java

- `CanbusLibrary`:
  - `HEADER` = `canbus_library 2`, `HEADER_LINE` przyjmuje 1 i 2, a parser pamięta wersję;
  - nowa wartość `CarCodes` (`fuel`, `range`; −1 = nieznany, `equals`/`toString` = tekst rekordu);
  - mapa w `Library` i `Library.codesFor(int id)` (`null` = brak);
  - `mergedWith()` z `Counts codes` w `MergeResult` (doliczony do `added()`/`duplicates()`/`replaced()`);
  - `serialize()` grupuje S jak C;
  - `recordCount()` liczy S per ID.
- `CanbusLibraryImport`: raport (`appendCounts` ≈326) dostaje linię `S (fuel and range codes, per car)`. Dialog i toast bez zmian
  (sumy już obejmą S).
- Testy w `CanbusLibraryTest`:
  - v1 bez S parsuje się; v2 z S parsuje się; S w v1 → błąd z linią;
  - złe pola S (kod > 1199, `- | -`, 2 pola);
  - dwa różne S dla ID → błąd, identyczny → duplikat;
  - scalanie S (nowy, duplikat, zastąpiony; inne ID bez zmian);
  - `serialize` → `parse` z S;
  - asset ma S dla 163 = 102/103.

## D3 — `Fuel statistics: the fuel and range codes come from the library when none is set`

1. **Okno „Kody canbus”** (`SettingsFragmentSecond.displayCodesDialog()` ≈1734):
   - gdy zapisany kod Fuel albo Range jest pusty lub „0”, a `CanbusLibrary.cached()` ma `codesFor(DATA[1000])` z tym kodem:
     pole puste, `setHint(<kod z biblioteki>)`. Inaczej pole pokazuje zapisaną wartość, jak dotąd;
   - zapis bez zmian (`saveCode()` ≈1946 pisze „0” za pusty tekst). „0” znaczy „z biblioteki”;
   - pola zostają edytowalne. Filtr 0..9999 bez zmian.
2. **Opis `stats_codes`** (`statsCodesSummary()` ≈1961): gdy w ustawieniach jest 0, a biblioteka zna kod, w miejscu kodu pokaż
   `stats_codes_library_code` („%1$s (library)”), np. `Fuel: 91 (library)`.
3. **`CanbusService`**:
   - `fuel`/`range` z extras (≈189) to kody z ustawień;
   - gdy auto jest znane (`mNotifyCar` ≈369): na `CanbusLibrary.executor()` wywołaj `loadBlocking`, potem `codesFor(carId)`.
     Wynik postuj na wątek główny:
     - kod efektywny = kod z ustawień, gdy > 0, inaczej z biblioteki (albo 0, gdy go nie zna);
     - zapisz go w nowych polach `volatile int fuelCode, rangeCode`;
     - wywołaj `registerStatsCodes()` (≈1053), która rejestruje kody efektywne;
   - `statsCallback.update()` porównuje z kodami efektywnymi. RPM bez zmian (tylko z ustawień; biblioteka go nie zna);
   - `sendForCar` wołaj jak dotąd.
4. Kontrola: auto bez rekordu S i z kodami w ustawieniach działa dokładnie jak przed tą zmianą.

## D4 — `Canbus: the code reader can leave out the codes that only sent 0`

1. Preferencja w `creator_preferences.xml`, kategoria `inspector_category` (≈249), pod `code_inspector_data`:
   - `com.android.launcher66.settings.CustomSwitchPreference`, `android:key="skip_zero_codes"`, `android:defaultValue="true"`,
     `app:layout="@layout/nested_preference_category_switch"`;
   - tytuł `skip_zero_codes` („Leave out the codes that only sent 0”);
   - opis `skip_zero_codes_summary` („Codes whose every value was 0 are not written to the file; the header counts them.”).
2. `Keys.SKIP_ZERO_CODES = "skip_zero_codes"`. W `SettingsFragmentSecond`:
   - `findPreference` obok `codeInspectorData` (≈338);
   - widoczność jak `codeInspectorData`: w obu miejscach ustawiania widoczności i w `displayCanbusReaderSwitch()` (≈1496).
3. `CanbusCodeInspector`:
   - wartość czytana w `onCreate` obok `getSkipCodes()` (≈121), domyślnie `true`;
   - kod jest „tylko 0”, gdy **każde** jego zdarzenie ma `ints[0] == 0` i pustą resztę ładunku. Zdarzenie bez `ints` nie jest zerem;
   - przy włączonym przełączniku taki kod nie dostaje sekcji `CODE: n`;
   - nagłówek (≈333): `Codes with data: 309 (unchanged: 298; 287 sent only 0 and are left out); events: …`. Przy wyłączonym jak dotąd;
   - oszacowania liczone ze wszystkich kodów, bez zmian.

## D5 — `Canbus: guesses tuned on real drives, and the CAN box's raw frames`

### D5.1 Kanał ramek: wykrywanie (dla każdego kodu, nigdy po numerze)

- Nowa czysta klasa `settings/CanbusFrames.java`. Wejście: zdarzenia jednego kodu jako `(t, int[] ints)`, czyli pełny ładunek.
  - `CanbusCodeInspector` musi więc zachować pełne `ints` zdarzeń. Dziś trzyma `ints[0]` i tekst reszty.
  - Dodaj `int[] ints` do `Event`, tylko gdy `ints.length > 1` (pamięć).
- **Składanie ramek RZC:**
  - zdarzenia po kolei; zdarzenie zaczynające się od `0xFD` otwiera ramkę;
  - zdarzenie bez `0xFD` na początku, ≤ 50 ms po poprzednim, dokleja się do otwartej ramki;
  - z bufora wycinaj ramki po polu `len` (`len` = liczba bajtów po `0xFD`), także kilka z jednego zdarzenia;
  - suma: `(len + cmd + dane) & 0xFF == ostatni bajt`.
- **Kod jest kanałem ramek RZC**, gdy:
  - ≥ 80 % jego zdarzeń z `ints` długości ≥ 4 zaczyna się od `0xFD`;
  - ≥ 80 % złożonych ramek ma poprawną sumę;
  - ramek jest ≥ 20.

  Każdy inny kod, także 1019 w innym aucie albo z inną ramką, jest zwykłym kodem: zostaje w oszacowaniach i w pliku jak dotąd.
- Kanał ramek: w `estimate()` nie bierze udziału (jego `ints[0]` to nagłówek 253). W pliku zostaje sekcja `CODE: n` jak dotąd
  i dochodzi sekcja z D5.2. Pomijanie zer (D4) go nie dotyczy.

### D5.2 Kanał ramek: sekcja w pliku

Za oszacowaniami, przed sekcjami `CODE: n`:

```
Raw frames on code 1019 (RZC format: FD len cmd data checksum), 1929 frames, checksum ok 99%
Frame 0x7D/03 (len 8): 619 frames, 2.1/s
  data[1..2] LE16: 100-4300 = code 510
Frame 0x33 (len 12): 67 frames
  data[0..1] BE16: 1-110, 65535 = code 91
  data[2..3] BE16: 290-310 = code 92
Frame 0x7D/08 (len 6): 969 frames
  data[1..2] LE16 signed: -3..6
…
```

- **Typ ramki**:
  - `(cmd, len)`;
  - gdy ta sama `cmd` występuje w więcej niż jednej długości, typ to `(cmd, len, dane[0])`, a `dane[0]` traktuj jako podkomendę
    (w zapisie `0x7D/03`).
- **Dla każdego typu**:
  - liczba ramek i częstość;
  - bajty danych, które się zmieniają (min..max, liczba różnych);
  - pola 16-bit LE i BE z sąsiednich bajtów, z których choć jeden się zmienia; pola 24-bit LE z trzech;
  - wariant ze znakiem, gdy wartości ≥ 0x8000 i bliskie 0 po przeliczeniu.
- **„= code N”**: pole równa się wartości kodu N (zwykłego, z ≥ 1 zmianą) w ≥ 90 % ramek. Wartość kodu bierz w chwili ramki
  + 300 ms (kod przychodzi tuż po ramce). Pokaż tylko pola pasujące i pola zmienne, bez stałych bajtów.
- Najwyżej 30 typów i 8 pól na typ. Nadmiar policz.
- Gdy żaden kod nie jest kanałem ramek: sekcji nie ma.

### D5.3 Estymator (`CanbusCodeEstimator`, `statsOf()` ≈169, kategorie ≈358–520, `estimate()` ≈525)

1. **Wstępnie, per kod:**
   - wartości 65535, 65534, 32767 i −1 to „brak wartości”: wypadają z analizy, a ich liczba trafia do opisu
     (`…, 65535 = no value 10×`);
   - wiodące zera przed pierwszą niezerową wartością wypadają, gdy dalej są wartości niezerowe (512: 0 → 108782).
2. **Seria o wartościach tylko z {0, 1, 2}** jest wyłącznie kandydatem na przełącznik/stan. Żadna inna kategoria
   (temperatura, poziom paliwa itd.) jej nie bierze. Temperatury wymagają ≥ 3 różnych wartości.
3. **Skala**: `g` = NWD niezerowych wartości. `g % 100 == 0` → skala 100, `g % 10 == 0` → 10, inaczej 1. Rozdzielczość kroku =
   NWD niezerowych |Δ| (dla 92: 10).
4. **Spalanie chwilowe**: udziały liczone na wartościach poprawnych i niezerowych:
   - ≥ 10 takich wartości, ≥ 70 % w 20..250, ≥ 10 zmian, ≥ 5 różnych;
   - średnie |Δ| > 2 (seria skacze); przy średnim |Δ| ≤ 2 i krokach ±1 ≥ 60 % to średnia, nie chwilowe;
   - bonus jak dotąd za korelację z GPS/RPM, plus za „brak wartości” albo 0 przy prędkości < 40 km/h (GPS albo kod prędkości).
5. **Spalanie średnie**:
   - ≥ 90 % poprawnych wartości w 20..250, kroki ±1 ≥ 60 %, średnie |Δ| ≤ 2, ≥ 1 zmiana;
   - bez górnej granicy liczby zmian; reguła „w jedną stronę” zostaje;
   - na logach właściciela ma brać 1033 z autostrady (kroki ±1 62–82 %, |Δ| 1,3–1,5), a nie 91.
6. **Prędkość**:
   - sprawdź skalę 1, 10 i 100: pierwsza, przy której `max/skala ≤ 260`, a NWD na nią pozwala;
   - korelacja z GPS nie zależy od skali: r ≥ 0,8 → ≥ 0,9; r ≥ 0,5 → 0,7;
   - bez GPS: powroty do 0, ≥ 5 zmian, `max/skala ≥ 20` → 0,5;
   - opis `0-124 km/h as value/100, follows the GPS speed (r=0.97)`;
   - seria ze skalą 100 i GPS r ≥ 0,8 nie może dostać kategorii RPM.
7. **RPM**:
   - 0,5 lub więcej tylko przy skupisku biegu jałowego (najniższe 20 % **niezerowych** wartości w 500..1100, rozrzut ≤ 150)
     albo korelacji z GPS ≥ 0,4;
   - inaczej najwyżej 0,45, czyli nie trafia na listę. (510 bez skali dostawał dziś „RPM”.)
8. **Zasięg**:
   - wartości 20..1500, ≥ 1 zmiana;
   - |Δ| / rozdzielczość ≤ 3; nie „głównie w górę” (przy ≥ 3 zmianach wzrosty ≤ 50 %);
   - bonus za podobne odstępy, gdy zmian ≥ 3;
   - stała wartość jak dotąd (0,5 z dopiskiem); w opisie rozdzielczość (`in 10 km steps`).
9. **Przebieg**:
   - po zrzuceniu wiodących zer: min ≥ 1000, nie maleje, krok ≤ 10;
   - **+0,2, gdy każdy krok to dokładnie +1** (kryterium właściciela).
10. **Nazwy z bloku add-on**: dla kodów 500..559 z ≥ 1 zmianą wypisz za listą oszacowań osobny blok:
    ```
    Add-on data block 500-559 (names from the canbus app, ConstRzcAddData; may not apply to every CAN box):
    Code 505 - left turn signal (56 changes)
    Code 510 - speed, value/100 km/h (626 changes)
    Code 518 - reverse gear (4 changes)
    ```
    Tabela kod → nazwa ze stałych `ConstRzcAddData` (§0). Nie wpływa na wyniki punktowe.
11. `Not found:` jak dotąd (bez przełączników).

### D5.4 Testy

- **`CanbusFramesTest`**:
  - ramki z §0 (także rozbite na dwa zdarzenia i kilka w jednym) → typy, pola LE16/LE24/BE16, sumy;
  - pole zgodne z serią kodu 510 → `= code 510`;
  - **te same ramki pod innym numerem kodu (np. 77)** → też wykryte jako kanał;
  - kod 1019 ze zwykłymi wartościami (np. 0..255 bez `0xFD`) → nie jest kanałem i zostaje w oszacowaniach;
  - ramki z błędną sumą w > 20 % → nie jest kanałem.
- **`CanbusCodeEstimatorTest`**, nowe serie syntetyczne jak w logach:
  - 91 z 65535 co jakiś czas → spalanie chwilowe;
  - 510 jako prędkość ×100 z GPS → prędkość `as value/100`, nie RPM; ta sama seria bez GPS → nie RPM;
  - 92: 310 → 300 → 290 → zasięg (`10 km steps`);
  - 512: 0, 108789, +1 … → przebieg z bonusem;
  - seria 0/1 o dwóch zmianach → przełącznik, nie temperatura;
  - gładka seria 119..179 o krokach ±1 → spalanie średnie.
  - Stare testy mają przechodzić. Dostrój progi, nie testy.

## 4. Czego NIE zmieniać

- `ModuleCallbackCanbusProxy`, `Callback_*`, `HandlerCanbus`, `DataCanbus`, `ConnectionCanbus`.
- Zakres skanera 0..1199 (to cały moduł, §0) i jego czas zapisu.
- Reguły scalania C/R/N i format v1 (dalej wczytywany).
- `LogcatWorker`, `FabOverlayService`, `LogcatStopButton`.
- Profile baseline, CI, `decompiled_*`, `fuel_stats_example/`, tłumaczenia (poza usuwaniem nieużywanych kluczy).

## 5. Weryfikacja

1. Po każdym commicie: kontrole `rg` z kroku, testy lokalne, CI zielone (push dopiero po wyniku poprzedniego).
2. Kontrola końcowa:
   - `python3 canbus_library/build_canbus_library.py --launcher . --out /tmp/x.txt && diff /tmp/x.txt app/src/main/assets/canbus_library.txt` → brak różnic;
   - `--check` na assecie → 0, nagłówek `canbus_library 2`, S dla 163 = `102 | 103`;
   - dekompilat: `python3 canbus_library/build_canbus_library.py decompiled_com.syu.canbus/classes.dex/sources --out /tmp/app.txt` →
     `--check /tmp/app.txt` = 0, S dla 1507667 = `91 | 92`;
   - plik v1 z poprzedniej rundy (np. `git show ee0e7a0e:app/src/main/assets/canbus_library.txt`) → `--check` = 0 i parser w Javie OK;
   - `rg -n 'className\(' app/src --glob '!**/generated/**'` → tylko `classNameFor`.
3. Scenariusze dla właściciela (7862, 7870), wypisz je w raporcie:
   - a) PSA bez importu: w oknie kodów puste pola Fuel/Range z podpowiedzią 102/103 (biblioteka wbudowana);
     wpisane 91/92 wygrywają, statystyki działają;
   - b) import biblioteki zbudowanej z `com.syu.canbus` właściciela:
     - raport z S `replaced 102/103 → 91/92` dla grupy PSA;
     - przy pustych polach podpowiedź 91/92 i statystyki na 91/92;
     - opis `Fuel: 91 (library)`;
   - c) skaner z przełącznikiem: plik bez kodów samych zer, nagłówek z liczbą pominiętych; po wyłączeniu plik jak dotąd;
   - d) skaner na PSA:
     - sekcja `Raw frames on code 1019 …` z polami `= code 510/512/91/92`;
     - oszacowania: 91 spalanie, 92 zasięg, 510 prędkość (`as value/100`), 512 przebieg;
     - 505/506/518 jako przełączniki i w bloku add-on; 0/1 nigdzie jako temperatura;
   - e) auto z innym CAN-boxem (jeśli dostępne): 1019 (jeśli jest) bez ramek RZC zostaje zwykłym kodem.

## 6. Raport końcowy (w odpowiedzi, po polsku)

- Commity (hash + temat) i wynik CI każdego.
- Liczby skryptu (`--launcher` i dekompilat): ID z klasą, z zapytaniem, z S (oba kody, samo spalanie, sam zasięg), ostrzeżenia.
- Wynik skanera na danych testowych (które kategorie dostały 91/92/510/512/1033).
- Każde odstępstwo od instrukcji i jego powód.
- Nowe klucze w `values/strings.xml` (do tłumaczenia) i klucze usunięte ze wszystkich języków.
- Scenariusze z pkt 5.3.
