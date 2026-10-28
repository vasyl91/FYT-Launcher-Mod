# Launcher Mod: usunięcie pozostałości `Cling` (samouczki pierwszego uruchomienia i podpowiedź głosowa) — instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`. Masz usunąć klasę `Cling` i wszystko, co istnieje tylko dla niej: kod Java, układy, zasoby w `res/` i wpisy w profilach baseline. Zrób to w czterech commitach, w kolejności C1 → C2 → C3 → C4. **Każdy commit musi się budować samodzielnie.** Wypchnij je na tę gałąź. **Nie twórz pull requesta.**

Numery linii to stan z `b38f128` i są orientacyjne. Zawsze sprawdzaj je w kodzie.

## 0. Cel i najważniejsza zasada

To czyste usuwanie martwego kodu. Na żadnym urządzeniu (FYT 7862, 8581, 7870, telefony) użytkownik nie może zobaczyć żadnej zmiany. Dotyczy to także Back: nadal ma wysyłać `com.syu.cancle_tts` (krok C1.2). Nie refaktoryzuj niczego poza tym, co wymienione. Nie „poprawiaj” przy okazji sąsiedniego kodu.

Dlaczego ten kod jest martwy (fakty z kodu):
- **Samouczki pierwszego uruchomienia** (`first_run_cling`, `workspace_cling`, `folder_cling`). `initCling` wywołuje się tylko wtedy, gdy `Launcher.isClingsEnabled()` (≈8803) zwraca `true`, a ta metoda zawsze zwraca `false`. Dlatego zawsze wykonuje się `removeCling(...)`, które wyjmuje widok z `DragLayer`. `showFirstRunCling()` nie ma ani jednego wywołującego.
- **Podpowiedź głosowa** (`clickapp_cling`) w `Launcher.startActivitySafely` (≈6907–7021). Pokazuje się tylko w gałęzi `else` warunku `… || !Config.EXISTVOICE || !closePop`. Pole `closePop` czyta `R.bool.close_popwindow`, które ma wartość `false` w jedynym miejscu, gdzie jest zdefiniowane (`values/bools.xml:39`). Żaden source set (`fyt`, `debug`, `release`) go nie nadpisuje. Zawsze wykonuje się więc `success = start(v, intent, tag)`.
- **Układy bez użycia.** `all_apps_cling.xml` i `custom_workspace_cling.xml` nie są nigdzie dołączane. Metoda `dismissAllAppsCling`, którą wskazuje ich `onClick`, w ogóle nie istnieje.
- **`HideFromAccessibilityHelper`.** Nikt nie wywołuje `setImportantForAccessibilityToNo`, więc `mHide` jest zawsze `false` i `restoreImportantForAccessibility` nic nie robi. Wszystkie wywołania tej klasy leżą w kodzie cling.
- **`ScrimView`** występuje tylko jako `@+id/cling_scrim` w czterech układach `launcher*.xml`.
- **`AppsCustomizePagedView.showAllAppsCling()`** oblicza pozycję i nigdzie jej nie używa.

## 1. Zasady pracy i konwencje repo (jak w poprzednich rundach)

- **Commity po angielsku**:
  - temat w trybie rozkazującym `<Obszar>: <co>`, treść zawinięta na ~72 znaki;
  - w treści napisz, *dlaczego* kod jest martwy (fakty z §0);
  - zakończ dokładnie trailerami z system-remindera sesji;
  - **nie wpisuj nazwy ani identyfikatora modelu** nigdzie w repo.
- **Push**: `git push -u origin ccr-087eed00-gbqsuz`. Przy błędzie sieci ponów do 4 razy z odstępem 2/4/8/16 s. Wypychaj **po każdym commicie** i zanim zaczniesz następny, poczekaj na wynik CI tego commita (patrz §5.3). Workflow ma `cancel-in-progress`, więc tylko tak sprawdzisz, że każdy commit buduje się osobno.
- **Nie ruszaj commita `57e3600 [BRANCH-ONLY] CI: …` ani plików `.github/workflows/*.yml`.**
- **Usuwaj dopiero po sprawdzeniu `rg`**, że nie zostaje żadne odwołanie:
  - szukaj w całym `app/src`, we wszystkich source setach (`main`, `fyt`, `debug`, `release`, `test`), w Javie, Kotlinie i XML;
  - repo czyta zasoby także **po nazwie w napisach**, np. `ResValue.getResId("clickapp_cling", R.id.class)` i `ResValue.getInstance().getId("clingmusictitle", "string")`. Szukaj więc samej nazwy zasobu, nie tylko `R.x.nazwa`.
