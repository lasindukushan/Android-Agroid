package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CropDetails extends AppCompatActivity {

    private String id;

    ImageView myImageCauliflower , myImageCabbage , myImageBitter , myImageCarrot ;
    ImageView myImagePineApple , myImageDragon , myImagePomegranate , myImageGrapes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_details);

        //ImageViews
        myImageCauliflower = findViewById(R.id.imgCauliflower);
        myImageCabbage = findViewById(R.id.imgCabbage);
        myImageBitter = findViewById(R.id.imgBitterGourd);
        myImageCarrot = findViewById(R.id.imgCarrot);
        myImagePineApple = findViewById(R.id.imgPineapple);
        myImageDragon = findViewById(R.id.imgDragon);
        myImagePomegranate = findViewById(R.id.imgPomegranate);
        myImageGrapes = findViewById(R.id.imgGrapes);

        myImageCauliflower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "1";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        myImageCabbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "2";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        myImageBitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "3";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        myImageCarrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "4";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        myImagePineApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "5";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        myImageDragon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "6";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        myImagePomegranate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "7";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        myImageGrapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "8";

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Crops");
                Query checkCropUser = ref.orderByChild("crpID").equalTo(id);

                checkCropUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //String cropIdFromDB = dataSnapshot.child(id).child("crpID").getValue(String.class);

                        String cropNameFromDB = dataSnapshot.child(id).child("crpName").getValue(String.class);
                        String cropDesFromDB = dataSnapshot.child(id).child("crpDes").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext() , IndividualCrop.class);
                        intent.putExtra("crop_Name" , cropNameFromDB);
                        intent.putExtra("crop_Des" , cropDesFromDB);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

    }
}