package com.example.myapplication.loggedScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;

import java.util.ArrayList;

public class OnSaleDataAdapter extends RecyclerView.Adapter<OnSaleDataAdapter.ViewHolder> {
    private ArrayList<OnLoadSaleData> lstSales;
    private LayoutInflater inflater;
    public OnSaleDataAdapter(Context context, ArrayList<OnLoadSaleData> lstSales){
        this.lstSales = lstSales;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OnSaleDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sale_data_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnSaleDataAdapter.ViewHolder holder, int position) {
        OnLoadSaleData sale = lstSales.get(position);
        // RELLENAR CON LOS DATOS
        holder.productName.setText(sale.getNombre());
        holder.productBrand.setText(sale.getMarca());
        holder.productPrice.setText(String.valueOf(sale.getPrecio()));
        holder.productDesc.setText(sale.getDescripcion());
        holder.productState.setText(sale.getEstado());
        holder.productColor.setText(sale.getColor());

    }

    @Override
    public int getItemCount() {
        return lstSales.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productBrand;
        TextView productPrice;
        TextView productDesc;
        TextView productState;
        TextView productColor;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.Username);
            productBrand = itemView.findViewById(R.id.productBrand);
            productPrice = itemView.findViewById(R.id.productPrice);
            productDesc = itemView.findViewById(R.id.userLast1);
            productState = itemView.findViewById(R.id.saleNumber);
            productColor = itemView.findViewById(R.id.userEmail);


        }
    }
}
