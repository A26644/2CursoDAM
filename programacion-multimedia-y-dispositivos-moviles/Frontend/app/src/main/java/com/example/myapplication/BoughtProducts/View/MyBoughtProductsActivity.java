package com.example.myapplication.BoughtProducts.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.Adapter.BoughtProductsAdapter;
import com.example.myapplication.BoughtProducts.BoughtProductsContract;
import com.example.myapplication.BoughtProducts.Data.BoughtProductsData;
import com.example.myapplication.BoughtProducts.Presenter.BoughtProductsPresenter;
import com.example.myapplication.R;
import com.example.myapplication.ViewAll.Adapter.ViewAllAdapter;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.ViewAll.View.ViewAllActivity;
import com.example.myapplication.addProduct.view.AddProductActivity;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.top.view.TopViewActivity;
import com.example.myapplication.topRated.View.TopRatedActivity;

import java.util.ArrayList;

public class MyBoughtProductsActivity extends AppCompatActivity implements BoughtProductsContract.View {
    BoughtProductsContract.Presenter presenter = new BoughtProductsPresenter(this);
    private BoughtProductsAdapter boughtProductsAdapter;
    private ArrayList<BoughtProductsData> boughtProductsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bought_products);
        initComponents();
    }

    private void initComponents() {
        presenter.MyBoughtProducts(getIntent().getExtras().getInt("id"));
    }

    @Override
    public void SuccessMyBoughtProducts(ArrayList<BoughtProductsData> lstProducts) {
        this.boughtProductsData = lstProducts;
        RecyclerView recyclerView = findViewById(R.id.boughtProductsRecycler);
        boughtProductsAdapter = new BoughtProductsAdapter(this, lstProducts, getIntent());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(boughtProductsAdapter);
    }

    @Override
    public void FailureMyBoughtProducts(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(MyBoughtProductsActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    PopupMenu subPopupMenu = new PopupMenu(MyBoughtProductsActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.products_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.addProduct) {
                                Intent intent = new Intent(MyBoughtProductsActivity.this, AddProductActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(MyBoughtProductsActivity.this, ViewAllActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            }
                            return false;
                        }
                    });
                    subPopupMenu.show();
                } else {
                    PopupMenu subPopupMenu = new PopupMenu(MyBoughtProductsActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.users_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            System.out.println("Esta es la ID que ha clickado: " +item.getItemId());
                            if (item.getItemId() == R.id.top10Sales) {
                                Intent intent = new Intent(MyBoughtProductsActivity.this, TopViewActivity.class);
                                startActivity(intent);
                            } else if (item.getItemId() == R.id.myBoughtProducts) {
                                Intent intent = new Intent(MyBoughtProductsActivity.this, MyBoughtProductsActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(MyBoughtProductsActivity.this, TopRatedActivity.class);
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