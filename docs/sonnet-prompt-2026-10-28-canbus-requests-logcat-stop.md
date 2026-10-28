# Launcher Mod: zapytania canbus tylko dla aut, które ich wymagają, pasywny inspektor kodów, import tabeli i przycisk „Stop logcat” — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.

Zrób siedem commitów w kolejności C1 → C7. **Każdy commit musi się budować samodzielnie.** Wypychaj je na tę gałąź.
**Nie twórz pull requesta.**

Numery linii to stan z `620fd61` i są orientacyjne (≈). Zawsze sprawdzaj je w kodzie.

## 0. Cel, fakty i decyzje właściciela

**Co to jest cmdInt/cmdArr.** To nie kod danych, tylko **komenda do CAN-boxa**: `DataCanbus.PROXY.cmd(cmdInt, new int[]{cmdArr})`.
Jej znaczenie zależy od protokołu auta. Przykład RZC PSA 408 w `decompiled_carinfo/com/syu/carinfo/rzc/biaozhi408/`:

| komenda | co robi |
|---|---|
| `70/{51}`, `71/{52}`, `72/{53}` | „wyślij stronę 1/2/3 komputera pokładowego” |
| `29/{0..2}` | przełącza stronę |
| `10/{0..3}` | ustawia czas świecenia świateł po wyłączeniu auta |
| `9` i `88/{x,v}` | przełączniki ustawień auta |

`cmd(0,{0})` w innych autach to np. przycisk ustawienia zegara (Mazda, `MzdClockSetActi`) albo przełącznik
ostrzeżeń (`LiFan720IndexAct`). Większość CAN-boxów sama wysyła spalanie i zasięg. Tylko część aut wysyła je dopiero
na zapytanie, które oryginalny ekran spalania wysyła przy otwarciu.

**Fakty z kodu:**
- `CanbusCommandLogger` wysyła **każdą** parę cmdInt×cmdArr z zakresu, czyli losowe komendy, także zmieniające ustawienia auta.
  Trwa to godziny.
- `CanbusService.onStartCommand` (≈186–188) wysyła `cmd(cmdInt,{cmdArr})` raz, przy starcie, **każdemu** autu.
  Domyślnie jest to `0/{0}`. `RemoteModuleProxy.cmd` gubi komendę po cichu, jeśli `com.syu.ms` nie jest jeszcze połączone.
- `cmdArr` przyjmuje jedną liczbę, a część aut wymaga dwóch: GM Andra `11/{74,3}`, Fiat RZC `1/{80,1}`, Golf7 XP `98/{80,255}`.
  `saveCode()` (≈1941) zapisuje pusty tekst jako `"0"`.
- `CanbusCodeInspector` słucha `DataCanbus.NOTIFY_EVENTS`, więc widzi tylko kody zarejestrowane przez `Callback_XXXX.in()`
  (np. `Callback_0001` → 0..122, nieznane auto → `Callback_0000_null` → tylko kod 0). Zapisuje też tylko `ints[0]`
  (`HandlerCanbus.update`). `startCanbusCodeInspector()` (≈1394) wysyła `Keys.CMD_INT/CMD_ARR` ze statystyk, a nie
  `INSPECTOR_CMD_*` z własnego okna.
- `IRemoteModule.register/unregister` są `oneway` (flaga 1 w `transact`), więc rejestracja kodu, którego `com.syu.ms` nie zna,
  nie zwraca wyjątku.

**Decyzje właściciela (nie zmieniaj ich):**
1. „Wstępną weryfikację” usunąć **bez zamiennika**.
2. Kody znajduje się tylko z pliku „Szczegółowej weryfikacji”, która ma być **pasywna** (bez własnych komend) i zapisywać wszystko, co wysyła `com.syu.ms`.
3. Pola cmdInt/cmdArr mają być **widoczne tylko dla aut, które wymagają zapytania**. Dla pozostałych nie ma ich na ekranie
   (nie wystarczy wyłączyć czy wyczyścić pole), a launcher **nie wysyła tym autom żadnej komendy**.
4. Tabelę aut wymagających zapytania generuje skrypt z `decompiled_carinfo`. Można ją uzupełnić **plikiem spoza aplikacji**,
   który jest scalany z istniejącą tabelą, jeśli ma poprawną strukturę.
5. Logcat uruchomiony przez „Tap to start logging” (**i tylko wtedy**) pokazuje nad wszystkimi ekranami przycisk „Stop logcat” (§C6).
6. **Nowe stringi tylko w `app/src/main/res/values/strings.xml`.** Tłumaczeniami zajmie się właściciel.

## 1. Zasady pracy i konwencje repo (jak w poprzednich rundach)

- **Commity po angielsku**:
  - temat `<Obszar>: <co>` (tematy podane przy krokach), treść zawinięta na ~72 znaki;
  - w treści napisz *dlaczego* (fakty z §0);
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push** po każdym commicie: `git push -u origin ccr-087eed00-gbqsuz`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
  Przed następnym commitem poczekaj na wynik CI (`.github/workflows/build.yml`: `testFytDebugUnitTest`, `assembleFytDebug`,
  `assembleStandardDebug`; `cancel-in-progress`). Sprawdzaj przez GitHub MCP (`actions_list`, `get_job_logs`). Czerwony
  build naprawiaj kolejnym commitem, bez amend i force-push.
- **Nie ruszaj**:
  - `.github/workflows/*` ani commita `[BRANCH-ONLY]`;
  - `app/src/main/generated/baselineProfiles/` (właściciel wygeneruje profile na nowo);
  - `decompiled_carinfo/com/**` i `decompiled_FYT_jars/`. To tylko materiał do czytania. Wolno dodać skrypt i README w `decompiled_carinfo/`.
