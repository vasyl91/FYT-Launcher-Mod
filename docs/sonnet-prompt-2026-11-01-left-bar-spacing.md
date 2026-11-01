# Launcher Mod: odstępy paska bocznego zależne od orientacji: instrukcja wykonawcza

Pracujesz w repozytorium `vasyl91/FYT-Launcher-Mod`, na gałęzi `ccr-087eed00-gbqsuz`. Zacznij od `git pull origin ccr-087eed00-gbqsuz`.
Commit, którego dotyczy poprawka: `ca24b41c` („Bars: slot count follows the room the icons need”). Numery linii są orientacyjne (≈).

Zasady:
- **Jeden commit** z kodem i testem.
- Push dopiero przy zielonym poprzednim runie CI; potem pilnujesz CI swojego commitu.
- **Nie twórz pull requesta.**
- Komentarze, Javadoc, `Log.*` i opis commitu **wyłącznie po angielsku**.

## 0. Skąd ta zmiana

### 0.1 Objaw
Na telefonie (portrait, 2340×1080, 450 dpi) pasek boczny wygląda dobrze. Na FYT (landscape, 2000×1200, 240 dpi) pasek dolny jest w porządku, ale boczny jest upakowany za gęsto: za dużo ikon, za małe odstępy.

### 0.2 Przyczyna: orientacja, nie gęstość ekranu
Cały rachunek jest w pikselach jako ułamek wymiarów, więc dpi nie gra roli. Różnica bierze się z kształtu elementu `res/layout-{port,land}/item_left_app_list.xml`:
- ikona to `ImageView` z `layout_constraintWidth_percent="0.7394"` i `scaleType="fitCenter"`, więc widoczna ikona to kwadrat o boku ≈ 0,7394 × szerokość paska, w obu orientacjach;
- **pion**: `layout_constraintDimensionRatio="1:1.7"` – element ma wysokość 1,7 × ikona, czyli ma w sobie ~0,7 ikony pustego miejsca;
- **poziom**: `1:1` – element jest równy ikonie, bez zapasu.

`BarCapacity.leftCapacity(height, naturalItemHeight)` (≈ l. 166) liczy `floor(H / (natural × 1.25))`, gdzie `natural` to zmierzona wysokość **elementu** (`EvenVerticalLayoutManager.measureChildWithMargins()`, Launcher.java ≈ l. 9012). Reguła „odstęp ≥ 25 %” dotyczy więc pudełka, nie widocznej ikony:
- w pionie widoczny odstęp to ≥ 0,25 × 1,7 + 0,7 ≈ 1,1 ikony;
- w poziomie to tylko 0,25 ikony.

Rachunek dla rzeczywistych układów (szerokość paska `0.071`, `W,0.071` w pionie; wysokość = ekran − status bar − pasek dolny):

| Urządzenie | H paska | ikona | dziś: sloty / widoczny odstęp | po poprawce |
|---|---|---|---|---|
| telefon portrait 1080×2340 | ≈ 2119 px | ≈ 110 px | 9 / ≈ 109 % ikony | 9 / ≈ 109 % (bez zmian) |
| FYT landscape 2000×1200 | ≈ 974 px | ≈ 104 px | 7 / ≈ 29 % | 5 / ≈ 72 % |
| FYT landscape 1280×720 | ≈ 582 px | ≈ 66 px | 7 / ≈ 23 % | 5 / ≈ 64 % |

Pasek dolny działa poprawnie, bo tam „ikona” w regule to dokładnie rozmiar `ImageView` (`BarCapacity.bottomIconSize()`). Pasek dolny zostaje bez zmian.

### 0.3 Czego chce właściciel
Pasek boczny ma w każdej orientacji wyglądać tak jak dziś w pionie na telefonie. Reguła pojemności liczy się więc od **widocznej ikony** z rozstawem dobranym tak, żeby pion dał dokładnie dzisiejszy wynik.

## 1. Zmiany

### 1.1 `app/src/main/java/com/android/launcher66/BarCapacity.java`
- Dodaj stałą `LEFT_ICON_WIDTH_PERCENT = 0.7394f`. Komentarz: musi odpowiadać `layout_constraintWidth_percent` ikony w obu `item_left_app_list.xml`.
- Dodaj stałą `LEFT_MIN_ICON_PITCH = MIN_SLOT_PITCH * 1.7f` (= 2,125). Komentarz po angielsku:
  - to minimalny rozstaw liczony od widocznej ikony;
  - 1,7 to proporcja pionowego elementu, którą właściciel uznał za właściwą;
  - poziom (1:1) dostaje ten sam widoczny odstęp.

  To jedyne miejsce do strojenia.
- `leftCapacity(int height, int naturalItemHeight)` zastąp przez `leftCapacity(int height, int iconSize)`:
  - wzór: `floor(height / (iconSize × LEFT_MIN_ICON_PITCH) + CAPACITY_EPSILON)`;
  - clamp do `[MIN_LEFT_SLOTS, LEFT_MEMORY]` jak dziś;
  - log: `left: available=… icon=… pitch=2.125 capacity=…`, dalej przez `logOnce(true, …)`.
- Dodaj czystą metodę `leftIconSize(int recyclerInnerWidth)`, zwracającą `(int) (recyclerInnerWidth * LEFT_ICON_WIDTH_PERCENT)`.
- Popraw Javadoc klasy i metody, bo mówią dziś o „item height”.

### 1.2 `app/src/main/java/com/android/launcher66/Launcher.java`, `EvenVerticalLayoutManager` (≈ l. 8807)
- Pojemność ma zależeć od **szerokości** recyclera, a nie od `mNaturalItemHeight`:
  - `iconSize = BarCapacity.leftIconSize(width − paddingLeft − paddingRight)`;
  - padding poziomy bierzesz z `mHost`; LM ustawia tylko padding pionowy.
