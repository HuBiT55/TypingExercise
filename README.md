# Ćwiczenie pisania na klawiaturze

## Spis treści
1. [Opis projektu](#opis-projektu)
2. [Funkcjonalności](#funkcjonalności)
3. [Instrukcja obsługi](#instrukcja-obsługi)
4. [Wymagania](#wymagania)
5. [Instalacja](#instalacja)
6. [Uruchomienie](#uruchomienie)
7. [Przykładowe dane wejściowe](#przykładowe-dane-wejściowe)

## Opis projektu
Projekt "Ćwiczenie pisania na klawiaturze" to aplikacja desktopowa, która pomaga użytkownikom poprawić swoje umiejętności pisania na klawiaturze. Program wczytuje bazę zdań z pliku, a następnie wyświetla losowo wybrane zdanie do przepisania przez użytkownika. Użytkownik nie widzi wpisywanego tekstu, a po zakończeniu wpisywania i wciśnięciu klawisza Enter, program porównuje wpisany tekst z oryginalnym, podkreśla błędy i oblicza procent błędów. Projekt wykonywany był na studia, stąd w całym kodzie pododawane są komentarze :)

## Funkcjonalności
- Wczytywanie bazy zdań z pliku.
- Wyświetlanie losowo wybranego zdania do przepisania.
- Ukrywanie wpisywanego tekstu.
- Wyświetlanie wpisanego tekstu po wciśnięciu Enter.
- Podkreślanie błędów w przepisanym tekście.
- Obliczanie i wyświetlanie procentowej ilości błędów.
- Mierzenie czasu przepisywania zdania.
- Możliwość ponownego przepisania zdania po zakończeniu.

## Instrukcja obsługi
1. Uruchom aplikację.
2. Program wczyta bazę zdań z pliku `sentences.txt`.
3. Na ekranie pojawi się jedno z zdań do przepisania.
4. Przepisz zdanie (tekst nie będzie widoczny na ekranie).
5. Po wciśnięciu Enter, program wyświetli wpisany tekst, podkreśli błędy oraz wyświetli procentową ilość błędów i czas przepisywania.
6. Użytkownik może wybrać, czy chce spróbować ponownie.

## Wymagania
- Java Development Kit (JDK) 11 lub nowszy
- Biblioteki zewnętrzne:
  - [JavaFX](https://openjfx.io/) do stworzenia interfejsu graficznego

## Instalacja
1. Pobierz i zainstaluj [JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Pobierz i zainstaluj [JavaFX](https://openjfx.io/).
3. Sklonuj repozytorium:
   ```
   git clone https://github.com/yourusername/typing-exercise.git
   ```
4. Przejdź do katalogu projektu:
   ```
   cd typing-exercise
   ```

## Uruchomienie
1. Skompiluj projekt:
   ```
   javac --module-path /path/to/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml src/main/java/com/example/typingexercise/*.java
   ```
2. Uruchom aplikację:
   ```
   java --module-path /path/to/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml com.example.typingexercise.Main
   ```

## Przykładowe dane wejściowe
- Plik `sentences.txt` zawierający przykładowe zdania (w tym przypadku dodałem pare łamańców językowych :) )
  ```
   Trenujemy szybkość pisania na klawiaturze.
  Jestem Mateusz, a Ty jak się nazywasz?
  Czytasz to zdanie szybciej niż piszesz?
  Lubię programować
  W Szczebrzeszynie chrząszcz brzmi w trzcinie
  Nie pieprz wieprza pieprzem Pietrze, bo bez pieprzu wieprz jest lepszy
  Baba bada baobaby. Baba dba o oba baobaby
  Wylaminowana i wyemaliowana iluminacja
  I wespół w zespół by żądz moc móc zmóc
  W czasie suszy szosa sucha
  ```
