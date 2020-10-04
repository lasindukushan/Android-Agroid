package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    Button callsignup;
    //********************************
    Button dashb;
    ImageButton Admin;
    EditText emails,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_login);

        emails=findViewById(R.id.logemail);
        pass=findViewById(R.id.pwd);

        callsignup = findViewById(R.id.signup_screen);

        callsignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,signup.class);
                startActivity(intent);



                dashb = findViewById(R.id.adminlogin);

            }
        });


        Admin = findViewById(R.id.admin);

        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(login.this, admin_login.class);
                startActivity(intent1);
            }
        });
    }


    public Boolean validateUsername () {

        String val = emails.getEditableText().toString();

        if (val.isEmpty()) {
            emails.setError("Field Cannot be Empty");
            return false;

        }
         else {
            emails.setError(null);
            emails.setEnabled(false);
            return true;
        }
    }

    public Boolean validatePassword () {

        String val = pass.getEditableText().toString();

        if (val.isEmpty()) {
            pass.setError("Field Cannot be Empty");
            return false;
        }  else {
            pass.setError(null);
            pass.setEnabled(false);
            return true;
        }
    }

    public void loginUser(View view){

        if(!validateUsername() | !validatePassword()){
            return;
        }
        else{
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredEmail = emails.getEditableText().toString().trim();
        final String userEnteredPassword = pass.getEditableText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("phoneNo").equalTo(userEnteredEmail);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                if(datasnapshot.exists()){

                    emails.setError(null);
                    emails.setEnabled(false);

                    String passwordFromDB = datasnapshot.child(userEnteredEmail).child("password").getValue(String.class);
                    if(passwordFromDB.equals(userEnteredPassword)){

                        emails.setError(null);
                        emails.setEnabled(false);

                                Intent intent = new Intent(login.this,Dashboard.class);
                                startActivity(intent);
                    }else{
                        pass.setError("Wrong Password");
                        pass.requestFocus();
                    }
                }
                else{
                    emails.setError("No Such User exist");
                    emails.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