- Całe pliki usuwaj przez `git rm`. Nie zostawiaj komentarzy typu „removed cling” ani pustych metod-zaślepek.
- Po każdym kroku usuń importy, które przestały być używane, i tylko te.
- **Bez nowego kodu, bez nowych zależności, bez migracji preferencji.** Klucze `cling_gel.*` (SharedPreferences) i właściwości `persist.sys.cling*` (SystemProperties) zapisane na urządzeniach zostają. Nie czyść ich.
- `Launcher.java` (>9000 linii) i `Workspace.java` (>7000) edytuj punktowo. Nie przenoś istniejącego kodu.
- **Kontrola bez SDK**: zmienione klasy możesz skompilować poleceniem `javac -proc:none -cp android_jar/android-36.jar -d <tmp> …`. Stuby klas projektu (`R`, `LauncherApplication` …) trzymaj w katalogu tymczasowym, nie w repo. Zasobów to nie sprawdzi, o nich rozstrzyga CI.

## C1 — `Launcher: drop the voice hint cling shown before stock apps`

Usuń podpowiedź głosową `clickapp_cling` i wszystko, co służy tylko jej.

1. **`Launcher.startActivitySafely`** (≈6907–7021): usuń zmienne `clingTitleText`, `clingText`, `str1` i cały `if/else`. Na końcu metody zostaje samo `success = start(v, intent, tag);` przed `return success;`. Część metody przed ≈6907 (easyconn, carlife, toasty) zostaw bez zmian.
2. **Callback Back w `onBackPressedX()`** (≈2086–2098). Blok `if (ResValue.getInstance().clickapp_cling > 0) { … }` wykonuje się dziś przy **każdym** Back: identyfikator istnieje, więc warunek jest zawsze prawdziwy. Zrób tak:
   - usuń tylko ukrycie cling (`Cling cling = (Cling) findViewById(...)` i `if (cling != null) cling.setVisibility(GONE)`);
   - trzy pozostałe efekty **zostaw** w tej samej kolejności i z tymi samymi kontrolami null, ale już bez warunku `clickapp_cling`: `Launcher.this.stopVoice()`, `mWaitingForResume.setStayPressed(false)` i `mAppsCustomizeContent.resetDrawableState()`;
   - **decyzja właściciela**: Back ma nadal przy każdym naciśnięciu wysyłać do asystenta głosowego FYT intencję `com.syu.cancle_tts` (`stopVoice()`), czyli przerywać jego mowę, tak jak dotąd. Nie usuwaj tego wywołania i nie dodawaj mu żadnego nowego warunku. W treści commita napisz, że `stopVoice()` zostaje celowo, mimo że `wakeVoice` znika.
3. **Usuń metody**:
   - `showClickappCling()` (≈9045);
   - `dismissClingApp(...)` (≈8823–8889);
   - `wakeVoice(String)` (≈7025).

   Metoda **`stopVoice()` (≈7032) zostaje** bez zmian, bo woła ją Back.
4. **Usuń pole** `closePop` (≈479).
5. **`share/ResValue.java`** (≈282–286): usuń pola `clingtitletext`, `clingtext`, `clickapp`, `clickapp_cling`, `clickapp_cancel`.
6. **`share/Config.java`**: usuń `EXISTVOICE` (po C1.1 nikt go nie czyta). W `AllAppsList.java` usuń trzy bloki `if (… FytPackage.voiceAction) { Config.EXISTVOICE = …; }` (≈70–72, ≈137–139, ≈161–163). `Config.EXISTAMPAUTO` i `FytPackage` zostają bez zmian.
7. **Układy**:
   - w `res/layout-port/launcher.xml`, `res/layout-land/launcher.xml`, `res/layout-port/launcher_f.xml` i `res/layout-land/launcher_f.xml` usuń `<include android:id="@+id/clickapp_cling" … layout="@layout/clickapp_cling" />`;
   - usuń pliki `res/layout-port/clickapp_cling.xml` i `res/layout-land/clickapp_cling.xml`.

