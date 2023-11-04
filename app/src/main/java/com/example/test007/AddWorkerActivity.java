package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddWorkerActivity extends AppCompatActivity {
    String[] lanListW = {"Masonry Worker", "Helper"};
    private TextView nameTV;
    private TextView addressTV;
    private TextView birthday;
    private TextView emailTV;
    private TextView phoneTV;
    private TextView nicTV;
    private Spinner role;
    private Button create;
    private DataHandler dbHandler;
    private Context context;

    private String EMAIL_REGEX= "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private boolean validateField(String fieldValue,String regex){
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher=pattern.matcher(fieldValue);
        if (matcher.matches()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_worker);
        context = this;
        dbHandler=new DataHandler(context);

        nameTV=findViewById(R.id.NameCS);
        addressTV=findViewById(R.id.AddressCS);
        birthday=findViewById(R.id.duraCS);
        role=findViewById(R.id.spinnerRoleEd);
        emailTV=findViewById(R.id.budgetCS);
        phoneTV=findViewById(R.id.assSuper);
        nicTV=findViewById(R.id.workerCC);
        create=findViewById(R.id.addCSBTN);

        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lanListW);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        role.setAdapter(a);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=nameTV.getText().toString();
                String rol = role.getSelectedItem().toString();
                String address=addressTV.getText().toString();
                String birth=birthday.getText().toString();
                String email=emailTV.getText().toString();
                String phone=phoneTV.getText().toString();
                String nic=nicTV.getText().toString();

                if (validateField(email,EMAIL_REGEX)){

                    Worker worker=new Worker(name,address,birth,rol,phone,nic,email);
                    try {
                            dbHandler.createWorker(worker);
                            nameTV.setText("");
                            addressTV.setText("");
                            birthday.setText("");
                            emailTV.setText("");
                            phoneTV.setText("");
                            nicTV.setText("");

                            Toast.makeText(getApplicationContext(), "Worker created...", Toast.LENGTH_LONG).show();

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}