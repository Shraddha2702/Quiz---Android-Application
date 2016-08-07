package com.example.shraddha.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {

    Button bquiz;
    Button bCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        bquiz=(Button)findViewById(R.id.btnquiz);
        bCal=(Button)findViewById(R.id.btncal);

        bCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstPage.this,HowmuchActivity.class);
                startActivity(i);
            }
        });

        bquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstPage.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
