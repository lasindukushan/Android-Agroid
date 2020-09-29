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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class earn extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView menuIcon;

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;
    TextView tv,tv1,tv2,tv3;
    Button multi;
    EditText n2,ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_earn);

        tv=(TextView) findViewById(R.id.textView2);
        tv1=(TextView) findViewById(R.id.textView3);
        tv2=(TextView) findViewById(R.id.textView5);
        tv3=(TextView) findViewById(R.id.textView9);

        tv.setText("CHECK YOUR EARN HERE");
        tv1.setText("Price: "+getIntent().getStringExtra("Price"));
        tv2.setText("Enter the Quantity in Kilo");
        tv3.setText("Rs: ");

        multi = (Button) findViewById(R.id.adminlogin);
        n2 =(EditText) findViewById(R.id.editTextNumber);
        ans=(EditText) findViewById(R.id.editTextNumber2);

        multi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                float a,b,c;
                a= Float.parseFloat(getIntent().getStringExtra("Price").toString());
                b= Float.parseFloat(n2.getText().toString());
                c=a*b;

                ans.setText(""+c);

            }

        });

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
                Intent intent1 = new Intent(earn.this,district.class);
                startActivity(intent1);
                break;

            case R.id.nav_market:
                Intent intent2 = new Intent(earn.this,price.class);
                startActivity(intent2);
                break;
        }
        return false;
    }
}