package com.example.myapplication.ViewAll.Adapter;

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

import com.example.myapplication.ProductDetail.View.ProductDetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.ViewAll.View.ViewAllActivity;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;

import java.util.ArrayList;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {
    private ArrayList<ViewAllData> lstProduct;
    private LayoutInflater inflater;
    private Bundle extras;
    public ViewAllAdapter(Context context, ArrayList<ViewAllData> lstProduct, Intent intent) {
        this.lstProduct = lstProduct;
        this.inflater = LayoutInflater.from(context);
        this.extras = intent.getExtras();
    }
    @NonNull
    @Override
    public ViewAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_card, parent, false);
        return new ViewAllAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAllAdapter.ViewHolder holder, int position) {
            ViewAllData data = lstProduct.get(position);
            holder.id = data.getId();
            holder.productSellerId = data.getUsuario().getId();
            holder.productBrand.setText(data.getMarca());
            holder.productPrice.setText(String.valueOf(data.getPrecio() + " €"));
            holder.productSellerName.setText(data.getUsuario().getNombre());
            holder.productColor = data.getColor();
            holder.productState.setText(data.getEstado());
            // Hacer que el boton funcione
            holder.buyButton.setOnClickListener( e -> {
            View itemView = holder.itemView;
            holder.buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProductDetailActivity.class);
                    intent.putExtra("detalle", data);
                    intent.putExtra("id", extras.getInt("id"));
                    itemView.getContext().startActivity(intent);
                }
            });

            });
    }

    @Override
    public int getItemCount() {
        return lstProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Integer id;
        Integer productSellerId;
        TextView productSellerName;
        TextView productBrand;
        TextView productPrice;
        TextView productName;
        String productColor;
        TextView productState;
        Button buyButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productSellerName = itemView.findViewById(R.id.productSellerName);
            productBrand = itemView.findViewById(R.id.productBrand);
            productPrice = itemView.findViewById(R.id.productPrice);
            productName = itemView.findViewById(R.id.productName);
            productState = itemView.findViewById(R.id.productState);
            buyButton = itemView.findViewById(R.id.buyButton);
        }
    }
}
