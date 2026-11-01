# Launcher Mod: biblioteka z nowszego com.syu.canbus, kody spalania z kilku wersji, eksport i porównanie bibliotek — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Ostatni commit właściciela to `f68d1173` („update canbus”). Dodał on katalog `decompiled_com.syu.canbus/classes.dex.new/`.

Zrób pięć commitów w kolejności G1 → G5. **Każdy commit musi się budować samodzielnie.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.** Numery linii są orientacyjne (≈), więc sprawdzaj je w kodzie.

## 0. Fakty (sprawdzone przy pisaniu tego briefu)

**Źródła:**
- `decompiled_com.syu.canbus/classes.dex/sources` to **stara** wersja `com.syu.canbus`, ta, która działa dziś na radiu
  właściciela (2958 plików);
- `decompiled_com.syu.canbus/classes.dex.new/sources` to **nowa** wersja (3223 pliki);
- `decompiled_com.syu.canbus/classes.dex.new/canbus_library_2026-10-30_00-56-34.txt` to biblioteka, którą właściciel
  wygenerował obecnym skryptem z nowej wersji;
- `decompiled_carinfo/` to pakiet `com.syu.carinfo` z jeszcze innego builda. Na nim stoi dzisiejszy asset
  (`py canbus_library/build_canbus_library.py --launcher .`: rekordy C i N z assetu, a R i S liczone z `decompiled_carinfo`).

**Auto właściciela:**
- `Car: id 1507667 (protocol 339, car 23)`, klasa `com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi`;
- na aucie potwierdzone kody: **91** = spalanie chwilowe ×10, **92** = zasięg;
- wysyłane zapytanie: `70:51; 29:0`.

**Kody S zależą od wersji `com.syu.ms`.** `U_CNT_MAX` jest w obu wersjach 1200, ale indeksy się przesunęły
(`FinalCanbus.java` urósł z ~3500 do ~5500 linii). `RZC_BZ408OilMilePage1Acti`:

| źródło | kody czytane przez ekran | uwagi |
|---|---|---|
| stara wersja (`classes.dex`) | `DATA[91]`, `[92]`, `[93]`, `[87]` | zgodne z autem |
| nowa wersja (`classes.dex.new`) | `DATA[102]`, `[103]`, `[104]`, `[98]` | |
| `decompiled_carinfo` | `DATA[102]`, `[103]` | asset ma `S … | 102 | 103` |

Inne auta też się różnią: między dzisiejszym assetem a nowym plikiem 8 rekordów S ma inne kody, np. id 217: `10|11` → `101|102`.

**Liczby: dzisiejszy asset → plik właściciela:**

| rekord | asset | nowy plik | tylko w starym | tylko w nowym | zmienione |
|---|---|---|---|---|---|
| C | 3864 | 4899 | 29 | 1064 | 238 |
| R | 595 | 625 | 97 | 127 | 91 |
| N | 0 | 0 | | | |
| S | 1158 | 1415 | 110 | 367 | 8 |

**Błąd generatora, groźny dla auta właściciela:**
- Nowa wersja ma dla 408 strony `RZC_BZ408EVMilePage1..4Acti` (zapytania `70:80`..`70:83`, ekran auta elektrycznego,
  otwierany z `RZC_BZ408IndexActi` ≈ l. 68).
- Klucz sortowania stron w skrypcie (`key()` ≈ l. 1294: `_<low>_`, `Page1`, `Index`, głębokość, nazwa) remisuje
  i wybiera alfabetycznie, więc **pierwszą stroną zostaje `EVMilePage1` (`70:80`)**.
- Launcher wysyła tylko zapytania pierwszej strony (`CanbusLibrary.sendForCarNow`, `pages.get(0)`). Auto właściciela
  dostałoby `70:80` zamiast `70:51; 29:0`.
- **Pliku `canbus_library_2026-10-30_00-56-34.txt` nie wolno importować** ani wpisywać do assetu bez poprawki z G1.

