package Interface;

public class Presenter implements MyInterface{
    @Override
    public void mostrarLoginCorrecto() {
        System.out.println("Login correcto");
    }

    @Override
    public void mostrarLoginIncorrecto() {
        System.out.println("Login incorrecto");
    }
}
