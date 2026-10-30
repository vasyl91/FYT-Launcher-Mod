# Co zmienia nowsza wersja `com.syu.canbus` dla launchera — porównanie z 30-10-2026

Porównane źródła:

| skrót | katalog | pliki `.java` |
|---|---|---|
| **stara** | `decompiled_com.syu.canbus/classes.dex/sources` (ta, która działa na radiu właściciela) | 2958 |
| **nowa** | `decompiled_com.syu.canbus/classes.dex.new/sources` | 3223 |
| **carinfo** | `decompiled_carinfo/` (pakiet `com.syu.carinfo` z jeszcze innego builda) | — |
| **asset** | `app/src/main/assets/canbus_library.txt` (558 rekordów) | — |

Liczby z `--diff` pochodzą z poprawionego skryptu (commit G1), uruchomionego na obu wersjach. Nic w tym dokumencie nie zmienia kodu launchera.

## 1. Wnioski

1. **IPC jest takie samo.** `com/syu/ipc/**` w starej i nowej wersji różni się tylko komentarzem `JADX INFO: loaded from`. Numery transakcji i deskryptory binderów zgadzają się też z kopią w launcherze. Zmiana nie grozi `cmd(...)`, `register(...)` ani formatowi `ModuleObject`.
2. **Zmieniły się numery kodów `DATA[n]`**, i to różnie dla różnych rodzin aut. Dla auta właściciela (rodzina PSA, protokół 339/163) przesunięcie jest stałe: **+11** (spalanie chwilowe 91 → 102, zasięg 92 → 103). Ekran spalania czyta więc inne indeksy w zależności od wersji `com.syu.ms`, a nie `com.syu.canbus`.
3. **Zapytania auta 1507667 się nie zmieniły:** `70:51; 29:0` (strona `RZC_BZ408OilMilePage1Acti`). Nowa wersja dokłada tylko ekran auta elektrycznego `RZC_BZ408EVMilePage1..4Acti` (`70:80`..`70:83`). Stary generator uczyniłby z niego pierwszą stronę. Poprawka jest w G1.
4. **RPM: nowa wersja nic nie daje.** Żaden ekran rodziny 339 nie czyta obrotów. Stała `U_ENGINE_SPEED` w `Const_RZC4_PSA_ALL_DATA` (137 w starej, 148 w nowej) istnieje, ale nie używa jej żaden ekran.
5. **Spalanie poniżej ~30 km/h: nowa wersja nic nie daje.** Strony `OilMilePage1..3` są identyczne po odjęciu numerów indeksów (ten sam zakres 0..3000, ten sam napis `--.--`). Nie ma nowego kodu z chwilowym spalaniem.
6. **Z ekranu spalania znika blok add-on 500–560.** W nowej wersji nie ma pakietu `com/syu/carinfo/rzc/addcan`, a `Callback_0339_RZC4_PSA_ALL` nie rejestruje już kodów 500–560. To tylko aplikacja canbus; czy `com.syu.ms` nadal je wysyła, tego z samych źródeł nie wiadomo (patrz p. 3).

## 2. Moduł i IPC

### 2.1 `com/syu/ipc/**`

Porównanie `diff` stara ↔ nowa:

| plik | różnica |
|---|---|
| `FinalMainServer`, `IModuleCallback`, `IRemoteModule`, `IRemoteToolkit`, `ModuleObject`, `RemoteModuleProxy` | tylko komentarz `JADX INFO: loaded from` (inna ścieżka projektu) |
| pozostałe pliki pakietu | identyczne |

Kopia w launcherze (`app/src/main/java/com/syu/ipc`), po odjęciu komentarzy `JADX`:

