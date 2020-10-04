package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    Button calllogin;
    EditText regName,regUsername,regPassword,regPhoneNo,regDistrict;
    Button regbtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_signup);


        regName=findViewById(R.id.reg_name);
        regUsername=findViewById(R.id.reg_username);
        regPassword=findViewById(R.id.reg_password);
        regPhoneNo=findViewById(R.id.reg_phoneNo);
        regDistrict=findViewById(R.id.reg_district);
        regbtn=findViewById(R.id.reg_btn);

        rootNode = FirebaseDatabase.getInstance();
        reference=rootNode.getReference("users");

        /*regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = regName.getEditableText().toString();
                String username=regUsername.getEditableText().toString();
                String district = regDistrict.getEditableText().toString();
                String phoneNo= regPhoneNo.getEditableText().toString();
                String password= regPassword.getEditableText().toString();


                userHelperClass helperClass = new userHelperClass(name,username,district,phoneNo,password);


                reference.child(phoneNo).setValue(helperClass);


            }
        });*/

        calllogin = findViewById(R.id.login_screen);

        calllogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this,login.class);
                startActivity(intent);
            }
        });
    }



        private Boolean validateName () {

            String val = regName.getEditableText().toString();

            if (val.isEmpty()) {
                regName.setError("Field Cannot be Empty");
                return false;
            } else {
                regName.setError(null);
                regName.setEnabled(false);
                return true;
            }
        }

        private Boolean validateUsername () {

            String val = regUsername.getEditableText().toString();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if (val.isEmpty()) {
                regUsername.setError("Field Cannot be Empty");
                return false;

            } else if (!val.matches(emailPattern)) {
                regUsername.setError("Invalid email Address");
                return false;
            } else {
                regUsername.setError(null);
                regUsername.setEnabled(false);
                return true;
            }
        }

        private Boolean validatePassword () {

            String val = regPassword.getEditableText().toString();
            String passwordVal =  "^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$";

            if (val.isEmpty()) {
                regPassword.setError("Field Cannot be Empty");
                return false;
            } else if (!val.matches(passwordVal)) {
                regPassword.setError("Password is too Weak");
                return false;
            } else {
                regPassword.setError(null);
                regPassword.setEnabled(false);
                return true;
            }
        }

        private Boolean validatePhoneno () {

            String val = regPhoneNo.getEditableText().toString();

            if (val.isEmpty()) {
                regPhoneNo.setError("Field Cannot be Empty");
                return false;
            } else if (val.length() == 11) {
                regPhoneNo.setError("Phone Number is too Long");
                return false;
            } else {
                regPhoneNo.setError(null);
                regPhoneNo.setEnabled(false);
                return true;
            }
        }

        private Boolean validateDistrict () {

            String val = regDistrict.getEditableText().toString();

            if (val.isEmpty()) {
                regDistrict.setError("Field Cannot be Empty");
                return false;
            } else {
                regDistrict.setError(null);
                regDistrict.setEnabled(false);
                return true;
            }
        }


        public void registerUser (View view){

            if (!validateName() | !validateUsername() | !validatePassword() | !validatePhoneno() | !validateDistrict()) {

                return;
            }


            String name = regName.getEditableText().toString();
            String username = regUsername.getEditableText().toString();
            String district = regDistrict.getEditableText().toString();
            String phoneNo = regPhoneNo.getEditableText().toString();
            String password = regPassword.getEditableText().toString();

            userHelperClass helperClass = new userHelperClass(name, username, district, phoneNo, password);
            reference.child(phoneNo).setValue(helperClass);

            Toast.makeText(signup.this, R.string.signupsuc,Toast.LENGTH_LONG).show();
        }

}