Po C1 nadal żyją `initCling`, `getFirstRunFocusedHotseatApp*()` i `mHideFromAccessibilityHelper`, bo używa ich kod z C2. Stringi `cling*` zostają do C3.

## C2 — `Launcher: drop the first-run clings and the Cling view`

1. **`Launcher.java`, usuń**:
   - metody z zakresów ≈8803–9059 i ≈9117–9166: `isClingsEnabled`, `initCling`, `dismissCling`, `removeCling`, `skipCustomClingIfNoAccounts`, `updateCustomContentHintVisibility`, `setCustomContentHintVisibility`, `showFirstRunCling`, `getFirstRunClingSearchBarHint`, `getFirstRunCustomContentHint`, `getFirstRunFocusedHotseatAppDrawableId`, `getFirstRunFocusedHotseatAppComponentName`, `getFirstRunFocusedHotseatAppRank`, `getFirstRunFocusedHotseatAppBubbleTitle`, `getFirstRunFocusedHotseatAppBubbleDescription`, `showFirstRunWorkspaceCling`, `showFirstRunFoldersCling`, `isFolderClingVisible`, `dismissFirstRunCling`, `dismissWorkspaceCling`, `dismissFolderCling`. Metody `protected` nie mają podklas, które by je nadpisywały: `rg 'extends Launcher\b'` daje zero wyników;
   - wywołanie `dismissFolderCling(null);` w `closeFolder()` (≈7179);
   - pole `mHideFromAccessibilityHelper` (≈502);
   - importy `android.accounts.Account` i `android.accounts.AccountManager`, których używa tylko `skipCustomClingIfNoAccounts`. `Animator`/`AnimatorListenerAdapter` zostają, bo są używane gdzie indziej. Inne importy usuń tylko wtedy, gdy `rg` pokaże zero użyć.

   Między tymi zakresami **zostają**: `setDefaultWallpaper()` (woła je `com/fyt/car/SetWallpaperReceiver.java:27`), `setDefaultWallpaper(String)`, `setWallpaper`, `getResId`, `getSharedPrefs`.
2. **`Folder.java`**:
   - usuń `mLauncher.dismissFolderCling(null);` w `onLongClick` (≈253);
   - w `onAnimationEnd` animacji otwarcia usuń cały blok `Cling cling = mLauncher.showFirstRunFoldersCling(); if (cling != null) { … }` (≈499–504);
   - `mState = STATE_OPEN`, `setLayerType(...)` i `setFocusOnFirstChild()` zostają.
3. **`DragLayer.java`** (≈154): `if (currentFolder != null && !mLauncher.isFolderClingVisible() && intercept)` zamień na `if (currentFolder != null && intercept)`. Dziś `isFolderClingVisible()` zawsze zwraca `false`, bo `folder_cling` jest wyjęty z drzewa albo ma GONE.
4. **`Workspace.java`**: w `createCustomContentPage` (≈2879–2880) i w `removeCustomContentPage` (≈2908–2909) usuń `mLauncher.updateCustomContentHintVisibility();` razem z komentarzem `// Update the custom content hint` nad nim. Niczego więcej w tym pliku nie zmieniaj.
5. **`AppsCustomizeTabHost.java`**: usuń `l.dismissWorkspaceCling(null);` w `onLauncherTransitionStart` (≈332) oraz `this.mAppsCustomizePane.showAllAppsCling();` w `onLauncherTransitionEnd` (≈347).
6. **`AppsCustomizePagedView.java`**, usuń:
   - pola `mHasShownAllAppsCling`, `mClingFocusedX`, `mClingFocusedY` razem z komentarzem `// Cling` (≈189–192);
   - odczyty `R.styleable.AppsCustomizePagedView_clingFocusedX/Y` w konstruktorze (≈280–281);
   - w `onDataReady` blok `if (!hostIsTransitioning) { post(… showAllAppsCling() …); }` razem z trzylinijkowym komentarzem nad nim (≈407–417). Zmienna `hostIsTransitioning` zostaje, bo czyta ją `invalidatePageData` linię wyżej;
   - metodę `showAllAppsCling()` (≈420–433).
