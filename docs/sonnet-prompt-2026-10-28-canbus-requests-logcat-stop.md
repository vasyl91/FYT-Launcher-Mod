# Launcher Mod: biblioteka canbus (klasy aut i zapytania), jej import, skaner z oszacowaniami i przycisk „Stop logcat” — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.

Zrób osiem commitów w kolejności C1 → C8. **Każdy commit musi się budować samodzielnie.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.**

Numery linii to stan z `7750437` i są orientacyjne (≈). Zawsze sprawdzaj je w kodzie.

## 0. Cel, fakty i decyzje właściciela

**Co to jest cmdInt/cmdArr.** To nie kod danych, tylko **komenda do CAN-boxa**: `DataCanbus.PROXY.cmd(cmdInt, new int[]{cmdArr})`.
Jej znaczenie zależy od protokołu auta. Przykład RZC PSA 408 w `decompiled_carinfo/com/syu/carinfo/rzc/biaozhi408/`:

| komenda | co robi |
|---|---|
| `70/{51}`, `71/{52}`, `72/{53}` | „wyślij stronę 1/2/3 komputera pokładowego” |
| `29/{0..2}` | przełącza stronę |
| `10/{0..3}` | ustawia czas świecenia świateł po wyłączeniu auta |
| `9`, `88/{x,v}` | przełączniki ustawień auta |

`cmd(0,{0})` w innych autach to np. przycisk ustawienia zegara (`MzdClockSetActi`) albo przełącznik ostrzeżeń (`LiFan720IndexAct`).
Większość CAN-boxów sama wysyła spalanie i zasięg. Tylko część aut wysyła je dopiero na zapytanie, które oryginalny
ekran spalania wysyła przy otwarciu.

**Fakty z kodu:**
- `CanbusCommandLogger` wysyła **każdą** parę cmdInt×cmdArr z zakresu, czyli losowe komendy, także zmieniające ustawienia auta.
- `CanbusService.onStartCommand` (≈186–188) wysyła `cmd(cmdInt,{cmdArr})` raz, przy starcie, **każdemu** autu.
  Domyślnie jest to `0/{0}`. `RemoteModuleProxy.cmd` gubi komendę po cichu, gdy `com.syu.ms` nie jest jeszcze połączone.
- `cmdArr` przyjmuje jedną liczbę, a część aut wymaga dwóch: GM Andra `11/{74,3}`, Fiat RZC `1/{80,1}`.
  `saveCode()` (≈1941) zapisuje pusty tekst jako `"0"`.
- `CanbusCodeInspector` i statystyki słuchają `DataCanbus.NOTIFY_EVENTS`, czyli widzą tylko kody zarejestrowane przez
  `Callback_XXXX.in()` (nieznane auto → `Callback_0000_null` → tylko kod 0) i tylko `ints[0]`.
- `IRemoteModule.register/unregister` są `oneway` (flaga 1 w `transact`). Rejestracja kodu, którego `com.syu.ms` nie zna, nie zwraca wyjątku.
- **Mapowanie ID auta → klasa ekranu.**
  - Oryginał: `decompiled_com.syu.canbus/classes.dex/sources/com/syu/canbus/ActivityLauncher.java`, `launchCanbus()` (≈517–4500).
    `switch (DataCanbus.DATA[1000])` przypisuje `cls = X.class;` (import albo ten sam pakiet).
  - Launcher: `app/src/main/java/com/android/launcher66/settings/CanbusClasses.java`, `className(int)`, gdzie jest `name = "fqcn";`.
  - Etykiety mają postać `case N:` albo `case FinalCanbus.X /* N */:`.
  - Oba przełączniki mają **fall-through** i **warunki**:
    - `TheApp.getConfiguration() == 1` / `LauncherApplication.getConfiguration() == 1`: orientacja, 1 = pion. Występuje też `!= 1`;
    - `readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || ….contains("Lt18")`;
    - przykład `CanbusClasses` 274 (≈1400): `if (getConfiguration() != 1) { name = …ActivityAccord7Index; break; }`, a w pionie przechodzi do
      przypadków 276…;
    - przykład 12648900 (≈4926): `fytver` zawiera `Ls18`/`Lt18` → `…zhtd.bmw.LZNewAllBBASetFunc`, w przeciwnym razie `…camry.luz.CamryIndexAct_LuZ`.
- Dekompilat w repo jest **starszy** niż `CanbusClasses`: ≈2848 ID wobec 3864, a uproszczone porównanie daje ≈299 ID z inną klasą.
  To dobry materiał testowy dla importu.

**Decyzje właściciela (nie zmieniaj ich):**
1. „Wstępną weryfikację” (`CanbusCommandLogger`) usunąć **bez zamiennika**.
2. Kody znajduje się z pliku pasywnego skanera („Szczegółowa weryfikacja”). Skaner nie wysyła losowych komend. Zapisuje wszystko,
   co wysyła `com.syu.ms`, każdą zmianę z czasem, a na początku pliku podaje **oszacowania** (C5).
3. Pola cmdInt/cmdArr są **widoczne tylko dla aut, które wymagają zapytania**. Dla pozostałych nie ma ich na ekranie,
   a launcher **nie wysyła tym autom żadnej komendy**.
4. **Biblioteka canbus** (klasy aut i zapytania):
   - budowana skryptem **Python 3 + `.bat`** z osobnego folderu `canbus_library/` (wraz z instrukcją `.md` dla Windows);
   - użytkownik może zbudować własną ze swojego dekompilatu `com.syu.canbus` i **zaimportować** ją w launcherze (C6);
   - plik musi mieć **stopkę z liczbą rekordów i CRC32**.
5. **Scalanie per ID auta.** Rekordy dla różnych aut zostają wszystkie. Identyczne są pomijane jako duplikaty.
   Przy sprzeczności dla tego samego ID **wygrywa plik użytkownika**.
6. Nazwa klasy w „Statystykach” (`stats_window_summary`) pochodzi z biblioteki, także zaktualizowanej importem.
   Do angielskiego tekstu w `values/` dochodzi „(recommended)”.
7. Statystyki (paliwo, zasięg, RPM) czytają kody **tak jak skaner**, bezpośrednio z `com.syu.ms`.
8. Logcat uruchomiony przez „Tap to start logging” (**i tylko wtedy**) pokazuje przesuwalny przycisk „Stop logcat” nad wszystkimi ekranami (C7).
9. **Nowe stringi tylko w `app/src/main/res/values/strings.xml`.** Tłumaczeniami zajmie się właściciel.

## 1. Zasady pracy i konwencje repo (jak w poprzednich rundach)

- **Commity po angielsku**:
  - temat `<Obszar>: <co>` (tematy przy krokach), treść zawinięta na ~72 znaki;
  - w treści napisz *dlaczego* (fakty z §0);
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push** po każdym commicie: `git push -u origin ccr-087eed00-gbqsuz`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
  Przed następnym commitem poczekaj na wynik CI (`.github/workflows/build.yml`: `testFytDebugUnitTest`, `assembleFytDebug`,
  `assembleStandardDebug`; `cancel-in-progress`). Sprawdzaj przez GitHub MCP (`actions_list`, `get_job_logs`).
  Czerwony build naprawiaj kolejnym commitem, bez amend i force-push.
- **Nie ruszaj**:
  - `.github/workflows/*` ani commita `[BRANCH-ONLY]`;
  - `app/src/main/generated/baselineProfiles/`;
  - `decompiled_carinfo/com/**`, `decompiled_com.syu.canbus/**` i `decompiled_FYT_jars/`. To tylko materiał do czytania;
  - `fuel_stats_example/`.
