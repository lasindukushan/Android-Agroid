package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IndividualCrop extends AppCompatActivity {

    //Text views
    TextView cropTitle , cropDescription;
    //Global variables to hold crop data inside this activity
    String crop_cropName , crop_cropDes , crop_cropID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_crop);

        cropTitle = findViewById(R.id.cropName);
        cropDescription = findViewById(R.id.description);

        //show data to user
        showCropData();
    }

    //retrieving operation
    private void showCropData() {
        Intent intent = getIntent();
        crop_cropName = intent.getStringExtra("crop_Name");
        crop_cropDes = intent.getStringExtra("crop_Des");
        //crop_cropID = intent.getStringExtra("crpID");

        cropTitle.setText(crop_cropName);
        cropDescription.setText(crop_cropDes);
    }
}