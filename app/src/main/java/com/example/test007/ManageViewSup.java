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
import android.widget.Toast;

import com.example.test007.databinding.ActivityManageViewSupBinding;

import java.util.ArrayList;
import java.util.List;

public class ManageViewSup extends DrawerBaseActivity {
ActivityManageViewSupBinding activityManageViewSupBinding;
    private Button add;
    private ListView list;
    private TextView count;
    Context context;
    private List<Supervisor> supervisorr;

    private DataHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityManageViewSupBinding=ActivityManageViewSupBinding.inflate(getLayoutInflater());
        setContentView(activityManageViewSupBinding.getRoot());
        allocateActivityTitle("Manage Supervisors");
        context=this;
        dbHandler=new DataHandler(this);
        list=findViewById(R.id.todolist);
        count=findViewById(R.id.textView);
        supervisorr=new ArrayList<>();
        supervisorr=dbHandler.getAllSupervisors();

        SupervisorAdapter adapter=new SupervisorAdapter(context,R.layout.single_supervisor,supervisorr);
        list.setAdapter(adapter);

        int countTodo=dbHandler.countToDo();
        count.setText("You have "+countTodo+" Supervisor records");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Supervisor supervisor=supervisorr.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(supervisor.getName());
                builder.setMessage(supervisor.getEmail());

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dbHandler.deleteSupervisors(supervisor.getSID());
                        Toast.makeText(getApplicationContext(), "Record deleted! ",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(context,ManageViewSup.class));
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        startActivity(new Intent(context,UpdateSupervisor.class));
                        Intent intent=new Intent(context,UpdateSupervisor.class);
                        intent.putExtra("SID",String.valueOf(supervisor.getSID()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
}