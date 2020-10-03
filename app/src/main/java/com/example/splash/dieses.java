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
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class dieses extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dieses);

        menuIcon = findViewById(R.id.menuIcon);


//           Button btnh = findViewById(R.id.btn_hom1);
//            btnh.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),Dashboard.class);
//                startActivity(intent);
//            }
//        });


        Button btnhdi1 = findViewById(R.id.btn_h1xx);
        btnhdi1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),card1details.class);
                startActivity(intent);
            }
        });

        Button btnhdi2 = findViewById(R.id.btn_h2x);
        btnhdi2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),card2details.class);
                startActivity(intent);
            }
        });

//        Button btnAddmin = findViewById(R.id.btn_a1);
//        btnAddmin.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),diseaseadmin.class);
//                startActivity(intent);
//            }
//        });


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


            case R.id.nav_market:
                Intent intent2 = new Intent(dieses.this,price.class);
                startActivity(intent2);
                break;
        }
        return false;
    }
}

