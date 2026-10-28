# Launcher Mod: platforma FYT po układzie, linia urządzenia, Shizuku Next, link do schowka, wyłączenie carinfo, porządki w res — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`. Wprowadź zmiany opisane niżej, każdą jako osobny commit, w kolejności D1 → D2 → V → B → S → T → K1 → K2 → K3 → K4 → U1 → U2 → U3. Wypchnij je na tę gałąź. **Nie twórz pull requesta.**

Ta runda następuje po `docs/sonnet-prompt-2026-10-27-pinned-logcat.md` (commity do `998d56f`). Zmian z tamtych rund nie cofaj. Numery linii to stan z `998d56f`, są orientacyjne. Zawsze sprawdzaj je w kodzie.

## 0. Urządzenia, mapa platform (zweryfikowana) i najważniejsza zasada

### Urządzenia właściciela
| Urządzenie | `Build.MANUFACTURER Build.MODEL` (nagłówek capture) | Android | Wariant | Pinned PiP po tej rundzie |
|---|---|---|---|---|
| FYT 7862 | `sprd ums512_1h10_Natv` | 10 (API 29) | `fyt`, system | tak |
| FYT 8581 | nieznane | 10 | `fyt` | tak |
| FYT 7870 | `UNISOC uis7870sc_2h10_nosec` | 13 (API 33) | `standard`, Shizuku | nie |
| Redmi Note 8T / Galaxy A55 | — | 14 / 16 | `standard` | nie (nie-FYT) |

### Mapa platform (po weryfikacji mapy właściciela)
| Platforma | SoC | `ro.fyt.platform` (= numer gałęzi `lsecNNNNupdate`) | Pinned PiP |
|---|---|---|---|
| FYT 7870 | Unisoc UIS7870SC | `6318` | **nie** |
| FYT 7862 / 7862S | Unisoc UIS7862 = UMS512 | `6315` | tak |
| FYT 8581 | Unisoc UIS8581A = SC9863A | `6316` | tak |
| FYT 9853i | Spreadtrum/Intel SC9853i | `6521` | tak |
| nieznana FYT | — | np. `6312`, `823` (zna je kod FYT, nie wiadomo, co to za układy) | tak |
| nie-FYT | — | — | **nie** |

Fakty, na których opiera się mapa (nie zgaduj ponad nie):
- **`ro.fyt.platform` to najpewniejszy identyfikator.** Kod FYT w tym repo (zdekompilowane aplikacje canbus, np. `com/syu/carinfo/air/Air_Activity_All_Normal.java:185–191`) porównuje go z `"6312"`, `"6315"`, `"6316"`, `"6318"`, `"6521"`, `"823"`. Dla `"6318"`/`"823"` wybiera tło `sp_air_bg_7870`. XDA potwierdza: `6315_1.zip` = UIS7862, `6316_1.zip` = UIS8581A, `lsec6521update` = SC9853i (**nie 6026**, jak w mapie właściciela).
- **`ums512_1h10_Natv` i `uis7870sc_2h10_nosec` to `Build.MODEL`**, a nie `Build.BOARD`. Dowód: `LogcatWorker` ≈509 zapisuje `device=` + `MANUFACTURER` + `MODEL`, a w capture z 7870 jest `===== device=UNISOC uis7870sc_2h10_nosec, android=13 (API 33)`. We frameworku FYT `Build.BOARD = ro.product.board` (`decompiled_FYT_jars/*/system.zip` → `android/os/Build.java`), a jego wartość na tych jednostkach nie jest znana. Rozpoznanie zapasowe sprawdza więc kilka pól, nie samo `BOARD`.
- `ro.build.fytmanufacturer` (liczbowy identyfikator klienta FYT) czytają frameworki 7862 i 7870 (`ActivityStarter`, `SyuPrivate`). Nadaje się na znacznik „to jest FYT”. Po `ro.fyt.version`/`ro.syu.version` nie ma śladu w żadnym frameworku z repo, więc ich nie używaj.
- Unisoc UMS512 (T618) mają też tablety i Teyes CC3 (Teyes ma własny firmware, nie FYT). **Układ bez znacznika FYT nie oznacza platformy FYT.**
- SoFIA 3GR (Android 5.1/6.0) i MT3561/3562 nie zainstalują launchera (`minSdk = 26`), więc nie dodawaj ich do kodu.
- Wersja Androida pochodzi z `Build.VERSION.SDK_INT`, nie z `RELEASE`: na 7862 interfejs i build.prop bywają podrobione na 13/14, a SDK_INT nie (aplikacje by się sypały).

### Propozycja klasy właściciela (`CompleteFytDetector`): czego z niej NIE przenosić
- sprawdza układ **przed** FYT, więc Teyes CC3 i tablety T618 dostałyby `FYT_7862` i Pinned PiP;
- `toLowerCase()` bez `Locale.ROOT` (launcher ma `values-tr`);
- własna refleksja na `android.os.SystemProperties`, choć repo ma już wrapper `app/src/main/java/android/SystemProperties.java`;
- polskie nazwy w kodzie, log przy każdym wywołaniu, brak pamięci podręcznej;
- `hardware contains "fyt"/"syu"`, `ro.fyt.version`, `ro.syu.version` — niepotwierdzone;
- pomija `ro.fyt.platform` jako źródło główne i `Build.MODEL`.

### Najważniejsza zasada (decyzja właściciela)
- **Po układzie (nowe `DeviceIdentity`)**: czy to FYT (`LauncherApplication.isFytDevice()`), Pinned PiP, minimalna jasność 7870 (`DayNightBrightness`), linia urządzenia w ustawieniach.
- **Po pakiecie (bez zmian)**: wszystko, co dotyczy muzyki i źródeł widgetu: `StockSources.isSyuMediaUnit()` (rozpoznanie usługi `com.syu.media`), `MusicService`, `SyuMediaClient`, `LauncherMusicWidget`, `DateMusicWidget`/`DateRadioWidget`, `MediaTransportController`, `NotificationListener.kt`, `StockRadioSource`, strony `com.syu.media` w `Launcher` (≈4604, ≈6839), ikony i domyślne aplikacje paska po `isPackageInstalled("com.syu.music")`. Aplikacja trzeciej strony o tej nazwie i tak nic tu nie zmieni, bo musiałaby wysyłać dane, które launcher czyta.
- **Pinned PiP jest niedostępne tylko na 7870 i na urządzeniach nie-FYT.** Każda inna platforma FYT (7862, 8581, 9853i i nieznane) je ma.

