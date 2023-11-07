<<<<<<< HEAD
package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.Adapter.RecyclerViewListAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<RecyclerViewListActivity> lstRecyclerViewListActivity;
    RecyclerView recyclerView;
=======
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class main extends AppCompatActivity {
>>>>>>> f4dcbc965e7d74620deebccd8a8816022b9e0b0d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        lstRecyclerViewListActivity = new ArrayList<>();
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.art, "Art"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.education, "Education"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.english, "English"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.geography, "Geography"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.history, "History"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.math, "Math"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.science, "Science"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.sport, "Sport"));
        lstRecyclerViewListActivity.add(new RecyclerViewListActivity(R.drawable.technology, "Technology"));
        RecyclerViewListAdapter recyclerViewListAdapter = new RecyclerViewListAdapter(lstRecyclerViewListActivity, this);
        recyclerView.setAdapter(recyclerViewListAdapter);
=======
        setContentView(R.layout.main);
>>>>>>> f4dcbc965e7d74620deebccd8a8816022b9e0b0d
    }
}