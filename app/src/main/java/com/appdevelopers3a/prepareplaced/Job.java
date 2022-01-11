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
import java.util.List;

public class Job extends AppCompatActivity {

    RecyclerView recyclerView ;
    List<JobModel> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        //Initialize and assign value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.about);

        // Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), Prepare.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        return true;
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.recycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        courseList = new ArrayList<>();
        courseList.add(new JobModel(R.drawable.infosys , "Infosys", "SDE-1" , "https://www.infosys.com/careers.html"));
        courseList.add(new JobModel(R.drawable.wipro , "Wipro", "Software developer" ,"https://careers.wipro.com/careers-home/" ));
        courseList.add(new JobModel(R.drawable.accenture , "Accenture", "Senior analyst" , "https://www.accenture.com/in-en/careers"));
        courseList.add(new JobModel(R.drawable.ibm , "IBM", "Associate Engineer" , "https://www.ibm.com/in-en/employment/"));
        courseList.add(new JobModel(R.drawable.gs , "Goldman Sachs", "SDE-II" ,"https://www.goldmansachs.com/careers/" ));
        courseList.add(new JobModel(R.drawable.persistent , "Persistent", "Java developer" , "https://www.persistent.com/careers/" ));
        courseList.add(new JobModel(R.drawable.cognizant , "Cognizant", "front-end intern" ,"https://careers.cognizant.com/professionals/global/en" ));
        courseList.add(new JobModel(R.drawable.microsoft , "Microsoft", "Full stack developer " ,"https://careers.microsoft.com/us/en" ));
        courseList.add(new JobModel(R.drawable.amazon , "Amazon", "SDE-Role" , "https://www.amazon.jobs/en/teams/in"));
        courseList.add(new JobModel(R.drawable.tcs, "TCS", "specialised programmer" , "https://www.tcs.com/blogs/tcs-careers" ));



        JobAdapter adapter = new JobAdapter(courseList , this );
        recyclerView.setAdapter(adapter);



    }
}