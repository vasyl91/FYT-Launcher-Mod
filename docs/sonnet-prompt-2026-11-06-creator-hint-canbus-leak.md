# Launcher Mod: strzałki kreatora, napis o podwójnym tapnięciu, przeciek callbacków canbus — instrukcja wykonawcza

Repozytorium: `vasyl91/FYT-Launcher-Mod`.
- **Pracujesz wyłącznie na istniejącej gałęzi `testBranch`.** Nie twórz nowej gałęzi i nie przełączaj się na inną.
- Zacznij od `git pull origin testBranch`.
- **Nie twórz pull requesta.**

Numery linii to stan z `11e70c29`. Są orientacyjne (≈): zawsze sprawdzaj je w kodzie.

Ścieżki bez prefiksu są względem `app/src/main/java/com/android/launcher66/`, a `settings/` to `…/launcher66/settings/`.

Przyczyny poniżej są już znalezione i potwierdzone. Naprawiasz dokładnie je.

## 0. Kolejność commitów i jej powód

| # | Temat commita | Źródło | Dlaczego tutaj |
|---|---|---|---|
| C1 | `Creator: a size set with the arrows is kept when the home screen fits the layout` | §2.2, Bug 1 | Utrata danych użytkownika. Mały. |
| C2 | `Creator: the double tap hint only where a double tap hides the bar` | §2.3, Bug 2 | Niezależny. |
| C3 | `Canbus: the binder callbacks no longer keep the reader, its recording or the service alive` | §2.4, LeakCanary | Niezależny. |

**Każdy commit buduje się samodzielnie i przechodzi testy.** Wypychaj go od razu. Przed następnym commitem poczekaj na zielone CI.

## 1. Zasady pracy (obowiązują w każdym commicie)

**Język i treść:**
- Komentarze, Javadoc, `Log.*` i opisy commitów piszesz **wyłącznie po angielsku**, w stylu otaczającego kodu: pełne zdania, które wyjaśniają *dlaczego*.
- **Nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.

**Commity:**
- Temat `<Obszar>: <co>` (tematy z tabeli §0). Treść zawijaj na ~72 znaki i wpisz do niej fakty z §2.
- Zakończ commit dokładnie trailerami z system-remindera sesji.
- Push: `git push -u origin testBranch`. Przy błędzie sieci ponów do 4 razy, z odstępem 2/4/8/16 s.

**CI:**
- Workflow to `.github/workflows/build.yml`, z `cancel-in-progress`. Sprawdzaj run **ostatniego** commita przez GitHub MCP (`actions_list`, `get_job_logs`).
- Czerwony build naprawiasz kolejnym commitem. Bez amend i bez force-push.
- Przed pushem uruchom lokalnie `./gradlew :app:testSystemDebugUnitTest`.

**StrictMode jest włączony.** W nowym kodzie na wątku głównym nie może być:
- I/O plików;
- zapytań do bazy;
- zapytań do `ContentResolver`;
- sieci;
- `su`;
- blokujących wywołań hosta VD.

Prefy zapisuj przez `apply()`. Wywołania bindera do com.syu.ms (rejestracja kodów) zostają tam, gdzie są dziś.

**Testy:**
- JVM, JUnit 5, w `app/src/test/java/…`. Wzorce: `BottomBarPlacementTest`, `PersistentBarWindowTest`.
- `unitTests.isReturnDefaultValues = true`.
- Logikę decyzyjną pisz w **czystych klasach bez `android.*`**.

**Ograniczenia:** bez nowych zależności; bez zmiany schematu bazy launchera; nowe klucze prefów tylko w `settings/Keys.java` (w tej rundzie żadnych).

**Napisy:** nowy string wpisz w 51 plikach `res/values*/strings.xml`, które mają `double_tap`, w tym domyślny `res/values/strings.xml`. Pozostałe 8 wariantów regionalnych dziedziczy z języka bazowego, tak jak dziś `double_tap` i `screen_first`:
- `en-rGB`, `en-rIN`;
- `es-rUS`, `et-rEE`, `fr-rCA`;
- `ms-rMY`, `pt-rPT`, `zh-rHK`.

Apostrofy i cudzysłowy escapuj jak w sąsiednich wpisach.

## 2. Fakty