| plik | różnica względem nowej |
|---|---|
| `FinalMainServer.java` | brak |
| `IModuleCallback`, `IRemoteModule`, `IRemoteToolkit` | tylko styl (`Stub` bez `public static`, `final` przy `mRemote`, brak komentarzy `@Override //`). **Linie z `case`, `DESCRIPTOR`, `TRANSACTION`, `transact(` są takie same.** |
| `ModuleObject.java` | ten sam warunek zapisany inaczej (`:9`) |
| `RemoteModuleProxy.java` | launcher wykonuje `cmd(...)` i `register(...)` w `Executors.newCachedThreadPool()` (`:10`, `:24`, `:36`), oryginał woła `remoteModule` na wątku wywołującym. To zmiana launchera, nie wersji aplikacji. |
| `DataMain.java`, `FinalBt.java`, `FinalRadio.java`, `data/` | tylko w launcherze (moduły main/bt/radio) |

**Ryzyko dla launchera: brak.** Żadna różnica w IPC, `cmd(...)` ani `NOTIFY_EVENTS` nie wynika z nowej wersji.

### 2.2 `com/syu/module/**`

| plik | stara ↔ nowa |
|---|---|
| `ConnectionObserver`, `DataMoudle`, `IUiNotify`, `UiNotifyEvent` | identyczne |
| `MsToolkitConnection` | `Random().nextInt(3000)` zapisane jako `MessageHandler.WHAT_ITEM_SELECTED` (ta stała to 3000). Ta sama wartość. |
| `canbus/DataCanbus` | identyczny. `DATA` i `NOTIFY_EVENTS` mają rozmiar `FinalCanbus.U_CNT_MAX` (`:15`, `:16`). |
| `canbus/FinalCanbus` | **`U_CNT_MAX = 1200` w obu** (`FinalCanbus.java:3477` w starej, `:5547` w nowej). Zakres 0..1199 się nie zmienił. |

Różnica w `DataCanbus` względem kopii launchera to tylko `final` na `PROXY` i wywołania `DoorHelper`/`AirHelper` (`:23`, `:24`), które launcher ma wyłączone.

### 2.3 Co właściwie rośnie w `FinalCanbus.java`

`FinalCanbus` zawiera **stałe identyfikatorów aut** (`CAR_..._ = <id>`), a nie indeksy `DATA`. Stara ma ich 3487, nowa 5557: 81 tylko w starej, 2151 tylko w nowej, 4 z inną wartością (zmiana nazwy). Stąd 2000 linii przyrostu, a nie z przesunięcia kodów.

### 2.4 Przesunięcie indeksów `DATA[n]`

Indeksy `DATA[n]` (n < 1000) stoją jako literały w ekranach (`carinfo/**`, `canbus/warn/**`, `ui/**`) i w klasach `Callback_*`. Porównałem wszystkie 2659 plików obecnych w obu wersjach, po kolei literał po literale (zakres < 1000):

| przypadek | klas |
|---|---|
| klasy z literałem `DATA[n]`, n < 1000 | 1478 |
| te same indeksy | 109 |
| **stałe przesunięcie w całej klasie** | 514 |
| przesunięcie różne w jednej klasie (klasa ma kilka bloków) | 620 |
| inna liczba literałów (ekran przepisany) | 235 |

Najczęstsze stałe przesunięcia (liczba klas): **+12** (120, m.in. `ui/parking`, `Callback_0443_*`), **+97** (80, m.in. `Callback_0278_XP1_BiaoZhi301`, `Callback_0221_RZC4_PSA2008`), **+98** (38, m.in. `Callback_0024_XP1_SIYU2012`), +71, +73, +76 (po 16–18), **+11** (14, m.in. `Callback_0339_RZC4_PSA_ALL`, `Callback_0163_RZC4_PSA14_408`).

Wniosek: **przesunięcie nie jest stałe.** Zależy od rodziny aut i bywa różne w jednym ekranie. Dla rodziny PSA/408 jest stałe, +11:

- `Const_RZC4_PSA_ALL_DATA`: 137 z 138 stałych przesunięte o +11 (jedna o +72);
- `RZC_BZ408OilMilePage1Acti`: `DATA[87,91,92,93]` (stara, `:69`..`:105`) → `DATA[98,102,103,104]` (nowa, te same linie);
- `OilMilePage2`: 88, 90, 94 → 99, 101, 105; `OilMilePage3`: 95, 97, 98 → 106, 108, 109;
- `RZC_BZ408IndexActi`: 153 → 164.

