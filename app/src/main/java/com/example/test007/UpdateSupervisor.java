package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateSupervisor extends AppCompatActivity {

    private EditText title,birth,addr,usern,phn,nic,email,pass;
    private Button edit;
    private DataHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_supervisor);
        context = this;
        dbHandler=new DataHandler(context);

        title=findViewById(R.id.editName);
        birth=findViewById(R.id.editAge);
        addr=findViewById(R.id.editAdd);
        usern=findViewById(R.id.editUsername);
        pass=findViewById(R.id.editPass);
        phn=findViewById(R.id.editPhone);
        nic=findViewById(R.id.editNic);
        email=findViewById(R.id.editEmail);
        edit=findViewById(R.id.buttonEdit);

        final String SID = getIntent().getStringExtra("SID");
        Supervisor supervisor=dbHandler.getSingleSupervisor(Integer.parseInt(SID));

        title.setText(supervisor.getName());
        birth.setText(supervisor.getBirth());
        addr.setText(supervisor.getAddress());
        usern.setText(supervisor.getUsername());
        pass.setText(supervisor.getPassword());
        phn.setText(supervisor.getPhone());
        nic.setText(supervisor.getNic());
        email.setText(supervisor.getEmail());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleText=title.getText().toString();
                String birt=birth.getText().toString();
                String address=addr.getText().toString();
                String usernam=usern.getText().toString();
                String passw=pass.getText().toString();
                String phon=phn.getText().toString();
                String Nic=nic.getText().toString();
                String Email=email.getText().toString();

                Supervisor supervisor=new Supervisor(Integer.parseInt(SID),
                        titleText,birt,address,usernam,passw,phon,Nic,Email);
                int state=dbHandler.updateSingleSupervisor(supervisor);
                startActivity(new Intent(context,ViewSupervisors.class));
            }
        });

    }
}