package com.nuryadincjr.activitylifecycle.fragmentLifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getFragmentPage(new HomeFragment());

        Log.d("TesLifecycleMain2", "onCreate Runn");
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.menu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.btnHome:
                    getFragmentPage(new HomeFragment());
                    break;
                case R.id.btnAbout:
                    getFragmentPage(new AboutFragment());
                    break;
                case R.id.btnChat:
                    getFragmentPage(new ChatFragment());
                    break;
            }
            return true;
        });
    }

    private boolean getFragmentPage(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TesLifecycleMain2", "onStart Runn");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TesLifecycleMain2", "onResume Runn");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TesLifecycleMain2", "onPause Runn");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TesLifecycleMain2", "onStop Runn");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TesLifecycleMain2", "onDistroy Runn");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TesLifecycleMain2", "onRestart Runn");
    }
}