package com.example.myapplication.actions;

import android.widget.Toast;

import com.example.myapplication.MainActivity;

public class ServicePeliculas {
    private MainActivity parent;
    private ViewPeliculas view;
    public ServicePeliculas(MainActivity parent){
        this.parent = parent;
    }
    public void getDatosPeliculas(){
        Toast.makeText(MainActivity.getInstance(), "Welcome to Miami", Toast.LENGTH_SHORT);
        view.showPeliculas("Los datos han ido bien:['films': {''}]");
    }
}
