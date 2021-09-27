package com.nuryadincjr.activitylifecycle.recycleview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivitySampleRecycleviewBinding;
import com.nuryadincjr.activitylifecycle.layout.ActionActivity;
import com.nuryadincjr.activitylifecycle.pojo.Hiros;
import com.nuryadincjr.activitylifecycle.sql.DatabasesHandler;

import java.util.ArrayList;

public class SampleRecycleviewActivity extends AppCompatActivity {

    private ActivitySampleRecycleviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycleview);

        binding = ActivitySampleRecycleviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getData();

        binding.btnFABsAdd.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActionActivity.class);
            intent.putExtra("act", "ADD DATA");
            startActivity(intent);
        });

        binding.swipeRefresh.setColorSchemeResources(android.R.color.holo_orange_dark);
        binding.swipeRefresh.setOnRefreshListener(() -> {
            getData();
            binding.swipeRefresh.setRefreshing(false);
        });
    }

    private void getData() {
        DatabasesHandler handler = new DatabasesHandler(this);
        ArrayList<Hiros> data = handler.retrive();

        SampleAdapter adapter = new SampleAdapter(this, data);
        binding.rvHero.setLayoutManager(new LinearLayoutManager(this));
//        binding.rvHero.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvHero.setAdapter(adapter);
    }
}