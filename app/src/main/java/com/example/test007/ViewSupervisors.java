package com.example.test007;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewSupervisors extends AppCompatActivity {


    private ListView list3;
    private TextView count3;
    Context context;
    private List<Supervisor> supervisorrr;

    private DataHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_supervisors);

        context=this;
        dbHandler=new DataHandler(this);

        list3=findViewById(R.id.todolistV);
        count3=findViewById(R.id.textViewV);
        supervisorrr=new ArrayList<>();
        supervisorrr=dbHandler.getAllSupervisors();

        SupervisorAdapter adapterSV=new SupervisorAdapter(context,R.layout.single_supervisor,supervisorrr);
        list3.setAdapter(adapterSV);

        int countTodo=dbHandler.countToDo();
        count3.setText("You have " +countTodo+ " supervisor records");




    }
}