package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class diseaseadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseaseadmin);

        Button btnAdd = findViewById(R.id.btn_u2x);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),add_deises.class);
                startActivity(intent);
            }
        });

//        Button btndelete = findViewById(R.id.btn_del);
//        btndelete.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),deletedieses.class);
//                startActivity(intent);
//            }
//        });


        Button btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),updatedieseform.class);
                startActivity(intent);
            }
        });

        Button btnhome = findViewById(R.id.btn_h1xx);
        btnhome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dieses.class);
                startActivity(intent);
            }
        });

    }
}