package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class price extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;
    List<marketprice> stveg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_price);

        stveg = new ArrayList<>();
        stveg.add(new marketprice("carrot",(float)200,R.drawable.coc));
        stveg.add(new marketprice("cabbage",(float)100,R.drawable.cab));
        stveg.add(new marketprice("Bell Pepper",(float)450,R.drawable.bel));
        stveg.add(new marketprice("Garlic",(float)120,R.drawable.garl));
        stveg.add(new marketprice("Passion Fruit",(float)300,R.drawable.pass));
        stveg.add(new marketprice("Broccoli",(float)90,R.drawable.brok));
        stveg.add(new marketprice("Pineapple",(float)80,R.drawable.pin));
        stveg.add(new marketprice("Apple",(float)80,R.drawable.apple));
        stveg.add(new marketprice("Orange",(float)90,R.drawable.orra));
        stveg.add(new marketprice("Banana",(float)70,R.drawable.bann));
        stveg.add(new marketprice("Coconut",(float)100,R.drawable.coc));
        stveg.add(new marketprice("Grapes",(float)80,R.drawable.gra));
        stveg.add(new marketprice("Avocado",(float)50,R.drawable.ava));
        stveg.add(new marketprice("Strawberry",(float)300,R.drawable.stra));
        stveg.add(new marketprice("Pears",(float)80,R.drawable.pea));
        stveg.add(new marketprice("Leeks",(float)90,R.drawable.leek));
        stveg.add(new marketprice("Beet Root",(float)150,R.drawable.beet));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter=new RecyclerViewAdapter(this,stveg);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

        menuIcon = findViewById(R.id.menuIcon);

        //menu huk
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuicon = findViewById(R.id.menuIcon);

        //nav drawer

        navigationDrawer();

        /*editText = (EditText) findViewById(R.id.price);*/
       /* button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String namevalue = editText.getText().toString();
                Intent intent = new Intent(price.this, earn.class);
                intent.putExtra("Price", namevalue);
                startActivity(intent);

            }
            
            
        });*/



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