**Import w launcherze** (`settings/CanbusLibraryImport.java`, `CanbusLibrary.java`):
- importy scalane są w `getFilesDir()/canbus_library_user.txt` (`CanbusLibrary.userFile`);
- biblioteka efektywna `builtIn.mergedWith(overlay)` jest tylko w pamięci (`loadBlocking`, ≈ l. 1190–1210);
- raport w `Download/Launcher66_Logs` ma tylko liczby i listę zamian;
- `Library.serialize()` (≈ l. 577) zapisuje poprawny plik ze stopką;
- **eksportu nie ma.**

**Decyzje właściciela:**
1. **Kody S z kilku wersji naraz.** Biblioteka trzyma dla car id kilka par fuel/range (z nowej i ze starej wersji).
   Launcher sam wybiera tę parę, która na tym radiu naprawdę podaje dane, i zapamiętuje ją.
2. Zaktualizować asset z nowej wersji tak, żeby radia ze starszym `com.syu.canbus` nadal działały.
3. Eksport wspólnej biblioteki (wbudowana + importy) z launchera. Workflow właściciela:
   - zainstalować build z eksportem, ze **starym** assetem;
   - zaimportować bibliotekę z nowej wersji;
   - wyeksportować i przysłać do porównania z nowym assetem.
4. Raport: czy nowa wersja daje coś launcherowi (RPM, spalanie poniżej ~30 km/h, komputer pokładowy, IPC).

**Zasady** (jak w `docs/sonnet-prompt-2026-10-29-canbus-library-classes-reader.md` §1):
- **Commity:**
  - po angielsku, z trailerami sesji;
  - push dopiero po wyniku CI poprzedniego commita (cancel-in-progress);
  - czerwony build naprawiaj nowym commitem, bez amend i force-push.
- **Tylko do odczytu, nie ruszaj:**
  - `.github/workflows/*`;
  - `app/src/main/generated/baselineProfiles/`;
  - `decompiled_carinfo/**`;
  - `decompiled_com.syu.canbus/**` (także `classes.dex.new`);
  - `decompiled_FYT_jars/`;
  - `fuel_stats_example/`.
- **Stringi:** nowe tylko w `values/strings.xml`.
- **Kod Javy:**
  - logika w czystej Javie z testami JVM;
  - StrictMode: żadnego I/O na wątku głównym.
- **Skrypt:** Python 3.8+, tylko biblioteka standardowa, Windows i Linux.
- **Nazwy modelu** nie wpisuj do repo.

## G1. Skrypt: strona główna, `--diff`, `--merge` (`canbus_library/build_canbus_library.py`, `README.md`)

1. **Wybór strony głównej, reguła uniwersalna (nie pod 408):**
   - wśród kandydatów najpierw strony, z których `extract_codes` wyciąga kod spalania albo zasięgu;
   - potem strony bez znaczników auta elektrycznego w nazwie: `EV`, `Electric`, `Battery` jako osobne słowo w CamelCase
     (`EVMile` tak, `Level` nie);
   - dopiero potem dzisiejszy klucz.

   Sprawdź w `RZC_BZ408EVMilePage1Acti`, że nie ma kodów spalania. Jeśli ma, druga reguła wystarczy.
   **Policz, u ilu grup zmienia się strona główna,** i wypisz je w logu skryptu (`main page changed by the fuel rule: …`).
   Każdą z nich przejrzyj w raporcie G2.
2. **`--diff A B [--ids 1507667,163]`:**
   - oba pliki najpierw sprawdzane jak `--check`;
   - per car id, osobno dla C, R per (id, strona), N i S: tylko w A, tylko w B, różne (A → B);
   - podsumowanie liczb, potem do 50 przykładów każdego rodzaju;
   - `--ids` wypisuje pełny stan wskazanych id w A i w B, z kolejnością stron;
   - exit code: 0 brak różnic, 3 są różnice, 2 nieprawidłowy plik;
   - działa dla wersji 1, 2 i 3 (G4).
3. **`--merge BASE FILE [--out OUT]`:**
   - scala dokładnie jak `Library.mergedWith` i README §6;
   - wynik jest zapieczętowany, a liczby new / duplicate / replaced wypisane per rodzaj;
   - domyślny `--out`: `canbus_library_merged_<data>_<czas>.txt`.
