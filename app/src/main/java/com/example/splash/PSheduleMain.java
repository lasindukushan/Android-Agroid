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

public class PSheduleMain extends AppCompatActivity {

    EditText etid;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_shedule_main);

        Button btnadd = findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DoChanges.class);
                startActivity(intent);
            }
        });

        Button show = findViewById(R.id.btnshow);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etid = findViewById(R.id.etID);

                final String id = etid.getText().toString().trim();

                dbref = FirebaseDatabase.getInstance().getReference().child("PlantingShedule");
                Query takeID = dbref.orderByChild("plantID").equalTo(id);

                takeID.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            String plantId = dataSnapshot.child(id).child("plantID").getValue(String.class);
                            String pName = dataSnapshot.child(id).child("plantName").getValue(String.class);
                            String desc = dataSnapshot.child(id).child("description").getValue(String.class);

                            Intent intent = new Intent(getApplicationContext(),DoChanges.class);

                            intent.putExtra("id",plantId);
                            intent.putExtra("name",pName);
                            intent.putExtra("description",desc);

                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "No serach plantShedule", Toast.LENGTH_SHORT).show();
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