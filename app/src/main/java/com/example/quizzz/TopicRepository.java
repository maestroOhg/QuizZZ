package com.example.quizzz;

import java.util.Arrays;
import java.util.List;

public class TopicRepository {

    private static TopicRepository instance;
    private TopicRepository(){}

    public static synchronized TopicRepository getInstance() {
        if (instance == null) {
            instance = new TopicRepository();
        }
        return instance;
    }

    public final List<Topic> getTopics(){
        return Arrays.asList(new Topic("Переменные, типы данных и операторы","wdad",getDataTypes()),
                new Topic("Циклы","Циклы",getCycle()));
    }
    public final List<Question> getDataTypes(){
        return Arrays.asList(new Question("Как обозначается целочисленный тип данных", "int",
                new String[]{"int,double,boolean"}));
    }
    public final List<Question> getCycle(){
        return Arrays.asList(new Question("Что произойдет, если условие цикла while изначально имеет значение False","Цикл не выполнится",
                new String[]{"Цикл не выполнится","Выполнится один раз","Будет выполняться бесконечно"}));
    }
}
