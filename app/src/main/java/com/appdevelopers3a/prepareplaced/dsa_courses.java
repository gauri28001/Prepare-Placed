package com.appdevelopers3a.prepareplaced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class dsa_courses extends AppCompatActivity {

    CardView dsaCard1;
    CardView dsaCard2;
    CardView dsaCard3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsa_courses);

        dsaCard1 = findViewById(R.id.dsa1);
        dsaCard2 = findViewById(R.id.dsa2);
        dsaCard3 = findViewById(R.id.dsa3);

        dsaCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA")));
            }
        });

        dsaCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop")));
            }
        });

        dsaCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("https://www.youtube.com/playlist?list=PLu0W_9lII9ahIappRPN0MCAgtOu3lQjQi")));
            }
        });
    }
}