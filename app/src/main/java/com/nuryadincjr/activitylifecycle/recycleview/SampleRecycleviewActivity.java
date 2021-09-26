package com.nuryadincjr.activitylifecycle.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivitySampleRecycleviewBinding;

import java.util.ArrayList;

public class SampleRecycleviewActivity extends AppCompatActivity {

    private ActivitySampleRecycleviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycleview);

        binding = ActivitySampleRecycleviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> data = new ArrayList<>();
        data.add("Avenger");
        data.add("Captain America");
        data.add("Hulk");
        data.add("Superman");
        data.add("Gatot Kaca");

        SampleAdapter adapter = new SampleAdapter(this, data);
        binding.rvHero.setLayoutManager(new LinearLayoutManager(this));
//        binding.rvHero.setLayoutManager(new GridLayoutManager(this, 2));

        binding.rvHero.setAdapter(adapter);
    }
}