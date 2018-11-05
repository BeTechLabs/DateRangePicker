package com.savvi.rangepickersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.savvi.rangedatepicker.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SampleActivity extends AppCompatActivity {


    CalendarPickerView calendar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.MONTH, 10);

        final Calendar lastYear = Calendar.getInstance();
        lastYear.add(Calendar.DAY_OF_YEAR, -2);

        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        button = (Button) findViewById(R.id.get_selected_dates);
        calendar.init(lastYear.getTime(), new Date(), new SimpleDateFormat("MMMM, YYYY", Locale.getDefault())) //
                .inMode(CalendarPickerView.SelectionMode.RANGE);

        calendar.scrollToDate(new Date(), false);
        calendar.selectDate(new Date(), false);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("list",  calendar.getSelectedDates().toString());
            }
        });
    }
}
