package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Plantshedule_u extends AppCompatActivity {

    RecyclerView recyclerView;
    private DatabaseReference myref;
    private ArrayList<PlantingShedule> sheduleList;
    private RecyclerAdapter recyclerAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantshedule_u);

        recyclerView = findViewById(R.id.RView);//id of the recycler view

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myref = FirebaseDatabase.getInstance().getReference();
        sheduleList = new ArrayList<>();

        ClearAll();//clear arraylist

        GetDataFromFirebase(); //called the method
    }

    //implementation of retrieve data from firebase database
    private void GetDataFromFirebase() {

        Query query = myref.child("PlantingShedule");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    PlantingShedule plantingShedule = new PlantingShedule();

                    plantingShedule.setUrl(snapshot.child("url").getValue().toString());
                    plantingShedule.setPlantName(snapshot.child("plantName").getValue().toString());
                    plantingShedule.setDescription(snapshot.child("description").getValue().toString());

                    sheduleList.add(plantingShedule);

                }
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(),sheduleList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void ClearAll(){
        if(sheduleList != null){
            sheduleList.clear();

            if(recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        sheduleList = new ArrayList<>();
    }
}