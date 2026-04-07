package com.example.quizzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TopicAdapter adapter;
    private String titleQuestions;
    private List<Question> questions;
    private int numberQuestion = 0;
    private int numCorrectAnswer = 0;
    private TextView titleQuiz;
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
        this.titleQuestions = getIntent().getStringExtra("TOPIC_TITLE");
        this.titleQuestions = (this.titleQuestions == null) ? "Заголовка нет" : this.titleQuestions;
        this.questions = (List<Question>) getIntent().getSerializableExtra("QUESTIONS_LIST");
        this.questions = (this.questions == null) ? new ArrayList<Question>() : this.questions;

        titleQuiz = findViewById(R.id.titleQuiz);
        titleQuiz.setText(titleQuestions);
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