- **Stringi**:
  - nowe klucze tylko w `values/strings.xml` (EN);
  - nie zmieniaj treści istniejącego klucza z tłumaczeniami, gdy zmienia się jego znaczenie: nowy klucz, stary usuń.
    **Jedyny wyjątek**: `stats_window_summary` dostaje „(recommended)” tylko w `values/` (decyzja 6);
  - klucz, który przestaje być używany, usuń w `values/` i we **wszystkich** `values-*/strings.xml` w tym samym commicie (skryptem, cały element);
  - poza tym nie edytuj `values-*/`.
- **Usuwaj dopiero po `rg`** w całym `app/src` (wszystkie source sety, Java i XML, `--glob '!**/generated/**'`). Szukaj też nazw zasobów w napisach.
- **Testy JVM**: JUnit 5 (jak `CanbusClassesTest`). `unitTests.isReturnDefaultValues = true`, więc `android.*` i `org.json`
  zwracają w testach wartości domyślne. Parser, walidację, scalanie, CRC i estymator pisz w **czystej Javie**
  (`java.util.zip.CRC32` jest OK; bez `android.*`, `org.json`, `TextUtils`).
- **StrictMode jest włączony także w release.** Żadnego I/O plików, assetów ani `ContentResolver` na wątku głównym.
- Bez nowych zależności. Bez migracji zapisanych preferencji, z wyjątkiem reguły „`0`/`0` = brak” (C3), która jest tylko interpretacją przy odczycie.
- Duże pliki (`SettingsFragmentSecond` ≈2100 linii, `LogcatWorker` ≈1950, `CanbusService` ≈1350) edytuj punktowo.
- Kontrola bez SDK (opcjonalnie): `javac -proc:none -cp android_jar/android-36.jar -d <tmp> …` ze stubami w katalogu tymczasowym.

## Format biblioteki (`canbus_library`, wersja 1): asset, plik użytkownika i nakładka

Plik tekstowy UTF-8. Reguły:
- Pierwsza znacząca linia: `canbus_library 1`. Linie puste i `#…` są pomijane. BOM na początku jest dozwolony.
- Rekordy (pola rozdzielone `|`, spacje wokół pól dozwolone):
  ```
  C <ids> | <class>                                      klasa ekranu auta
  C <ids> | <class> | <alt> | portrait                   <alt>, gdy ekran jest pionowy (getConfiguration() == 1)
  C <ids> | <class> | <alt> | fytver:<tok>[,<tok>...]    <alt>, gdy /sys/fytver/fyt_bin_version zawiera któryś token
  R <ids> | <page> | <req>[; <req>...]                   strona spalania i jej zapytania, w kolejności
  N <ids>                                                auto nie wymaga zapytania (wyłącza fałszywe trafienie)
  end <records> <crc32>                                  stopka, ostatnia znacząca linia
  ```
- Elementy rekordów:
  - `<ids>`: dziesiętne `int` od 1 do 2147483647, rozdzielone przecinkami, 1–5000, bez powtórzeń w linii;
  - `<class>`, `<page>`: pełna nazwa klasy `com\.syu(\.[A-Za-z_$][A-Za-z0-9_$]*)+`, najwyżej 200 znaków;
  - `<alt>`: jak wyżej albo `-` (wtedy przy spełnionym warunku auto nie ma klasy);
  - `<tok>`: `[A-Za-z0-9]{1,16}`, 1–8 tokenów;
  - `<req>`: `cmd` albo `cmd:i,i,…`. `cmd` mieści się w 0..9999, `i` w −65536..65536 (najwyżej 8 liczb).
    Najwyżej 8 zapytań w linii `R`.
- **Spójność w jednym pliku**:
  - jedno ID ma najwyżej jeden rekord `C`;
  - strony `R` są unikalne po (ID, strona), najwyżej 10 stron na ID;
  - `N` i `R` dla tego samego ID wykluczają się;
  - identyczny rekord powtórzony w pliku jest duplikatem (pomijany i liczony), sprzeczny jest błędem.
- **Stopka**:
  - `<records>` to liczba linii `C`/`R`/`N`;
  - `<crc32>` to 8 małych cyfr szesnastkowych CRC-32 (`java.util.zip.CRC32` = Python `zlib.crc32`) liczonego po bajtach UTF-8
    wszystkich linii od nagłówka do linii przed `end` włącznie. Każda linia jest bez swojego `\r`/`\n` i zakończona `\n`. BOM się nie liczy;
  - po `end` dozwolone są tylko puste linie.
- **Plik jest poprawny tylko w całości.** Import zbiera wszystkie błędy (do 200, każdy z numerem linii i powodem) i przy choćby jednym kończy się porażką.
  Limity: 2 MB, 200 000 linii.
- **Scalanie** `base ⊕ file` (to samo dla `builtIn ⊕ overlay` i dla `overlay ⊕ importowany plik`).
  Każdy rekord pliku liczy się dokładnie raz jako *nowy*, *duplikat* albo *zastąpiony*:
  - `C` po ID: brak w bazie → nowy; identyczny → duplikat; inny → zastąpiony (wygrywa plik);
  - `R` po (ID, strona): brak → nowy; identyczne zapytania → duplikat; inne → zastąpiony.
    Kolejność stron dla ID: najpierw strony z pliku (w jego kolejności), potem strony bazy, których plik nie wymienia.
    Jeśli baza ma `N` dla tego ID, `N` znika;
  - `N` po ID: baza ma `N` → duplikat; baza ma strony `R` → zastąpiony (strony znikają); inaczej → nowy;
  - rekordy dla różnych ID nie wchodzą sobie w drogę.

Przykład (CRC przykładowy, prawdziwy liczy skrypt):
```
canbus_library 1
C 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi
C 274 | com.syu.carinfo.accord.ActivityAccord7Index | com.syu.carinfo.xp.psa_all.XpPsaAllIndexActi | portrait
R 163,221 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti | 70:51; 29:0
R 19 | com.syu.carinfo.honda.HondaTripActi | 100:1; 100:3
N 1
end 5 1a2b3c4d
```

## C1 — `Canbus: drop the command logger`

Usuń „Wstępną weryfikację” w całości.

1. `git rm app/src/main/java/com/android/launcher66/settings/CanbusCommandLogger.java`. Usuń jego `<service>` w `AndroidManifest.xml` (≈275).
2. `res/xml/creator_preferences.xml`: usuń `CustomPreferenceCategory` `logger_category` (≈241–262).
3. `git rm res/layout/dialog_logger_codes_layout.xml`.
4. `Keys.java`: usuń `CODE_LOGGER`, `CODE_LOGGER_DATA`, `STARTING_CMD_INT`, `STARTING_CMD_ARR`, `MAX_CMD_INT`, `MAX_CMD_ARR`,
   `CODE_LOGGER_TIMEOUT`, `OMIT_DIGITS`.
5. `SettingsFragmentSecond.java`: usuń wszystko, co dotyczy loggera.
   - Pola: ≈110, ≈135–139, ≈156–159, ≈165, ≈172.
   - Odczyty w ≈323–332.
   - Widoczność i listenery w ≈619, ≈629–646, ≈1581–1583.
   - Przypadki kliknięć `CODE_LOGGER`/`CODE_LOGGER_DATA` (≈900–927).
   - Sprzątanie ≈1058, ≈1061, ≈1216–1218.
   - `setLoggerTickRunnable`/`removeLoggerTickRunnable`/`loggerTickRunnable` (≈1357–1390) i `startLoggerService`/`stopLoggerService` (≈1411–1419).
   - `dialogCodesLoggerEditText`/`dialogCodesLoggerTimeoutEditText` (≈1490–1515) i `displayCodesLoggerDialog()` (≈1784–1855).
   - `saveLoggerCode` z walidacją zakresów (≈1998–2070).
   - `code_logger_*` w `setCalculatedSizes` (≈1913–1914).

   Szukaj też `rg -n -i 'logger|omitDigits|startingCmd|maxCmd'`. Inspektor i `LogcatWorker` zostają.
