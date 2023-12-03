package com.example.myapplication.loggedScreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OnSaleDataAdapter extends RecyclerView.Adapter<OnSaleDataAdapter.ViewHolder> {
    private ArrayList<OnLoadSaleData> lstSales;
    private LayoutInflater inflater;

    public OnSaleDataAdapter(Context context, ArrayList<OnLoadSaleData> lstSales) {
        this.lstSales = lstSales;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OnSaleDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.own_product_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnSaleDataAdapter.ViewHolder holder, int position) {
        OnLoadSaleData sale = lstSales.get(position);
        // RELLENAR CON LOS DATOS
        holder.productName.setText(sale.getNombre());
        holder.productBrand.setText("Marca: " + sale.getMarca());
        holder.productPrice.setText(String.valueOf(sale.getPrecio()) + "€");
        holder.productState.setText("Estado: " + sale.getEstado());
        holder.productDesc = sale.getDescripcion();
        holder.productColor = sale.getColor();
        String imgUrl = sale.getImagen();
        if (!imgUrl.equals("")) {
            Picasso.get().load(imgUrl).into(holder.imagen);
        }
        System.out.println("He cargado un producto");
    }


    @Override
    public int getItemCount() {
        return lstSales.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productBrand;
        TextView productPrice;
        String productDesc = "";
        TextView productState;
        String productColor = "";
        ImageView imagen;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productState = itemView.findViewById(R.id.productState);
            productBrand = itemView.findViewById(R.id.productBrand);
            imagen = itemView.findViewById(R.id.imagenUrl);


        }
    }
}
