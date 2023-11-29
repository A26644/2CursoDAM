package com.example.myapplication.BoughtProducts.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;

import com.example.myapplication.R;
import com.example.myapplication.RateProduct.View.RateProduct;


import java.util.ArrayList;

public class BoughtProductsAdapter extends RecyclerView.Adapter<BoughtProductsAdapter.ViewHolder>{
    private ArrayList<BoughtProductsData> lstProduct;
    private LayoutInflater inflater;
    private Bundle extras;
    public BoughtProductsAdapter(Context context, ArrayList<BoughtProductsData> lstProduct, Intent intent) {
        this.lstProduct = lstProduct;
        this.inflater = LayoutInflater.from(context);
        this.extras = intent.getExtras();
    }
    @NonNull
    @Override
    public BoughtProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bought_product_card, parent, false);
        return new BoughtProductsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoughtProductsAdapter.ViewHolder holder, int position) {
        BoughtProductsData data = lstProduct.get(position);
        holder.id = data.getVentaId();
        holder.productName.setText(data.getProducto().getNombre());
        holder.sellerName.setText(data.getVendedor().getNombre());
        holder.productAddress.setText(data.getDireccion().getDireccion());
        View view = holder.itemView;
        holder.boughtButton.setOnClickListener(e -> {
            Intent intent = new Intent(view.getContext(), RateProduct.class);
            intent.putExtra("detalle", data);
            intent.putExtra("id", extras.getInt("id"));
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lstProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Integer id;
        TextView productName;
        TextView sellerName;
        TextView productAddress;
        Button boughtButton;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            sellerName = itemView.findViewById(R.id.sellerName);
            productAddress = itemView.findViewById(R.id.productAddress);
            boughtButton = itemView.findViewById(R.id.boughtButton);

        }
    }
}
