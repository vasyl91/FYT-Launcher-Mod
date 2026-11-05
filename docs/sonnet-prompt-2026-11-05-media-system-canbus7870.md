# Launcher Mod: okładki i serca com.syu.media (7870), flavor `fyt` → `system` z bezpiecznikiem kodu FYT, biblioteka i callbacki CAN dla 7870, automatyczna diagnostyka kodów CAN, PiP przy zmianie dzień/noc, poprawki z logów — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, wyłącznie na gałęzi `testBranch`. Zacznij od `git pull origin testBranch`. **Nie twórz pull requesta.**

Numery linii to stan z `bbcfaa49`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie. Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`. `settings/` to `…/launcher66/settings/`.

## 0. Kolejność commitów i jej powód

| # | Temat commita | Problem | Dlaczego tutaj |
|---|---|---|---|
| C1 | `Build: the fyt flavor is now system` | 3 | Zmienia nazwy zadań CI (`testSystemDebugUnitTest`) i plików wydań. Każdy następny commit buduje się już pod nową nazwą, a README i stringi nie wchodzą w konflikty. |
| C2 | `FYT code: a failure is reported, not a crash` | 3 (bezpiecznik) | Nowy kod FYT z C4–C8 od razu korzysta z bezpiecznika. Legenda logów dostaje linię `compat – …` raz. |
| C3 | `Logs: icon cache stamps from the package manager, framework warnings explained` | 2 | Mały i niezależny. |
| C4 | `Canbus: a library and callbacks of its own for the 7870` | 6 | C5 porównuje kandydatów z biblioteką, więc musi mieć właściwą bibliotekę dla urządzenia. |
| C5 | `Fuel statistics: reader codes reach the service, automatic code check while driving` | 5 | Korzysta z C2 i C4. |
| C6 | `VD host: protocol 3 with optional calls, older hosts keep the panes` | 1, 3 (infrastruktura) | Ścieżka Shizuku dla C7/C8 i nadawanie uprawnień w C9. |
| C7 | `Music widget: covers of com.syu.media's online radio, FM and BT` | 1 | Najpierw okładki: drogi odczytu (pliki, providery), z których korzysta też C8. |
| C8 | `Music widget: com.syu.media favorites, FM read-only, a note on the app's screen` | 1 | Korzysta z odczytu providera radia i z `SyuMediaFiles` z C7. |
| C9 | `Standard version: overlay, notification access and unknown apps through root or Shizuku` | 3 (rozszerzenie) | Korzysta z C6. |
| C10 | `PiP: panes survive a recreated launcher, day/night diagnostics` | 4 | Dotyka cyklu życia paneli. Osobno, żeby łatwo było cofnąć. |
| C11 | `Docs: README and briefs consistent` | wszystkie | Tylko jeśli po C1–C10 coś w README zostało niespójne. |

**Każdy commit buduje się samodzielnie i przechodzi testy.** Wypychaj go od razu. Przed następnym commitem poczekaj na zielone CI.

## 1. Zasady pracy (obowiązują w każdym commicie)

**Język i treść:**
- Komentarze, Javadoc, `Log.*` i opisy commitów piszesz **wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, które wyjaśniają *dlaczego*.
- **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.

**Commity:**
- Temat `<Obszar>: <co>` (tematy z tabeli §0). Treść zawijaj na ~72 znaki i wpisz do niej fakty z §3.
- Zakończ commit dokładnie trailerami z system-remindera sesji.
- Push: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy, z odstępem 2/4/8/16 s.

**CI:**
- Workflow to `.github/workflows/build.yml`, z `cancel-in-progress`. Sprawdzaj run **ostatniego** commita przez GitHub MCP (`actions_list`, `get_job_logs`).
- Czerwony build naprawiasz kolejnym commitem. Bez amend i bez force-push.

**StrictMode jest włączony.** W nowym kodzie na wątku głównym nie może być:
- I/O plików;
- zapytań do bazy;
- zapytań do `ContentResolver`;
- sieci;
- `su`;
- blokujących wywołań hosta VD.

Prefy zapisuj przez `apply()`.

**Testy:**
- JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `settings/CrashLoopPolicyTest`, `settings/ReaderGuessesTest`, `settings/FuelModelTest`, `fyt/car/StockKindArbiterTest`.
- `unitTests.isReturnDefaultValues = true`.
- Logikę decyzyjną pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:**
- Bez nowych zależności (OkHttp i Glide już są).
- Bez zmiany schematu bazy launchera.
- Nowe klucze prefów wolno dodawać (w `settings/Keys.java`).

**Napisy:**
- Nowy string dodaj do **każdego** `res/values*/strings.xml`, który ma `logcat_names_info_summary`. Takich plików jest 59, w tym domyślny `res/values/strings.xml`.
- Tłumaczenie ma być na język pliku.
- Zmieniony string popraw we wszystkich plikach, które go mają.

**Usuwanie:** usuwaj dopiero po `rg` w całym repo poza `docs/` (`--glob '!**/generated/**'`, Java, Kotlin, XML, gradle, workflowy, skrypty).

**Kontrola bez SDK (opcjonalnie):** `javac -proc:none -cp android_jar/android-36.jar …` w katalogu tymczasowym. Porównuj listę błędów przed zmianą i po niej: brak androidx daje dużo błędów niezwiązanych z Twoją zmianą.

## 2. Decyzje właściciela (nie zmieniaj ich)

**Problem 1 (com.syu.media):**
1. Dotyczy **wyłącznie com.syu.media**. Ścieżka com.syu.music (7862/8581) działa dokładnie jak dziś:
   - `settings/SyuMusicLibrary`;
   - gałęzie com.syu.music w `MediaFavoriteController`;
   - `fyt/car/MusicService.onStartCommand`;
   - nazwy i logo stacji z com.syu.radio w `StockRadioSource`.
2. Najpierw droga bez uprawnień: wszystko, czego tu używasz z com.syu.media, jest na 7870 eksportowane albo czytelne. Kiedy krok wymaga uprawnień, kolejność to **aplikacja systemowa → root → Shizuku**. Czego nie da się zrobić przez Shizuku, loguj raz na proces i opisz w raporcie.
3. Serce muzyki USB i radia online w widżecie:
   - zapis do bazy com.syu.media jak dziś;
   - plus jednorazowy (raz na proces) Toast, że com.syu.media pokaże zmianę po przeładowaniu biblioteki;
   - **bez** nowej opcji w ustawieniach; com.syu.media zostaje ukryte na liście „Select the music apps that should use the favorite cache”.
4. Serce FM w widżecie:
   - pokazuje stan z com.syu.media (**tylko odczyt**); naciśnięcie nic nie zmienia (log raz na proces);
   - dotknięcie samego widżetu dalej otwiera stronę radia;
   - serce BT zostaje szare.

**Problem 3 (flavor):**

5. Flavor `fyt` staje się `system`. W miejscach, które dzielą kod na „jednostka FYT” i „inne urządzenia”, **nazw nie zmieniasz** (lista w C1).
6. Oba flavory działają na każdym urządzeniu, tak jak dziś:
   - `system` tam, gdzie klucz platformy pasuje;
   - `standard` wszędzie, z rootem lub Shizuku.
7. Kod przeznaczony dla jednostek FYT nie może wywrócić launchera.
   - Wyjątek z takiego kodu jest przechwycony i zapisany jako **raport niekrytyczny** przez mechanizm crash handlera, w pliku `compat_pid_<czas>.txt`.
   - Legenda w ustawieniach dostaje linię `compat – …` pod linią `crash – …`. Tłumaczenia muszą być we wszystkich językach.
8. Sekcja `app_version` w ustawieniach:
   - druga linia pokazuje **tylko typ buildu** („Release build” / „Debug build”);
   - przycisk aktualizacji pokazuje w nawiasie plik, który pobierze, np. „Tap to download and update the app (system_release_1.2.2.apk)”.

**Problem 5 (automatyczna diagnostyka CAN):**

9. Startuje **2 minuty po wykryciu ruchu z GPS**.
   - Tylko na jednostkach FYT (`LauncherApplication.isFytDevice()`).
   - Tylko przy włączonych „Fuel statistics” (`user_stats`).
   - Tylko gdy dla tego auta test jeszcze się nie odbył albo poprzedni został przerwany (ACC off) lub nie skończył się z innego powodu.
10. Diagnostyka nie zapisuje pliku. Do logcata trafia tylko jedna linia podsumowania.
11. Kody wpisane ręcznie zawsze wygrywają. Kandydat z diagnostyki jest używany, gdy biblioteka nie ma kodu dla auta albo gdy jej kod w teście nie dał żadnych danych, a kandydat dał. Różnice są logowane.

**Problem 6 (com.syu.canbus 7870):**

12. 7870 dostaje własną ścieżkę callbacków i własną bibliotekę w assets. Launcher wybiera ją sam, po urządzeniu.
    - Obecna ścieżka i biblioteka 7862/8581 zostają domyślne dla pozostałych jednostek FYT.
    - Bibliotekę 7870 da się zaktualizować (skrypt i import) tak samo jak domyślną.

## 3. Fakty

### 3.1 Problem 1: com.syu.media na 7870

**Test i środowisko:** tester na 7870, Android 13, standard + Shizuku. Pliki USB, radio online, BT i FM.
- Serca działają tylko w kierunku aplikacja → widżet.
- Brak okładek dla radia online, FM i BT.
- AIMP działa w pełni.

**Kod launchera:**
- `fyt/car/SyuMediaClient` binduje `com.syu.media.music.MusicService` i `com.syu.media.online.OnlineRadioService` (IPlayer).
- Ulubione zapisuje w `content://com.syu.media/song` lub `/radio` (`writeFavorite` ≈399, `readFavorite` ≈419), selekcja `_id=? AND path=?`. Widżet czyta flagę z providera (przy nowym utworze, po zapisie i co 5 tików), więc po naciśnięciu serce w widżecie się nie cofa.
- `Song.read()` (≈536–562) czyta po `length` tylko `type` i pomija resztę pól `RadioSource`.
- `MusicService.applySyuMedia` (≈258–307) buduje `StockTrack` z `cover = null`.
- `StockRadioSource.requestLookup()` (≈204) **wyłącza** szukanie w `/sdcard/radio_logo` na jednostce com.syu.media. Komentarz „com.syu.media keeps no such files” jest błędny (pkt 6 niżej).
- `StockBtSource` rejestruje kody modułu 2: 0, 1, 2, 13, 26, 28. Kodu okładki (51) nie zna.
- `MediaFavoriteController.isStockFavoriteAvailable()` (≈1330) zwraca false dla nakładek RADIO i BT.

