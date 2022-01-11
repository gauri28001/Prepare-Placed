package com.appdevelopers3a.prepareplaced;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Prepare extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<CourseModel> courseModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);

        //Initialize and assign value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        // Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.dashboard:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), Job.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        // code to display on screen

        recyclerView = findViewById(R.id.recyclerView);

        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("Data Structure and Algorithms",4,R.drawable.dsa,"dsa")) ;
        courseModelArrayList.add(new CourseModel("Java Course",3,R.drawable.java_image1,"java"));
        courseModelArrayList.add(new CourseModel("C++ Course",4,R.drawable.cpp1,"cpp"));
        courseModelArrayList.add(new CourseModel("DBMS",4,R.drawable.dbms,"dbms"));
        courseModelArrayList.add(new CourseModel("Computer Networks Course",4,R.drawable.cn,"cn"));
        courseModelArrayList.add(new CourseModel("Operating System Course",4,R.drawable.os3,"os"));

        CourseAdapter courseAdapter = new CourseAdapter(this,courseModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(courseAdapter);
    }
}