Kody S z rekordów generowanych ze źródeł nowej wersji wskazują więc inne indeksy niż kody starej wersji (patrz p. 5).

## 3. Mapowanie car id → klasa (`com/syu/canbus/ActivityLauncher.java`)

| | stara | nowa |
|---|---|---|
| linii pliku | 4502 | 6818 |
| car id w `switch` | 2850 | 4901 |
| car id z klasą (po symulacji skryptem) | 2848 | 4899 |

`--diff` biblioteka starej ↔ nowej (C):

| rodzaj | liczba id |
|---|---|
| tylko w starej (ubyło) | 51 |
| tylko w nowej (doszło) | 2102 |
| zmieniona klasa lub ekran poziomy | 221 |

Przykłady:

- ubyły: 33, 46, 109, 110 (`wccamry.Rav4TripAct`), 254, 308 (`klc.KlcIndexAct`), 255 i 362 (`rzc.addcan.RZCAddCanDashBoard_HP`);
- doszły: 153, 249 (`rzc.sanlin.RZCXiandaiAmpCarSet`), 244 (`hava.ActivityHava18H6SetAct`), 352 (`wc.leinuo.Megane4SetIndexActi`);
- zmienione: 14, 49, 319 (`focus.FocusSyncBtActi` → `focus.ActivityIndex_14Festia`); 38, 231, 327 (`air.ActivityNewAir` → `air.Air_Activity_All_NewAdd_HP | air.ActivityNewAir | portrait`); 223 (`mengdiou.V11MDOAirControlActi` → `air.Air_Activity_All_Toyota_prado_HP`).

Dla porównania asset ↔ nowa: tylko w assecie 29, tylko w nowej 1064, zmienione 238 (asset powstał z innego builda, niż obie wersje).

Auto 1507667 ma ten sam ekran w obu wersjach: `RZC_BZ408IndexActi`.

## 4. Auto 1507667 (`com/syu/carinfo/rzc/biaozhi408/*`)

### 4.1 Strony i zapytania

| strona | zapytanie (stara = nowa) | kody stara → nowa |
|---|---|---|
| `RZC_BZ408OilMilePage1Acti` | `70:51; 29:0` | 91 spalanie ×10 (0..3000, inaczej `--.--`), 92 zasięg km (0..2000), 93 „dodatkowy przebieg” km (0..6000), 87 czas start-stop `hh:mm:ss` → 102, 103, 104, 98 |
| `RZC_BZ408OilMilePage2Acti` | `71:52; 29:1` (+ `28:2`) | 88 spalanie średnie 1, 90 prędkość średnia, 94 dystans → 99, 101, 105 |
| `RZC_BZ408OilMilePage3Acti` | `72:53; 29:2` (+ `28:3`) | 95, 97, 98 → 106, 108, 109 |
| `RZC_BZ408IndexActi` | — | 153 → 164 (numer zakładki, z którego `RZC_BZ408OilMileIndexActi` ustawia kartę) |
| **`RZC_BZ408EVMilePage1Acti`** (nowa) | `70:80` (`:111`) | 278 tryb jazdy, 279 flagi |
| `RZC_BZ408EVMilePage2Acti` (nowa) | `70:81` | 280..295 (ustawienia auta elektrycznego) |
| `RZC_BZ408EVMilePage3Acti` (nowa) | `70:82` | 296 godzina (ładowanie) |
| `RZC_BZ408EVMilePage4Acti` (nowa) | `70:83` | 297 |