7. **`PagedViewCellLayout.estimateCellPosition(int, int)`** (≈263): jedynym wywołującym był `showAllAppsCling`. Usuń ją po sprawdzeniu `rg`.
8. **`Hotseat.getCellCoordinates(int, int)`** (≈101): jedynym wywołującym był `Cling.setFocusedHotseatApp`. Usuń ją po sprawdzeniu `rg`. `getCellXFromOrder`/`getCellYFromOrder` zostają, bo mają innych wywołujących.
9. **Usuń klasy**: `com/android/launcher66/Cling.java`, `HideFromAccessibilityHelper.java`, `ScrimView.java`. Interfejs `Insettable` zostaje.
10. **Układy**:
    - w czterech plikach `res/layout-{port,land}/launcher.xml` i `res/layout-{port,land}/launcher_f.xml` usuń `<com.android.launcher66.ScrimView android:id="@+id/cling_scrim" … />` oraz `<include>` z id `first_run_cling`, `workspace_cling` i `folder_cling`;
    - pozostałe dzieci `DragLayer` (workspace, qsb, hotseat, overview_panel, page_indicator, apps_customize_pane i to, co jest tylko w `launcher_f.xml`) zostają w tej samej kolejności. `DragLayer` liczy indeksy dzieci tylko względem workspace i qsb (`indexOfChild`), więc usunięcie tych widoków ich nie psuje;
    - usuń pliki `res/layout-{port,land}/{first_run,workspace,folder,all_apps}_cling.xml` (8 plików) i `res/layout/custom_workspace_cling.xml`.

Kontrola po C2: `rg -n -i 'cling' app/src/main/java | rg -v -i 'recycling|lifecycling'` → zero wyników. Wyjątki `recycling` są niezwiązane: `WidgetPreviewLoader` i `com/syu/canbus/R.java`.

## C3 — `Resources: drop what only the clings used`

Każdą pozycję usuń dopiero wtedy, gdy `rg -n '<nazwa>' app/src --glob '!**/generated/**'` nie zwraca nic poza samą definicją. Poniższą listę sprawdzono na `b38f128`. Jeśli któraś pozycja ma jeszcze użycie, zostaw ją i napisz o tym w raporcie.

1. **Rastry** (59 plików). Leżą w `drawable-{mdpi,hdpi,xhdpi,xxhdpi}` i `drawable-land-{mdpi,hdpi,xhdpi,xxhdpi}`. Nazwy: `bg_cling1`…`bg_cling5`, `bg_cling_home`, `bg_cling_nakasi3`, `cling.9`, `cling_button.9`, `cling_button_pressed.9`, `cling_arrow_up`, `cling_arrow_down`, `cling_arrow_left`, `cling_arrow_right`. Wypisz je poleceniem `find app/src/main/res -name '*cling*.png'`, porównaj z tą listą (spodziewane 59) i usuń `git rm`.
2. **Drawable XML**: `res/drawable/cling_button_bg.xml`, `cling_arrow_start.xml`, `cling_arrow_end.xml`.
3. **`values/styles.xml`**: `ClingButton`, `ClingTitleText`, `ClingAltTitleText`, `ClingText`, `ClingHintText`, `CustomClingTitleText`, `CustomClingText`.
4. **`values/strings.xml`**:
   - `first_run_cling_title`, `first_run_cling_description`, `first_run_cling_custom_content_hint`, `first_run_cling_search_bar_hint`, `first_run_cling_create_screens_hint`;
   - `workspace_cling_title`, `workspace_cling_move_item`, `all_apps_cling_title`, `all_apps_cling_add_item`, `folder_cling_title`, `folder_cling_create_folder`, `cling_dismiss`, `dummy_custom_cling_error_message`;
   - `clingmusictitle`, `clingvideotitle`, `clingnavetitle`, `clingradiotitle`, `clingbttitle`, `clingkuwotitle`, `clingkaolatitle`;
   - `clingmusictext`, `clingvideotext`, `clingnavetext`, `clingradiotext`, `clingbttext`, `clingkuwotext`, `clingkaolatext`;
   - `cling_cancel`.

   Te stringi nie mają tłumaczeń: w żadnym `values-*/` nie ma żadnego z nich. Elementy `cling*text` są wieloliniowe, więc usuń każdy w całości, aż do `</string>`. Niczego innego w `strings.xml` nie ruszaj. Na przykład `folder_opened` tuż pod blokiem z ≈50–62 i `car_calculator` tuż pod `cling_cancel` zostają.
