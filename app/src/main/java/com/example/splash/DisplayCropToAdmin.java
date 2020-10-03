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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DisplayCropToAdmin extends AppCompatActivity {

    Button myDisplay;
    EditText cropID_enteredByAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_crop_to_admin);

        myDisplay = findViewById(R.id.btnUpdate);
        cropID_enteredByAdmin = findViewById(R.id.txtCropID);

        myDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String adminEnterCropID = cropID_enteredByAdmin.getText().toString().trim();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");

                Query checkCrop = ref.orderByChild("crpID").equalTo(adminEnterCropID);

                checkCrop.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String cropIdFromDB = dataSnapshot.child(adminEnterCropID).child("crpID").getValue(String.class);

                        if(cropIdFromDB.equals(adminEnterCropID)){

                            String cropNameFromDB = dataSnapshot.child(adminEnterCropID).child("crpName").getValue(String.class);
                            String cropDesFromDB = dataSnapshot.child(adminEnterCropID).child("crpDes").getValue(String.class);
                            String cropIDFromDB = dataSnapshot.child(adminEnterCropID).child("crpID").getValue(String.class);

                            Intent intent = new Intent(getApplicationContext(), UpdateDeleteCrops.class);

                            intent.putExtra("crpName" , cropNameFromDB);
                            intent.putExtra("crpDes" , cropDesFromDB);
                            intent.putExtra("crpID" , cropIDFromDB);
                            startActivity(intent);

                        }else{
                            Toast.makeText(getApplicationContext() , "ID doesn't Exist..." , Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}