Strony `OilMilePage1..3` są w obu wersjach identyczne po zamianie literałów indeksów (`sed` na `DATA[n]`, `NOTIFY_EVENTS[n]`, `case n:` i `diff`). EVMile otwiera się osobnym przyciskiem w `RZC_BZ408IndexActi` (`ctv_checkedtext10`, `:63`), zakładki żyją w `RZC_BZ408EVMileIndexActi`. Strony EV nie mają żadnego kodu spalania ani zasięgu, tylko ustawienia auta elektrycznego.

Poza tym w `Callback_0339_RZC4_PSA_ALL` kod **104 (stara) / 115 (nowa)** jest sygnałem „auto prosi o ekran komputera pokładowego”: gdy wynosi 1, aplikacja canbus sama otwiera `RZC_BZ408OilMileIndexActi` (`:61`..`:65` w nowej). To zdarzenie, nie wartość do wyświetlenia.

### 4.2 Nowe ekrany trip, średnie, RPM, prędkość

Nowe ekrany to wyłącznie: strony EV, `RZC_BZ408AmpSettingAct` (wzmacniacz) i `RZC_BZ408SeatMassageActi` (masaż foteli). Trip i średnie (Page2/3: spalanie średnie, prędkość średnia, dystans) były już w starej wersji. **Żaden nowy ekran nie pokazuje RPM ani prędkości chwilowej.**

### 4.3 Blok add-on 500–560 (`rzc/addcan/ConstRzcAddData.java`)

- Stara: pakiet `rzc/addcan` (5 plików) i 116 odwołań do `ConstRzcAddData`. `Callback_0339_RZC4_PSA_ALL` rejestruje 0..225 oraz `U_CAR_ADD_START` (500) .. 559 (`:23`, `:26`).
- Nowa: pakietu **nie ma**, 0 odwołań. `Callback_0339_RZC4_PSA_ALL` rejestruje tylko 0..297 (`:22`).
- Kody add-on (np. 510 prędkość ×100, 512 przebieg, 524 obroty, 518 bieg wsteczny) są nadal opisane w kopii launchera (`app/src/main/java/com/syu/module/canbus/data/ConstRzcAddData.java`).

To, czy `com.syu.ms` po aktualizacji nadal wypełnia 500–560, zależy od `com.syu.ms`, a nie od aplikacji canbus. Z kodu nie da się tego rozstrzygnąć. Ryzyko: launcher czyta prędkość z 510 i przebieg z 512 (jeśli czytnik je zgadł), więc po aktualizacji obu aplikacji warto przeskanować kody ponownie.

### 4.4 RPM i spalanie poniżej ~30 km/h

- **RPM.** Stała `Const_RZC4_PSA_ALL_DATA.U_ENGINE_SPEED` (137 w starej, 148 w nowej) nie jest użyta w żadnym ekranie rodziny 339 ani w jej klasie `Callback`. Trafienia `DATA[148]` w nowej to ekrany innych aut (`UIWCNissan08TianlaiAll`, `Golf7FunctionalMirrorsAndWipersActi`, …). Dane z logów właściciela (żadna ramka 1019 nie zawiera obrotów, 524 = 0) mówią, że ten CAN-box RPM nie wysyła. **Nowa wersja tego nie zmienia.** Jedyny trop: czy kod 137 (stary `ms`) lub 148 (nowy `ms`) kiedykolwiek różni się od 0. Skaner obejmuje cały zakres 0..1199, więc wystarczy poszukać go w istniejących zapisach.
- **Spalanie poniżej ~30 km/h.** `mUpdaterOilExpend` przyjmuje 0..3000, inaczej pokazuje `--.--` (`RZC_BZ408OilMilePage1Acti`, `:70`..`:72`, ten sam kod w obu wersjach). Nowa wersja nie dokłada żadnego kodu z chwilowym spalaniem poniżej progu. Dostępne są tylko wartości uśrednione dla tripów (99/106 w nowej, 88/95 w starej), te same co dotąd.

## 5. Generator (poprawiony skrypt, G1)

### 5.1 Uruchomienia