4. **Zgodność z Javą** (lokalnie, nie w CI): `--diff` między `--merge asset new` a
   `CanbusLibrary.parse(asset).library.mergedWith(parse(new).library).library.serialize()` ma dać 0 różnic.
   Klasy zbuduj jak w poprzednich rundach (junit-console + stuby albo jshell). Napisz w opisie commita, że to sprawdziłeś.
5. **README:**
   - nowe tryby w „Other modes” i §5;
   - reguła strony głównej w §6.

**Commit:** `Canbus library script: the fuel page before an EV page, diff and merge of libraries`

## G2. Raport porównania wersji (`docs/canbus-app-comparison-2026-10-30.md`, po polsku)

**Tylko analiza.** Porównaj wersję starą (`classes.dex`), nową (`classes.dex.new`), `decompiled_carinfo` i asset.

1. **Moduł i IPC:**
   - `com/syu/module/canbus/FinalCanbus.java` i `DataCanbus.java`;
   - `com/syu/ipc/**` w obu wersjach oraz kopie w launcherze (`app/src/main/java/com/syu/ipc`, `app/src/main/java/com/syu/module`).

   Każda różnica w IPC, `cmd(...)` albo `NOTIFY_EVENTS` to ryzyko dla launchera: podaj plik i linię.
   Opisz przesunięcie indeksów: czy jest stałe (np. +11 w bloku), czy różne per auto.
2. **Mapowanie** (`com/syu/canbus/ActivityLauncher.java`): ile car id doszło, ubyło i zmieniło klasę. Podaj przykłady.
3. **Auto 1507667** (`com/syu/carinfo/rzc/biaozhi408/*`, `com/syu/carinfo/rzc/addcan/*`, w tym `ConstRzcAddData.java`):
   - kody i zapytania wszystkich stron, w tym nowych `EVMile*`;
   - nowe ekrany (trip, średnie, RPM, prędkość);
   - blok add-on 500–560.

   Napisz wprost, czy nowa wersja daje coś na RPM i na spalanie poniżej ~30 km/h.
4. **Generator:**
   - uruchom poprawiony skrypt na nowej i na starej wersji (`--out` do katalogu tymczasowego);
   - `--diff` plik właściciela ↔ nowy wynik: oczekiwana różnica to tylko strona główna z G1, każdą inną wyjaśnij;
   - `--diff` stara ↔ nowa wersja i asset ↔ nowa wersja;
   - nowe ostrzeżenia generatora.
5. **Ostrzeżenie dla właściciela:**
   - aktualizacja `com.syu.canbus` bez pasującego `com.syu.ms` zepsuje oryginalny ekran spalania, bo czyta inne indeksy;
   - po aktualizacji obu kody auta zmienią się z 91/92 na 102/103. Ręcznie wpisane 91/92 w oknie „Kody canbus” trzeba
     wtedy wyczyścić. G4 robi to automatycznie tylko dla pustych pól.
6. **Rekomendacje bez implementacji,** każda z zakresem i ryzykiem.

**Commit:** `Docs: what the newer com.syu.canbus changes for the launcher`

## G3. Eksport biblioteki z launchera

1. **Preferencja `canbus_library_export`** w grupie Canbus reader (`creator_preferences.xml`, obok `canbus_library_import`
   i `canbus_library_reset`):
   - widoczna jak import (`displayCanbusReaderBool`);
   - nieaktywna podczas importu;
   - obsługa w `SettingsFragmentSecond` (`updateCanbusLibraryPrefs`, `onPreferenceClick`).
2. **Zapis na wątku biblioteki** (`CanbusLibrary.EXECUTOR`):
   - treść: `CanbusLibrary.loadBlocking(app).serialize()`, czyli biblioteka, której launcher naprawdę używa;
   - plik: `canbus_library_export_<yyyy-MM-dd_HH-mm-ss>.txt`;
   - folder ten sam co raport importu. Wybór folderu (`Download/Launcher66_Logs`, inaczej ścieżka aplikacji)
     **wydziel z `writeReport`** do wspólnej metody;
   - po nagłówku komentarz `#` z liczbą rekordów i datą. Sprawdź, że komentarze nie psują stopki (`parse`, `seal`).
