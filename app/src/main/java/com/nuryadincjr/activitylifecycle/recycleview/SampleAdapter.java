package com.nuryadincjr.activitylifecycle.recycleview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.activitylifecycle.databinding.ItemSampleBinding;

import java.util.ArrayList;

public class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder> {

    private ArrayList<String> data;

    public SampleAdapter(ArrayList<String> data) {
        this.data = data;
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
        holder.setDataToView(item);
    }

    @Override
    public int getItemCount() {
        Log.d("TAG", String.valueOf(data.size()));
        return data.size();
    }
}