| źródło | C | R (id z zapytaniem) | S (id z kodem) | ostrzeżenia |
|---|---|---|---|---|
| stara (`classes.dex`) | 2848 id | 353 | 638 (586 obu kodów, 29 tylko spalanie, 123 tylko zasięg) | 2 |
| nowa (`classes.dex.new`) | 4899 id | 625 | 1415 | 3 |

Ostrzeżenia nowej wersji (stare były w pliku właściciela; skrypt nie dodał nowych):

- `ActivityLauncher.java:3214`: warunek `TheApp.getScreenWidth()>=1080` uznany za fałsz;
- `PardoTripAct`: kilka kodów spalania (98 `mUpdaterOilExpend`, 110 `mUpdaterOptimalOilExpend`), użyty pierwszy;
- `Golf7OilMileagePage1Acti`: kilka kodów zasięgu (98 i 278), użyty pierwszy.

### 5.2 `--diff` plik właściciela ↔ nowy wynik (poprawiony skrypt, `--ids 1507667`)

Plik właściciela: `decompiled_com.syu.canbus/classes.dex.new/canbus_library_2026-10-30_00-56-34.txt`.

| rodzaj | tylko w A | tylko w B | różne |
|---|---|---|---|
| C | 0 | 0 | 0 |
| R (id, strona) | 0 | 0 | 0 |
| N | 0 | 0 | 0 |
| S | 0 | 0 | 101 |
| R: strona główna / kolejność | 0 | 0 | 176 |

Wszystkie różnice mają jedną przyczynę, regułę z G1 (strona z kodem spalania lub zasięgu przed stroną auta elektrycznego):

1. **R, kolejność (176 id):** żadna strona ani żadne zapytanie się nie zmieniło, zmieniła się tylko kolejność stron. Pierwsza strona zmienia się u **2 grup, 170 id**:
   - 69 id rodziny 408 (m.in. 163, 221, 238, 339, 439, **1507667**): `RZC_BZ408EVMilePage1Acti` → `RZC_BZ408OilMilePage1Acti`;
   - 101 id Golf7 (17, 160, 437, …): `Golf7ElectricMileageIndexActi` → `Golf7OilMileageIndexActi`;
   - pozostałe 6 id zmienia tylko kolejność dalszych stron (strony EV przesunięte na koniec). Grupa 196889, 1704275 miała już pierwszą stroną `BZ408OilMilePage1Acti` i ją zachowuje.
2. **S (101 id):** to te same 101 id Golf7. Zasięg przeszedł z 306 (strona elektryczna) na 98 (`Golf7OilMileagePage1Acti`, `mUpdaterDrivingMileage`). Dla auta z silnikiem spalinowym to właściwy kod, dla elektrycznego strona `Golf7Electric...` nadal jest w bibliotece jako kolejna.

Przejrzałem obie grupy: obie zmiany są poprawne. Grupa Xp 374/424 (20 id) również zmieniłaby stronę główną, gdyby reguła kodów stała przed regułą „strona nazwana od car id”. Dlatego **strona z `_<id>_` w nazwie zostaje pierwsza**, przed regułami z G1.

Dla auta właściciela: `--ids 1507667` daje w B pierwszą stronę `RZC_BZ408OilMilePage1Acti | 70:51; 29:0`, a po niej `OilMilePage2`, `OilMilePage3` i cztery strony `EVMile`.

### 5.3 `--diff` stara ↔ nowa wersja oraz asset ↔ nowa wersja

| rodzaj | stara → nowa: tylko w starej / tylko w nowej / różne | asset → nowa: tylko w assecie / tylko w nowej / różne |
|---|---|---|
| C (id) | 51 / 2102 / 221 | 29 / 1064 / 238 |
| R (id, strona) | 0 / 796 / 138 | 381 / 504 / 48 |
| N (id) | 0 / 0 / 0 | 0 / 0 / 0 |
| S (id) | 6 / 683 / 732 | 110 / 367 / 109 |
| R: strona główna / kolejność (id) | 0 / 0 / 0 | 0 / 0 / 105 |

