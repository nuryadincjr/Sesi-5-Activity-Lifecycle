package com.nuryadincjr.activitylifecycle.activitiesAndIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivityActivitiesAndIntentBinding;

public class ActivitiesAndIntentActivity extends AppCompatActivity {

    ActivityActivitiesAndIntentBinding binding;
    int count = 0;
    final String KEY_COUNT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_and_intent);

        binding = ActivityActivitiesAndIntentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0);
            binding.tvCount.setText(String.valueOf(count));
        }

        binding.tvCount.setText(String.valueOf(count));
        binding.btnCount.setOnClickListener(view -> {
            count = Integer.parseInt(binding.tvCount.getText().toString());
            count += 1;

            binding.tvCount.setText(String.valueOf(count));
        });

        binding.btnGoToCount.setOnClickListener(view -> {
            Intent intent = new Intent(this, ExplicitIntentActivity.class);
            intent.putExtra("dataCount", count);

            startActivity(intent);
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }
}