package model;

public class Empresa {
    private int empresaId;
    private String empresaNombre;
    private String empresaCif;
    private String empresaDireccionPostal;
    private String empresaDireccionWeb;
    private int empresaTelefono;

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public void setEmpresaNombre(String empresaNombre) {
        this.empresaNombre = empresaNombre;
    }

    public void setEmpresaCif(String empresaCif) {
        this.empresaCif = empresaCif;
    }

    public void setEmpresaDireccionPostal(String empresaDireccionPostal) {
        this.empresaDireccionPostal = empresaDireccionPostal;
    }

    public void setEmpresaDireccionWeb(String empresaDireccionWeb) {
        this.empresaDireccionWeb = empresaDireccionWeb;
    }

    public void setEmpresaTelefono(int empresaTelefono) {
        this.empresaTelefono = empresaTelefono;
    }

}