## 1. Zasady pracy i konwencje repo (jak w poprzednich rundach)
- **Komentarze i commity po angielsku**, w stylu otaczającego kodu: pełne zdania, które wyjaśniają *dlaczego*. Gęstość komentarzy jak w sąsiednim kodzie.
- **Commity**:
  - temat w trybie rozkazującym `<Obszar>: <co>`, treść zawinięta na ~72 znaki;
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push**: `git push -u origin ccr-087eed00-gbqsuz`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s.
- **Nie ruszaj commita `57e3600 [BRANCH-ONLY] CI: …` ani plików `.github/workflows/*.yml`.**
- **Logowanie**: `android.util.Log` z `TAG` danej klasy. Każda nowa decyzja ma jedną linię `Log.i`.
- **StrictMode** (debug i release, tylko `penaltyLog`): nic z dysku ani sieci na wątku głównym. `enableStrictMode()` włącza się dopiero pod koniec `LauncherApplication.onCreate` (≈227), ale **nie polegaj na tym**: nowy kod ma być czysty sam z siebie.
- **Testy**: JUnit 5 na JVM (`app/src/test/java`, `unitTests.isReturnDefaultValues = true`). Logikę decyzyjną wydziel do **czystych klas bez `android.*`** i przetestuj ją.
- **Bez nowych zależności i bez zmian schematu baz.** Nowy string jest jeden (krok S), jego tłumaczenia trafiają do kroku T.
- **Budowanie**: w kontenerze zwykle nie ma Android SDK. CI (`build.yml`) przy każdym pushu uruchamia `:app:testFytDebugUnitTest`, `:app:assembleFytDebug` i `:app:assembleStandardDebug`. Workflow ma `cancel-in-progress`, więc sprawdzaj run **ostatniego** commita (GitHub MCP `actions_list`/`get_job_logs`). Czerwoną budowę naprawiaj od razu. **Przy K1–K4 i U1–U3 wypychaj po każdym commicie i czekaj na zielone CI przed następnym**: tylko kompilacja i budowa zasobów (aapt2) wyłapią zerwane statyczne odwołanie.
- **Kontrola bez SDK**: klasy bez androidx skompilujesz poleceniem `javac -proc:none -cp android_jar/android-36.jar -d <tmp> <pliki>`. Stuby klas projektu trzymaj w katalogu tymczasowym, nie w repo.
- **Skrypty pomocnicze** (Python, `python3 -I`) trzymaj w scratchpadzie sesji, nigdy w repo. Tam też zapisuj listy usuniętych i zachowanych zasobów.
- `Workspace.java`, `Launcher.java`, `WindowUtil.java` i `CanbusClasses.java` edytuj punktowo.

---

## D1 — Rozpoznanie platformy FYT po układzie, raz, zapisane w preferencjach

### Jak jest dziś
- `LauncherApplication.isFytDevice()` (≈792–802) przy **każdym** wywołaniu (60+ miejsc) czyta 3 właściwości: `ro.product.board`/`ro.product.manufacturer` zawiera „FYT”, `ro.fyt.platform` niepuste, `Build.DISPLAY` zawiera „FYT”. Komentarz w `WakeSignals` ≈410 mówi, że ta reguła przegapiała jednostki FYT, których build nie mówi „FYT”.
- Model jednostki (7870 albo nie) zna dziś tylko `StockSources`, i to po pakiecie (asynchronicznie, `probeDevice` ≈132–170).

### Implementacja
1. **Czysta klasa** `app/src/main/java/com/android/launcher66/FytPlatform.java` (public final, prywatny konstruktor, bez `android.*`; `java.util.Locale` jest dozwolony):
   - `public enum Chipset { FYT_7870("FYT 7870", "6318"), FYT_7862("FYT 7862", "6315"), FYT_8581("FYT 8581", "6316"), FYT_9853I("FYT 9853i", "6521"), UNKNOWN_FYT("FYT", ""), NOT_FYT("", "") }` z polami `label` i `platformCode`. Javadoc: skąd kody (sekcja 0) i że numer to też numer gałęzi aktualizacji.
   - `static final int RULES_VERSION = 1;` — podbij, gdy zmienią się reguły, a zapisane wyniki policzą się raz od nowa.
   - `static boolean isFyt(String productBoard, String productManufacturer, String fytPlatform, String display, String fytManufacturer)`: dzisiejsze 4 warunki z `isFytDevice()` (z `toUpperCase(Locale.ROOT)`) **lub** niepuste (po `trim`) `ro.build.fytmanufacturer`.
   - `static Chipset classify(boolean fyt, String fytPlatform, String... ids)`:
     - `!fyt` → `NOT_FYT`;
     - dokładny kod `fytPlatform.trim()` z tabeli → ta platforma (kod wygrywa z nazwami);
     - inaczej `ids` połączone spacją i `toLowerCase(Locale.ROOT)`: `"7870"` → 7870; `"ums512"` lub `"7862"` → 7862; `"8581"` lub `"9863"` → 8581; `"9853"` → 9853i;
     - w każdym innym przypadku → `UNKNOWN_FYT`.
   - `static Chipset fromSaved(String name)`: `valueOf` albo `null` (dla `null`, pustego i nieznanego).
   - `static String androidVersion(int sdk, String release)`: 26 „8.0”, 27 „8.1”, 28 „9”, 29 „10”, 30 „11”, 31 „12”, 32 „12L”, 33 „13”, 34 „14”, 35 „15”, 36 „16”, 37 „17”. Dla innych wartości `release` (jeśli pusty: `"API " + sdk`).
   - `static String deviceLine(Chipset c, String manufacturer, String model, String fytPlatform, int sdk, String release)`, zawsze z dopiskiem `" · Android " + androidVersion(...)`:
     - znana platforma: `label + " (" + model + ")"` → `FYT 7862 (ums512_1h10_Natv) · Android 10`;
     - `UNKNOWN_FYT`: `"FYT (" + model + ", " + fytPlatform + ")"`, z pominięciem pustych części → `FYT (xyz, 823) · Android 13`;
     - `NOT_FYT`: producent z wielką pierwszą literą (`Locale.ROOT`) + `" " + model`; producenta nie powtarzaj, gdy model już się od niego zaczyna (bez względu na wielkość liter) → `Xiaomi Redmi Note 8T · Android 14`, `Samsung SM-A556B · Android 16`;
     - nigdy pustych nawiasów (pusty model → sam `label`).
