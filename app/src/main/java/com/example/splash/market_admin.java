package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class market_admin extends AppCompatActivity {

    EditText prices,name;
    Button add;
    DatabaseReference dbRef;
    marketprice mp;
    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_market_admin);


        prices =(EditText) findViewById(R.id.prices);
        name =(EditText) findViewById(R.id.name);

        add=findViewById(R.id.add);

        mp= new marketprice();

        dbRef = FirebaseDatabase.getInstance().getReference().child("marketprice");
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

                Float price=Float.parseFloat((prices.getText().toString().trim()));

                mp.setPrice(price);
                mp.setName(name.getText().toString().trim());


                dbRef.child(String.valueOf(maxid+1)).setValue(mp);

                Toast.makeText(market_admin.this, R.string.datainsert,Toast.LENGTH_LONG).show();
            }
        });

    }

}