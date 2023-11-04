package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MarkAttendance extends AppCompatActivity {

    private EditText name,birth,addr,phn,nic,email;
    private Button mark;
    private Spinner eRole;
    private DataHandler dbHandler;
    private Context context;
    int year,month,day;
    private TextView dateTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);
        context = this;
        dbHandler=new DataHandler(context);
        dateTV = findViewById(R.id.dateDisplayTV);

        name=findViewById(R.id.nameATT);
        email=findViewById(R.id.emailAT1);

        mark=findViewById(R.id.Mark);

        final String WID = getIntent().getStringExtra("WID");
        Worker worker=dbHandler.getSingleWorker(Integer.parseInt(WID));



        name.setText(worker.getName());
        email.setText(worker.getEmail());


    }
    public void onDateSelection(View view) {
        final Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateTV.setText(dayOfMonth + "-" + (month+1) + "-" + year);

            }
        },year,month,day);
        datePickerDialog.show();
    }
    public void markAttendance(View view)  {
        String nam = name.getText().toString();
        String emaile = email.getText().toString();
        String dat = dateTV.getText().toString();

                    Attendance attendance= new Attendance(nam,emaile,dat);
                    dbHandler.createAttendance(attendance);
                    Toast.makeText(getApplicationContext(), "attendance added...", Toast.LENGTH_LONG).show();

    }

}