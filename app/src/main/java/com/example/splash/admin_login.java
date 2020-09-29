package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class admin_login extends AppCompatActivity {

    /*Button login;*/
    private EditText Name;
    private EditText Password;
    private TextView info;
    private Button login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_admin_login);

        Name = (EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        info=(TextView)findViewById(R.id.tvInfo);
        login=(Button)findViewById(R.id.adminlogin);

        info.setText("No of attempts remaining:5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){

        if((userName.equals("admin1997")) && (userPassword.equals("agro"))){
            Intent intent = new Intent(admin_login.this,admin_home.class);
            startActivity(intent);
        }else{
            counter--;
            info.setText("Number of Attempts Remaining "+String.valueOf(counter));

            if(counter==0){
                login.setEnabled(false);
            }
        }
    }

}