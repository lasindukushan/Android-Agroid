package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCrop extends AppCompatActivity {

    //Variables
    Button myIntsert , myNext;
    EditText cropName , cropID , cropDes;

    DatabaseReference dbRef;
    CropHelper crpHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop);

        //buttons
        myIntsert = findViewById(R.id.btnInsertCrop);
        myNext = findViewById(R.id.btnNext);
        //Edit Texts
        cropName = findViewById(R.id.txtCropName);
        cropID = findViewById(R.id.txtCropID);
        cropDes = findViewById(R.id.txtCropDes);

        crpHelper = new CropHelper();

        myNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCrop.this , DisplayCropToAdmin.class);
                startActivity(intent);
            }
        });

        //save operation
        myIntsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Crops");
                //Exception Handeling
                try {

                    String stringCropName = cropName.getText().toString();
                    String stringCropDes = cropDes.getText().toString();
                    String stringCropId = cropID.getText().toString();

                    //if (TextUtils.isEmpty(cropName.getText().toString())) {
                    if (!crpHelper.validateCropName(stringCropName)) {
                        Toast.makeText(getApplicationContext(), "Please Enter the Crop Name...", Toast.LENGTH_SHORT).show();
                    //} else if (TextUtils.isEmpty(cropID.getText().toString())) {
                    } else if (!crpHelper.validateCropID(stringCropId) || !crpHelper.expectIntegerCropID(Integer.parseInt(stringCropId))) {
                        Toast.makeText(getApplicationContext(), "Please Enter the Crop ID...", Toast.LENGTH_SHORT).show();
                   // } else if (TextUtils.isEmpty(cropDes.getText().toString())) {
                    } else if (!crpHelper.validateCropDescription(stringCropDes)) {
                        Toast.makeText(getApplicationContext(), "Please Enter the Crop Description...", Toast.LENGTH_SHORT).show();
                    } else {
                        crpHelper.setCrpName(cropName.getText().toString().trim());
                        crpHelper.setCrpID(cropID.getText().toString().trim());
                        String crp = cropID.getText().toString().trim();
                        crpHelper.setCrpDes(cropDes.getText().toString().trim());
                        //dbRef.push().setValue(std);
                        dbRef.child(crp).setValue(crpHelper);
                        Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_SHORT).show();
                        clearConsols();
                    }
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext() , "Invalid" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //clears all the data after pressing 'save' button after filling the form
    private void clearConsols(){
        cropName.setText("");
        cropID.setText("");
        cropDes.setText("");
    }

}