2. **Klasa androidowa** `app/src/main/java/com/android/launcher66/DeviceIdentity.java` (public final, `TAG = "DeviceIdentity"`):
   - `private static volatile FytPlatform.Chipset sChipset;`
   - `private static Chipset detect()`: czyta przez `android.SystemProperties` `ro.fyt.platform`, `ro.product.board`, `ro.product.manufacturer`, `ro.build.fytmanufacturer`, `ro.board.platform`, a z `Build` `DISPLAY`, `BOARD`, `MODEL`, `PRODUCT`, `DEVICE`, `HARDWARE`. Właściwości systemowe są w pamięci (bez dysku), a pola `Build` są statyczne, więc nie ma tu operacji StrictMode. **Żadnych wywołań PackageManagera.**
   - `static void init(SharedPreferences prefs)` (wątek główny, raz na proces launchera):
     - jeśli `prefs.getInt(Keys.DEVICE_CHIPSET_RULES, 0) == RULES_VERSION` i `fromSaved(prefs.getString(Keys.DEVICE_CHIPSET, null)) != null`, przyjmij zapisany wynik → `Log.i(TAG, "FYT platform: FYT_7862 (saved)")`;
     - inaczej `detect()`, zapisz `putString` + `putInt` przez **`apply()`** (nigdy `commit()`) → `Log.i` z wynikiem i wszystkimi surowymi wartościami (żeby właściciel mógł sprawdzić 7862/8581/7870 w capture), np. `FYT platform: FYT_7862, detected from ro.fyt.platform=6315 board=… model=ums512_1h10_Natv product=… device=… hardware=… ro.board.platform=… fytmanufacturer=…`.
   - `public static Chipset chipset()`: zwraca `sChipset`. Gdy jest jeszcze `null` (proces `:wallpaper_chooser`, który nie woła `init`, albo odczyt przed `init`), liczy `detect()` bez zapisu, zapamiętuje i jednorazowo loguje `Log.d(TAG, "read before init(), detected without saving")`. W `init()` wynik z preferencji ma pierwszeństwo przed takim wcześniejszym odczytem, a ewentualną różnicę zaloguj `Log.w`.
   - `public static boolean isFyt()` (`!= NOT_FYT`), `public static boolean is7870()`, `public static String deviceLine()` (z bieżącymi `Build.MANUFACTURER`, `Build.MODEL`, `ro.fyt.platform`, `SDK_INT` i `RELEASE`; tani odczyt do wyświetlenia, a nie ponowne rozpoznanie).
3. `settings/Keys.java`: `DEVICE_CHIPSET = "device_chipset"`, `DEVICE_CHIPSET_RULES = "device_chipset_rules"`.
4. `LauncherApplication.onCreate`: zaraz za gałęzią procesu tapet (≈132–137), **przed** `initData()`, dodaj `DeviceIdentity.init(PreferenceManager.getDefaultSharedPreferences(this)); steps.mark("device");`. Domyślne preferencje są już wczytywane w `attachBaseContext` (≈117–122), więc nie dochodzi nowy odczyt dysku. Uwaga: „cold start” oznacza tu start procesu launchera, a nie `ColdStart` (pierwszy start po restarcie urządzenia). Po instalacji czy aktualizacji bez restartu urządzenie też musi być znane.
5. `isFytDevice()` = `return DeviceIdentity.isFyt();`. Javadoc: reguła i źródło w `FytPlatform`, wynik zapisany raz. `StockSources.isFyt()` zostaje (deleguje dalej).
6. **Test** `app/src/test/java/com/android/launcher66/FytPlatformTest.java`:
   - `classify`: `(true,"6315","ums512_1h10_Natv")` → 7862; `(true,"6318","uis7870sc_2h10_nosec")` → 7870; `(true,"","uis7870sc_2h10_nosec")` → 7870; `(true,"6316")` → 8581; `(true,"6521")` → 9853i; `(true,"","sp9863a_1h10")` → 8581; `(true,"823","x")` → UNKNOWN_FYT; `(false,"","ums512_1h10")` → NOT_FYT (Teyes/tablet T618); kod wygrywa z nazwą (`"6315"` + `"uis7870…"` → 7862);
   - `isFyt`: każdy z pięciu warunków osobno → true; wszystko puste/null → false;
   - `androidVersion`: 27, 29, 32, 33, nieznany SDK z `release` i bez;
   - `deviceLine`: przykłady z pkt 1, w tym brak powtórzenia producenta i brak pustych nawiasów;
   - `fromSaved`: poprawna nazwa, `null`, śmieci.
7. Commit `Device: tell the FYT platform by its chipset, once, and keep it`. W treści:
   - źródła (`ro.fyt.platform` jak kod FYT, `MODEL`/`BOARD`/… zapasowo, `ro.build.fytmanufacturer` jako nowy znacznik FYT);
   - zapis w preferencjach z `RULES_VERSION`;
   - brak operacji dyskowych na wątku głównym;
   - że `isFytDevice()` rozpoznaje teraz też jednostki z samym `ro.build.fytmanufacturer`;
   - 7862/7870 bez zmian w wyniku `isFytDevice()`.

---

## D2 — Pinned PiP i minimalna jasność 7870 po układzie, nie po aplikacji muzycznej

### Jak jest dziś
- `LauncherApplication.supportsPinnedPip()` (≈753–766) = `PinnedPip.supported(isFytDevice(), StockSources.isSyuMediaUnit())`. Do końca asynchronicznego `probeDevice` 7870 uchodzi za jednostkę z Pinned PiP. Zapisane tryby czyści dopiero `StockSources.onDeviceResolved` (≈172–185) przez `clearPinnedPipModes(…, "7870")`.
- `DayNightBrightness.sendToFyt` (≈191–211) czeka na `StockSources.isProbed()`, a `floorFytLevel(level, StockSources.isSyuMediaUnit())` (≈181–183) podnosi poziom na 7870. To sprawa ekranu, nie muzyki.

### Implementacja
1. `PinnedPip.java`: zastąp `supported(boolean fytUnit, boolean syuMediaUnit)` metodą `static boolean supported(FytPlatform.Chipset chipset)` = `chipset != FYT_7870 && chipset != NOT_FYT`. Obejmuje to 7862, 8581, 9853i i `UNKNOWN_FYT`. `mode(...)` zostaje. Javadoc klasy: decyzja właściciela (pinned stack mają wszystkie platformy FYT poza 7870; poza FYT go nie ma). Zaktualizuj `PinnedPipTest` dla wszystkich sześciu wartości enuma.
2. `supportsPinnedPip()` = `PinnedPip.supported(DeviceIdentity.chipset())`. Przepisz javadoc: wynik znany od startu, bez czekania na `StockSources`.
3. `onCreate` (≈169–174): zostaje `if (!supportsPinnedPip()) clearPinnedPipModes(prefs, DeviceIdentity.chipset().name());`. Popraw komentarz: teraz obejmuje też 7870, od razu.
4. `StockSources.onDeviceResolved`: usuń blok z `clearPinnedPipModes` i jego komentarz. Usuń import `PreferenceManager`, jeśli przestał być potrzebny. **Rozpoznania `com.syu.media` w `probeDevice` nie zmieniaj** (to logika muzyczna). Popraw tylko javadoc `isSyuMediaUnit()`: mówi, jakiego odtwarzacza używa jednostka (usługa `com.syu.media`, czyli 7870), i służy kodowi muzycznemu; pytania o urządzenie idą do `DeviceIdentity`.
5. `DayNightBrightness`: `floorFytLevel(level, DeviceIdentity.is7870())`. Parametr nazwij `is7870` i dopasuj javadoc. Z `sendToFyt` usuń czekanie na `probed` (zostaje ponawianie, gdy `!connected`) i komentarz o „a moment after the start”. Gdy `StockSources.isProbed()` i `sProbed` nie mają już wywołań, usuń je (sprawdź `grep`). `DayNightBrightnessFloorTest` ma przejść; popraw nazwy argumentów, jeśli trzeba.
6. Komentarze „units only (7862, 8581)” w `WindowUtil` (≈2191, ≈2510) → „every FYT platform but the 7870, see PinnedPip”.
7. `README.MD`:
   - linia 7 i tabela (≈56–60): „on FYT 7862/8581” → „on FYT units except the 7870 (recognised by the chipset)”;
   - linia 13: na 7870 launcher go nie oferuje.
