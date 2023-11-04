package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class UpdateWorker extends AppCompatActivity {

    private EditText name,birth,addr,phn,nic,email;
    private Button update;
    private Spinner eRole;
    private DataHandler dbHandler;
    private Context context;
    //private long updateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] lanListU = {"Masonry Worker", "Helper"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_worker);
        context = this;
        dbHandler=new DataHandler(context);

        name=findViewById(R.id.NameCS);
        birth=findViewById(R.id.duraCS);
        //age=findViewById(R.id.editAge);
        addr=findViewById(R.id.AddressCS);
        phn=findViewById(R.id.assSuper);
        nic=findViewById(R.id.workerCC);
        email=findViewById(R.id.budgetCS);
        eRole=findViewById(R.id.spinnerRoleEd);
        update=findViewById(R.id.addCSBTN);

        final String WID = getIntent().getStringExtra("WID");
        Worker worker=dbHandler.getSingleWorker(Integer.parseInt(WID));

        ArrayAdapter<String> ab = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lanListU);
        ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eRole.setAdapter(ab);

        name.setText(worker.getName());
        //eRole.setAdapter(worker.getRole()));
        birth.setText(worker.getBirthday());
        addr.setText(worker.getAddress());
        phn.setText(worker.getPhone());
        nic.setText(worker.getNic());
        email.setText(worker.getEmail());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameText=name.getText().toString();
                String birt=birth.getText().toString();
                String address=addr.getText().toString();
                String phon=phn.getText().toString();
                String Nic=nic.getText().toString();
                String Email=email.getText().toString();

                Worker worker=new Worker(Integer.parseInt(WID),nameText,birt,address,phon,Nic,Email);
                int state=dbHandler.updateSingleWorker(worker);
                startActivity(new Intent(context,ManageViewWorkers.class));
            }
        });

    }
}