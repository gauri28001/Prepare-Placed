package com.appdevelopers3a.prepareplaced;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.File;

public class Home extends AppCompatActivity {

    TextView fullname , username  ;
    TextInputLayout username_edit , fullname_edit , phonenumbr_edit ,email_edit;

    String user_username , user_fullname ,user_email ,user_phoneno ;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // create firebase database

        reference = FirebaseDatabase.getInstance().getReference("datauser");

        fullname = findViewById(R.id.FullName);
        username = findViewById(R.id.UserName);

//        TextInputEditText fullname_edit = (TextInputEditText)findViewById(R.id.FullNameEdit);
//        TextInputEditText username_edit = (TextInputEditText)findViewById(R.id.UserNameEdit);
//        TextInputEditText phonenumbr_edit = (TextInputEditText)findViewById(R.id.PhoneNoEdit);
//        TextInputEditText email_edit = (TextInputEditText)findViewById(R.id.EmailEdit);

        fullname_edit = findViewById(R.id.FullNameEdit);
        username_edit = findViewById(R.id.UserNameEdit);
        phonenumbr_edit = findViewById(R.id.PhoneNoEdit);
        email_edit = findViewById(R.id.EmailEdit);

        // show all data
        gettingdata();


        //Initialize and assign value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

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
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), Job.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }

    private void gettingdata() {

        Intent intent = getIntent();

        //make all variable global

        user_fullname = intent.getStringExtra("name");
        user_username = intent.getStringExtra("username");
        user_email = intent.getStringExtra("email");
        user_phoneno = intent.getStringExtra("phone");

        // updated data will show here

        fullname.setText(user_fullname);
        username.setText(user_username);



        fullname_edit.getEditText().setText(user_fullname);
        username_edit.getEditText().setText(user_username);
        email_edit.getEditText().setText(user_email);
        phonenumbr_edit.getEditText().setText(user_phoneno);


    }


    public void update_button_click(View view) {
        if(namechange() || phonenumberChange() || emailChange()){
            Toast.makeText(this,"Data updated successfully" ,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No changes detected" ,Toast.LENGTH_SHORT).show();
        }
    }

    private boolean emailChange() {
        if(!user_email.equals(email_edit.getEditText().getText().toString())){
            reference.child(user_username).child("email").setValue(email_edit.getEditText().getText().toString());
            user_email = email_edit.getEditText().getText().toString();
            return true;
        }else
        {
            return false;
        }
    }

    private boolean namechange() {
        if(!user_fullname.equals(fullname_edit.getEditText().getText().toString())){
            reference.child(user_username).child("name").setValue(fullname_edit.getEditText().getText().toString());
            user_fullname = fullname_edit.getEditText().getText().toString();
            fullname.setText(fullname_edit.getEditText().getText().toString());
            return true;
        }else
        {
            return false;
        }
    }
    private boolean phonenumberChange() {
        if(!user_phoneno.equals(phonenumbr_edit.getEditText().getText().toString())){
            reference.child(user_username).child("phone").setValue(phonenumbr_edit.getEditText().getText().toString());
            user_phoneno = phonenumbr_edit.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }

}