8. Commit `Pinned PiP and the 7870 brightness minimum: by the chipset, not by the music app`. W treści:
   - decyzja właściciela (muzyka po pakiecie, sprawy systemowe po urządzeniu; Pinned PiP wszędzie na FYT poza 7870);
   - 7870 traci Pinned PiP od pierwszej chwili, a nie po zakończeniu `probeDevice`;
   - na 7862/8581 bez zmian;
   - nieznane FYT: Pinned PiP jak dotąd i bez minimum jasności (minimum dotyczy wyłącznie 7870), z logiem z D1, który pokaże taką jednostkę.

---

## V — Ustawienia: linia z urządzeniem i Androidem w sekcji wersji

### Jak jest dziś
`SettingsFragmentFirst` (≈518–582): summary kategorii `app_version` (`VersionPreferenceCategory`) to najpierw `buildLine` (`Release build · Standard version`), a po wątku `AppTypeText` `appType + "\n" + buildLine`.

### Implementacja
1. `String deviceLine = DeviceIdentity.deviceLine();` (na wątku głównym: bez dysku).
   - Summary od razu: `deviceLine + "\n" + buildLine`.
   - Po wątku: `appType + "\n" + deviceLine + "\n" + buildLine`.

   Czyli trzy linie, a urządzenie stoi **między** typem aplikacji a buildem, np.:
   ```
   System app
   FYT 7862 (ums512_1h10_Natv) · Android 10
   Release build · FYT version
   ```
2. Popraw komentarz nad blokiem (≈519–520) i javadoc `VersionPreferenceCategory` (jak launcher działa tutaj, urządzenie, build).
3. Bez nowych stringów: linia składa się z nazw własnych i liczb.
4. Commit `Settings: the device and its Android under the app type`.

---

## B — Strona wydań bez przeglądarki: link do schowka

### Jak jest dziś
`FytRating.openReleasesPage` (≈1034–1043) przy `ActivityNotFoundException` loguje błąd i pokazuje `fyt_rating_missing`. Wzór kopiowania do schowka jest w `SettingsFragmentFirst` ≈713–720 (`Keys.COPY_PATCH_URL`, `R.string.url_copied`).

### Implementacja
1. Nowa klasa `app/src/main/java/com/android/launcher66/settings/ReleasesPage.java` (final, prywatny konstruktor), `static void open(Context context, String url, String tag)`:
   - `ACTION_VIEW` + `CATEGORY_BROWSABLE` + `FLAG_ACTIVITY_NEW_TASK`, jak dziś;
   - przy `ActivityNotFoundException`: `ClipData.newPlainText("URL", url)` → `ClipboardManager.setPrimaryClip` → `Toast.makeText(LauncherApplication.sApp, R.string.url_copied, Toast.LENGTH_SHORT)` → `Log.w(tag, "No browser to open " + url + ", copied to the clipboard")`;
   - brak schowka albo `RuntimeException` przy kopiowaniu: tylko `Log.w`.

   Toast pokazuj także na Androidzie 13+, gdzie system ma własne potwierdzenie. Tak działa `COPY_PATCH_URL` i tego chce właściciel.
2. `FytRating.openReleasesPage(activity)` → `ReleasesPage.open(activity, RELEASES_URL, TAG)`. `fyt_rating_missing` zostaje dla przypadku braku aplikacji.
3. Commit `Settings: copy a releases page link when there is no browser`.

---

## S — Przycisk „Shizuku Next” w wersji standard bez Shizuku

### Implementacja
1. `res/xml/launcher_preferences.xml`, w `VersionPreferenceCategory` (≈354–367), **między** `app_version_update` a `empty1`:
   ```xml
   <Preference
       android:key="shizuku_download"
       android:title="@string/shizuku_download_button"
       app:isPreferenceVisible="false" />
   ```
   W `Keys` dodaj `SHIZUKU_DOWNLOAD = "shizuku_download"`.
2. `values/strings.xml`, tuż po `install_release_button` (≈419): `<string name="shizuku_download_button">Tap to download Shizuku Next (needed for PiP panes without root)</string>`.
3. Widoczność: `"standard".equals(BuildConfig.FLAVOR) && !WindowHostVdClient.isShizukuInstalled(ctx)`. To wywołanie binderowe, więc licz je poza wątkiem głównym, wzorem `updateBaselineProfileSummary()` (≈1501–1515): metoda `updateShizukuDownload()` z wątkiem i `mHandler.post` + `isAdded()`. Wołaj ją w `onResume()`, które obejmuje też pierwsze pokazanie: po instalacji Shizuku i powrocie przycisk znika. W wersji `fyt` nigdy nie pokazuj go i nie uruchamiaj wątku.
4. Kliknięcie: `case Keys.SHIZUKU_DOWNLOAD` w `onPreferenceClick` (obok `APP_VERSION_UPDATE` ≈983) → `ReleasesPage.open(requireContext(), SHIZUKU_NEXT_RELEASES_URL, TAG)` ze stałą `"https://github.com/rushiranpise/Shizuku-Next/releases/latest"` (https: GitHub i tak przekierowuje). Podepnij `setOnPreferenceClickListener(this)` tak jak `appVersionUpdate` (≈580).
5. Commit `Settings: offer Shizuku Next in the standard version where it is missing` (tylko angielski string).

