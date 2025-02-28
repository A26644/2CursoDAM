package model;

public class Usuario {
    // ATRIBUTOS
    private Integer id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String pass;
    private String phone;

    public Usuario(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public Usuario(int id, String nombre, String apellido1, String apellido2, String email, String pass, String phone) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", email=" + email + ", pass=" + pass + ", phone=" + phone + "]";
    }

}