6. `Helpers.java`: usuń `codeLoggerBoolean`, `setCodeLoggerBoolean`, `returnCountDownLogger`, `setCountDownLogger` i ich pola (≈364–372, ≈461–469),
   jeśli `rg` nie pokazuje innych użyć.
7. `CanbusGuide.java` (≈60–63): usuń cztery pozycje „Initial reading”. Usuń `R.drawable.logger_guide` (wszystkie gęstości), jeśli nie ma innych użyć.
8. Usuń stringi (w `values/` i każdym `values-*/`):
   - `logger_category`, `code_logger_string`, `code_logger_summary`, `code_logger_summary_working`, `code_logger_data`,
     `code_logger_data_summary`;
   - `starting_cmd_int_text`, `starting_cmd_arr_text`, `max_cmd_int_text`, `max_cmd_arr_text`;
   - `code_logger_timeout_text`, `omit_digits`, `omit_digits_summary`, `code_logger_dialog_toast`, `code_logger_toast`;
   - `codes_guide_initial_reading_title`, `codes_guide_initial_reading_one`, `codes_guide_initial_reading_two`, `codes_guide_initial_reading_three`.
9. Kontrola: `rg -n 'CanbusCommandLogger|code_logger|CODE_LOGGER|OMIT_DIGITS|omit_digits|STARTING_CMD|MAX_CMD|starting_cmd|max_cmd|logger_category|codes_guide_initial|CountDownLogger|codeLoggerBoolean' app/src --glob '!**/generated/**'` → zero.

## C2 — `Canbus: a library of the cars' screens and requests, and the script that builds it`

Na razie bez zmiany zachowania: skrypt, asset, rdzeń w Javie i testy.

### C2.1 Folder `canbus_library/`

Zawartość: `build_canbus_library.py`, `build_canbus_library.bat`, `README.md`.

**`build_canbus_library.py`**:
- Python ≥ 3.8, tylko biblioteka standardowa, `pathlib`;
- wszystkie pliki czytane z `encoding='utf-8', errors='replace'`, zapis z `newline='\n'`;
- wynik deterministyczny (sortowanie);
- tryby:
  ```
  py build_canbus_library.py <src> [--out FILE] [--mapping FILE]   z dekompilatu com.syu.canbus (katalog "sources" albo dowolny nad nim)
  py build_canbus_library.py --launcher <repo> [--out FILE]        biblioteka wbudowana: CanbusClasses.java + decompiled_carinfo/
  py build_canbus_library.py --seal FILE                           przelicza stopkę ręcznie poprawionego pliku
  py build_canbus_library.py --check FILE                          walidacja jak w launcherze (te same reguły z §Format)
  ```
- domyślne `--out`: `canbus_library_<yyyy-MM-dd_HH-mm-ss>.txt` w katalogu bieżącym; dla `--launcher`: `app/src/main/assets/canbus_library.txt`;
- **źródło mapowania**:
  - `<src>`: szukaj `com/syu/canbus/ActivityLauncher.java` z metodą zawierającą `switch (DataCanbus.DATA[1000])`;
  - gdy go nie ma: plik z największą liczbą par `case` → (`cls = X.class` / `name = "…"`) w jednym `switch (DataCanbus.DATA[1000])`;
  - `--mapping` wskazuje plik ręcznie;
  - `--launcher`: `app/src/main/java/com/android/launcher66/settings/CanbusClasses.java`, metoda `className`;
  - zawsze wypisz, z którego pliku i metody wzięto mapowanie;
- **stałe**: wartość z komentarza `/* N */`. Bez komentarza: odczyt `public static final int X = N;` z `com/syu/module/canbus/FinalCanbus.java`
  w źródłach (w trybie `--launcher` z `app/src/main/java/com/syu/module/canbus/FinalCanbus.java`). Nierozwiązaną etykietę pomiń z ostrzeżeniem;
- **symulacja przełącznika** (nie zgadywanie liniami):
  - tokenizuj ciało `switch` na: etykiety `case`, przypisania (`cls = X.class;`, `cls = (Class<?>) X.class;`, `name = "…";`),
    `break;`, `return…;`, bloki `if (warunek) { … } else { … }` i `else if`;
  - dla każdego ID i każdej z 4 kombinacji (pion: tak/nie, fytver pasuje: tak/nie) wykonaj kod od etykiety tego ID z fall-through
    przez kolejne etykiety, aż do `break`/`return`/końca. Wynik to ostatnia przypisana klasa albo brak. `return` przed przypisaniem
    (np. 411 z `PROXY.cmd`) daje brak;
  - rozpoznawane warunki:
    - `(TheApp|LauncherApplication).getConfiguration() == 1` / `!= 1` (oraz `isPortrait()`);
    - alternatywa `readFile("/sys/fytver/fyt_bin_version").contains("…")` (tokeny zbierz);
    - negacje `!` tych form;
  - każdy inny warunek traktuj jako fałsz i wypisz ostrzeżenie z numerem linii;
  - rekord `C`:
    - wynik taki sam we wszystkich kombinacjach → `C ids | klasa`;
    - różnica tylko w orientacji → `| alt | portrait` (`klasa` = poziomo, `alt` = pionowo);
    - różnica tylko we fytver → `| alt | fytver:tokeny` (`klasa` = brak dopasowania);
    - brak klasy w kombinacji domyślnej (poziomo, bez dopasowania) → bez rekordu `C`, ale z ostrzeżeniem, jeśli `alt` istnieje;
    - różnica w obu wymiarach → kombinacja z pionem dla `alt` i ostrzeżenie;
  - nazwy `X.class` rozwiązuj przez importy pliku, potem ten sam pakiet, potem jednoznaczną prostą nazwę w źródłach.
    Niejednoznaczne lub nieznalezione: ostrzeżenie i pominięcie;
- **strony i zapytania** (rekordy `R`/`N`), po kolei:
  1. BFS od klas `C` danego ID (obu wariantów) po odwołaniach `\b([A-Z]\w+)\.class\b` do klas obecnych w źródłach, głębokość ≤ 3;
  2. strona spalania: prosta nazwa pasuje do `(?i)(oil|mile|trip|fuel|consum|drivinginfo)`, a w ciele `onCreate`/`onStart`/`onResume`
     są wywołania `PROXY.cmd(`;
  3. liczą się **tylko wywołania bezpośrednio w ciele metody** (także w `if`/`else`). Pomijaj klasy anonimowe (`new X(...) { … }`) i lambdy (`-> { … }`).
     `RZCLandRoverMilePage1Acti` ma `cmd(1,{1,6})` w `onClick`, a to nie może trafić do biblioteki;
  4. kolejność zapytań: `onCreate`, potem `onStart`, potem `onResume`, każda w kolejności źródła;
  5. postacie:

     | w źródle | w bibliotece |
     |---|---|
     | `cmd(N, new int[]{a, b}, …)` | `N:a,b` |
     | `cmd(N, new int[k], …)` | `N:` i k zer |
     | `cmd(N, v)` | `N:v` |
     | `cmd(N, a, b)` | `N:a,b` |
     | `cmd(N)` | `N` |

     Argument nieliteralny: pomiń i policz;
  6. kolejność stron dla ID: nazwa zawiera `_<id & 0xFFFF>_` → zawiera `Page1` → zawiera `Index` → mniejsza głębokość → alfabetycznie;
  7. ID bez stron nie dostaje rekordu `R` ani `N`. `N` jest tylko do ręcznego wyłączania;
