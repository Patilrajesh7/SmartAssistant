package com.example.android.smartassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.smartassistant.databinding.ActivityCreateTaskBinding;
import com.example.android.smartassistant.dialogs.TaskDescriptionDialogs;
import com.example.android.smartassistant.utility.CalendarUtils;

public class CreateTask extends AppCompatActivity implements TaskDescriptionDialogs.DescriptionDailogListner {

    ActivityCreateTaskBinding binding;
    View root;

    //declare Calendar Utility
     CalendarUtils mCalendar;

    //data
    String mTitle;
    String mCategory ,mDesc;
    boolean isCatEntered = false;
    boolean isDescEntered = false;
    boolean isDateSelected = false;
    //date of task
    int mDay,mMonth,mYear;
    //start and end time of task
    int startHour ,startMinute ,endHour ,endMinute;
    long startTime , endTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //view binding
       binding = ActivityCreateTaskBinding.inflate(getLayoutInflater());
       root = binding.getRoot();
       setContentView(root);
       //init Calendar
        mCalendar = new CalendarUtils(CreateTask.this);
        binding.startTime.setText(mCalendar.getCurTime());
        binding.endTime.setText(mCalendar.getCurTime());



       //on Click Back Button
       binding.backButton.setOnClickListener( v -> onBack());
       binding.submit.setOnClickListener( v -> onSubmit());
       //on Click Submit Button
       binding.catBtn1.setOnClickListener(v -> onCat(binding.catBtn1));

       //Selecting Task Category
       binding.catBtn2.setOnClickListener(v -> onCat(binding.catBtn2));
       binding.catBtn3.setOnClickListener(v -> onCat(binding.catBtn3));
       binding.catBtn4.setOnClickListener(v -> onCat(binding.catBtn4));
       binding.catBtn5.setOnClickListener(v -> onCat(binding.catBtn5));
       binding.catBtn6.setOnClickListener(v -> onCat(binding.catBtn6));

       //opening dialog for Description
       binding.tvDesc.setOnClickListener(v -> openDialog());


       //opening date picker dialog
        binding.tvDate.setOnClickListener( v -> openDateDialog());

        binding.startTime.setOnClickListener(v -> openTimeDialog(binding.startTime));
        binding.endTime.setOnClickListener










                (v -> openTimeDialog(binding.endTime));



//       binding.etDate.setOnClickListener( v -> {
//           Toast.makeText(this, "Date button Clicked", Toast.LENGTH_LONG).show();
//       });

    }

    private void openTimeDialog(TextView timeView) {
       mCalendar.getTimeDialog(timeView);
        if(timeView == binding.startTime){
            startHour = mCalendar.getSelectedHour();
            startMinute = mCalendar.getSelectedMins();
            startTime = mCalendar.timeInMillis( mDay, mMonth , mYear , startHour , startMinute );
        } else {
            endHour = mCalendar.getSelectedHour();
            endMinute = mCalendar.getSelectedMins();
            endTime = mCalendar.timeInMillis( mDay, mMonth , mYear , endHour , endMinute );
        }

    }



    private void openDateDialog() {
        mCalendar.getDateDialog(binding.tvDate);
        mDay = mCalendar.getSelectedDay();
        mMonth = mCalendar.getSelectedMonth();
        mYear = mCalendar.getSelectedYear();

        Log.d("CreateTask","DateDialog : "+mDay+"/"+mMonth+"/"+mYear);
        startTime = mCalendar.timeInMillis( mDay, mMonth , mYear , startHour , startMinute );
        endTime = mCalendar.timeInMillis( mDay, mMonth , mYear , endHour , endMinute );
        isDateSelected = true;

    }

    private void openDialog() {
        TaskDescriptionDialogs taskDescriptionDialogs = new TaskDescriptionDialogs();
        taskDescriptionDialogs.show(getSupportFragmentManager(),"description dialog");
    }


    private void onBack() {
        Toast.makeText(this, "Back to main activity", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void onSubmit() {
        if(TextUtils.isEmpty(binding.etTitle.getText())){
            notif("Enter Title Name");
        }else if(!isDateSelected){
            notif("Enter Date of Task");
        }else if(!isDescEntered){
            notif("Enter Description Task");
        }else if(!isCatEntered){
            notif("Please Select Category");
        }else{
            mTitle = binding.etTitle.getText().toString();
            Intent intent = new Intent(CreateTask.this,MainActivity.class);   //Testing purpose
//            notif("Title :"+mTitle+"\n" +
//                       "Date  :"+mDay+"-"+mMonth+"-"+mYear+"\n" +
//                       "StartTime :"+startTime+"\n" +
//                        "entTime :"+endTime+"\n" +
//                        "description :"+mDesc+"\n" +
//                        "Category :"+mCategory);
            Log.d("Create Task Activity","Title :"+mTitle+"\n" +
                    "Date  :"+mDay+"-"+mMonth+"-"+mYear+"\n" +
                    "StartTime :"+startTime+"\n" +
                    "entTime :"+endTime+"\n" +
                    "description :"+mDesc+"\n" +
                    "Category :"+mCategory);
            startActivity(intent);
            finish();
        }

    }

    private void onCat(Button cat) {
        // get selected category
        mCategory = cat.getText().toString();
        isCatEntered = true;
        //changing the state of button of selected category
        cat.setBackground(getDrawable(R.drawable.button_shape));
        cat.setTextColor(getResources().getColor(R.color.white));

        //changing the state of btn of non selected categories

        if(binding.catBtn1 != cat){
            binding.catBtn1.setBackground(getDrawable(R.drawable.category_button));
            binding.catBtn1.setTextColor(getResources().getColor(R.color.black));
        }

        if(binding.catBtn2 != cat){
            binding.catBtn2.setBackground(getDrawable(R.drawable.category_button));
            binding.catBtn2.setTextColor(getResources().getColor(R.color.black));
        }

        if(binding.catBtn3 != cat){
            binding.catBtn3.setBackground(getDrawable(R.drawable.category_button));
            binding.catBtn3.setTextColor(getResources().getColor(R.color.black));
        }

        if(binding.catBtn4 != cat){
            binding.catBtn4.setBackground(getDrawable(R.drawable.category_button));
            binding.catBtn4.setTextColor(getResources().getColor(R.color.black));
        }

        if(binding.catBtn5 != cat){
            binding.catBtn5.setBackground(getDrawable(R.drawable.category_button));
            binding.catBtn5.setTextColor(getResources().getColor(R.color.black));
        }

        if(binding.catBtn6 != cat){
            binding.catBtn6.setBackground(getDrawable(R.drawable.category_button));
            binding.catBtn6.setTextColor(getResources().getColor(R.color.black));
        }

    }

    @Override
    public void getDesc(String desc) {
        mDesc = desc.trim();
        isDescEntered = true;
        binding.tvDesc.setText(desc);
    }

    public   void notif(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}