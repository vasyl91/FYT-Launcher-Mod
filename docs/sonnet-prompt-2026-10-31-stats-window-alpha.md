# Launcher Mod: pełna alpha okna statystyk, dotyk przechodzi: instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Numery linii są orientacyjne (≈).

Jeden commit kodu, wypchnięty po zielonych testach lokalnych. **Nie twórz pull requesta.**

## 0. Najpierw: usuń dwa nieudane commity (także z historii)

Ostatnie dwa commity kodu są błędne:
- `383a1b9f` (run CI 322) zdjął `FLAG_NOT_TOUCHABLE`, więc dotyk przestał przechodzić pod okno;
- `f7482c35` (run CI 323) to cofnął i zostawił alphę 0,8 dla wszystkiego poza UID systemowym, czyli punkt wyjścia.

Nad nimi leży commit z tym briefem. Ma zostać. Usuń tylko te dwa:

```bash
git rebase --onto cb897ac0 f7482c35 ccr-087eed00-gbqsuz
git log --oneline | head -4      # brief, potem cb897ac0; nie ma 383a1b9f ani f7482c35
git ls-files | grep OverlayTouchMode   # pusto
git push --force-with-lease origin ccr-087eed00-gbqsuz
```

To **jedyny** wyjątek od zasady „bez force-push”, na wyraźne polecenie właściciela. Dalej obowiązuje zasada: czerwony build naprawiasz nowym commitem, bez amend i force-push.

## 1. Czego chce właściciel
1. Okno statystyk ma pełną alphę: tło **i tekst**. Dotyczy launchera, który ma jedno z trzech:
   - UID systemowy;
   - root;
   - Shizuku.
2. Dotyk **zawsze** przechodzi pod okno. `FLAG_NOT_TOUCHABLE` zostaje we wszystkich ścieżkach. Nie zmieniaj flag dotyku i nie zmniejszaj `params.alpha`.
3. Podniesiony limit (`maximum_obscuring_opacity_for_touch`, rozdz. 2) obowiązuje **tylko wtedy, gdy okno statystyk jest widoczne**:
   - podnoszony razem z dodaniem okna;
   - przywracany do poprzedniej wartości, gdy okno znika.

## 2. Przyczyna (Android 12+)
- `DisplayPolicy.adjustWindowParamsLw` sprawdza okno typu SAW (`TYPE_APPLICATION_OVERLAY` też do nich należy). Gdy okno ma `FLAG_NOT_TOUCHABLE` i nie ma `PRIVATE_FLAG_TRUSTED_OVERLAY`, dostaje:
  ```
  alpha = min(alpha, WMS.mMaximumObscuringOpacityForTouch)
  ```
- To alpha **całego okna**, więc dotyczy tła i tekstu razem.
- Limit to `Settings.Global` `"maximum_obscuring_opacity_for_touch"`, domyślnie 0,8. WMS obserwuje to ustawienie: po zmianie wystarczy `updateViewLayout` okna, a serwer przelicza alphę z nowym limitem.
- Przy limicie 1,0 dotyk nadal przechodzi, bo krycie okna (≤ 1) nie przekracza limitu.
- Są więc dwie drogi:
  - **UID systemowy** (albo przyznane `INTERNAL_SYSTEM_WINDOW`): `LayoutParams.setTrustedOverlay()`, ukryte API wołane refleksją. Tak robi `Privileges.applyOverlayTouchMode` w Display-Media-Titles. Bez tego uprawnienia **nie ustawiaj** tej flagi, bo `addView` rzuci `SecurityException`.
  - **Root, Shizuku albo przyznane `WRITE_SECURE_SETTINGS`**: ustaw limit na 1 (`settings put global maximum_obscuring_opacity_for_touch 1`). Shell (Shizuku przez ADB), root i system mają do tego prawo.

## 3. Co już jest w repo (użyj tego)
- **Host uprzywilejowany**, wspólny kod w `vdhost/shared/src/main/java/com/syu/vdhost/`. Działa jako daemon modułu Magisk (system albo root) albo user service Shizuku (`com/syu/util/WindowHostVdShizukuService extends VdHostStub`). Pliki:
  - `VdHostProtocol`: stałe `TX_*`, `Proxy`, `packageCall`;
  - `VdHostStub`: `onTransact`, case `TX_ALLOW_WRITE_SETTINGS` ≈ l. 150–166;
  - `HostServices.allowWriteSettings` ≈ l. 254: wzór kontroli `VdHostCore.isPackageOfUid` i `VdHostCore.runCommand`.