- **wyjście**:
  - nagłówek, komentarze: źródło, plik mapowania, data i liczby;
  - rekordy `C` pogrupowane (jedna linia na identyczną treść, ID rosnąco);
  - rekordy `R` pogrupowane po (zbiór ID o identycznej liście stron, strona);
  - stopka według §Format;
- **na konsolę**: ID w mapowaniu, rekordy C/R, ID z zapytaniem, grupy stron, ostrzeżenia, pominięte wywołania, grupy z niejednoznaczną stroną główną
  (np. `Xp_374_OilDisplayActi`/`Xp_424_OilDisplayActi`) i ścieżka wyniku;
- kod wyjścia 0 przy sukcesie, 1 przy błędzie wejścia, 2 przy niepoprawnym pliku w `--check`;
- **oczekiwane liczby** (jako kontrola, rozbieżności wyjaśnij w raporcie):
  - `--launcher` na `7750437`: ≈3864 ID z klasą, 589 z zapytaniem, 13 grup, 26 stron;
  - `decompiled_com.syu.canbus/classes.dex/sources`: ≈2848 ID, ≈349 z zapytaniem.

**`build_canbus_library.bat`**:
- `@echo off`, `chcp 65001 >nul`, `setlocal`;
- użyj `py -3`, a gdy go nie ma, `python`. Gdy nie ma ani jednego, czytelny komunikat z odnośnikiem do python.org i `pause`;
- argumenty przekazuje bez zmian. Bez argumentów pyta o ścieżkę (`set /p`), także przy przeciągnięciu folderu na plik `.bat`;
- skrypt szuka obok siebie (`%~dp0build_canbus_library.py`), wynik zapisuje w bieżącym katalogu;
- na końcu `pause`, gdy uruchomiony dwuklikiem.

**`README.md`** (po angielsku, dla użytkownika Windows, **bez instrukcji dekompilacji**; tylko odnośnik do kroków 10–12 w głównym `README.MD`):
1. Czym jest biblioteka i po co ją budować (nowsza albo inna wersja `com.syu.canbus` niż w launcherze).
2. Wymagania: Windows 10/11, Python 3.8+ z python.org (zaznacz „Add python.exe to PATH”; `py` instaluje się z nim), dekompilat
   (folder `…\javaCode\classes.dex\sources`).
3. Krok po kroku:
   1. pobierz folder `canbus_library`;
   2. przeciągnij folder `sources` na `build_canbus_library.bat` albo uruchom w `cmd`:
      `build_canbus_library.bat "C:\APKRepatcher\Projects\com.syu.canbus.apk\javaCode\classes.dex\sources"`;
   3. co oznacza podsumowanie;
   4. gdzie jest plik wynikowy.
4. Przeniesienie na radio (pendrive, chmura, `adb push … /sdcard/Download/`) i import w launcherze. Podaj ścieżkę w ustawieniach,
   opis okna postępu, przycisków i raportu w `Download/Launcher66_Logs`.
5. Rozwiązywanie problemów:
   - „mapping not found” → `--mapping …\com\syu\canbus\ActivityLauncher.java`;
   - brak Pythona;
   - import odrzucony → raport i `--check`;
   - ręczna edycja → `--seal`.
6. Specyfikacja formatu (pełna treść §Format po angielsku, z przykładem i regułami scalania).

### C2.2 Asset

`python3 canbus_library/build_canbus_library.py --launcher .` → dodaj `app/src/main/assets/canbus_library.txt`.

### C2.3 `settings/CanbusLibrary.java`, rdzeń w czystej Javie

- `Request` (`cmd`, `int[] ints`, `toString()` → `70:51`/`100`), `Page` (`fqcn`, `List<Request>`),
  `CarClass` (`fqcn`, `alt` albo `null`, `condition`: `NONE`/`PORTRAIT`/`FYTVER` + tokeny);
- `Library` (niezmienna):
  - `static ParseResult parse(Reader, long sizeBytes, ProgressSink, CancelToken)`. Zwraca bibliotekę albo listę `Error(line, reason)` (do 200)
    oraz duplikaty wewnątrz pliku. `ProgressSink` dostaje przeczytane bajty, a `CancelToken.isCancelled()` jest sprawdzany co 200 linii
    i rzuca `CancelledException`;
  - `MergeResult mergedWith(Library file)`: nowa biblioteka oraz liczniki new/duplicate/replaced (osobno dla C/R/N)
    i lista zastąpionych ID (stara → nowa wartość, do raportu);
  - `List<Page> pagesFor(int id)` (pusta = nie wymaga zapytania);
  - `String classNameFor(int id, boolean portrait, String fytver)` (`null` = brak);
  - `String serialize()` (z poprawną stopką);
  - liczniki: aut z klasą, aut z zapytaniem, rekordów;
- `static String seal(String bodyWithoutFooter)`: dopisuje `end …` (dla `serialize` i testów);
- `static int[] parseInts(String)`: `"74,3"`/`" 74, 3 "` → `{74,3}`, `"51"` → `{51}`, `""` → `int[0]`, zły tekst → `null`.

### C2.4 Testy `app/src/test/java/com/android/launcher66/settings/CanbusLibraryTest.java`

- parsowanie przykładu z §Format (zapieczętowanego przez `seal`);
- każdy błąd z numerem linii:
  - brak nagłówka;
  - brak stopki, zła liczba rekordów, zły CRC, treść po `end`;
  - złe pole, cmd poza zakresem, 9 liczb, nazwa spoza `com.syu.`;
  - dwa `C` dla jednego ID, `N` razem z `R`;
  - plik > 2 MB;
- duplikat wewnątrz pliku jest liczony, a nie jest błędem;
- scalanie:
  - nowy, duplikat i zastąpiony dla C, R, N;
  - kolejność stron;
  - `R` usuwa `N` z bazy;
  - inne ID bez zmian;
  - liczniki;
- `serialize()` → `parse()` daje tę samą bibliotekę;
- przerwanie przez `CancelToken`;
- `parseInts`;
- **prawdziwy asset** (`new File("src/main/assets/canbus_library.txt")`; katalog roboczy testów to `app/`):
  - `classNameFor` zgodne z `CanbusClassesTest`: 1, 273, 16384453, 16646583, nieznane 999999999 → `null`;
  - 274: poziomo `com.syu.carinfo.accord.ActivityAccord7Index`, pionowo klasa, do której przechodzi przypadek 276 (odczytaj ją z `CanbusClasses`);
  - 12648900: `fytver ""` → `com.syu.carinfo.camry.luz.CamryIndexAct_LuZ`, `"xLs18x"` → `com.syu.carinfo.zhtd.bmw.LZNewAllBBASetFunc`;
  - 163: strona główna `com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti` z `70:51; 29:0`;
  - 19: `100:1; 100:3`;
  - 2687429: `11:74,3`;
  - 1: brak zapytania;
  - żadna strona nie kończy się na `RZCLandRoverMilePage1Acti`.

## C3 — `Fuel statistics: the codes read as the reader reads them, a request only for the cars that need one`

