package com.nuryadincjr.activitylifecycle.layout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nuryadincjr.activitylifecycle.R;
import com.nuryadincjr.activitylifecycle.databinding.ActivityActionBinding;

import com.nuryadincjr.activitylifecycle.pojo.Hiros;
import com.nuryadincjr.activitylifecycle.recycleview.SampleRecycleviewActivity;
import com.nuryadincjr.activitylifecycle.sql.DatabasesHandler;

public class ActionActivity extends AppCompatActivity {

    private ActivityActionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        binding = ActivityActionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabasesHandler handler = new DatabasesHandler(ActionActivity.this);
        Intent intent = getIntent();
        String data = intent.getStringExtra("act");
        String mID = intent.getStringExtra("id");
        String mName = intent.getStringExtra("name");

        if(data != null)
            binding.tvInfo.setText(data);
            if(data.equals("EDIT DATA"))
                binding.etID.setEnabled(false);
                binding.etID.setText(mID);
                binding.etName.setText(mName);

        binding.btnAction.setOnClickListener(view -> {
            String id = binding.etID.getText().toString();
            String name = binding.etName.getText().toString();
            String msg = "Data is Added";

            if (data.equals("ADD DATA")) {
                handler.insert(new Hiros(id, name));
            } else
                handler.update(new Hiros(mID, name));
                msg = "Data is Change";

            Toast.makeText(ActionActivity.this, msg, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SampleRecycleviewActivity.class));
        });
    }
}