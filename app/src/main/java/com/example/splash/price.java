package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class price extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Button button;
    EditText editText;
    ImageView menuicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_price);

        menuIcon = findViewById(R.id.menuIcon);



        //menu huk
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuicon = findViewById(R.id.menuIcon);


        //nav drawer


        navigationDrawer();

        editText = (EditText) findViewById(R.id.price);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String namevalue = editText.getText().toString();
                Intent intent = new Intent(price.this, earn.class);
                intent.putExtra("Price", namevalue);
                startActivity(intent);

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
                Intent intent = new Intent(price.this,district.class);
                startActivity(intent);
                break;

            case R.id.nav_market:
                Intent intent1 = new Intent(price.this,price.class);
                startActivity(intent1);
                break;
        }
        return false;
    }
}