1. **Warstwa Androida w `CanbusLibrary`**:
   - jednowątkowy `ExecutorService`;
   - `builtIn` z `assets/canbus_library.txt`, `overlay` z `filesDir/canbus_library_user.txt` (C6);
   - `effective = builtIn ⊕ overlay` w polu `volatile`, unieważniany po imporcie i resecie;
   - `preload(Context)` na executorze;
   - `cached()` zwraca bibliotekę albo `null`, nigdy nie czyta plików na wątku głównym;
   - `loadBlocking(Context)` tylko poza wątkiem głównym;
   - `sendForCar(Context, int id)` na executorze:
     - strony puste → `Log.i` i nic;
     - zapytanie użytkownika (pkt 4) → tylko ono;
     - inaczej wszystkie zapytania strony głównej po kolei, przez `DataCanbus.PROXY.cmd(cmd, ints, null, null)`;
     - zwraca opis wysłanego.
2. **`CanbusService`**:
   - usuń ≈186–188;
   - `preload` w `onCreate`;
   - **odczyt kodów jak skaner**:
     - własny `IModuleCallback.Stub statsCallback` rejestrowany `DataCanbus.PROXY.register(statsCallback, code, 1)` dla `fuel`, `range`, `rpm` > 0;
     - przed rejestracją `unregister` tego kodu (bez podwójnej rejestracji);
     - w `update()` (wątek bindera): `ints != null && ints.length > 0` → wartość `ints[0]` do pól `fuelValue`/`rangeValue`/`rpmValue`
       (`volatile`), potem post na wątek główny do istniejących `mUpdaterOilExpend()` (≈1016), aktualizacji zasięgu (≈1046) i RPM (≈1069);
     - te metody czytają pola zamiast `DataCanbus.DATA[fuel/range/rpm]`;
     - listenery `NOTIFY_EVENTS[fuel/range/rpm]` w `addNotify()`/`removeNotify()` (≈1004–1014) usuń;
     - zakresy i formaty wyświetlania bez zmian;
   - listener `NOTIFY_EVENTS[1000]` (`addNotify(…, 1)`): gdy `DATA[1000] != 0`, (ponownie) zarejestruj kody i wywołaj `sendForCar`.
     `ConnectionCanbus.onDisconnected()` zeruje `DATA[1000]`, więc po każdym ponownym połączeniu przychodzi powiadomienie;
   - `onDestroy`/`removeNotify`: `unregister` kodów;
   - `static void resendRequestAfterWake()`: post 3000 ms, `sendForCar`, gdy `sInstance != null`.
     Wołaj ją z `WakeDetection.onWake` zaraz po bloku logcata (≈313).
3. Usuń extras `cmdInt`/`cmdArr` w `CanbusAsyncTask` (≈72–73) i `ServiceRestarter` (≈37–38). `Integer.parseInt` wysypałby się na `74,3`.
4. **Zapytanie użytkownika** (`CanbusLibrary.userRequest(SharedPreferences)`):
   - `CMD_INT` i `CMD_ARR` puste albo `"0"` → brak (stara wartość domyślna z `saveCode`);
   - inaczej `cmd = parseInt(CMD_INT)` i `ints = parseInts(CMD_ARR)`. Błąd → brak i `Log.w`.
5. **Okno „Kody canbus”** (`displayCodesDialog()` ≈1652–1712, `dialog_codes_layout.xml`):
   - widoki cmd mają `GONE`, gdy `cached()` jest `null` albo `pagesFor(DATA[1000])` jest puste;
   - gdy są widoczne:
     - pola z zapisaną wartością albo puste, a `setHint` pokazuje pierwsze zapytanie strony głównej;
     - `cmdArr` przyjmuje `0123456789,-` (`DigitsKeyListener`);
     - nowy `TextView` `@+id/known_requests_text` ze stringiem `stats_codes_known_requests` („Requests of this car's screens
       (empty fields send those of the first one):\n%1$s”), w liniach `ProstaNazwa: 70:51; 29:0`;
   - `fragment.onCreate` woła `preload`.
6. **Zapis pól cmd**: osobna metoda, nie `saveCode`.
   - Pusty tekst → `""`, `cmdArr` znormalizowany (`74,3`).
   - Zły tekst → toast `stats_codes_cmd_invalid` („cmdInt must be a number and cmdArr numbers separated by commas”) i bez zapisu.
   - Ukryte pola nie są zapisywane.
7. **Opis `stats_codes`** (≈563, ≈765–766, `saveCode` ≈1941–1950):
   - auto z zapytaniem → `stats_codes_summary_request` („Tap to set the canbus codes. \nFuel: %1$s, Range: %2$s, Request: %3$s”).
     `%3$s` to zapytanie użytkownika albo `stats_codes_request_auto` („%1$s (first screen)”);
   - inaczej → `stats_codes_summary_no_request` („Tap to set the canbus codes. \nFuel: %1$s, Range: %2$s”);
   - usuń wszędzie `stats_codes_summary`;
   - zamiast `cmdArr_code_text` daj `cmdArr_list_code_text` („cmdArr (e.g. 74,3):”), a stary usuń wszędzie.
8. Kontrola: `rg -n 'CMD_INT|CMD_ARR|cmdInt_code_int|cmdArr_code_int' app/src/main/java` → tylko `Keys`, `CanbusLibrary`, `SettingsFragmentSecond`.

## C4 — `Fuel statistics: the car's class comes from the library`

1. `CanbusClasses.determineClassName()`:
   - zamiast `className(carId)` użyj `CanbusLibrary.loadBlocking(ctx).classNameFor(carId, LauncherApplication.isPortrait(), readFile("/sys/fytver/fyt_bin_version"))`.
     Działa w `AsyncTask` poza wątkiem głównym;
   - zapis `"class " + name` / `vehicle_not_exist` bez zmian;
   - przypadek 411/LandRover (≈40–45) bez zmian;
   - `readFile` zrób package-private;
   - `className(int)` i przełącznik **zostają** (źródło dla `--launcher` i `CanbusClassesTest`). Dopisz w komentarzu klasy,
     że w czasie działania nazwa pochodzi z biblioteki;
   - przełącznika nie usuwaj w tej rundzie.
2. Po imporcie i resecie (C6) uruchom `new CanbusClasses().execute()` i odśwież opis „Statystyk”.
3. `values/strings.xml` (**tylko tam**): `stats_window_summary` → „Use the Canbus reader (recommended) or look for the necessary canbus codes
   in the class <b>%1$s</b> and its subclasses (see README.md)”.

## C5 — `Canbus: the code reader records every update and guesses what the codes are`

1. **`CanbusCodeInspector`**:
   - **rejestracja**: własny `IModuleCallback.Stub rawCallback` przez `DataCanbus.PROXY.register(rawCallback, code, 1)` dla 0..1199.
     Kolejność: `startTime`, zapytanie (`CanbusLibrary.sendForCar`), rejestracja, wszystko w `runSchedulerTask`.
     Wyrejestrowanie przez `PROXY.unregister` na `batchExecutor`. `addNotify`/`removeNotify` znikają. `ModuleCallbackCanbusProxy` bez zmian;
   - **zapis zdarzeń**: każde zdarzenie (wątek bindera) zapisuj jako `(System.currentTimeMillis(), ints[0] albo brak, reszta ładunku)` do listy kodu,
     pod `synchronized`. Limit 5000 zdarzeń na kod i 200 000 łącznie; nadmiar policz i podaj w nagłówku.
     `skip_codes` działa jak dotąd;
   - **czas zapisu**: domyślny czas inspektora 300 s zamiast 30 (`"30"` → `"300"` jako wartość domyślna wszędzie,
     gdzie czytany jest `CODE_INSPECTOR_TIMEOUT`: inspektor ≈63, `SettingsFragmentSecond` ≈346/≈652/≈932/≈944/≈2086). Zapisane wartości zostają;
   - **GPS (opcjonalnie)**: jeśli `ACCESS_FINE_LOCATION` jest już przyznane, podczas zapisu
     `DeviceLocation.requestUpdates(ctx, 1000L, receiver, Looper.getMainLooper())` (prędkość w km/h z czasem), z anulowaniem `Handle` na końcu.
     Nie pytaj o uprawnienie.
