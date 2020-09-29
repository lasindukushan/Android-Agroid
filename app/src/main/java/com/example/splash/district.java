package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class district extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;

    DatabaseReference dbRef;
    districtncrop dnc;
    private AutoCompleteTextView txtSearch;
    private ListView listData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_district);

        menuIcon = findViewById(R.id.menuIcon);


     /*   Spinner mySpinner = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(district.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.district));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);*/


        //menu huk
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuicon = findViewById(R.id.menuIcon);



        txtSearch=(AutoCompleteTextView)findViewById(R.id.txtSearch);

        dbRef = FirebaseDatabase.getInstance().getReference("districncrop");
        listData=(ListView)findViewById(R.id.listData);


        ValueEventListener event = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dissearch(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        dbRef.addListenerForSingleValueEvent(event);

        //nav drawer


        navigationDrawer();
    }

    private void dissearch(DataSnapshot snapshot) {

        Log.d("districtncrop","Reading Data");
        ArrayList<String> names= new ArrayList<>();
        if (snapshot.exists()){

            for (DataSnapshot ds:snapshot.getChildren())
            {
                String district = ds.child("district").getValue(String.class);
                names.add(district);
            }

            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
            txtSearch.setAdapter(adapter);
            txtSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String district = txtSearch.getText().toString();
                    searchCrop(district);

                }
            });

        }else {
            Log.d("districtncrop","No data Found");
        }
    }

    private void searchCrop(String district) {

        Query query = dbRef.orderByChild("district").equalTo(district);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    ArrayList<String> listcrops = new ArrayList<>();
                    for(DataSnapshot ds:snapshot.getChildren()){

                        districtncrop dns= new districtncrop(ds.child("district").getValue(String.class),ds.child("crops").getValue(String.class));
                        listcrops.add(dns.getCrops());
                    }
                    ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listcrops);
                    listData.setAdapter(adapter);

                }else{
                    Log.d("districtncrop","No data Found");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }




    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);

                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;

            case R.id.nav_district:
                break;

            case R.id.nav_market:
                Intent intent1 = new Intent(district.this,price.class);
                startActivity(intent1);
                break;
        }
        return false;
    }




}