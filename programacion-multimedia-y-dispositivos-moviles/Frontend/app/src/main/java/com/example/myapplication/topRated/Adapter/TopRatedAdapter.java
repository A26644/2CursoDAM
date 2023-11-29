package com.example.myapplication.topRated.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.topRated.Data.TopRatedData;

import java.util.ArrayList;

public class TopRatedAdapter extends RecyclerView.Adapter<TopRatedAdapter.ViewHolder> {
    private ArrayList<TopRatedData> topRatedData;
    private LayoutInflater inflater;

    public TopRatedAdapter(Context context, ArrayList<TopRatedData> topRatedData) {
        this.topRatedData = topRatedData;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TopRatedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.most_rated_users_card, parent, false);
        return new TopRatedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRatedAdapter.ViewHolder holder, int position) {
        TopRatedData data = topRatedData.get(position);
        holder.userName.setText(data.getUsuario().getNombre());
        System.out.println("El numero de estrellas es: " + data.getEstrellas());
        holder.userStars.setText(String.valueOf(data.getEstrellas()));
        holder.userEmail.setText(data.getUsuario().getEmail());
        holder.userPhone.setText(data.getUsuario().getPhone());
        holder.number.setText(String.valueOf(position + 1));

    }

    @Override
    public int getItemCount() {
        return topRatedData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userStars;
        TextView userEmail;
        TextView userPhone;
        TextView number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userRatedName);
            userStars = itemView.findViewById(R.id.userRatedStar);
            userEmail = itemView.findViewById(R.id.userRatedEmail);
            userPhone = itemView.findViewById(R.id.userRatedPhone);
            number = itemView.findViewById(R.id.userRatedNumber);

        }
    }
}
