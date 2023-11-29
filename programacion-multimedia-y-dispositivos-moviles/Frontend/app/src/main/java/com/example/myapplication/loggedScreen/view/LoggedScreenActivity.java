package com.example.myapplication.loggedScreen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.View.MyBoughtProductsActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewAll.View.ViewAllActivity;
import com.example.myapplication.addProduct.ContractAddProduct;
import com.example.myapplication.addProduct.data.AddProductData;
import com.example.myapplication.addProduct.presenter.AddProductPresenter;
import com.example.myapplication.addProduct.view.AddProductActivity;
import com.example.myapplication.loggedScreen.ContractLoggedScreen;
import com.example.myapplication.loggedScreen.adapter.OnSaleDataAdapter;
import com.example.myapplication.loggedScreen.data.CategoriaData;
import com.example.myapplication.loggedScreen.data.OnLoadSaleData;
import com.example.myapplication.loggedScreen.presenter.OnLoadSalePresenter;
import com.example.myapplication.login.view.ViewLoginActivity;
import com.example.myapplication.top.view.TopViewActivity;
import com.example.myapplication.topRated.View.TopRatedActivity;
import com.example.myapplication.utils.HeaderFunctionality;

import java.util.ArrayList;

public class LoggedScreenActivity extends AppCompatActivity implements ContractLoggedScreen.View {
    private OnLoadSalePresenter presenter = new OnLoadSalePresenter(this);
    private static LoggedScreenActivity mainActivity = null;
    public OnSaleDataAdapter onSaleDataAdapter;
    private ArrayList<OnLoadSaleData> lstSales;
    private Integer userId;

    public static LoggedScreenActivity getInstance() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_screen);
        initComponents();
        setHeader();

    }

    private void setHeader() {
        ImageView backArrow = findViewById(R.id.backArrow);
        ImageView hamburgerMenu = findViewById(R.id.hamburgerMenu);
        backArrow.setOnClickListener(e -> {
            Toast.makeText(this, "Has pulsado el boton de la flecha", Toast.LENGTH_SHORT).show();
        });
        hamburgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

    }

    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(LoggedScreenActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    PopupMenu subPopupMenu = new PopupMenu(LoggedScreenActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.products_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.addProduct) {
                                Intent intent = new Intent(LoggedScreenActivity.this, AddProductActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(LoggedScreenActivity.this, ViewAllActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            }
                            return false;
                        }
                    });
                    subPopupMenu.show();
                } else {
                    PopupMenu subPopupMenu = new PopupMenu(LoggedScreenActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.users_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            System.out.println("Esta es la ID que ha clickado: " +item.getItemId());
                            if (item.getItemId() == R.id.top10Sales) {
                                Intent intent = new Intent(LoggedScreenActivity.this, TopViewActivity.class);
                                startActivity(intent);
                            } else if (item.getItemId() == R.id.myBoughtProducts) {
                                Intent intent = new Intent(LoggedScreenActivity.this, MyBoughtProductsActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(LoggedScreenActivity.this, TopRatedActivity.class);
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

    public void initComponents() {
        Bundle extras = getIntent().getExtras();
        System.out.println(extras.getInt("id"));
        presenter.LoadOnSale(extras.getInt("id"));


    }
    @Override
    public void successLoadOnSale(ArrayList<OnLoadSaleData> lstSales) {
        this.lstSales = lstSales;
        System.out.println("He traido " + lstSales.size() + " productos");
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        onSaleDataAdapter = new OnSaleDataAdapter(this, lstSales);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(onSaleDataAdapter);
    }

    @Override
    public void failureLoadOnSale(String err) {
        Toast.makeText(LoggedScreenActivity.this, err, Toast.LENGTH_SHORT).show();
    }




}