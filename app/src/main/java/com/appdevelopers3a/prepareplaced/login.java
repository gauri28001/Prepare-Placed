package com.appdevelopers3a.prepareplaced;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    Button signupbutton,loginbutton;

    TextInputLayout username_var,password_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        signupbutton = findViewById(R.id.REGISTER);
        loginbutton = findViewById(R.id.login);

        username_var = findViewById(R.id.username_text_field_design);
        password_var = findViewById(R.id.password_input_field);



        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = username_var.getEditText().getText().toString();
                String password = password_var.getEditText().getText().toString();

                if (!username.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if (!password.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);

                        final String username_data = username_var.getEditText().getText().toString();
                        final String password_data = password_var.getEditText().getText().toString();

                        FirebaseDatabase firebasedatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebasedatabase.getReference("datauser");

                        Query check_username = databaseReference.orderByChild("username").equalTo(username_data);

                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (dataSnapshot.exists()){
                                    username_var.setError(null);
                                    username_var.setErrorEnabled(false);
                                    String passwordcheck = dataSnapshot.child(username_data).child("password").getValue(String.class);
                                    if (passwordcheck.equals(password_data)){
                                        password_var.setError(null);
                                        password_var.setErrorEnabled(false);

                                        // getting data from firebase

                                        String email = dataSnapshot.child(username_data).child("email").getValue(String.class);
                                        String phone = dataSnapshot.child(username_data).child("phone").getValue(String.class);
                                        String username = dataSnapshot.child(username_data).child("username").getValue(String.class);
                                        String name = dataSnapshot.child(username_data).child("name").getValue(String.class);

                                        Intent intent = new Intent(getApplicationContext() ,Home.class);

                                        intent.putExtra("username",username);
                                        intent.putExtra("email",email);
                                        intent.putExtra("phone",phone);
                                        intent.putExtra("name",name);

                                        Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_SHORT).show();

                                        startActivity(intent);
                                        finish();


                                    }else {
                                        password_var.setError("Wrong password");
                                    }
                                }else {
                                    username_var.setError("Incorrect username");
                                }


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                    }else {
                        password_var.setError("please enter the password");
                    }
                }else {
                    username_var.setError("please enter the username");
                }


            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);

            }
        });




    }
}