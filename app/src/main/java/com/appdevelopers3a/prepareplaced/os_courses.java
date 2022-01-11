package com.appdevelopers3a.prepareplaced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class os_courses extends AppCompatActivity {

    CardView osCard1;
    CardView osCard2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_courses);

        osCard1 = findViewById(R.id.os1);
        osCard2 = findViewById(R.id.os2);


        osCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLxCzCOWd7aiGz9donHRrE9I3Mwn6XdP8p")));
            }
        });

        osCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLEbnTDJUr_IfenRWZ73RPWNFTeGaqYQ8T")));
            }
        });

    }
}