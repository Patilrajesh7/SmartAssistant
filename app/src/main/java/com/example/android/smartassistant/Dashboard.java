package com.example.android.smartassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class Dashboard extends AppCompatActivity {
    private LinearLayout layout1;
    private CircularImageView logo;
    private TextView day;
    private TextView date;
    private CircularImageView profile;
    private TextView name;
    private TextView task;
    private LinearLayout layout2;
    private CardView card1;
    private CardView card2;
    private LinearLayout layout3;
    private CardView card3;
    private CardView card4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        layout1 = (LinearLayout) findViewById(R.id.layout1);
        logo = (CircularImageView) findViewById(R.id.logo);
        day = (TextView) findViewById(R.id.day);
        date = (TextView) findViewById(R.id.date);
        profile = (CircularImageView) findViewById(R.id.profile);
        name = (TextView) findViewById(R.id.name);
        task = (TextView) findViewById(R.id.task);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        card3 = (CardView) findViewById(R.id.card3);
        card4 = (CardView) findViewById(R.id.card4);

    card1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =new Intent(Dashboard.this,TaxkManager.class);
            startActivity(intent);

        }
    });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,ComplitedTask.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Dashboard.this,festivalWishes.class);
                startActivity(intent);

            }
        });


        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Dashboard.this,BirthadayWishese.class);
                startActivity(intent);

            }
        });



    }
}