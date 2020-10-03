package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    ImageView price;
    ImageView myImageCrop;
    ImageView pltshedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        price = findViewById(R.id.imgPrice);
        myImageCrop = findViewById(R.id.imgCrop);

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this , price.class);
                startActivity(intent);
            }
        });

        //moving to the crop details page
        myImageCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this , CropDetails.class);
                startActivity(intent);
            }
        });
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