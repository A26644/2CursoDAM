package com.example.myapplication.loggedScreen.data;

public class CategoriaData {
    private Integer categoriaId;
    private String categoriaNombre;

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    @Override
    public String toString() {
        return "CategoriaData{" +
                "categoriaId=" + categoriaId +
                ", categoriaNombre='" + categoriaNombre + '\'' +
                '}';
    }
}
