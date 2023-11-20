package com.example.myapplication.top.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.Username.setText(data.getNombre());
        holder.saleNumber.setText(String.valueOf(data.getNumeroVentas()));
        holder.userEmail.setText(data.getEmail());
        holder.userLast1.setText(data.getApellido1());
        holder.userLast2.setText(data.getApellido2());
    }

    @Override
    public int getItemCount() {
        return topData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Username;
        TextView saleNumber;
        TextView userEmail;
        TextView userLast1;
        TextView userLast2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Username = itemView.findViewById(R.id.Username);
            saleNumber = itemView.findViewById(R.id.saleNumber);
            userEmail = itemView.findViewById(R.id.userEmail);
            userLast1 = itemView.findViewById(R.id.userLast1);
            userLast2 = itemView.findViewById(R.id.userLast2);

        }
    }
}
