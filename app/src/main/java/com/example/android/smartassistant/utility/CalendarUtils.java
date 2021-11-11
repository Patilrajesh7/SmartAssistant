package com.example.android.smartassistant.utility;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.smartassistant.R;

import java.text.DateFormat;
import java.util.Calendar;

public class CalendarUtils {


    Context context;
    Calendar cal = Calendar.getInstance();
    int curDay = cal.get(Calendar.DAY_OF_MONTH);
    int curMonth = cal.get(Calendar.MONTH);
    int curYear = cal.get(Calendar.YEAR);
    int curHour = cal.get(Calendar.HOUR);
    int curMinute = cal.get(Calendar.MINUTE);


    int selectedDay ,selectedMonth ,selectedYear;
    int selectedHour ,selectedMins;


    public int getSelectedDay() {
        return selectedDay;
    }

    public int getSelectedMonth() {
        return selectedMonth;
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public int getSelectedHour() {
        return selectedHour;
    }

    public int getSelectedMins() {
        return selectedMins;
    }

    public CalendarUtils(Context context) {
        this.context = context;
    }

    public int getCurDay() {
        return curDay;
    }

    public int getCurMonth() {
        return curMonth;
    }

    public int getCurYear() {
        return curYear;
    }


    public int getCurHour() {
        return curHour;
    }


    public int getCurMinute() {
        return curMinute;
    }


    public CharSequence getCurTime(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY);
//        calendar.set(Calendar.MINUTE, min);
//        calendar.set(Calendar.SECOND, 0);
        return android.text.format.DateFormat.format("hh:mm aa",cal);
    }


    public long timeInMillis(){
        return cal.getTimeInMillis();
    }

    public long timeInMillis(int d,int m,int y,int h,int min){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.MONTH, m);
        calendar.set(Calendar.DAY_OF_MONTH, d);
        calendar.set(Calendar.HOUR_OF_DAY, h);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    public void getDateDialog(TextView dateText){

        DatePickerDialog datePicker = new DatePickerDialog(context,
                (datepicker, y, m, d) -> {

                    selectedDay = d;
                    selectedMonth = m;
                    selectedYear = y;

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.YEAR, selectedYear);
                    calendar.set(Calendar.MONTH, selectedMonth);
                    calendar.set(Calendar.DAY_OF_MONTH, selectedDay);

                    Log.v("DateUtils","Date1 :"+selectedDay+"-"+selectedMonth+"-"+selectedYear);
                    String enteredDate = DateFormat.getDateInstance().format(calendar.getTime());
                    dateText.setText(enteredDate);


                }, curYear, curMonth, curDay );

//        datePicker.updateDate(mYear ,mMonth ,mDay)
//        datePicker.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.create_task_gradient_up));

        datePicker.getDatePicker().setBackground(context.getDrawable(R.drawable.create_task_gradient_up));
        datePicker.show();
        Log.v("DateUtils","Date :"+selectedDay+"-"+selectedMonth+"-"+selectedYear);
    }

    public void getTimeDialog(TextView timeText){
//         int[] time = new int[2];


        TimePickerDialog timePicker = new TimePickerDialog(context,
                ( timePickerView , hourOfDay , minute )->{

                    selectedHour = hourOfDay;
                    selectedMins = minute;
                    Log.v("TimeUtils","time1 :- "+selectedHour+":"+selectedMins);
                    Calendar cal = Calendar.getInstance();
                    cal.set(0,0,0,selectedHour,selectedMins);
                    timeText.setText(android.text.format.DateFormat.format("hh:mm aa",cal));
//                    amOrPm = android.text.format.DateFormat.format("aa",cal).toString();

                }, curHour , curMinute ,false);

        timePicker.getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.create_task_gradient_up));
        timePicker.show();
        Log.v("TimeUtils","time :- "+selectedHour+":"+selectedMins);
    }






}
