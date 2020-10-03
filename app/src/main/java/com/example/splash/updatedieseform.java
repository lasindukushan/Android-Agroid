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

public class updatedieseform extends AppCompatActivity {

    EditText Name, Cause_it, Look_like, Can_do;
    Button btnupdate;
    DatabaseReference dbRef;
    DeisesID dis;

    long maxid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedieseform);

        Name = findViewById(R.id.editTextTextPersonName);
        Cause_it = findViewById(R.id.inputbox2);
        Look_like = findViewById(R.id.inputbox3);
        Can_do = findViewById(R.id.inputbox4);

        btnupdate = findViewById(R.id.btn_update);

        dis = new DeisesID();





        btnupdate.setOnClickListener(new android.view.View.OnClickListener() {
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
                    if (TextUtils.isEmpty(Name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(Cause_it.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Cause it", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(Look_like.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Look like", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(Can_do.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Can do", Toast.LENGTH_SHORT).show();
                    else {
                        dis.setName(Name.getText().toString().trim());
                        dis.setCause_it(Cause_it.getText().toString().trim());
                        dis.setLook_like(Look_like.getText().toString().trim());
                        dis.setCan_do(Can_do.getText().toString().trim());
                        dbRef.child(String.valueOf(maxid + 1)).setValue(dis);

                        Toast.makeText(updatedieseform.this, R.string.datainsert, Toast.LENGTH_LONG).show();

                    }
                } finally {

                }
            }
        });
    }
}