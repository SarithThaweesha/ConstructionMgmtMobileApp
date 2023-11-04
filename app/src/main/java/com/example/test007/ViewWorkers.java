package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewWorkers extends AppCompatActivity {


    private ListView list4;
    private TextView count4;
    Context context;
    private List<Worker> workerrr;

    private DataHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workers);

        context = this;
        dbHandler = new DataHandler(this);

        list4 = findViewById(R.id.todolistW);
        count4 = findViewById(R.id.textViewW);
        workerrr = new ArrayList<>();
        workerrr = dbHandler.getAllWorkers();

        WorkerAdapter adapterWV = new WorkerAdapter(context, R.layout.single_worker, workerrr);
        list4.setAdapter(adapterWV);

        int countTodo = dbHandler.countToDo();
        count4.setText("You have " + countTodo + " Worker records");


    }
}