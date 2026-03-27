package com.example.quizzz;

public class Question {
    private final String textQuestion;
    private final String correctAnswer;
    private final String[] allAnswer;

    public Question(String textQuestion, String correctAnswer, String[] allAnswer) {
        this.textQuestion = textQuestion;
        this.correctAnswer = correctAnswer;
        this.allAnswer = allAnswer;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getAllAnswer() {
        return allAnswer;
    }
}