- **Klient** `com/syu/util/WindowHostVdClient`:
  - `hasPrivilegedHost()`, `hasRoot()`, `isSystemUid()`;
  - `addListener(Listener)`: host Shizuku podłącza się asynchronicznie;
  - `allowWriteSettings(pkg)` jako wzór nowej metody.
- **Wzór wywołania** przez hosta poza wątkiem głównym: `LauncherPermissionFlow.allowWriteSettingsThroughHost()`.
- **`su -c` z timeoutem**: `SyuMusicLibrary.su(String)`, ≈ l. 365. Wydziel to do małego wspólnego helpera albo zrób tak samo; nie kopiuj błędów.
- **`VdHostProtocol.VERSION` jest sprawdzane ściśle** (`WindowHostVdClient` ≈ l. 275). **Nie podbijaj go**, bo stary daemon przestałby działać zupełnie.
  - Stary daemon nie zna nowego kodu: `VdHostStub` → `default: return super.onTransact(...)` → false.
  - Wtedy `packageCall` dostaje pustą odpowiedź, a `readString()` zwraca null.
  - Null (albo wyjątek) to dla klienta sygnał, żeby przejść do `su`.

## 4. Implementacja

### 4.1 Czysta decyzja: nowa klasa `settings/StatsOverlayAlpha.java` (bez `android.*` w tej metodzie)
```java
enum Route { NOT_NEEDED, TRUSTED, WRITE_DIRECT, HOST, SU, UNAVAILABLE }
static Route route(int sdk, boolean systemUid, boolean internalSystemWindow, boolean writeSecureSettings,
                   boolean privilegedHost, boolean root, float currentLimit)
```
- `sdk < 31` albo `currentLimit >= 1f` → `NOT_NEEDED`;
- `systemUid || internalSystemWindow` → `TRUSTED`;
- `writeSecureSettings` → `WRITE_DIRECT`;
- `privilegedHost` → `HOST`;
- `root` → `SU`;
- w przeciwnym razie → `UNAVAILABLE`.

### 4.2 Czysta decyzja o limicie (w tej samej klasie, bez `android.*`)
Limit ma być podniesiony tylko na czas widoczności okna. Stan zapisuj w domyślnych SharedPreferences (nowe klucze w `Keys`):
```java
public static final String STATS_OBSCURING_RAISED = "stats_obscuring_raised";     // boolean: to my podnieśliśmy limit
public static final String STATS_OBSCURING_ORIGINAL = "stats_obscuring_original"; // String: wartość sprzed podniesienia, brak klucza = ustawienie nie istniało
```
- **Zapamiętana wartość:** `Settings.Global.getString(cr, "maximum_obscuring_opacity_for_touch")` może zwrócić null, czyli ustawienie nie istniało. Wtedy zapisz null jako brak klucza `STATS_OBSCURING_ORIGINAL`.
- **Funkcja:**
```java
enum LimitAction { NOTHING, RAISE, RESTORE, FORGET }
static LimitAction limitAction(boolean windowShown, boolean raisedByUs, String currentValue)
```
  - `windowShown`, a `currentValue` nie jest ≥ 1 (null lub nieliczbowa wartość < 1) → `RAISE`;
  - `!windowShown && raisedByUs && currentValue` ≥ 1 → `RESTORE`;
  - `!windowShown && raisedByUs`, a `currentValue` < 1 → `FORGET`: ktoś inny zmienił ustawienie, nie ruszaj go, tylko wyczyść znacznik;
  - w pozostałych przypadkach → `NOTHING`.
- **Parsowanie** wartości tekstowej w osobnej czystej metodzie `static float parseLimit(String value)`: null, pusta albo błędna → 0,8.
- **Kolejność przy `RAISE`:** wartość sprzed podniesienia zapamiętaj **tylko** wtedy, gdy znacznika `STATS_OBSCURING_RAISED` jeszcze nie ma. Nie nadpiszesz wtedy oryginału naszą jedynką po awarii. Najpierw zapisz `ORIGINAL` i `RAISED=true` (jedno `edit()…apply()`), potem dopiero zmieniaj ustawienie.
- **Przy `RESTORE`:** gdy oryginał nie istniał, to `delete`; w przeciwnym razie `put` z oryginałem. Po sukcesie usuń oba klucze z prefs.