2. **Plik** (`Download/Launcher66_Canbus/CanbusCodes<timestamp>.txt`, jak dotąd), w kolejności:
   ```
   Canbus reader, 28-10-2026 21:05:11, 300 s
   Car: id 163 (protocol 163, car 0), class com.syu.carinfo…, callback Callback_0163_…, request: 70:51; 29:0
   GPS speed: 287 fixes | not recorded (no location permission)
   Codes with data: 87 (unchanged: 51); events: 12345; dropped: 0

   Likely meanings (best guesses, may be wrong):
   Code 91 - fuel consumption, instant (4.1-12.8 L/100 km as value/10, 62 changes)
   Code 92 - range (412-418 km, 6 changes, about every 52 s)
   Code 103 - RPM (690-2950, about 760 at idle)
   Code 45 - speed (0-87 km/h, follows the GPS speed)
   Not found: fuel consumption, average

   CODE: 91
   2026-10-28 21:05:11.123: 65
   2026-10-28 21:05:12.140: 68 [ints=68,1]
   …
   ```
   - Sekcje `CODE: n` mają układ jak w starym loggerze, ale bez `CMD:`.
   - Linia zdarzenia to `yyyy-MM-dd HH:mm:ss.SSS: <ints[0]>`, a w nawiasie reszta ładunku, jeśli jest (`ints`, `flts`, `strs`).
     Zdarzenie bez `ints` ma postać `-` z ładunkiem w nawiasie.
   - Kody bez zmian mają jedną linię z wartością.
   - Linia `Car:` zawiera:
     - ID, `id & 0xFFFF`, `id >>> 16`;
     - klasę z biblioteki (C4) albo `-`;
     - prostą nazwę klasy z `ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus()` (`Callback_0000_null` = launcher nie zna auta);
     - wysłane zapytanie albo `none`.
3. **`settings/CanbusCodeEstimator`** (czysta Java, testowalna):
   - wejście: zdarzenia per kod `(t, v)` i opcjonalnie seria GPS `(t, kmh)`;
   - wyjście: lista `Guess(code, category, score 0..1, reason)`;
   - statystyki per kod: liczba zdarzeń i zmian, wartości różne, min, max, mediana, percentyle, średni |Δ| na zmianę,
     odstępy między zmianami (średnia, współczynnik zmienności), udział spadków i wzrostów, korelacja z GPS (Pearson, po próbkowaniu co 1 s);
   - kategorie (progi to punkt wyjścia, możesz je dostroić testami):

     | kategoria | warunki |
     |---|---|
     | chwilowe spalanie | wartości w zakresie widżetu `0 < v < 3001`, ≥ 70% niezerowych w 20..250 (2,0–25,0 L/100 km jako `%d.%d` z `v/10`), ≥ 10 zmian, ≥ 5 różnych. Plus za korelację z RPM/GPS. Opis w L/100 km |
     | średnie spalanie | ten sam zakres, 1–20 zmian, głównie o ±1 |
     | zasięg | `0 ≤ v ≤ 2000`, większość w 20..1500, kroki ≤ 3, przewaga spadków, odstępy podobne (CV < 1). Bez zmian w zapisie: niski wynik i dopisek „(did not change while recording)” |
     | RPM | 0..8000, max ≥ 600, ≥ 10 zmian. Plus, gdy dolne 20% wartości skupia się w 500..1100 przy małym rozrzucie (bieg jałowy, postój) |
     | prędkość | 0..260, ≥ 5 zmian. Silnie przy korelacji z GPS ≥ 0,8, słabiej przy powrotach do 0 |
     | temperatura płynu | 0..130 albo 40..170 (przesunięcie +40), powolny wzrost o 1 albo stała |
     | napięcie akumulatora | 100..160 (×10 V) albo 10..16, mały rozrzut |
     | temperatura zewnętrzna | −40..60 albo 0..100 (+40), prawie stała |
     | poziom paliwa | 0..100, rzadkie spadki |
     | przebieg | ≥ 1000, nie maleje, małe kroki |
     | przełącznik/stan | ≤ 3 różne wartości z {0,1,2} |

   - przydział zachłanny: kod trafia do najlepszej kategorii. Na kategorię najwyżej 3 kandydatów z wynikiem ≥ 0,5,
     wypisywanych od najlepszego. Kategorie bez kandydata trafiają do „Not found: …”;
   - nagłówek sekcji dokładnie „Likely meanings (best guesses, may be wrong):”.
4. **Testy `CanbusCodeEstimatorTest`** na danych syntetycznych:
   - spalanie zmienne 40..130 co 1 s → chwilowe spalanie;
   - zasięg 418 → 412 co ~50 s → zasięg;
   - RPM 750±20 na postoju, potem 900..3000 → RPM;
   - prędkość zgodna z GPS → prędkość;
   - 0/1 → przełącznik;
   - stała → brak przypisania;
   - pusta seria → bez wyjątków.
5. **Okno i przewodnik**:
   - z `dialog_inspector_codes_layout.xml` usuń widoki cmd (`inspector_cmd_int_text`, `inspector_cmd_int`, `inspector_cmd_arr_text`, `inspector_cmd_arr`);
   - usuń `Keys.INSPECTOR_CMD_INT/ARR` i miejsca w `SettingsFragmentSecond` (≈141–142, ≈344–345, ≈663, ≈942–943, ≈1878–1898, ≈2084–2085)
     oraz extras w `startCanbusCodeInspector()` (≈1397–1399);
   - nowy `code_inspector_data_summary_time` („Tap to set the recording time. \nTimeout: %1$s”) zamiast `code_inspector_data_summary`;
     usuń wszędzie `code_inspector_data_summary`, `inspector_cmd_int_text`, `inspector_cmd_arr_text`;
   - `CanbusGuide`: zamiast `codes_guide_detailed_reading` → `codes_guide_inspector`, a zamiast `codes_guide_miscellaneous` → `codes_guide_skip_codes`.
     Treść: brak losowych komend, wszystkie kody, każda zmiana z czasem, oszacowania na początku pliku (mogą się mylić), zalecenie
     „drive for a few minutes, with a stop at idle”, zapytanie tylko dla aut z biblioteki, GPS przy przyznanym uprawnieniu.
     Stare klucze usuń wszędzie.

## C6 — `Canbus: import a library from a file, with progress, cancel and a report`

1. **Preferencje** w `creator_preferences.xml`, kategoria `canbus_reader`, za `skip_codes`. Widoczne jak pozostałe przy `display_canbus_reader` (≈619/≈1581):
   - `canbus_library_import`: „Import a canbus library”, opis `canbus_library_import_summary` („Cars with a class: %1$d, with a request: %2$d
     (imported records: %3$d). How to build one: canbus_library/README.md”);
   - `canbus_library_reset`: „Remove the imported libraries”, widoczna tylko przy istniejącej nakładce. Potwierdzenie `canbus_library_reset_confirm`.
2. **Wybór pliku**: `registerForActivityResult(new ActivityResultContracts.OpenDocument(), …)` z typami `{"text/plain", "application/octet-stream", "*/*"}`.
   Rozmiar i nazwa z `OpenableColumns` (na executorze). W trakcie importu preferencja jest wyłączona; drugi import nie startuje.