- **Stringi**:
  - nowe klucze tylko w `values/strings.xml` (EN);
  - **nie zmieniaj treści istniejącego klucza**, który ma tłumaczenia, gdy zmienia się jego znaczenie. Utwórz nowy klucz, a stary usuń;
  - klucz, który przestaje być używany, usuń w `values/` i we **wszystkich** `values-*/strings.xml` w tym samym commicie
    (skryptem, cały element do `</string>`), żeby nie zostały osierocone tłumaczenia;
  - poza takim usuwaniem nie edytuj żadnego `values-*/`.
- **Usuwaj dopiero po sprawdzeniu `rg`** w całym `app/src` (wszystkie source sety, Java i XML, `--glob '!**/generated/**'`).
  Szukaj także samej nazwy zasobu w napisach.
- **Testy JVM**: JUnit 5 (jak `CanbusClassesTest`). `unitTests.isReturnDefaultValues = true`, więc `android.*` i `org.json`
  zwracają w testach wartości domyślne. Kod parsera i scalania tabeli pisz w czystej Javie (bez `org.json`, `android.util`,
  `TextUtils`), żeby dało się go przetestować.
- **StrictMode jest włączony także w release** (`5bb6e2d`). Nie rób I/O plików ani assetów na wątku głównym.
- Bez nowych zależności i bez migracji zapisanych preferencji. Jedyny wyjątek to reguła „`0`/`0` = brak” w C3, a jest to tylko interpretacja przy odczycie.
- Duże pliki (`SettingsFragmentSecond` ≈2100 linii, `LogcatWorker` ≈1950) edytuj punktowo. Nie przenoś istniejącego kodu.
- Kontrola bez SDK (opcjonalnie): `javac -proc:none -cp android_jar/android-36.jar -d <tmp> …` ze stubami w katalogu tymczasowym.

## Format tabeli zapytań (`canbus_requests`, wersja 1) — wspólny dla assetu, importu i nakładki

Plik tekstowy UTF-8. Reguły:
- Pierwsza znacząca linia: `canbus_requests 1`.
- Linie puste i zaczynające się od `#` są pomijane. BOM na początku jest dozwolony.
- Każda inna linia to wpis z trzema polami rozdzielonymi `|` (spacje wokół pól są dozwolone):
  ```
  <id>[,<id>...] | <strona> | <zapytanie>[; <zapytanie>...]
  ```
  - `<id>` to dziesiętne `int` (wartość `DataCanbus.DATA[1000]`). Lista nie może być pusta.
  - `<strona>` to nazwa klasy ekranu źródłowego (`[A-Za-z0-9_.$]+`) albo `-`.
  - `<zapytanie>` ma postać `cmd` albo `cmd:i,i,...`. `cmd` i `i` to dziesiętne `int` (dozwolony minus).
    `cmd` bez `:` oznacza zapytanie bez tablicy (`int[0]`). Zamiast listy zapytań może stać `-`.
  - `-` w obu polach naraz (`163 | - | -`) oznacza: „to auto **nie wymaga** zapytania”. Służy do wyłączenia fałszywego trafienia.
    `-` tylko w jednym polu to błąd.
- Kilka linii może dotyczyć tego samego ID. Ich kolejność to kolejność stron, a **pierwsza strona jest główna**.
  Wpis `-` dla danego ID nie może występować razem ze stronami tego samego ID w jednym pliku.
- **Plik jest poprawny tylko w całości.** Pierwszy błąd (nagłówek, liczba pól, liczba, nazwa, sprzeczny `-`) odrzuca cały plik
  i podaje numer linii oraz powód. Limit rozmiaru importu: 1 MB.
- **Scalanie** `base.mergedWith(overlay)`: każde ID obecne w `overlay` dostaje dokładnie strony z `overlay`
  (albo „nie wymaga”, jeśli wpis to `-`). Wszystkie pozostałe ID zostają z `base`.

Przykład:
```
canbus_requests 1
# RZC PSA 408
163,221,238 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti | 70:51; 29:0
163,221,238 | com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage2Acti | 71:52; 29:1
19 | com.syu.carinfo.honda.HondaTripActi | 100:1; 100:3
1 | - | -
```

## C1 — `Canbus: drop the command logger`

Usuń „Wstępną weryfikację” w całości.

1. `git rm app/src/main/java/com/android/launcher66/settings/CanbusCommandLogger.java`. Usuń jego `<service>` w `AndroidManifest.xml` (≈275).
2. `res/xml/creator_preferences.xml`: usuń cały `CustomPreferenceCategory` `logger_category` (≈241–262: `code_logger`, `code_logger_data`, `omit_digits`).
3. `git rm res/layout/dialog_logger_codes_layout.xml`.
4. `Keys.java`: usuń `CODE_LOGGER`, `CODE_LOGGER_DATA`, `STARTING_CMD_INT`, `STARTING_CMD_ARR`, `MAX_CMD_INT`, `MAX_CMD_ARR`,
   `CODE_LOGGER_TIMEOUT`, `OMIT_DIGITS`. `CMD_INT`/`CMD_ARR` zostają.
