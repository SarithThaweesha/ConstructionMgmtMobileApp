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

public class ManageViewWorkers extends AppCompatActivity {
    private Button add;
    private ListView list2;
    private TextView count2;
    Context context;
    private List<Worker> workerr;

    private DataHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_view_workers);

        context=this;
        dbHandler=new DataHandler(this);

        list2=findViewById(R.id.todolistW);
        count2=findViewById(R.id.textViewW);
        workerr=new ArrayList<>();
        workerr=dbHandler.getAllWorkers();

        WorkerAdapter adapter=new WorkerAdapter(context,R.layout.single_worker,workerr);
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

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dbHandler.deleteWorkers(worker.getWID());
                        startActivity(new Intent(context,ManageViewWorkers.class));
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        startActivity(new Intent(context,UpdateWorker.class));
                        Intent intent=new Intent(context,UpdateWorker.class);
                        intent.putExtra("WID",String.valueOf(worker.getWID()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
    }