5. **`values/colors.xml`**: `first_run_cling_circle_background_color`.
6. **`values/dimens.xml`**: `clingPunchThroughGraphicCenterRadius`, `folderClingMarginTop`, `cling_text_block_offset_x`, `cling_text_block_offset_y`. Już dziś nic ich nie używa.
7. **`values/bools.xml`**:
   - `config_useCustomClings` (bez użyć);
   - `close_popwindow` (nieużywany od C1);
   - `isdefaultwallpaper` (nieużywany od C2, czytał go tylko `showFirstRunCling`).
8. **`values/attrs.xml`**: usuń cały `<declare-styleable name="Cling">` oraz atrybuty `clingFocusedX` i `clingFocusedY` z `<declare-styleable name="AppsCustomizePagedView">`. Java czyta ten styleable przez nazwane stałe (`AppsCustomizePagedView_widgetCountX` …), więc przesunięcie indeksów niczego nie psuje. Potwierdź to: `rg 'R.styleable.AppsCustomizePagedView'`.
9. **`res/layout/apps_customize_pane.xml` i `apps_customize_pane_3g.xml`**: usuń atrybuty `launcher:clingFocusedX` i `launcher:clingFocusedY`. W obu plikach to ostatnie atrybuty elementu, a zaraz za nimi stoi `/>`. Zachowaj zamknięcie tagu.
10. **`values-land/integers.xml` i `values-port/dimens.xml`**: usuń `apps_customize_cling_focused_x` i `apps_customize_cling_focused_y`. Wpisy `apps_customize_widget_cell_count_*` zostają.
11. **`values/ids.xml`**: usuń `all_apps_cling_title`, `all_apps_cling_add_item`, `cling_dismiss`, `clingtitletext`, `clingtext`, `clickapp`, `clickapp_cancel`, `folder_cling_title`, `folder_cling_create_folder`, `cling_scrim`, `first_run_cling`, `workspace_cling`, `folder_cling`, `clickapp_cling`, `bubble_content`, `search_bar_hint`, `custom_content_hint`, `focused_hotseat_app_bubble`, `focused_hotseat_app_title`, `focused_hotseat_app_description`, `content`.

    Przy `content` uważaj: wszystkie inne użycia w kodzie to `android.R.id.content` i ten wpis ich nie dotyczy. Przed usunięciem oba poniższe polecenia muszą zwrócić zero:
    - `rg -n '\bR\.id\.content\b' app/src/main/java | rg -v 'android\.R\.id\.content'`;
    - `rg -n '@\+?id/content"' app/src/main/res`.

Kontrola po C3: `rg -n -i 'cling' app/src/main/res` → zero.

## C4 — `Baseline profiles: drop entries of the removed classes`

W `app/src/main/generated/baselineProfiles/baseline-prof.txt` i `startup-prof.txt` usuń tylko linie, które odnoszą się do usuniętych klas i metod:
- `Lcom/android/launcher66/Cling;` i wszystkie jej metody;
- `HideFromAccessibilityHelper` (klasa i `<init>`);
- `ScrimView` (klasa i metody);
- `AppsCustomizePagedView;->showAllAppsCling`;
- `Launcher;->dismissCling`, `Launcher;->dismissWorkspaceCling`.

Linii `Launcher;->stopVoice()V` (metoda zostaje), `Landroidx/lifecycle/Lifecycling` i `RecyclerView$ViewHolder;->doesTransientStatePreventRecycling` nie ruszaj. Nie regeneruj profili i nie zmieniaj kolejności pozostałych linii.

Kontrola: `rg -n 'launcher66/(Cling|HideFromAccessibilityHelper|ScrimView);|showAllAppsCling|dismissCling|dismissWorkspaceCling' app/src/main/generated` → zero, a `rg -c 'Launcher;->stopVoice' app/src/main/generated/baselineProfiles/baseline-prof.txt` → 1.

## 4. Czego NIE zmieniać

