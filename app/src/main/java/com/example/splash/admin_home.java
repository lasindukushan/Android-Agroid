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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        districtadd = findViewById(R.id.districtbtn);

        districtadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,district_admin.class);
                startActivity(intent);

            }
        });

        marketadd = findViewById(R.id.marketbtn);

        marketadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_home.this,market_admin.class);
                startActivity(intent);

            }
        });
    }


}