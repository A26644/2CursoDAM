package model;

import java.sql.Date;

public class Producto {
    // ATRIBUTOS
    private Integer id;
    private Usuario usuario;
    private String marca;
    private Double precio;
    private Date fecha;
    private String descripcion;
    private String nombre;
    private String imagen;
    private String estado;
    private String color;

    // CONSTRUCTOR
    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(String descripcion, String nombre, String imagen, String estado, String color) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.estado = estado;
        this.color = color;
    }

    public Producto(int id, Usuario usuario, String marca, double precio, Date fecha, String descripcion, String nombre,
            String imagen, String estado, String color) {
        this.id = id;
        this.usuario = usuario;
        this.marca = marca;
        this.precio = precio;

        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.estado = estado;
        this.color = color;
    }

    public Producto(Usuario usuario, String marca, double precio, Date fecha, String descripcion, String nombre,
            String imagen, String estado, String color) {
        this.usuario = usuario;
        this.marca = marca;
        this.precio = precio;

        this.descripcion = descripcion;
        this.nombre = nombre;
        this.imagen = imagen;
        this.estado = estado;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", usuarioId=" + usuario + ", marca=" + marca + ", precio=" + precio
                + ", fecha=" + fecha + ", descripcion=" + descripcion + ", nombre=" + nombre + ", imagen=" + imagen
                + ", estado=" + estado + ", color=" + color + "]";
    }

    // METODOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