5. `SettingsFragmentSecond.java`: usuń wszystko, co dotyczy loggera.
   - Pola: ≈110 `loggerTickRunnableBool`, ≈135–139, ≈156–159, ≈165 `loggerTickHandler`, ≈172 `alertCodesLoggerDialog`.
   - Odczyty w ≈323–332.
   - Widoczność i listenery w ≈619 i ≈629–646 oraz ≈1581–1583.
   - Przypadki `Keys.CODE_LOGGER` i `Keys.CODE_LOGGER_DATA` w kliknięciach (≈900–927).
   - Sprzątanie w `onDestroy`/`onPause` (≈1058, ≈1061) i w `dismissDialogs` (≈1216–1218).
   - `setLoggerTickRunnable`/`removeLoggerTickRunnable`/`loggerTickRunnable` (≈1357–1390) i `startLoggerService`/`stopLoggerService` (≈1411–1419).
   - `dialogCodesLoggerEditText`/`dialogCodesLoggerTimeoutEditText` (≈1490–1515) i `displayCodesLoggerDialog()` (≈1784–1855).
   - `saveLoggerCode` (≈1998) razem z walidacją zakresów STARTING/MAX i `CODE_LOGGER_TIMEOUT` (≈2004–2070).
   - Identyfikatory `code_logger_*` w `setCalculatedSizes` (≈1913–1914).

   Szukaj dodatkowo `rg -n -i 'logger|omitDigits|startingCmd|maxCmd' …/SettingsFragmentSecond.java`.
   Wyniki dotyczące `codeInspector`, `LogcatWorker` itp. zostają.
6. `Helpers.java`: usuń `codeLoggerBoolean()`, `setCodeLoggerBoolean()`, `returnCountDownLogger()`, `setCountDownLogger()`
   razem z polami (≈364–372, ≈461–469), jeśli `rg` nie pokazuje innych użyć.
7. `CanbusGuide.java` (≈60–63): usuń cztery pozycje sekcji „Initial reading” (tytuł, dwa opisy, obraz).
   Usuń `R.drawable.logger_guide` (wszystkie gęstości), jeśli `rg 'logger_guide'` pokazuje tylko to miejsce.
8. Stringi do usunięcia (w `values/` i każdym `values-*/`):
   - `logger_category`, `code_logger_string`, `code_logger_summary`, `code_logger_summary_working`, `code_logger_data`,
     `code_logger_data_summary`;
   - `starting_cmd_int_text`, `starting_cmd_arr_text`, `max_cmd_int_text`, `max_cmd_arr_text`;
   - `code_logger_timeout_text`, `omit_digits`, `omit_digits_summary`, `code_logger_dialog_toast`, `code_logger_toast`;
   - `codes_guide_initial_reading_title`, `codes_guide_initial_reading_one`, `codes_guide_initial_reading_two`, `codes_guide_initial_reading_three`.
9. Kontrola: `rg -n 'CanbusCommandLogger|code_logger|CODE_LOGGER|OMIT_DIGITS|omit_digits|STARTING_CMD|MAX_CMD|starting_cmd|max_cmd|logger_category|codes_guide_initial|CountDownLogger|codeLoggerBoolean' app/src --glob '!**/generated/**'` → zero.

## C2 — `Canbus: the requests the cars' fuel pages send, as a table`

Na razie bez zmiany zachowania: generator, asset i parser z testami.

1. **Generator** `decompiled_carinfo/gen_canbus_requests.py`. Python 3, tylko biblioteka standardowa, wynik deterministyczny.
   Uruchamiany z katalogu głównego repo:
   `python3 decompiled_carinfo/gen_canbus_requests.py [--out app/src/main/assets/canbus_requests.txt]`.
   - Mapowanie ID → klasa: parsuj `static String className(int carId)` w
     `app/src/main/java/com/android/launcher66/settings/CanbusClasses.java`.
     - Etykiety to `case <liczba>:` albo `case FinalCanbus.X /* <liczba> */:`. Licz liczbę z komentarza.
     - `name = "<fqcn>";` przypisuje nazwę wszystkim zebranym etykietom.
     - `break`/`return` czyści zebrane etykiety.
     - Przypadki przechodzące dalej (fall-through) mają dostać ostatnią przypisaną nazwę, jak w kodzie.
   - Źródła: `decompiled_carinfo/com/syu/carinfo/**.java`. Indeks po prostej nazwie klasy; przy duplikatach wybierz pakiet zgodny z fqcn.
   - Dla każdego ID: BFS od klasy z `className` po odwołaniach `\b([A-Z]\w+)\.class\b`, które istnieją w indeksie, do głębokości 3.
   - Klasa jest **stroną spalania**, jeśli jej prosta nazwa pasuje do `(?i)(oil|mile|trip|fuel|consum|drivinginfo)`
     i w ciele `onCreate`/`onStart`/`onResume` są wywołania `PROXY.cmd(`.
     **Liczą się tylko wywołania bezpośrednio w ciele metody** (także w `if`/`else`). Pomijaj wszystko wewnątrz klas
     anonimowych (`new X(...) { … }`) i lambd (`-> { … }`).
     Przykład: `RZCLandRoverMilePage1Acti` ma `cmd(1,{1,6})` w `onClick`, czyli prawdopodobnie reset licznika. Nie może trafić do tabeli.
   - Kolejność zapytań na stronie: `onCreate`, potem `onStart`, potem `onResume`, w każdej w kolejności źródła.
   - Postacie wywołań:

     | w źródle | w tabeli |
     |---|---|
     | `cmd(N, new int[]{a, b}, …)` | `N:a,b` |
     | `cmd(N, new int[k], …)` | `N:` i k zer (`new int[1]` → `N:0`) |
     | `cmd(N, v)` | `N:v` |
     | `cmd(N, a, b)` | `N:a,b` |
     | `cmd(N)` | `N` |

     Wywołania z argumentem nieliteralnym (zmienna, wyrażenie) pomiń i policz w raporcie.
   - Kolejność stron dla ID:
     1. nazwa zawiera `_<id & 0xFFFF>_`;
     2. nazwa zawiera `Page1`;
     3. nazwa zawiera `Index`;
     4. mniejsza głębokość BFS;
     5. alfabetycznie.
   - Wyjście:
     - nagłówek `canbus_requests 1`;
     - komentarz z commitem źródła (`git rev-parse --short HEAD`, jeśli dostępny) i liczbami;
     - wpisy pogrupowane: jedna linia na (zbiór ID o identycznej liście stron, strona), ID rosnąco, grupy po najmniejszym ID.
   - Na stderr wypisz liczby: ID w `className`, ID z zapytaniem, grupy, strony, pominięte wywołania nieliteralne.
     Wypisz też **grupy z niejednoznaczną stroną główną** (kilka stron o tym samym priorytecie i różnych zapytaniach),
     np. `Xp_374_OilDisplayActi`/`Xp_424_OilDisplayActi` dla ID 65932, 65944, ….
   - Oczekiwane na `620fd61`: 3864 / 589 / 13 / 26. Inne liczby wyjaśnij w raporcie.
