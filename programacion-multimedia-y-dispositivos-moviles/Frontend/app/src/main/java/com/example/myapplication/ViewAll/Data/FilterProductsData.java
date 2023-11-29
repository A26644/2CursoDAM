package com.example.myapplication.ViewAll.Data;

public class FilterProductsData {
    String filtros = "";
    String filtrosBusqueda = "";

    Integer userId;

    public FilterProductsData(String filtros, String filtrosBusqueda, Integer userId) {
        this.filtros = filtros;
        this.filtrosBusqueda = filtrosBusqueda;
        this.userId = userId;
    }

    public String getFiltros() {
        return filtros;
    }

    public void setFiltros(String filtros) {
        this.filtros = filtros;
    }

    public String getFiltrosBusqueda() {
        return filtrosBusqueda;
    }

    public void setFiltrosBusqueda(String filtrosBusqueda) {
        this.filtrosBusqueda = filtrosBusqueda;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FilterProductsData{" +
                "filtros='" + filtros + '\'' +
                ", filtrosBusqueda='" + filtrosBusqueda + '\'' +
                '}';
    }
}
