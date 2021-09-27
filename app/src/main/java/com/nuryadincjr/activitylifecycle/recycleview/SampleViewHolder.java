package com.nuryadincjr.activitylifecycle.recycleview;

import android.app.AlertDialog;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import com.nuryadincjr.activitylifecycle.databinding.ItemSampleBinding;
import com.nuryadincjr.activitylifecycle.layout.ActionActivity;
import com.nuryadincjr.activitylifecycle.sql.DatabasesHandler;

public class SampleViewHolder extends RecyclerView.ViewHolder {

    private ItemSampleBinding binding;
    DatabasesHandler handler = new DatabasesHandler(itemView.getContext());

    public SampleViewHolder(ItemSampleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setDataToView(String id, String name, int position) {
        binding.tvId.setText(id);
        binding.tvName.setText(name);

        binding.btnEdit.setOnClickListener(view -> {
            Intent intent = new Intent(itemView.getContext(), ActionActivity.class);
            intent.putExtra("act", "EDIT DATA");
            intent.putExtra("id", id);
            intent.putExtra("name", name);
            itemView.getContext().startActivity(intent);
        });

        binding.btnDelete.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setMessage("Delete Data?");
            builder.setCancelable(true);

            builder.setPositiveButton("Yes", ((dialogInterface, i) -> {
                handler.delete(id);
                dialogInterface.cancel();
            }));

            builder.setNegativeButton("Not", ((dialogInterface, i) -> {
                dialogInterface.cancel();
            }));

            builder.create().show();
        });
    }
}