**Log (03-11):**
- Zapis z widżetu się udaje: `SyuMedia: favorite MEDIA_MUSIC=… written to 1 row(s)` (06:56:26.440, 06:56:32.795, …) i `MEDIA_ONLINE` (06:59:31.905, 06:59:37.819).
- Po zapisie com.syu.media loguje tylko `getPlayingSong` i `MediaProvider query uri: content://com.syu.media/song 1` (odczyt zwrotny launchera). Lista i ekran nie reagują.
- Serce naciśnięte w samej aplikacji (06:56:22.722):
  ```
  MusicFragment: listFavoriteNotify:<path> favorite:true
  MusicFragment: update item music:MediaSource(... favorite=true)
  MediaBaseFragment: notifyItemChanged favorite:true
  ```
- FM: `RadioCtrlFragment: updateFavorite station: RadioStation: _id:null, title:null city:DEF freq:10740 favorite:false cover_path:null` (07:00:48.113), `updateFavorite:true,freqInt:9040`, `RadioIconCache: coverSave filename:/storage/emulated/0/radio_logo` (06:56:12.360), `RadioIconCache: key:8760 ,path:null`.
- Radio online: `ResourcesLoader: path:odm/app/cabinet.data` (06:57:54.247).
- BT:
  - `blink` (PID 1179) zapisuje `/data/blink/Id3_CoverArt.JPEG` o 07:04:20.835;
  - `BtmusicFragment` czyta go o 07:04:23.683 (`iconPath:…`, `albumChange album:…`);
  - zmiana utworu w launcherze nastąpiła o 07:04:19.754.
- SELinux działa w trybie **permissive** (`permissive=1` we wszystkich `avc`).
- com.syu.media działa jako zwykły uid aplikacji `u0a82` (domena `platform_app`), **nie jako uid 1000**. Wersja systemowa launchera nie ma więc do jej danych większego dostępu niż standard.

**Dekompilacja** (`decompiled_com.syu.media/classes.dex/sources/`):
- Lokalizacja:
  - aplikacja w `com/syu/media/`;
  - radio w `com/syu/radio/` i `com/syu/manger/`;
  - provider radia w `decompiled_com.syu.media/classes2.dex/sources/com/syu/radio/provider/`.
- Manifestu nie ma. O eksporcie providera radia rozstrzyga próba w czasie działania (`SecurityException`). Sprawdź poniższe fakty w kodzie, zanim na nich oprzesz zmianę; różnice zgłoś.

1. **Provider `com.syu.media`** (`provider/MediaProvider`, baza Room `media_database.db`):
   - ścieżki:
     - `song` (1);
     - `list/#` (2): tylko query, zapytania łączone dla list 1 i 8;
     - `video` (3): query omyłkowo czyta `song`;
     - `Folder/#` (4): nieużywane;
     - `radio` (5).
   - `insert`, `update` i `delete` piszą przez surowe `SupportSQLiteDatabase` (własna transakcja, bez DAO Room) i **bez `notifyChange`**. `InvalidationTracker` Room nie zobaczy takiego zapisu, dopóki aplikacja nie zrobi własnej transakcji Room.
   - Provider jest eksportowany bez uprawnienia: zapis launchera z uid 10199 się udaje.
   - Kolumny:
     - `song(_id, title, displayName, artist, album, path, folder, duration, favorite, length)`;
     - `radio(type, country, local, freq, icon, _id, title, displayName, artist, album, path, folder, duration, favorite, length)`.
   - Skany wstawiają `INSERT OR IGNORE`, więc nie kasują `favorite`. `UPDATE` całego wiersza robi tylko serce naciśnięte w aplikacji (`MediaBaseFragment.notifyItemChanged` → `MediaDao.update`).
2. **Serce w aplikacji:**
   - muzyka: checkbox `musicFavorite` w `music/fragment/MusicFragment` → `playSong.setFavorite(z)` (obiekt w pamięci) → LiveData `MusicModel.musicFavorite` → `MediaBaseFragment.notifyItemChanged` → `MediaDao.update` (Room). Room odświeża Flow: `MediaProxy.mPlayingList` (lista grania) i `MediaApp` (`getPlayListById(1)`);
   - radio online: to samo z `RadioSource`;
   - FM: `radio/fragment/RadioCtrlFragment.updateFavorite(fav, true)` → `RadioDao.findStationByFreqAndCity(freq, city)` → `insert`, `delete` albo `update` w `radio_database.db`, tabela `city_station(_id, title, freq, city, cover_path, url, online, favorite)`. `city` to `"DEF"` albo wybrane miasto.
   - **Nic w aplikacji nie słucha zmian z zewnątrz.** Nie ma `ContentObserver`, receivera ani metody IPC dla ulubionych.
   - Zmiana zapisana przez provider pojawi się w aplikacji dopiero po jej własnym zapisie Room (serce w niej, skan nośnika) albo po jej restarcie. **Zmiana utworu niczego nie przeładowuje**, bo lista grania jest w pamięci.
3. **IPC** (`IPlayer`, implementacja `ipc/PlaybackBinder`):
   - transakcje: 1 `play`, 2 `playListWithId(list, id)`, 3 `playWithPath`, 4 `playWithId`, 5 `playLast`, 6 `playNext`, 7 `pause`, 8 `isPlaying`, 9 `getProgress`, 10 `getPlayingSong`, 11 `getPlayMode`, 12 `seekTo`, 13 `setPlayMode`, 14 `audioSessionId`, 15/16 `(un)registerCallback`, 17/18 `(un)registerCallback2` (rozmiar wideo);
   - **brak czegokolwiek o ulubionych**;
   - `playListWithId` ładuje listę z bazy, ale uruchamia utwór od nowa (`playListWithSource`), więc odpada;
   - `ICallback`: `onSongChanged`, `onPlayStatusChanged`, `onPlayModeChanged`;
   - kody, których używa `SyuMediaClient`, są zgodne;
   - `getPlayingSong()` daje kopię z pamięci, więc jej `favorite` bywa nieaktualne. Launcher słusznie czyta flagę z providera.
4. **Receivery i akcje:**
   - `companion/receiver/Receiver`, rejestrowany tylko przez `MainAct`: `com.fyt.systemui.remove` (zapis stanu, możliwa zmiana kanału dźwięku) i `PACKAGE_*`;
   - `MediaFiles`: `MEDIA_MOUNTED`, `UNMOUNTED`, `EJECT` (chronione; uruchamiają skan);
   - `MainAct` przyjmuje akcje kart: `com.syu.music`, `com.syu.radio`, `com.syu.online`, `com.syu.btmusic`;
   - nie ma obsługi klawisza „ulubione”.
5. **Provider `com.syu.radio`** (`com/syu/radio/provider/RadioProvider`, w tej samej aplikacji):
   - `city_station` (1): query. Gdy jest selekcja, `selectionArgs` są wymagane (`Intrinsics.checkNotNull`), inaczej NPE. Dlatego `content query --where …` bez argumentów zawodzi;
   - `city_station/*/#` (2): zwraca `query("")`. Nie używaj;
   - `local_assert` (3): statyczny kursor `freq, cover_path, title` z logo znalezionymi w `radio_logo`. `MediaApp` odświeża go i woła `notifyChange("content://com.syu.radio/local_assert")`, czyli jest przewidziany dla innych aplikacji;
   - `insert`, `update` i `delete` zwracają `null`/`-1`: **tylko odczyt**.
6. **Okładki:**
   - **FM** (`companion/cache/RadioIconCache`):
     - katalog `MediaApp.getInternalPath()` (`/storage/emulated/0`) + `/radio_logo`, opcjonalnie podkatalog miasta;
     - pliki `<Nazwa>_<freq>.png`: nazwa dzielona po `_` na **dokładnie 2** części; z częstotliwości usuwana jest kropka (`90.40` → 9040, więc dwa miejsca po przecinku);
     - bez logo aplikacja pokazuje losowo obrazek `radio1`–`radio3` ze swoich zasobów.
   - **Radio online** (`online/fragment/OnlineFragment` ≈565–570, `companion/resources/ResourcesLoader`):
     - `RadioSource.icon` to **nazwa pliku drawable** w paczce zasobów `/odm/app/cabinet.data` (APK);
     - aplikacja bierze pakiet z `getPackageArchiveInfo` i zasób przez `getIdentifier(nazwa bez rozszerzenia, "drawable", pakiet)`;
     - bez ikony bierze okładkę z `IconCache` (osadzoną albo losową `album*`).
   - **BT** (`com/syu/manger/module/bt/BluetoothObserver`):
     - com.syu.ms, moduł 2, **kod 51** (`strs[0]`) to ścieżka okładki (tu `/data/blink/Id3_CoverArt.JPEG`);
     - aplikacja czyta plik od razu po kodzie 51 i ponownie 1,5 s po zmianie tytułu lub czasu (`BluetoothObserver$updateIcon$1`);
     - inne kody tej klasy: 0 tytuł, 1 wykonawca, 2 czas całkowity, 3/4 numer i liczba utworów, 9 stan BT, 13 gra, 26 album, 28 pozycja, 44 bateria telefonu, 45 sygnał.
   - **Muzyka USB:** okładka osadzona. Launcher czyta ją sam; bez zmian.

**Co jest możliwe** (rozstrzyga C7/C8):

| Operacja | Bez uprawnień | System (uid 1000) | Root | Shizuku (shell) |
|---|---|---|---|---|
| Serce muzyki/online: widżet → baza com.syu.media | tak (provider, dziś) | tak | tak | tak |
| …widżet → ekran com.syu.media od razu | **nie** (brak API) | nie | nie (tylko restart aplikacji/utworu, zabroniony) | nie |
| Serce FM: aplikacja → widżet | tak, jeśli `com.syu.radio` eksportowany | tak (czyta też nieeksportowany) | tak (`su -c content query`) | **nie**, jeśli nieeksportowany |
| Serce FM: widżet → aplikacja | **nie** (provider tylko do odczytu, baza prywatna, aplikacja i tak by nie zauważyła) | nie | nie | nie |
| Logo FM | tak (`local_assert`; `/sdcard/radio_logo` z dostępem do pamięci) | tak | tak | tak |
| Ikona stacji online | tak (APK w `/odm/app`; na 7870 SELinux permissive) | tak | tak (kopia przez `su -c cat`) | tak (kopia przez host, C6) |
| Okładka BT | tak (kod 51 + odczyt pliku; permissive) | tak | tak | tak, jeśli DAC pozwala |

