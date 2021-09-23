package com.nuryadincjr.activitylifecycle.delightfulUserExperiences;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivityNinePatchFileBinding;

public class NinePatchFileActivity extends AppCompatActivity {

    private ActivityNinePatchFileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_patch_file);

        binding = ActivityNinePatchFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TransitionDrawable drawable = (TransitionDrawable) binding.ibTransition.getDrawable();
        binding.ibTransition.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                drawable.startTransition(500);
                return true;
            }
        });

    }
}