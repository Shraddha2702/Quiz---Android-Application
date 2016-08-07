package com.example.shraddha.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class HowmuchActivity extends Activity {
    long time;
    DatePicker datePicker;
    EditText Height;
    EditText Weight;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howmuch);


        datePicker = (DatePicker) findViewById(R.id.datePicker);

        int birthday = datePicker.getDayOfMonth();
        int birthmonth = datePicker.getMonth() + 1;
        int birthyear = datePicker.getYear();


        final Calendar c = Calendar.getInstance();
        int currentyear = c.get(Calendar.YEAR);
        int currentmonth = c.get(Calendar.MONTH);
        int currentday = c.get(Calendar.DAY_OF_MONTH);

        int year = currentyear - birthyear;
        int month = currentmonth - birthmonth;
        int day = currentday - birthday;
        time = ((year * 365) + (month * 30) + day) * (24 * 36);

        Height = (EditText) findViewById(R.id.editheight);

        Weight = (EditText) findViewById(R.id.editweight);

        b1 = (Button) findViewById(R.id.btnmain);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(HowmuchActivity.this,CalculatorActivity.class);
            String h = Height.getText().toString();
            String w=Weight.getText().toString();
            Bundle b=new Bundle();

            b.putLong("time",time);
            b.putString("height",h);
            b.putString("weight",w);

            intent.putExtras(b);

            startActivity(intent);
            finish();
        }
    });}
}