3. **Okno postępu** (`res/layout/dialog_canbus_library_import.xml`, styl i rozmiary jak w innych oknach fragmentu: `setCalculatedSizes`, `SettingsActivity.dialog*`):
   - tytuł `canbus_library_import_title`, linia stanu (faza i „line X of Y”), poziomy `ProgressBar` 0..100;
   - przyciski „Cancel” (`canbus_library_cancel`) i „Run in background” (`canbus_library_background`), `setCancelable(false)`;
   - fazy: walidacja 0–70% (bajty), scalanie 70–90%, zapis 90–100%. Od początku zapisu przycisk „Cancel” jest wyłączony.
4. **Praca** na executorze `CanbusLibrary`:
   1. `parse` pliku;
   2. przy błędach: porażka;
   3. `newOverlay = overlay ⊕ plik` (liczniki z tego scalenia);
   4. `effective = builtIn ⊕ newOverlay`;
   5. zapis `newOverlay.serialize()` przez `android.util.AtomicFile` do `filesDir/canbus_library_user.txt`;
   6. unieważnienie `effective`, `CanbusClasses` (C4), odświeżenie opisów (wątek główny, `isAdded()`).

   **Przerwanie** przed zapisem: `CancelToken`, `AtomicFile.failWrite`, stara baza nietknięta, bez raportu, Toast
   `canbus_library_cancelled` („Canbus: Import cancelled, the library is unchanged”).
5. **Raport** (sukces i porażka):
   - katalog `LogcatWorker.usablePublicDir(ctx)`, a gdy go nie ma, `LogcatWorker.resolveFallbackDir(ctx)`;
   - nazwa `canbus_library_success_<dd-MM-yyyy_HH-mm-ss>.txt` / `canbus_library_failed_<…>.txt` (`LogFileName.NAME_PATTERN`; przy kolizji `_N`);
   - treść:
     - czas, nazwa i rozmiar pliku źródłowego, wynik, czas trwania;
     - nagłówek i stopka (oczekiwane i policzone);
     - rekordy w pliku i duplikaty wewnątrz niego;
     - new/duplicate/replaced dla C/R/N, a przy zastąpionych ID wartość stara → nowa;
     - auta z klasą i z zapytaniem przed i po;
     - przy porażce wszystkie zebrane błędy (linia i powód);
   - w dialogu i Toaście pokazuj rzeczywistą ścieżkę: `Download/Launcher66_Logs`, gdy publiczny katalog, inaczej pełną.
6. **Zakończenie przy otwartym oknie**:
   - zamknij okno postępu i pokaż `AlertDialog` (OK);
   - sukces `canbus_library_import_done`: „Library imported.\nNew records: %1$d\nSkipped duplicates: %2$d\nReplaced (the file won): %3$d\n\nReport: %4$s”;
   - porażka `canbus_library_import_failed`: „Import failed, the library is unchanged.\n%1$s\n\nReport: %2$s”, gdzie `%1$s` to pierwszy błąd z linią;
   - gdy raportu nie udało się zapisać, `canbus_library_report_not_saved` („the report could not be saved”) w miejscu ścieżki;
   - fragment odłączony → zachowanie jak „w tle”.
7. **„Run in background”**: zamknij okno, praca trwa. Na końcu Toast z kontekstu aplikacji:
   - `canbus_library_toast_success` („Canbus: Success, report saved in %1$s”);
   - `canbus_library_toast_failed` („Canbus: Failed, report saved in %1$s”).
8. **Reset**: usuń plik nakładki (na executorze), unieważnij, `CanbusClasses`, Toast `canbus_library_reset_done`, odśwież.

## C7 — `Logcat: a stop button over every screen for a capture started by hand`

1. **`LogcatWorker`**:
   - `public interface CaptureEndListener { void onCaptureEnded(); }` z `CopyOnWriteArrayList`, `addCaptureEndListener` i `removeCaptureEndListener`;
   - wywołanie na wątku głównym w poście z `beginDrain()` (≈1790, przy `cancelCountdown()`): koniec czasu (`beginDrain("time limit")`) i `stop()`;
   - drugie wywołanie w poście z `finishOnce()` (≈1844). Słuchacze idempotentni;
   - `public boolean isManualCapture()` → `running && !draining && trigger == Trigger.MANUAL`;
   - `StateListener` bez zmian.
2. **`FabOverlayService`**, bez zmiany zachowania:
   - `static int fabSizePx(Context)` z `computeFabSizePx()` (8% krótszego boku z `getResources().getDisplayMetrics()`, min. 40 dp);
   - `static int statusBarHeightPx(Context)` z `getStatusBarHeight()` (≈806);
   - obie metody instancji wołają nowe;
   - `excludeFromSystemGestures(View)` (≈404) i `BACKGROUND_ALPHA` zrób package-private;
   - obsługi dotyku nie refaktoryzuj ani nie wydzielaj.
3. **Nowa `settings/LogcatStopButton`** (singleton, wątek główny, bez `Service` i bez manifestu):
   - `show(Context app)`:
     - nic nie rób, gdy `!LogcatWorker.get().isManualCapture()`, gdy przycisk już jest albo gdy `!Settings.canDrawOverlays(app)` (`Log.w`);
     - okno przez `WindowManager` z kontekstu aplikacji:
       - flagi jak `FabOverlayService.createLayoutParams()` (≈377): `TYPE_APPLICATION_OVERLAY`,
         `FLAG_NOT_FOCUSABLE | FLAG_NOT_TOUCH_MODAL | FLAG_LAYOUT_IN_SCREEN | FLAG_LAYOUT_NO_LIMITS`, `TRANSLUCENT`;
       - `gravity = TOP|LEFT`, `h = FabOverlayService.fabSizePx(app)`, `w = 2*h`;
       - pozycja przed `addView()`;
       - `FLAG_NOT_FOCUSABLE` jest konieczne (`PinnedPipFocus`, `HomeFrontGuard`);
       - API 29+: `excludeFromSystemGestures`;
     - rejestracja `CaptureEndListener` i `ComponentCallbacks`;
   - **pozycja** (zasady `FabOverlayService.resolvePosition`/`applySavedPosition`/`clampX`/`clampY`, ≈426–475):
     - klucze `Keys.LOGCAT_STOP_X = "logcat_stop_button_x"`, `LOGCAT_STOP_Y = "logcat_stop_button_y"`, `LOGCAT_STOP_SAVED = "logcat_stop_button_saved"`
       w domyślnych `SharedPreferences`;
     - `float`, odczyt z `try/catch ClassCastException`, wartość ujemna albo NaN = brak;
     - brak pozycji → wyśrodkowany u góry: `x = (W - w)/2`, `y = statusBarHeightPx`;
     - `clampX = max(0, min(x, W - w))`, `clampY = max(pasek, min(y, H - h))`;
   - **przeciąganie, jak `FabOverlayService`** (`attachTouchHandler`/`trackFinger`/`onDragFinished`, ≈523–611; własna kopia logiki):
     - `DOWN` zapamiętuje punkt i pozycję;
     - przeciąganie dopiero po `getScaledTouchSlop()`, pozycja względem `DOWN`, przez `clamp`, `updateViewLayout` tylko przy zmianie;
     - `POINTER_DOWN`/`POINTER_UP` → nowy punkt odniesienia (`reanchor`);
     - `UP` najpierw uwzględnia ostatnią pozycję. Po przeciąganiu zapis pozycji. Bez przeciągania i krócej niż `getLongPressTimeout()` → `performClick()`.
       Długie przytrzymanie nic nie robi;
     - `CANCEL` kończy przeciąganie z zapisem;
     - zapis tylko po przeciągnięciu;
   - **zmiana konfiguracji** (jak `FabOverlayService.onConfigurationChanged`, ≈220–238): przelicz `h`, `w` i ekran.
     Przy przeciąganiu tylko `clamp`, inaczej pozycja od nowa. `updateViewLayout` w `try/catch IllegalArgumentException`;
   - **widok**: `TextView` ze stringiem `logcat_stop_button` („Stop logcat”):
     - wyśrodkowany, jedna linia, pogrubiony;
     - kolor `@color/logcat_stop_text` = `#FFF44336`;
     - autosize do 0,3·h;
     - tło `GradientDrawable` (czarny z alfą `BACKGROUND_ALPHA`, promień `h * 0.25f`, stała `CORNER_FRACTION`), bez elewacji;
   - **kliknięcie**: wyłącz widok, `LogcatWorker.get().stop(true, app)`, dokładnie jak `stopLogcatRun()`. Przycisk znika przez `onCaptureEnded`;
   - `hide()`: `removeViewImmediate` w `try/catch`, wyrejestrowanie słuchaczy, wyzerowanie. `onCaptureEnded()` → `hide()`,
     więc przycisk znika sam przy planowym końcu czasu.