## T — Tłumaczenie przycisku (osobny commit)
1. Dodaj `shizuku_download_button` do **wszystkich 58** plików `app/src/main/res/values-*/strings.xml` (lista: `ls app/src/main/res/values-*/strings.xml`), w tym samym miejscu: po `install_release_button`. **Nie tłumacz** „Shizuku Next”, „PiP” ani „root”, jeśli dany plik tak robi w innych miejscach. Escapuj `'` i `"`. Język rozpoznaj po kwalifikatorze jak w poprzedniej rundzie (`in` = indonezyjski, `tl` = filipiński, `rm` = retoromański, `zh-rHK`/`zh-rTW` = chiński tradycyjny).
2. Kontrola skryptem: każdy plik ma klucz dokładnie raz, zawiera „Shizuku Next” i jest poprawnym XML-em; nie ma nieescapowanych apostrofów.
3. Commit `Translations: the Shizuku Next download button in every language`.

---

## K — `com/syu/carinfo/` wyłączony, a wskazanie klasy w Fuel statistics bez zmian (cztery commity, każdy z zielonym CI)

### Wymaganie właściciela
`app/src/main/java/com/syu/carinfo/` pochodzi z innej aplikacji syu. Służy wyłącznie temu, żeby ustawienia (sekcja Fuel statistics) pokazały nazwę klasy obsługującej model samochodu; użytkownik szuka w niej potem kodów ręcznie. Dane Fuel statistics obsługują `settings/CanbusClasses.java` i `settings/CanbusService.java`. **Żadna aktywność z carinfo nie może się uruchomić, żaden jej zasób (tła itp.) nie może być ustawiany ani pobierany, a jej klasy nie mają być nawet ładowane.** Wskazanie klasy w ustawieniach ma działać bez zmian.

### Fakty (stan `998d56f`, sprawdź skryptem)
- Katalog ma 1877 plików `.java` (29 MB). 1814 z nich importuje fałszywe `com.syu.canbus.R`; żaden nie importuje R launchera.
- Żaden manifest (`app/src/main`, `app/src/fyt`) nie deklaruje komponentu z carinfo. Każde `JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo…")` w żywym kodzie jest zakomentowane. Poza `CanbusClasses` żaden `Intent` ani `Class.forName` nie wskazuje carinfo. **Aktywności carinfo nigdy więc nie powstają.**
- Żywy kod poza carinfo odwołuje się do niego w 188 plikach: `com/syu/module/canbus` 108, `com/syu/ui/air` 71, `com/syu/ui/parking` 4, `com/syu/canbus/warn` 3, `com/syu/canbus/Receiver.java` 1, `settings/CanbusClasses.java` 1. Rodzaje odwołań:
  - `CanbusClasses`: 558 × `cls = X.class;` i 495 importów. Wynik `String.valueOf(cls)` (czyli `"class " + binarna nazwa`) trafia do `SessionPrefs` pod `"canbus_class"`. Pokazuje go `SettingsFragmentSecond.initUserStats` (≈1120) przez `can.replace("class ", "")`, a liczy `SettingsActivity` (≈201), gdy wartość to `"empty"`. Literał `.class` i tak ładuje klasę.
  - **Stan aktywności**: statyczne pola klas `extends Activity/BaseActivity/TabActivity`: `mIsFront` (328 odczytów), `mInstance` (231), `isFront` (18), `mInit` (4), `bFront` (1), `bNotShowingWarning` (1). Każdy odczyt ładuje i inicjalizuje klasę aktywności. Skoro aktywności nie powstają, pola mają zawsze wartość z deklaracji (`false`/`null`; sprawdź każdą).
  - **Klasy danych** (bez zależności od reszty carinfo), które czytają i piszą callbacki: `rzc/addcan/ConstRzcAddData`, `xp/yinglang/GmConstData`, `wccamry/ConstWcToyota`, `golf7/ConstGolf`, `air/ConstAllAirDara`, `rzc/biaozhi408/Const_RZC4_PSA_ALL_DATA` oraz klasa zagnieżdżona `wc/jingyix5/JYCarMaintaneceOptions.SPreUtils` (czytana w `Callback_0419_FengShenAX7` ≈154–200).
- `app/lint.xml` ma dwa `<ignore path="app/src/main/java/com/syu/carinfo/" />`. `app/src/main/generated/baselineProfiles/{baseline,startup}-prof.txt` mają po 2 linie z `com/syu/carinfo/`.

Zacznij od skryptu inwentaryzacji (scratchpad). Dla każdego pliku spoza carinfo wypisuje każde odwołanie do klasy carinfo z rodzajem (`.class`, pole stanu, inna składowa, literał nazwy) i rodzajem klasy (aktywność/inna). Uruchamiaj go po każdym kroku K.

### K1 — `CanbusClasses`: nazwy jako tekst, bez ładowania klas
1. Skrypt przepisuje `determineClassName()`:
   - `Class<?> cls = null;` → `String name = null;`;
   - każde `cls = X.class;` → `name = "<binarna nazwa X>";`. Pełna nazwa pochodzi z importu. Dla klasy zagnieżdżonej (rodzic importu to plik `.java`) użyj `$`. Klasa bez importu: ten sam pakiet; sprawdź, że takich nie ma;
   - zapis: `"class " + name`, czyli dokładnie dawne `String.valueOf(cls)`. Gałąź `"vehicle_not_exist"` bez zmian;
   - usuń importy carinfo i inne, które przestały być potrzebne.
2. Wydziel `static String className(int carId)` (package-private, `null` gdy brak) z istniejącym `switch`. Zostaw w nim `name = …; break;` i `return name;` na końcu: `return` w każdej gałęzi zrobiłby z `break` kod nieosiągalny. `determineClassName()` woła ją z `DataCanbus.DATA[1000]`.
3. Kontrola skryptem: mapowanie (etykiety `case` → nazwa) ze starego pliku (`git show HEAD:…`) i z nowego jest identyczne; 558 przypisań.
4. Test `app/src/test/java/com/android/launcher66/settings/CanbusClassesTest.java`: trzy identyfikatory z tabeli skryptu (pierwszy, środkowy, ostatni) i jeden nieznany (`null`). Jeżeli nadklasa `com.android.async.AsyncTask` nie daje się załadować na JVM, przenieś `switch` do czystej klasy package-private `CanbusClassNames` i testuj ją. Wybierz jedno i opisz to w commicie.
5. Commit `Canbus: name the car's class without loading it`. W treści: format zapisu bez zmian, więc summary w Fuel statistics jest identyczne.

### K2 — wspólne dane callbacków poza carinfo
1. `git mv` sześciu klas danych do `app/src/main/java/com/syu/module/canbus/data/` (pakiet `com.syu.module.canbus.data`) i zmień w nich linię `package`.
2. `SPreUtils`: wydziel klasę zagnieżdżoną do `com.syu.module.canbus.data.SPreUtils` z niezmienionym ciałem, a `JYCarMaintaneceOptions` niech jej używa. Jeżeli w żywym kodzie istnieje już identyczna klasa o tej nazwie, użyj tamtej i wyjaśnij to w commicie.
3. Popraw importy we **wszystkich** plikach, także wewnątrz carinfo: do K4 carinfo wciąż się kompiluje.
4. Zachowanie bez zmian: ten sam kod, inny pakiet. Commit `Canbus: the data the callbacks share lives outside carinfo`.