Co mówi S stara → nowa (732 różnych): w ogromnej części to przesunięcie indeksów z p. 2.4, np. id 12: `5 | 6` → `102 | 103`, id 19: `0 | 5` → `98 | 103`, id 217: `11 | 12` → `101 | 102`, id 1507667: `91 | 92` → `102 | 103`. Różne rodziny przesuwają się różnie, więc **jedna para kodów nie może obsłużyć obu wersji `ms`**. To uzasadnia G4.

R stara → nowa (138 różnych): to głównie dodane zapytania, np. `HondaTripActi` `100:1` → `100:1; 100:3` (ids 19, 41, 42, 59, 64, …).

## 6. Ostrzeżenie dla właściciela

- **Aktualizacja `com.syu.canbus` bez pasującego `com.syu.ms` zepsuje oryginalny ekran spalania:** ekran czyta wtedy `DATA[102]` zamiast `DATA[91]`, a `ms` nadal je wysyła pod starymi numerami. Z samych źródeł tej zależności nie da się sprawdzić, jest wniosek z zasady działania (`DATA[n]` to numer kodu `ms`).
- **Po aktualizacji obu kody auta zmienią się z 91/92 na 102/103.** Kody wpisane ręcznie w oknie „Kody canbus” (91 i 92) trzeba wtedy wyczyścić. Wybór pary w G4 robi to automatycznie tylko dla pustych pól: wpisany kod ma pierwszeństwo nad biblioteką.
- Biblioteka z pliku `canbus_library_2026-10-30_00-56-34.txt` **nie nadaje się do importu**: ma `RZC_BZ408EVMilePage1Acti` (`70:80`) jako pierwszą stronę, więc launcher wysłałby autu właściciela `70:80` zamiast `70:51; 29:0`. Trzeba ją wygenerować poprawionym skryptem z G1.

## 7. Rekomendacje (bez implementacji)

| # | propozycja | zakres | ryzyko |
|---|---|---|---|
| 1 | Przejrzeć 4 zapisy skanera (29-10) pod kątem kodu 137 (`U_ENGINE_SPEED` starej wersji). Skaner obejmuje cały zakres 0..1199, więc nic nie trzeba dodawać, wystarczy go znaleźć w istniejących plikach | analiza, bez kodu | brak |
| 2 | Okno „Kody canbus”: przy wpisanym kodzie, którego nie ma w żadnej parze biblioteki dla tego auta, pokazać ostrzeżenie „może pochodzić ze starej wersji `ms`” | `SettingsFragmentSecond` + 1 string | niskie; podpowiedź, nie blokada |
| 3 | Rozpoznanie wersji `ms` po kodzie, nie po numerze wersji: czytać `DATA[1000]` i sprawdzać, który z kodów pary daje wiarygodne wartości (to robi G4), zapisać wybór per car id | G4 | średnie, jeśli oba kody żyją naraz (para pierwsza wygrywa) |
| 4 | Generator: cztery grupy mają nadal remis przy wyborze strony głównej (`Golf7OilMileageIndexActi` / `...OD`, `BZ408OilMilePage1Acti` / `RZC_BZ408OilMilePage1Acti`, `GmAndraCarInfoTripA` / `TripB`), rozstrzyga alfabet. Jeśli ktoś ma takie auto, sprawdzić ręcznie, który ekran jest właściwy | `build_canbus_library.py`, klucz stron | średnie: zmiana klucza przestawia strony wielu aut |
| 5 | Przy aktualizacji assetu zachować `--diff stary nowy` w opisie commita; od teraz każda zmiana biblioteki ma dowód w liczbach | proces | brak |
| 6 | Pętla niezależna od aplikacji canbus: nie opierać się na `Callback_0339` ani na blokach 500–560 (p. 4.3), tylko na kodach z pary wybranej przez launcher | CanbusService | niskie |

## 8. Asset: stary → nowy

Zostanie dopisane w commicie G5 (tabela `--diff` starego assetu z nowym).