2. Wygeneruj i dodaj `app/src/main/assets/canbus_requests.txt`.
3. **`settings/CanbusRequests.java`**, rdzeń w czystej Javie:
   - `static final class Request { final int cmd; final int[] ints; }`. `toString()` daje `70:51` albo `100`.
   - `static final class Page { final String name; final List<Request> requests; }`. `name` jest `null` dla wpisu `-`.
   - `static final class Table` (niezmienna):
     - `static Table parse(Reader)` rzuca `FormatException` (`int line`, `String reason`);
     - `List<Page> pagesFor(int id)`: pusta lista, gdy auto nie wymaga zapytania (brak w tabeli albo wpis `-`);
     - `boolean mentions(int id)`: ID jest w tabeli, także jako `-`;
     - `Table mergedWith(Table overlay)` według §Format;
     - `MergeStats statsOfMerge(Table overlay)`: ile ID nowych, zastąpionych i oznaczonych `-`;
     - `String serialize()` w tym samym formacie;
     - `int carsNeedingRequest()`.
   - `static int[] parseInts(String)`:
     - `"74,3"` i `" 74, 3 "` → `{74,3}`;
     - `"51"` → `{51}`;
     - `""` → `new int[0]`;
     - zły tekst → `null`.
4. Testy `app/src/test/java/com/android/launcher66/settings/CanbusRequestsTest.java`:
   - parsowanie przykładu z §Format;
   - błędy, każdy z numerem linii: brak nagłówka, dwa pola, `x:1`, `-` tylko w jednym polu, sprzeczny `-` dla ID ze stronami;
   - scalanie:
     - ID z nakładki zastępuje bazę;
     - pozostałe ID zostają;
     - `-` usuwa zapytanie;
     - `statsOfMerge` liczy poprawnie;
   - `serialize()` → `parse()` daje tę samą tabelę;
   - `parseInts`;
   - test na prawdziwym assecie (`new File("src/main/assets/canbus_requests.txt")`, katalog roboczy testów to `app/`):
     - ID 163 ma stronę główną `com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti` z zapytaniami `70:51; 29:0`;
     - ID 19 ma `100:1; 100:3` (`HondaTripActi`);
     - ID 2687429 ma `11:74,3` (GM Andra);
     - ID 1 (`DasAutoWcAct`) nie wymaga zapytania;
     - żadna strona nie nazywa się `RZCLandRoverMilePage1Acti`.

## C3 — `Fuel statistics: the car's request only for the cars that need one`

1. **Warstwa Androida w `CanbusRequests`** (nie jest testowana na JVM):
   - jednowątkowy `ExecutorService` klasy;
   - `builtIn` wczytywany leniwie z `assets/canbus_requests.txt`, `overlay` z `context.getFilesDir()/canbus_requests_user.txt` (C5);
   - `effective = builtIn.mergedWith(overlay)` w polu `volatile`, unieważniany po imporcie i resecie;
   - `static void preload(Context)` ładuje na executorze;
   - `static List<Page> pagesForCurrentCar()` zwraca wynik z pamięci podręcznej albo `null`, gdy tabela nie jest jeszcze wczytana.
     Wywoływać tylko po `preload`; nigdy nie czyta plików na wątku głównym;
   - `static void sendForCar(Context, int id)` pracuje na executorze:
     - `pages = pagesFor(id)`. Gdy lista jest pusta: `Log.i` „no request for car …” i nic nie wysyłaj;
     - inaczej: jeśli użytkownik ustawił własne zapytanie (§3.4), wyślij **tylko** je: `DataCanbus.PROXY.cmd(cmd, ints, null, null)`;
     - w przeciwnym razie wyślij **wszystkie** zapytania strony głównej w kolejności;
     - zaloguj, co wysłano. Zwraca opis wysłanego (do nagłówka inspektora w C4).
2. **`CanbusService`**:
   - usuń ≈186–188 (odczyt extras i `PROXY.cmd`);
   - w `addNotify()` (≈1004) dodaj `DataCanbus.NOTIFY_EVENTS[1000].addNotify(requestNotify, 1)`, a w `removeNotify()` odpowiednie `removeNotify`;
   - `requestNotify`: gdy `DataCanbus.DATA[1000] != 0`, wołaj `CanbusRequests.sendForCar(this, DATA[1000])`.
     `ConnectionCanbus.onDisconnected()` zeruje `DATA[1000]`, więc powiadomienie przychodzi po każdym (ponownym) połączeniu;
   - wywołaj `CanbusRequests.preload(this)` w `onCreate`;
   - dodaj `static void resendRequestAfterWake()`: na wątku głównym, jeśli `sInstance != null`, `postDelayed` 3000 ms
     z `sendForCar(sInstance, DATA[1000])`. Wołaj ją z `WakeDetection.onWake` zaraz po bloku logcata (≈311),
     bo CAN-box po wybudzeniu może znów czekać na zapytanie.
