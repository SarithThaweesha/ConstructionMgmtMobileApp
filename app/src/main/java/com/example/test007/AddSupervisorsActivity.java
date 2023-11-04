package com.example.test007;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test007.databinding.ActivityAddSupervisorsBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AddSupervisorsActivity extends DrawerBaseActivity {
    ActivityAddSupervisorsBinding activityAddSupervisorsBinding;
    private TextView nameTV;
    private TextView addressTV;
    private TextView birthTV;
    private TextView usernameTV;
    private TextView passwordTV;
    private TextView emailTV;
    private TextView phoneTV;
    private TextView nicTV;
    private Button create;
    private DataHandler dbHandler;
    private Context context;

    private String EMAIL_REGEX= "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    DataHandler dataHandler = new DataHandler(this);

   private boolean validateFields(){
       String name = nameTV.getText().toString().trim();
       String address = addressTV.getText().toString().trim();
       String username = usernameTV.getText().toString().trim();
       String birth = birthTV.getText().toString().trim();
       String password = passwordTV.getText().toString().trim();
       String email = emailTV.getText().toString().trim();
       String nic = nicTV.getText().toString().trim();
       String phone = phoneTV.getText().toString().trim();
       if
       (name.trim().isEmpty() || address.trim().isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty()
               || nic.isEmpty()| phone.isEmpty()||birth.isEmpty()) {
           return false;
       }else{
           return true;
       }
   }
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
    public void onBackPressed() {
        if (!validateFields())
            super.onBackPressed();
        else{
            AlertDialog.Builder alert= new AlertDialog.Builder(AddSupervisorsActivity.this);
            alert.setMessage("Do you want to discard changes?")
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AddSupervisorsActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "continue editing", Toast.LENGTH_LONG).show();
                        }
                    });
            AlertDialog dialog= alert.create();
            dialog.show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddSupervisorsBinding= ActivityAddSupervisorsBinding.inflate(getLayoutInflater());
        setContentView(activityAddSupervisorsBinding.getRoot());

        nameTV = findViewById(R.id.NameCS);
        addressTV = findViewById(R.id.AddressCS);
        birthTV = findViewById(R.id.duraCS);
        usernameTV = findViewById(R.id.roleET);
        passwordTV = findViewById(R.id.passwordE);
        emailTV = findViewById(R.id.budgetCS);
        nicTV = findViewById(R.id.workerCC);
        phoneTV = findViewById(R.id.assSuper);
        create=findViewById(R.id.addCSBTN);
        allocateActivityTitle("Add Supervisors");
        context = this;
        dbHandler=new DataHandler(context);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTV.getText().toString();
                String address = addressTV.getText().toString();
                String birth = birthTV.getText().toString();
                String username = usernameTV.getText().toString();
                String password = passwordTV.getText().toString();
                String email = emailTV.getText().toString();
                String nic = nicTV.getText().toString();
                String phone=phoneTV.getText().toString();
                if (validateFields()){
                    if (validateField(email,EMAIL_REGEX)){
                        try {
                            Supervisor supervisor= new Supervisor(name,birth,address,username,password,phone,nic,email);
                            if (!dataHandler.checkSupervisorEmail(supervisor)){
                                dataHandler.createSupervisor(supervisor);
                                nameTV.setText("");
                                addressTV.setText("");
                                birthTV.setText("");
                                usernameTV.setText("");
                                passwordTV.setText("");
                                emailTV.setText("");
                                phoneTV.setText("");
                                nicTV.setText("");

                                Toast.makeText(getApplicationContext(), "Supervisor created...", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(), "email is already registered", Toast.LENGTH_LONG).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}