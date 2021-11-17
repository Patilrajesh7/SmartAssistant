package com.example.android.smartassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class BirthadayWishese extends AppCompatActivity {
    private CardView card1;
    private TextView n1;
    private CardView card2;
    private TextView n2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthaday_wishese);

        card1 = (CardView) findViewById(R.id.card1);
        n1 = (TextView) findViewById(R.id.n1);
        card2 = (CardView) findViewById(R.id.card2);
        n2 = (TextView) findViewById(R.id.n2);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder= new AlertDialog.Builder(BirthadayWishese.this);
                builder.setTitle("Enter Name");
                final EditText editText=new EditText(BirthadayWishese.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editText);
                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=editText.getText().toString().trim();
                        n1.setText(name);
                        n2.setText(name);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BirthadayWishese.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(BirthadayWishese.this);
                builder.setTitle("Enter Name");
                final EditText editText=new EditText(BirthadayWishese.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editText);
                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=editText.getText().toString().trim();
                        n1.setText(name);
                        n2.setText(name);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BirthadayWishese.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();

            }
        });


    }
}