### 3.2 Problem 2: logi (ten sam plik)

**`W Parcel: Expecting binder but got null!`**
- 258 wpisów, w launcherze 117, wszystkie na wątku grafiki 2748 (sąsiaduje z `mali_gralloc register/unregister`).
- Te same wpisy mają inne procesy: 4817 (67), 13816 Dabdream (37), 2396 (7) i inne.

**`E SurfaceSyncer: Failed to find sync for id=0`**
- 3813 wpisów: proces 4867 ma 3411, launcher 333 (wątek główny).

**Korelacja w launcherze:** oba ostrzeżenia idą 1:1 za przejęciem wyświetlacza przez nowy panel i za relayoutami okien `PipWindowHost:First/Second/Third`. W 15 minutach:
- 114× `WindowHostVdView: display N with <app> taken over from the previous pane, no fresh display`;
- około 46 „Pane rebuild starting”.

To ostrzeżenia frameworka Androida 13 (BLAST/SurfaceSyncer) przy tworzeniu powierzchni SurfaceView. Nie mają skutków funkcjonalnych.

**`avc: denied { getattr } … /odm/app/190000000_com.android.calculator2/…apk`**
- Proces `untrusted_app`, wątek `launcher-loader`; godziny 06:53:06.307 i 07:07:20.071.
- Przyczyna: `AppIconDiskCache.apkStamp()` (≈253–264) robi `File.length()` i `lastModified()` na `sourceDir` **każdej** aplikacji z aktywnością launchera. APK w `/odm/app` mają etykietę `vendor_file`.
- Przy SELinux permissive AVC loguje tylko pierwszą odmowę danego rodzaju. Kalkulator jest po prostu pierwszym takim APK.
- **Nie ma wywołania specyficznego dla kalkulatora.** Element `WS_CALCULATOR` (`Launcher` ≈6670) tylko uruchamia kalkulator po dotknięciu.

**APK com.syu.media otwierany na wątku głównym:**
- 36× `avc … open/read/map … 190000000_com.syu.media.apk` z wątku głównego.
- Za każdym razem tuż przed `START … cmp=com.syu.media/.MainAct` po dotknięciu widżetu.
- Sprawca: `LauncherMusicWidget.refreshLeftCycleForIntent()` (≈1396), `appInfo.loadLabel(pm)` na wątku głównym.

**Szum, bez działania:**
- `OnBackInvokedCallback is not enabled` ×38;
- `RemoteInputConnectionImpl … inactive InputConnection`;
- 06:56:25.554: aplikacja `dev.igor.fytcustomservice` (obca) startuje swoją aktywność po każdym powrocie do ekranu głównego. To daje dodatkowe onPause/onResume launchera i drugie okno „Pane rebuild”. Opisz w raporcie dla właściciela.

### 3.3 Problem 3: flavory dziś

Flavor rozróżnia w logice tylko trzy miejsca:
- manifest `app/src/fyt/AndroidManifest.xml`: `sharedUserId="android.uid.system"` i uprawnienia `permissionGroup SYSTEM_TOOLS`;
- `settings/VersionChecker.UPDATE_FILE_PREFIX = BuildConfig.FLAVOR + "_release_"` (≈42), `LEGACY_UPDATE_FILE_PREFIXES = {"update", "phone_release_"}` (≈45);
- `settings/SettingsFragmentFirst`: linia 2 sekcji wersji (`"fyt".equals(BuildConfig.FLAVOR)`, ≈544) oraz `updateShizukuDownload()` (`"standard".equals(…)`, ≈1547).

Wszystko inne idzie po **urządzeniu**:
- `FytPlatform`, `DeviceIdentity.isFyt()/is7870()/chipset()`, `LauncherApplication.isFytDevice()/showsFytOptions()/supportsPinnedPip()`;
- `StockSources.isSyuMediaUnit()`;

albo po **uprawnieniach**:
- `LauncherApplication.hasSystemPrivileges()` (≈771: `uid == 1000 || FLAG_SYSTEM`);
- `WindowHostVdClient` (root/Shizuku).

**Sekcja wersji:** `appVersion.setSummary(appType + "\n" + buildLine + "\n" + deviceLine)` (≈537–560).
- `appTypeText()` (≈1521) daje „System app” albo „User app, Root enabled / Shizuku …”.
- `buildLine` to „Release build · FYT version”.
- Przycisk `app_version_update` ma tytuł `@string/update_version_button` („Tap to download and update the app”). Debug ustawia `install_release_button` („… release version %1$s”).
- `update_version_button` jest w 52 plikach, legenda logów w 59.

**Zabezpieczenia, które już istnieją:**
- `com/syu/module/canbus/CanbusModuleGuard` łapie `RuntimeException` z `in()/out()/update()` modułów aut i loguje raz na klasę i metodę.
- `settings/CrashLogger` jest jedynym handlerem crashy. Zapisuje `crash_pid_<czas>.txt` (`LogFileName.CRASH_LABEL`) i kończy proces.

**Miejsca bez zabezpieczenia:**
- `com/syu/remote/Callback.Massage.refesh` woła `onRefresh` wszystkich listenerów na wątku głównym, bez try/catch i po żywej `ArrayList`. Wyjątek oznacza crash launchera. Listener, który usuwa się w trakcie, wywoła `ConcurrentModificationException`.
- `com/syu/module/UiNotifyEvent` (≈86–104): to samo. Listenery są wołane pod blokadą.
- `com/syu/module/main/ModuleCallbackMain`, case 174: sprawdza `intsOk(ints, 1)`, a czyta `ints[2]`. Wersja 7870 com.syu.canbus ma `ints != null && ints.length > 2` i `break`.
- `ModuleCallbackCanbusProxy.update`, case 1000–1002: `break` jest wewnątrz `if`, więc krótki payload przelatuje do następnego case.
- Framework FYT (`decompiled_FYT_jars/*/system.zip → framework/classes4/…/com/syu/ipc/`) ma własne `com.syu.ipc.*`. Przy ładowaniu rodzic-najpierw mogą one przesłonić kopie launchera. Różnica sygnatur na innej jednostce oznacza `LinkageError`.

**Zgrzyt w CI:** `.github/workflows/build.yml` ma nieaktualny akapit „[BRANCH-ONLY, NOT FOR MAIN] … ccr-087eed00-gbqsuz”.

### 3.4 Problem 4: PiP przy zmianie dzień/noc (zgłoszenie użytkownika)

„Apps in PIPs rerender themselves and sometimes restart when changing day/night mode (lights from car as a trigger).”

**Tryb nocny launchera to tylko tapeta i jasność.**
- Ścieżka: `CarStates` `U_LAMPLET` → `settings/HeadlightNightMode.onLightsReported` (≈58–73) → po 1500 ms `applyNow()` (≈92–108).
- `applyNow()` woła `DayNightBrightness.apply` i `NightModeService.startSunTaskForSavedLocation`.
- `SunTask` ustawia tapetę systemową: `setBitmap/setResource …FLAG_SYSTEM` (≈334, ≈386). Pomija to, gdy `alreadyApplied()` (≈408).
- Nic w `app/` ani `vdhost/` nie woła `UiModeManager`, `setNightMode`, `AppCompatDelegate.setDefaultNightMode`, `cmd uimode` ani `recreate()`.

**Tryb ciemny systemu przełącza ROM.**
- `docs/log-analysis-2026-10-26.md`: P2 (7870) pokazuje Launcher zniszczony 72 ms po `U_LAMPLET`, czyli przed reakcją launchera.
- Zmiana `uiMode` trafia do wszystkich wyświetlaczy, także do wirtualnych wyświetlaczy paneli.
- Aplikacja, która sama nie obsługuje `uiMode`, jest odtwarzana przez Androida. To jest poza kontrolą launchera.

**Launcher nie jest odtwarzany przez `uiMode`.**
- Manifest ma `configChanges="mcc|mnc|uiMode"` (≈135). `onConfigurationChanged` (≈4763–4781) loguje i odświeża paski.
- Gdy zmieni się bit, którego nie da się zadeklarować (`assetsPaths` przy nakładce motywu, np. Material You po zmianie tapety na Androidzie 12+), Launcher jest odtwarzany.
- `onDestroy()` (≈3045–3077) **bezwarunkowo** robi `WindowUtil.removePip()` i `mWindowHost.cleanup()`.
- Wyświetlacze mają `DESTROY_CONTENT_ON_REMOVAL`, więc aplikacje w panelach są niszczone i startują od nowa. To jest „restart” widziany przez użytkownika.

**Przekazanie wyświetlaczy już istnieje:**
- `WindowHostVdView.markDisplayDonor/takeDonorDisplay` (≈260–330);
- `WindowHost.retireActivityViews()` (≈104–115);
- `WindowHostAvReaper`.

Używa go `Launcher.initVariable()` (≈1956–1968), ale tylko gdy nowa instancja pojawi się przy żywej starej. W logu powrót do ekranu głównego zawsze kończy się „taken over from the previous pane”, więc mechanizm działa.

### 3.5 Problem 5: statystyki spalania (dlaczego model ruszył dopiero po readerze i uśpieniu)

**Reader** (`settings/CanbusCodeInspector`, usługa):
- Rejestruje wszystkie kody 0..1199 przez `DataCanbus.PROXY.register(rawCallback, code, 1)` (`registerCodes` ≈555–561).
- Zbiera GPS (`DeviceLocation.requestUpdates`). Zdarzenia zapisuje `record()` (≈205–235), z limitem 5000 na kod i 200 000 łącznie.
- Czas nagrania `code_inspector_timeout` wynosi domyślnie 300 s.
- Analiza i zapis są w jednym `writeDataToFile()` (≈274–474):
  - folder sprawdzany jest **przed** analizą (≈295–301): nieudany `mkdirs()` kończy metodę i `saveGuesses` się nie wykona;
  - potem `CanbusFrames.detect`, `CanbusCodeEstimator.estimate` (≈929–1047), `libraryCodesLine` (≈376), `saveGuesses` (≈389, ≈492–504 → `reader_guesses_<carId>`, `ReaderGuesses.of/over/serialize`).
