package com.nuryadincjr.activitylifecycle.recycleview;

import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.activitylifecycle.databinding.ItemSampleBinding;

public class SampleViewHolder extends RecyclerView.ViewHolder {

    private ItemSampleBinding binding;

    public SampleViewHolder(ItemSampleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setDataToView(String item) {
        binding.tvName.setText(item);
    }
}