### K3 — żadnego stanu ekranów carinfo, które się nie otwierają
1. Każdy odczyt pola stanu aktywności carinfo w żywym kodzie zastąp jego wartością z deklaracji i uprość kod tak, żeby wykonywało się dokładnie to samo co dziś:
   - `if (X.mIsFront && X.mInstance != null) { … }` bez `else` (zwykle `X.mInstance.finish()`) → usuń instrukcję;
   - `if (X.mInstance != null) { … }` → usuń;
   - `if (!X.mIsFront) { B }` → samo `B`. Zostaw blok `{ B }`, jeśli zmienne lokalne mogłyby się zderzyć;
   - `if (X.mIsFront) { A } else { B }` → `B`; `cond && !X.mIsFront` → `cond`; `cond || X.mIsFront` → `cond`; `cond && X.mIsFront` → warunek fałszywy, więc usuń gałąź, **zachowując** efekty uboczne `cond` (wywołania metod);
   - `X.mIsFront ? a : b` → `b`;
   - zapisy do tych pól w żywym kodzie → usuń.

   Nie podmieniaj tekstu na ślepo: każdy zmieniony fragment przeczytaj po edycji. Nie usuwaj niczego, co nie zależy od pola carinfo.
2. Po K3 skrypt inwentaryzacji nie znajduje w żywym kodzie żadnego odwołania do carinfo poza nazwami w `CanbusClasses` i komentarzami.
3. Commit `Canbus: no state of carinfo screens that never open`. W treści: dowód (manifesty, zakomentowane starty), liczby odczytów według pól, że callbacki, okna klimatyzacji i parkowania działają jak dotąd.

### K4 — carinfo poza budową, zachowany do wglądu
1. Warunek: `grep -rn "com\.syu\.carinfo" app/src --include=*.java --include=*.kt` zwraca wyłącznie nazwy w `CanbusClasses` i komentarze.
2. `git mv app/src/main/java/com/syu/carinfo decompiled_carinfo/com/syu/carinfo` (katalog w korzeniu repo, obok `decompiled_FYT_jars`). Dodaj krótki `decompiled_carinfo/README.md` po angielsku: nie jest kompilowany, a nazwy klas wskazywane w Fuel statistics (`CanbusClasses`) prowadzą do plików w nim.
3. `app/lint.xml`: usuń oba `ignore` dla carinfo (i element `issue`, jeśli zostanie pusty). Z obu plików profili usuń linie z `com/syu/carinfo/`.
4. Commit `Canbus: carinfo out of the build, kept as decompiled reference`. W treści: APK nie zawiera już 1877 klas carinfo, a zielone CI dowodzi, że nic ich nie potrzebuje. Summary Fuel statistics bez zmian (K1).

---

## U — Porządki w `app/src/main/res` (trzy commity, każdy z zielonym CI przed następnym)

### Fakty o zasobach (naiwny skan przy planowaniu; to szacunek, a nie lista do usunięcia)
- 1234 pliki, 24 MB. Bez odwołań może być ~1730 z 1792 `dimen` (w `values`, `values-land`, `values-port`), ~190 z 478 drawable (część to rodziny dynamiczne, patrz niżej), ~17 z 107 layoutów, ~50 stringów/tablic, po kilkanaście `bool`, `integer`, `color`, `style`, 2 animacje i `raw/` (3 pliki).
- Po K4 carinfo nie leży już w `app/src`, więc skan go nie widzi (i tak używał tylko fałszywego R).
- `app/src/main/java/com/syu/canbus/R.java` to **fałszywe R** (20 tys. linii stałych z innej aplikacji). Przed K4 importowało je 1895 plików, po K4 robi to nadal część kodu canbus. Ich `R.x.y` **nie wskazuje** zasobów launchera, więc nie liczy się jako użycie. Liczą się tylko odwołania do R launchera: pliki w pakiecie `com.android.launcher66`, pliki z `import com.android.launcher66.R` (Java/Kotlin) i pełne `com.android.launcher66.R.x.y`. **Samego `com/syu/canbus/R.java` nie ruszaj.**
- Release ma `isShrinkResources = true`, więc zysk dotyczy repo i buildów debug. Bezpieczeństwo jest ważniejsze niż liczba usuniętych plików.
- **Wyszukiwanie po nazwie** (tego nie wyłapie budowa, więc to musi zrobić skrypt):
  - literały w `share/ResValue.java` (379 × `getResId("name", R.x.class)`), `Utils.getNameTo*("…")`, `Utils.getId`, `Widget.getResId`;
  - `R.drawable.class.getFields()` + `name.contains(backgrounds)` w `BackgroundSelectorDialog` ≈507: rodziny `bg_custom*` i `app_list_bg*` (`SettingsFragmentSecond` ≈967–1029);
  - layout `name + "_background_selector"` (≈193): `bar_background_selector`, `widgets_background_selector`;
  - nazwy zapisane w preferencjach: `Keys.BAR_SELECTED_BACKGROUND`, `WIDGETS_SELECTED_BACKGROUND` (domyślnie `app_list_bg`), czytane w `Workspace` ≈999/≈1785 i `CellLayout` ≈4349–4373/≈5123;
  - pogoda: `WeatherUtils.getResId("weather" + iconCode)` (`LauncherWeather` ≈117, ≈134);
  - tapety: `Launcher.setDefaultWallpaper(resName)` ≈9080 i `WallpaperPickerActivity` ≈1022–1024 (`extra`, `extra + "_small"`), nazwy z tablic stringów (`wallpapers`, `wallpapers_n`);
  - `LauncherModel` ≈3213/≈3356 (`getIdentifier` nazw z bazy), `Partner` (pakiet zewnętrzny), `SkinResources` (skórki szukają po nazwie zasobów, które launcher ma).

  Zrób pełny spis: `grep -rn "getIdentifier(\|getDeclaredField(\|getFields()\|getResId(\|getNameTo\|R\.[a-z]*\.class" app/src/main/java`. Przejrzyj **każde** miejsce, ustal, jakie nazwy może zbudować, i wpisz je (nazwy, prefiksy lub wzorce) do listy „keep” w scratchpadzie z uzasadnieniem.

### U1 — usuń to, czego nic nie używa
1. Skrypt (scratchpad) zbiera zasoby z `app/src/main/res`:
   - pliki: typ = katalog bez kwalifikatorów;
   - wartości z `values*/*.xml`: `string`, `plurals`, `string-array`/`integer-array`/`array` (typ `array`), `dimen`, `color`, `bool`, `integer`, `style`, `item type="…"`, `declare-styleable` z `attr`, `id`.
