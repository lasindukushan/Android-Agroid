package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class district_admin extends AppCompatActivity {

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    EditText crop;
    Button add;
    DatabaseReference dbRef;
    districtncrop dnc;
    Spinner spinner;
    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_district_admin);


        crop =findViewById(R.id.cropin);
        spinner=findViewById(R.id.spinner2);
        add=findViewById(R.id.adding);

        dnc= new districtncrop();

        dbRef = FirebaseDatabase.getInstance().getReference().child("districncrop");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dnc.setCrops(crop.getText().toString().trim());
                dnc.setDistrict(spinner.getSelectedItem().toString().trim());

                dbRef.child(String.valueOf(maxid+1)).setValue(dnc);

                Toast.makeText(district_admin.this, R.string.datainsert,Toast.LENGTH_LONG).show();
            }
        });


        Spinner mySpinner = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(district_admin.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.district));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

    }

}