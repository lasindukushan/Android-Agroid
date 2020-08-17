package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class earn extends AppCompatActivity {

    TextView tv,tv1,tv2,tv3;

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




    }
}