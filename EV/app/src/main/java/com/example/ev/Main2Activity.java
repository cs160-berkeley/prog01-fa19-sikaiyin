package com.example.ev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView mName;
    TextView mDate;
    TextView mTime;
    Button mButton;
    TimePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("com.example.ev.Name");

        mName = (TextView) findViewById(R.id.textView_name);
        mName.setText(name);
        mDate = (TextView) findViewById(R.id.textView_name5);
        mButton = (Button) findViewById(R.id.button4);
        mTime = (TextView) findViewById(R.id.textView_name11);
        picker=(TimePicker)findViewById(R.id.datePicker1);
        picker.setIs24HourView(true);
        picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mTime.setText(hourOfDay + ":" + minute);
            }
        });



        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView); // get the reference of CalendarView
        // perform setOnDateChangeListener event on CalendarView
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                // Toast.makeText(getApplicationContext(), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                mDate.setText(dayOfMonth + "/" + month + "/" + year);
            }
    });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
    }

}
