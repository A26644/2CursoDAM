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

    @Override
    public String toString() {
        return "Empresa [empresaId=" + empresaId + ", empresaNombre=" + empresaNombre + ", empresaCif=" + empresaCif
                + ", empresaDireccionPostal=" + empresaDireccionPostal + ", empresaDireccionWeb=" + empresaDireccionWeb
                + ", empresaTelefono=" + empresaTelefono + "]";
    }

}
