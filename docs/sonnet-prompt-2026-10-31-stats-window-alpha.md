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

### 4.2 Cienka warstwa z `Context` (w tej samej klasie)
- **`static void applyBeforeAdd(Context, WindowManager.LayoutParams)`**: wątek główny, bez I/O.
  - Przy `TRUSTED` woła `setTrustedOverlay` refleksją.
  - Gdy refleksja zawiedzie, a `WRITE_SECURE_SETTINGS` jest przyznane (system je ma), to trasa `WRITE_DIRECT` z 4.2.
- **`static void raiseLimitAsync(Context, Runnable onRaised)`**: praca na wątku tła (wywołania hosta i `su` blokują).
  - `WRITE_DIRECT` → `Settings.Global.putFloat(cr, "maximum_obscuring_opacity_for_touch", 1f)`;
  - `HOST` → nowe `WindowHostVdClient.allowOpaqueOverlays(pkg)` (4.3). Gdy zwróci null albo rzuci wyjątek, a `hasRoot()` jest prawdą, to `SU`;
  - `SU` → `su -c "settings put global maximum_obscuring_opacity_for_touch 1"`.
  - Po każdej udanej próbie odczytaj `InputManager.getMaximumObscuringOpacityForTouch()` (publiczne API 31). Gdy jest ≥ 1, uruchom `onRaised` na wątku głównym.
- **Bieżący limit** czytaj przez `InputManager.getMaximumObscuringOpacityForTouch()` w `try`; przy błędzie przyjmij 0,8.
- **Shizuku wstaje później:** zarejestruj jednorazowo `WindowHostVdClient.addListener`. Gdy host stanie się dostępny, a limit nadal jest < 1, ponów `raiseLimitAsync` **raz**.
- **Log:** `Log.i("StatsOverlayAlpha", …)` z trasą, limitem przed i po oraz wynikiem hosta lub `su`.

### 4.3 Host (`vdhost/shared`)
- **`VdHostProtocol`:** `static final int TX_ALLOW_OPAQUE_OVERLAYS = IBinder.FIRST_CALL_TRANSACTION + 16;` oraz `Proxy.allowOpaqueOverlays(String pkg)` przez `packageCall`.
- **`VdHostStub`:** dopisz `TX_ALLOW_OPAQUE_OVERLAYS` do case'u z `TX_ALLOW_WRITE_SETTINGS`, z `clearCallingIdentity`, i woła `mServices.allowOpaqueOverlays(uid, pkg)`.
- **`HostServices.allowOpaqueOverlays(int callerUid, String pkg)`:**
  - ta sama kontrola `isPackageOfUid` co w `allowWriteSettings`;
  - potem `VdHostCore.runCommand(null, "/system/bin/settings", "put", "global", "maximum_obscuring_opacity_for_touch", "1")`;
  - `Log.i` i zwrot wyniku.
- **`WindowHostVdClient.allowOpaqueOverlays(pkg)`:** jak `allowWriteSettings`, null bez hosta.
- Lista dozwolonych komend `exec()` zostaje **bez zmian**.

### 4.4 `CanbusService` (tworzenie okna ≈ l. 819–960)
- Po zbudowaniu `statsLayoutParams`, przed każdym `addView`, wołaj `StatsOverlayAlpha.applyBeforeAdd(this, statsLayoutParams)`. Ścieżki `addView`:
  - Android 14+ z `statsHost` (okno na szerokość strony);
  - starsza z `FLAG_LAYOUT_NO_LIMITS`;
  - fallback;
  - `mapApp`.
- Po dodaniu okna: `StatsOverlayAlpha.raiseLimitAsync(this, () -> …)`. W callbacku `wm.updateViewLayout(v, statsLayoutParams)`, gdzie `v` to widok, który faktycznie jest w oknie: `statsHost`, a gdy go nie ma, `absoluteStats`. Tylko gdy `v.getParent() != null`, w `try`.
- Nie zmieniaj flag ani `alpha` w `statsLayoutParams`. `bgAlpha` z ustawień (`shape.setAlpha`) to wybór użytkownika i zostaje.

### 4.5 Skutek uboczny (napisz w commicie i w raporcie)
- `maximum_obscuring_opacity_for_touch` to ustawienie **globalne**: limit 1,0 dotyczy nakładek wszystkich aplikacji (ochrona przed tapjackingiem jest słabsza).
- Nie przywracamy go, bo okno statystyk działa stale.
- Na UID systemowym przy udanym `setTrustedOverlay` ustawienie nie jest zmieniane.

## 5. Testy (`StatsOverlayAlphaTest`, czyste, JVM)
- **Każda trasa**, w tym `UNAVAILABLE`, gdy nic nie ma.
- **Priorytety:** system > `WRITE_SECURE_SETTINGS` > host > `su`, np. system + host + root → `TRUSTED`; host + root → `HOST`.
- **`NOT_NEEDED`:** sdk 30 przy wszystkim przyznanym, oraz limit 1,0 przy sdk 34.
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

## 7. Commit
`Stats window: full alpha of the window and its text as system, with root or Shizuku; the touches still go through`

W treści commita:
- przyczyna (limit 0,8 z `DisplayPolicy`);
- trzy trasy;
- nowa transakcja hosta bez zmiany `VERSION` (stary daemon → `su`);
- skutek uboczny z 4.5.

Trailery sesji, bez nazwy modelu. Push, potem obserwuj CI. Czerwony build naprawiasz nowym commitem.

## 8. Raport dla właściciela (po polsku)
- **Wyniki:** numer runu CI i wynik testów.
- **W aucie:**
  - `logcat -s StatsOverlayAlpha`: trasa i limit;
  - `settings get global maximum_obscuring_opacity_for_touch` daje `1` (trasy root, Shizuku i bezpośredni zapis);
  - tło i tekst w pełni kryjące, dotyk przechodzi pod okno.
- **Zastrzeżenia:**
  - bez UID systemowego, roota i Shizuku zostaje 0,8 i nie da się tego obejść bez blokowania dotyku;
  - Shizuku przez ADB nie przetrwa restartu, ale samo ustawienie zostaje zapisane;
  - przy starej wersji modułu Magisk zadziała `su`; nowa wersja modułu obsłuży to przez hosta.
