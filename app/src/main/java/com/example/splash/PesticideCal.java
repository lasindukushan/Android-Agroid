package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PesticideCal extends AppCompatActivity {

    EditText et1,et2,et3; //declare varialbles
    Button btndone;
    TextView textView;

    public boolean isvalidInput1(String input1){
        if(input1.matches("[0-9][0-9]")){
            return true;
        }
        else
            return false;
    }

    public Boolean isValidinput2(){
        String i2 = et2.getText().toString();

        if(i2.isEmpty()){
            et2.setError("Field Cannot be empty");
            return false;
        }
        else{
            et2.setError(null);
            return true;
        }
    }

    public Boolean isValidinput3(){
        String i3 = et3.getText().toString();

        if(i3.isEmpty()){
            et3.setError("Field Cannot be empty");
            return false;
        }
        else{
            et3.setError(null);
            return true;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesticide_cal);

        et1 = findViewById(R.id.etI1);//take input ids
        et2 = findViewById(R.id.etI2);
        et3 = findViewById(R.id.etI3);
        btndone = findViewById(R.id.btndo);// button id

        textView = findViewById(R.id.output);// textview id to show final output

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input1 = Float.parseFloat(et1.getText().toString());
                double input2 = Float.parseFloat(et2.getText().toString());
                double input3 = Float.parseFloat(et3.getText().toString());

                textView.setText(String.valueOf(calculateResult(input1,input2,input3))+"kg");
            }


        });
    }
    public double calculateResult(double input1, double input2, double input3) {

        return input1 / (input2 * input3);

    }

}