- Prędkość jest zapisywana tylko przy wyniku ≥ 0,9 (korelacja z GPS).
- Reader nie zapisuje, czy przebieg się zaczął i czy się skończył. ACC off go nie zatrzymuje.

**`settings/CanbusService` czyta podpowiedzi readera tylko w `mNotifyCar` (≈482–513).** To działa tylko przy starcie usługi albo zmianie id auta.
- `saveGuesses` i zapis kodu w oknie „Canbus codes” (`SettingsFragmentSecond.saveCode` ≈2080–2086) tylko zapisują prefy.
- Działająca usługa zostaje z `speedCode = 0` aż do restartu usługi, launchera albo połączenia com.syu.ms. Uśpienie i wybudzenie właśnie to daje. **To główna przyczyna.**
- Wzorzec poprawki już istnieje: `CanbusService.carDataChanged()` (≈1331–1338).

**Przyczyny dodatkowe:**
- Sam GPS prawie nie uczy modelu. `FuelModel.learn()` (≈607) odrzuca próbkę bez przyspieszenia. `accel()` (≈957–987) wymaga ≥3 prędkości w 2 s rozpiętych na ≥0,8 s. Przy GPS 1 Hz zostaje około 1–4% próbek. `FuelModelTest` karmi tylko prędkością CAN 5 Hz.
- `onStartCommand` (≈275–290) robi wszystko wewnątrz `if (intent != null)`. Restart sticky z `null` niczego nie rejestruje.
- `requestLocationUpdates()` (≈1607–1626) prosi o uprawnienie raz w `onCreate`. Uprawnienie nadane później nie włącza GPS.

**Ruch i ACC:**
- Usługa dostaje GPS w `onLocation` (≈1706, co 500 ms, wątek główny). `DRIVING_KMH = 5.0` (≈175).
- Uśpienie i ACC off przychodzą do `settings/WakeDetection.onSleep` (≈412–475). Inne moduły podpinają się tam statycznym wywołaniem, jak `HeadlightNightMode.onSleep()`.
- „Odblokowane Fuel statistics” to przełącznik `user_stats` (`res/xml/creator_preferences.xml` ≈160–168). Usługa działa tylko przy `user_layout && user_stats`.

### 3.6 Problem 6: com.syu.canbus 7870 kontra obecny (7862/8581, `classes.dex.new`)

**Skrypt `canbus_library/build_canbus_library.py` pada na 7870** z błędem `no switch with class assignments`.
- Przyczyna: w `ActivityLauncher.launchCanbus()` 7870 zmienna nazywa się `cls2` (653 przypisania), a nie `cls`.
- Nazwy są wpisane na sztywno w `SwitchParser.parse_stmt` (≈264, `t.text in ('cls', 'name')`) i w `count_pairs` (≈474).
- Po poprawce reszta potoku działa na 7870: 5360 id, metoda `launchCanbus`, 3 ostrzeżenia.
- Nowy warunek `"6319".equals(platform)` (≈4168, ≈4497 w 7870) daje ostrzeżenie w `CondEval.parse_atom` (≈428).

**`--launcher` (`LAUNCHER_SOURCES` ≈1834):** nie zna 7870.
- `build_launcher` bierze rekord U tylko ze źródła właściciela.
- Z 7870 jako pierwszym źródłem 23 id Infiniti XinCheng (1573316…) traci `U code 109`. Przyczyna: konflikt etykiet `L/H` w `Infiniti_XinCheng_CarSet`.

**IPC jest identyczne:**
- `com.syu.ipc.*`, deskryptory i kody transakcji;
- `MsToolkitConnection`, moduły CANBUS=7, MAIN=0, SOUND=4;
- `DataCanbus`, `CallbackCanbusBase`, `UiNotifyEvent`.

Pakiet to nadal `com.syu.canbus`, a launcher rozmawia z `com.syu.ms` bezpośrednio.

**Różnice w kodzie 7870:**
- `FinalCanbus`:
  - 472 nowe stałe `CAR_*`, 5 usuniętych;
  - `CAR_XP1_GM_L` zmienia się z 26 na 2883610;
  - nowa stała `C_CHANGE_PANORAMA = 1003`.
- `HandlerCanbus.getCallbackCanbusById`:
  - usunięte callbacki protokołów 12, 26, 92, 253, 318 i id 131092;
  - 12 nowych klas `Callback_0456_*`;
  - wiele nowych gałęzi pod-id.
  - Launcherowi (673 klasy) brakuje 37 klas, które ma 7870.
- `ModuleCallbackMain` 174: poprawka zakresu (§3.3).
- `ConnectionCanbus` w 7870 i `new` rejestruje 1003 (`U_DRIVER_ON_RIGHT`). Launcher tego nie robi.

**Kody aut (7870 kontra new):**
- id z klasą: 5358 kontra 4899; 465 id jest tylko w 7870.
- Klasę zmieniają 4 wspólne id:
  - 12 i 129: `Psa301IndexActi` → `PsaOilMileIndexActi`;
  - 917798: `Rav4TripAct` → `Wc09LexusESIndexActi | Wc09LexusESEQActi | portrait`;
  - 3277173: `Rzc_ZiYouguang_Settings` → `Rzc_ZiYouguang_IndexAct`.
- R: wspólne identyczne, 39 nowych.
- S: 1413 wspólnych identycznych, 115 nowych, 2 usunięte.
- U: 168 identycznych, 23 utracone (skrypt).
- Prawdziwe zmiany `DATA[n]` w około 12 plikach, żaden nie jest stroną paliwa ani zasięgu.

**Biblioteka w launcherze** (`settings/CanbusLibrary`):
- asset `canbus_library.txt` (`ASSET_NAME` ≈1327) i nakładka `getFilesDir()/canbus_library_user.txt`; `loadBlocking()` zwraca `builtIn.mergedWith(overlay)`;
- import kumuluje (`CanbusLibraryImport.run` ≈224/238), `reset()` usuwa nakładkę, jest też eksport;
- **nie ma wyboru biblioteki po urządzeniu**, a plik nie ma pola platformy.

## C1 — `Build: the fyt flavor is now system`

### C1.1 Zmiany flavoru (zmieniasz)
1. `git mv app/src/fyt app/src/system`. Zawartość manifestu zostaje bez zmian.
2. `app/build.gradle.kts`:
   - `create("system") { dimension = "device"; isDefault = true }`.
   - Komentarz ma powiedzieć, czym jest ten flavor: aplikacja podpisana kluczem platformy z `sharedUserId=android.uid.system`. Instaluje się tylko tam, gdzie firmware ma ten sam klucz (testowy AOSP: jednostki FYT, niektóre ROM-y), na dowolnym urządzeniu.
   - Popraw komentarze `fyt -> fytRelease`, „the fyt build installs on FYT units only”, `standard runs the same code as fyt`.
3. `baselineProfile/build.gradle.kts`:
   - flavor `system`;
   - `finalizeDsl`: `findByName("system")`;
   - tekst ostrzeżenia „standard- or systemNonMinifiedRelease”;
   - komentarze.

   Poza tym:
   - komentarz w `baselineProfile/src/main/java/…/StartupBenchmark.kt`;
   - `baselineProfile/tools/prepare_device.sh`: `FLAVOR=System`, komunikaty „the system build”, polecenie `generateSystemReleaseBaselineProfile`;
   - `baselineProfile/README.md`.
4. `.github/workflows/build.yml`:
   - zadania `:app:testSystemDebugUnitTest` i `:app:assembleSystemDebug`;
   - artefakt `system-debug-apk` z `app/build/outputs/apk/system/debug/*.apk`;
   - usuń nieaktualny akapit „[BRANCH-ONLY …]”, bo budują się zawsze oba flavory.
5. `.github/workflows/release-assets.yml`:
   - źródło `system_release_${version}.apk`;
   - dodaje kopie `update${version}.apk` (wersje ≤1.2.1) **oraz `fyt_release_${version}.apk`**. Buildy testowe zrobione po zmianie „own file” i przed tym commitem szukają `fyt_release_`.
   - Czeka na plik `system_release_`. Popraw komentarze.
6. `settings/VersionChecker`:
   - prefiks zostaje `BuildConfig.FLAVOR + "_release_"`, więc teraz daje `system_release_`;
   - `LEGACY_UPDATE_FILE_PREFIXES = {"update", "phone_release_", "fyt_release_"}`, żeby `deleteInstalledUpdates()` sprzątał stare pobrania;
   - nowe `public static String updateFileName(String version)`, używane w URL-u (≈225, ≈263) i w przycisku;
   - popraw komentarze ≈35–40.
7. `settings/SettingsFragmentFirst` (decyzja 8):
   - `buildLine` to tylko typ buildu. Usuń użycie `build_flavor_*`.
   - Kolejność linii zostaje: najpierw `deviceLine + "\n" + buildLine`, potem `appType + "\n" + buildLine + "\n" + deviceLine`.
   - Release, w `onUpdateAvailable`: `appVersionUpdate.setTitle(getString(R.string.update_version_button_file, VersionChecker.updateFileName(latestVersion)))`.
   - Debug: `getString(R.string.install_release_button_file, latestVersion, VersionChecker.updateFileName(latestVersion))`.
   - Nowe stringi do 59 plików:
     - `update_version_button_file` = „Tap to download and update the app (%1$s)”;
     - `install_release_button_file` = „Tap to download and install release version %1$s (%2$s)”.
   - `update_version_button` zostaje jako tytuł domyślny w XML, bez placeholdera, bo przycisk jest ukryty do wyniku sprawdzenia.
   - Po `rg` usuń z wszystkich plików nieużywane `install_release_button`, `build_flavor_fyt` i `build_flavor_standard`.
8. Komentarze w kodzie, które mówią o **flavorze** (nie o jednostce FYT):
   - `LauncherApplication` ≈778, ≈857;
   - `PinnedPip` ≈6;
   - `settings/DayNightBrightness` ≈36;
   - `settings/SyuMusicLibrary` ≈35 („the FYT build, uid 1000” → „the system build”);
   - `settings/SettingsFragmentFirst` ≈1542;
   - `perf/BaselineProfileCompiler.kt` ≈55;
   - `com/syu/util/WindowUtil` ≈2534.

   Przejrzyj wynik `rg -n -i 'fyt (version|build|flavor)|fyt_release|fytRelease|fytDebug|"fyt".equals\(.*FLAVOR'`.
