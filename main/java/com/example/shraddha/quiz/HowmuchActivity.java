package com.example.shraddha.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class HowmuchActivity extends AppCompatActivity {
    EditText y , m, d;
    EditText Height;
    EditText Weight;
    Button b1;
    int flag = 0;
    int birthday=0, birthmonth=0, birthyear=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmuch);





        Height = (EditText) findViewById(R.id.height);
        Weight = (EditText) findViewById(R.id.weight);

        y = (EditText) findViewById(R.id.year);
        m = (EditText) findViewById(R.id.month);
        d = (EditText) findViewById(R.id.date);



        b1 = (Button) findViewById(R.id.calculate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postfix = "";
                flag = 0;
                Intent intent = new Intent(HowmuchActivity.this, CalculatorActivity.class);

                String h = Height.getText().toString();
                int height = Integer.parseInt(h);
                // checking height
                if(height <= 0 || height > 270){
                    flag = 1;
                }


                String w = Weight.getText().toString();
                int weight = Integer.parseInt(w);
                // checking weight
                if(weight <= 0 || weight > 442 ){
                    flag = 1;
                }

                String years = y.getText().toString();
                String months = m.getText().toString();
                String days = d.getText().toString();

                birthday = Integer.parseInt(days);
                birthmonth = Integer.parseInt(months);
                birthyear = Integer.parseInt(years);

                Calendar c = Calendar.getInstance();
                int currentyear = c.get(Calendar.YEAR);
                int currentmonth = c.get(Calendar.MONTH);
                int currentday = c.get(Calendar.DAY_OF_MONTH);


                int year = currentyear - birthyear;
                // year check
                if(year == 0){
                    year = 1;
                }
                if(birthyear < 1900 || birthyear > currentyear){
                    flag = 1;
                }

                int month = Math.abs(currentmonth - birthmonth);
                // month check
                if(birthmonth <= 0 || birthmonth > 12){
                    flag = 1;
                }

                int day = Math.abs(currentday - birthday);
                // date check
                if(birthday <=0 || birthday >= 31){
                    flag = 1;
                }


                // checking dates
                if(birthmonth == 1 || birthmonth == 3 || birthmonth == 5 || birthmonth == 7 || birthmonth == 8 || birthmonth == 10 || birthmonth == 12){

                    if(birthday > 31){
                        flag = 1;
                    }
                    else {
                        day = day + 1;
                    }
                }
                else if(birthmonth == 4 || birthmonth == 6 || birthmonth == 9 || birthmonth == 11){
                    if(birthday > 30){
                        flag = 1;
                    }
                }
                else if(birthmonth == 2){
                    if(birthday > 28 ){
                        flag = 1;
                    }
                    if(birthyear%4 == 0 && birthday > 29){
                        flag = 1;
                    }
                    else{
                        day++;
                    }
                }


                //converting all time units in second
                long t = ((year * 365) + (month * 30) + day) * (24 * 60);

                // Millions and Billions
                if (t >= 1000000000) {
                    t = t / 1000000000;
                    postfix = "Billion";
                } else if (t >= 1000000) {
                    t = t / 1000000;
                    postfix = "Million";
                }



                // Final check all together
                if (flag == 0) {
                    Bundle b = new Bundle();


                    b.putInt("height", height);
                    b.putInt("weight", weight);
                    b.putInt("year", year);
                    b.putInt("month", month);
                    b.putInt("day", day);
                    b.putLong("time", t);
                    b.putString("post", postfix);


                    intent.putExtras(b);

                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(HowmuchActivity.this, "Invalid input format entered", Toast.LENGTH_SHORT).show();
                }
            }
        });}
}






