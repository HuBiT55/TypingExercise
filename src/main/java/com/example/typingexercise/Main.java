package com.example.typingexercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.time.Duration;
import java.time.Instant;

public class Main extends Application {

    // Obiekty do ćwiczenia pisania
    private TypingExercise typingExercise = new TypingExercise();
    private Label sentenceLabel = new Label(); // Etykieta do wyświetlania zdania
    private TextField inputField = new TextField(); // Pole tekstowe do wpisywania
    private Button submitButton = new Button("Zatwierdź"); // Przycisk zatwierdzenia
    private Button resetButton = new Button("Reset"); // Przycisk resetowania
    private Label resultLabel = new Label(); // Etykieta do wyświetlania wyników
    private Instant startTime; // Czas rozpoczęcia wpisywania

    @Override
    public void start(Stage primaryStage) {
        // Tworzenie interfejsu graficznego
        VBox vbox = new VBox(10, sentenceLabel, inputField, submitButton, resetButton, resultLabel);
        Scene scene = new Scene(vbox, 600, 400);

        // Ustawienie obsługi zdarzeń
        inputField.setOnKeyPressed(this::handleKeyPress);
        submitButton.setOnAction(event -> handleSubmit());
        resetButton.setOnAction(event -> handleReset());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ćwiczenie pisania na klawiaturze");
        primaryStage.show();

        // Inicjalizacja ćwiczenia
        typingExercise.loadSentences("src/main/resources/sentences.txt");
        displayRandomSentence();
    }

    private void handleKeyPress(KeyEvent event) {
        // Obsługa zdarzeń klawiatury
        if (event.getCode() == KeyCode.ENTER) {
            handleSubmit(); // Zatwierdzenie przy wciśnięciu ENTER
        } else {
            if (startTime == null) {
                startTime = Instant.now(); // Ustawienie czasu rozpoczęcia wpisywania
                sentenceLabel.setText(""); // Ukrycie zdania po rozpoczęciu wpisywania
            }
        }
    }

    private void handleSubmit() {
        // Obsługa zatwierdzenia wpisanego tekstu
        if (startTime == null) {
            return; // Jeśli nie rozpoczęto wpisywania, nic nie rób
        }

        String typedText = inputField.getText(); // Pobranie wpisanego tekstu
        TypingResult result = typingExercise.evaluateInput(typedText); // Ocena wpisanego tekstu

        // Obliczenie czasu trwania wpisywania
        Duration duration = Duration.between(startTime, Instant.now());
        resultLabel.setText(result.getFormattedResult() + "\nCzas: " + duration.toSeconds() + " sekund");

        inputField.setEditable(false); // Zablokowanie dalszego wpisywania po zatwierdzeniu
        inputField.setOnKeyPressed(null); // Wyłączenie obsługi zdarzeń klawiatury
    }

    private void handleReset() {
        // Obsługa resetowania ćwiczenia
        inputField.clear(); // Wyczyść pole tekstowe
        resultLabel.setText(""); // Wyczyść etykietę wyników
        inputField.setEditable(true); // Odblokowanie pola tekstowego
        inputField.setOnKeyPressed(this::handleKeyPress); // Ponowne ustawienie obsługi zdarzeń klawiatury
        startTime = null; // Zresetowanie czasu rozpoczęcia
        displayRandomSentence(); // Wyświetlenie nowego zdania
    }

    private void displayRandomSentence() {
        // Wyświetlenie losowego zdania
        sentenceLabel.setText(typingExercise.getRandomSentence());
    }

    public static void main(String[] args) {
        launch(args); // Uruchomienie aplikacji
    }
}
