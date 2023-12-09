package com.example.myapplication.topRated.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.View.MyBoughtProductsActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewAll.View.ViewAllActivity;
import com.example.myapplication.addProduct.view.AddProductActivity;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.top.adapter.TopAdapter;
import com.example.myapplication.top.view.TopViewActivity;
import com.example.myapplication.topRated.Adapter.TopRatedAdapter;
import com.example.myapplication.topRated.Data.TopRatedData;
import com.example.myapplication.topRated.Presenter.TopRatedPresenter;
import com.example.myapplication.topRated.TopRatedContract;

import java.util.ArrayList;

public class TopRatedActivity extends AppCompatActivity implements TopRatedContract.View {
    TopRatedPresenter topRatedPresenter = new TopRatedPresenter(this);
    private ArrayList<TopRatedData> lstTopRatedData = new ArrayList<>();
    private TopRatedAdapter topRatedAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated);
        initComponents();
    }
    private void initComponents(){
        topRatedPresenter.TopRated();
    }

    @Override
    public void TopRatedOnSuccess(ArrayList<TopRatedData> topRatedData) {
        System.out.println("Estoy intentando hacer el adapter");
            this.lstTopRatedData = topRatedData;
        RecyclerView recyclerView = findViewById(R.id.TopRatedRecycler);
        topRatedAdapter = new TopRatedAdapter(this, topRatedData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(topRatedAdapter);
    }

    @Override
    public void TopRatedOnFailure(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(TopRatedActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    PopupMenu subPopupMenu = new PopupMenu(TopRatedActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.products_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.addProduct) {
                                Intent intent = new Intent(TopRatedActivity.this, AddProductActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(TopRatedActivity.this, ViewAllActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            }
                            return false;
                        }
                    });
                    subPopupMenu.show();
                } else {
                    PopupMenu subPopupMenu = new PopupMenu(TopRatedActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.users_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            System.out.println("Esta es la ID que ha clickado: " +item.getItemId());
                            if (item.getItemId() == R.id.top10Sales) {
                                Intent intent = new Intent(TopRatedActivity.this, TopViewActivity.class);
                                startActivity(intent);
                            } else if (item.getItemId() == R.id.myBoughtProducts) {
                                Intent intent = new Intent(TopRatedActivity.this, MyBoughtProductsActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(TopRatedActivity.this, TopRatedActivity.class);
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