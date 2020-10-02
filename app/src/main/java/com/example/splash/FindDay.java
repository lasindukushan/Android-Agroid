package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class FindDay extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private TextView datetext,txtharvest;
    Button harvest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_day);

        datetext = findViewById(R.id.date_text);//take the date
        txtharvest= findViewById(R.id.txt_harvest);//calculate the date after duration and show

        findViewById(R.id.btn_plant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(); // show date picker dialog

            }
        });


    }

    //implement the method showPickerDialog
    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date =  i + "/" + i1 + "/" + i2;
        datetext.setText(date);
        //txtharvest.setText((int) calculateHarvest((int) Calendar.getInstance().getTimeInMillis()));

    }

//    private Date calculateHarvest(long timeInMillis) {
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(timeInMillis);
//        calendar.add(Calendar.DATE,30);
//
//        Date end =  calendar.getTimeInMillis();
//        return end   ;
////
////        //Calendar today = Calendar.getInstance();
////
////        /*int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
////
////        if(today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH) ){
////            age--;
////        }
////
////        return age;     */
//    }
}
