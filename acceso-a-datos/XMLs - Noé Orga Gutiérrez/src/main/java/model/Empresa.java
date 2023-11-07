package model;

public class Empresa {

    private int empresaId;
    private String empresaNombre;
    private String empresaCif;
    private String empresaDireccionPostal;
    private String empresaDireccionWeb;
    private String empresaTelefono;

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

    public void setEmpresaTelefono(String empresaTelefono) {
        this.empresaTelefono = empresaTelefono;
    }

    public Empresa() {
    }

    public Empresa(String empresaNombre, String empresaCif, String empresaDireccionPostal, String empresaDireccionWeb,
            String empresaTelefono) {
        this.empresaNombre = empresaNombre;
        this.empresaCif = empresaCif;
        this.empresaDireccionPostal = empresaDireccionPostal;
        this.empresaDireccionWeb = empresaDireccionWeb;
        this.empresaTelefono = empresaTelefono;
    }

    @Override
    public String toString() {
        return "Empresa [empresaId=" + empresaId + ", empresaNombre=" + empresaNombre + ", empresaCif=" + empresaCif
                + ", empresaDireccionPostal=" + empresaDireccionPostal + ", empresaDireccionWeb=" + empresaDireccionWeb
                + ", empresaTelefono=" + empresaTelefono + "]";
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public String getEmpresaNombre() {
        return empresaNombre;
    }

    public String getEmpresaCif() {
        return empresaCif;
    }

    public String getEmpresaDireccionPostal() {
        return empresaDireccionPostal;
    }

    public String getEmpresaDireccionWeb() {
        return empresaDireccionWeb;
    }

    public String getEmpresaTelefono() {
        return empresaTelefono;
    }

}
