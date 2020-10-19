package com.hirmo.holgerijuuksur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Element;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupNames;
    CalendarView calendarView;

    TextView hairdresserText;
    TextView dateText;
    TextView timeText;


    private String[] hairdressers = (new Hairdressers().getNames());
    private String[] times = (new Times().getTimes());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.CalendarView);
        RadioGroup radioGroupNames = findViewById(R.id.hairdressergroup);
        RadioGroup radioGroupTimes = findViewById(R.id.timegroup);

        hairdresserText = findViewById(R.id.HairdresserText);
        dateText = findViewById(R.id.DateText);
        timeText = findViewById(R.id.TimeText);


        //HAIRDRESSER SELECTION
        radioGroupNames.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                RadioButton button = findViewById(checkId);
                int n = Integer.parseInt(button.getTag().toString()) -1;
                hairdresserText.setText("You want an appointment with " + hairdressers[n]);
            }
        });


        //DATE SELECTION
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i + "-" + (i1 + 1) + "-" + i2;
                dateText.setText(" on " + i2 + "/" + (i1 + 1) + "/" + i);
            }
        });

        //TIME SELECTION
        radioGroupTimes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                RadioButton button = findViewById(checkId);
                int n = Integer.parseInt(button.getTag().toString());
                timeText.setText(" at " + times[n]);
            }
        });

        //CONFIRMATION
/*        final Button confirm = findViewById(R.id.buttonConfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            }
        });*/
    }
}
