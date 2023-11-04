package com.example.test007;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test007.databinding.ActivityHomeBinding;

public class HomeActivity extends DrawerBaseActivity {
    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home");
    }
}