### 4.3 Cienka warstwa z `Context` (w tej samej klasie)
- **`static void applyBeforeAdd(Context, WindowManager.LayoutParams)`**: wątek główny, bez I/O.
  - Przy `TRUSTED` woła `setTrustedOverlay` refleksją.
  - Gdy refleksja zawiedzie, a `WRITE_SECURE_SETTINGS` jest przyznane (system je ma), dalej działa jak `WRITE_DIRECT`.
  - Przy udanym `TRUSTED` limitu **nie ruszaj wcale**.
- **`static void onWindowShown(Context, Runnable onRaised)`**, **`static void onWindowHidden(Context)`** i **`static void onWindowHiddenNow(Context)`**. Kolejność w każdej z nich jest wiążąca:
  - **`onWindowShown`:**
    1. `removeCallbacks(hideTask)`: anuluje przywrócenie, które czeka;
    2. `desiredShown = true`;
    3. zleca zadanie executorowi.
  - **`onWindowHidden`:** **tylko** `postDelayed(hideTask, 3000)` na wątku głównym. **Nie** zmienia `desiredShown`.
    - Robi to dopiero `hideTask`: `desiredShown = false`, potem zleca zadanie executorowi.
    - `addStatsView()` robi `removeView()` i od razu dodaje okno (przełączenie main/app), więc limit nie ma skakać.
  - **`onWindowHiddenNow`** (`onDestroy`, sprzątanie w `onCreate`): `removeCallbacks(hideTask)`, `desiredShown = false`, zadanie od razu.
  - **Executor:** jeden, **jednowątkowy**, w tle (wywołania hosta i `su` blokują). Zadanie czyta **bieżący** `desiredShown` (wygrywa ostatni), bieżącą wartość ustawienia i znacznik, liczy `limitAction(...)` i wykonuje:
    - `RAISE` → zapisz w prefs (4.2), ustaw `1` trasą z `route(...)`. Potem sprawdź `InputManager.getMaximumObscuringOpacityForTouch()` ≥ 1 i na wątku głównym uruchom `onRaised` (`updateViewLayout`);
    - `RESTORE` → przywróć oryginał tą samą trasą, wyczyść prefs;
    - `FORGET` → wyczyść prefs;
    - `NOTHING` → nic, także bez `onRaised`. Okno dodane, gdy limit już wynosi 1, ma pełną alphę od razu.
  - **Scenariusze, które muszą działać** (sprawdź je w logach i w testach `HideDebounce`, rozdz. 5):
    - **okno znika i wraca po 1 s:** przywrócenie anulowane, żadnego zapisu ustawienia (w logu brak RESTORE i RAISE), limit cały czas 1;
    - **okno wraca tuż po 3 s, gdy RESTORE już trwa na executorze:** następne zadanie widzi `desiredShown = true` → `RAISE` → `updateViewLayout`. Okno może przez ułamek sekundy mieć 0,8;
    - **pokaż → ukryj → pokaż → ukryj w ciągu 3 s:** dokładnie jedno RESTORE, 3 s po **ostatnim** ukryciu.
  - **Czas oczekiwania:** licz go czystą klasą `HideDebounce` (czas podawany z zewnątrz, bez `android.*`): `onHidden(long now)`, `onShown(long now)`, `boolean due(long now)` (true: wykonaj ukrycie, raz). `Handler` jest tylko w cienkiej warstwie: `hideTask` sprawdza `due(SystemClock.uptimeMillis())`.
- **Trasy zapisu** (dla podniesienia i przywrócenia te same, z wartością albo z „delete”):
  - `WRITE_DIRECT` → `Settings.Global.putString(cr, KEY, value)` (null przy przywróceniu nieistniejącego ustawienia);
  - `HOST` → nowe `WindowHostVdClient.setObscuringOpacityLimit(pkg, value)` (4.4). Gdy zwróci null albo rzuci wyjątek, a `hasRoot()` jest prawdą, przejdź do `SU`;
  - `SU` → `su -c "settings put global maximum_obscuring_opacity_for_touch <v>"` albo `su -c "settings delete global maximum_obscuring_opacity_for_touch"`;
  - `UNAVAILABLE` → nic, tylko log.
- **Sprzątanie po awarii lub restarcie:** w `CanbusService.onCreate` (przed jakimkolwiek oknem) wołaj `onWindowHiddenNow(this)`. Jeśli znacznik został z poprzedniego procesu (proces zabity bez `onDestroy`), limit wraca do oryginału.
- **Shizuku wstaje później:** zarejestruj jednorazowo `WindowHostVdClient.addListener`. Gdy host stanie się dostępny, ponów zadanie executora **raz**; ono samo zdecyduje, czy podnieść, czy przywrócić.
- **Bieżący limit okna** czytaj przez `InputManager.getMaximumObscuringOpacityForTouch()` w `try`; przy błędzie przyjmij 0,8.
- **Log:** `Log.i("StatsOverlayAlpha", …)` z trasą, akcją, wartością przed i po, oryginałem i wynikiem hosta lub `su`.