- `checkCapacity(int total)` → `checkCapacity(int width, int height)`. Wywołania:
  - `applySpacing(total)` (≈ l. 8971): przekaż szerokość, na przykład `getWidth()`; gdy jest 0, użyj `mHost.getMeasuredWidth()`;
  - `onLayoutCompleted()` (≈ l. 9045): `getWidth()`, `getHeight()`.
- Warunek wejścia w `checkCapacity` przestaje wymagać `mNaturalItemHeight > 0`; wymaga `width > 0 && height > 0`.
- `mCapacityCheck`: licz z `mHost.getWidth()` i `mHost.getHeight()` (ustalony rozmiar). W logu `EvenVerticalLM` podaj `W`, `H`, `icon`.
- Klucze pojemności `left_bar_capacity_port/_land` zmień na `left_bar_capacity_port_v2/_land_v2`. Stare wartości zostały policzone starą regułą: na FYT zapisane 7 dałoby po starcie snapshot z 7 ikonami i skok do 5. Starych kluczy nie czytaj; usuwaj je w `invalidateItemMetrics()`.
- **Bez zmian**:
  - matematyka `applySpacing()`: `count = min(itemCount, maxItems)`, `gap`, `edge`, `mSlotHeight` – `mNaturalItemHeight` dalej służy do odstępów;
  - pomiar naturalnej wysokości i jej cache per orientacja;
  - `setMaxItems()`, listener, `post` i ochrona przed pętlą.
- Kontrola cache wysokości: po wczytaniu `mNaturalItemHeight` i znanej szerokości policz oczekiwane pudełko `icon × (portrait ? 1.7 : 1.0)`. Gdy cache różni się o więcej niż 2 px:
  - `Log.w` z obiema wartościami;
  - jednorazowo (flaga na instancję) wyzeruj `mNaturalItemHeight` dla bieżącej orientacji i pozwól mu się zmierzyć w `measureChildWithMargins()`;
  - nie usuwaj wartości drugiej orientacji.

  Stała 1,7 / 1,0 trafia do `BarCapacity` (`LEFT_ITEM_RATIO_PORTRAIT/LANDSCAPE`) z komentarzem, że musi zgadzać się z XML.

### 1.3 `LauncherAppBars.java`
Nie wymaga zmian logiki: `leftCapacity()` korzysta z `EvenVerticalLayoutManager.loadCapacity()`, która przechodzi na nowe klucze. Sprawdź tylko, że nic poza LM nie woła `BarCapacity.leftCapacity()` (`grep`).

### 1.4 Nie ruszaj
- paska dolnego: `bottomCapacity`, `bottomIconSize`, `AppListAdapter`, dekoracji;
- prune po odinstalowaniu;
- `LEFT_MEMORY = 12`, `MIN_LEFT_SLOTS = 5`;
- sygnatur snapshotów – pojemność już w nich jest, więc jeden snapshot po aktualizacji zostanie odrzucony, i tak ma być.

## 2. Test JVM: `app/src/test/java/com/android/launcher66/BarCapacityTest.java`
JUnit 5 jak pozostałe testy. `unitTests.isReturnDefaultValues = true`, więc `Log.d` nie przeszkadza. Testuj tylko czyste metody paska bocznego. Nie testuj `bottomCapacity`: sięga do `Launcher.screenWidth`, a załadowanie klasy `Launcher` w JVM jest ryzykowne.

Przypadki:
- `leftCapacity(2119, 110) == 9`: telefon w pionie, wynik jak przed poprawką;
- `leftCapacity(974, 104) == 5`: FYT 2000×1200 w poziomie;
- `leftCapacity(582, 66) == 5`: FYT 1280×720 w poziomie;
- dolna i górna granica: `leftCapacity(100, 104) == 5`, `leftCapacity(10000, 50) == 12`;
- brak danych: `leftCapacity(0, 104) == 5` i `leftCapacity(974, 0) == 5`;
- tolerancja na całkowitej granicy: `iconSize = 100`, `height = 850` (dokładnie 4 rozstawy po 212,5) → 5 przez clamp; drugi przypadek dokładnie na 6 rozstawach (`height = 1275`) → 6;
- `leftIconSize(142) == 104` i `leftIconSize(150) == 110`.

## 3. Weryfikacja
- CI: `Unit tests` oraz oba buildy debug zielone.
- Na urządzeniach (właściciel), logi z tagami `BarCapacity` i `EvenVerticalLM`:
  - telefon w pionie: `capacity=9`, wygląd bez zmian;
  - FYT 2000×1200 w poziomie: `capacity=5`, odstęp ok. 0,7 ikony;
  - obrót na telefonie: w poziomie ten sam widoczny odstęp co w pionie (zwykle 5 przez clamp);
  - zmiana wysokości paska dolnego: pojemność bocznego przelicza się bez pętli (jedna linia `capacity a -> b`);
  - start po aktualizacji: brak migania 7 → 5 (nowe klucze).
- Przed commitem przejrzyj diff: tylko angielski w kodzie, brak zmian w pasku dolnym i w prune, `applySpacing()` liczy jak wcześniej.

## 4. Commit
Opis po angielsku, np. „Left bar: capacity from the visible icon, the same spacing in both orientations”. W treści:
- przyczyna (pudełko 1:1.7 wobec 1:1);
- wzór (`LEFT_MIN_ICON_PITCH = 2.125`);
- nowe klucze `_v2`;
- liczby z tabeli w 0.2.

Na końcu linie atrybucji z bieżącej sesji.