9. `CrashLogger` (≈108) wypisuje `flavor=` samo, teraz `system`/`standard`. Bez zmian.
10. README:
    - wszędzie, gdzie chodzi o flavor: „FYT version” → „system version”;
    - tabela „Supported devices”, „Versions and updates” (`system_release_` i kopie `update`/`fyt_release_`), tabela Baseline Profiles, instalacja („installs the system version”), „Generating app” (`systemRelease`/`standardRelease`);
    - przykład „Release build · FYT version” → nowy wygląd sekcji wersji i przycisk z nazwą pliku;
    - wyjaśnij, że wersja system to ta sama aplikacja na każdym ROM-ie z tym kluczem, FYT albo nie, a standard to wersja dla wszystkich pozostałych urządzeń, w tym jednostek FYT bez klucza.

### C1.2 Nazw NIE zmieniasz (to kod urządzeń FYT, nie flavoru)
- `FytPlatform` z `Chipset.FYT_*` i `UNKNOWN_FYT`. Do tego `DeviceIdentity.isFyt()/is7870()`, `LauncherApplication.isFytDevice()/showsFytOptions()/supportsPinnedPip()` oraz test `FytPlatformTest`.
- Źródło widżetu `"fyt"`:
  - `LauncherMusicWidget.mediaSource` (≈69, ≈196, ≈418, ≈1378, ≈1456, ≈1461) i `Launcher` ≈750;
  - `fyt/car/MusicService.SOURCE` i `MUSICSERVICE = "com.fyt.launcher.music"`;
  - `NotificationListener.kt` ≈1606 `source = "fyt"`;
  - `BtavService`, `VideoService`, `DvrService`.
- Pakiety `com.fyt.*` oraz `FytPackage`, `FytRating`, wątek `FytButtons`, akcja `com.fyt.systemui.remove`.
- Własności i ścieżki systemu: `ro.fyt.platform`, `ro.build.fytmanufacturer`, `ro.fyt.vdhost` (moduł Magisk), `/sys/fytver/fyt_bin_version`. Do tego tokeny `fytver:` w bibliotece CAN.
- Moduł „FYT VDHost” i nazwy `Keys`/prefów.
- Historyczne briefy w `docs/`. Nie edytuj ich.

Sprawdzenie: `rg -n 'BuildConfig\.FLAVOR'` po commicie może zwrócić tylko `VersionChecker`, `CrashLogger` i `updateShizukuDownload()`.

## C2 — `FYT code: a failure is reported, not a crash`

### C2.1 Polityka (czysta Java) — `settings/CompatReportPolicy.java`
- Klucz to `area` + klasa wyjątku + pierwsza ramka z `com.android.launcher66|com.syu|com.fyt`.
- Pierwsze wystąpienie klucza w procesie daje log `Log.e` ze stosem i raport do pliku. Kolejne wystąpienia tylko liczą.
- W procesie powstaje najwyżej 10 raportów. Potem jest już tylko licznik w logu, raz na 50 wystąpień.
- Po 5 wystąpieniach klucza `isDisabled(key)` zwraca true. Używaj tego tylko tam, gdzie pominięcie jest bezpieczne, np. listener kodu CAN.
- Test `CompatReportPolicyTest`.

### C2.2 `settings/FytCompat.java` i raport
- API:
  - `run(String area, Runnable r)`;
  - `<T> T call(String area, java.util.function.Supplier<T> s, T fallback)`;
  - `report(String area, Throwable t)`;
  - `isDisabled(String area)`.
- Łapie **tylko** `RuntimeException` i `LinkageError`. Nigdy `VirtualMachineError` (OOM, StackOverflow) ani innych `Error`.
- Raport zapisuje na własnym jednowątkowym executorze (demon). StrictMode na wątku głównym nie może zobaczyć dysku.
- `settings/CrashLogger`:
  - Wydziel wspólny zapis nagłówka i ogona logu.
  - Dodaj `static void writeNonFatal(Context, String area, Thread, Throwable, int occurrence)`.
  - Plik: `compat_pid_<dd-MM-yyyy_HH-mm-ss>.txt` (`LogFileName.COMPAT_LABEL = "compat"`).
  - Nagłówek `===== COMPAT <czas> pid=… thread=… area=… occurrence=N =====`, potem te same linie urządzenia i aplikacji co w raporcie crasha, stos i 300 ostatnich linii logu procesu.
  - Osobna rotacja: 20 plików `compat_*`. `deleteOldReports` liczy po etykiecie.
  - Nic tutaj nie może rzucić wyjątkiem.
- „Ostatni raport crasha” w ustawieniach nadal pokazuje tylko `crash_*`.

### C2.3 Gdzie założyć bezpiecznik (tylko na najbardziej zewnętrznym poziomie kodu FYT)
1. `com/syu/remote/Callback`:
   - `mLisenters` → `CopyOnWriteArrayList`;
   - każdy `onRefresh` w `try/catch (RuntimeException | LinkageError e)` → `FytCompat.report("ms.callback code " + code, e)`. Dopisz moduł, jeśli instancja go zna.
2. `com/syu/module/UiNotifyEvent`:
   - kopia listy pod blokadą, wywołania poza blokadą, każde osobno pod bezpiecznikiem (`"canbus.notify " + code`);
   - to samo dla synchronicznego wywołania w `addNotify(notify, 1)`.
3. `CanbusModuleGuard.failed()` dodatkowo woła `FytCompat.report("canbus.module " + class + "." + method, e)`. Jego log „raz na klasę” zostaje.
4. `ModuleCallbackCanbusProxy.update`: `break` za `if` w case 1000–1002, a całe ciało pod bezpiecznikiem.
5. `ModuleCallbackMain` case 174:
   - `ints != null && ints.length > 2` i `break`, jak w 7870;
   - ciała `update()` wszystkich `extends IModuleCallback.Stub` (znajdź przez `rg`) pod bezpiecznikiem.
6. Wątki, executory i posty, które istnieją tylko na FYT:
   - wątek `StockSourcesProbe`;
   - zadania `SyuMediaClient` na wątku `SyuMediaClient`;
   - `StockRadioSource` lookups: dziś łapią i logują, teraz dodatkowo `report`;
   - `UserTouches.startButtons` (wątek `FytButtons`);
   - `DataPack.init`;
   - zadania w tle `CanbusService` i `CanbusCodeInspector`;
   - `HeadlightNightMode.applyNow`;
   - listener ACC w `WakeSignals`.

   Szukaj: `rg -n 'new Thread\(|\.execute\(|\.post\(|postDelayed\(' app/src/main/java/com/fyt app/src/main/java/com/syu app/src/main/java/com/android/launcher66/settings/Canbus*`. Bramkuj to, co działa tylko pod `isFytDevice()` lub tylko przez `com.syu.*`.
7. Receivery akcji `com.syu.*` i `com.fyt.*` (manifest i `registerReceiver`): ciało `onReceive` pod bezpiecznikiem.
8. Istniejące `catch`, które tylko logują lub robią `printStackTrace`, w kodzie FYT:
   - `SkinActivityLifecycleCallbacks`;
   - KWAPI w `Launcher` ≈2029;
   - refleksja `PinnedPip` / `PinnedPipLaunch`;
   - „FYT's button events not available”.

   Zostaw zachowanie, ale zgłoś przez `FytCompat.report(area, e)`.

Nie owijaj kodu, który nie jest kodem FYT. Nie rozsiewaj try/catch w środku logiki.

### C2.4 Ustawienia i nazwy
- `logcat_names_info_summary` (59 plików): linia **pod** `crash – …`:
  - EN: `compat – written when code made for FYT units failed on this unit or Android version and was caught without a crash: the error and the last log lines`;
  - PL: `compat – zapisany, gdy kod dla jednostek FYT zawiódł na tej jednostce lub wersji Androida i został przechwycony bez awarii launchera: błąd i ostatnie linie logu`.
- `logcat_locations_info_summary`: „(crash_pid_…, compat_pid_…)”.
- `LogFileNameTest`: nazwa `compat_pid_…`.
- README, Debugging: raporty `compat_pid_…` w `Download/Launcher66_Logs`, kiedy powstają i że warto je dołączyć do zgłoszenia.

## C3 — `Logs: icon cache stamps from the package manager, framework warnings explained`

1. `AppIconDiskCache.apkStamp()` dla **cudzych** aplikacji:
   - zamiast `File.length()/lastModified()` użyj `PackageInfo.lastUpdateTime + ":" + getLongVersionCode()` (API <28: `versionCode`) `+ ":" + ai.sourceDir`;
   - wynik pamiętaj per pakiet na czas jednego ładowania (`ConcurrentHashMap`, czyszczona na starcie ładowania);
   - przy błędzie zwróć `null`, czyli brak cache, jak dziś przy nieczytelnym pliku;
   - własny APK launchera (`currentLauncherStamp()`) zostaje na pliku, bo to nasz plik;
   - `FORMAT` 1 → 2;
   - sprawdź wywołujących: `PackageManager` nie może trafić na wątek główny. Jeśli jakiś wywołujący jest na nim, potraktuj to jako brak trafienia.
2. Ostrzeżenia `Parcel` i `SurfaceSyncer` (§3.2):
   - **bez zmian w kodzie**, nie zmieniaj cyklu życia paneli;
   - dopisz „Troubleshooting” w `vdhost/README.md`: dwa zdania i liczby z §3.2;
   - w treści commita napisz, dlaczego to framework.
3. `LauncherMusicWidget.refreshLeftCycleForIntent()` (≈1396):
   - tytuł weź z listy aplikacji launchera (`AppInfo` / `IconCache`, użyj istniejącego API);
   - gdy go tam nie ma, `loadLabel` w tle i `post` na główny;
   - kolejność i wynik `refreshLeftCycle` bez zmian.

## C4 — `Canbus: a library and callbacks of its own for the 7870`

