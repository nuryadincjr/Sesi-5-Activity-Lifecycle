package com.nuryadincjr.activitylifecycle.recycleview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.activitylifecycle.databinding.ItemSampleBinding;

import java.util.ArrayList;

public class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder> {

    private ArrayList<String> data;
    private Context context;


    public SampleAdapter(Context context, ArrayList<String> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSampleBinding binding = ItemSampleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new SampleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position) {
        String item = data.get(position);
        holder.setDataToView(item, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, item +" ke " + String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("TAG", String.valueOf(data.size()));
        return data.size();
    }
}
