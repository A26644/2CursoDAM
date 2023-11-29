package com.example.myapplication.top.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.top.data.TopData;

import java.util.ArrayList;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder> {
    private ArrayList<TopData> topData;
    private LayoutInflater inflater;

    public TopAdapter(Context context, ArrayList<TopData> topData) {
        this.topData = topData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_data_card, parent, false);
        return new TopAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopAdapter.ViewHolder holder, int position) {
        TopData data = topData.get(position);
        holder.userSaleNumber.setText(String.valueOf(position));
        holder.userSales.setText(String.valueOf(data.getNumeroVentas()));
        holder.userSaleName.setText(data.getNombre());
        holder.userSaleEmail.setText(data.getEmail());

    }

    @Override
    public int getItemCount() {
        return topData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userSaleNumber;
        TextView userSales;
        TextView userSaleName;
        TextView userSaleEmail;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userSaleNumber = itemView.findViewById(R.id.userSaleNumber);
            userSales = itemView.findViewById(R.id.userSales);
            userSaleName = itemView.findViewById(R.id.userSaleName);
            userSaleEmail = itemView.findViewById(R.id.userSaleEmail);


        }
    }
}
