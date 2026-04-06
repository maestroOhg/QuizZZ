package com.example.quizzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    ListView listView;
    private TopicAdapter adapter;
    private String titleQuestion;
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.question_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quiz), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.titleQuestion = getIntent().getStringExtra("TOPIC_TITLE");
        this.titleQuestion = (this.titleQuestion == null) ? "Заголовка нет" : this.titleQuestion;
        {
            if ((List<Question>) getIntent().getSerializableExtra("QUESTIONS_LIST") == null) this.questions = new ArrayList<Question>();
            else{
                this.questions = (List<Question>) getIntent().getSerializableExtra("QUESTIONS_LIST");
        }
//        // 5. Обрабатываем клик по элементу списка
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Получаем выбранную тему
//                Topic selectedTopic = topics.get(position);
//
//                // Переход к экрану квиза
//                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
//                intent.putExtra("TOPIC_TITLE", selectedTopic.getTitle());
//                // Передаём список вопросов (требуется, чтобы Question реализовывал Serializable)
//                intent.putExtra("QUESTIONS_LIST", new java.util.ArrayList<>(selectedTopic.getQuestions()));
//                startActivity(intent);
//            }
//        });
    }
}