3. Usuń extras `cmdInt`/`cmdArr` w `CanbusAsyncTask` (≈72–73) i `ServiceRestarter` (≈37–38). Mają tam `Integer.parseInt`,
   które wysypałoby się na `74,3`.
   Kontrola: `rg -n 'CMD_INT|CMD_ARR|cmdInt_code_int|cmdArr_code_int' app/src/main/java` pokazuje tylko `Keys`, `CanbusRequests`
   i `SettingsFragmentSecond` (po C4 bez inspektora).
4. **Zapytanie użytkownika** (`CanbusRequests.userRequest(SharedPreferences)`):
   - `Keys.CMD_INT` jest pusty albo `"0"` **i** `Keys.CMD_ARR` jest pusty albo `"0"` → brak, czyli używa się tabeli.
     `"0"`/`"0"` to stara wartość domyślna, którą `saveCode` zapisywał zamiast pustego pola.
   - Inaczej `cmd = parseInt(CMD_INT)` i `ints = parseInts(CMD_ARR)`. Błąd parsowania → brak plus `Log.w`.
5. **Okno „Kody canbus”** (`displayCodesDialog()` ≈1652–1712, `res/layout/dialog_codes_layout.xml`):
   - `cmdInt_code_text`/`cmdInt_code_int`/`cmdArr_code_text`/`cmdArr_code_int` mają `GONE`, gdy
     `pagesForCurrentCar()` zwraca `null` albo pustą listę;
   - gdy są widoczne:
     - pola zawierają zapisaną wartość użytkownika albo są puste (nie `0`);
     - `setHint` pokazuje pierwsze zapytanie strony głównej (np. `70` / `51`);
     - `cmdArr` przyjmuje `0123456789,-` (`DigitsKeyListener`);
     - pod polami jest nowy `TextView` `@+id/known_requests_text` z nowym stringiem `stats_codes_known_requests`
       („Requests of this car's screens (empty fields send those of the first one):\n%1$s”). `%1$s` to linie
       `ProstaNazwaStrony: 70:51; 29:0`;
   - `fragment.onCreate` woła `CanbusRequests.preload(requireContext())`.
6. **Zapis**: dla pól cmd nie używaj `saveCode` z jego `empty → "0"`. Napisz osobny zapis:
   - pusty tekst → pusty string;
   - `cmdArr` znormalizowany do `74,3`;
   - zły tekst → toast z nowym `stats_codes_cmd_invalid` („cmdInt must be a number and cmdArr numbers separated by commas”)
     i te dwa pola nie są zapisywane.
   Gdy pola są ukryte, nie zapisuj ich wcale, a zapisane wcześniej wartości zostają.
7. **Opis preferencji `stats_codes`** (miejsca: ≈563, ≈765–766, `saveCode` ≈1941–1950):
   - auto wymaga zapytania → nowy `stats_codes_summary_request` („Tap to set the canbus codes. \nFuel: %1$s, Range: %2$s, Request: %3$s”).
     `%3$s` to `70:51` użytkownika albo nowy `stats_codes_request_auto` („%1$s (first screen)”) z zapytaniami strony głównej;
   - nie wymaga albo ID nieznane → nowy `stats_codes_summary_no_request` („Tap to set the canbus codes. \nFuel: %1$s, Range: %2$s”).
   - `stats_codes_summary` przestaje być używany: usuń go wszędzie.
   - Etykiety: zostaw `cmdInt_code_text`. Zamiast `cmdArr_code_text` daj nowy `cmdArr_list_code_text` („cmdArr (e.g. 74,3):”),
     a stary usuń wszędzie.

## C4 — `Canbus: the code inspector records what com.syu.ms sends, without a command`

1. **`CanbusCodeInspector.java`**:
   - Własny `private final IModuleCallback.Stub rawCallback`, rejestrowany bezpośrednio przez `DataCanbus.PROXY.register(rawCallback, code, 1)`
     dla `code` 0..1199. **Kolejność**:
     1. ustaw `startTime`;
     2. wyślij zapytanie (pkt 2);
     3. zarejestruj.

     Rejestruj w `runSchedulerTask`, nie w `onCreate`. Dzięki temu bieżące wartości, które `register(…, 1)` odsyła od razu,
     trafiają do sekundy 1.
   - Wyrejestrowanie: `DataCanbus.PROXY.unregister(rawCallback, code)` dla 0..1199 na `batchExecutor`.
     `addNotify`/`removeNotify` i batchowanie na wątku głównym znikają. `ModuleCallbackCanbusProxy` zostaje bez zmian.
   - `update(code, ints, flts, strs)` przychodzi na wątku bindera. Zapisuj pełny ładunek, np. `ints=[655, 3] strs=[ABC]`
     (puste i `null` tablice pomijaj; całkiem pusty ładunek → `(empty)`), do `codeData[code][second-1]`.
     Dostęp do `codeData` w obu wątkach w `synchronized (codeData)`. `skip_codes` działa jak dotąd.
   - Nagłówek pliku przed kodami:
     - `DataCanbus.DATA[1000]` (pełne), `id & 0xFFFF`, `id >>> 16`;
     - `CanbusClasses.className(id)` albo `-`;
     - prosta nazwa klasy z `ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus()`. `Callback_0000_null` oznacza, że launcher nie zna auta;
     - wysłane zapytanie albo `none`;
     - czas zapisu.
   - Zaktualizuj komentarz klasy.
2. Zapytanie: `CanbusRequests.sendForCar(this, DATA[1000])`. Wynik to ten sam opis co w statystykach, zapisany w nagłówku.
   Auto spoza tabeli: nic nie jest wysyłane.
3. Usuń własne pola cmd inspektora:
   - `Keys.INSPECTOR_CMD_INT/ARR`;
   - w `dialog_inspector_codes_layout.xml` widoki `inspector_cmd_int_text`, `inspector_cmd_int`, `inspector_cmd_arr_text`, `inspector_cmd_arr`
     (popraw ograniczenia `ConstraintLayout`, by `code_inspector_timeout_text` przylegał do tytułu);
   - w `SettingsFragmentSecond` miejsca ≈141–142, ≈344–345, ≈663, ≈942–943, ≈1878–1898, ≈2084–2085;
   - extras w `startCanbusCodeInspector()` (≈1397–1399).
4. Stringi:
   - nowy `code_inspector_data_summary_time` („Tap to set the recording time. \nTimeout: %1$s”) zamiast `code_inspector_data_summary`;
   - usuń wszędzie `code_inspector_data_summary`, `inspector_cmd_int_text`, `inspector_cmd_arr_text`.
5. `CanbusGuide`:
   - zamiast `codes_guide_detailed_reading` → nowy `codes_guide_inspector`. Treść: inspektor nie wysyła losowych komend;
     zapisuje wszystkie kody 0..1199, które wysyła usługa FYT, z pełnymi wartościami, co sekundę; nagłówek mówi, czy launcher zna auto;
     zapytanie idzie tylko do aut z tabeli; spalanie to zwykle kod o kilku zmieniających się wartościach, a zasięg kod, który zmienia się rzadko;
   - zamiast `codes_guide_miscellaneous` → nowy `codes_guide_skip_codes` (tylko o inspektorze);
   - stare dwa klucze usuń wszędzie. Tytuły zostają.

## C5 — `Canbus: import a request table from a file`

1. `creator_preferences.xml`, kategoria `canbus_reader`, za `skip_codes`, dwie preferencje widoczne jak pozostałe przy `display_canbus_reader`
   (≈619/≈1581):
   - `canbus_requests_import`: tytuł `canbus_requests_import` („Import a request table”), opis `canbus_requests_import_summary`
     („Cars needing a request: %1$d built in, %2$d from imported files. Format: decompiled_carinfo/README.md”);
   - `canbus_requests_reset` („Remove the imported tables”), widoczna tylko, gdy istnieje nakładka. Pyta o potwierdzenie
     (`canbus_requests_reset_confirm`).
2. Import:
   - `registerForActivityResult(new ActivityResultContracts.OpenDocument(), …)` w `SettingsFragmentSecond` z typami
     `{"text/plain", "application/octet-stream", "*/*"}`;
   - odczyt `ContentResolver.openInputStream` (UTF-8, ≤1 MB) i `Table.parse` **na executorze `CanbusRequests`**;
   - błąd → toast `canbus_requests_import_invalid` („No valid request table: line %1$d, %2$s”) i nic się nie zmienia;
   - sukces:
     1. `newOverlay = oldOverlay.mergedWith(plik)`;
     2. zapis atomowy (`android.util.AtomicFile`) do `filesDir/canbus_requests_user.txt` przez `serialize()`;
     3. unieważnienie `effective`;
     4. toast `canbus_requests_import_done` („%1$d cars imported: %2$d new, %3$d replaced, %4$d without a request”);
     5. odświeżenie opisów `stats_codes` i preferencji importu (wątek główny, `isAdded()`).
3. Reset: usuń plik, unieważnij, toast `canbus_requests_reset_done`, odśwież.
4. `decompiled_carinfo/README.md`: dopisz sekcję o generatorze (polecenie z C2.1) i pełną specyfikację formatu z §Format (po angielsku),
   z przykładem i opisem scalania.

## C6 — `Logcat: a stop button over every screen for a capture started by hand`

1. **`LogcatWorker`**:
   - nowy interfejs `public interface CaptureEndListener { void onCaptureEnded(); }` z listą `CopyOnWriteArrayList`
     oraz metodami `addCaptureEndListener` i `removeCaptureEndListener`;
   - wywołanie na wątku głównym w poście z `beginDrain()` (≈1790, przy `cancelCountdown()`). To obejmuje koniec czasu
     (`deadlineRunnable` → `beginDrain("time limit")`) i `stop()`;
   - drugie wywołanie w poście z `finishOnce()` (≈1846) na wypadek końca bez drenażu. Słuchacze muszą być idempotentni;
   - `public boolean isManualCapture()` → `running && !draining && trigger == Trigger.MANUAL`;
   - istniejący `StateListener` zostaje bez zmian.
2. **`FabOverlayService`**: bez zmiany zachowania wydziel to, czego potrzebuje przycisk.
   - `static int fabSizePx(Context)` z `computeFabSizePx()`. Ta sama formuła: 8% krótszego boku z `getResources().getDisplayMetrics()`,
     min. 40 dp. Metoda instancji ma ją wołać.
   - `static int statusBarHeightPx(Context)` z `getStatusBarHeight()` (≈806). Metoda instancji ma ją wołać.
   - `excludeFromSystemGestures(View)` (≈404) i `BACKGROUND_ALPHA` zrób package-private.
   - Obsługi dotyku (`attachTouchHandler`/`trackFinger`/`onDragFinished`) **nie refaktoryzuj** i nie wydzielaj do wspólnej klasy.
     Przycisk ma własną kopię tej logiki (pkt 3).
3. **Nowa klasa `settings/LogcatStopButton`** (singleton, wątek główny, bez `Service` i bez wpisu w manifeście; okno należy do procesu launchera jak sam logcat):
   - `show(Context app)`:
     - nic nie rób, gdy `!LogcatWorker.get().isManualCapture()`, gdy przycisk już jest albo gdy `!Settings.canDrawOverlays(app)` (wtedy `Log.w`);
     - inaczej dodaj okno przez `WindowManager` z kontekstu aplikacji:
       - flagi jak w `FabOverlayService.createLayoutParams()` (≈377): `TYPE_APPLICATION_OVERLAY`,
         `FLAG_NOT_FOCUSABLE | FLAG_NOT_TOUCH_MODAL | FLAG_LAYOUT_IN_SCREEN | FLAG_LAYOUT_NO_LIMITS`, `PixelFormat.TRANSLUCENT`;
       - `gravity = TOP|LEFT`, wysokość `h = FabOverlayService.fabSizePx(app)`, szerokość `w = 2*h`;
       - pozycja według pkt „Pozycja” niżej, ustalona **przed** `addView()`, żeby przycisk nie przeskakiwał;
       - `FLAG_NOT_FOCUSABLE` jest konieczne: okno nie może zabrać fokusu launcherowi (`PinnedPipFocus`, `HomeFrontGuard`);
       - na API 29+ `FabOverlayService.excludeFromSystemGestures(view)`, jak przy przyciskach PiP;
     - zarejestruj się jako `CaptureEndListener`;
     - zarejestruj `ComponentCallbacks` na kontekście aplikacji (pkt „Zmiana konfiguracji”).
   - **Pozycja** (te same zasady co `FabOverlayService.resolvePosition`/`applySavedPosition`/`clampX`/`clampY`, ≈426–475):
     - nowe klucze w `Keys`: `LOGCAT_STOP_X = "logcat_stop_button_x"`, `LOGCAT_STOP_Y = "logcat_stop_button_y"`,
       `LOGCAT_STOP_SAVED = "logcat_stop_button_saved"`, w domyślnych `SharedPreferences` (jak `FabOverlayService`, ≈149);
     - x i y zapisuj jako `float`, odczytuj z `try/catch ClassCastException`. Wartość ujemna albo NaN to brak pozycji;
     - zapisana i poprawna pozycja → użyj jej po `clamp`;
     - brak pozycji → domyślnie wyśrodkowany u góry: `x = (szerokośćEkranu - w)/2`, `y` = wysokość paska stanu
       (`FabOverlayService.statusBarHeightPx(app)`);
     - `clampX(x) = max(0, min(x, szerokośćEkranu - w))`, `clampY(y) = max(pasekStanu, min(y, wysokośćEkranu - h))`.
       Wymiary ekranu z `getResources().getDisplayMetrics()` kontekstu aplikacji.
   - **Przeciąganie, jak w `FabOverlayService`** (`attachTouchHandler`/`trackFinger`/`onDragFinished`, ≈523–611). Skopiuj tę logikę
     do `LogcatStopButton` z tymi samymi regułami i krótkimi komentarzami „dlaczego”:
     - `ACTION_DOWN` zapamiętuje `getRawX/Y` i `params.x/y`, `dragging = false`;
     - przeciąganie zaczyna się dopiero po przekroczeniu `ViewConfiguration.getScaledTouchSlop()`, bo drgnięcie palca przy tapie
       (zwłaszcza w jadącym aucie) nie może przesunąć przycisku;
     - pozycja liczona względem punktu `DOWN`, przez `clampX/clampY`, `updateViewLayout` tylko przy zmianie;
     - `ACTION_POINTER_DOWN`/`ACTION_POINTER_UP` ustawiają nowy punkt odniesienia (`reanchor`), żeby przycisk nie skakał
       przy dołożeniu albo podniesieniu drugiego palca;
     - `ACTION_UP` najpierw uwzględnia ostatnią pozycję palca. Po przeciąganiu zapisuje pozycję. Bez przeciągania i krócej niż
       `ViewConfiguration.getLongPressTimeout()` woła `performClick()`. Długie przytrzymanie bez ruchu nie robi nic;
     - `ACTION_CANCEL` kończy przeciąganie i zapisuje pozycję;
     - pozycja zapisuje się **tylko** po przeciągnięciu, nigdy po tapie.
   - **Zmiana konfiguracji** (jak `FabOverlayService.onConfigurationChanged`, ≈220–238): przelicz `h`, `w` i wymiary ekranu.
     W trakcie przeciągania tylko `clamp` bieżącej pozycji, w innym razie ustal pozycję od nowa (zapisana albo domyślna).
     Potem `updateViewLayout` w `try/catch IllegalArgumentException`.
   - Widok: `TextView` z nowym stringiem `logcat_stop_button` („Stop logcat”):
     - wyśrodkowany (`Gravity.CENTER`), jedna linia, pogrubiony;
     - kolor nowy `@color/logcat_stop_text` = `#FFF44336`;
     - tekst do 0,3·h px, autosize jednolity, by mieścił się w 2h;
     - tło `GradientDrawable` (prostokąt, kolor czarny z alfą `FabOverlayService.BACKGROUND_ALPHA`, promień rogów `h * 0.25f`,
       stała `CORNER_FRACTION`);
     - bez cienia i elewacji.
   - Kliknięcie:
     1. wyłącz widok (bez podwójnego kliknięcia);
     2. `LogcatWorker.get().stop(true, app)`, dokładnie jak `stopLogcatRun()` w ustawieniach.

     Przycisk znika przez `onCaptureEnded`.
   - `hide()`: `removeViewImmediate` w `try/catch`, wyrejestrowanie `CaptureEndListener` i `ComponentCallbacks`, wyzerowanie pól.
     Trwające przeciąganie po prostu się kończy, bez zapisu pozycji.
     `onCaptureEnded()` woła `hide()`, więc przycisk **znika sam przy planowym końcu czasu**.
4. **`SettingsFragmentFirst`**:
   - w `startLogcatRun()` (≈1146), po `start(…, Trigger.MANUAL)`, wołaj `LogcatStopButton.show(requireContext().getApplicationContext())`.
     Nigdzie indziej (`ColdStart`, wybudzenie) przycisk się nie pojawia;
   - wydziel z `stopLogcatRun()` część UI (`removeTickRunnable`, `cancelCountDownTimer`, `showLogcatSaving()` albo opis startowy)
     do `showLogcatStoppedUi()`;
   - zarejestruj `CaptureEndListener` fragmentu tam, gdzie `setStateListener` (≈510), i wyrejestruj tam, gdzie `clearStateListener` (≈1035).
     Wywołuje on `showLogcatStoppedUi()` przy `isAdded()`, żeby zatrzymanie z przycisku wyglądało w otwartych ustawieniach
     tak samo jak z preferencji.
5. Stringi i kolor tylko w `values/`: `logcat_stop_button` i `logcat_stop_text`. Klucze pozycji tylko w `Keys` (bez migracji).

## C7 — `README: fuel statistics without the command logger`

`README.MD`, sekcja statystyk paliwa (kroki 7–9, ≈205–296):
- pola cmdInt/cmdArr ustawia się tylko dla aut, przy których launcher je pokazuje. Zostaw przykład `70/51` jako ilustrację, skąd się biorą;
- puste pola wysyłają zapytania pierwszego ekranu z tabeli;
- kody najprościej znaleźć w pliku „Szczegółowej weryfikacji”;
- brakujące auto można dodać plikiem (odnośnik do `decompiled_carinfo/README.md`);
- usuń wzmianki o „Initial reading”.

## 4. Czego NIE zmieniać

- `ModuleCallbackCanbusProxy`, `Callback_*`, `HandlerCanbus`, `DataCanbus` i `ConnectionCanbus`.
- `CanbusClasses` (tylko czytasz `className`).
- Logikę statystyk (fuel/range/rpm, okna, położenie).
- `LogcatWorker` poza §C6.1: czas, drenaż, nazwy plików, wybudzenie i `StateListener`.
- `FabOverlayService` poza wydzieleniem `fabSizePx`/`statusBarHeightPx` i widocznością `excludeFromSystemGestures`/`BACKGROUND_ALPHA`.
  Jego obsługa dotyku, pozycje i klucze zostają bez zmian.
- Profile baseline, workflow CI, `decompiled_carinfo/com/**`, `decompiled_FYT_jars/`, `fuel_stats_example/`.
- Tłumaczenia poza usuwaniem nieużywanych kluczy.

## 5. Weryfikacja

1. Po każdym commicie: kontrole `rg` z danego kroku, potem CI zielone (testy JVM i oba `assemble…Debug`).
2. Kontrola końcowa:
   - `rg -n 'CanbusCommandLogger|INSPECTOR_CMD|code_logger|stats_codes_summary"|code_inspector_data_summary"' app/src --glob '!**/generated/**'` → zero;
   - `rg -n 'PROXY\.cmd\(' app/src/main/java/com/android/launcher66` → tylko `CanbusRequests` (oraz `CanbusClasses` 411/LandRover, jak było);
   - `python3 decompiled_carinfo/gen_canbus_requests.py --out /tmp/x.txt && diff /tmp/x.txt app/src/main/assets/canbus_requests.txt` → brak różnic.
3. Scenariusze dla właściciela (7862, 7870), wypisz je w raporcie:
   - a) auto spoza tabeli: w „Kody canbus” nie ma pól cmd, opis bez „Request”, logcat nie pokazuje żadnego `PROXY.cmd` przy starcie,
     wybudzeniu ani inspektorze; statystyki działają;
   - b) auto z tabeli (np. PSA RZC):
     - pola są z podpowiedzią i listą znanych zapytań;
     - puste pola: w logu zapytania strony głównej po połączeniu i 3 s po wybudzeniu;
     - własne `70` / `51`: tylko ono;
     - `74,3` zapisuje się i wraca w oknie;
   - c) inspektor: plik ma nagłówek (ID, klasa, callback, zapytanie) i kody spoza zakresu callbacku z pełnymi tablicami;
     statystyki i okna klimatyzacji/drzwi działają w trakcie i po zapisie;
   - d) import:
     - poprawny plik z §Format → toast z liczbami, pola cmd pojawiają się albo znikają zgodnie z plikiem;
     - plik z błędem w linii 3 → toast „line 3, …” i nic się nie zmienia;
     - reset przywraca tabelę wbudowaną;
     - ponowny import dokłada się do poprzedniego;
   - e) logcat:
     - „Tap to start logging” → przycisk „Stop logcat” nad każdą aplikacją, za pierwszym razem wyśrodkowany u góry;
     - przeciągnięcie przesuwa przycisk (w granicach ekranu, poniżej paska stanu) i go nie zatrzymuje. Drgnięcie palca przy tapie
       nie przesuwa. Długie przytrzymanie nic nie robi. Przy następnym ręcznym logcacie przycisk wraca na przesuniętą pozycję;
     - tap zatrzymuje jak preferencja (toast z plikiem, w otwartych ustawieniach opis jak po zatrzymaniu);
     - bez tapu przycisk znika sam po ustawionym czasie;
     - logcat przy zimnym starcie i po wybudzeniu nie pokazuje przycisku;
     - bez uprawnienia nakładki brak przycisku, ale logcat działa;
     - przycisk nie zabiera fokusu (klawiatura w aplikacji pod spodem działa).

## 6. Raport końcowy (w odpowiedzi, po polsku)

- Commity (hash + temat) i wynik CI każdego.
- Liczby z generatora (ID, z zapytaniem, grupy, strony, pominięte wywołania) i lista grup z niejednoznaczną stroną główną.
- Każde odstępstwo od tej instrukcji i jego powód.
- Lista nowych kluczy w `values/strings.xml` (do tłumaczenia) i kluczy usuniętych ze wszystkich języków.
- Scenariusze z pkt 5.3.
