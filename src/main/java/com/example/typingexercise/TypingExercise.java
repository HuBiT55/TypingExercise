package com.example.typingexercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class TypingExercise {

    private List<String> sentences;
    private String currentSentence;

    public void loadSentences(String filePath) {
        try {
            sentences = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomSentence() {
        Random random = new Random();
        currentSentence = sentences.get(random.nextInt(sentences.size()));
        return currentSentence;
    }

    public TypingResult evaluateInput(String input) {
        int errors = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < currentSentence.length(); i++) {
            if (i < input.length() && currentSentence.charAt(i) == input.charAt(i)) {
                result.append(currentSentence.charAt(i));
            } else {
                result.append('[').append(input.length() > i ? input.charAt(i) : '_').append(']');
                errors++;
            }
        }

        double errorPercentage = (errors / (double) currentSentence.length()) * 100;
        return new TypingResult(result.toString(), errorPercentage);
    }
}