4. **`SettingsFragmentFirst`**:
   - `startLogcatRun()` (≈1147) po `start(…, Trigger.MANUAL)` woła `LogcatStopButton.show(requireContext().getApplicationContext())`. Nigdzie indziej;
   - z `stopLogcatRun()` wydziel `showLogcatStoppedUi()`;
   - `CaptureEndListener` fragmentu rejestruj przy `setStateListener` (≈510), a wyrejestruj przy `clearStateListener` (≈1035).
     Przy `isAdded()` woła `showLogcatStoppedUi()`.
5. Stringi i kolor tylko w `values/`. Klucze pozycji tylko w `Keys`.

## C8 — `README: fuel statistics with the canbus library`

`README.MD`, sekcja statystyk paliwa (≈205–296):
- pola cmdInt/cmdArr tylko dla aut, przy których launcher je pokazuje (przykład `70/51` zostaje jako ilustracja);
- puste pola wysyłają zapytania pierwszego ekranu;
- kody najprościej znaleźć skanerem i jego oszacowaniami;
- brakujące albo nowsze auto: zbuduj i zaimportuj bibliotekę (odnośnik do `canbus_library/README.md`);
- usuń wzmianki o „Initial reading”;
- w krokach 10–12 dopisz, że dekompilat można dalej przekazać skryptowi.

Do `decompiled_carinfo/README.md` dopisz jedno zdanie, że bibliotekę wbudowaną buduje `canbus_library/build_canbus_library.py --launcher .`.

## 4. Czego NIE zmieniać

- `ModuleCallbackCanbusProxy`, `Callback_*`, `HandlerCanbus`, `DataCanbus` i `ConnectionCanbus`.
- Przełącznik `CanbusClasses.className()`: tylko czytany przez skrypt i testy. Przypadek 411/LandRover.
- W statystykach: zakresy, formaty, okna i położenie (zmienia się tylko źródło wartości w C3).
- `LogcatWorker` poza C7.1 (`usablePublicDir`/`resolveFallbackDir` tylko wywołujesz).
- `FabOverlayService` poza C7.2.
- Profile baseline, CI, `decompiled_*`, `fuel_stats_example/`.
- Tłumaczenia poza usuwaniem nieużywanych kluczy.

## 5. Weryfikacja

1. Po każdym commicie: kontrole `rg` z kroku, CI zielone.
2. Kontrola końcowa:
   - `rg -n 'CanbusCommandLogger|INSPECTOR_CMD|code_logger|stats_codes_summary"|code_inspector_data_summary"' app/src --glob '!**/generated/**'` → zero;
   - `rg -n 'PROXY\.cmd\(' app/src/main/java/com/android/launcher66` → tylko `CanbusLibrary` i `CanbusClasses` (411);
   - `python3 canbus_library/build_canbus_library.py --launcher . --out /tmp/x.txt && diff /tmp/x.txt app/src/main/assets/canbus_library.txt` → brak różnic;
   - `python3 canbus_library/build_canbus_library.py --check app/src/main/assets/canbus_library.txt` → kod 0;
   - `python3 canbus_library/build_canbus_library.py decompiled_com.syu.canbus/classes.dex/sources --out /tmp/app.txt` → liczby jak w C2.1,
     potem `--check /tmp/app.txt` → 0;
   - zmień jeden znak w kopii → `--check` → 2 (CRC), a `--seal` naprawia;
   - plik `.bat` sprawdź przynajmniej na sucho (składnia, ścieżki z spacjami w cudzysłowie). Na Windows sprawdzi go właściciel.
3. Scenariusze dla właściciela (7862, 7870), wypisz je w raporcie:
   - a) auto spoza biblioteki: brak pól cmd, opis bez „Request”, żadnego `PROXY.cmd` przy starcie, wybudzeniu i skanerze; statystyki działają;
   - b) auto z zapytaniem:
     - pola z podpowiedzią i listą;
     - puste pola: zapytania strony głównej po połączeniu i 3 s po wybudzeniu;
     - własne `70`/`51`: tylko ono;
     - `74,3` zapisuje się;
   - c) statystyki pokazują kod znaleziony skanerem także dla kodu spoza zakresu `Callback_XXXX`;
   - d) skaner:
     - nagłówek z autem, oszacowania;
     - sekcje `CODE: n` z czasem;
     - przy jeździe kilka minut oszacowania wskazują spalanie, zasięg i RPM;
     - GPS przy uprawnieniu;
   - e) import pliku z `decompiled_com.syu.canbus`:
     - okno postępu, dialog z liczbami;
     - duplikaty pominięte, ≈300 ID zastąpionych, ≈24 nowe (liczby z raportu);
     - raport `canbus_library_success_…` w `Download/Launcher66_Logs`;
     - klasa w „Statystykach” dla zastąpionego ID się zmienia;
   - f) ten sam plik drugi raz → wszystko duplikatami, 0 nowych;
   - g) plik z jednym zmienionym znakiem → porażka z błędem CRC, raport `canbus_library_failed_…`, biblioteka bez zmian;
   - h) „Cancel” w trakcie → Toast, bez raportu, bez zmian;
   - i) „Run in background” → Toast „Canbus: Success, report saved in Download/Launcher66_Logs”;
   - j) reset przywraca bibliotekę wbudowaną;
   - k) logcat:
     - przycisk po „Tap to start logging”, wyśrodkowany u góry;
     - przeciąganie przesuwa, drgnięcie nie, długie przytrzymanie nic nie robi;
     - tap zatrzymuje jak preferencja;
     - znika sam po czasie;
     - pozycja zapamiętana;
     - brak przycisku przy logcacie z zimnego startu i wybudzenia;
     - bez uprawnienia nakładki brak przycisku;
     - fokus zostaje w aplikacji pod spodem.

## 6. Raport końcowy (w odpowiedzi, po polsku)

- Commity (hash + temat) i wynik CI każdego.
- Liczby skryptu dla `--launcher` i dla `decompiled_com.syu.canbus`, ostrzeżenia (warunki nierozpoznane, niejednoznaczne strony główne).
- Każde odstępstwo od instrukcji i jego powód.
- Nowe klucze w `values/strings.xml` (do tłumaczenia) i klucze usunięte ze wszystkich języków.
- Scenariusze z pkt 5.3.
