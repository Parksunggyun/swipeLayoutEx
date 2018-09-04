package com.example.rowan_dev.swipelayoutex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.rowan_dev.swipelayoutex.databinding.ItemMainBinding;

import java.util.Vector;

public class MainAdapter extends RecyclerView.Adapter {


    private Vector<Integer> items;
    private Context context;

    public MainAdapter(Vector<Integer> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemMainBinding binding = ItemMainBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new TextHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        TextHolder holder = (TextHolder)viewHolder;
        ItemMainBinding binding = holder.binding;
        binding.textView.setText("" + items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class TextHolder extends RecyclerView.ViewHolder {

        ItemMainBinding binding;

        public TextHolder(ItemMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
