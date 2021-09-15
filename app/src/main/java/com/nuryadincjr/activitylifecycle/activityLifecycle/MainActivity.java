package com.nuryadincjr.activitylifecycle.activityLifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TesLifecycleMain", "onCreate Runn");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnGoToSecond.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActyvity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TesLifecycleMain", "onStart Runn");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TesLifecycleMain", "onResume Runn");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TesLifecycleMain", "onPause Runn");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TesLifecycleMain", "onStop Runn");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TesLifecycleMain", "onDistroy Runn");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TesLifecycleMain", "onRestart Runn");
    }
}