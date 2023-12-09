package com.example.myapplication.ViewAll.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.myapplication.BoughtProducts.View.MyBoughtProductsActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewAll.Adapter.ViewAllAdapter;
import com.example.myapplication.ViewAll.Data.FilterProductsData;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.ViewAll.Presenter.ViewAllPresenter;
import com.example.myapplication.ViewAll.ViewAllContract;
import com.example.myapplication.addProduct.view.AddProductActivity;
import com.example.myapplication.loggedScreen.data.CategoriaData;
import com.example.myapplication.loggedScreen.view.LoggedScreenActivity;
import com.example.myapplication.top.view.TopViewActivity;
import com.example.myapplication.topRated.View.TopRatedActivity;

import java.util.ArrayList;

public class ViewAllActivity extends AppCompatActivity implements ViewAllContract.View {
    private ViewAllPresenter presenter = new ViewAllPresenter(this);
    private ViewAllAdapter viewAllAdapter;
    private ArrayList<ViewAllData> viewAllData;
    private ArrayList<CheckBox> lstCheckBoxes = new ArrayList<>();
    private ArrayList<CategoriaData> lstCategories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        initComponents();
    }

    public void initComponents() {
        System.out.println("Estoy haciendo el initComponenents");
        presenter.loadCategories();
        checkChecks();
    }

    @Override
    public void ViewAllSuccess(ArrayList<ViewAllData> lstProduct) {

        for (ViewAllData data : lstProduct) {
            System.out.println(data.toString());
        }
        this.viewAllData = lstProduct;
        RecyclerView recyclerView = findViewById(R.id.productRecycleView);
        viewAllAdapter = new ViewAllAdapter(this, lstProduct, getIntent());
        viewAllAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(viewAllAdapter);
    }

    @Override
    public void ViewAllFailure(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successLoadCategories(ArrayList<CategoriaData> lstCategories) {
        this.lstCategories = lstCategories;
        GridLayout checkBoxesLayout = findViewById(R.id.checkBoxesLayout);
        for (CategoriaData data : lstCategories) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(data.getCategoriaNombre());
            checkBoxesLayout.addView(checkBox);
            lstCheckBoxes.add(checkBox);
            checkBox.setOnClickListener(e -> {
                checkChecks();
            });
        }

    }

    @Override
    public void failureLoadCategories(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successFilterProducts(ArrayList<ViewAllData> lstProduct) {
        ViewAllSuccess(lstProduct);
    }

    @Override
    public void failureFilterProducts(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    private void checkChecks() {
        String filtros = "";
        for (int i = 0; i < lstCheckBoxes.size(); i++) {
            if (lstCheckBoxes.get(i).isChecked()) {
                if (i == lstCheckBoxes.size() - 1){
                    filtros += lstCategories.get(i).getCategoriaId();
                }else {
                    filtros += lstCategories.get(i).getCategoriaId() + ".";
                }
            }
        }
        System.out.println("Estos son los filtros" + filtros);
        if (filtros.equalsIgnoreCase("")){
            presenter.ViewAll(getIntent().getExtras().getInt("id"));
        }else{
            FilterProductsData filterProductsData = new FilterProductsData(filtros, "", getIntent().getExtras().getInt("id"));
            presenter.filterProducts(filterProductsData);
        }
    }
    private void showMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(ViewAllActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop_up_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.products) {
                    PopupMenu subPopupMenu = new PopupMenu(ViewAllActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.products_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.addProduct) {
                                Intent intent = new Intent(ViewAllActivity.this, AddProductActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(ViewAllActivity.this, ViewAllActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            }
                            return false;
                        }
                    });
                    subPopupMenu.show();
                } else {
                    PopupMenu subPopupMenu = new PopupMenu(ViewAllActivity.this, view);
                    subPopupMenu.getMenuInflater().inflate(R.menu.users_menu, subPopupMenu.getMenu());
                    subPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            System.out.println("Esta es la ID que ha clickado: " +item.getItemId());
                            if (item.getItemId() == R.id.top10Sales) {
                                Intent intent = new Intent(ViewAllActivity.this, TopViewActivity.class);
                                startActivity(intent);
                            } else if (item.getItemId() == R.id.myBoughtProducts) {
                                Intent intent = new Intent(ViewAllActivity.this, MyBoughtProductsActivity.class);
                                Bundle extras = getIntent().getExtras();
                                intent.putExtra("id", extras.getInt("id"));
                                startActivity(intent);
                            } else {
                                Intent intent = new Intent(ViewAllActivity.this, TopRatedActivity.class);
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