- `setDefaultWallpaper()`, `setDefaultWallpaper(String)`, `setWallpaper`, `getResId` w `Launcher` oraz `SetWallpaperReceiver`.
- `stopVoice()` i jego wywołanie przy Back (decyzja właściciela, C1.2).
- `mWaitingForResume`, `resetDrawableState()`, `iconPressed` i logika `onResume`.
- `getSharedPrefs()` i `mSharedPrefs`. Nie dotyczą cling, nie rozszerzaj zakresu.
- `FytPackage`, `Config.EXISTAMPAUTO`, `ServiceIntentGate`, `SearchDropTargetBar` (`hideSearchBar`/`showSearchBar` mają innych wywołujących).
- `Insettable`; `DragLayer` poza linią z C2.3; `Hotseat` poza `getCellCoordinates`; `Utilities`; `DynamicGrid`.
- Tłumaczenia w `values-*/strings.xml`. Nie zawierają nic z cling.
- Zapisane preferencje i właściwości systemowe na urządzeniach.
- Commit `57e3600` i `.github/workflows/*`.

## 5. Weryfikacja

1. Po każdym kroku uruchom kontrolę `rg` z sekcji tego kroku i (opcjonalnie) `javac` na zmienionych klasach.
2. Kontrola końcowa:
   - `rg -n -i 'cling' app/src | rg -v -i 'recycling|lifecycling'` → zero;
   - `rg -n 'HideFromAccessibilityHelper|ScrimView|EXISTVOICE|closePop|close_popwindow|isdefaultwallpaper|config_useCustomClings|estimateCellPosition|getCellCoordinates|wakeVoice|clickapp' app/src` → zero;
   - `rg -n 'stopVoice\(\)' app/src/main/java` → dokładnie dwie linie: definicja i wywołanie w callbacku Back;
   - `git show --stat` każdego commita: C3 i C4 nie dotykają żadnego `.java`; C1 i C2 nie dotykają `values*/`.
3. **CI rozstrzyga o zasobach.** Po każdym pushu sprawdź run tego commita: `testFytDebugUnitTest`, `assembleFytDebug`, `assembleStandardDebug`. Użyj GitHub MCP (`actions_list`, `get_job_logs`) albo `curl -s "https://api.github.com/repos/vasyl91/FYT-Launcher-Mod/actions/runs?branch=ccr-087eed00-gbqsuz&per_page=1"`. AAPT zgłosi każdy brakujący zasób (`resource … not found`), a javac każde osierocone odwołanie. Czerwoną budowę napraw kolejnym commitem (bez amend i force-push), zanim przejdziesz dalej.
4. Scenariusze dla właściciela (7862 i 7870), wypisz je w raporcie:
   - a) zimny start launchera, także po wyczyszczeniu danych aplikacji: brak jakichkolwiek nakładek, ekran jak dotąd;
   - b) folder: otwarcie i zamknięcie, tap poza folderem zamyka go (`DragLayer`), przeciągnięcie ikony z folderu, zmiana nazwy;
   - c) Wszystkie aplikacje i widgety: otwarcie, przewijanie, powrót przez Back i Home;
   - d) uruchomienie Muzyki, Wideo, Radia, BT, nawigacji, Kuwo i Koala FM z pulpitu i z paska: startują od razu, bez okna podpowiedzi, jak dotąd;
   - e) Back na pulpicie, w trybie przeglądu i w otwartym folderze działa jak dotąd i nadal przerywa mowę asystenta głosowego FYT;
   - f) strona custom content (jeśli jest włączona) dodaje się i znika bez błędów;
   - g) opcjonalnie TalkBack: ikony pulpitu i Wszystkich aplikacji są nadal czytane.

## 6. Raport końcowy (w odpowiedzi, po polsku)

- Lista commitów (hash + temat) i wynik CI każdego z nich.
- Liczba usuniętych plików (Java / layout / drawable) i bilans linii (`git diff --shortstat b38f128..HEAD`).
- Każda pozycja z C3, której nie usunięto, razem ze znalezionym użyciem.
- Potwierdzenie, że zachowanie się nie zmieniło, w tym że Back nadal woła `stopVoice()`.
- Scenariusze z pkt 5.4 do sprawdzenia.
