package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test007.databinding.ActivitySupervisorHomeBinding;

public class SupervisorHomeActivity extends DrawerBaseActivity2 {
    ActivitySupervisorHomeBinding activitySupervisorHomeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySupervisorHomeBinding=ActivitySupervisorHomeBinding.inflate(getLayoutInflater());
        setContentView(activitySupervisorHomeBinding.getRoot());
        allocateActivityTitle("Home");

    }
}