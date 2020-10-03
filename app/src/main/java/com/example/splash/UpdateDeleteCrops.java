package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateDeleteCrops extends AppCompatActivity {

    //Edit text fields
    EditText crop_name , crop_des , crop_id;
    //buttons
    Button myUpdate , myDel;
    DatabaseReference dbRef;
    //Global variables to hold crop data inside this activity
    String crop_cropName , crop_cropDes , crop_cropID;
    //object from the helper class
    CropHelper crop_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_crops);

        crop_helper = new CropHelper();

        //database referrence
        dbRef = FirebaseDatabase.getInstance().getReference("Crops").child("crpID");

        //Edit text fields
        crop_name = findViewById(R.id.txtCropName);
        crop_des = findViewById(R.id.txtCropDes);
        crop_id = findViewById(R.id.txtCropid);
        //buttons
        myUpdate = findViewById(R.id.btnUpdate);
        myDel = findViewById(R.id.btnDeleteCrop);

        //show data to admin
        showCropData();

        //update operation
        myUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Crops");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("2")){
                            try{
                                crop_helper.setCrpName(crop_name.getText().toString().trim());
                                crop_helper.setCrpDes(crop_des.getText().toString().trim());
                                crop_helper.setCrpID(crop_id.getText().toString().trim());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Crops").child("2");
                                dbRef.setValue(crop_helper);
                                clearConsols();
                                Toast.makeText(getApplicationContext(), "updated" , Toast.LENGTH_SHORT).show();
                            }catch(NumberFormatException e){
                                Toast.makeText(getApplicationContext(), "Invalid" , Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Nothing to update" , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Delete Operation
        myDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Crops");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("1")){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Crops").child("1");
                            dbRef.removeValue();
                            clearConsols();
                            Toast.makeText(getApplicationContext(), "Deleted" , Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Nothing to delete" , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    //retrieving operation
    private void showCropData() {
        Intent intent = getIntent();
        crop_cropName = intent.getStringExtra("crpName");
        crop_cropDes = intent.getStringExtra("crpDes");
        crop_cropID = intent.getStringExtra("crpID");

        crop_name.setText(crop_cropName);
        crop_des.setText(crop_cropDes);
        crop_id.setText(crop_cropID);
    }

    /*    //Update operation
        public void update(View view){

            if( isCropDesEdit() || isCropNameEdit() ){
                Toast.makeText(this , "Crop Data is Updated..." , Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this , "Crop Data is same cannot be updated..." , Toast.LENGTH_SHORT).show();
            }
        }

        private boolean isCropNameEdit() {
            if(!crop_cropName.equals(crop_name.getText().toString())){
                dbRef.child(crop_cropID).child("crpName").setValue(crop_name.getText().toString());
                crop_cropName = crop_name.getText().toString();
                return true;
            }else{
                return false;
            }
        }

        private boolean isCropDesEdit(){
            if(!crop_cropDes.equals(crop_des.getText().toString())){
                dbRef.child(crop_cropID).child("crpDes").setValue(crop_des.getText().toString());
                crop_cropDes = crop_des.getText().toString();
                return true;
            }else{
                return false;
            }
        }
    */
    //clears all the data after pressing 'update' button after filling the form
    private void clearConsols(){
        crop_name.setText("");
        crop_des.setText("");
        crop_id.setText("");
    }
}