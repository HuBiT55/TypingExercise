package com.example.typingexercise;

public class TypingResult {

    private final String formattedResult;
    private final double errorPercentage;

    public TypingResult(String formattedResult, double errorPercentage) {
        this.formattedResult = formattedResult;
        this.errorPercentage = errorPercentage;
    }

    public String getFormattedResult() {
        return String.format("Result: %s\nErrors: %.2f%%", formattedResult, errorPercentage);
    }
}