### C4.1 Skrypt `canbus_library/build_canbus_library.py`
1. Zastąp nazwy na sztywno w `parse_stmt` (≈264) i `count_pairs` (≈474):
   - `CLASS_VAR_RE = re.compile(r'(?:cls|name)\d*')` (JADX: `cls`, `cls2`, …);
   - lepiej: zbierz nazwy z deklaracji `Class<?> X` metody i użyj tego zbioru.
2. `CondEval.parse_atom` (≈428): `"<cyfry>".equals(platform)` i `platform.equals("<cyfry>")` dają false, bez ostrzeżenia. Komentarz: format nie ma warunku platformy, a 7870 zgłasza 6318.
3. `--launcher`:
   - nowa opcja `--platform default|7870`;
   - `default` zostaje jak dziś (`LAUNCHER_SOURCES` ≈1834);
   - `7870` to źródła w kolejności `classes.dex.7870`, `classes.dex.new`, `classes.dex`, `decompiled_carinfo`;
   - wynik zapisuje się do `canbus_library_7870.txt`.
4. `build_launcher`: gdy źródło właściciela nie daje rekordu U (konflikt), weź U z następnego źródła. To odzyskuje 23 id Infiniti.
5. Nagłówek informacyjny `# Platform: 7870` / `# Platform: default`. To komentarz, więc parser go pomija.
6. Wygeneruj ponownie domyślny asset:
   - musi być identyczny poza komentarzami;
   - jeśli nie jest, opisz każdą różnicę w commicie.
7. `canbus_library/README.md` i `.bat`: jak zbudować bibliotekę dla 7870. Bibliotekę zbudowaną z własnego com.syu.canbus importuje się na tej samej jednostce.

### C4.2 Asset i wybór biblioteki
1. Wygeneruj i dodaj `app/src/main/assets/canbus_library_7870.txt`. Sprawdź nagłówek, `end <n> <crc>` i parsowanie całości.
   - Spodziewane liczby: około 5358 id z klasą, R 664, S 1528, U około 191 po poprawce.
   - Wpisz liczby do commita.
2. `settings/CanbusLibrary`:
   - `assetName()` = `DeviceIdentity.is7870() ? "canbus_library_7870.txt" : "canbus_library.txt"`;
   - nakładka `canbus_library_user_7870.txt` / `canbus_library_user.txt`;
   - `CanbusLibraryImport` (import, reset), `CanbusLibraryExport` (nazwa z platformą) i `loadBlocking()` pracują na aktywnej parze;
   - raport importu mówi, którą bibliotekę zaktualizowano;
   - `DeviceIdentity` czyta tylko własności, więc to nie jest dysk.
3. `CanbusLibraryTest`: parsowanie obu assetów, jeśli test czyta asset.

### C4.3 Ścieżka callbacków 7870
1. Porównaj `decompiled_com.syu.canbus/classes.dex.7870/sources/com/syu/module/canbus/HandlerCanbus.java` z `classes.dex.new/…` i z launcherowym `com/syu/module/canbus/HandlerCanbus.java`. Zobacz, jak launcher adaptował oryginał.
2. Nowa klasa `com/syu/module/canbus/HandlerCanbus7870`:
   - mapa `getCallbackCanbusById` z wersji 7870, z adaptacjami launchera;
   - id, które w `FinalCanbus` mają inną wartość (np. `CAR_XP1_GM_L`), wpisz jako literały z komentarzem;
   - `HandlerCanbus.canbusId` wybiera ją, gdy `DeviceIdentity.is7870()`. W pozostałych przypadkach działa jak dziś.
3. Przenieś brakujące klasy `Callback_*` (dokładna lista z różnicy, około 37, w tym 12 `Callback_0456_*`) do `com/syu/module/canbus/`:
   - wzorzec adaptacji weź z istniejącej pary, np. `Callback_0080_RZC_XP1_QiJun` w launcherze kontra oryginał;
   - klasa, która się nie kompiluje bez dużych zmian: pomiń ją, zmapuj na `Callback_0000_null` i wypisz w raporcie.
4. `FinalCanbus`: dodawaj tylko stałe używane przez przeniesiony kod. **Istniejących wartości nie zmieniaj.**
5. Rejestracja 1003 (`U_DRIVER_ON_RIGHT`) tylko na ścieżce 7870 (`ConnectionCanbus`). W raporcie zarekomenduj to samo dla ścieżki domyślnej, bo robią to obie aplikacje FYT (new i 7870).
6. README, sekcja Fuel statistics:
   - są dwie biblioteki i launcher wybiera je sam;
   - import trafia do biblioteki tej jednostki;
   - budowanie dla 7870.

## C5 — `Fuel statistics: reader codes reach the service, automatic code check while driving`

### C5.1 Naprawy przyczyny (§3.5)
1. `CanbusService.readerGuessesChanged()`, na wzór `carDataChanged()`:
   - `post` na główny, ponowny wybór kodów prędkości, RPM i spalania (część `mNotifyCar`) i `registerStatsCodes()`;
   - wołaj po `saveGuesses` readera, po `SettingsFragmentSecond.saveCode` i po diagnostyce automatycznej.
2. `onStartCommand` z `intent == null`: zarejestruj kody z prefów, tak samo jak z intentem.
3. GPS: gdy uprawnienie pojawi się później, `requestLocationUpdates()` próbuje ponownie (przy `onStartCommand` i przy wznowieniu launchera, jeśli GPS nie działa). Usługa nie prosi o uprawnienie ponownie.
4. `CanbusCodeInspector.writeDataToFile()`:
   - wydziel analizę do `settings/CanbusAnalysis` (seria, `CanbusFrames.detect`, `CanbusCodeEstimator.estimate`, `libraryCodesLine` dla par biblioteki);
   - `saveGuesses` wykonuje się **przed** sprawdzeniem folderu;
   - plik readera pozostaje bajtowo taki sam jak dziś.
5. `FuelModel.accel()` dla prędkości z GPS (flaga źródła już jest w `onSpeed(…, fromCan)`): okno 4 s, wystarczą 2 pomiary rozpięte na ≥1,5 s.
   - Prędkość CAN bez zmian.
   - Nowy test w `FuelModelTest`: jazda z GPS 1 Hz kalibruje się w tych samych granicach czasu co CAN.

### C5.2 Diagnostyka automatyczna (`settings/CanbusAutoCheck` w procesie `CanbusService`)

**Stan (czysta klasa `CanbusAutoCheckPolicy` z testem):**
- per auto, `Keys.CANBUS_AUTO_CHECK_PREFIX + carId`, w formacie `state;startedAtWallMs;attempts;finishedAtWallMs`;
- stany: `NONE` (brak klucza), `RUNNING`, `DONE`, `INTERRUPTED`, `FAILED`;
- `RUNNING` przy starcie usługi oznacza, że proces zginął w trakcie, czyli nieukończony.

**Warunki:**
- `isFytDevice()`, `user_layout && user_stats`, `carId > 0`;
- reader ręczny nie działa (`Helpers.codeInspectorBoolean()`);
- stan ≠ `DONE`;
- jest uprawnienie GPS. Bez niego raz `Log.i` i nic.

**Start:**
- Pierwszy fix GPS > 5 km/h w `onLocation` planuje start za 120 s.
- W chwili startu prędkość GPS > 5 km/h musiała wystąpić w ostatnich 30 s. Jeśli nie, anuluj i czekaj na następny ruch.

**Nagranie:**
- tak samo jak reader: wspólna klasa `settings/CanbusRecorder` wydzielona z `CanbusCodeInspector` (`registerCodes`, `record`, limity, `unregisterCodesInBatches`), plus prośba biblioteki `CanbusLibrary.sendForCar`;
- fixy GPS z `CanbusService.onLocation`;
- czas z ustawienia readera `code_inspector_timeout` (domyślnie 300 s);
- rejestracja i wyrejestrowanie w tle, nie na wątku głównym.

**Przerwanie:**
- uśpienie lub ACC off (statyczny hak `CanbusService.onSleep()` w `WakeDetection.onSleep`), `onDestroy` usługi, zmiana id auta, start readera ręcznego;
- skutek: `INTERRUPTED`, wyrejestrowanie, dane odrzucone.

**Koniec:**
- `CanbusAnalysis` w tle;
- `ReaderGuesses.of(result, now).over(stare)` → `reader_guesses_<carId>`, ten sam klucz, więc okno „Canbus codes” pokaże podpowiedzi;
- nowy `auto_codes_<carId>`: kandydaci paliwa i zasięgu oraz flaga „kod biblioteki milczał”, z `libraryCodesLine`;
- `DONE` tylko przy ≥120 s jazdy i ≥60 fixach. W innym przypadku `FAILED`, czyli ponowienie przy następnej jeździe;
- potem `readerGuessesChanged()`;
- jedna linia `Log.i("CanbusAutoCheck", "done car=… speed=… rpm=… fuel=… range=… librarySilent=… notFound=[…]")`. Bez pliku i bez Toastu.

**Użycie kandydatów (decyzja 11)** w `CanbusService`:
- spalanie i zasięg: kod użytkownika → para biblioteki, która daje dane (`CodePairChooser`) → kandydat `auto_codes`, gdy biblioteka nie ma pary albo flaga mówi „milczała”;
- prędkość i RPM: jak dziś (użytkownik → podpowiedź readera lub diagnostyki);
- loguj różnicę kandydat ≠ biblioteka.

## C6 — `VD host: protocol 3 with optional calls, older hosts keep the panes`

1. `vdhost/shared/…/VdHostProtocol`: `VERSION = 3`, nowe `MIN_VERSION = 2`.
2. Nowe transakcje (implementacja w `HostServices`, sprawdzanie uid jak w `allowWriteSettings`, `VdHostCore.isPackageOfUid`):
   - `TX_READ_FILE(path)`:
     - zwraca `ParcelFileDescriptor` do odczytu;
     - tylko zwykły plik ≤2 MB, ścieżka kanoniczna (bez dowiązań) z białej listy: pliki obrazów w `/data/blink/` (ścieżka z kodu 51, §3.1), `/storage/emulated/0/radio_logo/`, `/odm/app/cabinet.data` (paczka ikon radia online);
     - samą białą listę zrób w czystej klasie `HostFilePolicy` z testem.
   - `TX_ALLOW_APP_OP(pkg, op)`: `op ∈ {SYSTEM_ALERT_WINDOW, REQUEST_INSTALL_PACKAGES, WRITE_SETTINGS}` → `cmd appops set <pkg> <op> allow`.
   - `TX_ALLOW_NOTIFICATION_LISTENER(component)`: komponent pakietu wywołującego → `cmd notification allow_listener <component>`. Przy błędzie zwraca raport.
