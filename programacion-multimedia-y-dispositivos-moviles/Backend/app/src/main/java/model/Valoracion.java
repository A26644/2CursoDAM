package model;

public class Valoracion {
    private Integer id;
    private Usuario usuario;
    private Integer estrellas;
    private String comentario;
    private Usuario usuarioValorado;
    private Producto producto;

    public Valoracion(Usuario usuario, Integer estrellas, String comentario, Usuario usuarioValorado,
            Producto producto) {

        this.usuario = usuario;
        this.estrellas = estrellas;
        this.comentario = comentario;
        this.usuarioValorado = usuarioValorado;
        this.producto = producto;
    }

    public Valoracion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuarioValorado() {
        return usuarioValorado;
    }

    public void setUsuarioValorado(Usuario usuarioValorado) {
        this.usuarioValorado = usuarioValorado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
