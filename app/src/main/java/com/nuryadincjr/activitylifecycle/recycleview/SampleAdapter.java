package com.nuryadincjr.activitylifecycle.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.activitylifecycle.databinding.ItemSampleBinding;
import com.nuryadincjr.activitylifecycle.pojo.Hiros;

import java.util.ArrayList;

public class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder> {

    private final ArrayList<Hiros> data;
    private final Context context;

    public SampleAdapter(Context context, ArrayList<Hiros> data) {
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
        String id = data.get(position).getId();
        String name = data.get(position).getNama();
        holder.setDataToView(id, name, position);

        holder.itemView.setOnClickListener(view -> Toast.makeText(context, id +" ke " + String.valueOf(position),Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
