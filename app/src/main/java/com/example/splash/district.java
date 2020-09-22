package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class district extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(district.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.district));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }
}