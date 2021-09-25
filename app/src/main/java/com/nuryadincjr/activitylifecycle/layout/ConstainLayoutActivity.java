package com.nuryadincjr.activitylifecycle.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivityConstainLayoutBinding;

public class ConstainLayoutActivity extends AppCompatActivity {

    private ActivityConstainLayoutBinding binding;
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constain_layout);

        binding = ActivityConstainLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        value = Integer.parseInt(binding.textView3.getText().toString());

        binding.btnToast.setOnClickListener(view ->
                Toast.makeText(this, String.valueOf(value),
                        Toast.LENGTH_SHORT).show());

        binding.btnCount.setOnClickListener(view -> {
            value += 1;
            binding.textView3.setText(String.valueOf(value));
        });

        binding.btnZero.setOnClickListener(view -> {
            value = 0;
            binding.textView3.setText(String.valueOf(value));
        });

        // visible in rotate device
        if(savedInstanceState != null) {
            value = Integer.parseInt(savedInstanceState.getString("value"));
            binding.textView3.setText(String.valueOf(value));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value", String.valueOf(value));
    }
}