### 2.1 Przegląd rundy 5 (`347f06be`, `656decb4`, `11e70c29`): bez błędów do naprawy
CI wszystkich trzech commitów jest zielone. Sprawdzone i poprawne:
- `EdgeHandlePass`: odtwarzanie z kopii i odroczone ukrycie (koniec gestu, `show()`, `release()`);
- `onBottomBarAdapterReady`;
- `PersistentBarWindow.target` / `action`;
- `activate` / `park` z licznikiem generacji;
- `primeStandbyWindow`;
- `mPersistentShown` w `refreshWidgetBarAfterWake`;
- usunięcie okna w `cleanupAllResources`.

Zgłoszone odstępstwa są poprawne i zostają:
- `NOTHING` dla NONE→STANDBY w ruchu;
- `mPersistentParking` liczone jako STANDBY;
- wiązanie okna w gotowości po pierwszym layoucie;
- podział `persistentBarAllowed` na `permitted` i `free`.

Kodu rundy 5 nie zmieniasz.

### 2.2 Bug 1: rozmiar ustawiony strzałkami ginie po powrocie na ekran główny
Zgłoszenie właściciela: strzałki z paska kreatora zmieniają prostokąt. Po zatwierdzeniu i powrocie na ekran główny wraca stary rozmiar. Rozmiar zmieniony palcem albo przesunięcie prostokąta zostają.

**Mechanizm:**
- `DrawViewFirstScreen.savePrefs` (≈1220) zapisuje zawsze 8 rogów.
- **Prostokąt użytkownika** (`Helpers.putUserRect`, ≈872 w `settings/Helpers.java`) zapisuje tylko dla kluczy z `touchedKeys`.
- `touchedKeys` wypełniają tylko `moveActiveRect` (≈855) i `resizeActiveRect` (≈871), czyli dotyk.
- `onClick` strzałek (≈893–977) zmienia rogi (`candToPoints`) i woła `saveAndRedraw()`, ale **nie dodaje klucza do `touchedKeys`**.
- `Helpers.checkAndResetIfOverlappingOnScreen` (≈615–628) buduje układ z prostokąta użytkownika (`getUserRect`). Przy następnym dopasowaniu (powrót na ekran główny, `Launcher.onResume` ≈2443) rogi ze strzałek są nadpisywane starym prostokątem.

**Log `user_pid_06-11-2026_09-35-44`:**
- `09:36:01` zatwierdzenie (Toast z `DrawViewFirstScreen.onClick:958`);
- `09:36:03` `home clicked`, potem `Rectangle pipDual fitted to the room: RectF(5.0, 8.0, 1995.0, 1095.0) -> 13,20,1995,1095`: dopasowanie startuje ze starego prostokąta użytkownika.

**`DrawViewOtherScreens`** (kreator stron 2…n):
- `savePrefs` (≈913) zapisuje prostokąt użytkownika dla **wszystkich** prostokątów, z komentarzem „No bar cuts anything back on these screens”.
- Od „Bottom bar on every page” to nieprawda: `Helpers` przycina także te strony (≈646, `screen == 0 || everyPage`).
- Samo otwarcie i zapis kreatora strony 2 zastępuje więc narysowany prostokąt przyciętym. Po wyłączeniu opcji element nie wraca do pełnego rozmiaru.

### 2.3 Bug 2: napis „Double tap anywhere…” tam, gdzie podwójne tapnięcie nic nie robi
Zgłoszenie właściciela: przy „Bottom bar on every page” pasek kreatora prawidłowo się nie chowa, ale w tle wciąż jest napis `double_tap`. Napis ma być tylko tam, gdzie podwójne tapnięcie rzeczywiście chowa pasek:
- bez paska na wszystkich stronach;
- albo z auto-hide.

**Kod:**
- **`DrawViewFirstScreen`:**
  - podwójne tapnięcie (≈297) przełącza pasek tylko z auto-hide;
  - `onDraw` (≈571) rysuje `double_tap` tylko z auto-hide, a bez niego `screen_first`.
  - To jest dobrze.
- **`DrawViewOtherScreens`:**
  - podwójne tapnięcie (≈273) jest zablokowane przy `barOnThisPage = everyPage && !autoHide` (≈265);
  - `onDraw` (≈394–407) rysuje `double_tap` **zawsze**.
  - To jest błąd.
- **`DrawViewAppStats`** (kreator okna w aplikacji) przełącza pasek zawsze, więc napis jest tam prawdziwy. Bez zmian.

Nie ma stringu „Page: N” dla dowolnej strony: `screen_first` ma na sztywno „1”.

