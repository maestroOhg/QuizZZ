package com.example.quizzz;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final String title;
    private final String description;
    private final List<Question> questions;

    public Topic(String title, String description, List<Question> questions) {
        this.title = title;
        this.description = description;
        this.questions = questions != null ? questions : new ArrayList<>();
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<Question> getQuestions() { return questions; }
}
