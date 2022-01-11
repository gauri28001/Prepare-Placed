package com.appdevelopers3a.prepareplaced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {

    TextInputLayout fullname_var ,username_var,email_var,phone_var,password_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname_var = findViewById(R.id.enter_fullname);
        username_var = findViewById(R.id.enter_username);
        email_var = findViewById(R.id.Email);
        phone_var = findViewById(R.id.phone_number);
        password_var = findViewById(R.id.password);
    }

    public void loginbuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(),login.class);
        startActivity(intent);
        finish();
    }

    public void registerbuttonclick(View view) {

        String fullname = fullname_var.getEditText().getText().toString();
        String username = username_var.getEditText().getText().toString();
        String email = email_var.getEditText().getText().toString();
        String phone = phone_var.getEditText().getText().toString();
        String password = password_var.getEditText().getText().toString();


        if(!fullname.isEmpty()){
           fullname_var.setError(null);
           fullname_var.setErrorEnabled(false);
        if (username.isEmpty()) {
            username_var.setError("please enter the username");
        } else {
            username_var.setError(null);
            username_var.setErrorEnabled(false);
            if (!email.isEmpty()){
                email_var.setError(null);
                email_var.setErrorEnabled(false);
                if (!phone.isEmpty()){
                    phone_var.setError(null);
                    phone_var.setErrorEnabled(false);
                    if(!password.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);
                        if (!email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")){

                        firebaseDatabase = FirebaseDatabase.getInstance();
                        reference = firebaseDatabase.getReference("datauser");

                            String fullname_s = fullname_var.getEditText().getText().toString();
                            String username_s = username_var.getEditText().getText().toString();
                            String email_s = email_var.getEditText().getText().toString();
                            String phone_s = phone_var.getEditText().getText().toString();
                            String password_s = password_var.getEditText().getText().toString();

                            storingdata storingdatass = new storingdata(fullname_s ,username_s,email_s,phone_s,password_s);

                            reference.child(username_s).setValue(storingdatass);
                            Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), Home.class);

                            // get data from firebase

                            intent.putExtra("name",fullname_s);
                            intent.putExtra("email", email_s);
                            intent.putExtra("username",username_s);
                            intent.putExtra("phone",phone_s);

                            startActivity(intent);
                            finish();


                        }else {
                            email_var.setError("Invalid Email");
                        }

                    }else {
                        password_var.setError("please enter the password");
                    }

                }else {
                    phone_var.setError("please enter the phone number");
                }

            }else {
                email_var.setError("please enter the email");

            }

        }
        }else {
            fullname_var.setError("Please enter the full name");
        }

    }
}