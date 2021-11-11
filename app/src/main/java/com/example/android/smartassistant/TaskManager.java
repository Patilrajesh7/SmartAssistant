package com.example.android.smartassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.smartassistant.databinding.ActivityCreateTaskBinding;
import com.example.android.smartassistant.databinding.ActivityTaskManagerBinding;

public class TaskManager extends AppCompatActivity {

    ActivityTaskManagerBinding binding;
    boolean todayVis = false,
            tomVis = false,
            weekVis = false,
            monthVis = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTaskManagerBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_task_manager);

        binding.todayH1.setOnClickListener( v -> {
            if(!todayVis){
                todayVis = true;
//                binding.today.setVisibility(View.VISIBLE);
                binding.toTask1.setVisibility(View.VISIBLE);
                binding.toTask2.setVisibility(View.VISIBLE);
                binding.toTask3.setVisibility(View.VISIBLE);
            }
            else{
                binding.toTask1.setVisibility(View.GONE);
                binding.toTask2.setVisibility(View.GONE);
                binding.toTask3.setVisibility(View.GONE);
                todayVis = false;
            }
        });

        binding.tomorrowH1.setOnClickListener( v -> {
            if(!tomVis){
                tomVis = true;
                binding.tomTask1.setVisibility(View.VISIBLE);
                binding.tomTask2.setVisibility(View.VISIBLE);
            }else{
                binding.tomTask1.setVisibility(View.GONE);
                binding.tomTask2.setVisibility(View.GONE);
                tomVis = false;
            }
        });

        binding.monthlyH1.setOnClickListener( v -> {
            if(!monthVis){
                monthVis = true;
                binding.moTask1.setVisibility(View.VISIBLE);
            }else{
                binding.moTask1.setVisibility(View.GONE);
                monthVis = false;
            }
        });

        binding.weeklyH1.setOnClickListener( v -> {
            if(!weekVis){
                weekVis = true;
                binding.weTask1.setVisibility(View.VISIBLE);
            }else{
                binding.weTask1.setVisibility(View.GONE);
                weekVis = false;
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener( v -> {
            Intent intent = new Intent(TaskManager.this , CreateTask.class);
            startActivity(intent);
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        });

//        binding.button.setOnClickListener( v -> {
//            Intent intent = new Intent(TaskManager.this , CreateTask.class);
//            startActivity(intent);
//            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
//        });


//        binding.fab.setOnClickListener(v -> {
//            Intent intent = new Intent(TaskManager.this , CreateTask.class);
//            startActivity(intent);
//        });
    }
}