2. Użycia:
   - kod (`app/src/**/*.java|kt`, w tym `test`, `debug`, `release`) według reguły R powyżej; nazwy stylów z kropkami w kodzie mają `_`;
   - `R.styleable.Name` i `R.styleable.Name_attr`;
   - **każdy literał w kodzie równy nazwie zasobu** oraz wzorce z listy „keep”;
   - XML w `app/src/**` (zasoby, `AndroidManifest.xml` z `main` i `fyt`, `xml/`): `@type/name`, `@+id/name`, `?attr/name`, `?name`, atrybuty w przestrzeni innej niż `android:`/`tools:` (`app:`, `launcher:`) jako użycie `attr`, `<item name="attr">` w stylach, `parent="…"` oraz niejawny rodzic przez kropkę w nazwie stylu, teksty elementów tablic równe nazwie zasobu (tablice tapet);
   - odwołania z `tools:` licz jako użycia (ostrożnie).
3. **Punkt stały**: odwołanie z pliku lub wartości liczy się tylko wtedy, gdy ten plik lub wartość zostaje. Iteruj, aż nic nie ubywa.
4. Nie usuwaj nigdy: zasobów z manifestu, z listy „keep”, `app/src/debug/res`, `@bool/logcat_on_by_default`.
5. **`res/raw/` usuń w całości** (decyzja właściciela: `conf_platform*.xml` to pozostałość dekompilacji; nie czyta ich ani launcher, ani frameworki 7862/7870).
6. Usuwając wartość z `values/`, usuń ją ze **wszystkich** `values-*/` (tłumaczenia, `values-land`, `values-port`), łącznie z elementami wieloliniowymi (`string-array`, `plurals`). Nie przeformatowuj plików: usuwaj tylko linie elementu i ewentualny komentarz XML, który dotyczy wyłącznie jego.
7. Kontrola po zmianie (skrypt):
   - każde `@type/name` w pozostałych XML i każde `R.type.name` (R launchera) w kodzie wskazuje istniejący zasób;
   - każdy literał z listy „keep” nadal ma swój zasób;
   - wszystkie pliki `values*` są poprawnym XML-em.
8. Commit `Resources: remove what nothing uses`. W treści:
   - liczby usuniętych zasobów według typu;
   - reguła fałszywego R;
   - lista rodzin dynamicznych, które zostały;
   - `raw/` na prośbę właściciela.

   Pełne listy dołącz do raportu, nie do repo.

### U2 — jedna kopia tam, gdzie kopie z kwalifikatorami były takie same
1. **Layouty**: 17 par `layout-land/X` = `layout-port/X` (bajt w bajt) bez `layout/X` → `git mv layout-land/X layout/X` + `git rm layout-port/X` (dla każdej orientacji ta sama treść). `fyt_xml_dt_music_widget.xml` i `fyt_xml_dt_time_widget.xml` mają inny `layout/` domyślny, więc je zostaw. Policz pary po U1 od nowa.
2. **Wartości land/port**: dla każdej nazwy policz wynik dla `land` (`values-land` albo `values`) i `port`. Usuń nadpisanie albo przenieś identyczną parę do `values/` tylko wtedy, gdy oba wyniki się nie zmieniają.
3. **Drawable/mipmap o tej samej nazwie**: usuwaj kopię tylko wtedy, gdy **symulacja wyboru zasobu** dowodzi, że żadna konfiguracja nie dostanie czegoś innego. Przykład z repo: `drawable-nodpi/clock_bg.png` = 6 kopii w `drawable-sw*-*dpi`. Kopie z gęstością są skalowane inaczej niż `nodpi`, więc nie wolno ich usunąć „na oko”.
   - Konfiguracje: sw ∈ {320, 360, 411, 480, 533, 600, 640, 720, 800, 960, 1200}, orientacja ∈ {land, port}, gęstość ∈ {120, 160, 213, 240, 320, 480, 640}.
   - Kwalifikatory katalogu: `swNNNdp`, `land`/`port`, `ldpi`=120/`mdpi`=160/`hdpi`=240/`xhdpi`=320/`xxhdpi`=480/`xxxhdpi`=640, `nodpi`=0xFFFF, brak gęstości = 160. Przy innym kwalifikatorze skrypt **przerywa**.
   - Wybór:
     1. odrzuć sw > sw urządzenia i niepasującą orientację;
     2. jeśli któryś ma sw, zostaw tylko największe sw;
     3. jeśli któryś ma orientację, zostaw tylko te z orientacją;
     4. gęstość: wygrywa dokładna; inaczej porównuj parami jak AOSP `ResTable_config::isBetterThan`. Dla `h > l`: żądana ≥ h → h; l ≥ żądana → l; `((2*l) - żądana) * h > żądana²` → l, inaczej h.
   - Sygnatura: bitmapa (`png`/`jpg`/`webp`/`9.png`) = (hash, skala; `nodpi` = 1:1), XML = hash.
   - Kopię usuń, gdy po jej usunięciu sygnatura każdej konfiguracji jest taka sama. Usuwaj po jednej i licz od nowa.
4. Commit `Resources: one copy where the qualified ones were the same`. W treści: reguła symulacji, liczba usuniętych kopii, przeniesione layouty.

### U3 — jedna nazwa dla identycznych drawable (decyzja właściciela)
1. Para nazw A/B tego samego typu nadaje się do scalenia tylko wtedy, gdy **zbiory katalogów są identyczne** i w każdym katalogu pliki są identyczne bajt w bajt. Inaczej scalenie zmieniłoby którąś konfigurację, więc taką parę tylko wypisz w raporcie (np. `drawable-nodpi/icon_settings.png` = `mipmap-xxxhdpi/ic_settings.png`: różne typy i katalogi).
2. Którą nazwę zostawić: wariant `music_*` zamiast `btav_*` (wskazanie właściciela: `btav_pause_icon` → `music_pause_icon`), nazwę bez przyrostka zamiast z przyrostkiem (`icon_bg1` → `icon_bg`, `radio_btn_ic_prev` → `radio_ic_prev`), dzienną pogodę zamiast nocnej (`weatherNNn` → `weatherNNd`).
3. Przepnij **wszystkie** odwołania do B na A: `R.drawable.B`, `@drawable/B`, literały `"B"` (w `ResValue` zmień tylko literał, pole może zostać). Potem usuń pliki B.
4. **Pogoda**: nazwa jest budowana (`"weather" + iconCode`), więc dodaj czystą funkcję (np. `com.syu.util.WeatherIcons.name(String code)`, bez `android.*`). Dla kodów nocnych scalonych par zwraca nazwę dzienną, a dla reszty `"weather" + code`. `WeatherUtils.getResId` i `LauncherWeather` (≈117, ≈134) mają jej używać. Test z każdą scaloną parą i jednym kodem niescalonym.
5. **Nie scalaj** nazw z rodzin wyliczanych przez `getFields()` (`bg_custom*`, `app_list_bg*`) ani zapisanych w preferencjach. Gdyby się trafiły, wypisz je w raporcie.
6. Kontrola: `grep` każdej usuniętej nazwy B w `app/src` daje pusty wynik (poza fałszywym `com/syu/canbus/R.java`).
7. Commit `Resources: one name for identical drawables`. W treści: lista par, mapowanie pogody, uwaga, że skórka FYT z osobnym B będzie teraz pokazywać A (zgoda właściciela).

