package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddConstructionSite extends AppCompatActivity {

    private TextView nameTV;
    private TextView addressTV;
    private TextView supervisorC;
    private TextView workerC;
    private TextView budget;
    private TextView duration;
    private Button addC;
    private DataHandler dbHandler;
    private Context context;

    private boolean validateFields(){
        String name = nameTV.getText().toString().trim();
        String address = addressTV.getText().toString().trim();
        String sup = supervisorC.getText().toString().trim();
        String wor = workerC.getText().toString().trim();
        String budg = budget.getText().toString().trim();
        String dur = duration.getText().toString().trim();
        if
        (name.trim().isEmpty() || address.trim().isEmpty() || sup.isEmpty() || wor.isEmpty() || budg.isEmpty()
                || dur.isEmpty()) {
            return false;
        }else{
            return true;
        }
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_construction_site);
        context = this;
        dbHandler = new DataHandler(context);

        nameTV = findViewById(R.id.NameCS);
        addressTV = findViewById(R.id.AddressCS);
        duration = findViewById(R.id.duraCS);
        budget = findViewById(R.id.budgetCS);
        supervisorC = findViewById(R.id.assSuper);
        workerC = findViewById(R.id.workerCC);
        addC = findViewById(R.id.addCSBTN);
        addC.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick (View view) {
                String name = nameTV.getText().toString();
                String address = addressTV.getText().toString();
                String dura = duration.getText().toString();
                String superC = supervisorC.getText().toString();
                String budge = budget.getText().toString();
                String workeC = workerC.getText().toString();

                if (validateFields()) {
                    try {
                        Construction construction = new Construction(name, address, superC, workeC, budge, dura);
                        dbHandler.createSite(construction);
                        nameTV.setText("");
                        addressTV.setText("");
                        duration.setText("");
                        supervisorC.setText("");
                        budget.setText("");
                        workerC.setText("");

                        Toast.makeText(getApplicationContext(), "Construction site created...", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(context,ConstructionSiteHome.class));
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}