3. `com/syu/util/WindowHostVdClient` (≈300–308):
   - akceptuje host `MIN_VERSION ≤ v ≤ VERSION`;
   - starszy host loguje raz: „VD host protocol 2: file reads and permission grants need the module update”;
   - API `hostVersion()` i `supportsOptionalCalls()`;
   - nowych transakcji nie woła na hoście v2. Host v2 odpowiada na nieznaną transakcję pustą odpowiedzią.
4. Podbij `moduleVersion` i `moduleVersionCode` w `vdhost/server/build.gradle.kts`.
5. `vdhost/README.md`: tabela „Other errands”, zgodność wersji (stary moduł działa dalej dla paneli).
6. Jeśli przejdzie, dodaj do CI krok `bash ./gradlew :vdhost-server:magiskZip --stacktrace`. Jeśli wymaga czegoś, czego CI nie ma, pomiń i opisz w raporcie.
7. Testy: `HostFilePolicyTest` i test akceptacji wersji (czysta funkcja).

## C7 — `Music widget: covers of com.syu.media's online radio, FM and BT`

Klasy i linie com.syu.media podane w §3.1 pochodzą z dekompilacji. Przed kodowaniem sprawdź je w `decompiled_com.syu.media/`, a różnice opisz w raporcie.

### C7.1 Odczyt plików z łańcuchem uprawnień: `com/fyt/car/SyuMediaFiles.java` (tylko w tle)

Kolejne próby:
1. Bezpośredni `FileInputStream`. Na 7870 SELinux jest permissive, a com.syu.media (zwykły uid) sama czyta te pliki, więc to zadziała w każdym flavorze.
2. Aplikacja systemowa: ten sam odczyt jako uid 1000. Osobnego kroku nie ma, ale zaloguj uid.
3. Root: `su -c cat <path>` (strumień binarny, limit 2 MB, timeout 3 s), tylko gdy `WindowHostVdClient.hasRoot()`.
4. Shizuku albo demon: `TX_READ_FILE` (C6), gdy `supportsOptionalCalls()`.

Zasady:
- Zapamiętaj per rodzina ścieżek, co zadziałało, żeby nie pytać `su` przy każdej okładce.
- Ścieżki tylko z białej listy C6:
  - plik ze ścieżki kodu 51 w `/data/blink/`;
  - `/storage/emulated/0/radio_logo/`;
  - `/odm/app/cabinet.data`.
- Log raz na rodzinę: `SyuMediaFiles: <family> via <direct|system|root|shizuku|daemon> -> ok|fail`.
- Plik paczki zasobów, którego nie da się otworzyć bezpośrednio, kopiuj do `getCacheDir()/stock_res/cabinet.apk`. Odśwież kopię, gdy zmieni się rozmiar lub czas modyfikacji źródła.

### C7.2 Radio online
1. `SyuMediaClient.Song.read()`:
   - po `type` czytaj `country`, `local`, `freqTitle` i `icon`, w kolejności z `RadioSource.writeToParcel`;
   - przed każdym polem sprawdź `dataAvail()`;
   - `State` dostaje `icon`.
2. `com/fyt/car/StockCoverLoader` (executor w tle, cache w pamięci per nazwa ikony):
   - `PackageInfo pi = pm.getPackageArchiveInfo("/odm/app/cabinet.data", 0)`, potem `pi.applicationInfo.sourceDir = publicSourceDir = <ścieżka albo kopia>` i `Resources r = pm.getResourcesForApplication(pi.applicationInfo)`. To publiczne API; **nie** używaj ukrytego `AssetManager.addAssetPath`, którego używa com.syu.media;
   - zasób: `r.getIdentifier(<icon bez rozszerzenia>, "drawable", pi.packageName)`;
   - dekoduj z `inSampleSize` do ≤512 px; bajty PNG trafiają do `StockTrack.cover`;
   - `Resources` paczki trzymaj raz na proces. Gdy plik się zmieni (rozmiar lub czas modyfikacji), wczytaj je ponownie;
   - `icon` pusty albo nieznany daje okładkę domyślną widżetu;
   - log raz na stację: `StockCovers: online '<title>' icon=<name> -> ok|missing (via …)`.
3. `MusicService.applySyuMedia` (≈287) przekazuje `cover` do `StockTrack`. Okładka dochodzi później jako nowy `State`, więc tik co sekundę na nią nie czeka.

### C7.3 FM
1. `StockRadioSource.requestLookup()` (≈204): zdejmij wyłączenie dla jednostki com.syu.media i popraw komentarz.
2. Na 7870, w tej kolejności:
   - a) `content://com.syu.radio/local_assert` (`freq`, `cover_path`, `title`; `freq` w tych samych jednostkach co `StockRadioSource.freq`):
     - bez uprawnień, jeśli provider jest eksportowany;
     - `SecurityException` → jeden log i krok b);
   - b) skan `/storage/emulated/0/radio_logo` istniejącym `lookup()`. Schemat `<Nazwa>_<freq>.png` jest taki sam jak w com.syu.radio. Dopilnuj reguł `RadioIconCache`: dokładnie 2 części, kropka usuwana, `90.40` → 9040;
   - c) `cover_path` stacji z `city_station` (odczyt z C8.2), jeśli jest niepusty.
3. `title` z `local_assert` lub z nazwy pliku jest nazwą stacji, gdy brak RDS PS (tak jak dziś na 7862).
4. Bez logo:
   - obrazek `radio1`–`radio3` z zasobów com.syu.media: `pm.getResourcesForApplication("com.syu.media")`, `getIdentifier("radio" + (1 + freq % 3), "drawable", "com.syu.media")`;
   - wybór ma być stały dla częstotliwości, nie losowy jak w aplikacji;
   - brak zasobu daje okładkę domyślną widżetu.
5. Ścieżka 7862 (com.syu.radio, `fmbd`) zostaje bez zmian.

### C7.4 BT (tylko jednostka com.syu.media)
1. `StockBtSource.start()`: zarejestruj też **kod 51** modułu 2. `iconPath = firstString(strs)`; pusty oznacza brak okładki.
2. Plik ze ścieżki czytaj przez `SyuMediaFiles`:
   - od razu po kodzie 51 z niepustą ścieżką;
   - 1,5 s po zmianie tytułu, jak `BluetoothObserver`;
   - jeśli plik się jeszcze nie zmienił, ponownie po 3 i 6 s.
3. Plik przyjmij tylko, gdy `lastModified ≥ czas zmiany utworu − 2 s`. `blink` nadpisuje jeden plik, więc starszy to okładka poprzedniego utworu.
4. Przy zmianie utworu okładkę wyczyść. Telefon bez okładki daje okładkę domyślną. Serce BT zostaje szare.
5. Widżet: sprawdź, że `StockTrack.cover` jest rysowany dla `MEDIA_ONLINE`, `RADIO` i `MEDIA_BT`. Dla `RADIO` działa to już dziś.

### C7.5 Testy (czysta Java, `app/src/test/java/com/fyt/car/`)
- Parser nazwy logo zgodny z `RadioIconCache` (`<Nazwa>_<freq>.png`, dokładnie 2 części, kropka usuwana).
- Reguła świeżości okładki BT.
- Wybór `radio1..3` po częstotliwości.
- Odczyt pól `RadioSource`, jeśli da się go wydzielić z `Parcel` do czystej funkcji. Jeśli nie, pomiń.

## C8 — `Music widget: com.syu.media favorites, FM read-only, a note on the app's screen`

### C8.1 Muzyka USB i radio online (decyzja 3)
1. Zapis z widżetu zostaje jak dziś: `SyuMediaClient.writeFavorite`, provider, `_id=? AND path=?`, potem odczyt zwrotny.
   - To jedyna droga, która nie przerywa odtwarzania. com.syu.media nie ma API ulubionych, a jej provider omija Room (§3.1, punkty 1–3).
   - **Nie** dodawaj `notifyChange`, bo nikt go nie słucha.
   - **Nie** wołaj `playListWithId` ani `playWithId`, bo restartują utwór.
   - **Nie** restartuj aplikacji.
2. Po pierwszym udanym zapisie w procesie pokaż krótki Toast na wątku głównym, raz na proces (statyczna flaga). Nowy string `syu_media_favorite_note` dodaj do 59 plików:
   - EN: „Saved. The media app shows the heart after it reloads its library (e.g. after a restart).”;
   - PL: „Zapisano. Aplikacja multimedialna pokaże serce po przeładowaniu biblioteki (np. po ponownym uruchomieniu).”
3. Bez nowej opcji w ustawieniach. com.syu.media zostaje ukryte na liście „Select the music apps that should use the favorite cache” (`MediaFavoriteController.isFavoriteCacheBlockedByAccount`). Sprawdź, że nadal tak jest.
4. Log w `writeFavorite` uzupełnij o id: `favorite <kind> id=<id> =<b> written to <n> row(s)`.
5. README, sekcja Music widget: serce z widżetu com.syu.media pokazuje dopiero po przeładowaniu biblioteki.

### C8.2 FM: tylko odczyt (decyzja 4)
1. Nowa klasa `com/fyt/car/SyuMediaRadioFavorites` (praca w tle).
   - Zapytanie:
     - `content://com.syu.radio/city_station`, projekcja `favorite, cover_path, title`;
     - selekcja `freq=? AND favorite=1`, `selectionArgs` zawsze podane;
     - miasta nie znamy, bo jego wybór siedzi w prywatnych prefach com.syu.media. Ulubiony wiersz tej częstotliwości w dowolnym mieście liczy się jako ulubiony.
   - Kolejność dróg:
     1. bez uprawnień (provider eksportowany);
     2. aplikacja systemowa: ten sam odczyt (uid 1000 czyta też nieeksportowany);
     3. root: `su -c content query --uri content://com.syu.radio/city_station --projection freq:favorite:cover_path:title --sort "favorite DESC"`.
        - Bez `--where`, bo provider rzuca NPE przy selekcji bez argumentów.
        - Czytaj wiersze `Row: …`, dopóki `favorite=1`, potem zakończ proces.
        - Wynik trzymaj 60 s.
     4. Shizuku: niemożliwe, gdy provider nie jest eksportowany (shell). Zaloguj raz.
   - Kiedy czytać: przy zmianie stacji, co około 5 s, gdy radio jest pokazane, i przy powrocie launchera na wierzch. Wynik trzymaj w pamięci per częstotliwość.
