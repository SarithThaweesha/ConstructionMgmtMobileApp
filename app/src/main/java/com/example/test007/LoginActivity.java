package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] lanList = {"Administrator", "Supervisor"};
    private TextView userTV;
    private TextView passwordTV;
    private Spinner spinner;
    private Button loginBTN;
    private DataHandler dbHandler;
    private Context context;
    DataHandler DBhandler = new DataHandler(this);
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedStr = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), selectedStr, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userTV = (TextView) findViewById(R.id.userTV);
        passwordTV = (TextView) findViewById(R.id.passwordTV);
        spinner = (Spinner) findViewById(R.id.spinner);
        loginBTN = (Button) findViewById(R.id.loginBTN);
        context = this;
        dbHandler=new DataHandler(context);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lanList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = spinner.getSelectedItem().toString();
                String username = userTV.getText().toString();
                String password = passwordTV.getText().toString();

                try {
                    if (DBhandler.checkForAdmin(new Admin(username, password)) && item.equals("Administrator")){
                        Toast.makeText(getApplicationContext(), "Login granted.Welcome Admin! ",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }else{
                        if (DBhandler.checkForSupervisor(new Supervisor(username, password)) && item.equals("Supervisor")){
                            Toast.makeText(getApplicationContext(), "Login granted.Welcome Supervisor! ",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, SupervisorHomeActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "ERROR.re-enter details ",Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


