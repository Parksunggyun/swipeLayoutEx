package com.example.rowan_dev.swipelayoutex;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.rowan_dev.swipelayoutex.databinding.ActivityMainBinding;

import java.util.Vector;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ActivityMainBinding binding;
    private Vector<Integer> items;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        swipe(binding.swipeLayout);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.setLayoutManager(manager);
        refreshData();
    }

    private void refreshData() {
        items = new Vector<>();
        for(int i = 0; i < 6; i ++) {
            int a = (int)(Math.random() * 45) + 1;
            items.add(a);
        }
        adapter = new MainAdapter(items, this);
        binding.recyclerView.setAdapter(adapter);
        binding.swipeLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        refreshData();
    }

    private void swipe(SwipeRefreshLayout layout) {
        layout.setRefreshing(false);
        layout.setOnRefreshListener(this);
        layout.setColorSchemeColors(R.array.google_colors);
    }
}
