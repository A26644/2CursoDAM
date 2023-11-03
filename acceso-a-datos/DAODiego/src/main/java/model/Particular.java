package model;

public class Particular {
    private int particularId;
    private String particularNombre;
    private String particularApellido;
    private String particularTelefono;
    private String particularDireccion;
    private String firma;

    public String getFirma() {
        return firma;
    }

    public Particular() {
    }

    public Particular(String particularNombre, String particularApellido, String particularTelefono,
            String particularDireccion, String firma) {
        this.particularNombre = particularNombre;
        this.particularApellido = particularApellido;
        this.particularTelefono = particularTelefono;
        this.particularDireccion = particularDireccion;
        this.firma = firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public int getParticularId() {
        return particularId;
    }

    public void setParticularId(int particularId) {
        this.particularId = particularId;
    }

    public String getParticularNombre() {
        return particularNombre;
    }

    public void setParticularNombre(String particularNombre) {
        this.particularNombre = particularNombre;
    }

    public String getParticularApellido() {
        return particularApellido;
    }

    public void setParticularApellido(String particularApellido) {
        this.particularApellido = particularApellido;
    }

    public String getParticularTelefono() {
        return particularTelefono;
    }

    public void setParticularTelefono(String particularTelefono) {
        this.particularTelefono = particularTelefono;
    }

    public String getParticularDireccion() {
        return particularDireccion;
    }

    public void setParticularDireccion(String particularDireccion) {
        this.particularDireccion = particularDireccion;
    }

    @Override
    public String toString() {
        return "Particular [particularId=" + particularId + ", particularNombre=" + particularNombre
                + ", particularApellido=" + particularApellido + ", particularTelefono=" + particularTelefono
                + ", particularDireccion=" + particularDireccion + "]";
    }

}
