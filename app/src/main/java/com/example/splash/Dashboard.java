package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;

    ImageView pltshedule;
    ImageView pricetag;
    ImageView dises;

    //crops
    ImageView myImageCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        myImageCrop = findViewById(R.id.imgCrop);

        //moving to the crop details page

        myImageCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Dashboard.this , CropDetails.class);
                startActivity(intent3);
            }
        });


        pltshedule = findViewById(R.id.imgPlantingSchedule);// get the relevant imageview id

        pltshedule.setOnClickListener(new View.OnClickListener() {//set on click listner for the taken id
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this,Plantshedule_u.class);
                startActivity(i);

            }

        });

        pricetag = findViewById(R.id.imgPrice);
        pricetag.setOnClickListener(new View.OnClickListener() {//set on click listner for the taken id
            @Override
            public void onClick(View view) {
                Intent p = new Intent(Dashboard.this,price.class);
                startActivity(p);
            }
        });

        dises = findViewById(R.id.imgDis);
        dises.setOnClickListener(new View.OnClickListener() {//set on click listner for the taken id
            @Override
            public void onClick(View view) {
                Intent p = new Intent(Dashboard.this,dieses.class);
                startActivity(p);
            }
        });

        menuIcon = findViewById(R.id.menuIcon);

        //menu huk
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuicon = findViewById(R.id.menuIcon);

        //nav drawer

        navigationDrawer();


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
                Intent intent = new Intent(Dashboard.this,district.class);
                startActivity(intent);
                break;

            case R.id.nav_disease:
                Intent intent3 = new Intent(Dashboard.this,dieses.class);
                startActivity(intent3);
                break;

            case R.id.nav_market:
                Intent intent2 = new Intent(Dashboard.this,price.class);
                startActivity(intent2);
                break;
        }
        return false;
    }
    }
