package com.nuryadincjr.activitylifecycle.activityLifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivitySecondBinding;

public class SecondActyvity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("TesLifecycleSecond", "onCreate Runn");
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TesLifecycleSecond", "onStart Runn");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TesLifecycleSecond", "onResume Runn");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TesLifecycleSecond", "onPause Runn");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TesLifecycleSecond", "onStop Runn");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TesLifecycleSecond", "onDistroy Runn");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TesLifecycleSecond", "onRestart Runn");
    }
}