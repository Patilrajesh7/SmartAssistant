package com.example.android.smartassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.smartassistant.adapters.TaskViewAdapter;
import com.example.android.smartassistant.databinding.ActivityCreateTaskBinding;
import com.example.android.smartassistant.databinding.ActivityTaskManagerBinding;
import com.example.android.smartassistant.fragments.MonthlyFragment;
import com.example.android.smartassistant.fragments.TodayFragment;
import com.example.android.smartassistant.fragments.TomorrowFragment;
import com.example.android.smartassistant.fragments.WeeklyFragment;
import com.google.android.material.tabs.TabLayout;

public class TaskManager extends AppCompatActivity {

    ActivityTaskManagerBinding binding;
    boolean todayVis = false,
            tomVis = false,
            weekVis = false,
            monthVis = false;

    TaskViewAdapter taskViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTaskManagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.taskTabs.setupWithViewPager(binding.taskViewPager);

        taskViewAdapter = new TaskViewAdapter(getSupportFragmentManager() , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        taskViewAdapter.addFragment(new TodayFragment(),"Today");
        taskViewAdapter.addFragment(new TomorrowFragment(),"Tomorrow");
        taskViewAdapter.addFragment(new WeeklyFragment(),"Weekly");
        taskViewAdapter.addFragment(new MonthlyFragment(),"Monthly");
        binding.taskViewPager.setAdapter(taskViewAdapter);

        binding.createTask.setOnClickListener(v -> {
            Intent intent = new Intent(TaskManager.this,CreateTask.class);
            startActivity(intent);
        });
    }
}