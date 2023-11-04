package com.example.test007;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;


    @Override
    public void setContentView(View view) {
        drawerLayout=(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base,null);
        FrameLayout container=drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar=drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView=drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle
                (this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.home:
                startActivity(new Intent(this,HomeActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.addSup:
                startActivity(new Intent(this,AddSupervisorsActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.manageSup:
                startActivity(new Intent(this,ManageViewSup.class));
                overridePendingTransition(0,0);
                break;
            case R.id.addMas:
                startActivity(new Intent(this,AddWorkerActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.manageWorker:
                startActivity(new Intent(this,ManageViewWorkers.class));
                overridePendingTransition(0,0);
                break;
            case R.id.viewSup:
                startActivity(new Intent(this,ViewSupervisors.class));
                overridePendingTransition(0,0);
                break;
            case R.id.viewMAs:
                startActivity(new Intent(this,ViewWorkers.class));
                overridePendingTransition(0,0);
                break;
            case R.id.addCons:
                startActivity(new Intent(this,ConstructionSiteHome.class));
                overridePendingTransition(0,0);
                break;
        }
        return false;
    }
    protected void allocateActivityTitle(String titleString){
        if(getSupportActionBar() !=null){
            getSupportActionBar().setTitle(titleString);

        }
    }
}