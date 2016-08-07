package com.example.shraddha.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class CalculatorActivity extends AppCompatActivity {
    TextView onesub1,onesub2,twosub1,threesub1,foursub1,fivesub1,sixsub1,sevensub1,eightsub1,ninesub1,tensub1;
    int height = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Bundle b=getIntent().getExtras();

        String post=b.getString("post");
        int height = b.getInt("height");
        int weight = b.getInt("weight");
        int day = b.getInt("day");
        int month = b.getInt("month");
        int year = b.getInt("year");
        long t = b.getLong("time");








        //System.out.println("The values are:" + year + month + day + t);

        onesub1 = (TextView) findViewById(R.id.one_sub1);
        onesub1.setText("Your heart has beaten " + t*72 + post + " times");


        onesub2 = (TextView) findViewById(R.id.one_sub2);
        onesub2.setText("A Whale's heart has beaten " + t*8 + post + " times");


        twosub1 = (TextView) findViewById(R.id.two_sub1);
        twosub1.setText("Flash has completed " + 3*t + "Quintillion trips around the Earth");


        threesub1 = (TextView) findViewById(R.id.three_sub1);
        threesub1.setText("A Humming Bird's heart has beaten " + 250*t + post+ " times");


        foursub1 = (TextView) findViewById(R.id.four_sub1);
        foursub1.setText("You are " + Math.round(year/1.88) + " years old in Mars");


        fivesub1 = (TextView) findViewById(R.id.five_sub1);
        fivesub1.setText( "Ant has family of " + 667*(year)+ " generations");

        sixsub1 = (TextView) findViewById(R.id.six_sub1);
        sixsub1.setText("A redwood's growth in your lifetime " + height/100 * 3.5144 + "m");


        sevensub1 = (TextView) findViewById(R.id.seven_sub1);
        sevensub1.setText("Population has increased by " + Math.round((year)*  1.013) + "% in your lifetime");


        eightsub1 = (TextView) findViewById(R.id.eight_sub1);
        eightsub1.setText("You have walked " + Math.abs(3000*(year*365)) + " steps in your lifetime");


        ninesub1 = (TextView) findViewById(R.id.nine_sub1);
        ninesub1.setText("Sea level rising in your lifetime " + (year)*0.0032 + "%");


        tensub1 = (TextView) findViewById(R.id.ten_sub1);
        tensub1.setText("Your weight is " + weight/6 + " on moon");
    }
}