2. `StockRadioSource.buildTrack()` na jednostce com.syu.media ustawia `favorite` na wynik odczytu albo na `null`, gdy stan jest nieznany.
3. `MediaFavoriteController`:
   - `isStockFavoriteAvailable()` i `getStockFavoriteState()`: dla nakładki `RADIO` na jednostce com.syu.media pokaż stan (pełne lub puste), gdy jest znany. Użyj istniejącego wyglądu nieaktywnego przycisku, z wypełnieniem według stanu, bez nowych grafik;
   - `toggleStockFavorite()`: dla FM nic nie zmienia. Log raz na proces: `Press ignored: com.syu.media's FM favorites are read-only`;
   - BT zostaje szare. com.syu.music bez zmian (`git diff` nie dotyka `SyuMusicLibrary`).
4. Test czystej funkcji, która parsuje wynik `content query`.

## C9 — `Standard version: overlay, notification access and unknown apps through root or Shizuku`

1. `LauncherPermissionFlow`:
   - kroki `OVERLAY`, `NOTIFICATION_ACCESS` i `INSTALL_PACKAGES`: przy hoście z `supportsOptionalCalls()`, gdy launcher nie jest systemowy, najpierw host (wzór: `writeSettingsAwaitsHost` / `allowWriteSettingsThroughHost` ≈100–215);
   - potem ponowne sprawdzenie uprawnienia;
   - dopiero przy porażce ekran ustawień, jak dziś;
   - wywołania hosta tylko w tle.
2. Tego nie rób (opisz w raporcie dlaczego):
   - obszar przesuwania na pasku stanu: potrzebny jest typ okna systemowego w procesie launchera;
   - monitor wejścia `UserTouches`: wymagałby monitora po stronie hosta i przekazywania zdarzeń;
   - skórki FYT w wersji standard: da się bez uprawnień, instalując fabrykę przed AppCompat, ale z ryzykiem dla inflacji AppCompat. To osobny brief;
   - `HomeFrontGuard.isPackageRunning` i kontrola zadań Spotify przez host: mała wartość.
3. README: co wersja standard dostaje z rootem lub Shizuku.

## C10 — `PiP: panes survive a recreated launcher, day/night diagnostics`

1. `Launcher.onDestroy()` przy `isChangingConfigurations()`:
   - **przekaż panele**: `mWindowHost.retireActivityViews()` (wyświetlacze jako dawcy);
   - zwolnienie wyświetlaczy w `removePip()` i `cleanup()` pomiń. Sprawdź, co dokładnie robi `WindowUtil.removePip()`: okna paneli muszą zniknąć, wyświetlacze zostać;
   - nowa instancja przejmuje je przez istniejące `takeDonorDisplay`. Dopilnuj, żeby `initVariable()` znalazła wycofany host także po `onDestroy` starej, np. przez statyczny uchwyt z czasem;
   - bez przejęcia w 10 s wyświetlacze zwalnia `WindowHostAvReaper`;
   - zwykłe zniszczenie (bez zmiany konfiguracji) działa jak dziś.
2. `onConfigurationChanged`: jedna linia ze wszystkimi zmienionymi bitami (`ConfigChanges`). Przy `assetsPaths` dopisz „theme overlay”.
3. `SunTask`: tapetę ustawiaj tylko przy rzeczywistej zmianie (`alreadyApplied()`); log „wallpaper unchanged, not set”. Nadmiarowa zmiana tapety może na Androidzie 12+ uruchomić przemalowanie motywu (Material You).
4. README, Night mode:
   - tryb nocny launchera zmienia tapetę i jasność, nie tryb ciemny systemu;
   - jeśli ROM przełącza tryb ciemny ze światłami, aplikacje w PiP przerysowują się (a te, które tego nie obsługują, startują od nowa) dokładnie jak na ekranie głównym. Decyduje o tym opcja ROM-u.
5. **Nie** przypinaj wirtualnym wyświetlaczom paneli trybu dzień/noc. To pomysł na osobny brief (§7).

## C11 — `Docs: README and briefs consistent`
Rób go tylko wtedy, gdy po C1–C10 w README zostały niespójności.

## 4. Czego NIE zmieniać
- **Ścieżka com.syu.music i com.syu.radio na 7862/8581**: `SyuMusicLibrary`, `MusicService.onStartCommand`, gałęzie com.syu.music w `MediaFavoriteController`, lookups com.syu.radio. Wyjątek: włączenie `radio_logo` także na 7870.
- **Cykl życia paneli przy wyjściu i powrocie do ekranu głównego** (`removePip`, przebudowa, przejęcie). Wyjątek: odtworzenie przez zmianę konfiguracji w C10.
- **Nazwy z C1.2**, historyczne `docs/` oraz istniejące wartości `FinalCanbus`.
- **com.syu.media**: żadnego force-stop, kill ani zapisu jej prywatnej bazy.
- **Domyślna biblioteka CAN**: bez zmian treści. Wyjątek: ponowne wygenerowanie skryptem, z opisem różnic.
- **Ostrzeżenia `Parcel` i `SurfaceSyncer`**: nie zmieniaj kodu w ich sprawie (C3).

## 5. Weryfikacja
1. Po każdym commicie CI jest zielone, a nowe testy przechodzą.
2. Sprawdzenia `rg` (`--glob '!docs/**' --glob '!**/generated/**'`):
   - `BuildConfig.FLAVOR` → tylko `VersionChecker`, `CrashLogger`, `updateShizukuDownload`;
   - `fytRelease|fytDebug|testFyt|assembleFyt|app/src/fyt` → zero;
   - `"fyt"` jako źródło widżetu → nadal jest (C1.2);
   - `build_flavor_` → zero;
   - `apkStamp` w `AppIconDiskCache` → brak `new File(ai.sourceDir)` dla cudzych pakietów.
3. Scenariusze dla właściciela (7862, Android 10, wersja system). Wypisz je w raporcie:
   - a) Ustawienia, wersja: „System app”, „Release build”, linia urządzenia. Przycisk aktualizacji z „(system_release_X.apk)”.
   - b) Jazda z włączonymi Fuel statistics:
     - 2 min po ruszeniu `CanbusAutoCheck: started`, po około 5 min `done …`;
     - estymata bez restartu (`readerGuessesChanged`);
     - ACC off w trakcie daje `interrupted`; następna jazda zaczyna test od nowa;
     - po `done` test nie startuje ponownie.
   - c) Światła mijania wł./wył.: w logu brak `onDestroy … isChangingConfigurations=true`, a jeśli się pojawi, to `panes handed over`.
   - d) Brak plików `compat_pid_` w normalnej pracy.
4. Scenariusze dla testera 7870 (standard + Shizuku). Wypisz je po angielsku, w stylu instrukcji testera:
   - a) Pliki USB:
     - serce w widżecie zmienia się od razu i zostaje;
     - przy pierwszym naciśnięciu pojawia się komunikat;
     - com.syu.media pokazuje zmianę po ponownym uruchomieniu albo po dowolnym sercu naciśniętym w niej;
     - serce zmienione w aplikacji trafia do widżetu w ciągu ≤5 s.
   - b) Radio online: okładka stacji taka jak w aplikacji; serca jak w a).
   - c) FM:
     - logo z `radio_logo`, jeśli jest, a w innym razie obrazek radia jak w aplikacji;
     - serce pokazuje stan z aplikacji;
     - naciśnięcie w widżecie nic nie zmienia.
   - d) BT: okładka telefonu 1,5–6 s po zmianie utworu. Log pokazuje kod 51 i odczyt pliku.
   - e) Klasa w „Fuel statistics” pochodzi z biblioteki 7870. Import trafia do biblioteki 7870.
   - f) W logu nie ma `avc … getattr … /odm/app/…apk` z `launcher-loader`. Ostrzeżenia `SurfaceSyncer`/`Parcel` mogą zostać (framework).
   - g) W logu jest jedna linia mówiąca, czy provider `com.syu.radio` jest eksportowany (decyduje o drodze dla FM).

## 6. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash i temat) z wynikiem CI każdego.
- Potwierdzenie faktów z §3.1 w kodzie com.syu.media albo różnice. Dla każdej operacji (serce muzyki, online, FM; okładki): droga i to, co działa przez system, root i Shizuku (tabela z §3.1 po sprawdzeniu).
- **Czego nie da się zrobić przez Shizuku** (potwierdzone w kodzie).
- Lista przeniesionych i pominiętych klas `Callback_*` oraz liczby z biblioteki 7870.
- Każde odstępstwo od instrukcji i jego powód.
- Działania właściciela:
  - nowy moduł Magisk (protokół 3; stary działa dalej dla paneli);
  - nazwy plików w `installer.zip` (poza repo) przy przejściu na `system_release_`;
  - informacja o `dev.igor.fytcustomservice` dla testera;
  - rekomendacja 1003 dla ścieżki domyślnej;
  - scenariusze z §5.

## 7. Pomysł na osobny brief (nie implementuj w tej rundzie)

Wirtualnym wyświetlaczom PiP można przypiąć bieżący tryb dzień/noc. Aplikacje w PiP przestałyby się wtedy restartować, ale zostawałyby w motywie z chwili otwarcia.

Punkt wyjścia dla tamtego briefu (do sprawdzenia):
- **Mechanizm:** nadpisanie konfiguracji (`uiMode`) samego wirtualnego wyświetlacza panelu, np. ukrytym `IActivityTaskManager.updateDisplayOverrideConfiguration(Configuration, displayId)` (Android 8–9: `IActivityManager`). Zmiana trybu ciemnego systemu nie zmienia wtedy konfiguracji tego wyświetlacza, więc Android nie odtwarza aplikacji w panelu.
- **Uprawnienie `CHANGE_CONFIGURATION`:** ma je wersja system i demon modułu Magisk (uid 1000). Dla Shizuku (shell) trzeba to sprawdzić.
- **Kompromis:** aplikacja w panelu zostaje w motywie z chwili otwarcia. Czy i kiedy dopasować ją do bieżącego trybu (np. przy przebudowie panelu), decyduje właściciel.