3. **Toast** z pełną ścieżką albo z błędem, na wątku głównym.
4. **Stringi:** `canbus_library_export`, `canbus_library_export_summary`, `canbus_library_export_done` (`%1$s` = ścieżka),
   `canbus_library_export_failed`.
5. **Test JVM:** asset scalony z małym overlay (każdy rodzaj rekordu) po `serialize()` przechodzi `parse` bez błędów,
   a ponowne `serialize()` daje ten sam tekst.
6. **README §4:** eksport i workflow porównania (eksport, potem `--diff`).

W raporcie końcowym podaj **numer runu CI z APK G3**. Ten APK ma jeszcze stary asset i właściciel użyje go do eksportu.

**Commit:** `Canbus library: export the library the launcher uses to Download/Launcher66_Logs`

## G4. Kilka par kodów S i wybór pary na radiu

1. **Format w wersji 3** (`canbus_library 3`):
   - zapis: `S <ids> | <fuel> | <range> [| <fuel> | <range>]…`, do 4 par, każda para jak dziś (`-` = nieznany, para `- | -`
     to błąd), bez powtórzeń par w rekordzie;
   - kolejność par = preferencja, od najnowszej wersji;
   - wersje 1 i 2 czytane jak dotąd (w wersji 2 jedna para);
   - plik wersji 2 z kilkoma parami to błąd z jasnym komunikatem (`several code pairs need version 3`).

   Zaktualizuj:
   - parser Javy (`CanbusLibrary.parse`, `CarCodes` → lista par, `codesFor` zwraca pierwszą parę dla zgodności,
     nowe `codePairsFor`) i `serialize()`, który zapisuje wersję 3 tylko wtedy, gdy jest para > 1, inaczej 2;
   - `check_text`, `seal` i `--diff` w skrypcie;
   - README §6.
2. **Scalanie S:**
   - pary z FILE najpierw, potem pary z BASE, których FILE nie ma, razem najwyżej 4;
   - identyczna lista = duplicate, inna = replaced;
   - Java i `--merge` identycznie, zgodność sprawdzona jak w G1.4.
3. **Wybór pary w launcherze** (nowa czysta klasa, np. `settings/CodePairChooser.java`, z testami JVM):
   - **zasilanie:** `CanbusService` rejestruje kody wszystkich par (fuel i range) obok dzisiejszych
     (`registerStatsCodes`, `statsCallback`), a wartości trafiają do wyboru;
   - **wartość wiarygodna:**
     - fuel: 1..3000 albo 65535 („brak wartości”, ale kod żyje);
     - range: 1..2000;
   - **para potwierdzona:**
     - kod fuel albo range dał ≥ 10 wiarygodnych wartości, w tym ≥ 2 różne;
     - żadna wcześniejsza para tego nie spełnia;
     - jeśli spełnia kilka par, wygrywa pierwsza.
   - **zapis:** potwierdzony wybór idzie do prefs per car id (`code_pair_<carId>` = indeks i kody), przez `apply()`
     poza wątkiem głównym;
   - **zmiana pary:** wybór zmienia się tylko wtedy, gdy potwierdzona para przez ≥ 10 min jazdy nie daje nic,
     a inna para jest potwierdzona;
   - **przed potwierdzeniem:** pokazywane są wartości pierwszej pary, która dała wiarygodną wartość;
   - **priorytet:** kod wpisany w oknie „Kody canbus” > potwierdzona para > pierwsza para. Kody z czytnika
     (`ReaderGuesses`) nadal są tylko podpowiedzią dla prędkości i RPM, jak dziś;
   - **kalibracja:** `FuelModel` dostaje kod z wybranej pary, więc kalibruje się per kod jak dziś (`FuelModel.key`).
