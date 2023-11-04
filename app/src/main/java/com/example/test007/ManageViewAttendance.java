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

public class ManageViewAttendance extends AppCompatActivity {

    private Button add;
    private ListView list2;
    private TextView count2;
    Context context;
    private List<Worker> workerr;

    private DataHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_view_attendance);

        context=this;
        dbHandler=new DataHandler(this);

        list2=findViewById(R.id.todolistA);
        count2=findViewById(R.id.textViewA);
        workerr=new ArrayList<>();
        workerr=dbHandler.getAllWorkers();

        WorkerAttendanceAdapter adapter=new WorkerAttendanceAdapter(context,R.layout.single_attendance,workerr);
        list2.setAdapter(adapter);

        int countTodo=dbHandler.countToDoW();
        count2.setText("You have "+countTodo+" worker records");

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Worker worker=workerr.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(worker.getName());
                builder.setMessage(worker.getEmail());


                builder.setNeutralButton("Mark Attendance", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        startActivity(new Intent(context,MarkAttendance.class));
                        Intent intent=new Intent(context,MarkAttendance.class);
                        intent.putExtra("WID",String.valueOf(worker.getWID()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
}