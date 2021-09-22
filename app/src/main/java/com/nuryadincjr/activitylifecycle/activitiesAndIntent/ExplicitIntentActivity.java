package com.nuryadincjr.activitylifecycle.activitiesAndIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivityExplicitIntentBinding;

public class ExplicitIntentActivity extends AppCompatActivity {

    ActivityExplicitIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        binding = ActivityExplicitIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int count = getIntent().getIntExtra("dataCount", 0);
        binding.tvCount.setText(String.valueOf(count));
    }
}