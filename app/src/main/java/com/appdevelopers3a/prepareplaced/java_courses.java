package com.appdevelopers3a.prepareplaced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class java_courses extends AppCompatActivity {

    CardView javaCard1;
    CardView javaCard2;
    CardView javaCard3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_courses);

        javaCard1 = findViewById(R.id.java1);
        javaCard2 = findViewById(R.id.java2);
        javaCard3 = findViewById(R.id.java3);

        javaCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s")));
            }
        });

        javaCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLX9Zi6XTqOKQ7TdRz0QynGIKuMV9Q2H8E")));
            }
        });

        javaCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLu0W_9lII9agS67Uits0UnJyrYiXhDS6q")));
            }
        });

    }
}