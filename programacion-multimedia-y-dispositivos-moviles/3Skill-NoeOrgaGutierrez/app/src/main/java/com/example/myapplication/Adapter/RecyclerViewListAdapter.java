package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.PagesActivity;
import com.example.myapplication.Activity.RecyclerViewListActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.ViewHolder> {
    private ArrayList<RecyclerViewListActivity> lstRecyclerViewListActivity;
    private Context context;


    public RecyclerViewListAdapter(ArrayList<RecyclerViewListActivity> lstRecyclerViewListActivity, Context context) {
        this.lstRecyclerViewListActivity = lstRecyclerViewListActivity;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewListAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(lstRecyclerViewListActivity.get(position).getImage());
        holder.textView.setText(lstRecyclerViewListActivity.get(position).getText());
        holder.cardView.setOnClickListener(e->{
            Intent intent = new Intent(context, PagesActivity.class);
            intent.putExtra("id", position);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lstRecyclerViewListActivity.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
