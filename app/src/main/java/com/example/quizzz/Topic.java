package com.example.quizzz;

import java.util.List;

public class Topic {
    private String title;
    private String description;
    private List<Question> listQuestions;

    public void addQuestion(Question nowQuestions){
        listQuestions.add(nowQuestions);
    }
}
