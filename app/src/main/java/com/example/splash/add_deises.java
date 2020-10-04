package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class add_deises extends AppCompatActivity {

    EditText Name, Cause_it, Look_like, Can_do;
    Button btnAdd;
    DatabaseReference dbRef;
    DeisesID dis;



    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_deises);

        Name = findViewById(R.id.editTextTextPersonName);
        Cause_it = findViewById(R.id.inputbox2);
        Look_like = findViewById(R.id.inputbox3);
        Can_do = findViewById(R.id.inputbox4);

        btnAdd = findViewById(R.id.btn_u2x);

        dis = new DeisesID();





        btnAdd.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference().child("DeisesID");
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

                try {
                    String stringName = Name.getText().toString();
                    String stringCause_it = Cause_it.getText().toString();
                    String stringLook_like = Look_like.getText().toString();
                    String stringCan_do = Can_do.getText().toString();

                    if (!dis.validateName(stringName)) {
                        Toast.makeText(getApplicationContext(), "Empty Cause it", Toast.LENGTH_SHORT).show();}

                    else if (!Name.getText().toString().matches("[a-z,A-Z]*"))
                       Name.setError("Enter Only Characters");


                   else if (!dis.validateCause_it(stringCause_it)) {
                        Toast.makeText(getApplicationContext(), "Empty Cause it", Toast.LENGTH_SHORT).show();}
                    else if (!dis.validateLook_like(stringLook_like)) {
                        Toast.makeText(getApplicationContext(), "Empty Cause it", Toast.LENGTH_SHORT).show();}
                    else if (!dis.validateCan_do(stringCan_do)) {
                        Toast.makeText(getApplicationContext(), "Empty Cause it", Toast.LENGTH_SHORT).show();}
                    else {
                        dis.setName(Name.getText().toString().trim());
                        dis.setCause_it(Cause_it.getText().toString().trim());
                        dis.setLook_like(Look_like.getText().toString().trim());
                        dis.setCan_do(Can_do.getText().toString().trim());
                        dbRef.child(String.valueOf(maxid+1)).setValue(dis);

                        Toast.makeText(add_deises.this, R.string.datainsert,Toast.LENGTH_LONG).show();
                    }

                } finally {

                }
            }
        });
    }
}