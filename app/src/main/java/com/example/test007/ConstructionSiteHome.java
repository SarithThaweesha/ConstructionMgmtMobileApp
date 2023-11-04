package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConstructionSiteHome extends AppCompatActivity {

    private ListView list5;
    private TextView count4;
    private Button addSite;
    Context context;
    private List<Construction> construc;

    private DataHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_construction_site_home);

        context = this;
        dbHandler = new DataHandler(this);

        list5 = findViewById(R.id.consList);
        count4 = findViewById(R.id.textViewW);
        addSite=findViewById(R.id.addConsBTN);
        construc = new ArrayList<>();
        construc = dbHandler.getAllSites();

        ConstructionAdapter adapterCS = new ConstructionAdapter(context, R.layout.single_construction, construc);
        list5.setAdapter(adapterCS);

        addSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,AddConstructionSite.class));
                
            }
        });
    }
}