### 2.4 Przeciek: callback bindera trzyma serwis (LeakCanary)
Raport LeakCanary (sprd, API 29):
```
GC Root: Global variable in native code
├─ com.android.launcher66.settings.CanbusCodeInspector$1   (anonymous IModuleCallback$Stub)
│    ↓ CanbusCodeInspector$1.this$0
╰→ CanbusCodeInspector   Leaking: YES (Service#onDestroy()), Retaining 247.6 kB, retainedDuration 224679 ms
```

**Mechanizm:**
- `Stub` przekazany do com.syu.ms (`DataCanbus.PROXY.register`) trzyma globalna referencja JNI, dopóki zdalny proces ma do niego proxy.
- `unregister` usuwa go z list com.syu.ms, ale proxy znika dopiero przy GC tamtego procesu, czyli po minutach.
- Przez ten czas żyje wszystko, do czego `Stub` się odwołuje. Anonimowa klasa wewnętrzna odwołuje się do obiektu zewnętrznego.

**Stan dziś:**
- Raport pochodzi z wersji sprzed `916beeaf`. Tam callback był anonimową klasą w `CanbusCodeInspector`.
- Dziś ten sam wzorzec jest w dwóch miejscach:
  - **`settings/CanbusRecorder.callback`** (≈80): anonimowy, trzyma rekorder, czyli do 200 000 zdarzeń i punkty GPS. Używają go `CanbusCodeInspector` i `CanbusAutoCheck` (≈188). Rekorder nie jest obserwowany przez LeakCanary, więc nikt tego nie zgłosi, ale pamięć zostaje zajęta.
  - **`settings/CanbusService.statsCallback`** (≈455): anonimowy, trzyma `CanbusService.this`. Launcher zatrzymuje i uruchamia ten serwis (`Launcher` ≈3384, ≈2844), więc LeakCanary zgłosi go tak samo.
- `UserTouches` (≈122) tworzy `Stub` w metodzie statycznej, bez obiektu zewnętrznego. Bez zmian.

**Drobiazg w `CanbusCodeInspector.freezeAndSaveData`** (≈117): Toast po zapisie pokazuje się z kontekstu już zniszczonego serwisu (`this`).

## C1 — `Creator: a size set with the arrows is kept when the home screen fits the layout`
1. **`DrawViewFirstScreen.onClick`.** Gdy krok strzałki zostaje zastosowany (gałąź `clampedCand.equals(cand)`, ≈972), dodaj `touchedKeys.add(cfg.key)` przed `saveAndRedraw()`.
   - `stats` zostaje wyłączony z prostokąta użytkownika jak dziś (`savePrefs` ≈1234).
2. **`DrawViewOtherScreens`: ta sama zasada co pierwsza strona.**
   - Pole `touchedKeys` z tym samym komentarzem.
   - Oznaczaj w `moveActiveRect`, `resizeActiveRect` i w krokach strzałek (`onClick` ≈727–760, przy każdym zastosowanym `candToPoints`).
   - `savePrefs` zapisuje prostokąt użytkownika tylko dla oznaczonych kluczy (bez `stats`) i czyści zbiór.
   - Usuń nieprawdziwy komentarz „No bar cuts anything back on these screens” i opisz, dlaczego tak jest (pasek na każdej stronie przycina także te strony).
3. Bez zmian w `Helpers`, w regułach dopasowania i w zapisie rogów.

## C2 — `Creator: the double tap hint only where a double tap hides the bar`
1. **Czysta klasa `settings/CreatorBarToggle`** z testem wszystkich 8 kombinacji: `static boolean canToggle(boolean firstScreen, boolean autoHide, boolean everyPage)`.

   | Strona | Wynik |
   |---|---|
   | pierwsza | `autoHide` |
   | pozostałe | `autoHide \|\| !everyPage` |

2. **Jedna reguła dla tapnięcia i napisu w obu kreatorach.**
   - `DrawViewFirstScreen` (≈297 i ≈571) i `DrawViewOtherScreens` (≈265–283 i ≈394–407) pytają `canToggle` w podwójnym tapnięciu i w `onDraw`.
   - `barOnThisPage` (≈265) zostaje jako `!canToggle(false, …)`: dalej wymusza widoczny pasek.
3. **Bez możliwości przełączenia** `DrawViewOtherScreens.onDraw` rysuje jedną linię z numerem strony, wyśrodkowaną w `getHeight() / 2f`, jak `DrawViewFirstScreen` bez auto-hide.
   - Nowy string `screen_number`: EN „Page: %1$s”, PL „Strona: %1$s”.
   - W każdym z 51 plików treść to pierwsza linia `double_tap` tego pliku, bez końcowej spacji (np. DE „Seite: %1$s”, FR „Page : %1$s”, JA „ページ: %1$s”).
   - `screen_first` zostaje.
