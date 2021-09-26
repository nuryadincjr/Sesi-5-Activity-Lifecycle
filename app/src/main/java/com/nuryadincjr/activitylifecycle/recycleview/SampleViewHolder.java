package com.nuryadincjr.activitylifecycle.recycleview;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.activitylifecycle.databinding.ItemSampleBinding;

public class SampleViewHolder extends RecyclerView.ViewHolder {

    private ItemSampleBinding binding;

    public SampleViewHolder(ItemSampleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setDataToView(String item, int position) {
        binding.tvName.setText(item);

        String item2 = "genap";

        if(position %2 == 0) {
            binding.button.setText(item2);
        }

        String button = binding.button.getText().toString();
        binding.tvName.setOnClickListener(view -> Toast.makeText(itemView.getContext(),
                item +" "+ position, Toast.LENGTH_SHORT).show());
        binding.button.setOnClickListener(view -> Toast.makeText(itemView.getContext(),
                button +" "+ position, Toast.LENGTH_SHORT).show());
    }
}
