package com.example.myapplication.ViewAll.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ViewAll.Adapter.ViewAllAdapter;
import com.example.myapplication.ViewAll.Data.FilterProductsData;
import com.example.myapplication.ViewAll.Data.ViewAllData;
import com.example.myapplication.ViewAll.Presenter.ViewAllPresenter;
import com.example.myapplication.ViewAll.ViewAllContract;
import com.example.myapplication.loggedScreen.data.CategoriaData;

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
}