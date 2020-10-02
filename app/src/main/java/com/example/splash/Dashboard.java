package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    ImageView pltshedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        pltshedule = findViewById(R.id.imgPlantingSchedule);// get the relevant imageview id

        pltshedule.setOnClickListener(new View.OnClickListener() {//set on click listner for the taken id
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this,Plantshedule_u.class);
                startActivity(i);
            }
        });


    }
}