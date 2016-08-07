package com.example.shraddha.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    TextView onesub1,onesub2,twosub1,threesub1,foursub1,fivesub1,sixsub1,sevensub1,eightsub1,ninesub1,tensub1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Bundle b=getIntent().getExtras();

        String he=b.getString("height");
        int height = Integer.parseInt(he);
        String we = b.getString("weight");
        int weight = Integer.parseInt(we);
        Long t = b.getLong("time");





        onesub1 = (TextView) findViewById(R.id.one_sub1);
        onesub1.setText("Your heart has beaten " + t*72 + " times");


        onesub2 = (TextView) findViewById(R.id.one_sub2);
        onesub2.setText("A Whale's heart has beaten " + t*8 + " times");


        twosub1 = (TextView) findViewById(R.id.two_sub1);
        twosub1.setText("Flash has completed " + 3600*t + " around the Earth");


        threesub1 = (TextView) findViewById(R.id.three_sub1);
        threesub1.setText("A Humming Bird's heart has beaten " + 250*t + " times");


        foursub1 = (TextView) findViewById(R.id.four_sub1);
        foursub1.setText("You are " + (88800+t)/(365*86400) + " years old in Mars");


        fivesub1 = (TextView) findViewById(R.id.five_sub1);
        fivesub1.setText( "Ant has family of " + 579.1* t/(86400*365)+ " generations");

        sixsub1 = (TextView) findViewById(R.id.six_sub1);
        sixsub1.setText("A redwood's growth in your lifetime " + 2.6917*height);


        sevensub1 = (TextView) findViewById(R.id.seven_sub1);
        sevensub1.setText("Population growth in your lifetime " + t/(86400*365)* 7.4* 1.3 + " Billion");


        eightsub1 = (TextView) findViewById(R.id.eight_sub1);
        eightsub1.setText("You have walked " + 3000*(t/86400) + " steps in your lifetime");


        ninesub1 = (TextView) findViewById(R.id.nine_sub1);
        ninesub1.setText("Sea level rising in your lifetime " + t/(86400*365)*0.0032 + "%");


        tensub1 = (TextView) findViewById(R.id.ten_sub1);
        tensub1.setText("Your weight is " + weight/6 + " on moon");
    }
}
