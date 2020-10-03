package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class admin_home extends AppCompatActivity {

    Button districtadd;
    Button marketadd;
    Button plantsh;
    Button cropAdmin;
    Button diseasadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        districtadd = findViewById(R.id.districtbtn);
        marketadd = findViewById(R.id.marketbtn);
        plantsh = findViewById(R.id.plant);
        cropAdmin = findViewById(R.id.crop);
        diseasadd=findViewById(R.id.button7);

        districtadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,district_admin.class);
                startActivity(intent);

            }
        });

        marketadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,market_admin.class);
                startActivity(intent);

            }
        });

        plantsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,PSheduleMain.class);
                startActivity(intent);
            }
        });

        cropAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,AddCrop.class);
                startActivity(intent);
            }
        });

        diseasadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,diseaseadmin.class);
                startActivity(intent);

            }
        });

    }


}