4. `DrawViewAppStats` bez zmian.

## C3 — `Canbus: the binder callbacks no longer keep the reader, its recording or the service alive`
1. **`CanbusRecorder`.**
   - Anonimowy `callback` zastąp statyczną klasą zagnieżdżoną `RecorderCallback extends IModuleCallback.Stub` z polem `volatile CanbusRecorder target`. `update` przy `target == null` nic nie robi.
   - Pole `callback` zostaje (ten sam typ dla `register` / `unregister`).
2. **`CanbusRecorder.release()`** (wątek w tle):
   - `callback` odpina rekorder (`target = null`);
   - pod `lock` czyści zdarzenia, liczniki i `gpsFixes`.
   - Wołaj ją **po** wyrejestrowaniu kodów:
     - w `CanbusCodeInspector` na końcu zadania `unregisterCodesInBatches` (≈139), przed `batchExecutor.shutdown()`. Zapis pliku (`freezeAndSaveData`) jest w tej samej kolejce wcześniej, więc ma swoje kopie;
     - w `CanbusAutoCheck` po każdym `unregisterCodesInBatches` (≈117, ≈225, ≈236).
   - Sprawdź, że zapis pracuje na kopiach (`freeze()`, `fixes()`). Jeśli `fixes()` zwraca listę na żywo, niech zwraca kopię.
3. **`CanbusService.statsCallback`.** Tak samo: statyczna klasa zagnieżdżona z `volatile CanbusService target`, a `update` przekazuje do metody serwisu (dzisiejsze `onStatsCode`). W `onDestroy` po `removeNotify()` (≈334, które wyrejestrowuje kody) odepnij serwis.
4. **Toast w `freezeAndSaveData`** (≈121): `getApplicationContext()` zamiast `this`.
5. Bez testu JVM: `Stub` to `android.os.Binder`. Opis commita wymienia oba miejsca i mechanizm z §2.4.

## 3. Czego NIE zmieniać
- Kodu rundy 5 (pasek na każdej stronie, uchwyt).
- Reguł dopasowania w `Helpers` i zapisu rogów w kreatorach.
- `DrawViewAppStats`.
- Rejestracji kodów (kolejność, partie, wątki) poza odpięciem po wyrejestrowaniu.

## 4. Weryfikacja
1. Po każdym commicie CI jest zielone, a `CreatorBarToggleTest` przechodzi.
2. Sprawdzenia `rg`:
   - `name="screen_number"` jest w 51 plikach;
   - `new IModuleCallback.Stub()` nie ma w `CanbusRecorder` ani w `CanbusService`.
3. Scenariusze dla testera. Wypisz je w raporcie po angielsku, w stylu instrukcji testera:
   - a) Kreator pierwszej strony: zaznacz prostokąt, zmień jego rozmiar tylko strzałkami (kilka kroków na każdej krawędzi), zatwierdź, wróć na ekran główny. Element ma nowy rozmiar, także po ponownym otwarciu kreatora i po restarcie launchera.
   - b) To samo w kreatorze strony 2.
   - c) „Bottom bar on every page” włączony, bez auto-hide:
     - narysuj na stronie 2 prostokąt do dołu ekranu i zapisz;
     - otwórz kreator strony 2 i zatwierdź bez zmian;
     - wyłącz opcję. Prostokąt wraca do narysowanego rozmiaru.
   - d) Napis: kreator strony 2 przy „Bottom bar on every page” bez auto-hide pokazuje tylko „Page: 2”, a podwójne tapnięcie nic nie chowa. Bez tej opcji albo z auto-hide jest pełny napis i tapnięcie chowa pasek. Kreator pierwszej strony jak dotąd.
   - e) Czytnik kodów canbus z czasem 60 s: po jego końcu i 5 minutach LeakCanary nie zgłasza `CanbusCodeInspector`. Restart `CanbusService` (wyjście z launchera do aplikacji i powrót, wybudzenie) nie daje zgłoszenia `CanbusService`.

## 5. Raport końcowy (w odpowiedzi, po polsku)
- Commity (hash i temat) z wynikiem CI każdego.
- Każde odstępstwo od instrukcji i jego powód.
- Scenariusze z §4.3.