### 4.4 Host (`vdhost/shared`)
- **`VdHostProtocol`:** `static final int TX_SET_OBSCURING_LIMIT = IBinder.FIRST_CALL_TRANSACTION + 16;` oraz `Proxy.setObscuringOpacityLimit(String pkg, String value)`. Napisz to jak `packageCall`, z drugim `writeString`; `value == null` oznacza „usuń ustawienie”.
- **`VdHostStub`:** nowy case z `clearCallingIdentity`, czyta `pkg` i `value`, woła `mServices.setObscuringOpacityLimit(uid, pkg, value)`.
- **`HostServices.setObscuringOpacityLimit(int callerUid, String pkg, String value)`:**
  - kontrola `isPackageOfUid` jak w `allowWriteSettings`;
  - `value == null` → `VdHostCore.runCommand(null, "/system/bin/settings", "delete", "global", "maximum_obscuring_opacity_for_touch")`;
  - w przeciwnym razie `Float.parseFloat(value)` w zakresie [0, 1], inaczej `IllegalArgumentException`. Potem `runCommand(... "put", "global", "maximum_obscuring_opacity_for_touch", value)`;
  - wolno zmieniać **tylko ten jeden klucz**. `Log.i` i zwrot wyniku.
- **`WindowHostVdClient.setObscuringOpacityLimit(pkg, value)`:** jak `allowWriteSettings`, null bez hosta.
- Lista dozwolonych komend `exec()` zostaje **bez zmian**.

### 4.5 `CanbusService` (tworzenie okna ≈ l. 819–960, `removeView()` ≈ l. 973, `onDestroy()` ≈ l. 267)
- **Przed każdym `addView`** wołaj `StatsOverlayAlpha.applyBeforeAdd(this, statsLayoutParams)`. Ścieżki `addView`:
  - Android 14+ z `statsHost`;
  - starsza z `FLAG_LAYOUT_NO_LIMITS`;
  - fallback;
  - `mapApp`.
- **Po udanym `addView`:** `StatsOverlayAlpha.onWindowShown(this, () -> …)`. W callbacku `wm.updateViewLayout(v, statsLayoutParams)`, gdzie `v` to widok, który faktycznie jest w oknie: `statsHost`, a gdy go nie ma, `absoluteStats`. Tylko gdy `v.getParent() != null` i `statsLayoutParams != null`, w `try`.
- **W `removeView()`**, gdy okno było dodane: `StatsOverlayAlpha.onWindowHidden(this)`, z opóźnieniem 3 s (4.3).
- **W `onDestroy()`:** `removeView()` już tam jest. Po nim wołaj `StatsOverlayAlpha.onWindowHiddenNow(this)`, bo po `onDestroy` opóźnione zadanie może nie dojść do skutku.
- Nie zmieniaj flag ani `alpha` w `statsLayoutParams`. `bgAlpha` z ustawień (`shape.setAlpha`) to wybór użytkownika i zostaje.

### 4.6 Co napisać w commicie i raporcie
- `maximum_obscuring_opacity_for_touch` to ustawienie **globalne**. Na czas widoczności okna limit 1,0 dotyczy nakładek wszystkich aplikacji.
- Po zniknięciu okna (po 3 s) albo przy zatrzymaniu serwisu wraca wartość sprzed podniesienia, a gdy jej nie było, ustawienie jest usuwane.
- Gdy proces zginie bez `onDestroy`, przywrócenie nastąpi przy następnym starcie serwisu.
- Na UID systemowym z udanym `setTrustedOverlay` ustawienie nie jest zmieniane.

## 5. Testy (`StatsOverlayAlphaTest`, czyste, JVM)
- **`route`:**
  - każda trasa, w tym `UNAVAILABLE`, gdy nic nie ma;
  - priorytety: system > `WRITE_SECURE_SETTINGS` > host > `su`, np. system + host + root → `TRUSTED`; host + root → `HOST`;
  - `NOT_NEEDED` przy sdk 30, oraz przy limicie 1,0 i sdk 34.
- **`limitAction`:**
  - okno widoczne i wartości null, `"0.8"`, `"0.5"` → `RAISE`; widoczne i `"1"` / `"1.0"` → `NOTHING`;
  - ukryte, znacznik jest, `"1"` → `RESTORE`;
  - ukryte, znacznik jest, `"0.7"` → `FORGET`;
  - ukryte bez znacznika, przy każdej wartości → `NOTHING`.