---

## 4. Czego NIE zmieniać
- Rozpoznania odtwarzacza po pakiecie i całej logiki muzycznej z sekcji 0 (`StockSources.probeDevice`, `MusicService.startSyuMedia`, `SyuMediaClient`, widgety, `NotificationListener`, `MediaTransportController`, `StockRadioSource`).
- `DefaultDisplayTask.FYT_PINNED_MODE` (`SDK_INT <= Q`): to znaczenie trybu okna 6 we frameworku, nie układ.
- `initDefaultApp()`, `persist.launcher.packagename`, warunku bramki `openPinnedPip`.
- Kodu canbus (`com/syu/canbus`, `com/syu/module`, `com/syu/ui`) poza tym, co wymaga K2–K3, `CanbusService` i fałszywego `com/syu/canbus/R.java`. Treści plików carinfo nie edytuj (poza importami w K2); w K4 przenieś je w całości.
- Miejsc spoza carinfo, które próbują uruchomić aktywność nieobecną w manifeście (np. `com.syu.util.WarnDialgAct` w `Callback_0439_*` BYD, aktywności aktualizacji w `module/canbus/up/CanbusUpIndexActi`): tylko zgłoś je w raporcie.
- Zapisanych ustawień użytkownika (poza nowymi kluczami D1 i dzisiejszym resetem trybów pinned).
- `weather11ny.png` (wygląda na literówkę zamiast `weather11n`): nie naprawiaj, zgłoś w raporcie.

## 5. Weryfikacja
1. JVM: `FytPlatformTest`, `PinnedPipTest`, `DayNightBrightnessFloorTest`, `CanbusClassesTest` (lub `CanbusClassNames`), test pogody z U3 i wszystkie dotychczasowe zielone (`:app:testFytDebugUnitTest` w CI).
2. CI zielone na **każdym** commicie K1–K4 i U1–U3 oraz na ostatnim.
3. `grep`:
   - po D1: `isFytDevice()` nie czyta już właściwości; jedyne `SystemProperties.get("ro.fyt.platform"…)` w kodzie launchera (poza canbus/carinfo) jest w `DeviceIdentity`;
   - po D2: zero `isSyuMediaUnit()` w `LauncherApplication`, `PinnedPip`, `DayNightBrightness`; zero `clearPinnedPipModes` w `StockSources`;
   - po B: oba otwarcia strony wydań idą przez `ReleasesPage.open`;
   - po T: skrypt kontrolny przechodzi dla 58 plików;
   - po K1: zero `.class` i importów carinfo w `CanbusClasses`, a mapowanie stare = nowe (558);
   - po K3: skrypt inwentaryzacji nie znajduje odwołań do carinfo w żywym kodzie;
   - po K4: `app/src/main/java/com/syu/carinfo` nie istnieje, a `grep -rn "com\.syu\.carinfo" app/src` daje tylko nazwy w `CanbusClasses` i komentarze;
   - po U1: brak `res/raw`, a skrypt nie znajduje zerwanych odwołań.
4. Przegląd własnego diffu pod StrictMode: w D1/V/S żadnego `commit()`, PackageManagera ani pliku na wątku głównym.
5. Scenariusze dla właściciela (wypisz w raporcie):
   - a) 7862 po aktualizacji: w logu `FYT platform: FYT_7862, detected from ro.fyt.platform=…`, po restarcie launchera `(saved)`. Pinned PiP i przełącznik Window/PiP jak dotąd. W ustawieniach `FYT 7862 (ums512_1h10_Natv) · Android 10` między „System app” a „Release build · FYT version”;
   - b) 8581: `FYT_8581`, Pinned PiP działa. Podać właścicielowi surowe wartości z logu do potwierdzenia mapy;
   - c) 7870: `FYT_7870` od pierwszego startu, brak przełącznika Window/PiP, zapisane tryby pinned wróciły do Window. Jasność nocna nie schodzi poniżej minimum już przy starcie. Widget muzyki działa jak dotąd (com.syu.media);
   - d) telefon, wersja standard, bez Shizuku: przycisk „Tap to download Shizuku Next…” pod przyciskiem aktualizacji. Po zainstalowaniu Shizuku i powrocie przycisk znika. W wersji fyt go nie ma;
   - e) brak przeglądarki (wyłączona): stuknięcie przycisku Shizuku Next albo podwójne stuknięcie brakującego fYT Rating → toast „URL copied to clipboard”, link w schowku;
   - e2) Fuel statistics po K1–K4: summary pokazuje tę samą nazwę klasy co przed zmianą (np. zrzut sprzed i po). Statystyki paliwa i okna klimatyzacji z CAN działają jak dotąd. W capture nie ma linii z `com.syu.carinfo`;
   - f) po U1–U3: ekran główny, paski, widgety (muzyka, radio, data), wybór tła paska i widgetów (wszystkie tła z listy), pogoda w dzień i w nocy (także kody 03n/04n/13n/50n), tapety domyślne, ustawienia, na 7862 i 7870 w obu orientacjach.

## 6. Raport końcowy (w odpowiedzi, po polsku)
- Lista commitów (hash + temat) i wynik CI.
- Wartości wykrywania z D1 przewidywane dla 7862/7870 i prośba do właściciela o wklejenie linii `FYT platform:` z 8581.
- K: czy `className` zostało w `CanbusClasses`, czy przeszło do `CanbusClassNames`; liczby z K3 według pól; lista miejsc spoza carinfo, które próbują uruchomić aktywności nieobecne w manifeście (bez poprawek).
- U1: liczby według typu, lista rodzin „keep” z miejscem w kodzie, pełna lista usuniętych (w odpowiedzi lub jako plik w scratchpadzie).
- U2: przeniesione layouty, liczba usuniętych kopii.
- U3: scalone pary, pary pominięte i dlaczego.
- Zauważone, a nienaprawione: `weather11ny.png` i wszystko, co wymaga decyzji właściciela.
