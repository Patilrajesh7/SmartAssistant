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

public class festivalWishes extends AppCompatActivity {
    private CardView card1;
    private TextView n1;
    private CardView card2;
    private TextView n2;
    private CardView card3;
    private TextView n3;
    private CardView card4;
    private TextView n4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_wishes);


        card1 = (CardView) findViewById(R.id.card1);
        n1 = (TextView) findViewById(R.id.n1);
        card2 = (CardView) findViewById(R.id.card2);
        n2 = (TextView) findViewById(R.id.n2);
        card3 = (CardView) findViewById(R.id.card3);
        n3 = (TextView) findViewById(R.id.n3);
        card4 = (CardView) findViewById(R.id.card4);
        n4 = (TextView) findViewById(R.id.n4);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(festivalWishes.this);
                builder.setTitle("Enter Name");
                final EditText editText=new EditText(festivalWishes.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editText);
                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=editText.getText().toString().trim();
                        n1.setText(name);
                        n2.setText(name);
                        n3.setText(name);
                        n4.setText(name);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(festivalWishes.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();

            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(festivalWishes.this);
                builder.setTitle("Enter Name");
                final EditText editText=new EditText(festivalWishes.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editText);
                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=editText.getText().toString().trim();
                        n1.setText(name);
                        n2.setText(name);
                        n3.setText(name);
                        n4.setText(name);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(festivalWishes.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });


        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder= new AlertDialog.Builder(festivalWishes.this);
                builder.setTitle("Enter Name");
                final EditText editText=new EditText(festivalWishes.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editText);
                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=editText.getText().toString().trim();
                        n1.setText(name);
                        n2.setText(name);
                        n3.setText(name);
                        n4.setText(name);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(festivalWishes.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();


            }
        });


        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(festivalWishes.this);
                builder.setTitle("Enter Name");
                final EditText editText=new EditText(festivalWishes.this);
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(editText);
                builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=editText.getText().toString().trim();
                        n1.setText(name);
                        n2.setText(name);
                        n3.setText(name);
                        n4.setText(name);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(festivalWishes.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();

            }
        });


    }
}