- **`parseLimit`:** null, `""`, `"abc"` → 0,8; `"1"` → 1; `"0.75"` → 0,75.
- **`HideDebounce`** (czas w ms podawany w teście):
  - `onHidden(0)`, `onShown(1000)` → `due(3000)` i `due(10000)` fałsz: powrót w ciągu 3 s, żadnego przywrócenia;
  - `onHidden(0)` → `due(2999)` fałsz, `due(3000)` prawda, potem `due(3001)` fałsz: przywrócenie raz;
  - `onShown(0)`, `onHidden(500)`, `onShown(1000)`, `onHidden(2000)` → `due(4999)` fałsz, `due(5000)` prawda: jedno przywrócenie, 3 s po ostatnim ukryciu;
  - `onHidden(0)`, `due(3000)` prawda, `onShown(3100)` → `due` fałsz, a `limitAction(true, …)` daje `RAISE`: powrót tuż po przywróceniu.
- **Uruchamianie lokalne:** Gradle tu nie działa, użyj `javac` + JUnit console standalone 1.10.2 z `app/`.
  - classpath `../android_jar/android-36.jar`;
  - `-sourcepath <stuby>:src/main/java`;
  - stuby w scratchpadzie, jak w briefie `docs/sonnet-prompt-2026-10-31-stats-window-font.md`;
  - uruchom nowy test oraz `StatsWindowSizeTest`, `FuelModelTest`, `ConsumptionUnitsTest`, `CanbusLibraryTest`, `RoadGradeTest`;
  - jeśli kod w `vdhost/shared` da się skompilować z `android-36.jar`, skompiluj go dla sprawdzenia.

## 6. Przegląd własnego diffu przed pushem
- `git grep -n "NOT_TOUCHABLE" -- app/src/main/java/com/android/launcher66/settings/CanbusService.java`: tylko ustawienie flagi, żadnego `&= ~`.
- W nowym kodzie żadnego `params.alpha =` / `.alpha = Math.min`.
- `OverlayTouchMode` nie istnieje nigdzie.
- `VdHostProtocol.VERSION` bez zmian.
- `setTrustedOverlay` wołane tylko przy `TRUSTED`.
- **Każde podniesienie ma swoje przywrócenie:**
  - `onWindowShown` po każdym udanym `addView`;
  - `onWindowHidden` w `removeView()` i natychmiastowe w `onDestroy()`;
  - sprzątanie w `onCreate`.
- Host zmienia tylko klucz `maximum_obscuring_opacity_for_touch` i tylko na wartość z [0, 1] albo „delete”.
- Żadnych operacji na ustawieniach ani wywołań hosta i `su` na wątku głównym.
- `desiredShown = false` ustawiają **tylko** `hideTask` i `onWindowHiddenNow`, nigdy samo `onWindowHidden`. `onWindowShown` zaczyna od `removeCallbacks(hideTask)`.

## 7. Commit
`Stats window: full alpha of the window and its text as system, with root or Shizuku, only while it is shown; the touches still go through`

W treści commita:
- przyczyna (limit 0,8 z `DisplayPolicy`);
- trzy trasy;
- podniesienie limitu tylko na czas widoczności okna i przywrócenie poprzedniej wartości;
- nowa transakcja hosta bez zmiany `VERSION` (stary daemon → `su`);
- treść z 4.6.

Trailery sesji, bez nazwy modelu. Push, potem obserwuj CI. Czerwony build naprawiasz nowym commitem.

## 8. Raport dla właściciela (po polsku)
- **Wyniki:** numer runu CI i wynik testów.
- **W aucie:**
  - `logcat -s StatsOverlayAlpha`: trasa, akcja, wartości;
  - przy widocznym oknie `settings get global maximum_obscuring_opacity_for_touch` daje `1`;
  - po wyłączeniu statystyk albo zatrzymaniu serwisu (po ok. 3 s) wraca poprzednia wartość, zwykle `null`;
  - tło i tekst w pełni kryjące, dotyk przechodzi pod okno.
- **Zastrzeżenia:**
  - bez UID systemowego, roota i Shizuku zostaje 0,8 i nie da się tego obejść bez blokowania dotyku;
  - gdy Shizuku przez ADB zniknie (restart), przywrócenie nastąpi, gdy host wróci albo przez `su`;
  - przy starej wersji modułu Magisk zadziała `su`; nowa wersja modułu obsłuży to przez hosta.