4. **Okno „Kody canbus”:**
   - podpowiedzi Fuel/Range pokazują kod, który zostanie użyty;
   - linia informacyjna wymienia pary, np. `Library: 102/103, 91/92 — in use: 91/92 (confirmed)`;
   - nowy string, tylko w `values/`;
   - opis `stats_codes` jak dotąd, z kodem w użyciu.
5. **Testy JVM:**
   - parser i serializacja wersji 3 oraz błąd w wersji 2;
   - scalanie par;
   - wybór pary dla scenariuszy:
     - radio ze starym ms: 91/92 żyją, 102/103 nic → 91/92;
     - radio z nowym ms → 102/103;
     - obie pary żyją → pierwsza;
     - zmiana po 10 min;
     - wpisany kod wygrywa;
     - 65535 liczy się jako „kod żyje”;
     - same zera → para niepotwierdzona.

**Commit:** `Canbus library: several fuel and range code pairs, the one the radio reports is used`

## G5. Asset z nowej i starej wersji

1. **`--launcher REPO`:**
   - źródła w kolejności: `decompiled_com.syu.canbus/classes.dex.new/sources`, potem `classes.dex/sources`,
     potem `decompiled_carinfo` (stałe w skrypcie);
   - **C, R i N:** z najnowszego źródła, które zna car id (mapowanie z `ActivityLauncher.java` danego źródła;
     dla `decompiled_carinfo` C i N z dzisiejszego assetu jak teraz);
   - **S:** pary ze wszystkich źródeł w tej kolejności, bez powtórzeń, najwyżej 4;
   - **warunek:** `--launcher .` uruchomiony dwa razy z rzędu daje identyczny plik;
   - nagłówek `#` wymienia źródła;
   - zaktualizuj docstring i README.
2. **Nowy asset:**
   - `--check` musi przejść;
   - `--diff` stary → nowy asset dopisz do raportu G2 w tym commicie;
   - **dla 1507667:** pierwsza strona `RZC_BZ408OilMilePage1Acti` z `70:51; 29:0`, a S z parami 102/103 i 91/92.
     Jeśli wyjdzie inaczej, **zatrzymaj się i opisz to przed commitem**.
3. **Testy `CanbusLibraryTest`:**
   - `theAssetHasTheCodesOfThePsaCar`: pary dla 163, 1507667 i 19;
   - nowa asercja: pierwsza strona i zapytania 1507667;
   - pozostałe testy assetu zmieniaj tylko tam, gdzie `--diff` pokazuje zmianę. Każdą uzasadnij w opisie commita.
4. **Liczby aut** w README zaktualizuj, jeśli gdzieś są podane.

**Commit:** `Canbus library: the built-in library from the newer and the older com.syu.canbus`

## Weryfikacja i raport końcowy

- **Przed każdym pushem:**
  - lokalnie testy JVM;
  - `py canbus_library/build_canbus_library.py --check app/src/main/assets/canbus_library.txt`.
- **G1 i G4:** `--merge` i Java dają 0 różnic. **G5:** `--launcher .` jest idempotentny.
- **Raport dla właściciela (po polsku):**
  - wnioski z G2: RPM, spalanie poniżej progu, IPC, ostrzeżenie o ms;
  - liczby z `--diff`;
  - numer runu z APK G3 i workflow:
    1. zainstaluj APK G3;
    2. wygeneruj bibliotekę z nowej wersji **poprawionym** skryptem z G1 (nie importuj starego pliku z 30-10);
    3. zaimportuj ją i wyeksportuj;
    4. przyślij eksport;
    5. porównanie:
       `py build_canbus_library.py --diff canbus_library_export_….txt app/src/main/assets/canbus_library.txt --ids 1507667`;
  - czego się spodziewać:
    - C i R zgodne z nowym assetem dla aut z nowej wersji;
    - S w eksporcie mają jedną parę, bo stary launcher czyta wersję 2, a w assecie G5 będzie kilka par;
    - auta tylko ze starej wersji zostają w obu;
  - scenariusze na aucie:
    - po G4 bez wpisanych kodów okno pokazuje `in use: 91/92 (confirmed)` po kilku minutach;
    - zapytanie nadal `70:51; 29:0`.
