package com.example.myapplication.top.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.View.MyBoughtProductsActivity;
import com.example.myapplication.R;

import com.example.myapplication.ViewAll.View.ViewAllActivity;
import com.example.myapplication.addProduct.view.AddProductActivity;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.login.view.ViewLoginActivity;
import com.example.myapplication.top.ContractTop;
import com.example.myapplication.top.adapter.TopAdapter;
import com.example.myapplication.top.data.TopData;
import com.example.myapplication.top.presenter.TopPresenter;
import com.example.myapplication.topRated.View.TopRatedActivity;

import java.util.ArrayList;

public class TopViewActivity extends AppCompatActivity implements ContractTop.View {
    private TopPresenter topPresenter = new TopPresenter(this);
    private static TopViewActivity topViewActivity = null;
    private TopAdapter topAdapter;
    private ArrayList<TopData> lstUsers = new ArrayList<>();

    public static TopViewActivity getInstance() {
        return topViewActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_view);
        initComponentes();


    }



    private void initComponentes() {
        topPresenter.loadTop();
    }

    @Override
    public void onFinished(ArrayList<TopData> lstUsers) {
        this.lstUsers = lstUsers;
        RecyclerView recyclerView = findViewById(R.id.topRecycleView);
        topAdapter = new TopAdapter(this, lstUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(topAdapter);


    }

    @Override
    public void onFailure(String err) {
        Toast.makeText(TopViewActivity.this, "Error al cargar los usuarios con mas ventas", Toast.LENGTH_SHORT).show();

    }
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(TopViewActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    PopupMenu subPopupMenu = new PopupMenu(TopViewActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.products_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.addProduct) {
                                Intent intent = new Intent(TopViewActivity.this, AddProductActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(TopViewActivity.this, ViewAllActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            }
                            return false;
                        }
                    });
                    subPopupMenu.show();
                } else {
                    PopupMenu subPopupMenu = new PopupMenu(TopViewActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.users_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            System.out.println("Esta es la ID que ha clickado: " +item.getItemId());
                            if (item.getItemId() == R.id.top10Sales) {
                                Intent intent = new Intent(TopViewActivity.this, TopViewActivity.class);
                                startActivity(intent);
                            } else if (item.getItemId() == R.id.myBoughtProducts) {
                                Intent intent = new Intent(TopViewActivity.this, MyBoughtProductsActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(TopViewActivity.this, TopRatedActivity.class);
                                startActivity(intent);
                            }

                            return false;
                        }
                    });
                    subPopupMenu.show();
                }
                return false;
            }
        });
        popupMenu.show();
    }
}