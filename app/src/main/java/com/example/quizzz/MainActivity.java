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

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private TopicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listView);

        // 2. Получаем данные из репозитория
        List<Topic> topics = TopicRepository.getInstance().getTopics();

        // 3. Создаём адаптер и передаём в него контекст и список
        adapter = new TopicAdapter(this, topics);

        // 4. Привязываем адаптер к списку
        listView.setAdapter(adapter);

        // 5. Обрабатываем клик по элементу списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Получаем выбранную тему
                Topic selectedTopic = topics.get(position);

                // Переход к экрану квиза
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.putExtra("TOPIC_TITLE", selectedTopic.getTitle());
                // Передаём список вопросов (требуется, чтобы Question реализовывал Serializable)
                intent.putExtra("QUESTIONS_LIST", new java.util.ArrayList<>(selectedTopic.getQuestions()));

                startActivity(intent);
            }
            });
        }
    }