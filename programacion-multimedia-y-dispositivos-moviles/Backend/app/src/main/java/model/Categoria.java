package model;

public class Categoria {
    Integer categoriaId;
    String categoriaNombre;

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
        return "Categoria [categoriaId=" + categoriaId + ", categoriaNombre=" + categoriaNombre + "]";
    }

}
